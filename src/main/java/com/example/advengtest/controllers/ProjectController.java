package com.example.advengtest.controllers;

import com.example.advengtest.models.Project;
import com.example.advengtest.models.Subproject;
import com.example.advengtest.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/{id}")
    public String getProjectById(@PathVariable int id, Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "project";
    }


    @GetMapping("/new")
    public String createProjectForm(@ModelAttribute("project") Project project) {
        return "create-project";
    }

    @PostMapping("/new")
    public String createProject(@ModelAttribute("project") Project project) {
        projectService.createProject(project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/edit")
    public String updateProjectForm(@PathVariable int id, Model model) {
        Project project = projectService.getProject(id);
        model.addAttribute("project", project);
        return "update-project";
    }

    @PostMapping("/{id}/edit")
    public String updateProject(@PathVariable int id, @ModelAttribute Project project) {
        projectService.updateProject(id, project);
        return "redirect:/projects";
    }

    @GetMapping("/{id}/delete")
    public String deleteProject(@PathVariable int id) {
        projectService.delete(id);
        return "redirect:/projects";
    }

    @PostMapping("/{id}/addSubproject")
    public String updateProject(@PathVariable int id, @ModelAttribute Subproject subproject) {
        projectService.addSubproject(id, subproject);
        return "redirect:/projects";
    }

}
