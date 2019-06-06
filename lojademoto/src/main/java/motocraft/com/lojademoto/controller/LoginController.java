package motocraft.com.lojademoto.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            ModelMap modelMap) {
        if (username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
            session.setAttribute("username", username);
            return "index";
        } else {
            modelMap.put("error", "Invalid Account");
            return "account/index";
        }
    }

}
