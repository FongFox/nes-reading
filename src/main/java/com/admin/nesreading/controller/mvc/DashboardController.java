package com.admin.nesreading.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
  @GetMapping("/")
  public String getDashboardPage() {
    return "dashboard/view";
  }
}