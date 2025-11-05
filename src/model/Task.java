package model;

import constants.TaskType;

import java.util.Date;

public class Task {
    private int id;
    private String requirementName;
    private TaskType taskType;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;


    //constructor full parameters and without parameters
    public Task() {
    }

    public Task(int id, String requirementName, TaskType taskType, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.requirementName = requirementName;
        this.taskType = taskType;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public double planTime(){
        return planTo + planFrom;
    }
}
