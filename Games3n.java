import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.io.IOException;
import javax.swing.Timer;


public class Games3n extends JFrame implements ActionListener {

    private String gameName;
    private String language;
	private JButton returnHome; 
    private JFrame frame = new JFrame();
	private JTextField textfield = new JTextField();
	private JTextArea textarea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JButton buttonC = new JButton();
	private JButton buttonD = new JButton();
	private JLabel answer_labelA = new JLabel();
	private JLabel answer_labelB = new JLabel();
	private JLabel answer_labelC = new JLabel();
	private JLabel answer_labelD = new JLabel();
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
	private static int seconds = 10;

	private static int char_list = -1;
	private char[] AnswerChars;
	private  Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	

    public Games3n(String n, User s) {
        gameName = n;
        language = s.getLanguage();
		user = s;
    }


    public String getGameName() {
        return gameName;
    }

    public void mcQuiz() {

		

		
        if (language.equals("french")) {
            String[] qf = {"1. Que signifie  \"boire\" ?", "2. À quelle heure est-il utilisé pour discuter d'informations générales ?",
			"3. Quelle nourriture est consommée vers 20 heures ?",
			"4. Cette question n'a pas de sens, appuyez sur la troisième option?",
			"5. Qu’est-ce qui a des ailes et ne vole pas? "};

		String[][] af = {{"Manger de la nourriture","Passé progressif","Snack","Apprendre","A moulin "},
		{"Jouer dans la piscine", "Imparfait", "Déjeuner", "Danser", "Un hippocampe" },
		{"Consommer un liquide", "Prétérit", "Dîner", "Baiser", "Le papier toilette"},
		{"Manger du gâteau", "Présenter en continu", "Petit déjeuner", "Nettoyer", "Je ne sais pas :("}};

			char[] AnswerChar = {'C', 'A', 'B', 'B', 'A'};

			AnswerChars = AnswerChar;

			questions = qf;
			answersa = af;

			GameStarter();

        }
        if (language.equals("spanish")) {
			String[] qs = {"1. ¿Qué significa \"beber\"? ",
			"2. ¿Qué tiempo se usa para discutir información general?",
			"3. ¿Qué comida se consume alrededor de las 8 de la noche?",
			"4. ¿Esta pregunta no tiene sentido, presiona la tercera opción?",
			"5. Responde el acertijo: Una cajita redonda, blanca como el azar, todos la saben abrir, nadie la sabe cerrar."};

		String[][] as = {{"Para comer comida","Pasado progresivo","Bocadillo","Aprender","El huevo"}, 
		{"Jugar en la piscina", "Imperfecto", "Almuerzo", "Bsilar", "Las uvas" }, 
		{"Consumir un liquis", "Pretérito","Cena", "Besar", "La naranja"}, 
		{"Come un poco de pastel", "Presente continuo", "Desayuno","Limpiar", "No sé :("}};

		char[] AnswerChar = {'C', 'B', 'C', 'C', 'A'};
			AnswerChars = AnswerChar;

			questions = qs;
             answersa = as;

			 GameStarter();
		}
   

	}

        public void GameStarter(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920,1080);
		//bottom big half bg
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		frame.setResizable(false);
		
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

		returnHome = new JButton(); //REEMMM THIS IS WHERE I CHNANGED FOR THE RETURN HOME BUTTON TO EXTEND IT
		returnHome.setBounds(500,500,500,100);
		returnHome.setFont(new Font("WEST JAVA",Font.BOLD,100));
		returnHome.setFocusable(false);
		returnHome.addActionListener(this);
		returnHome.setText("Return");
		
		buttonB.setBounds(0,290,175,175);
		buttonB.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		frame.setTitle("McQuiz");
		//button for answer choices, doesnt move the actual option
		buttonC.setBounds(0,480,175,175);
		buttonC.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,670,175,175);
		buttonD.setFont(new Font("WEST JAVA",Font.BOLD,100));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
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
		answer_labelD.setBounds(200,725,5000,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(0,0,0));
		answer_labelD.setFont(new Font("WEST JAVA",Font.PLAIN,50));
		
		seconds_left.setBounds(1250,650,200,200);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(233,220,245));
		seconds_left.setFont(new Font("WEST JAVA",Font.BOLD,100));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
	
		
		number_right.setBounds(640,225,200,100);
		number_right.setBackground(new Color(255,255,255));
		number_right.setForeground(new Color(0,0,0));
		number_right.setFont(new Font("WEST JAVA",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(640,325,200,100);
		percentage.setBackground(new Color(207,252,255));
		percentage.setForeground(new Color(249,207,242)); //percentage color
		percentage.setFont(new Font("WEST JAVA",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
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
			answer_labelD.setText(answersa[3][index]);
			timer.start();
			index++;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
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
			if(e.getSource()==buttonD) {
				answer = 'D';
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
		buttonD.setEnabled(false);
		
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
	if(AnswerChars[char_list] != 'D')
		answer_labelD.setForeground(new Color(255,0,0));
		if(AnswerChars[char_list] == 'D')
		{
			answer_labelD.setForeground(new Color(0,255,0));
		}
	
		
	seconds = 10;


	Timer pause = new Timer(2000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			answer_labelA.setForeground(Color.black);
			answer_labelB.setForeground(Color.black);
			answer_labelC.setForeground(Color.black);
			answer_labelD.setForeground(Color.black);
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);

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
		buttonD.setEnabled(false);
		
		int result = (int)((correct_guesses/(double)questions.length)*100);
		
		textfield.setText("Your score:");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+questions.length+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);

		returnHome.setVisible(true);	
		
	}

    public void Listening() {
        if (language.equals("french")) {

        }
        if (language.equals("spanish")) {

        }
    }
    }

