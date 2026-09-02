/*
 * This class contains the logic
 * for using the application.
 */

package commandlinetasktracker;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

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

    // This function creates a new task.
    public static void addTask() {

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

        // Create a new task.
        Task newTask = new Task(taskID, taskTitle, taskDescription,
                                taskCategory, taskPriority, taskCompleted);

        // Add task to task array list.
        taskArrayList.add(newTask);

    }

    // This function will display a list of all tasks.
    public static void listTasks() {

        int count = 1;

        for (Task task : taskArrayList) {
            System.out.println(task + "\n");
        }

    }

    // This function will update a tasks to completed.
    public static void completeTask() {

    }

    // This function will allow the user to search task titles.
    public static void searchTasks() {

    }

    // This function displays statistics to the user.
    public static void showStats() {

    }

    // This task loads new tasks...
    public static void loadTasks() {

        // set which file to read
        File myObj = new File("savedTasks.txt");

        // try to read the file
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {

                // assign variables for each property
                int taskID = myReader.nextInt();
                String taskTitle = myReader.next();
                String taskDescription = myReader.next();
                String taskCategory = myReader.next();
                int taskPriority = myReader.nextInt();
                boolean taskCompleted = myReader.nextBoolean();


                // Create a new task.
                Task newTask = new Task(taskID, taskTitle, taskDescription,
                        taskCategory, taskPriority, taskCompleted);

                // Add task to task array list.
                taskArrayList.add(newTask);

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // This task saves new tasks...
    public static void saveTasks() {

        // first make the file if it doesnt already exist
        try {
            File myObj = new File("savedTasks.txt");
            if (myObj.createNewFile()) {

                // Try to create the file
                System.out.println("File created: " + myObj.getName() + "\n");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            // Print error details
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


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


                myWriter.write(ID + "\n" + title + "\n" + description + "\n" +
                                category + "\n" + priority + "\n" + completed + "\n");
            }

            // close the writer
            myWriter.close();  // must close manually

            // confirmation data was saved
            System.out.println("Successfully saved the task list.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
