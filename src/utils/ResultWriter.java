package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Solution;
import model.Task;

public class ResultWriter {

    private static final String FOLDER = "results/";

    public static void write(String fileName,
                             List<Solution> backtrackingSolutions,
                             List<Solution> branchSolutions,
                             List<Solution> greedySolutions) {

        File directory = new File(FOLDER);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);

        try (FileWriter writer = new FileWriter(file)) {

            for (int i = 0; i < backtrackingSolutions.size(); i++) {

                writer.write("Instancia " + (i + 1) + "\n\n");

                // Backtracking
                Solution back = backtrackingSolutions.get(i);
                writer.write("Backtracking\n");
                writer.write(back.getValue() + "\n");
                writer.write(back.getTasks().size() + "\n");

                for (Task t : back.getTasks()) {
                    writer.write(t.getValue() + " "); // apenas value
                }

                writer.write("\n\n");

                // Branch and Bound
                Solution bb = branchSolutions.get(i);
                writer.write("BranchAndBound\n");
                writer.write(bb.getValue() + "\n");
                writer.write(bb.getTasks().size() + "\n");

                for (Task t : bb.getTasks()) {
                    writer.write(t.getValue() + " "); // apenas value
                }

                writer.write("\n\n");

                // Greedy
                Solution greedy = greedySolutions.get(i);
                writer.write("Greedy\n");
                writer.write(greedy.getValue() + "\n");
                writer.write(greedy.getTasks().size() + "\n");

                for (Task t : greedy.getTasks()) {
                    writer.write(t.getValue() + " ");
                }

                writer.write("\n\n");

                // Separador entre instâncias
                writer.write("------------------------------\n\n");
            }

            System.out.println("Resultado salvo em: " + file.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}