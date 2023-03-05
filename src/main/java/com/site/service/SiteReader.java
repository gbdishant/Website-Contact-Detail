package com.site.service;

import com.site.Helper;
import com.site.constant.Constant;
import com.site.domain.CountryCallingCode;
import com.site.domain.CountryDetail;
import com.site.domain.WebsiteContactDetail;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.utils.URIUtils;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.site.common.Common.countryDialCodeMap;
import static com.site.constant.Constant.EMAIL_REGEX;

@Log4j2
public class SiteReader {
    public static final String MAIN_URL = "main_url";
    public static final String SUB_URL = "sub_url";
    private static final List<WebsiteContactDetail> contactDetailList = new ArrayList<>();
    public static final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);


    @SneakyThrows
    public static void main(String[] args) {
        List<String> sites = List.of("https://www.tatvasoft.com");

        for (String s : sites) {
            new Thread(() -> {
                new Generator().getPhoneNumberANDEmailFromWebPage(s);
            }).start();
        }
    }


    public static class Generator {
        private String siteURL;
        private String countryCodeRegex;
        private final Logger log = SiteReader.log;
        private final HashSet<String> hrefSet = new HashSet<>();
        private final HashSet<String> emailSet = new HashSet<>();
        private final HashSet<String> phoneNumberSet = new HashSet<>();

        private void getPhoneNumberANDEmailFromWebPage(String site) {
            Document doc;
            hrefSet.clear();
            correctURL(site);

            doc = getURLResponse(siteURL, SiteReader.MAIN_URL);
            if (doc == null) {
                log.debug("[{}] No Page found", siteURL);
                return;
            }
            getPhoneNumberAndEmailFromHref(doc);
            if (emailSet.isEmpty() || phoneNumberSet.isEmpty()) {
                createCountryCodeRegex();
                doc.body()
                        .select("a")
                        .stream()
                        .filter(element -> element.text().toLowerCase().contains("contact"))
                        .filter(element2 -> isValidURL(element2, siteURL))
                        .forEach(element -> {
                            try {
                                log.debug("Inside filter {}", element);
                                Document contactPageDoc = getURLResponse(element.attr("href"), SiteReader.SUB_URL);
                                if (contactPageDoc == null) {
                                    log.debug("[{}] No Page found", element.attr("href"));
                                    return;
                                }
                                getPhoneNumberAndEmailFromHref(contactPageDoc);
                                if (emailSet.isEmpty() || phoneNumberSet.isEmpty()) {
                                    contactPageDoc.getAllElements().forEach(el -> {
                                        String text = el.text();
                                        if ((text.matches(countryCodeRegex) && text.replaceAll("\\D", "")
                                                .length() >= 9)) {
                                            String mixNumber = text.replaceAll(("[^+/0-9]"), "");
                                            if (mixNumber.length() < 30) {
                                                phoneNumberSet.add(mixNumber);
                                            }
                                        }
                                        if (text.contains("@")) {
                                            Matcher matcher = SiteReader.emailPattern.matcher(text);
                                            if (matcher.find()) {
                                                String email = matcher.group();
                                                emailSet.add(email);
                                            }
                                        }
                                    });
                                }
                            } catch (Exception exception) {
                                log.error("Exception while read contact doc. Error message: {}", exception.getMessage(), exception);
                            }
                        });
            }
            WebsiteContactDetail contactDetail = new WebsiteContactDetail(siteURL, emailSet, phoneNumberSet);
            log.debug("ContactDetail: {}", contactDetail);
        }

        private void getPhoneNumberAndEmailFromHref(Document doc) {
            Elements elements = doc.select("a[href]");
            for (Element element : elements) {
                if (element.attr("href").contains("tel:")) {
                    String phoneNumber = element.attr("href");
                    phoneNumberSet.add(phoneNumber);
                } else if (element.attr("href").contains("mailto:")) {
                    String email = element.attr("href");
                    emailSet.add(email);
                } else if (element.attr("href").contains("email-protection")) {
                    String substring = element.attr("href").substring(element.attr("href").indexOf("#") + 1);
                    String finalString = StringUtils.hasText(substring) ? substring : element.attr("data-cfemail");
                    if (StringUtils.hasText(finalString) && finalString.length() > 33) {
                        String s = decodeEmail(substring);
                        emailSet.add(s);
                    }
                }
            }
        }

        private void createCountryCodeRegex() {
            CountryDetail countryDetail = new Helper().getCountryCode(siteURL);
            if (countryDetail != null) {
                String countryCode = countryDetail.getCountryCode();
                if (countryDialCodeMap.containsKey(countryCode)) {
                    CountryCallingCode countryCallingCodes = countryDialCodeMap.get(countryCode);
                    countryCodeRegex = "^.*?((\\" + countryCallingCodes.getDialCode() + ")|(\\" + countryCallingCodes.getDialCode()
                            .replaceAll(" ", "") + ")).*$";
                } else {
                    countryCodeRegex = "^.*?(\\+).*$";
                }
            }
            log.debug("[{}] countryCodeRegex: {}", siteURL, countryCodeRegex);
        }

        private String correctURL(String siteURL) {
            if (!siteURL.startsWith("www.") && !siteURL.startsWith("http://") && !siteURL.startsWith("https://")) {
                siteURL = "www." + siteURL;
            }
            if (!siteURL.startsWith("http://") && !siteURL.startsWith("https://")) {
                siteURL = "http://" + siteURL;
            }
            siteURL = URIUtils.extractHost(URI.create(siteURL)).toString();
            this.siteURL = siteURL;
            return siteURL;
        }

        @SuppressWarnings("ConstantValue")
        private Document getURLResponse(String url, String type) {
            log.debug("Inside getURLResponse url: {} type: {}", url, type);

            Document document = null;
            if (type.equals(SiteReader.MAIN_URL)) {
                url = siteURL;
            } else {
                url = url.startsWith("/") ? siteURL + url : url;
            }

            int i = 0;
            while (i < 5) {
                try {
                    Connection.Response res = Jsoup.connect(url).userAgent("Mozilla/5.0").execute();

                    if (HttpStatus.resolve(res.statusCode()).is2xxSuccessful()) {
                        document = res.parse();
                        log.debug("Document is Ready for URL: {}", url);
                        break;
                    }

                } catch (Exception exception) {
                    log.error("Exception while get document for site: {}. Error message: {}", url, exception.getMessage(), exception);
                    log.debug("Lets try {} time", ++i);
                }
            }
            return document;
        }

        private boolean isValidURL(Element element, String siteURL) {
            String href = element.attr("href");
            if (href.startsWith("/")) {
                href = siteURL + href;
            }
            return Pattern.matches(Constant.httpURLRegex, href) && hrefSet.add(href);
        }

        public String decodeEmail(String encodedEmail) {
            log.debug("Inside decodeEmail encodedEmail: {}", encodedEmail);
            int key = Integer.parseInt(encodedEmail.substring(0, 2), 16);
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < encodedEmail.length(); i += 2) {
                int value = Integer.parseInt(encodedEmail.substring(i, i + 2), 16);
                int result = value ^ key;
                sb.append((char) result);
            }
            log.debug("decoded String: {}", sb.toString());
            return sb.toString();
        }
    }
}

