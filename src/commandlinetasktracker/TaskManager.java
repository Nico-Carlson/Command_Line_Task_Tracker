/*
 * This class contains the logic
 * for using the application.
 */

package commandlinetasktracker;

import java.util.Scanner;
import java.util.ArrayList;

public class TaskManager {

    // Initialize a scanner.
    Scanner myScan = new Scanner(System.in);
    ArrayList<Task> taskArrayList = ArrayList<>();

    // initialize ID and completed
    int taskID = taskArrayList.;        // get length of arraylist for id number
    boolean taskCompleted = false;

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

        // generate unique ID
        // to do - figure out how to get last known task id
        taskID += 1;
    }

    // This function will display a list of all tasks.
    public static void listTasks() {

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

    // This task saves new tasks...
    public static void saveTasks() {

    }

}
