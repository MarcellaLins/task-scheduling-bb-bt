import algorithms.Backtracking;
import algorithms.BranchBound;
import algorithms.Greedy;
import algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import model.Solution;
import model.Task;
import utils.InputGenerator;
import utils.InputReader;
import utils.ResultWriter;
import utils.TimerUtils;

public class Main {

    public static void main(String[] args) {

        int[] sizes = {5, 10, 15, 20, 25};

        // gera instâncias
        InputGenerator.generate("input.txt", sizes);

        // lê instâncias
        List<List<Task>> instances = InputReader.read("input.txt");

        List<Solution> backtrackingSolutions = new ArrayList<>();
        List<Solution> branchSolutions = new ArrayList<>();
        List<Solution> greedySolutions = new ArrayList<>();
        List<Solution> dpSolutions = new ArrayList<>();

        for (int i = 0; i < instances.size(); i++) {
            List<Task> tasks = instances.get(i);

            // Solução para obter os nós explorados
            Backtracking bt = new Backtracking();
            Solution btSolution = bt.solve(tasks);
            long btNodes = bt.getNodesExplored();

            // Backtracking com medição de tempo
            TimerUtils.TimedResult backResult = TimerUtils.measureAverage(() -> {
                Backtracking temp = new Backtracking();
                return temp.solve(tasks);
            }, 15);

            System.out.printf( "Instancia %d - Backtracking -> Tempo médio: %.3f ms | Nós explorados: %d%n",
                    i+1, backResult.getAverageTimeMs(), btNodes);

            backtrackingSolutions.add(btSolution);

            // Solução para obter os nós explorados
            BranchBound bb = new BranchBound();
            Solution bbSolution = bb.solve(tasks);
            long bbNodes = bb.getNodesExplored();

            // Branch & Bound com medição de tempo
            TimerUtils.TimedResult bbResult = TimerUtils.measureAverage(() -> {
                BranchBound temp = new BranchBound();
                return temp.solve(tasks);
            }, 15);

            System.out.printf("Instância %d - Branch & Bound -> Tempo médio: %.3f ms | Nós explorados: %d%n",
                    i+1, bbResult.getAverageTimeMs(), bbNodes);

            branchSolutions.add(bbSolution);

            // Solução Greddy (gulosa)
            Greedy greedy = new Greedy();
            Solution greedySolution = greedy.solve(tasks);

            // Greddy com medição de tempo
            TimerUtils.TimedResult greedyResult = TimerUtils.measureAverage(() -> {
                Greedy temp = new Greedy();
                return temp.solve(tasks);
            }, 15);

            System.out.printf(
                    "Instância %d - Greedy -> Tempo médio: %.3f ms%n",
                    i + 1, greedyResult.getAverageTimeMs()
            );

            greedySolutions.add(greedySolution);

            // Solução Dynamic Programming
            DynamicProgramming dp = new DynamicProgramming();
            Solution dpSolution = dp.solve(tasks);

            // Dynamic Programming com medição de tempo
            TimerUtils.TimedResult dpResult = TimerUtils.measureAverage(() -> {
                DynamicProgramming temp = new DynamicProgramming();
                return temp.solve(tasks);
            }, 15);

            System.out.printf(
                    "Instância %d - Dynamic Programming -> Tempo médio: %.3f ms%n",
                    i + 1, dpResult.getAverageTimeMs()
            );

            dpSolutions.add(dpSolution);

            System.out.println();
        }

        ResultWriter.write("output.txt", backtrackingSolutions, branchSolutions, greedySolutions, dpSolutions);
    }
}