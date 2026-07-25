import java.util.*;

class Student {
    private int id;
    private String name;
    private String course;
    private double marks;

    public Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Course: " + course +
               ", Marks: " + marks;
    }
}

public class StudentRecordManagementSystem {

    static ArrayList<Student> studentList = new ArrayList<>();
    static HashMap<Integer, Student> studentMap = new HashMap<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, course, marks);

        studentList.add(student);
        studentMap.put(id, student);

        System.out.println("Student Added Successfully.");
    }

    public static void updateStudent(Scanner sc) {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();

        Student student = studentMap.get(id);

        if (student == null) {
            System.out.println("Student Not Found.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter New Name: ");
        student.setName(sc.nextLine());

        System.out.print("Enter New Course: ");
        student.setCourse(sc.nextLine());

        System.out.print("Enter New Marks: ");
        student.setMarks(sc.nextDouble());

        System.out.println("Student Updated Successfully.");
    }

    public static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();

        Student student = studentMap.get(id);

        if (student != null)
            System.out.println(student);
        else
            System.out.println("Student Not Found.");
    }

    public static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Student student = studentMap.remove(id);

        if (student != null) {
            studentList.remove(student);
            System.out.println("Student Deleted Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }
    }

    public static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Student Records Available.");
            return;
        }

        System.out.println("\n------ Student Records ------");

        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    updateStudent(sc);
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    displayStudents();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
