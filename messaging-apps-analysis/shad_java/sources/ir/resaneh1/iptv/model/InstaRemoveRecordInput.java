package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaRemoveRecordInput extends InstaInput {
    public ModelEnum model;
    public String post_id;
    public String record_id;

    public enum ModelEnum {
        Post,
        Comment,
        Profile
    }

    public InstaRemoveRecordInput(String str) {
        this.record_id = str;
    }

    public static InstaRemoveRecordInput setInputForComment(String str, String str2) {
        InstaRemoveRecordInput instaRemoveRecordInput = new InstaRemoveRecordInput(str);
        instaRemoveRecordInput.post_id = str2;
        instaRemoveRecordInput.model = ModelEnum.Comment;
        return instaRemoveRecordInput;
    }

    public static InstaRemoveRecordInput setInputForProfile(String str) {
        InstaRemoveRecordInput instaRemoveRecordInput = new InstaRemoveRecordInput(str);
        instaRemoveRecordInput.model = ModelEnum.Profile;
        return instaRemoveRecordInput;
    }

    public static InstaRemoveRecordInput setInputForPost(String str) {
        InstaRemoveRecordInput instaRemoveRecordInput = new InstaRemoveRecordInput(str);
        instaRemoveRecordInput.model = ModelEnum.Post;
        return instaRemoveRecordInput;
    }
}
