
package prj1_student_record;
import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Athlet {

    protected String firstName, lastName;
    protected ArrayList<Course> records = new ArrayList<>();
    protected int totalCredits = 0;

    public Student(String firstName, String lastName) {
        this.firstName = (firstName instanceof String) ? firstName.trim() : "";
        this.lastName = (lastName instanceof String) ? lastName.trim() : "";
    }
     public String getFirstName(){
         return firstName;
     }
     public String getLastName(){
         return lastName;
     }
     public int getTotalCredits(){
         return totalCredits;
     }
    public void addCourse(Course C) {
        if (!(C instanceof Course)) {
            return;
        }
        double points = C.grade2Point();
        if (points > 0) {
            totalCredits += C.getCredit();
        }
        records.add(C);
    }
    
    public String favorSport(){
        return "volleyball";
    }

    public double gpa() throws Exception {
        double totalPoints = 0;
        double attemptedCredits = totalCredits;
        for (Course C : records) {
            totalPoints += C.grade2Point() * C.getCredit();
            if (C.getGrade().toUpperCase().indexOf("F") >= 0) {
                attemptedCredits += C.getCredit();
            }
        }
        if (attemptedCredits < 0) {
            throw new Exception("Attempted credit is o, no gpa");
        }else if(attemptedCredits == 0){
            return 0;
        }
        return totalPoints/attemptedCredits;
    }

   }