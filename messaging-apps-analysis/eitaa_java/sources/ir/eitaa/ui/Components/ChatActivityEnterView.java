package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.MimeTypeMap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.recyclerview.widget.ChatListItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.messenger.camera.CameraController;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$BotInfo;
import ir.eitaa.tgnet.TLRPC$BotInlineResult;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$InputStickerSet;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageEntity;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$ReplyMarkup;
import ir.eitaa.tgnet.TLRPC$StickerSet;
import ir.eitaa.tgnet.TLRPC$StickerSetCovered;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_inputStickerSetID;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButton;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonBuy;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonCallback;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonGame;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestPhone;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonRequestPoll;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonSwitchInline;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrl;
import ir.eitaa.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityBold;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityCode;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityItalic;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityMentionName;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityPre;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityStrike;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityTextUrl;
import ir.eitaa.tgnet.TLRPC$TL_messageEntityUnderline;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_replyKeyboardMarkup;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarLayout;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BotCommandsMenuView;
import ir.eitaa.ui.Components.EditTextCaption;
import ir.eitaa.ui.Components.EmojiView;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SeekBar;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.StickersAlert;
import ir.eitaa.ui.Components.TextStyleSpan;
import ir.eitaa.ui.Components.VideoTimelineView;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.GroupStickersActivity;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.StickersActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class ChatActivityEnterView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate, StickersAlert.StickersAlertDelegate {
    private AccountInstance accountInstance;
    private AdjustPanLayoutHelper adjustPanLayoutHelper;
    private boolean allowGifs;
    private boolean allowShowTopView;
    private boolean allowStickers;
    protected int animatedTop;
    private int animatingContentType;
    private HashMap<View, Float> animationParamsX;
    private ImageView attachButton;
    private LinearLayout attachLayout;
    private ImageView audioSendButton;
    private TLRPC$TL_document audioToSend;
    private MessageObject audioToSendMessageObject;
    private String audioToSendPath;
    private AnimatorSet audioVideoButtonAnimation;
    private FrameLayout audioVideoButtonContainer;
    Paint backgroundPaint;
    private ImageView botButton;
    private ReplaceableIconDrawable botButtonDrawable;
    private MessageObject botButtonsMessageObject;
    int botCommandLastPosition;
    int botCommandLastTop;
    private BotCommandsMenuView.BotCommandsAdapter botCommandsAdapter;
    private BotCommandsMenuView botCommandsMenuButton;
    public BotCommandsMenuContainer botCommandsMenuContainer;
    private int botCount;
    private BotKeyboardView botKeyboardView;
    private boolean botKeyboardViewVisible;
    private MessageObject botMessageObject;
    private TLRPC$TL_replyKeyboardMarkup botReplyMarkup;
    private boolean calledRecordRunnable;
    private Drawable cameraDrawable;
    private Drawable cameraOutline;
    private boolean canWriteToChannel;
    private ImageView cancelBotButton;
    private NumberTextView captionLimitView;
    private boolean clearBotButtonsOnKeyboardOpen;
    private boolean closeAnimationInProgress;
    private int codePointCount;
    private boolean configAnimationsEnabled;
    private int currentAccount;
    private int currentEmojiIcon;
    private int currentLimit;
    private int currentPopupContentType;
    public ValueAnimator currentTopViewAnimation;
    private ChatActivityEnterViewDelegate delegate;
    private boolean destroyed;
    private long dialog_id;
    private float distCanMove;
    private AnimatorSet doneButtonAnimation;
    private ValueAnimator doneButtonColorAnimator;
    private FrameLayout doneButtonContainer;
    boolean doneButtonEnabled;
    private float doneButtonEnabledProgress;
    private ImageView doneButtonImage;
    private ContextProgressView doneButtonProgress;
    private final Drawable doneCheckDrawable;
    private Paint dotPaint;
    private CharSequence draftMessage;
    private boolean draftSearchWebpage;
    private boolean editingCaption;
    private MessageObject editingMessageObject;
    private ImageView[] emojiButton;
    private ImageView emojiButton1;
    private ImageView emojiButton2;
    private AnimatorSet emojiButtonAnimation;
    private int emojiPadding;
    private boolean emojiTabOpen;
    private EmojiView emojiView;
    private boolean emojiViewVisible;
    private ImageView expandStickersButton;
    private Runnable focusRunnable;
    private boolean forceShowSendButton;
    private boolean hasBotCommands;
    private boolean hasRecordVideo;
    private Runnable hideKeyboardRunnable;
    private boolean ignoreTextChange;
    private Drawable inactinveSendButtonDrawable;
    private TLRPC$ChatFull info;
    private int innerTextChange;
    private boolean isInitLineCount;
    private boolean isMxb;
    private boolean isPaste;
    private boolean isPaused;
    private int keyboardHeight;
    private int keyboardHeightLand;
    private boolean keyboardVisible;
    private int lastSizeChangeValue1;
    private boolean lastSizeChangeValue2;
    private long lastTypingTimeSend;
    private int lineCount;
    private int[] location;
    private Drawable lockShadowDrawable;
    private View.AccessibilityDelegate mediaMessageButtonsDelegate;
    protected EditTextCaption messageEditText;
    boolean messageTransitionIsRunning;
    private TLRPC$WebPage messageWebPage;
    private boolean messageWebPageSearch;
    private Drawable micDrawable;
    private Drawable micOutline;
    private Runnable moveToSendStateRunnable;
    private boolean needShowTopView;
    private int notificationsIndex;
    private ImageView notifyButton;
    private CrossOutDrawable notifySilentDrawable;
    private Runnable onFinishInitCameraRunnable;
    private Runnable openKeyboardRunnable;
    private int originalViewHeight;
    private Paint paint;
    private AnimatorSet panelAnimation;
    private Activity parentActivity;
    private ChatActivity parentFragment;
    private RectF pauseRect;
    private TLRPC$KeyboardButton pendingLocationButton;
    private MessageObject pendingMessageObject;
    private MediaActionDrawable playPauseDrawable;
    public boolean preventInput;
    private CloseProgressDrawable2 progressDrawable;
    private Runnable recordAudioVideoRunnable;
    private boolean recordAudioVideoRunnableStarted;
    private RecordCircle recordCircle;
    private Property<RecordCircle, Float> recordCircleScale;
    private RLottieImageView recordDeleteImageView;
    private RecordDot recordDot;
    private int recordInterfaceState;
    private boolean recordIsCanceled;
    private FrameLayout recordPanel;
    private AnimatorSet recordPannelAnimation;
    private LinearLayout recordTimeContainer;
    private TimerView recordTimerView;
    private View recordedAudioBackground;
    private FrameLayout recordedAudioPanel;
    private ImageView recordedAudioPlayButton;
    private SeekBarWaveformView recordedAudioSeekBar;
    private TextView recordedAudioTimeTextView;
    private boolean recordingAudioVideo;
    private int recordingGuid;
    private android.graphics.Rect rect;
    private Paint redDotPaint;
    private boolean removeEmojiViewAfterAnimation;
    private MessageObject replyingMessageObject;
    private final Theme.ResourcesProvider resourcesProvider;
    private Property<View, Integer> roundedTranslationYProperty;
    private Runnable runEmojiPanelAnimation;
    private AnimatorSet runningAnimation;
    private AnimatorSet runningAnimation2;
    private AnimatorSet runningAnimationAudio;
    private int runningAnimationType;
    private boolean scheduleButtonHidden;
    private ImageView scheduledButton;
    private AnimatorSet scheduledButtonAnimation;
    private ValueAnimator searchAnimator;
    private float searchToOpenProgress;
    private int searchingType;
    private SeekBarWaveform seekBarWaveform;
    private View sendButton;
    private FrameLayout sendButtonContainer;
    private Drawable sendButtonDrawable;
    private Drawable sendButtonInverseDrawable;
    private boolean sendByEnter;
    private Drawable sendDrawable;
    private ActionBarPopupWindow.ActionBarPopupWindowLayout sendPopupLayout;
    private ActionBarPopupWindow sendPopupWindow;
    private android.graphics.Rect sendRect;
    private Runnable setTextFieldRunnable;
    protected boolean shouldAnimateEditTextWithBounds;
    private boolean showKeyboardOnResume;
    private Runnable showTopViewRunnable;
    private boolean silent;
    private SizeNotifierFrameLayout sizeNotifierLayout;
    private SlideTextView slideText;
    private SimpleTextView slowModeButton;
    private int slowModeTimer;
    private boolean smoothKeyboard;
    private float startedDraggingX;
    private AnimatedArrowDrawable stickersArrow;
    private boolean stickersDragging;
    private boolean stickersExpanded;
    private int stickersExpandedHeight;
    private Animator stickersExpansionAnim;
    private float stickersExpansionProgress;
    private boolean stickersTabOpen;
    private FrameLayout textFieldContainer;
    boolean textTransitionIsRunning;
    protected View topLineView;
    protected View topView;
    protected float topViewEnterProgress;
    protected boolean topViewShowed;
    private final ValueAnimator.AnimatorUpdateListener topViewUpdateListener;
    private TrendingStickersAlert trendingStickersAlert;
    private Runnable updateExpandabilityRunnable;
    private Runnable updateSlowModeRunnable;
    private ImageView videoSendButton;
    private VideoTimelineView videoTimelineView;
    private VideoEditedInfo videoToSendMessageObject;
    private boolean waitingForKeyboardOpen;
    private boolean waitingForKeyboardOpenAfterAnimation;
    private PowerManager.WakeLock wakeLock;
    private boolean wasSendTyping;

    public interface ChatActivityEnterViewDelegate {

        /* renamed from: ir.eitaa.ui.Components.ChatActivityEnterView$ChatActivityEnterViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$bottomPanelTranslationYChanged(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate, float f) {
            }

            public static boolean $default$hasForwardingMessages(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
                return false;
            }

            public static boolean $default$hasScheduledMessages(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
                return true;
            }

            public static void $default$onTrendingStickersShowed(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate, boolean z) {
            }

            public static void $default$openScheduledMessages(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
            }

            public static void $default$prepareMessageSending(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
            }

            public static void $default$scrollToSendingMessage(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
            }
        }

        void bottomPanelTranslationYChanged(float translation);

        void didPressAttachButton();

        boolean hasForwardingMessages();

        boolean hasScheduledMessages();

        void needChangeVideoPreviewState(int state, float seekProgress);

        void needSendTyping();

        void needShowMediaBanHint();

        void needStartRecordAudio(int state);

        void needStartRecordVideo(int state, boolean notify, int scheduleDate);

        void onAttachButtonHidden();

        void onAttachButtonShow();

        void onAudioVideoInterfaceUpdated();

        void onMessageEditEnd(boolean loading);

        void onMessageSend(CharSequence message, boolean notify, int scheduleDate);

        void onPreAudioVideoRecord();

        void onSendLongClick();

        void onStickersExpandedChange();

        void onStickersTab(boolean opened);

        void onSwitchRecordMode(boolean video);

        void onTextChanged(CharSequence text, boolean bigChange);

        void onTextSelectionChanged(int start, int end);

        void onTextSpansChanged(CharSequence text);

        void onTrendingStickersShowed(boolean show);

        void onUpdateSlowModeButton(View button, boolean show, CharSequence time);

        void onWindowSizeChanged(int size);

        void openScheduledMessages();

        void prepareMessageSending();

        void scrollToSendingMessage();
    }

    static /* synthetic */ boolean lambda$new$9(View view, MotionEvent motionEvent) {
        return true;
    }

    public void checkAnimation() {
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    protected void onLineCountChanged(int oldLineCount, int newLineCount) {
    }

    protected boolean pannelAnimationEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SeekBarWaveformView extends View {
        public SeekBarWaveformView(Context context) {
            super(context);
            ChatActivityEnterView.this.seekBarWaveform = new SeekBarWaveform(context);
            ChatActivityEnterView.this.seekBarWaveform.setDelegate(new SeekBar.SeekBarDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$SeekBarWaveformView$eHvjXJohqdfPnmG4jF_u24xKcMY
                @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
                public /* synthetic */ void onSeekBarContinuousDrag(float f) {
                    SeekBar.SeekBarDelegate.CC.$default$onSeekBarContinuousDrag(this, f);
                }

                @Override // ir.eitaa.ui.Components.SeekBar.SeekBarDelegate
                public final void onSeekBarDrag(float f) {
                    this.f$0.lambda$new$0$ChatActivityEnterView$SeekBarWaveformView(f);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ChatActivityEnterView$SeekBarWaveformView(float f) {
            if (ChatActivityEnterView.this.audioToSendMessageObject != null) {
                ChatActivityEnterView.this.audioToSendMessageObject.audioProgress = f;
                MediaController.getInstance().seekToProgress(ChatActivityEnterView.this.audioToSendMessageObject, f);
            }
        }

        public void setWaveform(byte[] waveform) {
            ChatActivityEnterView.this.seekBarWaveform.setWaveform(waveform);
            invalidate();
        }

        public void setProgress(float progress) {
            ChatActivityEnterView.this.seekBarWaveform.setProgress(progress);
            invalidate();
        }

        public boolean isDragging() {
            return ChatActivityEnterView.this.seekBarWaveform.isDragging();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            boolean zOnTouch = ChatActivityEnterView.this.seekBarWaveform.onTouch(event.getAction(), event.getX(), event.getY());
            if (zOnTouch) {
                if (event.getAction() == 0) {
                    ChatActivityEnterView.this.requestDisallowInterceptTouchEvent(true);
                }
                invalidate();
            }
            return zOnTouch || super.onTouchEvent(event);
        }

        @Override // android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            super.onLayout(changed, left, top, right, bottom);
            ChatActivityEnterView.this.seekBarWaveform.setSize(right - left, bottom - top);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            ChatActivityEnterView.this.seekBarWaveform.setColors(ChatActivityEnterView.this.getThemedColor("chat_recordedVoiceProgress"), ChatActivityEnterView.this.getThemedColor("chat_recordedVoiceProgressInner"), ChatActivityEnterView.this.getThemedColor("chat_recordedVoiceProgress"));
            ChatActivityEnterView.this.seekBarWaveform.draw(canvas, this);
        }
    }

    private class RecordDot extends View {
        private float alpha;
        boolean attachedToWindow;
        RLottieDrawable drawable;
        private boolean enterAnimation;
        private boolean isIncr;
        private long lastUpdateTime;
        boolean playing;

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.attachedToWindow = true;
            if (this.playing) {
                this.drawable.start();
            }
            this.drawable.addParentView(this);
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.attachedToWindow = false;
            this.drawable.stop();
            this.drawable.removeParentView(this);
        }

        public RecordDot(Context context) {
            super(context);
            RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.chat_audio_record_delete, "" + R.raw.chat_audio_record_delete, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), false, (int[]) null);
            this.drawable = rLottieDrawable;
            rLottieDrawable.setCurrentParentView(this);
            this.drawable.setInvalidateOnProgressSet(true);
            updateColors();
        }

        public void updateColors() {
            int themedColor = ChatActivityEnterView.this.getThemedColor("chat_recordedVoiceDot");
            int themedColor2 = ChatActivityEnterView.this.getThemedColor("chat_messagePanelBackground");
            ChatActivityEnterView.this.redDotPaint.setColor(themedColor);
            this.drawable.beginApplyLayerColors();
            this.drawable.setLayerColor("Cup Red.**", themedColor);
            this.drawable.setLayerColor("Box.**", themedColor);
            this.drawable.setLayerColor("Line 1.**", themedColor2);
            this.drawable.setLayerColor("Line 2.**", themedColor2);
            this.drawable.setLayerColor("Line 3.**", themedColor2);
            this.drawable.commitApplyLayerColors();
            if (ChatActivityEnterView.this.playPauseDrawable != null) {
                ChatActivityEnterView.this.playPauseDrawable.setColor(ChatActivityEnterView.this.getThemedColor("chat_recordedVoicePlayPause"));
            }
        }

        public void resetAlpha() {
            this.alpha = 1.0f;
            this.lastUpdateTime = System.currentTimeMillis();
            this.isIncr = false;
            this.playing = false;
            this.drawable.stop();
            invalidate();
        }

        @Override // android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            this.drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.playing) {
                this.drawable.setAlpha((int) (this.alpha * 255.0f));
            }
            ChatActivityEnterView.this.redDotPaint.setAlpha((int) (this.alpha * 255.0f));
            long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdateTime;
            if (this.enterAnimation) {
                this.alpha = 1.0f;
            } else if (!this.isIncr && !this.playing) {
                float f = this.alpha - (jCurrentTimeMillis / 600.0f);
                this.alpha = f;
                if (f <= 0.0f) {
                    this.alpha = 0.0f;
                    this.isIncr = true;
                }
            } else {
                float f2 = this.alpha + (jCurrentTimeMillis / 600.0f);
                this.alpha = f2;
                if (f2 >= 1.0f) {
                    this.alpha = 1.0f;
                    this.isIncr = false;
                }
            }
            this.lastUpdateTime = System.currentTimeMillis();
            if (this.playing) {
                this.drawable.draw(canvas);
            }
            if (!this.playing || !this.drawable.hasBitmap()) {
                canvas.drawCircle(getMeasuredWidth() >> 1, getMeasuredHeight() >> 1, AndroidUtilities.dp(5.0f), ChatActivityEnterView.this.redDotPaint);
            }
            invalidate();
        }

        public void playDeleteAnimation() {
            this.playing = true;
            this.drawable.setProgress(0.0f);
            if (this.attachedToWindow) {
                this.drawable.start();
            }
        }
    }

    public class RecordCircle extends View {
        private float amplitude;
        private float animateAmplitudeDiff;
        private float animateToAmplitude;
        BlobDrawable bigWaveDrawable;
        private boolean canceledByGesture;
        private float circleRadius;
        private float circleRadiusAmplitude;
        public float drawingCircleRadius;
        public float drawingCx;
        public float drawingCy;
        private float exitTransition;
        public float iconScale;
        float idleProgress;
        boolean incIdle;
        private float lastMovingX;
        private float lastMovingY;
        private int lastSize;
        private long lastUpdateTime;
        private float lockAnimatedTranslation;
        Paint lockBackgroundPaint;
        Paint lockOutlinePaint;
        Paint lockPaint;
        private Paint p;
        private int paintAlpha;
        Path path;
        private boolean pressed;
        private float progressToSeekbarStep3;
        private float progressToSendButton;
        RectF rectF;
        private float scale;
        private boolean sendButtonVisible;
        private boolean showTooltip;
        private long showTooltipStartTime;
        private boolean showWaves;
        public boolean skipDraw;
        private int slideDelta;
        private float slideToCancelLockProgress;
        private float slideToCancelProgress;
        private float snapAnimationProgress;
        private float startTranslation;
        BlobDrawable tinyWaveDrawable;
        private float tooltipAlpha;
        private Drawable tooltipBackground;
        private Drawable tooltipBackgroundArrow;
        private StaticLayout tooltipLayout;
        private String tooltipMessage;
        private TextPaint tooltipPaint;
        private float tooltipWidth;
        private float touchSlop;
        private float transformToSeekbar;
        private VirtualViewHelper virtualViewHelper;
        public boolean voiceEnterTransitionInProgress;
        private float wavesEnterAnimation;

        public RecordCircle(Context context) {
            super(context);
            this.tinyWaveDrawable = new BlobDrawable(11);
            this.bigWaveDrawable = new BlobDrawable(12);
            this.tooltipPaint = new TextPaint(1);
            this.circleRadius = AndroidUtilities.dpf2(41.0f);
            this.circleRadiusAmplitude = AndroidUtilities.dp(30.0f);
            this.lockBackgroundPaint = new Paint(1);
            this.lockPaint = new Paint(1);
            this.lockOutlinePaint = new Paint(1);
            this.rectF = new RectF();
            this.path = new Path();
            this.wavesEnterAnimation = 0.0f;
            this.showWaves = true;
            this.p = new Paint(1);
            ChatActivityEnterView.this.micDrawable = getResources().getDrawable(R.drawable.input_mic_pressed).mutate();
            ChatActivityEnterView.this.micDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed"), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.cameraDrawable = getResources().getDrawable(R.drawable.input_video_pressed).mutate();
            ChatActivityEnterView.this.cameraDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed"), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.sendDrawable = getResources().getDrawable(R.drawable.attach_send).mutate();
            ChatActivityEnterView.this.sendDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed"), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.micOutline = getResources().getDrawable(R.drawable.input_mic).mutate();
            ChatActivityEnterView.this.micOutline.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.cameraOutline = getResources().getDrawable(R.drawable.input_video).mutate();
            ChatActivityEnterView.this.cameraOutline.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            VirtualViewHelper virtualViewHelper = new VirtualViewHelper(this);
            this.virtualViewHelper = virtualViewHelper;
            ViewCompat.setAccessibilityDelegate(this, virtualViewHelper);
            this.tinyWaveDrawable.minRadius = AndroidUtilities.dp(47.0f);
            this.tinyWaveDrawable.maxRadius = AndroidUtilities.dp(55.0f);
            this.tinyWaveDrawable.generateBlob();
            this.bigWaveDrawable.minRadius = AndroidUtilities.dp(47.0f);
            this.bigWaveDrawable.maxRadius = AndroidUtilities.dp(55.0f);
            this.bigWaveDrawable.generateBlob();
            this.lockOutlinePaint.setStyle(Paint.Style.STROKE);
            this.lockOutlinePaint.setStrokeCap(Paint.Cap.ROUND);
            this.lockOutlinePaint.setStrokeWidth(AndroidUtilities.dpf2(1.7f));
            ChatActivityEnterView.this.lockShadowDrawable = getResources().getDrawable(R.drawable.lock_round_shadow);
            ChatActivityEnterView.this.lockShadowDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("key_chat_messagePanelVoiceLockShadow"), PorterDuff.Mode.MULTIPLY));
            this.tooltipBackground = Theme.createRoundRectDrawable(AndroidUtilities.dp(5.0f), ChatActivityEnterView.this.getThemedColor("chat_gifSaveHintBackground"));
            this.tooltipPaint.setTextSize(AndroidUtilities.dp(14.0f));
            this.tooltipBackgroundArrow = ContextCompat.getDrawable(context, R.drawable.tooltip_arrow);
            this.tooltipMessage = LocaleController.getString("SlideUpToLock", R.string.SlideUpToLock);
            this.iconScale = 1.0f;
            float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            this.touchSlop = scaledTouchSlop;
            this.touchSlop = scaledTouchSlop * scaledTouchSlop;
            updateColors();
        }

        public void setAmplitude(double value) {
            this.bigWaveDrawable.setValue((float) (Math.min(1800.0d, value) / 1800.0d), true);
            this.tinyWaveDrawable.setValue((float) (Math.min(1800.0d, value) / 1800.0d), false);
            float fMin = (float) (Math.min(1800.0d, value) / 1800.0d);
            this.animateToAmplitude = fMin;
            this.animateAmplitudeDiff = (fMin - this.amplitude) / 375.0f;
            invalidate();
        }

        public float getScale() {
            return this.scale;
        }

        @Keep
        public void setScale(float value) {
            this.scale = value;
            invalidate();
        }

        @Keep
        public void setLockAnimatedTranslation(float value) {
            this.lockAnimatedTranslation = value;
            invalidate();
        }

        @Keep
        public void setSnapAnimationProgress(float snapAnimationProgress) {
            this.snapAnimationProgress = snapAnimationProgress;
            invalidate();
        }

        @Keep
        public float getLockAnimatedTranslation() {
            return this.lockAnimatedTranslation;
        }

        public boolean isSendButtonVisible() {
            return this.sendButtonVisible;
        }

        public void setSendButtonInvisible() {
            this.sendButtonVisible = false;
            invalidate();
        }

        public int setLockTranslation(float value) {
            if (value == 10000.0f) {
                this.sendButtonVisible = false;
                this.lockAnimatedTranslation = -1.0f;
                this.startTranslation = -1.0f;
                invalidate();
                this.snapAnimationProgress = 0.0f;
                this.transformToSeekbar = 0.0f;
                this.exitTransition = 0.0f;
                this.iconScale = 1.0f;
                this.scale = 0.0f;
                this.tooltipAlpha = 0.0f;
                this.showTooltip = false;
                this.progressToSendButton = 0.0f;
                this.slideToCancelProgress = 1.0f;
                this.slideToCancelLockProgress = 1.0f;
                this.canceledByGesture = false;
                return 0;
            }
            if (this.sendButtonVisible) {
                return 2;
            }
            if (this.lockAnimatedTranslation == -1.0f) {
                this.startTranslation = value;
            }
            this.lockAnimatedTranslation = value;
            invalidate();
            if (this.canceledByGesture || this.slideToCancelProgress < 0.7f || this.startTranslation - this.lockAnimatedTranslation < AndroidUtilities.dp(57.0f)) {
                return 1;
            }
            this.sendButtonVisible = true;
            return 2;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) throws InterruptedException {
            if (this.sendButtonVisible) {
                int x = (int) event.getX();
                int y = (int) event.getY();
                if (event.getAction() == 0) {
                    boolean zContains = ChatActivityEnterView.this.pauseRect.contains(x, y);
                    this.pressed = zContains;
                    return zContains;
                }
                if (this.pressed) {
                    if (event.getAction() == 1 && ChatActivityEnterView.this.pauseRect.contains(x, y)) {
                        if (ChatActivityEnterView.this.videoSendButton != null && ChatActivityEnterView.this.videoSendButton.getTag() != null) {
                            ChatActivityEnterView.this.delegate.needStartRecordVideo(3, true, 0);
                        } else {
                            MediaController.getInstance().stopRecording(2, true, 0);
                            ChatActivityEnterView.this.delegate.needStartRecordAudio(0);
                        }
                        ChatActivityEnterView.this.slideText.setEnabled(false);
                    }
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            int iDp = AndroidUtilities.dp(194.0f);
            if (this.lastSize != size) {
                this.lastSize = size;
                StaticLayout staticLayout = new StaticLayout(this.tooltipMessage, this.tooltipPaint, AndroidUtilities.dp(220.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                this.tooltipLayout = staticLayout;
                int lineCount = staticLayout.getLineCount();
                this.tooltipWidth = 0.0f;
                for (int i = 0; i < lineCount; i++) {
                    float lineWidth = this.tooltipLayout.getLineWidth(i);
                    if (lineWidth > this.tooltipWidth) {
                        this.tooltipWidth = lineWidth;
                    }
                }
            }
            StaticLayout staticLayout2 = this.tooltipLayout;
            if (staticLayout2 != null && staticLayout2.getLineCount() > 1) {
                iDp += this.tooltipLayout.getHeight() - this.tooltipLayout.getLineBottom(0);
            }
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(iDp, 1073741824));
            float measuredWidth = getMeasuredWidth() * 0.35f;
            if (measuredWidth > AndroidUtilities.dp(140.0f)) {
                measuredWidth = AndroidUtilities.dp(140.0f);
            }
            this.slideDelta = (int) ((-measuredWidth) * (1.0f - this.slideToCancelProgress));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0566  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x068c  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0693  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x06b1  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x06de  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0830  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0835  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0849  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x0863  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x086d  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x089a  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x0995  */
        /* JADX WARN: Removed duplicated region for block: B:234:0x09a4  */
        /* JADX WARN: Removed duplicated region for block: B:240:0x0a7a  */
        /* JADX WARN: Removed duplicated region for block: B:245:0x0ab6  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01b9  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r38) {
            /*
                Method dump skipped, instructions count: 2747
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.RecordCircle.onDraw(android.graphics.Canvas):void");
        }

        public void drawIcon(Canvas canvas, int cx, int cy, float alpha) {
            Drawable drawable;
            Drawable drawable2 = null;
            if (isSendButtonVisible()) {
                if (this.progressToSendButton != 1.0f) {
                    drawable2 = (ChatActivityEnterView.this.videoSendButton == null || ChatActivityEnterView.this.videoSendButton.getTag() == null) ? ChatActivityEnterView.this.micDrawable : ChatActivityEnterView.this.cameraDrawable;
                }
                drawable = ChatActivityEnterView.this.sendDrawable;
            } else {
                drawable = (ChatActivityEnterView.this.videoSendButton == null || ChatActivityEnterView.this.videoSendButton.getTag() == null) ? ChatActivityEnterView.this.micDrawable : ChatActivityEnterView.this.cameraDrawable;
            }
            Drawable drawable3 = drawable;
            Drawable drawable4 = drawable2;
            ChatActivityEnterView.this.sendRect.set(cx - (drawable3.getIntrinsicWidth() / 2), cy - (drawable3.getIntrinsicHeight() / 2), (drawable3.getIntrinsicWidth() / 2) + cx, (drawable3.getIntrinsicHeight() / 2) + cy);
            drawable3.setBounds(ChatActivityEnterView.this.sendRect);
            if (drawable4 != null) {
                drawable4.setBounds(cx - (drawable4.getIntrinsicWidth() / 2), cy - (drawable4.getIntrinsicHeight() / 2), cx + (drawable4.getIntrinsicWidth() / 2), cy + (drawable4.getIntrinsicHeight() / 2));
            }
            drawIconInternal(canvas, drawable3, drawable4, this.progressToSendButton, (int) (alpha * 255.0f));
        }

        private void drawIconInternal(Canvas canvas, Drawable drawable, Drawable replaceDrawable, float progressToSendButton, int alpha) {
            if (progressToSendButton == 0.0f || progressToSendButton == 1.0f || replaceDrawable == null) {
                boolean z = this.canceledByGesture;
                if (z && this.slideToCancelProgress == 1.0f) {
                    (ChatActivityEnterView.this.isInVideoMode() ? ChatActivityEnterView.this.videoSendButton : ChatActivityEnterView.this.audioSendButton).setAlpha(1.0f);
                    setVisibility(8);
                    return;
                }
                if (!z || this.slideToCancelProgress >= 1.0f) {
                    if (z) {
                        return;
                    }
                    drawable.setAlpha(alpha);
                    drawable.draw(canvas);
                    return;
                }
                Drawable drawable2 = ChatActivityEnterView.this.isInVideoMode() ? ChatActivityEnterView.this.cameraOutline : ChatActivityEnterView.this.micOutline;
                drawable2.setBounds(drawable.getBounds());
                float f = this.slideToCancelProgress;
                int i = (int) (f >= 0.93f ? ((f - 0.93f) / 0.07f) * 255.0f : 0.0f);
                drawable2.setAlpha(i);
                drawable2.draw(canvas);
                drawable2.setAlpha(255);
                drawable.setAlpha(255 - i);
                drawable.draw(canvas);
                return;
            }
            canvas.save();
            canvas.scale(progressToSendButton, progressToSendButton, drawable.getBounds().centerX(), drawable.getBounds().centerY());
            float f2 = alpha;
            drawable.setAlpha((int) (f2 * progressToSendButton));
            drawable.draw(canvas);
            canvas.restore();
            canvas.save();
            float f3 = 1.0f - progressToSendButton;
            canvas.scale(f3, f3, drawable.getBounds().centerX(), drawable.getBounds().centerY());
            replaceDrawable.setAlpha((int) (f2 * f3));
            replaceDrawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        protected boolean dispatchHoverEvent(MotionEvent event) {
            return super.dispatchHoverEvent(event) || this.virtualViewHelper.dispatchHoverEvent(event);
        }

        public void setTransformToSeekbar(float value) {
            this.transformToSeekbar = value;
            invalidate();
        }

        public float getTransformToSeekbarProgressStep3() {
            return this.progressToSeekbarStep3;
        }

        @Keep
        public float getExitTransition() {
            return this.exitTransition;
        }

        @Keep
        public void setExitTransition(float exitTransition) {
            this.exitTransition = exitTransition;
            invalidate();
        }

        public void updateColors() {
            ChatActivityEnterView.this.paint.setColor(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoiceBackground"));
            this.tinyWaveDrawable.paint.setColor(ColorUtils.setAlphaComponent(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoiceBackground"), 38));
            this.bigWaveDrawable.paint.setColor(ColorUtils.setAlphaComponent(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoiceBackground"), 76));
            this.tooltipPaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_gifSaveHintText"));
            this.tooltipBackground = Theme.createRoundRectDrawable(AndroidUtilities.dp(5.0f), ChatActivityEnterView.this.getThemedColor("chat_gifSaveHintBackground"));
            this.tooltipBackgroundArrow.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_gifSaveHintBackground"), PorterDuff.Mode.MULTIPLY));
            this.lockBackgroundPaint.setColor(ChatActivityEnterView.this.getThemedColor("key_chat_messagePanelVoiceLockBackground"));
            this.lockPaint.setColor(ChatActivityEnterView.this.getThemedColor("key_chat_messagePanelVoiceLock"));
            this.lockOutlinePaint.setColor(ChatActivityEnterView.this.getThemedColor("key_chat_messagePanelVoiceLock"));
            this.paintAlpha = ChatActivityEnterView.this.paint.getAlpha();
        }

        public void showTooltipIfNeed() {
            if (SharedConfig.lockRecordAudioVideoHint < 3) {
                this.showTooltip = true;
                this.showTooltipStartTime = System.currentTimeMillis();
            }
        }

        @Keep
        public float getSlideToCancelProgress() {
            return this.slideToCancelProgress;
        }

        @Keep
        public void setSlideToCancelProgress(float slideToCancelProgress) {
            this.slideToCancelProgress = slideToCancelProgress;
            float measuredWidth = getMeasuredWidth() * 0.35f;
            if (measuredWidth > AndroidUtilities.dp(140.0f)) {
                measuredWidth = AndroidUtilities.dp(140.0f);
            }
            this.slideDelta = (int) ((-measuredWidth) * (1.0f - slideToCancelProgress));
            invalidate();
        }

        public void canceledByGesture() {
            this.canceledByGesture = true;
        }

        public void setMovingCords(float x, float y) {
            float f = this.lastMovingX;
            float f2 = (x - f) * (x - f);
            float f3 = this.lastMovingY;
            float f4 = f2 + ((y - f3) * (y - f3));
            this.lastMovingY = y;
            this.lastMovingX = x;
            if (this.showTooltip && this.tooltipAlpha == 0.0f && f4 > this.touchSlop) {
                this.showTooltipStartTime = System.currentTimeMillis();
            }
        }

        public void showWaves(boolean b, boolean animated) {
            if (!animated) {
                this.wavesEnterAnimation = b ? 1.0f : 0.5f;
            }
            this.showWaves = b;
        }

        public void drawWaves(Canvas canvas, float cx, float cy, float additionalScale) {
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.wavesEnterAnimation);
            float f = this.slideToCancelProgress;
            float f2 = f > 0.7f ? 1.0f : f / 0.7f;
            canvas.save();
            float f3 = this.scale * f2 * interpolation * (BlobDrawable.SCALE_BIG_MIN + (this.bigWaveDrawable.amplitude * 1.4f)) * additionalScale;
            canvas.scale(f3, f3, cx, cy);
            BlobDrawable blobDrawable = this.bigWaveDrawable;
            blobDrawable.draw(cx, cy, canvas, blobDrawable.paint);
            canvas.restore();
            float f4 = this.scale * f2 * interpolation * (BlobDrawable.SCALE_SMALL_MIN + (this.tinyWaveDrawable.amplitude * 1.4f)) * additionalScale;
            canvas.save();
            canvas.scale(f4, f4, cx, cy);
            BlobDrawable blobDrawable2 = this.tinyWaveDrawable;
            blobDrawable2.draw(cx, cy, canvas, blobDrawable2.paint);
            canvas.restore();
        }

        private class VirtualViewHelper extends ExploreByTouchHelper {
            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected boolean onPerformActionForVirtualView(int id, int action, Bundle args) {
                return true;
            }

            public VirtualViewHelper(View host) {
                super(host);
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected int getVirtualViewAt(float x, float y) {
                if (!RecordCircle.this.isSendButtonVisible()) {
                    return -1;
                }
                if (ChatActivityEnterView.this.sendRect.contains((int) x, (int) y)) {
                    return 1;
                }
                return ChatActivityEnterView.this.pauseRect.contains(x, y) ? 2 : -1;
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected void getVisibleVirtualViews(List<Integer> list) {
                if (RecordCircle.this.isSendButtonVisible()) {
                    list.add(1);
                    list.add(2);
                }
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected void onPopulateNodeForVirtualView(int id, AccessibilityNodeInfoCompat info) {
                if (id == 1) {
                    info.setBoundsInParent(ChatActivityEnterView.this.sendRect);
                    info.setText(LocaleController.getString("Send", R.string.Send));
                } else if (id == 2) {
                    ChatActivityEnterView.this.rect.set((int) ChatActivityEnterView.this.pauseRect.left, (int) ChatActivityEnterView.this.pauseRect.top, (int) ChatActivityEnterView.this.pauseRect.right, (int) ChatActivityEnterView.this.pauseRect.bottom);
                    info.setBoundsInParent(ChatActivityEnterView.this.rect);
                    info.setText(LocaleController.getString("Stop", R.string.Stop));
                }
            }
        }
    }

    public ChatActivityEnterView(Activity context, SizeNotifierFrameLayout parent, ChatActivity fragment, final boolean isChat) {
        this(context, parent, fragment, isChat, null, false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ChatActivityEnterView(final Activity context, SizeNotifierFrameLayout parent, final ChatActivity fragment, final boolean isChat, final Theme.ResourcesProvider resourcesProvider, boolean isMxb) {
        String str;
        int i;
        String str2;
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        super(context);
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        this.accountInstance = AccountInstance.getInstance(i2);
        this.lineCount = 1;
        this.currentLimit = -1;
        this.animationParamsX = new HashMap<>();
        this.mediaMessageButtonsDelegate = new View.AccessibilityDelegate() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName("android.widget.ImageButton");
                info.setClickable(true);
                info.setLongClickable(true);
            }
        };
        this.emojiButton = new ImageView[2];
        this.currentPopupContentType = -1;
        this.currentEmojiIcon = -1;
        this.isPaused = true;
        this.startedDraggingX = -1.0f;
        this.distCanMove = AndroidUtilities.dp(80.0f);
        this.location = new int[2];
        this.messageWebPageSearch = true;
        this.animatingContentType = -1;
        this.doneButtonEnabledProgress = 1.0f;
        this.doneButtonEnabled = true;
        this.openKeyboardRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChatActivityEnterView.this.destroyed) {
                    return;
                }
                ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                if (chatActivityEnterView.messageEditText == null || !chatActivityEnterView.waitingForKeyboardOpen || ChatActivityEnterView.this.keyboardVisible || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                    return;
                }
                ChatActivityEnterView.this.messageEditText.requestFocus();
                AndroidUtilities.showKeyboard(ChatActivityEnterView.this.messageEditText);
                AndroidUtilities.cancelRunOnUIThread(ChatActivityEnterView.this.openKeyboardRunnable);
                AndroidUtilities.runOnUIThread(ChatActivityEnterView.this.openKeyboardRunnable, 100L);
            }
        };
        this.updateExpandabilityRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.3
            private int lastKnownPage = -1;

            @Override // java.lang.Runnable
            public void run() {
                int currentPage;
                if (ChatActivityEnterView.this.emojiView == null || (currentPage = ChatActivityEnterView.this.emojiView.getCurrentPage()) == this.lastKnownPage) {
                    return;
                }
                this.lastKnownPage = currentPage;
                boolean z = ChatActivityEnterView.this.stickersTabOpen;
                ChatActivityEnterView.this.stickersTabOpen = currentPage == 1 || currentPage == 2;
                boolean z2 = ChatActivityEnterView.this.emojiTabOpen;
                ChatActivityEnterView.this.emojiTabOpen = currentPage == 0;
                if (ChatActivityEnterView.this.stickersExpanded) {
                    if (ChatActivityEnterView.this.searchingType != 0) {
                        ChatActivityEnterView.this.setSearchingTypeInternal(currentPage != 0 ? 1 : 2, true);
                        ChatActivityEnterView.this.checkStickresExpandHeight();
                    } else if (!ChatActivityEnterView.this.stickersTabOpen) {
                        ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                    }
                }
                if (z == ChatActivityEnterView.this.stickersTabOpen && z2 == ChatActivityEnterView.this.emojiTabOpen) {
                    return;
                }
                ChatActivityEnterView.this.checkSendButton(true);
            }
        };
        this.roundedTranslationYProperty = new Property<View, Integer>(Integer.class, "translationY") { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.4
            @Override // android.util.Property
            public Integer get(View object) {
                return Integer.valueOf(Math.round(object.getTranslationY()));
            }

            @Override // android.util.Property
            public void set(View object, Integer value) {
                object.setTranslationY(value.intValue());
            }
        };
        this.recordCircleScale = new Property<RecordCircle, Float>(Float.class, "scale") { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.5
            @Override // android.util.Property
            public Float get(RecordCircle object) {
                return Float.valueOf(object.getScale());
            }

            @Override // android.util.Property
            public void set(RecordCircle object, Float value) {
                object.setScale(value.floatValue());
            }
        };
        this.redDotPaint = new Paint(1);
        this.onFinishInitCameraRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ChatActivityEnterView.this.delegate != null) {
                    ChatActivityEnterView.this.delegate.needStartRecordVideo(0, true, 0);
                }
            }
        };
        this.recordAudioVideoRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.7
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (ChatActivityEnterView.this.delegate == null || ChatActivityEnterView.this.parentActivity == null) {
                    return;
                }
                ChatActivityEnterView.this.delegate.onPreAudioVideoRecord();
                ChatActivityEnterView.this.calledRecordRunnable = true;
                ChatActivityEnterView.this.recordAudioVideoRunnableStarted = false;
                ChatActivityEnterView.this.slideText.setAlpha(1.0f);
                ChatActivityEnterView.this.slideText.setTranslationY(0.0f);
                if (ChatActivityEnterView.this.videoSendButton == null || ChatActivityEnterView.this.videoSendButton.getTag() == null) {
                    if (ChatActivityEnterView.this.parentFragment == null || Build.VERSION.SDK_INT < 23 || ChatActivityEnterView.this.parentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
                        ChatActivityEnterView.this.delegate.needStartRecordAudio(1);
                        ChatActivityEnterView.this.startedDraggingX = -1.0f;
                        MediaController.getInstance().startRecording(ChatActivityEnterView.this.currentAccount, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), ChatActivityEnterView.this.recordingGuid);
                        ChatActivityEnterView.this.recordingAudioVideo = true;
                        ChatActivityEnterView.this.updateRecordIntefrace(0);
                        ChatActivityEnterView.this.recordTimerView.start();
                        ChatActivityEnterView.this.recordDot.enterAnimation = false;
                        ChatActivityEnterView.this.audioVideoButtonContainer.getParent().requestDisallowInterceptTouchEvent(true);
                        ChatActivityEnterView.this.recordCircle.showWaves(true, false);
                        return;
                    }
                    ChatActivityEnterView.this.parentActivity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 3);
                    return;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    boolean z = ChatActivityEnterView.this.parentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
                    boolean z2 = ChatActivityEnterView.this.parentActivity.checkSelfPermission("android.permission.CAMERA") == 0;
                    if (!z || !z2) {
                        String[] strArr = new String[(z || z2) ? 1 : 2];
                        if (!z && !z2) {
                            strArr[0] = "android.permission.RECORD_AUDIO";
                            strArr[1] = "android.permission.CAMERA";
                        } else if (!z) {
                            strArr[0] = "android.permission.RECORD_AUDIO";
                        } else {
                            strArr[0] = "android.permission.CAMERA";
                        }
                        ChatActivityEnterView.this.parentActivity.requestPermissions(strArr, 3);
                        return;
                    }
                }
                if (!CameraController.getInstance().isCameraInitied()) {
                    CameraController.getInstance().initCamera(ChatActivityEnterView.this.onFinishInitCameraRunnable);
                } else {
                    ChatActivityEnterView.this.onFinishInitCameraRunnable.run();
                }
                if (ChatActivityEnterView.this.recordingAudioVideo) {
                    return;
                }
                ChatActivityEnterView.this.recordingAudioVideo = true;
                ChatActivityEnterView.this.updateRecordIntefrace(0);
                ChatActivityEnterView.this.recordCircle.showWaves(false, false);
                ChatActivityEnterView.this.recordTimerView.reset();
            }
        };
        this.paint = new Paint(1);
        this.pauseRect = new RectF();
        this.sendRect = new android.graphics.Rect();
        this.rect = new android.graphics.Rect();
        this.isMxb = false;
        this.runEmojiPanelAnimation = new Runnable() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.8
            @Override // java.lang.Runnable
            public void run() {
                if (ChatActivityEnterView.this.panelAnimation == null || ChatActivityEnterView.this.panelAnimation.isRunning()) {
                    return;
                }
                ChatActivityEnterView.this.panelAnimation.start();
            }
        };
        this.backgroundPaint = new Paint();
        this.topViewUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$2VXaPKhceY9idsnHxSvf1yMD_M8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$25$ChatActivityEnterView(valueAnimator);
            }
        };
        this.botCommandLastPosition = -1;
        this.resourcesProvider = resourcesProvider;
        this.isMxb = isMxb;
        this.smoothKeyboard = isChat && SharedConfig.smoothKeyboard && !AndroidUtilities.isInMultiwindow && (fragment == null || !fragment.isInBubbleMode());
        Paint paint = new Paint(1);
        this.dotPaint = paint;
        paint.setColor(getThemedColor("chat_emojiPanelNewTrending"));
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setClipChildren(false);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recordStarted);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recordStartError);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recordStopped);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.recordProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.audioDidSent);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.audioRouteChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.featuredStickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.sendingMessagesChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.audioRecordTooShort);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiLoaded);
        this.parentActivity = context;
        this.parentFragment = fragment;
        if (fragment != null) {
            this.recordingGuid = fragment.getClassGuid();
        }
        this.sizeNotifierLayout = parent;
        parent.setDelegate(this);
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        this.sendByEnter = globalMainSettings.getBoolean("send_by_enter", false);
        this.configAnimationsEnabled = globalMainSettings.getBoolean("view_animations", true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.textFieldContainer = frameLayout;
        frameLayout.setClipChildren(false);
        this.textFieldContainer.setClipToPadding(false);
        this.textFieldContainer.setPadding(0, AndroidUtilities.dp(1.0f), 0, 0);
        addView(this.textFieldContainer, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 1.0f, 0.0f, 0.0f));
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.9
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                if (ChatActivityEnterView.this.scheduledButton != null) {
                    int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp((ChatActivityEnterView.this.botButton == null || ChatActivityEnterView.this.botButton.getVisibility() != 0) ? 48.0f : 96.0f)) - AndroidUtilities.dp(48.0f);
                    ChatActivityEnterView.this.scheduledButton.layout(measuredWidth, ChatActivityEnterView.this.scheduledButton.getTop(), ChatActivityEnterView.this.scheduledButton.getMeasuredWidth() + measuredWidth, ChatActivityEnterView.this.scheduledButton.getBottom());
                }
                if (ChatActivityEnterView.this.animationParamsX.isEmpty()) {
                    return;
                }
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    Float f = (Float) ChatActivityEnterView.this.animationParamsX.get(childAt);
                    if (f != null) {
                        childAt.setTranslationX(f.floatValue() - childAt.getLeft());
                        childAt.animate().translationX(0.0f).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    }
                }
                ChatActivityEnterView.this.animationParamsX.clear();
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (child == ChatActivityEnterView.this.messageEditText) {
                    canvas.save();
                    canvas.clipRect(0, ((-getTop()) - ChatActivityEnterView.this.textFieldContainer.getTop()) - ChatActivityEnterView.this.getTop(), getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(6.0f));
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, child, drawingTime);
            }
        };
        frameLayout2.setClipChildren(false);
        this.textFieldContainer.addView(frameLayout2, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 48.0f, 0.0f));
        int i3 = 0;
        for (int i4 = 2; i3 < i4; i4 = 2) {
            this.emojiButton[i3] = new ImageView(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.10
                @Override // android.widget.ImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    if (getTag() == null || ChatActivityEnterView.this.attachLayout == null || ChatActivityEnterView.this.emojiViewVisible || MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).getUnreadStickerSets().isEmpty() || ChatActivityEnterView.this.dotPaint == null) {
                        return;
                    }
                    canvas.drawCircle((getWidth() / 2) + AndroidUtilities.dp(9.0f), (getHeight() / 2) - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), ChatActivityEnterView.this.dotPaint);
                }
            };
            this.emojiButton[i3].setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            this.emojiButton[i3].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (Build.VERSION.SDK_INT >= 21) {
                this.emojiButton[i3].setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor("listSelectorSDK21")));
            }
            frameLayout2.addView(this.emojiButton[i3], LayoutHelper.createFrame(48, 48.0f, 83, 3.0f, 0.0f, 0.0f, 0.0f));
            this.emojiButton[i3].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$-aSJV8wXhqHEsxvAQ12XZkN7eIc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$ChatActivityEnterView(view);
                }
            });
            this.emojiButton[i3].setContentDescription(LocaleController.getString("AccDescrEmojiButton", R.string.AccDescrEmojiButton));
            if (i3 == 1) {
                this.emojiButton[i3].setVisibility(4);
                this.emojiButton[i3].setAlpha(0.0f);
                this.emojiButton[i3].setScaleX(0.1f);
                this.emojiButton[i3].setScaleY(0.1f);
                this.emojiButton2 = this.emojiButton[i3];
            } else {
                this.emojiButton1 = this.emojiButton[i3];
            }
            i3++;
        }
        setEmojiButtonImage(false, false);
        NumberTextView numberTextView = new NumberTextView(context);
        this.captionLimitView = numberTextView;
        numberTextView.setVisibility(8);
        this.captionLimitView.setTextSize(15);
        this.captionLimitView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText"));
        this.captionLimitView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.captionLimitView.setCenterAlign(true);
        addView(this.captionLimitView, LayoutHelper.createFrame(48, 20.0f, 85, 3.0f, 0.0f, 0.0f, 48.0f));
        AnonymousClass11 anonymousClass11 = new AnonymousClass11(context, resourcesProvider, resourcesProvider, fragment, context);
        this.messageEditText = anonymousClass11;
        anonymousClass11.setDelegate(new EditTextCaption.EditTextCaptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$K5XIDaiEJ08vIsHx-O3ol53ml7I
            @Override // ir.eitaa.ui.Components.EditTextCaption.EditTextCaptionDelegate
            public final void onSpansChanged() {
                this.f$0.lambda$new$2$ChatActivityEnterView();
            }
        });
        this.messageEditText.setIncludeFontPadding(false);
        this.messageEditText.setWindowView(this.parentActivity.getWindow().getDecorView());
        ChatActivity chatActivity = this.parentFragment;
        TLRPC$EncryptedChat currentEncryptedChat = chatActivity != null ? chatActivity.getCurrentEncryptedChat() : null;
        this.messageEditText.setAllowTextEntitiesIntersection(supportsSendingNewEntities());
        updateFieldHint(false);
        this.messageEditText.setImeOptions(currentEncryptedChat != null ? 285212672 : 268435456);
        EditTextCaption editTextCaption = this.messageEditText;
        editTextCaption.setInputType(editTextCaption.getInputType() | 16384 | 131072);
        this.messageEditText.setSingleLine(false);
        this.messageEditText.setMaxLines(6);
        this.messageEditText.setTextSize(1, 18.0f);
        this.messageEditText.setGravity(80);
        this.messageEditText.setPadding(0, AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(12.0f));
        this.messageEditText.setBackgroundDrawable(null);
        this.messageEditText.setTextColor(getThemedColor("chat_messagePanelText"));
        this.messageEditText.setHintColor(getThemedColor("chat_messagePanelHint"));
        this.messageEditText.setHintTextColor(getThemedColor("chat_messagePanelHint"));
        this.messageEditText.setCursorColor(getThemedColor("chat_messagePanelCursor"));
        frameLayout2.addView(this.messageEditText, LayoutHelper.createFrame(-1, -2.0f, 80, 52.0f, 0.0f, isChat ? 50.0f : 2.0f, 0.0f));
        this.messageEditText.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.12
            boolean ctrlPressed = false;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i5, KeyEvent keyEvent) throws InterruptedException, IOException {
                if (i5 == 4 && !ChatActivityEnterView.this.keyboardVisible && ChatActivityEnterView.this.isPopupShowing()) {
                    if (keyEvent.getAction() == 1) {
                        if (ChatActivityEnterView.this.currentPopupContentType == 1 && ChatActivityEnterView.this.botButtonsMessageObject != null) {
                            MessagesController.getMainSettings(ChatActivityEnterView.this.currentAccount).edit().putInt("hidekeyboard_" + ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.botButtonsMessageObject.getId()).commit();
                        }
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.setSearchingTypeInternal(0, true);
                            if (ChatActivityEnterView.this.emojiView != null) {
                                ChatActivityEnterView.this.emojiView.closeSearch(true);
                            }
                            ChatActivityEnterView.this.messageEditText.requestFocus();
                        } else if (!ChatActivityEnterView.this.stickersExpanded) {
                            if (ChatActivityEnterView.this.stickersExpansionAnim == null) {
                                ChatActivityEnterView.this.showPopup(0, 0);
                            }
                        } else {
                            ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                        }
                    }
                    return true;
                }
                if (i5 == 66 && ((this.ctrlPressed || ChatActivityEnterView.this.sendByEnter) && keyEvent.getAction() == 0 && ChatActivityEnterView.this.editingMessageObject == null)) {
                    ChatActivityEnterView.this.sendMessage();
                    return true;
                }
                if (i5 != 113 && i5 != 114) {
                    return false;
                }
                this.ctrlPressed = keyEvent.getAction() == 0;
                return true;
            }
        });
        this.messageEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.13
            boolean ctrlPressed = false;

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) throws InterruptedException, IOException {
                if (i5 == 4) {
                    ChatActivityEnterView.this.sendMessage();
                    return true;
                }
                if (keyEvent == null || i5 != 0) {
                    return false;
                }
                if ((!this.ctrlPressed && !ChatActivityEnterView.this.sendByEnter) || keyEvent.getAction() != 0 || ChatActivityEnterView.this.editingMessageObject != null) {
                    return false;
                }
                ChatActivityEnterView.this.sendMessage();
                return true;
            }
        });
        this.messageEditText.addTextChangedListener(new AnonymousClass14());
        if (isChat) {
            if (this.parentFragment != null) {
                Drawable drawableMutate = context.getResources().getDrawable(R.drawable.input_calendar1).mutate();
                Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.input_calendar2).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
                drawableMutate2.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_recordedVoiceDot"), PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableMutate2);
                ImageView imageView = new ImageView(context);
                this.scheduledButton = imageView;
                imageView.setImageDrawable(combinedDrawable);
                this.scheduledButton.setVisibility(8);
                this.scheduledButton.setContentDescription(LocaleController.getString("ScheduledMessages", R.string.ScheduledMessages));
                this.scheduledButton.setScaleType(ImageView.ScaleType.CENTER);
                if (Build.VERSION.SDK_INT >= 21) {
                    str = "listSelectorSDK21";
                    this.scheduledButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
                } else {
                    str = "listSelectorSDK21";
                }
                frameLayout2.addView(this.scheduledButton, LayoutHelper.createFrame(48, 48, 85));
                this.scheduledButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$1XstP6HCfcAsoLM8qOP-uOn6oug
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$3$ChatActivityEnterView(view);
                    }
                });
            } else {
                str = "listSelectorSDK21";
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.attachLayout = linearLayout;
            linearLayout.setOrientation(0);
            this.attachLayout.setEnabled(false);
            this.attachLayout.setPivotX(AndroidUtilities.dp(48.0f));
            this.attachLayout.setClipChildren(false);
            frameLayout2.addView(this.attachLayout, LayoutHelper.createFrame(-2, 48, 85));
            BotCommandsMenuView botCommandsMenuView = new BotCommandsMenuView(getContext());
            this.botCommandsMenuButton = botCommandsMenuView;
            botCommandsMenuView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$Mp6PrkfScYJDlGo7R9m8T1anTiU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4$ChatActivityEnterView(view);
                }
            });
            frameLayout2.addView(this.botCommandsMenuButton, LayoutHelper.createFrame(-2, 32.0f, 83, 10.0f, 8.0f, 10.0f, 8.0f));
            AndroidUtilities.updateViewVisibilityAnimated(this.botCommandsMenuButton, false, 1.0f, false);
            this.botCommandsMenuButton.setExpanded(true, false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            BotCommandsMenuContainer botCommandsMenuContainer = new BotCommandsMenuContainer(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.15
                @Override // ir.eitaa.ui.Components.BotCommandsMenuContainer
                protected void onDismiss() {
                    super.onDismiss();
                    ChatActivityEnterView.this.botCommandsMenuButton.setOpened(false);
                }
            };
            this.botCommandsMenuContainer = botCommandsMenuContainer;
            botCommandsMenuContainer.listView.setLayoutManager(linearLayoutManager);
            RecyclerListView recyclerListView = this.botCommandsMenuContainer.listView;
            BotCommandsMenuView.BotCommandsAdapter botCommandsAdapter = new BotCommandsMenuView.BotCommandsAdapter();
            this.botCommandsAdapter = botCommandsAdapter;
            recyclerListView.setAdapter(botCommandsAdapter);
            this.botCommandsMenuContainer.listView.setOnItemClickListener(new AnonymousClass16(resourcesProvider, fragment));
            this.botCommandsMenuContainer.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.17
                @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
                public boolean onItemClick(View view, int position) {
                    if (!(view instanceof BotCommandsMenuView.BotCommandView)) {
                        return false;
                    }
                    String command = ((BotCommandsMenuView.BotCommandView) view).getCommand();
                    ChatActivityEnterView.this.setFieldText(command + " ");
                    ChatActivityEnterView.this.botCommandsMenuContainer.dismiss();
                    return true;
                }
            });
            this.botCommandsMenuContainer.setClipToPadding(false);
            this.sizeNotifierLayout.addView(this.botCommandsMenuContainer, 14, LayoutHelper.createFrame(-1, -1, 80));
            this.botCommandsMenuContainer.setVisibility(8);
            ImageView imageView2 = new ImageView(context);
            this.botButton = imageView2;
            ReplaceableIconDrawable replaceableIconDrawable = new ReplaceableIconDrawable(context);
            this.botButtonDrawable = replaceableIconDrawable;
            imageView2.setImageDrawable(replaceableIconDrawable);
            this.botButtonDrawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            this.botButtonDrawable.setIcon(R.drawable.input_bot2, false);
            this.botButton.setScaleType(ImageView.ScaleType.CENTER);
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                this.botButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
            }
            this.botButton.setVisibility(8);
            this.attachLayout.addView(this.botButton, LayoutHelper.createLinear(48, 48));
            this.botButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$JJCbS5tVgGR7gjNkssMncI2Csiw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$5$ChatActivityEnterView(view);
                }
            });
            this.notifyButton = new ImageView(context);
            CrossOutDrawable crossOutDrawable = new CrossOutDrawable(context, R.drawable.input_notify_on, "chat_messagePanelIcons");
            this.notifySilentDrawable = crossOutDrawable;
            this.notifyButton.setImageDrawable(crossOutDrawable);
            this.notifySilentDrawable.setCrossOut(this.silent, false);
            ImageView imageView3 = this.notifyButton;
            if (this.silent) {
                i = R.string.AccDescrChanSilentOn;
                str2 = "AccDescrChanSilentOn";
            } else {
                i = R.string.AccDescrChanSilentOff;
                str2 = "AccDescrChanSilentOff";
            }
            imageView3.setContentDescription(LocaleController.getString(str2, i));
            this.notifyButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            this.notifyButton.setScaleType(ImageView.ScaleType.CENTER);
            if (i5 >= 21) {
                this.notifyButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
            }
            this.notifyButton.setVisibility((!this.canWriteToChannel || ((chatActivityEnterViewDelegate = this.delegate) != null && chatActivityEnterViewDelegate.hasScheduledMessages())) ? 8 : 0);
            this.attachLayout.addView(this.notifyButton, LayoutHelper.createLinear(48, 48));
            this.notifyButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.18
                private Toast visibleToast;

                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    int i6;
                    String str3;
                    ChatActivityEnterView.this.silent = !r6.silent;
                    if (ChatActivityEnterView.this.notifySilentDrawable == null) {
                        ChatActivityEnterView.this.notifySilentDrawable = new CrossOutDrawable(context, R.drawable.input_notify_on, "chat_messagePanelIcons");
                    }
                    ChatActivityEnterView.this.notifySilentDrawable.setCrossOut(ChatActivityEnterView.this.silent, true);
                    ChatActivityEnterView.this.notifyButton.setImageDrawable(ChatActivityEnterView.this.notifySilentDrawable);
                    MessagesController.getNotificationsSettings(ChatActivityEnterView.this.currentAccount).edit().putBoolean("silent_" + ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.silent).commit();
                    NotificationsController.getInstance(ChatActivityEnterView.this.currentAccount).updateServerNotificationsSettings(ChatActivityEnterView.this.dialog_id);
                    try {
                        Toast toast = this.visibleToast;
                        if (toast != null) {
                            toast.cancel();
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    fragment.getUndoView().showWithAction(0L, !ChatActivityEnterView.this.silent ? 54 : 55, (Runnable) null);
                    ImageView imageView4 = ChatActivityEnterView.this.notifyButton;
                    if (ChatActivityEnterView.this.silent) {
                        i6 = R.string.AccDescrChanSilentOn;
                        str3 = "AccDescrChanSilentOn";
                    } else {
                        i6 = R.string.AccDescrChanSilentOff;
                        str3 = "AccDescrChanSilentOff";
                    }
                    imageView4.setContentDescription(LocaleController.getString(str3, i6));
                    ChatActivityEnterView.this.updateFieldHint(true);
                }
            });
            ImageView imageView4 = new ImageView(context);
            this.attachButton = imageView4;
            imageView4.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            this.attachButton.setImageResource(R.drawable.input_attach);
            this.attachButton.setScaleType(ImageView.ScaleType.CENTER);
            if (i5 >= 21) {
                this.attachButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
            }
            this.attachLayout.addView(this.attachButton, LayoutHelper.createLinear(48, 48));
            this.attachButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$QUH4phR39wQUIzWp49YEZNLdk6E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$6$ChatActivityEnterView(view);
                }
            });
            this.attachButton.setContentDescription(LocaleController.getString("AccDescrAttachButton", R.string.AccDescrAttachButton));
        } else {
            str = "listSelectorSDK21";
        }
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.recordedAudioPanel = frameLayout3;
        frameLayout3.setVisibility(this.audioToSend == null ? 8 : 0);
        this.recordedAudioPanel.setFocusable(true);
        this.recordedAudioPanel.setFocusableInTouchMode(true);
        this.recordedAudioPanel.setClickable(true);
        frameLayout2.addView(this.recordedAudioPanel, LayoutHelper.createFrame(-1, 48, 80));
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.recordDeleteImageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.recordDeleteImageView.setAnimation(R.raw.chat_audio_record_delete_2, 28, 28);
        this.recordDeleteImageView.getAnimatedDrawable().setInvalidateOnProgressSet(true);
        updateRecordedDeleteIconColors();
        this.recordDeleteImageView.setContentDescription(LocaleController.getString("Delete", R.string.Delete));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 21) {
            this.recordDeleteImageView.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
        }
        this.recordedAudioPanel.addView(this.recordDeleteImageView, LayoutHelper.createFrame(48, 48.0f));
        this.recordDeleteImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$HuKPJhRxauZreF9AylPYV9wW278
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException, IOException {
                this.f$0.lambda$new$7$ChatActivityEnterView(view);
            }
        });
        VideoTimelineView videoTimelineView = new VideoTimelineView(context);
        this.videoTimelineView = videoTimelineView;
        videoTimelineView.setColor(getThemedColor("chat_messagePanelVideoFrame"));
        this.videoTimelineView.setRoundFrames(true);
        this.videoTimelineView.setDelegate(new VideoTimelineView.VideoTimelineViewDelegate() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.19
            @Override // ir.eitaa.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void onLeftProgressChanged(float progress) {
                if (ChatActivityEnterView.this.videoToSendMessageObject == null) {
                    return;
                }
                ChatActivityEnterView.this.videoToSendMessageObject.startTime = (long) (ChatActivityEnterView.this.videoToSendMessageObject.estimatedDuration * progress);
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(2, progress);
            }

            @Override // ir.eitaa.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void onRightProgressChanged(float progress) {
                if (ChatActivityEnterView.this.videoToSendMessageObject == null) {
                    return;
                }
                ChatActivityEnterView.this.videoToSendMessageObject.endTime = (long) (ChatActivityEnterView.this.videoToSendMessageObject.estimatedDuration * progress);
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(2, progress);
            }

            @Override // ir.eitaa.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void didStartDragging() {
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(1, 0.0f);
            }

            @Override // ir.eitaa.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void didStopDragging() {
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(0, 0.0f);
            }
        });
        this.recordedAudioPanel.addView(this.videoTimelineView, LayoutHelper.createFrame(-1, -1.0f, 19, 56.0f, 0.0f, 8.0f, 0.0f));
        VideoTimelineView.TimeHintView timeHintView = new VideoTimelineView.TimeHintView(context);
        this.videoTimelineView.setTimeHintView(timeHintView);
        this.sizeNotifierLayout.addView(timeHintView, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, 52.0f));
        View view = new View(context);
        this.recordedAudioBackground = view;
        view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), getThemedColor("chat_recordedVoiceBackground")));
        this.recordedAudioPanel.addView(this.recordedAudioBackground, LayoutHelper.createFrame(-1, 36.0f, 19, 48.0f, 0.0f, 0.0f, 0.0f));
        this.recordedAudioSeekBar = new SeekBarWaveformView(context);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        this.recordedAudioPanel.addView(linearLayout2, LayoutHelper.createFrame(-1, 32.0f, 19, 92.0f, 0.0f, 13.0f, 0.0f));
        this.playPauseDrawable = new MediaActionDrawable();
        this.recordedAudioPlayButton = new ImageView(context);
        Matrix matrix = new Matrix();
        matrix.postScale(0.8f, 0.8f, AndroidUtilities.dpf2(24.0f), AndroidUtilities.dpf2(24.0f));
        this.recordedAudioPlayButton.setImageMatrix(matrix);
        this.recordedAudioPlayButton.setImageDrawable(this.playPauseDrawable);
        this.recordedAudioPlayButton.setScaleType(ImageView.ScaleType.MATRIX);
        this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        this.recordedAudioPanel.addView(this.recordedAudioPlayButton, LayoutHelper.createFrame(48, 48.0f, 83, 48.0f, 0.0f, 13.0f, 0.0f));
        this.recordedAudioPlayButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$7bISy_1uV0JGcAcxWTQThCovSes
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IOException {
                this.f$0.lambda$new$8$ChatActivityEnterView(view2);
            }
        });
        TextView textView = new TextView(context);
        this.recordedAudioTimeTextView = textView;
        textView.setTextColor(getThemedColor("chat_messagePanelVoiceDuration"));
        this.recordedAudioTimeTextView.setTextSize(1, 13.0f);
        linearLayout2.addView(this.recordedAudioSeekBar, LayoutHelper.createLinear(0, 32, 1.0f, 16, 0, 0, 4, 0));
        linearLayout2.addView(this.recordedAudioTimeTextView, LayoutHelper.createLinear(-2, -2, 0.0f, 16));
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.recordPanel = frameLayout4;
        frameLayout4.setClipChildren(false);
        this.recordPanel.setVisibility(8);
        frameLayout2.addView(this.recordPanel, LayoutHelper.createFrame(-1, 48.0f));
        this.recordPanel.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$53hsQVaLLzCswDncoGjNGNe_nvk
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ChatActivityEnterView.lambda$new$9(view2, motionEvent);
            }
        });
        SlideTextView slideTextView = new SlideTextView(context);
        this.slideText = slideTextView;
        this.recordPanel.addView(slideTextView, LayoutHelper.createFrame(-1, -1.0f, 0, 45.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.recordTimeContainer = linearLayout3;
        linearLayout3.setOrientation(0);
        this.recordTimeContainer.setPadding(AndroidUtilities.dp(13.0f), 0, 0, 0);
        this.recordPanel.addView(this.recordTimeContainer, LayoutHelper.createFrame(-1, -1, 16));
        RecordDot recordDot = new RecordDot(context);
        this.recordDot = recordDot;
        this.recordTimeContainer.addView(recordDot, LayoutHelper.createLinear(28, 28, 16, 0, 0, 0, 0));
        TimerView timerView = new TimerView(context);
        this.recordTimerView = timerView;
        this.recordTimeContainer.addView(timerView, LayoutHelper.createLinear(-1, -1, 16, 6, 0, 0, 0));
        FrameLayout frameLayout5 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.20
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (child == ChatActivityEnterView.this.sendButton && ChatActivityEnterView.this.textTransitionIsRunning) {
                    return true;
                }
                return super.drawChild(canvas, child, drawingTime);
            }
        };
        this.sendButtonContainer = frameLayout5;
        frameLayout5.setClipChildren(false);
        this.sendButtonContainer.setClipToPadding(false);
        this.textFieldContainer.addView(this.sendButtonContainer, LayoutHelper.createFrame(48, 48, 85));
        FrameLayout frameLayout6 = new FrameLayout(context);
        this.audioVideoButtonContainer = frameLayout6;
        frameLayout6.setSoundEffectsEnabled(false);
        this.sendButtonContainer.addView(this.audioVideoButtonContainer, LayoutHelper.createFrame(48, 48.0f));
        this.audioVideoButtonContainer.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$vpxD9Uih9Ot54FCLseLOB6tN68A
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$new$16$ChatActivityEnterView(resourcesProvider, view2, motionEvent);
            }
        });
        ImageView imageView5 = new ImageView(context);
        this.audioSendButton = imageView5;
        imageView5.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.audioSendButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
        this.audioSendButton.setImageResource(R.drawable.input_mic);
        this.audioSendButton.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
        this.audioSendButton.setContentDescription(LocaleController.getString("AccDescrVoiceMessage", R.string.AccDescrVoiceMessage));
        this.audioSendButton.setFocusable(true);
        this.audioSendButton.setAccessibilityDelegate(this.mediaMessageButtonsDelegate);
        this.audioVideoButtonContainer.addView(this.audioSendButton, LayoutHelper.createFrame(48, 48.0f));
        if (isChat) {
            ImageView imageView6 = new ImageView(context);
            this.videoSendButton = imageView6;
            imageView6.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.videoSendButton.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
            this.videoSendButton.setImageResource(R.drawable.input_video);
            this.videoSendButton.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
            this.videoSendButton.setContentDescription(LocaleController.getString("AccDescrVideoMessage", R.string.AccDescrVideoMessage));
            this.videoSendButton.setFocusable(true);
            this.videoSendButton.setAccessibilityDelegate(this.mediaMessageButtonsDelegate);
            this.audioVideoButtonContainer.addView(this.videoSendButton, LayoutHelper.createFrame(48, 48.0f));
        }
        RecordCircle recordCircle = new RecordCircle(context);
        this.recordCircle = recordCircle;
        recordCircle.setVisibility(8);
        this.sizeNotifierLayout.addView(this.recordCircle, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, 0.0f));
        ImageView imageView7 = new ImageView(context);
        this.cancelBotButton = imageView7;
        imageView7.setVisibility(4);
        this.cancelBotButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView8 = this.cancelBotButton;
        CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
        this.progressDrawable = closeProgressDrawable2;
        imageView8.setImageDrawable(closeProgressDrawable2);
        this.cancelBotButton.setContentDescription(LocaleController.getString("Cancel", R.string.Cancel));
        this.progressDrawable.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelCancelInlineBot"), PorterDuff.Mode.MULTIPLY));
        this.cancelBotButton.setSoundEffectsEnabled(false);
        this.cancelBotButton.setScaleX(0.1f);
        this.cancelBotButton.setScaleY(0.1f);
        this.cancelBotButton.setAlpha(0.0f);
        if (i6 >= 21) {
            this.cancelBotButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
        }
        this.sendButtonContainer.addView(this.cancelBotButton, LayoutHelper.createFrame(48, 48.0f));
        this.cancelBotButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$bCc0CBm6pN4aqbcu92KeASa1LKk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$17$ChatActivityEnterView(view2);
            }
        });
        if (isInScheduleMode()) {
            this.sendButtonDrawable = context.getResources().getDrawable(R.drawable.input_schedule).mutate();
            this.sendButtonInverseDrawable = context.getResources().getDrawable(R.drawable.input_schedule).mutate();
            this.inactinveSendButtonDrawable = context.getResources().getDrawable(R.drawable.input_schedule).mutate();
        } else {
            this.sendButtonDrawable = context.getResources().getDrawable(R.drawable.ic_send).mutate();
            this.sendButtonInverseDrawable = context.getResources().getDrawable(R.drawable.ic_send).mutate();
            this.inactinveSendButtonDrawable = context.getResources().getDrawable(R.drawable.ic_send).mutate();
        }
        View view2 = new View(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.21
            private float animationDuration;
            private float animationProgress;
            private int drawableColor;
            private long lastAnimationTime;
            private int prevColorType;

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                int themedColor;
                int iDp;
                float f;
                float fDp;
                int measuredWidth = (getMeasuredWidth() - ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth()) / 2;
                int measuredHeight = (getMeasuredHeight() - ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight()) / 2;
                if (ChatActivityEnterView.this.isInScheduleMode()) {
                    measuredHeight -= AndroidUtilities.dp(1.0f);
                } else {
                    measuredWidth += AndroidUtilities.dp(2.0f);
                }
                int i7 = 1;
                boolean z = ChatActivityEnterView.this.sendPopupWindow != null && ChatActivityEnterView.this.sendPopupWindow.isShowing();
                if (z) {
                    themedColor = ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed");
                } else {
                    themedColor = ChatActivityEnterView.this.getThemedColor("chat_messagePanelSend");
                    i7 = 2;
                }
                if (themedColor != this.drawableColor) {
                    this.lastAnimationTime = SystemClock.elapsedRealtime();
                    int i8 = this.prevColorType;
                    if (i8 != 0 && i8 != i7) {
                        this.animationProgress = 0.0f;
                        if (z) {
                            this.animationDuration = 200.0f;
                        } else {
                            this.animationDuration = 120.0f;
                        }
                    } else {
                        this.animationProgress = 1.0f;
                    }
                    this.prevColorType = i7;
                    this.drawableColor = themedColor;
                    ChatActivityEnterView.this.sendButtonDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelSend"), PorterDuff.Mode.MULTIPLY));
                    int themedColor2 = ChatActivityEnterView.this.getThemedColor("chat_messagePanelIcons");
                    ChatActivityEnterView.this.inactinveSendButtonDrawable.setColorFilter(new PorterDuffColorFilter(Color.argb(180, Color.red(themedColor2), Color.green(themedColor2), Color.blue(themedColor2)), PorterDuff.Mode.MULTIPLY));
                    ChatActivityEnterView.this.sendButtonInverseDrawable.setColorFilter(new PorterDuffColorFilter(ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed"), PorterDuff.Mode.MULTIPLY));
                }
                if (this.animationProgress < 1.0f) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    float f2 = this.animationProgress + ((jElapsedRealtime - this.lastAnimationTime) / this.animationDuration);
                    this.animationProgress = f2;
                    if (f2 > 1.0f) {
                        this.animationProgress = 1.0f;
                    }
                    this.lastAnimationTime = jElapsedRealtime;
                    invalidate();
                }
                if (!z) {
                    if (ChatActivityEnterView.this.slowModeTimer != Integer.MAX_VALUE || ChatActivityEnterView.this.isInScheduleMode()) {
                        ChatActivityEnterView.this.sendButtonDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                        ChatActivityEnterView.this.sendButtonDrawable.draw(canvas);
                    } else {
                        ChatActivityEnterView.this.inactinveSendButtonDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                        ChatActivityEnterView.this.inactinveSendButtonDrawable.draw(canvas);
                    }
                }
                if (z || this.animationProgress != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_messagePanelSend"));
                    int iDp2 = AndroidUtilities.dp(20.0f);
                    if (z) {
                        ChatActivityEnterView.this.sendButtonInverseDrawable.setAlpha(255);
                        float f3 = this.animationProgress;
                        if (f3 <= 0.25f) {
                            f = iDp2;
                            fDp = AndroidUtilities.dp(2.0f) * CubicBezierInterpolator.EASE_IN.getInterpolation(f3 / 0.25f);
                        } else {
                            float f4 = f3 - 0.25f;
                            if (f4 <= 0.5f) {
                                f = iDp2;
                                fDp = AndroidUtilities.dp(2.0f) - (AndroidUtilities.dp(3.0f) * CubicBezierInterpolator.EASE_IN.getInterpolation(f4 / 0.5f));
                            } else {
                                iDp = (int) (iDp2 + (-AndroidUtilities.dp(1.0f)) + (AndroidUtilities.dp(1.0f) * CubicBezierInterpolator.EASE_IN.getInterpolation((f4 - 0.5f) / 0.25f)));
                                iDp2 = iDp;
                            }
                        }
                        iDp = (int) (f + fDp);
                        iDp2 = iDp;
                    } else {
                        int i9 = (int) ((1.0f - this.animationProgress) * 255.0f);
                        Theme.dialogs_onlineCirclePaint.setAlpha(i9);
                        ChatActivityEnterView.this.sendButtonInverseDrawable.setAlpha(i9);
                    }
                    canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, iDp2, Theme.dialogs_onlineCirclePaint);
                    ChatActivityEnterView.this.sendButtonInverseDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                    ChatActivityEnterView.this.sendButtonInverseDrawable.draw(canvas);
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (getAlpha() <= 0.0f) {
                    return false;
                }
                return super.onTouchEvent(event);
            }
        };
        this.sendButton = view2;
        view2.setVisibility(4);
        int themedColor = getThemedColor("chat_messagePanelSend");
        this.sendButton.setContentDescription(LocaleController.getString("Send", R.string.Send));
        this.sendButton.setSoundEffectsEnabled(false);
        this.sendButton.setScaleX(0.1f);
        this.sendButton.setScaleY(0.1f);
        this.sendButton.setAlpha(0.0f);
        if (i6 >= 21) {
            this.sendButton.setBackgroundDrawable(Theme.createSelectorDrawable(Color.argb(24, Color.red(themedColor), Color.green(themedColor), Color.blue(themedColor)), 1));
        }
        this.sendButtonContainer.addView(this.sendButton, LayoutHelper.createFrame(48, 48.0f));
        this.sendButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$mH5fQqAbtu79r54BWU-sdByu3No
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) throws InterruptedException, IOException {
                this.f$0.lambda$new$18$ChatActivityEnterView(view3);
            }
        });
        SimpleTextView simpleTextView = new SimpleTextView(context);
        this.slowModeButton = simpleTextView;
        simpleTextView.setTextSize(18);
        this.slowModeButton.setVisibility(4);
        this.slowModeButton.setSoundEffectsEnabled(false);
        this.slowModeButton.setScaleX(0.1f);
        this.slowModeButton.setScaleY(0.1f);
        this.slowModeButton.setAlpha(0.0f);
        this.slowModeButton.setPadding(0, 0, AndroidUtilities.dp(13.0f), 0);
        this.slowModeButton.setGravity(21);
        this.slowModeButton.setTextColor(getThemedColor("chat_messagePanelIcons"));
        this.sendButtonContainer.addView(this.slowModeButton, LayoutHelper.createFrame(64, 48, 53));
        this.slowModeButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$8NlORBbGcU4oN9Sfg-Rp7EAaYSY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$19$ChatActivityEnterView(view3);
            }
        });
        this.slowModeButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$yqxxnk5AJONqtWQJE0CgTTH_SUY
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.f$0.lambda$new$20$ChatActivityEnterView(view3);
            }
        });
        ImageView imageView9 = new ImageView(context) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.22
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (getAlpha() <= 0.0f) {
                    return false;
                }
                return super.onTouchEvent(event);
            }
        };
        this.expandStickersButton = imageView9;
        imageView9.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView10 = this.expandStickersButton;
        AnimatedArrowDrawable animatedArrowDrawable = new AnimatedArrowDrawable(getThemedColor("chat_messagePanelIcons"), false);
        this.stickersArrow = animatedArrowDrawable;
        imageView10.setImageDrawable(animatedArrowDrawable);
        this.expandStickersButton.setVisibility(8);
        this.expandStickersButton.setScaleX(0.1f);
        this.expandStickersButton.setScaleY(0.1f);
        this.expandStickersButton.setAlpha(0.0f);
        if (i6 >= 21) {
            this.expandStickersButton.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(str)));
        }
        this.sendButtonContainer.addView(this.expandStickersButton, LayoutHelper.createFrame(48, 48.0f));
        this.expandStickersButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$JpZzrdFTxYGSFzh0bvSewasdwsg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$21$ChatActivityEnterView(view3);
            }
        });
        this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrExpandPanel", R.string.AccDescrExpandPanel));
        FrameLayout frameLayout7 = new FrameLayout(context);
        this.doneButtonContainer = frameLayout7;
        frameLayout7.setVisibility(8);
        this.textFieldContainer.addView(this.doneButtonContainer, LayoutHelper.createFrame(48, 48, 85));
        this.doneButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$tj0lYy-_zTZRgUru7JnsfHbfYLw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$22$ChatActivityEnterView(view3);
            }
        });
        ShapeDrawable shapeDrawableCreateCircleDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(16.0f), getThemedColor("chat_messagePanelSend"));
        Drawable drawableMutate3 = context.getResources().getDrawable(R.drawable.input_done).mutate();
        this.doneCheckDrawable = drawableMutate3;
        drawableMutate3.setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelVoicePressed"), PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable2 = new CombinedDrawable(shapeDrawableCreateCircleDrawable, drawableMutate3, 0, AndroidUtilities.dp(1.0f));
        combinedDrawable2.setCustomSize(AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
        ImageView imageView11 = new ImageView(context);
        this.doneButtonImage = imageView11;
        imageView11.setScaleType(ImageView.ScaleType.CENTER);
        this.doneButtonImage.setImageDrawable(combinedDrawable2);
        this.doneButtonImage.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.doneButtonContainer.addView(this.doneButtonImage, LayoutHelper.createFrame(48, 48.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 0);
        this.doneButtonProgress = contextProgressView;
        contextProgressView.setVisibility(4);
        this.doneButtonContainer.addView(this.doneButtonProgress, LayoutHelper.createFrame(-1, -1.0f));
        SharedPreferences globalEmojiSettings = MessagesController.getGlobalEmojiSettings();
        this.keyboardHeight = globalEmojiSettings.getInt("kbd_height", AndroidUtilities.dp(200.0f));
        this.keyboardHeightLand = globalEmojiSettings.getInt("kbd_height_land3", AndroidUtilities.dp(200.0f));
        setRecordVideoButtonVisible(false, false);
        checkSendButton(false);
        checkChannelRights();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatActivityEnterView(View view) {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if (adjustPanLayoutHelper == null || !adjustPanLayoutHelper.animationInProgress()) {
            if (!isPopupShowing() || this.currentPopupContentType != 0) {
                showPopup(1, 0);
                this.emojiView.onOpen(this.messageEditText.length() > 0);
                return;
            }
            if (this.searchingType != 0) {
                setSearchingTypeInternal(0, true);
                EmojiView emojiView = this.emojiView;
                if (emojiView != null) {
                    emojiView.closeSearch(false);
                }
                this.messageEditText.requestFocus();
            }
            if (this.stickersExpanded) {
                setStickersExpanded(false, true, false);
                this.waitingForKeyboardOpenAfterAnimation = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$LktvEhXeZptDhzR2csj7Se-XNSA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$new$0$ChatActivityEnterView();
                    }
                }, 200L);
                return;
            }
            openKeyboardInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ChatActivityEnterView() {
        this.waitingForKeyboardOpenAfterAnimation = false;
        openKeyboardInternal();
    }

    /* renamed from: ir.eitaa.ui.Components.ChatActivityEnterView$11, reason: invalid class name */
    class AnonymousClass11 extends EditTextCaption {
        final /* synthetic */ Activity val$context;
        final /* synthetic */ ChatActivity val$fragment;
        final /* synthetic */ Theme.ResourcesProvider val$resourcesProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(Context context, Theme.ResourcesProvider resourcesProvider, final Theme.ResourcesProvider val$resourcesProvider, final ChatActivity val$fragment, final Activity val$context) {
            super(context, resourcesProvider);
            this.val$resourcesProvider = val$resourcesProvider;
            this.val$fragment = val$fragment;
            this.val$context = val$context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: send, reason: merged with bridge method [inline-methods] */
        public void lambda$onCreateInputConnection$0$ChatActivityEnterView$11(InputContentInfoCompat inputContentInfo, boolean notify, int scheduleDate) {
            if (inputContentInfo.getDescription().hasMimeType("image/gif")) {
                SendMessagesHelper.prepareSendingDocument(ChatActivityEnterView.this.accountInstance, null, null, inputContentInfo.getContentUri(), null, "image/gif", ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), inputContentInfo, null, notify, 0);
            } else {
                SendMessagesHelper.prepareSendingPhoto(ChatActivityEnterView.this.accountInstance, null, inputContentInfo.getContentUri(), ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), null, null, null, inputContentInfo, 0, null, notify, 0);
            }
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onMessageSend(null, true, scheduleDate);
            }
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            try {
                EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/gif", "image/*", "image/jpg", "image/png", "image/webp"});
                final Theme.ResourcesProvider resourcesProvider = this.val$resourcesProvider;
                return InputConnectionCompat.createWrapper(inputConnectionOnCreateInputConnection, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$11$8hJGsy_HPm_845SHzAk73_c-EVk
                    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
                    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                        return this.f$0.lambda$onCreateInputConnection$1$ChatActivityEnterView$11(resourcesProvider, inputContentInfoCompat, i, bundle);
                    }
                });
            } catch (Throwable th) {
                FileLog.e(th);
                return inputConnectionOnCreateInputConnection;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateInputConnection$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateInputConnection$1$ChatActivityEnterView$11(Theme.ResourcesProvider resourcesProvider, final InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
            if (BuildCompat.isAtLeastNMR1() && (i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (inputContentInfoCompat.getDescription().hasMimeType("image/gif") || SendMessagesHelper.shouldSendWebPAsSticker(null, inputContentInfoCompat.getContentUri())) {
                if (ChatActivityEnterView.this.isInScheduleMode()) {
                    AlertsCreator.createScheduleDatePickerDialog(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$11$VbFtCq-XDHIdMdpMwQqLOmVWIdw
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i2) {
                            this.f$0.lambda$onCreateInputConnection$0$ChatActivityEnterView$11(inputContentInfoCompat, z, i2);
                        }
                    }, resourcesProvider);
                } else {
                    lambda$onCreateInputConnection$0(inputContentInfoCompat, true, 0);
                }
            } else {
                editPhoto(inputContentInfoCompat.getContentUri(), inputContentInfoCompat.getDescription().getMimeType(0));
            }
            return true;
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            boolean z;
            if (!ChatActivityEnterView.this.stickersDragging && ChatActivityEnterView.this.stickersExpansionAnim == null) {
                if (ChatActivityEnterView.this.isPopupShowing() && event.getAction() == 0) {
                    if (ChatActivityEnterView.this.searchingType != 0) {
                        ChatActivityEnterView.this.setSearchingTypeInternal(0, false);
                        ChatActivityEnterView.this.emojiView.closeSearch(false);
                        requestFocus();
                        z = true;
                    } else {
                        z = false;
                    }
                    ChatActivityEnterView.this.showPopup(AndroidUtilities.usingHardwareInput ? 0 : 2, 0);
                    if (!ChatActivityEnterView.this.stickersExpanded) {
                        ChatActivityEnterView.this.openKeyboardInternal();
                    } else {
                        ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                        ChatActivityEnterView.this.waitingForKeyboardOpenAfterAnimation = true;
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$11$VRyi_wOobo6WRVwBmE3X8XYd7-w
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$onTouchEvent$2$ChatActivityEnterView$11();
                            }
                        }, 200L);
                    }
                    return z;
                }
                try {
                    return super.onTouchEvent(event);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onTouchEvent$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onTouchEvent$2$ChatActivityEnterView$11() {
            ChatActivityEnterView.this.waitingForKeyboardOpenAfterAnimation = false;
            ChatActivityEnterView.this.openKeyboardInternal();
        }

        @Override // android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            if (ChatActivityEnterView.this.preventInput) {
                return false;
            }
            return super.dispatchKeyEvent(event);
        }

        @Override // android.widget.TextView
        protected void onSelectionChanged(int selStart, int selEnd) {
            super.onSelectionChanged(selStart, selEnd);
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onTextSelectionChanged(selStart, selEnd);
            }
        }

        @Override // ir.eitaa.ui.Components.EditTextBoldCursor
        protected void extendActionMode(ActionMode actionMode, Menu menu) {
            if (ChatActivityEnterView.this.parentFragment != null) {
                ChatActivityEnterView.this.parentFragment.extendActionMode(menu);
            }
        }

        @Override // android.view.View
        public boolean requestRectangleOnScreen(android.graphics.Rect rectangle) {
            rectangle.bottom += AndroidUtilities.dp(1000.0f);
            return super.requestRectangleOnScreen(rectangle);
        }

        @Override // ir.eitaa.ui.Components.EditTextCaption, ir.eitaa.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            ChatActivityEnterView.this.isInitLineCount = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (ChatActivityEnterView.this.isInitLineCount) {
                ChatActivityEnterView.this.lineCount = getLineCount();
            }
            ChatActivityEnterView.this.isInitLineCount = false;
        }

        @Override // android.widget.EditText, android.widget.TextView
        public boolean onTextContextMenuItem(int id) {
            if (id == 16908322) {
                ChatActivityEnterView.this.isPaste = true;
            }
            ClipData primaryClip = ((ClipboardManager) getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() == 1 && primaryClip.getDescription().hasMimeType("image/*")) {
                editPhoto(primaryClip.getItemAt(0).getUri(), primaryClip.getDescription().getMimeType(0));
            }
            return super.onTextContextMenuItem(id);
        }

        private void editPhoto(final Uri uri, String mime) {
            final File fileGeneratePicturePath = AndroidUtilities.generatePicturePath(this.val$fragment.isSecretChat(), MimeTypeMap.getSingleton().getExtensionFromMimeType(mime));
            DispatchQueue dispatchQueue = Utilities.globalQueue;
            final Activity activity = this.val$context;
            final Theme.ResourcesProvider resourcesProvider = this.val$resourcesProvider;
            dispatchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$11$EDOUQ9n0dIVb8v9PhuL9TBO20JM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$editPhoto$4$ChatActivityEnterView$11(activity, uri, fileGeneratePicturePath, resourcesProvider);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$editPhoto$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$editPhoto$4$ChatActivityEnterView$11(Activity activity, Uri uri, final File file, final Theme.ResourcesProvider resourcesProvider) {
            try {
                InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
                while (true) {
                    int i = inputStreamOpenInputStream.read(bArr);
                    if (i > 0) {
                        fileOutputStream.write(bArr, 0, i);
                        fileOutputStream.flush();
                    } else {
                        inputStreamOpenInputStream.close();
                        fileOutputStream.close();
                        final MediaController.PhotoEntry photoEntry = new MediaController.PhotoEntry(0, -1, 0L, file.getAbsolutePath(), 0, false, 0, 0, 0L);
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(photoEntry);
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$11$NAkNvno1lmT26-Zvqslhg0Z44uo
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, Resources.NotFoundException {
                                this.f$0.lambda$editPhoto$3$ChatActivityEnterView$11(resourcesProvider, arrayList, photoEntry, file);
                            }
                        });
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$editPhoto$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$editPhoto$3$ChatActivityEnterView$11(Theme.ResourcesProvider resourcesProvider, ArrayList arrayList, final MediaController.PhotoEntry photoEntry, final File file) throws InterruptedException, Resources.NotFoundException {
            PhotoViewer.getInstance().setParentActivity(ChatActivityEnterView.this.parentActivity, resourcesProvider);
            PhotoViewer.getInstance().openPhotoForSelect(arrayList, 0, 2, false, new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.11.1
                boolean sending;

                @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
                public void sendButtonPressed(int index, VideoEditedInfo videoEditedInfo, boolean notify, int scheduleDate, boolean forceDocument) {
                    String str;
                    ArrayList arrayList2 = new ArrayList();
                    SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
                    MediaController.PhotoEntry photoEntry2 = photoEntry;
                    boolean z = photoEntry2.isVideo;
                    if (!z && (str = photoEntry2.imagePath) != null) {
                        sendingMediaInfo.path = str;
                    } else {
                        String str2 = photoEntry2.path;
                        if (str2 != null) {
                            sendingMediaInfo.path = str2;
                        }
                    }
                    sendingMediaInfo.thumbPath = photoEntry2.thumbPath;
                    sendingMediaInfo.isVideo = z;
                    CharSequence charSequence = photoEntry2.caption;
                    sendingMediaInfo.caption = charSequence != null ? charSequence.toString() : null;
                    MediaController.PhotoEntry photoEntry3 = photoEntry;
                    sendingMediaInfo.entities = photoEntry3.entities;
                    sendingMediaInfo.masks = photoEntry3.stickers;
                    sendingMediaInfo.ttl = photoEntry3.ttl;
                    sendingMediaInfo.videoEditedInfo = videoEditedInfo;
                    sendingMediaInfo.canDeleteAfter = true;
                    arrayList2.add(sendingMediaInfo);
                    photoEntry.reset();
                    this.sending = true;
                    SendMessagesHelper.prepareSendingMedia(ChatActivityEnterView.this.accountInstance, arrayList2, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), null, false, false, ChatActivityEnterView.this.editingMessageObject, notify, scheduleDate);
                    if (ChatActivityEnterView.this.delegate != null) {
                        ChatActivityEnterView.this.delegate.onMessageSend(null, true, scheduleDate);
                    }
                }

                @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
                public void willHidePhotoViewer() {
                    if (this.sending) {
                        return;
                    }
                    try {
                        file.delete();
                    } catch (Throwable unused) {
                    }
                }
            }, ChatActivityEnterView.this.parentFragment);
        }

        @Override // ir.eitaa.ui.Components.EditTextBoldCursor
        protected Theme.ResourcesProvider getResourcesProvider() {
            return this.val$resourcesProvider;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ChatActivityEnterView() {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onTextSpansChanged(this.messageEditText.getText());
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatActivityEnterView$14, reason: invalid class name */
    class AnonymousClass14 implements TextWatcher {
        private boolean ignorePrevTextChange;
        private boolean nextChangeIsSend;
        private CharSequence prevText;
        private boolean processChange;

        AnonymousClass14() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.ignorePrevTextChange && ChatActivityEnterView.this.recordingAudioVideo) {
                this.prevText = charSequence.toString();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            if (this.ignorePrevTextChange) {
                return;
            }
            if (ChatActivityEnterView.this.lineCount != ChatActivityEnterView.this.messageEditText.getLineCount()) {
                if (!ChatActivityEnterView.this.isInitLineCount && ChatActivityEnterView.this.messageEditText.getMeasuredWidth() > 0) {
                    ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                    chatActivityEnterView.onLineCountChanged(chatActivityEnterView.lineCount, ChatActivityEnterView.this.messageEditText.getLineCount());
                }
                ChatActivityEnterView chatActivityEnterView2 = ChatActivityEnterView.this;
                chatActivityEnterView2.lineCount = chatActivityEnterView2.messageEditText.getLineCount();
            }
            if (ChatActivityEnterView.this.innerTextChange == 1) {
                return;
            }
            if (ChatActivityEnterView.this.sendByEnter && !ChatActivityEnterView.this.isPaste && ChatActivityEnterView.this.editingMessageObject == null && count > before && charSequence.length() > 0 && charSequence.length() == start + count && charSequence.charAt(charSequence.length() - 1) == '\n') {
                this.nextChangeIsSend = true;
            }
            ChatActivityEnterView.this.isPaste = false;
            ChatActivityEnterView.this.checkSendButton(true);
            CharSequence trimmedString = AndroidUtilities.getTrimmedString(charSequence.toString());
            if (ChatActivityEnterView.this.delegate != null && !ChatActivityEnterView.this.ignoreTextChange) {
                int i = count + 1;
                if (before > i || count - before > 2 || TextUtils.isEmpty(charSequence)) {
                    ChatActivityEnterView.this.messageWebPageSearch = true;
                }
                ChatActivityEnterView.this.delegate.onTextChanged(charSequence, before > i || count - before > 2);
            }
            if (ChatActivityEnterView.this.innerTextChange != 2 && count - before > 1) {
                this.processChange = true;
            }
            if (ChatActivityEnterView.this.editingMessageObject != null || ChatActivityEnterView.this.canWriteToChannel || trimmedString.length() == 0 || ChatActivityEnterView.this.lastTypingTimeSend >= System.currentTimeMillis() - 5000 || ChatActivityEnterView.this.ignoreTextChange) {
                return;
            }
            ChatActivityEnterView.this.lastTypingTimeSend = System.currentTimeMillis();
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.needSendTyping();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x01ab  */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r11) throws java.lang.InterruptedException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.AnonymousClass14.afterTextChanged(android.text.Editable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$afterTextChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$afterTextChanged$0$ChatActivityEnterView$14(ValueAnimator valueAnimator) {
            int themedColor = ChatActivityEnterView.this.getThemedColor("chat_messagePanelVoicePressed");
            int iAlpha = Color.alpha(themedColor);
            ChatActivityEnterView.this.doneButtonEnabledProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatActivityEnterView.this.doneCheckDrawable.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(themedColor, (int) (iAlpha * ((ChatActivityEnterView.this.doneButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.doneButtonImage.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ChatActivityEnterView(View view) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.openScheduledMessages();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$ChatActivityEnterView(View view) {
        boolean z = !this.botCommandsMenuButton.isOpened();
        this.botCommandsMenuButton.setOpened(z);
        if (z) {
            this.botCommandsMenuContainer.show();
        } else {
            this.botCommandsMenuContainer.dismiss();
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatActivityEnterView$16, reason: invalid class name */
    class AnonymousClass16 implements RecyclerListView.OnItemClickListener {
        final /* synthetic */ ChatActivity val$fragment;
        final /* synthetic */ Theme.ResourcesProvider val$resourcesProvider;

        AnonymousClass16(final Theme.ResourcesProvider val$resourcesProvider, final ChatActivity val$fragment) {
            this.val$resourcesProvider = val$resourcesProvider;
            this.val$fragment = val$fragment;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
        public void onItemClick(View view, int position) {
            if (view instanceof BotCommandsMenuView.BotCommandView) {
                final String command = ((BotCommandsMenuView.BotCommandView) view).getCommand();
                if (TextUtils.isEmpty(command)) {
                    return;
                }
                if (ChatActivityEnterView.this.isInScheduleMode()) {
                    AlertsCreator.createScheduleDatePickerDialog(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.dialog_id, new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$16$7iy7WdaOcLMOkt6bxzneQfibVXI
                        @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                        public final void didSelectDate(boolean z, int i) {
                            this.f$0.lambda$onItemClick$0$ChatActivityEnterView$16(command, z, i);
                        }
                    }, this.val$resourcesProvider);
                    return;
                }
                ChatActivity chatActivity = this.val$fragment;
                if (chatActivity == null || !chatActivity.checkSlowMode(view)) {
                    SendMessagesHelper.getInstance(ChatActivityEnterView.this.currentAccount).sendMessage(command, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), null, false, null, null, null, true, 0, null);
                    ChatActivityEnterView.this.setFieldText("");
                    ChatActivityEnterView.this.botCommandsMenuContainer.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ChatActivityEnterView$16(String str, boolean z, int i) {
            SendMessagesHelper.getInstance(ChatActivityEnterView.this.currentAccount).sendMessage(str, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), null, false, null, null, null, z, i, null);
            ChatActivityEnterView.this.setFieldText("");
            ChatActivityEnterView.this.botCommandsMenuContainer.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ChatActivityEnterView(View view) {
        if (this.searchingType != 0) {
            setSearchingTypeInternal(0, false);
            this.emojiView.closeSearch(false);
            this.messageEditText.requestFocus();
        }
        if (this.botReplyMarkup != null) {
            if (!isPopupShowing() || this.currentPopupContentType != 1) {
                showPopup(1, 1);
                MessagesController.getMainSettings(this.currentAccount).edit().remove("hidekeyboard_" + this.dialog_id).commit();
            } else {
                if (this.botButtonsMessageObject != null) {
                    MessagesController.getMainSettings(this.currentAccount).edit().putInt("hidekeyboard_" + this.dialog_id, this.botButtonsMessageObject.getId()).commit();
                }
                openKeyboardInternal();
            }
        } else if (this.hasBotCommands) {
            setFieldText("/");
            this.messageEditText.requestFocus();
            openKeyboard();
        }
        if (this.stickersExpanded) {
            setStickersExpanded(false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$6$ChatActivityEnterView(View view) {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if (adjustPanLayoutHelper == null || !adjustPanLayoutHelper.animationInProgress()) {
            this.delegate.didPressAttachButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$7$ChatActivityEnterView(View view) throws InterruptedException, IOException {
        AnimatorSet animatorSet = this.runningAnimationAudio;
        if (animatorSet == null || !animatorSet.isRunning()) {
            if (this.videoToSendMessageObject != null) {
                CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
                this.delegate.needStartRecordVideo(2, true, 0);
            } else {
                MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                if (playingMessageObject != null && playingMessageObject == this.audioToSendMessageObject) {
                    MediaController.getInstance().cleanupPlayer(true, true);
                }
            }
            if (this.audioToSendPath != null) {
                new File(this.audioToSendPath).delete();
            }
            hideRecordedAudioPanel(false);
            checkSendButton(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$8$ChatActivityEnterView(View view) throws IOException {
        if (this.audioToSend == null) {
            return;
        }
        if (MediaController.getInstance().isPlayingMessage(this.audioToSendMessageObject) && !MediaController.getInstance().isMessagePaused()) {
            MediaController.getInstance().lambda$startAudioAgain$7$MediaController(this.audioToSendMessageObject);
            this.playPauseDrawable.setIcon(0, true);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        } else {
            this.playPauseDrawable.setIcon(1, true);
            MediaController.getInstance().playMessage(this.audioToSendMessageObject);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPause", R.string.AccActionPause));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$16$ChatActivityEnterView(Theme.ResourcesProvider resourcesProvider, View view, MotionEvent motionEvent) throws InterruptedException {
        TLRPC$Chat currentChat;
        if (motionEvent.getAction() == 0) {
            if (this.recordCircle.isSendButtonVisible()) {
                boolean z = this.hasRecordVideo;
                if (!z || this.calledRecordRunnable) {
                    this.startedDraggingX = -1.0f;
                    if (z && this.videoSendButton.getTag() != null) {
                        this.delegate.needStartRecordVideo(1, true, 0);
                    } else {
                        if (this.recordingAudioVideo && isInScheduleMode()) {
                            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$6KOQgYJbld9VJmrn7lbPnilobMo
                                @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                                public final void didSelectDate(boolean z2, int i) throws InterruptedException {
                                    MediaController.getInstance().stopRecording(1, z2, i);
                                }
                            }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$VLBIsILfled2_dX2-IacbnajT4I
                                @Override // java.lang.Runnable
                                public final void run() throws InterruptedException {
                                    MediaController.getInstance().stopRecording(0, false, 0);
                                }
                            }, resourcesProvider);
                        }
                        MediaController.getInstance().stopRecording(isInScheduleMode() ? 3 : 1, true, 0);
                        this.delegate.needStartRecordAudio(0);
                    }
                    this.recordingAudioVideo = false;
                    this.messageTransitionIsRunning = false;
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$5UCnRZGX2QkfkjRJP1UQ5YDusM0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$12$ChatActivityEnterView();
                        }
                    };
                    this.moveToSendStateRunnable = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 200L);
                }
                return false;
            }
            ChatActivity chatActivity = this.parentFragment;
            if (chatActivity != null && (currentChat = chatActivity.getCurrentChat()) != null && !ChatObject.canSendMedia(currentChat)) {
                this.delegate.needShowMediaBanHint();
                return false;
            }
            if (this.hasRecordVideo) {
                this.calledRecordRunnable = false;
                this.recordAudioVideoRunnableStarted = true;
                AndroidUtilities.runOnUIThread(this.recordAudioVideoRunnable, 150L);
            } else {
                this.recordAudioVideoRunnable.run();
            }
        } else {
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getAction() == 3 && this.recordingAudioVideo) {
                    if (this.recordCircle.slideToCancelProgress >= 0.7f) {
                        this.recordCircle.sendButtonVisible = true;
                        startLockTransition();
                    } else {
                        if (this.hasRecordVideo && this.videoSendButton.getTag() != null) {
                            CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
                            this.delegate.needStartRecordVideo(2, true, 0);
                        } else {
                            this.delegate.needStartRecordAudio(0);
                            MediaController.getInstance().stopRecording(0, false, 0);
                        }
                        this.recordingAudioVideo = false;
                        updateRecordIntefrace(5);
                    }
                    return false;
                }
                if (this.recordCircle.isSendButtonVisible() || this.recordedAudioPanel.getVisibility() == 0) {
                    if (this.recordAudioVideoRunnableStarted) {
                        AndroidUtilities.cancelRunOnUIThread(this.recordAudioVideoRunnable);
                    }
                    return false;
                }
                if ((((motionEvent.getX() + this.audioVideoButtonContainer.getX()) - this.startedDraggingX) / this.distCanMove) + 1.0f < 0.45d) {
                    if (this.hasRecordVideo && this.videoSendButton.getTag() != null) {
                        CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
                        this.delegate.needStartRecordVideo(2, true, 0);
                    } else {
                        this.delegate.needStartRecordAudio(0);
                        MediaController.getInstance().stopRecording(0, false, 0);
                    }
                    this.recordingAudioVideo = false;
                    updateRecordIntefrace(5);
                } else if (this.recordAudioVideoRunnableStarted) {
                    AndroidUtilities.cancelRunOnUIThread(this.recordAudioVideoRunnable);
                    this.delegate.onSwitchRecordMode(this.videoSendButton.getTag() == null);
                    setRecordVideoButtonVisible(this.videoSendButton.getTag() == null, true);
                    performHapticFeedback(3);
                    sendAccessibilityEvent(1);
                } else {
                    boolean z2 = this.hasRecordVideo;
                    if (!z2 || this.calledRecordRunnable) {
                        this.startedDraggingX = -1.0f;
                        if (z2 && this.videoSendButton.getTag() != null) {
                            CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
                            this.delegate.needStartRecordVideo(1, true, 0);
                        } else {
                            if (this.recordingAudioVideo && isInScheduleMode()) {
                                AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$qMFF7wn0vlVBeKr-fL-VOc1iQMM
                                    @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                                    public final void didSelectDate(boolean z3, int i) throws InterruptedException {
                                        MediaController.getInstance().stopRecording(1, z3, i);
                                    }
                                }, new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$haEYyrOaXwoDD_16_Bkah4umjKs
                                    @Override // java.lang.Runnable
                                    public final void run() throws InterruptedException {
                                        MediaController.getInstance().stopRecording(0, false, 0);
                                    }
                                }, resourcesProvider);
                            }
                            this.delegate.needStartRecordAudio(0);
                            MediaController.getInstance().stopRecording(isInScheduleMode() ? 3 : 1, true, 0);
                        }
                        this.recordingAudioVideo = false;
                        this.messageTransitionIsRunning = false;
                        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$_X1VAgWrcsxilDu2PT-LK_ACUzw
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$15$ChatActivityEnterView();
                            }
                        };
                        this.moveToSendStateRunnable = runnable2;
                        AndroidUtilities.runOnUIThread(runnable2, 500L);
                    }
                }
            } else if (motionEvent.getAction() == 2 && this.recordingAudioVideo) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (this.recordCircle.isSendButtonVisible()) {
                    return false;
                }
                if (this.recordCircle.setLockTranslation(y) == 2) {
                    startLockTransition();
                    return false;
                }
                this.recordCircle.setMovingCords(x, y);
                if (this.startedDraggingX == -1.0f) {
                    this.startedDraggingX = x;
                    double measuredWidth = this.sizeNotifierLayout.getMeasuredWidth();
                    Double.isNaN(measuredWidth);
                    float f = (float) (measuredWidth * 0.35d);
                    this.distCanMove = f;
                    if (f > AndroidUtilities.dp(140.0f)) {
                        this.distCanMove = AndroidUtilities.dp(140.0f);
                    }
                }
                float x2 = x + this.audioVideoButtonContainer.getX();
                float f2 = this.startedDraggingX;
                float f3 = ((x2 - f2) / this.distCanMove) + 1.0f;
                if (f2 != -1.0f) {
                    float f4 = f3 <= 1.0f ? f3 < 0.0f ? 0.0f : f3 : 1.0f;
                    this.slideText.setSlideX(f4);
                    this.recordCircle.setSlideToCancelProgress(f4);
                    f3 = f4;
                }
                if (f3 == 0.0f) {
                    if (this.hasRecordVideo && this.videoSendButton.getTag() != null) {
                        CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
                        this.delegate.needStartRecordVideo(2, true, 0);
                    } else {
                        this.delegate.needStartRecordAudio(0);
                        MediaController.getInstance().stopRecording(0, false, 0);
                    }
                    this.recordingAudioVideo = false;
                    updateRecordIntefrace(5);
                }
            }
        }
        view.onTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$12$ChatActivityEnterView() {
        this.moveToSendStateRunnable = null;
        updateRecordIntefrace(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$15$ChatActivityEnterView() {
        this.moveToSendStateRunnable = null;
        updateRecordIntefrace(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$17$ChatActivityEnterView(View view) {
        String string = this.messageEditText.getText().toString();
        int iIndexOf = string.indexOf(32);
        if (iIndexOf == -1 || iIndexOf == string.length() - 1) {
            setFieldText("");
        } else {
            setFieldText(string.substring(0, iIndexOf + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$18$ChatActivityEnterView(View view) throws InterruptedException, IOException {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            AnimatorSet animatorSet = this.runningAnimationAudio;
            if (animatorSet == null || !animatorSet.isRunning()) {
                sendMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$19$ChatActivityEnterView(View view) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            SimpleTextView simpleTextView = this.slowModeButton;
            chatActivityEnterViewDelegate.onUpdateSlowModeButton(simpleTextView, true, simpleTextView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$20$ChatActivityEnterView(View view) {
        if (this.messageEditText.length() == 0) {
            return false;
        }
        return onSendLongClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$21$ChatActivityEnterView(View view) {
        EmojiView emojiView;
        if (this.expandStickersButton.getVisibility() == 0 && this.expandStickersButton.getAlpha() == 1.0f && !this.waitingForKeyboardOpen) {
            if (this.keyboardVisible && this.messageEditText.isFocused()) {
                return;
            }
            if (this.stickersExpanded) {
                if (this.searchingType != 0) {
                    setSearchingTypeInternal(0, true);
                    this.emojiView.closeSearch(true);
                    this.emojiView.hideSearchKeyboard();
                    if (this.emojiTabOpen) {
                        checkSendButton(true);
                    }
                } else if (!this.stickersDragging && (emojiView = this.emojiView) != null) {
                    emojiView.showSearchField(false);
                }
            } else if (!this.stickersDragging) {
                this.emojiView.showSearchField(true);
            }
            if (this.stickersDragging) {
                return;
            }
            setStickersExpanded(!this.stickersExpanded, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$22$ChatActivityEnterView(View view) {
        doneEditingMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBotMenu() {
        BotCommandsMenuView botCommandsMenuView = this.botCommandsMenuButton;
        if (botCommandsMenuView != null) {
            botCommandsMenuView.setExpanded((!TextUtils.isEmpty(this.messageEditText.getText()) || this.keyboardVisible || this.waitingForKeyboardOpen || isPopupShowing()) ? false : true, true);
            beginDelayedTransition();
        }
    }

    private void startLockTransition() {
        AnimatorSet animatorSet = new AnimatorSet();
        performHapticFeedback(3, 2);
        RecordCircle recordCircle = this.recordCircle;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(recordCircle, "lockAnimatedTranslation", recordCircle.startTranslation);
        objectAnimatorOfFloat.setStartDelay(100L);
        objectAnimatorOfFloat.setDuration(350L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.recordCircle, "snapAnimationProgress", 1.0f);
        objectAnimatorOfFloat2.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
        objectAnimatorOfFloat2.setDuration(250L);
        SharedConfig.removeLockRecordAudioVideoHint();
        animatorSet.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat, ObjectAnimator.ofFloat(this.recordCircle, "slideToCancelProgress", 1.0f).setDuration(200L), ObjectAnimator.ofFloat(this.slideText, "cancelToProgress", 1.0f));
        animatorSet.start();
    }

    public int getBackgroundTop() {
        int top = getTop();
        View view = this.topView;
        return (view == null || view.getVisibility() != 0) ? top : top + this.topView.getLayoutParams().height;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean z = child == this.topView || child == this.textFieldContainer;
        if (z) {
            canvas.save();
            if (child == this.textFieldContainer) {
                int iDp = this.animatedTop + AndroidUtilities.dp(2.0f);
                View view = this.topView;
                if (view != null && view.getVisibility() == 0) {
                    iDp += this.topView.getHeight();
                }
                canvas.clipRect(0, iDp, getMeasuredWidth(), getMeasuredHeight());
            } else {
                canvas.clipRect(0, this.animatedTop, getMeasuredWidth(), this.animatedTop + child.getLayoutParams().height + AndroidUtilities.dp(2.0f));
            }
        }
        boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
        if (z) {
            canvas.restore();
        }
        return zDrawChild;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i = this.animatedTop;
        View view = this.topView;
        if (view != null && view.getVisibility() == 0) {
            i = (int) (i + ((1.0f - this.topViewEnterProgress) * this.topView.getLayoutParams().height));
        }
        int intrinsicHeight = Theme.chat_composeShadowDrawable.getIntrinsicHeight() + i;
        Theme.chat_composeShadowDrawable.setBounds(0, i, getMeasuredWidth(), intrinsicHeight);
        Theme.chat_composeShadowDrawable.draw(canvas);
        this.backgroundPaint.setColor(getThemedColor("chat_messagePanelBackground"));
        canvas.drawRect(0.0f, intrinsicHeight, getWidth(), getHeight(), this.backgroundPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onSendLongClick(android.view.View r11) {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.onSendLongClick(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSendLongClick$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSendLongClick$23$ChatActivityEnterView(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.sendPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onSendLongClick$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onSendLongClick$24$ChatActivityEnterView(int i, View view) throws InterruptedException, IOException {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
            this.sendPopupWindow.dismiss();
        }
        if (i == 0) {
            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new $$Lambda$ChatActivityEnterView$AWaZbEIsOoseW6IuE9_uC0U2I_g(this), this.resourcesProvider);
        } else {
            sendMessageInternal(false, 0);
        }
    }

    public boolean isSendButtonVisible() {
        return this.sendButton.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setRecordVideoButtonVisible(boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.setRecordVideoButtonVisible(boolean, boolean):void");
    }

    public boolean isRecordingAudioVideo() {
        AnimatorSet animatorSet;
        return this.recordingAudioVideo || ((animatorSet = this.runningAnimationAudio) != null && animatorSet.isRunning());
    }

    public boolean isRecordLocked() {
        return this.recordingAudioVideo && this.recordCircle.isSendButtonVisible();
    }

    public void cancelRecordingAudioVideo() {
        ImageView imageView;
        if (this.hasRecordVideo && (imageView = this.videoSendButton) != null && imageView.getTag() != null) {
            CameraController.getInstance().cancelOnInitRunnable(this.onFinishInitCameraRunnable);
            this.delegate.needStartRecordVideo(5, true, 0);
        } else {
            this.delegate.needStartRecordAudio(0);
            MediaController.getInstance().stopRecording(0, false, 0);
        }
        this.recordingAudioVideo = false;
        updateRecordIntefrace(2);
    }

    public void showContextProgress(boolean show) {
        CloseProgressDrawable2 closeProgressDrawable2 = this.progressDrawable;
        if (closeProgressDrawable2 == null) {
            return;
        }
        if (show) {
            closeProgressDrawable2.startAnimation();
        } else {
            closeProgressDrawable2.stopAnimation();
        }
    }

    public void setCaption(String caption) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption != null) {
            editTextCaption.setCaption(caption);
            checkSendButton(true);
        }
    }

    public void setSlowModeTimer(int time) {
        this.slowModeTimer = time;
        updateSlowModeText();
    }

    public CharSequence getSlowModeTimer() {
        if (this.slowModeTimer > 0) {
            return this.slowModeButton.getText();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSlowModeText() {
        int i;
        boolean zIsUploadingMessageIdDialog;
        int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
        AndroidUtilities.cancelRunOnUIThread(this.updateSlowModeRunnable);
        this.updateSlowModeRunnable = null;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull != null && tLRPC$ChatFull.slowmode_seconds != 0 && tLRPC$ChatFull.slowmode_next_send_date <= currentTime && ((zIsUploadingMessageIdDialog = SendMessagesHelper.getInstance(this.currentAccount).isUploadingMessageIdDialog(this.dialog_id)) || SendMessagesHelper.getInstance(this.currentAccount).isSendingMessageIdDialog(this.dialog_id))) {
            if (ChatObject.hasAdminRights(this.accountInstance.getMessagesController().getChat(Long.valueOf(this.info.id)))) {
                i = 0;
            } else {
                i = this.info.slowmode_seconds;
                this.slowModeTimer = zIsUploadingMessageIdDialog ? ConnectionsManager.DEFAULT_DATACENTER_ID : 2147483646;
            }
        } else {
            int i2 = this.slowModeTimer;
            if (i2 >= 2147483646) {
                if (this.info != null) {
                    this.accountInstance.getMessagesController().loadFullChat(this.info.id, 0, true);
                }
                i = 0;
            } else {
                i = i2 - currentTime;
            }
        }
        if (this.slowModeTimer != 0 && i > 0) {
            this.slowModeButton.setText(AndroidUtilities.formatDurationNoHours(Math.max(1, i), false));
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                SimpleTextView simpleTextView = this.slowModeButton;
                chatActivityEnterViewDelegate.onUpdateSlowModeButton(simpleTextView, false, simpleTextView.getText());
            }
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$_6KwrP_EuXFYhHglS_snJvC8OrM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.updateSlowModeText();
                }
            };
            this.updateSlowModeRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 100L);
        } else {
            this.slowModeTimer = 0;
        }
        if (isInScheduleMode()) {
            return;
        }
        checkSendButton(true);
    }

    public void addTopView(View view, View lineView, int height) {
        if (view == null) {
            return;
        }
        this.topLineView = lineView;
        lineView.setVisibility(8);
        this.topLineView.setAlpha(0.0f);
        addView(this.topLineView, LayoutHelper.createFrame(-1, 1.0f, 51, 0.0f, height + 1, 0.0f, 0.0f));
        this.topView = view;
        view.setVisibility(8);
        this.topViewEnterProgress = 0.0f;
        float f = height;
        this.topView.setTranslationY(f);
        addView(this.topView, 0, LayoutHelper.createFrame(-1, f, 51, 0.0f, 2.0f, 0.0f, 0.0f));
        this.needShowTopView = false;
    }

    public void setForceShowSendButton(boolean value, boolean animated) {
        this.forceShowSendButton = value;
        checkSendButton(animated);
    }

    public void setAllowStickersAndGifs(boolean value, boolean value2) {
        setAllowStickersAndGifs(value, value2, false);
    }

    public void setAllowStickersAndGifs(boolean value, boolean value2, boolean waitingForKeyboardOpen) {
        if ((this.allowStickers != value || this.allowGifs != value2) && this.emojiView != null) {
            if (!SharedConfig.smoothKeyboard) {
                if (this.emojiViewVisible) {
                    hidePopup(false);
                }
                this.sizeNotifierLayout.removeView(this.emojiView);
                this.emojiView = null;
            } else if (this.emojiViewVisible && !waitingForKeyboardOpen) {
                this.removeEmojiViewAfterAnimation = true;
                hidePopup(false);
            } else {
                if (waitingForKeyboardOpen) {
                    openKeyboardInternal();
                }
                this.sizeNotifierLayout.removeView(this.emojiView);
                this.emojiView = null;
            }
        }
        this.allowStickers = value;
        this.allowGifs = value2;
        setEmojiButtonImage(false, !this.isPaused);
    }

    public void addEmojiToRecent(String code) {
        createEmojiView();
        this.emojiView.addEmojiToRecent(code);
    }

    public void setOpenGifsTabFirst() {
        createEmojiView();
        MediaDataController.getInstance(this.currentAccount).loadRecents(0, true, true, false);
        this.emojiView.switchToGifRecent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$25$ChatActivityEnterView(ValueAnimator valueAnimator) {
        if (this.topView != null) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.topViewEnterProgress = fFloatValue;
            this.topView.setTranslationY(this.animatedTop + ((1.0f - fFloatValue) * r0.getLayoutParams().height));
            this.topLineView.setAlpha(fFloatValue);
            this.topLineView.setTranslationY(this.animatedTop);
        }
    }

    public void showTopView(boolean animated, final boolean openKeyboard) {
        showTopView(animated, openKeyboard, false);
    }

    private void showTopView(boolean animated, final boolean openKeyboard, boolean skipAwait) {
        if (this.topView == null || this.topViewShowed || getVisibility() != 0) {
            if (this.recordedAudioPanel.getVisibility() != 0) {
                if (!this.forceShowSendButton || openKeyboard) {
                    openKeyboard();
                    return;
                }
                return;
            }
            return;
        }
        boolean z = this.recordedAudioPanel.getVisibility() != 0 && (!this.forceShowSendButton || openKeyboard) && (this.botReplyMarkup == null || this.editingMessageObject != null);
        if (!skipAwait && animated && z && !this.keyboardVisible && !isPopupShowing()) {
            openKeyboard();
            Runnable runnable = this.showTopViewRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$htSH3fpxPKMQ-XRtybS-ItHj90U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showTopView$26$ChatActivityEnterView();
                }
            };
            this.showTopViewRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 200L);
            return;
        }
        this.needShowTopView = true;
        this.topViewShowed = true;
        if (this.allowShowTopView) {
            this.topView.setVisibility(0);
            this.topLineView.setVisibility(0);
            ValueAnimator valueAnimator = this.currentTopViewAnimation;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.currentTopViewAnimation = null;
            }
            resizeForTopView(true);
            if (animated) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.topViewEnterProgress, 1.0f);
                this.currentTopViewAnimation = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(this.topViewUpdateListener);
                this.currentTopViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 != null && valueAnimator2.equals(animation)) {
                            ChatActivityEnterView.this.currentTopViewAnimation = null;
                        }
                        NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                    }
                });
                this.currentTopViewAnimation.setDuration(270L);
                this.currentTopViewAnimation.setInterpolator(ChatListItemAnimator.DEFAULT_INTERPOLATOR);
                this.currentTopViewAnimation.start();
                this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
            } else {
                this.topViewEnterProgress = 1.0f;
                this.topView.setTranslationY(0.0f);
                this.topLineView.setAlpha(1.0f);
            }
            if (z) {
                this.messageEditText.requestFocus();
                openKeyboard();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showTopView$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showTopView$26$ChatActivityEnterView() {
        showTopView(true, false, true);
        this.showTopViewRunnable = null;
    }

    public void onEditTimeExpired() {
        this.doneButtonContainer.setVisibility(8);
    }

    public void showEditDoneProgress(final boolean show, boolean animated) {
        AnimatorSet animatorSet = this.doneButtonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (animated) {
            this.doneButtonAnimation = new AnimatorSet();
            if (show) {
                this.doneButtonProgress.setVisibility(0);
                this.doneButtonContainer.setEnabled(false);
                this.doneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.doneButtonImage.setVisibility(0);
                this.doneButtonContainer.setEnabled(true);
                this.doneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            }
            this.doneButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (ChatActivityEnterView.this.doneButtonAnimation == null || !ChatActivityEnterView.this.doneButtonAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        ChatActivityEnterView.this.doneButtonProgress.setVisibility(4);
                    } else {
                        ChatActivityEnterView.this.doneButtonImage.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (ChatActivityEnterView.this.doneButtonAnimation == null || !ChatActivityEnterView.this.doneButtonAnimation.equals(animation)) {
                        return;
                    }
                    ChatActivityEnterView.this.doneButtonAnimation = null;
                }
            });
            this.doneButtonAnimation.setDuration(150L);
            this.doneButtonAnimation.start();
            return;
        }
        if (show) {
            this.doneButtonImage.setScaleX(0.1f);
            this.doneButtonImage.setScaleY(0.1f);
            this.doneButtonImage.setAlpha(0.0f);
            this.doneButtonProgress.setScaleX(1.0f);
            this.doneButtonProgress.setScaleY(1.0f);
            this.doneButtonProgress.setAlpha(1.0f);
            this.doneButtonImage.setVisibility(4);
            this.doneButtonProgress.setVisibility(0);
            this.doneButtonContainer.setEnabled(false);
            return;
        }
        this.doneButtonProgress.setScaleX(0.1f);
        this.doneButtonProgress.setScaleY(0.1f);
        this.doneButtonProgress.setAlpha(0.0f);
        this.doneButtonImage.setScaleX(1.0f);
        this.doneButtonImage.setScaleY(1.0f);
        this.doneButtonImage.setAlpha(1.0f);
        this.doneButtonImage.setVisibility(0);
        this.doneButtonProgress.setVisibility(4);
        this.doneButtonContainer.setEnabled(true);
    }

    public void hideTopView(final boolean animated) {
        if (this.topView == null || !this.topViewShowed) {
            return;
        }
        Runnable runnable = this.showTopViewRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        this.topViewShowed = false;
        this.needShowTopView = false;
        if (this.allowShowTopView) {
            ValueAnimator valueAnimator = this.currentTopViewAnimation;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.currentTopViewAnimation = null;
            }
            if (animated) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.topViewEnterProgress, 0.0f);
                this.currentTopViewAnimation = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(this.topViewUpdateListener);
                this.currentTopViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.28
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 == null || !valueAnimator2.equals(animation)) {
                            return;
                        }
                        ChatActivityEnterView.this.topView.setVisibility(8);
                        ChatActivityEnterView.this.topLineView.setVisibility(8);
                        ChatActivityEnterView.this.resizeForTopView(false);
                        ChatActivityEnterView.this.currentTopViewAnimation = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 == null || !valueAnimator2.equals(animation)) {
                            return;
                        }
                        ChatActivityEnterView.this.currentTopViewAnimation = null;
                    }
                });
                this.currentTopViewAnimation.setDuration(250L);
                this.currentTopViewAnimation.setInterpolator(ChatListItemAnimator.DEFAULT_INTERPOLATOR);
                this.currentTopViewAnimation.start();
                return;
            }
            this.topViewEnterProgress = 0.0f;
            this.topView.setVisibility(8);
            this.topLineView.setVisibility(8);
            this.topLineView.setAlpha(0.0f);
            resizeForTopView(false);
            this.topView.setTranslationY(r4.getLayoutParams().height);
        }
    }

    public boolean isTopViewVisible() {
        View view = this.topView;
        return view != null && view.getVisibility() == 0;
    }

    public void onAdjustPanTransitionStart(boolean keyboardVisible) {
        Runnable runnable;
        if (keyboardVisible && (runnable = this.showTopViewRunnable) != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.showTopViewRunnable.run();
        }
        Runnable runnable2 = this.setTextFieldRunnable;
        if (runnable2 != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable2);
            this.setTextFieldRunnable.run();
        }
    }

    private void onWindowSizeChanged() {
        int height = this.sizeNotifierLayout.getHeight();
        if (!this.keyboardVisible) {
            height -= this.emojiPadding;
        }
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onWindowSizeChanged(height);
        }
        if (this.topView != null) {
            if (height < AndroidUtilities.dp(72.0f) + ActionBar.getCurrentActionBarHeight()) {
                if (this.allowShowTopView) {
                    this.allowShowTopView = false;
                    if (this.needShowTopView) {
                        this.topView.setVisibility(8);
                        this.topLineView.setVisibility(8);
                        this.topLineView.setAlpha(0.0f);
                        resizeForTopView(false);
                        this.topViewEnterProgress = 0.0f;
                        this.topView.setTranslationY(r0.getLayoutParams().height);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.allowShowTopView) {
                return;
            }
            this.allowShowTopView = true;
            if (this.needShowTopView) {
                this.topView.setVisibility(0);
                this.topLineView.setVisibility(0);
                this.topLineView.setAlpha(1.0f);
                resizeForTopView(true);
                this.topViewEnterProgress = 1.0f;
                this.topView.setTranslationY(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizeForTopView(boolean show) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textFieldContainer.getLayoutParams();
        layoutParams.topMargin = AndroidUtilities.dp(2.0f) + (show ? this.topView.getLayoutParams().height : 0);
        this.textFieldContainer.setLayoutParams(layoutParams);
        setMinimumHeight(AndroidUtilities.dp(51.0f) + (show ? this.topView.getLayoutParams().height : 0));
        if (this.stickersExpanded) {
            if (this.searchingType == 0) {
                setStickersExpanded(false, true, false);
            } else {
                checkStickresExpandHeight();
            }
        }
    }

    public void onDestroy() {
        this.destroyed = true;
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recordStarted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recordStartError);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recordStopped);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.recordProgressChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.closeChats);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.audioDidSent);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.audioRouteChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.featuredStickersDidLoad);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.sendingMessagesChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.audioRecordTooShort);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiLoaded);
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.onDestroy();
        }
        Runnable runnable = this.updateSlowModeRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.updateSlowModeRunnable = null;
        }
        PowerManager.WakeLock wakeLock = this.wakeLock;
        if (wakeLock != null) {
            try {
                wakeLock.release();
                this.wakeLock = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
        if (sizeNotifierFrameLayout != null) {
            sizeNotifierFrameLayout.setDelegate(null);
        }
    }

    public void checkChannelRights() {
        TLRPC$Chat currentChat;
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null || (currentChat = chatActivity.getCurrentChat()) == null) {
            return;
        }
        this.audioVideoButtonContainer.setAlpha(ChatObject.canSendMedia(currentChat) ? 1.0f : 0.5f);
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.setStickersBanned(!ChatObject.canSendStickers(currentChat), currentChat.id);
        }
    }

    public void onBeginHide() {
        Runnable runnable = this.focusRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.focusRunnable = null;
        }
    }

    public void onPause() {
        this.isPaused = true;
        if (this.keyboardVisible) {
            this.showKeyboardOnResume = true;
        }
        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$mV_dTa0u8VKO9Z9ZzlDOsNZR_n4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPause$27$ChatActivityEnterView();
            }
        };
        this.hideKeyboardRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onPause$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onPause$27$ChatActivityEnterView() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null || chatActivity.isLastFragment()) {
            closeKeyboard();
        }
        this.hideKeyboardRunnable = null;
    }

    public void onResume() {
        this.isPaused = false;
        Runnable runnable = this.hideKeyboardRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.hideKeyboardRunnable = null;
        }
        getVisibility();
        if (this.showKeyboardOnResume && this.parentFragment.isLastFragment()) {
            this.showKeyboardOnResume = false;
            if (this.searchingType == 0) {
                this.messageEditText.requestFocus();
            }
            AndroidUtilities.showKeyboard(this.messageEditText);
            if (AndroidUtilities.usingHardwareInput || this.keyboardVisible || AndroidUtilities.isInMultiwindow) {
                return;
            }
            this.waitingForKeyboardOpen = true;
            AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
            AndroidUtilities.runOnUIThread(this.openKeyboardRunnable, 100L);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        this.messageEditText.setEnabled(visibility == 0);
    }

    public void setDialogId(long id, int account) {
        this.dialog_id = id;
        int i = this.currentAccount;
        if (i != account) {
            NotificationCenter.getInstance(i).onAnimationFinish(this.notificationsIndex);
            NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
            int i2 = NotificationCenter.recordStarted;
            notificationCenter.removeObserver(this, i2);
            NotificationCenter notificationCenter2 = NotificationCenter.getInstance(this.currentAccount);
            int i3 = NotificationCenter.recordStartError;
            notificationCenter2.removeObserver(this, i3);
            NotificationCenter notificationCenter3 = NotificationCenter.getInstance(this.currentAccount);
            int i4 = NotificationCenter.recordStopped;
            notificationCenter3.removeObserver(this, i4);
            NotificationCenter notificationCenter4 = NotificationCenter.getInstance(this.currentAccount);
            int i5 = NotificationCenter.recordProgressChanged;
            notificationCenter4.removeObserver(this, i5);
            NotificationCenter notificationCenter5 = NotificationCenter.getInstance(this.currentAccount);
            int i6 = NotificationCenter.closeChats;
            notificationCenter5.removeObserver(this, i6);
            NotificationCenter notificationCenter6 = NotificationCenter.getInstance(this.currentAccount);
            int i7 = NotificationCenter.audioDidSent;
            notificationCenter6.removeObserver(this, i7);
            NotificationCenter notificationCenter7 = NotificationCenter.getInstance(this.currentAccount);
            int i8 = NotificationCenter.audioRouteChanged;
            notificationCenter7.removeObserver(this, i8);
            NotificationCenter notificationCenter8 = NotificationCenter.getInstance(this.currentAccount);
            int i9 = NotificationCenter.messagePlayingDidReset;
            notificationCenter8.removeObserver(this, i9);
            NotificationCenter notificationCenter9 = NotificationCenter.getInstance(this.currentAccount);
            int i10 = NotificationCenter.messagePlayingProgressDidChanged;
            notificationCenter9.removeObserver(this, i10);
            NotificationCenter notificationCenter10 = NotificationCenter.getInstance(this.currentAccount);
            int i11 = NotificationCenter.featuredStickersDidLoad;
            notificationCenter10.removeObserver(this, i11);
            NotificationCenter notificationCenter11 = NotificationCenter.getInstance(this.currentAccount);
            int i12 = NotificationCenter.messageReceivedByServer;
            notificationCenter11.removeObserver(this, i12);
            NotificationCenter notificationCenter12 = NotificationCenter.getInstance(this.currentAccount);
            int i13 = NotificationCenter.sendingMessagesChanged;
            notificationCenter12.removeObserver(this, i13);
            this.currentAccount = account;
            this.accountInstance = AccountInstance.getInstance(account);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i2);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i3);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i4);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i5);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i6);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i7);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i8);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i9);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i10);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i11);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i12);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i13);
        }
        updateScheduleButton(false);
        checkRoundVideo();
        updateFieldHint(false);
    }

    public void setChatInfo(TLRPC$ChatFull chatInfo) {
        this.info = chatInfo;
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.setChatInfo(chatInfo);
        }
        setSlowModeTimer(chatInfo.slowmode_next_send_date);
    }

    public void checkRoundVideo() {
        boolean z;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        if (this.hasRecordVideo) {
            return;
        }
        if (this.attachLayout == null || Build.VERSION.SDK_INT < 18) {
            this.hasRecordVideo = false;
            setRecordVideoButtonVisible(false, false);
            return;
        }
        this.hasRecordVideo = true;
        if (DialogObject.isChatDialog(this.dialog_id)) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-this.dialog_id));
            z = ChatObject.isChannel(chat) && !chat.megagroup;
            if (z && !chat.creator && ((tLRPC$TL_chatAdminRights = chat.admin_rights) == null || !tLRPC$TL_chatAdminRights.post_messages)) {
                this.hasRecordVideo = false;
            }
        } else {
            z = false;
        }
        if (!SharedConfig.inappCamera) {
            this.hasRecordVideo = false;
        }
        if (this.hasRecordVideo) {
            if (SharedConfig.hasCameraCache) {
                CameraController.getInstance().initCamera(null);
            }
            setRecordVideoButtonVisible(MessagesController.getGlobalMainSettings().getBoolean(z ? "currentModeVideoChannel" : "currentModeVideo", z), false);
            return;
        }
        setRecordVideoButtonVisible(false, false);
    }

    public boolean isInVideoMode() {
        ImageView imageView = this.videoSendButton;
        return (imageView == null || imageView.getTag() == null) ? false : true;
    }

    public boolean hasRecordVideo() {
        return this.hasRecordVideo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFieldHint(boolean animated) {
        boolean z;
        MessageObject messageObject;
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup;
        TLRPC$ReplyMarkup tLRPC$ReplyMarkup2;
        MessageObject messageObject2 = this.replyingMessageObject;
        if (messageObject2 != null && (tLRPC$ReplyMarkup2 = messageObject2.messageOwner.reply_markup) != null && !TextUtils.isEmpty(tLRPC$ReplyMarkup2.placeholder)) {
            this.messageEditText.setHintText(this.replyingMessageObject.messageOwner.reply_markup.placeholder, animated);
            return;
        }
        if (this.editingMessageObject != null) {
            this.messageEditText.setHintText(this.editingCaption ? LocaleController.getString("Caption", R.string.Caption) : LocaleController.getString("TypeMessage", R.string.TypeMessage));
            return;
        }
        if (this.botKeyboardViewVisible && (messageObject = this.botButtonsMessageObject) != null && (tLRPC$ReplyMarkup = messageObject.messageOwner.reply_markup) != null && !TextUtils.isEmpty(tLRPC$ReplyMarkup.placeholder)) {
            this.messageEditText.setHintText(this.botButtonsMessageObject.messageOwner.reply_markup.placeholder, animated);
            return;
        }
        boolean zShouldSendAnonymously = false;
        if (DialogObject.isChatDialog(this.dialog_id)) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-this.dialog_id));
            if (ChatObject.isChannel(chat) && !chat.megagroup) {
                zShouldSendAnonymously = true;
            }
            boolean z2 = zShouldSendAnonymously;
            zShouldSendAnonymously = ChatObject.shouldSendAnonymously(chat);
            z = z2;
        } else {
            z = false;
        }
        if (zShouldSendAnonymously) {
            this.messageEditText.setHintText(LocaleController.getString("SendAnonymously", R.string.SendAnonymously));
            return;
        }
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity != null && chatActivity.isThreadChat()) {
            if (this.parentFragment.isReplyChatComment()) {
                this.messageEditText.setHintText(LocaleController.getString("Comment", R.string.Comment));
                return;
            } else {
                this.messageEditText.setHintText(LocaleController.getString("Reply", R.string.Reply));
                return;
            }
        }
        if (z) {
            if (this.silent) {
                this.messageEditText.setHintText(LocaleController.getString("ChannelSilentBroadcast", R.string.ChannelSilentBroadcast), animated);
                return;
            } else {
                this.messageEditText.setHintText(LocaleController.getString("ChannelBroadcast", R.string.ChannelBroadcast), animated);
                return;
            }
        }
        this.messageEditText.setHintText(LocaleController.getString("TypeMessage", R.string.TypeMessage));
    }

    public void setReplyingMessageObject(MessageObject messageObject) {
        MessageObject messageObject2;
        if (messageObject != null) {
            if (this.botMessageObject == null && (messageObject2 = this.botButtonsMessageObject) != this.replyingMessageObject) {
                this.botMessageObject = messageObject2;
            }
            this.replyingMessageObject = messageObject;
            setButtons(messageObject, true);
        } else if (this.replyingMessageObject == this.botButtonsMessageObject) {
            this.replyingMessageObject = null;
            setButtons(this.botMessageObject, false);
            this.botMessageObject = null;
        } else {
            this.replyingMessageObject = null;
        }
        MediaController.getInstance().setReplyingMessage(messageObject, getThreadMessage());
        updateFieldHint(false);
    }

    public void setWebPage(TLRPC$WebPage webPage, boolean searchWebPages) {
        this.messageWebPage = webPage;
        this.messageWebPageSearch = searchWebPages;
    }

    public boolean isMessageWebPageSearchEnabled() {
        return this.messageWebPageSearch;
    }

    private void hideRecordedAudioPanel(boolean wasSent) {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2 = this.recordPannelAnimation;
        if (animatorSet2 == null || !animatorSet2.isRunning()) {
            this.audioToSendPath = null;
            this.audioToSend = null;
            this.audioToSendMessageObject = null;
            this.videoToSendMessageObject = null;
            this.videoTimelineView.destroy();
            if (this.videoSendButton != null && isInVideoMode()) {
                this.videoSendButton.setVisibility(0);
            } else {
                ImageView imageView = this.audioSendButton;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            }
            if (wasSent) {
                this.attachButton.setAlpha(0.0f);
                this.emojiButton[0].setAlpha(0.0f);
                this.emojiButton[1].setAlpha(0.0f);
                this.attachButton.setScaleX(0.0f);
                this.emojiButton[0].setScaleX(0.0f);
                this.emojiButton[1].setScaleX(0.0f);
                this.attachButton.setScaleY(0.0f);
                this.emojiButton[0].setScaleY(0.0f);
                this.emojiButton[1].setScaleY(0.0f);
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.recordPannelAnimation = animatorSet3;
                animatorSet3.playTogether(ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.recordedAudioPanel, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.messageEditText, (Property<EditTextCaption, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.messageEditText, (Property<EditTextCaption, Float>) View.TRANSLATION_X, 0.0f));
                BotCommandsMenuView botCommandsMenuView = this.botCommandsMenuButton;
                if (botCommandsMenuView != null) {
                    botCommandsMenuView.setAlpha(0.0f);
                    this.botCommandsMenuButton.setScaleY(0.0f);
                    this.botCommandsMenuButton.setScaleX(0.0f);
                    this.recordPannelAnimation.playTogether(ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.SCALE_Y, 1.0f));
                }
                this.recordPannelAnimation.setDuration(150L);
                this.recordPannelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.29
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ChatActivityEnterView.this.recordedAudioPanel.setVisibility(8);
                        ChatActivityEnterView.this.messageEditText.requestFocus();
                    }
                });
            } else {
                this.recordDeleteImageView.playAnimation();
                AnimatorSet animatorSet4 = new AnimatorSet();
                if (isInVideoMode()) {
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.videoTimelineView, (Property<VideoTimelineView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.videoTimelineView, (Property<VideoTimelineView, Float>) View.TRANSLATION_X, -AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this.messageEditText, (Property<EditTextCaption, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.messageEditText, (Property<EditTextCaption, Float>) View.TRANSLATION_X, 0.0f));
                } else {
                    this.messageEditText.setAlpha(1.0f);
                    this.messageEditText.setTranslationX(0.0f);
                    animatorSet4.playTogether(ObjectAnimator.ofFloat(this.recordedAudioSeekBar, (Property<SeekBarWaveformView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordedAudioPlayButton, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordedAudioBackground, (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordedAudioTimeTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordedAudioSeekBar, (Property<SeekBarWaveformView, Float>) View.TRANSLATION_X, -AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this.recordedAudioPlayButton, (Property<ImageView, Float>) View.TRANSLATION_X, -AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this.recordedAudioBackground, (Property<View, Float>) View.TRANSLATION_X, -AndroidUtilities.dp(20.0f)), ObjectAnimator.ofFloat(this.recordedAudioTimeTextView, (Property<TextView, Float>) View.TRANSLATION_X, -AndroidUtilities.dp(20.0f)));
                }
                animatorSet4.setDuration(200L);
                ImageView imageView2 = this.attachButton;
                if (imageView2 != null) {
                    imageView2.setAlpha(0.0f);
                    this.attachButton.setScaleX(0.0f);
                    this.attachButton.setScaleY(0.0f);
                    AnimatorSet animatorSet5 = new AnimatorSet();
                    animatorSet5.playTogether(ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.attachButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
                    animatorSet5.setDuration(150L);
                    animatorSet = animatorSet5;
                } else {
                    animatorSet = null;
                }
                this.emojiButton[0].setAlpha(0.0f);
                this.emojiButton[1].setAlpha(0.0f);
                this.emojiButton[0].setScaleX(0.0f);
                this.emojiButton[1].setScaleX(0.0f);
                this.emojiButton[0].setScaleY(0.0f);
                this.emojiButton[1].setScaleY(0.0f);
                AnimatorSet animatorSet6 = new AnimatorSet();
                animatorSet6.playTogether(ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.recordDeleteImageView, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
                BotCommandsMenuView botCommandsMenuView2 = this.botCommandsMenuButton;
                if (botCommandsMenuView2 != null) {
                    botCommandsMenuView2.setAlpha(0.0f);
                    this.botCommandsMenuButton.setScaleY(0.0f);
                    this.botCommandsMenuButton.setScaleX(0.0f);
                    animatorSet6.playTogether(ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.botCommandsMenuButton, (Property<BotCommandsMenuView, Float>) View.SCALE_Y, 1.0f));
                }
                animatorSet6.setDuration(150L);
                animatorSet6.setStartDelay(600L);
                AnimatorSet animatorSet7 = new AnimatorSet();
                this.recordPannelAnimation = animatorSet7;
                if (animatorSet != null) {
                    animatorSet7.playTogether(animatorSet4, animatorSet, animatorSet6);
                } else {
                    animatorSet7.playTogether(animatorSet4, animatorSet6);
                }
                this.recordPannelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.30
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ChatActivityEnterView.this.recordedAudioPanel.setVisibility(8);
                        ChatActivityEnterView.this.recordedAudioSeekBar.setAlpha(1.0f);
                        ChatActivityEnterView.this.recordedAudioSeekBar.setTranslationX(0.0f);
                        ChatActivityEnterView.this.recordedAudioPlayButton.setAlpha(1.0f);
                        ChatActivityEnterView.this.recordedAudioPlayButton.setTranslationX(0.0f);
                        ChatActivityEnterView.this.recordedAudioBackground.setAlpha(1.0f);
                        ChatActivityEnterView.this.recordedAudioBackground.setTranslationX(0.0f);
                        ChatActivityEnterView.this.recordedAudioTimeTextView.setAlpha(1.0f);
                        ChatActivityEnterView.this.recordedAudioTimeTextView.setTranslationX(0.0f);
                        ChatActivityEnterView.this.videoTimelineView.setAlpha(1.0f);
                        ChatActivityEnterView.this.videoTimelineView.setTranslationX(0.0f);
                        ChatActivityEnterView.this.messageEditText.setAlpha(1.0f);
                        ChatActivityEnterView.this.messageEditText.setTranslationX(0.0f);
                        ChatActivityEnterView.this.messageEditText.requestFocus();
                    }
                });
            }
            this.recordPannelAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage() throws InterruptedException, IOException {
        if (isInScheduleMode()) {
            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new $$Lambda$ChatActivityEnterView$AWaZbEIsOoseW6IuE9_uC0U2I_g(this), this.resourcesProvider);
        } else {
            sendMessageInternal(true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageInternal(final boolean notify, final int scheduleDate) throws InterruptedException, IOException {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        TLRPC$Chat currentChat;
        EmojiView emojiView;
        if (this.slowModeTimer == Integer.MAX_VALUE && !isInScheduleMode()) {
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
            if (chatActivityEnterViewDelegate2 != null) {
                chatActivityEnterViewDelegate2.scrollToSendingMessage();
                return;
            }
            return;
        }
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity != null) {
            TLRPC$Chat currentChat2 = chatActivity.getCurrentChat();
            if (this.parentFragment.getCurrentUser() != null || ((ChatObject.isChannel(currentChat2) && currentChat2.megagroup) || !ChatObject.isChannel(currentChat2))) {
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("silent_" + this.dialog_id, !notify).commit();
            }
        }
        if (this.stickersExpanded) {
            setStickersExpanded(false, true, false);
            if (this.searchingType != 0 && (emojiView = this.emojiView) != null) {
                emojiView.closeSearch(false);
                this.emojiView.hideSearchKeyboard();
            }
        }
        if (this.videoToSendMessageObject != null) {
            this.delegate.needStartRecordVideo(4, notify, scheduleDate);
            hideRecordedAudioPanel(true);
            checkSendButton(true);
            return;
        }
        if (this.audioToSend != null) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject != null && playingMessageObject == this.audioToSendMessageObject) {
                MediaController.getInstance().cleanupPlayer(true, true);
            }
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.audioToSend, null, this.audioToSendPath, this.dialog_id, this.replyingMessageObject, getThreadMessage(), null, null, null, null, notify, scheduleDate, 0, null, null);
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate3 = this.delegate;
            if (chatActivityEnterViewDelegate3 != null) {
                chatActivityEnterViewDelegate3.onMessageSend(null, notify, scheduleDate);
            }
            hideRecordedAudioPanel(true);
            checkSendButton(true);
            return;
        }
        final Editable text = this.messageEditText.getText();
        ChatActivity chatActivity2 = this.parentFragment;
        if (chatActivity2 != null && (currentChat = chatActivity2.getCurrentChat()) != null && currentChat.slowmode_enabled && !ChatObject.hasAdminRights(currentChat)) {
            if (text.length() > this.accountInstance.getMessagesController().maxMessageLength) {
                AlertsCreator.showSimpleAlert(this.parentFragment, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendErrorTooLong", R.string.SlowmodeSendErrorTooLong), this.resourcesProvider);
                return;
            } else if (this.forceShowSendButton && text.length() > 0) {
                AlertsCreator.showSimpleAlert(this.parentFragment, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError), this.resourcesProvider);
                return;
            }
        }
        if (processSendingText(text, notify, scheduleDate)) {
            if (this.delegate.hasForwardingMessages() || ((scheduleDate != 0 && !isInScheduleMode()) || isInScheduleMode())) {
                this.messageEditText.setText("");
                ChatActivityEnterViewDelegate chatActivityEnterViewDelegate4 = this.delegate;
                if (chatActivityEnterViewDelegate4 != null) {
                    chatActivityEnterViewDelegate4.onMessageSend(text, notify, scheduleDate);
                }
            } else {
                this.messageTransitionIsRunning = false;
                Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$b5znNRalJBSyliZ549Dmzq18Ta0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendMessageInternal$28$ChatActivityEnterView(text, notify, scheduleDate);
                    }
                };
                this.moveToSendStateRunnable = runnable;
                AndroidUtilities.runOnUIThread(runnable, 200L);
            }
            this.lastTypingTimeSend = 0L;
            return;
        }
        if (!this.forceShowSendButton || (chatActivityEnterViewDelegate = this.delegate) == null) {
            return;
        }
        chatActivityEnterViewDelegate.onMessageSend(null, notify, scheduleDate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendMessageInternal$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendMessageInternal$28$ChatActivityEnterView(CharSequence charSequence, boolean z, int i) {
        this.moveToSendStateRunnable = null;
        hideTopView(true);
        this.messageEditText.setText("");
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onMessageSend(charSequence, z, i);
        }
    }

    public void doneEditingMessage() {
        if (this.editingMessageObject == null) {
            return;
        }
        if (this.currentLimit - this.codePointCount < 0) {
            AndroidUtilities.shakeView(this.captionLimitView, 2.0f, 0);
            Vibrator vibrator = (Vibrator) this.captionLimitView.getContext().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
                return;
            }
            return;
        }
        if (this.searchingType != 0) {
            setSearchingTypeInternal(0, true);
            this.emojiView.closeSearch(false);
            if (this.stickersExpanded) {
                setStickersExpanded(false, true, false);
                this.waitingForKeyboardOpenAfterAnimation = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$TPDHteCmwQDA-VF4oSkxHJ3IZa0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$doneEditingMessage$29$ChatActivityEnterView();
                    }
                }, 200L);
            }
        }
        CharSequence[] charSequenceArr = {AndroidUtilities.getTrimmedString(this.messageEditText.getText())};
        ArrayList<TLRPC$MessageEntity> entities = MediaDataController.getInstance(this.currentAccount).getEntities(charSequenceArr, supportsSendingNewEntities());
        if (!TextUtils.equals(charSequenceArr[0], this.editingMessageObject.messageText) || ((entities != null && !entities.isEmpty()) || ((entities == null && !this.editingMessageObject.messageOwner.entities.isEmpty()) || (this.editingMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaWebPage)))) {
            MessageObject messageObject = this.editingMessageObject;
            messageObject.editingMessage = charSequenceArr[0];
            messageObject.editingMessageEntities = entities;
            messageObject.editingMessageSearchWebPage = this.messageWebPageSearch;
            SendMessagesHelper.getInstance(this.currentAccount).editMessage(this.editingMessageObject, null, null, null, null, null, false, null, this.isMxb);
        }
        setEditingMessageObject(null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$doneEditingMessage$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$doneEditingMessage$29$ChatActivityEnterView() {
        this.waitingForKeyboardOpenAfterAnimation = false;
        openKeyboardInternal();
    }

    public boolean processSendingText(CharSequence text, boolean notify, int scheduleDate) {
        int i;
        int i2;
        int i3;
        int i4;
        ChatActivity chatActivity;
        CharSequence trimmedString = AndroidUtilities.getTrimmedString(text);
        boolean zSupportsSendingNewEntities = supportsSendingNewEntities();
        int i5 = this.accountInstance.getMessagesController().maxMessageLength;
        char c = 0;
        if (trimmedString.length() == 0) {
            return false;
        }
        if (this.delegate != null && (chatActivity = this.parentFragment) != null) {
            if ((scheduleDate != 0) == chatActivity.isInScheduleMode()) {
                this.delegate.prepareMessageSending();
            }
        }
        int i6 = 0;
        while (true) {
            int i7 = i6 + i5;
            if (trimmedString.length() > i7) {
                int i8 = i7 - 1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                for (int i9 = 0; i8 > i6 && i9 < 300; i9++) {
                    char cCharAt = trimmedString.charAt(i8);
                    char cCharAt2 = i8 > 0 ? trimmedString.charAt(i8 - 1) : ' ';
                    if (cCharAt == '\n' && cCharAt2 == '\n') {
                        i = i8;
                        break;
                    }
                    if (cCharAt == '\n') {
                        i4 = i8;
                    } else if (i2 < 0 && Character.isWhitespace(cCharAt) && cCharAt2 == '.') {
                        i2 = i8;
                    } else if (i3 < 0 && Character.isWhitespace(cCharAt)) {
                        i3 = i8;
                    }
                    i8--;
                }
                i = -1;
            } else {
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
            }
            int iMin = i > 0 ? i : i4 > 0 ? i4 : i2 > 0 ? i2 : i3 > 0 ? i3 : Math.min(i7, trimmedString.length());
            CharSequence[] charSequenceArr = new CharSequence[1];
            charSequenceArr[c] = AndroidUtilities.getTrimmedString(trimmedString.subSequence(i6, iMin));
            ArrayList<TLRPC$MessageEntity> entities = MediaDataController.getInstance(this.currentAccount).getEntities(charSequenceArr, zSupportsSendingNewEntities);
            MessageObject.SendAnimationData sendAnimationData = null;
            if (!this.delegate.hasForwardingMessages()) {
                sendAnimationData = new MessageObject.SendAnimationData();
                float fDp = AndroidUtilities.dp(22.0f);
                sendAnimationData.height = fDp;
                sendAnimationData.width = fDp;
                this.messageEditText.getLocationInWindow(this.location);
                sendAnimationData.x = this.location[c] + AndroidUtilities.dp(11.0f);
                sendAnimationData.y = this.location[1] + AndroidUtilities.dp(19.0f);
            }
            int i10 = iMin;
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(charSequenceArr[c].toString(), this.dialog_id, this.replyingMessageObject, getThreadMessage(), this.messageWebPage, this.messageWebPageSearch, entities, null, null, notify, scheduleDate, sendAnimationData);
            i6 = i10 + 1;
            if (i10 == trimmedString.length()) {
                return true;
            }
            c = 0;
        }
    }

    private boolean supportsSendingNewEntities() {
        ChatActivity chatActivity = this.parentFragment;
        TLRPC$EncryptedChat currentEncryptedChat = chatActivity != null ? chatActivity.getCurrentEncryptedChat() : null;
        return currentEncryptedChat == null || AndroidUtilities.getPeerLayerVersion(currentEncryptedChat.layer) >= 101;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSendButton(boolean animated) {
        int themedColor;
        int i;
        if (this.editingMessageObject != null || this.recordingAudioVideo) {
            return;
        }
        boolean z = this.isPaused ? false : animated;
        CharSequence trimmedString = AndroidUtilities.getTrimmedString(this.messageEditText.getText());
        int i2 = this.slowModeTimer;
        if (i2 > 0 && i2 != Integer.MAX_VALUE && !isInScheduleMode()) {
            if (this.slowModeButton.getVisibility() != 0) {
                if (z) {
                    if (this.runningAnimationType == 5) {
                        return;
                    }
                    AnimatorSet animatorSet = this.runningAnimation;
                    if (animatorSet != null) {
                        animatorSet.cancel();
                        this.runningAnimation = null;
                    }
                    AnimatorSet animatorSet2 = this.runningAnimation2;
                    if (animatorSet2 != null) {
                        animatorSet2.cancel();
                        this.runningAnimation2 = null;
                    }
                    if (this.attachLayout != null) {
                        this.runningAnimation2 = new AnimatorSet();
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.ALPHA, 0.0f));
                        arrayList.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.SCALE_X, 0.0f));
                        this.scheduleButtonHidden = false;
                        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
                        boolean z2 = chatActivityEnterViewDelegate != null && chatActivityEnterViewDelegate.hasScheduledMessages();
                        ImageView imageView = this.scheduledButton;
                        if (imageView != null) {
                            imageView.setScaleY(1.0f);
                            if (z2) {
                                this.scheduledButton.setVisibility(0);
                                this.scheduledButton.setTag(1);
                                this.scheduledButton.setPivotX(AndroidUtilities.dp(48.0f));
                                ImageView imageView2 = this.scheduledButton;
                                Property property = View.TRANSLATION_X;
                                float[] fArr = new float[1];
                                ImageView imageView3 = this.botButton;
                                fArr[0] = AndroidUtilities.dp((imageView3 == null || imageView3.getVisibility() != 0) ? 48.0f : 96.0f);
                                arrayList.add(ObjectAnimator.ofFloat(imageView2, (Property<ImageView, Float>) property, fArr));
                                arrayList.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                                arrayList.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                            } else {
                                ImageView imageView4 = this.scheduledButton;
                                ImageView imageView5 = this.botButton;
                                imageView4.setTranslationX(AndroidUtilities.dp((imageView5 == null || imageView5.getVisibility() != 0) ? 48.0f : 96.0f));
                                this.scheduledButton.setAlpha(1.0f);
                                this.scheduledButton.setScaleX(1.0f);
                            }
                        }
                        this.runningAnimation2.playTogether(arrayList);
                        this.runningAnimation2.setDuration(100L);
                        this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.31
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                    ChatActivityEnterView.this.attachLayout.setVisibility(8);
                                    ChatActivityEnterView.this.runningAnimation2 = null;
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animation) {
                                if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                    ChatActivityEnterView.this.runningAnimation2 = null;
                                }
                            }
                        });
                        this.runningAnimation2.start();
                        updateFieldRight(0);
                        if (this.delegate != null && getVisibility() == 0) {
                            this.delegate.onAttachButtonHidden();
                        }
                    }
                    this.runningAnimationType = 5;
                    this.runningAnimation = new AnimatorSet();
                    ArrayList arrayList2 = new ArrayList();
                    if (this.audioVideoButtonContainer.getVisibility() == 0) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_X, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_Y, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                    }
                    if (this.expandStickersButton.getVisibility() == 0) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                    }
                    if (this.sendButton.getVisibility() == 0) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 0.0f));
                    }
                    if (this.cancelBotButton.getVisibility() == 0) {
                        arrayList2.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                        arrayList2.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                    }
                    arrayList2.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_X, 1.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_Y, 1.0f));
                    arrayList2.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.ALPHA, 1.0f));
                    setSlowModeButtonVisible(true);
                    this.runningAnimation.playTogether(arrayList2);
                    this.runningAnimation.setDuration(150L);
                    this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.32
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                                ChatActivityEnterView.this.sendButton.setVisibility(8);
                                ChatActivityEnterView.this.cancelBotButton.setVisibility(8);
                                ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(8);
                                ChatActivityEnterView.this.expandStickersButton.setVisibility(8);
                                ChatActivityEnterView.this.runningAnimation = null;
                                ChatActivityEnterView.this.runningAnimationType = 0;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                                ChatActivityEnterView.this.runningAnimation = null;
                            }
                        }
                    });
                    this.runningAnimation.start();
                    return;
                }
                this.slowModeButton.setScaleX(1.0f);
                this.slowModeButton.setScaleY(1.0f);
                this.slowModeButton.setAlpha(1.0f);
                setSlowModeButtonVisible(true);
                this.audioVideoButtonContainer.setScaleX(0.1f);
                this.audioVideoButtonContainer.setScaleY(0.1f);
                this.audioVideoButtonContainer.setAlpha(0.0f);
                this.audioVideoButtonContainer.setVisibility(8);
                this.sendButton.setScaleX(0.1f);
                this.sendButton.setScaleY(0.1f);
                this.sendButton.setAlpha(0.0f);
                this.sendButton.setVisibility(8);
                this.cancelBotButton.setScaleX(0.1f);
                this.cancelBotButton.setScaleY(0.1f);
                this.cancelBotButton.setAlpha(0.0f);
                this.cancelBotButton.setVisibility(8);
                if (this.expandStickersButton.getVisibility() == 0) {
                    this.expandStickersButton.setScaleX(0.1f);
                    this.expandStickersButton.setScaleY(0.1f);
                    this.expandStickersButton.setAlpha(0.0f);
                    this.expandStickersButton.setVisibility(8);
                }
                LinearLayout linearLayout = this.attachLayout;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                    if (this.delegate != null && getVisibility() == 0) {
                        this.delegate.onAttachButtonHidden();
                    }
                    updateFieldRight(0);
                }
                this.scheduleButtonHidden = false;
                if (this.scheduledButton != null) {
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
                    if (chatActivityEnterViewDelegate2 != null && chatActivityEnterViewDelegate2.hasScheduledMessages()) {
                        this.scheduledButton.setVisibility(0);
                        this.scheduledButton.setTag(1);
                    }
                    ImageView imageView6 = this.scheduledButton;
                    ImageView imageView7 = this.botButton;
                    imageView6.setTranslationX(AndroidUtilities.dp((imageView7 == null || imageView7.getVisibility() != 0) ? 48.0f : 96.0f));
                    this.scheduledButton.setAlpha(1.0f);
                    this.scheduledButton.setScaleX(1.0f);
                    this.scheduledButton.setScaleY(1.0f);
                    return;
                }
                return;
            }
            return;
        }
        if (trimmedString.length() > 0 || this.forceShowSendButton || this.audioToSend != null || this.videoToSendMessageObject != null || (this.slowModeTimer == Integer.MAX_VALUE && !isInScheduleMode())) {
            final String caption = this.messageEditText.getCaption();
            boolean z3 = caption != null && (this.sendButton.getVisibility() == 0 || this.expandStickersButton.getVisibility() == 0);
            boolean z4 = caption == null && (this.cancelBotButton.getVisibility() == 0 || this.expandStickersButton.getVisibility() == 0);
            if (this.slowModeTimer == Integer.MAX_VALUE && !isInScheduleMode()) {
                themedColor = getThemedColor("chat_messagePanelIcons");
            } else {
                themedColor = getThemedColor("chat_messagePanelSend");
            }
            Theme.setSelectorDrawableColor(this.sendButton.getBackground(), Color.argb(24, Color.red(themedColor), Color.green(themedColor), Color.blue(themedColor)), true);
            if (this.audioVideoButtonContainer.getVisibility() == 0 || this.slowModeButton.getVisibility() == 0 || z3 || z4) {
                if (z) {
                    if (this.runningAnimationType == 1 && this.messageEditText.getCaption() == null) {
                        return;
                    }
                    if (this.runningAnimationType != 3 || caption == null) {
                        AnimatorSet animatorSet3 = this.runningAnimation;
                        if (animatorSet3 != null) {
                            animatorSet3.cancel();
                            this.runningAnimation = null;
                        }
                        AnimatorSet animatorSet4 = this.runningAnimation2;
                        if (animatorSet4 != null) {
                            animatorSet4.cancel();
                            this.runningAnimation2 = null;
                        }
                        if (this.attachLayout != null) {
                            this.runningAnimation2 = new AnimatorSet();
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.ALPHA, 0.0f));
                            arrayList3.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.SCALE_X, 0.0f));
                            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate3 = this.delegate;
                            final boolean z5 = chatActivityEnterViewDelegate3 != null && chatActivityEnterViewDelegate3.hasScheduledMessages();
                            this.scheduleButtonHidden = true;
                            ImageView imageView8 = this.scheduledButton;
                            if (imageView8 != null) {
                                imageView8.setScaleY(1.0f);
                                if (z5) {
                                    this.scheduledButton.setTag(null);
                                    arrayList3.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                                    arrayList3.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.SCALE_X, 0.0f));
                                    ImageView imageView9 = this.scheduledButton;
                                    Property property2 = View.TRANSLATION_X;
                                    float[] fArr2 = new float[1];
                                    ImageView imageView10 = this.botButton;
                                    fArr2[0] = AndroidUtilities.dp((imageView10 == null || imageView10.getVisibility() == 8) ? 48.0f : 96.0f);
                                    arrayList3.add(ObjectAnimator.ofFloat(imageView9, (Property<ImageView, Float>) property2, fArr2));
                                } else {
                                    this.scheduledButton.setAlpha(0.0f);
                                    this.scheduledButton.setScaleX(0.0f);
                                    ImageView imageView11 = this.scheduledButton;
                                    ImageView imageView12 = this.botButton;
                                    imageView11.setTranslationX(AndroidUtilities.dp((imageView12 == null || imageView12.getVisibility() == 8) ? 48.0f : 96.0f));
                                }
                            }
                            this.runningAnimation2.playTogether(arrayList3);
                            this.runningAnimation2.setDuration(100L);
                            this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.33
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                        ChatActivityEnterView.this.attachLayout.setVisibility(8);
                                        if (z5) {
                                            ChatActivityEnterView.this.scheduledButton.setVisibility(8);
                                        }
                                        ChatActivityEnterView.this.runningAnimation2 = null;
                                    }
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animation) {
                                    if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                        ChatActivityEnterView.this.runningAnimation2 = null;
                                    }
                                }
                            });
                            this.runningAnimation2.start();
                            updateFieldRight(0);
                            if (this.delegate != null && getVisibility() == 0) {
                                this.delegate.onAttachButtonHidden();
                            }
                        }
                        this.runningAnimation = new AnimatorSet();
                        ArrayList arrayList4 = new ArrayList();
                        if (this.audioVideoButtonContainer.getVisibility() == 0) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                        }
                        if (this.expandStickersButton.getVisibility() == 0) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                        }
                        if (this.slowModeButton.getVisibility() == 0) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f));
                        }
                        if (z3) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 0.0f));
                        } else if (z4) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                        }
                        if (caption != null) {
                            this.runningAnimationType = 3;
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                            this.cancelBotButton.setVisibility(0);
                        } else {
                            this.runningAnimationType = 1;
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 1.0f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 1.0f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 1.0f));
                            this.sendButton.setVisibility(0);
                        }
                        this.runningAnimation.playTogether(arrayList4);
                        this.runningAnimation.setDuration(150L);
                        this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.34
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                                    if (caption != null) {
                                        ChatActivityEnterView.this.cancelBotButton.setVisibility(0);
                                        ChatActivityEnterView.this.sendButton.setVisibility(8);
                                    } else {
                                        ChatActivityEnterView.this.sendButton.setVisibility(0);
                                        ChatActivityEnterView.this.cancelBotButton.setVisibility(8);
                                    }
                                    ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(8);
                                    ChatActivityEnterView.this.expandStickersButton.setVisibility(8);
                                    ChatActivityEnterView.this.setSlowModeButtonVisible(false);
                                    ChatActivityEnterView.this.runningAnimation = null;
                                    ChatActivityEnterView.this.runningAnimationType = 0;
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animation) {
                                if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                                    ChatActivityEnterView.this.runningAnimation = null;
                                }
                            }
                        });
                        this.runningAnimation.start();
                        return;
                    }
                    return;
                }
                this.audioVideoButtonContainer.setScaleX(0.1f);
                this.audioVideoButtonContainer.setScaleY(0.1f);
                this.audioVideoButtonContainer.setAlpha(0.0f);
                this.audioVideoButtonContainer.setVisibility(8);
                if (this.slowModeButton.getVisibility() == 0) {
                    this.slowModeButton.setScaleX(0.1f);
                    this.slowModeButton.setScaleY(0.1f);
                    this.slowModeButton.setAlpha(0.0f);
                    setSlowModeButtonVisible(false);
                }
                if (caption != null) {
                    this.sendButton.setScaleX(0.1f);
                    this.sendButton.setScaleY(0.1f);
                    this.sendButton.setAlpha(0.0f);
                    this.sendButton.setVisibility(8);
                    this.cancelBotButton.setScaleX(1.0f);
                    this.cancelBotButton.setScaleY(1.0f);
                    this.cancelBotButton.setAlpha(1.0f);
                    this.cancelBotButton.setVisibility(0);
                } else {
                    this.cancelBotButton.setScaleX(0.1f);
                    this.cancelBotButton.setScaleY(0.1f);
                    this.cancelBotButton.setAlpha(0.0f);
                    this.sendButton.setVisibility(0);
                    this.sendButton.setScaleX(1.0f);
                    this.sendButton.setScaleY(1.0f);
                    this.sendButton.setAlpha(1.0f);
                    this.cancelBotButton.setVisibility(8);
                }
                if (this.expandStickersButton.getVisibility() == 0) {
                    this.expandStickersButton.setScaleX(0.1f);
                    this.expandStickersButton.setScaleY(0.1f);
                    this.expandStickersButton.setAlpha(0.0f);
                    i = 8;
                    this.expandStickersButton.setVisibility(8);
                } else {
                    i = 8;
                }
                LinearLayout linearLayout2 = this.attachLayout;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(i);
                    if (this.delegate != null && getVisibility() == 0) {
                        this.delegate.onAttachButtonHidden();
                    }
                    updateFieldRight(0);
                }
                this.scheduleButtonHidden = true;
                if (this.scheduledButton != null) {
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate4 = this.delegate;
                    if (chatActivityEnterViewDelegate4 != null && chatActivityEnterViewDelegate4.hasScheduledMessages()) {
                        this.scheduledButton.setVisibility(8);
                        this.scheduledButton.setTag(null);
                    }
                    this.scheduledButton.setAlpha(0.0f);
                    this.scheduledButton.setScaleX(0.0f);
                    this.scheduledButton.setScaleY(1.0f);
                    ImageView imageView13 = this.scheduledButton;
                    ImageView imageView14 = this.botButton;
                    imageView13.setTranslationX(AndroidUtilities.dp((imageView14 == null || imageView14.getVisibility() == 8) ? 48.0f : 96.0f));
                    return;
                }
                return;
            }
            return;
        }
        if (this.emojiView != null && this.emojiViewVisible && ((this.stickersTabOpen || (this.emojiTabOpen && this.searchingType == 2)) && !AndroidUtilities.isInMultiwindow)) {
            if (z) {
                if (this.runningAnimationType == 4) {
                    return;
                }
                AnimatorSet animatorSet5 = this.runningAnimation;
                if (animatorSet5 != null) {
                    animatorSet5.cancel();
                    this.runningAnimation = null;
                }
                AnimatorSet animatorSet6 = this.runningAnimation2;
                if (animatorSet6 != null) {
                    animatorSet6.cancel();
                    this.runningAnimation2 = null;
                }
                LinearLayout linearLayout3 = this.attachLayout;
                if (linearLayout3 != null && this.recordInterfaceState == 0) {
                    linearLayout3.setVisibility(0);
                    this.runningAnimation2 = new AnimatorSet();
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.ALPHA, 1.0f));
                    arrayList5.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.SCALE_X, 1.0f));
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate5 = this.delegate;
                    boolean z6 = chatActivityEnterViewDelegate5 != null && chatActivityEnterViewDelegate5.hasScheduledMessages();
                    this.scheduleButtonHidden = false;
                    ImageView imageView15 = this.scheduledButton;
                    if (imageView15 != null) {
                        imageView15.setScaleY(1.0f);
                        if (z6) {
                            this.scheduledButton.setVisibility(0);
                            this.scheduledButton.setTag(1);
                            this.scheduledButton.setPivotX(AndroidUtilities.dp(48.0f));
                            arrayList5.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                            arrayList5.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                            arrayList5.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.TRANSLATION_X, 0.0f));
                        } else {
                            this.scheduledButton.setAlpha(1.0f);
                            this.scheduledButton.setScaleX(1.0f);
                            this.scheduledButton.setTranslationX(0.0f);
                        }
                    }
                    this.runningAnimation2.playTogether(arrayList5);
                    this.runningAnimation2.setDuration(100L);
                    this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.35
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }
                    });
                    this.runningAnimation2.start();
                    updateFieldRight(1);
                    if (getVisibility() == 0) {
                        this.delegate.onAttachButtonShow();
                    }
                }
                this.expandStickersButton.setVisibility(0);
                this.runningAnimation = new AnimatorSet();
                this.runningAnimationType = 4;
                ArrayList arrayList6 = new ArrayList();
                arrayList6.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                arrayList6.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_Y, 1.0f));
                arrayList6.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                if (this.cancelBotButton.getVisibility() == 0) {
                    arrayList6.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                } else if (this.audioVideoButtonContainer.getVisibility() == 0) {
                    arrayList6.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_X, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_Y, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.ALPHA, 0.0f));
                } else if (this.slowModeButton.getVisibility() == 0) {
                    arrayList6.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_X, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f));
                } else {
                    arrayList6.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 0.1f));
                    arrayList6.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 0.0f));
                }
                this.runningAnimation.playTogether(arrayList6);
                this.runningAnimation.setDuration(250L);
                this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.36
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                            ChatActivityEnterView.this.sendButton.setVisibility(8);
                            ChatActivityEnterView.this.cancelBotButton.setVisibility(8);
                            ChatActivityEnterView.this.setSlowModeButtonVisible(false);
                            ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(8);
                            ChatActivityEnterView.this.expandStickersButton.setVisibility(0);
                            ChatActivityEnterView.this.runningAnimation = null;
                            ChatActivityEnterView.this.runningAnimationType = 0;
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                            ChatActivityEnterView.this.runningAnimation = null;
                        }
                    }
                });
                this.runningAnimation.start();
                return;
            }
            this.slowModeButton.setScaleX(0.1f);
            this.slowModeButton.setScaleY(0.1f);
            this.slowModeButton.setAlpha(0.0f);
            setSlowModeButtonVisible(false);
            this.sendButton.setScaleX(0.1f);
            this.sendButton.setScaleY(0.1f);
            this.sendButton.setAlpha(0.0f);
            this.sendButton.setVisibility(8);
            this.cancelBotButton.setScaleX(0.1f);
            this.cancelBotButton.setScaleY(0.1f);
            this.cancelBotButton.setAlpha(0.0f);
            this.cancelBotButton.setVisibility(8);
            this.audioVideoButtonContainer.setScaleX(0.1f);
            this.audioVideoButtonContainer.setScaleY(0.1f);
            this.audioVideoButtonContainer.setAlpha(0.0f);
            this.audioVideoButtonContainer.setVisibility(8);
            this.expandStickersButton.setScaleX(1.0f);
            this.expandStickersButton.setScaleY(1.0f);
            this.expandStickersButton.setAlpha(1.0f);
            this.expandStickersButton.setVisibility(0);
            if (this.attachLayout != null) {
                if (getVisibility() == 0) {
                    this.delegate.onAttachButtonShow();
                }
                this.attachLayout.setVisibility(0);
                updateFieldRight(1);
            }
            this.scheduleButtonHidden = false;
            if (this.scheduledButton != null) {
                ChatActivityEnterViewDelegate chatActivityEnterViewDelegate6 = this.delegate;
                if (chatActivityEnterViewDelegate6 != null && chatActivityEnterViewDelegate6.hasScheduledMessages()) {
                    this.scheduledButton.setVisibility(0);
                    this.scheduledButton.setTag(1);
                }
                this.scheduledButton.setAlpha(1.0f);
                this.scheduledButton.setScaleX(1.0f);
                this.scheduledButton.setScaleY(1.0f);
                this.scheduledButton.setTranslationX(0.0f);
                return;
            }
            return;
        }
        if (this.sendButton.getVisibility() == 0 || this.cancelBotButton.getVisibility() == 0 || this.expandStickersButton.getVisibility() == 0 || this.slowModeButton.getVisibility() == 0) {
            if (z) {
                if (this.runningAnimationType == 2) {
                    return;
                }
                AnimatorSet animatorSet7 = this.runningAnimation;
                if (animatorSet7 != null) {
                    animatorSet7.cancel();
                    this.runningAnimation = null;
                }
                AnimatorSet animatorSet8 = this.runningAnimation2;
                if (animatorSet8 != null) {
                    animatorSet8.cancel();
                    this.runningAnimation2 = null;
                }
                LinearLayout linearLayout4 = this.attachLayout;
                if (linearLayout4 != null) {
                    if (linearLayout4.getVisibility() != 0) {
                        this.attachLayout.setVisibility(0);
                        this.attachLayout.setAlpha(0.0f);
                        this.attachLayout.setScaleX(0.0f);
                    }
                    this.runningAnimation2 = new AnimatorSet();
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.ALPHA, 1.0f));
                    arrayList7.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.SCALE_X, 1.0f));
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate7 = this.delegate;
                    boolean z7 = chatActivityEnterViewDelegate7 != null && chatActivityEnterViewDelegate7.hasScheduledMessages();
                    this.scheduleButtonHidden = false;
                    ImageView imageView16 = this.scheduledButton;
                    if (imageView16 != null) {
                        if (z7) {
                            imageView16.setVisibility(0);
                            this.scheduledButton.setTag(1);
                            this.scheduledButton.setPivotX(AndroidUtilities.dp(48.0f));
                            arrayList7.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                            arrayList7.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.SCALE_X, 1.0f));
                            arrayList7.add(ObjectAnimator.ofFloat(this.scheduledButton, (Property<ImageView, Float>) View.TRANSLATION_X, 0.0f));
                        } else {
                            imageView16.setAlpha(1.0f);
                            this.scheduledButton.setScaleX(1.0f);
                            this.scheduledButton.setScaleY(1.0f);
                            this.scheduledButton.setTranslationX(0.0f);
                        }
                    }
                    this.runningAnimation2.playTogether(arrayList7);
                    this.runningAnimation2.setDuration(100L);
                    this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.37
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            if (animation.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }
                    });
                    this.runningAnimation2.start();
                    updateFieldRight(1);
                    if (getVisibility() == 0) {
                        this.delegate.onAttachButtonShow();
                    }
                }
                this.audioVideoButtonContainer.setVisibility(0);
                this.runningAnimation = new AnimatorSet();
                this.runningAnimationType = 2;
                ArrayList arrayList8 = new ArrayList();
                arrayList8.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_X, 1.0f));
                arrayList8.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.SCALE_Y, 1.0f));
                arrayList8.add(ObjectAnimator.ofFloat(this.audioVideoButtonContainer, (Property<FrameLayout, Float>) View.ALPHA, 1.0f));
                if (this.cancelBotButton.getVisibility() == 0) {
                    arrayList8.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.cancelBotButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                } else if (this.expandStickersButton.getVisibility() == 0) {
                    arrayList8.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_X, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.SCALE_Y, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.expandStickersButton, (Property<ImageView, Float>) View.ALPHA, 0.0f));
                } else if (this.slowModeButton.getVisibility() == 0) {
                    arrayList8.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_X, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.slowModeButton, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f));
                } else {
                    arrayList8.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 0.1f));
                    arrayList8.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 0.0f));
                }
                this.runningAnimation.playTogether(arrayList8);
                this.runningAnimation.setDuration(150L);
                this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.38
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                            ChatActivityEnterView.this.setSlowModeButtonVisible(false);
                            ChatActivityEnterView.this.runningAnimation = null;
                            ChatActivityEnterView.this.runningAnimationType = 0;
                            if (ChatActivityEnterView.this.audioVideoButtonContainer != null) {
                                ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(0);
                            }
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        if (animation.equals(ChatActivityEnterView.this.runningAnimation)) {
                            ChatActivityEnterView.this.runningAnimation = null;
                        }
                    }
                });
                this.runningAnimation.start();
                return;
            }
            this.slowModeButton.setScaleX(0.1f);
            this.slowModeButton.setScaleY(0.1f);
            this.slowModeButton.setAlpha(0.0f);
            setSlowModeButtonVisible(false);
            this.sendButton.setScaleX(0.1f);
            this.sendButton.setScaleY(0.1f);
            this.sendButton.setAlpha(0.0f);
            this.sendButton.setVisibility(8);
            this.cancelBotButton.setScaleX(0.1f);
            this.cancelBotButton.setScaleY(0.1f);
            this.cancelBotButton.setAlpha(0.0f);
            this.cancelBotButton.setVisibility(8);
            this.expandStickersButton.setScaleX(0.1f);
            this.expandStickersButton.setScaleY(0.1f);
            this.expandStickersButton.setAlpha(0.0f);
            this.expandStickersButton.setVisibility(8);
            this.audioVideoButtonContainer.setScaleX(1.0f);
            this.audioVideoButtonContainer.setScaleY(1.0f);
            this.audioVideoButtonContainer.setAlpha(1.0f);
            this.audioVideoButtonContainer.setVisibility(0);
            if (this.attachLayout != null) {
                if (getVisibility() == 0) {
                    this.delegate.onAttachButtonShow();
                }
                this.attachLayout.setAlpha(1.0f);
                this.attachLayout.setScaleX(1.0f);
                this.attachLayout.setVisibility(0);
                updateFieldRight(1);
            }
            this.scheduleButtonHidden = false;
            if (this.scheduledButton != null) {
                ChatActivityEnterViewDelegate chatActivityEnterViewDelegate8 = this.delegate;
                if (chatActivityEnterViewDelegate8 != null && chatActivityEnterViewDelegate8.hasScheduledMessages()) {
                    this.scheduledButton.setVisibility(0);
                    this.scheduledButton.setTag(1);
                }
                this.scheduledButton.setAlpha(1.0f);
                this.scheduledButton.setScaleX(1.0f);
                this.scheduledButton.setScaleY(1.0f);
                this.scheduledButton.setTranslationX(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSlowModeButtonVisible(boolean visible) {
        this.slowModeButton.setVisibility(visible ? 0 : 8);
        int iDp = visible ? AndroidUtilities.dp(16.0f) : 0;
        if (this.messageEditText.getPaddingRight() != iDp) {
            this.messageEditText.setPadding(0, AndroidUtilities.dp(11.0f), iDp, AndroidUtilities.dp(12.0f));
        }
    }

    private void updateFieldRight(int attachVisible) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        LinearLayout linearLayout2;
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null || this.editingMessageObject != null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) editTextCaption.getLayoutParams();
        int i = layoutParams.rightMargin;
        if (attachVisible == 1) {
            ImageView imageView7 = this.botButton;
            if (imageView7 != null && imageView7.getVisibility() == 0 && (imageView6 = this.scheduledButton) != null && imageView6.getVisibility() == 0 && (linearLayout2 = this.attachLayout) != null && linearLayout2.getVisibility() == 0) {
                layoutParams.rightMargin = AndroidUtilities.dp(146.0f);
            } else {
                ImageView imageView8 = this.botButton;
                if ((imageView8 != null && imageView8.getVisibility() == 0) || (((imageView4 = this.notifyButton) != null && imageView4.getVisibility() == 0) || ((imageView5 = this.scheduledButton) != null && imageView5.getTag() != null))) {
                    layoutParams.rightMargin = AndroidUtilities.dp(98.0f);
                } else {
                    layoutParams.rightMargin = AndroidUtilities.dp(50.0f);
                }
            }
        } else if (attachVisible == 2) {
            if (i != AndroidUtilities.dp(2.0f)) {
                ImageView imageView9 = this.botButton;
                if (imageView9 != null && imageView9.getVisibility() == 0 && (imageView3 = this.scheduledButton) != null && imageView3.getVisibility() == 0 && (linearLayout = this.attachLayout) != null && linearLayout.getVisibility() == 0) {
                    layoutParams.rightMargin = AndroidUtilities.dp(146.0f);
                } else {
                    ImageView imageView10 = this.botButton;
                    if ((imageView10 != null && imageView10.getVisibility() == 0) || (((imageView = this.notifyButton) != null && imageView.getVisibility() == 0) || ((imageView2 = this.scheduledButton) != null && imageView2.getTag() != null))) {
                        layoutParams.rightMargin = AndroidUtilities.dp(98.0f);
                    } else {
                        layoutParams.rightMargin = AndroidUtilities.dp(50.0f);
                    }
                }
            }
        } else {
            ImageView imageView11 = this.scheduledButton;
            if (imageView11 != null && imageView11.getTag() != null) {
                layoutParams.rightMargin = AndroidUtilities.dp(50.0f);
            } else {
                layoutParams.rightMargin = AndroidUtilities.dp(2.0f);
            }
        }
        if (i != layoutParams.rightMargin) {
            this.messageEditText.setLayoutParams(layoutParams);
        }
    }

    public void startMessageTransition() {
        Runnable runnable = this.moveToSendStateRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.messageTransitionIsRunning = true;
            this.moveToSendStateRunnable.run();
            this.moveToSendStateRunnable = null;
        }
    }

    public boolean canShowMessageTransition() {
        return this.moveToSendStateRunnable != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateRecordIntefrace(final int r24) {
        /*
            Method dump skipped, instructions count: 3742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.updateRecordIntefrace(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateRecordIntefrace$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateRecordIntefrace$30$ChatActivityEnterView(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (!isInVideoMode()) {
            this.recordCircle.setTransformToSeekbar(fFloatValue);
            this.seekBarWaveform.setWaveScaling(this.recordCircle.getTransformToSeekbarProgressStep3());
            this.recordedAudioSeekBar.invalidate();
            this.recordedAudioTimeTextView.setAlpha(this.recordCircle.getTransformToSeekbarProgressStep3());
            this.recordedAudioPlayButton.setAlpha(this.recordCircle.getTransformToSeekbarProgressStep3());
            this.recordedAudioPlayButton.setScaleX(this.recordCircle.getTransformToSeekbarProgressStep3());
            this.recordedAudioPlayButton.setScaleY(this.recordCircle.getTransformToSeekbarProgressStep3());
            this.recordedAudioSeekBar.setAlpha(this.recordCircle.getTransformToSeekbarProgressStep3());
            return;
        }
        this.recordCircle.setExitTransition(fFloatValue);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.recordingAudioVideo) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }

    public void setDelegate(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
        this.delegate = chatActivityEnterViewDelegate;
    }

    public void setCommand(MessageObject messageObject, String command, boolean longPress, boolean username) {
        String str;
        if (command == null || getVisibility() != 0) {
            return;
        }
        TLRPC$User user = null;
        if (longPress) {
            String string = this.messageEditText.getText().toString();
            if (messageObject != null && DialogObject.isChatDialog(this.dialog_id)) {
                user = this.accountInstance.getMessagesController().getUser(Long.valueOf(messageObject.messageOwner.from_id.user_id));
            }
            if ((this.botCount != 1 || username) && user != null && user.bot && !command.contains("@")) {
                str = String.format(Locale.US, "%s@%s", command, user.username) + " " + string.replaceFirst("^/[a-zA-Z@\\d_]{1,255}(\\s|$)", "");
            } else {
                str = command + " " + string.replaceFirst("^/[a-zA-Z@\\d_]{1,255}(\\s|$)", "");
            }
            this.ignoreTextChange = true;
            this.messageEditText.setText(str);
            EditTextCaption editTextCaption = this.messageEditText;
            editTextCaption.setSelection(editTextCaption.getText().length());
            this.ignoreTextChange = false;
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                chatActivityEnterViewDelegate.onTextChanged(this.messageEditText.getText(), true);
            }
            if (this.keyboardVisible || this.currentPopupContentType != -1) {
                return;
            }
            openKeyboard();
            return;
        }
        if (this.slowModeTimer > 0 && !isInScheduleMode()) {
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
            if (chatActivityEnterViewDelegate2 != null) {
                SimpleTextView simpleTextView = this.slowModeButton;
                chatActivityEnterViewDelegate2.onUpdateSlowModeButton(simpleTextView, true, simpleTextView.getText());
                return;
            }
            return;
        }
        if (messageObject != null && DialogObject.isChatDialog(this.dialog_id)) {
            user = this.accountInstance.getMessagesController().getUser(Long.valueOf(messageObject.messageOwner.from_id.user_id));
        }
        if ((this.botCount != 1 || username) && user != null && user.bot && !command.contains("@")) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(String.format(Locale.US, "%s@%s", command, user.username), this.dialog_id, this.replyingMessageObject, getThreadMessage(), null, false, null, null, null, true, 0, null);
        } else {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(command, this.dialog_id, this.replyingMessageObject, getThreadMessage(), null, false, null, null, null, true, 0, null);
        }
    }

    public void setEditingMessageObject(MessageObject messageObject, boolean caption) {
        MessageObject messageObject2;
        CharSequence charSequence;
        ArrayList<TLRPC$MessageEntity> arrayList;
        if (this.audioToSend == null && this.videoToSendMessageObject == null && (messageObject2 = this.editingMessageObject) != messageObject) {
            int i = 1;
            boolean z = messageObject2 != null;
            this.editingMessageObject = messageObject;
            this.editingCaption = caption;
            if (messageObject != null) {
                AnimatorSet animatorSet = this.doneButtonAnimation;
                if (animatorSet != null) {
                    animatorSet.cancel();
                    this.doneButtonAnimation = null;
                }
                this.doneButtonContainer.setVisibility(0);
                this.doneButtonImage.setScaleX(0.1f);
                this.doneButtonImage.setScaleY(0.1f);
                this.doneButtonImage.setAlpha(0.0f);
                this.doneButtonImage.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(150L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                if (caption) {
                    this.currentLimit = this.accountInstance.getMessagesController().maxCaptionLength;
                    charSequence = this.editingMessageObject.caption;
                } else {
                    this.currentLimit = this.accountInstance.getMessagesController().maxMessageLength;
                    charSequence = this.editingMessageObject.messageText;
                }
                final CharSequence charSequenceReplaceEmoji = "";
                if (charSequence != null) {
                    ArrayList<TLRPC$MessageEntity> arrayList2 = this.editingMessageObject.messageOwner.entities;
                    MediaDataController.sortEntities(arrayList2);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                    Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
                    if (spans != null && spans.length > 0) {
                        for (Object obj : spans) {
                            spannableStringBuilder.removeSpan(obj);
                        }
                    }
                    if (arrayList2 != null) {
                        int i2 = 0;
                        while (i2 < arrayList2.size()) {
                            try {
                                TLRPC$MessageEntity tLRPC$MessageEntity = arrayList2.get(i2);
                                if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length > spannableStringBuilder.length()) {
                                    arrayList = arrayList2;
                                } else if (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName) {
                                    if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length < spannableStringBuilder.length() && spannableStringBuilder.charAt(tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length) == ' ') {
                                        tLRPC$MessageEntity.length += i;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("");
                                    arrayList = arrayList2;
                                    sb.append(((TLRPC$TL_inputMessageEntityMentionName) tLRPC$MessageEntity).user_id.user_id);
                                    URLSpanUserMention uRLSpanUserMention = new URLSpanUserMention(sb.toString(), 3);
                                    int i3 = tLRPC$MessageEntity.offset;
                                    spannableStringBuilder.setSpan(uRLSpanUserMention, i3, tLRPC$MessageEntity.length + i3, 33);
                                } else {
                                    arrayList = arrayList2;
                                    if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) {
                                        if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length < spannableStringBuilder.length() && spannableStringBuilder.charAt(tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length) == ' ') {
                                            tLRPC$MessageEntity.length += i;
                                        }
                                        URLSpanUserMention uRLSpanUserMention2 = new URLSpanUserMention("" + ((TLRPC$TL_messageEntityMentionName) tLRPC$MessageEntity).user_id, 3);
                                        int i4 = tLRPC$MessageEntity.offset;
                                        spannableStringBuilder.setSpan(uRLSpanUserMention2, i4, tLRPC$MessageEntity.length + i4, 33);
                                    } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCode) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityPre)) {
                                        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
                                        textStyleRun.flags |= 4;
                                        TextStyleSpan textStyleSpan = new TextStyleSpan(textStyleRun);
                                        int i5 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan, i5, tLRPC$MessageEntity.length + i5, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBold) {
                                        TextStyleSpan.TextStyleRun textStyleRun2 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun2.flags |= 1;
                                        TextStyleSpan textStyleSpan2 = new TextStyleSpan(textStyleRun2);
                                        int i6 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan2, i6, tLRPC$MessageEntity.length + i6, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityItalic) {
                                        TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun3.flags |= 2;
                                        TextStyleSpan textStyleSpan3 = new TextStyleSpan(textStyleRun3);
                                        int i7 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan3, i7, tLRPC$MessageEntity.length + i7, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityStrike) {
                                        TextStyleSpan.TextStyleRun textStyleRun4 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun4.flags |= 8;
                                        TextStyleSpan textStyleSpan4 = new TextStyleSpan(textStyleRun4);
                                        int i8 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan4, i8, tLRPC$MessageEntity.length + i8, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUnderline) {
                                        TextStyleSpan.TextStyleRun textStyleRun5 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun5.flags |= 16;
                                        TextStyleSpan textStyleSpan5 = new TextStyleSpan(textStyleRun5);
                                        int i9 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan5, i9, tLRPC$MessageEntity.length + i9, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl) {
                                        URLSpanReplacement uRLSpanReplacement = new URLSpanReplacement(tLRPC$MessageEntity.url);
                                        int i10 = tLRPC$MessageEntity.offset;
                                        spannableStringBuilder.setSpan(uRLSpanReplacement, i10, tLRPC$MessageEntity.length + i10, 33);
                                    }
                                }
                                i2++;
                                arrayList2 = arrayList;
                                i = 1;
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    }
                    charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(spannableStringBuilder), this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                }
                if (this.draftMessage == null && !z) {
                    this.draftMessage = this.messageEditText.length() > 0 ? this.messageEditText.getText() : null;
                    this.draftSearchWebpage = this.messageWebPageSearch;
                }
                this.messageWebPageSearch = this.editingMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaWebPage;
                if (!this.keyboardVisible) {
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$_ckWq-ppd7RsdYwN68Bl5SzRMsE
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setEditingMessageObject$31$ChatActivityEnterView(charSequenceReplaceEmoji);
                        }
                    };
                    this.setTextFieldRunnable = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 200L);
                } else {
                    Runnable runnable2 = this.setTextFieldRunnable;
                    if (runnable2 != null) {
                        AndroidUtilities.cancelRunOnUIThread(runnable2);
                        this.setTextFieldRunnable = null;
                    }
                    setFieldText(charSequenceReplaceEmoji);
                }
                this.messageEditText.requestFocus();
                openKeyboard();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.messageEditText.getLayoutParams();
                layoutParams.rightMargin = AndroidUtilities.dp(4.0f);
                this.messageEditText.setLayoutParams(layoutParams);
                this.sendButton.setVisibility(8);
                setSlowModeButtonVisible(false);
                this.cancelBotButton.setVisibility(8);
                this.audioVideoButtonContainer.setVisibility(8);
                this.attachLayout.setVisibility(8);
                this.sendButtonContainer.setVisibility(8);
                ImageView imageView = this.scheduledButton;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                Runnable runnable3 = this.setTextFieldRunnable;
                if (runnable3 != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable3);
                    this.setTextFieldRunnable = null;
                }
                this.doneButtonContainer.setVisibility(8);
                this.currentLimit = -1;
                this.delegate.onMessageEditEnd(false);
                this.sendButtonContainer.setVisibility(0);
                this.cancelBotButton.setScaleX(0.1f);
                this.cancelBotButton.setScaleY(0.1f);
                this.cancelBotButton.setAlpha(0.0f);
                this.cancelBotButton.setVisibility(8);
                if (this.slowModeTimer > 0 && !isInScheduleMode()) {
                    if (this.slowModeTimer == Integer.MAX_VALUE) {
                        this.sendButton.setScaleX(1.0f);
                        this.sendButton.setScaleY(1.0f);
                        this.sendButton.setAlpha(1.0f);
                        this.sendButton.setVisibility(0);
                        this.slowModeButton.setScaleX(0.1f);
                        this.slowModeButton.setScaleY(0.1f);
                        this.slowModeButton.setAlpha(0.0f);
                        setSlowModeButtonVisible(false);
                    } else {
                        this.sendButton.setScaleX(0.1f);
                        this.sendButton.setScaleY(0.1f);
                        this.sendButton.setAlpha(0.0f);
                        this.sendButton.setVisibility(8);
                        this.slowModeButton.setScaleX(1.0f);
                        this.slowModeButton.setScaleY(1.0f);
                        this.slowModeButton.setAlpha(1.0f);
                        setSlowModeButtonVisible(true);
                    }
                    this.attachLayout.setScaleX(0.01f);
                    this.attachLayout.setAlpha(0.0f);
                    this.attachLayout.setVisibility(8);
                    this.audioVideoButtonContainer.setScaleX(0.1f);
                    this.audioVideoButtonContainer.setScaleY(0.1f);
                    this.audioVideoButtonContainer.setAlpha(0.0f);
                    this.audioVideoButtonContainer.setVisibility(8);
                } else {
                    this.sendButton.setScaleX(0.1f);
                    this.sendButton.setScaleY(0.1f);
                    this.sendButton.setAlpha(0.0f);
                    this.sendButton.setVisibility(8);
                    this.slowModeButton.setScaleX(0.1f);
                    this.slowModeButton.setScaleY(0.1f);
                    this.slowModeButton.setAlpha(0.0f);
                    setSlowModeButtonVisible(false);
                    this.attachLayout.setScaleX(1.0f);
                    this.attachLayout.setAlpha(1.0f);
                    this.attachLayout.setVisibility(0);
                    this.audioVideoButtonContainer.setScaleX(1.0f);
                    this.audioVideoButtonContainer.setScaleY(1.0f);
                    this.audioVideoButtonContainer.setAlpha(1.0f);
                    this.audioVideoButtonContainer.setVisibility(0);
                }
                if (this.scheduledButton.getTag() != null) {
                    this.scheduledButton.setScaleX(1.0f);
                    this.scheduledButton.setScaleY(1.0f);
                    this.scheduledButton.setAlpha(1.0f);
                    this.scheduledButton.setVisibility(0);
                }
                this.messageEditText.setText(this.draftMessage);
                this.messageWebPageSearch = this.draftSearchWebpage;
                EditTextCaption editTextCaption = this.messageEditText;
                editTextCaption.setSelection(editTextCaption.length());
                if (getVisibility() == 0) {
                    this.delegate.onAttachButtonShow();
                }
                updateFieldRight(1);
            }
            updateFieldHint(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setEditingMessageObject$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setEditingMessageObject$31$ChatActivityEnterView(CharSequence charSequence) {
        setFieldText(charSequence);
        this.setTextFieldRunnable = null;
    }

    public ImageView getAttachButton() {
        return this.attachButton;
    }

    public View getSendButton() {
        return this.sendButton.getVisibility() == 0 ? this.sendButton : this.audioVideoButtonContainer;
    }

    public View getAudioVideoButtonContainer() {
        return this.audioVideoButtonContainer;
    }

    public EmojiView getEmojiView() {
        return this.emojiView;
    }

    public TrendingStickersAlert getTrendingStickersAlert() {
        return this.trendingStickersAlert;
    }

    public void updateColors() {
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.updateColors();
        }
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = this.sendPopupLayout;
        if (actionBarPopupWindowLayout != null) {
            int childCount = actionBarPopupWindowLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.sendPopupLayout.getChildAt(i);
                if (childAt instanceof ActionBarMenuSubItem) {
                    ActionBarMenuSubItem actionBarMenuSubItem = (ActionBarMenuSubItem) childAt;
                    actionBarMenuSubItem.setColors(getThemedColor("actionBarDefaultSubmenuItem"), getThemedColor("actionBarDefaultSubmenuItemIcon"));
                    actionBarMenuSubItem.setSelectorColor(getThemedColor("dialogButtonSelector"));
                }
            }
            this.sendPopupLayout.setBackgroundColor(getThemedColor("actionBarDefaultSubmenuBackground"));
            ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
            if (actionBarPopupWindow != null && actionBarPopupWindow.isShowing()) {
                this.sendPopupLayout.invalidate();
            }
        }
        updateRecordedDeleteIconColors();
        this.recordCircle.updateColors();
        this.recordDot.updateColors();
        this.slideText.updateColors();
        this.recordTimerView.updateColors();
        this.videoTimelineView.updateColors();
        NumberTextView numberTextView = this.captionLimitView;
        if (numberTextView != null && this.messageEditText != null) {
            if (this.codePointCount - this.currentLimit < 0) {
                numberTextView.setTextColor(getThemedColor("windowBackgroundWhiteRedText"));
            } else {
                numberTextView.setTextColor(getThemedColor("windowBackgroundWhiteGrayText"));
            }
        }
        this.doneCheckDrawable.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(getThemedColor("chat_messagePanelVoicePressed"), (int) (Color.alpha(r0) * ((this.doneButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
        BotCommandsMenuContainer botCommandsMenuContainer = this.botCommandsMenuContainer;
        if (botCommandsMenuContainer != null) {
            botCommandsMenuContainer.updateColors();
        }
        BotKeyboardView botKeyboardView = this.botKeyboardView;
        if (botKeyboardView != null) {
            botKeyboardView.updateColors();
        }
        for (int i2 = 0; i2 < 2; i2++) {
            this.emojiButton[i2].setColorFilter(new PorterDuffColorFilter(getThemedColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
        }
    }

    private void updateRecordedDeleteIconColors() {
        int themedColor = getThemedColor("chat_recordedVoiceDot");
        int themedColor2 = getThemedColor("chat_messagePanelBackground");
        int themedColor3 = getThemedColor("chat_messagePanelVoiceDelete");
        this.recordDeleteImageView.setLayerColor("Cup Red.**", themedColor);
        this.recordDeleteImageView.setLayerColor("Box Red.**", themedColor);
        this.recordDeleteImageView.setLayerColor("Cup Grey.**", themedColor3);
        this.recordDeleteImageView.setLayerColor("Box Grey.**", themedColor3);
        this.recordDeleteImageView.setLayerColor("Line 1.**", themedColor2);
        this.recordDeleteImageView.setLayerColor("Line 2.**", themedColor2);
        this.recordDeleteImageView.setLayerColor("Line 3.**", themedColor2);
    }

    public void setFieldText(CharSequence text) {
        setFieldText(text, true);
    }

    public void setFieldText(CharSequence text, boolean ignoreChange) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        this.ignoreTextChange = ignoreChange;
        editTextCaption.setText(text);
        EditTextCaption editTextCaption2 = this.messageEditText;
        editTextCaption2.setSelection(editTextCaption2.getText().length());
        this.ignoreTextChange = false;
        if (!ignoreChange || (chatActivityEnterViewDelegate = this.delegate) == null) {
            return;
        }
        chatActivityEnterViewDelegate.onTextChanged(this.messageEditText.getText(), true);
    }

    public void setSelection(int start) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        editTextCaption.setSelection(start, editTextCaption.length());
    }

    public int getCursorPosition() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return 0;
        }
        return editTextCaption.getSelectionStart();
    }

    public int getSelectionLength() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return 0;
        }
        try {
            return editTextCaption.getSelectionEnd() - this.messageEditText.getSelectionStart();
        } catch (Exception e) {
            FileLog.e(e);
            return 0;
        }
    }

    public void replaceWithText(int start, int len, CharSequence text, boolean parseEmoji) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.messageEditText.getText());
            spannableStringBuilder.replace(start, len + start, text);
            if (parseEmoji) {
                Emoji.replaceEmoji(spannableStringBuilder, this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            }
            this.messageEditText.setText(spannableStringBuilder);
            this.messageEditText.setSelection(start + text.length());
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setFieldFocused() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.parentActivity.getSystemService("accessibility");
        if (this.messageEditText == null || accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        try {
            this.messageEditText.requestFocus();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public void setFieldFocused(boolean focus) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.parentActivity.getSystemService("accessibility");
        if (this.messageEditText == null || accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        if (focus) {
            if (this.searchingType != 0 || this.messageEditText.isFocused()) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$nAyB5Aa-BxLtM18stKTl6gtPfHI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFieldFocused$32$ChatActivityEnterView();
                }
            };
            this.focusRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 600L);
            return;
        }
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null || !editTextCaption.isFocused()) {
            return;
        }
        if (!this.keyboardVisible || this.isPaused) {
            this.messageEditText.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setFieldFocused$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setFieldFocused$32$ChatActivityEnterView() {
        EditTextCaption editTextCaption;
        ActionBarLayout layersActionBarLayout;
        this.focusRunnable = null;
        boolean z = true;
        if (AndroidUtilities.isTablet()) {
            Activity activity = this.parentActivity;
            if ((activity instanceof LaunchActivity) && (layersActionBarLayout = ((LaunchActivity) activity).getLayersActionBarLayout()) != null && layersActionBarLayout.getVisibility() == 0) {
                z = false;
            }
        }
        if (this.isPaused || !z || (editTextCaption = this.messageEditText) == null) {
            return;
        }
        try {
            editTextCaption.requestFocus();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public boolean hasText() {
        EditTextCaption editTextCaption = this.messageEditText;
        return editTextCaption != null && editTextCaption.length() > 0;
    }

    public EditTextCaption getEditField() {
        return this.messageEditText;
    }

    public CharSequence getDraftMessage() {
        if (this.editingMessageObject != null) {
            if (TextUtils.isEmpty(this.draftMessage)) {
                return null;
            }
            return this.draftMessage;
        }
        if (hasText()) {
            return this.messageEditText.getText();
        }
        return null;
    }

    public CharSequence getFieldText() {
        if (hasText()) {
            return this.messageEditText.getText();
        }
        return null;
    }

    public void updateScheduleButton(boolean animated) {
        boolean z;
        ImageView imageView;
        ImageView imageView2;
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        if (DialogObject.isChatDialog(this.dialog_id)) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-this.dialog_id));
            this.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("silent_" + this.dialog_id, false);
            z = ChatObject.isChannel(chat) && (chat.creator || ((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_messages)) && !chat.megagroup;
            this.canWriteToChannel = z;
            if (this.notifyButton != null) {
                if (this.notifySilentDrawable == null) {
                    this.notifySilentDrawable = new CrossOutDrawable(getContext(), R.drawable.input_notify_on, "chat_messagePanelIcons");
                }
                this.notifySilentDrawable.setCrossOut(this.silent, false);
                this.notifyButton.setImageDrawable(this.notifySilentDrawable);
            } else {
                z = false;
            }
            LinearLayout linearLayout = this.attachLayout;
            if (linearLayout != null) {
                updateFieldRight(linearLayout.getVisibility() == 0 ? 1 : 0);
            }
        } else {
            z = false;
        }
        boolean z2 = (this.delegate == null || isInScheduleMode() || !this.delegate.hasScheduledMessages()) ? false : true;
        final boolean z3 = (!z2 || this.scheduleButtonHidden || this.recordingAudioVideo) ? false : true;
        ImageView imageView3 = this.scheduledButton;
        float f = 96.0f;
        if (imageView3 != null) {
            if ((imageView3.getTag() != null && z3) || (this.scheduledButton.getTag() == null && !z3)) {
                if (this.notifyButton != null) {
                    int i = (z2 || !z || this.scheduledButton.getVisibility() == 0) ? 8 : 0;
                    if (i != this.notifyButton.getVisibility()) {
                        this.notifyButton.setVisibility(i);
                        LinearLayout linearLayout2 = this.attachLayout;
                        if (linearLayout2 != null) {
                            ImageView imageView4 = this.botButton;
                            if ((imageView4 == null || imageView4.getVisibility() == 8) && ((imageView2 = this.notifyButton) == null || imageView2.getVisibility() == 8)) {
                                f = 48.0f;
                            }
                            linearLayout2.setPivotX(AndroidUtilities.dp(f));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.scheduledButton.setTag(z3 ? 1 : null);
        }
        AnimatorSet animatorSet = this.scheduledButtonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.scheduledButtonAnimation = null;
        }
        if (!animated || z) {
            ImageView imageView5 = this.scheduledButton;
            if (imageView5 != null) {
                imageView5.setVisibility(z3 ? 0 : 8);
                this.scheduledButton.setAlpha(z3 ? 1.0f : 0.0f);
                this.scheduledButton.setScaleX(z3 ? 1.0f : 0.1f);
                this.scheduledButton.setScaleY(z3 ? 1.0f : 0.1f);
                ImageView imageView6 = this.notifyButton;
                if (imageView6 != null) {
                    imageView6.setVisibility((!z || this.scheduledButton.getVisibility() == 0) ? 8 : 0);
                }
            }
        } else {
            ImageView imageView7 = this.scheduledButton;
            if (imageView7 != null) {
                if (z3) {
                    imageView7.setVisibility(0);
                }
                this.scheduledButton.setPivotX(AndroidUtilities.dp(24.0f));
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.scheduledButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView8 = this.scheduledButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z3 ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView8, (Property<ImageView, Float>) property, fArr);
                ImageView imageView9 = this.scheduledButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = z3 ? 1.0f : 0.1f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView9, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView10 = this.scheduledButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = z3 ? 1.0f : 0.1f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView10, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.scheduledButtonAnimation.setDuration(180L);
                this.scheduledButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.44
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ChatActivityEnterView.this.scheduledButtonAnimation = null;
                        if (z3) {
                            return;
                        }
                        ChatActivityEnterView.this.scheduledButton.setVisibility(8);
                    }
                });
                this.scheduledButtonAnimation.start();
            }
        }
        LinearLayout linearLayout3 = this.attachLayout;
        if (linearLayout3 != null) {
            ImageView imageView11 = this.botButton;
            if ((imageView11 == null || imageView11.getVisibility() == 8) && ((imageView = this.notifyButton) == null || imageView.getVisibility() == 8)) {
                f = 48.0f;
            }
            linearLayout3.setPivotX(AndroidUtilities.dp(f));
        }
    }

    private void updateBotButton(boolean animated) {
        ImageView imageView;
        ImageView imageView2 = this.botButton;
        if (imageView2 == null) {
            return;
        }
        boolean z = false;
        if (!this.parentFragment.openAnimationEnded) {
            animated = false;
        }
        boolean z2 = this.hasBotCommands;
        boolean z3 = z2 && this.dialog_id > 0;
        if (z2 || this.botReplyMarkup != null) {
            if (this.botReplyMarkup != null) {
                if (imageView2.getVisibility() != 0) {
                    this.botButton.setVisibility(0);
                }
                if (isPopupShowing() && this.currentPopupContentType == 1) {
                    this.botButtonDrawable.setIcon(R.drawable.input_keyboard, true);
                    this.botButton.setContentDescription(LocaleController.getString("AccDescrShowKeyboard", R.string.AccDescrShowKeyboard));
                } else {
                    this.botButtonDrawable.setIcon(R.drawable.input_bot2, true);
                    this.botButton.setContentDescription(LocaleController.getString("AccDescrBotKeyboard", R.string.AccDescrBotKeyboard));
                }
            } else if (!z3) {
                this.botButtonDrawable.setIcon(R.drawable.input_bot1, true);
                this.botButton.setContentDescription(LocaleController.getString("AccDescrBotCommands", R.string.AccDescrBotCommands));
                this.botButton.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
        } else {
            imageView2.setVisibility(8);
        }
        BotCommandsMenuView botCommandsMenuView = this.botCommandsMenuButton;
        if (z3 && this.hasBotCommands) {
            z = true;
        }
        AndroidUtilities.updateViewVisibilityAnimated(botCommandsMenuView, z, 0.5f, animated);
        if (animated) {
            beginDelayedTransition();
        }
        updateFieldRight(2);
        LinearLayout linearLayout = this.attachLayout;
        ImageView imageView3 = this.botButton;
        linearLayout.setPivotX(AndroidUtilities.dp(((imageView3 == null || imageView3.getVisibility() == 8) && ((imageView = this.notifyButton) == null || imageView.getVisibility() == 8)) ? 48.0f : 96.0f));
    }

    public boolean isRtlText() {
        try {
            return this.messageEditText.getLayout().getParagraphDirection(0) == -1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void setBotsCount(int count, boolean hasCommands, boolean animated) {
        this.botCount = count;
        if (this.hasBotCommands != hasCommands) {
            this.hasBotCommands = hasCommands;
            updateBotButton(animated);
        }
    }

    public void setButtons(MessageObject messageObject) {
        setButtons(messageObject, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setButtons(ir.eitaa.messenger.MessageObject r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatActivityEnterView.setButtons(ir.eitaa.messenger.MessageObject, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setButtons$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setButtons$33$ChatActivityEnterView(TLRPC$KeyboardButton tLRPC$KeyboardButton) {
        MessageObject messageObject = this.replyingMessageObject;
        if (messageObject == null) {
            messageObject = DialogObject.isChatDialog(this.dialog_id) ? this.botButtonsMessageObject : null;
        }
        MessageObject messageObject2 = this.replyingMessageObject;
        if (messageObject2 == null) {
            messageObject2 = this.botButtonsMessageObject;
        }
        boolean zDidPressedBotButton = didPressedBotButton(tLRPC$KeyboardButton, messageObject, messageObject2);
        if (this.replyingMessageObject != null) {
            openKeyboardInternal();
            setButtons(this.botMessageObject, false);
        } else {
            MessageObject messageObject3 = this.botButtonsMessageObject;
            if (messageObject3 != null && messageObject3.messageOwner.reply_markup.single_use) {
                if (zDidPressedBotButton) {
                    openKeyboardInternal();
                } else {
                    showPopup(0, 0);
                }
                MessagesController.getMainSettings(this.currentAccount).edit().putInt("answered_" + this.dialog_id, this.botButtonsMessageObject.getId()).commit();
            }
        }
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onMessageSend(null, true, 0);
        }
    }

    public boolean didPressedBotButton(final TLRPC$KeyboardButton button, final MessageObject replyMessageObject, final MessageObject messageObject) {
        if (button == null || messageObject == null) {
            return false;
        }
        if (button instanceof TLRPC$TL_keyboardButton) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(button.text, this.dialog_id, replyMessageObject, getThreadMessage(), null, false, null, null, null, true, 0, null);
        } else if (button instanceof TLRPC$TL_keyboardButtonUrl) {
            AlertsCreator.showOpenUrlAlert(this.parentFragment, button.url, false, true, this.resourcesProvider);
        } else if (button instanceof TLRPC$TL_keyboardButtonRequestPhone) {
            this.parentFragment.shareMyContact(2, messageObject);
        } else {
            if (button instanceof TLRPC$TL_keyboardButtonRequestPoll) {
                this.parentFragment.openPollCreate((button.flags & 1) != 0 ? Boolean.valueOf(button.quiz) : null);
                return false;
            }
            if (button instanceof TLRPC$TL_keyboardButtonRequestGeoLocation) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity);
                builder.setTitle(LocaleController.getString("ShareYouLocationTitle", R.string.ShareYouLocationTitle));
                builder.setMessage(LocaleController.getString("ShareYouLocationInfo", R.string.ShareYouLocationInfo));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$nRhzwy6i76i1FdPHOU9JHsox5HU
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$didPressedBotButton$34$ChatActivityEnterView(messageObject, button, dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                this.parentFragment.showDialog(builder.create());
            } else {
                boolean z = button instanceof TLRPC$TL_keyboardButtonBuy;
                if (z) {
                    SendMessagesHelper.getInstance(this.currentAccount).sendPayInfo(messageObject, button, this.parentFragment);
                } else if ((button instanceof TLRPC$TL_keyboardButtonCallback) || (button instanceof TLRPC$TL_keyboardButtonGame) || z || (button instanceof TLRPC$TL_keyboardButtonUrlAuth)) {
                    SendMessagesHelper.getInstance(this.currentAccount).sendCallback(true, messageObject, button, this.parentFragment);
                } else {
                    if (!(button instanceof TLRPC$TL_keyboardButtonSwitchInline) || this.parentFragment.processSwitchButton((TLRPC$TL_keyboardButtonSwitchInline) button)) {
                        return true;
                    }
                    if (button.same_peer) {
                        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
                        long j = tLRPC$Message.from_id.user_id;
                        long j2 = tLRPC$Message.via_bot_id;
                        if (j2 != 0) {
                            j = j2;
                        }
                        TLRPC$User user = this.accountInstance.getMessagesController().getUser(Long.valueOf(j));
                        if (user == null) {
                            return true;
                        }
                        setFieldText("@" + user.username + " " + button.query);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("onlySelect", true);
                        bundle.putInt("dialogsType", 1);
                        DialogsActivity dialogsActivity = new DialogsActivity(bundle);
                        dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$1vYi2ulOQFVr-5FaOVep__C6mV4
                            @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                            public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z2) {
                                this.f$0.lambda$didPressedBotButton$35$ChatActivityEnterView(messageObject, button, dialogsActivity2, arrayList, charSequence, z2);
                            }
                        });
                        this.parentFragment.presentFragment(dialogsActivity);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didPressedBotButton$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didPressedBotButton$34$ChatActivityEnterView(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, DialogInterface dialogInterface, int i) {
        if (Build.VERSION.SDK_INT >= 23 && this.parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            this.pendingMessageObject = messageObject;
            this.pendingLocationButton = tLRPC$KeyboardButton;
            return;
        }
        SendMessagesHelper.getInstance(this.currentAccount).sendCurrentLocation(messageObject, tLRPC$KeyboardButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didPressedBotButton$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didPressedBotButton$35$ChatActivityEnterView(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        long j = tLRPC$Message.from_id.user_id;
        long j2 = tLRPC$Message.via_bot_id;
        if (j2 != 0) {
            j = j2;
        }
        TLRPC$User user = this.accountInstance.getMessagesController().getUser(Long.valueOf(j));
        if (user == null) {
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        MediaDataController.getInstance(this.currentAccount).saveDraft(jLongValue, 0, "@" + user.username + " " + tLRPC$KeyboardButton.query, null, null, true);
        if (jLongValue != this.dialog_id) {
            if (!DialogObject.isEncryptedDialog(jLongValue)) {
                Bundle bundle = new Bundle();
                if (DialogObject.isUserDialog(jLongValue)) {
                    bundle.putLong("user_id", jLongValue);
                } else {
                    bundle.putLong("chat_id", -jLongValue);
                }
                if (this.accountInstance.getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
                    if (this.parentFragment.presentFragment(new ChatActivity(bundle), true)) {
                        if (AndroidUtilities.isTablet()) {
                            return;
                        }
                        this.parentFragment.removeSelfFromStack();
                        return;
                    }
                    dialogsActivity.finishFragment();
                    return;
                }
                return;
            }
            dialogsActivity.finishFragment();
            return;
        }
        dialogsActivity.finishFragment();
    }

    public boolean isPopupView(View view) {
        return view == this.botKeyboardView || view == this.emojiView;
    }

    public boolean isRecordCircle(View view) {
        return view == this.recordCircle;
    }

    private void createEmojiView() {
        if (this.emojiView != null) {
            return;
        }
        EmojiView emojiView = new EmojiView(this.allowStickers, this.allowGifs, getContext(), true, this.info, this.sizeNotifierLayout, this.resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.46
            @Override // ir.eitaa.ui.Components.EmojiView, android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY);
                if (ChatActivityEnterView.this.panelAnimation == null || ChatActivityEnterView.this.animatingContentType != 0) {
                    return;
                }
                ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(translationY);
            }
        };
        this.emojiView = emojiView;
        emojiView.setVisibility(8);
        this.emojiView.setShowing(false);
        this.emojiView.setDelegate(new AnonymousClass47());
        this.emojiView.setDragListener(new EmojiView.DragListener() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.48
            int initialOffset;
            boolean wasExpanded;

            @Override // ir.eitaa.ui.Components.EmojiView.DragListener
            public void onDragStart() {
                if (allowDragging()) {
                    if (ChatActivityEnterView.this.stickersExpansionAnim != null) {
                        ChatActivityEnterView.this.stickersExpansionAnim.cancel();
                    }
                    ChatActivityEnterView.this.stickersDragging = true;
                    this.wasExpanded = ChatActivityEnterView.this.stickersExpanded;
                    ChatActivityEnterView.this.stickersExpanded = true;
                    NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 1);
                    ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                    chatActivityEnterView.stickersExpandedHeight = (((chatActivityEnterView.sizeNotifierLayout.getHeight() - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) - ActionBar.getCurrentActionBarHeight()) - ChatActivityEnterView.this.getHeight()) + Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                    if (ChatActivityEnterView.this.searchingType == 2) {
                        ChatActivityEnterView chatActivityEnterView2 = ChatActivityEnterView.this;
                        int i = chatActivityEnterView2.stickersExpandedHeight;
                        int iDp = AndroidUtilities.dp(120.0f);
                        android.graphics.Point point = AndroidUtilities.displaySize;
                        chatActivityEnterView2.stickersExpandedHeight = Math.min(i, iDp + (point.x > point.y ? ChatActivityEnterView.this.keyboardHeightLand : ChatActivityEnterView.this.keyboardHeight));
                    }
                    ChatActivityEnterView.this.emojiView.getLayoutParams().height = ChatActivityEnterView.this.stickersExpandedHeight;
                    ChatActivityEnterView.this.emojiView.setLayerType(2, null);
                    ChatActivityEnterView.this.sizeNotifierLayout.requestLayout();
                    ChatActivityEnterView.this.sizeNotifierLayout.setForeground(ChatActivityEnterView.this.new ScrimDrawable());
                    this.initialOffset = (int) ChatActivityEnterView.this.getTranslationY();
                    if (ChatActivityEnterView.this.delegate != null) {
                        ChatActivityEnterView.this.delegate.onStickersExpandedChange();
                    }
                }
            }

            @Override // ir.eitaa.ui.Components.EmojiView.DragListener
            public void onDragEnd(float velocity) {
                if (allowDragging()) {
                    ChatActivityEnterView.this.stickersDragging = false;
                    if ((this.wasExpanded && velocity >= AndroidUtilities.dp(200.0f)) || ((!this.wasExpanded && velocity <= AndroidUtilities.dp(-200.0f)) || ((this.wasExpanded && ChatActivityEnterView.this.stickersExpansionProgress <= 0.6f) || (!this.wasExpanded && ChatActivityEnterView.this.stickersExpansionProgress >= 0.4f)))) {
                        ChatActivityEnterView.this.setStickersExpanded(!this.wasExpanded, true, true);
                    } else {
                        ChatActivityEnterView.this.setStickersExpanded(this.wasExpanded, true, true);
                    }
                }
            }

            @Override // ir.eitaa.ui.Components.EmojiView.DragListener
            public void onDragCancel() {
                if (ChatActivityEnterView.this.stickersTabOpen) {
                    ChatActivityEnterView.this.stickersDragging = false;
                    ChatActivityEnterView.this.setStickersExpanded(this.wasExpanded, true, false);
                }
            }

            @Override // ir.eitaa.ui.Components.EmojiView.DragListener
            public void onDrag(int offset) {
                if (allowDragging()) {
                    android.graphics.Point point = AndroidUtilities.displaySize;
                    float fMax = Math.max(Math.min(offset + this.initialOffset, 0), -(ChatActivityEnterView.this.stickersExpandedHeight - (point.x > point.y ? ChatActivityEnterView.this.keyboardHeightLand : ChatActivityEnterView.this.keyboardHeight)));
                    ChatActivityEnterView.this.emojiView.setTranslationY(fMax);
                    ChatActivityEnterView.this.setTranslationY(fMax);
                    ChatActivityEnterView.this.stickersExpansionProgress = fMax / (-(r1.stickersExpandedHeight - r0));
                    ChatActivityEnterView.this.sizeNotifierLayout.invalidate();
                }
            }

            private boolean allowDragging() {
                return ChatActivityEnterView.this.stickersTabOpen && (ChatActivityEnterView.this.stickersExpanded || ChatActivityEnterView.this.messageEditText.length() <= 0) && ChatActivityEnterView.this.emojiView.areThereAnyStickers() && !ChatActivityEnterView.this.waitingForKeyboardOpen;
            }
        });
        this.sizeNotifierLayout.addView(this.emojiView, r0.getChildCount() - 5);
        checkChannelRights();
    }

    /* renamed from: ir.eitaa.ui.Components.ChatActivityEnterView$47, reason: invalid class name */
    class AnonymousClass47 implements EmojiView.EmojiViewDelegate {
        AnonymousClass47() {
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public boolean onBackspace() {
            if (ChatActivityEnterView.this.messageEditText.length() == 0) {
                return false;
            }
            ChatActivityEnterView.this.messageEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onEmojiSelected(String symbol) {
            int selectionEnd = ChatActivityEnterView.this.messageEditText.getSelectionEnd();
            if (selectionEnd < 0) {
                selectionEnd = 0;
            }
            try {
                try {
                    ChatActivityEnterView.this.innerTextChange = 2;
                    CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(symbol, ChatActivityEnterView.this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                    EditTextCaption editTextCaption = ChatActivityEnterView.this.messageEditText;
                    editTextCaption.setText(editTextCaption.getText().insert(selectionEnd, charSequenceReplaceEmoji));
                    int length = selectionEnd + charSequenceReplaceEmoji.length();
                    ChatActivityEnterView.this.messageEditText.setSelection(length, length);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } finally {
                ChatActivityEnterView.this.innerTextChange = 0;
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSelected(View view, TLRPC$Document sticker, String query, Object parent, MessageObject.SendAnimationData sendAnimationData, boolean notify, int scheduleDate) {
            if (ChatActivityEnterView.this.trendingStickersAlert != null) {
                ChatActivityEnterView.this.trendingStickersAlert.dismiss();
                ChatActivityEnterView.this.trendingStickersAlert = null;
            }
            if (ChatActivityEnterView.this.slowModeTimer <= 0 || isInScheduleMode()) {
                if (ChatActivityEnterView.this.stickersExpanded) {
                    if (ChatActivityEnterView.this.searchingType != 0) {
                        ChatActivityEnterView.this.setSearchingTypeInternal(0, true);
                        ChatActivityEnterView.this.emojiView.closeSearch(true, MessageObject.getStickerSetId(sticker));
                        ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                    }
                    ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                }
                ChatActivityEnterView.this.lambda$onStickerSelected$36(sticker, query, parent, sendAnimationData, false, notify, scheduleDate);
                if (DialogObject.isEncryptedDialog(ChatActivityEnterView.this.dialog_id) && MessageObject.isGifDocument(sticker)) {
                    ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(parent, sticker);
                    return;
                }
                return;
            }
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onUpdateSlowModeButton(view != null ? view : ChatActivityEnterView.this.slowModeButton, true, ChatActivityEnterView.this.slowModeButton.getText());
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickersSettingsClick() {
            if (ChatActivityEnterView.this.parentFragment != null) {
                ChatActivityEnterView.this.parentFragment.presentFragment(new StickersActivity(0));
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        /* renamed from: onGifSelected, reason: merged with bridge method [inline-methods] */
        public void lambda$onGifSelected$0$ChatActivityEnterView$47(final View view, final Object gif, final String query, final Object parent, boolean notify, int scheduleDate) throws IOException {
            if (!isInScheduleMode() || scheduleDate != 0) {
                if (ChatActivityEnterView.this.slowModeTimer <= 0 || isInScheduleMode()) {
                    if (ChatActivityEnterView.this.stickersExpanded) {
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                        }
                        ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                    }
                    if (gif instanceof TLRPC$Document) {
                        TLRPC$Document tLRPC$Document = (TLRPC$Document) gif;
                        SendMessagesHelper.getInstance(ChatActivityEnterView.this.currentAccount).sendSticker(tLRPC$Document, query, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), parent, null, notify, scheduleDate);
                        MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).addRecentGif(tLRPC$Document, (int) (System.currentTimeMillis() / 1000));
                        if (DialogObject.isEncryptedDialog(ChatActivityEnterView.this.dialog_id)) {
                            ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(parent, tLRPC$Document);
                        }
                    } else if (gif instanceof TLRPC$BotInlineResult) {
                        TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) gif;
                        if (tLRPC$BotInlineResult.document != null) {
                            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).addRecentGif(tLRPC$BotInlineResult.document, (int) (System.currentTimeMillis() / 1000));
                            if (DialogObject.isEncryptedDialog(ChatActivityEnterView.this.dialog_id)) {
                                ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(parent, tLRPC$BotInlineResult.document);
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("id", tLRPC$BotInlineResult.id);
                        map.put("query_id", "" + tLRPC$BotInlineResult.query_id);
                        map.put("force_gif", "1");
                        SendMessagesHelper.prepareSendingBotContextResult(ChatActivityEnterView.this.accountInstance, tLRPC$BotInlineResult, map, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), notify, scheduleDate);
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.setSearchingTypeInternal(0, true);
                            ChatActivityEnterView.this.emojiView.closeSearch(true);
                            ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                        }
                    }
                    if (ChatActivityEnterView.this.delegate != null) {
                        ChatActivityEnterView.this.delegate.onMessageSend(null, notify, scheduleDate);
                        return;
                    }
                    return;
                }
                if (ChatActivityEnterView.this.delegate != null) {
                    ChatActivityEnterView.this.delegate.onUpdateSlowModeButton(view != null ? view : ChatActivityEnterView.this.slowModeButton, true, ChatActivityEnterView.this.slowModeButton.getText());
                    return;
                }
                return;
            }
            AlertsCreator.createScheduleDatePickerDialog(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$47$ADKcbthnIDbDTgM6j-s2nS_zolg
                @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i) throws IOException {
                    this.f$0.lambda$onGifSelected$0$ChatActivityEnterView$47(view, gif, query, parent, z, i);
                }
            }, ChatActivityEnterView.this.resourcesProvider);
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onTabOpened(int type) {
            ChatActivityEnterView.this.delegate.onStickersTab(type == 3);
            ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
            chatActivityEnterView.post(chatActivityEnterView.updateExpandabilityRunnable);
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onClearEmojiRecent() {
            if (ChatActivityEnterView.this.parentFragment == null || ChatActivityEnterView.this.parentActivity == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.resourcesProvider);
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("ClearRecentEmoji", R.string.ClearRecentEmoji));
            builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$47$VUjxUT7YH6d70ZHyEXQrdiyW94M
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onClearEmojiRecent$1$ChatActivityEnterView$47(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            ChatActivityEnterView.this.parentFragment.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onClearEmojiRecent$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onClearEmojiRecent$1$ChatActivityEnterView$47(DialogInterface dialogInterface, int i) {
            ChatActivityEnterView.this.emojiView.clearRecentEmoji();
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onShowStickerSet(TLRPC$StickerSet stickerSet, TLRPC$InputStickerSet inputStickerSet) {
            if (ChatActivityEnterView.this.trendingStickersAlert == null || ChatActivityEnterView.this.trendingStickersAlert.isDismissed()) {
                if (ChatActivityEnterView.this.parentFragment == null || ChatActivityEnterView.this.parentActivity == null) {
                    return;
                }
                if (stickerSet != null) {
                    inputStickerSet = new TLRPC$TL_inputStickerSetID();
                    inputStickerSet.access_hash = stickerSet.access_hash;
                    inputStickerSet.id = stickerSet.id;
                }
                ChatActivity chatActivity = ChatActivityEnterView.this.parentFragment;
                Activity activity = ChatActivityEnterView.this.parentActivity;
                ChatActivity chatActivity2 = ChatActivityEnterView.this.parentFragment;
                ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                chatActivity.showDialog(new StickersAlert(activity, chatActivity2, inputStickerSet, null, chatActivityEnterView, chatActivityEnterView.resourcesProvider));
                return;
            }
            ChatActivityEnterView.this.trendingStickersAlert.getLayout().showStickerSet(stickerSet, inputStickerSet);
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSetAdd(TLRPC$StickerSetCovered stickerSet) {
            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).toggleStickerSet(ChatActivityEnterView.this.parentActivity, stickerSet, 2, ChatActivityEnterView.this.parentFragment, false, false);
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSetRemove(TLRPC$StickerSetCovered stickerSet) {
            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).toggleStickerSet(ChatActivityEnterView.this.parentActivity, stickerSet, 0, ChatActivityEnterView.this.parentFragment, false, false);
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickersGroupClick(long chatId) {
            if (ChatActivityEnterView.this.parentFragment != null) {
                if (AndroidUtilities.isTablet()) {
                    ChatActivityEnterView.this.hidePopup(false);
                }
                GroupStickersActivity groupStickersActivity = new GroupStickersActivity(chatId);
                groupStickersActivity.setInfo(ChatActivityEnterView.this.info);
                ChatActivityEnterView.this.parentFragment.presentFragment(groupStickersActivity);
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void onSearchOpenClose(int type) {
            ChatActivityEnterView.this.setSearchingTypeInternal(type, true);
            if (type != 0) {
                ChatActivityEnterView.this.setStickersExpanded(true, true, false);
            }
            if (ChatActivityEnterView.this.emojiTabOpen && ChatActivityEnterView.this.searchingType == 2) {
                ChatActivityEnterView.this.checkStickresExpandHeight();
            }
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isSearchOpened() {
            return ChatActivityEnterView.this.searchingType != 0;
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isExpanded() {
            return ChatActivityEnterView.this.stickersExpanded;
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isInScheduleMode() {
            return ChatActivityEnterView.this.parentFragment != null && ChatActivityEnterView.this.parentFragment.isInScheduleMode();
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public long getDialogId() {
            return ChatActivityEnterView.this.dialog_id;
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public int getThreadId() {
            return ChatActivityEnterView.this.getThreadMessageId();
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void showTrendingStickersAlert(TrendingStickersLayout layout) {
            if (ChatActivityEnterView.this.parentActivity == null || ChatActivityEnterView.this.parentFragment == null) {
                return;
            }
            ChatActivityEnterView.this.trendingStickersAlert = new TrendingStickersAlert(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment, layout, ChatActivityEnterView.this.resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.47.1
                @Override // ir.eitaa.ui.Components.TrendingStickersAlert, ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
                public void dismiss() {
                    super.dismiss();
                    if (ChatActivityEnterView.this.trendingStickersAlert == this) {
                        ChatActivityEnterView.this.trendingStickersAlert = null;
                    }
                    if (ChatActivityEnterView.this.delegate != null) {
                        ChatActivityEnterView.this.delegate.onTrendingStickersShowed(false);
                    }
                }
            };
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onTrendingStickersShowed(true);
            }
            ChatActivityEnterView.this.trendingStickersAlert.show();
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public void invalidateEnterView() {
            ChatActivityEnterView.this.invalidate();
        }

        @Override // ir.eitaa.ui.Components.EmojiView.EmojiViewDelegate
        public float getProgressToSearchOpened() {
            return ChatActivityEnterView.this.searchToOpenProgress;
        }
    }

    @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertDelegate
    /* renamed from: onStickerSelected, reason: merged with bridge method [inline-methods] */
    public void lambda$onStickerSelected$36$ChatActivityEnterView(final TLRPC$Document sticker, final String query, final Object parent, final MessageObject.SendAnimationData sendAnimationData, final boolean clearsInputField, boolean notify, int scheduleDate) {
        if (isInScheduleMode() && scheduleDate == 0) {
            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$j9W_c_EbEt5u2O7j3aIypkMC4ac
                @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i) {
                    this.f$0.lambda$onStickerSelected$36$ChatActivityEnterView(sticker, query, parent, sendAnimationData, clearsInputField, z, i);
                }
            }, this.resourcesProvider);
            return;
        }
        if (this.slowModeTimer > 0 && !isInScheduleMode()) {
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                SimpleTextView simpleTextView = this.slowModeButton;
                chatActivityEnterViewDelegate.onUpdateSlowModeButton(simpleTextView, true, simpleTextView.getText());
                return;
            }
            return;
        }
        if (this.searchingType != 0) {
            setSearchingTypeInternal(0, true);
            this.emojiView.closeSearch(true);
            this.emojiView.hideSearchKeyboard();
        }
        setStickersExpanded(false, true, false);
        SendMessagesHelper.getInstance(this.currentAccount).sendSticker(sticker, query, this.dialog_id, this.replyingMessageObject, getThreadMessage(), parent, sendAnimationData, notify, scheduleDate);
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
        if (chatActivityEnterViewDelegate2 != null) {
            chatActivityEnterViewDelegate2.onMessageSend(null, true, scheduleDate);
        }
        if (clearsInputField) {
            setFieldText("");
        }
        MediaDataController.getInstance(this.currentAccount).addRecentSticker(0, parent, sticker, (int) (System.currentTimeMillis() / 1000), false);
    }

    @Override // ir.eitaa.ui.Components.StickersAlert.StickersAlertDelegate
    public boolean isInScheduleMode() {
        ChatActivity chatActivity = this.parentFragment;
        return chatActivity != null && chatActivity.isInScheduleMode();
    }

    public void addStickerToRecent(TLRPC$Document sticker) {
        createEmojiView();
        this.emojiView.addRecentSticker(sticker);
    }

    public void showEmojiView() {
        showPopup(1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup(final int show, int contentType) {
        int measuredHeight;
        View view;
        if (show == 2) {
            return;
        }
        if (show == 1) {
            if (contentType == 0 && this.emojiView == null) {
                if (this.parentActivity == null) {
                    return;
                } else {
                    createEmojiView();
                }
            }
            if (contentType == 0) {
                if (this.emojiView.getParent() == null) {
                    this.sizeNotifierLayout.addView(this.emojiView, r13.getChildCount() - 5);
                }
                if (this.emojiViewVisible) {
                    this.emojiView.getVisibility();
                }
                this.emojiView.setVisibility(0);
                this.emojiViewVisible = true;
                BotKeyboardView botKeyboardView = this.botKeyboardView;
                if (botKeyboardView == null || botKeyboardView.getVisibility() == 8) {
                    measuredHeight = 0;
                } else {
                    this.botKeyboardView.setVisibility(8);
                    this.botKeyboardViewVisible = false;
                    measuredHeight = this.botKeyboardView.getMeasuredHeight();
                }
                this.emojiView.setShowing(true);
                view = this.emojiView;
                this.animatingContentType = 0;
            } else if (contentType == 1) {
                if (this.botKeyboardViewVisible) {
                    this.botKeyboardView.getVisibility();
                }
                this.botKeyboardViewVisible = true;
                EmojiView emojiView = this.emojiView;
                if (emojiView == null || emojiView.getVisibility() == 8) {
                    measuredHeight = 0;
                } else {
                    this.sizeNotifierLayout.removeView(this.emojiView);
                    this.emojiView.setVisibility(8);
                    this.emojiView.setShowing(false);
                    this.emojiViewVisible = false;
                    measuredHeight = this.emojiView.getMeasuredHeight();
                }
                this.botKeyboardView.setVisibility(0);
                view = this.botKeyboardView;
                this.animatingContentType = 1;
            } else {
                measuredHeight = 0;
                view = null;
            }
            this.currentPopupContentType = contentType;
            if (this.keyboardHeight <= 0) {
                this.keyboardHeight = MessagesController.getGlobalEmojiSettings().getInt("kbd_height", AndroidUtilities.dp(200.0f));
            }
            if (this.keyboardHeightLand <= 0) {
                this.keyboardHeightLand = MessagesController.getGlobalEmojiSettings().getInt("kbd_height_land3", AndroidUtilities.dp(200.0f));
            }
            android.graphics.Point point = AndroidUtilities.displaySize;
            int iMin = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
            if (contentType == 1) {
                iMin = Math.min(this.botKeyboardView.getKeyboardHeight(), iMin);
            }
            BotKeyboardView botKeyboardView2 = this.botKeyboardView;
            if (botKeyboardView2 != null) {
                botKeyboardView2.setPanelHeight(iMin);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = iMin;
            view.setLayoutParams(layoutParams);
            if (!AndroidUtilities.isInMultiwindow) {
                AndroidUtilities.hideKeyboard(this.messageEditText);
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayout != null) {
                this.emojiPadding = iMin;
                sizeNotifierFrameLayout.requestLayout();
                setEmojiButtonImage(true, true);
                updateBotButton(true);
                onWindowSizeChanged();
                if (this.smoothKeyboard && !this.keyboardVisible && iMin != measuredHeight) {
                    this.panelAnimation = new AnimatorSet();
                    float f = iMin - measuredHeight;
                    view.setTranslationY(f);
                    this.panelAnimation.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, f, 0.0f));
                    this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                    this.panelAnimation.setDuration(250L);
                    this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.49
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            ChatActivityEnterView.this.panelAnimation = null;
                            if (ChatActivityEnterView.this.delegate != null) {
                                ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(0.0f);
                            }
                            NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                            ChatActivityEnterView.this.requestLayout();
                        }
                    });
                    AndroidUtilities.runOnUIThread(this.runEmojiPanelAnimation, 50L);
                    this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                    requestLayout();
                }
            }
        } else {
            if (this.emojiButton != null) {
                setEmojiButtonImage(false, true);
            }
            this.currentPopupContentType = -1;
            EmojiView emojiView2 = this.emojiView;
            if (emojiView2 != null) {
                if (show != 2 || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                    if (this.smoothKeyboard && !this.keyboardVisible && !this.stickersExpanded) {
                        this.emojiViewVisible = true;
                        this.animatingContentType = 0;
                        emojiView2.setShowing(false);
                        AnimatorSet animatorSet = new AnimatorSet();
                        this.panelAnimation = animatorSet;
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.emojiView, (Property<EmojiView, Float>) View.TRANSLATION_Y, r5.getMeasuredHeight()));
                        this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                        this.panelAnimation.setDuration(250L);
                        this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.50
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (show == 0) {
                                    ChatActivityEnterView.this.emojiPadding = 0;
                                }
                                ChatActivityEnterView.this.panelAnimation = null;
                                if (ChatActivityEnterView.this.emojiView != null) {
                                    ChatActivityEnterView.this.emojiView.setTranslationY(0.0f);
                                    ChatActivityEnterView.this.emojiView.setVisibility(8);
                                    ChatActivityEnterView.this.sizeNotifierLayout.removeView(ChatActivityEnterView.this.emojiView);
                                    if (ChatActivityEnterView.this.removeEmojiViewAfterAnimation) {
                                        ChatActivityEnterView.this.removeEmojiViewAfterAnimation = false;
                                        ChatActivityEnterView.this.emojiView = null;
                                    }
                                }
                                if (ChatActivityEnterView.this.delegate != null) {
                                    ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(0.0f);
                                }
                                NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                                ChatActivityEnterView.this.requestLayout();
                            }
                        });
                        this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                        AndroidUtilities.runOnUIThread(this.runEmojiPanelAnimation, 50L);
                        requestLayout();
                    } else {
                        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
                        if (chatActivityEnterViewDelegate != null) {
                            chatActivityEnterViewDelegate.bottomPanelTranslationYChanged(0.0f);
                        }
                        this.emojiPadding = 0;
                        this.sizeNotifierLayout.removeView(this.emojiView);
                        this.emojiView.setVisibility(8);
                        this.emojiView.setShowing(false);
                    }
                } else {
                    this.removeEmojiViewAfterAnimation = false;
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
                    if (chatActivityEnterViewDelegate2 != null) {
                        chatActivityEnterViewDelegate2.bottomPanelTranslationYChanged(0.0f);
                    }
                    this.sizeNotifierLayout.removeView(this.emojiView);
                    this.emojiView = null;
                }
                this.emojiViewVisible = false;
            }
            BotKeyboardView botKeyboardView3 = this.botKeyboardView;
            if (botKeyboardView3 != null && botKeyboardView3.getVisibility() == 0) {
                if (show != 2 || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                    if (this.smoothKeyboard && !this.keyboardVisible) {
                        if (this.botKeyboardViewVisible) {
                            this.animatingContentType = 1;
                        }
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        this.panelAnimation = animatorSet2;
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(this.botKeyboardView, (Property<BotKeyboardView, Float>) View.TRANSLATION_Y, r4.getMeasuredHeight()));
                        this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                        this.panelAnimation.setDuration(250L);
                        this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.51
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (show == 0) {
                                    ChatActivityEnterView.this.emojiPadding = 0;
                                }
                                ChatActivityEnterView.this.panelAnimation = null;
                                ChatActivityEnterView.this.botKeyboardView.setTranslationY(0.0f);
                                ChatActivityEnterView.this.botKeyboardView.setVisibility(8);
                                NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                                if (ChatActivityEnterView.this.delegate != null) {
                                    ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(0.0f);
                                }
                                ChatActivityEnterView.this.requestLayout();
                            }
                        });
                        this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                        AndroidUtilities.runOnUIThread(this.runEmojiPanelAnimation, 50L);
                        requestLayout();
                    } else if (!this.waitingForKeyboardOpen) {
                        this.botKeyboardView.setVisibility(8);
                    }
                }
                this.botKeyboardViewVisible = false;
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayout2 != null && !SharedConfig.smoothKeyboard && show == 0) {
                this.emojiPadding = 0;
                sizeNotifierFrameLayout2.requestLayout();
                onWindowSizeChanged();
            }
            updateBotButton(true);
        }
        if (this.stickersTabOpen || this.emojiTabOpen) {
            checkSendButton(true);
        }
        if (this.stickersExpanded && show != 1) {
            setStickersExpanded(false, false, false);
        }
        updateFieldHint(false);
        checkBotMenu();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    private void setEmojiButtonImage(boolean z, boolean z2) {
        int currentPage;
        int i;
        FrameLayout frameLayout;
        ?? r12 = z2;
        if (this.recordInterfaceState == 1 || ((frameLayout = this.recordedAudioPanel) != null && frameLayout.getVisibility() == 0)) {
            this.emojiButton[0].setScaleX(0.0f);
            this.emojiButton[0].setScaleY(0.0f);
            this.emojiButton[0].setAlpha(0.0f);
            this.emojiButton[1].setScaleX(0.0f);
            this.emojiButton[1].setScaleY(0.0f);
            this.emojiButton[1].setAlpha(0.0f);
            r12 = 0;
        }
        if (r12 != 0 && this.currentEmojiIcon == -1) {
            r12 = 0;
        }
        if (z && this.currentPopupContentType == 0) {
            i = 0;
        } else {
            EmojiView emojiView = this.emojiView;
            if (emojiView == null) {
                currentPage = MessagesController.getGlobalEmojiSettings().getInt("selected_page", 0);
            } else {
                currentPage = emojiView.getCurrentPage();
            }
            i = (currentPage == 0 || !(this.allowStickers || this.allowGifs)) ? 1 : currentPage == 1 ? 2 : 3;
        }
        if (this.currentEmojiIcon == i) {
            return;
        }
        AnimatorSet animatorSet = this.emojiButtonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.emojiButtonAnimation = null;
        }
        if (i == 0) {
            this.emojiButton[r12].setImageResource(R.drawable.input_keyboard);
        } else if (i == 1) {
            this.emojiButton[r12].setImageResource(R.drawable.input_smile);
        } else if (i == 2) {
            this.emojiButton[r12].setImageResource(R.drawable.input_sticker);
        } else if (i == 3) {
            this.emojiButton[r12].setImageResource(R.drawable.input_gif);
        }
        this.emojiButton[r12].setTag(i == 2 ? 1 : null);
        this.currentEmojiIcon = i;
        if (r12 != 0) {
            this.emojiButton[1].setVisibility(0);
            this.emojiButton[1].setAlpha(0.0f);
            this.emojiButton[1].setScaleX(0.1f);
            this.emojiButton[1].setScaleY(0.1f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.emojiButtonAnimation = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.emojiButton[0], (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.emojiButton[1], (Property<ImageView, Float>) View.ALPHA, 1.0f));
            this.emojiButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.52
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (animation.equals(ChatActivityEnterView.this.emojiButtonAnimation)) {
                        ChatActivityEnterView.this.emojiButtonAnimation = null;
                        ImageView imageView = ChatActivityEnterView.this.emojiButton[1];
                        ChatActivityEnterView.this.emojiButton[1] = ChatActivityEnterView.this.emojiButton[0];
                        ChatActivityEnterView.this.emojiButton[0] = imageView;
                        ChatActivityEnterView.this.emojiButton[1].setVisibility(4);
                        ChatActivityEnterView.this.emojiButton[1].setAlpha(0.0f);
                        ChatActivityEnterView.this.emojiButton[1].setScaleX(0.1f);
                        ChatActivityEnterView.this.emojiButton[1].setScaleY(0.1f);
                    }
                }
            });
            this.emojiButtonAnimation.setDuration(150L);
            this.emojiButtonAnimation.start();
        }
        onEmojiIconChanged(i);
    }

    protected void onEmojiIconChanged(int currentIcon) {
        if (currentIcon == 3 && this.emojiView == null) {
            MediaDataController.getInstance(this.currentAccount).loadRecents(0, true, true, false);
            ArrayList<String> arrayList = MessagesController.getInstance(this.currentAccount).gifSearchEmojies;
            int iMin = Math.min(10, arrayList.size());
            for (int i = 0; i < iMin; i++) {
                Emoji.preloadEmoji(arrayList.get(i));
            }
        }
    }

    public void hidePopup(boolean byBackButton) {
        if (isPopupShowing()) {
            if (this.currentPopupContentType == 1 && byBackButton && this.botButtonsMessageObject != null) {
                MessagesController.getMainSettings(this.currentAccount).edit().putInt("hidekeyboard_" + this.dialog_id, this.botButtonsMessageObject.getId()).commit();
            }
            if (byBackButton && this.searchingType != 0) {
                setSearchingTypeInternal(0, true);
                EmojiView emojiView = this.emojiView;
                if (emojiView != null) {
                    emojiView.closeSearch(true);
                }
                this.messageEditText.requestFocus();
                setStickersExpanded(false, true, false);
                if (this.emojiTabOpen) {
                    checkSendButton(true);
                    return;
                }
                return;
            }
            if (this.searchingType != 0) {
                setSearchingTypeInternal(0, false);
                this.emojiView.closeSearch(false);
                this.messageEditText.requestFocus();
            }
            showPopup(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSearchingTypeInternal(int searchingType, boolean animated) {
        final boolean z = searchingType != 0;
        if (z != (this.searchingType != 0)) {
            ValueAnimator valueAnimator = this.searchAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.searchAnimator.cancel();
            }
            if (!animated) {
                this.searchToOpenProgress = z ? 1.0f : 0.0f;
                EmojiView emojiView = this.emojiView;
                if (emojiView != null) {
                    emojiView.searchProgressChanged();
                }
            } else {
                float[] fArr = new float[2];
                fArr[0] = this.searchToOpenProgress;
                fArr[1] = z ? 1.0f : 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
                this.searchAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$iFkrLoy8m7Plcvt15VqnakIVDj4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$setSearchingTypeInternal$37$ChatActivityEnterView(valueAnimator2);
                    }
                });
                this.searchAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.53
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        ChatActivityEnterView.this.searchToOpenProgress = z ? 1.0f : 0.0f;
                        if (ChatActivityEnterView.this.emojiView != null) {
                            ChatActivityEnterView.this.emojiView.searchProgressChanged();
                        }
                    }
                });
                this.searchAnimator.setDuration(220L);
                this.searchAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.searchAnimator.start();
            }
        }
        this.searchingType = searchingType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setSearchingTypeInternal$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setSearchingTypeInternal$37$ChatActivityEnterView(ValueAnimator valueAnimator) {
        this.searchToOpenProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.searchProgressChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openKeyboardInternal() {
        ChatActivity chatActivity;
        showPopup((AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow || ((chatActivity = this.parentFragment) != null && chatActivity.isInBubbleMode()) || this.isPaused) ? 0 : 2, 0);
        this.messageEditText.requestFocus();
        AndroidUtilities.showKeyboard(this.messageEditText);
        if (this.isPaused) {
            this.showKeyboardOnResume = true;
            return;
        }
        if (AndroidUtilities.usingHardwareInput || this.keyboardVisible || AndroidUtilities.isInMultiwindow) {
            return;
        }
        ChatActivity chatActivity2 = this.parentFragment;
        if (chatActivity2 == null || !chatActivity2.isInBubbleMode()) {
            this.waitingForKeyboardOpen = true;
            EmojiView emojiView = this.emojiView;
            if (emojiView != null) {
                emojiView.onTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0f, 0.0f, 0));
            }
            AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
            AndroidUtilities.runOnUIThread(this.openKeyboardRunnable, 100L);
        }
    }

    public boolean isEditingMessage() {
        return this.editingMessageObject != null;
    }

    public MessageObject getEditingMessageObject() {
        return this.editingMessageObject;
    }

    public boolean isEditingCaption() {
        return this.editingCaption;
    }

    public boolean hasAudioToSend() {
        return (this.audioToSendMessageObject == null && this.videoToSendMessageObject == null) ? false : true;
    }

    public void openKeyboard() {
        if (AndroidUtilities.showKeyboard(this.messageEditText)) {
            return;
        }
        this.messageEditText.clearFocus();
        this.messageEditText.requestFocus();
    }

    public void closeKeyboard() {
        AndroidUtilities.hideKeyboard(this.messageEditText);
    }

    public boolean isPopupShowing() {
        return this.emojiViewVisible || this.botKeyboardViewVisible;
    }

    public boolean isKeyboardVisible() {
        return this.keyboardVisible;
    }

    public void addRecentGif(TLRPC$Document searchImage) {
        MediaDataController.getInstance(this.currentAccount).addRecentGif(searchImage, (int) (System.currentTimeMillis() / 1000));
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.addRecentGif(searchImage);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw && this.stickersExpanded) {
            setSearchingTypeInternal(0, false);
            this.emojiView.closeSearch(false);
            setStickersExpanded(false, false, false);
        }
        this.videoTimelineView.clearFrames();
    }

    public boolean isStickersExpanded() {
        return this.stickersExpanded;
    }

    @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
    public void onSizeChanged(int height, boolean isWidthGreater) {
        boolean z;
        View view;
        if (this.searchingType != 0) {
            this.lastSizeChangeValue1 = height;
            this.lastSizeChangeValue2 = isWidthGreater;
            this.keyboardVisible = height > 0;
            checkBotMenu();
            return;
        }
        if (height > AndroidUtilities.dp(50.0f) && this.keyboardVisible && !AndroidUtilities.isInMultiwindow) {
            if (isWidthGreater) {
                this.keyboardHeightLand = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height_land3", this.keyboardHeightLand).commit();
            } else {
                this.keyboardHeight = height;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height", this.keyboardHeight).commit();
            }
        }
        if (this.keyboardVisible && this.emojiViewVisible && this.emojiView == null) {
            this.emojiViewVisible = false;
        }
        if (isPopupShowing()) {
            int iMin = isWidthGreater ? this.keyboardHeightLand : this.keyboardHeight;
            if (this.currentPopupContentType == 1 && !this.botKeyboardView.isFullSize()) {
                iMin = Math.min(this.botKeyboardView.getKeyboardHeight(), iMin);
            }
            int i = this.currentPopupContentType;
            if (i == 0) {
                view = this.emojiView;
            } else {
                view = i == 1 ? this.botKeyboardView : null;
            }
            BotKeyboardView botKeyboardView = this.botKeyboardView;
            if (botKeyboardView != null) {
                botKeyboardView.setPanelHeight(iMin);
            }
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (!this.closeAnimationInProgress) {
                    int i2 = layoutParams.width;
                    int i3 = AndroidUtilities.displaySize.x;
                    if ((i2 != i3 || layoutParams.height != iMin) && !this.stickersExpanded) {
                        layoutParams.width = i3;
                        layoutParams.height = iMin;
                        view.setLayoutParams(layoutParams);
                        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
                        if (sizeNotifierFrameLayout != null) {
                            int i4 = this.emojiPadding;
                            this.emojiPadding = layoutParams.height;
                            sizeNotifierFrameLayout.requestLayout();
                            onWindowSizeChanged();
                            if (this.smoothKeyboard && !this.keyboardVisible && i4 != this.emojiPadding && pannelAnimationEnabled()) {
                                AnimatorSet animatorSet = new AnimatorSet();
                                this.panelAnimation = animatorSet;
                                animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, this.emojiPadding - i4, 0.0f));
                                this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                                this.panelAnimation.setDuration(250L);
                                this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.54
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animation) {
                                        ChatActivityEnterView.this.panelAnimation = null;
                                        if (ChatActivityEnterView.this.delegate != null) {
                                            ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(0.0f);
                                        }
                                        ChatActivityEnterView.this.requestLayout();
                                        NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                                    }
                                });
                                AndroidUtilities.runOnUIThread(this.runEmojiPanelAnimation, 50L);
                                this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                                requestLayout();
                            }
                        }
                    }
                }
            }
        }
        if (this.lastSizeChangeValue1 == height && this.lastSizeChangeValue2 == isWidthGreater) {
            onWindowSizeChanged();
            return;
        }
        this.lastSizeChangeValue1 = height;
        this.lastSizeChangeValue2 = isWidthGreater;
        boolean z2 = this.keyboardVisible;
        this.keyboardVisible = height > 0;
        checkBotMenu();
        if (this.keyboardVisible && isPopupShowing() && this.stickersExpansionAnim == null) {
            showPopup(0, this.currentPopupContentType);
        }
        if (this.emojiPadding != 0 && !(z = this.keyboardVisible) && z != z2 && !isPopupShowing()) {
            this.emojiPadding = 0;
            this.sizeNotifierLayout.requestLayout();
        }
        if (this.keyboardVisible && this.waitingForKeyboardOpen) {
            this.waitingForKeyboardOpen = false;
            if (this.clearBotButtonsOnKeyboardOpen) {
                this.clearBotButtonsOnKeyboardOpen = false;
                this.botKeyboardView.setButtons(this.botReplyMarkup);
            }
            AndroidUtilities.cancelRunOnUIThread(this.openKeyboardRunnable);
        }
        onWindowSizeChanged();
    }

    public int getEmojiPadding() {
        return this.emojiPadding;
    }

    public int getVisibleEmojiPadding() {
        if (this.emojiViewVisible) {
            return this.emojiPadding;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MessageObject getThreadMessage() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity != null) {
            return chatActivity.getThreadMessage();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThreadMessageId() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null || chatActivity.getThreadMessage() == null) {
            return 0;
        }
        return this.parentFragment.getThreadMessage().getId();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        TLRPC$ChatFull tLRPC$ChatFull;
        TLRPC$Chat chat;
        int i;
        if (id == NotificationCenter.emojiLoaded) {
            EmojiView emojiView = this.emojiView;
            if (emojiView != null) {
                emojiView.invalidateViews();
            }
            BotKeyboardView botKeyboardView = this.botKeyboardView;
            if (botKeyboardView != null) {
                botKeyboardView.invalidateViews();
            }
            EditTextCaption editTextCaption = this.messageEditText;
            if (editTextCaption != null) {
                editTextCaption.postInvalidate();
                return;
            }
            return;
        }
        if (id == NotificationCenter.recordProgressChanged) {
            if (((Integer) args[0]).intValue() != this.recordingGuid) {
                return;
            }
            if (this.recordInterfaceState != 0 && !this.wasSendTyping && !isInScheduleMode()) {
                this.wasSendTyping = true;
                MessagesController messagesController = this.accountInstance.getMessagesController();
                long j = this.dialog_id;
                int threadMessageId = getThreadMessageId();
                ImageView imageView = this.videoSendButton;
                messagesController.sendTyping(j, threadMessageId, (imageView == null || imageView.getTag() == null) ? 1 : 7, 0);
            }
            RecordCircle recordCircle = this.recordCircle;
            if (recordCircle != null) {
                recordCircle.setAmplitude(((Double) args[1]).doubleValue());
                return;
            }
            return;
        }
        if (id == NotificationCenter.closeChats) {
            EditTextCaption editTextCaption2 = this.messageEditText;
            if (editTextCaption2 == null || !editTextCaption2.isFocused()) {
                return;
            }
            AndroidUtilities.hideKeyboard(this.messageEditText);
            return;
        }
        int i2 = 4;
        if (id == NotificationCenter.recordStartError || id == NotificationCenter.recordStopped) {
            if (((Integer) args[0]).intValue() != this.recordingGuid) {
                return;
            }
            if (this.recordingAudioVideo) {
                this.recordingAudioVideo = false;
                if (id == NotificationCenter.recordStopped) {
                    Integer num = (Integer) args[1];
                    if (num.intValue() != 4) {
                        if (isInVideoMode() && num.intValue() == 5) {
                            i2 = 1;
                        } else if (num.intValue() == 0) {
                            i2 = 5;
                        } else {
                            i2 = num.intValue() == 6 ? 2 : 3;
                        }
                    }
                    if (i2 != 3) {
                        updateRecordIntefrace(i2);
                    }
                } else {
                    updateRecordIntefrace(2);
                }
            }
            if (id == NotificationCenter.recordStopped) {
                return;
            }
            return;
        }
        if (id == NotificationCenter.recordStarted) {
            if (((Integer) args[0]).intValue() != this.recordingGuid) {
                return;
            }
            boolean zBooleanValue = ((Boolean) args[1]).booleanValue();
            ImageView imageView2 = this.videoSendButton;
            if (imageView2 != null) {
                imageView2.setTag(zBooleanValue ? null : 1);
                this.videoSendButton.setVisibility(zBooleanValue ? 8 : 0);
                this.videoSendButton.setVisibility(zBooleanValue ? 0 : 8);
            }
            if (!this.recordingAudioVideo) {
                this.recordingAudioVideo = true;
                updateRecordIntefrace(0);
            } else {
                this.recordCircle.showWaves(true, true);
            }
            this.recordTimerView.start();
            this.recordDot.enterAnimation = false;
            return;
        }
        if (id == NotificationCenter.audioDidSent) {
            if (((Integer) args[0]).intValue() != this.recordingGuid) {
                return;
            }
            Object obj = args[1];
            if (obj instanceof VideoEditedInfo) {
                this.videoToSendMessageObject = (VideoEditedInfo) obj;
                String str = (String) args[2];
                this.audioToSendPath = str;
                ArrayList<Bitmap> arrayList = (ArrayList) args[3];
                this.videoTimelineView.setVideoPath(str);
                this.videoTimelineView.setKeyframes(arrayList);
                this.videoTimelineView.setVisibility(0);
                this.videoTimelineView.setMinProgressDiff(1000.0f / this.videoToSendMessageObject.estimatedDuration);
                updateRecordIntefrace(3);
                checkSendButton(false);
                return;
            }
            TLRPC$TL_document tLRPC$TL_document = (TLRPC$TL_document) args[1];
            this.audioToSend = tLRPC$TL_document;
            this.audioToSendPath = (String) args[2];
            if (tLRPC$TL_document != null) {
                if (this.recordedAudioPanel == null) {
                    return;
                }
                TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                tLRPC$TL_message.out = true;
                tLRPC$TL_message.id = 0;
                tLRPC$TL_message.peer_id = new TLRPC$TL_peerUser();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                TLRPC$Peer tLRPC$Peer = tLRPC$TL_message.peer_id;
                long clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
                tLRPC$TL_peerUser.user_id = clientUserId;
                tLRPC$Peer.user_id = clientUserId;
                tLRPC$TL_message.date = (int) (System.currentTimeMillis() / 1000);
                tLRPC$TL_message.message = "";
                tLRPC$TL_message.attachPath = this.audioToSendPath;
                TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                tLRPC$TL_message.media = tLRPC$TL_messageMediaDocument;
                tLRPC$TL_messageMediaDocument.flags |= 3;
                tLRPC$TL_messageMediaDocument.document = this.audioToSend;
                tLRPC$TL_message.flags |= 768;
                this.audioToSendMessageObject = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, false, true);
                this.recordedAudioPanel.setAlpha(1.0f);
                this.recordedAudioPanel.setVisibility(0);
                this.recordDeleteImageView.setVisibility(0);
                this.recordDeleteImageView.setAlpha(0.0f);
                this.recordDeleteImageView.setScaleY(0.0f);
                this.recordDeleteImageView.setScaleX(0.0f);
                int i3 = 0;
                while (true) {
                    if (i3 >= this.audioToSend.attributes.size()) {
                        i = 0;
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.audioToSend.attributes.get(i3);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                        i = tLRPC$DocumentAttribute.duration;
                        break;
                    }
                    i3++;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= this.audioToSend.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.audioToSend.attributes.get(i4);
                    if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                        byte[] bArr = tLRPC$DocumentAttribute2.waveform;
                        if (bArr == null || bArr.length == 0) {
                            tLRPC$DocumentAttribute2.waveform = MediaController.getInstance().getWaveform(this.audioToSendPath);
                        }
                        this.recordedAudioSeekBar.setWaveform(tLRPC$DocumentAttribute2.waveform);
                    } else {
                        i4++;
                    }
                }
                this.recordedAudioTimeTextView.setText(AndroidUtilities.formatShortDuration(i));
                checkSendButton(false);
                updateRecordIntefrace(3);
                return;
            }
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                chatActivityEnterViewDelegate.onMessageSend(null, true, 0);
                return;
            }
            return;
        }
        if (id == NotificationCenter.audioRouteChanged) {
            if (this.parentActivity != null) {
                this.parentActivity.setVolumeControlStream(((Boolean) args[0]).booleanValue() ? 0 : Integer.MIN_VALUE);
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidReset) {
            if (this.audioToSendMessageObject == null || MediaController.getInstance().isPlayingMessage(this.audioToSendMessageObject)) {
                return;
            }
            this.playPauseDrawable.setIcon(0, true);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
            this.recordedAudioSeekBar.setProgress(0.0f);
            return;
        }
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            if (this.audioToSendMessageObject == null || !MediaController.getInstance().isPlayingMessage(this.audioToSendMessageObject)) {
                return;
            }
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            MessageObject messageObject = this.audioToSendMessageObject;
            messageObject.audioProgress = playingMessageObject.audioProgress;
            messageObject.audioProgressSec = playingMessageObject.audioProgressSec;
            if (this.recordedAudioSeekBar.isDragging()) {
                return;
            }
            this.recordedAudioSeekBar.setProgress(this.audioToSendMessageObject.audioProgress);
            return;
        }
        if (id == NotificationCenter.featuredStickersDidLoad) {
            if (this.emojiButton == null) {
                return;
            }
            while (true) {
                ImageView[] imageViewArr = this.emojiButton;
                if (i >= imageViewArr.length) {
                    return;
                }
                imageViewArr[i].invalidate();
                i++;
            }
        } else {
            if (id == NotificationCenter.messageReceivedByServer) {
                if (((Boolean) args[6]).booleanValue() || ((Long) args[3]).longValue() != this.dialog_id || (tLRPC$ChatFull = this.info) == null || tLRPC$ChatFull.slowmode_seconds == 0 || (chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(this.info.id))) == null || ChatObject.hasAdminRights(chat)) {
                    return;
                }
                TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
                int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
                TLRPC$ChatFull tLRPC$ChatFull3 = this.info;
                tLRPC$ChatFull2.slowmode_next_send_date = currentTime + tLRPC$ChatFull3.slowmode_seconds;
                tLRPC$ChatFull3.flags |= 262144;
                setSlowModeTimer(tLRPC$ChatFull3.slowmode_next_send_date);
                return;
            }
            if (id == NotificationCenter.sendingMessagesChanged) {
                if (this.info != null) {
                    updateSlowModeText();
                }
            } else if (id == NotificationCenter.audioRecordTooShort) {
                updateRecordIntefrace(4);
            }
        }
    }

    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != 2 || this.pendingLocationButton == null) {
            return;
        }
        if (grantResults.length > 0 && grantResults[0] == 0) {
            SendMessagesHelper.getInstance(this.currentAccount).sendCurrentLocation(this.pendingMessageObject, this.pendingLocationButton);
        }
        this.pendingLocationButton = null;
        this.pendingMessageObject = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStickresExpandHeight() {
        if (this.emojiView == null) {
            return;
        }
        android.graphics.Point point = AndroidUtilities.displaySize;
        int i = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
        int currentActionBarHeight = (((this.originalViewHeight - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) - ActionBar.getCurrentActionBarHeight()) - getHeight()) + Theme.chat_composeShadowDrawable.getIntrinsicHeight();
        if (this.searchingType == 2) {
            currentActionBarHeight = Math.min(currentActionBarHeight, AndroidUtilities.dp(120.0f) + i);
        }
        int i2 = this.emojiView.getLayoutParams().height;
        if (i2 == currentActionBarHeight) {
            return;
        }
        Animator animator = this.stickersExpansionAnim;
        if (animator != null) {
            animator.cancel();
            this.stickersExpansionAnim = null;
        }
        this.stickersExpandedHeight = currentActionBarHeight;
        if (i2 > currentActionBarHeight) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)));
            ((ObjectAnimator) animatorSet.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$484jWb5O1UgUGMaqmFf3H0C57Ks
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$checkStickresExpandHeight$38$ChatActivityEnterView(valueAnimator);
                }
            });
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.55
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ChatActivityEnterView.this.stickersExpansionAnim = null;
                    if (ChatActivityEnterView.this.emojiView != null) {
                        ChatActivityEnterView.this.emojiView.getLayoutParams().height = ChatActivityEnterView.this.stickersExpandedHeight;
                        ChatActivityEnterView.this.emojiView.setLayerType(0, null);
                    }
                }
            });
            this.stickersExpansionAnim = animatorSet;
            this.emojiView.setLayerType(2, null);
            animatorSet.start();
            return;
        }
        this.emojiView.getLayoutParams().height = this.stickersExpandedHeight;
        this.sizeNotifierLayout.requestLayout();
        int selectionStart = this.messageEditText.getSelectionStart();
        int selectionEnd = this.messageEditText.getSelectionEnd();
        EditTextCaption editTextCaption = this.messageEditText;
        editTextCaption.setText(editTextCaption.getText());
        this.messageEditText.setSelection(selectionStart, selectionEnd);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)));
        ((ObjectAnimator) animatorSet2.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$rCcUyGyDPoEbWVWnyRBuPJtaZSE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$checkStickresExpandHeight$39$ChatActivityEnterView(valueAnimator);
            }
        });
        animatorSet2.setDuration(300L);
        animatorSet2.setInterpolator(CubicBezierInterpolator.DEFAULT);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.56
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ChatActivityEnterView.this.stickersExpansionAnim = null;
                ChatActivityEnterView.this.emojiView.setLayerType(0, null);
            }
        });
        this.stickersExpansionAnim = animatorSet2;
        this.emojiView.setLayerType(2, null);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkStickresExpandHeight$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkStickresExpandHeight$38$ChatActivityEnterView(ValueAnimator valueAnimator) {
        this.sizeNotifierLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkStickresExpandHeight$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkStickresExpandHeight$39$ChatActivityEnterView(ValueAnimator valueAnimator) {
        this.sizeNotifierLayout.invalidate();
    }

    public void setStickersExpanded(boolean expanded, boolean animated, boolean byDrag) {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if ((adjustPanLayoutHelper != null && adjustPanLayoutHelper.animationInProgress()) || this.waitingForKeyboardOpenAfterAnimation || this.emojiView == null) {
            return;
        }
        if (byDrag || this.stickersExpanded != expanded) {
            this.stickersExpanded = expanded;
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                chatActivityEnterViewDelegate.onStickersExpandedChange();
            }
            android.graphics.Point point = AndroidUtilities.displaySize;
            final int i = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
            Animator animator = this.stickersExpansionAnim;
            if (animator != null) {
                animator.cancel();
                this.stickersExpansionAnim = null;
            }
            if (this.stickersExpanded) {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 1);
                int height = this.sizeNotifierLayout.getHeight();
                this.originalViewHeight = height;
                int currentActionBarHeight = (((height - (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)) - ActionBar.getCurrentActionBarHeight()) - getHeight()) + Theme.chat_composeShadowDrawable.getIntrinsicHeight();
                this.stickersExpandedHeight = currentActionBarHeight;
                if (this.searchingType == 2) {
                    this.stickersExpandedHeight = Math.min(currentActionBarHeight, AndroidUtilities.dp(120.0f) + i);
                }
                this.emojiView.getLayoutParams().height = this.stickersExpandedHeight;
                this.sizeNotifierLayout.requestLayout();
                this.sizeNotifierLayout.setForeground(new ScrimDrawable());
                int selectionStart = this.messageEditText.getSelectionStart();
                int selectionEnd = this.messageEditText.getSelectionEnd();
                EditTextCaption editTextCaption = this.messageEditText;
                editTextCaption.setText(editTextCaption.getText());
                this.messageEditText.setSelection(selectionStart, selectionEnd);
                if (animated) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofFloat(this.stickersArrow, "animationProgress", 1.0f));
                    animatorSet.setDuration(300L);
                    animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    ((ObjectAnimator) animatorSet.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$b9aMgsTGK16z_zutUcQqrYO6Q00
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$setStickersExpanded$40$ChatActivityEnterView(i, valueAnimator);
                        }
                    });
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.57
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            ChatActivityEnterView.this.stickersExpansionAnim = null;
                            ChatActivityEnterView.this.emojiView.setLayerType(0, null);
                            NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                        }
                    });
                    this.stickersExpansionAnim = animatorSet;
                    this.emojiView.setLayerType(2, null);
                    this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                    this.stickersExpansionProgress = 0.0f;
                    this.sizeNotifierLayout.invalidate();
                    animatorSet.start();
                } else {
                    this.stickersExpansionProgress = 1.0f;
                    setTranslationY(-(this.stickersExpandedHeight - i));
                    this.emojiView.setTranslationY(-(this.stickersExpandedHeight - i));
                    this.stickersArrow.setAnimationProgress(1.0f);
                }
            } else {
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 1);
                if (animated) {
                    this.closeAnimationInProgress = true;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, 0), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, 0), ObjectAnimator.ofFloat(this.stickersArrow, "animationProgress", 0.0f));
                    animatorSet2.setDuration(300L);
                    animatorSet2.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    ((ObjectAnimator) animatorSet2.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatActivityEnterView$_h0U87DQKG-LE4Ou7m_KMET_5Z4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$setStickersExpanded$41$ChatActivityEnterView(i, valueAnimator);
                        }
                    });
                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatActivityEnterView.58
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            ChatActivityEnterView.this.closeAnimationInProgress = false;
                            ChatActivityEnterView.this.stickersExpansionAnim = null;
                            if (ChatActivityEnterView.this.emojiView != null) {
                                ChatActivityEnterView.this.emojiView.getLayoutParams().height = i;
                                ChatActivityEnterView.this.emojiView.setLayerType(0, null);
                            }
                            if (ChatActivityEnterView.this.sizeNotifierLayout != null) {
                                ChatActivityEnterView.this.sizeNotifierLayout.requestLayout();
                                ChatActivityEnterView.this.sizeNotifierLayout.setForeground(null);
                                ChatActivityEnterView.this.sizeNotifierLayout.setWillNotDraw(false);
                            }
                            if (ChatActivityEnterView.this.keyboardVisible && ChatActivityEnterView.this.isPopupShowing()) {
                                ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                                chatActivityEnterView.showPopup(0, chatActivityEnterView.currentPopupContentType);
                            }
                            NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                        }
                    });
                    this.stickersExpansionProgress = 1.0f;
                    this.sizeNotifierLayout.invalidate();
                    this.stickersExpansionAnim = animatorSet2;
                    this.emojiView.setLayerType(2, null);
                    this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
                    animatorSet2.start();
                } else {
                    this.stickersExpansionProgress = 0.0f;
                    setTranslationY(0.0f);
                    this.emojiView.setTranslationY(0.0f);
                    this.emojiView.getLayoutParams().height = i;
                    this.sizeNotifierLayout.requestLayout();
                    this.sizeNotifierLayout.setForeground(null);
                    this.sizeNotifierLayout.setWillNotDraw(false);
                    this.stickersArrow.setAnimationProgress(0.0f);
                }
            }
            if (expanded) {
                this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrCollapsePanel", R.string.AccDescrCollapsePanel));
            } else {
                this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrExpandPanel", R.string.AccDescrExpandPanel));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setStickersExpanded$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setStickersExpanded$40$ChatActivityEnterView(int i, ValueAnimator valueAnimator) {
        this.stickersExpansionProgress = Math.abs(getTranslationY() / (-(this.stickersExpandedHeight - i)));
        this.sizeNotifierLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setStickersExpanded$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setStickersExpanded$41$ChatActivityEnterView(int i, ValueAnimator valueAnimator) {
        this.stickersExpansionProgress = getTranslationY() / (-(this.stickersExpandedHeight - i));
        this.sizeNotifierLayout.invalidate();
    }

    public boolean swipeToBackEnabled() {
        FrameLayout frameLayout;
        if (this.recordingAudioVideo) {
            return false;
        }
        return this.videoSendButton == null || !isInVideoMode() || (frameLayout = this.recordedAudioPanel) == null || frameLayout.getVisibility() != 0;
    }

    public int getHeightWithTopView() {
        int measuredHeight = getMeasuredHeight();
        View view = this.topView;
        return (view == null || view.getVisibility() != 0) ? measuredHeight : (int) (measuredHeight - ((1.0f - this.topViewEnterProgress) * this.topView.getLayoutParams().height));
    }

    public void setAdjustPanLayoutHelper(AdjustPanLayoutHelper adjustPanLayoutHelper) {
        this.adjustPanLayoutHelper = adjustPanLayoutHelper;
    }

    public AdjustPanLayoutHelper getAdjustPanLayoutHelper() {
        return this.adjustPanLayoutHelper;
    }

    public boolean pannelAniamationInProgress() {
        return this.panelAnimation != null;
    }

    public float getTopViewTranslation() {
        View view = this.topView;
        if (view == null || view.getVisibility() == 8) {
            return 0.0f;
        }
        return this.topView.getTranslationY();
    }

    public int getAnimatedTop() {
        return this.animatedTop;
    }

    private class ScrimDrawable extends Drawable {
        private Paint paint;

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

        public ScrimDrawable() {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setColor(0);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (ChatActivityEnterView.this.emojiView == null) {
                return;
            }
            this.paint.setAlpha(Math.round(ChatActivityEnterView.this.stickersExpansionProgress * 102.0f));
            canvas.drawRect(0.0f, 0.0f, ChatActivityEnterView.this.getWidth(), (ChatActivityEnterView.this.emojiView.getY() - ChatActivityEnterView.this.getHeight()) + Theme.chat_composeShadowDrawable.getIntrinsicHeight(), this.paint);
        }
    }

    private class SlideTextView extends View {
        Paint arrowPaint;
        Path arrowPath;
        TextPaint bluePaint;
        float cancelAlpha;
        int cancelCharOffset;
        StaticLayout cancelLayout;
        private android.graphics.Rect cancelRect;
        String cancelString;
        float cancelToProgress;
        float cancelWidth;
        TextPaint grayPaint;
        private int lastSize;
        long lastUpdateTime;
        boolean moveForward;
        private boolean pressed;
        Drawable selectableBackground;
        float slideProgress;
        float slideToAlpha;
        String slideToCancelString;
        float slideToCancelWidth;
        StaticLayout slideToLayout;
        boolean smallSize;
        float xOffset;

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) throws InterruptedException {
            if (event.getAction() == 3 || event.getAction() == 1) {
                setPressed(false);
            }
            if (this.cancelToProgress == 0.0f || !isEnabled()) {
                return false;
            }
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (event.getAction() == 0) {
                boolean zContains = this.cancelRect.contains(x, y);
                this.pressed = zContains;
                if (zContains) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.selectableBackground.setHotspot(x, y);
                    }
                    setPressed(true);
                }
                return this.pressed;
            }
            boolean z = this.pressed;
            if (!z) {
                return z;
            }
            if (event.getAction() == 2 && !this.cancelRect.contains(x, y)) {
                setPressed(false);
                return false;
            }
            if (event.getAction() == 1 && this.cancelRect.contains(x, y)) {
                if (!ChatActivityEnterView.this.hasRecordVideo || ChatActivityEnterView.this.videoSendButton.getTag() == null) {
                    ChatActivityEnterView.this.delegate.needStartRecordAudio(0);
                    MediaController.getInstance().stopRecording(0, false, 0);
                } else {
                    CameraController.getInstance().cancelOnInitRunnable(ChatActivityEnterView.this.onFinishInitCameraRunnable);
                    ChatActivityEnterView.this.delegate.needStartRecordVideo(5, true, 0);
                }
                ChatActivityEnterView.this.recordingAudioVideo = false;
                ChatActivityEnterView.this.updateRecordIntefrace(2);
            }
            return true;
        }

        public SlideTextView(Context context) {
            super(context);
            this.arrowPaint = new Paint(1);
            this.xOffset = 0.0f;
            this.arrowPath = new Path();
            this.cancelRect = new android.graphics.Rect();
            this.smallSize = AndroidUtilities.displaySize.x <= AndroidUtilities.dp(320.0f);
            TextPaint textPaint = new TextPaint(1);
            this.grayPaint = textPaint;
            textPaint.setTextSize(AndroidUtilities.dp(this.smallSize ? 13.0f : 15.0f));
            TextPaint textPaint2 = new TextPaint(1);
            this.bluePaint = textPaint2;
            textPaint2.setTextSize(AndroidUtilities.dp(15.0f));
            this.bluePaint.setTypeface(AndroidUtilities.getFontFamily(true));
            this.arrowPaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_messagePanelIcons"));
            this.arrowPaint.setStyle(Paint.Style.STROKE);
            this.arrowPaint.setStrokeWidth(AndroidUtilities.dpf2(this.smallSize ? 1.0f : 1.6f));
            this.arrowPaint.setStrokeCap(Paint.Cap.ROUND);
            this.arrowPaint.setStrokeJoin(Paint.Join.ROUND);
            this.slideToCancelString = LocaleController.getString("SlideToCancel", R.string.SlideToCancel);
            this.slideToCancelString = this.slideToCancelString.charAt(0) + this.slideToCancelString.substring(1).toLowerCase();
            String upperCase = LocaleController.getString("Cancel", R.string.Cancel).toUpperCase();
            this.cancelString = upperCase;
            this.cancelCharOffset = this.slideToCancelString.indexOf(upperCase);
            updateColors();
        }

        public void updateColors() {
            this.grayPaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_recordTime"));
            this.bluePaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_recordVoiceCancel"));
            this.slideToAlpha = this.grayPaint.getAlpha();
            this.cancelAlpha = this.bluePaint.getAlpha();
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(60.0f), 0, ColorUtils.setAlphaComponent(ChatActivityEnterView.this.getThemedColor("chat_recordVoiceCancel"), 26));
            this.selectableBackground = drawableCreateSimpleSelectorCircleDrawable;
            drawableCreateSimpleSelectorCircleDrawable.setCallback(this);
        }

        @Override // android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            this.selectableBackground.setState(getDrawableState());
        }

        @Override // android.view.View
        public boolean verifyDrawable(Drawable drawable) {
            return this.selectableBackground == drawable || super.verifyDrawable(drawable);
        }

        @Override // android.view.View
        public void jumpDrawablesToCurrentState() {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.selectableBackground;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation"})
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
            if (this.lastSize != measuredHeight) {
                this.lastSize = measuredHeight;
                this.slideToCancelWidth = this.grayPaint.measureText(this.slideToCancelString);
                this.cancelWidth = this.bluePaint.measureText(this.cancelString);
                this.lastUpdateTime = System.currentTimeMillis();
                int measuredHeight2 = getMeasuredHeight() >> 1;
                this.arrowPath.reset();
                if (this.smallSize) {
                    float f = measuredHeight2;
                    this.arrowPath.setLastPoint(AndroidUtilities.dpf2(2.5f), f - AndroidUtilities.dpf2(3.12f));
                    this.arrowPath.lineTo(0.0f, f);
                    this.arrowPath.lineTo(AndroidUtilities.dpf2(2.5f), f + AndroidUtilities.dpf2(3.12f));
                } else {
                    float f2 = measuredHeight2;
                    this.arrowPath.setLastPoint(AndroidUtilities.dpf2(4.0f), f2 - AndroidUtilities.dpf2(5.0f));
                    this.arrowPath.lineTo(0.0f, f2);
                    this.arrowPath.lineTo(AndroidUtilities.dpf2(4.0f), f2 + AndroidUtilities.dpf2(5.0f));
                }
                this.slideToLayout = new StaticLayout(this.slideToCancelString, this.grayPaint, (int) this.slideToCancelWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.cancelLayout = new StaticLayout(this.cancelString, this.bluePaint, (int) this.cancelWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            StaticLayout staticLayout;
            if (this.slideToLayout == null || (staticLayout = this.cancelLayout) == null) {
                return;
            }
            int width = staticLayout.getWidth() + AndroidUtilities.dp(16.0f);
            this.grayPaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_recordTime"));
            this.grayPaint.setAlpha((int) (this.slideToAlpha * (1.0f - this.cancelToProgress) * this.slideProgress));
            this.bluePaint.setAlpha((int) (this.cancelAlpha * this.cancelToProgress));
            this.arrowPaint.setColor(this.grayPaint.getColor());
            if (this.smallSize) {
                this.xOffset = AndroidUtilities.dp(16.0f);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.lastUpdateTime;
                this.lastUpdateTime = System.currentTimeMillis();
                if (this.cancelToProgress == 0.0f && this.slideProgress > 0.8f) {
                    if (this.moveForward) {
                        float fDp = this.xOffset + ((AndroidUtilities.dp(3.0f) / 250.0f) * jCurrentTimeMillis);
                        this.xOffset = fDp;
                        if (fDp > AndroidUtilities.dp(6.0f)) {
                            this.xOffset = AndroidUtilities.dp(6.0f);
                            this.moveForward = false;
                        }
                    } else {
                        float fDp2 = this.xOffset - ((AndroidUtilities.dp(3.0f) / 250.0f) * jCurrentTimeMillis);
                        this.xOffset = fDp2;
                        if (fDp2 < (-AndroidUtilities.dp(6.0f))) {
                            this.xOffset = -AndroidUtilities.dp(6.0f);
                            this.moveForward = true;
                        }
                    }
                }
            }
            boolean z = this.cancelCharOffset >= 0;
            int measuredWidth = ((int) ((getMeasuredWidth() - this.slideToCancelWidth) / 2.0f)) + AndroidUtilities.dp(5.0f);
            int measuredWidth2 = (int) ((getMeasuredWidth() - this.cancelWidth) / 2.0f);
            float primaryHorizontal = z ? this.slideToLayout.getPrimaryHorizontal(this.cancelCharOffset) : 0.0f;
            float f = z ? (measuredWidth + primaryHorizontal) - measuredWidth2 : 0.0f;
            float f2 = this.xOffset;
            float f3 = this.cancelToProgress;
            float fDp3 = ((measuredWidth + ((f2 * (1.0f - f3)) * this.slideProgress)) - (f * f3)) + AndroidUtilities.dp(16.0f);
            float fDp4 = z ? 0.0f : this.cancelToProgress * AndroidUtilities.dp(12.0f);
            if (this.cancelToProgress != 1.0f) {
                int i = (int) (((-getMeasuredWidth()) / 4) * (1.0f - this.slideProgress));
                canvas.save();
                canvas.clipRect(ChatActivityEnterView.this.recordTimerView.getLeftProperty() + AndroidUtilities.dp(4.0f), 0.0f, getMeasuredWidth(), getMeasuredHeight());
                canvas.save();
                int i2 = (int) fDp3;
                canvas.translate((i2 - AndroidUtilities.dp(this.smallSize ? 7.0f : 10.0f)) + i, fDp4);
                canvas.drawPath(this.arrowPath, this.arrowPaint);
                canvas.restore();
                canvas.save();
                canvas.translate(i2 + i, ((getMeasuredHeight() - this.slideToLayout.getHeight()) / 2.0f) + fDp4);
                this.slideToLayout.draw(canvas);
                canvas.restore();
                canvas.restore();
            }
            if (this.cancelToProgress > 0.0f) {
                this.selectableBackground.setBounds((getMeasuredWidth() / 2) - width, (getMeasuredHeight() / 2) - width, (getMeasuredWidth() / 2) + width, (getMeasuredHeight() / 2) + width);
                this.selectableBackground.draw(canvas);
                float measuredHeight = (getMeasuredHeight() - this.cancelLayout.getHeight()) / 2.0f;
                if (!z) {
                    measuredHeight -= AndroidUtilities.dp(12.0f) - fDp4;
                }
                float f4 = z ? fDp3 + primaryHorizontal : measuredWidth2;
                canvas.save();
                canvas.translate(f4, measuredHeight);
                this.cancelRect.set((int) f4, (int) measuredHeight, (int) (f4 + this.cancelLayout.getWidth()), (int) (measuredHeight + this.cancelLayout.getHeight()));
                this.cancelRect.inset(-AndroidUtilities.dp(16.0f), -AndroidUtilities.dp(16.0f));
                this.cancelLayout.draw(canvas);
                canvas.restore();
            } else {
                setPressed(false);
            }
            if (this.cancelToProgress != 1.0f) {
                invalidate();
            }
        }

        @Keep
        public void setCancelToProgress(float cancelToProgress) {
            this.cancelToProgress = cancelToProgress;
        }

        @Keep
        public float getSlideToCancelWidth() {
            return this.slideToCancelWidth;
        }

        public void setSlideX(float v) {
            this.slideProgress = v;
        }
    }

    public class TimerView extends View {
        StaticLayout inLayout;
        boolean isRunning;
        long lastSendTypingTime;
        float left;
        String oldString;
        StaticLayout outLayout;
        final float replaceDistance;
        SpannableStringBuilder replaceIn;
        SpannableStringBuilder replaceOut;
        SpannableStringBuilder replaceStable;
        float replaceTransition;
        long startTime;
        long stopTime;
        boolean stoppedInternal;
        final TextPaint textPaint;

        public TimerView(Context context) {
            super(context);
            this.replaceIn = new SpannableStringBuilder();
            this.replaceOut = new SpannableStringBuilder();
            this.replaceStable = new SpannableStringBuilder();
            TextPaint textPaint = new TextPaint(1);
            this.textPaint = textPaint;
            this.replaceDistance = AndroidUtilities.dp(15.0f);
            textPaint.setTextSize(AndroidUtilities.dp(15.0f));
            textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
            updateColors();
        }

        public void start() {
            this.isRunning = true;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.startTime = jCurrentTimeMillis;
            this.lastSendTypingTime = jCurrentTimeMillis;
            invalidate();
        }

        public void stop() {
            if (this.isRunning) {
                this.isRunning = false;
                if (this.startTime > 0) {
                    this.stopTime = System.currentTimeMillis();
                }
                invalidate();
            }
            this.lastSendTypingTime = 0L;
        }

        @Override // android.view.View
        @SuppressLint({"DrawAllocation"})
        protected void onDraw(Canvas canvas) {
            String str;
            String str2;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.isRunning ? jCurrentTimeMillis - this.startTime : this.stopTime - this.startTime;
            long j2 = j / 1000;
            int i = ((int) (j % 1000)) / 10;
            if (ChatActivityEnterView.this.videoSendButton != null && ChatActivityEnterView.this.videoSendButton.getTag() != null && j >= 59500 && !this.stoppedInternal) {
                ChatActivityEnterView.this.startedDraggingX = -1.0f;
                ChatActivityEnterView.this.delegate.needStartRecordVideo(3, true, 0);
                this.stoppedInternal = true;
            }
            if (this.isRunning && jCurrentTimeMillis > this.lastSendTypingTime + 5000) {
                this.lastSendTypingTime = jCurrentTimeMillis;
                MessagesController.getInstance(ChatActivityEnterView.this.currentAccount).sendTyping(ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.getThreadMessageId(), (ChatActivityEnterView.this.videoSendButton == null || ChatActivityEnterView.this.videoSendButton.getTag() == null) ? 1 : 7, 0);
            }
            long j3 = j2 / 60;
            if (j3 >= 60) {
                str = String.format(Locale.US, "%01d:%02d:%02d,%d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60), Long.valueOf(j2 % 60), Integer.valueOf(i / 10));
            } else {
                str = String.format(Locale.US, "%01d:%02d,%d", Long.valueOf(j3), Long.valueOf(j2 % 60), Integer.valueOf(i / 10));
            }
            if (str.length() >= 3 && (str2 = this.oldString) != null && str2.length() >= 3 && str.length() == this.oldString.length() && str.charAt(str.length() - 3) != this.oldString.charAt(str.length() - 3)) {
                int length = str.length();
                this.replaceIn.clear();
                this.replaceOut.clear();
                this.replaceStable.clear();
                this.replaceIn.append((CharSequence) str);
                this.replaceOut.append((CharSequence) this.oldString);
                this.replaceStable.append((CharSequence) str);
                int i2 = -1;
                int i3 = -1;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < length - 1; i6++) {
                    if (this.oldString.charAt(i6) != str.charAt(i6)) {
                        if (i5 == 0) {
                            i3 = i6;
                        }
                        i5++;
                        if (i4 != 0) {
                            EmptyStubSpan emptyStubSpan = new EmptyStubSpan();
                            if (i6 == length - 2) {
                                i4++;
                            }
                            int i7 = i4 + i2;
                            this.replaceIn.setSpan(emptyStubSpan, i2, i7, 33);
                            this.replaceOut.setSpan(emptyStubSpan, i2, i7, 33);
                            i4 = 0;
                        }
                    } else {
                        if (i4 == 0) {
                            i2 = i6;
                        }
                        i4++;
                        if (i5 != 0) {
                            this.replaceStable.setSpan(new EmptyStubSpan(), i3, i5 + i3, 33);
                            i5 = 0;
                        }
                    }
                }
                if (i4 != 0) {
                    EmptyStubSpan emptyStubSpan2 = new EmptyStubSpan();
                    int i8 = i4 + i2 + 1;
                    this.replaceIn.setSpan(emptyStubSpan2, i2, i8, 33);
                    this.replaceOut.setSpan(emptyStubSpan2, i2, i8, 33);
                }
                if (i5 != 0) {
                    this.replaceStable.setSpan(new EmptyStubSpan(), i3, i5 + i3, 33);
                }
                this.inLayout = new StaticLayout(this.replaceIn, this.textPaint, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.outLayout = new StaticLayout(this.replaceOut, this.textPaint, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.replaceTransition = 1.0f;
            } else {
                if (this.replaceStable == null) {
                    this.replaceStable = new SpannableStringBuilder(str);
                }
                if (this.replaceStable.length() == 0 || this.replaceStable.length() != str.length()) {
                    this.replaceStable.clear();
                    this.replaceStable.append((CharSequence) str);
                } else {
                    this.replaceStable.replace(r13.length() - 1, this.replaceStable.length(), (CharSequence) str, (str.length() - 1) - (str.length() - this.replaceStable.length()), str.length());
                }
            }
            float f = this.replaceTransition;
            if (f != 0.0f) {
                float f2 = f - 0.15f;
                this.replaceTransition = f2;
                if (f2 < 0.0f) {
                    this.replaceTransition = 0.0f;
                }
            }
            float measuredHeight = getMeasuredHeight() / 2;
            if (this.replaceTransition == 0.0f) {
                this.replaceStable.clearSpans();
                StaticLayout staticLayout = new StaticLayout(this.replaceStable, this.textPaint, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                canvas.save();
                canvas.translate(0.0f, measuredHeight - (staticLayout.getHeight() / 2.0f));
                staticLayout.draw(canvas);
                canvas.restore();
                this.left = staticLayout.getLineWidth(0) + 0.0f;
            } else {
                if (this.inLayout != null) {
                    canvas.save();
                    this.textPaint.setAlpha((int) ((1.0f - this.replaceTransition) * 255.0f));
                    canvas.translate(0.0f, (measuredHeight - (this.inLayout.getHeight() / 2.0f)) - (this.replaceDistance * this.replaceTransition));
                    this.inLayout.draw(canvas);
                    canvas.restore();
                }
                if (this.outLayout != null) {
                    canvas.save();
                    this.textPaint.setAlpha((int) (this.replaceTransition * 255.0f));
                    canvas.translate(0.0f, (measuredHeight - (this.outLayout.getHeight() / 2.0f)) + (this.replaceDistance * (1.0f - this.replaceTransition)));
                    this.outLayout.draw(canvas);
                    canvas.restore();
                }
                canvas.save();
                this.textPaint.setAlpha(255);
                StaticLayout staticLayout2 = new StaticLayout(this.replaceStable, this.textPaint, getMeasuredWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                canvas.translate(0.0f, measuredHeight - (staticLayout2.getHeight() / 2.0f));
                staticLayout2.draw(canvas);
                canvas.restore();
                this.left = staticLayout2.getLineWidth(0) + 0.0f;
            }
            this.oldString = str;
            if (this.isRunning || this.replaceTransition != 0.0f) {
                invalidate();
            }
        }

        public void updateColors() {
            this.textPaint.setColor(ChatActivityEnterView.this.getThemedColor("chat_recordTime"));
        }

        public float getLeftProperty() {
            return this.left;
        }

        public void reset() {
            this.isRunning = false;
            this.startTime = 0L;
            this.stopTime = 0L;
            this.stoppedInternal = false;
        }
    }

    public RecordCircle getRecordCicle() {
        return this.recordCircle;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMax;
        LinearLayoutManager linearLayoutManager;
        int iFindFirstVisibleItemPosition;
        View viewFindViewByPosition;
        BotCommandsMenuView botCommandsMenuView = this.botCommandsMenuButton;
        if (botCommandsMenuView != null && botCommandsMenuView.getTag() != null) {
            this.botCommandsMenuButton.measure(widthMeasureSpec, heightMeasureSpec);
            int i = 0;
            while (true) {
                ImageView[] imageViewArr = this.emojiButton;
                if (i >= imageViewArr.length) {
                    break;
                }
                ((ViewGroup.MarginLayoutParams) imageViewArr[i].getLayoutParams()).leftMargin = AndroidUtilities.dp(10.0f) + this.botCommandsMenuButton.getMeasuredWidth();
                i++;
            }
            ((ViewGroup.MarginLayoutParams) this.messageEditText.getLayoutParams()).leftMargin = AndroidUtilities.dp(57.0f) + this.botCommandsMenuButton.getMeasuredWidth();
        } else {
            int i2 = 0;
            while (true) {
                ImageView[] imageViewArr2 = this.emojiButton;
                if (i2 >= imageViewArr2.length) {
                    break;
                }
                ((ViewGroup.MarginLayoutParams) imageViewArr2[i2].getLayoutParams()).leftMargin = AndroidUtilities.dp(3.0f);
                i2++;
            }
            ((ViewGroup.MarginLayoutParams) this.messageEditText.getLayoutParams()).leftMargin = AndroidUtilities.dp(50.0f);
        }
        if (this.botCommandsMenuContainer != null) {
            if (this.botCommandsAdapter.getItemCount() > 4) {
                iMax = Math.max(0, this.sizeNotifierLayout.getMeasuredHeight() - AndroidUtilities.dp(162.8f));
            } else {
                iMax = Math.max(0, this.sizeNotifierLayout.getMeasuredHeight() - AndroidUtilities.dp((Math.max(1, Math.min(4, this.botCommandsAdapter.getItemCount())) * 36) + 8));
            }
            if (this.botCommandsMenuContainer.listView.getPaddingTop() != iMax) {
                this.botCommandsMenuContainer.listView.setTopGlowOffset(iMax);
                if (this.botCommandLastPosition == -1 && this.botCommandsMenuContainer.getVisibility() == 0 && this.botCommandsMenuContainer.listView.getLayoutManager() != null && (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) this.botCommandsMenuContainer.listView.getLayoutManager()).findFirstVisibleItemPosition()) >= 0 && (viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition)) != null) {
                    this.botCommandLastPosition = iFindFirstVisibleItemPosition;
                    this.botCommandLastTop = viewFindViewByPosition.getTop() - this.botCommandsMenuContainer.listView.getPaddingTop();
                }
                this.botCommandsMenuContainer.listView.setPadding(0, iMax, 0, AndroidUtilities.dp(8.0f));
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.botCommandLastPosition != -1) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.botCommandsMenuContainer.listView.getLayoutManager();
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(this.botCommandLastPosition, this.botCommandLastTop);
            }
            this.botCommandLastPosition = -1;
        }
    }

    private void beginDelayedTransition() {
        HashMap<View, Float> map = this.animationParamsX;
        ImageView[] imageViewArr = this.emojiButton;
        map.put(imageViewArr[0], Float.valueOf(imageViewArr[0].getX()));
        HashMap<View, Float> map2 = this.animationParamsX;
        ImageView[] imageViewArr2 = this.emojiButton;
        map2.put(imageViewArr2[1], Float.valueOf(imageViewArr2[1].getX()));
        HashMap<View, Float> map3 = this.animationParamsX;
        EditTextCaption editTextCaption = this.messageEditText;
        map3.put(editTextCaption, Float.valueOf(editTextCaption.getX()));
    }

    public void setBotInfo(LongSparseArray<TLRPC$BotInfo> botInfo) {
        BotCommandsMenuView.BotCommandsAdapter botCommandsAdapter = this.botCommandsAdapter;
        if (botCommandsAdapter != null) {
            botCommandsAdapter.setBotInfo(botInfo);
        }
    }

    public boolean botCommandsMenuIsShowing() {
        BotCommandsMenuView botCommandsMenuView = this.botCommandsMenuButton;
        return botCommandsMenuView != null && botCommandsMenuView.isOpened();
    }

    public void hideBotCommands() {
        this.botCommandsMenuButton.setOpened(false);
        this.botCommandsMenuContainer.dismiss();
    }

    public void setTextTransitionIsRunning(boolean b) {
        this.textTransitionIsRunning = b;
        this.sendButtonContainer.invalidate();
    }

    public float getTopViewHeight() {
        View view = this.topView;
        if (view == null || view.getVisibility() != 0) {
            return 0.0f;
        }
        return this.topView.getLayoutParams().height;
    }

    public void runEmojiPanelAnimation() {
        AndroidUtilities.cancelRunOnUIThread(this.runEmojiPanelAnimation);
        this.runEmojiPanelAnimation.run();
    }

    public Drawable getStickersArrowDrawable() {
        return this.stickersArrow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        EmojiView emojiView = this.emojiView;
        if (emojiView == null || emojiView.getVisibility() != 0 || this.emojiView.getStickersExpandOffset() == 0.0f) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(0, AndroidUtilities.dp(2.0f), getMeasuredWidth(), getMeasuredHeight());
        canvas.translate(0.0f, -this.emojiView.getStickersExpandOffset());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
