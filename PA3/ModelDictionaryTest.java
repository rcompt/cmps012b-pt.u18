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
		try{
			A.insert("test123","123");
			if(!A.lookup("test123").equals("123")){
				System.out.println("insert test 1 failed!");
			}else{
				System.out.println("insert test 1 passed!");
				points += 5;
			}
		}catch(Exception e){
			System.out.println("insert test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			//System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}

	//Test 2
	//////////////////////////////
		try{
		A.insert("test234","1234");

		if(A.isEmpty() || !A.lookup("test234").equals("1234")){
			System.out.println("insert test 2 failed!");
		}else{
			System.out.println("insert test 2 passed!");
			points += 5;
		}
		}catch(Exception e){
			System.out.println("insert test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	
	//Test 3
	//////////////////////////////
		try{
		for(int i = 0; i < 10000; i++){
			B.insert("test"+(i+1),""+(i+1));	
		}

		if(B.isEmpty() || !B.lookup("test10000").equals("10000")){			
			System.out.println("insert test 3 failed!");
		}else{
			System.out.println("insert test 3 passed!");
			points += 5;
		}
		}catch(Exception e){
			System.out.println("insert test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
		try{
		if(!A.isEmpty() || !B.isEmpty()){
			System.out.println("isEmpty test 1 failed!");
		}else{
			System.out.println("isEmpty test 1 passed!");
			points += 2;
		}
		}catch(Exception e){
			System.out.println("isEmpty test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 2
	//////////////////////////////
		try{
		A.insert("test123","123");

		if(A.isEmpty() || !B.isEmpty()){
			System.out.println("isEmpty test 2 failed!");
		}else{
			System.out.println("isEmpty test 2 passed!");
			points += 3;
		}
		}catch(Exception e){
			System.out.println("isEmpty test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
		try{
        if (A.size() != B.size()){
			System.out.println("size test 1 failed!");
		}else{
			System.out.println("size test 1 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("size test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 2
	//////////////////////////////
		try{
        A.insert("test123", "123");
        if (A.size() == B.size()){			
			System.out.println("size test 2 failed!");
		}else{
			System.out.println("size test 2 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("size test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 3
	//////////////////////////////
		try{
        B.insert("test123", "123");
        if (A.size() != B.size()){
			System.out.println("size test 3 failed!");
		}else{
			System.out.println("size test 3 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("size test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}


		A = new Dictionary();
		B = new Dictionary();

	//Test 4
	//////////////////////////////
		try{
        for (int i = 0; i < test_range; i++) {
          A.insert(i + "", "test" + (i + 1));
        }

        for (int i = 0; i < test_range / 10; i++) {
          B.insert(i + "", "test" + (i + 1));
        }
        if (A.size() != test_range || B.size() != test_range / 10){
			System.out.println("size test 4 failed!");
		}else{
			System.out.println("size test 4 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("size test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 5
	//////////////////////////////
		try{
        for (int i = test_range / 10; i < test_range; i++) {
          B.insert(i + "", "test" + (i + 1));
        }
        if (A.size() != B.size()){
			System.out.println("size test 5 failed!");
		}else{
			System.out.println("size test 5 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("size test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 6
	//////////////////////////////
		try{
        for (int i = test_range * 9 / 10; i < test_range; i++) {
          A.delete(i + "");
        }
        if (A.size() != test_range * 9 / 10 || B.size() != test_range){
			System.out.println("size test 6 failed!");
		}else{
			System.out.println("size test 6 passed!");
			points += 0;
		}
		}catch(Exception e){
			System.out.println("size test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 7
	//////////////////////////////
		try{
        for (int i = test_range * 9 / 10 - 1; i >= 0; i--) {
          A.delete(i + "");
        }
        B.makeEmpty();
        if (A.size() != 0 || B.size() != 0){
			System.out.println("size test 7 failed!");
		}else{
			System.out.println("size test 7 passed!");
			points += 0;
		}
		}catch(Exception e){
			System.out.println("size test 7 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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

	//Test 1
	//////////////////////////////
		try{
		A.insert("test","123");
		A.delete("test");
        if (A.size() != B.size()){
			System.out.println("delete test 1 failed!");
		}else{
			System.out.println("delete test 1 passed!");
			points += 5;
		}
		}catch(Exception e){
			System.out.println("delete test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
		
	//Test 2
	//////////////////////////////
		try{
		B.insert("test123","123");
		B.insert("testing123","1234");
		B.delete("test123");
		A.insert("test123", "123");
        if (A.size() != B.size()){			
			System.out.println("delete test 2 failed!");
		}else{
			System.out.println("delete test 2 passed!");
			points += 5;
		}
		}catch(Exception e){
			System.out.println("delete test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 3
	//////////////////////////////
		try{
        A.delete("test123");
		for(int i = 0; i < 1000; i++){
			A.insert("test" + (i + 1),""+i);
		}
		for(int i = 0; i < 1000; i++){
			A.delete("test" + (i + 1));
		}
        if (A.size() != 0){
			System.out.println("delete test 3 failed!");
		}else{
			System.out.println("delete test 3 passed!");
			points += 5;
		}
		}catch(Exception e){
			System.out.println("delete test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
		try{
        if (A.lookup("test123") != B.lookup("test123")){
			System.out.println("lookUp test 1 failed!");
		}else{
			System.out.println("lookUp test 1 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 2
	//////////////////////////////
		try{
        A.insert("test123", "123");
        if (!A.lookup("test123").equals("123") || B.lookup("test123") != null){
			System.out.println("lookUp test 2 failed!");
		}else{
			System.out.println("lookUp test 2 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 3
	//////////////////////////////
		try{
        B.insert("test123", "123");
        if (!A.lookup("test123").equals(B.lookup("test123"))){
			System.out.println("lookUp test 3 failed!");
		}else{
			System.out.println("lookUp test 3 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 4
	//////////////////////////////
		try{
		for (int i = 0; i < test_range; i++) {
          	A.insert(i + "", "test" + (i + 1));
          	if (!A.lookup(i + "").equals("test" + (i + 1))){
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
		}catch(Exception e){
			System.out.println("lookUp test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 5
	//////////////////////////////
		try{
        for (int i = 0; i < test_range / 10; i++) {
          	B.insert(i + "", "test" + (i + 1));
          	if (!B.lookup(i + "").equals("test" + (i + 1))){
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
		}catch(Exception e){
			System.out.println("lookUp test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 6
	//////////////////////////////
		try{
        for (int i = test_range / 10; i < test_range; i++) {
          	if (B.lookup(i + "") != null){
				System.out.println("lookUp test 6a failed!");
				flag = false;
				break;
			}
          	B.insert((i) + "", "test" + (i + 1));
          	if (!B.lookup(i + "").equals("test" + (i + 1))){
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
		}catch(Exception e){
			System.out.println("lookUp test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 7
	//////////////////////////////
		try{
        for (int i = test_range * 9 / 10; i < test_range; i++) {
          	A.delete(i + "");
          	if (A.lookup(i + "") != null){
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
		}catch(Exception e){
			System.out.println("lookUp test 7 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 8
	//////////////////////////////
		try{
        for (int i = test_range * 9 / 10 - 1; i >= 0; i--) {
          A.delete(i + "");
          if (A.lookup(i + "") != null){
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
		}catch(Exception e){
			System.out.println("lookUp test 8 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 9
	//////////////////////////////
		try{
        B.makeEmpty();
        for (int i = 0; i < test_range; i++) {
          if (A.lookup(i + "") != null){
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
		}catch(Exception e){
			System.out.println("lookUp test 9 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 10
	//////////////////////////////
		try{
        A.insert("repeat123", "123");
        if (!A.lookup("repeat123").equals("123")){
			System.out.println("lookUp test 10 failed!");
		}else{
			System.out.println("lookUp test 10 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 10 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 11
	//////////////////////////////
		try{
        A.delete("repeat123");
        if (A.lookup("repeat123") != null){
			System.out.println("lookUp test 11 failed!");
		}else{
			System.out.println("lookUp test 11 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 11 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 12
	//////////////////////////////
		try{
        A.insert("repeat123", "123");
        if (!A.lookup("repeat123").equals("123")){
			System.out.println("lookUp test 12 failed!");
		}else{
			System.out.println("lookUp test 12 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 12 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 13
	//////////////////////////////
		try{
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
		}catch(Exception e){
			System.out.println("lookUp test 13 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 14
	//////////////////////////////
		try{
        if (!A.lookup("" + (test_range / 2 + 1)).equals(
              "test" + (test_range / 2 + 1))){
			System.out.println("lookUp test 14 failed!");
		}else{
			System.out.println("lookUp test 14 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 14 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 15
	//////////////////////////////
		try{
        if (!A.lookup("" + (test_range / 2 - 1)).equals(
              "test" + (test_range / 2 - 1))){
			System.out.println("lookUp test 15 failed!");
		}else{
			System.out.println("lookUp test 15 passed!");
			points += 1;
		}
		}catch(Exception e){
			System.out.println("lookUp test 15 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
		try{
        if (!A.toString().equals(B.toString())){
			System.out.println("toString test 1 failed!");
		}else{
			System.out.println("toString test 1 passed!");
			points += 3;
		}
		}catch(Exception e){
			System.out.println("toString test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}
	//Test 2
	//////////////////////////////
		try{
        A.insert("12", "one");
        B.insert("21", "two");
        A.insert("21", "two");
        B.insert("12", "one");
        if (A.toString().equals(B.toString())){
			System.out.println("toString test 2 failed!");
		}else{
			System.out.println("toString test 2 passed!");
			points += 3;
		}
		}catch(Exception e){
			System.out.println("toString test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
		}

	//Test 3
	//////////////////////////////
		try{
        B.delete("21");
        B.insert("21", "two");
        if (!A.toString().equals(B.toString())){
			System.out.println("toString test 3 failed!");
		}else{
			System.out.println("toString test 3 passed!");
			points += 4;
		}
		}catch(Exception e){
			System.out.println("toString test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
		try{
		for(int i = 0; i < 1000; i++){
			A.insert("test" + (i + 1), ""+i);
		}
		A.makeEmpty();
		if(A.size() != 0 && !A.isEmpty()){
			System.out.println("makeEmpty test 1 failed!");
		}else{
			System.out.println("makeEmpty test 1 passed!");
			points += 10;
		}
		}catch(Exception e){
			System.out.println("makeEmpty test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
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
			System.out.println("Exception test 1 passed!");
			points += 1;
			failed = false;
        } catch(Exception e){
			failed = false;
			System.out.println("Exception test 1 failed!");
		}
        if (failed){
			System.out.println("Exception test 1 failed!");
		}

        failed = true;

        try {
          A.insert("test", "123");
          A.insert("test", "123");
        } catch(DuplicateKeyException d) {
          	failed = false;
			System.out.println("Exception test 2 passed!");
			points += 2;
        } catch(Exception e){
			failed = false;
			System.out.println("Exception test 2 failed!");
		}
        if (failed){
			System.out.println("Exception test 2 failed!");
		}

        failed = true;
		boolean exception = false;

		try{
        	for (int i = 0; i < test_range; i++) {
          		A.insert((i + 1) + "", "test" + (i + 1));
        	}
        	for (int i = test_range - 1; i >= 0; i--) {
          		A.delete((i + 1) + "");
          		try{
            		A.delete((i + 1) + "");
          		} catch (KeyNotFoundException k) {
            		failed = false;
          		} catch (Exception e){
					exception = true;
					System.out.println("Exception test 3 failed!");	
					break;		
		  		}	

        	}
		} catch (Exception e){
			
		}
        if (failed && !exception){
			System.out.println("Exception test 3 failed!");
		 }else if (!exception){
			System.out.println("Exception test 3 passed!");
			points += 2;
		}
          failed = true;

		System.out.println("-----------------------------------------");
		System.out.println("Exceptions Test Case score: " + points + "/" + total);
		return points;

	}

	public static void main(String[] args){
		int all_total = 80;
		int all_points = 0;
	
		int total;
		int points;
		
		all_points += dictionaryTests();
		System.out.println("=========================================");
		System.out.println("Total score: " + all_points + "/" + all_total);
		System.out.println("=========================================");
		System.out.println(all_points);
	}

}
