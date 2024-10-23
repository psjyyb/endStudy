package algorithm;

public class Bacteria {

	public static void main(String[] args) {
		System.out.println(solution(2,10));
	}
	public static int solution(int n, int t) {
		int answer = n;
		for(int i = 0; i < t; i++) {
			answer = answer*2;
		}
        return answer;
    }

}
// 세균증식 Lv.0