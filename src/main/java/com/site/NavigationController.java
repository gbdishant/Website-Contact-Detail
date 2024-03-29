package com.site;


import com.site.domain.WebsiteContactDetail;
import com.site.service.SiteReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.http.client.utils.URIUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static com.site.constant.Constant.URL_REGEX;

@Log4j2
@Controller
@RequiredArgsConstructor
public class NavigationController {

    private final SiteReaderService siteReaderService;

    @RequestMapping("/")
    public String welcome() {
        return "fileuploadpage";
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public List<WebsiteContactDetail> upload(@RequestParam(value = "file") MultipartFile file) {
        log.debug("Inside upload file: {}", file.getName());


        List<WebsiteContactDetail> siteData = null;
        try {
            Path site = Files.createTempFile("site", ".txt");
            log.debug("site: {}", site.toAbsolutePath());
            file.transferTo(site);

            List<String> sites = Files.lines(site, StandardCharsets.UTF_8)
                                      .map(this::correctURL)
                                      .filter(siteURL -> Pattern.matches(URL_REGEX, siteURL))
                                      .collect(Collectors.toList());
            log.debug("sites: {}", sites);
            siteData = siteReaderService.getSiteData(sites);
            log.debug("SiteData size: {}", siteData.size());
            return siteData;
        } catch (Exception exception) {
            log.error("Exception while read siteList File. Error message: {}", exception.getMessage(), exception);
        }

        return siteData;
    }

    private String correctURL(String siteURL) {
        if (!siteURL.startsWith("www.") && !siteURL.startsWith("http://") && !siteURL.startsWith("https://")) {
            siteURL = "www." + siteURL;
        }
        if (!siteURL.startsWith("http://") && !siteURL.startsWith("https://")) {
            siteURL = "http://" + siteURL;
        }
        siteURL = URIUtils.extractHost(URI.create(siteURL)).toString();
        return siteURL;
    }
}






