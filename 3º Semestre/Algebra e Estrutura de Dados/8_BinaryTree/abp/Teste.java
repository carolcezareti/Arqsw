class Teste {
	public static void main( String argv[] ) {
		AvlTree t;

		t = new AvlTree();
		
		t.insert( new MyInteger( 3 ) );
		t.insert( new MyInteger( 2 ) );
		t.printTree();
		t.insert( new MyInteger( 1 ) );
		t.printTree();
		t.insert( new MyInteger( 4 ) );
		t.printTree();
		t.insert( new MyInteger( 5 ) );
		t.printTree();
		t.insert( new MyInteger( 6 ) );
		t.insert( new MyInteger( 7 ) );
		t.printTree();
		t.insert( new MyInteger( 16 ) );
		t.insert( new MyInteger( 15 ) );
		t.insert( new MyInteger( 14 ) );
		t.insert( new MyInteger( 13 ) );
		t.insert( new MyInteger( 12 ) );
		t.insert( new MyInteger( 11 ) );
		t.insert( new MyInteger( 10 ) );
		t.insert( new MyInteger( 8 ) );
		t.insert( new MyInteger( 9 ) );
		t.printTree();
		t.remove( new MyInteger( 6 ) );
		t.printTree();

	}
}
