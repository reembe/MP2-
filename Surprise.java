// //this class just contains everything ive learned about gui, will be deleted when we are done



// import javax.swing.JOptionPane;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JMenu;
// import javax.swing.JMenuBar;
// import javax.swing.JMenuItem;

// import java.awt.CardLayout;
// import java.awt.Color;
// import java.awt.Container;
// import java.awt.FlowLayout;
// import java.awt.Font;
// import java.awt.FontFormatException;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.KeyEvent;
// import java.io.File;
// import java.io.IOException;

// import javax.sound.sampled.*;

// public class Surprise extends JFrame implements ActionListener{

//     JMenuBar menuBar;
// 	JMenu fileMenu;
// 	JMenu editMenu;
// 	JMenu helpMenu;
// 	JMenuItem loadItem;
// 	JMenuItem saveItem;
// 	JMenuItem exitItem;
//     JButton button;
//     JButton buttonA;
// 	//ImageIcon loadIcon;
// 	//ImageIcon saveIcon;
// 	//ImageIcon exitIcon;

//     public Surprise() throws UnsupportedAudioFileException, IOException, LineUnavailableException
//     {
        
       
//   //blank screen

       
      
//         this.setLayout(null);



       

//         JLabel l =  new JLabel();
//         l.setText("LOTE Helper");
//         l.setHorizontalTextPosition(JLabel.CENTER);
//         l.setVerticalTextPosition(JLabel.TOP);
//         l.setForeground(Color.pink);
//         l.setFont(new Font("MV Boli", Font.BOLD, 20));
 
       
        
//         this.setTitle("LOTE Helper");
//         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         this.setResizable(false);
//         // this.setSize(1920,1080);
//         this.setSize(1920,1080);
//         this.getContentPane().setBackground(Color.pink);
//         this.setVisible(true);
//         this.add(l);
//         // this.add(button);
//         this.add(buttonA);
    
//         File file = new File("musik.wav");
//         AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
//         Clip clip = AudioSystem.getClip();
//         clip.open(audioStream);
//         clip.start();
        
  
//     }

//     @Override
//     public void actionPerformed(ActionEvent e) {
       
//         if (e.getSource() == loadItem)
//         {
//            System.out.print("Saved!");
//         }
//         if (e.getSource() == exitItem)
//         {
//             System.exit(0);
//         }
//         if (e.getSource() == buttonA)
//         {
//          this.setVisible(false);
//         // this.setVisible(false);
//         //  User s= new User("Bob", 12, "Spanish");
//         //  s.pickLanguage();
//         //  this.setVisible(true);
//         //  button.setEnabled(false);
       
//             try {
// 				introductionMenu introductionMenu = new introductionMenu();
// 			} catch (FontFormatException | IOException e1) {
// 				// TODO Auto-generated catch block
// 				e1.printStackTrace();
// 			}
   
    
//         }
//     }
// }
    
