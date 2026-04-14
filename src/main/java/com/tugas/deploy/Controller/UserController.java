package com.tugas.deploy.Controller;

import com.tugas.deploy.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> data = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if (username.equals("admin")) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("data", data);
        return "home";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user) {
        data.add(user);
        return "redirect:/home";
    }
}