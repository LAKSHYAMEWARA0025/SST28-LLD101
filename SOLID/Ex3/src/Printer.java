public class Printer {

    private final ReportPrinter reportPrinter;

    public Printer(ReportPrinter reportPrinter) {
        this.reportPrinter = reportPrinter;
    }

    public void print(StudentProfile s, EligibilityEngineResult res) {
        reportPrinter.print(s, res);
    }
}
//the work of printer is just to print and nothing else