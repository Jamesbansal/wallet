package wallet;
import java.util.*;
class DepositWithdrawal {
    private  int funds = 1000;
  
    public void deposit(int amount) {

        this.funds+=amount;

        System.out.println(amount + " has been deposited in your balance");

    }
    public void withdraw(int amount) {

        this.funds-=amount;

        System.out.println(amount+ " has been withdrawen from your balance");

    }
    public void getbalance() {

        System.out.println("Your current balance is : "+this.funds);

    }
    public void purchase(String item, int amount) {
        if(this.funds>=amount){
             this.funds-=amount;
             System.out.println("You bought "+item+" for "+amount+" rupees");
        }
        else{
            System.out.println("Not enough Balance");
        }        
    }

}

public class wallet{
    public static void main(String args[]) throws InterruptedException{

  

    DepositWithdrawal obj = new DepositWithdrawal();
    
    Thread one = new Thread(() -> {
        
//        obj.deposit(500);
//        obj.deposit(550);
//        obj.withdraw(750);
    });
    Thread two = new Thread(() -> {
      
//        obj.withdraw(750);
//        obj.deposit(600);
//        obj.deposit(500);
      
    });
    Thread three = new Thread(() -> {

       obj.withdraw(700);
       obj.deposit(600);
       obj.deposit(500);
       obj.getbalance();
       obj.purchase("Clothes", 100);
       obj.getbalance();

   });

    one.start();
    two.start();
    three.start();

    one.join();
    two.join();
    three.join();
  
 }
}