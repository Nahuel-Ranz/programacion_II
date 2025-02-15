import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

public class UndirectedGraph {
	
	private Node access;
	private int size;
	private HashSet<String> values; // this is for internal operations.
	private UndirectedGraph innerGraph; // this is for shortestPath methods.

	public UndirectedGraph() {
		access=null;
		size=0;
		values=new HashSet<String>();
	}

	private UndirectedGraph(boolean bool) { }
	
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

	private class INode {
		
		final String VALUE;
		HashSet<String> before;
		static HashMap<INode, Integer> nodes, auxiliaries;
		static LinkedList<INode> finalValues;
		static LinkedList<String> paths;
		static INode aux;

		INode(String VALUE) { this.VALUE=VALUE;}

		INode(String VALUE, String before) {
			this.VALUE=VALUE;

			if(!before.equals("@@")) {
				this.before=new HashSet<String>();
				this.before.add(before);
			}
		}

		@Override
		public int hashCode() {

			String toReturn="";
			for(int i=0; i<VALUE.length(); i++){
				toReturn+=String.valueOf(Character.hashCode(VALUE.charAt(i)));
			} return Integer.parseInt(toReturn);
		}

		@Override
		public boolean equals(Object o) { return o instanceof INode ? ((INode)o).VALUE.equals(VALUE) : false;}

	//	@Override
	//	public String toString() { return "("+ VALUE.toUpperCase()+ ")"+ (before!=null ? before.toLowerCase() : "");}
	}
	
	public String shortestPath(String origin, String target){
		if(contains(origin) && contains(target)) {
			
			if(!origin.equals(target)){
				
				innerGraph=new UndirectedGraph(true);
				INode.nodes=new HashMap<INode, Integer>();
				INode.finalValues=new LinkedList<INode>();
				INode.auxiliaries=new HashMap<INode, Integer>();
				INode.paths=new LinkedList<String>();

				INode.nodes.put(innerGraph.new INode(origin, "@@"), 0);
				shortestPath(target);
				int index=INode.finalValues.indexOf(innerGraph.new INode(target));
				printShortestPath(origin, index, "");

				innerGraph=null;
				INode.aux=null;
				INode.auxiliaries=null;
				INode.nodes.clear(); INode.nodes=null;
				INode.finalValues.clear(); INode.finalValues=null;
				
				return personalizedMessage();
			} return "the origin and the target are the same!";
		} return "some of the nodes weren't found!";
	}
	
	private void shortestPath(String target){
		if(!isTargetInFinalValues(target)) {
			newFinalValues();
			
			for(INode check : INode.auxiliaries.keySet()) {
				INode.finalValues.add(check);
				INode.nodes.remove(check);
			}

			for(Map.Entry<INode, Integer> pair : INode.auxiliaries.entrySet()) {
				addingINodesFrom(search(pair.getKey().VALUE), pair.getValue());
			}
			
			INode.auxiliaries.clear();
			shortestPath(target);
		}
	}

	private void addingINodesFrom(Node current, int weight) {
		for(Map.Entry<Node, Integer> pair : current.getAdjacentNodes().entrySet()){

			INode.aux=innerGraph.new INode(pair.getKey().getValue(), current.getValue());
			if(!INode.finalValues.contains(INode.aux)){

				if(INode.nodes.containsKey(INode.aux)) {

					if(INode.nodes.get(INode.aux) < weight+pair.getValue()) { continue;}
					if(INode.nodes.get(INode.aux) == weight+pair.getValue()) {
						INode.aux.before=getKey(INode.aux).before;
						INode.aux.before.add(current.getValue());
					} INode.nodes.remove(INode.aux);
				} INode.nodes.put(INode.aux, weight+pair.getValue());
			}
		}
	}
	
	private void newFinalValues(){
		int smaller=0;

		for(Integer check : INode.nodes.values()) { smaller=check; break;}
		for(Map.Entry<INode, Integer> pair : INode.nodes.entrySet()) {
			if(smaller < pair.getValue()) { continue;}
			if(smaller > pair.getValue()) { smaller=pair.getValue(); INode.auxiliaries.clear();}
			INode.auxiliaries.put(pair.getKey(), smaller);
		}
	}

	private boolean isTargetInFinalValues(String target) {
		return INode.finalValues.contains(innerGraph.new INode(target));
	}

	private INode getKey(INode node) {
		for(INode check : INode.nodes.keySet()){
			if(check.equals(node)) { return check;}
		} return null;
	}

	private void printShortestPath(String origin, int target, String value) {
		
		INode node=INode.finalValues.get(target);
		if(origin.equals(node.VALUE)) { INode.paths.add(origin+ value);}
		else {
			for(String beforeNode : node.before) {
				target=INode.finalValues.indexOf(innerGraph.new INode(beforeNode));
				printShortestPath(origin, target, ", "+ node.VALUE+ value);
			}
		}
	}

	private String personalizedMessage() {
		String toReturn="";

		for(String check : INode.paths) {
			toReturn+= "\nShortest Path: "+ check;
		} return toReturn.substring(1);
	}
}
