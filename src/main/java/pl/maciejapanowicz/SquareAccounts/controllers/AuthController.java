package pl.maciejapanowicz.SquareAccounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciejapanowicz.SquareAccounts.models.forms.RegisterForm;
import pl.maciejapanowicz.SquareAccounts.models.services.AuthService;

@Controller
public class AuthController {

    final  AuthService authService;

    @Autowired
    public AuthController (AuthService authService){
        this.authService = authService;
    }

    @GetMapping ("/login")
    public String login (){
        return "login";
    }

    @GetMapping ("/index")
    public String index () {
        return "login";
    }

    @PostMapping("/login")
    public String login (@RequestParam ("email") String email,
                         @RequestParam ("password") String password,
                         Model model) {
       if (!authService.tryLogin(email, password)){
            model.addAttribute("infoAboutWrongLogin", "Login or Password incorrect!");
            return "login";
       }
       return "redirect:/";
    }

    @GetMapping ("/register")
    public String register (Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping ("/register")
    public String register  (@ModelAttribute ("registerForm") RegisterForm registerForm, Model model){
        model.addAttribute("infoAboutRegistration", "Sorry, this e-mail is not available");
        if (!authService.tryRegister(registerForm)) {
            return "/register";
        }
        return "redirect:/login";
    }
}
