package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetProfilesStoriesInput {
    public int limit;
    public String profile_id;
    public String start_id;

    public GetProfilesStoriesInput(String str, int i, String str2) {
        this.profile_id = str;
        this.limit = i;
        this.start_id = str2;
    }
}
