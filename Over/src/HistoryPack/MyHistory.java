package HistoryPack;

import java.awt.Dimension;
import IndexPack.*;
import GamePack.*;
import AccountPack.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet; 
import java.sql.Date;
import java.sql.Time;

public class MyHistory implements ActionListener {
    JFrame f;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JLabel lbl, back, sn, dateLbl, timeLbl, prizeLbl, prev, next, toplbl, homePage;
    JScrollPane scrollPane;
    ArrayList<Time> timeListList = new ArrayList<>();
    ArrayList<Integer> prizeList = new ArrayList<>();
    ArrayList<Date> dateList = new ArrayList<>();
    int reached = 0, totalQuestions = 0;

    JLabel[] snLabelList = new JLabel[10];
    JLabel[] dateLabelList = new JLabel[10];
    JLabel[] timeLabelList = new JLabel[10];
    JLabel[] prizeLabelList = new JLabel[10];


    
    public MyHistory(JFrame frame, Statement st){

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

        toplbl = new JLabel(" PRIZE WIN HISTORY ");
        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1300,75);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.add(toplbl);

        back = new JLabel(" < - - Back to Questions Asked ");
        back.setToolTipText("");
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
                        new MyAccount(f, stm);
                    } catch (Exception e1) {
        
                        e1.printStackTrace();
                    }
                }
            });

        homePage = new JLabel(" < - - HomePage ");
        homePage.setToolTipText(" Click for HomePage ");
        homePage.setFont(new Font("MOnospace", Font.PLAIN, 18));
        homePage.setForeground(new Color(205,0,0) );
        homePage.setOpaque(false);
        
        homePage.setBounds(500, 120, 200, 40);
        
        lbl.add(homePage);

        homePage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

              homePage.addMouseListener(new MouseAdapter() {
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

        dateLbl = new JLabel("Date");
        dateLbl.setOpaque(true);
        // dateLbl.setBackground(Color.decode("#FFFFFF"));
        dateLbl.setBackground( new Color(205, 0, 0) );
        
        dateLbl.setForeground(Color.WHITE);
        dateLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        dateLbl.setHorizontalAlignment(SwingConstants.CENTER);
        dateLbl.setVerticalAlignment(SwingConstants.CENTER);
        dateLbl.setVerticalAlignment(SwingConstants.CENTER);
        dateLbl.setBounds(190, 200, 80, 30);
        lbl.add(dateLbl);

        timeLbl = new JLabel("Time");
        timeLbl.setOpaque(true);
        timeLbl.setBackground( new Color(205, 0, 0) );
     
        timeLbl.setForeground(Color.WHITE);
        timeLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        timeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        timeLbl.setVerticalAlignment(SwingConstants.CENTER);
        
        timeLbl.setBounds(280, 200, 450, 30);
        lbl.add(timeLbl);

        prizeLbl = new JLabel("Amount Won");
        prizeLbl.setOpaque(true);
        // prizeLbl.setBackground(Color.decode("#FFFFFF"));
        prizeLbl.setBackground( new Color(205, 0, 0) );
        prizeLbl.setForeground(Color.WHITE);
        prizeLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        prizeLbl.setHorizontalAlignment(SwingConstants.CENTER);
        prizeLbl.setVerticalAlignment(SwingConstants.CENTER);
        prizeLbl.setBounds(740, 200, 300, 30);
        lbl.add(prizeLbl);
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

                System.out.println("reached: " + reached + ", size: " + dateList.size());

                if(reached >= dateList.size()){
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
                System.out.println("reached: " + reached + ", size: " + dateList.size());
                if(reached >= dateList.size()){
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
        // String timeTime, prizeInt;
        String query;
        int idInt, prizeInt;
        Date dateDate;
        Time timeTime;
        try{

            query = "select * from login_details where logged_in = 'yes'";
            rst = stm.executeQuery(query);
            if(rst.next()){
                user_id = rst.getInt("id");
            }
        
            query = "select * from win_history where user_id = " + user_id;

            rst = stm.executeQuery(query);
            while(rst.next()){
                temp++;
                JLabel snTemp, dateTemp, timeTemp, prizeTemp;
                JButton acc, rej;

                idInt = rst.getInt("user_id");
                dateDate = rst.getDate("date");
                timeTime = rst.getTime("time");
                prizeInt = rst.getInt("prize_won");

                dateList.add(dateDate);
                timeListList.add(timeTime);
                prizeList.add(prizeInt);

                // // idList.add(idInt);

                // snTemp = new JLabel("" + temp);
                // snTemp.setOpaque(true);
                // snTemp.setBackground(Color.decode("#FFFFFF"));
                // snTemp.setBounds(50, 200 + 50 * temp, 40, 30);
                // lbl.add(snTemp);

                // dateTemp = new JLabel("" + dateDate);
                // dateTemp.setOpaque(true);
                // dateTemp.setBackground(Color.decode("#FFFFFF"));
                // dateTemp.setBounds(100, 200 + 50 * temp, 240, 30);
                // lbl.add(dateTemp);

                // timeTemp = new JLabel(timeTime);
                // timeTemp.setOpaque(true);
                // timeTemp.setBackground(Color.decode("#FFFFFF"));
                // timeTemp.setBounds(350, 200 + 50 * temp, 240, 30);
                // lbl.add(timeTemp);

                // prizeTemp = new JLabel(prizeInt);
                // prizeTemp.setOpaque(true);
                // prizeTemp.setBackground(Color.decode("#FFFFFF"));
                // prizeTemp.setBounds(600, 200 + 50 * temp, 240, 30);
                // lbl.add(prizeTemp);

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
            System.out.println("Error in MyHistory: " + e.getMessage());
        }


        f.add(lbl);

        addQuestionLabels();
        fillLabels();

        if(reached >= dateList.size()){
            next.setVisible(false);
        }
    }

    public void addQuestionLabels(){
        JLabel snTemp, dateTemp, timeTemp, prizeTemp;
        JButton acc, rej;

        Time timeTime;
        int prizeInt;
        String query;
        int idInt, temp = 0;
        Date dateDate;

        while(temp < 10){

            snTemp = new JLabel("1");
            snTemp.setOpaque(true);
            snTemp.setBackground(Color.decode("#FFFFFF"));
            snTemp.setBounds(120, 230 + 30 * temp, 80, 30);
            lbl.add(snTemp);
            snLabelList[temp] = snTemp;

            dateTemp = new JLabel("2022-11-01");
            dateTemp.setOpaque(true);
            dateTemp.setBackground(Color.decode("#FFFFFF"));
            dateTemp.setBounds(210, 230 + 30 * temp, 80, 30);
            lbl.add(dateTemp);
            dateLabelList[temp] = dateTemp;

            timeTemp = new JLabel("19:31:23");
            timeTemp.setOpaque(true);
            timeTemp.setBackground(Color.decode("#FFFFFF"));
            timeTemp.setBounds(300, 230 + 30 * temp, 500, 30);
            lbl.add(timeTemp);
            timeLabelList[temp] = timeTemp;

            prizeTemp = new JLabel("$1000000");
            prizeTemp.setOpaque(true);
            prizeTemp.setBackground(Color.decode("#FFFFFF"));
            prizeTemp.setBounds(800, 230 + 30 * temp, 400, 30);
            lbl.add(prizeTemp);
            prizeLabelList[temp] = prizeTemp;

            temp++;
        }

    }

    public void fillLabels(){
        int temp = 0;
        int flag = 0;

        while(temp < 10){
            snLabelList[temp].setText("" + (reached + 1));
            dateLabelList[temp].setText("" + dateList.get(reached));
            timeLabelList[temp].setText("" + timeListList.get(reached));
            prizeLabelList[temp].setText("$" + prizeList.get(reached));

            if(reached + 1 == dateList.size()){
                flag = 1;
            }

            if(flag == 1){
                temp++;
                while(temp < 10){
                    snLabelList[temp].setText("");
                    dateLabelList[temp].setText("");
                    timeLabelList[temp].setText("");
                    prizeLabelList[temp].setText("");
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
