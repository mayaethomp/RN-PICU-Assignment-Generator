import java.util.List;

public abstract class CSVPrinterDecorator implements CSVPrinter{
    protected CSVPrinter decoratedPrinter;

    public CSVPrinterDecorator(CSVPrinter decoratedPrinter) {
        this.decoratedPrinter = decoratedPrinter;
    }

    @Override
    public void print(String filePath, List<List<String>> rows) {
        decoratedPrinter.print(filePath, rows);
    }
}
