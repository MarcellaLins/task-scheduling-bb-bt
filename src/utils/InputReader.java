package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class InputReader {

    private static final String FOLDER = "instances/";

    public static List<List<Task>> read(String fileName) {

        List<List<Task>> instances = new ArrayList<>();

        String path = FOLDER + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            int numberOfInstances = Integer.parseInt(reader.readLine());

            for (int k = 0; k < numberOfInstances; k++) {

            int numberOfTasks = Integer.parseInt(reader.readLine());

            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < numberOfTasks; i++) {

                String line = reader.readLine();
                String[] parts = line.split(" ");

                int id = Integer.parseInt(parts[0]);
                int processingTime = Integer.parseInt(parts[1]);
                int deadline = Integer.parseInt(parts[2]);
                int value = Integer.parseInt(parts[3]);

                Task task = new Task(id, processingTime, deadline, value);
                tasks.add(task);
            }

            instances.add(tasks);

            reader.readLine(); // pula linha em branco
        }


        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + path);
            e.printStackTrace();
        }

        return instances;
    }
}