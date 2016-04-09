package jrJava.SolvingDiffMathProb;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class Mean extends JPanel{

	Top t;
	Bottom b;

	public Mean(){

		setLayout(new GridLayout(2, 1));
		t = new Top();
		add(t);
		b = new Bottom();
		add(b);

	}
	
	public void reset(){
		
		b.pressed = true;
		b.values.clear();
		b.sol.setText(b.solution);
		b.repaint();
		
		t.val.setText(t.start);
		t.repaint();
				
	}

	class Top extends JPanel implements ActionListener{

		JTextArea val;
		JButton reset;
		JLabel title;
		
		String start = "Enter numbers to calculate. Seperate and end using semicolons.";

		public Top(){

			setLayout(new BorderLayout());
			
			val = new JTextArea(start);
			add(val, BorderLayout.CENTER);
			val.setLineWrap(true);
			val.setWrapStyleWord(true);
			val.setBackground(Color.BLACK);
			val.setForeground(Color.GREEN);
			
			reset = new JButton("Reset");
			add(reset, BorderLayout.SOUTH);
			reset.setBackground(Color.BLACK);
			reset.setForeground(Color.GREEN);
			reset.addActionListener(this);
			
			title = new JLabel("Mean");
			add(title, BorderLayout.NORTH);
			title.setFont(new Font("Utopia",Font.PLAIN, 70));
			title.setForeground(Color.GREEN);

		}
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==reset){
				
				reset();
				
			}
			
		}
		
		public void paintComponent(Graphics g){

			setBackground(Color.BLACK);
			super.paintComponent(g);

		}

	}

	class Bottom extends JPanel implements ActionListener{

		JButton enter;
		JButton back;

		JLabel sol;

		String solution = "Solution: ";
		
		boolean pressed = true;

		ArrayList <Integer> values = new ArrayList();

		public Bottom(){

			setLayout(new BorderLayout());

			enter = new JButton("Enter");
			add(enter, BorderLayout.NORTH);
			enter.setBackground(Color.BLACK);
			enter.setForeground(Color.GREEN);
			enter.addActionListener(this);

			back = new JButton("Back");
			add(back, BorderLayout.SOUTH);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.GREEN);
			back.addActionListener(this);

			sol = new JLabel(solution);
			add(sol, BorderLayout.CENTER);
			sol.setForeground(Color.GREEN);

		}

		public void actionPerformed(ActionEvent e){

			if(pressed){
				
				if(e.getSource()==enter){

					String a = t.val.getText().replace(" ", "");
					String b = "";

					for(int i = 0; i<a.length(); i++){

						if((a.substring(i, i+1)).equalsIgnoreCase(";") || (a.substring(i, i+1)).equalsIgnoreCase(" ")){
							
							values.add(Integer.parseInt(b));
							b = "";
						
						}
						
						else b+=a.charAt(i);

					}
					
					calculate();
					
					pressed = false;

				}
						
			}

			if(e.getSource()==back){

				reset();
				Coordinator.cont.cards.show(Coordinator.cont, "statistics");

			}

		}

		public void calculate(){
			
			double average = 0;
			int sum = 0;

			for(int i = 0; i<values.size(); i++){
				
				sum+=values.get(i);
				
			}
			
			average = (double)(sum)/values.size();
			
			String a = "";
			
			for(int i = 0; i<values.size(); i++){
				
				a += values.get(i) + ", ";
				
			}
			
			sol.setText(solution+"	\n Mean - " + average + "	\n Order - " + a + "\t Terms: " + values.size());
			
			repaint();

		}

		public void paintComponent(Graphics g){

			setBackground(Color.BLACK);
			super.paintComponent(g);

		}

	}

}
