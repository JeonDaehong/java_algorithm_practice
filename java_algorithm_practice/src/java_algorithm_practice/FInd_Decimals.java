package java_algorithm_practice;

import java.util.ArrayList;
import java.util.List;

/*
	 1. ‘에라토스테네스의 체’ : 여러 자연수 중에서 ‘소수’만 구하기
	
	 [1] 정의
	  	☑ 자연수 ‘n’이 소수인지 아닌지를 걸러내는 방법이다.
	  	☑ 소수란, 1과 자신만을 약수로 갖는 1보다 큰 자연수를 의미한다.
	
	 [2] 방법
	  	☑ 1) 일단 ‘n’까지의 자연수를 ‘A’라는 배열에 순서대로 담는다. (for문 사용)
	      2) ‘A’ 배열의 가장 첫 번째 요소‘a’를 ‘B’라는 배열에 옮겨 담는다.
	      3) ‘A’ 배열에서 ‘a’의 배수를 모두 삭제한다.
	      4) ‘B’ 배열 마지막(최댓값) 수의 제곱보다, ‘A’ 배열의 마지막(최댓값) 수보다 작아질 때까지
	         (2~4)의 과정을 반복한다.
    	  5) ‘A’ 배열에 남아있는 수는 모두 ‘소수’이다.
*/

// 소수 골라주는 Class
class Find {
	
	List<Integer> findDecimals(int n) {
		
		List<Integer> numList = new ArrayList<>();			// 자연수 2 ~ n까지 담는 List배열 (추후 소수만 남게 될 List)
		List<Integer> decimalList = new ArrayList<>();		// 소수가 아닌 수를 담을 List배열
		
		int cnt = 0;				// numList decimalList로 이동한 수 카운트
		int decimalListMaxNum = 0;  // decimalList의 값 중, 최댓값
		int numListMaxNum = n; 		// numList의 남은 수 중, 최댓값
		
		// 2 ~ n까지의 수를 numList에 넣어주기
		for (int i=2; i<=n; i++) {
			numList.add(i);
		}
		
		// 소수 판별
		while ((decimalListMaxNum*decimalListMaxNum) < numListMaxNum) {
			
			// numList에서 decimalList로 보낸 수를 제외한 첫 번째 수를 decimalList에 추가
			decimalList.add(numList.get(cnt));
			
			// 방금 decimalList로 옮겨간 수의 배수들 전부 삭제
			for (int i=(cnt+1); i<numList.size(); i++) {
				if (numList.get(i) % decimalList.get(cnt) == 0) {
					numList.remove(i);
				}
			}
			
			// 남은 수들 중, 각 List별 최댓값 변경
			decimalListMaxNum = decimalList.get(decimalList.size()-1);
			numListMaxNum = numList.get(numList.size()-1);
			
			cnt++;	// 카운트 올려주기
			
		}
		
		// numList에는 소수만 남았기에 return
		return numList;
		
	}
	
}

// 작동 잘 되는지 확인해보기
public class FInd_Decimals {

	public static void main(String[] args) {

		List<Integer> answerList = new ArrayList<>();
		
		Find find = new Find();
		
		answerList = find.findDecimals(1000);		// n 값 넣기
		
		
		// 결과 출력
		for (int i=0; i<answerList.size(); i++) {
			System.out.println(answerList.get(i));
		}
		
	}

}
