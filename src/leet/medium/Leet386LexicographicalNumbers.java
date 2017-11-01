package leet.medium;

import java.util.ArrayList;
import java.util.List;

public class Leet386LexicographicalNumbers {
	/*public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
        	list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				return s1.compareTo(s2);
			}
		});
        return list;
    }*/
	public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
