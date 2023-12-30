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

public class MyFrame extends JFrame implements ActionListener{

    JMenuBar menuBar;
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
    JButton button;
	//ImageIcon loadIcon;
	//ImageIcon saveIcon;
	//ImageIcon exitIcon;

    MyFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        ImageIcon image = new ImageIcon("cute.jpg");
        ImageIcon i = new ImageIcon("doge.jpg");
  

        menuBar =  new JMenuBar();
        fileMenu = new JMenu("Menu");
        editMenu = new JMenu("Courses");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F
        // exitItem.setMnemonic(KeyEvent.VK_E);

        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        // -> System.out.print("Hi!"));
        button.setText("Spanish");
        button.setFocusable(false);
        button.setIcon(i);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setBackground(Color.DARK_GRAY);

       
        this.setLayout(new FlowLayout());



        loadItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(loadItem);
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

        JLabel l =  new JLabel();
        l.setText("LOTE Helper");
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.TOP);
        l.setForeground(Color.blue);
        l.setFont(new Font("MV Boli", Font.BOLD, 20));
 
       
        l.setIcon(i);
        this.setIconImage(image.getImage());
        this.setTitle("LOTE Helper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        this.setSize(500,500);
        this.getContentPane().setBackground(Color.pink);
        this.setVisible(true);
        this.add(l);
        this.add(button);
    
        // File file = new File("musik.wav");
        // AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        // Clip clip = AudioSystem.getClip();
        // clip.open(audioStream);
        // clip.start();
        
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == loadItem)
        {
           System.out.print("Saved!");
        }
        if (e.getSource() == exitItem)
        {
            System.exit(0);
        }
        if (e.getSource() == button)
        {
        this.setVisible(false);
         User s= new User("Bob", 12, "Spanish");
         s.pickLanguage();
         this.setVisible(true);
         button.setEnabled(false);
        }

    }
}
