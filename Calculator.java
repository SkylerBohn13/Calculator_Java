package calculator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
public class Calculator extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1995698338495281162L;
	static JFrame f;
	static JTextField l;
	String k,y,s;
	
	Calculator()
	{
		k = y = s = "";
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String ac = e.getActionCommand();
		
		if ((ac.charAt(0) >= '0' && ac.charAt(0) <= '9') || ac.charAt(0) == '.') { 
            // if operand is present then add to second no 
            if (!y.equals("")) 
                s = s + ac; 
            else
                k = k + ac; 
  
            // set the value of text 
            l.setText(k + y + s); 
        } 
        else if (ac.charAt(0) == 'C') { 
            // clear the one letter 
            k = y = s = ""; 
  
            // set the value of text 
            l.setText(k + y + s); 
        } 
        else if (ac.charAt(0) == '=') { 
  
            double te; 
  
            // store the value in 1st 
            if (y.equals("+")) 
                te = (Double.parseDouble(k) + Double.parseDouble(s)); 
            else if (y.equals("-")) 
                te = (Double.parseDouble(k) - Double.parseDouble(s)); 
            else if (y.equals("/")) 
                te = (Double.parseDouble(k) / Double.parseDouble(s)); 
            else
                te = (Double.parseDouble(k) * Double.parseDouble(s)); 
  
            // set the value of text 
            l.setText(k + y + s + "=" + te); 
  
            // convert it to string 
            k = Double.toString(te); 
  
            y = s = ""; 
        } 
        else { 
            // if there was no operand 
            if (y.equals("") || s.equals("")) 
                y = ac; 
            // else evaluate 
            else { 
                double te; 
  
                // store the value in 1st 
                if (y.equals("+")) 
                    te = (Double.parseDouble(k) + Double.parseDouble(s)); 
                else if (y.equals("-")) 
                    te = (Double.parseDouble(k) - Double.parseDouble(s)); 
                else if (y.equals("/")) 
                    te = (Double.parseDouble(k) / Double.parseDouble(s)); 
                else
                    te = (Double.parseDouble(k) * Double.parseDouble(s)); 
  
                // convert it to string 
                k = Double.toString(te); 
  
                // place the operator 
                y = ac; 
  
                // make the operand blank 
                s = ""; 
            } 
  
            // set the value of text 
            l.setText(k + y + s); 
        } 
    
	} 
	
	public static void main(String[] args)
	{
		f = new JFrame("Skyler's Calculator");
		
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}
		catch (Exception e) 
		{ 
            System.err.println(e.getMessage()); 
        } 
		Calculator c = new Calculator();
		
		l = new JTextField(40);
		l.setEditable(false);
		
		JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bs,bd,bm,be,bc,beq;
		JPanel p = new JPanel();
		b0 = new JButton("0");
		b0.setBounds(100,250,50,50);
		b1 = new JButton("1");
		b1.setBounds(50, 100, 50, 50);
		b2 = new JButton("2");
		b2.setBounds(100,100,50,50);
		b3 = new JButton("3");
		b3.setBounds(150,100,50,50);
		b4 = new JButton("4");
		b4.setBounds(50,150,50,50);
		b5 = new JButton("5");
		b5.setBounds(100,150,50,50);
		b6 = new JButton("6");
		b6.setBounds(150,150,50,50);
		b7 = new JButton("7");
		b7.setBounds(50,200,50,50);
		b8 = new JButton("8");
		b8.setBounds(100,200,50,50);
		b9 = new JButton("9");
		b9.setBounds(150,200,50,50);
		ba = new JButton("+");
		ba.setBounds(0,100,50,50);
		bs = new JButton("-");
		bs.setBounds(0,150,50,50);
		bm = new JButton("*");
		bm.setBounds(0,200,50,50);
		bd = new JButton("/");
		bd.setBounds(0,250,50,50);
		be = new JButton(".");
		be.setBounds(200,200,50,50);
		bc = new JButton("C");
		bc.setBounds(200,150,50,50);
		beq = new JButton("=");
		beq.setBounds(200,100,50,50);
		
		
		 bm.addActionListener(c); 
	     bd.addActionListener(c); 
	     bs.addActionListener(c); 
	     ba.addActionListener(c); 
	     b9.addActionListener(c); 
	     b8.addActionListener(c); 
	     b7.addActionListener(c); 
	     b6.addActionListener(c); 
	     b5.addActionListener(c); 
	     b4.addActionListener(c); 
	     b3.addActionListener(c); 
	     b2.addActionListener(c); 
	     b1.addActionListener(c); 
	     b0.addActionListener(c); 
	     be.addActionListener(c); 
	     bc.addActionListener(c); 
	     beq.addActionListener(c); 
	     
	     p.add(l,l.CENTER_ALIGNMENT); 
	     f.add(ba); 
	     f.add(b1); 
	     f.add(b2); 
	     f.add(b3); 
	     f.add(bs); 
	     f.add(b4); 
	     f.add(b5); 
	     f.add(b6); 
	     f.add(bm); 
	     f.add(b7); 
	     f.add(b8); 
	     f.add(b9); 
	     f.add(bd); 
	     f.add(be); 
	     f.add(b0); 
	     f.add(bc); 
	     f.add(beq); 
	     
	     p.setBackground(Color.green);
	     f.add(p);
	     f.setSize(350,350);
	     f.show();	 
	}
	
}

