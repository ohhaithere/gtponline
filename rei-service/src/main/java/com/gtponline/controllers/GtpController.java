package com.gtponline.controllers;

import com.gtponline.model.Gtp;
import com.gtponline.service.GtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping(path = "/api/v1/gtp")
public class GtpController {

    private GtpService gtpService;
    private static String UPLOADED_FOLDER = "/";

    @Autowired
    public GtpController(GtpService gtpService) {
        this.gtpService = gtpService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Gtp> getAllUsers() {
        return gtpService.list();
    }

    @RequestMapping("/{id}")
    public @ResponseBody
    Gtp getGtpById(@PathVariable Long id) {
        return gtpService.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(
            @RequestParam  Long id) {
        gtpService.delete(id);

        return "Deleted\n";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Gtp updateGtp(@RequestBody Gtp gtp) {
        return gtpService.save(gtp);
    }

    @PutMapping("/{bandId}/uploadGtp/")
    public Gtp uploadUserPhoto(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Gtp gtp = gtpService.get(id);
        Path path = Paths.get(UPLOADED_FOLDER + gtp.getId().toString());
        Files.write(path, bytes);


        gtp.setPath(path + file.getOriginalFilename());
        gtpService.save(gtp);
        return gtp;
    }

}
