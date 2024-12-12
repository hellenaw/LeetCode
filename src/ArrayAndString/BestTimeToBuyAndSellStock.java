import java.util.Arrays;


public class BestTimeToBuyAndSellStock {


    public static int maxProfit(int[] prices) {;
        // int profit = 0;

        // for (int i = 0; i < prices.length-1 ; i++){
        //     for (int j = i + 1; j < prices.length ; j++){
        //         if(prices[i] - prices[j] < profit){
        //             profit = prices[i] - prices[j];
        //         }
        //     }
        // }
        // return Math.abs(profit);
        int bestBuyDay = 0;
        int bestSellDay = 0;
        int bestBuyDayIndex = 0;
 

        for(int i = 0; i < prices.length - 1; i++){
            if(prices[i] < bestBuyDay){
                bestBuyDay = prices[i];
            }
        }

        for(int i = 0; i < prices.length; i++){

        }


        


    }

    public static void main(String[] args) {
        int [] prices = {3,2,6,5,0,3};
        System.out.println(maxProfit(prices));
    }
}
