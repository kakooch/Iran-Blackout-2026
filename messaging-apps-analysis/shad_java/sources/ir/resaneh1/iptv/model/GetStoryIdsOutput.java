package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.ChatType;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
public class GetStoryIdsOutput {
    public boolean can_reply;
    public String chat_object_guid;
    public ChatType chat_object_type;
    public Set<String> seen_story_ids;
    public ArrayList<String> story_ids;
}
