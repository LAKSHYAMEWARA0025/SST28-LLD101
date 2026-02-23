import java.util.LinkedHashMap;
import java.util.Map;

public class MenuService {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }
}
