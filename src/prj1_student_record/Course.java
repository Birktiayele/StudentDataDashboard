
package prj1_student_record;
public class Course {
      private String subject;
    private String number;
    private int credit = 3;
    private String grade;
    
    public Course(String subject, String number, int credit, String grade){
        this.subject = (subject instanceof String)? subject : "";
        this.subject = this.subject.toUpperCase();
        this.credit = (credit > 0)? credit : 0;
        this.grade = (grade instanceof String)? grade.trim().toUpperCase() : "";
        this.number = (number instanceof String)? number : "";   
    }
    
    public String getSubject(){
        return subject;
    }
     public String getNumber(){
        return number;
    }
      public String getGrade(){
        return grade;
    }
       public int getCredit(){
        return credit;
    }
       
     public double grade2Point(){
         double point = 0;
         switch(grade){
             case "A":
                 point = 4.0;
                 break;
             case "A+":
                 point = 4.0;
                 break;
             case "A-":
                 point = 3.7;
                 break;
             case "B+":
                 point = 3.3;
                 break;
             case "B":
                 point = 3.0;
                 break;
             case "B-":
                 point = 2.7;
                 break;   
             case "C+":
                 point = 2.3;
                 break;
             case "C":
                 point = 2.0;
                 break;
             case "C-":
                 point = 1.7;
                 break;
            case "D+":
                 point = 1.3;
                 break;
             case "D":
                 point = 1.0;
                 break;
             case "W":
             case "F":
                 point = 0.0;
                 break;
            default:
                System.out.println("Grade: " + grade + " is not in the correct form");
                break;
             
         }
        return point;
     } 
     public boolean equals(Course C){
         return subject.equals(C.subject)
                 && number.equals(C.number)
                 && credit ==C.credit && grade.equals(C.grade);
     }
     @Override
     public String toString(){
         return subject+" "+ number + ", credit:" + credit +", grade: " + grade;
     }
    
}
