public class BinarySearchTree
{
	
	BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public Comparable find( Comparable x ) {
		if (!this.isEmpty())
			if (root.find(x) != null)
				return root.find(x).elementAt(); 
			else return null;
		else return null;
	}

	public Comparable findMin() {	
		if (!this.isEmpty())
			if (root.findMin() != null)
				return root.findMin().elementAt(); 
			else return null;
		else return null;
	}

	public Comparable findMax() {	
		if (!this.isEmpty())
			if (root.findMax() != null)
				return root.findMax().elementAt(); 
			else return null;
		else return null;
	}
	
	public void insert(Comparable x) { 
		if (!this.isEmpty())
			root = root.insert(x);
		else root = new BinaryNode(x, null, null);
	}

	public void remove(Comparable x) { 
		if (!this.isEmpty())
			root = root.remove(x);
	}

	public void printTree() {
		if (!this.isEmpty())
			root.printTree(0);
		System.out.println();
	}

}
