package BonusAufgaben;


import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PseudoStockTicker{
    public static void main(String []args){
        PseudoStockTicker pseudoStockTicker = new PseudoStockTicker();
        pseudoStockTicker.generateStockTicker();
    }
    public void generateStockTicker(){
        ArrayList<Double> StockMark = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        generateStockTickerEntrys(scanner,random,StockMark);
        generateCSVFile(StockMark);

        System.out.println(StockMark);
    }
    private static ArrayList<Double> generateStockTickerEntrys(Scanner scanner,Random random,ArrayList<Double>StockMark){
        System.out.println("How many Entrys would you like to generate ?");
        int numberOfStocks = scanner.nextInt();
        for(int i=0;i<numberOfStocks;i++){
            double nextDouble= (random.nextGaussian())*20;
            StockMark.add(nextDouble);
            }
        return StockMark;
    }
    private static void generateCSVFile(ArrayList<Double> StockMark){
        String csvFile = "StockMarks.csv";
        try(FileWriter fileWriter = new FileWriter(csvFile)){
            //fileWriter.append("StockMark");

            for(Double value :StockMark ){
                fileWriter.append(Double.toString(value)).append("\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

