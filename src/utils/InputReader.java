package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class InputReader {

    private static final String FOLDER = "instances/";

    public static List<Task> read(String fileName) {

        List<Task> tasks = new ArrayList<>();

        String path = FOLDER + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            // lê o número de tarefas (primeira linha do arquivo)
            int numberOfTasks = Integer.parseInt(reader.readLine());

            // lê cada tarefa do arquivo
            for (int i = 0; i < numberOfTasks; i++) {

                String line = reader.readLine();

                // separa os valores da linha
                String[] parts = line.split(" ");

                int id = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);
                int deadline = Integer.parseInt(parts[2]);
                int value = Integer.parseInt(parts[3]);

                // cria o objeto Task
                Task task = new Task(id, processingTime, deadline, value);

                // adiciona na lista
                tasks.add(task);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + path);
            e.printStackTrace();
        }

        return tasks;
    }
}