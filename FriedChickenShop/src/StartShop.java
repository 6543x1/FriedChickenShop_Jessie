import java.time.LocalDate;
import java.util.Scanner;

public class StartShop {
    public static void main(String[] args) {
        System.out.println("Welcome admin,Please set your balance.（1100元足够全部进货）");
        Scanner in = new Scanner(System.in);
        int x= in.nextInt();
        West2FriedChickenRestaurant Shop = new West2FriedChickenRestaurant(x);
        //测试用，初始金额自定
        //菜单和进货预设好了
        Drinks[] testDrink = new Drinks[6];
        testDrink[0] = new Beers("BaiWei", 1024, LocalDate.now(), (float) 30.0);
        testDrink[1] = new Juice("FenDa", 3, LocalDate.now());
        LocalDate testDate = LocalDate.of(1982, 1, 1);
        testDrink[2] = new Beers("BaiWei", 10, testDate, (float)30);
        testDrink[3] = new Juice("FenDa", 3, testDate);
        testDrink[4] = new Beers("BaiWei", 10, LocalDate.now(), (float) 30.0);
        testDrink[5] = new Beers("BaiWei", 20, LocalDate.now(), (float) 60.0);
        //只有四瓶饮料可用，其中两瓶30度百威，1瓶芬达，1瓶60度百威
        for (int i = 0; i < 6; i++) {
            try {
                Shop.GetIn(testDrink[i]);//用个循环也算批量进货吧...?
            } catch (OverdraftBalanceException e) {
                System.out.println("Failed to get in "+testDrink[i].name);
            }
        }
        System.out.println("Stocking has finished,the shop is opening.Please waiting.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //会有几位客人开始点单,不模拟输入过程了。。。
        //虽然保存了本店所有的套餐，可是好像还是直接引用数组Menu里的元素比较方便。。。
        Shop.printMenu();
        while (true) {
            x = in.nextInt();
            if (x == -1) {
                System.out.println("白嫖！");
                break;
            }
            if (x == -2) Shop.printMenu();
            else {
                try {
                    Shop.SellMeal(x);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Wrong number!Please retry.");
                }
            }

        }

    }


}
