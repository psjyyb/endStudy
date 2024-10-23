package algorithm;

public class CutArray {
	public static void main(String[] args) {
		int qq [] = {1,2,3,4,5};
		System.out.println(solution(qq,1,3));
	}
	public static int[] solution(int[] numbers, int num1, int num2) {
		int[] answer = new int[num2 - num1 + 1];
		int cnt = 0;
		System.out.println(num1+" "+num2);
		for(int i = num1; i <= num2; i++) {
			answer[cnt] = numbers[i]; 
			cnt ++;
		}
	    return answer;
	}
}
// 배열자르기 Lv.0