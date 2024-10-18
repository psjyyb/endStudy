package algorithm;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public static void main(String[] args) {
		System.out.println(solution("1a2b3c4d123"));
	}

	public static int solution(String my_string) {
		int answer = 0;
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= my_string.length(); i++) {
			result.add(i - 1, my_string.substring(i - 1, i));
			System.out.println(result.get(i - 1).replaceAll("[^1-9]", "m").equals("m"));
			if (result.get(i - 1).replaceAll("[^0-9]", "m").equals("m")) {
				continue;
			} else {
				answer += Integer.parseInt(result.get(i - 1));
			}
		}
		return answer;
	}
}
