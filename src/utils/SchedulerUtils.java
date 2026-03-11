package utils;

import model.Task;
import java.util.List;

public class SchedulerUtils {

    public static int calculateCost(List<Task> tasks) {
        int cost = 0;
        int time = 0;

        for (Task t : tasks) {
            time += t.getProcessingTime();
            cost += time;
        }

        return cost;
    }

}
