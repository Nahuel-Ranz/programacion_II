import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

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
			size++;
			return true;
		} return false;
	}

	public boolean add(String value, String adjacentNode, int edge){
		
		if(edge<1 || !onlyLetters(value) || contains(value) || !contains(adjacentNode) || size<1){
			return false;
		}

		Node toAdd=new Node(value);
		Node adjacent=search(adjacentNode);

		toAdd.getAdjacentNodes().put(adjacent, edge);
		adjacent.getAdjacentNodes().put(toAdd, edge);
		
		size++;
		return true;
	}
	
	public Node search(String value) {
		if(onlyLetters(value) && access!=null){
			
			values.add(access.getValue());
			Node toReturn=search(new Node(value), access);

			values.clear();
			return toReturn;
		}
		return null;
	}

	private Node search(Node nodeToSearch, Node currentNode){
		
		if(nodeToSearch.equals(currentNode)) { return currentNode;}

		Node aux;
		for(Node check: currentNode.getAdjacentNodes().keySet()){
			
			if(values.add(check.getValue())){
				aux=search(nodeToSearch, check);
				if(nodeToSearch.equals(aux)) { return aux;}
			}
		} return null;
	}
	
	public boolean contains(String value) { return search(value)!=null;}

	public boolean changeAccess(String value) {
		if(contains(value)) { access=search(value); return true;}
		return false;
	}
	
	public boolean remove(String value){
		if(!contains(value)){ return false;}
		if(size == 1) { access=null;}
		else {
			if(access.getValue().equals(value)){
				for(Node This : access.getAdjacentNodes().keySet()) { access=This; break;}
			}
			isolateNode(search(value));
		}
		
		--size;
		return true;
	}
	
	private void isolateNode(Node node){
                for(Node isolate : node.getAdjacentNodes().keySet()){
                        isolate.getAdjacentNodes().remove(node);
                }

		node.getAdjacentNodes().clear();
        }
	
	public boolean connect(String one, String two, int edge){
		if(contains(one) && contains(two) && edge>0 && !new Node(one).equals(new Node(two))){
			
			Node first=search(one);
			Node second=search(two);
			
			first.getAdjacentNodes().put(second, edge);
			second.getAdjacentNodes().put(first, edge);
			return true;
		} return false;
	}
	
	@Override
	public String toString(){
		
		if(access!=null) { values.add(access.getValue());}
		String toReturn= access==null ? "{ }" : size()==1 ? access.toString() : allNodes(access);

		values.clear();
		return toReturn;
	}

	private String allNodes(Node current){
		
		String toReturn="";
		for(Node check : current.getAdjacentNodes().keySet()){
			
			if(values.add(check.getValue())) { toReturn+="\n"+ allNodes(check);}
		} return current.toString()+ toReturn;
	}

	private boolean onlyLetters(String string){
		string=string.toUpperCase();
		
		for(int i=0; i<string.length(); i++){
			if(string.charAt(i)<'A' || string.charAt(i)>'Z') { return false;}
		} return true;
	}

	private class DijkstraNode {
		
		final String value;
		String before;
		int weight;
		static Queue<DijkstraNode> nodeQueue=new LinkedList<DijkstraNode>();
		static HashSet<DijkstraNode> definitiveValues=new HashSet<DijkstraNode>();

		DijkstraNode(String value, String before, int weight){
			this.value=value;
			this.before=before;
			this.weight=weight;
		}

		@Override
		public int hashCode() {

			String toReturn="";
			for(int i=0; i<value.length(); i++){
				toReturn+=String.valueOf(Character.hashCode(value.charAt(i)));
			} return Integer.parseInt(toReturn);
		}
	}
}
