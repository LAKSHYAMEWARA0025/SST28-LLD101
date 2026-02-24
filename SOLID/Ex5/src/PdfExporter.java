// import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    // @Override
    // public ExportResult export(ExportRequest req) {
    //     // LSP violation: tightens precondition arbitrarily
    //     if (req.body != null && req.body.length() > 20) {
    //         throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
    //     }
    //     String fakePdf = "PDF(" + req.title + "):" + req.body;
    //     return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    // }
    public String typeOfFile(){
        return "application/pdf";
    }
    public String format(String title,String body){
        return "PDF(" + title + "):" + body;
    }
    protected void validate(String title,String body){
        if(body.length()>20){
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }
    }
}
