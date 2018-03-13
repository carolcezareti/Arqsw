public class MyInteger implements Comparable {

private int v;

public MyInteger(int x) { v = x; }

public int intValue() { return v; }

public int compareTo(Comparable r) {

return v < ((MyInteger) r).v ? -1 :
	v == ((MyInteger) r).v ? 0 : 1;

}

public String toString() { return (new Integer(this.intValue())).toString(); }
}
