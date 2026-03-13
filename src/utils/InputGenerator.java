package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InputGenerator {

    private static final String FOLDER = "instances";

    public static void generate(String fileName, int[] taskSizes) {

        Random random = new Random();

        File directory = new File(FOLDER);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(taskSizes.length + "\n"); // número de instâncias

            for (int size : taskSizes) {

                writer.write(size + "\n");

                for (int i = 1; i <= size; i++) {

                    int processingTime = random.nextInt(10) + 1;
                    int deadline = random.nextInt(30) + 5;
                    int value = random.nextInt(100) + 1;

                    writer.write(i + " " + processingTime + " " + deadline + " " + value + "\n");
                }

                writer.write("\n"); // separa instâncias
            }

            System.out.println("Arquivo criado em: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
