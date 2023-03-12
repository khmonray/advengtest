package com.example.advengtest.services;

import com.example.advengtest.models.Project;
import com.example.advengtest.models.Subproject;
import com.example.advengtest.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void addSubproject(int id, Subproject subproject) {
        Project project = this.getProject(id);
        if (project.getSubprojects() != null) {
            project.getSubprojects().add(subproject);
        } else {
            project.setSubprojects(Collections.singletonList(subproject));
        }
        projectRepository.save(project);
    }

    public void delete(int projectId) {
        projectRepository.deleteById(projectId);
    }

    public Project getProject(int projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isEmpty()) throw new NoSuchElementException("NOT FOUND");
        return project.get();
    }

    public void updateProject(int id, Project project) {
        Project upProject = this.getProject(id);
        upProject.setTitle(project.getTitle());
        projectRepository.save(upProject);
    }
}
