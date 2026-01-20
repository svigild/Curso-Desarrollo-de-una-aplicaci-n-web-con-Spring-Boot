package com.openwebinars.web.task.controller;

import com.openwebinars.web.category.model.Category;
import com.openwebinars.web.category.service.CategoryService;
import com.openwebinars.web.task.dto.CreateTaskRequest;
import com.openwebinars.web.task.dto.EditTaskRequest;
import com.openwebinars.web.task.model.Task;
import com.openwebinars.web.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/")
public class TaskAdminController {

    private final TaskService taskService;
    private final CategoryService categoryService;

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.findAll();
    }


    @GetMapping({"/", "/list", "/task"})
    public String adminTaskList(Model model, @RequestParam(name="q", required=false) String query) {

        List<Task> tasks;

        if (query != null && !query.isEmpty()) {
            System.out.println("¡QUERY DETECTADA!: " + query);
            // Si hay búsqueda, usamos el servicio de búsqueda
            tasks = taskService.searchTasks(query);
            model.addAttribute("taskList", tasks);
        } else {
            // Si no, mostramos todas
            // Cargo las tareas en el modal
            model.addAttribute("taskList", taskService.findAllAdmin());
        }


        // Añado al modal una tarea vacía para el caso en el que se quiera crear una nueva tarea
        model.addAttribute("newTask", new CreateTaskRequest());
        return "admin/admin-tasks";
    }

    @GetMapping(value={"/", "/list", "/task"}, params = "emptyListError")
    public String adminEmptyList(Model model) {
        return "admin/admin-tasks";
    }

    @PostMapping("/task/{id}/del")
    public String adminDeleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/admin/";
    }

    @PostMapping("/task/{id}/ed")
    public String adminEditTask(@PathVariable Long id, Model model){
        Task task = taskService.findById(id);
        EditTaskRequest editTask = EditTaskRequest.of(task);
        model.addAttribute("task", editTask);
        return "show-task";
    }


    @GetMapping("/task/{id}")
    public String adminViewTask(@PathVariable Long id, Model model) {

        Task task = taskService.findById(id);
        EditTaskRequest editTask = EditTaskRequest.of(task);
        model.addAttribute("task", editTask);
        return "admin/view-task";
    }

}