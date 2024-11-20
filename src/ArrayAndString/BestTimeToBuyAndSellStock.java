public class BestTimeToBuyAndSellStock {


    public static int maxProfit(int[] prices) {;
        int profit = 0;

        for (int i = 0; i < prices.length-1 ; i++){
            for (int j = i + 1; j < prices.length ; j++){
                if(prices[i] - prices[j] < profit){
                    profit = prices[i] - prices[j];
                }
            }
        }
        return Math.abs(profit);
    }

    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
