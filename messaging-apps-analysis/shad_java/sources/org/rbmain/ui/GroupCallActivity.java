package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.utilites.Objects;
import ir.medu.shad.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DialogObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.support.LongSparseIntArray;
import org.rbmain.messenger.voip.NativeInstance;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.messenger.voip.VoipAudioManager;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$GroupCall;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCall;
import org.rbmain.tgnet.TLRPC$TL_groupCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputUser;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phone_createGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_discardGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_inviteToGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_saveDefaultGroupCallJoinAs;
import org.rbmain.tgnet.TLRPC$TL_phone_startScheduledGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_toggleGroupCallSettings;
import org.rbmain.tgnet.TLRPC$TL_phone_toggleGroupCallStartSubscription;
import org.rbmain.tgnet.TLRPC$TL_photos_photo;
import org.rbmain.tgnet.TLRPC$TL_photos_uploadProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCall;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhotoEmpty;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$VideoSize;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.ActionBarMenuSubItem;
import org.rbmain.ui.ActionBar.ActionBarPopupWindow;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.AccountSelectCell;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.GroupCallInvitedCell;
import org.rbmain.ui.Cells.GroupCallTextCell;
import org.rbmain.ui.Cells.GroupCallUserCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;
import org.rbmain.ui.Components.AnimationProperties;
import org.rbmain.ui.Components.AudioPlayerAlert;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.BlobDrawable;
import org.rbmain.ui.Components.CheckBoxSquare;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.FillLastGridLayoutManager;
import org.rbmain.ui.Components.GroupCallFullscreenAdapter;
import org.rbmain.ui.Components.GroupCallPip;
import org.rbmain.ui.Components.GroupCallRecordAlert;
import org.rbmain.ui.Components.GroupVoipInviteAlert;
import org.rbmain.ui.Components.HintView;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.JoinCallAlert;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.NumberPicker;
import org.rbmain.ui.Components.ProfileGalleryView;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.RecordStatusDrawable;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ShareAlert;
import org.rbmain.ui.Components.TypefaceSpan;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.Components.voip.CellFlickerDrawable;
import org.rbmain.ui.Components.voip.GroupCallGridCell;
import org.rbmain.ui.Components.voip.GroupCallMiniTextureView;
import org.rbmain.ui.Components.voip.GroupCallRenderersContainer;
import org.rbmain.ui.Components.voip.GroupCallStatusIcon;
import org.rbmain.ui.Components.voip.PrivateVideoPreviewDialog;
import org.rbmain.ui.Components.voip.RTMPStreamPipOverlay;
import org.rbmain.ui.Components.voip.VoIPToggleButton;
import org.rbmain.ui.GroupCallActivity;
import org.rbmain.ui.PinchToZoomHelper;

/* loaded from: classes4.dex */
public class GroupCallActivity extends BottomSheet implements NotificationCenter.NotificationCenterDelegate, VoIPService.StateListener {
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
    ObjectAnimator additionalSubtitleYAnimator;
    private ActionBarMenuSubItem adminItem;
    private float amplitude;
    private float animateAmplitudeDiff;
    boolean animateButtonsOnNextLayout;
    private float animateToAmplitude;
    private boolean animatingToFullscreenExpand;
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
    private ValueAnimator expandAnimator;
    private ImageView expandButton;
    private ValueAnimator expandSizeAnimator;
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
    private ImageView minimizeButton;
    private RLottieImageView muteButton;
    private ValueAnimator muteButtonAnimator;
    private int muteButtonState;
    private TextView[] muteLabel;
    private ActionBarMenuSubItem noiseItem;
    private int oldAddMemberRow;
    private int oldCount;
    private ArrayList<Integer> oldInvited;
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
    private Runnable onUserLeaveHintListener;
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
    private boolean rtlLayout;
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
    private float scrollOffsetY;
    private TLRPC$Peer selfPeer;
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
    private Boolean wasExpandBigSize;
    private Boolean wasNotInLayoutFullscreen;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processSelectedOption$59(DialogInterface dialogInterface) {
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onCameraFirstFrameAvailable() {
        VoIPService.StateListener.CC.$default$onCameraFirstFrameAvailable(this);
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onMediaStateUpdated(int i, int i2) {
        VoIPService.StateListener.CC.$default$onMediaStateUpdated(this, i, i2);
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onScreenOnChange(boolean z) {
        VoIPService.StateListener.CC.$default$onScreenOnChange(this, z);
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onSignalBarsCountChanged(int i) {
        VoIPService.StateListener.CC.$default$onSignalBarsCountChanged(this, i);
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public /* synthetic */ void onVideoAvailableChange(boolean z) {
        VoIPService.StateListener.CC.$default$onVideoAvailableChange(this, z);
    }

    static /* synthetic */ float access$10516(GroupCallActivity groupCallActivity, float f) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0() {
        if (VoIPService.getSharedInstance() == null) {
            return;
        }
        VoIPService.getSharedInstance().setMicMute(false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (this.call == null || !this.scheduled || VoIPService.getSharedInstance() == null) {
            return;
        }
        this.muteButton.performHapticFeedback(3, 2);
        updateMuteButton(1, true);
        AndroidUtilities.runOnUIThread(this.unmuteRunnable, 80L);
        this.scheduled = false;
        this.pressed = true;
    }

    static {
        new AnimationProperties.FloatProperty<GroupCallActivity>("colorProgress") { // from class: org.rbmain.ui.GroupCallActivity.2
            @Override // org.rbmain.ui.Components.AnimationProperties.FloatProperty
            public void setValue(GroupCallActivity groupCallActivity, float f) {
                groupCallActivity.setColorProgress(f);
            }

            @Override // android.util.Property
            public Float get(GroupCallActivity groupCallActivity) {
                return Float.valueOf(groupCallActivity.getColorProgress());
            }
        };
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
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public SmallRecordCallDrawable(View view) {
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
        public void setAlpha(int i) {
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

        public void setRecording(boolean z) {
            this.recording = z;
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

        public WeavingState(int i) {
            this.currentState = i;
        }

        public void update(int i, int i2, int i3, long j, float f) {
            float f2;
            if (this.shader == null) {
                return;
            }
            float f3 = this.duration;
            if (f3 == 0.0f || this.time >= f3) {
                this.duration = Utilities.random.nextInt(200) + 1500;
                this.time = 0.0f;
                if (this.targetX == -1.0f) {
                    setTarget();
                }
                this.startX = this.targetX;
                this.startY = this.targetY;
                setTarget();
            }
            float f4 = j;
            float f5 = this.time + ((BlobDrawable.GRADIENT_SPEED_MIN + 0.5f) * f4) + (f4 * BlobDrawable.GRADIENT_SPEED_MAX * 2.0f * f);
            this.time = f5;
            float f6 = this.duration;
            if (f5 > f6) {
                this.time = f6;
            }
            float interpolation = CubicBezierInterpolator.EASE_OUT.getInterpolation(this.time / f6);
            float f7 = i3;
            float f8 = this.startX;
            float f9 = (i2 + ((f8 + ((this.targetX - f8) * interpolation)) * f7)) - 200.0f;
            float f10 = this.startY;
            float f11 = (i + (f7 * (f10 + ((this.targetY - f10) * interpolation)))) - 200.0f;
            if (GroupCallActivity.isGradientState(this.currentState)) {
                f2 = 1.0f;
            } else {
                f2 = this.currentState == 1 ? 4.0f : 2.5f;
            }
            float fDp = (AndroidUtilities.dp(122.0f) / 400.0f) * f2;
            this.matrix.reset();
            this.matrix.postTranslate(f9, f11);
            this.matrix.postScale(fDp, fDp, f9 + 200.0f, f11 + 200.0f);
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

    public static boolean isGradientState(int i) {
        return !(VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().groupCall == null || !VoIPService.getSharedInstance().groupCall.call.rtmp_stream) || i == 2 || i == 4 || i == 5 || i == 6 || i == 7;
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
        this.parentActivity.getActionBarLayout().getView().draw(canvas);
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

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean onCustomOpenAnimation() {
        groupCallUiVisible = true;
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.groupCallVisibilityChanged, new Object[0]);
        GroupCallPip.updateVisibility(getContext());
        return super.onCustomOpenAnimation();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.parentActivity.removeOnUserLeaveHintListener(this.onUserLeaveHintListener);
        this.parentActivity.setRequestedOrientation(-1);
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        int i3;
        String str;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2;
        int i4;
        String str2;
        String string;
        ChatObject.VideoParticipant videoParticipant;
        int i5;
        int i6;
        int i7 = 0;
        if (i == NotificationCenter.groupCallUpdated) {
            String str3 = (String) objArr[1];
            if (this.call == null || TextUtils.isEmpty(str3) || !Objects.equals(this.call.call.id, str3)) {
                return;
            }
            ChatObject.Call call = this.call;
            if (call.call instanceof TLRPC$TL_groupCallDiscarded) {
                dismiss();
                return;
            }
            if (this.creatingServiceTime == 0 && (((i6 = this.muteButtonState) == 7 || i6 == 5 || i6 == 6) && !call.isScheduled())) {
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda37
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$didReceivedNotification$2();
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
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = this.listView.getChildAt(i8);
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
            boolean zBooleanValue = ((Boolean) objArr[2]).booleanValue();
            boolean z = this.muteButtonState == 4;
            updateState(true, zBooleanValue);
            updateTitle(true);
            if (z && ((i5 = this.muteButtonState) == 1 || i5 == 0)) {
                getUndoView().showWithAction(0L, 38, (Runnable) null);
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().playAllowTalkSound();
                }
            }
            if (objArr.length >= 4) {
                long jLongValue = ((Long) objArr[3]).longValue();
                if (jLongValue == 0 || isRtmpStream()) {
                    return;
                }
                try {
                    ArrayList<TLRPC$Dialog> allDialogs = this.accountInstance.getMessagesController().getAllDialogs();
                    if (allDialogs != null) {
                        Iterator<TLRPC$Dialog> it = allDialogs.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().id == jLongValue) {
                                    i7 = 1;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
                if (DialogObject.isUserDialog(jLongValue)) {
                    TLRPC$User user = this.accountInstance.getMessagesController().getUser(Long.valueOf(jLongValue));
                    if (user != null) {
                        if (this.call.call.participants_count < 250 || UserObject.isContact(user) || user.verified || i7 != 0) {
                            getUndoView().showWithAction(0L, 44, user, this.currentChat, null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-jLongValue));
                if (chat != null) {
                    if (this.call.call.participants_count < 250 || !ChatObject.isNotInChat(chat) || chat.verified || i7 != 0) {
                        getUndoView().showWithAction(0L, 44, chat, this.currentChat, null, null);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.groupCallSpeakingUsersUpdated) {
            GroupCallRenderersContainer groupCallRenderersContainer = this.renderersContainer;
            if (groupCallRenderersContainer.inFullscreenMode && this.call != null) {
                boolean zAutoPinEnabled = groupCallRenderersContainer.autoPinEnabled();
                ChatObject.Call call2 = this.call;
                if (call2 != null) {
                    GroupCallRenderersContainer groupCallRenderersContainer2 = this.renderersContainer;
                    if (groupCallRenderersContainer2.inFullscreenMode && (videoParticipant = groupCallRenderersContainer2.fullscreenParticipant) != null && call2.participants.get(MessageObject.getPeerId(videoParticipant.participant.peer)) == null) {
                        zAutoPinEnabled = true;
                    }
                }
                if (zAutoPinEnabled) {
                    ChatObject.VideoParticipant videoParticipant2 = null;
                    for (int i9 = 0; i9 < this.visibleVideoParticipants.size(); i9++) {
                        ChatObject.VideoParticipant videoParticipant3 = this.visibleVideoParticipants.get(i9);
                        if (this.call.currentSpeakingPeers.get((long) MessageObject.getPeerId(videoParticipant3.participant.peer), null) != null) {
                            if (!videoParticipant3.participant.muted_by_you && this.renderersContainer.fullscreenPeerId != MessageObject.getPeerId(r0.peer)) {
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
        if (i == NotificationCenter.webRtcMicAmplitudeEvent) {
            setMicAmplitude(((Float) objArr[0]).floatValue());
            return;
        }
        if (i == NotificationCenter.needShowAlert) {
            if (((Integer) objArr[0]).intValue() == 6) {
                String str4 = (String) objArr[1];
                if ("GROUPCALL_PARTICIPANTS_TOO_MUCH".equals(str4)) {
                    if (ChatObject.isChannelOrGiga(this.currentChat)) {
                        string = LocaleController.getString("VoipChannelTooMuch", R.string.VoipChannelTooMuch);
                    } else {
                        string = LocaleController.getString("VoipGroupTooMuch", R.string.VoipGroupTooMuch);
                    }
                } else if (!"ANONYMOUS_CALLS_DISABLED".equals(str4) && !"GROUPCALL_ANONYMOUS_FORBIDDEN".equals(str4)) {
                    string = LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + str4;
                } else if (ChatObject.isChannelOrGiga(this.currentChat)) {
                    string = LocaleController.getString("VoipChannelJoinAnonymousAdmin", R.string.VoipChannelJoinAnonymousAdmin);
                } else {
                    string = LocaleController.getString("VoipGroupJoinAnonymousAdmin", R.string.VoipGroupJoinAnonymousAdmin);
                }
                AlertDialog.Builder builderCreateSimpleAlert = AlertsCreator.createSimpleAlert(getContext(), LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat), string);
                builderCreateSimpleAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda10
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$didReceivedNotification$3(dialogInterface);
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
        if (i == NotificationCenter.didEndCall) {
            if (VoIPService.getSharedInstance() == null) {
                dismiss();
                return;
            }
            return;
        }
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull.id == this.currentChat.id) {
                updateItems();
                updateState(isShowing(), false);
            }
            int peerId = MessageObject.getPeerId(this.selfPeer);
            ChatObject.Call call3 = this.call;
            if (call3 == null || tLRPC$ChatFull.id != (-peerId) || (tLRPC$TL_groupCallParticipant2 = call3.participants.get(peerId)) == null) {
                return;
            }
            tLRPC$TL_groupCallParticipant2.about = tLRPC$ChatFull.about;
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            if (this.currentOptionsLayout != null) {
                while (i7 < this.currentOptionsLayout.getChildCount()) {
                    View childAt2 = this.currentOptionsLayout.getChildAt(i7);
                    if ((childAt2 instanceof ActionBarMenuSubItem) && childAt2.getTag() != null && ((Integer) childAt2.getTag()).intValue() == 10) {
                        ActionBarMenuSubItem actionBarMenuSubItem = (ActionBarMenuSubItem) childAt2;
                        if (TextUtils.isEmpty(tLRPC$TL_groupCallParticipant2.about)) {
                            i4 = R.string.VoipAddDescription;
                            str2 = "VoipAddDescription";
                        } else {
                            i4 = R.string.VoipEditDescription;
                            str2 = "VoipEditDescription";
                        }
                        actionBarMenuSubItem.setTextAndIcon(LocaleController.getString(str2, i4), TextUtils.isEmpty(tLRPC$TL_groupCallParticipant2.about) ? R.drawable.msg_addbio : R.drawable.msg_info);
                    }
                    i7++;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.didLoadChatAdmins) {
            if (((Integer) objArr[0]).intValue() == this.currentChat.id) {
                updateItems();
                updateState(isShowing(), false);
                return;
            }
            return;
        }
        if (i == NotificationCenter.applyGroupCallVisibleParticipants) {
            int childCount2 = this.listView.getChildCount();
            long jLongValue2 = ((Long) objArr[0]).longValue();
            while (i7 < childCount2) {
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(this.listView.getChildAt(i7));
                if (viewHolderFindContainingViewHolder != null) {
                    View view = viewHolderFindContainingViewHolder.itemView;
                    if (view instanceof GroupCallUserCell) {
                        GroupCallUserCell groupCallUserCell = (GroupCallUserCell) view;
                        if (groupCallUserCell.getParticipant() != null) {
                            groupCallUserCell.getParticipant().lastVisibleDate = jLongValue2;
                        }
                    }
                }
                i7++;
            }
            return;
        }
        if (i == NotificationCenter.userInfoDidLoad) {
            Integer num = (Integer) objArr[0];
            int peerId2 = MessageObject.getPeerId(this.selfPeer);
            if (this.call == null || peerId2 != num.intValue() || (tLRPC$TL_groupCallParticipant = this.call.participants.get(peerId2)) == null) {
                return;
            }
            TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) objArr[1];
            tLRPC$TL_groupCallParticipant.about = tLRPC$UserFull != null ? tLRPC$UserFull.about : null;
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            if (this.currentOptionsLayout != null) {
                while (i7 < this.currentOptionsLayout.getChildCount()) {
                    View childAt3 = this.currentOptionsLayout.getChildAt(i7);
                    if ((childAt3 instanceof ActionBarMenuSubItem) && childAt3.getTag() != null && ((Integer) childAt3.getTag()).intValue() == 10) {
                        ActionBarMenuSubItem actionBarMenuSubItem2 = (ActionBarMenuSubItem) childAt3;
                        if (TextUtils.isEmpty(tLRPC$TL_groupCallParticipant.about)) {
                            i3 = R.string.VoipAddBio;
                            str = "VoipAddBio";
                        } else {
                            i3 = R.string.VoipEditBio;
                            str = "VoipEditBio";
                        }
                        actionBarMenuSubItem2.setTextAndIcon(LocaleController.getString(str, i3), TextUtils.isEmpty(tLRPC$TL_groupCallParticipant.about) ? R.drawable.msg_addbio : R.drawable.msg_info);
                    }
                    i7++;
                }
                return;
            }
            return;
        }
        if (i == NotificationCenter.mainUserInfoChanged) {
            applyCallParticipantUpdates(true);
            AndroidUtilities.updateVisibleRows(this.listView);
            return;
        }
        if (i == NotificationCenter.updateInterfaces) {
            int iIntValue = ((Integer) objArr[0]).intValue();
            int i10 = iIntValue & 16;
            if (i10 != 0) {
                applyCallParticipantUpdates(true);
            }
            if (i10 == 0 && (iIntValue & MessagesController.UPDATE_MASK_EMOJI_STATUS) == 0) {
                return;
            }
            AndroidUtilities.updateVisibleRows(this.listView);
            return;
        }
        if (i == NotificationCenter.groupCallScreencastStateChanged) {
            PrivateVideoPreviewDialog privateVideoPreviewDialog = this.previewDialog;
            if (privateVideoPreviewDialog != null) {
                privateVideoPreviewDialog.dismiss(true, true);
            }
            updateItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$2() {
        if (isStillConnecting()) {
            updateState(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didReceivedNotification$3(DialogInterface dialogInterface) {
        dismiss();
    }

    private void setMicAmplitude(float f) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition;
        if (VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().isMicMute()) {
            f = 0.0f;
        }
        setAmplitude(4000.0f * f);
        ChatObject.Call call = this.call;
        if (call == null || this.listView == null || (tLRPC$TL_groupCallParticipant = call.participants.get(MessageObject.getPeerId(this.selfPeer))) == null) {
            return;
        }
        if (!this.renderersContainer.inFullscreenMode) {
            int iIndexOf = (this.delayedGroupCallUpdated ? this.oldParticipants : this.call.visibleParticipants).indexOf(tLRPC$TL_groupCallParticipant);
            if (iIndexOf >= 0 && (viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(iIndexOf + this.listAdapter.usersStartRow)) != null) {
                View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                if (view instanceof GroupCallUserCell) {
                    ((GroupCallUserCell) view).setAmplitude(f * 15.0f);
                    if (viewHolderFindViewHolderForAdapterPosition.itemView == this.scrimView && !this.contentFullyOverlayed) {
                        this.containerView.invalidate();
                    }
                }
            }
        } else {
            for (int i = 0; i < this.fullscreenUsersListView.getChildCount(); i++) {
                GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) this.fullscreenUsersListView.getChildAt(i);
                if (MessageObject.getPeerId(groupCallUserCell.getParticipant().peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                    groupCallUserCell.setAmplitude(f * 15.0f);
                }
            }
        }
        this.renderersContainer.setAmplitude(tLRPC$TL_groupCallParticipant, f * 15.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020e A[LOOP:2: B:96:0x0206->B:98:0x020e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void applyCallParticipantUpdates(boolean r19) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.applyCallParticipantUpdates(boolean):void");
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
    public void updateItems() {
        int i;
        String str;
        TLObject chat;
        TLRPC$Chat tLRPC$Chat;
        ChatObject.Call call = this.call;
        if (call == null || call.isScheduled()) {
            this.pipItem.setVisibility(4);
            this.screenShareItem.setVisibility(8);
            if (this.call == null) {
                this.otherItem.setVisibility(8);
                return;
            }
        }
        if (this.changingPermissions) {
            return;
        }
        TLRPC$Chat chat2 = this.accountInstance.getMessagesController().getChat(Integer.valueOf(this.currentChat.id));
        if (chat2 != null) {
            if (chat2.accessEnumHashSet == null) {
                chat2.accessEnumHashSet = this.accountInstance.getDialogsProxy().getAccessSet(chat2.id);
            }
            this.currentChat = chat2;
        }
        this.inviteItem.setVisibility(8);
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.participants.get(MessageObject.getPeerId(this.selfPeer));
        ChatObject.Call call2 = this.call;
        if (call2 == null || call2.isScheduled() || (tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted)) {
            this.noiseItem.setVisibility(8);
        } else {
            this.noiseItem.setVisibility(0);
        }
        this.noiseItem.setIcon(SharedConfig.noiseSupression ? R.drawable.msg_noise_on : R.drawable.msg_noise_off);
        ActionBarMenuSubItem actionBarMenuSubItem = this.noiseItem;
        if (SharedConfig.noiseSupression) {
            i = R.string.VoipNoiseCancellationEnabled;
            str = "VoipNoiseCancellationEnabled";
        } else {
            i = R.string.VoipNoiseCancellationDisabled;
            str = "VoipNoiseCancellationDisabled";
        }
        actionBarMenuSubItem.setSubtext(LocaleController.getString(str, i));
        if (ChatObject.canManageCalls(this.currentChat)) {
            this.leaveItem.setVisibility(0);
            this.editTitleItem.setVisibility(0);
            if (isRtmpStream()) {
                this.recordItem.setVisibility(0);
                this.screenItem.setVisibility(8);
            } else if (this.call.isScheduled()) {
                this.recordItem.setVisibility(8);
                this.screenItem.setVisibility(8);
            } else {
                this.recordItem.setVisibility(8);
            }
            if (!this.call.canRecordVideo() || this.call.isScheduled() || Build.VERSION.SDK_INT < 21 || isRtmpStream()) {
                this.screenItem.setVisibility(8);
            } else {
                this.screenItem.setVisibility(0);
            }
            this.screenShareItem.setVisibility(8);
            this.recordCallDrawable.setRecording(this.call.recording);
            if (this.call.recording) {
                if (this.updateCallRecordRunnable == null) {
                    Runnable runnable = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda36
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$updateItems$4();
                        }
                    };
                    this.updateCallRecordRunnable = runnable;
                    AndroidUtilities.runOnUIThread(runnable, 1000L);
                }
                this.recordItem.setText(LocaleController.getString("VoipGroupStopRecordCall", R.string.VoipGroupStopRecordCall));
            } else {
                Runnable runnable2 = this.updateCallRecordRunnable;
                if (runnable2 != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable2);
                    this.updateCallRecordRunnable = null;
                }
                this.recordItem.setText(LocaleController.getString("VoipGroupRecordCall", R.string.VoipGroupRecordCall));
            }
            if (VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().getVideoState(true) == 2) {
                this.screenItem.setTextAndIcon(LocaleController.getString("VoipChatStopScreenCapture", R.string.VoipChatStopScreenCapture), R.drawable.msg_screencast_off);
            } else {
                this.screenItem.setTextAndIcon(LocaleController.getString("VoipChatStartScreenCapture", R.string.VoipChatStartScreenCapture), R.drawable.msg_screencast);
            }
            updateRecordCallText();
        } else {
            boolean z = (tLRPC$TL_groupCallParticipant == null || tLRPC$TL_groupCallParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipant.muted || ChatObject.canManageCalls(this.currentChat)) ? false : true;
            boolean z2 = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().getVideoState(true) == 2;
            if (Build.VERSION.SDK_INT < 21 || z || (!(this.call.canRecordVideo() || z2) || this.call.isScheduled() || isRtmpStream())) {
                this.screenShareItem.setVisibility(8);
                this.screenItem.setVisibility(8);
            } else if (z2) {
                this.screenShareItem.setVisibility(8);
                this.screenItem.setVisibility(0);
                this.screenItem.setTextAndIcon(LocaleController.getString("VoipChatStopScreenCapture", R.string.VoipChatStopScreenCapture), R.drawable.msg_screencast_off);
                this.screenItem.setContentDescription(LocaleController.getString("VoipChatStopScreenCapture", R.string.VoipChatStopScreenCapture));
            } else {
                this.screenItem.setTextAndIcon(LocaleController.getString("VoipChatStartScreenCapture", R.string.VoipChatStartScreenCapture), R.drawable.msg_screencast);
                this.screenItem.setContentDescription(LocaleController.getString("VoipChatStartScreenCapture", R.string.VoipChatStartScreenCapture));
                this.screenShareItem.setVisibility(8);
                this.screenItem.setVisibility(0);
            }
            this.leaveItem.setVisibility(8);
            this.editTitleItem.setVisibility(8);
            this.recordItem.setVisibility(8);
        }
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.call.participants.get(UserConfig.getInstance(this.currentAccount).getClientUserId());
        if (ChatObject.canManageCalls(this.currentChat) && ((tLRPC$TL_groupCallParticipant2 == null || tLRPC$TL_groupCallParticipant2.canManageCallVoiceChat) && (tLRPC$Chat = this.currentChat) != null && tLRPC$Chat.megagroup)) {
            this.permissionItem.setVisibility(0);
        } else {
            this.permissionItem.setVisibility(8);
        }
        this.soundItem.setVisibility(isRtmpStream() ? 8 : 0);
        if (this.editTitleItem.getVisibility() == 0 || this.permissionItem.getVisibility() == 0 || this.inviteItem.getVisibility() == 0 || this.screenItem.getVisibility() == 0 || this.recordItem.getVisibility() == 0 || this.leaveItem.getVisibility() == 0) {
            this.soundItemDivider.setVisibility(0);
        } else {
            this.soundItemDivider.setVisibility(8);
        }
        if (((VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().hasFewPeers) || this.scheduleHasFewPeers) && !isRtmpStream()) {
            this.accountSelectCell.setVisibility(0);
            this.accountGap.setVisibility(0);
            long peerId = MessageObject.getPeerId(this.selfPeer);
            if (DialogObject.isUserDialog(peerId)) {
                chat = this.accountInstance.getMessagesController().getUser(Long.valueOf(peerId));
            } else {
                chat = this.accountInstance.getMessagesController().getChat(Long.valueOf(-peerId));
            }
            this.accountSelectCell.setObject(chat);
        } else {
            this.accountSelectCell.setVisibility(8);
            this.accountGap.setVisibility(8);
        }
        TLRPC$Chat tLRPC$Chat2 = this.currentChat;
        if (tLRPC$Chat2 != null && !ChatObject.isChannelOrGiga(tLRPC$Chat2) && isRtmpStream() && this.inviteItem.getVisibility() == 8) {
            this.otherItem.setVisibility(8);
        } else {
            this.otherItem.setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.titleTextView.getLayoutParams();
        if (LocaleController.isRTL) {
            float f = 96;
            if (layoutParams.leftMargin != AndroidUtilities.dp(f)) {
                layoutParams.leftMargin = AndroidUtilities.dp(f);
                this.titleTextView.requestLayout();
            }
        } else {
            float f2 = 96;
            if (layoutParams.rightMargin != AndroidUtilities.dp(f2)) {
                layoutParams.rightMargin = AndroidUtilities.dp(f2);
                this.titleTextView.requestLayout();
            }
        }
        if (LocaleController.isRTL) {
            ((FrameLayout.LayoutParams) this.menuItemsContainer.getLayoutParams()).leftMargin = 0;
        } else {
            ((FrameLayout.LayoutParams) this.menuItemsContainer.getLayoutParams()).rightMargin = 0;
        }
        this.actionBar.setTitleRightMargin(AndroidUtilities.dp(48.0f) * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateItems$4() {
        updateRecordCallText();
        AndroidUtilities.runOnUIThread(this.updateCallRecordRunnable, 1000L);
    }

    protected void makeFocusable(final BottomSheet bottomSheet, final AlertDialog alertDialog, final EditTextBoldCursor editTextBoldCursor, final boolean z) throws Resources.NotFoundException {
        if (this.enterEventSent) {
            return;
        }
        BaseFragment baseFragment = this.parentActivity.getActionBarLayout().getFragmentStack().get(this.parentActivity.getActionBarLayout().getFragmentStack().size() - 1);
        if (baseFragment instanceof ChatActivity) {
            boolean zNeedEnterText = ((ChatActivity) baseFragment).needEnterText();
            this.enterEventSent = true;
            this.anyEnterEventSent = true;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda27
                @Override // java.lang.Runnable
                public final void run() {
                    GroupCallActivity.lambda$makeFocusable$7(bottomSheet, editTextBoldCursor, z, alertDialog);
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
        if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    GroupCallActivity.lambda$makeFocusable$8(editTextBoldCursor);
                }
            }, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeFocusable$7(BottomSheet bottomSheet, final EditTextBoldCursor editTextBoldCursor, boolean z, AlertDialog alertDialog) {
        if (bottomSheet != null && !bottomSheet.isDismissed()) {
            bottomSheet.setFocusable(true);
            editTextBoldCursor.requestFocus();
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda29
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidUtilities.showKeyboard(editTextBoldCursor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeFocusable$8(EditTextBoldCursor editTextBoldCursor) {
        editTextBoldCursor.requestFocus();
        AndroidUtilities.showKeyboard(editTextBoldCursor);
    }

    public static void create(LaunchActivity launchActivity, AccountInstance accountInstance, TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, boolean z, String str) {
        TLRPC$Chat chat;
        if (groupCallInstance == null) {
            if (tLRPC$InputPeer == null && VoIPService.getSharedInstance() == null) {
                return;
            }
            if (tLRPC$InputPeer != null) {
                groupCallInstance = new GroupCallActivity(launchActivity, accountInstance, accountInstance.getMessagesController().getGroupCall(tLRPC$Chat.id, false), tLRPC$Chat, tLRPC$InputPeer, z, str);
            } else {
                ChatObject.Call call = VoIPService.getSharedInstance().groupCall;
                if (call == null || (chat = accountInstance.getMessagesController().getChat(Integer.valueOf(call.chatId))) == null) {
                    return;
                }
                call.addSelfDummyParticipant(true);
                groupCallInstance = new GroupCallActivity(launchActivity, accountInstance, call, chat, null, z, str);
            }
            groupCallInstance.parentActivity = launchActivity;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    GroupCallActivity.lambda$create$9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$9() {
        GroupCallActivity groupCallActivity = groupCallInstance;
        if (groupCallActivity != null) {
            groupCallActivity.show();
        }
    }

    private GroupCallActivity(final Context context, final AccountInstance accountInstance, ChatObject.Call call, final TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, boolean z, String str) {
        int i;
        String str2;
        int i2;
        String str3;
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
        this.animatingToFullscreenExpand = false;
        this.paint = new Paint(7);
        this.paintTmp = new Paint(7);
        this.leaveBackgroundPaint = new Paint(1);
        this.states = new WeavingState[8];
        this.switchProgress = 1.0f;
        this.invalidateColors = true;
        this.colorsTmp = new int[3];
        this.attachedRenderers = new ArrayList<>();
        this.attachedRenderersTmp = new ArrayList<>();
        this.wasExpandBigSize = Boolean.TRUE;
        this.cellFlickerDrawable = new CellFlickerDrawable();
        this.statusIconPool = new ArrayList<>();
        this.buttonsAnimationParamsX = new HashMap<>();
        this.buttonsAnimationParamsY = new HashMap<>();
        this.onUserLeaveHintListener = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onUserLeaveHint();
            }
        };
        this.updateSchedeulRunnable = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity.1
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (GroupCallActivity.this.scheduleTimeTextView == null || GroupCallActivity.this.isDismissed()) {
                    return;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                ChatObject.Call call2 = groupCallActivity.call;
                if (call2 == null) {
                    i3 = groupCallActivity.scheduleStartAt;
                } else {
                    i3 = call2.call.schedule_date;
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
        this.unmuteRunnable = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                GroupCallActivity.lambda$new$0();
            }
        };
        this.pressRunnable = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1();
            }
        };
        this.visiblePeerIds = new LongSparseIntArray();
        this.gradientColors = new int[2];
        this.listViewVideoVisibility = true;
        this.rtlLayout = true;
        this.popupAnimationIndex = -1;
        this.diffUtilsCallback = new DiffUtil.Callback() { // from class: org.rbmain.ui.GroupCallActivity.58
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i3, int i4) {
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
            public boolean areItemsTheSame(int i3, int i4) {
                if (GroupCallActivity.this.listAdapter.addMemberRow >= 0) {
                    if (i3 == GroupCallActivity.this.oldAddMemberRow && i4 == GroupCallActivity.this.listAdapter.addMemberRow) {
                        return true;
                    }
                    if ((i3 == GroupCallActivity.this.oldAddMemberRow && i4 != GroupCallActivity.this.listAdapter.addMemberRow) || (i3 != GroupCallActivity.this.oldAddMemberRow && i4 == GroupCallActivity.this.listAdapter.addMemberRow)) {
                        return false;
                    }
                }
                if (GroupCallActivity.this.listAdapter.videoNotAvailableRow >= 0) {
                    if (i3 == GroupCallActivity.this.oldVideoNotAvailableRow && i4 == GroupCallActivity.this.listAdapter.videoNotAvailableRow) {
                        return true;
                    }
                    if ((i3 == GroupCallActivity.this.oldVideoNotAvailableRow && i4 != GroupCallActivity.this.listAdapter.videoNotAvailableRow) || (i3 != GroupCallActivity.this.oldVideoNotAvailableRow && i4 == GroupCallActivity.this.listAdapter.videoNotAvailableRow)) {
                        return false;
                    }
                }
                if (GroupCallActivity.this.listAdapter.videoGridDividerRow >= 0 && GroupCallActivity.this.listAdapter.videoGridDividerRow == i4 && i3 == GroupCallActivity.this.oldVideoDividerRow) {
                    return true;
                }
                if (i3 == GroupCallActivity.this.oldCount - 1 && i4 == GroupCallActivity.this.listAdapter.rowsCount - 1) {
                    return true;
                }
                if (i3 != GroupCallActivity.this.oldCount - 1 && i4 != GroupCallActivity.this.listAdapter.rowsCount - 1) {
                    if (i4 >= GroupCallActivity.this.listAdapter.usersVideoGridStartRow && i4 < GroupCallActivity.this.listAdapter.usersVideoGridEndRow && i3 >= GroupCallActivity.this.oldUsersVideoStartRow && i3 < GroupCallActivity.this.oldUsersVideoEndRow) {
                        ChatObject.VideoParticipant videoParticipant = (ChatObject.VideoParticipant) GroupCallActivity.this.oldVideoParticipants.get(i3 - GroupCallActivity.this.oldUsersVideoStartRow);
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        return videoParticipant.equals(groupCallActivity.visibleVideoParticipants.get(i4 - groupCallActivity.listAdapter.usersVideoGridStartRow));
                    }
                    if (i4 >= GroupCallActivity.this.listAdapter.usersStartRow && i4 < GroupCallActivity.this.listAdapter.usersEndRow && i3 >= GroupCallActivity.this.oldUsersStartRow && i3 < GroupCallActivity.this.oldUsersEndRow) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = (TLRPC$TL_groupCallParticipant) GroupCallActivity.this.oldParticipants.get(i3 - GroupCallActivity.this.oldUsersStartRow);
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == MessageObject.getPeerId(groupCallActivity2.call.visibleParticipants.get(i4 - groupCallActivity2.listAdapter.usersStartRow).peer)) {
                            return i3 == i4 || tLRPC$TL_groupCallParticipant.lastActiveDate == ((long) tLRPC$TL_groupCallParticipant.active_date);
                        }
                        return false;
                    }
                    if (i4 >= GroupCallActivity.this.listAdapter.invitedStartRow && i4 < GroupCallActivity.this.listAdapter.invitedEndRow && i3 >= GroupCallActivity.this.oldInvitedStartRow && i3 < GroupCallActivity.this.oldInvitedEndRow) {
                        Integer num = (Integer) GroupCallActivity.this.oldInvited.get(i3 - GroupCallActivity.this.oldInvitedStartRow);
                        GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                        return num.equals(groupCallActivity3.call.invitedUsers.get(i4 - groupCallActivity3.listAdapter.invitedStartRow));
                    }
                }
                return false;
            }
        };
        FirebaseCrashlytics.getInstance().setCustomKey("fragmentName", "GroupCallActivity");
        setOpenNoDelay(true);
        this.accountInstance = accountInstance;
        this.call = call;
        this.schedulePeer = tLRPC$InputPeer;
        this.currentChat = tLRPC$Chat;
        this.scheduledHash = str;
        this.currentAccount = accountInstance.getCurrentAccount();
        this.scheduleHasFewPeers = z;
        this.fullWidth = true;
        isTabletMode = false;
        isLandscapeMode = false;
        paused = false;
        setDelegate(new BottomSheet.BottomSheetDelegateInterface() { // from class: org.rbmain.ui.GroupCallActivity.3
            @Override // org.rbmain.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            public boolean canDismiss() {
                return true;
            }

            @Override // org.rbmain.ui.ActionBar.BottomSheet.BottomSheetDelegateInterface
            public void onOpenAnimationEnd() {
                CountDownLatch groupCallBottomSheetLatch;
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance != null && (groupCallBottomSheetLatch = sharedInstance.getGroupCallBottomSheetLatch()) != null) {
                    groupCallBottomSheetLatch.countDown();
                }
                if (GroupCallActivity.this.muteButtonState == 6) {
                    GroupCallActivity.this.showReminderHint();
                }
            }
        });
        this.drawDoubleNavigationBar = true;
        this.drawNavigationBar = true;
        if (Build.VERSION.SDK_INT >= 30) {
            getWindow().setNavigationBarColor(-16777216);
        }
        this.scrollNavBar = true;
        this.navBarColorKey = -1;
        this.scrimPaint = new Paint() { // from class: org.rbmain.ui.GroupCallActivity.4
            @Override // android.graphics.Paint
            public void setAlpha(int i3) {
                super.setAlpha(i3);
                if (((BottomSheet) GroupCallActivity.this).containerView != null) {
                    ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                }
            }
        };
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$new$10(dialogInterface);
            }
        });
        setDimBehindAlpha(75);
        this.listAdapter = new ListAdapter(context);
        final RecordStatusDrawable recordStatusDrawable = new RecordStatusDrawable(true);
        int i3 = Theme.key_voipgroup_speakingText;
        recordStatusDrawable.setColor(Theme.getColor(i3));
        recordStatusDrawable.start();
        ActionBar actionBar = new ActionBar(context) { // from class: org.rbmain.ui.GroupCallActivity.5
            @Override // android.view.View
            public void setAlpha(float f) {
                if (getAlpha() != f) {
                    super.setAlpha(f);
                    ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                }
            }

            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.ViewGroup, android.view.View
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
        actionBar.setSubtitle(BuildConfig.FLAVOR);
        this.actionBar.getSubtitleTextView().setVisibility(0);
        this.actionBar.createAdditionalSubtitleTextView();
        this.actionBar.getAdditionalSubtitleTextView().setPadding(AndroidUtilities.dp(24.0f), 0, 0, 0);
        AndroidUtilities.updateViewVisibilityAnimated(this.actionBar.getAdditionalSubtitleTextView(), this.drawSpeakingSubtitle, 1.0f, false);
        this.actionBar.getAdditionalSubtitleTextView().setTextColor(Theme.getColor(i3));
        ActionBar actionBar2 = this.actionBar;
        int i4 = Theme.key_voipgroup_lastSeenTextUnscrolled;
        actionBar2.setSubtitleColor(Theme.getColor(i4));
        this.actionBar.setRtlLayout(this.rtlLayout);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setOccupyStatusBar(false);
        this.actionBar.setAllowOverlayTitle(false);
        ActionBar actionBar3 = this.actionBar;
        int i5 = Theme.key_voipgroup_actionBarItems;
        actionBar3.setItemsColor(Theme.getColor(i5), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarActionModeDefaultSelector), false);
        this.actionBar.setTitleColor(Theme.getColor(i5));
        this.actionBar.setSubtitleColor(Theme.getColor(i4));
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass6(context));
        TLRPC$InputPeer groupCallPeer = tLRPC$InputPeer != null ? tLRPC$InputPeer : VoIPService.getSharedInstance().getGroupCallPeer();
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
        VoIPService.audioLevelsCallback = new NativeInstance.AudioLevelsCallback() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda49
            @Override // org.rbmain.messenger.voip.NativeInstance.AudioLevelsCallback
            public final void run(int[] iArr, float[] fArr, boolean[] zArr) {
                this.f$0.lambda$new$11(iArr, fArr, zArr);
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
        this.bigMicDrawable = new RLottieDrawable(R.raw.voip_filled, "2131820695", AndroidUtilities.dp(72.0f), AndroidUtilities.dp(72.0f), true, null);
        this.handDrawables = new RLottieDrawable(R.raw.hand_2, "2131820592", AndroidUtilities.dp(72.0f), AndroidUtilities.dp(72.0f), true, null);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.GroupCallActivity.7
            private int lastSize;
            boolean localHasVideo;
            private boolean updateRenderers;
            boolean wasLayout;
            private boolean ignoreLayout = false;
            private RectF rect = new RectF();
            HashMap<Object, View> listCells = new HashMap<>();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i6, int i7) {
                int iDp;
                int size = View.MeasureSpec.getSize(i7);
                this.ignoreLayout = true;
                boolean z2 = View.MeasureSpec.getSize(i6) > size && !AndroidUtilities.isTablet();
                GroupCallActivity.this.renderersContainer.listWidth = View.MeasureSpec.getSize(i6);
                boolean z3 = AndroidUtilities.isTablet() && View.MeasureSpec.getSize(i6) > size && !GroupCallActivity.this.isRtmpStream();
                if (GroupCallActivity.isLandscapeMode != z2) {
                    GroupCallActivity.isLandscapeMode = z2;
                    int measuredWidth = GroupCallActivity.this.muteButton.getMeasuredWidth();
                    if (measuredWidth == 0) {
                        measuredWidth = GroupCallActivity.this.muteButton.getLayoutParams().width;
                    }
                    float fDp = AndroidUtilities.dp(52.0f) / (measuredWidth - AndroidUtilities.dp(8.0f));
                    if (!GroupCallActivity.isLandscapeMode && !GroupCallActivity.this.renderersContainer.inFullscreenMode) {
                        fDp = 1.0f;
                    }
                    boolean z4 = GroupCallActivity.this.renderersContainer.inFullscreenMode && (AndroidUtilities.isTablet() || GroupCallActivity.isLandscapeMode == GroupCallActivity.this.isRtmpLandscapeMode());
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    ImageView imageView = z4 ? groupCallActivity.minimizeButton : groupCallActivity.expandButton;
                    ImageView imageView2 = z4 ? GroupCallActivity.this.expandButton : GroupCallActivity.this.minimizeButton;
                    imageView.setAlpha(1.0f);
                    imageView.setScaleX(fDp);
                    imageView.setScaleY(fDp);
                    imageView2.setAlpha(0.0f);
                    GroupCallActivity.this.muteLabel[0].setAlpha(1.0f);
                    GroupCallActivity.this.muteLabel[1].setAlpha(1.0f);
                    if (GroupCallActivity.this.renderersContainer.inFullscreenMode || (GroupCallActivity.isLandscapeMode && !AndroidUtilities.isTablet())) {
                        GroupCallActivity.this.muteLabel[0].setScaleX(0.687f);
                        GroupCallActivity.this.muteLabel[1].setScaleY(0.687f);
                    } else {
                        GroupCallActivity.this.muteLabel[0].setScaleX(1.0f);
                        GroupCallActivity.this.muteLabel[1].setScaleY(1.0f);
                    }
                    GroupCallActivity.this.invalidateLayoutFullscreen();
                    GroupCallActivity.this.layoutManager.setSpanCount(GroupCallActivity.isLandscapeMode ? 6 : 2);
                    GroupCallActivity.this.listView.invalidateItemDecorations();
                    GroupCallActivity.this.fullscreenUsersListView.invalidateItemDecorations();
                    this.updateRenderers = true;
                    if (GroupCallActivity.this.scheduleInfoTextView != null) {
                        GroupCallActivity.this.scheduleInfoTextView.setVisibility(!GroupCallActivity.isLandscapeMode ? 0 : 8);
                    }
                    if ((GroupCallActivity.this.isRtmpLandscapeMode() == z2) && GroupCallActivity.this.isRtmpStream() && !GroupCallActivity.this.renderersContainer.inFullscreenMode && !GroupCallActivity.this.call.visibleVideoParticipants.isEmpty()) {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        groupCallActivity2.fullscreenFor(groupCallActivity2.call.visibleVideoParticipants.get(0));
                        GroupCallActivity.this.renderersContainer.delayHideUi();
                    }
                }
                if (GroupCallActivity.isTabletMode != z3) {
                    GroupCallActivity.isTabletMode = z3;
                    GroupCallActivity.this.tabletVideoGridView.setVisibility(z3 ? 0 : 8);
                    GroupCallActivity.this.listView.invalidateItemDecorations();
                    GroupCallActivity.this.fullscreenUsersListView.invalidateItemDecorations();
                    this.updateRenderers = true;
                }
                if (this.updateRenderers) {
                    GroupCallActivity.this.applyCallParticipantUpdates(true);
                    GroupCallActivity.this.listAdapter.notifyDataSetChanged();
                    GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                    groupCallActivity3.fullscreenAdapter.update(false, groupCallActivity3.tabletVideoGridView);
                    if (GroupCallActivity.isTabletMode) {
                        GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                        groupCallActivity4.tabletGridAdapter.update(false, groupCallActivity4.tabletVideoGridView);
                    }
                    GroupCallActivity.this.tabletVideoGridView.setVisibility(GroupCallActivity.isTabletMode ? 0 : 8);
                    GroupCallActivity groupCallActivity5 = GroupCallActivity.this;
                    groupCallActivity5.tabletGridAdapter.setVisibility(groupCallActivity5.tabletVideoGridView, GroupCallActivity.isTabletMode && !groupCallActivity5.renderersContainer.inFullscreenMode, true);
                    GroupCallActivity groupCallActivity6 = GroupCallActivity.this;
                    groupCallActivity6.listViewVideoVisibility = !GroupCallActivity.isTabletMode || groupCallActivity6.renderersContainer.inFullscreenMode;
                    boolean z5 = !GroupCallActivity.isTabletMode && GroupCallActivity.this.renderersContainer.inFullscreenMode;
                    GroupCallActivity groupCallActivity7 = GroupCallActivity.this;
                    groupCallActivity7.fullscreenAdapter.setVisibility(groupCallActivity7.fullscreenUsersListView, z5);
                    GroupCallActivity.this.fullscreenUsersListView.setVisibility(z5 ? 0 : 8);
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
                    for (int i8 = 0; i8 < GroupCallActivity.this.attachedRenderersTmp.size(); i8++) {
                        ((GroupCallMiniTextureView) GroupCallActivity.this.attachedRenderersTmp.get(i8)).updateAttachState(true);
                    }
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    setPadding(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, GroupCallActivity.this.getStatusBarHeight(), ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0);
                }
                int paddingTop = (size - getPaddingTop()) - AndroidUtilities.dp(245.0f);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) GroupCallActivity.this.renderersContainer.getLayoutParams();
                if (GroupCallActivity.isTabletMode) {
                    layoutParams.topMargin = ActionBar.getCurrentActionBarHeight();
                } else {
                    layoutParams.topMargin = 0;
                }
                for (int i9 = 0; i9 < 2; i9++) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) GroupCallActivity.this.undoView[i9].getLayoutParams();
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
                for (int i10 = 0; i10 < GroupCallActivity.this.attachedRenderers.size(); i10++) {
                    ((GroupCallMiniTextureView) GroupCallActivity.this.attachedRenderers.get(i10)).setFullscreenMode(GroupCallActivity.this.renderersContainer.inFullscreenMode, true);
                }
                this.ignoreLayout = false;
                super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
                int measuredHeight = getMeasuredHeight() + (getMeasuredWidth() << 16);
                if (measuredHeight != this.lastSize) {
                    this.lastSize = measuredHeight;
                    GroupCallActivity.this.dismissAvatarPreview(false);
                }
                GroupCallActivity.this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z2, int i6, int i7, int i8, int i9) {
                float x;
                boolean z3;
                if (GroupCallActivity.isTabletMode && this.localHasVideo != GroupCallActivity.this.hasVideo && this.wasLayout) {
                    x = GroupCallActivity.this.listView.getX();
                    z3 = true;
                } else {
                    x = 0.0f;
                    z3 = false;
                }
                this.localHasVideo = GroupCallActivity.this.hasVideo;
                GroupCallActivity.this.renderersContainer.inLayout = true;
                super.onLayout(z2, i6, i7, i8, i9);
                GroupCallActivity.this.renderersContainer.inLayout = false;
                GroupCallActivity.this.updateLayout(false);
                this.wasLayout = true;
                if (!z3 || GroupCallActivity.this.listView.getLeft() == x) {
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
                GroupCallActivity.this.buttonsBackgroundGradientView.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.buttonsBackgroundGradientView2.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
                GroupCallActivity.this.buttonsContainer.animate().translationX(0.0f).setDuration(350L).setInterpolator(cubicBezierInterpolator).start();
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (GroupCallActivity.this.scrimView != null && motionEvent.getAction() == 0) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.rect.set(GroupCallActivity.this.scrimPopupLayout.getX(), GroupCallActivity.this.scrimPopupLayout.getY(), GroupCallActivity.this.scrimPopupLayout.getX() + GroupCallActivity.this.scrimPopupLayout.getMeasuredWidth(), GroupCallActivity.this.scrimPopupLayout.getY() + GroupCallActivity.this.scrimPopupLayout.getMeasuredHeight());
                    boolean z2 = !this.rect.contains(x, y);
                    this.rect.set(GroupCallActivity.this.avatarPreviewContainer.getX(), GroupCallActivity.this.avatarPreviewContainer.getY(), GroupCallActivity.this.avatarPreviewContainer.getX() + GroupCallActivity.this.avatarPreviewContainer.getMeasuredWidth(), GroupCallActivity.this.avatarPreviewContainer.getY() + GroupCallActivity.this.avatarPreviewContainer.getMeasuredWidth() + GroupCallActivity.this.scrimView.getMeasuredHeight());
                    if (this.rect.contains(x, y)) {
                        z2 = false;
                    }
                    if (z2) {
                        GroupCallActivity.this.dismissAvatarPreview(true);
                        return true;
                    }
                }
                if (motionEvent.getAction() == 0 && GroupCallActivity.this.scrollOffsetY != 0.0f && motionEvent.getY() < GroupCallActivity.this.scrollOffsetY - AndroidUtilities.dp(37.0f) && GroupCallActivity.this.actionBar.getAlpha() == 0.0f && !GroupCallActivity.this.avatarsPreviewShowed) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    if (groupCallActivity.previewDialog == null && !groupCallActivity.renderersContainer.inFullscreenMode) {
                        GroupCallActivity.this.dismiss();
                        return true;
                    }
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !GroupCallActivity.this.isDismissed() && super.onTouchEvent(motionEvent);
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
                    canvas.drawRect(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, GroupCallActivity.this.getStatusBarHeight(), Theme.dialogs_onlineCirclePaint);
                    PrivateVideoPreviewDialog privateVideoPreviewDialog = GroupCallActivity.this.previewDialog;
                    if (privateVideoPreviewDialog != null) {
                        Theme.dialogs_onlineCirclePaint.setColor(privateVideoPreviewDialog.getBackgroundColor());
                        canvas.drawRect(((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, 0.0f, getMeasuredWidth() - ((BottomSheet) GroupCallActivity.this).backgroundPaddingLeft, GroupCallActivity.this.getStatusBarHeight(), Theme.dialogs_onlineCirclePaint);
                    }
                }
                if (GroupCallActivity.this.renderersContainer.progressToFullscreenMode != 0.0f) {
                    Theme.dialogs_onlineCirclePaint.setColor(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_voipgroup_actionBar), (int) (GroupCallActivity.this.renderersContainer.progressToFullscreenMode * 255.0f)));
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
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.AnonymousClass7.dispatchDraw(android.graphics.Canvas):void");
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                if (!GroupCallActivity.isTabletMode && GroupCallActivity.this.renderersContainer.progressToFullscreenMode == 1.0f && (view == GroupCallActivity.this.actionBar || view == GroupCallActivity.this.actionBarShadow || view == GroupCallActivity.this.actionBarBackground || view == GroupCallActivity.this.titleTextView || view == GroupCallActivity.this.menuItemsContainer)) {
                    return true;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                if (!groupCallActivity.drawingForBlur || view != groupCallActivity.renderersContainer) {
                    if (view == GroupCallActivity.this.avatarPreviewContainer || view == GroupCallActivity.this.scrimPopupLayout || view == GroupCallActivity.this.scrimView) {
                        return true;
                    }
                    if (GroupCallActivity.this.contentFullyOverlayed && GroupCallActivity.this.useBlur && (view == GroupCallActivity.this.listView || view == GroupCallActivity.this.buttonsContainer)) {
                        return true;
                    }
                    if (GroupCallActivity.this.scrimFullscreenView == null) {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        if (!groupCallActivity2.drawingForBlur && groupCallActivity2.avatarsPreviewShowed && (view == GroupCallActivity.this.buttonsBackgroundGradientView2 || view == GroupCallActivity.this.buttonsBackgroundGradientView || view == GroupCallActivity.this.buttonsContainer || view == GroupCallActivity.this.undoView[0] || view == GroupCallActivity.this.undoView[1])) {
                            return true;
                        }
                    }
                    return super.drawChild(canvas, view, j);
                }
                canvas.save();
                canvas.translate(GroupCallActivity.this.renderersContainer.getX() + GroupCallActivity.this.fullscreenUsersListView.getX(), GroupCallActivity.this.renderersContainer.getY() + GroupCallActivity.this.fullscreenUsersListView.getY());
                GroupCallActivity.this.fullscreenUsersListView.draw(canvas);
                canvas.restore();
                return true;
            }

            @Override // android.view.View, android.view.KeyEvent.Callback
            public boolean onKeyDown(int i6, KeyEvent keyEvent) {
                if (GroupCallActivity.this.scrimView != null && i6 == 4) {
                    GroupCallActivity.this.dismissAvatarPreview(true);
                    return true;
                }
                return super.onKeyDown(i6, keyEvent);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setFocusable(true);
        this.containerView.setFocusableInTouchMode(true);
        this.containerView.setWillNotDraw(false);
        ViewGroup viewGroup2 = this.containerView;
        int i6 = this.backgroundPaddingLeft;
        viewGroup2.setPadding(i6, 0, i6, 0);
        this.containerView.setKeepScreenOn(true);
        this.containerView.setClipChildren(false);
        if (tLRPC$InputPeer != null) {
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.scheduleStartInTextView = simpleTextView;
            simpleTextView.setGravity(17);
            this.scheduleStartInTextView.setTextColor(-1);
            this.scheduleStartInTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.scheduleStartInTextView.setTextSize(18);
            this.scheduleStartInTextView.setText(LocaleController.getString("VoipChatStartsIn", R.string.VoipChatStartsIn));
            this.containerView.addView(this.scheduleStartInTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 311.0f));
            SimpleTextView simpleTextView2 = new SimpleTextView(context) { // from class: org.rbmain.ui.GroupCallActivity.8
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

                @Override // org.rbmain.ui.ActionBar.SimpleTextView
                protected boolean createLayout(int i7) {
                    boolean zCreateLayout = super.createLayout(i7);
                    int textWidth = getTextWidth();
                    if (textWidth != this.lastTextWidth) {
                        float f = textWidth;
                        this.gradientWidth = 1.3f * f;
                        int i8 = Theme.key_voipgroup_mutedByAdminGradient2;
                        this.linearGradient = new LinearGradient(0.0f, getTextHeight(), f * 2.0f, 0.0f, new int[]{Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient), Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient3), Theme.getColor(i8), Theme.getColor(i8)}, new float[]{0.0f, 0.38f, 0.76f, 1.0f}, Shader.TileMode.CLAMP);
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
                @Override // org.rbmain.ui.ActionBar.SimpleTextView, android.view.View
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                protected void onDraw(android.graphics.Canvas r9) {
                    /*
                        Method dump skipped, instructions count: 230
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.AnonymousClass8.onDraw(android.graphics.Canvas):void");
                }
            };
            this.scheduleTimeTextView = simpleTextView2;
            simpleTextView2.setGravity(17);
            this.scheduleTimeTextView.setTextColor(-1);
            this.scheduleTimeTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.scheduleTimeTextView.setTextSize(60);
            this.containerView.addView(this.scheduleTimeTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 231.0f));
            SimpleTextView simpleTextView3 = new SimpleTextView(context);
            this.scheduleStartAtTextView = simpleTextView3;
            simpleTextView3.setGravity(17);
            this.scheduleStartAtTextView.setTextColor(-1);
            this.scheduleStartAtTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.scheduleStartAtTextView.setTextSize(18);
            this.containerView.addView(this.scheduleStartAtTextView, LayoutHelper.createFrame(-2, -2.0f, 49, 21.0f, 0.0f, 21.0f, 201.0f));
        }
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.GroupCallActivity.9
            private final LongSparseIntArray visiblePeerTmp = new LongSparseIntArray();

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View view, long j) {
                if (view == GroupCallActivity.this.scrimView) {
                    return false;
                }
                return super.drawChild(canvas, view, j);
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void dispatchDraw(android.graphics.Canvas r18) {
                /*
                    Method dump skipped, instructions count: 447
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.AnonymousClass9.dispatchDraw(android.graphics.Canvas):void");
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
            public void setVisibility(int i7) {
                if (getVisibility() != i7) {
                    for (int i8 = 0; i8 < getChildCount(); i8++) {
                        View childAt = getChildAt(i8);
                        if (childAt instanceof GroupCallGridCell) {
                            GroupCallActivity.this.attachRenderer((GroupCallGridCell) childAt, i7 == 0);
                        }
                    }
                }
                super.setVisibility(i7);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z2, int i7, int i8, int i9, int i10) {
                super.onLayout(z2, i7, i8, i9, i10);
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
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.GroupCallActivity.10
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i7, int i8) {
                GroupCallActivity groupCallActivity;
                ChatObject.Call call2;
                if (GroupCallActivity.this.listView.getChildCount() <= 0 || (call2 = (groupCallActivity = GroupCallActivity.this).call) == null) {
                    return;
                }
                if (!call2.loadingMembers && !call2.membersLoadEndReached && groupCallActivity.layoutManager.findLastVisibleItemPosition() > GroupCallActivity.this.listAdapter.getItemCount() - 5) {
                    GroupCallActivity.this.call.loadMembers(false);
                }
                GroupCallActivity.this.updateLayout(true);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i7) {
                if (i7 != 0) {
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
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.GroupCallActivity.11
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i7) {
                int i8 = GroupCallActivity.isLandscapeMode ? 6 : 2;
                if (GroupCallActivity.isTabletMode || i7 < GroupCallActivity.this.listAdapter.usersVideoGridStartRow || i7 >= GroupCallActivity.this.listAdapter.usersVideoGridEndRow) {
                    return i8;
                }
                int i9 = GroupCallActivity.this.listAdapter.usersVideoGridEndRow - GroupCallActivity.this.listAdapter.usersVideoGridStartRow;
                int i10 = (i7 != GroupCallActivity.this.listAdapter.usersVideoGridEndRow - 1 || (!GroupCallActivity.isLandscapeMode && i9 % 2 == 0)) ? 1 : 2;
                if (!GroupCallActivity.isLandscapeMode) {
                    return i10;
                }
                if (i9 == 1) {
                    return 6;
                }
                return i9 == 2 ? 3 : 2;
            }
        };
        this.spanSizeLookup = spanSizeLookup;
        fillLastGridLayoutManager2.setSpanSizeLookup(spanSizeLookup);
        this.listView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: org.rbmain.ui.GroupCallActivity.12
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition >= 0) {
                    rect.setEmpty();
                    if (childAdapterPosition < GroupCallActivity.this.listAdapter.usersVideoGridStartRow || childAdapterPosition >= GroupCallActivity.this.listAdapter.usersVideoGridEndRow) {
                        return;
                    }
                    int i7 = childAdapterPosition - GroupCallActivity.this.listAdapter.usersVideoGridStartRow;
                    int i8 = GroupCallActivity.isLandscapeMode ? 6 : 2;
                    int i9 = i7 % i8;
                    if (i9 == 0) {
                        rect.right = AndroidUtilities.dp(2.0f);
                    } else if (i9 == i8 - 1) {
                        rect.left = AndroidUtilities.dp(2.0f);
                    } else {
                        rect.left = AndroidUtilities.dp(1.0f);
                    }
                }
            }
        });
        this.layoutManager.setBind(false);
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 14.0f, 14.0f, 231.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setTopBottomSelectorRadius(13);
        this.listView.setSelectorDrawableColor(Theme.getColor(Theme.key_voipgroup_listSelector));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda62
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i7) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i7);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i7, float f, float f2) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i7, f, f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i7, float f, float f2) throws Resources.NotFoundException {
                this.f$0.lambda$new$13(view, i7, f, f2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda64
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i7) {
                return this.f$0.lambda$new$14(view, i7);
            }
        });
        RecyclerListView recyclerListView3 = new RecyclerListView(context);
        this.tabletVideoGridView = recyclerListView3;
        this.containerView.addView(recyclerListView3, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 14.0f, 324.0f, 14.0f));
        RecyclerListView recyclerListView4 = this.tabletVideoGridView;
        GroupCallTabletGridAdapter groupCallTabletGridAdapter = new GroupCallTabletGridAdapter(call, this.currentAccount, this);
        this.tabletGridAdapter = groupCallTabletGridAdapter;
        recyclerListView4.setAdapter(groupCallTabletGridAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 6, 1, false);
        this.tabletVideoGridView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.GroupCallActivity.14
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i7) {
                return GroupCallActivity.this.tabletGridAdapter.getSpanCount(i7);
            }
        });
        this.tabletVideoGridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda60
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i7) {
                this.f$0.lambda$new$15(view, i7);
            }
        });
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setDelayAnimations(false);
        defaultItemAnimator.setTranslationInterpolator(cubicBezierInterpolator);
        defaultItemAnimator.setRemoveDuration(350L);
        defaultItemAnimator.setAddDuration(350L);
        defaultItemAnimator.setMoveDuration(350L);
        this.tabletVideoGridView.setItemAnimator(new DefaultItemAnimator() { // from class: org.rbmain.ui.GroupCallActivity.15
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onMoveAnimationUpdate(RecyclerView.ViewHolder viewHolder) {
                GroupCallActivity.this.listView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                GroupCallActivity.this.updateLayout(true);
            }
        });
        this.tabletVideoGridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.GroupCallActivity.16
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i7, int i8) {
                super.onScrolled(recyclerView, i7, i8);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        });
        this.tabletGridAdapter.setVisibility(this.tabletVideoGridView, false, false);
        this.tabletVideoGridView.setVisibility(8);
        this.buttonsContainer = new AnonymousClass17(context);
        int color = Theme.getColor(Theme.key_voipgroup_unmuteButton2);
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
        Paint paint2 = blobDrawable.paint;
        int i7 = Theme.key_voipgroup_unmuteButton;
        paint2.setColor(ColorUtils.setAlphaComponent(Theme.getColor(i7), 38));
        blobDrawable2.paint.setColor(ColorUtils.setAlphaComponent(Theme.getColor(i7), 76));
        VoIPToggleButton voIPToggleButton = new VoIPToggleButton(context);
        this.soundButton = voIPToggleButton;
        voIPToggleButton.setCheckable(true);
        this.soundButton.setTextSize(12);
        this.buttonsContainer.addView(this.soundButton, LayoutHelper.createFrame(68, 80.0f));
        this.soundButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                this.f$0.lambda$new$16(view);
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
        RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.camera_flip, "2131820555", AndroidUtilities.dp(24.0f), AndroidUtilities.dp(24.0f), true, null);
        this.flipIcon = rLottieDrawable;
        rLottieImageView.setAnimation(rLottieDrawable);
        this.flipButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$17(view);
            }
        });
        this.flipButton.setVisibility(8);
        this.buttonsContainer.addView(this.flipButton, LayoutHelper.createFrame(68, 80.0f));
        VoIPToggleButton voIPToggleButton4 = new VoIPToggleButton(context);
        this.leaveButton = voIPToggleButton4;
        voIPToggleButton4.setDrawBackground(false);
        this.leaveButton.setTextSize(12);
        this.leaveButton.setData((this.call == null || !isRtmpStream()) ? R.drawable.calls_decline : R.drawable.msg_voiceclose, -1, Theme.getColor(Theme.key_voipgroup_leaveButton), 0.3f, false, LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), false, false);
        this.buttonsContainer.addView(this.leaveButton, LayoutHelper.createFrame(68, 80.0f));
        this.leaveButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$18(context, view);
            }
        });
        RLottieImageView rLottieImageView2 = new RLottieImageView(context) { // from class: org.rbmain.ui.GroupCallActivity.18
            /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public boolean onTouchEvent(android.view.MotionEvent r13) {
                /*
                    r12 = this;
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    boolean r0 = r0.isRtmpStream()
                    if (r0 == 0) goto Ld
                    boolean r13 = super.onTouchEvent(r13)
                    return r13
                Ld:
                    int r0 = r13.getAction()
                    r1 = 1
                    if (r0 != 0) goto L32
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    int r0 = org.rbmain.ui.GroupCallActivity.access$2200(r0)
                    if (r0 != 0) goto L32
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.messenger.ChatObject$Call r2 = r0.call
                    if (r2 == 0) goto L32
                    java.lang.Runnable r0 = org.rbmain.ui.GroupCallActivity.access$14800(r0)
                    r2 = 300(0x12c, double:1.48E-321)
                    org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0, r2)
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.ui.GroupCallActivity.access$14902(r0, r1)
                    goto Ld4
                L32:
                    int r0 = r13.getAction()
                    r2 = 3
                    if (r0 == r1) goto L3f
                    int r0 = r13.getAction()
                    if (r0 != r2) goto Ld4
                L3f:
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    boolean r0 = org.rbmain.ui.GroupCallActivity.access$14900(r0)
                    r3 = 0
                    if (r0 == 0) goto L58
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    java.lang.Runnable r0 = org.rbmain.ui.GroupCallActivity.access$14800(r0)
                    org.rbmain.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.ui.GroupCallActivity.access$14902(r0, r3)
                    goto Ld4
                L58:
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    boolean r0 = org.rbmain.ui.GroupCallActivity.access$15000(r0)
                    if (r0 == 0) goto Ld4
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    java.lang.Runnable r13 = org.rbmain.ui.GroupCallActivity.access$15100(r13)
                    org.rbmain.messenger.AndroidUtilities.cancelRunOnUIThread(r13)
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.ui.GroupCallActivity.access$15200(r13, r3, r1)
                    org.rbmain.messenger.voip.VoIPService r13 = org.rbmain.messenger.voip.VoIPService.getSharedInstance()
                    if (r13 == 0) goto L85
                    org.rbmain.messenger.voip.VoIPService r13 = org.rbmain.messenger.voip.VoIPService.getSharedInstance()
                    r13.setMicMute(r1, r1, r3)
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.ui.Components.RLottieImageView r13 = org.rbmain.ui.GroupCallActivity.access$5100(r13)
                    r0 = 2
                    r13.performHapticFeedback(r2, r0)
                L85:
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    java.util.ArrayList r13 = org.rbmain.ui.GroupCallActivity.access$6300(r13)
                    r13.clear()
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    java.util.ArrayList r13 = org.rbmain.ui.GroupCallActivity.access$6300(r13)
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = org.rbmain.ui.GroupCallActivity.access$6400(r0)
                    r13.addAll(r0)
                    r13 = 0
                L9e:
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = org.rbmain.ui.GroupCallActivity.access$6300(r0)
                    int r0 = r0.size()
                    if (r13 >= r0) goto Lbc
                    org.rbmain.ui.GroupCallActivity r0 = org.rbmain.ui.GroupCallActivity.this
                    java.util.ArrayList r0 = org.rbmain.ui.GroupCallActivity.access$6300(r0)
                    java.lang.Object r0 = r0.get(r13)
                    org.rbmain.ui.Components.voip.GroupCallMiniTextureView r0 = (org.rbmain.ui.Components.voip.GroupCallMiniTextureView) r0
                    r0.updateAttachState(r1)
                    int r13 = r13 + 1
                    goto L9e
                Lbc:
                    org.rbmain.ui.GroupCallActivity r13 = org.rbmain.ui.GroupCallActivity.this
                    org.rbmain.ui.GroupCallActivity.access$15002(r13, r3)
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
                Ld4:
                    boolean r13 = super.onTouchEvent(r13)
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.AnonymousClass18.onTouchEvent(android.view.MotionEvent):boolean");
            }

            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName(Button.class.getName());
                accessibilityNodeInfo.setEnabled(GroupCallActivity.this.muteButtonState == 0 || GroupCallActivity.this.muteButtonState == 1);
                if (GroupCallActivity.this.muteButtonState != 1 || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, LocaleController.getString("VoipMute", R.string.VoipMute)));
            }
        };
        this.muteButton = rLottieImageView2;
        rLottieImageView2.setAnimation(this.bigMicDrawable);
        this.muteButton.setScaleType(ImageView.ScaleType.CENTER);
        this.buttonsContainer.addView(this.muteButton, LayoutHelper.createFrame(122, 122, 49));
        this.muteButton.setOnClickListener(new AnonymousClass19());
        int iDp = AndroidUtilities.dp(38.0f);
        ImageView imageView = new ImageView(context);
        this.expandButton = imageView;
        imageView.setScaleX(0.1f);
        this.expandButton.setScaleY(0.1f);
        this.expandButton.setAlpha(0.0f);
        this.expandButton.setImageResource(R.drawable.voice_expand);
        this.expandButton.setPadding(iDp, iDp, iDp, iDp);
        this.buttonsContainer.addView(this.expandButton, LayoutHelper.createFrame(122, 122, 49));
        ImageView imageView2 = new ImageView(context);
        this.minimizeButton = imageView2;
        imageView2.setScaleX(0.1f);
        this.minimizeButton.setScaleY(0.1f);
        this.minimizeButton.setAlpha(0.0f);
        this.minimizeButton.setImageResource(R.drawable.voice_minimize);
        this.minimizeButton.setPadding(iDp, iDp, iDp, iDp);
        this.buttonsContainer.addView(this.minimizeButton, LayoutHelper.createFrame(122, 122, 49));
        if (this.call != null && isRtmpStream() && !this.call.isScheduled()) {
            this.expandButton.setAlpha(1.0f);
            this.expandButton.setScaleX(1.0f);
            this.expandButton.setScaleY(1.0f);
            this.muteButton.setAlpha(0.0f);
        }
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.radialProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(110.0f));
        this.radialProgressView.setStrokeWidth(4.0f);
        this.radialProgressView.setProgressColor(Theme.getColor(Theme.key_voipgroup_connectingProgress));
        for (int i8 = 0; i8 < 2; i8++) {
            this.muteLabel[i8] = new TextView(context);
            this.muteLabel[i8].setTextColor(Theme.getColor(Theme.key_voipgroup_actionBarItems));
            this.muteLabel[i8].setTextSize(1, 18.0f);
            this.muteLabel[i8].setGravity(1);
            this.buttonsContainer.addView(this.muteLabel[i8], LayoutHelper.createFrame(-2, -2.0f, 81, 0.0f, 0.0f, 0.0f, 26.0f));
        }
        this.actionBar.setAlpha(0.0f);
        this.actionBar.getBackButton().setScaleX(0.9f);
        this.actionBar.getBackButton().setScaleY(0.9f);
        this.actionBar.getBackButton().setTranslationX(-AndroidUtilities.dp(14.0f));
        this.actionBar.getTitleTextView().setTranslationY(AndroidUtilities.dp(23.0f));
        this.actionBar.getSubtitleTextView().setTranslationY(AndroidUtilities.dp(20.0f));
        this.actionBar.getAdditionalSubtitleTextView().setTranslationY(AndroidUtilities.dp(20.0f));
        this.actionBar.setRtlLayout(this.rtlLayout);
        int i9 = Theme.key_voipgroup_actionBarItems;
        ActionBarMenuItem actionBarMenuItem = new ActionBarMenuItem(context, null, 0, Theme.getColor(i9));
        this.otherItem = actionBarMenuItem;
        actionBarMenuItem.setRtlLayout(true);
        this.otherItem.setLongClickEnabled(false);
        this.otherItem.setIcon(R.drawable.ic_ab_other);
        this.otherItem.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
        this.otherItem.setSubMenuOpenSide(2);
        this.otherItem.setDelegate(new ActionBarMenuItem.ActionBarMenuItemDelegate() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda54
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemDelegate
            public final void onItemClick(int i10) {
                this.f$0.lambda$new$19(i10);
            }
        });
        ActionBarMenuItem actionBarMenuItem2 = this.otherItem;
        int i10 = Theme.key_voipgroup_actionBarItemsSelector;
        actionBarMenuItem2.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i10), 6));
        this.otherItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$20(view);
            }
        });
        this.otherItem.setPopupItemsColor(Theme.getColor(i9), false);
        this.otherItem.setPopupItemsColor(Theme.getColor(i9), true);
        ActionBarMenuItem actionBarMenuItem3 = new ActionBarMenuItem(context, null, 0, Theme.getColor(i9));
        this.pipItem = actionBarMenuItem3;
        actionBarMenuItem3.setLongClickEnabled(false);
        this.pipItem.setIcon((this.call == null || !isRtmpStream()) ? R.drawable.msg_voice_pip : R.drawable.ic_goinline);
        this.pipItem.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        this.pipItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i10), 6));
        this.pipItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$21(view);
            }
        });
        ActionBarMenuItem actionBarMenuItem4 = new ActionBarMenuItem(context, null, 0, Theme.getColor(i9));
        this.screenShareItem = actionBarMenuItem4;
        actionBarMenuItem4.setLongClickEnabled(false);
        this.screenShareItem.setIcon(R.drawable.msg_screencast);
        this.screenShareItem.setContentDescription(LocaleController.getString("AccDescrPipMode", R.string.AccDescrPipMode));
        this.screenShareItem.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(i10), 6));
        this.screenShareItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$22(view);
            }
        });
        this.titleTextView = new AnonymousClass20(context, context);
        View view = new View(this, context) { // from class: org.rbmain.ui.GroupCallActivity.21
            @Override // android.view.View
            protected void onMeasure(int i11, int i12) {
                setMeasuredDimension(View.MeasureSpec.getSize(i11), ActionBar.getCurrentActionBarHeight());
            }
        };
        this.actionBarBackground = view;
        view.setAlpha(0.0f);
        this.containerView.addView(this.actionBarBackground, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        ViewGroup viewGroup3 = this.containerView;
        AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
        boolean z2 = LocaleController.isRTL;
        viewGroup3.addView(clippingTextViewSwitcher, LayoutHelper.createFrame(-2, -2.0f, z2 ? 53 : 51, z2 ? 48.0f : 23.0f, 0.0f, z2 ? 23.0f : 48.0f, 0.0f));
        this.containerView.addView(this.actionBar, LayoutHelper.createFrame(-1, -2.0f, LocaleController.isRTL ? 53 : 51, 0.0f, 0.0f, 0.0f, 0.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.menuItemsContainer = linearLayout;
        linearLayout.setOrientation(0);
        if (LocaleController.isRTL) {
            linearLayout.addView(this.screenShareItem, LayoutHelper.createLinear(48, 48));
            linearLayout.addView(this.pipItem, LayoutHelper.createLinear(48, 48));
            linearLayout.addView(this.otherItem, LayoutHelper.createLinear(48, 48));
        } else {
            linearLayout.addView(this.otherItem, LayoutHelper.createLinear(48, 48));
            linearLayout.addView(this.pipItem, LayoutHelper.createLinear(48, 48));
            linearLayout.addView(this.screenShareItem, LayoutHelper.createLinear(48, 48));
        }
        this.containerView.addView(linearLayout, LayoutHelper.createFrame(-2, 48, LocaleController.isRTL ? 51 : 53));
        View view2 = new View(context);
        this.actionBarShadow = view2;
        view2.setAlpha(0.0f);
        this.actionBarShadow.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        this.containerView.addView(this.actionBarShadow, LayoutHelper.createFrame(-1, 1.0f));
        for (int i11 = 0; i11 < 2; i11++) {
            this.undoView[i11] = new UndoView(context) { // from class: org.rbmain.ui.GroupCallActivity.22
                @Override // org.rbmain.ui.Components.UndoView
                public void showWithAction(long j, int i12, Object obj, Object obj2, Runnable runnable, Runnable runnable2) {
                    if (GroupCallActivity.this.previewDialog != null) {
                        return;
                    }
                    super.showWithAction(j, i12, obj, obj2, runnable, runnable2);
                }
            };
            this.undoView[i11].setAdditionalTranslationY(AndroidUtilities.dp(10.0f));
            if (Build.VERSION.SDK_INT >= 21) {
                this.undoView[i11].setTranslationZ(AndroidUtilities.dp(5.0f));
            }
            this.containerView.addView(this.undoView[i11], LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        }
        AccountSelectCell accountSelectCell = new AccountSelectCell(context, true);
        this.accountSelectCell = accountSelectCell;
        accountSelectCell.setTag(R.id.width_tag, 240);
        this.otherItem.addSubItem(8, this.accountSelectCell, -2, AndroidUtilities.dp(48.0f));
        this.otherItem.setShowSubmenuByMove(false);
        AccountSelectCell accountSelectCell2 = this.accountSelectCell;
        int i12 = Theme.key_voipgroup_listSelector;
        accountSelectCell2.setBackground(Theme.createRadSelectorDrawable(Theme.getColor(i12), 6, 6));
        this.accountGap = this.otherItem.addGap(0);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem = this.otherItem.addSubItem(1, 0, (CharSequence) LocaleController.getString("VoipGroupAllCanSpeak", R.string.VoipGroupAllCanSpeak), true);
        this.everyoneItem = actionBarMenuSubItemAddSubItem;
        actionBarMenuSubItemAddSubItem.updateSelectorBackground(true, false);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem2 = this.otherItem.addSubItem(2, 0, (CharSequence) LocaleController.getString("VoipGroupOnlyAdminsCanSpeak", R.string.VoipGroupOnlyAdminsCanSpeak), true);
        this.adminItem = actionBarMenuSubItemAddSubItem2;
        actionBarMenuSubItemAddSubItem2.updateSelectorBackground(false, true);
        ActionBarMenuSubItem actionBarMenuSubItem = this.everyoneItem;
        int i13 = Theme.key_voipgroup_checkMenu;
        actionBarMenuSubItem.setCheckColor(i13);
        this.everyoneItem.setColors(Theme.getColor(i13), Theme.getColor(i13));
        this.adminItem.setCheckColor(i13);
        this.adminItem.setColors(Theme.getColor(i13), Theme.getColor(i13));
        Paint paint3 = new Paint(1);
        int i14 = Theme.key_voipgroup_actionBarItems;
        paint3.setColor(Theme.getColor(i14));
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(AndroidUtilities.dp(1.5f));
        paint3.setStrokeCap(Paint.Cap.ROUND);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem3 = this.otherItem.addSubItem(10, R.drawable.msg_voice_speaker, null, LocaleController.getString("VoipGroupAudio", R.string.VoipGroupAudio), true, false);
        this.soundItem = actionBarMenuSubItemAddSubItem3;
        actionBarMenuSubItemAddSubItem3.setItemHeight(56);
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem4 = this.otherItem.addSubItem(11, R.drawable.msg_noise_on, null, LocaleController.getString("VoipNoiseCancellation", R.string.VoipNoiseCancellation), true, false);
        this.noiseItem = actionBarMenuSubItemAddSubItem4;
        actionBarMenuSubItemAddSubItem4.setItemHeight(56);
        View viewAddDivider = this.otherItem.addDivider(ColorUtils.blendARGB(Theme.getColor(Theme.key_voipgroup_actionBar), -16777216, 0.3f));
        this.soundItemDivider = viewAddDivider;
        ((ViewGroup.MarginLayoutParams) viewAddDivider.getLayoutParams()).topMargin = 0;
        ((ViewGroup.MarginLayoutParams) this.soundItemDivider.getLayoutParams()).bottomMargin = 0;
        ActionBarMenuItem actionBarMenuItem5 = this.otherItem;
        RecordCallDrawable recordCallDrawable = this.recordCallDrawable;
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            i = R.string.VoipChannelEditTitle;
            str2 = "VoipChannelEditTitle";
        } else {
            i = R.string.VoipGroupEditTitle;
            str2 = "VoipGroupEditTitle";
        }
        this.editTitleItem = actionBarMenuItem5.addSubItem(6, R.drawable.msg_edit, recordCallDrawable, LocaleController.getString(str2, i), true, false);
        this.permissionItem = this.otherItem.addSubItem(7, R.drawable.msg_permissions, this.recordCallDrawable, LocaleController.getString("VoipGroupEditPermissions", R.string.VoipGroupEditPermissions), false, false);
        this.inviteItem = this.otherItem.addSubItem(3, R.drawable.msg_link, LocaleController.getString("VoipGroupShareInviteLink", R.string.VoipGroupShareInviteLink));
        this.recordCallDrawable = new RecordCallDrawable();
        this.screenItem = this.otherItem.addSubItem(9, R.drawable.msg_screencast, LocaleController.getString("VoipChatStartScreenCapture", R.string.VoipChatStartScreenCapture));
        ActionBarMenuSubItem actionBarMenuSubItemAddSubItem5 = this.otherItem.addSubItem(5, 0, this.recordCallDrawable, LocaleController.getString("VoipGroupRecordCall", R.string.VoipGroupRecordCall), true, false);
        this.recordItem = actionBarMenuSubItemAddSubItem5;
        this.recordCallDrawable.setParentView(actionBarMenuSubItemAddSubItem5.getImageView());
        ActionBarMenuItem actionBarMenuItem6 = this.otherItem;
        if (ChatObject.isChannelOrGiga(this.currentChat)) {
            i2 = R.string.VoipChannelEndChat;
            str3 = "VoipChannelEndChat";
        } else {
            i2 = R.string.VoipGroupEndChat;
            str3 = "VoipGroupEndChat";
        }
        this.leaveItem = actionBarMenuItem6.addSubItem(4, R.drawable.msg_endcall, LocaleController.getString(str3, i2));
        this.otherItem.setPopupItemsSelectorColor(Theme.getColor(i12));
        this.otherItem.getPopupLayout().setFitItems(true);
        this.soundItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        this.noiseItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        ActionBarMenuSubItem actionBarMenuSubItem2 = this.leaveItem;
        int i15 = Theme.key_voipgroup_leaveCallMenu;
        actionBarMenuSubItem2.setColors(Theme.getColor(i15), Theme.getColor(i15));
        this.inviteItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        this.editTitleItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        this.permissionItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        this.recordItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        this.screenItem.setColors(Theme.getColor(i14), Theme.getColor(i14));
        if (this.call != null) {
            initCreatedGroupCall();
        }
        this.leaveBackgroundPaint.setColor(Theme.getColor(Theme.key_voipgroup_leaveButton));
        updateTitle(false);
        this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f$0.lambda$new$23(view3);
            }
        });
        this.fullscreenUsersListView = new RecyclerListView(context) { // from class: org.rbmain.ui.GroupCallActivity.23
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View view3, long j) {
                GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) view3;
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
                    boolean zDrawChild = super.drawChild(canvas, view3, j);
                    canvas.restore();
                    return zDrawChild;
                }
                return super.drawChild(canvas, view3, j);
            }
        };
        DefaultItemAnimator defaultItemAnimator2 = new DefaultItemAnimator() { // from class: org.rbmain.ui.GroupCallActivity.24
            @Override // androidx.recyclerview.widget.DefaultItemAnimator
            protected void onMoveAnimationUpdate(RecyclerView.ViewHolder viewHolder) {
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
        this.fullscreenUsersListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.GroupCallActivity.25
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i16, int i17) {
                super.onScrolled(recyclerView, i16, i17);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                GroupCallActivity.this.renderersContainer.invalidate();
            }
        });
        this.fullscreenUsersListView.setClipChildren(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.fullscreenUsersListView.setLayoutManager(linearLayoutManager);
        RecyclerListView recyclerListView5 = this.fullscreenUsersListView;
        GroupCallFullscreenAdapter groupCallFullscreenAdapter = new GroupCallFullscreenAdapter(call, this.currentAccount, this);
        this.fullscreenAdapter = groupCallFullscreenAdapter;
        recyclerListView5.setAdapter(groupCallFullscreenAdapter);
        this.fullscreenAdapter.setVisibility(this.fullscreenUsersListView, false);
        this.fullscreenUsersListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda61
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view3, int i16) {
                this.f$0.lambda$new$24(view3, i16);
            }
        });
        this.fullscreenUsersListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda63
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view3, int i16) {
                return this.f$0.lambda$new$25(view3, i16);
            }
        });
        this.fullscreenUsersListView.setVisibility(8);
        this.fullscreenUsersListView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: org.rbmain.ui.GroupCallActivity.26
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view3, RecyclerView recyclerView, RecyclerView.State state) {
                recyclerView.getChildAdapterPosition(view3);
                if (!GroupCallActivity.isLandscapeMode) {
                    rect.set(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
                } else {
                    rect.set(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
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
        ProfileGalleryView profileGalleryView = new ProfileGalleryView(context, this.actionBar, this.listView, avatarPreviewPagerIndicator) { // from class: org.rbmain.ui.GroupCallActivity.28
            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        };
        this.avatarsViewPager = profileGalleryView;
        profileGalleryView.setImagesLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        profileGalleryView.setInvalidateWithParent(true);
        avatarPreviewPagerIndicator.setProfileGalleryView(profileGalleryView);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: org.rbmain.ui.GroupCallActivity.29
            Rect rect = new Rect();
            RectF rectF = new RectF();
            Path path = new Path();

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i16, int i17) {
                int iMin = Math.min(View.MeasureSpec.getSize(i16), View.MeasureSpec.getSize(i17));
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin + getPaddingBottom(), 1073741824));
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (GroupCallActivity.this.progressToAvatarPreview != 1.0f) {
                    if (GroupCallActivity.this.scrimView == null || !GroupCallActivity.this.hasScrimAnchorView) {
                        if (GroupCallActivity.this.scrimFullscreenView != null && GroupCallActivity.this.scrimRenderer == null && GroupCallActivity.this.previewTextureTransitionEnabled) {
                            canvas.save();
                            float measuredHeight = (GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight() / 2.0f) * (getMeasuredHeight() / GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight());
                            int iDp2 = (int) (((1.0f - GroupCallActivity.this.progressToAvatarPreview) * measuredHeight) + (AndroidUtilities.dp(13.0f) * GroupCallActivity.this.progressToAvatarPreview));
                            int i16 = (int) (measuredHeight * (1.0f - GroupCallActivity.this.progressToAvatarPreview));
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getImageReceiver().setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().setRoundRadius(iDp2, iDp2, i16, i16);
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getImageReceiver().draw(canvas);
                            GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().setRoundRadius(GroupCallActivity.this.scrimFullscreenView.getAvatarImageView().getMeasuredHeight() / 2);
                            canvas.restore();
                        }
                    } else {
                        canvas.save();
                        float measuredHeight2 = (GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2.0f) * (getMeasuredHeight() / GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight());
                        int iDp3 = (int) (((1.0f - GroupCallActivity.this.progressToAvatarPreview) * measuredHeight2) + (AndroidUtilities.dp(13.0f) * GroupCallActivity.this.progressToAvatarPreview));
                        int i17 = (int) (measuredHeight2 * (1.0f - GroupCallActivity.this.progressToAvatarPreview));
                        GroupCallActivity.this.scrimView.getAvatarWavesDrawable().draw(canvas, GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2, GroupCallActivity.this.scrimView.getAvatarImageView().getMeasuredHeight() / 2, this);
                        GroupCallActivity.this.scrimView.getAvatarImageView().getImageReceiver().setImageCoords(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                        GroupCallActivity.this.scrimView.getAvatarImageView().setRoundRadius(iDp3, iDp3, i17, i17);
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
        profileGalleryView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: org.rbmain.ui.GroupCallActivity.30
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i16) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i16, float f, int i17) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i16) {
                GroupCallActivity.this.avatarsViewPager.getRealPosition(i16);
                GroupCallActivity.this.avatarPagerIndicator.saveCurrentPageProgress();
                GroupCallActivity.this.avatarPagerIndicator.invalidate();
            }
        });
        this.blurredView = new View(context) { // from class: org.rbmain.ui.GroupCallActivity.31
            @Override // android.view.View
            public void setAlpha(float f) {
                if (getAlpha() != f) {
                    super.setAlpha(f);
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
        if (tLRPC$InputPeer != null) {
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
            final NumberPicker numberPicker2 = new NumberPicker(this, context) { // from class: org.rbmain.ui.GroupCallActivity.32
                @Override // org.rbmain.ui.Components.NumberPicker
                protected CharSequence getContentDescription(int i16) {
                    return LocaleController.formatPluralString("Hours", i16);
                }
            };
            numberPicker2.setItemCount(5);
            numberPicker2.setTextColor(-1);
            numberPicker2.setSelectorColor(-9598483);
            numberPicker2.setTextOffset(-AndroidUtilities.dp(10.0f));
            final NumberPicker numberPicker3 = new NumberPicker(this, context) { // from class: org.rbmain.ui.GroupCallActivity.33
                @Override // org.rbmain.ui.Components.NumberPicker
                protected CharSequence getContentDescription(int i16) {
                    return LocaleController.formatPluralString("Minutes", i16);
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
            this.scheduleButtonTextView.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(8.0f), 0, 1056964608));
            this.scheduleButtonTextView.setTextColor(-1);
            this.scheduleButtonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.scheduleButtonTextView.setTextSize(1, 14.0f);
            this.containerView.addView(this.scheduleButtonTextView, LayoutHelper.createFrame(-1, 48.0f, 81, 21.0f, 0.0f, 21.0f, 20.5f));
            final TLRPC$InputPeer tLRPC$InputPeer2 = groupCallPeer;
            this.scheduleButtonTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda25
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    this.f$0.lambda$new$30(numberPicker, numberPicker2, numberPicker3, tLRPC$Chat, accountInstance, tLRPC$InputPeer2, view5);
                }
            });
            LinearLayout linearLayout2 = new LinearLayout(this, context) { // from class: org.rbmain.ui.GroupCallActivity.35
                boolean ignoreLayout = false;

                @Override // android.widget.LinearLayout, android.view.View
                protected void onMeasure(int i16, int i17) {
                    this.ignoreLayout = true;
                    numberPicker.setItemCount(5);
                    numberPicker2.setItemCount(5);
                    numberPicker3.setItemCount(5);
                    numberPicker.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    numberPicker2.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    numberPicker3.getLayoutParams().height = AndroidUtilities.dp(54.0f) * 5;
                    this.ignoreLayout = false;
                    super.onMeasure(i16, i17);
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
            final int i16 = calendar.get(1);
            int i17 = calendar.get(6);
            this.scheduleTimerContainer.addView(numberPicker, LayoutHelper.createLinear(0, 270, 0.5f));
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(365);
            numberPicker.setWrapSelectorWheel(false);
            numberPicker.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda56
                @Override // org.rbmain.ui.Components.NumberPicker.Formatter
                public final String format(int i18) {
                    return GroupCallActivity.lambda$new$31(jCurrentTimeMillis, calendar, i16, i18);
                }
            });
            NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda59
                @Override // org.rbmain.ui.Components.NumberPicker.OnValueChangeListener
                public final void onValueChange(NumberPicker numberPicker4, int i18, int i19) {
                    this.f$0.lambda$new$32(numberPicker, numberPicker2, numberPicker3, numberPicker4, i18, i19);
                }
            };
            numberPicker.setOnValueChangedListener(onValueChangeListener);
            numberPicker2.setMinValue(0);
            numberPicker2.setMaxValue(23);
            this.scheduleTimerContainer.addView(numberPicker2, LayoutHelper.createLinear(0, 270, 0.2f));
            numberPicker2.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda58
                @Override // org.rbmain.ui.Components.NumberPicker.Formatter
                public final String format(int i18) {
                    return GroupCallActivity.lambda$new$33(i18);
                }
            });
            numberPicker2.setOnValueChangedListener(onValueChangeListener);
            numberPicker3.setMinValue(0);
            numberPicker3.setMaxValue(59);
            numberPicker3.setValue(0);
            numberPicker3.setFormatter(new NumberPicker.Formatter() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda57
                @Override // org.rbmain.ui.Components.NumberPicker.Formatter
                public final String format(int i18) {
                    return GroupCallActivity.lambda$new$34(i18);
                }
            });
            this.scheduleTimerContainer.addView(numberPicker3, LayoutHelper.createLinear(0, 270, 0.3f));
            numberPicker3.setOnValueChangedListener(onValueChangeListener);
            calendar.setTimeInMillis(jCurrentTimeMillis + 10800000);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            int i18 = calendar.get(6);
            int i19 = calendar.get(12);
            int i20 = calendar.get(11);
            numberPicker.setValue(i17 != i18 ? 1 : 0);
            numberPicker3.setValue(i19);
            numberPicker2.setValue(i20);
            AlertsCreator.checkScheduleDate(this.scheduleButtonTextView, this.scheduleInfoTextView, 604800L, 2, numberPicker, numberPicker2, numberPicker3);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            viewGroup = (ViewGroup) getWindow().getDecorView();
        } else {
            viewGroup = this.containerView;
        }
        PinchToZoomHelper pinchToZoomHelper = new PinchToZoomHelper(viewGroup, this.containerView) { // from class: org.rbmain.ui.GroupCallActivity.36
            @Override // org.rbmain.ui.PinchToZoomHelper
            protected void invalidateViews() {
                super.invalidateViews();
                for (int i21 = 0; i21 < GroupCallActivity.this.avatarsViewPager.getChildCount(); i21++) {
                    GroupCallActivity.this.avatarsViewPager.getChildAt(i21).invalidate();
                }
            }

            @Override // org.rbmain.ui.PinchToZoomHelper
            protected void drawOverlays(Canvas canvas, float f, float f2, float f3, float f4, float f5) {
                if (f > 0.0f) {
                    float x = GroupCallActivity.this.avatarPreviewContainer.getX() + ((BottomSheet) GroupCallActivity.this).containerView.getX();
                    float y = GroupCallActivity.this.avatarPreviewContainer.getY() + ((BottomSheet) GroupCallActivity.this).containerView.getY();
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(x, y, GroupCallActivity.this.avatarsViewPager.getMeasuredWidth() + x, GroupCallActivity.this.avatarsViewPager.getMeasuredHeight() + y);
                    canvas.saveLayerAlpha(rectF, (int) (f * 255.0f), 31);
                    canvas.translate(x, y);
                    GroupCallActivity.this.avatarPreviewContainer.draw(canvas);
                    canvas.restore();
                }
            }
        };
        this.pinchToZoomHelper = pinchToZoomHelper;
        pinchToZoomHelper.setCallback(new PinchToZoomHelper.Callback() { // from class: org.rbmain.ui.GroupCallActivity.37
            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public /* synthetic */ TextureView getCurrentTextureView() {
                return PinchToZoomHelper.Callback.CC.$default$getCurrentTextureView(this);
            }

            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public void onZoomStarted(MessageObject messageObject) {
                GroupCallActivity.this.listView.cancelClickRunnables(true);
                GroupCallActivity.this.pinchToZoomHelper.getPhotoImage().setRoundRadius(AndroidUtilities.dp(13.0f), AndroidUtilities.dp(13.0f), 0, 0);
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }

            @Override // org.rbmain.ui.PinchToZoomHelper.Callback
            public void onZoomFinished(MessageObject messageObject) {
                ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            }
        });
        profileGalleryView.setPinchToZoomHelper(this.pinchToZoomHelper);
        this.cameraButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                this.f$0.lambda$new$35(context, view5);
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
    public /* synthetic */ void lambda$new$10(DialogInterface dialogInterface) {
        BaseFragment baseFragment = this.parentActivity.getActionBarLayout().getFragmentStack().get(this.parentActivity.getActionBarLayout().getFragmentStack().size() - 1);
        if (this.anyEnterEventSent && (baseFragment instanceof ChatActivity)) {
            ((ChatActivity) baseFragment).onEditTextDialogClose(true, true);
        }
    }

    /* renamed from: org.rbmain.ui.GroupCallActivity$6, reason: invalid class name */
    class AnonymousClass6 extends ActionBar.ActionBarMenuOnItemClick {
        final /* synthetic */ Context val$context;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onItemClick$8(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        AnonymousClass6(Context context) {
            this.val$context = context;
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) throws Resources.NotFoundException {
            final VoIPService sharedInstance;
            int i2;
            int color;
            int i3;
            String str;
            if (i == -1) {
                GroupCallActivity.this.onBackPressed();
                return;
            }
            if (i == 1) {
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                groupCallActivity.call.call.join_muted = false;
                groupCallActivity.toggleAdminSpeak();
                return;
            }
            if (i == 2) {
                GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                groupCallActivity2.call.call.join_muted = true;
                groupCallActivity2.toggleAdminSpeak();
                return;
            }
            if (i == 3) {
                GroupCallActivity.this.getLink(false);
                return;
            }
            if (i == 4) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GroupCallActivity.this.getContext());
                if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                    builder.setTitle(LocaleController.getString("VoipChannelEndAlertTitle", R.string.VoipChannelEndAlertTitle));
                    builder.setMessage(LocaleController.getString("VoipChannelEndAlertText", R.string.VoipChannelEndAlertText));
                } else {
                    builder.setTitle(LocaleController.getString("VoipGroupEndAlertTitle", R.string.VoipGroupEndAlertTitle));
                    builder.setMessage(LocaleController.getString("VoipGroupEndAlertText", R.string.VoipGroupEndAlertText));
                }
                builder.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
                builder.setPositiveButton(LocaleController.getString("VoipGroupEnd", R.string.VoipGroupEnd), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$onItemClick$1(dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
                alertDialogCreate.show();
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_voipgroup_leaveCallMenu));
                }
                alertDialogCreate.setTextColor(Theme.getColor(Theme.key_voipgroup_actionBarItems));
                return;
            }
            if (i == 9) {
                GroupCallActivity.this.screenShareItem.callOnClick();
                return;
            }
            if (i == 5) {
                GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                ChatObject.Call call = groupCallActivity3.call;
                if (call.recording) {
                    final boolean z = call.call.record_video_active;
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(groupCallActivity3.getContext());
                    builder2.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
                    builder2.setTitle(LocaleController.getString("VoipGroupStopRecordingTitle", R.string.VoipGroupStopRecordingTitle));
                    if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                        builder2.setMessage(LocaleController.getString("VoipChannelStopRecordingText", R.string.VoipChannelStopRecordingText));
                    } else {
                        builder2.setMessage(LocaleController.getString("VoipGroupStopRecordingText", R.string.VoipGroupStopRecordingText));
                    }
                    builder2.setPositiveButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda4
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            this.f$0.lambda$onItemClick$2(z, dialogInterface, i4);
                        }
                    });
                    builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    AlertDialog alertDialogCreate2 = builder2.create();
                    alertDialogCreate2.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
                    alertDialogCreate2.show();
                    alertDialogCreate2.setTextColor(Theme.getColor(Theme.key_voipgroup_nameText));
                    return;
                }
                Context context = GroupCallActivity.this.getContext();
                GroupCallActivity groupCallActivity4 = GroupCallActivity.this;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, groupCallActivity4.currentChat, groupCallActivity4.hasVideo);
                if (GroupCallActivity.this.isRtmpStream()) {
                    anonymousClass1.onStartRecord(2);
                    return;
                } else {
                    anonymousClass1.show();
                    return;
                }
            }
            if (i == 7) {
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
            if (i == 6) {
                GroupCallActivity.this.enterEventSent = false;
                final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(GroupCallActivity.this.getContext());
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(GroupCallActivity.this.getContext(), true));
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(GroupCallActivity.this.getContext());
                builder3.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
                if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                    builder3.setTitle(LocaleController.getString("VoipChannelTitle", R.string.VoipChannelTitle));
                } else {
                    builder3.setTitle(LocaleController.getString("VoipGroupTitle", R.string.VoipGroupTitle));
                }
                builder3.setCheckFocusable(false);
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                LinearLayout linearLayout = new LinearLayout(GroupCallActivity.this.getContext());
                linearLayout.setOrientation(1);
                builder3.setView(linearLayout);
                editTextBoldCursor.setTextSize(1, 16.0f);
                int i4 = Theme.key_voipgroup_nameText;
                editTextBoldCursor.setTextColor(Theme.getColor(i4));
                editTextBoldCursor.setMaxLines(1);
                editTextBoldCursor.setLines(1);
                editTextBoldCursor.setInputType(16385);
                editTextBoldCursor.setGravity(51);
                editTextBoldCursor.setSingleLine(true);
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setHint(GroupCallActivity.this.currentChat.title);
                editTextBoldCursor.setHintTextColor(Theme.getColor(Theme.key_voipgroup_lastSeenText));
                editTextBoldCursor.setCursorColor(Theme.getColor(i4));
                editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
                editTextBoldCursor.setCursorWidth(1.5f);
                editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 6, 24, 0));
                editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda7
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView2, int i5, KeyEvent keyEvent) {
                        return GroupCallActivity.AnonymousClass6.lambda$onItemClick$4(builder3, textView2, i5, keyEvent);
                    }
                });
                editTextBoldCursor.addTextChangedListener(new TextWatcher(this) { // from class: org.rbmain.ui.GroupCallActivity.6.2
                    boolean ignoreTextChange;

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        if (!this.ignoreTextChange && editable.length() > 40) {
                            this.ignoreTextChange = true;
                            editable.delete(40, editable.length());
                            AndroidUtilities.shakeView(editTextBoldCursor);
                            editTextBoldCursor.performHapticFeedback(3, 2);
                            this.ignoreTextChange = false;
                        }
                    }
                });
                if (!TextUtils.isEmpty(GroupCallActivity.this.call.call.title)) {
                    editTextBoldCursor.setText(GroupCallActivity.this.call.call.title);
                    editTextBoldCursor.setSelection(editTextBoldCursor.length());
                }
                builder3.setPositiveButton(LocaleController.getString("Save", R.string.Save), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$onItemClick$5(editTextBoldCursor, builder3, dialogInterface, i5);
                    }
                });
                final AlertDialog alertDialogCreate3 = builder3.create();
                alertDialogCreate3.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_inviteMembersBackground));
                alertDialogCreate3.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) throws Resources.NotFoundException {
                        this.f$0.lambda$onItemClick$6(alertDialogCreate3, editTextBoldCursor, dialogInterface);
                    }
                });
                alertDialogCreate3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda5
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                alertDialogCreate3.show();
                alertDialogCreate3.setTextColor(Theme.getColor(i4));
                editTextBoldCursor.requestFocus();
                return;
            }
            if (i == 8) {
                Context context2 = GroupCallActivity.this.getContext();
                GroupCallActivity groupCallActivity5 = GroupCallActivity.this;
                JoinCallAlert.open(context2, -groupCallActivity5.currentChat.id, groupCallActivity5.accountInstance, null, 2, GroupCallActivity.this.selfPeer, new JoinCallAlert.JoinCallAlertDelegate() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda10
                    @Override // org.rbmain.ui.Components.JoinCallAlert.JoinCallAlertDelegate
                    public final void didSelectChat(TLRPC$InputPeer tLRPC$InputPeer, boolean z2, boolean z3) {
                        this.f$0.lambda$onItemClick$9(tLRPC$InputPeer, z2, z3);
                    }
                });
                return;
            }
            if (i == 11) {
                SharedConfig.toggleNoiseSupression();
                VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                if (sharedInstance2 == null) {
                    return;
                }
                sharedInstance2.setNoiseSupressionEnabled(SharedConfig.noiseSupression);
                return;
            }
            if (i != 10 || (sharedInstance = VoIPService.getSharedInstance()) == null) {
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
                    i3 = R.string.VoipAudioRoutingHeadset;
                    str = "VoipAudioRoutingHeadset";
                } else {
                    i3 = R.string.VoipAudioRoutingPhone;
                    str = "VoipAudioRoutingPhone";
                }
                arrayList.add(LocaleController.getString(str, i3));
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
            for (int i5 = 0; i5 < size; i5++) {
                charSequenceArr[i5] = (CharSequence) arrayList.get(i5);
                iArr[i5] = ((Integer) arrayList2.get(i5)).intValue();
            }
            BottomSheet.Builder items = new BottomSheet.Builder(this.val$context).setTitle(LocaleController.getString("VoipSelectAudioOutput", R.string.VoipSelectAudioOutput), true).setItems(charSequenceArr, iArr, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i6) {
                    GroupCallActivity.AnonymousClass6.lambda$onItemClick$10(sharedInstance, arrayList3, dialogInterface, i6);
                }
            });
            BottomSheet bottomSheetCreate = items.create();
            int i6 = Theme.key_voipgroup_listViewBackgroundUnscrolled;
            bottomSheetCreate.setBackgroundColor(Theme.getColor(i6));
            bottomSheetCreate.fixNavigationBar(Theme.getColor(i6));
            if (sharedInstance.getCurrentAudioRoute() == 1) {
                i2 = 0;
            } else {
                i2 = sharedInstance.getCurrentAudioRoute() == 0 ? 1 : 2;
            }
            items.show();
            bottomSheetCreate.setTitleColor(Theme.getColor(Theme.key_voipgroup_nameText));
            for (int i7 = 0; i7 < bottomSheetCreate.getItemViews().size(); i7++) {
                BottomSheet.BottomSheetCell bottomSheetCell = bottomSheetCreate.getItemViews().get(i7);
                if (i7 == i2) {
                    color = Theme.getColor(Theme.key_voipgroup_listeningText);
                    bottomSheetCell.isSelected = true;
                } else {
                    color = Theme.getColor(Theme.key_voipgroup_nameText);
                }
                bottomSheetCell.setTextColor(color);
                bottomSheetCell.setIconColor(color);
                bottomSheetCell.setBackground(Theme.createSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_voipgroup_actionBarItems), 12), 2));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(DialogInterface dialogInterface, int i) {
            if (GroupCallActivity.this.call.isScheduled()) {
                TLRPC$ChatFull chatFull = GroupCallActivity.this.accountInstance.getMessagesController().getChatFull(GroupCallActivity.this.currentChat.id);
                if (chatFull != null) {
                    chatFull.flags &= -2097153;
                    chatFull.call = null;
                    GroupCallActivity.this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(GroupCallActivity.this.currentChat.id), GroupCallActivity.this.call.call.id, Boolean.FALSE);
                }
                TLRPC$TL_phone_discardGroupCall tLRPC$TL_phone_discardGroupCall = new TLRPC$TL_phone_discardGroupCall();
                tLRPC$TL_phone_discardGroupCall.call = GroupCallActivity.this.call.getInputGroupCall();
                GroupCallActivity.this.accountInstance.getCallProxy().discardGroupVoiceChat(tLRPC$TL_phone_discardGroupCall, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda8
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$0(tLObject, tLRPC$TL_error);
                    }
                });
            } else if (VoIPService.getSharedInstance() != null) {
                VoIPService.getSharedInstance().hangUp(1);
            }
            GroupCallActivity.this.dismiss();
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject instanceof TLRPC$TL_updates) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$TL_updates) tLObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2(boolean z, DialogInterface dialogInterface, int i) {
            GroupCallActivity.this.call.toggleRecord(null, 0);
            GroupCallActivity.this.getUndoView().showWithAction(0L, z ? 101 : 40, (Runnable) null);
        }

        /* renamed from: org.rbmain.ui.GroupCallActivity$6$1, reason: invalid class name */
        class AnonymousClass1 extends GroupCallRecordAlert {
            AnonymousClass1(Context context, TLRPC$Chat tLRPC$Chat, boolean z) {
                super(context, tLRPC$Chat, z);
            }

            @Override // org.rbmain.ui.Components.GroupCallRecordAlert
            public void onStartRecord(final int i) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
                GroupCallActivity.this.enterEventSent = false;
                builder.setTitle(LocaleController.getString("VoipGroupStartRecordingTitle", R.string.VoipGroupStartRecordingTitle));
                if (i == 0) {
                    builder.setMessage(LocaleController.getString(GroupCallActivity.this.call.call.rtmp_stream ? R.string.VoipGroupStartRecordingRtmpText : R.string.VoipGroupStartRecordingText));
                } else {
                    boolean zIsChannelOrGiga = ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat);
                    int i2 = R.string.VoipGroupStartRecordingRtmpVideoText;
                    if (zIsChannelOrGiga) {
                        if (!GroupCallActivity.this.call.call.rtmp_stream) {
                            i2 = R.string.VoipChannelStartRecordingVideoText;
                        }
                        builder.setMessage(LocaleController.getString(i2));
                    } else {
                        if (!GroupCallActivity.this.call.call.rtmp_stream) {
                            i2 = R.string.VoipGroupStartRecordingVideoText;
                        }
                        builder.setMessage(LocaleController.getString(i2));
                    }
                }
                builder.setCheckFocusable(false);
                final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(getContext());
                editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(getContext(), Theme.getColor(Theme.key_voipgroup_windowBackgroundWhiteInputField), Theme.getColor(Theme.key_voipgroup_windowBackgroundWhiteInputFieldActivated)));
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(1);
                builder.setView(linearLayout);
                editTextBoldCursor.setTextSize(1, 16.0f);
                int i3 = Theme.key_voipgroup_nameText;
                editTextBoldCursor.setTextColor(Theme.getColor(i3));
                editTextBoldCursor.setMaxLines(1);
                editTextBoldCursor.setLines(1);
                editTextBoldCursor.setInputType(16385);
                editTextBoldCursor.setGravity(51);
                editTextBoldCursor.setSingleLine(true);
                editTextBoldCursor.setHint(LocaleController.getString("VoipGroupSaveFileHint", R.string.VoipGroupSaveFileHint));
                editTextBoldCursor.setImeOptions(6);
                editTextBoldCursor.setHintTextColor(Theme.getColor(Theme.key_voipgroup_lastSeenText));
                editTextBoldCursor.setCursorColor(Theme.getColor(i3));
                editTextBoldCursor.setCursorSize(AndroidUtilities.dp(20.0f));
                editTextBoldCursor.setCursorWidth(1.5f);
                editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, 0);
                linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, 36, 51, 24, 0, 24, 12));
                editTextBoldCursor.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.GroupCallActivity$6$1$$ExternalSyntheticLambda4
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                        return GroupCallActivity.AnonymousClass6.AnonymousClass1.lambda$onStartRecord$0(builder, textView, i4, keyEvent);
                    }
                });
                final AlertDialog alertDialogCreate = builder.create();
                alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_inviteMembersBackground));
                alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: org.rbmain.ui.GroupCallActivity$6$1$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) throws Resources.NotFoundException {
                        this.f$0.lambda$onStartRecord$1(alertDialogCreate, editTextBoldCursor, dialogInterface);
                    }
                });
                alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$6$1$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                builder.setPositiveButton(LocaleController.getString("Start", R.string.Start), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$1$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$onStartRecord$3(editTextBoldCursor, i, dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$6$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        AndroidUtilities.hideKeyboard(editTextBoldCursor);
                    }
                });
                AlertDialog alertDialogCreate2 = builder.create();
                alertDialogCreate2.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
                alertDialogCreate2.show();
                alertDialogCreate2.setTextColor(Theme.getColor(i3));
                editTextBoldCursor.requestFocus();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ boolean lambda$onStartRecord$0(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
                AndroidUtilities.hideKeyboard(textView);
                builder.create().getButton(-1).callOnClick();
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onStartRecord$1(AlertDialog alertDialog, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) throws Resources.NotFoundException {
                GroupCallActivity.this.makeFocusable(null, alertDialog, editTextBoldCursor, true);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onStartRecord$3(EditTextBoldCursor editTextBoldCursor, int i, DialogInterface dialogInterface, int i2) {
                GroupCallActivity.this.call.toggleRecord(editTextBoldCursor.getText().toString(), i);
                AndroidUtilities.hideKeyboard(editTextBoldCursor);
                GroupCallActivity.this.getUndoView().showWithAction(0L, i == 0 ? 39 : 100, (Runnable) null);
                if (VoIPService.getSharedInstance() != null) {
                    VoIPService.getSharedInstance().playStartRecordSound();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$onItemClick$4(AlertDialog.Builder builder, TextView textView, int i, KeyEvent keyEvent) {
            AndroidUtilities.hideKeyboard(textView);
            builder.create().getButton(-1).callOnClick();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$5(EditTextBoldCursor editTextBoldCursor, AlertDialog.Builder builder, DialogInterface dialogInterface, int i) {
            AndroidUtilities.hideKeyboard(editTextBoldCursor);
            GroupCallActivity.this.call.setTitle(editTextBoldCursor.getText().toString());
            builder.getDismissRunnable().run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$6(AlertDialog alertDialog, EditTextBoldCursor editTextBoldCursor, DialogInterface dialogInterface) throws Resources.NotFoundException {
            GroupCallActivity.this.makeFocusable(null, alertDialog, editTextBoldCursor, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$9(TLRPC$InputPeer tLRPC$InputPeer, boolean z, boolean z2) {
            TLObject chat;
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            if (groupCallActivity.call == null) {
                return;
            }
            boolean z3 = tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser;
            if (z3) {
                chat = groupCallActivity.accountInstance.getMessagesController().getUser(Integer.valueOf(tLRPC$InputPeer.user_id));
            } else {
                chat = tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat ? groupCallActivity.accountInstance.getMessagesController().getChat(Integer.valueOf(tLRPC$InputPeer.chat_id)) : groupCallActivity.accountInstance.getMessagesController().getChat(Integer.valueOf(tLRPC$InputPeer.channel_id));
            }
            TLObject tLObject = chat;
            if (GroupCallActivity.this.call.isScheduled()) {
                GroupCallActivity.this.getUndoView().showWithAction(0L, 37, tLObject, GroupCallActivity.this.currentChat, null, null);
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
                GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_saveDefaultGroupCallJoinAs, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$6$$ExternalSyntheticLambda9
                    @Override // org.rbmain.tgnet.RequestDelegate
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onItemClick$10(VoIPService voIPService, ArrayList arrayList, DialogInterface dialogInterface, int i) {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            voIPService.setAudioOutput(((Integer) arrayList.get(i)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$11(int[] iArr, float[] fArr, boolean[] zArr) {
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
    public /* synthetic */ void lambda$new$13(View view, int i, float f, float f2) throws Resources.NotFoundException {
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
            bundle.putInt("user_id", groupCallInvitedCell.getUser().id);
            if (groupCallInvitedCell.hasAvatarSet()) {
                bundle.putBoolean("expandPhoto", true);
            }
            this.parentActivity.lambda$runLinkRequest$40(new ProfileActivity(bundle));
            dismiss();
            return;
        }
        if (i == this.listAdapter.addMemberRow) {
            if (ChatObject.isChannel(this.currentChat)) {
                TLRPC$Chat tLRPC$Chat = this.currentChat;
                if (!tLRPC$Chat.megagroup && ChatObject.isPublic(tLRPC$Chat)) {
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
            groupVoipInviteAlert.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$12(dialogInterface);
                }
            });
            this.groupVoipInviteAlert.setDelegate(new GroupVoipInviteAlert.GroupVoipInviteAlertDelegate() { // from class: org.rbmain.ui.GroupCallActivity.13
                @Override // org.rbmain.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void copyInviteLink() throws Resources.NotFoundException {
                    GroupCallActivity.this.getLink(true);
                }

                @Override // org.rbmain.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void inviteUser(int i2) {
                    GroupCallActivity.this.inviteUserToCall(i2, true);
                }

                @Override // org.rbmain.ui.Components.GroupVoipInviteAlert.GroupVoipInviteAlertDelegate
                public void needOpenSearch(MotionEvent motionEvent, EditTextBoldCursor editTextBoldCursor) throws Resources.NotFoundException {
                    if (GroupCallActivity.this.enterEventSent) {
                        return;
                    }
                    if (motionEvent.getX() > editTextBoldCursor.getLeft() && motionEvent.getX() < editTextBoldCursor.getRight() && motionEvent.getY() > editTextBoldCursor.getTop() && motionEvent.getY() < editTextBoldCursor.getBottom()) {
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        groupCallActivity.makeFocusable(groupCallActivity.groupVoipInviteAlert, null, editTextBoldCursor, true);
                    } else {
                        GroupCallActivity groupCallActivity2 = GroupCallActivity.this;
                        groupCallActivity2.makeFocusable(groupCallActivity2.groupVoipInviteAlert, null, editTextBoldCursor, false);
                    }
                }
            });
            this.groupVoipInviteAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$12(DialogInterface dialogInterface) {
        this.groupVoipInviteAlert = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$14(View view, int i) {
        if (isRtmpStream()) {
            return false;
        }
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
    public /* synthetic */ void lambda$new$15(View view, int i) {
        GroupCallGridCell groupCallGridCell = (GroupCallGridCell) view;
        if (groupCallGridCell.getParticipant() != null) {
            fullscreenFor(groupCallGridCell.getParticipant());
        }
    }

    /* renamed from: org.rbmain.ui.GroupCallActivity$17, reason: invalid class name */
    class AnonymousClass17 extends FrameLayout {
        AnimatorSet currentButtonsAnimation;
        int currentLightColor;
        final OvershootInterpolator overshootInterpolator;

        AnonymousClass17(Context context) {
            super(context);
            this.overshootInterpolator = new OvershootInterpolator(1.5f);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            if (!GroupCallActivity.isLandscapeMode) {
                i = View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(460.0f), View.MeasureSpec.getSize(i)), 1073741824);
            }
            for (int i3 = 0; i3 < 2; i3++) {
                if (!GroupCallActivity.isLandscapeMode || GroupCallActivity.isTabletMode) {
                    GroupCallActivity.this.muteLabel[i3].getLayoutParams().width = -2;
                } else {
                    GroupCallActivity.this.muteLabel[i3].getLayoutParams().width = (int) (View.MeasureSpec.getSize(i) / 0.68f);
                }
            }
            super.onMeasure(i, i2);
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int measuredWidth = (getMeasuredWidth() - AndroidUtilities.dp(122.0f)) / 2;
            int measuredHeight = getMeasuredHeight();
            int i5 = GroupCallActivity.this.cameraButton.getVisibility() != 0 ? 4 : 5;
            if (GroupCallActivity.this.soundButton.getVisibility() != 0) {
                i5--;
            }
            if (GroupCallActivity.this.flipButton.getVisibility() != 0) {
                i5--;
            }
            if (!GroupCallActivity.isLandscapeMode || GroupCallActivity.isTabletMode) {
                if (GroupCallActivity.this.renderersContainer.inFullscreenMode && !GroupCallActivity.isTabletMode) {
                    int measuredWidth2 = getMeasuredWidth() / i5;
                    if (GroupCallActivity.this.soundButton.getVisibility() == 0) {
                        int i6 = measuredWidth2 / 2;
                        int measuredWidth3 = i6 - (GroupCallActivity.this.cameraButton.getMeasuredWidth() / 2);
                        int measuredHeight2 = getMeasuredHeight() - GroupCallActivity.this.cameraButton.getMeasuredHeight();
                        GroupCallActivity.this.cameraButton.layout(measuredWidth3, measuredHeight2, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth3, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight2);
                        int measuredWidth4 = (i6 + (i5 == 4 ? measuredWidth2 : 0)) - (GroupCallActivity.this.leaveButton.getMeasuredWidth() / 2);
                        int measuredHeight3 = getMeasuredHeight() - GroupCallActivity.this.soundButton.getMeasuredHeight();
                        GroupCallActivity.this.soundButton.layout(measuredWidth4, measuredHeight3, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth4, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight3);
                    } else {
                        int i7 = measuredWidth2 / 2;
                        int measuredWidth5 = ((i5 == 4 ? measuredWidth2 : 0) + i7) - (GroupCallActivity.this.cameraButton.getMeasuredWidth() / 2);
                        int measuredHeight4 = getMeasuredHeight() - GroupCallActivity.this.cameraButton.getMeasuredHeight();
                        GroupCallActivity.this.cameraButton.layout(measuredWidth5, measuredHeight4, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth5, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight4);
                        int measuredWidth6 = i7 - (GroupCallActivity.this.flipButton.getMeasuredWidth() / 2);
                        int measuredHeight5 = getMeasuredHeight() - GroupCallActivity.this.flipButton.getMeasuredHeight();
                        GroupCallActivity.this.flipButton.layout(measuredWidth6, measuredHeight5, GroupCallActivity.this.flipButton.getMeasuredWidth() + measuredWidth6, GroupCallActivity.this.flipButton.getMeasuredHeight() + measuredHeight5);
                    }
                    int i8 = measuredWidth2 / 2;
                    int measuredWidth7 = ((i5 == 4 ? measuredWidth2 * 3 : measuredWidth2 * 2) + i8) - (GroupCallActivity.this.leaveButton.getMeasuredWidth() / 2);
                    int measuredHeight6 = getMeasuredHeight() - GroupCallActivity.this.leaveButton.getMeasuredHeight();
                    GroupCallActivity.this.leaveButton.layout(measuredWidth7, measuredHeight6, GroupCallActivity.this.leaveButton.getMeasuredWidth() + measuredWidth7, GroupCallActivity.this.leaveButton.getMeasuredHeight() + measuredHeight6);
                    int measuredWidth8 = (i8 + (i5 == 4 ? measuredWidth2 * 2 : measuredWidth2)) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2);
                    int measuredHeight7 = (getMeasuredHeight() - GroupCallActivity.this.leaveButton.getMeasuredHeight()) - ((GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(52.0f)) / 2);
                    GroupCallActivity.this.muteButton.layout(measuredWidth8, measuredHeight7, GroupCallActivity.this.muteButton.getMeasuredWidth() + measuredWidth8, GroupCallActivity.this.muteButton.getMeasuredHeight() + measuredHeight7);
                    GroupCallActivity.this.minimizeButton.layout(measuredWidth8, measuredHeight7, GroupCallActivity.this.minimizeButton.getMeasuredWidth() + measuredWidth8, GroupCallActivity.this.minimizeButton.getMeasuredHeight() + measuredHeight7);
                    GroupCallActivity.this.expandButton.layout(measuredWidth8, measuredHeight7, GroupCallActivity.this.expandButton.getMeasuredWidth() + measuredWidth8, GroupCallActivity.this.expandButton.getMeasuredHeight() + measuredHeight7);
                    float fDp = AndroidUtilities.dp(52.0f) / (GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(8.0f));
                    GroupCallActivity.this.muteButton.animate().scaleX(fDp).scaleY(fDp).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    for (int i9 = 0; i9 < 2; i9++) {
                        int measuredWidth9 = (i5 == 4 ? measuredWidth2 * 2 : measuredWidth2) + ((measuredWidth2 - GroupCallActivity.this.muteLabel[i9].getMeasuredWidth()) / 2);
                        int iDp = measuredHeight - AndroidUtilities.dp(27.0f);
                        GroupCallActivity.this.muteLabel[i9].layout(measuredWidth9, iDp, GroupCallActivity.this.muteLabel[i9].getMeasuredWidth() + measuredWidth9, GroupCallActivity.this.muteLabel[i9].getMeasuredHeight() + iDp);
                        GroupCallActivity.this.muteLabel[i9].animate().scaleX(0.687f).scaleY(0.687f).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
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
                    GroupCallActivity.this.minimizeButton.layout(measuredWidth16, measuredHeight14, GroupCallActivity.this.minimizeButton.getMeasuredWidth() + measuredWidth16, GroupCallActivity.this.minimizeButton.getMeasuredHeight() + measuredHeight14);
                    GroupCallActivity.this.expandButton.layout(measuredWidth16, measuredHeight14, GroupCallActivity.this.expandButton.getMeasuredWidth() + measuredWidth16, GroupCallActivity.this.expandButton.getMeasuredHeight() + measuredHeight14);
                    GroupCallActivity.this.muteButton.animate().setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).scaleX(1.0f).scaleY(1.0f).start();
                    for (int i10 = 0; i10 < 2; i10++) {
                        int measuredWidth17 = (getMeasuredWidth() - GroupCallActivity.this.muteLabel[i10].getMeasuredWidth()) / 2;
                        int iDp4 = (measuredHeight - AndroidUtilities.dp(12.0f)) - GroupCallActivity.this.muteLabel[i10].getMeasuredHeight();
                        GroupCallActivity.this.muteLabel[i10].layout(measuredWidth17, iDp4, GroupCallActivity.this.muteLabel[i10].getMeasuredWidth() + measuredWidth17, GroupCallActivity.this.muteLabel[i10].getMeasuredHeight() + iDp4);
                        GroupCallActivity.this.muteLabel[i10].animate().scaleX(1.0f).scaleY(1.0f).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
                    }
                }
            } else {
                int measuredHeight15 = getMeasuredHeight() / i5;
                if (GroupCallActivity.this.soundButton.getVisibility() == 0) {
                    int i11 = measuredHeight15 / 2;
                    int measuredHeight16 = i11 - (GroupCallActivity.this.cameraButton.getMeasuredHeight() / 2);
                    int measuredWidth18 = (getMeasuredWidth() - GroupCallActivity.this.cameraButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.cameraButton.layout(measuredWidth18, measuredHeight16, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth18, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight16);
                    int measuredHeight17 = (i11 + (i5 == 4 ? measuredHeight15 : 0)) - (GroupCallActivity.this.soundButton.getMeasuredHeight() / 2);
                    int measuredWidth19 = (getMeasuredWidth() - GroupCallActivity.this.soundButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.soundButton.layout(measuredWidth19, measuredHeight17, GroupCallActivity.this.soundButton.getMeasuredWidth() + measuredWidth19, GroupCallActivity.this.soundButton.getMeasuredHeight() + measuredHeight17);
                } else {
                    int i12 = measuredHeight15 / 2;
                    int measuredHeight18 = i12 - (GroupCallActivity.this.flipButton.getMeasuredHeight() / 2);
                    int measuredWidth20 = (getMeasuredWidth() - GroupCallActivity.this.flipButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.flipButton.layout(measuredWidth20, measuredHeight18, GroupCallActivity.this.flipButton.getMeasuredWidth() + measuredWidth20, GroupCallActivity.this.flipButton.getMeasuredHeight() + measuredHeight18);
                    int measuredHeight19 = (i12 + (i5 == 4 ? measuredHeight15 : 0)) - (GroupCallActivity.this.cameraButton.getMeasuredHeight() / 2);
                    int measuredWidth21 = (getMeasuredWidth() - GroupCallActivity.this.cameraButton.getMeasuredWidth()) >> 1;
                    GroupCallActivity.this.cameraButton.layout(measuredWidth21, measuredHeight19, GroupCallActivity.this.cameraButton.getMeasuredWidth() + measuredWidth21, GroupCallActivity.this.cameraButton.getMeasuredHeight() + measuredHeight19);
                }
                int i13 = measuredHeight15 / 2;
                int measuredHeight20 = ((i5 == 4 ? measuredHeight15 * 3 : measuredHeight15 * 2) + i13) - (GroupCallActivity.this.leaveButton.getMeasuredHeight() / 2);
                int measuredWidth22 = (getMeasuredWidth() - GroupCallActivity.this.leaveButton.getMeasuredWidth()) >> 1;
                GroupCallActivity.this.leaveButton.layout(measuredWidth22, measuredHeight20, GroupCallActivity.this.leaveButton.getMeasuredWidth() + measuredWidth22, GroupCallActivity.this.leaveButton.getMeasuredHeight() + measuredHeight20);
                int measuredWidth23 = (((i5 == 4 ? measuredHeight15 * 2 : measuredHeight15) + i13) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2)) - AndroidUtilities.dp(4.0f);
                int measuredWidth24 = (getMeasuredWidth() - GroupCallActivity.this.muteButton.getMeasuredWidth()) >> 1;
                if (i5 == 3) {
                    measuredWidth23 -= AndroidUtilities.dp(6.0f);
                }
                GroupCallActivity.this.muteButton.layout(measuredWidth24, measuredWidth23, GroupCallActivity.this.muteButton.getMeasuredWidth() + measuredWidth24, GroupCallActivity.this.muteButton.getMeasuredHeight() + measuredWidth23);
                GroupCallActivity.this.minimizeButton.layout(measuredWidth24, measuredWidth23, GroupCallActivity.this.minimizeButton.getMeasuredWidth() + measuredWidth24, GroupCallActivity.this.minimizeButton.getMeasuredHeight() + measuredWidth23);
                GroupCallActivity.this.expandButton.layout(measuredWidth24, measuredWidth23, GroupCallActivity.this.expandButton.getMeasuredWidth() + measuredWidth24, GroupCallActivity.this.expandButton.getMeasuredHeight() + measuredWidth23);
                float fDp2 = AndroidUtilities.dp(52.0f) / (GroupCallActivity.this.muteButton.getMeasuredWidth() - AndroidUtilities.dp(8.0f));
                GroupCallActivity.this.muteButton.animate().cancel();
                GroupCallActivity.this.muteButton.setScaleX(fDp2);
                GroupCallActivity.this.muteButton.setScaleY(fDp2);
                for (int i14 = 0; i14 < 2; i14++) {
                    int measuredWidth25 = (getMeasuredWidth() - GroupCallActivity.this.muteLabel[i14].getMeasuredWidth()) >> 1;
                    int i15 = i5 == 4 ? measuredHeight15 * 2 : measuredHeight15;
                    int measuredWidth26 = ((i13 + i15) - (GroupCallActivity.this.muteButton.getMeasuredWidth() / 2)) - AndroidUtilities.dp(4.0f);
                    if (i5 == 3) {
                        measuredWidth26 -= AndroidUtilities.dp(6.0f);
                    }
                    int measuredWidth27 = (int) (measuredWidth26 + (GroupCallActivity.this.muteButton.getMeasuredWidth() * 0.687f) + AndroidUtilities.dp(4.0f));
                    if (GroupCallActivity.this.muteLabel[i14].getMeasuredHeight() + measuredWidth27 > i15 + measuredHeight15) {
                        measuredWidth27 -= AndroidUtilities.dp(4.0f);
                    }
                    GroupCallActivity.this.muteLabel[i14].layout(measuredWidth25, measuredWidth27, GroupCallActivity.this.muteLabel[i14].getMeasuredWidth() + measuredWidth25, GroupCallActivity.this.muteLabel[i14].getMeasuredHeight() + measuredWidth27);
                    GroupCallActivity.this.muteLabel[i14].setScaleX(0.687f);
                    GroupCallActivity.this.muteLabel[i14].setScaleY(0.687f);
                }
            }
            if (GroupCallActivity.this.animateButtonsOnNextLayout) {
                AnimatorSet animatorSet = new AnimatorSet();
                boolean z2 = false;
                for (int i16 = 0; i16 < getChildCount(); i16++) {
                    View childAt = getChildAt(i16);
                    Float f = (Float) GroupCallActivity.this.buttonsAnimationParamsX.get(childAt);
                    Float f2 = (Float) GroupCallActivity.this.buttonsAnimationParamsY.get(childAt);
                    if (f != null && f2 != null) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) FrameLayout.TRANSLATION_X, f.floatValue() - childAt.getLeft(), 0.0f));
                        animatorSet.playTogether(ObjectAnimator.ofFloat(childAt, (Property<View, Float>) FrameLayout.TRANSLATION_Y, f2.floatValue() - childAt.getTop(), 0.0f));
                        z2 = true;
                    }
                }
                if (z2) {
                    AnimatorSet animatorSet2 = this.currentButtonsAnimation;
                    if (animatorSet2 != null) {
                        animatorSet2.removeAllListeners();
                        this.currentButtonsAnimation.cancel();
                    }
                    this.currentButtonsAnimation = animatorSet;
                    animatorSet.setDuration(350L);
                    animatorSet.setInterpolator(CubicBezierInterpolator.DEFAULT);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.17.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            AnonymousClass17.this.currentButtonsAnimation = null;
                            for (int i17 = 0; i17 < AnonymousClass17.this.getChildCount(); i17++) {
                                View childAt2 = AnonymousClass17.this.getChildAt(i17);
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
        /* JADX WARN: Removed duplicated region for block: B:144:0x0660  */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0663  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x06de  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x07f0  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x07f4  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x088b  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x08a0  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0902  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0930  */
        /* JADX WARN: Removed duplicated region for block: B:191:0x0952  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x095f  */
        /* JADX WARN: Removed duplicated region for block: B:195:0x0962  */
        /* JADX WARN: Removed duplicated region for block: B:198:0x09c8  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x09dd A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:204:0x09e5  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x0a54 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:213:0x0a7f  */
        /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x033e  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0363  */
        @Override // android.view.ViewGroup, android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected void dispatchDraw(android.graphics.Canvas r27) {
            /*
                Method dump skipped, instructions count: 2691
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.AnonymousClass17.dispatchDraw(android.graphics.Canvas):void");
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            if (view == GroupCallActivity.this.muteButton && view.getScaleX() != 1.0f) {
                canvas.save();
                float scaleX = (((1.0f / GroupCallActivity.this.muteButton.getScaleX()) - 1.0f) * 0.2f) + 1.0f;
                canvas.scale(scaleX, scaleX, view.getX() + (view.getMeasuredWidth() / 2.0f), view.getY() + (view.getMeasuredHeight() / 2.0f));
                boolean zDrawChild = super.drawChild(canvas, view, j);
                canvas.restore();
                return zDrawChild;
            }
            return super.drawChild(canvas, view, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$16(View view) throws Resources.NotFoundException {
        ChatObject.Call call = this.call;
        if (call == null || call.isScheduled() || isRtmpStream()) {
            getLink(false);
        } else {
            if (VoIPService.getSharedInstance() == null) {
                return;
            }
            VoIPService.getSharedInstance().toggleSpeakerphoneOrShowRouteSheet(getContext(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$17(View view) {
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
    public /* synthetic */ void lambda$new$18(Context context, View view) {
        this.renderersContainer.delayHideUi();
        ChatObject.Call call = this.call;
        if (call == null || call.isScheduled()) {
            dismiss();
        } else {
            updateItems();
            onLeaveClick(context, new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.dismiss();
                }
            }, false);
        }
    }

    /* renamed from: org.rbmain.ui.GroupCallActivity$19, reason: invalid class name */
    class AnonymousClass19 implements View.OnClickListener {
        Runnable finishRunnable = new Runnable() { // from class: org.rbmain.ui.GroupCallActivity.19.1
            @Override // java.lang.Runnable
            public void run() {
                GroupCallActivity.this.muteButton.setAnimation(GroupCallActivity.this.bigMicDrawable);
                GroupCallActivity.this.playingHandAnimation = false;
            }
        };

        AnonymousClass19() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            if (groupCallActivity.call == null || groupCallActivity.muteButtonState == 3) {
                return;
            }
            int i = 0;
            if (!GroupCallActivity.this.isRtmpStream() || GroupCallActivity.this.call.isScheduled()) {
                if (GroupCallActivity.this.muteButtonState == 5) {
                    if (GroupCallActivity.this.startingGroupCall) {
                        return;
                    }
                    view.performHapticFeedback(3, 2);
                    GroupCallActivity.this.startingGroupCall = true;
                    TLRPC$TL_phone_startScheduledGroupCall tLRPC$TL_phone_startScheduledGroupCall = new TLRPC$TL_phone_startScheduledGroupCall();
                    tLRPC$TL_phone_startScheduledGroupCall.call = GroupCallActivity.this.call.getInputGroupCall();
                    GroupCallActivity.this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_startScheduledGroupCall, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$19$$ExternalSyntheticLambda2
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$onClick$1(tLObject, tLRPC$TL_error);
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
                    groupCallActivity2.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_toggleGroupCallStartSubscription, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$19$$ExternalSyntheticLambda1
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$onClick$2(tLObject, tLRPC$TL_error);
                        }
                    });
                    GroupCallActivity groupCallActivity3 = GroupCallActivity.this;
                    groupCallActivity3.updateMuteButton(groupCallActivity3.call.call.schedule_start_subscribed ? 7 : 6, true);
                    return;
                }
                if (VoIPService.getSharedInstance() == null || GroupCallActivity.this.isStillConnecting()) {
                    return;
                }
                if (GroupCallActivity.this.muteButtonState == 2 || GroupCallActivity.this.muteButtonState == 4) {
                    if (GroupCallActivity.this.playingHandAnimation) {
                        return;
                    }
                    GroupCallActivity.this.playingHandAnimation = true;
                    AndroidUtilities.shakeView(GroupCallActivity.this.muteLabel[0]);
                    view.performHapticFeedback(3, 2);
                    int iNextInt = Utilities.random.nextInt(100);
                    int i2 = 540;
                    if (iNextInt < 32) {
                        i2 = 120;
                    } else if (iNextInt < 64) {
                        i2 = 240;
                        i = 120;
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
                        int peerId = MessageObject.getPeerId(groupCallActivity4.call.participants.get(MessageObject.getPeerId(groupCallActivity4.selfPeer)).peer);
                        VoIPService.getSharedInstance().editCallMember(DialogObject.isUserDialog((long) peerId) ? GroupCallActivity.this.accountInstance.getMessagesController().getUser(Integer.valueOf(peerId)) : GroupCallActivity.this.accountInstance.getMessagesController().getChat(Integer.valueOf(-peerId)), null, null, null, Boolean.TRUE, null);
                        GroupCallActivity.this.updateMuteButton(4, true);
                        return;
                    }
                    return;
                }
                if (GroupCallActivity.this.muteButtonState == 0) {
                    GroupCallActivity.this.updateMuteButton(1, true);
                    VoIPService.getSharedInstance().setMicMute(false, false, true);
                    GroupCallActivity.this.muteButton.performHapticFeedback(3, 2);
                    return;
                } else {
                    GroupCallActivity.this.updateMuteButton(0, true);
                    VoIPService.getSharedInstance().setMicMute(true, false, true);
                    GroupCallActivity.this.muteButton.performHapticFeedback(3, 2);
                    return;
                }
            }
            if (GroupCallActivity.this.renderersContainer != null && GroupCallActivity.this.renderersContainer.inFullscreenMode && (AndroidUtilities.isTablet() || GroupCallActivity.isLandscapeMode == GroupCallActivity.this.isRtmpLandscapeMode())) {
                GroupCallActivity.this.fullscreenFor(null);
                if (GroupCallActivity.isLandscapeMode) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$19$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onClick$0();
                        }
                    }, 200L);
                }
                GroupCallActivity.this.parentActivity.setRequestedOrientation(-1);
                return;
            }
            if (GroupCallActivity.this.visibleVideoParticipants.isEmpty()) {
                return;
            }
            ChatObject.VideoParticipant videoParticipant = GroupCallActivity.this.visibleVideoParticipants.get(0);
            if (AndroidUtilities.isTablet()) {
                GroupCallActivity.this.fullscreenFor(videoParticipant);
                return;
            }
            if (GroupCallActivity.isLandscapeMode == GroupCallActivity.this.isRtmpLandscapeMode()) {
                GroupCallActivity.this.fullscreenFor(videoParticipant);
            }
            if (GroupCallActivity.this.isRtmpLandscapeMode()) {
                GroupCallActivity.this.parentActivity.setRequestedOrientation(6);
            } else {
                GroupCallActivity.this.parentActivity.setRequestedOrientation(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() {
            GroupCallActivity.this.wasNotInLayoutFullscreen = null;
            GroupCallActivity.this.wasExpandBigSize = null;
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            groupCallActivity.updateMuteButton(groupCallActivity.muteButtonState, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$1(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$2(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                GroupCallActivity.this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$19(int i) {
        this.actionBar.getActionBarMenuOnItemClick().onItemClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$20(View view) {
        ChatObject.Call call = this.call;
        if (call == null || this.renderersContainer.inFullscreenMode) {
            return;
        }
        if (call.call.join_muted) {
            ActionBarMenuSubItem actionBarMenuSubItem = this.everyoneItem;
            int i = Theme.key_voipgroup_actionBarItems;
            actionBarMenuSubItem.setColors(Theme.getColor(i), Theme.getColor(i));
            this.everyoneItem.setChecked(false);
            ActionBarMenuSubItem actionBarMenuSubItem2 = this.adminItem;
            int i2 = Theme.key_voipgroup_checkMenu;
            actionBarMenuSubItem2.setColors(Theme.getColor(i2), Theme.getColor(i2));
            this.adminItem.setChecked(true);
        } else {
            ActionBarMenuSubItem actionBarMenuSubItem3 = this.everyoneItem;
            int i3 = Theme.key_voipgroup_checkMenu;
            actionBarMenuSubItem3.setColors(Theme.getColor(i3), Theme.getColor(i3));
            this.everyoneItem.setChecked(true);
            ActionBarMenuSubItem actionBarMenuSubItem4 = this.adminItem;
            int i4 = Theme.key_voipgroup_actionBarItems;
            actionBarMenuSubItem4.setColors(Theme.getColor(i4), Theme.getColor(i4));
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
                int i5 = R.drawable.msg_voice_phone;
                if (currentAudioRoute == 0) {
                    ActionBarMenuSubItem actionBarMenuSubItem5 = this.soundItem;
                    if (VoIPService.getSharedInstance().isHeadsetPlugged()) {
                        i5 = R.drawable.msg_voice_headphones;
                    }
                    actionBarMenuSubItem5.setIcon(i5);
                    this.soundItem.setSubtext(VoIPService.getSharedInstance().isHeadsetPlugged() ? LocaleController.getString("VoipAudioRoutingHeadset", R.string.VoipAudioRoutingHeadset) : LocaleController.getString("VoipAudioRoutingPhone", R.string.VoipAudioRoutingPhone));
                } else if (currentAudioRoute == 1) {
                    if (VoipAudioManager.get().isSpeakerphoneOn()) {
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
    public /* synthetic */ void lambda$new$21(View view) {
        if (isRtmpStream()) {
            if (AndroidUtilities.checkInlinePermissions(this.parentActivity)) {
                RTMPStreamPipOverlay.show();
                dismiss();
                return;
            } else {
                AlertsCreator.createDrawOverlayPermissionDialog(this.parentActivity, null).show();
                return;
            }
        }
        if (AndroidUtilities.checkInlinePermissions(this.parentActivity)) {
            GroupCallPip.clearForce();
            dismiss();
        } else {
            AlertsCreator.createDrawOverlayGroupCallPermissionDialog(getContext()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$22(View view) {
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

    /* renamed from: org.rbmain.ui.GroupCallActivity$20, reason: invalid class name */
    class AnonymousClass20 extends AudioPlayerAlert.ClippingTextViewSwitcher {
        final /* synthetic */ Context val$context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass20(Context context, Context context2) {
            super(context);
            this.val$context = context2;
        }

        @Override // org.rbmain.ui.Components.AudioPlayerAlert.ClippingTextViewSwitcher
        protected TextView createTextView() {
            final TextView textView = new TextView(this.val$context);
            textView.setTextColor(Theme.getColor(Theme.key_voipgroup_actionBarItems));
            textView.setTextSize(1, 20.0f);
            textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView.setGravity(51);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$20$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createTextView$0(textView, view);
                }
            });
            return textView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createTextView$0(TextView textView, View view) {
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            ChatObject.Call call = groupCallActivity.call;
            if (call == null || !call.recording) {
                return;
            }
            groupCallActivity.showRecordHint(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$23(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$24(View view, int i) {
        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell = (GroupCallFullscreenAdapter.GroupCallUserCell) view;
        if (groupCallUserCell.getVideoParticipant() == null) {
            fullscreenFor(new ChatObject.VideoParticipant(groupCallUserCell.getParticipant(), false, false));
        } else {
            fullscreenFor(groupCallUserCell.getVideoParticipant());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$25(View view, int i) {
        if (showMenuForCell(view)) {
            this.listView.performHapticFeedback(0);
        }
        return false;
    }

    /* renamed from: org.rbmain.ui.GroupCallActivity$27, reason: invalid class name */
    class AnonymousClass27 extends GroupCallRenderersContainer {
        ValueAnimator uiVisibilityAnimator;

        AnonymousClass27(Context context, RecyclerView recyclerView, RecyclerView recyclerView2, ArrayList arrayList, ChatObject.Call call, GroupCallActivity groupCallActivity) {
            super(context, recyclerView, recyclerView2, arrayList, call, groupCallActivity);
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer
        protected void update() {
            super.update();
            ((BottomSheet) GroupCallActivity.this).navBarColor = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_actionBarUnscrolled), Theme.getColor(Theme.key_voipgroup_actionBar), Math.max(GroupCallActivity.this.colorProgress, GroupCallActivity.this.renderersContainer == null ? 0.0f : GroupCallActivity.this.renderersContainer.progressToFullscreenMode), 1.0f);
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity groupCallActivity = GroupCallActivity.this;
            groupCallActivity.setColorProgress(groupCallActivity.colorProgress);
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer, android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            if (view == GroupCallActivity.this.scrimRenderer) {
                return true;
            }
            return super.drawChild(canvas, view, j);
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer
        protected void onFullScreenModeChanged(boolean z) {
            GroupCallActivity.this.delayedGroupCallUpdated = z;
            if (GroupCallActivity.isTabletMode) {
                if (z || !GroupCallActivity.this.renderersContainer.inFullscreenMode) {
                    return;
                }
                GroupCallActivity groupCallActivity = GroupCallActivity.this;
                groupCallActivity.tabletGridAdapter.setVisibility(groupCallActivity.tabletVideoGridView, false, true);
                return;
            }
            if (z) {
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
            GroupCallActivity.this.buttonsBackgroundGradientView2.setVisibility(z ? 0 : 8);
            if (GroupCallActivity.this.delayedGroupCallUpdated) {
                return;
            }
            GroupCallActivity.this.applyCallParticipantUpdates(true);
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer
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
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.GroupCallActivity$27$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f$0.lambda$onUiVisibilityChanged$0(valueAnimator2);
                }
            });
            this.uiVisibilityAnimator.setDuration(350L);
            this.uiVisibilityAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.uiVisibilityAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.27.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    GroupCallActivity.this.invalidateLayoutFullscreen();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
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
        public /* synthetic */ void lambda$onUiVisibilityChanged$0(ValueAnimator valueAnimator) {
            GroupCallActivity.this.progressToHideUi = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GroupCallActivity.this.renderersContainer.setProgressToHideUi(GroupCallActivity.this.progressToHideUi);
            GroupCallActivity.this.fullscreenUsersListView.invalidate();
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity.this.buttonsContainer.invalidate();
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer
        protected boolean canHideUI() {
            return super.canHideUI() && GroupCallActivity.this.previewDialog == null;
        }

        @Override // org.rbmain.ui.Components.voip.GroupCallRenderersContainer
        protected void onBackPressed() {
            GroupCallActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$30(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, final TLRPC$Chat tLRPC$Chat, AccountInstance accountInstance, final TLRPC$InputPeer tLRPC$InputPeer, View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.scheduleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(600L);
        this.scheduleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$26(valueAnimator);
            }
        });
        this.scheduleAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
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
        accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_createGroupCall, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda52
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$29(tLRPC$Chat, tLRPC$InputPeer, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$26(ValueAnimator valueAnimator) {
        this.switchToButtonProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        updateScheduleUI(true);
        this.buttonsContainer.invalidate();
        this.listView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$29(final TLRPC$Chat tLRPC$Chat, final TLRPC$InputPeer tLRPC$InputPeer, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda42
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$new$27(tLRPC$Chat, tLRPC$InputPeer, tLRPC$TL_updateGroupCall);
                        }
                    });
                    break;
                }
                i++;
            }
            this.accountInstance.getMessagesController().processUpdates(tLRPC$Updates, false);
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$28(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$27(TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall) {
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
    public /* synthetic */ void lambda$new$28(TLRPC$TL_error tLRPC$TL_error) {
        this.accountInstance.getNotificationCenter().postNotificationName(NotificationCenter.needShowAlert, 6, tLRPC$TL_error.text);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$31(long j, Calendar calendar, int i, int i2) {
        if (i2 == 0) {
            return LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
        }
        long j2 = j + (i2 * 86400000);
        calendar.setTimeInMillis(j2);
        if (calendar.get(1) == i) {
            return LocaleController.getInstance().formatterWeek.format(j2) + " " + LocaleController.getInstance().formatterScheduleDay.format(j2);
        }
        return LocaleController.getInstance().formatterScheduleYear.format(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$32(NumberPicker numberPicker, NumberPicker numberPicker2, NumberPicker numberPicker3, NumberPicker numberPicker4, int i, int i2) {
        try {
            this.container.performHapticFeedback(3, 2);
        } catch (Exception unused) {
        }
        AlertsCreator.checkScheduleDate(this.scheduleButtonTextView, this.scheduleInfoTextView, 604800L, 2, numberPicker, numberPicker2, numberPicker3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$33(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$34(int i) {
        return String.format("%02d", Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$35(Context context, View view) {
        LaunchActivity launchActivity;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23 && (launchActivity = this.parentActivity) != null && launchActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            this.parentActivity.requestPermissions(new String[]{"android.permission.CAMERA"}, 104);
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
                PrivateVideoPreviewDialog privateVideoPreviewDialog = new PrivateVideoPreviewDialog(context, z, VoIPService.getSharedInstance().getVideoState(true) != 2) { // from class: org.rbmain.ui.GroupCallActivity.38
                    @Override // org.rbmain.ui.Components.voip.PrivateVideoPreviewDialog
                    public void onDismiss(boolean z2, boolean z3) {
                        GroupCallActivity groupCallActivity = GroupCallActivity.this;
                        boolean z4 = groupCallActivity.previewDialog.micEnabled;
                        groupCallActivity.previewDialog = null;
                        VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                        if (!z3) {
                            if (sharedInstance2 != null) {
                                sharedInstance2.setVideoState(false, 0);
                                return;
                            }
                            return;
                        }
                        if (sharedInstance2 != null) {
                            sharedInstance2.setupCaptureDevice(z2, z4);
                        }
                        if (z2 && sharedInstance2 != null) {
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

    public LaunchActivity getParentActivity() {
        return this.parentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateLayoutFullscreen() {
        int i;
        if (isRtmpStream()) {
            boolean z = (!this.renderersContainer.isUiVisible() && this.renderersContainer.inFullscreenMode && (isLandscapeMode == isRtmpLandscapeMode() || AndroidUtilities.isTablet())) ? false : true;
            Boolean bool = this.wasNotInLayoutFullscreen;
            if (bool == null || z != bool.booleanValue()) {
                int systemUiVisibility = this.containerView.getSystemUiVisibility();
                if (z) {
                    i = systemUiVisibility & (-5) & (-3);
                    getWindow().clearFlags(1024);
                    setHideSystemVerticalInsets(false);
                } else {
                    setHideSystemVerticalInsets(true);
                    i = systemUiVisibility | 4 | 2;
                    getWindow().addFlags(1024);
                }
                this.containerView.setSystemUiVisibility(i);
                this.wasNotInLayoutFullscreen = Boolean.valueOf(z);
            }
        }
    }

    public LinearLayout getMenuItemsContainer() {
        return this.menuItemsContainer;
    }

    public void fullscreenFor(final ChatObject.VideoParticipant videoParticipant) {
        ChatObject.VideoParticipant videoParticipant2;
        if (videoParticipant == null) {
            this.parentActivity.setRequestedOrientation(-1);
        }
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
                        groupCallMiniTextureView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.39
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
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
                        groupCallMiniTextureView2.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.40
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda40
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$fullscreenFor$36(arrayList);
                        }
                    });
                }
            }
            final boolean z = !this.renderersContainer.inFullscreenMode;
            ViewTreeObserver viewTreeObserver = this.listView.getViewTreeObserver();
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.GroupCallActivity.41
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
                ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.GroupCallActivity.42
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
            ViewTreeObserver.OnPreDrawListener onPreDrawListener3 = new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.GroupCallActivity.43
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
        ViewTreeObserver.OnPreDrawListener onPreDrawListener4 = new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.GroupCallActivity.44
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
    public /* synthetic */ void lambda$fullscreenFor$36(ArrayList arrayList) {
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

    private void updateScheduleUI(boolean z) {
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
        if (!z) {
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
        this.leaveButton.setData(isRtmpStream() ? R.drawable.msg_voiceclose : R.drawable.calls_decline, -1, Theme.getColor(Theme.key_voipgroup_leaveButton), 0.3f, false, LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), false, true);
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.45
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
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
        ActionBar actionBar = this.actionBar;
        if (actionBar == null || this.call == null) {
            return;
        }
        actionBar.setRtlLayout(this.rtlLayout);
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
                                spannableStringBuilder.append(UserObject.getFirstName(user), new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0);
                            } else {
                                spannableStringBuilder.append((CharSequence) UserObject.getFirstName(user));
                            }
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            spannableStringBuilder.append(chat.title, new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0);
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
        this.actionBar.getSubtitleTextView().setText(LocaleController.formatPluralString(isRtmpStream() ? "ViewersWatching" : "Participants", this.call.call.participants_count + (this.listAdapter.addSelfToCounter() ? 1 : 0)));
        if (z != this.drawSpeakingSubtitle) {
            this.drawSpeakingSubtitle = z;
            this.actionBar.invalidate();
            this.actionBar.getSubtitleTextView().setPivotX(0.0f);
            this.actionBar.getSubtitleTextView().setPivotY(this.actionBar.getMeasuredHeight() >> 1);
            this.actionBar.getSubtitleTextView().animate().scaleX(this.drawSpeakingSubtitle ? 0.98f : 1.0f).scaleY(this.drawSpeakingSubtitle ? 0.9f : 1.0f).alpha(this.drawSpeakingSubtitle ? 0.0f : 1.0f).setDuration(150L);
            AndroidUtilities.updateViewVisibilityAnimated(this.actionBar.getAdditionalSubtitleTextView(), this.drawSpeakingSubtitle);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.stopAllHeavyOperations, 2048);
        super.show();
        if (RTMPStreamPipOverlay.isVisible()) {
            RTMPStreamPipOverlay.dismiss();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
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
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.startAllHeavyOperations, 2048);
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
        ChatObject.Call call = this.call;
        if (call != null) {
            call.clearVideFramesInfo();
        }
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().clearRemoteSinks();
        }
    }

    private void setAmplitude(double d) {
        float fMin = (float) (Math.min(8500.0d, d) / 8500.0d);
        this.animateToAmplitude = fMin;
        this.animateAmplitudeDiff = (fMin - this.amplitude) / ((BlobDrawable.AMPLITUDE_SPEED * 500.0f) + 100.0f);
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public void onStateChanged(int i) {
        this.currentCallState = i;
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

    private void updateTitle(boolean z) {
        ChatObject.Call call = this.call;
        if (call == null) {
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.titleTextView.setText(LocaleController.getString("VoipChannelScheduleVoiceChat", R.string.VoipChannelScheduleVoiceChat), z);
                return;
            } else {
                this.titleTextView.setText(LocaleController.getString("VoipGroupScheduleVoiceChat", R.string.VoipGroupScheduleVoiceChat), z);
                return;
            }
        }
        if (!TextUtils.isEmpty(call.call.title)) {
            if (!this.call.call.title.equals(this.actionBar.getTitle())) {
                if (z) {
                    this.actionBar.setTitleAnimated(this.call.call.title, true, 180L);
                    this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda18
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$updateTitle$37(view);
                        }
                    });
                } else {
                    this.actionBar.setTitle(this.call.call.title);
                }
                this.titleTextView.setText(this.call.call.title, z);
            } else {
                AudioPlayerAlert.ClippingTextViewSwitcher clippingTextViewSwitcher = this.titleTextView;
                if (clippingTextViewSwitcher != null && clippingTextViewSwitcher.getTextView() != null && !this.call.call.title.equals(String.valueOf(this.titleTextView.getTextView().getText()))) {
                    this.titleTextView.setText(this.call.call.title, z);
                }
            }
        } else if (!this.currentChat.title.equals(this.actionBar.getTitle())) {
            if (z) {
                this.actionBar.setTitleAnimated(this.currentChat.title, true, 180L);
                this.actionBar.getTitleTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda15
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$updateTitle$38(view);
                    }
                });
            } else {
                this.actionBar.setTitle(this.currentChat.title);
            }
            if (ChatObject.isChannelOrGiga(this.currentChat)) {
                this.titleTextView.setText(LocaleController.getString("VoipChannelVoiceChat", R.string.VoipChannelVoiceChat), z);
            } else {
                this.titleTextView.setText(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat), z);
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
    public /* synthetic */ void lambda$updateTitle$37(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTitle$38(View view) {
        ChatObject.Call call = this.call;
        if (call == null || !call.recording) {
            return;
        }
        showRecordHint(this.actionBar.getTitleTextView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorProgress(float f) {
        this.colorProgress = f;
        GroupCallRenderersContainer groupCallRenderersContainer = this.renderersContainer;
        float fMax = Math.max(f, groupCallRenderersContainer == null ? 0.0f : groupCallRenderersContainer.progressToFullscreenMode);
        int i = Theme.key_voipgroup_actionBarUnscrolled;
        int color = Theme.getColor(i);
        int i2 = Theme.key_voipgroup_actionBar;
        int offsetColor = AndroidUtilities.getOffsetColor(color, Theme.getColor(i2), f, 1.0f);
        this.backgroundColor = offsetColor;
        this.actionBarBackground.setBackgroundColor(offsetColor);
        this.otherItem.redrawPopup(-14472653);
        this.shadowDrawable.setColorFilter(new PorterDuffColorFilter(this.backgroundColor, PorterDuff.Mode.MULTIPLY));
        this.navBarColor = AndroidUtilities.getOffsetColor(Theme.getColor(i), Theme.getColor(i2), fMax, 1.0f);
        int offsetColor2 = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_listViewBackgroundUnscrolled), Theme.getColor(Theme.key_voipgroup_listViewBackground), f, 1.0f);
        this.listViewBackgroundPaint.setColor(offsetColor2);
        this.listView.setGlowColor(offsetColor2);
        int i3 = this.muteButtonState;
        if (i3 == 3 || isGradientState(i3)) {
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
        int offsetColor3 = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_leaveButton), Theme.getColor(Theme.key_voipgroup_leaveButtonScrolled), f, 1.0f);
        this.leaveButton.setBackgroundColor(offsetColor3, offsetColor3);
        int offsetColor4 = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_lastSeenTextUnscrolled), Theme.getColor(Theme.key_voipgroup_lastSeenText), f, 1.0f);
        int offsetColor5 = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_mutedIconUnscrolled), Theme.getColor(Theme.key_voipgroup_mutedIcon), f, 1.0f);
        int childCount = this.listView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = this.listView.getChildAt(i4);
            if (childAt instanceof GroupCallTextCell) {
                ((GroupCallTextCell) childAt).setColors(offsetColor5, offsetColor4);
            } else if (childAt instanceof GroupCallUserCell) {
                ((GroupCallUserCell) childAt).setGrayIconColor(this.actionBar.getTag() != null ? Theme.key_voipgroup_mutedIcon : Theme.key_voipgroup_mutedIconUnscrolled, offsetColor5);
            } else if (childAt instanceof GroupCallInvitedCell) {
                ((GroupCallInvitedCell) childAt).setGrayIconColor(this.actionBar.getTag() != null ? Theme.key_voipgroup_mutedIcon : Theme.key_voipgroup_mutedIconUnscrolled, offsetColor5);
            }
        }
        this.containerView.invalidate();
        this.listView.invalidate();
        this.container.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLink(final boolean z) throws Resources.NotFoundException {
        String str;
        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported;
        TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(this.currentChat.id));
        if (chat == null || !this.accountInstance.getDialogsProxy().isPrivateChannel(chat)) {
            return;
        }
        final TLRPC$ChatFull chatFull = this.accountInstance.getMessagesController().getChatFull(this.currentChat.id);
        String publicUsername = ChatObject.getPublicUsername(this.currentChat);
        if (TextUtils.isEmpty(publicUsername)) {
            str = (chatFull == null || (tLRPC$TL_chatInviteExported = chatFull.exported_invite) == null) ? null : tLRPC$TL_chatInviteExported.link;
        } else {
            str = this.accountInstance.getMessagesController().linkPrefix + "/" + publicUsername;
        }
        if (TextUtils.isEmpty(str)) {
            TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
            tLRPC$TL_messages_exportChatInvite.peer = MessagesController.getInputPeer(this.currentChat);
            this.accountInstance.getDialogsProxy().getGroupLinks(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda53
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$getLink$40(chatFull, z, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        openShareAlert(true, null, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLink$40(final TLRPC$ChatFull tLRPC$ChatFull, final boolean z, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f$0.lambda$getLink$39(tLObject, tLRPC$ChatFull, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLink$39(TLObject tLObject, TLRPC$ChatFull tLRPC$ChatFull, boolean z) throws Resources.NotFoundException {
        if (tLObject instanceof TLRPC$TL_chatInviteExported) {
            TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported = (TLRPC$TL_chatInviteExported) tLObject;
            if (tLRPC$ChatFull != null) {
                tLRPC$ChatFull.exported_invite = tLRPC$TL_chatInviteExported;
            }
            openShareAlert(true, null, tLRPC$TL_chatInviteExported.link, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openShareAlert(boolean r16, java.lang.String r17, java.lang.String r18, boolean r19) throws android.content.res.Resources.NotFoundException {
        /*
            r15 = this;
            r12 = r15
            boolean r0 = r15.isRtmpStream()
            r1 = 0
            if (r0 == 0) goto La
            r0 = r1
            goto Lc
        La:
            r0 = r18
        Lc:
            if (r19 == 0) goto L2c
            if (r17 == 0) goto L12
            r0 = r17
        L12:
            org.rbmain.messenger.AndroidUtilities.addToClipboard(r0)
            boolean r0 = org.rbmain.messenger.AndroidUtilities.shouldShowClipboardToast()
            if (r0 == 0) goto Lc9
            org.rbmain.ui.Components.UndoView r1 = r15.getUndoView()
            r2 = 0
            r4 = 33
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1.showWithAction(r2, r4, r5, r6, r7, r8)
            goto Lc9
        L2c:
            org.rbmain.ui.LaunchActivity r2 = r12.parentActivity
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L5f
            org.rbmain.ui.ActionBar.ActionBarLayout r2 = r2.getActionBarLayout()
            java.util.List r2 = r2.getFragmentStack()
            org.rbmain.ui.LaunchActivity r5 = r12.parentActivity
            org.rbmain.ui.ActionBar.ActionBarLayout r5 = r5.getActionBarLayout()
            java.util.List r5 = r5.getFragmentStack()
            int r5 = r5.size()
            int r5 = r5 - r4
            java.lang.Object r2 = r2.get(r5)
            org.rbmain.ui.ActionBar.BaseFragment r2 = (org.rbmain.ui.ActionBar.BaseFragment) r2
            boolean r5 = r2 instanceof org.rbmain.ui.ChatActivity
            if (r5 == 0) goto L5f
            org.rbmain.ui.ChatActivity r2 = (org.rbmain.ui.ChatActivity) r2
            boolean r2 = r2.needEnterText()
            r12.anyEnterEventSent = r4
            r12.enterEventSent = r4
            r13 = r2
            goto L60
        L5f:
            r13 = 0
        L60:
            if (r17 == 0) goto L68
            if (r0 != 0) goto L68
            r8 = r17
            r9 = r1
            goto L6b
        L68:
            r9 = r17
            r8 = r0
        L6b:
            if (r9 != 0) goto L94
            if (r16 == 0) goto L94
            org.rbmain.tgnet.TLRPC$Chat r0 = r12.currentChat
            boolean r0 = org.rbmain.messenger.ChatObject.isChannelOrGiga(r0)
            if (r0 == 0) goto L85
            r0 = 2131892547(0x7f121943, float:1.9419845E38)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r8
            java.lang.String r2 = "VoipChannelInviteText"
            java.lang.String r0 = org.rbmain.messenger.LocaleController.formatString(r2, r0, r1)
            goto L92
        L85:
            r0 = 2131892636(0x7f12199c, float:1.9420026E38)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r8
            java.lang.String r2 = "VoipGroupInviteText"
            java.lang.String r0 = org.rbmain.messenger.LocaleController.formatString(r2, r0, r1)
        L92:
            r5 = r0
            goto L95
        L94:
            r5 = r8
        L95:
            org.rbmain.ui.GroupCallActivity$46 r14 = new org.rbmain.ui.GroupCallActivity$46
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
            org.rbmain.ui.GroupCallActivity$47 r0 = new org.rbmain.ui.GroupCallActivity$47
            r0.<init>()
            r14.setDelegate(r0)
            org.rbmain.ui.Components.ShareAlert r0 = r12.shareAlert
            org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda11 r1 = new org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda11
            r1.<init>()
            r0.setOnDismissListener(r1)
            org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda34 r0 = new org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda34
            r0.<init>()
            if (r13 == 0) goto Lc4
            r1 = 200(0xc8, double:9.9E-322)
            goto Lc6
        Lc4:
            r1 = 0
        Lc6:
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r0, r1)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.openShareAlert(boolean, java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openShareAlert$43(DialogInterface dialogInterface) {
        this.shareAlert = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openShareAlert$44() {
        ShareAlert shareAlert = this.shareAlert;
        if (shareAlert != null) {
            shareAlert.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inviteUserToCall(final int i, final boolean z) {
        final TLRPC$User user;
        if (this.call == null || (user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(i))) == null) {
            return;
        }
        final AlertDialog[] alertDialogArr = {new AlertDialog(getContext(), 3)};
        final TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall = new TLRPC$TL_phone_inviteToGroupCall();
        tLRPC$TL_phone_inviteToGroupCall.call = this.call.getInputGroupCall();
        TLRPC$TL_inputUser tLRPC$TL_inputUser = new TLRPC$TL_inputUser();
        tLRPC$TL_inputUser.user_id = user.id;
        tLRPC$TL_inputUser.access_hash = user.access_hash;
        tLRPC$TL_phone_inviteToGroupCall.users.add(tLRPC$TL_inputUser);
        final int iSendRequest = this.accountInstance.getConnectionsManager().sendRequest(tLRPC$TL_phone_inviteToGroupCall, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda51
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$inviteUserToCall$47(i, alertDialogArr, user, z, tLRPC$TL_phone_inviteToGroupCall, tLObject, tLRPC$TL_error);
            }
        });
        if (iSendRequest != 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda44
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$inviteUserToCall$49(alertDialogArr, iSendRequest);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteUserToCall$47(final int i, final AlertDialog[] alertDialogArr, final TLRPC$User tLRPC$User, final boolean z, final TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda39
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$inviteUserToCall$45(i, alertDialogArr, tLRPC$User);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$inviteUserToCall$46(alertDialogArr, z, tLRPC$TL_error, i, tLRPC$TL_phone_inviteToGroupCall);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteUserToCall$45(int i, AlertDialog[] alertDialogArr, TLRPC$User tLRPC$User) {
        ChatObject.Call call = this.call;
        if (call == null || this.delayedGroupCallUpdated) {
            return;
        }
        call.addInvitedUser(i);
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
        getUndoView().showWithAction(0L, 34, tLRPC$User, this.currentChat, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteUserToCall$46(AlertDialog[] alertDialogArr, boolean z, TLRPC$TL_error tLRPC$TL_error, int i, TLRPC$TL_phone_inviteToGroupCall tLRPC$TL_phone_inviteToGroupCall) {
        try {
            alertDialogArr[0].dismiss();
        } catch (Throwable unused) {
        }
        alertDialogArr[0] = null;
        if (z && "USER_NOT_PARTICIPANT".equals(tLRPC$TL_error.text)) {
            processSelectedOption(null, i, 3);
        } else {
            AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this.parentActivity.getActionBarLayout().getFragmentStack().get(this.parentActivity.getActionBarLayout().getFragmentStack().size() - 1), tLRPC$TL_phone_inviteToGroupCall, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteUserToCall$49(AlertDialog[] alertDialogArr, final int i) {
        if (alertDialogArr[0] == null) {
            return;
        }
        alertDialogArr[0].setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$inviteUserToCall$48(i, dialogInterface);
            }
        });
        alertDialogArr[0].show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteUserToCall$48(int i, DialogInterface dialogInterface) {
        this.accountInstance.getConnectionsManager().cancelRequest(i, true);
    }

    public void invalidateActionBarAlpha() {
        ActionBar actionBar = this.actionBar;
        actionBar.setAlpha((actionBar.getTag() != null ? 1.0f : 0.0f) * (1.0f - this.renderersContainer.progressToFullscreenMode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout(boolean z) {
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
        final boolean z2 = paddingTop <= ((float) (ActionBar.getCurrentActionBarHeight() - AndroidUtilities.dp(14.0f)));
        float currentActionBarHeight = paddingTop + ActionBar.getCurrentActionBarHeight() + AndroidUtilities.dp(14.0f);
        if ((z2 && this.actionBar.getTag() == null) || (!z2 && this.actionBar.getTag() != null)) {
            this.actionBar.setTag(z2 ? 1 : null);
            AnimatorSet animatorSet = this.actionBarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.actionBarAnimation = null;
            }
            setUseLightStatusBar(this.actionBar.getTag() == null);
            ViewPropertyAnimator duration = this.actionBar.getBackButton().animate().scaleX(z2 ? 1.0f : 0.9f).scaleY(z2 ? 1.0f : 0.9f).translationX(z2 ? 0.0f : -AndroidUtilities.dp(14.0f)).setDuration(300L);
            CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
            duration.setInterpolator(cubicBezierInterpolator).start();
            this.actionBar.getTitleTextView().animate().translationY(z2 ? 0.0f : AndroidUtilities.dp(23.0f)).setDuration(300L).setInterpolator(cubicBezierInterpolator).start();
            ObjectAnimator objectAnimator = this.subtitleYAnimator;
            if (objectAnimator != null) {
                objectAnimator.removeAllListeners();
                this.subtitleYAnimator.cancel();
            }
            SimpleTextView subtitleTextView = this.actionBar.getSubtitleTextView();
            Property property = View.TRANSLATION_Y;
            float[] fArr = new float[2];
            fArr[0] = this.actionBar.getSubtitleTextView().getTranslationY();
            fArr[1] = z2 ? 0.0f : AndroidUtilities.dp(20.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(subtitleTextView, (Property<SimpleTextView, Float>) property, fArr);
            this.subtitleYAnimator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.subtitleYAnimator.setInterpolator(cubicBezierInterpolator);
            this.subtitleYAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.48
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GroupCallActivity groupCallActivity = GroupCallActivity.this;
                    groupCallActivity.subtitleYAnimator = null;
                    groupCallActivity.actionBar.getSubtitleTextView().setTranslationY(z2 ? 0.0f : AndroidUtilities.dp(20.0f));
                }
            });
            this.subtitleYAnimator.start();
            ObjectAnimator objectAnimator2 = this.additionalSubtitleYAnimator;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            SimpleTextView additionalSubtitleTextView = this.actionBar.getAdditionalSubtitleTextView();
            Property property2 = View.TRANSLATION_Y;
            float[] fArr2 = new float[1];
            fArr2[0] = z2 ? 0.0f : AndroidUtilities.dp(20.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(additionalSubtitleTextView, (Property<SimpleTextView, Float>) property2, fArr2);
            this.additionalSubtitleYAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.additionalSubtitleYAnimator.setInterpolator(cubicBezierInterpolator);
            this.additionalSubtitleYAnimator.start();
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.actionBarAnimation = animatorSet2;
            animatorSet2.setDuration(140L);
            AnimatorSet animatorSet3 = this.actionBarAnimation;
            Animator[] animatorArr = new Animator[3];
            ActionBar actionBar = this.actionBar;
            Property property3 = View.ALPHA;
            float[] fArr3 = new float[1];
            fArr3[0] = z2 ? 1.0f : 0.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(actionBar, (Property<ActionBar, Float>) property3, fArr3);
            View view = this.actionBarBackground;
            Property property4 = View.ALPHA;
            float[] fArr4 = new float[1];
            fArr4[0] = z2 ? 1.0f : 0.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property4, fArr4);
            View view2 = this.actionBarShadow;
            Property property5 = View.ALPHA;
            float[] fArr5 = new float[1];
            fArr5[0] = z2 ? 1.0f : 0.0f;
            animatorArr[2] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property5, fArr5);
            animatorSet3.playTogether(animatorArr);
            this.actionBarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.49
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    GroupCallActivity.this.actionBarAnimation = null;
                }
            });
            this.actionBarAnimation.start();
            this.renderersContainer.pipView.setClickable(!z2 || isLandscapeMode);
        }
        if (this.scrollOffsetY != currentActionBarHeight) {
            setScrollOffsetY(currentActionBarHeight);
        }
    }

    public void invalidateScrollOffsetY() {
        setScrollOffsetY(this.scrollOffsetY);
    }

    private void setScrollOffsetY(float f) {
        int iDp;
        this.scrollOffsetY = f;
        this.listView.setTopGlowOffset((int) (f - ((FrameLayout.LayoutParams) this.listView.getLayoutParams()).topMargin));
        float fDp = f - AndroidUtilities.dp(74.0f);
        if (this.backgroundPaddingTop + fDp < ActionBar.getCurrentActionBarHeight() * 2) {
            float fMin = Math.min(1.0f, (((ActionBar.getCurrentActionBarHeight() * 2) - fDp) - this.backgroundPaddingTop) / (((r0 - this.backgroundPaddingTop) - AndroidUtilities.dp(14.0f)) + ActionBar.getCurrentActionBarHeight()));
            iDp = (int) (AndroidUtilities.dp(AndroidUtilities.isTablet() ? 17.0f : 13.0f) * fMin);
            if (Math.abs(Math.min(1.0f, fMin) - this.colorProgress) > 1.0E-4f) {
                setColorProgress(Math.min(1.0f, fMin));
            }
            float f2 = 1.0f - ((0.1f * fMin) * 1.2f);
            this.titleTextView.setScaleX(Math.max(0.9f, f2));
            this.titleTextView.setScaleY(Math.max(0.9f, f2));
            this.titleTextView.setAlpha(Math.max(0.0f, 1.0f - (fMin * 1.2f)) * (1.0f - this.renderersContainer.progressToFullscreenMode));
        } else {
            iDp = 0;
            this.titleTextView.setScaleX(1.0f);
            this.titleTextView.setScaleY(1.0f);
            this.titleTextView.setAlpha(1.0f - this.renderersContainer.progressToFullscreenMode);
            if (this.colorProgress > 1.0E-4f) {
                setColorProgress(0.0f);
            }
        }
        float f3 = iDp;
        this.menuItemsContainer.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (f - AndroidUtilities.dp(53.0f)) - f3));
        this.titleTextView.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (f - AndroidUtilities.dp(44.0f)) - f3));
        LinearLayout linearLayout = this.scheduleTimerContainer;
        if (linearLayout != null) {
            linearLayout.setTranslationY(Math.max(AndroidUtilities.dp(4.0f), (f - AndroidUtilities.dp(44.0f)) - f3));
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
    public void updateState(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
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
            updateMuteButton(i4, z);
            this.leaveButton.setData(isRtmpStream() ? R.drawable.msg_voiceclose : R.drawable.calls_decline, -1, Theme.getColor(Theme.key_voipgroup_leaveButton), 0.3f, false, LocaleController.getString("Close", R.string.Close), false, false);
            updateScheduleUI(false);
            return;
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (!sharedInstance.isSwitchingStream() && ((this.creatingServiceTime == 0 || Math.abs(SystemClock.elapsedRealtime() - this.creatingServiceTime) > 3000) && ((i3 = this.currentCallState) == 1 || i3 == 2 || i3 == 6 || i3 == 5))) {
            cancelMutePress();
            updateMuteButton(3, z);
        } else {
            if (this.userSwitchObject != null) {
                getUndoView().showWithAction(0L, 37, this.userSwitchObject, this.currentChat, null, null);
                this.userSwitchObject = null;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.call.participants.get(MessageObject.getPeerId(this.selfPeer));
            if (!sharedInstance.micSwitching && tLRPC$TL_groupCallParticipant != null && !tLRPC$TL_groupCallParticipant.can_self_unmute && tLRPC$TL_groupCallParticipant.muted && !ChatObject.canManageCalls(this.currentChat)) {
                cancelMutePress();
                if (tLRPC$TL_groupCallParticipant.raise_hand_rating != 0) {
                    updateMuteButton(4, z);
                } else {
                    updateMuteButton(2, z);
                }
                sharedInstance.setMicMute(true, false, false);
            } else {
                boolean zIsMicMute = sharedInstance.isMicMute();
                if (!sharedInstance.micSwitching && z2 && tLRPC$TL_groupCallParticipant != null && tLRPC$TL_groupCallParticipant.muted && !zIsMicMute) {
                    cancelMutePress();
                    sharedInstance.setMicMute(true, false, false);
                    zIsMicMute = true;
                }
                if (zIsMicMute) {
                    updateMuteButton(0, z);
                } else {
                    updateMuteButton(1, z);
                }
            }
        }
        boolean z5 = VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().getVideoState(false) == 2;
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.call.participants.get(MessageObject.getPeerId(this.selfPeer));
        if (((((tLRPC$TL_groupCallParticipant2 == null || tLRPC$TL_groupCallParticipant2.can_self_unmute || !tLRPC$TL_groupCallParticipant2.muted || ChatObject.canManageCalls(this.currentChat)) ? false : true) || !this.call.canRecordVideo()) && !z5) || isRtmpStream()) {
            z3 = false;
            z4 = true;
        } else {
            z3 = true;
            z4 = false;
        }
        if (z5) {
            if (z && this.flipButton.getVisibility() != 0) {
                this.flipButton.setScaleX(0.3f);
                this.flipButton.setScaleY(0.3f);
            }
            i = 1;
        } else {
            i = 0;
        }
        int i5 = i + (z4 ? 2 : 0) + (z3 ? 4 : 0);
        GroupCallRenderersContainer groupCallRenderersContainer2 = this.renderersContainer;
        int i6 = i5 + ((groupCallRenderersContainer2 == null || !groupCallRenderersContainer2.inFullscreenMode) ? 0 : 8);
        int i7 = this.buttonsVisibility;
        if (i7 != 0 && i7 != i6 && z) {
            for (int i8 = 0; i8 < this.buttonsContainer.getChildCount(); i8++) {
                View childAt = this.buttonsContainer.getChildAt(i8);
                if (childAt.getVisibility() == 0) {
                    this.buttonsAnimationParamsX.put(childAt, Float.valueOf(childAt.getX()));
                    this.buttonsAnimationParamsY.put(childAt, Float.valueOf(childAt.getY()));
                }
            }
            this.animateButtonsOnNextLayout = true;
        }
        boolean z6 = (this.buttonsVisibility | 2) != (i6 | 2);
        this.buttonsVisibility = i6;
        if (z3) {
            i2 = 8;
            this.cameraButton.setData(R.drawable.calls_video, -1, 0, 1.0f, true, LocaleController.getString("VoipCamera", R.string.VoipCamera), !z5, z);
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
        boolean z7 = this.soundButton.getVisibility() == 0;
        this.soundButton.setVisibility(z4 ? 0 : 8);
        if (z6 && z4) {
            updateSpeakerPhoneIcon(false);
        }
        if (z6) {
            float f2 = z4 ? 1.0f : 0.3f;
            if (!z) {
                this.soundButton.animate().cancel();
                this.soundButton.setScaleX(f2);
                this.soundButton.setScaleY(f2);
            } else {
                if (z4 && !z7) {
                    this.soundButton.setScaleX(0.3f);
                    this.soundButton.setScaleY(0.3f);
                }
                this.soundButton.animate().scaleX(f2).scaleY(f2).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
            }
        }
        if (this.cameraButton.getVisibility() == 0) {
            this.cameraButton.showText(true, z);
            f = 1.0f;
        } else {
            f = 0.3f;
        }
        if (this.cameraButtonScale != f) {
            this.cameraButtonScale = f;
            if (!z) {
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
        if (!z5) {
            f3 = 0.3f;
        }
        if (!z) {
            this.flipButton.animate().cancel();
            this.flipButton.setScaleX(f3);
            this.flipButton.setScaleY(f3);
        } else {
            this.flipButton.animate().scaleX(f3).scaleY(f3).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
        this.flipButton.showText(f3 == 1.0f, z);
        float f4 = z5 ? 0.3f : 1.0f;
        if (this.soundButtonScale != f4) {
            this.soundButtonScale = f4;
            if (!z) {
                this.soundButton.animate().cancel();
                this.soundButton.setScaleX(f4);
                this.soundButton.setScaleY(f4);
                return;
            }
            this.soundButton.animate().scaleX(f4).scaleY(f4).setDuration(350L).setInterpolator(CubicBezierInterpolator.DEFAULT).start();
        }
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
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

    private void updateSpeakerPhoneIcon(boolean z) {
        VoIPToggleButton voIPToggleButton = this.soundButton;
        if (voIPToggleButton == null || voIPToggleButton.getVisibility() != 0) {
            return;
        }
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        boolean z2 = false;
        if (sharedInstance == null || isRtmpStream()) {
            this.soundButton.setData(R.drawable.msg_voiceshare, -1, 0, 0.3f, true, LocaleController.getString("VoipChatShare", R.string.VoipChatShare), false, z);
            this.soundButton.setEnabled(ChatObject.isPublic(this.currentChat) || (ChatObject.hasAdminRights(this.currentChat) && ChatObject.canAddUsers(this.currentChat)), false);
            this.soundButton.setChecked(true, false);
            return;
        }
        this.soundButton.setEnabled(true, z);
        boolean z3 = sharedInstance.isBluetoothOn() || sharedInstance.isBluetoothWillOn();
        if (!z3 && sharedInstance.isSpeakerphoneOn()) {
            z2 = true;
        }
        if (z3) {
            this.soundButton.setData(R.drawable.calls_bluetooth, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingBluetooth", R.string.VoipAudioRoutingBluetooth), false, z);
        } else if (z2) {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.3f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, z);
        } else if (sharedInstance.isHeadsetPlugged()) {
            this.soundButton.setData(R.drawable.calls_headphones, -1, 0, 0.1f, true, LocaleController.getString("VoipAudioRoutingHeadset", R.string.VoipAudioRoutingHeadset), false, z);
        } else {
            this.soundButton.setData(R.drawable.calls_speaker, -1, 0, 0.1f, true, LocaleController.getString("VoipSpeaker", R.string.VoipSpeaker), false, z);
        }
        this.soundButton.setChecked(z2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateMuteButton(int r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.updateMuteButton(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMuteButton$50(float f, View view, ValueAnimator valueAnimator) {
        if (!isLandscapeMode) {
            f = AndroidUtilities.lerp(1.0f, f, this.renderersContainer.progressToFullscreenMode);
        }
        view.setScaleX(f);
        view.setScaleY(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMuteButton$51(float f, View view, View view2, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (!isLandscapeMode) {
            f = AndroidUtilities.lerp(1.0f, f, this.renderersContainer.progressToFullscreenMode);
        }
        float f2 = 1.0f - fFloatValue;
        view.setAlpha(f2);
        float f3 = ((f2 * 0.9f) + 0.1f) * f;
        view.setScaleX(f3);
        view.setScaleY(f3);
        view2.setAlpha(fFloatValue);
        float f4 = ((fFloatValue * 0.9f) + 0.1f) * f;
        view2.setScaleX(f4);
        view2.setScaleY(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateMuteButton$52(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.muteLabel[0].setAlpha(1.0f - fFloatValue);
        this.muteLabel[0].setTranslationY(AndroidUtilities.dp(5.0f) * fFloatValue);
        this.muteLabel[1].setAlpha(fFloatValue);
        this.muteLabel[1].setTranslationY(AndroidUtilities.dp((fFloatValue * 5.0f) - 5.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillColors(int i, int[] iArr) {
        if (i == 0) {
            iArr[0] = Theme.getColor(Theme.key_voipgroup_unmuteButton2);
            iArr[1] = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_soundButtonActive), Theme.getColor(Theme.key_voipgroup_soundButtonActiveScrolled), this.colorProgress, 1.0f);
            iArr[2] = Theme.getColor(Theme.key_voipgroup_soundButton);
        } else if (i == 1) {
            iArr[0] = Theme.getColor(Theme.key_voipgroup_muteButton2);
            iArr[1] = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_soundButtonActive2), Theme.getColor(Theme.key_voipgroup_soundButtonActive2Scrolled), this.colorProgress, 1.0f);
            iArr[2] = Theme.getColor(Theme.key_voipgroup_soundButton2);
        } else if (isGradientState(i)) {
            iArr[0] = Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient3);
            iArr[1] = Theme.getColor(Theme.key_voipgroup_mutedByAdminMuteButton);
            iArr[2] = Theme.getColor(Theme.key_voipgroup_mutedByAdminMuteButtonDisabled);
        } else {
            int i2 = Theme.key_voipgroup_disabledButton;
            iArr[0] = Theme.getColor(i2);
            iArr[1] = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_disabledButtonActive), Theme.getColor(Theme.key_voipgroup_disabledButtonActiveScrolled), this.colorProgress, 1.0f);
            iArr[2] = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_listViewBackgroundUnscrolled), Theme.getColor(i2), this.colorProgress, 1.0f);
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

    private void updateMuteButtonState(boolean z) {
        boolean z2;
        this.muteButton.invalidate();
        WeavingState[] weavingStateArr = this.states;
        int i = this.muteButtonState;
        boolean z3 = false;
        if (weavingStateArr[i] == null) {
            weavingStateArr[i] = new WeavingState(i);
            int i2 = this.muteButtonState;
            if (i2 == 3) {
                this.states[i2].shader = null;
            } else if (isGradientState(i2)) {
                this.states[this.muteButtonState].shader = new LinearGradient(0.0f, 400.0f, 400.0f, 0.0f, new int[]{Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient), Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient3), Theme.getColor(Theme.key_voipgroup_mutedByAdminGradient2)}, (float[]) null, Shader.TileMode.CLAMP);
            } else {
                int i3 = this.muteButtonState;
                if (i3 == 1) {
                    this.states[i3].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor(Theme.key_voipgroup_muteButton), Theme.getColor(Theme.key_voipgroup_muteButton3)}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    this.states[i3].shader = new RadialGradient(200.0f, 200.0f, 200.0f, new int[]{Theme.getColor(Theme.key_voipgroup_unmuteButton2), Theme.getColor(Theme.key_voipgroup_unmuteButton)}, (float[]) null, Shader.TileMode.CLAMP);
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
            if (weavingState2 == null || !z) {
                this.switchProgress = 1.0f;
                this.prevState = null;
            } else {
                this.switchProgress = 0.0f;
            }
        }
        if (!z) {
            WeavingState weavingState3 = this.currentState;
            if (weavingState3 != null) {
                int i5 = weavingState3.currentState;
                boolean z4 = i5 == 1 || i5 == 0;
                z2 = i5 != 3;
                z3 = z4;
            } else {
                z2 = false;
            }
            this.showWavesProgress = z3 ? 1.0f : 0.0f;
            this.showLightingProgress = z2 ? 1.0f : 0.0f;
        }
        this.buttonsContainer.invalidate();
    }

    private static void processOnLeave(ChatObject.Call call, boolean z, int i, Runnable runnable) {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().hangUp(z ? 1 : 0);
        }
        if (call != null) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = call.participants.get(i);
            if (tLRPC$TL_groupCallParticipant != null) {
                call.participants.delete(i);
                call.sortedParticipants.remove(tLRPC$TL_groupCallParticipant);
                call.visibleParticipants.remove(tLRPC$TL_groupCallParticipant);
                int i2 = 0;
                while (i2 < call.visibleVideoParticipants.size()) {
                    if (MessageObject.getPeerId(call.visibleVideoParticipants.get(i2).participant.peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                        call.visibleVideoParticipants.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                TLRPC$GroupCall tLRPC$GroupCall = call.call;
                tLRPC$GroupCall.participants_count--;
            }
            for (int i3 = 0; i3 < call.sortedParticipants.size(); i3++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = call.sortedParticipants.get(i3);
                tLRPC$TL_groupCallParticipant2.lastActiveDate = tLRPC$TL_groupCallParticipant2.lastSpeakTime;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.didStartedCall, new Object[0]);
    }

    public static void onLeaveClick(Context context, final Runnable runnable, boolean z) {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        TLRPC$Chat chat = sharedInstance.getChat();
        final ChatObject.Call call = sharedInstance.groupCall;
        final int selfId = sharedInstance.getSelfId();
        if (!ChatObject.canManageCalls(chat)) {
            processOnLeave(call, false, selfId, runnable);
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
        if (z) {
            checkBoxCellArr[0].setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        } else {
            checkBoxCellArr[0].setTextColor(Theme.getColor(Theme.key_voipgroup_actionBarItems));
            ((CheckBoxSquare) checkBoxCellArr[0].getCheckBoxView()).setColors(Theme.key_voipgroup_mutedIcon, Theme.key_voipgroup_listeningText, Theme.key_voipgroup_nameText);
        }
        checkBoxCellArr[0].setTag(0);
        if (ChatObject.isChannelOrGiga(chat)) {
            checkBoxCellArr[0].setText(LocaleController.getString("VoipChannelLeaveAlertEndChat", R.string.VoipChannelLeaveAlertEndChat), BuildConfig.FLAVOR, false, false);
        } else {
            checkBoxCellArr[0].setText(LocaleController.getString("VoipGroupLeaveAlertEndChat", R.string.VoipGroupLeaveAlertEndChat), BuildConfig.FLAVOR, false, false);
        }
        checkBoxCellArr[0].setPadding(LocaleController.isRTL ? AndroidUtilities.dp(16.0f) : AndroidUtilities.dp(8.0f), 0, LocaleController.isRTL ? AndroidUtilities.dp(8.0f) : AndroidUtilities.dp(16.0f), 0);
        linearLayout.addView(checkBoxCellArr[0], LayoutHelper.createLinear(-1, -2));
        checkBoxCellArr[0].setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupCallActivity.lambda$onLeaveClick$53(checkBoxCellArr, view);
            }
        });
        builder.setView(linearLayout);
        builder.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
        builder.setPositiveButton(LocaleController.getString("VoipGroupLeave", R.string.VoipGroupLeave), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupCallActivity.lambda$onLeaveClick$54(call, checkBoxCellArr, selfId, runnable, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        if (z) {
            builder.setDimEnabled(false);
        }
        AlertDialog alertDialogCreate = builder.create();
        if (z) {
            if (Build.VERSION.SDK_INT >= 26) {
                alertDialogCreate.getWindow().setType(2038);
            } else {
                alertDialogCreate.getWindow().setType(2003);
            }
            alertDialogCreate.getWindow().clearFlags(2);
        }
        if (!z) {
            alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
        }
        alertDialogCreate.show();
        if (z) {
            return;
        }
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_voipgroup_leaveCallMenu));
        }
        alertDialogCreate.setTextColor(Theme.getColor(Theme.key_voipgroup_actionBarItems));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLeaveClick$53(CheckBoxCell[] checkBoxCellArr, View view) {
        checkBoxCellArr[((Integer) view.getTag()).intValue()].setChecked(!checkBoxCellArr[r2.intValue()].isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onLeaveClick$54(ChatObject.Call call, CheckBoxCell[] checkBoxCellArr, int i, Runnable runnable, DialogInterface dialogInterface, int i2) {
        processOnLeave(call, checkBoxCellArr[0].isChecked(), i, runnable);
    }

    private void processSelectedOption(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, final int i, int i2) {
        TLObject chat;
        String firstName;
        TextView textView;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance == null) {
            return;
        }
        if (i > 0) {
            chat = this.accountInstance.getMessagesController().getUser(Integer.valueOf(i));
        } else {
            chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-i));
        }
        final TLObject tLObject = chat;
        boolean z = false;
        if (i2 == 0 || i2 == 2 || i2 == 3) {
            if (i2 == 0) {
                if (VoIPService.getSharedInstance() == null) {
                    return;
                }
                VoIPService.getSharedInstance().editCallMember(tLObject, Boolean.TRUE, null, null, null, null);
                getUndoView().showWithAction(0L, 30, tLObject, null, null, null);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setDialogButtonColorKey(Theme.key_voipgroup_listeningText);
            TextView textView2 = new TextView(getContext());
            int i3 = Theme.key_voipgroup_actionBarItems;
            textView2.setTextColor(Theme.getColor(i3));
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
            boolean z2 = tLObject instanceof TLRPC$User;
            if (z2) {
                TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                backupImageView.setForUserOrChat(tLRPC$User, avatarDrawable);
                firstName = UserObject.getFirstName(tLRPC$User);
            } else {
                TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable);
                firstName = tLRPC$Chat.title;
            }
            TextView textView3 = new TextView(getContext());
            textView3.setTextColor(Theme.getColor(i3));
            textView3.setTextSize(1, 20.0f);
            textView3.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            textView3.setLines(1);
            textView3.setMaxLines(1);
            textView3.setSingleLine(true);
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            if (i2 == 2) {
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
            boolean z3 = LocaleController.isRTL;
            frameLayout.addView(textView3, LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 21 : 76, 11.0f, z3 ? 76 : 21, 0.0f));
            frameLayout.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, (LocaleController.isRTL ? 5 : 3) | 48, 24.0f, 57.0f, 24.0f, 9.0f));
            if (i2 == 2) {
                builder.setPositiveButton(LocaleController.getString("VoipGroupUserRemove", R.string.VoipGroupUserRemove), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$processSelectedOption$55(tLObject, dialogInterface, i4);
                    }
                });
            } else if (z2) {
                final TLRPC$User tLRPC$User2 = (TLRPC$User) tLObject;
                builder.setPositiveButton(LocaleController.getString("VoipGroupAdd", R.string.VoipGroupAdd), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$processSelectedOption$57(tLRPC$User2, i, dialogInterface, i4);
                    }
                });
            }
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setBackgroundColor(Theme.getColor(Theme.key_voipgroup_dialogBackground));
            alertDialogCreate.show();
            if (i2 != 2 || (textView = (TextView) alertDialogCreate.getButton(-1)) == null) {
                return;
            }
            textView.setTextColor(Theme.getColor(Theme.key_voipgroup_leaveCallMenu));
            return;
        }
        if (i2 == 6) {
            this.parentActivity.switchToAccount(this.currentAccount, true);
            Bundle bundle = new Bundle();
            if (i > 0) {
                bundle.putInt("user_id", i);
            } else {
                bundle.putInt("chat_id", -i);
            }
            this.parentActivity.lambda$runLinkRequest$40(new ChatActivity(bundle));
            dismiss();
            return;
        }
        if (i2 == 8) {
            this.parentActivity.switchToAccount(this.currentAccount, true);
            BaseFragment baseFragment = this.parentActivity.getActionBarLayout().getFragmentStack().get(this.parentActivity.getActionBarLayout().getFragmentStack().size() - 1);
            if ((baseFragment instanceof ChatActivity) && ((ChatActivity) baseFragment).getDialogId() == i) {
                dismiss();
                return;
            }
            Bundle bundle2 = new Bundle();
            if (i > 0) {
                bundle2.putInt("user_id", i);
            } else {
                bundle2.putInt("chat_id", -i);
            }
            this.parentActivity.lambda$runLinkRequest$40(new ChatActivity(bundle2));
            dismiss();
            return;
        }
        if (i2 == 7) {
            sharedInstance.editCallMember(tLObject, Boolean.TRUE, null, null, Boolean.FALSE, null);
            updateMuteButton(2, true);
            return;
        }
        if (i2 != 9) {
            if (i2 == 10) {
                AlertsCreator.createChangeBioAlert(tLRPC$TL_groupCallParticipant.about, i, getContext(), this.currentAccount);
                return;
            }
            if (i2 == 11) {
                AlertsCreator.createChangeNameAlert(i, getContext(), this.currentAccount);
                return;
            }
            if (i2 == 5) {
                sharedInstance.editCallMember(tLObject, Boolean.TRUE, null, null, null, null);
                getUndoView().showWithAction(0L, 35, tLObject);
                sharedInstance.setParticipantVolume(tLRPC$TL_groupCallParticipant, 0);
                return;
            }
            if ((tLRPC$TL_groupCallParticipant.flags & 128) != 0 && tLRPC$TL_groupCallParticipant.volume == 0) {
                tLRPC$TL_groupCallParticipant.volume = 10000;
                tLRPC$TL_groupCallParticipant.volume_by_admin = false;
                sharedInstance.editCallMember(tLObject, Boolean.FALSE, null, 10000, null, null);
            } else {
                sharedInstance.editCallMember(tLObject, Boolean.FALSE, null, null, null, null);
            }
            sharedInstance.setParticipantVolume(tLRPC$TL_groupCallParticipant, ChatObject.getParticipantVolume(tLRPC$TL_groupCallParticipant));
            getUndoView().showWithAction(0L, i2 == 1 ? 31 : 36, tLObject, null, null, null);
            return;
        }
        ImageUpdater imageUpdater = this.currentAvatarUpdater;
        if (imageUpdater == null || !imageUpdater.isUploadingImage()) {
            TLRPC$User currentUser = this.accountInstance.getUserConfig().getCurrentUser();
            ImageUpdater imageUpdater2 = new ImageUpdater(false);
            this.currentAvatarUpdater = imageUpdater2;
            imageUpdater2.setOpenWithFrontfaceCamera(true);
            this.currentAvatarUpdater.setForceDarkTheme(true);
            this.currentAvatarUpdater.setSearchAvailable(true, true);
            this.currentAvatarUpdater.parentFragment = this.parentActivity.getActionBarLayout().getLastFragment();
            ImageUpdater imageUpdater3 = this.currentAvatarUpdater;
            AvatarUpdaterDelegate avatarUpdaterDelegate = new AvatarUpdaterDelegate(i);
            this.avatarUpdaterDelegate = avatarUpdaterDelegate;
            imageUpdater3.setDelegate(avatarUpdaterDelegate);
            ImageUpdater imageUpdater4 = this.currentAvatarUpdater;
            TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = currentUser.photo;
            if (tLRPC$UserProfilePhoto != null && tLRPC$UserProfilePhoto.photo_big != null && !(tLRPC$UserProfilePhoto instanceof TLRPC$TL_userProfilePhotoEmpty)) {
                z = true;
            }
            imageUpdater4.openMenu(z, new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSelectedOption$58();
                }
            }, new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda13
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GroupCallActivity.lambda$processSelectedOption$59(dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processSelectedOption$55(TLObject tLObject, DialogInterface dialogInterface, int i) {
        if (tLObject instanceof TLRPC$User) {
            TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
            this.accountInstance.getMessagesController().deleteParticipantFromChat(this.currentChat.id, tLRPC$User, null);
            getUndoView().showWithAction(0L, 32, tLRPC$User, null, null, null);
        } else {
            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
            this.accountInstance.getMessagesController().deleteParticipantFromChat(this.currentChat.id, null, tLRPC$Chat, null, false, false);
            getUndoView().showWithAction(0L, 32, tLRPC$Chat, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processSelectedOption$57(TLRPC$User tLRPC$User, final int i, DialogInterface dialogInterface, int i2) {
        this.accountInstance.getMessagesController().addUserToChat(this.currentChat.id, tLRPC$User, 0, null, this.parentActivity.getActionBarLayout().getFragmentStack().get(this.parentActivity.getActionBarLayout().getFragmentStack().size() - 1), new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$processSelectedOption$56(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processSelectedOption$56(int i) {
        inviteUserToCall(i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processSelectedOption$58() {
        this.accountInstance.getMessagesController().deleteUserPhoto(null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showMenuForCell(View view) {
        GroupCallUserCell groupCallUserCell;
        LinearLayout linearLayout;
        ScrollView scrollView;
        boolean z;
        ImageLocation forUserOrChat;
        ImageLocation forUserOrChat2;
        boolean z2;
        AvatarUpdaterDelegate avatarUpdaterDelegate;
        int x;
        float y;
        float y2;
        int measuredHeight;
        int y3;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        int i4;
        String str4;
        if (this.itemAnimator.isRunning() || getContext() == null) {
            return false;
        }
        if (this.avatarPriviewTransitionInProgress || this.avatarsPreviewShowed) {
            dismissAvatarPreview(true);
            return false;
        }
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
            this.scrimPopupWindow = null;
            return false;
        }
        clearScrimView();
        if (view instanceof GroupCallGridCell) {
            GroupCallGridCell groupCallGridCell = (GroupCallGridCell) view;
            if (groupCallGridCell.getParticipant() == this.call.videoNotAvailableParticipant) {
                return false;
            }
            groupCallUserCell = new GroupCallUserCell(groupCallGridCell.getContext());
            groupCallUserCell.setData(this.accountInstance, groupCallGridCell.getParticipant().participant, this.call, MessageObject.getPeerId(this.selfPeer), null, false);
            AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable = groupCallUserCell.rightDrawable;
            if (swapAnimatedEmojiDrawable != null) {
                swapAnimatedEmojiDrawable.play();
            }
            this.hasScrimAnchorView = false;
            this.scrimGridView = groupCallGridCell;
            this.scrimRenderer = groupCallGridCell.getRenderer();
            if (!isTabletMode && !isLandscapeMode) {
                this.containerView.addView(groupCallUserCell, LayoutHelper.createFrame(-1, -2.0f, 0, 14.0f, 0.0f, 14.0f, 0.0f));
            }
        } else if (view instanceof GroupCallFullscreenAdapter.GroupCallUserCell) {
            GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell2 = (GroupCallFullscreenAdapter.GroupCallUserCell) view;
            if (groupCallUserCell2.getParticipant() == this.call.videoNotAvailableParticipant.participant) {
                return false;
            }
            groupCallUserCell = new GroupCallUserCell(groupCallUserCell2.getContext());
            groupCallUserCell.setData(this.accountInstance, groupCallUserCell2.getParticipant(), this.call, MessageObject.getPeerId(this.selfPeer), null, false);
            AnimatedEmojiDrawable.SwapAnimatedEmojiDrawable swapAnimatedEmojiDrawable2 = groupCallUserCell.rightDrawable;
            if (swapAnimatedEmojiDrawable2 != null) {
                swapAnimatedEmojiDrawable2.play();
            }
            this.hasScrimAnchorView = false;
            this.scrimFullscreenView = groupCallUserCell2;
            GroupCallMiniTextureView renderer = groupCallUserCell2.getRenderer();
            this.scrimRenderer = renderer;
            if (renderer != null && renderer.showingInFullscreen) {
                this.scrimRenderer = null;
            }
            this.containerView.addView(groupCallUserCell, LayoutHelper.createFrame(-1, -2.0f, 0, 14.0f, 0.0f, 14.0f, 0.0f));
        } else {
            groupCallUserCell = (GroupCallUserCell) view;
            this.hasScrimAnchorView = true;
        }
        GroupCallUserCell groupCallUserCell3 = groupCallUserCell;
        if (groupCallUserCell3 == null) {
            return false;
        }
        boolean z3 = (isLandscapeMode || isTabletMode || AndroidUtilities.isInMultiwindow) ? false : true;
        final TLRPC$TL_groupCallParticipant participant = groupCallUserCell3.getParticipant();
        if (participant == null) {
            return false;
        }
        final Rect rect = new Rect();
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getContext());
        actionBarPopupWindowLayout.setBackgroundDrawable(null);
        actionBarPopupWindowLayout.setPadding(0, 0, 0, 0);
        actionBarPopupWindowLayout.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.GroupCallActivity.53
            private int[] pos = new int[2];

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    if (GroupCallActivity.this.scrimPopupWindow != null && GroupCallActivity.this.scrimPopupWindow.isShowing()) {
                        View contentView = GroupCallActivity.this.scrimPopupWindow.getContentView();
                        contentView.getLocationInWindow(this.pos);
                        Rect rect2 = rect;
                        int[] iArr = this.pos;
                        rect2.set(iArr[0], iArr[1], iArr[0] + contentView.getMeasuredWidth(), this.pos[1] + contentView.getMeasuredHeight());
                        if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            GroupCallActivity.this.scrimPopupWindow.dismiss();
                        }
                    }
                } else if (motionEvent.getActionMasked() == 4 && GroupCallActivity.this.scrimPopupWindow != null && GroupCallActivity.this.scrimPopupWindow.isShowing()) {
                    GroupCallActivity.this.scrimPopupWindow.dismiss();
                }
                return false;
            }
        });
        actionBarPopupWindowLayout.setDispatchKeyEventListener(new ActionBarPopupWindow.OnDispatchKeyEventListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda55
            @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow.OnDispatchKeyEventListener
            public final void onDispatchKeyEvent(KeyEvent keyEvent) {
                this.f$0.lambda$showMenuForCell$60(keyEvent);
            }
        });
        final LinearLayout linearLayout2 = new LinearLayout(getContext());
        final LinearLayout linearLayout3 = !participant.muted_by_you ? new LinearLayout(getContext()) : null;
        this.currentOptionsLayout = linearLayout2;
        final LinearLayout linearLayout4 = new LinearLayout(this, getContext()) { // from class: org.rbmain.ui.GroupCallActivity.54
            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i5, int i6) {
                linearLayout2.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                LinearLayout linearLayout5 = linearLayout3;
                if (linearLayout5 != null) {
                    linearLayout5.measure(View.MeasureSpec.makeMeasureSpec(linearLayout2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                    setMeasuredDimension(linearLayout2.getMeasuredWidth(), linearLayout2.getMeasuredHeight() + linearLayout3.getMeasuredHeight());
                } else {
                    setMeasuredDimension(linearLayout2.getMeasuredWidth(), linearLayout2.getMeasuredHeight());
                }
            }
        };
        linearLayout4.setMinimumWidth(AndroidUtilities.dp(240.0f));
        linearLayout4.setOrientation(1);
        int offsetColor = AndroidUtilities.getOffsetColor(Theme.getColor(Theme.key_voipgroup_listViewBackgroundUnscrolled), Theme.getColor(Theme.key_voipgroup_listViewBackground), this.colorProgress, 1.0f);
        linearLayout2.setMinimumWidth(AndroidUtilities.dp(240.0f));
        linearLayout2.setOrientation(1);
        Drawable drawableMutate = getContext().getResources().getDrawable(R.drawable.popup_fixed_alert).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(offsetColor, PorterDuff.Mode.MULTIPLY));
        linearLayout2.setBackgroundDrawable(drawableMutate);
        linearLayout4.addView(linearLayout2, LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 0.0f, 0.0f));
        if (Build.VERSION.SDK_INT >= 21) {
            linearLayout = linearLayout4;
            scrollView = new ScrollView(this, getContext(), null, 0, R.style.scrollbarShapeStyle) { // from class: org.rbmain.ui.GroupCallActivity.55
                @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
                protected void onMeasure(int i5, int i6) {
                    super.onMeasure(i5, i6);
                    setMeasuredDimension(linearLayout4.getMeasuredWidth(), getMeasuredHeight());
                }
            };
        } else {
            linearLayout = linearLayout4;
            scrollView = new ScrollView(getContext());
        }
        scrollView.setClipToPadding(false);
        actionBarPopupWindowLayout.addView(scrollView, LayoutHelper.createFrame(-2, -2.0f));
        int peerId = MessageObject.getPeerId(participant.peer);
        ArrayList arrayList = new ArrayList(2);
        ArrayList arrayList2 = new ArrayList(2);
        final ArrayList arrayList3 = new ArrayList(2);
        boolean z4 = participant.canManageCallVoiceChat;
        if (groupCallUserCell3.isSelfUser()) {
            if (groupCallUserCell3.isHandRaised()) {
                arrayList.add(LocaleController.getString("VoipGroupCancelRaiseHand", R.string.VoipGroupCancelRaiseHand));
                arrayList2.add(Integer.valueOf(R.drawable.msg_handdown));
                arrayList3.add(7);
            }
            if (groupCallUserCell3.hasAvatarSet()) {
                i = R.string.VoipAddPhoto;
                str = "VoipAddPhoto";
            } else {
                i = R.string.VoipSetNewPhoto;
                str = "VoipSetNewPhoto";
            }
            arrayList.add(LocaleController.getString(str, i));
            arrayList2.add(Integer.valueOf(R.drawable.msg_addphoto));
            arrayList3.add(9);
            if (peerId > 0) {
                if (TextUtils.isEmpty(participant.about)) {
                    i4 = R.string.VoipAddBio;
                    str4 = "VoipAddBio";
                } else {
                    i4 = R.string.VoipEditBio;
                    str4 = "VoipEditBio";
                }
                arrayList.add(LocaleController.getString(str4, i4));
            } else {
                if (TextUtils.isEmpty(participant.about)) {
                    i2 = R.string.VoipAddDescription;
                    str2 = "VoipAddDescription";
                } else {
                    i2 = R.string.VoipEditDescription;
                    str2 = "VoipEditDescription";
                }
                arrayList.add(LocaleController.getString(str2, i2));
            }
            arrayList2.add(Integer.valueOf(TextUtils.isEmpty(participant.about) ? R.drawable.msg_addbio : R.drawable.msg_info));
            arrayList3.add(10);
            if (peerId > 0) {
                i3 = R.string.VoipEditName;
                str3 = "VoipEditName";
            } else {
                i3 = R.string.VoipEditTitle;
                str3 = "VoipEditTitle";
            }
            arrayList.add(LocaleController.getString(str3, i3));
            arrayList2.add(Integer.valueOf(R.drawable.msg_edit));
            arrayList3.add(11);
        } else if (ChatObject.canManageCalls(this.currentChat)) {
            if (z4 && participant.muted) {
                z = z4;
            } else if (!participant.muted || participant.can_self_unmute) {
                z = z4;
                arrayList.add(LocaleController.getString("VoipGroupMute", R.string.VoipGroupMute));
                arrayList2.add(Integer.valueOf(R.drawable.msg_voice_muted));
                arrayList3.add(0);
            } else {
                arrayList.add(LocaleController.getString("VoipGroupAllowToSpeak", R.string.VoipGroupAllowToSpeak));
                z = z4;
                if (participant.raise_hand_rating != 0) {
                    arrayList2.add(Integer.valueOf(R.drawable.msg_allowspeak));
                } else {
                    arrayList2.add(Integer.valueOf(R.drawable.msg_voice_unmuted));
                }
                arrayList3.add(1);
            }
            int i5 = participant.peer.channel_id;
            if (i5 != 0 && !ChatObject.isMegagroup(this.currentAccount, i5)) {
                arrayList.add(LocaleController.getString("VoipGroupOpenChannel", R.string.VoipGroupOpenChannel));
                arrayList2.add(Integer.valueOf(R.drawable.msg_channel));
                arrayList3.add(8);
            } else {
                arrayList.add(LocaleController.getString("VoipGroupOpenProfile", R.string.VoipGroupOpenProfile));
                arrayList2.add(Integer.valueOf(R.drawable.msg_openprofile));
                arrayList3.add(6);
            }
            if (!z && ChatObject.canBlockUsers(this.currentChat)) {
                arrayList.add(LocaleController.getString("VoipGroupUserRemove", R.string.VoipGroupUserRemove));
                arrayList2.add(Integer.valueOf(R.drawable.msg_block2));
                arrayList3.add(2);
            }
        } else {
            int i6 = participant.peer.channel_id;
            if (i6 != 0 && !ChatObject.isMegagroup(this.currentAccount, i6)) {
                arrayList.add(LocaleController.getString("VoipGroupOpenChannel", R.string.VoipGroupOpenChannel));
                arrayList2.add(Integer.valueOf(R.drawable.msg_msgbubble3));
                arrayList3.add(8);
            } else {
                arrayList.add(LocaleController.getString("VoipGroupOpenChat", R.string.VoipGroupOpenChat));
                arrayList2.add(Integer.valueOf(R.drawable.msg_msgbubble3));
                arrayList3.add(6);
            }
        }
        int size = arrayList.size();
        final int i7 = 0;
        while (i7 < size) {
            boolean z5 = z3;
            ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(getContext(), i7 == 0, i7 == size + (-1));
            if (((Integer) arrayList3.get(i7)).intValue() != 2) {
                int i8 = Theme.key_voipgroup_actionBarItems;
                actionBarMenuSubItem.setColors(Theme.getColor(i8), Theme.getColor(i8));
            } else {
                int i9 = Theme.key_voipgroup_leaveCallMenu;
                actionBarMenuSubItem.setColors(Theme.getColor(i9), Theme.getColor(i9));
            }
            actionBarMenuSubItem.setSelectorColor(Theme.getColor(Theme.key_voipgroup_listSelector));
            actionBarMenuSubItem.setTextAndIcon((CharSequence) arrayList.get(i7), ((Integer) arrayList2.get(i7)).intValue());
            linearLayout2.addView(actionBarMenuSubItem);
            actionBarMenuSubItem.setTag(arrayList3.get(i7));
            actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$showMenuForCell$61(i7, arrayList3, participant, view2);
                }
            });
            i7++;
            z3 = z5;
        }
        boolean z6 = z3;
        scrollView.addView(linearLayout, LayoutHelper.createScroll(-2, -2, 51));
        this.listView.stopScroll();
        this.layoutManager.setCanScrollVertically(false);
        this.scrimView = groupCallUserCell3;
        groupCallUserCell3.setAboutVisible(true);
        this.containerView.invalidate();
        this.listView.invalidate();
        AnimatorSet animatorSet = this.scrimAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.scrimPopupLayout = actionBarPopupWindowLayout;
        if (peerId > 0) {
            TLRPC$User user = this.accountInstance.getMessagesController().getUser(Integer.valueOf(peerId));
            forUserOrChat = ImageLocation.getForUserOrChat(user, 0);
            forUserOrChat2 = ImageLocation.getForUserOrChat(user, 1);
            if (MessagesController.getInstance(this.currentAccount).getUserFull(peerId) == null) {
                MessagesController.getInstance(this.currentAccount).loadUserInfo(user, false, 0);
            }
        } else {
            TLRPC$Chat chat = this.accountInstance.getMessagesController().getChat(Integer.valueOf(-peerId));
            forUserOrChat = ImageLocation.getForUserOrChat(chat, 0);
            forUserOrChat2 = ImageLocation.getForUserOrChat(chat, 1);
        }
        GroupCallMiniTextureView groupCallMiniTextureView = this.scrimRenderer;
        boolean z7 = groupCallMiniTextureView != null && groupCallMiniTextureView.isAttached();
        if (forUserOrChat != null || z7) {
            if (z6) {
                this.avatarsViewPager.setParentAvatarImage(this.scrimView.getAvatarImageView());
                this.avatarsViewPager.setData(peerId);
                this.avatarsViewPager.setCreateThumbFromParent(true);
                this.avatarsViewPager.initIfEmpty(null, forUserOrChat, forUserOrChat2, true);
                GroupCallMiniTextureView groupCallMiniTextureView2 = this.scrimRenderer;
                if (groupCallMiniTextureView2 != null) {
                    groupCallMiniTextureView2.setShowingAsScrimView(true, true);
                }
                if (MessageObject.getPeerId(this.selfPeer) == peerId && this.currentAvatarUpdater != null && (avatarUpdaterDelegate = this.avatarUpdaterDelegate) != null && avatarUpdaterDelegate.avatar != null) {
                    this.avatarsViewPager.addUploadingImage(this.avatarUpdaterDelegate.uploadingImageLocation, ImageLocation.getForLocal(this.avatarUpdaterDelegate.avatar));
                }
            }
            z2 = z6;
        } else {
            z2 = false;
        }
        if (z2) {
            this.avatarsPreviewShowed = true;
            actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
            this.containerView.addView(this.scrimPopupLayout, LayoutHelper.createFrame(-2, -2.0f));
            this.useBlur = true;
            prepareBlurBitmap();
            this.avatarPriviewTransitionInProgress = true;
            this.avatarPreviewContainer.setVisibility(0);
            runAvatarPreviewTransition(true, groupCallUserCell3);
            GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell4 = this.scrimFullscreenView;
            if (groupCallUserCell4 == null) {
                return true;
            }
            groupCallUserCell4.getAvatarImageView().setAlpha(0.0f);
            return true;
        }
        this.avatarsPreviewShowed = false;
        int i10 = -2;
        ActionBarPopupWindow actionBarPopupWindow2 = new ActionBarPopupWindow(actionBarPopupWindowLayout, i10, i10) { // from class: org.rbmain.ui.GroupCallActivity.56
            @Override // org.rbmain.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
            public void dismiss() {
                super.dismiss();
                if (GroupCallActivity.this.scrimPopupWindow != this) {
                    return;
                }
                GroupCallActivity.this.scrimPopupWindow = null;
                if (GroupCallActivity.this.scrimAnimatorSet != null) {
                    GroupCallActivity.this.scrimAnimatorSet.cancel();
                    GroupCallActivity.this.scrimAnimatorSet = null;
                }
                GroupCallActivity.this.layoutManager.setCanScrollVertically(true);
                GroupCallActivity.this.scrimAnimatorSet = new AnimatorSet();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(ObjectAnimator.ofInt(GroupCallActivity.this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0));
                GroupCallActivity.this.scrimAnimatorSet.playTogether(arrayList4);
                GroupCallActivity.this.scrimAnimatorSet.setDuration(220L);
                GroupCallActivity.this.scrimAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.56.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        GroupCallActivity.this.clearScrimView();
                        ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
                        GroupCallActivity.this.listView.invalidate();
                        if (GroupCallActivity.this.delayedGroupCallUpdated) {
                            GroupCallActivity.this.delayedGroupCallUpdated = false;
                            GroupCallActivity.this.applyCallParticipantUpdates(true);
                        }
                    }
                });
                GroupCallActivity.this.scrimAnimatorSet.start();
            }
        };
        this.scrimPopupWindow = actionBarPopupWindow2;
        actionBarPopupWindow2.setPauseNotifications(true);
        this.scrimPopupWindow.setDismissAnimationDuration(220);
        this.scrimPopupWindow.setOutsideTouchable(true);
        this.scrimPopupWindow.setClippingEnabled(true);
        this.scrimPopupWindow.setAnimationStyle(R.style.PopupContextAnimation);
        this.scrimPopupWindow.setFocusable(true);
        actionBarPopupWindowLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        this.scrimPopupWindow.setInputMethodMode(2);
        this.scrimPopupWindow.setSoftInputMode(0);
        this.scrimPopupWindow.getContentView().setFocusableInTouchMode(true);
        GroupCallFullscreenAdapter.GroupCallUserCell groupCallUserCell5 = this.scrimFullscreenView;
        if (groupCallUserCell5 != null) {
            if (isLandscapeMode) {
                x = (((int) ((groupCallUserCell5.getX() + this.fullscreenUsersListView.getX()) + this.renderersContainer.getX())) - actionBarPopupWindowLayout.getMeasuredWidth()) + AndroidUtilities.dp(32.0f);
                y3 = ((int) ((this.scrimFullscreenView.getY() + this.fullscreenUsersListView.getY()) + this.renderersContainer.getY())) - AndroidUtilities.dp(6.0f);
                this.scrimPopupWindow.showAtLocation(this.listView, 51, x, y3);
                this.scrimAnimatorSet = new AnimatorSet();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(ObjectAnimator.ofInt(this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0, 100));
                this.scrimAnimatorSet.playTogether(arrayList4);
                this.scrimAnimatorSet.setDuration(150L);
                this.scrimAnimatorSet.start();
                return true;
            }
            x = ((int) ((groupCallUserCell5.getX() + this.fullscreenUsersListView.getX()) + this.renderersContainer.getX())) - AndroidUtilities.dp(14.0f);
            y = ((this.scrimFullscreenView.getY() + this.fullscreenUsersListView.getY()) + this.renderersContainer.getY()) - actionBarPopupWindowLayout.getMeasuredHeight();
        } else {
            x = (int) (((this.listView.getX() + this.listView.getMeasuredWidth()) + AndroidUtilities.dp(8.0f)) - actionBarPopupWindowLayout.getMeasuredWidth());
            if (this.hasScrimAnchorView) {
                y2 = this.listView.getY() + groupCallUserCell3.getY();
                measuredHeight = groupCallUserCell3.getClipHeight();
            } else if (this.scrimGridView != null) {
                y2 = this.listView.getY() + this.scrimGridView.getY();
                measuredHeight = this.scrimGridView.getMeasuredHeight();
            } else {
                y = this.listView.getY();
            }
            y = y2 + measuredHeight;
        }
        y3 = (int) y;
        this.scrimPopupWindow.showAtLocation(this.listView, 51, x, y3);
        this.scrimAnimatorSet = new AnimatorSet();
        ArrayList arrayList42 = new ArrayList();
        arrayList42.add(ObjectAnimator.ofInt(this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0, 100));
        this.scrimAnimatorSet.playTogether(arrayList42);
        this.scrimAnimatorSet.setDuration(150L);
        this.scrimAnimatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMenuForCell$60(KeyEvent keyEvent) {
        ActionBarPopupWindow actionBarPopupWindow;
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0 && (actionBarPopupWindow = this.scrimPopupWindow) != null && actionBarPopupWindow.isShowing()) {
            this.scrimPopupWindow.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMenuForCell$61(int i, ArrayList arrayList, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, View view) {
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
    private void runAvatarPreviewTransition(final boolean r18, org.rbmain.ui.Cells.GroupCallUserCell r19) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.runAvatarPreviewTransition(boolean, org.rbmain.ui.Cells.GroupCallUserCell):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runAvatarPreviewTransition$62(float f, float f2, float f3, int i, ValueAnimator valueAnimator) {
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
    public void dismissAvatarPreview(boolean z) {
        if (this.avatarPriviewTransitionInProgress || !this.avatarsPreviewShowed) {
            return;
        }
        if (z) {
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
            if (GroupCallActivity.this.isRtmpStream() || this.hasSelfUser || VoIPService.getSharedInstance() == null) {
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateRows() {
            /*
                Method dump skipped, instructions count: 225
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.ListAdapter.updateRows():void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            updateRows();
            super.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemChanged(int i) {
            updateRows();
            super.notifyItemChanged(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int i, int i2) {
            updateRows();
            super.notifyItemRangeChanged(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeChanged(int i, int i2, Object obj) {
            updateRows();
            super.notifyItemRangeChanged(i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemMoved(int i, int i2) {
            updateRows();
            super.notifyItemMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeInserted(int i, int i2) {
            updateRows();
            super.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRemoved(int i) {
            updateRows();
            super.notifyItemRemoved(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyItemRangeRemoved(int i, int i2) {
            updateRows();
            super.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 1) {
                GroupCallUserCell groupCallUserCell = (GroupCallUserCell) viewHolder.itemView;
                int i = GroupCallActivity.this.actionBar.getTag() != null ? Theme.key_voipgroup_mutedIcon : Theme.key_voipgroup_mutedIconUnscrolled;
                groupCallUserCell.setGrayIconColor(i, Theme.getColor(i));
                groupCallUserCell.setDrawDivider(viewHolder.getAdapterPosition() != getItemCount() - 2);
                return;
            }
            if (itemViewType == 2) {
                GroupCallInvitedCell groupCallInvitedCell = (GroupCallInvitedCell) viewHolder.itemView;
                int i2 = GroupCallActivity.this.actionBar.getTag() != null ? Theme.key_voipgroup_mutedIcon : Theme.key_voipgroup_mutedIconUnscrolled;
                groupCallInvitedCell.setGrayIconColor(i2, Theme.getColor(i2));
                groupCallInvitedCell.setDrawDivider(viewHolder.getAdapterPosition() != getItemCount() - 2);
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
                Method dump skipped, instructions count: 546
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.GroupCallActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return (itemViewType == 3 || itemViewType == 4 || itemViewType == 5 || itemViewType == 6) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view;
            if (i == 0) {
                view = new GroupCallTextCell(this, this.mContext) { // from class: org.rbmain.ui.GroupCallActivity.ListAdapter.1
                    @Override // org.rbmain.ui.Cells.GroupCallTextCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(i2)), 1073741824), i3);
                        } else {
                            super.onMeasure(i2, i3);
                        }
                    }
                };
            } else if (i == 1) {
                view = new GroupCallUserCell(this.mContext) { // from class: org.rbmain.ui.GroupCallActivity.ListAdapter.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // org.rbmain.ui.Cells.GroupCallUserCell
                    /* renamed from: onMuteClick */
                    public void lambda$new$5(GroupCallUserCell groupCallUserCell) {
                        GroupCallActivity.this.showMenuForCell(groupCallUserCell);
                    }

                    @Override // org.rbmain.ui.Cells.GroupCallUserCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(i2)), 1073741824), i3);
                        } else {
                            super.onMeasure(i2, i3);
                        }
                    }
                };
            } else if (i != 2) {
                boolean z = false;
                if (i == 4) {
                    view = new GroupCallGridCell(this.mContext, z) { // from class: org.rbmain.ui.GroupCallActivity.ListAdapter.4
                        @Override // org.rbmain.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
                        protected void onAttachedToWindow() {
                            super.onAttachedToWindow();
                            if (GroupCallActivity.this.listView.getVisibility() == 0 && GroupCallActivity.this.listViewVideoVisibility) {
                                GroupCallActivity.this.attachRenderer(this, true);
                            }
                        }

                        @Override // org.rbmain.ui.Components.voip.GroupCallGridCell, android.view.ViewGroup, android.view.View
                        protected void onDetachedFromWindow() {
                            super.onDetachedFromWindow();
                            GroupCallActivity.this.attachRenderer(this, false);
                        }
                    };
                } else if (i == 5) {
                    view = new View(this, this.mContext) { // from class: org.rbmain.ui.GroupCallActivity.ListAdapter.5
                        @Override // android.view.View
                        protected void onMeasure(int i2, int i3) {
                            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(GroupCallActivity.isLandscapeMode ? 0.0f : 8.0f), 1073741824));
                        }
                    };
                } else if (i == 6) {
                    TextView textView = new TextView(this.mContext);
                    textView.setTextColor(-8682615);
                    textView.setTextSize(1, 13.0f);
                    textView.setGravity(1);
                    textView.setPadding(0, 0, 0, AndroidUtilities.dp(10.0f));
                    if (ChatObject.isChannelOrGiga(GroupCallActivity.this.currentChat)) {
                        textView.setText(LocaleController.formatString("VoipChannelVideoNotAvailableAdmin", R.string.VoipChannelVideoNotAvailableAdmin, LocaleController.formatPluralString("Participants", GroupCallActivity.this.accountInstance.getMessagesController().groupCallVideoMaxParticipants)));
                    } else {
                        textView.setText(LocaleController.formatString("VoipVideoNotAvailableAdmin", R.string.VoipVideoNotAvailableAdmin, LocaleController.formatPluralString("Members", GroupCallActivity.this.accountInstance.getMessagesController().groupCallVideoMaxParticipants)));
                    }
                    view = textView;
                } else {
                    view = new View(this.mContext);
                }
            } else {
                view = new GroupCallInvitedCell(this, this.mContext) { // from class: org.rbmain.ui.GroupCallActivity.ListAdapter.3
                    @Override // org.rbmain.ui.Cells.GroupCallInvitedCell, android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int i2, int i3) {
                        if (AndroidUtilities.isTablet()) {
                            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(420.0f), View.MeasureSpec.getSize(i2)), 1073741824), i3);
                        } else {
                            super.onMeasure(i2, i3);
                        }
                    }
                };
            }
            view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == this.lastRow) {
                return 3;
            }
            if (i == this.addMemberRow) {
                return 0;
            }
            if (i == this.videoGridDividerRow) {
                return 5;
            }
            if (i >= this.usersStartRow && i < this.usersEndRow) {
                return 1;
            }
            if (i < this.usersVideoGridStartRow || i >= this.usersVideoGridEndRow) {
                return i == this.videoNotAvailableRow ? 6 : 2;
            }
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void attachRenderer(GroupCallGridCell groupCallGridCell, boolean z) {
        if (isDismissed()) {
            return;
        }
        if (z && groupCallGridCell.getRenderer() == null) {
            groupCallGridCell.setRenderer(GroupCallMiniTextureView.getOrCreate(this.attachedRenderers, this.renderersContainer, groupCallGridCell, null, null, groupCallGridCell.getParticipant(), this.call, this));
        } else {
            if (z || groupCallGridCell.getRenderer() == null) {
                return;
            }
            groupCallGridCell.getRenderer().setPrimaryView(null);
            groupCallGridCell.setRenderer(null);
        }
    }

    public void setOldRows(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.oldAddMemberRow = i;
        this.oldUsersStartRow = i2;
        this.oldUsersEndRow = i3;
        this.oldInvitedStartRow = i4;
        this.oldInvitedEndRow = i5;
        this.oldUsersVideoStartRow = i6;
        this.oldUsersVideoEndRow = i7;
        this.oldVideoDividerRow = i8;
        this.oldVideoNotAvailableRow = i9;
    }

    private static class UpdateCallback implements ListUpdateCallback {
        final RecyclerView.Adapter adapter;

        private UpdateCallback(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.adapter.notifyItemRangeInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.adapter.notifyItemRangeRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.adapter.notifyItemMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.adapter.notifyItemRangeChanged(i, i2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleAdminSpeak() {
        TLRPC$TL_phone_toggleGroupCallSettings tLRPC$TL_phone_toggleGroupCallSettings = new TLRPC$TL_phone_toggleGroupCallSettings();
        tLRPC$TL_phone_toggleGroupCallSettings.call = this.call.getInputGroupCall();
        tLRPC$TL_phone_toggleGroupCallSettings.join_muted = this.call.call.join_muted;
        tLRPC$TL_phone_toggleGroupCallSettings.flags |= 1;
        this.accountInstance.getCallProxy().setGroupVoiceChatSetting(tLRPC$TL_phone_toggleGroupCallSettings, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda50
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$toggleAdminSpeak$63(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toggleAdminSpeak$63(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            this.accountInstance.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
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
        private final int peerId;
        private ImageLocation uploadingImageLocation;
        public float uploadingProgress;

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didStartUpload(boolean z) {
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ String getInitialSearchString() {
            return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
        }

        private AvatarUpdaterDelegate(int i) {
            this.peerId = i;
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didUploadPhoto(final TLRPC$InputFile tLRPC$InputFile, final TLRPC$InputFile tLRPC$InputFile2, final TLRPC$InputFile tLRPC$InputFile3, final double d, final String str, final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$AvatarUpdaterDelegate$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$3(tLRPC$InputFile, tLRPC$InputFile2, tLRPC$InputFile3, d, str, tLRPC$PhotoSize2, tLRPC$PhotoSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$3(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, final String str, TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
            if ((tLRPC$InputFile != null && tLRPC$InputFile2 != null) || tLRPC$InputFile3 != null) {
                if (this.peerId <= 0) {
                    GroupCallActivity.this.accountInstance.getMessagesController().changeChatAvatar(-this.peerId, null, tLRPC$InputFile, tLRPC$InputFile3, null, d, str, tLRPC$PhotoSize.location, tLRPC$PhotoSize2.location, new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$AvatarUpdaterDelegate$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$didUploadPhoto$2();
                        }
                    });
                    return;
                }
                TLRPC$TL_photos_uploadProfilePhoto tLRPC$TL_photos_uploadProfilePhoto = new TLRPC$TL_photos_uploadProfilePhoto();
                if (tLRPC$InputFile != null && tLRPC$InputFile2 != null) {
                    tLRPC$TL_photos_uploadProfilePhoto.file = tLRPC$InputFile;
                    tLRPC$TL_photos_uploadProfilePhoto.smallFile = tLRPC$InputFile2;
                    tLRPC$TL_photos_uploadProfilePhoto.flags |= 1;
                }
                if (tLRPC$InputFile3 != null) {
                    tLRPC$TL_photos_uploadProfilePhoto.video = tLRPC$InputFile3;
                    int i = tLRPC$TL_photos_uploadProfilePhoto.flags | 2;
                    tLRPC$TL_photos_uploadProfilePhoto.flags = i;
                    tLRPC$TL_photos_uploadProfilePhoto.video_start_ts = d;
                    tLRPC$TL_photos_uploadProfilePhoto.flags = i | 4;
                }
                GroupCallActivity.this.accountInstance.getFileProxy().sendUploadPhotoReq(tLRPC$TL_photos_uploadProfilePhoto, new RequestDelegate() { // from class: org.rbmain.ui.GroupCallActivity$AvatarUpdaterDelegate$$ExternalSyntheticLambda3
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$didUploadPhoto$1(str, tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            this.avatar = tLRPC$PhotoSize.location;
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize2.location;
            this.avatarBig = tLRPC$FileLocation;
            this.uploadingImageLocation = ImageLocation.getForLocal(tLRPC$FileLocation);
            GroupCallActivity.this.avatarsViewPager.addUploadingImage(this.uploadingImageLocation, ImageLocation.getForLocal(this.avatar));
            AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$1(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$AvatarUpdaterDelegate$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$0(tLRPC$TL_error, tLObject, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$0(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str) {
            if (this.uploadingImageLocation != null) {
                GroupCallActivity.this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
                this.uploadingImageLocation = null;
            }
            if (tLRPC$TL_error == null) {
                TLRPC$User user = GroupCallActivity.this.accountInstance.getMessagesController().getUser(Integer.valueOf(GroupCallActivity.this.accountInstance.getUserConfig().getClientUserId()));
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
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(arrayList, MediaController.MAX_WIDTH_HEIGHT_SIZE);
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
                    FileLoader.getInstance(((BottomSheet) GroupCallActivity.this).currentAccount);
                    File pathToAttach = FileLoader.getPathToAttach(closestPhotoSizeWithSize, true);
                    FileLoader.getInstance(((BottomSheet) GroupCallActivity.this).currentAccount);
                    FileLoader.getPathToAttach(this.avatar, true).renameTo(pathToAttach);
                    ImageLoader.getInstance().replaceImageInCache(this.avatar.volume_id + "_" + this.avatar.local_id + "@50_50", closestPhotoSizeWithSize.location.volume_id + "_" + closestPhotoSizeWithSize.location.local_id + "@50_50", ImageLocation.getForUser(user, 1), false);
                }
                if (closestPhotoSizeWithSize2 != null && this.avatarBig != null) {
                    FileLoader.getInstance(((BottomSheet) GroupCallActivity.this).currentAccount);
                    File pathToAttach2 = FileLoader.getPathToAttach(closestPhotoSizeWithSize2, true);
                    FileLoader.getInstance(((BottomSheet) GroupCallActivity.this).currentAccount);
                    FileLoader.getPathToAttach(this.avatarBig, true).renameTo(pathToAttach2);
                }
                if (tLRPC$VideoSize != null && str != null) {
                    FileLoader.getInstance(((BottomSheet) GroupCallActivity.this).currentAccount);
                    new File(str).renameTo(FileLoader.getPathToAttach(tLRPC$VideoSize, "mp4", true));
                }
                GroupCallActivity.this.accountInstance.getMessagesStorage().clearUserPhotos(user.id);
                ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
                arrayList2.add(user);
                GroupCallActivity.this.accountInstance.getMessagesStorage().putUsersAndChats(arrayList2, null, false, true);
                TLRPC$User user2 = GroupCallActivity.this.accountInstance.getMessagesController().getUser(Integer.valueOf(this.peerId));
                ImageLocation forUser = ImageLocation.getForUser(user2, 0);
                ImageLocation forUser2 = ImageLocation.getForUser(user2, 1);
                if (ImageLocation.getForLocal(this.avatarBig) == null) {
                    forUser2 = ImageLocation.getForLocal(this.avatar);
                }
                GroupCallActivity.this.avatarsViewPager.setCreateThumbFromParent(false);
                GroupCallActivity.this.avatarsViewPager.initIfEmpty(null, forUser, forUser2, true);
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
        public /* synthetic */ void lambda$didUploadPhoto$2() {
            if (this.uploadingImageLocation != null) {
                GroupCallActivity.this.avatarsViewPager.removeUploadingImage(this.uploadingImageLocation);
                this.uploadingImageLocation = null;
            }
            TLRPC$Chat chat = GroupCallActivity.this.accountInstance.getMessagesController().getChat(Integer.valueOf(-this.peerId));
            ImageLocation forChat = ImageLocation.getForChat(chat, 0);
            ImageLocation forChat2 = ImageLocation.getForChat(chat, 1);
            if (ImageLocation.getForLocal(this.avatarBig) == null) {
                forChat2 = ImageLocation.getForLocal(this.avatar);
            }
            GroupCallActivity.this.avatarsViewPager.setCreateThumbFromParent(false);
            GroupCallActivity.this.avatarsViewPager.initIfEmpty(null, forChat, forChat2, true);
            this.avatar = null;
            this.avatarBig = null;
            AndroidUtilities.updateVisibleRows(GroupCallActivity.this.listView);
            updateAvatarUploadingProgress(1.0f);
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void onUploadProgressChanged(float f) {
            GroupCallActivity.this.avatarsViewPager.setUploadProgress(this.uploadingImageLocation, f);
            updateAvatarUploadingProgress(f);
        }

        public void updateAvatarUploadingProgress(float f) {
            this.uploadingProgress = f;
            if (GroupCallActivity.this.listView == null) {
                return;
            }
            for (int i = 0; i < GroupCallActivity.this.listView.getChildCount(); i++) {
                View childAt = GroupCallActivity.this.listView.getChildAt(i);
                if (childAt instanceof GroupCallUserCell) {
                    GroupCallUserCell groupCallUserCell = (GroupCallUserCell) childAt;
                    if (groupCallUserCell.isSelfUser()) {
                        groupCallUserCell.setUploadProgress(f, true);
                    }
                }
            }
        }
    }

    public View getScrimView() {
        return this.scrimView;
    }

    @Override // org.rbmain.messenger.voip.VoIPService.StateListener
    public void onCameraSwitch(boolean z) {
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
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.GroupCallActivity$GroupCallItemAnimator$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$runPendingAnimations$0(valueAnimator2);
                    }
                });
                this.animator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.GroupCallActivity.GroupCallItemAnimator.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
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
        public /* synthetic */ void lambda$runPendingAnimations$0(ValueAnimator valueAnimator) {
            this.animationProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            GroupCallActivity.this.listView.invalidate();
            GroupCallActivity.this.renderersContainer.invalidate();
            ((BottomSheet) GroupCallActivity.this).containerView.invalidate();
            GroupCallActivity.this.updateLayout(true);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithTouchOutside() {
        return !this.renderersContainer.inFullscreenMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserLeaveHint() {
        if (isRtmpStream() && AndroidUtilities.checkInlinePermissions(this.parentActivity) && !RTMPStreamPipOverlay.isVisible()) {
            dismiss();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.GroupCallActivity$$ExternalSyntheticLambda46
                @Override // java.lang.Runnable
                public final void run() {
                    RTMPStreamPipOverlay.show();
                }
            }, 100L);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.parentActivity.addOnUserLeaveHintListener(this.onUserLeaveHintListener);
    }

    public boolean isRtmpLandscapeMode() {
        if (!isRtmpStream() || this.call.visibleVideoParticipants.isEmpty()) {
            return false;
        }
        return this.call.visibleVideoParticipants.get(0).aspectRatio == 0.0f || this.call.visibleVideoParticipants.get(0).aspectRatio >= 1.0f;
    }

    public boolean isRtmpStream() {
        ChatObject.Call call = this.call;
        return call != null && call.call.rtmp_stream;
    }
}
