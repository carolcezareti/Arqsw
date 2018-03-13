public class AvlNode extends BinaryNode
{
	int height;

	public AvlNode( Comparable elem, AvlNode l, AvlNode r ){
		super(elem, l, r);
		height = max(height(l), height(r)) + 1;
	}

	public AvlNode( Comparable elem ) {
		this( elem, null, null );
	}

	public BinaryNode insert(Comparable x) {
		if (x.compareTo(this.element) < 0)
			if (this.left != null) {
				this.left = this.left.insert(x);
				if (height((AvlNode)this.left) - height((AvlNode)this.right) == 2)
				if (x.compareTo(this.left.element) < 0)
					return this.rotateWithLeftChild();
				else return this.doubleWithLeftChild();
			} else this.left = new AvlNode(x, null, null);
		else if (x.compareTo(this.element) > 0)
			if (this.right != null) {
				this.right = this.right.insert(x);
				if (height((AvlNode)this.right) - height((AvlNode)this.left) == 2)
				if (x.compareTo(this.right.element) > 0)
					return this.rotateWithRightChild();
				else return this.doubleWithRightChild();
			} else this.right = new AvlNode(x, null, null);
		else ;
		this.height = max(height((AvlNode)this.left), height((AvlNode)this.right)) + 1;
		return this;
	}


	private AvlNode rotateWithLeftChild()
	{
		AvlNode k1 = (AvlNode) this.left;
		this.left = k1.right;
		k1.right = this;
		this.height = max(height((AvlNode) this.left), height((AvlNode) this.right)) + 1;
		k1.height = max(height((AvlNode) k1.left), height((AvlNode) k1.right)) + 1;
		return k1;
	}

	private AvlNode rotateWithRightChild()
	{
		AvlNode k1 = (AvlNode) this.right;
		this.right = k1.left;
		k1.left = this;
		this.height = max(height((AvlNode) this.left), height((AvlNode) this.right)) + 1;
		k1.height = max(height((AvlNode) k1.left), height((AvlNode) k1.right)) + 1;
		return k1;
	}

	private AvlNode doubleWithLeftChild()
	{
		this.left = ((AvlNode) this.left).rotateWithRightChild(); 
		return this.rotateWithLeftChild(); 
	}

	private AvlNode doubleWithRightChild()
	{
		this.right = ((AvlNode) this.right).rotateWithLeftChild(); 
		return this.rotateWithRightChild(); 
	}

	public BinaryNode remove(Comparable x) {
		System.out.println("Remove not implemented!");
		return this;
	}

	private static int max(int a, int b)
	{
		return a > b ? a : b;
	}

	private static int height(AvlNode n)
	{
		return n == null ? -1 : n.height;
	}


}
