import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cal implements ActionListener {
	
	//Declaring all the required components
	JFrame frame;
	JButton[] numberButtons = new JButton[10];
	JButton[] operatorButtons = new JButton[9];
	JButton decBtn, addBtn, subBtn, mulBtn, divBtn, clrBtn, delBtn, eqBtn, negBtn;
	JPanel panel;
	Font myFont = new Font("Monospaced",Font.BOLD,26);
	double num1=0,num2=0,result=0;
	char operator;
	
	JTextField display;
	
	Cal(){
		
		frame = new JFrame("Calculator");
		
		//Setting the layout
		frame.setLayout(null);
		//Other required parameters
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		
		//TextField
		display = new JTextField();
		display.setBounds(50,25,300,50);
		display.setFont(myFont);
		display.setBackground(Color.WHITE);
		display.setEditable(false);
		
		//Addition Button
		addBtn = new JButton("+");
		operatorButtons[0] = addBtn;
		//Subtract Button
		subBtn = new JButton("-");
		operatorButtons[1] = subBtn;
		//Multiplication Button
		mulBtn = new JButton("x");
		operatorButtons[2] = mulBtn;
		//Division Button
		divBtn = new JButton("÷");
		operatorButtons[3] = divBtn;
		//Decimal Button
		decBtn = new JButton(".");
		operatorButtons[4] = decBtn;
		//Clear Button
		clrBtn = new JButton("Clr");
		operatorButtons[5] = clrBtn;
		clrBtn.setBounds(260,430,90,50);
		//Delete Button
		delBtn = new JButton("Del");
		operatorButtons[6] = delBtn;
		delBtn.setBounds(155,430,90,50);
		//Equal Button
		eqBtn = new JButton("=");
		operatorButtons[7] = eqBtn;
		//Negative Button
		negBtn = new JButton("(-)");
		operatorButtons[8] = negBtn;
		negBtn.setBounds(50,430,90,50);
		
		
		for(int i=0;i<9;i++) {
			operatorButtons[i].addActionListener(this);
			operatorButtons[i].setFont(myFont);
			operatorButtons[i].setFocusable(false);
		}
		
		//Number Buttons
		for(int i=0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		
		//Panel
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addBtn);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subBtn);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		panel.add(numberButtons[0]);
		panel.add(eqBtn);
		panel.add(divBtn);
		
		
		
		//Adding our components
		frame.add(display);
		frame.add(negBtn);
		frame.add(clrBtn);
		frame.add(delBtn);
		frame.add(panel);
		
		//Setting the frame visible
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		Cal c = new Cal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Number Buttons Display
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				display.setText(display.getText().concat(String.valueOf(i)));
			}
		}
		//Decimal Button Display
		if(e.getSource()==decBtn) {
			display.setText(display.getText().concat("."));
		}
		//Addition Button Display
		if(e.getSource()==addBtn) {
			num1 = Double.parseDouble(display.getText());
			operator = '+';
			display.setText("");
		}
		//Subtraction Button Display
		if(e.getSource()==subBtn) {
			num1 = Double.parseDouble(display.getText());
			operator = '-';
			display.setText("");
		}
		//Multiplication Button Display
		if(e.getSource()==mulBtn) {
			num1 = Double.parseDouble(display.getText());
			operator = '*';
			display.setText("");
		}
		//Division Button Display
		if(e.getSource()==divBtn) {
			num1 = Double.parseDouble(display.getText());
			operator = '/';
			display.setText("");
		}
		//Equal Button Display
		if(e.getSource()==eqBtn) {
			num2 = Double.parseDouble(display.getText());
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			display.setText(String.valueOf(result));
			num1=result;
		}
		//Clear Button Display
		if(e.getSource()==clrBtn) {
			display.setText("");
		}
		//Delete Button Display
		if(e.getSource()==delBtn) {
			String str = display.getText();
			display.setText("");
			for(int i=0;i<str.length()-1;i++) {
				display.setText(display.getText()+str.charAt(i));
			}
		}
		//Negative Button Display
		if(e.getSource()==negBtn) {
			double temp = Double.parseDouble(display.getText());
			temp *= -1;
			display.setText(String.valueOf(temp));
		}
		
		
	}

}
