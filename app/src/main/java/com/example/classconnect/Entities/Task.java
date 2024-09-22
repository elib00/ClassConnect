package com.example.classconnect.Entities;

public class Task {
    private final int taskNumber;
    private final String taskName;
    private final String taskInstructions;
    private boolean isDone;


    public Task(int taskNumber, String taskName, String taskInstructions){
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskInstructions = taskInstructions;
        isDone = false;
    }
    public boolean getIsDone(){
        return isDone;
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
