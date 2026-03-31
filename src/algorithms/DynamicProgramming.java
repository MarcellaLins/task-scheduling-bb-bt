package algorithms;

import model.Task;
import model.Solution;

import java.util.*;

public class DynamicProgramming {

    public Solution solve(List<Task> tasks) {

        // Ordena por deadline
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparingInt(Task::getDeadline));

        int maxDeadline = sortedTasks.stream()
                .mapToInt(Task::getDeadline)
                .max()
                .orElse(0);

        // dp[t] = melhor valor possível no tempo t
        int[] dp = new int[maxDeadline + 1];

        // para reconstrução da solução
        boolean[][] take = new boolean[sortedTasks.size()][maxDeadline + 1];

        for (int i = 0; i < sortedTasks.size(); i++) {
            Task task = sortedTasks.get(i);

            for (int t = maxDeadline; t >= task.getProcessingTime(); t--) {
                if (t <= task.getDeadline()) {
                    int newValue = dp[t - task.getProcessingTime()] + task.getValue();

                    if (newValue > dp[t]) {
                        dp[t] = newValue;
                        take[i][t] = true;
                    }
                }
            }
        }

        int bestValue = 0;
        int bestTime = 0;

        for (int t = 0; t <= maxDeadline; t++) {
            if (dp[t] > bestValue) {
                bestValue = dp[t];
                bestTime = t;
            }
        }

        List<Task> selectedTasks = new ArrayList<>();

        for (int i = sortedTasks.size() - 1; i >= 0; i--) {
            Task task = sortedTasks.get(i);

            if (bestTime >= task.getProcessingTime() && take[i][bestTime]) {
                selectedTasks.add(task);
                bestTime -= task.getProcessingTime();
            }
        }

        Collections.reverse(selectedTasks);

        return new Solution(selectedTasks, bestValue);
    }
}