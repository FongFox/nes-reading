package com.nesreading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    // =============================== (Start) Dashboard Controller =====================================
    @GetMapping("")
    public String getDashboardPage() {
        return "admin/dashboard/view";
    }
    // =============================== (End) Dashboard Controller =======================================

    // =============================== (Start) User Controller =====================================
    @GetMapping("/users")
    public String getUserViewPage() {
        return "admin/user/view";
    }

    @GetMapping("/users/create")
    public String getUserCreatePage() {
        return "admin/user/create";
    }

    @GetMapping("/users/{id}")
    public String getUserDetailPage() {
        return "admin/user/detail";
    }

    @GetMapping("/users/update/{id}")
    public String getUserUpdatePage() {
        return "admin/user/update";
    }

    @GetMapping("/users/delete/{id}")
    public String getUserDetelePage() {
        return "admin/user/delete";
    }
    // =============================== (End) User Controller =======================================

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
        return "redirect:admin//book/view";
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
        return "redirect:admin//book/view";
    }

    @GetMapping("/books/delete/{id}")
    public String getBookDetelePage() {
        return "admin/book/delete";
    }

    @PostMapping("/books/delete/{id}")
    public String handleDeteleBook() {
        return "redirect:admin//book/view";
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
    public String getOderDetelePage() {
        return "admin/order/delete";
    }
    // =============================== (End) Order Controller =======================================
}
