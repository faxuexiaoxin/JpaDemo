package top.faxuexiaoxin.dao;

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
        printAllStudent();

        final Examination examination = examinationDao.findDistinctByGrade(10);
        Assertions.assertEquals("张三",examination.getName());
    }

    /**
     * 打印表中所有的数据
     */
    private void printAllStudent() {
        List<Examination> examinations = examinationDao.findAll();
        System.out.println("表中所有的数据如下所示");
        examinations.forEach(System.out::println);
        System.out.println(" ======================================= ");
    }

    @Test
    void findAllByClassNo() {
        printAllStudent();
        final List<Examination> examinations = examinationDao.findAllByClassNo("1402");
        Assertions.assertEquals(2,examinations.size());
        final String[] nameArrays =  examinations.stream().map(Examination::getName).toArray(String[]::new);
        Assertions.assertArrayEquals(new String[]{"张三", "李四"},nameArrays);
    }
}