 package GamePack;

import IndexPack.*; // TODO: UNCOMMENT THIS LATER
import IndexPack.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.lang.Math;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
// import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class PlayGame implements ActionListener{
	 // TODO: remove it later
    public static JPanel topLeftPanel,leftCenterPanel , rightPanel, nestRightpanel;
    
    JButton fiftyFiftyBtn, swapBtn, doubleDieBtn, option1, option2, option3, option4, lockBtn, nextQuestionBtn, quitBtn, playAgainBtn; 
    JLabel lbl1, lbl2, lbl3, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14, questionLbl, timerLabel;
    JLabel gameLabel, gameOverLbl;
    JFrame gameFrame;
    Connection conn;
    Statement stm;
    ResultSet rst;

    JButton[] buttonList = new JButton[4];
    JLabel[] moneyLevel = new JLabel[12];
    JButton choosedBtn, currentBtn;

    Timer timer;

    String currentQuestion, optionA, optionB, optionC, optionD;


    String[][] easyQuestions = {
        {"Which is the hottest planet in our solar system?","Saturn","Uranus","Mars","Venus","Venus"},
        {"What is the square root of 144?","11","12","14","16","12"},
        {"Which is the highest mountain in the World?","Mt.Everest","Mt.Kanchenjunga","Mt.K2","Mt.Cho Oyu","Mt.Everest"},
        {"Which is the smallest country in the world?","Monaco","Nauru","Vatican City","Maldives","Vatican City"},
        {"Which is the largest river in Nepal?","SaptaKoshi","Karnali","Koshi","Bagmati","SaptaKoshi"},
        {"Which is the capital city of India?","Chennai","New Delhi","Mumbai","Punjab", "New Delhi"},
        {"Which is the National bird of Nepal?","Dove","Crow","Sparrow","Lhophophorus","Lhophophorus"},
        {"How Many Colors does rainbow have?","6","7","8","5","7"},
        {"How many letters are in the English Alphabet?","25","27","26","24","26"},
        {"Which Animal Lays the Largest Eggs?","Crow","Ostrish","Eagle","Vulture","Eagle"},
        {"How many days are there in a year?","365","366","369","367","365"},
        {"What is the closest planet to the Sun?","Venus","Earth","Mercury","Jupiter","Mercury"},
        {"In which Country is the Taj Mahal Located?","India","China","Bhutan","Nepal","India"},
        {"Which district is name as the Switzerland Of Nepal?","Mustang","Jumla","Jiri","Lamjung","Jiri"},
        {"Which animal is known as 'the Ship of the Desert'?","Camel","Kangaroo","Giraffe","Donkey","Camel"},
        {"How many sides are there in a triangle?","4","3","5","7","3"},
        {"Which month of the year has the least number of days?","January","October","June","February","February"}
    };
    String[][] mediumQuestions = {
        {"When is World Heritage Day celebrated?","18 April","18 October","18 June","18 January","18 April"},
        {"In which ocean did the famous Titanic sink in 1912?","Pacific","North Atlantic","the Mediterranean","Indian Ocean","North Atlantic"},
        {"What is the next number in the following sequence 7,14,21,28?","33","34","36","35","35"},
        {"Which day is celebrated as Environment Day?","5 June","8 June","17 June","5 August","5 June"},
        {"What is the hottest place of Nepal?","Lamjung","Morang","Nepalgunj","Dolpa","Nepalgunj"},
        {"In which district is Mahendra Cave located?","Kaski","Mustang","Jumla","Myadi","Kaski"},
        {"Which planet is longer day than the year?","Jupiter","Saturn","Earth","Venus","Venus"},
        {"Who is Nepal’s first elected Prime Minister?","Gahendra Shumsher","BP Koirala","Madan Bhandari","Prithvi Narayan Shah","BP Koirala"},
        {"How old must be to become President?","48","42","45","47","45"},
        {"What gas is filled in the electric bulb?","Nitrogen","Oxygen","Helium","Carbon Dioxide","Nitrogen"},
        {"Which country is the world’s first female president?","Nepal","Bhutan","USA","Argentina","Argentina"},
        {"Which caste celebrates the Gaura festival?","Tharu","Magar","Limbu","Newar","Tharu"},
        {"Which country is the sunrise at midnight?","Argentina","Norway","Brazil","Africa","Norway"},
        {"Which is the most living creature in the world?","Turtle","Elephant","Whale","Chimpanzee","Turtle"},
        {"How many doors are there in Koshi Barrage?","57","59","54","55","55"},
        {"Which is the most expensive metal?","Radium","Gold","Silver","Uranium","Radium"}
    };

    String[][] hardQuestions = {
        {"Which is the national bird of the United States of America?","Sparrow","Pigeon","Bald Eagle","Crow","Bald Eagle"},
        {"Which is the only district not getting fish in Nepal?","Manang","Jiri","Dolpa","Lamjung","Manang"},
        {"A device called ECG is used for the examination of which organ?","Brain","Liver","Heart","Kidney","Heart"},
        {"How long does it take for the sun’s light to come to Earth?","8min 20sec","8min 22sec","8min 27sec","8min 18sec","8min 20sec"},
        {"Which river in the world does not have fish?","Amazon","Jordon","Congo","Parana","Jordon"},
        {"What ray is used in remote control?","Infra red Ray","Gamma Ray","UV Ray","Alpha Ray","Infra red Ray"},
        {"What is the fastest growing plant?","Sugarcane","Bamboo","Mustard","Potato","Bamboo"},
        {"Which country is 6 days a week considered?","Bhutan","Bangladesh","Africa","China","China"},
        {"When was Interpol founded?","1958","1956","1955","1957","1956"},
        {"What is a non-snake country?","Iceland","Maldives","Pakistan","Iran","Iceland"},
        {"Who was the inventor of penicillin?","Nicholas Copernicus","Galileo Galilee","Alexander Fleming","Alexander Graham Bell","Alexander Fleming"},
        {"When is the darkest day in the history of sports in Nepal?","B.S. 2044 Falgun 29","B.S. 2044 Falgun 27","B.S. 2044 Falgun 26","B.S. 2044 Falgun 28","B.S. 2044 Falgun 29"},
        {"Which animal has three hearts and blue blood?","Octopus","Whale","Dolphin","Shark","Octopus"},
        {"Which is the first film launch in internet in Nepal?","Aama","Kusume Rumal","Badal Pari","Papi Manche","Badal Pari"},
        {"In which district is ‘Nand Bhauju’ Lake located?","Jumla","Lamjung","Dolpa","Chitwan","Chitwan"},
        {"Where is the world’s largest prison?","Pakistan","Russia","England","Isreal","Pakistan"}
    };


    int i, questionCount = 0, winPoint, questionPoint, submitted=0;
    int questionIndex = 0, gameLevel = 0, swapFlag = 0, swapFlagUsed = 0, doubleFlag = 0, fiftyFiftyFlagUsed = 0, doubleFlagUsed = 0;
    int wrongAnswerFlag = 0, quitFlag = 0;
    String correctAnswer;

    Stack<Integer> easyAskedIndices = new Stack<Integer>();
    Stack<Integer> mediumAskedIndices = new Stack<Integer>();
    Stack<Integer> hardAskedIndices = new Stack<Integer>();
    Stack<Integer> askedIndices = new Stack<Integer>();


    Stack<Integer> oneAskedIndices = new Stack<Integer>();
    Stack<Integer> twoAskedIndices = new Stack<Integer>();
    Stack<Integer> threeAskedIndices = new Stack<Integer>();
    Stack<Integer> fourAskedIndices = new Stack<Integer>();
    Stack<Integer> fiveAskedIndices = new Stack<Integer>();
    Stack<Integer> sixAskedIndices = new Stack<Integer>();
    Stack<Integer> sevenAskedIndices = new Stack<Integer>();
    Stack<Integer> eightAskedIndices = new Stack<Integer>();
    Stack<Integer> nineAskedIndices = new Stack<Integer>();
    Stack<Integer> tenAskedIndices = new Stack<Integer>();
    Stack<Integer> elevenAskedIndices = new Stack<Integer>();
    Stack<Integer> twelveAskedIndices = new Stack<Integer>();
    /**
     * 
     */
    public PlayGame(JFrame frame, Statement st){
        gameFrame = frame;
        stm = st;
        topLeftPanel= new JPanel();

        // System.out.println("Reached PlayGame");
        // frame.setLayout(null);
        // frame.setVisible(true);
        // frame.setSize(1450,1000);
        // frame.setBackground(Color.WHITE);


        gameLabel = new JLabel();
        gameLabel.setOpaque(true);
        gameLabel.setBackground(Color.decode("#533483"));
        gameLabel.setBounds(0, 0, 1000, 1000);

        topLeftPanel.setLayout(new GridLayout(0,3, 50,15));
        fiftyFiftyBtn = new JButton("50 : 50");
        fiftyFiftyBtn.setBounds(30, 30, 180, 20);
        fiftyFiftyBtn.setToolTipText("Click For 50 : 50");
        swapBtn = new JButton("Swap");
        swapBtn.setBounds(230, 30, 180, 20);
        swapBtn.setToolTipText("Click For Swapping Question");
        doubleDieBtn = new JButton("Double");
        doubleDieBtn.setBounds(430, 30, 180, 20);
        doubleDieBtn.setToolTipText("Click For DoubleDie");
        
        gameLabel.add(fiftyFiftyBtn);
        gameLabel.add(swapBtn);
        gameLabel.add(doubleDieBtn);
        topLeftPanel.setBounds(80,25,500, 40);
        // gameLabel.add(topLeftPanel);

        rightPanel = new JPanel(new GridLayout(0, 1));
        nestRightpanel = new JPanel();
        leftCenterPanel = new JPanel();
        // rightPanel.setHorizontalAlignment(SwingConstants.CENTER);
        
        // rightPanel.setLayout(new GridLayout(12,0, 0, 13));

        nestRightpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        nestRightpanel.setBackground(Color.BLUE);
        rightPanel.setBounds(800,50,150,600);
        rightPanel.setBackground(Color.decode("#533483"));
        nestRightpanel.setBounds(800, 50, 400, 550);
        
        // leftCenterPanel.setLayout(new GridLayout(12,0, 0, 13));

        l1 = new JLabel("$1,000");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l1.setBounds(0, 500, 300, 20);
        l1.setForeground(Color.WHITE);
        

        l2 = new JLabel("$3,000");
        l2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l2.setBounds(0, 460, 300, 20);
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("$5,000");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l3.setBounds(0, 420, 300, 20);
        l3.setForeground(Color.WHITE);
        
        l4 = new JLabel("$10,000");
        l4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l4.setBounds(0, 380, 300, 20);
        l4.setForeground(Color.WHITE);

        l5 = new JLabel("$15,000");
        l5.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l5.setBounds(0, 340, 300, 20);
        l5.setForeground(Color.WHITE);

        l6 = new JLabel("$30,000");
        l6.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l6.setBounds(0, 300, 300, 20);
        l6.setForeground(Color.WHITE);

        l7 = new JLabel("$60,000");
        l7.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l7.setBounds(0, 260, 300, 20);
        l7.setForeground(Color.WHITE);

        l8 = new JLabel("$120,000");
        l8.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l8.setBounds(0, 220, 300, 20);
        l8.setForeground(Color.WHITE);

        l9 = new JLabel("$250,000");
        l9.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l9.setBounds(0, 180, 300, 20);
        l9.setForeground(Color.WHITE);

        l10 = new JLabel("$500,000");
        l10.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l10.setBounds(0, 140, 300, 20);
        l10.setForeground(Color.WHITE);

        l11 = new JLabel("$1,000,000");
        l11.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l11.setAlignmentX(CENTER_ALIGNMENT);
        // l11.setBounds(20, 100, 300, 20);
        l11.setForeground(Color.WHITE);

        l12 = new JLabel("$1,000,000");
        l12.setFont(new Font("Times New Roman", Font.BOLD, 25));
        // l12.setBounds(0, 0, 40, 20);
        l12.setForeground(Color.WHITE);

        questionLbl = new JLabel();
        // Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        // questionLbl.setBorder(border);
        questionLbl.setBounds(80,260, 560, 40);
        questionLbl.setHorizontalAlignment(SwingConstants.CENTER);
        questionLbl.setVerticalAlignment(SwingConstants.CENTER);
        questionLbl.setOpaque(true);;
        questionLbl.setBackground(Color.BLUE);
        questionLbl.setForeground(Color.WHITE);

        timerLabel = new JLabel();
        // timerLabel.setAlignmentY();
        timerLabel.setFont(new Font("Monospace", Font.BOLD, 25));
        timerLabel.setBackground(Color.BLUE);
        timerLabel.setVerticalAlignment(SwingConstants.CENTER);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setOpaque(true);
        timerLabel.setForeground(Color.white);
        timerLabel.setBounds(80,165, 80, 80);

        // option buttons 
        gameLabel.add(timerLabel);
        gameLabel.add(questionLbl);
        
        option1 = new JButton();
        option1.setBounds(80+35, 340, 210, 35);
        option2 = new JButton();
        option2.setBounds(360+35, 340, 210, 35);
        option3 = new JButton();
        option3.setBounds(80+35, 400, 210, 35);
        option4 = new JButton();
        option4.setBounds(360+35, 400, 210, 35);

        lockBtn = new JButton("Lock");
        lockBtn.setBounds(80+35, 460, 490, 35);
        nextQuestionBtn = new JButton("Next");
        nextQuestionBtn.setBounds(80+35, 460, 490, 35);
        lockBtn.setToolTipText("Lock Your Answer");
        quitBtn= new JButton("Quit");
        quitBtn.setBounds(80+35, 515, 490, 35);
        quitBtn.setToolTipText("Quit Question");
        playAgainBtn = new JButton("Play Again");
        playAgainBtn.setBounds(80+35, 460, 490, 35);



        gameOverLbl = new JLabel("Game Over");
        gameOverLbl.setBounds(80+35, 570, 490, 35);
        gameOverLbl.setOpaque(true);
        gameOverLbl.setBackground(Color.red);
        gameOverLbl.setHorizontalAlignment(SwingConstants.CENTER);
        gameLabel.add(gameOverLbl);
        gameOverLbl.setVisible(false);
    

        // gameOverLbl = new JLabel("Game Over");
        // gameOverLbl.setBounds(80, 570, 490, 35);
        // gameOverLbl.setOpaque(true);
        // gameOverLbl.setBackground(Color.red);
        // gameLabel.add(gameOverLbl);
        // gameOverLbl.setVisible(false);


        
        gameLabel.add(option1);
        gameLabel.add(option2);
        gameLabel.add(option3);
        gameLabel.add(option4);
        gameLabel.add(lockBtn);
        gameLabel.add(nextQuestionBtn);
        gameLabel.add(quitBtn);
        gameLabel.add(playAgainBtn);


        buttonList[0] = option1;
        buttonList[1] = option2;
        buttonList[2] = option3;
        buttonList[3] = option4;



        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);

        lockBtn.addActionListener(this);
        quitBtn.addActionListener(this);
        nextQuestionBtn.addActionListener(this);
        playAgainBtn.addActionListener(this);
        swapBtn.addActionListener(this);
        fiftyFiftyBtn.addActionListener(this);
        doubleDieBtn.addActionListener(this);


        rightPanel.add(l12);
        rightPanel.add(l11);
        rightPanel.add(l10);
        rightPanel.add(l9);
        rightPanel.add(l8);
        rightPanel.add(l7);
        rightPanel.add(l6);
        rightPanel.add(l5);
        rightPanel.add(l4); 
        rightPanel.add(l3);
        rightPanel.add(l2);
        rightPanel.add(l1);
        // add(rightPanel);
        gameLabel.add(rightPanel);


       
        frame.add(gameLabel);
        startGame();  // TODO: uncomment this later
        // generateQuestionId();  // TODO: comment this later
  
}

void startTimer(int timeLimit){

    // TODO: limit time acc to question difficulty
    timer = new Timer();

    if(gameLevel == 3){
        timerLabel.setVisible(false);
        return;
    }

    timer.scheduleAtFixedRate(new TimerTask(){
        int i = timeLimit;


        public void run(){
            timerLabel.setText("" + i);
            i--;

            if(i < 0){
                timer.cancel();
                // timerLabel.setText("Time Over");
                lockBtn.setEnabled(false);

                // choosing the button with correct answer
                for(int i = 0; i < 4; i++){
                    if(buttonList[i].getText().equals(correctAnswer)){
                        buttonList[i].setBackground(Color.GREEN);
                    }
                }
                gameOver();
                // nextQuestionBtn.setVisible(false);
                // gameOver.setVisible(true);
                // playAgain.setVisible(true);
            }
        }
    }, 0, 1000);
}

    public int generateQuestionIndex(){
        int result;
        int min = 0;

        int max;

        if(gameLevel == 1){
            max = easyQuestions.length;
            result = (int)(Math.random()*(max - min) + min);

            if(easyAskedIndices.contains(result)){
                return generateQuestionIndex();
            }else{
                easyAskedIndices.push(result);
                return result;
            }
        }else if(gameLevel == 2){
            max = mediumQuestions.length;
            result = (int)(Math.random()*(max - min) + min);

            if(mediumAskedIndices.contains(result)){
                return generateQuestionIndex();
            }else{
                mediumAskedIndices.push(result);
                return result;
            }
        }else{
            max = hardQuestions.length;
            result = (int)(Math.random()*(max - min) + min);

            if(hardAskedIndices.contains(result)){
                return generateQuestionIndex();
            }else{
                hardAskedIndices.push(result);
                return result;
            }
        }

    }

    
    public int generateQuestionId(){
        // questionCount = 1; // TODO: comment this later
        int result;
        int min = 0;
        String query;

        int max = 0;
        try{
            query = "select count(*) as num from question_list where level = " + questionCount;

            rst = stm.executeQuery(query);
            if(rst.next()){
                max = rst.getInt("num");
            }

            // System.out.println("success");
            // System.out.println(max);
        }catch(Exception e){
            System.out.println("error: " + e.getMessage());
            // System.out.println(e.getMessage());
        }



        int[] ids = new int[max];
        try{
            query = "select id from question_list where level = " + questionCount;
            rst = stm.executeQuery(query);
            int temp = 0;
            while(rst.next()){
                ids[temp] = rst.getInt("id");
                System.out.println(ids[temp]);
                temp++;
            }
        }catch(Exception e){
            System.out.println("error: " + e.getMessage());
            // System.out.println(e.getMessage());
        }

        result = (int)(Math.random()*(max - min) + min);

        // if(askedIndices.contains(ids[result])){
        //     return generateQuestionId();
        // }else{
        //     askedIndices.push(ids[result]);
        //     return result;
        // }

        if(questionCount == 1){
            // repeating question if all questions are asked
            if(oneAskedIndices.size() >= max){
                while(oneAskedIndices.size() > 0){
                    oneAskedIndices.pop();
                }
            }

            if(oneAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                oneAskedIndices.push(ids[result]);
                System.out.println("result: "+ result + " ids[result]:" + ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 2){
            // repeating question if all questions are asked
            if(twoAskedIndices.size() >= max){
                while(twoAskedIndices.size() > 0){
                    twoAskedIndices.pop();
                }
            }

            if(twoAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                twoAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 3){
            // repeating question if all questions are asked
            if(threeAskedIndices.size() >= max){
                while(threeAskedIndices.size() > 0){
                    threeAskedIndices.pop();
                }
            }

            if(threeAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                threeAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 4){
            // repeating question if all questions are asked
            if(fourAskedIndices.size() >= max){
                while(fourAskedIndices.size() > 0){
                    fourAskedIndices.pop();
                }
            }

            if(fourAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                fourAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 5){
            // repeating question if all questions are asked
            if(fiveAskedIndices.size() >= max){
                while(fiveAskedIndices.size() > 0){
                    fiveAskedIndices.pop();
                }
            }

            if(fiveAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                fiveAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 6){
            // repeating question if all questions are asked
            if(sixAskedIndices.size() >= max){
                while(sixAskedIndices.size() > 0){
                    sixAskedIndices.pop();
                }
            }

            if(sixAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                sixAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 7){
            // repeating question if all questions are asked
            if(sevenAskedIndices.size() >= max){
                while(sevenAskedIndices.size() > 0){
                    sevenAskedIndices.pop();
                }
            }

            if(sevenAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                sevenAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 8){
            // repeating question if all questions are asked
            if(eightAskedIndices.size() >= max){
                while(eightAskedIndices.size() > 0){
                    eightAskedIndices.pop();
                }
            }

            if(eightAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                eightAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 9){
            // repeating question if all questions are asked
            if(nineAskedIndices.size() >= max){
                while(nineAskedIndices.size() > 0){
                    nineAskedIndices.pop();
                }
            }

            if(nineAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                nineAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 10){
            // repeating question if all questions are asked
            if(tenAskedIndices.size() >= max){
                while(tenAskedIndices.size() > 0){
                    tenAskedIndices.pop();
                }
            }

            if(tenAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                tenAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 11){
            // repeating question if all questions are asked
            if(elevenAskedIndices.size() >= max){
                while(elevenAskedIndices.size() > 0){
                    elevenAskedIndices.pop();
                }
            }

            if(elevenAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                elevenAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        if(questionCount == 12){
            // repeating question if all questions are asked
            if(twelveAskedIndices.size() >= max){
                while(twelveAskedIndices.size() > 0){
                    twelveAskedIndices.pop();
                }
            }

            if(twelveAskedIndices.contains(ids[result])){
                return generateQuestionId();
            }else{
                twelveAskedIndices.push(ids[result]);
                return ids[result];
            }
        }

        System.out.println("Question Id: " + result);
        
        return 0;
        // if(gameLevel == 1){
        //     max = easyQuestions.length;
        //     result = (int)(Math.random()*(max - min) + min);

        //     if(easyAskedIndices.contains(result)){
        //         return generateQuestionId();
        //     }else{
        //         easyAskedIndices.push(result);
        //         return result;
        //     }
        // }else if(gameLevel == 2){
        //     max = mediumQuestions.length;
        //     result = (int)(Math.random()*(max - min) + min);

        //     if(mediumAskedIndices.contains(result)){
        //         return generateQuestionId();
        //     }else{
        //         mediumAskedIndices.push(result);
        //         return result;
        //     }
        // }else{
        //     max = hardQuestions.length;
        //     result = (int)(Math.random()*(max - min) + min);

        //     if(hardAskedIndices.contains(result)){
        //         return generateQuestionId();
        //     }else{
        //         hardAskedIndices.push(result);
        //         return result;
        //     }
        // }


    }


    public void startGame(){
        questionCount++;

        if(swapFlag == 1){
            questionCount--;
            swapFlag = 0;
        }

        int timeLimit = 30;


        if(questionCount < 5){
            gameLevel = 1;
        }else if(questionCount < 8){
            gameLevel = 2;
        }else{
            gameLevel = 3;
        }
        decorateMoneyTree();

        try{
            questionIndex = generateQuestionId();

            System.out.println("Question Id: " + questionIndex);
            
            String query = "select * from question_list where id = " + questionIndex;

            rst = stm.executeQuery(query);
            if(rst.next()){
                currentQuestion = rst.getString("question");
                optionA = rst.getString("option_a");
                optionB = rst.getString("option_b");
                optionC = rst.getString("option_c");
                optionD = rst.getString("option_d");
                correctAnswer = rst.getString("correct_answer");
                System.out.println("A: " + optionA + " B: " + optionB + " C: " + optionC + " D: " + optionD + " Correct: " + correctAnswer);
                // timeLimit = 30;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            questionIndex = generateQuestionIndex();
            if(gameLevel == 1){
                currentQuestion = easyQuestions[questionIndex][0];
                optionA = easyQuestions[questionIndex][1];
                optionB = easyQuestions[questionIndex][2];
                optionC = easyQuestions[questionIndex][3];
                optionD = easyQuestions[questionIndex][4];
                correctAnswer = easyQuestions[questionIndex][5];
                timeLimit = 30;
            }else if(gameLevel == 2){
                currentQuestion = mediumQuestions[questionIndex][0];
                optionA = mediumQuestions[questionIndex][1];
                optionB = mediumQuestions[questionIndex][2];
                optionC = mediumQuestions[questionIndex][3];
                optionD = mediumQuestions[questionIndex][4];
                correctAnswer = mediumQuestions[questionIndex][5];
                timeLimit = 60;
            }else{
                currentQuestion = hardQuestions[questionIndex][0];
                optionA = hardQuestions[questionIndex][1];
                optionB = hardQuestions[questionIndex][2];
                optionC = hardQuestions[questionIndex][3];
                optionD = hardQuestions[questionIndex][4];
                correctAnswer = hardQuestions[questionIndex][5];
            }
        }

        if(gameLevel == 1){
            timeLimit = 30;
        }else if(gameLevel == 2){
            timeLimit = 60;
        }

        // System.out.println(questionCount + ", " + gameLevel + "," + currentQuestion);
        

        // lockBtn.setVisible(false);
        // lockLbl.setVisible(true);
        // gameOver.setVisible(false);
        // playAgain.setVisible(false);
        // nextQuestionBtn.setVisible(false);
        // nextQuestionLbl.setVisible(false);

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);


        lockBtn.setEnabled(false);


        // option1.addActionListener(this);
        // option2.addActionListener(this);
        // option3.addActionListener(this);
        // option4.addActionListener(this);
        // lockBtn.addActionListener(this);
        // nextQuestionBtn.addActionListener(this);
        // fifty.addActionListener(this);
        // dblGuess.addActionListener(this);
        // swp.addActionListener(this); 
        // playAgain.addActionListener(this); 

        questionLbl.setText(currentQuestion);
        // randomizing the option position
        Stack<Integer> taken = new Stack<Integer>();
        int rand, i=0;
        String[] optionArr = {optionA, optionB, optionC, optionD};
        while(i<4){
            rand = (int)(Math.random()*4);
            if(taken.contains(rand)){
                continue;
            }
            buttonList[i].setText(optionArr[rand]); // choosing option for button
            taken.push(rand);
            i++;
        }
        
        // option1.setText(optionA);
        // option2.setText(optionB);
        // option3.setText(optionC);
        // option4.setText(optionD);


        // if(gameLevel == 1){
        //     questionLbl.setText(easyQuestions[questionIndex][0]);
        //     option1.setText(easyQuestions[questionIndex][1]);
        //     option2.setText(easyQuestions[questionIndex][2]);
        //     option3.setText(easyQuestions[questionIndex][3]);
        //     option4.setText(easyQuestions[questionIndex][4]);
        //     timeLimit = 30;
        // }else if(gameLevel == 2){
        //     questionLbl.setText(mediumQuestions[questionIndex][0]);
        //     option1.setText(mediumQuestions[questionIndex][1]);
        //     option2.setText(mediumQuestions[questionIndex][2]);
        //     option3.setText(mediumQuestions[questionIndex][3]);
        //     option4.setText(mediumQuestions[questionIndex][4]);
        //     timeLimit = 60;
        // }else{
        //     questionLbl.setText(hardQuestions[questionIndex][0]);
        //     option1.setText(hardQuestions[questionIndex][1]);
        //     option2.setText(hardQuestions[questionIndex][2]);
        //     option3.setText(hardQuestions[questionIndex][3]);
        //     option4.setText(hardQuestions[questionIndex][4]);
        // }

        startTimer(timeLimit);



        option1.setBackground(Color.WHITE);
        option2.setBackground(Color.WHITE);
        option3.setBackground(Color.WHITE);
        option4.setBackground(Color.WHITE);

    }

// public void paint(Graphics g){
    
//     // super.paint(g);
//     // g.setColor(Color.BLUE);
//     // g.drawLine(90, 260, 60, 280);
//     // g.drawLine(90, 260, 118, 280);
//     // g.fillRoundRect(50, 180, 80, 80, 35, 35);
//     // g.setFont(new Font("Monospace", Font.BOLD, 25));
//     // g.setColor(Color.WHITE);
//     // g.drawString("30", 75, 225);
 
//     // int[] x ={25, 50, 550, 575, 550, 50};
//     // int[] y ={297, 280, 280, 297, 315, 315};
//     // g.setColor(Color.BLUE);
//     // g.fillPolygon(x, y, 6);
//     // g.setColor(Color.WHITE);
//     // g.setFont(new Font("Times New Roman", Font.BOLD, 18));
//     // g.drawString("Who is this This is me and ...knadjsfndkjsfhasjdfasdfnjasdhfojsdhfo",50,300);
  
// }

    public void optionButtonClicked(){
        choosedBtn = currentBtn;

        // System.out.println(option1.getBackground());
        if(option1.getBackground() != Color.red){
            option1.setBackground(Color.WHITE);
            // option1.setForeground(Color.decode("#000000"));
        }
        if(option2.getBackground() != Color.red){
            option2.setBackground(Color.WHITE);
            // option2.setForeground(Color.decode("#000000"));
        }
        if(option3.getBackground() != Color.red){
            option3.setBackground(Color.WHITE);
            // option3.setForeground(Color.decode("#000000"));
        }
        if(option4.getBackground() != Color.red){
            option4.setBackground(Color.WHITE);
            // option4.setForeground(Color.decode("#000000"));
        }

        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);

        lockBtn.setEnabled(true);


        if(option1.getBackground() == Color.red){
            option1.setEnabled(false);
            // option1.setForeground(Color.decode("#000000"));
        }
        if(option2.getBackground() == Color.red){
            option1.setEnabled(false);
            // option2.setForeground(Color.decode("#000000"));
        }
        if(option3.getBackground() == Color.red){
            option1.setEnabled(false);
            // option3.setForeground(Color.decode("#000000"));
        }
        if(option4.getBackground() == Color.red){
            option1.setEnabled(false);
            // option4.setForeground(Color.decode("#000000"));
        }
        
        // option2.setBackground(Color.WHITE);
        // option3.setBackground(Color.WHITE);
        // option4.setBackground(Color.WHITE);


        choosedBtn.setBackground(Color.GRAY);
        // choosedBtn.setForeground(Color.decode("#FDF6EC"));
        choosedBtn.setEnabled(false);

        // lockLbl.setVisible(false);
        lockBtn.setVisible(true);
    }

    public void lockButtonClicked(){
        disableLifeLines();
        choosedBtn.setEnabled(false);

        if(doubleFlag == 0){
            submitted = 1;
            currentBtn.setVisible(false);
            nextQuestionBtn.setVisible(true);
            timer.cancel();

            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);
        }

        if(choosedBtn.getText().equals(correctAnswer)){
            System.out.println("correct answer clicked");
            System.out.println("choosed: " + choosedBtn.getText() + " Correct: " + correctAnswer);
            doubleFlag = 0;
            choosedBtn.setBackground(Color.GREEN);
            moneyLevel[questionCount - 1].setBackground(Color.decode("#FFF323"));
            moneyLevel[questionCount - 1].setForeground(Color.decode("#000000"));
            quitBtn.setEnabled(true);
            currentBtn.setVisible(false);
            nextQuestionBtn.setVisible(true);
            timer.cancel();
            option1.setEnabled(false);
            option2.setEnabled(false);
            option3.setEnabled(false);
            option4.setEnabled(false);


            if(questionCount == 12){
                gameOver();
            }
        }else{
            System.out.println("wrong answer clicked");
            System.out.println("choosed: " + choosedBtn.getText() + " Correct: " + correctAnswer);
            System.out.print("conditions: ");
            System.out.println(choosedBtn.getText().equals(correctAnswer));
            choosedBtn.setBackground(Color.RED);
            choosedBtn.setEnabled(false);

            // choosing the button with correct answer
            if(doubleFlag == 0){

                for(int i = 0; i < 4; i++){
                    if(buttonList[i].getText().equals(correctAnswer)){
                        buttonList[i].setBackground(Color.GREEN);
                    }
                }
                wrongAnswerFlag = 1;
                gameOver();
            }else{
                // doubleFlag = 0;
                nextQuestionBtn.setVisible(false);
                playAgainBtn.setVisible(false);
                lockBtn.setVisible(true);
                lockBtn.setEnabled(false);
            }
            
            doubleFlag = 0;

        }

    }

    public void nextButtonClicked(){
        enableLifeLines();
        nextQuestionBtn.setVisible(false);
        option1.setVisible(true);
        option2.setVisible(true);
        option3.setVisible(true);
        option4.setVisible(true);
        lockBtn.setVisible(true);
        lockBtn.setEnabled(false);
        // questionIndex++;
        // System.out.println(questionIndex);
        // System.out.println(questions[questionIndex][0]);
        startGame();
    }

    public void swapButtonClicked(){
        swapFlag = 1;
        swapFlagUsed = 1;
        swapBtn.setEnabled(false);  //TODO: uncomment this later
        timer.cancel();
        enableLifeLines();
        startGame();
    }

    public void fiftyFiftyButtonClicked(){
        disableLifeLines();
        fiftyFiftyFlagUsed = 1;
        int removedButton = 0;
        Stack<Integer> checked = new Stack<Integer>();
        int temp;
        // System.out.println("fifty fifty pressed");
        quitBtn.setEnabled(false);

        while(removedButton < 2){
            temp = (int)(Math.random() * 4);
            // System.out.println(temp);

            if(checked.contains(temp)){
                continue;
            }

            checked.push(temp);

            if(buttonList[temp].getText().equals(correctAnswer)){
                continue;
            }else{
                buttonList[temp].setVisible(false);
                removedButton++;
            }
        }

        fiftyFiftyBtn.setEnabled(false); //TODO: uncomment this later
    }

    public void doubleDipButtonClicked(){
        disableLifeLines();
        doubleFlag = 1;
        doubleFlagUsed = 1;
        quitBtn.setEnabled(false);
        doubleDieBtn.setEnabled(false);
    }

    public void disableLifeLines(){
        fiftyFiftyBtn.setEnabled(false);
        doubleDieBtn.setEnabled(false);
        swapBtn.setEnabled(false);
    }

    public void enableLifeLines(){
        System.out.println("enable life lines. fifty = " + fiftyFiftyFlagUsed);
        System.out.println("double = " + doubleFlag + "swapFlag = " + swapFlagUsed);
        fiftyFiftyBtn.setEnabled(true);
        doubleDieBtn.setEnabled(true);
        swapBtn.setEnabled(true);

        if(doubleFlagUsed == 1){
            doubleDieBtn.setEnabled(false);
        }

        if(swapFlagUsed == 1){
            swapBtn.setEnabled(false);
        }

        if(fiftyFiftyFlagUsed == 1){
            fiftyFiftyBtn.setEnabled(false);
        }
    }


    public void actionPerformed(ActionEvent ae){
        currentBtn = (JButton)ae.getSource();
        System.out.println("called0");
        
        if(currentBtn.equals(quitBtn)){
            // System.out.println("called1");
            gameOver();
            // System.out.println("called3");
            gameLabel.setVisible(false);
            gameLabel.setText("");
            // System.out.println("called2");
            new FirstInterface(gameFrame, stm); // TODO: UNCOMMENT THIS LATER

        }


        if(currentBtn.getText().equals(optionA) || currentBtn.getText().equals(optionB)
            || currentBtn.getText().equals(optionC) || currentBtn.getText().equals(optionD)){
            optionButtonClicked();
        }else if(currentBtn.getText().equals("Lock")){
            System.out.println("lock button clicked");
            lockButtonClicked();
        
        }else if(currentBtn.getText().equals("Next")){
            nextButtonClicked();
        }else if(currentBtn.getText().equals("Swap")){
            swapButtonClicked();
        }else if(currentBtn.equals(playAgainBtn)){
            playAgain();
        }else if(currentBtn.equals(fiftyFiftyBtn)){
            fiftyFiftyButtonClicked();
        }else if(currentBtn.equals(doubleDieBtn)){
            doubleDipButtonClicked();
        }
    }

    void gameOver(){
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);

        lockBtn.setVisible(false);
        nextQuestionBtn.setVisible(false);
        playAgainBtn.setVisible(true);
        playAgainBtn.setEnabled(true);


        fiftyFiftyBtn.setEnabled(false);
        swapBtn.setEnabled(false);
        doubleDieBtn.setEnabled(false);
        gameOverLbl.setVisible(true);
        quitBtn.setEnabled(true);

        decorateMoneyTree();
    }

    void playAgain(){
        questionCount = 0;
        // System.out.println(easyAskedIndices);

        // TODO: check condition number later
        // if((easyQuestions.length - easyAskedIndices.size()) < 4){
        //     while(easyAskedIndices.size() > 0){
        //         easyAskedIndices.pop();
        //     }
        // }
        // if((mediumQuestions.length - mediumAskedIndices.size()) < 3){
        //     while(mediumAskedIndices.size() > 0){
        //         mediumAskedIndices.pop();
        //     }
        // }
        // if((hardQuestions.length - hardAskedIndices.size()) < 5){
        //     while(hardAskedIndices.size() > 0){
        //         hardAskedIndices.pop();
        //     }
        // }

        option1.setVisible(true);
        option2.setVisible(true);
        option3.setVisible(true);
        option4.setVisible(true);
        
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);


        lockBtn.setVisible(true);
        nextQuestionBtn.setVisible(false);
        playAgainBtn.setVisible(false);
        playAgainBtn.setEnabled(false);

        fiftyFiftyBtn.setEnabled(true);
        swapBtn.setEnabled(true);
        doubleDieBtn.setEnabled(true);
        gameOverLbl.setVisible(false);
        timerLabel.setVisible(true);

        // set all flag to false
        wrongAnswerFlag = 0;
        swapFlag = 0;
        quitFlag = 0;
        doubleFlag = 0;
        fiftyFiftyFlagUsed = 0;



        startGame();

    }

    void decorateMoneyTree(){
        moneyLevel[0] = l1;
        moneyLevel[1] = l2;
        moneyLevel[2] = l3;
        moneyLevel[3] = l4;
        moneyLevel[4] = l5;
        moneyLevel[5] = l6;
        moneyLevel[6] = l7;
        moneyLevel[7] = l8;
        moneyLevel[8] = l9;
        moneyLevel[9] = l10;
        moneyLevel[10] = l11;
        moneyLevel[11] = l12;

        System.out.println("questions count = " + questionCount);

        for(int i = 0; i < 12; i++){
            moneyLevel[i].setOpaque(true);
            moneyLevel[i].setBackground(Color.decode("#533483"));
            moneyLevel[i].setForeground(Color.decode("#BF9742"));
            moneyLevel[i].setHorizontalAlignment(SwingConstants.CENTER);
            moneyLevel[i].setVerticalAlignment(SwingConstants.CENTER);

            if(i == 0 || i == 3 || i == 6){                
                moneyLevel[i].setForeground(Color.decode("#FCFFE7"));
            }

            if(i + 1 == questionCount && wrongAnswerFlag != 1){
                moneyLevel[i].setBackground(Color.decode("#FFCE45"));
                moneyLevel[i].setForeground(Color.decode("#000000"));
            }


            if(wrongAnswerFlag == 1){
                if(gameLevel == 1){
                    moneyLevel[0].setBackground(Color.decode("#FFCE45"));
                    moneyLevel[0].setForeground(Color.decode("#000000"));
                
                }else if(gameLevel == 2){
                    moneyLevel[3].setBackground(Color.decode("#FFCE45"));
                    moneyLevel[3].setForeground(Color.decode("#000000"));
                
                }else if(gameLevel == 3){
                    moneyLevel[6].setBackground(Color.decode("#FFCE45"));
                    moneyLevel[6].setForeground(Color.decode("#000000"));
                }
            }
        }
    }



// public static void main(String[] args) {
//     JFrame frame = new JFrame();
//     frame.setSize(1000,1000);
//     frame.setLocation(10,10);
//     frame.setLayout(null);
//     frame.setVisible(true);
//     frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
//     new PlayGame(frame);
// }
}
