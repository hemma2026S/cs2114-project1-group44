package moodie;
// -------------------------------------------------------------------------
/**
 *  Main class that runs the program and interacts with the user
 * 
 *  @author Team 4
 *  @version Sep 15, 2026
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class MoodieApp {
    private ArrayList<MoodEntry> entries; // Holds an ArrayList<MoodEntry>[cite: 2]
    private MoodStorage storage;
    private MoodAnalyzer analyzer;
    private MoodMessage messenger;
    private Scanner scanner;

    public MoodieApp() {
        this.storage = new MoodStorage("mood_data.txt");
        this.analyzer = new MoodAnalyzer();
        this.messenger = new MoodMessage();
        this.scanner = new Scanner(System.in);
        this.entries = storage.loadData();
    }

    // Starts the app and handles the main menu loop[cite: 2]
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Moodie App ---");
            System.out.println("1. Log Mood");
            System.out.println("2. View Weekly Average");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    getMood();
                    break;
                case "2":
                    System.out.println("Your average mood is: " + analyzer.calculateWeeklyAverage(entries));
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Handles the workflow of capturing the mood[cite: 2]
    private void getMood() {
        Integer validMood = validateMood();
        if (validMood != null) {
            String date = LocalDate.now().toString(); // Date for the entry[cite: 1]
            String time = LocalTime.now().toString(); // Time for the entry[cite: 1]
            
            MoodEntry newEntry = new MoodEntry(validMood, date, time);
            entries.add(newEntry);
            storage.writeEntry(newEntry);
            
            System.out.println(messenger.getMessage(validMood));
        }
    }

    // Reprompts the user if input is outside 1-10, not an integer, or returns null if empty[cite: 2]
    private Integer validateMood() {
        System.out.print("How are you feeling today on a scale of 1-10? (Press Enter to skip): ");
        String input = scanner.nextLine();
        
        // If no mood rating is detected, the app does not create a new entry[cite: 2]
        if (input.trim().isEmpty()) {
            return null;
        }
        
        try {
            int rating = Integer.parseInt(input);
            // Catch ratings outside 1-10[cite: 2]
            if (rating >= 1 && rating <= 10) {
                return rating;
            } else {
                System.out.println("Please enter a valid number between 1 and 10.");
                return validateMood(); 
            }
        } catch (NumberFormatException e) {
            // Catch non-integer inputs like "pizza"[cite: 2]
            System.out.println("Invalid input. Please enter an integer.");
            return validateMood();
        }
    }

    public static void main(String[] args) {
        MoodieApp app = new MoodieApp();
        app.start();
    }
}
