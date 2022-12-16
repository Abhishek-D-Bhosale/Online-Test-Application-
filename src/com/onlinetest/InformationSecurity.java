package com.onlinetest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationSecurity extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton[] jb =new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0;
    int current=0;
    int x=1;
    int now=0;
    int[] m =new int[10];
    InformationSecurity(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==19)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"Correct answers: "+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which one among these is not a primitive datatype?");
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");
        }
        if(current==1)
        {
            l.setText("Que2: Which class is the parent class of all classes in java?");
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
        }
        if(current==2)
        {
            l.setText("Que3: Which package is directly available to our classes?");
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
        }
        if(current==3)
        {
            l.setText("Que4: String class is defined in _ package.");
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
        }
        if(current==4)
        {
            l.setText("Que5:What is the size of long variable?");
            jb[0].setText("8 bit");jb[1].setText("16 bit");jb[2].setText("32 bit");jb[3].setText("64 bit");
        }
        if(current==5)
        {
            l.setText("Que6: Which one among these is not a keyword?");
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
        }
        if(current==6)
        {
            l.setText("Que7: Which one among these is not a class?");
            jb[0].setText("Applet");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");jb[3].setText("Button");
        }
        if(current==7)
        {
            l.setText("Que8: Which among these is not a function of Object class?");
            jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");
        }
        if(current==8)
        {
            l.setText("Que9: Which function is not found in Applet class?");
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
        }
        if(current==9)
        {
            l.setText("Que10: Which one among these is not a valid component?");
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");jb[3].setText("JTextArea");
        }

        if(current==10)
        {
            l.setText("Que11:  This is the parent of Error and Exception classes");
            jb[0].setText("Throwable");jb[1].setText("Catchable");jb[2].setText("MainError");jb[3].setText("MainExecption");/* Ans : Throwable  */
        }

        if(current==11)
        {
            l.setText("Que12:  What is the default value of float variable?");
            jb[0].setText("0.0d");jb[1].setText("0.0f");jb[2].setText("0");jb[3].setText("Not defined");    /* Ans : 0.0f */
        }

        if(current==12)
        {
            l.setText("Que13: Which of the following is false about String?");
            jb[0].setText("String is immutable");jb[1].setText("String can be created using new operator ");jb[2].setText(" String is a primary data type.");jb[3].setText("non of the above ");/* Ans : string is a primary data type */
        }

        if(current==13)
        {
            l.setText("Que14: which operator is considered to be with highest precedence?");
            jb[0].setText(" () , []");jb[1].setText("=");jb[2].setText("?");jb[3].setText("%");   /* ans : () , []*/
        }

        if(current==14)
        {
            l.setText("Que15: Which of the following is a thread safe?");
            jb[0].setText("StringBuilder");jb[1].setText("StringBuffer");jb[2].setText("Both of the above");jb[3].setText("None of the above");
        }

        if(current==15)
        {
            l.setText("Que16:  What is the default value of byte variable?");
            jb[0].setText("0");jb[1].setText("0.0");jb[2].setText("null");jb[3].setText("not defined");/* Ans : 0 */
        }

        if(current==16)
        {
            l.setText("Que17: Inheritance represents");
            jb[0].setText("Has-a-relationship");jb[1].setText("IS-a-relationship");jb[2].setText("Both of the above ");jb[3].setText("None of the above ");/* Is-a-relationship */
        }

        if(current==17)
        {
            l.setText("Que18:  What is an applet?");
            jb[0].setText("An applet is a Java program that runs in a Web browser");jb[1].setText("Applet is a tool ");jb[2].setText("both of the above ");jb[3].setText("none of the above ");
        }

        if(current==18)
        {
            l.setText("Que19:  What is Serialization?");
            jb[0].setText("writing the state of an object to another object ");jb[1].setText("writing the state of an object to byte stream");jb[2].setText("both of the above ");jb[3].setText("none of the above ");
        }


        if(current==19)
        {
            l.setText("Que20: Extension of java file is : ");
            jb[0].setText(".java");jb[1].setText(".py");jb[2].setText(".c");jb[3].setText(".j");
        }

        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        if(current==10)
            return(jb[0].isSelected());
        if(current==11)
            return(jb[1].isSelected());
        if(current==12)
            return(jb[2].isSelected());
        if(current==13)
            return(jb[0].isSelected());
        if(current==14)
            return(jb[1].isSelected());
        if(current==15)
            return(jb[0].isSelected());
        if(current==16)
            return(jb[1].isSelected());
        if(current==17)
            return(jb[0].isSelected());
        if(current==18)
            return(jb[1].isSelected());
        if(current==19)
            return(jb[0].isSelected());
        return false;
    }

    public static void main(String[] args) {
        new InformationSecurity("InformationSecurity");

    }
}
