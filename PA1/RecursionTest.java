public class RecursionTest {

	//////////////////////////////
	//Test Cases for minArrayIndex
	//////////////////////////////
	private static int minArrayIndexTests() {
		int total = 16;
		int points = 0;

		System.out.println("=========================================");
		System.out.println("minArrayIndex");

		//Test 1
		//////////////////////////////
		int[] min1 = {10};
		points += minArrayIndexTest_ExpectedIndex(min1, 0, 1);

		//Test 2
		//////////////////////////////
		int[] min2 = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
		points += minArrayIndexTest_ExpectedIndex(min2, 6, 2);

		//Test 3
		//////////////////////////////
		int ats3 = 10000;
		int[] min3 = new int[ats3];
		for (int i = 0; i < ats3; i++) {
			min3[i] = ats3 - i;
		}
		points += minArrayIndexTest_ExpectedIndex(min3, ats3 - 1, 3);

		//Test 4
		//////////////////////////////
		int ats4 = 10000;
		int[] min4 = new int[ats4];
		points += minArrayIndexTest_InBounds(min4, 4);

		System.out.println("Test Case score: " + points + "/" + total);
		return points;
	}

	private static int minArrayIndexTest_ExpectedIndex(int[] array, int expectedIndex, int testIndex) {
		int points = 0;
		try {
			int minIndex = Recursion.minArrayIndex(array , 0, array.length - 1);
			if (minIndex == expectedIndex) {
				points += 4;
				System.out.println("Test " + testIndex + " Passed!");
			} else {
				System.out.println("Test " + testIndex + " Failed!");
			}
		} catch (Exception e) {
			System.out.println("Test " + testIndex + " Failed from a Runtime Error!");
			System.out.println("Exception: " + e);
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;
	}

	private static int minArrayIndexTest_InBounds(int[] array, int testIndex) {
		int points = 0;
		try {
			int minIndex = Recursion.minArrayIndex(array , 0, array.length - 1);
			if (minIndex >= 0 && minIndex < array.length) {
				points += 4;
				System.out.println("Test " + testIndex + " Passed!");
			} else {
				System.out.println("Test " + testIndex + " Failed!");
			}
		} catch (Exception e) {
			System.out.println("Test " + testIndex + " Failed from a Runtime Error!");
			System.out.println("Exception: " + e);
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;
	}


	//////////////////////////////
	//Test Cases for maxArrayIndex
	//////////////////////////////
	private static int maxArrayIndexTests() {
		int total = 16;
		int points = 0;

		System.out.println("=========================================");
		System.out.println("maxArrayIndex");

		//Test 1
		//////////////////////////////
		int[] max1 = {10};
		points += maxArrayIndexTest_ExpectedIndex(max1, 0, 1);

		//Test 2
		//////////////////////////////
		int[] max2 = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
		points += maxArrayIndexTest_ExpectedIndex(max2, 3, 2);

		//Test 3
		//////////////////////////////
		int ats3 = 10000;
		int[] max3 = new int[ats3];
		for (int i = 0; i < ats3; i++) {
			max3[i] = ats3 - i;
		}
		points += maxArrayIndexTest_ExpectedIndex(max3, 0, 3);

		//Test 4
		//////////////////////////////
		int ats4 = 10000;
		int[] max4 = new int[ats4];
		points += maxArrayIndexTest_InBounds(max4, 4);

		System.out.println("Test Case score: " + points + "/" + total);
		return points;
	}

	private static int maxArrayIndexTest_ExpectedIndex(int[] array, int expectedIndex, int testIndex) {
		int points = 0;
		try {
			int maxIndex = Recursion.maxArrayIndex(array , 0, array.length - 1);
			if (maxIndex == expectedIndex) {
				points += 4;
				System.out.println("Test " + testIndex + " Passed!");
			} else {
				System.out.println("Test " + testIndex + " Failed!");
			}
		} catch (Exception e) {
			System.out.println("Test " + testIndex + " Failed from a Runtime Error!");
			System.out.println("Exception: " + e);
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;
	}

	private static int maxArrayIndexTest_InBounds(int[] array, int testIndex) {
		int points = 0;
		try {
			int maxIndex = Recursion.maxArrayIndex(array , 0, array.length - 1);
			if (maxIndex >= 0 && maxIndex < array.length) {
				points += 4;
				System.out.println("Test " + testIndex + " Passed!");
			} else {
				System.out.println("Test " + testIndex + " Failed!");
			}
		} catch (Exception e) {
			System.out.println("Test " + testIndex + " Failed from a Runtime Error!");
			System.out.println("Exception: " + e);
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;
	}


	//////////////////////////////
	//Test Cases for reverseArray1
	//////////////////////////////
	private static int reverseArray1Tests(){
		int points = 0;
		int total = 16;
		int A_rev[] = new int[1000];
    	int B_rev[] = new int[1000];

       	for (int i = 0; i < A_rev.length; i++) {
        	A_rev[i] = i + 1;
       	}

		System.out.println("=========================================");
		System.out.println("reverseArray1");

		points += reverseArray1Test_Test1(A_rev,B_rev);
		points += reverseArray1Test_Test2(A_rev,B_rev);
		points += reverseArray1Test_Test3(A_rev,B_rev);
		points += reverseArray1Test_Test4();

		System.out.println("Test Case score: " + points + "/" + total);
		return points;
	}

		//Test 1
		//////////////////////////////
	private static int reverseArray1Test_Test1(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray1(A, 1, B);
			if (A[0] != B[B.length - 1] || B[B.length - 2] != 0){
				System.out.println("Test 1 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray1Test_Test2(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray1(A, A.length - 1, B);
			if  (A[A.length - 2] != B[1] || B[0] != 0){
				System.out.println("Test 2 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray1Test_Test3(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray1(B, B.length, A);
			int test_flag = 0;
			for (int i = 0; i < A.length - 1; i++) {
          		if (A[i] != i + 1){
					System.out.println("Test 3 Failed!");	
					test_flag = 1;
					break;				
				}
        	}
			if(test_flag == 0){
				points += 4;
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
	private static int reverseArray1Test_Test4(){
		int points = 0;
		int[] arr = {1};
		int[] rev = new int[arr.length];
		try{
			Recursion.reverseArray1(arr , arr.length, rev);
			if(rev[0] == arr[0]){
				points += 4;
				System.out.println("Test 4 Passed!");
			}
			else{
				System.out.println("Test 4 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 4 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//////////////////////////////
	//Test Cases for reverseArray2
	//////////////////////////////
	private static int reverseArray2Tests(){
		int points = 0;
		int total = 16;
		int A_rev[] = new int[1000];
    	int B_rev[] = new int[1000];

       	for (int i = 0; i < A_rev.length; i++) {
        	A_rev[i] = i + 1;
       	}

		System.out.println("=========================================");
		System.out.println("reverseArray2");

		points += reverseArray2Test_Test1(A_rev,B_rev);
		points += reverseArray2Test_Test2(A_rev,B_rev);
		points += reverseArray2Test_Test3(A_rev,B_rev);
		points += reverseArray2Test_Test4();

		System.out.println("Test Case score: " + points + "/" + total);
		return points;
	}

		//Test 1
		//////////////////////////////
	private static int reverseArray2Test_Test1(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray2(A, 1, B);
			if (A[A.length - 1] != B[0] || B[1] != 0){
				System.out.println("Test 1 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray2Test_Test2(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray2(A, A.length - 1, B);
			if  (A[1] != B[B.length - 2] || B[A.length - 1] != 0){
				System.out.println("Test 2 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray2Test_Test3(int[] A, int[] B){
		int points = 0;
		try{
			Recursion.reverseArray2(B, B.length, A);
			int test_flag = 0;
			for (int i = 1; i < A.length; i++) {
          		if (A[i] != i + 1){
					System.out.println("Test 3 Failed!");	
					test_flag = 1;
					break;				
				}
        	}
			if(test_flag == 0){
				points += 4;
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
	private static int reverseArray2Test_Test4(){
		int points = 0;
		int[] arr = {1};
		int[] rev = new int[arr.length];
		
		try{
			Recursion.reverseArray2(arr , arr.length, rev);
			if(rev[0] == arr[0]){
				points += 4;
				System.out.println("Test 4 Passed!");
			}
			else{
				System.out.println("Test 4 Failed!");
			}
		}catch(Exception e){
			System.out.println("Test 4 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}

	//////////////////////////////
	//Test Cases for reverseArray3
	//////////////////////////////
	private static int reverseArray3Tests(){
		int points = 0;
		int total = 16;
		int A_rev[] = new int[1000];

       	for (int i = 0; i < A_rev.length; i++) {
        	A_rev[i] = i + 1;
       	}

		System.out.println("=========================================");
		System.out.println("reverseArray3");

		points += reverseArray3Test_Test1(A_rev);
		points += reverseArray3Test_Test2(A_rev);
		points += reverseArray3Test_Test3(A_rev);
		points += reverseArray3Test_Test4(A_rev);

		System.out.println("Test Case score: " + points + "/" + total);
		return points;
	}

		//Test 1
		//////////////////////////////
	private static int reverseArray3Test_Test1(int[] A){
		int points = 0;
		try{
			Recursion.reverseArray3(A, 0, 0);
			if (A[0] != 1){
				System.out.println("Test 1 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray3Test_Test2(int[] A){
		int points = 0;
		try{
			Recursion.reverseArray3(A, 0, 2);
			if  (A[0] != 3 || A[1] != 2 || A[2] != 1){
				System.out.println("Test 2 Failed!");
			}
			else{
				points += 4;
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
	private static int reverseArray3Test_Test3(int[] A){
		int points = 0;
		try{
			Recursion.reverseArray3(A, 0, 3);
			if(A[0] != 4 || A[1] != 1 || A[2] != 2 || A[3] != 3){
				System.out.println("Test 4 Failed!");
			}
			else{
				points += 4;
				System.out.println("Test 4 Passed!");
			}
		}catch(Exception e){
			System.out.println("Test 4 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}
		//Test 4
		//////////////////////////////
	private static int reverseArray3Test_Test4(int[] A){
		int points = 0;
		try{
			Recursion.reverseArray3(A, 3, A.length - 1);;
			int test_flag = 0;
			for (int i = 1; i < A.length - 4; i++) {
          		if (A[A.length - i - 1] != i + 4){
					System.out.println("Test 3 Failed!");	
					test_flag = 1;
					break;				
				}
        	}
			if(test_flag == 0){
				if (A[3] != A.length || A[A.length - 1] != 3){
					System.out.println("Test 3 Failed!");
				}
				else{
					points += 4;
					System.out.println("Test 3 Passed!");
				}
			}
		}catch(Exception e){
			System.out.println("Test 3 Failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		return points;

	}


	public static void main(String[] args) {
		int all_total = 80;
		int all_points = 0;
		int total;
		int points;

		all_points += minArrayIndexTests();
		all_points += maxArrayIndexTests();
		all_points += reverseArray1Tests();
		all_points += reverseArray2Tests();
		all_points += reverseArray3Tests();

		System.out.println("=========================================");
		System.out.println("Overall Test Case score: " + all_points + "/" + all_total);
		System.out.println("=========================================");
	}
}