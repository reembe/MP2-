import javax.swing.JOptionPane;

public class User {
    private String name;
    private int age;
    private String language;

    public User(String n, int a, String l)
    {
        n = JOptionPane.showInputDialog("What is your name? ");
        a = Integer.parseInt(JOptionPane.showInputDialog("How old are you? "));
        l = JOptionPane.showInputDialog("What language would you like to learn ");
        JOptionPane.showMessageDialog(null, "Hi, " + n + "! Thank you for picking LOTE Helper!");
        this.name = n;
        this.age = a;
        this.language = l;
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
