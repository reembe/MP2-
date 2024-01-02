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
            String[] qf = {"1. How many pronouns are there?", "2. What are the basic conjugates?", "3. What tense is for a continuous past event?", "4. How many francaphone countries are there?", "5. How do you conjugate an IR verb using the nous pronoun?", "6. How do you say Hello in french?", "7. How many tenses are there?", "8. Who is the best french actor (Alive)?", "9. When was the first appearence of french in records?", "10. "};
        }
        if (language.equals("spanish"))
        {
            String[] qs = {"1. What is 3 in Spanish?", "2. Which of the following means \"cat\" in Spanish?", "3. What is the female pronoun?","4. How many Spanish speaking countries are there?", "5. Which of the following is the imperfect tense for the verb \"ser\" in the yo form?", "6. Which of the following greets means \"good morning\" in Spanish?", "7. How do you " };
            String[] as = {};
            String[] bs = {};
            String[] cs = {};
            String[] ds = {};


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
