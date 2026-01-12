package rn.picu.assignment.generator.io;

public class CSVReader {
    public List<Entry> loadNurseData(String inputFile) {
    List<Entry> entries = new ArrayList<>();
    if (!isInputFileAValidCSV(inputFile)) {
      return null;
    }

    try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
      String line;

      while ((line = br.readLine()) != null) {
        Entry entry = parseCSVLines(line);
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
