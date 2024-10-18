import java.util.Scanner;

public class SimpleStudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of students:");
        int numStudents = sc.nextInt();
        
        String[] names = new String[numStudents];
        double[] averages = new double[numStudents];
        char[] grades = new char[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            names[i] = sc.next();
            
            double total = 0;
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter score " + (j + 1) + ":");
                total += sc.nextDouble();
            }
            averages[i] = total / 3;
            
            grades[i] = (averages[i] >= 90) ? 'A' : (averages[i] >= 80) ? 'B' : (averages[i] >= 70) ? 'C' : (averages[i] >= 60) ? 'D' : 'F';
        }
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println(names[i] + ": Average = " + averages[i] + ", Grade = " + grades[i]);
        }
    }
}
