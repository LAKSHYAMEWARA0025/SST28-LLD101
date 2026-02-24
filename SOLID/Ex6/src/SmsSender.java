public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    // @Override
    // public void send(Notification n) {
    //     // Ignores subject; base type doesn't clarify expectations (smell)
    //     System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
    //     audit.add("sms sent");
    // }
    public String addmsg(){
        return "sms sent";
    }
    public void doSend(String subject,String body,String email,String phone){
        System.out.println("SMS -> to=" + phone + " body=" + body);
    }
}
