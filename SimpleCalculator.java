/* Name: Jonathan Price
   Date: 12/5/2018
   Class: CIT-130-Z04B
   
   The purpose of this file is to implement a simple
   calculator with a working GUI. */
   
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculator extends JFrame implements ActionListener
{
   //Hold total, stored amount, stored operator, total's display & field, and input string
   private double total = 0;
   private double storedAmount = 0;
   private String storedOperator = "";
   private String totalDisplay = "";
   private String inputString = "";
   private JTextField totalField;
   
   //Main program
   public static void main(String[] args)
   {
      //Create the calculator and set its visability
      SimpleCalculator calc = new SimpleCalculator();
      calc.setVisible(true);
   }
   
   //Constructor method
   public SimpleCalculator()
   {
      //Create the window and set the default close operation
      setTitle("Simple Calculator: Jonathan Price, 18FA");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300, 325);
      setVisible(true);
      
      //Create and set the window's base panel
      JPanel basePanel = new JPanel();
      setLayout(new BorderLayout());
      add(basePanel,BorderLayout.CENTER);
      basePanel.setLayout(new GridLayout(1,1));
      basePanel.setSize(300, 125);
      
      //Create and set the window's text panel and text field
      JPanel textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      basePanel.add(textPanel, BorderLayout.CENTER);
      totalField = new JTextField();
      textPanel.add(totalField);
      totalField.setSize(300, 125);
        
      //Create and add buttons
      JPanel buttonPanel = new JPanel();
      add(buttonPanel, BorderLayout.SOUTH);
      buttonPanel.setLayout(new GridLayout(4, 4));
      JButton button1 = new JButton("1");
      button1.addActionListener(this);
      buttonPanel.add(button1);
      JButton button2 = new JButton("2");
      button2.addActionListener(this);
      buttonPanel.add(button2);
      JButton button3 = new JButton("3");
      button3.addActionListener(this);
      buttonPanel.add(button3);
      JButton buttonDiv = new JButton("/");
      buttonDiv.addActionListener(this);
      buttonPanel.add(buttonDiv);
      JButton button4 = new JButton("4");
      button4.addActionListener(this);
      buttonPanel.add(button4);
      JButton button5 = new JButton("5");
      button5.addActionListener(this);
      buttonPanel.add(button5);
      JButton button6 = new JButton("6");
      button6.addActionListener(this);
      buttonPanel.add(button6);
      JButton buttonMult = new JButton("*");
      buttonMult.addActionListener(this);
      buttonPanel.add(buttonMult);
      JButton button7 = new JButton("7");
      button7.addActionListener(this);
      buttonPanel.add(button7);
      JButton button8 = new JButton("8");
      button8.addActionListener(this);
      buttonPanel.add(button8);
      JButton button9 = new JButton("9");
      button9.addActionListener(this);
      buttonPanel.add(button9);
      JButton buttonSub = new JButton("-");
      buttonSub.addActionListener(this);
      buttonPanel.add(buttonSub);
      JButton buttonClear = new JButton("C");
      buttonClear.addActionListener(this);
      buttonPanel.add(buttonClear);
      JButton button0 = new JButton("0");
      button0.addActionListener(this);
      buttonPanel.add(button0);
      JButton buttonEquals = new JButton("=");
      buttonEquals.addActionListener(this);
      buttonPanel.add(buttonEquals);
      JButton buttonAdd = new JButton("+");
      buttonAdd.addActionListener(this);
      buttonPanel.add(buttonAdd);
   }
   
   //Create method for button actions
   public void actionPerformed(ActionEvent e)
   {
      //Hold which button was clicked
      String buttonClick = e.getActionCommand();
      
      //Set the responses for the buttons
      switch (buttonClick)
      {
         case "1":
            inputString = (inputString + "1");
            totalField.setText(inputString);
            break;
         case "2":
            inputString = (inputString + "2");
            totalField.setText(inputString);
            break;
         case "3":
            inputString = (inputString + "3");
            totalField.setText(inputString);
            break;
         case "4":
            inputString = (inputString + "2");
            totalField.setText(inputString);
            break;
         case "5":
            inputString = (inputString + "5");
            totalField.setText(inputString);
            break;
         case "6":
            inputString = (inputString + "6");
            totalField.setText(inputString);
            break;
         case "7":
            inputString = (inputString + "7");
            totalField.setText(inputString);
            break;
         case "8":
            inputString = (inputString + "8");
            totalField.setText(inputString);
            break;
         case "9":
            inputString = (inputString + "9");
            totalField.setText(inputString);
            break;
         case "0":
            inputString = (inputString + "0");
            totalField.setText(inputString);
            break;
         case "+":
         case "-":
         case "*":
         case "/":
         case "=":
            //Call on seperate method for operation buttons
            operatorAction(buttonClick, inputString);
            inputString = "";
            break;
         case "C":
            inputString = "";
            total = 0;
            storedAmount = 0;
            storedOperator = "";
            totalDisplay = "";
            totalField.setText(inputString);
            break;
      }
   }
   
   //Create method to define operator button actions
   public void operatorAction(String operator, String inputString)
   {
      double input;
      
      //Set the input
      if (inputString == "")
      {
         input = 0;
      }
      else
      {
         input = Double.parseDouble(inputString.trim());
      }
      
      if (storedOperator != "")
      {
         if (storedAmount != 0)
         {
            total = calculate(storedAmount, input);
            storedAmount = 0;      
         }
         else if (total != 0)
         {    
            total = calculate(total, input);
            storedAmount = 0;
         }
      
         //Display total
         totalDisplay = (Double.toString(total));
         totalField.setText(totalDisplay);
         
         //Set the operator
         if (operator == "=")
         {
            storedOperator = "";
            totalField.setText(totalDisplay);
         }
         else
         {
            storedOperator = operator;
         }
      }
    
      if (total == 0)
      {
         total = input;
      }
      
      if (storedOperator == "")
      {
         storedAmount = input;
         storedOperator = operator;
      } 
   }
   
   //Create method to do calculations
   public double calculate(double num1, double num2)
   {
      double result = 0;
      
      //Switch operation based on user action
      switch (storedOperator)
      {
         case "+":
            result = num1 + num2;
            break;
         case "-":
            result = num1 - num2;
            break;
         case "*":
            result = num1 * num2;
            break;
         case "/":
            result = num1 / num2;
            break;
      }
      
      return result;
   }
}     