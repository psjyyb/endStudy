package algorithm;

public class Root {
	public static void main(String[] args) {
		System.out.println(solution(976));
	}
	public static int solution(int n) {
		int answer = 0;
		double result = Math.sqrt(n);
		if(Math.floor(result)==result) {
			answer = 1;
		}else {
			answer = 2;
		}
        return answer;
    }
}
// 제곱수 판별하기  LV.0