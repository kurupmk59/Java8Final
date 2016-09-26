package school;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Calculator {
    
    public static void main(String[] args) {
    
        System.out.print("Enter number of student : ");
        
        //wait for input
        Scanner scanner = new Scanner(System.in);
        int numberOfStudent = scanner.nextInt();
        
        HashMap<String, Student> studentMap = new HashMap();
        
        for( int i=0; i < numberOfStudent; i++) {
          Student student = new Student();  
          System.out.print("Enter student name?: ");
          String studentName = new Scanner(System.in).nextLine();
          student.setName(studentName);
          Set<String> keys = student.gpa.subjectGpa.keySet();
          
          for (String subjName : keys) {
                int gpa;
                do {
                    System.out.print("Enter PGA for subject " + subjName + " : ");
                    gpa = new Scanner(System.in).nextInt();
                    student.gpa.subjectGpa.put(subjName, gpa);
                } while(gpa < 0 || gpa > 4);
          }   
          studentMap.put(student.name, student);
        }      
               
        for(;;) {
            System.out.print("Enter student name for GPA? : ");
            String nameGPA = new Scanner(System.in).nextLine();
            if(nameGPA.equals("0")) {
                break;
            }
            
            Student student = studentMap.get(nameGPA);
            if(student !=null) {
                System.out.println("Name:" +   student.name + " get " + student.gpa.getGpa());
            }else {
                System.out.println("Student not found !!!");
            }
        }
    }
}
