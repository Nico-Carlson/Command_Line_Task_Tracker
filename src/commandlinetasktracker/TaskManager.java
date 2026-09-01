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

    // This task saves new tasks...
    public static void saveTasks() {

    }

}
