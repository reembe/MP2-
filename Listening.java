import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Listening implements ActionListener{
	
    private JFrame frame = new JFrame();
	private User user;
	private JTextField textfield = new JTextField();
	private JTextArea textarea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JLabel time_label = new JLabel();
	private JLabel seconds_left = new JLabel();
	private JTextField number_right = new JTextField();
	private JTextField percentage = new JTextField();
    private static int index;
    private String[] questions;
    private static String answer;
    private static int correct_guesses;
	private JButton returnHome;
	private Clip clip;
	private static int seconds = 10;
	private static int char_list = -1;
	private String[] AnswerString;


	private Timer timer = new Timer(10000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});


		    public Listening(User s) {
		user = s;
    }

	
    public void Quiz() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		


		String[] mg = {
			"1. Il est déprimé.",
			"2. Il dort trop.",
			"3. Il ne fait pas assez d'exercice.",
			"4. Il a des douleurs à la gorge.",
			"5. Il a beaucoup d'allergies.",
			"6. Il a mal au dos.",
			"7. Il ne mange pas sainement.",
			"8. Il a de la fièvre."};

	    String[] answers = {"true", "false", "true", "false", "false", "true", "true"};
		AnswerString = answers;
        questions = mg;
		

		GameStarter();
		}

	
    
		
        public void GameStarter() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

		File file = new File("frenchaudio.wav");
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
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
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
		
		buttonA.setBounds(0,100,600,100);
		buttonA.setFont(new Font("WEST JAVA",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("True");
		
		buttonB.setBounds(840,100,600,100);
		buttonB.setFont(new Font("WEST JAVA",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("False");
		
		seconds_left.setBounds(1250,650,200,200);
		seconds_left.setBackground(Color.black);
		seconds_left.setForeground(Color.pink);
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		//*dont change anything except for the color of the words
		number_right.setBounds(620,225,200,100);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(249,207,242));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		//COME BACK HERE
		percentage.setBounds(620,325,200,100);
		percentage.setBackground(new Color(255,255,255));
		percentage.setForeground(new Color(249,207,242));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(textarea);
		frame.add(textfield);

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
			
			System.out.println(index);
			timer.start();
			System.out.print(seconds);
			index++;
		}
	}

    @OverRide
	public void actionPerformed(ActionEvent e) {
		
			
			if(e.getSource()==buttonA) {
				answer= "true";
				if(AnswerString[char_list].equals(answer)) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer = "false";
				if(AnswerString[char_list].equals(answer)) {
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
					((Throwable) e1).printStackTrace();
				}
			}
		
			
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		if(AnswerString[char_list].equals("false"))
			buttonA.setForeground(new Color(255,90,85));
		if(AnswerString[char_list].equals("true")) {
		    buttonB.setForeground(new Color(255,90,85));
		}


		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				buttonA.setForeground(Color.black);
				buttonB.setForeground(Color.black);
				
				answer = " ";
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
			
				nextQuestion();
				
			}
		});
		
		pause.setRepeats(false);
		pause.start();
	}

	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
				
		int result = (int)((correct_guesses/(double)10)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		
		number_right.setText("("+correct_guesses+"/"+10+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);

		clip.stop();

		returnHome.setVisible(true);	
		
	}
}