package leet.medium;

public class Leet423ReconstructOriginalDigitsFromEnglish {
	public String originalDigits(String s) {
		int[] cs = new int[26];
        for(char c : s.toCharArray()){
        	cs[c - 'a']++;
        }
        int[] digs = new int[10];
        if(cs['z' - 'a'] > 0){
	        int zeros = cs['z' - 'a'];
	        digs[0] = zeros;
	        cs['z' - 'a'] = 0;
	        cs['e' - 'a'] -= zeros;
	        cs['r' - 'a'] -= zeros;
	        cs['o' - 'a'] -= zeros;
        }
        if(cs['w' - 'a'] > 0){
	        int twos = cs['w' - 'a'];
	        digs[2] = twos;
	        cs['w' - 'a'] = 0;
	        cs['t' - 'a'] -= twos;
	        cs['o' - 'a'] -= twos;
        }
        if(cs['x' - 'a'] > 0){
	        int sixs = cs['x' - 'a'];
	        digs[6] = sixs;
	        cs['x' - 'a'] = 0;
	        cs['s' - 'a'] -= sixs;
	        cs['i' - 'a'] -= sixs;
        }
        if(cs['g' - 'a'] > 0){
	        int eights = cs['g' - 'a'];
	        digs[8] = eights;
	        cs['g' - 'a'] = 0;
	        cs['e' - 'a'] -= eights;
	        cs['i' - 'a'] -= eights;
	        cs['h' - 'a'] -= eights;
	        cs['t' - 'a'] -= eights;
        }
        if(cs['s' - 'a'] > 0){
	        int sevens = cs['s' - 'a'];
	        digs[7] = sevens;
	        cs['s' - 'a'] = 0;
	        cs['e' - 'a'] -= sevens;
	        cs['v' - 'a'] -= sevens;
	        cs['e' - 'a'] -= sevens;
	        cs['n' - 'a'] -= sevens;
        }
        if(cs['v' - 'a'] > 0){
	        int fives = cs['v' - 'a'];
	        digs[5] = fives;
	        cs['v' - 'a'] = 0;
	        cs['f' - 'a'] -= fives;
	        cs['i' - 'a'] -= fives;
	        cs['e' - 'a'] -= fives;
        }
        if(cs['i' - 'a'] > 0){
	        int nines = cs['i' - 'a'];
	        digs[9] = nines;
	        cs['i' - 'a'] = 0;
	        cs['n' - 'a'] -= nines;
	        cs['n' - 'a'] -= nines;
	        cs['e' - 'a'] -= nines;
        }
        if(cs['f' - 'a'] > 0){
	        int fours = cs['f' - 'a'];
	        digs[4] = fours;
	        cs['f' - 'a'] = 0;
	        cs['o' - 'a'] -= fours;
	        cs['u' - 'a'] -= fours;
	        cs['r' - 'a'] -= fours;
        }
        if(cs['o' - 'a'] > 0){
	        int ones = cs['o' - 'a'];
	        digs[1] = ones;
	        cs['o' - 'a'] = 0;
	        cs['n' - 'a'] -= ones;
	        cs['e' - 'a'] -= ones;
        }
        if(cs['t' - 'a'] > 0){
	        int threes = cs['t' - 'a'];
	        digs[3] = threes;
	        cs['t' - 'a'] = 0;
	        cs['h' - 'a'] -= threes;
	        cs['r' - 'a'] -= threes;
	        cs['e' - 'a'] -= threes;
	        cs['e' - 'a'] -= threes;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<digs.length; i++){
        	for(int j=0; j<digs[i]; j++){
        		res.append(i);
        	}
        }
        return res.toString();
    }
}
