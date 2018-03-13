public class BinaryNode 
{
	Comparable element;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode( Comparable elem, BinaryNode l, BinaryNode r ){
		element = elem;
		left = l;
		right = r;
	}

	public BinaryNode( Comparable elem ) {
		this( elem, null, null );
	}

	public void printTree(int i) {
		if (this.left != null) this.left.printTree(i+1);
		for (int j = 0; j < i; j++) System.out.print("-");	
		System.out.println(this.element.toString());
		if (this.right != null) this.right.printTree(i+1);
	}

	public Comparable elementAt() {
		return this.element; 
	}

	public BinaryNode find(Comparable x) {
		if (x.compareTo(this.element) < 0)
			if (this.left != null)
				return this.left.find(x);
			else return null;
		else if (x.compareTo(this.element) > 0)
			if (this.right != null)
				return this.right.find(x);
			else return null;
		else return this;
	}

	public BinaryNode findMin() {
		if (this.left == null) return this;
		return this.left.findMin();
	}

	public BinaryNode findMax() {
		if (this.right == null) return this;
		return this.right.findMax();
	}

	public BinaryNode insert(Comparable x) {
		if (x.compareTo(this.element) < 0)
			if (this.left != null)
				this.left = this.left.insert(x);
			else this.left = new BinaryNode(x, null, null);
		else if (x.compareTo(this.element) > 0)
			if (this.right != null)
				this.right = this.right.insert(x);
			else this.right = new BinaryNode(x, null, null);
		else ;
		return this;
	}

	public BinaryNode remove(Comparable x) {
		if (x.compareTo(this.element) < 0)
			if (this.left != null)
				this.left = this.left.remove(x);
			else ;
		else if (x.compareTo(this.element) > 0)
			if (this.right != null)
				this.right = this.right.remove(x);
			else ;
		else if (this.left != null && this.right != null) {
			this.element = this.right.findMin().element;
			this.right = this.right.remove(this.element);
		} else return (this.left != null) ? this.left : this.right;
		return this;
	}

}
