package AccountPack;

import java.awt.Dimension;
import IndexPack.*;
import GamePack.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet; 

public class MyAccount {
    JFrame f;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JLabel lbl, back, sn, levelLbl, questionLbl, answerLbl;
    JScrollPane scrollPane;
    
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
        lbl.setBounds(0, 0, 1000, 1000);
        // scrollPane.setPreferredSize(new Dimension(1000, 3000));
        // scrollPane = new JScrollPane(lbl);
        // setDimension();

        back = new JLabel("< - - HomePage ");
        back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        back.setForeground(new Color(205,0,0) );
        back.setOpaque(false);
        
        back.setBounds(232, 600, 160, 40);
        
        lbl.add(back);


        sn = new JLabel("S.N.");
        sn.setOpaque(true);
        sn.setBackground(Color.decode("#FFFFFF"));
        sn.setBounds(50, 200, 40, 30);
        lbl.add(sn);

        levelLbl = new JLabel("Level");
        levelLbl.setOpaque(true);
        levelLbl.setBackground(Color.decode("#FFFFFF"));
        levelLbl.setBounds(100, 200, 240, 30);
        lbl.add(levelLbl);

        questionLbl = new JLabel("Question");
        questionLbl.setOpaque(true);
        questionLbl.setBackground(Color.decode("#FFFFFF"));
        questionLbl.setBounds(350, 200, 240, 30);
        lbl.add(questionLbl);

        answerLbl = new JLabel("Answer");
        answerLbl.setOpaque(true);
        answerLbl.setBackground(Color.decode("#FFFFFF"));
        answerLbl.setBounds(600, 200, 150, 30);
        lbl.add(answerLbl);

        
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
        
            query = "select * from question_asked where user_id = " + user_id;

            rst = stm.executeQuery(query);
            while(rst.next()){
                temp++;
                JLabel snTemp, levelTemp, questionTemp, answerTemp;
                JButton acc, rej;

                idInt = rst.getInt("user_id");
                levelInt = rst.getInt("level");
                questionStr = rst.getString("question");
                answerStr = rst.getString("answer");

                // idList.add(idInt);

                snTemp = new JLabel("" + temp);
                snTemp.setOpaque(true);
                snTemp.setBackground(Color.decode("#FFFFFF"));
                snTemp.setBounds(50, 200 + 50 * temp, 40, 30);
                lbl.add(snTemp);

                levelTemp = new JLabel("" + levelInt);
                levelTemp.setOpaque(true);
                levelTemp.setBackground(Color.decode("#FFFFFF"));
                levelTemp.setBounds(100, 200 + 50 * temp, 240, 30);
                lbl.add(levelTemp);

                questionTemp = new JLabel(questionStr);
                questionTemp.setOpaque(true);
                questionTemp.setBackground(Color.decode("#FFFFFF"));
                questionTemp.setBounds(350, 200 + 50 * temp, 240, 30);
                lbl.add(questionTemp);

                answerTemp = new JLabel(answerStr);
                answerTemp.setOpaque(true);
                answerTemp.setBackground(Color.decode("#FFFFFF"));
                answerTemp.setBounds(600, 200 + 50 * temp, 240, 30);
                lbl.add(answerTemp);

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