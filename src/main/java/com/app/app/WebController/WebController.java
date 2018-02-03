package com.app.app.WebController;

import com.app.app.DaoController.UserDAOController;
import com.app.app.Domini.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class WebController {

    @Autowired
    private UserDAOController userDAOController;

    @GetMapping("/welcome")
    public ModelAndView initialPage(Model model) {
        return new ModelAndView("welcome");
    }

    @GetMapping("/logUser")
    public String logUser(Model model) {
        return "logUser";
    }

    @RequestMapping(value = "/logUser", method = {RequestMethod.POST})
    public boolean existsUser(@RequestParam("user") String user, @RequestParam("password") String password) {
        System.out.println(userDAOController.validateUser(user, password));
        return true;
    }
}
