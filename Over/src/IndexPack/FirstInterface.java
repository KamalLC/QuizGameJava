package IndexPack;
import GamePack.*;
import AccountPack.*;
import HistoryPack.*;
import InstructionPack.*;
import RulesPack.*;
import QuestionPack.*;
import RegisterPack.*;
import java.awt.*;

// import kamel.*;
// import register.*;
// import testFolder.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


import javax.swing.*;

public class FirstInterface implements ActionListener{
    JFrame myFrame;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JButton rules, play, instruction, exit, test;
    JLabel register;
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
        indexLabel.setBounds(0, 0, 1800, 1000);
        indexLabel.setOpaque(true);
        indexLabel.setBackground(Color.decode("#FFFFFF"));
        
        lbl = new JLabel("Welcome to Who wants to be a Millionare");
        lbl.setForeground(Color.WHITE);
        lbl.setBounds(0, 0, 1300, 70);
        lbl.setFont(new Font("Monospace", Font.PLAIN, 20));
        lbl.setBackground(new Color(153,0,0) );
        lbl.setOpaque(true);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);

        indexLabel.add(lbl);

        // register = new JButton("Register");
        // register.setToolTipText("Click to Register");
        // register.setBounds(400, 180, 200, 50 );
        // register.setBackground(Color.YELLOW);
        // register.setForeground(Color.WHITE);
        
        // register = new JButton("Register");
        // register.setToolTipText("Click to Register");
        // register.setBounds(450, 150, 300, 50 );
        // register.setBackground( new Color(205, 0, 0) );
        // register.setForeground(Color.WHITE);
        
        // indexLabel.add(register);

        register = new JLabel("Register");
        register.setFont(new Font("MOnospace", Font.PLAIN, 20));
        register.setForeground(Color.BLUE);
        register.setOpaque(false);
        
        register.setBounds(1000, 100, 400, 22);
        indexLabel.add(register);
        
        rules = new JButton("Rules");
        rules.setToolTipText("Click for Rules");
        rules.setBounds(80, 250, 400, 70);
        rules.setBackground( new Color(205, 0, 0) );
        rules.setFont(new Font("MOnospace", Font.BOLD, 15));
        rules.setForeground(Color.white);
        indexLabel.add(rules);

        play = new JButton("play");
        
        play.setBounds(680, 250, 400, 70);
        play.setForeground(Color.white);
        play.setBackground( new Color(205, 0, 0) );
        play.setFont(new Font("MOnospace", Font.BOLD, 15));
        indexLabel.add(play);

        // instruction = new JButton("Instruction");
        // instruction.setBounds(400, 480, 200, 50);
        // instruction.setForeground(Color.white);
        // instruction.setBackground(Color.magenta);

        instruction = new JButton("Instruction");
        instruction.setBounds(80, 420, 400, 70);
        instruction.setForeground(Color.white);
        instruction.setBackground( new Color(205, 0, 0) );
        instruction.setFont(new Font("MOnospace", Font.BOLD, 15));
        indexLabel.add(instruction);

        // exit = new JButton("Exit");
        // exit.setBounds(400, 580, 200, 50);
        // exit.setForeground(Color.white);
        // exit.setBackground(Color.black);

        exit = new JButton("Exit");
        exit.setBounds(680, 420, 400, 70);
        exit.setForeground(Color.white);
        exit.setBackground( new Color(205, 0, 0) );
        exit.setFont(new Font("MOnospace", Font.BOLD, 15));
        indexLabel.add(exit);

        test = new JButton("Test");
        test.setBounds(400, 650, 200, 50);
        test.setBackground(Color.white);
        // add(test);

        // register.addActionListener(this);
        rules.addActionListener(this);
        play.addActionListener(this);
        instruction.addActionListener(this);
        exit.addActionListener(this);
        test.addActionListener(this);

        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        register.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            // new Question(myFrame, stm); // TODO: comment this later
              try {
                 
                indexLabel.setVisible(false);

                String q = "select * from login_details where logged_in = 'yes'";

                rst = stm.executeQuery(q);
                 
                if(rst.next()){
                    if(rst.getString("admin_status").equals("accepted")){
                        new Question(myFrame, stm);
                    }
                }else{
                    new Register(myFrame, stm);
                }
                  // this is for linking another file where should this label directs.
                  
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });


        frame.add(indexLabel);

        

    }
    public void actionPerformed(ActionEvent ae){
        JButton eventSource = (JButton)ae.getSource();
        
        if(eventSource == play){
            
            indexLabel.setVisible(false);
            try{
                String query = "select * from login_details where logged_in = 'yes'";

                rst = stm.executeQuery(query);
                if(rst.next()){
                    new PlayGame(myFrame, stm);
                }else{
                    new Register(myFrame, stm);
                }

                // System.out.println("success");
                // System.out.println(max);
            }catch(Exception e){
                System.out.println("error: " + e.getMessage());
                // System.out.println(e.getMessage());
            }

        }else if(eventSource == instruction){
            
            indexLabel.setVisible(false);
            new MyAccount(myFrame, stm);

        }else if(eventSource == rules){
            
            indexLabel.setVisible(false);
            new PlayGame(myFrame, stm); // TODO: new Rules

        }
        //  else if(eventSource == register){
        //     indexLabel.setVisible(false);
        //      new Question(myFrame, stm);
        //  }
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
