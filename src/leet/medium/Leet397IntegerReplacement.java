package leet.medium;

public class Leet397IntegerReplacement {

    public static void main(String[] args) {
        Leet397IntegerReplacement c = new Leet397IntegerReplacement();
//        System.out.println(c.helper(11));
//        System.out.println(c.integerReplacement(11));
        for(int i=10; i< 100000; i++){
            if(c.integerReplacement(i) != c.helper(i)){
                System.out.println(i);
            }
        }
    }

    public int integerReplacement(int n) {
        int res = 0;
        if(n == Integer.MAX_VALUE) {
            n = n >> 1 + 1;
            res += 2;
        }
        while(n != 1){
            if(n == 3) {
                res += 2;
                break;
            }
            if(n % 2 == 0) n >>= 1;
            else{
                if((n+1) % 4 == 0) n += 1;
                else  n-=1;
            }
            res++;
        }
        return res;
    }

    private int helper(long n) {
        if(n == 1) return 0;
        if(n % 2 == 0) return 1 + helper(n >> 1);
        return 1 + Math.min(helper(n+1), helper(n-1));
    }

}
