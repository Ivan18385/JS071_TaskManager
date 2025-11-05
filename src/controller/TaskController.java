package controller;

import constants.TaskType;
import model.Task;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TaskController {
    private final List<Task> taskList = new ArrayList<>();
    private int lastId = 1;


    //add task function
    public void addTask(String requirementName, TaskType taskType, Date date,
                        double planFrom, double planTo, String assignee, String reviewer) {
        int newId = lastId++;
        Task newTask = new Task(newId, requirementName, taskType, date, planFrom, planTo, assignee, reviewer);
        taskList.add(newTask);
    }

    //delete task
    public void deleteTask(int id) {
        boolean removedTask = taskList.removeIf(task -> task.getId() == id);
        if (!removedTask) {
            throw new IllegalArgumentException("Task ID " + id + " not found");
        }
    }

    //return a copy of all task
    public List<Task> getTaskList() {
        return new ArrayList<>(taskList);
    }

    public List<Task> displayTaskAscendingId(){
        List<Task> sortTask = getTaskList();
        sortTask.sort(Comparator.comparingInt(Task :: getId));
        return sortTask;
    }


}
