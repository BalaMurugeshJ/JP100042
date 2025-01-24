package week_2_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class student {
    int id;
    String name;
    int mark;

    public student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{ID=" + id + ", Name='" + name + "', Mark=" + mark + "}";
    }
}

public class Project_3 {
    public static ArrayList<student> al = new ArrayList<>();
    public static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        loadTasksFromFile();
        int choice;

        while (true) {
            System.out.println("\n\tEnter your choice");
            System.out.println("1. Add New Entry");
            System.out.println("2. View the Entry");
            System.out.println("3. Sort By Mark");
            System.out.println("4. Sort By Name");
            System.out.println("5. Search By ID");
            System.out.println("6. Remove By ID");
            System.out.println("7. Exit\n");

            try {
                choice = Integer.parseInt(ip.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1:
                    addEntry();
                    break;
                case 2:
                    show(al);
                    break;
                case 3:
                    sortByMark();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    searchById();
                    break;
                case 6:
                    removeById();
                    break;
                case 7:
                    saveTasksToFile();
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Choice should be between 1 to 7.");
            }
        }
    }

    public static void addEntry() {
        int id;
        String name;
        int mark;

        while (true) {
            System.out.print("Enter ID for student: ");
            try {
                id = Integer.parseInt(ip.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for ID.");
            }
        }

        System.out.print("Enter Name for student: ");
        name = ip.nextLine();

        while (true) {
            System.out.print("Enter Mark for student: ");
            try {
                mark = Integer.parseInt(ip.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number for marks.");
            }
        }

        al.add(new student(id, name, mark));
        saveTasksToFile();
        System.out.println("Student entry added successfully.");
    }

    public static <T> void show(ArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("No entries found!");
        } else {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    public static void sortByMark() {
        if (al.isEmpty()) {
            System.out.println("No entries found!");
        } else {
            al.sort((s1, s2) -> Integer.compare(s2.mark, s1.mark));
            System.out.println("Sorted By Marks (High to Low):");
            show(al);
        }
    }

    public static void sortByName() {
        if (al.isEmpty()) {
            System.out.println("No entries found!");
        } else {
            al.sort((s1, s2) -> s1.name.compareToIgnoreCase(s2.name));
            System.out.println("Sorted By Name:");
            show(al);
        }
    }

    public static void searchById() {
        if (al.isEmpty()) {
            System.out.println("No entries found!");
        } else {
            System.out.print("Enter the ID to search: ");
            try {
                int searchId = Integer.parseInt(ip.nextLine());
                for (student s : al) {
                    if (s.id == searchId) {
                        System.out.println("Student found: " + s);
                        return;
                    }
                }
                System.out.println("ID not found.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public static void removeById() {
        if (al.isEmpty()) {
            System.out.println("No entries found!");
        } else {
            System.out.print("Enter the ID to remove: ");
            try {
                int searchId = Integer.parseInt(ip.nextLine());
                for (int i = 0; i < al.size(); i++) {
                    if (al.get(i).id == searchId) {
                        System.out.println("Student removed: " + al.get(i));
                        al.remove(i);
                        saveTasksToFile();
                        return;
                    }
                }
                System.out.println("ID not found.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void saveTasksToFile() {
        File file = new File("save.txt");
        try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
            for (student s : al) {
                writer.println(s.id + ", " + s.name + ", " + s.mark);
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    private static void loadTasksFromFile() {
        File file = new File("save.txt");
        if (!file.exists()) {
            System.out.println("No saved tasks found. Starting fresh.");
            return;
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int mark = Integer.parseInt(parts[2]);
                    al.add(new student(id, name, mark));
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}
