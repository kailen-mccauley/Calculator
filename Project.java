import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout; 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
public class Project extends JFrame implements ActionListener{
    private JLabel output;
    private JButton clear;
    private JButton[] buttons;
    private JLabel labelPlus, labelSum,labelequal;
    private JButton buttonEquals;
    private JTextField text1, text2;
    private int box;
    public Project(){
        setSize(800,400);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        output=new JLabel(" ", JLabel.CENTER);
        clear= new JButton("AC");
        buttons=new JButton[20];
        for(int i=0; i<=9;i++){
            buttons[i]=new JButton(""+i);
        }
        buttons[10]= new JButton("+");
        buttons[11]= new JButton("*");
        buttons[12]= new JButton("/");
        buttons[13]= new JButton("-");
        buttons[14]= new JButton("=");
        buttons[15]= new JButton(".");
        buttons[16]= new JButton("ANS");
        buttons[17]= new JButton("box 1");
        buttons[18]= new JButton("box 2");
        buttons[19]=new JButton(".");
        labelPlus= new JLabel("+",JLabel.CENTER);
        labelequal= new JLabel("=",JLabel.CENTER);//overloaded construction for label using alignment
        labelSum= new JLabel("",JLabel.CENTER);//we can allign center or right(default is left
        text1= new JTextField();
        text2= new JTextField(); 
        JPanel center= new JPanel();
        center.setLayout(new GridLayout(5,5));
        center.add(text1);
        center.add(labelPlus);
        center.add(text2);
        center.add(labelequal);
        center.add(labelSum);
        center.add(buttons[14]);
        for(int i=7; i<=9;i++)
            center.add(buttons[i]);
        center.add(buttons[11]);
        center.add(buttons[16]);
        center.add(buttons[4]);
        for(int i=5; i<=6;i++)
            center.add(buttons[i]);
        center.add(buttons[13]);
        center.add(buttons[17]);
        for(int i=1; i<=3;i++)
            center.add(buttons[i]);
        center.add(buttons[10]);
        center.add(buttons[18]);
        center.add(buttons[14]);
        center.add(buttons[0]);
        center.add(buttons[19]);
        center.add(buttons[12]);
        center.add(clear);
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(center, BorderLayout.CENTER);
        for(int i=0; i<20; i++)
            buttons[i].addActionListener(this);
        clear.addActionListener(this);
        buttons[14].addActionListener(this);
        text1.addActionListener(this);
        text2.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed (ActionEvent e){
        String action=e.getActionCommand();
        if(action.equals("box 1"))
            box=1;
        if(action.equals("box 2"))
            box=2;
        for(int i=0; i<=9;i++)
            if(action.equals(buttons[i].getText())&& box==1)
                text1.setText(text1.getText()+buttons[i].getText());     
        for(int i=0; i<=9;i++)
            if(action.equals(buttons[i].getText())&& box==2)
                text2.setText(text2.getText()+buttons[i].getText());   
        if(action.equals("+"))
            labelPlus.setText("+");
        if(action.equals("-"))
            labelPlus.setText("-");
        if(action.equals("*"))
            labelPlus.setText("*");
        if(action.equals("/"))
            labelPlus.setText("/");
        if(action.equals("AC")){
            text1.setText("");
            text2.setText("");
            labelSum.setText("");
        }
        if(action.equals("=")){
           double num1=Double.parseDouble(text1.getText());
           double num2=Double.parseDouble(text2.getText());
           double sum=0;
           if(labelPlus.getText().equals("+"))
              sum=num1+num2;
           if(labelPlus.getText().equals("-"))
                sum=num1-num2;
           if(labelPlus.getText().equals("*"))
               sum=num1*num2;
           if(labelPlus.getText().equals("/"))
               sum=num1/num2;
           labelSum.setText(String.valueOf(sum));
        }
        if(action.equals(".") && box==1)
            text1.setText(text1.getText()+".");  
        if(action.equals(".") && box==2)
            text2.setText(text2.getText()+".");  
        if(action.equals("ANS")){
          text1.setText(labelSum.getText());
          text2.setText("");
          labelSum.setText("");
        }
    }
    public static void main(String[] args){
        Project t= new Project();
    }    
}

