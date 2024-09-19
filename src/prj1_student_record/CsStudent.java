package prj1_student_record;

public class CsStudent extends Student {

    private int mathCredit = 0;
    private int csCredits = 0;

    public CsStudent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String favorSport() {
        return "Baseball";
    }

    public int getCsCredit() {
        return csCredits;
    }

    public int getMathCredit() {
        return mathCredit;
    }

    public double majorGpa() throws Exception {
        double totalP = 0;
        double attemptedCr = mathCredit + csCredits;
        String s = "";
        for (Course C : records) {
            s = C.getSubject().toUpperCase();
            if (s.indexOf("MATH") >= 0 || s.indexOf("COMP") >= 0) {
                totalP += C.grade2Point() * C.getCredit();
                if (C.getGrade().toUpperCase().indexOf("F") >= 0) {
                    attemptedCr += C.getCredit();
                }
            }
        }
        if (attemptedCr < 0) {
            throw new Exception("Attempted credit is o, no major gpa");
        } else if (attemptedCr == 0) {
            return 0;
        }
        return totalP / attemptedCr;
    }

    @Override
    public void addCourse(Course C) {
        if (!(C instanceof Course)) {
            return;
        }
        super.addCourse(C);
        final String s = C.getSubject().toUpperCase();

        if (s.indexOf("MATH") >= 0) {
            if (C.grade2Point() > 0) {
                mathCredit += C.getCredit();
            }
        }
            else if (s.indexOf("COMP") >= 0) {
                if (C.grade2Point() > 0) {
                    csCredits += C.getCredit();
                }
            }
    }
}
