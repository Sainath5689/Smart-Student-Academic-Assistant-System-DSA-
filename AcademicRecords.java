// CO4: Interactive Academic Records using HashMap
import java.util.HashMap;
import java.util.Scanner;

public class AcademicRecords {
    private HashMap<String, Integer> studentMarks = new HashMap<>();

    // Add student record
    public void addRecord(String name, int marks) {
        studentMarks.put(name, marks);
        System.out.println("Record added: " + name + " scored " + marks);
    }

    // Lookup student record
    public void getRecord(String name) {
        if (studentMarks.containsKey(name)) {
            System.out.println(name + " scored: " + studentMarks.get(name));
        } else {
            System.out.println("Record not found for " + name);
        }
    }

    // Display all records
    public void displayAllRecords() {
        if (studentMarks.isEmpty()) {
            System.out.println("No records available.");
        } else {
            System.out.println("All Student Records:");
            for (String name : studentMarks.keySet()) {
                System.out.println("- " + name + ": " + studentMarks.get(name));
            }
        }
    }

    // Remove a record
    public void removeRecord(String name) {
        if (studentMarks.remove(name) != null) {
            System.out.println("Record removed for " + name);
        } else {
            System.out.println("No record found for " + name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AcademicRecords ar = new AcademicRecords();
        int choice;

        do {
            System.out.println("\n=== Smart Student Academic Assistant: Academic Records ===");
            System.out.println("1. Add Student Record");
            System.out.println("2. Search Student Record");
            System.out.println("3. Display All Records");
            System.out.println("4. Remove Student Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    ar.addRecord(name, marks);
                    break;
                case 2:
                    System.out.print("Enter student name to search: ");
                    String searchName = sc.nextLine();
                    ar.getRecord(searchName);
                    break;
                case 3:
                    ar.displayAllRecords();
                    break;
                case 4:
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine();
                    ar.removeRecord(removeName);
                    break;
                case 5:
                    System.out.println("Exiting Academic Records...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}