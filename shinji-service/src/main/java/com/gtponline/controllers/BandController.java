package com.gtponline.controllers;

import com.gtponline.model.Band;
import com.gtponline.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/band")
public class BandController {

    private BandService bandService;

    @Autowired
    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Band createUser(@RequestBody Band band) {
        return bandService.save(band);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Band> getAllUsers() {
        return bandService.list();
    }

    @RequestMapping("/{id}")
    public @ResponseBody
    Band getUserById(@PathVariable Long id) {
        return bandService.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(
            @RequestParam  Long id) {
        bandService.delete(id);

        return "Deleted\n";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    Band updateUser(@RequestBody Band band) {
        return bandService.save(band);
    }


}
