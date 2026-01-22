package rn.picu.assignment.generator.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class NurseCSVReader implements CSVReader {
  public List<Entry> loadData(String path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] nurses = line.splits(",");
        for (String nurse : nurses) {
          // create entry objects
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> parseCSVLines() {
    List<String> lines;
    return lines;
  }
}
