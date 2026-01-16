package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class MentionStoryObject {
    public String full_thumbnail_url;
    public String name;
    public String profile_id;
    public String username;

    public MentionStoryObject(String str) {
        this.username = str;
    }

    public String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        String str2 = this.username;
        return str2 != null ? str2 : BuildConfig.FLAVOR;
    }
}
