import algorithms.Backtracking;
import algorithms.BranchBound;
import java.util.List;
import model.Solution;
import model.Task;
import utils.InputGenerator;
import utils.InputReader;

public class Main {

    public static void main(String[] args) {

        // gera arquivo de entrada com várias instâncias
        int[] sizes = {5, 10, 15, 20, 25};
        InputGenerator.generate("input.txt", sizes);

        // lê todas as instâncias
        List<List<Task>> instances = InputReader.read("input.txt");

        System.out.println("Instâncias lidas do arquivo:\n");

        int instanceNumber = 1;

        for (List<Task> tasks : instances) {

            System.out.println("Instância " + instanceNumber);

            for (Task task : tasks) {
                System.out.println(task);
            }

            // Backtracking:

            Backtracking backtracking = new Backtracking();
            Solution backtrackingSolution = backtracking.solve(tasks);

            System.out.println("\nBacktracking:");
            System.out.println("Lucro total: " + backtrackingSolution.getCost());
            System.out.println("Quantidade de tarefas: " + backtrackingSolution.getTasks().size());
            System.out.print("Tarefas escolhidas: ");

            for (Task task : backtrackingSolution.getTasks()) {
                System.out.print(task.getId() + " ");
            }

            System.out.println();
            System.out.println("Nós explorados: " + backtracking.getNodesExplored());
            System.out.println();
            

            // BranchAndBounda:

            BranchBound branchAndBound = new BranchBound();
            Solution branchSolution = branchAndBound.solve(tasks);

            System.out.println("Branch and Bound:");
            System.out.println("Lucro total: " + branchSolution.getCost());
            System.out.println("Quantidade de tarefas: " + branchSolution.getTasks().size());
            System.out.print("Tarefas escolhidas: ");

            for (Task task : branchSolution.getTasks()) {
                System.out.print(task.getId() + " ");
            }

            System.out.println();
            System.out.println("Nós explorados: " + branchAndBound.getNodesExplored());
            System.out.println("\n-----------------------------------------\n");

            instanceNumber++;
        }
    }
}