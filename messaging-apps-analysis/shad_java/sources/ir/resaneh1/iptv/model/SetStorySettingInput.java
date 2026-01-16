package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.InstaProfileSettingObject;
import java.util.Set;

/* loaded from: classes3.dex */
public class SetStorySettingInput {
    public String profile_id;
    public StoryAllowReplyEnum story_allow_reply;
    public boolean story_save_to_archive;
    public boolean story_save_to_gallery;
    public Set<InstaProfileSettingObject.UpdatedParameterEnum> updated_parameters;

    public enum StoryAllowReplyEnum {
        AllFollowers,
        FollowersFollowBack,
        Off
    }
}
