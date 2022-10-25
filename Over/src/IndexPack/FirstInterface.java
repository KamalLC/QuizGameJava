package IndexPack;
import GamePack.*;
import InstructionPack.*;
import RulesPack.*;
import QuestionPack.*;
// import kamel.*;
// import register.*;
// import testFolder.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;

import java.sql.Connection;
import java.sql.Statement; 


import javax.swing.*;

public class FirstInterface implements ActionListener{
	JFrame myFrame;
    Connection conn;
    Statement stm;
    JButton b0, b1, b2, b3, b4, test;
    GridLayout gdl;
    public static FirstInterface fi;
    JLabel lbl, indexLabel;

    /**
     * @param FrameTitle
     */
    public FirstInterface(JFrame frame, Statement st){

        // super(FrameTitle);
        myFrame = frame;
        stm = st;

        System.out.println("reached FirstInterface");
        // frame.setSize(1000,1000);
        // frame.setLocation(10,10);
        // frame.setLayout(null);
        // frame.setVisible(true);
       
        indexLabel = new JLabel();
        indexLabel.setBounds(0, 0, 1000, 1000);
        indexLabel.setOpaque(true);
        indexLabel.setBackground(Color.decode("#FFFFFF"));
        

        lbl = new JLabel("!!!Welcome to Who wants to be a Millionare!!!");
        lbl.setBounds(200, 30, 1000, 100);
        lbl.setForeground(Color.BLACK);
        lbl.setFont(new Font("Times New Roman", Font.BOLD, 30));
        
        indexLabel.add(lbl);

        b0 = new JButton("Register");
        b0.setToolTipText("Click to Register");
        b0.setBounds(400, 180, 200, 50 );
        b0.setBackground(Color.YELLOW);
        b0.setForeground(Color.WHITE);
        
        
        indexLabel.add(b0);
        

        b1 = new JButton("Rules and Regulation");
        b1.setToolTipText("Click for Rules");
        b1.setBounds(400, 280, 200, 50);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        indexLabel.add(b1);

        b2 = new JButton("Play");
        b2.setBounds(400, 380, 200, 50);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        indexLabel.add(b2);

        b3 = new JButton("Instruction");
        b3.setBounds(400, 480, 200, 50);
        b3.setForeground(Color.white);
        b3.setBackground(Color.magenta);
        indexLabel.add(b3);

        b4 = new JButton("Exit");
        b4.setBounds(400, 580, 200, 50);
        b4.setForeground(Color.white);
        b4.setBackground(Color.black);
        indexLabel.add(b4);

        test = new JButton("Test");
        test.setBounds(400, 650, 200, 50);
        test.setBackground(Color.white);
        // add(test);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        test.addActionListener(this);


        frame.add(indexLabel);

    }
    public void actionPerformed(ActionEvent e){
        JButton eventSource = (JButton)e.getSource();
        
        if(eventSource == b2){
            
            indexLabel.setVisible(false);
            new PlayGame(myFrame, stm);

        }else if(eventSource == b3){
            
            indexLabel.setVisible(false);
            new Instruction(myFrame, stm);

        }else if(eventSource == b1){
            
            indexLabel.setVisible(false);
            new Rules(myFrame, stm);

        }
         else if(eventSource == b0){
            indexLabel.setVisible(false);
             new Question(myFrame, stm);
         }
        // else if(eventSource == test){
        //     new testFile("Register Section");
        // }
        
    }
    // public void windowClosing(WindowEvent e){
    //     this.dispose();
    // }
    // @Override
    // public void windowOpened(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void windowClosed(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void windowIconified(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void windowDeiconified(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void windowActivated(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
    // @Override
    // public void windowDeactivated(WindowEvent e) {
    //     // TODO Auto-generated method stub
        
    // }
//    public static void main(String[] args) {
//        FirstInterface fi = new FirstInterface("Quiz Game");
//
//       
//        // fi.getContentPane().setBackground(Color.WHITE);
//        // fi.setVisible(true);
//    }
}
