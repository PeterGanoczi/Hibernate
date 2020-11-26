package sk.itsovy.ganoczi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("")
public class DefaultController {

    @RequestMapping
    public String printDefault(Model model) {
        model.addAttribute("message", "hello Spring");
        return "default";
    }
}
