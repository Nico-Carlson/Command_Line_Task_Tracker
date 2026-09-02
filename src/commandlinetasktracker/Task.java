/*
 * This class defines what a task is.
 */

package commandlinetasktracker;

public class Task {

    // properties
    private int ID;
    private String title = "";
    private String description = "";
    private String category = "";
    private int priority;
    private boolean completed = false;

    // constructors
    Task(int ID, String title, String description, String category, int priority, boolean completed){
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.completed = completed;
    }

    // getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // methods
    @Override
    public String toString() {
        return (this.ID + " " + this.title + " (" + this.category + ")\n" +
                "Priority of " + this.priority + "\nCompleted? " + this.completed +
                "\n" + this.description);
    }


}
