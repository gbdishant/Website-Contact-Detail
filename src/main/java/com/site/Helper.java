package com.site;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.constant.Constant;
import com.site.domain.CountryDetail;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;

@Log4j2
public class Helper {

    @SuppressWarnings("deprecation")
    private final DefaultHttpClient httpClient = new DefaultHttpClient();
    private final HttpGet req = new HttpGet();

    public CountryDetail getCountryCode(String site) {

        CountryDetail countryDetail = null;
        try {
            String ipAddress = InetAddress.getByName(new URL(site).getHost()).getHostAddress();

            req.setURI(URI.create(Constant.IPINFO_URL + ipAddress));
            HttpResponse httpResponse = httpClient.execute(req);

            byte[] bytes = httpResponse.getEntity().getContent().readAllBytes();
            countryDetail = new ObjectMapper().readValue(bytes, CountryDetail.class);
            log.debug("[{}] countryDetail: {}", site, countryDetail);
        } catch (Exception exception) {
            log.error("Exception while get country. Error message: {}", exception.getMessage(), exception);
        }
        return countryDetail;
    }
}
