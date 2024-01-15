import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Games extends JFrame implements ActionListener {

    private String gameName;
    private String language;
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
	

    public Games(String n, User s) {
        gameName = n;
        language = s.getLanguage();
    }


    public String getGameName() {
        return gameName;
    }

    public void mcQuiz() {

		

		
        if (language.equals("french")) {
            String[] qf = {
                "1. Combien de pronoms existent-ils?",
                "2. Quelles sont les conjugaisons de base?",
                "3. Quel temps est utilisé pour un événement passé continu?",
                "4. Combien de pays francophones existent-ils?",
                "5. Comment conjuguer un verbe en -IR avec le pronom 'nous'?",
                "6. Comment dit-on bonjour en français?",
                "7. Combien de temps verbaux existent-ils?",
                "8. Qui est le meilleur acteur français (en vie)?",
                "9. Quand a eu lieu la première apparition du français dans les documents?",
                "10. Quel est le nom de notre professeur?"};


				
			String[][] af = {{"8", "e, es, e, ons, ez, ent", "Passé composé", "18", "issons", "Bonjourné", "21", "Omar Sy", "L'année 842", "Newman"}, 
			{"4", "s, s, x, ons, ez, ent", "Imparfait", "28", "ons", "Salut", "9", "Timothee Chalamet", "L'année 843", "Eddy"},
			{"6", "e, es, e, ont, ez, ons", "Futur simple", "8", "ent", "Bonsoir", "15", "Anne Hathaway", "L'année 1052", "Holmer"},
			{"5", "s, s, es, ons, ez, ent", "Present", "23", "ont", "Bonne nuit", "10", "Angelina Jolie", "L'année 2022", "Eric Adamns"}};
			
			
			char[] AnswerChar = {}; // look at mine to see how i formatted it!

			questions = qf;
			answersa = af;

			GameStarter();


        }
        if (language.equals("spanish")) {
            String[] qs = {"1. What is 3 in Spanish?",
                "2. Which of the following means \"cat\" in Spanish?",
                "3. What is the female pronoun?",
                "4. How many Spanish speaking countries are there?",
                "5. Which of the following is the imperfect tense for the verb \"ser\" in the yo form?",
                "6. Which of the following greetings means \"good morning\" in Spanish?",
                "7. How do you conjugate the yo form of the verb \"correr\" in the present tense?",
                "8. Which of the following means \"to buy\" in Spanish?",
                "9. What does \"como se dice\" mean in English?",
                "10. What does \"tu madre\" mean in English?"};
 
            String[][] as = {{"Tres","Perro","Usted","1","Era","Hola","Corro","Comprar","What is that", "Your dad"}, 
            {"Cuatro", "Gato", "El", "4", "Fui","Buenos noches", "Corri", "Dinero", "How do you say", "My mom" }, 
			{"Cinco", "Pajaro","Ella", "21", "Seaba", "Buenos Dias", "Correo", "Dolar", "How do I do that", "Your brother"}, 
			{"Venti", "Oso", "Nosotros","5", "Eraba", "Buen", "Correr","Buyar", "Who am I", "Your mom"}};

			char[] AnswerChar = {'A', 'B', 'C', 'C', 'A', 'C', 'A', 'A', 'B', 'D'};
			AnswerChars = AnswerChar;

			questions = qs;
             answersa = as;

			 GameStarter();
		}

            
          

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
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("MV Boli",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("MV Boli",Font.PLAIN,35));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("MV Boli",Font.PLAIN,35));
		
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
		if(AnswerChars[char_list] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(AnswerChars[char_list] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(AnswerChars[char_list] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		
		
		
			
		seconds = 10;

	
		

		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
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
		
		int result = (int)((correct_guesses/(double)10)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+10+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}


    public void Listening() {
        if (language.equals("french")) {

        }
        if (language.equals("spanish")) {

        }
    }

    // public void fillInTheBlank() {
    //     if (language.equals("french")) {
    //         String[] fitb = {"1. Nous _avoir_ un examen lundi.",
    //             "2. Elle __ française.",
    //             "3. Le chien est __ la table.",
    //             "4. Tu __ venir à la fête?",
    //             "5. Les élèves __ beaucoup de devoirs.",
    //             "6. __-tu au cinéma hier soir?",
    //             "7. La fille __ un livre intéressant.",
    //             "8. Nous __ dîner ensemble ce soir.",
    //             "9. Le professeur __ la leçon.",
    //             "10. Vous __ du café?"};
    //     }
    //     if (language.equals("spanish")) {

    //     }
    // }

    

    }

