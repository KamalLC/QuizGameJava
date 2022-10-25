// package RegisterPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Register {
    JFrame f;
    JLabel lbl, msglbl ,toplbl, Instruction1, Instruction2, Instruction3, Instruction4, Instruction5, Instruction6, description1, description2, description6, description3, description4, description5, back ;
    
    public Register(){
        f = new JFrame();
        f.setSize(1920,1080);
        f.setLocation(10,10);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setVisible(true);
        // f.getContentPane().setBackground(new Color(51, 153, 255));
        // f.getContentPane().setBackground(new Color(51, 204, 255));
        // f.getContentPane().setBackground(new Color(0, 0, 204));
        f.getContentPane().setBackground(new Color(204, 204, 204));

        lbl = new JLabel();
        toplbl = new JLabel("INSTRUCTION SECTION");
        msglbl= new JLabel("* First, please familiar with Instructions and play well. Good luck for success.");
        Instruction1 = new JLabel("Instruction 1 -->");
        Instruction2 = new JLabel("Instruction 2 -->");
        Instruction3 = new JLabel("Instruction 3 -->");
        Instruction4 = new JLabel("Instruction 4 -->");
        Instruction5 = new JLabel("Instruction 5 -->");
        Instruction6 = new JLabel("Instruction 6 -->");
      
 

        lbl.setSize(1450, 1000);
        lbl.setLocation(0, 0);

        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1285, 40);
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

        //back button
        back = new JLabel("<-- Back");
        back.setFont(new Font("MOnospace", Font.PLAIN, 15));
        back.setForeground(new Color(205,0,0) );
        
        back.setBounds(80, 580, 120, 22);

        Instruction1.setBounds(80, 120, 120, 22);
        Instruction2.setBounds(80, 200, 120, 22);
        Instruction3.setBounds(80, 280, 120, 22);
        Instruction4.setBounds(80, 360, 120, 22);
        Instruction5.setBounds(80, 440, 120, 22);
        Instruction6.setBounds(80, 520, 120, 22);
        Instruction1.setForeground(Color.WHITE);
        Instruction2.setForeground(Color.WHITE);
        Instruction3.setForeground(Color.WHITE);
        Instruction4.setForeground(Color.WHITE);
        Instruction5.setForeground(Color.WHITE);
        Instruction6.setForeground(Color.WHITE);
        Instruction1.setFont(new Font("MOnospace", Font.PLAIN, 15));
        Instruction2.setFont(new Font("MOnospace", Font.PLAIN, 15));
        Instruction3.setFont(new Font("MOnospace", Font.PLAIN, 15));
        Instruction4.setFont(new Font("MOnospace", Font.PLAIN, 15));
        Instruction5.setFont(new Font("MOnospace", Font.PLAIN, 15));
        Instruction6.setFont(new Font("MOnospace", Font.PLAIN, 15));

        Instruction1.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction1.setVerticalAlignment(SwingConstants.CENTER);
        Instruction2.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction2.setVerticalAlignment(SwingConstants.CENTER);
        Instruction3.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction3.setVerticalAlignment(SwingConstants.CENTER);
        Instruction4.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction4.setVerticalAlignment(SwingConstants.CENTER);
        Instruction5.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction5.setVerticalAlignment(SwingConstants.CENTER);
        Instruction6.setHorizontalAlignment(SwingConstants.CENTER);
        Instruction6.setVerticalAlignment(SwingConstants.CENTER);
        
        Instruction1.setBackground(new Color(205,0,0) );
        Instruction1.setOpaque(true);
        Instruction2.setBackground(new Color(205,0,0) );
        Instruction2.setOpaque(true);
        Instruction3.setBackground(new Color(205,0,0) );
        Instruction3.setOpaque(true);
        Instruction4.setBackground(new Color(205,0,0) );
        Instruction4.setOpaque(true);
        Instruction5.setBackground(new Color(205,0,0) );
        Instruction5.setOpaque(true);
        Instruction6.setBackground(new Color(205,0,0) );
        Instruction6.setOpaque(true);


        description1 = new JLabel("12 questions worth 1 crore(in total) is available.");
        description1.setBounds(230, 120, 800, 18);
        description1.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description1.setForeground(new Color(0, 0,255));

        description2 = new JLabel("Three lifelines( 50 : 50, Double dip, swap ) is available for one time use only. ");
        description2.setBounds(230, 200, 800, 18);
        description2.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description2.setForeground(new Color(0, 0,255));

        description3 = new JLabel("First four, second three and last five questions will be from easy, medium and hard section respectively.");
        description3.setBounds(230, 280, 800, 18);
        description3.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description3.setForeground(new Color(0, 0,255));

        description4 = new JLabel("Money safe zone is on $10,000 and $3,20,000 only.");
        description4.setBounds(230, 360, 800, 18);
        description4.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description4.setForeground(new Color(0, 0,255));

        description5 = new JLabel("Timer will be stopped after lifeline is activated.");
        description5.setBounds(230, 440, 800, 18);
        description5.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description5.setForeground(new Color(0, 0,255));

        description6 = new JLabel("Players' hand will not be empty incase of quit with some question's right answer.");
        description6.setBounds(230, 520, 800, 18);
        description6.setFont(new Font("MOnospace", Font.PLAIN, 15));
        description6.setForeground(new Color(0, 0,255));

        

       
        
        lbl.add(toplbl);
        lbl.add(msglbl);
        lbl.add(Instruction1);
        lbl.add(Instruction2);
        lbl.add(Instruction3);
        lbl.add(Instruction4);
        lbl.add(Instruction5);
        lbl.add(Instruction6);
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
                        // this is for linking another file where should this label directs.
                                // new SecondInterface();
                    } catch (Exception e1) {
        
                        e1.printStackTrace();
                    }
                }
            });

    }
        
        
    public static void main(String[] args) {
        new Register();
    }

}