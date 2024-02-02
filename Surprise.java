//this class just contains everything ive learned about gui, will be deleted when we are done




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.*;

public class Surprise extends JFrame implements ActionListener{

    private static JButton reward;
    private static JButton returntoMenu;
    private User use;
    private static JLabel rewardmessage;


    public Surprise(User user) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        use = user;
        

      
        this.setLayout(null);



       

        JLabel l =  new JLabel();
        l.setText("So " + user + ", you worked real hard");
        l.setBounds(50,57,10000000,100);
        l.setForeground(Color.black);
        l.setFont(new Font("WEST JAVA", Font.BOLD, 75));

        JLabel j =  new JLabel();
        j.setText("you better pass your exams now");
        j.setBounds(150,127,10000000,100);
        j.setForeground(Color.black);
        j.setFont(new Font("WEST JAVA", Font.BOLD, 75));

        JLabel k =  new JLabel();
        k.setText("click the button below to reveal your reward");
        k.setBounds(150,197,10000000,100);
        k.setForeground(Color.black);
        k.setFont(new Font("WEST JAVA", Font.BOLD, 75));

        rewardmessage =  new JLabel();
        rewardmessage.setText("TIMBITS FOR THE WHOLE CLASS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        rewardmessage.setBounds(300,557,10000000,100);
        rewardmessage.setForeground(Color.black);
        rewardmessage.setFont(new Font("WEST JAVA", Font.BOLD, 50));


        reward =  new JButton();
		reward.setBounds(1500,850,400,175);
		reward.setFont(new Font("WEST JAVA",Font.BOLD,50));
		reward.setFocusable(false);
		reward.addActionListener(this);
		reward.setText("CLICK HERE !!");

        returntoMenu =  new JButton();
		returntoMenu.setBounds(1600,850,300,175);
		returntoMenu.setFont(new Font("WEST JAVA",Font.BOLD,50));
		returntoMenu.setFocusable(false);
		returntoMenu.addActionListener(this);
		returntoMenu.setText("Return?");

        
        this.setTitle("SURPRISE?!?!?!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(Color.pink);
        this.setVisible(true);
        
    
    

        this.add(l);
        this.add(j);
        this.add(k);
        this.add(rewardmessage);
        this.add(returntoMenu);
        this.add(reward);

        rewardmessage.setVisible(false);
        returntoMenu.setVisible(false);
        
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == returntoMenu)
        {
            try {
                MainMenu MainMenu = new MainMenu(use);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
           
        }

        if (e.getSource() == reward)
        {
            reward.setVisible(false);
            rewardmessage.setVisible(true);
            returntoMenu.setVisible(true);
           
        }
    }
}

    
