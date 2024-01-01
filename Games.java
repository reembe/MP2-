import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Games implements ActionListener{

    private String gameName; 
    private String language;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public Games(String n, User s)
    {
        gameName = n;
        language = s.getLanguage();

    }

    public String getGameName()
    {
        return gameName;
    }

    public void mcQuiz()
    {
        if (language.equals("french"))
        {

        }
        if (language.equals("spanish"))
        {

        }

    }

    public void Listening()
    {
             if (language.equals("french"))
        {

        }
        if (language.equals("spanish"))
        {

        }

    }

    public void fillInTheBlank()
    {
             if (language.equals("french"))
        {

        }
        if (language.equals("spanish"))
        {

        }

    }

    public void matchingGame()
    {
             if (language.equals("french"))
        {

        }
        if (language.equals("spanish"))
        {

        }

    }

    public void trueorFalse()
    {
             if (language.equals("french"))
        {

        }
        if (language.equals("spanish"))
        {

        }

    }


    
    
}
