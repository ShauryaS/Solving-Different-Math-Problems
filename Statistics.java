package jrJava.SolvingDiffMathProb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jrJava.SolvingDiffMathProb.Title.Bottom;
import jrJava.SolvingDiffMathProb.Title.Top;

public class Statistics extends JPanel implements ActionListener{
	
	Top top;
	Bottom bot;
	JButton back;
	
	public Statistics(){
		
		setLayout(new BorderLayout());
		top = new Top();
		add(top, BorderLayout.NORTH);
		bot = new Bottom();
		add(bot, BorderLayout.CENTER);
		back = new JButton("Back");
		add(back, BorderLayout.SOUTH);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.GREEN);
		back.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==back){

			Coordinator.cont.cards.show(Coordinator.cont, "title");
			
		}
		
	}
			
	class Top extends JPanel{

		JLabel lab;

		public Top(){

			lab = new JLabel("Statistics");
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

		JButton mean;
		JButton median;
		JButton mode;
		JButton variance;
		JButton stanDev;
		JButton sum;

		public Bottom(){

			setLayout(new GridLayout(3, 2));

			mean = new JButton("Mean");
			add(mean);
			mean.setBackground(Color.BLACK);
			mean.setForeground(Color.GREEN);
			mean.addActionListener(this);

			median = new JButton("Median");
			add(median);
			median.setBackground(Color.BLACK);
			median.setForeground(Color.GREEN);
			median.addActionListener(this);

			mode = new JButton("Mode");
			add(mode);
			mode.setBackground(Color.BLACK);
			mode.setForeground(Color.GREEN);
			mode.addActionListener(this);

			variance = new JButton("Variance");
			add(variance);
			variance.setBackground(Color.BLACK);
			variance.setForeground(Color.GREEN);
			variance.addActionListener(this);

			stanDev = new JButton("Standard Deviation");
			add(stanDev);
			stanDev.setBackground(Color.BLACK);
			stanDev.setForeground(Color.GREEN);
			stanDev.addActionListener(this);

			sum = new JButton("Correlation");
			add(sum);
			sum.setBackground(Color.BLACK);
			sum.setForeground(Color.GREEN);
			sum.addActionListener(this);

		}

		public void actionPerformed(ActionEvent e){

			if(e.getSource()==mean){

				Coordinator.cont.cards.show(Coordinator.cont, "mean");

			}

			if(e.getSource()==median){

				Coordinator.cont.cards.show(Coordinator.cont, "median");

			}
			
			if(e.getSource()==mode){
				
				Coordinator.cont.cards.show(Coordinator.cont, "mode");
				
			}
			
		}

	}

}
