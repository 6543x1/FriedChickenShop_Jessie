import java.time.LocalDate;

public class Juice extends Drinks{
    public Juice(String name, double price, LocalDate L){
        super(name,price,L,2);
    }
    public Juice(String m){
        name=m;
    }
}
