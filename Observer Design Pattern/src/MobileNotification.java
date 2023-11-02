public class MobileNotification implements  Observer{
    private String phonenumber;
    private Store store;
   public MobileNotification(String phonenumber, Store store){
       this.phonenumber = phonenumber;
       this.store = store;
   }
    @Override
    public void update() {
         sendMessage();
    }

    void sendMessage(){
      System.out.println("send messgae to this phonenumber stock is avaliable " + this.phonenumber);
    }
}
