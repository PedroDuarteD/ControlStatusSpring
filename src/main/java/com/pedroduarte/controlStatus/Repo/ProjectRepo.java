package com.pedroduarte.controlStatus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroduarte.controlStatus.Model.ProjectModel;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectModel, Long>{
    
}
