package com.site;


import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class NavigationController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("standardDate", new Date());
        return "fileuploadpage";
    }

    @SneakyThrows
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile file) {
        System.out.println("Inside Upload");
        byte[] bytes = file.getBytes();


        return new String(bytes);
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
}
