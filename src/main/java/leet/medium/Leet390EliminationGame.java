package leet.medium;

public class Leet390EliminationGame {
    public int lastRemaining(int n) {
        if(n == 1) return 1;
        else if(n > 1 && n < 5) return 2;
        //找规律，一左一右作为一个过程，找到通项公式，递归求解。
        if(n/2 % 2 == 1){
            return 4 * lastRemaining((n/2-1)/2);
        }
        else{
            return lastRemaining(n/4) * 4 - 2;
        }
    }
}
