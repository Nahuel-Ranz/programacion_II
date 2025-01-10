import java.util.HashMap;
import java.util.HashSet;

public class UndirectedGraph {
	
	private Node access;
	private int size;
	private HashSet<String> values; // this is for internal operations.
	
	public UndirectedGraph(){
		access=null;
		size=0;
		values=new HashSet<String>();
	}
	
	public Node getAccess() { return access;}
	
	public int size() { return size;}

	public boolean add(String value){
		if(onlyLetters(value) && size==0){
			access=new Node(value);
			size++; System.out.println("add method");
			return true;
		} return false;
	}

	public boolean add(String value, String adjacentNode, int edge){
		
		if(edge<1 || !onlyLetters(value) || contains(value) || !contains(adjacentNode) || size<1){
			return false;
		}

		Node toAdd=new Node(value);
		Node adjacent=searchNode(adjacentNode);

		toAdd.getAdjacentNodes().put(adjacent, edge);
		adjacent.getAdjacentNodes().put(toAdd, edge);
		
		size++;
		return true;
	}
	
	public Node searchNode(String value) {
		if(onlyLetters(value) && access!=null){
			Node toReturn=searchNode(new Node(value), access);
			values.clear();
			return toReturn;
		}
		return null;
	}

	private Node searchNode(Node nodeToSearch, Node currentNode){
		
		if(currentNode.equals(nodeToSearch)) { return currentNode;}
		values.add(currentNode.getValue());

		Node aux;
		if(values.size()<size){
			for(Node check: currentNode.getAdjacentNodes().keySet()){
				
				if(!values.contains(check.getValue())){
					aux=searchNode(nodeToSearch, check);
					if(aux != null) { return nodeToSearch.equals(aux) ? aux : null;}
				}
			}
		} return null;
	}
	
	public boolean contains(String value) { return searchNode(value)!=null;}

	public boolean changeAccessNode(String value) {
		if(contains(value)) { access=searchNode(value); return true;}
		return false;
	}
	
	public boolean remove(String value){
		if(contains(value)){
			isolateNode(searchNode(value));
			size--;
			return true;
		} return false;
	}
	
	private void isolateNode(Node node){
                for(Node isolate : node.getAdjacentNodes().keySet()){
                        isolate.getAdjacentNodes().remove(node);
                }
        }
	
	public boolean connect(String one, String two, int edge){
		if(contains(one) && contains(two) && edge>0){
			
			Node first=searchNode(one);
			Node second=searchNode(two);
			
			first.getAdjacentNodes().put(second, edge);
			second.getAdjacentNodes().put(first, edge);
			return true;
		} return false;
	}

	private boolean onlyLetters(String string){
		string=string.toUpperCase();
		
		for(int i=0; i<string.length(); i++){
			if(string.charAt(i)<'A' || string.charAt(i)>'Z') { return false;}
		} return true;
	}
}
