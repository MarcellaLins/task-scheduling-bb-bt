package model;
import java.util.List;

public class Solution {

    private List<Task> tasks;
    private int cost;

    public Solution(List<Task> tasks, int cost) {
        this.tasks = tasks;
        this.cost = cost;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
