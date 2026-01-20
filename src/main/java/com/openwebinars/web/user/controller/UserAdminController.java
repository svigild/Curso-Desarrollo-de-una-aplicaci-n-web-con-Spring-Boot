package com.openwebinars.web.user.controller;

import com.openwebinars.web.user.dto.UserResponse;
import com.openwebinars.web.user.model.UserRole;
import com.openwebinars.web.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserAdminController {

    private final UserService userService;

    @GetMapping("/admin/user")
    public String listUsers(Model model) {
        model.addAttribute("userList",
                userService.findAll().stream().map(UserResponse::of).toList());
        return "admin/admin-users";
    }

    @GetMapping("/admin/user/{id}/promote")
    public String makeAdmin(@PathVariable Long id, Model model) {
        userService.changeRole(id, UserRole.ADMIN);
        return "redirect:/admin/user";
    }

    // Método hecho por mi para poder cambiar el rol de un usuario a USER
    @GetMapping("/admin/user/{id}/demote")
    public String makeUser(@PathVariable Long id, Model model){
        userService.changeRole(id, UserRole.USER);
        return "redirect:/admin/user";
    }

}