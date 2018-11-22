package Brainteaser;

/**
 *
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 *
 * @author Mr.Bao
 * @create 2018-10-17-14:42
 * @since 1.0.0
 */
public class No292NimGame {

    public boolean canWinNim(int n) {
        if(n%4!=0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        No292NimGame game = new No292NimGame();
        System.out.println(game.canWinNim(4));
    }
}
