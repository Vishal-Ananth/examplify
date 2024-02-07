package dev.group.studentserver.service;

import dev.group.studentserver.dao.AdminRepository;
import dev.group.studentserver.model.Admin;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Objects;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String checkAdmin(Admin admin) {

        String db_pwd= adminRepository.checkAdmin(admin.getUsername());
        if(Objects.equals(admin.getPassword(), db_pwd)){
            System.out.println("Login Successful");
            return("login/login-complete");
        }
        return ("login/error-page");
    }
}
