import java.util.Scanner;

class Student {
    private int studentID;
    private String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }
}

 class Grade {
    private int studentID;
    private int courseID;
    private char grade;

    public Grade(int studentID, int courseID, char grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public char getGrade() {
        return grade;
    }
}

 class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;

    public GradingSystem(int studentCapacity, int gradeCapacity, int courseCapacity) {
        students = new Student[studentCapacity];
        grades = new Grade[gradeCapacity];
        courseCredits = new int[courseCapacity];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Student capacity reached!");
        }
    }

    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
        } else {
            System.out.println("Grade capacity reached!");
        }
    }

    public void addCourseCredits(int courseID, int credits) {
        if (courseID < courseCredits.length) {
            courseCredits[courseID] = credits;
        } else {
            System.out.println("Invalid course ID!");
        }
    }

    public double calculateGPA(int studentID) {
        int totalCredits = 0;
        int totalPoints = 0;

        for (int i = 0; i < gradeCount; i++) {
            Grade grade = grades[i];
            if (grade.getStudentID() == studentID) {
                int credits = courseCredits[grade.getCourseID()];
                totalCredits += credits;
                totalPoints += credits * gradeToPoints(grade.getGrade());
            }
        }

        return totalCredits == 0 ? 0 : (double) totalPoints / totalCredits;
    }

    public int gradeToPoints(char grade) {
        switch (grade) {
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            case 'D': return 1;
            case 'F': return 0;
            default: return 0;
        }
    }
}

class GradingSystemMGTM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem(10, 20, 100);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    Student student = new Student(studentID, name);
                    gradingSystem.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int gStudentID = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter grade (A/B/C/D/F): ");
                    char grade = scanner.next().charAt(0);
                    Grade gradeObj = new Grade(gStudentID, courseID, grade);
                    gradingSystem.addGrade(gradeObj);
                    break;

                case 3:
                    System.out.print("Enter course ID: ");
                    int cCourseID = scanner.nextInt();
                    System.out.print("Enter course credits: ");
                    int credits = scanner.nextInt();
                    gradingSystem.addCourseCredits(cCourseID, credits);
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int sStudentID = scanner.nextInt();
                    double gpa = gradingSystem.calculateGPA(sStudentID);
                    System.out.println("GPA of student with ID " + sStudentID + ": " + gpa);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}