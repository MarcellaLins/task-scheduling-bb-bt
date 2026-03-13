package algorithms;

import java.util.ArrayList;
import java.util.List;
import model.Solution;
import model.Task;

public class Backtracking {
    private Solution bestSolution;
    private int nodesExplored;

    public Solution solve(List<Task> tasks) {

        bestSolution = new Solution(new ArrayList<>(), 0);
        nodesExplored = 0;

        backtrack(tasks, 0, 0, 0, new ArrayList<>());

        System.out.println("Nós explorados: " + nodesExplored);

        return bestSolution;
    }

    private void backtrack(List<Task> tasks,
                           int index,
                           int currentTime,
                           int currentValue,
                           List<Task> currentTasks) {

        nodesExplored++;

        // caso base
        if (index == tasks.size()) {

            if (currentValue > bestSolution.getCost()) {
                bestSolution = new Solution(new ArrayList<>(currentTasks), currentValue);
            }

            return;
        }

        Task task = tasks.get(index);

        // opção 1: incluir a tarefa
        int finishTime = currentTime + task.getProcessingTime();

        if (finishTime <= task.getDeadline()) {

            currentTasks.add(task);

            backtrack(
                    tasks,
                    index + 1,
                    finishTime,
                    currentValue + task.getValue(),
                    currentTasks
            );

            currentTasks.remove(currentTasks.size() - 1);
        }

        // opção 2: não incluir a tarefa
        backtrack(
                tasks,
                index + 1,
                currentTime,
                currentValue,
                currentTasks
        );
    }
}
