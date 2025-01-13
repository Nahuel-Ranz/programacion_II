import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Node> {
	
	private final String value;
	private HashMap<Node, Integer> adjacentNodes;

	public Node(String value){
		this.value=value;
		adjacentNodes=new HashMap<Node, Integer>();
	}

	public String getValue(){ return value;}
	
	public HashMap<Node, Integer> getAdjacentNodes(){ return adjacentNodes;}
	
	public boolean isAnAdjacentNode(String value){ return adjacentNodes.containsKey(new Node(value));}
	
	public int numberOfAdjacentNodes(){ return adjacentNodes.size();}

	@Override
	public int hashCode(){
		String hash="";
		
		for(int i=0; i<value.length(); i++){
			hash+=String.valueOf(Character.hashCode(value.charAt(i)));
		} return Integer.parseInt(hash);
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o instanceof Node){
			return value.equals(((Node)o).getValue());
		} return false;
	}

	@Override
	public int compareTo(Node node){ return value.compareTo(node.getValue());}

	@Override
	public String toString(){
		String toReturn="Node: "+ value+ ". Edges|Adjacent nodes: {";
		
		for(Map.Entry<Node, Integer> pair : adjacentNodes.entrySet()){
			toReturn+=pair.getValue()+ "|"+ pair.getKey().getValue()+ "; ";
		} return toReturn.substring(0, toReturn.length()-2)+ "}";
	}
}
