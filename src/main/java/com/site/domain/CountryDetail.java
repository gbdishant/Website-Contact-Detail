package com.site.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDetail {

    private String ip;

    @JsonProperty("hostname")
    private String hostName;
    private String city;
    private String region;

    @JsonProperty("country")
    private String countryCode;
    private String loc;
    private String org;
    private String postal;
    @JsonProperty("timezone")
    private String timeZone;
    private String readme;

}
