package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.SetStorySettingInput;

/* loaded from: classes3.dex */
public class InstaProfileSettingObject {
    public SetStorySettingInput.StoryAllowReplyEnum story_allow_reply;
    public boolean story_save_to_archive;
    public boolean story_save_to_gallery;

    public enum UpdatedParameterEnum {
        story_allow_reply,
        story_save_to_gallery,
        story_save_to_archive
    }
}
