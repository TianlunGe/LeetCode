package leet.medium;

public class Leet402RemoveKDigits {

    public static void main(String[] args) {
        Leet402RemoveKDigits test = new Leet402RemoveKDigits();
        test.removeKdigits("10200", 1);
    }

    public String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        StringBuilder sb = new StringBuilder(num);
        int cur = 0;
        while(k-- > 0){
            cur = findDescStart(sb, --cur);
            sb.deleteCharAt(cur);
        }
        return removeLeadingZeros(sb.toString());
    }

    private String removeLeadingZeros(String s){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != '0') return s.substring(i);
        }
        return "0";
    }

    private int findDescStart(StringBuilder sb, int start){
        if(start <= 0) start = 0;
        for(; start<sb.length()-1; start++){
            if(sb.charAt(start+1) < sb.charAt(start)) return start;
        }
        return start;
    }

}
