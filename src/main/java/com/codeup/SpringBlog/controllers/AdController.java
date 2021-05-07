package com.codeup.SpringBlog.controllers;

import com.codeup.SpringBlog.models.Ad;
import com.codeup.SpringBlog.repositories.AdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    // Contructor dependendency injection
    private final AdRepo adsDao;

    public AdController(AdRepo adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> getAllAds() {
        return adsDao.findAll();
    }

//    How do we delete? insert? edit?
    @GetMapping("/ads/{id}")
    public String getOneAd(@PathVariable long id, Model vModel) {
        Ad ad = adsDao.getOne(id);
        vModel.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("/ads/delete")
    public String deleteAd() {
        //delete ad
        adsDao.deleteById(4L);
        return "redirect:/ads"; //redirect to "/ads"
    }

    @PostMapping("/ads/create")
    public String createAd() {
        Ad ad = new Ad(
                "Unicorn",
                "It is a very small unicorn",
                2000
        );
        return "redirect:/ads";
    }

    @GetMapping("/ads/update")
    public String updatedAd() {
        Ad updatedAd = new Ad(
                101,
                "Dragon",
                "It is a dragon.",
                200
        );
        adsDao.save(updatedAd);
        return "redirect:/ads";
    }

    @GetMapping("/ads/create")
    public String showCreateForm() {
        return "ads/create";
    }

//    @PostMapping("/ads/create")
//    public String create(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ) {
//        Ad ad = new Ad();
//        ad.setTitle(title);
//        ad.setDescription(description);
//        // save the ad...
//    }

}
