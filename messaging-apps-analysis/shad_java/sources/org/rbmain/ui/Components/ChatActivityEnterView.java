package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
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
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.BotButtonHandler;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLog;
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
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.messenger.camera.CameraController;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$BotInlineResult;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$EncryptedChat;
import org.rbmain.tgnet.TLRPC$InputStickerSet;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$StickerSet;
import org.rbmain.tgnet.TLRPC$StickerSetCovered;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeAudio;
import org.rbmain.tgnet.TLRPC$TL_inputMessageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_keyboardButton;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonBuy;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonCallback;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonGame;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestGeoLocation;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestPhone;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonRequestPoll;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonSwitchInline;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrl;
import org.rbmain.tgnet.TLRPC$TL_keyboardButtonUrlAuth;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageEntityBold;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCode;
import org.rbmain.tgnet.TLRPC$TL_messageEntityItalic;
import org.rbmain.tgnet.TLRPC$TL_messageEntityMentionName;
import org.rbmain.tgnet.TLRPC$TL_messageEntityPre;
import org.rbmain.tgnet.TLRPC$TL_messageEntitySpoiler;
import org.rbmain.tgnet.TLRPC$TL_messageEntityStrike;
import org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl;
import org.rbmain.tgnet.TLRPC$TL_messageEntityUnderline;
import org.rbmain.tgnet.TLRPC$TL_messageMediaDocument;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWebPage;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_replyKeyboardMarkup;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EditTextCaption;
import org.rbmain.ui.Components.EmojiView;
import org.rbmain.ui.Components.SeekBar;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.Components.StickersAlert;
import org.rbmain.ui.Components.TextStyleSpan;
import org.rbmain.ui.Components.VideoTimelineView;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.GroupStickersActivity;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.StickersActivity;

/* loaded from: classes5.dex */
public class ChatActivityEnterView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate, SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate, StickersAlert.StickersAlertDelegate {
    private AccountInstance accountInstance;
    private AdjustPanLayoutHelper adjustPanLayoutHelper;
    private boolean allowGifs;
    private boolean allowShowTopView;
    private boolean allowStickers;
    protected int animatedTop;
    private int animatingContentType;
    private ImageView attachButton;
    private LinearLayout attachLayout;
    private ImageView audioSendButton;
    private TLRPC$TL_document audioToSend;
    private MessageObject audioToSendMessageObject;
    private String audioToSendPath;
    private AnimatorSet audioVideoButtonAnimation;
    private FrameLayout audioVideoButtonContainer;
    private ImageView botButton;
    private ReplaceableIconDrawable botButtonDrawablel;
    private MessageObject botButtonsMessageObject;
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
    private float chatSearchExpandOffset;
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
    private boolean editingCaption;
    private MessageObject editingMessageObject;
    private ImageView[] emojiButton;
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
    private boolean isPaste;
    private boolean isPaused;
    private int keyboardHeight;
    private int keyboardHeightLand;
    private boolean keyboardVisible;
    private int lastSizeChangeValue1;
    private boolean lastSizeChangeValue2;
    private long lastTypingTimeSend;
    private int lineCount;
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
    CrossOutDrawable notifySilentDrawable;
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
    private Property<View, Integer> roundedTranslationYProperty;
    private Runnable runEmojiPanelAnimation;
    private AnimatorSet runningAnimation;
    private AnimatorSet runningAnimation2;
    private AnimatorSet runningAnimationAudio;
    private int runningAnimationType;
    private boolean scheduleButtonHidden;
    private ImageView scheduledButton;
    private AnimatorSet scheduledButtonAnimation;
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
    private LinearLayout textFieldContainer;
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

        /* renamed from: org.rbmain.ui.Components.ChatActivityEnterView$ChatActivityEnterViewDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$bottomPanelTranslationYChanged(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate, float f) {
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

        void bottomPanelTranslationYChanged(float f);

        void didPressAttachButton();

        boolean hasScheduledMessages();

        void needChangeVideoPreviewState(int i, float f);

        void needSendTyping();

        void needShowMediaBanHint();

        void needStartRecordAudio(int i);

        void needStartRecordVideo(int i, boolean z, int i2);

        void onAttachButtonHidden();

        void onAttachButtonShow();

        void onAudioVideoInterfaceUpdated();

        void onMessageEditEnd(boolean z);

        void onMessageSend(CharSequence charSequence, boolean z, int i);

        void onPreAudioVideoRecord();

        void onStickersExpandedChange();

        void onStickersTab(boolean z);

        void onSwitchRecordMode(boolean z);

        void onTextChanged(CharSequence charSequence, boolean z);

        void onTextSelectionChanged(int i, int i2);

        void onTextSpansChanged(CharSequence charSequence);

        void onTrendingStickersShowed(boolean z);

        void onUpdateSlowModeButton(View view, boolean z, CharSequence charSequence);

        void onWindowSizeChanged(int i);

        void openScheduledMessages();

        void prepareMessageSending();

        void scrollToSendingMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$8(View view, MotionEvent motionEvent) {
        return true;
    }

    public void checkAnimation() {
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    protected void onLineCountChanged(int i, int i2) {
    }

    protected boolean pannelAnimationEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SeekBarWaveformView extends View {
        public SeekBarWaveformView(Context context) {
            super(context);
            ChatActivityEnterView.this.seekBarWaveform = new SeekBarWaveform(context);
            ChatActivityEnterView.this.seekBarWaveform.setDelegate(new SeekBar.SeekBarDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$SeekBarWaveformView$$ExternalSyntheticLambda0
                @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
                public /* synthetic */ void onSeekBarContinuousDrag(float f) {
                    SeekBar.SeekBarDelegate.CC.$default$onSeekBarContinuousDrag(this, f);
                }

                @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
                public final void onSeekBarDrag(float f) {
                    this.f$0.lambda$new$0(f);
                }

                @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
                public /* synthetic */ void onSeekBarPressed() {
                    SeekBar.SeekBarDelegate.CC.$default$onSeekBarPressed(this);
                }

                @Override // org.rbmain.ui.Components.SeekBar.SeekBarDelegate
                public /* synthetic */ void onSeekBarReleased() {
                    SeekBar.SeekBarDelegate.CC.$default$onSeekBarReleased(this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(float f) {
            if (ChatActivityEnterView.this.audioToSendMessageObject != null) {
                ChatActivityEnterView.this.audioToSendMessageObject.audioProgress = f;
                MediaController.getInstance().seekToProgress(ChatActivityEnterView.this.audioToSendMessageObject, f);
            }
        }

        public void setWaveform(byte[] bArr) {
            ChatActivityEnterView.this.seekBarWaveform.setWaveform(bArr);
            invalidate();
        }

        public void setProgress(float f) {
            ChatActivityEnterView.this.seekBarWaveform.setProgress(f);
            invalidate();
        }

        public boolean isDragging() {
            return ChatActivityEnterView.this.seekBarWaveform.isDragging();
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean zOnTouch = ChatActivityEnterView.this.seekBarWaveform.onTouch(motionEvent.getAction(), motionEvent.getX(), motionEvent.getY());
            if (zOnTouch) {
                if (motionEvent.getAction() == 0) {
                    ChatActivityEnterView.this.requestDisallowInterceptTouchEvent(true);
                }
                invalidate();
            }
            return zOnTouch || super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ChatActivityEnterView.this.seekBarWaveform.setSize(i3 - i, i4 - i2);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            SeekBarWaveform seekBarWaveform = ChatActivityEnterView.this.seekBarWaveform;
            int i = Theme.key_chat_recordedVoiceProgress;
            seekBarWaveform.setColors(Theme.getColor(i), Theme.getColor(Theme.key_chat_recordedVoiceProgressInner), Theme.getColor(i));
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
            this.drawable.setMasterParent(this);
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.attachedToWindow = false;
            this.drawable.stop();
            this.drawable.setMasterParent(this);
        }

        public RecordDot(Context context) {
            super(context);
            RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.chat_audio_record_delete, BuildConfig.FLAVOR + R.raw.chat_audio_record_delete, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(28.0f), false, null);
            this.drawable = rLottieDrawable;
            rLottieDrawable.setCurrentParentView(this);
            this.drawable.setInvalidateOnProgressSet(true);
            updateColors();
        }

        public void updateColors() {
            int color = Theme.getColor(Theme.key_chat_recordedVoiceDot);
            int color2 = Theme.getColor(Theme.key_chat_messagePanelBackground);
            ChatActivityEnterView.this.redDotPaint.setColor(color);
            this.drawable.beginApplyLayerColors();
            this.drawable.setLayerColor("Cup Red.**", color);
            this.drawable.setLayerColor("Box.**", color);
            this.drawable.setLayerColor("Line 1.**", color2);
            this.drawable.setLayerColor("Line 2.**", color2);
            this.drawable.setLayerColor("Line 3.**", color2);
            this.drawable.commitApplyLayerColors();
            if (ChatActivityEnterView.this.playPauseDrawable != null) {
                ChatActivityEnterView.this.playPauseDrawable.setColor(Theme.getColor(Theme.key_chat_recordedVoicePlayPause));
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
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
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
        float idleProgress;
        boolean incIdle;
        private float lastMovingX;
        private float lastMovingY;
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
            Drawable drawable = ChatActivityEnterView.this.micDrawable;
            int i = Theme.key_chat_messagePanelVoicePressed;
            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.cameraDrawable = getResources().getDrawable(R.drawable.input_video_pressed).mutate();
            ChatActivityEnterView.this.cameraDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.sendDrawable = getResources().getDrawable(R.drawable.attach_send).mutate();
            ChatActivityEnterView.this.sendDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.micOutline = getResources().getDrawable(R.drawable.input_mic).mutate();
            Drawable drawable2 = ChatActivityEnterView.this.micOutline;
            int i2 = Theme.key_chat_messagePanelIcons;
            drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.cameraOutline = getResources().getDrawable(R.drawable.input_video).mutate();
            ChatActivityEnterView.this.cameraOutline.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
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
            ChatActivityEnterView.this.lockShadowDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelVoiceLockShadow), PorterDuff.Mode.MULTIPLY));
            this.tooltipBackground = Theme.createRoundRectDrawable(AndroidUtilities.dp(5.0f), Theme.getColor(Theme.key_chat_gifSaveHintBackground));
            this.tooltipPaint.setTextSize(AndroidUtilities.dp(14.0f));
            this.tooltipBackgroundArrow = ContextCompat.getDrawable(context, R.drawable.tooltip_arrow);
            this.tooltipMessage = LocaleController.getString("SlideUpToLock", R.string.SlideUpToLock);
            float scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
            this.touchSlop = scaledTouchSlop;
            this.touchSlop = scaledTouchSlop * scaledTouchSlop;
            updateColors();
        }

        public void setAmplitude(double d) {
            this.bigWaveDrawable.setValue((float) (Math.min(1800.0d, d) / 1800.0d), true);
            this.tinyWaveDrawable.setValue((float) (Math.min(1800.0d, d) / 1800.0d), false);
            float fMin = (float) (Math.min(1800.0d, d) / 1800.0d);
            this.animateToAmplitude = fMin;
            this.animateAmplitudeDiff = (fMin - this.amplitude) / 375.0f;
            invalidate();
        }

        public float getScale() {
            return this.scale;
        }

        @Keep
        public void setScale(float f) {
            this.scale = f;
            invalidate();
        }

        @Keep
        public void setLockAnimatedTranslation(float f) {
            this.lockAnimatedTranslation = f;
            invalidate();
        }

        @Keep
        public void setSnapAnimationProgress(float f) {
            this.snapAnimationProgress = f;
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

        public int setLockTranslation(float f) {
            if (f == 10000.0f) {
                this.sendButtonVisible = false;
                this.lockAnimatedTranslation = -1.0f;
                this.startTranslation = -1.0f;
                invalidate();
                this.snapAnimationProgress = 0.0f;
                this.transformToSeekbar = 0.0f;
                this.exitTransition = 0.0f;
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
                this.startTranslation = f;
            }
            this.lockAnimatedTranslation = f;
            invalidate();
            if (this.canceledByGesture || this.slideToCancelProgress < 0.7f || this.startTranslation - this.lockAnimatedTranslation < AndroidUtilities.dp(57.0f)) {
                return 1;
            }
            this.sendButtonVisible = true;
            return 2;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.sendButtonVisible) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 0) {
                    boolean zContains = ChatActivityEnterView.this.pauseRect.contains(x, y);
                    this.pressed = zContains;
                    return zContains;
                }
                if (this.pressed) {
                    if (motionEvent.getAction() == 1 && ChatActivityEnterView.this.pauseRect.contains(x, y)) {
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
        protected void onMeasure(int i, int i2) {
            int iDp = AndroidUtilities.dp(194.0f);
            StaticLayout staticLayout = new StaticLayout(this.tooltipMessage, this.tooltipPaint, AndroidUtilities.dp(220.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            this.tooltipLayout = staticLayout;
            int lineCount = staticLayout.getLineCount();
            this.tooltipWidth = 0.0f;
            for (int i3 = 0; i3 < lineCount; i3++) {
                float lineWidth = this.tooltipLayout.getLineWidth(i3);
                if (lineWidth > this.tooltipWidth) {
                    this.tooltipWidth = lineWidth;
                }
            }
            if (this.tooltipLayout.getLineCount() > 1) {
                iDp += this.tooltipLayout.getHeight() - this.tooltipLayout.getLineBottom(0);
            }
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(iDp, 1073741824));
            float measuredWidth = getMeasuredWidth() * 0.35f;
            if (measuredWidth > AndroidUtilities.dp(140.0f)) {
                measuredWidth = AndroidUtilities.dp(140.0f);
            }
            this.slideDelta = (int) ((-measuredWidth) * (1.0f - this.slideToCancelProgress));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0560  */
        /* JADX WARN: Removed duplicated region for block: B:184:0x0686  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x068d  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x06ab  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x06d8  */
        /* JADX WARN: Removed duplicated region for block: B:202:0x082a  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x082f  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0843  */
        /* JADX WARN: Removed duplicated region for block: B:220:0x085d  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x0867  */
        /* JADX WARN: Removed duplicated region for block: B:228:0x0894  */
        /* JADX WARN: Removed duplicated region for block: B:231:0x098f  */
        /* JADX WARN: Removed duplicated region for block: B:234:0x099e  */
        /* JADX WARN: Removed duplicated region for block: B:240:0x0a74  */
        /* JADX WARN: Removed duplicated region for block: B:245:0x0ab0  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01b9  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void onDraw(android.graphics.Canvas r38) {
            /*
                Method dump skipped, instructions count: 2741
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatActivityEnterView.RecordCircle.onDraw(android.graphics.Canvas):void");
        }

        public void drawIcon(Canvas canvas, int i, int i2, float f) {
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
            ChatActivityEnterView.this.sendRect.set(i - (drawable3.getIntrinsicWidth() / 2), i2 - (drawable3.getIntrinsicHeight() / 2), (drawable3.getIntrinsicWidth() / 2) + i, (drawable3.getIntrinsicHeight() / 2) + i2);
            drawable3.setBounds(ChatActivityEnterView.this.sendRect);
            if (drawable4 != null) {
                drawable4.setBounds(i - (drawable4.getIntrinsicWidth() / 2), i2 - (drawable4.getIntrinsicHeight() / 2), i + (drawable4.getIntrinsicWidth() / 2), i2 + (drawable4.getIntrinsicHeight() / 2));
            }
            drawIconInternal(canvas, drawable3, drawable4, this.progressToSendButton, (int) (f * 255.0f));
        }

        private void drawIconInternal(Canvas canvas, Drawable drawable, Drawable drawable2, float f, int i) {
            if (f == 0.0f || f == 1.0f || drawable2 == null) {
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
                    drawable.setAlpha(i);
                    drawable.draw(canvas);
                    return;
                }
                Drawable drawable3 = ChatActivityEnterView.this.isInVideoMode() ? ChatActivityEnterView.this.cameraOutline : ChatActivityEnterView.this.micOutline;
                drawable3.setBounds(drawable.getBounds());
                float f2 = this.slideToCancelProgress;
                int i2 = (int) (f2 >= 0.93f ? ((f2 - 0.93f) / 0.07f) * 255.0f : 0.0f);
                drawable3.setAlpha(i2);
                drawable3.draw(canvas);
                drawable3.setAlpha(255);
                drawable.setAlpha(255 - i2);
                drawable.draw(canvas);
                return;
            }
            canvas.save();
            canvas.scale(f, f, drawable.getBounds().centerX(), drawable.getBounds().centerY());
            float f3 = i;
            drawable.setAlpha((int) (f3 * f));
            drawable.draw(canvas);
            canvas.restore();
            canvas.save();
            float f4 = 1.0f - f;
            canvas.scale(f4, f4, drawable.getBounds().centerX(), drawable.getBounds().centerY());
            drawable2.setAlpha((int) (f3 * f4));
            drawable2.draw(canvas);
            canvas.restore();
        }

        @Override // android.view.View
        protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
            return super.dispatchHoverEvent(motionEvent) || this.virtualViewHelper.dispatchHoverEvent(motionEvent);
        }

        public void setTransformToSeekbar(float f) {
            this.transformToSeekbar = f;
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
        public void setExitTransition(float f) {
            this.exitTransition = f;
            invalidate();
        }

        public void updateColors() {
            Paint paint = ChatActivityEnterView.this.paint;
            int i = Theme.key_chat_messagePanelVoiceBackground;
            paint.setColor(Theme.getColor(i));
            this.tinyWaveDrawable.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor(i), 38));
            this.bigWaveDrawable.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor(i), 76));
            this.tooltipPaint.setColor(Theme.getColor(Theme.key_chat_gifSaveHintText));
            int iDp = AndroidUtilities.dp(5.0f);
            int i2 = Theme.key_chat_gifSaveHintBackground;
            this.tooltipBackground = Theme.createRoundRectDrawable(iDp, Theme.getColor(i2));
            this.tooltipBackgroundArrow.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i2), PorterDuff.Mode.MULTIPLY));
            this.lockBackgroundPaint.setColor(Theme.getColor(Theme.key_chat_messagePanelVoiceLockBackground));
            Paint paint2 = this.lockPaint;
            int i3 = Theme.key_chat_messagePanelVoiceLock;
            paint2.setColor(Theme.getColor(i3));
            this.lockOutlinePaint.setColor(Theme.getColor(i3));
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
        public void setSlideToCancelProgress(float f) {
            this.slideToCancelProgress = f;
            float measuredWidth = getMeasuredWidth() * 0.35f;
            if (measuredWidth > AndroidUtilities.dp(140.0f)) {
                measuredWidth = AndroidUtilities.dp(140.0f);
            }
            this.slideDelta = (int) ((-measuredWidth) * (1.0f - f));
            invalidate();
        }

        public void canceledByGesture() {
            this.canceledByGesture = true;
        }

        public void setMovingCords(float f, float f2) {
            float f3 = this.lastMovingX;
            float f4 = (f - f3) * (f - f3);
            float f5 = this.lastMovingY;
            float f6 = f4 + ((f2 - f5) * (f2 - f5));
            this.lastMovingY = f2;
            this.lastMovingX = f;
            if (this.showTooltip && this.tooltipAlpha == 0.0f && f6 > this.touchSlop) {
                this.showTooltipStartTime = System.currentTimeMillis();
            }
        }

        public void showWaves(boolean z, boolean z2) {
            if (!z2) {
                this.wavesEnterAnimation = z ? 1.0f : 0.5f;
            }
            this.showWaves = z;
        }

        public void drawWaves(Canvas canvas, float f, float f2, float f3) {
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.wavesEnterAnimation);
            float f4 = this.slideToCancelProgress;
            float f5 = f4 > 0.7f ? 1.0f : f4 / 0.7f;
            canvas.save();
            float f6 = this.scale * f5 * interpolation * (BlobDrawable.SCALE_BIG_MIN + (this.bigWaveDrawable.amplitude * 1.4f)) * f3;
            canvas.scale(f6, f6, f, f2);
            BlobDrawable blobDrawable = this.bigWaveDrawable;
            blobDrawable.draw(f, f2, canvas, blobDrawable.paint);
            canvas.restore();
            float f7 = this.scale * f5 * interpolation * (BlobDrawable.SCALE_SMALL_MIN + (this.tinyWaveDrawable.amplitude * 1.4f)) * f3;
            canvas.save();
            canvas.scale(f7, f7, f, f2);
            BlobDrawable blobDrawable2 = this.tinyWaveDrawable;
            blobDrawable2.draw(f, f2, canvas, blobDrawable2.paint);
            canvas.restore();
        }

        private class VirtualViewHelper extends ExploreByTouchHelper {
            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
                return true;
            }

            public VirtualViewHelper(View view) {
                super(view);
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected int getVirtualViewAt(float f, float f2) {
                if (!RecordCircle.this.isSendButtonVisible()) {
                    return -1;
                }
                if (ChatActivityEnterView.this.sendRect.contains((int) f, (int) f2)) {
                    return 1;
                }
                return ChatActivityEnterView.this.pauseRect.contains(f, f2) ? 2 : -1;
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected void getVisibleVirtualViews(List<Integer> list) {
                if (RecordCircle.this.isSendButtonVisible()) {
                    list.add(1);
                    list.add(2);
                }
            }

            @Override // androidx.customview.widget.ExploreByTouchHelper
            protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                if (i == 1) {
                    accessibilityNodeInfoCompat.setBoundsInParent(ChatActivityEnterView.this.sendRect);
                    accessibilityNodeInfoCompat.setText(LocaleController.getString("Send", R.string.Send));
                } else if (i == 2) {
                    ChatActivityEnterView.this.rect.set((int) ChatActivityEnterView.this.pauseRect.left, (int) ChatActivityEnterView.this.pauseRect.top, (int) ChatActivityEnterView.this.pauseRect.right, (int) ChatActivityEnterView.this.pauseRect.bottom);
                    accessibilityNodeInfoCompat.setBoundsInParent(ChatActivityEnterView.this.rect);
                    accessibilityNodeInfoCompat.setText(LocaleController.getString("Stop", R.string.Stop));
                }
            }
        }
    }

    public ChatActivityEnterView(final Activity activity, SizeNotifierFrameLayout sizeNotifierFrameLayout, final ChatActivity chatActivity, boolean z) throws Resources.NotFoundException {
        int i;
        String str;
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        super(activity);
        int i2 = UserConfig.selectedAccount;
        this.currentAccount = i2;
        this.accountInstance = AccountInstance.getInstance(i2);
        this.lineCount = 1;
        this.currentLimit = -1;
        this.mediaMessageButtonsDelegate = new View.AccessibilityDelegate(this) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.1
            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName("android.widget.ImageButton");
                accessibilityNodeInfo.setClickable(true);
                accessibilityNodeInfo.setLongClickable(true);
            }
        };
        this.emojiButton = new ImageView[2];
        this.currentPopupContentType = -1;
        this.currentEmojiIcon = -1;
        this.isPaused = true;
        this.startedDraggingX = -1.0f;
        this.distCanMove = AndroidUtilities.dp(80.0f);
        this.messageWebPageSearch = true;
        this.animatingContentType = -1;
        this.doneButtonEnabledProgress = 1.0f;
        this.doneButtonEnabled = true;
        this.openKeyboardRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.2
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
        this.updateExpandabilityRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.3
            private int lastKnownPage = -1;

            @Override // java.lang.Runnable
            public void run() {
                int currentPage;
                if (ChatActivityEnterView.this.emojiView == null || (currentPage = ChatActivityEnterView.this.emojiView.getCurrentPage()) == this.lastKnownPage) {
                    return;
                }
                this.lastKnownPage = currentPage;
                boolean z2 = ChatActivityEnterView.this.stickersTabOpen;
                ChatActivityEnterView.this.stickersTabOpen = currentPage == 1 || currentPage == 2;
                boolean z3 = ChatActivityEnterView.this.emojiTabOpen;
                ChatActivityEnterView.this.emojiTabOpen = currentPage == 0;
                if (ChatActivityEnterView.this.stickersExpanded) {
                    if (ChatActivityEnterView.this.searchingType == 0) {
                        if (!ChatActivityEnterView.this.stickersTabOpen) {
                            ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                        }
                    } else {
                        ChatActivityEnterView.this.searchingType = currentPage != 0 ? 1 : 2;
                        ChatActivityEnterView.this.checkStickresExpandHeight();
                    }
                }
                if (z2 == ChatActivityEnterView.this.stickersTabOpen && z3 == ChatActivityEnterView.this.emojiTabOpen) {
                    return;
                }
                ChatActivityEnterView.this.checkSendButton(true);
            }
        };
        this.roundedTranslationYProperty = new Property<View, Integer>(this, Integer.class, "translationY") { // from class: org.rbmain.ui.Components.ChatActivityEnterView.4
            @Override // android.util.Property
            public Integer get(View view) {
                return Integer.valueOf(Math.round(view.getTranslationY()));
            }

            @Override // android.util.Property
            public void set(View view, Integer num) {
                view.setTranslationY(num.intValue());
            }
        };
        this.recordCircleScale = new Property<RecordCircle, Float>(this, Float.class, "scale") { // from class: org.rbmain.ui.Components.ChatActivityEnterView.5
            @Override // android.util.Property
            public Float get(RecordCircle recordCircle) {
                return Float.valueOf(recordCircle.getScale());
            }

            @Override // android.util.Property
            public void set(RecordCircle recordCircle, Float f) {
                recordCircle.setScale(f.floatValue());
            }
        };
        this.redDotPaint = new Paint(1);
        this.onFinishInitCameraRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.6
            @Override // java.lang.Runnable
            public void run() {
                if (ChatActivityEnterView.this.delegate != null) {
                    ChatActivityEnterView.this.delegate.needStartRecordVideo(0, true, 0);
                }
            }
        };
        this.recordAudioVideoRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.7
            @Override // java.lang.Runnable
            public void run() {
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
                    boolean z2 = ChatActivityEnterView.this.parentActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0;
                    boolean z3 = ChatActivityEnterView.this.parentActivity.checkSelfPermission("android.permission.CAMERA") == 0;
                    if (!z2 || !z3) {
                        String[] strArr = new String[(z2 || z3) ? 1 : 2];
                        if (!z2 && !z3) {
                            strArr[0] = "android.permission.RECORD_AUDIO";
                            strArr[1] = "android.permission.CAMERA";
                        } else if (!z2) {
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
        this.runEmojiPanelAnimation = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.8
            @Override // java.lang.Runnable
            public void run() {
                if (ChatActivityEnterView.this.panelAnimation == null || ChatActivityEnterView.this.panelAnimation.isRunning()) {
                    return;
                }
                ChatActivityEnterView.this.panelAnimation.start();
            }
        };
        this.topViewUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$24(valueAnimator);
            }
        };
        this.smoothKeyboard = z && SharedConfig.smoothKeyboard && !AndroidUtilities.isInMultiwindow && (chatActivity == null || !chatActivity.isInBubbleMode());
        Paint paint = new Paint(1);
        this.dotPaint = paint;
        paint.setColor(Theme.getColor(Theme.key_chat_emojiPanelNewTrending));
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
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        this.parentActivity = activity;
        this.parentFragment = chatActivity;
        if (chatActivity != null) {
            this.recordingGuid = chatActivity.getClassGuid();
        }
        this.sizeNotifierLayout = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setDelegate(this);
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        this.sendByEnter = globalMainSettings.getBoolean("send_by_enter", false);
        this.configAnimationsEnabled = globalMainSettings.getBoolean("view_animations", true);
        LinearLayout linearLayout = new LinearLayout(activity);
        this.textFieldContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.textFieldContainer.setClipChildren(false);
        this.textFieldContainer.setClipToPadding(false);
        this.textFieldContainer.setPadding(0, AndroidUtilities.dp(1.0f), 0, 0);
        addView(this.textFieldContainer, LayoutHelper.createFrame(-1, -2.0f, 83, 0.0f, 1.0f, 0.0f, 0.0f));
        FrameLayout frameLayout = new FrameLayout(activity) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.9
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
                super.onLayout(z2, i3, i4, i5, i6);
                if (ChatActivityEnterView.this.scheduledButton != null) {
                    int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp((ChatActivityEnterView.this.botButton == null || ChatActivityEnterView.this.botButton.getVisibility() != 0) ? 48.0f : 96.0f)) - AndroidUtilities.dp(48.0f);
                    ChatActivityEnterView.this.scheduledButton.layout(measuredWidth, ChatActivityEnterView.this.scheduledButton.getTop(), ChatActivityEnterView.this.scheduledButton.getMeasuredWidth() + measuredWidth, ChatActivityEnterView.this.scheduledButton.getBottom());
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (view == ChatActivityEnterView.this.messageEditText) {
                    canvas.save();
                    canvas.clipRect(0, ((-getTop()) - ChatActivityEnterView.this.textFieldContainer.getTop()) - ChatActivityEnterView.this.getTop(), getMeasuredWidth(), getMeasuredHeight() - AndroidUtilities.dp(6.0f));
                    boolean zDrawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, view, j);
            }
        };
        frameLayout.setClipChildren(false);
        this.textFieldContainer.addView(frameLayout, LayoutHelper.createLinear(0, -2, 1.0f, 80));
        int i3 = 0;
        for (int i4 = 2; i3 < i4; i4 = 2) {
            this.emojiButton[i3] = new ImageView(activity) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.10
                @Override // android.widget.ImageView, android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    if (getTag() == null || ChatActivityEnterView.this.attachLayout == null || ChatActivityEnterView.this.emojiViewVisible || MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).getUnreadStickerSets().isEmpty() || ChatActivityEnterView.this.dotPaint == null) {
                        return;
                    }
                    canvas.drawCircle((getWidth() / 2) + AndroidUtilities.dp(9.0f), (getHeight() / 2) - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(5.0f), ChatActivityEnterView.this.dotPaint);
                }
            };
            this.emojiButton[i3].setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelIcons), PorterDuff.Mode.MULTIPLY));
            this.emojiButton[i3].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            if (Build.VERSION.SDK_INT >= 21) {
                this.emojiButton[i3].setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
            }
            frameLayout.addView(this.emojiButton[i3], LayoutHelper.createFrame(48, 48.0f, 83, 3.0f, 0.0f, 0.0f, 0.0f));
            this.emojiButton[i3].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    this.f$0.lambda$new$1(view);
                }
            });
            this.emojiButton[i3].setContentDescription(LocaleController.getString("AccDescrEmojiButton", R.string.AccDescrEmojiButton));
            if (i3 == 1) {
                this.emojiButton[i3].setVisibility(4);
                this.emojiButton[i3].setAlpha(0.0f);
                this.emojiButton[i3].setScaleX(0.1f);
                this.emojiButton[i3].setScaleY(0.1f);
                ImageView imageView = this.emojiButton[i3];
            } else {
                ImageView imageView2 = this.emojiButton[i3];
            }
            i3++;
        }
        setEmojiButtonImage(false, false);
        NumberTextView numberTextView = new NumberTextView(activity);
        this.captionLimitView = numberTextView;
        numberTextView.setVisibility(8);
        this.captionLimitView.setTextSize(15);
        this.captionLimitView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
        this.captionLimitView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.captionLimitView.setCenterAlign(true);
        addView(this.captionLimitView, LayoutHelper.createFrame(48, 20.0f, 85, 3.0f, 0.0f, 0.0f, 48.0f));
        AnonymousClass11 anonymousClass11 = new AnonymousClass11(activity, null);
        this.messageEditText = anonymousClass11;
        anonymousClass11.setDelegate(new EditTextCaption.EditTextCaptionDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda37
            @Override // org.rbmain.ui.Components.EditTextCaption.EditTextCaptionDelegate
            public final void onSpansChanged() {
                this.f$0.lambda$new$2();
            }
        });
        this.messageEditText.setWindowView(this.parentActivity.getWindow().getDecorView());
        ChatActivity chatActivity2 = this.parentFragment;
        TLRPC$EncryptedChat currentEncryptedChat = chatActivity2 != null ? chatActivity2.getCurrentEncryptedChat() : null;
        this.messageEditText.setAllowTextEntitiesIntersection(supportsSendingNewEntities());
        updateFieldHint(false);
        this.messageEditText.setImeOptions(currentEncryptedChat != null ? 285212672 : 268435456);
        EditTextCaption editTextCaption = this.messageEditText;
        editTextCaption.setInputType(editTextCaption.getInputType() | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM | MessagesController.UPDATE_MASK_REORDER);
        this.messageEditText.setSingleLine(false);
        this.messageEditText.setMaxLines(6);
        this.messageEditText.setTextSize(1, 18.0f);
        this.messageEditText.setGravity(80);
        this.messageEditText.setPadding(0, AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(12.0f));
        this.messageEditText.setBackgroundDrawable(null);
        this.messageEditText.setTextColor(Theme.getColor(Theme.key_chat_messagePanelText));
        EditTextCaption editTextCaption2 = this.messageEditText;
        int i5 = Theme.key_chat_messagePanelHint;
        editTextCaption2.setHintColor(Theme.getColor(i5));
        this.messageEditText.setHintTextColor(Theme.getColor(i5));
        this.messageEditText.setCursorColor(Theme.getColor(Theme.key_chat_messagePanelCursor));
        frameLayout.addView(this.messageEditText, LayoutHelper.createFrame(-1, -2.0f, 80, 52.0f, 0.0f, z ? 50.0f : 2.0f, 0.0f));
        this.messageEditText.setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.12
            boolean ctrlPressed = false;

            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i6, KeyEvent keyEvent) throws Resources.NotFoundException {
                if (i6 == 4 && !ChatActivityEnterView.this.keyboardVisible && ChatActivityEnterView.this.isPopupShowing()) {
                    if (keyEvent.getAction() == 1) {
                        if (ChatActivityEnterView.this.currentPopupContentType == 1 && ChatActivityEnterView.this.botButtonsMessageObject != null) {
                            SharedPreferences mainSettings = MessagesController.getMainSettings(ChatActivityEnterView.this.currentAccount);
                            String dialogId = IdStorage.getInstance().getDialogId(ChatActivityEnterView.this.dialog_id);
                            String keypadStateId = IdStorage.getInstance().getKeypadStateId(ChatActivityEnterView.this.botButtonsMessageObject.getId());
                            mainSettings.edit().putString("hidekeyboard_" + dialogId, keypadStateId).apply();
                        }
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.searchingType = 0;
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
                if (i6 == 66 && ((this.ctrlPressed || ChatActivityEnterView.this.sendByEnter) && keyEvent.getAction() == 0 && ChatActivityEnterView.this.editingMessageObject == null)) {
                    ChatActivityEnterView.this.sendMessage();
                    return true;
                }
                if (i6 != 113 && i6 != 114) {
                    return false;
                }
                this.ctrlPressed = keyEvent.getAction() == 0;
                return true;
            }
        });
        this.messageEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.13
            boolean ctrlPressed = false;

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i6, KeyEvent keyEvent) {
                if (i6 == 4) {
                    ChatActivityEnterView.this.sendMessage();
                    return true;
                }
                if (keyEvent == null || i6 != 0) {
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
        if (z) {
            if (this.parentFragment != null) {
                Drawable drawableMutate = activity.getResources().getDrawable(R.drawable.input_calendar1).mutate();
                Drawable drawableMutate2 = activity.getResources().getDrawable(R.drawable.input_calendar2).mutate();
                drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelIcons), PorterDuff.Mode.MULTIPLY));
                drawableMutate2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_recordedVoiceDot), PorterDuff.Mode.MULTIPLY));
                CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableMutate2);
                ImageView imageView3 = new ImageView(activity);
                this.scheduledButton = imageView3;
                imageView3.setImageDrawable(combinedDrawable);
                this.scheduledButton.setVisibility(8);
                this.scheduledButton.setContentDescription(LocaleController.getString("ScheduledMessages", R.string.ScheduledMessages));
                this.scheduledButton.setScaleType(ImageView.ScaleType.CENTER);
                if (Build.VERSION.SDK_INT >= 21) {
                    this.scheduledButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
                }
                frameLayout.addView(this.scheduledButton, LayoutHelper.createFrame(48, 48, 85));
                this.scheduledButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda14
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$new$3(view);
                    }
                });
            }
            LinearLayout linearLayout2 = new LinearLayout(activity);
            this.attachLayout = linearLayout2;
            linearLayout2.setOrientation(0);
            this.attachLayout.setEnabled(false);
            this.attachLayout.setPivotX(AndroidUtilities.dp(48.0f));
            this.attachLayout.setClipChildren(false);
            frameLayout.addView(this.attachLayout, LayoutHelper.createFrame(-2, 48, 85));
            ImageView imageView4 = new ImageView(activity);
            this.botButton = imageView4;
            ReplaceableIconDrawable replaceableIconDrawable = new ReplaceableIconDrawable(activity);
            this.botButtonDrawablel = replaceableIconDrawable;
            imageView4.setImageDrawable(replaceableIconDrawable);
            ReplaceableIconDrawable replaceableIconDrawable2 = this.botButtonDrawablel;
            int i6 = Theme.key_chat_messagePanelIcons;
            replaceableIconDrawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i6), PorterDuff.Mode.MULTIPLY));
            this.botButtonDrawablel.setIcon(R.drawable.input_bot2, false);
            this.botButton.setScaleType(ImageView.ScaleType.CENTER);
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 21) {
                this.botButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
            }
            this.botButton.setVisibility(8);
            this.attachLayout.addView(this.botButton, LayoutHelper.createLinear(48, 48));
            this.botButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    this.f$0.lambda$new$4(view);
                }
            });
            this.notifyButton = new ImageView(activity);
            CrossOutDrawable crossOutDrawable = new CrossOutDrawable(activity, R.drawable.input_notify_on, i6);
            this.notifySilentDrawable = crossOutDrawable;
            this.notifyButton.setImageDrawable(crossOutDrawable);
            this.notifySilentDrawable.setCrossOut(this.silent, false);
            ImageView imageView5 = this.notifyButton;
            if (this.silent) {
                i = R.string.AccDescrChanSilentOn;
                str = "AccDescrChanSilentOn";
            } else {
                i = R.string.AccDescrChanSilentOff;
                str = "AccDescrChanSilentOff";
            }
            imageView5.setContentDescription(LocaleController.getString(str, i));
            this.notifyButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i6), PorterDuff.Mode.MULTIPLY));
            this.notifyButton.setScaleType(ImageView.ScaleType.CENTER);
            if (i7 >= 21) {
                this.notifyButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
            }
            this.notifyButton.setVisibility((!this.canWriteToChannel || ((chatActivityEnterViewDelegate = this.delegate) != null && chatActivityEnterViewDelegate.hasScheduledMessages())) ? 8 : 0);
            this.attachLayout.addView(this.notifyButton, LayoutHelper.createLinear(48, 48));
            this.notifyButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.15
                private Toast visibleToast;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i8;
                    String str2;
                    ChatActivityEnterView.this.silent = !r6.silent;
                    ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
                    if (chatActivityEnterView.notifySilentDrawable == null) {
                        chatActivityEnterView.notifySilentDrawable = new CrossOutDrawable(activity, R.drawable.input_notify_on, Theme.key_chat_messagePanelIcons);
                    }
                    ChatActivityEnterView chatActivityEnterView2 = ChatActivityEnterView.this;
                    chatActivityEnterView2.notifySilentDrawable.setCrossOut(chatActivityEnterView2.silent, true);
                    ChatActivityEnterView.this.notifyButton.setImageDrawable(ChatActivityEnterView.this.notifySilentDrawable);
                    String dialogId = IdStorage.getInstance().getDialogId(ChatActivityEnterView.this.dialog_id);
                    MessagesController.getNotificationsSettings(ChatActivityEnterView.this.currentAccount).edit().putBoolean("silent3_" + dialogId, ChatActivityEnterView.this.silent).apply();
                    MessagesController.getNotificationsSettings(ChatActivityEnterView.this.currentAccount).edit().putBoolean("silent3_" + ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.silent).apply();
                    try {
                        Toast toast = this.visibleToast;
                        if (toast != null) {
                            toast.cancel();
                        }
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    chatActivity.getUndoView().showWithAction(0L, !ChatActivityEnterView.this.silent ? 54 : 55, (Runnable) null);
                    ImageView imageView6 = ChatActivityEnterView.this.notifyButton;
                    if (ChatActivityEnterView.this.silent) {
                        i8 = R.string.AccDescrChanSilentOn;
                        str2 = "AccDescrChanSilentOn";
                    } else {
                        i8 = R.string.AccDescrChanSilentOff;
                        str2 = "AccDescrChanSilentOff";
                    }
                    imageView6.setContentDescription(LocaleController.getString(str2, i8));
                    ChatActivityEnterView.this.updateFieldHint(true);
                }
            });
            ImageView imageView6 = new ImageView(activity);
            this.attachButton = imageView6;
            imageView6.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i6), PorterDuff.Mode.MULTIPLY));
            this.attachButton.setImageResource(R.drawable.input_attach);
            this.attachButton.setScaleType(ImageView.ScaleType.CENTER);
            if (i7 >= 21) {
                this.attachButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
            }
            this.attachLayout.addView(this.attachButton, LayoutHelper.createLinear(48, 48));
            this.attachButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$5(view);
                }
            });
            this.attachButton.setContentDescription(LocaleController.getString("AccDescrAttachButton", R.string.AccDescrAttachButton));
        }
        FrameLayout frameLayout2 = new FrameLayout(activity);
        this.recordedAudioPanel = frameLayout2;
        frameLayout2.setVisibility(this.audioToSend == null ? 8 : 0);
        this.recordedAudioPanel.setFocusable(true);
        this.recordedAudioPanel.setFocusableInTouchMode(true);
        this.recordedAudioPanel.setClickable(true);
        frameLayout.addView(this.recordedAudioPanel, LayoutHelper.createFrame(-1, 48, 80));
        RLottieImageView rLottieImageView = new RLottieImageView(activity);
        this.recordDeleteImageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        this.recordDeleteImageView.setAnimation(R.raw.chat_audio_record_delete_2, 28, 28);
        this.recordDeleteImageView.getAnimatedDrawable().setInvalidateOnProgressSet(true);
        updateRecordedDeleteIconColors();
        this.recordDeleteImageView.setContentDescription(LocaleController.getString("Delete", R.string.Delete));
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 21) {
            this.recordDeleteImageView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
        }
        this.recordedAudioPanel.addView(this.recordDeleteImageView, LayoutHelper.createFrame(48, 48.0f));
        this.recordDeleteImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$6(view);
            }
        });
        VideoTimelineView videoTimelineView = new VideoTimelineView(activity);
        this.videoTimelineView = videoTimelineView;
        videoTimelineView.setRoundFrames(true);
        this.videoTimelineView.setDelegate(new VideoTimelineView.VideoTimelineViewDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.16
            @Override // org.rbmain.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void onLeftProgressChanged(float f) {
                if (ChatActivityEnterView.this.videoToSendMessageObject == null) {
                    return;
                }
                ChatActivityEnterView.this.videoToSendMessageObject.startTime = (long) (ChatActivityEnterView.this.videoToSendMessageObject.estimatedDuration * f);
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(2, f);
            }

            @Override // org.rbmain.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void onRightProgressChanged(float f) {
                if (ChatActivityEnterView.this.videoToSendMessageObject == null) {
                    return;
                }
                ChatActivityEnterView.this.videoToSendMessageObject.endTime = (long) (ChatActivityEnterView.this.videoToSendMessageObject.estimatedDuration * f);
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(2, f);
            }

            @Override // org.rbmain.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void didStartDragging() {
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(1, 0.0f);
            }

            @Override // org.rbmain.ui.Components.VideoTimelineView.VideoTimelineViewDelegate
            public void didStopDragging() {
                ChatActivityEnterView.this.delegate.needChangeVideoPreviewState(0, 0.0f);
            }
        });
        this.recordedAudioPanel.addView(this.videoTimelineView, LayoutHelper.createFrame(-1, -1.0f, 19, 56.0f, 0.0f, 8.0f, 0.0f));
        VideoTimelineView.TimeHintView timeHintView = new VideoTimelineView.TimeHintView(activity);
        this.videoTimelineView.setTimeHintView(timeHintView);
        this.sizeNotifierLayout.addView(timeHintView, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, 52.0f));
        View view = new View(activity);
        this.recordedAudioBackground = view;
        view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(Theme.key_chat_recordedVoiceBackground)));
        this.recordedAudioPanel.addView(this.recordedAudioBackground, LayoutHelper.createFrame(-1, 36.0f, 19, 48.0f, 0.0f, 0.0f, 0.0f));
        this.recordedAudioSeekBar = new SeekBarWaveformView(activity);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(0);
        this.recordedAudioPanel.addView(linearLayout3, LayoutHelper.createFrame(-1, 32.0f, 19, 92.0f, 0.0f, 13.0f, 0.0f));
        this.playPauseDrawable = new MediaActionDrawable();
        this.recordedAudioPlayButton = new ImageView(activity);
        Matrix matrix = new Matrix();
        matrix.postScale(0.8f, 0.8f, AndroidUtilities.dpf2(24.0f), AndroidUtilities.dpf2(24.0f));
        this.recordedAudioPlayButton.setImageMatrix(matrix);
        this.recordedAudioPlayButton.setImageDrawable(this.playPauseDrawable);
        this.recordedAudioPlayButton.setScaleType(ImageView.ScaleType.MATRIX);
        this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        this.recordedAudioPanel.addView(this.recordedAudioPlayButton, LayoutHelper.createFrame(48, 48.0f, 83, 48.0f, 0.0f, 13.0f, 0.0f));
        this.recordedAudioPlayButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$7(view2);
            }
        });
        TextView textView = new TextView(activity);
        this.recordedAudioTimeTextView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_chat_messagePanelVoiceDuration));
        this.recordedAudioTimeTextView.setTextSize(1, 13.0f);
        linearLayout3.addView(this.recordedAudioSeekBar, LayoutHelper.createLinear(0, 32, 1.0f, 16, 0, 0, 4, 0));
        linearLayout3.addView(this.recordedAudioTimeTextView, LayoutHelper.createLinear(-2, -2, 0.0f, 16));
        FrameLayout frameLayout3 = new FrameLayout(activity);
        this.recordPanel = frameLayout3;
        frameLayout3.setClipChildren(false);
        this.recordPanel.setVisibility(8);
        frameLayout.addView(this.recordPanel, LayoutHelper.createFrame(-1, 48.0f));
        this.recordPanel.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda21
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ChatActivityEnterView.lambda$new$8(view2, motionEvent);
            }
        });
        SlideTextView slideTextView = new SlideTextView(activity);
        this.slideText = slideTextView;
        this.recordPanel.addView(slideTextView, LayoutHelper.createFrame(-1, -1.0f, 0, 45.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout4 = new LinearLayout(activity);
        this.recordTimeContainer = linearLayout4;
        linearLayout4.setOrientation(0);
        this.recordTimeContainer.setPadding(AndroidUtilities.dp(13.0f), 0, 0, 0);
        this.recordPanel.addView(this.recordTimeContainer, LayoutHelper.createFrame(-1, -1, 16));
        RecordDot recordDot = new RecordDot(activity);
        this.recordDot = recordDot;
        this.recordTimeContainer.addView(recordDot, LayoutHelper.createLinear(28, 28, 16, 0, 0, 0, 0));
        TimerView timerView = new TimerView(activity);
        this.recordTimerView = timerView;
        this.recordTimeContainer.addView(timerView, LayoutHelper.createLinear(-1, -1, 16, 6, 0, 0, 0));
        FrameLayout frameLayout4 = new FrameLayout(activity) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.17
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view2, long j) {
                if (view2 == ChatActivityEnterView.this.sendButton && ChatActivityEnterView.this.textTransitionIsRunning) {
                    return true;
                }
                return super.drawChild(canvas, view2, j);
            }
        };
        this.sendButtonContainer = frameLayout4;
        frameLayout4.setClipChildren(false);
        this.sendButtonContainer.setClipToPadding(false);
        this.textFieldContainer.addView(this.sendButtonContainer, LayoutHelper.createLinear(48, 48, 80));
        FrameLayout frameLayout5 = new FrameLayout(activity);
        this.audioVideoButtonContainer = frameLayout5;
        frameLayout5.setSoundEffectsEnabled(false);
        this.sendButtonContainer.addView(this.audioVideoButtonContainer, LayoutHelper.createFrame(48, 48.0f));
        this.audioVideoButtonContainer.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda20
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.f$0.lambda$new$15(view2, motionEvent);
            }
        });
        ImageView imageView7 = new ImageView(activity);
        this.audioSendButton = imageView7;
        imageView7.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView8 = this.audioSendButton;
        int i9 = Theme.key_chat_messagePanelIcons;
        imageView8.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i9), PorterDuff.Mode.MULTIPLY));
        this.audioSendButton.setImageResource(R.drawable.input_mic);
        this.audioSendButton.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
        this.audioSendButton.setContentDescription(LocaleController.getString("AccDescrVoiceMessage", R.string.AccDescrVoiceMessage));
        this.audioSendButton.setFocusable(true);
        this.audioSendButton.setAccessibilityDelegate(this.mediaMessageButtonsDelegate);
        this.audioVideoButtonContainer.addView(this.audioSendButton, LayoutHelper.createFrame(48, 48.0f));
        if (z) {
            ImageView imageView9 = new ImageView(activity);
            this.videoSendButton = imageView9;
            imageView9.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.videoSendButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i9), PorterDuff.Mode.MULTIPLY));
            this.videoSendButton.setImageResource(R.drawable.input_video);
            this.videoSendButton.setPadding(0, 0, AndroidUtilities.dp(4.0f), 0);
            this.videoSendButton.setContentDescription(LocaleController.getString("AccDescrVideoMessage", R.string.AccDescrVideoMessage));
            this.videoSendButton.setFocusable(true);
            this.videoSendButton.setAccessibilityDelegate(this.mediaMessageButtonsDelegate);
            this.audioVideoButtonContainer.addView(this.videoSendButton, LayoutHelper.createFrame(48, 48.0f));
        }
        RecordCircle recordCircle = new RecordCircle(activity);
        this.recordCircle = recordCircle;
        recordCircle.setVisibility(8);
        this.sizeNotifierLayout.addView(this.recordCircle, LayoutHelper.createFrame(-1, -2.0f, 80, 0.0f, 0.0f, 0.0f, 0.0f));
        ImageView imageView10 = new ImageView(activity);
        this.cancelBotButton = imageView10;
        imageView10.setVisibility(4);
        this.cancelBotButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        ImageView imageView11 = this.cancelBotButton;
        CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
        this.progressDrawable = closeProgressDrawable2;
        imageView11.setImageDrawable(closeProgressDrawable2);
        this.cancelBotButton.setContentDescription(LocaleController.getString("Cancel", R.string.Cancel));
        this.progressDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelCancelInlineBot), PorterDuff.Mode.MULTIPLY));
        this.cancelBotButton.setSoundEffectsEnabled(false);
        this.cancelBotButton.setScaleX(0.1f);
        this.cancelBotButton.setScaleY(0.1f);
        this.cancelBotButton.setAlpha(0.0f);
        if (i8 >= 21) {
            this.cancelBotButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
        }
        this.sendButtonContainer.addView(this.cancelBotButton, LayoutHelper.createFrame(48, 48.0f));
        this.cancelBotButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$16(view2);
            }
        });
        if (isInScheduleMode()) {
            this.sendButtonDrawable = activity.getResources().getDrawable(R.drawable.input_schedule).mutate();
            this.sendButtonInverseDrawable = activity.getResources().getDrawable(R.drawable.input_schedule).mutate();
            this.inactinveSendButtonDrawable = activity.getResources().getDrawable(R.drawable.input_schedule).mutate();
        } else {
            this.sendButtonDrawable = activity.getResources().getDrawable(R.drawable.ic_send).mutate();
            this.sendButtonInverseDrawable = activity.getResources().getDrawable(R.drawable.ic_send).mutate();
            this.inactinveSendButtonDrawable = activity.getResources().getDrawable(R.drawable.ic_send).mutate();
        }
        View view2 = new View(activity) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.18
            private float animationDuration;
            private float animationProgress;
            private int drawableColor;
            private long lastAnimationTime;
            private int prevColorType;

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                int color;
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
                int i10 = 1;
                boolean z2 = ChatActivityEnterView.this.sendPopupWindow != null && ChatActivityEnterView.this.sendPopupWindow.isShowing();
                if (z2) {
                    color = Theme.getColor(Theme.key_chat_messagePanelVoicePressed);
                } else {
                    color = Theme.getColor(Theme.key_chat_messagePanelSend);
                    i10 = 2;
                }
                if (color != this.drawableColor) {
                    this.lastAnimationTime = SystemClock.elapsedRealtime();
                    int i11 = this.prevColorType;
                    if (i11 != 0 && i11 != i10) {
                        this.animationProgress = 0.0f;
                        if (z2) {
                            this.animationDuration = 200.0f;
                        } else {
                            this.animationDuration = 120.0f;
                        }
                    } else {
                        this.animationProgress = 1.0f;
                    }
                    this.prevColorType = i10;
                    this.drawableColor = color;
                    ChatActivityEnterView.this.sendButtonDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelSend), PorterDuff.Mode.MULTIPLY));
                    int color2 = Theme.getColor(Theme.key_chat_messagePanelIcons);
                    ChatActivityEnterView.this.inactinveSendButtonDrawable.setColorFilter(new PorterDuffColorFilter(Color.argb(180, Color.red(color2), Color.green(color2), Color.blue(color2)), PorterDuff.Mode.MULTIPLY));
                    ChatActivityEnterView.this.sendButtonInverseDrawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelVoicePressed), PorterDuff.Mode.MULTIPLY));
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
                if (!z2) {
                    if (ChatActivityEnterView.this.slowModeTimer != Integer.MAX_VALUE || ChatActivityEnterView.this.isInScheduleMode()) {
                        ChatActivityEnterView.this.sendButtonDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                        ChatActivityEnterView.this.sendButtonDrawable.draw(canvas);
                    } else {
                        ChatActivityEnterView.this.inactinveSendButtonDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                        ChatActivityEnterView.this.inactinveSendButtonDrawable.draw(canvas);
                    }
                }
                if (z2 || this.animationProgress != 1.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(Theme.getColor(Theme.key_chat_messagePanelSend));
                    int iDp2 = AndroidUtilities.dp(20.0f);
                    if (z2) {
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
                        int i12 = (int) ((1.0f - this.animationProgress) * 255.0f);
                        Theme.dialogs_onlineCirclePaint.setAlpha(i12);
                        ChatActivityEnterView.this.sendButtonInverseDrawable.setAlpha(i12);
                    }
                    canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, iDp2, Theme.dialogs_onlineCirclePaint);
                    ChatActivityEnterView.this.sendButtonInverseDrawable.setBounds(measuredWidth, measuredHeight, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicWidth() + measuredWidth, ChatActivityEnterView.this.sendButtonDrawable.getIntrinsicHeight() + measuredHeight);
                    ChatActivityEnterView.this.sendButtonInverseDrawable.draw(canvas);
                }
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (getAlpha() <= 0.0f) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.sendButton = view2;
        view2.setVisibility(4);
        int i10 = Theme.key_chat_messagePanelSend;
        int color = Theme.getColor(i10);
        this.sendButton.setContentDescription(LocaleController.getString("Send", R.string.Send));
        this.sendButton.setSoundEffectsEnabled(false);
        this.sendButton.setScaleX(0.1f);
        this.sendButton.setScaleY(0.1f);
        this.sendButton.setAlpha(0.0f);
        if (i8 >= 21) {
            this.sendButton.setBackgroundDrawable(Theme.createSelectorDrawable(Color.argb(24, Color.red(color), Color.green(color), Color.blue(color)), 1));
        }
        this.sendButtonContainer.addView(this.sendButton, LayoutHelper.createFrame(48, 48.0f));
        this.sendButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$17(view3);
            }
        });
        this.sendButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda18
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.f$0.onSendLongClick(view3);
            }
        });
        SimpleTextView simpleTextView = new SimpleTextView(activity);
        this.slowModeButton = simpleTextView;
        simpleTextView.setTextSize(18);
        this.slowModeButton.setVisibility(4);
        this.slowModeButton.setSoundEffectsEnabled(false);
        this.slowModeButton.setScaleX(0.1f);
        this.slowModeButton.setScaleY(0.1f);
        this.slowModeButton.setAlpha(0.0f);
        this.slowModeButton.setPadding(0, 0, AndroidUtilities.dp(13.0f), 0);
        this.slowModeButton.setGravity(21);
        this.slowModeButton.setTextColor(Theme.getColor(i9));
        this.sendButtonContainer.addView(this.slowModeButton, LayoutHelper.createFrame(64, 48, 53));
        this.slowModeButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$18(view3);
            }
        });
        this.slowModeButton.setOnLongClickListener(new View.OnLongClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda19
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                return this.f$0.lambda$new$19(view3);
            }
        });
        ImageView imageView12 = new ImageView(this, activity) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.19
            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (getAlpha() <= 0.0f) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.expandStickersButton = imageView12;
        imageView12.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView13 = this.expandStickersButton;
        AnimatedArrowDrawable animatedArrowDrawable = new AnimatedArrowDrawable(Theme.getColor(i9), false);
        this.stickersArrow = animatedArrowDrawable;
        imageView13.setImageDrawable(animatedArrowDrawable);
        this.expandStickersButton.setVisibility(8);
        this.expandStickersButton.setScaleX(0.1f);
        this.expandStickersButton.setScaleY(0.1f);
        this.expandStickersButton.setAlpha(0.0f);
        if (i8 >= 21) {
            this.expandStickersButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
        }
        this.sendButtonContainer.addView(this.expandStickersButton, LayoutHelper.createFrame(48, 48.0f));
        this.expandStickersButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$20(view3);
            }
        });
        this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrExpandPanel", R.string.AccDescrExpandPanel));
        FrameLayout frameLayout6 = new FrameLayout(activity);
        this.doneButtonContainer = frameLayout6;
        frameLayout6.setVisibility(8);
        this.textFieldContainer.addView(this.doneButtonContainer, LayoutHelper.createLinear(48, 48, 80));
        this.doneButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$21(view3);
            }
        });
        ShapeDrawable shapeDrawableCreateCircleDrawable = Theme.createCircleDrawable(AndroidUtilities.dp(16.0f), Theme.getColor(i10));
        Drawable drawableMutate3 = activity.getResources().getDrawable(R.drawable.input_done).mutate();
        this.doneCheckDrawable = drawableMutate3;
        drawableMutate3.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelVoicePressed), PorterDuff.Mode.MULTIPLY));
        CombinedDrawable combinedDrawable2 = new CombinedDrawable(shapeDrawableCreateCircleDrawable, drawableMutate3, 0, AndroidUtilities.dp(1.0f));
        combinedDrawable2.setCustomSize(AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
        ImageView imageView14 = new ImageView(activity);
        this.doneButtonImage = imageView14;
        imageView14.setScaleType(ImageView.ScaleType.CENTER);
        this.doneButtonImage.setImageDrawable(combinedDrawable2);
        this.doneButtonImage.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.doneButtonContainer.addView(this.doneButtonImage, LayoutHelper.createFrame(48, 48.0f));
        ContextProgressView contextProgressView = new ContextProgressView(activity, 0);
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
    public /* synthetic */ void lambda$new$1(View view) throws Resources.NotFoundException {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if (adjustPanLayoutHelper == null || !adjustPanLayoutHelper.animationInProgress()) {
            if (!isPopupShowing() || this.currentPopupContentType != 0) {
                showPopup(1, 0);
                this.emojiView.onOpen(this.messageEditText.length() > 0);
                return;
            }
            if (this.searchingType != 0) {
                this.searchingType = 0;
                EmojiView emojiView = this.emojiView;
                if (emojiView != null) {
                    emojiView.closeSearch(false);
                }
                this.messageEditText.requestFocus();
            }
            if (this.stickersExpanded) {
                setStickersExpanded(false, true, false);
                this.waitingForKeyboardOpenAfterAnimation = true;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda22
                    @Override // java.lang.Runnable
                    public final void run() throws Resources.NotFoundException {
                        this.f$0.lambda$new$0();
                    }
                }, 200L);
                return;
            }
            openKeyboardInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() throws Resources.NotFoundException {
        this.waitingForKeyboardOpenAfterAnimation = false;
        openKeyboardInternal();
    }

    /* renamed from: org.rbmain.ui.Components.ChatActivityEnterView$11, reason: invalid class name */
    class AnonymousClass11 extends EditTextCaption {
        AnonymousClass11(Context context, Theme.ResourcesProvider resourcesProvider) {
            super(context, resourcesProvider);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: send, reason: merged with bridge method [inline-methods] */
        public void lambda$onCreateInputConnection$0(InputContentInfoCompat inputContentInfoCompat, boolean z, int i) {
            inputContentInfoCompat.getDescription().hasMimeType("image/gif");
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onMessageSend(null, true, i);
            }
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            try {
                EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/gif", "image/*", "image/jpg", "image/png", "image/webp"});
                return InputConnectionCompat.createWrapper(inputConnectionOnCreateInputConnection, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$11$$ExternalSyntheticLambda0
                    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
                    public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                        return this.f$0.lambda$onCreateInputConnection$1(inputContentInfoCompat, i, bundle);
                    }
                });
            } catch (Throwable th) {
                FileLog.e(th);
                return inputConnectionOnCreateInputConnection;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateInputConnection$1(final InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
            if (BuildCompat.isAtLeastNMR1() && (i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (ChatActivityEnterView.this.isInScheduleMode()) {
                AlertsCreator.createScheduleDatePickerDialog(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$11$$ExternalSyntheticLambda2
                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                    public final void didSelectDate(boolean z, int i2) {
                        this.f$0.lambda$onCreateInputConnection$0(inputContentInfoCompat, z, i2);
                    }
                });
            } else {
                lambda$onCreateInputConnection$0(inputContentInfoCompat, true, 0);
            }
            return true;
        }

        @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (!ChatActivityEnterView.this.stickersDragging && ChatActivityEnterView.this.stickersExpansionAnim == null) {
                if (ChatActivityEnterView.this.isPopupShowing() && motionEvent.getAction() == 0) {
                    if (ChatActivityEnterView.this.searchingType != 0) {
                        ChatActivityEnterView.this.searchingType = 0;
                        ChatActivityEnterView.this.emojiView.closeSearch(false);
                    }
                    ChatActivityEnterView.this.showPopup(AndroidUtilities.usingHardwareInput ? 0 : 2, 0);
                    if (!ChatActivityEnterView.this.stickersExpanded) {
                        ChatActivityEnterView.this.openKeyboardInternal();
                    } else {
                        ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                        ChatActivityEnterView.this.waitingForKeyboardOpenAfterAnimation = true;
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$11$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() throws Resources.NotFoundException {
                                this.f$0.lambda$onTouchEvent$2();
                            }
                        }, 200L);
                    }
                }
                try {
                    return super.onTouchEvent(motionEvent);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTouchEvent$2() throws Resources.NotFoundException {
            ChatActivityEnterView.this.waitingForKeyboardOpenAfterAnimation = false;
            ChatActivityEnterView.this.openKeyboardInternal();
        }

        @Override // android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (ChatActivityEnterView.this.preventInput) {
                return false;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // org.rbmain.ui.Components.EditTextEffects, android.widget.TextView
        protected void onSelectionChanged(int i, int i2) {
            super.onSelectionChanged(i, i2);
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterView.this.delegate.onTextSelectionChanged(i, i2);
            }
        }

        @Override // org.rbmain.ui.Components.EditTextBoldCursor
        protected void extendActionMode(ActionMode actionMode, Menu menu) {
            if (ChatActivityEnterView.this.parentFragment != null) {
                ChatActivityEnterView.this.parentFragment.extendActionMode(menu);
            }
        }

        @Override // android.view.View
        public boolean requestRectangleOnScreen(android.graphics.Rect rect) {
            rect.bottom += AndroidUtilities.dp(1000.0f);
            return super.requestRectangleOnScreen(rect);
        }

        @Override // org.rbmain.ui.Components.EditTextCaption, org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
        protected void onMeasure(int i, int i2) {
            ChatActivityEnterView.this.isInitLineCount = getMeasuredWidth() == 0 && getMeasuredHeight() == 0;
            super.onMeasure(i, i2);
            if (ChatActivityEnterView.this.isInitLineCount) {
                ChatActivityEnterView.this.lineCount = getLineCount();
            }
            ChatActivityEnterView.this.isInitLineCount = false;
        }

        @Override // org.rbmain.ui.Components.EditTextCaption, android.widget.EditText, android.widget.TextView
        public boolean onTextContextMenuItem(int i) {
            if (i == 16908322) {
                ChatActivityEnterView.this.isPaste = true;
            }
            return super.onTextContextMenuItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        this.messageEditText.invalidateEffects();
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onTextSpansChanged(this.messageEditText.getText());
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatActivityEnterView$14, reason: invalid class name */
    class AnonymousClass14 implements TextWatcher {
        private boolean nextChangeIsSend;
        private boolean processChange;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        AnonymousClass14() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
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
            if (ChatActivityEnterView.this.sendByEnter && !ChatActivityEnterView.this.isPaste && ChatActivityEnterView.this.editingMessageObject == null && i3 > i2 && charSequence.length() > 0 && charSequence.length() == i + i3 && charSequence.charAt(charSequence.length() - 1) == '\n') {
                this.nextChangeIsSend = true;
            }
            ChatActivityEnterView.this.isPaste = false;
            ChatActivityEnterView.this.checkSendButton(true);
            CharSequence trimmedString = AndroidUtilities.getTrimmedString(charSequence.toString());
            if (ChatActivityEnterView.this.delegate != null && !ChatActivityEnterView.this.ignoreTextChange) {
                if (i3 > 2 || TextUtils.isEmpty(charSequence)) {
                    ChatActivityEnterView.this.messageWebPageSearch = true;
                }
                ChatActivityEnterView.this.delegate.onTextChanged(charSequence, i2 > i3 + 1 || i3 - i2 > 2);
            }
            if (ChatActivityEnterView.this.innerTextChange != 2 && i3 - i2 > 1) {
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

        /* JADX WARN: Removed duplicated region for block: B:36:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void afterTextChanged(android.text.Editable r10) {
            /*
                Method dump skipped, instructions count: 393
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatActivityEnterView.AnonymousClass14.afterTextChanged(android.text.Editable):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$afterTextChanged$0(ValueAnimator valueAnimator) {
            int color = Theme.getColor(Theme.key_chat_messagePanelVoicePressed);
            int iAlpha = Color.alpha(color);
            ChatActivityEnterView.this.doneButtonEnabledProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ChatActivityEnterView.this.doneCheckDrawable.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(color, (int) (iAlpha * ((ChatActivityEnterView.this.doneButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
            ChatActivityEnterView.this.doneButtonImage.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.openScheduledMessages();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(View view) throws Resources.NotFoundException {
        if (this.searchingType != 0) {
            this.searchingType = 0;
            this.emojiView.closeSearch(false);
            this.messageEditText.requestFocus();
        }
        if (this.botReplyMarkup != null) {
            if (!isPopupShowing() || this.currentPopupContentType != 1) {
                showPopup(1, 1);
                SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
                String dialogId = IdStorage.getInstance().getDialogId(this.dialog_id);
                mainSettings.edit().remove("hidekeyboard_" + dialogId).apply();
            } else {
                if (this.botButtonsMessageObject != null) {
                    SharedPreferences mainSettings2 = MessagesController.getMainSettings(this.currentAccount);
                    String dialogId2 = IdStorage.getInstance().getDialogId(this.dialog_id);
                    String keypadStateId = IdStorage.getInstance().getKeypadStateId(this.botButtonsMessageObject.getId());
                    mainSettings2.edit().putString("hidekeyboard_" + dialogId2, keypadStateId).apply();
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
    public /* synthetic */ void lambda$new$5(View view) {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if (adjustPanLayoutHelper == null || !adjustPanLayoutHelper.animationInProgress()) {
            this.delegate.didPressAttachButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$6(View view) {
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
    public /* synthetic */ void lambda$new$7(View view) {
        if (this.audioToSend == null) {
            return;
        }
        if (MediaController.getInstance().isPlayingMessage(this.audioToSendMessageObject) && !MediaController.getInstance().isMessagePaused()) {
            MediaController.getInstance().lambda$startAudioAgain$7(this.audioToSendMessageObject);
            this.playPauseDrawable.setIcon(0, true);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
        } else {
            this.playPauseDrawable.setIcon(1, true);
            MediaController.getInstance().playMessage(this.audioToSendMessageObject);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPause", R.string.AccActionPause));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$15(View view, MotionEvent motionEvent) {
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
                            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda34
                                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                                public final void didSelectDate(boolean z2, int i) {
                                    ChatActivityEnterView.lambda$new$9(z2, i);
                                }
                            }, new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda31
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ChatActivityEnterView.lambda$new$10();
                                }
                            }, (Theme.ResourcesProvider) null);
                        }
                        MediaController.getInstance().stopRecording(isInScheduleMode() ? 3 : 1, true, 0);
                        this.delegate.needStartRecordAudio(0);
                    }
                    this.recordingAudioVideo = false;
                    Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda23
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$11();
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
                                AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda35
                                    @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                                    public final void didSelectDate(boolean z3, int i) {
                                        ChatActivityEnterView.lambda$new$12(z3, i);
                                    }
                                }, new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda30
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        ChatActivityEnterView.lambda$new$13();
                                    }
                                }, (Theme.ResourcesProvider) null);
                            }
                            this.delegate.needStartRecordAudio(0);
                            MediaController.getInstance().stopRecording(isInScheduleMode() ? 3 : 1, true, 0);
                        }
                        this.recordingAudioVideo = false;
                        Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda24
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$new$14();
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
    public static /* synthetic */ void lambda$new$10() {
        MediaController.getInstance().stopRecording(0, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$9(boolean z, int i) {
        MediaController.getInstance().stopRecording(1, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11() {
        this.moveToSendStateRunnable = null;
        this.messageTransitionIsRunning = false;
        updateRecordIntefrace(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$12(boolean z, int i) {
        MediaController.getInstance().stopRecording(1, z, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$13() {
        MediaController.getInstance().stopRecording(0, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$14() {
        this.moveToSendStateRunnable = null;
        this.messageTransitionIsRunning = false;
        updateRecordIntefrace(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$16(View view) {
        String string = this.messageEditText.getText().toString();
        int iIndexOf = string.indexOf(32);
        if (iIndexOf == -1 || iIndexOf == string.length() - 1) {
            setFieldText(BuildConfig.FLAVOR);
        } else {
            setFieldText(string.substring(0, iIndexOf + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$17(View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.sendPopupWindow;
        if (actionBarPopupWindow == null || !actionBarPopupWindow.isShowing()) {
            AnimatorSet animatorSet = this.runningAnimationAudio;
            if (animatorSet == null || !animatorSet.isRunning()) {
                sendMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$18(View view) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            SimpleTextView simpleTextView = this.slowModeButton;
            chatActivityEnterViewDelegate.onUpdateSlowModeButton(simpleTextView, true, simpleTextView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$19(View view) {
        if (this.messageEditText.length() == 0) {
            return false;
        }
        return onSendLongClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$20(View view) {
        EmojiView emojiView;
        if (this.expandStickersButton.getVisibility() == 0 && this.expandStickersButton.getAlpha() == 1.0f && !this.waitingForKeyboardOpen) {
            if (this.keyboardVisible && this.messageEditText.isFocused()) {
                return;
            }
            if (this.stickersExpanded) {
                if (this.searchingType != 0) {
                    this.searchingType = 0;
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
    public /* synthetic */ void lambda$new$21(View view) {
        doneEditingMessage();
    }

    public ChatActivity getParentFragment() {
        return this.parentFragment;
    }

    public Editable getEditText() {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return null;
        }
        return editTextCaption.getText();
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption != null) {
            editTextCaption.addTextChangedListener(textWatcher);
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
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.topView || view == this.textFieldContainer;
        if (z) {
            canvas.save();
            if (view == this.textFieldContainer) {
                int iDp = (int) (this.animatedTop + AndroidUtilities.dp(2.0f) + this.chatSearchExpandOffset);
                View view2 = this.topView;
                if (view2 != null && view2.getVisibility() == 0) {
                    iDp += this.topView.getHeight();
                }
                canvas.clipRect(0, iDp, getMeasuredWidth(), getMeasuredHeight());
            } else {
                canvas.clipRect(0, this.animatedTop, getMeasuredWidth(), this.animatedTop + view.getLayoutParams().height + AndroidUtilities.dp(2.0f));
            }
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
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
        Theme.chat_composeShadowDrawable.setBounds(0, i, getMeasuredWidth(), Theme.chat_composeShadowDrawable.getIntrinsicHeight() + i);
        Theme.chat_composeShadowDrawable.draw(canvas);
        canvas.drawRect(0.0f, (int) (r1 + this.chatSearchExpandOffset), getWidth(), getHeight(), Theme.chat_composeBackgroundPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onSendLongClick(View view) {
        if (this.parentFragment == null) {
            return false;
        }
        isInScheduleMode();
        return false;
    }

    public boolean isSendButtonVisible() {
        return this.sendButton.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setRecordVideoButtonVisible(boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatActivityEnterView.setRecordVideoButtonVisible(boolean, boolean):void");
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

    public void showContextProgress(boolean z) {
        CloseProgressDrawable2 closeProgressDrawable2 = this.progressDrawable;
        if (closeProgressDrawable2 == null) {
            return;
        }
        if (z) {
            closeProgressDrawable2.startAnimation();
        } else {
            closeProgressDrawable2.stopAnimation();
        }
    }

    public void setCaption(String str) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption != null) {
            editTextCaption.setCaption(str);
            checkSendButton(true);
        }
    }

    public void setSlowModeTimer(int i) {
        this.slowModeTimer = i;
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
        int timeMillis = (int) (AccountInstance.getInstance(this.currentAccount).getCoreMainClass().getTimeMillis() / 1000);
        AndroidUtilities.cancelRunOnUIThread(this.updateSlowModeRunnable);
        this.updateSlowModeRunnable = null;
        TLRPC$ChatFull tLRPC$ChatFull = this.info;
        if (tLRPC$ChatFull != null && tLRPC$ChatFull.slowmode_seconds != 0 && tLRPC$ChatFull.slowmode_next_send_date <= timeMillis && ((zIsUploadingMessageIdDialog = SendMessagesHelper.getInstance(this.currentAccount).isUploadingMessageIdDialog(this.dialog_id)) || SendMessagesHelper.getInstance(this.currentAccount).isSendingMessageIdDialog(this.dialog_id))) {
            if (ChatObject.hasAdminRights(this.accountInstance.getMessagesController().getChat(Integer.valueOf(this.info.id)))) {
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
                i = i2 - timeMillis;
            }
        }
        if (this.slowModeTimer != 0 && i > 0) {
            this.slowModeButton.setText(AndroidUtilities.formatDurationNoHours(Math.max(1, i), false));
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
            if (chatActivityEnterViewDelegate != null) {
                SimpleTextView simpleTextView = this.slowModeButton;
                chatActivityEnterViewDelegate.onUpdateSlowModeButton(simpleTextView, false, simpleTextView.getText());
            }
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda25
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

    public void addTopView(View view, View view2, int i) {
        if (view == null) {
            return;
        }
        this.topLineView = view2;
        view2.setVisibility(8);
        this.topLineView.setAlpha(0.0f);
        addView(this.topLineView, LayoutHelper.createFrame(-1, 1.0f, 51, 0.0f, i + 1, 0.0f, 0.0f));
        this.topView = view;
        view.setVisibility(8);
        this.topViewEnterProgress = 0.0f;
        float f = i;
        this.topView.setTranslationY(f);
        addView(this.topView, 0, LayoutHelper.createFrame(-1, f, 51, 0.0f, 2.0f, 0.0f, 0.0f));
        this.needShowTopView = false;
    }

    public void setForceShowSendButton(boolean z, boolean z2) {
        this.forceShowSendButton = z;
        checkSendButton(z2);
    }

    public void setAllowStickersAndGifs(boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        setAllowStickersAndGifs(z, z2, z3, false);
    }

    public void setAllowStickersAndGifs(boolean z, boolean z2) throws Resources.NotFoundException {
        setAllowStickersAndGifs(z, z2, false);
    }

    public void setAllowStickersAndGifs(boolean z, boolean z2, boolean z3, boolean z4) throws Resources.NotFoundException {
        if ((this.allowStickers != z2 || this.allowGifs != z3) && this.emojiView != null) {
            if (this.emojiViewVisible && !z4) {
                this.removeEmojiViewAfterAnimation = true;
                hidePopup(false);
            } else if (z4) {
                openKeyboardInternal();
            }
        }
        this.allowStickers = z2;
        this.allowGifs = z3;
        setEmojiButtonImage(false, !this.isPaused);
    }

    public void addEmojiToRecent(String str) throws Resources.NotFoundException {
        createEmojiView();
        this.emojiView.addEmojiToRecent(str);
    }

    public void setOpenGifsTabFirst() throws Resources.NotFoundException {
        createEmojiView();
        MediaDataController.getInstance(this.currentAccount).loadRecents(0, true, true, false);
        this.emojiView.switchToGifRecent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$24(ValueAnimator valueAnimator) {
        if (this.topView != null) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.topViewEnterProgress = fFloatValue;
            this.topView.setTranslationY(this.animatedTop + ((1.0f - fFloatValue) * r0.getLayoutParams().height));
            this.topLineView.setAlpha(fFloatValue);
            this.topLineView.setTranslationY(this.animatedTop);
        }
    }

    public void showTopView(boolean z, boolean z2) {
        showTopView(z, z2, false);
    }

    private void showTopView(boolean z, boolean z2, boolean z3) {
        if (this.topView == null || this.topViewShowed || getVisibility() != 0) {
            if (this.recordedAudioPanel.getVisibility() != 0) {
                if (!this.forceShowSendButton || z2) {
                    openKeyboard();
                    return;
                }
                return;
            }
            return;
        }
        boolean z4 = this.recordedAudioPanel.getVisibility() != 0 && (!this.forceShowSendButton || z2) && (this.botReplyMarkup == null || this.editingMessageObject != null);
        if (!z3 && z && z4 && !this.keyboardVisible && !isPopupShowing()) {
            openKeyboard();
            Runnable runnable = this.showTopViewRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda26
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$showTopView$25();
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
            if (z) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.topViewEnterProgress, 1.0f);
                this.currentTopViewAnimation = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(this.topViewUpdateListener);
                this.currentTopViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.23
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 != null && valueAnimator2.equals(animator)) {
                            ChatActivityEnterView.this.currentTopViewAnimation = null;
                        }
                        NotificationCenter.getInstance(ChatActivityEnterView.this.currentAccount).onAnimationFinish(ChatActivityEnterView.this.notificationsIndex);
                    }
                });
                this.currentTopViewAnimation.setDuration(250L);
                this.currentTopViewAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.currentTopViewAnimation.start();
                this.notificationsIndex = NotificationCenter.getInstance(this.currentAccount).setAnimationInProgress(this.notificationsIndex, null);
            } else {
                this.topViewEnterProgress = 1.0f;
                this.topView.setTranslationY(0.0f);
                this.topLineView.setAlpha(1.0f);
            }
            if (z4) {
                this.messageEditText.requestFocus();
                openKeyboard();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTopView$25() {
        showTopView(true, false, true);
        this.showTopViewRunnable = null;
    }

    public void showEditDoneProgress(final boolean z, boolean z2) {
        AnimatorSet animatorSet = this.doneButtonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (z2) {
            this.doneButtonAnimation = new AnimatorSet();
            if (z) {
                this.doneButtonProgress.setVisibility(0);
                this.doneButtonContainer.setEnabled(false);
                this.doneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.doneButtonImage.setVisibility(0);
                this.doneButtonContainer.setEnabled(true);
                this.doneButtonAnimation.playTogether(ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneButtonProgress, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneButtonImage, (Property<ImageView, Float>) View.ALPHA, 1.0f));
            }
            this.doneButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.24
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (ChatActivityEnterView.this.doneButtonAnimation == null || !ChatActivityEnterView.this.doneButtonAnimation.equals(animator)) {
                        return;
                    }
                    if (!z) {
                        ChatActivityEnterView.this.doneButtonProgress.setVisibility(4);
                    } else {
                        ChatActivityEnterView.this.doneButtonImage.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (ChatActivityEnterView.this.doneButtonAnimation == null || !ChatActivityEnterView.this.doneButtonAnimation.equals(animator)) {
                        return;
                    }
                    ChatActivityEnterView.this.doneButtonAnimation = null;
                }
            });
            this.doneButtonAnimation.setDuration(150L);
            this.doneButtonAnimation.start();
            return;
        }
        if (z) {
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

    public void hideTopView(boolean z) {
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
            if (z) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.topViewEnterProgress, 0.0f);
                this.currentTopViewAnimation = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(this.topViewUpdateListener);
                this.currentTopViewAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.25
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 == null || !valueAnimator2.equals(animator)) {
                            return;
                        }
                        ChatActivityEnterView.this.topView.setVisibility(8);
                        ChatActivityEnterView.this.topLineView.setVisibility(8);
                        ChatActivityEnterView.this.resizeForTopView(false);
                        ChatActivityEnterView.this.currentTopViewAnimation = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        ValueAnimator valueAnimator2 = ChatActivityEnterView.this.currentTopViewAnimation;
                        if (valueAnimator2 == null || !valueAnimator2.equals(animator)) {
                            return;
                        }
                        ChatActivityEnterView.this.currentTopViewAnimation = null;
                    }
                });
                this.currentTopViewAnimation.setDuration(220L);
                this.currentTopViewAnimation.setStartDelay(50L);
                this.currentTopViewAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
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

    public void onAdjustPanTransitionStart(boolean z) {
        Runnable runnable;
        if (z && (runnable = this.showTopViewRunnable) != null) {
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
    public void resizeForTopView(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textFieldContainer.getLayoutParams();
        layoutParams.topMargin = AndroidUtilities.dp(2.0f) + (z ? this.topView.getLayoutParams().height : 0);
        this.textFieldContainer.setLayoutParams(layoutParams);
        setMinimumHeight(AndroidUtilities.dp(51.0f) + (z ? this.topView.getLayoutParams().height : 0));
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
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
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

    public void checkChannelRights() throws Resources.NotFoundException {
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
        Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onPause$26();
            }
        };
        this.hideKeyboardRunnable = runnable;
        AndroidUtilities.runOnUIThread(runnable, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$26() {
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
        if (this.showKeyboardOnResume) {
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
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.messageEditText.setEnabled(i == 0);
    }

    public void setDialogId(long j, int i) {
        this.dialog_id = j;
        int i2 = this.currentAccount;
        if (i2 != i) {
            NotificationCenter.getInstance(i2).onAnimationFinish(this.notificationsIndex);
            NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
            int i3 = NotificationCenter.recordStarted;
            notificationCenter.removeObserver(this, i3);
            NotificationCenter notificationCenter2 = NotificationCenter.getInstance(this.currentAccount);
            int i4 = NotificationCenter.recordStartError;
            notificationCenter2.removeObserver(this, i4);
            NotificationCenter notificationCenter3 = NotificationCenter.getInstance(this.currentAccount);
            int i5 = NotificationCenter.recordStopped;
            notificationCenter3.removeObserver(this, i5);
            NotificationCenter notificationCenter4 = NotificationCenter.getInstance(this.currentAccount);
            int i6 = NotificationCenter.recordProgressChanged;
            notificationCenter4.removeObserver(this, i6);
            NotificationCenter notificationCenter5 = NotificationCenter.getInstance(this.currentAccount);
            int i7 = NotificationCenter.closeChats;
            notificationCenter5.removeObserver(this, i7);
            NotificationCenter notificationCenter6 = NotificationCenter.getInstance(this.currentAccount);
            int i8 = NotificationCenter.audioDidSent;
            notificationCenter6.removeObserver(this, i8);
            NotificationCenter notificationCenter7 = NotificationCenter.getInstance(this.currentAccount);
            int i9 = NotificationCenter.audioRouteChanged;
            notificationCenter7.removeObserver(this, i9);
            NotificationCenter notificationCenter8 = NotificationCenter.getInstance(this.currentAccount);
            int i10 = NotificationCenter.messagePlayingDidReset;
            notificationCenter8.removeObserver(this, i10);
            NotificationCenter notificationCenter9 = NotificationCenter.getInstance(this.currentAccount);
            int i11 = NotificationCenter.messagePlayingProgressDidChanged;
            notificationCenter9.removeObserver(this, i11);
            NotificationCenter notificationCenter10 = NotificationCenter.getInstance(this.currentAccount);
            int i12 = NotificationCenter.featuredStickersDidLoad;
            notificationCenter10.removeObserver(this, i12);
            NotificationCenter notificationCenter11 = NotificationCenter.getInstance(this.currentAccount);
            int i13 = NotificationCenter.messageReceivedByServer;
            notificationCenter11.removeObserver(this, i13);
            NotificationCenter notificationCenter12 = NotificationCenter.getInstance(this.currentAccount);
            int i14 = NotificationCenter.sendingMessagesChanged;
            notificationCenter12.removeObserver(this, i14);
            this.currentAccount = i;
            this.accountInstance = AccountInstance.getInstance(i);
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
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, i14);
        }
        updateScheduleButton(false);
        checkRoundVideo();
        updateFieldHint(false);
    }

    public void setChatInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.setChatInfo(tLRPC$ChatFull);
        }
        setSlowModeTimer(tLRPC$ChatFull.slowmode_next_send_date);
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
        long j = this.dialog_id;
        int i = (int) (j >> 32);
        if (((int) j) != 0 || i == 0 || AndroidUtilities.getPeerLayerVersion(this.accountInstance.getMessagesController().getEncryptedChat(Integer.valueOf(i)).layer) >= 66) {
            this.hasRecordVideo = true;
        }
        if (((int) this.dialog_id) < 0) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-((int) this.dialog_id)));
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

    public void updateFieldHint(boolean z) {
        boolean z2;
        if (this.editingMessageObject != null) {
            this.messageEditText.setHintText(this.editingCaption ? LocaleController.getString("Caption", R.string.Caption) : LocaleController.getString("TypeMessage", R.string.TypeMessage));
            return;
        }
        boolean zShouldSendAnonymously = false;
        if (((int) this.dialog_id) < 0) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-((int) this.dialog_id)));
            if (ChatObject.isChannel(chat) && !chat.megagroup) {
                zShouldSendAnonymously = true;
            }
            boolean z3 = zShouldSendAnonymously;
            zShouldSendAnonymously = ChatObject.shouldSendAnonymously(chat);
            z2 = z3;
        } else {
            z2 = false;
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
        if (z2) {
            if (this.silent) {
                this.messageEditText.setHintText(LocaleController.getString("ChannelSilentBroadcast", R.string.ChannelSilentBroadcast), z);
                return;
            } else {
                this.messageEditText.setHintText(LocaleController.getString("ChannelBroadcast", R.string.ChannelBroadcast), z);
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
    }

    public void setWebPage(TLRPC$WebPage tLRPC$WebPage, boolean z) {
        this.messageWebPage = tLRPC$WebPage;
        this.messageWebPageSearch = z;
    }

    public boolean isMessageWebPageSearchEnabled() {
        return this.messageWebPageSearch;
    }

    private void hideRecordedAudioPanel(boolean z) {
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
            if (z) {
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
                this.recordPannelAnimation.setDuration(150L);
                this.recordPannelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.26
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
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
                animatorSet6.setDuration(150L);
                animatorSet6.setStartDelay(600L);
                AnimatorSet animatorSet7 = new AnimatorSet();
                this.recordPannelAnimation = animatorSet7;
                if (animatorSet != null) {
                    animatorSet7.playTogether(animatorSet4, animatorSet, animatorSet6);
                } else {
                    animatorSet7.playTogether(animatorSet4, animatorSet6);
                }
                this.recordPannelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.27
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
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
    public void sendMessage() {
        if (isInScheduleMode()) {
            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda32
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z, int i) {
                    this.f$0.sendMessageInternal(z, i);
                }
            });
        } else {
            sendMessageInternal(true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageInternal(boolean z, int i) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        TLRPC$Chat currentChat;
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
                String dialogId = IdStorage.getInstance().getDialogId(this.dialog_id);
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("silent3_" + dialogId, !z).apply();
                MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("silent3_" + this.dialog_id, !z).apply();
            }
        }
        if (this.stickersExpanded) {
            setStickersExpanded(false, true, false);
            if (this.searchingType != 0) {
                this.emojiView.closeSearch(false);
                this.emojiView.hideSearchKeyboard();
            }
        }
        if (this.videoToSendMessageObject != null) {
            this.delegate.needStartRecordVideo(4, z, i);
            hideRecordedAudioPanel(true);
            checkSendButton(true);
            return;
        }
        if (this.audioToSend != null) {
            MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
            if (playingMessageObject != null && playingMessageObject == this.audioToSendMessageObject) {
                MediaController.getInstance().cleanupPlayer(true, true);
            }
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.audioToSend, null, this.audioToSendPath, this.dialog_id, this.replyingMessageObject, getThreadMessage(), null, null, null, null, z, i, 0, null);
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate3 = this.delegate;
            if (chatActivityEnterViewDelegate3 != null) {
                chatActivityEnterViewDelegate3.onMessageSend(null, z, i);
            }
            hideRecordedAudioPanel(true);
            checkSendButton(true);
            return;
        }
        Editable text = this.messageEditText.getText();
        ChatActivity chatActivity2 = this.parentFragment;
        if (chatActivity2 != null && (currentChat = chatActivity2.getCurrentChat()) != null && currentChat.slowmode_enabled && !ChatObject.hasAdminRights(currentChat)) {
            if (text.length() > this.accountInstance.getMessagesController().maxMessageLength) {
                AlertsCreator.showSimpleAlert(this.parentFragment, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendErrorTooLong", R.string.SlowmodeSendErrorTooLong));
                return;
            } else if (this.forceShowSendButton && text.length() > 0) {
                AlertsCreator.showSimpleAlert(this.parentFragment, LocaleController.getString("Slowmode", R.string.Slowmode), LocaleController.getString("SlowmodeSendError", R.string.SlowmodeSendError));
                return;
            }
        }
        if (processSendingText(text, z, i)) {
            this.messageEditText.setText(BuildConfig.FLAVOR);
            this.lastTypingTimeSend = 0L;
            ChatActivityEnterViewDelegate chatActivityEnterViewDelegate4 = this.delegate;
            if (chatActivityEnterViewDelegate4 != null) {
                chatActivityEnterViewDelegate4.onMessageSend(text, z, i);
                return;
            }
            return;
        }
        if (!this.forceShowSendButton || (chatActivityEnterViewDelegate = this.delegate) == null) {
            return;
        }
        chatActivityEnterViewDelegate.onMessageSend(null, z, i);
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
        CharSequence[] charSequenceArr = {AndroidUtilities.getTrimmedString(this.messageEditText.getText())};
        ArrayList<TLRPC$MessageEntity> entities = MediaDataController.getInstance(this.currentAccount).getEntities(charSequenceArr, supportsSendingNewEntities());
        if (!TextUtils.equals(charSequenceArr[0], this.editingMessageObject.messageText) || ((entities != null && !entities.isEmpty()) || (this.editingMessageObject.messageOwner.media instanceof TLRPC$TL_messageMediaWebPage))) {
            MessageObject messageObject = this.editingMessageObject;
            messageObject.editingMessage = charSequenceArr[0];
            messageObject.editingMessageEntities = entities;
            messageObject.editingMessageSearchWebPage = this.messageWebPageSearch;
            SendMessagesHelper.getInstance(this.currentAccount).editMessage(this.editingMessageObject, null, null, null, null, null, false, null);
        }
        setEditingMessageObject(null, false);
    }

    public boolean processSendingText(CharSequence charSequence, boolean z, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        ChatActivity chatActivity;
        CharSequence trimmedString = AndroidUtilities.getTrimmedString(charSequence);
        boolean zSupportsSendingNewEntities = supportsSendingNewEntities();
        int i6 = this.accountInstance.getMessagesController().maxMessageLength;
        char c = 0;
        if (trimmedString.length() == 0) {
            return false;
        }
        if (this.delegate != null && (chatActivity = this.parentFragment) != null) {
            if ((i != 0) == chatActivity.isInScheduleMode()) {
                this.delegate.prepareMessageSending();
            }
        }
        int i7 = 0;
        while (true) {
            int i8 = i7 + i6;
            if (trimmedString.length() > i8) {
                int i9 = i8 - 1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                for (int i10 = 0; i9 > i7 && i10 < 300; i10++) {
                    char cCharAt = trimmedString.charAt(i9);
                    char cCharAt2 = i9 > 0 ? trimmedString.charAt(i9 - 1) : ' ';
                    if (cCharAt == '\n' && cCharAt2 == '\n') {
                        i2 = i9;
                        break;
                    }
                    if (cCharAt == '\n') {
                        i5 = i9;
                    } else if (i3 < 0 && Character.isWhitespace(cCharAt) && cCharAt2 == '.') {
                        i3 = i9;
                    } else if (i4 < 0 && Character.isWhitespace(cCharAt)) {
                        i4 = i9;
                    }
                    i9--;
                }
                i2 = -1;
            } else {
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
            }
            int iMin = i2 > 0 ? i2 : i5 > 0 ? i5 : i3 > 0 ? i3 : i4 > 0 ? i4 : Math.min(i8, trimmedString.length());
            CharSequence[] charSequenceArr = new CharSequence[1];
            charSequenceArr[c] = AndroidUtilities.getTrimmedString(trimmedString.subSequence(i7, iMin));
            int i11 = iMin;
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(charSequenceArr[c].toString(), this.dialog_id, this.replyingMessageObject, getThreadMessage(), this.messageWebPage, this.messageWebPageSearch, MediaDataController.getInstance(this.currentAccount).getEntities(charSequenceArr, zSupportsSendingNewEntities), (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, z, i);
            i7 = i11 + 1;
            if (i11 == trimmedString.length()) {
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
    public void checkSendButton(boolean z) {
        int color;
        int i;
        if (this.editingMessageObject != null || this.recordingAudioVideo) {
            return;
        }
        boolean z2 = this.isPaused ? false : z;
        CharSequence trimmedString = AndroidUtilities.getTrimmedString(this.messageEditText.getText());
        int i2 = this.slowModeTimer;
        if (i2 > 0 && i2 != Integer.MAX_VALUE && !isInScheduleMode()) {
            if (this.slowModeButton.getVisibility() != 0) {
                if (z2) {
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
                        boolean z3 = chatActivityEnterViewDelegate != null && chatActivityEnterViewDelegate.hasScheduledMessages();
                        ImageView imageView = this.scheduledButton;
                        if (imageView != null) {
                            imageView.setScaleY(1.0f);
                            if (z3) {
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
                        this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.28
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                    ChatActivityEnterView.this.attachLayout.setVisibility(8);
                                    ChatActivityEnterView.this.runningAnimation2 = null;
                                }
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
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
                    this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.29
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
                                ChatActivityEnterView.this.sendButton.setVisibility(8);
                                ChatActivityEnterView.this.cancelBotButton.setVisibility(8);
                                ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(8);
                                ChatActivityEnterView.this.expandStickersButton.setVisibility(8);
                                ChatActivityEnterView.this.runningAnimation = null;
                                ChatActivityEnterView.this.runningAnimationType = 0;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
            boolean z4 = caption != null && (this.sendButton.getVisibility() == 0 || this.expandStickersButton.getVisibility() == 0);
            boolean z5 = caption == null && (this.cancelBotButton.getVisibility() == 0 || this.expandStickersButton.getVisibility() == 0);
            if (this.slowModeTimer == Integer.MAX_VALUE && !isInScheduleMode()) {
                color = Theme.getColor(Theme.key_chat_messagePanelIcons);
            } else {
                color = Theme.getColor(Theme.key_chat_messagePanelSend);
            }
            Theme.setSelectorDrawableColor(this.sendButton.getBackground(), Color.argb(24, Color.red(color), Color.green(color), Color.blue(color)), true);
            if (this.audioVideoButtonContainer.getVisibility() == 0 || this.slowModeButton.getVisibility() == 0 || z4 || z5) {
                if (z2) {
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
                            final boolean z6 = chatActivityEnterViewDelegate3 != null && chatActivityEnterViewDelegate3.hasScheduledMessages();
                            this.scheduleButtonHidden = true;
                            ImageView imageView8 = this.scheduledButton;
                            if (imageView8 != null) {
                                imageView8.setScaleY(1.0f);
                                if (z6) {
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
                            this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.30
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                        ChatActivityEnterView.this.attachLayout.setVisibility(8);
                                        if (z6) {
                                            ChatActivityEnterView.this.scheduledButton.setVisibility(8);
                                        }
                                        ChatActivityEnterView.this.runningAnimation2 = null;
                                    }
                                }

                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationCancel(Animator animator) {
                                    if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
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
                        if (z4) {
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_X, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.SCALE_Y, 0.1f));
                            arrayList4.add(ObjectAnimator.ofFloat(this.sendButton, (Property<View, Float>) View.ALPHA, 0.0f));
                        } else if (z5) {
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
                        this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.31
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
                            public void onAnimationCancel(Animator animator) {
                                if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
            if (z2) {
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
                    boolean z7 = chatActivityEnterViewDelegate5 != null && chatActivityEnterViewDelegate5.hasScheduledMessages();
                    this.scheduleButtonHidden = false;
                    ImageView imageView15 = this.scheduledButton;
                    if (imageView15 != null) {
                        imageView15.setScaleY(1.0f);
                        if (z7) {
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
                    this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.32
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
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
                this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.33
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
                    public void onAnimationCancel(Animator animator) {
                        if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
            if (z2) {
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
                    linearLayout4.setVisibility(0);
                    this.runningAnimation2 = new AnimatorSet();
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.ALPHA, 1.0f));
                    arrayList7.add(ObjectAnimator.ofFloat(this.attachLayout, (Property<LinearLayout, Float>) View.SCALE_X, 1.0f));
                    ChatActivityEnterViewDelegate chatActivityEnterViewDelegate7 = this.delegate;
                    boolean z8 = chatActivityEnterViewDelegate7 != null && chatActivityEnterViewDelegate7.hasScheduledMessages();
                    this.scheduleButtonHidden = false;
                    ImageView imageView16 = this.scheduledButton;
                    if (imageView16 != null) {
                        if (z8) {
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
                    this.runningAnimation2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.34
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
                                ChatActivityEnterView.this.runningAnimation2 = null;
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            if (animator.equals(ChatActivityEnterView.this.runningAnimation2)) {
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
                this.runningAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.35
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
                            ChatActivityEnterView.this.setSlowModeButtonVisible(false);
                            ChatActivityEnterView.this.runningAnimation = null;
                            ChatActivityEnterView.this.runningAnimationType = 0;
                            if (ChatActivityEnterView.this.audioVideoButtonContainer != null) {
                                ChatActivityEnterView.this.audioVideoButtonContainer.setVisibility(0);
                            }
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (animator.equals(ChatActivityEnterView.this.runningAnimation)) {
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
    public void setSlowModeButtonVisible(boolean z) {
        this.slowModeButton.setVisibility(z ? 0 : 8);
        int iDp = z ? AndroidUtilities.dp(16.0f) : 0;
        if (this.messageEditText.getPaddingRight() != iDp) {
            this.messageEditText.setPadding(0, AndroidUtilities.dp(11.0f), iDp, AndroidUtilities.dp(12.0f));
        }
    }

    public Boolean isSlowModeButtonVisible() {
        return Boolean.valueOf(this.slowModeButton.getVisibility() == 0);
    }

    private void updateFieldRight(int i) {
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
        int i2 = layoutParams.rightMargin;
        if (i == 1) {
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
        } else if (i == 2) {
            if (i2 != AndroidUtilities.dp(2.0f)) {
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
        if (i2 != layoutParams.rightMargin) {
            this.messageEditText.setLayoutParams(layoutParams);
        }
    }

    public void startMessageTransition() {
        Runnable runnable = this.moveToSendStateRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.moveToSendStateRunnable = null;
        }
        this.messageTransitionIsRunning = true;
        updateRecordIntefrace(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateRecordIntefrace(final int r26) {
        /*
            Method dump skipped, instructions count: 3498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatActivityEnterView.updateRecordIntefrace(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateRecordIntefrace$27(ValueAnimator valueAnimator) {
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

    public boolean canShowMessageTransition() {
        return this.moveToSendStateRunnable != null;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.recordingAudioVideo) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setDelegate(ChatActivityEnterViewDelegate chatActivityEnterViewDelegate) {
        this.delegate = chatActivityEnterViewDelegate;
    }

    public void setCommand(MessageObject messageObject, String str, boolean z, boolean z2) {
        String str2;
        if (str == null || getVisibility() != 0) {
            return;
        }
        TLRPC$User user = null;
        if (z) {
            String string = this.messageEditText.getText().toString();
            if (messageObject != null && ((int) this.dialog_id) < 0) {
                user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(messageObject.messageOwner.from_id.user_id));
            }
            if ((this.botCount != 1 || z2) && user != null && user.bot && !str.contains("@")) {
                str2 = String.format(Locale.US, "%s@%s", str, user.username) + " " + string.replaceFirst("^/[a-zA-Z@\\d_]{1,255}(\\s|$)", BuildConfig.FLAVOR);
            } else {
                str2 = str + " " + string.replaceFirst("^/[a-zA-Z@\\d_]{1,255}(\\s|$)", BuildConfig.FLAVOR);
            }
            this.ignoreTextChange = true;
            this.messageEditText.setText(str2);
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
        if (messageObject != null && ((int) this.dialog_id) < 0) {
            user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(messageObject.messageOwner.from_id.user_id));
        }
        if ((this.botCount != 1 || z2) && user != null && user.bot && !str.contains("@")) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(String.format(Locale.US, "%s@%s", str, user.username), this.dialog_id, this.replyingMessageObject, getThreadMessage(), (TLRPC$WebPage) null, false, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        } else {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(str, this.dialog_id, this.replyingMessageObject, getThreadMessage(), (TLRPC$WebPage) null, false, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
    }

    public void setEditingMessageObject(MessageObject messageObject, boolean z) {
        MessageObject messageObject2;
        CharSequence charSequence;
        if (this.audioToSend == null && this.videoToSendMessageObject == null && (messageObject2 = this.editingMessageObject) != messageObject) {
            boolean z2 = messageObject2 != null;
            this.editingMessageObject = messageObject;
            this.editingCaption = z;
            final CharSequence charSequenceReplaceEmoji = BuildConfig.FLAVOR;
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
                if (z) {
                    this.currentLimit = this.accountInstance.getMessagesController().maxCaptionLength;
                    charSequence = this.editingMessageObject.caption;
                } else {
                    this.currentLimit = this.accountInstance.getMessagesController().maxMessageLength;
                    charSequence = this.editingMessageObject.messageText;
                }
                if (charSequence != null) {
                    ArrayList<TLRPC$MessageEntity> arrayList = this.editingMessageObject.messageOwner.entities;
                    MediaDataController.sortEntities(arrayList);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                    Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
                    if (spans != null && spans.length > 0) {
                        for (Object obj : spans) {
                            spannableStringBuilder.removeSpan(obj);
                        }
                    }
                    if (arrayList != null) {
                        for (int i = 0; i < arrayList.size(); i++) {
                            try {
                                TLRPC$MessageEntity tLRPC$MessageEntity = arrayList.get(i);
                                if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length <= spannableStringBuilder.length()) {
                                    if (tLRPC$MessageEntity instanceof TLRPC$TL_inputMessageEntityMentionName) {
                                        if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length < spannableStringBuilder.length() && spannableStringBuilder.charAt(tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length) == ' ') {
                                            tLRPC$MessageEntity.length++;
                                        }
                                        URLSpanUserMention uRLSpanUserMention = new URLSpanUserMention(BuildConfig.FLAVOR + ((TLRPC$TL_inputMessageEntityMentionName) tLRPC$MessageEntity).user_id.user_id, 3);
                                        int i2 = tLRPC$MessageEntity.offset;
                                        spannableStringBuilder.setSpan(uRLSpanUserMention, i2, tLRPC$MessageEntity.length + i2, 33);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityMentionName) {
                                        if (tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length < spannableStringBuilder.length() && spannableStringBuilder.charAt(tLRPC$MessageEntity.offset + tLRPC$MessageEntity.length) == ' ') {
                                            tLRPC$MessageEntity.length++;
                                        }
                                        URLSpanUserMention uRLSpanUserMention2 = new URLSpanUserMention(BuildConfig.FLAVOR + ((TLRPC$TL_messageEntityMentionName) tLRPC$MessageEntity).user_id, 3);
                                        int i3 = tLRPC$MessageEntity.offset;
                                        spannableStringBuilder.setSpan(uRLSpanUserMention2, i3, tLRPC$MessageEntity.length + i3, 33);
                                    } else if ((tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityCode) || (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityPre)) {
                                        TextStyleSpan.TextStyleRun textStyleRun = new TextStyleSpan.TextStyleRun();
                                        textStyleRun.flags |= 4;
                                        TextStyleSpan textStyleSpan = new TextStyleSpan(textStyleRun);
                                        int i4 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan, i4, tLRPC$MessageEntity.length + i4, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityBold) {
                                        TextStyleSpan.TextStyleRun textStyleRun2 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun2.flags |= 1;
                                        TextStyleSpan textStyleSpan2 = new TextStyleSpan(textStyleRun2);
                                        int i5 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan2, i5, tLRPC$MessageEntity.length + i5, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityItalic) {
                                        TextStyleSpan.TextStyleRun textStyleRun3 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun3.flags |= 2;
                                        TextStyleSpan textStyleSpan3 = new TextStyleSpan(textStyleRun3);
                                        int i6 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan3, i6, tLRPC$MessageEntity.length + i6, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityStrike) {
                                        TextStyleSpan.TextStyleRun textStyleRun4 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun4.flags |= 8;
                                        TextStyleSpan textStyleSpan4 = new TextStyleSpan(textStyleRun4);
                                        int i7 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan4, i7, tLRPC$MessageEntity.length + i7, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityUnderline) {
                                        TextStyleSpan.TextStyleRun textStyleRun5 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun5.flags |= 16;
                                        TextStyleSpan textStyleSpan5 = new TextStyleSpan(textStyleRun5);
                                        int i8 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan5, i8, tLRPC$MessageEntity.length + i8, spannableStringBuilder, true);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntityTextUrl) {
                                        URLSpanReplacement uRLSpanReplacement = new URLSpanReplacement(tLRPC$MessageEntity.url);
                                        int i9 = tLRPC$MessageEntity.offset;
                                        spannableStringBuilder.setSpan(uRLSpanReplacement, i9, tLRPC$MessageEntity.length + i9, 33);
                                    } else if (tLRPC$MessageEntity instanceof TLRPC$TL_messageEntitySpoiler) {
                                        TextStyleSpan.TextStyleRun textStyleRun6 = new TextStyleSpan.TextStyleRun();
                                        textStyleRun6.flags |= 256;
                                        TextStyleSpan textStyleSpan6 = new TextStyleSpan(textStyleRun6);
                                        int i10 = tLRPC$MessageEntity.offset;
                                        MediaDataController.addStyleToText(textStyleSpan6, i10, tLRPC$MessageEntity.length + i10, spannableStringBuilder, true);
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                    }
                    charSequenceReplaceEmoji = Emoji.replaceEmoji(new SpannableStringBuilder(spannableStringBuilder), this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                }
                if (this.draftMessage == null && !z2) {
                    EditTextCaption editTextCaption = this.messageEditText;
                    this.draftMessage = (editTextCaption == null || editTextCaption.length() <= 0) ? null : this.messageEditText.getText();
                }
                if (!this.keyboardVisible) {
                    Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda29
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$setEditingMessageObject$28(charSequenceReplaceEmoji);
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
                EditTextCaption editTextCaption2 = this.messageEditText;
                if (editTextCaption2 != null) {
                    editTextCaption2.setText(this.draftMessage);
                    EditTextCaption editTextCaption3 = this.messageEditText;
                    editTextCaption3.setSelection(editTextCaption3.length());
                } else {
                    editTextCaption2.setText(BuildConfig.FLAVOR);
                }
                this.draftMessage = null;
                if (getVisibility() == 0) {
                    this.delegate.onAttachButtonShow();
                }
                updateFieldRight(1);
            }
            updateFieldHint(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setEditingMessageObject$28(CharSequence charSequence) {
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

    public View getEmojiButton() {
        return this.emojiButton[0];
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
                    actionBarMenuSubItem.setColors(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem), Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon));
                    actionBarMenuSubItem.setSelectorColor(Theme.getColor(Theme.key_dialogButtonSelector));
                }
            }
            this.sendPopupLayout.setBackgroundColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground));
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
                numberTextView.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            } else {
                numberTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
            }
        }
        this.doneCheckDrawable.setColorFilter(new PorterDuffColorFilter(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_chat_messagePanelVoicePressed), (int) (Color.alpha(r0) * ((this.doneButtonEnabledProgress * 0.42f) + 0.58f))), PorterDuff.Mode.MULTIPLY));
    }

    private void updateRecordedDeleteIconColors() {
        int color = Theme.getColor(Theme.key_chat_recordedVoiceDot);
        int color2 = Theme.getColor(Theme.key_chat_messagePanelBackground);
        int color3 = Theme.getColor(Theme.key_chat_messagePanelVoiceDelete);
        this.recordDeleteImageView.setLayerColor("Cup Red.**", color);
        this.recordDeleteImageView.setLayerColor("Box Red.**", color);
        this.recordDeleteImageView.setLayerColor("Cup Grey.**", color3);
        this.recordDeleteImageView.setLayerColor("Box Grey.**", color3);
        this.recordDeleteImageView.setLayerColor("Line 1.**", color2);
        this.recordDeleteImageView.setLayerColor("Line 2.**", color2);
        this.recordDeleteImageView.setLayerColor("Line 3.**", color2);
    }

    public void setFieldText(CharSequence charSequence) {
        setFieldText(charSequence, true);
    }

    public void setFieldText(CharSequence charSequence, boolean z) {
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate;
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        this.ignoreTextChange = z;
        editTextCaption.setText(charSequence);
        EditTextCaption editTextCaption2 = this.messageEditText;
        editTextCaption2.setSelection(editTextCaption2.getText().length());
        this.ignoreTextChange = false;
        if (!z || (chatActivityEnterViewDelegate = this.delegate) == null) {
            return;
        }
        chatActivityEnterViewDelegate.onTextChanged(this.messageEditText.getText(), true);
    }

    public void setSelection(int i) {
        EditTextCaption editTextCaption = this.messageEditText;
        if (editTextCaption == null) {
            return;
        }
        editTextCaption.setSelection(i, editTextCaption.length());
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

    public void replaceWithText(int i, int i2, CharSequence charSequence, boolean z) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.messageEditText.getText());
            spannableStringBuilder.replace(i, i2 + i, charSequence);
            if (z) {
                Emoji.replaceEmoji(spannableStringBuilder, this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            }
            this.messageEditText.setText(spannableStringBuilder);
            this.messageEditText.setSelection(i + charSequence.length());
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

    public void setFieldFocused(boolean z) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.parentActivity.getSystemService("accessibility");
        if (this.messageEditText == null || accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        if (z) {
            if (this.searchingType != 0 || this.messageEditText.isFocused()) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setFieldFocused$29();
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
    public /* synthetic */ void lambda$setFieldFocused$29() {
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

    public CharSequence getFieldText() {
        if (hasText()) {
            return this.messageEditText.getText();
        }
        return null;
    }

    public void updateScheduleButton(boolean z) {
        boolean z2;
        ImageView imageView;
        ImageView imageView2;
        if (((int) this.dialog_id) < 0) {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-((int) this.dialog_id)));
            String dialogId = IdStorage.getInstance().getDialogId(this.dialog_id);
            this.silent = MessagesController.getNotificationsSettings(this.currentAccount).getBoolean("silent3_" + dialogId, false);
            z2 = ChatObject.isChannel(chat) && ChatObject.canSendMessages(chat) && !chat.megagroup;
            this.canWriteToChannel = z2;
            if (this.notifyButton != null) {
                if (this.notifySilentDrawable == null) {
                    this.notifySilentDrawable = new CrossOutDrawable(getContext(), R.drawable.input_notify_on, Theme.key_chat_messagePanelIcons);
                }
                this.notifySilentDrawable.setCrossOut(this.silent, false);
                this.notifyButton.setImageDrawable(this.notifySilentDrawable);
            } else {
                z2 = false;
            }
            LinearLayout linearLayout = this.attachLayout;
            if (linearLayout != null) {
                updateFieldRight(linearLayout.getVisibility() == 0 ? 1 : 0);
            }
        } else {
            z2 = false;
        }
        boolean z3 = (this.delegate == null || isInScheduleMode() || !this.delegate.hasScheduledMessages()) ? false : true;
        final boolean z4 = (!z3 || this.scheduleButtonHidden || this.recordingAudioVideo) ? false : true;
        ImageView imageView3 = this.scheduledButton;
        float f = 96.0f;
        if (imageView3 != null) {
            if ((imageView3.getTag() != null && z4) || (this.scheduledButton.getTag() == null && !z4)) {
                if (this.notifyButton != null) {
                    int i = (z3 || !z2 || this.scheduledButton.getVisibility() == 0) ? 8 : 0;
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
            this.scheduledButton.setTag(z4 ? 1 : null);
        }
        AnimatorSet animatorSet = this.scheduledButtonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.scheduledButtonAnimation = null;
        }
        if (!z || z2) {
            ImageView imageView5 = this.scheduledButton;
            if (imageView5 != null) {
                imageView5.setVisibility(z4 ? 0 : 8);
                this.scheduledButton.setAlpha(z4 ? 1.0f : 0.0f);
                this.scheduledButton.setScaleX(z4 ? 1.0f : 0.1f);
                this.scheduledButton.setScaleY(z4 ? 1.0f : 0.1f);
                ImageView imageView6 = this.notifyButton;
                if (imageView6 != null) {
                    imageView6.setVisibility((!z2 || this.scheduledButton.getVisibility() == 0) ? 8 : 0);
                }
            }
        } else {
            ImageView imageView7 = this.scheduledButton;
            if (imageView7 != null) {
                if (z4) {
                    imageView7.setVisibility(0);
                }
                this.scheduledButton.setPivotX(AndroidUtilities.dp(24.0f));
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.scheduledButtonAnimation = animatorSet2;
                Animator[] animatorArr = new Animator[3];
                ImageView imageView8 = this.scheduledButton;
                Property property = View.ALPHA;
                float[] fArr = new float[1];
                fArr[0] = z4 ? 1.0f : 0.0f;
                animatorArr[0] = ObjectAnimator.ofFloat(imageView8, (Property<ImageView, Float>) property, fArr);
                ImageView imageView9 = this.scheduledButton;
                Property property2 = View.SCALE_X;
                float[] fArr2 = new float[1];
                fArr2[0] = z4 ? 1.0f : 0.1f;
                animatorArr[1] = ObjectAnimator.ofFloat(imageView9, (Property<ImageView, Float>) property2, fArr2);
                ImageView imageView10 = this.scheduledButton;
                Property property3 = View.SCALE_Y;
                float[] fArr3 = new float[1];
                fArr3[0] = z4 ? 1.0f : 0.1f;
                animatorArr[2] = ObjectAnimator.ofFloat(imageView10, (Property<ImageView, Float>) property3, fArr3);
                animatorSet2.playTogether(animatorArr);
                this.scheduledButtonAnimation.setDuration(180L);
                this.scheduledButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.41
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ChatActivityEnterView.this.scheduledButtonAnimation = null;
                        if (z4) {
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

    private void updateBotButton() {
        ImageView imageView;
        ImageView imageView2 = this.botButton;
        if (imageView2 == null) {
            return;
        }
        if (this.hasBotCommands || this.botReplyMarkup != null) {
            if (imageView2.getVisibility() != 0) {
                this.botButton.setVisibility(0);
            }
            if (this.botReplyMarkup != null) {
                if (isPopupShowing() && this.currentPopupContentType == 1) {
                    this.botButtonDrawablel.setIcon(R.drawable.input_keyboard, true);
                    this.botButton.setContentDescription(LocaleController.getString("AccDescrShowKeyboard", R.string.AccDescrShowKeyboard));
                } else {
                    this.botButtonDrawablel.setIcon(R.drawable.input_bot2, true);
                    this.botButton.setContentDescription(LocaleController.getString("AccDescrBotKeyboard", R.string.AccDescrBotKeyboard));
                }
            } else {
                this.botButtonDrawablel.setIcon(R.drawable.input_bot1, true);
                this.botButton.setContentDescription(LocaleController.getString("AccDescrBotCommands", R.string.AccDescrBotCommands));
            }
        } else {
            imageView2.setVisibility(8);
        }
        updateFieldRight(2);
        LinearLayout linearLayout = this.attachLayout;
        ImageView imageView3 = this.botButton;
        linearLayout.setPivotX(AndroidUtilities.dp(((imageView3 == null || imageView3.getVisibility() == 8) && ((imageView = this.notifyButton) == null || imageView.getVisibility() == 8)) ? 48.0f : 96.0f));
    }

    public void setBotsCount(int i, boolean z) {
        this.botCount = i;
        if (this.hasBotCommands != z) {
            this.hasBotCommands = z;
            updateBotButton();
        }
    }

    public void setButtons(MessageObject messageObject) {
        setButtons(messageObject, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setButtons(final org.rbmain.messenger.MessageObject r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatActivityEnterView.setButtons(org.rbmain.messenger.MessageObject, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setButtons$30(final MessageObject messageObject, final TLRPC$KeyboardButton tLRPC$KeyboardButton) throws Resources.NotFoundException {
        MessageObject messageObject2 = this.replyingMessageObject;
        final MessageObject messageObject3 = messageObject2 != null ? messageObject2 : ((int) this.dialog_id) < 0 ? this.botButtonsMessageObject : null;
        if (messageObject2 == null) {
            messageObject2 = this.botButtonsMessageObject;
        }
        final MessageObject messageObject4 = messageObject2;
        if (messageObject4 == null || tLRPC$KeyboardButton == null) {
            return;
        }
        BotButtonHandler.handleButtonClick(this.parentFragment, this.dialog_id, tLRPC$KeyboardButton.miniFunctionObject, null, new BotButtonHandler.Delegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.43
            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void uploadFileDone(String str, String str2) {
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void done(String str, ArrayList<String> arrayList) throws JSONException {
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i));
                        if (i < arrayList.size() - 1) {
                            sb.append("\n");
                        }
                    }
                    str = sb.toString();
                }
                messageObject4.messageOwner.bot_button_text = str;
                TLRPC$KeyboardButton tLRPC$KeyboardButton2 = tLRPC$KeyboardButton;
                tLRPC$KeyboardButton2.text = str;
                ChatActivityEnterView.this.didPressedBotButton(tLRPC$KeyboardButton2, messageObject3, messageObject);
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void onLocationSelected(TLRPC$MessageMedia tLRPC$MessageMedia) throws JSONException {
                MessageObject messageObject5 = messageObject;
                messageObject5.messageOwner.media = tLRPC$MessageMedia;
                ChatActivityEnterView.this.didPressedBotButton(tLRPC$KeyboardButton, messageObject3, messageObject5);
            }

            @Override // androidMessenger.utilites.BotButtonHandler.Delegate
            public void notSupported() {
                AlertsCreator.showSimpleToast(ChatActivityEnterView.this.parentFragment, LocaleController.getString("notSupported", R.string.notSupported));
            }
        });
        if (this.replyingMessageObject != null) {
            openKeyboardInternal();
            setButtons(this.botMessageObject, false);
        } else {
            MessageObject messageObject5 = this.botButtonsMessageObject;
            if (messageObject5 != null && messageObject5.messageOwner.reply_markup.single_use) {
                openKeyboardInternal();
                SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
                String dialogId = IdStorage.getInstance().getDialogId(this.dialog_id);
                String keypadStateId = IdStorage.getInstance().getKeypadStateId(this.botButtonsMessageObject.getId());
                mainSettings.edit().putString("answered_" + dialogId, keypadStateId).apply();
            }
        }
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = this.delegate;
        if (chatActivityEnterViewDelegate != null) {
            chatActivityEnterViewDelegate.onMessageSend(null, true, 0);
        }
    }

    public boolean didPressedBotButton(final TLRPC$KeyboardButton tLRPC$KeyboardButton, MessageObject messageObject, final MessageObject messageObject2) throws JSONException {
        if (tLRPC$KeyboardButton == null || messageObject2 == null) {
            return false;
        }
        if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButton) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$KeyboardButton.text, tLRPC$KeyboardButton.button_id, this.dialog_id, messageObject, getThreadMessage(), (TLRPC$WebPage) null, false, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        } else if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonUrl) {
            AlertsCreator.showOpenUrlAlert(this.parentFragment, tLRPC$KeyboardButton.url, false, true);
        } else if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonRequestPhone) {
            this.parentFragment.shareMyContact(2, messageObject2);
        } else {
            if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonRequestPoll) {
                this.parentFragment.openPollCreate((tLRPC$KeyboardButton.flags & 1) != 0 ? Boolean.valueOf(tLRPC$KeyboardButton.quiz) : null);
                return false;
            }
            if (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonRequestGeoLocation) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.parentActivity);
                builder.setTitle(LocaleController.getString("ShareYouLocationTitle", R.string.ShareYouLocationTitle));
                builder.setMessage(LocaleController.getString("ShareYouLocationInfo", R.string.ShareYouLocationInfo));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$didPressedBotButton$31(messageObject2, tLRPC$KeyboardButton, dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                this.parentFragment.showDialog(builder.create());
            } else if ((tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonCallback) || (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonGame) || (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonBuy) || (tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonUrlAuth)) {
                SendMessagesHelper.getInstance(this.currentAccount).sendCallback(true, messageObject2, tLRPC$KeyboardButton, this.parentFragment);
            } else {
                if (!(tLRPC$KeyboardButton instanceof TLRPC$TL_keyboardButtonSwitchInline) || this.parentFragment.processSwitchButton((TLRPC$TL_keyboardButtonSwitchInline) tLRPC$KeyboardButton)) {
                    return true;
                }
                if (tLRPC$KeyboardButton.same_peer) {
                    TLRPC$Message tLRPC$Message = messageObject2.messageOwner;
                    int i = tLRPC$Message.from_id.user_id;
                    int i2 = tLRPC$Message.via_bot_id;
                    if (i2 != 0) {
                        i = i2;
                    }
                    TLRPC$User user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(i));
                    if (user == null) {
                        return true;
                    }
                    setFieldText("@" + user.username + " " + tLRPC$KeyboardButton.query);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("onlySelect", true);
                    bundle.putInt("dialogsType", 1);
                    DialogsActivity dialogsActivity = new DialogsActivity(bundle);
                    dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda38
                        @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                        public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                            this.f$0.lambda$didPressedBotButton$32(messageObject2, tLRPC$KeyboardButton, dialogsActivity2, arrayList, charSequence, z);
                        }
                    });
                    this.parentFragment.presentFragment(dialogsActivity);
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didPressedBotButton$31(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, DialogInterface dialogInterface, int i) {
        if (Build.VERSION.SDK_INT >= 23 && this.parentActivity.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.parentActivity.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, 2);
            this.pendingMessageObject = messageObject;
            this.pendingLocationButton = tLRPC$KeyboardButton;
            return;
        }
        SendMessagesHelper.getInstance(this.currentAccount).sendCurrentLocation(messageObject, tLRPC$KeyboardButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didPressedBotButton$32(MessageObject messageObject, TLRPC$KeyboardButton tLRPC$KeyboardButton, DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        int i = tLRPC$Message.from_id.user_id;
        int i2 = tLRPC$Message.via_bot_id;
        if (i2 != 0) {
            i = i2;
        }
        TLRPC$User user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(i));
        if (user == null) {
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        MediaDataController.getInstance(this.currentAccount).saveDraft(jLongValue, 0L, "@" + user.username + " " + tLRPC$KeyboardButton.query, null, null, true);
        if (jLongValue == this.dialog_id) {
            dialogsActivity.finishFragment();
            return;
        }
        int i3 = (int) jLongValue;
        if (i3 != 0) {
            Bundle bundle = new Bundle();
            if (i3 > 0) {
                bundle.putInt("user_id", i3);
            } else {
                bundle.putInt("chat_id", -i3);
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
    }

    public boolean isPopupView(View view) {
        return view == this.botKeyboardView || view == this.emojiView;
    }

    public boolean isRecordCircle(View view) {
        return view == this.recordCircle;
    }

    public int getPopupViewHeight(View view) {
        BotKeyboardView botKeyboardView = this.botKeyboardView;
        if (view != botKeyboardView || botKeyboardView == null) {
            return -1;
        }
        return botKeyboardView.getKeyboardHeight();
    }

    private void createEmojiView() throws Resources.NotFoundException {
        if (this.emojiView != null) {
            return;
        }
        EmojiView emojiView = new EmojiView(this.parentFragment, this.allowStickers, this.allowGifs, this.parentActivity, true, this.info) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.44
            @Override // org.rbmain.ui.Components.EmojiView, android.view.View
            public void setTranslationY(float f) {
                super.setTranslationY(f);
                if (ChatActivityEnterView.this.panelAnimation == null || ChatActivityEnterView.this.animatingContentType != 0) {
                    return;
                }
                ChatActivityEnterView.this.delegate.bottomPanelTranslationYChanged(f);
            }
        };
        this.emojiView = emojiView;
        emojiView.setVisibility(8);
        this.emojiView.setDelegate(new AnonymousClass45());
        this.emojiView.setDragListener(new EmojiView.DragListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.46
            int initialOffset;
            boolean wasExpanded;

            @Override // org.rbmain.ui.Components.EmojiView.DragListener
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

            @Override // org.rbmain.ui.Components.EmojiView.DragListener
            public void onDragEnd(float f) {
                if (allowDragging()) {
                    ChatActivityEnterView.this.stickersDragging = false;
                    if ((this.wasExpanded && f >= AndroidUtilities.dp(200.0f)) || ((!this.wasExpanded && f <= AndroidUtilities.dp(-200.0f)) || ((this.wasExpanded && ChatActivityEnterView.this.stickersExpansionProgress <= 0.6f) || (!this.wasExpanded && ChatActivityEnterView.this.stickersExpansionProgress >= 0.4f)))) {
                        ChatActivityEnterView.this.setStickersExpanded(!this.wasExpanded, true, true);
                    } else {
                        ChatActivityEnterView.this.setStickersExpanded(this.wasExpanded, true, true);
                    }
                }
            }

            @Override // org.rbmain.ui.Components.EmojiView.DragListener
            public void onDragCancel() {
                if (ChatActivityEnterView.this.stickersTabOpen) {
                    ChatActivityEnterView.this.stickersDragging = false;
                    ChatActivityEnterView.this.setStickersExpanded(this.wasExpanded, true, false);
                }
            }

            @Override // org.rbmain.ui.Components.EmojiView.DragListener
            public void onDrag(int i) {
                if (allowDragging()) {
                    android.graphics.Point point = AndroidUtilities.displaySize;
                    float fMax = Math.max(Math.min(i + this.initialOffset, 0), -(ChatActivityEnterView.this.stickersExpandedHeight - (point.x > point.y ? ChatActivityEnterView.this.keyboardHeightLand : ChatActivityEnterView.this.keyboardHeight)));
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
        this.sizeNotifierLayout.addView(this.emojiView, r0.getChildCount() - 1);
        checkChannelRights();
    }

    /* renamed from: org.rbmain.ui.Components.ChatActivityEnterView$45, reason: invalid class name */
    class AnonymousClass45 implements EmojiView.EmojiViewDelegate {
        AnonymousClass45() {
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public boolean onBackspace() {
            if (ChatActivityEnterView.this.messageEditText.length() == 0) {
                return false;
            }
            ChatActivityEnterView.this.messageEditText.dispatchKeyEvent(new KeyEvent(0, 67));
            return true;
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onEmojiSelected(String str) {
            int selectionEnd = ChatActivityEnterView.this.messageEditText.getSelectionEnd();
            if (selectionEnd < 0) {
                selectionEnd = 0;
            }
            try {
                try {
                    ChatActivityEnterView.this.innerTextChange = 2;
                    CharSequence charSequenceReplaceEmoji = Emoji.replaceEmoji(str, ChatActivityEnterView.this.messageEditText.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
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

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSelected(View view, TLRPC$Document tLRPC$Document, String str, Object obj, boolean z, int i) throws IOException {
            if (ChatActivityEnterView.this.trendingStickersAlert != null) {
                ChatActivityEnterView.this.trendingStickersAlert.dismiss();
                ChatActivityEnterView.this.trendingStickersAlert = null;
            }
            if (ChatActivityEnterView.this.slowModeTimer <= 0 || isInScheduleMode()) {
                if (ChatActivityEnterView.this.stickersExpanded) {
                    if (ChatActivityEnterView.this.searchingType != 0) {
                        ChatActivityEnterView.this.searchingType = 0;
                        ChatActivityEnterView.this.emojiView.closeSearch(true, MessageObject.getStickerSetId(tLRPC$Document));
                        ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                    }
                    ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                }
                ChatActivityEnterView.this.lambda$onStickerSelected$33(tLRPC$Document, str, obj, false, z, i);
                if (((int) ChatActivityEnterView.this.dialog_id) == 0 && MessageObject.isGifDocument(tLRPC$Document)) {
                    ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(obj, tLRPC$Document);
                    return;
                }
                return;
            }
            if (ChatActivityEnterView.this.delegate != null) {
                ChatActivityEnterViewDelegate chatActivityEnterViewDelegate = ChatActivityEnterView.this.delegate;
                if (view == null) {
                    view = ChatActivityEnterView.this.slowModeButton;
                }
                chatActivityEnterViewDelegate.onUpdateSlowModeButton(view, true, ChatActivityEnterView.this.slowModeButton.getText());
            }
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickersSettingsClick() {
            if (ChatActivityEnterView.this.parentFragment != null) {
                ChatActivityEnterView.this.parentFragment.presentFragment(new StickersActivity(0));
            }
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        /* renamed from: onGifSelected, reason: merged with bridge method [inline-methods] */
        public void lambda$onGifSelected$0(final View view, final Object obj, final String str, final Object obj2, boolean z, int i) throws IOException {
            if (!isInScheduleMode() || i != 0) {
                if (ChatActivityEnterView.this.slowModeTimer <= 0 || isInScheduleMode()) {
                    if (ChatActivityEnterView.this.stickersExpanded) {
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                        }
                        ChatActivityEnterView.this.setStickersExpanded(false, true, false);
                    }
                    if (obj instanceof TLRPC$Document) {
                        TLRPC$Document tLRPC$Document = (TLRPC$Document) obj;
                        SendMessagesHelper.getInstance(ChatActivityEnterView.this.currentAccount).sendSticker(tLRPC$Document, str, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), obj2, null, z, i, false);
                        MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).addRecentGif(tLRPC$Document, (int) (System.currentTimeMillis() / 1000));
                        if (((int) ChatActivityEnterView.this.dialog_id) == 0) {
                            ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(obj2, tLRPC$Document);
                        }
                    } else if (obj instanceof TLRPC$BotInlineResult) {
                        TLRPC$BotInlineResult tLRPC$BotInlineResult = (TLRPC$BotInlineResult) obj;
                        if (tLRPC$BotInlineResult.document != null) {
                            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).addRecentGif(tLRPC$BotInlineResult.document, (int) (System.currentTimeMillis() / 1000));
                            if (((int) ChatActivityEnterView.this.dialog_id) == 0) {
                                ChatActivityEnterView.this.accountInstance.getMessagesController().saveGif(obj2, tLRPC$BotInlineResult.document);
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("id", tLRPC$BotInlineResult.id);
                        map.put("query_id", BuildConfig.FLAVOR + tLRPC$BotInlineResult.query_id);
                        map.put("force_gif", "1");
                        SendMessagesHelper.prepareSendingBotContextResult(ChatActivityEnterView.this.accountInstance, tLRPC$BotInlineResult, map, ChatActivityEnterView.this.dialog_id, ChatActivityEnterView.this.replyingMessageObject, ChatActivityEnterView.this.getThreadMessage(), z, i);
                        if (ChatActivityEnterView.this.searchingType != 0) {
                            ChatActivityEnterView.this.searchingType = 0;
                            ChatActivityEnterView.this.emojiView.closeSearch(true);
                            ChatActivityEnterView.this.emojiView.hideSearchKeyboard();
                        }
                    }
                    if (ChatActivityEnterView.this.delegate != null) {
                        ChatActivityEnterView.this.delegate.onMessageSend(null, z, i);
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
            AlertsCreator.createScheduleDatePickerDialog(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$45$$ExternalSyntheticLambda1
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z2, int i2) throws IOException {
                    this.f$0.lambda$onGifSelected$0(view, obj, str, obj2, z2, i2);
                }
            });
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onTabOpened(int i) {
            ChatActivityEnterView.this.delegate.onStickersTab(i == 3);
            ChatActivityEnterView chatActivityEnterView = ChatActivityEnterView.this;
            chatActivityEnterView.post(chatActivityEnterView.updateExpandabilityRunnable);
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onClearEmojiRecent() {
            if (ChatActivityEnterView.this.parentFragment == null || ChatActivityEnterView.this.parentActivity == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivityEnterView.this.parentActivity);
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("ClearRecentEmoji", R.string.ClearRecentEmoji));
            builder.setPositiveButton(LocaleController.getString("ClearButton", R.string.ClearButton).toUpperCase(), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$45$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onClearEmojiRecent$1(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            ChatActivityEnterView.this.parentFragment.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClearEmojiRecent$1(DialogInterface dialogInterface, int i) {
            ChatActivityEnterView.this.emojiView.clearRecentEmoji();
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onShowStickerSet(TLRPC$StickerSet tLRPC$StickerSet, TLRPC$InputStickerSet tLRPC$InputStickerSet) {
            if (ChatActivityEnterView.this.trendingStickersAlert == null || ChatActivityEnterView.this.trendingStickersAlert.isDismissed()) {
                if (ChatActivityEnterView.this.parentFragment == null || ChatActivityEnterView.this.parentActivity == null) {
                    return;
                }
                if (tLRPC$StickerSet != null) {
                    tLRPC$InputStickerSet = new TLRPC$TL_inputStickerSetID();
                    tLRPC$InputStickerSet.access_hash = tLRPC$StickerSet.access_hash;
                    tLRPC$InputStickerSet.id = tLRPC$StickerSet.id;
                }
                ChatActivityEnterView.this.parentFragment.showDialog(new StickersAlert(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment, tLRPC$InputStickerSet, null, ChatActivityEnterView.this));
                return;
            }
            ChatActivityEnterView.this.trendingStickersAlert.getLayout().showStickerSet(tLRPC$StickerSet, tLRPC$InputStickerSet);
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSetAdd(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).toggleStickerSet(ChatActivityEnterView.this.parentActivity, tLRPC$StickerSetCovered, 2, ChatActivityEnterView.this.parentFragment, false, false);
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickerSetRemove(TLRPC$StickerSetCovered tLRPC$StickerSetCovered) {
            MediaDataController.getInstance(ChatActivityEnterView.this.currentAccount).toggleStickerSet(ChatActivityEnterView.this.parentActivity, tLRPC$StickerSetCovered, 0, ChatActivityEnterView.this.parentFragment, false, false);
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onStickersGroupClick(int i) {
            if (ChatActivityEnterView.this.parentFragment != null) {
                if (AndroidUtilities.isTablet()) {
                    ChatActivityEnterView.this.hidePopup(false);
                }
                GroupStickersActivity groupStickersActivity = new GroupStickersActivity(i);
                groupStickersActivity.setInfo(ChatActivityEnterView.this.info);
                ChatActivityEnterView.this.parentFragment.presentFragment(groupStickersActivity);
            }
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void onSearchOpenClose(int i) {
            ChatActivityEnterView.this.searchingType = i;
            if (i != 0) {
                ChatActivityEnterView.this.setStickersExpanded(true, true, false);
            }
            if (ChatActivityEnterView.this.emojiTabOpen && ChatActivityEnterView.this.searchingType == 2) {
                ChatActivityEnterView.this.checkStickresExpandHeight();
            }
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isSearchOpened() {
            return ChatActivityEnterView.this.searchingType != 0;
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isExpanded() {
            return ChatActivityEnterView.this.stickersExpanded;
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public boolean canSchedule() {
            return ChatActivityEnterView.this.parentFragment != null && ChatActivityEnterView.this.parentFragment.canScheduleMessage();
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public boolean isInScheduleMode() {
            return ChatActivityEnterView.this.parentFragment != null && ChatActivityEnterView.this.parentFragment.isInScheduleMode();
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public long getDialogId() {
            return ChatActivityEnterView.this.dialog_id;
        }

        @Override // org.rbmain.ui.Components.EmojiView.EmojiViewDelegate
        public void showTrendingStickersAlert(TrendingStickersLayout trendingStickersLayout) {
            if (ChatActivityEnterView.this.parentActivity == null || ChatActivityEnterView.this.parentFragment == null) {
                return;
            }
            ChatActivityEnterView.this.trendingStickersAlert = new TrendingStickersAlert(ChatActivityEnterView.this.parentActivity, ChatActivityEnterView.this.parentFragment, trendingStickersLayout) { // from class: org.rbmain.ui.Components.ChatActivityEnterView.45.1
                @Override // org.rbmain.ui.Components.TrendingStickersAlert, org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
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
    }

    @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
    /* renamed from: onStickerSelected, reason: merged with bridge method [inline-methods] */
    public void lambda$onStickerSelected$33(final TLRPC$Document tLRPC$Document, final String str, final Object obj, final boolean z, boolean z2, int i) throws IOException {
        if (isInScheduleMode() && i == 0) {
            AlertsCreator.createScheduleDatePickerDialog(this.parentActivity, this.parentFragment.getDialogId(), new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda33
                @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
                public final void didSelectDate(boolean z3, int i2) throws IOException {
                    this.f$0.lambda$onStickerSelected$33(tLRPC$Document, str, obj, z, z3, i2);
                }
            });
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
            this.searchingType = 0;
            this.emojiView.closeSearch(true);
            this.emojiView.hideSearchKeyboard();
        }
        setStickersExpanded(false, true, false);
        SendMessagesHelper.getInstance(this.currentAccount).sendSticker(tLRPC$Document, str, this.dialog_id, this.replyingMessageObject, getThreadMessage(), obj, null, z2, i, false);
        ChatActivityEnterViewDelegate chatActivityEnterViewDelegate2 = this.delegate;
        if (chatActivityEnterViewDelegate2 != null) {
            chatActivityEnterViewDelegate2.onMessageSend(null, true, i);
        }
        if (z) {
            setFieldText(BuildConfig.FLAVOR);
        }
        MediaDataController.getInstance(this.currentAccount).addRecentSticker(0, obj, tLRPC$Document, (int) (System.currentTimeMillis() / 1000), false);
    }

    @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
    public boolean canSchedule() {
        ChatActivity chatActivity = this.parentFragment;
        return chatActivity != null && chatActivity.canScheduleMessage();
    }

    @Override // org.rbmain.ui.Components.StickersAlert.StickersAlertDelegate
    public boolean isInScheduleMode() {
        ChatActivity chatActivity = this.parentFragment;
        return chatActivity != null && chatActivity.isInScheduleMode();
    }

    public void addStickerToRecent(TLRPC$Document tLRPC$Document) throws Resources.NotFoundException {
        createEmojiView();
        this.emojiView.addRecentSticker(tLRPC$Document);
    }

    public void showEmojiView() throws Resources.NotFoundException {
        showPopup(1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopup(final int i, int i2) throws Resources.NotFoundException {
        int measuredHeight;
        View view;
        if (i == 2) {
            return;
        }
        if (i == 1) {
            if (i2 == 0 && this.emojiView == null) {
                if (this.parentActivity == null) {
                    return;
                } else {
                    createEmojiView();
                }
            }
            if (i2 == 0) {
                if (this.emojiView.getParent() == null) {
                    SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
                    sizeNotifierFrameLayout.addView(this.emojiView, sizeNotifierFrameLayout.getChildCount() - 1);
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
                view = this.emojiView;
                this.animatingContentType = 0;
            } else if (i2 == 1) {
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
            this.currentPopupContentType = i2;
            if (this.keyboardHeight <= 0) {
                this.keyboardHeight = MessagesController.getGlobalEmojiSettings().getInt("kbd_height", AndroidUtilities.dp(200.0f));
            }
            if (this.keyboardHeightLand <= 0) {
                this.keyboardHeightLand = MessagesController.getGlobalEmojiSettings().getInt("kbd_height_land3", AndroidUtilities.dp(200.0f));
            }
            android.graphics.Point point = AndroidUtilities.displaySize;
            int iMin = point.x > point.y ? this.keyboardHeightLand : this.keyboardHeight;
            if (i2 == 1) {
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
            SizeNotifierFrameLayout sizeNotifierFrameLayout2 = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayout2 != null) {
                this.emojiPadding = iMin;
                sizeNotifierFrameLayout2.requestLayout();
                setEmojiButtonImage(true, true);
                updateBotButton();
                onWindowSizeChanged();
                if (this.smoothKeyboard && !this.keyboardVisible && iMin != measuredHeight) {
                    this.panelAnimation = new AnimatorSet();
                    float f = iMin - measuredHeight;
                    view.setTranslationY(f);
                    this.panelAnimation.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, f, 0.0f));
                    this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                    this.panelAnimation.setDuration(250L);
                    this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.47
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
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
            if (this.emojiView != null) {
                if (i != 2 || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                    if (this.smoothKeyboard && !this.keyboardVisible && !this.stickersExpanded) {
                        this.emojiViewVisible = true;
                        this.animatingContentType = 0;
                        AnimatorSet animatorSet = new AnimatorSet();
                        this.panelAnimation = animatorSet;
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.emojiView, (Property<EmojiView, Float>) View.TRANSLATION_Y, r5.getMeasuredHeight()));
                        this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                        this.panelAnimation.setDuration(250L);
                        this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.48
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (i == 0) {
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
            if (botKeyboardView3 != null) {
                if (i != 2 || AndroidUtilities.usingHardwareInput || AndroidUtilities.isInMultiwindow) {
                    if (this.smoothKeyboard && !this.keyboardVisible) {
                        if (this.botKeyboardViewVisible) {
                            this.animatingContentType = 1;
                        }
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        this.panelAnimation = animatorSet2;
                        animatorSet2.playTogether(ObjectAnimator.ofFloat(this.botKeyboardView, (Property<BotKeyboardView, Float>) View.TRANSLATION_Y, r4.getMeasuredHeight()));
                        this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                        this.panelAnimation.setDuration(250L);
                        this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.49
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                if (i == 0) {
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
                        botKeyboardView3.setVisibility(8);
                    }
                }
                this.botKeyboardViewVisible = false;
            }
            SizeNotifierFrameLayout sizeNotifierFrameLayout3 = this.sizeNotifierLayout;
            if (sizeNotifierFrameLayout3 != null && !SharedConfig.smoothKeyboard && i == 0) {
                this.emojiPadding = 0;
                sizeNotifierFrameLayout3.requestLayout();
                onWindowSizeChanged();
            }
            updateBotButton();
        }
        if (this.stickersTabOpen || this.emojiTabOpen) {
            checkSendButton(true);
        }
        if (!this.stickersExpanded || i == 1) {
            return;
        }
        setStickersExpanded(false, false, false);
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
            this.emojiButtonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.50
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (animator.equals(ChatActivityEnterView.this.emojiButtonAnimation)) {
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

    protected void onEmojiIconChanged(int i) {
        if (i == 3 && this.emojiView == null) {
            MediaDataController.getInstance(this.currentAccount).loadRecents(0, true, true, false);
            ArrayList<String> arrayList = MessagesController.getInstance(this.currentAccount).gifSearchEmojies;
            int iMin = Math.min(10, arrayList.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                Emoji.preloadEmoji(arrayList.get(i2));
            }
        }
    }

    public boolean hidePopup(boolean z) {
        return hidePopup(z, false);
    }

    public boolean hidePopup(boolean z, boolean z2) throws Resources.NotFoundException {
        if (!isPopupShowing()) {
            return false;
        }
        if (this.currentPopupContentType == 1 && this.botReplyMarkup != null && z && this.botButtonsMessageObject != null) {
            SharedPreferences mainSettings = MessagesController.getMainSettings(this.currentAccount);
            String dialogId = IdStorage.getInstance().getDialogId(this.dialog_id);
            String keypadStateId = IdStorage.getInstance().getKeypadStateId(this.botButtonsMessageObject.getId());
            mainSettings.edit().putString("hidekeyboard_" + dialogId, keypadStateId).apply();
        }
        if ((z && this.searchingType != 0) || z2) {
            this.searchingType = 0;
            EmojiView emojiView = this.emojiView;
            if (emojiView != null) {
                emojiView.closeSearch(true);
            }
            EditTextCaption editTextCaption = this.messageEditText;
            if (editTextCaption != null) {
                editTextCaption.requestFocus();
            }
            setStickersExpanded(false, true, false);
            if (this.emojiTabOpen) {
                checkSendButton(true);
            }
        } else {
            if (this.searchingType != 0) {
                this.searchingType = 0;
                this.emojiView.closeSearch(false);
                EditTextCaption editTextCaption2 = this.messageEditText;
                if (editTextCaption2 != null) {
                    editTextCaption2.requestFocus();
                }
            }
            showPopup(0, 0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openKeyboardInternal() throws Resources.NotFoundException {
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

    public void addRecentGif(TLRPC$Document tLRPC$Document) {
        MediaDataController.getInstance(this.currentAccount).addRecentGif(tLRPC$Document, (int) (System.currentTimeMillis() / 1000));
        EmojiView emojiView = this.emojiView;
        if (emojiView != null) {
            emojiView.addRecentGif(tLRPC$Document);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 && this.stickersExpanded) {
            this.searchingType = 0;
            this.emojiView.closeSearch(false);
            setStickersExpanded(false, false, false);
        }
        this.videoTimelineView.clearFrames();
    }

    public boolean isStickersExpanded() {
        return this.stickersExpanded;
    }

    @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout.SizeNotifierFrameLayoutDelegate
    public void onSizeChanged(int i, boolean z) throws Resources.NotFoundException {
        boolean z2;
        View view;
        if (this.searchingType != 0) {
            this.lastSizeChangeValue1 = i;
            this.lastSizeChangeValue2 = z;
            this.keyboardVisible = i > 0;
            return;
        }
        if (i > AndroidUtilities.dp(50.0f) && this.keyboardVisible && !AndroidUtilities.isInMultiwindow) {
            if (z) {
                this.keyboardHeightLand = i;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height_land3", this.keyboardHeightLand).apply();
            } else {
                this.keyboardHeight = i;
                MessagesController.getGlobalEmojiSettings().edit().putInt("kbd_height", this.keyboardHeight).apply();
            }
        }
        if (this.keyboardVisible && this.emojiViewVisible && this.emojiView == null) {
            this.emojiViewVisible = false;
        }
        if (isPopupShowing()) {
            int iMin = z ? this.keyboardHeightLand : this.keyboardHeight;
            if (this.currentPopupContentType == 1 && !this.botKeyboardView.isFullSize()) {
                iMin = Math.min(this.botKeyboardView.getKeyboardHeight(), iMin);
            }
            int i2 = this.currentPopupContentType;
            if (i2 == 0) {
                view = this.emojiView;
            } else {
                view = i2 == 1 ? this.botKeyboardView : null;
            }
            BotKeyboardView botKeyboardView = this.botKeyboardView;
            if (botKeyboardView != null) {
                botKeyboardView.setPanelHeight(iMin);
            }
            if (view != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                if (!this.closeAnimationInProgress) {
                    int i3 = layoutParams.width;
                    int i4 = AndroidUtilities.displaySize.x;
                    if ((i3 != i4 || layoutParams.height != iMin) && !this.stickersExpanded) {
                        layoutParams.width = i4;
                        layoutParams.height = iMin;
                        view.setLayoutParams(layoutParams);
                        SizeNotifierFrameLayout sizeNotifierFrameLayout = this.sizeNotifierLayout;
                        if (sizeNotifierFrameLayout != null) {
                            int i5 = this.emojiPadding;
                            this.emojiPadding = layoutParams.height;
                            sizeNotifierFrameLayout.requestLayout();
                            onWindowSizeChanged();
                            if (this.smoothKeyboard && !this.keyboardVisible && i5 != this.emojiPadding && pannelAnimationEnabled()) {
                                AnimatorSet animatorSet = new AnimatorSet();
                                this.panelAnimation = animatorSet;
                                animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, this.emojiPadding - i5, 0.0f));
                                this.panelAnimation.setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator);
                                this.panelAnimation.setDuration(250L);
                                this.panelAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.51
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animator) {
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
        if (this.lastSizeChangeValue1 == i && this.lastSizeChangeValue2 == z) {
            onWindowSizeChanged();
            return;
        }
        this.lastSizeChangeValue1 = i;
        this.lastSizeChangeValue2 = z;
        boolean z3 = this.keyboardVisible;
        boolean z4 = i > 0;
        this.keyboardVisible = z4;
        if (z4 && isPopupShowing() && this.stickersExpansionAnim == null) {
            showPopup(0, this.currentPopupContentType);
        }
        if (this.emojiPadding != 0 && !(z2 = this.keyboardVisible) && z2 != z3 && !isPopupShowing()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public MessageObject getThreadMessage() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity != null) {
            return chatActivity.getThreadMessage();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getThreadMessageId() {
        ChatActivity chatActivity = this.parentFragment;
        if (chatActivity == null || chatActivity.getThreadMessage() == null) {
            return 0L;
        }
        return this.parentFragment.getThreadMessage().getId();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        TLRPC$ChatFull tLRPC$ChatFull;
        TLRPC$Chat chat;
        int i3;
        if (i == NotificationCenter.emojiDidLoad) {
            EmojiView emojiView = this.emojiView;
            if (emojiView != null) {
                emojiView.invalidateViews();
            }
            BotKeyboardView botKeyboardView = this.botKeyboardView;
            if (botKeyboardView != null) {
                botKeyboardView.invalidateViews();
                return;
            }
            return;
        }
        if (i == NotificationCenter.recordProgressChanged) {
            if (((Integer) objArr[0]).intValue() != this.recordingGuid) {
                return;
            }
            if (this.recordInterfaceState != 0 && !this.wasSendTyping && !isInScheduleMode()) {
                this.wasSendTyping = true;
                MessagesController messagesController = this.accountInstance.getMessagesController();
                long j = this.dialog_id;
                long threadMessageId = getThreadMessageId();
                ImageView imageView = this.videoSendButton;
                messagesController.sendTyping(j, threadMessageId, (imageView == null || imageView.getTag() == null) ? 1 : 7, 0);
            }
            RecordCircle recordCircle = this.recordCircle;
            if (recordCircle != null) {
                recordCircle.setAmplitude(((Double) objArr[1]).doubleValue());
                return;
            }
            return;
        }
        if (i == NotificationCenter.closeChats) {
            EditTextCaption editTextCaption = this.messageEditText;
            if (editTextCaption == null || !editTextCaption.isFocused()) {
                return;
            }
            AndroidUtilities.hideKeyboard(this.messageEditText);
            return;
        }
        int i4 = 4;
        if (i == NotificationCenter.recordStartError || i == NotificationCenter.recordStopped) {
            if (((Integer) objArr[0]).intValue() != this.recordingGuid) {
                return;
            }
            if (this.recordingAudioVideo) {
                this.recordingAudioVideo = false;
                if (i == NotificationCenter.recordStopped) {
                    Integer num = (Integer) objArr[1];
                    if (num.intValue() != 4) {
                        if (isInVideoMode() && num.intValue() == 5) {
                            i4 = 1;
                        } else if (num.intValue() == 0) {
                            i4 = 5;
                        } else {
                            i4 = num.intValue() == 6 ? 2 : 3;
                        }
                    }
                    if (i4 != 3) {
                        updateRecordIntefrace(i4);
                    }
                } else {
                    updateRecordIntefrace(2);
                }
            }
            if (i == NotificationCenter.recordStopped) {
                return;
            }
            return;
        }
        if (i == NotificationCenter.recordStarted) {
            if (((Integer) objArr[0]).intValue() != this.recordingGuid) {
                return;
            }
            boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
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
        if (i == NotificationCenter.audioDidSent) {
            if (((Integer) objArr[0]).intValue() != this.recordingGuid) {
                return;
            }
            Object obj = objArr[1];
            if (obj instanceof VideoEditedInfo) {
                this.videoToSendMessageObject = (VideoEditedInfo) obj;
                String str = (String) objArr[2];
                this.audioToSendPath = str;
                ArrayList<Bitmap> arrayList = (ArrayList) objArr[3];
                this.videoTimelineView.setVideoPath(str);
                this.videoTimelineView.setKeyframes(arrayList);
                this.videoTimelineView.setVisibility(0);
                this.videoTimelineView.setMinProgressDiff(1000.0f / this.videoToSendMessageObject.estimatedDuration);
                updateRecordIntefrace(3);
                checkSendButton(false);
                return;
            }
            TLRPC$TL_document tLRPC$TL_document = (TLRPC$TL_document) objArr[1];
            this.audioToSend = tLRPC$TL_document;
            this.audioToSendPath = (String) objArr[2];
            if (tLRPC$TL_document != null) {
                if (this.recordedAudioPanel == null) {
                    return;
                }
                TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                tLRPC$TL_message.out = true;
                tLRPC$TL_message.id = 0L;
                tLRPC$TL_message.peer_id = new TLRPC$TL_peerUser();
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                TLRPC$Peer tLRPC$Peer = tLRPC$TL_message.peer_id;
                int clientUserId = UserConfig.getInstance(this.currentAccount).getClientUserId();
                tLRPC$TL_peerUser.user_id = clientUserId;
                tLRPC$Peer.user_id = clientUserId;
                tLRPC$TL_message.date = (int) (System.currentTimeMillis() / 1000);
                tLRPC$TL_message.message = BuildConfig.FLAVOR;
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
                int i5 = 0;
                while (true) {
                    if (i5 >= this.audioToSend.attributes.size()) {
                        i3 = 0;
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.audioToSend.attributes.get(i5);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeAudio) {
                        i3 = tLRPC$DocumentAttribute.duration;
                        break;
                    }
                    i5++;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= this.audioToSend.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute2 = this.audioToSend.attributes.get(i6);
                    if (tLRPC$DocumentAttribute2 instanceof TLRPC$TL_documentAttributeAudio) {
                        byte[] bArr = tLRPC$DocumentAttribute2.waveform;
                        if (bArr == null || bArr.length == 0) {
                            tLRPC$DocumentAttribute2.waveform = MediaController.getInstance().getWaveform(this.audioToSendPath);
                        }
                        this.recordedAudioSeekBar.setWaveform(tLRPC$DocumentAttribute2.waveform);
                    } else {
                        i6++;
                    }
                }
                this.recordedAudioTimeTextView.setText(AndroidUtilities.formatShortDuration(i3));
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
        if (i == NotificationCenter.audioRouteChanged) {
            if (this.parentActivity != null) {
                this.parentActivity.setVolumeControlStream(((Boolean) objArr[0]).booleanValue() ? 0 : Integer.MIN_VALUE);
                return;
            }
            return;
        }
        if (i == NotificationCenter.messagePlayingDidReset) {
            if (this.audioToSendMessageObject == null || MediaController.getInstance().isPlayingMessage(this.audioToSendMessageObject)) {
                return;
            }
            this.playPauseDrawable.setIcon(0, true);
            this.recordedAudioPlayButton.setContentDescription(LocaleController.getString("AccActionPlay", R.string.AccActionPlay));
            this.recordedAudioSeekBar.setProgress(0.0f);
            return;
        }
        if (i == NotificationCenter.messagePlayingProgressDidChanged) {
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
        if (i == NotificationCenter.featuredStickersDidLoad) {
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
            if (i == NotificationCenter.messageReceivedByServer) {
                if (((Boolean) objArr[6]).booleanValue() || ((Long) objArr[3]).longValue() != this.dialog_id || (tLRPC$ChatFull = this.info) == null || tLRPC$ChatFull.slowmode_seconds == 0 || (chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(this.info.id))) == null || ChatObject.hasAdminRights(chat)) {
                    return;
                }
                TLRPC$ChatFull tLRPC$ChatFull2 = this.info;
                int currentTime = ConnectionsManager.getInstance(this.currentAccount).getCurrentTime();
                TLRPC$ChatFull tLRPC$ChatFull3 = this.info;
                tLRPC$ChatFull2.slowmode_next_send_date = currentTime + tLRPC$ChatFull3.slowmode_seconds;
                tLRPC$ChatFull3.flags |= MessagesController.UPDATE_MASK_CHAT_MUTE;
                setSlowModeTimer(tLRPC$ChatFull3.slowmode_next_send_date);
                return;
            }
            if (i == NotificationCenter.sendingMessagesChanged) {
                if (this.info != null) {
                    updateSlowModeText();
                }
            } else if (i == NotificationCenter.audioRecordTooShort) {
                updateRecordIntefrace(4);
            }
        }
    }

    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i != 2 || this.pendingLocationButton == null) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
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
            ((ObjectAnimator) animatorSet.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$checkStickresExpandHeight$34(valueAnimator);
                }
            });
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.52
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
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
        ((ObjectAnimator) animatorSet2.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$checkStickresExpandHeight$35(valueAnimator);
            }
        });
        animatorSet2.setDuration(300L);
        animatorSet2.setInterpolator(CubicBezierInterpolator.DEFAULT);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.53
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                ChatActivityEnterView.this.stickersExpansionAnim = null;
                ChatActivityEnterView.this.emojiView.setLayerType(0, null);
            }
        });
        this.stickersExpansionAnim = animatorSet2;
        this.emojiView.setLayerType(2, null);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkStickresExpandHeight$34(ValueAnimator valueAnimator) {
        this.sizeNotifierLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkStickresExpandHeight$35(ValueAnimator valueAnimator) {
        this.sizeNotifierLayout.invalidate();
    }

    public void setStickersExpanded(boolean z, boolean z2, boolean z3) {
        AdjustPanLayoutHelper adjustPanLayoutHelper = this.adjustPanLayoutHelper;
        if ((adjustPanLayoutHelper != null && adjustPanLayoutHelper.animationInProgress()) || this.waitingForKeyboardOpenAfterAnimation || this.emojiView == null) {
            return;
        }
        if (z3 || this.stickersExpanded != z) {
            this.stickersExpanded = z;
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
                if (z2) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, -(this.stickersExpandedHeight - i)), ObjectAnimator.ofFloat(this.stickersArrow, "animationProgress", 1.0f));
                    animatorSet.setDuration(300L);
                    animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    ((ObjectAnimator) animatorSet.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda5
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$setStickersExpanded$36(i, valueAnimator);
                        }
                    });
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.54
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
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
                if (z2) {
                    this.closeAnimationInProgress = true;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(ObjectAnimator.ofInt(this, (Property<ChatActivityEnterView, Integer>) this.roundedTranslationYProperty, 0), ObjectAnimator.ofInt(this.emojiView, (Property<EmojiView, Integer>) this.roundedTranslationYProperty, 0), ObjectAnimator.ofFloat(this.stickersArrow, "animationProgress", 0.0f));
                    animatorSet2.setDuration(300L);
                    animatorSet2.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    ((ObjectAnimator) animatorSet2.getChildAnimations().get(0)).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ChatActivityEnterView$$ExternalSyntheticLambda4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.f$0.lambda$setStickersExpanded$37(i, valueAnimator);
                        }
                    });
                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ChatActivityEnterView.55
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) throws Resources.NotFoundException {
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
            if (z) {
                this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrCollapsePanel", R.string.AccDescrCollapsePanel));
            } else {
                this.expandStickersButton.setContentDescription(LocaleController.getString("AccDescrExpandPanel", R.string.AccDescrExpandPanel));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStickersExpanded$36(int i, ValueAnimator valueAnimator) {
        this.stickersExpansionProgress = Math.abs(getTranslationY() / (-(this.stickersExpandedHeight - i)));
        this.sizeNotifierLayout.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setStickersExpanded$37(int i, ValueAnimator valueAnimator) {
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

    public boolean panelAnimationInProgress() {
        return this.panelAnimation != null;
    }

    public float getTopViewTranslation() {
        View view = this.topView;
        if (view == null || view.getVisibility() == 8) {
            return 0.0f;
        }
        return this.topView.getTranslationY();
    }

    public void runEmojiPanelAnimation() {
        AndroidUtilities.cancelRunOnUIThread(this.runEmojiPanelAnimation);
        this.runEmojiPanelAnimation.run();
    }

    public Drawable getStickersArrowDrawable() {
        return this.stickersArrow;
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
        public void setAlpha(int i) {
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
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                setPressed(false);
            }
            if (this.cancelToProgress == 0.0f || !isEnabled()) {
                return false;
            }
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 0) {
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
            if (motionEvent.getAction() == 2 && !this.cancelRect.contains(x, y)) {
                setPressed(false);
                return false;
            }
            if (motionEvent.getAction() == 1 && this.cancelRect.contains(x, y)) {
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
            this.bluePaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.arrowPaint.setColor(Theme.getColor(Theme.key_chat_messagePanelIcons));
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
            this.grayPaint.setColor(Theme.getColor(Theme.key_chat_recordTime));
            TextPaint textPaint = this.bluePaint;
            int i = Theme.key_chat_recordVoiceCancel;
            textPaint.setColor(Theme.getColor(i));
            this.slideToAlpha = this.grayPaint.getAlpha();
            this.cancelAlpha = this.bluePaint.getAlpha();
            Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(60.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor(i), 26));
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
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            this.slideToCancelWidth = this.grayPaint.measureText(this.slideToCancelString);
            this.cancelWidth = this.bluePaint.measureText(this.cancelString);
            this.lastUpdateTime = System.currentTimeMillis();
            int measuredHeight = getMeasuredHeight() >> 1;
            this.arrowPath.reset();
            if (this.smallSize) {
                float f = measuredHeight;
                this.arrowPath.setLastPoint(AndroidUtilities.dpf2(2.5f), f - AndroidUtilities.dpf2(3.12f));
                this.arrowPath.lineTo(0.0f, f);
                this.arrowPath.lineTo(AndroidUtilities.dpf2(2.5f), f + AndroidUtilities.dpf2(3.12f));
            } else {
                float f2 = measuredHeight;
                this.arrowPath.setLastPoint(AndroidUtilities.dpf2(4.0f), f2 - AndroidUtilities.dpf2(5.0f));
                this.arrowPath.lineTo(0.0f, f2);
                this.arrowPath.lineTo(AndroidUtilities.dpf2(4.0f), f2 + AndroidUtilities.dpf2(5.0f));
            }
            this.slideToLayout = new StaticLayout(this.slideToCancelString, this.grayPaint, (int) this.slideToCancelWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.cancelLayout = new StaticLayout(this.cancelString, this.bluePaint, (int) this.cancelWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            StaticLayout staticLayout;
            if (this.slideToLayout == null || (staticLayout = this.cancelLayout) == null) {
                return;
            }
            int width = staticLayout.getWidth() + AndroidUtilities.dp(16.0f);
            this.grayPaint.setColor(Theme.getColor(Theme.key_chat_recordTime));
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
        public void setCancelToProgress(float f) {
            this.cancelToProgress = f;
        }

        @Keep
        public float getSlideToCancelWidth() {
            return this.slideToCancelWidth;
        }

        public void setSlideX(float f) {
            this.slideProgress = f;
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
            textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
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
            this.textPaint.setColor(Theme.getColor(Theme.key_chat_recordTime));
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

    public RecordCircle getRecordCircle() {
        return this.recordCircle;
    }

    public void setChatSearchExpandOffset(float f) {
        this.chatSearchExpandOffset = f;
        invalidate();
    }

    public CharSequence getDraftMessage() {
        if (this.editingMessageObject != null) {
            if (TextUtils.isEmpty(this.draftMessage)) {
                return null;
            }
            return this.draftMessage;
        }
        if (this.messageEditText == null || !hasText()) {
            return null;
        }
        return this.messageEditText.getText();
    }

    public void setTextTransitionIsRunning(boolean z) {
        this.textTransitionIsRunning = z;
        this.sendButtonContainer.invalidate();
    }

    public float getTopViewHeight() {
        View view = this.topView;
        if (view == null || view.getVisibility() != 0) {
            return 0.0f;
        }
        return this.topView.getLayoutParams().height;
    }
}
