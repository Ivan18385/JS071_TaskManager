package view;

import model.Task;

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
        System.out.printf("%-5s%-20s%-15s%-15s%-10s%-20s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Plan from", "Plan to", "Assignee", "Reviewer");
    }

    public void addTaskFormHeader(){
        System.out.println("\n------------Add Task---------------");

    }
    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showUserInput(String input) {System.out.print(input); }

    public void showAllTask(List<Task> taskList){
        for (Task task : taskList){
            System.out.printf("%-5d %-20s %-15s %-15s %-10.1f %-10s %-15s",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskType(),
                    task.getDate(),
                    task.planTime(),
                    task.getAssignee(),
                    task.getReviewer());
        }
    }



}
