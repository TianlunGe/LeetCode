package leet.hard;

import org.junit.Test;

public class Leet135Candy {
	
	/*
	 * 解体思路：找到rating数组中局部的递增或递减序列；对于局部递增的序列，如[1, 2, 5, 8],对应的candy数量从1开始每次加1，对应数量为[1, 2, 3, 4];
	 * 对于局部递减序列，则相反地从rating最小的地方对应1开始，想前加1递增；
	 * 对于[1, 2, 4, 3, 2, 1]这种先递增后递减，先找到[1, 2, 4]递增对应candy[1, 2, 3],再找到[4, 3, 2, 1]递减对应candy[4, 3, 2, 1]，对于rating4这个
	 * 递增递减交叉的位置，应该选两个中较大的一个。
	 * */
	
	public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int index;
        for(int i=0; i<candies.length-1; ){
        	index = i;
        	//如果是接下去是局部递增序列
        	if(ratings[i+1] > ratings[i]){
        		//找到i直到不是递增
	        	while(i < candies.length-1 && ratings[i+1] > ratings[i]){
	        		i++;
	        	}
	        	//ratings中最小位置对应的candies设为1
	        	candies[index] = 1;
	        	//接下去的递增序列中candies对应每次加1
	        	for(int j=index+1; j<i; j++){
	        		candies[j] = candies[j-1] + 1;
	        	}
	        	//最后的一个位置进行判断，选择较大的数
	        	candies[i] = Math.max(candies[i-1] + 1, candies[i]);
        	}
        	//接下去是局部递减序列
        	else if(ratings[i+1] < ratings[i]){
	        	while(i < candies.length-1 && ratings[i+1] < ratings[i]){
	        		i++;
	        	}
	        	candies[i] = 1;
	        	for(int j=i-1; j>index; j--){
	        		candies[j] = candies[j+1] + 1;
	        	}
	        	candies[index] = Math.max(candies[index+1] + 1, candies[index]);
        	}
        	//是相等序列，将其设为1，因为题目没有对ratings相等的邻近位置做出要求。
        	else{
        		candies[++i] = 1;
        	}
        }
        int res = 0;
        for(int i=0; i<candies.length; i++){
        	res += candies[i];
        }
        return res;
    }
}
