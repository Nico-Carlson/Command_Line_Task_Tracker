/*
 * This class contains the logic
 * for using the application.
 */

package commandlinetasktracker;

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

    // This function creates a new task.
    public static void addTask() {

        // Get user input values.
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

        /*
         Iterate through the arraylist of tasks
         and display to the user.
         */
        for (Task task : taskArrayList) {
            System.out.println(task + "\n");
        }
    }

    // This function will update a tasks to "completed".
    public static void completeTask() {

        // Get an id from the user.
        // todo: helper function for user inputs?
        System.out.println("What is the id of the task to complete: ");
        taskID = Integer.parseInt(myScan.nextLine());

        // Iterate through the list to find the correct task.
        for (Task t : taskArrayList) {

            // If the id matches, update completed.
            if (taskID == t.getID()) {
                t.setCompleted(true);
            }
        }
    }

    // This function allows the user to delete a task.
    public static void deleteTask() {

        // Get an id from the user.
        System.out.println("What is the id of the task to complete: ");
        taskID = Integer.parseInt(myScan.nextLine());

        // Iterate through the list to find the correct task.
        for (Task t : taskArrayList) {

            // If the id matches, update completed.
            if (taskID == t.getID()) {
                taskArrayList.remove(t);
            }
        }
    }


    // This function will allow the user to search task titles.
    public static void searchTasks() {

    }

    // This function displays statistics to the user.
    public static void showStats() {

    }

    // This task saves new tasks...
    public static void saveTasks() {

    }

}
