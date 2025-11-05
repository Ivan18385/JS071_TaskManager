package app;

import constants.TaskType;
import controller.TaskController;
import model.Task;
import util.Validation;
import view.TaskView;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final Validation validate = new Validation();
    private static final TaskView view = new TaskView();
    private static TaskController controller = new TaskController();

    public static void main(String[] args) {
        view.displayMenu();
        while (true) {
            try {
                view.showUserInput("Enter choice(1-4): ");
                int choice = validate.validateInteger(scan.nextLine(), 1, 4, "Choice");
                switch (choice) {
                    case 1:
                        handleAddTask();
                        break;
                    case 2:
                        handleDeleteTask();
                        break;
                    case 3:
                        handleDisplayTask();
                        break;
                    case 4:
                        view.showMessage("See you again!");
                        System.exit(0);
                        break;
                }
            } catch (Exception e) {
                view.showMessage(e.getMessage());
            }
        }

    }

    //function 1
    public static void handleAddTask() {
        view.addTaskFormHeader();
        while (true) {
            try {
                view.showUserInput("Requirement Name: ");
                String requirementName = validate.checkString(scan.nextLine());

                view.showUserInput("Task Type: ");
                int taskType = validate.validateInteger(scan.nextLine(), 1, 4, "Task type");

                view.showUserInput("Date: ");
                Date date = validate.validateDate(scan.nextLine());

                view.showUserInput("From: ");
                double planFrom = validate.validatePlanValues(scan.nextLine(), 8.0, 17.5);

                view.showUserInput("To: ");
                double planTo = validate.validatePlanValues(scan.nextLine(), 8.0, 17.5);

                //check plan
                if (!validate.validatePlanRange(planFrom, planTo)) {
                    view.showMessage("Plan from must be smaller than plan to!");
                }

                view.showUserInput("Assignee: ");
                String assignee = validate.checkString(scan.nextLine());

                view.showUserInput("Reviewer: ");
                String reviewer = validate.checkString(scan.nextLine());
                controller.addTask(requirementName, TaskType.fromId(taskType), date, planFrom, planTo, assignee, reviewer );
                break;
            } catch (Exception e) {
                view.showMessage(e.getMessage());
            }

        }
    }

    //funtion 2
    public static void handleDeleteTask(){
        view.showUserInput("Enter ID to delete: ");
        int idToDelete = validate.validateInteger(scan.nextLine(), 1, 4, "ID");
        controller.deleteTask(idToDelete);
        view.showMessage("Delete completed !");
    }

    //function 3
    public static void handleDisplayTask(){
        List<Task> sortedTask =  controller.displayTaskAscendingId();
        if (sortedTask.isEmpty()) throw new IllegalArgumentException("No Task to display");
        view.addTaskHeader();
        view.showAllTask(sortedTask);
    }

}


