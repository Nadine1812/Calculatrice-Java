import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calcul implements ActionListener {

	JFrame frame; //Jrame représente toute l'interface de l'application.
	JTextField textfield;
	
	JButton[] numberButton = new JButton[10];
	JButton[] functionButton = new JButton[9];
	JButton addButton, subButton, mulButton, ClrButton, negButton, divButton, decButton, equButton, delButton;
	JPanel panel;
	
	Font myfont = new Font("Ink free", Font.BOLD,30);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	
	Calcul() {
		frame = new JFrame ("Calculatrice"); //Le nom de l'application.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // pour retourner la variable de la valeur et la modifier.
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textfield = new JTextField(); //pour les nombres qui vont etre affiché.
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myfont);
		textfield.setEditable(false);
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		equButton = new JButton("=");
		delButton = new JButton("del");
		decButton = new JButton(".");
		ClrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
		
		functionButton[0] = addButton;
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = equButton;
		functionButton[5] = delButton;
		functionButton[6] = decButton;
		functionButton[7] = ClrButton;
		functionButton[8] = negButton;
		
		
		for (int i = 0 ; i < 9 ; i++) {
			functionButton[i].addActionListener(this);
			//functionButton[i].setFont(myfont);
			functionButton[i].setFocusable(false);
		}
		
		for (int i = 0 ; i < 10 ; i++) {
			numberButton[i] = new JButton(String.valueOf(i)); // ValueOf: elle va nous permettre de récupérer les valeurs qui se trouve dans le tableau numberButton.
			numberButton[i].addActionListener(this);
			//numberButton[i].setFont(myfont);
			numberButton[i].setFocusable(false);
		}
		
		
		//Modification l'interface des bouttons
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		ClrButton.setBounds(250, 430, 100, 50);
		
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(4,4,10,10));
		
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButton[0]);
		
		panel.add(divButton);
		panel.add(equButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(ClrButton);
		frame.add(textfield);
		frame.setVisible(true);
		    
	}
	
	public void actionPerformed(ActionEvent e) {
		for (int i = 0 ; i < 10 ; i++) {
			if (e.getSource() == numberButton[i]) { //si lors de retour de la source de l'évennement est égale à celle du tableau
				textfield.setText(textfield.getText().concat(String.valueOf(i))); // contact : pour convertir les valeurs pour les afficher dans le text field
			}
		}
		    if (e.getSource() == decButton) {
		    	textfield.setText(textfield.getText().concat("."));
		    }
		    if (e.getSource() == addButton) {
		    	num1 = Double.parseDouble(textfield.getText()); //parseDouble pour convertir du text à nombre double.
		    	operator = '+';
		    	textfield.setText("");
		    }
		    if (e.getSource() == subButton) {
		    	num1 = Double.parseDouble(textfield.getText());
		    	operator = '-';
		    	textfield.setText("");
		    }
		    if (e.getSource() == mulButton) {
		    	num1 = Double.parseDouble(textfield.getText());
		    	operator = '*';
		    	textfield.setText("");
		    }
		    if (e.getSource() == divButton) {
		    	num1 = Double.parseDouble(textfield.getText());
		    	operator = '/';
		    	textfield.setText("");
		    }
		    if (e.getSource() == equButton) {
		    	num2 = Double.parseDouble(textfield.getText());
		    	switch (operator) {
		    	case '+' :
		    		result = num1 + num2;
		    		break;
		    	case '-' :
		    		result = num1 - num2;
		    		break;
		    	case '*' :
		    		result = num1 * num2;
		    		break;
		    	case '/' :
		    		result = num1 / num2;
		    		break;
		    	}
		    	
		    	//on doit convertir le nombre à chaine de caractère pour qu'elle puisse etre affiché dans le textfield
		    	textfield.setText(String.valueOf(result));
		    	num1 = result;
		    }
		    
		    if (e.getSource() == ClrButton) {
		    	textfield.setText("");
		    }
		    
		    if (e.getSource() == delButton) {
		    	String string = textfield.getText();
		    	textfield.setText("");
		    	for (int i = 0; i < string.length()-1; i++) {
		    		textfield.setText(textfield.getText()+string.charAt(i)); //charArt : pour convertir les chiffre à l'interier du tableau
		    	}
		    }
		    
		    if (e.getSource() == negButton) {
		    	double temps = Double.parseDouble(textfield.getText());
		    	temps *= -1;
		    	textfield.setText(String.valueOf(temps));
		    }
		    
	}
}
