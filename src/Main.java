import algorithms.Backtracking;
import java.util.List;
import model.Solution;
import model.Task;
import utils.InputGenerator;
import utils.InputReader;

public class Main {

    public static void main(String[] args) {

        // gera arquivos de entrada
        InputGenerator.generate("input5.txt", 5);
        InputGenerator.generate("input10.txt", 10);
        InputGenerator.generate("input15.txt", 15);
        InputGenerator.generate("input20.txt", 20);
        InputGenerator.generate("input25.txt", 25);

        // lê uma instância para testar
        List<Task> tasks = InputReader.read("input10.txt");

        // imprime as tarefas lidas
        System.out.println("Tarefas lidas do arquivo:");

<<<<<<< Updated upstream
        for (Task task : tasks) {
            System.out.println(task);
=======
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
>>>>>>> Stashed changes
        }
    }
}