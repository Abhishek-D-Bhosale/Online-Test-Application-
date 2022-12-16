package com.onlinetest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class test1 extends JFrame implements ActionListener {

    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];

    test1(String s){

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

    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1:In G=(V,E), the value of v should be ....");
            jb[0].setText(">0");jb[1].setText("0");jb[2].setText("<0");jb[3].setText("infinite");
        }
        if(current==1)
        {
            l.setText("Que2: The degree of any vertex of graph is .... ?   ");
            jb[0].setText("The number of edges incident with vertex");jb[1].setText("Number of vertex in a graph");jb[2].setText("Number of vertices adjacent to that vertex");jb[3].setText("Number of edges in a graph");
        }
        if(current==2)
        {
            l.setText("Que3:A graph with no edges is known as empty graph. Empty graph is also known as... ? ");
            jb[0].setText("Trivial graph");jb[1].setText("Regular graph");jb[2].setText("Bipartite graph");jb[3].setText("None of these");
        }
        if(current==3)
        {
            l.setText("Que4: A graph G is called a ..... if it is a connected acyclic graph ");
            jb[0].setText("cyclic graph ");jb[1].setText("Regular graph");jb[2].setText("Tree");jb[3].setText("non of these");
        }
        if(current==4)
        {
            l.setText("Que5: A graph is a collection of ....");
            jb[0].setText("Row and columns");jb[1].setText("Vertices and edges");jb[2].setText("None of these");
        }
        if(current==5)
        {
            l.setText("Que6:If the origin and terminus of a walk are same, the walk is known as... ? ");
            jb[0].setText("open");jb[1].setText("close");jb[2].setText("path");jb[3].setText("non of these");
        }
        if(current==6)
        {
            l.setText("Que7: A minimal spanning tree of a graph G is ");
            jb[0].setText("A spanning sub graph");jb[1].setText("A tree");jb[2].setText("Minimum weights");jb[3].setText("All of above");
        }
        if(current==7)
        {
            l.setText("Que8: A partial ordered relation is transitive, reflexive and ");
            jb[0].setText("Antisymmetric");jb[1].setText("Bisymmetric");jb[2].setText("Anti reflexive");jb[3].setText("Asymmetric");
        }
        if(current==8)
        {
            l.setText("Que9: A continuous non intersecting curve in the plane whose origin and terminus coincide");
            jb[0].setText("Planer");jb[1].setText("Jordan");jb[2].setText("Hamiltonian");jb[3].setText("All of these");
        }
        if(current==9)
        {
            l.setText("Que10:The maximum degree of any vertex in a simple graph with n vertices is ");
            jb[0].setText("n–1");jb[1].setText("n+1");jb[2].setText("2n–1 ");jb[3].setText("n");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if(e.getSource()==b1)
            {
                if(check())
                    count=count+1;
                current++;
                set();
                if(current==9)
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


    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[1].isSelected());
        if(current==2)
            return(jb[1].isSelected());
        if(current==3)
            return(jb[3].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[4].isSelected());
        if(current==7)
            return(jb[1].isSelected());
        if(current==8)
            return(jb[2].isSelected());
        if(current==9)
            return(jb[1].isSelected());
        return false;
    }
    public static void main(String[] args) {
        new test1("hello");
    }
}
