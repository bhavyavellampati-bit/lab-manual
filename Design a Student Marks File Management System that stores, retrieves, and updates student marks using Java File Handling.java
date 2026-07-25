import java.io.*;
import java.util.*;

public class StudentMarksFileManagement {

    static final String FILE_NAME = "students.txt";

    // Add Student
    public static void addStudent(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter Student ID: ");
            String id = sc.next();

            System.out.print("Enter Student Name: ");
            String name = sc.next();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            bw.write(id + "," + name + "," + marks);
            bw.newLine();
            bw.close();

            System.out.println("Student record added successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display All Students
    public static void displayStudents() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println("No records found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\nStudent Records");
            System.out.println("-----------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println("ID: " + data[0] +
                        "  Name: " + data[1] +
                        "  Marks: " + data[2]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Student
    public static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID to search: ");
        String searchId = sc.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals(searchId)) {
                    System.out.println("Record Found");
                    System.out.println("ID: " + data[0]);
                    System.out.println("Name: " + data[1]);
                    System.out.println("Marks: " + data[2]);
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.println("Student not found.");

            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Marks
    public static void updateMarks(Scanner sc) {
        System.out.print("Enter Student ID to update: ");
        String searchId = sc.next();

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[0].equals(searchId)) {
                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();

                    bw.write(data[0] + "," + data[1] + "," + newMarks);
                    found = true;
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found)
                System.out.println("Marks updated successfully.");
            else
                System.out.println("Student not found.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Marks File Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    updateMarks(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
