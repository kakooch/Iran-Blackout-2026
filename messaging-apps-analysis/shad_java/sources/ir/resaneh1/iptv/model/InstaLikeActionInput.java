package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaLikeActionInput extends InstaInput {
    public ActionTypeEnum action_type;
    public String comment_id;
    public String post_id;
    public String post_profile_id;

    public enum ActionTypeEnum {
        Like,
        Unlike
    }

    public InstaLikeActionInput(String str, String str2, boolean z) {
        this.comment_id = str;
        this.post_id = str2;
    }

    public InstaLikeActionInput(String str, String str2) {
        this.post_profile_id = str;
        this.post_id = str2;
    }
}
