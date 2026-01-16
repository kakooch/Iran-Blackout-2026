package ir.eitaa.ui.explore.cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.Property;
import android.util.SparseArray;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
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
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.messenger.video.VideoPlayerRewinder;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
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
import ir.eitaa.tgnet.TLRPC$TL_messageReactions;
import ir.eitaa.tgnet.TLRPC$TL_messages_stickerSet;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswer;
import ir.eitaa.tgnet.TLRPC$TL_pollAnswerVoters;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$TL_user;
import ir.eitaa.tgnet.TLRPC$TL_webPage;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.BaseCell;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.AnimatedNumberLayout;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackgroundGradientDrawable;
import ir.eitaa.ui.Components.CheckBoxBase;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.InfiniteProgress;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.MessageBackgroundDrawable;
import ir.eitaa.ui.Components.MotionBackgroundDrawable;
import ir.eitaa.ui.Components.MsgClockDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RoundVideoPlayingDrawable;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.SeekBarWaveform;
import ir.eitaa.ui.Components.StaticLayoutEx;
import ir.eitaa.ui.Components.TextStyleSpan;
import ir.eitaa.ui.Components.TimerParticles;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.URLSpanBotCommand;
import ir.eitaa.ui.Components.URLSpanBrowser;
import ir.eitaa.ui.Components.URLSpanMono;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.Components.VideoForwardDrawable;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class KavoshCell extends BaseCell implements SeekBar.SeekBarDelegate, ImageReceiver.ImageReceiverDelegate, DownloadController.FileDownloadProgressListener, TextSelectionHelper.SelectableView {
    private static float[] radii = new float[8];
    private final boolean ALPHA_PROPERTY_WORKAROUND;
    public Property<KavoshCell, Float> ANIMATION_OFFSET_X;
    private int TAG;
    private SparseArray<Rect> accessibilityVirtualViewBounds;
    private int addedCaptionHeight;
    private boolean addedForTest;
    private int additionalTimeOffsetY;
    private StaticLayout adminLayout;
    private boolean allowAssistant;
    private float alphaInternal;
    private int animateFromStatusDrawableParams;
    private boolean animatePollAnswer;
    private boolean animatePollAnswerAlpha;
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
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private boolean attachedToWindow;
    private StaticLayout authorLayout;
    private int authorX;
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
    public float captionY;
    private int channelNameAndAvatarHeight;
    StaticLayout channelNameLayout;
    int channelNameStartX;
    float channelNameY;
    private CheckBoxBase checkBox;
    private boolean checkBoxAnimationInProgress;
    private float checkBoxAnimationProgress;
    private int checkBoxTranslation;
    private boolean checkBoxVisible;
    private boolean checkOnlyButtonPressed;
    private String closeTimeText;
    private int closeTimeWidth;
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
    public MessageObject currentMessageObject;
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
    private KavoshCellDelegate delegate;
    private RectF deleteProgressRect;
    private StaticLayout descriptionLayout;
    private int descriptionX;
    private int descriptionY;
    private Runnable diceFinishCallback;
    private boolean disallowLongPress;
    Paint dividerPaint;
    private StaticLayout docTitleLayout;
    private int docTitleOffsetX;
    private int docTitleWidth;
    private TLRPC$Document documentAttach;
    public int documentAttachType;
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
    private boolean drawSelectionBackground;
    private boolean drawTime;
    private float drawTimeX;
    private float drawTimeY;
    private boolean drawVideoImageButton;
    private boolean drawVideoSize;
    private StaticLayout durationLayout;
    private int durationWidth;
    private boolean edited;
    boolean enterTransitionInPorgress;
    private boolean firstCircleLength;
    private int firstVisibleBlockNum;
    private boolean forceNotDrawTime;
    ImageView forwardButton;
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
    private float hintButtonProgress;
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
    private int infoX;
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
    public boolean isBot;
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
    private long lastPollCloseTime;
    private ArrayList<TLRPC$TL_pollAnswerVoters> lastPollResults;
    private int lastPollResultsVoters;
    private String lastPostAuthor;
    private TLRPC$TL_messageReactions lastReactions;
    private int lastRepliesCount;
    private TLRPC$Message lastReplyMessage;
    private long lastSeekUpdateTime;
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
    private boolean mediaBackground;
    private CheckBoxBase mediaCheckBox;
    private int mediaOffsetY;
    private boolean mediaWasInvisible;
    ImageView menuButton;
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
    private float pollAnimationProgress;
    private float pollAnimationProgressTime;
    private AvatarDrawable[] pollAvatarDrawables;
    private ImageReceiver[] pollAvatarImages;
    private boolean[] pollAvatarImagesVisible;
    private ArrayList<PollButton> pollButtons;
    private CheckBoxBase[] pollCheckBox;
    private boolean pollClosed;
    private boolean pollHintPressed;
    private int pollHintX;
    private int pollHintY;
    private boolean pollUnvoteInProgress;
    private boolean pollVoteInProgress;
    private int pollVoteInProgressNum;
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
    private TextView readMoreButton;
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
    private float roundProgressAlpha;
    float roundSeekbarOutAlpha;
    float roundSeekbarOutProgress;
    int roundSeekbarTouched;
    private float roundToPauseProgress;
    private float roundToPauseProgress2;
    private RoundVideoPlayingDrawable roundVideoPlayingDrawable;
    private boolean scheduledInvalidate;
    private Rect scrollRect;
    private SeekBar seekBar;
    private SeekBarAccessibilityDelegate seekBarAccessibilityDelegate;
    private SeekBarWaveform seekBarWaveform;
    private int seekBarX;
    private int seekBarY;
    float seekbarRoundX;
    float seekbarRoundY;
    private float selectedBackgroundProgress;
    private Drawable[] selectorDrawable;
    private int[] selectorDrawableMaskType;
    private AnimatorSet shakeAnimation;
    public boolean shouldDrawMenu;
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
    private TimerParticles timerParticles;
    private float timerTransitionProgress;
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
    private boolean videoClicked;
    VideoForwardDrawable videoForwardDrawable;
    private StaticLayout videoInfoLayout;
    private FrameLayout videoPlayerContainer;
    VideoPlayerRewinder videoPlayerRewinder;
    private RadialProgress2 videoRadialProgress;
    private TextureView videoTextureView;
    private float viewTop;
    private StaticLayout viewsLayout;
    private TextView viewsLayout2;
    private int viewsTextWidth;
    ImageView volumeButton;
    private float voteCurrentCircleLength;
    private float voteCurrentProgressTime;
    private long voteLastUpdateTime;
    private float voteRadOffset;
    private boolean voteRisingCircleLength;
    private boolean wasLayout;
    private boolean wasPinned;
    private boolean wasSending;
    private int widthBeforeNewTimeLine;
    private int widthForButtons;
    private int widthForCaption;

    public interface KavoshCellDelegate {

        /* renamed from: ir.eitaa.ui.explore.cells.KavoshCell$KavoshCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didLongPress(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, float f, float f2) {
            }

            public static boolean $default$didLongPressChannelAvatar(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                return false;
            }

            public static boolean $default$didLongPressUserAvatar(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, TLRPC$User tLRPC$User, float f, float f2) {
                return false;
            }

            public static void $default$didPressBotButton(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
            }

            public static void $default$didPressCancelSendButton(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
            }

            public static void $default$didPressCommentButton(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
            }

            public static void $default$didPressHiddenForward(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
            }

            public static void $default$didPressHint(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, int i) {
            }

            public static void $default$didPressInstantButton(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, int i) {
            }

            public static void $default$didPressReaction(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
            }

            public static void $default$didPressReplyMessage(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, int i) {
            }

            public static void $default$didPressSideButton(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
            }

            public static void $default$didPressTime(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
            }

            public static void $default$didPressUserAvatar(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, TLRPC$User tLRPC$User, float f, float f2) {
            }

            public static void $default$didPressVoteButtons(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell, ArrayList arrayList, int i, int i2, int i3) {
            }

            public static void $default$didStartVideoStream(KavoshCellDelegate kavoshCellDelegate, MessageObject messageObject) {
            }

            public static String $default$getAdminRank(KavoshCellDelegate kavoshCellDelegate, long j) {
                return null;
            }

            public static PinchToZoomHelper $default$getPinchToZoomHelper(KavoshCellDelegate kavoshCellDelegate) {
                return null;
            }

            public static TextSelectionHelper.ChatListTextSelectionHelper $default$getTextSelectionHelper(KavoshCellDelegate kavoshCellDelegate) {
                return null;
            }

            public static boolean $default$isLandscape(KavoshCellDelegate kavoshCellDelegate) {
                return false;
            }

            public static boolean $default$keyboardIsOpened(KavoshCellDelegate kavoshCellDelegate) {
                return false;
            }

            public static void $default$needOpenWebView(KavoshCellDelegate kavoshCellDelegate, MessageObject messageObject, String str, String str2, String str3, String str4, int i, int i2) {
            }

            public static void $default$needReloadPolls(KavoshCellDelegate kavoshCellDelegate) {
            }

            public static void $default$onDiceFinished(KavoshCellDelegate kavoshCellDelegate) {
            }

            public static void $default$setShouldNotRepeatSticker(KavoshCellDelegate kavoshCellDelegate, MessageObject messageObject) {
            }

            public static boolean $default$shouldDrawThreadProgress(KavoshCellDelegate kavoshCellDelegate, KavoshCell kavoshCell) {
                return false;
            }

            public static boolean $default$shouldRepeatSticker(KavoshCellDelegate kavoshCellDelegate, MessageObject messageObject) {
                return true;
            }

            public static void $default$videoTimerReached(KavoshCellDelegate kavoshCellDelegate) {
            }
        }

        boolean canPerformActions();

        void didLongPress(KavoshCell cell, float x, float y);

        boolean didLongPressChannelAvatar(KavoshCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        boolean didLongPressUserAvatar(KavoshCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressBotButton(KavoshCell cell, TLRPC$KeyboardButton button);

        void didPressCancelSendButton(KavoshCell cell);

        void didPressChannelAvatar(KavoshCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        void didPressCommentButton(KavoshCell cell);

        void didPressForwardButton(MessageObject currentMessageObject);

        void didPressHiddenForward(KavoshCell cell);

        void didPressHint(KavoshCell cell, int type);

        void didPressImage(KavoshCell cell, float x, float y);

        void didPressInstantButton(KavoshCell cell, int type);

        void didPressOther(KavoshCell cell, float otherX, float otherY);

        void didPressReaction(KavoshCell cell, TLRPC$TL_reactionCount reaction);

        void didPressReplyMessage(KavoshCell cell, int id);

        void didPressSideButton(KavoshCell cell);

        void didPressTime(KavoshCell cell);

        void didPressUrl(KavoshCell cell, CharacterStyle url, boolean longPress);

        void didPressUserAvatar(KavoshCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressVolumeButton(MessageObject messageObject);

        void didPressVoteButtons(KavoshCell cell, ArrayList<TLRPC$TL_pollAnswer> buttons, int showCount, int x, int y);

        void didStartVideoStream(MessageObject message);

        String getAdminRank(long uid);

        PinchToZoomHelper getPinchToZoomHelper();

        TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper();

        boolean isLandscape();

        boolean keyboardIsOpened();

        void needOpenWebView(MessageObject message, String url, String title, String description, String originalUrl, int w, int h);

        boolean needPlayMessage(MessageObject messageObject);

        void needReloadPolls();

        void onDiceFinished();

        void setShouldNotRepeatSticker(MessageObject message);

        boolean shouldDrawThreadProgress(KavoshCell cell);

        boolean shouldRepeatSticker(MessageObject message);

        void videoTimerReached();
    }

    private boolean checkTextSelection(MotionEvent event) {
        return false;
    }

    private boolean intersect(float left1, float right1, float left2, float right2) {
        return left1 <= left2 ? right1 >= left2 : left1 <= right2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldDrawMenuDrawable() {
        return false;
    }

    private void updateSelectionTextPosition() {
    }

    public int getBackgroundDrawableLeft() {
        return 0;
    }

    public int getBackgroundDrawableTop() {
        return 0;
    }

    static /* synthetic */ int access$4812(KavoshCell kavoshCell, int i) {
        int i2 = kavoshCell.totalHeight + i;
        kavoshCell.totalHeight = i2;
        return i2;
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

        static /* synthetic */ float access$2716(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha + f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ float access$2724(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha - f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ int access$2816(BotButton botButton, float f) {
            int i = (int) (botButton.angle + f);
            botButton.angle = i;
            return i;
        }

        static /* synthetic */ int access$2820(BotButton botButton, int i) {
            int i2 = botButton.angle - i;
            botButton.angle = i2;
            return i2;
        }
    }

    public static class PollButton {
        private TLRPC$TL_pollAnswer answer;
        private boolean chosen;
        private boolean correct;
        private int count;
        private float decimal;
        public int height;
        private int percent;
        private float percentProgress;
        private boolean prevChosen;
        private int prevPercent;
        private float prevPercentProgress;
        private StaticLayout title;
        public int x;
        public int y;

        static /* synthetic */ int access$1712(PollButton pollButton, int i) {
            int i2 = pollButton.percent + i;
            pollButton.percent = i2;
            return i2;
        }

        static /* synthetic */ float access$2424(PollButton pollButton, float f) {
            float f2 = pollButton.decimal - f;
            pollButton.decimal = f2;
            return f2;
        }
    }

    public KavoshCell(Context context) throws Resources.NotFoundException {
        this(context, null);
        createMenuButton();
        createForwardButton();
        createReadMoreButton();
        createViewsLayout();
    }

    public KavoshCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.scrollRect = new Rect();
        this.imageBackgroundGradientRotation = 45;
        this.selectorDrawable = new Drawable[2];
        this.selectorDrawableMaskType = new int[2];
        this.instantButtonRect = new RectF();
        this.pressedState = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        this.deleteProgressRect = new RectF();
        this.rect = new RectF();
        this.timeAlpha = 1.0f;
        this.controlsAlpha = 1.0f;
        this.urlPathCache = new ArrayList<>();
        this.urlPath = new ArrayList<>();
        this.urlPathSelection = new ArrayList<>();
        this.rectPath = new Path();
        this.channelNameAndAvatarHeight = AndroidUtilities.dp(40.0f);
        this.pollButtons = new ArrayList<>();
        this.botButtons = new ArrayList<>();
        this.botButtonsByData = new HashMap<>();
        this.botButtonsByPosition = new HashMap<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.isCheckPressed = true;
        this.drawBackground = true;
        this.backgroundWidth = 100;
        this.drawCommentButton = false;
        this.commentButtonRect = new Rect();
        this.drawName = false;
        this.drawNameLayout = false;
        this.forwardedNameLayout = new StaticLayout[2];
        this.drawForwardedName = false;
        this.forwardNameOffsetX = new float[2];
        this.drawTime = true;
        this.ALPHA_PROPERTY_WORKAROUND = Build.VERSION.SDK_INT == 28;
        this.alphaInternal = 1.0f;
        this.transitionParams = new TransitionParams();
        this.shouldDrawMenu = true;
        this.diceFinishCallback = new Runnable() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.1
            @Override // java.lang.Runnable
            public void run() {
                if (KavoshCell.this.delegate != null) {
                    KavoshCell.this.delegate.onDiceFinished();
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.2
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                KavoshCell.this.checkLocationExpired();
                if (KavoshCell.this.locationExpired) {
                    KavoshCell.this.invalidate();
                    KavoshCell.this.scheduledInvalidate = false;
                    return;
                }
                KavoshCell.this.invalidate(((int) r0.rect.left) - 5, ((int) KavoshCell.this.rect.top) - 5, ((int) KavoshCell.this.rect.right) + 5, ((int) KavoshCell.this.rect.bottom) + 5);
                if (KavoshCell.this.scheduledInvalidate) {
                    AndroidUtilities.runOnUIThread(KavoshCell.this.invalidateRunnable, 1000L);
                }
            }
        };
        this.accessibilityVirtualViewBounds = new SparseArray<>();
        this.currentFocusedVirtualView = -1;
        this.videoClicked = false;
        this.ANIMATION_OFFSET_X = new Property<KavoshCell, Float>(Float.class, "animationOffsetX") { // from class: ir.eitaa.ui.explore.cells.KavoshCell.14
            @Override // android.util.Property
            public Float get(KavoshCell object) {
                return Float.valueOf(object.animationOffsetX);
            }

            @Override // android.util.Property
            public void set(KavoshCell object, Float value) {
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
        this.seekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.3
            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                if (KavoshCell.this.currentMessageObject.isMusic()) {
                    return KavoshCell.this.seekBar.getProgress();
                }
                if (KavoshCell.this.currentMessageObject.isVoice()) {
                    return KavoshCell.this.useSeekBarWaweform ? KavoshCell.this.seekBarWaveform.getProgress() : KavoshCell.this.seekBar.getProgress();
                }
                return 0.0f;
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float progress) {
                if (KavoshCell.this.currentMessageObject.isMusic()) {
                    KavoshCell.this.seekBar.setProgress(progress);
                } else {
                    if (!KavoshCell.this.currentMessageObject.isVoice()) {
                        return;
                    }
                    if (KavoshCell.this.useSeekBarWaweform) {
                        KavoshCell.this.seekBarWaveform.setProgress(progress);
                    } else {
                        KavoshCell.this.seekBar.setProgress(progress);
                    }
                }
                KavoshCell.this.onSeekBarDrag(progress);
                KavoshCell.this.invalidate();
            }
        };
        this.roundVideoPlayingDrawable = new RoundVideoPlayingDrawable(this, resourcesProvider);
    }

    private void createPollUI() {
        if (this.pollAvatarImages != null) {
            return;
        }
        this.pollAvatarImages = new ImageReceiver[3];
        this.pollAvatarDrawables = new AvatarDrawable[3];
        this.pollAvatarImagesVisible = new boolean[3];
        int i = 0;
        while (true) {
            ImageReceiver[] imageReceiverArr = this.pollAvatarImages;
            if (i >= imageReceiverArr.length) {
                break;
            }
            imageReceiverArr[i] = new ImageReceiver(this);
            this.pollAvatarImages[i].setRoundRadius(AndroidUtilities.dp(8.0f));
            this.pollAvatarDrawables[i] = new AvatarDrawable();
            this.pollAvatarDrawables[i].setTextSize(AndroidUtilities.dp(6.0f));
            i++;
        }
        this.pollCheckBox = new CheckBoxBase[10];
        int i2 = 0;
        while (true) {
            CheckBoxBase[] checkBoxBaseArr = this.pollCheckBox;
            if (i2 >= checkBoxBaseArr.length) {
                return;
            }
            checkBoxBaseArr[i2] = new CheckBoxBase(this, 20, this.resourcesProvider);
            this.pollCheckBox[i2].setDrawUnchecked(false);
            this.pollCheckBox[i2].setBackgroundType(9);
            i2++;
        }
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

    private LinkPath obtainNewUrlPath(boolean text) {
        LinkPath linkPath;
        if (!this.urlPathCache.isEmpty()) {
            linkPath = this.urlPathCache.get(0);
            this.urlPathCache.remove(0);
        } else {
            linkPath = new LinkPath();
        }
        linkPath.reset();
        if (text) {
            this.urlPathSelection.add(linkPath);
        } else {
            this.urlPath.add(linkPath);
        }
        return linkPath;
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

    /* JADX WARN: Removed duplicated region for block: B:107:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkTextBlockMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkTextBlockMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkCaptionMotionEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkCaptionMotionEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkGameMotionEvent(MotionEvent event) {
        int i;
        int i2;
        if (!this.hasGamePreview) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 0) {
            if (this.drawPhotoImage && this.drawImageButton && this.buttonState != -1 && x >= (i = this.buttonX) && x <= i + AndroidUtilities.dp(48.0f) && y >= (i2 = this.buttonY) && y <= i2 + AndroidUtilities.dp(48.0f) && this.radialProgress.getIcon() != 4) {
                this.buttonPressed = 1;
                invalidate();
                return true;
            }
            if (this.drawPhotoImage && this.photoImage.isInsideImage(x, y)) {
                this.gamePreviewPressed = true;
                return true;
            }
            if (this.descriptionLayout != null && y >= this.descriptionY) {
                try {
                    int iDp = x - ((this.unmovedTextX + AndroidUtilities.dp(10.0f)) + this.descriptionX);
                    int lineForVertical = this.descriptionLayout.getLineForVertical(y - this.descriptionY);
                    float f = iDp;
                    int offsetForHorizontal = this.descriptionLayout.getOffsetForHorizontal(lineForVertical, f);
                    float lineLeft = this.descriptionLayout.getLineLeft(lineForVertical);
                    if (lineLeft <= f && lineLeft + this.descriptionLayout.getLineWidth(lineForVertical) >= f) {
                        Spannable spannable = (Spannable) this.currentMessageObject.linkDescription;
                        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        if (!(clickableSpanArr.length == 0 || ((clickableSpanArr[0] instanceof URLSpanBotCommand) && !URLSpanBotCommand.enabled))) {
                            this.pressedLink = clickableSpanArr[0];
                            this.linkBlockNum = -10;
                            this.pressedLinkType = 2;
                            resetUrlPaths(false);
                            try {
                                LinkPath linkPathObtainNewUrlPath = obtainNewUrlPath(false);
                                int[] realSpanStartAndEnd = getRealSpanStartAndEnd(spannable, this.pressedLink);
                                linkPathObtainNewUrlPath.setCurrentLayout(this.descriptionLayout, realSpanStartAndEnd[0], 0.0f);
                                this.descriptionLayout.getSelectionPath(realSpanStartAndEnd[0], realSpanStartAndEnd[1], linkPathObtainNewUrlPath);
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                            invalidate();
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        } else if (event.getAction() == 1) {
            if (this.pressedLinkType == 2 || this.gamePreviewPressed || this.buttonPressed != 0) {
                if (this.buttonPressed != 0) {
                    this.buttonPressed = 0;
                    playSoundEffect(0);
                    didPressButton(true, false);
                    invalidate();
                } else {
                    CharacterStyle characterStyle = this.pressedLink;
                    if (characterStyle != null) {
                        if (characterStyle instanceof URLSpan) {
                            Browser.openUrl(getContext(), ((URLSpan) this.pressedLink).getURL());
                        } else if (characterStyle instanceof ClickableSpan) {
                            ((ClickableSpan) characterStyle).onClick(this);
                        }
                        resetPressedLink(2);
                    } else {
                        this.gamePreviewPressed = false;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.botButtons.size()) {
                                break;
                            }
                            BotButton botButton = this.botButtons.get(i3);
                            if (botButton.button instanceof TLRPC$TL_keyboardButtonGame) {
                                playSoundEffect(0);
                                this.delegate.didPressBotButton(this, botButton.button);
                                invalidate();
                                break;
                            }
                            i3++;
                        }
                        resetPressedLink(2);
                        return true;
                    }
                }
            } else {
                resetPressedLink(2);
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkLinkPreviewMotionEvent(android.view.MotionEvent r18) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkLinkPreviewMotionEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkPollButtonMotionEvent(MotionEvent event) {
        int i;
        int i2;
        if (this.currentMessageObject.eventId != 0 || this.pollVoteInProgress || this.pollUnvoteInProgress || this.pollButtons.isEmpty()) {
            return false;
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject.type != 17 || !messageObject.isSent()) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 0) {
            this.pressedVoteButton = -1;
            this.pollHintPressed = false;
            if (this.hintButtonVisible && (i = this.pollHintX) != -1 && x >= i && x <= i + AndroidUtilities.dp(40.0f) && y >= (i2 = this.pollHintY) && y <= i2 + AndroidUtilities.dp(40.0f)) {
                this.pollHintPressed = true;
                this.selectorDrawableMaskType[0] = 3;
                if (Build.VERSION.SDK_INT >= 21) {
                    Drawable[] drawableArr = this.selectorDrawable;
                    if (drawableArr[0] != null) {
                        drawableArr[0].setBounds(this.pollHintX - AndroidUtilities.dp(8.0f), this.pollHintY - AndroidUtilities.dp(8.0f), this.pollHintX + AndroidUtilities.dp(32.0f), this.pollHintY + AndroidUtilities.dp(32.0f));
                        this.selectorDrawable[0].setHotspot(x, y);
                        this.selectorDrawable[0].setState(this.pressedState);
                    }
                }
                invalidate();
            } else {
                for (int i3 = 0; i3 < this.pollButtons.size(); i3++) {
                    PollButton pollButton = this.pollButtons.get(i3);
                    int iDp = (pollButton.y + this.namesOffset) - AndroidUtilities.dp(13.0f);
                    int i4 = pollButton.x;
                    if (x >= i4 && x <= (i4 + this.backgroundWidth) - AndroidUtilities.dp(31.0f) && y >= iDp && y <= pollButton.height + iDp + AndroidUtilities.dp(26.0f)) {
                        this.pressedVoteButton = i3;
                        if (!this.pollVoted && !this.pollClosed) {
                            this.selectorDrawableMaskType[0] = 1;
                            if (Build.VERSION.SDK_INT >= 21) {
                                Drawable[] drawableArr2 = this.selectorDrawable;
                                if (drawableArr2[0] != null) {
                                    drawableArr2[0].setBounds(pollButton.x - AndroidUtilities.dp(9.0f), iDp, (pollButton.x + this.backgroundWidth) - AndroidUtilities.dp(22.0f), pollButton.height + iDp + AndroidUtilities.dp(26.0f));
                                    this.selectorDrawable[0].setHotspot(x, y);
                                    this.selectorDrawable[0].setState(this.pressedState);
                                }
                            }
                            invalidate();
                        }
                    }
                }
                return false;
            }
            return true;
        }
        if (event.getAction() == 1) {
            if (this.pollHintPressed) {
                playSoundEffect(0);
                this.delegate.didPressHint(this, 0);
                this.pollHintPressed = false;
                if (Build.VERSION.SDK_INT < 21) {
                    return false;
                }
                Drawable[] drawableArr3 = this.selectorDrawable;
                if (drawableArr3[0] == null) {
                    return false;
                }
                drawableArr3[0].setState(StateSet.NOTHING);
                return false;
            }
            if (this.pressedVoteButton == -1) {
                return false;
            }
            playSoundEffect(0);
            if (Build.VERSION.SDK_INT >= 21) {
                Drawable[] drawableArr4 = this.selectorDrawable;
                if (drawableArr4[0] != null) {
                    drawableArr4[0].setState(StateSet.NOTHING);
                }
            }
            if (this.currentMessageObject.scheduled) {
                Toast.makeText(getContext(), LocaleController.getString("MessageScheduledVote", ir.eitaa.messenger.R.string.MessageScheduledVote), 1).show();
            } else {
                PollButton pollButton2 = this.pollButtons.get(this.pressedVoteButton);
                TLRPC$TL_pollAnswer tLRPC$TL_pollAnswer = pollButton2.answer;
                if (this.pollVoted || this.pollClosed) {
                    ArrayList<TLRPC$TL_pollAnswer> arrayList = new ArrayList<>();
                    arrayList.add(tLRPC$TL_pollAnswer);
                    this.delegate.didPressVoteButtons(this, arrayList, pollButton2.count, pollButton2.x + AndroidUtilities.dp(50.0f), this.namesOffset + pollButton2.y);
                } else if (this.lastPoll.multiple_choice) {
                    if (this.currentMessageObject.checkedVotes.contains(tLRPC$TL_pollAnswer)) {
                        this.currentMessageObject.checkedVotes.remove(tLRPC$TL_pollAnswer);
                        this.pollCheckBox[this.pressedVoteButton].setChecked(false, true);
                    } else {
                        this.currentMessageObject.checkedVotes.add(tLRPC$TL_pollAnswer);
                        this.pollCheckBox[this.pressedVoteButton].setChecked(true, true);
                    }
                } else {
                    this.pollVoteInProgressNum = this.pressedVoteButton;
                    this.pollVoteInProgress = true;
                    this.vibrateOnPollVote = true;
                    this.voteCurrentProgressTime = 0.0f;
                    this.firstCircleLength = true;
                    this.voteCurrentCircleLength = 360.0f;
                    this.voteRisingCircleLength = false;
                    ArrayList<TLRPC$TL_pollAnswer> arrayList2 = new ArrayList<>();
                    arrayList2.add(tLRPC$TL_pollAnswer);
                    this.delegate.didPressVoteButtons(this, arrayList2, -1, 0, 0);
                }
            }
            this.pressedVoteButton = -1;
            invalidate();
            return false;
        }
        if (event.getAction() != 2) {
            return false;
        }
        if ((this.pressedVoteButton == -1 && !this.pollHintPressed) || Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Drawable[] drawableArr5 = this.selectorDrawable;
        if (drawableArr5[0] == null) {
            return false;
        }
        drawableArr5[0].setHotspot(x, y);
        return false;
    }

    private boolean checkInstantButtonMotionEvent(MotionEvent event) {
        if (!this.currentMessageObject.isSponsored() && (!this.drawInstantView || this.currentMessageObject.type == 0)) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 0) {
            if (this.drawInstantView) {
                float f = x;
                float f2 = y;
                if (this.instantButtonRect.contains(f, f2)) {
                    this.selectorDrawableMaskType[0] = this.lastPoll == null ? 0 : 2;
                    this.instantPressed = true;
                    if (Build.VERSION.SDK_INT >= 21 && this.selectorDrawable[0] != null && this.instantButtonRect.contains(f, f2)) {
                        this.selectorDrawable[0].setHotspot(f, f2);
                        this.selectorDrawable[0].setState(this.pressedState);
                        this.instantButtonPressed = true;
                    }
                    invalidate();
                    return true;
                }
            }
        } else if (event.getAction() == 1) {
            if (this.instantPressed) {
                KavoshCellDelegate kavoshCellDelegate = this.delegate;
                if (kavoshCellDelegate != null) {
                    if (this.lastPoll != null) {
                        MessageObject messageObject = this.currentMessageObject;
                        if (messageObject.scheduled) {
                            Toast.makeText(getContext(), LocaleController.getString("MessageScheduledVoteResults", ir.eitaa.messenger.R.string.MessageScheduledVoteResults), 1).show();
                        } else if (this.pollVoted || this.pollClosed) {
                            kavoshCellDelegate.didPressInstantButton(this, this.drawInstantViewType);
                        } else {
                            if (!messageObject.checkedVotes.isEmpty()) {
                                this.pollVoteInProgressNum = -1;
                                this.pollVoteInProgress = true;
                                this.vibrateOnPollVote = true;
                                this.voteCurrentProgressTime = 0.0f;
                                this.firstCircleLength = true;
                                this.voteCurrentCircleLength = 360.0f;
                                this.voteRisingCircleLength = false;
                            }
                            this.delegate.didPressVoteButtons(this, this.currentMessageObject.checkedVotes, -1, 0, this.namesOffset);
                        }
                    } else {
                        kavoshCellDelegate.didPressInstantButton(this, this.drawInstantViewType);
                    }
                }
                playSoundEffect(0);
                if (Build.VERSION.SDK_INT >= 21) {
                    Drawable[] drawableArr = this.selectorDrawable;
                    if (drawableArr[0] != null) {
                        drawableArr[0].setState(StateSet.NOTHING);
                    }
                }
                this.instantButtonPressed = false;
                this.instantPressed = false;
                invalidate();
            }
        } else if (event.getAction() == 2 && this.instantButtonPressed && Build.VERSION.SDK_INT >= 21) {
            Drawable[] drawableArr2 = this.selectorDrawable;
            if (drawableArr2[0] != null) {
                drawableArr2[0].setHotspot(x, y);
            }
        }
        return false;
    }

    private void invalidateWithParent() {
        if (this.currentMessagesGroup != null && getParent() != null) {
            ((ViewGroup) getParent()).invalidate();
        }
        invalidate();
    }

    private boolean checkCommentButtonMotionEvent(MotionEvent event) {
        int i = 0;
        if (!this.drawCommentButton) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if (groupedMessagePosition != null && (groupedMessagePosition.flags & 1) == 0 && this.commentButtonRect.contains(x, y)) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int childCount = viewGroup.getChildCount();
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if (childAt != this && (childAt instanceof KavoshCell)) {
                    KavoshCell kavoshCell = (KavoshCell) childAt;
                    if (kavoshCell.drawCommentButton && kavoshCell.currentMessagesGroup == this.currentMessagesGroup && (kavoshCell.currentPosition.flags & 1) != 0) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, event.getActionMasked(), (event.getX() + getLeft()) - kavoshCell.getLeft(), (event.getY() + getTop()) - kavoshCell.getTop(), 0);
                        kavoshCell.checkCommentButtonMotionEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        break;
                    }
                }
                i++;
            }
            return true;
        }
        if (event.getAction() == 0) {
            if (this.commentButtonRect.contains(x, y)) {
                if (this.currentMessageObject.isSent()) {
                    this.selectorDrawableMaskType[1] = 2;
                    this.commentButtonPressed = true;
                    if (Build.VERSION.SDK_INT >= 21) {
                        Drawable[] drawableArr = this.selectorDrawable;
                        if (drawableArr[1] != null) {
                            drawableArr[1].setHotspot(x, y);
                            this.selectorDrawable[1].setState(this.pressedState);
                        }
                    }
                    invalidateWithParent();
                }
                return true;
            }
        } else if (event.getAction() == 1) {
            if (this.commentButtonPressed) {
                KavoshCellDelegate kavoshCellDelegate = this.delegate;
                if (kavoshCellDelegate != null) {
                    if (this.isRepliesChat) {
                        kavoshCellDelegate.didPressSideButton(this);
                    } else {
                        kavoshCellDelegate.didPressCommentButton(this);
                    }
                }
                playSoundEffect(0);
                if (Build.VERSION.SDK_INT >= 21) {
                    Drawable[] drawableArr2 = this.selectorDrawable;
                    if (drawableArr2[1] != null) {
                        drawableArr2[1].setState(StateSet.NOTHING);
                    }
                }
                this.commentButtonPressed = false;
                invalidateWithParent();
            }
        } else if (event.getAction() == 2 && this.commentButtonPressed && Build.VERSION.SDK_INT >= 21) {
            Drawable[] drawableArr3 = this.selectorDrawable;
            if (drawableArr3[1] != null) {
                drawableArr3[1].setHotspot(x, y);
            }
        }
        return false;
    }

    private boolean checkOtherButtonMotionEvent(MotionEvent motionEvent) {
        MessageObject.GroupedMessagePosition groupedMessagePosition;
        int i = this.documentAttachType;
        if ((i == 5 || i == 1) && (groupedMessagePosition = this.currentPosition) != null && (groupedMessagePosition.flags & 4) == 0) {
            return false;
        }
        int i2 = this.currentMessageObject.type;
        boolean z = i2 == 16;
        if (!z) {
            z = ((i != 1 && i2 != 12 && i != 5 && i != 4 && i != 2 && i2 != 8) || this.hasGamePreview || this.hasInvoicePreview) ? false : true;
        }
        if (!z) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            MessageObject messageObject = this.currentMessageObject;
            if (messageObject.type == 16) {
                boolean zIsVideoCall = messageObject.isVideoCall();
                int i3 = this.otherX;
                if (x >= i3) {
                    if (x <= i3 + AndroidUtilities.dp((!zIsVideoCall ? 202 : 200) + 30) && y >= this.otherY - AndroidUtilities.dp(14.0f) && y <= this.otherY + AndroidUtilities.dp(50.0f)) {
                        this.otherPressed = true;
                        this.selectorDrawableMaskType[0] = 4;
                        if (Build.VERSION.SDK_INT >= 21 && this.selectorDrawable[0] != null) {
                            int iDp = this.otherX + AndroidUtilities.dp(!zIsVideoCall ? 202.0f : 200.0f) + (Theme.chat_msgInCallDrawable[zIsVideoCall ? 1 : 0].getIntrinsicWidth() / 2);
                            int intrinsicHeight = this.otherY + (Theme.chat_msgInCallDrawable[zIsVideoCall ? 1 : 0].getIntrinsicHeight() / 2);
                            this.selectorDrawable[0].setBounds(iDp - AndroidUtilities.dp(20.0f), intrinsicHeight - AndroidUtilities.dp(20.0f), iDp + AndroidUtilities.dp(20.0f), intrinsicHeight + AndroidUtilities.dp(20.0f));
                            this.selectorDrawable[0].setHotspot(x, y);
                            this.selectorDrawable[0].setState(this.pressedState);
                        }
                        invalidate();
                        return true;
                    }
                }
            } else if (x >= this.otherX - AndroidUtilities.dp(20.0f) && x <= this.otherX + AndroidUtilities.dp(20.0f) && y >= this.otherY - AndroidUtilities.dp(4.0f) && y <= this.otherY + AndroidUtilities.dp(30.0f)) {
                this.otherPressed = true;
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 1) {
            if (this.otherPressed) {
                if (this.currentMessageObject.type == 16 && Build.VERSION.SDK_INT >= 21) {
                    Drawable[] drawableArr = this.selectorDrawable;
                    if (drawableArr[0] != null) {
                        drawableArr[0].setState(StateSet.NOTHING);
                    }
                }
                this.otherPressed = false;
                playSoundEffect(0);
                this.delegate.didPressOther(this, this.otherX, this.otherY);
                invalidate();
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.currentMessageObject.type == 16 && this.otherPressed && Build.VERSION.SDK_INT >= 21) {
            Drawable[] drawableArr2 = this.selectorDrawable;
            if (drawableArr2[0] != null) {
                drawableArr2[0].setHotspot(x, y);
            }
        }
        return false;
    }

    private boolean checkDateMotionEvent(MotionEvent event) {
        if (!this.currentMessageObject.isImportedForward()) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 0) {
            float f = x;
            float f2 = this.drawTimeX;
            if (f < f2 || f > f2 + this.timeWidth) {
                return false;
            }
            float f3 = y;
            float f4 = this.drawTimeY;
            if (f3 < f4 || f3 > f4 + AndroidUtilities.dp(20.0f)) {
                return false;
            }
            this.timePressed = true;
            invalidate();
        } else {
            if (event.getAction() != 1 || !this.timePressed) {
                return false;
            }
            this.timePressed = false;
            playSoundEffect(0);
            this.delegate.didPressTime(this);
            invalidate();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkRoundSeekbar(android.view.MotionEvent r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkRoundSeekbar(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkPhotoImageMotionEvent(android.view.MotionEvent r9) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkPhotoImageMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkAudioMotionEvent(android.view.MotionEvent r13) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.checkAudioMotionEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkBotButtonMotionEvent(MotionEvent event) {
        int iDp;
        if (this.botButtons.isEmpty() || this.currentMessageObject.eventId != 0) {
            return false;
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == 0) {
            if (this.currentMessageObject.isOutOwner()) {
                iDp = (getMeasuredWidth() - this.widthForButtons) - AndroidUtilities.dp(10.0f);
            } else {
                iDp = this.backgroundDrawableLeft + AndroidUtilities.dp(this.mediaBackground ? 1.0f : 7.0f);
            }
            for (int i = 0; i < this.botButtons.size(); i++) {
                BotButton botButton = this.botButtons.get(i);
                int iDp2 = (botButton.y + this.layoutHeight) - AndroidUtilities.dp(2.0f);
                if (x >= botButton.x + iDp && x <= botButton.x + iDp + botButton.width && y >= iDp2 && y <= iDp2 + botButton.height) {
                    this.pressedBotButton = i;
                    invalidate();
                    return true;
                }
            }
            return false;
        }
        if (event.getAction() != 1 || this.pressedBotButton == -1) {
            return false;
        }
        playSoundEffect(0);
        if (this.currentMessageObject.scheduled) {
            Toast.makeText(getContext(), LocaleController.getString("MessageScheduledBotAction", ir.eitaa.messenger.R.string.MessageScheduledBotAction), 1).show();
        } else {
            BotButton botButton2 = this.botButtons.get(this.pressedBotButton);
            if (botButton2.button != null) {
                this.delegate.didPressBotButton(this, botButton2.button);
            } else if (botButton2.reaction != null) {
                this.delegate.didPressReaction(this, botButton2.reaction);
            }
        }
        this.pressedBotButton = -1;
        invalidate();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) throws InterruptedException, IOException {
        int i;
        int i2;
        if (this.currentMessageObject == null || !this.delegate.canPerformActions() || this.animationRunning) {
            checkTextSelection(event);
            return super.onTouchEvent(event);
        }
        boolean z = true;
        if (checkTextSelection(event) || checkRoundSeekbar(event)) {
            return true;
        }
        VideoPlayerRewinder videoPlayerRewinder = this.videoPlayerRewinder;
        if (videoPlayerRewinder != null && videoPlayerRewinder.rewindCount > 0) {
            if (event.getAction() != 1 && event.getAction() != 3) {
                return true;
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            this.videoPlayerRewinder.cancelRewind();
            return false;
        }
        this.disallowLongPress = false;
        this.lastTouchX = event.getX();
        float y = event.getY();
        this.lastTouchY = y;
        this.backgroundDrawable.setTouchCoords(this.lastTouchX, y);
        boolean zCheckTextBlockMotionEvent = checkTextBlockMotionEvent(event);
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkPinchToZoom(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkDateMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkTextSelection(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkOtherButtonMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkCaptionMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkAudioMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkLinkPreviewMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkInstantButtonMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkCommentButtonMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkGameMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkPhotoImageMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkBotButtonMotionEvent(event);
        }
        if (!zCheckTextBlockMotionEvent) {
            zCheckTextBlockMotionEvent = checkPollButtonMotionEvent(event);
        }
        if (event.getAction() == 3) {
            this.buttonPressed = 0;
            this.miniButtonPressed = 0;
            this.pressedBotButton = -1;
            this.pressedVoteButton = -1;
            this.pollHintPressed = false;
            this.psaHintPressed = false;
            this.linkPreviewPressed = false;
            this.otherPressed = false;
            this.imagePressed = false;
            this.timePressed = false;
            this.gamePreviewPressed = false;
            this.commentButtonPressed = false;
            this.instantButtonPressed = false;
            this.instantPressed = false;
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
            resetPressedLink(-1);
            zCheckTextBlockMotionEvent = false;
        }
        updateRadialProgressBackground();
        if (!this.disallowLongPress && zCheckTextBlockMotionEvent && event.getAction() == 0) {
            startCheckLongPress();
        }
        if (event.getAction() != 0 && event.getAction() != 2) {
            cancelCheckLongPress();
        }
        if (zCheckTextBlockMotionEvent) {
            return zCheckTextBlockMotionEvent;
        }
        float x = event.getX();
        float y2 = event.getY();
        if (event.getAction() == 0) {
            KavoshCellDelegate kavoshCellDelegate = this.delegate;
            if (kavoshCellDelegate != null && !kavoshCellDelegate.canPerformActions()) {
                return zCheckTextBlockMotionEvent;
            }
            if (checkIsInsideChannelNameAndAvatar(x, y2)) {
                this.avatarPressed = true;
            } else {
                z = zCheckTextBlockMotionEvent;
            }
            if (z) {
                startCheckLongPress();
            }
            return z;
        }
        if (event.getAction() != 2) {
            cancelCheckLongPress();
        }
        if (!this.avatarPressed) {
            return zCheckTextBlockMotionEvent;
        }
        if (event.getAction() == 1) {
            this.avatarPressed = false;
            playSoundEffect(0);
            KavoshCellDelegate kavoshCellDelegate2 = this.delegate;
            if (kavoshCellDelegate2 == null) {
                return zCheckTextBlockMotionEvent;
            }
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null) {
                if (tLRPC$User.id == 0) {
                    kavoshCellDelegate2.didPressHiddenForward(this);
                    return zCheckTextBlockMotionEvent;
                }
                kavoshCellDelegate2.didPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
                return zCheckTextBlockMotionEvent;
            }
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat == null) {
                return zCheckTextBlockMotionEvent;
            }
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
            kavoshCellDelegate2.didPressChannelAvatar(this, tLRPC$Chat, i, this.lastTouchX, this.lastTouchY);
            return zCheckTextBlockMotionEvent;
        }
        if (event.getAction() != 3) {
            return zCheckTextBlockMotionEvent;
        }
        this.avatarPressed = false;
        return zCheckTextBlockMotionEvent;
    }

    private boolean checkIsInsideChannelNameAndAvatar(float x, float y) {
        int iDp = (int) (this.currentMessageObject.type == 0 ? 0.0f : this.captionY + AndroidUtilities.dp(4.0f));
        if (x >= this.channelNameStartX && x <= this.avatarImage.getImageX() + this.avatarImage.getImageWidth()) {
            float f = iDp;
            if (y >= f && y <= f + this.avatarImage.getImageHeight()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPinchToZoom(MotionEvent ev) {
        KavoshCellDelegate kavoshCellDelegate = this.delegate;
        PinchToZoomHelper pinchToZoomHelper = kavoshCellDelegate == null ? null : kavoshCellDelegate.getPinchToZoomHelper();
        if (this.currentMessageObject == null || !this.photoImage.hasNotThumb() || pinchToZoomHelper == null || this.currentMessageObject.isSticker() || this.currentMessageObject.isAnimatedEmoji()) {
            return false;
        }
        if ((this.currentMessageObject.isVideo() && !this.autoPlayingMedia) || this.isRoundVideo || this.currentMessageObject.isAnimatedSticker()) {
            return false;
        }
        if ((!this.currentMessageObject.isDocument() || this.currentMessageObject.isGif()) && !this.currentMessageObject.needDrawBluredPreview()) {
            return pinchToZoomHelper.checkPinchToZoom(ev, this, this.photoImage, this.currentMessageObject);
        }
        return false;
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
                }
                if (SharedConfig.shouldPlayWithSound) {
                    invalidate();
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
            this.parentViewTopOffset = parentOffset;
            this.parentHeight = parent;
        }
        if ((this.currentMessageObject != null && ((hasGradientService() && this.currentMessageObject.shouldDrawWithoutBackground()) || !this.botButtons.isEmpty())) || ((messageDrawable = this.currentBackgroundDrawable) != null && messageDrawable.getGradientShader() != null)) {
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

    private void didClickedImage() {
        TLRPC$WebPage tLRPC$WebPage;
        boolean z;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject.type == 1 || messageObject.isAnyKindOfSticker()) {
            int i = this.buttonState;
            if (i == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            } else {
                if (i == 0) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        MessageObject messageObject2 = this.currentMessageObject;
        int i2 = messageObject2.type;
        if (i2 == 12) {
            this.delegate.didPressUserAvatar(this, MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.currentMessageObject.messageOwner.media.user_id)), this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i2 == 5) {
            if (this.buttonState != -1) {
                didPressButton(true, false);
                return;
            } else if (!MediaController.getInstance().isPlayingMessage(this.currentMessageObject) || MediaController.getInstance().isMessagePaused()) {
                this.delegate.needPlayMessage(this.currentMessageObject);
                return;
            } else {
                MediaController.getInstance().lambda$startAudioAgain$7$MediaController(this.currentMessageObject);
                return;
            }
        }
        if (i2 == 8) {
            int i3 = this.buttonState;
            if (i3 == -1 || (i3 == 1 && this.canStreamVideo && this.autoPlayingMedia)) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            } else {
                if (i3 == 2 || i3 == 0) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        int i4 = this.documentAttachType;
        if (i4 == 4) {
            int i5 = this.buttonState;
            if (i5 == -1 || ((z = this.drawVideoImageButton) && (this.autoPlayingMedia || (SharedConfig.streamMedia && this.canStreamVideo)))) {
                this.videoClicked = true;
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            } else if (z) {
                didPressButton(true, true);
                return;
            } else {
                if (i5 == 0 || i5 == 3) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        if (i2 == 4) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i4 == 1) {
            if (this.buttonState == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            }
            return;
        }
        if (i4 == 2) {
            if (this.buttonState != -1 || (tLRPC$WebPage = messageObject2.messageOwner.media.webpage) == null) {
                return;
            }
            String str = tLRPC$WebPage.embed_url;
            if (str != null && str.length() != 0) {
                this.delegate.needOpenWebView(this.currentMessageObject, tLRPC$WebPage.embed_url, tLRPC$WebPage.site_name, tLRPC$WebPage.description, tLRPC$WebPage.url, tLRPC$WebPage.embed_width, tLRPC$WebPage.embed_height);
                return;
            } else {
                Browser.openUrl(getContext(), tLRPC$WebPage.url);
                return;
            }
        }
        if (this.hasInvoicePreview) {
            if (this.buttonState == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            }
        } else if (i2 == 72) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
        }
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.isPhotoDataChanged(ir.eitaa.messenger.MessageObject):boolean");
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

    private boolean isUserDataChanged() {
        TLRPC$FileLocation tLRPC$FileLocation;
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        MessageObject messageObject;
        MessageObject messageObject2;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        TLRPC$MessageMedia tLRPC$MessageMedia;
        MessageObject messageObject3 = this.currentMessageObject;
        if (messageObject3 != null && !this.hasLinkPreview && (tLRPC$MessageMedia = messageObject3.messageOwner.media) != null && (tLRPC$MessageMedia.webpage instanceof TLRPC$TL_webPage)) {
            return true;
        }
        if (messageObject3 != null && (this.currentUser != null || this.currentChat != null)) {
            int i = this.lastSendState;
            TLRPC$Message tLRPC$Message = messageObject3.messageOwner;
            if (i != tLRPC$Message.send_state || this.lastDeleteDate != tLRPC$Message.destroyTime || this.lastViewsCount != tLRPC$Message.views || this.lastRepliesCount != getRepliesCount() || this.lastReactions != this.currentMessageObject.messageOwner.reactions) {
                return true;
            }
            updateCurrentUserAndChat();
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null && (tLRPC$UserProfilePhoto = tLRPC$User.photo) != null) {
                tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
            } else {
                TLRPC$Chat tLRPC$Chat = this.currentChat;
                tLRPC$FileLocation = (tLRPC$Chat == null || (tLRPC$ChatPhoto = tLRPC$Chat.photo) == null) ? null : tLRPC$ChatPhoto.photo_small;
            }
            if (this.replyTextLayout == null && (messageObject2 = this.currentMessageObject.replyMessageObject) != null && (!this.isThreadChat || (tLRPC$MessageFwdHeader = messageObject2.messageOwner.fwd_from) == null || tLRPC$MessageFwdHeader.channel_post == 0)) {
                return true;
            }
            TLRPC$FileLocation tLRPC$FileLocation2 = this.currentPhoto;
            if ((tLRPC$FileLocation2 == null && tLRPC$FileLocation != null) || ((tLRPC$FileLocation2 != null && tLRPC$FileLocation == null) || (tLRPC$FileLocation2 != null && (tLRPC$FileLocation2.local_id != tLRPC$FileLocation.local_id || tLRPC$FileLocation2.volume_id != tLRPC$FileLocation.volume_id)))) {
                return true;
            }
            if (this.replyNameLayout == null || (messageObject = this.currentMessageObject.replyMessageObject) == null || (closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 40)) == null || this.currentMessageObject.replyMessageObject.isAnyKindOfSticker()) {
                closestPhotoSizeWithSize = null;
            }
            if (this.currentReplyPhoto == null && closestPhotoSizeWithSize != null) {
                return true;
            }
            String authorName = isNeedAuthorName() ? getAuthorName() : null;
            String str = this.currentNameString;
            if ((str == null && authorName != null) || ((str != null && authorName == null) || (str != null && !str.equals(authorName)))) {
                return true;
            }
            if (this.drawForwardedName && this.currentMessageObject.needDrawForwarded()) {
                String forwardedName = this.currentMessageObject.getForwardedName();
                String str2 = this.currentForwardNameString;
                if (str2 == null && forwardedName != null) {
                    return true;
                }
                if (str2 == null || forwardedName != null) {
                    return (str2 == null || str2.equals(forwardedName)) ? false : true;
                }
                return true;
            }
        }
        return false;
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
    protected void onDetachedFromWindow() throws InterruptedException, IOException {
        super.onDetachedFromWindow();
        cancelShakeAnimation();
        if (this.animationRunning) {
            return;
        }
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
        if (this.currentMessageObject.isVideo()) {
            stopVideo();
        } else if (this.currentMessageObject.isMusic()) {
            stopMusic();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws Resources.NotFoundException {
        ImageView imageView;
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
            this.toSeekBarProgress = MediaController.getInstance().isPlayingMessage(this.currentMessageObject) ? 1.0f : 0.0f;
        }
        if (this.menuButton == null || (imageView = this.forwardButton) == null) {
            return;
        }
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
        this.menuButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 5794 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1068:0x1619  */
    /* JADX WARN: Removed duplicated region for block: B:1081:0x163d  */
    /* JADX WARN: Removed duplicated region for block: B:1084:0x165f  */
    /* JADX WARN: Removed duplicated region for block: B:1095:0x1680  */
    /* JADX WARN: Removed duplicated region for block: B:1111:0x16bc  */
    /* JADX WARN: Removed duplicated region for block: B:1130:0x16f0  */
    /* JADX WARN: Removed duplicated region for block: B:1133:0x1704  */
    /* JADX WARN: Removed duplicated region for block: B:1134:0x170b  */
    /* JADX WARN: Removed duplicated region for block: B:1156:0x174a  */
    /* JADX WARN: Removed duplicated region for block: B:1157:0x1751  */
    /* JADX WARN: Removed duplicated region for block: B:1160:0x175d  */
    /* JADX WARN: Removed duplicated region for block: B:1163:0x1767  */
    /* JADX WARN: Removed duplicated region for block: B:1168:0x1770  */
    /* JADX WARN: Removed duplicated region for block: B:1170:0x177c  */
    /* JADX WARN: Removed duplicated region for block: B:1215:0x183b  */
    /* JADX WARN: Removed duplicated region for block: B:1218:0x1840  */
    /* JADX WARN: Removed duplicated region for block: B:1222:0x186b  */
    /* JADX WARN: Removed duplicated region for block: B:1228:0x189b  */
    /* JADX WARN: Removed duplicated region for block: B:1231:0x18e0  */
    /* JADX WARN: Removed duplicated region for block: B:1233:0x1909  */
    /* JADX WARN: Removed duplicated region for block: B:1300:0x1b3d  */
    /* JADX WARN: Removed duplicated region for block: B:1350:0x1c67  */
    /* JADX WARN: Removed duplicated region for block: B:1354:0x1c96  */
    /* JADX WARN: Removed duplicated region for block: B:1356:0x1c9a  */
    /* JADX WARN: Removed duplicated region for block: B:1385:0x1dd8  */
    /* JADX WARN: Removed duplicated region for block: B:1450:0x2010  */
    /* JADX WARN: Removed duplicated region for block: B:1451:0x2013  */
    /* JADX WARN: Removed duplicated region for block: B:1454:0x2026  */
    /* JADX WARN: Removed duplicated region for block: B:1456:0x202f  */
    /* JADX WARN: Removed duplicated region for block: B:1478:0x20f3  */
    /* JADX WARN: Removed duplicated region for block: B:1485:0x211e  */
    /* JADX WARN: Removed duplicated region for block: B:1488:0x212b  */
    /* JADX WARN: Removed duplicated region for block: B:1489:0x212f  */
    /* JADX WARN: Removed duplicated region for block: B:1764:0x2813  */
    /* JADX WARN: Removed duplicated region for block: B:1899:0x2acf  */
    /* JADX WARN: Removed duplicated region for block: B:1902:0x2add  */
    /* JADX WARN: Removed duplicated region for block: B:1919:0x2c0e  */
    /* JADX WARN: Removed duplicated region for block: B:1925:0x2c24  */
    /* JADX WARN: Removed duplicated region for block: B:1932:0x2cbd  */
    /* JADX WARN: Removed duplicated region for block: B:1943:0x2cd7  */
    /* JADX WARN: Removed duplicated region for block: B:1946:0x2ce7  */
    /* JADX WARN: Removed duplicated region for block: B:1948:0x2cf8  */
    /* JADX WARN: Removed duplicated region for block: B:2098:0x318e  */
    /* JADX WARN: Removed duplicated region for block: B:2103:0x31b9  */
    /* JADX WARN: Removed duplicated region for block: B:2146:0x32c9  */
    /* JADX WARN: Removed duplicated region for block: B:2151:0x32d4  */
    /* JADX WARN: Removed duplicated region for block: B:2175:0x3330  */
    /* JADX WARN: Removed duplicated region for block: B:2178:0x3335  */
    /* JADX WARN: Removed duplicated region for block: B:2208:0x338e  */
    /* JADX WARN: Removed duplicated region for block: B:2226:0x33e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2227:0x33e3  */
    /* JADX WARN: Removed duplicated region for block: B:2235:0x3406  */
    /* JADX WARN: Removed duplicated region for block: B:2242:0x3448  */
    /* JADX WARN: Removed duplicated region for block: B:2245:0x3454  */
    /* JADX WARN: Removed duplicated region for block: B:2248:0x3481  */
    /* JADX WARN: Removed duplicated region for block: B:2249:0x3484  */
    /* JADX WARN: Removed duplicated region for block: B:2252:0x348c  */
    /* JADX WARN: Removed duplicated region for block: B:2253:0x348f  */
    /* JADX WARN: Removed duplicated region for block: B:2256:0x3499  */
    /* JADX WARN: Removed duplicated region for block: B:2259:0x34a0  */
    /* JADX WARN: Removed duplicated region for block: B:2266:0x34c5  */
    /* JADX WARN: Removed duplicated region for block: B:2418:0x37cf  */
    /* JADX WARN: Removed duplicated region for block: B:2473:0x393c A[PHI: r4 r6
      0x393c: PHI (r4v71 int) = (r4v65 int), (r4v65 int), (r4v72 int) binds: [B:2462:0x3913, B:2464:0x3924, B:2472:0x393b] A[DONT_GENERATE, DONT_INLINE]
      0x393c: PHI (r6v63 int) = (r6v689 int), (r6v690 int), (r6v691 int) binds: [B:2462:0x3913, B:2464:0x3924, B:2472:0x393b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2479:0x3949  */
    /* JADX WARN: Removed duplicated region for block: B:2483:0x3962  */
    /* JADX WARN: Removed duplicated region for block: B:2487:0x396a A[PHI: r6
      0x396a: PHI (r6v109 int) = (r6v687 int), (r6v110 int) binds: [B:2484:0x3965, B:2486:0x3968] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2492:0x3982  */
    /* JADX WARN: Removed duplicated region for block: B:2494:0x3985  */
    /* JADX WARN: Removed duplicated region for block: B:2498:0x39a0  */
    /* JADX WARN: Removed duplicated region for block: B:2501:0x39ad A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2514:0x3a22  */
    /* JADX WARN: Removed duplicated region for block: B:2524:0x3a5f  */
    /* JADX WARN: Removed duplicated region for block: B:2530:0x3aac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2535:0x3ab4  */
    /* JADX WARN: Removed duplicated region for block: B:2542:0x3ac3  */
    /* JADX WARN: Removed duplicated region for block: B:2575:0x3b17  */
    /* JADX WARN: Removed duplicated region for block: B:2585:0x3bce  */
    /* JADX WARN: Removed duplicated region for block: B:2736:0x3f83  */
    /* JADX WARN: Removed duplicated region for block: B:2745:0x3fa0  */
    /* JADX WARN: Removed duplicated region for block: B:2763:0x3fee  */
    /* JADX WARN: Removed duplicated region for block: B:2774:0x4033 A[PHI: r0 r2
      0x4033: PHI (r0v172 int) = (r0v171 int), (r0v171 int), (r0v175 int) binds: [B:2765:0x4003, B:2767:0x400b, B:2772:0x4029] A[DONT_GENERATE, DONT_INLINE]
      0x4033: PHI (r2v329 int) = (r2v328 int), (r2v328 int), (r2v332 int) binds: [B:2765:0x4003, B:2767:0x400b, B:2772:0x4029] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2777:0x4039  */
    /* JADX WARN: Removed duplicated region for block: B:2780:0x4046  */
    /* JADX WARN: Removed duplicated region for block: B:2781:0x4055  */
    /* JADX WARN: Removed duplicated region for block: B:2784:0x4065  */
    /* JADX WARN: Removed duplicated region for block: B:2813:0x40d6  */
    /* JADX WARN: Removed duplicated region for block: B:2817:0x40e6  */
    /* JADX WARN: Removed duplicated region for block: B:2823:0x40f4  */
    /* JADX WARN: Removed duplicated region for block: B:2842:0x417f  */
    /* JADX WARN: Removed duplicated region for block: B:2853:0x41bc A[Catch: Exception -> 0x420a, TryCatch #17 {Exception -> 0x420a, blocks: (B:2845:0x4184, B:2847:0x418f, B:2849:0x4195, B:2851:0x41b7, B:2853:0x41bc, B:2855:0x41c4, B:2857:0x41cc, B:2859:0x41f6), top: B:3127:0x4184 }] */
    /* JADX WARN: Removed duplicated region for block: B:2866:0x4214  */
    /* JADX WARN: Removed duplicated region for block: B:2868:0x4219  */
    /* JADX WARN: Removed duplicated region for block: B:2877:0x423c  */
    /* JADX WARN: Removed duplicated region for block: B:2921:0x4368  */
    /* JADX WARN: Removed duplicated region for block: B:2924:0x4370  */
    /* JADX WARN: Removed duplicated region for block: B:3006:0x46ab  */
    /* JADX WARN: Removed duplicated region for block: B:3009:0x46b4  */
    /* JADX WARN: Removed duplicated region for block: B:3016:0x46d1  */
    /* JADX WARN: Removed duplicated region for block: B:3019:0x46df  */
    /* JADX WARN: Removed duplicated region for block: B:3020:0x46e1  */
    /* JADX WARN: Removed duplicated region for block: B:3021:0x46ed  */
    /* JADX WARN: Removed duplicated region for block: B:3033:0x470f  */
    /* JADX WARN: Removed duplicated region for block: B:3036:0x471a  */
    /* JADX WARN: Removed duplicated region for block: B:3044:0x474d  */
    /* JADX WARN: Removed duplicated region for block: B:3046:0x4755  */
    /* JADX WARN: Removed duplicated region for block: B:3048:0x4763  */
    /* JADX WARN: Removed duplicated region for block: B:3061:0x47aa  */
    /* JADX WARN: Removed duplicated region for block: B:3064:0x47b2  */
    /* JADX WARN: Removed duplicated region for block: B:3067:0x47be  */
    /* JADX WARN: Removed duplicated region for block: B:3076:0x47f3  */
    /* JADX WARN: Removed duplicated region for block: B:3083:0x4815  */
    /* JADX WARN: Removed duplicated region for block: B:3088:0x4821  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:3125:0x0cfe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:3127:0x4184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:3135:0x3801 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:3250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0a69  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0a96  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0aca  */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0ad1  */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0aed  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0b2d  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0b33  */
    /* JADX WARN: Removed duplicated region for block: B:556:0x0b3e  */
    /* JADX WARN: Removed duplicated region for block: B:559:0x0b4d  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x0bfe  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0c17  */
    /* JADX WARN: Removed duplicated region for block: B:622:0x0c1c  */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0c3a  */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0c49  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0ca9  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0cb3  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0ce6  */
    /* JADX WARN: Removed duplicated region for block: B:666:0x0ce8  */
    /* JADX WARN: Removed duplicated region for block: B:695:0x0da0  */
    /* JADX WARN: Removed duplicated region for block: B:698:0x0da7  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x0ea9 A[Catch: Exception -> 0x0ec7, TryCatch #24 {Exception -> 0x0ec7, blocks: (B:746:0x0ea5, B:749:0x0eb0, B:748:0x0ea9, B:743:0x0e98), top: B:3139:0x0ea5 }] */
    /* JADX WARN: Removed duplicated region for block: B:770:0x0f18  */
    /* JADX WARN: Removed duplicated region for block: B:774:0x0f26  */
    /* JADX WARN: Removed duplicated region for block: B:776:0x0f35 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:801:0x0fdc  */
    /* JADX WARN: Removed duplicated region for block: B:803:0x0fe1  */
    /* JADX WARN: Removed duplicated region for block: B:822:0x1046 A[Catch: Exception -> 0x111a, TRY_LEAVE, TryCatch #9 {Exception -> 0x111a, blocks: (B:817:0x1017, B:821:0x1033, B:822:0x1046), top: B:3110:0x100f }] */
    /* JADX WARN: Removed duplicated region for block: B:875:0x1128  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x112e  */
    /* JADX WARN: Removed duplicated region for block: B:886:0x1146  */
    /* JADX WARN: Removed duplicated region for block: B:887:0x114d  */
    /* JADX WARN: Removed duplicated region for block: B:889:0x1151  */
    /* JADX WARN: Type inference failed for: r11v114 */
    /* JADX WARN: Type inference failed for: r11v118 */
    /* JADX WARN: Type inference failed for: r11v71, types: [int] */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r11v86 */
    /* JADX WARN: Type inference failed for: r11v96 */
    /* JADX WARN: Type inference failed for: r11v97 */
    /* JADX WARN: Type inference failed for: r11v98 */
    /* JADX WARN: Type inference failed for: r11v99, types: [int] */
    /* JADX WARN: Type inference failed for: r12v142 */
    /* JADX WARN: Type inference failed for: r12v143 */
    /* JADX WARN: Type inference failed for: r12v308 */
    /* JADX WARN: Type inference failed for: r12v309 */
    /* JADX WARN: Type inference failed for: r12v310 */
    /* JADX WARN: Type inference failed for: r12v311 */
    /* JADX WARN: Type inference failed for: r12v312 */
    /* JADX WARN: Type inference failed for: r12v313 */
    /* JADX WARN: Type inference failed for: r12v314 */
    /* JADX WARN: Type inference failed for: r15v108 */
    /* JADX WARN: Type inference failed for: r15v109 */
    /* JADX WARN: Type inference failed for: r15v110 */
    /* JADX WARN: Type inference failed for: r15v66, types: [int] */
    /* JADX WARN: Type inference failed for: r15v72 */
    /* JADX WARN: Type inference failed for: r15v73 */
    /* JADX WARN: Type inference failed for: r15v74 */
    /* JADX WARN: Type inference failed for: r15v75 */
    /* JADX WARN: Type inference failed for: r15v77, types: [int] */
    /* JADX WARN: Type inference failed for: r15v82, types: [int] */
    /* JADX WARN: Type inference failed for: r15v98 */
    /* JADX WARN: Type inference failed for: r15v99 */
    /* JADX WARN: Type inference failed for: r2v610, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r2v622, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r2v627, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r2v628, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r2v629, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r3v535 */
    /* JADX WARN: Type inference failed for: r3v536 */
    /* JADX WARN: Type inference failed for: r3v539 */
    /* JADX WARN: Type inference failed for: r3v541 */
    /* JADX WARN: Type inference failed for: r3v939, types: [android.text.StaticLayout, ir.eitaa.messenger.WebFile, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v949 */
    /* JADX WARN: Type inference failed for: r4v530, types: [ir.eitaa.messenger.DownloadController] */
    /* JADX WARN: Type inference failed for: r5v471, types: [ir.eitaa.messenger.ImageReceiver] */
    /* JADX WARN: Type inference failed for: r64v0, types: [android.view.View, android.view.ViewGroup, ir.eitaa.messenger.DownloadController$FileDownloadProgressListener, ir.eitaa.ui.explore.cells.KavoshCell] */
    /* JADX WARN: Type inference failed for: r6v169, types: [double] */
    /* JADX WARN: Type inference failed for: r6v17, types: [ir.eitaa.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r6v174, types: [double] */
    /* JADX WARN: Type inference failed for: r6v181, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v183, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v189, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v23, types: [float] */
    /* JADX WARN: Type inference failed for: r6v257, types: [float] */
    /* JADX WARN: Type inference failed for: r6v27, types: [float] */
    /* JADX WARN: Type inference failed for: r6v279, types: [float] */
    /* JADX WARN: Type inference failed for: r6v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v316, types: [float] */
    /* JADX WARN: Type inference failed for: r6v393, types: [int] */
    /* JADX WARN: Type inference failed for: r6v394 */
    /* JADX WARN: Type inference failed for: r6v395, types: [ir.eitaa.messenger.MessageObject] */
    /* JADX WARN: Type inference failed for: r6v398, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v40, types: [android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r6v402, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v403, types: [ir.eitaa.messenger.MessageObject] */
    /* JADX WARN: Type inference failed for: r6v405, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v407, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v409, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v411, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v421, types: [android.text.Layout$Alignment] */
    /* JADX WARN: Type inference failed for: r6v423, types: [android.text.Layout$Alignment] */
    /* JADX WARN: Type inference failed for: r6v425 */
    /* JADX WARN: Type inference failed for: r6v426 */
    /* JADX WARN: Type inference failed for: r6v429, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v430 */
    /* JADX WARN: Type inference failed for: r6v431 */
    /* JADX WARN: Type inference failed for: r6v432 */
    /* JADX WARN: Type inference failed for: r6v433 */
    /* JADX WARN: Type inference failed for: r6v434 */
    /* JADX WARN: Type inference failed for: r6v435 */
    /* JADX WARN: Type inference failed for: r6v436 */
    /* JADX WARN: Type inference failed for: r6v437 */
    /* JADX WARN: Type inference failed for: r6v458, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v50, types: [float] */
    /* JADX WARN: Type inference failed for: r6v538, types: [android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r6v572 */
    /* JADX WARN: Type inference failed for: r6v573 */
    /* JADX WARN: Type inference failed for: r6v574 */
    /* JADX WARN: Type inference failed for: r6v583 */
    /* JADX WARN: Type inference failed for: r6v584 */
    /* JADX WARN: Type inference failed for: r6v585 */
    /* JADX WARN: Type inference failed for: r6v586 */
    /* JADX WARN: Type inference failed for: r6v587 */
    /* JADX WARN: Type inference failed for: r6v672 */
    /* JADX WARN: Type inference failed for: r6v673 */
    /* JADX WARN: Type inference failed for: r6v674 */
    /* JADX WARN: Type inference failed for: r6v675 */
    /* JADX WARN: Type inference failed for: r6v676 */
    /* JADX WARN: Type inference failed for: r6v677 */
    /* JADX WARN: Type inference failed for: r6v678 */
    /* JADX WARN: Type inference failed for: r6v679 */
    /* JADX WARN: Type inference failed for: r6v680 */
    /* JADX WARN: Type inference failed for: r6v681 */
    /* JADX WARN: Type inference failed for: r6v682 */
    /* JADX WARN: Type inference failed for: r6v683 */
    /* JADX WARN: Type inference failed for: r6v684 */
    /* JADX WARN: Type inference failed for: r6v685 */
    /* JADX WARN: Type inference failed for: r6v686 */
    /* JADX WARN: Type inference failed for: r6v79 */
    /* JADX WARN: Type inference failed for: r6v88 */
    /* JADX WARN: Type inference failed for: r6v99 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageContent(ir.eitaa.messenger.MessageObject r65, ir.eitaa.messenger.MessageObject.GroupedMessages r66, boolean r67, boolean r68) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 18470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.setMessageContent(ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject$GroupedMessages, boolean, boolean):void");
    }

    static /* synthetic */ int lambda$setMessageContent$0(PollButton pollButton, PollButton pollButton2) {
        if (pollButton.decimal > pollButton2.decimal) {
            return -1;
        }
        if (pollButton.decimal < pollButton2.decimal) {
            return 1;
        }
        if (pollButton.decimal != pollButton2.decimal) {
            return 0;
        }
        if (pollButton.percent > pollButton2.percent) {
            return 1;
        }
        return pollButton.percent < pollButton2.percent ? -1 : 0;
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
                this.videoPlayerRewinder = new VideoPlayerRewinder() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.4
                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindCanceled() throws InterruptedException, IOException {
                        KavoshCell.this.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        KavoshCell.this.videoForwardDrawable.setShowing(false);
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void updateRewindProgressUi(long timeDiff, float progress, boolean rewindByBackSeek) {
                        KavoshCell.this.videoForwardDrawable.setTime(Math.abs(timeDiff));
                        if (rewindByBackSeek) {
                            KavoshCell kavoshCell = KavoshCell.this;
                            kavoshCell.currentMessageObject.audioProgress = progress;
                            kavoshCell.updatePlayingMessageProgress();
                        }
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindStart(boolean rewindForward) {
                        KavoshCell.this.videoForwardDrawable.setDelegate(new VideoForwardDrawable.VideoForwardDrawableDelegate() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.4.1
                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void onAnimationEnd() {
                            }

                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void invalidate() {
                                KavoshCell.this.invalidate();
                            }
                        });
                        KavoshCell.this.videoForwardDrawable.setOneShootAnimation(false);
                        KavoshCell.this.videoForwardDrawable.setLeftSide(!rewindForward);
                        KavoshCell.this.videoForwardDrawable.setShowing(true);
                        KavoshCell.this.invalidate();
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
        KavoshCellDelegate kavoshCellDelegate = this.delegate;
        if (kavoshCellDelegate != null) {
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
                        zDidLongPressChannelAvatar = kavoshCellDelegate.didLongPressChannelAvatar(this, tLRPC$Chat, i, this.lastTouchX, this.lastTouchY);
                    }
                } else if (tLRPC$User.id != 0) {
                    zDidLongPressChannelAvatar = kavoshCellDelegate.didLongPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
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
        if (messageObject.type == 0) {
            this.documentAttach = messageObject.messageOwner.media.webpage.document;
        } else {
            this.documentAttach = messageObject.getDocument();
        }
        TLRPC$Document tLRPC$Document = this.documentAttach;
        int i = 0;
        if (tLRPC$Document == null) {
            return 0;
        }
        if (MessageObject.isMusicDocument(tLRPC$Document)) {
            this.documentAttachType = 5;
            int iDp = maxWidth - AndroidUtilities.dp(60.0f);
            if (iDp < 0) {
                iDp = AndroidUtilities.dp(100.0f);
            }
            int i2 = iDp;
            StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicTitle().replace('\n', ' '), Theme.chat_audioTitlePaint, i2 - AndroidUtilities.dp(12.0f), TextUtils.TruncateAt.END), Theme.chat_audioTitlePaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.songLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.songX = -((int) Math.ceil(this.songLayout.getLineLeft(0)));
            }
            StaticLayout staticLayout2 = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicAuthor().replace('\n', ' '), Theme.chat_audioPerformerPaint, i2, TextUtils.TruncateAt.END), Theme.chat_audioPerformerPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.performerLayout = staticLayout2;
            if (staticLayout2.getLineCount() > 0) {
                this.performerX = -((int) Math.ceil(this.performerLayout.getLineLeft(0)));
            }
            int i3 = 0;
            while (true) {
                if (i3 >= this.documentAttach.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.documentAttach.attributes.get(i3);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    i = tLRPC$DocumentAttribute.duration;
                    break;
                }
                i3++;
            }
            int iCeil = (int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatShortDuration(i, i)));
            this.widthBeforeNewTimeLine = (this.backgroundWidth - AndroidUtilities.dp(86.0f)) - iCeil;
            this.availableTimeWidth = this.backgroundWidth - AndroidUtilities.dp(28.0f);
            return iCeil;
        }
        if (MessageObject.isVideoDocument(this.documentAttach)) {
            this.documentAttachType = 4;
            if (!messageObject.needDrawBluredPreview()) {
                updatePlayingMessageProgress();
                String str = String.format("%s", AndroidUtilities.formatFileSize(this.documentAttach.size));
                this.docTitleWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(str));
                this.docTitleLayout = new StaticLayout(str, Theme.chat_infoPaint, this.docTitleWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return 0;
        }
        if (MessageObject.isGifDocument(this.documentAttach, messageObject.hasValidGroupId())) {
            this.documentAttachType = 2;
            if (!messageObject.needDrawBluredPreview()) {
                String string = LocaleController.getString("AttachGif", ir.eitaa.messenger.R.string.AttachGif);
                this.infoWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(string));
                this.infoLayout = new StaticLayout(string, Theme.chat_infoPaint, this.infoWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                String str2 = String.format("%s", AndroidUtilities.formatFileSize(this.documentAttach.size));
                this.docTitleWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(str2));
                this.docTitleLayout = new StaticLayout(str2, Theme.chat_infoPaint, this.docTitleWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return 0;
        }
        String str3 = this.documentAttach.mime_type;
        boolean z = (str3 != null && (str3.toLowerCase().startsWith("image/") || this.documentAttach.mime_type.toLowerCase().startsWith("video/mp4"))) || MessageObject.isDocumentHasThumb(this.documentAttach);
        this.drawPhotoImage = z;
        int iDp2 = !z ? maxWidth + AndroidUtilities.dp(30.0f) : maxWidth;
        this.documentAttachType = 1;
        String documentFileName = FileLoader.getDocumentFileName(this.documentAttach);
        if (documentFileName.length() == 0) {
            documentFileName = LocaleController.getString("AttachDocument", ir.eitaa.messenger.R.string.AttachDocument);
        }
        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(documentFileName, Theme.chat_docNamePaint, iDp2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.MIDDLE, iDp2, 2, false);
        this.docTitleLayout = staticLayoutCreateStaticLayout;
        this.docTitleOffsetX = Integer.MIN_VALUE;
        if (staticLayoutCreateStaticLayout != null && staticLayoutCreateStaticLayout.getLineCount() > 0) {
            int iMax = 0;
            while (i < this.docTitleLayout.getLineCount()) {
                iMax = Math.max(iMax, (int) Math.ceil(this.docTitleLayout.getLineWidth(i)));
                this.docTitleOffsetX = Math.max(this.docTitleOffsetX, (int) Math.ceil(-this.docTitleLayout.getLineLeft(i)));
                i++;
            }
            iMin = Math.min(iDp2, iMax);
        } else {
            this.docTitleOffsetX = 0;
            iMin = iDp2;
        }
        String str4 = AndroidUtilities.formatFileSize(this.documentAttach.size) + " " + FileLoader.getDocumentExtension(this.documentAttach);
        int iDp3 = iDp2 - AndroidUtilities.dp(30.0f);
        TextPaint textPaint = Theme.chat_infoPaint;
        int iMin2 = Math.min(iDp3, (int) Math.ceil(textPaint.measureText("000.0 mm / " + AndroidUtilities.formatFileSize(this.documentAttach.size))));
        this.infoWidth = iMin2;
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(str4, Theme.chat_infoPaint, (float) iMin2, TextUtils.TruncateAt.END);
        try {
            if (this.infoWidth < 0) {
                this.infoWidth = AndroidUtilities.dp(10.0f);
            }
            this.infoLayout = new StaticLayout(charSequenceEllipsize, Theme.chat_infoPaint, this.infoWidth + AndroidUtilities.dp(6.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
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

    private void calcBackgroundWidth(int maxWidth, int timeMore, int maxChildWidth) {
        if (!this.hasLinkPreview && !this.hasOldCaptionPreview && !this.hasGamePreview && !this.hasInvoicePreview) {
            MessageObject messageObject = this.currentMessageObject;
            if (maxWidth - messageObject.lastLineWidth >= timeMore && !messageObject.hasRtl) {
                int extraTextX = maxChildWidth - getExtraTextX();
                int i = this.currentMessageObject.lastLineWidth;
                int i2 = extraTextX - i;
                if (i2 >= 0 && i2 <= timeMore) {
                    this.backgroundWidth = ((maxChildWidth + timeMore) - i2) + AndroidUtilities.dp(31.0f);
                    return;
                } else {
                    this.backgroundWidth = Math.max(maxChildWidth, i + timeMore) + AndroidUtilities.dp(31.0f);
                    return;
                }
            }
        }
        this.totalHeight += AndroidUtilities.dp(14.0f);
        this.hasNewLineForTime = true;
        int iMax = Math.max(maxChildWidth, this.currentMessageObject.lastLineWidth) + AndroidUtilities.dp(31.0f);
        this.backgroundWidth = iMax;
        this.backgroundWidth = Math.max(iMax, (this.currentMessageObject.isOutOwner() ? this.timeWidth + AndroidUtilities.dp(17.0f) : this.timeWidth) + AndroidUtilities.dp(31.0f));
    }

    public void setHighlightedText(String text) {
        MessageObject messageObject = this.messageObjectToSet;
        if (messageObject == null) {
            messageObject = this.currentMessageObject;
        }
        if (messageObject == null || messageObject.messageOwner.message == null || TextUtils.isEmpty(text)) {
            if (this.urlPathSelection.isEmpty()) {
                return;
            }
            this.linkSelectionBlockNum = -1;
            resetUrlPaths(true);
            invalidate();
            return;
        }
        String lowerCase = text.toLowerCase();
        String lowerCase2 = messageObject.messageOwner.message.toLowerCase();
        int length = lowerCase2.length();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            int iMin = Math.min(lowerCase.length(), length - i3);
            int i4 = 0;
            for (int i5 = 0; i5 < iMin; i5++) {
                boolean z = lowerCase2.charAt(i3 + i5) == lowerCase.charAt(i5);
                if (z) {
                    if (i4 != 0 || i3 == 0 || " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n".indexOf(lowerCase2.charAt(i3 - 1)) >= 0) {
                        i4++;
                    } else {
                        z = false;
                    }
                }
                if (!z || i5 == iMin - 1) {
                    if (i4 > 0 && i4 > i2) {
                        i = i3;
                        i2 = i4;
                    }
                }
            }
        }
        if (i == -1) {
            if (this.urlPathSelection.isEmpty()) {
                return;
            }
            this.linkSelectionBlockNum = -1;
            resetUrlPaths(true);
            invalidate();
            return;
        }
        int length2 = lowerCase2.length();
        for (int i6 = i + i2; i6 < length2 && " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n".indexOf(lowerCase2.charAt(i6)) < 0; i6++) {
            i2++;
        }
        int i7 = i + i2;
        if (this.captionLayout != null && !TextUtils.isEmpty(messageObject.caption)) {
            resetUrlPaths(true);
            try {
                LinkPath linkPathObtainNewUrlPath = obtainNewUrlPath(true);
                linkPathObtainNewUrlPath.setCurrentLayout(this.captionLayout, i, 0.0f);
                this.captionLayout.getSelectionPath(i, i7, linkPathObtainNewUrlPath);
            } catch (Exception e) {
                FileLog.e(e);
            }
            invalidate();
            return;
        }
        if (messageObject.textLayoutBlocks != null) {
            for (int i8 = 0; i8 < messageObject.textLayoutBlocks.size(); i8++) {
                MessageObject.TextLayoutBlock textLayoutBlock = messageObject.textLayoutBlocks.get(i8);
                if (i >= textLayoutBlock.charactersOffset && i < textLayoutBlock.charactersEnd) {
                    this.linkSelectionBlockNum = i8;
                    resetUrlPaths(true);
                    try {
                        LinkPath linkPathObtainNewUrlPath2 = obtainNewUrlPath(true);
                        linkPathObtainNewUrlPath2.setCurrentLayout(textLayoutBlock.textLayout, i, 0.0f);
                        textLayoutBlock.textLayout.getSelectionPath(i, i7, linkPathObtainNewUrlPath2);
                        if (i7 >= textLayoutBlock.charactersOffset + i2) {
                            for (int i9 = i8 + 1; i9 < messageObject.textLayoutBlocks.size(); i9++) {
                                MessageObject.TextLayoutBlock textLayoutBlock2 = messageObject.textLayoutBlocks.get(i9);
                                int i10 = textLayoutBlock2.charactersEnd - textLayoutBlock2.charactersOffset;
                                LinkPath linkPathObtainNewUrlPath3 = obtainNewUrlPath(true);
                                linkPathObtainNewUrlPath3.setCurrentLayout(textLayoutBlock2.textLayout, 0, textLayoutBlock2.height);
                                textLayoutBlock2.textLayout.getSelectionPath(0, i7 - textLayoutBlock2.charactersOffset, linkPathObtainNewUrlPath3);
                                if (i7 < (textLayoutBlock.charactersOffset + i10) - 1) {
                                    break;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    invalidate();
                    return;
                }
            }
        }
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
    public void checkLocationExpired() throws Resources.NotFoundException {
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

    public void setMessageObject(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, boolean bottomNear, boolean topNear) throws Resources.NotFoundException {
        if (messageObject.type == 3) {
            creatVideoPlayerViews();
            createVolumeButton();
        }
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
            Drawable drawable = new Drawable() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.5
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

                /* JADX WARN: Removed duplicated region for block: B:35:0x00d1  */
                @Override // android.graphics.drawable.Drawable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void draw(android.graphics.Canvas r13) {
                    /*
                        Method dump skipped, instructions count: 341
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.AnonymousClass5.draw(android.graphics.Canvas):void");
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Resources.NotFoundException {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && (messageObject.checkLayout() || this.lastHeight != AndroidUtilities.displaySize.y)) {
            this.inLayout = true;
            MessageObject messageObject2 = this.currentMessageObject;
            this.currentMessageObject = null;
            setMessageObject(messageObject2, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
            this.inLayout = false;
        }
        updateSelectionTextPosition();
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.totalHeight + this.keyboardHeight);
        this.menuButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
        this.forwardButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
        this.viewsLayout2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 0), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 0));
        if (this.currentMessageObject.type == 3) {
            this.videoPlayerContainer.measure(View.MeasureSpec.makeMeasureSpec(1000, 1073741824), View.MeasureSpec.makeMeasureSpec(1000, 1073741824));
            this.volumeButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(32.0f), 1073741824));
        }
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
        if (!this.currentMessageObject.isOutOwner() && this.isPlayingRound && this.currentMessageObject.type == 5) {
            return (int) ((AndroidUtilities.roundPlayingMessageSize - AndroidUtilities.roundMessageSize) * 0.7f);
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int i;
        int iCeil;
        int i2;
        int iDp;
        int iDp2;
        int iDp3;
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
            this.timeLayout = new StaticLayout(this.currentTimeString, Theme.chat_timePaint, AndroidUtilities.dp(100.0f) + this.timeTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (this.mediaBackground) {
                int iDp4 = (this.backgroundWidth - AndroidUtilities.dp(4.0f)) - this.timeWidth;
                this.timeX = iDp4;
                if (SharedConfig.bubbleRadius >= 10 && this.captionLayout == null && (i = this.documentAttachType) != 7 && i != 6) {
                    this.timeX = iDp4 - AndroidUtilities.dp(2.0f);
                }
            } else {
                this.timeX = (getParentWidth() - AndroidUtilities.dp(9.0f)) - this.timeWidth;
                if (this.currentMessageObject.isAnyKindOfSticker()) {
                    this.timeX = Math.max(0, this.timeX);
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
            this.wasLayout = true;
        }
        this.lastSize = measuredHeight;
        if (this.isRoundVideo) {
            updatePlayingMessageProgress();
        }
        int i3 = this.documentAttachType;
        if (i3 == 3) {
            if (this.currentMessageObject.isOutOwner()) {
                this.seekBarX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(57.0f);
                this.buttonX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
                this.timeAudioX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(67.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
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
            int iDp5 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp5;
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i4 = this.buttonX;
            radialProgress2.setProgressRect(i4, iDp5, AndroidUtilities.dp(44.0f) + i4, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i3 == 5) {
            float f = 50;
            this.seekBarX = AndroidUtilities.dp(f);
            this.buttonX = AndroidUtilities.dp(8);
            this.timeAudioX = AndroidUtilities.dp(61);
            this.seekBar.setSize(this.backgroundWidth - AndroidUtilities.dp(f), AndroidUtilities.dp(30.0f));
            this.seekBarY = AndroidUtilities.dp(29.0f) + this.namesOffset + this.mediaOffsetY;
            int iDp6 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp6;
            RadialProgress2 radialProgress22 = this.radialProgress;
            int i5 = this.buttonX;
            radialProgress22.setProgressRect(i5, iDp6, AndroidUtilities.dp(44.0f) + i5, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i3 == 1 && !this.drawPhotoImage) {
            int iDp7 = AndroidUtilities.dp(16.0f);
            this.buttonX = iDp7;
            if (this.hasLinkPreview) {
                this.buttonX = iDp7 + AndroidUtilities.dp(10.0f);
            }
            int iDp8 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp8;
            RadialProgress2 radialProgress23 = this.radialProgress;
            int i6 = this.buttonX;
            radialProgress23.setProgressRect(i6, iDp8, AndroidUtilities.dp(44.0f) + i6, this.buttonY + AndroidUtilities.dp(44.0f));
            this.photoImage.setImageCoords(this.buttonX - AndroidUtilities.dp(10.0f), this.buttonY - AndroidUtilities.dp(10.0f), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        int i7 = messageObject.type;
        if (i7 == 12) {
            if (messageObject.isOutOwner()) {
                iDp3 = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                iDp3 = AndroidUtilities.dp(72.0f);
            } else {
                iDp3 = AndroidUtilities.dp(23.0f);
            }
            this.photoImage.setImageCoords(iDp3, AndroidUtilities.dp(13.0f) + this.namesOffset, AndroidUtilities.dp(44.0f), AndroidUtilities.dp(44.0f));
            return;
        }
        if (i7 == 0 && (this.hasLinkPreview || this.hasGamePreview || this.hasInvoicePreview)) {
            if (this.hasGamePreview) {
                iDp2 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    i2 = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                } else {
                    i2 = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                }
                iDp2 = i2 + iDp;
            }
            if (this.isSmallImage) {
                iCeil = (iDp2 + this.backgroundWidth) - AndroidUtilities.dp(81.0f);
            } else {
                iCeil = iDp2 + (this.hasInvoicePreview ? -AndroidUtilities.dp(6.3f) : AndroidUtilities.dp(10.0f));
            }
        } else {
            iCeil = 0;
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if (groupedMessagePosition != null) {
            if ((groupedMessagePosition.flags & 1) == 0) {
                iCeil -= AndroidUtilities.dp(2.0f);
            }
            if (this.currentPosition.leftSpanOffset != 0) {
                iCeil += (int) Math.ceil((r2 / 1000.0f) * getGroupPhotosWidth());
            }
        }
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.imageChangeBoundsTransition || transitionParams.updatePhotoImageX) {
            transitionParams.updatePhotoImageX = false;
            ImageReceiver imageReceiver = this.photoImage;
            imageReceiver.setImageCoords(iCeil, imageReceiver.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
        }
        this.buttonX = (int) (iCeil + ((this.photoImage.getImageWidth() - AndroidUtilities.dp(48.0f)) / 2.0f));
        int imageY = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - AndroidUtilities.dp(48.0f)) / 2.0f));
        this.buttonY = imageY;
        RadialProgress2 radialProgress24 = this.radialProgress;
        int i8 = this.buttonX;
        radialProgress24.setProgressRect(i8, imageY, AndroidUtilities.dp(48.0f) + i8, this.buttonY + AndroidUtilities.dp(48.0f));
        this.deleteProgressRect.set(this.buttonX + AndroidUtilities.dp(5.0f), this.buttonY + AndroidUtilities.dp(5.0f), this.buttonX + AndroidUtilities.dp(43.0f), this.buttonY + AndroidUtilities.dp(43.0f));
        int i9 = this.documentAttachType;
        if (i9 == 4 || i9 == 2) {
            this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
            int imageY2 = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
            this.videoButtonY = imageY2;
            RadialProgress2 radialProgress25 = this.videoRadialProgress;
            int i10 = this.videoButtonX;
            radialProgress25.setProgressRect(i10, imageY2, AndroidUtilities.dp(24.0f) + i10, this.videoButtonY + AndroidUtilities.dp(24.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawRoundProgress(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawRoundProgress(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updatePollAnimations(long r9) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.updatePollAnimations(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:320:0x0765  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawContent(android.graphics.Canvas r31) {
        /*
            Method dump skipped, instructions count: 3862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawContent(android.graphics.Canvas):void");
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
                    KavoshCellDelegate kavoshCellDelegate = this.delegate;
                    if (kavoshCellDelegate == null || kavoshCellDelegate.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
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
                    KavoshCellDelegate kavoshCellDelegate2 = this.delegate;
                    if (kavoshCellDelegate2 == null || kavoshCellDelegate2.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
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
                radialProgress23.setProgressRect(i16, imageY4, AndroidUtilities.dp(24.0f) + i16, this.videoButtonY + AndroidUtilities.dp(24.0f));
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
                                BotButton.access$2816(botButton2, (360 * j) / 2000.0f);
                                BotButton.access$2820(botButton2, (botButton2.angle / 360) * 360);
                                if (z2) {
                                    if (botButton2.progressAlpha < 1.0f) {
                                        BotButton.access$2716(botButton2, j / 200.0f);
                                        if (botButton2.progressAlpha > 1.0f) {
                                            botButton2.progressAlpha = 1.0f;
                                        }
                                    }
                                } else if (botButton2.progressAlpha > 0.0f) {
                                    BotButton.access$2724(botButton2, j / 200.0f);
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
    /* JADX WARN: Removed duplicated region for block: B:54:0x0149 A[LOOP:1: B:52:0x0141->B:54:0x0149, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170 A[LOOP:2: B:61:0x0168->B:63:0x0170, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawMessageText(android.graphics.Canvas r18, java.util.ArrayList<ir.eitaa.messenger.MessageObject.TextLayoutBlock> r19, boolean r20, float r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawMessageText(android.graphics.Canvas, java.util.ArrayList, boolean, float, boolean):void");
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
                this.captionY = (((this.totalHeight - this.captionHeight) - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f)) - this.linkPreviewHeight) - AndroidUtilities.dp(17.0f);
            } else {
                this.captionX = this.backgroundDrawableLeft + AndroidUtilities.dp(11.0f) + this.captionOffsetX;
                this.captionY = (this.totalHeight - this.captionHeight) - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f);
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

    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getMaxNameWidth() {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.getMaxNameWidth():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateButtonState(boolean r17, boolean r18, boolean r19) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.updateButtonState(boolean, boolean, boolean):void");
    }

    private void updateVideoViews() throws Resources.NotFoundException {
        if (this.documentAttachType == 4) {
            Resources resources = getContext().getResources();
            boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
            int i = ir.eitaa.messenger.R.drawable.ic_volume_off;
            if (zIsPlayingMessage && SharedConfig.shouldPlayWithSound) {
                i = ir.eitaa.messenger.R.drawable.ic_volume_on;
            }
            Drawable drawable = resources.getDrawable(i);
            ImageView imageView = this.volumeButton;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
                this.volumeButton.setVisibility((this.documentAttachType == 4 && this.buttonState == 3) ? 0 : 4);
            }
            FrameLayout frameLayout = this.videoPlayerContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(MediaController.getInstance().isPlayingMessage(this.currentMessageObject) ? 0 : 4);
            }
        }
    }

    private void didPressMiniButton(boolean animated) throws InterruptedException, IOException {
        int i = this.miniButtonState;
        if (i != 0) {
            if (i == 1) {
                int i2 = this.documentAttachType;
                if ((i2 == 3 || i2 == 5) && MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                    MediaController.getInstance().cleanupPlayer(true, true);
                }
                this.miniButtonState = 0;
                this.currentMessageObject.loadingCancelled = true;
                FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.documentAttach);
                this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
                invalidate();
                return;
            }
            return;
        }
        this.miniButtonState = 1;
        this.radialProgress.setProgress(0.0f, false);
        int i3 = this.documentAttachType;
        if (i3 == 3 || i3 == 5) {
            FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 1, 0);
            this.currentMessageObject.loadingCancelled = false;
        } else if (i3 == 4) {
            createLoadingProgressLayout(this.documentAttach);
            FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
            TLRPC$Document tLRPC$Document = this.documentAttach;
            MessageObject messageObject = this.currentMessageObject;
            fileLoader.loadFile(tLRPC$Document, messageObject, 1, messageObject.shouldEncryptPhotoOrVideo() ? 2 : 0);
            this.currentMessageObject.loadingCancelled = false;
        }
        this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
        invalidate();
    }

    private void didPressButton(boolean animated, boolean video) {
        MessageObject playingMessageObject;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        String str;
        int i = this.buttonState;
        if (i == 0 && (!this.drawVideoImageButton || video)) {
            int i2 = this.documentAttachType;
            if (i2 == 3 || i2 == 5) {
                if (this.miniButtonState == 0) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 1, 0);
                    this.currentMessageObject.loadingCancelled = false;
                }
                String fileName = this.currentMessageObject.getFileName();
                final SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("media_saved_pos", 0);
                float f = sharedPreferences.getFloat(fileName, -1.0f);
                sharedPreferences.edit().putBoolean("canResumeAudio", false).commit();
                final Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$JYZDivRZBm0kUXDGOoPfEgFGlJo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didPressButton$1$KavoshCell();
                    }
                };
                if (MediaController.getInstance().getPlayingMessageObject() == null) {
                    if (f > 0.0f) {
                        final SharedPreferences sharedPreferences2 = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                        try {
                            int i3 = sharedPreferences2.getInt("playerResumeOption", 0);
                            if (i3 == 0) {
                                final boolean[] zArr = new boolean[1];
                                final CheckBoxCell checkBoxCell = new CheckBoxCell(getContext(), 2);
                                checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                                checkBoxCell.setText(LocaleController.getString("UseByDefault", ir.eitaa.messenger.R.string.UseByDefault), "", false, false);
                                checkBoxCell.setTextColor(-16777216);
                                checkBoxCell.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                                checkBoxCell.setLayoutParams(LayoutHelper.createLinear(-1, 48, 51, 0, 0, 0, 0));
                                checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$vaX2WSJWZm1iX9t8lKyOgcetgJc
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        KavoshCell.lambda$didPressButton$3(zArr, checkBoxCell, view);
                                    }
                                });
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setView(checkBoxCell);
                                builder.setTitle(fileName);
                                builder.setPositiveButton(LocaleController.getString("Resume", ir.eitaa.messenger.R.string.Resume), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.8
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (zArr[0]) {
                                            sharedPreferences2.edit().putInt("playerResumeOption", 1).apply();
                                        }
                                        sharedPreferences.edit().putBoolean("canResumeAudio", true).commit();
                                        dialog.dismiss();
                                        runnable.run();
                                    }
                                });
                                builder.setNegativeButton(LocaleController.getString("StartOver", ir.eitaa.messenger.R.string.StartOver), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.9
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (zArr[0]) {
                                            sharedPreferences2.edit().putInt("playerResumeOption", 2).apply();
                                        }
                                        dialog.dismiss();
                                        runnable.run();
                                    }
                                });
                                builder.setMessage(LocaleController.getString("VideoPlayResume", ir.eitaa.messenger.R.string.VideoPlayResume));
                                builder.show();
                                return;
                            }
                            if (i3 == 1) {
                                sharedPreferences.edit().putBoolean("canResumeAudio", true).commit();
                            }
                            runnable.run();
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    runnable.run();
                    return;
                }
                if (f > 0.0f && !this.currentMessageObject.equals(MediaController.getInstance().getPlayingMessageObject())) {
                    final SharedPreferences sharedPreferences3 = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                    try {
                        int i4 = sharedPreferences3.getInt("playerResumeOption", 0);
                        if (i4 == 0) {
                            final boolean[] zArr2 = new boolean[1];
                            final CheckBoxCell checkBoxCell2 = new CheckBoxCell(getContext(), 2);
                            checkBoxCell2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                            checkBoxCell2.setText(LocaleController.getString("UseByDefault", ir.eitaa.messenger.R.string.UseByDefault), "", false, false);
                            checkBoxCell2.setTextColor(-16777216);
                            checkBoxCell2.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                            checkBoxCell2.setLayoutParams(LayoutHelper.createLinear(-1, 48, 51, 0, 0, 0, 0));
                            checkBoxCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$l8RhiVLPakvBuEqVoyJMt7seOPo
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    KavoshCell.lambda$didPressButton$2(zArr2, checkBoxCell2, view);
                                }
                            });
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                            builder2.setView(checkBoxCell2);
                            builder2.setTitle(fileName);
                            builder2.setPositiveButton(LocaleController.getString("Resume", ir.eitaa.messenger.R.string.Resume), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.6
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    if (zArr2[0]) {
                                        sharedPreferences3.edit().putInt("playerResumeOption", 1).apply();
                                    }
                                    sharedPreferences.edit().putBoolean("canResumeAudio", true).commit();
                                    dialog.dismiss();
                                    runnable.run();
                                }
                            });
                            builder2.setNegativeButton(LocaleController.getString("StartOver", ir.eitaa.messenger.R.string.StartOver), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.7
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    if (zArr2[0]) {
                                        sharedPreferences3.edit().putInt("playerResumeOption", 2).apply();
                                    }
                                    dialog.dismiss();
                                    runnable.run();
                                }
                            });
                            builder2.setMessage(LocaleController.getString("VideoPlayResume", ir.eitaa.messenger.R.string.VideoPlayResume));
                            builder2.show();
                            return;
                        }
                        if (i4 == 1) {
                            sharedPreferences.edit().putBoolean("canResumeAudio", true).commit();
                        }
                        runnable.run();
                        return;
                    } catch (Exception e2) {
                        FileLog.e(e2);
                        return;
                    }
                }
                runnable.run();
                return;
            }
            if (video) {
                this.videoRadialProgress.setProgress(0.0f, false);
            } else {
                this.radialProgress.setProgress(0.0f, false);
            }
            if (this.currentPhotoObject != null && (this.photoImage.hasNotThumb() || this.currentPhotoObjectThumb == null)) {
                tLRPC$PhotoSize = this.currentPhotoObject;
                str = ((tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) || "s".equals(tLRPC$PhotoSize.type)) ? this.currentPhotoFilterThumb : this.currentPhotoFilter;
            } else {
                tLRPC$PhotoSize = this.currentPhotoObjectThumb;
                str = this.currentPhotoFilterThumb;
            }
            String str2 = str;
            MessageObject messageObject = this.currentMessageObject;
            int i5 = messageObject.type;
            if (i5 == 1) {
                this.photoImage.setForceLoading(true);
                ImageReceiver imageReceiver = this.photoImage;
                ImageLocation forObject = ImageLocation.getForObject(this.currentPhotoObject, this.photoParentObject);
                String str3 = this.currentPhotoFilter;
                ImageLocation forObject2 = ImageLocation.getForObject(this.currentPhotoObjectThumb, this.photoParentObject);
                String str4 = this.currentPhotoFilterThumb;
                int i6 = this.currentPhotoObject.size;
                MessageObject messageObject2 = this.currentMessageObject;
                imageReceiver.setImage(forObject, str3, forObject2, str4, i6, null, messageObject2, messageObject2.shouldEncryptPhotoOrVideo() ? 2 : 0);
            } else if (i5 == 8) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 1, 0);
                if (this.currentMessageObject.loadedFileSize > 0) {
                    createLoadingProgressLayout(this.documentAttach);
                }
            } else if (this.isRoundVideo) {
                if (messageObject.isSecretMedia()) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.currentMessageObject.getDocument(), this.currentMessageObject, 1, 1);
                } else {
                    MessageObject messageObject3 = this.currentMessageObject;
                    messageObject3.gifState = 2.0f;
                    TLRPC$Document document = messageObject3.getDocument();
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForDocument(document), null, ImageLocation.getForObject(tLRPC$PhotoSize, document), str2, document.size, null, this.currentMessageObject, 0);
                }
            } else if (i5 == 9) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 1, 0);
                if (this.currentMessageObject.loadedFileSize > 0) {
                    createLoadingProgressLayout(this.documentAttach);
                }
            } else {
                int i7 = this.documentAttachType;
                if (i7 == 4) {
                    FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
                    TLRPC$Document tLRPC$Document = this.documentAttach;
                    MessageObject messageObject4 = this.currentMessageObject;
                    fileLoader.loadFile(tLRPC$Document, messageObject4, 1, messageObject4.shouldEncryptPhotoOrVideo() ? 2 : 0);
                    MessageObject messageObject5 = this.currentMessageObject;
                    if (messageObject5.loadedFileSize > 0) {
                        createLoadingProgressLayout(messageObject5.getDocument());
                    }
                } else if (i5 != 0 || i7 == 0) {
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForObject(this.currentPhotoObject, this.photoParentObject), this.currentPhotoFilter, ImageLocation.getForObject(this.currentPhotoObjectThumb, this.photoParentObject), this.currentPhotoFilterThumb, 0, null, this.currentMessageObject, 0);
                } else if (i7 == 2) {
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForDocument(this.documentAttach), null, ImageLocation.getForDocument(this.currentPhotoObject, this.documentAttach), this.currentPhotoFilterThumb, this.documentAttach.size, null, this.currentMessageObject, 0);
                    MessageObject messageObject6 = this.currentMessageObject;
                    messageObject6.gifState = 2.0f;
                    if (messageObject6.loadedFileSize > 0) {
                        createLoadingProgressLayout(messageObject6.getDocument());
                    }
                } else if (i7 == 1) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 0, 0);
                } else if (i7 == 8) {
                    this.photoImage.setImage(ImageLocation.getForDocument(this.documentAttach), this.currentPhotoFilter, ImageLocation.getForDocument(this.currentPhotoObject, this.documentAttach), "b1", 0, "jpg", this.currentMessageObject, 1);
                }
            }
            this.currentMessageObject.loadingCancelled = false;
            this.buttonState = 1;
            if (video) {
                this.videoRadialProgress.setIcon(14, false, animated);
            } else {
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            }
            invalidate();
            return;
        }
        if (i == 1 && (!this.drawVideoImageButton || video)) {
            this.photoImage.setForceLoading(false);
            int i8 = this.documentAttachType;
            if (i8 == 3 || i8 == 5) {
                if (MediaController.getInstance().lambda$startAudioAgain$7$MediaController(this.currentMessageObject)) {
                    this.buttonState = 0;
                    this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                    invalidate();
                    return;
                }
                return;
            }
            if (this.currentMessageObject.isOut() && !this.drawVideoImageButton && (this.currentMessageObject.isSending() || this.currentMessageObject.isEditing())) {
                if (this.radialProgress.getIcon() != 6) {
                    this.delegate.didPressCancelSendButton(this);
                    return;
                }
                return;
            }
            MessageObject messageObject7 = this.currentMessageObject;
            messageObject7.loadingCancelled = true;
            int i9 = this.documentAttachType;
            if (i9 == 2 || i9 == 4 || i9 == 1 || i9 == 8) {
                FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.documentAttach);
            } else {
                int i10 = messageObject7.type;
                if (i10 == 0 || i10 == 1 || i10 == 8 || i10 == 5) {
                    ImageLoader.getInstance().cancelForceLoadingForImageReceiver(this.photoImage);
                    this.photoImage.cancelLoadImage();
                } else if (i10 == 9) {
                    FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.currentMessageObject.getDocument());
                }
            }
            this.buttonState = 0;
            if (video) {
                this.videoRadialProgress.setIcon(2, false, animated);
            } else {
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            }
            invalidate();
            return;
        }
        if (i == 2) {
            int i11 = this.documentAttachType;
            if (i11 == 3 || i11 == 5) {
                this.radialProgress.setProgress(0.0f, false);
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 1, 0);
                this.currentMessageObject.loadingCancelled = false;
                this.buttonState = 4;
                this.radialProgress.setIcon(getIconForCurrentState(), true, animated);
                invalidate();
                return;
            }
            if (!this.isRoundVideo || (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) == null || !playingMessageObject.isRoundVideo()) {
                this.photoImage.setAllowStartAnimation(true);
                this.photoImage.startAnimation();
            }
            this.currentMessageObject.gifState = 0.0f;
            this.buttonState = -1;
            this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
            return;
        }
        if (i == 3 || i == 0) {
            if (this.hasMiniProgress == 2 && this.miniButtonState != 1) {
                this.miniButtonState = 1;
                this.radialProgress.setProgress(0.0f, false);
                this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, animated);
            }
            this.delegate.didPressImage(this, 0.0f, 0.0f);
            return;
        }
        if (i == 4) {
            int i12 = this.documentAttachType;
            if (i12 == 3 || i12 == 5) {
                if ((this.currentMessageObject.isOut() && (this.currentMessageObject.isSending() || this.currentMessageObject.isEditing())) || this.currentMessageObject.isSendError()) {
                    if (this.delegate == null || this.radialProgress.getIcon() == 6) {
                        return;
                    }
                    this.delegate.didPressCancelSendButton(this);
                    return;
                }
                this.currentMessageObject.loadingCancelled = true;
                FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.documentAttach);
                this.buttonState = 2;
                this.radialProgress.setIcon(getIconForCurrentState(), false, animated);
                invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didPressButton$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didPressButton$1$KavoshCell() {
        if (this.delegate.needPlayMessage(this.currentMessageObject)) {
            if (this.hasMiniProgress == 2 && this.miniButtonState != 1) {
                this.miniButtonState = 1;
                this.radialProgress.setProgress(0.0f, false);
                this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
            }
            updatePlayingMessageProgress();
            this.buttonState = 1;
            this.radialProgress.setIcon(getIconForCurrentState(), false, true);
            invalidate();
        }
    }

    static /* synthetic */ void lambda$didPressButton$2(boolean[] zArr, CheckBoxCell checkBoxCell, View view) {
        zArr[0] = !zArr[0];
        checkBoxCell.setChecked(zArr[0], true);
    }

    static /* synthetic */ void lambda$didPressButton$3(boolean[] zArr, CheckBoxCell checkBoxCell, View view) {
        zArr[0] = !zArr[0];
        checkBoxCell.setChecked(zArr[0], true);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) throws Resources.NotFoundException {
        int i = this.documentAttachType;
        updateButtonState(true, i == 3 || i == 5, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0126  */
    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSuccessDownload(java.lang.String r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.onSuccessDownload(java.lang.String):void");
    }

    @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
    public void didSetImage(ImageReceiver imageReceiver, boolean set, boolean thumb, boolean memCache) throws Resources.NotFoundException {
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
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) throws Resources.NotFoundException {
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
                    return;
                }
                return;
            } else {
                if (this.buttonState != 4) {
                    updateButtonState(false, false, false);
                    return;
                }
                return;
            }
        }
        if (this.hasMiniProgress != 0) {
            if (this.miniButtonState != 1) {
                updateButtonState(false, false, false);
            }
        } else if (this.buttonState != 1) {
            updateButtonState(false, false, false);
        }
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.createLoadingProgressLayout(long, long):void");
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

    public void setDelegate(KavoshCellDelegate chatMessageCellDelegate) {
        this.delegate = chatMessageCellDelegate;
    }

    public KavoshCellDelegate getDelegate() {
        return this.delegate;
    }

    public void setAllowAssistant(boolean value) {
        this.allowAssistant = value;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void measureTime(ir.eitaa.messenger.MessageObject r18) {
        /*
            Method dump skipped, instructions count: 853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.measureTime(ir.eitaa.messenger.MessageObject):void");
    }

    public void updateViewsLayout(int views) {
        MessageObject messageObject = this.currentMessageObject;
        messageObject.messageOwner.views = views;
        measureTime(messageObject);
        this.viewsLayout2.setText(this.currentViewsString);
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
        this.currentChat = messagesController.getChat(Long.valueOf(this.currentMessageObject.messageOwner.peer_id.channel_id));
        if (tLRPC$MessageFwdHeader != null && (tLRPC$MessageFwdHeader.from_id instanceof TLRPC$TL_peerChannel) && this.currentMessageObject.getDialogId() == clientUserId) {
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
                    return;
                }
                return;
            }
            if (tLRPC$Peer.chat_id != 0) {
                TLRPC$Peer tLRPC$Peer4 = tLRPC$MessageFwdHeader.from_id;
                if (tLRPC$Peer4 instanceof TLRPC$TL_peerUser) {
                    this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$Peer4.user_id));
                    return;
                }
                return;
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
        } else {
            if (DialogObject.isChatDialog(fromChatId)) {
                return;
            }
            boolean z = this.currentMessageObject.messageOwner.post;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:235|(2:239|(1:241))|242|(1:244)(2:245|(1:247))|248|(6:(9:254|(3:256|(3:258|(1:260)(1:261)|262)(1:263)|264)(1:265)|(1:267)|(1:285)(3:280|(1:282)(1:283)|284)|286|(2:289|(2:291|(1:293)(1:302))(2:294|(2:296|(1:298)(0))(2:299|(1:301)(0))))|(1:304)|305|(1:307)(2:308|(1:310)(2:311|(3:313|(1:315)(1:316)|317)(2:318|(1:327)(3:322|(1:324)(1:325)|326)))))(6:329|(1:331)(2:332|(1:334)(2:335|(1:337)))|338|(1:340)|341|(7:349|(1:(1:352)(1:353))(1:(1:355)(1:356))|357|(1:359)(1:360)|361|(1:367)|368)(14:348|(1:371)|372|403|373|(1:375)(1:376)|377|(2:379|(1:381))|385|407|386|(1:388)(1:389)|390|(2:392|(1:394))))|407|386|(0)(0)|390|(0))|328|(0)|372|403|373|(0)(0)|377|(0)|385) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:44|(1:46)|47|(1:56)(16:53|(1:55)|64|(1:83)(1:84)|85|(1:87)(1:88)|89|(8:91|(1:93)|94|(1:96)(3:98|(1:100)(1:101)|102)|97|103|(1:105)(1:106)|107)(1:108)|109|402|110|(3:112|(1:114)|115)(1:116)|(1:118)(1:119)|123|(1:125)|126)|57|(2:65|(14:81|(0)(0)|85|(0)(0)|89|(0)(0)|109|402|110|(0)(0)|(0)(0)|123|(0)|126)(3:77|(1:79)|80))(1:63)|64|(0)(0)|85|(0)(0)|89|(0)(0)|109|402|110|(0)(0)|(0)(0)|123|(0)|126) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x03bb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03bc, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0b5a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0b5b, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0358 A[Catch: Exception -> 0x03bb, TryCatch #1 {Exception -> 0x03bb, blocks: (B:110:0x0335, B:112:0x0358, B:114:0x036d, B:115:0x0378, B:118:0x0387, B:119:0x03b7, B:116:0x0382), top: B:402:0x0335 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0382 A[Catch: Exception -> 0x03bb, TryCatch #1 {Exception -> 0x03bb, blocks: (B:110:0x0335, B:112:0x0358, B:114:0x036d, B:115:0x0378, B:118:0x0387, B:119:0x03b7, B:116:0x0382), top: B:402:0x0335 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0387 A[Catch: Exception -> 0x03bb, TryCatch #1 {Exception -> 0x03bb, blocks: (B:110:0x0335, B:112:0x0358, B:114:0x036d, B:115:0x0378, B:118:0x0387, B:119:0x03b7, B:116:0x0382), top: B:402:0x0335 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b7 A[Catch: Exception -> 0x03bb, TRY_LEAVE, TryCatch #1 {Exception -> 0x03bb, blocks: (B:110:0x0335, B:112:0x0358, B:114:0x036d, B:115:0x0378, B:118:0x0387, B:119:0x03b7, B:116:0x0382), top: B:402:0x0335 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0aef  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0b07  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0b0a  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0b15 A[Catch: Exception -> 0x0b5a, TryCatch #2 {Exception -> 0x0b5a, blocks: (B:373:0x0b03, B:377:0x0b0b, B:379:0x0b15, B:381:0x0b36), top: B:403:0x0b03 }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0b63  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0b66  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0b71 A[Catch: Exception -> 0x0bb3, TryCatch #4 {Exception -> 0x0bb3, blocks: (B:386:0x0b5f, B:390:0x0b67, B:392:0x0b71, B:394:0x0b8f), top: B:407:0x0b5f }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0240  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$User, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v64 */
    /* JADX WARN: Type inference failed for: r5v150 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageObjectInternal(ir.eitaa.messenger.MessageObject r40) {
        /*
            Method dump skipped, instructions count: 3003
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.setMessageObjectInternal(ir.eitaa.messenger.MessageObject):void");
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
        return this.avatarImage;
    }

    public float getCheckBoxTranslation() {
        return this.checkBoxTranslation;
    }

    public float getCaptionX() {
        return this.captionX;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[PHI: r3 r5
      0x003d: PHI (r3v3 int) = (r3v2 int), (r3v10 int) binds: [B:16:0x001a, B:18:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x003d: PHI (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:16:0x001a, B:18:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
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
            if (r1 >= r2) goto L6b
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
            goto L68
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
            if (r12 == 0) goto L46
            float r3 = r11.getY()
            goto L4b
        L46:
            int r3 = r11.getTop()
            float r3 = (float) r3
        L4b:
            float r5 = r11.parentViewTopOffset
            float r3 = r3 + r5
            int r3 = (int) r3
            int r8 = (int) r5
            boolean r9 = r11.pinnedTop
            boolean r5 = r11.pinnedBottom
            if (r5 != 0) goto L63
            ir.eitaa.ui.explore.cells.KavoshCell$TransitionParams r5 = r11.transitionParams
            float r5 = r5.changePinnedBottomProgress
            r10 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L61
            goto L63
        L61:
            r10 = 0
            goto L64
        L63:
            r10 = 1
        L64:
            r5 = r3
            r4.setTop(r5, r6, r7, r8, r9, r10)
        L68:
            int r1 = r1 + 1
            goto L2
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.setBackgroundTopY(boolean):void");
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
            ir.eitaa.ui.explore.cells.KavoshCell$TransitionParams r8 = r7.transitionParams
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.setBackgroundTopY(int):void");
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
    /* JADX WARN: Removed duplicated region for block: B:250:0x05ef A[PHI: r1 r9
      0x05ef: PHI (r1v87 int) = (r1v86 int), (r1v102 int) binds: [B:246:0x05ca, B:248:0x05da] A[DONT_GENERATE, DONT_INLINE]
      0x05ef: PHI (r9v44 int) = (r9v43 int), (r9v48 int) binds: [B:246:0x05ca, B:248:0x05da] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongCall"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r27) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 2184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.onDraw(android.graphics.Canvas):void");
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

    public int getBackgroundDrawableRight() {
        return getParentWidth();
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

    public StaticLayout getCaptionLayout() {
        return this.captionLayout;
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

    /* JADX WARN: Removed duplicated region for block: B:193:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0517 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawCaptionLayout(android.graphics.Canvas r20, android.text.StaticLayout r21, boolean r22, float r23) {
        /*
            Method dump skipped, instructions count: 1376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawCaptionLayout(android.graphics.Canvas, android.text.StaticLayout, boolean, float):void");
    }

    private void placeReadMoreButton(int x, int y) {
        this.readMoreButton.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 0), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(16.0f), 0));
        TextView textView = this.readMoreButton;
        textView.layout(x, (this.captionHeight + y) - textView.getMeasuredHeight(), this.readMoreButton.getMeasuredWidth() + x, y + this.captionHeight);
    }

    private void drawChannelInfoAndButtons(Canvas canvas) {
        canvas.save();
        int iDp = (int) (this.currentMessageObject.type == 0 ? 0.0f : this.captionY + AndroidUtilities.dp(4.0f));
        ImageView imageView = this.menuButton;
        imageView.layout(0, iDp, imageView.getMeasuredWidth(), this.menuButton.getMeasuredHeight() + iDp);
        this.forwardButton.layout(this.menuButton.getMeasuredWidth() + AndroidUtilities.dp(16.0f), iDp, this.menuButton.getMeasuredWidth() + AndroidUtilities.dp(16.0f) + this.forwardButton.getMeasuredWidth(), this.forwardButton.getMeasuredHeight() + iDp);
        if (this.currentMessageObject.type == 3) {
            int iDp2 = AndroidUtilities.dp(8.0f);
            this.volumeButton.layout((getParentWidth() - this.volumeButton.getMeasuredWidth()) - iDp2, (((int) this.photoImage.getImageHeight()) - this.volumeButton.getMeasuredHeight()) - iDp2, getParentWidth() - iDp2, ((int) this.photoImage.getImageHeight()) - iDp2);
        }
        this.channelNameStartX = AndroidUtilities.dp(96.0f);
        int iDp3 = AndroidUtilities.dp(48.0f);
        CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.currentChat.title, Theme.explore_channelNameTextPaint, getParentWidth() - (this.channelNameStartX + iDp3), TextUtils.TruncateAt.END);
        int iMeasureText = (int) Theme.explore_channelNameTextPaint.measureText(charSequenceEllipsize.toString());
        this.channelNameStartX = (getParentWidth() - iMeasureText) - iDp3;
        this.channelNameLayout = new StaticLayout(charSequenceEllipsize, Theme.explore_channelNameTextPaint, iMeasureText, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        float fAbs = iDp + Math.abs((r1.getHeight() / 2) - (this.avatarImage.getImageHeight() / 2.0f));
        this.channelNameY = fAbs;
        canvas.translate(this.channelNameStartX, fAbs);
        this.channelNameLayout.draw(canvas);
        canvas.restore();
    }

    public void createMenuButton() {
        Drawable drawableMutate = getContext().getResources().getDrawable(ir.eitaa.messenger.R.drawable.msg_actions).mutate();
        ImageView imageView = new ImageView(getContext());
        this.menuButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.menuButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
        this.menuButton.setImageDrawable(drawableMutate);
        this.menuButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
        addView(this.menuButton);
        this.menuButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$SjBoTfm2Gf56POptMzS6oxSaPG8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createMenuButton$4$KavoshCell(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenuButton$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenuButton$4$KavoshCell(View view) {
        this.delegate.didPressOther(this, view.getX(), view.getY());
    }

    public void createForwardButton() {
        Drawable drawable = Theme.chat_replyIconDrawable;
        ImageView imageView = new ImageView(getContext());
        this.forwardButton = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.forwardButton.setBackgroundDrawable(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("chats_actionBackground"), 50)));
        this.forwardButton.setImageDrawable(drawable);
        this.forwardButton.setRotationY(180.0f);
        this.forwardButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
        addView(this.forwardButton);
        this.forwardButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$wZqg-u5v1oMrX4fRDqEN6K6I5B0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createForwardButton$5$KavoshCell(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createForwardButton$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createForwardButton$5$KavoshCell(View view) {
        this.delegate.didPressForwardButton(this.currentMessageObject);
    }

    public void createVolumeButton() {
        if (this.volumeButton == null) {
            ImageView imageView = new ImageView(getContext()) { // from class: ir.eitaa.ui.explore.cells.KavoshCell.10
                @Override // android.widget.ImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    Paint paint = new Paint();
                    paint.setColor(-16777216);
                    paint.setStrokeWidth(1.0f);
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    paint.setShader(new RadialGradient(getWidth() / 2, getHeight() / 2, getHeight() / 2, ColorUtils.setAlphaComponent(KavoshCell.this.getThemedPaint("paintChatTimeBackground").getColor(), 40), 0, Shader.TileMode.MIRROR));
                    int width = getWidth();
                    float height = getHeight() / 2;
                    canvas.drawCircle(width / 2, height, height, paint);
                    super.onDraw(canvas);
                }
            };
            this.volumeButton = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.volumeButton.setImageDrawable(getContext().getResources().getDrawable(SharedConfig.shouldPlayWithSound ? ir.eitaa.messenger.R.drawable.ic_volume_on : ir.eitaa.messenger.R.drawable.ic_volume_off));
            this.volumeButton.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.MULTIPLY));
            addView(this.volumeButton);
            this.volumeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$inPWKv5-O_NnVp9Cs-yrF_DUbn8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    this.f$0.lambda$createVolumeButton$6$KavoshCell(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createVolumeButton$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createVolumeButton$6$KavoshCell(View view) throws IOException {
        this.delegate.didPressVolumeButton(this.currentMessageObject);
        if (!MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
            SharedConfig.shouldPlayWithSound = true;
        } else {
            SharedConfig.shouldPlayWithSound = !SharedConfig.shouldPlayWithSound;
        }
        if (SharedConfig.shouldPlayWithSound) {
            playVideo(true);
        } else {
            muteVideo();
        }
    }

    private void createReadMoreButton() throws Resources.NotFoundException {
        Drawable drawable = getContext().getResources().getDrawable(ir.eitaa.messenger.R.drawable.ic_read_more_flip);
        drawable.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(Theme.getColor("chats_actionBackground"), BlendModeCompat.SRC_ATOP));
        final int iDp = AndroidUtilities.dp(24.0f);
        TextView textView = new TextView(getContext()) { // from class: ir.eitaa.ui.explore.cells.KavoshCell.11
            @Override // android.widget.TextView, android.view.View
            protected void onDraw(Canvas canvas) {
                LinearGradient linearGradient = new LinearGradient(getWidth() - iDp, 0.0f, getWidth(), 0.0f, Theme.getColor("windowBackgroundGray"), 0, Shader.TileMode.REPEAT);
                Paint paint = new Paint();
                paint.setShader(linearGradient);
                canvas.drawRect(new RectF(getWidth() - iDp, 0.0f, getWidth(), getHeight()), paint);
                Paint paint2 = new Paint();
                paint2.setColor(Theme.getColor("windowBackgroundGray"));
                canvas.drawRect(new RectF(0.0f, 0.0f, getWidth() - iDp, getHeight()), paint2);
                super.onDraw(canvas);
            }
        };
        this.readMoreButton = textView;
        textView.setTextColor(Theme.getColor("chats_actionBackground"));
        this.readMoreButton.setTextSize(SharedConfig.fontSize);
        this.readMoreButton.setTypeface(AndroidUtilities.getFontFamily(false));
        this.readMoreButton.setGravity(16);
        this.readMoreButton.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.readMoreButton.setCompoundDrawablePadding(8);
        this.readMoreButton.setText(LocaleController.getString("More", ir.eitaa.messenger.R.string.More));
        this.readMoreButton.setPadding(0, 0, iDp + AndroidUtilities.dp(8.0f), 0);
        this.readMoreButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                KavoshCell.this.readMoreButton.setVisibility(4);
                KavoshCell kavoshCell = KavoshCell.this;
                MessageObject messageObject = kavoshCell.currentMessageObject;
                messageObject.shortCaption = false;
                if (messageObject.type == 0) {
                    int height = messageObject.textLayoutBlocks.get(0).textLayout.getHeight();
                    MessageObject messageObject2 = KavoshCell.this.currentMessageObject;
                    messageObject2.drawFullWith = 3;
                    messageObject2.applyNewText();
                    KavoshCell kavoshCell2 = KavoshCell.this;
                    KavoshCell.access$4812(kavoshCell2, kavoshCell2.currentMessageObject.textLayoutBlocks.get(0).textLayout.getHeight() - height);
                    KavoshCell.this.requestLayout();
                    return;
                }
                if (messageObject.caption != null) {
                    try {
                        kavoshCell.captionLayout = kavoshCell.createFullCaption();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    KavoshCell kavoshCell3 = KavoshCell.this;
                    KavoshCell.access$4812(kavoshCell3, kavoshCell3.captionLayout.getHeight() - KavoshCell.this.captionHeight);
                    KavoshCell kavoshCell4 = KavoshCell.this;
                    kavoshCell4.captionHeight = kavoshCell4.captionLayout.getHeight();
                    KavoshCell.this.requestLayout();
                }
            }
        });
        addView(this.readMoreButton);
    }

    private void createViewsLayout() throws Resources.NotFoundException {
        Drawable drawable = getContext().getResources().getDrawable(ir.eitaa.messenger.R.drawable.msg_views);
        drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_inTimeText"), PorterDuff.Mode.MULTIPLY));
        TextView textView = new TextView(getContext());
        this.viewsLayout2 = textView;
        textView.setTextColor(Theme.getColor("chat_inTimeText"));
        this.viewsLayout2.setTextSize(12.0f);
        this.viewsLayout2.setTypeface(AndroidUtilities.getFontFamily(true));
        this.viewsLayout2.setText("");
        this.viewsLayout2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.viewsLayout2.setCompoundDrawablePadding(4);
        addView(this.viewsLayout2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StaticLayout createFullCaption() {
        if (Build.VERSION.SDK_INT >= 24) {
            CharSequence charSequence = this.currentMessageObject.caption;
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), Theme.chat_msgTextPaint, this.widthForCaption).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
            this.captionLayout = staticLayoutBuild;
            return staticLayoutBuild;
        }
        StaticLayout staticLayout = new StaticLayout(this.currentMessageObject.caption, Theme.chat_msgTextPaint, this.widthForCaption, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.captionLayout = staticLayout;
        return staticLayout;
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawTime(android.graphics.Canvas, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:258:0x05e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawTimeInternal(android.graphics.Canvas r29, float r30, boolean r31, float r32, android.text.StaticLayout r33, float r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 1854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawTimeInternal(android.graphics.Canvas, float, boolean, float, android.text.StaticLayout, float, boolean):void");
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
            this.statusDrawableAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.explore.cells.-$$Lambda$KavoshCell$97y_WO3oJb-DN6aCTeIg-gp-TC0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createStatusDrawableAnimator$7$KavoshCell(fromParent, valueAnimator);
                }
            });
            this.statusDrawableAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.13
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    int iCreateStatusDrawableParams = KavoshCell.this.transitionParams.createStatusDrawableParams();
                    if (KavoshCell.this.animateToStatusDrawableParams == iCreateStatusDrawableParams) {
                        KavoshCell.this.statusDrawableAnimationInProgress = false;
                        KavoshCell.this.transitionParams.lastStatusDrawableParams = KavoshCell.this.animateToStatusDrawableParams;
                    } else {
                        KavoshCell kavoshCell = KavoshCell.this;
                        kavoshCell.createStatusDrawableAnimator(kavoshCell.animateToStatusDrawableParams, iCreateStatusDrawableParams, fromParent);
                    }
                }
            });
            this.statusDrawableAnimationInProgress = true;
            this.statusDrawableAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createStatusDrawableAnimator$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createStatusDrawableAnimator$7$KavoshCell(boolean z, ValueAnimator valueAnimator) {
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
            Method dump skipped, instructions count: 1185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawViewsAndRepliesLayout(android.graphics.Canvas, float, float, float, float, float, boolean):void");
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

    /* JADX WARN: Removed duplicated region for block: B:192:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0afe  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0b91  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x0d9e  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x12fe  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x15c3  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x15dc  */
    /* JADX WARN: Removed duplicated region for block: B:759:0x15fd  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x1614  */
    /* JADX WARN: Removed duplicated region for block: B:779:0x1645  */
    /* JADX WARN: Removed duplicated region for block: B:785:0x1653  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x1664  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawOverlays(android.graphics.Canvas r32) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 6231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.drawOverlays(android.graphics.Canvas):void");
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    public MessageObject getMessageObject() {
        MessageObject messageObject = this.messageObjectToSet;
        return messageObject != null ? messageObject : this.currentMessageObject;
    }

    public TLRPC$Document getStreamingMedia() {
        int i = this.documentAttachType;
        if (i == 4 || i == 7 || i == 2) {
            return this.documentAttach;
        }
        return null;
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
    public boolean performAccessibilityAction(int action, Bundle arguments) throws InterruptedException, IOException {
        KavoshCellDelegate kavoshCellDelegate;
        if (action == 16) {
            int iconForCurrentState = getIconForCurrentState();
            if (iconForCurrentState != 4 && iconForCurrentState != 5) {
                didPressButton(true, false);
            } else if (this.currentMessageObject.type == 16) {
                this.delegate.didPressOther(this, this.otherX, this.otherY);
            } else {
                didClickedImage();
            }
            return true;
        }
        if (action == ir.eitaa.messenger.R.id.acc_action_small_button) {
            didPressMiniButton(true);
        } else if (action == ir.eitaa.messenger.R.id.acc_action_msg_options && (kavoshCellDelegate = this.delegate) != null) {
            if (this.currentMessageObject.type == 16) {
                kavoshCellDelegate.didLongPress(this, 0.0f, 0.0f);
            } else {
                kavoshCellDelegate.didPressOther(this, this.otherX, this.otherY);
            }
        }
        if ((this.currentMessageObject.isVoice() || (this.currentMessageObject.isMusic() && MediaController.getInstance().isPlayingMessage(this.currentMessageObject))) && this.seekBarAccessibilityDelegate.performAccessibilityActionInternal(action, arguments)) {
            return true;
        }
        return super.performAccessibilityAction(action, arguments);
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

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.eitaa.ui.Components.Point getMessageSize(int r3, int r4, int r5, int r6) {
        /*
            if (r6 == 0) goto L4
            if (r5 != 0) goto L55
        L4:
            boolean r5 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r5 == 0) goto L16
            int r5 = ir.eitaa.messenger.AndroidUtilities.getMinTabletSide()
            r6 = 1098907648(0x41800000, float:16.0)
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
        L14:
            int r5 = r5 - r6
            goto L3a
        L16:
            if (r3 < r4) goto L29
            android.graphics.Point r5 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r6 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r6, r5)
            r6 = 1115684864(0x42800000, float:64.0)
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            goto L14
        L29:
            android.graphics.Point r5 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r6 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r6, r5)
            float r5 = (float) r5
            r6 = 1060320051(0x3f333333, float:0.7)
            float r5 = r5 * r6
            int r5 = (int) r5
        L3a:
            r6 = 1120403456(0x42c80000, float:100.0)
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            int r6 = r6 + r5
            int r0 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
            if (r5 <= r0) goto L4b
            int r5 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
        L4b:
            int r0 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
            if (r6 <= r0) goto L55
            int r6 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
        L55:
            float r3 = (float) r3
            float r5 = (float) r5
            float r0 = r3 / r5
            float r1 = r3 / r0
            int r1 = (int) r1
            float r4 = (float) r4
            float r0 = r4 / r0
            int r0 = (int) r0
            r2 = 1125515264(0x43160000, float:150.0)
            if (r1 != 0) goto L68
            int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
        L68:
            if (r0 != 0) goto L6e
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
        L6e:
            if (r0 <= r6) goto L71
            goto L87
        L71:
            r6 = 1123024896(0x42f00000, float:120.0)
            int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            if (r0 >= r2) goto L86
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            float r0 = (float) r6
            float r4 = r4 / r0
            float r3 = r3 / r4
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 >= 0) goto L87
            int r1 = (int) r3
            goto L87
        L86:
            r6 = r0
        L87:
            ir.eitaa.ui.Components.Point r3 = new ir.eitaa.ui.Components.Point
            float r4 = (float) r1
            float r5 = (float) r6
            r3.<init>(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.getMessageSize(int, int, int, int):ir.eitaa.ui.Components.Point");
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
            String string2;
            KavoshCell kavoshCell;
            int i;
            int[] iArr = {0, 0};
            KavoshCell.this.getLocationOnScreen(iArr);
            if (virtualViewId == -1) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(KavoshCell.this);
                KavoshCell.this.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                StringBuilder sb = new StringBuilder();
                KavoshCell kavoshCell2 = KavoshCell.this;
                if (kavoshCell2.isChat && kavoshCell2.currentUser != null && !KavoshCell.this.currentMessageObject.isOut()) {
                    sb.append(UserObject.getUserName(KavoshCell.this.currentUser));
                    sb.append('\n');
                }
                if (KavoshCell.this.drawForwardedName) {
                    int i2 = 0;
                    while (i2 < 2) {
                        if (KavoshCell.this.forwardedNameLayout[i2] != null) {
                            sb.append(KavoshCell.this.forwardedNameLayout[i2].getText());
                            sb.append(i2 == 0 ? " " : "\n");
                        }
                        i2++;
                    }
                }
                if (!TextUtils.isEmpty(KavoshCell.this.currentMessageObject.messageText)) {
                    sb.append(KavoshCell.this.currentMessageObject.messageText);
                }
                if (KavoshCell.this.documentAttach != null && ((i = (kavoshCell = KavoshCell.this).documentAttachType) == 1 || i == 2 || i == 4)) {
                    if (kavoshCell.buttonState != 1 || KavoshCell.this.loadingProgressLayout == null) {
                        if (KavoshCell.this.buttonState == 0 || KavoshCell.this.documentAttachType == 1) {
                            sb.append(", ");
                            sb.append(AndroidUtilities.formatFileSize(KavoshCell.this.documentAttach.size));
                        }
                    } else {
                        sb.append("\n");
                        boolean zIsSending = KavoshCell.this.currentMessageObject.isSending();
                        sb = sb;
                        sb.append(LocaleController.formatString(zIsSending ? "AccDescrUploadProgress" : "AccDescrDownloadProgress", zIsSending ? ir.eitaa.messenger.R.string.AccDescrUploadProgress : ir.eitaa.messenger.R.string.AccDescrDownloadProgress, AndroidUtilities.formatFileSize(KavoshCell.this.currentMessageObject.loadedFileSize), AndroidUtilities.formatFileSize(KavoshCell.this.lastLoadingSizeTotal)));
                    }
                    if (KavoshCell.this.documentAttachType == 4) {
                        sb.append(", ");
                        sb.append(LocaleController.formatDuration(KavoshCell.this.currentMessageObject.getDuration()));
                    }
                }
                if (KavoshCell.this.currentMessageObject.isMusic()) {
                    sb.append("\n");
                    sb.append(LocaleController.formatString("AccDescrMusicInfo", ir.eitaa.messenger.R.string.AccDescrMusicInfo, KavoshCell.this.currentMessageObject.getMusicAuthor(), KavoshCell.this.currentMessageObject.getMusicTitle()));
                    sb.append(", ");
                    sb.append(LocaleController.formatDuration(KavoshCell.this.currentMessageObject.getDuration()));
                } else if (KavoshCell.this.currentMessageObject.isVoice() || KavoshCell.this.isRoundVideo) {
                    sb.append(", ");
                    sb.append(LocaleController.formatDuration(KavoshCell.this.currentMessageObject.getDuration()));
                    if (KavoshCell.this.currentMessageObject.isContentUnread()) {
                        sb.append(", ");
                        sb.append(LocaleController.getString("AccDescrMsgNotPlayed", ir.eitaa.messenger.R.string.AccDescrMsgNotPlayed));
                    }
                }
                if (KavoshCell.this.lastPoll != null) {
                    sb.append(", ");
                    sb.append(KavoshCell.this.lastPoll.question);
                    sb.append(", ");
                    if (!KavoshCell.this.pollClosed) {
                        if (KavoshCell.this.lastPoll.quiz) {
                            if (KavoshCell.this.lastPoll.public_voters) {
                                string2 = LocaleController.getString("QuizPoll", ir.eitaa.messenger.R.string.QuizPoll);
                            } else {
                                string2 = LocaleController.getString("AnonymousQuizPoll", ir.eitaa.messenger.R.string.AnonymousQuizPoll);
                            }
                        } else if (KavoshCell.this.lastPoll.public_voters) {
                            string2 = LocaleController.getString("PublicPoll", ir.eitaa.messenger.R.string.PublicPoll);
                        } else {
                            string2 = LocaleController.getString("AnonymousPoll", ir.eitaa.messenger.R.string.AnonymousPoll);
                        }
                    } else {
                        string2 = LocaleController.getString("FinalResults", ir.eitaa.messenger.R.string.FinalResults);
                    }
                    sb.append(string2);
                }
                MessageObject messageObject = KavoshCell.this.currentMessageObject;
                if (messageObject.messageOwner.media != null && !TextUtils.isEmpty(messageObject.caption)) {
                    sb.append("\n");
                    sb.append(KavoshCell.this.currentMessageObject.caption);
                }
                sb.append("\n");
                sb.append(LocaleController.formatString("AccDescrReceivedDate", ir.eitaa.messenger.R.string.AccDescrReceivedDate, LocaleController.getString("TodayAt", ir.eitaa.messenger.R.string.TodayAt) + " " + KavoshCell.this.currentTimeString));
                if ((KavoshCell.this.currentMessageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                    sb.append("\n");
                    sb.append(LocaleController.formatPluralString("AccDescrNumberOfViews", KavoshCell.this.currentMessageObject.messageOwner.views));
                }
                sb.append("\n");
                accessibilityNodeInfoObtain.setContentDescription(sb.toString());
                accessibilityNodeInfoObtain.setEnabled(true);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 19 && (collectionItemInfo = accessibilityNodeInfoObtain.getCollectionItemInfo()) != null) {
                    accessibilityNodeInfoObtain.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(collectionItemInfo.getRowIndex(), 1, 0, 1, false));
                }
                if (i3 >= 21) {
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.eitaa.messenger.R.id.acc_action_msg_options, LocaleController.getString("AccActionMessageOptions", ir.eitaa.messenger.R.string.AccActionMessageOptions)));
                    int iconForCurrentState = KavoshCell.this.getIconForCurrentState();
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
                        string = KavoshCell.this.currentMessageObject.type == 16 ? LocaleController.getString("CallAgain", ir.eitaa.messenger.R.string.CallAgain) : null;
                    }
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, string));
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccActionEnterSelectionMode", ir.eitaa.messenger.R.string.AccActionEnterSelectionMode)));
                    if (KavoshCell.this.getMiniIconForCurrentState() == 2) {
                        accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.eitaa.messenger.R.id.acc_action_small_button, LocaleController.getString("AccActionDownload", ir.eitaa.messenger.R.string.AccActionDownload)));
                    }
                } else {
                    accessibilityNodeInfoObtain.addAction(16);
                    accessibilityNodeInfoObtain.addAction(32);
                }
                if ((KavoshCell.this.currentMessageObject.isVoice() || KavoshCell.this.currentMessageObject.isMusic()) && MediaController.getInstance().isPlayingMessage(KavoshCell.this.currentMessageObject)) {
                    KavoshCell.this.seekBarAccessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfoObtain);
                }
                CharSequence charSequence = KavoshCell.this.currentMessageObject.messageText;
                if (charSequence instanceof Spannable) {
                    Spannable spannable = (Spannable) charSequence;
                    int i4 = 0;
                    for (CharacterStyle characterStyle : (CharacterStyle[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(KavoshCell.this, i4 + 2000);
                        i4++;
                    }
                }
                KavoshCell kavoshCell3 = KavoshCell.this;
                if ((kavoshCell3.currentMessageObject.caption instanceof Spannable) && kavoshCell3.captionLayout != null) {
                    Spannable spannable2 = (Spannable) KavoshCell.this.currentMessageObject.caption;
                    int i5 = 0;
                    for (CharacterStyle characterStyle2 : (CharacterStyle[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(KavoshCell.this, i5 + 3000);
                        i5++;
                    }
                }
                Iterator it = KavoshCell.this.botButtons.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, i6 + 1000);
                    i6++;
                }
                if (KavoshCell.this.hintButtonVisible && KavoshCell.this.pollHintX != -1 && KavoshCell.this.currentMessageObject.isPoll()) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, 495);
                }
                Iterator it2 = KavoshCell.this.pollButtons.iterator();
                int i7 = 0;
                while (it2.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, i7 + 500);
                    i7++;
                }
                if (KavoshCell.this.drawInstantView && !KavoshCell.this.instantButtonRect.isEmpty()) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, 499);
                }
                if (KavoshCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, 496);
                }
                KavoshCell kavoshCell4 = KavoshCell.this;
                if (kavoshCell4.replyNameLayout != null) {
                    accessibilityNodeInfoObtain.addChild(kavoshCell4, 497);
                }
                if (KavoshCell.this.forwardedNameLayout[0] != null && KavoshCell.this.forwardedNameLayout[1] != null) {
                    accessibilityNodeInfoObtain.addChild(KavoshCell.this, 494);
                }
                if (KavoshCell.this.drawSelectionBackground || KavoshCell.this.getBackground() != null) {
                    accessibilityNodeInfoObtain.setSelected(true);
                }
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain2.setSource(KavoshCell.this, virtualViewId);
            accessibilityNodeInfoObtain2.setParent(KavoshCell.this);
            accessibilityNodeInfoObtain2.setPackageName(KavoshCell.this.getContext().getPackageName());
            if (virtualViewId >= 3000) {
                KavoshCell kavoshCell5 = KavoshCell.this;
                if (!(kavoshCell5.currentMessageObject.caption instanceof Spannable) || kavoshCell5.captionLayout == null) {
                    return null;
                }
                Spannable spannable3 = (Spannable) KavoshCell.this.currentMessageObject.caption;
                ClickableSpan linkById = getLinkById(virtualViewId, true);
                if (linkById == null) {
                    return null;
                }
                int[] realSpanStartAndEnd = KavoshCell.this.getRealSpanStartAndEnd(spannable3, linkById);
                accessibilityNodeInfoObtain2.setText(spannable3.subSequence(realSpanStartAndEnd[0], realSpanStartAndEnd[1]).toString());
                KavoshCell.this.captionLayout.getText().length();
                KavoshCell.this.captionLayout.getSelectionPath(realSpanStartAndEnd[0], realSpanStartAndEnd[1], this.linkPath);
                this.linkPath.computeBounds(this.rectF, true);
                Rect rect = this.rect;
                RectF rectF = this.rectF;
                rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.rect.offset((int) KavoshCell.this.captionX, (int) KavoshCell.this.captionY);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
                CharSequence charSequence2 = KavoshCell.this.currentMessageObject.messageText;
                if (!(charSequence2 instanceof Spannable)) {
                    return null;
                }
                Spannable spannable4 = (Spannable) charSequence2;
                ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                if (linkById2 == null) {
                    return null;
                }
                int[] realSpanStartAndEnd2 = KavoshCell.this.getRealSpanStartAndEnd(spannable4, linkById2);
                accessibilityNodeInfoObtain2.setText(spannable4.subSequence(realSpanStartAndEnd2[0], realSpanStartAndEnd2[1]).toString());
                Iterator<MessageObject.TextLayoutBlock> it3 = KavoshCell.this.currentMessageObject.textLayoutBlocks.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    MessageObject.TextLayoutBlock next = it3.next();
                    int length = next.textLayout.getText().length();
                    int i8 = next.charactersOffset;
                    if (i8 <= realSpanStartAndEnd2[0] && length + i8 >= realSpanStartAndEnd2[1]) {
                        next.textLayout.getSelectionPath(realSpanStartAndEnd2[0] - i8, realSpanStartAndEnd2[1] - i8, this.linkPath);
                        this.linkPath.computeBounds(this.rectF, true);
                        Rect rect2 = this.rect;
                        RectF rectF2 = this.rectF;
                        rect2.set((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        this.rect.offset(0, (int) next.textYOffset);
                        this.rect.offset(KavoshCell.this.textX, KavoshCell.this.textY);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                            KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
                int i9 = virtualViewId - 1000;
                if (i9 >= KavoshCell.this.botButtons.size()) {
                    return null;
                }
                BotButton botButton = (BotButton) KavoshCell.this.botButtons.get(i9);
                accessibilityNodeInfoObtain2.setText(botButton.title.getText());
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(botButton.x, botButton.y, botButton.x + botButton.width, botButton.y + botButton.height);
                this.rect.offset(KavoshCell.this.currentMessageObject.isOutOwner() ? (KavoshCell.this.getMeasuredWidth() - KavoshCell.this.widthForButtons) - AndroidUtilities.dp(10.0f) : KavoshCell.this.backgroundDrawableLeft + AndroidUtilities.dp(KavoshCell.this.mediaBackground ? 1.0f : 7.0f), KavoshCell.this.layoutHeight);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
            } else if (virtualViewId >= 500) {
                int i10 = virtualViewId - 500;
                if (i10 >= KavoshCell.this.pollButtons.size()) {
                    return null;
                }
                PollButton pollButton = (PollButton) KavoshCell.this.pollButtons.get(i10);
                StringBuilder sb2 = new StringBuilder(pollButton.title.getText());
                if (KavoshCell.this.pollVoted) {
                    accessibilityNodeInfoObtain2.setSelected(pollButton.chosen);
                    sb2.append(", ");
                    sb2.append(pollButton.percent);
                    sb2.append("%");
                    if (KavoshCell.this.lastPoll != null && KavoshCell.this.lastPoll.quiz && pollButton.correct) {
                        sb2.append(", ");
                        sb2.append(LocaleController.getString("AccDescrQuizCorrectAnswer", ir.eitaa.messenger.R.string.AccDescrQuizCorrectAnswer));
                    }
                } else {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                accessibilityNodeInfoObtain2.setText(sb2);
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.addAction(16);
                int i11 = pollButton.y + KavoshCell.this.namesOffset;
                int iDp = KavoshCell.this.backgroundWidth - AndroidUtilities.dp(76.0f);
                Rect rect3 = this.rect;
                int i12 = pollButton.x;
                rect3.set(i12, i11, iDp + i12, pollButton.height + i11);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 495) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setText(LocaleController.getString("AccDescrQuizExplanation", ir.eitaa.messenger.R.string.AccDescrQuizExplanation));
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(KavoshCell.this.pollHintX - AndroidUtilities.dp(8.0f), KavoshCell.this.pollHintY - AndroidUtilities.dp(8.0f), KavoshCell.this.pollHintX + AndroidUtilities.dp(32.0f), KavoshCell.this.pollHintY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 499) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (KavoshCell.this.instantViewLayout != null) {
                    accessibilityNodeInfoObtain2.setText(KavoshCell.this.instantViewLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                KavoshCell.this.instantButtonRect.round(this.rect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 498) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.ImageButton");
                accessibilityNodeInfoObtain2.setEnabled(true);
                KavoshCell kavoshCell6 = KavoshCell.this;
                if (kavoshCell6.isOpenChatByShare(kavoshCell6.currentMessageObject)) {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("AccDescrOpenChat", ir.eitaa.messenger.R.string.AccDescrOpenChat));
                } else {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("ShareFile", ir.eitaa.messenger.R.string.ShareFile));
                }
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 497) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(LocaleController.getString("Reply", ir.eitaa.messenger.R.string.Reply));
                sb3.append(", ");
                StaticLayout staticLayout = KavoshCell.this.replyNameLayout;
                if (staticLayout != null) {
                    sb3.append(staticLayout.getText());
                    sb3.append(", ");
                }
                StaticLayout staticLayout2 = KavoshCell.this.replyTextLayout;
                if (staticLayout2 != null) {
                    sb3.append(staticLayout2.getText());
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb3.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                Rect rect4 = this.rect;
                KavoshCell kavoshCell7 = KavoshCell.this;
                int i13 = kavoshCell7.replyStartX;
                rect4.set(i13, kavoshCell7.replyStartY, Math.max(kavoshCell7.replyNameWidth, KavoshCell.this.replyTextWidth) + i13, KavoshCell.this.replyStartY + AndroidUtilities.dp(35.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 494) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb4 = new StringBuilder();
                if (KavoshCell.this.forwardedNameLayout[0] != null && KavoshCell.this.forwardedNameLayout[1] != null) {
                    int i14 = 0;
                    while (i14 < 2) {
                        sb4.append(KavoshCell.this.forwardedNameLayout[i14].getText());
                        sb4.append(i14 == 0 ? " " : "\n");
                        i14++;
                    }
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb4.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                int iMin = (int) Math.min(KavoshCell.this.forwardNameX - KavoshCell.this.forwardNameOffsetX[0], KavoshCell.this.forwardNameX - KavoshCell.this.forwardNameOffsetX[1]);
                this.rect.set(iMin, KavoshCell.this.forwardNameY, KavoshCell.this.forwardedNameWidth + iMin, KavoshCell.this.forwardNameY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 496) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (KavoshCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain2.setText(KavoshCell.this.commentLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(KavoshCell.this.commentButtonRect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) KavoshCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    KavoshCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
        public boolean performAction(int virtualViewId, int action, Bundle arguments) throws InterruptedException, IOException {
            if (virtualViewId == -1) {
                KavoshCell.this.performAccessibilityAction(action, arguments);
            } else if (action == 64) {
                KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            } else {
                if (action == 16) {
                    if (virtualViewId >= 3000) {
                        ClickableSpan linkById = getLinkById(virtualViewId, true);
                        if (linkById != null) {
                            KavoshCell.this.delegate.didPressUrl(KavoshCell.this, linkById, false);
                            KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 2000) {
                        ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                        if (linkById2 != null) {
                            KavoshCell.this.delegate.didPressUrl(KavoshCell.this, linkById2, false);
                            KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 1000) {
                        int i = virtualViewId - 1000;
                        if (i >= KavoshCell.this.botButtons.size()) {
                            return false;
                        }
                        BotButton botButton = (BotButton) KavoshCell.this.botButtons.get(i);
                        if (KavoshCell.this.delegate != null) {
                            if (botButton.button != null) {
                                KavoshCell.this.delegate.didPressBotButton(KavoshCell.this, botButton.button);
                            } else if (botButton.reaction != null) {
                                KavoshCell.this.delegate.didPressReaction(KavoshCell.this, botButton.reaction);
                            }
                        }
                        KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId >= 500) {
                        int i2 = virtualViewId - 500;
                        if (i2 >= KavoshCell.this.pollButtons.size()) {
                            return false;
                        }
                        PollButton pollButton = (PollButton) KavoshCell.this.pollButtons.get(i2);
                        if (KavoshCell.this.delegate != null) {
                            ArrayList<TLRPC$TL_pollAnswer> arrayList = new ArrayList<>();
                            arrayList.add(pollButton.answer);
                            KavoshCell.this.delegate.didPressVoteButtons(KavoshCell.this, arrayList, -1, 0, 0);
                        }
                        KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId == 495) {
                        if (KavoshCell.this.delegate != null) {
                            KavoshCell.this.delegate.didPressHint(KavoshCell.this, 0);
                        }
                    } else if (virtualViewId == 499) {
                        if (KavoshCell.this.delegate != null) {
                            KavoshCellDelegate kavoshCellDelegate = KavoshCell.this.delegate;
                            KavoshCell kavoshCell = KavoshCell.this;
                            kavoshCellDelegate.didPressInstantButton(kavoshCell, kavoshCell.drawInstantViewType);
                        }
                    } else if (virtualViewId == 498) {
                        if (KavoshCell.this.delegate != null) {
                            KavoshCell.this.delegate.didPressSideButton(KavoshCell.this);
                        }
                    } else if (virtualViewId == 497) {
                        if (KavoshCell.this.delegate != null) {
                            KavoshCell kavoshCell2 = KavoshCell.this;
                            if ((!kavoshCell2.isThreadChat || kavoshCell2.currentMessageObject.getReplyTopMsgId() != 0) && KavoshCell.this.currentMessageObject.hasValidReplyMessageObject()) {
                                KavoshCellDelegate kavoshCellDelegate2 = KavoshCell.this.delegate;
                                KavoshCell kavoshCell3 = KavoshCell.this;
                                kavoshCellDelegate2.didPressReplyMessage(kavoshCell3, kavoshCell3.currentMessageObject.getReplyMsgId());
                            }
                        }
                    } else if (virtualViewId == 494) {
                        if (KavoshCell.this.delegate != null && KavoshCell.this.currentForwardChannel == null) {
                            if (KavoshCell.this.currentForwardUser != null) {
                                KavoshCellDelegate kavoshCellDelegate3 = KavoshCell.this.delegate;
                                KavoshCell kavoshCell4 = KavoshCell.this;
                                kavoshCellDelegate3.didPressUserAvatar(kavoshCell4, kavoshCell4.currentForwardUser, KavoshCell.this.lastTouchX, KavoshCell.this.lastTouchY);
                            } else if (KavoshCell.this.currentForwardName != null) {
                                KavoshCell.this.delegate.didPressHiddenForward(KavoshCell.this);
                            }
                        }
                    } else if (virtualViewId == 496 && KavoshCell.this.delegate != null) {
                        KavoshCell kavoshCell5 = KavoshCell.this;
                        if (kavoshCell5.isRepliesChat) {
                            kavoshCell5.delegate.didPressSideButton(KavoshCell.this);
                        } else {
                            kavoshCell5.delegate.didPressCommentButton(KavoshCell.this);
                        }
                    }
                } else if (action == 32) {
                    ClickableSpan linkById3 = getLinkById(virtualViewId, virtualViewId >= 3000);
                    if (linkById3 != null) {
                        KavoshCell.this.delegate.didPressUrl(KavoshCell.this, linkById3, true);
                        KavoshCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 2);
                    }
                }
            }
            return true;
        }

        private ClickableSpan getLinkById(int id, boolean caption) {
            if (caption) {
                int i = id - 3000;
                CharSequence charSequence = KavoshCell.this.currentMessageObject.caption;
                if (!(charSequence instanceof Spannable)) {
                    return null;
                }
                Spannable spannable = (Spannable) charSequence;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
                if (clickableSpanArr.length <= i) {
                    return null;
                }
                return clickableSpanArr[i];
            }
            int i2 = id - 2000;
            CharSequence charSequence2 = KavoshCell.this.currentMessageObject.messageText;
            if (!(charSequence2 instanceof Spannable)) {
                return null;
            }
            Spannable spannable2 = (Spannable) charSequence2;
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

    public int getCurrentBackgroundLeft() {
        int i = this.currentBackgroundDrawable.getBounds().left;
        return (this.currentMessageObject.isOutOwner() || this.transitionParams.changePinnedBottomProgress == 1.0f || this.mediaBackground || this.drawPinnedBottom) ? i : i - AndroidUtilities.dp(6.0f);
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
        return (AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x) - AndroidUtilities.dp(16.0f);
    }

    public class TransitionParams {
        public boolean animateBackgroundBoundsInner;
        private boolean animateButton;
        private int animateCommentArrowX;
        private boolean animateComments;
        public boolean animateDrawingTimeAlpha;
        private boolean animateEditedEnter;
        private StaticLayout animateEditedLayout;
        public boolean animateForwardedLayout;
        public int animateForwardedNamesOffset;
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
        private boolean lastShouldDrawMenuDrawable;
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
            this.lastDrawingImageX = KavoshCell.this.photoImage.getImageX();
            this.lastDrawingImageY = KavoshCell.this.photoImage.getImageY();
            this.lastDrawingImageW = KavoshCell.this.photoImage.getImageWidth();
            this.lastDrawingImageH = KavoshCell.this.photoImage.getImageHeight();
            System.arraycopy(KavoshCell.this.photoImage.getRoundRadius(), 0, this.imageRoundRadius, 0, 4);
            if (KavoshCell.this.currentBackgroundDrawable != null) {
                this.lastDrawingBackgroundRect.set(KavoshCell.this.currentBackgroundDrawable.getBounds());
            }
            KavoshCell kavoshCell = KavoshCell.this;
            this.lastDrawingTextBlocks = kavoshCell.currentMessageObject.textLayoutBlocks;
            this.lastDrawingEdited = kavoshCell.edited;
            this.lastDrawingCaptionX = KavoshCell.this.captionX;
            KavoshCell kavoshCell2 = KavoshCell.this;
            this.lastDrawingCaptionY = kavoshCell2.captionY;
            this.lastDrawingCaptionLayout = kavoshCell2.captionLayout;
            if (!KavoshCell.this.botButtons.isEmpty()) {
                this.lastDrawBotButtons.clear();
                this.lastDrawBotButtons.addAll(KavoshCell.this.botButtons);
            }
            if (KavoshCell.this.commentLayout != null) {
                this.lastCommentsCount = KavoshCell.this.getRepliesCount();
                this.lastTotalCommentWidth = KavoshCell.this.totalCommentWidth;
                this.lastCommentLayout = KavoshCell.this.commentLayout;
                this.lastCommentArrowX = KavoshCell.this.commentArrowX;
                this.lastCommentUnreadX = KavoshCell.this.commentUnreadX;
                this.lastCommentDrawUnread = KavoshCell.this.commentDrawUnread;
                this.lastCommentX = KavoshCell.this.commentX;
                this.lastDrawCommentNumber = KavoshCell.this.drawCommentNumber;
            }
            this.lastRepliesCount = KavoshCell.this.getRepliesCount();
            this.lastViewsCount = KavoshCell.this.getMessageObject().messageOwner.views;
            this.lastRepliesLayout = KavoshCell.this.repliesLayout;
            this.lastViewsLayout = KavoshCell.this.viewsLayout;
            KavoshCell kavoshCell3 = KavoshCell.this;
            this.lastIsPinned = kavoshCell3.isPinned;
            this.lastSignMessage = kavoshCell3.lastPostAuthor;
            this.lastButtonX = KavoshCell.this.buttonX;
            this.lastButtonY = KavoshCell.this.buttonY;
            this.lastDrawTime = !KavoshCell.this.forceNotDrawTime;
            this.lastTimeX = KavoshCell.this.timeX;
            this.lastTimeLayout = KavoshCell.this.timeLayout;
            this.lastTimeWidth = KavoshCell.this.timeWidth;
            this.lastShouldDrawTimeOnMedia = KavoshCell.this.shouldDrawTimeOnMedia();
            this.lastTopOffset = KavoshCell.this.getTopMediaOffset();
            this.lastShouldDrawMenuDrawable = KavoshCell.this.shouldDrawMenuDrawable();
            this.lastLocatinIsExpired = KavoshCell.this.locationExpired;
            this.lastIsPlayingRound = KavoshCell.this.isPlayingRound;
            this.lastDrawingTextY = KavoshCell.this.textY;
            this.lastDrawingTextX = KavoshCell.this.textX;
            this.lastDrawnForwardedNameLayout[0] = KavoshCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = KavoshCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = KavoshCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = KavoshCell.this.forwardNameX;
            this.lastForwardedNamesOffset = KavoshCell.this.namesOffset;
            this.lastForwardNameWidth = KavoshCell.this.forwardedNameWidth;
        }

        public void onDetach() {
            this.wasDraw = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int createStatusDrawableParams() {
            /*
                r7 = this;
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isOutOwner()
                r1 = 8
                r2 = 4
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L68
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L53
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L24
                goto L53
            L24:
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isSendError()
                if (r0 == 0) goto L33
                r0 = 0
                r3 = 0
                r5 = 0
                r6 = 1
                goto L57
            L33:
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isSent()
                if (r0 == 0) goto L4f
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r5 = r0.scheduled
                if (r5 != 0) goto L4d
                boolean r0 = r0.isUnread()
                if (r0 != 0) goto L4d
                r0 = 1
                goto L51
            L4d:
                r0 = 0
                goto L51
            L4f:
                r0 = 0
                r3 = 0
            L51:
                r5 = 0
                goto L56
            L53:
                r0 = 0
                r3 = 0
                r5 = 1
            L56:
                r6 = 0
            L57:
                if (r3 == 0) goto L5b
                r3 = 2
                goto L5c
            L5b:
                r3 = 0
            L5c:
                r0 = r0 | r3
                if (r5 == 0) goto L60
                goto L61
            L60:
                r2 = 0
            L61:
                r0 = r0 | r2
                if (r6 == 0) goto L65
                goto L66
            L65:
                r1 = 0
            L66:
                r0 = r0 | r1
                return r0
            L68:
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L7e
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L7d
                goto L7e
            L7d:
                r3 = 0
            L7e:
                ir.eitaa.ui.explore.cells.KavoshCell r0 = ir.eitaa.ui.explore.cells.KavoshCell.this
                ir.eitaa.messenger.MessageObject r0 = r0.currentMessageObject
                boolean r0 = r0.isSendError()
                if (r3 == 0) goto L89
                goto L8a
            L89:
                r2 = 0
            L8a:
                if (r0 == 0) goto L8d
                goto L8e
            L8d:
                r1 = 0
            L8e:
                r0 = r2 | r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.cells.KavoshCell.TransitionParams.createStatusDrawableParams():int");
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

    /* JADX INFO: Access modifiers changed from: private */
    public Paint getThemedPaint(String paintKey) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Paint paint = resourcesProvider != null ? resourcesProvider.getPaint(paintKey) : null;
        return paint != null ? paint : Theme.getThemePaint(paintKey);
    }

    private boolean hasGradientService() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        return resourcesProvider != null ? resourcesProvider.hasGradientService() : Theme.hasGradientService();
    }

    private void creatVideoPlayerViews() {
        if (Build.VERSION.SDK_INT >= 21) {
            FrameLayout frameLayout = new FrameLayout(getContext()) { // from class: ir.eitaa.ui.explore.cells.KavoshCell.15
                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    super.setTranslationY(translationY);
                }
            };
            this.videoPlayerContainer = frameLayout;
            frameLayout.setTag(ir.eitaa.messenger.R.id.parent_tag, this.photoImage);
            this.videoPlayerContainer.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.explore.cells.KavoshCell.16
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, KavoshCell.this.getParentWidth(), (int) KavoshCell.this.photoImage.getImageHeight(), AndroidUtilities.dp(SharedConfig.bubbleRadius));
                }
            });
            this.videoPlayerContainer.setClipToOutline(true);
        }
        this.videoPlayerContainer.setWillNotDraw(false);
        AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(getContext());
        this.aspectRatioFrameLayout = aspectRatioFrameLayout;
        aspectRatioFrameLayout.setWillNotDraw(false);
        this.aspectRatioFrameLayout.setBackgroundColor(0);
        this.videoPlayerContainer.addView(this.aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
        TextureView textureView = new TextureView(getContext());
        this.videoTextureView = textureView;
        textureView.setOpaque(false);
        this.videoTextureView.setWillNotDraw(false);
        this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1.0f));
        this.aspectRatioFrameLayout.setDrawingReady(false);
        this.aspectRatioFrameLayout.setResizeMode(3);
        addView(this.videoPlayerContainer, 1, new FrameLayout.LayoutParams(getParentWidth(), (int) this.photoImage.getImageHeight()));
    }

    public void playVideo(boolean fromAnimation) throws IOException {
        if (this.documentAttachType == 4) {
            int size = this.documentAttach.attributes.size();
            for (int i = 0; i < size; i++) {
                if (this.documentAttach.attributes.get(i) instanceof TLRPC$TL_documentAttributeVideo) {
                    this.videoTextureView.setScaleY((r3.h * (this.photoImage.getImageWidth() / r3.w)) / this.photoImage.getImageHeight());
                }
            }
            if (MediaController.getInstance().getVideoPlayer() != null && MediaController.getInstance().getPlayingMessageObject() == this.currentMessageObject) {
                MediaController.getInstance().getVideoPlayer().setMute(false);
                return;
            }
            if (getPhotoImage().getAnimation() != null) {
                MessagesController.getInstance(getMessageObject().currentAccount).setLastVisibleDialogId(getMessageObject().getDialogId(), false, true);
                if (fromAnimation) {
                    getMessageObject().audioProgress = getPhotoImage().getAnimation().getCurrentProgress();
                    getMessageObject().audioProgressMs = getPhotoImage().getAnimation().getCurrentProgressMs();
                }
                MediaController.getInstance().playMessage(getMessageObject());
                this.videoPlayerContainer.layout(0, 0, getParentWidth(), (int) this.photoImage.getImageHeight());
                this.aspectRatioFrameLayout.layout(0, 0, getParentWidth(), (int) this.photoImage.getImageHeight());
                this.videoTextureView.layout(0, 0, getParentWidth(), (int) this.photoImage.getImageHeight());
                MediaController.getInstance().setTextureView(this.videoTextureView, this.aspectRatioFrameLayout, this.videoPlayerContainer, true);
                MediaController.getInstance().setCurrentVideoVisible(true);
            }
        }
    }

    private void muteVideo() {
        if (MediaController.getInstance().getVideoPlayer() != null) {
            MediaController.getInstance().getVideoPlayer().setMute(true);
        }
    }

    public void stopVideo() throws InterruptedException, IOException {
        if (this.videoPlayerContainer == null || !MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
            return;
        }
        MediaController.getInstance().cleanupPlayer(true, true);
    }

    private void stopMusic() throws InterruptedException, IOException {
        if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
            MediaController.getInstance().cleanupPlayer(true, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws Resources.NotFoundException {
        super.dispatchDraw(canvas);
        if (MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && this.currentMessageObject.type == 3) {
            drawOverlays(canvas);
        }
    }
}
