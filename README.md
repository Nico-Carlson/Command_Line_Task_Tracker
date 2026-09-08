# Command Line Task Tracker
### Developed by Parker Basham & Nico Carlson

---

## To Do
- ~~needs spacing after user adds/completes/deletes/searching a new task~~
- ~~you can add improper types when adding a task (doesn't seem to break it but it also doesn't fit the form)~~
- ~~adding an "empty" task kept the ID from the last task~~
- ~~give a confirmation of what task was completed/deleted~~
- ~~when choosing what task to delete maybe add a list of all current task IDs and names?~~
- ~~search seems to be case sensitive~~ 
- ~~move the create file to the load not save function~~
- ~~when completeing/deleting a task I can type a string without being prompted to enter a task ID~~
 

---


## Solved issues

 **iterating over a list and removing an object caused us pain**
```java
for (Task t : taskArrayList) {
    if (taskID == t.getID()) {
        taskArrayList.remove(t);
        break;  // adding this solved the issue
    }
}
```
- since we changed the length of the array before moving to the next index it screwed things up
- (intelliJ gave a weird "error" that the line numbers may have diverged which led us down a long and disappointing rabbit hole that didn't really end up mattering)
- another solution we found recommended was
```java
// If the id matches, update completed.
taskArrayList.removeIf(t -> taskID == t.getID());
```

---
We also added a .gitattributes file to hopefully account for the line ending differences of varying OS