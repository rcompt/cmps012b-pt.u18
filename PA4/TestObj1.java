public class TestObj1{
	int item;

	public TestObj1(int val){
		this.item = val;
	}

	public String toString(){
		return "" + this.item;
	}
	
	public boolean equals(TestObj1 obj){
		if(obj == null){
			return false;
		}
		if(this.item == obj.item){
			return true;
		}
		return false;
	}
}