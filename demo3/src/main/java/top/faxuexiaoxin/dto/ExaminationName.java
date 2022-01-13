package top.faxuexiaoxin.dto;

public class ExaminationName {
    private String name;

    @Override
    public String toString() {
        return "ExaminationName{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
