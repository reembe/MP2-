import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class introductionMenu extends JFrame implements ActionListener{

    private JButton button;
    private JButton option1;
    private JButton option2;
    private JButton continueButton;
	private JTextField textField;
    private int buttonsPressed;
    private String currentOption;
    private ImageIcon logo;
    //private JLabel logogo;

    public introductionMenu() throws FontFormatException, IOException 
    {

        //logo = new ImageIcon("LOTE_Helper_logo.jpg");

        File font_file = new File("joystix.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = font.deriveFont(40f);

        JLabel title = new JLabel();
        title.setText("Welcome to LOTE Helper!");
        title.setBounds(300,57,10000000,100);
        title.setForeground(Color.pink);
        title.setFont(sizedFont);

        JLabel intro = new JLabel();
        intro.setText("Enter your name then select a language");
        intro.setBounds(100,107,100000,100);
        intro.setForeground(Color.pink);
        intro.setFont(sizedFont);

        // JLabel intro1 = new JLabel();
        // intro1.setText("to help you prepare for your LOTE exams!");
        // intro1.setBounds(300,157,10000000,100);
        // intro1.setForeground(Color.WHITE);
        // intro1.setFont(sizedFont);

        button = new JButton("Submit");
		button.addActionListener(this);
        button.setBounds(500,600,100,100);
        button.setBackground(Color.pink);
		button.setForeground(Color.black);

		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(sizedFont);
        textField.setBounds(200,500,1000,100);
		textField.setForeground(Color.pink);
		textField.setBackground(Color.white);
		textField.setCaretColor(Color.pink);
		textField.setText("Name: ");

        option1 = new JButton("Spanish");
		option1.addActionListener(this);
        option1.setBounds(600,600,100,100);
        option1.setBackground(Color.pink);
		option1.setForeground(Color.black);

        option2 = new JButton("French");
		option2.addActionListener(this);
        option2.setBounds(700,600,100,100);
        option2.setBackground(Color.pink);
		option2.setForeground(Color.black);

        continueButton = new JButton("Continue");
		continueButton.addActionListener(this);
        continueButton.setBounds(800,600,100,100);
        continueButton.setBackground(Color.pink);
		continueButton.setForeground(Color.black);

        //logogo = new JLabel();
        //logogo.setBounds(950, 500, 100,100);;
        //logogo.setIcon(logo);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("LOTE Helper");

        this.setVisible(true);
        this.add(title);
        this.add(intro);
        //this.add(logogo);
        this.add(button);
        this.add(option1);
        this.add(option2);
		this.add(textField);
        this.add(continueButton);
        //this.add(logogo);
        continueButton.setEnabled(false);		
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==button) {
			button.setEnabled(false);
			textField.setEditable(false);
            buttonsPressed++;
             
		}
         if(e.getSource()==option1) {
             buttonsPressed++; 
            currentOption = "spanish";
            option2.setEnabled(false);
            option1.setEnabled(false);	

         }
         if(e.getSource()==option2) {
            buttonsPressed++;
            currentOption = "french";
            option1.setEnabled(false);
            option2.setEnabled(false);	

         }
         if(e.getSource() == continueButton)
         {
            User user = new User(textField.getText(), currentOption);
          
                try {
                    mainMenu mainMenu = new mainMenu(user);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
           
                this.setVisible(false);
            
            }
            if (buttonsPressed == 2)
       {
        continueButton.setEnabled(true);
       }
        }

    public void introductionMenu() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'introductionMenu'");
    }
}