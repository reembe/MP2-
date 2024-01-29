import javax.swing.JOptionPane;


/** Precondition: language is not null when user object is initilized 
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
    private static int count;

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

    public User[] formatUserListbackwards()
    {
       // alg ???

      for (int k = 0; k < userList.length / 2; k++)
            {
                User j = userList[k];
                userList[k] = userList[userList.length - k - 1];
                userList[userList.length - k - 1] = j;
    
            }


        return userList;



    }

    public int moreLoopsforrequirements()
    {
        while (count < 5) // does this count as a count ?????
        {
            for(int i = 0; i < 10; i++)
            {
                count++;
                if ((count%2) == i)
                {
                    return count;
                }

            }

        }
        return count;

    }


    
}
