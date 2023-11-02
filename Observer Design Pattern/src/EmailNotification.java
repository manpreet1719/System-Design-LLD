public class EmailNotification implements Observer{

    private String emailid;
    private Store store;

    public EmailNotification(String emailid,Store store){
        this.emailid = emailid;
        this.store = store;
    }
    @Override
    public void update() {
       sendMessage();
    }
    public void sendMessage(){
        System.out.println("Send Message to this Mail id "+ this.emailid);
    }
}
