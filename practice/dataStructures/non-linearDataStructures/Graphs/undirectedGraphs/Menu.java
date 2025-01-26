import java.util.Scanner;

public class Menu {
	
	private Scanner into;
	private UndirectedGraph graph;
	
	public Menu(){
		into=new Scanner(System.in);
		graph=new UndirectedGraph();
	}

	public void menu(){
		String nodeOne="", nodeTwo="";
		int edge=0;

		do{
			switch(firstMenu()) {
				case 1:
					automaticGraph();
					System.out.println("\nAutomatic graph generated!");
					break;
				case 2:
					System.out.print("\n Enter the first value: ");
					if(graph.add(into.nextLine())) { System.out.println(" > Value correctly added!!!");}
					else { System.out.println(" (-) There was an error trying to add the node. Node not added!");}
					break;
				case 3:
					System.out.print("\n Enter the new value: "); nodeOne=into.nextLine();
					System.out.print(" Which node will this be connected to? "); nodeTwo=into.nextLine();
					System.out.print(" Enter the edge weight: "); edge=into.nextInt(); into.nextLine();
					if(graph.add(nodeOne, nodeTwo, edge)){ System.out.println(" > New node added!!!");}
					else { System.out.println(" (-) Node not added! ");}
					break;
				case 4:
					System.out.print("\n Enter the node to remove: ");
					if(graph.remove(into.nextLine())){ System.out.println(" > Node was removed!!");}
					else { System.out.println(" (-) Node not removed!!");}
					break;
				case 5:
					System.out.print("\n - Enter one of the nodes: "); nodeOne=into.nextLine();
					System.out.print(" - Enter the another one: "); nodeTwo=into.nextLine();
					System.out.print(" - And now, Enter de edge weight: "); edge=into.nextInt(); into.nextLine();
					if(graph.connect(nodeOne, nodeTwo, edge)){ System.out.println(" The nodes were connected!");}
					else { System.out.println(" The nodes weren't connected!");}
					break;
				case 6:
					System.out.print("\n Node: "); Node searched=graph.search(into.nextLine());
					if(searched!=null){ System.out.println(searched.toString());}
					else { System.out.println("The node wasn't found!!!");}
					break;
				case 7:
					System.out.println("\n Access node: "+ graph.getAccess()+ ".");
					break;
				case 8:
					System.out.println("\n "+ graph.size()+ " nodes have this graph!");
					break;
				case 9:
					System.out.print("\n Node: "); nodeOne=into.nextLine();
					if(graph.contains(nodeOne)){
						Node node=graph.search(nodeOne);
						System.out.println(node.numberOfAdjacentNodes()+ " nodes.");
					}else { System.out.println("Node not found!!!");}
					break;
				case 10:
					System.out.println("\n"+ graph);
					break;
				case 11:
					System.out.print("\n Enter the origin node: "); nodeOne=into.nextLine();
					System.out.print(" Enter the target node: "); nodeTwo=into.nextLine();
					System.out.println(graph.shortestPath(nodeOne, nodeTwo));
					break;
				case 12:
					System.out.print("\n Are you sure? ");
					do{
						nodeTwo=into.nextLine().toUpperCase();
						if(!nodeTwo.equals("Y") && !nodeTwo.equals("N")){
							System.out.print(" Wrong option. Try again: "); nodeTwo=null;
						} nodeOne=null;
					}while(nodeTwo==null);
					break;
				default:
			}
		}while(!nodeTwo.equals("Y") || nodeOne!=null);
	}

	private int firstMenu(){
		int num=1;
		
		System.out.println((num++)+ ") Automatic graph");
		System.out.println((num++)+ ") Initialize graph");
		System.out.println((num++)+ ") Add a new node");
		System.out.println((num++)+ ") Remove a node");
		System.out.println((num++)+ ") Connect the following two nodes");
		System.out.println((num++)+ ") Search the following node");
		System.out.println((num++)+ ") Get access node");
		System.out.println((num++)+ ") How many nodes are there?");
		System.out.println((num++)+ ") How many neighbors does the following node have?");
		System.out.println((num++)+ ") All nodes and their adjacents");
		System.out.println((num++)+ ") Shortest path between these two nodes");
		System.out.println((num++)+ ") Exit");
		System.out.print(" >>>>> Option: "); num=into.nextInt(); into.nextLine();

		return num;
	}

	private void automaticGraph() {
		graph.add("A");
		graph.add("B", "A", 8);
		graph.add("E", "A", 4);
		graph.add("D", "A", 5);
		graph.add("C", "B", 3);
		graph.add("F", "B", 4);
		graph.add("J", "E", 5);
		graph.add("H", "D", 6);
		graph.add("I", "E", 8);
		graph.add("M", "H", 7);
		graph.add("N", "M", 2);
		graph.add("K", "J", 6);
		graph.add("G", "C", 11);
		graph.add("L", "K", 5);
		graph.add("P", "K", 7);
		graph.connect("B", "E", 12);
		graph.connect("E", "D", 9);
		graph.connect("E", "F", 3);
		graph.connect("I", "J", 10);
		graph.connect("F", "C", 9);
		graph.connect("F", "G", 1);
		graph.connect("F", "K", 8);
		graph.connect("G", "K", 8);
		graph.connect("G", "L", 7);
		graph.connect("L", "P", 6);
		graph.connect("I", "H", 2);
		graph.connect("I", "M", 6);
		graph.connect("N", "J", 9);
		graph.connect("N", "P", 12);
	}
}
