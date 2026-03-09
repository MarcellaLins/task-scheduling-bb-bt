package model;

public class Task {

    private int id;
    private int processingTime;
    private int deadline;

    public Task(int id, int processingTime, int deadline) {
        this.id = id;
        this.processingTime = processingTime;
        this.deadline = deadline;
    }

    public int getId() {
        return id;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getDeadline() {
        return deadline;
    }

}