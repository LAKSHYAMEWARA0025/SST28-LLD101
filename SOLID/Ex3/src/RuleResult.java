public class RuleResult {
    boolean passed;
    String reason;
    public  RuleResult(boolean passed,String reason){
        this.passed=passed;
        this.reason=reason;
    }
    public boolean isPassed(){
        return passed;
    }
    public String reason(){
        return reason;
    }
}
//this class will judge on the basis of all the rules that we are going to create and will make a result of all of it
