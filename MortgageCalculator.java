import java.text.NumberFormat;
import java.util.Currency;
import java.util.Scanner;

public class MortgageCalculator{
    public static void main(String[] args) {
        //Making a mortgage calculator
        System.out.println("This is a mortgage calculator. ");
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        String principle = "";
        while (true) {
            System.out.print("Please enter the principle amount($1K-$1M): ");
            amount = scanner.nextInt();
            principle  = NumberFormat.getCurrencyInstance().format(amount);
            if (amount>=1000 && amount<=1_000_000)
                break;
            System.out.println("Enter a number between $1000 and $1000000");
        } 
        float rate = 0;
        while (true) {
            System.out.print("Please enter the annual interest rate: ");
            rate = scanner.nextFloat();
            if (rate >=1 && rate<=30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }
        byte years = 0;
        while (true) {
            System.out.print("Please enter the time period: ");
            years = scanner.nextByte();
            if (years >=1 && years <=30)
                break;
            System.out.println("Enter a time period between 1 and 30 years");
        }
        
        System.out.println("Confirming that the principle amount is " + principle + " interest rate is " + rate + " and time period in years is " + years + ".");
        scanner.close();
        // Changing the rate from annual to monthly
        int payments = years*12;
        // Inserting the values into the calculator
        /*Formula for calculating mortgage = amount*monthlyRate(1+monthlyRate)^payments/(1+monthlyRate)^payments-1 */
        double value = (double)1+(rate/(12*100));
        double part = Math.pow(value, payments);
        double mortgage = amount*((rate/(12*100))*(part))/part-1;
        System.out.println("Your monthly mortgage is " + NumberFormat.getCurrencyInstance().format(mortgage));
        System.out.println("Thank you for using the calculator!!:)");


    }
}