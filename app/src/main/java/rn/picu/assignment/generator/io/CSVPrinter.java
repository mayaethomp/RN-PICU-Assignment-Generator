import java.util.List;

public interface CSVPrinter {
    void print(String filePath, List<List<String>> rows);
}
