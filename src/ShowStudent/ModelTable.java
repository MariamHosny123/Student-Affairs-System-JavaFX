package ShowStudent;

public class ModelTable {

    String id, name, gpa, course1, course2, course3, course4, course5, course6,credithours;

    public ModelTable(String id, String name, String gpa,String credithours, String course1, String course2, String course3, String course4, String course5, String course6) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.credithours = credithours ;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        this.course6 = course6;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    public String getCourse4() {
        return course4;
    }

    public void setCourse4(String course4) {
        this.course4 = course4;
    }

    public String getCourse5() {
        return course5;
    }

    public void setCourse5(String course5) {
        this.course5 = course5;
    }

    public String getCourse6() {
        return course6;
    }

    public void setCourse6(String course6) {
        this.course6 = course6;
    }
    
        public String getCreditHours() {
        return credithours;
    }

    public void setCreditHours(String credithours) {
        this.credithours = credithours;
    }

}
