package muratk.mktarih.Models;

/**
 * Created by Murat on 23/11/15.
 */
public class QuestionModel {
    private double QuestionId;
    private double QuestionLesson;
    private double QuestionTest;
    private  String QuestionQuestion;
    private  String QuestionAOption;
    private  String QuestionBOption;
    private  String QuestionCOption;
    private  String QuestionDOption;
    private String QuestionAnswer;

    public double getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(double questionId) {
        QuestionId = questionId;
    }

    public double getQuestionLesson() {
        return QuestionLesson;
    }

    public void setQuestionLesson(double questionLesson) {
        QuestionLesson = questionLesson;
    }

    public double getQuestionTest() {
        return QuestionTest;
    }

    public void setQuestionTest(double questionTest) {
        QuestionTest = questionTest;
    }

    public String getQuestionQuestion() {
        return QuestionQuestion;
    }

    public void setQuestionQuestion(String questionQuestion) {
        QuestionQuestion = questionQuestion;
    }

    public String getQuestionAOption() {
        return QuestionAOption;
    }

    public void setQuestionAOption(String questionAOption) {
        QuestionAOption = questionAOption;
    }

    public String getQuestionBOption() {
        return QuestionBOption;
    }

    public void setQuestionBOption(String questionBOption) {
        QuestionBOption = questionBOption;
    }

    public String getQuestionCOption() {
        return QuestionCOption;
    }

    public void setQuestionCOption(String questionCOption) {
        QuestionCOption = questionCOption;
    }

    public String getQuestionDOption() {
        return QuestionDOption;
    }

    public void setQuestionDOption(String questionDOption) {
        QuestionDOption = questionDOption;
    }

    public String getQuestionAnswer() {
        return QuestionAnswer;
    }

    public void setQuestionAnswer(String questionAnswer) {
        QuestionAnswer = questionAnswer;
    }

    public QuestionModel() {
    }

    public QuestionModel(double questionId, double questionLesson, double questionTest, String questionQuestion, String questionAOption, String questionBOption, String questionCOption, String questionDOption, String questionAnswer) {
        QuestionId = questionId;
        QuestionLesson = questionLesson;
        QuestionTest = questionTest;
        QuestionQuestion = questionQuestion;
        QuestionAOption = questionAOption;
        QuestionBOption = questionBOption;
        QuestionCOption = questionCOption;
        QuestionDOption = questionDOption;
        QuestionAnswer = questionAnswer;
    }
}
