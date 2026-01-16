package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class InstaGetListInput extends InstaInput {
    public String comment_id;
    public String content;
    public boolean equal;
    public TypeEnum f_type;
    public String max_id;
    public String min_id;
    public String post_id;
    public String post_profile_id;
    public String start_id;
    public String target_profile_id;
    public String topic_id;
    public String user_id;
    public String username;
    public int limit = 10;
    public SortEnum sort = SortEnum.FromMax;

    public enum SortEnum {
        FromMin,
        FromMax
    }

    public enum TypeEnum {
        Follower,
        Following
    }
}
