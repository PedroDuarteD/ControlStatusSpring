package com.pedroduarte.controlStatus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedroduarte.controlStatus.Repo.ProjectRepo;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }
    
    
}
