import java.util.Scanner;


class Course {
     int courseID;
     String courseName;
   int credits;

    public Course(int courseID, String courseName, int credits) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.credits = credits;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

 
    public String toString() {
        return "Course ID: " + courseID + ", Course Name: " + courseName + ", Credits: " + credits;
    }
}


class Enrollment {
    private int[][] studentCourses;
    private int[] count;
    private static final int MAX_COURSES = 10; 
    public Enrollment(int numStudents) {
        studentCourses = new int[numStudents][MAX_COURSES];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        if (count[studentID] < MAX_COURSES) {
            studentCourses[studentID][count[studentID]] = courseID;
            count[studentID]++;
            System.out.println("Student ID: " + studentID + " enrolled in course ID: " + courseID);
        } else {
            System.out.println("Student ID: " + studentID + " has reached the maximum number of enrolled courses.");
        }
    }

    public void drop(int studentID, int courseID) {
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
              
                for (int j = i; j < count[studentID] - 1; j++) {
                    studentCourses[studentID][j] = studentCourses[studentID][j + 1];
                }
                studentCourses[studentID][count[studentID] - 1] = 0; 
                count[studentID]--;
                System.out.println("Student ID: " + studentID + " dropped course ID: " + courseID);
                return;
            }
        }
        System.out.println("Student ID: " + studentID + " is not enrolled in course ID: " + courseID);
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Student ID: " + studentID + " is enrolled in the following courses:");
        for (int i = 0; i < count[studentID]; i++) {
            int courseID = studentCourses[studentID][i];
            System.out.println(courseCatalog[courseID].toString());
        }
    }
}


public class CourseEnrollment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Course[] courseCatalog = {
            new Course(0, "JAVA", 4),
            new Course(1, "COA", 3),
            new Course(2, "DSA", 4),
            new Course(3, "MATH", 5)
        };
System.out.println("Enter number of student :");
int stunum = scan.nextInt();
        Enrollment enrollment = new Enrollment(stunum);

        boolean c=true;
        int choice;
while (c) { 
    

            System.out.println("\nCourse Enrollment System");
            System.out.println("1. Enroll in a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View enrolled courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentID = scan.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseID = scan.nextInt();
                    enrollment.enroll(studentID, courseID);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentID = scan.nextInt();
                    System.out.print("Enter course ID: ");
                    courseID = scan.nextInt();
                    enrollment.drop(studentID, courseID);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scan.nextInt();
                    enrollment.getEnrolledCourses(studentID, courseCatalog);
                    break;
                case 4:
                    System.out.println("Exiting from Program !");
                    c=false;
                   
                default:
                    System.out.println("ERROR:Enter Valid Choice !");
            }
        }
    }
}