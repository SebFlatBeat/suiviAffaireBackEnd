package fr.enedis.cliffs.qdd.suiviaffairebackend.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    /**
     *
     * @return redirect:/index"
     */
    @GetMapping("/login?logout")
    public String logout() {
        return "redirect:/index";
    }

    /**
     *
     * @return redirect:/index
     */
    @GetMapping("/login")
    public String login() {
        return "redirect:/index";
    }

}
