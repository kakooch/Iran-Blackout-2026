package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.story.DateSticker;
import ir.resaneh1.iptv.story.QuestionSticker;
import ir.resaneh1.iptv.story.poll.PollSticker;
import ir.resaneh1.iptv.story.quiz.QuizSticker;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class StoryEntityItem extends PresenterItem {
    public RubinoClockObject clockObject;
    public RubinoDateObject dateObject;
    public RubinoEmojiObject emojiObject;
    public EmojiSliderObject emojiSliderObject;
    public RubinoHashTagObject hashTagObject;
    public boolean isSupportVideo;
    public StoryTextAttributeObject linkTextAttribute;
    public float maxWidthInArray;
    public RubinoMentionObject mentionObject;
    public StoryPollObject pollObject;
    public RubinoPostObject postObject;
    public StoryQuestionObject questionObject;
    public StoryQuizObject quizObject;
    public StoryShareQuestionObject shareQuestionObject;
    public RubinoStickerObject stickerObject;
    public StoryEntityTypeEnum storyEntityType;
    public StoryLinkObject storyLinkObject;

    public enum StoryEntityTypeEnum {
        mention,
        hashtag,
        sticker,
        emoji,
        hashtagPreview,
        mentionPreview,
        clock,
        clockPreview,
        pollPreview,
        poll,
        emojiSliderPreview,
        linkPreview,
        link,
        emojiSlider,
        pollShare,
        datePreview,
        date,
        post,
        questionPreview,
        question,
        questionShare,
        quizPreview,
        quiz
    }

    public StoryTextAttributeObject getTextAttributeObject() {
        StoryEntityTypeEnum storyEntityTypeEnum = this.storyEntityType;
        if (storyEntityTypeEnum == StoryEntityTypeEnum.hashtag || storyEntityTypeEnum == StoryEntityTypeEnum.hashtagPreview) {
            return this.hashTagObject.textAttributeObject;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.mention || storyEntityTypeEnum == StoryEntityTypeEnum.mentionPreview) {
            return this.mentionObject.textAttributeObject;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.link || storyEntityTypeEnum == StoryEntityTypeEnum.linkPreview) {
            return this.linkTextAttribute;
        }
        return null;
    }

    public int getSizeDp() {
        StoryEntityTypeEnum storyEntityTypeEnum = this.storyEntityType;
        if (storyEntityTypeEnum == StoryEntityTypeEnum.emoji) {
            return 48;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.clockPreview || storyEntityTypeEnum == StoryEntityTypeEnum.clock) {
            return this.clockObject.sizeInDp;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.datePreview || storyEntityTypeEnum == StoryEntityTypeEnum.date) {
            return this.dateObject.sizeInDp;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.sticker) {
            return 56;
        }
        if (storyEntityTypeEnum == StoryEntityTypeEnum.pollPreview || storyEntityTypeEnum == StoryEntityTypeEnum.linkPreview || storyEntityTypeEnum == StoryEntityTypeEnum.questionPreview || storyEntityTypeEnum == StoryEntityTypeEnum.emojiSliderPreview) {
            return 80;
        }
        return (storyEntityTypeEnum == StoryEntityTypeEnum.hashtagPreview || storyEntityTypeEnum == StoryEntityTypeEnum.mentionPreview) ? 88 : 0;
    }

    public float getWidthPxInArray() {
        float f = this.maxWidthInArray;
        return f > 0.0f ? f : AndroidUtilities.dp(getSizeDp());
    }

    public float getPreviewPaddingPercentage() {
        StoryEntityTypeEnum storyEntityTypeEnum = this.storyEntityType;
        return (storyEntityTypeEnum == StoryEntityTypeEnum.emoji || storyEntityTypeEnum == StoryEntityTypeEnum.pollPreview) ? 0.1f : 0.0f;
    }

    public float getPreviewRealWidth() {
        int iDp;
        StoryEntityTypeEnum storyEntityTypeEnum = this.storyEntityType;
        if (storyEntityTypeEnum == StoryEntityTypeEnum.pollPreview) {
            iDp = PollSticker.getPollWidth(PollSticker.PollStickerMode.PREVIEW);
        } else if (storyEntityTypeEnum == StoryEntityTypeEnum.clockPreview) {
            iDp = AndroidUtilities.dp(207.0f);
        } else if (storyEntityTypeEnum == StoryEntityTypeEnum.datePreview) {
            iDp = DateSticker.getViewWidth();
        } else if (storyEntityTypeEnum == StoryEntityTypeEnum.questionPreview) {
            iDp = QuestionSticker.getViewWidth();
        } else if (storyEntityTypeEnum == StoryEntityTypeEnum.quizPreview) {
            iDp = QuizSticker.getQuizStickerWidth();
        } else {
            iDp = AndroidUtilities.dp(getSizeDp());
        }
        return iDp;
    }
}
