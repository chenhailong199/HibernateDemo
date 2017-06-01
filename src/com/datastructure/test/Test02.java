package com.datastructure.test;

public class Test02 {
	
	public static void main(String[] args) {
		//sort();
		sort2();
	}
	
	/**
	 * @param args
	 * 直接插入排序
	 */
	public static void sort(){
		int [] data = {23,45,16,7,42};
		for (int i=1; i<data.length; i++){
			int currentData = data[i];
			int temp = i;
			while (temp>0 && data[temp-1]>currentData){
				//前一位大于后一位,前一位元素赋值给后一位
				data[temp] = data[temp-1];
				temp --;
			}
			data[temp] = currentData; //交换数据
		}
		for (int x:data){
			System.out.println(x);
		}
	}
	
	/**
	 * 折半插入排序
	 */
	public static void sort2(){
		int[] data = {7,16,23,43,45};
		int len = data.length;
		int insertData = 44;
		int low = 0;
		int hight = len-2;
		while (low < hight){
			int middle = (low+hight)/2;
			if (insertData < data[middle]){
				hight = middle-1;
			} else {
				low = middle +1;
			}
		}
		for (int j=len-1; j>hight+1; j--){
			data[j] = data[j-1];
		}
		data[hight+1] = insertData;
		for (int x:data){
			System.out.println(x);
		}
	}
}
