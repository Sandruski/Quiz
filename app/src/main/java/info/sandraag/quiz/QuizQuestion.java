package info.sandraag.quiz;

public class QuizQuestion {

    private String text;
    private String[] answers;
    private int correct;

    public QuizQuestion(String text, String[] answers, int correct) {

        this.text = text;
        this.answers = answers;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
