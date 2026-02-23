import java.util.*;


public class Print {
    public void printraw(String raw){
         System.out.println("INPUT: " + raw);
    }
    public void printErrors(List<String> errors){
        System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
    }

    public void printSuccess(StudentRecord rec,int count){
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + count);
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
