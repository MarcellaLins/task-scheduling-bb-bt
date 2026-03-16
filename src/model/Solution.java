package model;
import java.util.List;

public class Solution {

    private final List<Task> tasks;
    private int value;

    public Solution(List<Task> tasks, int value) {
        this.tasks = tasks;
        this.value = value;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
