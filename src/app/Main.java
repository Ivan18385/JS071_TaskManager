package app;

import controller.TaskController;
import util.Validation;
import view.TaskView;

import java.util.Date;
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
                        addTaskForm();
                        break;
                    case 2:
                        break;
                    case 3:
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

    public static void addTaskForm() {
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
                break;
            } catch (Exception e) {
                view.showMessage("Error adding task: " + e.getMessage());
            }

        }
    }
}


