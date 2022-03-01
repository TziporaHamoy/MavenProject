import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        boolean b=true;
        int i=0;
        ArrayList<Double> convertHistory= new ArrayList<Double>();

        //Welcome screen
        System.out.println("Welcome to currency converter");
        while (b=true){
        System.out.println("Please choose an option (1/2)");
        System.out.println("1.Dollars to Shekels");
        System.out.println("2.Shekels to Dollars");
        //Validation
        try {
            Scanner s=new Scanner(System.in);
            int option=s.nextInt();
            if (option!=1 & option!=2){
                throw new Exception("Invalid input");
            }
            //input amount screen
        System.out.println("Please enter an amount to convert");
        Scanner scan = new Scanner(System.in);
        double input = scan.nextDouble();

        //Convert shekel to dollar
        if (option==1) {
            Coin usdValue = CoinFactory.getCoinInstance(Coins.USD);
            USD usd = new USD();
            double value = usd.calculate(input);
            System.out.println("The result is:"+value+" shekel");
            convertHistory.add(value);

        }
        //convert dollar to shekel
        else if (option==2){
            Coin ilsValue = CoinFactory.getCoinInstance(Coins.ILS);
            ILS ils = new ILS();
            double value = ils.calculate(input);
            //Result screen
            System.out.println("The result is:"+value+" dollars");
            convertHistory.add(value);
        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid input");
        }
        //Start over or exit
        System.out.println("Do you want to start over? enter y/n");
        Scanner yn= new Scanner(System.in);
        String answer= yn.next();
        if (answer.equalsIgnoreCase("y")){
            b=true;
            i++;
        }else if (answer.equalsIgnoreCase("n")){
            b=false;
            //End screen
            System.out.println("Thanks for using our currency converter");
            System.out.println("Your conversion history: "+convertHistory);
            //write result in file
            FileWriter writer = new FileWriter("results.txt");
            for(double str: convertHistory) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
            break;
        }
        }
      }
    }