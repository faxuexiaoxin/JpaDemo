package top.faxuexiaoxin.dao;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.faxuexiaoxin.entity.Examination;

import java.util.List;

@SpringBootTest
class ExaminationDaoTest {

    @Autowired
    private ExaminationDao examinationDao;
    @Test
    void findDistinctByGrade() {
        final Examination examination = examinationDao.findDistinctByGrade(10);
        Assertions.assertEquals("张三",examination);
    }

    @Test
    void findAllByClassNo() {
        final List<Examination> examinations = examinationDao.findAllByClassNo("1402");
        Assertions.assertEquals(2,examinations);
        final String[] nameArrays = ((String[]) examinations.stream().map(Examination::getName).toArray());
        Assertions.assertArrayEquals(new String[]{"张三", "李四"},nameArrays);
    }
}