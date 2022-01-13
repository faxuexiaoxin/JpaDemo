package top.faxuexiaoxin.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import top.faxuexiaoxin.entity.ExaminationGrade;

import java.util.List;

@SpringBootTest
class ExaminationGradeDao1Test {

    @Autowired
    private ExaminationGradeDao1 dao;

    @Test
    void findDistinctByChineseSource() {
        ExaminationGrade distinctByChineseSource = dao.findFirstDistinctByChineseSource(53);
        System.out.println("distinctByChineseSource = " + distinctByChineseSource);
    }

    @Test
    void findByEnglishSource() {
        ExaminationGrade byEnglishSource = dao.findByEnglishSource(25);
        System.out.println("byEnglishSource = " + byEnglishSource);
    }

    @Test
    void findAllByEnglishSource() {
        Sort.TypedSort<ExaminationGrade> examinationGradeTypedSort = Sort.sort(ExaminationGrade.class);
        Sort sort = examinationGradeTypedSort.by(ExaminationGrade::getChineseSource).descending();
        dao.findAllByEnglishSource(59, sort).stream().forEach(System.out::println);
    }

    @Test
    void testFindByEnglishSource() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        List<ExaminationGrade> source = dao.findByEnglishSource(59, pageRequest);
        source.stream().forEach(System.out::println);
    }

    @Test
    void findTop10ByEnglishSourceBetween() {
        List<ExaminationGrade> top10ByEnglishSourceBetween = dao.findTop10ByEnglishSourceBetween(10, 60);
        top10ByEnglishSourceBetween.stream().forEach(System.out::println);
    }

    @Test
    void findFirst10ByEnglishSourceBetweenAndChineseSourceAfter() {
        dao.findFirst10ByEnglishSourceBetweenAndChineseSourceAfter(10, 60, 20).stream().forEach(System.out::println);
    }
}