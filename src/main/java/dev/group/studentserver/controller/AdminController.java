package dev.group.studentserver.controller;
import dev.group.studentserver.model.Admin;
import dev.group.studentserver.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/showLoginForm")
    public String adminPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "login/admin-login";
    }

    @PostMapping("/verify")
    public String checkAdmin(@ModelAttribute("admin") Admin admin){
        System.out.println(admin);
        return adminService.checkAdmin(admin);
    }

    @GetMapping("/test")
    public String showHelloPage(){
        return "helloPage";
    }

    @GetMapping("/toStudent")
    public String goToStudent(){
        return "/home/student";
    }

    @GetMapping("/main")
    public String toMain(){
        return "/home/index";
    }
}
