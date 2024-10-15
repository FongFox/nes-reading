package com.admin.nesreading.controller.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oders")
public class OderController {
    @GetMapping("")
    public String getOderViewPage() {
      return "oder/view";
    }

    @GetMapping("/create")
    public String getOderCreatePage() {
      return "oder/create";
    }

    @GetMapping("/{id}")
    public String getOderDetailPage() {
      return "oder/detail";
    }

    @GetMapping("/update/{id}")
    public String getOderUpdatePage() {
      return "oder/update";
    }

    @GetMapping("/delete/{id}")
    public String getOderDetelePage() {
      return "oder/delete";
    }
}
