import java.util.ArrayList;
import java.util.List;

public class Store implements  Subject{
    List<Observer> observerList = new ArrayList<>();
    private int stock = 0;

    public Store(){}

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
      for(Observer observer : observerList){
          observer.update();
      }

    }

    public void setStock(int stock){
         this.stock = stock;
         if(this.stock > 0){
             notifyObservers();
         }
    }
}
