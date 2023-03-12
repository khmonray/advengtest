package com.example.advengtest.controllers;

import com.example.advengtest.models.Project;
import com.example.advengtest.models.Subproject;
import com.example.advengtest.models.Task;
import com.example.advengtest.services.ProjectService;
import com.example.advengtest.services.SubprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class SubprojectController {

    @Autowired
    private SubprojectService subprojectService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}/subprojects")
    public String getAllSubrojects(@PathVariable("projectId") int projectId, Model model) {
        List<Subproject> subprojects = subprojectService.getAllSubprojects(projectId);
        model.addAttribute("subprojects", subprojects);
        return "subprojects";
    }

    @GetMapping("/{projectId}/subprojects/new")
    public String showSubprojectForm(@PathVariable("projectId") Long projectId, Model model) {
        model.addAttribute("subproject", new Subproject());
        model.addAttribute("projectId", projectId);
        return "subproject-form";
    }

    @PostMapping("/{projectId}/subprojects/new")
    public String createSubproject(@PathVariable("projectId") int projectId,
                                   @ModelAttribute("subproject") Subproject subproject) {
        projectService.addSubproject(projectId, subproject);
        return "redirect:/projects/" + projectId;
    }

    @GetMapping("/{projectId}/subprojects/{subprojectId}")
    public String getSubprojectById(@PathVariable("projectId") int projectId,
                                    @PathVariable("subprojectId") int subprojectId, Model model) {
        Subproject subproject = subprojectService.getSubprojectById(subprojectId);
        model.addAttribute("subproject", subproject);
        return "subproject-details";
    }

    @GetMapping("/{projectId}/subprojects/{subprojectId}/tasks/new")
    public String showTaskForm(@PathVariable("projectId") Long projectId,
                               @PathVariable("subprojectId") Long subprojectId, Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projectId", projectId);
        model.addAttribute("subprojectId", subprojectId);
        return "task-form";
    }

    @PostMapping("/{projectId}/subprojects/{subprojectId}/tasks/new")
    public String createTask(@PathVariable("projectId") int projectId,
                             @PathVariable("subprojectId") int subprojectId, @ModelAttribute("task") Task task) {
        subprojectService.createTask(subprojectId, task);
        return "redirect:/projects/" + projectId + "/subprojects/" + subprojectId;
    }

    @GetMapping("/{projectId}/subprojects/{subprojectId}/tasks/{taskId}")
    public String getTaskById(@PathVariable("taskId") int taskId,
                              Model model) {
        Task task = subprojectService.getTaskById(taskId);
        model.addAttribute("task", task);
        return "task-details";
    }

    @PostMapping("/{projectId}/subprojects/{subprojectId}/tasks/{taskId}")
    public String updateTask(@PathVariable("projectId") Long projectId,
                             @PathVariable("subprojectId") Long subprojectId, @PathVariable("taskId") int taskId,
                             @ModelAttribute("task") Task task) {
        subprojectService.updateTask(taskId,task);
        return "redirect:/projects/" + projectId + "/subprojects/" + subprojectId + "/tasks/" + taskId;
    }

    @PostMapping("/{projectId}/subprojects/{subprojectId}/tasks/{taskId}/delete")
    public String deleteTask(@PathVariable("projectId") Long projectId,
                             @PathVariable("subprojectId") Long subprojectId, @PathVariable("taskId") int taskId) {
        subprojectService.deleteTask(taskId);
        return "redirect:/projects/" + projectId + "/subprojects/" + subprojectId;
    }
}
