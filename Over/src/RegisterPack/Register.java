package RegisterPack;

import IndexPack.*;
import QuestionPack.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Register implements ActionListener {
    JFrame f;
    Statement stm;
    ResultSet rst, rst2;
    JLabel lbl, nameLabel, emailLabel, pwdLabel, confirmPasswordLabel;
    JButton login, register, submit, cancel;
    JTextField username, email, password, confirmPassword;
    JCheckBox checkBox;
    
    public Register(JFrame frame, Statement st){ 
        f = frame;
        stm = st;
        // f.getContentPane().setBackground(new Color(204, 204, 204));

        lbl = new JLabel();
        lbl.setOpaque(true);
        lbl.setBackground(Color.decode("#FFFFFF"));
        lbl.setBounds(0, 0, 1000, 1000);

        login = new JButton("LOGIN");
        login.setBounds(400, 250, 100, 30);
        login.addActionListener(this);
        lbl.add(login);
        login.setBackground(Color.white);

        register = new JButton("REGISTER");
        register.setBounds(250, 250, 100, 30);
        register.addActionListener(this);
        lbl.add(register);
        register.setBackground(Color.green);

        nameLabel = new JLabel("Full Name");
        nameLabel.setBounds(200, 300, 120, 30);
        lbl.add(nameLabel);

        username = new JTextField("");
        username.setBounds(350, 300, 200, 30);
        lbl.add(username);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(200, 350, 120, 30);
        lbl.add(emailLabel);

        email = new JTextField("");
        email.setBounds(350, 350, 200, 30);
        lbl.add(email);

        pwdLabel = new JLabel("Password");
        pwdLabel.setBounds(200, 400, 120, 30);
        lbl.add(pwdLabel);

        password = new JTextField("");
        password.setBounds(350, 400, 200, 30);
        lbl.add(password);

        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(200, 450, 120, 30);
        lbl.add(confirmPasswordLabel);

        confirmPassword = new JTextField("");
        confirmPassword.setBounds(350, 450, 200, 30);
        lbl.add(confirmPassword);

        checkBox = new JCheckBox("Request for admin access.");
        checkBox.setBounds(200, 500, 250, 30);
        lbl.add(checkBox);

        submit = new JButton("REGISTER");
        submit.setBounds(250, 550, 100, 30);
        submit.addActionListener(this);
        lbl.add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(400, 550, 100, 30);
        cancel.addActionListener(this);
        lbl.add(cancel);

        f.add(lbl);
    }

    public void showRegister(){
        register.setBackground(Color.green);
        login.setBackground(Color.white);
        submit.setText("REGISTER");

        username.setVisible(true);
        nameLabel.setVisible(true);
        confirmPassword.setVisible(true);
        confirmPasswordLabel.setVisible(true);
        checkBox.setVisible(true);
    }

    public void showLogin(){
        register.setBackground(Color.white);
        login.setBackground(Color.green);
        submit.setText("LOGIN");
        
        username.setVisible(false);
        nameLabel.setVisible(false);
        confirmPassword.setVisible(false);
        confirmPasswordLabel.setVisible(false);
        checkBox.setVisible(false);
    }

    public void submitButtonClicked(){
        String uname = username.getText();
        String emailStr = email.getText();
        String pass = password.getText();
        String comPass = confirmPassword.getText();
        String admin_stat = "no";
        String logged_in_stat = "no";

        if(checkBox.isSelected()){
            admin_stat = "requested";
        }



        if(submit.getText().equals("LOGIN")){
            // System.out.println("register button clicked");
            try{
                String query = "select * from login_details where email = '" + emailStr + "' and password = '" + pass + "'";

                rst = stm.executeQuery(query);
                if(rst.next()){
                    // query = "update login_details set logged_in = 'yes' where email = '" + emailStr + "'";
                    // stm.executeUpdate(query);
                    if(rst.getString("admin_status").equals("accepted")){
                        query = "update login_details set logged_in = 'yes' where email = '" + emailStr + "'";
                        stm.executeUpdate(query);
                        lbl.setVisible(false);
                        new Question(f, stm);
                    }else{
                        query = "update login_details set logged_in = 'yes' where email = '" + emailStr + "'";
                        stm.executeUpdate(query);
                        lbl.setVisible(false);
                        new FirstInterface(f, stm);
                    }
                }

                // System.out.println("success");
                // System.out.println(max);
            }catch(Exception e){
                System.out.println("error: " + e.getMessage());
                // System.out.println(e.getMessage());
            }


        }else if(submit.getText().equals("REGISTER")){
            // System.out.println("login button clicked");
            if(pass.equals(comPass)){
                // System.out.println(uname + emailStr + pass + comPass + admin_stat + logged_in);
                try{
                    // stm = conn.createStatement();
                    System.out.println("testing");
                    String query = "INSERT INTO login_details(name, email, password, admin_status, logged_in) VALUES('"+uname+"','"+emailStr+"','"+pass+"','"+admin_stat+"','"+logged_in_stat+"')";
                    System.out.println("testing 2");
                    stm.executeUpdate(query);
                    System.out.println("Inserted into table");
                    username.setText("");
                    email.setText("");
                    password.setText("");
                    confirmPassword.setText("");
                    showLogin();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource().equals(login)){
            showLogin();
        }else if(ae.getSource().equals(register)){
            showRegister();
        }else if(ae.getSource().equals(submit)){
            submitButtonClicked();
        }else if(ae.getSource().equals(cancel)){
            lbl.setVisible(false);
            new FirstInterface(f, stm);
        }
    }
        
        
    // public static void main(String[] args) {
    //     JFrame frame = new JFrame();
    //     frame.setSize(1000,1000);
    //     frame.setLocation(10,10);
    //     frame.setLayout(null);
    //     frame.setVisible(true);
    //     frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
    //     new Register(frame);
    // }

}