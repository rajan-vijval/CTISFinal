import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScorePanel extends JPanel implements ActionListener
//this sets up the timer so it counts from 100 and counts by seconds
{
	JLabel setTime = new JLabel();
	public int score = 0;
	int done = 0;
	
	static JFrame frame1;
	
	//----------------------------------------------
	//Constructor: Sets up timer Panel
	//----------------------------------------------

//	public TimerPanel(JFrame frame)
//	{
//		frame1 = frame;
//		setPreferredSize(new Dimension(300,300));
//		setBounds(500,200,300,300);
//		setFont(new Font("Verdana", Font.BOLD, 22));
//		add(setTime);
//		setT.start();
//		setVisible(true);
//	}
	static JLabel lblNewLabel;
	
	public ScorePanel(JFrame frame) {
		frame1 = frame;
		setPreferredSize(new Dimension(300,300));
		setFont(new Font("Verdana", Font.BOLD, 22));
		setLayout(null);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(109, 11, 67, 34);
		lblScore.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		add(lblScore);
		
		lblNewLabel = new JLabel("0");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 84));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 56, 235, 209);
		add(lblNewLabel);
		setTime.setBounds(211, 22, 0, 0);
		add(setTime);
		setVisible(true);
	}
	
	public ScorePanel() {

	}
	//This creates the logic for the timer
	public void logic(int dim)
	{
		score = dim*2*100;
		lblNewLabel.setText(String.valueOf(score));
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
//	//implements the logic for the timer
//	public void actionPerformed(ActionEvent e)
//	{
//		logic();
//		repaint();
//	}
}
