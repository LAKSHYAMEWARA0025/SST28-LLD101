public class CgrRule implements EligibilityRule{
    public RuleResult evaluate(StudentProfile s){
        String reason="";
        boolean passed=true;
        if (s.cgr < 8.0) {
            passed = false;
            reason="CGR below 8.0";
        }
        return new RuleResult(passed,reason);
    }
}
