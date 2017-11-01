package leet.medium;

import java.util.Random;

public class Leet384ShuffleAnArray {
	public Leet384ShuffleAnArray(int[] nums) {
        ori = nums;
        sh = nums.clone();
        rnd = new Random();
        size = ori.length;
    }
    
	int[] ori;
	int[] sh;
	Random rnd;
	int size;
	
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // Shuffle array
        for (int i=size; i>1; i--){
            swap(sh, i-1, rnd.nextInt(i));
        }
        return sh;
    }
    
    private void swap(int[] sh, int i, int nextInt) {
    	int temp = sh[i];
    	sh[i] = sh[nextInt];
    	sh[nextInt] = temp;
	}

}
