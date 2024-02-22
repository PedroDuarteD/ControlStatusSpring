package com.pedroduarte.controlStatus.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "project")
public class ProjectModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Setter
  private String name;

  @Setter
  private String url;

  @Setter
  private Boolean active;
}
