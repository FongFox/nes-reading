package com.admin.nesreading.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
  @GetMapping("")
  public String getUserViewPage() {
    return "user/view";
  }

  @GetMapping("/create")
  public String getUserCreatePage() {
    return "user/create";
  }

  @GetMapping("/{id}")
  public String getUserDetailPage() {
    return "user/detail";
  }

  @GetMapping("/update/{id}")
  public String getUserUpdatePage() {
    return "user/update";
  }

  @GetMapping("/delete/{id}")
  public String getUserDetelePage() {
    return "user/delete";
  }

}
