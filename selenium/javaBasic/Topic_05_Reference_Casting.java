
package javaBasic;

public class Topic_05_Reference_Casting {

    public String studentName;

    // Reference Casting
    public String getUserName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void showStudentName() {
        System.out.println("Student name = " + studentName);
    }

    public static void main(String[] args) {
        Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
        Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();

        firstStudent.setStudentName("Nguyen Van Nam");
        secondStudent.setStudentName("Le Van Dau");

        firstStudent.showStudentName();
        secondStudent.showStudentName();

        // Casting
        firstStudent = secondStudent;

        firstStudent.showStudentName();
        secondStudent.showStudentName();

        secondStudent.setStudentName("Pham My Duyen");

        firstStudent.showStudentName();
        secondStudent.showStudentName();
    }
}
