package leet.easy;

public class Leet482LicenseKeyFormatting {
	public String licenseKeyFormatting(String S, int K) {
        char[] cs = S.toCharArray();
        StringBuilder res = new StringBuilder();
        int count = 0;
        for(int i=cs.length-1; i>=0; i--) {
        	if(cs[i] == '-') continue;
        	res.append(cs[i]);
        	count++;
        	if(count == K) {
        		res.append('-');
        		count = 0;
        	}
        }
        res.reverse();
        if(res.length() == 0) return res.toString();
        if(res.charAt(0) == '-') return res.substring(1).toUpperCase();
        return res.toString().toUpperCase();
    }
}
