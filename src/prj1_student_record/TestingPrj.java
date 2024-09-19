
package prj1_student_record;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;
import java.nio.file.Files;

public class TestingPrj {

    public static Course fromString(String line) {
        Scanner sc = new Scanner(line);
        final String subject = sc.next();
        final String number = sc.next();
        final int credits = sc.nextInt();
        final String grade= sc.next();
        Course C = new Course(subject, number, credits, grade);
        return C;
    }

    public static ArrayList<CsStudent> readFile(String fileName) 
            throws IOException {
        CsStudent s = null;
        String line = "";
        ArrayList<CsStudent> students = new ArrayList<>();
        File file = new File(fileName);
        Scanner scanner = new Scanner(new FileInputStream(file));
        int numStudents = scanner.nextInt();
        line = scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
                final String firstName = scanner.next();
                final String lastName = scanner.next();
                s = new CsStudent(firstName,lastName);
                students.add(s);
                line  = scanner.nextLine();
                line = scanner.nextLine().strip();
                while (line.length() > 0) {
                    final Course C = fromString(line);    
                   s.addCourse(C);
                   if(scanner.hasNextLine()){
                    line = scanner.nextLine().strip();
                   }
                   else{
                       break;
                   }
                }
        }
        return students;
    }

    public static void saveToFile(String outFile, ArrayList<CsStudent> students)  {
       try{
           File file = new File(outFile);
           if(file.exists()){
               file.delete();
           }
        PrintWriter pw = new PrintWriter(new File(outFile));
        System.out.printf("%-12s\t%-12s\t%12s\t%4s\t%10s\t%10s\t%4s\n",
                   "FirstName", "lastName", "TotalCredits", 
                   "GPA", "MathCredits", "CsCredits", 
                   "CS_major_GPA");
           pw.printf("%-12s\t%-12s\t%12s\t%4s\t%10s\t%10s\t%4s\n",
                   "FirstName", "lastName", "TotalCredits", 
                   "GPA", "MathCredits", "CsCredits", 
                   "CS_major_GPA");
          
        // Write student data
     for (CsStudent st : students) {
         final double GPA =  st.gpa();
          final String first = st.getFirstName();
           final String last =  st.getLastName();      
           final int credits = st.getTotalCredits();
           final int mCredits = st.getMathCredit();
           final int cCredits = st.getCsCredit();
           final double mGPA = st.majorGpa();
           System.out.printf("%-12s\t%-12s\t%12d\t%4.2f\t%10d\t%10d\t%4.2f\n",
                   first,
                    last, 
                    credits,
                    GPA,
                    mCredits,
                    cCredits,
                    mGPA );
            pw.printf("%-12s\t%-12s\t%12d\t%4.2f\t%10d\t%10d\t%4.2f\n",
                   first,
                    last, 
                    credits,
                    GPA,
                    mCredits,
                    cCredits,
                    mGPA );

        }
       pw.close();
       }
       catch(FileNotFoundException fe){
           System.out.println(outFile + " not found");
       }
        catch(IOException ie){
           System.out.println("Exception: " + ie.getMessage());
       }
       catch(Exception e){
           System.out.println("Exception: " + e.getMessage());
       }
    }

    public static void main(String[] args) throws Exception {
        try {
            ArrayList<CsStudent> students = readFile("input.txt");
            saveToFile("output.txt", students);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
