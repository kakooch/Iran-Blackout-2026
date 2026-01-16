package ir.resaneh1.iptv.model;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class StoryProfileStoryId {
    public String profile_id;
    public Set<String> story_ids = new HashSet();

    public StoryProfileStoryId(String str) {
        this.profile_id = str;
    }
}
