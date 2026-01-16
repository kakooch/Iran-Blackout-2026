package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaAddCommentInput extends InstaInput {
    public String comment_id;
    public String content;
    public String post_id;
    public String post_profile_id;
    public int rnd;

    public InstaAddCommentInput(String str, String str2, String str3, boolean z) {
        this.post_id = str;
        this.content = str2;
        this.post_profile_id = str3;
    }

    public InstaAddCommentInput(String str, String str2, String str3) {
        this.post_id = str;
        this.content = str2;
        this.comment_id = str3;
    }
}
