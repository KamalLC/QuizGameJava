package IndexPack;
import GamePack.*;
import AccountPack.*;
import HistoryPack.*;
import InstructionPack.*;
import RulesPack.*;
import QuestionPack.*;
import LeaderBoardPack.*;
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
    private static final String ToolKit = null;
    // private static final String ToolKit = null;
    JFrame myFrame;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JButton rules, play, instruction, exit, test;
    JLabel register, QuestionAskedHistory, LeaderBoard, History, adminTool;
    GridLayout gdl;
    public static FirstInterface fi;
    JLabel lbl, indexLabel;
    int logged_in_flag = 0, player_id, admin_flag = 0;

    /**
     * @param FrameTitle
     */
    public FirstInterface(JFrame frame, Statement st){

        // super(FrameTitle);
        myFrame = frame;
        stm = st;

        checkLoggedIn();

        // System.out.println("reached FirstInterface");
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

        adminTool = new JLabel("Admin Tool");
        adminTool.setFont(new Font("MOnospace", Font.PLAIN, 20));
        adminTool.setForeground(Color.BLUE);
        adminTool.setOpaque(false);
        adminTool.setBounds(450, 100, 100, 25);
        indexLabel.add(adminTool);

        register = new JLabel("Register/Login");
        register.setFont(new Font("MOnospace", Font.PLAIN, 20));
        register.setForeground(Color.BLUE);
        register.setOpaque(false);
        register.setBounds(550, 100, 200, 25);
        indexLabel.add(register);

        History = new JLabel("My Game History");
        History.setFont(new Font("MOnospace", Font.PLAIN, 20));
        History.setForeground(Color.BLUE);
        History.setOpaque(false);
        History.setBounds(755, 100, 240, 25);
        indexLabel.add(History);

        QuestionAskedHistory = new JLabel("Question Asked");
        QuestionAskedHistory.setFont(new Font("MOnospace", Font.PLAIN, 20));
        QuestionAskedHistory.setForeground(Color.BLUE);
        QuestionAskedHistory.setOpaque(false);
        QuestionAskedHistory.setBounds(920, 100, 200, 25);
        indexLabel.add(QuestionAskedHistory);

        LeaderBoard = new JLabel("LeaderBoard");
        LeaderBoard.setFont(new Font("MOnospace", Font.PLAIN, 20));
        LeaderBoard.setForeground(Color.BLUE);
        LeaderBoard.setOpaque(false);
        LeaderBoard.setBounds(1100, 100, 120, 25);
        indexLabel.add(LeaderBoard);
        
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


      adminTool.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

      adminTool.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                
                indexLabel.setVisible(false);
                // this is for linking another file where should this label directs.
                new Question(myFrame, stm);
            } catch (Exception e1) {

                e1.printStackTrace();
            }
        }
    });


        register.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        register.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            // new Question(myFrame, stm); // TODO: comment this later
              try {
                 
                // indexLabel.setVisible(false);

                String q = "select * from login_details where logged_in = 'yes'";

                rst = stm.executeQuery(q);
                 
                if(rst.next()){
                    // if(rst.getString("admin_status").equals("accepted")){
                    //     indexLabel.setVisible(false);
                    //     new Question(myFrame, stm);
                    // }else{
                        q = "update login_details set logged_in = 'no' where logged_in = 'yes'";
                        stm.executeUpdate(q);
                        logged_in_flag = 0;
                        changeVisibility();
                        register.setText("Register/Login");
                    // }
                }else{
                    indexLabel.setVisible(false);
                    new Register(myFrame, stm);
                }
                  // this is for linking another file where should this label directs.
                  
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });

      History.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

      History.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                
                indexLabel.setVisible(false);
                // this is for linking another file where should this label directs.
                new MyHistory(myFrame, stm);
            } catch (Exception e1) {

                e1.printStackTrace();
            }
        }
    });

      QuestionAskedHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

      QuestionAskedHistory.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                
                indexLabel.setVisible(false);
                // this is for linking another file where should this label directs.
                new MyAccount(myFrame, stm);
            } catch (Exception e1) {

                e1.printStackTrace();
            }
        }
    });

    LeaderBoard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    LeaderBoard.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
          try {
              
            indexLabel.setVisible(false);
              // this is for linking another file where should this label directs.
              new LeaderBoard(myFrame, stm);
          } catch (Exception e1) {

              e1.printStackTrace();
          }
      }
  });



        frame.add(indexLabel);

        /**
         * 
         */
     changeVisibility();

    }
    public void close(){
        // WindowEvent closeWindow = new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING);
        // ToolKit.getDefaultToolkit().getSystemEventQueue.postEvent(closeWindow);
        myFrame.dispose();
    }

    public void changeVisibility(){
        if(logged_in_flag == 0){
            QuestionAskedHistory.setVisible(false);
            History.setVisible(false);
            adminTool.setVisible(false);
         }else{
            if(admin_flag == 1){      
                // register.setText("Admin Tool");
                adminTool.setVisible(true);
            }else{
                register.setText("Logout");
                adminTool.setVisible(false);
            }
         }
    }


    public void checkLoggedIn(){
        String query, lgIn;
        try{

            query = "select * from login_details where logged_in = 'yes'";
            rst = stm.executeQuery(query);
            if(rst.next()){
                logged_in_flag = 1;
                player_id = rst.getInt("id");
                lgIn = rst.getString("admin_status");
                if(lgIn.equals("accepted")){
                    admin_flag = 1;
                }
            }
        
        }catch(Exception ex){
            System.out.println("error in updatePlayerDatabase: " + ex.getMessage());
        }
    }
    

    public void actionPerformed(ActionEvent ae){
        JButton eventSource = (JButton)ae.getSource();
        
        if(eventSource == play){
            
            indexLabel.setVisible(false);
            new PlayGame(myFrame, stm);
            // try{
            //     String query = "select * from login_details where logged_in = 'yes'";

            //     rst = stm.executeQuery(query);
            //     if(rst.next()){
            //         new PlayGame(myFrame, stm);
            //     }else{
            //         new Register(myFrame, stm);
            //     }

            //     // System.out.println("success");
            //     // System.out.println(max);
            // }catch(Exception e){
            //     System.out.println("error: " + e.getMessage());
            //     // System.out.println(e.getMessage());
            // }

        }else if(eventSource == instruction){
            
            indexLabel.setVisible(false);
            new MyAccount(myFrame, stm);

        }else if(eventSource == rules){
            
            indexLabel.setVisible(false);
            new Register(myFrame, stm); // TODO: new Rules

        }
        else if(eventSource == exit)
            close();
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

