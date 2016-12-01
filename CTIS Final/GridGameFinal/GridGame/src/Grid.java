import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.*;


public class Grid extends JPanel
{
	private int dim = 0; //dim is number columns = number rows
	private int gridSize = 0; //int representation of number of pixels (height, width)
	private JButton chosenOne, other;
	
	JFrame frame = new JFrame("Grid Game");
	JPanel panel = new JPanel();
	randPosCol newPosition;
	ButtonListener listener = new ButtonListener();
	
	JButton newChosen;
	JButton newOther;
	
	int randCol = 0, randRow = 0;
	TimerPanel timer;
	ScorePanel score;
	
	int alteredState;
	Color diffColor;
	
	//Constructor
	public Grid(int dimension)
	{
		dim = dimension;
		newPosition = new randPosCol(dim);
		gridSize = 750; //gridSize var is 750px
		
		alteredState = (int )((1/Math.sqrt(dim)) * newPosition.getRandAdd());
		
		panel.setBackground(Color.blue);
		panel.setLayout(new GridLayout(dim, dim));
		
		randCol = newPosition.getCol();
		randRow = newPosition.getRow();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		panel.setBackground(Color.blue);
		
		panel.setLayout(new GridLayout(dim, dim));
		
		timer = new TimerPanel(frame);
		
//		timer.setBounds(500, 200, 100, 100);		
		score = new ScorePanel(frame);

		
		JFrame frame1 = new JFrame("Score"); //put the name of the game once decided here
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inserts the graphics and buttons
		frame1.getContentPane().add(score);
		frame1.setLocation(800, 340);
		
		frame1.pack();
		frame1.setVisible(true);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
//		timer.setBounds(500, 200, 100, 100);		
		
		JFrame frame2 = new JFrame("Timer"); //put the name of the game once decided here
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inserts the graphics and buttons
		frame2.getContentPane().add(timer);
		frame2.setLocation(800, 0);
		
		frame2.pack();
		frame2.setVisible(true);
		
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (newPosition.getR() == newPosition.getCol()) 
		{
			if (newPosition.getR() > 128) {newPosition.setR((-newPosition.getRandAdd() * alteredState));}
			else {newPosition.setR((newPosition.getRandAdd() * alteredState));}
		}
		if (newPosition.getG() == newPosition.getCol()) 
		{
			if (newPosition.getG() > 128) {newPosition.setG((-newPosition.getRandAdd() * alteredState));}
			else {newPosition.setG((newPosition.getRandAdd() * alteredState));}
		}
		if (newPosition.getB() == newPosition.getCol()) 
		{
			if (newPosition.getB() > 128) {newPosition.setB((-newPosition.getRandAdd() * alteredState));}
			else {newPosition.setB((newPosition.getRandAdd() * alteredState));}
		}
		
		diffColor = new Color(newPosition.getR(),newPosition.getG(), newPosition.getB());
	
		
		for (int i = 0; i < dim; i++) 
		{
			for (int c = 0; c < dim; c++)
			{
				ButtonListener listener = new ButtonListener();					

				if (i == newPosition.getCol() && c == newPosition.getRow())
				{
					chosenOne = new JButton();
					chosenOne.setSize(new Dimension(50, 50));
					
					chosenOne.setBorder(BorderFactory.createLineBorder(Color.black));
					chosenOne.setBackground(diffColor);
					
					chosenOne.addActionListener(listener);
					panel.add(chosenOne);
				}
				else
				{
					other = new JButton();
					other.setSize(new Dimension(50,50));
					
					other.setBorder(BorderFactory.createLineBorder(Color.black));
					other.setBackground(newPosition.getNewColor());
					
					other.addActionListener(listener);
					panel.add(other);

				}

			}
		}
		panel.setSize(new Dimension(100, 100));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setSize(new Dimension(gridSize, gridSize));
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == getChosenOne())
			{
				dim++;
				
				alteredState = (int )((1/Math.sqrt(dim)) * newPosition.getRandAdd());

				
				newPosition = new randPosCol(dim);
				randCol = newPosition.getCol();
				randRow = newPosition.getRow();
				
				JFrame newFrame = new JFrame("new");
				JPanel newPanel = new JPanel();
				
				newPanel.setBackground(Color.blue);
				newPanel.setLayout(new GridLayout(dim, dim));
				
				if (newPosition.getR() == newPosition.getCol()) 
				{
					if (newPosition.getR() > 128) {newPosition.setR((-newPosition.getRandAdd() * alteredState));}
					else {newPosition.setR((newPosition.getRandAdd() * alteredState));}
				}
				if (newPosition.getG() == newPosition.getCol()) 
				{
					if (newPosition.getG() > 128) {newPosition.setG((-newPosition.getRandAdd() * alteredState));}
					else {newPosition.setG((newPosition.getRandAdd() * alteredState));}
				}
				if (newPosition.getB() == newPosition.getCol()) 
				{
					if (newPosition.getB() > 128) {newPosition.setB((-newPosition.getRandAdd() * alteredState));}
					else {newPosition.setB((newPosition.getRandAdd() * alteredState));}
				}
				
				diffColor = new Color(newPosition.getR(),newPosition.getG(), newPosition.getB());

				
				for (int i = 0; i < dim; i++) 
				{
					for (int c = 0; c < dim; c++)
					{

						if (i == randCol && c == randRow)
						{					
							chosenOne = new JButton();
							chosenOne.setSize(new Dimension(25,25));
							
							chosenOne.setBorder(BorderFactory.createLineBorder(Color.black));
							chosenOne.setBackground(diffColor);
							
							chosenOne.addActionListener(listener);
							newPanel.add(chosenOne);
						}
						else
						{
							other = new JButton();
							other.setSize(new Dimension(25,25));
							
							other.setBorder(BorderFactory.createLineBorder(Color.black));
							other.setBackground(newPosition.getNewColor());
							
							other.addActionListener(listener);
							newPanel.add(other);

						}

					}
				}
				
				newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newPanel.setSize(new Dimension(100, 100));
				
				newFrame.getContentPane().add(newPanel);
				newFrame.pack();
				newFrame.setSize(new Dimension(gridSize, gridSize));
				newFrame.setVisible(true);
				
				newFrame.invalidate();
				newFrame.repaint();
				newFrame.validate();
				
				
				score.logic(dim);
				
	
			}
			else{
				timer.changeTimer(5);
			}
		}
	}
	
	//Getters
	public int getDim() {return dim;}
	
	public JButton getChosenOne() {return chosenOne;}
	public JButton getOther() {return other;}
	
	//Setters
	public void setChosenOne(JButton chosenOne) 
	{
		this.chosenOne = chosenOne;
	}
	public void setOther(JButton other) 
	{
		this.other = other;
	}
}
