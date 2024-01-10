import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Games implements ActionListener {

    private String gameName;
    private String language;

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public Games(String n, User s) {
        gameName = n;
        language = s.getLanguage();
    }

    public String getGameName() {
        return gameName;
    }

    public void mcQuiz() {
        if (language.equals("french")) {
            String[] qf = {
                "1. Combien de pronoms existent-ils?",
                "2. Quelles sont les conjugaisons de base?",
                "3. Quel temps est utilisé pour un événement passé continu?",
                "4. Combien de pays francophones existent-ils?",
                "5. Comment conjuguer un verbe en -IR avec le pronom 'nous'?",
                "6. Comment dit-on bonjour en français?",
                "7. Combien de temps verbaux existent-ils?",
                "8. Qui est le meilleur acteur français (en vie)?",
                "9. Quand a eu lieu la première apparition du français dans les documents?",
                "10. Quel est le nom de notre professeur?"
            };
        }
        if (language.equals("spanish")) {
            String[] qs = {"1. What is 3 in Spanish?",
                "2. Which of the following means \"cat\" in Spanish?",
                "3. What is the female pronoun?",
                "4. How many Spanish speaking countries are there?",
                "5. Which of the following is the imperfect tense for the verb \"ser\" in the yo form?",
                "6. Which of the following greetings means \"good morning\" in Spanish?",
                "7. How do you conjugate the yo form of the verb \"correr\" in the present tense?",
                "8. Which of the following means \"to buy\" in Spanish?",
                "9. What does \"como se dice\" mean in English?",
                "10. What does \"tu madre\" mean in English?"};

            String[] as = {};
            String[] bs = {};
            String[] cs = {};
            String[] ds = {};
        }
    }

    public void Listening() {
        if (language.equals("french")) {

        }
        if (language.equals("spanish")) {

        }
    }

    public void fillInTheBlank() {
        if (language.equals("french")) {
            String[] fitb = {"1. Nous _avoir_ un examen lundi.",
                "2. Elle __ française.",
                "3. Le chien est __ la table.",
                "4. Tu __ venir à la fête?",
                "5. Les élèves __ beaucoup de devoirs.",
                "6. __-tu au cinéma hier soir?",
                "7. La fille __ un livre intéressant.",
                "8. Nous __ dîner ensemble ce soir.",
                "9. Le professeur __ la leçon.",
                "10. Vous __ du café?"};
        }
        if (language.equals("spanish")) {

        }
    }

    public void matchingGame() {
        if (language.equals("french")) {

        }
        if (language.equals("spanish")) {

        }
    }

    public void trueorFalse() {
        if (language.equals("french")) {
            String[] mg = {"1. Les verbes réfléchis sont couramment utilisés en français.",
                "2. La France a 30 provinces.",
                "3. Le futur proche utilise l'auxiliaire 'être'.",
                "4. 'Rouge' est un adjectif de couleur.",
                "5. Le passé composé est utilisé pour décrire une action en cours.",
                "6. 'Bonjour' est utilisé pour dire au revoir.",
                "7. La négation 'ne...pas' est utilisée avant le verbe.",
                "8. La chanteuse Édith Piaf était surnommée 'La Môme Piaf'.",
                "9. Le français est une langue romane.",
                "10. Les articles définis en français sont 'le', 'la', 'les'."
            };
        }
        if (language.equals("spanish")) {

        }
    }
}
