public class Main {
    public static void main(String[] args) {

       Store store = new Store();

       MobileNotification mobileNotification = new MobileNotification("12345678",store);
       EmailNotification emailNotification = new EmailNotification("email123@gmail.com",store);

       store.addObserver(mobileNotification);
       store.addObserver(emailNotification);
       store.setStock(2);

       store.removeObserver(emailNotification);

       store.setStock(0);

       store.setStock(5);

    }
}