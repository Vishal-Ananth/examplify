package dev.group.studentserver.controller;


import dev.group.studentserver.model.Admin;
import dev.group.studentserver.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/showFormForLogin")
    public String showFormForAdd() {
        return "login/admin-login";
    }

    @PostMapping("/verify")
    public String checkAdmin(@ModelAttribute("admin") Admin admin){
        adminService.checkAdmin(admin);
        System.out.println(admin.getUsername());
        System.out.println(admin.getPassword());
        return "helloPage";
    }


    @GetMapping("/test")
    public String showHelloPage(){
        return "helloPage";
    }



}
