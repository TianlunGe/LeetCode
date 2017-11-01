package leet.medium;

import java.util.Arrays;

public class Leet378KthSmallestElementInASortedMatrix {
	
	public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
		int[] array = new int[len * len];
		int index = 0;
		for(int[] inner : matrix){
			for(int temp : inner){
				array[index++] = temp;
			}
		}
		Arrays.sort(array);
		return array[k-1];
    }
}
