package ir.resaneh1.iptv.model;

import java.util.Set;

/* loaded from: classes3.dex */
public class AddViewStoryInput {
    public String profile_id;
    public Set<String> story_ids;
    public String story_profile_id;

    public AddViewStoryInput(String str, Set<String> set, String str2) {
        this.profile_id = str;
        this.story_ids = set;
        this.story_profile_id = str2;
    }
}
