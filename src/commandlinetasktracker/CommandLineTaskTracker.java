/*
 * Developers: Parker Basham, Nico Carlson
 * Project: Command-Line Task Tracker
 * Date:
 * Description: This app is a command line task manager
 * meant to review core java concepts and build a complete
 * and useful program.
 */

package commandlinetasktracker;

import java.util.Scanner;

public class CommandLineTaskTracker {

    // The main method serves as the main menu for the app.
    public static void main(String[] args) {

        // Initialize a scanner to take user input.
        Scanner myScan = new Scanner(System.in);

        // Initialize variables.
        int choice = 0;
        String msg = """
                Welcome to the task manager! 
                Please select and option (1-8) 
                1 - Add a new task
                2 - List all tasks
                3 - Complete a task
                4 - Delete a task
                5 - Search Tasks
                6 - Show statistics
                7 - Save Tasks
                8 - Exit
                """;
        boolean endLoop = false;

        // Get user input for choice.
        // todo: add loop
        // todo: add try/catch
        System.out.println(msg);
        choice = Integer.parseInt(myScan.nextLine());

        // Call the appropriate function based on choice.
        if (choice == 1) {
            System.out.println("Add a new task");
        } else if (choice == 2) {
            System.out.println("List all tasks");
        } else if (choice == 3) {
            System.out.println("Complete a task");
        } else if (choice == 4) {
            System.out.println("Delete task");
        } else if (choice == 5) {
            System.out.println("search tasks");
        } else if (choice == 6) {
            System.out.println("show stats");
        } else if (choice == 7) {
            System.out.println("save tasks");
        } else if (choice == 8) {
            System.out.println("Goodbye");
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
