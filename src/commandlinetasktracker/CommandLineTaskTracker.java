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

        // TESTING DATA - Remove when load functionality is running.
        int[] testIDs = {1, 2, 3};
        String[] testNames = {"task1", "task2", "task3"};
        String[] testDescriptions = {"desc1", "desc2", "desc3"};
        String[] testCategories = {"Personal", "Work", "School"};
        int[] testPriorities = {1, 3, 5};

        for(int i = 0; i < testIDs.length; i++) {
            Task testTask = new Task(testIDs[i], testNames[i], testDescriptions[i], testCategories[i], testPriorities[i], false);
            TaskManager.taskArrayList.add(testTask);
        }
        // END OF TEST DATA

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

        // The loop runs until the user terminates the session.
        while (true) {

            // Get user input for choice.
            System.out.println(msg);
            try {
                choice = Integer.parseInt(myScan.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // Call the appropriate function based on choice.
            if (choice == 1) {
                System.out.println("Add a new task\n");
                TaskManager.addTask();
            } else if (choice == 2) {
//                System.out.println("List all tasks");
                TaskManager.listTasks();
            } else if (choice == 3) {
                System.out.println("Complete a task\n");
            } else if (choice == 4) {
                System.out.println("Delete task\n");
            } else if (choice == 5) {
                System.out.println("search tasks\n");
            } else if (choice == 6) {
                System.out.println("show stats\n");
            } else if (choice == 7) {
                System.out.println("save tasks\n");
            } else if (choice == 8) {
                System.out.println("Goodbye\n");
                System.exit(0);
            } else {
                System.out.println("Invalid input. Please try again.\n");
            }
        }
    }
}
