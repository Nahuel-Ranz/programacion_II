import java.util.ArrayList;

public class TreeNry {
	
	private Node root;
	private Node explorer;
	private int size;

	private TreeNry() { }
	public TreeNry(String root) {
		this.root=new Node(root, 0);
		explorer=this.root;
		
		size=1;
	}
	
	public Node getRoot() { return root;}
	public Node getExplorer() { return explorer;}
	public int getExplorerLevel() { return explorer.getLevel();}
	public int size() { return size;}
	
	public boolean explorerToChild(String node){
		if(explorer.hasChild(node)) {
			explorer=explorer.getChild(node);
			return true;
		} return false;
	}
	
	public void explorerToRoot() { explorer=root;}
	
	public boolean add(String node) {
		if(explorer.addChild(node)) { size++; return true;}
		return false;
	}
	
	public boolean remove(String node) {
		if(explorer.hasChild(node)) {
		
			
			size--;
			return true;
		}
		return false;
	}

	private void isolateNode(Node node) {
		
	}

/*	public boolean add(String node, String father, int fatherLevel) {
		
		if(root == null) { root=new Node(node);}
		
	}*/
}
