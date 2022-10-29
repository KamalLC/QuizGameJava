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

import java.sql.Connection;
import java.sql.Statement; 


public class Question implements ActionListener {
    JFrame f;
    Connection conn;
    Statement stm;
    JLabel lbl,toplbl, questionLbl, option1Lbl, option2Lbl, option3Lbl, option4Lbl, cor_ansLbl, levelLbl;
    JTextField question, option1, option2, option3, option4, cor_ans, level;
    JButton submit, back;
    String[] levelOptions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    int[] levelOptionsInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    JComboBox<String> levelComboBox = new JComboBox<>(levelOptions);
    String[] optionOptions = {"Option1", "Option2", "Option3", "Option4"};
    JComboBox<String> optionComboBox = new JComboBox<>(optionOptions);
    
    public Question(JFrame frame, Statement st){
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

        levelLbl = new JLabel("Level: ");
        levelLbl.setOpaque(true);
        levelLbl.setBounds(150, 120, 50+80, 40);
        levelLbl.setForeground(Color.WHITE);
        levelLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        levelLbl.setHorizontalAlignment(SwingConstants.CENTER);
        levelLbl.setVerticalAlignment(SwingConstants.CENTER);
        levelLbl.setBackground(new Color(205,0,0) );
        lbl.add(levelLbl);

        levelComboBox.setBounds(340, 120, 80, 40);
        levelComboBox.setBackground( new Color(204, 204, 204) );

        lbl.add(levelComboBox);

        questionLbl = new JLabel("Question: ");
        questionLbl.setOpaque(true);
        questionLbl.setBounds(100, 150, 50+40, 30);
        questionLbl.setForeground(Color.WHITE);
        questionLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        questionLbl.setVerticalAlignment(SwingConstants.CENTER);
        questionLbl.setBackground(new Color(205,0,0) );

        lbl.add(questionLbl);

        question = new JTextField();
        question.setBounds(200, 150, 400, 30);
        question.setBackground( new Color(204, 204, 204) );
        lbl.add(question);

        option1Lbl = new JLabel("Option1: ");
        option1Lbl.setOpaque(true);
        option1Lbl.setBounds(100, 200, 50+40, 30);
        option1Lbl.setForeground(Color.WHITE);
        option1Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option1Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option1Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option1Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option1Lbl);

        option1 = new JTextField();
        option1.setBounds(200, 200, 400, 30);
        option1.setBackground( new Color(204, 204, 204) );
        lbl.add(option1);

        option2Lbl = new JLabel("Option2: ");
        option2Lbl.setOpaque(true);
        option2Lbl.setBounds(100, 250, 50+40, 30);
        option2Lbl.setForeground(Color.WHITE);
        option2Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option2Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option2Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option2Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option2Lbl);

        option2 = new JTextField();
        option2.setBounds(200, 250, 400, 30);
        option2.setBackground( new Color(204, 204, 204) );
        lbl.add(option2);

        option3Lbl = new JLabel("Option3: ");
        option3Lbl.setOpaque(true);
        option3Lbl.setBounds(100, 300, 50+40, 30);
        option3Lbl.setForeground(Color.WHITE);
        option3Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option3Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option3Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option3Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option3Lbl);

        option3 = new JTextField();
        option3.setBounds(200, 300, 400, 30);
        option3.setBackground( new Color(204, 204, 204) );
        lbl.add(option3);

        option4Lbl = new JLabel("Option4: ");
        option4Lbl.setOpaque(true);
        option4Lbl.setBounds(100, 350, 50+40, 30);
        option4Lbl.setForeground(Color.WHITE);
        option4Lbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        option4Lbl.setHorizontalAlignment(SwingConstants.CENTER);
        option4Lbl.setVerticalAlignment(SwingConstants.CENTER);
        option4Lbl.setBackground(new Color(205,0,0) );
        lbl.add(option4Lbl);

        option4 = new JTextField();
        option4.setBounds(200, 350, 400, 30);
        option4.setBackground( new Color(204, 204, 204) );
        lbl.add(option4);

        cor_ansLbl = new JLabel("Right Ans: ");
        cor_ansLbl.setOpaque(true);
        cor_ansLbl.setBounds(100, 400, 50+40, 30);
        cor_ansLbl.setForeground(Color.WHITE);
        cor_ansLbl.setFont(new Font("MOnospace", Font.PLAIN, 15));
        cor_ansLbl.setHorizontalAlignment(SwingConstants.CENTER);
        cor_ansLbl.setVerticalAlignment(SwingConstants.CENTER);
        cor_ansLbl.setBackground(new Color(205,0,0) );
        lbl.add(cor_ansLbl);


        
        optionComboBox.setBounds(200, 400, 100, 30);
        optionComboBox.setBackground( new Color(204, 204, 204) );
        lbl.add(optionComboBox);

        submit = new JButton("Submit");
        submit.setBounds(150, 450, 150, 30);
        submit.setForeground(Color.white);
        submit.setBackground( new Color(205, 0, 0) );
        lbl.add(submit);
        submit.addActionListener(this);

        back = new JButton("Home");
        back.setBounds(300, 550, 150, 30);
        back.setForeground(Color.white);
        back.setBackground( new Color(205, 0, 0) );
        
        lbl.add(back);
        back.addActionListener(this);
        
        f.add(lbl);
    }
    public void actionPerformed(ActionEvent ae){
        // System.out.println("correct");
//        System.out.println(ae.getSource());
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
            
        }else if(ae.getSource().equals(back)){
            lbl.setVisible(false);
            new FirstInterface(f, stm);
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
//     new Instruction(frame);
// }

}