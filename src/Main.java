import algorithms.Backtracking;
import algorithms.BranchBound;
import model.Solution;
import model.Task;
import utils.InputGenerator;
import utils.InputReader;
import utils.ResultWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {5, 10, 15, 20, 25};

        InputGenerator.generate("input.txt", sizes);

        List<List<Task>> instances = InputReader.read("input.txt");

        List<Solution> backtrackingSolutions = new ArrayList<>();
        List<Solution> branchSolutions = new ArrayList<>();

        for (List<Task> tasks : instances) {

            Backtracking backtracking = new Backtracking();
            Solution backSolution = backtracking.solve(tasks);

            BranchBound branchBound = new BranchBound();
            Solution branchSolution = branchBound.solve(tasks);

            backtrackingSolutions.add(backSolution);
            branchSolutions.add(branchSolution);
        }

        ResultWriter.write("output.txt", backtrackingSolutions, branchSolutions);
    }
}