import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculatorEngine implements ActionListener {
 
 Calculator parent; // a reference to the Calculator
	
 // Constructor stores the reference to the 
 // Calculator window in  the member variable parent
 CalculatorEngine(Calculator parent)
 {
   this.parent = parent;
 }

    double firstArg;
    double result;
    String[] operations={"+","-","*","/","^"};
    String operation;

 public void actionPerformed(ActionEvent e){
   // Get the source of this action
   JButton clickedButton =  (JButton) e.getSource();
   	
   // Get the existing text from the Calculator's
   // display field. Reaching inside another object is bad.
   String dispFieldText = parent.getDisplayValue();


   // Calculating
   String clickedButtonLabel = clickedButton.getText();
     parent.setDisplayValue(dispFieldText + clickedButtonLabel);
     for (String a: operations) {
         if (clickedButtonLabel.equals(a)){
             operation=a;
             firstArg = Double.parseDouble(dispFieldText);
             parent.setDisplayValue(null);
         }
     }
     if (clickedButtonLabel.equals("=")){
         double secondArg = Double.parseDouble(dispFieldText);
         switch (operation){
             case "+": result = firstArg + secondArg;
                 break;
             case "-": result = firstArg - secondArg;
                 break;
             case "*": result = firstArg * secondArg;
                 break;
             case "/": result = firstArg / secondArg;
                 break;
             case "^": result = Math.pow(firstArg,secondArg);
                 break;
         }
         parent.setDisplayValue(String.valueOf(result));
         } else {
         if (clickedButtonLabel.equals("Clear")) {
             parent.setDisplayValue(null);
         }
     }
     }
 }

