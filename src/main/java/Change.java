import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
** 1. Take the largest coin
*  2. Check if this is less than change
*  3. If it is, add it to the coin-set
*  4.change the value of change
*  5. repeat with new change
*
* *
* */
public class Change {
    private static int getChange(int m) {
        //write your code here
        int [] coins = new int[3];
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;

        int change = m;
        int remainingAmount = 0;
        int returnedChange = 0;
        int i = coins.length - 1, numOfCoins=0;
        while(returnedChange < m && i >= 0) {
            while(returnedChange + coins[i] <= m){
                //System.out.println("Change :" + change);
                returnedChange = returnedChange + coins[i];
                //System.out.println("Returned Change :" + returnedChange);
                numOfCoins++;
            }
            i--;
        }
        //System.out.println(numOfCoins);
        return numOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}
