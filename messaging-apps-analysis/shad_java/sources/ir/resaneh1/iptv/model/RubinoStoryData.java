package ir.resaneh1.iptv.model;

import ir.aaap.messengercore.model.ChatType;

/* loaded from: classes3.dex */
public class RubinoStoryData {
    public boolean is_error;
    public RubinoProfileObject profileObject;
    public String reply_text;
    public StoryObject storyObject;
    public String story_id;
    public String story_profile_id;
    public ChatType toType;
    public Type type;

    public enum Type {
        Direct,
        Reply
    }
}
