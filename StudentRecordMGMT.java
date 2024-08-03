import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String department;

    Student() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ID:");
        this.id = scan.nextInt();
        scan.nextLine(); 
        System.out.println("Enter Name:");
        this.name = scan.nextLine();
        System.out.println("Enter Age:");
        this.age = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Department:");
        this.department = scan.nextLine();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class StudentRecordSystem {
    private Student[] students;
    private int count = 0;

    public StudentRecordSystem(int size) {
        students = new Student[size];
    }

    public void addStudent() {
        if (count < students.length) {
            students[count] = new Student();
            count++;
        } else {
            System.out.println("ERROR: Data is Full In System!");
        }
    }

    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].id == studentID) {
                return students[i];
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}

public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int num = scan.nextInt();

        StudentRecordSystem system = new StudentRecordSystem(num);
        
        while (true) {
            System.out.println("Enter 1: To add new student data.");
            System.out.println("Enter 2: To display all students data.");
            System.out.println("Enter 3: Exiting from program.");
            int c = scan.nextInt();
            switch (c) {
                case 1: {
                    system.addStudent();
                    break;
                }
                case 2: {
                    system.displayAllStudents();
                    break;
                }
                case 3: {
                    System.out.println("Exiting From Program!");
                    return;
                }
                default: {
                    System.out.println("Enter Proper Choice!");
                }
            }
        }
    }
}