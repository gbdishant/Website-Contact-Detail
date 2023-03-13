package com.site;


import com.site.domain.WebsiteContactDetail;
import com.site.service.SiteReader;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.site.constant.Constant.URL_REGEX;

@Log4j2
@Controller
public class NavigationController {

    @RequestMapping("/")
    public String welcome() {
        return "fileuploadpage";
    }

    @SneakyThrows
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public List<WebsiteContactDetail> upload(@RequestParam(value = "file") MultipartFile file) {
        log.debug("Inside upload file: {}", file.getName());

        Path site = Files.createTempFile("site", ".txt");
        file.transferTo(site);

        try {
            List<String> sites = Files.lines(site, StandardCharsets.UTF_8)
                    .filter(siteURL -> Pattern.matches(URL_REGEX, siteURL))
                    .collect(Collectors.toList());
            SiteReader siteReader = new SiteReader();
            List<WebsiteContactDetail> siteData = siteReader.getSiteData(sites);
            log.debug("SiteData size: {}", siteData.size());
            return siteData;
        } catch (Exception exception) {
            log.error("Exception while read siteList File. Error message: {}", exception.getMessage(), exception);
        }

        return null;
    }

    @RequestMapping(path = "/download")
    @ResponseBody
    public ResponseEntity<Resource> download(String param) throws IOException {

        File file = new File("C:\\Users\\Dishant\\Downloads\\data.csv");
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=MyCSV.csv");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

//    @PostMapping("/datatable")
//    public DataTablesOutput<UserEntity> listPOST(@Valid @RequestBody DataTablesInput input) {
//        log.info("Inside listPOST :{} ", input);
//        return service.findAll(input);
//    }
}
