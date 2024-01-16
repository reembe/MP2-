import javax.swing.JOptionPane;


/** Precondition: age > 0  
 * Postcondition: creates user objects
*/

public class User {
    private static final User User = null;
    private String name;
    private int age;
    private String language;
    private static User instance = null;
    private static User[] userList;
    private static int userNum;

    public User(String n, String l)
    {

        this.name = n;
        // this.age = a;
        this.language = l;
        // userList[userNum] = this.instance;
        // userNum++;
    }

    public User getName()
    {
        return this.User.getName(); 
    }
   
     public static User getInstance() {
        return instance;
    }


    public void pickLanguage()
    {
        String option = JOptionPane.showInputDialog("What language Would You like To Pick? ");
        setLanguage(option);
        JOptionPane.showMessageDialog(null, "Congrats your new language is " + option);
    }

    private void setLanguage(String o)
    {
        this.language = o;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public void getUserList()
    {
        for (User u : userList)
        {
            System.out.println(u.getName() +"!");
        }

    }

    public String toString()
    {
        return "User: " + name + ", " + language + "Learner";

    }


    
}
