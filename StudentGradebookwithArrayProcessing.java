import java.util.Scanner;

public class StudentGradebookwithArrayProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of students:");
        int studentCount = scanner.nextInt();
        
        String[] studentNames = new String[studentCount];
        double[][] studentGrades = new double[studentCount][3];
        double[] gradeAverages = new double[studentCount];
        char[] letterGrades = new char[studentCount];
        
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter name of student " + (i + 1) + ":");
            studentNames[i] = scanner.next();
            double totalScore = 0;

            for (int j = 0; j < 3; j++) {
                System.out.println("Enter score for assignment " + (j + 1) + ":");
                studentGrades[i][j] = scanner.nextDouble();
                totalScore += studentGrades[i][j];
            }

            gradeAverages[i] = totalScore / 3;
            letterGrades[i] = (gradeAverages[i] >= 90) ? 'A' : 
                              (gradeAverages[i] >= 80) ? 'B' : 
                              (gradeAverages[i] >= 70) ? 'C' : 
                              (gradeAverages[i] >= 60) ? 'D' : 'F';
        }

        double highestAverage = gradeAverages[0], lowestAverage = gradeAverages[0];
        int highestIndex = 0, lowestIndex = 0;

        for (int i = 1; i < studentCount; i++) {
            if (gradeAverages[i] > highestAverage) {
                highestAverage = gradeAverages[i];
                highestIndex = i;
            }
            if (gradeAverages[i] < lowestAverage) {
                lowestAverage = gradeAverages[i];
                lowestIndex = i;
            }
        }
        
        System.out.println("\nStudent Report:");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%s: %.2f | Grade: %c%n", studentNames[i], gradeAverages[i], letterGrades[i]);
        }
        
        System.out.printf("Highest Average: %s with %.2f%n", studentNames[highestIndex], highestAverage);
        System.out.printf("Lowest Average: %s with %.2f%n", studentNames[lowestIndex], lowestAverage);
        
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = 0; j < studentCount - i - 1; j++) {
                if (gradeAverages[j] < gradeAverages[j + 1]) {
                    double tempAverage = gradeAverages[j];
                    gradeAverages[j] = gradeAverages[j + 1];
                    gradeAverages[j + 1] = tempAverage;

                    String tempName = studentNames[j];
                    studentNames[j] = studentNames[j + 1];
                    studentNames[j + 1] = tempName;

                    double[] tempGrades = studentGrades[j];
                    studentGrades[j] = studentGrades[j + 1];
                    studentGrades[j + 1] = tempGrades;

                    char tempLetterGrade = letterGrades[j];
                    letterGrades[j] = letterGrades[j + 1];
                    letterGrades[j + 1] = tempLetterGrade;
                }
            }
        }

        System.out.println("\nSorted by Average Score:");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%s: %.2f%n", studentNames[i], gradeAverages[i]);
        }
    }
}
