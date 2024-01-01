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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class introductionMenu extends JFrame implements ActionListener{

    JButton button;
    JButton option1;
    JButton option2;
    JButton continueButton;
	JTextField textField;
    int buttonsPressed;
    String currentOption;

    public introductionMenu() throws FontFormatException, IOException 
    {
        File font_file = new File("joystix.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font sizedFont = font.deriveFont(40f);

        JLabel title = new JLabel();
        title.setText("Welcome to LOTE Helper!");
        title.setBounds(0,57,10000000,100);
        title.setForeground(Color.black);
        title.setFont(sizedFont);

        JLabel intro = new JLabel();
        intro.setText("Here you will find fun educational games");
        intro.setBounds(0,107,10000000,100);
        intro.setForeground(Color.black);
        intro.setFont(sizedFont);

        JLabel intro1 = new JLabel();
        intro1.setText("to help you prepare for your LOTE exams!");
        intro1.setBounds(0,157,10000000,100);
        intro1.setForeground(Color.black);
        intro1.setFont(sizedFont);

        button = new JButton("Submit");
		button.addActionListener(this);
        button.setBounds(200,500,100,100);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(250,40));
		textField.setFont(sizedFont);
        textField.setBounds(500,500,1000,100);
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.white);
		textField.setCaretColor(Color.white);
		textField.setText("Name: ");
        // textField.getText()

        option1 = new JButton("Spanish");
		option1.addActionListener(this);
        option1.setBounds(200,600,100,100);


        option2 = new JButton("French");
		option2.addActionListener(this);
        option2.setBounds(300,600,100,100);

        continueButton = new JButton("Continue?");
		continueButton.addActionListener(this);
        continueButton.setBounds(200,700,100,100);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("LOTE Helper");

        this.setVisible(true);
        this.add(title);
        this.add(intro);
        this.add(intro1);
        this.add(button);
        this.add(option1);
        this.add(option2);
		this.add(textField);
        this.add(continueButton);
        continueButton.setEnabled(false);
       

       
				

    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button) {
			System.out.println("Welcome "+ textField.getText());
			button.setEnabled(false);
			textField.setEditable(false);
            buttonsPressed++;
             
		}
         if(e.getSource()==option1) {
             buttonsPressed++; 
            currentOption = "spanish";

         }
         if(e.getSource()==option2) {
            buttonsPressed++;
            currentOption = "french";

         }
         if(e.getSource() == continueButton)
         {
            User user = new User(textField.getText(), currentOption);
            try {
                mainMenu mainMenu = new mainMenu(user);
                this.setVisible(false);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }


         }
        if (buttonsPressed == 2)
       {
        continueButton.setEnabled(true);
       }

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

    }
    
}
