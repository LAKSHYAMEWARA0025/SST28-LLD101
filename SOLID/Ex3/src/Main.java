import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        //here we need to add list of Eligibility rules of all the four rules defined
        List<EligibilityRule> rules=Arrays.asList(
            new CgrRule(),
            new DisciplinaryRule(),
            new AttendanceRule(),
            new CreditRule()
        );
        Printer p=new Printer(new ReportPrinter());
        FakeEligibilityStore store=new FakeEligibilityStore();
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityEngine engine = new EligibilityEngine(rules);
        // engine.runAndPrint(s);
        // engine.evaluate(s);
        EligibilityEngineResult result=engine.evaluate(s);
        p.print(s,result);
        store.save(s.rollNo,result.status);
    }
}
