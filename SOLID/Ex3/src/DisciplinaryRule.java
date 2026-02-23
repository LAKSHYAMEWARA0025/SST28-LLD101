public class DisciplinaryRule implements EligibilityRule{
    public RuleResult evaluate(StudentProfile s){
        String reason="";
        boolean passed=true;
        if(s.disciplinaryFlag != LegacyFlags.NONE){
            passed=false;
            reason="disciplinary flag present";
        }
        return new RuleResult(passed,reason);
    }
}

//all the rules are made