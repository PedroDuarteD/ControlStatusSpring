package com.pedroduarte.controlStatus.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.pedroduarte.controlStatus.Model.ProjectModel;
import com.pedroduarte.controlStatus.Repo.ProjectRepo;
import com.pedroduarte.controlStatus.Services.ProjectService;


@RestController
public class ProjectController {
    
    @Autowired
    private ProjectService service;

   

    @PostMapping("/add")
    public String addProject(
        @RequestParam(required = true,value="name") String name,
        @RequestParam(required = true,value="url") String url
    ){
         ProjectModel newModel = new ProjectModel();
         newModel.setName(name);
         newModel.setUrl(url);
         newModel.setActive(true);
         service.addProject(newModel);

         String body = "";

         body+="<div id='projects'> ";
 
        for (ProjectModel model : service.listAll()){
         String actClass = "";
         if(model.getActive()){
             actClass = "active";
         }else{
             actClass="notactive";
         }
         body+="<div class='card " +actClass+ "'> ";
         body+="<div class='project_name'> "+model.getName();
         body+="</div> ";
 
         body+="<div class='project_url'> "+model.getUrl();
         body+="</div> ";
 
         body+="<div class='project_status'> "+(model.getActive()? "200 OK" : "");
         body+="</div> ";
         body+="</div>";
        }
        body+="</div> ";
 
         return body;
    }


    @GetMapping("/list")
    public String getIndex(){
        
        Gson gson = new Gson();
        String body = "";

        body+="<div id='projects'> ";

       for (ProjectModel model : service.listAll()){
        String actClass = "";
        if(model.getActive()){
            actClass = "active";
        }else{
            actClass="notactive";
        }
        body+="<div class='card " +actClass+ "'> ";
        body+="<div class='project_name'> "+model.getName();
        body+="</div> ";

        body+="<div class='project_url'> "+model.getUrl();
        body+="</div> ";

        body+="<div class='project_status'> "+(model.getActive()? "200 OK" : "");
        body+="</div> ";
        body+="</div>";
       }
       body+="</div> ";

        return body;
    }
}
