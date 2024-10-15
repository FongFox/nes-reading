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
}
