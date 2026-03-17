import algorithms.Backtracking;
import algorithms.BranchBound;
import model.Solution;
import model.Task;
import utils.InputGenerator;
import utils.InputReader;
import utils.ResultWriter;
import utils.TimerUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {5, 10, 15, 20, 25};

        InputGenerator.generate("input.txt", sizes);

        List<List<Task>> instances = InputReader.read("input.txt");

        List<Solution> backtrackingSolutions = new ArrayList<>();
        List<Solution> branchSolutions = new ArrayList<>();

        for (int i = 0; i < instances.size(); i++) {
            List<Task> tasks = instances.get(i);

            // Backtracking com medição de tempo
            TimerUtils.TimedResult backResult = TimerUtils.measureAverage(() -> {
                Backtracking bt = new Backtracking();
                return bt.solve(tasks);
            }, 15);
            System.out.printf("Instancia %d - Backtracking: %.3f ms%n", i + 1, backResult.getAverageTimeMs());
            backtrackingSolutions.add(backResult.getSolution());

            // Branch & Bound com medição de tempo
            TimerUtils.TimedResult bbResult = TimerUtils.measureAverage(() -> {
                BranchBound bb = new BranchBound();
                return bb.solve(tasks);
            }, 15);
            System.out.printf("Instancia %d - Branch & Bound: %.3f ms%n", i + 1, bbResult.getAverageTimeMs());
            branchSolutions.add(bbResult.getSolution());
        }

        ResultWriter.write("output.txt", backtrackingSolutions, branchSolutions);
    }
}