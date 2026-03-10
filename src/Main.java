import utils.InputGenerator;
import utils.InputReader;
import model.Task;

import java.util.List;

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

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}