package hasanalmunawrDev.webMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class UploadController {

    @PostMapping(path = "/upload/profile")
    @ResponseBody
    public String upload(@RequestParam(name = "name") String name,
                       @RequestParam(name = "profile")MultipartFile profile) throws IOException {
        Path path = Path.of("images/" + profile.getOriginalFilename());
//        Files.write(path, profile.getBytes());
        profile.transferTo(path);

        return "succes save image "+ name + " " + profile.getOriginalFilename() + " to " + path;
    }
}
