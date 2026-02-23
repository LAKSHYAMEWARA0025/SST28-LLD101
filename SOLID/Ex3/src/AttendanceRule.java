public class AttendanceRule implements EligibilityRule{
    public RuleResult evaluate(StudentProfile s){
        boolean passed=true;
        String reason="";
        if(s.attendancePct<75){
            passed=false;
            reason="attendance below 75";
        }
        return new RuleResult(passed,reason);
    }
}
