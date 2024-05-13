public class BestTimeToBuy {
    public static void main(String[] args) {
        int[] prices = new int[] {7,6,4,3,1};
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int price : prices) {
            if(minPrice > price) {
                minPrice = price;
            } else if (maxProfit < price - minPrice) {
                maxProfit = price - minPrice;
            }
        }
        System.out.println(maxProfit);
    }
}
