package com.site.service;

import com.site.domain.WebsiteContactDetail;
import java.util.List;

public interface SiteReaderService {
    List<WebsiteContactDetail> getSiteData(List<String> sites);
}
