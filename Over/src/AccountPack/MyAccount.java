package AccountPack;

import java.awt.Dimension;
import IndexPack.*;
import GamePack.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet; 

public class MyAccount implements ActionListener {
    JFrame f;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JLabel lbl, back, sn, levelLbl, questionLbl, answerLbl, prev, next, toplbl;
    JScrollPane scrollPane;
    ArrayList<String> questionList = new ArrayList<>();
    ArrayList<String> answerList = new ArrayList<>();
    ArrayList<Integer> levelList = new ArrayList<>();
    int reached = 0, totalQuestions = 0;

    JLabel[] snLabelList = new JLabel[10];
    JLabel[] levelLabelList = new JLabel[10];
    JLabel[] qsnLabelList = new JLabel[10];
    JLabel[] ansLabelList = new JLabel[10];


    
    public MyAccount(JFrame frame, Statement st){

        f = frame;
        stm = st;
        // f.setSize(1920,1080);
        // f.setLocation(10,10);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        // f.getContentPane().setBackground(new Color(51, 153, 255));
        // f.getContentPane().setBackground(new Color(51, 204, 255));
        // f.getContentPane().setBackground(new Color(0, 0, 204));
        f.getContentPane().setBackground(new Color(204, 204, 204));

        lbl = new JLabel();
        lbl.setOpaque(true);
        lbl.setBackground(Color.decode("#FFFFFF"));
        lbl.setBounds(0, 0, 1800, 1000);
        // scrollPane.setPreferredSize(new Dimension(1000, 3000));
        // scrollPane = new JScrollPane(lbl);
        // setDimension();

        toplbl = new JLabel(" QUESTION  ASKED ");
        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1300,75);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.add(toplbl);

        back = new JLabel(" < - - HomePage ");
        back.setToolTipText(" Click for HomePage ");
        back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        back.setForeground(new Color(205,0,0) );
        back.setOpaque(false);
        
        back.setBounds(100, 120, 200, 40);
        
        lbl.add(back);

        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

              back.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        System.out.println("inst quit");
                        lbl.setVisible(false);
                        lbl.setText("");
                        System.out.println("inst quit2");

                        // this is for linking another file where should this label directs.
                        new FirstInterface(f, stm);
                    } catch (Exception e1) {
        
                        e1.printStackTrace();
                    }
                }
            });


        sn = new JLabel("S.N.");
        sn.setOpaque(true);
        // sn.setBackground(Color.decode("#FFFFFF"));
        sn.setBackground( new Color(205, 0, 0) );
        sn.setBounds(100, 200, 80, 30);
        sn.setForeground(Color.WHITE);
        sn.setFont(new Font("MOnospace", Font.PLAIN, 15));
        sn.setHorizontalAlignment(SwingConstants.CENTER);
        sn.setVerticalAlignment(SwingConstants.CENTER);
        sn.setVerticalAlignment(SwingConstants.CENTER);
        lbl.add(sn);

        levelLbl = new JLabel("Level");
        levelLbl.setOpaque(true);
        // levelLbl.setBackground(Color.decode("#FFFFFF"));
        levelLbl.setBackground( new Color(205, 0, 0) );
        
        levelLbl.setForeground(Color.WHITE);
        levelLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        levelLbl.setHorizontalAlignment(SwingConstants.CENTER);
        levelLbl.setVerticalAlignment(SwingConstants.CENTER);
        levelLbl.setVerticalAlignment(SwingConstants.CENTER);
        levelLbl.setBounds(190, 200, 80, 30);
        lbl.add(levelLbl);

        questionLbl = new JLabel("Question");
        questionLbl.setOpaque(true);
        questionLbl.setBackground( new Color(205, 0, 0) );
     
        questionLbl.setForeground(Color.WHITE);
        questionLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        questionLbl.setVerticalAlignment(SwingConstants.CENTER);
        
        questionLbl.setBounds(280, 200, 450, 30);
        lbl.add(questionLbl);

        answerLbl = new JLabel("Answer");
        answerLbl.setOpaque(true);
        // answerLbl.setBackground(Color.decode("#FFFFFF"));
        answerLbl.setBackground( new Color(205, 0, 0) );
        answerLbl.setForeground(Color.WHITE);
        answerLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        answerLbl.setHorizontalAlignment(SwingConstants.CENTER);
        answerLbl.setVerticalAlignment(SwingConstants.CENTER);
        answerLbl.setBounds(740, 200, 300, 30);
        lbl.add(answerLbl);
        // back = new JLabel("< - - HomePage ");
        // back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        // back.setForeground(new Color(205,0,0) );
        // back.setOpaque(false);
        
        // back.setBounds(232, 600, 160, 40);
        
        // lbl.add(back);

        prev = new JLabel(" < - - Previous ");
        prev.setToolTipText(" Click for Previous Questions' Asked");
        prev.setFont(new Font("MOnospace", Font.PLAIN, 18));
        prev.setForeground(new Color(205,0,0) );
        prev.setOpaque(false);
        
        prev.setBounds(100, 600, 200, 40);
        
        lbl.add(prev);


        prev.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        prev.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                 
                // lbl.setVisible(false);
                // // this is for linking another file where should this label directs.
                // new FirstInterface(f, stm);
                reached = reached - 10;
                reached = reached / 10 * 10;
                fillLabels();

                System.out.println("reached: " + reached + ", size: " + levelList.size());

                if(reached >= levelList.size()){
                    next.setVisible(false);
                }else{
                    next.setVisible(true);
                }

                if(reached - 10 > 0){
                    prev.setVisible(true);
                }else{
                    prev.setVisible(false);
                }
               
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });

        prev.setVisible(false); //TODO: uncomment this later

        //         back = new JLabel("< - - HomePage ");
        // back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        // back.setForeground(new Color(205,0,0) );
        // back.setOpaque(false);
        
        // back.setBounds(232, 600, 160, 40);
        
        // lbl.add(back);

        next = new JLabel(" Next  - - > ");
        next.setFont(new Font("MOnospace", Font.PLAIN, 18));
        next.setForeground(new Color(205,0,0) );
        next.setOpaque(false);
        next.setToolTipText(" Click for Next Questions' Asked ");
        
        next.setBounds(945, 600, 200, 40);
        
        lbl.add(next);


        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        next.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                 
                // lbl.setVisible(false);
                // // this is for linking another file where should this label directs.
                // new FirstInterface(f, stm);
                fillLabels();
                System.out.println("reached: " + reached + ", size: " + levelList.size());
                if(reached >= levelList.size()){
                    next.setVisible(false);
                }else{
                    next.setVisible(true);
                }

                if(reached - 10 > 0){
                    prev.setVisible(true);
                }else{
                    prev.setVisible(false);
                }
               
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });



        
        int temp = 0, user_id = 1;
        String questionStr, answerStr;
        String query;
        int idInt, levelInt;
        try{

            query = "select * from login_details where logged_in = 'yes'";
            rst = stm.executeQuery(query);
            if(rst.next()){
                user_id = rst.getInt("id");
            }
        
            query = "select distinct user_id, level, question, answer from question_asked where user_id = " + user_id;

            rst = stm.executeQuery(query);
            while(rst.next()){
                temp++;
                JLabel snTemp, levelTemp, questionTemp, answerTemp;
                JButton acc, rej;

                idInt = rst.getInt("user_id");
                levelInt = rst.getInt("level");
                questionStr = rst.getString("question");
                answerStr = rst.getString("answer");

                levelList.add(levelInt);
                questionList.add(questionStr);
                answerList.add(answerStr);

                // // idList.add(idInt);

                // snTemp = new JLabel("" + temp);
                // snTemp.setOpaque(true);
                // snTemp.setBackground(Color.decode("#FFFFFF"));
                // snTemp.setBounds(50, 200 + 50 * temp, 40, 30);
                // lbl.add(snTemp);

                // levelTemp = new JLabel("" + levelInt);
                // levelTemp.setOpaque(true);
                // levelTemp.setBackground(Color.decode("#FFFFFF"));
                // levelTemp.setBounds(100, 200 + 50 * temp, 240, 30);
                // lbl.add(levelTemp);

                // questionTemp = new JLabel(questionStr);
                // questionTemp.setOpaque(true);
                // questionTemp.setBackground(Color.decode("#FFFFFF"));
                // questionTemp.setBounds(350, 200 + 50 * temp, 240, 30);
                // lbl.add(questionTemp);

                // answerTemp = new JLabel(answerStr);
                // answerTemp.setOpaque(true);
                // answerTemp.setBackground(Color.decode("#FFFFFF"));
                // answerTemp.setBounds(600, 200 + 50 * temp, 240, 30);
                // lbl.add(answerTemp);

                // acc = new JButton("ACCEPT");
                // acc.setBounds(600, 200 + 50 * temp, 140, 30);
                // acc.addActionListener(this);
                // lbl.add(acc);
                // acceptList.add(acc);

                // rej = new JButton("REJECT");
                // rej.setBounds(750, 200 + 50 * temp, 150, 30);
                // rej.addActionListener(this);
                // lbl.add(rej);
                // rejectList.add(rej);


            }
        }catch(Exception e){
            System.out.println("Error in MyAccount: " + e.getMessage());
        }


        f.add(lbl);

        addQuestionLabels();
        fillLabels();

        if(reached >= levelList.size()){
            next.setVisible(false);
        }
    }

    public void addQuestionLabels(){
        JLabel snTemp, levelTemp, questionTemp, answerTemp;
        JButton acc, rej;

        String questionStr, answerStr;
        String query;
        int idInt, levelInt, temp = 0;

        while(temp < 10){

            snTemp = new JLabel("1");
            snTemp.setOpaque(true);
            snTemp.setBackground(Color.decode("#FFFFFF"));
            snTemp.setBounds(120, 230 + 30 * temp, 80, 30);
            lbl.add(snTemp);
            snLabelList[temp] = snTemp;

            levelTemp = new JLabel("1");
            levelTemp.setOpaque(true);
            levelTemp.setBackground(Color.decode("#FFFFFF"));
            levelTemp.setBounds(210, 230 + 30 * temp, 80, 30);
            lbl.add(levelTemp);
            levelLabelList[temp] = levelTemp;

            questionTemp = new JLabel("Which is the national bird of the United States of America?");
            questionTemp.setOpaque(true);
            questionTemp.setBackground(Color.decode("#FFFFFF"));
            questionTemp.setBounds(300, 230 + 30 * temp, 500, 30);
            lbl.add(questionTemp);
            qsnLabelList[temp] = questionTemp;

            answerTemp = new JLabel("Alexander Graham Bell");
            answerTemp.setOpaque(true);
            answerTemp.setBackground(Color.decode("#FFFFFF"));
            answerTemp.setBounds(800, 230 + 30 * temp, 400, 30);
            lbl.add(answerTemp);
            ansLabelList[temp] = answerTemp;

            temp++;
        }

    }

    public void fillLabels(){
        int temp = 0;
        int flag = 0;

        while(temp < 10){
            snLabelList[temp].setText("" + (reached + 1));
            levelLabelList[temp].setText("" + levelList.get(reached));
            qsnLabelList[temp].setText(questionList.get(reached));
            ansLabelList[temp].setText(answerList.get(reached));

            if(reached + 1 == levelList.size()){
                flag = 1;
            }

            if(flag == 1){
                temp++;
                while(temp < 10){
                    snLabelList[temp].setText("");
                    levelLabelList[temp].setText("");
                    qsnLabelList[temp].setText("");
                    ansLabelList[temp].setText("");
                    temp++;
                }
            }

            reached++;
            temp++;
        }
    }


    public void actionPerformed(ActionEvent ae){
        // if(ae.getSource().equals(back)){
        //     lbl.setVisible(false);
        //     admin_lbl.setVisible(false);
        //     new FirstInterface(f, stm);
        // }
    }

    public void setDimension(){
        scrollPane.setPreferredSize(new Dimension(1000, 1000));
    }
    // public static void main(String[] args) {
    //     new Rules();
    // }


    // public static void main(String[] args) {
    //     JFrame frame = new JFrame();
    //     frame.setSize(1000,1000);
    //     frame.setLocation(10,10);
    //     frame.setLayout(null);
    //     frame.setVisible(true);
    //     frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    //     new Rules(frame);
    // }
}
