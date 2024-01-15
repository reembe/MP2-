
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
import javax.swing.Timer;


public class TrueOrFalseS implements ActionListener{
    private JFrame frame = new JFrame();
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
	private static int seconds = 10;
	private static int char_list = -1;
	private String[] AnswerString;


	private Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
    public void Quiz() {

		String[] mg = {"1. El español es el único idioma que se habla en España.",
		"2. El Día de los Muertos se celebra el 31 de octubre de cada año.",
		"3. La bandera mexicana es roja, blanca y verde.",
		"4. Los idiomas no estan en mayuscula en español.",
		"5. Madrid está situada en el centro físico del país.",
		"6. Stem-change verbs in the Preterite are called Boot verbs.",
		"7. Bag is \"una bolsa\" in Spanish.",
		"8. Possessive Adjectives express the quality of the ownership.",
		"9. -er and -ir verbs share the same endings in the Preterite.",
		"10. There are 2 pronouns in Spanish."};
	    String[] answers = {"false", "false", "true", "true", "true", "false", "true", "true", "true", "false"};
		AnswerString = answers;
        questions = mg;
		

		GameStarter();
		}

    
		
        public void GameStarter(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920,1080);
		frame.getContentPane().setBackground(Color.pink);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,1920,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,1920,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,200,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("True");
		
		buttonB.setBounds(0,200,200,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("False");
		
		
	
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
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
		
			
			
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		if(AnswerString[char_list].equals("false"))
			buttonA.setForeground(new Color(255,0,0));
		if(AnswerString[char_list].equals("true"))
		    buttonB.setForeground(new Color(255,0,0));

		

		

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
		
	}




}
