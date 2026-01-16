package ir.eitaa.ui.Cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
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
import android.os.SystemClock;
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
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
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
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
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
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RadialProgress2;
import ir.eitaa.ui.Components.RoundVideoPlayingDrawable;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SeekBarAccessibilityDelegate;
import ir.eitaa.ui.Components.SeekBarWaveform;
import ir.eitaa.ui.Components.SlotsDrawable;
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
public class ChatMessageCell extends BaseCell implements SeekBar.SeekBarDelegate, ImageReceiver.ImageReceiverDelegate, DownloadController.FileDownloadProgressListener, TextSelectionHelper.SelectableView {
    private static float[] radii = new float[8];
    private final boolean ALPHA_PROPERTY_WORKAROUND;
    public Property<ChatMessageCell, Float> ANIMATION_OFFSET_X;
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
    private float captionY;
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
    private ChatMessageCellDelegate delegate;
    private RectF deleteProgressRect;
    private StaticLayout descriptionLayout;
    private int descriptionX;
    private int descriptionY;
    private Runnable diceFinishCallback;
    private boolean disallowLongPress;
    private StaticLayout docTitleLayout;
    private int docTitleOffsetX;
    private int docTitleWidth;
    private TLRPC$Document documentAttach;
    private int documentAttachType;
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
    private boolean forwardBotPressed;
    private int forwardNameCenterX;
    private float[] forwardNameOffsetX;
    private boolean forwardNamePressed;
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
    private boolean isAvatarVisible;
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
    private long lastNamesAnimationTime;
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
    private MessageObject messageObjectToSet;
    private int miniButtonPressed;
    private int miniButtonState;
    private MotionBackgroundDrawable motionBackgroundDrawable;
    private StaticLayout nameLayout;
    private float nameOffsetX;
    private int nameWidth;
    private float nameX;
    private float nameY;
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
    private float psaButtonProgress;
    private boolean psaButtonVisible;
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
    private boolean replyPressed;
    public int replyStartX;
    public int replyStartY;
    public StaticLayout replyTextLayout;
    private int replyTextOffset;
    private int replyTextWidth;
    private final Theme.ResourcesProvider resourcesProvider;
    private float roundPlayingDrawableProgress;
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
    private boolean shareToMinePerformed;
    private boolean shareToMinePressed;
    private int shareToMineStartX;
    private int shareToMineStartY;
    public boolean shouldDrawMenu;
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
    VideoForwardDrawable videoForwardDrawable;
    private StaticLayout videoInfoLayout;
    VideoPlayerRewinder videoPlayerRewinder;
    private RadialProgress2 videoRadialProgress;
    private float viewTop;
    private StaticLayout viewsLayout;
    private int viewsTextWidth;
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
    private boolean willRemoved;

    public interface ChatMessageCellDelegate {

        /* renamed from: ir.eitaa.ui.Cells.ChatMessageCell$ChatMessageCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canPerformActions(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static void $default$didLongPress(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, float f, float f2) {
            }

            public static boolean $default$didLongPressChannelAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                return false;
            }

            public static boolean $default$didLongPressUserAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2) {
                return false;
            }

            public static void $default$didPressBotButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
            }

            public static void $default$didPressCancelSendButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressChannelAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
            }

            public static void $default$didPressCommentButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressHiddenForward(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressHint(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, int i) {
            }

            public static void $default$didPressImage(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, float f, float f2) {
            }

            public static void $default$didPressInstantButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, int i) {
            }

            public static void $default$didPressOther(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, float f, float f2) {
            }

            public static void $default$didPressReaction(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
            }

            public static void $default$didPressReplyMessage(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, int i) {
            }

            public static void $default$didPressSideButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressTime(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressUrl(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, CharacterStyle characterStyle, boolean z) {
            }

            public static void $default$didPressUserAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2) {
            }

            public static void $default$didPressViaBot(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, String str) {
            }

            public static void $default$didPressVoteButtons(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, ArrayList arrayList, int i, int i2, int i3) {
            }

            public static void $default$didPressedShareToMine(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didStartVideoStream(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject) {
            }

            public static String $default$getAdminRank(ChatMessageCellDelegate chatMessageCellDelegate, long j) {
                return null;
            }

            public static PinchToZoomHelper $default$getPinchToZoomHelper(ChatMessageCellDelegate chatMessageCellDelegate) {
                return null;
            }

            public static TextSelectionHelper.ChatListTextSelectionHelper $default$getTextSelectionHelper(ChatMessageCellDelegate chatMessageCellDelegate) {
                return null;
            }

            public static boolean $default$hasSelectedMessages(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static boolean $default$isLandscape(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static boolean $default$keyboardIsOpened(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static void $default$needOpenWebView(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject, String str, String str2, String str3, String str4, int i, int i2) {
            }

            public static boolean $default$needPlayMessage(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject) {
                return false;
            }

            public static void $default$needReloadPolls(ChatMessageCellDelegate chatMessageCellDelegate) {
            }

            public static void $default$onDiceFinished(ChatMessageCellDelegate chatMessageCellDelegate) {
            }

            public static void $default$setShouldNotRepeatSticker(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject) {
            }

            public static boolean $default$shouldDrawThreadProgress(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
                return false;
            }

            public static boolean $default$shouldRepeatSticker(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject) {
                return true;
            }

            public static void $default$videoTimerReached(ChatMessageCellDelegate chatMessageCellDelegate) {
            }
        }

        boolean canPerformActions();

        void didLongPress(ChatMessageCell cell, float x, float y);

        boolean didLongPressChannelAvatar(ChatMessageCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        boolean didLongPressUserAvatar(ChatMessageCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressBotButton(ChatMessageCell cell, TLRPC$KeyboardButton button);

        void didPressCancelSendButton(ChatMessageCell cell);

        void didPressChannelAvatar(ChatMessageCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY);

        void didPressCommentButton(ChatMessageCell cell);

        void didPressHiddenForward(ChatMessageCell cell);

        void didPressHint(ChatMessageCell cell, int type);

        void didPressImage(ChatMessageCell cell, float x, float y);

        void didPressInstantButton(ChatMessageCell cell, int type);

        void didPressOther(ChatMessageCell cell, float otherX, float otherY);

        void didPressReaction(ChatMessageCell cell, TLRPC$TL_reactionCount reaction);

        void didPressReplyMessage(ChatMessageCell cell, int id);

        void didPressSideButton(ChatMessageCell cell);

        void didPressTime(ChatMessageCell cell);

        void didPressUrl(ChatMessageCell cell, CharacterStyle url, boolean longPress);

        void didPressUserAvatar(ChatMessageCell cell, TLRPC$User user, float touchX, float touchY);

        void didPressViaBot(ChatMessageCell cell, String username);

        void didPressVoteButtons(ChatMessageCell cell, ArrayList<TLRPC$TL_pollAnswer> buttons, int showCount, int x, int y);

        void didPressedShareToMine(ChatMessageCell cell);

        void didStartVideoStream(MessageObject message);

        String getAdminRank(long uid);

        PinchToZoomHelper getPinchToZoomHelper();

        TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper();

        boolean hasSelectedMessages();

        boolean isLandscape();

        boolean keyboardIsOpened();

        void needOpenWebView(MessageObject message, String url, String title, String description, String originalUrl, int w, int h);

        boolean needPlayMessage(MessageObject messageObject);

        void needReloadPolls();

        void onDiceFinished();

        void setShouldNotRepeatSticker(MessageObject message);

        boolean shouldDrawThreadProgress(ChatMessageCell cell);

        boolean shouldRepeatSticker(MessageObject message);

        void videoTimerReached();
    }

    private boolean intersect(float left1, float right1, float left2, float right2) {
        return left1 <= left2 ? right1 >= left2 : left1 <= right2;
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

        static /* synthetic */ float access$2816(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha + f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ float access$2824(BotButton botButton, float f) {
            float f2 = botButton.progressAlpha - f;
            botButton.progressAlpha = f2;
            return f2;
        }

        static /* synthetic */ int access$2916(BotButton botButton, float f) {
            int i = (int) (botButton.angle + f);
            botButton.angle = i;
            return i;
        }

        static /* synthetic */ int access$2920(BotButton botButton, int i) {
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

        static /* synthetic */ int access$1812(PollButton pollButton, int i) {
            int i2 = pollButton.percent + i;
            pollButton.percent = i2;
            return i2;
        }

        static /* synthetic */ float access$2524(PollButton pollButton, float f) {
            float f2 = pollButton.decimal - f;
            pollButton.decimal = f2;
            return f2;
        }
    }

    public ChatMessageCell(Context context) {
        this(context, null);
    }

    public ChatMessageCell(Context context, Theme.ResourcesProvider resourcesProvider) {
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
        this.pollButtons = new ArrayList<>();
        this.botButtons = new ArrayList<>();
        this.botButtonsByData = new HashMap<>();
        this.botButtonsByPosition = new HashMap<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.isCheckPressed = true;
        this.drawBackground = true;
        this.backgroundWidth = 100;
        this.commentButtonRect = new Rect();
        this.forwardedNameLayout = new StaticLayout[2];
        this.forwardNameOffsetX = new float[2];
        this.currentTimeString = "";
        this.drawTime = true;
        this.ALPHA_PROPERTY_WORKAROUND = Build.VERSION.SDK_INT == 28;
        this.alphaInternal = 1.0f;
        this.transitionParams = new TransitionParams();
        this.shouldDrawMenu = true;
        this.diceFinishCallback = new Runnable() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.1
            @Override // java.lang.Runnable
            public void run() {
                if (ChatMessageCell.this.delegate != null) {
                    ChatMessageCell.this.delegate.onDiceFinished();
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.2
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException, NumberFormatException {
                ChatMessageCell.this.checkLocationExpired();
                if (ChatMessageCell.this.locationExpired) {
                    ChatMessageCell.this.invalidate();
                    ChatMessageCell.this.scheduledInvalidate = false;
                    return;
                }
                ChatMessageCell.this.invalidate(((int) r0.rect.left) - 5, ((int) ChatMessageCell.this.rect.top) - 5, ((int) ChatMessageCell.this.rect.right) + 5, ((int) ChatMessageCell.this.rect.bottom) + 5);
                if (ChatMessageCell.this.scheduledInvalidate) {
                    AndroidUtilities.runOnUIThread(ChatMessageCell.this.invalidateRunnable, 1000L);
                }
            }
        };
        this.accessibilityVirtualViewBounds = new SparseArray<>();
        this.currentFocusedVirtualView = -1;
        this.ANIMATION_OFFSET_X = new Property<ChatMessageCell, Float>(Float.class, "animationOffsetX") { // from class: ir.eitaa.ui.Cells.ChatMessageCell.12
            @Override // android.util.Property
            public Float get(ChatMessageCell object) {
                return Float.valueOf(object.animationOffsetX);
            }

            @Override // android.util.Property
            public void set(ChatMessageCell object, Float value) {
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
        this.seekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.3
            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                if (ChatMessageCell.this.currentMessageObject.isMusic()) {
                    return ChatMessageCell.this.seekBar.getProgress();
                }
                if (ChatMessageCell.this.currentMessageObject.isVoice()) {
                    return ChatMessageCell.this.useSeekBarWaweform ? ChatMessageCell.this.seekBarWaveform.getProgress() : ChatMessageCell.this.seekBar.getProgress();
                }
                return 0.0f;
            }

            @Override // ir.eitaa.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float progress) {
                if (ChatMessageCell.this.currentMessageObject.isMusic()) {
                    ChatMessageCell.this.seekBar.setProgress(progress);
                } else {
                    if (!ChatMessageCell.this.currentMessageObject.isVoice()) {
                        return;
                    }
                    if (ChatMessageCell.this.useSeekBarWaweform) {
                        ChatMessageCell.this.seekBarWaveform.setProgress(progress);
                    } else {
                        ChatMessageCell.this.seekBar.setProgress(progress);
                    }
                }
                ChatMessageCell.this.onSeekBarDrag(progress);
                ChatMessageCell.this.invalidate();
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

    /* JADX WARN: Removed duplicated region for block: B:107:0x01ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkTextBlockMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkTextBlockMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkCaptionMotionEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkCaptionMotionEvent(android.view.MotionEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkLinkPreviewMotionEvent(android.view.MotionEvent):boolean");
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
                ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
                if (chatMessageCellDelegate != null) {
                    if (this.lastPoll != null) {
                        MessageObject messageObject = this.currentMessageObject;
                        if (messageObject.scheduled) {
                            Toast.makeText(getContext(), LocaleController.getString("MessageScheduledVoteResults", ir.eitaa.messenger.R.string.MessageScheduledVoteResults), 1).show();
                        } else if (this.pollVoted || this.pollClosed) {
                            chatMessageCellDelegate.didPressInstantButton(this, this.drawInstantViewType);
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
                        chatMessageCellDelegate.didPressInstantButton(this, this.drawInstantViewType);
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
                if (childAt != this && (childAt instanceof ChatMessageCell)) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    if (chatMessageCell.drawCommentButton && chatMessageCell.currentMessagesGroup == this.currentMessagesGroup && (chatMessageCell.currentPosition.flags & 1) != 0) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, event.getActionMasked(), (event.getX() + getLeft()) - chatMessageCell.getLeft(), (event.getY() + getTop()) - chatMessageCell.getTop(), 0);
                        chatMessageCell.checkCommentButtonMotionEvent(motionEventObtain);
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
                ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
                if (chatMessageCellDelegate != null) {
                    if (this.isRepliesChat) {
                        chatMessageCellDelegate.didPressSideButton(this);
                    } else {
                        chatMessageCellDelegate.didPressCommentButton(this);
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkRoundSeekbar(android.view.MotionEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkPhotoImageMotionEvent(android.view.MotionEvent):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkAudioMotionEvent(android.view.MotionEvent):boolean");
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

    /* JADX WARN: Removed duplicated region for block: B:108:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0610  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) throws java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkPinchToZoom(MotionEvent ev) {
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        PinchToZoomHelper pinchToZoomHelper = chatMessageCellDelegate == null ? null : chatMessageCellDelegate.getPinchToZoomHelper();
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

    private boolean checkTextSelection(MotionEvent event) {
        int i;
        int iDp;
        int iDp2;
        MessageObject.GroupedMessages groupedMessages;
        TextSelectionHelper.ChatListTextSelectionHelper textSelectionHelper = this.delegate.getTextSelectionHelper();
        if (textSelectionHelper == null) {
            return false;
        }
        ArrayList<MessageObject.TextLayoutBlock> arrayList = this.currentMessageObject.textLayoutBlocks;
        if (!((arrayList == null || arrayList.isEmpty()) ? false : true) && !hasCaptionLayout()) {
            return false;
        }
        if ((!this.drawSelectionBackground && this.currentMessagesGroup == null) || (this.currentMessagesGroup != null && !this.delegate.hasSelectedMessages())) {
            return false;
        }
        if (this.currentMessageObject.hasValidGroupId() && (groupedMessages = this.currentMessagesGroup) != null && !groupedMessages.isDocuments) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    MessageObject.GroupedMessages currentMessagesGroup = chatMessageCell.getCurrentMessagesGroup();
                    MessageObject.GroupedMessagePosition currentPosition = chatMessageCell.getCurrentPosition();
                    if (currentMessagesGroup != null && currentMessagesGroup.groupId == this.currentMessagesGroup.groupId) {
                        int i3 = currentPosition.flags;
                        if ((i3 & 8) != 0 && (i3 & 1) != 0) {
                            textSelectionHelper.setMaybeTextCord((int) chatMessageCell.captionX, (int) chatMessageCell.captionY);
                            textSelectionHelper.setMessageObject(chatMessageCell);
                            if (chatMessageCell == this) {
                                return textSelectionHelper.onTouchEvent(event);
                            }
                            event.offsetLocation(getLeft() - chatMessageCell.getLeft(), getTop() - chatMessageCell.getTop());
                            boolean zOnTouchEvent = textSelectionHelper.onTouchEvent(event);
                            event.offsetLocation(-(getLeft() - chatMessageCell.getLeft()), -(getTop() - chatMessageCell.getTop()));
                            return zOnTouchEvent;
                        }
                    }
                }
            }
            return false;
        }
        if (hasCaptionLayout()) {
            textSelectionHelper.setIsDescription(false);
            textSelectionHelper.setMaybeTextCord((int) this.captionX, (int) this.captionY);
        } else if (this.descriptionLayout != null && event.getY() > this.descriptionY) {
            textSelectionHelper.setIsDescription(true);
            if (this.hasGamePreview) {
                iDp2 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    i = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                } else {
                    i = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                }
                iDp2 = i + iDp;
            }
            textSelectionHelper.setMaybeTextCord(iDp2 + AndroidUtilities.dp(10.0f) + this.descriptionX, this.descriptionY);
        } else {
            textSelectionHelper.setIsDescription(false);
            textSelectionHelper.setMaybeTextCord(this.textX, this.textY);
        }
        textSelectionHelper.setMessageObject(this);
        return textSelectionHelper.onTouchEvent(event);
    }

    private void updateSelectionTextPosition() {
        int i;
        int iDp;
        int iDp2;
        if (getDelegate().getTextSelectionHelper() == null || !getDelegate().getTextSelectionHelper().isSelected(this.currentMessageObject)) {
            return;
        }
        int textSelectionType = getDelegate().getTextSelectionHelper().getTextSelectionType(this);
        if (textSelectionType == TextSelectionHelper.ChatListTextSelectionHelper.TYPE_DESCRIPTION) {
            if (this.hasGamePreview) {
                iDp2 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    i = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                } else {
                    i = this.unmovedTextX;
                    iDp = AndroidUtilities.dp(1.0f);
                }
                iDp2 = i + iDp;
            }
            getDelegate().getTextSelectionHelper().updateTextPosition(iDp2 + AndroidUtilities.dp(10.0f) + this.descriptionX, this.descriptionY);
            return;
        }
        if (textSelectionType == TextSelectionHelper.ChatListTextSelectionHelper.TYPE_CAPTION) {
            getDelegate().getTextSelectionHelper().updateTextPosition((int) this.captionX, (int) this.captionY);
        } else {
            getDelegate().getTextSelectionHelper().updateTextPosition(this.textX, this.textY);
        }
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

    public void setParentViewSize(int parentW, int parentH) {
        Theme.MessageDrawable messageDrawable;
        this.parentWidth = parentW;
        this.parentHeight = parentH;
        this.backgroundHeight = parentH;
        if ((this.currentMessageObject == null || (!(hasGradientService() && this.currentMessageObject.shouldDrawWithoutBackground()) && this.drawSideButton == 0 && this.botButtons.isEmpty())) && ((messageDrawable = this.currentBackgroundDrawable) == null || messageDrawable.getGradientShader() == null)) {
            return;
        }
        invalidate();
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
                MediaController.getInstance().lambda$startAudioAgain$7(this.currentMessageObject);
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
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            }
            if (z) {
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.isPhotoDataChanged(ir.eitaa.messenger.MessageObject):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.isUserDataChanged():boolean");
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
        if (getDelegate().getTextSelectionHelper() != null) {
            getDelegate().getTextSelectionHelper().onChatMessageCellDetached(this);
        }
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
    protected void onAttachedToWindow() throws Resources.NotFoundException, NumberFormatException {
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
        if (getDelegate().getTextSelectionHelper() != null) {
            getDelegate().getTextSelectionHelper().onChatMessageCellAttached(this);
        }
        if (this.documentAttachType == 5) {
            this.toSeekBarProgress = MediaController.getInstance().isPlayingMessage(this.currentMessageObject) ? 1.0f : 0.0f;
        }
    }

    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 6051 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1005:0x12c7  */
    /* JADX WARN: Removed duplicated region for block: B:1007:0x12cb  */
    /* JADX WARN: Removed duplicated region for block: B:1016:0x12e3  */
    /* JADX WARN: Removed duplicated region for block: B:1018:0x12eb  */
    /* JADX WARN: Removed duplicated region for block: B:1205:0x17bf  */
    /* JADX WARN: Removed duplicated region for block: B:1218:0x17e3  */
    /* JADX WARN: Removed duplicated region for block: B:1221:0x1805  */
    /* JADX WARN: Removed duplicated region for block: B:1232:0x1826  */
    /* JADX WARN: Removed duplicated region for block: B:1248:0x1862  */
    /* JADX WARN: Removed duplicated region for block: B:1267:0x1896  */
    /* JADX WARN: Removed duplicated region for block: B:1270:0x18aa  */
    /* JADX WARN: Removed duplicated region for block: B:1271:0x18b1  */
    /* JADX WARN: Removed duplicated region for block: B:1293:0x18f0  */
    /* JADX WARN: Removed duplicated region for block: B:1294:0x18f7  */
    /* JADX WARN: Removed duplicated region for block: B:1297:0x1903  */
    /* JADX WARN: Removed duplicated region for block: B:1300:0x190d  */
    /* JADX WARN: Removed duplicated region for block: B:1305:0x1916  */
    /* JADX WARN: Removed duplicated region for block: B:1307:0x1922  */
    /* JADX WARN: Removed duplicated region for block: B:1352:0x19e6  */
    /* JADX WARN: Removed duplicated region for block: B:1355:0x19eb  */
    /* JADX WARN: Removed duplicated region for block: B:1359:0x1a16  */
    /* JADX WARN: Removed duplicated region for block: B:1365:0x1a46  */
    /* JADX WARN: Removed duplicated region for block: B:1368:0x1a8b  */
    /* JADX WARN: Removed duplicated region for block: B:1370:0x1ab9  */
    /* JADX WARN: Removed duplicated region for block: B:1487:0x1e41  */
    /* JADX WARN: Removed duplicated region for block: B:1491:0x1e70  */
    /* JADX WARN: Removed duplicated region for block: B:1493:0x1e74  */
    /* JADX WARN: Removed duplicated region for block: B:1521:0x1fa9  */
    /* JADX WARN: Removed duplicated region for block: B:1612:0x2218  */
    /* JADX WARN: Removed duplicated region for block: B:1613:0x221b  */
    /* JADX WARN: Removed duplicated region for block: B:1616:0x222e  */
    /* JADX WARN: Removed duplicated region for block: B:1618:0x2237  */
    /* JADX WARN: Removed duplicated region for block: B:1641:0x22fe  */
    /* JADX WARN: Removed duplicated region for block: B:1648:0x2329  */
    /* JADX WARN: Removed duplicated region for block: B:1651:0x2336  */
    /* JADX WARN: Removed duplicated region for block: B:1652:0x233a  */
    /* JADX WARN: Removed duplicated region for block: B:2077:0x2cd4  */
    /* JADX WARN: Removed duplicated region for block: B:2084:0x2d07  */
    /* JADX WARN: Removed duplicated region for block: B:2087:0x2d0c  */
    /* JADX WARN: Removed duplicated region for block: B:2096:0x2d31  */
    /* JADX WARN: Removed duplicated region for block: B:2108:0x2d6f  */
    /* JADX WARN: Removed duplicated region for block: B:2109:0x2d81  */
    /* JADX WARN: Removed duplicated region for block: B:2139:0x2e03  */
    /* JADX WARN: Removed duplicated region for block: B:2142:0x2e0d  */
    /* JADX WARN: Removed duplicated region for block: B:2176:0x3017  */
    /* JADX WARN: Removed duplicated region for block: B:2206:0x316a  */
    /* JADX WARN: Removed duplicated region for block: B:2231:0x3231  */
    /* JADX WARN: Removed duplicated region for block: B:2241:0x3248  */
    /* JADX WARN: Removed duplicated region for block: B:2244:0x3264  */
    /* JADX WARN: Removed duplicated region for block: B:2383:0x36cc  */
    /* JADX WARN: Removed duplicated region for block: B:2389:0x36f9  */
    /* JADX WARN: Removed duplicated region for block: B:2431:0x37f8  */
    /* JADX WARN: Removed duplicated region for block: B:2442:0x3820  */
    /* JADX WARN: Removed duplicated region for block: B:2446:0x382e  */
    /* JADX WARN: Removed duplicated region for block: B:2447:0x383c  */
    /* JADX WARN: Removed duplicated region for block: B:2460:0x386b  */
    /* JADX WARN: Removed duplicated region for block: B:2465:0x3876  */
    /* JADX WARN: Removed duplicated region for block: B:2486:0x38c4  */
    /* JADX WARN: Removed duplicated region for block: B:2489:0x38d2  */
    /* JADX WARN: Removed duplicated region for block: B:2496:0x38e0  */
    /* JADX WARN: Removed duplicated region for block: B:2497:0x38e3  */
    /* JADX WARN: Removed duplicated region for block: B:2522:0x3930  */
    /* JADX WARN: Removed duplicated region for block: B:2537:0x397b A[PHI: r3 r4
      0x397b: PHI (r3v219 int) = (r3v70 int), (r3v70 int), (r3v74 int), (r3v70 int) binds: [B:2518:0x3921, B:3655:0x397b, B:2533:0x3964, B:2516:0x391b] A[DONT_GENERATE, DONT_INLINE]
      0x397b: PHI (r4v184 int) = (r4v27 int), (r4v27 int), (r4v30 int), (r4v27 int) binds: [B:2518:0x3921, B:3655:0x397b, B:2533:0x3964, B:2516:0x391b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:2539:0x397e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2540:0x3980  */
    /* JADX WARN: Removed duplicated region for block: B:2555:0x39bd  */
    /* JADX WARN: Removed duplicated region for block: B:2562:0x39ff  */
    /* JADX WARN: Removed duplicated region for block: B:2565:0x3a0b  */
    /* JADX WARN: Removed duplicated region for block: B:2568:0x3a38  */
    /* JADX WARN: Removed duplicated region for block: B:2569:0x3a3b  */
    /* JADX WARN: Removed duplicated region for block: B:2572:0x3a43  */
    /* JADX WARN: Removed duplicated region for block: B:2573:0x3a46  */
    /* JADX WARN: Removed duplicated region for block: B:2576:0x3a50  */
    /* JADX WARN: Removed duplicated region for block: B:2579:0x3a57  */
    /* JADX WARN: Removed duplicated region for block: B:2580:0x3a69  */
    /* JADX WARN: Removed duplicated region for block: B:2590:0x3a93  */
    /* JADX WARN: Removed duplicated region for block: B:2746:0x3db9  */
    /* JADX WARN: Removed duplicated region for block: B:2767:0x3e1e  */
    /* JADX WARN: Removed duplicated region for block: B:2818:0x3f44  */
    /* JADX WARN: Removed duplicated region for block: B:2822:0x3f5d  */
    /* JADX WARN: Removed duplicated region for block: B:2829:0x3f72  */
    /* JADX WARN: Removed duplicated region for block: B:2831:0x3f7d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2833:0x3f80  */
    /* JADX WARN: Removed duplicated region for block: B:2837:0x3f9b  */
    /* JADX WARN: Removed duplicated region for block: B:2840:0x3fa8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2853:0x401d  */
    /* JADX WARN: Removed duplicated region for block: B:2865:0x4060  */
    /* JADX WARN: Removed duplicated region for block: B:2866:0x408b  */
    /* JADX WARN: Removed duplicated region for block: B:2869:0x40a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:2873:0x40af  */
    /* JADX WARN: Removed duplicated region for block: B:2880:0x40be  */
    /* JADX WARN: Removed duplicated region for block: B:2913:0x4112  */
    /* JADX WARN: Removed duplicated region for block: B:2923:0x41c3  */
    /* JADX WARN: Removed duplicated region for block: B:3076:0x456e  */
    /* JADX WARN: Removed duplicated region for block: B:3085:0x458c  */
    /* JADX WARN: Removed duplicated region for block: B:3103:0x45db  */
    /* JADX WARN: Removed duplicated region for block: B:3116:0x462b  */
    /* JADX WARN: Removed duplicated region for block: B:3119:0x4634  */
    /* JADX WARN: Removed duplicated region for block: B:3122:0x4641  */
    /* JADX WARN: Removed duplicated region for block: B:3123:0x4651  */
    /* JADX WARN: Removed duplicated region for block: B:3126:0x4664  */
    /* JADX WARN: Removed duplicated region for block: B:3155:0x46dc  */
    /* JADX WARN: Removed duplicated region for block: B:3159:0x46ec  */
    /* JADX WARN: Removed duplicated region for block: B:3161:0x46f2  */
    /* JADX WARN: Removed duplicated region for block: B:3186:0x4793 A[Catch: Exception -> 0x47e1, TryCatch #7 {Exception -> 0x47e1, blocks: (B:3178:0x4762, B:3180:0x476d, B:3182:0x4773, B:3184:0x478d, B:3186:0x4793, B:3188:0x479b, B:3190:0x47a3, B:3192:0x47cd), top: B:3519:0x4762 }] */
    /* JADX WARN: Removed duplicated region for block: B:3198:0x47e9  */
    /* JADX WARN: Removed duplicated region for block: B:3200:0x47ef  */
    /* JADX WARN: Removed duplicated region for block: B:3204:0x47f8  */
    /* JADX WARN: Removed duplicated region for block: B:3210:0x4814  */
    /* JADX WARN: Removed duplicated region for block: B:3254:0x4940  */
    /* JADX WARN: Removed duplicated region for block: B:3257:0x4947  */
    /* JADX WARN: Removed duplicated region for block: B:3267:0x497c  */
    /* JADX WARN: Removed duplicated region for block: B:3354:0x4cd6  */
    /* JADX WARN: Removed duplicated region for block: B:3357:0x4cdf  */
    /* JADX WARN: Removed duplicated region for block: B:3364:0x4cfc  */
    /* JADX WARN: Removed duplicated region for block: B:3367:0x4d0a  */
    /* JADX WARN: Removed duplicated region for block: B:3368:0x4d0c  */
    /* JADX WARN: Removed duplicated region for block: B:3369:0x4d18  */
    /* JADX WARN: Removed duplicated region for block: B:3381:0x4d3c  */
    /* JADX WARN: Removed duplicated region for block: B:3384:0x4d55  */
    /* JADX WARN: Removed duplicated region for block: B:3386:0x4d5b  */
    /* JADX WARN: Removed duplicated region for block: B:3389:0x4d72  */
    /* JADX WARN: Removed duplicated region for block: B:3392:0x4d7d  */
    /* JADX WARN: Removed duplicated region for block: B:3399:0x4db0  */
    /* JADX WARN: Removed duplicated region for block: B:3401:0x4db8  */
    /* JADX WARN: Removed duplicated region for block: B:3449:0x4e2f A[PHI: r3 r5 r6 r7
      0x4e2f: PHI (r3v619 int) = (r3v618 int), (r3v618 int), (r3v625 int) binds: [B:3434:0x4e0f, B:3436:0x4e13, B:3447:0x4e2b] A[DONT_GENERATE, DONT_INLINE]
      0x4e2f: PHI (r5v431 int) = (r5v430 int), (r5v430 int), (r5v441 int) binds: [B:3434:0x4e0f, B:3436:0x4e13, B:3447:0x4e2b] A[DONT_GENERATE, DONT_INLINE]
      0x4e2f: PHI (r6v353 int) = (r6v352 int), (r6v352 int), (r6v357 int) binds: [B:3434:0x4e0f, B:3436:0x4e13, B:3447:0x4e2b] A[DONT_GENERATE, DONT_INLINE]
      0x4e2f: PHI (r7v228 int) = (r7v227 int), (r7v227 int), (r7v233 int) binds: [B:3434:0x4e0f, B:3436:0x4e13, B:3447:0x4e2b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:3452:0x4e34  */
    /* JADX WARN: Removed duplicated region for block: B:3458:0x4e43  */
    /* JADX WARN: Removed duplicated region for block: B:3467:0x4e5b  */
    /* JADX WARN: Removed duplicated region for block: B:3470:0x4e63  */
    /* JADX WARN: Removed duplicated region for block: B:3483:0x4eab  */
    /* JADX WARN: Removed duplicated region for block: B:3486:0x4eb3  */
    /* JADX WARN: Removed duplicated region for block: B:3489:0x4ebf  */
    /* JADX WARN: Removed duplicated region for block: B:3498:0x4ef4  */
    /* JADX WARN: Removed duplicated region for block: B:3550:0x0eac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:3552:0x3e34 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0bb4  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x0be1  */
    /* JADX WARN: Removed duplicated region for block: B:646:0x0c0a  */
    /* JADX WARN: Removed duplicated region for block: B:653:0x0c45  */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0c4c  */
    /* JADX WARN: Removed duplicated region for block: B:660:0x0c65  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0cb5  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0cbb  */
    /* JADX WARN: Removed duplicated region for block: B:679:0x0cd3  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0cef  */
    /* JADX WARN: Removed duplicated region for block: B:687:0x0cfa  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x0da6  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x0dab  */
    /* JADX WARN: Removed duplicated region for block: B:747:0x0dc4  */
    /* JADX WARN: Removed duplicated region for block: B:750:0x0dc9  */
    /* JADX WARN: Removed duplicated region for block: B:763:0x0de7  */
    /* JADX WARN: Removed duplicated region for block: B:765:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:780:0x0e55  */
    /* JADX WARN: Removed duplicated region for block: B:781:0x0e5f  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x0e92  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x0e94  */
    /* JADX WARN: Removed duplicated region for block: B:824:0x0f51  */
    /* JADX WARN: Removed duplicated region for block: B:827:0x0f59  */
    /* JADX WARN: Removed duplicated region for block: B:877:0x105f A[Catch: Exception -> 0x107b, TryCatch #16 {Exception -> 0x107b, blocks: (B:875:0x105b, B:878:0x1066, B:877:0x105f, B:872:0x1047), top: B:3538:0x105b }] */
    /* JADX WARN: Removed duplicated region for block: B:899:0x10c0  */
    /* JADX WARN: Removed duplicated region for block: B:903:0x10ce  */
    /* JADX WARN: Removed duplicated region for block: B:905:0x10db A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:929:0x1180  */
    /* JADX WARN: Removed duplicated region for block: B:931:0x1183  */
    /* JADX WARN: Removed duplicated region for block: B:950:0x11e5 A[Catch: Exception -> 0x12be, TryCatch #14 {Exception -> 0x12be, blocks: (B:945:0x11b9, B:949:0x11d5, B:955:0x1208, B:956:0x1220, B:958:0x1228, B:960:0x1236, B:962:0x123a, B:963:0x123e, B:965:0x1246, B:966:0x1249, B:967:0x1250, B:969:0x1258, B:971:0x1266, B:973:0x126a, B:975:0x126f, B:996:0x12b3, B:979:0x1278, B:950:0x11e5, B:954:0x11fc), top: B:3534:0x11b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:983:0x128c  */
    /* JADX WARN: Removed duplicated region for block: B:987:0x1294 A[Catch: Exception -> 0x12ba, TryCatch #17 {Exception -> 0x12ba, blocks: (B:985:0x1290, B:988:0x129b, B:991:0x12a0, B:993:0x12a9, B:987:0x1294, B:981:0x1281), top: B:3540:0x1290 }] */
    /* JADX WARN: Removed duplicated region for block: B:990:0x129e  */
    /* JADX WARN: Type inference failed for: r12v168 */
    /* JADX WARN: Type inference failed for: r12v169 */
    /* JADX WARN: Type inference failed for: r12v228 */
    /* JADX WARN: Type inference failed for: r12v229 */
    /* JADX WARN: Type inference failed for: r12v230 */
    /* JADX WARN: Type inference failed for: r12v231 */
    /* JADX WARN: Type inference failed for: r12v232 */
    /* JADX WARN: Type inference failed for: r12v233 */
    /* JADX WARN: Type inference failed for: r12v234 */
    /* JADX WARN: Type inference failed for: r12v235 */
    /* JADX WARN: Type inference failed for: r12v236 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v847 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageContent(ir.eitaa.messenger.MessageObject r69, ir.eitaa.messenger.MessageObject.GroupedMessages r70, boolean r71, boolean r72) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 20242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.setMessageContent(ir.eitaa.messenger.MessageObject, ir.eitaa.messenger.MessageObject$GroupedMessages, boolean, boolean):void");
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
                this.videoPlayerRewinder = new VideoPlayerRewinder() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.4
                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindCanceled() throws InterruptedException, IOException {
                        ChatMessageCell.this.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        ChatMessageCell.this.videoForwardDrawable.setShowing(false);
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void updateRewindProgressUi(long timeDiff, float progress, boolean rewindByBackSeek) {
                        ChatMessageCell.this.videoForwardDrawable.setTime(Math.abs(timeDiff));
                        if (rewindByBackSeek) {
                            ChatMessageCell.this.currentMessageObject.audioProgress = progress;
                            ChatMessageCell.this.updatePlayingMessageProgress();
                        }
                    }

                    @Override // ir.eitaa.messenger.video.VideoPlayerRewinder
                    protected void onRewindStart(boolean rewindForward) {
                        ChatMessageCell.this.videoForwardDrawable.setDelegate(new VideoForwardDrawable.VideoForwardDrawableDelegate() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.4.1
                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void onAnimationEnd() {
                            }

                            @Override // ir.eitaa.ui.Components.VideoForwardDrawable.VideoForwardDrawableDelegate
                            public void invalidate() {
                                ChatMessageCell.this.invalidate();
                            }
                        });
                        ChatMessageCell.this.videoForwardDrawable.setOneShootAnimation(false);
                        ChatMessageCell.this.videoForwardDrawable.setLeftSide(!rewindForward);
                        ChatMessageCell.this.videoForwardDrawable.setShowing(true);
                        ChatMessageCell.this.invalidate();
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
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        if (chatMessageCellDelegate != null) {
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
                        zDidLongPressChannelAvatar = chatMessageCellDelegate.didLongPressChannelAvatar(this, tLRPC$Chat, i, this.lastTouchX, this.lastTouchY);
                    }
                } else if (tLRPC$User.id != 0) {
                    zDidLongPressChannelAvatar = chatMessageCellDelegate.didLongPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
                }
            }
            if (!zDidLongPressChannelAvatar) {
                this.delegate.didLongPress(this, this.lastTouchX, this.lastTouchY);
            }
        }
        return true;
    }

    public void showHintButton(boolean show, boolean animated, int type) {
        if (type == -1 || type == 0) {
            if (this.hintButtonVisible == show) {
                return;
            }
            this.hintButtonVisible = show;
            if (!animated) {
                this.hintButtonProgress = show ? 1.0f : 0.0f;
            } else {
                invalidate();
            }
        }
        if ((type == -1 || type == 1) && this.psaButtonVisible != show) {
            this.psaButtonVisible = show;
            if (!animated) {
                this.psaButtonProgress = show ? 1.0f : 0.0f;
            } else {
                setInvalidatesParent(true);
                invalidate();
            }
        }
    }

    public void setCheckPressed(boolean value, boolean pressed) {
        this.isCheckPressed = value;
        this.isPressed = pressed;
        updateRadialProgressBackground();
        if (this.useSeekBarWaweform) {
            this.seekBarWaveform.setSelected(isDrawSelectionBackground());
        } else {
            this.seekBar.setSelected(isDrawSelectionBackground());
        }
        invalidate();
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

    public boolean isHighlightedAnimated() {
        return this.isHighlightedAnimated;
    }

    public void setHighlightedAnimated() {
        this.isHighlightedAnimated = true;
        this.highlightProgress = 1000;
        this.lastHighlightProgressTime = System.currentTimeMillis();
        invalidate();
        if (getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isHighlighted() {
        return this.isHighlighted;
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

    public boolean isAnimatingPollAnswer() {
        return this.animatePollAnswerAlpha;
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
        int iDp = maxWidth;
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
            this.widthBeforeNewTimeLine = (iDp - AndroidUtilities.dp(94.0f)) - ((int) Math.ceil(Theme.chat_audioTimePaint.measureText("00:00")));
            this.availableTimeWidth = iDp - AndroidUtilities.dp(18.0f);
            measureTime(messageObject);
            int iDp2 = AndroidUtilities.dp(174.0f) + this.timeWidth;
            if (!this.hasLinkPreview) {
                this.backgroundWidth = Math.min(iDp, iDp2 + ((int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatLongDuration(i)))));
            }
            this.seekBarWaveform.setMessageObject(messageObject);
            return 0;
        }
        if (MessageObject.isMusicDocument(this.documentAttach)) {
            this.documentAttachType = 5;
            int iDp3 = iDp - AndroidUtilities.dp(92.0f);
            if (iDp3 < 0) {
                iDp3 = AndroidUtilities.dp(100.0f);
            }
            int i4 = iDp3;
            StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicTitle().replace('\n', ' '), Theme.chat_audioTitlePaint, i4 - AndroidUtilities.dp(12.0f), TextUtils.TruncateAt.END), Theme.chat_audioTitlePaint, i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.songLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.songX = -((int) Math.ceil(this.songLayout.getLineLeft(0)));
            }
            StaticLayout staticLayout2 = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicAuthor().replace('\n', ' '), Theme.chat_audioPerformerPaint, i4, TextUtils.TruncateAt.END), Theme.chat_audioPerformerPaint, i4, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.performerLayout = staticLayout2;
            if (staticLayout2.getLineCount() > 0) {
                this.performerX = -((int) Math.ceil(this.performerLayout.getLineLeft(0)));
            }
            int i5 = 0;
            while (true) {
                if (i5 >= this.documentAttach.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.documentAttach.attributes.get(i5);
                if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                    i2 = tLRPC$DocumentAttribute2.duration;
                    break;
                }
                i5++;
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
        if (!z) {
            iDp += AndroidUtilities.dp(30.0f);
        }
        this.documentAttachType = 1;
        String documentFileName = FileLoader.getDocumentFileName(this.documentAttach);
        if (documentFileName.length() == 0) {
            documentFileName = LocaleController.getString("AttachDocument", ir.eitaa.messenger.R.string.AttachDocument);
        }
        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(documentFileName, Theme.chat_docNamePaint, iDp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.MIDDLE, iDp, 2, false);
        this.docTitleLayout = staticLayoutCreateStaticLayout;
        this.docTitleOffsetX = Integer.MIN_VALUE;
        if (staticLayoutCreateStaticLayout != null && staticLayoutCreateStaticLayout.getLineCount() > 0) {
            int iMax = 0;
            while (i2 < this.docTitleLayout.getLineCount()) {
                iMax = Math.max(iMax, (int) Math.ceil(this.docTitleLayout.getLineWidth(i2)));
                this.docTitleOffsetX = Math.max(this.docTitleOffsetX, (int) Math.ceil(-this.docTitleLayout.getLineLeft(i2)));
                i2++;
            }
            iMin = Math.min(iDp, iMax);
        } else {
            this.docTitleOffsetX = 0;
            iMin = iDp;
        }
        String str4 = AndroidUtilities.formatFileSize(this.documentAttach.size) + " " + FileLoader.getDocumentExtension(this.documentAttach);
        int iDp4 = iDp - AndroidUtilities.dp(30.0f);
        TextPaint textPaint = Theme.chat_infoPaint;
        int iMin2 = Math.min(iDp4, (int) Math.ceil(textPaint.measureText("000.0 mm / " + AndroidUtilities.formatFileSize(this.documentAttach.size))));
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
    public void checkLocationExpired() throws Resources.NotFoundException, NumberFormatException {
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

    public void setMessageObject(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, boolean bottomNear, boolean topNear) throws Resources.NotFoundException, NumberFormatException {
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
            Drawable drawable = new Drawable() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.5
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
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.AnonymousClass5.draw(android.graphics.Canvas):void");
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Resources.NotFoundException, NumberFormatException {
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
    }

    public void forceResetMessageObject() throws Resources.NotFoundException, NumberFormatException {
        MessageObject messageObject = this.messageObjectToSet;
        if (messageObject == null) {
            messageObject = this.currentMessageObject;
        }
        this.currentMessageObject = null;
        setMessageObject(messageObject, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
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
            this.timeLayout = new StaticLayout(this.currentTimeString, Theme.chat_timePaint, AndroidUtilities.dp(100.0f) + this.timeTextWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
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
            int iDp7 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp7;
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i5 = this.buttonX;
            radialProgress2.setProgressRect(i5, iDp7, AndroidUtilities.dp(44.0f) + i5, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i4 == 5) {
            if (this.currentMessageObject.isOutOwner()) {
                this.seekBarX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(56.0f);
                this.buttonX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
                this.timeAudioX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(67.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                this.seekBarX = AndroidUtilities.dp(113.0f);
                this.buttonX = AndroidUtilities.dp(71.0f);
                this.timeAudioX = AndroidUtilities.dp(124.0f);
            } else {
                this.seekBarX = AndroidUtilities.dp(65.0f);
                this.buttonX = AndroidUtilities.dp(23.0f);
                this.timeAudioX = AndroidUtilities.dp(76.0f);
            }
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
            if (this.currentMessageObject.isOutOwner()) {
                this.buttonX = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                this.buttonX = AndroidUtilities.dp(71.0f);
            } else {
                this.buttonX = AndroidUtilities.dp(23.0f);
            }
            if (this.hasLinkPreview) {
                this.buttonX += AndroidUtilities.dp(10.0f);
            }
            int iDp9 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp9;
            RadialProgress2 radialProgress23 = this.radialProgress;
            int i7 = this.buttonX;
            radialProgress23.setProgressRect(i7, iDp9, AndroidUtilities.dp(44.0f) + i7, this.buttonY + AndroidUtilities.dp(44.0f));
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
                iDp += (int) Math.ceil((r2 / 1000.0f) * getGroupPhotosWidth());
            }
        }
        if (this.currentMessageObject.type != 0) {
            iDp -= AndroidUtilities.dp(2.0f);
        }
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.imageChangeBoundsTransition || transitionParams.updatePhotoImageX) {
            transitionParams.updatePhotoImageX = false;
            ImageReceiver imageReceiver = this.photoImage;
            imageReceiver.setImageCoords(iDp, imageReceiver.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
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
            radialProgress25.setProgressRect(i11, imageY2, AndroidUtilities.dp(24.0f) + i11, this.videoButtonY + AndroidUtilities.dp(24.0f));
        }
    }

    public boolean needDelayRoundProgressDraw() {
        int i = this.documentAttachType;
        return (i == 7 || i == 4) && this.currentMessageObject.type != 5 && MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawRoundProgress(android.graphics.Canvas):void");
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.updatePollAnimations(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:350:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0830  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0913  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawContent(android.graphics.Canvas r32) {
        /*
            Method dump skipped, instructions count: 4184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawContent(android.graphics.Canvas):void");
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
                    ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
                    if (chatMessageCellDelegate == null || chatMessageCellDelegate.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
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
                    ChatMessageCellDelegate chatMessageCellDelegate2 = this.delegate;
                    if (chatMessageCellDelegate2 == null || chatMessageCellDelegate2.getPinchToZoomHelper() == null || !this.delegate.getPinchToZoomHelper().isInOverlayModeFor(this)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldDrawMenuDrawable() {
        return (this.currentMessagesGroup == null || (this.currentPosition.flags & 4) != 0) && this.shouldDrawMenu;
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
                                BotButton.access$2916(botButton2, (360 * j) / 2000.0f);
                                BotButton.access$2920(botButton2, (botButton2.angle / 360) * 360);
                                if (z2) {
                                    if (botButton2.progressAlpha < 1.0f) {
                                        BotButton.access$2816(botButton2, j / 200.0f);
                                        if (botButton2.progressAlpha > 1.0f) {
                                            botButton2.progressAlpha = 1.0f;
                                        }
                                    }
                                } else if (botButton2.progressAlpha > 0.0f) {
                                    BotButton.access$2824(botButton2, j / 200.0f);
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
    /* JADX WARN: Removed duplicated region for block: B:54:0x0131 A[LOOP:1: B:52:0x0129->B:54:0x0131, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0158 A[LOOP:2: B:61:0x0150->B:63:0x0158, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"Range"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawMessageText(android.graphics.Canvas r18, java.util.ArrayList<ir.eitaa.messenger.MessageObject.TextLayoutBlock> r19, boolean r20, float r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawMessageText(android.graphics.Canvas, java.util.ArrayList, boolean, float, boolean):void");
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

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getMaxNameWidth() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.getMaxNameWidth():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateButtonState(boolean r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 2121
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.updateButtonState(boolean, boolean, boolean):void");
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
                final Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ChatMessageCell$0SANHF3k4g4K2xe5IEeYnz5cY_4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didPressButton$1$ChatMessageCell();
                    }
                };
                if (MediaController.getInstance().getPlayingMessageObject() != null) {
                    if (f > 0.0f && !this.currentMessageObject.equals(MediaController.getInstance().getPlayingMessageObject())) {
                        final SharedPreferences sharedPreferences2 = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                        try {
                            int i3 = sharedPreferences2.getInt("playerResumeOption", 0);
                            if (i3 == 0) {
                                final boolean[] zArr = new boolean[1];
                                final CheckBoxCell checkBoxCell = new CheckBoxCell(getContext(), 2);
                                checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                                checkBoxCell.setText(LocaleController.getString("UseByDefault", ir.eitaa.messenger.R.string.UseByDefault), "", false, false);
                                checkBoxCell.setTextColor(Theme.getColor("dialogTextBlack"));
                                checkBoxCell.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                                checkBoxCell.setLayoutParams(LayoutHelper.createLinear(-1, 48, 51, 0, 0, 0, 0));
                                checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ChatMessageCell$6IOs9qI8lREUNAYYHe1pNf4ZzXo
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        ChatMessageCell.lambda$didPressButton$2(zArr, checkBoxCell, view);
                                    }
                                });
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setView(checkBoxCell);
                                builder.setTitle(fileName);
                                builder.setPositiveButton(LocaleController.getString("Resume", ir.eitaa.messenger.R.string.Resume), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.6
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
                                builder.setNegativeButton(LocaleController.getString("StartOver", ir.eitaa.messenger.R.string.StartOver), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.7
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
                if (f > 0.0f) {
                    final SharedPreferences sharedPreferences3 = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0);
                    try {
                        int i4 = sharedPreferences3.getInt("playerResumeOption", 0);
                        if (i4 == 0) {
                            final boolean[] zArr2 = new boolean[1];
                            final CheckBoxCell checkBoxCell2 = new CheckBoxCell(getContext(), 2);
                            checkBoxCell2.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                            checkBoxCell2.setText(LocaleController.getString("UseByDefault", ir.eitaa.messenger.R.string.UseByDefault), "", false, false);
                            checkBoxCell2.setTextColor(Theme.getColor("dialogTextBlack"));
                            checkBoxCell2.setPadding(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
                            checkBoxCell2.setLayoutParams(LayoutHelper.createLinear(-1, 48, 51, 0, 0, 0, 0));
                            checkBoxCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ChatMessageCell$HnnNGN7S1SvA0-NNDWvowYKsfQE
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    ChatMessageCell.lambda$didPressButton$3(zArr2, checkBoxCell2, view);
                                }
                            });
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                            builder2.setView(checkBoxCell2);
                            builder2.setTitle(fileName);
                            builder2.setPositiveButton(LocaleController.getString("Resume", ir.eitaa.messenger.R.string.Resume), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.8
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
                            builder2.setNegativeButton(LocaleController.getString("StartOver", ir.eitaa.messenger.R.string.StartOver), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.9
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialog, int which) {
                                    if (zArr2[0]) {
                                        sharedPreferences3.edit().putInt("playerResumeOption", 2).apply();
                                    }
                                    dialog.dismiss();
                                    runnable.run();
                                }
                            });
                            builder2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.10
                                @Override // android.content.DialogInterface.OnCancelListener
                                public void onCancel(DialogInterface dialogInterface) {
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
                if (MediaController.getInstance().lambda$startAudioAgain$7(this.currentMessageObject)) {
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
    public /* synthetic */ void lambda$didPressButton$1$ChatMessageCell() {
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
    public void onFailedDownload(String fileName, boolean canceled) {
        int i = this.documentAttachType;
        updateButtonState(true, i == 3 || i == 5, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0119  */
    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSuccessDownload(java.lang.String r22) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.onSuccessDownload(java.lang.String):void");
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
                        ((SlotsDrawable) rLottieDrawable).setDiceNumber(this, diceValue, stickerSetByEmojiOrName, instant);
                        if (this.currentMessageObject.isOut()) {
                            rLottieDrawable.setOnFinishCallback(this.diceFinishCallback, ConnectionsManager.DEFAULT_DATACENTER_ID);
                        }
                        this.currentMessageObject.wasUnread = false;
                    }
                    if (!rLottieDrawable.hasBaseDice() && stickerSetByEmojiOrName.documents.size() > 0) {
                        ((SlotsDrawable) rLottieDrawable).setBaseDice(this, stickerSetByEmojiOrName);
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.createLoadingProgressLayout(long, long):void");
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

    public void setDelegate(ChatMessageCellDelegate chatMessageCellDelegate) {
        this.delegate = chatMessageCellDelegate;
    }

    public ChatMessageCellDelegate getDelegate() {
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
            Method dump skipped, instructions count: 863
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.measureTime(ir.eitaa.messenger.MessageObject):void");
    }

    private boolean isDrawSelectionBackground() {
        return ((isPressed() && this.isCheckPressed) || ((!this.isCheckPressed && this.isPressed) || this.isHighlighted)) && !textIsSelectionMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpenChatByShare(MessageObject messageObject) {
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
        return (tLRPC$MessageFwdHeader == null || tLRPC$MessageFwdHeader.saved_from_peer == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkNeedDrawShareButton(ir.eitaa.messenger.MessageObject r8) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.checkNeedDrawShareButton(ir.eitaa.messenger.MessageObject):boolean");
    }

    public boolean isInsideBackground(float x, float y) {
        if (this.currentBackgroundDrawable != null) {
            if (x >= this.backgroundDrawableLeft && x <= r3 + this.backgroundDrawableRight) {
                return true;
            }
        }
        return false;
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

    /* JADX WARN: Can't wrap try/catch for region: R(20:244|(2:248|(1:250))|251|(1:253)(2:254|(1:256))|257|(9:263|(3:265|(3:267|(1:269)(1:270)|271)(1:272)|273)(1:274)|(1:276)|(1:294)(3:289|(1:291)(1:292)|293)|295|(2:298|(2:300|(1:302)(1:311))(2:303|(2:305|(1:307)(0))(2:308|(1:310)(0))))|(1:313)|314|(1:316)(2:317|(1:319)(2:320|(3:322|(1:324)(1:325)|326)(2:327|(1:336)(3:331|(1:333)(1:334)|335)))))(6:338|(1:340)(2:341|(1:343)(2:344|(1:346)))|347|(1:349)|350|(7:358|(1:(1:361)(1:362))(1:(1:364)(1:365))|366|(1:368)(1:369)|370|(1:376)|377)(14:357|(1:380)|381|414|382|(1:384)(1:385)|386|(2:388|(1:390))|394|411|395|(1:397)(1:398)|399|(2:401|(1:403))))|337|(0)|381|414|382|(0)(0)|386|(0)|394|411|395|(0)(0)|399|(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:53|(1:55)|56|(1:65)(16:62|(1:64)|73|(1:92)(1:93)|94|(1:96)(1:97)|98|(8:100|(1:102)|103|(1:105)(3:107|(1:109)(1:110)|111)|106|112|(1:114)(1:115)|116)(1:117)|118|413|119|(3:121|(1:123)|124)(1:125)|(1:127)(1:128)|132|(1:134)|135)|66|(2:74|(14:90|(0)(0)|94|(0)(0)|98|(0)(0)|118|413|119|(0)(0)|(0)(0)|132|(0)|135)(3:86|(1:88)|89))(1:72)|73|(0)(0)|94|(0)(0)|98|(0)(0)|118|413|119|(0)(0)|(0)(0)|132|(0)|135) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03d4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03d5, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0b81, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0b82, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0371 A[Catch: Exception -> 0x03d4, TryCatch #2 {Exception -> 0x03d4, blocks: (B:119:0x034e, B:121:0x0371, B:123:0x0386, B:124:0x0391, B:127:0x03a0, B:128:0x03d0, B:125:0x039b), top: B:413:0x034e }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x039b A[Catch: Exception -> 0x03d4, TryCatch #2 {Exception -> 0x03d4, blocks: (B:119:0x034e, B:121:0x0371, B:123:0x0386, B:124:0x0391, B:127:0x03a0, B:128:0x03d0, B:125:0x039b), top: B:413:0x034e }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03a0 A[Catch: Exception -> 0x03d4, TryCatch #2 {Exception -> 0x03d4, blocks: (B:119:0x034e, B:121:0x0371, B:123:0x0386, B:124:0x0391, B:127:0x03a0, B:128:0x03d0, B:125:0x039b), top: B:413:0x034e }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03d0 A[Catch: Exception -> 0x03d4, TRY_LEAVE, TryCatch #2 {Exception -> 0x03d4, blocks: (B:119:0x034e, B:121:0x0371, B:123:0x0386, B:124:0x0391, B:127:0x03a0, B:128:0x03d0, B:125:0x039b), top: B:413:0x034e }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0b16  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0b2e  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0b31  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0b3c A[Catch: Exception -> 0x0b81, TryCatch #3 {Exception -> 0x0b81, blocks: (B:382:0x0b2a, B:386:0x0b32, B:388:0x0b3c, B:390:0x0b5d), top: B:414:0x0b2a }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0b8a  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0b8d  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0b98 A[Catch: Exception -> 0x0bda, TryCatch #1 {Exception -> 0x0bda, blocks: (B:395:0x0b86, B:399:0x0b8e, B:401:0x0b98, B:403:0x0bb6), top: B:411:0x0b86 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x024a  */
    /* JADX WARN: Type inference failed for: r3v102 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [ir.eitaa.tgnet.TLRPC$Chat, ir.eitaa.tgnet.TLRPC$User, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v159 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageObjectInternal(ir.eitaa.messenger.MessageObject r41) {
        /*
            Method dump skipped, instructions count: 3042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.setMessageObjectInternal(ir.eitaa.messenger.MessageObject):void");
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

    public boolean shouldDrawAlphaLayer() {
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        return (groupedMessages == null || !groupedMessages.transitionParams.backgroundChangeBounds) && getAlpha() != 1.0f;
    }

    public float getCaptionX() {
        return this.captionX;
    }

    public boolean isDrawPinnedBottom() {
        return this.mediaBackground || this.drawPinnedBottom;
    }

    public void drawCheckBox(Canvas canvas) {
        float top;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.isSending() || this.currentMessageObject.isSendError() || this.checkBox == null) {
            return;
        }
        if (this.checkBoxVisible || this.checkBoxAnimationInProgress) {
            MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
            if (groupedMessagePosition != null) {
                int i = groupedMessagePosition.flags;
                if ((i & 8) == 0 || (i & 1) == 0) {
                    return;
                }
            }
            canvas.save();
            float y = getY();
            MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
            if (groupedMessages != null && groupedMessages.messages.size() > 1) {
                top = (getTop() + this.currentMessagesGroup.transitionParams.offsetTop) - getTranslationY();
            } else {
                top = y + this.transitionParams.deltaTop;
            }
            canvas.translate(0.0f, top + this.transitionYOffsetForDrawables);
            this.checkBox.draw(canvas);
            canvas.restore();
        }
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
            ir.eitaa.ui.Cells.ChatMessageCell$TransitionParams r5 = r11.transitionParams
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.setBackgroundTopY(boolean):void");
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
            ir.eitaa.ui.Cells.ChatMessageCell$TransitionParams r8 = r7.transitionParams
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
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.setBackgroundTopY(int):void");
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
    /* JADX WARN: Removed duplicated region for block: B:364:0x0888 A[PHI: r3 r5
      0x0888: PHI (r3v118 int) = (r3v117 int), (r3v133 int) binds: [B:360:0x0863, B:362:0x0873] A[DONT_GENERATE, DONT_INLINE]
      0x0888: PHI (r5v33 int) = (r5v32 int), (r5v37 int) binds: [B:360:0x0863, B:362:0x0873] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongCall"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r30) {
        /*
            Method dump skipped, instructions count: 3740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.onDraw(android.graphics.Canvas):void");
    }

    public void drawCommentButton(Canvas canvas, float alpha) {
        if (this.drawSideButton != 3) {
            return;
        }
        int iDp = AndroidUtilities.dp(32.0f);
        if (this.commentLayout != null) {
            this.sideStartY -= AndroidUtilities.dp(18.0f);
            iDp += AndroidUtilities.dp(18.0f);
        }
        RectF rectF = this.rect;
        float f = this.sideStartX;
        rectF.set(f, this.sideStartY, AndroidUtilities.dp(32.0f) + f, this.sideStartY + iDp);
        applyServiceShaderMatrix(getMeasuredWidth(), this.backgroundHeight, getX(), this.viewTop);
        if (alpha != 1.0f) {
            int alpha2 = getThemedPaint("paintChatActionBackground").getAlpha();
            getThemedPaint("paintChatActionBackground").setAlpha((int) (alpha2 * alpha));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), getThemedPaint("paintChatActionBackground"));
            getThemedPaint("paintChatActionBackground").setAlpha(alpha2);
        } else {
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), getThemedPaint(this.sideButtonPressed ? "paintChatActionBackgroundSelected" : "paintChatActionBackground"));
        }
        if (hasGradientService()) {
            if (alpha != 1.0f) {
                int alpha3 = Theme.chat_actionBackgroundGradientDarkenPaint.getAlpha();
                Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha((int) (alpha3 * alpha));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
                Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha(alpha3);
            } else {
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
        }
        Drawable themeDrawable = Theme.getThemeDrawable("drawableCommentSticker");
        BaseCell.setDrawableBounds(themeDrawable, this.sideStartX + AndroidUtilities.dp(4.0f), this.sideStartY + AndroidUtilities.dp(4.0f));
        if (alpha != 1.0f) {
            themeDrawable.setAlpha((int) (alpha * 255.0f));
            themeDrawable.draw(canvas);
            themeDrawable.setAlpha(255);
        } else {
            themeDrawable.draw(canvas);
        }
        if (this.commentLayout != null) {
            Theme.chat_stickerCommentCountPaint.setColor(getThemedColor("chat_stickerReplyNameText"));
            Theme.chat_stickerCommentCountPaint.setAlpha((int) (alpha * 255.0f));
            if (this.transitionParams.animateComments) {
                if (this.transitionParams.animateCommentsLayout != null) {
                    canvas.save();
                    TextPaint textPaint = Theme.chat_stickerCommentCountPaint;
                    double d = this.transitionParams.animateChangeProgress;
                    Double.isNaN(d);
                    double d2 = alpha;
                    Double.isNaN(d2);
                    textPaint.setAlpha((int) ((1.0d - d) * 255.0d * d2));
                    canvas.translate(this.sideStartX + ((AndroidUtilities.dp(32.0f) - this.transitionParams.animateTotalCommentWidth) / 2), this.sideStartY + AndroidUtilities.dp(30.0f));
                    this.transitionParams.animateCommentsLayout.draw(canvas);
                    canvas.restore();
                }
                Theme.chat_stickerCommentCountPaint.setAlpha((int) (this.transitionParams.animateChangeProgress * 255.0f));
            }
            canvas.save();
            canvas.translate(this.sideStartX + ((AndroidUtilities.dp(32.0f) - this.totalCommentWidth) / 2), this.sideStartY + AndroidUtilities.dp(30.0f));
            this.commentLayout.draw(canvas);
            canvas.restore();
        }
    }

    private void applyServiceShaderMatrix(int measuredWidth, int backgroundHeight, float x, float viewTop) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider != null) {
            resourcesProvider.applyServiceShaderMatrix(measuredWidth, backgroundHeight, x, viewTop);
        } else {
            Theme.applyServiceShaderMatrix(measuredWidth, backgroundHeight, x, viewTop);
        }
    }

    public void drawOutboundsContent(Canvas canvas) {
        TransitionParams transitionParams = this.transitionParams;
        if (transitionParams.animateBackgroundBoundsInner) {
            if (!transitionParams.transitionBotButtons.isEmpty()) {
                drawBotButtons(canvas, this.transitionParams.transitionBotButtons, 1.0f - this.transitionParams.animateChangeProgress);
            }
            if (this.botButtons.isEmpty()) {
                return;
            }
            drawBotButtons(canvas, this.botButtons, this.transitionParams.animateChangeProgress);
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083 A[PHI: r6 r7
      0x0083: PHI (r6v14 int) = (r6v13 int), (r6v20 int) binds: [B:27:0x0060, B:29:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0083: PHI (r7v1 int) = (r7v0 int), (r7v6 int) binds: [B:27:0x0060, B:29:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawBackground(android.graphics.Canvas r14, int r15, int r16, int r17, int r18, boolean r19, boolean r20, boolean r21, int r22) {
        /*
            r13 = this;
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            ir.eitaa.messenger.MessageObject r6 = r0.currentMessageObject
            boolean r6 = r6.isOutOwner()
            if (r6 == 0) goto L37
            boolean r6 = r0.mediaBackground
            if (r6 != 0) goto L27
            if (r20 != 0) goto L27
            if (r21 == 0) goto L1c
            java.lang.String r6 = "drawableMsgOutSelected"
            goto L1e
        L1c:
            java.lang.String r6 = "drawableMsgOut"
        L1e:
            android.graphics.drawable.Drawable r6 = r13.getThemedDrawable(r6)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = (ir.eitaa.ui.ActionBar.Theme.MessageDrawable) r6
            r0.currentBackgroundDrawable = r6
            goto L5c
        L27:
            if (r21 == 0) goto L2c
            java.lang.String r6 = "drawableMsgOutMediaSelected"
            goto L2e
        L2c:
            java.lang.String r6 = "drawableMsgOutMedia"
        L2e:
            android.graphics.drawable.Drawable r6 = r13.getThemedDrawable(r6)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = (ir.eitaa.ui.ActionBar.Theme.MessageDrawable) r6
            r0.currentBackgroundDrawable = r6
            goto L5c
        L37:
            boolean r6 = r0.mediaBackground
            if (r6 != 0) goto L4d
            if (r20 != 0) goto L4d
            if (r21 == 0) goto L42
            java.lang.String r6 = "drawableMsgInSelected"
            goto L44
        L42:
            java.lang.String r6 = "drawableMsgIn"
        L44:
            android.graphics.drawable.Drawable r6 = r13.getThemedDrawable(r6)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = (ir.eitaa.ui.ActionBar.Theme.MessageDrawable) r6
            r0.currentBackgroundDrawable = r6
            goto L5c
        L4d:
            if (r21 == 0) goto L52
            java.lang.String r6 = "drawableMsgInMediaSelected"
            goto L54
        L52:
            java.lang.String r6 = "drawableMsgInMedia"
        L54:
            android.graphics.drawable.Drawable r6 = r13.getThemedDrawable(r6)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = (ir.eitaa.ui.ActionBar.Theme.MessageDrawable) r6
            r0.currentBackgroundDrawable = r6
        L5c:
            int r6 = r0.parentWidth
            int r7 = r0.parentHeight
            if (r7 != 0) goto L83
            int r6 = r13.getParentWidth()
            android.graphics.Point r7 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r7 = r7.y
            android.view.ViewParent r8 = r13.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L83
            android.view.ViewParent r6 = r13.getParent()
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getMeasuredWidth()
            int r6 = r6.getMeasuredHeight()
            r9 = r6
            r8 = r7
            goto L85
        L83:
            r8 = r6
            r9 = r7
        L85:
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = r0.currentBackgroundDrawable
            if (r6 == 0) goto Lcf
            float r7 = r0.parentViewTopOffset
            int r10 = (int) r7
            r7 = r22
            r11 = r19
            r12 = r20
            r6.setTop(r7, r8, r9, r10, r11, r12)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = r0.currentBackgroundDrawable
            android.graphics.drawable.Drawable r6 = r6.getShadowDrawable()
            r7 = 255(0xff, float:3.57E-43)
            r8 = 1132396544(0x437f0000, float:255.0)
            if (r6 == 0) goto Lb4
            float r9 = r13.getAlpha()
            float r9 = r9 * r8
            int r9 = (int) r9
            r6.setAlpha(r9)
            r6.setBounds(r15, r3, r4, r5)
            r6.draw(r14)
            r6.setAlpha(r7)
        Lb4:
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = r0.currentBackgroundDrawable
            float r9 = r13.getAlpha()
            float r9 = r9 * r8
            int r8 = (int) r9
            r6.setAlpha(r8)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r6 = r0.currentBackgroundDrawable
            r6.setBounds(r15, r3, r4, r5)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r2 = r0.currentBackgroundDrawable
            r2.draw(r14)
            ir.eitaa.ui.ActionBar.Theme$MessageDrawable r1 = r0.currentBackgroundDrawable
            r1.setAlpha(r7)
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawBackground(android.graphics.Canvas, int, int, int, int, boolean, boolean, boolean, int):void");
    }

    public boolean hasNameLayout() {
        if (this.drawNameLayout && this.nameLayout != null) {
            return true;
        }
        if (this.drawForwardedName) {
            StaticLayout[] staticLayoutArr = this.forwardedNameLayout;
            if (staticLayoutArr[0] != null && staticLayoutArr[1] != null) {
                MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
                if (groupedMessagePosition == null) {
                    return true;
                }
                if (groupedMessagePosition.minY == 0 && groupedMessagePosition.minX == 0) {
                    return true;
                }
            }
        }
        return this.replyNameLayout != null;
    }

    public boolean isDrawNameLayout() {
        return this.drawNameLayout && this.nameLayout != null;
    }

    public boolean isAdminLayoutChanged() {
        return !TextUtils.equals(this.lastPostAuthor, this.currentMessageObject.messageOwner.post_author);
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x076b  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0826  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0846  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x09c1  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0a20  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawNamesLayout(android.graphics.Canvas r24, float r25) {
        /*
            Method dump skipped, instructions count: 2805
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawNamesLayout(android.graphics.Canvas, float):void");
    }

    public boolean hasCaptionLayout() {
        return this.captionLayout != null;
    }

    public boolean hasCommentLayout() {
        return this.drawCommentButton;
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

    public boolean isDrawingSelectionBackground() {
        return this.drawSelectionBackground || this.isHighlightedAnimated || this.isHighlighted;
    }

    public float getHightlightAlpha() {
        int i;
        if (this.drawSelectionBackground || !this.isHighlightedAnimated || (i = this.highlightProgress) >= 300) {
            return 1.0f;
        }
        return i / 300.0f;
    }

    public void setCheckBoxVisible(boolean visible, boolean animated) {
        MessageObject.GroupedMessages groupedMessages;
        MessageObject.GroupedMessages groupedMessages2;
        if (visible && this.checkBox == null) {
            CheckBoxBase checkBoxBase = new CheckBoxBase(this, 21, this.resourcesProvider);
            this.checkBox = checkBoxBase;
            if (this.attachedToWindow) {
                checkBoxBase.onAttachedToWindow();
            }
        }
        if (visible && this.mediaCheckBox == null && (((groupedMessages = this.currentMessagesGroup) != null && groupedMessages.messages.size() > 1) || ((groupedMessages2 = this.groupedMessagesToSet) != null && groupedMessages2.messages.size() > 1))) {
            CheckBoxBase checkBoxBase2 = new CheckBoxBase(this, 21, this.resourcesProvider);
            this.mediaCheckBox = checkBoxBase2;
            checkBoxBase2.setUseDefaultCheck(true);
            if (this.attachedToWindow) {
                this.mediaCheckBox.onAttachedToWindow();
            }
        }
        if (this.checkBoxVisible == visible) {
            if (animated == this.checkBoxAnimationInProgress || animated) {
                return;
            }
            this.checkBoxAnimationProgress = visible ? 1.0f : 0.0f;
            invalidate();
            return;
        }
        this.checkBoxAnimationInProgress = animated;
        this.checkBoxVisible = visible;
        if (animated) {
            this.lastCheckBoxAnimationTime = SystemClock.elapsedRealtime();
        } else {
            this.checkBoxAnimationProgress = visible ? 1.0f : 0.0f;
        }
        invalidate();
    }

    public void setChecked(boolean checked, boolean allChecked, boolean animated) {
        CheckBoxBase checkBoxBase = this.checkBox;
        if (checkBoxBase != null) {
            checkBoxBase.setChecked(allChecked, animated);
        }
        CheckBoxBase checkBoxBase2 = this.mediaCheckBox;
        if (checkBoxBase2 != null) {
            checkBoxBase2.setChecked(checked, animated);
        }
        this.backgroundDrawable.setSelected(allChecked, animated);
    }

    public void setLastTouchCoords(float x, float y) {
        this.lastTouchX = x;
        this.lastTouchY = y;
        this.backgroundDrawable.setTouchCoords(x + getTranslationX(), this.lastTouchY);
    }

    public MessageBackgroundDrawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public Theme.MessageDrawable getCurrentBackgroundDrawable(boolean update) {
        if (update) {
            MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
            boolean z = groupedMessagePosition != null && (groupedMessagePosition.flags & 8) == 0 && this.currentMessagesGroup.isDocuments && !this.drawPinnedBottom;
            if (this.currentMessageObject.isOutOwner()) {
                if (!this.mediaBackground && !this.drawPinnedBottom && !z) {
                    this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgOut");
                } else {
                    this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgOutMedia");
                }
            } else if (!this.mediaBackground && !this.drawPinnedBottom && !z) {
                this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgIn");
            } else {
                this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgInMedia");
            }
        }
        this.currentBackgroundDrawable.getBackgroundDrawable();
        return this.currentBackgroundDrawable;
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

    /* JADX WARN: Removed duplicated region for block: B:245:0x05ff  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x06c7  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x07cf  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0792 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawCaptionLayout(android.graphics.Canvas r25, android.text.StaticLayout r26, boolean r27, float r28) {
        /*
            Method dump skipped, instructions count: 2006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawCaptionLayout(android.graphics.Canvas, android.text.StaticLayout, boolean, float):void");
    }

    public boolean needDrawTime() {
        return !this.forceNotDrawTime;
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
    public void drawTime(android.graphics.Canvas r17, float r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawTime(android.graphics.Canvas, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:265:0x0604  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawTimeInternal(android.graphics.Canvas r29, float r30, boolean r31, float r32, android.text.StaticLayout r33, float r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 1883
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawTimeInternal(android.graphics.Canvas, float, boolean, float, android.text.StaticLayout, float, boolean):void");
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
            this.statusDrawableAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$ChatMessageCell$NelFDI4VKeFDY6JAtaN5ZEQ4eMk
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createStatusDrawableAnimator$4$ChatMessageCell(fromParent, valueAnimator);
                }
            });
            this.statusDrawableAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.ChatMessageCell.11
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    int iCreateStatusDrawableParams = ChatMessageCell.this.transitionParams.createStatusDrawableParams();
                    if (ChatMessageCell.this.animateToStatusDrawableParams == iCreateStatusDrawableParams) {
                        ChatMessageCell.this.statusDrawableAnimationInProgress = false;
                        ChatMessageCell.this.transitionParams.lastStatusDrawableParams = ChatMessageCell.this.animateToStatusDrawableParams;
                    } else {
                        ChatMessageCell chatMessageCell = ChatMessageCell.this;
                        chatMessageCell.createStatusDrawableAnimator(chatMessageCell.animateToStatusDrawableParams, iCreateStatusDrawableParams, fromParent);
                    }
                }
            });
            this.statusDrawableAnimationInProgress = true;
            this.statusDrawableAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createStatusDrawableAnimator$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createStatusDrawableAnimator$4$ChatMessageCell(boolean z, ValueAnimator valueAnimator) {
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
            Method dump skipped, instructions count: 1174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawViewsAndRepliesLayout(android.graphics.Canvas, float, float, float, float, float, boolean):void");
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

    /* JADX WARN: Removed duplicated region for block: B:192:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x06ed  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0b94  */
    /* JADX WARN: Removed duplicated region for block: B:535:0x0df0  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x134f  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x1611  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x162a  */
    /* JADX WARN: Removed duplicated region for block: B:764:0x164b  */
    /* JADX WARN: Removed duplicated region for block: B:768:0x1662  */
    /* JADX WARN: Removed duplicated region for block: B:784:0x1693  */
    /* JADX WARN: Removed duplicated region for block: B:790:0x16a1  */
    /* JADX WARN: Removed duplicated region for block: B:794:0x16b2  */
    /* JADX WARN: Removed duplicated region for block: B:835:0x17b4  */
    /* JADX WARN: Removed duplicated region for block: B:837:0x17bb  */
    /* JADX WARN: Removed duplicated region for block: B:925:0x19ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawOverlays(android.graphics.Canvas r33) {
        /*
            Method dump skipped, instructions count: 6922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.drawOverlays(android.graphics.Canvas):void");
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

    public boolean drawPinnedBottom() {
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && groupedMessages.isDocuments) {
            MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
            if (groupedMessagePosition == null || (groupedMessagePosition.flags & 8) == 0) {
                return true;
            }
            return this.pinnedBottom;
        }
        return this.pinnedBottom;
    }

    public boolean drawPinnedTop() {
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && groupedMessages.isDocuments) {
            MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
            if (groupedMessagePosition == null || (groupedMessagePosition.flags & 4) == 0) {
                return true;
            }
            return this.pinnedTop;
        }
        return this.pinnedTop;
    }

    public boolean isPinnedBottom() {
        return this.pinnedBottom;
    }

    public boolean isPinnedTop() {
        return this.pinnedTop;
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
        ChatMessageCellDelegate chatMessageCellDelegate;
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
        } else if (action == ir.eitaa.messenger.R.id.acc_action_msg_options && (chatMessageCellDelegate = this.delegate) != null) {
            if (this.currentMessageObject.type == 16) {
                chatMessageCellDelegate.didLongPress(this, 0.0f, 0.0f);
            } else {
                chatMessageCellDelegate.didPressOther(this, this.otherX, this.otherY);
            }
        }
        if ((this.currentMessageObject.isVoice() || (this.currentMessageObject.isMusic() && MediaController.getInstance().isPlayingMessage(this.currentMessageObject))) && this.seekBarAccessibilityDelegate.performAccessibilityActionInternal(action, arguments)) {
            return true;
        }
        return super.performAccessibilityAction(action, arguments);
    }

    public void setAnimationRunning(boolean animationRunning, boolean willRemoved) {
        this.animationRunning = animationRunning;
        if (animationRunning) {
            this.willRemoved = willRemoved;
        } else {
            this.willRemoved = false;
        }
        if (getParent() == null && this.attachedToWindow) {
            onDetachedFromWindow();
        }
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

    public static Point getMessageSize(int imageW, int imageH) {
        return getMessageSize(imageW, imageH, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.eitaa.ui.Components.Point getMessageSize(int r3, int r4, int r5, int r6) {
        /*
            if (r6 == 0) goto L4
            if (r5 != 0) goto L50
        L4:
            boolean r5 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            r6 = 1060320051(0x3f333333, float:0.7)
            if (r5 == 0) goto L16
            int r5 = ir.eitaa.messenger.AndroidUtilities.getMinTabletSide()
        L11:
            float r5 = (float) r5
            float r5 = r5 * r6
            int r5 = (int) r5
            goto L35
        L16:
            if (r3 < r4) goto L2a
            android.graphics.Point r5 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r6 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r6, r5)
            r6 = 1115684864(0x42800000, float:64.0)
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            int r5 = r5 - r6
            goto L35
        L2a:
            android.graphics.Point r5 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r0 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r0, r5)
            goto L11
        L35:
            r6 = 1120403456(0x42c80000, float:100.0)
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            int r6 = r6 + r5
            int r0 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
            if (r5 <= r0) goto L46
            int r5 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
        L46:
            int r0 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
            if (r6 <= r0) goto L50
            int r6 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
        L50:
            float r3 = (float) r3
            float r5 = (float) r5
            float r0 = r3 / r5
            float r1 = r3 / r0
            int r1 = (int) r1
            float r4 = (float) r4
            float r0 = r4 / r0
            int r0 = (int) r0
            r2 = 1125515264(0x43160000, float:150.0)
            if (r1 != 0) goto L63
            int r1 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
        L63:
            if (r0 != 0) goto L69
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
        L69:
            if (r0 <= r6) goto L72
            float r3 = (float) r0
            float r4 = (float) r6
            float r3 = r3 / r4
            float r4 = (float) r1
            float r4 = r4 / r3
            int r1 = (int) r4
            goto L88
        L72:
            r6 = 1123024896(0x42f00000, float:120.0)
            int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            if (r0 >= r2) goto L87
            int r6 = ir.eitaa.messenger.AndroidUtilities.dp(r6)
            float r0 = (float) r6
            float r4 = r4 / r0
            float r3 = r3 / r4
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 >= 0) goto L88
            int r1 = (int) r3
            goto L88
        L87:
            r6 = r0
        L88:
            ir.eitaa.ui.Components.Point r3 = new ir.eitaa.ui.Components.Point
            float r4 = (float) r1
            float r5 = (float) r6
            r3.<init>(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.getMessageSize(int, int, int, int):ir.eitaa.ui.Components.Point");
    }

    public StaticLayout getDescriptionlayout() {
        return this.descriptionLayout;
    }

    public void setSelectedBackgroundProgress(float value) {
        this.selectedBackgroundProgress = value;
        invalidate();
    }

    public int computeHeight(MessageObject object, MessageObject.GroupedMessages groupedMessages) throws Resources.NotFoundException, NumberFormatException {
        this.photoImage.setIgnoreImageSet(true);
        this.avatarImage.setIgnoreImageSet(true);
        this.replyImageReceiver.setIgnoreImageSet(true);
        this.locationImageReceiver.setIgnoreImageSet(true);
        if (groupedMessages != null && groupedMessages.messages.size() != 1) {
            int i = 0;
            for (int i2 = 0; i2 < groupedMessages.messages.size(); i2++) {
                MessageObject messageObject = groupedMessages.messages.get(i2);
                MessageObject.GroupedMessagePosition groupedMessagePosition = groupedMessages.positions.get(messageObject);
                if (groupedMessagePosition != null && (groupedMessagePosition.flags & 1) != 0) {
                    setMessageContent(messageObject, groupedMessages, false, false);
                    i += this.totalHeight + this.keyboardHeight;
                }
            }
            return i;
        }
        setMessageContent(object, groupedMessages, false, false);
        this.photoImage.setIgnoreImageSet(false);
        this.avatarImage.setIgnoreImageSet(false);
        this.replyImageReceiver.setIgnoreImageSet(false);
        this.locationImageReceiver.setIgnoreImageSet(false);
        return this.totalHeight + this.keyboardHeight;
    }

    public void shakeView() {
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 3.0f), Keyframe.ofFloat(0.4f, -3.0f), Keyframe.ofFloat(0.6f, 3.0f), Keyframe.ofFloat(0.8f, -3.0f), Keyframe.ofFloat(1.0f, 0.0f));
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 1.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.5f, 0.97f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3);
        PropertyValuesHolder propertyValuesHolderOfKeyframe3 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3);
        AnimatorSet animatorSet = new AnimatorSet();
        this.shakeAnimation = animatorSet;
        animatorSet.playTogether(ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe), ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe2), ObjectAnimator.ofPropertyValuesHolder(this, propertyValuesHolderOfKeyframe3));
        this.shakeAnimation.setDuration(500L);
        this.shakeAnimation.start();
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

    public float getNonAnimationTranslationX(boolean update) {
        boolean z;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && !messageObject.isOutOwner()) {
            if (update && ((z = this.checkBoxVisible) || this.checkBoxAnimationInProgress)) {
                this.checkBoxTranslation = (int) Math.ceil((z ? CubicBezierInterpolator.EASE_OUT : CubicBezierInterpolator.EASE_IN).getInterpolation(this.checkBoxAnimationProgress) * AndroidUtilities.dp(35.0f));
            }
            return this.slidingOffsetX + this.checkBoxTranslation;
        }
        return this.slidingOffsetX;
    }

    public float getSlidingOffsetX() {
        return this.slidingOffsetX;
    }

    public boolean willRemovedAfterAnimation() {
        return this.willRemoved;
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
            int[] iArr = {0, 0};
            ChatMessageCell.this.getLocationOnScreen(iArr);
            if (virtualViewId == -1) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(ChatMessageCell.this);
                ChatMessageCell.this.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                StringBuilder sb = new StringBuilder();
                ChatMessageCell chatMessageCell = ChatMessageCell.this;
                if (chatMessageCell.isChat && chatMessageCell.currentUser != null && !ChatMessageCell.this.currentMessageObject.isOut()) {
                    sb.append(UserObject.getUserName(ChatMessageCell.this.currentUser));
                    sb.append('\n');
                }
                if (ChatMessageCell.this.drawForwardedName) {
                    int i2 = 0;
                    while (i2 < 2) {
                        if (ChatMessageCell.this.forwardedNameLayout[i2] != null) {
                            sb.append(ChatMessageCell.this.forwardedNameLayout[i2].getText());
                            sb.append(i2 == 0 ? " " : "\n");
                        }
                        i2++;
                    }
                }
                if (!TextUtils.isEmpty(ChatMessageCell.this.currentMessageObject.messageText)) {
                    sb.append(ChatMessageCell.this.currentMessageObject.messageText);
                }
                if (ChatMessageCell.this.documentAttach != null && (ChatMessageCell.this.documentAttachType == 1 || ChatMessageCell.this.documentAttachType == 2 || ChatMessageCell.this.documentAttachType == 4)) {
                    if (ChatMessageCell.this.buttonState != 1 || ChatMessageCell.this.loadingProgressLayout == null) {
                        if (ChatMessageCell.this.buttonState == 0 || ChatMessageCell.this.documentAttachType == 1) {
                            sb.append(", ");
                            sb.append(AndroidUtilities.formatFileSize(ChatMessageCell.this.documentAttach.size));
                        }
                    } else {
                        sb.append("\n");
                        boolean zIsSending = ChatMessageCell.this.currentMessageObject.isSending();
                        sb = sb;
                        sb.append(LocaleController.formatString(zIsSending ? "AccDescrUploadProgress" : "AccDescrDownloadProgress", zIsSending ? ir.eitaa.messenger.R.string.AccDescrUploadProgress : ir.eitaa.messenger.R.string.AccDescrDownloadProgress, AndroidUtilities.formatFileSize(ChatMessageCell.this.currentMessageObject.loadedFileSize), AndroidUtilities.formatFileSize(ChatMessageCell.this.lastLoadingSizeTotal)));
                    }
                    if (ChatMessageCell.this.documentAttachType == 4) {
                        sb.append(", ");
                        sb.append(LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                    }
                }
                if (!ChatMessageCell.this.currentMessageObject.isMusic()) {
                    if (ChatMessageCell.this.currentMessageObject.isVoice() || ChatMessageCell.this.isRoundVideo) {
                        sb.append(", ");
                        sb.append(LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                        if (ChatMessageCell.this.currentMessageObject.isContentUnread()) {
                            sb.append(", ");
                            sb.append(LocaleController.getString("AccDescrMsgNotPlayed", ir.eitaa.messenger.R.string.AccDescrMsgNotPlayed));
                        }
                    }
                } else {
                    sb.append("\n");
                    sb.append(LocaleController.formatString("AccDescrMusicInfo", ir.eitaa.messenger.R.string.AccDescrMusicInfo, ChatMessageCell.this.currentMessageObject.getMusicAuthor(), ChatMessageCell.this.currentMessageObject.getMusicTitle()));
                    sb.append(", ");
                    sb.append(LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                }
                if (ChatMessageCell.this.lastPoll != null) {
                    sb.append(", ");
                    sb.append(ChatMessageCell.this.lastPoll.question);
                    sb.append(", ");
                    if (!ChatMessageCell.this.pollClosed) {
                        if (ChatMessageCell.this.lastPoll.quiz) {
                            if (ChatMessageCell.this.lastPoll.public_voters) {
                                string2 = LocaleController.getString("QuizPoll", ir.eitaa.messenger.R.string.QuizPoll);
                            } else {
                                string2 = LocaleController.getString("AnonymousQuizPoll", ir.eitaa.messenger.R.string.AnonymousQuizPoll);
                            }
                        } else if (ChatMessageCell.this.lastPoll.public_voters) {
                            string2 = LocaleController.getString("PublicPoll", ir.eitaa.messenger.R.string.PublicPoll);
                        } else {
                            string2 = LocaleController.getString("AnonymousPoll", ir.eitaa.messenger.R.string.AnonymousPoll);
                        }
                    } else {
                        string2 = LocaleController.getString("FinalResults", ir.eitaa.messenger.R.string.FinalResults);
                    }
                    sb.append(string2);
                }
                if (ChatMessageCell.this.currentMessageObject.messageOwner.media != null && !TextUtils.isEmpty(ChatMessageCell.this.currentMessageObject.caption)) {
                    sb.append("\n");
                    sb.append(ChatMessageCell.this.currentMessageObject.caption);
                }
                if (ChatMessageCell.this.currentMessageObject.isOut()) {
                    if (!ChatMessageCell.this.currentMessageObject.isSent()) {
                        if (!ChatMessageCell.this.currentMessageObject.isSending()) {
                            if (ChatMessageCell.this.currentMessageObject.isSendError()) {
                                sb.append("\n");
                                sb.append(LocaleController.getString("AccDescrMsgSendingError", ir.eitaa.messenger.R.string.AccDescrMsgSendingError));
                            }
                        } else {
                            sb.append("\n");
                            sb.append(LocaleController.getString("AccDescrMsgSending", ir.eitaa.messenger.R.string.AccDescrMsgSending));
                            float progress = ChatMessageCell.this.radialProgress.getProgress();
                            if (progress > 0.0f) {
                                sb.append(", ");
                                sb.append(Math.round(progress * 100.0f));
                                sb.append("%");
                            }
                        }
                    } else {
                        sb.append("\n");
                        if (ChatMessageCell.this.currentMessageObject.scheduled) {
                            sb.append(LocaleController.formatString("AccDescrScheduledDate", ir.eitaa.messenger.R.string.AccDescrScheduledDate, ChatMessageCell.this.currentTimeString));
                        } else {
                            sb.append(LocaleController.formatString("AccDescrSentDate", ir.eitaa.messenger.R.string.AccDescrSentDate, LocaleController.getString("TodayAt", ir.eitaa.messenger.R.string.TodayAt) + " " + ChatMessageCell.this.currentTimeString));
                            sb.append(", ");
                            if (ChatMessageCell.this.currentMessageObject.isUnread()) {
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
                    sb.append(LocaleController.formatString("AccDescrReceivedDate", ir.eitaa.messenger.R.string.AccDescrReceivedDate, LocaleController.getString("TodayAt", ir.eitaa.messenger.R.string.TodayAt) + " " + ChatMessageCell.this.currentTimeString));
                }
                if ((ChatMessageCell.this.currentMessageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0) {
                    sb.append("\n");
                    sb.append(LocaleController.formatPluralString("AccDescrNumberOfViews", ChatMessageCell.this.currentMessageObject.messageOwner.views));
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
                    int iconForCurrentState = ChatMessageCell.this.getIconForCurrentState();
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
                        string = ChatMessageCell.this.currentMessageObject.type == 16 ? LocaleController.getString("CallAgain", ir.eitaa.messenger.R.string.CallAgain) : null;
                    }
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, string));
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccActionEnterSelectionMode", ir.eitaa.messenger.R.string.AccActionEnterSelectionMode)));
                    if (ChatMessageCell.this.getMiniIconForCurrentState() == 2) {
                        accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.eitaa.messenger.R.id.acc_action_small_button, LocaleController.getString("AccActionDownload", ir.eitaa.messenger.R.string.AccActionDownload)));
                    }
                } else {
                    accessibilityNodeInfoObtain.addAction(16);
                    accessibilityNodeInfoObtain.addAction(32);
                }
                if ((ChatMessageCell.this.currentMessageObject.isVoice() || ChatMessageCell.this.currentMessageObject.isMusic()) && MediaController.getInstance().isPlayingMessage(ChatMessageCell.this.currentMessageObject)) {
                    ChatMessageCell.this.seekBarAccessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfoObtain);
                }
                if (ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable) {
                    Spannable spannable = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
                    int i4 = 0;
                    for (CharacterStyle characterStyle : (CharacterStyle[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i4 + 2000);
                        i4++;
                    }
                }
                if ((ChatMessageCell.this.currentMessageObject.caption instanceof Spannable) && ChatMessageCell.this.captionLayout != null) {
                    Spannable spannable2 = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                    int i5 = 0;
                    for (CharacterStyle characterStyle2 : (CharacterStyle[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class)) {
                        accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i5 + 3000);
                        i5++;
                    }
                }
                Iterator it = ChatMessageCell.this.botButtons.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i6 + 1000);
                    i6++;
                }
                if (ChatMessageCell.this.hintButtonVisible && ChatMessageCell.this.pollHintX != -1 && ChatMessageCell.this.currentMessageObject.isPoll()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 495);
                }
                Iterator it2 = ChatMessageCell.this.pollButtons.iterator();
                int i7 = 0;
                while (it2.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i7 + 500);
                    i7++;
                }
                if (ChatMessageCell.this.drawInstantView && !ChatMessageCell.this.instantButtonRect.isEmpty()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 499);
                }
                if (ChatMessageCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 496);
                }
                if (ChatMessageCell.this.drawSideButton == 1) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 498);
                }
                ChatMessageCell chatMessageCell2 = ChatMessageCell.this;
                if (chatMessageCell2.replyNameLayout != null) {
                    accessibilityNodeInfoObtain.addChild(chatMessageCell2, 497);
                }
                if (ChatMessageCell.this.forwardedNameLayout[0] != null && ChatMessageCell.this.forwardedNameLayout[1] != null) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 494);
                }
                if (ChatMessageCell.this.drawSelectionBackground || ChatMessageCell.this.getBackground() != null) {
                    accessibilityNodeInfoObtain.setSelected(true);
                }
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain2.setSource(ChatMessageCell.this, virtualViewId);
            accessibilityNodeInfoObtain2.setParent(ChatMessageCell.this);
            accessibilityNodeInfoObtain2.setPackageName(ChatMessageCell.this.getContext().getPackageName());
            if (virtualViewId >= 3000) {
                if (!(ChatMessageCell.this.currentMessageObject.caption instanceof Spannable) || ChatMessageCell.this.captionLayout == null) {
                    return null;
                }
                Spannable spannable3 = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                ClickableSpan linkById = getLinkById(virtualViewId, true);
                if (linkById == null) {
                    return null;
                }
                int[] realSpanStartAndEnd = ChatMessageCell.this.getRealSpanStartAndEnd(spannable3, linkById);
                accessibilityNodeInfoObtain2.setText(spannable3.subSequence(realSpanStartAndEnd[0], realSpanStartAndEnd[1]).toString());
                ChatMessageCell.this.captionLayout.getText().length();
                ChatMessageCell.this.captionLayout.getSelectionPath(realSpanStartAndEnd[0], realSpanStartAndEnd[1], this.linkPath);
                this.linkPath.computeBounds(this.rectF, true);
                Rect rect = this.rect;
                RectF rectF = this.rectF;
                rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.rect.offset((int) ChatMessageCell.this.captionX, (int) ChatMessageCell.this.captionY);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
                if (!(ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable)) {
                    return null;
                }
                Spannable spannable4 = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
                ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                if (linkById2 == null) {
                    return null;
                }
                int[] realSpanStartAndEnd2 = ChatMessageCell.this.getRealSpanStartAndEnd(spannable4, linkById2);
                accessibilityNodeInfoObtain2.setText(spannable4.subSequence(realSpanStartAndEnd2[0], realSpanStartAndEnd2[1]).toString());
                Iterator<MessageObject.TextLayoutBlock> it3 = ChatMessageCell.this.currentMessageObject.textLayoutBlocks.iterator();
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
                        this.rect.offset(ChatMessageCell.this.textX, ChatMessageCell.this.textY);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
                if (i9 >= ChatMessageCell.this.botButtons.size()) {
                    return null;
                }
                BotButton botButton = (BotButton) ChatMessageCell.this.botButtons.get(i9);
                accessibilityNodeInfoObtain2.setText(botButton.title.getText());
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(botButton.x, botButton.y, botButton.x + botButton.width, botButton.y + botButton.height);
                this.rect.offset(ChatMessageCell.this.currentMessageObject.isOutOwner() ? (ChatMessageCell.this.getMeasuredWidth() - ChatMessageCell.this.widthForButtons) - AndroidUtilities.dp(10.0f) : ChatMessageCell.this.backgroundDrawableLeft + AndroidUtilities.dp(ChatMessageCell.this.mediaBackground ? 1.0f : 7.0f), ChatMessageCell.this.layoutHeight);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
            } else if (virtualViewId >= 500) {
                int i10 = virtualViewId - 500;
                if (i10 >= ChatMessageCell.this.pollButtons.size()) {
                    return null;
                }
                PollButton pollButton = (PollButton) ChatMessageCell.this.pollButtons.get(i10);
                StringBuilder sb2 = new StringBuilder(pollButton.title.getText());
                if (ChatMessageCell.this.pollVoted) {
                    accessibilityNodeInfoObtain2.setSelected(pollButton.chosen);
                    sb2.append(", ");
                    sb2.append(pollButton.percent);
                    sb2.append("%");
                    if (ChatMessageCell.this.lastPoll != null && ChatMessageCell.this.lastPoll.quiz && pollButton.correct) {
                        sb2.append(", ");
                        sb2.append(LocaleController.getString("AccDescrQuizCorrectAnswer", ir.eitaa.messenger.R.string.AccDescrQuizCorrectAnswer));
                    }
                } else {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                accessibilityNodeInfoObtain2.setText(sb2);
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.addAction(16);
                int i11 = pollButton.y + ChatMessageCell.this.namesOffset;
                int iDp = ChatMessageCell.this.backgroundWidth - AndroidUtilities.dp(76.0f);
                Rect rect3 = this.rect;
                int i12 = pollButton.x;
                rect3.set(i12, i11, iDp + i12, pollButton.height + i11);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 495) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setText(LocaleController.getString("AccDescrQuizExplanation", ir.eitaa.messenger.R.string.AccDescrQuizExplanation));
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(ChatMessageCell.this.pollHintX - AndroidUtilities.dp(8.0f), ChatMessageCell.this.pollHintY - AndroidUtilities.dp(8.0f), ChatMessageCell.this.pollHintX + AndroidUtilities.dp(32.0f), ChatMessageCell.this.pollHintY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 499) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (ChatMessageCell.this.instantViewLayout != null) {
                    accessibilityNodeInfoObtain2.setText(ChatMessageCell.this.instantViewLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                ChatMessageCell.this.instantButtonRect.round(this.rect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 498) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.ImageButton");
                accessibilityNodeInfoObtain2.setEnabled(true);
                ChatMessageCell chatMessageCell3 = ChatMessageCell.this;
                if (chatMessageCell3.isOpenChatByShare(chatMessageCell3.currentMessageObject)) {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("AccDescrOpenChat", ir.eitaa.messenger.R.string.AccDescrOpenChat));
                } else {
                    accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("ShareFile", ir.eitaa.messenger.R.string.ShareFile));
                }
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set((int) ChatMessageCell.this.sideStartX, (int) ChatMessageCell.this.sideStartY, ((int) ChatMessageCell.this.sideStartX) + AndroidUtilities.dp(40.0f), ((int) ChatMessageCell.this.sideStartY) + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 497) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(LocaleController.getString("Reply", ir.eitaa.messenger.R.string.Reply));
                sb3.append(", ");
                StaticLayout staticLayout = ChatMessageCell.this.replyNameLayout;
                if (staticLayout != null) {
                    sb3.append(staticLayout.getText());
                    sb3.append(", ");
                }
                StaticLayout staticLayout2 = ChatMessageCell.this.replyTextLayout;
                if (staticLayout2 != null) {
                    sb3.append(staticLayout2.getText());
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb3.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                Rect rect4 = this.rect;
                ChatMessageCell chatMessageCell4 = ChatMessageCell.this;
                int i13 = chatMessageCell4.replyStartX;
                rect4.set(i13, chatMessageCell4.replyStartY, Math.max(chatMessageCell4.replyNameWidth, ChatMessageCell.this.replyTextWidth) + i13, ChatMessageCell.this.replyStartY + AndroidUtilities.dp(35.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 494) {
                accessibilityNodeInfoObtain2.setEnabled(true);
                StringBuilder sb4 = new StringBuilder();
                if (ChatMessageCell.this.forwardedNameLayout[0] != null && ChatMessageCell.this.forwardedNameLayout[1] != null) {
                    int i14 = 0;
                    while (i14 < 2) {
                        sb4.append(ChatMessageCell.this.forwardedNameLayout[i14].getText());
                        sb4.append(i14 == 0 ? " " : "\n");
                        i14++;
                    }
                }
                accessibilityNodeInfoObtain2.setContentDescription(sb4.toString());
                accessibilityNodeInfoObtain2.addAction(16);
                int iMin = (int) Math.min(ChatMessageCell.this.forwardNameX - ChatMessageCell.this.forwardNameOffsetX[0], ChatMessageCell.this.forwardNameX - ChatMessageCell.this.forwardNameOffsetX[1]);
                this.rect.set(iMin, ChatMessageCell.this.forwardNameY, ChatMessageCell.this.forwardedNameWidth + iMin, ChatMessageCell.this.forwardNameY + AndroidUtilities.dp(32.0f));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClickable(true);
            } else if (virtualViewId == 496) {
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                if (ChatMessageCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain2.setText(ChatMessageCell.this.commentLayout.getText());
                }
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(ChatMessageCell.this.commentButtonRect);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(virtualViewId)).equals(this.rect)) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(virtualViewId, new Rect(this.rect));
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
                ChatMessageCell.this.performAccessibilityAction(action, arguments);
            } else if (action == 64) {
                ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 32768);
            } else {
                if (action == 16) {
                    if (virtualViewId >= 3000) {
                        ClickableSpan linkById = getLinkById(virtualViewId, true);
                        if (linkById != null) {
                            ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById, false);
                            ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 2000) {
                        ClickableSpan linkById2 = getLinkById(virtualViewId, false);
                        if (linkById2 != null) {
                            ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById2, false);
                            ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                        }
                    } else if (virtualViewId >= 1000) {
                        int i = virtualViewId - 1000;
                        if (i >= ChatMessageCell.this.botButtons.size()) {
                            return false;
                        }
                        BotButton botButton = (BotButton) ChatMessageCell.this.botButtons.get(i);
                        if (ChatMessageCell.this.delegate != null) {
                            if (botButton.button != null) {
                                ChatMessageCell.this.delegate.didPressBotButton(ChatMessageCell.this, botButton.button);
                            } else if (botButton.reaction != null) {
                                ChatMessageCell.this.delegate.didPressReaction(ChatMessageCell.this, botButton.reaction);
                            }
                        }
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId >= 500) {
                        int i2 = virtualViewId - 500;
                        if (i2 >= ChatMessageCell.this.pollButtons.size()) {
                            return false;
                        }
                        PollButton pollButton = (PollButton) ChatMessageCell.this.pollButtons.get(i2);
                        if (ChatMessageCell.this.delegate != null) {
                            ArrayList<TLRPC$TL_pollAnswer> arrayList = new ArrayList<>();
                            arrayList.add(pollButton.answer);
                            ChatMessageCell.this.delegate.didPressVoteButtons(ChatMessageCell.this, arrayList, -1, 0, 0);
                        }
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 1);
                    } else if (virtualViewId == 495) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell.this.delegate.didPressHint(ChatMessageCell.this, 0);
                        }
                    } else if (virtualViewId == 499) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCellDelegate chatMessageCellDelegate = ChatMessageCell.this.delegate;
                            ChatMessageCell chatMessageCell = ChatMessageCell.this;
                            chatMessageCellDelegate.didPressInstantButton(chatMessageCell, chatMessageCell.drawInstantViewType);
                        }
                    } else if (virtualViewId == 498) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell.this.delegate.didPressSideButton(ChatMessageCell.this);
                        }
                    } else if (virtualViewId == 497) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell chatMessageCell2 = ChatMessageCell.this;
                            if ((!chatMessageCell2.isThreadChat || chatMessageCell2.currentMessageObject.getReplyTopMsgId() != 0) && ChatMessageCell.this.currentMessageObject.hasValidReplyMessageObject()) {
                                ChatMessageCellDelegate chatMessageCellDelegate2 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell3 = ChatMessageCell.this;
                                chatMessageCellDelegate2.didPressReplyMessage(chatMessageCell3, chatMessageCell3.currentMessageObject.getReplyMsgId());
                            }
                        }
                    } else if (virtualViewId == 494) {
                        if (ChatMessageCell.this.delegate != null) {
                            if (ChatMessageCell.this.currentForwardChannel != null) {
                                ChatMessageCellDelegate chatMessageCellDelegate3 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell4 = ChatMessageCell.this;
                                chatMessageCellDelegate3.didPressChannelAvatar(chatMessageCell4, chatMessageCell4.currentForwardChannel, ChatMessageCell.this.currentMessageObject.messageOwner.fwd_from.channel_post, ChatMessageCell.this.lastTouchX, ChatMessageCell.this.lastTouchY);
                            } else if (ChatMessageCell.this.currentForwardUser != null) {
                                ChatMessageCellDelegate chatMessageCellDelegate4 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell5 = ChatMessageCell.this;
                                chatMessageCellDelegate4.didPressUserAvatar(chatMessageCell5, chatMessageCell5.currentForwardUser, ChatMessageCell.this.lastTouchX, ChatMessageCell.this.lastTouchY);
                            } else if (ChatMessageCell.this.currentForwardName != null) {
                                ChatMessageCell.this.delegate.didPressHiddenForward(ChatMessageCell.this);
                            }
                        }
                    } else if (virtualViewId == 496 && ChatMessageCell.this.delegate != null) {
                        ChatMessageCell chatMessageCell6 = ChatMessageCell.this;
                        if (chatMessageCell6.isRepliesChat) {
                            chatMessageCell6.delegate.didPressSideButton(ChatMessageCell.this);
                        } else {
                            chatMessageCell6.delegate.didPressCommentButton(ChatMessageCell.this);
                        }
                    }
                } else if (action == 32) {
                    ClickableSpan linkById3 = getLinkById(virtualViewId, virtualViewId >= 3000);
                    if (linkById3 != null) {
                        ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById3, true);
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(virtualViewId, 2);
                    }
                }
            }
            return true;
        }

        private ClickableSpan getLinkById(int id, boolean caption) {
            if (caption) {
                int i = id - 3000;
                if (!(ChatMessageCell.this.currentMessageObject.caption instanceof Spannable)) {
                    return null;
                }
                Spannable spannable = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
                if (clickableSpanArr.length <= i) {
                    return null;
                }
                return clickableSpanArr[i];
            }
            int i2 = id - 2000;
            if (!(ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable)) {
                return null;
            }
            Spannable spannable2 = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
            ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class);
            if (clickableSpanArr2.length <= i2) {
                return null;
            }
            return clickableSpanArr2[i2];
        }
    }

    public void setImageCoords(float x, float y, float w, float h) {
        this.photoImage.setImageCoords(x, y, w, h);
        int i = this.documentAttachType;
        if (i == 4 || i == 2) {
            this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
            int imageY = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
            this.videoButtonY = imageY;
            RadialProgress2 radialProgress2 = this.videoRadialProgress;
            int i2 = this.videoButtonX;
            radialProgress2.setProgressRect(i2, imageY, AndroidUtilities.dp(24.0f) + i2, this.videoButtonY + AndroidUtilities.dp(24.0f));
            this.buttonX = (int) (x + ((this.photoImage.getImageWidth() - AndroidUtilities.dp(48.0f)) / 2.0f));
            int imageY2 = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - AndroidUtilities.dp(48.0f)) / 2.0f));
            this.buttonY = imageY2;
            RadialProgress2 radialProgress22 = this.radialProgress;
            int i3 = this.buttonX;
            radialProgress22.setProgressRect(i3, imageY2, AndroidUtilities.dp(48.0f) + i3, this.buttonY + AndroidUtilities.dp(48.0f));
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

    public boolean isPlayingRound() {
        return this.isRoundVideo && this.isPlayingRound;
    }

    public int getParentWidth() {
        int i;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            messageObject = this.messageObjectToSet;
        }
        return (messageObject == null || !messageObject.preview || (i = this.parentWidth) <= 0) ? AndroidUtilities.displaySize.x : i;
    }

    public class TransitionParams {
        public boolean animateBackgroundBoundsInner;
        private boolean animateButton;
        public boolean animateChange;
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
        int animateForwardNameWidth;
        float animateForwardNameX;
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
        private float animateNameX;
        private StaticLayout animateOutCaptionLayout;
        private ArrayList<MessageObject.TextLayoutBlock> animateOutTextBlocks;
        private boolean animatePinned;
        public boolean animatePlayingRound;
        public boolean animateRadius;
        boolean animateReplaceCaptionLayout;
        private boolean animateReplies;
        private StaticLayout animateRepliesLayout;
        private boolean animateShouldDrawMenuDrawable;
        private boolean animateShouldDrawTimeOnMedia;
        private boolean animateSign;
        public boolean animateText;
        private StaticLayout animateTimeLayout;
        private int animateTimeWidth;
        public float animateToImageH;
        public float animateToImageW;
        public float animateToImageX;
        public float animateToImageY;
        public int[] animateToRadius;
        private int animateTotalCommentWidth;
        private StaticLayout animateViewsLayout;
        public float captionFromX;
        public float captionFromY;
        public float deltaBottom;
        public float deltaLeft;
        public float deltaRight;
        public float deltaTop;
        public boolean drawPinnedBottomBackground;
        public boolean ignoreAlpha;
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

        public boolean supportChangeAnimation() {
            return true;
        }

        public TransitionParams() {
        }

        public void recordDrawingState() {
            this.wasDraw = true;
            this.lastDrawingImageX = ChatMessageCell.this.photoImage.getImageX();
            this.lastDrawingImageY = ChatMessageCell.this.photoImage.getImageY();
            this.lastDrawingImageW = ChatMessageCell.this.photoImage.getImageWidth();
            this.lastDrawingImageH = ChatMessageCell.this.photoImage.getImageHeight();
            System.arraycopy(ChatMessageCell.this.photoImage.getRoundRadius(), 0, this.imageRoundRadius, 0, 4);
            if (ChatMessageCell.this.currentBackgroundDrawable != null) {
                this.lastDrawingBackgroundRect.set(ChatMessageCell.this.currentBackgroundDrawable.getBounds());
            }
            this.lastDrawingTextBlocks = ChatMessageCell.this.currentMessageObject.textLayoutBlocks;
            this.lastDrawingEdited = ChatMessageCell.this.edited;
            this.lastDrawingCaptionX = ChatMessageCell.this.captionX;
            this.lastDrawingCaptionY = ChatMessageCell.this.captionY;
            this.lastDrawingCaptionLayout = ChatMessageCell.this.captionLayout;
            if (!ChatMessageCell.this.botButtons.isEmpty()) {
                this.lastDrawBotButtons.clear();
                this.lastDrawBotButtons.addAll(ChatMessageCell.this.botButtons);
            }
            if (ChatMessageCell.this.commentLayout != null) {
                this.lastCommentsCount = ChatMessageCell.this.getRepliesCount();
                this.lastTotalCommentWidth = ChatMessageCell.this.totalCommentWidth;
                this.lastCommentLayout = ChatMessageCell.this.commentLayout;
                this.lastCommentArrowX = ChatMessageCell.this.commentArrowX;
                this.lastCommentUnreadX = ChatMessageCell.this.commentUnreadX;
                this.lastCommentDrawUnread = ChatMessageCell.this.commentDrawUnread;
                this.lastCommentX = ChatMessageCell.this.commentX;
                this.lastDrawCommentNumber = ChatMessageCell.this.drawCommentNumber;
            }
            this.lastRepliesCount = ChatMessageCell.this.getRepliesCount();
            this.lastViewsCount = ChatMessageCell.this.getMessageObject().messageOwner.views;
            this.lastRepliesLayout = ChatMessageCell.this.repliesLayout;
            this.lastViewsLayout = ChatMessageCell.this.viewsLayout;
            ChatMessageCell chatMessageCell = ChatMessageCell.this;
            this.lastIsPinned = chatMessageCell.isPinned;
            this.lastSignMessage = chatMessageCell.lastPostAuthor;
            this.lastButtonX = ChatMessageCell.this.buttonX;
            this.lastButtonY = ChatMessageCell.this.buttonY;
            this.lastDrawTime = !ChatMessageCell.this.forceNotDrawTime;
            this.lastTimeX = ChatMessageCell.this.timeX;
            this.lastTimeLayout = ChatMessageCell.this.timeLayout;
            this.lastTimeWidth = ChatMessageCell.this.timeWidth;
            this.lastShouldDrawTimeOnMedia = ChatMessageCell.this.shouldDrawTimeOnMedia();
            this.lastTopOffset = ChatMessageCell.this.getTopMediaOffset();
            this.lastShouldDrawMenuDrawable = ChatMessageCell.this.shouldDrawMenuDrawable();
            this.lastLocatinIsExpired = ChatMessageCell.this.locationExpired;
            this.lastIsPlayingRound = ChatMessageCell.this.isPlayingRound;
            this.lastDrawingTextY = ChatMessageCell.this.textY;
            this.lastDrawingTextX = ChatMessageCell.this.textX;
            this.lastDrawnForwardedNameLayout[0] = ChatMessageCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = ChatMessageCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = ChatMessageCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = ChatMessageCell.this.forwardNameX;
            this.lastForwardedNamesOffset = ChatMessageCell.this.namesOffset;
            this.lastForwardNameWidth = ChatMessageCell.this.forwardedNameWidth;
        }

        public void recordDrawingStatePreview() {
            this.lastDrawnForwardedNameLayout[0] = ChatMessageCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = ChatMessageCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = ChatMessageCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = ChatMessageCell.this.forwardNameX;
            this.lastForwardedNamesOffset = ChatMessageCell.this.namesOffset;
            this.lastForwardNameWidth = ChatMessageCell.this.forwardedNameWidth;
        }

        /* JADX WARN: Removed duplicated region for block: B:135:0x033d  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0349  */
        /* JADX WARN: Removed duplicated region for block: B:141:0x0355  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x0365  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean animateChange() {
            /*
                Method dump skipped, instructions count: 927
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.TransitionParams.animateChange():boolean");
        }

        public void onDetach() {
            this.wasDraw = false;
        }

        public void resetAnimation() {
            this.animateChange = false;
            this.animatePinned = false;
            this.animateBackgroundBoundsInner = false;
            this.deltaLeft = 0.0f;
            this.deltaRight = 0.0f;
            this.deltaBottom = 0.0f;
            this.deltaTop = 0.0f;
            if (this.imageChangeBoundsTransition && this.animateToImageW != 0.0f && this.animateToImageH != 0.0f) {
                ChatMessageCell.this.photoImage.setImageCoords(this.animateToImageX, this.animateToImageY, this.animateToImageW, this.animateToImageH);
            }
            if (this.animateRadius) {
                ChatMessageCell.this.photoImage.setRoundRadius(this.animateToRadius);
            }
            this.animateToImageX = 0.0f;
            this.animateToImageY = 0.0f;
            this.animateToImageW = 0.0f;
            this.animateToImageH = 0.0f;
            this.imageChangeBoundsTransition = false;
            this.changePinnedBottomProgress = 1.0f;
            this.captionEnterProgress = 1.0f;
            this.animateRadius = false;
            this.animateChangeProgress = 1.0f;
            this.animateMessageText = false;
            this.animateOutTextBlocks = null;
            this.animateEditedLayout = null;
            this.animateTimeLayout = null;
            this.animateEditedEnter = false;
            this.animateReplaceCaptionLayout = false;
            this.transformGroupToSingleMessage = false;
            this.animateOutCaptionLayout = null;
            this.moveCaption = false;
            this.animateDrawingTimeAlpha = false;
            this.transitionBotButtons.clear();
            this.animateButton = false;
            this.animateReplies = false;
            this.animateRepliesLayout = null;
            this.animateComments = false;
            this.animateCommentsLayout = null;
            this.animateViewsLayout = null;
            this.animateShouldDrawTimeOnMedia = false;
            this.animateShouldDrawMenuDrawable = false;
            this.shouldAnimateTimeX = false;
            this.animateSign = false;
            this.animateDrawingTimeAlpha = false;
            this.animateLocationIsExpired = false;
            this.animatePlayingRound = false;
            this.animateText = false;
            this.animateForwardedLayout = false;
            StaticLayout[] staticLayoutArr = this.animatingForwardedNameLayout;
            staticLayoutArr[0] = null;
            staticLayoutArr[1] = null;
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
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isOutOwner()
                r1 = 8
                r2 = 4
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L7a
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L65
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L2a
                goto L65
            L2a:
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isSendError()
                if (r0 == 0) goto L3b
                r0 = 0
                r3 = 0
                r5 = 0
                r6 = 1
                goto L69
            L3b:
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isSent()
                if (r0 == 0) goto L61
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.scheduled
                if (r0 != 0) goto L5f
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
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
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L94
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L93
                goto L94
            L93:
                r3 = 0
            L94:
                ir.eitaa.ui.Cells.ChatMessageCell r0 = ir.eitaa.ui.Cells.ChatMessageCell.this
                ir.eitaa.messenger.MessageObject r0 = ir.eitaa.ui.Cells.ChatMessageCell.access$600(r0)
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
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatMessageCell.TransitionParams.createStatusDrawableParams():int");
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
}
