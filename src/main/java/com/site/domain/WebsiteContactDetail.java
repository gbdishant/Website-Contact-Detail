package com.site.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Data
public class WebsiteContactDetail {

    private String siteName;
    private List<String> emailList;
    private List<String> phoneNumberList;

    public WebsiteContactDetail() {
    }

    public WebsiteContactDetail(String siteURL, HashSet<String> emailSet, HashSet<String> phoneNumberSet) {
        this.siteName = siteURL;
        this.emailList = new ArrayList<>(emailSet) ;
        this.phoneNumberList = new ArrayList<>(phoneNumberSet);
    }
}