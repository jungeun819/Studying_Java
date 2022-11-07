package workshop4;

public class Test06 {

	public static void main(String[] args) {
		double sum = 0;
		int cnt = 0;
		// 입력 받은 데이터가 2개 미만 또는 2개 초과로 입력 하면 “다시 입력 하세요” 출력
		if(args.length == 2) {
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			// 1~5이외의 숫자가 입력 될 경우 “숫자를 확인 하세요” 출력
			if((num1 > 0 && num1 < 6) &&(num2 > 0 && num2 <6)){
				// 입력 받은 두개의 정수를 이용하여 2차원 배열을 생성한다
				int[][] arr = new int[num1][num2];
				// 2차원 배열에 1~5까지의 랜덤한 숫자(중복허용)를 넣는다
				for(int i = 0; i < arr.length; i++) {
					for(int j = 0; j < arr[i].length; j++) {
						arr[i][j] = (int)(Math.random() * 5 + 1);
						// 배열의 내용을 출력 한다
						System.out.print(arr[i][j] + " ");
						sum += arr[i][j];
						cnt++;
					}
					System.out.println();
				}
				// 배열의 총합과 평균을 출력 한다 
				System.out.println("sum = " + sum);
				System.out.println("avg = " + String.format("%.1f", sum / cnt));
			}else 
				System.err.println("숫자를 확인 하세요");
		}else 
			System.err.println("다시 입력 하세요");
	}
}
