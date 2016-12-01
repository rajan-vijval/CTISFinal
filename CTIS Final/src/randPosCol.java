//randomly chooses a position on the grid for the different square
import java.awt.Color;
import java.util.Random;

public class randPosCol
{
	private int randCol, randRow;
	private Random rand = new Random();
	private int r, g, b;
	private Color newColor;
	private Color diffColor;
	
	private int addColor;
	private int randAdd;
	//Constructor
	public randPosCol(int dimension) //meant to be used with dim in Grid.java
	{
		randCol = rand.nextInt(dimension);
		randRow = rand.nextInt(dimension);
		
		r = rand.nextInt(256);
		g = rand.nextInt(256);
		b = rand.nextInt(256);
		
		newColor = new Color(r, g, b);
		addColor = Math.max(Math.max(r,  g), b);
		randAdd = rand.nextInt(128);
		
		
		
		if (r == addColor) 
		{
			if (r > 128) {r -= randAdd;}
			else {r += randAdd;}
		}
		if (g == addColor) 
		{
			if (g > 128) {g -= randAdd;}
			else {g += randAdd;}
		}
		if (b == addColor) 
		{
			if (b > 128) {b -= randAdd;}
			else {b += randAdd;}
		}
		
		diffColor = new Color(r, g, b);
	}
	
	//Setter - may be combined because always changing both at same time
	public void setColAndRow(int newDimension)
	{
		randCol = rand.nextInt(newDimension);
		randRow = rand.nextInt(newDimension);
		
	
	}
	
	//Getter
	public int getCol()	{return randCol;}
	public int getRow() {return randRow;}
	
	public Color getNewColor() {return newColor;}
	public Color getDiffColor() {return diffColor;}
	
	public int getRandAdd() {return randAdd;}
	public int getAddCol() {return addColor;}
	
	public int getR() {return r;}
	public int getG() {return g;}
	public int getB() {return b;}
	
	//Setter
	public void setR(int newR) {r += newR;}
	public void setG(int newG) {r += newG;}
	public void setB(int newB) {r += newB;}
}
