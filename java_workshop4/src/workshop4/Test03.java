package workshop4;

public class Test03 {
/**
 *  다음 배열의 내용을 실행 결과와 같이 출력 되도록 프로그램을 작성 하시오.
 *  100 90 80 70 60 50 40 30 20 10
 */
	public static void main(String[] args) {
		Test03 study = new Test03();
		
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		for(int i = 0; i < arr.length - 1; i++) {
			int max = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					max = j;
				}
				study.swap(arr, i, max);
			}
		}
		// 배열 내용 출력
		for (int array : arr) 
			System.out.print(array + " ");
	}
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
