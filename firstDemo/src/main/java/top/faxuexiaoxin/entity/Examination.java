package top.faxuexiaoxin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 考试成绩表，用来记录一次全年级的一次考试的结果
 *
 */
@Entity
public class Examination {

    /**
     * 表示一张表的逐渐
     */
    @Id
    private Long id;

    /**
     * 表示考生的名称,假设没有同名的学生
     */
    private String name;

    /**
     * 表示考生对应的班级
     */
    private String classNo;

    /**
     * 表示考生对应的分数
     */
    private Integer grade;

    /**
     * 必须提供一个无参数的构造器
     */
    public Examination() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", classNo='" + classNo + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
