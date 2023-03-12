package com.example.advengtest.services;

import com.example.advengtest.models.Project;
import com.example.advengtest.models.Subproject;
import com.example.advengtest.models.Task;
import com.example.advengtest.repositories.SubprojectRepository;
import com.example.advengtest.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubprojectService {
    private final TaskRepository taskRepository;
    private final SubprojectRepository subprojectRepository;

    public SubprojectService(TaskRepository taskRepository, SubprojectRepository subprojectRepository) {
        this.taskRepository = taskRepository;
        this.subprojectRepository = subprojectRepository;
    }

    public Subproject getSubprojectById(int subprojectId) {
        return subprojectRepository.findById(subprojectId);
    }

    public List<Subproject> getAllSubprojects(int projectId) {
        return subprojectRepository.findAllByProjectId(projectId);
    }

    public void createTask(int subprojectId, Task task) {
        Subproject sub = subprojectRepository.findById(subprojectId);
        sub.getTasks().add(task);
    }

    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId);
    }

    public void updateTask(int taskId, Task task) {
        Task upTask = this.getTaskById(taskId);
        upTask.setSubproject(task.getSubproject());
        upTask.setUpdateStateDate(new Date());
        upTask.setTitle(task.getTitle());
        upTask.setInfo(task.getInfo());
        upTask.setState(task.getState());
        taskRepository.save(upTask);

    }

    public void deleteTask(int taskId) {
        taskRepository.delete(this.getTaskById(taskId));
    }
}
