package jrJava.SolvingDiffMathProb;

import java.awt.*;
import javax.swing.*;

public class Coordinator extends JFrame{
	
	public static Container cont;

	public static void main(String[] args) {
		
		Coordinator c = new Coordinator();
		
	}
	
	public Coordinator(){
		
		super("Math Solver");
		setSize(800, 800);
		cont = new Container();
		add(cont);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	class Container extends JPanel{
		
		CardLayout cards;
		Title t;
		Statistics s;
		Mean mean;
		Median med;
		Mode mod;
		
		public Container(){
			
			cards = new CardLayout();			
			setLayout(cards);			
			t = new Title();
			add(t, "title");
			
			s = new Statistics();
			add(s, "statistics");
			
			mean = new Mean();
			add(mean, "mean");
			
			med = new Median();
			add(med, "median");
			
			mod = new Mode();
			add(mod, "mode");
			
		}
		
	}

}
