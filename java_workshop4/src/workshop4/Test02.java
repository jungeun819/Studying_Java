package workshop4;

public class Test02 {
/**
 * 다음과 같이 선언되어 있는 배열에 1~10까지의 랜덤한 숫자(중복허용)를 넣고 
 * 이 배열에 어떤 값이 셋팅 되었는지 출력 하고 배열 데이터의 합과 평균을 구하는 프로그램을 작성 하시오 
 */
	public static void main(String[] args) {
		int[] arr3 = new int[5];
		int cnt = 0;
		int index = 0;
		int sum = 0;
		int temp = 0;
		
		label :
		for(;;) {
			cnt++;
			temp = (int)(Math.random() * 10 + 1);
			for(int i = 0; i < arr3.length; i++) {
				if(arr3[i] == temp)
					continue label;
			}
			arr3[index++] = temp;
			sum += temp;
			if(index == arr3.length)
				break;
		}
		// 배열 내용 출력
		for (int arr : arr3) {
			System.out.print(arr + " ");
		}
		System.out.println();
		double avg = sum / cnt;
		System.out.printf("sum = %d\n", sum);
		System.out.printf("avg = %.1f", avg);
	}
}
