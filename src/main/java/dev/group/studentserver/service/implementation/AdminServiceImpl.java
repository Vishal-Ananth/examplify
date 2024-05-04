package dev.group.studentserver.service.implementation;

import dev.group.studentserver.dao.AdminRepository;
import dev.group.studentserver.model.Admin;
import dev.group.studentserver.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public String checkAdmin(Admin admin) {

        String db_pwd= adminRepository.checkAdmin(admin.getUsername());
        if(Objects.equals(admin.getPassword(), db_pwd)){
            System.out.println("Login Successful");
            return("home/index");
        }
        return ("login/error-page");
    }
}
