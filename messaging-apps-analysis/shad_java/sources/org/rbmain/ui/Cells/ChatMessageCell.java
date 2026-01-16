package org.rbmain.ui.Cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
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
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.ShopModels;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.WebFile;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageFwdHeader;
import org.rbmain.tgnet.TLRPC$MessagePeerReaction;
import org.rbmain.tgnet.TLRPC$MessageReplies;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$Poll;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$ReactionCount;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeVideo;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonBuy;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonGame;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestPeer;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonSwitchInline;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrl;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_stickerSet;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.tgnet.TLRPC$TL_pollAnswer;
import org.rbmain.tgnet.TLRPC$TL_pollAnswerVoters;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_webPage;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.TextSelectionHelper;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.AnimatedFileDrawable;
import org.rbmain.ui.Components.AnimatedFloat;
import org.rbmain.ui.Components.AnimatedNumberLayout;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.CheckBoxBase;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.InfiniteProgress;
import org.rbmain.ui.Components.LinkPath;
import org.rbmain.ui.Components.LinkSpanDrawable;
import org.rbmain.ui.Components.LoadingDrawable;
import org.rbmain.ui.Components.MessageBackgroundDrawable;
import org.rbmain.ui.Components.MotionBackgroundDrawable;
import org.rbmain.ui.Components.MsgClockDrawable;
import org.rbmain.ui.Components.Point;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RadialProgress2;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.RoundVideoPlayingDrawable;
import org.rbmain.ui.Components.SeekBar;
import org.rbmain.ui.Components.SeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.SeekBarWaveform;
import org.rbmain.ui.Components.SlotsDrawable;
import org.rbmain.ui.Components.StaticLayoutEx;
import org.rbmain.ui.Components.TextStyleSpan;
import org.rbmain.ui.Components.TimerParticles;
import org.rbmain.ui.Components.TranscribeButton;
import org.rbmain.ui.Components.TypefaceSpan;
import org.rbmain.ui.Components.URLSpanBotCommand;
import org.rbmain.ui.Components.URLSpanBrowser;
import org.rbmain.ui.Components.URLSpanMono;
import org.rbmain.ui.Components.URLSpanNoUnderline;
import org.rbmain.ui.Components.VideoForwardDrawable;
import org.rbmain.ui.Components.spoilers.SpoilerEffect;
import org.rbmain.ui.PhotoViewer;
import org.rbmain.ui.PinchToZoomHelper;
import org.xml.sax.SAXException;

/* loaded from: classes4.dex */
public class ChatMessageCell extends BaseCell implements SeekBar.SeekBarDelegate, ImageReceiver.ImageReceiverDelegate, DownloadController.FileDownloadProgressListener, TextSelectionHelper.SelectableView, NotificationCenter.NotificationCenterDelegate {
    private static float[] radii = new float[8];
    private final boolean ALPHA_PROPERTY_WORKAROUND;
    public Property<ChatMessageCell, Float> ANIMATION_OFFSET_X;
    private int TAG;
    private boolean absReceiverWalletPressed;
    private boolean absSenderWalletPressed;
    CharSequence accessibilityText;
    private boolean accessibilityTextContentUnread;
    private long accessibilityTextFileSize;
    private boolean accessibilityTextUnread;
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
    public AnimatedEmojiSpan.EmojiGroupedSpans animatedEmojiDescriptionStack;
    public AnimatedEmojiSpan.EmojiGroupedSpans animatedEmojiReplyStack;
    public AnimatedEmojiSpan.EmojiGroupedSpans animatedEmojiStack;
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
    private Theme.MessageDrawable.PathDrawParams backgroundCacheParams;
    private MessageBackgroundDrawable backgroundDrawable;
    private int backgroundDrawableBottom;
    private int backgroundDrawableLeft;
    private int backgroundDrawableRight;
    private int backgroundDrawableTop;
    private int backgroundHeight;
    private int backgroundWidth;
    private ImageReceiver blurredPhotoImage;
    private int blurredViewBottomOffset;
    private int blurredViewTopOffset;
    private Path botButtonPath;
    private float[] botButtonRadii;
    private ArrayList<BotButton> botButtons;
    private HashMap<String, BotButton> botButtonsByData;
    private HashMap<String, BotButton> botButtonsByPosition;
    private String botButtonsLayout;
    private boolean bottomNearToSet;
    private int buttonPressed;
    private int buttonState;
    private int buttonX;
    private int buttonY;
    private final boolean canDrawBackgroundInParent;
    private boolean canStreamVideo;
    private int captionHeight;
    private StaticLayout captionLayout;
    private int captionOffsetX;
    private AtomicReference<Layout> captionPatchedSpoilersLayout;
    private List<SpoilerEffect> captionSpoilers;
    private Stack<SpoilerEffect> captionSpoilersPool;
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
    private StaticLayout currencyTitle;
    private StaticLayout currencyValue;
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
    private Object currentNameStatus;
    private AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable currentNameStatusDrawable;
    private String currentNameString;
    private TLRPC$FileLocation currentPhoto;
    private String currentPhotoFilter;
    private String currentPhotoFilterThumb;
    private TLRPC$PhotoSize currentPhotoObject;
    private TLRPC$PhotoSize currentPhotoObjectThumb;
    private BitmapDrawable currentPhotoObjectThumbStripped;
    private MessageObject.GroupedMessagePosition currentPosition;
    private String currentRepliesString;
    private TLRPC$PhotoSize currentReplyPhoto;
    private int currentReplyUserId;
    private float currentSelectedBackgroundAlpha;
    private CharSequence currentTimeString;
    private String currentUnlockString;
    private String currentUrl;
    private TLRPC$User currentUser;
    private TLRPC$User currentViaBotUser;
    private String currentViewsString;
    private WebFile currentWebFile;
    private StaticLayout dateTitle;
    private StaticLayout dateValue;
    private ChatMessageCellDelegate delegate;
    private RectF deleteProgressRect;
    private StaticLayout descriptionLayout;
    private StaticLayout descriptionTitle;
    private StaticLayout descriptionValue;
    private int descriptionX;
    private int descriptionY;
    private Runnable diceFinishCallback;
    private boolean disallowLongPress;
    private StaticLayout docTitleLayout;
    private int docTitleOffsetX;
    private int docTitleWidth;
    private TLRPC$Document documentAttach;
    private int documentAttachType;
    private StaticLayout doneTitle;
    private boolean drawBackground;
    private boolean drawCommentButton;
    private boolean drawCommentNumber;
    public boolean drawForBlur;
    private boolean drawForwardedName;
    public boolean drawFromPinchToZoom;
    private boolean drawImageButton;
    private boolean drawInstantView;
    private int drawInstantViewType;
    private boolean drawMediaCheckBox;
    private boolean drawName;
    private boolean drawNameLayout;
    private boolean drawPhotoImage;
    public boolean drawPinnedBottom;
    private boolean drawPinnedTop;
    private boolean drawRadialCheckBackground;
    private boolean drawSelectionBackground;
    private int drawSideButton;
    private boolean drawTime;
    private float drawTimeX;
    private float drawTimeY;
    private boolean drawTopic;
    private boolean drawVideoImageButton;
    private boolean drawVideoSize;
    private Paint drillHolePaint;
    private Path drillHolePath;
    private StaticLayout durationLayout;
    private int durationWidth;
    private boolean edited;
    boolean enterTransitionInProgress;
    private boolean firstCircleLength;
    private int firstVisibleBlockNum;
    private boolean flipImage;
    private boolean forceNotDrawTime;
    private boolean forwardBotPressed;
    private int forwardHeight;
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
    private boolean hadLongPress;
    public boolean hasDiscussion;
    private boolean hasEmbed;
    private boolean hasGamePreview;
    private boolean hasInvoicePreview;
    private boolean hasLinkPreview;
    private int hasMiniProgress;
    private boolean hasNewLineForTime;
    private boolean hasOldCaptionPreview;
    private boolean hasPsaHint;
    private LinkPath highlightPath;
    private CharacterStyle highlightPathSpan;
    private long highlightPathStart;
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
    boolean imageReceiversAttachState;
    private boolean inLayout;
    private StaticLayout infoLayout;
    private StaticLayout infoLayoutLiveParticipants;
    private int infoWidth;
    private int infoWidthLiveParticipant;
    private int infoX;
    private LoadingDrawable instantButtonLoading;
    private ValueAnimator instantButtonPressAnimator;
    private float instantButtonPressProgress;
    private boolean instantButtonPressed;
    private RectF instantButtonRect;
    private boolean instantPressed;
    private int instantTextLeftX;
    private boolean instantTextNewLine;
    private int instantTextX;
    private StaticLayout instantViewLayout;
    private int instantWidth;
    private Runnable invalidateRunnable;
    private boolean invalidateSpoilersParent;
    private boolean invalidatesParent;
    private boolean isAvatarVisible;
    public boolean isBlurred;
    public boolean isBot;
    private boolean isCaptionSpoilerPressed;
    public boolean isChat;
    private boolean isCheckPressed;
    public boolean isForum;
    public boolean isForumGeneral;
    private boolean isHiddenForward;
    private boolean isHighlighted;
    private boolean isHighlightedAnimated;
    private boolean isLiveInProgress;
    public boolean isMegagroup;
    public boolean isPinned;
    public boolean isPinnedChat;
    private boolean isPlayingRound;
    private boolean isPressed;
    public boolean isRepliesChat;
    private boolean isRoundVideo;
    private boolean isSmallImage;
    private boolean isSpoilerRevealing;
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
    private boolean lastTranslated;
    private int lastViewsCount;
    private int lastVisibleBlockNum;
    private int lastWidth;
    private int layoutHeight;
    private int layoutWidth;
    private int linkBlockNum;
    private int linkPreviewHeight;
    private boolean linkPreviewPressed;
    private int linkSelectionBlockNum;
    public int linkedChatId;
    private LinkSpanDrawable.LinkCollector links;
    private StaticLayout liveStatusLayout;
    private int liveStatusWidth;
    private StaticLayout loadingProgressLayout;
    private long loadingProgressLayoutHash;
    private boolean locationExpired;
    private ImageReceiver locationImageReceiver;
    private Drawable locationLoadingThumb;
    private boolean mediaBackground;
    private CheckBoxBase mediaCheckBox;
    private int mediaOffsetY;
    private SpoilerEffect mediaSpoilerEffect;
    private Path mediaSpoilerPath;
    private float[] mediaSpoilerRadii;
    private float mediaSpoilerRevealMaxRadius;
    private float mediaSpoilerRevealProgress;
    private float mediaSpoilerRevealX;
    private float mediaSpoilerRevealY;
    private boolean mediaWasInvisible;
    private MessageObject messageObjectToSet;
    private int miniButtonPressed;
    private int miniButtonState;
    private int minutes;
    private MotionBackgroundDrawable motionBackgroundDrawable;
    private StaticLayout nameLayout;
    private int nameLayoutWidth;
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
    int parentBoundsBottom;
    float parentBoundsTop;
    private int parentHeight;
    public float parentViewTopOffset;
    private int parentWidth;
    private StaticLayout performerLayout;
    private int performerX;
    private ImageReceiver photoImage;
    private boolean photoImageOutOfBounds;
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
    private boolean pollInstantViewTouchesBottom;
    private boolean pollUnvoteInProgress;
    private boolean pollVoteInProgress;
    private int pollVoteInProgressNum;
    private boolean pollVoted;
    private int pressedBotButton;
    private AnimatedEmojiSpan pressedEmoji;
    private LinkSpanDrawable pressedLink;
    private int pressedLinkType;
    private int[] pressedState;
    private int pressedVoteButton;
    private CharacterStyle progressLoadingLink;
    private LoadingDrawable progressLoadingLinkCurrentDrawable;
    private ArrayList<LoadingDrawableLocation> progressLoadingLinkDrawables;
    private float psaButtonProgress;
    private boolean psaButtonVisible;
    private int psaHelpX;
    private int psaHelpY;
    private boolean psaHintPressed;
    private RadialProgress2 radialProgress;
    public final ReactionsLayoutInBubble reactionsLayoutInBubble;
    private StaticLayout receiverTitle;
    private StaticLayout receiverValue;
    private RectF rect;
    private Path rectPath;
    private StaticLayout repliesLayout;
    private int repliesTextWidth;
    public float replyHeight;
    public ImageReceiver replyImageReceiver;
    public LoadingDrawable replyLoadingDrawable;
    private float[] replyLoadingSegment;
    private float replyLoadingT;
    public StaticLayout replyNameLayout;
    private int replyNameOffset;
    private int replyNameWidth;
    private boolean replyPanelIsForward;
    private boolean replyPressed;
    private AnimatedFloat replyPressedFloat;
    private Path replyRoundRectPath;
    private float[] replyRoundRectRadii;
    public Drawable replySelector;
    private boolean replySelectorCanBePressed;
    public int replySelectorColor;
    private boolean replySelectorPressed;
    public float replySelectorRadLeft;
    public float replySelectorRadRight;
    public Rect replySelectorRect;
    public List<SpoilerEffect> replySpoilers;
    private Stack<SpoilerEffect> replySpoilersPool;
    public int replyStartX;
    public int replyStartY;
    public StaticLayout replyTextLayout;
    private int replyTextOffset;
    private int replyTextWidth;
    private float replyTouchX;
    private float replyTouchY;
    private Theme.ResourcesProvider resourcesProvider;
    private float roundPlayingDrawableProgress;
    private float roundProgressAlpha;
    float roundSeekbarOutAlpha;
    float roundSeekbarOutProgress;
    int roundSeekbarTouched;
    private float roundToPauseProgress;
    private float roundToPauseProgress2;
    private AnimatedFloat roundVideoPlayPipFloat;
    private RoundVideoPlayingDrawable roundVideoPlayingDrawable;
    private Drawable rubinoProfileDrawable;
    private final ImageReceiver rubinoProfileImage;
    private StaticLayout rubinoProfileName;
    private StaticLayout rubinoStoryName;
    private int rubinoStoryNameWidth;
    private Path sPath;
    private boolean scheduledInvalidate;
    private Rect scrollRect;
    private int seconds;
    private SeekBar seekBar;
    private SeekBarAccessibilityDelegate seekBarAccessibilityDelegate;
    private SeekBarWaveform seekBarWaveform;
    private int seekBarWaveformTranslateX;
    private int seekBarX;
    private int seekBarY;
    float seekbarRoundX;
    float seekbarRoundY;
    private float selectedBackgroundProgress;
    private Paint selectionOverlayPaint;
    private Drawable[] selectorDrawable;
    private int[] selectorDrawableMaskType;
    private StaticLayout senderTitle;
    private StaticLayout senderValue;
    private AnimatorSet shakeAnimation;
    private String shopProductColor;
    private StaticLayout shopProductColorName;
    private StaticLayout shopProductName;
    private StaticLayout shopProductPrice;
    private RectF shopProductPriceRect;
    private Drawable shopProfileDrawable;
    private final ImageReceiver shopProfileImage;
    private StaticLayout shopProfileName;
    public boolean shouldCheckVisibleOnScreen;
    private boolean sideButtonPressed;
    private float sideStartX;
    private float sideStartY;
    private StaticLayout siteNameLayout;
    private boolean siteNameRtl;
    private int siteNameWidth;
    private float slidingOffsetX;
    private StaticLayout songLayout;
    private int songX;
    private SpoilerEffect spoilerPressed;
    private AtomicReference<Layout> spoilersPatchedReplyTextLayout;
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
    private StaticLayout timeValue;
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
    private StaticLayout trackingCodeTitle;
    private StaticLayout trackingCodeValue;
    private AvatarDrawable[] transactionAvatarDrawables;
    private ImageReceiver[] transactionAvatarImages;
    private StaticLayout transactionNotAvailableTitle;
    private TranscribeButton transcribeButton;
    private float transcribeX;
    private float transcribeY;
    private final TransitionParams transitionParams;
    float transitionYOffsetForDrawables;
    private LoadingDrawable translationLoadingDrawable;
    private StaticLayout translationLoadingDrawableLayout;
    private ArrayList<MessageObject.TextLayoutBlock> translationLoadingDrawableText;
    private AnimatedFloat translationLoadingFloat;
    private LinkPath translationLoadingPath;
    private float unlockAlpha;
    private StaticLayout unlockLayout;
    private SpoilerEffect unlockSpoilerEffect;
    private Path unlockSpoilerPath;
    private float[] unlockSpoilerRadii;
    private int unlockTextWidth;
    private float unlockX;
    private float unlockY;
    private int unmovedTextX;
    private ArrayList<LinkPath> urlPathCache;
    private ArrayList<LinkPath> urlPathSelection;
    private boolean useSeekBarWaveform;
    private boolean useTranscribeButton;
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
    private RadialProgress2 videoRadialProgress;
    private float viewTop;
    private StaticLayout viewsLayout;
    private int viewsTextWidth;
    private boolean visibleOnScreen;
    private float voteCurrentCircleLength;
    private float voteCurrentProgressTime;
    private long voteLastUpdateTime;
    private float voteRadOffset;
    private boolean voteRisingCircleLength;
    private boolean wasLayout;
    private boolean wasPinned;
    private boolean wasSending;
    private boolean wasTranscriptionOpen;
    private int widthBeforeNewTimeLine;
    private int widthForButtons;
    private boolean willRemoved;
    private boolean wouldBeInPip;

    public interface ChatMessageCellDelegate {

        /* renamed from: org.rbmain.ui.Cells.ChatMessageCell$ChatMessageCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canDrawOutboundsContent(ChatMessageCellDelegate chatMessageCellDelegate) {
                return true;
            }

            public static boolean $default$canPerformActions(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static void $default$didLongPress(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, float f, float f2) {
            }

            public static void $default$didLongPressBotButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
            }

            public static boolean $default$didLongPressChannelAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2) {
                return false;
            }

            public static boolean $default$didLongPressUserAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2) {
                return false;
            }

            public static boolean $default$didPressAnimatedEmoji(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, AnimatedEmojiSpan animatedEmojiSpan) {
                return false;
            }

            public static void $default$didPressBotButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
            }

            public static void $default$didPressCancelSendButton(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didPressChannelAvatar(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2) {
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

            public static void $default$didPressReaction(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, TLRPC$ReactionCount tLRPC$ReactionCount, boolean z) {
            }

            public static void $default$didPressReplyMessage(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, long j) {
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

            public static void $default$didPressViaBotNotInline(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, int i) {
            }

            public static void $default$didPressVoteButtons(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, ArrayList arrayList, int i, int i2, int i3) {
            }

            public static void $default$didPressedForwardedFrom(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
            }

            public static void $default$didStartVideoStream(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject) {
            }

            public static String $default$getAdminRank(ChatMessageCellDelegate chatMessageCellDelegate, int i) {
                return null;
            }

            public static PinchToZoomHelper $default$getPinchToZoomHelper(ChatMessageCellDelegate chatMessageCellDelegate) {
                return null;
            }

            public static String $default$getProgressLoadingBotButtonUrl(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
                return null;
            }

            public static CharacterStyle $default$getProgressLoadingLink(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell) {
                return null;
            }

            public static TextSelectionHelper.ChatListTextSelectionHelper $default$getTextSelectionHelper(ChatMessageCellDelegate chatMessageCellDelegate) {
                return null;
            }

            public static boolean $default$hasSelectedMessages(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static void $default$invalidateBlur(ChatMessageCellDelegate chatMessageCellDelegate) {
            }

            public static boolean $default$isLandscape(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static boolean $default$isProgressLoading(ChatMessageCellDelegate chatMessageCellDelegate, ChatMessageCell chatMessageCell, int i) {
                return false;
            }

            public static boolean $default$isReplyOrSelf(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static boolean $default$keyboardIsOpened(ChatMessageCellDelegate chatMessageCellDelegate) {
                return false;
            }

            public static void $default$needOpenWebView(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject, String str, String str2, String str3, String str4, int i, int i2) {
            }

            public static boolean $default$needPlayMessage(ChatMessageCellDelegate chatMessageCellDelegate, MessageObject messageObject, boolean z) {
                return false;
            }

            public static void $default$needReloadPolls(ChatMessageCellDelegate chatMessageCellDelegate) {
            }

            public static void $default$needShowPremiumBulletin(ChatMessageCellDelegate chatMessageCellDelegate, int i) {
            }

            public static boolean $default$onAccessibilityAction(ChatMessageCellDelegate chatMessageCellDelegate, int i, Bundle bundle) {
                return false;
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

        boolean canDrawOutboundsContent();

        boolean canPerformActions();

        void didLongPress(ChatMessageCell chatMessageCell, float f, float f2);

        void didLongPressBotButton(ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton);

        boolean didLongPressChannelAvatar(ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2);

        boolean didLongPressUserAvatar(ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2);

        boolean didPressAnimatedEmoji(ChatMessageCell chatMessageCell, AnimatedEmojiSpan animatedEmojiSpan);

        void didPressBotButton(ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton);

        void didPressCancelSendButton(ChatMessageCell chatMessageCell);

        void didPressChannelAvatar(ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2);

        void didPressCommentButton(ChatMessageCell chatMessageCell);

        void didPressHiddenForward(ChatMessageCell chatMessageCell);

        void didPressHint(ChatMessageCell chatMessageCell, int i);

        void didPressImage(ChatMessageCell chatMessageCell, float f, float f2);

        void didPressInstantButton(ChatMessageCell chatMessageCell, int i);

        void didPressOther(ChatMessageCell chatMessageCell, float f, float f2);

        void didPressReaction(ChatMessageCell chatMessageCell, TLRPC$ReactionCount tLRPC$ReactionCount, boolean z);

        void didPressReplyMessage(ChatMessageCell chatMessageCell, long j);

        void didPressSideButton(ChatMessageCell chatMessageCell);

        void didPressTime(ChatMessageCell chatMessageCell);

        void didPressUrl(ChatMessageCell chatMessageCell, CharacterStyle characterStyle, boolean z);

        void didPressUserAvatar(ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2);

        void didPressViaBot(ChatMessageCell chatMessageCell, String str);

        void didPressViaBotNotInline(ChatMessageCell chatMessageCell, int i);

        void didPressVoteButtons(ChatMessageCell chatMessageCell, ArrayList<TLRPC$TL_pollAnswer> arrayList, int i, int i2, int i3);

        void didPressedForwardedFrom(ChatMessageCell chatMessageCell);

        void didStartVideoStream(MessageObject messageObject);

        String getAdminRank(int i);

        PinchToZoomHelper getPinchToZoomHelper();

        String getProgressLoadingBotButtonUrl(ChatMessageCell chatMessageCell);

        CharacterStyle getProgressLoadingLink(ChatMessageCell chatMessageCell);

        TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper();

        boolean hasSelectedMessages();

        void invalidateBlur();

        boolean isLandscape();

        boolean isProgressLoading(ChatMessageCell chatMessageCell, int i);

        boolean isReplyOrSelf();

        boolean keyboardIsOpened();

        void needOpenWebView(MessageObject messageObject, String str, String str2, String str3, String str4, int i, int i2);

        boolean needPlayMessage(MessageObject messageObject, boolean z);

        void needReloadPolls();

        void needShowPremiumBulletin(int i);

        boolean onAccessibilityAction(int i, Bundle bundle);

        void onDiceFinished();

        void setShouldNotRepeatSticker(MessageObject messageObject);

        boolean shouldDrawThreadProgress(ChatMessageCell chatMessageCell);

        boolean shouldRepeatSticker(MessageObject messageObject);

        void videoTimerReached();
    }

    private Object getAuthorStatus() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasGradientService() {
        return false;
    }

    private boolean intersect(float f, float f2, float f3, float f4) {
        return f <= f3 ? f2 >= f3 : f <= f4;
    }

    private void updateFlagSecure() {
    }

    public float getDrawTopicHeight() {
        return 0.0f;
    }

    public void setResourcesProvider(Theme.ResourcesProvider resourcesProvider) {
    }

    public RadialProgress2 getRadialProgress() {
        return this.radialProgress;
    }

    public void setEnterTransitionInProgress(boolean z) {
        this.enterTransitionInProgress = z;
        invalidate();
    }

    public ReactionsLayoutInBubble.ReactionButton getReactionButton(ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
        return this.reactionsLayoutInBubble.getReactionButton(visibleReaction);
    }

    public MessageObject getPrimaryMessageObject() {
        MessageObject messageObject = this.currentMessageObject;
        MessageObject messageObjectFindPrimaryMessageObject = (messageObject == null || this.currentMessagesGroup == null || !messageObject.hasValidGroupId()) ? null : this.currentMessagesGroup.findPrimaryMessageObject();
        return messageObjectFindPrimaryMessageObject != null ? messageObjectFindPrimaryMessageObject : this.currentMessageObject;
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        Integer num;
        if (i == NotificationCenter.startSpoilers) {
            setSpoilersSuppressed(false);
            return;
        }
        if (i == NotificationCenter.stopSpoilers) {
            setSpoilersSuppressed(true);
            return;
        }
        if (i == NotificationCenter.userInfoDidLoad) {
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User == null || (num = (Integer) objArr[0]) == null || tLRPC$User.id != num.intValue()) {
                return;
            }
            setAvatar(this.currentMessageObject);
            return;
        }
        if (i == NotificationCenter.emojiDidLoad) {
            invalidate();
        }
    }

    private void setAvatar(MessageObject messageObject) {
        if (messageObject == null) {
            return;
        }
        if (this.isAvatarVisible) {
            Drawable drawable = messageObject.customAvatarDrawable;
            if (drawable != null) {
                this.avatarImage.setImageBitmap(drawable);
                return;
            }
            TLRPC$User tLRPC$User = this.currentUser;
            if (tLRPC$User != null) {
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = tLRPC$User.photo;
                if (tLRPC$UserProfilePhoto != null) {
                    this.currentPhoto = tLRPC$UserProfilePhoto.photo_small;
                } else {
                    this.currentPhoto = null;
                }
                post(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setAvatar$0();
                    }
                });
                return;
            }
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat != null) {
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                if (tLRPC$ChatPhoto != null) {
                    this.currentPhoto = tLRPC$ChatPhoto.photo_small;
                } else {
                    this.currentPhoto = null;
                }
                post(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$setAvatar$1();
                    }
                });
                return;
            }
            if (messageObject.isSponsored()) {
                return;
            }
            this.currentPhoto = null;
            this.avatarDrawable.setInfo(messageObject.getFromChatId(), null, null);
            this.avatarImage.setImage(null, null, this.avatarDrawable, null, null, 0);
            return;
        }
        this.currentPhoto = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAvatar$0() {
        this.avatarDrawable.setInfo(this.currentUser);
        this.avatarImage.setForUserOrChat(this.currentUser, this.avatarDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAvatar$1() {
        this.avatarDrawable.setInfo(this.currentChat);
        this.avatarImage.setForUserOrChat(this.currentChat, this.avatarDrawable);
    }

    public void setSpoilersSuppressed(boolean z) {
        for (int i = 0; i < this.captionSpoilers.size(); i++) {
            this.captionSpoilers.get(i).setSuppressUpdates(z);
        }
        for (int i2 = 0; i2 < this.replySpoilers.size(); i2++) {
            this.replySpoilers.get(i2).setSuppressUpdates(z);
        }
        if (getMessageObject() == null || getMessageObject().textLayoutBlocks == null) {
            return;
        }
        for (int i3 = 0; i3 < getMessageObject().textLayoutBlocks.size(); i3++) {
            MessageObject.TextLayoutBlock textLayoutBlock = getMessageObject().textLayoutBlocks.get(i3);
            for (int i4 = 0; i4 < textLayoutBlock.spoilers.size(); i4++) {
                textLayoutBlock.spoilers.get(i4).setSuppressUpdates(z);
            }
        }
    }

    public boolean hasSpoilers() {
        if ((hasCaptionLayout() && !this.captionSpoilers.isEmpty()) || (this.replyTextLayout != null && !this.replySpoilers.isEmpty())) {
            return true;
        }
        if (getMessageObject() == null || getMessageObject().textLayoutBlocks == null) {
            return false;
        }
        Iterator<MessageObject.TextLayoutBlock> it = getMessageObject().textLayoutBlocks.iterator();
        while (it.hasNext()) {
            if (!it.next().spoilers.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void updateSpoilersVisiblePart(int i, int i2) {
        if (hasCaptionLayout()) {
            float f = -this.captionY;
            Iterator<SpoilerEffect> it = this.captionSpoilers.iterator();
            while (it.hasNext()) {
                it.next().setVisibleBounds(0.0f, i + f, getWidth(), i2 + f);
            }
        }
        StaticLayout staticLayout = this.replyTextLayout;
        if (staticLayout != null) {
            float height = (-this.replyStartY) - staticLayout.getHeight();
            Iterator<SpoilerEffect> it2 = this.replySpoilers.iterator();
            while (it2.hasNext()) {
                it2.next().setVisibleBounds(0.0f, i + height, getWidth(), i2 + height);
            }
        }
        if (getMessageObject() == null || getMessageObject().textLayoutBlocks == null) {
            return;
        }
        Iterator<MessageObject.TextLayoutBlock> it3 = getMessageObject().textLayoutBlocks.iterator();
        while (it3.hasNext()) {
            MessageObject.TextLayoutBlock next = it3.next();
            Iterator<SpoilerEffect> it4 = next.spoilers.iterator();
            while (it4.hasNext()) {
                it4.next().setVisibleBounds(0.0f, (i - next.textYOffset) - this.textY, getWidth(), (i2 - next.textYOffset) - this.textY);
            }
        }
    }

    public void setScrimReaction(String str) {
        this.reactionsLayoutInBubble.setScrimReaction(str);
    }

    public void drawScrimReaction(Canvas canvas, String str) {
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if (groupedMessagePosition != null) {
            int i = groupedMessagePosition.flags;
            if ((i & 8) == 0 || (i & 1) == 0) {
                return;
            }
        }
        ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
        if (reactionsLayoutInBubble.isSmall) {
            return;
        }
        reactionsLayoutInBubble.draw(canvas, this.transitionParams.animateChangeProgress, str);
    }

    public boolean checkUnreadReactions(float f, int i) {
        if (!this.reactionsLayoutInBubble.hasUnreadReactions) {
            return false;
        }
        float y = getY();
        float f2 = y + r2.y;
        return f2 > f && (f2 + ((float) this.reactionsLayoutInBubble.height)) - ((float) AndroidUtilities.dp(16.0f)) < ((float) i);
    }

    public void markReactionsAsRead() {
        this.reactionsLayoutInBubble.hasUnreadReactions = false;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        messageObject.markReactionsAsRead();
    }

    public void setVisibleOnScreen(boolean z) {
        if (this.visibleOnScreen != z) {
            this.visibleOnScreen = z;
            checkImageReceiversAttachState();
            if (z) {
                invalidate();
            }
        }
    }

    public void setParentBounds(float f, int i) {
        this.parentBoundsTop = f;
        this.parentBoundsBottom = i;
        if (this.photoImageOutOfBounds) {
            float y = getY() + this.photoImage.getImageY();
            if (this.photoImage.getImageHeight() + y < this.parentBoundsTop || y > this.parentBoundsBottom) {
                return;
            }
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class BotButton {
        private int angle;
        private TLRPC$KeyboardButton button;
        private int height;
        private boolean isInviteButton;
        private long lastUpdateTime;
        private LoadingDrawable loadingDrawable;
        private int positionFlags;
        private ValueAnimator pressAnimator;
        private float pressT;
        private boolean pressed;
        private float progressAlpha;
        private Drawable selectorDrawable;
        private StaticLayout title;
        private int width;
        private int x;
        private int y;

        private BotButton() {
        }

        static /* synthetic */ int access$3676(BotButton botButton, int i) {
            int i2 = i | botButton.positionFlags;
            botButton.positionFlags = i2;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPressed(boolean z) {
            ValueAnimator valueAnimator;
            if (this.pressed != z) {
                this.pressed = z;
                ChatMessageCell.this.invalidateOutbounds();
                if (z && (valueAnimator = this.pressAnimator) != null) {
                    valueAnimator.removeAllListeners();
                    this.pressAnimator.cancel();
                }
                if (z) {
                    return;
                }
                float f = this.pressT;
                if (f != 0.0f) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
                    this.pressAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.ChatMessageCell$BotButton$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            this.f$0.lambda$setPressed$0(valueAnimator2);
                        }
                    });
                    this.pressAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.ChatMessageCell.BotButton.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            BotButton.this.pressAnimator = null;
                        }
                    });
                    this.pressAnimator.setInterpolator(new OvershootInterpolator(2.0f));
                    this.pressAnimator.setDuration(350L);
                    this.pressAnimator.start();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setPressed$0(ValueAnimator valueAnimator) {
            this.pressT = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatMessageCell.this.invalidateOutbounds();
        }

        public boolean hasPositionFlag(int i) {
            return (this.positionFlags & i) == i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getPressScale() {
            if (this.pressed) {
                float f = this.pressT;
                if (f != 1.0f) {
                    float fMin = f + (Math.min(40.0f, 1000.0f / AndroidUtilities.screenRefreshRate) / 100.0f);
                    this.pressT = fMin;
                    this.pressT = Utilities.clamp(fMin, 1.0f, 0.0f);
                    ChatMessageCell.this.invalidateOutbounds();
                }
            }
            return ((1.0f - this.pressT) * 0.04f) + 0.96f;
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

        static /* synthetic */ int access$2212(PollButton pollButton, int i) {
            int i2 = pollButton.percent + i;
            pollButton.percent = i2;
            return i2;
        }

        static /* synthetic */ float access$2924(PollButton pollButton, float f) {
            float f2 = pollButton.decimal - f;
            pollButton.decimal = f2;
            return f2;
        }
    }

    class LoadingDrawableLocation {
        int blockNum;
        LoadingDrawable drawable;

        LoadingDrawableLocation(ChatMessageCell chatMessageCell) {
        }
    }

    public ChatMessageCell(Context context) {
        this(context, false, null);
    }

    public ChatMessageCell(Context context, boolean z, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.visibleOnScreen = true;
        this.reactionsLayoutInBubble = new ReactionsLayoutInBubble(this);
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
        this.links = new LinkSpanDrawable.LinkCollector(this);
        this.urlPathCache = new ArrayList<>();
        this.urlPathSelection = new ArrayList<>();
        this.rectPath = new Path();
        this.pollButtons = new ArrayList<>();
        this.botButtons = new ArrayList<>();
        this.botButtonPath = new Path();
        this.botButtonRadii = new float[8];
        this.botButtonsByData = new HashMap<>();
        this.botButtonsByPosition = new HashMap<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.isCheckPressed = true;
        this.drawBackground = true;
        this.backgroundWidth = 100;
        this.commentButtonRect = new Rect();
        this.spoilersPatchedReplyTextLayout = new AtomicReference<>();
        this.forwardedNameLayout = new StaticLayout[2];
        this.forwardNameOffsetX = new float[2];
        this.drawTime = true;
        this.mediaSpoilerPath = new Path();
        this.mediaSpoilerRadii = new float[8];
        this.mediaSpoilerEffect = new SpoilerEffect();
        this.unlockAlpha = 1.0f;
        this.unlockSpoilerEffect = new SpoilerEffect();
        this.unlockSpoilerPath = new Path();
        this.unlockSpoilerRadii = new float[8];
        this.isHiddenForward = true;
        this.replySelectorRect = new Rect();
        this.ALPHA_PROPERTY_WORKAROUND = Build.VERSION.SDK_INT == 28;
        this.alphaInternal = 1.0f;
        this.transitionParams = new TransitionParams();
        this.roundVideoPlayPipFloat = new AnimatedFloat(this, 200L, CubicBezierInterpolator.EASE_OUT);
        this.diceFinishCallback = new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell.1
            @Override // java.lang.Runnable
            public void run() {
                if (ChatMessageCell.this.delegate != null) {
                    ChatMessageCell.this.delegate.onDiceFinished();
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell.2
            @Override // java.lang.Runnable
            public void run() throws SAXException, IOException {
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
        this.backgroundCacheParams = new Theme.MessageDrawable.PathDrawParams();
        this.replySpoilers = new ArrayList();
        this.replySpoilersPool = new Stack<>();
        this.captionSpoilers = new ArrayList();
        this.captionSpoilersPool = new Stack<>();
        this.captionPatchedSpoilersLayout = new AtomicReference<>();
        this.sPath = new Path();
        this.shopProductPriceRect = new RectF();
        this.hadLongPress = false;
        this.ANIMATION_OFFSET_X = new Property<ChatMessageCell, Float>(this, Float.class, "animationOffsetX") { // from class: org.rbmain.ui.Cells.ChatMessageCell.10
            @Override // android.util.Property
            public Float get(ChatMessageCell chatMessageCell) {
                return Float.valueOf(chatMessageCell.animationOffsetX);
            }

            @Override // android.util.Property
            public void set(ChatMessageCell chatMessageCell, Float f) {
                chatMessageCell.setAnimationOffsetX(f.floatValue());
            }
        };
        this.resourcesProvider = resourcesProvider;
        this.canDrawBackgroundInParent = z;
        this.backgroundDrawable = new MessageBackgroundDrawable(this);
        ImageReceiver imageReceiver = new ImageReceiver();
        this.avatarImage = imageReceiver;
        imageReceiver.setAllowLoadingOnAttachedOnly(true);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(21.0f));
        this.avatarDrawable = new AvatarDrawable();
        ImageReceiver imageReceiver2 = new ImageReceiver(this);
        this.replyImageReceiver = imageReceiver2;
        imageReceiver2.setAllowLoadingOnAttachedOnly(true);
        this.replyImageReceiver.setRoundRadius(AndroidUtilities.dp(4.0f));
        ImageReceiver imageReceiver3 = new ImageReceiver(this);
        this.locationImageReceiver = imageReceiver3;
        imageReceiver3.setAllowLoadingOnAttachedOnly(true);
        this.locationImageReceiver.setRoundRadius(AndroidUtilities.dp(26.1f));
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        this.contactAvatarDrawable = new AvatarDrawable();
        ImageReceiver imageReceiver4 = new ImageReceiver(this);
        this.photoImage = imageReceiver4;
        imageReceiver4.setAllowLoadingOnAttachedOnly(true);
        this.photoImage.setUseRoundForThumbDrawable(true);
        this.photoImage.setDelegate(this);
        ImageReceiver imageReceiver5 = new ImageReceiver(this);
        this.blurredPhotoImage = imageReceiver5;
        imageReceiver5.setAllowLoadingOnAttachedOnly(true);
        this.blurredPhotoImage.setUseRoundForThumbDrawable(true);
        this.radialProgress = new RadialProgress2(this);
        RadialProgress2 radialProgress2 = new RadialProgress2(this);
        this.videoRadialProgress = radialProgress2;
        radialProgress2.setDrawBackground(false);
        this.videoRadialProgress.setCircleRadius(AndroidUtilities.dp(15.0f));
        SeekBar seekBar = new SeekBar(this) { // from class: org.rbmain.ui.Cells.ChatMessageCell.3
            @Override // org.rbmain.ui.Components.SeekBar
            protected void onTimestampUpdate(URLSpanNoUnderline uRLSpanNoUnderline) {
                ChatMessageCell.this.highlightCaptionLink(uRLSpanNoUnderline);
            }
        };
        this.seekBar = seekBar;
        seekBar.setDelegate(this);
        SeekBarWaveform seekBarWaveform = new SeekBarWaveform(context);
        this.seekBarWaveform = seekBarWaveform;
        seekBarWaveform.setDelegate(this);
        this.seekBarWaveform.setParentView(this);
        this.seekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: org.rbmain.ui.Cells.ChatMessageCell.4
            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                if (ChatMessageCell.this.currentMessageObject.isMusic()) {
                    return ChatMessageCell.this.seekBar.getProgress();
                }
                if (ChatMessageCell.this.currentMessageObject.isVoice()) {
                    return ChatMessageCell.this.useSeekBarWaveform ? ChatMessageCell.this.seekBarWaveform.getProgress() : ChatMessageCell.this.seekBar.getProgress();
                }
                if (ChatMessageCell.this.currentMessageObject.isRoundVideo()) {
                    return ChatMessageCell.this.currentMessageObject.audioProgress;
                }
                return 0.0f;
            }

            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float f) {
                if (ChatMessageCell.this.currentMessageObject.isMusic()) {
                    ChatMessageCell.this.seekBar.setProgress(f);
                } else if (ChatMessageCell.this.currentMessageObject.isVoice()) {
                    if (ChatMessageCell.this.useSeekBarWaveform) {
                        ChatMessageCell.this.seekBarWaveform.setProgress(f);
                    } else {
                        ChatMessageCell.this.seekBar.setProgress(f);
                    }
                } else {
                    if (!ChatMessageCell.this.currentMessageObject.isRoundVideo()) {
                        return;
                    }
                    if (ChatMessageCell.this.useSeekBarWaveform) {
                        if (ChatMessageCell.this.seekBarWaveform != null) {
                            ChatMessageCell.this.seekBarWaveform.setProgress(f);
                        }
                    } else if (ChatMessageCell.this.seekBar != null) {
                        ChatMessageCell.this.seekBar.setProgress(f);
                    }
                    ChatMessageCell.this.currentMessageObject.audioProgress = f;
                }
                ChatMessageCell.this.onSeekBarDrag(f);
                ChatMessageCell.this.invalidate();
            }
        };
        this.roundVideoPlayingDrawable = new RoundVideoPlayingDrawable(this, resourcesProvider);
        setImportantForAccessibility(1);
        ImageReceiver imageReceiver6 = new ImageReceiver();
        this.rubinoProfileImage = imageReceiver6;
        imageReceiver6.setRoundRadius(AndroidUtilities.dp(18.0f));
        ImageReceiver imageReceiver7 = new ImageReceiver();
        this.shopProfileImage = imageReceiver7;
        imageReceiver7.setRoundRadius(AndroidUtilities.dp(18.0f));
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
            this.pollAvatarDrawables[i].setTextSize(AndroidUtilities.dp(22.0f));
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
            this.commentAvatarDrawables[i].setTextSize(AndroidUtilities.dp(18.0f));
            i++;
        }
    }

    public void resetPressedLink(int i) {
        if (i != -1) {
            this.links.removeLinks(Integer.valueOf(i));
        } else {
            this.links.clear();
        }
        this.pressedEmoji = null;
        if (this.pressedLink != null) {
            if (this.pressedLinkType == i || i == -1) {
                this.pressedLink = null;
                this.pressedLinkType = -1;
                invalidate();
            }
        }
    }

    private void resetUrlPaths() {
        if (this.urlPathSelection.isEmpty()) {
            return;
        }
        this.urlPathCache.addAll(this.urlPathSelection);
        this.urlPathSelection.clear();
    }

    private LinkPath obtainNewUrlPath() {
        LinkPath linkPath;
        if (!this.urlPathCache.isEmpty()) {
            linkPath = this.urlPathCache.get(0);
            this.urlPathCache.remove(0);
        } else {
            linkPath = new LinkPath(true);
        }
        linkPath.reset();
        this.urlPathSelection.add(linkPath);
        return linkPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getRealSpanStartAndEnd(Spannable spannable, CharacterStyle characterStyle) {
        int spanEnd;
        int spanStart;
        boolean z;
        TextStyleSpan.TextStyleRun style;
        TLRPC$MessageEntity tLRPC$MessageEntity;
        if (!(characterStyle instanceof URLSpanBrowser) || (style = ((URLSpanBrowser) characterStyle).getStyle()) == null || (tLRPC$MessageEntity = style.urlEntity) == null) {
            spanEnd = 0;
            spanStart = 0;
            z = false;
        } else {
            spanStart = tLRPC$MessageEntity.offset;
            spanEnd = tLRPC$MessageEntity.length + spanStart;
            z = true;
        }
        if (!z) {
            spanStart = spannable.getSpanStart(characterStyle);
            spanEnd = spannable.getSpanEnd(characterStyle);
        }
        return new int[]{spanStart, spanEnd};
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkTransferMessageMotionEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkTransferMessageMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x02b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkTextBlockMotionEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkTextBlockMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkCaptionMotionEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkCaptionMotionEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkGameMotionEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.hasGamePreview) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
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
                    int i3 = y - this.descriptionY;
                    int lineForVertical = this.descriptionLayout.getLineForVertical(i3);
                    float f = iDp;
                    int offsetForHorizontal = this.descriptionLayout.getOffsetForHorizontal(lineForVertical, f);
                    float lineLeft = this.descriptionLayout.getLineLeft(lineForVertical);
                    if (lineLeft <= f && lineLeft + this.descriptionLayout.getLineWidth(lineForVertical) >= f) {
                        Spannable spannable = (Spannable) this.currentMessageObject.linkDescription;
                        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                        if (!(clickableSpanArr.length == 0 || ((clickableSpanArr[0] instanceof URLSpanBotCommand) && !URLSpanBotCommand.enabled)) && !AndroidUtilities.isAccessibilityScreenReaderEnabled()) {
                            LinkSpanDrawable linkSpanDrawable = this.pressedLink;
                            if (linkSpanDrawable == null || linkSpanDrawable.getSpan() != clickableSpanArr[0]) {
                                this.links.removeLink(this.pressedLink);
                                LinkSpanDrawable linkSpanDrawable2 = new LinkSpanDrawable(clickableSpanArr[0], this.resourcesProvider, f, i3, spanSupportsLongPress(clickableSpanArr[0]));
                                this.pressedLink = linkSpanDrawable2;
                                linkSpanDrawable2.setColor(getThemedColor(this.currentMessageObject.isOutOwner() ? Theme.key_chat_outLinkSelectBackground : Theme.key_chat_linkSelectBackground));
                                this.linkBlockNum = -10;
                                this.pressedLinkType = 2;
                                try {
                                    LinkPath linkPathObtainNewPath = this.pressedLink.obtainNewPath();
                                    int[] realSpanStartAndEnd = getRealSpanStartAndEnd(spannable, this.pressedLink.getSpan());
                                    linkPathObtainNewPath.setCurrentLayout(this.descriptionLayout, realSpanStartAndEnd[0], 0.0f);
                                    this.descriptionLayout.getSelectionPath(realSpanStartAndEnd[0], realSpanStartAndEnd[1], linkPathObtainNewPath);
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                                this.links.addLink(this.pressedLink, 2);
                            }
                            invalidate();
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        } else if (motionEvent.getAction() == 1) {
            if (this.pressedLinkType == 2 || this.gamePreviewPressed || this.buttonPressed != 0) {
                if (this.buttonPressed != 0) {
                    this.buttonPressed = 0;
                    playSoundEffect(0);
                    didPressButton(true, false);
                    invalidate();
                } else {
                    LinkSpanDrawable linkSpanDrawable3 = this.pressedLink;
                    if (linkSpanDrawable3 != null) {
                        if (linkSpanDrawable3.getSpan() instanceof URLSpan) {
                            Browser.openUrl(getContext(), ((URLSpan) this.pressedLink.getSpan()).getURL());
                        } else if (this.pressedLink.getSpan() instanceof ClickableSpan) {
                            ((ClickableSpan) this.pressedLink.getSpan()).onClick(this);
                        }
                        resetPressedLink(2);
                    } else {
                        this.gamePreviewPressed = false;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= this.botButtons.size()) {
                                break;
                            }
                            BotButton botButton = this.botButtons.get(i4);
                            if (botButton.button instanceof TLRPC$TL_keyboardButtonGame) {
                                playSoundEffect(0);
                                this.delegate.didPressBotButton(this, botButton.button);
                                invalidate();
                                break;
                            }
                            i4++;
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

    private boolean checkTranscribeButtonMotionEvent(MotionEvent motionEvent) {
        TranscribeButton transcribeButton;
        return this.useTranscribeButton && (!this.isPlayingRound || getVideoTranscriptionProgress() > 0.0f || this.wasTranscriptionOpen) && (transcribeButton = this.transcribeButton) != null && transcribeButton.onTouch(motionEvent.getAction(), motionEvent.getX(), motionEvent.getY());
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkLinkPreviewMotionEvent(android.view.MotionEvent r19) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkLinkPreviewMotionEvent(android.view.MotionEvent):boolean");
    }

    private boolean checkPollButtonMotionEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (this.currentMessageObject.eventId != 0 || this.pollVoteInProgress || this.pollUnvoteInProgress || this.pollButtons.isEmpty()) {
            return false;
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject.type != 17 || !messageObject.isSent()) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
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
        if (motionEvent.getAction() == 1) {
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
                Toast.makeText(getContext(), LocaleController.getString("MessageScheduledVote", ir.medu.shad.R.string.MessageScheduledVote), 1).show();
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
        if (motionEvent.getAction() != 2) {
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

    private boolean checkInstantButtonMotionEvent(MotionEvent motionEvent) {
        if (!this.currentMessageObject.isSponsored() && (!this.drawInstantView || this.currentMessageObject.type == 0)) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (this.drawInstantView) {
                float f = x;
                float f2 = y;
                if (this.instantButtonRect.contains(f, f2)) {
                    this.selectorDrawableMaskType[0] = this.lastPoll == null ? 0 : 2;
                    this.instantPressed = true;
                    if (Build.VERSION.SDK_INT >= 21 && this.selectorDrawable[0] != null && this.instantButtonRect.contains(f, f2)) {
                        this.selectorDrawable[0].setHotspot(f, f2);
                        this.selectorDrawable[0].setState(this.pressedState);
                        setInstantButtonPressed(true);
                    }
                    invalidate();
                    return true;
                }
            }
        } else if (motionEvent.getAction() == 1) {
            if (this.instantPressed) {
                ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
                if (chatMessageCellDelegate != null) {
                    if (this.lastPoll != null) {
                        MessageObject messageObject = this.currentMessageObject;
                        if (messageObject.scheduled) {
                            Toast.makeText(getContext(), LocaleController.getString("MessageScheduledVoteResults", ir.medu.shad.R.string.MessageScheduledVoteResults), 1).show();
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
                this.instantPressed = false;
                setInstantButtonPressed(false);
                invalidate();
            }
        } else if (motionEvent.getAction() == 2 && this.instantButtonPressed && Build.VERSION.SDK_INT >= 21) {
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

    private boolean checkCommentButtonMotionEvent(MotionEvent motionEvent) {
        int i = 0;
        if (!this.drawCommentButton) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
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
                        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, motionEvent.getActionMasked(), (motionEvent.getX() + getLeft()) - chatMessageCell.getLeft(), (motionEvent.getY() + getTop()) - chatMessageCell.getTop(), 0);
                        chatMessageCell.checkCommentButtonMotionEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        break;
                    }
                }
                i++;
            }
            return true;
        }
        if (motionEvent.getAction() == 0) {
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
        } else if (motionEvent.getAction() == 1) {
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
        } else if (motionEvent.getAction() == 2 && this.commentButtonPressed && Build.VERSION.SDK_INT >= 21) {
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
                    if (x <= i3 + AndroidUtilities.dp((LocaleController.isRTL ? 0 : 200) + 30 + (!zIsVideoCall ? 2 : 0)) && y >= this.otherY - AndroidUtilities.dp(14.0f) && y <= this.otherY + AndroidUtilities.dp(50.0f)) {
                        this.otherPressed = true;
                        this.selectorDrawableMaskType[0] = 4;
                        if (Build.VERSION.SDK_INT >= 21 && this.selectorDrawable[0] != null) {
                            int iDp = this.otherX + AndroidUtilities.dp((LocaleController.isRTL ? 0 : 200) + (!zIsVideoCall ? 2 : 0)) + (Theme.chat_msgInCallDrawable[zIsVideoCall ? 1 : 0].getIntrinsicWidth() / 2);
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

    private void setInstantButtonPressed(boolean z) {
        ValueAnimator valueAnimator;
        if (this.instantButtonPressed != z) {
            invalidate();
            if (z && (valueAnimator = this.instantButtonPressAnimator) != null) {
                valueAnimator.removeAllListeners();
                this.instantButtonPressAnimator.cancel();
            }
            if (!z) {
                float f = this.instantButtonPressProgress;
                if (f != 0.0f) {
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
                    this.instantButtonPressAnimator = valueAnimatorOfFloat;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda0
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            this.f$0.lambda$setInstantButtonPressed$2(valueAnimator2);
                        }
                    });
                    this.instantButtonPressAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.ChatMessageCell.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            ChatMessageCell.this.instantButtonPressAnimator = null;
                        }
                    });
                    this.instantButtonPressAnimator.setInterpolator(new OvershootInterpolator(5.0f));
                    this.instantButtonPressAnimator.setDuration(350L);
                    this.instantButtonPressAnimator.start();
                }
            }
            this.instantButtonPressed = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setInstantButtonPressed$2(ValueAnimator valueAnimator) {
        this.instantButtonPressProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private boolean checkDateMotionEvent(MotionEvent motionEvent) {
        if (!this.currentMessageObject.isImportedForward()) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
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
            if (motionEvent.getAction() != 1 || !this.timePressed) {
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
    private boolean checkRoundSeekbar(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkRoundSeekbar(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkPhotoImageMotionEvent(android.view.MotionEvent r9) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkPhotoImageMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkAudioMotionEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.checkAudioMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean checkSpoilersMotionEvent(MotionEvent motionEvent, int i) {
        int i2;
        MessageObject.GroupedMessages groupedMessages;
        if (i <= 15 && getParent() != null) {
            if (this.currentMessageObject.hasValidGroupId() && (groupedMessages = this.currentMessagesGroup) != null && !groupedMessages.isDocuments) {
                ViewGroup viewGroup = (ViewGroup) getParent();
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt instanceof ChatMessageCell) {
                        ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                        MessageObject.GroupedMessages currentMessagesGroup = chatMessageCell.getCurrentMessagesGroup();
                        MessageObject.GroupedMessagePosition currentPosition = chatMessageCell.getCurrentPosition();
                        if (currentMessagesGroup != null && currentMessagesGroup.groupId == this.currentMessagesGroup.groupId) {
                            int i4 = currentPosition.flags;
                            if ((i4 & 8) != 0 && (i4 & 1) != 0 && chatMessageCell != this) {
                                motionEvent.offsetLocation(getLeft() - chatMessageCell.getLeft(), getTop() - chatMessageCell.getTop());
                                boolean zCheckSpoilersMotionEvent = chatMessageCell.checkSpoilersMotionEvent(motionEvent, i + 1);
                                motionEvent.offsetLocation(-(getLeft() - chatMessageCell.getLeft()), -(getTop() - chatMessageCell.getTop()));
                                return zCheckSpoilersMotionEvent;
                            }
                        }
                    }
                }
            }
            if (this.isSpoilerRevealing) {
                return false;
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                int i5 = this.textX;
                if (x >= i5 && y >= (i2 = this.textY)) {
                    MessageObject messageObject = this.currentMessageObject;
                    if (x <= i5 + messageObject.textWidth && y <= i2 + messageObject.textHeight) {
                        ArrayList<MessageObject.TextLayoutBlock> arrayList = messageObject.textLayoutBlocks;
                        for (int i6 = 0; i6 < arrayList.size() && arrayList.get(i6).textYOffset <= y; i6++) {
                            MessageObject.TextLayoutBlock textLayoutBlock = arrayList.get(i6);
                            int i7 = textLayoutBlock.isRtl() ? (int) this.currentMessageObject.textXOffset : 0;
                            for (SpoilerEffect spoilerEffect : textLayoutBlock.spoilers) {
                                if (spoilerEffect.getBounds().contains((x - this.textX) + i7, (int) ((y - this.textY) - textLayoutBlock.textYOffset))) {
                                    this.spoilerPressed = spoilerEffect;
                                    this.isCaptionSpoilerPressed = false;
                                    return true;
                                }
                            }
                        }
                    }
                }
                if (hasCaptionLayout()) {
                    float f = x;
                    float f2 = this.captionX;
                    if (f >= f2) {
                        float f3 = y;
                        if (f3 >= this.captionY && f <= f2 + this.captionLayout.getWidth() && f3 <= this.captionY + this.captionLayout.getHeight()) {
                            for (SpoilerEffect spoilerEffect2 : this.captionSpoilers) {
                                if (spoilerEffect2.getBounds().contains((int) (f - this.captionX), (int) (f3 - this.captionY))) {
                                    this.spoilerPressed = spoilerEffect2;
                                    this.isCaptionSpoilerPressed = true;
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else if (actionMasked == 1 && this.spoilerPressed != null) {
                playSoundEffect(0);
                this.sPath.rewind();
                if (this.isCaptionSpoilerPressed) {
                    Iterator<SpoilerEffect> it = this.captionSpoilers.iterator();
                    while (it.hasNext()) {
                        Rect bounds = it.next().getBounds();
                        this.sPath.addRect(bounds.left, bounds.top, bounds.right, bounds.bottom, Path.Direction.CW);
                    }
                } else {
                    Iterator<MessageObject.TextLayoutBlock> it2 = this.currentMessageObject.textLayoutBlocks.iterator();
                    while (it2.hasNext()) {
                        MessageObject.TextLayoutBlock next = it2.next();
                        Iterator<SpoilerEffect> it3 = next.spoilers.iterator();
                        while (it3.hasNext()) {
                            Rect bounds2 = it3.next().getBounds();
                            Path path = this.sPath;
                            float f4 = bounds2.left;
                            float f5 = bounds2.top;
                            float f6 = next.textYOffset;
                            path.addRect(f4, f5 + f6, bounds2.right, bounds2.bottom + f6, Path.Direction.CW);
                        }
                    }
                }
                this.sPath.computeBounds(this.rect, false);
                float fSqrt = (float) Math.sqrt(Math.pow(this.rect.width(), 2.0d) + Math.pow(this.rect.height(), 2.0d));
                this.isSpoilerRevealing = true;
                this.spoilerPressed.setOnRippleEndCallback(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkSpoilersMotionEvent$4();
                    }
                });
                if (this.isCaptionSpoilerPressed) {
                    Iterator<SpoilerEffect> it4 = this.captionSpoilers.iterator();
                    while (it4.hasNext()) {
                        it4.next().startRipple(x - this.captionX, y - this.captionY, fSqrt);
                    }
                } else {
                    ArrayList<MessageObject.TextLayoutBlock> arrayList2 = this.currentMessageObject.textLayoutBlocks;
                    if (arrayList2 != null) {
                        Iterator<MessageObject.TextLayoutBlock> it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            MessageObject.TextLayoutBlock next2 = it5.next();
                            int i8 = next2.isRtl() ? (int) this.currentMessageObject.textXOffset : 0;
                            Iterator<SpoilerEffect> it6 = next2.spoilers.iterator();
                            while (it6.hasNext()) {
                                it6.next().startRipple((x - this.textX) + i8, (y - next2.textYOffset) - this.textY, fSqrt);
                            }
                        }
                    }
                }
                if (getParent() instanceof RecyclerListView) {
                    ViewGroup viewGroup2 = (ViewGroup) getParent();
                    for (int i9 = 0; i9 < viewGroup2.getChildCount(); i9++) {
                        View childAt2 = viewGroup2.getChildAt(i9);
                        if (childAt2 instanceof ChatMessageCell) {
                            final ChatMessageCell chatMessageCell2 = (ChatMessageCell) childAt2;
                            if (chatMessageCell2.getMessageObject() != null && chatMessageCell2.getMessageObject().getReplyMsgId() == getMessageObject().getId() && !chatMessageCell2.replySpoilers.isEmpty()) {
                                chatMessageCell2.replySpoilers.get(0).setOnRippleEndCallback(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda12
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.lambda$checkSpoilersMotionEvent$6(chatMessageCell2);
                                    }
                                });
                                Iterator<SpoilerEffect> it7 = chatMessageCell2.replySpoilers.iterator();
                                while (it7.hasNext()) {
                                    it7.next().startRipple(r4.getBounds().centerX(), r4.getBounds().centerY(), fSqrt);
                                }
                            }
                        }
                    }
                }
                this.spoilerPressed = null;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSpoilersMotionEvent$4() {
        post(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkSpoilersMotionEvent$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSpoilersMotionEvent$3() {
        this.isSpoilerRevealing = false;
        getMessageObject().isSpoilersRevealed = true;
        if (this.isCaptionSpoilerPressed) {
            this.captionSpoilers.clear();
        } else {
            ArrayList<MessageObject.TextLayoutBlock> arrayList = this.currentMessageObject.textLayoutBlocks;
            if (arrayList != null) {
                Iterator<MessageObject.TextLayoutBlock> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().spoilers.clear();
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkSpoilersMotionEvent$6(final ChatMessageCell chatMessageCell) {
        post(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                ChatMessageCell.lambda$checkSpoilersMotionEvent$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkSpoilersMotionEvent$5(ChatMessageCell chatMessageCell) {
        chatMessageCell.getMessageObject().replyMessageObject.isSpoilersRevealed = true;
        chatMessageCell.replySpoilers.clear();
        chatMessageCell.invalidate();
    }

    private boolean checkBotButtonMotionEvent(MotionEvent motionEvent) {
        int i;
        int iDp;
        if (this.botButtons.isEmpty() || this.currentMessageObject.eventId != 0) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            if (this.currentMessageObject.isOutOwner()) {
                iDp = (getMeasuredWidth() - this.widthForButtons) - AndroidUtilities.dp(10.0f);
            } else {
                iDp = this.backgroundDrawableLeft + AndroidUtilities.dp(this.mediaBackground ? 1.0f : 7.0f);
            }
            for (int i2 = 0; i2 < this.botButtons.size(); i2++) {
                BotButton botButton = this.botButtons.get(i2);
                int iDp2 = (botButton.y + this.layoutHeight) - AndroidUtilities.dp(2.0f);
                if (x >= botButton.x + iDp && x <= botButton.x + iDp + botButton.width && y >= iDp2 && y <= botButton.height + iDp2) {
                    this.pressedBotButton = i2;
                    invalidateOutbounds();
                    if (botButton.selectorDrawable == null) {
                        botButton.selectorDrawable = Theme.createRadSelectorDrawable(getThemedColor(Theme.key_chat_serviceBackgroundSelector), 6, 6);
                        botButton.selectorDrawable.setBounds(botButton.x + iDp, iDp2, botButton.x + iDp + botButton.width, botButton.height + iDp2);
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        botButton.selectorDrawable.setHotspot(x, y);
                    }
                    botButton.selectorDrawable.setState(this.pressedState);
                    botButton.setPressed(true);
                    final int i3 = this.pressedBotButton;
                    postDelayed(new Runnable() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$checkBotButtonMotionEvent$7(i3);
                        }
                    }, ViewConfiguration.getLongPressTimeout() - 1);
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getAction() == 1) {
            if (this.pressedBotButton == -1) {
                return false;
            }
            playSoundEffect(0);
            BotButton botButton2 = this.botButtons.get(this.pressedBotButton);
            if (botButton2.selectorDrawable != null) {
                botButton2.selectorDrawable.setState(StateSet.NOTHING);
            }
            botButton2.setPressed(false);
            if (!this.currentMessageObject.scheduled) {
                if (botButton2.button != null) {
                    this.delegate.didPressBotButton(this, botButton2.button);
                }
            } else {
                Toast.makeText(getContext(), LocaleController.getString("MessageScheduledBotAction", ir.medu.shad.R.string.MessageScheduledBotAction), 1).show();
            }
            this.pressedBotButton = -1;
            invalidateOutbounds();
            return false;
        }
        if (motionEvent.getAction() != 3 || (i = this.pressedBotButton) == -1) {
            return false;
        }
        BotButton botButton3 = this.botButtons.get(i);
        if (botButton3.selectorDrawable != null) {
            botButton3.selectorDrawable.setState(StateSet.NOTHING);
        }
        botButton3.setPressed(false);
        this.pressedBotButton = -1;
        invalidateOutbounds();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkBotButtonMotionEvent$7(int i) {
        int i2 = this.pressedBotButton;
        if (i == i2) {
            BotButton botButton = this.botButtons.get(i2);
            if (botButton != null) {
                if (botButton.selectorDrawable != null) {
                    botButton.selectorDrawable.setState(StateSet.NOTHING);
                }
                botButton.setPressed(false);
                if (!this.currentMessageObject.scheduled && botButton.button != null) {
                    cancelCheckLongPress();
                    this.delegate.didLongPressBotButton(this, botButton.button);
                }
            }
            this.pressedBotButton = -1;
            invalidateOutbounds();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0620  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r19) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$8() {
        if (this.replyPressed && !this.replySelectorPressed && this.replySelectorCanBePressed) {
            this.replySelectorPressed = true;
            this.replySelector.setState(new int[]{R.attr.state_pressed, R.attr.state_enabled});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$9() {
        this.replySelector.setState(new int[0]);
        invalidate();
    }

    private boolean checkRubinoMotionEvent(MotionEvent motionEvent) throws SAXException, IOException {
        int i = this.currentMessageObject.type;
        if (i != 124 && i != 125) {
            return false;
        }
        int x = (int) motionEvent.getX();
        motionEvent.getY();
        boolean z = true;
        if (motionEvent.getAction() == 0) {
            float f = x;
            if (f < this.photoImage.getImageX() || f > this.photoImage.getImageX() + this.backgroundWidth) {
                z = false;
            } else {
                this.imagePressed = true;
            }
            if (!this.imagePressed || !this.currentMessageObject.isSendError()) {
                return z;
            }
            this.imagePressed = false;
            return false;
        }
        if (motionEvent.getAction() != 1 || !this.imagePressed) {
            return false;
        }
        this.imagePressed = false;
        int i2 = this.buttonState;
        if (i2 == -1 || i2 == 2 || i2 == 3) {
            playSoundEffect(0);
            didClickedImage();
        }
        invalidate();
        return false;
    }

    private boolean checkReactionsTouchEvent(MotionEvent motionEvent) {
        MessageObject.GroupedMessages groupedMessages;
        if (this.currentMessageObject.hasValidGroupId() && (groupedMessages = this.currentMessagesGroup) != null && !groupedMessages.isDocuments) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup == null) {
                return false;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ChatMessageCell) {
                    ChatMessageCell chatMessageCell = (ChatMessageCell) childAt;
                    MessageObject.GroupedMessages currentMessagesGroup = chatMessageCell.getCurrentMessagesGroup();
                    MessageObject.GroupedMessagePosition currentPosition = chatMessageCell.getCurrentPosition();
                    if (currentMessagesGroup != null && currentMessagesGroup.groupId == this.currentMessagesGroup.groupId) {
                        int i2 = currentPosition.flags;
                        if ((i2 & 8) != 0 && (i2 & 1) != 0) {
                            if (chatMessageCell == this) {
                                return this.reactionsLayoutInBubble.chekTouchEvent(motionEvent);
                            }
                            motionEvent.offsetLocation(getLeft() - chatMessageCell.getLeft(), getTop() - chatMessageCell.getTop());
                            boolean zChekTouchEvent = chatMessageCell.reactionsLayoutInBubble.chekTouchEvent(motionEvent);
                            motionEvent.offsetLocation(-(getLeft() - chatMessageCell.getLeft()), -(getTop() - chatMessageCell.getTop()));
                            return zChekTouchEvent;
                        }
                    }
                }
            }
            return false;
        }
        return this.reactionsLayoutInBubble.chekTouchEvent(motionEvent);
    }

    private boolean checkPinchToZoom(MotionEvent motionEvent) {
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        PinchToZoomHelper pinchToZoomHelper = chatMessageCellDelegate == null ? null : chatMessageCellDelegate.getPinchToZoomHelper();
        if (this.currentMessageObject == null || !this.photoImage.hasNotThumb() || pinchToZoomHelper == null || this.currentMessageObject.isSticker() || this.currentMessageObject.isAnimatedEmoji()) {
            return false;
        }
        if ((this.currentMessageObject.isVideo() && !this.autoPlayingMedia) || this.isRoundVideo || this.currentMessageObject.isAnimatedSticker()) {
            return false;
        }
        if ((!this.currentMessageObject.isDocument() || this.currentMessageObject.isGif()) && !this.currentMessageObject.needDrawBluredPreview()) {
            return pinchToZoomHelper.checkPinchToZoom(motionEvent, this, this.photoImage, this.currentMessageObject);
        }
        return false;
    }

    private boolean checkTextSelection(MotionEvent motionEvent) {
        MessageObject messageObject;
        TLRPC$Message tLRPC$Message;
        int i;
        int iDp;
        int iDp2;
        MessageObject.GroupedMessages groupedMessages;
        TextSelectionHelper.ChatListTextSelectionHelper textSelectionHelper = this.delegate.getTextSelectionHelper();
        if (textSelectionHelper == null || MessagesController.getInstance(this.currentAccount).isChatNoForwards(this.currentMessageObject.getChatId()) || ((tLRPC$Message = (messageObject = this.currentMessageObject).messageOwner) != null && tLRPC$Message.noforwards)) {
            return false;
        }
        ArrayList<MessageObject.TextLayoutBlock> arrayList = messageObject.textLayoutBlocks;
        if (!((arrayList == null || arrayList.isEmpty()) ? false : true) && !hasCaptionLayout()) {
            return false;
        }
        if ((!this.drawSelectionBackground && this.currentMessagesGroup == null) || (this.currentMessagesGroup != null && !this.delegate.hasSelectedMessages())) {
            return false;
        }
        if (this.currentMessageObject.hasValidGroupId() && (groupedMessages = this.currentMessagesGroup) != null && !groupedMessages.isDocuments) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup == null) {
                return false;
            }
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
                                return textSelectionHelper.onTouchEvent(motionEvent);
                            }
                            motionEvent.offsetLocation(getLeft() - chatMessageCell.getLeft(), getTop() - chatMessageCell.getTop());
                            boolean zOnTouchEvent = textSelectionHelper.onTouchEvent(motionEvent);
                            motionEvent.offsetLocation(-(getLeft() - chatMessageCell.getLeft()), -(getTop() - chatMessageCell.getTop()));
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
        } else if (this.descriptionLayout != null && motionEvent.getY() > this.descriptionY) {
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
        return textSelectionHelper.onTouchEvent(motionEvent);
    }

    private void updateSelectionTextPosition() {
        int i;
        int iDp;
        int iDp2;
        if (getDelegate() == null || getDelegate().getTextSelectionHelper() == null || !getDelegate().getTextSelectionHelper().isSelected(this.currentMessageObject)) {
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
        if (this.currentMessageObject == null) {
            return;
        }
        if (this.documentAttachType == 4) {
            SeekBar seekBar = this.seekBar;
            if (seekBar != null) {
                seekBar.clearTimestamps();
            }
            if (this.infoLayout == null || !(PhotoViewer.isPlayingMessage(this.currentMessageObject) || MediaController.getInstance().isGoingToShowMessageObject(this.currentMessageObject))) {
                AnimatedFileDrawable animation = this.photoImage.getAnimation();
                if (animation != null) {
                    MessageObject messageObject = this.currentMessageObject;
                    currentProgressMs = animation.getDurationMs() / CloseCodes.NORMAL_CLOSURE;
                    messageObject.audioPlayerDuration = currentProgressMs;
                    MessageObject messageObject2 = this.currentMessageObject;
                    TLRPC$Message tLRPC$Message = messageObject2.messageOwner;
                    if (tLRPC$Message.ttl > 0 && tLRPC$Message.destroyTime == 0 && !messageObject2.needDrawBluredPreview() && this.currentMessageObject.isVideo() && animation.hasBitmap()) {
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
                        currentProgressMs -= animation.getCurrentProgressMs() / CloseCodes.NORMAL_CLOSURE;
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
            if (this.useSeekBarWaveform) {
                if (!this.seekBarWaveform.isDragging()) {
                    this.seekBarWaveform.setProgress(this.currentMessageObject.audioProgress, true);
                }
            } else {
                if (!this.seekBar.isDragging()) {
                    this.seekBar.setProgress(this.currentMessageObject.audioProgress);
                    this.seekBar.setBufferedProgress(this.currentMessageObject.bufferedProgress);
                }
                this.seekBar.clearTimestamps();
            }
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
            if (this.useSeekBarWaveform) {
                if (!this.seekBarWaveform.isDragging()) {
                    this.seekBarWaveform.setProgress(this.currentMessageObject.audioProgress, true);
                }
            } else {
                if (!this.seekBar.isDragging()) {
                    this.seekBar.setProgress(this.currentMessageObject.audioProgress);
                    this.seekBar.setBufferedProgress(this.currentMessageObject.bufferedProgress);
                }
                this.seekBar.updateTimestamps(this.currentMessageObject, null);
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

    public void setFullyDraw(boolean z) {
        this.fullyDraw = z;
    }

    public void setParentViewSize(int i, int i2) {
        Theme.MessageDrawable messageDrawable;
        this.parentWidth = i;
        this.parentHeight = i2;
        this.backgroundHeight = i2;
        if (!(this.currentMessageObject != null && hasGradientService() && this.currentMessageObject.shouldDrawWithoutBackground()) && ((messageDrawable = this.currentBackgroundDrawable) == null || messageDrawable.getGradientShader() == null)) {
            return;
        }
        invalidate();
    }

    public void setVisiblePart(int i, int i2, int i3, float f, float f2, int i4, int i5, int i6, int i7) {
        this.parentWidth = i4;
        this.parentHeight = i5;
        this.backgroundHeight = i5;
        this.blurredViewTopOffset = i6;
        this.blurredViewBottomOffset = i7;
        if (!this.botButtons.isEmpty() && this.viewTop != f2) {
            invalidate();
        }
        this.viewTop = f2;
        if (i3 != this.parentHeight || f != this.parentViewTopOffset) {
            this.parentViewTopOffset = f;
            this.parentHeight = i3;
        }
        if (this.currentMessageObject != null && hasGradientService() && this.currentMessageObject.shouldDrawWithoutBackground()) {
            invalidate();
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.textLayoutBlocks == null) {
            return;
        }
        int i8 = i - this.textY;
        int i9 = 0;
        for (int i10 = 0; i10 < this.currentMessageObject.textLayoutBlocks.size() && this.currentMessageObject.textLayoutBlocks.get(i10).textYOffset <= i8; i10++) {
            i9 = i10;
        }
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        while (i9 < this.currentMessageObject.textLayoutBlocks.size()) {
            float f3 = this.currentMessageObject.textLayoutBlocks.get(i9).textYOffset;
            float f4 = i8;
            if (!intersect(f3, r13.height + f3, f4, i8 + i2)) {
                if (f3 > f4) {
                    break;
                }
            } else {
                if (i11 == -1) {
                    i11 = i9;
                }
                i13++;
                i12 = i9;
            }
            i9++;
        }
        if (this.lastVisibleBlockNum != i12 || this.firstVisibleBlockNum != i11 || this.totalVisibleBlocksCount != i13) {
            this.lastVisibleBlockNum = i12;
            this.firstVisibleBlockNum = i11;
            this.totalVisibleBlocksCount = i13;
            invalidate();
            return;
        }
        if (this.animatedEmojiStack != null) {
            for (int i14 = 0; i14 < this.animatedEmojiStack.holders.size(); i14++) {
                AnimatedEmojiSpan.AnimatedEmojiHolder animatedEmojiHolder = this.animatedEmojiStack.holders.get(i14);
                if (animatedEmojiHolder != null && animatedEmojiHolder.skipDraw && !animatedEmojiHolder.outOfBounds((this.parentBoundsTop - getY()) - animatedEmojiHolder.drawingYOffset, (this.parentBoundsBottom - getY()) - animatedEmojiHolder.drawingYOffset)) {
                    invalidate();
                    return;
                }
            }
        }
    }

    public static StaticLayout generateStaticLayout(CharSequence charSequence, TextPaint textPaint, int i, int i2, int i3, int i4) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        int i5 = i;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            staticLayout.getLineDirections(i7);
            if (staticLayout.getLineLeft(i7) != 0.0f || staticLayout.isRtlCharAt(staticLayout.getLineStart(i7)) || staticLayout.isRtlCharAt(staticLayout.getLineEnd(i7))) {
                i5 = i2;
            }
            int lineEnd = staticLayout.getLineEnd(i7);
            if (lineEnd == charSequence.length()) {
                break;
            }
            int i8 = (lineEnd - 1) + i6;
            if (spannableStringBuilder.charAt(i8) == ' ') {
                spannableStringBuilder.replace(i8, i8 + 1, (CharSequence) "\n");
            } else if (spannableStringBuilder.charAt(i8) != '\n') {
                spannableStringBuilder.insert(i8, (CharSequence) "\n");
                i6++;
            }
            if (i7 == staticLayout.getLineCount() - 1 || i7 == i4 - 1) {
                break;
            }
        }
        int i9 = i5;
        return StaticLayoutEx.createStaticLayout(spannableStringBuilder, textPaint, i9, Layout.Alignment.ALIGN_NORMAL, 1.0f, AndroidUtilities.dp(1.0f), false, TextUtils.TruncateAt.END, i9, i4, true);
    }

    private void didClickedImage() throws SAXException, IOException {
        ChatMessageCellDelegate chatMessageCellDelegate;
        TLRPC$WebPage tLRPC$WebPage;
        boolean z;
        if (this.currentMessageObject.hasMediaSpoilers() && !this.currentMessageObject.isMediaSpoilersRevealed) {
            startRevealMedia(this.lastTouchX, this.lastTouchY);
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        int i = messageObject.type;
        if (i == 20) {
            return;
        }
        if (i == 1 || messageObject.isAnyKindOfSticker()) {
            int i2 = this.buttonState;
            if (i2 == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            } else {
                if (i2 == 0) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        MessageObject messageObject2 = this.currentMessageObject;
        int i3 = messageObject2.type;
        if (i3 == 12) {
            long j = MessageObject.getMedia(messageObject2.messageOwner).user_id;
            this.delegate.didPressUserAvatar(this, j != 0 ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(j)) : null, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i3 == 5) {
            if (this.buttonState != -1) {
                didPressButton(true, false);
                return;
            } else if (!MediaController.getInstance().isPlayingMessage(this.currentMessageObject) || MediaController.getInstance().isMessagePaused()) {
                this.delegate.needPlayMessage(this.currentMessageObject, false);
                return;
            } else {
                MediaController.getInstance().lambda$startAudioAgain$7(this.currentMessageObject);
                return;
            }
        }
        if (i3 == 8) {
            int i4 = this.buttonState;
            if (i4 == -1 || (i4 == 1 && this.canStreamVideo && this.autoPlayingMedia)) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            } else {
                if (i4 == 2 || i4 == 0) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        int i5 = this.documentAttachType;
        if (i5 == 4) {
            int i6 = this.buttonState;
            if (i6 == -1 || ((z = this.drawVideoImageButton) && (this.autoPlayingMedia || (SharedConfig.streamMedia && this.canStreamVideo)))) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            }
            if (z) {
                didPressButton(true, true);
                return;
            } else {
                if (i6 == 0 || i6 == 3) {
                    didPressButton(true, false);
                    return;
                }
                return;
            }
        }
        if (i3 == 4) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i5 == 1) {
            if (this.buttonState == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            }
            return;
        }
        if (i5 == 2) {
            if (this.buttonState != -1 || (tLRPC$WebPage = MessageObject.getMedia(messageObject2.messageOwner).webpage) == null) {
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
                return;
            }
            return;
        }
        if (i3 == 123) {
            if (this.buttonState == -1) {
                this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
                return;
            }
            return;
        }
        if (i3 == 124) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i3 == 125) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (i3 == 104) {
            this.delegate.didPressImage(this, this.lastTouchX, this.lastTouchY);
            return;
        }
        if (Build.VERSION.SDK_INT < 26 || (chatMessageCellDelegate = this.delegate) == null) {
            return;
        }
        if (i3 == 16) {
            chatMessageCellDelegate.didLongPress(this, 0.0f, 0.0f);
        } else {
            chatMessageCellDelegate.didPressOther(this, this.otherX, this.otherY);
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
    private boolean isPhotoDataChanged(org.rbmain.messenger.MessageObject r25) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.isPhotoDataChanged(org.rbmain.messenger.MessageObject):boolean");
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

    public void updateAnimatedEmojis() {
        if (this.imageReceiversAttachState) {
            int cacheTypeForEnterView = this.currentMessageObject.wasJustSent ? AnimatedEmojiDrawable.getCacheTypeForEnterView() : 0;
            StaticLayout staticLayout = this.captionLayout;
            if (staticLayout != null) {
                this.animatedEmojiStack = AnimatedEmojiSpan.update(cacheTypeForEnterView, (View) this, false, this.animatedEmojiStack, staticLayout);
            } else {
                ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
                this.animatedEmojiStack = AnimatedEmojiSpan.update(cacheTypeForEnterView, this, chatMessageCellDelegate == null || !chatMessageCellDelegate.canDrawOutboundsContent(), this.animatedEmojiStack, this.currentMessageObject.textLayoutBlocks);
            }
        }
    }

    private void updateCaptionSpoilers() {
        this.captionSpoilersPool.addAll(this.captionSpoilers);
        this.captionSpoilers.clear();
        if (this.captionLayout == null || getMessageObject().isSpoilersRevealed) {
            return;
        }
        SpoilerEffect.addSpoilers(this, this.captionLayout, -1, this.captionOffsetX + this.captionWidth, this.captionSpoilersPool, this.captionSpoilers);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isUserDataChanged() {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.isUserDataChanged():boolean");
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
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.userInfoDidLoad);
        cancelShakeAnimation();
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
        this.avatarImage.onDetachedFromWindow();
        checkImageReceiversAttachState();
        if (this.addedForTest && this.currentUrl != null && this.currentWebFile != null) {
            ImageLoader.getInstance().removeTestWebFile(this.currentUrl);
            this.addedForTest = false;
        }
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        if (getDelegate() != null && getDelegate().getTextSelectionHelper() != null) {
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
        this.reactionsLayoutInBubble.onDetachFromWindow();
        this.statusDrawableAnimationInProgress = false;
        AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable = this.currentNameStatusDrawable;
        if (swapAnimatedEmojiDrawable != null) {
            swapAnimatedEmojiDrawable.detach();
        }
        this.rubinoProfileImage.onDetachedFromWindow();
        this.shopProfileImage.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() throws SAXException, IOException {
        super.onAttachedToWindow();
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.userInfoDidLoad);
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
        this.avatarImage.setParentView((View) getParent());
        this.avatarImage.onAttachedToWindow();
        checkImageReceiversAttachState();
        MessageObject messageObject3 = this.currentMessageObject;
        if (messageObject3 != null) {
            setAvatar(messageObject3);
        }
        int i2 = this.documentAttachType;
        if (i2 == 4 && this.autoPlayingMedia) {
            boolean zIsPlayingMessage = MediaController.getInstance().isPlayingMessage(this.currentMessageObject);
            this.animatingNoSoundPlaying = zIsPlayingMessage;
            this.animatingNoSoundProgress = zIsPlayingMessage ? 0.0f : 1.0f;
            this.animatingNoSound = 0;
        } else {
            this.animatingNoSoundPlaying = false;
            this.animatingNoSoundProgress = 0.0f;
            this.animatingDrawVideoImageButtonProgress = ((i2 == 4 || i2 == 2) && this.drawVideoSize) ? 1.0f : 0.0f;
        }
        if (getDelegate() != null && getDelegate().getTextSelectionHelper() != null) {
            getDelegate().getTextSelectionHelper().onChatMessageCellAttached(this);
        }
        if (this.documentAttachType == 5) {
            this.toSeekBarProgress = MediaController.getInstance().isPlayingMessage(this.currentMessageObject) ? 1.0f : 0.0f;
        }
        this.reactionsLayoutInBubble.onAttachToWindow();
        updateFlagSecure();
        MessageObject messageObject4 = this.currentMessageObject;
        if (messageObject4 != null && messageObject4.type == 20 && this.unlockLayout != null) {
            invalidate();
        }
        AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable = this.currentNameStatusDrawable;
        if (swapAnimatedEmojiDrawable != null) {
            swapAnimatedEmojiDrawable.attach();
        }
        this.rubinoProfileImage.onAttachedToWindow();
        this.shopProfileImage.onAttachedToWindow();
    }

    private void checkImageReceiversAttachState() {
        int i = 0;
        boolean z = this.attachedToWindow && (this.visibleOnScreen || !this.shouldCheckVisibleOnScreen);
        if (z == this.imageReceiversAttachState) {
            return;
        }
        this.imageReceiversAttachState = z;
        if (z) {
            this.radialProgress.onAttachedToWindow();
            this.videoRadialProgress.onAttachedToWindow();
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
            if (this.transactionAvatarImages != null) {
                int i4 = 0;
                while (true) {
                    ImageReceiver[] imageReceiverArr3 = this.transactionAvatarImages;
                    if (i4 >= imageReceiverArr3.length) {
                        break;
                    }
                    imageReceiverArr3[i4].onAttachedToWindow();
                    i4++;
                }
            }
            this.replyImageReceiver.onAttachedToWindow();
            this.locationImageReceiver.onAttachedToWindow();
            this.blurredPhotoImage.onAttachedToWindow();
            if (!this.photoImage.onAttachedToWindow() || this.drawPhotoImage) {
                updateButtonState(false, false, false);
            }
            MessageObject messageObject = this.currentMessageObject;
            if (messageObject != null && (this.isRoundVideo || messageObject.isVideo())) {
                checkVideoPlayback(true, null);
            }
            MessageObject messageObject2 = this.currentMessageObject;
            if (messageObject2 != null && !messageObject2.mediaExists) {
                int iCanDownloadMedia = DownloadController.getInstance(this.currentAccount).canDownloadMedia(this.currentMessageObject.messageOwner);
                TLRPC$Document document = this.currentMessageObject.getDocument();
                if (!(MessageObject.isStickerDocument(document) || MessageObject.isAnimatedStickerDocument(document, true) || MessageObject.isGifDocument(document) || MessageObject.isRoundVideoDocument(document))) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize = document == null ? FileLoader.getClosestPhotoSizeWithSize(this.currentMessageObject.photoThumbs, AndroidUtilities.getPhotoSize()) : null;
                    if (iCanDownloadMedia == 2 || (iCanDownloadMedia == 1 && this.currentMessageObject.isVideo())) {
                        if (iCanDownloadMedia != 2 && document != null && !this.currentMessageObject.shouldEncryptPhotoOrVideo() && this.currentMessageObject.canStreamVideo()) {
                            FileLoader.getInstance(this.currentAccount).loadFile(document, this.currentMessageObject, 1, 0);
                        }
                    } else if (iCanDownloadMedia != 0) {
                        if (document != null) {
                            FileLoader.getInstance(this.currentAccount).loadFile(document, this.currentMessageObject, 1, (MessageObject.isVideoDocument(document) && this.currentMessageObject.shouldEncryptPhotoOrVideo()) ? 2 : 0);
                        } else if (closestPhotoSizeWithSize != null) {
                            FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
                            ImageLocation forObject = ImageLocation.getForObject(closestPhotoSizeWithSize, this.currentMessageObject.photoThumbsObject);
                            MessageObject messageObject3 = this.currentMessageObject;
                            fileLoader.loadFile(forObject, messageObject3, null, 1, messageObject3.shouldEncryptPhotoOrVideo() ? 2 : 0);
                        }
                    }
                    updateButtonState(false, false, false);
                }
            }
            this.animatedEmojiReplyStack = AnimatedEmojiSpan.update(0, (View) this, false, this.animatedEmojiReplyStack, this.replyTextLayout);
            this.animatedEmojiDescriptionStack = AnimatedEmojiSpan.update(0, (View) this, false, this.animatedEmojiDescriptionStack, this.descriptionLayout);
            updateAnimatedEmojis();
            return;
        }
        this.radialProgress.onDetachedFromWindow();
        this.videoRadialProgress.onDetachedFromWindow();
        if (this.pollAvatarImages != null) {
            int i5 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr4 = this.pollAvatarImages;
                if (i5 >= imageReceiverArr4.length) {
                    break;
                }
                imageReceiverArr4[i5].onDetachedFromWindow();
                i5++;
            }
        }
        if (this.commentAvatarImages != null) {
            int i6 = 0;
            while (true) {
                ImageReceiver[] imageReceiverArr5 = this.commentAvatarImages;
                if (i6 >= imageReceiverArr5.length) {
                    break;
                }
                imageReceiverArr5[i6].onDetachedFromWindow();
                i6++;
            }
        }
        if (this.transactionAvatarImages != null) {
            while (true) {
                ImageReceiver[] imageReceiverArr6 = this.transactionAvatarImages;
                if (i >= imageReceiverArr6.length) {
                    break;
                }
                imageReceiverArr6[i].onDetachedFromWindow();
                i++;
            }
        }
        this.replyImageReceiver.onDetachedFromWindow();
        this.locationImageReceiver.onDetachedFromWindow();
        this.photoImage.onDetachedFromWindow();
        this.blurredPhotoImage.onDetachedFromWindow();
        cancelLoading(this.currentMessageObject);
        AnimatedEmojiSpan.release(this, this.animatedEmojiDescriptionStack);
        AnimatedEmojiSpan.release(this, this.animatedEmojiReplyStack);
        AnimatedEmojiSpan.release(this, this.animatedEmojiStack);
    }

    private void cancelLoading(MessageObject messageObject) {
        if (messageObject == null || messageObject.mediaExists || messageObject.putInDownloadsStore || DownloadController.getInstance(this.currentAccount).isDownloading(messageObject.messageOwner.id) || PhotoViewer.getInstance().isVisible()) {
            return;
        }
        TLRPC$Document document = messageObject.getDocument();
        boolean z = true;
        if (!MessageObject.isStickerDocument(document) && !MessageObject.isAnimatedStickerDocument(document, true) && !MessageObject.isGifDocument(document) && !MessageObject.isRoundVideoDocument(document)) {
            z = false;
        }
        if (z) {
            return;
        }
        if (document != null) {
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(document);
            return;
        }
        TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
        if (closestPhotoSizeWithSize != null) {
            FileLoader.getInstance(this.currentAccount).cancelLoadFile(closestPhotoSizeWithSize);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(4:5734|4195|(1:4197)(1:4198)|(3:5735|4199|4200))|(3:5737|4201|4202)|4205|(1:4213)(1:4212)|4214|(1:4216)(2:4217|4218)|4219|5732|4220) */
    /* JADX WARN: Code restructure failed: missing block: B:1371:0x161a, code lost:
    
        r7.captionWidth = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4222:0x54cc, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4226:0x54d0, code lost:
    
        org.rbmain.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Multi-variable search skipped. Vars limit reached: 8470 (expected less than 5000) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1004:0x0e66  */
    /* JADX WARN: Removed duplicated region for block: B:1006:0x0e6e  */
    /* JADX WARN: Removed duplicated region for block: B:1033:0x0ec8  */
    /* JADX WARN: Removed duplicated region for block: B:1164:0x10aa  */
    /* JADX WARN: Removed duplicated region for block: B:1168:0x10b3  */
    /* JADX WARN: Removed duplicated region for block: B:1272:0x12c6  */
    /* JADX WARN: Removed duplicated region for block: B:1277:0x12e0 A[Catch: Exception -> 0x13b7, TryCatch #6 {Exception -> 0x13b7, blocks: (B:1275:0x12ce, B:1277:0x12e0, B:1296:0x1364, B:1298:0x136a, B:1299:0x1386, B:1295:0x135d, B:1280:0x12e6, B:1282:0x12ec, B:1284:0x1301, B:1283:0x12f7, B:1285:0x1306, B:1287:0x130a, B:1289:0x1349, B:1291:0x134d, B:1292:0x1351, B:1288:0x1312), top: B:5695:0x12ce }] */
    /* JADX WARN: Removed duplicated region for block: B:1285:0x1306 A[Catch: Exception -> 0x13b7, TryCatch #6 {Exception -> 0x13b7, blocks: (B:1275:0x12ce, B:1277:0x12e0, B:1296:0x1364, B:1298:0x136a, B:1299:0x1386, B:1295:0x135d, B:1280:0x12e6, B:1282:0x12ec, B:1284:0x1301, B:1283:0x12f7, B:1285:0x1306, B:1287:0x130a, B:1289:0x1349, B:1291:0x134d, B:1292:0x1351, B:1288:0x1312), top: B:5695:0x12ce }] */
    /* JADX WARN: Removed duplicated region for block: B:1294:0x135c  */
    /* JADX WARN: Removed duplicated region for block: B:1295:0x135d A[Catch: Exception -> 0x13b7, TryCatch #6 {Exception -> 0x13b7, blocks: (B:1275:0x12ce, B:1277:0x12e0, B:1296:0x1364, B:1298:0x136a, B:1299:0x1386, B:1295:0x135d, B:1280:0x12e6, B:1282:0x12ec, B:1284:0x1301, B:1283:0x12f7, B:1285:0x1306, B:1287:0x130a, B:1289:0x1349, B:1291:0x134d, B:1292:0x1351, B:1288:0x1312), top: B:5695:0x12ce }] */
    /* JADX WARN: Removed duplicated region for block: B:1298:0x136a A[Catch: Exception -> 0x13b7, TryCatch #6 {Exception -> 0x13b7, blocks: (B:1275:0x12ce, B:1277:0x12e0, B:1296:0x1364, B:1298:0x136a, B:1299:0x1386, B:1295:0x135d, B:1280:0x12e6, B:1282:0x12ec, B:1284:0x1301, B:1283:0x12f7, B:1285:0x1306, B:1287:0x130a, B:1289:0x1349, B:1291:0x134d, B:1292:0x1351, B:1288:0x1312), top: B:5695:0x12ce }] */
    /* JADX WARN: Removed duplicated region for block: B:1299:0x1386 A[Catch: Exception -> 0x13b7, TRY_LEAVE, TryCatch #6 {Exception -> 0x13b7, blocks: (B:1275:0x12ce, B:1277:0x12e0, B:1296:0x1364, B:1298:0x136a, B:1299:0x1386, B:1295:0x135d, B:1280:0x12e6, B:1282:0x12ec, B:1284:0x1301, B:1283:0x12f7, B:1285:0x1306, B:1287:0x130a, B:1289:0x1349, B:1291:0x134d, B:1292:0x1351, B:1288:0x1312), top: B:5695:0x12ce }] */
    /* JADX WARN: Removed duplicated region for block: B:1305:0x13bf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1306:0x13c1  */
    /* JADX WARN: Removed duplicated region for block: B:1310:0x13f8 A[Catch: Exception -> 0x13c1, TryCatch #37 {Exception -> 0x13c1, blocks: (B:1308:0x13c6, B:1310:0x13f8, B:1311:0x142d), top: B:5750:0x13c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:1311:0x142d A[Catch: Exception -> 0x13c1, TRY_LEAVE, TryCatch #37 {Exception -> 0x13c1, blocks: (B:1308:0x13c6, B:1310:0x13f8, B:1311:0x142d), top: B:5750:0x13c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:1333:0x14d9 A[Catch: Exception -> 0x158b, TryCatch #24 {Exception -> 0x158b, blocks: (B:1316:0x14a0, B:1326:0x14c3, B:1332:0x14d0, B:1329:0x14c8, B:1319:0x14a5, B:1322:0x14ac, B:1323:0x14b7, B:1325:0x14bd, B:1333:0x14d9, B:1338:0x14ea, B:1341:0x14ef, B:1344:0x14f4, B:1336:0x14e6, B:1345:0x150f, B:1347:0x1532, B:1349:0x1574, B:1348:0x154a), top: B:5726:0x14a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:1354:0x1590 A[PHI: r1
      0x1590: PHI (r1v878 int) = (r1v840 int), (r1v842 int) binds: [B:1353:0x158e, B:1361:0x15e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:1403:0x16af  */
    /* JADX WARN: Removed duplicated region for block: B:1404:0x16b3  */
    /* JADX WARN: Removed duplicated region for block: B:1557:0x1988  */
    /* JADX WARN: Removed duplicated region for block: B:1596:0x19e9  */
    /* JADX WARN: Removed duplicated region for block: B:1627:0x1a85  */
    /* JADX WARN: Removed duplicated region for block: B:1632:0x1a9d  */
    /* JADX WARN: Removed duplicated region for block: B:1732:0x1d1f  */
    /* JADX WARN: Removed duplicated region for block: B:1748:0x1d8f  */
    /* JADX WARN: Removed duplicated region for block: B:1825:0x1f82  */
    /* JADX WARN: Removed duplicated region for block: B:1930:0x2176  */
    /* JADX WARN: Removed duplicated region for block: B:1931:0x2179  */
    /* JADX WARN: Removed duplicated region for block: B:1991:0x234e  */
    /* JADX WARN: Removed duplicated region for block: B:1997:0x2370  */
    /* JADX WARN: Removed duplicated region for block: B:1998:0x2380  */
    /* JADX WARN: Removed duplicated region for block: B:2002:0x2393  */
    /* JADX WARN: Removed duplicated region for block: B:2006:0x239c  */
    /* JADX WARN: Removed duplicated region for block: B:2009:0x23b2  */
    /* JADX WARN: Removed duplicated region for block: B:2010:0x23b5  */
    /* JADX WARN: Removed duplicated region for block: B:2011:0x23bd  */
    /* JADX WARN: Removed duplicated region for block: B:2017:0x23ed  */
    /* JADX WARN: Removed duplicated region for block: B:2021:0x23f6  */
    /* JADX WARN: Removed duplicated region for block: B:2022:0x23f9  */
    /* JADX WARN: Removed duplicated region for block: B:2025:0x240d  */
    /* JADX WARN: Removed duplicated region for block: B:2065:0x2585  */
    /* JADX WARN: Removed duplicated region for block: B:2089:0x262e  */
    /* JADX WARN: Removed duplicated region for block: B:2090:0x2642  */
    /* JADX WARN: Removed duplicated region for block: B:2131:0x2747  */
    /* JADX WARN: Removed duplicated region for block: B:2132:0x2749  */
    /* JADX WARN: Removed duplicated region for block: B:2149:0x2799  */
    /* JADX WARN: Removed duplicated region for block: B:2205:0x28b8  */
    /* JADX WARN: Removed duplicated region for block: B:2259:0x2ae0  */
    /* JADX WARN: Removed duplicated region for block: B:2304:0x2d05  */
    /* JADX WARN: Removed duplicated region for block: B:2305:0x2d11  */
    /* JADX WARN: Removed duplicated region for block: B:2318:0x2d30  */
    /* JADX WARN: Removed duplicated region for block: B:2331:0x2d75  */
    /* JADX WARN: Removed duplicated region for block: B:2332:0x2d78  */
    /* JADX WARN: Removed duplicated region for block: B:2336:0x2d8a  */
    /* JADX WARN: Removed duplicated region for block: B:2348:0x2da9  */
    /* JADX WARN: Removed duplicated region for block: B:2357:0x2de9  */
    /* JADX WARN: Removed duplicated region for block: B:2367:0x2e39  */
    /* JADX WARN: Removed duplicated region for block: B:2419:0x2f59  */
    /* JADX WARN: Removed duplicated region for block: B:2435:0x2f93  */
    /* JADX WARN: Removed duplicated region for block: B:2462:0x2ffd  */
    /* JADX WARN: Removed duplicated region for block: B:2468:0x3019  */
    /* JADX WARN: Removed duplicated region for block: B:2472:0x3021  */
    /* JADX WARN: Removed duplicated region for block: B:2484:0x303d  */
    /* JADX WARN: Removed duplicated region for block: B:2576:0x316f  */
    /* JADX WARN: Removed duplicated region for block: B:2583:0x3197  */
    /* JADX WARN: Removed duplicated region for block: B:2608:0x31f3  */
    /* JADX WARN: Removed duplicated region for block: B:2624:0x3227  */
    /* JADX WARN: Removed duplicated region for block: B:2628:0x3245  */
    /* JADX WARN: Removed duplicated region for block: B:2645:0x3281  */
    /* JADX WARN: Removed duplicated region for block: B:2651:0x32a1  */
    /* JADX WARN: Removed duplicated region for block: B:2670:0x32dc  */
    /* JADX WARN: Removed duplicated region for block: B:2671:0x32de  */
    /* JADX WARN: Removed duplicated region for block: B:2675:0x32f2  */
    /* JADX WARN: Removed duplicated region for block: B:2678:0x32fd  */
    /* JADX WARN: Removed duplicated region for block: B:2688:0x337f  */
    /* JADX WARN: Removed duplicated region for block: B:2692:0x338e  */
    /* JADX WARN: Removed duplicated region for block: B:2693:0x3390  */
    /* JADX WARN: Removed duplicated region for block: B:2719:0x33f0  */
    /* JADX WARN: Removed duplicated region for block: B:2752:0x345c  */
    /* JADX WARN: Removed duplicated region for block: B:2754:0x3462  */
    /* JADX WARN: Removed duplicated region for block: B:3236:0x414a A[PHI: r5
      0x414a: PHI (r5v55 org.rbmain.messenger.MessageObject) = 
      (r5v53 org.rbmain.messenger.MessageObject)
      (r5v53 org.rbmain.messenger.MessageObject)
      (r5v56 org.rbmain.messenger.MessageObject)
     binds: [B:3226:0x4133, B:3229:0x413c, B:3235:0x4148] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:3240:0x4155  */
    /* JADX WARN: Removed duplicated region for block: B:3245:0x4172  */
    /* JADX WARN: Removed duplicated region for block: B:3253:0x41b6  */
    /* JADX WARN: Removed duplicated region for block: B:3266:0x41de  */
    /* JADX WARN: Removed duplicated region for block: B:3270:0x41fe  */
    /* JADX WARN: Removed duplicated region for block: B:3274:0x420e  */
    /* JADX WARN: Removed duplicated region for block: B:3278:0x4221  */
    /* JADX WARN: Removed duplicated region for block: B:3406:0x44b1  */
    /* JADX WARN: Removed duplicated region for block: B:3411:0x44bf  */
    /* JADX WARN: Removed duplicated region for block: B:3414:0x44cc  */
    /* JADX WARN: Removed duplicated region for block: B:3423:0x4514  */
    /* JADX WARN: Removed duplicated region for block: B:3426:0x4519  */
    /* JADX WARN: Removed duplicated region for block: B:3452:0x45b7  */
    /* JADX WARN: Removed duplicated region for block: B:3463:0x45f5  */
    /* JADX WARN: Removed duplicated region for block: B:3466:0x4604  */
    /* JADX WARN: Removed duplicated region for block: B:3473:0x4638  */
    /* JADX WARN: Removed duplicated region for block: B:3483:0x467e  */
    /* JADX WARN: Removed duplicated region for block: B:3816:0x4da7  */
    /* JADX WARN: Removed duplicated region for block: B:3817:0x4daa  */
    /* JADX WARN: Removed duplicated region for block: B:3825:0x4dba  */
    /* JADX WARN: Removed duplicated region for block: B:3835:0x4e07  */
    /* JADX WARN: Removed duplicated region for block: B:3846:0x4e49  */
    /* JADX WARN: Removed duplicated region for block: B:3850:0x4e65  */
    /* JADX WARN: Removed duplicated region for block: B:3861:0x4e90  */
    /* JADX WARN: Removed duplicated region for block: B:3880:0x4ee6  */
    /* JADX WARN: Removed duplicated region for block: B:3884:0x4efd  */
    /* JADX WARN: Removed duplicated region for block: B:3887:0x4f15  */
    /* JADX WARN: Removed duplicated region for block: B:3893:0x4f32  */
    /* JADX WARN: Removed duplicated region for block: B:3896:0x4f47  */
    /* JADX WARN: Removed duplicated region for block: B:3908:0x4fb0  */
    /* JADX WARN: Removed duplicated region for block: B:3936:0x5007  */
    /* JADX WARN: Removed duplicated region for block: B:3942:0x501e  */
    /* JADX WARN: Removed duplicated region for block: B:3946:0x5035  */
    /* JADX WARN: Removed duplicated region for block: B:3970:0x507e  */
    /* JADX WARN: Removed duplicated region for block: B:3972:0x5081  */
    /* JADX WARN: Removed duplicated region for block: B:3973:0x5084  */
    /* JADX WARN: Removed duplicated region for block: B:3998:0x50b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:4002:0x50ba  */
    /* JADX WARN: Removed duplicated region for block: B:4007:0x50da  */
    /* JADX WARN: Removed duplicated region for block: B:4017:0x510a  */
    /* JADX WARN: Removed duplicated region for block: B:4021:0x5118  */
    /* JADX WARN: Removed duplicated region for block: B:4022:0x511e  */
    /* JADX WARN: Removed duplicated region for block: B:4026:0x5129 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:4030:0x5132  */
    /* JADX WARN: Removed duplicated region for block: B:4107:0x52c0  */
    /* JADX WARN: Removed duplicated region for block: B:4108:0x52c2  */
    /* JADX WARN: Removed duplicated region for block: B:4111:0x52c9  */
    /* JADX WARN: Removed duplicated region for block: B:4116:0x52d6 A[PHI: r1 r2 r6 r10 r11
      0x52d6: PHI (r1v285 int) = (r1v213 int), (r1v216 int) binds: [B:4115:0x52d4, B:4131:0x535a] A[DONT_GENERATE, DONT_INLINE]
      0x52d6: PHI (r2v243 boolean) = (r2v157 boolean), (r2v163 boolean) binds: [B:4115:0x52d4, B:4131:0x535a] A[DONT_GENERATE, DONT_INLINE]
      0x52d6: PHI (r6v194 int) = (r6v143 int), (r6v146 int) binds: [B:4115:0x52d4, B:4131:0x535a] A[DONT_GENERATE, DONT_INLINE]
      0x52d6: PHI (r10v144 int) = (r10v57 int), (r10v61 int) binds: [B:4115:0x52d4, B:4131:0x535a] A[DONT_GENERATE, DONT_INLINE]
      0x52d6: PHI (r11v115 java.lang.String) = (r11v48 java.lang.String), (r11v50 java.lang.String) binds: [B:4115:0x52d4, B:4131:0x535a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:4117:0x52da  */
    /* JADX WARN: Removed duplicated region for block: B:4187:0x5402  */
    /* JADX WARN: Removed duplicated region for block: B:4193:0x5411 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:4194:0x5413  */
    /* JADX WARN: Removed duplicated region for block: B:4197:0x541a  */
    /* JADX WARN: Removed duplicated region for block: B:4198:0x541b A[Catch: Exception -> 0x54ce, TRY_LEAVE, TryCatch #28 {Exception -> 0x54ce, blocks: (B:4195:0x5416, B:4208:0x5449, B:4213:0x546c, B:4214:0x5481, B:4216:0x54a9, B:4217:0x54b8, B:4212:0x5450, B:4198:0x541b), top: B:5734:0x5416 }] */
    /* JADX WARN: Removed duplicated region for block: B:4208:0x5449 A[Catch: Exception -> 0x54ce, TRY_ENTER, TryCatch #28 {Exception -> 0x54ce, blocks: (B:4195:0x5416, B:4208:0x5449, B:4213:0x546c, B:4214:0x5481, B:4216:0x54a9, B:4217:0x54b8, B:4212:0x5450, B:4198:0x541b), top: B:5734:0x5416 }] */
    /* JADX WARN: Removed duplicated region for block: B:4212:0x5450 A[Catch: Exception -> 0x54ce, TryCatch #28 {Exception -> 0x54ce, blocks: (B:4195:0x5416, B:4208:0x5449, B:4213:0x546c, B:4214:0x5481, B:4216:0x54a9, B:4217:0x54b8, B:4212:0x5450, B:4198:0x541b), top: B:5734:0x5416 }] */
    /* JADX WARN: Removed duplicated region for block: B:4216:0x54a9 A[Catch: Exception -> 0x54ce, TryCatch #28 {Exception -> 0x54ce, blocks: (B:4195:0x5416, B:4208:0x5449, B:4213:0x546c, B:4214:0x5481, B:4216:0x54a9, B:4217:0x54b8, B:4212:0x5450, B:4198:0x541b), top: B:5734:0x5416 }] */
    /* JADX WARN: Removed duplicated region for block: B:4217:0x54b8 A[Catch: Exception -> 0x54ce, TRY_LEAVE, TryCatch #28 {Exception -> 0x54ce, blocks: (B:4195:0x5416, B:4208:0x5449, B:4213:0x546c, B:4214:0x5481, B:4216:0x54a9, B:4217:0x54b8, B:4212:0x5450, B:4198:0x541b), top: B:5734:0x5416 }] */
    /* JADX WARN: Removed duplicated region for block: B:4229:0x54d7  */
    /* JADX WARN: Removed duplicated region for block: B:4322:0x564b  */
    /* JADX WARN: Removed duplicated region for block: B:4330:0x565b  */
    /* JADX WARN: Removed duplicated region for block: B:4332:0x565e  */
    /* JADX WARN: Removed duplicated region for block: B:4355:0x56b2  */
    /* JADX WARN: Removed duplicated region for block: B:4357:0x56b8  */
    /* JADX WARN: Removed duplicated region for block: B:4358:0x56ba  */
    /* JADX WARN: Removed duplicated region for block: B:4361:0x56c7  */
    /* JADX WARN: Removed duplicated region for block: B:4362:0x56c9  */
    /* JADX WARN: Removed duplicated region for block: B:4365:0x56d2  */
    /* JADX WARN: Removed duplicated region for block: B:4366:0x56d5  */
    /* JADX WARN: Removed duplicated region for block: B:4370:0x56e6  */
    /* JADX WARN: Removed duplicated region for block: B:4372:0x56ec  */
    /* JADX WARN: Removed duplicated region for block: B:4613:0x5c23  */
    /* JADX WARN: Removed duplicated region for block: B:4618:0x5c2a  */
    /* JADX WARN: Removed duplicated region for block: B:4632:0x5c51  */
    /* JADX WARN: Removed duplicated region for block: B:4634:0x5c7c  */
    /* JADX WARN: Removed duplicated region for block: B:4874:0x60da  */
    /* JADX WARN: Removed duplicated region for block: B:4882:0x60f7  */
    /* JADX WARN: Removed duplicated region for block: B:4935:0x62cb  */
    /* JADX WARN: Removed duplicated region for block: B:4956:0x6322  */
    /* JADX WARN: Removed duplicated region for block: B:4979:0x6361  */
    /* JADX WARN: Removed duplicated region for block: B:4985:0x63c9  */
    /* JADX WARN: Removed duplicated region for block: B:5013:0x64e6  */
    /* JADX WARN: Removed duplicated region for block: B:5037:0x6555  */
    /* JADX WARN: Removed duplicated region for block: B:5046:0x6576  */
    /* JADX WARN: Removed duplicated region for block: B:5052:0x6589  */
    /* JADX WARN: Removed duplicated region for block: B:5061:0x659d  */
    /* JADX WARN: Removed duplicated region for block: B:5072:0x65b6  */
    /* JADX WARN: Removed duplicated region for block: B:5073:0x65b9  */
    /* JADX WARN: Removed duplicated region for block: B:5089:0x65f9  */
    /* JADX WARN: Removed duplicated region for block: B:5099:0x6633  */
    /* JADX WARN: Removed duplicated region for block: B:5100:0x6634 A[Catch: Exception -> 0x66d2, TryCatch #23 {Exception -> 0x66d2, blocks: (B:5091:0x661e, B:5097:0x662d, B:5113:0x665a, B:5120:0x666b, B:5124:0x6678, B:5126:0x668d, B:5129:0x66cb, B:5128:0x66a8, B:5116:0x665f, B:5119:0x6664, B:5100:0x6634, B:5102:0x663a, B:5106:0x6645, B:5112:0x6659, B:5107:0x664a, B:5111:0x6655, B:5094:0x6628), top: B:5724:0x661e }] */
    /* JADX WARN: Removed duplicated region for block: B:5115:0x665e A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:5116:0x665f A[Catch: Exception -> 0x66d2, TryCatch #23 {Exception -> 0x66d2, blocks: (B:5091:0x661e, B:5097:0x662d, B:5113:0x665a, B:5120:0x666b, B:5124:0x6678, B:5126:0x668d, B:5129:0x66cb, B:5128:0x66a8, B:5116:0x665f, B:5119:0x6664, B:5100:0x6634, B:5102:0x663a, B:5106:0x6645, B:5112:0x6659, B:5107:0x664a, B:5111:0x6655, B:5094:0x6628), top: B:5724:0x661e }] */
    /* JADX WARN: Removed duplicated region for block: B:5122:0x6674  */
    /* JADX WARN: Removed duplicated region for block: B:5123:0x6676  */
    /* JADX WARN: Removed duplicated region for block: B:5126:0x668d A[Catch: Exception -> 0x66d2, TryCatch #23 {Exception -> 0x66d2, blocks: (B:5091:0x661e, B:5097:0x662d, B:5113:0x665a, B:5120:0x666b, B:5124:0x6678, B:5126:0x668d, B:5129:0x66cb, B:5128:0x66a8, B:5116:0x665f, B:5119:0x6664, B:5100:0x6634, B:5102:0x663a, B:5106:0x6645, B:5112:0x6659, B:5107:0x664a, B:5111:0x6655, B:5094:0x6628), top: B:5724:0x661e }] */
    /* JADX WARN: Removed duplicated region for block: B:5128:0x66a8 A[Catch: Exception -> 0x66d2, TryCatch #23 {Exception -> 0x66d2, blocks: (B:5091:0x661e, B:5097:0x662d, B:5113:0x665a, B:5120:0x666b, B:5124:0x6678, B:5126:0x668d, B:5129:0x66cb, B:5128:0x66a8, B:5116:0x665f, B:5119:0x6664, B:5100:0x6634, B:5102:0x663a, B:5106:0x6645, B:5112:0x6659, B:5107:0x664a, B:5111:0x6655, B:5094:0x6628), top: B:5724:0x661e }] */
    /* JADX WARN: Removed duplicated region for block: B:5136:0x66db  */
    /* JADX WARN: Removed duplicated region for block: B:5159:0x6738  */
    /* JADX WARN: Removed duplicated region for block: B:5160:0x673a A[Catch: Exception -> 0x67f0, TryCatch #10 {Exception -> 0x67f0, blocks: (B:5142:0x66e8, B:5152:0x671d, B:5157:0x6731, B:5164:0x6766, B:5168:0x6773, B:5174:0x678e, B:5180:0x679b, B:5184:0x67ab, B:5187:0x67c2, B:5190:0x67d2, B:5183:0x67a5, B:5177:0x6793, B:5171:0x6788, B:5167:0x676b, B:5160:0x673a, B:5155:0x672b, B:5161:0x6746, B:5145:0x66ef, B:5148:0x66f4, B:5149:0x670d, B:5151:0x6715, B:5191:0x67dc), top: B:5702:0x66e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:5163:0x6764  */
    /* JADX WARN: Removed duplicated region for block: B:5164:0x6766 A[Catch: Exception -> 0x67f0, TryCatch #10 {Exception -> 0x67f0, blocks: (B:5142:0x66e8, B:5152:0x671d, B:5157:0x6731, B:5164:0x6766, B:5168:0x6773, B:5174:0x678e, B:5180:0x679b, B:5184:0x67ab, B:5187:0x67c2, B:5190:0x67d2, B:5183:0x67a5, B:5177:0x6793, B:5171:0x6788, B:5167:0x676b, B:5160:0x673a, B:5155:0x672b, B:5161:0x6746, B:5145:0x66ef, B:5148:0x66f4, B:5149:0x670d, B:5151:0x6715, B:5191:0x67dc), top: B:5702:0x66e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:5191:0x67dc A[Catch: Exception -> 0x67f0, TRY_LEAVE, TryCatch #10 {Exception -> 0x67f0, blocks: (B:5142:0x66e8, B:5152:0x671d, B:5157:0x6731, B:5164:0x6766, B:5168:0x6773, B:5174:0x678e, B:5180:0x679b, B:5184:0x67ab, B:5187:0x67c2, B:5190:0x67d2, B:5183:0x67a5, B:5177:0x6793, B:5171:0x6788, B:5167:0x676b, B:5160:0x673a, B:5155:0x672b, B:5161:0x6746, B:5145:0x66ef, B:5148:0x66f4, B:5149:0x670d, B:5151:0x6715, B:5191:0x67dc), top: B:5702:0x66e8 }] */
    /* JADX WARN: Removed duplicated region for block: B:5202:0x67f9  */
    /* JADX WARN: Removed duplicated region for block: B:5205:0x6801  */
    /* JADX WARN: Removed duplicated region for block: B:5212:0x6810  */
    /* JADX WARN: Removed duplicated region for block: B:5230:0x6853  */
    /* JADX WARN: Removed duplicated region for block: B:5234:0x6865  */
    /* JADX WARN: Removed duplicated region for block: B:5243:0x687a  */
    /* JADX WARN: Removed duplicated region for block: B:5259:0x68b0  */
    /* JADX WARN: Removed duplicated region for block: B:5261:0x68b8  */
    /* JADX WARN: Removed duplicated region for block: B:5262:0x68ba  */
    /* JADX WARN: Removed duplicated region for block: B:5265:0x68d8  */
    /* JADX WARN: Removed duplicated region for block: B:5266:0x68db  */
    /* JADX WARN: Removed duplicated region for block: B:5270:0x68e8  */
    /* JADX WARN: Removed duplicated region for block: B:5281:0x692d  */
    /* JADX WARN: Removed duplicated region for block: B:5286:0x693c  */
    /* JADX WARN: Removed duplicated region for block: B:5294:0x6959  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:5387:0x6bc6  */
    /* JADX WARN: Removed duplicated region for block: B:5394:0x6bd4  */
    /* JADX WARN: Removed duplicated region for block: B:5402:0x6bf2  */
    /* JADX WARN: Removed duplicated region for block: B:5404:0x6bf6  */
    /* JADX WARN: Removed duplicated region for block: B:5423:0x6c2e  */
    /* JADX WARN: Removed duplicated region for block: B:5438:0x6c5f  */
    /* JADX WARN: Removed duplicated region for block: B:5450:0x6c9d  */
    /* JADX WARN: Removed duplicated region for block: B:5451:0x6c9f  */
    /* JADX WARN: Removed duplicated region for block: B:5457:0x6cc1  */
    /* JADX WARN: Removed duplicated region for block: B:5458:0x6cc7  */
    /* JADX WARN: Removed duplicated region for block: B:5468:0x6cfe  */
    /* JADX WARN: Removed duplicated region for block: B:5518:0x6d6f A[PHI: r1 r3 r6 r7
      0x6d6f: PHI (r1v122 int) = (r1v121 int), (r1v121 int), (r1v131 int) binds: [B:5514:0x6d68, B:5517:0x6d6d, B:5532:0x6d8a] A[DONT_GENERATE, DONT_INLINE]
      0x6d6f: PHI (r3v37 int) = (r3v36 int), (r3v36 int), (r3v51 int) binds: [B:5514:0x6d68, B:5517:0x6d6d, B:5532:0x6d8a] A[DONT_GENERATE, DONT_INLINE]
      0x6d6f: PHI (r6v21 int) = (r6v20 int), (r6v20 int), (r6v25 int) binds: [B:5514:0x6d68, B:5517:0x6d6d, B:5532:0x6d8a] A[DONT_GENERATE, DONT_INLINE]
      0x6d6f: PHI (r7v9 int) = (r7v8 int), (r7v8 int), (r7v14 int) binds: [B:5514:0x6d68, B:5517:0x6d6d, B:5532:0x6d8a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:5567:0x6ddc  */
    /* JADX WARN: Removed duplicated region for block: B:5602:0x6e56  */
    /* JADX WARN: Removed duplicated region for block: B:5626:0x6e8e  */
    /* JADX WARN: Removed duplicated region for block: B:5628:0x6e92  */
    /* JADX WARN: Removed duplicated region for block: B:5633:0x6ea3  */
    /* JADX WARN: Removed duplicated region for block: B:5646:0x6edc  */
    /* JADX WARN: Removed duplicated region for block: B:5693:0x5142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5702:0x66e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5719:0x1593 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x09df  */
    /* JADX WARN: Removed duplicated region for block: B:770:0x0b5d  */
    /* JADX WARN: Removed duplicated region for block: B:773:0x0b68  */
    /* JADX WARN: Removed duplicated region for block: B:801:0x0ba7  */
    /* JADX WARN: Removed duplicated region for block: B:802:0x0bb2  */
    /* JADX WARN: Removed duplicated region for block: B:804:0x0bc4  */
    /* JADX WARN: Removed duplicated region for block: B:809:0x0bd9  */
    /* JADX WARN: Removed duplicated region for block: B:813:0x0be5  */
    /* JADX WARN: Removed duplicated region for block: B:818:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:819:0x0bfb  */
    /* JADX WARN: Removed duplicated region for block: B:831:0x0c3f  */
    /* JADX WARN: Removed duplicated region for block: B:832:0x0c41  */
    /* JADX WARN: Removed duplicated region for block: B:835:0x0c4a  */
    /* JADX WARN: Removed duplicated region for block: B:856:0x0c93  */
    /* JADX WARN: Removed duplicated region for block: B:858:0x0ca0  */
    /* JADX WARN: Removed duplicated region for block: B:885:0x0cdb  */
    /* JADX WARN: Removed duplicated region for block: B:925:0x0d39  */
    /* JADX WARN: Removed duplicated region for block: B:945:0x0d8d  */
    /* JADX WARN: Removed duplicated region for block: B:963:0x0dd2  */
    /* JADX WARN: Removed duplicated region for block: B:969:0x0ddf  */
    /* JADX WARN: Removed duplicated region for block: B:971:0x0ded  */
    /* JADX WARN: Removed duplicated region for block: B:979:0x0e00  */
    /* JADX WARN: Removed duplicated region for block: B:980:0x0e05  */
    /* JADX WARN: Removed duplicated region for block: B:984:0x0e1e  */
    /* JADX WARN: Removed duplicated region for block: B:987:0x0e27  */
    /* JADX WARN: Removed duplicated region for block: B:989:0x0e2f  */
    /* JADX WARN: Removed duplicated region for block: B:996:0x0e49  */
    /* JADX WARN: Type inference failed for: r0v134, types: [org.rbmain.ui.Components.RadialProgress2] */
    /* JADX WARN: Type inference failed for: r0v142, types: [org.rbmain.ui.Components.RadialProgress2] */
    /* JADX WARN: Type inference failed for: r0v834, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v232 */
    /* JADX WARN: Type inference failed for: r13v233 */
    /* JADX WARN: Type inference failed for: r1v108 */
    /* JADX WARN: Type inference failed for: r1v1086 */
    /* JADX WARN: Type inference failed for: r1v109, types: [java.lang.Object, org.rbmain.tgnet.TLRPC$Document, org.rbmain.tgnet.TLRPC$PhotoSize] */
    /* JADX WARN: Type inference failed for: r1v136 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageContent(org.rbmain.messenger.MessageObject r67, org.rbmain.messenger.MessageObject.GroupedMessages r68, boolean r69, boolean r70) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 28752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.setMessageContent(org.rbmain.messenger.MessageObject, org.rbmain.messenger.MessageObject$GroupedMessages, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMessageContent$10(TLRPC$User tLRPC$User, int i, TLRPC$Chat tLRPC$Chat, int i2) {
        if (tLRPC$User != null) {
            this.commentAvatarDrawables[i].setInfo(tLRPC$User);
            this.commentAvatarImages[i].setForUserOrChat(tLRPC$User, this.commentAvatarDrawables[i]);
        } else if (tLRPC$Chat != null) {
            this.commentAvatarDrawables[i].setInfo(tLRPC$Chat);
            this.commentAvatarImages[i].setForUserOrChat(tLRPC$Chat, this.commentAvatarDrawables[i]);
        } else {
            this.commentAvatarDrawables[i].setInfo(i2, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$setMessageContent$11(PollButton pollButton, PollButton pollButton2) {
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

    private boolean loopStickers() {
        return LiteMode.isEnabled(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void highlightCaptionLink(URLSpan uRLSpan) {
        if (uRLSpan != null) {
            try {
                StaticLayout staticLayout = this.captionLayout;
                if (staticLayout == null || !(staticLayout.getText() instanceof Spanned) || uRLSpan == this.highlightPathSpan) {
                    return;
                }
                this.highlightPathSpan = uRLSpan;
                Spanned spanned = (Spanned) this.captionLayout.getText();
                int spanStart = spanned.getSpanStart(this.highlightPathSpan);
                int spanEnd = spanned.getSpanEnd(this.highlightPathSpan);
                LinkPath linkPath = this.highlightPath;
                if (linkPath != null) {
                    linkPath.rewind();
                } else {
                    this.highlightPath = new LinkPath(true);
                }
                this.highlightPath.setCurrentLayout(this.captionLayout, spanStart, 0.0f);
                this.captionLayout.getSelectionPath(spanStart, spanEnd, this.highlightPath);
                this.highlightPathStart = System.currentTimeMillis();
                invalidate();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void calculateUnlockXY() {
        if (this.currentMessageObject.type != 20 || this.unlockLayout == null) {
            return;
        }
        this.unlockX = this.backgroundDrawableLeft + ((this.photoImage.getImageWidth() - this.unlockLayout.getWidth()) / 2.0f);
        this.unlockY = this.backgroundDrawableTop + this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - this.unlockLayout.getHeight()) / 2.0f);
    }

    private String getProductVarietyName(String str) {
        return (!TextUtils.isEmpty(str) && str.equals(ShopModels.ProductVarietyTypeEnum.Size.name())) ? LocaleController.getString(ir.medu.shad.R.string.VarietySizeTitle) : BuildConfig.FLAVOR;
    }

    public void checkVideoPlayback(boolean z, Bitmap bitmap) {
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
        if (z) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            z = playingMessageObject == null || !playingMessageObject.isRoundVideo();
        }
        this.photoImage.setAllowStartAnimation(z);
        if (bitmap != null) {
            this.photoImage.startCrossfadeFromStaticThumb(bitmap);
        }
        if (z) {
            this.photoImage.startAnimation();
        } else {
            this.photoImage.stopAnimation();
        }
    }

    private static boolean spanSupportsLongPress(CharacterStyle characterStyle) {
        return (characterStyle instanceof URLSpanMono) || (characterStyle instanceof URLSpan);
    }

    @Override // org.rbmain.ui.Cells.BaseCell
    protected boolean onLongPress() {
        long j;
        boolean zDidLongPressChannelAvatar = false;
        if (this.isRoundVideo && this.isPlayingRound && MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && ((this.lastTouchX - this.photoImage.getCenterX()) * (this.lastTouchX - this.photoImage.getCenterX())) + ((this.lastTouchY - this.photoImage.getCenterY()) * (this.lastTouchY - this.photoImage.getCenterY())) < (this.photoImage.getImageWidth() / 2.0f) * (this.photoImage.getImageWidth() / 2.0f) && (this.lastTouchX > this.photoImage.getCenterX() + (this.photoImage.getImageWidth() / 4.0f) || this.lastTouchX < this.photoImage.getCenterX() - (this.photoImage.getImageWidth() / 4.0f))) {
            this.photoImage.getCenterX();
            return false;
        }
        Drawable drawable = this.replySelector;
        if (drawable != null) {
            this.replySelectorPressed = false;
            drawable.setState(new int[0]);
            invalidate();
        }
        if (this.pressedEmoji != null) {
            this.pressedEmoji = null;
        }
        LinkSpanDrawable linkSpanDrawable = this.pressedLink;
        if (linkSpanDrawable != null) {
            if (linkSpanDrawable.getSpan() instanceof URLSpanMono) {
                this.hadLongPress = true;
                this.delegate.didPressUrl(this, this.pressedLink.getSpan(), true);
                return true;
            }
            if (this.pressedLink.getSpan() instanceof URLSpanNoUnderline) {
                URLSpanNoUnderline uRLSpanNoUnderline = (URLSpanNoUnderline) this.pressedLink.getSpan();
                if (ChatActivity.isClickableLink(uRLSpanNoUnderline.getURL()) || uRLSpanNoUnderline.getURL().startsWith("/")) {
                    this.hadLongPress = true;
                    this.delegate.didPressUrl(this, this.pressedLink.getSpan(), true);
                    return true;
                }
            } else if (this.pressedLink.getSpan() instanceof URLSpan) {
                this.hadLongPress = true;
                this.delegate.didPressUrl(this, this.pressedLink.getSpan(), true);
                return true;
            }
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
            this.instantPressed = false;
            setInstantButtonPressed(false);
            this.pressedVoteButton = -1;
            this.pollHintPressed = false;
            this.psaHintPressed = false;
            this.otherPressed = false;
            if (Build.VERSION.SDK_INT >= 21) {
                int i = 0;
                while (true) {
                    Drawable[] drawableArr = this.selectorDrawable;
                    if (i >= drawableArr.length) {
                        break;
                    }
                    if (drawableArr[i] != null) {
                        drawableArr[i].setState(StateSet.NOTHING);
                    }
                    i++;
                }
            }
            invalidate();
        }
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        if (chatMessageCellDelegate != null) {
            if (this.avatarPressed) {
                TLRPC$User tLRPC$User = this.currentUser;
                if (tLRPC$User != null) {
                    if (tLRPC$User.id != 0) {
                        zDidLongPressChannelAvatar = chatMessageCellDelegate.didLongPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
                    }
                } else {
                    TLRPC$Chat tLRPC$Chat = this.currentChat;
                    if (tLRPC$Chat != null) {
                        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.currentMessageObject.messageOwner.fwd_from;
                        if (tLRPC$MessageFwdHeader == null) {
                            j = 0;
                        } else if ((tLRPC$MessageFwdHeader.flags & 16) != 0) {
                            j = tLRPC$MessageFwdHeader.saved_from_msg_id;
                        } else {
                            j = tLRPC$MessageFwdHeader.channel_post;
                        }
                        zDidLongPressChannelAvatar = chatMessageCellDelegate.didLongPressChannelAvatar(this, tLRPC$Chat, j, this.lastTouchX, this.lastTouchY);
                    }
                }
            }
            if (!zDidLongPressChannelAvatar) {
                this.delegate.didLongPress(this, this.lastTouchX, this.lastTouchY);
            }
        }
        return true;
    }

    public void showHintButton(boolean z, boolean z2, int i) {
        if (i == -1 || i == 0) {
            if (this.hintButtonVisible == z) {
                return;
            }
            this.hintButtonVisible = z;
            if (!z2) {
                this.hintButtonProgress = z ? 1.0f : 0.0f;
            } else {
                invalidate();
            }
        }
        if ((i == -1 || i == 1) && this.psaButtonVisible != z) {
            this.psaButtonVisible = z;
            if (!z2) {
                this.psaButtonProgress = z ? 1.0f : 0.0f;
            } else {
                setInvalidatesParent(true);
                invalidate();
            }
        }
    }

    public void setCheckPressed(boolean z, boolean z2) {
        this.isCheckPressed = z;
        this.isPressed = z2;
        updateRadialProgressBackground();
        if (this.useSeekBarWaveform) {
            this.seekBarWaveform.setSelected(isDrawSelectionBackground());
        } else {
            this.seekBar.setSelected(isDrawSelectionBackground());
        }
        invalidate();
    }

    public void setInvalidateSpoilersParent(boolean z) {
        this.invalidateSpoilersParent = z;
    }

    public void setInvalidatesParent(boolean z) {
        this.invalidatesParent = z;
    }

    private boolean invalidateParentForce() {
        return (this.links.isEmpty() && this.reactionsLayoutInBubble.isEmpty) ? false : true;
    }

    public void invalidateOutbounds() {
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        if (chatMessageCellDelegate == null || !chatMessageCellDelegate.canDrawOutboundsContent()) {
            if (getParent() instanceof View) {
                ((View) getParent()).invalidate();
                return;
            }
            return;
        }
        super.invalidate();
    }

    @Override // android.view.View, org.rbmain.ui.Cells.TextSelectionHelper.SelectableView
    public void invalidate() {
        ChatMessageCellDelegate chatMessageCellDelegate;
        if (this.currentMessageObject == null) {
            return;
        }
        super.invalidate();
        if ((this.invalidatesParent || (this.currentMessagesGroup != null && invalidateParentForce())) && getParent() != null) {
            View view = (View) getParent();
            if (view.getParent() != null) {
                view.invalidate();
                ((View) view.getParent()).invalidate();
            }
        }
        if (!this.isBlurred || (chatMessageCellDelegate = this.delegate) == null) {
            return;
        }
        chatMessageCellDelegate.invalidateBlur();
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        ChatMessageCellDelegate chatMessageCellDelegate;
        if (this.currentMessageObject == null) {
            return;
        }
        super.invalidate(i, i2, i3, i4);
        if (this.invalidatesParent && getParent() != null) {
            ((View) getParent()).invalidate(((int) getX()) + i, ((int) getY()) + i2, ((int) getX()) + i3, ((int) getY()) + i4);
        }
        if (!this.isBlurred || (chatMessageCellDelegate = this.delegate) == null) {
            return;
        }
        chatMessageCellDelegate.invalidateBlur();
    }

    public boolean isHighlightedAnimated() {
        return this.isHighlightedAnimated;
    }

    public void setHighlightedAnimated() {
        this.isHighlightedAnimated = true;
        this.highlightProgress = CloseCodes.NORMAL_CLOSURE;
        this.lastHighlightProgressTime = System.currentTimeMillis();
        invalidate();
        if (getParent() != null) {
            ((View) getParent()).invalidate();
        }
    }

    public boolean isHighlighted() {
        return this.isHighlighted;
    }

    public void setHighlighted(boolean z) {
        if (this.isHighlighted == z) {
            return;
        }
        this.isHighlighted = z;
        if (!z) {
            this.lastHighlightProgressTime = System.currentTimeMillis();
            this.isHighlightedAnimated = true;
            this.highlightProgress = 300;
        } else {
            this.isHighlightedAnimated = false;
            this.highlightProgress = 0;
        }
        updateRadialProgressBackground();
        if (this.useSeekBarWaveform) {
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
    public void setPressed(boolean z) {
        super.setPressed(z);
        updateRadialProgressBackground();
        if (this.useSeekBarWaveform) {
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

    @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarPressed() {
        requestDisallowInterceptTouchEvent(true);
    }

    @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarReleased() {
        requestDisallowInterceptTouchEvent(false);
    }

    @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarDrag(float f) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        messageObject.audioProgress = f;
        MediaController.getInstance().seekToProgress(this.currentMessageObject, f);
        updatePlayingMessageProgress();
    }

    @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
    public void onSeekBarContinuousDrag(float f) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null) {
            return;
        }
        messageObject.audioProgress = f;
        messageObject.audioProgressSec = (int) (messageObject.getDuration() * f);
        updatePlayingMessageProgress();
    }

    public boolean isAnimatingPollAnswer() {
        return this.animatePollAnswerAlpha;
    }

    private void updateWaveform() {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null) {
            int i = this.documentAttachType;
            if (i == 3 || i == 7) {
                byte[] waveform = messageObject.getWaveform();
                this.useSeekBarWaveform = waveform != null;
                SeekBarWaveform seekBarWaveform = this.seekBarWaveform;
                if (seekBarWaveform != null) {
                    seekBarWaveform.setWaveform(waveform);
                }
                this.useTranscribeButton = false;
                updateSeekBarWaveformWidth(null);
            }
        }
    }

    private void updateSeekBarWaveformWidth(Canvas canvas) {
        int i;
        this.seekBarWaveformTranslateX = 0;
        int i2 = -AndroidUtilities.dp((this.hasLinkPreview ? 10 : 0) + 92);
        TransitionParams transitionParams = this.transitionParams;
        if (transitionParams.animateBackgroundBoundsInner && ((i = this.documentAttachType) == 3 || i == 7)) {
            int i3 = this.backgroundWidth;
            int iDp = (int) ((i3 - transitionParams.toDeltaLeft) + transitionParams.toDeltaRight);
            int videoTranscriptionProgress = (int) ((i3 - transitionParams.deltaLeft) + transitionParams.deltaRight);
            if (this.isRoundVideo && !this.drawBackground) {
                videoTranscriptionProgress = (int) (videoTranscriptionProgress + (getVideoTranscriptionProgress() * AndroidUtilities.dp(8.0f)));
                iDp += AndroidUtilities.dp(8.0f);
            }
            TransitionParams transitionParams2 = this.transitionParams;
            if (transitionParams2.toDeltaLeft == 0.0f && transitionParams2.toDeltaRight == 0.0f) {
                iDp = videoTranscriptionProgress;
            }
            SeekBarWaveform seekBarWaveform = this.seekBarWaveform;
            if (seekBarWaveform != null) {
                if (transitionParams2.animateUseTranscribeButton) {
                    seekBarWaveform.setSize((videoTranscriptionProgress + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())), AndroidUtilities.dp(30.0f), i3 + i2 + (!this.useTranscribeButton ? -AndroidUtilities.dp(34.0f) : 0), iDp + i2 + (this.useTranscribeButton ? -AndroidUtilities.dp(34.0f) : 0));
                } else {
                    seekBarWaveform.setSize((videoTranscriptionProgress + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())), AndroidUtilities.dp(30.0f), (i3 + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())), (iDp + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())));
                }
            }
            SeekBar seekBar = this.seekBar;
            if (seekBar != null) {
                seekBar.setSize((videoTranscriptionProgress - ((int) (getUseTranscribeButtonProgress() * AndroidUtilities.dp(34.0f)))) - AndroidUtilities.dp((this.documentAttachType != 5 ? 72 : 65) + (this.hasLinkPreview ? 10 : 0)), AndroidUtilities.dp(30.0f));
                return;
            }
            return;
        }
        SeekBarWaveform seekBarWaveform2 = this.seekBarWaveform;
        if (seekBarWaveform2 != null) {
            if (transitionParams.animateUseTranscribeButton) {
                seekBarWaveform2.setSize((this.backgroundWidth + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())), AndroidUtilities.dp(30.0f), this.backgroundWidth + i2 + (!this.useTranscribeButton ? -AndroidUtilities.dp(34.0f) : 0), this.backgroundWidth + i2 + (this.useTranscribeButton ? -AndroidUtilities.dp(34.0f) : 0));
            } else {
                seekBarWaveform2.setSize((this.backgroundWidth + i2) - ((int) (AndroidUtilities.dp(34.0f) * getUseTranscribeButtonProgress())), AndroidUtilities.dp(30.0f));
            }
        }
        SeekBar seekBar2 = this.seekBar;
        if (seekBar2 != null) {
            seekBar2.setSize((this.backgroundWidth - ((int) (getUseTranscribeButtonProgress() * AndroidUtilities.dp(34.0f)))) - AndroidUtilities.dp((this.documentAttachType != 5 ? 72 : 65) + (this.hasLinkPreview ? 10 : 0)), AndroidUtilities.dp(30.0f));
        }
    }

    private int createDocumentLayout(int i, MessageObject messageObject) {
        int iMin;
        int i2;
        int iDp = i;
        if (messageObject.type == 0) {
            this.documentAttach = MessageObject.getMedia(messageObject.messageOwner).webpage.document;
        } else {
            this.documentAttach = messageObject.getDocument();
        }
        TLRPC$Document tLRPC$Document = this.documentAttach;
        int i3 = 0;
        if (tLRPC$Document == null) {
            return 0;
        }
        if (MessageObject.isVoiceDocument(tLRPC$Document)) {
            this.documentAttachType = 3;
            int i4 = 0;
            while (true) {
                if (i4 >= this.documentAttach.attributes.size()) {
                    i2 = 0;
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.documentAttach.attributes.get(i4);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                    i2 = tLRPC$DocumentAttribute.duration;
                    break;
                }
                i4++;
            }
            this.widthBeforeNewTimeLine = (iDp - AndroidUtilities.dp(94.0f)) - ((int) Math.ceil(Theme.chat_audioTimePaint.measureText("00:00")));
            this.availableTimeWidth = iDp - AndroidUtilities.dp(18.0f);
            measureTime(messageObject);
            int iDp2 = AndroidUtilities.dp(174.0f) + this.timeWidth;
            if (!this.hasLinkPreview) {
                this.backgroundWidth = Math.min(iDp, iDp2 + ((int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatLongDuration(i2)))));
            }
            this.seekBarWaveform.setMessageObject(messageObject);
            return 0;
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
        if (MessageObject.isMusicDocument(this.documentAttach)) {
            this.documentAttachType = 5;
            int iDp3 = iDp - AndroidUtilities.dp(92.0f);
            if (iDp3 < 0) {
                iDp3 = AndroidUtilities.dp(100.0f);
            }
            int i5 = iDp3;
            StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicTitle().replace('\n', ' '), Theme.chat_audioTitlePaint, i5 - AndroidUtilities.dp(12.0f), TextUtils.TruncateAt.END), Theme.chat_audioTitlePaint, i5, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.songLayout = staticLayout;
            if (staticLayout.getLineCount() > 0) {
                this.songX = -((int) Math.ceil(this.songLayout.getLineLeft(0)));
            }
            StaticLayout staticLayout2 = new StaticLayout(TextUtils.ellipsize(messageObject.getMusicAuthor().replace('\n', ' '), Theme.chat_audioPerformerPaint, i5, TextUtils.TruncateAt.END), Theme.chat_audioPerformerPaint, i5, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.performerLayout = staticLayout2;
            if (staticLayout2.getLineCount() > 0) {
                this.performerX = -((int) Math.ceil(this.performerLayout.getLineLeft(0)));
            }
            int i6 = 0;
            while (true) {
                if (i6 >= this.documentAttach.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.documentAttach.attributes.get(i6);
                if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                    i3 = tLRPC$DocumentAttribute2.duration;
                    break;
                }
                i6++;
            }
            int iCeil = (int) Math.ceil(Theme.chat_audioTimePaint.measureText(AndroidUtilities.formatShortDuration(i3, i3)));
            this.widthBeforeNewTimeLine = (this.backgroundWidth - AndroidUtilities.dp(86.0f)) - iCeil;
            this.availableTimeWidth = this.backgroundWidth - AndroidUtilities.dp(28.0f);
            return iCeil;
        }
        if (MessageObject.isGifDocument(this.documentAttach, messageObject.hasValidGroupId())) {
            this.documentAttachType = 2;
            if (!messageObject.needDrawBluredPreview()) {
                String string = LocaleController.getString("AttachGif", ir.medu.shad.R.string.AttachGif);
                this.infoWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(string));
                this.infoLayout = new StaticLayout(string, Theme.chat_infoPaint, this.infoWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                String str2 = String.format("%s", AndroidUtilities.formatFileSize(this.documentAttach.size));
                this.docTitleWidth = (int) Math.ceil(Theme.chat_infoPaint.measureText(str2));
                this.docTitleLayout = new StaticLayout(str2, Theme.chat_infoPaint, this.docTitleWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return 0;
        }
        String str3 = this.documentAttach.mime_type;
        boolean z = (str3 != null && (str3.toLowerCase().startsWith("image/") || (this.documentAttach.mime_type.toLowerCase().startsWith("video/mp4") && !MessageObject.isVideoFileDocument(this.documentAttach)))) || MessageObject.isDocumentHasThumb(this.documentAttach);
        this.drawPhotoImage = z;
        if (!z) {
            iDp += AndroidUtilities.dp(30.0f);
        }
        this.documentAttachType = 1;
        String documentFileName = FileLoader.getDocumentFileName(this.documentAttach);
        if (documentFileName.length() == 0) {
            documentFileName = LocaleController.getString("AttachDocument", ir.medu.shad.R.string.AttachDocument);
        }
        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(documentFileName, Theme.chat_docNamePaint, iDp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false, TextUtils.TruncateAt.MIDDLE, iDp, 2, false);
        this.docTitleLayout = staticLayoutCreateStaticLayout;
        this.docTitleOffsetX = Integer.MIN_VALUE;
        if (staticLayoutCreateStaticLayout != null && staticLayoutCreateStaticLayout.getLineCount() > 0) {
            int iMax = 0;
            while (i3 < this.docTitleLayout.getLineCount()) {
                iMax = Math.max(iMax, (int) Math.ceil(this.docTitleLayout.getLineWidth(i3)));
                this.docTitleOffsetX = Math.max(this.docTitleOffsetX, (int) Math.ceil(-this.docTitleLayout.getLineLeft(i3)));
                i3++;
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
            } else {
                BitmapDrawable bitmapDrawable = this.currentMessageObject.strippedThumb;
                if (bitmapDrawable != null) {
                    this.currentPhotoObjectThumb = null;
                    this.currentPhotoObjectThumbStripped = bitmapDrawable;
                }
            }
            this.currentPhotoFilter = "86_86_b";
            this.photoImage.setImage(ImageLocation.getForObject(this.currentPhotoObject, messageObject.photoThumbsObject), "86_86", ImageLocation.getForObject(this.currentPhotoObjectThumb, messageObject.photoThumbsObject), this.currentPhotoFilter, this.currentPhotoObjectThumbStripped, 0L, null, messageObject, 1);
        }
        return iMin;
    }

    private void calcBackgroundWidth(int i, int i2, int i3) {
        ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
        boolean z = reactionsLayoutInBubble.isEmpty;
        int i4 = (z || reactionsLayoutInBubble.isSmall) ? this.currentMessageObject.lastLineWidth : reactionsLayoutInBubble.lastLineX;
        if (!z && !reactionsLayoutInBubble.isSmall) {
            z = i - i4 < i2 || this.currentMessageObject.hasRtl;
            if (this.hasInvoicePreview) {
                this.totalHeight += AndroidUtilities.dp(14.0f);
            }
        } else if (this.hasLinkPreview || this.hasOldCaptionPreview || this.hasGamePreview || this.hasInvoicePreview || i - i4 < i2 || this.currentMessageObject.hasRtl) {
            z = true;
        }
        if (z) {
            this.totalHeight += AndroidUtilities.dp(14.0f);
            this.hasNewLineForTime = true;
            int iMax = Math.max(i3, i4) + AndroidUtilities.dp(31.0f);
            this.backgroundWidth = iMax;
            this.backgroundWidth = Math.max(iMax, (this.currentMessageObject.isOutOwner() ? this.timeWidth + AndroidUtilities.dp(17.0f) : this.timeWidth) + AndroidUtilities.dp(31.0f));
            return;
        }
        int extraTextX = (i3 - getExtraTextX()) - i4;
        if (extraTextX >= 0 && extraTextX <= i2) {
            this.backgroundWidth = ((i3 + i2) - extraTextX) + AndroidUtilities.dp(31.0f);
        } else {
            this.backgroundWidth = Math.max(i3, i4 + i2) + AndroidUtilities.dp(31.0f);
        }
    }

    public void setHighlightedText(String str) {
        MessageObject messageObject = this.messageObjectToSet;
        if (messageObject == null) {
            messageObject = this.currentMessageObject;
        }
        if (messageObject == null || messageObject.messageOwner.message == null || TextUtils.isEmpty(str)) {
            if (this.urlPathSelection.isEmpty()) {
                return;
            }
            this.linkSelectionBlockNum = -1;
            resetUrlPaths();
            invalidate();
            return;
        }
        String lowerCase = str.toLowerCase();
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
            resetUrlPaths();
            invalidate();
            return;
        }
        int length2 = lowerCase2.length();
        for (int i6 = i + i2; i6 < length2 && " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\n".indexOf(lowerCase2.charAt(i6)) < 0; i6++) {
            i2++;
        }
        int i7 = i + i2;
        if (this.captionLayout != null && !TextUtils.isEmpty(messageObject.caption)) {
            resetUrlPaths();
            try {
                LinkPath linkPathObtainNewUrlPath = obtainNewUrlPath();
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
                    resetUrlPaths();
                    try {
                        LinkPath linkPathObtainNewUrlPath2 = obtainNewUrlPath();
                        linkPathObtainNewUrlPath2.setCurrentLayout(textLayoutBlock.textLayout, i, 0.0f);
                        textLayoutBlock.textLayout.getSelectionPath(i, i7, linkPathObtainNewUrlPath2);
                        if (i7 >= textLayoutBlock.charactersOffset + i2) {
                            for (int i9 = i8 + 1; i9 < messageObject.textLayoutBlocks.size(); i9++) {
                                MessageObject.TextLayoutBlock textLayoutBlock2 = messageObject.textLayoutBlocks.get(i9);
                                int i10 = textLayoutBlock2.charactersEnd - textLayoutBlock2.charactersOffset;
                                LinkPath linkPathObtainNewUrlPath3 = obtainNewUrlPath();
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
    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            Drawable[] drawableArr = this.selectorDrawable;
            if (drawable != drawableArr[0] && drawable != drawableArr[1]) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        if (this.currentMessagesGroup != null) {
            invalidateWithParent();
        }
    }

    private boolean isCurrentLocationTimeExpired(MessageObject messageObject) {
        return MessageObject.getMedia(this.currentMessageObject.messageOwner).period % 60 == 0 ? Math.abs(ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - messageObject.messageOwner.date) > MessageObject.getMedia(messageObject.messageOwner).period : Math.abs(ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - messageObject.messageOwner.date) > MessageObject.getMedia(messageObject.messageOwner).period + (-5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkLocationExpired() throws SAXException, IOException {
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
            this.docTitleLayout = new StaticLayout(TextUtils.ellipsize(LocaleController.getString("AttachLiveLocation", ir.medu.shad.R.string.AttachLiveLocation), Theme.chat_locationTitlePaint, iDp, TextUtils.TruncateAt.END), Theme.chat_locationTitlePaint, iDp, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            return;
        }
        MessageObject messageObject2 = this.currentMessageObject;
        this.currentMessageObject = null;
        setMessageObject(messageObject2, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
    }

    public void setIsUpdating(boolean z) {
        this.isUpdating = true;
    }

    public void setMessageObject(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages, boolean z, boolean z2) throws SAXException, IOException {
        if (this.attachedToWindow) {
            setMessageContent(messageObject, groupedMessages, z, z2);
            return;
        }
        this.messageObjectToSet = messageObject;
        this.groupedMessagesToSet = groupedMessages;
        this.bottomNearToSet = z;
        this.topNearToSet = z2;
    }

    private int getAdditionalWidthForPosition(MessageObject.GroupedMessagePosition groupedMessagePosition) {
        if (groupedMessagePosition == null) {
            return 0;
        }
        int iDp = (groupedMessagePosition.flags & 2) == 0 ? 0 + AndroidUtilities.dp(4.0f) : 0;
        return (groupedMessagePosition.flags & 1) == 0 ? iDp + AndroidUtilities.dp(4.0f) : iDp;
    }

    public void createSelectorDrawable(final int i) {
        int themedColor;
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (this.psaHintPressed) {
            themedColor = getThemedColor(this.currentMessageObject.isOutOwner() ? Theme.key_chat_outViews : Theme.key_chat_inViews);
        } else {
            themedColor = getThemedColor(this.currentMessageObject.isOutOwner() ? Theme.key_chat_outPreviewInstantText : Theme.key_chat_inPreviewInstantText);
        }
        Drawable[] drawableArr = this.selectorDrawable;
        if (drawableArr[i] == null) {
            final Paint paint = new Paint(1);
            paint.setColor(-1);
            Drawable drawable = new Drawable() { // from class: org.rbmain.ui.Cells.ChatMessageCell.6
                RectF rect = new RectF();
                Path path = new Path();

                @Override // android.graphics.drawable.Drawable
                public int getOpacity() {
                    return -2;
                }

                @Override // android.graphics.drawable.Drawable
                public void setAlpha(int i2) {
                }

                @Override // android.graphics.drawable.Drawable
                public void setColorFilter(ColorFilter colorFilter) {
                }

                /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x01bf  */
                @Override // android.graphics.drawable.Drawable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void draw(android.graphics.Canvas r15) {
                    /*
                        Method dump skipped, instructions count: 557
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.AnonymousClass6.draw(android.graphics.Canvas):void");
                }
            };
            int[][] iArr = {StateSet.WILD_CARD};
            int[] iArr2 = new int[1];
            iArr2[0] = 436207615 & getThemedColor(this.currentMessageObject.isOutOwner() ? Theme.key_chat_outPreviewInstantText : Theme.key_chat_inPreviewInstantText);
            this.selectorDrawable[i] = new RippleDrawable(new ColorStateList(iArr, iArr2), null, drawable);
            this.selectorDrawable[i].setCallback(this);
        } else {
            Theme.setSelectorDrawableColor(drawableArr[i], themedColor & 436207615, true);
        }
        this.selectorDrawable[i].setVisible(true, false);
    }

    private void createWalletTransactionUI() {
        if (this.transactionAvatarImages != null) {
            return;
        }
        this.transactionAvatarImages = new ImageReceiver[2];
        this.transactionAvatarDrawables = new AvatarDrawable[2];
        int i = 0;
        while (true) {
            ImageReceiver[] imageReceiverArr = this.transactionAvatarImages;
            if (i >= imageReceiverArr.length) {
                return;
            }
            imageReceiverArr[i] = new ImageReceiver(this);
            this.transactionAvatarImages[i].setRoundRadius(AndroidUtilities.dp(16.0f));
            this.transactionAvatarImages[i].setImageCoords(0.0f, 0.0f, AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
            this.transactionAvatarDrawables[i] = new AvatarDrawable();
            this.transactionAvatarDrawables[i].setTextSize(AndroidUtilities.dp(6.0f));
            i++;
        }
    }

    private void createInstantViewButton() {
        String string;
        int iMeasureText;
        if (Build.VERSION.SDK_INT >= 21 && this.drawInstantView) {
            createSelectorDrawable(0);
        }
        if (this.drawInstantView && this.instantViewLayout == null) {
            this.instantWidth = AndroidUtilities.dp(33.0f);
            int i = this.drawInstantViewType;
            if (i == 12) {
                string = LocaleController.getString("OpenChannelPost", ir.medu.shad.R.string.OpenChannelPost);
            } else if (i == 1) {
                string = LocaleController.getString("OpenChannel", ir.medu.shad.R.string.OpenChannel);
            } else if (i == 13) {
                string = LocaleController.getString("SendMessage", ir.medu.shad.R.string.SendMessage).toUpperCase();
            } else if (i == 10) {
                string = LocaleController.getString("OpenBot", ir.medu.shad.R.string.OpenBot);
            } else if (i == 2) {
                string = LocaleController.getString("OpenGroup", ir.medu.shad.R.string.OpenGroup);
            } else if (i == 3) {
                string = LocaleController.getString("OpenMessage", ir.medu.shad.R.string.OpenMessage);
            } else if (i == 5) {
                string = LocaleController.getString("ViewContact", ir.medu.shad.R.string.ViewContact);
            } else if (i == 6) {
                string = LocaleController.getString("OpenBackground", ir.medu.shad.R.string.OpenBackground);
            } else if (i == 7) {
                string = LocaleController.getString("OpenTheme", ir.medu.shad.R.string.OpenTheme);
            } else if (i == 8) {
                if (this.pollVoted || this.pollClosed) {
                    string = LocaleController.getString("PollViewResults", ir.medu.shad.R.string.PollViewResults);
                } else {
                    string = LocaleController.getString("PollSubmitVotes", ir.medu.shad.R.string.PollSubmitVotes);
                }
            } else if (i == 9 || i == 11) {
                TLRPC$TL_webPage tLRPC$TL_webPage = (TLRPC$TL_webPage) MessageObject.getMedia(this.currentMessageObject.messageOwner).webpage;
                if (tLRPC$TL_webPage != null && tLRPC$TL_webPage.url.contains("voicechat=")) {
                    string = LocaleController.getString("VoipGroupJoinAsSpeaker", ir.medu.shad.R.string.VoipGroupJoinAsSpeaker);
                } else {
                    string = LocaleController.getString("VoipGroupJoinAsLinstener", ir.medu.shad.R.string.VoipGroupJoinAsLinstener);
                }
            } else if (i == 14) {
                string = LocaleController.getString("ViewChatList", ir.medu.shad.R.string.ViewChatList).toUpperCase();
            } else if (i == 15) {
                string = LocaleController.getString(ir.medu.shad.R.string.BotWebAppInstantViewOpen).toUpperCase();
            } else {
                string = LocaleController.getString("InstantView", ir.medu.shad.R.string.InstantView);
            }
            if (this.currentMessageObject.isSponsored() && this.backgroundWidth < (iMeasureText = (int) (Theme.chat_instantViewPaint.measureText(string) + AndroidUtilities.dp(75.0f)))) {
                this.backgroundWidth = iMeasureText;
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
            if (this.currentMessageObject.isSponsored() && this.hasNewLineForTime) {
                this.totalHeight += AndroidUtilities.dp(16.0f);
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
    protected void onMeasure(int i, int i2) throws SAXException, IOException {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && (messageObject.checkLayout() || this.lastHeight != AndroidUtilities.displaySize.y)) {
            this.inLayout = true;
            MessageObject messageObject2 = this.currentMessageObject;
            this.currentMessageObject = null;
            setMessageObject(messageObject2, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
            this.inLayout = false;
        }
        updateSelectionTextPosition();
        setMeasuredDimension(View.MeasureSpec.getSize(i), this.totalHeight + this.keyboardHeight);
    }

    public void forceResetMessageObject() throws SAXException, IOException {
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
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int iDp;
        int iDp2;
        int iDp3;
        int i7;
        int iDp4;
        int i8;
        int iDp5;
        int iDp6;
        int iDp7;
        int iDp8;
        int iDp9;
        int i9;
        int iDp10;
        int iDp11;
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
                    if (groupedMessagePosition != null && (i5 = groupedMessagePosition.leftSpanOffset) != 0) {
                        this.timeX += (int) Math.ceil((i5 / 1000.0f) * getGroupPhotosWidth());
                    }
                    if (this.captionLayout != null && this.currentPosition != null) {
                        this.timeX += AndroidUtilities.dp(4.0f);
                    }
                }
                if (SharedConfig.bubbleRadius >= 10 && this.captionLayout == null && (i6 = this.documentAttachType) != 7 && i6 != 6) {
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
            if ((this.currentMessageObject.messageOwner.flags & 1024) != 0) {
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
            if (this.currentMessageObject.type == 20 && this.currentUnlockString != null) {
                this.unlockLayout = new StaticLayout(this.currentUnlockString, Theme.chat_unlockExtendedMediaTextPaint, this.unlockTextWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
                this.videoInfoLayout = null;
            } else {
                this.unlockLayout = null;
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
        int i10 = this.documentAttachType;
        if (i10 == 3 || i10 == 7) {
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
            updateSeekBarWaveformWidth(null);
            this.seekBarY = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            int iDp12 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp12;
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i11 = this.buttonX;
            radialProgress2.setProgressRect(i11, iDp12, AndroidUtilities.dp(44.0f) + i11, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            if (this.documentAttachType == 7) {
                MessageObject messageObject = this.currentMessageObject;
                if (messageObject.type == 0 && (this.hasLinkPreview || this.hasGamePreview || this.hasInvoicePreview)) {
                    if (this.hasGamePreview) {
                        iDp2 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
                    } else {
                        if (this.hasInvoicePreview) {
                            i8 = this.unmovedTextX;
                            iDp5 = AndroidUtilities.dp(1.0f);
                        } else {
                            i8 = this.unmovedTextX;
                            iDp5 = AndroidUtilities.dp(1.0f);
                        }
                        iDp2 = i8 + iDp5;
                    }
                    if (this.isSmallImage) {
                        i7 = iDp2 + this.backgroundWidth;
                        iDp4 = AndroidUtilities.dp(81.0f);
                        iDp = i7 - iDp4;
                    } else {
                        iDp3 = this.hasInvoicePreview ? -AndroidUtilities.dp(6.3f) : AndroidUtilities.dp(10.0f);
                        iDp = iDp2 + iDp3;
                    }
                } else if (messageObject.isOutOwner()) {
                    if (this.mediaBackground) {
                        i7 = this.layoutWidth - this.backgroundWidth;
                        iDp4 = AndroidUtilities.dp(3.0f);
                        iDp = i7 - iDp4;
                    } else {
                        iDp2 = this.layoutWidth - this.backgroundWidth;
                        iDp3 = AndroidUtilities.dp(6.0f);
                        iDp = iDp2 + iDp3;
                    }
                } else {
                    if (this.isChat && this.isAvatarVisible && (!this.isPlayingRound || this.currentMessageObject.isVoiceTranscriptionOpen())) {
                        iDp = AndroidUtilities.dp(63.0f);
                    } else {
                        iDp = AndroidUtilities.dp(15.0f);
                    }
                    MessageObject.GroupedMessagePosition groupedMessagePosition2 = this.currentPosition;
                    if (groupedMessagePosition2 != null && !groupedMessagePosition2.edge) {
                        iDp -= AndroidUtilities.dp(10.0f);
                    }
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
                if (this.currentMessageObject.isVoiceTranscriptionOpen()) {
                    iDp += AndroidUtilities.dp(10.0f);
                }
                TransitionParams transitionParams = this.transitionParams;
                if (!transitionParams.imageChangeBoundsTransition || transitionParams.updatePhotoImageX) {
                    transitionParams.updatePhotoImageX = false;
                    ImageReceiver imageReceiver = this.photoImage;
                    imageReceiver.setImageCoords(iDp, imageReceiver.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
                    return;
                }
                return;
            }
            return;
        }
        if (i10 == 5) {
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
            updateSeekBarWaveformWidth(null);
            this.seekBarY = AndroidUtilities.dp(29.0f) + this.namesOffset + this.mediaOffsetY;
            int iDp13 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp13;
            RadialProgress2 radialProgress22 = this.radialProgress;
            int i12 = this.buttonX;
            radialProgress22.setProgressRect(i12, iDp13, AndroidUtilities.dp(44.0f) + i12, this.buttonY + AndroidUtilities.dp(44.0f));
            updatePlayingMessageProgress();
            return;
        }
        if (i10 == 1 && !this.drawPhotoImage) {
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
            int iDp14 = AndroidUtilities.dp(13.0f) + this.namesOffset + this.mediaOffsetY;
            this.buttonY = iDp14;
            RadialProgress2 radialProgress23 = this.radialProgress;
            int i13 = this.buttonX;
            radialProgress23.setProgressRect(i13, iDp14, AndroidUtilities.dp(44.0f) + i13, this.buttonY + AndroidUtilities.dp(44.0f));
            this.photoImage.setImageCoords(this.buttonX - AndroidUtilities.dp(10.0f), this.buttonY - AndroidUtilities.dp(10.0f), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
            return;
        }
        MessageObject messageObject2 = this.currentMessageObject;
        int i14 = messageObject2.type;
        if (i14 == 12) {
            if (messageObject2.isOutOwner()) {
                iDp11 = (this.layoutWidth - this.backgroundWidth) + AndroidUtilities.dp(14.0f);
            } else if (this.isChat && !this.isThreadPost && this.currentMessageObject.needDrawAvatar()) {
                iDp11 = AndroidUtilities.dp(72.0f);
            } else {
                iDp11 = AndroidUtilities.dp(23.0f);
            }
            this.photoImage.setImageCoords(iDp11, AndroidUtilities.dp(13.0f) + this.namesOffset, AndroidUtilities.dp(44.0f), AndroidUtilities.dp(44.0f));
            return;
        }
        if (i14 == 0 && (this.hasLinkPreview || this.hasGamePreview || this.hasInvoicePreview)) {
            if (this.hasGamePreview) {
                iDp8 = this.unmovedTextX - AndroidUtilities.dp(10.0f);
            } else {
                if (this.hasInvoicePreview) {
                    i9 = this.unmovedTextX;
                    iDp10 = AndroidUtilities.dp(1.0f);
                } else {
                    i9 = this.unmovedTextX;
                    iDp10 = AndroidUtilities.dp(1.0f);
                }
                iDp8 = i9 + iDp10;
            }
            if (this.isSmallImage) {
                iDp6 = iDp8 + this.backgroundWidth;
                iDp7 = AndroidUtilities.dp(81.0f);
                iDp6 -= iDp7;
            } else {
                iDp9 = this.hasInvoicePreview ? -AndroidUtilities.dp(6.3f) : AndroidUtilities.dp(10.0f);
                iDp6 = iDp8 + iDp9;
            }
        } else {
            if (messageObject2.isOutOwner()) {
                if (this.mediaBackground) {
                    iDp6 = this.layoutWidth - this.backgroundWidth;
                    iDp7 = AndroidUtilities.dp(3.0f);
                } else {
                    iDp8 = this.layoutWidth - this.backgroundWidth;
                    iDp9 = AndroidUtilities.dp(6.0f);
                    iDp6 = iDp8 + iDp9;
                }
            } else {
                if (this.isChat && this.isAvatarVisible && !this.isPlayingRound) {
                    iDp6 = AndroidUtilities.dp(63.0f);
                } else {
                    iDp6 = AndroidUtilities.dp(15.0f);
                }
                MessageObject.GroupedMessagePosition groupedMessagePosition4 = this.currentPosition;
                if (groupedMessagePosition4 != null && !groupedMessagePosition4.edge) {
                    iDp7 = AndroidUtilities.dp(10.0f);
                }
            }
            iDp6 -= iDp7;
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition5 = this.currentPosition;
        if (groupedMessagePosition5 != null) {
            if ((groupedMessagePosition5.flags & 1) == 0) {
                iDp6 -= AndroidUtilities.dp(2.0f);
            }
            if (this.currentPosition.leftSpanOffset != 0) {
                iDp6 += (int) Math.ceil((r2 / 1000.0f) * getGroupPhotosWidth());
            }
        }
        if (this.currentMessageObject.type != 0) {
            iDp6 -= AndroidUtilities.dp(2.0f);
        }
        TransitionParams transitionParams2 = this.transitionParams;
        if (!transitionParams2.imageChangeBoundsTransition || transitionParams2.updatePhotoImageX) {
            transitionParams2.updatePhotoImageX = false;
            ImageReceiver imageReceiver2 = this.photoImage;
            imageReceiver2.setImageCoords(iDp6, imageReceiver2.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
        }
        this.buttonX = (int) (iDp6 + ((this.photoImage.getImageWidth() - AndroidUtilities.dp(48.0f)) / 2.0f));
        int imageY = (int) (this.photoImage.getImageY() + ((this.photoImage.getImageHeight() - AndroidUtilities.dp(48.0f)) / 2.0f));
        this.buttonY = imageY;
        RadialProgress2 radialProgress24 = this.radialProgress;
        int i15 = this.buttonX;
        radialProgress24.setProgressRect(i15, imageY, AndroidUtilities.dp(48.0f) + i15, this.buttonY + AndroidUtilities.dp(48.0f));
        this.deleteProgressRect.set(this.buttonX + AndroidUtilities.dp(5.0f), this.buttonY + AndroidUtilities.dp(5.0f), this.buttonX + AndroidUtilities.dp(43.0f), this.buttonY + AndroidUtilities.dp(43.0f));
        int i16 = this.documentAttachType;
        if (i16 == 4 || i16 == 2) {
            this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
            int imageY2 = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
            this.videoButtonY = imageY2;
            RadialProgress2 radialProgress25 = this.videoRadialProgress;
            int i17 = this.videoButtonX;
            radialProgress25.setProgressRect(i17, imageY2, AndroidUtilities.dp(24.0f) + i17, this.videoButtonY + AndroidUtilities.dp(24.0f));
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
            Method dump skipped, instructions count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawRoundProgress(android.graphics.Canvas):void");
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.updatePollAnimations(long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:427:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:720:0x116e  */
    /* JADX WARN: Removed duplicated region for block: B:721:0x1171  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x118b  */
    /* JADX WARN: Removed duplicated region for block: B:725:0x118e  */
    /* JADX WARN: Removed duplicated region for block: B:728:0x11b2  */
    /* JADX WARN: Removed duplicated region for block: B:729:0x11ba  */
    /* JADX WARN: Removed duplicated region for block: B:732:0x11c1  */
    /* JADX WARN: Removed duplicated region for block: B:733:0x11ea  */
    /* JADX WARN: Removed duplicated region for block: B:736:0x11ff  */
    /* JADX WARN: Removed duplicated region for block: B:748:0x1256  */
    /* JADX WARN: Removed duplicated region for block: B:751:0x125f  */
    /* JADX WARN: Removed duplicated region for block: B:752:0x126b  */
    /* JADX WARN: Removed duplicated region for block: B:755:0x127a  */
    /* JADX WARN: Removed duplicated region for block: B:759:0x12be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawContent(android.graphics.Canvas r36) {
        /*
            Method dump skipped, instructions count: 6724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawContent(android.graphics.Canvas):void");
    }

    private void startRevealMedia(float f, float f2) throws SAXException, IOException {
        float fSqrt = (float) Math.sqrt(Math.pow(this.photoImage.getImageWidth(), 2.0d) + Math.pow(this.photoImage.getImageHeight(), 2.0d));
        this.mediaSpoilerRevealMaxRadius = fSqrt;
        startRevealMedia(f, f2, fSqrt);
    }

    private void startRevealMedia(float f, float f2, float f3) throws SAXException, IOException {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject.isMediaSpoilersRevealed || this.mediaSpoilerRevealProgress != 0.0f) {
            return;
        }
        if (messageObject.type == 3) {
            messageObject.forceUpdate = true;
            messageObject.revealingMediaSpoilers = true;
            setMessageContent(messageObject, this.currentMessagesGroup, this.pinnedBottom, this.pinnedTop);
            MessageObject messageObject2 = this.currentMessageObject;
            messageObject2.revealingMediaSpoilers = false;
            messageObject2.forceUpdate = false;
            if (this.currentMessagesGroup != null) {
                this.radialProgress.setProgress(0.0f, false);
            }
        }
        this.mediaSpoilerRevealX = f;
        this.mediaSpoilerRevealY = f2;
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration((long) MathUtils.clamp(this.mediaSpoilerRevealMaxRadius * 0.3f, 250.0f, 550.0f));
        duration.setInterpolator(CubicBezierInterpolator.EASE_BOTH);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$startRevealMedia$12(valueAnimator);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.ChatMessageCell.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ChatMessageCell.this.currentMessageObject.isMediaSpoilersRevealed = true;
                ChatMessageCell.this.invalidate();
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRevealMedia$12(ValueAnimator valueAnimator) {
        this.mediaSpoilerRevealProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void drawBlurredPhoto(Canvas canvas) {
        if (this.currentMessageObject.isMediaSpoilersRevealed || this.mediaSpoilerRevealProgress == 1.0f) {
            return;
        }
        int[] roundRadius = this.photoImage.getRoundRadius();
        float[] fArr = this.mediaSpoilerRadii;
        float f = roundRadius[0];
        fArr[1] = f;
        fArr[0] = f;
        float f2 = roundRadius[1];
        fArr[3] = f2;
        fArr[2] = f2;
        float f3 = roundRadius[2];
        fArr[5] = f3;
        fArr[4] = f3;
        float f4 = roundRadius[3];
        fArr[7] = f4;
        fArr[6] = f4;
        this.mediaSpoilerPath.rewind();
        RectF rectF = AndroidUtilities.rectTmp;
        rectF.set(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageX2(), this.photoImage.getImageY2());
        this.mediaSpoilerPath.addRoundRect(rectF, this.mediaSpoilerRadii, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.mediaSpoilerPath);
        if (this.mediaSpoilerRevealProgress != 0.0f) {
            this.mediaSpoilerPath.rewind();
            this.mediaSpoilerPath.addCircle(this.mediaSpoilerRevealX, this.mediaSpoilerRevealY, this.mediaSpoilerRevealMaxRadius * this.mediaSpoilerRevealProgress, Path.Direction.CW);
            canvas.clipPath(this.mediaSpoilerPath, Region.Op.DIFFERENCE);
        }
        this.blurredPhotoImage.setImageCoords(this.photoImage.getImageX(), this.photoImage.getImageY(), this.photoImage.getImageWidth(), this.photoImage.getImageHeight());
        this.blurredPhotoImage.setRoundRadius(this.photoImage.getRoundRadius());
        this.blurredPhotoImage.draw(canvas);
        this.mediaSpoilerEffect.setColor(ColorUtils.setAlphaComponent(-1, (int) (Color.alpha(-1) * 0.325f * this.photoImage.getAlpha())));
        this.mediaSpoilerEffect.setBounds((int) this.photoImage.getImageX(), (int) this.photoImage.getImageY(), (int) this.photoImage.getImageX2(), (int) this.photoImage.getImageY2());
        this.mediaSpoilerEffect.draw(canvas);
        canvas.restore();
        invalidate();
    }

    private float getUseTranscribeButtonProgress() {
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.animateUseTranscribeButton) {
            return this.useTranscribeButton ? 1.0f : 0.0f;
        }
        if (this.useTranscribeButton) {
            return transitionParams.animateChangeProgress;
        }
        return 1.0f - transitionParams.animateChangeProgress;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateReactionLayoutPosition() {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.updateReactionLayoutPosition():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:308:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0af0  */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawLinkPreview(android.graphics.Canvas r36, float r37) {
        /*
            Method dump skipped, instructions count: 3005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawLinkPreview(android.graphics.Canvas, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldDrawMenuDrawable() {
        return this.currentMessagesGroup == null || (this.currentPosition.flags & 4) != 0;
    }

    private void drawBotButtons(Canvas canvas, ArrayList<BotButton> arrayList, int i) {
        int iDp;
        Drawable themedDrawable;
        ChatMessageCellDelegate chatMessageCellDelegate;
        float f = 1.0f;
        if (this.currentMessageObject.isOutOwner()) {
            iDp = (getMeasuredWidth() - this.widthForButtons) - AndroidUtilities.dp(10.0f);
        } else {
            iDp = this.backgroundDrawableLeft + AndroidUtilities.dp((this.mediaBackground || this.drawPinnedBottom) ? 1.0f : 7.0f);
        }
        float f2 = 2.0f;
        float fDp = (this.layoutHeight - AndroidUtilities.dp(2.0f)) + this.transitionParams.deltaBottom;
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            BotButton botButton = arrayList.get(i2);
            float f4 = botButton.y + botButton.height;
            if (f4 > f3) {
                f3 = f4;
            }
        }
        this.rect.set(0.0f, fDp, getMeasuredWidth(), f3 + fDp);
        if (i != 255) {
            canvas.saveLayerAlpha(this.rect, i, 31);
        } else {
            canvas.save();
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            BotButton botButton2 = arrayList.get(i3);
            float fDp2 = ((botButton2.y + this.layoutHeight) - AndroidUtilities.dp(f2)) + this.transitionParams.deltaBottom;
            float pressScale = botButton2.getPressScale();
            this.rect.set(botButton2.x + iDp, fDp2, botButton2.x + iDp + botButton2.width, botButton2.height + fDp2);
            canvas.save();
            if (pressScale != f) {
                canvas.scale(pressScale, pressScale, this.rect.centerX(), this.rect.centerY());
            }
            applyServiceShaderMatrix();
            Arrays.fill(this.botButtonRadii, AndroidUtilities.dp(Math.min(6.75f, SharedConfig.bubbleRadius)));
            if (botButton2.hasPositionFlag(9)) {
                float[] fArr = this.botButtonRadii;
                float fDp3 = AndroidUtilities.dp(SharedConfig.bubbleRadius);
                fArr[7] = fDp3;
                fArr[6] = fDp3;
            }
            if (botButton2.hasPositionFlag(10)) {
                float[] fArr2 = this.botButtonRadii;
                float fDp4 = AndroidUtilities.dp(SharedConfig.bubbleRadius);
                fArr2[5] = fDp4;
                fArr2[4] = fDp4;
            }
            this.botButtonPath.rewind();
            this.botButtonPath.addRoundRect(this.rect, this.botButtonRadii, Path.Direction.CW);
            canvas.drawPath(this.botButtonPath, getThemedPaint("paintChatActionBackground"));
            if (hasGradientService()) {
                canvas.drawPath(this.botButtonPath, Theme.chat_actionBackgroundGradientDarkenPaint);
            }
            boolean z = (((botButton2.button instanceof TLRPC$TL_keyboardButtonCallback) || (botButton2.button instanceof TLRPC$TL_keyboardButtonGame) || (botButton2.button instanceof TLRPC$TL_keyboardButtonBuy) || (botButton2.button instanceof TLRPC$TL_keyboardButtonUrlAuth)) && SendMessagesHelper.getInstance(this.currentAccount).isSendingCallback(this.currentMessageObject, botButton2.button)) || ((botButton2.button instanceof TLRPC$TL_keyboardButtonRequestGeoLocation) && SendMessagesHelper.getInstance(this.currentAccount).isSendingCurrentLocation(this.currentMessageObject, botButton2.button)) || ((botButton2.button instanceof TLRPC$TL_keyboardButtonUrl) && (chatMessageCellDelegate = this.delegate) != null && chatMessageCellDelegate.isProgressLoading(this, 3) && this.delegate.getProgressLoadingBotButtonUrl(this) == botButton2.button.url);
            canvas.save();
            canvas.clipPath(this.botButtonPath);
            if (z) {
                if (botButton2.loadingDrawable == null) {
                    botButton2.loadingDrawable = new LoadingDrawable();
                    botButton2.loadingDrawable.setRadiiDp(5.5f);
                    botButton2.loadingDrawable.setAppearByGradient(true);
                    botButton2.loadingDrawable.strokePaint.setStrokeWidth(AndroidUtilities.dpf2(1.25f));
                } else if (botButton2.loadingDrawable.isDisappeared() || botButton2.loadingDrawable.isDisappearing()) {
                    botButton2.loadingDrawable.reset();
                    botButton2.loadingDrawable.resetDisappear();
                }
            } else if (botButton2.loadingDrawable != null && !botButton2.loadingDrawable.isDisappearing() && !botButton2.loadingDrawable.isDisappeared()) {
                botButton2.loadingDrawable.disappear();
            }
            if (botButton2.loadingDrawable != null && (z || botButton2.loadingDrawable.isDisappearing())) {
                this.rect.inset(AndroidUtilities.dpf2(0.625f), AndroidUtilities.dpf2(0.625f));
                botButton2.loadingDrawable.setRadii(this.botButtonRadii);
                botButton2.loadingDrawable.setBounds(this.rect);
                LoadingDrawable loadingDrawable = botButton2.loadingDrawable;
                int i4 = Theme.key_chat_serviceBackgroundSelector;
                loadingDrawable.setColors(Theme.multAlpha(Theme.getColor(i4, this.resourcesProvider), f), Theme.multAlpha(Theme.getColor(i4, this.resourcesProvider), 2.5f), Theme.multAlpha(Theme.getColor(i4, this.resourcesProvider), 3.0f), Theme.multAlpha(Theme.getColor(i4, this.resourcesProvider), 10.0f));
                botButton2.loadingDrawable.setAlpha(255);
                botButton2.loadingDrawable.draw(canvas);
                invalidateOutbounds();
            }
            if (botButton2.selectorDrawable != null) {
                int i5 = (int) fDp2;
                botButton2.selectorDrawable.setBounds(botButton2.x + iDp, i5, botButton2.x + iDp + botButton2.width, botButton2.height + i5);
                botButton2.selectorDrawable.setAlpha(255);
                botButton2.selectorDrawable.draw(canvas);
            }
            canvas.restore();
            canvas.save();
            canvas.translate(botButton2.x + iDp + AndroidUtilities.dp(5.0f), ((AndroidUtilities.dp(44.0f) - botButton2.title.getLineBottom(botButton2.title.getLineCount() - 1)) / 2) + fDp2);
            botButton2.title.draw(canvas);
            canvas.restore();
            if (botButton2.button instanceof TLRPC$TL_keyboardButtonUrl) {
                if (botButton2.isInviteButton) {
                    themedDrawable = getThemedDrawable("drawable_botInvite");
                } else {
                    themedDrawable = getThemedDrawable("drawableBotLink");
                }
                BaseCell.setDrawableBounds(themedDrawable, (((botButton2.x + botButton2.width) - AndroidUtilities.dp(3.0f)) - themedDrawable.getIntrinsicWidth()) + iDp, fDp2 + AndroidUtilities.dp(3.0f));
                themedDrawable.draw(canvas);
            } else if (!(botButton2.button instanceof TLRPC$TL_keyboardButtonSwitchInline) && !(botButton2.button instanceof TLRPC$TL_keyboardButtonRequestPeer)) {
                if (botButton2.button instanceof TLRPC$TL_keyboardButtonBuy) {
                    BaseCell.setDrawableBounds(Theme.chat_botCardDrawable, (((botButton2.x + botButton2.width) - AndroidUtilities.dp(5.0f)) - Theme.chat_botCardDrawable.getIntrinsicWidth()) + iDp, fDp2 + AndroidUtilities.dp(4.0f));
                    Theme.chat_botCardDrawable.draw(canvas);
                }
            } else {
                Drawable themedDrawable2 = getThemedDrawable("drawableBotInline");
                BaseCell.setDrawableBounds(themedDrawable2, (((botButton2.x + botButton2.width) - AndroidUtilities.dp(3.0f)) - themedDrawable2.getIntrinsicWidth()) + iDp, fDp2 + AndroidUtilities.dp(3.0f));
                themedDrawable2.draw(canvas);
            }
            canvas.restore();
            i3++;
            f = 1.0f;
            f2 = 2.0f;
        }
        canvas.restore();
    }

    private boolean allowDrawPhotoImage() {
        return !this.currentMessageObject.hasMediaSpoilers() || this.currentMessageObject.isMediaSpoilersRevealed || this.mediaSpoilerRevealProgress != 0.0f || this.blurredPhotoImage.getBitmap() == null;
    }

    public void drawMessageText(Canvas canvas, ArrayList<MessageObject.TextLayoutBlock> arrayList, boolean z, float f, boolean z2) {
        MessageObject messageObject = this.currentMessageObject;
        drawMessageText(canvas, arrayList, messageObject == null ? 0.0f : messageObject.textXOffset, z, f, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027c A[LOOP:2: B:116:0x0274->B:118:0x027c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x021d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawMessageText(android.graphics.Canvas r27, java.util.ArrayList<org.rbmain.messenger.MessageObject.TextLayoutBlock> r28, float r29, boolean r30, float r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawMessageText(android.graphics.Canvas, java.util.ArrayList, float, boolean, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.rbmain.ui.Components.AnimatedEmojiSpan[] getAnimatedEmojiSpans() {
        /*
            r7 = this;
            org.rbmain.messenger.MessageObject r0 = r7.currentMessageObject
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L1c
            java.lang.CharSequence r0 = r0.messageText
            boolean r3 = r0 instanceof android.text.Spanned
            if (r3 == 0) goto L1c
            r3 = r0
            android.text.Spanned r3 = (android.text.Spanned) r3
            int r0 = r0.length()
            java.lang.Class<org.rbmain.ui.Components.AnimatedEmojiSpan> r4 = org.rbmain.ui.Components.AnimatedEmojiSpan.class
            java.lang.Object[] r0 = r3.getSpans(r2, r0, r4)
            org.rbmain.ui.Components.AnimatedEmojiSpan[] r0 = (org.rbmain.ui.Components.AnimatedEmojiSpan[]) r0
            goto L1d
        L1c:
            r0 = r1
        L1d:
            org.rbmain.messenger.MessageObject r3 = r7.currentMessageObject
            if (r3 == 0) goto L37
            java.lang.CharSequence r3 = r3.caption
            boolean r4 = r3 instanceof android.text.Spanned
            if (r4 == 0) goto L37
            r4 = r3
            android.text.Spanned r4 = (android.text.Spanned) r4
            int r3 = r3.length()
            java.lang.Class<org.rbmain.ui.Components.AnimatedEmojiSpan> r5 = org.rbmain.ui.Components.AnimatedEmojiSpan.class
            java.lang.Object[] r3 = r4.getSpans(r2, r3, r5)
            org.rbmain.ui.Components.AnimatedEmojiSpan[] r3 = (org.rbmain.ui.Components.AnimatedEmojiSpan[]) r3
            goto L38
        L37:
            r3 = r1
        L38:
            if (r0 == 0) goto L3d
            int r4 = r0.length
            if (r4 != 0) goto L43
        L3d:
            if (r3 == 0) goto L6f
            int r4 = r3.length
            if (r4 != 0) goto L43
            goto L6f
        L43:
            if (r0 != 0) goto L47
            r1 = 0
            goto L48
        L47:
            int r1 = r0.length
        L48:
            if (r3 != 0) goto L4c
            r4 = 0
            goto L4d
        L4c:
            int r4 = r3.length
        L4d:
            int r1 = r1 + r4
            org.rbmain.ui.Components.AnimatedEmojiSpan[] r1 = new org.rbmain.ui.Components.AnimatedEmojiSpan[r1]
            if (r0 == 0) goto L60
            r4 = 0
            r5 = 0
        L54:
            int r6 = r0.length
            if (r4 >= r6) goto L61
            r6 = r0[r4]
            r1[r5] = r6
            int r4 = r4 + 1
            int r5 = r5 + 1
            goto L54
        L60:
            r5 = 0
        L61:
            if (r3 == 0) goto L6f
        L63:
            int r0 = r3.length
            if (r2 >= r0) goto L6f
            r0 = r3[r2]
            r1[r5] = r0
            int r2 = r2 + 1
            int r5 = r5 + 1
            goto L63
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.getAnimatedEmojiSpans():org.rbmain.ui.Components.AnimatedEmojiSpan[]");
    }

    public void updateCaptionLayout() {
        float imageX;
        float imageY;
        float imageHeight;
        MessageObject messageObject;
        int i;
        MessageObject messageObject2 = this.currentMessageObject;
        int i2 = messageObject2.type;
        if (i2 == 1 || i2 == 20 || this.documentAttachType == 4 || i2 == 8 || messageObject2.isLiveMessage() || (i = (messageObject = this.currentMessageObject).type) == 124 || i == 125) {
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
                if (this.isRoundVideo) {
                    this.captionX = getBackgroundDrawableLeft() + AndroidUtilities.dp((this.currentMessageObject.isOutOwner() ? 0 : 6) + 11);
                } else {
                    int i3 = this.backgroundDrawableLeft;
                    if (!messageObject.isOutOwner() && !this.mediaBackground && !this.drawPinnedBottom) {
                        f = 17.0f;
                    }
                    this.captionX = i3 + AndroidUtilities.dp(f) + this.captionOffsetX;
                }
                float fDp2 = (this.totalHeight - this.captionHeight) - AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f);
                this.captionY = fDp2;
                if (this.drawCommentButton && this.drawSideButton != 3) {
                    this.captionY = fDp2 - AndroidUtilities.dp(shouldDrawTimeOnMedia() ? 41.3f : 43.0f);
                }
                ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
                if (!reactionsLayoutInBubble.isEmpty && !reactionsLayoutInBubble.isSmall) {
                    this.captionY -= reactionsLayoutInBubble.totalHeight;
                }
            }
        }
        this.captionX += getExtraTextX();
    }

    private boolean textIsSelectionMode() {
        return getCurrentMessagesGroup() == null && this.delegate.getTextSelectionHelper() != null && this.delegate.getTextSelectionHelper().isSelected(this.currentMessageObject);
    }

    public float getViewTop() {
        return this.viewTop;
    }

    public int getBackgroundHeight() {
        return this.backgroundHeight;
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
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || (messageObject != null && messageObject.hasExtendedMedia())) {
            return 4;
        }
        if (this.documentAttachType == 7 && this.currentMessageObject.isVoiceTranscriptionOpen() && this.canStreamVideo) {
            int i = this.buttonState;
            return (i == 1 || i == 4) ? 1 : 0;
        }
        int i2 = this.documentAttachType;
        if (i2 == 3 || i2 == 5) {
            if (this.currentMessageObject.isOutOwner()) {
                this.radialProgress.setColorKeys(Theme.key_chat_outLoader, Theme.key_chat_outLoaderSelected, Theme.key_chat_outMediaIcon, Theme.key_chat_outMediaIconSelected);
            } else {
                this.radialProgress.setColorKeys(Theme.key_chat_inLoader, Theme.key_chat_inLoaderSelected, Theme.key_chat_inMediaIcon, Theme.key_chat_inMediaIconSelected);
            }
            int i3 = this.buttonState;
            if (i3 == 1) {
                return 1;
            }
            if (i3 == 2) {
                return 2;
            }
            return i3 == 4 ? 3 : 0;
        }
        if (i2 == 1 && !this.drawPhotoImage) {
            if (this.currentMessageObject.isOutOwner()) {
                this.radialProgress.setColorKeys(Theme.key_chat_outLoader, Theme.key_chat_outLoaderSelected, Theme.key_chat_outMediaIcon, Theme.key_chat_outMediaIconSelected);
            } else {
                this.radialProgress.setColorKeys(Theme.key_chat_inLoader, Theme.key_chat_inLoaderSelected, Theme.key_chat_inMediaIcon, Theme.key_chat_inMediaIconSelected);
            }
            int i4 = this.buttonState;
            if (i4 == -1) {
                return 5;
            }
            if (i4 == 0) {
                return 2;
            }
            if (i4 == 1) {
                return 3;
            }
        } else {
            RadialProgress2 radialProgress2 = this.radialProgress;
            int i5 = Theme.key_chat_mediaLoaderPhoto;
            int i6 = Theme.key_chat_mediaLoaderPhotoSelected;
            int i7 = Theme.key_chat_mediaLoaderPhotoIcon;
            int i8 = Theme.key_chat_mediaLoaderPhotoIconSelected;
            radialProgress2.setColorKeys(i5, i6, i7, i8);
            this.videoRadialProgress.setColorKeys(i5, i6, i7, i8);
            int i9 = this.buttonState;
            if (i9 >= 0 && i9 < 4) {
                if (i9 == 0) {
                    return 2;
                }
                if (i9 == 1) {
                    return 3;
                }
                return (i9 != 2 && this.autoPlayingMedia) ? 4 : 0;
            }
            if (i9 == -1) {
                if (this.documentAttachType == 1) {
                    if (this.drawPhotoImage && (this.currentPhotoObject != null || this.currentPhotoObjectThumb != null)) {
                        if (this.photoImage.hasBitmapImage()) {
                            return 4;
                        }
                        MessageObject messageObject2 = this.currentMessageObject;
                        if (messageObject2.mediaExists || messageObject2.attachPathExists) {
                            return 4;
                        }
                    }
                    return 5;
                }
                if (this.currentMessageObject.needDrawBluredPreview()) {
                    MessageObject messageObject3 = this.currentMessageObject;
                    if (messageObject3.messageOwner.destroyTime != 0) {
                        return messageObject3.isOutOwner() ? 9 : 11;
                    }
                    return 7;
                }
                if (this.hasEmbed) {
                    return 0;
                }
                if (this.currentMessageObject.type == 123) {
                    return 100;
                }
            }
        }
        MessageObject messageObject4 = this.currentMessageObject;
        return (messageObject4 != null && this.isRoundVideo && messageObject4.isVoiceTranscriptionOpen()) ? 0 : 4;
    }

    private int getMaxNameWidth() {
        int iMin;
        int iMin2;
        int iDp;
        MessageObject messageObject;
        MessageObject messageObject2;
        int i;
        int parentWidth;
        int i2 = this.documentAttachType;
        if (i2 == 6 || i2 == 8 || (i = (messageObject2 = this.currentMessageObject).type) == 5) {
            if (AndroidUtilities.isTablet()) {
                if (this.isChat && !this.isThreadPost && !this.currentMessageObject.isOutOwner() && this.currentMessageObject.needDrawAvatar()) {
                    iMin2 = AndroidUtilities.getMinTabletSide();
                    iDp = AndroidUtilities.dp(42.0f);
                    iMin = iMin2 - iDp;
                } else {
                    iMin = AndroidUtilities.getMinTabletSide();
                }
            } else if (this.isChat && !this.isThreadPost && !this.currentMessageObject.isOutOwner() && this.currentMessageObject.needDrawAvatar()) {
                iMin2 = Math.min(getParentWidth(), AndroidUtilities.displaySize.y);
                iDp = AndroidUtilities.dp(42.0f);
                iMin = iMin2 - iDp;
            } else {
                iMin = Math.min(getParentWidth(), AndroidUtilities.displaySize.y);
            }
            if (this.isPlayingRound && ((messageObject = this.currentMessageObject) == null || !messageObject.isVoiceTranscriptionOpen())) {
                return (iMin - (this.backgroundWidth - (AndroidUtilities.roundPlayingMessageSize - AndroidUtilities.roundMessageSize))) - AndroidUtilities.dp(57.0f);
            }
            return (iMin - this.backgroundWidth) - AndroidUtilities.dp(57.0f);
        }
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages == null || groupedMessages.isDocuments) {
            if (i == 19) {
                return Math.max(messageObject2.textWidth, (int) (((AndroidUtilities.displaySize.x - AndroidUtilities.dp(52.0f)) - (this.isAvatarVisible ? AndroidUtilities.dp(48.0f) : 0)) * 0.5f));
            }
            return this.backgroundWidth - AndroidUtilities.dp(this.mediaBackground ? 22.0f : 31.0f);
        }
        if (AndroidUtilities.isTablet()) {
            parentWidth = AndroidUtilities.getMinTabletSide();
        } else {
            parentWidth = getParentWidth();
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.currentMessagesGroup.posArray.size(); i4++) {
            if (this.currentMessagesGroup.posArray.get(i4).minY != 0) {
                break;
            }
            double d = i3;
            double dCeil = Math.ceil(((r4.pw + r4.leftSpanOffset) / 1000.0f) * parentWidth);
            Double.isNaN(d);
            i3 = (int) (d + dCeil);
        }
        return i3 - AndroidUtilities.dp((this.isAvatarVisible ? 48 : 0) + 31);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateButtonState(boolean r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 2204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.updateButtonState(boolean, boolean, boolean):void");
    }

    private void didPressMiniButton(boolean z) {
        int i = this.miniButtonState;
        if (i != 0) {
            if (i == 1) {
                int i2 = this.documentAttachType;
                if ((i2 == 3 || i2 == 5 || i2 == 7) && MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
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
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && !messageObject.isAnyKindOfSticker()) {
            this.currentMessageObject.putInDownloadsStore = true;
        }
        int i3 = this.documentAttachType;
        if (i3 == 3 || i3 == 5) {
            FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
            this.currentMessageObject.loadingCancelled = false;
        } else if (i3 == 4 || i3 == 7) {
            createLoadingProgressLayout(this.documentAttach);
            FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
            TLRPC$Document tLRPC$Document = this.documentAttach;
            MessageObject messageObject2 = this.currentMessageObject;
            fileLoader.loadFile(tLRPC$Document, messageObject2, 2, messageObject2.shouldEncryptPhotoOrVideo() ? 2 : 0);
            this.currentMessageObject.loadingCancelled = false;
        }
        this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
        invalidate();
    }

    private void didPressButton(boolean z, boolean z2) {
        MessageObject messageObject;
        MessageObject playingMessageObject;
        MessageObject messageObject2;
        MessageObject messageObject3;
        TLRPC$PhotoSize tLRPC$PhotoSize;
        String str;
        MessageObject messageObject4;
        MessageObject messageObject5 = this.currentMessageObject;
        if (messageObject5 != null && !messageObject5.isAnyKindOfSticker()) {
            this.currentMessageObject.putInDownloadsStore = true;
        }
        int i = this.buttonState;
        if (i == 0 && (!this.drawVideoImageButton || z2)) {
            int i2 = this.documentAttachType;
            if (i2 == 3 || i2 == 5 || (i2 == 7 && (messageObject4 = this.currentMessageObject) != null && messageObject4.isVoiceTranscriptionOpen() && this.currentMessageObject.mediaExists)) {
                if (this.miniButtonState == 0) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
                    this.currentMessageObject.loadingCancelled = false;
                }
                if (this.delegate.needPlayMessage(this.currentMessageObject, false)) {
                    if (this.hasMiniProgress == 2 && this.miniButtonState != 1) {
                        this.miniButtonState = 1;
                        this.radialProgress.setProgress(0.0f, false);
                        this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, true);
                    }
                    updatePlayingMessageProgress();
                    this.buttonState = 1;
                    this.radialProgress.setIcon(getIconForCurrentState(), false, true);
                    invalidate();
                    return;
                }
                return;
            }
            if (z2) {
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
            MessageObject messageObject6 = this.currentMessageObject;
            int i3 = messageObject6.type;
            if (i3 == 1 || i3 == 20) {
                this.photoImage.setForceLoading(true);
                ImageReceiver imageReceiver = this.photoImage;
                ImageLocation forObject = ImageLocation.getForObject(this.currentPhotoObject, this.photoParentObject);
                String str3 = this.currentPhotoFilter;
                ImageLocation forObject2 = ImageLocation.getForObject(this.currentPhotoObjectThumb, this.photoParentObject);
                String str4 = this.currentPhotoFilterThumb;
                BitmapDrawable bitmapDrawable = this.currentPhotoObjectThumbStripped;
                long j = this.currentPhotoObject.size;
                MessageObject messageObject7 = this.currentMessageObject;
                imageReceiver.setImage(forObject, str3, forObject2, str4, bitmapDrawable, j, null, messageObject7, messageObject7.shouldEncryptPhotoOrVideo() ? 2 : 0);
            } else if (i3 == 8) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
                if (this.currentMessageObject.loadedFileSize > 0) {
                    createLoadingProgressLayout(this.documentAttach);
                }
            } else if (this.isRoundVideo) {
                if (messageObject6.isSecretMedia()) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.currentMessageObject.getDocument(), this.currentMessageObject, 2, 1);
                } else {
                    MessageObject messageObject8 = this.currentMessageObject;
                    messageObject8.gifState = 2.0f;
                    TLRPC$Document document = messageObject8.getDocument();
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForDocument(document), null, ImageLocation.getForObject(tLRPC$PhotoSize, document), str2, document.size, null, this.currentMessageObject, 0);
                }
                this.wouldBeInPip = true;
                invalidate();
            } else if (i3 == 9) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
                if (this.currentMessageObject.loadedFileSize > 0) {
                    createLoadingProgressLayout(this.documentAttach);
                }
            } else {
                int i4 = this.documentAttachType;
                if (i4 == 4) {
                    FileLoader fileLoader = FileLoader.getInstance(this.currentAccount);
                    TLRPC$Document tLRPC$Document = this.documentAttach;
                    MessageObject messageObject9 = this.currentMessageObject;
                    fileLoader.loadFile(tLRPC$Document, messageObject9, 1, messageObject9.shouldEncryptPhotoOrVideo() ? 2 : 0);
                    MessageObject messageObject10 = this.currentMessageObject;
                    if (messageObject10.loadedFileSize > 0) {
                        createLoadingProgressLayout(messageObject10.getDocument());
                    }
                } else if (i3 != 0 || i4 == 0) {
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForObject(this.currentPhotoObject, this.photoParentObject), this.currentPhotoFilter, ImageLocation.getForObject(this.currentPhotoObjectThumb, this.photoParentObject), this.currentPhotoFilterThumb, this.currentPhotoObjectThumbStripped, 0L, null, this.currentMessageObject, 0);
                } else if (i4 == 2) {
                    this.photoImage.setForceLoading(true);
                    this.photoImage.setImage(ImageLocation.getForDocument(this.documentAttach), null, ImageLocation.getForDocument(this.currentPhotoObject, this.documentAttach), this.currentPhotoFilterThumb, this.documentAttach.size, null, this.currentMessageObject, 0);
                    MessageObject messageObject11 = this.currentMessageObject;
                    messageObject11.gifState = 2.0f;
                    if (messageObject11.loadedFileSize > 0) {
                        createLoadingProgressLayout(messageObject11.getDocument());
                    }
                } else if (i4 == 1) {
                    FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
                } else if (i4 == 8) {
                    this.photoImage.setImage(ImageLocation.getForDocument(this.documentAttach), this.currentPhotoFilter, ImageLocation.getForDocument(this.currentPhotoObject, this.documentAttach), "b1", 0L, "jpg", this.currentMessageObject, 1);
                }
            }
            this.currentMessageObject.loadingCancelled = false;
            this.buttonState = 1;
            if (z2) {
                this.videoRadialProgress.setIcon(14, false, z);
            } else {
                this.radialProgress.setIcon(getIconForCurrentState(), false, z);
            }
            invalidate();
            return;
        }
        if (i == 1 && (!this.drawVideoImageButton || z2)) {
            this.photoImage.setForceLoading(false);
            int i5 = this.documentAttachType;
            if (i5 == 3 || i5 == 5 || (i5 == 7 && (messageObject3 = this.currentMessageObject) != null && messageObject3.isVoiceTranscriptionOpen())) {
                if (MediaController.getInstance().lambda$startAudioAgain$7(this.currentMessageObject)) {
                    this.buttonState = 0;
                    this.radialProgress.setIcon(getIconForCurrentState(), false, z);
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
            MessageObject messageObject12 = this.currentMessageObject;
            messageObject12.loadingCancelled = true;
            int i6 = this.documentAttachType;
            if (i6 == 2 || i6 == 4 || i6 == 1 || i6 == 8) {
                FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.documentAttach);
            } else {
                int i7 = messageObject12.type;
                if (i7 == 0 || i7 == 1 || i7 == 20 || i7 == 8 || i7 == 5) {
                    ImageLoader.getInstance().cancelForceLoadingForImageReceiver(this.photoImage);
                    this.photoImage.cancelLoadImage();
                } else if (i7 == 9) {
                    FileLoader.getInstance(this.currentAccount).cancelLoadFile(this.currentMessageObject.getDocument());
                }
            }
            this.buttonState = 0;
            if (z2) {
                this.videoRadialProgress.setIcon(2, false, z);
            } else {
                this.radialProgress.setIcon(getIconForCurrentState(), false, z);
            }
            invalidate();
            return;
        }
        if (i != 2) {
            if (i == 3 || i == 0) {
                if (this.hasMiniProgress == 2 && this.miniButtonState != 1) {
                    this.miniButtonState = 1;
                    this.radialProgress.setProgress(0.0f, false);
                    this.radialProgress.setMiniIcon(getMiniIconForCurrentState(), false, z);
                }
                this.delegate.didPressImage(this, 0.0f, 0.0f);
                return;
            }
            if (i == 4) {
                int i8 = this.documentAttachType;
                if (i8 == 3 || i8 == 5 || (i8 == 7 && (messageObject = this.currentMessageObject) != null && messageObject.isVoiceTranscriptionOpen())) {
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
                    this.radialProgress.setIcon(getIconForCurrentState(), false, z);
                    invalidate();
                    return;
                }
                return;
            }
            return;
        }
        if (this.documentAttachType == 7 && (messageObject2 = this.currentMessageObject) != null && messageObject2.isVoiceTranscriptionOpen()) {
            if (this.miniButtonState == 0) {
                FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
                this.currentMessageObject.loadingCancelled = false;
            }
            if (this.delegate.needPlayMessage(this.currentMessageObject, false)) {
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
            if (this.isRoundVideo) {
                this.wouldBeInPip = true;
                invalidate();
                return;
            }
            return;
        }
        int i9 = this.documentAttachType;
        if (i9 == 3 || i9 == 5) {
            this.radialProgress.setProgress(0.0f, false);
            FileLoader.getInstance(this.currentAccount).loadFile(this.documentAttach, this.currentMessageObject, 2, 0);
            this.currentMessageObject.loadingCancelled = false;
            this.buttonState = 4;
            this.radialProgress.setIcon(getIconForCurrentState(), true, z);
            invalidate();
            return;
        }
        if (!this.isRoundVideo || (playingMessageObject = MediaController.getInstance().getPlayingMessageObject()) == null || !playingMessageObject.isRoundVideo()) {
            this.photoImage.setAllowStartAnimation(true);
            this.photoImage.startAnimation();
        }
        this.currentMessageObject.gifState = 0.0f;
        this.buttonState = -1;
        this.radialProgress.setIcon(getIconForCurrentState(), false, z);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String str, boolean z) {
        int i = this.documentAttachType;
        updateButtonState(true, i == 3 || i == 5, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0125  */
    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onSuccessDownload(java.lang.String r23) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.onSuccessDownload(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0043  */
    @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didSetImage(org.rbmain.messenger.ImageReceiver r5, boolean r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            org.rbmain.messenger.MessageObject r0 = r4.currentMessageObject
            if (r0 == 0) goto L4a
            if (r6 == 0) goto L4a
            r1 = 0
            r2 = 1
            if (r8 != 0) goto L10
            boolean r8 = r0.wasUnread
            if (r8 != 0) goto L10
            r8 = 1
            goto L11
        L10:
            r8 = 0
        L11:
            boolean r8 = r4.setCurrentDiceValue(r8)
            if (r8 == 0) goto L18
            return
        L18:
            if (r7 == 0) goto L26
            org.rbmain.messenger.MessageObject r8 = r4.currentMessageObject
            int r0 = r8.type
            r3 = 20
            if (r0 != r3) goto L26
            boolean r8 = r8.mediaExists
            if (r8 == 0) goto L43
        L26:
            if (r7 != 0) goto L4a
            org.rbmain.messenger.MessageObject r7 = r4.currentMessageObject
            boolean r8 = r7.mediaExists
            if (r8 != 0) goto L4a
            boolean r8 = r7.attachPathExists
            if (r8 != 0) goto L4a
            int r7 = r7.type
            if (r7 != 0) goto L41
            int r8 = r4.documentAttachType
            r0 = 8
            if (r8 == r0) goto L43
            if (r8 == 0) goto L43
            r0 = 6
            if (r8 == r0) goto L43
        L41:
            if (r7 != r2) goto L4a
        L43:
            org.rbmain.messenger.MessageObject r7 = r4.currentMessageObject
            r7.mediaExists = r2
            r4.updateButtonState(r1, r2, r1)
        L4a:
            if (r6 == 0) goto L8c
            org.rbmain.messenger.MessageObject r6 = r4.currentMessageObject
            if (r6 == 0) goto L8c
            org.rbmain.messenger.ImageReceiver r6 = r4.blurredPhotoImage
            android.graphics.Bitmap r6 = r6.getBitmap()
            if (r6 == 0) goto L67
            org.rbmain.messenger.ImageReceiver r6 = r4.blurredPhotoImage
            android.graphics.Bitmap r6 = r6.getBitmap()
            r6.recycle()
            org.rbmain.messenger.ImageReceiver r6 = r4.blurredPhotoImage
            r7 = 0
            r6.setImageBitmap(r7)
        L67:
            org.rbmain.messenger.MessageObject r6 = r4.currentMessageObject
            boolean r6 = r6.hasMediaSpoilers()
            if (r6 == 0) goto L8c
            android.graphics.Bitmap r6 = r5.getBitmap()
            if (r6 == 0) goto L8c
            android.graphics.Bitmap r6 = r5.getBitmap()
            boolean r6 = r6.isRecycled()
            if (r6 != 0) goto L8c
            org.rbmain.messenger.ImageReceiver r6 = r4.blurredPhotoImage
            android.graphics.Bitmap r5 = r5.getBitmap()
            android.graphics.Bitmap r5 = org.rbmain.messenger.Utilities.stackBlurBitmapMax(r5)
            r6.setImageBitmap(r5)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.didSetImage(org.rbmain.messenger.ImageReceiver, boolean, boolean, boolean):void");
    }

    public boolean setCurrentDiceValue(boolean z) {
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
                        ((SlotsDrawable) rLottieDrawable).setDiceNumber(this, diceValue, stickerSetByEmojiOrName, z);
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
                        FileLoader.getInstance(this.currentAccount);
                        if (rLottieDrawable.setBaseDice(FileLoader.getPathToAttach(tLRPC$Document, true))) {
                            DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
                        } else {
                            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$Document), this.currentMessageObject, this);
                            FileLoader.getInstance(this.currentAccount).loadFile(tLRPC$Document, stickerSetByEmojiOrName, 1, 1);
                        }
                    }
                    if (diceValue >= 0 && diceValue < stickerSetByEmojiOrName.documents.size()) {
                        if (!z && this.currentMessageObject.isOut() && (diceFrameSuccess = MessagesController.getInstance(this.currentAccount).diceSuccess.get(diceEmoji)) != null && diceFrameSuccess.num == diceValue) {
                            rLottieDrawable.setOnFinishCallback(this.diceFinishCallback, diceFrameSuccess.frame);
                        }
                        TLRPC$Document tLRPC$Document2 = stickerSetByEmojiOrName.documents.get(Math.max(diceValue, 0));
                        FileLoader.getInstance(this.currentAccount);
                        if (rLottieDrawable.setDiceNumber(FileLoader.getPathToAttach(tLRPC$Document2, true), z)) {
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

    @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
    public void onAnimationReady(ImageReceiver imageReceiver) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && imageReceiver == this.photoImage && messageObject.isAnimatedSticker()) {
            this.delegate.setShouldNotRepeatSticker(this.currentMessageObject);
        }
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String str, long j, long j2) {
        float fMin = j2 == 0 ? 0.0f : Math.min(1.0f, j / j2);
        this.currentMessageObject.loadedFileSize = j;
        createLoadingProgressLayout(j, j2);
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

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String str, long j, long j2, boolean z) {
        int i;
        float fMin = j2 == 0 ? 0.0f : Math.min(1.0f, j / j2);
        this.currentMessageObject.loadedFileSize = j;
        this.radialProgress.setProgress(fMin, true);
        if (j == j2 && this.currentPosition != null && SendMessagesHelper.getInstance(this.currentAccount).isSendingMessage(this.currentMessageObject.getId()) && ((i = this.buttonState) == 1 || (i == 4 && this.documentAttachType == 5))) {
            this.drawRadialCheckBackground = true;
            getIconForCurrentState();
            this.radialProgress.setIcon(6, false, true);
        }
        long j3 = this.lastLoadingSizeTotal;
        if (j3 > 0 && Math.abs(j3 - j2) > 1048576) {
            this.lastLoadingSizeTotal = j2;
        }
        createLoadingProgressLayout(j, j2);
    }

    private void createLoadingProgressLayout(TLRPC$Document tLRPC$Document) {
        if (tLRPC$Document == null) {
            return;
        }
        long[] fileProgressSizes = ImageLoader.getInstance().getFileProgressSizes(FileLoader.getDocumentFileName(tLRPC$Document));
        if (fileProgressSizes != null) {
            createLoadingProgressLayout(fileProgressSizes[0], fileProgressSizes[1]);
        } else {
            createLoadingProgressLayout(this.currentMessageObject.loadedFileSize, tLRPC$Document.size);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void createLoadingProgressLayout(long r17, long r19) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.createLoadingProgressLayout(long, long):void");
    }

    @Override // android.view.View
    public void onProvideStructure(ViewStructure viewStructure) {
        super.onProvideStructure(viewStructure);
        if (!this.allowAssistant || Build.VERSION.SDK_INT < 23) {
            return;
        }
        CharSequence charSequence = this.currentMessageObject.messageText;
        if (charSequence != null && charSequence.length() > 0) {
            viewStructure.setText(this.currentMessageObject.messageText);
            return;
        }
        CharSequence charSequence2 = this.currentMessageObject.caption;
        if (charSequence2 == null || charSequence2.length() <= 0) {
            return;
        }
        viewStructure.setText(this.currentMessageObject.caption);
    }

    public void setDelegate(ChatMessageCellDelegate chatMessageCellDelegate) {
        this.delegate = chatMessageCellDelegate;
    }

    public ChatMessageCellDelegate getDelegate() {
        return this.delegate;
    }

    public void setAllowAssistant(boolean z) {
        this.allowAssistant = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void measureTime(org.rbmain.messenger.MessageObject r17) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.measureTime(org.rbmain.messenger.MessageObject):void");
    }

    private boolean shouldDrawSelectionOverlay() {
        return hasSelectionOverlay() && ((isPressed() && this.isCheckPressed) || ((!this.isCheckPressed && this.isPressed) || this.isHighlighted || this.isHighlightedAnimated)) && !textIsSelectionMode() && ((this.currentMessagesGroup == null || this.drawSelectionBackground) && this.currentBackgroundDrawable != null);
    }

    private int getSelectionOverlayColor() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider == null) {
            return 0;
        }
        MessageObject messageObject = this.currentMessageObject;
        return resourcesProvider.getColor((messageObject == null || !messageObject.isOut()) ? Theme.key_chat_inBubbleSelectedOverlay : Theme.key_chat_outBubbleSelectedOverlay);
    }

    private boolean hasSelectionOverlay() {
        int selectionOverlayColor = getSelectionOverlayColor();
        return (selectionOverlayColor == 0 || selectionOverlayColor == -65536) ? false : true;
    }

    private boolean isDrawSelectionBackground() {
        return (((!isPressed() || !this.isCheckPressed) && ((this.isCheckPressed || !this.isPressed) && !this.isHighlighted)) || textIsSelectionMode() || hasSelectionOverlay()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOpenChatByShare(MessageObject messageObject) {
        ChatMessageCellDelegate chatMessageCellDelegate;
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = messageObject.messageOwner.fwd_from;
        return (tLRPC$MessageFwdHeader == null || tLRPC$MessageFwdHeader.saved_from_peer == null || ((chatMessageCellDelegate = this.delegate) != null && !chatMessageCellDelegate.isReplyOrSelf())) ? false : true;
    }

    private boolean checkNeedDrawShareButton(MessageObject messageObject) {
        MessageObject messageObject2 = this.currentMessageObject;
        if (messageObject2.deleted || messageObject2.isSponsored()) {
            return false;
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if (groupedMessagePosition == null || this.currentMessagesGroup.isDocuments || groupedMessagePosition.last) {
            return messageObject.needDrawShareButton();
        }
        return false;
    }

    public boolean isInsideBackground(float f, float f2) {
        if (this.currentBackgroundDrawable != null) {
            if (f >= this.backgroundDrawableLeft && f <= r3 + this.backgroundDrawableRight) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateCurrentUserAndChat() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.updateCurrentUserAndChat():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x09e3 A[PHI: r5
      0x09e3: PHI (r5v16 java.lang.String) = 
      (r5v10 java.lang.String)
      (r5v13 java.lang.String)
      (r5v13 java.lang.String)
      (r5v13 java.lang.String)
      (r5v13 java.lang.String)
     binds: [B:351:0x09e1, B:357:0x09f1, B:369:0x0a41, B:366:0x0a26, B:361:0x0a0c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r3v174 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String, org.rbmain.tgnet.TLRPC$Chat, org.rbmain.tgnet.TLRPC$User] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v83 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setMessageObjectInternal(org.rbmain.messenger.MessageObject r42) {
        /*
            Method dump skipped, instructions count: 3731
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.setMessageObjectInternal(org.rbmain.messenger.MessageObject):void");
    }

    private boolean isNeedAuthorName() {
        return (this.isPinnedChat && this.currentMessageObject.type == 0) || (!this.pinnedTop && this.drawName && this.isChat && (!this.currentMessageObject.isOutOwner() || (this.currentMessageObject.isSupergroup() && this.currentMessageObject.isFromGroup()))) || (this.currentMessageObject.isImportedForward() && this.currentMessageObject.messageOwner.fwd_from.from_id == null);
    }

    private String getAuthorName() {
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User != null) {
            return UserObject.getUserName(tLRPC$User);
        }
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        if (tLRPC$Chat != null) {
            return tLRPC$Chat.title;
        }
        MessageObject messageObject = this.currentMessageObject;
        return (messageObject == null || !messageObject.isSponsored()) ? "DELETED" : BuildConfig.FLAVOR;
    }

    private String getForwardedMessageText(MessageObject messageObject) {
        if (this.hasPsaHint) {
            String string = LocaleController.getString("PsaMessage_" + messageObject.messageOwner.fwd_from.psa_type);
            return string == null ? LocaleController.getString("PsaMessageDefault", ir.medu.shad.R.string.PsaMessageDefault) : string;
        }
        return LocaleController.getString("ForwardedMessage", ir.medu.shad.R.string.ForwardedMessage);
    }

    public int getExtraInsetHeight() {
        int iDp = this.addedCaptionHeight;
        if (this.drawCommentButton) {
            iDp += AndroidUtilities.dp(shouldDrawTimeOnMedia() ? 41.3f : 43.0f);
        }
        return (this.reactionsLayoutInBubble.isEmpty || !this.currentMessageObject.shouldDrawReactionsInLayout()) ? iDp : iDp + this.reactionsLayoutInBubble.totalHeight;
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
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        return this.mediaBackground || this.drawPinnedBottom || (groupedMessagePosition != null && (groupedMessagePosition.flags & 8) == 0 && this.currentMessagesGroup.isDocuments);
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[PHI: r4 r5
      0x003d: PHI (r4v1 int) = (r4v0 int), (r4v14 int) binds: [B:15:0x001a, B:17:0x002a] A[DONT_GENERATE, DONT_INLINE]
      0x003d: PHI (r5v1 int) = (r5v0 int), (r5v6 int) binds: [B:15:0x001a, B:17:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setBackgroundTopY(boolean r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 2
            if (r1 >= r2) goto L85
            r2 = 1
            if (r1 != r2) goto Lb
            if (r15 != 0) goto Lb
            return
        Lb:
            if (r1 != 0) goto L10
            org.rbmain.ui.ActionBar.Theme$MessageDrawable r3 = r14.currentBackgroundDrawable
            goto L12
        L10:
            org.rbmain.ui.ActionBar.Theme$MessageDrawable r3 = r14.currentBackgroundSelectedDrawable
        L12:
            if (r3 != 0) goto L16
            goto L81
        L16:
            int r4 = r14.parentWidth
            int r5 = r14.parentHeight
            if (r5 != 0) goto L3d
            int r4 = r14.getParentWidth()
            android.graphics.Point r5 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r5 = r5.y
            android.view.ViewParent r6 = r14.getParent()
            boolean r6 = r6 instanceof android.view.View
            if (r6 == 0) goto L3d
            android.view.ViewParent r4 = r14.getParent()
            android.view.View r4 = (android.view.View) r4
            int r5 = r4.getMeasuredWidth()
            int r4 = r4.getMeasuredHeight()
            r7 = r4
            r6 = r5
            goto L3f
        L3d:
            r6 = r4
            r7 = r5
        L3f:
            if (r15 == 0) goto L46
            float r4 = r14.getY()
            goto L4b
        L46:
            int r4 = r14.getTop()
            float r4 = (float) r4
        L4b:
            float r5 = r14.parentViewTopOffset
            float r4 = r4 + r5
            int r8 = (int) r4
            int r9 = (int) r5
            int r10 = r14.blurredViewTopOffset
            int r11 = r14.blurredViewBottomOffset
            boolean r12 = r14.pinnedTop
            boolean r4 = r14.pinnedBottom
            if (r4 != 0) goto L67
            org.rbmain.ui.Cells.ChatMessageCell$TransitionParams r4 = r14.transitionParams
            float r4 = r4.changePinnedBottomProgress
            r5 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L65
            goto L67
        L65:
            r13 = 0
            goto L68
        L67:
            r13 = 1
        L68:
            r4 = r3
            r5 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r4.setTop(r5, r6, r7, r8, r9, r10, r11, r12)
            org.rbmain.messenger.MessageObject r4 = r14.currentMessageObject
            if (r4 == 0) goto L7d
            boolean r4 = r4.hasInlineBotButtons()
            if (r4 == 0) goto L7d
            goto L7e
        L7d:
            r2 = 0
        L7e:
            r3.setBotButtonsBottom(r2)
        L81:
            int r1 = r1 + 1
            goto L2
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.setBackgroundTopY(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0029 A[PHI: r0 r1
      0x0029: PHI (r0v1 int) = (r0v0 int), (r0v5 int) binds: [B:3:0x0006, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r1v1 int) = (r1v0 int), (r1v4 int) binds: [B:3:0x0006, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setBackgroundTopY(int r13) {
        /*
            r12 = this;
            org.rbmain.ui.ActionBar.Theme$MessageDrawable r9 = r12.currentBackgroundDrawable
            int r0 = r12.parentWidth
            int r1 = r12.parentHeight
            if (r1 != 0) goto L29
            int r0 = r12.getParentWidth()
            android.graphics.Point r1 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r1 = r1.y
            android.view.ViewParent r2 = r12.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L29
            android.view.ViewParent r0 = r12.getParent()
            android.view.View r0 = (android.view.View) r0
            int r1 = r0.getMeasuredWidth()
            int r0 = r0.getMeasuredHeight()
            r3 = r0
            r2 = r1
            goto L2b
        L29:
            r2 = r0
            r3 = r1
        L2b:
            float r0 = r12.parentViewTopOffset
            float r13 = (float) r13
            float r13 = r13 + r0
            int r1 = (int) r13
            int r4 = (int) r0
            int r5 = r12.blurredViewTopOffset
            int r6 = r12.blurredViewBottomOffset
            boolean r7 = r12.pinnedTop
            boolean r13 = r12.pinnedBottom
            r10 = 0
            r11 = 1
            if (r13 != 0) goto L4a
            org.rbmain.ui.Cells.ChatMessageCell$TransitionParams r13 = r12.transitionParams
            float r13 = r13.changePinnedBottomProgress
            r0 = 1065353216(0x3f800000, float:1.0)
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 == 0) goto L48
            goto L4a
        L48:
            r8 = 0
            goto L4b
        L4a:
            r8 = 1
        L4b:
            r0 = r9
            r0.setTop(r1, r2, r3, r4, r5, r6, r7, r8)
            org.rbmain.messenger.MessageObject r13 = r12.currentMessageObject
            if (r13 == 0) goto L5a
            boolean r13 = r13.hasInlineBotButtons()
            if (r13 == 0) goto L5a
            r10 = 1
        L5a:
            r9.setBotButtonsBottom(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.setBackgroundTopY(int):void");
    }

    public void setDrawableBoundsInner(Drawable drawable, int i, int i2, int i3, int i4) {
        if (drawable != null) {
            float f = i4 + i2;
            TransitionParams transitionParams = this.transitionParams;
            float f2 = transitionParams.deltaBottom;
            this.transitionYOffsetForDrawables = (f + f2) - ((int) (f + f2));
            drawable.setBounds((int) (i + transitionParams.deltaLeft), (int) (i2 + transitionParams.deltaTop), (int) (i + i3 + transitionParams.deltaRight), (int) (f + f2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0401  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 1531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:363:0x07e2 A[PHI: r2 r5
      0x07e2: PHI (r2v46 int) = (r2v45 int), (r2v63 int) binds: [B:359:0x07bd, B:361:0x07cd] A[DONT_GENERATE, DONT_INLINE]
      0x07e2: PHI (r5v23 int) = (r5v22 int), (r5v28 int) binds: [B:359:0x07bd, B:361:0x07cd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawBackgroundInternal(android.graphics.Canvas r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 2246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawBackgroundInternal(android.graphics.Canvas, boolean):void");
    }

    private void animateCheckboxTranslation() {
        boolean z = this.checkBoxVisible;
        if (z || this.checkBoxAnimationInProgress) {
            if ((z && this.checkBoxAnimationProgress == 1.0f) || (!z && this.checkBoxAnimationProgress == 0.0f)) {
                this.checkBoxAnimationInProgress = false;
            }
            this.checkBoxTranslation = (int) Math.ceil((z ? CubicBezierInterpolator.EASE_OUT : CubicBezierInterpolator.EASE_IN).getInterpolation(this.checkBoxAnimationProgress) * AndroidUtilities.dp(35.0f));
            if (!this.currentMessageObject.isOutOwner()) {
                updateTranslation();
            }
            if (this.checkBoxAnimationInProgress) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.lastCheckBoxAnimationTime;
                this.lastCheckBoxAnimationTime = jElapsedRealtime;
                if (this.checkBoxVisible) {
                    float f = this.checkBoxAnimationProgress + (j / 200.0f);
                    this.checkBoxAnimationProgress = f;
                    if (f > 1.0f) {
                        this.checkBoxAnimationProgress = 1.0f;
                    }
                } else {
                    float f2 = this.checkBoxAnimationProgress - (j / 200.0f);
                    this.checkBoxAnimationProgress = f2;
                    if (f2 <= 0.0f) {
                        this.checkBoxAnimationProgress = 0.0f;
                    }
                }
                invalidate();
                ((View) getParent()).invalidate();
            }
        }
    }

    public boolean drawBackgroundInParent() {
        MessageObject messageObject;
        return this.canDrawBackgroundInParent && (messageObject = this.currentMessageObject) != null && messageObject.isOutOwner() && getThemedColor(Theme.key_chat_outBubbleGradient1) != 0;
    }

    public void drawCommentButton(Canvas canvas, float f) {
        if (this.drawSideButton != 3) {
            return;
        }
        int iDp = AndroidUtilities.dp(32.0f);
        if (this.commentLayout != null) {
            this.sideStartY -= AndroidUtilities.dp(18.0f);
            iDp += AndroidUtilities.dp(18.0f);
        }
        RectF rectF = this.rect;
        float f2 = this.sideStartX;
        rectF.set(f2, this.sideStartY, AndroidUtilities.dp(32.0f) + f2, this.sideStartY + iDp);
        applyServiceShaderMatrix();
        if (f != 1.0f) {
            int alpha = getThemedPaint("paintChatActionBackground").getAlpha();
            getThemedPaint("paintChatActionBackground").setAlpha((int) (alpha * f));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), getThemedPaint("paintChatActionBackground"));
            getThemedPaint("paintChatActionBackground").setAlpha(alpha);
        } else {
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), getThemedPaint(this.sideButtonPressed ? "paintChatActionBackgroundSelected" : "paintChatActionBackground"));
        }
        if (hasGradientService()) {
            if (f != 1.0f) {
                int alpha2 = Theme.chat_actionBackgroundGradientDarkenPaint.getAlpha();
                Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha((int) (alpha2 * f));
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
                Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha(alpha2);
            } else {
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
        }
        Drawable themeDrawable = Theme.getThemeDrawable("drawableCommentSticker");
        BaseCell.setDrawableBounds(themeDrawable, this.sideStartX + AndroidUtilities.dp(4.0f), this.sideStartY + AndroidUtilities.dp(4.0f));
        if (f != 1.0f) {
            themeDrawable.setAlpha((int) (f * 255.0f));
            themeDrawable.draw(canvas);
            themeDrawable.setAlpha(255);
        } else {
            themeDrawable.draw(canvas);
        }
        if (this.commentLayout != null) {
            Theme.chat_stickerCommentCountPaint.setColor(getThemedColor(Theme.key_chat_stickerReplyNameText));
            Theme.chat_stickerCommentCountPaint.setAlpha((int) (f * 255.0f));
            if (this.transitionParams.animateComments) {
                if (this.transitionParams.animateCommentsLayout != null) {
                    canvas.save();
                    TextPaint textPaint = Theme.chat_stickerCommentCountPaint;
                    double d = this.transitionParams.animateChangeProgress;
                    Double.isNaN(d);
                    double d2 = f;
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

    public void applyServiceShaderMatrix() {
        applyServiceShaderMatrix(getMeasuredWidth(), this.backgroundHeight, getX(), this.viewTop);
    }

    private void applyServiceShaderMatrix(int i, int i2, float f, float f2) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider != null) {
            resourcesProvider.applyServiceShaderMatrix(i, i2, f, f2);
        } else {
            Theme.applyServiceShaderMatrix(i, i2, f, f2);
        }
    }

    public boolean hasOutboundsContent() {
        AnimatedEmojiSpan.EmojiGroupedSpans emojiGroupedSpans;
        AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable;
        if (getAlpha() != 1.0f) {
            return false;
        }
        if ((this.transitionParams.transitionBotButtons.isEmpty() || !this.transitionParams.animateBotButtonsChanged) && this.botButtons.isEmpty() && this.drawSideButton == 0 && ((!this.drawNameLayout || this.nameLayout == null || (swapAnimatedEmojiDrawable = this.currentNameStatusDrawable) == null || swapAnimatedEmojiDrawable.getDrawable() == null) && ((emojiGroupedSpans = this.animatedEmojiStack) == null || emojiGroupedSpans.holders.isEmpty()))) {
            if (this.currentMessagesGroup != null) {
                return false;
            }
            TransitionParams transitionParams = this.transitionParams;
            if (((!transitionParams.animateReplaceCaptionLayout || transitionParams.animateChangeProgress == 1.0f) && (transitionParams.animateChangeProgress == 1.0f || !transitionParams.animateMessageText)) || transitionParams.animateOutAnimateEmoji == null || this.transitionParams.animateOutAnimateEmoji.holders.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void drawOutboundsContent(Canvas canvas) {
        float fDp;
        int extraTextX;
        float f;
        int themedColor;
        float fDp2;
        float fDp3;
        if (!this.enterTransitionInProgress) {
            drawAnimatedEmojis(canvas, 1.0f);
        }
        if (this.currentNameStatusDrawable != null && this.drawNameLayout && this.nameLayout != null) {
            if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                themedColor = getThemedColor(Theme.key_chat_stickerNameText);
                if (this.currentMessageObject.isOutOwner()) {
                    fDp3 = AndroidUtilities.dp(28.0f);
                } else {
                    fDp3 = this.backgroundDrawableLeft + this.transitionParams.deltaLeft + this.backgroundDrawableRight + AndroidUtilities.dp(22.0f);
                }
                fDp2 = this.layoutHeight - AndroidUtilities.dp(38.0f);
                f = fDp3 - this.nameOffsetX;
            } else {
                if (this.mediaBackground || this.currentMessageObject.isOutOwner()) {
                    fDp = this.backgroundDrawableLeft + this.transitionParams.deltaLeft + AndroidUtilities.dp(11.0f);
                    extraTextX = getExtraTextX();
                } else {
                    fDp = this.backgroundDrawableLeft + this.transitionParams.deltaLeft + AndroidUtilities.dp((this.mediaBackground || !this.drawPinnedBottom) ? 17.0f : 11.0f);
                    extraTextX = getExtraTextX();
                }
                f = fDp + extraTextX;
                if (this.currentUser != null) {
                    Theme.MessageDrawable messageDrawable = this.currentBackgroundDrawable;
                    if (messageDrawable != null && messageDrawable.hasGradient()) {
                        themedColor = getThemedColor(Theme.key_chat_messageTextOut);
                    } else {
                        themedColor = getThemedColor(AvatarDrawable.getNameColorNameForId(this.currentUser.id));
                    }
                } else if (this.currentChat != null) {
                    if (this.currentMessageObject.isOutOwner() && ChatObject.isChannel(this.currentChat)) {
                        Theme.MessageDrawable messageDrawable2 = this.currentBackgroundDrawable;
                        if (messageDrawable2 != null && messageDrawable2.hasGradient()) {
                            themedColor = getThemedColor(Theme.key_chat_messageTextOut);
                        } else {
                            themedColor = getThemedColor(Theme.key_chat_outForwardedNameText);
                        }
                    } else if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
                        themedColor = Theme.changeColorAccent(getThemedColor(AvatarDrawable.getNameColorNameForId(5L)));
                    } else if (this.currentMessageObject.isOutOwner()) {
                        themedColor = getThemedColor(Theme.key_chat_outForwardedNameText);
                    } else {
                        themedColor = getThemedColor(AvatarDrawable.getNameColorNameForId(this.currentChat.id));
                    }
                } else {
                    themedColor = getThemedColor(AvatarDrawable.getNameColorNameForId(0L));
                }
                fDp2 = AndroidUtilities.dp(this.drawPinnedTop ? 9.0f : 10.0f);
            }
            MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
            if (groupedMessages != null) {
                MessageObject.GroupedMessages.TransitionParams transitionParams = groupedMessages.transitionParams;
                if (transitionParams.backgroundChangeBounds) {
                    f += transitionParams.offsetLeft;
                    fDp2 += transitionParams.offsetTop - getTranslationY();
                }
            }
            float f2 = f + this.animationOffsetX;
            TransitionParams transitionParams2 = this.transitionParams;
            float f3 = fDp2 + transitionParams2.deltaTop;
            if (transitionParams2.animateSign) {
                f2 = ((f2 - this.transitionParams.animateNameX) * this.transitionParams.animateChangeProgress) + this.transitionParams.animateNameX;
            }
            this.currentNameStatusDrawable.setBounds((int) (Math.abs(f2) + this.nameLayoutWidth + AndroidUtilities.dp(2.0f)), (int) (((this.nameLayout.getHeight() / 2) + f3) - AndroidUtilities.dp(10.0f)), (int) (Math.abs(f2) + this.nameLayoutWidth + AndroidUtilities.dp(22.0f)), (int) (f3 + (this.nameLayout.getHeight() / 2) + AndroidUtilities.dp(10.0f)));
            this.currentNameStatusDrawable.setColor(Integer.valueOf(ColorUtils.setAlphaComponent(themedColor, 115)));
            this.currentNameStatusDrawable.draw(canvas);
        }
        if (!this.transitionParams.transitionBotButtons.isEmpty()) {
            if (this.transitionParams.animateBotButtonsChanged) {
                drawBotButtons(canvas, this.transitionParams.transitionBotButtons, (int) (MathUtils.clamp(1.0f - ((float) Math.pow(r0.animateChangeProgress, 2.0d)), 0.0f, 1.0f) * 255.0f));
            }
        }
        if (!this.botButtons.isEmpty()) {
            ArrayList<BotButton> arrayList = this.botButtons;
            TransitionParams transitionParams3 = this.transitionParams;
            drawBotButtons(canvas, arrayList, transitionParams3.animateBotButtonsChanged ? (int) (transitionParams3.animateChangeProgress * 255.0f) : 255);
        }
        drawSideButton(canvas);
    }

    public void drawAnimatedEmojis(Canvas canvas, float f) {
        drawAnimatedEmojiMessageText(canvas, f);
    }

    private void drawAnimatedEmojiMessageText(Canvas canvas, float f) {
        TransitionParams transitionParams = this.transitionParams;
        if (transitionParams.animateChangeProgress != 1.0f && transitionParams.animateMessageText) {
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
            drawAnimatedEmojiMessageText(canvas, this.transitionParams.animateOutTextBlocks, this.transitionParams.animateOutAnimateEmoji, false, f * (1.0f - this.transitionParams.animateChangeProgress));
            drawAnimatedEmojiMessageText(canvas, this.currentMessageObject.textLayoutBlocks, this.animatedEmojiStack, true, f * this.transitionParams.animateChangeProgress);
            canvas.restore();
            return;
        }
        drawAnimatedEmojiMessageText(canvas, this.currentMessageObject.textLayoutBlocks, this.animatedEmojiStack, true, f);
    }

    private void drawAnimatedEmojiMessageText(Canvas canvas, ArrayList<MessageObject.TextLayoutBlock> arrayList, AnimatedEmojiSpan.EmojiGroupedSpans emojiGroupedSpans, boolean z, float f) {
        int size;
        int i;
        if (arrayList == null || arrayList.isEmpty() || f == 0.0f) {
            return;
        }
        if (z) {
            if (this.fullyDraw) {
                this.firstVisibleBlockNum = 0;
                this.lastVisibleBlockNum = arrayList.size();
            }
            i = this.firstVisibleBlockNum;
            size = this.lastVisibleBlockNum;
        } else {
            size = arrayList.size();
            i = 0;
        }
        int i2 = this.textY;
        float f2 = i2;
        TransitionParams transitionParams = this.transitionParams;
        if (transitionParams.animateText) {
            float f3 = transitionParams.animateFromTextY;
            float f4 = transitionParams.animateChangeProgress;
            f2 = (f3 * (1.0f - f4)) + (i2 * f4);
        }
        float f5 = f2;
        for (int i3 = i; i3 <= size && i3 < arrayList.size(); i3++) {
            if (i3 >= 0) {
                MessageObject.TextLayoutBlock textLayoutBlock = arrayList.get(i3);
                canvas.save();
                canvas.translate(this.textX - (textLayoutBlock.isRtl() ? (int) Math.ceil(this.currentMessageObject.textXOffset) : 0), textLayoutBlock.textYOffset + f5 + this.transitionYOffsetForDrawables);
                float f6 = textLayoutBlock.textYOffset + f5 + this.transitionYOffsetForDrawables;
                boolean z2 = this.transitionParams.messageEntering;
                AnimatedEmojiSpan.drawAnimatedEmojis(canvas, textLayoutBlock.textLayout, emojiGroupedSpans, 0.0f, textLayoutBlock.spoilers, 0.0f, 0.0f, f6, f, Theme.chat_animatedEmojiTextColorFilter);
                canvas.restore();
            }
        }
    }

    public void drawAnimatedEmojiCaption(Canvas canvas, float f) {
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.animateReplaceCaptionLayout || transitionParams.animateChangeProgress == 1.0f) {
            drawAnimatedEmojiCaption(canvas, this.captionLayout, this.animatedEmojiStack, f);
        } else {
            drawAnimatedEmojiCaption(canvas, transitionParams.animateOutCaptionLayout, this.transitionParams.animateOutAnimateEmoji, (1.0f - this.transitionParams.animateChangeProgress) * f);
            drawAnimatedEmojiCaption(canvas, this.captionLayout, this.animatedEmojiStack, f * this.transitionParams.animateChangeProgress);
        }
    }

    private void drawAnimatedEmojiCaption(Canvas canvas, Layout layout, AnimatedEmojiSpan.EmojiGroupedSpans emojiGroupedSpans, float f) {
        float f2;
        float f3;
        if (layout != null) {
            if ((!this.currentMessageObject.deleted || this.currentPosition == null) && f > 0.0f) {
                canvas.save();
                MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
                if (groupedMessages != null) {
                    f *= groupedMessages.transitionParams.captionEnterProgress;
                }
                float f4 = f;
                if (f4 == 0.0f) {
                    return;
                }
                float translationY = this.captionY;
                float f5 = this.captionX;
                TransitionParams transitionParams = this.transitionParams;
                if (transitionParams.animateBackgroundBoundsInner) {
                    if (transitionParams.transformGroupToSingleMessage) {
                        translationY -= getTranslationY();
                        f3 = this.transitionParams.deltaLeft;
                    } else if (transitionParams.moveCaption) {
                        float f6 = this.captionX;
                        TransitionParams transitionParams2 = this.transitionParams;
                        float f7 = transitionParams2.animateChangeProgress;
                        float f8 = (f6 * f7) + (transitionParams2.captionFromX * (1.0f - f7));
                        float f9 = (this.captionY * f7) + (transitionParams2.captionFromY * (1.0f - f7));
                        f5 = f8;
                        f2 = f9;
                    } else {
                        if (!this.currentMessageObject.isVoice() || !TextUtils.isEmpty(this.currentMessageObject.caption)) {
                            f3 = this.transitionParams.deltaLeft;
                        }
                        f2 = translationY;
                    }
                    f5 += f3;
                    f2 = translationY;
                } else {
                    f2 = translationY;
                }
                canvas.translate(f5, f2);
                try {
                    AnimatedEmojiSpan.drawAnimatedEmojis(canvas, layout, emojiGroupedSpans, 0.0f, this.captionSpoilers, 0.0f, 0.0f, f2, f4, Theme.chat_animatedEmojiTextColorFilter);
                } catch (Exception e) {
                    FileLog.e(e);
                }
                canvas.restore();
            }
        }
    }

    private void drawSideButton(Canvas canvas) {
        if (this.drawSideButton != 0) {
            if (this.currentMessageObject.isOutOwner()) {
                float fDp = this.transitionParams.lastBackgroundLeft - AndroidUtilities.dp(40.0f);
                this.sideStartX = fDp;
                MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
                if (groupedMessages != null) {
                    this.sideStartX = fDp + (groupedMessages.transitionParams.offsetLeft - this.animationOffsetX);
                }
            } else {
                float fDp2 = this.transitionParams.lastBackgroundRight + AndroidUtilities.dp(8.0f);
                this.sideStartX = fDp2;
                MessageObject.GroupedMessages groupedMessages2 = this.currentMessagesGroup;
                if (groupedMessages2 != null) {
                    this.sideStartX = fDp2 + (groupedMessages2.transitionParams.offsetRight - this.animationOffsetX);
                }
            }
            float fDp3 = (this.layoutHeight + this.transitionParams.deltaBottom) - AndroidUtilities.dp(41.0f);
            this.sideStartY = fDp3;
            MessageObject messageObject = this.currentMessageObject;
            if (messageObject.type == 19 && messageObject.textWidth < this.timeTextWidth) {
                this.sideStartY = fDp3 - AndroidUtilities.dp(22.0f);
            }
            MessageObject.GroupedMessages groupedMessages3 = this.currentMessagesGroup;
            if (groupedMessages3 != null) {
                float f = this.sideStartY;
                MessageObject.GroupedMessages.TransitionParams transitionParams = groupedMessages3.transitionParams;
                float f2 = f + transitionParams.offsetBottom;
                this.sideStartY = f2;
                if (transitionParams.backgroundChangeBounds) {
                    this.sideStartY = f2 - getTranslationY();
                }
            }
            ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
            if (!reactionsLayoutInBubble.isSmall) {
                if (this.isRoundVideo) {
                    this.sideStartY -= reactionsLayoutInBubble.getCurrentTotalHeight(this.transitionParams.animateChangeProgress) * (1.0f - getVideoTranscriptionProgress());
                } else if (reactionsLayoutInBubble.drawServiceShaderBackground > 0.0f) {
                    this.sideStartY -= reactionsLayoutInBubble.getCurrentTotalHeight(this.transitionParams.animateChangeProgress);
                }
            }
            if (!this.currentMessageObject.isOutOwner() && this.isRoundVideo && !this.hasLinkPreview) {
                float fDp4 = this.isAvatarVisible ? (AndroidUtilities.roundPlayingMessageSize - AndroidUtilities.roundMessageSize) * 0.7f : AndroidUtilities.dp(50.0f);
                float videoTranscriptionProgress = this.isPlayingRound ? (1.0f - getVideoTranscriptionProgress()) * fDp4 : 0.0f;
                float fDp5 = this.isPlayingRound ? AndroidUtilities.dp(28.0f) * (1.0f - getVideoTranscriptionProgress()) : 0.0f;
                TransitionParams transitionParams2 = this.transitionParams;
                if (transitionParams2.animatePlayingRound) {
                    videoTranscriptionProgress = (this.isPlayingRound ? transitionParams2.animateChangeProgress : 1.0f - transitionParams2.animateChangeProgress) * (1.0f - getVideoTranscriptionProgress()) * fDp4;
                    fDp5 = AndroidUtilities.dp(28.0f) * (this.isPlayingRound ? this.transitionParams.animateChangeProgress : 1.0f - this.transitionParams.animateChangeProgress) * (1.0f - getVideoTranscriptionProgress());
                }
                this.sideStartX -= videoTranscriptionProgress;
                this.sideStartY -= fDp5;
            }
            if (this.drawSideButton == 3) {
                if (!this.enterTransitionInProgress || this.currentMessageObject.isVoice()) {
                    drawCommentButton(canvas, 1.0f);
                    return;
                }
                return;
            }
            RectF rectF = this.rect;
            float f3 = this.sideStartX;
            rectF.set(f3, this.sideStartY, AndroidUtilities.dp(32.0f) + f3, this.sideStartY + AndroidUtilities.dp(32.0f));
            applyServiceShaderMatrix();
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), getThemedPaint(this.sideButtonPressed ? "paintChatActionBackgroundSelected" : "paintChatActionBackground"));
            if (hasGradientService()) {
                canvas.drawRoundRect(this.rect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
            if (this.drawSideButton == 2) {
                Drawable themedDrawable = getThemedDrawable("drawableGoIcon");
                if (this.currentMessageObject.isOutOwner()) {
                    BaseCell.setDrawableBounds(themedDrawable, this.sideStartX + AndroidUtilities.dp(10.0f), this.sideStartY + AndroidUtilities.dp(9.0f));
                    canvas.save();
                    canvas.scale(-1.0f, 1.0f, themedDrawable.getBounds().centerX(), themedDrawable.getBounds().centerY());
                } else {
                    BaseCell.setDrawableBounds(themedDrawable, this.sideStartX + AndroidUtilities.dp(12.0f), this.sideStartY + AndroidUtilities.dp(9.0f));
                }
                themedDrawable.draw(canvas);
                if (this.currentMessageObject.isOutOwner()) {
                    canvas.restore();
                    return;
                }
                return;
            }
            Drawable themedDrawable2 = getThemedDrawable("drawableShareIcon");
            BaseCell.setDrawableBounds(themedDrawable2, this.sideStartX + AndroidUtilities.dp(8.0f), this.sideStartY + AndroidUtilities.dp(9.0f));
            themedDrawable2.draw(canvas);
        }
    }

    public void setTimeAlpha(float f) {
        this.timeAlpha = f;
    }

    public float getTimeAlpha() {
        return this.timeAlpha;
    }

    public int getBackgroundDrawableLeft() {
        int iDp;
        int iDp2;
        int i;
        if (this.currentMessageObject.isOutOwner()) {
            if (this.isRoundVideo) {
                return (this.layoutWidth - this.backgroundWidth) - ((int) ((1.0f - getVideoTranscriptionProgress()) * AndroidUtilities.dp(9.0f)));
            }
            return (this.layoutWidth - this.backgroundWidth) - (this.mediaBackground ? AndroidUtilities.dp(9.0f) : 0);
        }
        if (this.isRoundVideo) {
            if (this.isChat && this.isAvatarVisible) {
                i = 48;
            }
            iDp = AndroidUtilities.dp(i + 3) + ((int) (AndroidUtilities.dp(6.0f) * (1.0f - getVideoTranscriptionProgress())));
        } else {
            if (this.isChat && this.isAvatarVisible) {
                i = 48;
            }
            iDp = AndroidUtilities.dp(i + (this.mediaBackground ? 9 : 3));
        }
        MessageObject.GroupedMessages groupedMessages = this.currentMessagesGroup;
        if (groupedMessages != null && !groupedMessages.isDocuments && (i = this.currentPosition.leftSpanOffset) != 0) {
            iDp += (int) Math.ceil((i / 1000.0f) * getGroupPhotosWidth());
        }
        if (this.isRoundVideo) {
            if (!this.drawPinnedBottom) {
                return iDp;
            }
            iDp2 = (int) (AndroidUtilities.dp(6.0f) * (1.0f - getVideoTranscriptionProgress()));
        } else {
            if (this.mediaBackground || !this.drawPinnedBottom) {
                return iDp;
            }
            iDp2 = AndroidUtilities.dp(6.0f);
        }
        return iDp + iDp2;
    }

    public int getBackgroundDrawableRight() {
        int iDp;
        int backgroundDrawableLeft;
        int i = this.backgroundWidth;
        if (this.isRoundVideo) {
            iDp = i - ((int) (getVideoTranscriptionProgress() * AndroidUtilities.dp(3.0f)));
            if (this.drawPinnedBottom && this.currentMessageObject.isOutOwner()) {
                iDp = (int) (iDp - (AndroidUtilities.dp(6.0f) * (1.0f - getVideoTranscriptionProgress())));
            }
            if (this.drawPinnedBottom && !this.currentMessageObject.isOutOwner()) {
                iDp = (int) (iDp - (AndroidUtilities.dp(6.0f) * (1.0f - getVideoTranscriptionProgress())));
            }
            backgroundDrawableLeft = getBackgroundDrawableLeft();
        } else {
            iDp = i - (this.mediaBackground ? 0 : AndroidUtilities.dp(3.0f));
            if (!this.mediaBackground && this.drawPinnedBottom) {
                iDp -= AndroidUtilities.dp(6.0f);
            }
            backgroundDrawableLeft = getBackgroundDrawableLeft();
        }
        return backgroundDrawableLeft + iDp;
    }

    public int getBackgroundDrawableTop() {
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        int iDp = ((groupedMessagePosition == null || (groupedMessagePosition.flags & 4) != 0) ? 0 : 0 - AndroidUtilities.dp(3.0f)) + (this.drawPinnedTop ? 0 : AndroidUtilities.dp(1.0f));
        return (this.mediaBackground || !this.drawPinnedTop) ? iDp : iDp - AndroidUtilities.dp(1.0f);
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
        int backgroundDrawableTop = ((getBackgroundDrawableTop() + this.layoutHeight) - iDp2) + iDp;
        if (this.mediaBackground) {
            return backgroundDrawableTop;
        }
        if (this.drawPinnedTop) {
            backgroundDrawableTop += AndroidUtilities.dp(1.0f);
        }
        return this.drawPinnedBottom ? backgroundDrawableTop + AndroidUtilities.dp(1.0f) : backgroundDrawableTop;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0085 A[PHI: r6 r7
      0x0085: PHI (r6v14 int) = (r6v13 int), (r6v21 int) binds: [B:27:0x0062, B:29:0x0072] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r7v1 int) = (r7v0 int), (r7v11 int) binds: [B:27:0x0062, B:29:0x0072] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawBackground(android.graphics.Canvas r16, int r17, int r18, int r19, int r20, boolean r21, boolean r22, boolean r23, int r24) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawBackground(android.graphics.Canvas, int, int, int, int, boolean, boolean, boolean, int):void");
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
        return this.replyNameLayout != null || this.drawTopic;
    }

    public boolean isDrawNameLayout() {
        return this.drawNameLayout && this.nameLayout != null;
    }

    public boolean isDrawTopic() {
        return this.drawTopic;
    }

    public boolean isAdminLayoutChanged() {
        return !TextUtils.equals(this.lastPostAuthor, this.currentMessageObject.messageOwner.post_author);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0879  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x08e3  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0bb9  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0c83  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x12b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawNamesLayout(android.graphics.Canvas r32, float r33) {
        /*
            Method dump skipped, instructions count: 4801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawNamesLayout(android.graphics.Canvas, float):void");
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

    public void setDrawSelectionBackground(boolean z) {
        if (this.drawSelectionBackground != z) {
            this.drawSelectionBackground = z;
            invalidate();
        }
    }

    public boolean isDrawingSelectionBackground() {
        return this.drawSelectionBackground || this.isHighlightedAnimated || this.isHighlighted;
    }

    public float getHighlightAlpha() {
        int i;
        if (this.drawSelectionBackground || !this.isHighlightedAnimated || (i = this.highlightProgress) >= 300) {
            return 1.0f;
        }
        return i / 300.0f;
    }

    public void setCheckBoxVisible(boolean z, boolean z2) {
        MessageObject.GroupedMessages groupedMessages;
        MessageObject.GroupedMessages groupedMessages2;
        if (z && this.checkBox == null) {
            CheckBoxBase checkBoxBase = new CheckBoxBase(this, 21, this.resourcesProvider);
            this.checkBox = checkBoxBase;
            if (this.attachedToWindow) {
                checkBoxBase.onAttachedToWindow();
            }
        }
        if (z && ((((groupedMessages = this.currentMessagesGroup) != null && groupedMessages.messages.size() > 1) || ((groupedMessages2 = this.groupedMessagesToSet) != null && groupedMessages2.messages.size() > 1)) && this.mediaCheckBox == null)) {
            CheckBoxBase checkBoxBase2 = new CheckBoxBase(this, 21, this.resourcesProvider);
            this.mediaCheckBox = checkBoxBase2;
            checkBoxBase2.setUseDefaultCheck(true);
            if (this.attachedToWindow) {
                this.mediaCheckBox.onAttachedToWindow();
            }
        }
        if (this.checkBoxVisible == z) {
            if (z2 == this.checkBoxAnimationInProgress || z2) {
                return;
            }
            this.checkBoxAnimationProgress = z ? 1.0f : 0.0f;
            invalidate();
            return;
        }
        this.checkBoxAnimationInProgress = z2;
        this.checkBoxVisible = z;
        if (z2) {
            this.lastCheckBoxAnimationTime = SystemClock.elapsedRealtime();
        } else {
            this.checkBoxAnimationProgress = z ? 1.0f : 0.0f;
        }
        invalidate();
    }

    public void setChecked(boolean z, boolean z2, boolean z3) {
        CheckBoxBase checkBoxBase = this.checkBox;
        if (checkBoxBase != null) {
            checkBoxBase.setChecked(z2, z3);
        }
        CheckBoxBase checkBoxBase2 = this.mediaCheckBox;
        if (checkBoxBase2 != null) {
            checkBoxBase2.setChecked(z, z3);
        }
        this.backgroundDrawable.setSelected(z2, z3);
    }

    public void setLastTouchCoords(float f, float f2) {
        this.lastTouchX = f;
        this.lastTouchY = f2;
        this.backgroundDrawable.setTouchCoords(f + getTranslationX(), this.lastTouchY);
    }

    public MessageBackgroundDrawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    public Theme.MessageDrawable getCurrentBackgroundDrawable(boolean z) {
        if (z) {
            MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
            boolean z2 = groupedMessagePosition != null && (groupedMessagePosition.flags & 8) == 0 && this.currentMessagesGroup.isDocuments && !this.drawPinnedBottom;
            if (this.currentMessageObject.isOutOwner()) {
                if (!this.mediaBackground && !this.drawPinnedBottom && !z2) {
                    this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgOut");
                } else {
                    this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgOutMedia");
                }
            } else if (!this.mediaBackground && !this.drawPinnedBottom && !z2) {
                this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgIn");
            } else {
                this.currentBackgroundDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgInMedia");
            }
        }
        this.currentBackgroundDrawable.getBackgroundDrawable();
        return this.currentBackgroundDrawable;
    }

    private boolean shouldDrawCaptionLayout() {
        MessageObject.GroupedMessagePosition groupedMessagePosition;
        MessageObject.GroupedMessages groupedMessages;
        MessageObject messageObject = this.currentMessageObject;
        return (messageObject.preview || ((groupedMessagePosition = this.currentPosition) != null && ((groupedMessages = this.currentMessagesGroup) == null || !groupedMessages.isDocuments || (groupedMessagePosition.flags & 8) != 0)) || this.transitionParams.animateBackgroundBoundsInner || (this.enterTransitionInProgress && messageObject.isVoice())) ? false : true;
    }

    public void drawCaptionLayout(Canvas canvas, boolean z, float f) {
        if (this.animatedEmojiStack != null && (this.captionLayout != null || this.transitionParams.animateOutCaptionLayout != null)) {
            this.animatedEmojiStack.clearPositions();
        }
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.animateReplaceCaptionLayout || transitionParams.animateChangeProgress == 1.0f) {
            drawCaptionLayout(canvas, this.captionLayout, z, f);
        } else {
            drawCaptionLayout(canvas, transitionParams.animateOutCaptionLayout, z, (1.0f - this.transitionParams.animateChangeProgress) * f);
            drawCaptionLayout(canvas, this.captionLayout, z, this.transitionParams.animateChangeProgress * f);
        }
        if (!z) {
            drawAnimatedEmojiCaption(canvas, f);
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && messageObject.messageOwner != null && messageObject.isVoiceTranscriptionOpen()) {
            MessageObject messageObject2 = this.currentMessageObject;
            if (!messageObject2.messageOwner.voiceTranscriptionFinal && TranscribeButton.isTranscribing(messageObject2)) {
                invalidate();
            }
        }
        if (this.isRoundVideo) {
            this.reactionsLayoutInBubble.drawServiceShaderBackground = 1.0f - getVideoTranscriptionProgress();
        }
        if (z) {
            return;
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if (groupedMessagePosition != null) {
            int i = groupedMessagePosition.flags;
            if ((i & 8) == 0 || (i & 1) == 0) {
                return;
            }
        }
        ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
        if (reactionsLayoutInBubble.isSmall) {
            return;
        }
        if (reactionsLayoutInBubble.drawServiceShaderBackground > 0.0f) {
            applyServiceShaderMatrix();
        }
        if (getAlpha() != 1.0f) {
            RectF rectF = AndroidUtilities.rectTmp;
            rectF.set(0.0f, 0.0f, getWidth(), getHeight());
            canvas.saveLayerAlpha(rectF, (int) (getAlpha() * 255.0f), 31);
        }
        ReactionsLayoutInBubble reactionsLayoutInBubble2 = this.reactionsLayoutInBubble;
        if (reactionsLayoutInBubble2.drawServiceShaderBackground > 0.0f || !this.transitionParams.animateBackgroundBoundsInner || this.currentPosition != null || this.isRoundVideo) {
            TransitionParams transitionParams2 = this.transitionParams;
            reactionsLayoutInBubble2.draw(canvas, transitionParams2.animateChange ? transitionParams2.animateChangeProgress : 1.0f, null);
        } else {
            canvas.save();
            canvas.clipRect(0.0f, 0.0f, getMeasuredWidth(), getBackgroundDrawableBottom() + this.transitionParams.deltaBottom);
            ReactionsLayoutInBubble reactionsLayoutInBubble3 = this.reactionsLayoutInBubble;
            TransitionParams transitionParams3 = this.transitionParams;
            reactionsLayoutInBubble3.draw(canvas, transitionParams3.animateChange ? transitionParams3.animateChangeProgress : 1.0f, null);
            canvas.restore();
        }
        if (getAlpha() != 1.0f) {
            canvas.restore();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0586  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05d5  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawCaptionLayout(android.graphics.Canvas r28, android.text.StaticLayout r29, boolean r30, float r31) {
        /*
            Method dump skipped, instructions count: 2799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawCaptionLayout(android.graphics.Canvas, android.text.StaticLayout, boolean, float):void");
    }

    public void drawProgressLoadingLink(Canvas canvas, int i) {
        updateProgressLoadingLink();
        ArrayList<LoadingDrawableLocation> arrayList = this.progressLoadingLinkDrawables;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        MessageObject messageObject = this.currentMessageObject;
        int themedColor = getThemedColor((messageObject == null || !messageObject.isOutOwner()) ? Theme.key_chat_linkSelectBackground : Theme.key_chat_outLinkSelectBackground);
        int i2 = 0;
        while (i2 < this.progressLoadingLinkDrawables.size()) {
            LoadingDrawableLocation loadingDrawableLocation = this.progressLoadingLinkDrawables.get(i2);
            if (loadingDrawableLocation.blockNum == i) {
                LoadingDrawable loadingDrawable = loadingDrawableLocation.drawable;
                loadingDrawable.setColors(Theme.multAlpha(themedColor, 0.85f), Theme.multAlpha(themedColor, 2.0f), Theme.multAlpha(themedColor, 3.5f), Theme.multAlpha(themedColor, 6.0f));
                loadingDrawable.draw(canvas);
                invalidate();
                if (loadingDrawable.isDisappeared()) {
                    this.progressLoadingLinkDrawables.remove(i2);
                    i2--;
                }
            }
            i2++;
        }
    }

    public void updateProgressLoadingLink() {
        StaticLayout staticLayout;
        ArrayList<MessageObject.TextLayoutBlock> arrayList;
        ChatMessageCellDelegate chatMessageCellDelegate = this.delegate;
        if (chatMessageCellDelegate == null) {
            return;
        }
        if (!chatMessageCellDelegate.isProgressLoading(this, 1)) {
            this.progressLoadingLink = null;
            ArrayList<LoadingDrawableLocation> arrayList2 = this.progressLoadingLinkDrawables;
            if (arrayList2 == null || arrayList2.isEmpty()) {
                return;
            }
            for (int i = 0; i < this.progressLoadingLinkDrawables.size(); i++) {
                LoadingDrawableLocation loadingDrawableLocation = this.progressLoadingLinkDrawables.get(i);
                if (!loadingDrawableLocation.drawable.isDisappearing()) {
                    loadingDrawableLocation.drawable.disappear();
                }
            }
            return;
        }
        CharacterStyle progressLoadingLink = this.delegate.getProgressLoadingLink(this);
        if (progressLoadingLink == this.progressLoadingLink) {
            return;
        }
        this.progressLoadingLink = progressLoadingLink;
        LoadingDrawable loadingDrawable = this.progressLoadingLinkCurrentDrawable;
        if (loadingDrawable != null) {
            loadingDrawable.disappear();
            this.progressLoadingLinkCurrentDrawable = null;
        }
        LoadingDrawable loadingDrawable2 = new LoadingDrawable();
        this.progressLoadingLinkCurrentDrawable = loadingDrawable2;
        loadingDrawable2.setAppearByGradient(true);
        LinkPath linkPath = new LinkPath(true);
        this.progressLoadingLinkCurrentDrawable.usePath(linkPath);
        this.progressLoadingLinkCurrentDrawable.setRadiiDp(5.0f);
        LoadingDrawableLocation loadingDrawableLocation2 = new LoadingDrawableLocation(this);
        loadingDrawableLocation2.drawable = this.progressLoadingLinkCurrentDrawable;
        loadingDrawableLocation2.blockNum = -3;
        if (this.progressLoadingLinkDrawables == null) {
            this.progressLoadingLinkDrawables = new ArrayList<>();
        }
        this.progressLoadingLinkDrawables.add(loadingDrawableLocation2);
        if (this.progressLoadingLink != null) {
            MessageObject messageObject = this.currentMessageObject;
            int iMax = Math.max(0, (messageObject == null || (arrayList = messageObject.textLayoutBlocks) == null) ? 0 : arrayList.size());
            for (int i2 = -2; i2 < iMax; i2++) {
                float f = 0.0f;
                if (i2 == -2) {
                    staticLayout = this.descriptionLayout;
                } else if (i2 == -1) {
                    staticLayout = this.captionLayout;
                } else {
                    StaticLayout staticLayout2 = this.currentMessageObject.textLayoutBlocks.get(i2).textLayout;
                    f = this.currentMessageObject.textLayoutBlocks.get(i2).textYOffset;
                    staticLayout = staticLayout2;
                }
                if (staticLayout != null && (staticLayout.getText() instanceof Spanned)) {
                    Spanned spanned = (Spanned) staticLayout.getText();
                    CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class);
                    if (characterStyleArr != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= characterStyleArr.length) {
                                break;
                            }
                            if (characterStyleArr[i3] == this.progressLoadingLink) {
                                loadingDrawableLocation2.blockNum = i2;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (loadingDrawableLocation2.blockNum == i2) {
                        linkPath.rewind();
                        int spanStart = spanned.getSpanStart(this.progressLoadingLink);
                        int spanEnd = spanned.getSpanEnd(this.progressLoadingLink);
                        linkPath.setCurrentLayout(staticLayout, spanStart, f);
                        staticLayout.getSelectionPath(spanStart, spanEnd, linkPath);
                        this.progressLoadingLinkCurrentDrawable.updateBounds();
                        return;
                    }
                }
            }
        }
    }

    public boolean needDrawTime() {
        return !this.forceNotDrawTime;
    }

    public boolean shouldDrawTimeOnMedia() {
        int i = this.overideShouldDrawTimeOnMedia;
        if (i != 0) {
            return i == 1;
        }
        if (!this.mediaBackground || this.captionLayout != null) {
            return false;
        }
        ReactionsLayoutInBubble reactionsLayoutInBubble = this.reactionsLayoutInBubble;
        return reactionsLayoutInBubble.isEmpty || reactionsLayoutInBubble.isSmall || this.currentMessageObject.isAnyKindOfSticker() || this.currentMessageObject.isRoundVideo();
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
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawTime(android.graphics.Canvas, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:335:0x0749  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawTimeInternal(android.graphics.Canvas r40, float r41, boolean r42, float r43, android.text.StaticLayout r44, float r45, boolean r46) {
        /*
            Method dump skipped, instructions count: 2753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawTimeInternal(android.graphics.Canvas, float, boolean, float, android.text.StaticLayout, float, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createStatusDrawableAnimator(int i, int i2, final boolean z) {
        boolean z2 = false;
        boolean z3 = (i2 & 1) != 0;
        boolean z4 = (i2 & 2) != 0;
        boolean z5 = (i & 1) != 0;
        boolean z6 = (i & 2) != 0;
        if (!((i & 4) != 0) && z6 && z4 && !z5 && z3) {
            z2 = true;
        }
        if (!this.transitionParams.messageEntering || z2) {
            this.statusDrawableProgress = 0.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.statusDrawableAnimator = valueAnimatorOfFloat;
            if (z2) {
                valueAnimatorOfFloat.setDuration(220L);
            } else {
                valueAnimatorOfFloat.setDuration(150L);
            }
            this.statusDrawableAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.animateFromStatusDrawableParams = i;
            this.animateToStatusDrawableParams = i2;
            this.statusDrawableAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.ChatMessageCell$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$createStatusDrawableAnimator$13(z, valueAnimator);
                }
            });
            this.statusDrawableAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.ChatMessageCell.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int iCreateStatusDrawableParams = ChatMessageCell.this.transitionParams.createStatusDrawableParams();
                    if (ChatMessageCell.this.animateToStatusDrawableParams == iCreateStatusDrawableParams) {
                        ChatMessageCell.this.statusDrawableAnimationInProgress = false;
                        ChatMessageCell.this.transitionParams.lastStatusDrawableParams = ChatMessageCell.this.animateToStatusDrawableParams;
                    } else {
                        ChatMessageCell chatMessageCell = ChatMessageCell.this;
                        chatMessageCell.createStatusDrawableAnimator(chatMessageCell.animateToStatusDrawableParams, iCreateStatusDrawableParams, z);
                    }
                }
            });
            this.statusDrawableAnimationInProgress = true;
            this.statusDrawableAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createStatusDrawableAnimator$13(boolean z, ValueAnimator valueAnimator) {
        this.statusDrawableProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
        if (!z || getParent() == null) {
            return;
        }
        ((View) getParent()).invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawClockOrErrorLayout(android.graphics.Canvas r7, boolean r8, boolean r9, float r10, float r11, float r12, float r13, float r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawClockOrErrorLayout(android.graphics.Canvas, boolean, boolean, float, float, float, float, float, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawViewsAndRepliesLayout(android.graphics.Canvas r25, float r26, float r27, float r28, float r29, float r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 1226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawViewsAndRepliesLayout(android.graphics.Canvas, float, float, float, float, float, boolean):void");
    }

    private void drawStatusDrawable(Canvas canvas, boolean z, boolean z2, boolean z3, boolean z4, float f, boolean z5, float f2, float f3, float f4, boolean z6, boolean z7) {
        float imageY2;
        int iDp;
        int iDp2;
        Drawable themedDrawable;
        Drawable themedDrawable2;
        int themedColor;
        boolean z8 = (f4 == 1.0f || z6) ? false : true;
        float f5 = (f4 * 0.5f) + 0.5f;
        float f6 = z8 ? f * f4 : f;
        if (this.documentAttachType == 7) {
            imageY2 = f3 - ((AndroidUtilities.dp(this.drawPinnedBottom ? 4.0f : 5.0f) + this.reactionsLayoutInBubble.getCurrentTotalHeight(this.transitionParams.animateChangeProgress)) * (1.0f - getVideoTranscriptionProgress()));
        } else {
            imageY2 = this.photoImage.getImageY2() + this.additionalTimeOffsetY;
        }
        float fDp = imageY2 - AndroidUtilities.dp(8.5f);
        if (z3) {
            MsgClockDrawable msgClockDrawable = Theme.chat_msgClockDrawable;
            if (shouldDrawTimeOnMedia()) {
                if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                    themedColor = getThemedColor(Theme.key_chat_serviceText);
                    BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(z5 ? 24.0f : 22.0f)) - msgClockDrawable.getIntrinsicWidth(), (fDp - msgClockDrawable.getIntrinsicHeight()) + f2);
                    msgClockDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f6));
                } else {
                    themedColor = getThemedColor(Theme.key_chat_mediaSentClock);
                    BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(z5 ? 24.0f : 22.0f)) - msgClockDrawable.getIntrinsicWidth(), (fDp - msgClockDrawable.getIntrinsicHeight()) + f2);
                    msgClockDrawable.setAlpha((int) (f6 * 255.0f));
                }
            } else {
                int themedColor2 = getThemedColor(Theme.key_chat_outSentClock);
                BaseCell.setDrawableBounds(msgClockDrawable, (this.layoutWidth - AndroidUtilities.dp(18.5f)) - msgClockDrawable.getIntrinsicWidth(), ((f3 - AndroidUtilities.dp(8.5f)) - msgClockDrawable.getIntrinsicHeight()) + f2);
                msgClockDrawable.setAlpha((int) (f6 * 255.0f));
                themedColor = themedColor2;
            }
            msgClockDrawable.setColor(themedColor);
            if (z8) {
                canvas.save();
                canvas.scale(f5, f5, msgClockDrawable.getBounds().centerX(), msgClockDrawable.getBounds().centerY());
            }
            msgClockDrawable.draw(canvas);
            msgClockDrawable.setAlpha(255);
            if (z8) {
                canvas.restore();
            }
            invalidate();
        }
        float f7 = 9.0f;
        if (z2) {
            if (shouldDrawTimeOnMedia()) {
                if (z6) {
                    canvas.save();
                }
                if (this.currentMessageObject.shouldDrawWithoutBackground()) {
                    themedDrawable2 = getThemedDrawable("drawableMsgStickerCheck");
                    if (z) {
                        if (z6) {
                            canvas.translate(AndroidUtilities.dp(4.8f) * (1.0f - f4), 0.0f);
                        }
                        BaseCell.setDrawableBounds(themedDrawable2, (this.layoutWidth - AndroidUtilities.dp(z5 ? 28.3f : 26.3f)) - themedDrawable2.getIntrinsicWidth(), (fDp - themedDrawable2.getIntrinsicHeight()) + f2);
                    } else {
                        BaseCell.setDrawableBounds(themedDrawable2, (this.layoutWidth - AndroidUtilities.dp(z5 ? 23.5f : 21.5f)) - themedDrawable2.getIntrinsicWidth(), (fDp - themedDrawable2.getIntrinsicHeight()) + f2);
                    }
                    themedDrawable2.setAlpha((int) (this.timeAlpha * 255.0f * f6));
                } else {
                    if (z) {
                        if (z6) {
                            canvas.translate(AndroidUtilities.dp(4.8f) * (1.0f - f4), 0.0f);
                        }
                        BaseCell.setDrawableBounds(Theme.chat_msgMediaCheckDrawable, (this.layoutWidth - AndroidUtilities.dp(z5 ? 28.3f : 26.3f)) - Theme.chat_msgMediaCheckDrawable.getIntrinsicWidth(), (fDp - Theme.chat_msgMediaCheckDrawable.getIntrinsicHeight()) + f2);
                    } else {
                        BaseCell.setDrawableBounds(Theme.chat_msgMediaCheckDrawable, (this.layoutWidth - AndroidUtilities.dp(z5 ? 23.5f : 21.5f)) - Theme.chat_msgMediaCheckDrawable.getIntrinsicWidth(), (fDp - Theme.chat_msgMediaCheckDrawable.getIntrinsicHeight()) + f2);
                    }
                    Theme.chat_msgMediaCheckDrawable.setAlpha((int) (this.timeAlpha * 255.0f * f6));
                    themedDrawable2 = Theme.chat_msgMediaCheckDrawable;
                }
                if (z8) {
                    canvas.save();
                    canvas.scale(f5, f5, themedDrawable2.getBounds().centerX(), themedDrawable2.getBounds().centerY());
                }
                themedDrawable2.draw(canvas);
                if (z8) {
                    canvas.restore();
                }
                if (z6) {
                    canvas.restore();
                }
                themedDrawable2.setAlpha(255);
            } else {
                if (z6) {
                    canvas.save();
                }
                if (z) {
                    if (z6) {
                        canvas.translate(AndroidUtilities.dp(4.0f) * (1.0f - f4), 0.0f);
                    }
                    themedDrawable = getThemedDrawable(z7 ? "drawableMsgOutCheckReadSelected" : "drawableMsgOutCheckRead");
                    BaseCell.setDrawableBounds(themedDrawable, (this.layoutWidth - AndroidUtilities.dp(22.5f)) - themedDrawable.getIntrinsicWidth(), ((f3 - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.0f : 8.0f)) - themedDrawable.getIntrinsicHeight()) + f2);
                } else {
                    themedDrawable = getThemedDrawable(z7 ? "drawableMsgOutCheckSelected" : "drawableMsgOutCheck");
                    BaseCell.setDrawableBounds(themedDrawable, (this.layoutWidth - AndroidUtilities.dp(18.5f)) - themedDrawable.getIntrinsicWidth(), ((f3 - AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 9.0f : 8.0f)) - themedDrawable.getIntrinsicHeight()) + f2);
                }
                themedDrawable.setAlpha((int) (f6 * 255.0f));
                if (z8) {
                    canvas.save();
                    canvas.scale(f5, f5, themedDrawable.getBounds().centerX(), themedDrawable.getBounds().centerY());
                }
                themedDrawable.draw(canvas);
                if (z8) {
                    canvas.restore();
                }
                if (z6) {
                    canvas.restore();
                }
                themedDrawable.setAlpha(255);
            }
        }
        if (z) {
            if (shouldDrawTimeOnMedia()) {
                Drawable themedDrawable3 = this.currentMessageObject.shouldDrawWithoutBackground() ? getThemedDrawable("drawableMsgStickerHalfCheck") : Theme.chat_msgMediaHalfCheckDrawable;
                BaseCell.setDrawableBounds(themedDrawable3, (this.layoutWidth - AndroidUtilities.dp(z5 ? 23.5f : 21.5f)) - themedDrawable3.getIntrinsicWidth(), (fDp - themedDrawable3.getIntrinsicHeight()) + f2);
                themedDrawable3.setAlpha((int) (this.timeAlpha * 255.0f * f6));
                if (z8 || z6) {
                    canvas.save();
                    canvas.scale(f5, f5, themedDrawable3.getBounds().centerX(), themedDrawable3.getBounds().centerY());
                }
                themedDrawable3.draw(canvas);
                if (z8 || z6) {
                    canvas.restore();
                }
                themedDrawable3.setAlpha(255);
            } else {
                Drawable themedDrawable4 = getThemedDrawable(z7 ? "drawableMsgOutHalfCheckSelected" : "drawableMsgOutHalfCheck");
                float fDp2 = (this.layoutWidth - AndroidUtilities.dp(18.0f)) - themedDrawable4.getIntrinsicWidth();
                if (!this.pinnedBottom && !this.pinnedTop) {
                    f7 = 8.0f;
                }
                BaseCell.setDrawableBounds(themedDrawable4, fDp2, ((f3 - AndroidUtilities.dp(f7)) - themedDrawable4.getIntrinsicHeight()) + f2);
                themedDrawable4.setAlpha((int) (f6 * 255.0f));
                if (z8 || z6) {
                    canvas.save();
                    canvas.scale(f5, f5, themedDrawable4.getBounds().centerX(), themedDrawable4.getBounds().centerY());
                }
                themedDrawable4.draw(canvas);
                if (z8 || z6) {
                    canvas.restore();
                }
                themedDrawable4.setAlpha(255);
            }
        }
        if (z4) {
            if (shouldDrawTimeOnMedia()) {
                iDp = this.layoutWidth - AndroidUtilities.dp(34.5f);
                iDp2 = AndroidUtilities.dp(26.5f);
            } else {
                iDp = this.layoutWidth - AndroidUtilities.dp(32.0f);
                iDp2 = AndroidUtilities.dp((this.pinnedBottom || this.pinnedTop) ? 22.0f : 21.0f);
            }
            float f8 = (f3 - iDp2) + f2;
            this.rect.set(iDp, f8, AndroidUtilities.dp(14.0f) + iDp, AndroidUtilities.dp(14.0f) + f8);
            int alpha = Theme.chat_msgErrorPaint.getAlpha();
            Theme.chat_msgErrorPaint.setAlpha((int) (alpha * f6));
            canvas.drawRoundRect(this.rect, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), Theme.chat_msgErrorPaint);
            Theme.chat_msgErrorPaint.setAlpha(alpha);
            BaseCell.setDrawableBounds(Theme.chat_msgErrorDrawable, iDp + AndroidUtilities.dp(6.0f), f8 + AndroidUtilities.dp(2.0f));
            Theme.chat_msgErrorDrawable.setAlpha((int) (f6 * 255.0f));
            if (z8) {
                canvas.save();
                canvas.scale(f5, f5, Theme.chat_msgErrorDrawable.getBounds().centerX(), Theme.chat_msgErrorDrawable.getBounds().centerY());
            }
            Theme.chat_msgErrorDrawable.draw(canvas);
            Theme.chat_msgErrorDrawable.setAlpha(255);
            if (z8) {
                canvas.restore();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:1002:0x19c5  */
    /* JADX WARN: Removed duplicated region for block: B:1014:0x19ea  */
    /* JADX WARN: Removed duplicated region for block: B:1060:0x1b07  */
    /* JADX WARN: Removed duplicated region for block: B:1062:0x1b0e  */
    /* JADX WARN: Removed duplicated region for block: B:1180:0x1dcc  */
    /* JADX WARN: Removed duplicated region for block: B:1229:0x1406 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x065a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0868  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x08dd  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x090b  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x09bf  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x09d7  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0a4e  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0a5c  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0a62  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0a67  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0a97  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0aa4  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0e68  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0f10  */
    /* JADX WARN: Removed duplicated region for block: B:641:0x11d0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:682:0x12f9  */
    /* JADX WARN: Removed duplicated region for block: B:691:0x133b  */
    /* JADX WARN: Removed duplicated region for block: B:697:0x1364  */
    /* JADX WARN: Removed duplicated region for block: B:698:0x136b  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x1383  */
    /* JADX WARN: Removed duplicated region for block: B:711:0x13bb  */
    /* JADX WARN: Removed duplicated region for block: B:716:0x140a  */
    /* JADX WARN: Removed duplicated region for block: B:754:0x14da  */
    /* JADX WARN: Removed duplicated region for block: B:916:0x17cf  */
    /* JADX WARN: Removed duplicated region for block: B:920:0x17e8  */
    /* JADX WARN: Removed duplicated region for block: B:928:0x1809  */
    /* JADX WARN: Removed duplicated region for block: B:932:0x1820  */
    /* JADX WARN: Removed duplicated region for block: B:948:0x1851  */
    /* JADX WARN: Removed duplicated region for block: B:954:0x185f  */
    /* JADX WARN: Removed duplicated region for block: B:958:0x1870  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawOverlays(android.graphics.Canvas r29) {
        /*
            Method dump skipped, instructions count: 7985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.drawOverlays(android.graphics.Canvas):void");
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
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

    public float getVideoTranscriptionProgress() {
        MessageObject messageObject;
        if (this.transitionParams == null || (messageObject = this.currentMessageObject) == null || !messageObject.isRoundVideo()) {
            return 1.0f;
        }
        TransitionParams transitionParams = this.transitionParams;
        if (!transitionParams.animateDrawBackground) {
            return this.drawBackground ? 1.0f : 0.0f;
        }
        if (this.drawBackground) {
            return transitionParams.animateChangeProgress;
        }
        return 1.0f - transitionParams.animateChangeProgress;
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
    public boolean performAccessibilityAction(int i, Bundle bundle) throws SAXException, IOException {
        ChatMessageCellDelegate chatMessageCellDelegate;
        ChatMessageCellDelegate chatMessageCellDelegate2 = this.delegate;
        if (chatMessageCellDelegate2 != null && chatMessageCellDelegate2.onAccessibilityAction(i, bundle)) {
            return false;
        }
        if (i == 16) {
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
        if (i == ir.medu.shad.R.id.acc_action_small_button) {
            didPressMiniButton(true);
        } else if (i == ir.medu.shad.R.id.acc_action_msg_options) {
            ChatMessageCellDelegate chatMessageCellDelegate3 = this.delegate;
            if (chatMessageCellDelegate3 != null) {
                if (this.currentMessageObject.type == 16) {
                    chatMessageCellDelegate3.didLongPress(this, 0.0f, 0.0f);
                } else {
                    chatMessageCellDelegate3.didPressOther(this, this.otherX, this.otherY);
                }
            }
        } else if (i == ir.medu.shad.R.id.acc_action_open_forwarded_origin && (chatMessageCellDelegate = this.delegate) != null) {
            TLRPC$Chat tLRPC$Chat = this.currentForwardChannel;
            if (tLRPC$Chat != null) {
                chatMessageCellDelegate.didPressChannelAvatar(this, tLRPC$Chat, this.currentMessageObject.messageOwner.fwd_from.channel_post, this.lastTouchX, this.lastTouchY);
            } else {
                TLRPC$User tLRPC$User = this.currentForwardUser;
                if (tLRPC$User != null) {
                    chatMessageCellDelegate.didPressUserAvatar(this, tLRPC$User, this.lastTouchX, this.lastTouchY);
                } else if (this.currentForwardName != null) {
                    chatMessageCellDelegate.didPressHiddenForward(this);
                }
            }
        }
        if ((this.currentMessageObject.isVoice() || this.currentMessageObject.isRoundVideo() || (this.currentMessageObject.isMusic() && MediaController.getInstance().isPlayingMessage(this.currentMessageObject))) && this.seekBarAccessibilityDelegate.performAccessibilityActionInternal(i, bundle)) {
            return true;
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void setAnimationRunning(boolean z, boolean z2) {
        this.animationRunning = z;
        if (z) {
            this.willRemoved = z2;
        } else {
            this.willRemoved = false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
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
        } else if (motionEvent.getAction() == 10) {
            this.currentFocusedVirtualView = 0;
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return new MessageAccessibilityNodeProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEventForVirtualView(int i, int i2) {
        sendAccessibilityEventForVirtualView(i, i2, null);
    }

    private void sendAccessibilityEventForVirtualView(int i, int i2, String str) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isTouchExplorationEnabled()) {
            AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            accessibilityEventObtain.setPackageName(getContext().getPackageName());
            accessibilityEventObtain.setSource(this, i);
            if (str != null) {
                accessibilityEventObtain.getText().add(str);
            }
            if (getParent() != null) {
                getParent().requestSendAccessibilityEvent(this, accessibilityEventObtain);
            }
        }
    }

    public static Point getMessageSize(int i, int i2) {
        return getMessageSize(i, i2, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.rbmain.ui.Components.Point getMessageSize(int r3, int r4, int r5, int r6) {
        /*
            if (r6 == 0) goto L4
            if (r5 != 0) goto L50
        L4:
            boolean r5 = org.rbmain.messenger.AndroidUtilities.isTablet()
            r6 = 1060320051(0x3f333333, float:0.7)
            if (r5 == 0) goto L16
            int r5 = org.rbmain.messenger.AndroidUtilities.getMinTabletSide()
        L11:
            float r5 = (float) r5
            float r5 = r5 * r6
            int r5 = (int) r5
            goto L35
        L16:
            if (r3 < r4) goto L2a
            android.graphics.Point r5 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r6 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r6, r5)
            r6 = 1115684864(0x42800000, float:64.0)
            int r6 = org.rbmain.messenger.AndroidUtilities.dp(r6)
            int r5 = r5 - r6
            goto L35
        L2a:
            android.graphics.Point r5 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r0 = r5.x
            int r5 = r5.y
            int r5 = java.lang.Math.min(r0, r5)
            goto L11
        L35:
            r6 = 1120403456(0x42c80000, float:100.0)
            int r6 = org.rbmain.messenger.AndroidUtilities.dp(r6)
            int r6 = r6 + r5
            int r0 = org.rbmain.messenger.AndroidUtilities.getPhotoSize()
            if (r5 <= r0) goto L46
            int r5 = org.rbmain.messenger.AndroidUtilities.getPhotoSize()
        L46:
            int r0 = org.rbmain.messenger.AndroidUtilities.getPhotoSize()
            if (r6 <= r0) goto L50
            int r6 = org.rbmain.messenger.AndroidUtilities.getPhotoSize()
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
            int r1 = org.rbmain.messenger.AndroidUtilities.dp(r2)
        L63:
            if (r0 != 0) goto L69
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r2)
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
            int r2 = org.rbmain.messenger.AndroidUtilities.dp(r6)
            if (r0 >= r2) goto L87
            int r6 = org.rbmain.messenger.AndroidUtilities.dp(r6)
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
            org.rbmain.ui.Components.Point r3 = new org.rbmain.ui.Components.Point
            float r4 = (float) r1
            float r5 = (float) r6
            r3.<init>(r4, r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.getMessageSize(int, int, int, int):org.rbmain.ui.Components.Point");
    }

    public StaticLayout getDescriptionlayout() {
        return this.descriptionLayout;
    }

    public void setSelectedBackgroundProgress(float f) {
        this.selectedBackgroundProgress = f;
        invalidate();
    }

    public int computeHeight(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages) throws SAXException, IOException {
        this.photoImage.setIgnoreImageSet(true);
        this.avatarImage.setIgnoreImageSet(true);
        this.replyImageReceiver.setIgnoreImageSet(true);
        this.locationImageReceiver.setIgnoreImageSet(true);
        if (groupedMessages != null && groupedMessages.messages.size() != 1) {
            int i = 0;
            for (int i2 = 0; i2 < groupedMessages.messages.size(); i2++) {
                MessageObject messageObject2 = groupedMessages.messages.get(i2);
                MessageObject.GroupedMessagePosition groupedMessagePosition = groupedMessages.positions.get(messageObject2);
                if (groupedMessagePosition != null && (groupedMessagePosition.flags & 1) != 0) {
                    setMessageContent(messageObject2, groupedMessages, false, false);
                    i += this.totalHeight + this.keyboardHeight;
                }
            }
            return i;
        }
        setMessageContent(messageObject, groupedMessages, false, false);
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

    public void setSlidingOffset(float f) {
        if (this.slidingOffsetX != f) {
            this.slidingOffsetX = f;
            updateTranslation();
        }
    }

    public void setAnimationOffsetX(float f) {
        if (this.animationOffsetX != f) {
            this.animationOffsetX = f;
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

    public float getNonAnimationTranslationX(boolean z) {
        boolean z2;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && !messageObject.isOutOwner()) {
            if (z && ((z2 = this.checkBoxVisible) || this.checkBoxAnimationInProgress)) {
                this.checkBoxTranslation = (int) Math.ceil((z2 ? CubicBezierInterpolator.EASE_OUT : CubicBezierInterpolator.EASE_IN).getInterpolation(this.checkBoxAnimationProgress) * AndroidUtilities.dp(35.0f));
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
    public void setTranslationX(float f) {
        super.setTranslationX(f);
    }

    public SeekBar getSeekBar() {
        return this.seekBar;
    }

    public SeekBarWaveform getSeekBarWaveform() {
        return this.seekBarWaveform;
    }

    private class MessageAccessibilityNodeProvider extends AccessibilityNodeProvider {
        private Path linkPath;
        private Rect rect;
        private RectF rectF;

        private MessageAccessibilityNodeProvider() {
            this.linkPath = new Path();
            this.rectF = new RectF();
            this.rect = new Rect();
        }

        private class ProfileSpan extends ClickableSpan {
            private TLRPC$User user;

            public ProfileSpan(TLRPC$User tLRPC$User) {
                this.user = tLRPC$User;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                if (ChatMessageCell.this.delegate != null) {
                    ChatMessageCell.this.delegate.didPressUserAvatar(ChatMessageCell.this, this.user, 0.0f, 0.0f);
                }
            }
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            boolean z;
            int i2;
            String str;
            String shortNumber;
            int i3;
            String str2;
            boolean z2;
            CharSequence charSequence;
            long j;
            CharSequence charSequence2;
            CharSequence charSequence3;
            CharSequence charSequence4;
            boolean zIsUserSelf;
            TLRPC$MessagePeerReaction tLRPC$MessagePeerReaction;
            int i4;
            String str3;
            String string;
            String string2;
            AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
            int[] iArr = {0, 0};
            ChatMessageCell.this.getLocationOnScreen(iArr);
            if (i == -1) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(ChatMessageCell.this);
                ChatMessageCell.this.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
                boolean z3 = ChatMessageCell.this.currentMessageObject != null && ChatMessageCell.this.currentMessageObject.isOut() && !ChatMessageCell.this.currentMessageObject.scheduled && ChatMessageCell.this.currentMessageObject.isUnread();
                boolean z4 = ChatMessageCell.this.currentMessageObject != null && ChatMessageCell.this.currentMessageObject.isContentUnread();
                if (ChatMessageCell.this.currentMessageObject != null) {
                    charSequence = "\n";
                    j = ChatMessageCell.this.currentMessageObject.loadedFileSize;
                } else {
                    charSequence = "\n";
                    j = 0;
                }
                ChatMessageCell chatMessageCell = ChatMessageCell.this;
                if (chatMessageCell.accessibilityText == null || chatMessageCell.accessibilityTextUnread != z3 || ChatMessageCell.this.accessibilityTextContentUnread != z4 || ChatMessageCell.this.accessibilityTextFileSize != j) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    ChatMessageCell chatMessageCell2 = ChatMessageCell.this;
                    if (chatMessageCell2.isChat && chatMessageCell2.currentUser != null && !ChatMessageCell.this.currentMessageObject.isOut()) {
                        spannableStringBuilder.append((CharSequence) UserObject.getUserName(ChatMessageCell.this.currentUser));
                        spannableStringBuilder.setSpan(new ProfileSpan(ChatMessageCell.this.currentUser), 0, spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append('\n');
                    }
                    if (ChatMessageCell.this.drawForwardedName) {
                        int i5 = 0;
                        while (i5 < 2) {
                            if (ChatMessageCell.this.forwardedNameLayout[i5] != null) {
                                spannableStringBuilder.append(ChatMessageCell.this.forwardedNameLayout[i5].getText());
                                spannableStringBuilder.append(i5 == 0 ? " " : charSequence);
                            }
                            i5++;
                        }
                    }
                    if (ChatMessageCell.this.documentAttach != null && ChatMessageCell.this.documentAttachType == 1) {
                        String attachFileName = FileLoader.getAttachFileName(ChatMessageCell.this.documentAttach);
                        if (attachFileName.indexOf(46) != -1) {
                            spannableStringBuilder.append((CharSequence) LocaleController.formatString(ir.medu.shad.R.string.AccDescrDocumentType, attachFileName.substring(attachFileName.lastIndexOf(46) + 1).toUpperCase(Locale.ROOT)));
                        }
                    }
                    if (!TextUtils.isEmpty(ChatMessageCell.this.currentMessageObject.messageText)) {
                        spannableStringBuilder.append(ChatMessageCell.this.currentMessageObject.messageText);
                    }
                    if (ChatMessageCell.this.documentAttach == null || !((ChatMessageCell.this.documentAttachType == 1 || ChatMessageCell.this.documentAttachType == 2 || ChatMessageCell.this.documentAttachType == 4) && ChatMessageCell.this.buttonState == 1 && ChatMessageCell.this.loadingProgressLayout != null)) {
                        charSequence2 = ", ";
                        charSequence3 = charSequence;
                    } else {
                        charSequence3 = charSequence;
                        spannableStringBuilder.append(charSequence3);
                        boolean zIsSending = ChatMessageCell.this.currentMessageObject.isSending();
                        charSequence2 = ", ";
                        spannableStringBuilder.append((CharSequence) LocaleController.formatString(zIsSending ? "AccDescrUploadProgress" : "AccDescrDownloadProgress", zIsSending ? ir.medu.shad.R.string.AccDescrUploadProgress : ir.medu.shad.R.string.AccDescrDownloadProgress, AndroidUtilities.formatFileSize(ChatMessageCell.this.currentMessageObject.loadedFileSize), AndroidUtilities.formatFileSize(ChatMessageCell.this.lastLoadingSizeTotal)));
                    }
                    if (!ChatMessageCell.this.currentMessageObject.isMusic()) {
                        charSequence4 = charSequence2;
                        if (ChatMessageCell.this.currentMessageObject.isVoice() || ChatMessageCell.this.isRoundVideo) {
                            spannableStringBuilder.append(charSequence4);
                            spannableStringBuilder.append((CharSequence) LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                            spannableStringBuilder.append(charSequence4);
                            if (ChatMessageCell.this.currentMessageObject.isContentUnread()) {
                                spannableStringBuilder.append((CharSequence) LocaleController.getString("AccDescrMsgNotPlayed", ir.medu.shad.R.string.AccDescrMsgNotPlayed));
                            } else {
                                spannableStringBuilder.append((CharSequence) LocaleController.getString("AccDescrMsgPlayed", ir.medu.shad.R.string.AccDescrMsgPlayed));
                            }
                        }
                    } else {
                        spannableStringBuilder.append(charSequence3);
                        spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrMusicInfo", ir.medu.shad.R.string.AccDescrMusicInfo, ChatMessageCell.this.currentMessageObject.getMusicAuthor(), ChatMessageCell.this.currentMessageObject.getMusicTitle()));
                        charSequence4 = charSequence2;
                        spannableStringBuilder.append(charSequence4);
                        spannableStringBuilder.append((CharSequence) LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                    }
                    if (ChatMessageCell.this.lastPoll != null) {
                        spannableStringBuilder.append(charSequence4);
                        spannableStringBuilder.append((CharSequence) ChatMessageCell.this.lastPoll.question);
                        spannableStringBuilder.append(charSequence4);
                        if (!ChatMessageCell.this.pollClosed) {
                            if (ChatMessageCell.this.lastPoll.quiz) {
                                if (ChatMessageCell.this.lastPoll.public_voters) {
                                    string = LocaleController.getString("QuizPoll", ir.medu.shad.R.string.QuizPoll);
                                } else {
                                    string = LocaleController.getString("AnonymousQuizPoll", ir.medu.shad.R.string.AnonymousQuizPoll);
                                }
                            } else if (ChatMessageCell.this.lastPoll.public_voters) {
                                string = LocaleController.getString("PublicPoll", ir.medu.shad.R.string.PublicPoll);
                            } else {
                                string = LocaleController.getString("AnonymousPoll", ir.medu.shad.R.string.AnonymousPoll);
                            }
                        } else {
                            string = LocaleController.getString("FinalResults", ir.medu.shad.R.string.FinalResults);
                        }
                        spannableStringBuilder.append((CharSequence) string);
                    }
                    if (ChatMessageCell.this.documentAttach != null) {
                        if (ChatMessageCell.this.documentAttachType == 4) {
                            spannableStringBuilder.append(charSequence4);
                            spannableStringBuilder.append((CharSequence) LocaleController.formatDuration(ChatMessageCell.this.currentMessageObject.getDuration()));
                        }
                        if (ChatMessageCell.this.buttonState == 0 || ChatMessageCell.this.documentAttachType == 1) {
                            spannableStringBuilder.append(charSequence4);
                            spannableStringBuilder.append((CharSequence) AndroidUtilities.formatFileSize(ChatMessageCell.this.documentAttach.size));
                        }
                    }
                    if (!ChatMessageCell.this.currentMessageObject.isVoiceTranscriptionOpen()) {
                        if (MessageObject.getMedia(ChatMessageCell.this.currentMessageObject.messageOwner) != null && !TextUtils.isEmpty(ChatMessageCell.this.currentMessageObject.caption)) {
                            spannableStringBuilder.append(charSequence3);
                            spannableStringBuilder.append(ChatMessageCell.this.currentMessageObject.caption);
                        }
                    } else {
                        spannableStringBuilder.append(charSequence3);
                        spannableStringBuilder.append(ChatMessageCell.this.currentMessageObject.getVoiceTranscription());
                    }
                    if (ChatMessageCell.this.currentMessageObject.isOut()) {
                        if (!ChatMessageCell.this.currentMessageObject.isSent()) {
                            if (!ChatMessageCell.this.currentMessageObject.isSending()) {
                                if (ChatMessageCell.this.currentMessageObject.isSendError()) {
                                    spannableStringBuilder.append(charSequence3);
                                    spannableStringBuilder.append((CharSequence) LocaleController.getString("AccDescrMsgSendingError", ir.medu.shad.R.string.AccDescrMsgSendingError));
                                }
                            } else {
                                spannableStringBuilder.append(charSequence3);
                                spannableStringBuilder.append((CharSequence) LocaleController.getString("AccDescrMsgSending", ir.medu.shad.R.string.AccDescrMsgSending));
                                float progress = ChatMessageCell.this.radialProgress.getProgress();
                                if (progress > 0.0f) {
                                    spannableStringBuilder.append((CharSequence) Integer.toString(Math.round(progress * 100.0f))).append((CharSequence) "%");
                                }
                            }
                        } else {
                            spannableStringBuilder.append(charSequence3);
                            if (ChatMessageCell.this.currentMessageObject.scheduled) {
                                spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrScheduledDate", ir.medu.shad.R.string.AccDescrScheduledDate, ChatMessageCell.this.currentTimeString));
                            } else {
                                spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrSentDate", ir.medu.shad.R.string.AccDescrSentDate, LocaleController.getString("TodayAt", ir.medu.shad.R.string.TodayAt) + " " + ((Object) ChatMessageCell.this.currentTimeString)));
                                spannableStringBuilder.append(charSequence4);
                                if (ChatMessageCell.this.currentMessageObject.isUnread()) {
                                    i4 = ir.medu.shad.R.string.AccDescrMsgUnread;
                                    str3 = "AccDescrMsgUnread";
                                } else {
                                    i4 = ir.medu.shad.R.string.AccDescrMsgRead;
                                    str3 = "AccDescrMsgRead";
                                }
                                spannableStringBuilder.append((CharSequence) LocaleController.getString(str3, i4));
                            }
                        }
                    } else {
                        spannableStringBuilder.append(charSequence3);
                        spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrReceivedDate", ir.medu.shad.R.string.AccDescrReceivedDate, LocaleController.getString("TodayAt", ir.medu.shad.R.string.TodayAt) + " " + ((Object) ChatMessageCell.this.currentTimeString)));
                    }
                    if (ChatMessageCell.this.getRepliesCount() > 0 && !ChatMessageCell.this.hasCommentLayout()) {
                        spannableStringBuilder.append(charSequence3);
                        spannableStringBuilder.append((CharSequence) LocaleController.formatPluralString("AccDescrNumberOfReplies", ChatMessageCell.this.getRepliesCount()));
                    }
                    if (ChatMessageCell.this.currentMessageObject.messageOwner.reactions != null && ChatMessageCell.this.currentMessageObject.messageOwner.reactions.results != null) {
                        int size = ChatMessageCell.this.currentMessageObject.messageOwner.reactions.results.size();
                        String firstName = BuildConfig.FLAVOR;
                        if (size == 1) {
                            TLRPC$ReactionCount tLRPC$ReactionCount = ChatMessageCell.this.currentMessageObject.messageOwner.reactions.results.get(0);
                            TLRPC$Reaction tLRPC$Reaction = tLRPC$ReactionCount.reaction;
                            String str4 = tLRPC$Reaction instanceof TLRPC$TL_reactionEmoji ? ((TLRPC$TL_reactionEmoji) tLRPC$Reaction).emoticon : BuildConfig.FLAVOR;
                            int i6 = tLRPC$ReactionCount.count;
                            if (i6 == 1) {
                                spannableStringBuilder.append(charSequence3);
                                if (ChatMessageCell.this.currentMessageObject.messageOwner.reactions.recent_reactions == null || ChatMessageCell.this.currentMessageObject.messageOwner.reactions.recent_reactions.size() != 1 || (tLRPC$MessagePeerReaction = ChatMessageCell.this.currentMessageObject.messageOwner.reactions.recent_reactions.get(0)) == null) {
                                    zIsUserSelf = false;
                                } else {
                                    TLRPC$User user = MessagesController.getInstance(ChatMessageCell.this.currentAccount).getUser(Integer.valueOf(MessageObject.getPeerId(tLRPC$MessagePeerReaction.peer_id)));
                                    zIsUserSelf = UserObject.isUserSelf(user);
                                    if (user != null) {
                                        firstName = UserObject.getFirstName(user);
                                    }
                                }
                                if (zIsUserSelf) {
                                    spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrYouReactedWith", ir.medu.shad.R.string.AccDescrYouReactedWith, str4));
                                } else {
                                    spannableStringBuilder.append((CharSequence) LocaleController.formatString("AccDescrReactedWith", ir.medu.shad.R.string.AccDescrReactedWith, firstName, str4));
                                }
                            } else if (i6 > 1) {
                                spannableStringBuilder.append(charSequence3);
                                spannableStringBuilder.append((CharSequence) LocaleController.formatPluralString("AccDescrNumberOfPeopleReactions", tLRPC$ReactionCount.count, str4));
                            }
                        } else {
                            spannableStringBuilder.append((CharSequence) LocaleController.getString("Reactions", ir.medu.shad.R.string.Reactions)).append((CharSequence) ": ");
                            int size2 = ChatMessageCell.this.currentMessageObject.messageOwner.reactions.results.size();
                            for (int i7 = 0; i7 < size2; i7++) {
                                TLRPC$ReactionCount tLRPC$ReactionCount2 = ChatMessageCell.this.currentMessageObject.messageOwner.reactions.results.get(i7);
                                TLRPC$Reaction tLRPC$Reaction2 = tLRPC$ReactionCount2.reaction;
                                spannableStringBuilder.append((CharSequence) (tLRPC$Reaction2 instanceof TLRPC$TL_reactionEmoji ? ((TLRPC$TL_reactionEmoji) tLRPC$Reaction2).emoticon : BuildConfig.FLAVOR)).append((CharSequence) " ").append((CharSequence) (tLRPC$ReactionCount2.count + BuildConfig.FLAVOR));
                                if (i7 + 1 < size2) {
                                    spannableStringBuilder.append(charSequence4);
                                }
                            }
                            spannableStringBuilder.append(charSequence3);
                        }
                    }
                    if ((ChatMessageCell.this.currentMessageObject.messageOwner.flags & 1024) != 0) {
                        spannableStringBuilder.append(charSequence3);
                        spannableStringBuilder.append((CharSequence) LocaleController.formatPluralString("AccDescrNumberOfViews", ChatMessageCell.this.currentMessageObject.messageOwner.views));
                    }
                    spannableStringBuilder.append(charSequence3);
                    for (final CharacterStyle characterStyle : (CharacterStyle[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ClickableSpan.class)) {
                        int spanStart = spannableStringBuilder.getSpanStart(characterStyle);
                        int spanEnd = spannableStringBuilder.getSpanEnd(characterStyle);
                        spannableStringBuilder.removeSpan(characterStyle);
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: org.rbmain.ui.Cells.ChatMessageCell.MessageAccessibilityNodeProvider.1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View view) {
                                CharacterStyle characterStyle2 = characterStyle;
                                if (!(characterStyle2 instanceof ProfileSpan)) {
                                    if (ChatMessageCell.this.delegate != null) {
                                        ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, characterStyle, false);
                                        return;
                                    }
                                    return;
                                }
                                ((ProfileSpan) characterStyle2).onClick(view);
                            }
                        }, spanStart, spanEnd, 33);
                    }
                    ChatMessageCell chatMessageCell3 = ChatMessageCell.this;
                    chatMessageCell3.accessibilityText = spannableStringBuilder;
                    chatMessageCell3.accessibilityTextUnread = z3;
                    ChatMessageCell.this.accessibilityTextContentUnread = z4;
                    ChatMessageCell.this.accessibilityTextFileSize = j;
                }
                int i8 = Build.VERSION.SDK_INT;
                if (i8 < 24) {
                    accessibilityNodeInfoObtain.setContentDescription(ChatMessageCell.this.accessibilityText.toString());
                } else {
                    accessibilityNodeInfoObtain.setText(ChatMessageCell.this.accessibilityText);
                }
                accessibilityNodeInfoObtain.setEnabled(true);
                if (i8 >= 19 && (collectionItemInfo = accessibilityNodeInfoObtain.getCollectionItemInfo()) != null) {
                    accessibilityNodeInfoObtain.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(collectionItemInfo.getRowIndex(), 1, 0, 1, false));
                }
                if (i8 >= 21) {
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.medu.shad.R.id.acc_action_msg_options, LocaleController.getString("AccActionMessageOptions", ir.medu.shad.R.string.AccActionMessageOptions)));
                    int iconForCurrentState = ChatMessageCell.this.getIconForCurrentState();
                    if (iconForCurrentState == 0) {
                        string2 = LocaleController.getString("AccActionPlay", ir.medu.shad.R.string.AccActionPlay);
                    } else if (iconForCurrentState == 1) {
                        string2 = LocaleController.getString("AccActionPause", ir.medu.shad.R.string.AccActionPause);
                    } else if (iconForCurrentState == 2) {
                        string2 = LocaleController.getString("AccActionDownload", ir.medu.shad.R.string.AccActionDownload);
                    } else if (iconForCurrentState == 3) {
                        string2 = LocaleController.getString("AccActionCancelDownload", ir.medu.shad.R.string.AccActionCancelDownload);
                    } else if (iconForCurrentState == 5) {
                        string2 = LocaleController.getString("AccActionOpenFile", ir.medu.shad.R.string.AccActionOpenFile);
                    } else {
                        string2 = ChatMessageCell.this.currentMessageObject.type == 16 ? LocaleController.getString("CallAgain", ir.medu.shad.R.string.CallAgain) : null;
                    }
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, string2));
                    accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, LocaleController.getString("AccActionEnterSelectionMode", ir.medu.shad.R.string.AccActionEnterSelectionMode)));
                    if (ChatMessageCell.this.getMiniIconForCurrentState() == 2) {
                        accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.medu.shad.R.id.acc_action_small_button, LocaleController.getString("AccActionDownload", ir.medu.shad.R.string.AccActionDownload)));
                    }
                } else {
                    accessibilityNodeInfoObtain.addAction(16);
                    accessibilityNodeInfoObtain.addAction(32);
                }
                if ((ChatMessageCell.this.currentMessageObject.isVoice() || ChatMessageCell.this.currentMessageObject.isRoundVideo() || ChatMessageCell.this.currentMessageObject.isMusic()) && MediaController.getInstance().isPlayingMessage(ChatMessageCell.this.currentMessageObject)) {
                    ChatMessageCell.this.seekBarAccessibilityDelegate.onInitializeAccessibilityNodeInfoInternal(accessibilityNodeInfoObtain);
                }
                if (ChatMessageCell.this.useTranscribeButton && ChatMessageCell.this.transcribeButton != null) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 493);
                }
                if (i8 < 24) {
                    ChatMessageCell chatMessageCell4 = ChatMessageCell.this;
                    if (chatMessageCell4.isChat && chatMessageCell4.currentUser != null && !ChatMessageCell.this.currentMessageObject.isOut()) {
                        accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 5000);
                    }
                    if (ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable) {
                        Spannable spannable = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
                        int i9 = 0;
                        for (CharacterStyle characterStyle2 : (CharacterStyle[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class)) {
                            accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i9 + 2000);
                            i9++;
                        }
                    }
                    if ((ChatMessageCell.this.currentMessageObject.caption instanceof Spannable) && ChatMessageCell.this.captionLayout != null) {
                        Spannable spannable2 = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                        int i10 = 0;
                        for (CharacterStyle characterStyle3 : (CharacterStyle[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class)) {
                            accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i10 + 3000);
                            i10++;
                        }
                    }
                }
                Iterator it = ChatMessageCell.this.botButtons.iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i11 + CloseCodes.NORMAL_CLOSURE);
                    i11++;
                }
                if (ChatMessageCell.this.hintButtonVisible && ChatMessageCell.this.pollHintX != -1 && ChatMessageCell.this.currentMessageObject.isPoll()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 495);
                }
                Iterator it2 = ChatMessageCell.this.pollButtons.iterator();
                int i12 = 0;
                while (it2.hasNext()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, i12 + HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                    i12++;
                }
                if (ChatMessageCell.this.drawInstantView && !ChatMessageCell.this.instantButtonRect.isEmpty()) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 499);
                }
                if (ChatMessageCell.this.commentLayout != null) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 496);
                }
                if (ChatMessageCell.this.drawSideButton == 1 || ChatMessageCell.this.drawSideButton == 2) {
                    accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 498);
                }
                ChatMessageCell chatMessageCell5 = ChatMessageCell.this;
                if (chatMessageCell5.replyNameLayout != null) {
                    accessibilityNodeInfoObtain.addChild(chatMessageCell5, 497);
                }
                if (ChatMessageCell.this.forwardedNameLayout[0] != null && ChatMessageCell.this.forwardedNameLayout[1] != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        accessibilityNodeInfoObtain.addAction(new AccessibilityNodeInfo.AccessibilityAction(ir.medu.shad.R.id.acc_action_open_forwarded_origin, LocaleController.getString("AccActionOpenForwardedOrigin", ir.medu.shad.R.string.AccActionOpenForwardedOrigin)));
                    } else {
                        accessibilityNodeInfoObtain.addChild(ChatMessageCell.this, 494);
                    }
                }
                if (ChatMessageCell.this.drawSelectionBackground || ChatMessageCell.this.getBackground() != null) {
                    accessibilityNodeInfoObtain.setSelected(true);
                }
                return accessibilityNodeInfoObtain;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain();
            accessibilityNodeInfoObtain2.setSource(ChatMessageCell.this, i);
            accessibilityNodeInfoObtain2.setParent(ChatMessageCell.this);
            accessibilityNodeInfoObtain2.setPackageName(ChatMessageCell.this.getContext().getPackageName());
            if (i == 5000) {
                if (ChatMessageCell.this.currentUser == null) {
                    return null;
                }
                accessibilityNodeInfoObtain2.setText(UserObject.getUserName(ChatMessageCell.this.currentUser));
                this.rect.set((int) ChatMessageCell.this.nameX, (int) ChatMessageCell.this.nameY, (int) (ChatMessageCell.this.nameX + ChatMessageCell.this.nameWidth), (int) (ChatMessageCell.this.nameY + (ChatMessageCell.this.nameLayout != null ? ChatMessageCell.this.nameLayout.getHeight() : 10)));
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClassName("android.widget.TextView");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.setLongClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.addAction(32);
            } else if (i >= 3000) {
                if (!(ChatMessageCell.this.currentMessageObject.caption instanceof Spannable) || ChatMessageCell.this.captionLayout == null) {
                    return null;
                }
                Spannable spannable3 = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                ClickableSpan linkById = getLinkById(i, true);
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
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                accessibilityNodeInfoObtain2.setClassName("android.widget.TextView");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.setLongClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.addAction(32);
            } else if (i >= 2000) {
                if (!(ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable)) {
                    return null;
                }
                Spannable spannable4 = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
                ClickableSpan linkById2 = getLinkById(i, false);
                if (linkById2 == null) {
                    return null;
                }
                int[] realSpanStartAndEnd2 = ChatMessageCell.this.getRealSpanStartAndEnd(spannable4, linkById2);
                accessibilityNodeInfoObtain2.setText(spannable4.subSequence(realSpanStartAndEnd2[0], realSpanStartAndEnd2[1]).toString());
                Iterator<MessageObject.TextLayoutBlock> it3 = ChatMessageCell.this.currentMessageObject.textLayoutBlocks.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = true;
                        break;
                    }
                    MessageObject.TextLayoutBlock next = it3.next();
                    int length = next.textLayout.getText().length();
                    int i13 = next.charactersOffset;
                    if (i13 <= realSpanStartAndEnd2[0] && length + i13 >= realSpanStartAndEnd2[1]) {
                        next.textLayout.getSelectionPath(realSpanStartAndEnd2[0] - i13, realSpanStartAndEnd2[1] - i13, this.linkPath);
                        this.linkPath.computeBounds(this.rectF, true);
                        Rect rect2 = this.rect;
                        RectF rectF2 = this.rectF;
                        rect2.set((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        this.rect.offset(0, (int) next.textYOffset);
                        this.rect.offset(ChatMessageCell.this.textX, ChatMessageCell.this.textY);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z2 = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                    }
                }
                accessibilityNodeInfoObtain2.setClassName("android.widget.TextView");
                accessibilityNodeInfoObtain2.setEnabled(z2);
                accessibilityNodeInfoObtain2.setClickable(z2);
                accessibilityNodeInfoObtain2.setLongClickable(z2);
                accessibilityNodeInfoObtain2.addAction(16);
                accessibilityNodeInfoObtain2.addAction(32);
            } else if (i >= 1000) {
                int i14 = i - 1000;
                if (i14 >= ChatMessageCell.this.botButtons.size()) {
                    return null;
                }
                BotButton botButton = (BotButton) ChatMessageCell.this.botButtons.get(i14);
                accessibilityNodeInfoObtain2.setText(botButton.title.getText());
                accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                accessibilityNodeInfoObtain2.setEnabled(true);
                accessibilityNodeInfoObtain2.setClickable(true);
                accessibilityNodeInfoObtain2.addAction(16);
                this.rect.set(botButton.x, botButton.y, botButton.x + botButton.width, botButton.y + botButton.height);
                this.rect.offset(ChatMessageCell.this.currentMessageObject.isOutOwner() ? (ChatMessageCell.this.getMeasuredWidth() - ChatMessageCell.this.widthForButtons) - AndroidUtilities.dp(10.0f) : ChatMessageCell.this.backgroundDrawableLeft + AndroidUtilities.dp(ChatMessageCell.this.mediaBackground ? 1.0f : 7.0f), ChatMessageCell.this.layoutHeight);
                accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null) {
                    ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                }
                this.rect.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
            } else {
                if (i >= 500) {
                    int i15 = i - 500;
                    if (i15 >= ChatMessageCell.this.pollButtons.size()) {
                        return null;
                    }
                    PollButton pollButton = (PollButton) ChatMessageCell.this.pollButtons.get(i15);
                    StringBuilder sb = new StringBuilder(pollButton.title.getText());
                    if (ChatMessageCell.this.pollVoted) {
                        accessibilityNodeInfoObtain2.setSelected(pollButton.chosen);
                        sb.append(", ");
                        sb.append(pollButton.percent);
                        sb.append("%");
                        if (ChatMessageCell.this.lastPoll != null && ChatMessageCell.this.lastPoll.quiz && (pollButton.chosen || pollButton.correct)) {
                            sb.append(", ");
                            if (pollButton.correct) {
                                i3 = ir.medu.shad.R.string.AccDescrQuizCorrectAnswer;
                                str2 = "AccDescrQuizCorrectAnswer";
                            } else {
                                i3 = ir.medu.shad.R.string.AccDescrQuizIncorrectAnswer;
                                str2 = "AccDescrQuizIncorrectAnswer";
                            }
                            sb.append(LocaleController.getString(str2, i3));
                        }
                    } else {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                    }
                    accessibilityNodeInfoObtain2.setText(sb);
                    accessibilityNodeInfoObtain2.setEnabled(true);
                    accessibilityNodeInfoObtain2.addAction(16);
                    int i16 = pollButton.y + ChatMessageCell.this.namesOffset;
                    int iDp = ChatMessageCell.this.backgroundWidth - AndroidUtilities.dp(76.0f);
                    Rect rect3 = this.rect;
                    int i17 = pollButton.x;
                    rect3.set(i17, i16, iDp + i17, pollButton.height + i16);
                    accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                    if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null) {
                        ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                    }
                    z = true;
                    this.rect.offset(iArr[0], iArr[1]);
                    accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                    accessibilityNodeInfoObtain2.setClickable(true);
                } else {
                    z = true;
                    if (i == 495) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        accessibilityNodeInfoObtain2.setText(LocaleController.getString("AccDescrQuizExplanation", ir.medu.shad.R.string.AccDescrQuizExplanation));
                        accessibilityNodeInfoObtain2.addAction(16);
                        this.rect.set(ChatMessageCell.this.pollHintX - AndroidUtilities.dp(8.0f), ChatMessageCell.this.pollHintY - AndroidUtilities.dp(8.0f), ChatMessageCell.this.pollHintX + AndroidUtilities.dp(32.0f), ChatMessageCell.this.pollHintY + AndroidUtilities.dp(32.0f));
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 499) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        if (ChatMessageCell.this.instantViewLayout != null) {
                            accessibilityNodeInfoObtain2.setText(ChatMessageCell.this.instantViewLayout.getText());
                        }
                        accessibilityNodeInfoObtain2.addAction(16);
                        ChatMessageCell.this.instantButtonRect.round(this.rect);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 498) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.ImageButton");
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        ChatMessageCell chatMessageCell6 = ChatMessageCell.this;
                        if (chatMessageCell6.isOpenChatByShare(chatMessageCell6.currentMessageObject)) {
                            accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("AccDescrOpenChat", ir.medu.shad.R.string.AccDescrOpenChat));
                        } else {
                            accessibilityNodeInfoObtain2.setContentDescription(LocaleController.getString("ShareFile", ir.medu.shad.R.string.ShareFile));
                        }
                        accessibilityNodeInfoObtain2.addAction(16);
                        this.rect.set((int) ChatMessageCell.this.sideStartX, (int) ChatMessageCell.this.sideStartY, ((int) ChatMessageCell.this.sideStartX) + AndroidUtilities.dp(40.0f), ((int) ChatMessageCell.this.sideStartY) + AndroidUtilities.dp(32.0f));
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 497) {
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(LocaleController.getString("Reply", ir.medu.shad.R.string.Reply));
                        sb2.append(", ");
                        StaticLayout staticLayout = ChatMessageCell.this.replyNameLayout;
                        if (staticLayout != null) {
                            sb2.append(staticLayout.getText());
                            sb2.append(", ");
                        }
                        StaticLayout staticLayout2 = ChatMessageCell.this.replyTextLayout;
                        if (staticLayout2 != null) {
                            sb2.append(staticLayout2.getText());
                        }
                        accessibilityNodeInfoObtain2.setContentDescription(sb2.toString());
                        accessibilityNodeInfoObtain2.addAction(16);
                        Rect rect4 = this.rect;
                        ChatMessageCell chatMessageCell7 = ChatMessageCell.this;
                        int i18 = chatMessageCell7.replyStartX;
                        int i19 = chatMessageCell7.replyStartY;
                        int iMax = Math.max(chatMessageCell7.replyNameWidth, ChatMessageCell.this.replyTextWidth) + i18;
                        ChatMessageCell chatMessageCell8 = ChatMessageCell.this;
                        rect4.set(i18, i19, iMax, chatMessageCell8.replyStartY + ((int) chatMessageCell8.replyHeight));
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 494) {
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        StringBuilder sb3 = new StringBuilder();
                        if (ChatMessageCell.this.forwardedNameLayout[0] != null && ChatMessageCell.this.forwardedNameLayout[1] != null) {
                            int i20 = 0;
                            while (i20 < 2) {
                                sb3.append(ChatMessageCell.this.forwardedNameLayout[i20].getText());
                                sb3.append(i20 == 0 ? " " : "\n");
                                i20++;
                            }
                        }
                        accessibilityNodeInfoObtain2.setContentDescription(sb3.toString());
                        accessibilityNodeInfoObtain2.addAction(16);
                        int iMin = (int) Math.min(ChatMessageCell.this.forwardNameX - ChatMessageCell.this.forwardNameOffsetX[0], ChatMessageCell.this.forwardNameX - ChatMessageCell.this.forwardNameOffsetX[1]);
                        this.rect.set(iMin, ChatMessageCell.this.forwardNameY, ChatMessageCell.this.forwardedNameWidth + iMin, ChatMessageCell.this.forwardNameY + ChatMessageCell.this.forwardHeight);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 496) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        int repliesCount = ChatMessageCell.this.getRepliesCount();
                        if (ChatMessageCell.this.currentMessageObject != null && !ChatMessageCell.this.currentMessageObject.shouldDrawWithoutBackground() && !ChatMessageCell.this.currentMessageObject.isAnimatedEmoji()) {
                            if (ChatMessageCell.this.isRepliesChat) {
                                shortNumber = LocaleController.getString("ViewInChat", ir.medu.shad.R.string.ViewInChat);
                            } else {
                                shortNumber = repliesCount == 0 ? LocaleController.getString("LeaveAComment", ir.medu.shad.R.string.LeaveAComment) : LocaleController.formatPluralString("CommentsCount", repliesCount);
                            }
                        } else {
                            shortNumber = (ChatMessageCell.this.isRepliesChat || repliesCount <= 0) ? null : LocaleController.formatShortNumber(repliesCount, null);
                        }
                        if (shortNumber != null) {
                            accessibilityNodeInfoObtain2.setText(shortNumber);
                        }
                        accessibilityNodeInfoObtain2.addAction(16);
                        this.rect.set(ChatMessageCell.this.commentButtonRect);
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        if (ChatMessageCell.this.accessibilityVirtualViewBounds.get(i) == null || !((Rect) ChatMessageCell.this.accessibilityVirtualViewBounds.get(i)).equals(this.rect)) {
                            ChatMessageCell.this.accessibilityVirtualViewBounds.put(i, new Rect(this.rect));
                        }
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else if (i == 493) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                        accessibilityNodeInfoObtain2.setEnabled(true);
                        if (ChatMessageCell.this.currentMessageObject.isVoiceTranscriptionOpen()) {
                            i2 = ir.medu.shad.R.string.AccActionCloseTranscription;
                            str = "AccActionCloseTranscription";
                        } else {
                            i2 = ir.medu.shad.R.string.AccActionOpenTranscription;
                            str = "AccActionOpenTranscription";
                        }
                        accessibilityNodeInfoObtain2.setText(LocaleController.getString(str, i2));
                        accessibilityNodeInfoObtain2.addAction(16);
                        if (ChatMessageCell.this.transcribeButton != null) {
                            this.rect.set((int) ChatMessageCell.this.transcribeX, (int) ChatMessageCell.this.transcribeY, (int) (ChatMessageCell.this.transcribeX + ChatMessageCell.this.transcribeButton.width()), (int) (ChatMessageCell.this.transcribeY + ChatMessageCell.this.transcribeButton.height()));
                        }
                        accessibilityNodeInfoObtain2.setBoundsInParent(this.rect);
                        z = true;
                        this.rect.offset(iArr[0], iArr[1]);
                        accessibilityNodeInfoObtain2.setBoundsInScreen(this.rect);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    }
                }
                accessibilityNodeInfoObtain2.setFocusable(z);
                accessibilityNodeInfoObtain2.setVisibleToUser(z);
                return accessibilityNodeInfoObtain2;
            }
            z = true;
            accessibilityNodeInfoObtain2.setFocusable(z);
            accessibilityNodeInfoObtain2.setVisibleToUser(z);
            return accessibilityNodeInfoObtain2;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) throws SAXException, IOException {
            if (i == -1) {
                ChatMessageCell.this.performAccessibilityAction(i2, bundle);
            } else if (i2 == 64) {
                ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 32768);
            } else {
                if (i2 == 16) {
                    if (i == 5000) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCellDelegate chatMessageCellDelegate = ChatMessageCell.this.delegate;
                            ChatMessageCell chatMessageCell = ChatMessageCell.this;
                            chatMessageCellDelegate.didPressUserAvatar(chatMessageCell, chatMessageCell.currentUser, 0.0f, 0.0f);
                        }
                    } else if (i >= 3000) {
                        ClickableSpan linkById = getLinkById(i, true);
                        if (linkById != null) {
                            ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById, false);
                            ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 1);
                        }
                    } else if (i >= 2000) {
                        ClickableSpan linkById2 = getLinkById(i, false);
                        if (linkById2 != null) {
                            ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById2, false);
                            ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 1);
                        }
                    } else if (i >= 1000) {
                        int i3 = i - 1000;
                        if (i3 >= ChatMessageCell.this.botButtons.size()) {
                            return false;
                        }
                        BotButton botButton = (BotButton) ChatMessageCell.this.botButtons.get(i3);
                        if (ChatMessageCell.this.delegate != null && botButton.button != null) {
                            ChatMessageCell.this.delegate.didPressBotButton(ChatMessageCell.this, botButton.button);
                        }
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 1);
                    } else if (i >= 500) {
                        int i4 = i - 500;
                        if (i4 >= ChatMessageCell.this.pollButtons.size()) {
                            return false;
                        }
                        PollButton pollButton = (PollButton) ChatMessageCell.this.pollButtons.get(i4);
                        if (ChatMessageCell.this.delegate != null) {
                            ArrayList<TLRPC$TL_pollAnswer> arrayList = new ArrayList<>();
                            arrayList.add(pollButton.answer);
                            ChatMessageCell.this.delegate.didPressVoteButtons(ChatMessageCell.this, arrayList, -1, 0, 0);
                        }
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 1);
                    } else if (i == 495) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell.this.delegate.didPressHint(ChatMessageCell.this, 0);
                        }
                    } else if (i == 499) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCellDelegate chatMessageCellDelegate2 = ChatMessageCell.this.delegate;
                            ChatMessageCell chatMessageCell2 = ChatMessageCell.this;
                            chatMessageCellDelegate2.didPressInstantButton(chatMessageCell2, chatMessageCell2.drawInstantViewType);
                        }
                    } else if (i == 498) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell.this.delegate.didPressSideButton(ChatMessageCell.this);
                        }
                    } else if (i == 497) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell chatMessageCell3 = ChatMessageCell.this;
                            if ((!chatMessageCell3.isThreadChat || chatMessageCell3.currentMessageObject.getReplyTopMsgId() != 0) && ChatMessageCell.this.currentMessageObject.hasValidReplyMessageObject()) {
                                ChatMessageCellDelegate chatMessageCellDelegate3 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell4 = ChatMessageCell.this;
                                chatMessageCellDelegate3.didPressReplyMessage(chatMessageCell4, chatMessageCell4.currentMessageObject.getReplyMsgId());
                            }
                        }
                    } else if (i == 494) {
                        if (ChatMessageCell.this.delegate != null) {
                            if (ChatMessageCell.this.currentForwardChannel != null) {
                                ChatMessageCellDelegate chatMessageCellDelegate4 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell5 = ChatMessageCell.this;
                                chatMessageCellDelegate4.didPressChannelAvatar(chatMessageCell5, chatMessageCell5.currentForwardChannel, ChatMessageCell.this.currentMessageObject.messageOwner.fwd_from.channel_post, ChatMessageCell.this.lastTouchX, ChatMessageCell.this.lastTouchY);
                            } else if (ChatMessageCell.this.currentForwardUser != null) {
                                ChatMessageCellDelegate chatMessageCellDelegate5 = ChatMessageCell.this.delegate;
                                ChatMessageCell chatMessageCell6 = ChatMessageCell.this;
                                chatMessageCellDelegate5.didPressUserAvatar(chatMessageCell6, chatMessageCell6.currentForwardUser, ChatMessageCell.this.lastTouchX, ChatMessageCell.this.lastTouchY);
                            } else if (ChatMessageCell.this.currentForwardName != null) {
                                ChatMessageCell.this.delegate.didPressHiddenForward(ChatMessageCell.this);
                            }
                        }
                    } else if (i == 496) {
                        if (ChatMessageCell.this.delegate != null) {
                            ChatMessageCell chatMessageCell7 = ChatMessageCell.this;
                            if (chatMessageCell7.isRepliesChat) {
                                chatMessageCell7.delegate.didPressSideButton(ChatMessageCell.this);
                            } else {
                                chatMessageCell7.delegate.didPressCommentButton(ChatMessageCell.this);
                            }
                        }
                    } else if (i == 493 && ChatMessageCell.this.transcribeButton != null) {
                        ChatMessageCell.this.transcribeButton.onTap();
                    }
                } else if (i2 == 32) {
                    ClickableSpan linkById3 = getLinkById(i, i >= 3000);
                    if (linkById3 != null) {
                        ChatMessageCell.this.delegate.didPressUrl(ChatMessageCell.this, linkById3, true);
                        ChatMessageCell.this.sendAccessibilityEventForVirtualView(i, 2);
                    }
                }
            }
            return true;
        }

        private ClickableSpan getLinkById(int i, boolean z) {
            if (i == 5000) {
                return null;
            }
            if (z) {
                int i2 = i - 3000;
                if (!(ChatMessageCell.this.currentMessageObject.caption instanceof Spannable) || i2 < 0) {
                    return null;
                }
                Spannable spannable = (Spannable) ChatMessageCell.this.currentMessageObject.caption;
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
                if (clickableSpanArr.length <= i2) {
                    return null;
                }
                return clickableSpanArr[i2];
            }
            int i3 = i - 2000;
            if (!(ChatMessageCell.this.currentMessageObject.messageText instanceof Spannable) || i3 < 0) {
                return null;
            }
            Spannable spannable2 = (Spannable) ChatMessageCell.this.currentMessageObject.messageText;
            ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable2.getSpans(0, spannable2.length(), ClickableSpan.class);
            if (clickableSpanArr2.length <= i3) {
                return null;
            }
            return clickableSpanArr2[i3];
        }
    }

    public void setImageCoords(float f, float f2, float f3, float f4) {
        this.photoImage.setImageCoords(f, f2, f3, f4);
        int i = this.documentAttachType;
        if (i == 4 || i == 2) {
            this.videoButtonX = (int) (this.photoImage.getImageX() + AndroidUtilities.dp(8.0f));
            int imageY = (int) (this.photoImage.getImageY() + AndroidUtilities.dp(8.0f));
            this.videoButtonY = imageY;
            RadialProgress2 radialProgress2 = this.videoRadialProgress;
            int i2 = this.videoButtonX;
            radialProgress2.setProgressRect(i2, imageY, AndroidUtilities.dp(24.0f) + i2, this.videoButtonY + AndroidUtilities.dp(24.0f));
            this.buttonX = (int) (f + ((this.photoImage.getImageWidth() - AndroidUtilities.dp(48.0f)) / 2.0f));
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
    public void setAlpha(float f) {
        if ((f == 1.0f) != (getAlpha() == 1.0f)) {
            invalidate();
        }
        if (this.ALPHA_PROPERTY_WORKAROUND) {
            this.alphaInternal = f;
            invalidate();
        } else {
            super.setAlpha(f);
        }
        MessageObject.GroupedMessagePosition groupedMessagePosition = this.currentPosition;
        if ((groupedMessagePosition != null && (groupedMessagePosition.minY != 0 || groupedMessagePosition.minX != 0)) || ((this.enterTransitionInProgress && !this.currentMessageObject.isVoice()) || this.replyNameLayout == null || this.replyTextLayout == null)) {
            MessageObject.GroupedMessagePosition groupedMessagePosition2 = this.currentPosition;
            if (groupedMessagePosition2 != null) {
                int i = groupedMessagePosition2.flags;
                if ((i & 8) == 0 || (i & 1) == 0) {
                    return;
                }
            }
            if (this.reactionsLayoutInBubble.isSmall) {
                return;
            }
        }
        invalidate();
    }

    public int getCurrentBackgroundLeft() {
        Theme.MessageDrawable messageDrawable = this.currentBackgroundDrawable;
        if (messageDrawable == null) {
            return 0;
        }
        int i = messageDrawable.getBounds().left;
        if (this.currentMessageObject.isOutOwner() || this.transitionParams.changePinnedBottomProgress == 1.0f) {
            return i;
        }
        boolean z = this.isRoundVideo;
        if ((!z && this.mediaBackground) || this.drawPinnedBottom) {
            return i;
        }
        if (z) {
            return (int) (i - (AndroidUtilities.dp(6.0f) * getVideoTranscriptionProgress()));
        }
        return i - AndroidUtilities.dp(6.0f);
    }

    public int getCurrentBackgroundRight() {
        Theme.MessageDrawable messageDrawable = this.currentBackgroundDrawable;
        if (messageDrawable == null) {
            return getWidth();
        }
        int i = messageDrawable.getBounds().right;
        if (!this.currentMessageObject.isOutOwner() || this.transitionParams.changePinnedBottomProgress == 1.0f) {
            return i;
        }
        boolean z = this.isRoundVideo;
        if ((!z && this.mediaBackground) || this.drawPinnedBottom) {
            return i;
        }
        if (z) {
            return (int) (i + (AndroidUtilities.dp(6.0f) * getVideoTranscriptionProgress()));
        }
        return i + AndroidUtilities.dp(6.0f);
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
        boolean animateBotButtonsChanged;
        private boolean animateButton;
        public boolean animateChange;
        private int animateCommentArrowX;
        private boolean animateCommentDrawUnread;
        private int animateCommentUnreadX;
        private float animateCommentX;
        private boolean animateComments;
        private StaticLayout animateCommentsLayout;
        public boolean animateDrawBackground;
        private boolean animateDrawCommentNumber;
        public boolean animateDrawingTimeAlpha;
        private boolean animateEditedEnter;
        private StaticLayout animateEditedLayout;
        private int animateEditedWidthDiff;
        int animateForwardNameWidth;
        float animateForwardNameX;
        public boolean animateForwardedLayout;
        public int animateForwardedNamesOffset;
        private float animateFromButtonX;
        private float animateFromButtonY;
        public float animateFromReplyY;
        public float animateFromRoundVideoDotY;
        public float animateFromTextY;
        public int animateFromTimeX;
        public float animateFromTimeXPinned;
        private float animateFromTimeXReplies;
        private float animateFromTimeXViews;
        public boolean animateLocationIsExpired;
        boolean animateMessageText;
        private float animateNameX;
        private AnimatedEmojiSpan.EmojiGroupedSpans animateOutAnimateEmoji;
        private AnimatedEmojiSpan.EmojiGroupedSpans animateOutAnimateEmojiReply;
        private StaticLayout animateOutCaptionLayout;
        private ArrayList<MessageObject.TextLayoutBlock> animateOutTextBlocks;
        private float animateOutTextXOffset;
        private boolean animatePinned;
        public boolean animatePlayingRound;
        public boolean animateRadius;
        boolean animateReplaceCaptionLayout;
        private boolean animateReplies;
        private StaticLayout animateRepliesLayout;
        private StaticLayout animateReplyTextLayout;
        public float animateReplyTextOffset;
        public boolean animateRoundVideoDotY;
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
        public boolean animateUseTranscribeButton;
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
        public int lastBackgroundLeft;
        public int lastBackgroundRight;
        private float lastButtonX;
        private float lastButtonY;
        private int lastCommentArrowX;
        private boolean lastCommentDrawUnread;
        private StaticLayout lastCommentLayout;
        private int lastCommentUnreadX;
        private float lastCommentX;
        private int lastCommentsCount;
        public boolean lastDrawBackground;
        private boolean lastDrawCommentNumber;
        public StaticLayout lastDrawDocTitleLayout;
        public StaticLayout lastDrawInfoLayout;
        public float lastDrawLocationExpireProgress;
        public String lastDrawLocationExpireText;
        public float lastDrawReplyY;
        public float lastDrawRoundVideoDotY;
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
        public float lastDrawingTextY;
        public boolean lastDrawnForwardedName;
        public StaticLayout lastDrawnReplyTextLayout;
        int lastForwardNameWidth;
        float lastForwardNameX;
        public int lastForwardedNamesOffset;
        private boolean lastIsPinned;
        private boolean lastIsPlayingRound;
        public boolean lastLocatinIsExpired;
        private int lastRepliesCount;
        private StaticLayout lastRepliesLayout;
        public int lastReplyTextXOffset;
        private boolean lastShouldDrawMenuDrawable;
        private boolean lastShouldDrawTimeOnMedia;
        private String lastSignMessage;
        public float lastTextXOffset;
        private StaticLayout lastTimeLayout;
        private int lastTimeWidth;
        public int lastTimeX;
        public float lastTimeXPinned;
        private float lastTimeXReplies;
        private float lastTimeXViews;
        public int lastTopOffset;
        private int lastTotalCommentWidth;
        public boolean lastUseTranscribeButton;
        private int lastViewsCount;
        private StaticLayout lastViewsLayout;
        public boolean messageEntering;
        private boolean moveCaption;
        public boolean shouldAnimateTimeX;
        public float toDeltaLeft;
        public float toDeltaRight;
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
            this.lastDrawBotButtons.clear();
            if (!ChatMessageCell.this.botButtons.isEmpty()) {
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
            this.lastDrawBackground = ChatMessageCell.this.drawBackground;
            this.lastUseTranscribeButton = ChatMessageCell.this.useTranscribeButton;
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
            int unused = ChatMessageCell.this.textX;
            this.lastDrawnForwardedNameLayout[0] = ChatMessageCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = ChatMessageCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = ChatMessageCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = ChatMessageCell.this.forwardNameX;
            this.lastForwardedNamesOffset = ChatMessageCell.this.namesOffset;
            this.lastForwardNameWidth = ChatMessageCell.this.forwardedNameWidth;
            this.lastBackgroundLeft = ChatMessageCell.this.getCurrentBackgroundLeft();
            this.lastBackgroundRight = ChatMessageCell.this.currentBackgroundDrawable.getBounds().right;
            this.lastTextXOffset = ChatMessageCell.this.currentMessageObject.textXOffset;
            ChatMessageCell chatMessageCell2 = ChatMessageCell.this;
            this.lastDrawnReplyTextLayout = chatMessageCell2.replyTextLayout;
            this.lastReplyTextXOffset = chatMessageCell2.replyTextOffset;
            ChatMessageCell.this.reactionsLayoutInBubble.recordDrawingState();
            if (ChatMessageCell.this.replyNameLayout != null) {
                this.lastDrawReplyY = r0.replyStartY;
            } else {
                this.lastDrawReplyY = 0.0f;
            }
        }

        public void recordDrawingStatePreview() {
            this.lastDrawnForwardedNameLayout[0] = ChatMessageCell.this.forwardedNameLayout[0];
            this.lastDrawnForwardedNameLayout[1] = ChatMessageCell.this.forwardedNameLayout[1];
            this.lastDrawnForwardedName = ChatMessageCell.this.currentMessageObject.needDrawForwarded();
            this.lastForwardNameX = ChatMessageCell.this.forwardNameX;
            this.lastForwardedNamesOffset = ChatMessageCell.this.namesOffset;
            this.lastForwardNameWidth = ChatMessageCell.this.forwardedNameWidth;
        }

        /* JADX WARN: Removed duplicated region for block: B:191:0x04c5  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x04d1  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x04dd  */
        /* JADX WARN: Removed duplicated region for block: B:200:0x04ed  */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0534  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x0541  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x0574  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ee  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean animateChange() {
            /*
                Method dump skipped, instructions count: 1415
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.TransitionParams.animateChange():boolean");
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
            this.toDeltaLeft = 0.0f;
            this.toDeltaRight = 0.0f;
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
            AnimatedEmojiSpan.release(ChatMessageCell.this, this.animateOutAnimateEmoji);
            this.animateOutAnimateEmoji = null;
            this.moveCaption = false;
            this.animateDrawingTimeAlpha = false;
            this.transitionBotButtons.clear();
            this.animateButton = false;
            this.animateReplyTextLayout = null;
            this.animateReplies = false;
            this.animateRepliesLayout = null;
            this.animateComments = false;
            this.animateCommentsLayout = null;
            this.animateViewsLayout = null;
            this.animateShouldDrawTimeOnMedia = false;
            this.animateShouldDrawMenuDrawable = false;
            this.shouldAnimateTimeX = false;
            this.animateDrawBackground = false;
            this.animateSign = false;
            this.animateDrawingTimeAlpha = false;
            this.animateLocationIsExpired = false;
            this.animatePlayingRound = false;
            this.animateText = false;
            this.animateForwardedLayout = false;
            StaticLayout[] staticLayoutArr = this.animatingForwardedNameLayout;
            staticLayoutArr[0] = null;
            staticLayoutArr[1] = null;
            this.animateRoundVideoDotY = false;
            ChatMessageCell.this.reactionsLayoutInBubble.resetAnimation();
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
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isOutOwner()
                r1 = 8
                r2 = 4
                r3 = 1
                r4 = 0
                if (r0 == 0) goto L7a
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L65
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L2a
                goto L65
            L2a:
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isSendError()
                if (r0 == 0) goto L3b
                r0 = 0
                r3 = 0
                r5 = 0
                r6 = 1
                goto L69
            L3b:
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isSent()
                if (r0 == 0) goto L61
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.scheduled
                if (r0 != 0) goto L5f
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
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
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isSending()
                if (r0 != 0) goto L94
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
                boolean r0 = r0.isEditing()
                if (r0 == 0) goto L93
                goto L94
            L93:
                r3 = 0
            L94:
                org.rbmain.ui.Cells.ChatMessageCell r0 = org.rbmain.ui.Cells.ChatMessageCell.this
                org.rbmain.messenger.MessageObject r0 = org.rbmain.ui.Cells.ChatMessageCell.access$800(r0)
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
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatMessageCell.TransitionParams.createStatusDrawableParams():int");
        }
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i);
    }

    private Drawable getThemedDrawable(String str) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Drawable drawable = resourcesProvider != null ? resourcesProvider.getDrawable(str) : null;
        return drawable != null ? drawable : Theme.getThemeDrawable(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Paint getThemedPaint(String str) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Paint paint = resourcesProvider != null ? resourcesProvider.getPaint(str) : null;
        return paint != null ? paint : Theme.getThemePaint(str);
    }

    private CharSequence getPostNotAvailableSpan() {
        SpannableString spannableString = new SpannableString(LocaleController.formatString(ir.medu.shad.R.string.RubinoPostNotAvailable, LocaleController.getString(ir.medu.shad.R.string.RubinoNameFarsi)));
        spannableString.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0, LocaleController.formatString(ir.medu.shad.R.string.RubinoPost, LocaleController.getString(ir.medu.shad.R.string.RubinoNameFarsi)).length(), 33);
        return spannableString;
    }

    private CharSequence getPostIsLoadingSpan() {
        SpannableString spannableString = new SpannableString(LocaleController.formatString(ir.medu.shad.R.string.RubinoPostLoading, LocaleController.getString(ir.medu.shad.R.string.RubinoNameFarsi)));
        spannableString.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0, LocaleController.formatString(ir.medu.shad.R.string.RubinoPost, LocaleController.getString(ir.medu.shad.R.string.RubinoNameFarsi)).length(), 33);
        return spannableString;
    }
}
