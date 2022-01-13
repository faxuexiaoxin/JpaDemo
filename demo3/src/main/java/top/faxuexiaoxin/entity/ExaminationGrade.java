package top.faxuexiaoxin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExaminationGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private Integer mathSource;
    private Integer chineseSource;
    private Integer englishSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getMathSource() {
        return mathSource;
    }

    public void setMathSource(Integer mathSource) {
        this.mathSource = mathSource;
    }

    public Integer getChineseSource() {
        return chineseSource;
    }

    public void setChineseSource(Integer chineseSource) {
        this.chineseSource = chineseSource;
    }

    public Integer getEnglishSource() {
        return englishSource;
    }

    public void setEnglishSource(Integer englishSource) {
        this.englishSource = englishSource;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "ExaminationGrade{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", mathSource='" + mathSource + '\'' +
                ", chineseSource='" + chineseSource + '\'' +
                ", englishSource='" + englishSource + '\'' +
                '}';
    }
}
