import java.util.ArrayList;
import java.util.Arrays;

public class P322 {
    private int smallest = Integer.MAX_VALUE;
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        ArrayList<Integer> coinList = new ArrayList<>();
        dfs(coinList, coins, amount);
        return smallest != Integer.MAX_VALUE ? smallest : -1;
    }
    
    private boolean dfs(ArrayList coinList, int[] coins, int amount) {
        if (amount == 0) {
            return true;
        }
        else if (amount < 0) {
            System.out.println(coinList.size());
            return false;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            coinList.add(coin);
            if (dfs(coinList, coins, amount - coin)) {
                if (coinList.size() < smallest) {
                    smallest = coinList.size();
                }
            }
            coinList.remove(coinList.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        P322 problem = new P322();
        System.out.println(problem.coinChange(new int[] {1, 2, 5}, 100));
    }
}