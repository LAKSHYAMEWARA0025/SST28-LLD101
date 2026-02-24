public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public final void send(Notification n){ //after writing final, no subclass can overwrite it
        String body=n.body==null?"":n.body;
        String email=n.email==null?"":n.email;
        String subject=n.subject==null?"":n.subject;
        String phone=n.phone==null?null:n.phone;
        validate(subject,body,email,phone);
        doSend(subject,body,email,phone);
        audit.add(addmsg());
    };
    protected void validate(String subject,String body,String email,String phone){};
    protected abstract void doSend(String subject,String body,String email,String phone);
    public abstract String addmsg();
}
//we need to implement rules over here 