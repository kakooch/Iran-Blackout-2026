package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.StoryObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AddStoryInput {
    public long duration;
    public String file_id;
    public String hash_file_receive;
    public int height;
    public String profile_id;
    public int rnd;
    public String snapshot_file_id;
    public String snapshot_hash_file_receive;
    public StoryObject.StoryTypeEnum story_type;
    public String thumbnail_file_id;
    public String thumbnail_hash_file_receive;
    public ArrayList<WidgetStoryObject> widget_story_list;
    public int width;

    public static AddStoryInput createFromStory(StoryObject storyObject) {
        AddStoryInput addStoryInput = new AddStoryInput();
        addStoryInput.rnd = storyObject.rnd;
        addStoryInput.width = DimensionHelper.getStoryWidth();
        addStoryInput.height = DimensionHelper.getStoryHeight();
        addStoryInput.snapshot_file_id = storyObject.snapshotFileId;
        addStoryInput.snapshot_hash_file_receive = storyObject.snapshotHashFileReceive;
        addStoryInput.file_id = storyObject.fileId;
        addStoryInput.hash_file_receive = storyObject.hashFileReceive;
        addStoryInput.thumbnail_file_id = storyObject.thuFileId;
        addStoryInput.thumbnail_hash_file_receive = storyObject.thuHashFileReceive;
        StoryObject.StoryTypeEnum storyTypeEnum = storyObject.story_type;
        addStoryInput.duration = storyTypeEnum == StoryObject.StoryTypeEnum.Video ? storyObject.duration : 0L;
        addStoryInput.story_type = storyTypeEnum;
        addStoryInput.profile_id = storyObject.localProfileId;
        addStoryInput.widget_story_list = storyObject.widget_story_list;
        return addStoryInput;
    }
}
