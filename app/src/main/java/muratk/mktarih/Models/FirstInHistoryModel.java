package muratk.mktarih.Models;

/**
 * Created by Murat on 23/11/15.
 */
public class FirstInHistoryModel {
    private  String SubjectContent;

    public String getSubjectContent() {
        return SubjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        SubjectContent = subjectContent;
    }

    public FirstInHistoryModel() {
    }

    public FirstInHistoryModel(String subjectContent) {
        SubjectContent = subjectContent;
    }
}
