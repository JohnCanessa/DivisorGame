import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 
 */
public class DivisorGame {


    /**
     * Recursive call.
     * Time: O(2^n) without memoization
     * 
     * Using memoization.
     * Time: O(n^2)  Space: O(n)
     */
    static private int divisorGameHelper(int n, int[] memo) {

        // **** player cannot make a move (base condition) ****
        if (n <= 1) return 0;

        // **** check memo (if needed) ****
        if (memo[n] != -1) return memo[n];

        // **** try all factors ****
        for (int x = 1; x <= (n / 2); x++) {

            // **** check if x is a factor of n ****
            if (n % x == 0) {

                // **** recursive call (update memo) ****
                memo[n - 1] = divisorGameHelper(n - 1, memo);

                // **** check if next player cannot make a move ****
                if (memo[n - 1] == 0)
                    return 1;               // game won
            }
        }

        // **** game lost *****
        return 0;
    }


    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     * Initially, there is a number n on the chalkboard.
     * On each player's turn, that player makes a move consisting of:
     * 
     * o Choosing any x with 0 < x < n and n % x == 0.
     * o Replacing the number n on the chalkboard with n - x.
     * 
     * Also, if a player cannot make a move, they lose the game.
     * 
     * Return true if and only if Alice wins the game, 
     * assuming both players play optimally.
     * 
     * Runtime: 6 ms, faster than 8.35% of Java online submissions.
     * Memory Usage: 35.6 MB, less than 66.11% of Java online submissions.
     */
    static boolean divisorGame(int n) {

        // **** initialization ****
        int memo[] = new int[n + 1];
        Arrays.fill(memo, -1);

        // **** make recursive call  ****
        boolean ans = divisorGameHelper(n, memo) == 1 ? true : false;

        // ???? ????
        System.out.println("<<< memo: " + Arrays.toString(memo));

        // **** return answer ****
        return ans;
    }


    /**
     * Alice and Bob take turns playing a game, with Alice starting first.
     * Initially, there is a number n on the chalkboard.
     * On each player's turn, that player makes a move consisting of:
     * 
     * o Choosing any x with 0 < x < n and n % x == 0.
     * o Replacing the number n on the chalkboard with n - x.
     * 
     * Also, if a player cannot make a move, they lose the game.
     * 
     * Return true if and only if Alice wins the game, 
     * assuming both players play optimally.
     * 
     * n: odd -> Alice lose
     * n: even -> Alice win
     * 
     * Time: O(n) - Space: O(1)
     * 
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 35.6 MB, less than 77.92% of Java online submissions.
     * 
     * Time: O(1)  Space: O(1)
     */
    static boolean divisorGame1(int n) {
        return (n % 2 == 0);
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** initialization ****
        long start  = 0;
        long end    = 0;

        // **** open buffere reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read n ****
        int n = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();

        // **** check if n is out of range ****
        if (n < 1 || n > 1000) {
            System.out.println("main <<< unexpected n: " + n);
            System.exit(-1);
        }

        // **** play game and display winner ****
        start = System.currentTimeMillis();
        System.out.println("main <<< n: " + n + " divisorGame: " + (divisorGame(n) ? "Alice" : "Bob"));
        end = System.currentTimeMillis();
        System.out.println("main <<< execution time: " + (end - start) + " ms");

        // **** play game and display winner ****
        start = System.currentTimeMillis();
        System.out.println("main <<< n: " + n + " divisorGame1: " + (divisorGame1(n) ? "Alice" : "Bob"));
        end = System.currentTimeMillis();
        System.out.println("main <<< execution time: " + (end - start) + " ms");
    }
}