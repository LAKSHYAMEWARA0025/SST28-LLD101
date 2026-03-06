public class EvaluationPipeline {
    // DIP violation: high-level module constructs concretes directly
    private Plagarism pc;
    private Rub rubric;
    private Grader grader;
    private Writer writer;
    public EvaluationPipeline(Plagarism pc,Rub rubric,Grader grader,Writer writer){
        this.pc=pc;
        this.rubric=rubric;
        this.grader=grader;
        this.writer=writer;
    }
    public void evaluate(Submission sub) {
        // rubric = ;
        // pc = new PlagiarismChecker();
        // grader = new CodeGrader();
        // writer = new ReportWriter();

        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
//we need to create interfaces and instead of passing objects directly we need to pass their refrences!!