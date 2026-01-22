package rn.picu.assignment.generator.io;

import java.util.List;

public interface CSVReader {
    List<Entry> loadData(String filename);
    List<String> parseCSVLines();
  
}
