package dev.group.studentserver.dao;

import dev.group.studentserver.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {


    @Query(value = "SELECT password FROM admin a where a.username=:username",nativeQuery = true)
    String checkAdmin(String username);
}
