package rn.picu.assignment.generator.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<NurseEntry> loadData(String inputFile) { // TODO will change to a generic
    List<NurseEntry> entries = new ArrayList<>();
    if (!isInputFileAValidCSV(inputFile)) {
      return null;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
      String line;

      while ((line = reader.readLine()) != null) {
        NurseEntry entry = parseCSVLines(line);  // TODO need method
        if (entry == null) {
          return null;
        } else {
          entries.add(entry);
        }
      }

    } catch (IOException e) {
      System.err.println("Error: Unable to load file: " + e.getMessage());
      return null;
    }

    return entries;
  }

  private boolean isInputFileAValidCSV(String inputFile) {
    if (!inputFile.endsWith(".csv")) {
      System.err.println("Error: Input path must have '.csv' extension");
      return false;
    }

    File file = new File(inputFile);
    if (!file.exists()) {
      System.err.println("Error: File not found at " + inputFile);
      return false;
    }

    if (file.length() == 0) {
      System.err.println("Error: File entry is missing fields.");
      return false;
    }
    return true;
  }
  
}
