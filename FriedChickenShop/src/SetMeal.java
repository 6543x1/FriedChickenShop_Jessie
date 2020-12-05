public class SetMeal {

    private String name;
    private String Chickenname;
    private double price;
    private Drinks drink;

    public String getName() {
        return name;
    }

    public Drinks getDrink() {
        return drink;
    }
    public double getPrice(){
        return price;
    }
    public SetMeal(){

    }
    public SetMeal(String name,String Chickenname,double price,Drinks D){
        this.name=name;
        this.Chickenname=Chickenname;
        this.price=price;
        this.drink=D;
    }
    @Override
    public String toString(){
        return name+" "+Chickenname+" "+price+" "+drink;
    }
}
