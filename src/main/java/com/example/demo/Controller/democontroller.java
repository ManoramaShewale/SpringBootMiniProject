package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.User;
import com.example.demo.service.demoService;

@Controller
public class democontroller {
  @Autowired
  demoService demo;

  @GetMapping("/Test1")
  public String test() {
    return "index";
  }

  // @GetMapping("/Test2")
  // public String test2(){
  // return "table";
  // }
  @PostMapping("/welcome")
  public String wel(@ModelAttribute User user, Model model) {
    // System.out.println(user.toString());
    model.addAttribute("name", user.getName());
    demo.Add(user);
    model.addAttribute("data", demo.show());
    return "table";
  }

  @GetMapping("/deletedata/{id}")
  public String deleteTutorial(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
    try {
      demo.delete(id);

      redirectAttributes.addFlashAttribute("message", "The Tutorial with id=" + id + " has been deleted successfully!");
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("message", e.getMessage());
    }

    model.addAttribute("data", demo.show());
    return "table";
  }

  @PostMapping("/update")
  public String update(@ModelAttribute User user ,Model model) {
    demo.Add(user);
    model.addAttribute("data", demo.show());
    return "table";
  }

  @GetMapping("/update/{id}")
  public String updateById(@PathVariable Integer id, Model model) {
    User u = demo.getById(id);
    model.addAttribute("updatedata", u);
    return "update";
  }

}
