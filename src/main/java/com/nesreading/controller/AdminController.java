package com.nesreading.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nesreading.domain.Author;
import com.nesreading.domain.User;
import com.nesreading.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    // =============================== (Start) Dashboard Controller =====================================
    @GetMapping("")
    public String getDashboardPage() {
        return "admin/dashboard/view";
    }
    // =============================== (End) Dashboard Controller =======================================

    // =============================== (Start) User Controller =====================================
    @GetMapping("/users")
    public String getUserViewPage(Model model) {
        List<User> userList = this.userService.handleFetchAllUser();

        model.addAttribute("userList", userList);
    
        return "admin/user/view";
    }

    @GetMapping("/users/create")
    public String getUserCreatePage(Model model) {
        model.addAttribute("newUser", new User());

        return "admin/user/create";
    }

    @PostMapping("/users/create")
    public String handleCreateUser(@ModelAttribute("newUser") User user) {
        this.userService.handleCreateUser(user);
        return "redirect:/admin/users";
    }


    @GetMapping("/users/{id}")
    public String getUserDetailPage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);

        model.addAttribute("user", user);

        return "admin/user/detail";
    }

    @GetMapping("/users/update/{id}")
    public String getUserUpdatePage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);
        if(user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("tempUser", user);

        return "admin/user/update";
    }

    @PostMapping("/users/update")
    public String handleUpdateUser(@ModelAttribute("tempUser") User user) {
        userService.handleUpdateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String getUserDeletePage(@PathVariable long id ,Model model) {
        User user = this.userService.handleFetchUserById(id).orElse(null);
        if(user == null) {
            return "redirect:/admin/users";
        }

        model.addAttribute("tempUser", user);

        return "admin/user/delete";
    }

    @PostMapping("/users/delete")
    public String handleUserDeletePage(@ModelAttribute("tempUser") User user) {
        userService.handleDeleteUser(user.getId());
        return "redirect:/admin/users";
    }
    // =============================== (End) User Controller =======================================

    // =============================== (Start) Author Controller =====================================
    @GetMapping("/authors")
    public String getAuthorViewPage() {
        return "admin/author/view";
    }

    @GetMapping("/authors/create")
    public String getAuthorCreatePage(Model model) {
        model.addAttribute("newAuthor", new Author());

        return "admin/author/create";
    }
    // =============================== (End) Author Controller =======================================

    // =============================== (Start) Book Controller =====================================
    @GetMapping("/books")
    public String getBookViewPage() {
        return "admin/book/view";
    }

    @GetMapping("/books/create")
    public String getBookCreatePage() {
        return "admin/book/create";
    }

    @PostMapping("/books/create")
    public String handleCreateBook() {
        return "redirect:/admin/books";
    }

    @GetMapping("/books/{id}")
    public String getBookDetailPage() {
        return "admin/book/detail";
    }

    @GetMapping("/books/update/{id}")
    public String getBookUpdatePage() {
        return "admin/book/update";
    }

    @PostMapping("/books/update/{id}")
    public String handleUpdateBook() {
        return "redirect:/admin/books";
    }

    @GetMapping("/books/delete/{id}")
    public String getBookDeletePage() {
        return "admin/book/delete";
    }

    @PostMapping("/books/delete/{id}")
    public String handleDeleteBook() {
        return "redirect:/admin/books";
    }
    // =============================== (End) Book Controller ========================================

    // =============================== (Start) Order Controller =====================================
    @GetMapping("/orders")
    public String getOderViewPage() {
        return "admin/order/view";
    }

    @GetMapping("/orders/create")
    public String getOderCreatePage() {
        return "admin/order/create";
    }

    @GetMapping("/orders/{id}")
    public String getOderDetailPage() {
        return "admin/order/detail";
    }

    @GetMapping("/orders/update/{id}")
    public String getOderUpdatePage() {
        return "admin/order/update";
    }

    @GetMapping("/orders/delete/{id}")
    public String getOderDeletePage() {
        return "admin/order/delete";
    }
    // =============================== (End) Order Controller =======================================
}
