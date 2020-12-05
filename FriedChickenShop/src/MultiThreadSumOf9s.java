import java.util.*;

public class MultiThreadSumOf9s
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        MyThread.x = scanner.nextInt();
        scanner.close();
        long Time_consumed = System.currentTimeMillis();
        MyThread[] threads = new MyThread[8];//启动线程分开计算
        long divide = 125000000;//每个小区间长度，总共十亿
        for (int i = 0; i < 8; i++)
        {
            threads[i] = new MyThread(divide * i, divide * (i + 1));
            //d_start+=divide*i;
            threads[i].start();
        }
        for (int i = 0; i < 8; i++)
        {
            try
            {
                threads[i].join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Ans is " + MyThread.ans);
        System.out.println("It took " + (System.currentTimeMillis() - Time_consumed) + "ms to finish.");
        //在本机（i7 8550u 4C8T）上测试，单线程耗时45s，分四个线程，耗时17s
        //分八个线程，耗时15s，分十万个线程耗时35s
        //分太多线程反而降低效率，当然我觉得这和输出了每个线程的结果有一点关系，如果省去这部分时间，十万线程耗时会更小一些
        //另外特说明intel的超线程还是能提高多线程效率的,E3神教的八个框框神秘加成不是说乱说的()
        //含9的一共327813115672186884，这是单线程跑出来的结果
    }
}

class MyThread extends Thread
{
    private long start;
    private long end;
    private long sum_here;
    public static long ans = 0;
    public static int x;
    public static final Object lock = new Object();

    public MyThread(long s, long e)
    {
        start = s;
        end = e;
        sum_here = 0;
    }

    private static boolean contain(long num, int x)
    {
        return String.valueOf(num).contains(String.valueOf(x));
    }

    @Override
    public void run()
    {
        for (long i = start; i < end; i++)
        {
            if (contain(i, x))
            {
                sum_here += i;
            }
        }
        synchronized (MyThread.lock)
        {
            MyThread.ans += sum_here;
        }
        System.out.printf("Thread: %d to %d finished;sum_here is %d;Sum:%d\n", start, end, sum_here, ans);
    }


}
