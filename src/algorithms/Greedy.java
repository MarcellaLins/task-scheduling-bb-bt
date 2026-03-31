package algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Solution;
import model.Task;

public class Greedy {

    public Solution solve(List<Task> tasks) {

        List<Task> sortedTasks = new ArrayList<>(tasks);

        // ordena por valor por unidade de tempo (value | processingTime) de forma decrescente
        sortedTasks.sort(Comparator.comparingDouble(
                (Task t) -> (double) t.getValue() / t.getProcessingTime()
        ).reversed());

        List<Task> selectedTasks = new ArrayList<>();

        int currentTime = 0;
        int totalValue = 0;

        for(Task task : sortedTasks){
            if(currentTime + task.getProcessingTime() <= task.getDeadline()){

                selectedTasks.add(task);

                currentTime += task.getProcessingTime();
                totalValue += task.getValue();
            }
        }

        return new Solution(selectedTasks, totalValue);
    }
}