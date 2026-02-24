// import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    // @Override
    // public ExportResult export(ExportRequest req) {
    //     // LSP issue: changes meaning by lossy conversion
    //     String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
    //     String csv = "title,body\n" + req.title + "," + body + "\n";
    //     return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    // }
    public String typeOfFile(){
        return "text/csv";
    }
    public String format(String title,String body){
        return "title,body\n" + title + "," + body + "\n";
    }
}
