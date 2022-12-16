package com.onlinetest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2,b3,b4;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    Main(String s){

        super(s);
        l=new JLabel();
        add(l);
        l.setText("Welcome to Pratice paper.....set select an subject for exam");

        bg=new ButtonGroup();

        b1=new JButton("OadPaper");
        b2=new JButton("InformationSecurity");
        b3=new JButton("Csharp");
        b4=new JButton("JavaPaper");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OoadPaper page = new OoadPaper("OadPaper");
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InformationSecurity page = new InformationSecurity("InformationSecurity");
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Csharp page = new Csharp("Csharp");
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JavaPaper page = new JavaPaper("JavaPaper");
            }
        });

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        set();
        l.setBounds(30,10,450,20);

        b1.setBounds(75,50,100,30);
        b2.setBounds(400,50,100,30);
        b3.setBounds(75,100,100,30);
        b4.setBounds(400,100,100,30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

    }

    void set()
    {

    }


    public void actionPerformed(ActionEvent e){


    }

    public static void main(String[] args) {
	// write your code here
        new Main("pratice");
    }
}
