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
					System.out.print("\n Enter the first value: ");
					if(graph.add(into.nextLine())) { System.out.println(" > Value correctly added!!!");}
					else { System.out.println(" (-) There was an error trying to add the node. Node not added!");}
					break;
				case 2:
					System.out.print("\n Enter the new value: "); nodeOne=into.nextLine();
					System.out.print(" Which node will this be connected to? "); nodeTwo=into.nextLine();
					System.out.print(" Enter the edge weight: "); edge=into.nextInt(); into.nextLine();
					if(graph.add(nodeOne, nodeTwo, edge)){ System.out.println(" > New node added!!!");}
					else { System.out.println(" (-) Node not added! ");}
					break;
				case 3:
					System.out.print("\n Enter the node to remove: ");
					if(graph.remove(into.nextLine())){ System.out.println(" > Node was removed!!");}
					else { System.out.println(" (-) Node not removed!!");}
					break;
				case 4:
					System.out.print("\n - Enter one of the nodes: "); nodeOne=into.nextLine();
					System.out.print(" - Enter the another one: "); nodeTwo=into.nextLine();
					System.out.print(" - And now, Enter de edge weight: "); edge=into.nextInt(); into.nextLine();
					if(graph.connect(nodeOne, nodeTwo, edge)){ System.out.println(" The nodes were connected!");}
					else { System.out.println(" The nodes weren't connected!");}
					break;
				case 5:
					System.out.print("\n Node: "); Node searched=graph.search(into.nextLine());
					if(searched!=null){ System.out.println(searched.toString());}
					else { System.out.println("The node wasn't found!!!");}
					break;
				case 6:
					System.out.println("\n Access node: "+ graph.getAccess()+ ".");
					break;
				case 7:
					System.out.println("\n "+ graph.size()+ " nodes have this graph!");
					break;
				case 8:
					System.out.print("\n Node: "); nodeOne=into.nextLine();
					if(graph.contains(nodeOne)){
						Node node=graph.search(nodeOne);
						System.out.println(node.numberOfAdjacentNodes()+ " nodes.");
					}else { System.out.println("Node not found!!!");}
					break;
				case 9:
					System.out.println("\n"+ graph);
					break;
				case 10:
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

		System.out.println((num++)+ ") Initialize graph");
		System.out.println((num++)+ ") Add a new node");
		System.out.println((num++)+ ") Remove a node");
		System.out.println((num++)+ ") Connect the following two nodes");
		System.out.println((num++)+ ") Search the following node");
		System.out.println((num++)+ ") Get access node");
		System.out.println((num++)+ ") How many nodes are there?");
		System.out.println((num++)+ ") How many neighbors does the following node have?");
		System.out.println((num++)+ ") All nodes and their adjacents");
		System.out.println((num++)+ ") Exit");
		System.out.print(" >>>>> Option: "); num=into.nextInt(); into.nextLine();

		return num;
	}
}
