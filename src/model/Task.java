package model;

public class Task {

    private final int id;
    private final int processingTime;
    private final int deadline;
    private final int value;

    public Task(int id, int processingTime, int deadline, int value) {
        this.id = id;
        this.processingTime = processingTime;
        this.deadline = deadline;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", processingTime=" + processingTime +
                ", deadline=" + deadline +
                '}';
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

    public int getValue() {
        return value;
    }

}