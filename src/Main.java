import utils.InputGenerator;
import utils.InputReader;
import model.Task;

import java.util.List;

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

            System.out.println();
            instanceNumber++;
        }
    }
}