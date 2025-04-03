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
	
	public void add(Ttype element) throws Exception
	{
		if(element == null)
		{
			throw new Exception("Padotais elements nedrīkst būt kā null");
		}
		
		if(isFull())
		{
			throw new Exception("BST ir pilns un nevar pievienot jaunu elementu");
		}
		
		if(isEmpty())//ja ir jāievieto pirmais elements
		{
			MyNode<Ttype> newNode = new MyNode<Ttype>(element);
			root = newNode;
			counter++;
		}
		else//ja ir jāievieto pārejie elementi
		{
			addHelper(root, element);
			counter++;
		}
		
	}
	
	private void addHelper(MyNode<Ttype>  currentNode, Ttype newElement)
	{
		//ja jaunais elements ir lielāks par esošo mezglu, tad jaunais elements būs labajā puse
		if(  ((Comparable)newElement).compareTo(currentNode.getElement()) == 1   )
		{
			//ja nekas nav labajā pusē, tad pievienojam jauno mezglu ka labo bērnu
			if(currentNode.getRightChildNode() == null)
			{
				
				MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
				
				currentNode.setRightChildNode(newNode);
				newNode.setParent(currentNode);
			}
			else //labajā pusē nav vietas, tāpēc izsauc funkciju rekursīvi, bet uz labo bērnu
			{
				addHelper(currentNode.getRightChildNode(), newElement);
			}
		}
		//ja jaunais elements ir mazaāks par esošo mezglu, tad jaunais elements būs kreisajā puse
 		else if(  ((Comparable)newElement).compareTo(currentNode.getElement()) == -1   )
 		{
 			//ja nekas nav kreisajā pusē, tad pievienojam jauno mezglu kā kreiso bērnu
 			if(currentNode.getLeftChildNode() == null)
 			{
 				MyNode<Ttype> newNode = new MyNode<Ttype>(newElement);
 				currentNode.setLeftChildNode(newNode);
 				newNode.setParent(currentNode);
 			}
 			else  //kreisajā pusē nav vietas, tāpēc izsauc funkciju rekursīvi, bet uz kreiso bērnu
 			{
 				addHelper(currentNode.getLeftChildNode(), newElement);
 			}
 				
 		}
	}
	
	
	
}
