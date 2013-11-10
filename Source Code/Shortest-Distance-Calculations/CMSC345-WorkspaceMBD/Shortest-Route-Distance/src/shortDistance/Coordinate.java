package shortDistance;


/**
 * @author Mariama Barr-Dallas & Michael Tang
 * @version 1.0
 *
 *This is the Coordinate class which 
 *defines the Coordinate data structure
 *
 *Each Coordinate possesses a :
 *Label - Name of the Coordinate
 *Longitude - horizontal dimension
 *Latitude - vertical dimension
 */
public class Coordinate {

	/**
	 * Default value for longitude and latitude
	 */
	private static final double DEFAULT_VALUE = 0;
	
	/**
	 * Default value for the Coordinate Label
	 */
	private static final String DEFAULT_LABEL = "";
	
	/**
	 * Label data member of Coordinate
	 */
	private String label;
	protected void setLabel(String label){this.label = label;}
	
	
	/**
	 * Longitude 
	 */
	private double x;
	
	/**This function sets the x (Longitude) of the coordinate
	 * 
	 * @param x
	 */
	protected void setLong(double x){this.x = x;}
	
	
	/**
	 * Latitude
	 */
	private double y;
	
	/**This function sets the y (Latitude) of the coordinate
	 * 
	 * @param y
	 */
	protected void setLat(double y){this.y = y;}
	
	
	/**
	 * @category Constructor
	 * @param label
	 * @param x
	 * @param y
	 * 
	 * This is the constructor for the Coordinate Object
	 * which takes in the latitude and longitude (x & y respectively)
	 *  
	 */
	public Coordinate(String label, double x, double y){
		
		this.label = label;
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * This is a no-parameter constructor for the Coordinate class which sets
	 * the longitude and latitude to DEFAULT_VALUE
	 * Note: the default value for the label is 'null'
	 */
	public Coordinate(){
		
		this.label = DEFAULT_LABEL;
		this.x = DEFAULT_VALUE;
		this.y = DEFAULT_VALUE;
	}
	
	/**
	 * @category function
	 * @param other
	 * @return double containing distance between 2 coordinates
	 * 
	 * This function calculates the distance between 2 coordinates
	 */
	public double distance(Coordinate other)
	{
		return Math.sqrt( Math.pow((other.x - this.x), 2) + Math.pow((other.y - this.y), 2) );
	}
	
	public String toString(){
		return label;
	}
	
	
	/**This is a function to TEST the methods and attributes of the 
	 * Coordinate class
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		Coordinate destA = new Coordinate("Destination A",50.0,50.0);
		Coordinate destB = new Coordinate("Destination B",50.0,50.0);
		
		/*
		 * TESTING .DISTANCE()
		 */
		//0 distance from A to B (SUCCESS)
		//System.out.println(destA.distance(destB));
		
		//0 distance from B to A (SUCCESS)
		//System.out.println(destB.distance(destA));
		
		//distance with negative input A: -50.0 , -50.0  B: 50 , 50 (SUCCESS)
		//destA.setLong(-50.0);
		//destA.setLat(-50.0);
		
		//System.out.println(destA.distance(destB));
		
		//distance with negative input B: -50.0 , -50.0  A: 50 , 50 (SUCCESS)
		//destB.setLong(-50.0);
		//destB.setLat(-50.0);
		
		//System.out.println(destB.distance(destA));
		
	}
}
