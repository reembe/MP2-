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
import java.awt.FontFormatException;
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
private JButton mcQuiz2;
private JButton surprise;
private JButton mcQuiz3;
private JLabel title;
private JLabel submessage;
private JLabel welcomemessage;
private static User user;
private ImageIcon logo;
private JLabel logol;


    public mainMenu(User s) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        user = s;

        ImageIcon logo = new ImageIcon("LOTE_HELPER_logo.jpg");
        logol =  new JLabel();
        logol.setBounds(500,600,400,150);
        logol.setForeground(Color.pink);
        logol.setFont(new Font("MV Boli", Font.BOLD, 20));

        logol.setIcon(logo);

        menuBar = new JMenuBar();
        saveMenu = new JMenu("Save");
        restartMenu = new JMenu("Restart");
        viewAccount = new JMenu("View Account");
        helpMenu = new JMenu("Help");

        mcQuiz = new JButton();
        mcQuiz.setBounds(0,80,400,150);
		mcQuiz.setFont(new Font("MV Boli",Font.BOLD,35)); 
        
        // //import joystix.ttf later for all options

		mcQuiz.setFocusable(false);
		mcQuiz.addActionListener(this);
		mcQuiz.setText("Level 1: MC Quiz");

        mcQuiz2 = new JButton();
        mcQuiz2.setBounds(500,80,400,150);
		mcQuiz2.setFont(new Font("MV Boli",Font.BOLD,35));
		mcQuiz2.setFocusable(false);
		mcQuiz2.addActionListener(this);
		mcQuiz2.setText("Level 2: MC Quiz");

        mcQuiz3 = new JButton();
        mcQuiz3.setBounds(1040,80,400,150);
		mcQuiz3.setFont(new Font("MV Boli",Font.BOLD,35));
		mcQuiz3.setFocusable(false);
		mcQuiz3.addActionListener(this);
		mcQuiz3.setText("Level 3: MC Quiz");
        
        Listening = new JButton();
        Listening.setBounds(0,300,400,150);
		Listening.setFont(new Font("MV Boli",Font.BOLD,35));
		Listening.setFocusable(false);
		Listening.addActionListener(this);
		Listening.setText("Listening Practice!");

        trueorFalse = new JButton();
        trueorFalse.setBounds(500,300,400,150);
		trueorFalse.setFont(new Font("MV Boli",Font.BOLD,35));
		trueorFalse.setFocusable(false);
		trueorFalse.addActionListener(this);
		trueorFalse.setText("True or False?");

        surprise = new JButton();
        surprise.setBounds(1040,300,400,150);
		surprise.setFont(new Font("MV Boli",Font.BOLD,35));
		surprise.setFocusable(false);
		surprise.addActionListener(this);
		surprise.setText("SURPRISE!");

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
        this.getContentPane().setBackground(new Color(255,238,255));
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("LOTE Helper");


        this.setVisible(true);

        this.add(mcQuiz);
        this.add(trueorFalse);
        this.add(mcQuiz2);
        this.add(mcQuiz3);
        this.add(Listening);
        this.add(logol);
        this.add(surprise);

        menuBar.add(saveMenu);
        menuBar.add(restartMenu);
        menuBar.add(viewAccount);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == mcQuiz)
        {
            Games Games = new Games("mcQuiz", user);
                Games.mcQuiz();
                this.setVisible(false);
          
        }
        if (e.getSource() == trueorFalse)
        {
            if (user.getLanguage().equals("french"))
            {
            TrueOrFalseF TrueOrFalseF = new TrueOrFalseF();
            TrueOrFalseF.Quiz(user);
            this.setVisible(false);
            } 
            else{
            TrueOrFalseS TrueOrFalseS = new TrueOrFalseS();
            TrueOrFalseS.Quiz(user);
            this.setVisible(false);
            }
        }
        if (e.getSource() == restartMenu)
        {
            try {
                introductionMenu introductionMenu = new introductionMenu();
                this.setVisible(false);
            } catch (FontFormatException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

      

    }
}


