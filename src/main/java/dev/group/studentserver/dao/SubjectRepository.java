package dev.group.studentserver.dao;

import dev.group.studentserver.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer>{

    Subject findBySubCode(String subCode);


}
