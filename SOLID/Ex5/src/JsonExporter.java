// import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    // @Override
    // public ExportResult export(ExportRequest req) {
    //     // inconsistent handling (surprise)
    //     if (req == null) return new ExportResult("application/json", new byte[0]);
    //     String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
    //     return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    // }

    public String typeOfFile(){
        return "application/json";
    }
    public String format(String title,String body){
        return "{\"title\":\"" + escape(title) + "\",\"body\":\"" + escape(body) + "\"}";
    }
    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
