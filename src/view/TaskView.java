package view;

import model.Task;

import java.text.SimpleDateFormat;
import java.util.List;

public class TaskView {
    public void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public void addTaskHeader() {
        System.out.println("\n----------------------------------------- Task ---------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-15s %-10s %-10s %-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
    }

    public void addTaskFormHeader(){
        System.out.println("\n------------Add Task---------------");

    }
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showUserInput(String input) {System.out.print(input); }

    public void showAllTask(List<Task> taskList){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for (Task task : taskList){
            System.out.printf("%-5d %-20s %-15s %-15s %-10.1f %-10s %-15s \n",
                    task.getId(),
                    task.getRequirementName(),
                    //lay ten task qua enum
                    task.getTaskType().toString(),
                    dateFormat.format(task.getDate()),
                    task.calculatePlanTime(),
                    task.getAssignee(),
                    task.getReviewer());
        }
    }



}
