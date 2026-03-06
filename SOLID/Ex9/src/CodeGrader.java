public class CodeGrader implements Grader{
    public int grade(Submission s, Rub r) {
        // fake scoring (but deterministic)
        int base = Math.min(80, 50 + s.code.length() % 40);
        return base + r.getBonus();
    }
}
