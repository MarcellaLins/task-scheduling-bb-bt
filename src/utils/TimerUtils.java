package utils;

import model.Solution;

import java.util.function.Supplier;

public class TimerUtils {

    public static TimedResult measureAverage(Supplier<Solution> taskSupplier, int repetitions) {
        long totalTimeNs = 0;
        Solution lastSolution = null;

        for (int i = 0; i < repetitions; i++) {
            long startTime = System.nanoTime();
            lastSolution = taskSupplier.get();
            long endTime = System.nanoTime();

            totalTimeNs += (endTime - startTime);
        }

        double averageMs = totalTimeNs / (double) repetitions / 1_000_000.0;
        return new TimedResult(lastSolution, averageMs);
    }

    public static class TimedResult {
        private final Solution solution;
        private final double averageTimeMs;

        public TimedResult(Solution solution, double averageTimeMs) {
            this.solution = solution;
            this.averageTimeMs = averageTimeMs;
        }

        public Solution getSolution() {
            return solution;
        }

        public double getAverageTimeMs() {
            return averageTimeMs;
        }
    }
}