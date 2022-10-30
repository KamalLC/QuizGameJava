/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package over;

//import GamePack.*;
import IndexPack.*;
//import InstructionPack.*;
// import kamel.*;
// import register.*;
// import testFolder.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.Statement; 


import javax.swing.*;

public class Over implements ActionListener{
	JFrame frame;
    JButton registerBtn, rulesBtn, playBtn, helpBtn, exitBtn, test;
    GridLayout gdl;
    public static Over fi;
    JLabel lbl, indexLabel;
    Connection conn;
    Statement stm;

    /**
     * @param FrameTitle
     */
    public Over(String FrameTitle){
        // super(FrameTitle);
        frame = new JFrame();


        frame.setSize(1800, 1000);
        frame.setLocation(0, 0);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //driver registration
            //connection to database
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");
            stm=conn.createStatement(); //creating statement
            if(conn != null){
                System.out.println("Database connection success ...");
            }

            String query = "update login_details set logged_in = 'no' where logged_in = 'yes'";
            stm.executeUpdate(query);

            // System.out.println("Connected");
        }catch(Exception ex){
            System.out.println("Not connected! (Error Occured:)"+ex);
        } 

        new FirstInterface(frame, stm);
       
    }
    public void actionPerformed(ActionEvent e){
        JButton eventSource = (JButton)e.getSource();
        
        
    }
    
    public static void main(String[] args) {
        Over fi = new Over("Quiz Game");
    }
}

//public class Over {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//    }
//    
//}
