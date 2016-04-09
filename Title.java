package jrJava.SolvingDiffMathProb;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Title extends JPanel{
	
	Top top;
	Bottom bot;
	
	public Title(){
		
		setLayout(new BorderLayout());
		top = new Top();
		add(top, BorderLayout.NORTH);
		bot = new Bottom();
		add(bot, BorderLayout.CENTER);
		
	}
		
	class Top extends JPanel{
		
		JLabel lab;
		
		public Top(){
			
			lab = new JLabel("Math Solver");
			add(lab);
			lab.setForeground(Color.GREEN);
			lab.setFont(new Font("Utopia",Font.PLAIN, 70));
			
		}
		
		public void paintComponent(Graphics g){
			
			setBackground(Color.BLACK);
			super.paintComponent(g);
			
		}
		
	}
	
	class Bottom extends JPanel implements ActionListener{
		
		JButton statistics;
		
		public Bottom(){
			
			setLayout(new GridLayout(1,1));
			
			statistics = new JButton("Statistics");
			add(statistics);
			statistics.setBackground(Color.BLACK);
			statistics.setForeground(Color.GREEN);
			statistics.addActionListener(this);
						
		}
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==statistics){
				
				Coordinator.cont.cards.show(Coordinator.cont, "statistics");
				
			}
			
		}
		
	}
	
}
