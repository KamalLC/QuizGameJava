
package mainInterface;
import IndexPack.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import java.sql.Statement;

public class MainInterface{
    JFrame fr;
    Statement stm;
    Dimension dim;
    JLabel l1, lbl, greetinglbl, toplbl, next, indexLabel1;
    JRadioButton r1, r2, r3;
    Thread th;

    

    public MainInterface(JFrame frame, Statement st){

           // super(FrameTitle);
           fr = frame;
           stm = st;
   
           System.out.println("reached MainInterface");
           // frame.setSize(1000,1000);
           // frame.setLocation(10,10);
           // frame.setLayout(null);
           // frame.setVisible(true);
          
        indexLabel1 = new JLabel();
        indexLabel1.setBounds(0, 0, 1800, 1000);
        indexLabel1.setOpaque(true);
        indexLabel1.setBackground(Color.decode("#FFFFFF"));
        // fr = new JFrame("SlideShow Image");
        // dim  = ToolKit.getDefaultToolkit().getScreenSize();
        // fr.setSize(dim.width, dim.height);
        indexLabel1.setLayout(null);

        lbl = new JLabel();
        lbl.setSize(1490, 1000);
        lbl.setBounds(0,0,1490,1000);
        lbl.setLayout(new BorderLayout());

        toplbl = new JLabel(" ! ! !  WELCOME  ! ! ! ");
        toplbl.setForeground(Color.WHITE);
        toplbl.setBounds(0, 0, 1285, 55);
        toplbl.setFont(new Font("MOnospace", Font.PLAIN, 20));
        toplbl.setBackground(new Color(153,0,0) );
        // toplbl.setBackground(new Color(102,102,102) );
        // toplbl.setBackground(new Color(51,51,51) );
        toplbl.setOpaque(true);
        toplbl.setHorizontalAlignment(SwingConstants.CENTER);
        toplbl.setVerticalAlignment(SwingConstants.CENTER);
        indexLabel1.add(toplbl);

        greetinglbl = new JLabel("Welcome to Who wants to be a Millionare");
        greetinglbl.setBounds(400,65, 500,40);
        greetinglbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
        indexLabel1.add(greetinglbl);


        l1 = new JLabel(new ImageIcon("C:\\Users\\Dell\\Desktop\\QuizGameJava-mainupdatedNovember2\\javaImg.jpg"));
        // ImageIcon image = new ImageIcon("C:\\Users\\Dell\\Desktop\\myFolder\\register.png");
        // JLabel l1 = new JLabel(image);
        // JScrollPane scrollPane = new JScrollPane(l1);
        // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        l1.setBounds(250, 105, 900, 500);
        indexLabel1.add(l1);
        // fr.add(scrollPane, BorderLayout.CENTER);



        r1 = new JRadioButton();
        r1.setBounds(635, 605, 32,32);
        r1.setSelected(true);
        r1.setBackground(Color.white);
        r1.setForeground(Color.RED);
        indexLabel1.add(r1);

        r2 = new JRadioButton();
        r2.setBounds(675, 605, 32,32);
        r2.setBackground(Color.white);
        r2.setForeground(Color.RED);
        indexLabel1.add(r2);

        r3 = new JRadioButton();
        r3.setBounds(715, 605, 32,32);
        r3.setBackground(Color.white);
        r3.setForeground(Color.RED);
        indexLabel1.add(r3);

        next = new JLabel(" NEXT - - >");
        next.setFont(new Font("MOnospace", Font.PLAIN, 18));
        next.setForeground(new Color(205,0,0) );
        next.setOpaque(false);
        
        next.setBounds(1070, 605, 160, 40);
        
        indexLabel1.add( next);


        th = new Thread(rr);
        th.start();

        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        next.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              try {
                 
                indexLabel1.setVisible(false);
                // this is for linking another file where should this label directs.
                new FirstInterface(fr, stm);
               
              } catch (Exception e1) {
  
                  e1.printStackTrace();
              }
          }
      });
      fr.add(indexLabel1);
    }

    Runnable rr = ()->{
        try {
            while(true){
                th.sleep(2000);
                l1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\QuizGameJava-mainupdatedNovember2\\javaImg.jpg"));
                // ImageIcon image = new ImageIcon("C:\\Users\\Dell\\Desktop\\JavaProject\\QuizProject\\sofa.png");
               
                r1.setSelected(true);
                r3.setSelected(false);
                r2.setSelected(false);

                th.sleep(2000);
                l1.setIcon(new ImageIcon("C:\\Users\\Dell\\Desktop\\QuizGameJava-mainupdatedNovember2\\millionareImg.jpg"));
                // ImageIcon image = new ImageIcon("C:\\Users\\Dell\\Desktop\\JavaProject\\QuizProject\\sofa.png");
                // JLabel l1 = new JLabel(image);
                // JScrollPane scrollPane = new JScrollPane(l1);
                // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                // // l1.setBounds(300, 100, 800, 500);
                r1.setSelected(false);
                r3.setSelected(false);
                r2.setSelected(true);

                th.sleep(2000);
                l1.setIcon(new ImageIcon("aaa.jpg"));
                r3.setSelected(true);
                r1.setSelected(false);
                r2.setSelected(false);

                // th.sleep(2000);
                // indexLabel1.setVisible(false);
                // // indexLabel.setVisible(true);
                // new FirstInterface(fr, stm);

            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error in mainInterface");
        }

    };
   
}