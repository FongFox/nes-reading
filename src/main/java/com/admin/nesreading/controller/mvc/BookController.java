package com.admin.nesreading.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
  @GetMapping("")
  public String getBookViewPage() {
    return "book/view";
  }

  @GetMapping("create")
  public String getBookCreatePage() {
    return "book/create";
  }

  @PostMapping("create")
  public String handleCreateBook() {
    return "redirect:/book/view";
  }

  @GetMapping("{id}")
  public String getBookDetailPage() {
    return "book/detail";
  }

  @GetMapping("update/{id}")
  public String getBookUpdatePage() {
    return "book/update";
  }

  @PostMapping("update/{id}")
  public String handleUpdateBook() {
    return "redirect:/book/view";
  }

  @GetMapping("delete/{id}")
  public String getBookDetelePage() {
    return "book/delete";
  }

  @PostMapping("delete/{id}")
  public String handleDeteleBook() {
    return "redirect:/book/view";
  }
}
