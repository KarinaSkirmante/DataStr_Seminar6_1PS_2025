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
	
	public void print() throws Exception{
		if(isEmpty())
		{
			throw new Exception("BST ir tukšs, līdz ar to nav iespējams izprintēt elementus");
		}
		
		printHelp(root);
		
	}
	
	private void printHelp(MyNode<Ttype> currentNode) {
	
		System.out.println("P ->" + currentNode.getElement());
		
		
		//pārbaudam, vai eksistē kreisais bērns
		if(currentNode.getLeftChildNode() != null)
		{
			System.out.println("Kreisais bērns: " 
					+ currentNode.getLeftChildNode().getElement()
					+ " (" + currentNode.getElement() + ")");
			printHelp(currentNode.getLeftChildNode());
		}
		
		//pārbaudām, vai eksistē labais bērns
		if(currentNode.getRightChildNode() != null)
		{
			System.out.println("Labais bērns: " 
					+ currentNode.getRightChildNode().getElement()
					+ " (" + currentNode.getElement() + ")");
			printHelp(currentNode.getRightChildNode());
		}
		
	}
	
	public boolean search(Ttype searchElement) throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("BST ir tukšs, līdz ar to nav iespējams meklēt elementus");
		}
		
		if(searchElement == null)
		{
			throw new Exception("Padotais elements nedrīkst būt kā null");
		}
		
		return searchHelp(root, searchElement);
	}
	
	
	private boolean searchHelp(MyNode<Ttype> currentNode, Ttype searchElement)
	{
		//pārbaudam, vai currentNode elements sakrīt ar melkēto
		if(currentNode.getElement().equals(searchElement))
		{
			return true;
		}//veikt meklēšanu tālāk pa kreiso vai labo pusi
		else
		{
			//jāturpina meklēšana pa labo pusi
			if( ((Comparable)searchElement).compareTo(currentNode.getElement()) == 1 )
			{
				//ja labais bērns eksistē, tad turpinām pa labo pusi
				if(currentNode.getRightChildNode() != null)
				{
					//return jālieto tad, ja rekursīva funkcija nav void
					return searchHelp(currentNode.getRightChildNode(), searchElement);
				}
			}
			//jāturpina meklēšana pa kreiso pusi
			else if( ((Comparable)searchElement).compareTo(currentNode.getElement()) == -1 )
			{
				if(currentNode.getLeftChildNode() != null)
				{
					return searchHelp(currentNode.getLeftChildNode(), searchElement);
				}
			}
		}
		
		return false;
	}

	
	// delete
	// -----------------------------SĀKAS PIEVIENOTAIS KODA FRAGMENTS--------------------------

		public void delete(Ttype element) throws Exception {
			if (isEmpty()) {
				throw new Exception("BST is empty and it is not possible to delete element");
			}

			if (!search(element)) // ja nebūs atrasts elements, ko grib dzest
			{
				throw new Exception("Element doesn't exists in BST and it is not possible to delete it");
			}

			deleteHelper(element, root);

		}

		private void deleteHelper(Ttype element, MyNode<Ttype> currentNode) {
			// TODO samazinār coutner, pie atrastā elementa
			// ja sakritīs, tad dzēsīsim
			if (element.equals(currentNode.getElement())) {
				// ja currentNode mezgls ir kā lapa
				if (currentNode.getLeftChildNode() == null && currentNode.getRightChildNode() == null) {
					MyNode<Ttype> parentOfCurrentNode = currentNode.getParent();

					// jānoņem saite uz kreiso bērnu
					if (parentOfCurrentNode.getLeftChildNode().getElement().equals(element)) {
						parentOfCurrentNode.setLeftChildNode(null);
					} else if (parentOfCurrentNode.getRightChildNode().getElement().equals(element)) {
						parentOfCurrentNode.setRightChildNode(null);
					}

				}

				// ja currentNode mezglam ir tikai viens bērns
				// gadījums, kad ir tikai labais bērns
				else if (currentNode.getLeftChildNode() == null && currentNode.getRightChildNode() != null) {
					MyNode<Ttype> parentOfCurrentNode = currentNode.getParent();
					MyNode<Ttype> rightChildOCurrentNode = currentNode.getRightChildNode();

					parentOfCurrentNode.setRightChildNode(rightChildOCurrentNode);
					rightChildOCurrentNode.setParent(parentOfCurrentNode);
				}
				// ir tikai kreisais bērns
				else if (currentNode.getLeftChildNode() != null && currentNode.getRightChildNode() == null) {
					MyNode<Ttype> parentOfCurrentNode = currentNode.getParent();
					MyNode<Ttype> leftChildOCurrentNode = currentNode.getLeftChildNode();

					parentOfCurrentNode.setRightChildNode(leftChildOCurrentNode);
					leftChildOCurrentNode.setParent(parentOfCurrentNode);
				}
				// ja currentNode mezglam ir abi bērni
				else if (currentNode.getLeftChildNode() != null && currentNode.getRightChildNode() != null) {
					
					// Caur labo pusi, meklēs "kreisāko bērnu"
					MyNode<Ttype> temp = root.getRightChildNode();
					// ja labajam bērnam nav neviens kreisajā pusē piesaistīts, tad pašu labo bērnu
					// jāieliek dzēšamajā vietā
					if (temp.getLeftChildNode() == null) {
						currentNode.setElement(temp.getElement());
						currentNode.setRightChildNode(temp.getRightChildNode());
						temp.getRightChildNode().setParent(currentNode);
					} else // ja labajam bērnam ir piesaistīts kreisais bērns, tad tiek meklēts arī kreisā
							// bērna kreisais bērns utt
					{
						while (temp.getLeftChildNode() != null) {
							temp = temp.getLeftChildNode();
						}
						// temp2 - būs ar to vērtību, kas ir jāieliek ieks tempNode
						currentNode.setElement(temp.getElement());

						// var gadīties, ka mezglu, kuru vērtību pārvietos uz dzēšamo mezglu, ir
						// piesaistīts labais bērns, tad šo labo bērnu vecākma jāuztaisa kā kreiso
						if (temp.getRightChildNode() != null) {
							MyNode<Ttype> parent = temp.getParent();
							MyNode<Ttype> rightCh = temp.getRightChildNode();
							parent.setLeftChildNode(rightCh);
							rightCh.setParent(parent);
						} else // ja mezgls ir kā lapa, tad var uz to vienkārsi noņemt sasaisti no vecāka puses
						{
							// noņemam sasaisti vecākam uz to mezglu, kura vērtību uzlika dzēšamajā vietā
							MyNode<Ttype> parent = temp.getParent();
							if (parent.getLeftChildNode().equals(temp)) {
								parent.setLeftChildNode(null);
							} else if (parent.getRightChildNode().equals(temp)) {
								parent.setRightChildNode(null);
							}
						}
					}
					
				}
			} else {
				// ja elements ir lielāks par currentNode elementu
				if (((Comparable) element).compareTo(currentNode.getElement()) == 1) {
					// izsaucam rekursiju, tikai tad, ja labajā pusē ir piesiastīts bērns
					if (currentNode.getRightChildNode() != null) {
						deleteHelper(element, currentNode.getRightChildNode());
					}
				} else if (((Comparable) element).compareTo(currentNode.getElement()) == -1) {
					// izsaucam rekursiju, tikai tad, ja kreisajā pusē ir piesiastīts bērns
					if (currentNode.getLeftChildNode() != null) {
						deleteHelper(element, currentNode.getLeftChildNode());
					}
				}

			}
		}
		// -----------------------------BEIDZAS PIEVIENOTAIS KODA FRAGMENTS--------------------------

}
