package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.messenger.support.LongSparseIntArray;
import ir.eitaa.messenger.voip.NativeInstance;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$GroupCall;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCall;
import ir.eitaa.tgnet.TLRPC$TL_groupCallDiscarded;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputUser;
import ir.eitaa.tgnet.TLRPC$TL_messages_exportChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_phone_createGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_discardGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_exportGroupCallInvite;
import ir.eitaa.tgnet.TLRPC$TL_phone_exportedGroupCallInvite;
import ir.eitaa.tgnet.TLRPC$TL_phone_inviteToGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_saveDefaultGroupCallJoinAs;
import ir.eitaa.tgnet.TLRPC$TL_phone_startScheduledGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_toggleGroupCallSettings;
import ir.eitaa.tgnet.TLRPC$TL_phone_toggleGroupCallStartSubscription;
import ir.eitaa.tgnet.TLRPC$TL_photos_photo;
import ir.eitaa.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhoto;
import ir.eitaa.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.AccountSelectCell;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.GroupCallInvitedCell;
import ir.eitaa.ui.Cells.GroupCallTextCell;
import ir.eitaa.ui.Cells.GroupCallUserCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.AudioPlayerAlert;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.BlobDrawable;
import ir.eitaa.ui.Components.CheckBoxSquare;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.FillLastGridLayoutManager;
import ir.eitaa.ui.Components.GroupCallFullscreenAdapter;
import ir.eitaa.ui.Components.GroupCallPip;
import ir.eitaa.ui.Components.GroupCallRecordAlert;
import ir.eitaa.ui.Components.GroupVoipInviteAlert;
import ir.eitaa.ui.Components.HintView;
import ir.eitaa.ui.Components.ImageUpdater;
import ir.eitaa.ui.Components.JoinCallAlert;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.NumberPicker;
import ir.eitaa.ui.Components.ProfileGalleryView;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.RecordStatusDrawable;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.Components.UndoView;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;
import ir.eitaa.ui.Components.voip.GroupCallGridCell;
import ir.eitaa.ui.Components.voip.GroupCallMiniTextureView;
import ir.eitaa.ui.Components.voip.GroupCallRenderersContainer;
import ir.eitaa.ui.Components.voip.GroupCallStatusIcon;
import ir.eitaa.ui.Components.voip.PrivateVideoPreviewDialog;
import ir.eitaa.ui.Components.voip.VoIPToggleButton;
import ir.eitaa.ui.GroupCallActivity;
import ir.eitaa.ui.PinchToZoomHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.linphone.mediastream.Factory;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes3.dex */
public class GroupCallActivity extends BottomSheet implements NotificationCenter.NotificationCenterDelegate, VoIPService.StateListener {
    public static final Property<GroupCallActivity, Float> COLOR_PROGRESS = new AnimationProperties.FloatProperty<GroupCallActivity>("colorProgress") { // from class: ir.eitaa.ui.GroupCallActivity.2
        @Override // ir.eitaa.ui.Components.AnimationProperties.FloatProperty
        public void setValue(GroupCallActivity object, float value) {
            object.setColorProgress(value);
        }

        @Override // android.util.Property
        public Float get(GroupCallActivity object) {
            return Float.valueOf(object.getColorProgress());
        }
    };
    public static GroupCallActivity groupCallInstance;
    public static boolean groupCallUiVisible;
    public static boolean isLandscapeMode;
    public static boolean isTabletMode;
    public static boolean paused;
    private View accountGap;
    private AccountInstance accountInstance;
    private AccountSelectCell accountSelectCell;
    private ActionBar actionBar;
    private AnimatorSet actionBarAnimation;
    private View actionBarBackground;
    private View actionBarShadow;
    private ActionBarMenuSubItem adminItem;
    private float amplitude;
    private float animateAmplitudeDiff;
    boolean animateButtonsOnNextLayout;
    private float animateToAmplitude;
    private boolean anyEnterEventSent;
    private final ArrayList<GroupCallMiniTextureView> attachedRenderers;
    private final ArrayList<GroupCallMiniTextureView> attachedRenderersTmp;
    private final AvatarPreviewPagerIndicator avatarPagerIndicator;
    private final FrameLayout avatarPreviewContainer;
    private boolean avatarPriviewTransitionInProgress;
    AvatarUpdaterDelegate avatarUpdaterDelegate;
    private boolean avatarsPreviewShowed;
    private final ProfileGalleryView avatarsViewPager;
    private int backgroundColor;
    private RLottieDrawable bigMicDrawable;
    private final BlobDrawable bigWaveDrawable;
    private View blurredView;
    private HashMap<View, Float> buttonsAnimationParamsX;
    private HashMap<View, Float> buttonsAnimationParamsY;
    private GradientDrawable buttonsBackgroundGradient;
    private final View buttonsBackgroundGradientView;
    private final View buttonsBackgroundGradientView2;
    private FrameLayout buttonsContainer;
    private int buttonsVisibility;
    public ChatObject.Call call;
    private boolean callInitied;
    private VoIPToggleButton cameraButton;
    private float cameraButtonScale;
    public CellFlickerDrawable cellFlickerDrawable;
    private boolean changingPermissions;
    private float colorProgress;
    private final int[] colorsTmp;
    private boolean contentFullyOverlayed;
    private long creatingServiceTime;
    ImageUpdater currentAvatarUpdater;
    private int currentCallState;
    public TLRPC$Chat currentChat;
    private ViewGroup currentOptionsLayout;
    private WeavingState currentState;
    private boolean delayedGroupCallUpdated;
    private DiffUtil.Callback diffUtilsCallback;
    private boolean drawSpeakingSubtitle;
    public boolean drawingForBlur;
    private ActionBarMenuSubItem editTitleItem;
    private boolean enterEventSent;
    private ActionBarMenuSubItem everyoneItem;
    private VoIPToggleButton flipButton;
    private final RLottieDrawable flipIcon;
    private int flipIconCurrentEndFrame;
    GroupCallFullscreenAdapter fullscreenAdapter;
    private final DefaultItemAnimator fullscreenListItemAnimator;
    RecyclerListView fullscreenUsersListView;
    private int[] gradientColors;
    private GroupVoipInviteAlert groupVoipInviteAlert;
    private RLottieDrawable handDrawables;
    private boolean hasScrimAnchorView;
    private boolean hasVideo;
    private boolean invalidateColors;
    private ActionBarMenuSubItem inviteItem;
    private String[] invites;
    private GroupCallItemAnimator itemAnimator;
    private long lastUpdateTime;
    private FillLastGridLayoutManager layoutManager;
    private Paint leaveBackgroundPaint;
    private VoIPToggleButton leaveButton;
    private ActionBarMenuSubItem leaveItem;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private Paint listViewBackgroundPaint;
    private boolean listViewVideoVisibility;
    private final LinearLayout menuItemsContainer;
    private RLottieImageView muteButton;
    private ValueAnimator muteButtonAnimator;
    private int muteButtonState;
    private TextView[] muteLabel;
    private ActionBarMenuSubItem noiseItem;
    private int oldAddMemberRow;
    private int oldCount;
    private ArrayList<Long> oldInvited;
    private int oldInvitedEndRow;
    private int oldInvitedStartRow;
    private ArrayList<TLRPC$TL_groupCallParticipant> oldParticipants;
    private int oldUsersEndRow;
    private int oldUsersStartRow;
    private int oldUsersVideoEndRow;
    private int oldUsersVideoStartRow;
    private int oldVideoDividerRow;
    private int oldVideoNotAvailableRow;
    private ArrayList<ChatObject.VideoParticipant> oldVideoParticipants;
    private ActionBarMenuItem otherItem;
    private Paint paint;
    private Paint paintTmp;
    private LaunchActivity parentActivity;
    private ActionBarMenuSubItem permissionItem;
    PinchToZoomHelper pinchToZoomHelper;
    private ActionBarMenuItem pipItem;
    private boolean playingHandAnimation;
    private int popupAnimationIndex;
    private Runnable pressRunnable;
    private boolean pressed;
    private WeavingState prevState;
    PrivateVideoPreviewDialog previewDialog;
    private boolean previewTextureTransitionEnabled;
    private float progressToAvatarPreview;
    float progressToHideUi;
    private RadialGradient radialGradient;
    private final Matrix radialMatrix;
    private final Paint radialPaint;
    private RadialProgressView radialProgressView;
    private RecordCallDrawable recordCallDrawable;
    private HintView recordHintView;
    private ActionBarMenuSubItem recordItem;
    private RectF rect;
    private HintView reminderHintView;
    private GroupCallRenderersContainer renderersContainer;
    ViewTreeObserver.OnPreDrawListener requestFullscreenListener;
    private ValueAnimator scheduleAnimator;
    private TextView scheduleButtonTextView;
    private float scheduleButtonsScale;
    private boolean scheduleHasFewPeers;
    private TextView scheduleInfoTextView;
    private TLRPC$InputPeer schedulePeer;
    private int scheduleStartAt;
    private SimpleTextView scheduleStartAtTextView;
    private SimpleTextView scheduleStartInTextView;
    private SimpleTextView scheduleTimeTextView;
    private LinearLayout scheduleTimerContainer;
    private boolean scheduled;
    private String scheduledHash;
    private ActionBarMenuSubItem screenItem;
    private ActionBarMenuItem screenShareItem;
    private AnimatorSet scrimAnimatorSet;
    private GroupCallFullscreenAdapter.GroupCallUserCell scrimFullscreenView;
    private GroupCallGridCell scrimGridView;
    private Paint scrimPaint;
    private View scrimPopupLayout;
    private ActionBarPopupWindow scrimPopupWindow;
    private GroupCallMiniTextureView scrimRenderer;
    private GroupCallUserCell scrimView;
    private boolean scrimViewAttached;
    private float scrollOffsetY;
    private TLRPC$Peer selfPeer;
    private int shaderBitmapSize;
    private Drawable shadowDrawable;
    private ShareAlert shareAlert;
    private float showLightingProgress;
    private float showWavesProgress;
    private VoIPToggleButton soundButton;
    private float soundButtonScale;
    private ActionBarMenuSubItem soundItem;
    private View soundItemDivider;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;
    private boolean startingGroupCall;
    private WeavingState[] states;
    public final ArrayList<GroupCallStatusIcon> statusIconPool;
    ObjectAnimator subtitleYAnimator;
    private float switchProgress;
    private float switchToButtonInt2;
    private float switchToButtonProgress;
    GroupCallTabletGridAdapter tabletGridAdapter;
    RecyclerListView tabletVideoGridView;
    private final BlobDrawable tinyWaveDrawable;
    private AudioPlayerAlert.ClippingTextViewSwitcher titleTextView;
    private UndoView[] undoView;
    private Runnable unmuteRunnable;
    private Runnable updateCallRecordRunnable;
    private Runnable updateSchedeulRunnable;
    private boolean useBlur;
    private TLObject userSwitchObject;
    LongSparseIntArray visiblePeerIds;
    public final ArrayList<ChatObject.VideoParticipant> visibleVideoParticipants;

    public static boolean isGradientState(int state) {
        return state == 2 || state == 4 || state == 5 || state == 6 || state == 7;
    }

    static /* synthetic */ void lambda$processSelectedOption$56(DialogInterface dialogInterface) {
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onMediaStateUpdated(int i, int i2) {
        VoIPService.StateListener.CC.$default$onMediaStateUpdated(this, i, i2);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onScreenOnChange(boolean z) {
        VoIPService.StateListener.CC.$default$onScreenOnChange(this, z);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onSignalBarsCountChanged(int i) {
        VoIPService.StateListener.CC.$default$onSignalBarsCountChanged(this, i);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onVideoAvailableChange(boolean z) {
        VoIPService.StateListener.CC.$default$onVideoAvailableChange(this, z);
    }

    static /* synthetic */ float access$10316(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.amplitude + f;
        groupCallActivity.amplitude = f2;
        return f2;
    }

    static /* synthetic */ float access$13116(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.switchProgress + f;
        groupCallActivity.switchProgress = f2;
        return f2;
    }

    static /* synthetic */ float access$13716(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.showWavesProgress + f;
        groupCallActivity.showWavesProgress = f2;
        return f2;
    }

    static /* synthetic */ float access$13724(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.showWavesProgress - f;
        groupCallActivity.showWavesProgress = f2;
        return f2;
    }

    static /* synthetic */ float access$13816(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.showLightingProgress + f;
        groupCallActivity.showLightingProgress = f2;
        return f2;
    }

    static /* synthetic */ float access$13824(GroupCallActivity groupCallActivity, float f) {
        float f2 = groupCallActivity.showLightingProgress - f;
        groupCallActivity.showLightingProgress = f2;
        return f2;
    }

    static /* synthetic */ void lambda$new$0() {
        if (VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().setMicMute(false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$GroupCallActivity() throws InterruptedException {
        if (this.call == null || !this.scheduled || VoIPService.getSharedInstance() == null) {
            return;
        }
        this.muteButton.performHapticFeedback(3, 2);
        updateMuteButton(1, true);
        AndroidUtilities.runOnUIThread(this.unmuteRunnable, 80L);
        this.scheduled = false;
        this.pressed = true;
    }

    private static class SmallRecordCallDrawable extends Drawable {
        private long lastUpdateTime;
        private View parentView;
        private int state;
        private Paint paint2 = new Paint(1);
        private float alpha = 1.0f;

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

        public SmallRecordCallDrawable(View parent) {
            this.parentView = parent;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return AndroidUtilities.dp(24.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return AndroidUtilities.dp(24.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int iDp;
            int iCenterX = getBounds().centerX();
            int iCenterY = getBounds().centerY();
            if (this.parentView instanceof SimpleTextView) {
                iDp = iCenterY + AndroidUtilities.dp(1.0f);
                iCenterX -= AndroidUtilities.dp(3.0f);
            } else {
                iDp = iCenterY + AndroidUtilities.dp(2.0f);
            }
            this.paint2.setColor(-1147527);
            this.paint2.setAlpha((int) (this.alpha * 255.0f));
            canvas.drawCircle(iCenterX, iDp, AndroidUtilities.dp(4.0f), this.paint2);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.lastUpdateTime;
            if (j > 17) {
                j = 17;
            }
            this.lastUpdateTime = jElapsedRealtime;
            int i = this.state;
            if (i == 0) {
                float f = this.alpha + (j / 2000.0f);
                this.alpha = f;
                if (f >= 1.0f) {
                    this.alpha = 1.0f;
                    this.state = 1;
                }
            } else if (i == 1) {
                float f2 = this.alpha - (j / 2000.0f);
                this.alpha = f2;
                if (f2 < 0.5f) {
                    this.alpha = 0.5f;
                    this.state = 0;
                }
            }
            this.parentView.invalidate();
        }
    }

    private static class RecordCallDrawable extends Drawable {
        private long lastUpdateTime;
        private View parentView;
        private boolean recording;
        private int state;
        private Paint paint = new Paint(1);
        private Paint paint2 = new Paint(1);
        private float alpha = 1.0f;

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

        public RecordCallDrawable() {
            this.paint.setColor(-1);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(AndroidUtilities.dp(1.5f));
        }

        public void setParentView(View view) {
            this.parentView = view;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return AndroidUtilities.dp(24.0f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return AndroidUtilities.dp(24.0f);
        }

        public void setRecording(boolean value) {
            this.recording = value;
            this.alpha = 1.0f;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            float fCenterX = getBounds().centerX();
            float fCenterY = getBounds().centerY();
            canvas.drawCircle(fCenterX, fCenterY, AndroidUtilities.dp(10.0f), this.paint);
            this.paint2.setColor(this.recording ? -1147527 : -1);
            this.paint2.setAlpha((int) (this.alpha * 255.0f));
            canvas.drawCircle(fCenterX, fCenterY, AndroidUtilities.dp(5.0f), this.paint2);
            if (this.recording) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.lastUpdateTime;
                if (j > 17) {
                    j = 17;
                }
                this.lastUpdateTime = jElapsedRealtime;
                int i = this.state;
                if (i == 0) {
                    float f = this.alpha + (j / 2000.0f);
                    this.alpha = f;
                    if (f >= 1.0f) {
                        this.alpha = 1.0f;
                        this.state = 1;
                    }
                } else if (i == 1) {
                    float f2 = this.alpha - (j / 2000.0f);
                    this.alpha = f2;
                    if (f2 < 0.5f) {
                        this.alpha = 0.5f;
                        this.state = 0;
                    }
                }
                this.parentView.invalidate();
            }
        }
    }

    private class VolumeSlider extends FrameLayout {
        private boolean captured;
        private float colorChangeProgress;
        private int currentColor;
        private TLRPC$TL_groupCallParticipant currentParticipant;
        private double currentProgress;
        private boolean dragging;
        private RLottieImageView imageView;
        private long lastUpdateTime;
        private int oldColor;
        private Paint paint;
        private Paint paint2;
        private Path path;
        private float[] radii;
        private RectF rect;
        private RLottieDrawable speakerDrawable;
        private float sx;
        private float sy;
        private TextView textView;
        private int thumbX;
        private float[] volumeAlphas;

        public VolumeSlider(Context context, TLRPC$TL_groupCallParticipant participant) throws InterruptedException {
            super(context);
            this.paint = new Paint(1);
            this.paint2 = new Paint(1);
            this.path = new Path();
            this.radii = new float[8];
            this.rect = new RectF();
            this.volumeAlphas = new float[3];
            setWillNotDraw(false);
            this.currentParticipant = participant;
            this.currentProgress = ChatObject.getParticipantVolume(participant) / 20000.0f;
            this.colorChangeProgress = 1.0f;
            setPadding(AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f), 0);
            this.speakerDrawable = new RLottieDrawable(R.raw.speaker, "2131624026", AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), true, (int[]) null);
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.setAnimation(this.speakerDrawable);
            this.imageView.setTag(this.currentProgress == 0.0d ? 1 : null);
            addView(this.imageView, LayoutHelper.createFrame(-2, 40.0f, (LocaleController.isRTL ? 5 : 3) | 16, 0.0f, 0.0f, 0.0f, 0.0f));
            this.speakerDrawable.setCustomEndFrame(this.currentProgress == 0.0d ? 17 : 34);
            RLottieDrawable rLottieDrawable = this.speakerDrawable;
            rLottieDrawable.setCurrentFrame(rLottieDrawable.getCustomEndFrame() - 1, false, true);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(3);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            this.textView.setTextSize(1, 16.0f);
            double participantVolume = ChatObject.getParticipantVolume(this.currentParticipant);
            Double.isNaN(participantVolume);
            double d = participantVolume / 100.0d;
            TextView textView2 = this.textView;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf((int) (d > 0.0d ? Math.max(d, 1.0d) : 0.0d));
            textView2.setText(String.format(locale, "%d%%", objArr));
            this.textView.setPadding(LocaleController.isRTL ? 0 : AndroidUtilities.dp(43.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(43.0f) : 0, 0);
            addView(this.textView, LayoutHelper.createFrame(-2, -2, (LocaleController.isRTL ? 5 : 3) | 16));
            this.paint2.setStyle(Paint.Style.STROKE);
            this.paint2.setStrokeWidth(AndroidUtilities.dp(1.5f));
            this.paint2.setStrokeCap(Paint.Cap.ROUND);
            this.paint2.setColor(-1);
            double participantVolume2 = ChatObject.getParticipantVolume(this.currentParticipant);
            Double.isNaN(participantVolume2);
            int i = (int) (participantVolume2 / 100.0d);
            int i2 = 0;
            while (true) {
                float[] fArr = this.volumeAlphas;
                if (i2 >= fArr.length) {
                    return;
                }
                if (i > (i2 == 0 ? 0 : i2 == 1 ? 50 : ImageReceiver.DEFAULT_CROSSFADE_DURATION)) {
                    fArr[i2] = 1.0f;
                } else {
                    fArr[i2] = 0.0f;
                }
                i2++;
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
            double size = View.MeasureSpec.getSize(widthMeasureSpec);
            double d = this.currentProgress;
            Double.isNaN(size);
            this.thumbX = (int) (size * d);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            return onTouch(ev);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            return onTouch(event);
        }

        boolean onTouch(MotionEvent ev) throws InterruptedException {
            if (ev.getAction() == 0) {
                this.sx = ev.getX();
                this.sy = ev.getY();
                return true;
            }
            if (ev.getAction() == 1 || ev.getAction() == 3) {
                this.captured = false;
                if (ev.getAction() == 1) {
                    if (Math.abs(ev.getY() - this.sy) < ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                        int x = (int) ev.getX();
                        this.thumbX = x;
                        if (x < 0) {
                            this.thumbX = 0;
                        } else if (x > getMeasuredWidth()) {
                            this.thumbX = getMeasuredWidth();
                        }
                        this.dragging = true;
                    }
                }
                if (this.dragging) {
                    if (ev.getAction() == 1) {
                        double d = this.thumbX;
                        double measuredWidth = getMeasuredWidth();
                        Double.isNaN(d);
                        Double.isNaN(measuredWidth);
                        onSeekBarDrag(d / measuredWidth, true);
                    }
                    this.dragging = false;
                    invalidate();
                    return true;
                }
            } else if (ev.getAction() == 2) {
                if (!this.captured) {
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
                    if (Math.abs(ev.getY() - this.sy) <= viewConfiguration.getScaledTouchSlop() && Math.abs(ev.getX() - this.sx) > viewConfiguration.getScaledTouchSlop()) {
                        this.captured = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        if (ev.getY() >= 0.0f && ev.getY() <= getMeasuredHeight()) {
                            int x2 = (int) ev.getX();
                            this.thumbX = x2;
                            if (x2 < 0) {
                                this.thumbX = 0;
                            } else if (x2 > getMeasuredWidth()) {
                                this.thumbX = getMeasuredWidth();
                            }
                            this.dragging = true;
                            invalidate();
                            return true;
                        }
                    }
                } else if (this.dragging) {
                    int x3 = (int) ev.getX();
                    this.thumbX = x3;
                    if (x3 < 0) {
                        this.thumbX = 0;
                    } else if (x3 > getMeasuredWidth()) {
                        this.thumbX = getMeasuredWidth();
                    }
                    double d2 = this.thumbX;
                    double measuredWidth2 = getMeasuredWidth();
                    Double.isNaN(d2);
                    Double.isNaN(measuredWidth2);
                    onSeekBarDrag(d2 / measuredWidth2, false);
                    invalidate();
                    return true;
                }
            }
            return false;
        }

        private void onSeekBarDrag(double progress, boolean finalMove) throws InterruptedException {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            this.currentProgress = progress;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.currentParticipant;
            tLRPC$TL_groupCallParticipant.volume = (int) (progress * 20000.0d);
            tLRPC$TL_groupCallParticipant.volume_by_admin = false;
            tLRPC$TL_groupCallParticipant.flags |= 128;
            double participantVolume = ChatObject.getParticipantVolume(tLRPC$TL_groupCallParticipant);
            Double.isNaN(participantVolume);
            double d = participantVolume / 100.0d;
            TextView textView = this.textView;
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf((int) (d > 0.0d ? Math.max(d, 1.0d) : 0.0d));
            textView.setText(String.format(locale, "%d%%", objArr));
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.currentParticipant;
            sharedInstance.setParticipantVolume(tLRPC$TL_groupCallParticipant2, tLRPC$TL_groupCallParticipant2.volume);
            if (finalMove) {
                long peerId = MessageObject.getPeerId(this.currentParticipant.peer);
                TLObject user = peerId > 0 ? GroupCallActivity.this.accountInstance.getMessagesController().getUser(Long.valueOf(peerId)) : GroupCallActivity.this.accountInstance.getMessagesController().getChat(Long.valueOf(-peerId));
                if (this.currentParticipant.volume == 0) {
                    if (GroupCallActivity.this.scrimPopupWindow != null) {
                        GroupCallActivity.this.scrimPopupWindow.dismiss();
                        GroupCallActivity.this.scrimPopupWindow = null;
                    }
                    GroupCallActivity.this.dismissAvatarPreview(true);
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.processSelectedOption(this.currentParticipant, peerId, ChatObject.canManageCalls(groupCallActivity.currentChat) ? 0 : 5);
                } else {
                    VoIPService.getSharedInstance().editCallMember(user, null, null, Integer.valueOf(this.currentParticipant.volume), null, null);
                }
            }
            Integer num = this.currentProgress == 0.0d ? 1 : null;
            if ((this.imageView.getTag() != null || num == null) && (this.imageView.getTag() == null || num != null)) {
                return;
            }
            this.speakerDrawable.setCustomEndFrame(this.currentProgress == 0.0d ? 17 : 34);
            this.speakerDrawable.setCurrentFrame(this.currentProgress != 0.0d ? 17 : 0);
            this.speakerDrawable.start();
            this.imageView.setTag(num);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            int i;
            float fDp;
            int i2;
            int i3 = this.currentColor;
            double d = this.currentProgress;
            if (d < 0.25d) {
                this.currentColor = -3385513;
            } else if (d > 0.25d && d < 0.5d) {
                this.currentColor = -3562181;
            } else if (d >= 0.5d && d <= 0.75d) {
                this.currentColor = -11027349;
            } else {
                this.currentColor = -11688225;
            }
            float f = 1.0f;
            if (i3 == 0) {
                i = this.currentColor;
                this.colorChangeProgress = 1.0f;
            } else {
                int offsetColor = AndroidUtilities.getOffsetColor(this.oldColor, i3, this.colorChangeProgress, 1.0f);
                if (i3 != this.currentColor) {
                    this.colorChangeProgress = 0.0f;
                    this.oldColor = offsetColor;
                }
                i = offsetColor;
            }
            this.paint.setColor(i);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.lastUpdateTime;
            if (j > 17) {
                j = 17;
            }
            this.lastUpdateTime = jElapsedRealtime;
            float f2 = this.colorChangeProgress;
            if (f2 < 1.0f) {
                float f3 = f2 + (j / 200.0f);
                this.colorChangeProgress = f3;
                if (f3 > 1.0f) {
                    this.colorChangeProgress = 1.0f;
                } else {
                    invalidate();
                }
            }
            this.path.reset();
            float[] fArr = this.radii;
            float f4 = 6.0f;
            float fDp2 = AndroidUtilities.dp(6.0f);
            fArr[7] = fDp2;
            fArr[6] = fDp2;
            int i4 = 1;
            fArr[1] = fDp2;
            fArr[0] = fDp2;
            float fMax = this.thumbX < AndroidUtilities.dp(12.0f) ? Math.max(0.0f, (this.thumbX - AndroidUtilities.dp(6.0f)) / AndroidUtilities.dp(6.0f)) : 1.0f;
            float[] fArr2 = this.radii;
            float fDp3 = AndroidUtilities.dp(6.0f) * fMax;
            fArr2[5] = fDp3;
            fArr2[4] = fDp3;
            fArr2[3] = fDp3;
            fArr2[2] = fDp3;
            this.rect.set(0.0f, 0.0f, this.thumbX, getMeasuredHeight());
            this.path.addRoundRect(this.rect, this.radii, Path.Direction.CW);
            this.path.close();
            canvas.drawPath(this.path, this.paint);
            double participantVolume = ChatObject.getParticipantVolume(this.currentParticipant);
            Double.isNaN(participantVolume);
            int i5 = (int) (participantVolume / 100.0d);
            int left = this.imageView.getLeft() + (this.imageView.getMeasuredWidth() / 2) + AndroidUtilities.dp(5.0f);
            int top = this.imageView.getTop() + (this.imageView.getMeasuredHeight() / 2);
            int i6 = 0;
            while (i6 < this.volumeAlphas.length) {
                if (i6 == 0) {
                    fDp = AndroidUtilities.dp(f4);
                    i2 = 0;
                } else if (i6 == i4) {
                    fDp = AndroidUtilities.dp(10.0f);
                    i2 = 50;
                } else {
                    fDp = AndroidUtilities.dp(14.0f);
                    i2 = ImageReceiver.DEFAULT_CROSSFADE_DURATION;
                }
                float fDp4 = AndroidUtilities.dp(2.0f);
                float[] fArr3 = this.volumeAlphas;
                float f5 = fDp4 * (f - fArr3[i6]);
                this.paint2.setAlpha((int) (fArr3[i6] * 255.0f));
                float f6 = left;
                float f7 = top;
                this.rect.set((f6 - fDp) + f5, (f7 - fDp) + f5, (f6 + fDp) - f5, (f7 + fDp) - f5);
                int i7 = i2;
                int i8 = i6;
                canvas.drawArc(this.rect, -50.0f, 100.0f, false, this.paint2);
                if (i5 > i7) {
                    float[] fArr4 = this.volumeAlphas;
                    if (fArr4[i8] < 1.0f) {
                        fArr4[i8] = fArr4[i8] + (j / 180.0f);
                        if (fArr4[i8] > 1.0f) {
                            fArr4[i8] = 1.0f;
                        }
                        invalidate();
                    }
                } else {
                    float[] fArr5 = this.volumeAlphas;
                    if (fArr5[i8] > 0.0f) {
                        fArr5[i8] = fArr5[i8] - (j / 180.0f);
                        if (fArr5[i8] < 0.0f) {
                            fArr5[i8] = 0.0f;
                        }
                        invalidate();
                    }
                }
                i6 = i8 + 1;
                f = 1.0f;
                i4 = 1;
                f4 = 6.0f;
            }
        }
    }

    public static class WeavingState {
        public int currentState;
        private float duration;
        public Shader shader;
        private float startX;
        private float startY;
        private float time;
        private float targetX = -1.0f;
        private float targetY = -1.0f;
        private Matrix matrix = new Matrix();

        public WeavingState(int state) {
            this.currentState = state;
        }

        public void update(int top, int left, int size, long dt, float amplitude) {
            float f;
            if (this.shader == null) {
                return;
            }
            float f2 = this.duration;
            if (f2 == 0.0f || this.time >= f2) {
                this.duration = Utilities.random.nextInt(200) + 1500;
                this.time = 0.0f;
                if (this.targetX == -1.0f) {
                    setTarget();
                }
                this.startX = this.targetX;
                this.startY = this.targetY;
                setTarget();
            }
            float f3 = dt;
            float f4 = this.time + ((BlobDrawable.GRADIENT_SPEED_MIN + 0.5f) * f3) + (f3 * BlobDrawable.GRADIENT_SPEED_MAX * 2.0f * amplitude);
            this.time = f4;
            float f5 = this.duration;
            if (f4 > f5) {
                this.time = f5;
            }
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.time / f5);
            float f6 = size;
            float f7 = this.startX;
            float f8 = (left + ((f7 + ((this.targetX - f7) * interpolation)) * f6)) - 200.0f;
            float f9 = this.startY;
            float f10 = (top + (f6 * (f9 + ((this.targetY - f9) * interpolation)))) - 200.0f;
            if (GroupCallActivity.isGradientState(this.currentState)) {
                f = 1.0f;
            } else {
                f = this.currentState == 1 ? 4.0f : 2.5f;
            }
            float fDp = (AndroidUtilities.dp(122.0f) / 400.0f) * f;
            this.matrix.reset();
            this.matrix.postTranslate(f8, f10);
            this.matrix.postScale(fDp, fDp, f8 + 200.0f, f10 + 200.0f);
            this.shader.setLocalMatrix(this.matrix);
        }

        private void setTarget() {
            if (GroupCallActivity.isGradientState(this.currentState)) {
                this.targetX = ((Utilities.random.nextInt(100) * 0.2f) / 100.0f) + 0.85f;
                this.targetY = 1.0f;
            } else if (this.currentState == 1) {
                this.targetX = ((Utilities.random.nextInt(100) * 0.3f) / 100.0f) + 0.2f;
                this.targetY = ((Utilities.random.nextInt(100) * 0.3f) / 100.0f) + 0.7f;
            } else {
                this.targetX = ((Utilities.random.nextInt(100) / 100.0f) * 0.2f) + 0.8f;
                this.targetY = Utilities.random.nextInt(100) / 100.0f;
            }
        }
    }

    private void prepareBlurBitmap() {
        if (this.blurredView == null) {
            return;
        }
        int measuredWidth = (int) ((this.containerView.getMeasuredWidth() - (this.backgroundPaddingLeft * 2)) / 6.0f);
        int measuredHeight = (int) ((this.containerView.getMeasuredHeight() - AndroidUtilities.statusBarHeight) / 6.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.scale(0.16666667f, 0.16666667f);
        canvas.save();
        canvas.translate(0.0f, -AndroidUtilities.statusBarHeight);
        this.parentActivity.getActionBarLayout().draw(canvas);
        canvas.drawColor(ColorUtils.setAlphaComponent(-16777216, 76));
        canvas.restore();
        canvas.save();
        canvas.translate(this.containerView.getX(), -AndroidUtilities.statusBarHeight);
        this.drawingForBlur = true;
        this.containerView.draw(canvas);
        this.drawingForBlur = false;
        Utilities.stackBlurBitmap(bitmapCreateBitmap, Math.max(7, Math.max(measuredWidth, measuredHeight) / 180));
        this.blurredView.setBackground(new BitmapDrawable(bitmapCreateBitmap));
        this.blurredView.setAlpha(0.0f);
        this.blurredView.setVisibility(0);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean onCustomOpenAnimation() {
        groupCallUiVisible = true;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.groupCallVisibilityChanged, new Object[0]);
        GroupCallPip.updateVisibility(getContext());
        return super.onCustomOpenAnimation();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        groupCallUiVisible = false;
        GroupVoipInviteAlert groupVoipInviteAlert = this.groupVoipInviteAlert;
        if (groupVoipInviteAlert != null) {
            groupVoipInviteAlert.dismiss();
        }
        this.delayedGroupCallUpdated = true;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.groupCallVisibilityChanged, new Object[0]);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.needShowAlert);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.groupCallUpdated);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.chatInfoDidLoad);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.didLoadChatAdmins);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.applyGroupCallVisibleParticipants);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.userInfoDidLoad);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.mainUserInfoChanged);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.updateInterfaces);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.groupCallScreencastStateChanged);
        this.accountInstance.getNotificationCenter().removeObserver(this, NotificationCenter.groupCallSpeakingUsersUpdated);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didEndCall);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isStillConnecting() {
        int i = this.currentCallState;
        return i == 1 || i == 2 || i == 6 || i == 5;
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws InterruptedException {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        int i;
        String str;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2;
        int i2;
        String str2;
        String string;
        ChatObject.VideoParticipant videoParticipant;
        int i3;
        int i4;
        if (id == NotificationCenter.groupCallUpdated) {
            Long l = (Long) args[1];
            ChatObject.Call call = this.call;
            if (call == null || call.call.id != l.longValue()) {
                return;
            }
            ChatObject.Call call2 = this.call;
            if (call2.call instanceof TLRPC$TL_groupCallDiscarded) {
                dismiss();
                return;
            }
            if (this.creatingServiceTime == 0 && (((i4 = this.muteButtonState) == 7 || i4 == 5 || i4 == 6) && !call2.isScheduled())) {
                try {
                    Intent intent = new Intent(this.parentActivity, (Class<?>) VoIPService.class);
                    intent.putExtra("chat_id", this.currentChat.id);
                    intent.putExtra("createGroupCall", false);
                    intent.putExtra("hasFewPeers", this.scheduleHasFewPeers);
                    intent.putExtra("peerChannelId", this.schedulePeer.channel_id);
                    intent.putExtra("peerChatId", this.schedulePeer.chat_id);
                    intent.putExtra("peerUserId", this.schedulePeer.user_id);
                    intent.putExtra("hash", this.scheduledHash);
                    intent.putExtra("peerAccessHash", this.schedulePeer.access_hash);
                    intent.putExtra("is_outgoing", true);
                    intent.putExtra("start_incall_activity", false);
                    intent.putExtra("account", this.accountInstance.getCurrentAccount());
                    intent.putExtra("scheduleDate", this.scheduleStartAt);
                    this.parentActivity.startService(intent);
                } catch (Throwable th) {
                    FileLog.e(th);
                }
                this.creatingServiceTime = SystemClock.elapsedRealtime();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$SBkeYn9n4y0ECVckPfVpgZvNHVc
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f$0.lambda$didReceivedNotification$2$GroupCallActivity();
                    }
                }, 3000L);
            }
            if (!this.callInitied && VoIPService.getSharedInstance() != null) {
                this.call.addSelfDummyParticipant(false);
                initCreatedGroupCall();
                VoIPService.getSharedInstance().playConnectedSound();
            }
            updateItems();
            int childCount = this.listView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.listView.getChildAt(i5);
                if (childAt instanceof GroupCallUserCell) {
                    ((GroupCallUserCell) childAt).applyParticipantChanges(true);
                }
            }
            if (this.scrimView != null) {
                this.delayedGroupCallUpdated = true;
            } else {
                applyCallParticipantUpdates(true);
            }
            updateSubtitle();
            boolean zBooleanValue = ((Boolean) args[2]).booleanValue();
            i = this.muteButtonState == 4 ? 1 : 0;
            updateState(true, zBooleanValue);
            updateTitle(true);
            if (i != 0 && ((i3 = this.muteButtonState) == 1 || i3 == 0)) {
                getUndoView().showWithAction(0L, 38, (Runnable) null);
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().playAllowTalkSound();
                }
            }
            if (args.length >= 4) {
                long jLongValue = ((Long) args[3]).longValue();
                if (jLongValue != 0) {
                    if (DialogObject.isUserDialog(jLongValue)) {
                        TLRPC$User user = this.accountInstance.getMessagesController().getUser(Long.valueOf(jLongValue));
                        if (this.call.call.participants_count < 250 || UserObject.isContact(user)) {
                            getUndoView().showWithAction(0L, 44, user, this.currentChat, (Runnable) null, (Runnable) null);
                            return;
                        }
                        return;
                    }
                    TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-jLongValue));
                    if (this.call.call.participants_count < 250 || !ChatObject.isNotInChat(chat)) {
                        getUndoView().showWithAction(0L, 44, chat, this.currentChat, (Runnable) null, (Runnable) null);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.groupCallSpeakingUsersUpdated) {
            GroupCallRenderersContainer groupCallRenderersContainer = this.renderersContainer;
            if (groupCallRenderersContainer.inFullscreenMode && this.call != null) {
                boolean zAutoPinEnabled = groupCallRenderersContainer.autoPinEnabled();
                ChatObject.Call call3 = this.call;
                if (call3 != null) {
                    GroupCallRenderersContainer groupCallRenderersContainer2 = this.renderersContainer;
                    if (groupCallRenderersContainer2.inFullscreenMode && (videoParticipant = groupCallRenderersContainer2.fullscreenParticipant) != null && call3.participants.get(MessageObject.getPeerId(videoParticipant.participant.peer)) == null) {
                        zAutoPinEnabled = true;
                    }
                }
                if (zAutoPinEnabled) {
                    ChatObject.VideoParticipant videoParticipant2 = null;
                    for (int i6 = 0; i6 < this.visibleVideoParticipants.size(); i6++) {
                        ChatObject.VideoParticipant videoParticipant3 = this.visibleVideoParticipants.get(i6);
                        if (this.call.currentSpeakingPeers.get(MessageObject.getPeerId(videoParticipant3.participant.peer), null) != null) {
                            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant3 = videoParticipant3.participant;
                            if (!tLRPC$TL_groupCallParticipant3.muted_by_you && this.renderersContainer.fullscreenPeerId != MessageObject.getPeerId(tLRPC$TL_groupCallParticipant3.peer)) {
                                videoParticipant2 = videoParticipant3;
                            }
                        }
                    }
                    if (videoParticipant2 != null) {
                        fullscreenFor(videoParticipant2);
                    }
                }
            }
            this.renderersContainer.setVisibleParticipant(true);
            updateSubtitle();
            return;
        }
        if (id == NotificationCenter.webRtcMicAmplitudeEvent) {
            setMicAmplitude(((Float) args[0]).floatValue());
            return;
        }
        if (id == NotificationCenter.needShowAlert) {
            if (((Integer) args[0]).intValue() == 6) {
                String str3 = (String) args[1];
                if ("GROUPCALL_PARTICIPANTS_TOO_MUCH".equals(str3)) {
                    if (ChatObject.isChannelOrGiga(this.currentChat)) {
                        string = LocaleController.getString("VoipChannelTooMuch", R.string.VoipChannelTooMuch);
                    } else {
                        string = LocaleController.getString("VoipGroupTooMuch", R.string.VoipGroupTooMuch);
                    }
                } else if (!"ANONYMOUS_CALLS_DISABLED".equals(str3) && !"GROUPCALL_ANONYMOUS_FORBIDDEN".equals(str3)) {
                    string = LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + str3;
                } else if (ChatObject.isChannelOrGiga(this.currentChat)) {
                    string = LocaleController.getString("VoipChannelJoinAnonymousAdmin", R.string.VoipChannelJoinAnonymousAdmin);
                } else {
                    string = LocaleController.getString("VoipGroupJoinAnonymousAdmin", R.string.VoipGroupJoinAnonymousAdmin);
                }
                AlertDialog.Builder builderCreateSimpleAlert = AlertsCreator.createSimpleAlert(getContext(), LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat), string);
                builderCreateSimpleAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$81u9lYgIa-KL4xGKerP5LE1nFNU
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$didReceivedNotification$3$GroupCallActivity(dialogInterface);
                    }
                });
                try {
                    builderCreateSimpleAlert.show();
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        if (id == NotificationCenter.didEndCall) {
            if (VoIPService.getSharedInstance() == null) {
                dismiss();
                return;
            }
            return;
        }
        if (id == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) args[0];
            if (tLRPC$ChatFull.id == this.currentChat.id) {
                updateItems();
                updateState(isShowing(), false);
            }
            long peerId = MessageObject.getPeerId(this.selfPeer);
            ChatObject.Call call4 = this.call;
            if (call4 == null || tLRPC$ChatFull.id != (-peerId) || (tLRPC$TL_groupCallParticipant2 = call4.participants.get(peerId)) == null) {
                return;
            }
            tLRPC$TL_groupCallParticipant2.about = tLRPC$ChatFull.about;
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            if (this.currentOptionsLayout != null) {
                while (i < this.currentOptionsLayout.getChildCount()) {
                    View childAt2 = this.currentOptionsLayout.getChildAt(i);
                    if ((childAt2 instanceof ActionBarMenuSubItem) && childAt2.getTag() != null && ((Integer) childAt2.getTag()).intValue() == 10) {
                        ActionBarMenuSubItem actionBarMenuSubItem = (ActionBarMenuSubItem) childAt2;
                        if (TextUtils.isEmpty(tLRPC$TL_groupCallParticipant2.about)) {
                            i2 = R.string.VoipAddDescription;
                            str2 = "VoipAddDescription";
                        } else {
                            i2 = R.string.VoipEditDescription;
                            str2 = "VoipEditDescription";
                        }
                        actionBarMenuSubItem.setTextAndIcon(LocaleController.getString(str2, i2), TextUtils.isEmpty(tLRPC$TL_groupCallParticipant2.about) ? R.drawable.msg_addbio : R.drawable.msg_bio);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.didLoadChatAdmins) {
            if (((Long) args[0]).longValue() == this.currentChat.id) {
                updateItems();
                updateState(isShowing(), false);
                return;
            }
            return;
        }
        if (id == NotificationCenter.applyGroupCallVisibleParticipants) {
            int childCount2 = this.listView.getChildCount();
            long jLongValue2 = ((Long) args[0]).longValue();
            while (i < childCount2) {
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(this.listView.getChildAt(i));
                if (viewHolderFindContainingViewHolder != null) {
                    View view = viewHolderFindContainingViewHolder.itemView;
                    if (view instanceof GroupCallUserCell) {
                        ((GroupCallUserCell) view).getParticipant().lastVisibleDate = jLongValue2;
                    }
                }
                i++;
            }
            return;
        }
        if (id == NotificationCenter.userInfoDidLoad) {
            Long l2 = (Long) args[0];
            long peerId2 = MessageObject.getPeerId(this.selfPeer);
            if (this.call == null || peerId2 != l2.longValue() || (tLRPC$TL_groupCallParticipant = this.call.participants.get(peerId2)) == null) {
                return;
            }
            tLRPC$TL_groupCallParticipant.about = ((TLRPC$UserFull) args[1]).about;
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            if (this.currentOptionsLayout != null) {
                while (i < this.currentOptionsLayout.getChildCount()) {
                    View childAt3 = this.currentOptionsLayout.getChildAt(i);
                    if ((childAt3 instanceof ActionBarMenuSubItem) && childAt3.getTag() != null && ((Integer) childAt3.getTag()).intValue() == 10) {
                        ActionBarMenuSubItem actionBarMenuSubItem2 = (ActionBarMenuSubItem) childAt3;
                        if (TextUtils.isEmpty(tLRPC$TL_groupCallParticipant.about)) {
                            i = R.string.VoipAddBio;
                            str = "VoipAddBio";
                        } else {
                            i = R.string.VoipEditBio;
                            str = "VoipEditBio";
                        }
                        actionBarMenuSubItem2.setTextAndIcon(LocaleController.getString(str, i), TextUtils.isEmpty(tLRPC$TL_groupCallParticipant.about) ? R.drawable.msg_addbio : R.drawable.msg_bio);
                    }
                    i++;
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.mainUserInfoChanged) {
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            return;
        }
        if (id == NotificationCenter.updateInterfaces) {
            if ((((Integer) args[0]).intValue() & MessagesController.UPDATE_MASK_CHAT_NAME) != 0) {
                applyCallParticipantUpdates(true);
                AndroidUtilities.updateVisibleRows(this.listView);
                return;
            }
            return;
        }
        if (id == NotificationCenter.groupCallScreencastStateChanged) {
            PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
            if (privateVideoPreviewDialog != null) {
                privateVideoPreviewDialog.dismiss(true, true);
            }
            updateItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$2$GroupCallActivity() throws InterruptedException {
        if (isStillConnecting()) {
            updateState(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$didReceivedNotification$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$didReceivedNotification$3$GroupCallActivity(DialogInterface dialogInterface) {
        dismiss();
    }

    private void setMicAmplitude(float amplitude) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute()) {
            amplitude = 0.0f;
        }
        setAmplitude(4000.0f * amplitude);
        ChatObject.Call call = this.call;
        if (call == null || this.listView == null || (tLRPC$TL_groupCallParticipant = call.participants.get(MessageObject.getPeerId(this.selfPeer))) == null) {
            return;
        }
        if (!this.renderersContainer.inFullscreenMode) {
            int iIndexOf = (this.delayedGroupCallUpdated ? this.oldParticipants : this.call.visibleParticipants).indexOf(tLRPC$TL_groupCallParticipant);
            if (iIndexOf >= 0 && (viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(iIndexOf + this.listAdapter.usersStartRow)) != null) {
                View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                if (view instanceof GroupCallUserCell) {
                    ((GroupCallUserCell) view).setAmplitude(amplitude * 15.0f);
                    if (viewHolderFindViewHolderForAdapterPosition.itemView == this.scrimView && !this.contentFullyOverlayed) {
                        this.containerView.invalidate();
                    }
                }
            }
        } else {
            for (int i = 0; i < this.fullscreenUsersListView.getChildCount(); i++) {
                GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) this.fullscreenUsersListView.getChildAt(i);
                if (MessageObject.getPeerId(groupCallUserCell.getParticipant().peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                    groupCallUserCell.setAmplitude(amplitude * 15.0f);
                }
            }
        }
        this.renderersContainer.setAmplitude(tLRPC$TL_groupCallParticipant, amplitude * 15.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0208 A[LOOP:2: B:92:0x0200->B:94:0x0208, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x021b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void applyCallParticipantUpdates(boolean r19) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.applyCallParticipantUpdates(boolean):void");
    }

    private void updateVideoParticipantList() {
        this.visibleVideoParticipants.clear();
        if (isTabletMode) {
            if (this.renderersContainer.inFullscreenMode) {
                this.visibleVideoParticipants.addAll(this.call.visibleVideoParticipants);
                ChatObject.VideoParticipant videoParticipant = this.renderersContainer.fullscreenParticipant;
                if (videoParticipant != null) {
                    this.visibleVideoParticipants.remove(videoParticipant);
                    return;
                }
                return;
            }
            return;
        }
        this.visibleVideoParticipants.addAll(this.call.visibleVideoParticipants);
    }

    private void updateRecordCallText() {
        if (this.call == null) {
            return;
        }
        int currentTime = this.accountInstance.getConnectionsManager().getCurrentTime();
        ChatObject.Call call = this.call;
        int i = currentTime - call.call.record_start_date;
        if (call.recording) {
            this.recordItem.setSubtext(AndroidUtilities.formatDuration(i, false));
        } else {
            this.recordItem.setSubtext(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateItems() {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.updateItems():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateItems$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateItems$4$GroupCallActivity() {
        updateRecordCallText();
        AndroidUtilities.runOnUIThread(this.updateCallRecordRunnable, 1000L);
    }

    protected void makeFocusable(final BottomSheet bottomSheet, final AlertDialog alertDialog, final EditTextBoldCursor editText, final boolean showKeyboard) {
        if (this.enterEventSent) {
            return;
        }
        BaseFragment baseFragment = this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1);
        if (baseFragment instanceof ChatActivity) {
            boolean zNeedEnterText = ((ChatActivity) baseFragment).needEnterText();
            this.enterEventSent = true;
            this.anyEnterEventSent = true;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$EWlvDwT4ez0wTz47-b2vp4UVyfc
                @Override // java.lang.Runnable
                public final void run() {
                    GroupCallActivity.lambda$makeFocusable$7(bottomSheet, editText, showKeyboard, alertDialog);
                }
            }, zNeedEnterText ? 200L : 0L);
            return;
        }
        this.enterEventSent = true;
        this.anyEnterEventSent = true;
        if (bottomSheet != null) {
            bottomSheet.setFocusable(true);
        } else if (alertDialog != null) {
            alertDialog.setFocusable(true);
        }
        if (showKeyboard) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$3hk34KsjDGL7ZVy_gL3LcJM8Cfg
                @Override // java.lang.Runnable
                public final void run() {
                    GroupCallActivity.lambda$makeFocusable$8(editText);
                }
            }, 100L);
        }
    }

    static /* synthetic */ void lambda$makeFocusable$7(BottomSheet bottomSheet, final EditTextBoldCursor editTextBoldCursor, boolean z, AlertDialog alertDialog) {
        if (bottomSheet != null && !bottomSheet.isDismissed()) {
            bottomSheet.setFocusable(true);
            editTextBoldCursor.requestFocus();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$ETPuX3XZ2qDMn8PxGaxWhjQMXZM
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidUtilities.showKeyboard(editTextBoldCursor);
                    }
                });
                return;
            }
            return;
        }
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        alertDialog.setFocusable(true);
        editTextBoldCursor.requestFocus();
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$FE0F27GHCf7ERwR6yW0RRCJGWAk
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidUtilities.showKeyboard(editTextBoldCursor);
                }
            });
        }
    }

    static /* synthetic */ void lambda$makeFocusable$8(EditTextBoldCursor editTextBoldCursor) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    public static void create(LaunchActivity activity, AccountInstance account, TLRPC$Chat scheduleChat, TLRPC$InputPeer schedulePeer, boolean hasFewPeers, String scheduledHash) {
        TLRPC$Chat chat;
        if (groupCallInstance == null) {
            if (schedulePeer == null && VoIPService.getSharedInstance() == null) {
                return;
            }
            if (schedulePeer != null) {
                groupCallInstance = new GroupCallActivity(activity, account, account.getMessagesController().getGroupCall(scheduleChat.id, false), scheduleChat, schedulePeer, hasFewPeers, scheduledHash);
            } else {
                ChatObject.Call call = VoIPService.getSharedInstance().groupCall;
                if (call == null || (chat = account.getMessagesController().getChat(Long.valueOf(call.chatId))) == null) {
                    return;
                }
                call.addSelfDummyParticipant(true);
                groupCallInstance = new GroupCallActivity(activity, account, call, chat, null, hasFewPeers, scheduledHash);
            }
            GroupCallActivity groupCallActivity = groupCallInstance;
            groupCallActivity.parentActivity = activity;
            groupCallActivity.show();
        }
    }

    private GroupCallActivity(final Context context, final AccountInstance account, ChatObject.Call groupCall, final TLRPC$Chat chat, TLRPC$InputPeer schedulePeer, boolean scheduleHasFewPeers, String scheduledHash) throws InterruptedException {
        int i;
        String str;
        int i2;
        String str2;
        ViewGroup viewGroup;
        super(context, false);
        this.muteLabel = new TextView[2];
        this.undoView = new UndoView[2];
        this.visibleVideoParticipants = new ArrayList<>();
        this.rect = new RectF();
        this.listViewBackgroundPaint = new Paint(1);
        this.oldParticipants = new ArrayList<>();
        this.oldVideoParticipants = new ArrayList<>();
        this.oldInvited = new ArrayList<>();
        this.muteButtonState = 0;
        this.paint = new Paint(7);
        this.paintTmp = new Paint(7);
        this.leaveBackgroundPaint = new Paint(1);
        this.states = new WeavingState[8];
        this.switchProgress = 1.0f;
        this.shaderBitmapSize = 200;
        this.invalidateColors = true;
        this.colorsTmp = new int[3];
        this.attachedRenderers = new ArrayList<>();
        this.attachedRenderersTmp = new ArrayList<>();
        this.cellFlickerDrawable = new CellFlickerDrawable();
        this.statusIconPool = new ArrayList<>();
        this.buttonsAnimationParamsX = new HashMap<>();
        this.buttonsAnimationParamsY = new HashMap<>();
        this.updateSchedeulRunnable = new Runnable() { // from class: ir.eitaa.ui.GroupCallActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (GroupCallActivity.this.scheduleTimeTextView == null || GroupCallActivity.this.isDismissed()) {
                    return;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                ChatObject.Call call = groupCallActivity.call;
                if (call == null) {
                    i3 = groupCallActivity.scheduleStartAt;
                } else {
                    i3 = call.call.schedule_date;
                }
                if (i3 == 0) {
                    return;
                }
                int currentTime = i3 - GroupCallActivity.this.accountInstance.getConnectionsManager().getCurrentTime();
                if (currentTime >= 86400) {
                    GroupCallActivity.this.scheduleTimeTextView.setText(LocaleController.formatPluralString("Days", Math.round(currentTime / 86400.0f)));
                } else {
                    GroupCallActivity.this.scheduleTimeTextView.setText(AndroidUtilities.formatFullDuration(Math.abs(currentTime)));
                    if (currentTime < 0 && GroupCallActivity.this.scheduleStartInTextView.getTag() == null) {
                        GroupCallActivity.this.scheduleStartInTextView.setTag(1);
                        GroupCallActivity.this.scheduleStartInTextView.setText(LocaleController.getString("VoipChatLateBy", R.string.VoipChatLateBy));
                    }
                }
                GroupCallActivity.this.scheduleStartAtTextView.setText(LocaleController.formatStartsTime(i3, 3));
                AndroidUtilities.runOnUIThread(GroupCallActivity.this.updateSchedeulRunnable, 1000L);
            }
        };
        this.unmuteRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$rrkpt13GyWLoS1zY45Zrj0Fls4E
            @Override // java.lang.Runnable
            public final void run() {
                GroupCallActivity.lambda$new$0();
            }
        };
        this.pressRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$fSI88PVpRvp-dkFMrQUSvh6k6fI
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$1$GroupCallActivity();
            }
        };
        this.visiblePeerIds = new LongSparseIntArray();
        this.gradientColors = new int[2];
        this.listViewVideoVisibility = true;
        this.invites = new String[2];
        this.popupAnimationIndex = -1;
        this.diffUtilsCallback = new DiffUtil.Callback() { // from class: ir.eitaa.ui.GroupCallActivity.56
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return true;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return GroupCallActivity.this.oldCount;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return GroupCallActivity.this.listAdapter.rowsCount;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                if (GroupCallActivity.this.listAdapter.addMemberRow >= 0) {
                    if (oldItemPosition == GroupCallActivity.this.oldAddMemberRow && newItemPosition == GroupCallActivity.this.listAdapter.addMemberRow) {
                        return true;
                    }
                    if ((oldItemPosition == GroupCallActivity.this.oldAddMemberRow && newItemPosition != GroupCallActivity.this.listAdapter.addMemberRow) || (oldItemPosition != GroupCallActivity.this.oldAddMemberRow && newItemPosition == GroupCallActivity.this.listAdapter.addMemberRow)) {
                        return false;
                    }
                }
                if (GroupCallActivity.this.listAdapter.videoNotAvailableRow >= 0) {
                    if (oldItemPosition == GroupCallActivity.this.oldVideoNotAvailableRow && newItemPosition == GroupCallActivity.this.listAdapter.videoNotAvailableRow) {
                        return true;
                    }
                    if ((oldItemPosition == GroupCallActivity.this.oldVideoNotAvailableRow && newItemPosition != GroupCallActivity.this.listAdapter.videoNotAvailableRow) || (oldItemPosition != GroupCallActivity.this.oldVideoNotAvailableRow && newItemPosition == GroupCallActivity.this.listAdapter.videoNotAvailableRow)) {
                        return false;
                    }
                }
                if (GroupCallActivity.this.listAdapter.videoGridDividerRow >= 0 && GroupCallActivity.this.listAdapter.videoGridDividerRow == newItemPosition && oldItemPosition == GroupCallActivity.this.oldVideoDividerRow) {
                    return true;
                }
                if (oldItemPosition == GroupCallActivity.this.oldCount - 1 && newItemPosition == GroupCallActivity.this.listAdapter.rowsCount - 1) {
                    return true;
                }
                if (oldItemPosition != GroupCallActivity.this.oldCount - 1 && newItemPosition != GroupCallActivity.this.listAdapter.rowsCount - 1) {
                    if (newItemPosition >= GroupCallActivity.this.listAdapter.usersVideoGridStartRow && newItemPosition < GroupCallActivity.this.listAdapter.usersVideoGridEndRow && oldItemPosition >= GroupCallActivity.this.oldUsersVideoStartRow && oldItemPosition < GroupCallActivity.this.oldUsersVideoEndRow) {
                        ChatObject.VideoParticipant videoParticipant = (ChatObject.VideoParticipant) GroupCallActivity.this.oldVideoParticipants.get(oldItemPosition - GroupCallActivity.this.oldUsersVideoStartRow);
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        return videoParticipant.equals(groupCallActivity.visibleVideoParticipants.get(newItemPosition - groupCallActivity.listAdapter.usersVideoGridStartRow));
                    }
                    if (newItemPosition >= GroupCallActivity.this.listAdapter.usersStartRow && newItemPosition < GroupCallActivity.this.listAdapter.usersEndRow && oldItemPosition >= GroupCallActivity.this.oldUsersStartRow && oldItemPosition < GroupCallActivity.this.oldUsersEndRow) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = (TLRPC$TL_groupCallParticipant) GroupCallActivity.this.oldParticipants.get(oldItemPosition - GroupCallActivity.this.oldUsersStartRow);
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == MessageObject.getPeerId(groupCallActivity2.call.visibleParticipants.get(newItemPosition - groupCallActivity2.listAdapter.usersStartRow).peer)) {
                            return oldItemPosition == newItemPosition || tLRPC$TL_groupCallParticipant.lastActiveDate == ((long) tLRPC$TL_groupCallParticipant.active_date);
                        }
                        return false;
                    }
                    if (newItemPosition >= GroupCallActivity.this.listAdapter.invitedStartRow && newItemPosition < GroupCallActivity.this.listAdapter.invitedEndRow && oldItemPosition >= GroupCallActivity.this.oldInvitedStartRow && oldItemPosition < GroupCallActivity.this.oldInvitedEndRow) {
                        Long l = (Long) GroupCallActivity.this.oldInvited.get(oldItemPosition - GroupCallActivity.this.oldInvitedStartRow);
                        GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                        return l.equals(groupCallActivity3.call.invitedUsers.get(newItemPosition - groupCallActivity3.listAdapter.invitedStartRow));
                    }
                }
                return false;
            }
        };
        this.accountInstance = account;
        this.call = groupCall;
        this.schedulePeer = schedulePeer;
        this.currentChat = chat;
        this.scheduledHash = scheduledHash;
        this.currentAccount = account.getCurrentAccount();
        this.scheduleHasFewPeers = scheduleHasFewPeers;
        this.fullWidth = true;
        isTabletMode = false;
        isLandscapeMode = false;
        paused = false;
        setDelegate(new BottomSheet.BottomSheetDelegateInterface() { // from class: ir.eitaa.ui.GroupCallActivity.3
            @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            public boolean canDismiss() {
                return true;
            }

            @Override // ir.eitaa.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            public void onOpenAnimationEnd() {
                if (GroupCallActivity.this.muteButtonState == 6) {
                    GroupCallActivity.this.showReminderHint();
                }
            }
        });
        this.drawNavigationBar = true;
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setNavigationBarColor(-16777216);
        }
        this.scrollNavBar = true;
        this.navBarColorKey = null;
        this.scrimPaint = new Paint() { // from class: ir.eitaa.ui.GroupCallActivity.4
            @Override // android.graphics.Paint
            public void setAlpha(int a) {
                super.setAlpha(a);
                if (((BottomSheet) GroupCallActivity.this).containerView != null) {
                    ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                }
            }
        };
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$SlBPrzndEI0Ld_n6sXjpEl1Lv1k
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$new$9$GroupCallActivity(dialogInterface);
            }
        });
        setDimBehindAlpha(75);
        this.listAdapter = new ListAdapter(context);
        final RecordStatusDrawable recordStatusDrawable = new RecordStatusDrawable(true);
        recordStatusDrawable.setColor(Theme.getColor("voipgroup_speakingText"));
        recordStatusDrawable.start();
        ActionBar actionBar = new ActionBar(context) { // from class: ir.eitaa.ui.GroupCallActivity.5
            @Override // android.view.View
            public void setAlpha(float alpha) {
                if (getAlpha() != alpha) {
                    super.setAlpha(alpha);
                    ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (getAdditionalSubtitleTextView().getVisibility() == 0) {
                    canvas.save();
                    canvas.translate(getSubtitleTextView().getLeft(), getSubtitleTextView().getY() - AndroidUtilities.dp(1.0f));
                    recordStatusDrawable.setAlpha((int) (getAdditionalSubtitleTextView().getAlpha() * 255.0f));
                    recordStatusDrawable.draw(canvas);
                    canvas.restore();
                    invalidate();
                }
            }
        };
        this.actionBar = actionBar;
        actionBar.setSubtitle("");
        this.actionBar.getSubtitleTextView().setVisibility(0);
        this.actionBar.createAdditionalSubtitleTextView();
        this.actionBar.getAdditionalSubtitleTextView().setPadding(AndroidUtilities.dp(24.0f), 0, 0, 0);
        AndroidUtilities.updateViewVisibilityAnimated(this.actionBar.getAdditionalSubtitleTextView(), this.drawSpeakingSubtitle, 1.0f, false);
        this.actionBar.getAdditionalSubtitleTextView().setTextColor(Theme.getColor("voipgroup_speakingText"));
        this.actionBar.setSubtitleColor(Theme.getColor("voipgroup_lastSeenTextUnscrolled"));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setItemsColor(Theme.getColor("voipgroup_actionBarItems"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarActionModeDefaultSelector"), false);
        this.actionBar.setTitleColor(Theme.getColor("voipgroup_actionBarItems"));
        this.actionBar.setSubtitleColor(Theme.getColor("voipgroup_lastSeenTextUnscrolled"));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass6(context));
        TLRPC$InputPeer groupCallPeer = schedulePeer != null ? schedulePeer : VoIPService.getSharedInstance().getGroupCallPeer();
        if (groupCallPeer == null) {
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            this.selfPeer = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = this.accountInstance.getUserConfig().getClientUserId();
        } else if (groupCallPeer instanceof TLRPC$TL_inputPeerChannel) {
            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
            this.selfPeer = tLRPC$TL_peerChannel;
            tLRPC$TL_peerChannel.channel_id = groupCallPeer.channel_id;
        } else if (groupCallPeer instanceof TLRPC$TL_inputPeerUser) {
            TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
            this.selfPeer = tLRPC$TL_peerUser2;
            tLRPC$TL_peerUser2.user_id = groupCallPeer.user_id;
        } else if (groupCallPeer instanceof TLRPC$TL_inputPeerChat) {
            TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
            this.selfPeer = tLRPC$TL_peerChat;
            tLRPC$TL_peerChat.chat_id = groupCallPeer.chat_id;
        }
        VoIPService.audioLevelsCallback = new NativeInstance.AudioLevelsCallback() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$sAMBvDXRc7x24KsMiZeh9_eb17Y
            @Override // ir.eitaa.messenger.voip.NativeInstance.AudioLevelsCallback
            public final void run(int[] iArr, float[] fArr, boolean[] zArr) {
                this.f$0.lambda$new$10$GroupCallActivity(iArr, fArr, zArr);
            }
        };
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.groupCallUpdated);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.needShowAlert);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.chatInfoDidLoad);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.didLoadChatAdmins);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.applyGroupCallVisibleParticipants);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.userInfoDidLoad);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.mainUserInfoChanged);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.updateInterfaces);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.groupCallScreencastStateChanged);
        this.accountInstance.getNotificationCenter().addObserver(this, NotificationCenter.groupCallSpeakingUsersUpdated);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.webRtcMicAmplitudeEvent);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didEndCall);
        this.shadowDrawable = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.bigMicDrawable = new RLottieDrawable(R.raw.voip_filled, "2131624067", AndroidUtilities.dp(72.0f), AndroidUtilities.dp(72.0f), true, (int[]) null);
        this.handDrawables = new RLottieDrawable(R.raw.hand_2, "2131623982", AndroidUtilities.dp(72.0f), AndroidUtilities.dp(72.0f), true, (int[]) null);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.GroupCallActivity.7
            private int lastSize;
            boolean localHasVideo;
            private boolean updateRenderers;
            boolean wasLayout;
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();
            HashMap<Object, View> listCells = new HashMap<>();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws InterruptedException {
                int iDp;
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                this.ignoreLayout = true;
                boolean z = View.MeasureSpec.getSize(widthMeasureSpec) > size && !AndroidUtilities.isTablet();
                GroupCallActivity.this.renderersContainer.listWidth = View.MeasureSpec.getSize(widthMeasureSpec);
                boolean z2 = AndroidUtilities.isTablet() && View.MeasureSpec.getSize(widthMeasureSpec) > size;
                if (GroupCallActivity.isLandscapeMode != z) {
                    GroupCallActivity.isLandscapeMode = z;
                    GroupCallActivity.this.layoutManager.setSpanCount(GroupCallActivity.isLandscapeMode ? 6 : 2);
                    GroupCallActivity.this.listView.invalidateItemDecorations();
                    GroupCallActivity.this.fullscreenUsersListView.invalidateItemDecorations();
                    this.updateRenderers = true;
                    if (GroupCallActivity.this.scheduleInfoTextView != null) {
                        GroupCallActivity.this.scheduleInfoTextView.setVisibility(!GroupCallActivity.isLandscapeMode ? 0 : 8);
                    }
                }
                if (GroupCallActivity.isTabletMode != z2) {
                    GroupCallActivity.isTabletMode = z2;
                    GroupCallActivity.this.tabletVideoGridView.setVisibility(z2 ? 0 : 8);
                    GroupCallActivity.this.listView.invalidateItemDecorations();
                    GroupCallActivity.this.fullscreenUsersListView.invalidateItemDecorations();
                    this.updateRenderers = true;
                }
                if (this.updateRenderers) {
                    GroupCallActivity.this.applyCallParticipantUpdates(true);
                    GroupCallActivity.this.listAdapter.notifyDataSetChanged();
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.fullscreenAdapter.update(false, groupCallActivity.tabletVideoGridView);
                    if (GroupCallActivity.isTabletMode) {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        groupCallActivity2.tabletGridAdapter.update(false, groupCallActivity2.tabletVideoGridView);
                    }
                    GroupCallActivity.this.tabletVideoGridView.setVisibility(GroupCallActivity.isTabletMode ? 0 : 8);
                    GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                    groupCallActivity3.tabletGridAdapter.setVisibility(groupCallActivity3.tabletVideoGridView, GroupCallActivity.isTabletMode && !groupCallActivity3.renderersContainer.inFullscreenMode, true);
                    GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                    groupCallActivity4.listViewVideoVisibility = !GroupCallActivity.isTabletMode || groupCallActivity4.renderersContainer.inFullscreenMode;
                    boolean z3 = !GroupCallActivity.isTabletMode && GroupCallActivity.this.renderersContainer.inFullscreenMode;
                    GroupCallActivity groupCallActivity5 = GroupCallActivity.this;
                    groupCallActivity5.fullscreenAdapter.setVisibility(groupCallActivity5.fullscreenUsersListView, z3);
                    GroupCallActivity.this.fullscreenUsersListView.setVisibility(z3 ? 0 : 8);
                    GroupCallActivity.this.listView.setVisibility((GroupCallActivity.isTabletMode || !GroupCallActivity.this.renderersContainer.inFullscreenMode) ? 0 : 8);
                    GroupCallActivity.this.layoutManager.setSpanCount(GroupCallActivity.isLandscapeMode ? 6 : 2);
                    GroupCallActivity.this.updateState(false, false);
                    GroupCallActivity.this.listView.invalidateItemDecorations();
                    GroupCallActivity.this.fullscreenUsersListView.invalidateItemDecorations();
                    AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
                    this.updateRenderers = false;
                    GroupCallActivity.this.attachedRenderersTmp.clear();
                    GroupCallActivity.this.attachedRenderersTmp.addAll(GroupCallActivity.this.attachedRenderers);
                    GroupCallActivity.this.renderersContainer.setIsTablet(GroupCallActivity.isTabletMode);
                    for (int i3 = 0; i3 < GroupCallActivity.this.attachedRenderersTmp.size(); i3++) {
                        ((GroupCallMiniTextureView) GroupCallActivity.this.attachedRenderersTmp.get(i3)).updateAttachState(true);
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    setPadding(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, ((BottomSheet) GroupCallActivity.this).statusBarHeight, ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0);
                }
                int paddingTop = (size - getPaddingTop()) - AndroidUtilities.dp(245.0f);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) GroupCallActivity.this.renderersContainer.getLayoutParams();
                if (GroupCallActivity.isTabletMode) {
                    layoutParams.topMargin = ActionBar.getCurrentActionBarHeight();
                } else {
                    layoutParams.topMargin = 0;
                }
                for (int i4 = 0; i4 < 2; i4++) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) GroupCallActivity.this.undoView[i4].getLayoutParams();
                    if (GroupCallActivity.isTabletMode) {
                        layoutParams2.rightMargin = AndroidUtilities.dp(328.0f);
                    } else {
                        layoutParams2.rightMargin = AndroidUtilities.dp(8.0f);
                    }
                }
                RecyclerListView recyclerListView = GroupCallActivity.this.tabletVideoGridView;
                if (recyclerListView != null) {
                    ((FrameLayout.LayoutParams) recyclerListView.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                }
                int iDp2 = AndroidUtilities.dp(150.0f);
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) GroupCallActivity.this.listView.getLayoutParams();
                if (GroupCallActivity.isTabletMode) {
                    layoutParams3.gravity = GroupCallActivity.this.hasVideo ? 5 : 1;
                    layoutParams3.width = AndroidUtilities.dp(320.0f);
                    int iDp3 = AndroidUtilities.dp(4.0f);
                    layoutParams3.leftMargin = iDp3;
                    layoutParams3.rightMargin = iDp3;
                    layoutParams3.bottomMargin = iDp2;
                    layoutParams3.topMargin = ActionBar.getCurrentActionBarHeight();
                    iDp = AndroidUtilities.dp(60.0f);
                } else if (GroupCallActivity.isLandscapeMode) {
                    layoutParams3.gravity = 51;
                    layoutParams3.width = -1;
                    layoutParams3.topMargin = ActionBar.getCurrentActionBarHeight();
                    layoutParams3.bottomMargin = AndroidUtilities.dp(14.0f);
                    layoutParams3.rightMargin = AndroidUtilities.dp(90.0f);
                    layoutParams3.leftMargin = AndroidUtilities.dp(14.0f);
                    iDp = 0;
                } else {
                    layoutParams3.gravity = 51;
                    layoutParams3.width = -1;
                    int iDp4 = AndroidUtilities.dp(60.0f);
                    layoutParams3.bottomMargin = iDp2;
                    layoutParams3.topMargin = ActionBar.getCurrentActionBarHeight() + AndroidUtilities.dp(14.0f);
                    int iDp5 = AndroidUtilities.dp(14.0f);
                    layoutParams3.leftMargin = iDp5;
                    layoutParams3.rightMargin = iDp5;
                    iDp = iDp4;
                }
                if (!GroupCallActivity.isLandscapeMode || GroupCallActivity.isTabletMode) {
                    GroupCallActivity.this.buttonsBackgroundGradientView.setVisibility(0);
                    FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) GroupCallActivity.this.buttonsBackgroundGradientView.getLayoutParams();
                    layoutParams4.bottomMargin = iDp2;
                    if (GroupCallActivity.isTabletMode) {
                        layoutParams4.gravity = GroupCallActivity.this.hasVideo ? 85 : 81;
                        layoutParams4.width = AndroidUtilities.dp(328.0f);
                    } else {
                        layoutParams4.width = -1;
                    }
                    GroupCallActivity.this.buttonsBackgroundGradientView2.setVisibility(0);
                    FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) GroupCallActivity.this.buttonsBackgroundGradientView2.getLayoutParams();
                    layoutParams5.height = iDp2;
                    if (GroupCallActivity.isTabletMode) {
                        layoutParams5.gravity = GroupCallActivity.this.hasVideo ? 85 : 81;
                        layoutParams5.width = AndroidUtilities.dp(328.0f);
                    } else {
                        layoutParams5.width = -1;
                    }
                } else {
                    GroupCallActivity.this.buttonsBackgroundGradientView.setVisibility(8);
                    GroupCallActivity.this.buttonsBackgroundGradientView2.setVisibility(8);
                }
                if (GroupCallActivity.isLandscapeMode) {
                    GroupCallActivity.this.fullscreenUsersListView.setPadding(0, AndroidUtilities.dp(9.0f), 0, AndroidUtilities.dp(9.0f));
                } else {
                    GroupCallActivity.this.fullscreenUsersListView.setPadding(AndroidUtilities.dp(9.0f), 0, AndroidUtilities.dp(9.0f), 0);
                }
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) GroupCallActivity.this.buttonsContainer.getLayoutParams();
                if (GroupCallActivity.isTabletMode) {
                    layoutParams6.width = AndroidUtilities.dp(320.0f);
                    layoutParams6.height = AndroidUtilities.dp(200.0f);
                    layoutParams6.gravity = GroupCallActivity.this.hasVideo ? 85 : 81;
                    layoutParams6.rightMargin = 0;
                } else if (GroupCallActivity.isLandscapeMode) {
                    layoutParams6.width = AndroidUtilities.dp(90.0f);
                    layoutParams6.height = -1;
                    layoutParams6.gravity = 53;
                } else {
                    layoutParams6.width = -1;
                    layoutParams6.height = AndroidUtilities.dp(200.0f);
                    layoutParams6.gravity = 81;
                    layoutParams6.rightMargin = 0;
                }
                if (GroupCallActivity.isLandscapeMode && !GroupCallActivity.isTabletMode) {
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBar.getLayoutParams()).rightMargin = AndroidUtilities.dp(90.0f);
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.menuItemsContainer.getLayoutParams()).rightMargin = AndroidUtilities.dp(90.0f);
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBarBackground.getLayoutParams()).rightMargin = AndroidUtilities.dp(90.0f);
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBarShadow.getLayoutParams()).rightMargin = AndroidUtilities.dp(90.0f);
                } else {
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBar.getLayoutParams()).rightMargin = 0;
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.menuItemsContainer.getLayoutParams()).rightMargin = 0;
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBarBackground.getLayoutParams()).rightMargin = 0;
                    ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBarShadow.getLayoutParams()).rightMargin = 0;
                }
                FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) GroupCallActivity.this.fullscreenUsersListView.getLayoutParams();
                if (GroupCallActivity.isLandscapeMode) {
                    if (((LinearLayoutManager) GroupCallActivity.this.fullscreenUsersListView.getLayoutManager()).getOrientation() != 1) {
                        ((LinearLayoutManager) GroupCallActivity.this.fullscreenUsersListView.getLayoutManager()).setOrientation(1);
                    }
                    layoutParams7.height = -1;
                    layoutParams7.width = AndroidUtilities.dp(80.0f);
                    layoutParams7.gravity = 53;
                    layoutParams7.rightMargin = AndroidUtilities.dp(100.0f);
                    layoutParams7.bottomMargin = 0;
                } else {
                    if (((LinearLayoutManager) GroupCallActivity.this.fullscreenUsersListView.getLayoutManager()).getOrientation() != 0) {
                        ((LinearLayoutManager) GroupCallActivity.this.fullscreenUsersListView.getLayoutManager()).setOrientation(0);
                    }
                    layoutParams7.height = AndroidUtilities.dp(80.0f);
                    layoutParams7.width = -1;
                    layoutParams7.gravity = 80;
                    layoutParams7.rightMargin = 0;
                    layoutParams7.bottomMargin = AndroidUtilities.dp(100.0f);
                }
                ((FrameLayout.LayoutParams) GroupCallActivity.this.actionBarShadow.getLayoutParams()).topMargin = ActionBar.getCurrentActionBarHeight();
                int iMax = GroupCallActivity.isTabletMode ? 0 : Math.max(0, (paddingTop - Math.max(AndroidUtilities.dp(259.0f), (paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f));
                if (GroupCallActivity.this.listView.getPaddingTop() != iMax || GroupCallActivity.this.listView.getPaddingBottom() != iDp) {
                    GroupCallActivity.this.listView.setPadding(0, iMax, 0, iDp);
                }
                if (GroupCallActivity.this.scheduleStartAtTextView != null) {
                    int iDp6 = iMax + (((paddingTop - iMax) + AndroidUtilities.dp(60.0f)) / 2);
                    FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) GroupCallActivity.this.scheduleStartInTextView.getLayoutParams();
                    layoutParams8.topMargin = iDp6 - AndroidUtilities.dp(30.0f);
                    FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) GroupCallActivity.this.scheduleStartAtTextView.getLayoutParams();
                    layoutParams9.topMargin = AndroidUtilities.dp(80.0f) + iDp6;
                    FrameLayout.LayoutParams layoutParams10 = (FrameLayout.LayoutParams) GroupCallActivity.this.scheduleTimeTextView.getLayoutParams();
                    if (layoutParams8.topMargin < ActionBar.getCurrentActionBarHeight() || layoutParams9.topMargin + AndroidUtilities.dp(20.0f) > size - AndroidUtilities.dp(231.0f)) {
                        GroupCallActivity.this.scheduleStartInTextView.setVisibility(4);
                        GroupCallActivity.this.scheduleStartAtTextView.setVisibility(4);
                        layoutParams10.topMargin = iDp6 - AndroidUtilities.dp(20.0f);
                    } else {
                        GroupCallActivity.this.scheduleStartInTextView.setVisibility(0);
                        GroupCallActivity.this.scheduleStartAtTextView.setVisibility(0);
                        layoutParams10.topMargin = iDp6;
                    }
                }
                for (int i5 = 0; i5 < GroupCallActivity.this.attachedRenderers.size(); i5++) {
                    ((GroupCallMiniTextureView) GroupCallActivity.this.attachedRenderers.get(i5)).setFullscreenMode(GroupCallActivity.this.renderersContainer.inFullscreenMode, true);
                }
                this.ignoreLayout = false;
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
                int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
                if (measuredHeight != this.lastSize) {
                    this.lastSize = measuredHeight;
                    GroupCallActivity.this.dismissAvatarPreview(false);
                }
                GroupCallActivity.this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                float x;
                boolean z;
                if (GroupCallActivity.isTabletMode && this.localHasVideo != GroupCallActivity.this.hasVideo && this.wasLayout) {
                    x = GroupCallActivity.this.listView.getX();
                    z = true;
                } else {
                    x = 0.0f;
                    z = false;
                }
                this.localHasVideo = GroupCallActivity.this.hasVideo;
                GroupCallActivity.this.renderersContainer.inLayout = true;
                super.onLayout(changed, l, t, r, b);
                GroupCallActivity.this.renderersContainer.inLayout = false;
                GroupCallActivity.this.updateLayout(false);
                this.wasLayout = true;
                if (!z || GroupCallActivity.this.listView.getLeft() == x) {
                    return;
                }
                float left = x - GroupCallActivity.this.listView.getLeft();
                GroupCallActivity.this.listView.setTranslationX(left);
                GroupCallActivity.this.buttonsContainer.setTranslationX(left);
                GroupCallActivity.this.buttonsBackgroundGradientView.setTranslationX(left);
                GroupCallActivity.this.buttonsBackgroundGradientView2.setTranslationX(left);
                ViewPropertyAnimator duration = GroupCallActivity.this.listView.animate().translationX(0.0f).setDuration(350L);
                CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
                duration.setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.listView.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.buttonsBackgroundGradientView.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.buttonsBackgroundGradientView2.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.buttonsContainer.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (GroupCallActivity.this.scrimView != null && ev.getAction() == 0) {
                    float x = ev.getX();
                    float y = ev.getY();
                    this.rect.set(GroupCallActivity.this.scrimPopupLayout.getX(), GroupCallActivity.this.scrimPopupLayout.getY(), GroupCallActivity.this.scrimPopupLayout.getX() + GroupCallActivity.this.scrimPopupLayout.getMeasuredWidth(), GroupCallActivity.this.scrimPopupLayout.getY() + GroupCallActivity.this.scrimPopupLayout.getMeasuredHeight());
                    boolean z = !this.rect.contains(x, y);
                    this.rect.set(GroupCallActivity.this.avatarPreviewContainer.getX(), GroupCallActivity.this.avatarPreviewContainer.getY(), GroupCallActivity.this.avatarPreviewContainer.getX() + GroupCallActivity.this.avatarPreviewContainer.getMeasuredWidth(), GroupCallActivity.this.avatarPreviewContainer.getY() + GroupCallActivity.this.avatarPreviewContainer.getMeasuredWidth() + GroupCallActivity.this.scrimView.getMeasuredHeight());
                    if (this.rect.contains(x, y)) {
                        z = false;
                    }
                    if (z) {
                        GroupCallActivity.this.dismissAvatarPreview(true);
                        return true;
                    }
                }
                if (ev.getAction() == 0 && GroupCallActivity.this.scrollOffsetY != 0.0f && ev.getY() < GroupCallActivity.this.scrollOffsetY - AndroidUtilities.dp(37.0f) && GroupCallActivity.this.actionBar.getAlpha() == 0.0f && !GroupCallActivity.this.avatarsPreviewShowed) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    if (groupCallActivity.previewDialog == null && !groupCallActivity.renderersContainer.inFullscreenMode) {
                        GroupCallActivity.this.dismiss();
                        return true;
                    }
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !GroupCallActivity.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                float f;
                int iDp = AndroidUtilities.dp(74.0f);
                float f2 = GroupCallActivity.this.scrollOffsetY - iDp;
                int measuredHeight = getMeasuredHeight() + AndroidUtilities.dp(15.0f) + ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop;
                if (((BottomSheet) GroupCallActivity.this).backgroundPaddingTop + f2 < ActionBar.getCurrentActionBarHeight()) {
                    float fMin = Math.min(1.0f, ((ActionBar.getCurrentActionBarHeight() - f2) - ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop) / ((iDp - ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop) - AndroidUtilities.dp(14.0f)));
                    int currentActionBarHeight = (int) ((ActionBar.getCurrentActionBarHeight() - r0) * fMin);
                    f2 -= currentActionBarHeight;
                    measuredHeight += currentActionBarHeight;
                    f = 1.0f - fMin;
                } else {
                    f = 1.0f;
                }
                float paddingTop = f2 + getPaddingTop();
                if (GroupCallActivity.this.renderersContainer.progressToFullscreenMode != 1.0f) {
                    GroupCallActivity.this.shadowDrawable.setBounds(0, (int) paddingTop, getMeasuredWidth(), measuredHeight);
                    GroupCallActivity.this.shadowDrawable.draw(canvas);
                    if (f != 1.0f) {
                        Theme.dialogs_onlineCirclePaint.setColor(GroupCallActivity.this.backgroundColor);
                        this.rect.set(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop + paddingTop, getMeasuredWidth() - ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop + paddingTop + AndroidUtilities.dp(24.0f));
                        canvas.drawRoundRect(this.rect, AndroidUtilities.dp(12.0f) * f, AndroidUtilities.dp(12.0f) * f, Theme.dialogs_onlineCirclePaint);
                    }
                    Theme.dialogs_onlineCirclePaint.setColor(Color.argb((int) (GroupCallActivity.this.actionBar.getAlpha() * 255.0f), (int) (Color.red(GroupCallActivity.this.backgroundColor) * 0.8f), (int) (Color.green(GroupCallActivity.this.backgroundColor) * 0.8f), (int) (Color.blue(GroupCallActivity.this.backgroundColor) * 0.8f)));
                    canvas.drawRect(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, ((BottomSheet) GroupCallActivity.this).statusBarHeight, Theme.dialogs_onlineCirclePaint);
                    PrivateVideoPreviewDialog privateVideoPreviewDialog = GroupCallActivity.this.previewDialog;
                    if (privateVideoPreviewDialog != null) {
                        Theme.dialogs_onlineCirclePaint.setColor(privateVideoPreviewDialog.getBackgroundColor());
                        canvas.drawRect(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, ((BottomSheet) GroupCallActivity.this).statusBarHeight, Theme.dialogs_onlineCirclePaint);
                    }
                }
                if (GroupCallActivity.this.renderersContainer.progressToFullscreenMode != 0.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_actionBar"), (int) (GroupCallActivity.this.renderersContainer.progressToFullscreenMode * 255.0f)));
                    canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), Theme.dialogs_onlineCirclePaint);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:163:0x09da  */
            @Override // android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void dispatchDraw(android.graphics.Canvas r23) {
                /*
                    Method dump skipped, instructions count: 2765
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.AnonymousClass7.dispatchDraw(android.graphics.Canvas):void");
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (!GroupCallActivity.isTabletMode && GroupCallActivity.this.renderersContainer.progressToFullscreenMode == 1.0f && (child == GroupCallActivity.this.actionBar || child == GroupCallActivity.this.actionBarShadow || child == GroupCallActivity.this.actionBarBackground || child == GroupCallActivity.this.titleTextView || child == GroupCallActivity.this.menuItemsContainer)) {
                    return true;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                if (!groupCallActivity.drawingForBlur || child != groupCallActivity.renderersContainer) {
                    if (child == GroupCallActivity.this.avatarPreviewContainer || child == GroupCallActivity.this.scrimPopupLayout || child == GroupCallActivity.this.scrimView) {
                        return true;
                    }
                    if (GroupCallActivity.this.contentFullyOverlayed && GroupCallActivity.this.useBlur && (child == GroupCallActivity.this.listView || child == GroupCallActivity.this.buttonsContainer)) {
                        return true;
                    }
                    if (GroupCallActivity.this.scrimFullscreenView == null) {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        if (!groupCallActivity2.drawingForBlur && groupCallActivity2.avatarsPreviewShowed && (child == GroupCallActivity.this.buttonsBackgroundGradientView2 || child == GroupCallActivity.this.buttonsBackgroundGradientView || child == GroupCallActivity.this.buttonsContainer || child == GroupCallActivity.this.undoView[0] || child == GroupCallActivity.this.undoView[1])) {
                            return true;
                        }
                    }
                    return super.drawChild(canvas, child, drawingTime);
                }
                canvas.save();
                canvas.translate(GroupCallActivity.this.renderersContainer.getX() + GroupCallActivity.this.fullscreenUsersListView.getX(), GroupCallActivity.this.renderersContainer.getY() + GroupCallActivity.this.fullscreenUsersListView.getY());
                GroupCallActivity.this.fullscreenUsersListView.draw(canvas);
                canvas.restore();
                return true;
            }

            @Override // android.view.View, android.view.KeyEvent.Callback
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                if (GroupCallActivity.this.scrimView != null && keyCode == 4) {
                    GroupCallActivity.this.dismissAvatarPreview(true);
                    return true;
                }
                return super.onKeyDown(keyCode, event);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setFocusable(true);
        this.containerView.setFocusableInTouchMode(true);
        this.containerView.setWillNotDraw(false);
        ViewGroup viewGroup2 = this.containerView;
        int i3 = this.backgroundPaddingLeft;
        viewGroup2.setPadding(i3, 0, i3, 0);
        this.containerView.setKeepScreenOn(true);
        this.containerView.setClipChildren(false);
        if (schedulePeer != null) {
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.scheduleStartInTextView = simpleTextView;
            simpleTextView.setGravity(17);
            this.scheduleStartInTextView.setTextColor(-1);
            this.scheduleStartInTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.scheduleStartInTextView.setTextSize(18);
            this.scheduleStartInTextView.setText(LocaleController.getString("VoipChatStartsIn", R.string.VoipChatStartsIn));
            this.containerView.addView(this.scheduleStartInTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 311.0f));
            SimpleTextView simpleTextView2 = new SimpleTextView(context) { // from class: ir.eitaa.ui.GroupCallActivity.8
                private float duration;
                private float gradientWidth;
                private int lastTextWidth;
                private long lastUpdateTime;
                private LinearGradient linearGradient;
                private float startX;
                private float time;
                private Matrix matrix = new Matrix();
                private float targetX = -1.0f;

                private void setTarget() {
                    this.targetX = ((Utilities.random.nextInt(100) - 50) * 0.2f) / 50.0f;
                }

                @Override // ir.eitaa.ui.ActionBar.SimpleTextView
                protected boolean createLayout(int width) {
                    boolean zCreateLayout = super.createLayout(width);
                    int textWidth = getTextWidth();
                    if (textWidth != this.lastTextWidth) {
                        float f = textWidth;
                        this.gradientWidth = 1.3f * f;
                        this.linearGradient = new LinearGradient(0.0f, getTextHeight(), f * 2.0f, 0.0f, new int[]{Theme.getColor("voipgroup_mutedByAdminGradient"), Theme.getColor("voipgroup_mutedByAdminGradient3"), Theme.getColor("voipgroup_mutedByAdminGradient2"), Theme.getColor("voipgroup_mutedByAdminGradient2")}, new float[]{0.0f, 0.38f, 0.76f, 1.0f}, Shader.TileMode.CLAMP);
                        getPaint().setShader(this.linearGradient);
                        this.lastTextWidth = textWidth;
                    }
                    return zCreateLayout;
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
                /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
                @Override // ir.eitaa.ui.ActionBar.SimpleTextView, android.view.View
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onDraw(android.graphics.Canvas r9) {
                    /*
                        Method dump skipped, instructions count: 230
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.AnonymousClass8.onDraw(android.graphics.Canvas):void");
                }
            };
            this.scheduleTimeTextView = simpleTextView2;
            simpleTextView2.setGravity(17);
            this.scheduleTimeTextView.setTextColor(-1);
            this.scheduleTimeTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.scheduleTimeTextView.setTextSize(60);
            this.containerView.addView(this.scheduleTimeTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 231.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.scheduleStartAtTextView = simpleTextView3;
            simpleTextView3.setGravity(17);
            this.scheduleStartAtTextView.setTextColor(-1);
            this.scheduleStartAtTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.scheduleStartAtTextView.setTextSize(18);
            this.containerView.addView(this.scheduleStartAtTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 201.0f));
        }
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.GroupCallActivity.9
            private final LongSparseIntArray visiblePeerTmp = new LongSparseIntArray();

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                if (child == GroupCallActivity.this.scrimView) {
                    return false;
                }
                return super.drawChild(canvas, child, drawingTime);
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void dispatchDraw(android.graphics.Canvas r18) {
                /*
                    Method dump skipped, instructions count: 447
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.AnonymousClass9.dispatchDraw(android.graphics.Canvas):void");
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.View
            public void setVisibility(int visibility) {
                if (getVisibility() != visibility) {
                    for (int i4 = 0; i4 < getChildCount(); i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt instanceof GroupCallGridCell) {
                            GroupCallActivity.this.attachRenderer((GroupCallGridCell) childAt, visibility == 0);
                        }
                    }
                }
                super.setVisibility(visibility);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                super.onLayout(changed, l, t, r, b);
                GroupCallActivity.this.itemAnimator.updateBackgroundBeforeAnimation();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.listView.setClipChildren(false);
        GroupCallItemAnimator groupCallItemAnimator = new GroupCallItemAnimator();
        this.itemAnimator = groupCallItemAnimator;
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        groupCallItemAnimator.setTranslationInterpolator(cubicBezierInterpolator);
        this.itemAnimator.setRemoveDuration(350L);
        this.itemAnimator.setAddDuration(350L);
        this.itemAnimator.setMoveDuration(350L);
        this.itemAnimator.setDelayAnimations(false);
        this.listView.setItemAnimator(this.itemAnimator);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.GroupCallActivity.10
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                GroupCallActivity groupCallActivity;
                ChatObject.Call call;
                if (GroupCallActivity.this.listView.getChildCount() <= 0 || (call = (groupCallActivity = GroupCallActivity.this).call) == null) {
                    return;
                }
                if (!call.loadingMembers && !call.membersLoadEndReached && groupCallActivity.layoutManager.findLastVisibleItemPosition() > GroupCallActivity.this.listAdapter.getItemCount() - 5) {
                    GroupCallActivity.this.call.loadMembers(false);
                }
                GroupCallActivity.this.updateLayout(true);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState != 0) {
                    if (GroupCallActivity.this.recordHintView != null) {
                        GroupCallActivity.this.recordHintView.hide();
                    }
                    if (GroupCallActivity.this.reminderHintView != null) {
                        GroupCallActivity.this.reminderHintView.hide();
                        return;
                    }
                    return;
                }
                if ((GroupCallActivity.this.scrollOffsetY - AndroidUtilities.dp(74.0f)) + ((BottomSheet) GroupCallActivity.this).backgroundPaddingTop >= ActionBar.getCurrentActionBarHeight() || !GroupCallActivity.this.listView.canScrollVertically(1)) {
                    return;
                }
                GroupCallActivity.this.listView.getChildAt(0);
                RecyclerListView.Holder holder = (RecyclerListView.Holder) GroupCallActivity.this.listView.findViewHolderForAdapterPosition(0);
                if (holder == null || holder.itemView.getTop() <= 0) {
                    return;
                }
                GroupCallActivity.this.listView.smoothScrollBy(0, holder.itemView.getTop());
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastGridLayoutManager fillLastGridLayoutManager = new FillLastGridLayoutManager(getContext(), isLandscapeMode ? 6 : 2, 1, false, 0, this.listView);
        this.layoutManager = fillLastGridLayoutManager;
        recyclerListView2.setLayoutManager(fillLastGridLayoutManager);
        FillLastGridLayoutManager fillLastGridLayoutManager2 = this.layoutManager;
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.GroupCallActivity.11
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                int i4 = GroupCallActivity.isLandscapeMode ? 6 : 2;
                if (GroupCallActivity.isTabletMode || position < GroupCallActivity.this.listAdapter.usersVideoGridStartRow || position >= GroupCallActivity.this.listAdapter.usersVideoGridEndRow) {
                    return i4;
                }
                int i5 = GroupCallActivity.this.listAdapter.usersVideoGridEndRow - GroupCallActivity.this.listAdapter.usersVideoGridStartRow;
                int i6 = (position != GroupCallActivity.this.listAdapter.usersVideoGridEndRow - 1 || (!GroupCallActivity.isLandscapeMode && i5 % 2 == 0)) ? 1 : 2;
                if (!GroupCallActivity.isLandscapeMode) {
                    return i6;
                }
                if (i5 == 1) {
                    return 6;
                }
                return i5 == 2 ? 3 : 2;
            }
        };
        this.spanSizeLookup = spanSizeLookup;
        fillLastGridLayoutManager2.setSpanSizeLookup(spanSizeLookup);
        this.listView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.GroupCallActivity.12
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition >= 0) {
                    outRect.setEmpty();
                    if (childAdapterPosition < GroupCallActivity.this.listAdapter.usersVideoGridStartRow || childAdapterPosition >= GroupCallActivity.this.listAdapter.usersVideoGridEndRow) {
                        return;
                    }
                    int i4 = childAdapterPosition - GroupCallActivity.this.listAdapter.usersVideoGridStartRow;
                    int i5 = GroupCallActivity.isLandscapeMode ? 6 : 2;
                    int i6 = i4 % i5;
                    if (i6 == 0) {
                        outRect.right = AndroidUtilities.dp(2.0f);
                    } else if (i6 == i5 - 1) {
                        outRect.left = AndroidUtilities.dp(2.0f);
                    } else {
                        outRect.left = AndroidUtilities.dp(1.0f);
                    }
                }
            }
        });
        this.layoutManager.setBind(false);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 14.0f, 14.0f, 231.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setTopBottomSelectorRadius(13);
        this.listView.setSelectorDrawableColor(Theme.getColor("voipgroup_listSelector"));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$DmCvUoYz2SsjrCEi2YS4vHSQRAE
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i4, float f, float f2) {
                this.f$0.lambda$new$12$GroupCallActivity(view, i4, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$nL8XX6UJj9tmPfBnCeZzpZvGGJ0
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i4) {
                return this.f$0.lambda$new$13$GroupCallActivity(view, i4);
            }
        });
        RecyclerListView recyclerListView3 = new RecyclerListView(context);
        this.tabletVideoGridView = recyclerListView3;
        this.containerView.addView(recyclerListView3, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 14.0f, 324.0f, 14.0f));
        RecyclerListView recyclerListView4 = this.tabletVideoGridView;
        GroupCallTabletGridAdapter groupCallTabletGridAdapter = new GroupCallTabletGridAdapter(groupCall, this.currentAccount, this);
        this.tabletGridAdapter = groupCallTabletGridAdapter;
        recyclerListView4.setAdapter(groupCallTabletGridAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 6, 1, false);
        this.tabletVideoGridView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.GroupCallActivity.14
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return GroupCallActivity.this.tabletGridAdapter.getSpanCount(position);
            }
        });
        this.tabletVideoGridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$3v7GVaFWH_UXYlxqkHdR0qxjisQ
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$new$14$GroupCallActivity(view, i4);
            }
        });
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setDelayAnimations(false);
        defaultItemAnimator.setTranslationInterpolator(cubicBezierInterpolator);
        final TLRPC$InputPeer tLRPC$InputPeer = groupCallPeer;
        defaultItemAnimator.setRemoveDuration(350L);
        defaultItemAnimator.setAddDuration(350L);
        defaultItemAnimator.setMoveDuration(350L);
        this.tabletVideoGridView.setItemAnimator(new DefaultItemAnimator() { // from class: ir.eitaa.ui.GroupCallActivity.15
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onMoveAnimationUpdate(RecyclerView.ViewHolder holder) {
                GroupCallActivity.this.listView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                GroupCallActivity.this.updateLayout(true);
            }
        });
        this.tabletVideoGridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.GroupCallActivity.16
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        });
        this.tabletGridAdapter.setVisibility(this.tabletVideoGridView, false, false);
        this.tabletVideoGridView.setVisibility(8);
        this.buttonsContainer = new AnonymousClass17(context);
        int color = Theme.getColor("voipgroup_unmuteButton2");
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        this.radialMatrix = new Matrix();
        this.radialGradient = new RadialGradient(0.0f, 0.0f, AndroidUtilities.dp(160.0f), new int[]{Color.argb(50, iRed, iGreen, iBlue), Color.argb(0, iRed, iGreen, iBlue)}, (float[]) null, Shader.TileMode.CLAMP);
        Paint paint = new Paint(1);
        this.radialPaint = paint;
        paint.setShader(this.radialGradient);
        BlobDrawable blobDrawable = new BlobDrawable(9);
        this.tinyWaveDrawable = blobDrawable;
        BlobDrawable blobDrawable2 = new BlobDrawable(12);
        this.bigWaveDrawable = blobDrawable2;
        blobDrawable.minRadius = AndroidUtilities.dp(62.0f);
        blobDrawable.maxRadius = AndroidUtilities.dp(72.0f);
        blobDrawable.generateBlob();
        blobDrawable2.minRadius = AndroidUtilities.dp(65.0f);
        blobDrawable2.maxRadius = AndroidUtilities.dp(75.0f);
        blobDrawable2.generateBlob();
        blobDrawable.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_unmuteButton"), 38));
        blobDrawable2.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_unmuteButton"), 76));
        VoIPToggleButton voIPToggleButton = new VoIPToggleButton(context);
        this.soundButton = voIPToggleButton;
        voIPToggleButton.setCheckable(true);
        this.soundButton.setTextSize(12);
        this.buttonsContainer.addView(this.soundButton, LayoutHelper.createFrame(68, 80.0f));
        this.soundButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$bNZKigiV_NgR8SwAouxISTQEjBU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$15$GroupCallActivity(view);
            }
        });
        VoIPToggleButton voIPToggleButton2 = new VoIPToggleButton(context);
        this.cameraButton = voIPToggleButton2;
        voIPToggleButton2.setCheckable(true);
        this.cameraButton.setTextSize(12);
        this.cameraButton.showText(false, false);
        this.cameraButton.setCrossOffset(-AndroidUtilities.dpf2(3.5f));
        this.cameraButton.setVisibility(8);
        this.buttonsContainer.addView(this.cameraButton, LayoutHelper.createFrame(68, 80.0f));
        VoIPToggleButton voIPToggleButton3 = new VoIPToggleButton(context);
        this.flipButton = voIPToggleButton3;
        voIPToggleButton3.setCheckable(true);
        this.flipButton.setTextSize(12);
        this.flipButton.showText(false, false);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.flipButton.addView(rLottieImageView, LayoutHelper.createFrame(32, 32.0f, 0, 18.0f, 10.0f, 18.0f, 0.0f));
        RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.camera_flip, "2131623945", AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), true, (int[]) null);
        this.flipIcon = rLottieDrawable;
        rLottieImageView.setAnimation(rLottieDrawable);
        this.flipButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$ECLq7BZwxizHfumnuMCH84WlSC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws InterruptedException {
                this.f$0.lambda$new$16$GroupCallActivity(view);
            }
        });
        this.flipButton.setVisibility(8);
        this.buttonsContainer.addView(this.flipButton, LayoutHelper.createFrame(68, 80.0f));
        VoIPToggleButton voIPToggleButton4 = new VoIPToggleButton(context);
        this.leaveButton = voIPToggleButton4;
        voIPToggleButton4.setDrawBackground(false);
        this.leaveButton.setTextSize(12);
        this.leaveButton.setData(R.drawable.calls_decline, -1, Theme.getColor("voipgroup_leaveButton"), 0.3f, false, LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), false, false);
        this.buttonsContainer.addView(this.leaveButton, LayoutHelper.createFrame(68, 80.0f));
        this.leaveButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$EUSN4Q5kyxP2RUv_Vpu0TK5fKLU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalStateException, InterruptedException {
                this.f$0.lambda$new$17$GroupCallActivity(context, view);
            }
        });
        RLottieImageView rLottieImageView2 = new RLottieImageView(context) { // from class: ir.eitaa.ui.GroupCallActivity.18
            /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r13) throws java.lang.InterruptedException {
                /*
                    r12 = this;
                    int r0 = r13.getAction()
                    r1 = 1
                    if (r0 != 0) goto L25
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    int r0 = ir.eitaa.ui.GroupCallActivity.access$2200(r0)
                    if (r0 != 0) goto L25
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.messenger.ChatObject$Call r2 = r0.call
                    if (r2 == 0) goto L25
                    java.lang.Runnable r0 = ir.eitaa.ui.GroupCallActivity.access$14800(r0)
                    r2 = 300(0x12c, double:1.48E-321)
                    ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0, r2)
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.ui.GroupCallActivity.access$14902(r0, r1)
                    goto Lc7
                L25:
                    int r0 = r13.getAction()
                    r2 = 3
                    if (r0 == r1) goto L32
                    int r0 = r13.getAction()
                    if (r0 != r2) goto Lc7
                L32:
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    boolean r0 = ir.eitaa.ui.GroupCallActivity.access$14900(r0)
                    r3 = 0
                    if (r0 == 0) goto L4b
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    java.lang.Runnable r0 = ir.eitaa.ui.GroupCallActivity.access$14800(r0)
                    ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.ui.GroupCallActivity.access$14902(r0, r3)
                    goto Lc7
                L4b:
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    boolean r0 = ir.eitaa.ui.GroupCallActivity.access$15000(r0)
                    if (r0 == 0) goto Lc7
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    java.lang.Runnable r13 = ir.eitaa.ui.GroupCallActivity.access$15100(r13)
                    ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r13)
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.ui.GroupCallActivity.access$15200(r13, r3, r1)
                    ir.eitaa.messenger.voip.VoIPService r13 = ir.eitaa.messenger.voip.VoIPService.getSharedInstance()
                    if (r13 == 0) goto L78
                    ir.eitaa.messenger.voip.VoIPService r13 = ir.eitaa.messenger.voip.VoIPService.getSharedInstance()
                    r13.setMicMute(r1, r1, r3)
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.ui.Components.RLottieImageView r13 = ir.eitaa.ui.GroupCallActivity.access$12000(r13)
                    r0 = 2
                    r13.performHapticFeedback(r2, r0)
                L78:
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    java.util.ArrayList r13 = ir.eitaa.ui.GroupCallActivity.access$5800(r13)
                    r13.clear()
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    java.util.ArrayList r13 = ir.eitaa.ui.GroupCallActivity.access$5800(r13)
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = ir.eitaa.ui.GroupCallActivity.access$5900(r0)
                    r13.addAll(r0)
                    r13 = 0
                L91:
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = ir.eitaa.ui.GroupCallActivity.access$5800(r0)
                    int r0 = r0.size()
                    if (r13 >= r0) goto Laf
                    ir.eitaa.ui.GroupCallActivity r0 = ir.eitaa.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = ir.eitaa.ui.GroupCallActivity.access$5800(r0)
                    java.lang.Object r0 = r0.get(r13)
                    ir.eitaa.ui.Components.voip.GroupCallMiniTextureView r0 = (ir.eitaa.ui.Components.voip.GroupCallMiniTextureView) r0
                    r0.updateAttachState(r1)
                    int r13 = r13 + 1
                    goto L91
                Laf:
                    ir.eitaa.ui.GroupCallActivity r13 = ir.eitaa.ui.GroupCallActivity.this
                    ir.eitaa.ui.GroupCallActivity.access$15002(r13, r3)
                    r4 = 0
                    r6 = 0
                    r8 = 3
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r4, r6, r8, r9, r10, r11)
                    super.onTouchEvent(r13)
                    r13.recycle()
                    return r1
                Lc7:
                    boolean r13 = super.onTouchEvent(r13)
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.AnonymousClass18.onTouchEvent(android.view.MotionEvent):boolean");
            }

            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setClassName(Button.class.getName());
                info.setEnabled(GroupCallActivity.this.muteButtonState == 0 || GroupCallActivity.this.muteButtonState == 1);
                if (GroupCallActivity.this.muteButtonState != 1 || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("VoipMute", R.string.VoipMute)));
            }
        };
        this.muteButton = rLottieImageView2;
        rLottieImageView2.setAnimation(this.bigMicDrawable);
        this.muteButton.setScaleType(ImageView.ScaleType.CENTER);
        this.buttonsContainer.addView(this.muteButton, LayoutHelper.createFrame(122, 122, 49));
        this.muteButton.setOnClickListener(new AnonymousClass19());
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.radialProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(110.0f));
        this.radialProgressView.setStrokeWidth(4.0f);
        this.radialProgressView.setProgressColor(Theme.getColor("voipgroup_connectingProgress"));
        for (int i4 = 0; i4 < 2; i4++) {
            this.muteLabel[i4] = new TextView(context);
            this.muteLabel[i4].setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            this.muteLabel[i4].setTextSize(1, 18.0f);
            this.muteLabel[i4].setGravity(1);
            this.buttonsContainer.addView(this.muteLabel[i4], LayoutHelper.createFrame(-2, -2.0f, 81, 0.0f, 0.0f, 0.0f, 26.0f));
        }
        this.actionBar.setAlpha(0.0f);
        this.actionBar.getBackButton().setScaleX(0.9f);
        this.actionBar.getBackButton().setScaleY(0.9f);
        this.actionBar.getBackButton().setTranslationX(-AndroidUtilities.dp(14.0f));
        this.actionBar.getTitleTextView().setTranslationY(AndroidUtilities.dp(23.0f));
        this.actionBar.getSubtitleTextView().setTranslationY(AndroidUtilities.dp(20.0f));
        this.actionBar.getAdditionalSubtitleTextView().setTranslationY(AndroidUtilities.dp(20.0f));
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor("voipgroup_actionBarItems"));
        this.otherItem = actionBarMenuItem;
        actionBarMenuItem.setLongClickEnabled(false);
        this.otherItem.setIcon(R.drawable.ic_ab_other);
        this.otherItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.otherItem.setSubMenuOpenSide(2);
        this.otherItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$_EG-R2wR1DBuLTeWpzLKQRIxej8
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i5) {
                this.f$0.lambda$new$18$GroupCallActivity(i5);
            }
        });
        this.otherItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("voipgroup_actionBarItemsSelector"), 6));
        this.otherItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$PLl801gK1C3HP0_Ud-rjiW_AadE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$19$GroupCallActivity(context, view);
            }
        });
        this.otherItem.setPopupItemsColor(Theme.getColor("voipgroup_actionBarItems"), false);
        this.otherItem.setPopupItemsColor(Theme.getColor("voipgroup_actionBarItems"), true);
        ActionBarMenuItem actionBarMenuItem2 = new ActionBarMenuItem(context, null, 0, Theme.getColor("voipgroup_actionBarItems"));
        this.pipItem = actionBarMenuItem2;
        actionBarMenuItem2.setLongClickEnabled(false);
        this.pipItem.setIcon(R.drawable.msg_voice_pip);
        this.pipItem.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        this.pipItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("voipgroup_actionBarItemsSelector"), 6));
        this.pipItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$-PrHsc6n0AmYWnG39r-CRpkhhas
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$20$GroupCallActivity(view);
            }
        });
        ActionBarMenuItem actionBarMenuItem3 = new ActionBarMenuItem(context, null, 0, Theme.getColor("voipgroup_actionBarItems"));
        this.screenShareItem = actionBarMenuItem3;
        actionBarMenuItem3.setLongClickEnabled(false);
        this.screenShareItem.setIcon(R.drawable.msg_screencast);
        this.screenShareItem.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        this.screenShareItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("voipgroup_actionBarItemsSelector"), 6));
        this.screenShareItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$GmWqfGF6bFrV_IWYh70mXE1iMm4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$21$GroupCallActivity(view);
            }
        });
        this.titleTextView = new AnonymousClass20(context, context);
        View view = new View(context) { // from class: ir.eitaa.ui.GroupCallActivity.21
            @Override // android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), ActionBar.getCurrentActionBarHeight());
            }
        };
        this.actionBarBackground = view;
        view.setAlpha(0.0f);
        this.containerView.addView(this.actionBarBackground, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        this.containerView.addView(this.titleTextView, LayoutHelper.createFrame(-2, -2.0f, 51, 23.0f, 0.0f, 48.0f, 0.0f));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.menuItemsContainer = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.addView(this.screenShareItem, LayoutHelper.createLinear(48, 48));
        linearLayout.addView(this.pipItem, LayoutHelper.createLinear(48, 48));
        linearLayout.addView(this.otherItem, LayoutHelper.createLinear(48, 48));
        this.containerView.addView(linearLayout, LayoutHelper.createFrame(-2, 48, 53));
        View view2 = new View(context);
        this.actionBarShadow = view2;
        view2.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
        for (int i5 = 0; i5 < 2; i5++) {
            this.undoView[i5] = new UndoView(context) { // from class: ir.eitaa.ui.GroupCallActivity.22
                @Override // ir.eitaa.ui.Components.UndoView
                public void showWithAction(long did, int action, Object infoObject, Object infoObject2, Runnable actionRunnable, Runnable cancelRunnable) {
                    if (GroupCallActivity.this.previewDialog != null) {
                        return;
                    }
                    super.showWithAction(did, action, infoObject, infoObject2, actionRunnable, cancelRunnable);
                }
            };
            this.undoView[i5].setAdditionalTranslationY(AndroidUtilities.dp(10.0f));
            if (Build.VERSION.SDK_INT >= 21) {
                this.undoView[i5].setTranslationZ(AndroidUtilities.dp(5.0f));
            }
            this.containerView.addView(this.undoView[i5], LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        }
        AccountSelectCell accountSelectCell = new AccountSelectCell(context, true);
        this.accountSelectCell = accountSelectCell;
        accountSelectCell.setTag(R.id.width_tag, 240);
        this.otherItem.addSubItem(8, this.accountSelectCell, -2, AndroidUtilities.dp(48.0f));
        this.otherItem.setShowSubmenuByMove(false);
        this.accountSelectCell.setBackground(Theme.createRadSelectorDrawable(Theme.getColor("voipgroup_listSelector"), 6, 6));
        this.accountGap = this.otherItem.addGap(0);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem = this.otherItem.addSubItem(1, 0, (CharSequence) LocaleController.getString("VoipGroupAllCanSpeak", R.string.VoipGroupAllCanSpeak), true);
        this.everyoneItem = actionBarMenuSubItemAddSubItem;
        actionBarMenuSubItemAddSubItem.updateSelectorBackground(true, false);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem2 = this.otherItem.addSubItem(2, 0, (CharSequence) LocaleController.getString("VoipGroupOnlyAdminsCanSpeak", R.string.VoipGroupOnlyAdminsCanSpeak), true);
        this.adminItem = actionBarMenuSubItemAddSubItem2;
        actionBarMenuSubItemAddSubItem2.updateSelectorBackground(false, true);
        this.everyoneItem.setCheckColor("voipgroup_checkMenu");
        this.everyoneItem.setColors(Theme.getColor("voipgroup_checkMenu"), Theme.getColor("voipgroup_checkMenu"));
        this.adminItem.setCheckColor("voipgroup_checkMenu");
        this.adminItem.setColors(Theme.getColor("voipgroup_checkMenu"), Theme.getColor("voipgroup_checkMenu"));
        Paint paint2 = new Paint(1);
        paint2.setColor(Theme.getColor("voipgroup_actionBarItems"));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(AndroidUtilities.dp(1.5f));
        paint2.setStrokeCap(Paint.Cap.ROUND);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem3 = this.otherItem.addSubItem(10, R.drawable.msg_voice_speaker, null, LocaleController.getString("VoipGroupAudio", R.string.VoipGroupAudio), true, false);
        this.soundItem = actionBarMenuSubItemAddSubItem3;
        actionBarMenuSubItemAddSubItem3.setItemHeight(56);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem4 = this.otherItem.addSubItem(11, R.drawable.msg_noise_on, null, LocaleController.getString("VoipNoiseCancellation", R.string.VoipNoiseCancellation), true, false);
        this.noiseItem = actionBarMenuSubItemAddSubItem4;
        actionBarMenuSubItemAddSubItem4.setItemHeight(56);
        View viewAddDivider = this.otherItem.addDivider(ColorUtils.blendARGB(Theme.getColor("voipgroup_actionBar"), -16777216, 0.3f));
        this.soundItemDivider = viewAddDivider;
        ((ViewGroup.MarginLayoutParams) viewAddDivider.getLayoutParams()).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) this.soundItemDivider.getLayoutParams()).bottomMargin = 0;
        ActionBarMenuItem actionBarMenuItem4 = this.otherItem;
        RecordCallDrawable recordCallDrawable = this.recordCallDrawable;
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            i = R.string.VoipChannelEditTitle;
            str = "VoipChannelEditTitle";
        } else {
            i = R.string.VoipGroupEditTitle;
            str = "VoipGroupEditTitle";
        }
        this.editTitleItem = actionBarMenuItem4.addSubItem(6, R.drawable.msg_edit, recordCallDrawable, LocaleController.getString(str, i), true, false);
        this.permissionItem = this.otherItem.addSubItem(7, R.drawable.msg_permissions, this.recordCallDrawable, LocaleController.getString("VoipGroupEditPermissions", R.string.VoipGroupEditPermissions), false, false);
        this.inviteItem = this.otherItem.addSubItem(3, R.drawable.msg_link, LocaleController.getString("VoipGroupShareInviteLink", R.string.VoipGroupShareInviteLink));
        this.recordCallDrawable = new RecordCallDrawable();
        this.screenItem = this.otherItem.addSubItem(9, R.drawable.msg_screencast, LocaleController.getString("VoipChatStartScreenCapture", R.string.VoipChatStartScreenCapture));
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem5 = this.otherItem.addSubItem(5, 0, this.recordCallDrawable, LocaleController.getString("VoipGroupRecordCall", R.string.VoipGroupRecordCall), true, false);
        this.recordItem = actionBarMenuSubItemAddSubItem5;
        this.recordCallDrawable.setParentView(actionBarMenuSubItemAddSubItem5.getImageView());
        ActionBarMenuItem actionBarMenuItem5 = this.otherItem;
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            i2 = R.string.VoipChannelEndChat;
            str2 = "VoipChannelEndChat";
        } else {
            i2 = R.string.VoipGroupEndChat;
            str2 = "VoipGroupEndChat";
        }
        this.leaveItem = actionBarMenuItem5.addSubItem(4, R.drawable.msg_endcall, LocaleController.getString(str2, i2));
        this.otherItem.setPopupItemsSelectorColor(Theme.getColor("voipgroup_listSelector"));
        this.otherItem.getPopupLayout().setFitItems(true);
        this.soundItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.noiseItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.leaveItem.setColors(Theme.getColor("voipgroup_leaveCallMenu"), Theme.getColor("voipgroup_leaveCallMenu"));
        this.inviteItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.editTitleItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.permissionItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.recordItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        this.screenItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
        if (this.call != null) {
            initCreatedGroupCall();
        }
        this.leaveBackgroundPaint.setColor(Theme.getColor("voipgroup_leaveButton"));
        updateTitle(false);
        this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$zT0jPxf6oVkU23DZ22xZqBzKf-w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$22$GroupCallActivity(view3);
            }
        });
        this.fullscreenUsersListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.GroupCallActivity.23
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) child;
                if (!GroupCallActivity.this.renderersContainer.isAnimating() && !GroupCallActivity.this.fullscreenListItemAnimator.isRunning()) {
                    groupCallUserCell.setAlpha(1.0f);
                    groupCallUserCell.setTranslationX(0.0f);
                    groupCallUserCell.setTranslationY(0.0f);
                }
                if (groupCallUserCell.isRemoving(GroupCallActivity.this.fullscreenUsersListView) && groupCallUserCell.getRenderer() != null) {
                    return true;
                }
                if (groupCallUserCell.getTranslationY() != 0.0f && groupCallUserCell.getRenderer() != null && groupCallUserCell.getRenderer().primaryView != null) {
                    float top = GroupCallActivity.this.listView.getTop() - getTop();
                    float f = GroupCallActivity.this.renderersContainer.progressToFullscreenMode;
                    canvas.save();
                    float f2 = 1.0f - f;
                    canvas.clipRect(0.0f, top * f2, getMeasuredWidth(), ((GroupCallActivity.this.listView.getMeasuredHeight() + top) * f2) + (getMeasuredHeight() * f));
                    boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, child, drawingTime);
            }
        };
        DefaultItemAnimator defaultItemAnimator2 = new DefaultItemAnimator() { // from class: ir.eitaa.ui.GroupCallActivity.24
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onMoveAnimationUpdate(RecyclerView.ViewHolder holder) {
                GroupCallActivity.this.listView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                GroupCallActivity.this.updateLayout(true);
            }
        };
        this.fullscreenListItemAnimator = defaultItemAnimator2;
        this.fullscreenUsersListView.setClipToPadding(false);
        defaultItemAnimator2.setDelayAnimations(false);
        defaultItemAnimator2.setTranslationInterpolator(CubicBezierInterpolator.DEFAULT);
        defaultItemAnimator2.setRemoveDuration(350L);
        defaultItemAnimator2.setAddDuration(350L);
        defaultItemAnimator2.setMoveDuration(350L);
        this.fullscreenUsersListView.setItemAnimator(defaultItemAnimator2);
        this.fullscreenUsersListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.GroupCallActivity.25
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
            }
        });
        this.fullscreenUsersListView.setClipChildren(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.fullscreenUsersListView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView5 = this.fullscreenUsersListView;
        GroupCallFullscreenAdapter groupCallFullscreenAdapter = new GroupCallFullscreenAdapter(groupCall, this.currentAccount, this);
        this.fullscreenAdapter = groupCallFullscreenAdapter;
        recyclerListView5.setAdapter(groupCallFullscreenAdapter);
        this.fullscreenAdapter.setVisibility(this.fullscreenUsersListView, false);
        this.fullscreenUsersListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$ax6zZpku1Nvmyb8GK2UncqsxWkE
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view3, int i6) {
                this.f$0.lambda$new$23$GroupCallActivity(view3, i6);
            }
        });
        this.fullscreenUsersListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$MlsEWx0F_okUbgq7zYjrHi-OKJE
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view3, int i6) {
                return this.f$0.lambda$new$24$GroupCallActivity(view3, i6);
            }
        });
        this.fullscreenUsersListView.setVisibility(8);
        this.fullscreenUsersListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.GroupCallActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view3, RecyclerView parent, RecyclerView.State state) {
                parent.getChildAdapterPosition(view3);
                if (!GroupCallActivity.isLandscapeMode) {
                    outRect.set(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                } else {
                    outRect.set(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
                }
            }
        });
        AnonymousClass27 anonymousClass27 = new AnonymousClass27(context, this.listView, this.fullscreenUsersListView, this.attachedRenderers, this.call, this);
        this.renderersContainer = anonymousClass27;
        anonymousClass27.setClipChildren(false);
        this.fullscreenAdapter.setRenderersPool(this.attachedRenderers, this.renderersContainer);
        if (this.tabletVideoGridView != null) {
            this.tabletGridAdapter.setRenderersPool(this.attachedRenderers, this.renderersContainer);
        }
        AvatarPreviewPagerIndicator avatarPreviewPagerIndicator = new AvatarPreviewPagerIndicator(context);
        this.avatarPagerIndicator = avatarPreviewPagerIndicator;
        ProfileGalleryView profileGalleryView = new ProfileGalleryView(context, this.actionBar, this.listView, avatarPreviewPagerIndicator) { // from class: ir.eitaa.ui.GroupCallActivity.28
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        };
        this.avatarsViewPager = profileGalleryView;
        profileGalleryView.setImagesLayerNum(8192);
        profileGalleryView.setInvalidateWithParent(true);
        avatarPreviewPagerIndicator.setProfileGalleryView(profileGalleryView);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.GroupCallActivity.29
            Rect rect = new Rect();
            RectF rectF = new RectF();
            Path path = new Path();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iMin = Math.min(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin + getPaddingBottom(), 1073741824));
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (GroupCallActivity.this.progressToAvatarPreview != 1.0f) {
                    if (GroupCallActivity.this.scrimView == null || !GroupCallActivity.this.hasScrimAnchorView) {
                        if (GroupCallActivity.this.scrimFullscreenView != null && GroupCallActivity.this.scrimRenderer == null && GroupCallActivity.this.previewTextureTransitionEnabled) {
                            canvas.save();
                            float measuredHeight = (GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight() / 2.0f) * (getMeasuredHeight() / GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight());
                            int iDp = (int) (((1.0f - GroupCallActivity.this.progressToAvatarPreview) * measuredHeight) + (AndroidUtilities.dp(13.0f) * GroupCallActivity.this.progressToAvatarPreview));
                            int i6 = (int) (measuredHeight * (1.0f - GroupCallActivity.this.progressToAvatarPreview));
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getImageReceiver().setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().setRoundRadius(iDp, iDp, i6, i6);
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getImageReceiver().draw(canvas);
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().setRoundRadius(GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight() / 2);
                            canvas.restore();
                        }
                    } else {
                        canvas.save();
                        float measuredHeight2 = (GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2.0f) * (getMeasuredHeight() / GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight());
                        int iDp2 = (int) (((1.0f - GroupCallActivity.this.progressToAvatarPreview) * measuredHeight2) + (AndroidUtilities.dp(13.0f) * GroupCallActivity.this.progressToAvatarPreview));
                        int i7 = (int) (measuredHeight2 * (1.0f - GroupCallActivity.this.progressToAvatarPreview));
                        GroupCallActivity.this.scrimView.getAvatarWavesDrawable().draw(canvas, GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2, GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2, this);
                        GroupCallActivity.this.scrimView.getAvatarImageView().getImageReceiver().setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                        GroupCallActivity.this.scrimView.getAvatarImageView().setRoundRadius(iDp2, iDp2, i7, i7);
                        GroupCallActivity.this.scrimView.getAvatarImageView().getImageReceiver().draw(canvas);
                        GroupCallActivity.this.scrimView.getAvatarImageView().setRoundRadius(GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2);
                        canvas.restore();
                    }
                }
                GroupCallActivity.this.avatarsViewPager.setAlpha(GroupCallActivity.this.progressToAvatarPreview);
                this.path.reset();
                this.rectF.set(0.0f, 0.0f, getMeasuredHeight(), getMeasuredWidth());
                this.path.addRoundRect(this.rectF, new float[]{AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
                canvas.save();
                canvas.clipPath(this.path);
                View viewFindVideoActiveView = GroupCallActivity.this.avatarsViewPager.findVideoActiveView();
                if (viewFindVideoActiveView != null && GroupCallActivity.this.scrimRenderer != null && GroupCallActivity.this.scrimRenderer.isAttached() && !GroupCallActivity.this.drawingForBlur) {
                    canvas.save();
                    this.rect.setEmpty();
                    GroupCallActivity.this.avatarsViewPager.getChildVisibleRect(viewFindVideoActiveView, this.rect, null);
                    int measuredWidth = this.rect.left;
                    if (measuredWidth < (-GroupCallActivity.this.avatarsViewPager.getMeasuredWidth())) {
                        measuredWidth += GroupCallActivity.this.avatarsViewPager.getMeasuredWidth() * 2;
                    } else if (measuredWidth > GroupCallActivity.this.avatarsViewPager.getMeasuredWidth()) {
                        measuredWidth -= GroupCallActivity.this.avatarsViewPager.getMeasuredWidth() * 2;
                    }
                    canvas.translate(measuredWidth, 0.0f);
                    GroupCallActivity.this.scrimRenderer.draw(canvas);
                    canvas.restore();
                }
                super.dispatchDraw(canvas);
                canvas.restore();
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        };
        this.avatarPreviewContainer = frameLayout2;
        frameLayout2.setVisibility(8);
        profileGalleryView.setVisibility(0);
        profileGalleryView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ir.eitaa.ui.GroupCallActivity.30
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                GroupCallActivity.this.avatarsViewPager.getRealPosition(position);
                GroupCallActivity.this.avatarPagerIndicator.saveCurrentPageProgress();
                GroupCallActivity.this.avatarPagerIndicator.invalidate();
            }
        });
        this.blurredView = new View(context) { // from class: ir.eitaa.ui.GroupCallActivity.31
            @Override // android.view.View
            public void setAlpha(float alpha) {
                if (getAlpha() != alpha) {
                    super.setAlpha(alpha);
                    GroupCallActivity.this.checkContentOverlayed();
                }
            }
        };
        this.containerView.addView(this.renderersContainer);
        this.renderersContainer.addView(this.fullscreenUsersListView, LayoutHelper.createFrame(-1, 80.0f, 80, 0.0f, 0.0f, 0.0f, 100.0f));
        this.buttonsContainer.setWillNotDraw(false);
        View view3 = new View(context);
        this.buttonsBackgroundGradientView = view3;
        int[] iArr = this.gradientColors;
        iArr[0] = this.backgroundColor;
        iArr[1] = 0;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.gradientColors);
        this.buttonsBackgroundGradient = gradientDrawable;
        view3.setBackground(gradientDrawable);
        this.containerView.addView(view3, LayoutHelper.createFrame(-1, 60, 83));
        View view4 = new View(context);
        this.buttonsBackgroundGradientView2 = view4;
        view4.setBackgroundColor(this.gradientColors[0]);
        this.containerView.addView(view4, LayoutHelper.createFrame(-1, 0, 83));
        this.containerView.addView(this.buttonsContainer, LayoutHelper.createFrame(-1, 200, 81));
        this.containerView.addView(this.blurredView);
        frameLayout2.addView(profileGalleryView, LayoutHelper.createFrame(-1, -1.0f));
        frameLayout2.addView(avatarPreviewPagerIndicator, LayoutHelper.createFrame(-1, -1.0f, 0, 0.0f, 0.0f, 0.0f, 0.0f));
        this.containerView.addView(frameLayout2, LayoutHelper.createFrame(-1, -1.0f, 0, 14.0f, 14.0f, 14.0f, 14.0f));
        applyCallParticipantUpdates(false);
        this.listAdapter.notifyDataSetChanged();
        if (isTabletMode) {
            this.tabletGridAdapter.update(false, this.tabletVideoGridView);
        }
        this.oldCount = this.listAdapter.getItemCount();
        if (schedulePeer != null) {
            TextView textView = new TextView(context);
            this.scheduleInfoTextView = textView;
            textView.setGravity(17);
            this.scheduleInfoTextView.setTextColor(-8682615);
            this.scheduleInfoTextView.setTextSize(1, 14.0f);
            if (ChatObject.isChannel(this.currentChat) && !this.currentChat.megagroup) {
                this.scheduleInfoTextView.setTag(1);
            }
            this.containerView.addView(this.scheduleInfoTextView, LayoutHelper.createFrame(-2, -2.0f, 81, 21.0f, 0.0f, 21.0f, 100.0f));
            final NumberPicker numberPicker = new NumberPicker(context);
            numberPicker.setTextColor(-1);
            numberPicker.setSelectorColor(-9598483);
            numberPicker.setTextOffset(AndroidUtilities.dp(10.0f));
            numberPicker.setItemCount(5);
            final NumberPicker numberPicker2 = new NumberPicker(context) { // from class: ir.eitaa.ui.GroupCallActivity.32
                @Override // ir.eitaa.ui.Components.NumberPicker
                protected CharSequence getContentDescription(int value) {
                    return LocaleController.formatPluralString("Hours", value);
                }
            };
            numberPicker2.setItemCount(5);
            numberPicker2.setTextColor(-1);
            numberPicker2.setSelectorColor(-9598483);
            numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
            final NumberPicker numberPicker3 = new NumberPicker(context) { // from class: ir.eitaa.ui.GroupCallActivity.33
                @Override // ir.eitaa.ui.Components.NumberPicker
                protected CharSequence getContentDescription(int value) {
                    return LocaleController.formatPluralString("Minutes", value);
                }
            };
            numberPicker3.setItemCount(5);
            numberPicker3.setTextColor(-1);
            numberPicker3.setSelectorColor(-9598483);
            numberPicker3.setTextOffset(-AndroidUtilities.dp(34.0f));
            TextView textView2 = new TextView(context);
            this.scheduleButtonTextView = textView2;
            textView2.setLines(1);
            this.scheduleButtonTextView.setSingleLine(true);
            this.scheduleButtonTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.scheduleButtonTextView.setGravity(17);
            this.scheduleButtonTextView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), 0, 1056964608));
            this.scheduleButtonTextView.setTextColor(-1);
            this.scheduleButtonTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.scheduleButtonTextView.setTextSize(1, 14.0f);
            this.containerView.addView(this.scheduleButtonTextView, LayoutHelper.createFrame(-1, 48.0f, 81, 21.0f, 0.0f, 21.0f, 20.5f));
            this.scheduleButtonTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$hkao2giH9Iy7BbKIam6VPdAtJYQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    this.f$0.lambda$new$29$GroupCallActivity(numberPicker, numberPicker2, numberPicker3, chat, account, tLRPC$InputPeer, view5);
                }
            });
            LinearLayout linearLayout2 = new LinearLayout(context) { // from class: ir.eitaa.ui.GroupCallActivity.35
                boolean ignoreLayout = false;

                @Override // android.widget.LinearLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    this.ignoreLayout = true;
                    numberPicker.setItemCount(5);
                    numberPicker2.setItemCount(5);
                    numberPicker3.setItemCount(5);
                    numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    this.ignoreLayout = false;
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }

                @Override // android.view.View, android.view.ViewParent
                public void requestLayout() {
                    if (this.ignoreLayout) {
                        return;
                    }
                    super.requestLayout();
                }
            };
            this.scheduleTimerContainer = linearLayout2;
            linearLayout2.setWeightSum(1.0f);
            this.scheduleTimerContainer.setOrientation(0);
            this.containerView.addView(this.scheduleTimerContainer, LayoutHelper.createFrame(-1, 270.0f, 51, 0.0f, 50.0f, 0.0f, 0.0f));
            final long jCurrentTimeMillis = System.currentTimeMillis();
            final Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(jCurrentTimeMillis);
            final int i6 = calendar.get(1);
            int i7 = calendar.get(6);
            this.scheduleTimerContainer.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.5f));
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(365);
            numberPicker.setWrapSelectorWheel(false);
            numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$M2kQZrxBfHfrp4dcoZa29SyvdYM
                @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
                public final String format(int i8) {
                    return GroupCallActivity.lambda$new$30(jCurrentTimeMillis, calendar, i6, i8);
                }
            });
            NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$c-8IQFW17b5NaPli3eHAPmzu5JQ
                @Override // ir.eitaa.ui.Components.NumberPicker.OnValueChangeListener
                public final void onValueChange(NumberPicker numberPicker4, int i8, int i9) {
                    this.f$0.lambda$new$31$GroupCallActivity(numberPicker, numberPicker2, numberPicker3, numberPicker4, i8, i9);
                }
            };
            numberPicker.setOnValueChangedListener(onValueChangeListener);
            numberPicker2.setMinValue(0);
            numberPicker2.setMaxValue(23);
            this.scheduleTimerContainer.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.2f));
            numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$TRJsuJkRTg6ojq3CkO9c3m5RGao
                @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
                public final String format(int i8) {
                    return String.format("%02d", Integer.valueOf(i8));
                }
            });
            numberPicker2.setOnValueChangedListener(onValueChangeListener);
            numberPicker3.setMinValue(0);
            numberPicker3.setMaxValue(59);
            numberPicker3.setValue(0);
            numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$WHYl3r9jLaQ7Z-YQimccvm69wJQ
                @Override // ir.eitaa.ui.Components.NumberPicker.Formatter
                public final String format(int i8) {
                    return String.format("%02d", Integer.valueOf(i8));
                }
            });
            this.scheduleTimerContainer.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.3f));
            numberPicker3.setOnValueChangedListener(onValueChangeListener);
            calendar.setTimeInMillis(jCurrentTimeMillis + 10800000);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            int i8 = calendar.get(6);
            int i9 = calendar.get(12);
            int i10 = calendar.get(11);
            numberPicker.setValue(i7 != i8 ? 1 : 0);
            numberPicker3.setValue(i9);
            numberPicker2.setValue(i10);
            AlertsCreator.checkScheduleDate(this.scheduleButtonTextView, this.scheduleInfoTextView, 604800L, 2, numberPicker, numberPicker2, numberPicker3);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewGroup = (ViewGroup) getWindow().getDecorView();
        } else {
            viewGroup = this.containerView;
        }
        PinchToZoomHelper pinchToZoomHelper = new PinchToZoomHelper(viewGroup) { // from class: ir.eitaa.ui.GroupCallActivity.36
            @Override // ir.eitaa.ui.PinchToZoomHelper
            protected void invalidateViews() {
                super.invalidateViews();
                for (int i11 = 0; i11 < GroupCallActivity.this.avatarsViewPager.getChildCount(); i11++) {
                    GroupCallActivity.this.avatarsViewPager.getChildAt(i11).invalidate();
                }
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper
            protected void drawOverlays(Canvas canvas, float alpha, float parentOffsetX, float parentOffsetY, float clipTop, float clipBottom) {
                if (alpha > 0.0f) {
                    float x = GroupCallActivity.this.avatarPreviewContainer.getX() + ((BottomSheet) GroupCallActivity.this).containerView.getX();
                    float y = GroupCallActivity.this.avatarPreviewContainer.getY() + ((BottomSheet) GroupCallActivity.this).containerView.getY();
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(x, y, GroupCallActivity.this.avatarsViewPager.getMeasuredWidth() + x, GroupCallActivity.this.avatarsViewPager.getMeasuredHeight() + y);
                    canvas.saveLayerAlpha(rectF, (int) (alpha * 255.0f), 31);
                    canvas.translate(x, y);
                    GroupCallActivity.this.avatarPreviewContainer.draw(canvas);
                    canvas.restore();
                }
            }
        };
        this.pinchToZoomHelper = pinchToZoomHelper;
        pinchToZoomHelper.setCallback(new PinchToZoomHelper.Callback() { // from class: ir.eitaa.ui.GroupCallActivity.37
            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public /* synthetic */ TextureView getCurrentTextureView() {
                return PinchToZoomHelper.Callback.CC.$default$getCurrentTextureView(this);
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public void onZoomStarted(MessageObject messageObject) {
                GroupCallActivity.this.listView.cancelClickRunnables(true);
                GroupCallActivity.this.pinchToZoomHelper.getPhotoImage().setRoundRadius(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), 0, 0);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }

            @Override // ir.eitaa.ui.PinchToZoomHelper.Callback
            public void onZoomFinished(MessageObject messageObject) {
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        });
        profileGalleryView.setPinchToZoomHelper(this.pinchToZoomHelper);
        this.cameraButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$tI9IyPxcxOQZsG5oazB4Ysl_e54
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) throws InterruptedException {
                this.f$0.lambda$new$34$GroupCallActivity(context, view5);
            }
        });
        updateScheduleUI(false);
        updateItems();
        updateSpeakerPhoneIcon(false);
        updateState(false, false);
        setColorProgress(0.0f);
        updateSubtitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$9$GroupCallActivity(DialogInterface dialogInterface) {
        BaseFragment baseFragment = this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1);
        if (this.anyEnterEventSent && (baseFragment instanceof ChatActivity)) {
            ((ChatActivity) baseFragment).onEditTextDialogClose(true);
        }
    }

    /* renamed from: ir.eitaa.ui.GroupCallActivity$6, reason: invalid class name */
    class AnonymousClass6 extends ActionBar.ActionBarMenuOnItemClick {
        final /* synthetic */ Context val$context;

        static /* synthetic */ void lambda$onItemClick$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        AnonymousClass6(final Context val$context) {
            this.val$context = val$context;
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            final VoIPService sharedInstance;
            int color;
            int i;
            String str;
            if (id == -1) {
                GroupCallActivity.this.onBackPressed();
                return;
            }
            int i2 = 1;
            if (id == 1) {
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                groupCallActivity.call.call.join_muted = false;
                groupCallActivity.toggleAdminSpeak();
                return;
            }
            if (id == 2) {
                GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                groupCallActivity2.call.call.join_muted = true;
                groupCallActivity2.toggleAdminSpeak();
                return;
            }
            if (id == 3) {
                GroupCallActivity.this.getLink(false);
                return;
            }
            if (id == 4) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GroupCallActivity.this.getContext());
                if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                    builder.setTitle(LocaleController.getString("VoipChannelEndAlertTitle", R.string.VoipChannelEndAlertTitle));
                    builder.setMessage(LocaleController.getString("VoipChannelEndAlertText", R.string.VoipChannelEndAlertText));
                } else {
                    builder.setTitle(LocaleController.getString("VoipGroupEndAlertTitle", R.string.VoipGroupEndAlertTitle));
                    builder.setMessage(LocaleController.getString("VoipGroupEndAlertText", R.string.VoipGroupEndAlertText));
                }
                builder.setDialogButtonColorKey("voipgroup_listeningText");
                builder.setPositiveButton(LocaleController.getString("VoipGroupEnd", R.string.VoipGroupEnd), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$D0_bJEs4TO8vtZVGdfYj_lkCHJA
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) throws IllegalStateException, InterruptedException {
                        this.f$0.lambda$onItemClick$1$GroupCallActivity$6(dialogInterface, i3);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
                alertDialogCreate.show();
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("voipgroup_leaveCallMenu"));
                }
                alertDialogCreate.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
                return;
            }
            if (id == 9) {
                GroupCallActivity.this.screenShareItem.callOnClick();
                return;
            }
            if (id == 5) {
                GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                ChatObject.Call call = groupCallActivity3.call;
                if (call.recording) {
                    final boolean z = call.call.record_video_active;
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(groupCallActivity3.getContext());
                    builder2.setDialogButtonColorKey("voipgroup_listeningText");
                    builder2.setTitle(LocaleController.getString("VoipGroupStopRecordingTitle", R.string.VoipGroupStopRecordingTitle));
                    if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                        builder2.setMessage(LocaleController.getString("VoipChannelStopRecordingText", R.string.VoipChannelStopRecordingText));
                    } else {
                        builder2.setMessage(LocaleController.getString("VoipGroupStopRecordingText", R.string.VoipGroupStopRecordingText));
                    }
                    builder2.setPositiveButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$BQnRFt3nSgpedrXJc5Xg-F9f0kM
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.f$0.lambda$onItemClick$2$GroupCallActivity$6(z, dialogInterface, i3);
                        }
                    });
                    builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate2 = builder2.create();
                    alertDialogCreate2.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
                    alertDialogCreate2.show();
                    alertDialogCreate2.setTextColor(Theme.getColor("voipgroup_nameText"));
                    return;
                }
                Context context = GroupCallActivity.this.getContext();
                GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                new AnonymousClass1(context, groupCallActivity4.currentChat, groupCallActivity4.hasVideo).show();
                return;
            }
            if (id == 7) {
                GroupCallActivity.this.changingPermissions = true;
                GroupCallActivity.this.everyoneItem.setVisibility(0);
                GroupCallActivity.this.adminItem.setVisibility(0);
                GroupCallActivity.this.accountGap.setVisibility(8);
                GroupCallActivity.this.inviteItem.setVisibility(8);
                GroupCallActivity.this.leaveItem.setVisibility(8);
                GroupCallActivity.this.permissionItem.setVisibility(8);
                GroupCallActivity.this.editTitleItem.setVisibility(8);
                GroupCallActivity.this.recordItem.setVisibility(8);
                GroupCallActivity.this.screenItem.setVisibility(8);
                GroupCallActivity.this.accountSelectCell.setVisibility(8);
                GroupCallActivity.this.soundItem.setVisibility(8);
                GroupCallActivity.this.noiseItem.setVisibility(8);
                GroupCallActivity.this.otherItem.forceUpdatePopupPosition();
                return;
            }
            if (id == 6) {
                GroupCallActivity.this.enterEventSent = false;
                final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(GroupCallActivity.this.getContext());
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(GroupCallActivity.this.getContext(), true));
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(GroupCallActivity.this.getContext());
                builder3.setDialogButtonColorKey("voipgroup_listeningText");
                if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                    builder3.setTitle(LocaleController.getString("VoipChannelTitle", R.string.VoipChannelTitle));
                } else {
                    builder3.setTitle(LocaleController.getString("VoipGroupTitle", R.string.VoipGroupTitle));
                }
                builder3.setCheckFocusable(false);
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$UM3PbJSCnL8jFeoQpdQMEPcM0lI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                LinearLayout linearLayout = new LinearLayout(GroupCallActivity.this.getContext());
                linearLayout.setOrientation(1);
                builder3.setView(linearLayout);
                editTextBoldCursor.setTextSize(1, 16.0f);
                editTextBoldCursor.setTextColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.setMaxLines(1);
                editTextBoldCursor.setLines(1);
                editTextBoldCursor.setInputType(16385);
                editTextBoldCursor.setGravity(51);
                editTextBoldCursor.setSingleLine(true);
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setHint(GroupCallActivity.this.currentChat.title);
                editTextBoldCursor.setHintTextColor(Theme.getColor("voipgroup_lastSeenText"));
                editTextBoldCursor.setCursorColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
                editTextBoldCursor.setCursorWidth(1.5f);
                editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
                editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$0LxoNB2iEj41jgZkXPsdy6aFaTg
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                        return GroupCallActivity.AnonymousClass6.lambda$onItemClick$4(builder3, textView2, i3, keyEvent);
                    }
                });
                editTextBoldCursor.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.GroupCallActivity.6.2
                    boolean ignoreTextChange;

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        if (!this.ignoreTextChange && s.length() > 40) {
                            this.ignoreTextChange = true;
                            s.delete(40, s.length());
                            AndroidUtilities.shakeView(editTextBoldCursor, 2.0f, 0);
                            editTextBoldCursor.performHapticFeedback(3, 2);
                            this.ignoreTextChange = false;
                        }
                    }
                });
                if (!TextUtils.isEmpty(GroupCallActivity.this.call.call.title)) {
                    editTextBoldCursor.setText(GroupCallActivity.this.call.call.title);
                    editTextBoldCursor.setSelection(editTextBoldCursor.length());
                }
                builder3.setPositiveButton(LocaleController.getString("Save", R.string.Save), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$jfqfDykaXZKlfpplLMtcC9uvld8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        this.f$0.lambda$onItemClick$5$GroupCallActivity$6(editTextBoldCursor, builder3, dialogInterface, i3);
                    }
                });
                final AlertDialog alertDialogCreate3 = builder3.create();
                alertDialogCreate3.setBackgroundColor(Theme.getColor("voipgroup_inviteMembersBackground"));
                alertDialogCreate3.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$cQRBgbHvouo7PkNCc8cvubCORxA
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        this.f$0.lambda$onItemClick$6$GroupCallActivity$6(alertDialogCreate3, editTextBoldCursor, dialogInterface);
                    }
                });
                alertDialogCreate3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$DMpCCEW5oHDEYXaeaJT_66KwppE
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                alertDialogCreate3.show();
                alertDialogCreate3.setTextColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.requestFocus();
                return;
            }
            if (id == 8) {
                Context context2 = GroupCallActivity.this.getContext();
                GroupCallActivity groupCallActivity5 = GroupCallActivity.this;
                JoinCallAlert.open(context2, -groupCallActivity5.currentChat.id, groupCallActivity5.accountInstance, null, 2, GroupCallActivity.this.selfPeer, new JoinCallAlert.JoinCallAlertDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$4Lgy-P2hlYuVnaI_gMxwYaov8vg
                    @Override // ir.eitaa.ui.Components.JoinCallAlert.JoinCallAlertDelegate
                    public final void didSelectChat(TLRPC$InputPeer tLRPC$InputPeer, boolean z2, boolean z3) {
                        this.f$0.lambda$onItemClick$9$GroupCallActivity$6(tLRPC$InputPeer, z2, z3);
                    }
                });
                return;
            }
            if (id == 11) {
                SharedConfig.toggleNoiseSupression();
                VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                if (sharedInstance2 == null) {
                    return;
                }
                sharedInstance2.setNoiseSupressionEnabled(SharedConfig.noiseSupression);
                return;
            }
            if (id != 10 || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            arrayList.add(LocaleController.getString("VoipAudioRoutingSpeaker", R.string.VoipAudioRoutingSpeaker));
            arrayList2.add(Integer.valueOf(R.drawable.msg_voice_speaker));
            arrayList3.add(0);
            if (sharedInstance.hasEarpiece()) {
                if (sharedInstance.isHeadsetPlugged()) {
                    i = R.string.VoipAudioRoutingHeadset;
                    str = "VoipAudioRoutingHeadset";
                } else {
                    i = R.string.VoipAudioRoutingPhone;
                    str = "VoipAudioRoutingPhone";
                }
                arrayList.add(LocaleController.getString(str, i));
                arrayList2.add(Integer.valueOf(sharedInstance.isHeadsetPlugged() ? R.drawable.msg_voice_headphones : R.drawable.msg_voice_phone));
                arrayList3.add(1);
            }
            if (sharedInstance.isBluetoothHeadsetConnected()) {
                String string = sharedInstance.currentBluetoothDeviceName;
                if (string == null) {
                    string = LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth);
                }
                arrayList.add(string);
                arrayList2.add(Integer.valueOf(R.drawable.msg_voice_bluetooth));
                arrayList3.add(2);
            }
            int size = arrayList.size();
            CharSequence[] charSequenceArr = new CharSequence[size];
            int[] iArr = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                charSequenceArr[i3] = (CharSequence) arrayList.get(i3);
                iArr[i3] = ((Integer) arrayList2.get(i3)).intValue();
            }
            BottomSheet.Builder items = new BottomSheet.Builder(this.val$context).setTitle(LocaleController.getString("VoipSelectAudioOutput", R.string.VoipSelectAudioOutput), true).setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$bQZlAq7CgUamDP3U1McwmfZe7j4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    GroupCallActivity.AnonymousClass6.lambda$onItemClick$10(sharedInstance, arrayList3, dialogInterface, i4);
                }
            });
            BottomSheet bottomSheetCreate = items.create();
            bottomSheetCreate.setBackgroundColor(Theme.getColor("voipgroup_listViewBackgroundUnscrolled"));
            if (sharedInstance.getCurrentAudioRoute() == 1) {
                i2 = 0;
            } else if (sharedInstance.getCurrentAudioRoute() != 0) {
                i2 = 2;
            }
            items.show();
            bottomSheetCreate.setTitleColor(Theme.getColor("voipgroup_nameText"));
            for (int i4 = 0; i4 < bottomSheetCreate.getItemViews().size(); i4++) {
                BottomSheet.BottomSheetCell bottomSheetCell = bottomSheetCreate.getItemViews().get(i4);
                if (i4 == i2) {
                    color = Theme.getColor("voipgroup_listeningText");
                } else {
                    color = Theme.getColor("voipgroup_nameText");
                }
                bottomSheetCell.setTextColor(color);
                bottomSheetCell.setIconColor(color);
                bottomSheetCell.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("voipgroup_actionBarItems"), 12), 2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$GroupCallActivity$6(DialogInterface dialogInterface, int i) throws IllegalStateException, InterruptedException {
            if (GroupCallActivity.this.call.isScheduled()) {
                TLRPC$ChatFull chatFull = GroupCallActivity.this.accountInstance.getMessagesController().getChatFull(GroupCallActivity.this.currentChat.id);
                if (chatFull != null) {
                    chatFull.flags &= -2097153;
                    chatFull.call = null;
                    GroupCallActivity.this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(GroupCallActivity.this.currentChat.id), Long.valueOf(GroupCallActivity.this.call.call.id), Boolean.FALSE);
                }
                TLRPC$TL_phone_discardGroupCall tLRPC$TL_phone_discardGroupCall = new TLRPC$TL_phone_discardGroupCall();
                tLRPC$TL_phone_discardGroupCall.call = GroupCallActivity.this.call.getInputGroupCall();
                GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_discardGroupCall, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$7IF-gtqsNw0Y2oTGy_4hnsW9WUU
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$0$GroupCallActivity$6(tLObject, tLRPC$TL_error);
                    }
                });
            } else if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().hangUp(1);
            }
            GroupCallActivity.this.dismiss();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$GroupCallActivity$6(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject instanceof TLRPC$TL_updates) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$TL_updates) tLObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$GroupCallActivity$6(boolean z, DialogInterface dialogInterface, int i) {
            GroupCallActivity.this.call.toggleRecord(null, 0);
            GroupCallActivity.this.getUndoView().showWithAction(0L, z ? R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle : 40, (Runnable) null);
        }

        /* renamed from: ir.eitaa.ui.GroupCallActivity$6$1, reason: invalid class name */
        class AnonymousClass1 extends GroupCallRecordAlert {
            AnonymousClass1(Context context, TLRPC$Chat chat, boolean hasVideo) {
                super(context, chat, hasVideo);
            }

            @Override // ir.eitaa.ui.Components.GroupCallRecordAlert
            protected void onStartRecord(final int type) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setDialogButtonColorKey("voipgroup_listeningText");
                GroupCallActivity.this.enterEventSent = false;
                builder.setTitle(LocaleController.getString("VoipGroupStartRecordingTitle", R.string.VoipGroupStartRecordingTitle));
                if (type == 0) {
                    builder.setMessage(LocaleController.getString("VoipGroupStartRecordingText", R.string.VoipGroupStartRecordingText));
                } else if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                    builder.setMessage(LocaleController.getString("VoipChannelStartRecordingVideoText", R.string.VoipChannelStartRecordingVideoText));
                } else {
                    builder.setMessage(LocaleController.getString("VoipGroupStartRecordingVideoText", R.string.VoipGroupStartRecordingVideoText));
                }
                builder.setCheckFocusable(false);
                final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(getContext());
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(getContext(), Theme.getColor("voipgroup_windowBackgroundWhiteInputField"), Theme.getColor("voipgroup_windowBackgroundWhiteInputFieldActivated")));
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(1);
                builder.setView(linearLayout);
                editTextBoldCursor.setTextSize(1, 16.0f);
                editTextBoldCursor.setTextColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.setMaxLines(1);
                editTextBoldCursor.setLines(1);
                editTextBoldCursor.setInputType(16385);
                editTextBoldCursor.setGravity(51);
                editTextBoldCursor.setSingleLine(true);
                editTextBoldCursor.setHint(LocaleController.getString("VoipGroupSaveFileHint", R.string.VoipGroupSaveFileHint));
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setHintTextColor(Theme.getColor("voipgroup_lastSeenText"));
                editTextBoldCursor.setCursorColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
                editTextBoldCursor.setCursorWidth(1.5f);
                editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 0, 24, 12));
                editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$1$z5R_M9WW38eYBmsyPws0AiEiAeg
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        return GroupCallActivity.AnonymousClass6.AnonymousClass1.lambda$onStartRecord$0(builder, textView, i, keyEvent);
                    }
                });
                final AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_inviteMembersBackground"));
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$1$sDfFBbqB92TBRbN6xBAsbve6jgw
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        this.f$0.lambda$onStartRecord$1$GroupCallActivity$6$1(alertDialogCreate, editTextBoldCursor, dialogInterface);
                    }
                });
                alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$1$-7Ze8VW8YKIZDUzGW3qEX_g2z6o
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                builder.setPositiveButton(LocaleController.getString("Start", R.string.Start), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$1$A6RqdVEmW2ggLSNDUEP34b-7aCE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onStartRecord$3$GroupCallActivity$6$1(editTextBoldCursor, type, dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$1$OPopOuLXWeikM-dMLTHjs427uzw
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                AlertDialog alertDialogCreate2 = builder.create();
                alertDialogCreate2.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
                alertDialogCreate2.show();
                alertDialogCreate2.setTextColor(Theme.getColor("voipgroup_nameText"));
                editTextBoldCursor.requestFocus();
            }

            static /* synthetic */ boolean lambda$onStartRecord$0(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
                AndroidUtilities.hideKeyboard(textView);
                builder.create().getButton(-1).callOnClick();
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onStartRecord$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onStartRecord$1$GroupCallActivity$6$1(AlertDialog alertDialog, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) {
                GroupCallActivity.this.makeFocusable(null, alertDialog, editTextBoldCursor, true);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onStartRecord$3, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onStartRecord$3$GroupCallActivity$6$1(EditTextBoldCursor editTextBoldCursor, int i, DialogInterface dialogInterface, int i2) {
                GroupCallActivity.this.call.toggleRecord(editTextBoldCursor.getText().toString(), i);
                AndroidUtilities.hideKeyboard(editTextBoldCursor);
                GroupCallActivity.this.getUndoView().showWithAction(0L, i == 0 ? 39 : 100, (Runnable) null);
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().playStartRecordSound();
                }
            }
        }

        static /* synthetic */ boolean lambda$onItemClick$4(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
            AndroidUtilities.hideKeyboard(textView);
            builder.create().getButton(-1).callOnClick();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$5$GroupCallActivity$6(EditTextBoldCursor editTextBoldCursor, AlertDialog.Builder builder, DialogInterface dialogInterface, int i) {
            AndroidUtilities.hideKeyboard(editTextBoldCursor);
            GroupCallActivity.this.call.setTitle(editTextBoldCursor.getText().toString());
            builder.getDismissRunnable().run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$6$GroupCallActivity$6(AlertDialog alertDialog, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) {
            GroupCallActivity.this.makeFocusable(null, alertDialog, editTextBoldCursor, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$9$GroupCallActivity$6(TLRPC$InputPeer tLRPC$InputPeer, boolean z, boolean z2) {
            TLObject chat;
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            if (groupCallActivity.call == null) {
                return;
            }
            boolean z3 = tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser;
            if (z3) {
                chat = groupCallActivity.accountInstance.getMessagesController().getUser(Long.valueOf(tLRPC$InputPeer.user_id));
            } else {
                chat = tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat ? groupCallActivity.accountInstance.getMessagesController().getChat(Long.valueOf(tLRPC$InputPeer.chat_id)) : groupCallActivity.accountInstance.getMessagesController().getChat(Long.valueOf(tLRPC$InputPeer.channel_id));
            }
            TLObject tLObject = chat;
            if (GroupCallActivity.this.call.isScheduled()) {
                GroupCallActivity.this.getUndoView().showWithAction(0L, 37, tLObject, GroupCallActivity.this.currentChat, (Runnable) null, (Runnable) null);
                if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
                    GroupCallActivity.this.selfPeer = new TLRPC$TL_peerChannel();
                    GroupCallActivity.this.selfPeer.channel_id = tLRPC$InputPeer.channel_id;
                } else if (z3) {
                    GroupCallActivity.this.selfPeer = new TLRPC$TL_peerUser();
                    GroupCallActivity.this.selfPeer.user_id = tLRPC$InputPeer.user_id;
                } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                    GroupCallActivity.this.selfPeer = new TLRPC$TL_peerChat();
                    GroupCallActivity.this.selfPeer.chat_id = tLRPC$InputPeer.chat_id;
                }
                GroupCallActivity.this.schedulePeer = tLRPC$InputPeer;
                TLRPC$ChatFull chatFull = GroupCallActivity.this.accountInstance.getMessagesController().getChatFull(GroupCallActivity.this.currentChat.id);
                if (chatFull != null) {
                    chatFull.groupcall_default_join_as = GroupCallActivity.this.selfPeer;
                    if (chatFull instanceof TLRPC$TL_chatFull) {
                        chatFull.flags |= 32768;
                    } else {
                        chatFull.flags |= ConnectionsManager.FileTypeFile;
                    }
                }
                TLRPC$TL_phone_saveDefaultGroupCallJoinAs tLRPC$TL_phone_saveDefaultGroupCallJoinAs = new TLRPC$TL_phone_saveDefaultGroupCallJoinAs();
                tLRPC$TL_phone_saveDefaultGroupCallJoinAs.peer = MessagesController.getInputPeer(GroupCallActivity.this.currentChat);
                tLRPC$TL_phone_saveDefaultGroupCallJoinAs.join_as = tLRPC$InputPeer;
                GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_saveDefaultGroupCallJoinAs, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$6$Wh05EOS2mEgWO7xUIZPHlY4SNgU
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                        GroupCallActivity.AnonymousClass6.lambda$onItemClick$8(tLObject2, tLRPC$TL_error);
                    }
                });
                GroupCallActivity.this.updateItems();
                return;
            }
            if (VoIPService.getSharedInstance() == null || !z) {
                return;
            }
            GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
            groupCallActivity2.call.participants.get(MessageObject.getPeerId(groupCallActivity2.selfPeer));
            VoIPService.getSharedInstance().setGroupCallPeer(tLRPC$InputPeer);
            GroupCallActivity.this.userSwitchObject = tLObject;
        }

        static /* synthetic */ void lambda$onItemClick$10(VoIPService voIPService, ArrayList arrayList, DialogInterface dialogInterface, int i) {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            voIPService.setAudioOutput(((Integer) arrayList.get(i)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$10$GroupCallActivity(int[] iArr, float[] fArr, boolean[] zArr) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        for (int i = 0; i < iArr.length; i++) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.participantsBySources.get(iArr[i]);
            if (tLRPC$TL_groupCallParticipant != null) {
                if (!this.renderersContainer.inFullscreenMode) {
                    int iIndexOf = (this.delayedGroupCallUpdated ? this.oldParticipants : this.call.visibleParticipants).indexOf(tLRPC$TL_groupCallParticipant);
                    if (iIndexOf >= 0 && (viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(iIndexOf + this.listAdapter.usersStartRow)) != null) {
                        View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                        if (view instanceof GroupCallUserCell) {
                            ((GroupCallUserCell) view).setAmplitude(fArr[i] * 15.0f);
                            if (viewHolderFindViewHolderForAdapterPosition.itemView == this.scrimView && !this.contentFullyOverlayed) {
                                this.containerView.invalidate();
                            }
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < this.fullscreenUsersListView.getChildCount(); i2++) {
                        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) this.fullscreenUsersListView.getChildAt(i2);
                        if (MessageObject.getPeerId(groupCallUserCell.getParticipant().peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                            groupCallUserCell.setAmplitude(fArr[i] * 15.0f);
                        }
                    }
                }
                this.renderersContainer.setAmplitude(tLRPC$TL_groupCallParticipant, fArr[i] * 15.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$12$GroupCallActivity(View view, int i, float f, float f2) {
        if (view instanceof GroupCallGridCell) {
            fullscreenFor(((GroupCallGridCell) view).getParticipant());
            return;
        }
        if (view instanceof GroupCallUserCell) {
            showMenuForCell((GroupCallUserCell) view);
            return;
        }
        if (view instanceof GroupCallInvitedCell) {
            GroupCallInvitedCell groupCallInvitedCell = (GroupCallInvitedCell) view;
            if (groupCallInvitedCell.getUser() == null) {
                return;
            }
            this.parentActivity.switchToAccount(this.currentAccount, true);
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", groupCallInvitedCell.getUser().id);
            if (groupCallInvitedCell.hasAvatarSet()) {
                bundle.putBoolean("expandPhoto", true);
            }
            this.parentActivity.lambda$runLinkRequest$39$LaunchActivity(new ProfileActivity(bundle));
            dismiss();
            return;
        }
        if (i == this.listAdapter.addMemberRow) {
            if (ChatObject.isChannel(this.currentChat)) {
                TLRPC$Chat tLRPC$Chat = this.currentChat;
                if (!tLRPC$Chat.megagroup && !TextUtils.isEmpty(tLRPC$Chat.username)) {
                    getLink(false);
                    return;
                }
            }
            TLRPC$ChatFull chatFull = this.accountInstance.getMessagesController().getChatFull(this.currentChat.id);
            if (chatFull == null) {
                return;
            }
            this.enterEventSent = false;
            Context context = getContext();
            int currentAccount = this.accountInstance.getCurrentAccount();
            TLRPC$Chat tLRPC$Chat2 = this.currentChat;
            ChatObject.Call call = this.call;
            GroupVoipInviteAlert groupVoipInviteAlert = new GroupVoipInviteAlert(context, currentAccount, tLRPC$Chat2, chatFull, call.participants, call.invitedUsersMap);
            this.groupVoipInviteAlert = groupVoipInviteAlert;
            groupVoipInviteAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$4tBn14K0YSP8trrh0EoDf4qYrOY
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$11$GroupCallActivity(dialogInterface);
                }
            });
            this.groupVoipInviteAlert.setDelegate(new GroupVoipInviteAlert.GroupVoipInviteAlertDelegate() { // from class: ir.eitaa.ui.GroupCallActivity.13
                @Override // ir.eitaa.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void copyInviteLink() {
                    GroupCallActivity.this.getLink(true);
                }

                @Override // ir.eitaa.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void inviteUser(long id) {
                    GroupCallActivity.this.inviteUserToCall(id, true);
                }

                @Override // ir.eitaa.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void needOpenSearch(MotionEvent ev, EditTextBoldCursor editText) {
                    if (GroupCallActivity.this.enterEventSent) {
                        return;
                    }
                    if (ev.getX() > editText.getLeft() && ev.getX() < editText.getRight() && ev.getY() > editText.getTop() && ev.getY() < editText.getBottom()) {
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        groupCallActivity.makeFocusable(groupCallActivity.groupVoipInviteAlert, null, editText, true);
                    } else {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        groupCallActivity2.makeFocusable(groupCallActivity2.groupVoipInviteAlert, null, editText, false);
                    }
                }
            });
            this.groupVoipInviteAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$11$GroupCallActivity(DialogInterface dialogInterface) {
        this.groupVoipInviteAlert = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$13$GroupCallActivity(View view, int i) {
        if (view instanceof GroupCallGridCell) {
            return showMenuForCell(view);
        }
        if (!(view instanceof GroupCallUserCell)) {
            return false;
        }
        updateItems();
        return ((GroupCallUserCell) view).clickMuteButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$14$GroupCallActivity(View view, int i) {
        GroupCallGridCell groupCallGridCell = (GroupCallGridCell) view;
        if (groupCallGridCell.getParticipant() != null) {
            fullscreenFor(groupCallGridCell.getParticipant());
        }
    }

    /* renamed from: ir.eitaa.ui.GroupCallActivity$17, reason: invalid class name */
    class AnonymousClass17 extends FrameLayout {
        AnimatorSet currentButtonsAnimation;
        int currentLightColor;
        final OvershootInterpolator overshootInterpolator;

        AnonymousClass17(Context context) {
            super(context);
            this.overshootInterpolator = new OvershootInterpolator(1.5f);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (!GroupCallActivity.isLandscapeMode) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(460.0f), View.MeasureSpec.getSize(widthMeasureSpec)), 1073741824);
            }
            for (int i = 0; i < 2; i++) {
                if (!GroupCallActivity.isLandscapeMode || GroupCallActivity.isTabletMode) {
                    GroupCallActivity.this.muteLabel[i].getLayoutParams().width = -2;
                } else {
                    GroupCallActivity.this.muteLabel[i].getLayoutParams().width = (int) (View.MeasureSpec.getSize(widthMeasureSpec) / 0.68f);
                }
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp(122.0f)) / 2;
            int measuredHeight = getMeasuredHeight();
            int i = GroupCallActivity.this.cameraButton.getVisibility() != 0 ? 4 : 5;
            if (GroupCallActivity.this.soundButton.getVisibility() != 0) {
                i--;
            }
            if (GroupCallActivity.this.flipButton.getVisibility() != 0) {
                i--;
            }
            if (!GroupCallActivity.isLandscapeMode || GroupCallActivity.isTabletMode) {
                if (GroupCallActivity.this.renderersContainer.inFullscreenMode && !GroupCallActivity.isTabletMode) {
                    int measuredWidth2 = getMeasuredWidth() / i;
                    if (GroupCallActivity.this.soundButton.getVisibility() == 0) {
                        int i2 = measuredWidth2 / 2;
                        int measuredWidth3 = i2 - (GroupCallActivity.this.cameraButton.getMeasuredWidth() / 2);
                        int measuredHeight2 = getMeasuredHeight() - GroupCallActivity.this.cameraButton.getMeasuredHeight();
                        GroupCallActivity.this.cameraButton.layout(measuredWidth3, measuredHeight2, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth3, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight2);
                        int measuredWidth4 = (i2 + (i == 4 ? measuredWidth2 : 0)) - (GroupCallActivity.this.leaveButton.getMeasuredWidth() / 2);
                        int measuredHeight3 = getMeasuredHeight() - GroupCallActivity.this.soundButton.getMeasuredHeight();
                        GroupCallActivity.this.soundButton.layout(measuredWidth4, measuredHeight3, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth4, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight3);
                    } else {
                        int i3 = measuredWidth2 / 2;
                        int measuredWidth5 = ((i == 4 ? measuredWidth2 : 0) + i3) - (GroupCallActivity.this.cameraButton.getMeasuredWidth() / 2);
                        int measuredHeight4 = getMeasuredHeight() - GroupCallActivity.this.cameraButton.getMeasuredHeight();
                        GroupCallActivity.this.cameraButton.layout(measuredWidth5, measuredHeight4, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth5, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight4);
                        int measuredWidth6 = i3 - (GroupCallActivity.this.flipButton.getMeasuredWidth() / 2);
                        int measuredHeight5 = getMeasuredHeight() - GroupCallActivity.this.flipButton.getMeasuredHeight();
                        GroupCallActivity.this.flipButton.layout(measuredWidth6, measuredHeight5, GroupCallActivity.this.flipButton.getMeasuredWidth() + measuredWidth6, GroupCallActivity.this.flipButton.getMeasuredHeight() + measuredHeight5);
                    }
                    int i4 = measuredWidth2 / 2;
                    int measuredWidth7 = ((i == 4 ? measuredWidth2 * 3 : measuredWidth2 * 2) + i4) - (GroupCallActivity.this.leaveButton.getMeasuredWidth() / 2);
                    int measuredHeight6 = getMeasuredHeight() - GroupCallActivity.this.leaveButton.getMeasuredHeight();
                    GroupCallActivity.this.leaveButton.layout(measuredWidth7, measuredHeight6, GroupCallActivity.this.leaveButton.getMeasuredWidth() + measuredWidth7, GroupCallActivity.this.leaveButton.getMeasuredHeight() + measuredHeight6);
                    int measuredWidth8 = (i4 + (i == 4 ? measuredWidth2 * 2 : measuredWidth2)) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2);
                    int measuredHeight7 = (getMeasuredHeight() - GroupCallActivity.this.leaveButton.getMeasuredHeight()) - ((GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(52.0f)) / 2);
                    GroupCallActivity.this.muteButton.layout(measuredWidth8, measuredHeight7, GroupCallActivity.this.muteButton.getMeasuredWidth() + measuredWidth8, GroupCallActivity.this.muteButton.getMeasuredHeight() + measuredHeight7);
                    float fDp = AndroidUtilities.dp(52.0f) / (GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(8.0f));
                    GroupCallActivity.this.muteButton.animate().scaleX(fDp).scaleY(fDp).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    for (int i5 = 0; i5 < 2; i5++) {
                        int measuredWidth9 = (i == 4 ? measuredWidth2 * 2 : measuredWidth2) + ((measuredWidth2 - GroupCallActivity.this.muteLabel[i5].getMeasuredWidth()) / 2);
                        int iDp = measuredHeight - AndroidUtilities.dp(27.0f);
                        GroupCallActivity.this.muteLabel[i5].layout(measuredWidth9, iDp, GroupCallActivity.this.muteLabel[i5].getMeasuredWidth() + measuredWidth9, GroupCallActivity.this.muteLabel[i5].getMeasuredHeight() + iDp);
                        GroupCallActivity.this.muteLabel[i5].animate().scaleX(0.687f).scaleY(0.687f).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    }
                } else {
                    int iDp2 = AndroidUtilities.dp(0.0f);
                    if (GroupCallActivity.this.soundButton.getVisibility() == 0) {
                        if (GroupCallActivity.this.cameraButton.getVisibility() == 0) {
                            int measuredWidth10 = (measuredWidth - GroupCallActivity.this.cameraButton.getMeasuredWidth()) / 2;
                            int measuredHeight8 = (measuredHeight - GroupCallActivity.this.cameraButton.getMeasuredHeight()) / 2;
                            GroupCallActivity.this.cameraButton.layout(measuredWidth10, measuredHeight8, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth10, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight8);
                            int measuredWidth11 = (measuredWidth - GroupCallActivity.this.soundButton.getMeasuredWidth()) / 2;
                            int measuredHeight9 = (measuredHeight - GroupCallActivity.this.leaveButton.getMeasuredHeight()) / 2;
                            GroupCallActivity.this.soundButton.layout(measuredWidth11, measuredHeight9, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth11, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight9);
                        } else {
                            int measuredWidth12 = (measuredWidth - GroupCallActivity.this.soundButton.getMeasuredWidth()) / 2;
                            int measuredHeight10 = (measuredHeight - GroupCallActivity.this.soundButton.getMeasuredHeight()) / 2;
                            GroupCallActivity.this.soundButton.layout(measuredWidth12, measuredHeight10, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth12, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight10);
                        }
                    } else {
                        int iDp3 = GroupCallActivity.this.flipButton.getVisibility() == 0 ? AndroidUtilities.dp(28.0f) : 0;
                        int measuredWidth13 = (measuredWidth - GroupCallActivity.this.flipButton.getMeasuredWidth()) / 2;
                        int measuredHeight11 = (((measuredHeight - GroupCallActivity.this.flipButton.getMeasuredHeight()) / 2) + iDp2) - iDp3;
                        GroupCallActivity.this.flipButton.layout(measuredWidth13, measuredHeight11, GroupCallActivity.this.flipButton.getMeasuredWidth() + measuredWidth13, GroupCallActivity.this.flipButton.getMeasuredHeight() + measuredHeight11);
                        int measuredWidth14 = (measuredWidth - GroupCallActivity.this.cameraButton.getMeasuredWidth()) / 2;
                        int measuredHeight12 = ((measuredHeight - GroupCallActivity.this.cameraButton.getMeasuredHeight()) / 2) + iDp2 + iDp3;
                        GroupCallActivity.this.cameraButton.layout(measuredWidth14, measuredHeight12, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth14, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight12);
                    }
                    int measuredHeight13 = ((measuredHeight - GroupCallActivity.this.leaveButton.getMeasuredHeight()) / 2) + iDp2;
                    int measuredWidth15 = (getMeasuredWidth() - measuredWidth) + ((measuredWidth - GroupCallActivity.this.leaveButton.getMeasuredWidth()) / 2);
                    GroupCallActivity.this.leaveButton.layout(measuredWidth15, measuredHeight13, GroupCallActivity.this.leaveButton.getMeasuredWidth() + measuredWidth15, GroupCallActivity.this.leaveButton.getMeasuredHeight() + measuredHeight13);
                    int measuredWidth16 = (getMeasuredWidth() - GroupCallActivity.this.muteButton.getMeasuredWidth()) / 2;
                    int measuredHeight14 = ((measuredHeight - GroupCallActivity.this.muteButton.getMeasuredHeight()) / 2) - AndroidUtilities.dp(9.0f);
                    GroupCallActivity.this.muteButton.layout(measuredWidth16, measuredHeight14, GroupCallActivity.this.muteButton.getMeasuredWidth() + measuredWidth16, GroupCallActivity.this.muteButton.getMeasuredHeight() + measuredHeight14);
                    GroupCallActivity.this.muteButton.animate().setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).scaleX(1.0f).scaleY(1.0f).start();
                    for (int i6 = 0; i6 < 2; i6++) {
                        int measuredWidth17 = (getMeasuredWidth() - GroupCallActivity.this.muteLabel[i6].getMeasuredWidth()) / 2;
                        int iDp4 = (measuredHeight - AndroidUtilities.dp(12.0f)) - GroupCallActivity.this.muteLabel[i6].getMeasuredHeight();
                        GroupCallActivity.this.muteLabel[i6].layout(measuredWidth17, iDp4, GroupCallActivity.this.muteLabel[i6].getMeasuredWidth() + measuredWidth17, GroupCallActivity.this.muteLabel[i6].getMeasuredHeight() + iDp4);
                        GroupCallActivity.this.muteLabel[i6].animate().scaleX(1.0f).scaleY(1.0f).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    }
                }
            } else {
                int measuredHeight15 = getMeasuredHeight() / i;
                if (GroupCallActivity.this.soundButton.getVisibility() == 0) {
                    int i7 = measuredHeight15 / 2;
                    int measuredHeight16 = i7 - (GroupCallActivity.this.cameraButton.getMeasuredHeight() / 2);
                    int measuredWidth18 = (getMeasuredWidth() - GroupCallActivity.this.cameraButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.cameraButton.layout(measuredWidth18, measuredHeight16, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth18, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight16);
                    int measuredHeight17 = (i7 + (i == 4 ? measuredHeight15 : 0)) - (GroupCallActivity.this.soundButton.getMeasuredHeight() / 2);
                    int measuredWidth19 = (getMeasuredWidth() - GroupCallActivity.this.soundButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.soundButton.layout(measuredWidth19, measuredHeight17, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth19, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight17);
                } else {
                    int i8 = measuredHeight15 / 2;
                    int measuredHeight18 = i8 - (GroupCallActivity.this.flipButton.getMeasuredHeight() / 2);
                    int measuredWidth20 = (getMeasuredWidth() - GroupCallActivity.this.flipButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.flipButton.layout(measuredWidth20, measuredHeight18, GroupCallActivity.this.flipButton.getMeasuredWidth() + measuredWidth20, GroupCallActivity.this.flipButton.getMeasuredHeight() + measuredHeight18);
                    int measuredHeight19 = (i8 + (i == 4 ? measuredHeight15 : 0)) - (GroupCallActivity.this.cameraButton.getMeasuredHeight() / 2);
                    int measuredWidth21 = (getMeasuredWidth() - GroupCallActivity.this.cameraButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.cameraButton.layout(measuredWidth21, measuredHeight19, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth21, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight19);
                }
                int i9 = measuredHeight15 / 2;
                int measuredHeight20 = ((i == 4 ? measuredHeight15 * 3 : measuredHeight15 * 2) + i9) - (GroupCallActivity.this.leaveButton.getMeasuredHeight() / 2);
                int measuredWidth22 = (getMeasuredWidth() - GroupCallActivity.this.leaveButton.getMeasuredWidth()) >> 1;
                GroupCallActivity.this.leaveButton.layout(measuredWidth22, measuredHeight20, GroupCallActivity.this.leaveButton.getMeasuredWidth() + measuredWidth22, GroupCallActivity.this.leaveButton.getMeasuredHeight() + measuredHeight20);
                int measuredWidth23 = (((i == 4 ? measuredHeight15 * 2 : measuredHeight15) + i9) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2)) - AndroidUtilities.dp(4.0f);
                int measuredWidth24 = (getMeasuredWidth() - GroupCallActivity.this.muteButton.getMeasuredWidth()) >> 1;
                if (i == 3) {
                    measuredWidth23 -= AndroidUtilities.dp(6.0f);
                }
                GroupCallActivity.this.muteButton.layout(measuredWidth24, measuredWidth23, GroupCallActivity.this.muteButton.getMeasuredWidth() + measuredWidth24, GroupCallActivity.this.muteButton.getMeasuredHeight() + measuredWidth23);
                float fDp2 = AndroidUtilities.dp(52.0f) / (GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(8.0f));
                GroupCallActivity.this.muteButton.animate().cancel();
                GroupCallActivity.this.muteButton.setScaleX(fDp2);
                GroupCallActivity.this.muteButton.setScaleY(fDp2);
                for (int i10 = 0; i10 < 2; i10++) {
                    int measuredWidth25 = (getMeasuredWidth() - GroupCallActivity.this.muteLabel[i10].getMeasuredWidth()) >> 1;
                    int i11 = i == 4 ? measuredHeight15 * 2 : measuredHeight15;
                    int measuredWidth26 = ((i9 + i11) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2)) - AndroidUtilities.dp(4.0f);
                    if (i == 3) {
                        measuredWidth26 -= AndroidUtilities.dp(6.0f);
                    }
                    int measuredWidth27 = (int) (measuredWidth26 + (GroupCallActivity.this.muteButton.getMeasuredWidth() * 0.687f) + AndroidUtilities.dp(4.0f));
                    if (GroupCallActivity.this.muteLabel[i10].getMeasuredHeight() + measuredWidth27 > i11 + measuredHeight15) {
                        measuredWidth27 -= AndroidUtilities.dp(4.0f);
                    }
                    GroupCallActivity.this.muteLabel[i10].layout(measuredWidth25, measuredWidth27, GroupCallActivity.this.muteLabel[i10].getMeasuredWidth() + measuredWidth25, GroupCallActivity.this.muteLabel[i10].getMeasuredHeight() + measuredWidth27);
                    GroupCallActivity.this.muteLabel[i10].setScaleX(0.687f);
                    GroupCallActivity.this.muteLabel[i10].setScaleY(0.687f);
                }
            }
            if (GroupCallActivity.this.animateButtonsOnNextLayout) {
                AnimatorSet animatorSet = new AnimatorSet();
                boolean z = false;
                for (int i12 = 0; i12 < getChildCount(); i12++) {
                    View childAt = getChildAt(i12);
                    Float f = (Float) GroupCallActivity.this.buttonsAnimationParamsX.get(childAt);
                    Float f2 = (Float) GroupCallActivity.this.buttonsAnimationParamsY.get(childAt);
                    if (f != null && f2 != null) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) FrameLayout.TRANSLATION_X, f.floatValue() - childAt.getLeft(), 0.0f));
                        animatorSet.playTogether(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) FrameLayout.TRANSLATION_Y, f2.floatValue() - childAt.getTop(), 0.0f));
                        z = true;
                    }
                }
                if (z) {
                    AnimatorSet animatorSet2 = this.currentButtonsAnimation;
                    if (animatorSet2 != null) {
                        animatorSet2.removeAllListeners();
                        this.currentButtonsAnimation.cancel();
                    }
                    this.currentButtonsAnimation = animatorSet;
                    animatorSet.setDuration(350L);
                    animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.17.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            AnonymousClass17.this.currentButtonsAnimation = null;
                            for (int i13 = 0; i13 < AnonymousClass17.this.getChildCount(); i13++) {
                                View childAt2 = AnonymousClass17.this.getChildAt(i13);
                                childAt2.setTranslationX(0.0f);
                                childAt2.setTranslationY(0.0f);
                            }
                        }
                    });
                    animatorSet.start();
                }
                GroupCallActivity.this.buttonsAnimationParamsX.clear();
                GroupCallActivity.this.buttonsAnimationParamsY.clear();
            }
            GroupCallActivity.this.animateButtonsOnNextLayout = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:104:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x03ab  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x03c9  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x065e  */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0661  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x06da  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x07ea  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x07ee  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0826  */
        /* JADX WARN: Removed duplicated region for block: B:174:0x087e  */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0891  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x08f3  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x0921  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x0943  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0950  */
        /* JADX WARN: Removed duplicated region for block: B:193:0x0953  */
        /* JADX WARN: Removed duplicated region for block: B:196:0x09b9  */
        /* JADX WARN: Removed duplicated region for block: B:199:0x09ce A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:202:0x09d6  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x0a45 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:211:0x0a75  */
        /* JADX WARN: Removed duplicated region for block: B:217:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x033e  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0363  */
        @Override // android.view.ViewGroup, android.view.View
        @android.annotation.SuppressLint({"DrawAllocation"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void dispatchDraw(android.graphics.Canvas r25) {
            /*
                Method dump skipped, instructions count: 2681
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.AnonymousClass17.dispatchDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (child == GroupCallActivity.this.muteButton && child.getScaleX() != 1.0f) {
                canvas.save();
                float scaleX = (((1.0f / GroupCallActivity.this.muteButton.getScaleX()) - 1.0f) * 0.2f) + 1.0f;
                canvas.scale(scaleX, scaleX, child.getX() + (child.getMeasuredWidth() / 2.0f), child.getY() + (child.getMeasuredHeight() / 2.0f));
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                canvas.restore();
                return zDrawChild;
            }
            return super.drawChild(canvas, child, drawingTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$15$GroupCallActivity(View view) {
        ChatObject.Call call = this.call;
        if (call == null || call.isScheduled()) {
            getLink(false);
        } else {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(getContext(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$16$GroupCallActivity(View view) throws InterruptedException {
        this.renderersContainer.delayHideUi();
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            if (sharedInstance.getVideoState(false) == 2) {
                sharedInstance.switchCamera();
                if (this.flipIconCurrentEndFrame == 18) {
                    RLottieDrawable rLottieDrawable = this.flipIcon;
                    this.flipIconCurrentEndFrame = 39;
                    rLottieDrawable.setCustomEndFrame(39);
                    this.flipIcon.start();
                } else {
                    this.flipIcon.setCurrentFrame(0, false);
                    RLottieDrawable rLottieDrawable2 = this.flipIcon;
                    this.flipIconCurrentEndFrame = 18;
                    rLottieDrawable2.setCustomEndFrame(18);
                    this.flipIcon.start();
                }
                for (int i = 0; i < this.attachedRenderers.size(); i++) {
                    GroupCallMiniTextureView groupCallMiniTextureView = this.attachedRenderers.get(i);
                    ChatObject.VideoParticipant videoParticipant = groupCallMiniTextureView.participant;
                    if (videoParticipant.participant.self && !videoParticipant.presentation) {
                        groupCallMiniTextureView.startFlipAnimation();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$17$GroupCallActivity(Context context, View view) throws IllegalStateException, InterruptedException {
        this.renderersContainer.delayHideUi();
        ChatObject.Call call = this.call;
        if (call == null || call.isScheduled()) {
            dismiss();
        } else {
            updateItems();
            onLeaveClick(context, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$nEsKRiqx-0Jp5YUVAPzKNum_Cn0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dismiss();
                }
            }, false);
        }
    }

    /* renamed from: ir.eitaa.ui.GroupCallActivity$19, reason: invalid class name */
    class AnonymousClass19 implements View.OnClickListener {
        Runnable finishRunnable = new Runnable() { // from class: ir.eitaa.ui.GroupCallActivity.19.1
            @Override // java.lang.Runnable
            public void run() {
                GroupCallActivity.this.muteButton.setAnimation(GroupCallActivity.this.bigMicDrawable);
                GroupCallActivity.this.playingHandAnimation = false;
            }
        };

        AnonymousClass19() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) throws InterruptedException {
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            if (groupCallActivity.call == null || groupCallActivity.muteButtonState == 3) {
                return;
            }
            if (GroupCallActivity.this.muteButtonState == 5) {
                if (GroupCallActivity.this.startingGroupCall) {
                    return;
                }
                v.performHapticFeedback(3, 2);
                GroupCallActivity.this.startingGroupCall = true;
                TLRPC$TL_phone_startScheduledGroupCall tLRPC$TL_phone_startScheduledGroupCall = new TLRPC$TL_phone_startScheduledGroupCall();
                tLRPC$TL_phone_startScheduledGroupCall.call = GroupCallActivity.this.call.getInputGroupCall();
                GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_startScheduledGroupCall, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$19$WoqdYY710ZD20-FCWXVsukN8AHg
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onClick$0$GroupCallActivity$19(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (GroupCallActivity.this.muteButtonState == 7 || GroupCallActivity.this.muteButtonState == 6) {
                if (GroupCallActivity.this.muteButtonState == 6 && GroupCallActivity.this.reminderHintView != null) {
                    GroupCallActivity.this.reminderHintView.hide();
                }
                TLRPC$TL_phone_toggleGroupCallStartSubscription tLRPC$TL_phone_toggleGroupCallStartSubscription = new TLRPC$TL_phone_toggleGroupCallStartSubscription();
                tLRPC$TL_phone_toggleGroupCallStartSubscription.call = GroupCallActivity.this.call.getInputGroupCall();
                GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                TLRPC$GroupCall tLRPC$GroupCall = groupCallActivity2.call.call;
                boolean z = !tLRPC$GroupCall.schedule_start_subscribed;
                tLRPC$GroupCall.schedule_start_subscribed = z;
                tLRPC$TL_phone_toggleGroupCallStartSubscription.subscribed = z;
                groupCallActivity2.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_toggleGroupCallStartSubscription, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$19$RL-7Fhqf-7HuN9UulIzFXTzvoPA
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onClick$1$GroupCallActivity$19(tLObject, tLRPC$TL_error);
                    }
                });
                GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                groupCallActivity3.updateMuteButton(groupCallActivity3.call.call.schedule_start_subscribed ? 7 : 6, true);
                return;
            }
            if (VoIPService.getSharedInstance() == null || GroupCallActivity.this.isStillConnecting()) {
                return;
            }
            int i = 0;
            if (GroupCallActivity.this.muteButtonState == 2 || GroupCallActivity.this.muteButtonState == 4) {
                if (GroupCallActivity.this.playingHandAnimation) {
                    return;
                }
                GroupCallActivity.this.playingHandAnimation = true;
                AndroidUtilities.shakeView(GroupCallActivity.this.muteLabel[0], 2.0f, 0);
                v.performHapticFeedback(3, 2);
                int iNextInt = Utilities.random.nextInt(100);
                int i2 = 540;
                if (iNextInt < 32) {
                    i2 = R.styleable.AppCompatTheme_windowNoTitle;
                } else if (iNextInt < 64) {
                    i2 = 240;
                    i = R.styleable.AppCompatTheme_windowNoTitle;
                } else if (iNextInt < 97) {
                    i2 = 420;
                    i = 240;
                } else if (iNextInt == 98) {
                    i = 420;
                } else {
                    i2 = 720;
                    i = 540;
                }
                GroupCallActivity.this.handDrawables.setCustomEndFrame(i2);
                GroupCallActivity.this.handDrawables.setOnFinishCallback(this.finishRunnable, i2 - 1);
                GroupCallActivity.this.muteButton.setAnimation(GroupCallActivity.this.handDrawables);
                GroupCallActivity.this.handDrawables.setCurrentFrame(i);
                GroupCallActivity.this.muteButton.playAnimation();
                if (GroupCallActivity.this.muteButtonState == 2) {
                    GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                    long peerId = MessageObject.getPeerId(groupCallActivity4.call.participants.get(MessageObject.getPeerId(groupCallActivity4.selfPeer)).peer);
                    VoIPService.getSharedInstance().editCallMember(DialogObject.isUserDialog(peerId) ? GroupCallActivity.this.accountInstance.getMessagesController().getUser(Long.valueOf(peerId)) : GroupCallActivity.this.accountInstance.getMessagesController().getChat(Long.valueOf(-peerId)), null, null, null, Boolean.TRUE, null);
                    GroupCallActivity.this.updateMuteButton(4, true);
                    return;
                }
                return;
            }
            if (GroupCallActivity.this.muteButtonState == 0) {
                GroupCallActivity.this.updateMuteButton(1, true);
                VoIPService.getSharedInstance().setMicMute(false, false, true);
                GroupCallActivity.this.muteButton.performHapticFeedback(3, 2);
            } else {
                GroupCallActivity.this.updateMuteButton(0, true);
                VoIPService.getSharedInstance().setMicMute(true, false, true);
                GroupCallActivity.this.muteButton.performHapticFeedback(3, 2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onClick$0$GroupCallActivity$19(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onClick$1$GroupCallActivity$19(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$18$GroupCallActivity(int i) {
        this.actionBar.getActionBarMenuOnItemClick().onItemClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$19$GroupCallActivity(Context context, View view) {
        ChatObject.Call call = this.call;
        if (call == null || this.renderersContainer.inFullscreenMode) {
            return;
        }
        if (call.call.join_muted) {
            this.everyoneItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
            this.everyoneItem.setChecked(false);
            this.adminItem.setColors(Theme.getColor("voipgroup_checkMenu"), Theme.getColor("voipgroup_checkMenu"));
            this.adminItem.setChecked(true);
        } else {
            this.everyoneItem.setColors(Theme.getColor("voipgroup_checkMenu"), Theme.getColor("voipgroup_checkMenu"));
            this.everyoneItem.setChecked(true);
            this.adminItem.setColors(Theme.getColor("voipgroup_actionBarItems"), Theme.getColor("voipgroup_actionBarItems"));
            this.adminItem.setChecked(false);
        }
        this.changingPermissions = false;
        this.otherItem.hideSubItem(1);
        this.otherItem.hideSubItem(2);
        if (VoIPService.getSharedInstance() != null && (VoIPService.getSharedInstance().hasEarpiece() || VoIPService.getSharedInstance().isBluetoothHeadsetConnected())) {
            int currentAudioRoute = VoIPService.getSharedInstance().getCurrentAudioRoute();
            if (currentAudioRoute == 2) {
                this.soundItem.setIcon(R.drawable.msg_voice_bluetooth);
                this.soundItem.setSubtext(VoIPService.getSharedInstance().currentBluetoothDeviceName != null ? VoIPService.getSharedInstance().currentBluetoothDeviceName : LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth));
            } else {
                int i = R.drawable.msg_voice_phone;
                if (currentAudioRoute == 0) {
                    ActionBarMenuSubItem actionBarMenuSubItem = this.soundItem;
                    if (VoIPService.getSharedInstance().isHeadsetPlugged()) {
                        i = R.drawable.msg_voice_headphones;
                    }
                    actionBarMenuSubItem.setIcon(i);
                    this.soundItem.setSubtext(VoIPService.getSharedInstance().isHeadsetPlugged() ? LocaleController.getString("VoipAudioRoutingHeadset", R.string.VoipAudioRoutingHeadset) : LocaleController.getString("VoipAudioRoutingPhone", R.string.VoipAudioRoutingPhone));
                } else if (currentAudioRoute == 1) {
                    if (((AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).isSpeakerphoneOn()) {
                        this.soundItem.setIcon(R.drawable.msg_voice_speaker);
                        this.soundItem.setSubtext(LocaleController.getString("VoipAudioRoutingSpeaker", R.string.VoipAudioRoutingSpeaker));
                    } else {
                        this.soundItem.setIcon(R.drawable.msg_voice_phone);
                        this.soundItem.setSubtext(LocaleController.getString("VoipAudioRoutingPhone", R.string.VoipAudioRoutingPhone));
                    }
                }
            }
        }
        updateItems();
        this.otherItem.toggleSubMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$20$GroupCallActivity(View view) {
        if (Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(this.parentActivity)) {
            GroupCallPip.clearForce();
            dismiss();
        } else {
            AlertsCreator.createDrawOverlayGroupCallPermissionDialog(getContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$21$GroupCallActivity(View view) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (sharedInstance.getVideoState(true) == 2) {
            sharedInstance.stopScreenCapture();
        } else {
            startScreenCapture();
        }
    }

    /* renamed from: ir.eitaa.ui.GroupCallActivity$20, reason: invalid class name */
    class AnonymousClass20 extends AudioPlayerAlert.ClippingTextViewSwitcher {
        final /* synthetic */ Context val$context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass20(Context context, final Context val$context) {
            super(context);
            this.val$context = val$context;
        }

        @Override // ir.eitaa.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
        protected TextView createTextView() {
            final TextView textView = new TextView(this.val$context);
            textView.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            textView.setTextSize(1, 20.0f);
            textView.setTypeface(AndroidUtilities.getFontFamily(true));
            textView.setGravity(51);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$20$Ej-ytvSBqeI3JVJkT6DWvk6oWkk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createTextView$0$GroupCallActivity$20(textView, view);
                }
            });
            return textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$createTextView$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$createTextView$0$GroupCallActivity$20(TextView textView, View view) {
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            ChatObject.Call call = groupCallActivity.call;
            if (call == null || !call.recording) {
                return;
            }
            groupCallActivity.showRecordHint(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$22$GroupCallActivity(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$23$GroupCallActivity(View view, int i) {
        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) view;
        if (groupCallUserCell.getVideoParticipant() == null) {
            fullscreenFor(new ChatObject.VideoParticipant(groupCallUserCell.getParticipant(), false, false));
        } else {
            fullscreenFor(groupCallUserCell.getVideoParticipant());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$24$GroupCallActivity(View view, int i) {
        if (showMenuForCell(view)) {
            this.listView.performHapticFeedback(0);
        }
        return false;
    }

    /* renamed from: ir.eitaa.ui.GroupCallActivity$27, reason: invalid class name */
    class AnonymousClass27 extends GroupCallRenderersContainer {
        ValueAnimator uiVisibilityAnimator;

        AnonymousClass27(Context context, RecyclerView listView, RecyclerView fullscreenListView, ArrayList attachedRenderers, ChatObject.Call call, GroupCallActivity groupCallActivity) {
            super(context, listView, fullscreenListView, attachedRenderers, call, groupCallActivity);
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer
        protected void update() {
            super.update();
            ((BottomSheet) GroupCallActivity.this).navBarColor = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_actionBarUnscrolled"), Theme.getColor("voipgroup_actionBar"), Math.max(GroupCallActivity.this.colorProgress, GroupCallActivity.this.renderersContainer == null ? 0.0f : GroupCallActivity.this.renderersContainer.progressToFullscreenMode), 1.0f);
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            groupCallActivity.setColorProgress(groupCallActivity.colorProgress);
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer, android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
            if (child == GroupCallActivity.this.scrimRenderer) {
                return true;
            }
            return super.drawChild(canvas, child, drawingTime);
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer
        protected void onFullScreenModeChanged(boolean startAnimation) throws InterruptedException {
            GroupCallActivity.this.delayedGroupCallUpdated = startAnimation;
            if (GroupCallActivity.isTabletMode) {
                if (startAnimation || !GroupCallActivity.this.renderersContainer.inFullscreenMode) {
                    return;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                groupCallActivity.tabletGridAdapter.setVisibility(groupCallActivity.tabletVideoGridView, false, true);
                return;
            }
            if (startAnimation) {
                GroupCallActivity.this.undoView[0].hide(false, 1);
                GroupCallActivity.this.renderersContainer.undoView[0].hide(false, 2);
                if (!GroupCallActivity.this.renderersContainer.inFullscreenMode) {
                    GroupCallActivity.this.listView.setVisibility(0);
                    GroupCallActivity.this.actionBar.setVisibility(0);
                }
                GroupCallActivity.this.updateState(true, false);
                GroupCallActivity.this.buttonsContainer.requestLayout();
                if (GroupCallActivity.this.fullscreenUsersListView.getVisibility() != 0) {
                    GroupCallActivity.this.fullscreenUsersListView.setVisibility(0);
                    GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                    groupCallActivity2.fullscreenAdapter.setVisibility(groupCallActivity2.fullscreenUsersListView, true);
                    GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                    groupCallActivity3.fullscreenAdapter.update(false, groupCallActivity3.fullscreenUsersListView);
                } else {
                    GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                    groupCallActivity4.fullscreenAdapter.setVisibility(groupCallActivity4.fullscreenUsersListView, true);
                    GroupCallActivity.this.applyCallParticipantUpdates(true);
                }
            } else {
                if (GroupCallActivity.this.renderersContainer.inFullscreenMode) {
                    GroupCallActivity.this.actionBar.setVisibility(8);
                    GroupCallActivity.this.listView.setVisibility(8);
                } else {
                    GroupCallActivity.this.fullscreenUsersListView.setVisibility(8);
                    GroupCallActivity groupCallActivity5 = GroupCallActivity.this;
                    groupCallActivity5.fullscreenAdapter.setVisibility(groupCallActivity5.fullscreenUsersListView, false);
                }
                if (GroupCallActivity.this.fullscreenUsersListView.getVisibility() == 0) {
                    for (int i = 0; i < GroupCallActivity.this.fullscreenUsersListView.getChildCount(); i++) {
                        View childAt = GroupCallActivity.this.fullscreenUsersListView.getChildAt(i);
                        childAt.setAlpha(1.0f);
                        childAt.setScaleX(1.0f);
                        childAt.setScaleY(1.0f);
                        childAt.setTranslationX(0.0f);
                        childAt.setTranslationY(0.0f);
                        ((GroupCallFullscreenAdapter.GroupCallUserCell) childAt).setProgressToFullscreen(GroupCallActivity.this.renderersContainer.progressToFullscreenMode);
                    }
                }
            }
            GroupCallActivity.this.buttonsBackgroundGradientView2.setVisibility(startAnimation ? 0 : 8);
            if (GroupCallActivity.this.delayedGroupCallUpdated) {
                return;
            }
            GroupCallActivity.this.applyCallParticipantUpdates(true);
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer
        public void onUiVisibilityChanged() {
            if (GroupCallActivity.this.renderersContainer == null) {
                return;
            }
            final boolean zIsUiVisible = GroupCallActivity.this.renderersContainer.isUiVisible();
            ValueAnimator valueAnimator = this.uiVisibilityAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.uiVisibilityAnimator.cancel();
            }
            float[] fArr = new float[2];
            fArr[0] = GroupCallActivity.this.progressToHideUi;
            fArr[1] = zIsUiVisible ? 0.0f : 1.0f;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            this.uiVisibilityAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$27$5maaa72JjhRp7wJL8iHEIS5v1hk
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onUiVisibilityChanged$0$GroupCallActivity$27(valueAnimator2);
                }
            });
            this.uiVisibilityAnimator.setDuration(350L);
            this.uiVisibilityAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.uiVisibilityAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.27.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    AnonymousClass27 anonymousClass27 = AnonymousClass27.this;
                    anonymousClass27.uiVisibilityAnimator = null;
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.progressToHideUi = zIsUiVisible ? 0.0f : 1.0f;
                    groupCallActivity.renderersContainer.setProgressToHideUi(GroupCallActivity.this.progressToHideUi);
                    GroupCallActivity.this.fullscreenUsersListView.invalidate();
                    ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                    GroupCallActivity.this.buttonsContainer.invalidate();
                }
            });
            this.uiVisibilityAnimator.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onUiVisibilityChanged$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onUiVisibilityChanged$0$GroupCallActivity$27(ValueAnimator valueAnimator) {
            GroupCallActivity.this.progressToHideUi = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GroupCallActivity.this.renderersContainer.setProgressToHideUi(GroupCallActivity.this.progressToHideUi);
            GroupCallActivity.this.fullscreenUsersListView.invalidate();
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity.this.buttonsContainer.invalidate();
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer
        protected boolean canHideUI() {
            return super.canHideUI() && GroupCallActivity.this.previewDialog == null;
        }

        @Override // ir.eitaa.ui.Components.voip.GroupCallRenderersContainer
        protected void onBackPressed() {
            GroupCallActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$29$GroupCallActivity(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, final TLRPC$Chat tLRPC$Chat, AccountInstance accountInstance, final TLRPC$InputPeer tLRPC$InputPeer, View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.scheduleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(600L);
        this.scheduleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$q_GAZCA0Y1p2FdNWfLxB9fpMf18
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$25$GroupCallActivity(valueAnimator);
            }
        });
        this.scheduleAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                GroupCallActivity.this.scheduleAnimator = null;
            }
        });
        this.scheduleAnimator.start();
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            this.titleTextView.setText(LocaleController.getString("VoipChannelVoiceChat", R.string.VoipChannelVoiceChat), true);
        } else {
            this.titleTextView.setText(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat), true);
        }
        Calendar calendar = Calendar.getInstance();
        boolean zCheckScheduleDate = AlertsCreator.checkScheduleDate(null, null, 604800L, 3, numberPicker, numberPicker2, numberPicker3);
        calendar.setTimeInMillis(System.currentTimeMillis() + (numberPicker.getValue() * 24 * 3600 * 1000));
        calendar.set(11, numberPicker2.getValue());
        calendar.set(12, numberPicker3.getValue());
        if (zCheckScheduleDate) {
            calendar.set(13, 0);
        }
        this.scheduleStartAt = (int) (calendar.getTimeInMillis() / 1000);
        updateScheduleUI(false);
        TLRPC$TL_phone_createGroupCall tLRPC$TL_phone_createGroupCall = new TLRPC$TL_phone_createGroupCall();
        tLRPC$TL_phone_createGroupCall.peer = MessagesController.getInputPeer(tLRPC$Chat);
        tLRPC$TL_phone_createGroupCall.random_id = Utilities.random.nextInt();
        tLRPC$TL_phone_createGroupCall.schedule_date = this.scheduleStartAt;
        tLRPC$TL_phone_createGroupCall.flags |= 2;
        accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_createGroupCall, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$7QEwxUa6OzSE0fnbMiTM7c21Dj0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$28$GroupCallActivity(tLRPC$Chat, tLRPC$InputPeer, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$25$GroupCallActivity(ValueAnimator valueAnimator) {
        this.switchToButtonProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateScheduleUI(true);
        this.buttonsContainer.invalidate();
        this.listView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$28$GroupCallActivity(final TLRPC$Chat tLRPC$Chat, final TLRPC$InputPeer tLRPC$InputPeer, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            int i = 0;
            while (true) {
                if (i >= tLRPC$Updates.updates.size()) {
                    break;
                }
                TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                if (tLRPC$Update instanceof TLRPC$TL_updateGroupCall) {
                    final TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = (TLRPC$TL_updateGroupCall) tLRPC$Update;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$-um2sE42te-eCtgA6TiYmS6p9WE
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$26$GroupCallActivity(tLRPC$Chat, tLRPC$InputPeer, tLRPC$TL_updateGroupCall);
                        }
                    });
                    break;
                }
                i++;
            }
            this.accountInstance.getMessagesController().processUpdates(tLRPC$Updates, false);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$Bdvbf8tHiBjURhufQuUzjTGVXtI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$27$GroupCallActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$26$GroupCallActivity(TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall) {
        ChatObject.Call call = new ChatObject.Call();
        this.call = call;
        call.call = new TLRPC$TL_groupCall();
        ChatObject.Call call2 = this.call;
        TLRPC$GroupCall tLRPC$GroupCall = call2.call;
        tLRPC$GroupCall.participants_count = 0;
        tLRPC$GroupCall.version = 1;
        tLRPC$GroupCall.can_start_video = true;
        tLRPC$GroupCall.can_change_join_muted = true;
        call2.chatId = tLRPC$Chat.id;
        tLRPC$GroupCall.schedule_date = this.scheduleStartAt;
        tLRPC$GroupCall.flags |= 128;
        call2.currentAccount = this.accountInstance;
        call2.setSelfPeer(tLRPC$InputPeer);
        ChatObject.Call call3 = this.call;
        TLRPC$GroupCall tLRPC$GroupCall2 = call3.call;
        TLRPC$GroupCall tLRPC$GroupCall3 = tLRPC$TL_updateGroupCall.call;
        tLRPC$GroupCall2.access_hash = tLRPC$GroupCall3.access_hash;
        tLRPC$GroupCall2.id = tLRPC$GroupCall3.id;
        call3.createNoVideoParticipant();
        this.fullscreenAdapter.setGroupCall(this.call);
        this.renderersContainer.setGroupCall(this.call);
        this.tabletGridAdapter.setGroupCall(this.call);
        MessagesController messagesController = this.accountInstance.getMessagesController();
        ChatObject.Call call4 = this.call;
        messagesController.putGroupCall(call4.chatId, call4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$27$GroupCallActivity(TLRPC$TL_error tLRPC$TL_error) {
        this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.needShowAlert, 6, tLRPC$TL_error.text);
        dismiss();
    }

    static /* synthetic */ String lambda$new$30(long j, Calendar calendar, int i, int i2) {
        if (i2 == 0) {
            return LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
        }
        long j2 = j + (i2 * 86400000);
        calendar.setTimeInMillis(j2);
        if (calendar.get(1) == i) {
            return LocaleController.getInstance().formatterScheduleDay.format(j2);
        }
        return LocaleController.getInstance().formatterScheduleYear.format(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$31$GroupCallActivity(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            this.container.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        AlertsCreator.checkScheduleDate(this.scheduleButtonTextView, this.scheduleInfoTextView, 604800L, 2, numberPicker, numberPicker2, numberPicker3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$34$GroupCallActivity(Context context, View view) throws InterruptedException {
        LaunchActivity launchActivity;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23 && (launchActivity = this.parentActivity) != null && launchActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            this.parentActivity.requestPermissions(new String[]{"android.permission.CAMERA"}, R.styleable.AppCompatTheme_textColorAlertDialogListItem);
            return;
        }
        if (VoIPService.getSharedInstance() == null) {
            return;
        }
        if (VoIPService.getSharedInstance().getVideoState(false) != 2) {
            this.undoView[0].hide(false, 1);
            if (this.previewDialog == null) {
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance != null) {
                    sharedInstance.createCaptureDevice(false);
                }
                PrivateVideoPreviewDialog privateVideoPreviewDialog = new PrivateVideoPreviewDialog(context, z, VoIPService.getSharedInstance().getVideoState(true) != 2) { // from class: ir.eitaa.ui.GroupCallActivity.38
                    @Override // ir.eitaa.ui.Components.voip.PrivateVideoPreviewDialog
                    public void onDismiss(boolean screencast, boolean apply) throws InterruptedException {
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        boolean z2 = groupCallActivity.previewDialog.micEnabled;
                        groupCallActivity.previewDialog = null;
                        VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                        if (!apply) {
                            if (sharedInstance2 != null) {
                                sharedInstance2.setVideoState(false, 0);
                                return;
                            }
                            return;
                        }
                        if (sharedInstance2 != null) {
                            sharedInstance2.setupCaptureDevice(screencast, z2);
                        }
                        if (screencast && sharedInstance2 != null) {
                            sharedInstance2.setVideoState(false, 0);
                        }
                        GroupCallActivity.this.updateState(true, false);
                        GroupCallActivity.this.call.sortParticipants();
                        GroupCallActivity.this.applyCallParticipantUpdates(true);
                        GroupCallActivity.this.buttonsContainer.requestLayout();
                    }
                };
                this.previewDialog = privateVideoPreviewDialog;
                this.container.addView(privateVideoPreviewDialog);
                if (sharedInstance == null || sharedInstance.isFrontFaceCamera()) {
                    return;
                }
                sharedInstance.switchCamera();
                return;
            }
            return;
        }
        VoIPService.getSharedInstance().setVideoState(false, 0);
        updateState(true, false);
        updateSpeakerPhoneIcon(false);
        this.call.sortParticipants();
        applyCallParticipantUpdates(true);
        this.buttonsContainer.requestLayout();
    }

    public void fullscreenFor(final ChatObject.VideoParticipant videoParticipant) {
        ChatObject.VideoParticipant videoParticipant2;
        if (VoIPService.getSharedInstance() == null || this.renderersContainer.isAnimating()) {
            return;
        }
        if (isTabletMode) {
            if (this.requestFullscreenListener != null) {
                this.listView.getViewTreeObserver().removeOnPreDrawListener(this.requestFullscreenListener);
                this.requestFullscreenListener = null;
            }
            final ArrayList arrayList = new ArrayList();
            if (videoParticipant == null) {
                this.attachedRenderersTmp.clear();
                this.attachedRenderersTmp.addAll(this.attachedRenderers);
                for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
                    final GroupCallMiniTextureView groupCallMiniTextureView = this.attachedRenderersTmp.get(i);
                    GroupCallGridCell groupCallGridCell = groupCallMiniTextureView.primaryView;
                    if (groupCallGridCell != null) {
                        groupCallGridCell.setRenderer(null);
                        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = groupCallMiniTextureView.secondaryView;
                        if (groupCallUserCell != null) {
                            groupCallUserCell.setRenderer(null);
                        }
                        GroupCallGridCell groupCallGridCell2 = groupCallMiniTextureView.tabletGridView;
                        if (groupCallGridCell2 != null) {
                            groupCallGridCell2.setRenderer(null);
                        }
                        arrayList.add(groupCallMiniTextureView.participant);
                        groupCallMiniTextureView.forceDetach(false);
                        groupCallMiniTextureView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.39
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (groupCallMiniTextureView.getParent() != null) {
                                    ((BottomSheet) GroupCallActivity.this).containerView.removeView(groupCallMiniTextureView);
                                }
                            }
                        });
                    }
                }
                this.listViewVideoVisibility = false;
                this.tabletGridAdapter.setVisibility(this.tabletVideoGridView, true, true);
            } else {
                this.attachedRenderersTmp.clear();
                this.attachedRenderersTmp.addAll(this.attachedRenderers);
                for (int i2 = 0; i2 < this.attachedRenderersTmp.size(); i2++) {
                    final GroupCallMiniTextureView groupCallMiniTextureView2 = this.attachedRenderersTmp.get(i2);
                    if (groupCallMiniTextureView2.tabletGridView != null && ((videoParticipant2 = groupCallMiniTextureView2.participant) == null || !videoParticipant2.equals(videoParticipant))) {
                        arrayList.add(groupCallMiniTextureView2.participant);
                        groupCallMiniTextureView2.forceDetach(false);
                        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell2 = groupCallMiniTextureView2.secondaryView;
                        if (groupCallUserCell2 != null) {
                            groupCallUserCell2.setRenderer(null);
                        }
                        GroupCallGridCell groupCallGridCell3 = groupCallMiniTextureView2.primaryView;
                        if (groupCallGridCell3 != null) {
                            groupCallGridCell3.setRenderer(null);
                        }
                        groupCallMiniTextureView2.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.40
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                if (groupCallMiniTextureView2.getParent() != null) {
                                    ((BottomSheet) GroupCallActivity.this).containerView.removeView(groupCallMiniTextureView2);
                                }
                            }
                        });
                    }
                }
                this.listViewVideoVisibility = true;
                this.tabletGridAdapter.setVisibility(this.tabletVideoGridView, false, false);
                if (!arrayList.isEmpty()) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$P9P9A15CXavOOhXjKpKz1kTvAYg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$fullscreenFor$35$GroupCallActivity(arrayList);
                        }
                    });
                }
            }
            final boolean z = !this.renderersContainer.inFullscreenMode;
            ViewTreeObserver viewTreeObserver = this.listView.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.GroupCallActivity.41
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    GroupCallActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.requestFullscreenListener = null;
                    groupCallActivity.renderersContainer.requestFullscreen(videoParticipant);
                    if (GroupCallActivity.this.delayedGroupCallUpdated) {
                        GroupCallActivity.this.delayedGroupCallUpdated = false;
                        GroupCallActivity.this.applyCallParticipantUpdates(true);
                        if (z && videoParticipant != null) {
                            GroupCallActivity.this.listView.scrollToPosition(0);
                        }
                        GroupCallActivity.this.delayedGroupCallUpdated = true;
                    } else {
                        GroupCallActivity.this.applyCallParticipantUpdates(true);
                    }
                    return false;
                }
            };
            this.requestFullscreenListener = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
            return;
        }
        if (this.requestFullscreenListener != null) {
            this.listView.getViewTreeObserver().removeOnPreDrawListener(this.requestFullscreenListener);
            this.requestFullscreenListener = null;
        }
        if (videoParticipant != null) {
            if (this.fullscreenUsersListView.getVisibility() != 0) {
                this.fullscreenUsersListView.setVisibility(0);
                this.fullscreenAdapter.update(false, this.fullscreenUsersListView);
                this.delayedGroupCallUpdated = true;
                if (!this.renderersContainer.inFullscreenMode) {
                    this.fullscreenAdapter.scrollTo(videoParticipant, this.fullscreenUsersListView);
                }
                ViewTreeObserver viewTreeObserver2 = this.listView.getViewTreeObserver();
                ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.GroupCallActivity.42
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        GroupCallActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        groupCallActivity.requestFullscreenListener = null;
                        groupCallActivity.renderersContainer.requestFullscreen(videoParticipant);
                        AndroidUtilities.updateVisibleRows(GroupCallActivity.this.fullscreenUsersListView);
                        return false;
                    }
                };
                this.requestFullscreenListener = onPreDrawListener2;
                viewTreeObserver2.addOnPreDrawListener(onPreDrawListener2);
                return;
            }
            this.renderersContainer.requestFullscreen(videoParticipant);
            AndroidUtilities.updateVisibleRows(this.fullscreenUsersListView);
            return;
        }
        if (this.listView.getVisibility() != 0) {
            this.listView.setVisibility(0);
            applyCallParticipantUpdates(false);
            this.delayedGroupCallUpdated = true;
            ViewTreeObserver viewTreeObserver3 = this.listView.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener3 = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.GroupCallActivity.43
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    GroupCallActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    GroupCallActivity.this.renderersContainer.requestFullscreen(null);
                    AndroidUtilities.updateVisibleRows(GroupCallActivity.this.fullscreenUsersListView);
                    return false;
                }
            };
            this.requestFullscreenListener = onPreDrawListener3;
            viewTreeObserver3.addOnPreDrawListener(onPreDrawListener3);
            return;
        }
        ViewTreeObserver viewTreeObserver4 = this.listView.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener4 = new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.GroupCallActivity.44
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                GroupCallActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                GroupCallActivity.this.renderersContainer.requestFullscreen(null);
                AndroidUtilities.updateVisibleRows(GroupCallActivity.this.fullscreenUsersListView);
                return false;
            }
        };
        this.requestFullscreenListener = onPreDrawListener4;
        viewTreeObserver4.addOnPreDrawListener(onPreDrawListener4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$fullscreenFor$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$fullscreenFor$35$GroupCallActivity(ArrayList arrayList) {
        for (int i = 0; i < this.attachedRenderers.size(); i++) {
            if (this.attachedRenderers.get(i).participant != null) {
                arrayList.remove(this.attachedRenderers.get(i).participant);
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ChatObject.VideoParticipant videoParticipant = (ChatObject.VideoParticipant) arrayList.get(i2);
            if (videoParticipant.participant.self) {
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().setLocalSink(null, videoParticipant.presentation);
                }
            } else if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().removeRemoteSink(videoParticipant.participant, videoParticipant.presentation);
            }
        }
    }

    public void enableCamera() {
        this.cameraButton.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkContentOverlayed() {
        boolean z = !this.avatarPriviewTransitionInProgress && this.blurredView.getVisibility() == 0 && this.blurredView.getAlpha() == 1.0f;
        if (this.contentFullyOverlayed != z) {
            this.contentFullyOverlayed = z;
            this.buttonsContainer.invalidate();
            this.containerView.invalidate();
            this.listView.invalidate();
        }
    }

    private void updateScheduleUI(boolean animation) {
        float interpolation;
        float f;
        LinearLayout linearLayout = this.scheduleTimerContainer;
        if ((linearLayout == null || this.call != null) && this.scheduleAnimator == null) {
            this.scheduleButtonsScale = 1.0f;
            this.switchToButtonInt2 = 1.0f;
            this.switchToButtonProgress = 1.0f;
            if (linearLayout == null) {
                return;
            }
        }
        if (!animation) {
            AndroidUtilities.cancelRunOnUIThread(this.updateSchedeulRunnable);
            this.updateSchedeulRunnable.run();
            ChatObject.Call call = this.call;
            if (call == null || call.isScheduled()) {
                this.listView.setVisibility(4);
            } else {
                this.listView.setVisibility(0);
            }
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.leaveItem.setText(LocaleController.getString("VoipChannelCancelChat", R.string.VoipChannelCancelChat));
            } else {
                this.leaveItem.setText(LocaleController.getString("VoipGroupCancelChat", R.string.VoipGroupCancelChat));
            }
        }
        float f2 = this.switchToButtonProgress;
        if (f2 > 0.6f) {
            interpolation = 1.05f - (CubicBezierInterpolator.DEFAULT.getInterpolation((f2 - 0.6f) / 0.4f) * 0.05f);
            this.scheduleButtonsScale = interpolation;
            this.switchToButtonInt2 = 1.0f;
            f = 1.0f;
        } else {
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            this.scheduleButtonsScale = (cubicBezierInterpolator.getInterpolation(f2 / 0.6f) * 0.05f) + 1.0f;
            this.switchToButtonInt2 = cubicBezierInterpolator.getInterpolation(this.switchToButtonProgress / 0.6f);
            interpolation = 1.05f * cubicBezierInterpolator.getInterpolation(this.switchToButtonProgress / 0.6f);
            f = this.switchToButtonProgress / 0.6f;
        }
        float fDp = isLandscapeMode ? (AndroidUtilities.dp(52.0f) * interpolation) / (this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(8.0f)) : interpolation;
        float f3 = 1.0f - f;
        this.leaveButton.setAlpha(f);
        VoIPToggleButton voIPToggleButton = this.soundButton;
        voIPToggleButton.setAlpha((voIPToggleButton.isEnabled() ? 1.0f : 0.5f) * f);
        this.muteButton.setAlpha(f);
        this.scheduleTimerContainer.setAlpha(f3);
        this.scheduleStartInTextView.setAlpha(f);
        this.scheduleStartAtTextView.setAlpha(f);
        this.scheduleTimeTextView.setAlpha(f);
        this.muteLabel[0].setAlpha(f);
        this.scheduleTimeTextView.setScaleX(interpolation);
        this.scheduleTimeTextView.setScaleY(interpolation);
        this.leaveButton.setScaleX(interpolation);
        this.leaveButton.setScaleY(interpolation);
        this.soundButton.setScaleX(interpolation);
        this.soundButton.setScaleY(interpolation);
        this.muteButton.setScaleX(fDp);
        this.muteButton.setScaleY(fDp);
        this.scheduleButtonTextView.setScaleX(f3);
        this.scheduleButtonTextView.setScaleY(f3);
        this.scheduleButtonTextView.setAlpha(f3);
        this.scheduleInfoTextView.setAlpha(f3);
        this.cameraButton.setAlpha(f);
        this.cameraButton.setScaleY(interpolation);
        this.cameraButton.setScaleX(interpolation);
        this.flipButton.setAlpha(f);
        this.flipButton.setScaleY(interpolation);
        this.flipButton.setScaleX(interpolation);
        this.otherItem.setAlpha(f);
        int i = f3 != 0.0f ? 0 : 4;
        if (i != this.scheduleTimerContainer.getVisibility()) {
            this.scheduleTimerContainer.setVisibility(i);
            this.scheduleButtonTextView.setVisibility(i);
        }
    }

    private void initCreatedGroupCall() {
        VoIPService sharedInstance;
        int i;
        String str;
        if (this.callInitied || (sharedInstance = VoIPService.getSharedInstance()) == null) {
            return;
        }
        this.callInitied = true;
        this.oldParticipants.addAll(this.call.visibleParticipants);
        this.oldVideoParticipants.addAll(this.visibleVideoParticipants);
        this.oldInvited.addAll(this.call.invitedUsers);
        this.currentCallState = sharedInstance.getCallState();
        if (this.call == null) {
            ChatObject.Call call = sharedInstance.groupCall;
            this.call = call;
            this.fullscreenAdapter.setGroupCall(call);
            this.renderersContainer.setGroupCall(this.call);
            this.tabletGridAdapter.setGroupCall(this.call);
        }
        this.actionBar.setTitleRightMargin(AndroidUtilities.dp(48.0f) * 2);
        this.call.saveActiveDates();
        VoIPService.getSharedInstance().registerStateListener(this);
        SimpleTextView simpleTextView = this.scheduleTimeTextView;
        if (simpleTextView == null || simpleTextView.getVisibility() != 0) {
            return;
        }
        this.leaveButton.setData(R.drawable.calls_decline, -1, Theme.getColor("voipgroup_leaveButton"), 0.3f, false, LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), false, true);
        updateSpeakerPhoneIcon(true);
        ActionBarMenuSubItem actionBarMenuSubItem = this.leaveItem;
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            i = R.string.VoipChannelEndChat;
            str = "VoipChannelEndChat";
        } else {
            i = R.string.VoipGroupEndChat;
            str = "VoipGroupEndChat";
        }
        actionBarMenuSubItem.setText(LocaleController.getString(str, i));
        this.listView.setVisibility(0);
        this.pipItem.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.listView, (Property<RecyclerListView, Float>) View.ALPHA, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.listView, (Property<RecyclerListView, Float>) View.TRANSLATION_Y, AndroidUtilities.dp(200.0f), 0.0f), ObjectAnimator.ofFloat(this.scheduleTimeTextView, (Property<SimpleTextView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.scheduleTimeTextView, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.scheduleTimeTextView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartInTextView, (Property<SimpleTextView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartInTextView, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartInTextView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartAtTextView, (Property<SimpleTextView, Float>) View.SCALE_X, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartAtTextView, (Property<SimpleTextView, Float>) View.SCALE_Y, 0.0f), ObjectAnimator.ofFloat(this.scheduleStartAtTextView, (Property<SimpleTextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.pipItem, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.pipItem, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.pipItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f, 1.0f));
        animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.45
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                GroupCallActivity.this.scheduleTimeTextView.setVisibility(4);
                GroupCallActivity.this.scheduleStartAtTextView.setVisibility(4);
                GroupCallActivity.this.scheduleStartInTextView.setVisibility(4);
            }
        });
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubtitle() {
        if (this.actionBar == null || this.call == null) {
            return;
        }
        boolean z = false;
        SpannableStringBuilder spannableStringBuilder = null;
        int i = 0;
        for (int i2 = 0; i2 < this.call.currentSpeakingPeers.size(); i2++) {
            long jKeyAt = this.call.currentSpeakingPeers.keyAt(i2);
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.currentSpeakingPeers.get(jKeyAt);
            if (!tLRPC$TL_groupCallParticipant.self && !this.renderersContainer.isVisible(tLRPC$TL_groupCallParticipant) && this.visiblePeerIds.get(jKeyAt, 0) != 1) {
                long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                }
                if (i < 2) {
                    TLRPC$User user = peerId > 0 ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(peerId)) : null;
                    TLRPC$Chat chat = peerId <= 0 ? MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(peerId)) : null;
                    if (user != null || chat != null) {
                        if (i != 0) {
                            spannableStringBuilder.append((CharSequence) ", ");
                        }
                        if (user != null) {
                            if (Build.VERSION.SDK_INT >= 21) {
                                spannableStringBuilder.append(UserObject.getFirstName(user), new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0);
                            } else {
                                spannableStringBuilder.append((CharSequence) UserObject.getFirstName(user));
                            }
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            spannableStringBuilder.append(chat.title, new TypefaceSpan(AndroidUtilities.getFontFamily(true)), 0);
                        } else {
                            spannableStringBuilder.append((CharSequence) chat.title);
                        }
                    }
                }
                i++;
                if (i == 2) {
                    break;
                }
            }
        }
        if (i > 0) {
            String pluralString = LocaleController.getPluralString("MembersAreSpeakingToast", i);
            int iIndexOf = pluralString.indexOf("un1");
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(pluralString);
            spannableStringBuilder2.replace(iIndexOf, iIndexOf + 3, (CharSequence) spannableStringBuilder);
            this.actionBar.getAdditionalSubtitleTextView().setText(spannableStringBuilder2);
            z = true;
        }
        this.actionBar.getSubtitleTextView().setText(LocaleController.formatPluralString("Participants", this.call.call.participants_count + (this.listAdapter.addSelfToCounter() ? 1 : 0)));
        if (z != this.drawSpeakingSubtitle) {
            this.drawSpeakingSubtitle = z;
            this.actionBar.invalidate();
            this.actionBar.getSubtitleTextView().setPivotX(0.0f);
            this.actionBar.getSubtitleTextView().setPivotY(this.actionBar.getMeasuredHeight() >> 1);
            this.actionBar.getSubtitleTextView().animate().scaleX(this.drawSpeakingSubtitle ? 0.98f : 1.0f).scaleY(this.drawSpeakingSubtitle ? 0.9f : 1.0f).alpha(this.drawSpeakingSubtitle ? 0.0f : 1.0f).setDuration(150L);
            AndroidUtilities.updateViewVisibilityAnimated(this.actionBar.getAdditionalSubtitleTextView(), this.drawSpeakingSubtitle);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, Integer.valueOf(Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS));
        super.show();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        if (this.renderersContainer != null) {
            if (this.requestFullscreenListener != null) {
                this.listView.getViewTreeObserver().removeOnPreDrawListener(this.requestFullscreenListener);
                this.requestFullscreenListener = null;
            }
            this.attachedRenderersTmp.clear();
            this.attachedRenderersTmp.addAll(this.attachedRenderers);
            for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
                this.attachedRenderersTmp.get(i).saveThumb();
                this.renderersContainer.removeView(this.attachedRenderersTmp.get(i));
                this.attachedRenderersTmp.get(i).release();
                this.attachedRenderersTmp.get(i).forceDetach(true);
            }
            this.attachedRenderers.clear();
            if (this.renderersContainer.getParent() != null) {
                this.attachedRenderers.clear();
                this.containerView.removeView(this.renderersContainer);
            }
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, Integer.valueOf(Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS));
        super.dismissInternal();
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().unregisterStateListener(this);
            VoIPService.getSharedInstance().setSinks(null, null);
        }
        if (groupCallInstance == this) {
            groupCallInstance = null;
        }
        groupCallUiVisible = false;
        VoIPService.audioLevelsCallback = null;
        GroupCallPip.updateVisibility(getContext());
        this.call.clearVideFramesInfo();
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().clearRemoteSinks();
        }
    }

    private void setAmplitude(double value) {
        float fMin = (float) (Math.min(8500.0d, value) / 8500.0d);
        this.animateToAmplitude = fMin;
        this.animateAmplitudeDiff = (fMin - this.amplitude) / ((BlobDrawable.AMPLITUDE_SPEED * 500.0f) + 100.0f);
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int state) throws InterruptedException {
        this.currentCallState = state;
        updateState(isShowing(), false);
    }

    public UndoView getUndoView() {
        if (!isTabletMode) {
            GroupCallRenderersContainer groupCallRenderersContainer = this.renderersContainer;
            if (groupCallRenderersContainer.inFullscreenMode) {
                return groupCallRenderersContainer.getUndoView();
            }
        }
        if (this.undoView[0].getVisibility() == 0) {
            UndoView[] undoViewArr = this.undoView;
            UndoView undoView = undoViewArr[0];
            undoViewArr[0] = undoViewArr[1];
            undoViewArr[1] = undoView;
            undoView.hide(true, 2);
            this.containerView.removeView(this.undoView[0]);
            this.containerView.addView(this.undoView[0]);
        }
        return this.undoView[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getColorProgress() {
        return this.colorProgress;
    }

    private void updateTitle(boolean animated) {
        ChatObject.Call call = this.call;
        if (call == null) {
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.titleTextView.setText(LocaleController.getString("VoipChannelScheduleVoiceChat", R.string.VoipChannelScheduleVoiceChat), animated);
                return;
            } else {
                this.titleTextView.setText(LocaleController.getString("VoipGroupScheduleVoiceChat", R.string.VoipGroupScheduleVoiceChat), animated);
                return;
            }
        }
        if (!TextUtils.isEmpty(call.call.title)) {
            if (!this.call.call.title.equals(this.actionBar.getTitle())) {
                if (animated) {
                    this.actionBar.setTitleAnimated(this.call.call.title, true, 180L);
                    this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$j3KDLc3bISfDRNjZoUTZRMffPRA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$updateTitle$36$GroupCallActivity(view);
                        }
                    });
                } else {
                    this.actionBar.setTitle(this.call.call.title);
                }
                this.titleTextView.setText(this.call.call.title, animated);
            }
        } else if (!this.currentChat.title.equals(this.actionBar.getTitle())) {
            if (animated) {
                this.actionBar.setTitleAnimated(this.currentChat.title, true, 180L);
                this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$3ZIlxOext0wPmVDHAhwUEM58iVg
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$updateTitle$37$GroupCallActivity(view);
                    }
                });
            } else {
                this.actionBar.setTitle(this.currentChat.title);
            }
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.titleTextView.setText(LocaleController.getString("VoipChannelVoiceChat", R.string.VoipChannelVoiceChat), animated);
            } else {
                this.titleTextView.setText(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat), animated);
            }
        }
        SimpleTextView titleTextView = this.actionBar.getTitleTextView();
        if (this.call.recording) {
            if (titleTextView.getRightDrawable() == null) {
                titleTextView.setRightDrawable(new SmallRecordCallDrawable(titleTextView));
                TextView textView = this.titleTextView.getTextView();
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, new SmallRecordCallDrawable(textView), (Drawable) null);
                TextView nextTextView = this.titleTextView.getNextTextView();
                nextTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, new SmallRecordCallDrawable(nextTextView), (Drawable) null);
                return;
            }
            return;
        }
        if (titleTextView.getRightDrawable() != null) {
            titleTextView.setRightDrawable((Drawable) null);
            this.titleTextView.getTextView().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.titleTextView.getNextTextView().setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTitle$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTitle$36$GroupCallActivity(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateTitle$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateTitle$37$GroupCallActivity(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorProgress(float progress) {
        this.colorProgress = progress;
        GroupCallRenderersContainer groupCallRenderersContainer = this.renderersContainer;
        float fMax = Math.max(progress, groupCallRenderersContainer == null ? 0.0f : groupCallRenderersContainer.progressToFullscreenMode);
        int offsetColor = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_actionBarUnscrolled"), Theme.getColor("voipgroup_actionBar"), progress, 1.0f);
        this.backgroundColor = offsetColor;
        this.actionBarBackground.setBackgroundColor(offsetColor);
        this.otherItem.redrawPopup(-14472653);
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(this.backgroundColor, PorterDuff.Mode.MULTIPLY));
        this.navBarColor = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_actionBarUnscrolled"), Theme.getColor("voipgroup_actionBar"), fMax, 1.0f);
        int offsetColor2 = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_listViewBackgroundUnscrolled"), Theme.getColor("voipgroup_listViewBackground"), progress, 1.0f);
        this.listViewBackgroundPaint.setColor(offsetColor2);
        this.listView.setGlowColor(offsetColor2);
        int i = this.muteButtonState;
        if (i == 3 || isGradientState(i)) {
            this.muteButton.invalidate();
        }
        View view = this.buttonsBackgroundGradientView;
        if (view != null) {
            int[] iArr = this.gradientColors;
            iArr[0] = this.backgroundColor;
            iArr[1] = 0;
            if (Build.VERSION.SDK_INT > 29) {
                this.buttonsBackgroundGradient.setColors(iArr);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.gradientColors);
                this.buttonsBackgroundGradient = gradientDrawable;
                view.setBackground(gradientDrawable);
            }
            this.buttonsBackgroundGradientView2.setBackgroundColor(this.gradientColors[0]);
        }
        int offsetColor3 = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_leaveButton"), Theme.getColor("voipgroup_leaveButtonScrolled"), progress, 1.0f);
        this.leaveButton.setBackgroundColor(offsetColor3, offsetColor3);
        int offsetColor4 = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_lastSeenTextUnscrolled"), Theme.getColor("voipgroup_lastSeenText"), progress, 1.0f);
        int offsetColor5 = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_mutedIconUnscrolled"), Theme.getColor("voipgroup_mutedIcon"), progress, 1.0f);
        int childCount = this.listView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.listView.getChildAt(i2);
            if (childAt instanceof GroupCallTextCell) {
                ((GroupCallTextCell) childAt).setColors(offsetColor5, offsetColor4);
            } else if (childAt instanceof GroupCallUserCell) {
                ((GroupCallUserCell) childAt).setGrayIconColor(this.actionBar.getTag() != null ? "voipgroup_mutedIcon" : "voipgroup_mutedIconUnscrolled", offsetColor5);
            } else if (childAt instanceof GroupCallInvitedCell) {
                ((GroupCallInvitedCell) childAt).setGrayIconColor(this.actionBar.getTag() != null ? "voipgroup_mutedIcon" : "voipgroup_mutedIconUnscrolled", offsetColor5);
            }
        }
        this.containerView.invalidate();
        this.listView.invalidate();
        this.container.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLink(final boolean copy) {
        String str;
        TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite;
        TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(this.currentChat.id));
        if (chat != null && TextUtils.isEmpty(chat.username)) {
            final TLRPC$ChatFull chatFull = this.accountInstance.getMessagesController().getChatFull(this.currentChat.id);
            if (TextUtils.isEmpty(this.currentChat.username)) {
                str = (chatFull == null || (tLRPC$ExportedChatInvite = chatFull.exported_invite) == null) ? null : tLRPC$ExportedChatInvite.link;
            } else {
                str = this.accountInstance.getMessagesController().linkPrefix + "/" + this.currentChat.username;
            }
            if (TextUtils.isEmpty(str)) {
                TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
                tLRPC$TL_messages_exportChatInvite.peer = MessagesController.getInputPeer(this.currentChat);
                this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$VUhNd2Z-QcINyIHKUIK-gkDseNk
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$getLink$39$GroupCallActivity(chatFull, copy, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            openShareAlert(true, null, str, copy);
            return;
        }
        if (this.call == null) {
            return;
        }
        final int i = 0;
        while (i < 2) {
            TLRPC$TL_phone_exportGroupCallInvite tLRPC$TL_phone_exportGroupCallInvite = new TLRPC$TL_phone_exportGroupCallInvite();
            tLRPC$TL_phone_exportGroupCallInvite.call = this.call.getInputGroupCall();
            tLRPC$TL_phone_exportGroupCallInvite.can_self_unmute = i == 1;
            this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_exportGroupCallInvite, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$mZQbqH_XE2L_l_dxJ73MPqPYRpY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$getLink$41$GroupCallActivity(i, copy, tLObject, tLRPC$TL_error);
                }
            });
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getLink$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getLink$39$GroupCallActivity(final TLRPC$ChatFull tLRPC$ChatFull, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$x9Hf3WFIDExaJUDnQapOa3tcF1c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLink$38$GroupCallActivity(tLObject, tLRPC$ChatFull, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getLink$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getLink$38$GroupCallActivity(TLObject tLObject, TLRPC$ChatFull tLRPC$ChatFull, boolean z) {
        if (tLObject instanceof TLRPC$TL_chatInviteExported) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = (TLRPC$TL_chatInviteExported) tLObject;
            if (tLRPC$ChatFull != null) {
                tLRPC$ChatFull.exported_invite = tLRPC$TL_chatInviteExported;
            } else {
                openShareAlert(true, null, tLRPC$TL_chatInviteExported.link, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getLink$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getLink$41$GroupCallActivity(final int i, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$9yPw6Pg8SLFR4yRaaDnyYzOlIOY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLink$40$GroupCallActivity(tLObject, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getLink$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getLink$40$GroupCallActivity(TLObject tLObject, int i, boolean z) {
        if (tLObject instanceof TLRPC$TL_phone_exportedGroupCallInvite) {
            this.invites[i] = ((TLRPC$TL_phone_exportedGroupCallInvite) tLObject).link;
        } else {
            this.invites[i] = "";
        }
        for (int i2 = 0; i2 < 2; i2++) {
            String[] strArr = this.invites;
            if (strArr[i2] == null) {
                return;
            }
            if (strArr[i2].length() == 0) {
                this.invites[i2] = null;
            }
        }
        if (!z && ChatObject.canManageCalls(this.currentChat) && !this.call.call.join_muted) {
            this.invites[0] = null;
        }
        String[] strArr2 = this.invites;
        if (strArr2[0] == null && strArr2[1] == null && !TextUtils.isEmpty(this.currentChat.username)) {
            openShareAlert(true, null, this.accountInstance.getMessagesController().linkPrefix + "/" + this.currentChat.username, z);
            return;
        }
        String[] strArr3 = this.invites;
        openShareAlert(false, strArr3[0], strArr3[1], z);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openShareAlert(boolean r16, java.lang.String r17, java.lang.String r18, boolean r19) {
        /*
            r15 = this;
            r12 = r15
            if (r19 == 0) goto L1e
            if (r17 == 0) goto L8
            r0 = r17
            goto La
        L8:
            r0 = r18
        La:
            ir.eitaa.messenger.AndroidUtilities.addToClipboard(r0)
            ir.eitaa.ui.Components.UndoView r1 = r15.getUndoView()
            r2 = 0
            r4 = 33
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1.showWithAction(r2, r4, r5, r6, r7, r8)
            goto Lb9
        L1e:
            ir.eitaa.ui.LaunchActivity r0 = r12.parentActivity
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L4d
            ir.eitaa.ui.ActionBar.ActionBarLayout r0 = r0.getActionBarLayout()
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r0 = r0.fragmentsStack
            ir.eitaa.ui.LaunchActivity r3 = r12.parentActivity
            ir.eitaa.ui.ActionBar.ActionBarLayout r3 = r3.getActionBarLayout()
            java.util.ArrayList<ir.eitaa.ui.ActionBar.BaseFragment> r3 = r3.fragmentsStack
            int r3 = r3.size()
            int r3 = r3 - r2
            java.lang.Object r0 = r0.get(r3)
            ir.eitaa.ui.ActionBar.BaseFragment r0 = (ir.eitaa.ui.ActionBar.BaseFragment) r0
            boolean r3 = r0 instanceof ir.eitaa.ui.ChatActivity
            if (r3 == 0) goto L4d
            ir.eitaa.ui.ChatActivity r0 = (ir.eitaa.ui.ChatActivity) r0
            boolean r0 = r0.needEnterText()
            r12.anyEnterEventSent = r2
            r12.enterEventSent = r2
            r13 = r0
            goto L4e
        L4d:
            r13 = 0
        L4e:
            if (r17 == 0) goto L57
            if (r18 != 0) goto L57
            r0 = 0
            r8 = r17
            r9 = r0
            goto L5b
        L57:
            r9 = r17
            r8 = r18
        L5b:
            if (r9 != 0) goto L84
            if (r16 == 0) goto L84
            ir.eitaa.tgnet.TLRPC$Chat r0 = r12.currentChat
            boolean r0 = ir.eitaa.messenger.ChatObject.isChannelOrGiga(r0)
            if (r0 == 0) goto L75
            r0 = 2131694859(0x7f0f150b, float:1.9018886E38)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            java.lang.String r1 = "VoipChannelInviteText"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatString(r1, r0, r2)
            goto L82
        L75:
            r0 = 2131694948(0x7f0f1564, float:1.9019067E38)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r8
            java.lang.String r1 = "VoipGroupInviteText"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatString(r1, r0, r2)
        L82:
            r5 = r0
            goto L85
        L84:
            r5 = r8
        L85:
            ir.eitaa.ui.GroupCallActivity$46 r14 = new ir.eitaa.ui.GroupCallActivity$46
            android.content.Context r2 = r15.getContext()
            r3 = 0
            r4 = 0
            r7 = 0
            r10 = 0
            r11 = 1
            r0 = r14
            r1 = r15
            r6 = r9
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.shareAlert = r14
            ir.eitaa.ui.GroupCallActivity$47 r0 = new ir.eitaa.ui.GroupCallActivity$47
            r0.<init>()
            r14.setDelegate(r0)
            ir.eitaa.ui.Components.ShareAlert r0 = r12.shareAlert
            ir.eitaa.ui.-$$Lambda$GroupCallActivity$fVRqT9oFg2Dpq9xwLs0E4IPAhXo r1 = new ir.eitaa.ui.-$$Lambda$GroupCallActivity$fVRqT9oFg2Dpq9xwLs0E4IPAhXo
            r1.<init>()
            r0.setOnDismissListener(r1)
            ir.eitaa.ui.-$$Lambda$GroupCallActivity$zJNobTIwDr0LR1Gj_sZ4Tmry94c r0 = new ir.eitaa.ui.-$$Lambda$GroupCallActivity$zJNobTIwDr0LR1Gj_sZ4Tmry94c
            r0.<init>()
            if (r13 == 0) goto Lb4
            r1 = 200(0xc8, double:9.9E-322)
            goto Lb6
        Lb4:
            r1 = 0
        Lb6:
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r0, r1)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.openShareAlert(boolean, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openShareAlert$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openShareAlert$42$GroupCallActivity(DialogInterface dialogInterface) {
        this.shareAlert = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$openShareAlert$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$openShareAlert$43$GroupCallActivity() {
        ShareAlert shareAlert = this.shareAlert;
        if (shareAlert != null) {
            shareAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inviteUserToCall(final long id, final boolean shouldAdd) {
        final TLRPC$User user;
        if (this.call == null || (user = this.accountInstance.getMessagesController().getUser(Long.valueOf(id))) == null) {
            return;
        }
        final AlertDialog[] alertDialogArr = {new AlertDialog(getContext(), 3)};
        final TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall = new TLRPC$TL_phone_inviteToGroupCall();
        tLRPC$TL_phone_inviteToGroupCall.call = this.call.getInputGroupCall();
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = user.id;
        tLRPC$TL_inputUser.access_hash = user.access_hash;
        tLRPC$TL_phone_inviteToGroupCall.users.add(tLRPC$TL_inputUser);
        final int iSendRequest = this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_inviteToGroupCall, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$YojyXwwUcrmQ9sK0YZ52fii-Dpk
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$inviteUserToCall$46$GroupCallActivity(id, alertDialogArr, user, shouldAdd, tLRPC$TL_phone_inviteToGroupCall, tLObject, tLRPC$TL_error);
            }
        });
        if (iSendRequest != 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$aFEifqu-e2JeyVVZY3ifxGqf06U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$inviteUserToCall$48$GroupCallActivity(alertDialogArr, iSendRequest);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$inviteUserToCall$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$inviteUserToCall$46$GroupCallActivity(final long j, final AlertDialog[] alertDialogArr, final TLRPC$User tLRPC$User, final boolean z, final TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$NTZcMOSed8x_xFlIJ3_zegBs6l4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$inviteUserToCall$44$GroupCallActivity(j, alertDialogArr, tLRPC$User);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$3VHG0kWhjpwaFB2-KJns-XvDZ1g
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$inviteUserToCall$45$GroupCallActivity(alertDialogArr, z, tLRPC$TL_error, j, tLRPC$TL_phone_inviteToGroupCall);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$inviteUserToCall$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$inviteUserToCall$44$GroupCallActivity(long j, AlertDialog[] alertDialogArr, TLRPC$User tLRPC$User) {
        ChatObject.Call call = this.call;
        if (call == null || this.delayedGroupCallUpdated) {
            return;
        }
        call.addInvitedUser(j);
        applyCallParticipantUpdates(true);
        GroupVoipInviteAlert groupVoipInviteAlert = this.groupVoipInviteAlert;
        if (groupVoipInviteAlert != null) {
            groupVoipInviteAlert.dismiss();
        }
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        getUndoView().showWithAction(0L, 34, tLRPC$User, this.currentChat, (Runnable) null, (Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$inviteUserToCall$45, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$inviteUserToCall$45$GroupCallActivity(AlertDialog[] alertDialogArr, boolean z, TLRPC$TL_error tLRPC$TL_error, long j, TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall) throws InterruptedException {
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        if (z && "USER_NOT_PARTICIPANT".equals(tLRPC$TL_error.text)) {
            processSelectedOption(null, j, 3);
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1), tLRPC$TL_phone_inviteToGroupCall, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$inviteUserToCall$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$inviteUserToCall$48$GroupCallActivity(AlertDialog[] alertDialogArr, final int i) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$Y0JdrayKjaeQjrc-Sp7Z4R3WWro
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$inviteUserToCall$47$GroupCallActivity(i, dialogInterface);
            }
        });
        alertDialogArr[0].show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$inviteUserToCall$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$inviteUserToCall$47$GroupCallActivity(int i, DialogInterface dialogInterface) {
        this.accountInstance.getConnectionsManager().cancelRequest(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean animated) {
        int childCount = this.listView.getChildCount();
        float paddingTop = 2.1474836E9f;
        for (int i = 0; i < childCount; i++) {
            if (this.listView.getChildAdapterPosition(this.listView.getChildAt(i)) >= 0) {
                paddingTop = Math.min(paddingTop, r4.getTop());
            }
        }
        if (paddingTop < 0.0f || paddingTop == 2.1474836E9f) {
            paddingTop = childCount != 0 ? 0.0f : this.listView.getPaddingTop();
        }
        final boolean z = paddingTop <= ((float) (ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(14.0f)));
        float currentActionBarHeight = paddingTop + ActionBar.getCurrentActionBarHeight() + AndroidUtilities.dp(14.0f);
        if ((z && this.actionBar.getTag() == null) || (!z && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            setUseLightStatusBar(this.actionBar.getTag() == null);
            ViewPropertyAnimator duration = this.actionBar.getBackButton().animate().scaleX(z ? 1.0f : 0.9f).scaleY(z ? 1.0f : 0.9f).translationX(z ? 0.0f : -AndroidUtilities.dp(14.0f)).setDuration(300L);
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            duration.setInterpolator(cubicBezierInterpolator).start();
            this.actionBar.getTitleTextView().animate().translationY(z ? 0.0f : AndroidUtilities.dp(23.0f)).setDuration(300L).setInterpolator(cubicBezierInterpolator).start();
            ObjectAnimator objectAnimator = this.subtitleYAnimator;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.subtitleYAnimator.cancel();
            }
            SimpleTextView subtitleTextView = this.actionBar.getSubtitleTextView();
            Property property = View.TRANSLATION_Y;
            float[] fArr = new float[2];
            fArr[0] = this.actionBar.getSubtitleTextView().getTranslationY();
            fArr[1] = z ? 0.0f : AndroidUtilities.dp(20.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(subtitleTextView, (Property<SimpleTextView, Float>) property, fArr);
            this.subtitleYAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.subtitleYAnimator.setInterpolator(cubicBezierInterpolator);
            this.subtitleYAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.48
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.subtitleYAnimator = null;
                    groupCallActivity.actionBar.getSubtitleTextView().setTranslationY(z ? 0.0f : AndroidUtilities.dp(20.0f));
                }
            });
            this.subtitleYAnimator.start();
            this.actionBar.getAdditionalSubtitleTextView().animate().translationY(z ? 0.0f : AndroidUtilities.dp(20.0f)).setDuration(300L).setInterpolator(cubicBezierInterpolator).start();
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(140L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[3];
            ActionBar actionBar = this.actionBar;
            Property property2 = View.ALPHA;
            float[] fArr2 = new float[1];
            fArr2[0] = z ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property2, fArr2);
            View view = this.actionBarBackground;
            Property property3 = View.ALPHA;
            float[] fArr3 = new float[1];
            fArr3[0] = z ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property3, fArr3);
            View view2 = this.actionBarShadow;
            Property property4 = View.ALPHA;
            float[] fArr4 = new float[1];
            fArr4[0] = z ? 1.0f : 0.0f;
            animatorArr[2] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property4, fArr4);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.49
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    GroupCallActivity.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
        }
        if (this.scrollOffsetY != currentActionBarHeight) {
            setScrollOffsetY(currentActionBarHeight);
        }
    }

    private void setScrollOffsetY(float scrollOffsetY) {
        int iDp;
        this.scrollOffsetY = scrollOffsetY;
        this.listView.setTopGlowOffset((int) (scrollOffsetY - ((FrameLayout.LayoutParams) this.listView.getLayoutParams()).topMargin));
        float fDp = scrollOffsetY - AndroidUtilities.dp(74.0f);
        if (this.backgroundPaddingTop + fDp < ActionBar.getCurrentActionBarHeight() * 2) {
            float fMin = Math.min(1.0f, (((ActionBar.getCurrentActionBarHeight() * 2) - fDp) - this.backgroundPaddingTop) / (((r0 - this.backgroundPaddingTop) - AndroidUtilities.dp(14.0f)) + ActionBar.getCurrentActionBarHeight()));
            iDp = (int) (AndroidUtilities.dp(AndroidUtilities.isTablet() ? 17.0f : 13.0f) * fMin);
            if (Math.abs(Math.min(1.0f, fMin) - this.colorProgress) > 1.0E-4f) {
                setColorProgress(Math.min(1.0f, fMin));
            }
            float f = 1.0f - ((0.1f * fMin) * 1.2f);
            this.titleTextView.setScaleX(Math.max(0.9f, f));
            this.titleTextView.setScaleY(Math.max(0.9f, f));
            this.titleTextView.setAlpha(Math.max(0.0f, 1.0f - (fMin * 1.2f)));
        } else {
            iDp = 0;
            this.titleTextView.setScaleX(1.0f);
            this.titleTextView.setScaleY(1.0f);
            this.titleTextView.setAlpha(1.0f);
            if (this.colorProgress > 1.0E-4f) {
                setColorProgress(0.0f);
            }
        }
        float f2 = iDp;
        this.menuItemsContainer.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (scrollOffsetY - AndroidUtilities.dp(53.0f)) - f2));
        this.titleTextView.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (scrollOffsetY - AndroidUtilities.dp(44.0f)) - f2));
        LinearLayout linearLayout = this.scheduleTimerContainer;
        if (linearLayout != null) {
            linearLayout.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (scrollOffsetY - AndroidUtilities.dp(44.0f)) - f2));
        }
        this.containerView.invalidate();
    }

    private void cancelMutePress() {
        if (this.scheduled) {
            this.scheduled = false;
            AndroidUtilities.cancelRunOnUIThread(this.pressRunnable);
        }
        if (this.pressed) {
            this.pressed = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
            this.muteButton.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateState(boolean animated, boolean selfUpdated) throws InterruptedException {
        boolean z;
        boolean z2;
        int i;
        int i2;
        float f;
        GroupCallRenderersContainer groupCallRenderersContainer;
        int i3;
        ChatObject.Call call = this.call;
        int i4 = 5;
        if (call == null || call.isScheduled()) {
            if (!ChatObject.canManageCalls(this.currentChat)) {
                i4 = this.call.call.schedule_start_subscribed ? 7 : 6;
            }
            updateMuteButton(i4, animated);
            this.leaveButton.setData(R.drawable.calls_decline, -1, Theme.getColor("voipgroup_leaveButton"), 0.3f, false, LocaleController.getString("Close", R.string.Close), false, false);
            updateScheduleUI(false);
            return;
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (!sharedInstance.isSwitchingStream() && ((this.creatingServiceTime == 0 || Math.abs(SystemClock.elapsedRealtime() - this.creatingServiceTime) > 3000) && ((i3 = this.currentCallState) == 1 || i3 == 2 || i3 == 6 || i3 == 5))) {
            cancelMutePress();
            updateMuteButton(3, animated);
        } else {
            if (this.userSwitchObject != null) {
                getUndoView().showWithAction(0L, 37, this.userSwitchObject, this.currentChat, (Runnable) null, (Runnable) null);
                this.userSwitchObject = null;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.participants.get(MessageObject.getPeerId(this.selfPeer));
            if (!sharedInstance.micSwitching && tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted && !ChatObject.canManageCalls(this.currentChat)) {
                cancelMutePress();
                if (tLRPC$TL_groupCallParticipant.raise_hand_rating != 0) {
                    updateMuteButton(4, animated);
                } else {
                    updateMuteButton(2, animated);
                }
                sharedInstance.setMicMute(true, false, false);
            } else {
                boolean zIsMicMute = sharedInstance.isMicMute();
                if (!sharedInstance.micSwitching && selfUpdated && tLRPC$TL_groupCallParticipant != null && tLRPC$TL_groupCallParticipant.muted && !zIsMicMute) {
                    cancelMutePress();
                    sharedInstance.setMicMute(true, false, false);
                    zIsMicMute = true;
                }
                if (zIsMicMute) {
                    updateMuteButton(0, animated);
                } else {
                    updateMuteButton(1, animated);
                }
            }
        }
        boolean z3 = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().getVideoState(false) == 2;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.call.participants.get(MessageObject.getPeerId(this.selfPeer));
        if ((((tLRPC$TL_groupCallParticipant2 == null || tLRPC$TL_groupCallParticipant2.can_self_unmute || !tLRPC$TL_groupCallParticipant2.muted || ChatObject.canManageCalls(this.currentChat)) ? false : true) || !this.call.canRecordVideo()) && !z3) {
            z = false;
            z2 = true;
        } else {
            z = true;
            z2 = false;
        }
        if (z3) {
            if (animated && this.flipButton.getVisibility() != 0) {
                this.flipButton.setScaleX(0.3f);
                this.flipButton.setScaleY(0.3f);
            }
            i = 1;
        } else {
            i = 0;
        }
        int i5 = i + (z2 ? 2 : 0) + (z ? 4 : 0);
        GroupCallRenderersContainer groupCallRenderersContainer2 = this.renderersContainer;
        int i6 = i5 + ((groupCallRenderersContainer2 == null || !groupCallRenderersContainer2.inFullscreenMode) ? 0 : 8);
        int i7 = this.buttonsVisibility;
        if (i7 != 0 && i7 != i6 && animated) {
            for (int i8 = 0; i8 < this.buttonsContainer.getChildCount(); i8++) {
                View childAt = this.buttonsContainer.getChildAt(i8);
                if (childAt.getVisibility() == 0) {
                    this.buttonsAnimationParamsX.put(childAt, Float.valueOf(childAt.getX()));
                    this.buttonsAnimationParamsY.put(childAt, Float.valueOf(childAt.getY()));
                }
            }
            this.animateButtonsOnNextLayout = true;
        }
        boolean z4 = (this.buttonsVisibility | 2) != (i6 | 2);
        this.buttonsVisibility = i6;
        if (z) {
            i2 = 8;
            this.cameraButton.setData(R.drawable.calls_video, -1, 0, 1.0f, true, LocaleController.getString("VoipCamera", R.string.VoipCamera), !z3, animated);
            this.cameraButton.setChecked(true, false);
        } else {
            i2 = 8;
            this.cameraButton.setVisibility(8);
        }
        if (i != 0) {
            this.flipButton.setData(0, -1, 0, 1.0f, true, LocaleController.getString("VoipFlip", R.string.VoipFlip), false, false);
            this.flipButton.setChecked(true, false);
        } else {
            this.flipButton.setVisibility(i2);
        }
        this.soundButton.setVisibility(z2 ? 0 : 8);
        if (z4 && z2) {
            updateSpeakerPhoneIcon(false);
        }
        if (z4) {
            float f2 = z2 ? 1.0f : 0.3f;
            if (!animated) {
                this.soundButton.animate().cancel();
                this.soundButton.setScaleX(f2);
                this.soundButton.setScaleY(f2);
            } else {
                if (z2) {
                    this.soundButton.setScaleX(0.3f);
                    this.soundButton.setScaleY(0.3f);
                }
                this.soundButton.animate().scaleX(f2).scaleY(f2).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
            }
        }
        if (this.cameraButton.getVisibility() == 0) {
            this.cameraButton.showText(true, animated);
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        if (this.cameraButtonScale != f) {
            this.cameraButtonScale = f;
            if (!animated) {
                this.cameraButton.animate().cancel();
                this.cameraButton.setScaleX(f);
                this.cameraButton.setScaleY(f);
            } else {
                this.cameraButton.animate().scaleX(f).scaleY(f).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
            }
        }
        float f3 = 0.8f;
        if (!isTabletMode && (isLandscapeMode || ((groupCallRenderersContainer = this.renderersContainer) != null && groupCallRenderersContainer.inFullscreenMode))) {
            f3 = 1.0f;
        }
        if (!z3) {
            f3 = 0.3f;
        }
        if (!animated) {
            this.flipButton.animate().cancel();
            this.flipButton.setScaleX(f3);
            this.flipButton.setScaleY(f3);
        } else {
            this.flipButton.animate().scaleX(f3).scaleY(f3).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
        this.flipButton.showText(f3 == 1.0f, animated);
        float f4 = z3 ? 0.3f : 1.0f;
        if (this.soundButtonScale != f4) {
            this.soundButtonScale = f4;
            if (!animated) {
                this.soundButton.animate().cancel();
                this.soundButton.setScaleX(f4);
                this.soundButton.setScaleY(f4);
                return;
            }
            this.soundButton.animate().scaleX(f4).scaleY(f4).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onAudioSettingsChanged() {
        updateSpeakerPhoneIcon(true);
        if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute()) {
            setMicAmplitude(0.0f);
        }
        if (this.listView.getVisibility() == 0) {
            AndroidUtilities.updateVisibleRows(this.listView);
        }
        if (this.fullscreenUsersListView.getVisibility() == 0) {
            AndroidUtilities.updateVisibleRows(this.fullscreenUsersListView);
        }
        this.attachedRenderersTmp.clear();
        this.attachedRenderersTmp.addAll(this.attachedRenderers);
        for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
            this.attachedRenderersTmp.get(i).updateAttachState(true);
        }
    }

    private void updateSpeakerPhoneIcon(boolean animated) {
        VoIPToggleButton voIPToggleButton = this.soundButton;
        if (voIPToggleButton == null || voIPToggleButton.getVisibility() != 0) {
            return;
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        boolean z = false;
        if (sharedInstance == null) {
            this.soundButton.setData(R.drawable.msg_voiceshare, -1, 0, 0.3f, true, LocaleController.getString("VoipChatShare", R.string.VoipChatShare), false, animated);
            this.soundButton.setEnabled(!TextUtils.isEmpty(this.currentChat.username) || (ChatObject.hasAdminRights(this.currentChat) && ChatObject.canAddUsers(this.currentChat)), false);
            this.soundButton.setChecked(true, false);
            return;
        }
        this.soundButton.setEnabled(true, animated);
        boolean z2 = sharedInstance.isBluetoothOn() || sharedInstance.isBluetoothWillOn();
        if (!z2 && sharedInstance.isSpeakerphoneOn()) {
            z = true;
        }
        if (z2) {
            this.soundButton.setData(R.drawable.calls_bluetooth, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth), false, animated);
        } else if (z) {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.3f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
        } else if (sharedInstance.isHeadsetPlugged()) {
            this.soundButton.setData(R.drawable.calls_headphones, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingHeadset", R.string.VoipAudioRoutingHeadset), false, animated);
        } else {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.1f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, animated);
        }
        this.soundButton.setChecked(z, animated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateMuteButton(int r18, boolean r19) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.updateMuteButton(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateMuteButton$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateMuteButton$49$GroupCallActivity(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.muteLabel[0].setAlpha(1.0f - fFloatValue);
        this.muteLabel[0].setTranslationY(AndroidUtilities.dp(5.0f) * fFloatValue);
        this.muteLabel[1].setAlpha(fFloatValue);
        this.muteLabel[1].setTranslationY(AndroidUtilities.dp((fFloatValue * 5.0f) - 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillColors(int state, int[] colorsToSet) {
        if (state == 0) {
            colorsToSet[0] = Theme.getColor("voipgroup_unmuteButton2");
            colorsToSet[1] = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_soundButtonActive"), Theme.getColor("voipgroup_soundButtonActiveScrolled"), this.colorProgress, 1.0f);
            colorsToSet[2] = Theme.getColor("voipgroup_soundButton");
        } else if (state == 1) {
            colorsToSet[0] = Theme.getColor("voipgroup_muteButton2");
            colorsToSet[1] = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_soundButtonActive2"), Theme.getColor("voipgroup_soundButtonActive2Scrolled"), this.colorProgress, 1.0f);
            colorsToSet[2] = Theme.getColor("voipgroup_soundButton2");
        } else if (isGradientState(state)) {
            colorsToSet[0] = Theme.getColor("voipgroup_mutedByAdminGradient3");
            colorsToSet[1] = Theme.getColor("voipgroup_mutedByAdminMuteButton");
            colorsToSet[2] = Theme.getColor("voipgroup_mutedByAdminMuteButtonDisabled");
        } else {
            colorsToSet[0] = Theme.getColor("voipgroup_disabledButton");
            colorsToSet[1] = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_disabledButtonActive"), Theme.getColor("voipgroup_disabledButtonActiveScrolled"), this.colorProgress, 1.0f);
            colorsToSet[2] = AndroidUtilities.getOffsetColor(Theme.getColor("voipgroup_listViewBackgroundUnscrolled"), Theme.getColor("voipgroup_disabledButton"), this.colorProgress, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRecordHint(View view) {
        if (this.recordHintView == null) {
            HintView hintView = new HintView(getContext(), 8, true);
            this.recordHintView = hintView;
            hintView.setAlpha(0.0f);
            this.recordHintView.setVisibility(4);
            this.recordHintView.setShowingDuration(3000L);
            this.containerView.addView(this.recordHintView, LayoutHelper.createFrame(-2, -2.0f, 51, 19.0f, 0.0f, 19.0f, 0.0f));
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.recordHintView.setText(LocaleController.getString("VoipChannelRecording", R.string.VoipChannelRecording));
            } else {
                this.recordHintView.setText(LocaleController.getString("VoipGroupRecording", R.string.VoipGroupRecording));
            }
            this.recordHintView.setBackgroundColor(-366530760, -1);
        }
        this.recordHintView.setExtraTranslationY(-AndroidUtilities.statusBarHeight);
        this.recordHintView.showForView(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showReminderHint() {
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (globalMainSettings.getBoolean("reminderhint", false)) {
            return;
        }
        globalMainSettings.edit().putBoolean("reminderhint", true).commit();
        if (this.reminderHintView == null) {
            HintView hintView = new HintView(getContext(), 8);
            this.reminderHintView = hintView;
            hintView.setAlpha(0.0f);
            this.reminderHintView.setVisibility(4);
            this.reminderHintView.setShowingDuration(4000L);
            this.containerView.addView(this.reminderHintView, LayoutHelper.createFrame(-2, -2.0f, 51, 19.0f, 0.0f, 19.0f, 0.0f));
            this.reminderHintView.setText(LocaleController.getString("VoipChatReminderHint", R.string.VoipChatReminderHint));
            this.reminderHintView.setBackgroundColor(-366530760, -1);
        }
        this.reminderHintView.setExtraTranslationY(-AndroidUtilities.statusBarHeight);
        this.reminderHintView.showForView(this.muteButton, true);
    }

    private void updateMuteButtonState(boolean animated) {
        boolean z;
        this.muteButton.invalidate();
        WeavingState[] weavingStateArr = this.states;
        int i = this.muteButtonState;
        boolean z2 = false;
        if (weavingStateArr[i] == null) {
            weavingStateArr[i] = new WeavingState(i);
            int i2 = this.muteButtonState;
            if (i2 == 3) {
                this.states[i2].shader = null;
            } else if (isGradientState(i2)) {
                this.states[this.muteButtonState].shader = new LinearGradient(0.0f, 400.0f, 400.0f, 0.0f, new int[]{Theme.getColor("voipgroup_mutedByAdminGradient"), Theme.getColor("voipgroup_mutedByAdminGradient3"), Theme.getColor("voipgroup_mutedByAdminGradient2")}, (float[]) null, Shader.TileMode.CLAMP);
            } else {
                int i3 = this.muteButtonState;
                if (i3 == 1) {
                    this.states[i3].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor("voipgroup_muteButton"), Theme.getColor("voipgroup_muteButton3")}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    this.states[i3].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor("voipgroup_unmuteButton2"), Theme.getColor("voipgroup_unmuteButton")}, (float[]) null, Shader.TileMode.CLAMP);
                }
            }
        }
        WeavingState[] weavingStateArr2 = this.states;
        int i4 = this.muteButtonState;
        WeavingState weavingState = weavingStateArr2[i4];
        WeavingState weavingState2 = this.currentState;
        if (weavingState != weavingState2) {
            this.prevState = weavingState2;
            this.currentState = weavingStateArr2[i4];
            if (weavingState2 == null || !animated) {
                this.switchProgress = 1.0f;
                this.prevState = null;
            } else {
                this.switchProgress = 0.0f;
            }
        }
        if (!animated) {
            WeavingState weavingState3 = this.currentState;
            if (weavingState3 != null) {
                int i5 = weavingState3.currentState;
                boolean z3 = i5 == 1 || i5 == 0;
                z = i5 != 3;
                z2 = z3;
            } else {
                z = false;
            }
            this.showWavesProgress = z2 ? 1.0f : 0.0f;
            this.showLightingProgress = z ? 1.0f : 0.0f;
        }
        this.buttonsContainer.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processOnLeave(ChatObject.Call call, boolean z, long j, Runnable runnable) throws IllegalStateException, InterruptedException {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().hangUp(z ? 1 : 0);
        }
        if (call != null) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(j);
            if (tLRPC$TL_groupCallParticipant != null) {
                call.participants.delete(j);
                call.sortedParticipants.remove(tLRPC$TL_groupCallParticipant);
                call.visibleParticipants.remove(tLRPC$TL_groupCallParticipant);
                int i = 0;
                while (i < call.visibleVideoParticipants.size()) {
                    if (MessageObject.getPeerId(call.visibleVideoParticipants.get(i).participant.peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                        call.visibleVideoParticipants.remove(i);
                        i--;
                    }
                    i++;
                }
                TLRPC$GroupCall tLRPC$GroupCall = call.call;
                tLRPC$GroupCall.participants_count--;
            }
            for (int i2 = 0; i2 < call.sortedParticipants.size(); i2++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = call.sortedParticipants.get(i2);
                tLRPC$TL_groupCallParticipant2.lastActiveDate = tLRPC$TL_groupCallParticipant2.lastSpeakTime;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
    }

    public static void onLeaveClick(Context context, final Runnable onLeave, boolean fromOverlayWindow) throws IllegalStateException, InterruptedException {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        TLRPC$Chat chat = sharedInstance.getChat();
        final ChatObject.Call call = sharedInstance.groupCall;
        final long selfId = sharedInstance.getSelfId();
        if (!ChatObject.canManageCalls(chat)) {
            processOnLeave(call, false, selfId, onLeave);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        if (ChatObject.isChannelOrGiga(chat)) {
            builder.setTitle(LocaleController.getString("VoipChannelLeaveAlertTitle", R.string.VoipChannelLeaveAlertTitle));
            builder.setMessage(LocaleController.getString("VoipChannelLeaveAlertText", R.string.VoipChannelLeaveAlertText));
        } else {
            builder.setTitle(LocaleController.getString("VoipGroupLeaveAlertTitle", R.string.VoipGroupLeaveAlertTitle));
            builder.setMessage(LocaleController.getString("VoipGroupLeaveAlertText", R.string.VoipGroupLeaveAlertText));
        }
        sharedInstance.getAccount();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        final CheckBoxCell[] checkBoxCellArr = {new CheckBoxCell(context, 1)};
        checkBoxCellArr[0].setBackgroundDrawable(Theme.getSelectorDrawable(false));
        if (fromOverlayWindow) {
            checkBoxCellArr[0].setTextColor(Theme.getColor("dialogTextBlack"));
        } else {
            checkBoxCellArr[0].setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            ((CheckBoxSquare) checkBoxCellArr[0].getCheckBoxView()).setColors("voipgroup_mutedIcon", "voipgroup_listeningText", "voipgroup_nameText");
        }
        checkBoxCellArr[0].setTag(0);
        if (ChatObject.isChannelOrGiga(chat)) {
            checkBoxCellArr[0].setText(LocaleController.getString("VoipChannelLeaveAlertEndChat", R.string.VoipChannelLeaveAlertEndChat), "", false, false);
        } else {
            checkBoxCellArr[0].setText(LocaleController.getString("VoipGroupLeaveAlertEndChat", R.string.VoipGroupLeaveAlertEndChat), "", false, false);
        }
        checkBoxCellArr[0].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
        linearLayout.addView(checkBoxCellArr[0], LayoutHelper.createLinear(-1, -2));
        checkBoxCellArr[0].setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$h-7maaMMRX3BFtWBlFShiScg98c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                checkBoxCellArr[((Integer) view.getTag()).intValue()].setChecked(!r0[view.intValue()].isChecked(), true);
            }
        });
        builder.setCustomViewOffset(12);
        builder.setView(linearLayout);
        builder.setDialogButtonColorKey("voipgroup_listeningText");
        builder.setPositiveButton(LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$mhWnOnqpjLwlboUbpehD9FksJS0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) throws IllegalStateException, InterruptedException {
                GroupCallActivity.processOnLeave(call, checkBoxCellArr[0].isChecked(), selfId, onLeave);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        if (fromOverlayWindow) {
            builder.setDimEnabled(false);
        }
        AlertDialog alertDialogCreate = builder.create();
        if (fromOverlayWindow) {
            if (Build.VERSION.SDK_INT >= 26) {
                alertDialogCreate.getWindow().setType(2038);
            } else {
                alertDialogCreate.getWindow().setType(2003);
            }
            alertDialogCreate.getWindow().clearFlags(2);
        }
        if (!fromOverlayWindow) {
            alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
        }
        alertDialogCreate.show();
        if (fromOverlayWindow) {
            return;
        }
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("voipgroup_leaveCallMenu"));
        }
        alertDialogCreate.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processSelectedOption(TLRPC$TL_groupCallParticipant participant, final long peerId, int option) throws InterruptedException {
        TLObject chat;
        String firstName;
        TextView textView;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (peerId > 0) {
            chat = this.accountInstance.getMessagesController().getUser(Long.valueOf(peerId));
        } else {
            chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-peerId));
        }
        final TLObject tLObject = chat;
        if (option == 0 || option == 2 || option == 3) {
            if (option == 0) {
                if (VoIPService.getSharedInstance() == null) {
                    return;
                }
                VoIPService.getSharedInstance().editCallMember(tLObject, Boolean.TRUE, null, null, null, null);
                getUndoView().showWithAction(0L, 30, tLObject, (Object) null, (Runnable) null, (Runnable) null);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setDialogButtonColorKey("voipgroup_listeningText");
            TextView textView2 = new TextView(getContext());
            textView2.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            textView2.setTextSize(1, 16.0f);
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            FrameLayout frameLayout = new FrameLayout(getContext());
            builder.setView(frameLayout);
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setTextSize(AndroidUtilities.dp(12.0f));
            BackupImageView backupImageView = new BackupImageView(getContext());
            backupImageView.setRoundRadius(AndroidUtilities.dp(20.0f));
            frameLayout.addView(backupImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 5 : 3) | 48, 22.0f, 5.0f, 22.0f, 0.0f));
            avatarDrawable.setInfo(tLObject);
            boolean z = tLObject instanceof TLRPC$User;
            if (z) {
                TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                backupImageView.setForUserOrChat(tLRPC$User, avatarDrawable);
                firstName = UserObject.getFirstName(tLRPC$User);
            } else {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable);
                firstName = tLRPC$Chat.title;
            }
            TextView textView3 = new TextView(getContext());
            textView3.setTextColor(Theme.getColor("voipgroup_actionBarItems"));
            textView3.setTextSize(1, 20.0f);
            textView3.setTypeface(AndroidUtilities.getFontFamily(true));
            textView3.setLines(1);
            textView3.setMaxLines(1);
            textView3.setSingleLine(true);
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            if (option == 2) {
                textView3.setText(LocaleController.getString("VoipGroupRemoveMemberAlertTitle2", R.string.VoipGroupRemoveMemberAlertTitle2));
                if (ChatObject.isChannelOrGiga(this.currentChat)) {
                    textView2.setText(AndroidUtilities.replaceTags(LocaleController.formatString("VoipChannelRemoveMemberAlertText2", R.string.VoipChannelRemoveMemberAlertText2, firstName, this.currentChat.title)));
                } else {
                    textView2.setText(AndroidUtilities.replaceTags(LocaleController.formatString("VoipGroupRemoveMemberAlertText2", R.string.VoipGroupRemoveMemberAlertText2, firstName, this.currentChat.title)));
                }
            } else {
                textView3.setText(LocaleController.getString("VoipGroupAddMemberTitle", R.string.VoipGroupAddMemberTitle));
                textView2.setText(AndroidUtilities.replaceTags(LocaleController.formatString("VoipGroupAddMemberText", R.string.VoipGroupAddMemberText, firstName, this.currentChat.title)));
            }
            boolean z2 = LocaleController.isRTL;
            frameLayout.addView(textView3, LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 21 : 76, 11.0f, z2 ? 76 : 21, 0.0f));
            frameLayout.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
            if (option == 2) {
                builder.setPositiveButton(LocaleController.getString("VoipGroupUserRemove", R.string.VoipGroupUserRemove), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$ZNZ28DIaJOgLPlWURZ174YXVoAU
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$processSelectedOption$52$GroupCallActivity(tLObject, dialogInterface, i);
                    }
                });
            } else if (z) {
                final TLRPC$User tLRPC$User2 = (TLRPC$User) tLObject;
                builder.setPositiveButton(LocaleController.getString("VoipGroupAdd", R.string.VoipGroupAdd), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$Id0UsiNK63f5HG-W_OJIW4nI3-Y
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$processSelectedOption$54$GroupCallActivity(tLRPC$User2, peerId, dialogInterface, i);
                    }
                });
            }
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setBackgroundColor(Theme.getColor("voipgroup_dialogBackground"));
            alertDialogCreate.show();
            if (option != 2 || (textView = (TextView) alertDialogCreate.getButton(-1)) == null) {
                return;
            }
            textView.setTextColor(Theme.getColor("voipgroup_leaveCallMenu"));
            return;
        }
        if (option == 6) {
            this.parentActivity.switchToAccount(this.currentAccount, true);
            Bundle bundle = new Bundle();
            if (peerId > 0) {
                bundle.putLong("user_id", peerId);
            } else {
                bundle.putLong("chat_id", -peerId);
            }
            this.parentActivity.lambda$runLinkRequest$39$LaunchActivity(new ChatActivity(bundle));
            dismiss();
            return;
        }
        if (option == 8) {
            this.parentActivity.switchToAccount(this.currentAccount, true);
            BaseFragment baseFragment = this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1);
            if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).getDialogId() == peerId) {
                dismiss();
                return;
            }
            Bundle bundle2 = new Bundle();
            if (peerId > 0) {
                bundle2.putLong("user_id", peerId);
            } else {
                bundle2.putLong("chat_id", -peerId);
            }
            this.parentActivity.lambda$runLinkRequest$39$LaunchActivity(new ChatActivity(bundle2));
            dismiss();
            return;
        }
        if (option == 7) {
            sharedInstance.editCallMember(tLObject, Boolean.TRUE, null, null, Boolean.FALSE, null);
            updateMuteButton(2, true);
            return;
        }
        if (option == 9) {
            ImageUpdater imageUpdater = this.currentAvatarUpdater;
            if (imageUpdater == null || !imageUpdater.isUploadingImage()) {
                ImageUpdater imageUpdater2 = new ImageUpdater(true);
                this.currentAvatarUpdater = imageUpdater2;
                imageUpdater2.setOpenWithFrontfaceCamera(true);
                this.currentAvatarUpdater.setForceDarkTheme(true);
                this.currentAvatarUpdater.setSearchAvailable(true, true);
                this.currentAvatarUpdater.setShowingFromDialog(true);
                this.currentAvatarUpdater.parentFragment = this.parentActivity.getActionBarLayout().getLastFragment();
                ImageUpdater imageUpdater3 = this.currentAvatarUpdater;
                AvatarUpdaterDelegate avatarUpdaterDelegate = new AvatarUpdaterDelegate(peerId);
                this.avatarUpdaterDelegate = avatarUpdaterDelegate;
                imageUpdater3.setDelegate(avatarUpdaterDelegate);
                TLRPC$User currentUser = this.accountInstance.getUserConfig().getCurrentUser();
                ImageUpdater imageUpdater4 = this.currentAvatarUpdater;
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = currentUser.photo;
                imageUpdater4.openMenu((tLRPC$UserProfilePhoto == null || tLRPC$UserProfilePhoto.photo_big == null || (tLRPC$UserProfilePhoto instanceof TLRPC$TL_userProfilePhotoEmpty)) ? false : true, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$_QQT8i6m5uqtx0mzJDdnfWCeJ7s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processSelectedOption$55$GroupCallActivity();
                    }
                }, new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$9xjyZvzL55c2szJGnaLuChW8kRo
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        GroupCallActivity.lambda$processSelectedOption$56(dialogInterface);
                    }
                });
                return;
            }
            return;
        }
        if (option == 10) {
            AlertsCreator.createChangeBioAlert(participant.about, peerId, getContext(), this.currentAccount);
            return;
        }
        if (option == 11) {
            AlertsCreator.createChangeNameAlert(peerId, getContext(), this.currentAccount);
            return;
        }
        if (option == 5) {
            sharedInstance.editCallMember(tLObject, Boolean.TRUE, null, null, null, null);
            getUndoView().showWithAction(0L, 35, tLObject);
            sharedInstance.setParticipantVolume(participant, 0);
            return;
        }
        if ((participant.flags & 128) != 0 && participant.volume == 0) {
            participant.volume = 10000;
            participant.volume_by_admin = false;
            sharedInstance.editCallMember(tLObject, Boolean.FALSE, null, 10000, null, null);
        } else {
            sharedInstance.editCallMember(tLObject, Boolean.FALSE, null, null, null, null);
        }
        sharedInstance.setParticipantVolume(participant, ChatObject.getParticipantVolume(participant));
        getUndoView().showWithAction(0L, option == 1 ? 31 : 36, tLObject, (Object) null, (Runnable) null, (Runnable) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$52$GroupCallActivity(TLObject tLObject, DialogInterface dialogInterface, int i) {
        if (tLObject instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
            this.accountInstance.getMessagesController().deleteParticipantFromChat(this.currentChat.id, tLRPC$User, null);
            getUndoView().showWithAction(0L, 32, tLRPC$User, (Object) null, (Runnable) null, (Runnable) null);
        } else {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
            this.accountInstance.getMessagesController().deleteParticipantFromChat(this.currentChat.id, null, tLRPC$Chat, null, false, false);
            getUndoView().showWithAction(0L, 32, tLRPC$Chat, (Object) null, (Runnable) null, (Runnable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$54$GroupCallActivity(TLRPC$User tLRPC$User, final long j, DialogInterface dialogInterface, int i) {
        this.accountInstance.getMessagesController().addUserToChat(this.currentChat.id, tLRPC$User, 0, null, this.parentActivity.getActionBarLayout().fragmentsStack.get(this.parentActivity.getActionBarLayout().fragmentsStack.size() - 1), new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$dqDIYUCCUJPC0xt8dk23rTbwtx8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSelectedOption$53$GroupCallActivity(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$53$GroupCallActivity(long j) {
        inviteUserToCall(j, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$55$GroupCallActivity() {
        this.accountInstance.getMessagesController().deleteUserPhoto(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c6 A[PHI: r21 r22 r23 r25 r26
      0x02c6: PHI (r21v3 ir.eitaa.ui.Cells.GroupCallUserCell) = 
      (r21v1 ir.eitaa.ui.Cells.GroupCallUserCell)
      (r21v5 ir.eitaa.ui.Cells.GroupCallUserCell)
      (r21v5 ir.eitaa.ui.Cells.GroupCallUserCell)
     binds: [B:102:0x02e9, B:100:0x02d3, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c6: PHI (r22v3 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout) = 
      (r22v1 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
      (r22v5 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
      (r22v5 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
     binds: [B:102:0x02e9, B:100:0x02d3, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c6: PHI (r23v2 android.widget.LinearLayout) = (r23v0 android.widget.LinearLayout), (r23v4 android.widget.LinearLayout), (r23v4 android.widget.LinearLayout) binds: [B:102:0x02e9, B:100:0x02d3, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c6: PHI (r25v2 boolean) = (r25v0 boolean), (r25v4 boolean), (r25v5 boolean) binds: [B:102:0x02e9, B:100:0x02d3, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c6: PHI (r26v2 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant) = 
      (r26v0 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
      (r26v7 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
      (r26v8 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
     binds: [B:102:0x02e9, B:100:0x02d3, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02c8 A[PHI: r21 r22 r23 r25 r26
      0x02c8: PHI (r21v2 ir.eitaa.ui.Cells.GroupCallUserCell) = 
      (r21v1 ir.eitaa.ui.Cells.GroupCallUserCell)
      (r21v5 ir.eitaa.ui.Cells.GroupCallUserCell)
      (r21v5 ir.eitaa.ui.Cells.GroupCallUserCell)
     binds: [B:102:0x02e9, B:93:0x02bf, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c8: PHI (r22v2 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout) = 
      (r22v1 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
      (r22v5 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
      (r22v5 ir.eitaa.ui.ActionBar.ActionBarPopupWindow$ActionBarPopupWindowLayout)
     binds: [B:102:0x02e9, B:93:0x02bf, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c8: PHI (r23v1 android.widget.LinearLayout) = (r23v0 android.widget.LinearLayout), (r23v4 android.widget.LinearLayout), (r23v4 android.widget.LinearLayout) binds: [B:102:0x02e9, B:93:0x02bf, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c8: PHI (r25v1 boolean) = (r25v0 boolean), (r25v5 boolean), (r25v5 boolean) binds: [B:102:0x02e9, B:93:0x02bf, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]
      0x02c8: PHI (r26v1 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant) = 
      (r26v0 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
      (r26v8 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
      (r26v8 ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant)
     binds: [B:102:0x02e9, B:93:0x02bf, B:95:0x02c3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean showMenuForCell(android.view.View r30) {
        /*
            Method dump skipped, instructions count: 2104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.showMenuForCell(android.view.View):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForCell$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForCell$57$GroupCallActivity(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.scrimPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.scrimPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showMenuForCell$58, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showMenuForCell$58$GroupCallActivity(int i, ArrayList arrayList, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, View view) throws InterruptedException {
        if (i >= arrayList.size()) {
            return;
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.call.participants.get(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer));
        if (tLRPC$TL_groupCallParticipant2 != null) {
            tLRPC$TL_groupCallParticipant = tLRPC$TL_groupCallParticipant2;
        }
        processSelectedOption(tLRPC$TL_groupCallParticipant, MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer), ((Integer) arrayList.get(i)).intValue());
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        } else {
            if (((Integer) arrayList.get(i)).intValue() == 9 || ((Integer) arrayList.get(i)).intValue() == 10 || ((Integer) arrayList.get(i)).intValue() == 11) {
                return;
            }
            dismissAvatarPreview(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrimView() {
        GroupCallMiniTextureView groupCallMiniTextureView = this.scrimRenderer;
        if (groupCallMiniTextureView != null) {
            groupCallMiniTextureView.textureView.setRoundCorners(AndroidUtilities.dp(8.0f));
            this.scrimRenderer.setShowingAsScrimView(false, false);
            this.scrimRenderer.invalidate();
            this.renderersContainer.invalidate();
        }
        GroupCallUserCell groupCallUserCell = this.scrimView;
        if (groupCallUserCell != null && !this.hasScrimAnchorView && groupCallUserCell.getParent() != null) {
            this.containerView.removeView(this.scrimView);
        }
        GroupCallUserCell groupCallUserCell2 = this.scrimView;
        if (groupCallUserCell2 != null) {
            groupCallUserCell2.setProgressToAvatarPreview(0.0f);
            this.scrimView.setAboutVisible(false);
            this.scrimView.getAvatarImageView().setAlpha(1.0f);
        }
        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell3 = this.scrimFullscreenView;
        if (groupCallUserCell3 != null) {
            groupCallUserCell3.getAvatarImageView().setAlpha(1.0f);
        }
        this.scrimView = null;
        this.scrimGridView = null;
        this.scrimFullscreenView = null;
        this.scrimRenderer = null;
    }

    private void startScreenCapture() {
        LaunchActivity launchActivity = this.parentActivity;
        if (launchActivity == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        this.parentActivity.startActivityForResult(((MediaProjectionManager) launchActivity.getSystemService("media_projection")).createScreenCaptureIntent(), 520);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void runAvatarPreviewTransition(final boolean r18, ir.eitaa.ui.Cells.GroupCallUserCell r19) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.runAvatarPreviewTransition(boolean, ir.eitaa.ui.Cells.GroupCallUserCell):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$runAvatarPreviewTransition$59, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$runAvatarPreviewTransition$59$GroupCallActivity(float f, float f2, float f3, int i, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.progressToAvatarPreview = fFloatValue;
        this.renderersContainer.progressToScrimView = fFloatValue;
        float f4 = (f * (1.0f - fFloatValue)) + (fFloatValue * 1.0f);
        this.avatarPreviewContainer.setScaleX(f4);
        this.avatarPreviewContainer.setScaleY(f4);
        this.avatarPreviewContainer.setTranslationX(f2 * (1.0f - this.progressToAvatarPreview));
        this.avatarPreviewContainer.setTranslationY(f3 * (1.0f - this.progressToAvatarPreview));
        if (!this.useBlur) {
            this.scrimPaint.setAlpha((int) (this.progressToAvatarPreview * 100.0f));
        }
        GroupCallMiniTextureView groupCallMiniTextureView = this.scrimRenderer;
        if (groupCallMiniTextureView != null) {
            groupCallMiniTextureView.textureView.setRoundCorners(AndroidUtilities.dp(8.0f) * (1.0f - this.progressToAvatarPreview));
        }
        this.avatarPreviewContainer.invalidate();
        this.containerView.invalidate();
        ProfileGalleryView profileGalleryView = this.avatarsViewPager;
        float f5 = i;
        float f6 = this.progressToAvatarPreview;
        profileGalleryView.setRoundRadius((int) ((1.0f - f6) * f5), (int) (f5 * (1.0f - f6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAvatarPreview(boolean animated) {
        if (this.avatarPriviewTransitionInProgress || !this.avatarsPreviewShowed) {
            return;
        }
        if (animated) {
            this.avatarPriviewTransitionInProgress = true;
            runAvatarPreviewTransition(false, this.scrimView);
            return;
        }
        clearScrimView();
        this.containerView.removeView(this.scrimPopupLayout);
        this.scrimPopupLayout = null;
        this.avatarPreviewContainer.setVisibility(8);
        this.containerView.invalidate();
        this.avatarsPreviewShowed = false;
        this.layoutManager.setCanScrollVertically(true);
        this.listView.invalidate();
        this.blurredView.setVisibility(8);
        if (this.delayedGroupCallUpdated) {
            this.delayedGroupCallUpdated = false;
            applyCallParticipantUpdates(true);
        }
        checkContentOverlayed();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private int addMemberRow;
        private boolean hasSelfUser;
        private int invitedEndRow;
        private int invitedStartRow;
        private int lastRow;
        private Context mContext;
        private int rowsCount;
        private int usersEndRow;
        private int usersStartRow;
        private int usersVideoGridEndRow;
        private int usersVideoGridStartRow;
        private int videoGridDividerRow;
        private int videoNotAvailableRow;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        public boolean addSelfToCounter() {
            if (this.hasSelfUser || VoIPService.getSharedInstance() == null) {
                return false;
            }
            return !VoIPService.getSharedInstance().isJoined();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.rowsCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateRows() {
            /*
                Method dump skipped, instructions count: 268
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.ListAdapter.updateRows():void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRows();
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int position) {
            updateRows();
            super.notifyItemChanged(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int positionStart, int itemCount, Object payload) {
            updateRows();
            super.notifyItemRangeChanged(positionStart, itemCount, payload);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemMoved(int fromPosition, int toPosition) {
            updateRows();
            super.notifyItemMoved(fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int position) {
            updateRows();
            super.notifyItemRemoved(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int positionStart, int itemCount) {
            updateRows();
            super.notifyItemRangeRemoved(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            String str;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 1) {
                GroupCallUserCell groupCallUserCell = (GroupCallUserCell) holder.itemView;
                str = GroupCallActivity.this.actionBar.getTag() == null ? "voipgroup_mutedIconUnscrolled" : "voipgroup_mutedIcon";
                groupCallUserCell.setGrayIconColor(str, Theme.getColor(str));
                groupCallUserCell.setDrawDivider(holder.getAdapterPosition() != getItemCount() - 2);
                return;
            }
            if (itemViewType == 2) {
                GroupCallInvitedCell groupCallInvitedCell = (GroupCallInvitedCell) holder.itemView;
                str = GroupCallActivity.this.actionBar.getTag() == null ? "voipgroup_mutedIconUnscrolled" : "voipgroup_mutedIcon";
                groupCallInvitedCell.setGrayIconColor(str, Theme.getColor(str));
                groupCallInvitedCell.setDrawDivider(holder.getAdapterPosition() != getItemCount() - 2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r17, int r18) {
            /*
                Method dump skipped, instructions count: 543
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.GroupCallActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 1) {
                return true;
            }
            return (itemViewType == 3 || itemViewType == 4 || itemViewType == 5 || itemViewType == 6) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == 0) {
                view = new GroupCallTextCell(this.mContext) { // from class: ir.eitaa.ui.GroupCallActivity.ListAdapter.1
                    @Override // ir.eitaa.ui.Cells.GroupCallTextCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(widthMeasureSpec)), 1073741824), heightMeasureSpec);
                        } else {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        }
                    }
                };
            } else if (viewType == 1) {
                view = new GroupCallUserCell(this.mContext) { // from class: ir.eitaa.ui.GroupCallActivity.ListAdapter.2
                    @Override // ir.eitaa.ui.Cells.GroupCallUserCell
                    /* renamed from: onMuteClick */
                    protected void lambda$new$5$GroupCallUserCell(GroupCallUserCell cell) {
                        GroupCallActivity.this.showMenuForCell(cell);
                    }

                    @Override // ir.eitaa.ui.Cells.GroupCallUserCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(widthMeasureSpec)), 1073741824), heightMeasureSpec);
                        } else {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        }
                    }
                };
            } else if (viewType != 2) {
                boolean z = false;
                if (viewType == 4) {
                    view = new GroupCallGridCell(this.mContext, z) { // from class: ir.eitaa.ui.GroupCallActivity.ListAdapter.4
                        @Override // ir.eitaa.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
                        protected void onAttachedToWindow() {
                            super.onAttachedToWindow();
                            if (GroupCallActivity.this.listView.getVisibility() == 0 && GroupCallActivity.this.listViewVideoVisibility) {
                                GroupCallActivity.this.attachRenderer(this, true);
                            }
                        }

                        @Override // ir.eitaa.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
                        protected void onDetachedFromWindow() {
                            super.onDetachedFromWindow();
                            GroupCallActivity.this.attachRenderer(this, false);
                        }
                    };
                } else if (viewType == 5) {
                    view = new View(this.mContext) { // from class: ir.eitaa.ui.GroupCallActivity.ListAdapter.5
                        @Override // android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(GroupCallActivity.isLandscapeMode ? 0.0f : 8.0f), 1073741824));
                        }
                    };
                } else if (viewType == 6) {
                    TextView textView = new TextView(this.mContext);
                    textView.setTextColor(-8682615);
                    textView.setTextSize(1, 13.0f);
                    textView.setGravity(1);
                    textView.setPadding(0, 0, 0, AndroidUtilities.dp(10.0f));
                    if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                        textView.setText(LocaleController.formatString("VoipChannelVideoNotAvailableAdmin", R.string.VoipChannelVideoNotAvailableAdmin, LocaleController.formatPluralString("Participants", GroupCallActivity.this.accountInstance.getMessagesController().groipCallVideoMaxParticipants)));
                    } else {
                        textView.setText(LocaleController.formatString("VoipVideoNotAvailableAdmin", R.string.VoipVideoNotAvailableAdmin, LocaleController.formatPluralString("Members", GroupCallActivity.this.accountInstance.getMessagesController().groipCallVideoMaxParticipants)));
                    }
                    view = textView;
                } else {
                    view = new View(this.mContext);
                }
            } else {
                view = new GroupCallInvitedCell(this.mContext) { // from class: ir.eitaa.ui.GroupCallActivity.ListAdapter.3
                    @Override // ir.eitaa.ui.Cells.GroupCallInvitedCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(widthMeasureSpec)), 1073741824), heightMeasureSpec);
                        } else {
                            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                        }
                    }
                };
            }
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == this.lastRow) {
                return 3;
            }
            if (position == this.addMemberRow) {
                return 0;
            }
            if (position == this.videoGridDividerRow) {
                return 5;
            }
            if (position >= this.usersStartRow && position < this.usersEndRow) {
                return 1;
            }
            if (position < this.usersVideoGridStartRow || position >= this.usersVideoGridEndRow) {
                return position == this.videoNotAvailableRow ? 6 : 2;
            }
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachRenderer(GroupCallGridCell cell, boolean attach) {
        if (isDismissed()) {
            return;
        }
        if (attach && cell.getRenderer() == null) {
            cell.setRenderer(GroupCallMiniTextureView.getOrCreate(this.attachedRenderers, this.renderersContainer, cell, null, null, cell.getParticipant(), this.call, this));
        } else {
            if (attach || cell.getRenderer() == null) {
                return;
            }
            cell.getRenderer().setPrimaryView(null);
            cell.setRenderer(null);
        }
    }

    public void setOldRows(int addMemberRow, int usersStartRow, int usersEndRow, int invitedStartRow, int invitedEndRow, int usersVideoStartRow, int usersVideoEndRow, int videoDividerRow, int videoNotAvailableRow) {
        this.oldAddMemberRow = addMemberRow;
        this.oldUsersStartRow = usersStartRow;
        this.oldUsersEndRow = usersEndRow;
        this.oldInvitedStartRow = invitedStartRow;
        this.oldInvitedEndRow = invitedEndRow;
        this.oldUsersVideoStartRow = usersVideoStartRow;
        this.oldUsersVideoEndRow = usersVideoEndRow;
        this.oldVideoDividerRow = videoDividerRow;
        this.oldVideoNotAvailableRow = videoNotAvailableRow;
    }

    private static class UpdateCallback implements ListUpdateCallback {
        final RecyclerView.Adapter adapter;

        private UpdateCallback(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int position, int count) {
            this.adapter.notifyItemRangeInserted(position, count);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int position, int count) {
            this.adapter.notifyItemRangeRemoved(position, count);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int fromPosition, int toPosition) {
            this.adapter.notifyItemMoved(fromPosition, toPosition);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int position, int count, Object payload) {
            this.adapter.notifyItemRangeChanged(position, count, payload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleAdminSpeak() {
        TLRPC$TL_phone_toggleGroupCallSettings tLRPC$TL_phone_toggleGroupCallSettings = new TLRPC$TL_phone_toggleGroupCallSettings();
        tLRPC$TL_phone_toggleGroupCallSettings.call = this.call.getInputGroupCall();
        tLRPC$TL_phone_toggleGroupCallSettings.join_muted = this.call.call.join_muted;
        tLRPC$TL_phone_toggleGroupCallSettings.flags |= 1;
        this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_toggleGroupCallSettings, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$DPUSewyJMETO-dSq5w_44DJoIjU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleAdminSpeak$60$GroupCallActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$toggleAdminSpeak$60, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$toggleAdminSpeak$60$GroupCallActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return new ArrayList<>();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
        if (privateVideoPreviewDialog != null) {
            privateVideoPreviewDialog.dismiss(false, false);
            return;
        }
        if (this.avatarsPreviewShowed) {
            dismissAvatarPreview(true);
        } else if (this.renderersContainer.inFullscreenMode) {
            fullscreenFor(null);
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class AvatarUpdaterDelegate implements ImageUpdater.ImageUpdaterDelegate {
        private TLRPC$FileLocation avatar;
        private TLRPC$FileLocation avatarBig;
        private final long peerId;
        private ImageLocation uploadingImageLocation;
        public float uploadingProgress;

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didStartUpload(boolean isVideo) {
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ String getInitialSearchString() {
            return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
        }

        private AvatarUpdaterDelegate(long peerId) {
            this.peerId = peerId;
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didUploadPhoto(final TLRPC$InputFile photo, final TLRPC$InputFile video, final double videoStartTimestamp, final String videoPath, final TLRPC$PhotoSize bigSize, final TLRPC$PhotoSize smallSize) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$AvatarUpdaterDelegate$zq-cmSWyMEGjdN1AV92tlyW6CEo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$3$GroupCallActivity$AvatarUpdaterDelegate(photo, video, videoStartTimestamp, videoPath, smallSize, bigSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didUploadPhoto$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didUploadPhoto$1$GroupCallActivity$AvatarUpdaterDelegate(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$AvatarUpdaterDelegate$1-Qnir2ZN4wHHI3MsGbjrQJeaLU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$0$GroupCallActivity$AvatarUpdaterDelegate(tLRPC$TL_error, tLObject, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didUploadPhoto$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didUploadPhoto$0$GroupCallActivity$AvatarUpdaterDelegate(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
            if (this.uploadingImageLocation != null) {
                GroupCallActivity.this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
                this.uploadingImageLocation = null;
            }
            if (tLRPC$TL_error == null) {
                TLRPC$User user = GroupCallActivity.this.accountInstance.getMessagesController().getUser(Long.valueOf(GroupCallActivity.this.accountInstance.getUserConfig().getClientUserId()));
                if (user == null) {
                    user = GroupCallActivity.this.accountInstance.getUserConfig().getCurrentUser();
                    if (user == null) {
                        return;
                    } else {
                        GroupCallActivity.this.accountInstance.getMessagesController().putUser(user, false);
                    }
                } else {
                    GroupCallActivity.this.accountInstance.getUserConfig().setCurrentUser(user);
                }
                TLRPC$TL_photos_photo tLRPC$TL_photos_photo = (TLRPC$TL_photos_photo) tLObject;
                ArrayList<TLRPC$PhotoSize> arrayList = tLRPC$TL_photos_photo.photo.sizes;
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(arrayList, ImageReceiver.DEFAULT_CROSSFADE_DURATION);
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, 800);
                TLRPC$VideoSize tLRPC$VideoSize = tLRPC$TL_photos_photo.photo.video_sizes.isEmpty() ? null : tLRPC$TL_photos_photo.photo.video_sizes.get(0);
                TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
                user.photo = tLRPC$TL_userProfilePhoto;
                tLRPC$TL_userProfilePhoto.photo_id = tLRPC$TL_photos_photo.photo.id;
                if (closestPhotoSizeWithSize != null) {
                    tLRPC$TL_userProfilePhoto.photo_small = closestPhotoSizeWithSize.location;
                }
                if (closestPhotoSizeWithSize2 != null) {
                    tLRPC$TL_userProfilePhoto.photo_big = closestPhotoSizeWithSize2.location;
                }
                if (closestPhotoSizeWithSize != null && this.avatar != null) {
                    FileLoader.getPathToAttach(this.avatar, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize, true));
                    ImageLoader.getInstance().replaceImageInCache(this.avatar.volume_id + "_" + this.avatar.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForUser(user, 1), false);
                }
                if (closestPhotoSizeWithSize2 != null && this.avatarBig != null) {
                    FileLoader.getPathToAttach(this.avatarBig, true).renameTo(FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true));
                }
                if (tLRPC$VideoSize != null && str != null) {
                    new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
                }
                GroupCallActivity.this.accountInstance.getMessagesStorage().clearUserPhotos(user.id);
                ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
                arrayList2.add(user);
                GroupCallActivity.this.accountInstance.getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
                TLRPC$User user2 = GroupCallActivity.this.accountInstance.getMessagesController().getUser(Long.valueOf(this.peerId));
                ImageLocation forUser = ImageLocation.getForUser(user2, 0);
                ImageLocation forUser2 = ImageLocation.getForUser(user2, 1);
                if (ImageLocation.getForLocal(this.avatarBig) == null) {
                    forUser2 = ImageLocation.getForLocal(this.avatar);
                }
                GroupCallActivity.this.avatarsViewPager.setCreateThumbFromParent(false);
                GroupCallActivity.this.avatarsViewPager.initIfEmpty(forUser, forUser2);
                this.avatar = null;
                this.avatarBig = null;
                AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
                updateAvatarUploadingProgress(1.0f);
            }
            GroupCallActivity.this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.updateInterfaces, Integer.valueOf(MessagesController.UPDATE_MASK_ALL));
            GroupCallActivity.this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
            GroupCallActivity.this.accountInstance.getUserConfig().saveConfig(true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didUploadPhoto$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didUploadPhoto$2$GroupCallActivity$AvatarUpdaterDelegate() {
            if (this.uploadingImageLocation != null) {
                GroupCallActivity.this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
                this.uploadingImageLocation = null;
            }
            TLRPC$Chat chat = GroupCallActivity.this.accountInstance.getMessagesController().getChat(Long.valueOf(-this.peerId));
            ImageLocation forChat = ImageLocation.getForChat(chat, 0);
            ImageLocation forChat2 = ImageLocation.getForChat(chat, 1);
            if (ImageLocation.getForLocal(this.avatarBig) == null) {
                forChat2 = ImageLocation.getForLocal(this.avatar);
            }
            GroupCallActivity.this.avatarsViewPager.setCreateThumbFromParent(false);
            GroupCallActivity.this.avatarsViewPager.initIfEmpty(forChat, forChat2);
            this.avatar = null;
            this.avatarBig = null;
            AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
            updateAvatarUploadingProgress(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didUploadPhoto$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didUploadPhoto$3$GroupCallActivity$AvatarUpdaterDelegate(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
            if (tLRPC$InputFile == null && tLRPC$InputFile2 == null) {
                this.avatar = tLRPC$PhotoSize.location;
                TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize2.location;
                this.avatarBig = tLRPC$FileLocation;
                this.uploadingImageLocation = ImageLocation.getForLocal(tLRPC$FileLocation);
                GroupCallActivity.this.avatarsViewPager.addUploadingImage(this.uploadingImageLocation, ImageLocation.getForLocal(this.avatar));
                AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
                return;
            }
            if (this.peerId <= 0) {
                GroupCallActivity.this.accountInstance.getMessagesController().changeChatAvatar(-this.peerId, null, tLRPC$InputFile, tLRPC$InputFile2, d, str, tLRPC$PhotoSize.location, tLRPC$PhotoSize2.location, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$AvatarUpdaterDelegate$KcRSAUaToaijIKj8erYsBrf2g2o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didUploadPhoto$2$GroupCallActivity$AvatarUpdaterDelegate();
                    }
                });
                return;
            }
            TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
            if (tLRPC$InputFile != null) {
                tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
                tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
            }
            if (tLRPC$InputFile2 != null) {
                tLRPC$TL_photos_uploadProfilePhoto.video = tLRPC$InputFile2;
                int i = tLRPC$TL_photos_uploadProfilePhoto.flags | 2;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i;
                tLRPC$TL_photos_uploadProfilePhoto.video_start_ts = d;
                tLRPC$TL_photos_uploadProfilePhoto.flags = i | 4;
            }
            GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$AvatarUpdaterDelegate$ASn1GgS47aCdLLpOTbxn2hFAagw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$didUploadPhoto$1$GroupCallActivity$AvatarUpdaterDelegate(str, tLObject, tLRPC$TL_error);
                }
            });
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void onUploadProgressChanged(float progress) {
            GroupCallActivity.this.avatarsViewPager.setUploadProgress(this.uploadingImageLocation, progress);
            updateAvatarUploadingProgress(progress);
        }

        public void updateAvatarUploadingProgress(float progress) {
            this.uploadingProgress = progress;
            if (GroupCallActivity.this.listView == null) {
                return;
            }
            for (int i = 0; i < GroupCallActivity.this.listView.getChildCount(); i++) {
                View childAt = GroupCallActivity.this.listView.getChildAt(i);
                if (childAt instanceof GroupCallUserCell) {
                    GroupCallUserCell groupCallUserCell = (GroupCallUserCell) childAt;
                    if (groupCallUserCell.isSelfUser()) {
                        groupCallUserCell.setUploadProgress(progress, true);
                    }
                }
            }
        }
    }

    public View getScrimView() {
        return this.scrimView;
    }

    @Override // ir.eitaa.messenger.voip.VoIPService.StateListener
    public void onCameraSwitch(boolean isFrontFace) {
        this.attachedRenderersTmp.clear();
        this.attachedRenderersTmp.addAll(this.attachedRenderers);
        for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
            this.attachedRenderersTmp.get(i).updateAttachState(true);
        }
        PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
        if (privateVideoPreviewDialog != null) {
            privateVideoPreviewDialog.update();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class GroupCallItemAnimator extends DefaultItemAnimator {
        HashSet<RecyclerView.ViewHolder> addingHolders;
        public float animationProgress;
        public ValueAnimator animator;
        float outMaxBottom;
        float outMinTop;
        HashSet<RecyclerView.ViewHolder> removingHolders;

        private GroupCallItemAnimator() {
            this.addingHolders = new HashSet<>();
            this.removingHolders = new HashSet<>();
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void endAnimations() {
            super.endAnimations();
            this.removingHolders.clear();
            this.addingHolders.clear();
            this.outMinTop = Float.MAX_VALUE;
            GroupCallActivity.this.listView.invalidate();
        }

        public void updateBackgroundBeforeAnimation() {
            if (this.animator != null) {
                return;
            }
            this.addingHolders.clear();
            this.addingHolders.addAll(this.mPendingAdditions);
            this.removingHolders.clear();
            this.removingHolders.addAll(this.mPendingRemovals);
            this.outMaxBottom = 0.0f;
            this.outMinTop = Float.MAX_VALUE;
            if (this.addingHolders.isEmpty() && this.removingHolders.isEmpty()) {
                return;
            }
            int childCount = GroupCallActivity.this.listView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = GroupCallActivity.this.listView.getChildAt(i);
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = GroupCallActivity.this.listView.findContainingViewHolder(childAt);
                if (viewHolderFindContainingViewHolder != null && viewHolderFindContainingViewHolder.getItemViewType() != 3 && viewHolderFindContainingViewHolder.getItemViewType() != 4 && viewHolderFindContainingViewHolder.getItemViewType() != 5 && !this.addingHolders.contains(viewHolderFindContainingViewHolder)) {
                    this.outMaxBottom = Math.max(this.outMaxBottom, childAt.getY() + childAt.getMeasuredHeight());
                    this.outMinTop = Math.min(this.outMinTop, Math.max(0.0f, childAt.getY()));
                }
            }
            this.animationProgress = 0.0f;
            GroupCallActivity.this.listView.invalidate();
        }

        @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.RecyclerView.ItemAnimator
        public void runPendingAnimations() {
            boolean z = !this.mPendingRemovals.isEmpty();
            boolean z2 = !this.mPendingMoves.isEmpty();
            boolean z3 = !this.mPendingAdditions.isEmpty();
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.animator = null;
            }
            if (z || z2 || z3) {
                this.animationProgress = 0.0f;
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.animator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$GroupCallActivity$GroupCallItemAnimator$6x89TkWc80YYa-IabeISh3euwqA
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$runPendingAnimations$0$GroupCallActivity$GroupCallItemAnimator(valueAnimator2);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.GroupCallActivity.GroupCallItemAnimator.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        GroupCallItemAnimator groupCallItemAnimator = GroupCallItemAnimator.this;
                        groupCallItemAnimator.animator = null;
                        GroupCallActivity.this.listView.invalidate();
                        GroupCallActivity.this.renderersContainer.invalidate();
                        ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                        GroupCallActivity.this.updateLayout(true);
                        GroupCallItemAnimator.this.addingHolders.clear();
                        GroupCallItemAnimator.this.removingHolders.clear();
                    }
                });
                this.animator.setDuration(350L);
                this.animator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                this.animator.start();
                GroupCallActivity.this.listView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
            }
            super.runPendingAnimations();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$runPendingAnimations$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$runPendingAnimations$0$GroupCallActivity$GroupCallItemAnimator(ValueAnimator valueAnimator) {
            this.animationProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GroupCallActivity.this.listView.invalidate();
            GroupCallActivity.this.renderersContainer.invalidate();
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity.this.updateLayout(true);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithTouchOutside() {
        return !this.renderersContainer.inFullscreenMode;
    }

    public void onResume() {
        paused = false;
        this.listAdapter.notifyDataSetChanged();
        if (this.fullscreenUsersListView.getVisibility() == 0) {
            this.fullscreenAdapter.update(false, this.fullscreenUsersListView);
        }
        if (isTabletMode) {
            this.tabletGridAdapter.update(false, this.tabletVideoGridView);
        }
        this.attachedRenderersTmp.clear();
        this.attachedRenderersTmp.addAll(this.attachedRenderers);
        for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
            this.attachedRenderersTmp.get(i).updateAttachState(true);
        }
    }

    public void onPause() {
        paused = true;
        this.attachedRenderersTmp.clear();
        this.attachedRenderersTmp.addAll(this.attachedRenderers);
        for (int i = 0; i < this.attachedRenderersTmp.size(); i++) {
            this.attachedRenderersTmp.get(i).updateAttachState(false);
        }
    }
}
