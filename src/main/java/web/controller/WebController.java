package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;


@Controller
public class WebController {

    private final UserService userService;

    @Autowired
    public WebController(UserService userService) {this.userService = userService;}


    @GetMapping("/")
    public String start(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/save-user")
    public String save(){
        return "/add-user";
    }


    @GetMapping("/delete-user")
    public String deleteUserById() {
        return "delete-user";
    }

    @GetMapping("/update-user")
    public String update(){
        return "update-user";
    }
}