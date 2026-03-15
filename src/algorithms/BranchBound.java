package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Solution;
import model.Task;

public class BranchBound {

    private Solution bestSolution;
    private int bestValue;
    private long nodesExplored;

    public BranchBound() {
        this.bestSolution = new Solution(new ArrayList<>(), 0);
        this.bestValue = 0;
        this.nodesExplored = 0;
    }

    public Solution solve(List<Task> tasks) {

        List<Task> sortedTasks = new ArrayList<>(tasks);

        // ordena por deadline crescente
        sortedTasks.sort(Comparator.comparingInt(Task::getDeadline));

        bestSolution = new Solution(new ArrayList<>(), 0);
        bestValue = 0;
        nodesExplored = 0;

        branchAndBound(sortedTasks, 0, 0, 0, new ArrayList<>());

        return bestSolution;
    }

    private void branchAndBound(List<Task> tasks, int index, int currentTime, int currentValue, List<Task> currentTasks) {

        nodesExplored++;

        // cálculo do bound
        int upperBound = currentValue + calculateRemainingValue(tasks, index);

        // poda o trecho da árvore
        if (upperBound <= bestValue) {
            return;
        }

        // caso base
        if (index == tasks.size()) {

            if (currentValue > bestValue) {
                bestValue = currentValue;
                bestSolution = new Solution(new ArrayList<>(currentTasks), currentValue);
            }

            return;
        }

        Task task = tasks.get(index);

        // opção 1: incluir tarefa
        if (currentTime + task.getProcessingTime() <= task.getDeadline()) {

            currentTasks.add(task);

            branchAndBound(tasks, index + 1, currentTime + task.getProcessingTime(), currentValue + task.getValue(), currentTasks);

            currentTasks.remove(currentTasks.size() - 1);
        }

        // opção 2: não incluir tarefa
        branchAndBound(tasks, index + 1, currentTime, currentValue, currentTasks);
    }

    private int calculateRemainingValue(List<Task> tasks, int index){

        int sum = 0;
        for(int i = index; i < tasks.size(); i++){
            sum += tasks.get(i).getValue();
        }

        return sum;
    }

    public long getNodesExplored(){
        return nodesExplored;
    }
}