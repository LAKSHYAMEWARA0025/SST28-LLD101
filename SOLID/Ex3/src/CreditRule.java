public class CreditRule implements EligibilityRule{
    public RuleResult evaluate(StudentProfile s){
        String reason="";
        boolean passed=true;
        if(s.earnedCredits < 20){
            passed=false;
            reason="credits below 20";
        }
        return new RuleResult(passed,reason);
    }
}
