public class ModelQueueTest{

	public static int queueTests(){
		int points = 0;

		points += enqueueTests();
		points += dequeueTests();
		points += isEmptyTests();
		points += lengthTests();
		points += peekTests();
		points += dequeueAllTests();
		points += toStringTests();

		return points;
	}

	//Test Cases for isEmpty
	//////////////////////////////
	public static int isEmptyTests(){
		int points = 0;
		int total = 4;
		Queue A = new Queue();
		Queue B = new Queue();
		int testSize = 10000;

		System.out.println("=========================================");
		System.out.println("isEmptyTest Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			if(A.isEmpty() && B.isEmpty()){
				System.out.println("isEmpty test 1 passed!");
				points += 1;
			}else{
				System.out.println("isEmpty test 1 failed!");
			}
		}catch(Exception e){
			System.out.println("isEmpty test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}

	//Test 2
	//////////////////////////////	
		try{
			for(int i = 0; i < testSize; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < testSize; i++){
				TestObj1 obj = (TestObj1) A.dequeue();
			}
			if(A.isEmpty()){
				System.out.println("isEmpty test 2 passed!");
				points += 1;
			}else{
				System.out.println("isEmpty test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("isEmpty test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			for(int i = 0; i < testSize; i++){
				B.enqueue(new TestObj1(i));
			}
			B.dequeueAll();
			if(B.isEmpty()){
				System.out.println("isEmpty test 3 passed!");
				points += 1;
			}else{
				System.out.println("isEmpty test 3 failed!");
			} 						
		}catch(Exception e){
			System.out.println("isEmpty test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			B = new Queue();
			B.enqueue(new TestObj1(1));
			if(!B.isEmpty()){
				System.out.println("isEmpty test 4 passed!");
				points += 1;
			}else{
				System.out.println("isEmpty test 4 failed!");
			} 				
		}catch(Exception e){
			System.out.println("isEmpty test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("isEmpty Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for length
	//////////////////////////////
	public static int lengthTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();

		System.out.println("=========================================");
		System.out.println("length Test Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			if(A.length() == B.length()){
				System.out.println("length test 1 passed!");
				points += 1;
			}else{
				System.out.println("length test 1 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
			}
			if(A.length() != B.length() && A.length() == 10000){
				System.out.println("length test 2 passed!");
				points += 1;
			}else{
				System.out.println("length test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			for(int i = 0; i < 5000; i++){
				TestObj1 test = (TestObj1) A.dequeue();
			}
			if(A.length() != B.length() && A.length() == 5000){
				System.out.println("length test 3 passed!");
				points += 1;
			}else{
				System.out.println("length test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			for(int i = 0; i < 5000; i++){
				B.enqueue(new TestObj1(i));
			}
			if(A.length() == B.length() && B.length() == 5000){
				System.out.println("length test 4 passed!");
				points += 1;
			}else{
				System.out.println("length test 4 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			B.dequeueAll();
			if(A.length() != B.length() && B.length() == 0){
				System.out.println("length test 5 passed!");
				points += 1;
			}else{
				System.out.println("length test 5 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			for(int i = 0; i < 5000; i++){
				TestObj1 test = (TestObj1) A.dequeue();
			}
			if(A.length() == B.length() && A.length() == 0){
				System.out.println("length test 6 passed!");
				points += 1;
			}else{
				System.out.println("length test 6 failed!");
			} 
		}catch(Exception e){
			System.out.println("length test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("length Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for enqueue
	//////////////////////////////
	public static int enqueueTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();
		
		System.out.println("=========================================");
		System.out.println("enqueue Test Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(1));
			if(A.length() != B.length() && A.length() == 1 && !A.isEmpty()){
				System.out.println("enqueue test 1 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 1 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(2));
			A.enqueue(new TestObj1(3));
			A.enqueue(new TestObj1(4));
			if(A.length() == 4 && !A.isEmpty()){
				System.out.println("enqueue test 2 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				B.enqueue(new TestObj1(i));
			}
			if(B.length() == 10000 && !B.isEmpty()){
				System.out.println("enqueue test 3 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			TestObj1 obj = new TestObj1(0);
			if(((TestObj1)B.peek()).equals(obj)){
				System.out.println("enqueue test 4 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 4 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			A = new Queue();
			TestObj1 obj = new TestObj1(1);
			A.enqueue(new TestObj1(1));
			for(int i = 2; i < 1000; i++){
				A.enqueue(new TestObj1(i));
			}
			if(((TestObj1)A.dequeue()).equals(obj)){
				System.out.println("enqueue test 5 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 5 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			B = new Queue();
			TestObj1 obj = new TestObj1(999);
			TestObj1 obj2 = new TestObj1(0);
			for(int i = 0; i < 1000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 1000; i++){
				obj2 = (TestObj1) B.dequeue();
			}			
			if(obj.equals(obj2)){
				System.out.println("enqueue test 6 passed!");
				points += 1;
			}else{
				System.out.println("enqueue test 6 failed!");
			} 
		}catch(Exception e){
			System.out.println("enqueue test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("enqueue Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for dequeue
	//////////////////////////////
	public static int dequeueTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();

		System.out.println("=========================================");
		System.out.println("dequeue Test Cases");
		System.out.println("-----------------------------------------");


	//Test 1
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(1));
			TestObj1 obj = (TestObj1) A.dequeue();
			if(A.length() == B.length() && A.length() == 0 && A.isEmpty()){
				System.out.println("dequeue test 1 passed!");
				points += 1;
			}else{
				System.out.println("dequeue test 1 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeue test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			for(int i = 0; i < 100; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 99; i++){
				TestObj1 obj = (TestObj1) A.dequeue();
			}
			if(A.length() != B.length() && A.length() == 1 && !A.isEmpty()){
				System.out.println("dequeue test 2 passed!");
				points += 1;
			}else{
				System.out.println("dequeue test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeue test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 9000; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			if(A.length() != B.length() && B.length() == 1000 && !B.isEmpty()){
				System.out.println("dequeue test 3 passed!");
				points += 1;
			}else{
				System.out.println("dequeue test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeue test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			B = new Queue();
			for(int i = 0; i < 100; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 50; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			for(int i = 0; i < 1000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 500; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			if(A.length() != B.length() && B.length() == 550 && !B.isEmpty()){
				System.out.println("dequeue test 4 passed!");
				points += 1;
			}else{
				System.out.println("dequeue test 4 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeue test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			B = new Queue();
			B.dequeue();
			System.out.println("dequeue test 5 failed!");
		}catch(QueueEmptyException e){
			System.out.println("dequeue test 5 passed!");
			points += 1;
		}catch(Exception e){
			System.out.println("dequeue test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			A = new Queue();
			B = new Queue();
			TestObj1 obj6 = new TestObj1(0);
			TestObj1 obj7 = new TestObj1(0);
			for(int i = 1; i <= 100; i++){
				A.enqueue(new TestObj1(i));
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 50; i++){
				obj6 = (TestObj1) B.dequeue();
			}
			for(int i = 0; i < 100; i++){
				obj7 = (TestObj1) A.dequeue();
			}
			for(int i = 101; i <= 1000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 1; i <= 1000; i++){
				A.enqueue(new TestObj1(i+50));
			}
			for(int i = 1; i <= 50; i++){
				obj6 = (TestObj1) B.dequeue();
				obj7 = (TestObj1) A.dequeue();
			}
			if(obj6.equals(obj7)){
				System.out.println("dequeue test 6 passed!");
				points += 1;
			}else{
				System.out.println("dequeue test 6 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeue test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("dequeue Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for peek
	//////////////////////////////
	public static int peekTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();

		System.out.println("=========================================");
		System.out.println("peek Test Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(1));
			if(((TestObj1)A.peek()).equals(new TestObj1(1))){
				System.out.println("peek test 1 passed!");
				points += 1;
			}else{
				System.out.println("peek test 1 failed!");
			} 
		}catch(Exception e){
			System.out.println("peek test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			B.enqueue(new TestObj1(1));
			if(((TestObj1)B.peek()).equals((TestObj1)A.peek())){
				System.out.println("peek test 2 passed!");
				points += 1;
			}else{
				System.out.println("peek test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("peek test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			B = new Queue();
			for(int i = 0; i < 10000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 9000; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			if(((TestObj1)B.peek()).equals(new TestObj1(9000))){
				System.out.println("peek test 3 passed!");
				points += 1;
			}else{
				System.out.println("peek test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("peek test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			B = new Queue();
			for(int i = 0; i < 100; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 50; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			for(int i = 0; i < 1000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 500; i++){
				TestObj1 obj = (TestObj1) B.dequeue();
			}
			if(((TestObj1)B.peek()).equals(new TestObj1(450))){
				System.out.println("peek test 4 passed!");
				points += 1;
			}else{
				System.out.println("peek test 4 failed!");
			} 
		}catch(Exception e){
			System.out.println("peek test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			B = new Queue();
			B.peek();
			System.out.println("peek test 5 failed!");						
		}catch(QueueEmptyException e){
				System.out.println("peek test 5 passed!");
				points += 1;			
		}catch(Exception e){
			System.out.println("peek test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			A = new Queue();
			B = new Queue();
			TestObj1 obj6 = new TestObj1(0);
			TestObj1 obj7 = new TestObj1(0);
			for(int i = 1; i <= 100; i++){
				A.enqueue(new TestObj1(i));
				B.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 50; i++){
				obj6 = (TestObj1) B.dequeue();
			}
			for(int i = 0; i < 100; i++){
				obj7 = (TestObj1) A.dequeue();
			}
			for(int i = 101; i <= 1000; i++){
				B.enqueue(new TestObj1(i));
			}
			for(int i = 1; i <= 1000; i++){
				A.enqueue(new TestObj1(i+50));
			}
			for(int i = 1; i <= 50; i++){
				obj6 = (TestObj1) B.dequeue();
				obj7 = (TestObj1) A.dequeue();
			}
			if(((TestObj1)B.peek()).equals((TestObj1)A.peek())){
				System.out.println("peek test 6 passed!");
				points += 1;
			}else{
				System.out.println("peek test 6 failed!");
			} 
		}catch(Exception e){
			System.out.println("peek test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("peek Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for dequeueAll
	//////////////////////////////
	public static int dequeueAllTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();

		System.out.println("=========================================");
		System.out.println("dequeueAll Test Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(1));
			A.dequeueAll();
			if(A.isEmpty()){
				System.out.println("dequeueAll test 1 passed!");
				points += 1;
			}else{
				System.out.println("dequeueAll test 1 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeueAll test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
			}
			A.dequeueAll();
			if(A.isEmpty() && A.length() == 0){
				System.out.println("dequeueAll test 2 passed!");
				points += 1;
			}else{
				System.out.println("dequeueAll test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeueAll test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 500; i++){
				TestObj1 obj = (TestObj1) A.dequeue();				
			}
			A.dequeueAll();
			if(A.isEmpty() && A.length() == 0){
				System.out.println("dequeueAll test 3 passed!");
				points += 1;
			}else{
				System.out.println("dequeueAll test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("dequeueAll test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 10000; i++){
				TestObj1 obj = (TestObj1) A.dequeue();				
			}
			A.dequeueAll();
			System.out.println("dequeueAll test 4 failed!");						
		}catch(QueueEmptyException e){
			System.out.println("dequeueAll test 4 passed!");
			points += 1;	
		}catch(Exception e){
			System.out.println("dequeueAll test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 5000; i++){
				TestObj1 obj = (TestObj1) A.dequeue();				
			}
			for(int i = 0; i < 5000; i++){
				A.enqueue(new TestObj1(i));
			}
			for(int i = 0; i < 10000; i++){
				TestObj1 obj = (TestObj1) A.dequeue();				
			}
			A.dequeueAll();
			System.out.println("dequeueAll test 5 failed!");						
		}catch(QueueEmptyException e){
			System.out.println("dequeueAll test 5 passed!");
			points += 1;	
		}catch(Exception e){
			System.out.println("dequeueAll test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			for(int i = 0; i < 10000; i++){
				A.enqueue(new TestObj1(i));
				TestObj1 obj = (TestObj1) A.dequeue();	
			}
			A.dequeueAll();
			System.out.println("dequeueAll test 6 failed!");						
		}catch(QueueEmptyException e){
			System.out.println("dequeueAll test 6 passed!");
			points += 1;
		}catch(Exception e){
			System.out.println("dequeueAll test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("dequeueAll Test Case score: " + points + "/" + total);
		return points;
	}

	//Test Cases for toString
	//////////////////////////////
	public static int toStringTests(){
		int points = 0;
		int total = 6;
		Queue A = new Queue();
		Queue B = new Queue();

		System.out.println("=========================================");
		System.out.println("toString Test Cases");
		System.out.println("-----------------------------------------");

	//Test 1
	//////////////////////////////	
		try{
			A.enqueue(new TestObj1(1));
			if(A.toString().equals("1 ")){
				System.out.println("toString test 1 passed!");
				points += 1;
			}else{
				System.out.println("toString test 1 failed!");
			} 			
		}catch(Exception e){
			System.out.println("toString test 1 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 2
	//////////////////////////////	
		try{
			B.enqueue(new TestObj1(1));
			if(A.toString().equals(B.toString())){
				System.out.println("toString test 2 passed!");
				points += 1;
			}else{
				System.out.println("toString test 2 failed!");
			} 
		}catch(Exception e){
			System.out.println("toString test 2 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 3
	//////////////////////////////	
		try{
			B = new Queue();
			String testStr = "";
			for(int i = 0; i < 1000; i++){
				B.enqueue(new TestObj1(i));
				testStr += i + " ";
			}
			if(B.toString().equals(testStr)){
				System.out.println("toString test 3 passed!");
				points += 1;
			}else{
				System.out.println("toString test 3 failed!");
			} 
		}catch(Exception e){
			System.out.println("toString test 3 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 4
	//////////////////////////////	
		try{
			B = new Queue();
			String testStr = "";
			for(int i = 0; i < 100; i++){
				Job job = new Job(i,i*2);
				B.enqueue(job);
				testStr += job.toString() + " ";
			}
			if(B.toString().equals(testStr)){
				System.out.println("toString test 4 passed!");
				points += 1;
			}else{
				System.out.println("toString test 4 failed!");
			} 
		}catch(Exception e){
			System.out.println("toString test 4 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 5
	//////////////////////////////	
		try{
			B = new Queue();
			String testStr = "";
			for(int i = 0; i < 100; i++){
				Job job = new Job(i,i*2);
				B.enqueue(job);
				testStr += job.toString() + " ";
			}
			if(B.toString().equals(testStr)){
				System.out.println("toString test 5 passed!");
				points += 1;
			}else{
				System.out.println("toString test 5 failed!");
			} 
		}catch(Exception e){
			System.out.println("toString test 5 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
	//Test 6
	//////////////////////////////	
		try{
			A = new Queue();
			String testStr = "";
			for(int i = 0; i < 100; i++){
				Job job = new Job(i,i*2);
				A.enqueue(job);
			}
			if(B.toString().equals(A.toString())){
				System.out.println("toString test 6 passed!");
				points += 1;
			}else{
				System.out.println("toString test 6 failed!: " + B.peek());
			} 
		}catch(Exception e){
			System.out.println("toString test 6 failed from Runtime Error!");
			System.out.println("Exception: " + e);			
			System.out.println("Try running this test outside of this testing class and see where the exception occurs\n");
		}
		System.out.println("-----------------------------------------");
		System.out.println("toString Test Case score: " + points + "/" + total);
		return points;
	}

	public static void main(String[] args){
		int all_total = 40;
		int all_points = 0;
	
		int total;
		int points;
		
		all_points += queueTests();
		System.out.println("=========================================");
		System.out.println("Total score: " + all_points + "/" + all_total);
		System.out.println("=========================================");
		//System.out.println(all_points);
	}

}