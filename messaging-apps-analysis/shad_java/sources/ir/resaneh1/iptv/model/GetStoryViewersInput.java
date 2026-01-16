package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetStoryViewersInput {
    public int limit;
    public String profile_id;
    public String start_id;
    public String story_id;

    public GetStoryViewersInput(String str, String str2, String str3, int i) {
        this.profile_id = str;
        this.story_id = str2;
        this.start_id = str3;
        this.limit = i;
    }
}
