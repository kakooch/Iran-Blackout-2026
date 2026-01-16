package ir.resaneh1.iptv.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.PostInStoryCell;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ColorObject;
import ir.resaneh1.iptv.model.EmojiSliderObject;
import ir.resaneh1.iptv.model.RubinoClockObject;
import ir.resaneh1.iptv.model.RubinoDateObject;
import ir.resaneh1.iptv.model.StoryEntityItem;
import ir.resaneh1.iptv.model.StoryPollObject;
import ir.resaneh1.iptv.model.StoryQuestionObject;
import ir.resaneh1.iptv.model.StoryQuizObject;
import ir.resaneh1.iptv.model.StoryShareQuestionObject;
import ir.resaneh1.iptv.model.StoryTextAttributeObject;
import ir.resaneh1.iptv.story.ClockSticker;
import ir.resaneh1.iptv.story.DateSticker;
import ir.resaneh1.iptv.story.ExtraView;
import ir.resaneh1.iptv.story.QuestionSticker;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar;
import ir.resaneh1.iptv.story.emojiSlider.EmojiSticker;
import ir.resaneh1.iptv.story.poll.PollSticker;
import ir.resaneh1.iptv.story.poll.PollView;
import ir.resaneh1.iptv.story.quiz.QuizPreview;
import ir.resaneh1.iptv.story.quiz.QuizSticker;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StoryEntityView extends FrameLayout {
    public ClockSticker clockSticker;
    public ClockSticker clockStickerPreview;
    int currentAccount;
    public DateSticker dateSticker;
    public DateSticker dateStickerPreview;
    public boolean downAnimationEndAndSmallest;
    public ExtraView emojiExtraView;
    public EmojiSticker emojiSticker;
    public EmojiSticker emojiStickerPreview;
    public StoryEntityItem entityItem;
    private ImageView imageView;
    public boolean isClicked;
    public boolean isDeletable;
    public boolean isLastAnimationDown;
    public boolean isLock;
    public FrameLayout.LayoutParams lastLayoutParams;
    public boolean needToAnimateBack;
    public boolean needToAnimateBackAtEnd;
    private boolean needToSetBackground;
    private boolean needToSetTextPaint;
    public int offsetX;
    public int offsetY;
    private boolean pivotSet;
    public float pivotXBeforeAnimation;
    public float pivotYBeforeAnimation;
    public PollSticker pollPreview;
    public PollSticker pollShare;
    public PollSticker pollSticker;
    public int positionX;
    public int positionY;
    public PostInStoryCell postCell;
    public QuestionSticker questionPreview;
    public QuestionSticker questionShare;
    public QuestionSticker questionSticker;
    public QuizPreview quizPreview;
    public QuizSticker quizSticker;
    public float rotation;
    public float scaleAfterAnimation;
    public float scaleBeforeAnimation;
    public float scaleFactor;
    public StoryTextAttributeObject textAttributeObject;
    private TextView textView;
    public TypeEnum type;

    public enum TypeEnum {
        storyContainer,
        text,
        sticker,
        hashtag,
        mention,
        emoji,
        clock,
        clockPreview,
        poll,
        pollPreview,
        emojiSlider,
        emojiSliderPreview,
        pollShare,
        datePreview,
        date,
        post,
        questionPreview,
        question,
        questionShare,
        quizPreview,
        quiz,
        link
    }

    public static float getReverseRotationAngle(float f) {
        float f2;
        float f3 = f % 360.0f;
        if (f3 >= 0.0f && f3 <= 90.0f) {
            return -f3;
        }
        if (f3 > 90.0f && f3 < 180.0f) {
            return 180.0f - f3;
        }
        if (f3 >= 180.0f && f3 < 270.0f) {
            f2 = f3 - 180.0f;
        } else {
            if (f3 >= 270.0f && f3 <= 360.0f) {
                return 360.0f - f3;
            }
            if (f3 < 0.0f && f3 >= -90.0f) {
                return -f3;
            }
            if ((f3 < -90.0f && f3 >= -180.0f) || (f3 < -180.0f && f3 >= -270.0f)) {
                f2 = f3 + 180.0f;
            } else {
                if (f3 >= -270.0f || f3 < -360.0f) {
                    return f3;
                }
                f2 = f3 + 360.0f;
            }
        }
        return -f2;
    }

    public static class EntityViewAttr {
        public int positionX;
        public int positionY;
        public float rotation;
        public float scaleFactor;

        public EntityViewAttr(int i, int i2, float f, float f2) {
            this.scaleFactor = 1.0f;
            this.rotation = 0.0f;
            this.positionX = i;
            this.positionY = i2;
            this.scaleFactor = f;
            this.rotation = f2;
        }
    }

    public EntityViewAttr getAttr() {
        saveCurrentPosition((int) getX(), (int) getY());
        saveCurrentScaleAndRotation();
        updatePosition();
        return new EntityViewAttr(this.positionX, this.positionY, this.scaleFactor, this.rotation);
    }

    public void setByAttr(EntityViewAttr entityViewAttr) {
        this.scaleFactor = 1.0f;
        this.rotation = 0.0f;
        this.offsetX = 0;
        this.offsetY = 0;
        setScaleX(entityViewAttr.scaleFactor);
        setScaleY(entityViewAttr.scaleFactor);
        setX(entityViewAttr.positionX);
        setY(entityViewAttr.positionY);
        setRotation(entityViewAttr.rotation);
        saveCurrentPosition((int) getX(), (int) getY());
        saveCurrentScaleAndRotation();
        invalidate();
    }

    public StoryEntityView(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.scaleFactor = 1.0f;
        this.rotation = 0.0f;
        this.isDeletable = true;
        setWillNotDraw(false);
        setClipToPadding(false);
        setClipChildren(false);
    }

    public void setOrEditEntityItem(StoryEntityItem storyEntityItem) {
        if (storyEntityItem == null) {
            this.entityItem = null;
            this.isDeletable = true;
            return;
        }
        this.entityItem = storyEntityItem;
        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum = storyEntityItem.storyEntityType;
        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum2 = StoryEntityItem.StoryEntityTypeEnum.post;
        this.isDeletable = storyEntityTypeEnum != storyEntityTypeEnum2;
        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum3 = StoryEntityItem.StoryEntityTypeEnum.hashtag;
        if (storyEntityTypeEnum == storyEntityTypeEnum3 || storyEntityTypeEnum == StoryEntityItem.StoryEntityTypeEnum.mention) {
            addOrEditHashtagOrMention(storyEntityItem.getTextAttributeObject(), this.entityItem.storyEntityType == storyEntityTypeEnum3);
        }
        StoryEntityItem storyEntityItem2 = this.entityItem;
        if (storyEntityItem2.storyEntityType == StoryEntityItem.StoryEntityTypeEnum.linkPreview) {
            addOrEditLinkPreview(storyEntityItem2.getTextAttributeObject(), this.entityItem.getWidthPxInArray());
        }
        StoryEntityItem storyEntityItem3 = this.entityItem;
        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum4 = storyEntityItem3.storyEntityType;
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.link) {
            addOrEditLink(storyEntityItem3.getTextAttributeObject());
            return;
        }
        StoryEntityItem.StoryEntityTypeEnum storyEntityTypeEnum5 = StoryEntityItem.StoryEntityTypeEnum.hashtagPreview;
        if (storyEntityTypeEnum4 == storyEntityTypeEnum5 || storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.mentionPreview) {
            StoryTextAttributeObject textAttributeObject = storyEntityItem3.getTextAttributeObject();
            StoryEntityItem storyEntityItem4 = this.entityItem;
            addOrEditHashtagOrMentionPreview(textAttributeObject, storyEntityItem4.storyEntityType == storyEntityTypeEnum5, storyEntityItem4.getWidthPxInArray());
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.sticker) {
            addImage(storyEntityItem3.stickerObject.imageUrl, (int) storyEntityItem3.getWidthPxInArray());
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.emoji) {
            addOrEditEmoji(storyEntityItem3.emojiObject.emojiCharacter, (int) storyEntityItem3.getWidthPxInArray());
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.clock) {
            addClock(storyEntityItem3.clockObject, storyEntityItem3.getSizeDp());
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.clockPreview) {
            addClockPreview(storyEntityItem3.clockObject);
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.pollPreview) {
            addPollPreview();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.pollShare) {
            addPollShare();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.poll) {
            addPoll();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.emojiSliderPreview) {
            addEmojiSliderPreview(storyEntityItem3.getSizeDp());
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.emojiSlider) {
            addEmojiSlider();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.datePreview) {
            addDatePreview();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.date) {
            addDate();
            return;
        }
        if (storyEntityTypeEnum4 == storyEntityTypeEnum2) {
            addPost(storyEntityItem3.isSupportVideo);
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.quizPreview) {
            addQuizPreview();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.quiz) {
            addQuiz();
            return;
        }
        if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.questionPreview) {
            addQuestionPreview();
        } else if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.question) {
            addQuestion();
        } else if (storyEntityTypeEnum4 == StoryEntityItem.StoryEntityTypeEnum.questionShare) {
            addQuestionShare();
        }
    }

    public void addOrEditText(final StoryTextAttributeObject storyTextAttributeObject, int i, int i2) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.text;
        this.textAttributeObject = storyTextAttributeObject;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(0.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(0.0f));
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23) {
                this.textView.setHyphenationFrequency(0);
                if (i3 >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StoryEntityView.this.needToSetBackground) {
                        StoryEntityView.this.needToSetBackground = false;
                        storyTextAttributeObject.layout = StoryEntityView.this.textView.getLayout();
                        if (storyTextAttributeObject.getBackground(StoryEntityView.this.textView.getLayout()) != null) {
                            TextView textView2 = StoryEntityView.this.textView;
                            StoryTextAttributeObject storyTextAttributeObject2 = storyTextAttributeObject;
                            textView2.setBackground(storyTextAttributeObject2.getBackground(storyTextAttributeObject2.layout));
                            return;
                        }
                        StoryEntityView.this.textView.setBackgroundColor(0);
                    }
                }
            });
        }
        this.textView.setTextSize(1, storyTextAttributeObject.textSizeInDp);
        this.textView.setText(storyTextAttributeObject.spannableString);
        this.textView.setTextColor(storyTextAttributeObject.getTextColor());
        this.textView.setLinkTextColor(storyTextAttributeObject.getTextColor());
        this.textView.setGravity(StoryTextAttributeObject.getGravity(storyTextAttributeObject));
        this.textView.setShadowLayer(storyTextAttributeObject.getShadowRadius(), storyTextAttributeObject.getShadowDx(), storyTextAttributeObject.getShadowDy(), storyTextAttributeObject.getShadowColor());
        this.textView.setTypeface(storyTextAttributeObject.getTypeFace());
        this.needToSetBackground = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.textView.setMaxWidth(i);
        layoutParams.gravity = 1;
        removeAllViews();
        addView(this.textView, layoutParams);
        requestLayout();
    }

    public void addOrEditEmoji(String str, int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.emoji;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                textView.setHyphenationFrequency(0);
                if (i2 >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.setTextSize(0, (i * 1.0f) / 1.5f);
            this.textView.setTextColor(-1);
            this.textView.setGravity(17);
            this.textView.setBackgroundColor(0);
        }
        this.textView.setText(Emoji.replaceEmoji(str.trim(), this.textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
        this.needToSetBackground = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        removeAllViews();
        addView(this.textView, layoutParams);
        requestLayout();
    }

    public void addOrEditLinkPreview(final StoryTextAttributeObject storyTextAttributeObject, final float f) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.link;
        this.textAttributeObject = storyTextAttributeObject;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            textView.setSingleLine(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AndroidUtilities.dp(this.entityItem.getSizeDp() + 4), -2);
            layoutParams.gravity = 17;
            removeAllViews();
            addView(this.textView, layoutParams);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                this.textView.setHyphenationFrequency(0);
                if (i >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StoryEntityView.this.needToSetTextPaint) {
                        StoryEntityView.this.needToSetTextPaint = false;
                        float width = StoryEntityView.this.textView.getWidth() * StoryEntityView.this.textView.getScaleX();
                        float f2 = f;
                        if (width > f2 && f2 > 0.0f) {
                            float width2 = f2 / (StoryEntityView.this.textView.getWidth() * StoryEntityView.this.textView.getScaleX());
                            StoryEntityView.this.textView.setScaleX(width2);
                            StoryEntityView.this.textView.setScaleY(width2);
                        }
                        if (StoryEntityView.this.textView.getLayout() == null || StoryEntityView.this.textView.getLayout().getLineCount() <= 0) {
                            StoryEntityView.this.textView.getPaint().setShader(null);
                            StoryEntityView.this.textView.setTextColor(-1);
                        } else {
                            StoryTextAttributeObject storyTextAttributeObject2 = storyTextAttributeObject;
                            Shader textPaintShader = storyTextAttributeObject2.getTextPaintShader(storyTextAttributeObject2.textColorType, StoryEntityView.this.textView.getLayout().getLineLeft(0) + AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineTop(0) + AndroidUtilities.dp(2.0f), StoryEntityView.this.textView.getLayout().getLineRight(0) - AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineBottom(0) - AndroidUtilities.dp(2.0f));
                            if (textPaintShader == null) {
                                StoryEntityView.this.textView.getPaint().setShader(null);
                                StoryEntityView.this.textView.setTextColor(-1);
                            } else {
                                StoryEntityView.this.textView.getPaint().setShader(textPaintShader);
                            }
                        }
                        StoryEntityView.this.textView.invalidate();
                    }
                }
            });
        }
        this.textView.setTextSize(1, storyTextAttributeObject.textSizeInDp);
        this.textView.setGravity(StoryTextAttributeObject.getGravity(storyTextAttributeObject));
        this.textView.setBackground(storyTextAttributeObject.getHashtagBackground());
        this.textView.setTypeface(storyTextAttributeObject.getTypeFace());
        this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f));
        SpannableString spannableString = new SpannableString(LocaleController.getString(R.string.rubinoStoryLinkSymbol) + this.entityItem.storyLinkObject.text);
        storyTextAttributeObject.spannableString = spannableString;
        SpanHelper.makeBoldAndRelativeSize(spannableString, 0, LocaleController.getString(R.string.rubinoStoryLinkSymbol).length(), 0.8f);
        this.textView.setText(storyTextAttributeObject.spannableString);
        this.textView.setTextColor(-1);
        this.needToSetTextPaint = true;
        requestLayout();
    }

    public void addOrEditLink(final StoryTextAttributeObject storyTextAttributeObject) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.link;
        this.textAttributeObject = storyTextAttributeObject;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            textView.setSingleLine(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            removeAllViews();
            addView(this.textView, layoutParams);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                this.textView.setHyphenationFrequency(0);
                if (i >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StoryEntityView.this.needToSetTextPaint) {
                        StoryEntityView.this.needToSetTextPaint = false;
                        if (StoryEntityView.this.textView.getLayout() == null || StoryEntityView.this.textView.getLayout().getLineCount() <= 0) {
                            StoryEntityView.this.textView.getPaint().setShader(null);
                            StoryEntityView.this.textView.setTextColor(-1);
                        } else {
                            StoryTextAttributeObject storyTextAttributeObject2 = storyTextAttributeObject;
                            Shader textPaintShader = storyTextAttributeObject2.getTextPaintShader(storyTextAttributeObject2.textColorType, StoryEntityView.this.textView.getLayout().getLineLeft(0) + AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineTop(0) + AndroidUtilities.dp(2.0f), StoryEntityView.this.textView.getLayout().getLineRight(0) - AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineBottom(0) - AndroidUtilities.dp(2.0f));
                            if (textPaintShader == null) {
                                StoryEntityView.this.textView.getPaint().setShader(null);
                                if (storyTextAttributeObject.textColorType == StoryTextAttributeObject.TextColorTypeEnum.simple) {
                                    StoryEntityView.this.textView.setTextColor(-16777216);
                                } else {
                                    StoryEntityView.this.textView.setTextColor(-1);
                                }
                            } else {
                                StoryEntityView.this.textView.getPaint().setShader(textPaintShader);
                            }
                        }
                        StoryEntityView.this.textView.invalidate();
                    }
                }
            });
        }
        this.textView.setTextSize(1, storyTextAttributeObject.textSizeInDp);
        this.textView.setGravity(StoryTextAttributeObject.getGravity(storyTextAttributeObject));
        this.textView.setBackground(storyTextAttributeObject.getHashtagBackground());
        this.textView.setTypeface(storyTextAttributeObject.getTypeFace());
        this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f));
        SpannableString spannableString = new SpannableString(LocaleController.getString(R.string.rubinoStoryLinkSymbol) + this.entityItem.storyLinkObject.text);
        storyTextAttributeObject.spannableString = spannableString;
        SpanHelper.makeBoldAndRelativeSize(spannableString, 0, LocaleController.getString(R.string.rubinoStoryLinkSymbol).length(), 0.8f);
        this.textView.setText(storyTextAttributeObject.spannableString);
        this.textView.setTextColor(-1);
        this.needToSetTextPaint = true;
        requestLayout();
    }

    public void addOrEditHashtagOrMentionPreview(final StoryTextAttributeObject storyTextAttributeObject, boolean z, final float f) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        if (z) {
            this.type = TypeEnum.hashtag;
        } else {
            this.type = TypeEnum.mention;
        }
        this.textAttributeObject = storyTextAttributeObject;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            textView.setSingleLine(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AndroidUtilities.dp(this.entityItem.getSizeDp() + 4), -2);
            layoutParams.gravity = 17;
            removeAllViews();
            addView(this.textView, layoutParams);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                this.textView.setHyphenationFrequency(0);
                if (i >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StoryEntityView.this.needToSetTextPaint) {
                        StoryEntityView.this.needToSetTextPaint = false;
                        float width = StoryEntityView.this.textView.getWidth() * StoryEntityView.this.textView.getScaleX();
                        float f2 = f;
                        if (width > f2 && f2 > 0.0f) {
                            float width2 = f2 / (StoryEntityView.this.textView.getWidth() * StoryEntityView.this.textView.getScaleX());
                            StoryEntityView.this.textView.setScaleX(width2);
                            StoryEntityView.this.textView.setScaleY(width2);
                        }
                        if (StoryEntityView.this.textView.getLayout() == null || StoryEntityView.this.textView.getLayout().getLineCount() <= 0) {
                            StoryEntityView.this.textView.getPaint().setShader(null);
                            StoryEntityView.this.textView.setTextColor(-1);
                        } else {
                            StoryTextAttributeObject storyTextAttributeObject2 = storyTextAttributeObject;
                            Shader textPaintShader = storyTextAttributeObject2.getTextPaintShader(storyTextAttributeObject2.textColorType, StoryEntityView.this.textView.getLayout().getLineLeft(0) + AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineTop(0) + AndroidUtilities.dp(2.0f), StoryEntityView.this.textView.getLayout().getLineRight(0) - AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineBottom(0) - AndroidUtilities.dp(2.0f));
                            if (textPaintShader == null) {
                                StoryEntityView.this.textView.getPaint().setShader(null);
                                StoryEntityView.this.textView.setTextColor(-1);
                            } else {
                                StoryEntityView.this.textView.getPaint().setShader(textPaintShader);
                            }
                        }
                        StoryEntityView.this.textView.invalidate();
                    }
                }
            });
        }
        this.textView.setTextSize(1, storyTextAttributeObject.textSizeInDp);
        this.textView.setGravity(StoryTextAttributeObject.getGravity(storyTextAttributeObject));
        this.textView.setBackground(storyTextAttributeObject.getHashtagBackground());
        this.textView.setTypeface(storyTextAttributeObject.getTypeFace());
        this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(2.0f));
        this.textView.setText(storyTextAttributeObject.spannableString);
        this.textView.setTextColor(-1);
        this.needToSetTextPaint = true;
        requestLayout();
    }

    public void addOrEditHashtagOrMention(final StoryTextAttributeObject storyTextAttributeObject, boolean z) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        if (z) {
            this.type = TypeEnum.hashtag;
        } else {
            this.type = TypeEnum.mention;
        }
        this.textAttributeObject = storyTextAttributeObject;
        if (this.textView == null) {
            TextView textView = new TextView(ApplicationLoader.applicationActivity);
            this.textView = textView;
            textView.setSingleLine(true);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            removeAllViews();
            addView(this.textView, layoutParams);
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                this.textView.setHyphenationFrequency(0);
                if (i >= 29) {
                    this.textView.setBreakStrategy(0);
                }
            }
            this.textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (StoryEntityView.this.needToSetTextPaint) {
                        StoryEntityView.this.needToSetTextPaint = false;
                        if (StoryEntityView.this.textView.getLayout().getLineCount() <= 0) {
                            StoryEntityView.this.textView.getPaint().setShader(null);
                            StoryEntityView.this.textView.setTextColor(-1);
                        } else {
                            StoryTextAttributeObject storyTextAttributeObject2 = storyTextAttributeObject;
                            Shader textPaintShader = storyTextAttributeObject2.getTextPaintShader(storyTextAttributeObject2.textColorType, StoryEntityView.this.textView.getLayout().getLineLeft(0) + AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineTop(0) + AndroidUtilities.dp(2.0f), StoryEntityView.this.textView.getLayout().getLineRight(0) - AndroidUtilities.dp(8.0f), StoryEntityView.this.textView.getLayout().getLineBottom(0) - AndroidUtilities.dp(2.0f));
                            if (textPaintShader == null) {
                                StoryEntityView.this.textView.getPaint().setShader(null);
                                StoryEntityView.this.textView.setTextColor(-1);
                            } else {
                                StoryEntityView.this.textView.getPaint().setShader(textPaintShader);
                            }
                        }
                        StoryEntityView.this.textView.invalidate();
                    }
                }
            });
        }
        this.textView.setTextSize(1, storyTextAttributeObject.textSizeInDp);
        this.textView.setGravity(StoryTextAttributeObject.getGravity(storyTextAttributeObject));
        this.textView.setBackground(storyTextAttributeObject.getHashtagBackground());
        this.textView.setTypeface(storyTextAttributeObject.getTypeFace());
        this.textView.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        this.textView.setText(storyTextAttributeObject.spannableString);
        this.textView.setTextColor(-1);
        this.needToSetTextPaint = true;
        requestLayout();
    }

    public void addClock(RubinoClockObject rubinoClockObject, int i) {
        this.type = TypeEnum.clock;
        if (this.clockSticker == null) {
            float f = 207;
            int iDp = AndroidUtilities.dp(f);
            this.clockSticker = new ClockSticker(getContext(), ClockSticker.ClockMode.TEXTUAL_GRAY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDp, iDp, 17);
            float f2 = ((i * 1.0f) / f) * 1.0f;
            this.clockSticker.setScaleX(f2);
            this.clockSticker.setScaleY(f2);
            addView(this.clockSticker, layoutParams);
        }
        int hour = DateFormatUtils.getHour(rubinoClockObject.date);
        int minute = DateFormatUtils.getMinute(rubinoClockObject.date);
        this.clockSticker.setTexts((hour / 10) + BuildConfig.FLAVOR, (hour % 10) + BuildConfig.FLAVOR, (minute / 10) + BuildConfig.FLAVOR, (minute % 10) + BuildConfig.FLAVOR);
    }

    public void addClockPreview(RubinoClockObject rubinoClockObject) {
        this.type = TypeEnum.clockPreview;
        int previewRealWidth = (int) this.entityItem.getPreviewRealWidth();
        if (this.clockStickerPreview == null) {
            this.clockStickerPreview = new ClockSticker(getContext(), ClockSticker.ClockMode.TEXTUAL_GRAY);
            addView(this.clockStickerPreview, new FrameLayout.LayoutParams(previewRealWidth, previewRealWidth, 17));
        }
        int hour = DateFormatUtils.getHour(rubinoClockObject.date);
        int minute = DateFormatUtils.getMinute(rubinoClockObject.date);
        this.clockStickerPreview.setTexts((hour / 10) + BuildConfig.FLAVOR, (hour % 10) + BuildConfig.FLAVOR, (minute / 10) + BuildConfig.FLAVOR, (minute % 10) + BuildConfig.FLAVOR);
    }

    public void addDate() {
        this.type = TypeEnum.date;
        RubinoDateObject rubinoDateObject = this.entityItem.dateObject;
        if (this.dateSticker == null) {
            int iDp = AndroidUtilities.dp(r0.getSizeDp());
            this.dateSticker = new DateSticker(getContext(), BuildConfig.FLAVOR);
            addView(this.dateSticker, new FrameLayout.LayoutParams(iDp, -2, 17));
        }
        if (rubinoDateObject != null) {
            this.dateSticker.setDateString(LocaleController.formatRubinoStoryDate(rubinoDateObject.date));
            this.dateSticker.setDateTheme(rubinoDateObject.theme);
        }
    }

    public void addDatePreview() {
        this.type = TypeEnum.datePreview;
        StoryEntityItem storyEntityItem = this.entityItem;
        RubinoDateObject rubinoDateObject = storyEntityItem.dateObject;
        int previewRealWidth = (int) storyEntityItem.getPreviewRealWidth();
        if (this.dateStickerPreview == null) {
            this.dateStickerPreview = new DateSticker(getContext(), BuildConfig.FLAVOR);
            addView(this.dateStickerPreview, new FrameLayout.LayoutParams(previewRealWidth, -2, 17));
        }
        if (rubinoDateObject != null) {
            rubinoDateObject.theme = DateSticker.DateTheme.WHITE;
            this.dateStickerPreview.setDateString(LocaleController.formatRubinoStoryDate(rubinoDateObject.date));
            this.dateStickerPreview.setDateTheme(rubinoDateObject.theme);
        }
    }

    public void addImage(String str, int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.sticker;
        if (this.imageView == null) {
            this.imageView = new ImageView(ApplicationLoader.applicationActivity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i - AndroidUtilities.dp(4.0f), i - AndroidUtilities.dp(4.0f));
            layoutParams.gravity = 17;
            addView(this.imageView, layoutParams);
        }
        GlideHelper.loadForStory(ApplicationLoader.applicationActivity, this.imageView, str, R.color.transparent);
    }

    private void addPost(boolean z) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.post;
        if (this.postCell == null) {
            this.postCell = new PostInStoryCell(ApplicationLoader.applicationActivity, z);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.postCell, layoutParams);
        }
        if (this.entityItem.postObject != null) {
            int screenWidth = (DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity) * 4) / 5;
            int i = (int) (screenWidth * this.entityItem.postObject.viewHWRatio);
            this.postCell.linearLayout.getLayoutParams().width = screenWidth;
            this.postCell.imageViewPost.getLayoutParams().width = screenWidth;
            this.postCell.imageViewPost.getLayoutParams().height = i;
            ((FrameLayout.LayoutParams) this.postCell.getLayoutParams()).gravity = 17;
            this.postCell.setPost(this.entityItem.postObject, PostInStoryCell.ModeEnum.details);
        }
    }

    private void addPollPreview() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.pollPreview;
        if (this.pollPreview == null) {
            this.pollPreview = new PollSticker(ApplicationLoader.applicationActivity, PollSticker.PollStickerMode.PREVIEW);
            addView(this.pollPreview, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addQuizPreview() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.quizPreview;
        if (this.quizPreview == null) {
            this.quizPreview = new QuizPreview(ApplicationLoader.applicationActivity);
            addView(this.quizPreview, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addQuestionPreview() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.questionPreview;
        if (this.questionPreview == null) {
            this.questionPreview = new QuestionSticker(ApplicationLoader.applicationActivity, QuestionSticker.QuestionMode.PREVIEW, null);
            addView(this.questionPreview, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addPoll() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.poll;
        if (this.pollSticker == null) {
            this.pollSticker = new PollSticker(ApplicationLoader.applicationActivity, PollSticker.PollStickerMode.ADD_STORY);
            addView(this.pollSticker, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addQuestion() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.question;
        if (this.questionSticker == null) {
            this.questionSticker = new QuestionSticker(ApplicationLoader.applicationActivity, QuestionSticker.QuestionMode.ADD_STORY, null);
            addView(this.questionSticker, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addQuiz() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.quiz;
        if (this.quizSticker == null) {
            this.quizSticker = new QuizSticker(ApplicationLoader.applicationActivity, QuizSticker.QuizMode.ADD_STORY, QuizSticker.QuizTheme.PURPLE_GRADIENT.getThemeModel());
            addView(this.quizSticker, LayoutHelper.createFrame(-2, -2, 17));
            if (Build.VERSION.SDK_INT >= 17) {
                this.quizSticker.setLayoutDirection(0);
            }
        }
    }

    private void setQuestionUserImage(final QuestionSticker questionSticker) {
        if (ApplicationLoader.applicationActivity == null || questionSticker == null) {
            return;
        }
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        requestOptions.placeholder(R.drawable.placeholder_avatar_man);
        String str = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().full_photo_url;
        if (str == null || str.isEmpty()) {
            ImageHelper.drawableToBitmap(ApplicationLoader.applicationActivity, R.drawable.placeholder_avatar_man).isRecycled();
        } else {
            Glide.with((FragmentActivity) ApplicationLoader.applicationActivity).asBitmap().apply((BaseRequestOptions<?>) requestOptions).load(str).into((RequestBuilder<Bitmap>) new SimpleTarget<Bitmap>(this) { // from class: ir.resaneh1.iptv.helper.StoryEntityView.6
                @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable drawable) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (questionSticker != null) {
                        bitmap.isRecycled();
                    }
                }
            });
        }
    }

    private void addPollShare() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.pollShare;
        if (this.pollShare == null) {
            this.pollShare = new PollSticker(ApplicationLoader.applicationActivity, PollSticker.PollStickerMode.SHARE);
            FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2.0f);
            layoutParamsCreateFrame.gravity = 17;
            addView(this.pollShare, layoutParamsCreateFrame);
            StoryPollObject storyPollObject = this.entityItem.pollObject;
            if (storyPollObject.answer_count == 0) {
                this.pollShare.setPollLeftPercentage(50, false, PollView.PollOption.NONE);
            } else {
                this.pollShare.setPollLeftPercentage(storyPollObject.getLeftPercentage(), false, PollView.PollOption.NONE);
            }
            StoryPollObject storyPollObject2 = this.entityItem.pollObject;
            if (storyPollObject2 != null) {
                String str = storyPollObject2.content;
                String str2 = BuildConfig.FLAVOR;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                ArrayList<String> arrayList = storyPollObject2.choices_list;
                String str3 = (arrayList == null || arrayList.size() <= 0) ? BuildConfig.FLAVOR : storyPollObject2.choices_list.get(0);
                ArrayList<String> arrayList2 = storyPollObject2.choices_list;
                if (arrayList2 != null && arrayList2.size() > 1) {
                    str2 = storyPollObject2.choices_list.get(1);
                }
                this.pollShare.setValues(str, str3, str2);
            }
        }
    }

    private void addQuestionShare() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.questionShare;
        if (this.questionShare == null) {
            this.questionShare = new QuestionSticker(ApplicationLoader.applicationActivity, QuestionSticker.QuestionMode.SHARE, null);
            FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2.0f);
            layoutParamsCreateFrame.gravity = 17;
            addView(this.questionShare, layoutParamsCreateFrame);
            StoryShareQuestionObject storyShareQuestionObject = this.entityItem.shareQuestionObject;
            if (storyShareQuestionObject != null) {
                this.questionShare.setTitleText(storyShareQuestionObject.storyQuestionObject.question);
                this.questionShare.setUserResponseText(storyShareQuestionObject.answer);
            }
        }
    }

    private void addEmojiSlider() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.emojiSlider;
        if (this.emojiSticker == null) {
            this.emojiSticker = new EmojiSticker(ApplicationLoader.applicationActivity, EmojiSticker.EmojiMode.ADD_STORY, new EmojiSeekbar.Delegate() { // from class: ir.resaneh1.iptv.helper.StoryEntityView.7
                @Override // ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar.Delegate
                public void onChangedProgress(float f) {
                }

                @Override // ir.resaneh1.iptv.story.emojiSlider.EmojiSeekbar.Delegate
                public Point realValueOfEventPosition(float f, float f2) {
                    return new Point((int) (f + StoryEntityView.this.emojiSticker.getX()), (int) (f2 + StoryEntityView.this.emojiSticker.getY()));
                }
            });
            ExtraView extraView = new ExtraView(ApplicationLoader.applicationActivity);
            this.emojiExtraView = extraView;
            this.emojiSticker.setExtraView(extraView);
            addView(this.emojiSticker, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    private void addEmojiSliderPreview(int i) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.type = TypeEnum.emojiSliderPreview;
        if (this.emojiStickerPreview == null) {
            this.emojiStickerPreview = new EmojiSticker(getContext(), EmojiSticker.EmojiMode.PREVIEW, null);
            float fDp = ((AndroidUtilities.dp(i) * 1.0f) / EmojiSticker.getViewWidth()) * 1.0f;
            this.emojiStickerPreview.setScaleX(fDp);
            this.emojiStickerPreview.setScaleY(fDp);
            addView(this.emojiStickerPreview, LayoutHelper.createFrame(-2, -2, 17));
        }
    }

    public PollSticker getPollStickerViewAndRemoveFromParent() {
        if (this.type != TypeEnum.poll) {
            return null;
        }
        if (this.pollSticker != null) {
            removeAllViews();
        }
        return this.pollSticker;
    }

    public EmojiSticker getEmojiStickerViewAndRemoveFromParent() {
        if (this.type != TypeEnum.emojiSlider) {
            return null;
        }
        EmojiSticker emojiSticker = this.emojiSticker;
        if (emojiSticker != null) {
            removeView(emojiSticker);
        }
        return this.emojiSticker;
    }

    public QuestionSticker getQuestionStickerViewAndRemoveFromParent() {
        if (this.type != TypeEnum.question) {
            return null;
        }
        QuestionSticker questionSticker = this.questionSticker;
        if (questionSticker != null) {
            removeView(questionSticker);
        }
        return this.questionSticker;
    }

    public QuizSticker getQuizStickerViewAndRemoveFromParent() {
        if (this.type != TypeEnum.quiz) {
            return null;
        }
        QuizSticker quizSticker = this.quizSticker;
        if (quizSticker != null) {
            removeView(quizSticker);
        }
        return this.quizSticker;
    }

    public void addPollStickerViewAndSetParameters(PollSticker pollSticker) {
        if (this.type != TypeEnum.poll) {
            return;
        }
        removeAllViews();
        this.pollSticker = pollSticker;
        addView(this.pollSticker, LayoutHelper.createFrame(-2, -2, 17));
        StoryEntityItem storyEntityItem = this.entityItem;
        if (storyEntityItem != null) {
            if (storyEntityItem.pollObject == null) {
                storyEntityItem.pollObject = new StoryPollObject();
            }
            this.entityItem.pollObject.setData(this.pollSticker.getPollTitle(), this.pollSticker.getOptionLeft(), this.pollSticker.getOptionRight());
        }
    }

    public void addEmojiSliderStickerViewAndSetParameters(EmojiSticker emojiSticker) {
        if (this.type == TypeEnum.emojiSlider && emojiSticker != null) {
            removeAllViews();
            this.emojiSticker = emojiSticker;
            addView(emojiSticker, LayoutHelper.createFrame(-2, -2, 17));
            StoryEntityItem storyEntityItem = this.entityItem;
            if (storyEntityItem != null) {
                if (storyEntityItem.emojiSliderObject == null) {
                    storyEntityItem.emojiSliderObject = new EmojiSliderObject();
                }
                this.entityItem.emojiSliderObject.content = emojiSticker.getTitle();
                this.entityItem.emojiSliderObject.emoji_char = emojiSticker.getEmoji();
                EmojiSliderObject.ThemeEmojiSlider themeEmojiSlider = new EmojiSliderObject.ThemeEmojiSlider();
                this.entityItem.emojiSliderObject.theme = themeEmojiSlider;
                themeEmojiSlider.seekbar_type = emojiSticker.isGradient() ? EmojiSliderObject.ThemeEmojiSlider.SeekbarTypeEnum.Gradient : EmojiSliderObject.ThemeEmojiSlider.SeekbarTypeEnum.Simple;
                themeEmojiSlider.seekbar_background_color = ColorObject.getColorObject(emojiSticker.getTheme().getThemeModel().getSeekBarBackgroundColor());
                themeEmojiSlider.seekbar_progress_color = ColorObject.getColorObject(emojiSticker.getTheme().getThemeModel().getSeekBarForegroundColor());
                themeEmojiSlider.text_color = ColorObject.getColorObject(emojiSticker.getTheme().getThemeModel().getTextColor());
                themeEmojiSlider.background_color = ColorObject.getColorObject(emojiSticker.getTheme().getThemeModel().getBackgroundColor());
            }
        }
    }

    public void addQuestionStickerViewAndSetParameters(QuestionSticker questionSticker) {
        if (this.type != TypeEnum.question) {
            return;
        }
        removeAllViews();
        this.questionSticker = questionSticker;
        addView(questionSticker, LayoutHelper.createFrame(-2, -2, 17));
        StoryEntityItem storyEntityItem = this.entityItem;
        if (storyEntityItem != null) {
            if (storyEntityItem.questionObject == null) {
                storyEntityItem.questionObject = new StoryQuestionObject();
            }
            this.entityItem.questionObject.question = questionSticker.getTitleEditText();
            this.entityItem.questionObject.theme = new StoryQuestionObject.ThemeQuestionObject();
        }
    }

    public void addQuizStickerViewAndSetParameters(QuizSticker quizSticker) {
        if (this.type != TypeEnum.quiz) {
            return;
        }
        removeAllViews();
        this.quizSticker = quizSticker;
        addView(quizSticker, LayoutHelper.createFrame(-2, -2, 17));
        StoryEntityItem storyEntityItem = this.entityItem;
        if (storyEntityItem == null || storyEntityItem.quizObject != null) {
            return;
        }
        storyEntityItem.quizObject = new StoryQuizObject();
    }

    public String getText() {
        TextView textView = this.textView;
        return textView == null ? BuildConfig.FLAVOR : textView.getText().toString().trim();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public float getReverseRotationAngle() {
        return getReverseRotationAngle(getRotation());
    }

    public void setOffset(int i, int i2) {
        this.offsetX = i;
        this.offsetY = i2;
        updatePosition();
    }

    public void saveCurrentPosition(int i, int i2) {
        this.positionX = i;
        this.positionY = i2;
    }

    public void saveCurrentScaleAndRotation() {
        this.scaleFactor = getScaleX();
        this.rotation = getRotation();
    }

    public void setRotationAngle(float f) {
        if (this.type == TypeEnum.post && !this.pivotSet) {
            setPivotY(getPostPivotY());
        }
        setRotation(normalizeAngle(f + this.rotation));
    }

    private float normalizeAngle(float f) {
        int i;
        int i2;
        int i3 = (int) f;
        int i4 = i3 % 90;
        MyLog.e("angle", "angle:" + f);
        if (i4 < 0 || i4 >= 4) {
            if (i4 > 86) {
                i = ((i3 / 90) * 90) + 90;
            } else if (i4 < 0 && i4 > -4) {
                i2 = i3 / 90;
            } else {
                if (i4 >= -86) {
                    return f;
                }
                i = ((i3 / 90) * 90) - 90;
            }
            return i;
        }
        i2 = i3 / 90;
        i = i2 * 90;
        return i;
    }

    public void setScale(float f) {
        float fDp;
        int width;
        float screenWidth;
        int width2;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        float f2 = this.scaleFactor * f;
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        TypeEnum typeEnum = this.type;
        if (typeEnum == TypeEnum.poll || typeEnum == TypeEnum.emojiSlider) {
            if (getWidth() * f2 < AndroidUtilities.dp(70.0f)) {
                fDp = AndroidUtilities.dp(70.0f) * 1.0f;
                width = getWidth();
            } else {
                float screenWidth2 = DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity);
                if (getWidth() * f2 > screenWidth2) {
                    fDp = screenWidth2 * 1.0f;
                    width = getWidth();
                }
            }
            f2 = (fDp / width) * 1.0f;
        }
        TypeEnum typeEnum2 = this.type;
        if (typeEnum2 == TypeEnum.storyContainer || typeEnum2 == TypeEnum.post) {
            if (getWidth() * f2 < AndroidUtilities.dp(120.0f)) {
                screenWidth = AndroidUtilities.dp(120.0f) * 1.0f;
                width2 = getWidth();
            } else {
                screenWidth = DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity) * 3.0f;
                if (getWidth() * f2 > screenWidth) {
                    width2 = getWidth();
                }
            }
            f2 = (screenWidth / width2) * 1.0f;
        }
        if (this.type == TypeEnum.link) {
            if (f2 > 1.5d) {
                f2 = 1.5f;
            }
            if (f2 < 0.7f) {
                f2 = 0.7f;
            }
        }
        setScaleX(f2);
        setScaleY(f2);
    }

    protected void updatePosition() {
        setX(this.positionX + this.offsetX);
        setY(this.positionY + this.offsetY);
    }

    public float getWidthAfterScale() {
        return getWidth() * getScaleX();
    }

    public float getHeightAfterScale() {
        return getHeight() * getScaleY();
    }

    public float getXAfterScale() {
        return (getX() + (getWidth() / 2.0f)) - (getWidthAfterScale() / 2.0f);
    }

    public float getYAfterScale() {
        return (getY() + (getHeight() / 2.0f)) - (getHeightAfterScale() / 2.0f);
    }

    public float getCenterX() {
        return getX() + (getWidth() / 2.0f);
    }

    public float getCenterY() {
        return getY() + (getHeight() / 2.0f);
    }

    public RectF getEntityClickableRect() {
        PostInStoryCell postInStoryCell;
        if (this.type == TypeEnum.post && (postInStoryCell = this.postCell) != null && postInStoryCell.mode == PostInStoryCell.ModeEnum.justImage) {
            float clickableWidth = postInStoryCell.getClickableWidth() * getScaleX();
            float clickableHeight = this.postCell.getClickableHeight() * getScaleY();
            float xAfterScale = getXAfterScale() + (this.postCell.getClickableX() * getScaleX());
            float yAfterScale = getYAfterScale() + (this.postCell.getClickableY() * getScaleY());
            return new RectF(xAfterScale, yAfterScale, clickableWidth + xAfterScale, clickableHeight + yAfterScale);
        }
        float widthAfterScale = getWidthAfterScale();
        float heightAfterScale = getHeightAfterScale();
        float xAfterScale2 = getXAfterScale();
        float yAfterScale2 = getYAfterScale();
        return new RectF(xAfterScale2, yAfterScale2, widthAfterScale + xAfterScale2, heightAfterScale + yAfterScale2);
    }

    public int getTopOfVideoPost() {
        PostInStoryCell postInStoryCell;
        if (this.type != TypeEnum.post || (postInStoryCell = this.postCell) == null) {
            return 0;
        }
        return postInStoryCell.getTopOfVideoPost();
    }

    public float getPostPivotY() {
        PostInStoryCell postInStoryCell = this.postCell;
        if (postInStoryCell != null) {
            return postInStoryCell.postAndCaptionContainer.getY() + (this.postCell.imageViewPost.getHeight() / 2.0f);
        }
        return getHeight() / 2.0f;
    }

    public float getVideoWidthAfterScale() {
        return this.postCell.getVideoWidth() * getScaleX();
    }

    public float getVideoHeightAfterScale() {
        return this.postCell.getVideoHeight() * getScaleY();
    }

    public float getVideoXAfterScale() {
        if (this.postCell != null) {
            return ((getX() + this.postCell.postAndCaptionContainer.getX()) + (this.postCell.imageViewPost.getWidth() / 2.0f)) - (getVideoWidthAfterScale() / 2.0f);
        }
        return getXAfterScale();
    }

    public float getVideoYAfterScale() {
        if (this.postCell != null) {
            return ((getY() + this.postCell.postAndCaptionContainer.getY()) + (this.postCell.imageViewPost.getHeight() / 2.0f)) - (getVideoHeightAfterScale() / 2.0f);
        }
        return getYAfterScale();
    }
}
