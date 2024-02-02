import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;


public class Listenings extends JFrame implements ActionListener {

    private String gameName;
    private String language;
	private JButton returnHome; 
    private JFrame frame = new JFrame();
	private JTextField textfield = new JTextField();
	private JTextArea textarea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JButton buttonC = new JButton();
	
	private JLabel answer_labelA = new JLabel();
	private JLabel answer_labelB = new JLabel();
	private JLabel answer_labelC = new JLabel();
	
	private JLabel time_label = new JLabel();
	private JLabel seconds_left = new JLabel();
	private JTextField number_right = new JTextField();
	private JTextField percentage = new JTextField();
	private User user;
    private static int index;
    private String[] questions;
    private static char answer;
    private static int correct_guesses;
    private String[][] answersa;
	private Clip clip;
	private static int seconds = 10;

	private static int char_list = -1;
	private char[] AnswerChars;
	private  Timer timer = new Timer(10000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});

        public Listenings(User s) {
            user = s;
        }
	



    public void Quiz() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
       
            String[] qs = {"1. La competencia de surf dura...",
                "2. Este año participan...",
                "3. Los participantes son...",
                "4. Eva quiere saber si ella y Ethan pueden...",
                "5. Además de la competencia de surf, por la noche se celebra..."};
 
            String[][] as = {{"un día","treinta surfistas","hispanos","bañarse en la playa","un concierto"}, 
            {"dos días", "cuarenta surfistas", "norteamericanos", "montar en bici", "una carrera"}, 
			{"tres días", "cien surfistas","de varios países", "asistir a algún espectáculo", "un concurso"}};

			char[] AnswerChar = {'C', 'A', 'C', 'C', 'A'};
			AnswerChars = AnswerChar;

			questions = qs;
             answersa = as;

			 GameStarter();
		
   

	}

        public void GameStarter() throws UnsupportedAudioFileException, IOException, LineUnavailableException{



			
        File file = new File("spanishaudio.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920,1080);
		//bottom big half bg
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Listening");
		
		textfield.setBounds(-250,0,1920,50);
		//vv for the bottom background in t/f
		textfield.setBackground((Color.pink)); //pink from intro menu
		textfield.setForeground(new Color(0,0,0)); //nvm
		textfield.setFont(new Font("WEST JAVA",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		//vv second top rectangle thing with the questions displayed
		textarea.setBounds(0,50,1920,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground((Color.pink));
		textarea.setForeground(new Color(0,0,0)); //lol nvm
		textarea.setFont(new Font("WEST JAVA",Font.BOLD,40));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,175,175);
		buttonA.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");


		buttonB.setBounds(0,290,175,175);
		buttonB.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");


		buttonC.setBounds(0,480,175,175);
		buttonC.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");


		returnHome = new JButton(); //REEMMM THIS IS WHERE I CHNANGED FOR THE RETURN HOME BUTTON TO EXTEND IT
		returnHome.setBounds(500,500,500,100);
		returnHome.setFont(new Font("WEST JAVA",Font.BOLD,100));
		returnHome.setFocusable(false);
		returnHome.addActionListener(this);
		returnHome.setText("Return");
		
	
		
		
		answer_labelA.setBounds(200,150,5000,100);
		answer_labelA.setBackground(new Color(250,50,50));
		answer_labelA.setForeground(new Color(0,0,0));
		answer_labelA.setFont(new Font("WEST JAVA",Font.PLAIN,50));
		
		answer_labelB.setBounds(200,325,5000,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(0,0,0));
		answer_labelB.setFont(new Font("WEST JAVA",Font.PLAIN,50));
		
		answer_labelC.setBounds(200,525,5000,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(0,0,0));
		answer_labelC.setFont(new Font("WEST JAVA",Font.PLAIN,50));
		//
		
		seconds_left.setBounds(1250,650,200,200);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(233,220,245));
		seconds_left.setFont(new Font("WEST JAVA",Font.BOLD,100));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(207,252,255));
		number_right.setFont(new Font("WEST JAVA",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(207,252,255));
		percentage.setForeground(new Color(207,252,255));
		percentage.setFont(new Font("WEST JAVA",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
	
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
	
		frame.add(textarea);
		frame.add(textfield);
		frame.add(returnHome);

		returnHome.setVisible(false);
		
		frame.setVisible(true);
		
		nextQuestion();
	}
    

    public void nextQuestion() {
		char_list++;
		
		
		if(index>=questions.length) {
			results();
		}
		else {
			
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(answersa[0][index]);
			answer_labelB.setText(answersa[1][index]);
			answer_labelC.setText(answersa[2][index]);
	
			timer.start();
			index++;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
		
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == AnswerChars[char_list]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer = 'B';
				if(answer == AnswerChars[char_list]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer = 'C';
				if(answer == AnswerChars[char_list]) {
					correct_guesses++;
				}
			}
			
			if(e.getSource() == returnHome)
			{
				try {
					MainMenu MainMenu = new MainMenu(user);
					frame.setVisible(false);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		
		if(AnswerChars[char_list] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
			if(AnswerChars[char_list] == 'A')
			{
				answer_labelA.setForeground(new Color(0,255,0));
			}
		if(AnswerChars[char_list] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
			if(AnswerChars[char_list] == 'B')
			{
				answer_labelB.setForeground(new Color(0,255,0));
			}
		if(AnswerChars[char_list] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
			if(AnswerChars[char_list] == 'C')
			{
				answer_labelC.setForeground(new Color(0,255,0));
			}
		
		seconds = 10;


		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(233,220,245));
				answer_labelB.setForeground(new Color(233,220,245));
				answer_labelC.setForeground(new Color(233,220,245));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				
				nextQuestion();
				
				
			}
		});
		
		pause.setRepeats(false);
		pause.start();
		
	}
	

	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		
		int result = (int)((correct_guesses/(double)questions.length)*100);
		
		textfield.setText("Your score:");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		
		
		number_right.setText("("+correct_guesses+"/"+questions.length+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		clip.stop();

		returnHome.setVisible(true);	
		
	}

    public void Listening() {
        if (language.equals("french")) {

        }
        if (language.equals("spanish")) {

        }
    }
    }

