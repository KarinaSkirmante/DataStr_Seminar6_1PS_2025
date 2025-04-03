package datastr;

public class MyNode<Ttype> {
	private Ttype element;
	private MyNode<Ttype> leftChildNode = null;
	private MyNode<Ttype> rightChildNode = null;
	private MyNode<Ttype> parent = null;
	public Ttype getElement() {
		return element;
	}
	public void setElement(Ttype element) {
		if(element != null)
		{
			this.element = element;
		}
		else
		{
			this.element = (Ttype)new Object();
		}
	}
	public MyNode<Ttype> getLeftChildNode() {
		return leftChildNode;
	}
	public void setLeftChildNode(MyNode<Ttype> leftChildNode) {
		this.leftChildNode = leftChildNode;
	}
	public MyNode<Ttype> getRightChildNode() {
		return rightChildNode;
	}
	public void setRightChildNode(MyNode<Ttype> rightChildNode) {
		this.rightChildNode = rightChildNode;
	}
	public MyNode<Ttype> getParent() {
		return parent;
	}
	public void setParent(MyNode<Ttype> parent) {
		this.parent = parent;
	}
	

	public MyNode(Ttype element)
	{
		setElement(element);
	}
	
	public String toString()
	{
		return "" + element;
	}
	
}
