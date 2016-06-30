package in.lemonco.awesomequizapp;

import java.util.ArrayList;

/**
 * Quiz class contains all the questions and answers in a Quiz array
 */
public class Quiz {
    private String question, answer, answer1, answer2;

    //constructor for Quiz with one correct answer
    public Quiz(String ques, String ans) {
        this.question = ques;
        this.answer = ans;
    }

    //constructor for Quiz with two correct answers
    public Quiz(String ques, String ans, String ans1) {
        this.question = ques;
        this.answer = ans;
        this.answer1 = ans1;
    }

    //constructor for quiz with three correct answers
    public Quiz(String ques, String ans, String ans1, String ans2) {
        this.question = ques;
        this.answer = ans;
        this.answer1 = ans1;
        this.answer2 = ans2;
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
            new Quiz("Olympus Mons is a large volcanic mountain on which planet?", "mars"),
            new Quiz("Select all planets from the list?", "Earth", "Venus", "Jupiter"),
            new Quiz("How many planets are in our solar system", "9")
    };

    public String getAnswer() {
        return this.answer;
    } //getter method for single answer

    public String getQuestion() {
        return this.question;
    } //getter method for question

    //getter method for multiple answers
    public ArrayList<String> getMultiAnswer() {
        ArrayList<String> ans_arrayList = new ArrayList<String>();
        ans_arrayList.add(answer);
        ans_arrayList.add(answer1);
        ans_arrayList.add(answer2);
        return ans_arrayList;
    }
}

