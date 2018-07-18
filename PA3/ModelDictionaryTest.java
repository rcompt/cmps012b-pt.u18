import java.util.*;

public class ModelDictionaryTest{


	private static int dictionaryTests(){
		int points = 0;

		points += insert_tests();
		points += isEmpty_tests();
		points += delete_tests();
		points += makeEmpty_tests();
		points += size_tests();
		points += lookup_tests();
		points += toString_tests();
		points += exceptions_tests();
		
		return points;
	}

	//Test Cases for insert
	//////////////////////////////
	private static int insert_tests(){
		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("insert Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 15;

	//Test 1
	//////////////////////////////	
		A.insert("test","123");
		if(A.lookup("test") != "123"){
			System.out.println("insert test 1 failed!");
		}else{
			System.out.println("insert test 1 passed!");
			points += 5;
		}

	//Test 2
	//////////////////////////////
		A.insert("test2","1234");

		if(A.isEmpty() || A.lookup("test") != "123"){
			System.out.println("insert test 2 failed!");
		}else{
			System.out.println("insert test 2 passed!");
			points += 5;
		}
	
	//Test 3
	//////////////////////////////
		for(int i = 0; i < 10000; i++){
			B.insert("test"+i,""+i);	
		}

		if(B.isEmpty() || B.lookup("test9999") != "9999"){
			System.out.println("insert test 3 failed!");
		}else{
			System.out.println("insert test 3 passed!");
			points += 5;
		}
	
		System.out.println("-----------------------------------------");
		System.out.println("insert Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for isEmpty
	//////////////////////////////
	private static int isEmpty_tests(){
		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("isEmpty Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 5;

	//Test 1
	//////////////////////////////	
		if(!A.isEmpty() || !B.isEmpty()){
			System.out.println("isEmpty test 1 failed!");
		}else{
			System.out.println("isEmpty test 1 passed!");
			points += 2;
		}

	//Test 2
	//////////////////////////////
		A.insert("test","123");

		if(A.isEmpty() || !B.isEmpty()){
			System.out.println("isEmpty test 2 failed!");
		}else{
			System.out.println("isEmpty test 2 passed!");
			points += 3;
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("isEmpty Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for size
	//////////////////////////////
	private static int size_tests(){
		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("size Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 5;

		int test_range = 1000;

	//Test 1
	//////////////////////////////
        if (A.size() != B.size()){
			System.out.println("size test 1 failed!");
		}else{
			System.out.println("size test 1 passed!");
			points += 1;
		}

	//Test 2
	//////////////////////////////
        A.insert("test", "123");
        if (A.size() == B.size()){			
			System.out.println("size test 2 failed!");
		}else{
			System.out.println("size test 2 passed!");
			points += 1;
		}

	//Test 3
	//////////////////////////////
        B.insert("test", "123");
        if (A.size() != B.size()){
			System.out.println("size test 3 failed!");
		}else{
			System.out.println("size test 3 passed!");
			points += 1;
		}


		A = new Dictionary();
		B = new Dictionary();

	//Test 4
	//////////////////////////////
        for (int i = 0; i < test_range; i++) {
          A.insert(i + 1 + "", "test" + i + 1);
        }

        for (int i = 0; i < test_range / 10; i++) {
          B.insert(i + 1 + "", "test" + i + 1);
        }
        if (A.size() != test_range || B.size() != test_range / 10){
			System.out.println("size test 4 failed!");
		}else{
			System.out.println("size test 4 passed!");
			points += 1;
		}

	//Test 5
	//////////////////////////////
        for (int i = test_range / 10; i < test_range; i++) {
          B.insert(i + 1 + "", "test" + i + 1);
        }
        if (A.size() != B.size()){
			System.out.println("size test 5 failed!");
		}else{
			System.out.println("size test 5 passed!");
			points += 1;
		}

	//Test 6
	//////////////////////////////
        for (int i = test_range * 9 / 10; i < test_range; i++) {
          A.delete(i + 1 + "");
        }
        if (A.size() != test_range * 9 / 10 || B.size() != test_range){
			System.out.println("size test 6 failed!");
		}else{
			System.out.println("size test 6 passed!");
			points += 0;
		}

	//Test 7
	//////////////////////////////
        for (int i = test_range * 9 / 10 - 1; i >= 0; i--) {
          A.delete(i + 1 + "");
        }
        B.makeEmpty();
        if (A.size() != 0 || B.size() != 0){
			System.out.println("size test 7 failed!");
		}else{
			System.out.println("size test 7 passed!");
			points += 0;
		}

		System.out.println("-----------------------------------------");
		System.out.println("size Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for delete
	//////////////////////////////
	private static int delete_tests(){
		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("delete Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 15;

		A.insert("test","123");
		A.delete("test");

	//Test 1
	//////////////////////////////
        if (A.size() != B.size()){
			System.out.println("delete test 1 failed!");
		}else{
			System.out.println("delete test 1 passed!");
			points += 5;
		}
		
	//Test 2
	//////////////////////////////
		B.insert("test","123");
		B.insert("testing","1234");
		B.delete("test");
		A.insert("test", "123");
        if (A.size() != B.size()){			
			System.out.println("delete test 2 failed!");
		}else{
			System.out.println("delete test 2 passed!");
			points += 5;
		}

	//Test 3
	//////////////////////////////
        A.delete("test");
		for(int i = 0; i < 1000; i++){
			A.insert("test" + i,""+i);
		}
		for(int i = 0; i < 1000; i++){
			A.delete("test" + i);
		}
        if (A.size() != 0){
			System.out.println("delete test 3 failed!");
		}else{
			System.out.println("delete test 3 passed!");
			points += 5;
		}
		System.out.println("-----------------------------------------");
		System.out.println("delete Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for lookUp
	//////////////////////////////
	private static int lookup_tests(){

		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("lookUp Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 15;

		boolean flag = true;
		int test_range = 1000;

	//Test 1
	//////////////////////////////
        if (A.lookup("test") != B.lookup("test")){
			System.out.println("lookUp test 1 failed!");
		}else{
			System.out.println("lookUp test 1 passed!");
			points += 1;
		}

	//Test 2
	//////////////////////////////
        A.insert("test", "123");
        if (!A.lookup("test").equals("123") || B.lookup("test") != null){
			System.out.println("lookUp test 2 failed!");
		}else{
			System.out.println("lookUp test 2 passed!");
			points += 1;
		}

	//Test 3
	//////////////////////////////
        B.insert("test", "123");
        if (!A.lookup("test").equals(B.lookup("test"))){
			System.out.println("lookUp test 3 failed!");
		}else{
			System.out.println("lookUp test 3 passed!");
			points += 1;
		}

	//Test 4
	//////////////////////////////
		for (int i = 0; i < test_range; i++) {
          	A.insert(i + 1 + "", "test" + i + 1);
          	if (!A.lookup(i + 1 + "").equals("test" + i + 1)){
				System.out.println("lookUp test 4 failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 4 passed!");
			points += 1;
		}else{
			flag = true;	
		}
	//Test 5
	//////////////////////////////
        for (int i = 0; i < test_range / 10; i++) {
          	B.insert(i + 1 + "", "test" + i + 1);
          	if (!B.lookup(i + 1 + "").equals("test" + i + 1)){
				System.out.println("lookUp test 5 failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 5 passed!");
			points += 1;
		}else{
			flag = true;	
		}
	//Test 6
	//////////////////////////////
        for (int i = test_range / 10; i < test_range; i++) {
          	if (B.lookup(i + 1 + "") != null){
				System.out.println("lookUp test 6a failed!");
				flag = false;
				break;
			}
          	B.insert(i + 1 + "", "test" + i + 1);
          	if (!B.lookup(i + 1 + "").equals("test" + i + 1)){
				System.out.println("lookUp test 6b failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 6 passed!");
			points += 1;
		}else{
			flag = true;	
		}

	//Test 7
	//////////////////////////////
        for (int i = test_range * 9 / 10; i < test_range; i++) {
          	A.delete(i + 1 + "");
          	if (A.lookup(i + 1 + "") != null){
				System.out.println("lookUp test 7 failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 7 passed!");
			points += 1;
		}else{
			flag = true;	
		}
	//Test 8
	//////////////////////////////
        for (int i = test_range * 9 / 10 - 1; i >= 0; i--) {
          A.delete(i + 1 + "");
          if (A.lookup(i + 1 + "") != null){
				System.out.println("lookUp test 8 failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 8 passed!");
			points += 1;
		}else{
			flag = true;	
		}
	//Test 9
	//////////////////////////////
        B.makeEmpty();
        for (int i = 0; i < test_range; i++) {
          if (A.lookup(i + 1 + "") != null){
			System.out.println("lookUp test 9 failed!");
				flag = false;
				break;
			}
        }
		if(flag){
			System.out.println("lookUp test 9 passed!");
			points += 1;
		}else{
			flag = true;	
		}
	//Test 10
	//////////////////////////////
        A.insert("repeat", "123");
        if (!A.lookup("repeat").equals("123")){
			System.out.println("lookUp test 10 failed!");
		}else{
			System.out.println("lookUp test 10 passed!");
			points += 1;
		}
	//Test 11
	//////////////////////////////
        A.delete("repeat");
        if (A.lookup("repeat") != null){
			System.out.println("lookUp test 11 failed!");
		}else{
			System.out.println("lookUp test 11 passed!");
			points += 1;
		}
	//Test 12
	//////////////////////////////
        A.insert("repeat", "123");
        if (!A.lookup("repeat").equals("123")){
			System.out.println("lookUp test 12 failed!");
		}else{
			System.out.println("lookUp test 12 passed!");
			points += 1;
		}

	//Test 13
	//////////////////////////////
        for (int i = 0; i < test_range; i++) {
          A.insert("" + (i + 1), "test" + (i + 1));
        }

        A.delete("" + (test_range / 2));
        if (A.lookup("" + (test_range / 2)) != null){
			System.out.println("lookUp test 13 failed!");
		}else{
			System.out.println("lookUp test 13 passed!");
			points += 1;
		}
	//Test 14
	//////////////////////////////
        if (!A.lookup("" + (test_range / 2 + 1)).equals(
              "test" + (test_range / 2 + 1))){
			System.out.println("lookUp test 14 failed!");
		}else{
			System.out.println("lookUp test 14 passed!");
			points += 1;
		}

	//Test 15
	//////////////////////////////
        if (!A.lookup("" + (test_range / 2 - 1)).equals(
              "test" + (test_range / 2 - 1))){
			System.out.println("lookUp test 15 failed!");
		}else{
			System.out.println("lookUp test 15 passed!");
			points += 1;
		}
		System.out.println("-----------------------------------------");
		System.out.println("lookUp Test Case score: " + points + "/" + total);
		return points;

	}

	//Test Cases for toString
	//////////////////////////////
	private static int toString_tests(){
		Dictionary A = new Dictionary();
		Dictionary B = new Dictionary();

		System.out.println("=========================================");
		System.out.println("toString Test Cases");
		System.out.println("-----------------------------------------");

		int points = 0;
		int total = 10;
		
	//Test 1
	//////////////////////////////
        if (!A.toString().equals(B.toString())){
			System.out.println("toString test 1 failed!");
		}else{
			System.out.println("toString test 1 passed!");
			points += 3;
		}
	//Test 2
	//////////////////////////////
        A.insert("1", "one");
        B.insert("2", "two");
        A.insert("2", "two");
        B.insert("1", "one");
        if (A.toString().equals(B.toString())){
			System.out.println("toString test 2 failed!");
		}else{
			System.out.println("toString test 2 passed!");
			points += 3;
		}

	//Test 3
	//////////////////////////////
        B.delete("2");
        B.insert("2", "two");
        if (!A.toString().equals(B.toString())){
			System.out.println("toString test 3 failed!");
		}else{
			System.out.println("toString test 3 passed!");
			points += 4;
		}
		System.out.println("-----------------------------------------");
		System.out.println("toString Test Case score: " + points + "/" + total);
		return points;

	}

	//Test Cases for makeEmpty
	//////////////////////////////
	private static int makeEmpty_tests(){

		System.out.println("=========================================");
		System.out.println("makeEmpty Test Cases");
		System.out.println("-----------------------------------------");

		Dictionary A = new Dictionary();

		int points = 0;
		int total = 10;
		
	//Test 1
	//////////////////////////////
		for(int i = 0; i < 1000; i++){
			A.insert("test" + i, ""+i);
		}
		A.makeEmpty();
		if(A.size() != 0 && !A.isEmpty()){
			System.out.println("makeEmpty test 1 failed!");
		}else{
			System.out.println("makeEmpty test 1 passed!");
			points += 10;
		}
		System.out.println("----------------------------------------");
		System.out.println("makeEmpty Test Case score: " + points + "/" + total);
		return points;

	}

	//Test Cases for Exceptions
	//////////////////////////////
	private static int exceptions_tests(){

		System.out.println("=========================================");
		System.out.println("Exceptions Test Cases");
		System.out.println("-----------------------------------------");

		Dictionary A = new Dictionary();
		int points = 0;
		int test_range = 1000;

		int total = 5;

       boolean failed = true;
        try {
          	A.delete("test");
        } catch(KeyNotFoundException k) {
          	failed = false;
        }
        if (failed){
			System.out.println("Exception test 1 failed!");
		}else{
			System.out.println("Exception test 1 passed!");
			points += 1;
		}

        failed = true;
        A.insert("test", "123");
        try {
          A.insert("test", "123");
        } catch(DuplicateKeyException d) {
          failed = false;
        }
        if (failed){
			System.out.println("Exception test 2 failed!");
		}else{
			System.out.println("Exception test 2 passed!");
			points += 2;
		}

        failed = true;
        for (int i = 0; i < test_range; i++) {
          A.insert(i + 1 + "", "test" + i + 1);
        }
        for (int i = test_range - 1; i >= 0; i--) {
          A.delete(i + 1 + "");
          try{
            A.delete(i + 1 + "");
          } catch (KeyNotFoundException k) {
            failed = false;
          }

        }
        if (failed){
			System.out.println("Exception test 3 failed!");
		 }else{
			System.out.println("Exception test 3 passed!");
			points += 2;
		}
          failed = true;

		System.out.println("-----------------------------------------");
		System.out.println("Exceptions Test Case score: " + points + "/" + total);
		return points;

	}

	public static void main(String[] args){
		int all_total = 75;
		int all_points = 0;
	
		int total;
		int points;
		
		all_points += dictionaryTests();
		System.out.println("=========================================");
		System.out.println("Total score: " + all_points + "/" + all_total);
		System.out.println("=========================================");
	}

}
