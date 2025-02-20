import java.util.Stack;
import java.util.Queue;

public class NryTreeNoDegree {
	
	private Node root;
	private Stack<Node> explorer;
	private int size;
	private static Stack<Node> auxiliaries;
	private static Queue<Node> show;

	private NryTreeNoDegree { }
	public NryTreeNoDegree(String root) {
		this.root=new Node(root, 0);
		explorer=new Stack<Node>();
		explorer.push(this.root);
		
		size=1;
	}
	
	public Node getRoot() { return root;}
	public Node getExplorer() { return explorer.peek();}
	public int getExplorerLevel() { return explorer.peek().getLevel();}
	public int size() { return size;}
	
	public boolean explorerToChild(String node){
		if(explorer.peek().hasChild(node)) {
			explorer.push(explorer.peek().getChild(node));
			return true;
		} return false;
	}
	
	public void goBackExplorer() { if(!explorer.peek().equals(this.root)) { explorer.pop();}}
	private void explorerToRoot() { explorer.clear(); explorer.push(this.root);}
	
	public boolean add(String node) {
		if(explorer.peek().addChild(node)) { size++; return true;}
		return false;
	}
	
	public boolean remove(String node) {
		if(!explorer.peek().hasChild(node)) { return false;}

		size-=(numberOfDescendents(explorer.peek().getChild(node))+1);
		return explorer.peek().removeChild(node);
	}
	
	public int numberOfDescendents(Node node) {
		if(!node.hasChildren()) { return 0;}

		int toReturn=0;
		for(Node check : node.getChildren()) {
			toReturn+=1+ numberOfDescendents(check);
		} return toReturn;
	}

	public String pathToExplorer() {
		if(explorer.peek().equals(this.root)) { "{ "+ root.getValue()+ " }";}

		NryTreeNoDegree.auxiliaries.clear();
		explorerToAuxiliaries(this.explorer.size());
		return "{ "+ pathToExplorer()+ " }";
	}

	private String pathToExplorer() {
		explorer.push(NryTreeNoDegree.auxiliaries.pop());
		if(NryTreeNoDegree.auxiliaries.size() == 0) { return explorer.peek().getValue();}
		
		return explorer.peek().getValue()+ " > "+ pathToExplorer();
	}

	private void explorerToAuxiliaries(int explorerSize) {
		if(explorerSize > 0) {
			NryTreeNoDegree.auxiliaries.push(explorer.pop());
			explorerToAuxiliaries(explorer.size());
		}
	}

	public String allSubNodesOf(Node node) {
		NryTreeNoDegree.show=new Queue<Node>();
		NryTreeNoDegree.show.offer(node);

		return offerSubNodes();
	}

	private String offerSubNodes() {
		String toReturn="\n";

		if(NryTreeNoDegree.show.size() == 1) {
			
		} return "";
	}
}
