import java.nio.charset.StandardCharsets;

public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    //there are no set of rules and values over here, and hence any class extending it can implement their own behaviour violating LSP
    //hence we need to define some set of predefined tules and guideleines for it
    public ExportResult export(ExportRequest req){
        if(req==null){
            throw new IllegalArgumentException("Export Requests can not be null.");
        }
        String title=req.title==null?"":req.title;
        String body=req.body==null?"":req.body;
        validate(title,body);
        String formatted=format(title,body);
        return new ExportResult(typeOfFile(), formatted.getBytes(StandardCharsets.UTF_8));
    };
    protected void validate(String title,String body){};
    public abstract String format(String title,String body);
    public abstract String typeOfFile();
}
