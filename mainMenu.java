import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class mainMenu extends JFrame implements ActionListener{



private JMenu helpMenu;
private JMenu saveMenu;
private JMenu restartMenu;
private JMenu viewAccount;
private JMenuBar menuBar;
private JButton mcQuiz;
private JButton Listening;
private JButton fillInTheBlank;
private JButton matchingGame;
private JButton trueorFalse;
private JLabel title;
private JLabel submessage;
private JLabel welcomemessage;
private static User user;


    public mainMenu(User s) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        user = s;

        // menuBar = new JMenuBar();
        // saveMenu = new JMenu("Save");
        // restartMenu = new JMenu("Restart");
        // viewAccount = new JMenu("View Account");
        // helpMenu = new JMenu("Help");

        mcQuiz = new JButton();
        mcQuiz.setBounds(0,100,150,150);
		mcQuiz.setFont(new Font("MV Boli",Font.BOLD,35)); 
        
        // //import joystix.ttf later for all options

		mcQuiz.setFocusable(false);
		mcQuiz.addActionListener(this);
		mcQuiz.setText("Multiple Choice Quiz!");

        // Listening = new JButton();
        // Listening.setBounds(0,100,100,100);
		// Listening.setFont(new Font("MV Boli",Font.BOLD,35));
		// Listening.setFocusable(false);
		// Listening.addActionListener(this);
		// Listening.setText("Listening Practice!");

        // fillInTheBlank = new JButton();
        // fillInTheBlank.setBounds(0,100,100,100);
		// fillInTheBlank.setFont(new Font("MV Boli",Font.BOLD,35));
		// fillInTheBlank.setFocusable(false);
		// fillInTheBlank.addActionListener(this);
		// fillInTheBlank.setText("Completing Sentences!");

        // matchingGame = new JButton();
        // matchingGame.setBounds(0,100,100,100);
		// matchingGame.setFont(new Font("MV Boli",Font.BOLD,35));
		// matchingGame.setFocusable(false);
		// matchingGame.addActionListener(this);
		// matchingGame.setText("Match Terms!");

        // trueorFalse = new JButton();
        // trueorFalse.setBounds(0,100,100,100);
		// trueorFalse.setFont(new Font("MV Boli",Font.BOLD,35));
		// trueorFalse.setFocusable(false);
		// trueorFalse.addActionListener(this);
		// trueorFalse.setText("True or False?");

        title = new JLabel();
        title.setText("Please select which mode you want to practice with:");
        title.setBounds(0,57,10000000,100);
        title.setForeground(Color.black);
        // title.setFont(sizedFont);

        // submessage.setText("Your current language");
        // submessage.setBounds(0,57,10000000,100);
        // submessage.setForeground(Color.black);
        // // submessage.setFont(sizedFont);



        // saveMenu.setMnemonic(KeyEvent.VK_S);
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(new Color(50,94,168));
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("LOTE Helper");








        this.setVisible(true);

        this.add(mcQuiz);
        
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == mcQuiz)
        {
            Games Games = new Games("mcQuiz", user);
                Games.mcQuiz();
                this.setVisible(false);
          
        }
        // if (e.getSource() == exitItem)
        // {
        //     System.exit(0);
        // }
        // if (e.getSource() == button)
        // {
        // this.setVisible(false);
        //  User s= new User("Bob", 12, "Spanish");
        //  s.pickLanguage();
        //  this.setVisible(true);
        //  button.setEnabled(false);
        // }

    }
}


// import java.net.URL;
// import java.util.ResourceBundle;
// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.control.ChoiceBox;
// import javafx.scene.control.Label;

// public class Controller implements Initializable{

// 	@FXML
// 	private Label myLabel;
	
// 	@FXML
// 	private ChoiceBox<String> myChoiceBox;
	
// 	private String[] food = {"pizza","sushi","ramen"};

// 	@Override
// 	public void initialize(URL arg0, ResourceBundle arg1) {
		
// 		myChoiceBox.getItems().addAll(food);
// 		myChoiceBox.setOnAction(this::getFood);
		
// 	}
	
// 	public void getFood(ActionEvent event) {
		
// 		String myFood = myChoiceBox.getValue();
// 		myLabel.setText(myFood);
// 	}

// }

// <?xml version="1.0" encoding="UTF-8"?>

// <?import javafx.scene.control.ChoiceBox?>
// <?import javafx.scene.control.Label?>
// <?import javafx.scene.layout.AnchorPane?>
// <?import javafx.scene.text.Font?>

// <AnchorPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/15.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="application.Controller">
//    <children>
//       <ChoiceBox fx:id="myChoiceBox" layoutX="225.0" layoutY="188.0" prefWidth="150.0" />
//       <Label fx:id="myLabel" alignment="CENTER" layoutX="-2.0" layoutY="94.0" prefHeight="17.0" prefWidth="600.0" text="Select what you want to eat">
//          <font>
//             <Font size="28.0" />
//          </font>
//       </Label>
//    </children>
// </AnchorPane>