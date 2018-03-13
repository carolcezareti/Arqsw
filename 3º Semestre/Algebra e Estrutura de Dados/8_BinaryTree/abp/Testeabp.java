class Testeabp {
	public static void main( String argv[] ) {
		BinarySearchTree t;

		t = new BinarySearchTree();
		
		t.insert( new MyInteger( 2 ) );
		t.insert( new MyInteger( 1 ) );
		t.insert( new MyInteger( 6 ) );
		t.insert( new MyInteger( 4 ) );
		t.printTree();
		t.insert( new MyInteger( 8 ) );
		t.printTree();
		t.remove( new MyInteger( 6 ) );
		t.printTree();
		t.remove( new MyInteger( 1 ) );
		t.printTree();
		t.remove( new MyInteger( 2 ) );
		t.printTree();

	}
}
