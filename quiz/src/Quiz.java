import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {

    String[] questions = {
                            "Quel est la Capital de la France ? ",
                            "Quel sport pratique Teddy Riner ? ",
                            "Ou ce passe les prochains jeu olympique en 2028 ? "
                         };

    String[][] options = {
                            {"Marseille", "Toulouse" ,"Paris", "Lyon"},
                            {"Judo", "Boxe" ,"Karaté", "MMA"},
                            {"Australie", "Canada" ,"France", "USA"},
                        };
    char[] answers = {
                        'C',
                        'A',
                        'D',
                     };
    //char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_question = questions.length;
    int result;
    //int seconds = 10;


    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton buttonNextQuestion = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    //JLabel time_label = new JLabel();
    //JLabel seconds_left = new JLabel();
    JTextField number_rigth = new JTextField();
    JTextField percentage = new JTextField();



    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(255,250,240));
        textField.setFont(new Font("Ink Free",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(255,250,240));
        textArea.setFont(new Font("MV Boli",Font.BOLD,20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        buttonA.setBounds(0,125,100,100);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,375,100,100);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,500,100,100);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        buttonNextQuestion.setBounds(375,510,250,75);
        buttonNextQuestion.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonNextQuestion.setFocusable(false);
        buttonNextQuestion.addActionListener(this);
        buttonNextQuestion.setText("Question Suivant");

        answer_labelA.setBounds(125,125,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MV boli",Font.BOLD,35));

        answer_labelB.setBounds(125,250,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MV boli",Font.BOLD,35));

        answer_labelC.setBounds(125,375,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MV boli",Font.BOLD,35));

        answer_labelD.setBounds(125,500,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MV boli",Font.BOLD,35));

       /* seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(250,0,0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN,20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Timer "); */

        number_rigth.setBounds(225,225,200,100);
        number_rigth.setBackground(new Color(25,25,25));
        number_rigth.setForeground(new Color(25,255,0));
        number_rigth.setFont(new Font("Ink Free",Font.BOLD,50));
        number_rigth.setBorder(BorderFactory.createBevelBorder(1));
        number_rigth.setHorizontalAlignment(JTextField.CENTER);
        number_rigth.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        frame.add(buttonNextQuestion);
        // frame.add(time_label);
        //frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion(){

        if(index >= total_question){
            results();
        }
        else {
            textField.setText("Question "+(index + 1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);


        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonNextQuestion.setEnabled(true);


        if (e.getSource() == buttonA){
            answer = 'A';
            if (answer == answers[index]){
                correct_guesses++ ;
            }
        }

        if (e.getSource() == buttonB){
            answer = 'B';
            if (answer == answers[index]){
                correct_guesses++ ;
            }
        }

        if (e.getSource() == buttonC){
            answer = 'C';
            if (answer == answers[index]){
                correct_guesses++ ;
            }
        }

        if (e.getSource() == buttonD){
            answer = 'D';
            if (answer == answers[index]){
                correct_guesses++ ;
            }
        }

        displayAnswer();

        if(e.getSource() == buttonNextQuestion){
            resetQuestion();
            index++;
            nextQuestion();

        }
    }

    public void resetQuestion(){
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);

        answer_labelA.setForeground(Color.GREEN);
        answer_labelB.setForeground(Color.GREEN);
        answer_labelC.setForeground(Color.GREEN);
        answer_labelD.setForeground(Color.GREEN);

        answer = '\0';


    }

    public void displayAnswer(){



        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));



    }
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int) ((correct_guesses/(double)total_question) * 100);

        textField.setText("Resultas");
        textArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_rigth.setText(correct_guesses + " / " + total_question);
        percentage.setText(result + " % ");

        frame.add(percentage);
        frame.add(number_rigth);
    }
}
