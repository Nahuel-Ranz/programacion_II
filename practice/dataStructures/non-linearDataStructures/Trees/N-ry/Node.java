import java.util.HashSet;

public class Node {
	
	private final String VALUE;
	private int level;
	private HashSet<Node> children;
	
	public Node(String VALUE) { this.VALUE=VALUE;}
	public Node(String VALUE, int level) {
		this.VALUE=VALUE;
		this.level=level;
		this.children=new HashSet<Node>();
	}

	public String getValue() { return VALUE;}
	
	public int getLevel() { return level;}

	public HashSet<Node> getChildren() { return children;}
	
	public boolean addChild(String child) { return children.add(new Node(child, ++level));}

	public boolean removeChild(String child) { return children.remove(new Node(child));}

	public boolean hasChildren() { return children.size()>0;}
	
	public boolean hasChild(String child) { return children.contains(new Node(child));}

	public Node getChild(String child) {
		for(Node check : children) {
			if(new Node(child).equals(check)) { return check;}
		} return null;
	}
	
	@Override
	public int hashCode() {
		String toReturn="";
		for(int i=0; i<VALUE.length(); i++) {
			toReturn+=String.valueOf(Character.hashCode(VALUE.charAt(i)));
		} return Integer.parseInt(toReturn);
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Node ? ((Node)o).getValue().equals(VALUE) : false;
	}
}
