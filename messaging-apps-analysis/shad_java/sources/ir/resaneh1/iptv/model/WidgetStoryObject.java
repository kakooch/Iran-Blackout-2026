package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.StoryPostObject;

/* loaded from: classes3.dex */
public class WidgetStoryObject {
    public EmojiSliderObject emoji_slider;
    public HashtagStoryObject hashtag;
    public MentionStoryObject mention;
    public StoryPollObject poll;
    public StoryPositionObject position;
    public transient RubinoPostObject rubinoPostObject;
    public transient StoryShareQuestionObject shareQuestionObject;
    public StoryLinkObject story_link;
    public StoryPostObject story_post;
    public WidgetTypeEnum type;

    public enum StateEnum {
        Open,
        Closed
    }

    public enum WidgetTypeEnum {
        Mention,
        Hashtag,
        Location,
        Poll,
        EmojiSlider,
        Post,
        QuestionTest,
        Link
    }

    public WidgetStoryObject() {
    }

    public WidgetStoryObject(RubinoPostObject rubinoPostObject, StoryPositionObject storyPositionObject) {
        StoryPostObject storyPostObject = new StoryPostObject();
        this.story_post = storyPostObject;
        Rubino.PostObjectFromServer postObjectFromServer = rubinoPostObject.post;
        storyPostObject.post_id = postObjectFromServer.id;
        storyPostObject.post_type = postObjectFromServer.is_multi_file ? StoryPostObject.TypeEnum.Multi : StoryPostObject.TypeEnum.Single;
        storyPostObject.duration = postObjectFromServer.duration;
        storyPostObject.post_profile_id = postObjectFromServer.profile_id;
        this.position = storyPositionObject;
        this.type = WidgetTypeEnum.Post;
    }

    public WidgetStoryObject(StoryPollObject storyPollObject, StoryPositionObject storyPositionObject) {
        this.poll = storyPollObject;
        this.position = storyPositionObject;
        this.type = WidgetTypeEnum.Poll;
    }

    public WidgetStoryObject(StoryLinkObject storyLinkObject, StoryPositionObject storyPositionObject) {
        this.story_link = storyLinkObject;
        this.position = storyPositionObject;
        this.type = WidgetTypeEnum.Link;
    }

    public WidgetStoryObject(HashtagStoryObject hashtagStoryObject, StoryPositionObject storyPositionObject) {
        this.hashtag = hashtagStoryObject;
        this.position = storyPositionObject;
        this.type = WidgetTypeEnum.Hashtag;
    }

    public WidgetStoryObject(MentionStoryObject mentionStoryObject, StoryPositionObject storyPositionObject) {
        this.position = storyPositionObject;
        this.mention = mentionStoryObject;
        this.type = WidgetTypeEnum.Mention;
    }

    public WidgetStoryObject(EmojiSliderObject emojiSliderObject, StoryPositionObject storyPositionObject) {
        this.position = storyPositionObject;
        this.emoji_slider = emojiSliderObject;
        this.type = WidgetTypeEnum.EmojiSlider;
    }
}
