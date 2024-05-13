import java.util.Arrays;

public class LC_322_CoinChange {
    public static int coinChange(int[] coins, int amount) {

        int[] memoryTable = new int[amount+1];
        Arrays.fill(memoryTable, amount + 1);

        memoryTable[0] = 0;

        for(int i = 1; i< amount +1; i++) {
            for(int c : coins) {
                if (i -c >= 0) {
                    memoryTable[i] = Math.min(memoryTable[i], 1 + memoryTable[i - c]);
                }
            }
        }

        return memoryTable[amount] > amount ? -1 : memoryTable[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
