class Solution {
    public static int maxProfit(List<Integer> prices) {
        int minPriceSoFar = prices.get(0);
        int maxProfit = 0;
        for (int todaysPrice : prices) {
            if (todaysPrice - minPriceSoFar > maxProfit) {
                maxProfit = todaysPrice - minPriceSoFar;
            } else if (todaysPrice < minPriceSoFar) {
                minPriceSoFar = todaysPrice;
            }
        }
        return maxProfit;
    }
}
