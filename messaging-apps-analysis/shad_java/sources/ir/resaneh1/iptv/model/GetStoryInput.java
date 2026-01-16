package ir.resaneh1.iptv.model;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetStoryInput {
    public String profile_id;
    public ArrayList<String> story_ids;
    public String story_profile_id;

    public GetStoryInput(ArrayList<String> arrayList, String str, String str2) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.story_ids = arrayList2;
        if (arrayList != null) {
            arrayList2.addAll(arrayList);
        }
        this.story_profile_id = str;
        this.profile_id = str2;
    }
}
