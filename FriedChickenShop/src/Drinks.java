import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Drinks {
    protected String name;
    protected double price;
    protected LocalDate produceData;
    protected int eDay;
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public Drinks(String name,double price,LocalDate L,int e){
        this.name=name;
        this.price=price;
        produceData=L;
        eDay=e;
    }
    public Drinks(){}
    boolean expired(){
        long now= ChronoUnit.DAYS.between(produceData,LocalDate.now());
        if(now<=eDay){
            return true;//还没过期
        }
        return false;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Drinks)){
            return false;
        }
        else{
            return ((Drinks) obj).name.equals(this.name);
        }
    }
}
