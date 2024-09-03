package com.example.classconnect.Entities;

public class Task {
    private final int taskNumber;
    private final String taskName;
    private final String taskInstructions;


    public Task(int taskNumber, String taskName, String taskInstructions){
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskInstructions = taskInstructions;
    }

    public int getTaskNumber(){
        return taskNumber;
    }

    public String getTaskName(){
        return taskName;
    }

    public String getTaskInstructions(){
        return taskInstructions;
    }
}
