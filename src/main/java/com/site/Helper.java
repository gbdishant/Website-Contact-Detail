package com.site;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.site.constant.Constant;
import com.site.domain.CountryDetail;
import lombok.extern.log4j.Log4j2;

import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Log4j2
public class Helper {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public CountryDetail getCountryCode(String site) {

        CountryDetail countryDetail = null;
        try {
            String ipAddress = InetAddress.getByName(new URL(site).getHost()).getHostAddress();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Constant.IPINFO_URL + ipAddress + "/json"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            countryDetail = new ObjectMapper().readValue(response.body(), CountryDetail.class);
            log.debug("[{}] countryDetail: {}", site, countryDetail);
        } catch (Exception exception) {
            log.error("Exception while get country. Error message: {}", exception.getMessage(), exception);
        }
        return countryDetail;
    }
}
