package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InputGenerator {

    private static final String FOLDER = "instances";

    public static void generate(String fileName, int numberOfTasks) {

        Random random = new Random();

        File directory = new File(FOLDER);

        // cria a pasta se não existir
        if (!directory.exists()) {
            directory.mkdirs();
            System.out.println("Pasta 'instances' criada.");
        }

        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(numberOfTasks + "\n");

            for (int i = 1; i <= numberOfTasks; i++) {

                int processingTime = random.nextInt(10) + 1; // gerar valores entre 1 e 10
                int deadline = random.nextInt(30) + 5; // gerar valores entre 5 e 34

                writer.write(i + " " + processingTime + " " + deadline + "\n");
            }

            System.out.println("Arquivo criado em: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo.");
            e.printStackTrace();
        }
    }
}