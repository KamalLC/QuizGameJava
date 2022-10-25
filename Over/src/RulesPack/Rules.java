package RulesPack;

import IndexPack.*;
import GamePack.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement; 

public class Rules {
    JFrame f;
    Connection conn;
    Statement stm;
    JLabel lbl, msglbl ,toplbl, rule1, rule2, rule3, rule4, rule5, rule6, description1, description2, description6, description3, description4, description5,  back;
    
    public Rules(JFrame frame, Statement st){
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
        toplbl = new JLabel("RULES SECTION");
        msglbl= new JLabel("*First, please familiar with rules and play well. Good luck for success.");
        rule1 = new JLabel("Rule 1 -->");
        rule2 = new JLabel("Rule 2 -->");
        rule3 = new JLabel("Rule 3 -->");
        rule4 = new JLabel("Rule 4 -->");
        rule5 = new JLabel("Rule 5 -->");
        rule6 = new JLabel("Rule 6 -->");
      
        
        back = new JLabel("<-- Back");
        back.setFont(new Font("MOnospace", Font.PLAIN, 15));
        back.setForeground(new Color(51, 51,51));
        back.setBackground(new Color(205,0,0) );
        back.setBounds(80, 580, 120, 22);

        // lbl.setSize(1450, 1000);
        // lbl.setLocation(0, 0);

        // lbl.setOpaque(true);
        // lbl.setBackground(Color.decode("#FFFFFF"));
        // lbl.setBounds(0, 0, 1000, 1000);

        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1000, 40);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        // toplbl.setBackground(new Color(102,102,102) );
        // toplbl.setBackground(new Color(51,51,51) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);

        msglbl.setBounds(200, 50, 800, 16);
        msglbl.setForeground(Color.RED);
        msglbl.setFont(new Font("MOnospace", Font.PLAIN, 15));

        rule1.setBounds(80, 120, 120, 22);
        rule2.setBounds(80, 200, 120, 22);
        rule3.setBounds(80, 280, 120, 22);
        rule4.setBounds(80, 360, 120, 22);
        rule5.setBounds(80, 440, 120, 22);
        rule6.setBounds(80, 520, 120, 22);
        rule1.setForeground(Color.WHITE);
        rule2.setForeground(Color.WHITE);
        rule3.setForeground(Color.WHITE);
        rule4.setForeground(Color.WHITE);
        rule5.setForeground(Color.WHITE);
        rule6.setForeground(Color.WHITE);
        rule1.setFont(new Font("MOnospace", Font.PLAIN, 15));
        rule2.setFont(new Font("MOnospace", Font.PLAIN, 15));
        rule3.setFont(new Font("MOnospace", Font.PLAIN, 15));
        rule4.setFont(new Font("MOnospace", Font.PLAIN, 15));
        rule5.setFont(new Font("MOnospace", Font.PLAIN, 15));
        rule6.setFont(new Font("MOnospace", Font.PLAIN, 15));

        rule1.setHorizontalAlignment(SwingConstants.CENTER);
        rule1.setVerticalAlignment(SwingConstants.CENTER);
        rule2.setHorizontalAlignment(SwingConstants.CENTER);
        rule2.setVerticalAlignment(SwingConstants.CENTER);
        rule3.setHorizontalAlignment(SwingConstants.CENTER);
        rule3.setVerticalAlignment(SwingConstants.CENTER);
        rule4.setHorizontalAlignment(SwingConstants.CENTER);
        rule4.setVerticalAlignment(SwingConstants.CENTER);
        rule5.setHorizontalAlignment(SwingConstants.CENTER);
        rule5.setVerticalAlignment(SwingConstants.CENTER);
        rule6.setHorizontalAlignment(SwingConstants.CENTER);
        rule6.setVerticalAlignment(SwingConstants.CENTER);
        
        rule1.setBackground(new Color(205,0,0) );
        rule1.setOpaque(true);
        rule2.setBackground(new Color(205,0,0) );
        rule2.setOpaque(true);
        rule3.setBackground(new Color(205,0,0) );
        rule3.setOpaque(true);
        rule4.setBackground(new Color(205,0,0) );
        rule4.setOpaque(true);
        rule5.setBackground(new Color(205,0,0) );
        rule5.setOpaque(true);
        rule6.setBackground(new Color(205,0,0) );
        rule6.setOpaque(true);


        description1 = new JLabel("Answer will be finalized with lock button clicked");
        description1.setBounds(230, 120, 700, 18);
        description1.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description1.setForeground(new Color(0, 0,255));

        description2 = new JLabel("Answer must be locked before timer indicates time over (except for hard question)");
        description2.setBounds(230, 200, 700, 18);
        description2.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description2.setForeground(new Color(0, 0,255));

        description3 = new JLabel("Wrong answer selection directs for game quit");
        description3.setBounds(230, 280, 700, 18);
        description3.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description3.setForeground(new Color(0, 0,255));

        description4 = new JLabel("Quit is restricted for Double dip and 50 : 50 lifeline");
        description4.setBounds(230, 360, 700, 18);
        description4.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description4.setForeground(new Color(0, 0,255));

        description5 = new JLabel("Multiple use of same lifeline is restricted");
        description5.setBounds(230, 440, 700, 18);
        description5.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description5.setForeground(new Color(0, 0,255));

        description6 = new JLabel("External support except lifelines is restricted");
        description6.setBounds(230, 520, 700, 18);
        description6.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description6.setForeground(new Color(0, 0,255));

        

       
        
        lbl.add(toplbl);
        lbl.add(msglbl);
        lbl.add(rule1);
        lbl.add(rule2);
        lbl.add(rule3);
        lbl.add(rule4);
        lbl.add(rule5);
        lbl.add(rule6);
        lbl.add(description1);
        lbl.add(description2);
        lbl.add(description3);
        lbl.add(description4);
        lbl.add(description5);
        lbl.add(description6);
        lbl.add(back);

        f.add(lbl);
        
        
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
