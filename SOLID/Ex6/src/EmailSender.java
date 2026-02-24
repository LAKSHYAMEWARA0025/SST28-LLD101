public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    // @Override
    // public void send(Notification n) {
    //     // LSP smell: truncates silently, changing meaning
    //     String body = n.body;
    //     if (body.length() > 40) body = body.substring(0, 40);
    //     System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
    //     // audit.add("email sent");
    // }
    public String addmsg(){
        return "email sent";
    }
    // public void  validate() here there is nothing to validate
    public void doSend(String subject,String body,String email,String phone){
        if (body.length() > 40) body = body.substring(0, 40);
        System.out.println("EMAIL -> to=" + email + " subject=" + subject + " body=" + body);
    }
}
