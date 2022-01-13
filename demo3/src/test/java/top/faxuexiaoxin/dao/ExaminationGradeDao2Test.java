package top.faxuexiaoxin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import top.faxuexiaoxin.entity.ExaminationGrade;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExaminationGradeDao2Test {

    @Autowired
    private ExaminationGradeDao2 dao;

    @Test
    void findOne() {
        ExaminationGrade examinationGrade = new ExaminationGrade();
        examinationGrade.setId(3L);

        Example<ExaminationGrade> example = Example.of(examinationGrade);

        Optional<ExaminationGrade> gradeOptional = dao.findOne(example);
        System.out.println("gradeOptional = " + gradeOptional.get());
    }

    @Test
    void findAll() {
        ExaminationGrade examinationGrade = new ExaminationGrade();
        examinationGrade.setChineseSource(58);

        Example<ExaminationGrade> example = Example.of(examinationGrade);

        List<ExaminationGrade> grades = dao.findAll(example);
        grades.stream().forEach(System.out::println);
    }
}