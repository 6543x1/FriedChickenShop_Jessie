public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException(double money){
        System.out.println("Error: balance is not Enough.");
        System.out.println("You have to add "+money+".");
    }
}
