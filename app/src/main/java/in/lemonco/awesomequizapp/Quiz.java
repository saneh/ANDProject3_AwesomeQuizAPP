package in.lemonco.awesomequizapp;

/**
 * Quiz class contains all the questions and answers in a Quiz array
 */
public class Quiz {
    private String question;
    private String answer;

    public Quiz(String ques, String ans) {
        this.question = ques;
        this.answer = ans;
    }

    public final static Quiz[] QUIZCARDS = {
            new Quiz("What is the closest planet to the Sun?", "mercury"),
            new Quiz("What is the name of the 2nd biggest planet in our solar system?", "saturn"),
            new Quiz("What is the hottest planet in our solar system?", "venus"),
            new Quiz("What planet is famous for its big red spot on it?", "jupiter"),
            new Quiz("What planet is famous for the beautiful rings that surround it?", "saturn"),
            new Quiz("Have human beings ever set foot on Mars?", "no"),
            new Quiz("What is the name of NASA’s most famous space telescope?", "hubble space telescope"),
            new Quiz("Ganymede is a moon of which planet?", "jupiter"),
            new Quiz("What is the name of Saturn’s largest moon?", "Titan"),
            new Quiz("Olympus Mons is a large volcanic mountain on which planet?", "mars")
    };

    public String getAnswer() {
        return this.answer;
    }

    public String getQuestion() {
        return this.question;
    }
}

