/**
 * 
 */
package shortDistance;

import java.util.ArrayList;

/**
 * 
 * @author Mariama Barr-Dallas & Michael Tang
 *@version 1.0
 */
public class DistCalcDriver {

	//Must know the arraylist <type> that will be recieved from
	//Google Earth Data.
	
	/**This function calculates the shortest route
	 * based on the given list and the start and end points
	 * returns an arraylist of coordinates sorted for shortest distance
	 * @param parklist	list of parks that the user wants to go to
	 * @param start 	the coordinate the user starts at
	 * @param end		the coordinate the user ends at
	 * @return ArrayList<Coordinate>
	 */
	public static ArrayList<Coordinate> shortDistAlgorithm(ArrayList<Coordinate> parklist, Coordinate start, Coordinate end){
		
		ArrayList<Coordinate> path = new ArrayList<Coordinate>();
		Coordinate current = start;
		Coordinate next = null;
		double smallest = Double.MAX_VALUE;
		double distance;
		path.add(current);
		
		for(int i=0; i<(parklist.size()-2); i++)
		{
			for(int j=0; j<parklist.size(); j++)
			{
				//determines the next nearest destination not searching previous targets or the end value 
				if(!path.contains(parklist.get(j)) && parklist.get(j) != end)
				{
					distance = current.distance(parklist.get(j));
					if(smallest > distance)
					{
						smallest = distance;
						next = parklist.get(j);
					}
				}
			}
			current = next;
			path.add(current);
			smallest = Double.MAX_VALUE;
		}
		path.add(end);		
		return path;
	}
	
	/**
	 * This function calculates the total distance covered by this path
	 * @param list	A list containing the sorted path
	 * @return double
	 */
	public static double totalDistance(ArrayList<Coordinate> list)
	{
		double dist = 0;
		for(int i=0; i<list.size()-1; i++)
		{
			dist += list.get(i).distance(list.get(i+1));
		}
		return dist;
	}
	
	public static void main(String[] args){
		
		Coordinate destA = new Coordinate("Destination A",1,1);
		Coordinate destB = new Coordinate("Destination B",200,200);
		Coordinate destC = new Coordinate("Destination C",5,5);
		Coordinate destD = new Coordinate("Destination D",56,34);
		Coordinate destE = new Coordinate("Destination E",100,100);
		Coordinate destF = new Coordinate("Destination F",0,0);
		Coordinate destG = new Coordinate("Destination G",20,20);
		
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		list.add(destA);
		list.add(destB);
		list.add(destC);
		list.add(destD);
		list.add(destE);
		list.add(destF);
		list.add(destG);
		ArrayList<Coordinate> endlist = new ArrayList<Coordinate>();
		endlist = shortDistAlgorithm(list, destA, destG);
		for(int i=0;i<endlist.size();i++)
		{
			System.out.println(endlist.get(i));
		}
		System.out.print(totalDistance(endlist));
		
		
	}
}
