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

// ask about nonprivate instance variables

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


    mainMenu(User s) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        // menuBar = new JMenuBar();
        // saveMenu = new JMenu("Save");
        // restartMenu = new JMenu("Restart");
        // viewAccount = new JMenu("View Account");
        // helpMenu = new JMenu("Help");

        // mcQuiz = new JButton();
        // mcQuiz.setBounds(0,100,100,100);
		// mcQuiz.setFont(new Font("MV Boli",Font.BOLD,35)); 
        
        // //import joystix.ttf later for all options

		// mcQuiz.setFocusable(false);
		// mcQuiz.addActionListener(this);
		// mcQuiz.setText("Multiple Choice Quiz!");

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

        // title = new JLabel();
        // title.setText("Please select which mode you want to practice with:");
        // title.setBounds(0,57,10000000,100);
        // title.setForeground(Color.black);
        // // title.setFont(sizedFont);

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
        
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        // if (e.getSource() == loadItem)
        // {
        //    System.out.print("Saved!");
        // }
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
