package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaRequestFollowInput extends InstaInput {
    public TypeEnum f_type;
    public String followee_id;

    public enum TypeEnum {
        Follow,
        Unfollow
    }

    public InstaRequestFollowInput(String str) {
        this.followee_id = str;
    }
}
