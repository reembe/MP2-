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

// all this must be deleted later b/c we cant have nonprivate instance variables
    private JMenuBar menuBar;
	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	JMenuItem loadItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
    JLabel title;
    JButton button;
    JButton buttonA;
	ImageIcon loadIcon;
	ImageIcon saveIcon;
	ImageIcon exitIcon;

    mainMenu() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
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
