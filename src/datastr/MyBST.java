package datastr;

public class MyBST<Ttype> {

	private MyNode<Ttype> root = null;
	private int counter = 0;
	
	//neveidošu beazrgumenta konstruktoru, jo tas ir jau no Object klases pieejams
	
	
	public boolean isFull()//koks būs pilns, ja RAM atmiņā nebūs vietas 
	{
		try
		{
			MyNode<Integer> newNode = new MyNode<Integer>(4);
			return false;
			
		}
		catch (OutOfMemoryError e) {
			return true;
		}
	}
	
	
	public boolean isEmpty() {
		return (counter == 0);
	}

	public int howManyElements() {
		return counter;
	}
	
	
	
	
}
