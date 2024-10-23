package algorithm;

public class Main {
	public static void main(String[] args) {
		System.out.println(solution(11,3));
	}
    public static int solution(int n, int k) {
        int answer = (n*12000)+(k*2000)-(n/10*2000);
        
        return answer;
    }
}
// 문제 : 양꼬치 LV: 0 