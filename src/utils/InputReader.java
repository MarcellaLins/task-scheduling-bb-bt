package utils;

import model.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public static List<List<Task>> read(String fileName) {
        List<List<Task>> instances = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("instances/" + fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // ignora linhas em branco

                int size = Integer.parseInt(line); // número de tarefas da instância
                List<Task> tasks = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    line = br.readLine().trim();
                    String[] parts = line.split("\\s+"); // divide por espaços

                    int processingTime = Integer.parseInt(parts[0]);
                    int deadline = Integer.parseInt(parts[1]);
                    int value = Integer.parseInt(parts[2]);

                    tasks.add(new Task(processingTime, deadline, value));
                }

                instances.add(tasks);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return instances;
    }
}