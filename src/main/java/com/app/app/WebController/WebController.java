package com.app.app.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/welcome")
    public String initialPage(Model model) {
        return "welcome";
    }

}
