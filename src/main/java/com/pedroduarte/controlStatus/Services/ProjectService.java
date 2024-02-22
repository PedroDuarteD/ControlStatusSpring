package com.pedroduarte.controlStatus.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedroduarte.controlStatus.Model.ProjectModel;
import com.pedroduarte.controlStatus.Repo.ProjectRepo;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepo repo;



    public void addProject(ProjectModel model){
        repo.save(model);
    }

    public List<ProjectModel> listAll(){
        return repo.findAll();
    }
}
