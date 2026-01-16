package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaReportInput extends InstaInput {
    public RecordModel model;
    public String post_id;
    public String post_profile_id;
    public int reason;
    public String record_id;
    public String story_profile_id;

    public enum RecordModel {
        Post,
        Comment,
        Profile,
        Live,
        Story
    }

    public static InstaReportInput setForStory(String str, String str2) {
        InstaReportInput instaReportInput = new InstaReportInput();
        instaReportInput.model = RecordModel.Story;
        instaReportInput.record_id = str;
        instaReportInput.story_profile_id = str2;
        return instaReportInput;
    }

    public InstaReportInput(String str, String str2, int i, boolean z) {
        this.reason = 0;
        this.record_id = str;
        this.post_id = str2;
        this.reason = i;
        this.model = RecordModel.Comment;
    }

    public InstaReportInput(String str, String str2, int i) {
        this.reason = 0;
        this.record_id = str;
        this.post_profile_id = str2;
        this.reason = i;
        this.model = RecordModel.Post;
    }

    public InstaReportInput(String str, int i, boolean z) {
        this.reason = 0;
        this.record_id = str;
        this.reason = i;
        this.model = RecordModel.Profile;
    }

    public InstaReportInput() {
        this.reason = 0;
    }

    public void setForPost(String str, String str2, int i) {
        this.record_id = str;
        this.post_profile_id = str2;
        this.reason = i;
        this.model = RecordModel.Post;
    }

    public void setForComment(String str, String str2, int i) {
        this.record_id = str;
        this.post_id = str2;
        this.reason = i;
        this.model = RecordModel.Comment;
    }
}
