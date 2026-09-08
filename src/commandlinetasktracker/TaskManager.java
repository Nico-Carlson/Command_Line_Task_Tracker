/*
 * This class contains the logic
 * for the app functionality.
 */

package commandlinetasktracker;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskManager {

    // Initialize a scanner and arraylist.
    static Scanner myScan = new Scanner(System.in);
    static ArrayList<Task> taskArrayList = new ArrayList<>();

    // Initialize variables.
    static int taskID = taskArrayList.size();        // get length of arraylist for id number
    static String taskTitle = "";
    static String taskCategory = "";
    static String taskDescription = "";
    static int taskPriority = 0;
    static boolean taskCompleted = false;
    static String done = "n";

    // This function creates a new task.
    public static void addTask() {

        while (!done.equals("n")) {
            // Get user input values.
            try {
                System.out.println("Enter task name: ");
                taskTitle = myScan.nextLine();

                System.out.println("Enter task category: ");
                taskCategory = myScan.nextLine();

                System.out.println("Enter task description: ");
                taskDescription = myScan.nextLine();

                System.out.println("Enter task priority (1-5): ");
                taskPriority = Integer.parseInt(myScan.nextLine());

                // Generate unique ID
                taskID = taskArrayList.getLast().getID() + 1;

                // ask user if they'd like to repeat function
                System.out.println("Would you like to add another task? (y/n): ");
                done = myScan.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Improper Input... Try again\n");

                // restart loop if invalid input
                continue;
            }

            // Create a new task.
            Task newTask = new Task(taskID, taskTitle, taskDescription,
                    taskCategory, taskPriority, taskCompleted);

            // Add task to task array list.
            taskArrayList.add(newTask);
        }
    }

    // This function will display a list of all tasks.
    public static void listTasks() {

        /*
         Iterate through the arraylist of tasks
         and display to the user.
         */
        for (Task t : taskArrayList) {
            System.out.println(t + "\n");
        }
    }

    // This function will update a tasks to "completed".
    public static void completeTask() {

        // Initialize taskFound.
        boolean taskFound = false;
        done = "y";


        while (!done.equals("n")) {

            // Display current tasks to choose from
            for(Task t: taskArrayList){
                System.out.println(t.getID() + ": " + t.getTitle());
            }

            // Get an id from the user.
            try {
                System.out.println("What is the id of the task to complete: ");
                taskID = Integer.parseInt(myScan.nextLine());


            // Iterate through the list to find the correct task.
            for (Task t : taskArrayList) {

                // If the id matches, update completed.
                if (taskID == t.getID()) {
                    t.setCompleted(true);
                    taskFound = true;
                    break;
                }
            }

            // Let the user know if no such task exists.
            if (!taskFound) {
                System.out.println("No such task id matches: " + taskID + "\n");
            }

            // Let the user know what was changed
            System.out.println("Task " + taskID + " was completed.\n");

            // ask user if they'd like to repeat function
            System.out.println("Would you like to complete another task? (y/n): ");
            done = myScan.nextLine();

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    // This function allows the user to delete a task.
    public static void deleteTask() {

        // Initialize taskFound.
        boolean taskFound = false;
        done = "y";

        while (!done.equals("n")) {

            // Display current tasks to choose from
            for(Task t: taskArrayList){
                System.out.println(t.getID() + ": " + t.getTitle());
            }

            // Get an id from the user.
            try {
                System.out.println("What is the id of the task to delete: ");
                taskID = Integer.parseInt(myScan.nextLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            // Iterate through the list to find the correct task.
            for (Task t : taskArrayList) {

                // If the id matches, update completed.
                if (taskID == t.getID()) {
                    taskArrayList.remove(t);
                    taskFound = true;
                    break;
                }
            }

            // Let the user know if no such task exists.
            if (!taskFound) {
                System.out.println("No such task id matches: " + taskID + "\n");
            }

            // Let the user know what was changed
            System.out.println("Task " + taskID + " was deleted.\n");

            // ask user if they'd like to repeat function
            System.out.println("Would you like to delete another task? (y/n): ");
            done = myScan.nextLine();
        }
    }

    // This function will allow the user to search task titles.
    public static void searchTasks() {

        // Initialize variable to store search.
        String userText = "";
        String userTextLower = "";
        String taskTitle = "";
        boolean foundTask = false;

        // Get user input for task title.
        try {
            System.out.println("What is the title of the task: ");
            userText = myScan.nextLine();
            userTextLower = userText.toLowerCase();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Iterate through the arraylist to find the correct task.
        for (Task t : taskArrayList) {

            taskTitle = t.getTitle().toLowerCase();

            // Check to see if taskTitle matches.
            if (t.getTitle().toLowerCase().contains(userTextLower)) {
                System.out.println("\n" + t + "\n");
                foundTask = true;
            }
        }

        // If no match was found, inform the user.
        if (!foundTask) {
            System.out.println("No task containing " + userText + " was found\n");
        }
    }

    // This function displays statistics to the user.
    public static void showStats() {

        // instantiate variables
        int totalTasks = 0;
        double completedTasks = 0.0;
        double incompleteTasks = 0.0;
        int highPriorityTasks = 0;
        double completionPercentage = 0.0;

        // set total tasks to length of ArrayList
        totalTasks = taskArrayList.size();

        // iterate through the ArrayList to increase counts
        for (Task t : taskArrayList){

            // if task is completed increase the count
            if (t.isCompleted()) completedTasks++;

            // if task is high priority (4 or 5) increase the count
            if (t.getPriority() == 4 || t.getPriority() == 5) highPriorityTasks++;
        }

        // calc the incomplete tasks
        incompleteTasks = totalTasks - completedTasks;

        // calc the completion percentage
        completionPercentage = Math.round((completedTasks / totalTasks) * 100);

        // print statistics to the screen
        System.out.println(
                "\nTotal Tasks: " + totalTasks +
                "\nCompleted Tasks: " + Math.round(completedTasks * 1) +
                "\nIncomplete Tasks: " + Math.round(incompleteTasks * 1) +
                "\nHigh Priority Tasks: " + highPriorityTasks +
                "\nCompletion Percentage: " + completionPercentage + "%\n");

    }

    // This task loads new tasks...
    // It will only run at the start of the program once
    public static void loadTasks() {

        // set which file to read
        File myFile = new File("savedTasks.txt");
//
        // first make the file if it doesnt already exist
        try {
            if (myFile.createNewFile()) {

                // Try to create the file
                System.out.println("File created: " + myFile.getName() + "\n");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            // Print error details
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // try to read the file
        try (BufferedReader myReader = new BufferedReader(new FileReader(myFile))) {

            // set a temp variable to check if the file still has data to read
            String firstLine;
            while ((firstLine = myReader.readLine()) != null) {

                // assign variables for each property
                // since the first line read is stored in buffer just use that for the first value
                int taskID = Integer.parseInt(firstLine);
                String taskTitle = myReader.readLine();
                String taskDescription = myReader.readLine();
                String taskCategory = myReader.readLine();
                int taskPriority = Integer.parseInt(myReader.readLine());
                boolean taskCompleted = Boolean.parseBoolean(myReader.readLine());

                // Create a new task with the new variables
                Task newTask = new Task(taskID, taskTitle, taskDescription,
                        taskCategory, taskPriority, taskCompleted);

                // Add task to task array list.
                taskArrayList.add(newTask);

            }
        // send error message if it couldn't read the file
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // This task saves new tasks...
    public static void saveTasks() {

//        // first make the file if it doesnt already exist
//        try {
//            File myObj = new File("savedTasks.txt");
//            if (myObj.createNewFile()) {
//
//                // Try to create the file
//                System.out.println("File created: " + myObj.getName() + "\n");
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            // Print error details
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }


        // attempt to write data to the file
        try {
            // initialize FileWriter here because it needs the exception handling to work
            FileWriter myWriter = new FileWriter("savedTasks.txt");

            // use this to find the directory its being saved if needed
            // System.out.println(System.getProperty("user.dir"));

            // iterate through ArrayList and write as we go
            for (int i = 0; i < taskArrayList.size(); i++){

                // get temp variables from each task
                int ID = taskArrayList.get(i).getID();
                String title = taskArrayList.get(i).getTitle();
                String description = taskArrayList.get(i).getDescription();
                String category = taskArrayList.get(i).getCategory();
                int priority = taskArrayList.get(i).getPriority();
                boolean completed = taskArrayList.get(i).isCompleted();

                // format it to the txt file so each property is on a new line (makes reading easier)
                myWriter.write(ID + "\n" + title + "\n" + description + "\n" +
                                category + "\n" + priority + "\n" + completed + "\n");
            }

            // close the writer
            myWriter.close();

            // confirmation message that data was saved
            System.out.println("Successfully saved the task list.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
