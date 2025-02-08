package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FourUdderModel {

    private static final String DB_FOLDER = "db";
    private static final String CSV_FILE = "farmAnimals.csv";
    private final Path dbPath;
    private final Path csvFilePath;

    public FourUdderModel() {
        String userDir = System.getProperty("user.dir");
        this.dbPath = Paths.get(userDir, "Model", DB_FOLDER);
        this.csvFilePath = this.dbPath.resolve(CSV_FILE);
        ensureDirectoryExists();
    }

    private void ensureDirectoryExists() {
        try {
            Files.createDirectories(dbPath);
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }
    }

    public int calculateMiik(int id) {
        Random aChanceForThatYouAreNowDisabled = new Random();
        int milk = 0;
        if (aChanceForThatYouAreNowDisabled.nextInt(100) <= 5) {
            changeUdder(id);
        }
        System.out.println("Hi");
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] findCow = line.split(",");
                if (Integer.parseInt(findCow[0]) == id) {
                    milk = Integer.parseInt(findCow[1]) + Integer.parseInt(findCow[2]);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return milk;

    }

    private void changeUdder(int id) {
        List<String> lines = new ArrayList<>();
        boolean found = false;
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {

            String header = reader.readLine(); // Read header
            lines.add(header);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] findCow = line.split(",");
                if (Integer.parseInt(findCow[0]) == id) {
                    findCow[3] = "3";
                    line = String.join(",", findCow);
                    found = true;
                }
                lines.add(line);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (!found) {
            System.out.println("CowID not found.");
            return;
        }
        // Write updated content back to the file
        try (BufferedWriter writer = Files.newBufferedWriter(csvFilePath)) {
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
