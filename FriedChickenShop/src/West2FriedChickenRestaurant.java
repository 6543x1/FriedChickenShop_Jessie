import java.util.ArrayList;
import java.util.Collections;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{
    private double balance;
    private ArrayList<Beers> AllBeers=new ArrayList<>();
    private ArrayList<Juice> AllJuice=new ArrayList<>();
    private ArrayList<SetMeal> Menu=new ArrayList<>();
    //private当然是为了隐藏过期饮料的罪证（
    //为什么选这个List呢？因为加入和删除比较方便，对于这个项目功能够用，以及。。。懒
    public West2FriedChickenRestaurant(double b){
        balance=b;
        //静态代码，初始化套餐
        SetMeal[] M = new SetMeal[3];
        M[0] = new SetMeal("BeersFriedChicken", "CommonFriedChicken", 20.0, new Beers("BaiWei", 30));
        M[1] = new SetMeal("JuiceFriedChicken", "CommonFriedChicken", 13.0, new Juice("FenDa"));
        M[2] = new SetMeal("BeersFriedChicken(60 degree)", "SpecialFriedChicken", 30, new Beers("BaiWei", 60));
        Collections.addAll(Menu, M);
    }
    public void use(Beers B){
        AllBeers.removeIf(i -> i.expired());//使用前清空过期库存
        if(AllBeers.contains(B)){
            AllBeers.remove(B);
        }
        else{
            throw new IngredientSortOutException(B);
        }
    }
    public void use(Juice B){
        AllJuice.removeIf(i -> i.expired());
        if(AllJuice.contains(B)){
            AllJuice.remove(B);
        }
        else{
            throw new IngredientSortOutException(B);
        }
    }
    //public方便员工偷喝饮料（
    @Override
    public void SellMeal(int s) {
        Drinks D= Menu.get(s).getDrink();
        try{
            if(D instanceof Beers)
            use((Beers)D);
            else if(D instanceof Juice){
                use((Juice)D);
                //我觉得use用多态更合适
            }
            System.out.println("Your "+ Menu.get(s).getName()+ " Done.");
        }catch (IngredientSortOutException e){
            System.out.println("Please choose other meals.");
        }
    }
    @Override
    public void GetIn(Drinks D) {
        //我觉得进货的时候就要先判断原料是否过期（黑心批发商
        if(D instanceof Beers){
            if(balance-D.getPrice()>=0){
            AllBeers.add((Beers) D);
            balance-=D.getPrice();
            }
            else{
                throw new OverdraftBalanceException(D.getPrice()-balance);
            }
        }
        else if(D instanceof Juice){
            if(balance-D.getPrice()>=0){
                AllJuice.add((Juice) D);
                balance-=D.getPrice();
            }
            else{
                throw new OverdraftBalanceException(D.getPrice()-balance);
            }
        }
    }
    public void printMenu() {
        System.out.print("Menu:     Name:     Price:\n");
        int i = 0;
        for (SetMeal x : Menu) {//
            System.out.println(i + " " + x.getName() + " " + x.getPrice());
            i++;
        }
        System.out.println("Enter the num you want order,my customer.Enter -1 to quit shop.");
        System.out.println("Enter -2 to show Menu again");
    }
}
