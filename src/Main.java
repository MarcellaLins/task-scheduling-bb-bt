import algorithms.Backtracking;
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

            Backtracking backtracking = new Backtracking();
            Solution solution = backtracking.solve(tasks);

            System.out.println("\nMelhor solução encontrada:");
            System.out.println("Lucro total: " + solution.getCost());
            System.out.println("Quantidade de tarefas: " + solution.getTasks().size());
            System.out.print("Tarefas escolhidas: ");

            for (Task task : solution.getTasks()) {
                System.out.print(task.getId() + " ");
            }

            System.out.println();
            System.out.println("Nós explorados: " + backtracking.getNodesExplored());
            System.out.println();

            instanceNumber++;
        }
    }
}