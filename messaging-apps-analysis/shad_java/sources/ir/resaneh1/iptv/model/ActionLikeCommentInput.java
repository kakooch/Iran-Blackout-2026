package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class ActionLikeCommentInput {
    public String cat_id;
    public String comment_id;
    public String object_id;
    public LikeStateEnum state;

    public enum LikeStateEnum {
        Like,
        Dislike,
        NoLike
    }
}
