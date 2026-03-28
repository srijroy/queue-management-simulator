import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Person> queue = new PriorityQueue<>(new PersonComparator());
    static Scanner scanner = new Scanner(System.in);
    static int totalServed = 0;

    public static void main(String[] args) {

        loadFromFile(); // 🔥 LOAD DATA AT START

        System.out.println("\nQueue Management Simulator");
        System.out.println("==========================");

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Choice: ");

            switch (choice) {
                case 1: addPerson(); break;
                case 2: serveNext(); break;
                case 3: showQueue(); break;
                case 4: showStats(); break;
                case 5:
                    saveToFile(); // 🔥 SAVE BEFORE EXIT
                    System.out.println("Exiting.");
                    running = false;
                    break;
                default:
                    System.out.println("Enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n1. Add person");
        System.out.println("2. Serve next");
        System.out.println("3. View queue");
        System.out.println("4. Statistics");
        System.out.println("5. Exit");
    }

    static void addPerson() {
        System.out.print("\nName: ");
        String name = scanner.nextLine().trim();

        int age = readInt("Age: ");

        System.out.println("Type: 1) Normal  2) Elderly  3) Emergency");
        int t = readInt("Pick: ");

        String type;
        switch (t) {
            case 2: type = "Elderly"; break;
            case 3: type = "Emergency"; break;
            default: type = "Normal";
        }

        Person p = new Person(name, age, type);
        queue.add(p);

        saveToFile(); // 🔥 SAVE AFTER ADD

        System.out.println("Added: " + p);
    }

    static void serveNext() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Person p = queue.poll();
        totalServed++;

        saveToFile(); // 🔥 SAVE AFTER SERVE

        System.out.println("Serving: " + p);
        System.out.println("Total served: " + totalServed);
    }

    static void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        PriorityQueue<Person> copy = new PriorityQueue<>(new PersonComparator());
        copy.addAll(queue);

        System.out.println("\n--- CURRENT QUEUE ---");
        int i = 1;
        while (!copy.isEmpty()) {
            System.out.println(i++ + ". " + copy.poll());
        }

        System.out.println("Waiting: " + queue.size());
    }

    static void showStats() {
        int normal = 0, elderly = 0, emergency = 0;

        for (Person p : queue) {
            switch (p.getType().toLowerCase()) {
                case "normal": normal++; break;
                case "elderly": elderly++; break;
                case "emergency": emergency++; break;
            }
        }

        System.out.println("\n--- STATISTICS ---");
        System.out.println("Waiting  : " + queue.size());
        System.out.println("Served   : " + totalServed);
        System.out.println("Emergency: " + emergency);
        System.out.println("Elderly  : " + elderly);
        System.out.println("Normal   : " + normal);
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Numbers only.");
            }
        }
    }

  
    static void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter("data.txt");

            for (Person p : queue) {
                writer.println(p.getName() + "," + p.getAge() + "," + p.getType());
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

   
    static void loadFromFile() {
        try {
            File file = new File("data.txt");
            if (!file.exists()) return;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String type = parts[2];

                queue.add(new Person(name, age, type));
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error loading data.");
        }
    }
}