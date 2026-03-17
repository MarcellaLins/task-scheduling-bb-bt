package model;

public class Task {

    private final int processingTime;
    private final int deadline;
    private final int value;

    public Task(int processingTime, int deadline, int value) {
        this.processingTime = processingTime;
        this.deadline = deadline;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Task{" +
                "processingTime=" + processingTime +
                ", deadline=" + deadline +
                ", value=" + value +
                '}';
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