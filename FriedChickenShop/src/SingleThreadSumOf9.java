import java.util.Scanner;
public class SingleThreadSumOf9 {
    public static void main(String[] args) {
        long ans = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        long Time_consume=System.currentTimeMillis();
        for (long i = 1; i < 1000000000; i++) {
            if (contain(i, x)) ans += i;
        }
        System.out.println(ans);
        System.out.println((System.currentTimeMillis()-Time_consume));
        //含9的一共327813115672186884，大约耗时45s
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}
