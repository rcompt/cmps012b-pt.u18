import java.util.*;

public class SearchTest{

	//////////////////////////////
	//Test Cases for mergeSort
	//////////////////////////////
	private static int mergeSortTests(){
		int points = 0;
		int total = 20;
		String A[] = new String[1000];
		String expectation[] = new String[1000];
		int lineNumber[] = new int[1000];

		for(int i = 0; i < A.length; i++){
			A[i] = Integer.toString((A.length - i)+1);
			expectation[i] = Integer.toString((expectation.length - i)+1);
			lineNumber[i] = i+1;
		}

		System.out.println("=========================================");
		System.out.println("mergeSort");

		Arrays.sort(expectation);

		points += mergeSortTest1(A,lineNumber,expectation);
		points += mergeSortTest2(A,lineNumber);
		points += mergeSortTest3(A,lineNumber);
		points += mergeSortTest4(A,lineNumber);

		System.out.println("Test Case score: " + points + "/" + total);
		
		return points;

	}

	//Test 1
	//////////////////////////////
	private static int mergeSortTest1(String[] A, int[] lineNumber, String[] expectation){

		int points = 0;
		try{
			Search.mergeSort(A,lineNumber,0,A.length-1);
			boolean flag = true;
			for(int i = 0; i < A.length; i++){
				if(!A[i].equals(expectation[i])){
					System.out.println("Test 1 Failed!");
					flag = false;
					break;
				}
			}			
			if(flag){
				points += 5;
				System.out.println("Test 1 Passed!");
			}

		}catch(Exception e){
			System.out.println("Test 1 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test 2
	//////////////////////////////
	private static int mergeSortTest2(String[] A, int[] lineNumber){

		int points = 0;
		try{
			boolean flag = true;
        	for (int i = 0; i < A.length; i++) {
          		A[A.length - i - 1] = i + "";
        	}
        	Search.mergeSort(A, lineNumber, 0, 1);

			//// If catch 1
        	if (flag && !A[0].equals("998")){
					System.out.println("Test 2 Failed! If catch 1");
					flag = false;
			}
			//// If catch 2
        	if (flag && !A[2].equals("997")){
					System.out.println("Test 2 Failed! If catch 2");
					flag = false;
			}

        	Search.mergeSort(A, lineNumber, 998, 999);
			//// If catch 3
        	if (flag && !A[999].equals("1")){
					System.out.println("Test 2 Failed! If catch 3");
					flag = false;
			}
			//// If catch 4
        	if (flag && !A[997].equals("2")){
					System.out.println("Test 2 Failed! If catch 4");
					flag = false;
			}
			if(flag){
				points += 5;
				System.out.println("Test 2 Passed!");
			}

		}catch(Exception e){
			System.out.println("Test 2 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test 3
	//////////////////////////////
	private static int mergeSortTest3(String[] A, int[] lineNumber){

		int points = 0;
		try{
			boolean flag = true;
        	for (int i = 0; i < A.length / 2; i++) {
          		A[i + A.length / 2] = i + "";
        	}
        	for (int i = 0; i < A.length / 2; i++) {
          		A[i] = i + A.length / 2 + "";
        	}
        	Search.mergeSort(A, lineNumber, 249, 750);
			//// If catch 1
        	if (flag && !A[0].equals("500")){
					System.out.println("Test 3 Failed! If catch 1");
					flag = false;
			}
			//// If catch 2
        	if (flag && !A[999].equals("499")){
					System.out.println("Test 3 Failed! If catch 2");
					flag = false;
			}
			//// If catch 3
        	if (flag && !A[249].equals("0")){
					System.out.println("Test 3 Failed! If catch 3");
					flag = false;
			}
			//// If catch 4
        	if (flag && !A[750].equals("999")){
					System.out.println("Test 3 Failed! If catch 4");
					flag = false;
			}

        	Search.mergeSort(A, lineNumber, 0, 999);
			//// If catch 5
        	if (flag && !A[0].equals("0")){
					System.out.println("Test 3 Failed! If catch 5");
					flag = false;
			}
			//// If catch 6
        	if (flag && !A[999].equals("999")){
					System.out.println("Test 3 Failed! If catch 6");
					flag = false;
			}
			if(flag){
				points += 5;
				System.out.println("Test 3 Passed!");
			}

		}catch(Exception e){
			System.out.println("Test 3 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test 4
	//////////////////////////////
	private static int mergeSortTest4(String[] A, int[] lineNumber){

		int points = 0;
		try{

			boolean flag = true;
        	for (int i = 0; i < A.length; i++) {
          		A[A.length - i - 1] = i + 1 + "";
        	}

        	A[51] = "makes";
        	A[50] = "Sense,";
        	A[0] = "nothing";

        	Search.mergeSort(A, lineNumber, 0, 50);
			//// If catch 1
        	if (flag && !A[49].equals("Sense,")){
					System.out.println("Test 4 Failed! If catch 1");
					flag = false;
			}
			//// If catch 2
        	if (flag && !A[50].equals("nothing")){
					System.out.println("Test 4 Failed! If catch 2");
					flag = false;
			}
			//// If catch 3
        	if (flag && !A[51].equals("makes")){
					System.out.println("Test 4 Failed! If catch 3");
					flag = false;
			}
        	Search.mergeSort(A, lineNumber, 0, 999);
			//// If catch 4
        	if (flag && !A[997].equals("Sense,")){
					System.out.println("Test 4 Failed! If catch 4");
					flag = false;
			}
			//// If catch 5
        	if (flag && !A[998].equals("makes")){
					System.out.println("Test 4 Failed! If catch 5");
					flag = false;
			}
			//// If catch 6
        	if (flag && !A[999].equals("nothing")){
					System.out.println("Test 4 Failed! If catch 6");
					flag = false;
			}
			//// If catch 7
        	if (flag && !A[996].equals("999")){
					System.out.println("Test 4 Failed! If catch 7");
					flag = false;
			}
			if(flag){
				points += 5;
				System.out.println("Test 4 Passed!");
			}
		}catch(Exception e){
			System.out.println("Test 4 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test Cases for binarySearch
	//////////////////////////////
	private static int binarySearchTests(){
		int points = 0;
		int total = 20;
		String A[] = new String[1000];
		
		for(int i = 0; i < A.length; i++){
			A[i] = Integer.toString(i+1);
		}

		System.out.println("=========================================");
		System.out.println("binarySearch");

		points += binarySearchTest1(A);
		points += binarySearchTest2(A);
		points += binarySearchTest3(A);
		points += binarySearchTest4(A);

		System.out.println("Test Case score: " + points + "/" + total);
		
		return points;

	}

	//Test 1
	//////////////////////////////
	private static int binarySearchTest1(String[] A){
		int points = 0;
		try{
			int result = Search.binarySearch(A,0,A.length-1,"200");
			if(A[result].equals("200")){
				System.out.println("Test 1 Passed!");
				points += 5;
			}else{
				System.out.println("Test 1 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 1 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;
	}

	//Test 2
	//////////////////////////////
	private static int binarySearchTest2(String[] A){

		int points = 0;
		try{
			int result = Search.binarySearch(A,0,10,"8");
			if(A[result].equals("8")){
				System.out.println("Test 2 Passed!");
				points += 5;
			}else{
				System.out.println("Test 2 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 2 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test 3
	//////////////////////////////
	private static int binarySearchTest3(String[] A){

		int points = 0;
		try{
			int result = Search.binarySearch(A,0,10,"900");
			if(result == -1){
				System.out.println("Test 3 Passed!");
				points += 5;
			}else{
				System.out.println("Test 3 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 3 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//Test 4
	//////////////////////////////
	private static int binarySearchTest4(String[] A){

		int points = 0;
		try{
			int result = Search.binarySearch(A,0,500,"499");
			if(A[result].equals("499")){
				System.out.println("Test 4 Passed!");
				points += 5;
			}else{
				System.out.println("Test 4 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 4 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	public static void main(String[] args){
		int all_total = 40;
		int all_points = 0;
		int total;
		int points;

		all_points += mergeSortTests();
		all_points += binarySearchTests();

		System.out.println("=========================================");
		System.out.println("Function Test Case score: " + all_points + "/" + all_total);
		System.out.println("=========================================");
	}

}