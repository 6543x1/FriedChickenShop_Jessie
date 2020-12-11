public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(double money){
        System.out.println("Error: balance is not Enough.");
        System.out.println("You have to add "+money+".");
        //未成功购买的原料信息在catch块中给出，比如主函数里catch到就在主函数里直接输出啥没买成功就好了。。。
        //因为再写个参数是很麻烦的事情（瘫
    }
}
