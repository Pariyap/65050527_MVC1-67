package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class farmModel {
    private int cowID;
    private int cowAgeYear;
    private int cowAgeMonth;
    private int udderAmounts;
    private Random random;

    private static final String DB_FOLDER = "db";
    private static final String CSV_FILE = "farmAnimals.csv";
    private final Path dbPath;
    private final Path csvFilePath;

    public farmModel() {
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

    public void commitAnimalsData() {
        try (BufferedWriter writer = Files.newBufferedWriter(csvFilePath, StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            if (Files.size(csvFilePath) == 0) {
                // Write the CSV header if the file is empty
                writer.write("CowID,Age(Y.),Age(M.),Udder");
                writer.newLine();
            }

            // Write the record
            // String line = String.join(",", singers.get(0), songName,
            // String.valueOf(duration), String.valueOf(score));
            String line = cowID + "," + cowAgeYear + "," + cowAgeMonth + "," + udderAmounts;

            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

    }

    public void randomAnimalsData() {
        for (int i = 0; i < 50; i++) {
            random = new Random();
            int lastSeven = random.nextInt(10000000);
            int firstDigit = random.nextInt(9) + 1;
            this.cowID = firstDigit * 10000000 + lastSeven;

            this.cowAgeYear = random.nextInt(11);
            this.cowAgeMonth = random.nextInt(13);
            this.udderAmounts = random.nextInt(2) + 3;

            commitAnimalsData();
        }
    }

    public farmModel readRecords(int idCowInSearch) {
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && Integer.parseInt(data[0]) == idCowInSearch) {
                    farmModel record = new farmModel();
                    record.setCowID(Integer.parseInt(data[0]));
                    record.setCowAgeYear(Integer.parseInt(data[1]));
                    record.setCowAgeMonth(Integer.parseInt(data[2]));
                    record.setUdderAmounts(Integer.parseInt(data[3]));
                    return record;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return null;
    }

    public int getCowID() {
        return cowID;
    }

    public void setCowID(int cowID) {
        this.cowID = cowID;
    }

    public int getCowAgeYear() {
        return cowAgeYear;
    }

    public void setCowAgeYear(int cowAgeYear) {
        this.cowAgeYear = cowAgeYear;
    }

    public int getCowAgeMonth() {
        return cowAgeMonth;
    }

    public void setCowAgeMonth(int cowAgeMonth) {
        this.cowAgeMonth = cowAgeMonth;
    }

    public int getUdderAmounts() {
        return udderAmounts;
    }

    public void setUdderAmounts(int udderAmounts) {
        this.udderAmounts = udderAmounts;
    }

}