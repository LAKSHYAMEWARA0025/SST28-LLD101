import java.util.*;

public class OnboardingService {
    private final StudentRepository repo;
    private final Print printer;
    private final StudentParser parser;
    private final StudentValidator validator;

    public OnboardingService(StudentRepository repo,Print printer, StudentParser parser, StudentValidator validator) { 
    this.repo=repo;
    this.printer=printer;
    this.parser=parser;
    this.validator=validator;
}

    public void registerFromRawInput(String raw) {
        printer.printraw(raw);
        StudentData data=parser.parse(raw);
        List<String> errors=validator.validate(data);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
        }
        //id creation
        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, data.name, data.email, data.phone, data.program);
        //saving
        repo.save(rec);
        //printing
        System.out.println("OK: created student " + id);
        System.out.println("Saved. Total students: " + repo.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
