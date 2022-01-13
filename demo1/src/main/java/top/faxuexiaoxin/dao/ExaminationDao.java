package top.faxuexiaoxin.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import top.faxuexiaoxin.entity.Examination;

public interface ExaminationDao extends JpaRepository<Examination,Long> {
    Examination findDistinctByGrade(int grade);
    List<Examination> findAllByClassNo(String classNo);
}
