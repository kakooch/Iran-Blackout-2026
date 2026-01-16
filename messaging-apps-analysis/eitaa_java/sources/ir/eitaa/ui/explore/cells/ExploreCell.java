package ir.eitaa.ui.explore.cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.util.Property;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.WebFile;
import ir.eitaa.messenger.video.VideoPlayerRewinder;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageReplies;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$Poll;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonBuy;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonGame;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonSwitchInline;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrl;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaGeoLive;
import ir.eitaa.tgnet.TLRPC$TL_messageReactions;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswer;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswerVoters;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_webPage;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.BaseCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.AnimatedNumberLayout;
import ir.eitaa.ui.Components.AudioVisualizerDrawable;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.CheckBoxBase;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.InfiniteProgress;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.MessageBackgroundDrawable;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.MsgClockDrawable;
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RoundVideoPlayingDrawable;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.SeekBarWaveform;
import ir.eitaa.ui.Components.StaticLayoutEx;
import ir.eitaa.ui.Components.TextStyleSpan;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.URLSpanBrowser;
import ir.eitaa.ui.Components.URLSpanMono;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.Components.VideoForwardDrawable;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import ir.eitaa.ui.SecretMediaViewer;
import ir.eitaa.ui.explore.util.ExploreDateFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ExploreCell extends BaseCell implements SeekBar.SeekBarDelegate, ImageReceiver.ImageReceiverDelegate, DownloadController.FileDownloadProgressListener, TextSelectionHelper.SelectableView {
    private static float[] radii = new float[8];
    private final boolean ALPHA_PROPERTY_WORKAROUND;
    public Property<ExploreCell, Float> ANIMATION_OFFSET_X;
    private int MIN_PREVIEW_DOWNLOAD_SIZE;
    private int TAG;
    private SparseArray<Rect> accessibilityVirtualViewBounds;
    private int addedCaptionHeight;
    private boolean addedForTest;
    private int additionalTimeOffsetY;
    private StaticLayout adminLayout;
    private boolean allowAssistant;
    private float alphaInternal;
    private int animateFromStatusDrawableParams;
    private boolean animatePollAvatars;
    private int animateToStatusDrawableParams;
    private int animatingDrawVideoImageButton;
    private float animatingDrawVideoImageButtonProgress;
    private float animatingLoadingProgressProgress;
    private int animatingNoSound;
    private boolean animatingNoSoundPlaying;
    private float animatingNoSoundProgress;
    private float animationOffsetX;
    private boolean animationRunning;
    private boolean attachedToWindow;
    private StaticLayout authorLayout;
    private int authorX;
    private boolean autoDownload;
    private boolean autoPlayingMedia;
    private int availableTimeWidth;
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private boolean avatarPressed;
    private MessageBackgroundDrawable backgroundDrawable;
    private int backgroundDrawableBottom;
    private int backgroundDrawableLeft;
    private int backgroundDrawableRight;
    private int backgroundDrawableTop;
    private int backgroundHeight;
    private int backgroundWidth;
    private ArrayList<BotButton> botButtons;
    private HashMap<String, BotButton> botButtonsByData;
    private HashMap<String, BotButton> botButtonsByPosition;
    private String botButtonsLayout;
    private boolean bottomNearToSet;
    private int buttonPressed;
    private int buttonState;
    private int buttonX;
    private int buttonY;
    private boolean canStreamVideo;
    private int captionHeight;
    private StaticLayout captionLayout;
    private int captionOffsetX;
    private int captionWidth;
    private float captionX;
    private float captionY;
    StaticLayout channelNameLayout;
    private CheckBoxBase checkBox;
    private boolean checkBoxAnimationInProgress;
    private float checkBoxAnimationProgress;
    private int checkBoxTranslation;
    private boolean checkBoxVisible;
    private boolean checkOnlyButtonPressed;
    private int commentArrowX;
    private AvatarDrawable[] commentAvatarDrawables;
    private ImageReceiver[] commentAvatarImages;
    private boolean[] commentAvatarImagesVisible;
    private boolean commentButtonPressed;
    private Rect commentButtonRect;
    private boolean commentDrawUnread;
    private StaticLayout commentLayout;
    private AnimatedNumberLayout commentNumberLayout;
    private int commentNumberWidth;
    private InfiniteProgress commentProgress;
    private float commentProgressAlpha;
    private long commentProgressLastUpadteTime;
    private int commentUnreadX;
    private int commentWidth;
    private int commentX;
    private AvatarDrawable contactAvatarDrawable;
    private float controlsAlpha;
    private int currentAccount;
    private Theme.MessageDrawable currentBackgroundDrawable;
    private Theme.MessageDrawable currentBackgroundSelectedDrawable;
    private CharSequence currentCaption;
    private TLRPC$Chat currentChat;
    private int currentFocusedVirtualView;
    private TLRPC$Chat currentForwardChannel;
    private String currentForwardName;
    private String currentForwardNameString;
    private TLRPC$User currentForwardUser;
    private int currentMapProvider;
    private MessageObject currentMessageObject;
    private MessageObject.GroupedMessages currentMessagesGroup;
    private String currentNameString;
    private TLRPC$FileLocation currentPhoto;
    private String currentPhotoFilter;
    private String currentPhotoFilterThumb;
    private TLRPC$PhotoSize currentPhotoObject;
    private TLRPC$PhotoSize currentPhotoObjectThumb;
    private MessageObject.GroupedMessagePosition currentPosition;
    private String currentRepliesString;
    private TLRPC$PhotoSize currentReplyPhoto;
    private float currentSelectedBackgroundAlpha;
    private String currentTimeString;
    private String currentUrl;
    private TLRPC$User currentUser;
    private TLRPC$User currentViaBotUser;
    private String currentViewsString;
    private WebFile currentWebFile;
    private ExploreCellDelegate delegate;
    private RectF deleteProgressRect;
    private StaticLayout descriptionLayout;
    private int descriptionX;
    private int descriptionY;
    private Runnable diceFinishCallback;
    private StaticLayout docTitleLayout;
    private int docTitleOffsetX;
    private int docTitleWidth;
    private TLRPC$Document documentAttach;
    int documentAttachType;
    private boolean downloadObserverAdded;
    private boolean drawBackground;
    private boolean drawCommentButton;
    private boolean drawCommentNumber;
    private boolean drawForwardedName;
    public boolean drawFromPinchToZoom;
    private boolean drawImageButton;
    private boolean drawInstantView;
    private int drawInstantViewType;
    private boolean drawLiveMessageIcon;
    private boolean drawMediaCheckBox;
    private boolean drawName;
    private boolean drawNameLayout;
    private boolean drawPhotoImage;
    private boolean drawPinnedBottom;
    private boolean drawPinnedTop;
    private boolean drawRadialCheckBackground;
    private boolean drawSaveToMyCloudButton;
    private boolean drawSelectionBackground;
    private int drawSideButton;
    private boolean drawTime;
    private float drawTimeY;
    private boolean drawVideoImageButton;
    private boolean drawVideoSize;
    private StaticLayout durationLayout;
    private int durationWidth;
    private boolean edited;
    boolean enterTransitionInPorgress;
    private int firstVisibleBlockNum;
    private boolean forceNotDrawTime;
    private boolean forwardName;
    private int forwardNameCenterX;
    private float[] forwardNameOffsetX;
    private float forwardNameX;
    private int forwardNameY;
    private StaticLayout[] forwardedNameLayout;
    private int forwardedNameWidth;
    private boolean fullyDraw;
    private boolean gamePreviewPressed;
    private LinearGradient gradientShader;
    private boolean groupPhotoInvisible;
    private MessageObject.GroupedMessages groupedMessagesToSet;
    public boolean hasDiscussion;
    private boolean hasEmbed;
    private boolean hasGamePreview;
    private boolean hasInvoicePreview;
    private boolean hasLinkPreview;
    private int hasMiniProgress;
    private boolean hasNewLineForTime;
    private boolean hasOldCaptionPreview;
    private boolean hasPsaHint;
    private int highlightProgress;
    private boolean hintButtonVisible;
    private int imageBackgroundColor;
    private int imageBackgroundGradientColor1;
    private int imageBackgroundGradientColor2;
    private int imageBackgroundGradientColor3;
    private int imageBackgroundGradientRotation;
    private float imageBackgroundIntensity;
    private int imageBackgroundSideColor;
    private int imageBackgroundSideWidth;
    private boolean imageDrawn;
    private boolean imagePressed;
    private boolean inLayout;
    private StaticLayout infoLayout;
    private int infoWidth;
    private boolean insantTextNewLine;
    private boolean instantButtonPressed;
    private RectF instantButtonRect;
    private boolean instantPressed;
    private int instantTextLeftX;
    private int instantTextX;
    private StaticLayout instantViewLayout;
    private int instantWidth;
    private Runnable invalidateRunnable;
    private boolean invalidatesParent;
    private boolean isAvatarVisible;
    public boolean isChat;
    private boolean isCheckPressed;
    private boolean isHighlighted;
    private boolean isHighlightedAnimated;
    private boolean isMedia;
    public boolean isMegagroup;
    public boolean isPinned;
    public boolean isPinnedChat;
    private boolean isPlayingRound;
    private boolean isPressed;
    public boolean isRepliesChat;
    private boolean isRoundVideo;
    private boolean isSmallImage;
    public boolean isThreadChat;
    private boolean isThreadPost;
    private boolean isUpdating;
    private int keyboardHeight;
    private long lastAnimationTime;
    private long lastCheckBoxAnimationTime;
    private long lastControlsAlphaChangeTime;
    private int lastDeleteDate;
    private float lastDrawingAudioProgress;
    private int lastHeight;
    private long lastHighlightProgressTime;
    private long lastLoadingSizeTotal;
    private TLRPC$Poll lastPoll;
    private ArrayList<TLRPC$TL_pollAnswerVoters> lastPollResults;
    private int lastPollResultsVoters;
    private String lastPostAuthor;
    private TLRPC$TL_messageReactions lastReactions;
    private int lastRepliesCount;
    private TLRPC$Message lastReplyMessage;
    private int lastSendState;
    int lastSize;
    private int lastTime;
    private float lastTouchX;
    private float lastTouchY;
    private int lastViewsCount;
    private int lastVisibleBlockNum;
    private WebFile lastWebFile;
    private int lastWidth;
    private int layoutHeight;
    private int layoutWidth;
    private int linkBlockNum;
    private int linkPreviewHeight;
    private boolean linkPreviewPressed;
    private int linkSelectionBlockNum;
    public long linkedChatId;
    private StaticLayout liveStreamArchiveSizeLayout;
    private StaticLayout liveStreamStateLayout;
    private StaticLayout liveTotalTimeLayout;
    private StaticLayout liveTotalViewerLayout;
    private StaticLayout loadingProgressLayout;
    private boolean locationExpired;
    private ImageReceiver locationImageReceiver;
    private boolean longVideo;
    private boolean mediaBackground;
    private CheckBoxBase mediaCheckBox;
    private int mediaOffsetY;
    private boolean mediaWasInvisible;
    private MessageObject messageObjectToSet;
    private int miniButtonPressed;
    private int miniButtonState;
    private MotionBackgroundDrawable motionBackgroundDrawable;
    private StaticLayout nameLayout;
    private float nameOffsetX;
    private int nameWidth;
    private int namesOffset;
    private boolean needNewVisiblePart;
    public boolean needReplyImage;
    private int noSoundCenterX;
    private boolean otherPressed;
    private int otherX;
    private int otherY;
    private int overideShouldDrawTimeOnMedia;
    private int parentHeight;
    public float parentViewTopOffset;
    private int parentWidth;
    private StaticLayout performerLayout;
    private int performerX;
    private ImageReceiver photoImage;
    private boolean photoNotSet;
    private TLObject photoParentObject;
    private StaticLayout photosCountLayout;
    private int photosCountWidth;
    public boolean pinnedBottom;
    public boolean pinnedTop;
    private float pollAnimationProgressTime;
    private ImageReceiver[] pollAvatarImages;
    private ArrayList<PollButton> pollButtons;
    private CheckBoxBase[] pollCheckBox;
    private boolean pollClosed;
    private boolean pollHintPressed;
    private int pollHintX;
    private int pollHintY;
    private boolean pollUnvoteInProgress;
    private boolean pollVoteInProgress;
    private boolean pollVoted;
    private int pressedBotButton;
    private CharacterStyle pressedLink;
    private int pressedLinkType;
    private int[] pressedState;
    private int pressedVoteButton;
    private int psaHelpX;
    private int psaHelpY;
    private boolean psaHintPressed;
    private RadialProgress2 radialProgress;
    private RectF rect;
    private Path rectPath;
    private StaticLayout repliesLayout;
    private int repliesTextWidth;
    public ImageReceiver replyImageReceiver;
    public StaticLayout replyNameLayout;
    private int replyNameOffset;
    private int replyNameWidth;
    private boolean replyPanelIsForward;
    public int replyStartX;
    public int replyStartY;
    public StaticLayout replyTextLayout;
    private int replyTextOffset;
    private int replyTextWidth;
    private final Theme.ResourcesProvider resourcesProvider;
    private float roundPlayingDrawableProgress;
    private RoundVideoPlayingDrawable roundVideoPlayingDrawable;
    private boolean scheduledInvalidate;
    private Rect scrollRect;
    private SeekBar seekBar;
    private SeekBarAccessibilityDelegate seekBarAccessibilityDelegate;
    private SeekBarWaveform seekBarWaveform;
    private int seekBarX;
    private int seekBarY;
    private float selectedBackgroundProgress;
    private Drawable[] selectorDrawable;
    private int[] selectorDrawableMaskType;
    private AnimatorSet shakeAnimation;
    private boolean showPreview;
    private boolean sideButtonPressed;
    private float sideStartX;
    private float sideStartY;
    private StaticLayout siteNameLayout;
    private boolean siteNameRtl;
    private int siteNameWidth;
    private float slidingOffsetX;
    private StaticLayout songLayout;
    private int songX;
    private boolean statusDrawableAnimationInProgress;
    private ValueAnimator statusDrawableAnimator;
    private float statusDrawableProgress;
    private int substractBackgroundHeight;
    private int textX;
    private int textY;
    private float timeAlpha;
    private int timeAudioX;
    private StaticLayout timeLayout;
    private boolean timePressed;
    private int timeTextWidth;
    private boolean timeWasInvisible;
    private int timeWidth;
    private int timeWidthAudio;
    private int timeX;
    private StaticLayout titleLayout;
    private int titleX;
    private float toSeekBarProgress;
    private boolean topNearToSet;
    private long totalChangeTime;
    private int totalCommentWidth;
    private int totalHeight;
    private int totalVisibleBlocksCount;
    private final TransitionParams transitionParams;
    float transitionYOffsetForDrawables;
    private int unmovedTextX;
    private ArrayList<LinkPath> urlPath;
    private ArrayList<LinkPath> urlPathCache;
    private ArrayList<LinkPath> urlPathSelection;
    private boolean useSeekBarWaweform;
    private int viaNameWidth;
    private TypefaceSpan viaSpan1;
    private TypefaceSpan viaSpan2;
    private int viaWidth;
    private boolean vibrateOnPollVote;
    private int videoButtonPressed;
    private int videoButtonX;
    private int videoButtonY;
    VideoForwardDrawable videoForwardDrawable;
    private StaticLayout videoInfoLayout;
    VideoPlayerRewinder videoPlayerRewinder;
    private RadialProgress2 videoRadialProgress;
    private float viewTop;
    private StaticLayout viewsLayout;
    private int viewsTextWidth;
    private boolean wasLayout;
    private boolean wasPinned;
    private boolean wasSending;
    private int widthBeforeNewTimeLine;
    private int widthForButtons;

    public interface ExploreCellDelegate {

        /* renamed from: ir.eitaa.ui.explore.cells.ExploreCell$ExploreCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didLongPress(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, float f, float f2) {
            }

            public static boolean $default$didLongPressChannelAvatar(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                return false;
            }

            public static boolean $default$didLongPressUserAvatar(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$User tLRPC$User, float f, float f2) {
                return false;
            }

            public static void $default$didPressBotButton(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
            }

            public static void $default$didPressChannelAvatar(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
            }

            public static void $default$didPressCommentButton(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell) {
            }

            public static void $default$didPressHiddenForward(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell) {
            }

            public static void $default$didPressHint(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, int i) {
            }

            public static void $default$didPressInstantButton(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, int i) {
            }

            public static void $default$didPressReaction(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
            }

            public static void $default$didPressReplyMessage(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, int i) {
            }

            public static void $default$didPressSideButton(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell) {
            }

            public static void $default$didPressUrl(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, CharacterStyle characterStyle, boolean z) {
            }

            public static void $default$didPressUserAvatar(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, TLRPC$User tLRPC$User, float f, float f2) {
            }

            public static void $default$didPressVoteButtons(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell, ArrayList arrayList, int i, int i2, int i3) {
            }

            public static void $default$didStartVideoStream(ExploreCellDelegate exploreCellDelegate, MessageObject messageObject) {
            }

            public static String $default$getAdminRank(ExploreCellDelegate exploreCellDelegate, long j) {
                return null;
            }

            public static PinchToZoomHelper $default$getPinchToZoomHelper(ExploreCellDelegate exploreCellDelegate) {
                return null;
            }

            public static TextSelectionHelper.ChatListTextSelectionHelper $default$getTextSelectionHelper(ExploreCellDelegate exploreCellDelegate) {
                return null;
            }

            public static boolean $default$isLandscape(ExploreCellDelegate exploreCellDelegate) {
                return false;
            }

            public static boolean $default$keyboardIsOpened(ExploreCellDelegate exploreCellDelegate) {
                return false;
            }

            public static void $default$onDiceFinished(ExploreCellDelegate exploreCellDelegate) {
            }

            public static void $default$setShouldNotRepeatSticker(ExploreCellDelegate exploreCellDelegate, MessageObject messageObject) {
            }

            public static boolean $default$shouldDrawThreadProgress(ExploreCellDelegate exploreCellDelegate, ExploreCell exploreCell) {
                return false;
            }

            public static boolean $default$shouldRepeatSticker(ExploreCellDelegate exploreCellDelegate, MessageObject messageObject) {
                return true;
            }

            public static void $default$videoTimerReached(ExploreCellDelegate exploreCellDelegate) {
            }
        }

        void didLongPress(ExploreCell cell, float x, float y);

        boolean didLongPressChannelAvatar(ExploreCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        boolean didLongPressUserAvatar(ExploreCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressBotButton(ExploreCell cell, TLRPC$KeyboardButton button);

        void didPressChannelAvatar(ExploreCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        void didPressCommentButton(ExploreCell cell);

        void didPressHiddenForward(ExploreCell cell);

        void didPressHint(ExploreCell cell, int type);

        void didPressInstantButton(ExploreCell cell, int type);

        void didPressReaction(ExploreCell cell, TLRPC$TL_reactionCount reaction);

        void didPressReplyMessage(ExploreCell cell, int id);

        void didPressSideButton(ExploreCell cell);

        void didPressUrl(ExploreCell cell, CharacterStyle url, boolean longPress);

        void didPressUserAvatar(ExploreCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressVoteButtons(ExploreCell cell, ArrayList<TLRPC$TL_pollAnswer> buttons, int showCount, int x, int y);

        void didStartVideoStream(MessageObject message);

        String getAdminRank(long uid);

        PinchToZoomHelper getPinchToZoomHelper();

        TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper();

        boolean isLandscape();

        boolean keyboardIsOpened();

        void onDiceFinished();

        void setShouldNotRepeatSticker(MessageObject message);

        boolean shouldDrawThreadProgress(ExploreCell cell);

        boolean shouldRepeatSticker(MessageObject message);

        void videoTimerReached();
    }

    private boolean intersect(float left1, float right1, float left2, float right2) {
        return left1 <= left2 ? right1 >= left2 : left1 <= right2;
    }

    public int getCurrentBackgroundLeft() {
        return 0;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return true;
    }

    public RadialProgress2 getRadialProgress() {
        return this.radialProgress;
    }

    public void setEnterTransitionInProgress(boolean b) {
        this.enterTransitionInPorgress = b;
        invalidate();
    }

    private static class BotButton {
        private int angle;
        private TLRPC$KeyboardButton button;
        private int height;
        private long lastUpdateTime;
        private float progressAlpha;
        private TLRPC$TL_reactionCount reaction;
        private StaticLayout title;
        private int width;
        private int x;
        private int y;

        private BotButton() {
        }

        static /* synthetic */ float access$1216(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha + f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ float access$1224(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha - f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ int access$1316(BotButton botButton, float f) {
            int i = (int) (botButton.angle + f);
            botButton.angle = i;
            return i;
        }

        static /* synthetic */ int access$1320(BotButton botButton, int i) {
            int i2 = botButton.angle - i;
            botButton.angle = i2;
            return i2;
        }
    }

    public static class PollButton {
        private TLRPC$TL_pollAnswer answer;
        private boolean chosen;
        private boolean correct;
        public int height;
        private int percent;
        private StaticLayout title;
        public int x;
        public int y;
    }

    public ExploreCell(Context context) {
        this(context, null);
    }

    public ExploreCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.scrollRect = new Rect();
        this.parentViewTopOffset = 0.0f;
        this.canStreamVideo = true;
        this.mediaOffsetY = 0;
        this.imageBackgroundGradientRotation = 45;
        this.selectorDrawable = new Drawable[2];
        this.selectorDrawableMaskType = new int[2];
        this.instantButtonRect = new RectF();
        this.pressedState = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        this.MIN_PREVIEW_DOWNLOAD_SIZE = 2000000;
        this.showPreview = false;
        this.downloadObserverAdded = false;
        this.captionOffsetX = 0;
        this.deleteProgressRect = new RectF();
        this.rect = new RectF();
        this.timeAlpha = 1.0f;
        this.controlsAlpha = 1.0f;
        this.urlPathCache = new ArrayList<>();
        this.urlPath = new ArrayList<>();
        this.urlPathSelection = new ArrayList<>();
        this.rectPath = new Path();
        this.pollButtons = new ArrayList<>();
        this.autoDownload = true;
        this.longVideo = false;
        this.botButtons = new ArrayList<>();
        this.botButtonsByData = new HashMap<>();
        this.botButtonsByPosition = new HashMap<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.isChat = false;
        this.forwardName = false;
        this.isCheckPressed = true;
        this.isAvatarVisible = false;
        this.drawBackground = true;
        this.backgroundWidth = 100;
        this.commentButtonRect = new Rect();
        this.drawSideButton = 0;
        this.drawSaveToMyCloudButton = false;
        this.drawName = false;
        this.drawNameLayout = false;
        this.forwardedNameLayout = new StaticLayout[2];
        this.drawForwardedName = false;
        this.forwardNameOffsetX = new float[2];
        this.ALPHA_PROPERTY_WORKAROUND = Build.VERSION.SDK_INT == 28;
        this.alphaInternal = 1.0f;
        this.transitionParams = new TransitionParams();
        this.diceFinishCallback = new Runnable() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.1
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreCell.this.delegate != null) {
                    ExploreCell.this.delegate.onDiceFinished();
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.2
            @Override // java.lang.Runnable
            public void run() {
                ExploreCell.this.checkLocationExpired();
                if (ExploreCell.this.locationExpired) {
                    ExploreCell.this.invalidate();
                    ExploreCell.this.scheduledInvalidate = false;
                    return;
                }
                ExploreCell.this.invalidate(((int) r0.rect.left) - 5, ((int) ExploreCell.this.rect.top) - 5, ((int) ExploreCell.this.rect.right) + 5, ((int) ExploreCell.this.rect.bottom) + 5);
                if (ExploreCell.this.scheduledInvalidate) {
                    AndroidUtilities.runOnUIThread(ExploreCell.this.invalidateRunnable, 1000L);
                }
            }
        };
        this.accessibilityVirtualViewBounds = new SparseArray<>();
        this.currentFocusedVirtualView = -1;
        this.ANIMATION_OFFSET_X = new Property<ExploreCell, Float>(Float.class, "animationOffsetX") { // from class: ir.eitaa.ui.explore.cells.ExploreCell.8
            @Override // android.util.Property
            public Float get(ExploreCell object) {
                return Float.valueOf(object.animationOffsetX);
            }

            @Override // android.util.Property
            public void set(ExploreCell object, Float value) {
                object.setAnimationOffsetX(value.floatValue());
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.backgroundDrawable = new MessageBackgroundDrawable(this);
        ImageReceiver imageReceiver = new ImageReceiver();
        this.avatarImage = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarDrawable = new AvatarDrawable();
        ImageReceiver imageReceiver2 = new ImageReceiver(this);
        this.replyImageReceiver = imageReceiver2;
        imageReceiver2.setRoundRadius(AndroidUtilities.dp(2.0f));
        ImageReceiver imageReceiver3 = new ImageReceiver(this);
        this.locationImageReceiver = imageReceiver3;
        imageReceiver3.setRoundRadius(AndroidUtilities.dp(26.1f));
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        this.contactAvatarDrawable = new AvatarDrawable();
        ImageReceiver imageReceiver4 = new ImageReceiver(this);
        this.photoImage = imageReceiver4;
        imageReceiver4.setDelegate(this);
        this.radialProgress = new RadialProgress2(this, resourcesProvider);
        RadialProgress2 radialProgress2 = new RadialProgress2(this, resourcesProvider);
        this.videoRadialProgress = radialProgress2;
        radialProgress2.setDrawBackground(false);
        this.videoRadialProgress.setCircleRadius(AndroidUtilities.dp(15.0f));
        SeekBar seekBar = new SeekBar(this);
        this.seekBar = seekBar;
        seekBar.setDelegate(this);
        SeekBarWaveform seekBarWaveform = new SeekBarWaveform(context);
        this.seekBarWaveform = seekBarWaveform;
        seekBarWaveform.setDelegate(this);
        this.seekBarWaveform.setParentView(this);
        this.seekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.3
            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                if (ExploreCell.this.currentMessageObject.isMusic()) {
                    return ExploreCell.this.seekBar.getProgress();
                }
                if (ExploreCell.this.currentMessageObject.isVoice()) {
                    return ExploreCell.this.useSeekBarWaweform ? ExploreCell.this.seekBarWaveform.getProgress() : ExploreCell.this.seekBar.getProgress();
                }
                return 0.0f;
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float progress) {
                if (ExploreCell.this.currentMessageObject.isMusic()) {
                    ExploreCell.this.seekBar.setProgress(progress);
                } else {
                    if (!ExploreCell.this.currentMessageObject.isVoice()) {
                        return;
                    }
                    if (ExploreCell.this.useSeekBarWaweform) {
                        ExploreCell.this.seekBarWaveform.setProgress(progress);
                    } else {
                        ExploreCell.this.seekBar.setProgress(progress);
                    }
                }
                ExploreCell.this.onSeekBarDrag(progress);
                ExploreCell.this.invalidate();
            }
        };
        this.roundVideoPlayingDrawable = new RoundVideoPlayingDrawable(this, resourcesProvider);
    }

    private void createCommentUI() {
        if (this.commentAvatarImages != null) {
            return;
        }
        this.commentAvatarImages = new ImageReceiver[3];
        this.commentAvatarDrawables = new AvatarDrawable[3];
        this.commentAvatarImagesVisible = new boolean[3];
        int i = 0;
        while (true) {
            ImageReceiver[] imageReceiverArr = this.commentAvatarImages;
            if (i >= imageReceiverArr.length) {
                return;
            }
            imageReceiverArr[i] = new ImageReceiver(this);
            this.commentAvatarImages[i].setRoundRadius(AndroidUtilities.dp(12.0f));
            this.commentAvatarDrawables[i] = new AvatarDrawable();
            this.commentAvatarDrawables[i].setTextSize(AndroidUtilities.dp(8.0f));
            i++;
        }
    }

    private void resetPressedLink(int type) {
        if (this.pressedLink != null) {
            if (this.pressedLinkType == type || type == -1) {
                resetUrlPaths(false);
                this.pressedLink = null;
                this.pressedLinkType = -1;
                invalidate();
            }
        }
    }

    private void resetUrlPaths(boolean text) {
        if (text) {
            if (this.urlPathSelection.isEmpty()) {
                return;
            }
            this.urlPathCache.addAll(this.urlPathSelection);
            this.urlPathSelection.clear();
            return;
        }
        if (this.urlPath.isEmpty()) {
            return;
        }
        this.urlPathCache.addAll(this.urlPath);
        this.urlPath.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getRealSpanStartAndEnd(Spannable buffer, CharacterStyle link) {
        int spanEnd;
        int spanStart;
        boolean z;
        TextStyleSpan.TextStyleRun style;
        TLRPC$MessageEntity tLRPC$MessageEntity;
        if (!(link instanceof URLSpanBrowser) || (style = ((URLSpanBrowser) link).getStyle()) == null || (tLRPC$MessageEntity = style.urlEntity) == null) {
            spanEnd = 0;
            spanStart = 0;
            z = false;
        } else {
            spanStart = tLRPC$MessageEntity.offset;
            spanEnd = tLRPC$MessageEntity.length + spanStart;
            z = true;
        }
        if (!z) {
            spanStart = buffer.getSpanStart(link);
            spanEnd = buffer.getSpanEnd(link);
        }
        return new int[]{spanStart, spanEnd};
    }

    private void invalidateWithParent() {
        if (this.currentMessagesGroup != null && getParent() != null) {
            ((ViewGroup) getParent()).invalidate();
        }
        invalidate();
    }

    public ArrayList<PollButton> getPollButtons() {
        return this.pollButtons;
    }

    public void updatePlayingMessageProgress() {
        int iMax;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        VideoPlayerRewinder videoPlayerRewinder = this.videoPlayerRewinder;
        if (videoPlayerRewinder != null && videoPlayerRewinder.rewindCount != 0 && videoPlayerRewinder.rewindByBackSeek) {
            messageObject.audioProgress = videoPlayerRewinder.getVideoProgress();
        }
        if (this.documentAttachType == 4) {
            if (this.infoLayout == null || !(PhotoViewer.isPlayingMessage(this.currentMessageObject) || MediaController.getInstance().isGoingToShowMessageObject(this.currentMessageObject))) {
                AnimatedFileDrawable animation = this.photoImage.getAnimation();
                if (animation != null) {
                    MessageObject messageObject2 = this.currentMessageObject;
                    currentProgressMs = animation.getDurationMs() / 1000;
                    messageObject2.audioPlayerDuration = currentProgressMs;
                    MessageObject messageObject3 = this.currentMessageObject;
                    TLRPC$Message tLRPC$Message = messageObject3.messageOwner;
                    if (tLRPC$Message.ttl > 0 && tLRPC$Message.destroyTime == 0 && !messageObject3.needDrawBluredPreview() && this.currentMessageObject.isVideo() && animation.hasBitmap()) {
                        this.delegate.didStartVideoStream(this.currentMessageObject);
                    }
                }
                if (currentProgressMs == 0) {
                    currentProgressMs = this.currentMessageObject.getDuration();
                }
                if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                    float f = currentProgressMs;
                    currentProgressMs = (int) (f - (this.currentMessageObject.audioProgress * f));
                } else if (animation != null) {
                    if (currentProgressMs != 0) {
                        currentProgressMs -= animation.getCurrentProgressMs() / 1000;
                    }
                    if (this.delegate != null && animation.getCurrentProgressMs() >= 3000) {
                        this.delegate.videoTimerReached();
                    }
                }
                if (this.lastTime != currentProgressMs) {
                    String shortDuration = AndroidUtilities.formatShortDuration(currentProgressMs);
                    this.infoWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(shortDuration));
                    this.infoLayout = new StaticLayout(shortDuration, Theme.chat_infoPaint, this.infoWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                    this.lastTime = currentProgressMs;
                    return;
                }
                return;
            }
            return;
        }
        if (this.isRoundVideo) {
            TLRPC$Document document = this.currentMessageObject.getDocument();
            int i = 0;
            while (true) {
                if (i >= document.attributes.size()) {
                    iMax = 0;
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeVideo) {
                    iMax = tLRPC$DocumentAttribute.duration;
                    break;
                }
                i++;
            }
            if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                iMax = Math.max(0, iMax - this.currentMessageObject.audioProgressSec);
            }
            if (this.lastTime != iMax) {
                this.lastTime = iMax;
                String longDuration = AndroidUtilities.formatLongDuration(iMax);
                this.timeWidthAudio = (int) Math.ceil(Theme.chat_timePaint.measureText(longDuration));
                this.durationLayout = new StaticLayout(longDuration, Theme.chat_timePaint, this.timeWidthAudio, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            float f2 = this.currentMessageObject.audioProgress;
            if (f2 != 0.0f) {
                this.lastDrawingAudioProgress = f2;
                if (f2 > 0.9f) {
                    this.lastDrawingAudioProgress = 1.0f;
                }
            }
            invalidate();
            return;
        }
        if (this.documentAttach != null) {
            if (this.useSeekBarWaweform) {
                if (!this.seekBarWaveform.isDragging()) {
                    this.seekBarWaveform.setProgress(this.currentMessageObject.audioProgress, true);
                }
            } else if (!this.seekBar.isDragging()) {
                this.seekBar.setProgress(this.currentMessageObject.audioProgress);
                this.seekBar.setBufferedProgress(this.currentMessageObject.bufferedProgress);
            }
            if (this.documentAttachType == 3) {
                if (!MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.documentAttach.attributes.size()) {
                            break;
                        }
                        TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.documentAttach.attributes.get(i2);
                        if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                            currentProgressMs = tLRPC$DocumentAttribute2.duration;
                            break;
                        }
                        i2++;
                    }
                } else {
                    currentProgressMs = this.currentMessageObject.audioProgressSec;
                }
                if (this.lastTime != currentProgressMs) {
                    this.lastTime = currentProgressMs;
                    String longDuration2 = AndroidUtilities.formatLongDuration(currentProgressMs);
                    this.timeWidthAudio = (int) Math.ceil(Theme.chat_audioTimePaint.measureText(longDuration2));
                    this.durationLayout = new StaticLayout(longDuration2, Theme.chat_audioTimePaint, this.timeWidthAudio, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
            } else {
                int duration = this.currentMessageObject.getDuration();
                currentProgressMs = MediaController.getInstance().isPlayingMessage(this.currentMessageObject) ? this.currentMessageObject.audioProgressSec : 0;
                if (this.lastTime != currentProgressMs) {
                    this.lastTime = currentProgressMs;
                    this.durationLayout = new StaticLayout(AndroidUtilities.formatShortDuration(currentProgressMs, duration), Theme.chat_audioTimePaint, (int) Math.ceil(Theme.chat_audioTimePaint.measureText(r4)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                }
            }
            invalidate();
        }
    }

    public void setFullyDraw(boolean draw) {
        this.fullyDraw = draw;
    }

    public void setVisiblePart(int position, int height, int parent, float parentOffset, float visibleTop, int parentW, int parentH) {
        Theme.MessageDrawable messageDrawable;
        this.parentWidth = parentW;
        this.parentHeight = parentH;
        this.backgroundHeight = parentH;
        this.viewTop = visibleTop;
        if (parent != parentH || parentOffset != this.parentViewTopOffset) {
            this.parentHeight = parent;
        }
        if ((this.currentMessageObject != null && ((hasGradientService() && this.currentMessageObject.shouldDrawWithoutBackground()) || this.drawSideButton != 0 || !this.botButtons.isEmpty())) || ((messageDrawable = this.currentBackgroundDrawable) != null && messageDrawable.getGradientShader() != null)) {
            invalidate();
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.textLayoutBlocks == null) {
            return;
        }
        int i = position - this.textY;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.currentMessageObject.textLayoutBlocks.size() && this.currentMessageObject.textLayoutBlocks.get(i4).textYOffset <= i; i4++) {
            i3 = i4;
        }
        int i5 = -1;
        int i6 = -1;
        while (i3 < this.currentMessageObject.textLayoutBlocks.size()) {
            float f = this.currentMessageObject.textLayoutBlocks.get(i3).textYOffset;
            float f2 = i;
            if (!intersect(f, r0.height + f, f2, i + height)) {
                if (f > f2) {
                    break;
                }
            } else {
                if (i5 == -1) {
                    i5 = i3;
                }
                i2++;
                i6 = i3;
            }
            i3++;
        }
        if (this.lastVisibleBlockNum == i6 && this.firstVisibleBlockNum == i5 && this.totalVisibleBlocksCount == i2) {
            return;
        }
        this.lastVisibleBlockNum = i6;
        this.firstVisibleBlockNum = i5;
        this.totalVisibleBlocksCount = i2;
        invalidate();
    }

    public static StaticLayout generateStaticLayout(CharSequence text, TextPaint paint, int maxWidth, int smallWidth, int linesCount, int maxLines) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        StaticLayout staticLayout = new StaticLayout(text, paint, smallWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int i = maxWidth;
        int i2 = 0;
        for (int i3 = 0; i3 < linesCount; i3++) {
            staticLayout.getLineDirections(i3);
            if (staticLayout.getLineLeft(i3) != 0.0f || staticLayout.isRtlCharAt(staticLayout.getLineStart(i3)) || staticLayout.isRtlCharAt(staticLayout.getLineEnd(i3))) {
                i = smallWidth;
            }
            int lineEnd = staticLayout.getLineEnd(i3);
            if (lineEnd == text.length()) {
                break;
            }
            int i4 = (lineEnd - 1) + i2;
            if (spannableStringBuilder.charAt(i4) == ' ') {
                spannableStringBuilder.replace(i4, i4 + 1, (CharSequence) "\n");
            } else if (spannableStringBuilder.charAt(i4) != '\n') {
                spannableStringBuilder.insert(i4, (CharSequence) "\n");
                i2++;
            }
            if (i3 == staticLayout.getLineCount() - 1 || i3 == maxLines - 1) {
                break;
            }
        }
        int i5 = i;
        return StaticLayoutEx.createStaticLayout(spannableStringBuilder, paint, i5, Layout.Alignment.ALIGN_NORMAL, 1.0f, AndroidUtilities.dp(1.0f), false, TextUtils.TruncateAt.END, i5, maxLines, true);
    }

    private void updateSecretTimeText(MessageObject messageObject) {
        String secretTimeString;
        if (messageObject == null || !messageObject.needDrawBluredPreview() || (secretTimeString = messageObject.getSecretTimeString()) == null) {
            return;
        }
        int iCeil = (int) Math.ceil(Theme.chat_infoPaint.measureText(secretTimeString));
        this.infoWidth = iCeil;
        this.infoLayout = new StaticLayout(TextUtils.ellipsize(secretTimeString, Theme.chat_infoPaint, iCeil, TextUtils.TruncateAt.END), Theme.chat_infoPaint, this.infoWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isPhotoDataChanged(ir.eitaa.messenger.MessageObject r25) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.isPhotoDataChanged(ir.eitaa.messenger.MessageObject):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRepliesCount() {
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && !groupedMessages.messages.isEmpty()) {
            return this.currentMessagesGroup.messages.get(0).getRepliesCount();
        }
        return this.currentMessageObject.getRepliesCount();
    }

    private ArrayList<TLRPC$Peer> getRecentRepliers() {
        TLRPC$MessageReplies tLRPC$MessageReplies;
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && !groupedMessages.messages.isEmpty() && (tLRPC$MessageReplies = this.currentMessagesGroup.messages.get(0).messageOwner.replies) != null) {
            return tLRPC$MessageReplies.recent_repliers;
        }
        TLRPC$MessageReplies tLRPC$MessageReplies2 = this.currentMessageObject.messageOwner.replies;
        if (tLRPC$MessageReplies2 != null) {
            return tLRPC$MessageReplies2.recent_repliers;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isUserDataChanged() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.isUserDataChanged():boolean");
    }

    public ImageReceiver getPhotoImage() {
        return this.photoImage;
    }

    public int getNoSoundIconCenterX() {
        return this.noSoundCenterX;
    }

    public int getForwardNameCenterX() {
        float centerX;
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User != null && tLRPC$User.id == 0) {
            centerX = this.avatarImage.getCenterX();
        } else {
            centerX = this.forwardNameX + this.forwardNameCenterX;
        }
        return (int) centerX;
    }

    public int getChecksX() {
        return this.layoutWidth - AndroidUtilities.dp(SharedConfig.bubbleRadius >= 10 ? 27.3f : 25.3f);
    }

    public int getChecksY() {
        float f;
        int intrinsicHeight;
        if (this.currentMessageObject.shouldDrawWithoutBackground()) {
            f = this.drawTimeY;
            intrinsicHeight = getThemedDrawable("drawableMsgStickerCheck").getIntrinsicHeight();
        } else {
            f = this.drawTimeY;
            intrinsicHeight = Theme.chat_msgMediaCheckDrawable.getIntrinsicHeight();
        }
        return (int) (f - intrinsicHeight);
    }

    public TLRPC$User getCurrentUser() {
        return this.currentUser;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelShakeAnimation();
        if (this.animationRunning) {
            return;
        }
        this.downloadObserverAdded = false;
        this.showPreview = false;
        CheckBoxBase checkBoxBase = this.checkBox;
        if (checkBoxBase != null) {
            checkBoxBase.onDetachedFromWindow();
        }
        CheckBoxBase checkBoxBase2 = this.mediaCheckBox;
        if (checkBoxBase2 != null) {
            checkBoxBase2.onDetachedFromWindow();
        }
        if (this.pollCheckBox != null) {
            int i = 0;
            while (true) {
                CheckBoxBase[] checkBoxBaseArr = this.pollCheckBox;
                if (i >= checkBoxBaseArr.length) {
                    break;
                }
                checkBoxBaseArr[i].onDetachedFromWindow();
                i++;
            }
        }
        this.attachedToWindow = false;
        this.radialProgress.onDetachedFromWindow();
        this.videoRadialProgress.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
        if (this.pollAvatarImages != null) {
            int i2 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr = this.pollAvatarImages;
                if (i2 >= imageReceiverArr.length) {
                    break;
                }
                imageReceiverArr[i2].onDetachedFromWindow();
                i2++;
            }
        }
        if (this.commentAvatarImages != null) {
            int i3 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr2 = this.commentAvatarImages;
                if (i3 >= imageReceiverArr2.length) {
                    break;
                }
                imageReceiverArr2[i3].onDetachedFromWindow();
                i3++;
            }
        }
        this.replyImageReceiver.onDetachedFromWindow();
        this.locationImageReceiver.onDetachedFromWindow();
        this.photoImage.onDetachedFromWindow();
        if (this.addedForTest && this.currentUrl != null && this.currentWebFile != null) {
            ImageLoader.getInstance().removeTestWebFile(this.currentUrl);
            this.addedForTest = false;
        }
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.transitionParams.onDetach();
        if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
            Theme.getCurrentAudiVisualizerDrawable().setParentView(null);
        }
        ValueAnimator valueAnimator = this.statusDrawableAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.statusDrawableAnimator.cancel();
        }
        this.statusDrawableAnimationInProgress = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null) {
            messageObject.animateComments = false;
        }
        MessageObject messageObject2 = this.messageObjectToSet;
        if (messageObject2 != null) {
            messageObject2.animateComments = false;
            setMessageContent(messageObject2, this.groupedMessagesToSet, this.bottomNearToSet, this.topNearToSet);
            this.messageObjectToSet = null;
            this.groupedMessagesToSet = null;
        }
        CheckBoxBase checkBoxBase = this.checkBox;
        if (checkBoxBase != null) {
            checkBoxBase.onAttachedToWindow();
        }
        CheckBoxBase checkBoxBase2 = this.mediaCheckBox;
        if (checkBoxBase2 != null) {
            checkBoxBase2.onAttachedToWindow();
        }
        if (this.pollCheckBox != null) {
            int i = 0;
            while (true) {
                CheckBoxBase[] checkBoxBaseArr = this.pollCheckBox;
                if (i >= checkBoxBaseArr.length) {
                    break;
                }
                checkBoxBaseArr[i].onAttachedToWindow();
                i++;
            }
        }
        this.attachedToWindow = true;
        this.animationOffsetX = 0.0f;
        this.slidingOffsetX = 0.0f;
        this.checkBoxTranslation = 0;
        updateTranslation();
        this.radialProgress.onAttachedToWindow();
        this.videoRadialProgress.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
        this.avatarImage.setParentView((View) getParent());
        if (this.pollAvatarImages != null) {
            int i2 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr = this.pollAvatarImages;
                if (i2 >= imageReceiverArr.length) {
                    break;
                }
                imageReceiverArr[i2].onAttachedToWindow();
                i2++;
            }
        }
        if (this.commentAvatarImages != null) {
            int i3 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr2 = this.commentAvatarImages;
                if (i3 >= imageReceiverArr2.length) {
                    break;
                }
                imageReceiverArr2[i3].onAttachedToWindow();
                i3++;
            }
        }
        this.replyImageReceiver.onAttachedToWindow();
        this.locationImageReceiver.onAttachedToWindow();
        if (!this.photoImage.onAttachedToWindow() || this.drawPhotoImage) {
            updateButtonState(false, false, false);
        }
        MessageObject messageObject3 = this.currentMessageObject;
        if (messageObject3 != null && (this.isRoundVideo || messageObject3.isVideo())) {
            checkVideoPlayback(true, null);
        }
        int i4 = this.documentAttachType;
        if (i4 == 4 && this.autoPlayingMedia) {
            boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
            this.animatingNoSoundPlaying = zIsPlayingMessage;
            this.animatingNoSoundProgress = zIsPlayingMessage ? 0.0f : 1.0f;
            this.animatingNoSound = 0;
        } else {
            this.animatingNoSoundPlaying = false;
            this.animatingNoSoundProgress = 0.0f;
            this.animatingDrawVideoImageButtonProgress = ((i4 == 4 || i4 == 2) && this.drawVideoSize) ? 1.0f : 0.0f;
        }
        if (this.documentAttachType == 5) {
            this.toSeekBarProgress = 0.0f;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1109:0x1624  */
    /* JADX WARN: Removed duplicated region for block: B:1122:0x164c  */
    /* JADX WARN: Removed duplicated region for block: B:1125:0x166e  */
    /* JADX WARN: Removed duplicated region for block: B:1136:0x168f  */
    /* JADX WARN: Removed duplicated region for block: B:1152:0x16cd  */
    /* JADX WARN: Removed duplicated region for block: B:1171:0x1701  */
    /* JADX WARN: Removed duplicated region for block: B:1174:0x1715  */
    /* JADX WARN: Removed duplicated region for block: B:1175:0x171c  */
    /* JADX WARN: Removed duplicated region for block: B:1193:0x174a  */
    /* JADX WARN: Removed duplicated region for block: B:1194:0x1751  */
    /* JADX WARN: Removed duplicated region for block: B:1197:0x175d  */
    /* JADX WARN: Removed duplicated region for block: B:1200:0x1767  */
    /* JADX WARN: Removed duplicated region for block: B:1205:0x1770  */
    /* JADX WARN: Removed duplicated region for block: B:1207:0x177c  */
    /* JADX WARN: Removed duplicated region for block: B:1251:0x183c  */
    /* JADX WARN: Removed duplicated region for block: B:1254:0x1841  */
    /* JADX WARN: Removed duplicated region for block: B:1258:0x1870  */
    /* JADX WARN: Removed duplicated region for block: B:1264:0x18a0  */
    /* JADX WARN: Removed duplicated region for block: B:1267:0x18e5  */
    /* JADX WARN: Removed duplicated region for block: B:1269:0x1909  */
    /* JADX WARN: Removed duplicated region for block: B:1363:0x1c12  */
    /* JADX WARN: Removed duplicated region for block: B:1367:0x1c43  */
    /* JADX WARN: Removed duplicated region for block: B:1369:0x1c47  */
    /* JADX WARN: Removed duplicated region for block: B:1397:0x1d82  */
    /* JADX WARN: Removed duplicated region for block: B:1455:0x1f58  */
    /* JADX WARN: Removed duplicated region for block: B:1456:0x1f5b  */
    /* JADX WARN: Removed duplicated region for block: B:1459:0x1f6e  */
    /* JADX WARN: Removed duplicated region for block: B:1461:0x1f77  */
    /* JADX WARN: Removed duplicated region for block: B:1484:0x2040  */
    /* JADX WARN: Removed duplicated region for block: B:1491:0x206b  */
    /* JADX WARN: Removed duplicated region for block: B:1494:0x2078  */
    /* JADX WARN: Removed duplicated region for block: B:1495:0x207c  */
    /* JADX WARN: Removed duplicated region for block: B:1560:0x21bb  */
    /* JADX WARN: Removed duplicated region for block: B:1579:0x2232  */
    /* JADX WARN: Removed duplicated region for block: B:1586:0x2268  */
    /* JADX WARN: Removed duplicated region for block: B:1589:0x226d  */
    /* JADX WARN: Removed duplicated region for block: B:1598:0x2292  */
    /* JADX WARN: Removed duplicated region for block: B:1610:0x22d0  */
    /* JADX WARN: Removed duplicated region for block: B:1611:0x22e0  */
    /* JADX WARN: Removed duplicated region for block: B:1627:0x2345  */
    /* JADX WARN: Removed duplicated region for block: B:1652:0x23c9  */
    /* JADX WARN: Removed duplicated region for block: B:1657:0x23d7  */
    /* JADX WARN: Removed duplicated region for block: B:1659:0x23db  */
    /* JADX WARN: Removed duplicated region for block: B:1666:0x2400  */
    /* JADX WARN: Removed duplicated region for block: B:1672:0x241e  */
    /* JADX WARN: Removed duplicated region for block: B:1679:0x242b  */
    /* JADX WARN: Removed duplicated region for block: B:1680:0x242e  */
    /* JADX WARN: Removed duplicated region for block: B:1705:0x2477  */
    /* JADX WARN: Removed duplicated region for block: B:1723:0x24cb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1724:0x24cd  */
    /* JADX WARN: Removed duplicated region for block: B:1732:0x24f3  */
    /* JADX WARN: Removed duplicated region for block: B:1739:0x2536  */
    /* JADX WARN: Removed duplicated region for block: B:1742:0x254a  */
    /* JADX WARN: Removed duplicated region for block: B:1743:0x254d  */
    /* JADX WARN: Removed duplicated region for block: B:1746:0x2557  */
    /* JADX WARN: Removed duplicated region for block: B:1749:0x255e  */
    /* JADX WARN: Removed duplicated region for block: B:1750:0x256f  */
    /* JADX WARN: Removed duplicated region for block: B:1756:0x2588  */
    /* JADX WARN: Removed duplicated region for block: B:1906:0x2883  */
    /* JADX WARN: Removed duplicated region for block: B:1958:0x29ad  */
    /* JADX WARN: Removed duplicated region for block: B:1962:0x29c4  */
    /* JADX WARN: Removed duplicated region for block: B:1969:0x29d9  */
    /* JADX WARN: Removed duplicated region for block: B:1971:0x29e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1973:0x29e5  */
    /* JADX WARN: Removed duplicated region for block: B:1979:0x2a0a  */
    /* JADX WARN: Removed duplicated region for block: B:1994:0x2a83  */
    /* JADX WARN: Removed duplicated region for block: B:2006:0x2ac6  */
    /* JADX WARN: Removed duplicated region for block: B:2007:0x2af1  */
    /* JADX WARN: Removed duplicated region for block: B:2010:0x2b0e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2014:0x2b15  */
    /* JADX WARN: Removed duplicated region for block: B:2021:0x2b24  */
    /* JADX WARN: Removed duplicated region for block: B:2042:0x2b54  */
    /* JADX WARN: Removed duplicated region for block: B:2045:0x2b5a  */
    /* JADX WARN: Removed duplicated region for block: B:2055:0x2c12  */
    /* JADX WARN: Removed duplicated region for block: B:2206:0x2fb4  */
    /* JADX WARN: Removed duplicated region for block: B:2213:0x2fd5  */
    /* JADX WARN: Removed duplicated region for block: B:2216:0x2fec  */
    /* JADX WARN: Removed duplicated region for block: B:2220:0x3003  */
    /* JADX WARN: Removed duplicated region for block: B:2223:0x3017  */
    /* JADX WARN: Removed duplicated region for block: B:2227:0x302b  */
    /* JADX WARN: Removed duplicated region for block: B:2231:0x303b  */
    /* JADX WARN: Removed duplicated region for block: B:2237:0x3049  */
    /* JADX WARN: Removed duplicated region for block: B:2258:0x30ba  */
    /* JADX WARN: Removed duplicated region for block: B:2281:0x3154 A[PHI: r2 r15
      0x3154: PHI (r2v319 char) = (r2v245 char), (r2v245 char), (r2v245 char), (r2v245 char), (r2v245 char), (r2v245 char), (r2v320 char) binds: [B:2261:0x30be, B:2279:0x314e, B:2263:0x30c9, B:2265:0x30cf, B:2275:0x3133, B:2269:0x30f9, B:2280:0x3152] A[DONT_GENERATE, DONT_INLINE]
      0x3154: PHI (r15v26 int) = (r15v14 int), (r15v14 int), (r15v14 int), (r15v14 int), (r15v14 int), (r15v14 int), (r15v27 int) binds: [B:2261:0x30be, B:2279:0x314e, B:2263:0x30c9, B:2265:0x30cf, B:2275:0x3133, B:2269:0x30f9, B:2280:0x3152] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2284:0x3159  */
    /* JADX WARN: Removed duplicated region for block: B:2286:0x315f  */
    /* JADX WARN: Removed duplicated region for block: B:2290:0x3168  */
    /* JADX WARN: Removed duplicated region for block: B:2296:0x3186  */
    /* JADX WARN: Removed duplicated region for block: B:2340:0x32b4  */
    /* JADX WARN: Removed duplicated region for block: B:2343:0x32bc  */
    /* JADX WARN: Removed duplicated region for block: B:2428:0x3621  */
    /* JADX WARN: Removed duplicated region for block: B:2431:0x362a  */
    /* JADX WARN: Removed duplicated region for block: B:2434:0x3635  */
    /* JADX WARN: Removed duplicated region for block: B:2441:0x3668  */
    /* JADX WARN: Removed duplicated region for block: B:2443:0x3670  */
    /* JADX WARN: Removed duplicated region for block: B:2491:0x36e9 A[PHI: r2 r4 r5 r6
      0x36e9: PHI (r2v271 int) = (r2v270 int), (r2v270 int), (r2v277 int) binds: [B:2476:0x36c9, B:2478:0x36cd, B:2489:0x36e5] A[DONT_GENERATE, DONT_INLINE]
      0x36e9: PHI (r4v212 int) = (r4v211 int), (r4v211 int), (r4v222 int) binds: [B:2476:0x36c9, B:2478:0x36cd, B:2489:0x36e5] A[DONT_GENERATE, DONT_INLINE]
      0x36e9: PHI (r5v204 int) = (r5v203 int), (r5v203 int), (r5v208 int) binds: [B:2476:0x36c9, B:2478:0x36cd, B:2489:0x36e5] A[DONT_GENERATE, DONT_INLINE]
      0x36e9: PHI (r6v182 int) = (r6v181 int), (r6v181 int), (r6v187 int) binds: [B:2476:0x36c9, B:2478:0x36cd, B:2489:0x36e5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2494:0x36ee  */
    /* JADX WARN: Removed duplicated region for block: B:2500:0x36fd  */
    /* JADX WARN: Removed duplicated region for block: B:2509:0x3715  */
    /* JADX WARN: Removed duplicated region for block: B:2512:0x371d  */
    /* JADX WARN: Removed duplicated region for block: B:2522:0x3757  */
    /* JADX WARN: Removed duplicated region for block: B:2525:0x375f  */
    /* JADX WARN: Removed duplicated region for block: B:2528:0x376b  */
    /* JADX WARN: Removed duplicated region for block: B:2536:0x3798  */
    /* JADX WARN: Removed duplicated region for block: B:2537:0x379a  */
    /* JADX WARN: Removed duplicated region for block: B:2541:0x37aa  */
    /* JADX WARN: Removed duplicated region for block: B:2561:0x0d40 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:2563:0x28d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:2577:0x30c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:546:0x0a7b  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0aa7  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x0ae0  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0af9  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x0b48  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0b4e  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0b66  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0b82  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0b8d  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x0c39  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0c3e  */
    /* JADX WARN: Removed duplicated region for block: B:655:0x0c57  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x0c5c  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0c7a  */
    /* JADX WARN: Removed duplicated region for block: B:673:0x0c89  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x0ceb  */
    /* JADX WARN: Removed duplicated region for block: B:688:0x0cf5  */
    /* JADX WARN: Removed duplicated region for block: B:700:0x0d28  */
    /* JADX WARN: Removed duplicated region for block: B:701:0x0d2a  */
    /* JADX WARN: Removed duplicated region for block: B:730:0x0de2  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x0de9  */
    /* JADX WARN: Removed duplicated region for block: B:786:0x0ee4 A[Catch: Exception -> 0x0f01, TryCatch #26 {Exception -> 0x0f01, blocks: (B:784:0x0ee0, B:787:0x0eeb, B:786:0x0ee4, B:781:0x0ed3), top: B:2598:0x0ee0 }] */
    /* JADX WARN: Removed duplicated region for block: B:811:0x0f53  */
    /* JADX WARN: Removed duplicated region for block: B:815:0x0f61  */
    /* JADX WARN: Removed duplicated region for block: B:817:0x0f6f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:841:0x1014  */
    /* JADX WARN: Removed duplicated region for block: B:843:0x1017  */
    /* JADX WARN: Removed duplicated region for block: B:864:0x107e A[Catch: Exception -> 0x114f, TryCatch #13 {Exception -> 0x114f, blocks: (B:844:0x1018, B:846:0x1023, B:848:0x1035, B:857:0x104d, B:861:0x1069, B:869:0x10a1, B:870:0x10b9, B:872:0x10c1, B:874:0x10cf, B:876:0x10d3, B:877:0x10d7, B:879:0x10df, B:880:0x10e2, B:881:0x10e9, B:883:0x10f1, B:885:0x10ff, B:887:0x1103, B:889:0x1108, B:896:0x1125, B:899:0x1130, B:902:0x1135, B:904:0x113e, B:906:0x1146, B:898:0x1129, B:892:0x110f, B:864:0x107e, B:868:0x1095), top: B:2574:0x1018 }] */
    /* JADX WARN: Removed duplicated region for block: B:911:0x1155  */
    /* JADX WARN: Removed duplicated region for block: B:920:0x116c  */
    /* JADX WARN: Removed duplicated region for block: B:922:0x1174  */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v572 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageContent(ir.eitaa.messenger.MessageObject r65, ir.eitaa.messenger.MessageObject.GroupedMessages r66, boolean r67, boolean r68) {
        /*
            Method dump skipped, instructions count: 14280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.setMessageContent(ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject$GroupedMessages, boolean, boolean):void");
    }

    public void checkVideoPlayback(boolean allowStart, Bitmap thumb) {
        if (this.currentMessageObject.isVideo()) {
            if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                this.photoImage.setAllowStartAnimation(false);
                this.photoImage.stopAnimation();
                return;
            } else {
                this.photoImage.setAllowStartAnimation(true);
                this.photoImage.startAnimation();
                return;
            }
        }
        if (allowStart) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            allowStart = playingMessageObject == null || !playingMessageObject.isRoundVideo();
        }
        this.photoImage.setAllowStartAnimation(allowStart);
        if (thumb != null) {
            this.photoImage.startCrossfadeFromStaticThumb(thumb);
        }
        if (allowStart) {
            this.photoImage.startAnimation();
        } else {
            this.photoImage.stopAnimation();
        }
    }

    @Override // ir.eitaa.ui.Cells.BaseCell
    protected boolean onLongPress() {
        int i;
        int i2;
        boolean zDidLongPressChannelAvatar = false;
        if (this.isRoundVideo && this.isPlayingRound && MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && ((this.lastTouchX - this.photoImage.getCenterX()) * (this.lastTouchX - this.photoImage.getCenterX())) + ((this.lastTouchY - this.photoImage.getCenterY()) * (this.lastTouchY - this.photoImage.getCenterY())) < (this.photoImage.getImageWidth() / 2.0f) * (this.photoImage.getImageWidth() / 2.0f) && (this.lastTouchX > this.photoImage.getCenterX() + (this.photoImage.getImageWidth() / 4.0f) || this.lastTouchX < this.photoImage.getCenterX() - (this.photoImage.getImageWidth() / 4.0f))) {
            boolean z = this.lastTouchX > this.photoImage.getCenterX();
            if (this.videoPlayerRewinder == null) {
                this.videoForwardDrawable = new VideoForwardDrawable(true);
                this.videoPlayerRewinder = new VideoPlayerRewinder() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.4
                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindCanceled() {
                        ExploreCell.this.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        ExploreCell.this.videoForwardDrawable.setShowing(false);
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void updateRewindProgressUi(long timeDiff, float progress, boolean rewindByBackSeek) {
                        ExploreCell.this.videoForwardDrawable.setTime(Math.abs(timeDiff));
                        if (rewindByBackSeek) {
                            ExploreCell.this.currentMessageObject.audioProgress = progress;
                            ExploreCell.this.updatePlayingMessageProgress();
                        }
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindStart(boolean rewindForward) {
                        ExploreCell.this.videoForwardDrawable.setDelegate(new VideoForwardDrawable.VideoForwardDrawableDelegate() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.4.1
                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void onAnimationEnd() {
                            }

                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void invalidate() {
                                ExploreCell.this.invalidate();
                            }
                        });
                        ExploreCell.this.videoForwardDrawable.setOneShootAnimation(false);
                        ExploreCell.this.videoForwardDrawable.setLeftSide(!rewindForward);
                        ExploreCell.this.videoForwardDrawable.setShowing(true);
                        ExploreCell.this.invalidate();
                    }
                };
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            this.videoPlayerRewinder.startRewind(MediaController.getInstance().getVideoPlayer(), z, MediaController.getInstance().getPlaybackSpeed(false));
            return false;
        }
        CharacterStyle characterStyle = this.pressedLink;
        if (characterStyle instanceof URLSpanMono) {
            this.delegate.didPressUrl(this, characterStyle, true);
            return true;
        }
        if (characterStyle instanceof URLSpanNoUnderline) {
            URLSpanNoUnderline uRLSpanNoUnderline = (URLSpanNoUnderline) characterStyle;
            if (ChatActivity.isClickableLink(uRLSpanNoUnderline.getURL()) || uRLSpanNoUnderline.getURL().startsWith("/")) {
                this.delegate.didPressUrl(this, this.pressedLink, true);
                return true;
            }
        } else if (characterStyle instanceof URLSpan) {
            this.delegate.didPressUrl(this, characterStyle, true);
            return true;
        }
        resetPressedLink(-1);
        if (this.buttonPressed != 0 || this.miniButtonPressed != 0 || this.videoButtonPressed != 0 || this.pressedBotButton != -1) {
            this.buttonPressed = 0;
            this.miniButtonPressed = 0;
            this.videoButtonPressed = 0;
            this.pressedBotButton = -1;
            invalidate();
        }
        this.linkPreviewPressed = false;
        this.sideButtonPressed = false;
        this.imagePressed = false;
        this.timePressed = false;
        this.gamePreviewPressed = false;
        if (this.pressedVoteButton != -1 || this.pollHintPressed || this.psaHintPressed || this.instantPressed || this.otherPressed || this.commentButtonPressed) {
            this.commentButtonPressed = false;
            this.instantButtonPressed = false;
            this.instantPressed = false;
            this.pressedVoteButton = -1;
            this.pollHintPressed = false;
            this.psaHintPressed = false;
            this.otherPressed = false;
            if (Build.VERSION.SDK_INT >= 21) {
                int i3 = 0;
                while (true) {
                    Drawable[] drawableArr = this.selectorDrawable;
                    if (i3 >= drawableArr.length) {
                        break;
                    }
                    if (drawableArr[i3] != null) {
                        drawableArr[i3].setState(StateSet.NOTHING);
                    }
                    i3++;
                }
            }
            invalidate();
        }
        ExploreCellDelegate exploreCellDelegate = this.delegate;
        if (exploreCellDelegate != null) {
            if (this.avatarPressed) {
                TLRPC$User tLRPC$User = this.currentUser;
                if (tLRPC$User == null) {
                    TLRPC$Chat tLRPC$Chat = this.currentChat;
                    if (tLRPC$Chat != null) {
                        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.currentMessageObject.messageOwner.fwd_from;
                        if (tLRPC$MessageFwdHeader != null) {
                            if ((tLRPC$MessageFwdHeader.flags & 16) != 0) {
                                i2 = tLRPC$MessageFwdHeader.saved_from_msg_id;
                            } else {
                                i2 = tLRPC$MessageFwdHeader.channel_post;
                            }
                            i = i2;
                        } else {
                            i = 0;
                        }
                        zDidLongPressChannelAvatar = exploreCellDelegate.didLongPressChannelAvatar(this, tLRPC$Chat, i, this.lastTouchX, this.lastTouchY);
                    }
                } else if (tLRPC$User.id != 0) {
                    zDidLongPressChannelAvatar = exploreCellDelegate.didLongPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
                }
            }
            if (!zDidLongPressChannelAvatar) {
                this.delegate.didLongPress(this, this.lastTouchX, this.lastTouchY);
            }
        }
        return true;
    }

    public void setInvalidatesParent(boolean value) {
        this.invalidatesParent = value;
    }

    @Override // android.view.View, ir.eitaa.ui.Cells.TextSelectionHelper.SelectableView
    public void invalidate() {
        if (this.currentMessageObject == null) {
            return;
        }
        super.invalidate();
        if (!this.invalidatesParent || getParent() == null) {
            return;
        }
        View view = (View) getParent();
        if (view.getParent() != null) {
            view.invalidate();
            ((View) view.getParent()).invalidate();
        }
    }

    @Override // android.view.View
    public void invalidate(int l, int t, int r, int b) {
        if (this.currentMessageObject == null) {
            return;
        }
        super.invalidate(l, t, r, b);
        if (!this.invalidatesParent || getParent() == null) {
            return;
        }
        ((View) getParent()).invalidate(((int) getX()) + l, ((int) getY()) + t, ((int) getX()) + r, ((int) getY()) + b);
    }

    public void setHighlighted(boolean value) {
        if (this.isHighlighted == value) {
            return;
        }
        this.isHighlighted = value;
        if (!value) {
            this.lastHighlightProgressTime = System.currentTimeMillis();
            this.isHighlightedAnimated = true;
            this.highlightProgress = 300;
        } else {
            this.isHighlightedAnimated = false;
            this.highlightProgress = 0;
        }
        updateRadialProgressBackground();
        if (this.useSeekBarWaweform) {
            this.seekBarWaveform.setSelected(isDrawSelectionBackground());
        } else {
            this.seekBar.setSelected(isDrawSelectionBackground());
        }
        invalidate();
        if (getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        updateRadialProgressBackground();
        if (this.useSeekBarWaweform) {
            this.seekBarWaveform.setSelected(isDrawSelectionBackground());
        } else {
            this.seekBar.setSelected(isDrawSelectionBackground());
        }
        invalidate();
    }

    private void updateRadialProgressBackground() {
        if (this.drawRadialCheckBackground) {
            return;
        }
        boolean z = true;
        boolean z2 = (this.isHighlighted || this.isPressed || isPressed()) && !(this.drawPhotoImage && this.photoImage.hasBitmapImage());
        this.radialProgress.setPressed(z2 || this.buttonPressed != 0, false);
        if (this.hasMiniProgress != 0) {
            this.radialProgress.setPressed(z2 || this.miniButtonPressed != 0, true);
        }
        RadialProgress2 radialProgress2 = this.videoRadialProgress;
        if (!z2 && this.videoButtonPressed == 0) {
            z = false;
        }
        radialProgress2.setPressed(z, false);
    }

    @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarDrag(float progress) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        messageObject.audioProgress = progress;
        MediaController.getInstance().seekToProgress(this.currentMessageObject, progress);
        updatePlayingMessageProgress();
    }

    @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarContinuousDrag(float progress) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        messageObject.audioProgress = progress;
        messageObject.audioProgressSec = (int) (messageObject.getDuration() * progress);
        updatePlayingMessageProgress();
    }

    private void updateWaveform() {
        if (this.currentMessageObject == null || this.documentAttachType != 3) {
            return;
        }
        for (int i = 0; i < this.documentAttach.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.documentAttach.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                byte[] bArr = tLRPC$DocumentAttribute.waveform;
                if (bArr == null || bArr.length == 0) {
                    MediaController.getInstance().generateWaveform(this.currentMessageObject);
                }
                byte[] bArr2 = tLRPC$DocumentAttribute.waveform;
                this.useSeekBarWaweform = bArr2 != null;
                this.seekBarWaveform.setWaveform(bArr2);
                return;
            }
        }
    }

    private int createDocumentLayout(int maxWidth, MessageObject messageObject) {
        int iMin;
        int i;
        if (messageObject.type == 0) {
            this.documentAttach = messageObject.messageOwner.media.webpage.document;
        } else {
            this.documentAttach = messageObject.getDocument();
        }
        TLRPC$Document tLRPC$Document = this.documentAttach;
        int i2 = 0;
        if (tLRPC$Document == null) {
            return 0;
        }
        if (MessageObject.isVoiceDocument(tLRPC$Document)) {
            this.documentAttachType = 3;
            int i3 = 0;
            while (true) {
                if (i3 >= this.documentAttach.attributes.size()) {
                    i = 0;
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.documentAttach.attributes.get(i3);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    i = tLRPC$DocumentAttribute.duration;
                    break;
                }
                i3++;
            }
            this.widthBeforeNewTimeLine = (maxWidth - AndroidUtilities.dp(94.0f)) - ((int) Math.ceil(Theme.chat_audioTimePaint.measureText("00:00")));
            this.availableTimeWidth = maxWidth - AndroidUtilities.dp(18.0f);
            measureTime(messageObject);
            int iDp = AndroidUtilities.dp(174.0f) + this.timeWidth;
            if (!this.hasLinkPreview) {
                this.backgroundWidth = Math.min(maxWidth, iDp + ((int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatLongDuration(i)))));
            }
            this.seekBarWaveform.setMessageObject(messageObject);
            return 0;
        }
        if (MessageObject.isMusicDocument(this.documentAttach)) {
            this.documentAttachType = 5;
            int parentWidth = getParentWidth() - (AndroidUtilities.dp(32.0f) + AndroidUtilities.dp(52.0f));
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(messageObject.getMusicTitle().replace('\n', ' '), Theme.chat_audioTitlePaint, parentWidth - AndroidUtilities.dp(12.0f), TextUtils.TruncateAt.END);
            if (Build.VERSION.SDK_INT >= 24) {
                this.songLayout = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, charSequenceEllipsize.length(), Theme.chat_audioTitlePaint, parentWidth).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).setMaxLines(2).setEllipsize(TextUtils.TruncateAt.END).build();
            } else {
                this.songLayout = new StaticLayout(charSequenceEllipsize, Theme.chat_audioTitlePaint, parentWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            if (this.songLayout.getLineCount() > 0) {
                this.songX = -((int) Math.ceil(this.songLayout.getLineLeft(0)));
            }
            StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicAuthor().replace('\n', ' '), Theme.chat_audioPerformerPaint, parentWidth, TextUtils.TruncateAt.END), Theme.chat_audioPerformerPaint, parentWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.performerLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.performerX = -((int) Math.ceil(this.performerLayout.getLineLeft(0)));
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.documentAttach.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.documentAttach.attributes.get(i4);
                if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                    i2 = tLRPC$DocumentAttribute2.duration;
                    break;
                }
                i4++;
            }
            int iCeil = (int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatShortDuration(i2, i2)));
            this.widthBeforeNewTimeLine = (this.backgroundWidth - AndroidUtilities.dp(86.0f)) - iCeil;
            this.availableTimeWidth = this.backgroundWidth - AndroidUtilities.dp(28.0f);
            return iCeil;
        }
        if (MessageObject.isVideoDocument(this.documentAttach)) {
            this.documentAttachType = 4;
            if (!messageObject.needDrawBluredPreview()) {
                updatePlayingMessageProgress();
            }
            return 0;
        }
        if (MessageObject.isGifDocument(this.documentAttach, messageObject.hasValidGroupId())) {
            this.documentAttachType = 2;
            if (!messageObject.needDrawBluredPreview()) {
                String string = LocaleController.getString("AttachGif", ir.eitaa.messenger.R.string.AttachGif);
                this.infoWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(string));
                this.infoLayout = new StaticLayout(string, Theme.chat_infoPaint, this.infoWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                String str = String.format("%s", AndroidUtilities.formatFileSize(this.documentAttach.size));
                this.docTitleWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(str));
                this.docTitleLayout = new StaticLayout(str, Theme.chat_infoPaint, this.docTitleWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return 0;
        }
        String str2 = this.documentAttach.mime_type;
        this.drawPhotoImage = (str2 != null && (str2.toLowerCase().startsWith("image/") || this.documentAttach.mime_type.toLowerCase().startsWith("video/mp4"))) || MessageObject.isDocumentHasThumb(this.documentAttach);
        int parentWidth2 = getParentWidth() - AndroidUtilities.dp(60.0f);
        if (this.drawPhotoImage) {
            parentWidth2 -= AndroidUtilities.dp(44.0f);
        }
        this.documentAttachType = 1;
        String documentFileName = FileLoader.getDocumentFileName(this.documentAttach);
        if (documentFileName.length() == 0) {
            documentFileName = LocaleController.getString("AttachDocument", ir.eitaa.messenger.R.string.AttachDocument);
        }
        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(documentFileName, Theme.chat_docNamePaint, parentWidth2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.MIDDLE, parentWidth2, 2, false);
        this.docTitleLayout = staticLayoutCreateStaticLayout;
        this.docTitleOffsetX = Integer.MIN_VALUE;
        if (staticLayoutCreateStaticLayout != null && staticLayoutCreateStaticLayout.getLineCount() > 0) {
            int iMax = 0;
            while (i2 < this.docTitleLayout.getLineCount()) {
                iMax = Math.max(iMax, (int) Math.ceil(this.docTitleLayout.getLineWidth(i2)));
                this.docTitleOffsetX = Math.max(this.docTitleOffsetX, (int) Math.ceil(-this.docTitleLayout.getLineLeft(i2)));
                i2++;
            }
            iMin = Math.min(parentWidth2, iMax);
        } else {
            this.docTitleOffsetX = 0;
            iMin = parentWidth2;
        }
        String str3 = AndroidUtilities.formatFileSize(this.documentAttach.size) + " " + FileLoader.getDocumentExtension(this.documentAttach);
        int iDp2 = parentWidth2 - AndroidUtilities.dp(30.0f);
        TextPaint textPaint = Theme.chat_infoPaint;
        int iMin2 = Math.min(iDp2, (int) Math.ceil(textPaint.measureText("000.0 mm / " + AndroidUtilities.formatFileSize(this.documentAttach.size))));
        this.infoWidth = iMin2;
        CharSequence charSequenceEllipsize2 = TextUtils.ellipsize(str3, Theme.chat_infoPaint, (float) iMin2, TextUtils.TruncateAt.END);
        try {
            if (this.infoWidth < 0) {
                this.infoWidth = AndroidUtilities.dp(10.0f);
            }
            this.infoLayout = new StaticLayout(charSequenceEllipsize2, Theme.chat_infoPaint, this.infoWidth + AndroidUtilities.dp(6.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.drawPhotoImage) {
            this.currentPhotoObject = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320);
            this.currentPhotoObjectThumb = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 40);
            if ((DownloadController.getInstance(this.currentAccount).getAutodownloadMask() & 1) == 0) {
                this.currentPhotoObject = null;
            }
            TLRPC$PhotoSize tLRPC$PhotoSize = this.currentPhotoObject;
            if (tLRPC$PhotoSize == null || tLRPC$PhotoSize == this.currentPhotoObjectThumb) {
                this.currentPhotoObject = null;
                this.photoImage.setNeedsQualityThumb(true);
                this.photoImage.setShouldGenerateQualityThumb(true);
            }
            this.currentPhotoFilter = "86_86_b";
            this.photoImage.setImage(ImageLocation.getForObject(this.currentPhotoObject, messageObject.photoThumbsObject), "86_86", ImageLocation.getForObject(this.currentPhotoObjectThumb, messageObject.photoThumbsObject), this.currentPhotoFilter, 0, null, messageObject, 1);
        }
        return iMin;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void calcBackgroundWidth(int r2, int r3, int r4) {
        /*
            r1 = this;
            boolean r4 = r1.hasLinkPreview
            if (r4 != 0) goto L1c
            boolean r4 = r1.hasOldCaptionPreview
            if (r4 != 0) goto L1c
            boolean r4 = r1.hasGamePreview
            if (r4 != 0) goto L1c
            boolean r4 = r1.hasInvoicePreview
            if (r4 != 0) goto L1c
            ir.eitaa.messenger.MessageObject r4 = r1.currentMessageObject
            int r0 = r4.lastLineWidth
            int r0 = r2 - r0
            if (r0 < r3) goto L1c
            boolean r3 = r4.hasRtl
            if (r3 == 0) goto L2a
        L1c:
            int r3 = r1.totalHeight
            r4 = 1096810496(0x41600000, float:14.0)
            int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
            int r3 = r3 + r4
            r1.totalHeight = r3
            r3 = 1
            r1.hasNewLineForTime = r3
        L2a:
            r1.backgroundWidth = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.calcBackgroundWidth(int, int, int):void");
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        if (!super.verifyDrawable(who)) {
            Drawable[] drawableArr = this.selectorDrawable;
            if (who != drawableArr[0] && who != drawableArr[1]) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (this.currentMessagesGroup == null || drawable != this.selectorDrawable[1]) {
            return;
        }
        invalidateWithParent();
    }

    private boolean isCurrentLocationTimeExpired(MessageObject messageObject) {
        return this.currentMessageObject.messageOwner.media.period % 60 == 0 ? Math.abs(ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - messageObject.messageOwner.date) > messageObject.messageOwner.media.period : Math.abs(ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - messageObject.messageOwner.date) > messageObject.messageOwner.media.period + (-5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLocationExpired() {
        boolean zIsCurrentLocationTimeExpired;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || (zIsCurrentLocationTimeExpired = isCurrentLocationTimeExpired(messageObject)) == this.locationExpired) {
            return;
        }
        this.locationExpired = zIsCurrentLocationTimeExpired;
        if (!zIsCurrentLocationTimeExpired) {
            AndroidUtilities.runOnUIThread(this.invalidateRunnable, 1000L);
            this.scheduledInvalidate = true;
            int iDp = this.backgroundWidth - AndroidUtilities.dp(91.0f);
            this.docTitleLayout = new StaticLayout(TextUtils.ellipsize(LocaleController.getString("AttachLiveLocation", ir.eitaa.messenger.R.string.AttachLiveLocation), Theme.chat_locationTitlePaint, iDp, TextUtils.TruncateAt.END), Theme.chat_locationTitlePaint, iDp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            return;
        }
        MessageObject messageObject2 = this.currentMessageObject;
        this.currentMessageObject = null;
        setMessageObject(messageObject2, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
    }

    public void setIsUpdating(boolean value) {
        this.isUpdating = true;
    }

    public void setMessageObject(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, boolean bottomNear, boolean topNear) {
        if (this.attachedToWindow) {
            setMessageContent(messageObject, groupedMessages, bottomNear, topNear);
            return;
        }
        this.messageObjectToSet = messageObject;
        this.groupedMessagesToSet = groupedMessages;
        this.bottomNearToSet = bottomNear;
        this.topNearToSet = topNear;
    }

    private int getAdditionalWidthForPosition(MessageObject.GroupedMessagePosition position) {
        if (position == null) {
            return 0;
        }
        int iDp = (position.flags & 2) == 0 ? 0 + AndroidUtilities.dp(4.0f) : 0;
        return (position.flags & 1) == 0 ? iDp + AndroidUtilities.dp(4.0f) : iDp;
    }

    public void createSelectorDrawable(final int num) {
        int themedColor;
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.psaHintPressed) {
            themedColor = getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outViews" : "chat_inViews");
        } else {
            themedColor = getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outPreviewInstantText" : "chat_inPreviewInstantText");
        }
        Drawable[] drawableArr = this.selectorDrawable;
        if (drawableArr[num] == null) {
            final Paint paint = new Paint(1);
            paint.setColor(-1);
            Drawable drawable = new Drawable() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.5
                RectF rect = new RectF();
                Path path = new Path();

                @Override // android.graphics.drawable.Drawable
                public int getOpacity() {
                    return -2;
                }

                @Override // android.graphics.drawable.Drawable
                public void setAlpha(int alpha) {
                }

                @Override // android.graphics.drawable.Drawable
                public void setColorFilter(ColorFilter colorFilter) {
                }

                /* JADX WARN: Removed duplicated region for block: B:35:0x00d9  */
                @Override // android.graphics.drawable.Drawable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void draw(android.graphics.Canvas r13) {
                    /*
                        Method dump skipped, instructions count: 349
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.AnonymousClass5.draw(android.graphics.Canvas):void");
                }
            };
            int[][] iArr = {StateSet.WILD_CARD};
            int[] iArr2 = new int[1];
            iArr2[0] = getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outPreviewInstantText" : "chat_inPreviewInstantText") & 436207615;
            this.selectorDrawable[num] = new RippleDrawable(new ColorStateList(iArr, iArr2), null, drawable);
            this.selectorDrawable[num].setCallback(this);
        } else {
            Theme.setSelectorDrawableColor(drawableArr[num], themedColor & 436207615, true);
        }
        this.selectorDrawable[num].setVisible(true, false);
    }

    private void createInstantViewButton() {
        String string;
        if (Build.VERSION.SDK_INT >= 21 && this.drawInstantView) {
            createSelectorDrawable(0);
        }
        if (this.drawInstantView && this.instantViewLayout == null) {
            this.instantWidth = AndroidUtilities.dp(33.0f);
            int i = this.drawInstantViewType;
            if (i == 1) {
                string = LocaleController.getString("OpenChannel", ir.eitaa.messenger.R.string.OpenChannel);
            } else if (i == 10) {
                string = LocaleController.getString("OpenBot", ir.eitaa.messenger.R.string.OpenBot);
            } else if (i == 2) {
                string = LocaleController.getString("OpenGroup", ir.eitaa.messenger.R.string.OpenGroup);
            } else if (i == 3) {
                string = LocaleController.getString("OpenMessage", ir.eitaa.messenger.R.string.OpenMessage);
            } else if (i == 5) {
                string = LocaleController.getString("ViewContact", ir.eitaa.messenger.R.string.ViewContact);
            } else if (i == 6) {
                string = LocaleController.getString("OpenBackground", ir.eitaa.messenger.R.string.OpenBackground);
            } else if (i == 7) {
                string = LocaleController.getString("OpenTheme", ir.eitaa.messenger.R.string.OpenTheme);
            } else if (i == 8) {
                if (this.pollVoted || this.pollClosed) {
                    string = LocaleController.getString("PollViewResults", ir.eitaa.messenger.R.string.PollViewResults);
                } else {
                    string = LocaleController.getString("PollSubmitVotes", ir.eitaa.messenger.R.string.PollSubmitVotes);
                }
            } else if (i == 9 || i == 11) {
                TLRPC$TL_webPage tLRPC$TL_webPage = (TLRPC$TL_webPage) this.currentMessageObject.messageOwner.media.webpage;
                if (tLRPC$TL_webPage != null && tLRPC$TL_webPage.url.contains("voicechat=")) {
                    string = LocaleController.getString("VoipGroupJoinAsSpeaker", ir.eitaa.messenger.R.string.VoipGroupJoinAsSpeaker);
                } else {
                    string = LocaleController.getString("VoipGroupJoinAsLinstener", ir.eitaa.messenger.R.string.VoipGroupJoinAsLinstener);
                }
            } else {
                string = LocaleController.getString("InstantView", ir.eitaa.messenger.R.string.InstantView);
            }
            int iDp = this.backgroundWidth - AndroidUtilities.dp(75.0f);
            this.instantViewLayout = new StaticLayout(TextUtils.ellipsize(string, Theme.chat_instantViewPaint, iDp, TextUtils.TruncateAt.END), Theme.chat_instantViewPaint, iDp + AndroidUtilities.dp(2.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (this.drawInstantViewType == 8) {
                this.instantWidth = this.backgroundWidth - AndroidUtilities.dp(13.0f);
            } else {
                this.instantWidth = this.backgroundWidth - AndroidUtilities.dp(34.0f);
            }
            int iDp2 = this.totalHeight + AndroidUtilities.dp(46.0f);
            this.totalHeight = iDp2;
            if (this.currentMessageObject.type == 12) {
                this.totalHeight = iDp2 + AndroidUtilities.dp(14.0f);
            }
            StaticLayout staticLayout = this.instantViewLayout;
            if (staticLayout == null || staticLayout.getLineCount() <= 0) {
                return;
            }
            double d = this.instantWidth;
            double dCeil = Math.ceil(this.instantViewLayout.getLineWidth(0));
            Double.isNaN(d);
            this.instantTextX = (((int) (d - dCeil)) / 2) + (this.drawInstantViewType == 0 ? AndroidUtilities.dp(8.0f) : 0);
            int lineLeft = (int) this.instantViewLayout.getLineLeft(0);
            this.instantTextLeftX = lineLeft;
            this.instantTextX += -lineLeft;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.inLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && (messageObject.checkLayout() || this.lastHeight != AndroidUtilities.displaySize.y)) {
            this.inLayout = true;
            MessageObject messageObject2 = this.currentMessageObject;
            this.currentMessageObject = null;
            setMessageObject(messageObject2, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
            this.inLayout = false;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.totalHeight + this.keyboardHeight);
    }

    private int getGroupPhotosWidth() {
        int parentWidth = getParentWidth();
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && messageObject.preview) {
            parentWidth = this.parentWidth;
        }
        if (AndroidUtilities.isInMultiwindow || !AndroidUtilities.isTablet()) {
            return parentWidth;
        }
        if (AndroidUtilities.isSmallTablet() && getResources().getConfiguration().orientation != 2) {
            return parentWidth;
        }
        int iDp = (parentWidth / 100) * 35;
        if (iDp < AndroidUtilities.dp(320.0f)) {
            iDp = AndroidUtilities.dp(320.0f);
        }
        return parentWidth - iDp;
    }

    private int getExtraTextX() {
        int i = SharedConfig.bubbleRadius;
        if (i >= 15) {
            return AndroidUtilities.dp(2.0f);
        }
        if (i >= 11) {
            return AndroidUtilities.dp(1.0f);
        }
        return 0;
    }

    private int getExtraTimeX() {
        int i;
        if (!this.currentMessageObject.isOutOwner() && ((!this.mediaBackground || this.captionLayout != null) && (i = SharedConfig.bubbleRadius) > 11)) {
            return AndroidUtilities.dp((i - 11) / 1.5f);
        }
        if (!this.currentMessageObject.isOutOwner() && this.isPlayingRound && this.isAvatarVisible && this.currentMessageObject.type == 5) {
            return (int) ((AndroidUtilities.roundPlayingMessageSize - AndroidUtilities.roundMessageSize) * 0.7f);
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int i2;
        int iDp;
        int iDp2;
        int iDp3;
        int iDp4;
        int i3;
        int iDp5;
        int iDp6;
        if (this.currentMessageObject == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
        if (this.lastSize != measuredHeight || !this.wasLayout) {
            this.layoutWidth = getMeasuredWidth();
            this.layoutHeight = getMeasuredHeight() - this.substractBackgroundHeight;
            if (this.timeTextWidth < 0) {
                this.timeTextWidth = AndroidUtilities.dp(10.0f);
            }
            this.timeLayout = new StaticLayout(this.currentTimeString, Theme.chat_timePaint, this.timeTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (this.mediaBackground) {
                if (this.currentMessageObject.isOutOwner()) {
                    this.timeX = (this.layoutWidth - this.timeWidth) - AndroidUtilities.dp(42.0f);
                } else {
                    this.timeX = (this.backgroundWidth - AndroidUtilities.dp(4.0f)) - this.timeWidth;
                    if (this.currentMessageObject.isAnyKindOfSticker()) {
                        this.timeX = Math.max(AndroidUtilities.dp(26.0f), this.timeX);
                    }
                    if (this.isAvatarVisible) {
                        this.timeX += AndroidUtilities.dp(48.0f);
                    }
                    MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
                    if (groupedMessagePosition != null && (i = groupedMessagePosition.leftSpanOffset) != 0) {
                        this.timeX += (int) Math.ceil((i / 1000.0f) * getGroupPhotosWidth());
                    }
                    if (this.captionLayout != null && this.currentPosition != null) {
                        this.timeX += AndroidUtilities.dp(4.0f);
                    }
                }
                if (SharedConfig.bubbleRadius >= 10 && this.captionLayout == null && (i2 = this.documentAttachType) != 7 && i2 != 6) {
                    this.timeX -= AndroidUtilities.dp(2.0f);
                }
            } else if (this.currentMessageObject.isOutOwner()) {
                this.timeX = (this.layoutWidth - this.timeWidth) - AndroidUtilities.dp(38.5f);
            } else {
                this.timeX = (this.backgroundWidth - AndroidUtilities.dp(9.0f)) - this.timeWidth;
                if (this.currentMessageObject.isAnyKindOfSticker()) {
                    this.timeX = Math.max(0, this.timeX);
                }
                if (this.isAvatarVisible) {
                    this.timeX += AndroidUtilities.dp(48.0f);
                }
                if (shouldDrawTimeOnMedia()) {
                    this.timeX -= AndroidUtilities.dp(7.0f);
                }
            }
            this.timeX -= getExtraTimeX();
            if ((this.currentMessageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                this.viewsLayout = new StaticLayout(this.currentViewsString, Theme.chat_timePaint, this.viewsTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            } else {
                this.viewsLayout = null;
            }
            if (this.currentRepliesString != null && !this.currentMessageObject.scheduled) {
                this.repliesLayout = new StaticLayout(this.currentRepliesString, Theme.chat_timePaint, this.repliesTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            } else {
                this.repliesLayout = null;
            }
            if (this.isAvatarVisible) {
                this.avatarImage.setImageCoords(AndroidUtilities.dp(6.0f), this.avatarImage.getImageY(), AndroidUtilities.dp(42.0f), AndroidUtilities.dp(42.0f));
            }
            this.wasLayout = true;
        }
        this.lastSize = measuredHeight;
        if (this.currentMessageObject.type == 0) {
            this.textY = AndroidUtilities.dp(10.0f) + this.namesOffset;
        }
        if (this.isRoundVideo) {
            updatePlayingMessageProgress();
        }
        int i4 = this.documentAttachType;
        if (i4 == 3) {
            if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                this.seekBarX = AndroidUtilities.dp(114.0f);
                this.buttonX = AndroidUtilities.dp(71.0f);
                this.timeAudioX = AndroidUtilities.dp(124.0f);
            } else {
                this.seekBarX = AndroidUtilities.dp(66.0f);
                this.buttonX = AndroidUtilities.dp(23.0f);
                this.timeAudioX = AndroidUtilities.dp(76.0f);
            }
            if (this.hasLinkPreview) {
                this.seekBarX += AndroidUtilities.dp(10.0f);
                this.buttonX += AndroidUtilities.dp(10.0f);
                this.timeAudioX += AndroidUtilities.dp(10.0f);
            }
            this.seekBarWaveform.setSize(this.backgroundWidth - AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 92), AndroidUtilities.dp(30.0f));
            this.seekBar.setSize(this.backgroundWidth - AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 72), AndroidUtilities.dp(30.0f));
            this.seekBarY = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            int iDp7 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp7;
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i5 = this.buttonX;
            radialProgress2.setProgressRect(i5, iDp7, AndroidUtilities.dp(44.0f) + i5, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i4 == 5) {
            this.seekBarX = AndroidUtilities.dp(58.0f);
            this.buttonX = AndroidUtilities.dp(16.0f);
            this.timeAudioX = AndroidUtilities.dp(69.0f);
            if (this.hasLinkPreview) {
                this.seekBarX += AndroidUtilities.dp(10.0f);
                this.buttonX += AndroidUtilities.dp(10.0f);
                this.timeAudioX += AndroidUtilities.dp(10.0f);
            }
            this.seekBar.setSize(this.backgroundWidth - AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 65), AndroidUtilities.dp(30.0f));
            this.seekBarY = AndroidUtilities.dp(29.0f) + this.namesOffset + this.mediaOffsetY;
            int iDp8 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp8;
            RadialProgress2 radialProgress22 = this.radialProgress;
            int i6 = this.buttonX;
            radialProgress22.setProgressRect(i6, iDp8, AndroidUtilities.dp(44.0f) + i6, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i4 == 1 && !this.drawPhotoImage) {
            int iDp9 = AndroidUtilities.dp(8.0f);
            this.buttonX = iDp9;
            if (this.hasLinkPreview) {
                this.buttonX = iDp9 + AndroidUtilities.dp(10.0f);
            }
            int iDp10 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp10;
            RadialProgress2 radialProgress23 = this.radialProgress;
            int i7 = this.buttonX;
            radialProgress23.setProgressRect(i7, iDp10, AndroidUtilities.dp(44.0f) + i7, this.buttonY + AndroidUtilities.dp(44.0f));
            this.photoImage.setImageCoords(this.buttonX - AndroidUtilities.dp(10.0f), this.buttonY - AndroidUtilities.dp(10.0f), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        int i8 = messageObject.type;
        if (i8 == 12) {
            if (messageObject.isOutOwner()) {
                iDp6 = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                iDp6 = AndroidUtilities.dp(72.0f);
            } else {
                iDp6 = AndroidUtilities.dp(23.0f);
            }
            this.photoImage.setImageCoords(iDp6, AndroidUtilities.dp(13.0f) + this.namesOffset, AndroidUtilities.dp(44.0f), AndroidUtilities.dp(44.0f));
            return;
        }
        if (i8 == 0 && (this.hasLinkPreview || this.hasGamePreview || this.hasInvoicePreview)) {
            if (this.hasGamePreview) {
                iDp3 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    i3 = this.unmovedTextX;
                    iDp5 = AndroidUtilities.dp(1.0f);
                } else {
                    i3 = this.unmovedTextX;
                    iDp5 = AndroidUtilities.dp(1.0f);
                }
                iDp3 = i3 + iDp5;
            }
            if (this.isSmallImage) {
                iDp = iDp3 + this.backgroundWidth;
                iDp2 = AndroidUtilities.dp(81.0f);
                iDp -= iDp2;
            } else {
                iDp4 = this.hasInvoicePreview ? -AndroidUtilities.dp(6.3f) : AndroidUtilities.dp(10.0f);
                iDp = iDp3 + iDp4;
            }
        } else {
            if (messageObject.isOutOwner()) {
                if (this.mediaBackground) {
                    iDp = this.layoutWidth - this.backgroundWidth;
                    iDp2 = AndroidUtilities.dp(3.0f);
                } else {
                    iDp3 = this.layoutWidth - this.backgroundWidth;
                    iDp4 = AndroidUtilities.dp(6.0f);
                    iDp = iDp3 + iDp4;
                }
            } else {
                if (this.isChat && this.isAvatarVisible && !this.isPlayingRound) {
                    iDp = AndroidUtilities.dp(63.0f);
                } else {
                    iDp = AndroidUtilities.dp(15.0f);
                }
                MessageObject.GroupedMessagePosition groupedMessagePosition2 = this.currentPosition;
                if (groupedMessagePosition2 != null && !groupedMessagePosition2.edge) {
                    iDp2 = AndroidUtilities.dp(10.0f);
                }
            }
            iDp -= iDp2;
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition3 = this.currentPosition;
        if (groupedMessagePosition3 != null) {
            if ((groupedMessagePosition3.flags & 1) == 0) {
                iDp -= AndroidUtilities.dp(2.0f);
            }
            if (this.currentPosition.leftSpanOffset != 0) {
                iDp += (int) Math.ceil((r3 / 1000.0f) * getGroupPhotosWidth());
            }
        }
        if (this.currentMessageObject.type != 0) {
            iDp -= AndroidUtilities.dp(12.0f);
        }
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.imageChangeBoundsTransition || transitionParams.updatePhotoImageX) {
            transitionParams.updatePhotoImageX = false;
            ImageReceiver imageReceiver = this.photoImage;
            imageReceiver.setImageCoords(0.0f, imageReceiver.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
        }
        this.buttonX = (int) (iDp + ((this.photoImage.getImageWidth() - AndroidUtilities.dp(48.0f)) / 2.0f));
        int imageY = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - AndroidUtilities.dp(48.0f)) / 2.0f));
        this.buttonY = imageY;
        RadialProgress2 radialProgress24 = this.radialProgress;
        int i9 = this.buttonX;
        radialProgress24.setProgressRect(i9, imageY, AndroidUtilities.dp(48.0f) + i9, this.buttonY + AndroidUtilities.dp(48.0f));
        this.deleteProgressRect.set(this.buttonX + AndroidUtilities.dp(5.0f), this.buttonY + AndroidUtilities.dp(5.0f), this.buttonX + AndroidUtilities.dp(43.0f), this.buttonY + AndroidUtilities.dp(43.0f));
        int i10 = this.documentAttachType;
        if (i10 == 4 || i10 == 2) {
            this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
            int imageY2 = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
            this.videoButtonY = imageY2;
            RadialProgress2 radialProgress25 = this.videoRadialProgress;
            int i11 = this.videoButtonX;
            radialProgress25.setProgressRect(i11, imageY2, AndroidUtilities.dp(16.0f) + i11, this.videoButtonY + AndroidUtilities.dp(16.0f));
        }
    }

    private void drawContent(Canvas canvas) {
        String str;
        ViewGroup viewGroup;
        float fDp;
        int iDp;
        int i;
        StaticLayout staticLayout;
        int imageX;
        int iDp2;
        int iDp3;
        MessageObject.GroupedMessages groupedMessages;
        AudioVisualizerDrawable animatedOutAudioVisualizerDrawable;
        float f;
        float f2;
        MessageObject messageObject;
        if (this.needNewVisiblePart && this.currentMessageObject.type == 0) {
            getLocalVisibleRect(this.scrollRect);
            Rect rect = this.scrollRect;
            int i2 = rect.top;
            setVisiblePart(i2, rect.bottom - i2, this.parentHeight, this.parentViewTopOffset, this.viewTop, this.parentWidth, this.backgroundHeight);
            this.needNewVisiblePart = false;
        }
        float f3 = this.buttonX;
        float f4 = this.buttonY;
        if (this.transitionParams.animateButton) {
            float f5 = this.transitionParams.animateFromButtonX;
            TransitionParams transitionParams = this.transitionParams;
            float f6 = transitionParams.animateChangeProgress;
            f3 = (f5 * (1.0f - f6)) + (this.buttonX * f6);
            float f7 = transitionParams.animateFromButtonY;
            float f8 = this.transitionParams.animateChangeProgress;
            f4 = (f7 * (1.0f - f8)) + (this.buttonY * f8);
            int i3 = (int) f3;
            int i4 = (int) f4;
            this.radialProgress.setProgressRect(i3, i4, AndroidUtilities.dp(44.0f) + i3, AndroidUtilities.dp(44.0f) + i4);
        }
        float f9 = f4;
        TransitionParams transitionParams2 = this.transitionParams;
        if (transitionParams2.animateBackgroundBoundsInner && this.documentAttachType == 3) {
            int i5 = (int) ((this.backgroundWidth - transitionParams2.deltaLeft) + transitionParams2.deltaRight);
            this.seekBarWaveform.setSize(i5 - AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 92), AndroidUtilities.dp(30.0f));
            this.seekBar.setSize(i5 - AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 72), AndroidUtilities.dp(30.0f));
        }
        this.forceNotDrawTime = this.currentMessagesGroup != null;
        this.photoImage.setPressed(((this.isHighlightedAnimated || this.isHighlighted) && this.currentPosition != null) ? 2 : 0);
        this.photoImage.setVisible((PhotoViewer.isShowingImage(this.currentMessageObject) || SecretMediaViewer.getInstance().isShowingImage(this.currentMessageObject)) ? false : true, false);
        if (!this.photoImage.getVisible()) {
            this.mediaWasInvisible = true;
            this.timeWasInvisible = true;
            int i6 = this.animatingNoSound;
            if (i6 == 1) {
                this.animatingNoSoundProgress = 0.0f;
                this.animatingNoSound = 0;
            } else if (i6 == 2) {
                this.animatingNoSoundProgress = 1.0f;
                this.animatingNoSound = 0;
            }
        } else if (this.groupPhotoInvisible) {
            this.timeWasInvisible = true;
        } else {
            boolean z = this.mediaWasInvisible;
            if (z || this.timeWasInvisible) {
                if (z) {
                    this.controlsAlpha = 0.0f;
                    this.mediaWasInvisible = false;
                }
                if (this.timeWasInvisible) {
                    this.timeAlpha = 0.0f;
                    this.timeWasInvisible = false;
                }
                this.lastControlsAlphaChangeTime = System.currentTimeMillis();
                this.totalChangeTime = 0L;
            }
        }
        this.radialProgress.setProgressColor(getThemedColor("chat_mediaProgress"));
        this.videoRadialProgress.setProgressColor(getThemedColor("chat_mediaProgress"));
        this.imageDrawn = false;
        this.radialProgress.setCircleCrossfadeColor(null, 0.0f, 1.0f);
        MessageObject messageObject2 = this.currentMessageObject;
        if (messageObject2.type == 0) {
            if (messageObject2.isOutOwner()) {
                this.textX = getCurrentBackgroundLeft() + AndroidUtilities.dp(11.0f) + getExtraTextX();
            } else {
                this.textX = getCurrentBackgroundLeft() + AndroidUtilities.dp((this.mediaBackground || !this.drawPinnedBottom) ? 17.0f : 11.0f) + getExtraTextX();
            }
            if (this.hasGamePreview) {
                this.textX += AndroidUtilities.dp(11.0f);
                int iDp4 = AndroidUtilities.dp(14.0f) + this.namesOffset;
                this.textY = iDp4;
                StaticLayout staticLayout2 = this.siteNameLayout;
                if (staticLayout2 != null) {
                    this.textY = iDp4 + staticLayout2.getLineBottom(staticLayout2.getLineCount() - 1);
                }
            } else if (this.hasInvoicePreview) {
                int iDp5 = AndroidUtilities.dp(14.0f) + this.namesOffset;
                this.textY = iDp5;
                StaticLayout staticLayout3 = this.siteNameLayout;
                if (staticLayout3 != null) {
                    this.textY = iDp5 + staticLayout3.getLineBottom(staticLayout3.getLineCount() - 1);
                }
            } else {
                this.textY = AndroidUtilities.dp(10.0f) + this.namesOffset;
            }
            this.unmovedTextX = this.textX;
            if (this.currentMessageObject.textXOffset != 0.0f && this.replyNameLayout != null) {
                int iDp6 = this.backgroundWidth - AndroidUtilities.dp(31.0f);
                MessageObject messageObject3 = this.currentMessageObject;
                int iDp7 = iDp6 - messageObject3.textWidth;
                if (!this.hasNewLineForTime) {
                    iDp7 -= this.timeWidth + AndroidUtilities.dp((messageObject3.isOutOwner() ? 20 : 0) + 4);
                }
                if (iDp7 > 0) {
                    this.textX += iDp7 - getExtraTimeX();
                }
            }
            if (this.enterTransitionInPorgress || (messageObject = this.currentMessageObject) == null || messageObject.preview) {
                str = "chat_mediaProgress";
            } else {
                TransitionParams transitionParams3 = this.transitionParams;
                if (transitionParams3.animateChangeProgress != 1.0f && transitionParams3.animateMessageText) {
                    canvas.save();
                    Theme.MessageDrawable messageDrawable = this.currentBackgroundDrawable;
                    if (messageDrawable != null) {
                        Rect bounds = messageDrawable.getBounds();
                        if (this.currentMessageObject.isOutOwner() && !this.mediaBackground && !this.pinnedBottom) {
                            canvas.clipRect(bounds.left + AndroidUtilities.dp(4.0f), bounds.top + AndroidUtilities.dp(4.0f), bounds.right - AndroidUtilities.dp(10.0f), bounds.bottom - AndroidUtilities.dp(4.0f));
                        } else {
                            canvas.clipRect(bounds.left + AndroidUtilities.dp(4.0f), bounds.top + AndroidUtilities.dp(4.0f), bounds.right - AndroidUtilities.dp(4.0f), bounds.bottom - AndroidUtilities.dp(4.0f));
                        }
                    }
                    str = "chat_mediaProgress";
                    drawMessageText(canvas, this.transitionParams.animateOutTextBlocks, false, 1.0f - this.transitionParams.animateChangeProgress, false);
                    drawMessageText(canvas, this.currentMessageObject.textLayoutBlocks, true, this.transitionParams.animateChangeProgress, false);
                    canvas.restore();
                } else {
                    str = "chat_mediaProgress";
                    drawMessageText(canvas, messageObject.textLayoutBlocks, true, 1.0f, false);
                }
            }
            if (!this.enterTransitionInPorgress || this.currentMessageObject.isVoice()) {
                drawLinkPreview(canvas, 1.0f);
            }
            this.drawTime = true;
        } else {
            str = "chat_mediaProgress";
            if (this.drawPhotoImage) {
                if (this.isRoundVideo && MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && MediaController.getInstance().isVideoDrawingReady() && canvas.isHardwareAccelerated()) {
                    this.imageDrawn = true;
                    this.drawTime = true;
                } else {
                    int i7 = this.currentMessageObject.type;
                    if (i7 == 5 && Theme.chat_roundVideoShadow != null) {
                        float imageX2 = this.photoImage.getImageX();
                        float imageY = this.photoImage.getImageY();
                        Theme.chat_roundVideoShadow.setAlpha(255);
                        Theme.chat_roundVideoShadow.setBounds((int) imageX2, (int) imageY, (int) (imageX2 + this.photoImage.getImageWidth() + AndroidUtilities.dp(6.0f)), (int) (imageY + this.photoImage.getImageHeight() + AndroidUtilities.dp(6.0f)));
                        Theme.chat_roundVideoShadow.draw(canvas);
                        if (!this.photoImage.hasBitmapImage() || this.photoImage.getCurrentAlpha() != 1.0f) {
                            Theme.chat_docBackPaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outBubble" : "chat_inBubble"));
                            canvas.drawCircle(this.photoImage.getCenterX(), this.photoImage.getCenterY(), this.photoImage.getImageWidth() / 2.0f, Theme.chat_docBackPaint);
                        }
                    } else if (i7 == 4) {
                        this.rect.set(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX2(), this.photoImage.getImageY2());
                        Theme.chat_docBackPaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outLocationBackground" : "chat_inLocationBackground"));
                        int[] roundRadius = this.photoImage.getRoundRadius();
                        this.rectPath.reset();
                        for (int i8 = 0; i8 < roundRadius.length; i8++) {
                            float[] fArr = radii;
                            int i9 = i8 * 2;
                            float f10 = roundRadius[i8];
                            fArr[i9 + 1] = f10;
                            fArr[i9] = f10;
                        }
                        this.rectPath.addRoundRect(this.rect, radii, Path.Direction.CW);
                        this.rectPath.close();
                        canvas.drawPath(this.rectPath, Theme.chat_docBackPaint);
                        Drawable drawable = Theme.chat_locationDrawable[this.currentMessageObject.isOutOwner() ? 1 : 0];
                        BaseCell.setDrawableBounds(drawable, this.rect.centerX() - (drawable.getIntrinsicWidth() / 2), this.rect.centerY() - (drawable.getIntrinsicHeight() / 2));
                        drawable.draw(canvas);
                    }
                    CheckBoxBase checkBoxBase = this.mediaCheckBox;
                    boolean z2 = checkBoxBase != null && (this.checkBoxVisible || checkBoxBase.getProgress() != 0.0f || this.checkBoxAnimationInProgress) && this.currentMessagesGroup != null;
                    this.drawMediaCheckBox = z2;
                    if (z2 && ((this.mediaCheckBox.isChecked() || this.mediaCheckBox.getProgress() != 0.0f || this.checkBoxAnimationInProgress) && !textIsSelectionMode())) {
                        if (!this.currentMessagesGroup.isDocuments) {
                            Theme.chat_replyLinePaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outBubbleSelected" : "chat_inBubbleSelected"));
                            this.rect.set(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX2(), this.photoImage.getImageY2());
                            int[] roundRadius2 = this.photoImage.getRoundRadius();
                            this.rectPath.reset();
                            for (int i10 = 0; i10 < roundRadius2.length; i10++) {
                                float[] fArr2 = radii;
                                int i11 = i10 * 2;
                                float f11 = roundRadius2[i10];
                                fArr2[i11 + 1] = f11;
                                fArr2[i11] = f11;
                            }
                            this.rectPath.addRoundRect(this.rect, radii, Path.Direction.CW);
                            this.rectPath.close();
                            canvas.drawPath(this.rectPath, Theme.chat_replyLinePaint);
                        }
                        this.photoImage.setSideClip(AndroidUtilities.dp(14.0f) * this.mediaCheckBox.getProgress());
                        if (this.checkBoxAnimationInProgress) {
                            this.mediaCheckBox.setBackgroundAlpha(this.checkBoxAnimationProgress);
                        } else {
                            CheckBoxBase checkBoxBase2 = this.mediaCheckBox;
                            checkBoxBase2.setBackgroundAlpha(this.checkBoxVisible ? 1.0f : checkBoxBase2.getProgress());
                        }
                    } else {
                        this.photoImage.setSideClip(0.0f);
                    }
                    ExploreCellDelegate exploreCellDelegate = this.delegate;
                    if (exploreCellDelegate == null || exploreCellDelegate.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
                        this.imageDrawn = this.photoImage.draw(canvas);
                    }
                    boolean z3 = this.drawTime;
                    boolean visible = this.photoImage.getVisible();
                    this.drawTime = visible;
                    if (this.currentPosition != null && z3 != visible && (viewGroup = (ViewGroup) getParent()) != null) {
                        if (!this.currentPosition.last) {
                            int childCount = viewGroup.getChildCount();
                            for (int i12 = 0; i12 < childCount; i12++) {
                                View childAt = viewGroup.getChildAt(i12);
                                if (childAt != this && (childAt instanceof ExploreCell)) {
                                    ExploreCell exploreCell = (ExploreCell) childAt;
                                    if (exploreCell.getCurrentMessagesGroup() == this.currentMessagesGroup) {
                                        MessageObject.GroupedMessagePosition currentPosition = exploreCell.getCurrentPosition();
                                        if (currentPosition.last && currentPosition.maxY == this.currentPosition.maxY && (exploreCell.timeX - AndroidUtilities.dp(4.0f)) + exploreCell.getLeft() < getRight()) {
                                            exploreCell.groupPhotoInvisible = !this.drawTime;
                                            exploreCell.invalidate();
                                            viewGroup.invalidate();
                                        }
                                    }
                                }
                            }
                        } else {
                            viewGroup.invalidate();
                        }
                    }
                }
            } else {
                int i13 = this.documentAttachType;
                if (i13 == 5 || i13 == 1) {
                    CheckBoxBase checkBoxBase3 = this.mediaCheckBox;
                    boolean z4 = checkBoxBase3 != null && (this.checkBoxVisible || checkBoxBase3.getProgress() != 0.0f || this.checkBoxAnimationInProgress) && this.currentMessagesGroup != null;
                    this.drawMediaCheckBox = z4;
                    if (z4) {
                        this.radialProgress.setCircleCrossfadeColor(this.currentMessageObject.isOutOwner() ? "chat_outTimeText" : "chat_inTimeText", this.checkBoxAnimationProgress, 1.0f - this.mediaCheckBox.getProgress());
                    }
                    if (this.drawMediaCheckBox && !textIsSelectionMode() && (this.mediaCheckBox.isChecked() || this.mediaCheckBox.getProgress() != 0.0f || this.checkBoxAnimationInProgress)) {
                        if (this.checkBoxAnimationInProgress) {
                            this.mediaCheckBox.setBackgroundAlpha(this.checkBoxAnimationProgress);
                            if (this.radialProgress.getMiniIcon() == 4) {
                                this.radialProgress.setMiniIconScale(this.checkBoxAnimationProgress);
                            }
                        } else {
                            CheckBoxBase checkBoxBase4 = this.mediaCheckBox;
                            checkBoxBase4.setBackgroundAlpha(this.checkBoxVisible ? 1.0f : checkBoxBase4.getProgress());
                        }
                    } else {
                        CheckBoxBase checkBoxBase5 = this.mediaCheckBox;
                        if (checkBoxBase5 != null) {
                            checkBoxBase5.setBackgroundAlpha(1.0f);
                        }
                    }
                }
            }
        }
        int i14 = this.documentAttachType;
        if (i14 != 2) {
            if (i14 == 5) {
                Theme.chat_audioTitlePaint.setColor(getThemedColor("chat_inAudioTitleText"));
                Theme.chat_audioPerformerPaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_inAudioPerfomerSelectedText" : "chat_inAudioPerfomerText"));
                Theme.chat_audioTimePaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_inAudioDurationSelectedText" : "chat_inAudioDurationText"));
                this.radialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.buttonPressed != 0) ? "chat_inAudioSelectedProgress" : "chat_inAudioProgress"));
                this.radialProgress.setBackgroundDrawable(isDrawSelectionBackground() ? this.currentBackgroundSelectedDrawable : this.currentBackgroundDrawable);
                this.radialProgress.draw(canvas);
                canvas.save();
                canvas.translate(this.timeAudioX + this.songX, AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY);
                this.songLayout.draw(canvas);
                canvas.restore();
                float f12 = this.toSeekBarProgress;
                if (f12 != 0.0f) {
                    float f13 = f12 - 0.16f;
                    this.toSeekBarProgress = f13;
                    if (f13 < 0.0f) {
                        this.toSeekBarProgress = 0.0f;
                    }
                    invalidate();
                }
                float f14 = this.toSeekBarProgress;
                if (f14 > 0.0f) {
                    if (f14 != 1.0f) {
                        canvas.saveLayerAlpha(this.seekBarX, this.seekBarY, r1 + this.seekBar.getWidth() + AndroidUtilities.dp(24.0f), this.seekBarY + AndroidUtilities.dp(24.0f), (int) (this.toSeekBarProgress * 255.0f), 31);
                    } else {
                        canvas.save();
                    }
                    canvas.translate(this.seekBarX, this.seekBarY);
                    this.seekBar.draw(canvas);
                    canvas.restore();
                }
                if (this.toSeekBarProgress < 1.0f) {
                    float f15 = this.timeAudioX + this.performerX;
                    float fDp2 = AndroidUtilities.dp(35.0f) + this.namesOffset + this.mediaOffsetY;
                    if (this.toSeekBarProgress != 0.0f) {
                        f = fDp2;
                        f2 = f15;
                        canvas.saveLayerAlpha(f15, fDp2, f15 + this.performerLayout.getWidth(), fDp2 + this.performerLayout.getHeight(), (int) ((1.0f - this.toSeekBarProgress) * 255.0f), 31);
                    } else {
                        f = fDp2;
                        f2 = f15;
                        canvas.save();
                    }
                    float f16 = this.toSeekBarProgress;
                    if (f16 != 0.0f) {
                        float f17 = ((1.0f - f16) * 0.3f) + 0.7f;
                        canvas.scale(f17, f17, f2, f + (this.performerLayout.getHeight() / 2.0f));
                    }
                    canvas.translate(f2, f);
                    this.performerLayout.draw(canvas);
                    canvas.restore();
                }
                canvas.save();
                canvas.translate(this.timeAudioX, AndroidUtilities.dp(57.0f) + this.namesOffset + this.mediaOffsetY);
                this.durationLayout.draw(canvas);
                canvas.restore();
            } else if (i14 == 3) {
                if (this.currentMessageObject.isOutOwner()) {
                    Theme.chat_audioTimePaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_outAudioDurationSelectedText" : "chat_outAudioDurationText"));
                    this.radialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.buttonPressed != 0) ? "chat_outAudioSelectedProgress" : "chat_outAudioProgress"));
                } else {
                    Theme.chat_audioTimePaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_inAudioDurationSelectedText" : "chat_inAudioDurationText"));
                    this.radialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.buttonPressed != 0) ? "chat_inAudioSelectedProgress" : "chat_inAudioProgress"));
                }
                if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                    animatedOutAudioVisualizerDrawable = Theme.getCurrentAudiVisualizerDrawable();
                } else {
                    animatedOutAudioVisualizerDrawable = Theme.getAnimatedOutAudioVisualizerDrawable(this.currentMessageObject);
                }
                if (animatedOutAudioVisualizerDrawable != null) {
                    animatedOutAudioVisualizerDrawable.setParentView(this);
                    animatedOutAudioVisualizerDrawable.draw(canvas, AndroidUtilities.dp(22.0f) + f3, AndroidUtilities.dp(22.0f) + f9, this.currentMessageObject.isOutOwner());
                }
                if (!this.enterTransitionInPorgress) {
                    this.radialProgress.setBackgroundDrawable(isDrawSelectionBackground() ? this.currentBackgroundSelectedDrawable : this.currentBackgroundDrawable);
                    this.radialProgress.draw(canvas);
                }
                int i15 = this.seekBarX;
                int i16 = this.timeAudioX;
                if (this.transitionParams.animateButton) {
                    int i17 = this.buttonX;
                    float f18 = this.transitionParams.animateFromButtonX;
                    float f19 = this.transitionParams.animateChangeProgress;
                    int i18 = i17 - ((int) ((f18 * (1.0f - f19)) + (this.buttonX * f19)));
                    i15 -= i18;
                    i16 -= i18;
                }
                canvas.save();
                if (this.useSeekBarWaweform) {
                    canvas.translate(i15 + AndroidUtilities.dp(13.0f), this.seekBarY);
                    this.seekBarWaveform.draw(canvas, this);
                } else {
                    canvas.translate(i15, this.seekBarY);
                    this.seekBar.draw(canvas);
                }
                canvas.restore();
                canvas.save();
                canvas.translate(i16, AndroidUtilities.dp(44.0f) + this.namesOffset + this.mediaOffsetY);
                this.durationLayout.draw(canvas);
                canvas.restore();
                MessageObject messageObject4 = this.currentMessageObject;
                if (messageObject4.type != 0 && messageObject4.isContentUnread()) {
                    Theme.chat_docBackPaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outVoiceSeekbarFill" : "chat_inVoiceSeekbarFill"));
                    canvas.drawCircle(i16 + this.timeWidthAudio + AndroidUtilities.dp(6.0f), AndroidUtilities.dp(51.0f) + this.namesOffset + this.mediaOffsetY, AndroidUtilities.dp(3.0f), Theme.chat_docBackPaint);
                }
            }
        }
        if (this.captionLayout != null) {
            updateCaptionLayout();
        }
        MessageObject messageObject5 = this.currentMessageObject;
        if (!messageObject5.preview && ((this.currentPosition == null || ((groupedMessages = this.currentMessagesGroup) != null && groupedMessages.isDocuments)) && !this.transitionParams.transformGroupToSingleMessage && (!this.enterTransitionInPorgress || !messageObject5.isVoice()))) {
            drawCaptionLayout(canvas, false, 1.0f);
        }
        if (this.hasOldCaptionPreview) {
            MessageObject messageObject6 = this.currentMessageObject;
            int i19 = messageObject6.type;
            if (i19 == 1 || this.documentAttachType == 4 || i19 == 8) {
                imageX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(5.0f));
            } else {
                imageX = this.backgroundDrawableLeft + AndroidUtilities.dp(messageObject6.isOutOwner() ? 11.0f : 17.0f);
            }
            int i20 = imageX;
            int iDp8 = ((this.totalHeight - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f)) - this.linkPreviewHeight) - AndroidUtilities.dp(8.0f);
            Theme.chat_replyLinePaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outPreviewLine" : "chat_inPreviewLine"));
            canvas.drawRect(i20, iDp8 - AndroidUtilities.dp(3.0f), AndroidUtilities.dp(2.0f) + i20, this.linkPreviewHeight + iDp8, Theme.chat_replyLinePaint);
            if (this.siteNameLayout != null) {
                Theme.chat_replyNamePaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outSiteNameText" : "chat_inSiteNameText"));
                canvas.save();
                if (this.siteNameRtl) {
                    iDp3 = (this.backgroundWidth - this.siteNameWidth) - AndroidUtilities.dp(32.0f);
                } else {
                    iDp3 = this.hasInvoicePreview ? 0 : AndroidUtilities.dp(10.0f);
                }
                canvas.translate(iDp3 + i20, iDp8 - AndroidUtilities.dp(3.0f));
                this.siteNameLayout.draw(canvas);
                canvas.restore();
                StaticLayout staticLayout4 = this.siteNameLayout;
                iDp2 = staticLayout4.getLineBottom(staticLayout4.getLineCount() - 1) + iDp8;
            } else {
                iDp2 = iDp8;
            }
            if (this.currentMessageObject.isOutOwner()) {
                Theme.chat_replyTextPaint.setColor(getThemedColor("chat_messageTextOut"));
            } else {
                Theme.chat_replyTextPaint.setColor(getThemedColor("chat_messageTextIn"));
            }
            if (this.descriptionLayout != null) {
                if (iDp2 != iDp8) {
                    iDp2 += AndroidUtilities.dp(2.0f);
                }
                this.descriptionY = iDp2 - AndroidUtilities.dp(3.0f);
                canvas.save();
                canvas.translate(i20 + AndroidUtilities.dp(10.0f) + this.descriptionX, this.descriptionY);
                this.descriptionLayout.draw(canvas);
                canvas.restore();
            }
            this.drawTime = true;
        }
        if (this.documentAttachType == 1) {
            if (this.currentMessageObject.isOutOwner()) {
                Theme.chat_docNamePaint.setColor(getThemedColor("chat_outFileNameText"));
                Theme.chat_infoPaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_outFileInfoSelectedText" : "chat_outFileInfoText"));
                Theme.chat_docBackPaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_outFileBackgroundSelected" : "chat_outFileBackground"));
            } else {
                Theme.chat_docNamePaint.setColor(getThemedColor("chat_inFileNameText"));
                Theme.chat_infoPaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_inFileInfoSelectedText" : "chat_inFileInfoText"));
                Theme.chat_docBackPaint.setColor(getThemedColor(isDrawSelectionBackground() ? "chat_inFileBackgroundSelected" : "chat_inFileBackground"));
            }
            if (this.drawPhotoImage) {
                fDp = (int) (this.photoImage.getImageX() + this.photoImage.getImageWidth() + AndroidUtilities.dp(10.0f));
                int imageY2 = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
                int imageY3 = (int) (this.photoImage.getImageY() + (this.docTitleLayout != null ? r3.getLineBottom(r3.getLineCount() - 1) + AndroidUtilities.dp(13.0f) : AndroidUtilities.dp(8.0f)));
                if (!this.imageDrawn) {
                    if (this.currentMessageObject.isOutOwner()) {
                        this.radialProgress.setColors("chat_outLoader", "chat_outLoaderSelected", "chat_outMediaIcon", "chat_outMediaIconSelected");
                        this.radialProgress.setProgressColor(getThemedColor(isDrawSelectionBackground() ? "chat_outFileProgressSelected" : "chat_outFileProgress"));
                        this.videoRadialProgress.setColors("chat_outLoader", "chat_outLoaderSelected", "chat_outMediaIcon", "chat_outMediaIconSelected");
                        this.videoRadialProgress.setProgressColor(getThemedColor(isDrawSelectionBackground() ? "chat_outFileProgressSelected" : "chat_outFileProgress"));
                    } else {
                        this.radialProgress.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
                        this.radialProgress.setProgressColor(getThemedColor(isDrawSelectionBackground() ? "chat_inFileProgressSelected" : "chat_inFileProgress"));
                        this.videoRadialProgress.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
                        this.videoRadialProgress.setProgressColor(getThemedColor(isDrawSelectionBackground() ? "chat_inFileProgressSelected" : "chat_inFileProgress"));
                    }
                    this.rect.set(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX() + this.photoImage.getImageWidth(), this.photoImage.getImageY() + this.photoImage.getImageHeight());
                    int[] roundRadius3 = this.photoImage.getRoundRadius();
                    this.rectPath.reset();
                    for (int i21 = 0; i21 < roundRadius3.length; i21++) {
                        float[] fArr3 = radii;
                        int i22 = i21 * 2;
                        fArr3[i22] = roundRadius3[i21];
                        fArr3[i22 + 1] = roundRadius3[i21];
                    }
                    this.rectPath.addRoundRect(this.rect, radii, Path.Direction.CW);
                    this.rectPath.close();
                    canvas.drawPath(this.rectPath, Theme.chat_docBackPaint);
                } else {
                    this.radialProgress.setColors("chat_mediaLoaderPhoto", "chat_mediaLoaderPhotoSelected", "chat_mediaLoaderPhotoIcon", "chat_mediaLoaderPhotoIconSelected");
                    String str2 = str;
                    this.radialProgress.setProgressColor(getThemedColor(str2));
                    this.videoRadialProgress.setColors("chat_mediaLoaderPhoto", "chat_mediaLoaderPhotoSelected", "chat_mediaLoaderPhotoIcon", "chat_mediaLoaderPhotoIconSelected");
                    this.videoRadialProgress.setProgressColor(getThemedColor(str2));
                    if (this.buttonState == -1 && this.radialProgress.getIcon() != 4) {
                        this.radialProgress.setIcon(4, true, true);
                    }
                }
                i = imageY3;
                iDp = imageY2;
            } else {
                fDp = f3 + AndroidUtilities.dp(53.0f);
                int i23 = (int) f9;
                iDp = AndroidUtilities.dp(4.0f) + i23;
                int iDp9 = i23 + AndroidUtilities.dp(27.0f);
                StaticLayout staticLayout5 = this.docTitleLayout;
                if (staticLayout5 != null && staticLayout5.getLineCount() > 1) {
                    iDp9 += ((this.docTitleLayout.getLineCount() - 1) * AndroidUtilities.dp(16.0f)) + AndroidUtilities.dp(2.0f);
                }
                if (this.currentMessageObject.isOutOwner()) {
                    this.radialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.buttonPressed != 0) ? "chat_outAudioSelectedProgress" : "chat_outAudioProgress"));
                    this.videoRadialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.videoButtonPressed != 0) ? "chat_outAudioSelectedProgress" : "chat_outAudioProgress"));
                } else {
                    this.radialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.buttonPressed != 0) ? "chat_inAudioSelectedProgress" : "chat_inAudioProgress"));
                    this.videoRadialProgress.setProgressColor(getThemedColor((isDrawSelectionBackground() || this.videoButtonPressed != 0) ? "chat_inAudioSelectedProgress" : "chat_inAudioProgress"));
                }
                i = iDp9;
            }
            float f20 = fDp;
            try {
                if (this.docTitleLayout != null) {
                    canvas.save();
                    canvas.translate(this.docTitleOffsetX + f20, iDp);
                    this.docTitleLayout.draw(canvas);
                    canvas.restore();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            try {
                if (this.infoLayout != null) {
                    canvas.save();
                    canvas.translate(f20, i);
                    if (this.buttonState == 1 && (staticLayout = this.loadingProgressLayout) != null) {
                        staticLayout.draw(canvas);
                    } else {
                        this.infoLayout.draw(canvas);
                    }
                    canvas.restore();
                }
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        MessageObject messageObject7 = this.currentMessageObject;
        if (messageObject7.type == 4 && !(messageObject7.messageOwner.media instanceof TLRPC$TL_messageMediaGeoLive) && this.currentMapProvider == 2 && this.photoImage.hasNotThumb()) {
            int intrinsicWidth = (int) (Theme.chat_redLocationIcon.getIntrinsicWidth() * 0.8f);
            int intrinsicHeight = (int) (Theme.chat_redLocationIcon.getIntrinsicHeight() * 0.8f);
            int imageX3 = (int) (this.photoImage.getImageX() + ((this.photoImage.getImageWidth() - intrinsicWidth) / 2.0f));
            int imageY4 = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() / 2.0f) - intrinsicHeight));
            Theme.chat_redLocationIcon.setAlpha((int) (this.photoImage.getCurrentAlpha() * 255.0f));
            Theme.chat_redLocationIcon.setBounds(imageX3, imageY4, intrinsicWidth + imageX3, intrinsicHeight + imageY4);
            Theme.chat_redLocationIcon.draw(canvas);
        }
        this.transitionParams.recordDrawingState();
        drawChannelName(canvas);
    }

    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v44 */
    public void drawLinkPreview(Canvas canvas, float f) {
        int iDp;
        int i;
        int iDp2;
        int iDp3;
        int iDp4;
        int iDp5;
        int i2;
        ?? r11;
        int i3;
        Drawable themedDrawable;
        int imageY;
        int imageX;
        int i4;
        int i5;
        boolean z;
        int i6;
        boolean z2;
        int iDp6;
        if (this.currentMessageObject.isSponsored() || this.hasLinkPreview || this.hasGamePreview || this.hasInvoicePreview) {
            if (this.hasGamePreview) {
                iDp = AndroidUtilities.dp(14.0f) + this.namesOffset;
                iDp3 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    iDp = AndroidUtilities.dp(14.0f) + this.namesOffset;
                    i = this.unmovedTextX;
                    iDp2 = AndroidUtilities.dp(1.0f);
                } else if (this.currentMessageObject.isSponsored()) {
                    iDp = (this.textY + this.currentMessageObject.textHeight) - AndroidUtilities.dp(2.0f);
                    i = this.unmovedTextX;
                    iDp2 = AndroidUtilities.dp(1.0f);
                } else {
                    iDp = this.textY + this.currentMessageObject.textHeight + AndroidUtilities.dp(8.0f);
                    i = this.unmovedTextX;
                    iDp2 = AndroidUtilities.dp(1.0f);
                }
                iDp3 = i + iDp2;
            }
            int iDp7 = iDp;
            int i7 = iDp3;
            if (!this.hasInvoicePreview && !this.currentMessageObject.isSponsored()) {
                Theme.chat_replyLinePaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outPreviewLine" : "chat_inPreviewLine"));
                if (f != 1.0f) {
                    Theme.chat_replyLinePaint.setAlpha((int) (r1.getAlpha() * f));
                }
                canvas.drawRect(i7, iDp7 - AndroidUtilities.dp(3.0f), AndroidUtilities.dp(2.0f) + i7, this.linkPreviewHeight + iDp7 + AndroidUtilities.dp(3.0f), Theme.chat_replyLinePaint);
            }
            if (this.siteNameLayout != null) {
                int iDp8 = iDp7 - AndroidUtilities.dp(1.0f);
                Theme.chat_replyNamePaint.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? "chat_outSiteNameText" : "chat_inSiteNameText"));
                if (f != 1.0f) {
                    Theme.chat_replyNamePaint.setAlpha((int) (Theme.chat_replyLinePaint.getAlpha() * f));
                }
                canvas.save();
                if (this.siteNameRtl) {
                    iDp6 = (this.backgroundWidth - this.siteNameWidth) - AndroidUtilities.dp(32.0f);
                    if (this.isSmallImage) {
                        iDp6 -= AndroidUtilities.dp(54.0f);
                    }
                } else {
                    iDp6 = this.hasInvoicePreview ? 0 : AndroidUtilities.dp(10.0f);
                }
                canvas.translate(iDp6 + i7, iDp7 - AndroidUtilities.dp(3.0f));
                this.siteNameLayout.draw(canvas);
                canvas.restore();
                StaticLayout staticLayout = this.siteNameLayout;
                iDp4 = staticLayout.getLineBottom(staticLayout.getLineCount() - 1) + iDp7;
                iDp5 = iDp8;
            } else {
                iDp4 = iDp7;
                iDp5 = 0;
            }
            if ((this.hasGamePreview || this.hasInvoicePreview) && (i2 = this.currentMessageObject.textHeight) != 0) {
                iDp7 += i2 + AndroidUtilities.dp(4.0f);
                iDp4 += this.currentMessageObject.textHeight + AndroidUtilities.dp(4.0f);
            }
            if (!(this.drawPhotoImage && this.drawInstantView && this.drawInstantViewType != 9) && (this.drawInstantViewType != 6 || this.imageBackgroundColor == 0)) {
                r11 = 1;
                i3 = 0;
            } else {
                if (iDp4 != iDp7) {
                    iDp4 += AndroidUtilities.dp(2.0f);
                }
                int i8 = iDp4;
                if (this.imageBackgroundSideColor != 0) {
                    int iDp9 = AndroidUtilities.dp(10.0f) + i7;
                    ImageReceiver imageReceiver = this.photoImage;
                    float f2 = iDp9;
                    imageReceiver.setImageCoords(((this.imageBackgroundSideWidth - imageReceiver.getImageWidth()) / 2.0f) + f2, i8, this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
                    this.rect.set(f2, this.photoImage.getImageY(), iDp9 + this.imageBackgroundSideWidth, this.photoImage.getImageY2());
                    Theme.chat_instantViewPaint.setColor(ColorUtils.setAlphaComponent(this.imageBackgroundSideColor, (int) (f * 255.0f)));
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), Theme.chat_instantViewPaint);
                } else {
                    this.photoImage.setImageCoords(AndroidUtilities.dp(10.0f) + i7, i8, this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
                }
                if (this.imageBackgroundColor != 0) {
                    this.rect.set(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX2(), this.photoImage.getImageY2());
                    if (this.imageBackgroundGradientColor1 != 0) {
                        if (this.imageBackgroundGradientColor2 != 0) {
                            if (this.motionBackgroundDrawable == null) {
                                MotionBackgroundDrawable motionBackgroundDrawable = new MotionBackgroundDrawable(this.imageBackgroundColor, this.imageBackgroundGradientColor1, this.imageBackgroundGradientColor2, this.imageBackgroundGradientColor3, true);
                                this.motionBackgroundDrawable = motionBackgroundDrawable;
                                if (this.imageBackgroundIntensity < 0.0f) {
                                    this.photoImage.setGradientBitmap(motionBackgroundDrawable.getBitmap());
                                }
                                if (!this.photoImage.hasImageSet()) {
                                    this.motionBackgroundDrawable.setRoundRadius(AndroidUtilities.dp(4.0f));
                                }
                            }
                        } else {
                            if (this.gradientShader == null) {
                                Rect gradientPoints = BackgroundGradientDrawable.getGradientPoints(AndroidUtilities.getWallpaperRotation(this.imageBackgroundGradientRotation, false), (int) this.rect.width(), (int) this.rect.height());
                                this.gradientShader = new LinearGradient(gradientPoints.left, gradientPoints.top, gradientPoints.right, gradientPoints.bottom, new int[]{this.imageBackgroundColor, this.imageBackgroundGradientColor1}, (float[]) null, Shader.TileMode.CLAMP);
                            }
                            Theme.chat_instantViewPaint.setShader(this.gradientShader);
                            if (f != 1.0f) {
                                Theme.chat_instantViewPaint.setAlpha((int) (f * 255.0f));
                            }
                        }
                    } else {
                        Theme.chat_instantViewPaint.setShader(null);
                        Theme.chat_instantViewPaint.setColor(this.imageBackgroundColor);
                        if (f != 1.0f) {
                            Theme.chat_instantViewPaint.setAlpha((int) (f * 255.0f));
                        }
                    }
                    MotionBackgroundDrawable motionBackgroundDrawable2 = this.motionBackgroundDrawable;
                    if (motionBackgroundDrawable2 != null) {
                        RectF rectF = this.rect;
                        motionBackgroundDrawable2.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                        this.motionBackgroundDrawable.draw(canvas);
                        i5 = i8;
                        i6 = 255;
                        z2 = true;
                        i3 = 0;
                    } else if (this.imageBackgroundSideColor != 0) {
                        i5 = i8;
                        i6 = 255;
                        i3 = 0;
                        z2 = true;
                        canvas.drawRect(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX2(), this.photoImage.getImageY2(), Theme.chat_instantViewPaint);
                    } else {
                        i5 = i8;
                        i6 = 255;
                        z2 = true;
                        i3 = 0;
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), Theme.chat_instantViewPaint);
                    }
                    Theme.chat_instantViewPaint.setShader(null);
                    Theme.chat_instantViewPaint.setAlpha(i6);
                    z = z2;
                } else {
                    i5 = i8;
                    z = true;
                    i3 = 0;
                }
                if (this.drawPhotoImage && this.drawInstantView && this.drawInstantViewType != 9) {
                    if (this.drawImageButton) {
                        int iDp10 = AndroidUtilities.dp(48.0f);
                        float f3 = iDp10;
                        int imageX2 = (int) (this.photoImage.getImageX() + ((this.photoImage.getImageWidth() - f3) / 2.0f));
                        this.buttonX = imageX2;
                        this.buttonX = imageX2;
                        int imageY2 = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - f3) / 2.0f));
                        this.buttonY = imageY2;
                        this.buttonY = imageY2;
                        RadialProgress2 radialProgress2 = this.radialProgress;
                        int i9 = this.buttonX;
                        radialProgress2.setProgressRect(i9, imageY2, i9 + iDp10, iDp10 + imageY2);
                    }
                    ExploreCellDelegate exploreCellDelegate = this.delegate;
                    if (exploreCellDelegate == null || exploreCellDelegate.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
                        if (f != 1.0f) {
                            this.photoImage.setAlpha(f);
                            this.imageDrawn = this.photoImage.draw(canvas);
                            this.photoImage.setAlpha(1.0f);
                        } else {
                            this.imageDrawn = this.photoImage.draw(canvas);
                        }
                    }
                }
                iDp4 = (int) (i5 + this.photoImage.getImageHeight() + AndroidUtilities.dp(6.0f));
                r11 = z;
            }
            if (this.currentMessageObject.isOutOwner()) {
                int i10 = (int) (f * 255.0f);
                Theme.chat_replyNamePaint.setColor(ColorUtils.setAlphaComponent(getThemedColor("chat_messageTextOut"), i10));
                Theme.chat_replyTextPaint.setColor(ColorUtils.setAlphaComponent(getThemedColor("chat_messageTextOut"), i10));
            } else {
                int i11 = (int) (f * 255.0f);
                Theme.chat_replyNamePaint.setColor(ColorUtils.setAlphaComponent(getThemedColor("chat_messageTextIn"), i11));
                Theme.chat_replyTextPaint.setColor(ColorUtils.setAlphaComponent(getThemedColor("chat_messageTextIn"), i11));
            }
            if (this.titleLayout != null) {
                if (iDp4 != iDp7) {
                    iDp4 += AndroidUtilities.dp(2.0f);
                }
                if (iDp5 == 0) {
                    iDp5 = iDp4 - AndroidUtilities.dp(1.0f);
                }
                canvas.save();
                canvas.translate(AndroidUtilities.dp(10.0f) + i7 + this.titleX, iDp4 - AndroidUtilities.dp(3.0f));
                this.titleLayout.draw(canvas);
                canvas.restore();
                StaticLayout staticLayout2 = this.titleLayout;
                iDp4 += staticLayout2.getLineBottom(staticLayout2.getLineCount() - r11);
            }
            if (this.authorLayout != null) {
                if (iDp4 != iDp7) {
                    iDp4 += AndroidUtilities.dp(2.0f);
                }
                if (iDp5 == 0) {
                    iDp5 = iDp4 - AndroidUtilities.dp(1.0f);
                }
                canvas.save();
                canvas.translate(AndroidUtilities.dp(10.0f) + i7 + this.authorX, iDp4 - AndroidUtilities.dp(3.0f));
                this.authorLayout.draw(canvas);
                canvas.restore();
                StaticLayout staticLayout3 = this.authorLayout;
                iDp4 += staticLayout3.getLineBottom(staticLayout3.getLineCount() - r11);
            }
            if (this.descriptionLayout != null) {
                if (iDp4 != iDp7) {
                    iDp4 += AndroidUtilities.dp(2.0f);
                }
                if (iDp5 == 0) {
                    iDp5 = iDp4 - AndroidUtilities.dp(1.0f);
                }
                this.descriptionY = iDp4 - AndroidUtilities.dp(3.0f);
                canvas.save();
                canvas.translate((this.hasInvoicePreview ? 0 : AndroidUtilities.dp(10.0f)) + i7 + this.descriptionX, this.descriptionY);
                if (this.pressedLink != null && this.linkBlockNum == -10) {
                    for (int i12 = 0; i12 < this.urlPath.size(); i12++) {
                        canvas.drawPath(this.urlPath.get(i12), Theme.chat_urlPaint);
                    }
                }
                if (this.delegate.getTextSelectionHelper() != null && getDelegate().getTextSelectionHelper().isSelected(this.currentMessageObject)) {
                    this.delegate.getTextSelectionHelper().drawDescription(this.currentMessageObject.isOutOwner(), this.descriptionLayout, canvas);
                }
                this.descriptionLayout.draw(canvas);
                canvas.restore();
                StaticLayout staticLayout4 = this.descriptionLayout;
                iDp4 += staticLayout4.getLineBottom(staticLayout4.getLineCount() - r11);
            }
            int i13 = iDp5;
            if (this.drawPhotoImage && (!this.drawInstantView || (i4 = this.drawInstantViewType) == 9 || i4 == 11)) {
                if (iDp4 != iDp7) {
                    iDp4 += AndroidUtilities.dp(2.0f);
                }
                if (this.isSmallImage) {
                    this.photoImage.setImageCoords((this.backgroundWidth + i7) - AndroidUtilities.dp(81.0f), i13, this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
                } else {
                    this.photoImage.setImageCoords((this.hasInvoicePreview ? -AndroidUtilities.dp(6.3f) : AndroidUtilities.dp(10.0f)) + i7, iDp4, this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
                    if (this.drawImageButton) {
                        int iDp11 = AndroidUtilities.dp(48.0f);
                        float f4 = iDp11;
                        int imageX3 = (int) (this.photoImage.getImageX() + ((this.photoImage.getImageWidth() - f4) / 2.0f));
                        this.buttonX = imageX3;
                        this.buttonX = imageX3;
                        int imageY3 = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - f4) / 2.0f));
                        this.buttonY = imageY3;
                        this.buttonY = imageY3;
                        RadialProgress2 radialProgress22 = this.radialProgress;
                        int i14 = this.buttonX;
                        radialProgress22.setProgressRect(i14, imageY3, i14 + iDp11, iDp11 + imageY3);
                    }
                }
                if (this.isRoundVideo && MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && MediaController.getInstance().isVideoDrawingReady() && canvas.isHardwareAccelerated()) {
                    this.imageDrawn = r11;
                    this.drawTime = r11;
                } else {
                    ExploreCellDelegate exploreCellDelegate2 = this.delegate;
                    if (exploreCellDelegate2 == null || exploreCellDelegate2.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
                        if (f != 1.0f) {
                            this.photoImage.setAlpha(f);
                            this.imageDrawn = this.photoImage.draw(canvas);
                            this.photoImage.setAlpha(1.0f);
                        } else {
                            this.imageDrawn = this.photoImage.draw(canvas);
                        }
                    }
                }
            }
            int i15 = this.documentAttachType;
            if (i15 == 4 || i15 == 2) {
                this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
                int imageY4 = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
                this.videoButtonY = imageY4;
                RadialProgress2 radialProgress23 = this.videoRadialProgress;
                int i16 = this.videoButtonX;
                radialProgress23.setProgressRect(i16, imageY4, AndroidUtilities.dp(16.0f) + i16, this.videoButtonY + AndroidUtilities.dp(16.0f));
            }
            Paint themedPaint = getThemedPaint("paintChatTimeBackground");
            if (this.photosCountLayout != null && this.photoImage.getVisible()) {
                int imageX4 = (int) (((this.photoImage.getImageX() + this.photoImage.getImageWidth()) - AndroidUtilities.dp(8.0f)) - this.photosCountWidth);
                int imageY5 = (int) ((this.photoImage.getImageY() + this.photoImage.getImageHeight()) - AndroidUtilities.dp(19.0f));
                this.rect.set(imageX4 - AndroidUtilities.dp(4.0f), imageY5 - AndroidUtilities.dp(1.5f), this.photosCountWidth + imageX4 + AndroidUtilities.dp(4.0f), imageY5 + AndroidUtilities.dp(14.5f));
                int alpha = themedPaint.getAlpha();
                themedPaint.setAlpha((int) (alpha * this.controlsAlpha));
                Theme.chat_durationPaint.setAlpha((int) (this.controlsAlpha * 255.0f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), themedPaint);
                themedPaint.setAlpha(alpha);
                canvas.save();
                canvas.translate(imageX4, imageY5);
                this.photosCountLayout.draw(canvas);
                canvas.restore();
                Theme.chat_durationPaint.setAlpha(255);
            }
            if (this.videoInfoLayout != null && ((!this.drawPhotoImage || this.photoImage.getVisible()) && this.imageBackgroundSideColor == 0)) {
                if (this.hasGamePreview || this.hasInvoicePreview || this.documentAttachType == 8) {
                    if (this.drawPhotoImage) {
                        imageX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.5f));
                        imageY = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(6.0f));
                        this.rect.set(imageX - AndroidUtilities.dp(4.0f), imageY - AndroidUtilities.dp(1.5f), this.durationWidth + imageX + AndroidUtilities.dp(4.0f), AndroidUtilities.dp(this.documentAttachType == 8 ? 14.5f : 16.5f) + imageY);
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), themedPaint);
                    } else {
                        imageY = iDp4;
                        imageX = i7;
                    }
                } else {
                    imageX = (int) (((this.photoImage.getImageX() + this.photoImage.getImageWidth()) - AndroidUtilities.dp(8.0f)) - this.durationWidth);
                    int imageY6 = (int) ((this.photoImage.getImageY() + this.photoImage.getImageHeight()) - AndroidUtilities.dp(19.0f));
                    this.rect.set(imageX - AndroidUtilities.dp(4.0f), imageY6 - AndroidUtilities.dp(1.5f), this.durationWidth + imageX + AndroidUtilities.dp(4.0f), AndroidUtilities.dp(14.5f) + imageY6);
                    canvas.drawRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), getThemedPaint("paintChatTimeBackground"));
                    imageY = imageY6;
                }
                canvas.save();
                canvas.translate(imageX, imageY);
                if (this.hasInvoicePreview) {
                    if (this.drawPhotoImage) {
                        Theme.chat_shipmentPaint.setColor(getThemedColor("chat_previewGameText"));
                    } else if (this.currentMessageObject.isOutOwner()) {
                        Theme.chat_shipmentPaint.setColor(getThemedColor("chat_messageTextOut"));
                    } else {
                        Theme.chat_shipmentPaint.setColor(getThemedColor("chat_messageTextIn"));
                    }
                }
                this.videoInfoLayout.draw(canvas);
                canvas.restore();
            }
            if (this.drawInstantView) {
                int iDp12 = iDp7 + this.linkPreviewHeight + AndroidUtilities.dp(10.0f);
                Paint paint = Theme.chat_instantViewRectPaint;
                if (this.currentMessageObject.isOutOwner()) {
                    themedDrawable = getThemedDrawable("drawableMsgOutInstant");
                    Theme.chat_instantViewPaint.setColor(getThemedColor("chat_outPreviewInstantText"));
                    paint.setColor(getThemedColor("chat_outPreviewInstantText"));
                } else {
                    themedDrawable = Theme.chat_msgInInstantDrawable;
                    Theme.chat_instantViewPaint.setColor(getThemedColor("chat_inPreviewInstantText"));
                    paint.setColor(getThemedColor("chat_inPreviewInstantText"));
                }
                this.instantButtonRect.set(i7, iDp12, this.instantWidth + i7, AndroidUtilities.dp(36.0f) + iDp12);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.selectorDrawableMaskType[i3] = i3;
                    this.selectorDrawable[i3].setBounds(i7, iDp12, this.instantWidth + i7, AndroidUtilities.dp(36.0f) + iDp12);
                    this.selectorDrawable[i3].draw(canvas);
                }
                canvas.drawRoundRect(this.instantButtonRect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), paint);
                if (this.drawInstantViewType == 0) {
                    BaseCell.setDrawableBounds(themedDrawable, ((this.instantTextLeftX + this.instantTextX) + i7) - AndroidUtilities.dp(15.0f), AndroidUtilities.dp(11.5f) + iDp12, AndroidUtilities.dp(9.0f), AndroidUtilities.dp(13.0f));
                    themedDrawable.draw(canvas);
                }
                if (this.instantViewLayout != null) {
                    canvas.save();
                    canvas.translate(i7 + this.instantTextX, iDp12 + AndroidUtilities.dp(10.5f));
                    this.instantViewLayout.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    private void drawBotButtons(Canvas canvas, ArrayList<BotButton> botButtons, float alpha) {
        int iDp;
        if (this.currentMessageObject.isOutOwner()) {
            iDp = (getMeasuredWidth() - this.widthForButtons) - AndroidUtilities.dp(10.0f);
        } else {
            iDp = this.backgroundDrawableLeft + AndroidUtilities.dp((this.mediaBackground || this.drawPinnedBottom) ? 1.0f : 7.0f);
        }
        int i = iDp;
        float f = 2.0f;
        float fDp = (this.layoutHeight - AndroidUtilities.dp(2.0f)) + this.transitionParams.deltaBottom;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < botButtons.size(); i2++) {
            BotButton botButton = botButtons.get(i2);
            float f3 = botButton.y + botButton.height;
            if (f3 > f2) {
                f2 = f3;
            }
        }
        this.rect.set(0.0f, fDp, getMeasuredWidth(), f2 + fDp);
        if (alpha != 1.0f) {
            canvas.saveLayerAlpha(this.rect, (int) (alpha * 255.0f), 31);
        } else {
            canvas.save();
        }
        int i3 = 0;
        while (i3 < botButtons.size()) {
            BotButton botButton2 = botButtons.get(i3);
            boolean z = botButton2.button instanceof TLRPC$TL_keyboardButtonBuy;
            float fDp2 = ((botButton2.y + this.layoutHeight) - AndroidUtilities.dp(f)) + this.transitionParams.deltaBottom;
            this.rect.set(botButton2.x + i, fDp2, botButton2.x + i + botButton2.width, botButton2.height + fDp2);
            applyServiceShaderMatrix(getMeasuredWidth(), this.backgroundHeight, getX(), this.viewTop);
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), getThemedPaint(i3 == this.pressedBotButton ? "paintChatActionBackgroundSelected" : "paintChatActionBackground"));
            if (hasGradientService()) {
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
            canvas.save();
            boolean z2 = true;
            canvas.translate(botButton2.x + i + AndroidUtilities.dp(5.0f) + (z ? AndroidUtilities.dp(12.0f) : 0), ((AndroidUtilities.dp(44.0f) - botButton2.title.getLineBottom(botButton2.title.getLineCount() - 1)) / 2) + fDp2);
            botButton2.title.draw(canvas);
            canvas.restore();
            if (z) {
                int iDp2 = (int) (((AndroidUtilities.dp(44.0f) - AndroidUtilities.dp(24.0f)) / 2) + fDp2);
                int iDp3 = (int) (botButton2.x + i + AndroidUtilities.dp(5.0f) + AndroidUtilities.dp(12.0f) + ((botButton2.title.getLineLeft(botButton2.title.getLineCount() - 1) - AndroidUtilities.dp(24.0f)) - AndroidUtilities.dp(5.0f)));
                Theme.chat_eitaaPayDrawable.setBounds(iDp3, iDp2, AndroidUtilities.dp(24.0f) + iDp3, AndroidUtilities.dp(24.0f) + iDp2);
                Theme.chat_eitaaPayDrawable.draw(canvas);
            }
            if (!(botButton2.button instanceof TLRPC$TL_keyboardButtonUrl)) {
                if (!(botButton2.button instanceof TLRPC$TL_keyboardButtonSwitchInline)) {
                    if ((botButton2.button instanceof TLRPC$TL_keyboardButtonCallback) || (botButton2.button instanceof TLRPC$TL_keyboardButtonRequestGeoLocation) || (botButton2.button instanceof TLRPC$TL_keyboardButtonGame) || (botButton2.button instanceof TLRPC$TL_keyboardButtonBuy) || (botButton2.button instanceof TLRPC$TL_keyboardButtonUrlAuth)) {
                        boolean z3 = botButton2.button instanceof TLRPC$TL_keyboardButtonBuy;
                        if (((!(botButton2.button instanceof TLRPC$TL_keyboardButtonCallback) && !(botButton2.button instanceof TLRPC$TL_keyboardButtonGame) && !(botButton2.button instanceof TLRPC$TL_keyboardButtonBuy) && !(botButton2.button instanceof TLRPC$TL_keyboardButtonUrlAuth)) || !SendMessagesHelper.getInstance(this.currentAccount).isSendingCallback(this.currentMessageObject, botButton2.button)) && (!(botButton2.button instanceof TLRPC$TL_keyboardButtonRequestGeoLocation) || !SendMessagesHelper.getInstance(this.currentAccount).isSendingCurrentLocation(this.currentMessageObject, botButton2.button))) {
                            z2 = false;
                        }
                        if (z2 || botButton2.progressAlpha != 0.0f) {
                            Theme.chat_botProgressPaint.setAlpha(Math.min(255, (int) (botButton2.progressAlpha * 255.0f)));
                            int iDp4 = ((botButton2.x + botButton2.width) - AndroidUtilities.dp(12.0f)) + i;
                            if (botButton2.button instanceof TLRPC$TL_keyboardButtonBuy) {
                                fDp2 += AndroidUtilities.dp(26.0f);
                            }
                            this.rect.set(iDp4, AndroidUtilities.dp(4.0f) + fDp2, iDp4 + AndroidUtilities.dp(8.0f), fDp2 + AndroidUtilities.dp(12.0f));
                            canvas.drawArc(this.rect, botButton2.angle, 220.0f, false, Theme.chat_botProgressPaint);
                            invalidate();
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (Math.abs(botButton2.lastUpdateTime - System.currentTimeMillis()) < 1000) {
                                long j = jCurrentTimeMillis - botButton2.lastUpdateTime;
                                BotButton.access$1316(botButton2, (360 * j) / 2000.0f);
                                BotButton.access$1320(botButton2, (botButton2.angle / 360) * 360);
                                if (z2) {
                                    if (botButton2.progressAlpha < 1.0f) {
                                        BotButton.access$1216(botButton2, j / 200.0f);
                                        if (botButton2.progressAlpha > 1.0f) {
                                            botButton2.progressAlpha = 1.0f;
                                        }
                                    }
                                } else if (botButton2.progressAlpha > 0.0f) {
                                    BotButton.access$1224(botButton2, j / 200.0f);
                                    if (botButton2.progressAlpha < 0.0f) {
                                        botButton2.progressAlpha = 0.0f;
                                    }
                                }
                            }
                            botButton2.lastUpdateTime = jCurrentTimeMillis;
                        }
                    }
                    i3++;
                    f = 2.0f;
                } else {
                    Drawable themedDrawable = getThemedDrawable("drawableBotInline");
                    BaseCell.setDrawableBounds(themedDrawable, (((botButton2.x + botButton2.width) - AndroidUtilities.dp(3.0f)) - themedDrawable.getIntrinsicWidth()) + i, fDp2 + AndroidUtilities.dp(3.0f));
                    themedDrawable.draw(canvas);
                }
            } else {
                Drawable themedDrawable2 = getThemedDrawable("drawableBotLink");
                BaseCell.setDrawableBounds(themedDrawable2, (((botButton2.x + botButton2.width) - AndroidUtilities.dp(3.0f)) - themedDrawable2.getIntrinsicWidth()) + i, fDp2 + AndroidUtilities.dp(3.0f));
                themedDrawable2.draw(canvas);
            }
            i3++;
            f = 2.0f;
        }
        canvas.restore();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0139 A[LOOP:1: B:52:0x0131->B:54:0x0139, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160 A[LOOP:2: B:61:0x0158->B:63:0x0160, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawMessageText(android.graphics.Canvas r18, java.util.ArrayList<ir.eitaa.messenger.MessageObject.TextLayoutBlock> r19, boolean r20, float r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 449
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawMessageText(android.graphics.Canvas, java.util.ArrayList, boolean, float, boolean):void");
    }

    private void drawChannelName(Canvas canvas) {
        canvas.save();
        int parentWidth = getParentWidth() - AndroidUtilities.dp(16.0f);
        this.channelNameLayout = new StaticLayout(TextUtils.ellipsize(this.currentChat.title, Theme.explore_channelNameTextPaint, parentWidth, TextUtils.TruncateAt.END), Theme.explore_channelNameTextPaint, parentWidth, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, false);
        if (this.currentMessageObject.type == 0) {
            canvas.translate(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        } else {
            canvas.translate(AndroidUtilities.dp(8.0f), this.captionY);
        }
        this.channelNameLayout.draw(canvas);
        canvas.restore();
    }

    public void updateCaptionLayout() {
        float imageX;
        float imageY;
        float imageHeight;
        MessageObject messageObject = this.currentMessageObject;
        int i = messageObject.type;
        if (i == 1 || this.documentAttachType == 4 || i == 8) {
            TransitionParams transitionParams = this.transitionParams;
            if (transitionParams.imageChangeBoundsTransition) {
                imageX = transitionParams.animateToImageX;
                imageY = transitionParams.animateToImageY;
                imageHeight = transitionParams.animateToImageH;
            } else {
                imageX = this.photoImage.getImageX();
                imageY = this.photoImage.getImageY();
                imageHeight = this.photoImage.getImageHeight();
            }
            this.captionX = imageX + AndroidUtilities.dp(5.0f) + this.captionOffsetX;
            this.captionY = imageY + imageHeight + AndroidUtilities.dp(6.0f);
        } else {
            if (this.hasOldCaptionPreview) {
                this.captionX = this.backgroundDrawableLeft + AndroidUtilities.dp(messageObject.isOutOwner() ? 11.0f : 17.0f) + this.captionOffsetX;
                float fDp = (((this.totalHeight - this.captionHeight) - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f)) - this.linkPreviewHeight) - AndroidUtilities.dp(17.0f);
                this.captionY = fDp;
                if (this.drawCommentButton && this.drawSideButton != 3) {
                    this.captionY = fDp - AndroidUtilities.dp(shouldDrawTimeOnMedia() ? 41.3f : 43.0f);
                }
            } else {
                int i2 = this.backgroundDrawableLeft;
                if (!messageObject.isOutOwner() && !this.mediaBackground && !this.drawPinnedBottom) {
                    f = 17.0f;
                }
                this.captionX = i2 + AndroidUtilities.dp(f) + this.captionOffsetX;
                float fDp2 = (this.totalHeight - this.captionHeight) - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f);
                this.captionY = fDp2;
                if (this.drawCommentButton && this.drawSideButton != 3) {
                    this.captionY = fDp2 - AndroidUtilities.dp(shouldDrawTimeOnMedia() ? 41.3f : 43.0f);
                }
            }
        }
        this.captionX += getExtraTextX();
    }

    private boolean textIsSelectionMode() {
        return getCurrentMessagesGroup() == null && this.delegate.getTextSelectionHelper() != null && this.delegate.getTextSelectionHelper().isSelected(this.currentMessageObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMiniIconForCurrentState() {
        int i = this.miniButtonState;
        if (i < 0) {
            return 4;
        }
        return i == 0 ? 2 : 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getIconForCurrentState() {
        int i = this.documentAttachType;
        if (i == 3 || i == 5) {
            if (this.currentMessageObject.isOutOwner()) {
                this.radialProgress.setColors("chat_outLoader", "chat_outLoaderSelected", "chat_outMediaIcon", "chat_outMediaIconSelected");
            } else {
                this.radialProgress.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
            }
            int i2 = this.buttonState;
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
            return i2 == 4 ? 3 : 0;
        }
        if (i == 1 && !this.drawPhotoImage) {
            if (this.currentMessageObject.isOutOwner()) {
                this.radialProgress.setColors("chat_outLoader", "chat_outLoaderSelected", "chat_outMediaIcon", "chat_outMediaIconSelected");
            } else {
                this.radialProgress.setColors("chat_inLoader", "chat_inLoaderSelected", "chat_inMediaIcon", "chat_inMediaIconSelected");
            }
            int i3 = this.buttonState;
            if (i3 == -1) {
                return 5;
            }
            if (i3 == 0) {
                return 2;
            }
            if (i3 == 1) {
                return 3;
            }
        } else {
            this.radialProgress.setColors("chat_mediaLoaderPhoto", "chat_mediaLoaderPhotoSelected", "chat_mediaLoaderPhotoIcon", "chat_mediaLoaderPhotoIconSelected");
            this.videoRadialProgress.setColors("chat_mediaLoaderPhoto", "chat_mediaLoaderPhotoSelected", "chat_mediaLoaderPhotoIcon", "chat_mediaLoaderPhotoIconSelected");
            int i4 = this.buttonState;
            if (i4 >= 0 && i4 < 4) {
                if (i4 == 0) {
                    return 2;
                }
                if (i4 == 1) {
                    return 3;
                }
                return (i4 != 2 && this.autoPlayingMedia) ? 4 : 0;
            }
            if (i4 == -1) {
                if (this.documentAttachType == 1) {
                    if (this.drawPhotoImage && (this.currentPhotoObject != null || this.currentPhotoObjectThumb != null)) {
                        if (this.photoImage.hasBitmapImage()) {
                            return 4;
                        }
                        MessageObject messageObject = this.currentMessageObject;
                        if (messageObject.mediaExists || messageObject.attachPathExists) {
                            return 4;
                        }
                    }
                    return 5;
                }
                if (this.currentMessageObject.needDrawBluredPreview()) {
                    MessageObject messageObject2 = this.currentMessageObject;
                    if (messageObject2.messageOwner.destroyTime != 0) {
                        return messageObject2.isOutOwner() ? 9 : 11;
                    }
                    return 7;
                }
                if (this.hasEmbed) {
                    return 0;
                }
            }
        }
        return 4;
    }

    private int getMaxNameWidth() {
        return getParentWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateButtonState(boolean r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 2308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.updateButtonState(boolean, boolean, boolean):void");
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) {
        int i = this.documentAttachType;
        updateButtonState(true, i == 3 || i == 5, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0115  */
    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSuccessDownload(java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.onSuccessDownload(java.lang.String):void");
    }

    @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
    public void didSetImage(ImageReceiver imageReceiver, boolean set, boolean thumb, boolean memCache) {
        int i;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || !set) {
            return;
        }
        if (setCurrentDiceValue((memCache || messageObject.wasUnread) ? false : true) || thumb) {
            return;
        }
        MessageObject messageObject2 = this.currentMessageObject;
        if (messageObject2.mediaExists || messageObject2.attachPathExists) {
            return;
        }
        int i2 = messageObject2.type;
        if ((i2 == 0 && ((i = this.documentAttachType) == 8 || i == 0 || i == 6)) || i2 == 1) {
            messageObject2.mediaExists = true;
            updateButtonState(false, true, false);
        }
    }

    public boolean setCurrentDiceValue(boolean instant) {
        MessagesController.DiceFrameSuccess diceFrameSuccess;
        if (!this.currentMessageObject.isDice()) {
            return false;
        }
        Drawable drawable = this.photoImage.getDrawable();
        if (drawable instanceof RLottieDrawable) {
            RLottieDrawable rLottieDrawable = (RLottieDrawable) drawable;
            String diceEmoji = this.currentMessageObject.getDiceEmoji();
            TLRPC$TL_messages_stickerSet stickerSetByEmojiOrName = MediaDataController.getInstance(this.currentAccount).getStickerSetByEmojiOrName(diceEmoji);
            if (stickerSetByEmojiOrName != null) {
                int diceValue = this.currentMessageObject.getDiceValue();
                if ("🎰".equals(this.currentMessageObject.getDiceEmoji())) {
                    if (diceValue >= 0 && diceValue <= 64) {
                        if (this.currentMessageObject.isOut()) {
                            rLottieDrawable.setOnFinishCallback(this.diceFinishCallback, ConnectionsManager.DEFAULT_DATACENTER_ID);
                        }
                        this.currentMessageObject.wasUnread = false;
                    }
                    if (!rLottieDrawable.hasBaseDice()) {
                        stickerSetByEmojiOrName.documents.size();
                    }
                } else {
                    if (!rLottieDrawable.hasBaseDice() && stickerSetByEmojiOrName.documents.size() > 0) {
                        TLRPC$Document tLRPC$Document = stickerSetByEmojiOrName.documents.get(0);
                        if (rLottieDrawable.setBaseDice(FileLoader.getPathToAttach(tLRPC$Document, true))) {
                            DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                        } else {
                            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$Document), this.currentMessageObject, this);
                            FileLoader.getInstance(this.currentAccount).loadFile(tLRPC$Document, stickerSetByEmojiOrName, 1, 1);
                        }
                    }
                    if (diceValue >= 0 && diceValue < stickerSetByEmojiOrName.documents.size()) {
                        if (!instant && this.currentMessageObject.isOut() && (diceFrameSuccess = MessagesController.getInstance(this.currentAccount).diceSuccess.get(diceEmoji)) != null && diceFrameSuccess.num == diceValue) {
                            rLottieDrawable.setOnFinishCallback(this.diceFinishCallback, diceFrameSuccess.frame);
                        }
                        TLRPC$Document tLRPC$Document2 = stickerSetByEmojiOrName.documents.get(Math.max(diceValue, 0));
                        if (rLottieDrawable.setDiceNumber(FileLoader.getPathToAttach(tLRPC$Document2, true), instant)) {
                            DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                        } else {
                            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$Document2), this.currentMessageObject, this);
                            FileLoader.getInstance(this.currentAccount).loadFile(tLRPC$Document2, stickerSetByEmojiOrName, 1, 1);
                        }
                        this.currentMessageObject.wasUnread = false;
                    }
                }
            } else {
                MediaDataController.getInstance(this.currentAccount).loadStickersByEmojiOrName(diceEmoji, true, true);
            }
        }
        return true;
    }

    @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
    public void onAnimationReady(ImageReceiver imageReceiver) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && imageReceiver == this.photoImage && messageObject.isAnimatedSticker()) {
            this.delegate.setShouldNotRepeatSticker(this.currentMessageObject);
        }
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
        float fMin = totalSize == 0 ? 0.0f : Math.min(1.0f, downloadedSize / totalSize);
        this.currentMessageObject.loadedFileSize = downloadedSize;
        createLoadingProgressLayout(downloadedSize, totalSize);
        if (this.drawVideoImageButton) {
            this.videoRadialProgress.setProgress(fMin, true);
        } else {
            this.radialProgress.setProgress(fMin, true);
        }
        int i = this.documentAttachType;
        if (i == 3 || i == 5) {
            if (this.hasMiniProgress != 0) {
                if (this.miniButtonState != 1) {
                    updateButtonState(false, false, false);
                }
            } else if (this.buttonState != 4) {
                updateButtonState(false, false, false);
            }
        } else if (this.hasMiniProgress != 0) {
            if (this.miniButtonState != 1) {
                updateButtonState(false, false, false);
            }
        } else if (this.buttonState != 1) {
            updateButtonState(false, false, false);
        }
        int iMax = (int) Math.max(this.MIN_PREVIEW_DOWNLOAD_SIZE, totalSize / 10);
        if (this.documentAttachType != 4 || downloadedSize <= iMax || downloadedSize == totalSize) {
            return;
        }
        if (this.hasMiniProgress != 0) {
            if (this.miniButtonState != 1) {
                updateButtonState(false, false, false);
            }
        } else if (this.buttonState != 1) {
            updateButtonState(false, false, false);
        }
        FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.documentAttach);
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.showPreview = true;
        restartPreview();
        Log.d("downloadInfo", "download end reached | TotalSize:" + totalSize + " | downloadedSize:" + downloadedSize);
    }

    public void restartPreview() {
        new Handler().postDelayed(new Runnable() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.6
            @Override // java.lang.Runnable
            public void run() {
                if (ExploreCell.this.showPreview) {
                    Log.d("downloadInfo", "video Restarted **********");
                    if (ExploreCell.this.photoImage.getAnimation() != null) {
                        ExploreCell.this.photoImage.getAnimation().seekTo(0L, false, true);
                    }
                    ExploreCell.this.restartPreview();
                }
            }
        }, 5000L);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
        int i;
        float fMin = totalSize == 0 ? 0.0f : Math.min(1.0f, uploadedSize / totalSize);
        this.currentMessageObject.loadedFileSize = uploadedSize;
        this.radialProgress.setProgress(fMin, true);
        if (uploadedSize == totalSize && this.currentPosition != null && SendMessagesHelper.getInstance(this.currentAccount).isSendingMessage(this.currentMessageObject.getId()) && ((i = this.buttonState) == 1 || (i == 4 && this.documentAttachType == 5))) {
            this.drawRadialCheckBackground = true;
            getIconForCurrentState();
            this.radialProgress.setIcon(6, false, true);
        }
        createLoadingProgressLayout(uploadedSize, totalSize);
    }

    private void createLoadingProgressLayout(TLRPC$Document document) {
        if (document == null) {
            return;
        }
        long[] fileProgressSizes = ImageLoader.getInstance().getFileProgressSizes(FileLoader.getDocumentFileName(document));
        if (fileProgressSizes != null) {
            createLoadingProgressLayout(fileProgressSizes[0], fileProgressSizes[1]);
        } else {
            createLoadingProgressLayout(this.currentMessageObject.loadedFileSize, document.size);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createLoadingProgressLayout(long r17, long r19) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.createLoadingProgressLayout(long, long):void");
    }

    @Override // android.view.View
    public void onProvideStructure(ViewStructure structure) {
        super.onProvideStructure(structure);
        if (!this.allowAssistant || Build.VERSION.SDK_INT < 23) {
            return;
        }
        CharSequence charSequence = this.currentMessageObject.messageText;
        if (charSequence != null && charSequence.length() > 0) {
            structure.setText(this.currentMessageObject.messageText);
            return;
        }
        CharSequence charSequence2 = this.currentMessageObject.caption;
        if (charSequence2 == null || charSequence2.length() <= 0) {
            return;
        }
        structure.setText(this.currentMessageObject.caption);
    }

    public void setDelegate(ExploreCellDelegate chatMessageCellDelegate) {
        this.delegate = chatMessageCellDelegate;
    }

    public ExploreCellDelegate getDelegate() {
        return this.delegate;
    }

    public void setAllowAssistant(boolean value) {
        this.allowAssistant = value;
    }

    private void measureTime(MessageObject messageObject) {
        TLRPC$User user;
        String str;
        long fromChatId = messageObject.getFromChatId();
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message.post_author != null) {
            if (!this.isMegagroup || messageObject.getFromChatId() != messageObject.getDialogId()) {
                messageObject.messageOwner.post_author.replace("\n", "");
            }
        } else {
            TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from;
            if (tLRPC$MessageFwdHeader != null && (str = tLRPC$MessageFwdHeader.post_author) != null) {
                str.replace("\n", "");
            } else if (tLRPC$MessageFwdHeader != null && tLRPC$MessageFwdHeader.imported) {
                if (tLRPC$MessageFwdHeader.date == tLRPC$Message.date) {
                    LocaleController.getString("ImportedMessage", ir.eitaa.messenger.R.string.ImportedMessage);
                } else {
                    String str2 = LocaleController.formatImportedDate(messageObject.messageOwner.fwd_from.date) + " " + LocaleController.getString("ImportedMessage", ir.eitaa.messenger.R.string.ImportedMessage);
                }
            } else if (!messageObject.isOutOwner() && fromChatId > 0 && messageObject.messageOwner.post && (user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(fromChatId))) != null) {
                ContactsController.formatName(user.first_name, user.last_name).replace('\n', ' ');
            }
        }
        String strFixNumbers = AndroidUtilities.fixNumbers(" " + new ExploreDateFormatter().toTimeAgo(Long.valueOf(messageObject.messageOwner.date * 1000)) + " ");
        this.currentTimeString = strFixNumbers;
        int iCeil = (int) Math.ceil((double) Theme.chat_timePaint.measureText(strFixNumbers));
        this.timeWidth = iCeil;
        this.timeTextWidth = iCeil;
        MessageObject messageObject2 = this.currentMessageObject;
        if (messageObject2.scheduled && messageObject2.messageOwner.date == 2147483646) {
            this.timeWidth = iCeil - AndroidUtilities.dp(8.0f);
        }
        if ((messageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
            this.currentViewsString = "";
            this.viewsTextWidth = 0;
        }
    }

    private boolean isDrawSelectionBackground() {
        return ((isPressed() && this.isCheckPressed) || ((!this.isCheckPressed && this.isPressed) || this.isHighlighted)) && !textIsSelectionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpenChatByShare(MessageObject messageObject) {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
        return (tLRPC$MessageFwdHeader == null || tLRPC$MessageFwdHeader.saved_from_peer == null) ? false : true;
    }

    private void updateCurrentUserAndChat() {
        TLRPC$Peer tLRPC$Peer;
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.currentMessageObject.messageOwner.fwd_from;
        long clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
        if (tLRPC$MessageFwdHeader != null && (tLRPC$MessageFwdHeader.from_id instanceof TLRPC$TL_peerChannel) && this.currentMessageObject.getDialogId() == clientUserId) {
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(tLRPC$MessageFwdHeader.from_id.channel_id));
            return;
        }
        if (tLRPC$MessageFwdHeader != null && (tLRPC$Peer = tLRPC$MessageFwdHeader.saved_from_peer) != null) {
            long j = tLRPC$Peer.user_id;
            if (j != 0) {
                TLRPC$Peer tLRPC$Peer2 = tLRPC$MessageFwdHeader.from_id;
                if (tLRPC$Peer2 instanceof TLRPC$TL_peerUser) {
                    this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$Peer2.user_id));
                    return;
                } else {
                    this.currentUser = messagesController.getUser(Long.valueOf(j));
                    return;
                }
            }
            if (tLRPC$Peer.channel_id != 0) {
                if (this.currentMessageObject.isSavedFromMegagroup()) {
                    TLRPC$Peer tLRPC$Peer3 = tLRPC$MessageFwdHeader.from_id;
                    if (tLRPC$Peer3 instanceof TLRPC$TL_peerUser) {
                        this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$Peer3.user_id));
                        return;
                    }
                }
                this.currentChat = messagesController.getChat(Long.valueOf(tLRPC$MessageFwdHeader.saved_from_peer.channel_id));
                return;
            }
            long j2 = tLRPC$Peer.chat_id;
            if (j2 != 0) {
                TLRPC$Peer tLRPC$Peer4 = tLRPC$MessageFwdHeader.from_id;
                if (tLRPC$Peer4 instanceof TLRPC$TL_peerUser) {
                    this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$Peer4.user_id));
                    return;
                } else {
                    this.currentChat = messagesController.getChat(Long.valueOf(j2));
                    return;
                }
            }
            return;
        }
        if (tLRPC$MessageFwdHeader != null && (tLRPC$MessageFwdHeader.from_id instanceof TLRPC$TL_peerUser) && (tLRPC$MessageFwdHeader.imported || this.currentMessageObject.getDialogId() == clientUserId)) {
            this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$MessageFwdHeader.from_id.user_id));
            return;
        }
        if (tLRPC$MessageFwdHeader != null && !TextUtils.isEmpty(tLRPC$MessageFwdHeader.from_name) && (tLRPC$MessageFwdHeader.imported || this.currentMessageObject.getDialogId() == clientUserId)) {
            TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
            this.currentUser = tLRPC$TL_user;
            tLRPC$TL_user.first_name = tLRPC$MessageFwdHeader.from_name;
            return;
        }
        long fromChatId = this.currentMessageObject.getFromChatId();
        if (DialogObject.isUserDialog(fromChatId) && !this.currentMessageObject.messageOwner.post) {
            this.currentUser = messagesController.getUser(Long.valueOf(fromChatId));
            return;
        }
        if (DialogObject.isChatDialog(fromChatId)) {
            this.currentChat = messagesController.getChat(Long.valueOf(-fromChatId));
            return;
        }
        TLRPC$Message tLRPC$Message = this.currentMessageObject.messageOwner;
        if (tLRPC$Message.post) {
            this.currentChat = messagesController.getChat(Long.valueOf(tLRPC$Message.peer_id.channel_id));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:238|(2:242|(1:244))|245|(1:247)(2:248|(1:250))|251|(9:257|(3:259|(3:261|(1:263)(1:264)|265)(1:266)|267)(1:268)|(1:270)|(1:288)(3:283|(1:285)(1:286)|287)|289|(2:292|(2:294|(1:296)(1:305))(2:297|(2:299|(1:301)(0))(2:302|(1:304)(0))))|(1:307)|308|(1:310)(2:311|(1:313)(2:314|(3:316|(1:318)(1:319)|320)(2:321|(1:330)(3:325|(1:327)(1:328)|329)))))(6:332|(1:334)(2:335|(1:337)(2:338|(1:340)))|341|(1:343)|344|(7:352|(1:(1:355)(1:356))(1:(1:358)(1:359))|360|(1:362)(1:363)|364|(1:370)|371)(14:351|(1:374)|375|410|376|(1:378)(1:379)|380|(2:382|(1:384))|388|405|389|(1:391)(1:392)|393|(2:395|(1:397))))|331|(0)|375|410|376|(0)(0)|380|(0)|388|405|389|(0)(0)|393|(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:47|(1:49)|50|(1:59)(16:56|(1:58)|67|(1:86)(1:87)|88|(1:90)(1:91)|92|(8:94|(1:96)|97|(1:99)(3:101|(1:103)(1:104)|105)|100|106|(1:108)(1:109)|110)(1:111)|112|409|113|(3:115|(1:117)|118)(1:119)|(1:121)(1:122)|126|(1:128)|129)|60|(2:68|(14:84|(0)(0)|88|(0)(0)|92|(0)(0)|112|409|113|(0)(0)|(0)(0)|126|(0)|129)(3:80|(1:82)|83))(1:66)|67|(0)(0)|88|(0)(0)|92|(0)(0)|112|409|113|(0)(0)|(0)(0)|126|(0)|129) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x03c2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03c3, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0b61, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x0b62, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x035f A[Catch: Exception -> 0x03c2, TryCatch #3 {Exception -> 0x03c2, blocks: (B:113:0x033c, B:115:0x035f, B:117:0x0374, B:118:0x037f, B:121:0x038e, B:122:0x03be, B:119:0x0389), top: B:409:0x033c }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0389 A[Catch: Exception -> 0x03c2, TryCatch #3 {Exception -> 0x03c2, blocks: (B:113:0x033c, B:115:0x035f, B:117:0x0374, B:118:0x037f, B:121:0x038e, B:122:0x03be, B:119:0x0389), top: B:409:0x033c }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x038e A[Catch: Exception -> 0x03c2, TryCatch #3 {Exception -> 0x03c2, blocks: (B:113:0x033c, B:115:0x035f, B:117:0x0374, B:118:0x037f, B:121:0x038e, B:122:0x03be, B:119:0x0389), top: B:409:0x033c }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03be A[Catch: Exception -> 0x03c2, TRY_LEAVE, TryCatch #3 {Exception -> 0x03c2, blocks: (B:113:0x033c, B:115:0x035f, B:117:0x0374, B:118:0x037f, B:121:0x038e, B:122:0x03be, B:119:0x0389), top: B:409:0x033c }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08c6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0af6  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0b0e  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0b11  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0b1c A[Catch: Exception -> 0x0b61, TryCatch #4 {Exception -> 0x0b61, blocks: (B:376:0x0b0a, B:380:0x0b12, B:382:0x0b1c, B:384:0x0b3d), top: B:410:0x0b0a }] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0b6a  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0b6d  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0b78 A[Catch: Exception -> 0x0bba, TryCatch #1 {Exception -> 0x0bba, blocks: (B:389:0x0b66, B:393:0x0b6e, B:395:0x0b78, B:397:0x0b96), top: B:405:0x0b66 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0247  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$User, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v145 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageObjectInternal(ir.eitaa.messenger.MessageObject r40) {
        /*
            Method dump skipped, instructions count: 3010
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.setMessageObjectInternal(ir.eitaa.messenger.MessageObject):void");
    }

    private boolean isNeedAuthorName() {
        return (this.isPinnedChat && this.currentMessageObject.type == 0) || ((!this.pinnedTop || (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup)) && this.drawName && this.isChat && (!this.currentMessageObject.isOutOwner() || (this.currentMessageObject.isSupergroup() && this.currentMessageObject.isFromGroup()))) || (this.currentMessageObject.isImportedForward() && this.currentMessageObject.messageOwner.fwd_from.from_id == null);
    }

    private String getAuthorName() {
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User != null) {
            return UserObject.getUserName(tLRPC$User);
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        return tLRPC$Chat != null ? tLRPC$Chat.title : "DELETED";
    }

    private String getForwardedMessageText(MessageObject messageObject) {
        if (this.hasPsaHint) {
            String string = LocaleController.getString("PsaMessage_" + messageObject.messageOwner.fwd_from.psa_type);
            return string == null ? LocaleController.getString("PsaMessageDefault", ir.eitaa.messenger.R.string.PsaMessageDefault) : string;
        }
        return LocaleController.getString("ForwardedMessage", ir.eitaa.messenger.R.string.ForwardedMessage);
    }

    public int getExtraInsetHeight() {
        int i = this.addedCaptionHeight;
        if (this.drawCommentButton) {
            return i + AndroidUtilities.dp(shouldDrawTimeOnMedia() ? 41.3f : 43.0f);
        }
        return i;
    }

    public ImageReceiver getAvatarImage() {
        if (this.isAvatarVisible) {
            return this.avatarImage;
        }
        return null;
    }

    public float getCheckBoxTranslation() {
        return this.checkBoxTranslation;
    }

    public float getCaptionX() {
        return this.captionX;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[PHI: r3 r5
      0x003d: PHI (r3v3 int) = (r3v2 int), (r3v9 int) binds: [B:16:0x001a, B:18:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x003d: PHI (r5v1 int) = (r5v0 int), (r5v4 int) binds: [B:16:0x001a, B:18:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setBackgroundTopY(boolean r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 2
            if (r1 >= r2) goto L5f
            r2 = 1
            if (r1 != r2) goto Lb
            if (r12 != 0) goto Lb
            return
        Lb:
            if (r1 != 0) goto L10
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r3 = r11.currentBackgroundDrawable
            goto L12
        L10:
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r3 = r11.currentBackgroundSelectedDrawable
        L12:
            r4 = r3
            if (r4 != 0) goto L16
            goto L5c
        L16:
            int r3 = r11.parentWidth
            int r5 = r11.parentHeight
            if (r5 != 0) goto L3d
            int r3 = r11.getParentWidth()
            android.graphics.Point r5 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r5 = r5.y
            android.view.ViewParent r6 = r11.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L3d
            android.view.ViewParent r3 = r11.getParent()
            android.view.View r3 = (android.view.View) r3
            int r5 = r3.getMeasuredWidth()
            int r3 = r3.getMeasuredHeight()
            r7 = r3
            r6 = r5
            goto L3f
        L3d:
            r6 = r3
            r7 = r5
        L3f:
            float r3 = r11.getY()
            int r5 = (int) r3
            r8 = 0
            boolean r9 = r11.pinnedTop
            boolean r3 = r11.pinnedBottom
            if (r3 != 0) goto L58
            ir.eitaa.ui.explore.cells.ExploreCell$TransitionParams r3 = r11.transitionParams
            float r3 = r3.changePinnedBottomProgress
            r10 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 == 0) goto L56
            goto L58
        L56:
            r10 = 0
            goto L59
        L58:
            r10 = 1
        L59:
            r4.setTop(r5, r6, r7, r8, r9, r10)
        L5c:
            int r1 = r1 + 1
            goto L2
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.setBackgroundTopY(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0028 A[PHI: r1 r2
      0x0028: PHI (r1v1 int) = (r1v0 int), (r1v7 int) binds: [B:3:0x0006, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]
      0x0028: PHI (r2v1 int) = (r2v0 int), (r2v5 int) binds: [B:3:0x0006, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setBackgroundTopY(int r8) {
        /*
            r7 = this;
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r0 = r7.currentBackgroundDrawable
            int r1 = r7.parentWidth
            int r2 = r7.parentHeight
            if (r2 != 0) goto L28
            int r1 = r7.getParentWidth()
            android.graphics.Point r2 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r2 = r2.y
            android.view.ViewParent r3 = r7.getParent()
            boolean r3 = r3 instanceof android.view.View
            if (r3 == 0) goto L28
            android.view.ViewParent r1 = r7.getParent()
            android.view.View r1 = (android.view.View) r1
            int r2 = r1.getMeasuredWidth()
            int r1 = r1.getMeasuredHeight()
            r3 = r1
            goto L2a
        L28:
            r3 = r2
            r2 = r1
        L2a:
            int r1 = r7.getTop()
            float r1 = (float) r1
            float r4 = r7.parentViewTopOffset
            float r1 = r1 + r4
            float r8 = (float) r8
            float r1 = r1 + r8
            int r1 = (int) r1
            int r4 = (int) r4
            boolean r5 = r7.pinnedTop
            boolean r8 = r7.pinnedBottom
            if (r8 != 0) goto L4a
            ir.eitaa.ui.explore.cells.ExploreCell$TransitionParams r8 = r7.transitionParams
            float r8 = r8.changePinnedBottomProgress
            r6 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L47
            goto L4a
        L47:
            r8 = 0
            r6 = 0
            goto L4c
        L4a:
            r8 = 1
            r6 = 1
        L4c:
            r0.setTop(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.setBackgroundTopY(int):void");
    }

    public void setDrawableBoundsInner(Drawable drawable, int x, int y, int w, int h) {
        if (drawable != null) {
            float f = h + y;
            TransitionParams transitionParams = this.transitionParams;
            float f2 = transitionParams.deltaBottom;
            this.transitionYOffsetForDrawables = (f + f2) - ((int) (f + f2));
            drawable.setBounds((int) (x + transitionParams.deltaLeft), (int) (y + transitionParams.deltaTop), (int) (x + w + transitionParams.deltaRight), (int) (f + f2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04a1 A[PHI: r1 r9
      0x04a1: PHI (r1v102 int) = (r1v101 int), (r1v117 int) binds: [B:184:0x047c, B:186:0x048c] A[DONT_GENERATE, DONT_INLINE]
      0x04a1: PHI (r9v38 int) = (r9v37 int), (r9v42 int) binds: [B:184:0x047c, B:186:0x048c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongCall"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r27) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1875
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.onDraw(android.graphics.Canvas):void");
    }

    private void applyServiceShaderMatrix(int measuredWidth, int backgroundHeight, float x, float viewTop) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider != null) {
            resourcesProvider.applyServiceShaderMatrix(measuredWidth, backgroundHeight, x, viewTop);
        } else {
            Theme.applyServiceShaderMatrix(measuredWidth, backgroundHeight, x, viewTop);
        }
    }

    public void setTimeAlpha(float value) {
        this.timeAlpha = value;
    }

    public float getTimeAlpha() {
        return this.timeAlpha;
    }

    public int getBackgroundDrawableLeft() {
        int i;
        if (this.currentMessageObject.isOutOwner()) {
            return (this.layoutWidth - this.backgroundWidth) - (this.mediaBackground ? AndroidUtilities.dp(9.0f) : 0);
        }
        if (this.isChat && this.isAvatarVisible) {
            i = 48;
        }
        int iDp = AndroidUtilities.dp(i + (!this.mediaBackground ? 3 : 9));
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && !groupedMessages.isDocuments && (i = this.currentPosition.leftSpanOffset) != 0) {
            iDp += (int) Math.ceil((i / 1000.0f) * getGroupPhotosWidth());
        }
        return (this.mediaBackground || !this.drawPinnedBottom) ? iDp : iDp + AndroidUtilities.dp(6.0f);
    }

    public int getBackgroundDrawableRight() {
        int iDp = this.backgroundWidth - (this.mediaBackground ? 0 : AndroidUtilities.dp(3.0f));
        if (!this.mediaBackground && this.drawPinnedBottom && this.currentMessageObject.isOutOwner()) {
            iDp -= AndroidUtilities.dp(6.0f);
        }
        if (!this.mediaBackground && this.drawPinnedBottom && !this.currentMessageObject.isOutOwner()) {
            iDp -= AndroidUtilities.dp(6.0f);
        }
        return getBackgroundDrawableLeft() + iDp;
    }

    public int getBackgroundDrawableTop() {
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        return ((groupedMessagePosition == null || (groupedMessagePosition.flags & 4) != 0) ? 0 : 0 - AndroidUtilities.dp(3.0f)) + (this.drawPinnedTop ? 0 : AndroidUtilities.dp(1.0f));
    }

    public int getBackgroundDrawableBottom() {
        int iDp;
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        int iDp2 = 0;
        if (groupedMessagePosition != null) {
            iDp = (groupedMessagePosition.flags & 4) == 0 ? AndroidUtilities.dp(3.0f) + 0 : 0;
            if ((this.currentPosition.flags & 8) == 0) {
                iDp += AndroidUtilities.dp(this.currentMessageObject.isOutOwner() ? 3 : 4);
            }
        } else {
            iDp = 0;
        }
        boolean z = this.drawPinnedBottom;
        if (!z || !this.drawPinnedTop) {
            if (z) {
                iDp2 = AndroidUtilities.dp(1.0f);
            } else {
                iDp2 = AndroidUtilities.dp(2.0f);
            }
        }
        return ((getBackgroundDrawableTop() + this.layoutHeight) - iDp2) + iDp;
    }

    public void setDrawSelectionBackground(boolean value) {
        if (this.drawSelectionBackground != value) {
            this.drawSelectionBackground = value;
            invalidate();
        }
    }

    public float getHightlightAlpha() {
        int i;
        if (this.drawSelectionBackground || !this.isHighlightedAnimated || (i = this.highlightProgress) >= 300) {
            return 1.0f;
        }
        return i / 300.0f;
    }

    public MessageBackgroundDrawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public void drawCaptionLayout(Canvas canvas, boolean selectionOnly, float alpha) {
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.animateReplaceCaptionLayout || transitionParams.animateChangeProgress == 1.0f) {
            drawCaptionLayout(canvas, this.captionLayout, selectionOnly, alpha);
        } else {
            drawCaptionLayout(canvas, transitionParams.animateOutCaptionLayout, selectionOnly, (1.0f - this.transitionParams.animateChangeProgress) * alpha);
            drawCaptionLayout(canvas, this.captionLayout, selectionOnly, alpha * this.transitionParams.animateChangeProgress);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0784 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawCaptionLayout(android.graphics.Canvas r27, android.text.StaticLayout r28, boolean r29, float r30) {
        /*
            Method dump skipped, instructions count: 1992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawCaptionLayout(android.graphics.Canvas, android.text.StaticLayout, boolean, float):void");
    }

    public boolean shouldDrawTimeOnMedia() {
        int i = this.overideShouldDrawTimeOnMedia;
        return i != 0 ? i == 1 : this.mediaBackground && this.captionLayout == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawTime(android.graphics.Canvas r17, float r18, boolean r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawTime(android.graphics.Canvas, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0312  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawTimeInternal(android.graphics.Canvas r30, float r31, boolean r32, float r33, android.text.StaticLayout r34, float r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 1123
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawTimeInternal(android.graphics.Canvas, float, boolean, float, android.text.StaticLayout, float, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createStatusDrawableAnimator(int lastStatusDrawableParams, int currentStatus, final boolean fromParent) {
        boolean z = false;
        boolean z2 = (currentStatus & 1) != 0;
        boolean z3 = (currentStatus & 2) != 0;
        boolean z4 = (currentStatus & 16) != 0;
        boolean z5 = (lastStatusDrawableParams & 1) != 0;
        boolean z6 = (lastStatusDrawableParams & 2) != 0;
        boolean z7 = (lastStatusDrawableParams & 4) != 0;
        boolean z8 = (lastStatusDrawableParams & 16) != 0;
        if (!z7 && !z4 && !z8 && z6 && z3 && !z5 && z2) {
            z = true;
        }
        if (!this.transitionParams.messageEntering || z) {
            this.statusDrawableProgress = 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.statusDrawableAnimator = valueAnimatorOfFloat;
            if (z) {
                valueAnimatorOfFloat.setDuration(220L);
            } else {
                valueAnimatorOfFloat.setDuration(150L);
            }
            this.statusDrawableAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.animateFromStatusDrawableParams = lastStatusDrawableParams;
            this.animateToStatusDrawableParams = currentStatus;
            this.statusDrawableAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$ExploreCell$wpbxjEctuMHLD-CALjBF9f3uBkc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createStatusDrawableAnimator$0$ExploreCell(fromParent, valueAnimator);
                }
            });
            this.statusDrawableAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.explore.cells.ExploreCell.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    int iCreateStatusDrawableParams = ExploreCell.this.transitionParams.createStatusDrawableParams();
                    if (ExploreCell.this.animateToStatusDrawableParams == iCreateStatusDrawableParams) {
                        ExploreCell.this.statusDrawableAnimationInProgress = false;
                        ExploreCell.this.transitionParams.lastStatusDrawableParams = ExploreCell.this.animateToStatusDrawableParams;
                    } else {
                        ExploreCell exploreCell = ExploreCell.this;
                        exploreCell.createStatusDrawableAnimator(exploreCell.animateToStatusDrawableParams, iCreateStatusDrawableParams, fromParent);
                    }
                }
            });
            this.statusDrawableAnimationInProgress = true;
            this.statusDrawableAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createStatusDrawableAnimator$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createStatusDrawableAnimator$0$ExploreCell(boolean z, ValueAnimator valueAnimator) {
        this.statusDrawableProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        if (!z || getParent() == null) {
            return;
        }
        ((View) getParent()).invalidate();
    }

    private void drawClockOrErrorLayout(Canvas canvas, boolean drawTime, boolean drawError, float layoutHeight, float alpha, float timeYOffset, float timeX, float progress, boolean drawSelectionBackground) {
        float fDp;
        int themedColor;
        float fDp2;
        boolean z = progress != 1.0f;
        float f = (progress * 0.5f) + 0.5f;
        float f2 = alpha * progress;
        if (drawTime) {
            if (this.currentMessageObject.isOutOwner()) {
                return;
            }
            MsgClockDrawable msgClockDrawable = Theme.chat_msgClockDrawable;
            if (shouldDrawTimeOnMedia()) {
                themedColor = getThemedColor("chat_mediaSentClock");
            } else {
                themedColor = getThemedColor(drawSelectionBackground ? "chat_outSentClockSelected" : "chat_mediaSentClock");
            }
            msgClockDrawable.setColor(themedColor);
            if (shouldDrawTimeOnMedia()) {
                fDp2 = (this.photoImage.getImageY2() + this.additionalTimeOffsetY) - AndroidUtilities.dp(9.0f);
            } else {
                fDp2 = (layoutHeight - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.5f : 8.5f)) + timeYOffset;
            }
            BaseCell.setDrawableBounds(msgClockDrawable, timeX + (this.currentMessageObject.scheduled ? 0 : AndroidUtilities.dp(11.0f)), fDp2 - msgClockDrawable.getIntrinsicHeight());
            msgClockDrawable.setAlpha((int) (f2 * 255.0f));
            if (z) {
                canvas.save();
                canvas.scale(f, f, msgClockDrawable.getBounds().centerX(), msgClockDrawable.getBounds().centerY());
            }
            msgClockDrawable.draw(canvas);
            msgClockDrawable.setAlpha(255);
            invalidate();
            if (z) {
                canvas.restore();
                return;
            }
            return;
        }
        if (!drawError || this.currentMessageObject.isOutOwner()) {
            return;
        }
        float fDp3 = timeX + (this.currentMessageObject.scheduled ? 0 : AndroidUtilities.dp(11.0f));
        float f3 = 21.5f;
        if (shouldDrawTimeOnMedia()) {
            fDp = (this.photoImage.getImageY2() + this.additionalTimeOffsetY) - AndroidUtilities.dp(21.5f);
        } else {
            if (!this.pinnedBottom && !this.pinnedTop) {
                f3 = 20.5f;
            }
            fDp = (layoutHeight - AndroidUtilities.dp(f3)) + timeYOffset;
        }
        this.rect.set(fDp3, fDp, AndroidUtilities.dp(14.0f) + fDp3, AndroidUtilities.dp(14.0f) + fDp);
        int alpha2 = Theme.chat_msgErrorPaint.getAlpha();
        int i = (int) (f2 * 255.0f);
        Theme.chat_msgErrorPaint.setAlpha(i);
        if (z) {
            canvas.save();
            canvas.scale(f, f, this.rect.centerX(), this.rect.centerY());
        }
        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), Theme.chat_msgErrorPaint);
        Theme.chat_msgErrorPaint.setAlpha(alpha2);
        Drawable themedDrawable = getThemedDrawable("drawableMsgError");
        BaseCell.setDrawableBounds(themedDrawable, fDp3 + AndroidUtilities.dp(6.0f), fDp + AndroidUtilities.dp(2.0f));
        themedDrawable.setAlpha(i);
        themedDrawable.draw(canvas);
        themedDrawable.setAlpha(255);
        if (z) {
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawViewsAndRepliesLayout(android.graphics.Canvas r24, float r25, float r26, float r27, float r28, float r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawViewsAndRepliesLayout(android.graphics.Canvas, float, float, float, float, float, boolean):void");
    }

    private void drawStatusDrawable(Canvas canvas, boolean drawCheck1, boolean drawCheck2, boolean drawClock, boolean drawError, boolean isBroadcast, float alpha, boolean bigRadius, float timeYOffset, float layoutHeight, float progress, boolean moveCheck, boolean drawSelectionBackground) {
        Drawable themedDrawable;
        Drawable themedDrawable2;
        Drawable themedDrawable3;
        int iDp;
        int iDp2;
        Drawable drawable;
        int themedColor;
        boolean z = (progress == 1.0f || moveCheck) ? false : true;
        float f = (progress * 0.5f) + 0.5f;
        float f2 = z ? alpha * progress : alpha;
        float imageY2 = (this.photoImage.getImageY2() + this.additionalTimeOffsetY) - AndroidUtilities.dp(8.5f);
        if (drawClock) {
            MsgClockDrawable msgClockDrawable = Theme.chat_msgClockDrawable;
            if (shouldDrawTimeOnMedia()) {
                if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                    themedColor = getThemedColor("chat_serviceText");
                    BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 24.0f : 22.0f)) - msgClockDrawable.getIntrinsicWidth(), (imageY2 - msgClockDrawable.getIntrinsicHeight()) + timeYOffset);
                    msgClockDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f2));
                } else {
                    themedColor = getThemedColor("chat_mediaSentClock");
                    BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 24.0f : 22.0f)) - msgClockDrawable.getIntrinsicWidth(), (imageY2 - msgClockDrawable.getIntrinsicHeight()) + timeYOffset);
                    msgClockDrawable.setAlpha((int) (f2 * 255.0f));
                }
            } else {
                int themedColor2 = getThemedColor("chat_outSentClock");
                BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(18.5f)) - msgClockDrawable.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp(8.5f)) - msgClockDrawable.getIntrinsicHeight()) + timeYOffset);
                msgClockDrawable.setAlpha((int) (f2 * 255.0f));
                themedColor = themedColor2;
            }
            msgClockDrawable.setColor(themedColor);
            if (z) {
                canvas.save();
                canvas.scale(f, f, msgClockDrawable.getBounds().centerX(), msgClockDrawable.getBounds().centerY());
            }
            msgClockDrawable.draw(canvas);
            msgClockDrawable.setAlpha(255);
            if (z) {
                canvas.restore();
            }
            invalidate();
        }
        if (!isBroadcast) {
            if (drawCheck2) {
                if (shouldDrawTimeOnMedia()) {
                    if (moveCheck) {
                        canvas.save();
                    }
                    if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                        themedDrawable3 = getThemedDrawable("drawableMsgStickerCheck");
                        if (drawCheck1) {
                            if (moveCheck) {
                                canvas.translate(AndroidUtilities.dp(4.8f) * (1.0f - progress), 0.0f);
                            }
                            BaseCell.setDrawableBounds(themedDrawable3, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 28.3f : 26.3f)) - themedDrawable3.getIntrinsicWidth(), (imageY2 - themedDrawable3.getIntrinsicHeight()) + timeYOffset);
                        } else {
                            BaseCell.setDrawableBounds(themedDrawable3, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 23.5f : 21.5f)) - themedDrawable3.getIntrinsicWidth(), (imageY2 - themedDrawable3.getIntrinsicHeight()) + timeYOffset);
                        }
                        themedDrawable3.setAlpha((int) (this.timeAlpha * 255.0f * f2));
                    } else {
                        if (drawCheck1) {
                            if (moveCheck) {
                                canvas.translate(AndroidUtilities.dp(4.8f) * (1.0f - progress), 0.0f);
                            }
                            BaseCell.setDrawableBounds(Theme.chat_msgMediaCheckDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 28.3f : 26.3f)) - Theme.chat_msgMediaCheckDrawable.getIntrinsicWidth(), (imageY2 - Theme.chat_msgMediaCheckDrawable.getIntrinsicHeight()) + timeYOffset);
                        } else {
                            BaseCell.setDrawableBounds(Theme.chat_msgMediaCheckDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 23.5f : 21.5f)) - Theme.chat_msgMediaCheckDrawable.getIntrinsicWidth(), (imageY2 - Theme.chat_msgMediaCheckDrawable.getIntrinsicHeight()) + timeYOffset);
                        }
                        Theme.chat_msgMediaCheckDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f2));
                        themedDrawable3 = Theme.chat_msgMediaCheckDrawable;
                    }
                    if (z) {
                        canvas.save();
                        canvas.scale(f, f, themedDrawable3.getBounds().centerX(), themedDrawable3.getBounds().centerY());
                    }
                    themedDrawable3.draw(canvas);
                    if (z) {
                        canvas.restore();
                    }
                    if (moveCheck) {
                        canvas.restore();
                    }
                    themedDrawable3.setAlpha(255);
                } else {
                    if (moveCheck) {
                        canvas.save();
                    }
                    if (drawCheck1) {
                        if (moveCheck) {
                            canvas.translate(AndroidUtilities.dp(4.0f) * (1.0f - progress), 0.0f);
                        }
                        themedDrawable2 = getThemedDrawable(drawSelectionBackground ? "drawableMsgOutCheckReadSelected" : "drawableMsgOutCheckRead");
                        BaseCell.setDrawableBounds(themedDrawable2, (this.layoutWidth - AndroidUtilities.dp(22.5f)) - themedDrawable2.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.0f : 8.0f)) - themedDrawable2.getIntrinsicHeight()) + timeYOffset);
                    } else {
                        Drawable themedDrawable4 = getThemedDrawable(drawSelectionBackground ? "drawableMsgOutCheckSelected" : "drawableMsgOutCheck");
                        BaseCell.setDrawableBounds(themedDrawable4, (this.layoutWidth - AndroidUtilities.dp(18.5f)) - themedDrawable4.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.0f : 8.0f)) - themedDrawable4.getIntrinsicHeight()) + timeYOffset);
                        themedDrawable2 = themedDrawable4;
                    }
                    themedDrawable2.setAlpha((int) (f2 * 255.0f));
                    if (z) {
                        canvas.save();
                        canvas.scale(f, f, themedDrawable2.getBounds().centerX(), themedDrawable2.getBounds().centerY());
                    }
                    themedDrawable2.draw(canvas);
                    if (z) {
                        canvas.restore();
                    }
                    if (moveCheck) {
                        canvas.restore();
                    }
                    themedDrawable2.setAlpha(255);
                }
            }
            if (drawCheck1) {
                if (shouldDrawTimeOnMedia()) {
                    if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                        themedDrawable = getThemedDrawable("drawableMsgStickerHalfCheck");
                        BaseCell.setDrawableBounds(themedDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 23.5f : 21.5f)) - themedDrawable.getIntrinsicWidth(), (imageY2 - themedDrawable.getIntrinsicHeight()) + timeYOffset);
                        themedDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f2));
                    } else {
                        themedDrawable = Theme.chat_msgMediaHalfCheckDrawable;
                        BaseCell.setDrawableBounds(themedDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 23.5f : 21.5f)) - themedDrawable.getIntrinsicWidth(), (imageY2 - themedDrawable.getIntrinsicHeight()) + timeYOffset);
                        themedDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f2));
                    }
                    if (z || moveCheck) {
                        canvas.save();
                        canvas.scale(f, f, themedDrawable.getBounds().centerX(), themedDrawable.getBounds().centerY());
                    }
                    themedDrawable.draw(canvas);
                    if (z || moveCheck) {
                        canvas.restore();
                    }
                    themedDrawable.setAlpha(255);
                } else {
                    Drawable themedDrawable5 = getThemedDrawable(drawSelectionBackground ? "drawableMsgOutHalfCheckSelected" : "drawableMsgOutHalfCheck");
                    BaseCell.setDrawableBounds(themedDrawable5, (this.layoutWidth - AndroidUtilities.dp(18.0f)) - themedDrawable5.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.0f : 8.0f)) - themedDrawable5.getIntrinsicHeight()) + timeYOffset);
                    themedDrawable5.setAlpha((int) (f2 * 255.0f));
                    if (z || moveCheck) {
                        canvas.save();
                        canvas.scale(f, f, themedDrawable5.getBounds().centerX(), themedDrawable5.getBounds().centerY());
                    }
                    themedDrawable5.draw(canvas);
                    if (z || moveCheck) {
                        canvas.restore();
                    }
                    themedDrawable5.setAlpha(255);
                }
            }
        } else if (drawCheck1 || drawCheck2) {
            if (shouldDrawTimeOnMedia()) {
                BaseCell.setDrawableBounds(Theme.chat_msgBroadcastMediaDrawable, (this.layoutWidth - AndroidUtilities.dp(bigRadius ? 26.0f : 24.0f)) - Theme.chat_msgBroadcastMediaDrawable.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp(14.0f)) - Theme.chat_msgBroadcastMediaDrawable.getIntrinsicHeight()) + timeYOffset);
                Theme.chat_msgBroadcastMediaDrawable.setAlpha((int) (f2 * 255.0f));
                drawable = Theme.chat_msgBroadcastMediaDrawable;
            } else {
                BaseCell.setDrawableBounds(Theme.chat_msgBroadcastDrawable, (this.layoutWidth - AndroidUtilities.dp(20.5f)) - Theme.chat_msgBroadcastDrawable.getIntrinsicWidth(), ((layoutHeight - AndroidUtilities.dp(8.0f)) - Theme.chat_msgBroadcastDrawable.getIntrinsicHeight()) + timeYOffset);
                Theme.chat_msgBroadcastDrawable.setAlpha((int) (f2 * 255.0f));
                drawable = Theme.chat_msgBroadcastDrawable;
            }
            if (z) {
                canvas.save();
                canvas.scale(f, f, drawable.getBounds().centerX(), drawable.getBounds().centerY());
            }
            drawable.draw(canvas);
            if (z) {
                canvas.restore();
            }
            drawable.setAlpha(255);
        }
        if (drawError) {
            if (shouldDrawTimeOnMedia()) {
                iDp = this.layoutWidth - AndroidUtilities.dp(34.5f);
                iDp2 = AndroidUtilities.dp(26.5f);
            } else {
                iDp = this.layoutWidth - AndroidUtilities.dp(32.0f);
                iDp2 = AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 22.0f : 21.0f);
            }
            float f3 = (layoutHeight - iDp2) + timeYOffset;
            this.rect.set(iDp, f3, AndroidUtilities.dp(14.0f) + iDp, AndroidUtilities.dp(14.0f) + f3);
            int alpha2 = Theme.chat_msgErrorPaint.getAlpha();
            Theme.chat_msgErrorPaint.setAlpha((int) (alpha2 * f2));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), Theme.chat_msgErrorPaint);
            Theme.chat_msgErrorPaint.setAlpha(alpha2);
            BaseCell.setDrawableBounds(Theme.chat_msgErrorDrawable, iDp + AndroidUtilities.dp(6.0f), f3 + AndroidUtilities.dp(2.0f));
            Theme.chat_msgErrorDrawable.setAlpha((int) (f2 * 255.0f));
            if (z) {
                canvas.save();
                canvas.scale(f, f, Theme.chat_msgErrorDrawable.getBounds().centerX(), Theme.chat_msgErrorDrawable.getBounds().centerY());
            }
            Theme.chat_msgErrorDrawable.draw(canvas);
            Theme.chat_msgErrorDrawable.setAlpha(255);
            if (z) {
                canvas.restore();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x06b9  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x09c8  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x09df  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x09fe  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0a15  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0a46  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0a54  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0ac2  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0b78  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0d80  */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [ir.eitaa.ui.ActionBar.Theme$MessageDrawable, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v69 */
    /* JADX WARN: Type inference failed for: r8v70 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawOverlays(android.graphics.Canvas r29) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 3771
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.drawOverlays(android.graphics.Canvas):void");
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    public MessageObject getMessageObject() {
        MessageObject messageObject = this.messageObjectToSet;
        return messageObject != null ? messageObject : this.currentMessageObject;
    }

    public MessageObject.GroupedMessages getCurrentMessagesGroup() {
        return this.currentMessagesGroup;
    }

    public MessageObject.GroupedMessagePosition getCurrentPosition() {
        return this.currentPosition;
    }

    public int getLayoutHeight() {
        return this.layoutHeight;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 9 || event.getAction() == 7) {
            for (int i = 0; i < this.accessibilityVirtualViewBounds.size(); i++) {
                if (this.accessibilityVirtualViewBounds.valueAt(i).contains(x, y)) {
                    int iKeyAt = this.accessibilityVirtualViewBounds.keyAt(i);
                    if (iKeyAt == this.currentFocusedVirtualView) {
                        return true;
                    }
                    this.currentFocusedVirtualView = iKeyAt;
                    sendAccessibilityEventForVirtualView(iKeyAt, 32768);
                    return true;
                }
            }
        } else if (event.getAction() == 10) {
            this.currentFocusedVirtualView = 0;
        }
        return super.onHoverEvent(event);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return new MessageAccessibilityNodeProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEventForVirtualView(int viewId, int eventType) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(eventType);
            accessibilityEventObtain.setPackageName(getContext().getPackageName());
            accessibilityEventObtain.setSource(this, viewId);
            if (getParent() != null) {
                getParent().requestSendAccessibilityEvent(this, accessibilityEventObtain);
            }
        }
    }

    private static Point getMessageSize(int imageW, int imageH, int photoWidth, int photoHeight) {
        if (photoHeight == 0 || photoWidth == 0) {
            if (AndroidUtilities.isTablet()) {
                photoWidth = (AndroidUtilities.getMinTabletSide() / 2) - 32;
            } else if (imageW >= imageH) {
                android.graphics.Point point = AndroidUtilities.displaySize;
                photoWidth = Math.min(point.x, point.y) - AndroidUtilities.dp(64.0f);
            } else {
                android.graphics.Point point2 = AndroidUtilities.displaySize;
                photoWidth = (int) (Math.min(point2.x, point2.y) * 0.7f);
            }
            int iDp = AndroidUtilities.dp(100.0f) + photoWidth;
            if (photoWidth > AndroidUtilities.getPhotoSize()) {
                photoWidth = AndroidUtilities.getPhotoSize();
            }
            if (iDp > AndroidUtilities.getPhotoSize()) {
                AndroidUtilities.getPhotoSize();
            }
        }
        float f = imageW;
        float f2 = photoWidth;
        float f3 = f / f2;
        int iDp2 = (int) (f / f3);
        float f4 = imageH;
        int iDp3 = (int) (f4 / f3);
        if (iDp2 == 0) {
            iDp2 = AndroidUtilities.dp(150.0f);
        }
        if (iDp3 == 0) {
            iDp3 = AndroidUtilities.dp(150.0f);
        }
        if (iDp3 < AndroidUtilities.dp(120.0f)) {
            iDp3 = AndroidUtilities.dp(120.0f);
            float f5 = f / (f4 / iDp3);
            if (f5 < f2) {
                iDp2 = (int) f5;
            }
        }
        return new Point(iDp2, iDp3);
    }

    public StaticLayout getDescriptionlayout() {
        return this.descriptionLayout;
    }

    public void setSelectedBackgroundProgress(float value) {
        this.selectedBackgroundProgress = value;
        invalidate();
    }

    private void cancelShakeAnimation() {
        AnimatorSet animatorSet = this.shakeAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.shakeAnimation = null;
            setScaleX(1.0f);
            setScaleY(1.0f);
            setRotation(0.0f);
        }
    }

    public void setSlidingOffset(float offsetX) {
        if (this.slidingOffsetX != offsetX) {
            this.slidingOffsetX = offsetX;
            updateTranslation();
        }
    }

    public void setAnimationOffsetX(float offsetX) {
        if (this.animationOffsetX != offsetX) {
            this.animationOffsetX = offsetX;
            updateTranslation();
        }
    }

    private void updateTranslation() {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        setTranslationX(this.slidingOffsetX + this.animationOffsetX + (!messageObject.isOutOwner() ? this.checkBoxTranslation : 0));
    }

    public float getSlidingOffsetX() {
        return this.slidingOffsetX;
    }

    public float getAnimationOffsetX() {
        return this.animationOffsetX;
    }

    @Override // android.view.View
    public void setTranslationX(float translationX) {
        super.setTranslationX(translationX);
    }

    public SeekBar getSeekBar() {
        return this.seekBar;
    }

    private class MessageAccessibilityNodeProvider extends AccessibilityNodeProvider {
        private final int BOT_BUTTONS_START;
        private final int COMMENT;
        private final int FORWARD;
        private final int INSTANT_VIEW;
        private final int LINK_CAPTION_IDS_START;
        private final int LINK_IDS_START;
        private final int POLL_BUTTONS_START;
        private final int POLL_HINT;
        private final int REPLY;
        private final int SHARE;
        private Path linkPath;
        private Rect rect;
        private RectF rectF;

        private MessageAccessibilityNodeProvider() {
            this.LINK_IDS_START = 2000;
            this.LINK_CAPTION_IDS_START = 3000;
            this.BOT_BUTTONS_START = 1000;
            this.POLL_BUTTONS_START = 500;
            this.INSTANT_VIEW = 499;
            this.SHARE = 498;
            this.REPLY = 497;
            this.COMMENT = 496;
            this.POLL_HINT = 495;
            this.FORWARD = 494;
            this.linkPath = new Path();
            this.rectF = new RectF();
            this.rect = new Rect();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            String string;
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
            int i;
            String str;
            String string2;
            ExploreCell exploreCell;
            int i2;
            int[] iArr = {0, 0};
            ExploreCell.this.getLocationOnScreen(iArr);
            if (virtualViewId == -1) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(ExploreCell.this);
                ExploreCell.this.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                StringBuilder sb = new StringBuilder();
                ExploreCell exploreCell2 = ExploreCell.this;
                if (exploreCell2.isChat && exploreCell2.currentUser != null && !ExploreCell.this.currentMessageObject.isOut()) {
                    sb.append(UserObject.getUserName(ExploreCell.this.currentUser));
                    sb.append('\n');
                }
                if (ExploreCell.this.drawForwardedName) {
                    int i3 = 0;
                    while (i3 < 2) {
                        if (ExploreCell.this.forwardedNameLayout[i3] != null) {
                            sb.append(ExploreCell.this.forwardedNameLayout[i3].getText());
                            sb.append(i3 == 0 ? " " : "\n");
                        }
                        i3++;
                    }
                }
                if (!TextUtils.isEmpty(ExploreCell.this.currentMessageObject.messageText)) {
                    sb.append(ExploreCell.this.currentMessageObject.messageText);
                }
                if (ExploreCell.this.documentAttach != null && ((i2 = (exploreCell = ExploreCell.this).documentAttachType) == 1 || i2 == 2 || i2 == 4)) {
                    if (exploreCell.buttonState != 1 || ExploreCell.this.loadingProgressLayout == null) {
                        if (ExploreCell.this.buttonState == 0 || ExploreCell.this.documentAttachType == 1) {
                            sb.append(", ");
                            sb.append(AndroidUtilities.formatFileSize(ExploreCell.this.documentAttach.size));
                        }
                    } else {
                        sb.append("\n");
                        boolean zIsSending = ExploreCell.this.currentMessageObject.isSending();
                        sb = sb;
                        sb.append(LocaleController.formatString(zIsSending ? "AccDescrUploadProgress" : "AccDescrDownloadProgress", zIsSending ? ir.eitaa.messenger.R.string.AccDescrUploadProgress : ir.eitaa.messenger.R.string.AccDescrDownloadProgress, AndroidUtilities.formatFileSize(ExploreCell.this.currentMessageObject.loadedFileSize), AndroidUtilities.formatFileSize(ExploreCell.this.lastLoadingSizeTotal)));
                    }
                    if (ExploreCell.this.documentAttachType == 4) {
                        sb.append(", ");
                        sb.append(LocaleController.formatDuration(ExploreCell.this.currentMessageObject.getDuration()));
                    }
                }
                if (!ExploreCell.this.currentMessageObject.isMusic()) {
                    if (ExploreCell.this.currentMessageObject.isVoice() || ExploreCell.this.isRoundVideo) {
                        sb.append(", ");
                        sb.append(LocaleController.formatDuration(ExploreCell.this.currentMessageObject.getDuration()));
                        if (ExploreCell.this.currentMessageObject.isContentUnread()) {
                            sb.append(", ");
                            sb.append(LocaleController.getString("AccDescrMsgNotPlayed", ir.eitaa.messenger.R.string.AccDescrMsgNotPlayed));
                        }
                    }
                } else {
                    sb.append("\n");
                    sb.append(LocaleController.formatString("AccDescrMusicInfo", ir.eitaa.messenger.R.string.AccDescrMusicInfo, ExploreCell.this.currentMessageObject.getMusicAuthor(), ExploreCell.this.currentMessageObject.getMusicTitle()));
                    sb.append(", ");
                    sb.append(LocaleController.formatDuration(ExploreCell.this.currentMessageObject.getDuration()));
                }
                if (ExploreCell.this.lastPoll != null) {
                    sb.append(", ");
                    sb.append(ExploreCell.this.lastPoll.question);
                    sb.append(", ");
                    if (!ExploreCell.this.pollClosed) {
                        if (ExploreCell.this.lastPoll.quiz) {
                            if (ExploreCell.this.lastPoll.public_voters) {
                                string2 = LocaleController.getString("QuizPoll", ir.eitaa.messenger.R.string.QuizPoll);
                            } else {
                                string2 = LocaleController.getString("AnonymousQuizPoll", ir.eitaa.messenger.R.string.AnonymousQuizPoll);
                            }
                        } else if (ExploreCell.this.lastPoll.public_voters) {
                            string2 = LocaleController.getString("PublicPoll", ir.eitaa.messenger.R.string.PublicPoll);
                        } else {
                            string2 = LocaleController.getString("AnonymousPoll", ir.eitaa.messenger.R.string.AnonymousPoll);
                        }
                    } else {
                        string2 = LocaleController.getString("FinalResults", ir.eitaa.messenger.R.string.FinalResults);
                    }
                    sb.append(string2);
                }
                if (ExploreCell.this.currentMessageObject.messageOwner.media != null && !TextUtils.isEmpty(ExploreCell.this.currentMessageObject.caption)) {
                    sb.append("\n");
                    sb.append(ExploreCell.this.currentMessageObject.caption);
                }
                if (ExploreCell.this.currentMessageObject.isOut()) {
                    if (!ExploreCell.this.currentMessageObject.isSent()) {
                        if (!ExploreCell.this.currentMessageObject.isSending()) {
                            if (ExploreCell.this.currentMessageObject.isSendError()) {
                                sb.append("\n");
                                sb.append(LocaleController.getString("AccDescrMsgSendingError", ir.eitaa.messenger.R.string.AccDescrMsgSendingError));
                            }
                        } else {
                            sb.append("\n");
                            sb.append(LocaleController.getString("AccDescrMsgSending", ir.eitaa.messenger.R.string.AccDescrMsgSending));
                            float progress = ExploreCell.this.radialProgress.getProgress();
                            if (progress > 0.0f) {
                                sb.append(", ");
                                sb.append(Math.round(progress * 100.0f));
                                sb.append("%");
                            }
                        }
                    } else {
                        sb.append("\n");
                        if (ExploreCell.this.currentMessageObject.scheduled) {
                            sb.append(LocaleController.formatString("AccDescrScheduledDate", ir.eitaa.messenger.R.string.AccDescrScheduledDate, ExploreCell.this.currentTimeString));
                        } else {
                            sb.append(LocaleController.formatString("AccDescrSentDate", ir.eitaa.messenger.R.string.AccDescrSentDate, LocaleController.getString("TodayAt", ir.eitaa.messenger.R.string.TodayAt) + " " + ExploreCell.this.currentTimeString));
                            sb.append(", ");
                            if (ExploreCell.this.currentMessageObject.isUnread()) {
                                i = ir.eitaa.messenger.R.string.AccDescrMsgUnread;
                                str = "AccDescrMsgUnread";
                            } else {
                                i = ir.eitaa.messenger.R.string.AccDescrMsgRead;
                                str = "AccDescrMsgRead";
                            }
                            sb.append(LocaleController.getString(str, i));
                        }
                    }
                } else {
                    sb.append("\n");
                    sb.append(LocaleController.formatString("AccDescrReceivedDate", ir.eitaa.messenger.R.string.AccDescrReceivedDate, LocaleController.getString("TodayAt", ir.eitaa.messenger.R.string.TodayAt) + " " + ExploreCell.this.currentTimeString));
                }
                if ((ExploreCell.this.currentMessageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                    sb.append("\n");
                    sb.append(LocaleController.formatPluralString("AccDescrNumberOfViews", ExploreCell.this.currentMessageObject.messageOwner.views));
                }
                sb.append("\n");
                accessibilityNodeInfoObtain.setContentDescription(sb.toString());
                accessibilityNodeInfoObtain.setEnabled(true);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 19 && (collectionItemInfo = accessibilityNodeInfoObtain.getCollectionItemInfo()) != null) {
                    accessibilityNodeInfoObtain.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(collectionItemInfo.getRowIndex(), 1, 0, 1, false));
                }
                if (i4 >= 21) {
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.eitaa.messenger.R.id.acc_action_msg_options, LocaleController.getString("AccActionMessageOptions", ir.eitaa.messenger.R.string.AccActionMessageOptions)));
                    int iconForCurrentState = ExploreCell.this.getIconForCurrentState();
                    if (iconForCurrentState == 0) {
                        string = LocaleController.getString("AccActionPlay", ir.eitaa.messenger.R.string.AccActionPlay);
                    } else if (iconForCurrentState == 1) {
                        string = LocaleController.getString("AccActionPause", ir.eitaa.messenger.R.string.AccActionPause);
                    } else if (iconForCurrentState == 2) {
                        string = LocaleController.getString("AccActionDownload", ir.eitaa.messenger.R.string.AccActionDownload);
                    } else if (iconForCurrentState == 3) {
                        string = LocaleController.getString("AccActionCancelDownload", ir.eitaa.messenger.R.string.AccActionCancelDownload);
                    } else if (iconForCurrentState == 5) {
                        string = LocaleController.getString("AccActionOpenFile", ir.eitaa.messenger.R.string.AccActionOpenFile);
                    } else {
                        string = ExploreCell.this.currentMessageObject.type == 16 ? LocaleController.getString("CallAgain", ir.eitaa.messenger.R.string.CallAgain) : null;
                    }
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, string));
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccActionEnterSelectionMode", ir.eitaa.messenger.R.string.AccActionEnterSelectionMode)));
                    if (ExploreCell.this.getMiniIconForCurrentState() == 2) {
                        accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.eitaa.messenger.R.id.acc_action_small_button, LocaleController.getString("AccActionDownload", ir.eitaa.messenger.R.string.AccActionDownload)));
                    }
                } else {
                    accessibilityNodeInfoObtain.addAction(16);
                    accessibilityNodeInfoObtain.addAction(32);
                }
                if ((ExploreCell.this.currentMessageObject.isVoice() || ExploreCell.this.currentMessageObject.isMusic()) && MediaController.getInstance().isPlayingMessage(ExploreCell.this.currentMessageObject)) {
                    ExploreCell.this.seekBarAccessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfoObtain);
                }
                if (ExploreCell.this.currentMessageObject.messageText instanceof Spannable) {
                    Spannable spannable = (Spannable) ExploreCell.this.currentMessageObject.messageText;
                    int i5 = 0;
                    for (CharacterStyle characterStyle : (CharacterStyle[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(ExploreCell.this, i5 + 2000);
                        i5++;
                    }
                }
                if ((ExploreCell.this.currentMessageObject.caption instanceof Spannable) && ExploreCell.this.captionLayout != null) {
                    Spannable spannable2 = (Spannable) ExploreCell.this.currentMessageObject.caption;
                    int i6 = 0;
                    for (CharacterStyle characterStyle2 : (CharacterStyle[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(ExploreCell.this, i6 + 3000);
                        i6++;
                    }
                }
                Iterator it = ExploreCell.this.botButtons.iterator();
                int i7 = 0;
                while (it.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, i7 + 1000);
                    i7++;
                }
                if (ExploreCell.this.hintButtonVisible && ExploreCell.this.pollHintX != -1 && ExploreCell.this.currentMessageObject.isPoll()) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, 495);
                }
                Iterator it2 = ExploreCell.this.pollButtons.iterator();
                int i8 = 0;
                while (it2.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, i8 + 500);
                    i8++;
                }
                if (ExploreCell.this.drawInstantView && !ExploreCell.this.instantButtonRect.isEmpty()) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, 499);
                }
                if (ExploreCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, 496);
                }
                if (ExploreCell.this.drawSideButton == 1) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, 498);
                }
                ExploreCell exploreCell3 = ExploreCell.this;
                if (exploreCell3.replyNameLayout != null) {
                    accessibilityNodeInfoObtain.addChild(exploreCell3, 497);
                }
                if (ExploreCell.this.forwardedNameLayout[0] != null && ExploreCell.this.forwardedNameLayout[1] != null) {
                    accessibilityNodeInfoObtain.addChild(ExploreCell.this, 494);
                }
                if (ExploreCell.this.drawSelectionBackground || ExploreCell.this.getBackground() != null) {
                    accessibilityNodeInfoObtain.setSelected(true);
                }
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain2.setSource(ExploreCell.this, virtualViewId);
            accessibilityNodeInfoObtain2.setParent(ExploreCell.this);
            accessibilityNodeInfoObtain2.setPackageName(ExploreCell.this.getContext().getPackageName());
            if (virtualViewId >= 3000) {
                if (!(ExploreCell.this.currentMessageObject.caption instanceof Spannable) || ExploreCell.this.captionLayout == null) {
                    return null;
                }
                Spannable spannable3 = (Spannable) ExploreCell.this.currentMessageObject.caption;
                ClickableSpan linkById = getLinkById(virtualViewId, true);
                if (linkById == null) {
                    return null;
                }
                int[] realSpanStartAndEnd = ExploreCell.this.getRealSpanStartAndEnd(spannable3, linkById);
                accessibilityNodeInfoObtain2.setText(spannable3.subSequence(realSpanStartAndEnd[0], realSpanStartAndEnd[1]).toString());
                ExploreCell.this.captionLayout.getText().length();
                ExploreCell.this.captionLayout.getSelectionPath(realSpanStartAndEnd[0], realSpanStartAndEnd[1], this.linkPath);
                this.linkPath.computeBounds(this.rectF, true);
                Rect rect = this.rect;
                RectF rectF = this.rectF;
                rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.rect.offset((int) ExploreCell.this.captionX, (int) ExploreCell.this.captionY);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClassName("android.widget.TextView");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.setLongClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.addAction(32);
            } else if (virtualViewId >= 2000) {
                if (!(ExploreCell.this.currentMessageObject.messageText instanceof Spannable)) {
                    return null;
                }
                Spannable spannable4 = (Spannable) ExploreCell.this.currentMessageObject.messageText;
                ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                if (linkById2 == null) {
                    return null;
                }
                int[] realSpanStartAndEnd2 = ExploreCell.this.getRealSpanStartAndEnd(spannable4, linkById2);
                accessibilityNodeInfoObtain2.setText(spannable4.subSequence(realSpanStartAndEnd2[0], realSpanStartAndEnd2[1]).toString());
                Iterator<MessageObject.TextLayoutBlock> it3 = ExploreCell.this.currentMessageObject.textLayoutBlocks.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    MessageObject.TextLayoutBlock next = it3.next();
                    int length = next.textLayout.getText().length();
                    int i9 = next.charactersOffset;
                    if (i9 <= realSpanStartAndEnd2[0] && length + i9 >= realSpanStartAndEnd2[1]) {
                        next.textLayout.getSelectionPath(realSpanStartAndEnd2[0] - i9, realSpanStartAndEnd2[1] - i9, this.linkPath);
                        this.linkPath.computeBounds(this.rectF, true);
                        Rect rect2 = this.rect;
                        RectF rectF2 = this.rectF;
                        rect2.set((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        this.rect.offset(0, (int) next.textYOffset);
                        this.rect.offset(ExploreCell.this.textX, ExploreCell.this.textY);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                            ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                        }
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                    }
                }
                accessibilityNodeInfoObtain2.setClassName("android.widget.TextView");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.setLongClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.addAction(32);
            } else if (virtualViewId >= 1000) {
                int i10 = virtualViewId - 1000;
                if (i10 >= ExploreCell.this.botButtons.size()) {
                    return null;
                }
                BotButton botButton = (BotButton) ExploreCell.this.botButtons.get(i10);
                accessibilityNodeInfoObtain2.setText(botButton.title.getText());
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(botButton.x, botButton.y, botButton.x + botButton.width, botButton.y + botButton.height);
                this.rect.offset(ExploreCell.this.currentMessageObject.isOutOwner() ? (ExploreCell.this.getMeasuredWidth() - ExploreCell.this.widthForButtons) - AndroidUtilities.dp(10.0f) : ExploreCell.this.backgroundDrawableLeft + AndroidUtilities.dp(ExploreCell.this.mediaBackground ? 1.0f : 7.0f), ExploreCell.this.layoutHeight);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
            } else if (virtualViewId >= 500) {
                int i11 = virtualViewId - 500;
                if (i11 >= ExploreCell.this.pollButtons.size()) {
                    return null;
                }
                PollButton pollButton = (PollButton) ExploreCell.this.pollButtons.get(i11);
                StringBuilder sb2 = new StringBuilder(pollButton.title.getText());
                if (ExploreCell.this.pollVoted) {
                    accessibilityNodeInfoObtain2.setSelected(pollButton.chosen);
                    sb2.append(", ");
                    sb2.append(pollButton.percent);
                    sb2.append("%");
                    if (ExploreCell.this.lastPoll != null && ExploreCell.this.lastPoll.quiz && pollButton.correct) {
                        sb2.append(", ");
                        sb2.append(LocaleController.getString("AccDescrQuizCorrectAnswer", ir.eitaa.messenger.R.string.AccDescrQuizCorrectAnswer));
                    }
                } else {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                accessibilityNodeInfoObtain2.setText(sb2);
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.addAction(16);
                int i12 = pollButton.y + ExploreCell.this.namesOffset;
                int iDp = ExploreCell.this.backgroundWidth - AndroidUtilities.dp(76.0f);
                Rect rect3 = this.rect;
                int i13 = pollButton.x;
                rect3.set(i13, i12, iDp + i13, pollButton.height + i12);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 495) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setText(LocaleController.getString("AccDescrQuizExplanation", ir.eitaa.messenger.R.string.AccDescrQuizExplanation));
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(ExploreCell.this.pollHintX - AndroidUtilities.dp(8.0f), ExploreCell.this.pollHintY - AndroidUtilities.dp(8.0f), ExploreCell.this.pollHintX + AndroidUtilities.dp(32.0f), ExploreCell.this.pollHintY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 499) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (ExploreCell.this.instantViewLayout != null) {
                    accessibilityNodeInfoObtain2.setText(ExploreCell.this.instantViewLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                ExploreCell.this.instantButtonRect.round(this.rect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 498) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.ImageButton");
                accessibilityNodeInfoObtain2.setEnabled(true);
                ExploreCell exploreCell4 = ExploreCell.this;
                if (exploreCell4.isOpenChatByShare(exploreCell4.currentMessageObject)) {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("AccDescrOpenChat", ir.eitaa.messenger.R.string.AccDescrOpenChat));
                } else {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("ShareFile", ir.eitaa.messenger.R.string.ShareFile));
                }
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set((int) ExploreCell.this.sideStartX, (int) ExploreCell.this.sideStartY, ((int) ExploreCell.this.sideStartX) + AndroidUtilities.dp(40.0f), ((int) ExploreCell.this.sideStartY) + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 497) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(LocaleController.getString("Reply", ir.eitaa.messenger.R.string.Reply));
                sb3.append(", ");
                StaticLayout staticLayout = ExploreCell.this.replyNameLayout;
                if (staticLayout != null) {
                    sb3.append(staticLayout.getText());
                    sb3.append(", ");
                }
                StaticLayout staticLayout2 = ExploreCell.this.replyTextLayout;
                if (staticLayout2 != null) {
                    sb3.append(staticLayout2.getText());
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb3.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                Rect rect4 = this.rect;
                ExploreCell exploreCell5 = ExploreCell.this;
                int i14 = exploreCell5.replyStartX;
                rect4.set(i14, exploreCell5.replyStartY, Math.max(exploreCell5.replyNameWidth, ExploreCell.this.replyTextWidth) + i14, ExploreCell.this.replyStartY + AndroidUtilities.dp(35.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 494) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb4 = new StringBuilder();
                if (ExploreCell.this.forwardedNameLayout[0] != null && ExploreCell.this.forwardedNameLayout[1] != null) {
                    int i15 = 0;
                    while (i15 < 2) {
                        sb4.append(ExploreCell.this.forwardedNameLayout[i15].getText());
                        sb4.append(i15 == 0 ? " " : "\n");
                        i15++;
                    }
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb4.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                int iMin = (int) Math.min(ExploreCell.this.forwardNameX - ExploreCell.this.forwardNameOffsetX[0], ExploreCell.this.forwardNameX - ExploreCell.this.forwardNameOffsetX[1]);
                this.rect.set(iMin, ExploreCell.this.forwardNameY, ExploreCell.this.forwardedNameWidth + iMin, ExploreCell.this.forwardNameY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 496) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (ExploreCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain2.setText(ExploreCell.this.commentLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(ExploreCell.this.commentButtonRect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ExploreCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ExploreCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            }
            accessibilityNodeInfoObtain2.setFocusable(true);
            accessibilityNodeInfoObtain2.setVisibleToUser(true);
            return accessibilityNodeInfoObtain2;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            if (virtualViewId == -1) {
                ExploreCell.this.performAccessibilityAction(action, arguments);
            } else if (action == 64) {
                ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            } else {
                if (action == 16) {
                    if (virtualViewId >= 3000) {
                        ClickableSpan linkById = getLinkById(virtualViewId, true);
                        if (linkById != null) {
                            ExploreCell.this.delegate.didPressUrl(ExploreCell.this, linkById, false);
                            ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 2000) {
                        ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                        if (linkById2 != null) {
                            ExploreCell.this.delegate.didPressUrl(ExploreCell.this, linkById2, false);
                            ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 1000) {
                        int i = virtualViewId - 1000;
                        if (i >= ExploreCell.this.botButtons.size()) {
                            return false;
                        }
                        BotButton botButton = (BotButton) ExploreCell.this.botButtons.get(i);
                        if (ExploreCell.this.delegate != null) {
                            if (botButton.button != null) {
                                ExploreCell.this.delegate.didPressBotButton(ExploreCell.this, botButton.button);
                            } else if (botButton.reaction != null) {
                                ExploreCell.this.delegate.didPressReaction(ExploreCell.this, botButton.reaction);
                            }
                        }
                        ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId >= 500) {
                        int i2 = virtualViewId - 500;
                        if (i2 >= ExploreCell.this.pollButtons.size()) {
                            return false;
                        }
                        PollButton pollButton = (PollButton) ExploreCell.this.pollButtons.get(i2);
                        if (ExploreCell.this.delegate != null) {
                            ArrayList<TLRPC$TL_pollAnswer> arrayList = new ArrayList<>();
                            arrayList.add(pollButton.answer);
                            ExploreCell.this.delegate.didPressVoteButtons(ExploreCell.this, arrayList, -1, 0, 0);
                        }
                        ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId == 495) {
                        if (ExploreCell.this.delegate != null) {
                            ExploreCell.this.delegate.didPressHint(ExploreCell.this, 0);
                        }
                    } else if (virtualViewId == 499) {
                        if (ExploreCell.this.delegate != null) {
                            ExploreCellDelegate exploreCellDelegate = ExploreCell.this.delegate;
                            ExploreCell exploreCell = ExploreCell.this;
                            exploreCellDelegate.didPressInstantButton(exploreCell, exploreCell.drawInstantViewType);
                        }
                    } else if (virtualViewId == 498) {
                        if (ExploreCell.this.delegate != null) {
                            ExploreCell.this.delegate.didPressSideButton(ExploreCell.this);
                        }
                    } else if (virtualViewId == 497) {
                        if (ExploreCell.this.delegate != null) {
                            ExploreCell exploreCell2 = ExploreCell.this;
                            if ((!exploreCell2.isThreadChat || exploreCell2.currentMessageObject.getReplyTopMsgId() != 0) && ExploreCell.this.currentMessageObject.hasValidReplyMessageObject()) {
                                ExploreCellDelegate exploreCellDelegate2 = ExploreCell.this.delegate;
                                ExploreCell exploreCell3 = ExploreCell.this;
                                exploreCellDelegate2.didPressReplyMessage(exploreCell3, exploreCell3.currentMessageObject.getReplyMsgId());
                            }
                        }
                    } else if (virtualViewId == 494) {
                        if (ExploreCell.this.delegate != null) {
                            if (ExploreCell.this.currentForwardChannel != null) {
                                ExploreCellDelegate exploreCellDelegate3 = ExploreCell.this.delegate;
                                ExploreCell exploreCell4 = ExploreCell.this;
                                exploreCellDelegate3.didPressChannelAvatar(exploreCell4, exploreCell4.currentForwardChannel, ExploreCell.this.currentMessageObject.messageOwner.fwd_from.channel_post, ExploreCell.this.lastTouchX, ExploreCell.this.lastTouchY);
                            } else if (ExploreCell.this.currentForwardUser != null) {
                                ExploreCellDelegate exploreCellDelegate4 = ExploreCell.this.delegate;
                                ExploreCell exploreCell5 = ExploreCell.this;
                                exploreCellDelegate4.didPressUserAvatar(exploreCell5, exploreCell5.currentForwardUser, ExploreCell.this.lastTouchX, ExploreCell.this.lastTouchY);
                            } else if (ExploreCell.this.currentForwardName != null) {
                                ExploreCell.this.delegate.didPressHiddenForward(ExploreCell.this);
                            }
                        }
                    } else if (virtualViewId == 496 && ExploreCell.this.delegate != null) {
                        ExploreCell exploreCell6 = ExploreCell.this;
                        if (exploreCell6.isRepliesChat) {
                            exploreCell6.delegate.didPressSideButton(ExploreCell.this);
                        } else {
                            exploreCell6.delegate.didPressCommentButton(ExploreCell.this);
                        }
                    }
                } else if (action == 32) {
                    ClickableSpan linkById3 = getLinkById(virtualViewId, virtualViewId >= 3000);
                    if (linkById3 != null) {
                        ExploreCell.this.delegate.didPressUrl(ExploreCell.this, linkById3, true);
                        ExploreCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 2);
                    }
                }
            }
            return true;
        }

        private ClickableSpan getLinkById(int id, boolean caption) {
            if (caption) {
                int i = id - 3000;
                if (!(ExploreCell.this.currentMessageObject.caption instanceof Spannable)) {
                    return null;
                }
                Spannable spannable = (Spannable) ExploreCell.this.currentMessageObject.caption;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
                if (clickableSpanArr.length <= i) {
                    return null;
                }
                return clickableSpanArr[i];
            }
            int i2 = id - 2000;
            if (!(ExploreCell.this.currentMessageObject.messageText instanceof Spannable)) {
                return null;
            }
            Spannable spannable2 = (Spannable) ExploreCell.this.currentMessageObject.messageText;
            ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class);
            if (clickableSpanArr2.length <= i2) {
                return null;
            }
            return clickableSpanArr2[i2];
        }
    }

    @Override // android.view.View
    public float getAlpha() {
        if (this.ALPHA_PROPERTY_WORKAROUND) {
            return this.alphaInternal;
        }
        return super.getAlpha();
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        if (this.ALPHA_PROPERTY_WORKAROUND) {
            this.alphaInternal = alpha;
            invalidate();
        } else {
            super.setAlpha(alpha);
        }
    }

    public TransitionParams getTransitionParams() {
        return this.transitionParams;
    }

    public int getTopMediaOffset() {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.type != 14) {
            return 0;
        }
        return this.mediaOffsetY + this.namesOffset;
    }

    public int getTextX() {
        return this.textX;
    }

    public int getTextY() {
        return this.textY;
    }

    public int getParentWidth() {
        return ((AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x) / 2) - 32;
    }

    public class TransitionParams {
        public boolean animateBackgroundBoundsInner;
        private boolean animateButton;
        private int animateCommentArrowX;
        private boolean animateCommentDrawUnread;
        private int animateCommentUnreadX;
        private float animateCommentX;
        private boolean animateComments;
        private StaticLayout animateCommentsLayout;
        private boolean animateDrawCommentNumber;
        public boolean animateDrawingTimeAlpha;
        private boolean animateEditedEnter;
        private StaticLayout animateEditedLayout;
        private float animateFromButtonX;
        private float animateFromButtonY;
        public float animateFromTextY;
        public int animateFromTimeX;
        public float animateFromTimeXPinned;
        private float animateFromTimeXReplies;
        private float animateFromTimeXViews;
        public boolean animateLocationIsExpired;
        boolean animateMessageText;
        private StaticLayout animateOutCaptionLayout;
        private ArrayList<MessageObject.TextLayoutBlock> animateOutTextBlocks;
        private boolean animatePinned;
        public boolean animatePlayingRound;
        boolean animateReplaceCaptionLayout;
        private boolean animateReplies;
        private StaticLayout animateRepliesLayout;
        private boolean animateShouldDrawTimeOnMedia;
        public boolean animateText;
        private StaticLayout animateTimeLayout;
        private int animateTimeWidth;
        public float animateToImageH;
        public float animateToImageX;
        public float animateToImageY;
        private StaticLayout animateViewsLayout;
        public float captionFromX;
        public float captionFromY;
        public float deltaBottom;
        public float deltaLeft;
        public float deltaRight;
        public float deltaTop;
        public boolean drawPinnedBottomBackground;
        public boolean imageChangeBoundsTransition;
        private float lastButtonX;
        private float lastButtonY;
        private int lastCommentArrowX;
        private boolean lastCommentDrawUnread;
        private StaticLayout lastCommentLayout;
        private int lastCommentUnreadX;
        private float lastCommentX;
        private int lastCommentsCount;
        private boolean lastDrawCommentNumber;
        public StaticLayout lastDrawDocTitleLayout;
        public StaticLayout lastDrawInfoLayout;
        public float lastDrawLocationExpireProgress;
        public String lastDrawLocationExpireText;
        public boolean lastDrawTime;
        private StaticLayout lastDrawingCaptionLayout;
        public float lastDrawingCaptionX;
        public float lastDrawingCaptionY;
        private boolean lastDrawingEdited;
        public float lastDrawingImageH;
        public float lastDrawingImageW;
        public float lastDrawingImageX;
        public float lastDrawingImageY;
        private ArrayList<MessageObject.TextLayoutBlock> lastDrawingTextBlocks;
        public float lastDrawingTextX;
        public float lastDrawingTextY;
        public boolean lastDrawnForwardedName;
        int lastForwardNameWidth;
        float lastForwardNameX;
        public int lastForwardedNamesOffset;
        private boolean lastIsPinned;
        private boolean lastIsPlayingRound;
        public boolean lastLocatinIsExpired;
        private int lastRepliesCount;
        private StaticLayout lastRepliesLayout;
        private boolean lastShouldDrawTimeOnMedia;
        private String lastSignMessage;
        private StaticLayout lastTimeLayout;
        private int lastTimeWidth;
        public int lastTimeX;
        public float lastTimeXPinned;
        private float lastTimeXReplies;
        private float lastTimeXViews;
        public int lastTopOffset;
        private int lastTotalCommentWidth;
        private int lastViewsCount;
        private StaticLayout lastViewsLayout;
        public boolean messageEntering;
        private boolean moveCaption;
        public boolean shouldAnimateTimeX;
        public boolean transformGroupToSingleMessage;
        public boolean updatePhotoImageX;
        public boolean wasDraw;
        public int[] imageRoundRadius = new int[4];
        public float captionEnterProgress = 1.0f;
        public float changePinnedBottomProgress = 1.0f;
        public Rect lastDrawingBackgroundRect = new Rect();
        public float animateChangeProgress = 1.0f;
        private ArrayList<BotButton> lastDrawBotButtons = new ArrayList<>();
        private ArrayList<BotButton> transitionBotButtons = new ArrayList<>();
        public int lastStatusDrawableParams = -1;
        public StaticLayout[] lastDrawnForwardedNameLayout = new StaticLayout[2];
        public StaticLayout[] animatingForwardedNameLayout = new StaticLayout[2];

        public TransitionParams() {
        }

        public void recordDrawingState() {
            this.wasDraw = true;
            this.lastDrawingImageX = ExploreCell.this.photoImage.getImageX();
            this.lastDrawingImageY = ExploreCell.this.photoImage.getImageY();
            this.lastDrawingImageW = ExploreCell.this.photoImage.getImageWidth();
            this.lastDrawingImageH = ExploreCell.this.photoImage.getImageHeight();
            System.arraycopy(ExploreCell.this.photoImage.getRoundRadius(), 0, this.imageRoundRadius, 0, 4);
            if (ExploreCell.this.currentBackgroundDrawable != null) {
                this.lastDrawingBackgroundRect.set(ExploreCell.this.currentBackgroundDrawable.getBounds());
            }
            this.lastDrawingTextBlocks = ExploreCell.this.currentMessageObject.textLayoutBlocks;
            this.lastDrawingEdited = ExploreCell.this.edited;
            this.lastDrawingCaptionX = ExploreCell.this.captionX;
            this.lastDrawingCaptionY = ExploreCell.this.captionY;
            this.lastDrawingCaptionLayout = ExploreCell.this.captionLayout;
            if (!ExploreCell.this.botButtons.isEmpty()) {
                this.lastDrawBotButtons.clear();
                this.lastDrawBotButtons.addAll(ExploreCell.this.botButtons);
            }
            if (ExploreCell.this.commentLayout != null) {
                this.lastCommentsCount = ExploreCell.this.getRepliesCount();
                this.lastTotalCommentWidth = ExploreCell.this.totalCommentWidth;
                this.lastCommentLayout = ExploreCell.this.commentLayout;
                this.lastCommentArrowX = ExploreCell.this.commentArrowX;
                this.lastCommentUnreadX = ExploreCell.this.commentUnreadX;
                this.lastCommentDrawUnread = ExploreCell.this.commentDrawUnread;
                this.lastCommentX = ExploreCell.this.commentX;
                this.lastDrawCommentNumber = ExploreCell.this.drawCommentNumber;
            }
            this.lastRepliesCount = ExploreCell.this.getRepliesCount();
            this.lastViewsCount = ExploreCell.this.getMessageObject().messageOwner.views;
            this.lastRepliesLayout = ExploreCell.this.repliesLayout;
            this.lastViewsLayout = ExploreCell.this.viewsLayout;
            ExploreCell exploreCell = ExploreCell.this;
            this.lastIsPinned = exploreCell.isPinned;
            this.lastSignMessage = exploreCell.lastPostAuthor;
            this.lastButtonX = ExploreCell.this.buttonX;
            this.lastButtonY = ExploreCell.this.buttonY;
            this.lastDrawTime = !ExploreCell.this.forceNotDrawTime;
            this.lastTimeX = ExploreCell.this.timeX;
            this.lastTimeLayout = ExploreCell.this.timeLayout;
            this.lastTimeWidth = ExploreCell.this.timeWidth;
            this.lastShouldDrawTimeOnMedia = ExploreCell.this.shouldDrawTimeOnMedia();
            this.lastTopOffset = ExploreCell.this.getTopMediaOffset();
            this.lastLocatinIsExpired = ExploreCell.this.locationExpired;
            this.lastIsPlayingRound = ExploreCell.this.isPlayingRound;
            this.lastDrawingTextY = ExploreCell.this.textY;
            this.lastDrawingTextX = ExploreCell.this.textX;
            this.lastDrawnForwardedNameLayout[0] = ExploreCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = ExploreCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = ExploreCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = ExploreCell.this.forwardNameX;
            this.lastForwardedNamesOffset = ExploreCell.this.namesOffset;
            this.lastForwardNameWidth = ExploreCell.this.forwardedNameWidth;
        }

        public void onDetach() {
            this.wasDraw = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int createStatusDrawableParams() {
            /*
                r7 = this;
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isOutOwner()
                r1 = 8
                r2 = 4
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L7a
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L65
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L2a
                goto L65
            L2a:
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isSendError()
                if (r0 == 0) goto L3b
                r0 = 0
                r3 = 0
                r5 = 0
                r6 = 1
                goto L69
            L3b:
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isSent()
                if (r0 == 0) goto L61
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.scheduled
                if (r0 != 0) goto L5f
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isUnread()
                if (r0 != 0) goto L5f
                r0 = 1
                goto L63
            L5f:
                r0 = 0
                goto L63
            L61:
                r0 = 0
                r3 = 0
            L63:
                r5 = 0
                goto L68
            L65:
                r0 = 0
                r3 = 0
                r5 = 1
            L68:
                r6 = 0
            L69:
                if (r3 == 0) goto L6d
                r3 = 2
                goto L6e
            L6d:
                r3 = 0
            L6e:
                r0 = r0 | r3
                if (r5 == 0) goto L72
                goto L73
            L72:
                r2 = 0
            L73:
                r0 = r0 | r2
                if (r6 == 0) goto L77
                goto L78
            L77:
                r1 = 0
            L78:
                r0 = r0 | r1
                return r0
            L7a:
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L94
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L93
                goto L94
            L93:
                r3 = 0
            L94:
                ir.eitaa.ui.explore.cells.ExploreCell r0 = ir.eitaa.ui.explore.cells.ExploreCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.explore.cells.ExploreCell.access$600(r0)
                boolean r0 = r0.isSendError()
                if (r3 == 0) goto La1
                goto La2
            La1:
                r2 = 0
            La2:
                if (r0 == 0) goto La5
                goto La6
            La5:
                r1 = 0
            La6:
                r0 = r2 | r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.ExploreCell.TransitionParams.createStatusDrawableParams():int");
        }
    }

    private int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private Drawable getThemedDrawable(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Drawable drawable = resourcesProvider != null ? resourcesProvider.getDrawable(key) : null;
        return drawable != null ? drawable : Theme.getThemeDrawable(key);
    }

    private Paint getThemedPaint(String paintKey) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Paint paint = resourcesProvider != null ? resourcesProvider.getPaint(paintKey) : null;
        return paint != null ? paint : Theme.getThemePaint(paintKey);
    }

    private boolean hasGradientService() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        return resourcesProvider != null ? resourcesProvider.hasGradientService() : Theme.hasGradientService();
    }

    private int getTimeX() {
        return LocaleController.isRTL ? (getParentWidth() - this.timeLayout.getWidth()) - AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(8.0f);
    }
}
