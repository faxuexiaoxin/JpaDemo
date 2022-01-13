package top.faxuexiaoxin.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.faxuexiaoxin.dao.ExaminationGradeDao1;
import top.faxuexiaoxin.entity.ExaminationGrade;

import java.util.LinkedList;
import java.util.Random;

@Component
public class ImportDataRunner implements ApplicationRunner {

    @Autowired
    private ExaminationGradeDao1 dao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        generateExaminationGrades();
        printAllExaminationGrades();
    }

    private void printAllExaminationGrades() {
        System.out.println(" ============================");
        dao.findAll().stream().forEach(System.out::println);
        System.out.println(" ============================");
    }

    private void generateExaminationGrades() {
        Random random = new Random();
        random.setSeed(0L);

        LinkedList<ExaminationGrade> examinationGrades = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            ExaminationGrade examinationGrade = new ExaminationGrade();
            examinationGrade.setStudentName(generateName(random));
            examinationGrade.setMathSource(generateRandomSource(random));
            examinationGrade.setChineseSource(generateRandomSource(random));
            examinationGrade.setEnglishSource(generateRandomSource(random));
            examinationGrades.add(examinationGrade);
        }

        dao.saveAll(examinationGrades);
    }

    private int generateRandomSource(Random random) {
        return random.nextInt(100);
    }

    private String generateName(Random random) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(((char) ('a' + random.nextInt(26))));
        }
        return builder.toString();
    }
}
