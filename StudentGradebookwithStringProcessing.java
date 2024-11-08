import java.io.*;
import java.util.Scanner;

public class StudentGradebookwithStringProcessing {
public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("students.txt"));
            PrintWriter output = new PrintWriter(new FileWriter("student_grades.txt"));
            
            output.printf("%-15s %-5s %-5s %-10s %-8s %-6s %-8s %-8s\n", 
                "Name", "Quiz1", "Quiz2", "Homework1", "Midterm", "Final", "Average", "Grade");
            
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts.length != 7) continue;

                String[] nameParts = parts[0].split(" ");
                if (nameParts.length != 2) continue;

                String name = nameParts[1] + ", " + nameParts[0];
                double quiz1 = Double.parseDouble(parts[1]);
                double quiz2 = Double.parseDouble(parts[2]);
                double homework1 = Double.parseDouble(parts[3]);
                double midterm = Double.parseDouble(parts[4]);
                double finalExam = Double.parseDouble(parts[5]);
                double average = (quiz1 + quiz2 + homework1 + midterm + finalExam) / 5;

                String grade = average >= 90 ? "A" : average >= 80 ? "B" : average >= 70 ? "C" : average >= 60 ? "D" : "F";

                output.printf("%-15s %-5.0f %-5.0f %-10.0f %-8.0f %-6.0f %-8.2f %-8s\n", 
                    name, quiz1, quiz2, homework1, midterm, finalExam, average, grade);
            }
            
            sc.close();
            output.close();
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error occurred.");
        }
    }
}
