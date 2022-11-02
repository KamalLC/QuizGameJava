/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionPack;

import GamePack.*;
import IndexPack.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class Question implements ActionListener {
    JFrame f;
    Connection conn;
    Statement stm;
    ResultSet rst;
    JLabel sn, email, name;
    JLabel lbl, admin_lbl,toplbl, questionLbl, option1Lbl, option2Lbl, option3Lbl, option4Lbl, cor_ansLbl, levelLbl, submit, back;
    JTextField question, option1, option2, option3, option4, cor_ans, level;
    JButton back_to_admin, accept, reject, admin_request;
    String[] levelOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    int[] levelOptionsInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    JComboBox<String> levelComboBox = new JComboBox<>(levelOptions);
    String[] optionOptions = {"Option1", "Option2", "Option3", "Option4"};
    JComboBox<String> optionComboBox = new JComboBox<>(optionOptions);
    ArrayList<Integer> idList = new ArrayList<>();
    ArrayList<JButton> acceptList = new ArrayList<>();
    ArrayList<JButton> rejectList = new ArrayList<>();

    int userId;
    
    public Question(JFrame frame, Statement st){ //, Statement st
        // System.out.println("reached instruction interface");
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

        toplbl = new JLabel("REGISTER SECTION");
        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1300, 55);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.add(toplbl);

        // levelLbl = new JLabel("Level: ");
        // levelLbl.setOpaque(true);
        // levelLbl.setBounds(150, 120, 50+80, 40);
        // levelLbl.setForeground(Color.WHITE);
        // levelLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // levelLbl.setHorizontalAlignment(SwingConstants.CENTER);
        // levelLbl.setVerticalAlignment(SwingConstants.CENTER);
        // levelLbl.setBackground(new Color(205,0,0) );
        // lbl.add(levelLbl);

        levelLbl = new JLabel("Level: ");
        levelLbl.setOpaque(true);
        levelLbl.setBounds(250, 120, 160, 40);
        levelLbl.setForeground(Color.WHITE);
        levelLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        levelLbl.setHorizontalAlignment(SwingConstants.CENTER);
        levelLbl.setVerticalAlignment(SwingConstants.CENTER);
        levelLbl.setBackground(new Color(205,0,0) );
        lbl.add(levelLbl);

        // levelComboBox.setBounds(340, 120, 80, 40);
        // levelComboBox.setBackground( new Color(204, 204, 204) );

        // lbl.add(levelComboBox);
        levelComboBox.setBounds(480, 120, 80, 40);
        levelComboBox.setBackground( new Color(204, 204, 204) );

        lbl.add(levelComboBox);

        // questionLbl = new JLabel("Question: ");
        // questionLbl.setOpaque(true);
        // questionLbl.setBounds(100, 150, 50+40, 30);
        // questionLbl.setForeground(Color.WHITE);
        // questionLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        // questionLbl.setVerticalAlignment(SwingConstants.CENTER);
        // questionLbl.setBackground(new Color(205,0,0) );

        // lbl.add(questionLbl);

        questionLbl = new JLabel("Question: ");
        questionLbl.setOpaque(true);
        questionLbl.setBounds(250, 190, 160, 40);
        questionLbl.setForeground(Color.WHITE);
        questionLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        questionLbl.setVerticalAlignment(SwingConstants.CENTER);
        questionLbl.setBackground(new Color(205,0,0) );

        lbl.add(questionLbl);

        // question = new JTextField();
        // question.setBounds(200, 150, 400, 30);
        // question.setBackground( new Color(204, 204, 204) );
        // lbl.add(question);

        // option1Lbl = new JLabel("Option1: ");
        // option1Lbl.setOpaque(true);
        // option1Lbl.setBounds(100, 200, 50+40, 30);
        // option1Lbl.setForeground(Color.WHITE);
        // option1Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // option1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        // option1Lbl.setVerticalAlignment(SwingConstants.CENTER);
        // option1Lbl.setBackground(new Color(205,0,0) );
        // lbl.add(option1Lbl);

        question = new JTextField();
        question.setBounds(480, 190, 500, 40);
        question.setBackground( new Color(204, 204, 204) );
        lbl.add(question);

        option1Lbl = new JLabel("Option1: ");
        option1Lbl.setOpaque(true);
        option1Lbl.setBounds(250, 260, 160, 40);
        option1Lbl.setForeground(Color.WHITE);
        option1Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option1Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option1Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option1Lbl);

        // option1 = new JTextField();
        // option1.setBounds(200, 200, 400, 30);
        // option1.setBackground( new Color(204, 204, 204) );
        // lbl.add(option1);

        option1 = new JTextField();
        option1.setBounds(480, 260, 500, 40);
        option1.setBackground( new Color(204, 204, 204) );
        lbl.add(option1);

        // option2Lbl = new JLabel("Option2: ");
        // option2Lbl.setOpaque(true);
        // option2Lbl.setBounds(100, 250, 50+40, 30);
        // option2Lbl.setForeground(Color.WHITE);
        // option2Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // option2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        // option2Lbl.setVerticalAlignment(SwingConstants.CENTER);
        // option2Lbl.setBackground(new Color(205,0,0) );
        // lbl.add(option2Lbl);

        option2Lbl = new JLabel("Option2: ");
        option2Lbl.setOpaque(true);
        option2Lbl.setBounds(250, 330, 160, 40);
        option2Lbl.setForeground(Color.WHITE);
        option2Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option2Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option2Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option2Lbl);

        // option2 = new JTextField();
        // option2.setBounds(200, 250, 400, 30);
        // option2.setBackground( new Color(204, 204, 204) );
        // lbl.add(option2);

        option2 = new JTextField();
        option2.setBounds(480, 330, 500, 40);
        option2.setBackground( new Color(204, 204, 204) );
        lbl.add(option2);

        option3Lbl = new JLabel("Option3: ");
        // option3Lbl.setOpaque(true);
        // option3Lbl.setBounds(100, 300, 50+40, 30);
        // option3Lbl.setForeground(Color.WHITE);
        // option3Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // option3Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        // option3Lbl.setVerticalAlignment(SwingConstants.CENTER);
        // option3Lbl.setBackground(new Color(205,0,0) );
        // lbl.add(option3Lbl);

        option3Lbl = new JLabel("Option3: ");
        option3Lbl.setOpaque(true);
        option3Lbl.setBounds(250, 400, 160, 40);
        option3Lbl.setForeground(Color.WHITE);
        option3Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option3Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option3Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option3Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option3Lbl);

        // option3 = new JTextField();
        // option3.setBounds(200, 300, 400, 30);
        // option3.setBackground( new Color(204, 204, 204) );
        // lbl.add(option3);

        // option4Lbl = new JLabel("Option4: ");
        // option4Lbl.setOpaque(true);
        // option4Lbl.setBounds(100, 350, 50+40, 30);
        // option4Lbl.setForeground(Color.WHITE);
        // option4Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // option4Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        // option4Lbl.setVerticalAlignment(SwingConstants.CENTER);
        // option4Lbl.setBackground(new Color(205,0,0) );
        // lbl.add(option4Lbl);

        option3 = new JTextField();
        option3.setBounds(480, 400, 500, 40);
        option3.setBackground( new Color(204, 204, 204) );
        lbl.add(option3);

        option4Lbl = new JLabel("Option4: ");
        option4Lbl.setOpaque(true);
        option4Lbl.setBounds(250, 470, 160, 40);
        option4Lbl.setForeground(Color.WHITE);
        option4Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option4Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option4Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option4Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option4Lbl);

        // option4 = new JTextField();
        // option4.setBounds(200, 350, 400, 30);
        // option4.setBackground( new Color(204, 204, 204) );
        // lbl.add(option4);

        // cor_ansLbl = new JLabel("Right Ans: ");
        // cor_ansLbl.setOpaque(true);
        // cor_ansLbl.setBounds(100, 400, 50+40, 30);
        // cor_ansLbl.setForeground(Color.WHITE);
        // cor_ansLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        // cor_ansLbl.setHorizontalAlignment(SwingConstants.CENTER);
        // cor_ansLbl.setVerticalAlignment(SwingConstants.CENTER);
        // cor_ansLbl.setBackground(new Color(205,0,0) );
        // lbl.add(cor_ansLbl);

        option4 = new JTextField();
        option4.setBounds(480, 470, 500, 40);
        option4.setBackground( new Color(204, 204, 204) );
        lbl.add(option4);

        cor_ansLbl = new JLabel("Right Ans: ");
        cor_ansLbl.setOpaque(true);
        cor_ansLbl.setBounds(250, 540, 160, 40);
        cor_ansLbl.setForeground(Color.WHITE);
        cor_ansLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        cor_ansLbl.setHorizontalAlignment(SwingConstants.CENTER);
        cor_ansLbl.setVerticalAlignment(SwingConstants.CENTER);
        cor_ansLbl.setBackground(new Color(205,0,0) );
        lbl.add(cor_ansLbl);


        
        // optionComboBox.setBounds(200, 400, 100, 30);
        // optionComboBox.setBackground( new Color(204, 204, 204) );
        // lbl.add(optionComboBox);

        // submit = new JButton("Submit");
        // submit.setBounds(150, 450, 150, 30);
        // submit.setForeground(Color.white);
        // submit.setBackground( new Color(205, 0, 0) );
        // lbl.add(submit);
        // submit.addActionListener(this);

        optionComboBox.setBounds(480,540, 100, 40);
        optionComboBox.setBackground( new Color(204, 204, 204) );
        lbl.add(optionComboBox);

        submit = new JLabel("Submit");
        submit.setBounds(150, 450, 150, 30);
        submit.setForeground(Color.white);
        submit.setBackground( new Color(205, 0, 0) );
        lbl.add(submit);
        

        // back = new JButton("Home");
        // back.setBounds(300, 550, 150, 30);
        // back.setForeground(Color.white);
        // back.setBackground( new Color(205, 0, 0) );
        
        // lbl.add(back);
        // back.addActionListener(this);
        back = new JLabel("< - - HomePage ");
        back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        back.setForeground(new Color(205,0,0) );
        back.setOpaque(false);
        
        back.setBounds(232, 600, 160, 40);
        
        lbl.add(back);

        submit = new JLabel("Submit - - >");
        submit.setFont(new Font("MOnospace", Font.PLAIN, 18));
        submit.setForeground(new Color(205,0,0) );
        submit.setOpaque(false);
        
        submit.setBounds(1000, 600, 160, 40);
        
        lbl.add(submit);


        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        back.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                 
                lbl.setVisible(false);
                // this is for linking another file where should this label directs.
                new FirstInterface(f, stm);
               
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });

      submit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

      submit.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            try {
               
                String qsn, op1, op2, op3, op4, corr;
                int lev;
    
                lev = Integer.parseInt(levelComboBox.getItemAt(levelComboBox.getSelectedIndex()));
    
                qsn = question.getText();
                op1 = option1.getText();
                op2 = option2.getText();
                op3 = option3.getText();
                op4 = option4.getText();
    
                String[] optionList = {op1, op2, op3, op4};
                corr = optionList[optionComboBox.getSelectedIndex()];
                System.out.println(lev);
    
                
                    // stm = conn.createStatement();
                    System.out.println("testing");
                    String query = "INSERT INTO question_list(question, option_a, option_b, option_c, option_d, correct_answer, level) VALUES('"+qsn+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+corr+"','"+lev+"')";
                    System.out.println("testing 2");
                    stm.executeUpdate(query);
                    System.out.println("Inserted into table");
                    question.setText("");
                    option1.setText("");
                    option2.setText("");
                    option3.setText("");
                    option4.setText("");
                
             
            } catch (Exception e1) {

                e1.printStackTrace();
            }
        }
    });
    
      


        admin_request = new JButton("ADMIN REQUEST");
        admin_request.setBounds(1120, 65, 150, 40);
        admin_request.setForeground(Color.white);
        admin_request.setBackground( new Color(205, 0, 0) );
        lbl.add(admin_request);
        admin_request.addActionListener(this);
        
        f.add(lbl);
        // lbl.setVisible(false);

        addAdminLabel();
        admin_lbl.setVisible(false);
    }

    public void addAdminLabel(){

       
        admin_lbl = new JLabel();
        admin_lbl.setOpaque(true);
        admin_lbl.setBackground(Color.decode("#FFFFFF"));
        admin_lbl.setBounds(0, 0, 1800, 1000);

        toplbl = new JLabel("ADMIN ACCESS REQUEST");
        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1300,75);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);
        admin_lbl.add(toplbl);

        // back_to_admin = new JButton("BACK");
        // back_to_admin.setBounds(200, 600, 200, 40);
        // back_to_admin.setForeground(Color.white);
        // back_to_admin.setBackground( new Color(205, 0, 0) );
        // admin_lbl.add(back_to_admin);
        // back_to_admin.addActionListener(this);

        back = new JLabel("< - - BACK ");
        back.setFont(new Font("MOnospace", Font.PLAIN, 18));
        back.setForeground(new Color(205,0,0) );
        back.setOpaque(false);
        
        back.setBounds(80, 600, 160, 40);
        
        admin_lbl.add(back);

        sn = new JLabel("S.N.");
        sn.setOpaque(true);
        // sn.setBackground(Color.decode("#FFFFFF"));
        sn.setForeground(Color.WHITE);
        sn.setFont(new Font("MOnospace", Font.PLAIN, 15));
        sn.setHorizontalAlignment(SwingConstants.CENTER);
        sn.setVerticalAlignment(SwingConstants.CENTER);
        sn.setBackground(new Color(205,0,0) );
        sn.setOpaque(true);
        sn.setBounds(80, 150, 80, 40);
        admin_lbl.add(sn);

        name = new JLabel("NAME");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("MOnospace", Font.PLAIN, 15));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBackground(new Color(205,0,0) );
        name.setOpaque(true);
        name.setBounds(170, 150, 240, 40);
        admin_lbl.add(name);

        email = new JLabel("EMAIL");
        email.setForeground(Color.WHITE);
        email.setFont(new Font("MOnospace", Font.PLAIN, 15));
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setVerticalAlignment(SwingConstants.CENTER);
        email.setBackground(new Color(205,0,0) );
        email.setOpaque(true);
        email.setBounds(420, 150, 240, 40);
        admin_lbl.add(email);

        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        back.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                 
                // lbl.setVisible(false);
                // // this is for linking another file where should this label directs.
                // new FirstInterface(f, stm);

                lbl.setVisible(false);
                admin_lbl.setVisible(false);
                new Question(f, stm);
               
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });

        showRequestList();

        f.add(admin_lbl);
    }
    
    public void showRequestList(){
        int temp = 0;
        String namestr, emailstr;
        int idInt;
        try{
            String query = "select * from login_details where admin_status = 'requested'";

            rst = stm.executeQuery(query);
            while(rst.next()){
                temp++;
                JLabel snTemp, nameTemp, emailTemp;
                JButton acc, rej;

                idInt = rst.getInt("id");
                namestr = rst.getString("name");
                emailstr = rst.getString("email");

                idList.add(idInt);

                snTemp = new JLabel("" + temp);
                snTemp.setOpaque(true);
                snTemp.setBackground(Color.decode("#FFFFFF"));
                snTemp.setBounds(80, 150 + 50 * temp, 80, 30);
                admin_lbl.add(snTemp);

                nameTemp = new JLabel(namestr);
                nameTemp.setOpaque(true);
                nameTemp.setBackground(Color.decode("#FFFFFF"));
                nameTemp.setBounds(160, 150 + 50 * temp, 240, 30); //(160, 150, 240, 40)
                admin_lbl.add(nameTemp);

                emailTemp = new JLabel(emailstr);
                emailTemp.setOpaque(true);
                emailTemp.setBackground(Color.decode("#FFFFFF"));
                emailTemp.setBounds(400, 150 + 50 * temp, 240, 30);  //(400, 150, 240, 40)
                admin_lbl.add(emailTemp);

                acc = new JButton("ACCEPT");
                acc.setBounds(650, 150 + 50 * temp, 140, 30);
                acc.addActionListener(this);
                admin_lbl.add(acc);
                acceptList.add(acc);

                rej = new JButton("REJECT");
                rej.setBounds(800, 150 + 50 * temp, 150, 30);
                rej.addActionListener(this);
                admin_lbl.add(rej);
                rejectList.add(rej);


            }
        }catch(Exception e){
            System.out.println("Error in showRequestList: " + e.getMessage());
        }
    }

    public void acceptButtonClicked(JButton b){
        try{
            userId = idList.get(acceptList.indexOf(b));
            // System.out.println(userId);

            String query = "update login_details set admin_status = 'accepted' where id = " + userId;
            stm.executeUpdate(query);
            b.setText("accepted");
            b.setEnabled(false);
            rejectList.get(acceptList.indexOf(b)).setVisible(false);

            // System.out.println("Connected");
        }catch(Exception ex){
            System.out.println("Not connected! (Error Occured:)"+ex);
        } 
    }

    public void rejectButtonClicked(JButton rb){
        try{
            userId = idList.get(rejectList.indexOf(rb));
            // System.out.println(userId);

            String query = "update login_details set admin_status = 'rejected' where id = " + userId;
            stm.executeUpdate(query);
            int temp = rejectList.indexOf(rb);
            rb.setText("rejected");
            rb.setEnabled(false);
            // b.setBounds(600, 200 + 50 * (temp+1), 140, 30);
            // acceptList.get(rejectList.indexOf(b)).setText("rejected");
            acceptList.get(rejectList.indexOf(rb)).setVisible(false);
            // rejectList.get(rejectList.indexOf(b)).setVisible(false);
            // rejectList.get(rejectList.indexOf(b)).setVisible(false);

            // System.out.println("Connected");
        }catch(Exception ex){
            System.out.println("Not connected! (Error Occured:)"+ex.getMessage());
        } 
    }

    public void actionPerformed(ActionEvent ae){
        // System.out.println("correct");
//        System.out.println(ae.getSource());
        JButton currBtn = (JButton)ae.getSource();

        if(ae.getSource().equals(submit)){
            String qsn, op1, op2, op3, op4, corr;
            int lev;

            lev = Integer.parseInt(levelComboBox.getItemAt(levelComboBox.getSelectedIndex()));

            qsn = question.getText();
            op1 = option1.getText();
            op2 = option2.getText();
            op3 = option3.getText();
            op4 = option4.getText();

            String[] optionList = {op1, op2, op3, op4};
            corr = optionList[optionComboBox.getSelectedIndex()];
            System.out.println(lev);

            try{
                // stm = conn.createStatement();
                System.out.println("testing");
                String query = "INSERT INTO question_list(question, option_a, option_b, option_c, option_d, correct_answer, level) VALUES('"+qsn+"','"+op1+"','"+op2+"','"+op3+"','"+op4+"','"+corr+"','"+lev+"')";
                System.out.println("testing 2");
                stm.executeUpdate(query);
                System.out.println("Inserted into table");
                question.setText("");
                option1.setText("");
                option2.setText("");
                option3.setText("");
                option4.setText("");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        // }else if(ae.getSource().equals(back)){
        //     lbl.setVisible(false);
        //     admin_lbl.setVisible(false);
        //     new FirstInterface(f, stm);
        }else if(ae.getSource().equals(back_to_admin)){
            // System.out.println("back clicked");
            admin_lbl.setVisible(false);
            lbl.setVisible(true);
        }else if(ae.getSource().equals(admin_request)){
            // System.out.println("back clicked");
            admin_lbl.setVisible(true);
            lbl.setVisible(false);
            // showRequestList();
        }else if(currBtn.getText().equals("ACCEPT")){
            acceptButtonClicked(currBtn);
            // admin_lbl.setVisible(true);
            // lbl.setVisible(false);
            // currBtn.setVisible(false);
        }else if(currBtn.getText().equals("REJECT")){
            rejectButtonClicked(currBtn);
            // admin_lbl.setVisible(true);
            // currBtn.setVisible(false);
        }
        

    }

    // public void ActionPerformed(ActionEvent ae){

    // }
        
        
    // public static void main(String[] args) {
    //     new Instruction();
    // }

    // public static void main(String[] args) {
    //     JFrame frame = new JFrame();
    //     frame.setSize(1000,1000);
    //     frame.setLocation(10,10);
    //     frame.setLayout(null);
    //     frame.setVisible(true);
    //     frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    //     new Question(frame);
    // }

}
