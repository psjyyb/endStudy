package algorithm;

import java.util.Scanner;

public class Triangle {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j <= i; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }
    }
}
// 직각 삼각형 출력하기(별찍기 ㅋㅋ Scanner 오랜만) Lv.0s