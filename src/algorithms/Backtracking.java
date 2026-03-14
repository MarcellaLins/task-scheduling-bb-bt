package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Solution;
import model.Task;

public class Backtracking {

    private Solution bestSolution;
    private int bestValue;
    private long nodesExplored;

    public Backtracking() {
        this.bestSolution = new Solution(new ArrayList<>(), 0);
        this.bestValue = 0;
        this.nodesExplored = 0;
    }

    public Solution solve(List<Task> tasks) {
        List<Task> sortedTasks = new ArrayList<>(tasks);

        // ordena por deadline crescente
        sortedTasks.sort(Comparator.comparingInt(Task::getDeadline));

        // reseta os dados para nova execução
        bestSolution = new Solution(new ArrayList<>(), 0);
        bestValue = 0;
        nodesExplored = 0;

        backtrack(sortedTasks, 0, 0, 0, new ArrayList<>());

        return bestSolution;
    }

    private void backtrack(List<Task> tasks, int index, int currentTime, int currentValue, List<Task> currentTasks) {
        nodesExplored++;

        // caso base
        if (index == tasks.size()) {
            if (currentValue > bestValue) {
                bestValue = currentValue;
                bestSolution = new Solution(new ArrayList<>(currentTasks), currentValue);
            }
            return;
        }

        Task task = tasks.get(index);

        // opção 1: não incluir a tarefa
        backtrack(tasks, index + 1, currentTime, currentValue, currentTasks);

        // opção 2: incluir a tarefa, se respeitar o deadline
        if (currentTime + task.getProcessingTime() <= task.getDeadline()) {
            currentTasks.add(task);

            backtrack(
                    tasks,
                    index + 1,
                    currentTime + task.getProcessingTime(),
                    currentValue + task.getValue(),
                    currentTasks
            );

            // desfaz a escolha
            currentTasks.remove(currentTasks.size() - 1);
        }
    }

    public long getNodesExplored() {
        return nodesExplored;
    }
}