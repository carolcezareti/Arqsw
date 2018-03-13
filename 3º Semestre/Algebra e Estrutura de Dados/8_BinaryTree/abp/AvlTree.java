public class AvlTree extends BinarySearchTree
{
	
	public AvlTree() {
		root = null;
	}

	public void insert(Comparable x) { 
		if (!this.isEmpty())
			root = root.insert(x);
		else root = new AvlNode(x);
	}

}
