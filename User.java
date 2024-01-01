import javax.swing.JOptionPane;

public class User {
    private String name;
    private int age;
    private String language;
    private static User instance = null;

    public User(String n, String l)
    {

        this.name = n;
        // this.age = a;
        this.language = l;
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


    
}
