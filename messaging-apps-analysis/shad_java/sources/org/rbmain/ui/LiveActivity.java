package org.rbmain.ui;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MessageConverter;
import androidMessenger.utilites.MyLog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2t.analytics.AnalyticsListener;
import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.encoder.input.video.CameraOpenException;
import com.pedro.rtplibrary.rtmp.RtmpCamera1;
import com.pedro.rtplibrary.util.BitrateAdapter;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreUtilities;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.LiveModels;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.ossrs.rtmp.ConnectCheckerRtmp;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.Bitmaps;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageFwdHeader;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_GetLiveCommentResult;
import org.rbmain.tgnet.TLRPC$TL_LiveComment;
import org.rbmain.tgnet.TLRPC$TL_live;
import org.rbmain.tgnet.TLRPC$TL_messageMediaLiveMessage;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.LiveViewsAlert;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.VideoEditTextureView;
import org.rbmain.ui.Components.VideoPlayer;
import org.rbmain.ui.Components.VideoPlayerSeekBar;
import org.rbmain.ui.LiveSettingAlert;

/* loaded from: classes4.dex */
public class LiveActivity extends BaseFragment implements ConnectCheckerRtmp, View.OnClickListener, NotificationCenter.NotificationCenterDelegate {
    private final Object StopObjectSync;
    private ObjectAnimator animatorCommon;
    private AvatarDrawable avatarDrawable;
    private BackupImageView avatarImageView;
    private BitrateAdapter bitrateAdapter;
    private ImageView buttonClose;
    private Button buttonStart;
    SurfaceHolder.Callback callback;
    private final ChatType chatType;
    private CommentAdapter commentAdapter;
    private ArrayList<LiveModels.CommentLiveHintObject> commentHint;
    private final ArrayList<TLRPC$TL_LiveComment> commentObjects;
    private final Queue<TLRPC$TL_LiveComment> commentObjectsToAdd;
    ViewGroup commonLayout;
    private Context context;
    FrameLayout contextView;
    private TLRPC$Chat currentChat;
    private MessageObject currentLiveMessageObject;
    private TLRPC$User currentUser;
    private final long did;
    private EditText editTextComment;
    private EditText edittextTitle;
    LinearLayout endBroadCastLayout;
    private boolean forceBack;
    private boolean forceDisconnect;
    private FrameLayout frameLayoutComment;
    private FrameLayout frameLayoutPlayerContainer;
    private final Runnable getCommentListRunnable;
    private final Runnable getLiveStatusRunnable;
    public boolean hideInfo;
    private HintAdapter hintAdapter;
    private String hostStreamUrl;
    private boolean isBroadCastMode;
    boolean isBroadcastIsByExternalPublisher;
    private boolean isCommentLoading;
    private boolean isCommentTimerStarted;
    private boolean isCommonLayoutInVisible;
    private boolean isExternalCreator;
    private boolean isGettingLiveStatus;
    private boolean isPlaying;
    private boolean isStopedStreamMyself;
    private boolean isVODMode;
    private boolean is_owner;
    private Boolean lastAllowComment;
    private int lastReqId;
    private Camera.Size lastSize;
    private TextView liveTextView;
    private HashMap<String, TLRPC$TL_LiveComment> myComments;
    private String myGuid;
    private boolean needToRunGetComments;
    private boolean needToRunProgress;
    private boolean needToRunUpdateComments;
    private String nextStartIdComment;
    private LiveModels.PlayTypeEnum playType;
    private int playerHeight;
    private int playerWidth;
    ViewGroup progressLayout;
    private String publishText;
    private RecyclerListView recyclerViewComment;
    private RecyclerListView recyclerViewCommentHint;
    private Runnable retryRunnable;
    private int rotation;
    private RtmpCamera1 rtmpCamera1;
    private int screenWidth;
    private float seekToProgressPending;
    ViewGroup startBroadCastLayout;
    private String streamingUrl;
    private SurfaceView surfaceView;
    private TextView textViewMemberCount;
    private TextView textViewProgress;
    private TextureView textureView;
    private TextView titleAvatarTextView;
    private final Runnable updateCommentListRunnable;
    private final Runnable updateProgressRunnable;
    private VideoPlayer videoPlayer;
    private VideoPlayerSeekBar videoPlayerSeekbar;
    private View videoPlayerSeekbarView;
    private PowerManager.WakeLock wakeLock;

    public enum FinishedReason {
        rtmpDisconnectedForBroadCaster,
        liveFinishedForViewer,
        liveFinishedBeforeForViewer,
        playbackVideoDoesntExist,
        liveBanedForViewer
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onAuthErrorRtmp() {
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onAuthSuccessRtmp() {
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
    }

    public LiveActivity(boolean z, long j, boolean z2) {
        this.commentHint = new ArrayList<>();
        this.isBroadcastIsByExternalPublisher = false;
        this.hostStreamUrl = null;
        this.myComments = new HashMap<>();
        this.streamingUrl = null;
        this.isStopedStreamMyself = false;
        this.StopObjectSync = new Object();
        this.isCommonLayoutInVisible = false;
        this.commentObjects = new ArrayList<>();
        this.commentObjectsToAdd = new ConcurrentLinkedQueue();
        this.isGettingLiveStatus = false;
        this.avatarDrawable = new AvatarDrawable();
        this.playerHeight = 0;
        this.playerWidth = 0;
        this.wakeLock = null;
        this.callback = new SurfaceHolder.Callback() { // from class: org.rbmain.ui.LiveActivity.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) throws IOException {
                LiveActivity.this.rtmpCamera1.startPreview(CameraHelper.Facing.FRONT, LiveActivity.this.lastSize.width, LiveActivity.this.lastSize.height, LiveActivity.this.rotation);
                if (LiveActivity.this.streamingUrl != null) {
                    LiveActivity liveActivity = LiveActivity.this;
                    liveActivity.startStreamingWithUrl(liveActivity.streamingUrl);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (LiveActivity.this.rtmpCamera1.isStreaming()) {
                    LiveActivity.this.rtmpCamera1.stopStream();
                    LiveActivity.this.startBroadCastLayout.setVisibility(0);
                }
                LiveActivity.this.rtmpCamera1.stopPreview();
            }
        };
        this.updateProgressRunnable = new Runnable() { // from class: org.rbmain.ui.LiveActivity.2
            @Override // java.lang.Runnable
            public void run() {
                if (LiveActivity.this.videoPlayer != null) {
                    LiveActivity.this.videoPlayerSeekbar.setProgress(LiveActivity.this.videoPlayer.getCurrentPosition() / LiveActivity.this.videoPlayer.getDuration(), false);
                    LiveActivity.this.videoPlayerSeekbarView.invalidate();
                }
                if (LiveActivity.this.isPlaying) {
                    AndroidUtilities.runOnUIThread(LiveActivity.this.updateProgressRunnable, 17L);
                }
            }
        };
        this.updateCommentListRunnable = new Runnable() { // from class: org.rbmain.ui.LiveActivity.3
            @Override // java.lang.Runnable
            public void run() {
                TLRPC$TL_LiveComment tLRPC$TL_LiveComment;
                if (!LiveActivity.this.commentObjectsToAdd.isEmpty() && (tLRPC$TL_LiveComment = (TLRPC$TL_LiveComment) LiveActivity.this.commentObjectsToAdd.poll()) != null && LiveActivity.this.myComments.get(tLRPC$TL_LiveComment.commentId) == null) {
                    LiveActivity.this.addComment(tLRPC$TL_LiveComment);
                }
                AndroidUtilities.runOnUIThread(LiveActivity.this.updateCommentListRunnable, 700L);
            }
        };
        this.getCommentListRunnable = new Runnable() { // from class: org.rbmain.ui.LiveActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (!LiveActivity.this.isCommentLoading) {
                    LiveActivity.this.getComments();
                }
                AndroidUtilities.runOnUIThread(LiveActivity.this.getCommentListRunnable, 5000L);
            }
        };
        this.getLiveStatusRunnable = new Runnable() { // from class: org.rbmain.ui.LiveActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (!LiveActivity.this.isGettingLiveStatus) {
                    LiveActivity.this.getLiveStatus();
                }
                Utilities.stageQueue.postRunnable(LiveActivity.this.getLiveStatusRunnable, LiveActivity.this.isBroadCastMode ? 15000L : 30000L);
            }
        };
        this.isBroadCastMode = z;
        this.isForceBlackTheme = true;
        this.isBroadcastIsByExternalPublisher = getAppPreferences().getBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false);
        this.did = j;
        this.hideInfo = z2;
        int i = (int) j;
        if (i < 0) {
            this.currentChat = getMessagesController().getChat(Integer.valueOf(-i));
        } else {
            this.currentUser = getMessagesController().getUser(Integer.valueOf(i));
        }
        if (j > 0) {
            TLRPC$User user = getMessagesController().getUser(Integer.valueOf(i));
            this.chatType = user.bot ? ChatType.Bot : user.support ? ChatType.Service : ChatType.User;
        } else {
            this.chatType = getCoreMainClass().isChannel(IdStorage.getInstance().getDialogId(j)) ? ChatType.Channel : ChatType.Group;
        }
    }

    public LiveActivity(long j, MessageObject messageObject, boolean z) {
        this(false, j, z);
        this.isForceBlackTheme = true;
        this.isBroadcastIsByExternalPublisher = getAppPreferences().getBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false);
        this.currentLiveMessageObject = messageObject;
        LiveModels.LastLiveState lastLiveState = getCoreMainClass().getLastLiveState();
        if (lastLiveState == null || messageObject == null || !messageObject.isLiveMessage()) {
            return;
        }
        TLRPC$TL_live tLRPC$TL_live = messageObject.messageOwner.media.live;
        LiveModels.LiveStatusEnum liveStatusEnum = tLRPC$TL_live.live_status.status;
        if ((liveStatusEnum == LiveModels.LiveStatusEnum.InProgress || liveStatusEnum == LiveModels.LiveStatusEnum.Ready) && tLRPC$TL_live.live_id.equals(lastLiveState.live_id) && System.currentTimeMillis() - lastLiveState.timestamp < 180000) {
            if (lastLiveState.isExternalPublish) {
                this.isExternalCreator = true;
                this.publishText = lastLiveState.publishText;
            } else {
                this.isBroadCastMode = true;
                this.streamingUrl = lastLiveState.streamURl;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getLiveStatus() {
        MessageObject messageObject = this.currentLiveMessageObject;
        if (messageObject != null) {
            this.isGettingLiveStatus = true;
            TLRPC$TL_live tLRPC$TL_live = messageObject.messageOwner.media.live;
            String str = tLRPC$TL_live.live_id;
            String str2 = tLRPC$TL_live.access_token;
            messageObject.hasGetLiveStatus = false;
            getMessageProxy().requestLiveUpdate(str, str2, false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar = null;
        this.context = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return LiveActivity.lambda$createView$0(view, motionEvent);
            }
        });
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        this.contextView = frameLayout2;
        frameLayout2.setBackgroundColor(-16777216);
        init();
        return this.fragmentView;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        RtmpCamera1 rtmpCamera1;
        super.onPause();
        PowerManager.WakeLock wakeLock = this.wakeLock;
        LiveModels.LiveStatus liveStatus = null;
        if (wakeLock != null) {
            try {
                wakeLock.release();
                this.wakeLock = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        stopRunnable();
        try {
            VideoPlayer videoPlayer = this.videoPlayer;
            if (videoPlayer != null) {
                this.isPlaying = false;
                videoPlayer.setPlayWhenReady(false);
            }
            if (this.isBroadCastMode && (rtmpCamera1 = this.rtmpCamera1) != null) {
                this.isStopedStreamMyself = true;
                rtmpCamera1.stopStream();
                this.rtmpCamera1.stopPreview();
            }
            MessageObject messageObject = this.currentLiveMessageObject;
            if (messageObject != null && messageObject.isLiveMessage()) {
                liveStatus = this.currentLiveMessageObject.messageOwner.media.live.live_status;
            }
            if (!this.isBroadCastMode || liveStatus == null) {
                return;
            }
            LiveModels.LiveStatusEnum liveStatusEnum = liveStatus.status;
            if (liveStatusEnum == LiveModels.LiveStatusEnum.InProgress || liveStatusEnum == LiveModels.LiveStatusEnum.Ready) {
                getCoreMainClass().setLastLiveState(this.currentLiveMessageObject.messageOwner.media.live.live_id, this.streamingUrl, this.isBroadcastIsByExternalPublisher, this.publishText);
            }
        } catch (Exception unused) {
        }
    }

    private void init() {
        float fAbs;
        this.myGuid = getCoreMainClass().getMyGuid();
        this.screenWidth = AndroidUtilities.getScreenWidth();
        ArrayList<LiveModels.CommentLiveHintObject> arrayList = new ArrayList<>();
        this.commentHint = arrayList;
        arrayList.add(new LiveModels.CommentLiveHintObject("👍🏻"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject("😎️"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject("☹️"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject("❤️❤"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject("😂😂😂"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject("😍"));
        this.commentHint.add(new LiveModels.CommentLiveHintObject(LocaleController.getString("CommentOther", R.string.CommentOther)));
        if (this.isBroadCastMode) {
            FrameLayout frameLayout = new FrameLayout(this.context);
            this.contextView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            SurfaceView surfaceView = new SurfaceView(this.context);
            this.surfaceView = surfaceView;
            frameLayout.addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
        }
        FrameLayout frameLayout2 = new FrameLayout(this.context);
        this.progressLayout = frameLayout2;
        frameLayout2.setBackgroundColor(Color.parseColor("#aa000000"));
        this.progressLayout.setVisibility(8);
        this.contextView.addView(this.progressLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        TextView textView = new TextView(this.context);
        this.textViewProgress = textView;
        textView.setGravity(17);
        this.textViewProgress.setText(LocaleController.getString("Connecting", R.string.Connecting));
        this.textViewProgress.setTextColor(-1);
        this.textViewProgress.setTextSize(1, 20.0f);
        this.progressLayout.addView(this.textViewProgress, new FrameLayout.LayoutParams(-1, -2, 17));
        FrameLayout frameLayout3 = new FrameLayout(this.context);
        this.startBroadCastLayout = frameLayout3;
        frameLayout3.setBackgroundColor(Color.parseColor("#99000000"));
        this.startBroadCastLayout.setVisibility(8);
        this.contextView.addView(this.startBroadCastLayout, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(R.drawable.menu_settings);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$2(view);
            }
        });
        imageView.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f));
        this.startBroadCastLayout.addView(imageView, new FrameLayout.LayoutParams(AndroidUtilities.dp(48.0f), AndroidUtilities.dp(48.0f), 51));
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        this.startBroadCastLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 17));
        TextView textView2 = new TextView(this.context);
        textView2.setGravity(17);
        textView2.setTextColor(-1);
        textView2.setTextSize(1, 22.0f);
        textView2.setTypeface(null, 1);
        textView2.setText(LocaleController.getString("Live", R.string.Live));
        linearLayout.addView(textView2, new FrameLayout.LayoutParams(-1, -2));
        TextView textView3 = new TextView(this.context);
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setText(LocaleController.getString("EnterLiveTitleAndStart", R.string.EnterLiveTitleAndStart));
        linearLayout.addView(textView3, new FrameLayout.LayoutParams(-1, -2));
        EditText editText = new EditText(this.context);
        this.edittextTitle = editText;
        editText.setGravity(17);
        this.edittextTitle.setTextColor(-1);
        this.edittextTitle.setHint(LocaleController.getString("LiveTitle", R.string.LiveTitle));
        this.edittextTitle.setHintTextColor(Color.parseColor("#99FFFFFF"));
        this.edittextTitle.setLines(1);
        this.edittextTitle.setSingleLine(true);
        this.edittextTitle.setMaxLines(1);
        this.edittextTitle.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
        this.edittextTitle.setMinWidth(AndroidUtilities.dp(160.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AndroidUtilities.dp(150.0f), -2);
        layoutParams.setMargins(AndroidUtilities.dp(24.0f), 0, AndroidUtilities.dp(24.0f), 0);
        linearLayout.addView(this.edittextTitle, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        Button button = new Button(this.context);
        this.buttonStart = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$3(view);
            }
        });
        linearLayout2.addView(this.buttonStart, LayoutHelper.createFrame(-2, -2.0f, 16, 0.0f, 0.0f, 0.0f, 0.0f));
        ImageView imageView2 = new ImageView(this.context);
        imageView2.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.camera_revert1));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f$0.lambda$init$4(view);
            }
        });
        linearLayout2.addView(imageView2, LayoutHelper.createFrame(-2, -2.0f, 16, 8.0f, 0.0f, 0.0f, 0.0f));
        linearLayout.addView(linearLayout2, LayoutHelper.createFrame(-2, -2.0f, 17, 16.0f, 16.0f, 16.0f, 16.0f));
        updateStartButton();
        FrameLayout frameLayout4 = new FrameLayout(this.context);
        this.frameLayoutPlayerContainer = frameLayout4;
        this.contextView.addView(frameLayout4, new FrameLayout.LayoutParams(-1, -1, 48));
        if (this.isBroadCastMode) {
            this.startBroadCastLayout.setVisibility(0);
            RtmpCamera1 rtmpCamera1 = new RtmpCamera1(this.surfaceView, this);
            this.rtmpCamera1 = rtmpCamera1;
            rtmpCamera1.setReTries(10);
            this.surfaceView.getHolder().addCallback(this.callback);
            float fAbs2 = 10000.0f;
            float f = 100.0f;
            for (Camera.Size size : this.rtmpCamera1.getResolutionsFront()) {
                float fAbs3 = Math.abs(((size.width * 1.0f) / size.height) - 1.7777778f);
                if (fAbs3 > f) {
                    fAbs = Math.abs(((size.height * 1.0f) / size.width) - 1.7777778f);
                    if (fAbs > f && (fAbs != 0.0f || f != 0.0f || Math.abs(size.width - 480) <= fAbs2)) {
                        fAbs2 = Math.abs(size.width - 480);
                        this.lastSize = size;
                        this.rotation = 0;
                        f = fAbs;
                    }
                } else if (fAbs3 != 0.0f || f != 0.0f || Math.abs(size.height - 480) <= fAbs2) {
                    fAbs2 = Math.abs(size.height - 480);
                    this.lastSize = size;
                    this.rotation = 90;
                    f = fAbs3;
                    fAbs = Math.abs(((size.height * 1.0f) / size.width) - 1.7777778f);
                    if (fAbs > f) {
                    }
                }
            }
            Camera.Size size2 = this.lastSize;
            float f2 = (size2.height * 1.0f) / size2.width;
            if (f2 < 1.0f) {
                f2 = 1.0f / f2;
            }
            float f3 = 1.7777778f / f2;
            this.surfaceView.getLayoutParams().height = (int) (((int) (this.screenWidth * f2)) * f3);
            this.surfaceView.getLayoutParams().width = (int) (this.screenWidth * f3);
            SurfaceView surfaceView2 = this.surfaceView;
            surfaceView2.setLayoutParams(surfaceView2.getLayoutParams());
            this.surfaceView.getHolder().setFixedSize(this.surfaceView.getLayoutParams().width, this.surfaceView.getLayoutParams().height);
            this.surfaceView.invalidate();
        }
        FrameLayout frameLayout5 = new FrameLayout(this.context);
        this.commonLayout = frameLayout5;
        frameLayout5.setVisibility(4);
        this.contextView.addView(this.commonLayout, new FrameLayout.LayoutParams(-1, -1));
        RecyclerListView recyclerListView = new RecyclerListView(this.context);
        this.recyclerViewComment = recyclerListView;
        recyclerListView.setClipToPadding(false);
        this.recyclerViewComment.setBackgroundColor(16777215);
        this.recyclerViewComment.setFadingEdgeLength(AndroidUtilities.dp(8.0f));
        this.recyclerViewComment.setVerticalFadingEdgeEnabled(true);
        this.recyclerViewComment.setLayoutManager(new LinearLayoutManager(this.context, 1, true));
        RecyclerListView recyclerListView2 = this.recyclerViewComment;
        CommentAdapter commentAdapter = new CommentAdapter(this.context);
        this.commentAdapter = commentAdapter;
        recyclerListView2.setAdapter(commentAdapter);
        this.commonLayout.addView(this.recyclerViewComment, LayoutHelper.createFrame(-1, 188.0f, 80, 8.0f, 0.0f, 8.0f, 98.0f));
        this.recyclerViewComment.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda15
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f4, float f5) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f4, f5);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f4, float f5) {
                this.f$0.lambda$init$5(view, i, f4, f5);
            }
        });
        FrameLayout frameLayout6 = new FrameLayout(this.context);
        frameLayout6.setAlpha(0.24f);
        frameLayout6.setBackground(ContextCompat.getDrawable(this.context, R.drawable.gradient_bottom));
        this.commonLayout.addView(frameLayout6, LayoutHelper.createFrame(-1, 88.0f, 80, 0.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout frameLayout7 = new FrameLayout(this.context);
        this.frameLayoutComment = frameLayout7;
        this.commonLayout.addView(frameLayout7, LayoutHelper.createFrame(-1, 108, 80));
        RecyclerListView recyclerListView3 = new RecyclerListView(this.context);
        this.recyclerViewCommentHint = recyclerListView3;
        recyclerListView3.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        this.recyclerViewCommentHint.setClipToPadding(true);
        this.recyclerViewCommentHint.setFadingEdgeLength(AndroidUtilities.dp(8.0f));
        this.recyclerViewCommentHint.setHorizontalFadingEdgeEnabled(true);
        this.recyclerViewCommentHint.setHorizontalScrollBarEnabled(false);
        this.recyclerViewCommentHint.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        RecyclerListView recyclerListView4 = this.recyclerViewCommentHint;
        HintAdapter hintAdapter = new HintAdapter(this.context);
        this.hintAdapter = hintAdapter;
        recyclerListView4.setAdapter(hintAdapter);
        this.frameLayoutComment.addView(this.recyclerViewCommentHint, LayoutHelper.createFrame(-1, 48.0f, 80, 8.0f, 0.0f, 8.0f, 36.0f));
        this.recyclerViewCommentHint.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda14
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f4, float f5) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f4, f5);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f4, float f5) {
                this.f$0.lambda$init$6(view, i, f4, f5);
            }
        });
        ImageView imageView3 = new ImageView(this.context);
        imageView3.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
        imageView3.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_send));
        this.frameLayoutComment.addView(imageView3, LayoutHelper.createFrame(36, 36.0f, 85, 8.0f, 0.0f, 16.0f, 8.0f));
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$7(view);
            }
        });
        if (this.isBroadCastMode) {
            ImageView imageView4 = new ImageView(this.context);
            imageView4.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.camera_revert1));
            this.frameLayoutComment.addView(imageView4, LayoutHelper.createFrame(36, 36.0f, 85, 8.0f, 0.0f, 64.0f, 8.0f));
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    this.f$0.lambda$init$8(view);
                }
            });
        }
        FrameLayout frameLayout8 = new FrameLayout(this.context);
        this.frameLayoutComment.addView(frameLayout8, LayoutHelper.createFrame(-1, -2.0f, 80, 16.0f, 0.0f, 104.0f, 0.0f));
        EditText editText2 = new EditText(this.context);
        this.editTextComment = editText2;
        editText2.setGravity(5);
        this.editTextComment.setTextColor(-1);
        this.editTextComment.setHintTextColor(-1);
        this.editTextComment.setHint(LocaleController.getString("WriteAMessage", R.string.WriteAMessage));
        this.editTextComment.setTextSize(1, 13.0f);
        this.editTextComment.setBackgroundResource(R.drawable.shape_game_add_comment_background);
        EditText editText3 = this.editTextComment;
        editText3.setFilters(InputFilterHelper.getFilter(128, 1, editText3));
        this.editTextComment.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(40.0f), AndroidUtilities.dp(8.0f));
        frameLayout8.addView(this.editTextComment, LayoutHelper.createFrame(-1, -2.0f, 80, 8.0f, 8.0f, 8.0f, 8.0f));
        ImageView imageView5 = new ImageView(this.context);
        imageView5.setPadding(AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f));
        imageView5.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.msg_actions));
        frameLayout8.addView(imageView5, LayoutHelper.createFrame(36, 30.0f, 21, 0.0f, 1.0f, 8.0f, 0.0f));
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$9(view);
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(this.context);
        linearLayout3.setOrientation(0);
        this.commonLayout.addView(linearLayout3, LayoutHelper.createFrame(-2, -2.0f, 53, 0.0f, 0.0f, 56.0f, 0.0f));
        TextView textView4 = new TextView(this.context);
        this.liveTextView = textView4;
        textView4.setGravity(17);
        this.liveTextView.setTextColor(-1);
        this.liveTextView.setTextSize(1, 12.0f);
        this.liveTextView.setText(LocaleController.getString("Live", R.string.Live));
        this.liveTextView.setBackground(ContextCompat.getDrawable(this.context, R.drawable.shape_red_alpha_round));
        this.liveTextView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        linearLayout3.addView(this.liveTextView, LayoutHelper.createFrame(-2, 32.0f, 53, 0.0f, 8.0f, 8.0f, 0.0f));
        TextView textView5 = new TextView(this.context);
        this.textViewMemberCount = textView5;
        textView5.setGravity(17);
        this.textViewMemberCount.setTextColor(-16777216);
        this.textViewMemberCount.setTextSize(1, 12.0f);
        this.textViewMemberCount.setBackgroundResource(R.drawable.shape_white_alpha_round);
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.game_user_black);
        drawable.getClass();
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.textViewMemberCount.setCompoundDrawables(drawable, null, null, null);
        this.textViewMemberCount.setPadding(0, 0, AndroidUtilities.dp(8.0f), 0);
        linearLayout3.addView(this.textViewMemberCount, LayoutHelper.createFrame(-2, 32.0f, 53, 0.0f, 8.0f, 8.0f, 0.0f));
        this.buttonClose = new ImageView(this.context);
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);
        this.buttonClose.setBackgroundResource(typedValue.resourceId);
        this.buttonClose.setImageResource(R.drawable.ic_close_white);
        this.buttonClose.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$init$10(view);
            }
        });
        this.buttonClose.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        this.contextView.addView(this.buttonClose, new FrameLayout.LayoutParams(AndroidUtilities.dp(48.0f), AndroidUtilities.dp(48.0f), 53));
        LinearLayout linearLayout4 = new LinearLayout(this.context);
        this.endBroadCastLayout = linearLayout4;
        linearLayout4.setOrientation(1);
        this.endBroadCastLayout.setGravity(17);
        this.endBroadCastLayout.setVisibility(8);
        this.endBroadCastLayout.setBackgroundColor(Color.parseColor("#99000000"));
        this.contextView.addView(this.endBroadCastLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout9 = new FrameLayout(this.context);
        BackupImageView backupImageView = new BackupImageView(this.context);
        this.avatarImageView = backupImageView;
        backupImageView.setRoundRadius(AndroidUtilities.dp(16.0f));
        frameLayout9.addView(this.avatarImageView, LayoutHelper.createFrame(-1, -1.0f));
        this.commonLayout.addView(frameLayout9, LayoutHelper.createFrame(32, 32.0f, 3, 8.0f, 8.0f, 8.0f, 8.0f));
        TextView textView6 = new TextView(this.context);
        this.titleAvatarTextView = textView6;
        textView6.setGravity(17);
        this.titleAvatarTextView.setTextColor(-1);
        this.titleAvatarTextView.setTextSize(1, 13.0f);
        this.titleAvatarTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleAvatarTextView.setShadowLayer(4.0f, 0.0f, 1.0f, Color.parseColor("#99424242"));
        this.titleAvatarTextView.setMaxLines(1);
        this.commonLayout.addView(this.titleAvatarTextView, LayoutHelper.createFrame(-2, 32.0f, 3, 44.0f, 8.0f, AndroidUtilities.px(DimensionHelper.getScreenWidth((Activity) this.context) / 2.0f), 0.0f));
        if (!this.isBroadCastMode) {
            this.textureView = new TextureView(this.context);
            this.frameLayoutPlayerContainer.setLayoutTransition(new LayoutTransition());
            this.frameLayoutPlayerContainer.setClipChildren(false);
            this.frameLayoutPlayerContainer.setClipToPadding(false);
            this.frameLayoutPlayerContainer.setBackgroundColor(Color.parseColor("#00ffffff"));
            this.frameLayoutPlayerContainer.addView(this.textureView, LayoutHelper.createFrame(-1, -1, 48));
            playStream();
            int i = this.screenWidth;
            this.playerHeight = (int) (i * 1.7777778f);
            this.playerWidth = i;
            this.textureView.getLayoutParams().height = this.playerHeight;
            this.textureView.getLayoutParams().width = this.playerWidth;
            ((FrameLayout.LayoutParams) this.textureView.getLayoutParams()).gravity = 48;
            setRotationListener();
            setMemberCount();
        } else {
            this.textViewMemberCount.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$init$11(view);
                }
            });
        }
        setAvatarAndTitle();
        setHideCommonLayoutListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(View view) {
        showDialog(new LiveSettingAlert(getParentActivity(), this.isBroadcastIsByExternalPublisher, new LiveSettingAlert.LiveSettingsDelegate() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda16
            @Override // org.rbmain.ui.LiveSettingAlert.LiveSettingsDelegate
            public final void onChangeLiveSettings(Boolean bool) {
                this.f$0.lambda$init$1(bool);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(Boolean bool) {
        getAppPreferences().setBoolean(AppPreferences.Key.LiveBroadCastExternalMode, bool.booleanValue());
        this.isBroadcastIsByExternalPublisher = bool.booleanValue();
        updateStartButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(View view) {
        AndroidUtilities.hideKeyboard(this.edittextTitle);
        startLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$4(View view) throws IOException {
        try {
            this.rtmpCamera1.switchCamera();
        } catch (CameraOpenException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$5(View view, int i, float f, float f2) {
        showBlockAbsObject(((CommentCell) view).currentObject.absObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$6(View view, int i, float f, float f2) {
        sendComment(((CommentHintCell) view).hintObject.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$7(View view) {
        String string = this.editTextComment.getText().toString();
        if (CoreUtilities.isNotEmpty(string)) {
            sendComment(string);
        }
        this.editTextComment.setText(BuildConfig.FLAVOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$8(View view) throws IOException {
        try {
            this.rtmpCamera1.switchCamera();
        } catch (CameraOpenException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$9(View view) {
        onOptionClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$10(View view) {
        if (onBackClicked() || ApplicationLoader.applicationActivity == null) {
            return;
        }
        this.forceDisconnect = true;
        this.forceBack = true;
        ApplicationLoader.applicationActivity.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$11(View view) {
        showDialog(new LiveViewsAlert(this, this.currentLiveMessageObject));
    }

    private void updateStartButton() {
        if (this.isBroadcastIsByExternalPublisher) {
            this.buttonStart.setText(LocaleController.getString("SendLiveByExternalDevice", R.string.SendLiveByExternalDevice));
        } else {
            this.buttonStart.setText(LocaleController.getString("Start", R.string.Start));
        }
    }

    private void onOptionClicked() {
        String str;
        TLRPC$TL_live tLRPC$TL_live;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        MessageObject messageObject = this.currentLiveMessageObject;
        LiveModels.LiveStatus liveStatus = (messageObject == null || (tLRPC$TL_live = messageObject.messageOwner.media.live) == null) ? null : tLRPC$TL_live.live_status;
        if (this.isBroadCastMode || this.is_owner || this.isExternalCreator) {
            if (liveStatus != null && liveStatus.allow_comment) {
                arrayList.add(LocaleController.getString("StopComment", R.string.StopComment));
                arrayList2.add(1);
            } else {
                arrayList.add(LocaleController.getString("TurnOnComment", R.string.TurnOnComment));
                arrayList2.add(2);
            }
            if (this.isExternalCreator && (str = this.publishText) != null && !str.isEmpty()) {
                arrayList.add(LocaleController.getString("PublishInfo", R.string.PublishInfo));
                arrayList2.add(4);
            }
            arrayList.add(LocaleController.getString("StopLive", R.string.StopLive));
            arrayList2.add(5);
        } else {
            arrayList.add(LocaleController.getString("ReportLive", R.string.ReportLive));
            arrayList2.add(3);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onOptionClicked$12(arrayList2, dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onOptionClicked$12(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        MessageObject messageObject;
        if (((Integer) arrayList.get(i)).intValue() == 1) {
            setLiveSetting(false);
            return;
        }
        if (((Integer) arrayList.get(i)).intValue() == 2) {
            setLiveSetting(true);
            return;
        }
        if (((Integer) arrayList.get(i)).intValue() == 3) {
            if ((this.currentChat == null && this.currentUser == null) || (messageObject = this.currentLiveMessageObject) == null || !MessageObject.isLiveMessage(messageObject.messageOwner) || this.currentLiveMessageObject.messageOwner.media.live == null) {
                return;
            }
            AlertsCreator.createLiveReportAlert(getParentActivity(), this.did, this.currentLiveMessageObject.getId(), this.currentLiveMessageObject.messageOwner.media.live.live_id, this);
            return;
        }
        if (((Integer) arrayList.get(i)).intValue() == 4) {
            showPublishTextDialog(this.publishText);
        } else if (((Integer) arrayList.get(i)).intValue() == 5) {
            showAlertForStopLive();
        }
    }

    public void setLiveSetting(boolean z) {
        MessageObject messageObject;
        if (this.isBroadCastMode || this.is_owner) {
            if ((this.currentChat == null && this.currentUser == null) || (messageObject = this.currentLiveMessageObject) == null || !(messageObject.messageOwner.media instanceof TLRPC$TL_messageMediaLiveMessage)) {
                return;
            }
            getDialogsProxy().setLiveSetting(z, this.currentLiveMessageObject.messageOwner.media.live.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAvatarAndTitle() {
        int i;
        TLRPC$User user;
        TLRPC$User currentUser;
        String str;
        if (this.hideInfo) {
            this.titleAvatarTextView.setVisibility(4);
            this.avatarImageView.setVisibility(4);
            return;
        }
        boolean z = false;
        String strReplace = null;
        if (this.isBroadCastMode) {
            user = getUserConfig().getCurrentUser();
        } else {
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat == null || tLRPC$Chat.megagroup) {
                MessageObject messageObject = this.currentLiveMessageObject;
                if (messageObject != null) {
                    TLRPC$Message tLRPC$Message = messageObject.messageOwner;
                    TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = tLRPC$Message.fwd_from;
                    if (tLRPC$MessageFwdHeader != null) {
                        i = tLRPC$MessageFwdHeader.from_id.user_id;
                    } else {
                        i = tLRPC$Message.from_id.user_id;
                    }
                    user = getMessagesController().getUser(Integer.valueOf(i));
                }
            } else {
                z = true;
            }
            user = null;
        }
        if (user != null) {
            this.avatarDrawable.setInfo(user);
            if (UserObject.isDeleted(user)) {
                strReplace = LocaleController.getString("HiddenName", R.string.HiddenName);
            } else {
                strReplace = ContactsController.formatName(user.first_name, user.last_name).replace('\n', ' ');
            }
        } else {
            TLRPC$Chat tLRPC$Chat2 = this.currentChat;
            if (tLRPC$Chat2 != null && z) {
                this.avatarDrawable.setInfo(tLRPC$Chat2);
                strReplace = this.currentChat.title.replace('\n', ' ');
            }
        }
        MessageObject messageObject2 = this.currentLiveMessageObject;
        if (messageObject2 != null && messageObject2.isLiveMessage() && (str = this.currentLiveMessageObject.messageOwner.media.live.title) != null && !str.isEmpty()) {
            strReplace = this.currentLiveMessageObject.messageOwner.media.live.title;
        } else if (this.isBroadCastMode && (currentUser = getUserConfig().getCurrentUser()) != null) {
            strReplace = ContactsController.formatName(currentUser.first_name, currentUser.last_name).replace('\n', ' ');
        }
        if (strReplace != null) {
            this.titleAvatarTextView.setText(strReplace);
        }
        if (user != null) {
            this.avatarImageView.setForUserOrChat(user, this.avatarDrawable);
            return;
        }
        TLRPC$Chat tLRPC$Chat3 = this.currentChat;
        if (tLRPC$Chat3 != null && z) {
            this.avatarImageView.setForUserOrChat(tLRPC$Chat3, this.avatarDrawable);
        } else {
            this.avatarImageView.setImageDrawable(this.avatarDrawable);
        }
    }

    public void showBlockAbsObject(final ChatAbsObject chatAbsObject) {
        if ((this.isBroadCastMode || this.is_owner) && !chatAbsObject.object_guid.equals(this.myGuid)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setMessage(LocaleController.getString("AreYouSureBlockUser", R.string.AreYouSureBlockUser));
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$showBlockAbsObject$13(chatAbsObject, dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            showDialog(builder.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBlockAbsObject$13(ChatAbsObject chatAbsObject, DialogInterface dialogInterface, int i) {
        getDialogsProxy().blockCommentsInLive(IdStorage.getInstance().getDialogId(this.did), chatAbsObject, this.chatType);
    }

    private void preparePlayer() {
        if (this.videoPlayer == null) {
            VideoPlayer videoPlayer = new VideoPlayer(this) { // from class: org.rbmain.ui.LiveActivity.6
                @Override // org.rbmain.ui.Components.VideoPlayer
                public void play() {
                    super.play();
                }

                @Override // org.rbmain.ui.Components.VideoPlayer
                public void pause() {
                    super.pause();
                }
            };
            this.videoPlayer = videoPlayer;
            videoPlayer.setDelegate(new VideoPlayer.VideoPlayerDelegate() { // from class: org.rbmain.ui.LiveActivity.7
                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onRenderedFirstFrame() {
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onRenderedFirstFrame(this, eventTime);
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onSeekFinished(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekFinished(this, eventTime);
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
                    VideoPlayer.VideoPlayerDelegate.CC.$default$onSeekStarted(this, eventTime);
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
                    return false;
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onStateChanged(boolean z, int i) {
                    LiveActivity.this.updatePlayerState(z, i);
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onError(final VideoPlayer videoPlayer2, Exception exc) {
                    if (videoPlayer2 == null || LiveActivity.this.isBroadCastMode) {
                        return;
                    }
                    if (LiveActivity.this.retryRunnable != null) {
                        AndroidUtilities.cancelRunOnUIThread(LiveActivity.this.retryRunnable);
                    }
                    LiveActivity.this.retryRunnable = new Runnable() { // from class: org.rbmain.ui.LiveActivity$7$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            videoPlayer2.retry();
                        }
                    };
                    AndroidUtilities.runOnUIThread(LiveActivity.this.retryRunnable, 700L);
                }

                @Override // org.rbmain.ui.Components.VideoPlayer.VideoPlayerDelegate
                public void onVideoSizeChanged(int i, int i2, int i3, float f) {
                    LiveActivity.this.updateTextureViewSize(i, i2);
                }
            });
            TextureView textureView = this.textureView;
            if (textureView != null) {
                this.videoPlayer.setTextureView(textureView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextureViewSize(float f, float f2) {
        float f3;
        float f4 = this.playerWidth;
        float f5 = this.playerHeight;
        float f6 = f4 / f5;
        float f7 = f / f2;
        float f8 = 1.0f;
        if (f6 > f7) {
            f3 = (f2 / f) * f6;
        } else {
            f8 = f7 / f6;
            f3 = 1.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f8, f3, f4 / 2.0f, f5 / 2.0f);
        TextureView textureView = this.textureView;
        if (textureView != null) {
            textureView.setTransform(matrix);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        LiveModels.LiveStatus liveStatus;
        super.onResume();
        try {
            if (this.wakeLock == null) {
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) ApplicationLoader.applicationContext.getSystemService("power")).newWakeLock(26, ":live_lock");
                this.wakeLock = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        startRunnable();
        MessageObject messageObject = this.currentLiveMessageObject;
        if (messageObject != null && (liveStatus = messageObject.messageOwner.media.live.live_status) != null && liveStatus.allow_comment) {
            startCommentRunnableIfNeeded();
        }
        resumePlayer();
    }

    public TLRPC$Chat getCurrentChat() {
        return this.currentChat;
    }

    public TLRPC$User getCurrentUser() {
        return this.currentUser;
    }

    private class HintAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public HintAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveActivity.this.commentHint.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() != 0) {
                return;
            }
            ((CommentHintCell) viewHolder.itemView).setData((LiveModels.CommentLiveHintObject) LiveActivity.this.commentHint.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            CommentHintCell commentHintCell = new CommentHintCell(this.mContext);
            commentHintCell.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            return new RecyclerListView.Holder(commentHintCell);
        }
    }

    private class CommentAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public CommentAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveActivity.this.commentObjects.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() != 0) {
                return;
            }
            ((CommentCell) viewHolder.itemView).setData((TLRPC$TL_LiveComment) LiveActivity.this.commentObjects.get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            CommentCell commentCell = new CommentCell(this.mContext);
            commentCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(commentCell);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.buttonExitBroadCast && ApplicationLoader.applicationActivity != null) {
            this.forceDisconnect = true;
            this.forceBack = true;
            ApplicationLoader.applicationActivity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectingBroadCast() {
        this.startBroadCastLayout.setVisibility(8);
        this.progressLayout.setVisibility(0);
        this.commonLayout.setVisibility(4);
    }

    private void startLive() {
        onConnectingBroadCast();
        Camera camera = this.rtmpCamera1.getCamera();
        new Camera.CameraInfo();
        if (Build.VERSION.SDK_INT >= 17) {
            camera.enableShutterSound(false);
        }
        this.nextStartIdComment = null;
        this.rtmpCamera1.getCamera().takePicture(new Camera.ShutterCallback(this) { // from class: org.rbmain.ui.LiveActivity.8
            @Override // android.hardware.Camera.ShutterCallback
            public void onShutter() {
            }
        }, new Camera.PictureCallback(this) { // from class: org.rbmain.ui.LiveActivity.9
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera2) {
            }
        }, new Camera.PictureCallback() { // from class: org.rbmain.ui.LiveActivity.10
            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera2) {
                LiveActivity.this.rtmpCamera1.getCamera().startPreview();
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, new BitmapFactory.Options());
                int width = bitmapDecodeByteArray.getWidth();
                int height = bitmapDecodeByteArray.getHeight();
                float f = (width > height ? width : height) / 50.0f;
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, (int) (width / f), (int) (height / f), false);
                bitmapDecodeByteArray.recycle();
                Matrix matrix = new Matrix();
                matrix.setRotate(LiveActivity.getOrientation(bArr) - LiveActivity.this.rotation);
                Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(bitmapCreateScaledBitmap, 0, 0, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight(), matrix, false);
                if (bitmapCreateBitmap != bitmapCreateScaledBitmap) {
                    bitmapCreateScaledBitmap.recycle();
                }
                Utilities.blurBitmap(bitmapCreateBitmap, 3, Build.VERSION.SDK_INT < 21 ? 0 : 1, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), bitmapCreateBitmap.getRowBytes());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
                LiveActivity.this.sendLive(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getOrientation(byte[] r10) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LiveActivity.getOrientation(byte[]):int");
    }

    private static int pack(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        if (z) {
            i += i2 - 1;
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return i4;
            }
            i4 = (bArr[i] & 255) | (i4 << 8);
            i += i3;
            i2 = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLive(String str) {
        this.nextStartIdComment = null;
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().startLive(this.did, str, AndroidUtilities.getTrimmedString(this.edittextTitle.getText()).toString(), this.isBroadcastIsByExternalPublisher, new AnonymousClass11());
    }

    /* renamed from: org.rbmain.ui.LiveActivity$11, reason: invalid class name */
    class AnonymousClass11 implements LoadListener<LiveModels.SendLiveResult> {
        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass11() {
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final LiveModels.SendLiveResult sendLiveResult) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity$11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws IOException {
                    this.f$0.lambda$onDidLoad$0(sendLiveResult);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(LiveModels.SendLiveResult sendLiveResult) throws IOException {
            if (sendLiveResult != null) {
                LiveActivity.this.streamingUrl = sendLiveResult.publish_url;
                TLRPC$Message tLRPC$MessageConvertToTlMessage = MessageConverter.convertToTlMessage(LiveActivity.this.getCoreMainClass(), LiveActivity.this.did, LiveActivity.this.getCoreMainClass().isChannel(IdStorage.getInstance().getDialogId(LiveActivity.this.did)), sendLiveResult.liveMessage, null);
                LiveActivity.this.currentLiveMessageObject = new MessageObject(((BaseFragment) LiveActivity.this).currentAccount, tLRPC$MessageConvertToTlMessage, false, false);
                LiveActivity liveActivity = LiveActivity.this;
                if (!liveActivity.isBroadcastIsByExternalPublisher) {
                    liveActivity.startStreamingWithUrl(liveActivity.streamingUrl);
                    LiveActivity.this.startCommentRunnableIfNeeded();
                    LiveActivity.this.setAvatarAndTitle();
                    Utilities.stageQueue.postRunnable(LiveActivity.this.getLiveStatusRunnable);
                    return;
                }
                ApplicationLoader.applicationActivity.onBackPressed();
                LiveActivity.this.publishText = sendLiveResult.publish_text;
                LiveActivity liveActivity2 = LiveActivity.this;
                liveActivity2.showPublishTextDialog(liveActivity2.publishText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCommentRunnableIfNeeded() {
        if (this.hideInfo || this.isCommentTimerStarted) {
            return;
        }
        this.isCommentTimerStarted = true;
        AndroidUtilities.runOnUIThread(this.getCommentListRunnable, 2000L);
        AndroidUtilities.runOnUIThread(this.updateCommentListRunnable, 1000L);
    }

    private void sendComment(String str) {
        TLRPC$TL_live tLRPC$TL_live = this.currentLiveMessageObject.messageOwner.media.live;
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().addLiveComment(tLRPC$TL_live.live_id, tLRPC$TL_live.access_token, str, new AnonymousClass12());
    }

    /* renamed from: org.rbmain.ui.LiveActivity$12, reason: invalid class name */
    class AnonymousClass12 implements LoadListener<TLRPC$TL_LiveComment> {
        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass12() {
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final TLRPC$TL_LiveComment tLRPC$TL_LiveComment) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(tLRPC$TL_LiveComment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(TLRPC$TL_LiveComment tLRPC$TL_LiveComment) {
            LiveActivity.this.myComments.put(tLRPC$TL_LiveComment.commentId, tLRPC$TL_LiveComment);
            LiveActivity.this.addComment(tLRPC$TL_LiveComment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getComments() {
        if (this.isCommentLoading) {
            return;
        }
        this.isCommentLoading = true;
        TLRPC$TL_live tLRPC$TL_live = this.currentLiveMessageObject.messageOwner.media.live;
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().getLiveComments(tLRPC$TL_live.live_id, tLRPC$TL_live.access_token, this.nextStartIdComment, new LoadListener<TLRPC$TL_GetLiveCommentResult>() { // from class: org.rbmain.ui.LiveActivity.13
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(TLRPC$TL_GetLiveCommentResult tLRPC$TL_GetLiveCommentResult) {
                LiveActivity.this.isCommentLoading = false;
                LiveActivity.this.addNewCommentsToQueue(tLRPC$TL_GetLiveCommentResult.comments);
                LiveActivity.this.nextStartIdComment = tLRPC$TL_GetLiveCommentResult.nextStartId;
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                LiveActivity.this.isCommentLoading = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNewCommentsToQueue(ArrayList<TLRPC$TL_LiveComment> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.commentObjectsToAdd.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addComment(TLRPC$TL_LiveComment tLRPC$TL_LiveComment) {
        boolean z = true;
        if (this.commentObjects.size() > 1000) {
            ArrayList<TLRPC$TL_LiveComment> arrayList = this.commentObjects;
            arrayList.remove(arrayList.size() - 1);
            this.commentAdapter.notifyItemRemoved(this.commentObjects.size());
        }
        TLRPC$TL_LiveComment tLRPC$TL_LiveComment2 = null;
        try {
            tLRPC$TL_LiveComment2 = this.commentObjects.get(0);
        } catch (Exception unused) {
        }
        if (tLRPC$TL_LiveComment2 != null) {
            for (int i = 0; i < this.recyclerViewComment.getChildCount(); i++) {
                if ((this.recyclerViewComment.getChildAt(i) instanceof CommentCell) && ((CommentCell) this.recyclerViewComment.getChildAt(i)).currentObject == tLRPC$TL_LiveComment2) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (tLRPC$TL_LiveComment != null) {
            this.commentObjects.add(0, tLRPC$TL_LiveComment);
            this.commentAdapter.notifyItemInserted(0);
        } else if (MyLog.isDebugAble) {
            MyLog.handleException(new Exception("ExceptionComment"));
        }
        if (z) {
            try {
                this.recyclerViewComment.scrollToPosition(0);
            } catch (Exception unused2) {
            }
        }
    }

    public void showPublishTextDialog(String str) {
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null || str == null || str.isEmpty()) {
            return;
        }
        AlertsCreator.showPublishDialog(launchActivity, str);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.liveStatusChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        if (this.lastReqId != 0) {
            ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.lastReqId);
            this.lastReqId = 0;
        }
        RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
        if (rtmpCamera1 != null) {
            if (rtmpCamera1.isStreaming()) {
                this.rtmpCamera1.stopStream();
            }
            this.rtmpCamera1.stopPreview();
        }
        releasePlayer();
    }

    private void releasePlayer() {
        TextureView textureView = this.textureView;
        if (textureView != null) {
            if (textureView instanceof VideoEditTextureView) {
                ((VideoEditTextureView) textureView).release();
            }
            this.textureView = null;
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.releasePlayer(true);
            this.videoPlayer = null;
        }
        this.isPlaying = false;
        AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        if (this.isBroadCastMode) {
            this.needLockOrientation = true;
            lockOrientationPortrait();
        }
        getNotificationCenter().addObserver(this, NotificationCenter.liveStatusChanged);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        return true;
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onConnectionSuccessRtmp() {
        if (Build.VERSION.SDK_INT >= 19) {
            BitrateAdapter bitrateAdapter = new BitrateAdapter(new BitrateAdapter.Listener() { // from class: org.rbmain.ui.LiveActivity.14
                @Override // com.pedro.rtplibrary.util.BitrateAdapter.Listener
                public void onBitrateAdapted(int i) {
                    MyLog.e("Bitrate", "BitrateChanged: " + (i / 1024));
                    if (i <= 614400) {
                        i = 614400;
                    }
                    LiveActivity.this.rtmpCamera1.setVideoBitrateOnFly(i);
                }
            });
            this.bitrateAdapter = bitrateAdapter;
            bitrateAdapter.setMaxBitrate(this.rtmpCamera1.getBitrate());
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LiveActivity.this.onBroadCasting();
            }
        });
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onConnectionFailedRtmp(final String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity.16
            @Override // java.lang.Runnable
            public void run() {
                if (LiveActivity.this.isStopedStreamMyself) {
                    LiveActivity.this.isStopedStreamMyself = false;
                } else if (LiveActivity.this.currentLiveMessageObject == null || !LiveActivity.this.rtmpCamera1.reTry(5000L, str)) {
                    LiveActivity.this.rtmpCamera1.stopStream();
                    LiveActivity.this.onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
                } else {
                    LiveActivity.this.onConnectingBroadCast();
                }
            }
        });
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onNewBitrateRtmp(long j) {
        BitrateAdapter bitrateAdapter = this.bitrateAdapter;
        if (bitrateAdapter != null) {
            bitrateAdapter.adaptBitrate(j);
        }
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onDisconnectRtmp() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDisconnectRtmp$14();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDisconnectRtmp$14() {
        if (this.isStopedStreamMyself) {
            this.isStopedStreamMyself = false;
            return;
        }
        if (this.currentLiveMessageObject != null && !this.forceDisconnect && this.rtmpCamera1.reTry(5000L, "disconnect")) {
            onConnectingBroadCast();
            return;
        }
        this.forceDisconnect = false;
        this.rtmpCamera1.stopStream();
        onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
    }

    public void startStreamingWithUrl(String str) throws IOException {
        if (this.rtmpCamera1.isStreaming()) {
            return;
        }
        if (this.rtmpCamera1.prepareAudio()) {
            RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
            Camera.Size size = this.lastSize;
            if (rtmpCamera1.prepareVideo(size.width, size.height, 25, Build.VERSION.SDK_INT >= 19 ? 1126400 : 870400, false, this.rotation)) {
                onConnectingBroadCast();
                this.rtmpCamera1.startStream(str);
                return;
            }
        }
        onFailedBroadCasting();
    }

    void onFailedBroadCasting() {
        this.progressLayout.setVisibility(8);
        this.startBroadCastLayout.setVisibility(0);
        this.commonLayout.setVisibility(4);
        Utilities.stageQueue.cancelRunnable(this.getLiveStatusRunnable);
        if (this.rtmpCamera1.isStreaming()) {
            this.rtmpCamera1.stopStream();
        }
        this.streamingUrl = null;
    }

    void onBroadCastingFinished(FinishedReason finishedReason) {
        synchronized (this.StopObjectSync) {
            this.progressLayout.setVisibility(8);
            this.startBroadCastLayout.setVisibility(4);
            this.endBroadCastLayout.setVisibility(0);
            this.endBroadCastLayout.removeAllViews();
            TextView textView = new TextView(this.context);
            textView.setTextColor(-1);
            textView.setTextSize(1, 22.0f);
            textView.setGravity(17);
            this.endBroadCastLayout.addView(textView, LayoutHelper.createFrame(-1, -2.0f, 17, 4.0f, 0.0f, 4.0f, 0.0f));
            String string = BuildConfig.FLAVOR;
            if (finishedReason == FinishedReason.rtmpDisconnectedForBroadCaster) {
                string = LocaleController.getString("liveEndRtmpDisconnected", R.string.liveEndRtmpDisconnected);
            } else if (finishedReason == FinishedReason.liveFinishedForViewer || finishedReason == FinishedReason.liveFinishedBeforeForViewer) {
                if (finishedReason == FinishedReason.liveFinishedBeforeForViewer) {
                    string = LocaleController.getString("LiveAlreadyFinished", R.string.LiveAlreadyFinished);
                } else {
                    string = LocaleController.getString("LiveFinished", R.string.LiveFinished);
                    TextView textView2 = new TextView(this.context);
                    textView2.setTextColor(-1);
                    textView2.setTextSize(1, 20.0f);
                    textView2.setGravity(17);
                    this.endBroadCastLayout.addView(textView2, LayoutHelper.createFrame(-1, -2.0f, 17, 4.0f, 0.0f, 4.0f, 0.0f));
                    textView2.setText(LocaleController.getString("ThankForYourView", R.string.ThankForYourView));
                }
            } else if (finishedReason == FinishedReason.playbackVideoDoesntExist) {
                string = LocaleController.getString("playbackVideoDoesntExist", R.string.playbackVideoDoesntExist);
            } else if (finishedReason == FinishedReason.liveBanedForViewer) {
                string = LocaleController.getString("liveBanedForViewer", R.string.liveBanedForViewer);
            }
            textView.setText(string);
            this.commonLayout.setVisibility(4);
            releasePlayer();
            this.streamingUrl = null;
            Utilities.stageQueue.cancelRunnable(this.getLiveStatusRunnable);
            RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
            if (rtmpCamera1 != null && rtmpCamera1.isStreaming()) {
                this.rtmpCamera1.stopStream();
            }
        }
    }

    private void stopRunnable() {
        this.isCommentTimerStarted = false;
        AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
        AndroidUtilities.cancelRunOnUIThread(this.getCommentListRunnable);
        AndroidUtilities.cancelRunOnUIThread(this.updateCommentListRunnable);
        Utilities.stageQueue.cancelRunnable(this.getLiveStatusRunnable);
        Runnable runnable = this.retryRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
    }

    private void startRunnable() {
        LiveModels.PlayTypeEnum playTypeEnum;
        if (this.needToRunProgress) {
            AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
        }
        if (this.needToRunGetComments) {
            AndroidUtilities.runOnUIThread(this.getCommentListRunnable);
        }
        if (this.needToRunUpdateComments && !this.isCommentTimerStarted) {
            this.isCommentTimerStarted = true;
            AndroidUtilities.cancelRunOnUIThread(this.updateCommentListRunnable);
            AndroidUtilities.runOnUIThread(this.getCommentListRunnable);
        }
        if (this.isBroadCastMode || ((playTypeEnum = this.playType) != null && playTypeEnum == LiveModels.PlayTypeEnum.Live)) {
            Utilities.stageQueue.postRunnable(this.getLiveStatusRunnable);
        }
    }

    void onBroadCasting() {
        if (!this.hideInfo) {
            this.commonLayout.setVisibility(0);
            this.commonLayout.setAlpha(1.0f);
            this.isCommonLayoutInVisible = false;
        }
        this.progressLayout.setVisibility(8);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        MessageObject messageObject;
        if (this.isVODMode) {
            return;
        }
        try {
            if (i == NotificationCenter.liveStatusChanged && (messageObject = this.currentLiveMessageObject) != null && ((String) objArr[0]).equals(messageObject.messageOwner.media.live.live_id)) {
                this.isGettingLiveStatus = false;
                this.currentLiveMessageObject.messageOwner.media.live.live_status = (LiveModels.LiveStatus) objArr[1];
                onLiveStatusChanged();
            }
            if (i == NotificationCenter.emojiDidLoad) {
                HintAdapter hintAdapter = this.hintAdapter;
                if (hintAdapter != null) {
                    hintAdapter.notifyDataSetChanged();
                }
                CommentAdapter commentAdapter = this.commentAdapter;
                if (commentAdapter != null) {
                    commentAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception unused) {
        }
    }

    private void onLiveStatusChanged() {
        VideoPlayer videoPlayer;
        LiveModels.LiveStatus liveStatus = this.currentLiveMessageObject.messageOwner.media.live.live_status;
        if (liveStatus != null) {
            boolean z = this.isBroadCastMode;
            if (!z && liveStatus.isBlocked) {
                onBroadCastingFinished(FinishedReason.liveBanedForViewer);
                return;
            }
            LiveModels.LiveStatusEnum liveStatusEnum = liveStatus.status;
            if (liveStatusEnum == LiveModels.LiveStatusEnum.Finish) {
                if (z) {
                    if (this.rtmpCamera1.isStreaming()) {
                        this.rtmpCamera1.stopStream();
                    }
                    this.streamingUrl = null;
                    onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
                } else if (((this.playType != null && !this.isVODMode) || !liveStatus.can_play) && ((videoPlayer = this.videoPlayer) == null || videoPlayer.getPlaybackState() != 3)) {
                    onBroadCastingFinished(FinishedReason.liveFinishedForViewer);
                }
            } else if (liveStatusEnum == LiveModels.LiveStatusEnum.InProgress) {
                setMemberCount();
            }
        }
        refreshViewWithLiveSetting(false);
    }

    private void setMemberCount() {
        LiveModels.LiveStatus liveStatus = this.currentLiveMessageObject.messageOwner.media.live.live_status;
        if (liveStatus != null) {
            this.textViewMemberCount.setText(LocaleController.formatShortNumber(liveStatus.play_count, new int[1]));
        }
    }

    public void refreshViewWithLiveSetting(boolean z) {
        LiveModels.LiveStatus liveStatus = this.currentLiveMessageObject.messageOwner.media.live.live_status;
        boolean z2 = liveStatus != null && liveStatus.allow_comment;
        Boolean bool = this.lastAllowComment;
        if (bool == null || bool.booleanValue() != z2 || z) {
            if (!z2) {
                this.recyclerViewCommentHint.setVisibility(4);
                this.recyclerViewComment.setVisibility(4);
                this.editTextComment.setHint(LocaleController.getString("commentsAreOff", R.string.commentsAreOff));
                this.editTextComment.setEnabled(false);
                this.editTextComment.setAlpha(0.7f);
                this.lastAllowComment = Boolean.FALSE;
                this.isCommentTimerStarted = false;
                AndroidUtilities.cancelRunOnUIThread(this.getCommentListRunnable);
                return;
            }
            this.recyclerViewCommentHint.setVisibility(0);
            this.recyclerViewComment.setVisibility(0);
            this.editTextComment.setHint(LocaleController.getString("commentsAreOnHint", R.string.commentsAreOnHint));
            this.editTextComment.setEnabled(true);
            this.editTextComment.setAlpha(1.0f);
            this.lastAllowComment = Boolean.TRUE;
            startCommentRunnableIfNeeded();
        }
    }

    private boolean onBackClicked() {
        RtmpCamera1 rtmpCamera1;
        if (this.forceDisconnect || this.forceBack || (rtmpCamera1 = this.rtmpCamera1) == null || !rtmpCamera1.isStreaming()) {
            return false;
        }
        showAlertForStopLive();
        return true;
    }

    private void showAlertForStopLive() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString(R.string.AppName));
        builder.setMessage(LocaleController.getString("AreYouSureStopLive", R.string.AreYouSureStopLive));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showAlertForStopLive$15(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertForStopLive$15(DialogInterface dialogInterface, int i) {
        this.forceDisconnect = true;
        this.forceBack = true;
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.onBackPressed();
        }
        stopLive();
    }

    private void stopLive() {
        TLRPC$MessageMedia tLRPC$MessageMedia;
        TLRPC$TL_live tLRPC$TL_live;
        RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
        if (rtmpCamera1 != null && rtmpCamera1.isStreaming()) {
            this.startBroadCastLayout.setVisibility(0);
            this.progressLayout.setVisibility(8);
            this.rtmpCamera1.stopStream();
            this.rtmpCamera1.stopPreview();
        }
        MessageObject messageObject = this.currentLiveMessageObject;
        if (messageObject == null || (tLRPC$MessageMedia = messageObject.messageOwner.media) == null || (tLRPC$TL_live = tLRPC$MessageMedia.live) == null) {
            return;
        }
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().stopLive(tLRPC$TL_live.live_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayerState(boolean z, int i) {
        LiveModels.PlayTypeEnum playTypeEnum;
        MessageObject messageObject;
        LiveModels.PlayTypeEnum playTypeEnum2;
        if (this.videoPlayer == null) {
            return;
        }
        if (z && i != 4 && i != 1) {
            try {
                getParentActivity().getWindow().addFlags(128);
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else {
            try {
                getParentActivity().getWindow().clearFlags(128);
            } catch (Exception e2) {
                FileLog.e(e2);
            }
        }
        if ((i == 3 || i == 1) && this.seekToProgressPending != 0.0f && this.videoPlayer.getDuration() != -9223372036854775807L) {
            this.videoPlayer.seekTo((int) (this.videoPlayer.getDuration() * this.seekToProgressPending));
            this.seekToProgressPending = 0.0f;
        }
        if (this.videoPlayer.isPlaying() && i != 4 && i != 1 && (playTypeEnum2 = this.playType) != null && playTypeEnum2 == LiveModels.PlayTypeEnum.VOD) {
            if (!this.isPlaying) {
                this.isPlaying = true;
                AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
            }
        } else if (this.isPlaying || i == 4) {
            this.isPlaying = false;
            AndroidUtilities.cancelRunOnUIThread(this.updateProgressRunnable);
            if (i == 4) {
                this.videoPlayerSeekbar.setProgress(0.0f);
                this.videoPlayerSeekbarView.invalidate();
                this.videoPlayer.seekTo(0L);
                this.videoPlayer.pause();
            }
        }
        if (!this.isBroadCastMode && this.playType == LiveModels.PlayTypeEnum.Live && (messageObject = this.currentLiveMessageObject) != null && messageObject.messageOwner.media.live.live_status.status == LiveModels.LiveStatusEnum.Ready && i != 3) {
            this.textViewProgress.setText(LocaleController.getString("PreparingLive", R.string.PreparingLive));
            this.progressLayout.setVisibility(0);
            this.frameLayoutComment.setVisibility(8);
        } else {
            if (this.progressLayout.getVisibility() == 0) {
                this.progressLayout.setVisibility(4);
            }
            Boolean bool = this.lastAllowComment;
            if (bool != null && bool.booleanValue()) {
                this.frameLayoutComment.setVisibility(0);
            } else {
                this.frameLayoutComment.setVisibility(8);
            }
        }
        if (i == 3 && (playTypeEnum = this.playType) != null && playTypeEnum == LiveModels.PlayTypeEnum.VOD) {
            this.needToRunProgress = true;
        }
    }

    private void createVideoControlsInterface() {
        FrameLayout frameLayout = (FrameLayout) this.fragmentView;
        VideoPlayerControlFrameLayout videoPlayerControlFrameLayout = new VideoPlayerControlFrameLayout(frameLayout.getContext());
        frameLayout.addView(videoPlayerControlFrameLayout, LayoutHelper.createFrame(-1, 48, 83));
        final VideoPlayerSeekBar.SeekBarDelegate seekBarDelegate = new VideoPlayerSeekBar.SeekBarDelegate() { // from class: org.rbmain.ui.LiveActivity.17
            @Override // org.rbmain.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarContinuousDrag(float f) {
            }

            @Override // org.rbmain.ui.Components.VideoPlayerSeekBar.SeekBarDelegate
            public void onSeekBarDrag(float f) {
                if (LiveActivity.this.videoPlayer != null) {
                    if (LiveActivity.this.videoPlayer.getDuration() == -9223372036854775807L) {
                        LiveActivity.this.seekToProgressPending = f;
                    } else {
                        LiveActivity.this.videoPlayer.seekTo((int) (f * r0));
                    }
                    if (LiveActivity.this.isPlaying) {
                        return;
                    }
                    LiveActivity.this.resumePlayer();
                }
            }
        };
        FloatSeekBarAccessibilityDelegate floatSeekBarAccessibilityDelegate = new FloatSeekBarAccessibilityDelegate() { // from class: org.rbmain.ui.LiveActivity.18
            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public float getProgress() {
                return LiveActivity.this.videoPlayerSeekbar.getProgress();
            }

            @Override // org.rbmain.ui.Components.FloatSeekBarAccessibilityDelegate
            public void setProgress(float f) {
                seekBarDelegate.onSeekBarDrag(f);
                LiveActivity.this.videoPlayerSeekbar.setProgress(f);
                LiveActivity.this.videoPlayerSeekbarView.invalidate();
            }
        };
        View view = new View(frameLayout.getContext()) { // from class: org.rbmain.ui.LiveActivity.19
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                LiveActivity.this.videoPlayerSeekbar.draw(canvas, this);
            }
        };
        this.videoPlayerSeekbarView = view;
        view.setAccessibilityDelegate(floatSeekBarAccessibilityDelegate);
        this.videoPlayerSeekbarView.setImportantForAccessibility(1);
        videoPlayerControlFrameLayout.addView(this.videoPlayerSeekbarView, LayoutHelper.createFrame(-1, -1.0f));
        VideoPlayerSeekBar videoPlayerSeekBar = new VideoPlayerSeekBar(this.videoPlayerSeekbarView);
        this.videoPlayerSeekbar = videoPlayerSeekBar;
        videoPlayerSeekBar.setHorizontalPadding(AndroidUtilities.dp(2.0f));
        this.videoPlayerSeekbar.setColors(872415231, 872415231, -1, -1, -1, 1509949439);
        this.videoPlayerSeekbar.setDelegate(seekBarDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumePlayer() {
        LiveModels.PlayTypeEnum playTypeEnum = this.playType;
        if (playTypeEnum != null) {
            if ((playTypeEnum == LiveModels.PlayTypeEnum.VOD || playTypeEnum == LiveModels.PlayTypeEnum.Live) && !this.isPlaying) {
                this.isPlaying = true;
                preparePlayer();
                this.videoPlayer.setPlayWhenReady(true);
            }
        }
    }

    private void playStream() {
        String str = this.hostStreamUrl;
        if (str != null && !str.isEmpty()) {
            playStream(this.hostStreamUrl, this.playType);
            return;
        }
        onConnectingBroadCast();
        if (this.currentLiveMessageObject.messageOwner.media.live != null) {
            if (this.lastReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.lastReqId);
                this.lastReqId = 0;
            }
            LiveModels.GetLivePlayUrlInput getLivePlayUrlInput = new LiveModels.GetLivePlayUrlInput();
            TLRPC$TL_live tLRPC$TL_live = this.currentLiveMessageObject.messageOwner.media.live;
            getLivePlayUrlInput.live_id = tLRPC$TL_live.live_id;
            getLivePlayUrlInput.access_token = tLRPC$TL_live.access_token;
            DialogsProxy dialogsProxy = getDialogsProxy();
            TLRPC$TL_live tLRPC$TL_live2 = this.currentLiveMessageObject.messageOwner.media.live;
            this.lastReqId = dialogsProxy.getLivePlayUrl(tLRPC$TL_live2.live_id, tLRPC$TL_live2.access_token, new AnonymousClass20());
        }
    }

    /* renamed from: org.rbmain.ui.LiveActivity$20, reason: invalid class name */
    class AnonymousClass20 implements LoadListener<LiveModels.GetLivePlayUrlResult> {
        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
        }

        AnonymousClass20() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(LiveModels.GetLivePlayUrlResult getLivePlayUrlResult) {
            LiveActivity.this.onGetLivePlayUrlResponse(getLivePlayUrlResult.play_type, getLivePlayUrlResult.play_url, getLivePlayUrlResult.is_owner, getLivePlayUrlResult.can_play);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final LiveModels.GetLivePlayUrlResult getLivePlayUrlResult) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LiveActivity$20$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(getLivePlayUrlResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetLivePlayUrlResponse(LiveModels.PlayTypeEnum playTypeEnum, String str, boolean z, boolean z2) {
        this.playType = playTypeEnum;
        this.hostStreamUrl = str;
        this.is_owner = z;
        if (str != null && !str.isEmpty() && z2) {
            if (!this.hideInfo) {
                this.commonLayout.setVisibility(0);
            }
            this.progressLayout.setVisibility(4);
            playStream(this.hostStreamUrl, this.playType);
            return;
        }
        onBroadCastingFinished(FinishedReason.playbackVideoDoesntExist);
    }

    private void playStream(String str, LiveModels.PlayTypeEnum playTypeEnum) {
        if (this.isPlaying) {
            return;
        }
        if (str == null || str.isEmpty()) {
            releasePlayer();
            return;
        }
        preparePlayer();
        setPlayerOrientation();
        this.isPlaying = true;
        this.videoPlayer.preparePlayer(Uri.parse(str), playTypeEnum == LiveModels.PlayTypeEnum.Live ? "hls" : "other");
        this.videoPlayer.setPlayWhenReady(true);
        if (playTypeEnum == LiveModels.PlayTypeEnum.VOD) {
            this.isVODMode = true;
            this.frameLayoutComment.setVisibility(8);
            this.recyclerViewCommentHint.setVisibility(8);
            if (!this.is_owner) {
                this.textViewMemberCount.setVisibility(8);
            } else {
                this.textViewMemberCount.setVisibility(0);
            }
            this.liveTextView.setVisibility(8);
            createVideoControlsInterface();
            AndroidUtilities.runOnUIThread(this.updateProgressRunnable);
            this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.LiveActivity.21
                float downX;
                float downY;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.downX = motionEvent.getX();
                        this.downY = motionEvent.getY();
                    } else if (motionEvent.getAction() == 1) {
                        if (Math.abs(this.downX - motionEvent.getX()) < AndroidUtilities.dp(15.0f) && Math.abs(this.downY - motionEvent.getY()) < AndroidUtilities.dp(15.0f) && LiveActivity.this.videoPlayer != null) {
                            if (!LiveActivity.this.isPlaying) {
                                LiveActivity.this.resumePlayer();
                            }
                            if (this.downX < AndroidUtilities.dp(100.0f)) {
                                long currentPosition = LiveActivity.this.videoPlayer.getCurrentPosition() - Math.max(LiveActivity.this.videoPlayer.getDuration() / 20, 1000L);
                                VideoPlayer videoPlayer = LiveActivity.this.videoPlayer;
                                if (currentPosition <= 0) {
                                    currentPosition = 0;
                                }
                                videoPlayer.seekTo(currentPosition);
                            } else if (this.downX > LiveActivity.this.screenWidth - AndroidUtilities.dp(150.0f)) {
                                long currentPosition2 = LiveActivity.this.videoPlayer.getCurrentPosition() + Math.max(LiveActivity.this.videoPlayer.getDuration() / 20, 1000L);
                                VideoPlayer videoPlayer2 = LiveActivity.this.videoPlayer;
                                if (currentPosition2 >= LiveActivity.this.videoPlayer.getDuration()) {
                                    currentPosition2 = LiveActivity.this.videoPlayer.getDuration() - 1;
                                }
                                videoPlayer2.seekTo(currentPosition2);
                            }
                        }
                        view.performClick();
                    }
                    return true;
                }
            });
        } else {
            Utilities.stageQueue.postRunnable(this.getLiveStatusRunnable);
        }
        startRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerOrientation() {
        if (this.textureView == null || this.videoPlayer == null) {
            return;
        }
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textureView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (rotation == 1) {
            layoutParams.gravity = 17;
            this.textureView.setRotation(-90.0f);
        } else if (rotation == 3) {
            layoutParams.gravity = 17;
            this.textureView.setRotation(90.0f);
        } else {
            layoutParams.gravity = 49;
            this.textureView.setRotation(0.0f);
            layoutParams.width = this.playerWidth;
            layoutParams.height = this.playerHeight;
        }
        this.videoPlayer.setTextureView(this.textureView);
        this.textureView.requestLayout();
    }

    private void setRotationListener() {
        if (Build.VERSION.SDK_INT >= 17) {
            ((DisplayManager) this.context.getSystemService("display")).registerDisplayListener(new DisplayManager.DisplayListener() { // from class: org.rbmain.ui.LiveActivity.22
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    LiveActivity.this.setPlayerOrientation();
                }
            }, ApplicationLoader.applicationHandler);
        }
    }

    private void setHideCommonLayoutListener() {
        this.commonLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setHideCommonLayoutListener$16(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setHideCommonLayoutListener$16(View view) {
        if (this.playType == LiveModels.PlayTypeEnum.VOD) {
            return;
        }
        if (!this.isCommonLayoutInVisible) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.commonLayout, "alpha", 0.0f).setDuration(400L);
            this.animatorCommon = duration;
            duration.setInterpolator(new DecelerateInterpolator());
            this.isCommonLayoutInVisible = true;
            toggleFullscreenSwitch(true);
            this.isFullScreen = true;
        } else {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.commonLayout, "alpha", 1.0f).setDuration(400L);
            this.animatorCommon = duration2;
            duration2.setInterpolator(new AccelerateInterpolator());
            this.isCommonLayoutInVisible = false;
            toggleFullscreenSwitch(false);
            this.isFullScreen = false;
        }
        this.animatorCommon.start();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setPlayerOrientation();
    }

    private class VideoPlayerControlFrameLayout extends FrameLayout {
        private boolean ignoreLayout;
        private int parentHeight;
        private int parentWidth;
        private float progress;

        public VideoPlayerControlFrameLayout(Context context) {
            super(context);
            this.progress = 1.0f;
            setWillNotDraw(false);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.progress < 1.0f) {
                return false;
            }
            if (LiveActivity.this.videoPlayerSeekbar.onTouch(motionEvent.getAction(), motionEvent.getX() - AndroidUtilities.dp(2.0f), motionEvent.getY())) {
                getParent().requestDisallowInterceptTouchEvent(true);
                LiveActivity.this.videoPlayerSeekbarView.invalidate();
            }
            return true;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.ignoreLayout) {
                return;
            }
            super.requestLayout();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            this.ignoreLayout = true;
            int iDp = this.parentWidth > this.parentHeight ? AndroidUtilities.dp(48.0f) : 0;
            this.ignoreLayout = false;
            super.onMeasure(i, i2);
            long j = 0;
            if (LiveActivity.this.videoPlayer != null) {
                long duration = LiveActivity.this.videoPlayer.getDuration();
                if (duration != -9223372036854775807L) {
                    j = duration;
                }
            }
            long j2 = j / 1000;
            LiveActivity.this.videoPlayerSeekbar.setSize((getMeasuredWidth() - AndroidUtilities.dp(16.0f)) - iDp, getMeasuredHeight());
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (LiveActivity.this.videoPlayer != null) {
                LiveActivity.this.videoPlayer.getCurrentPosition();
                LiveActivity.this.videoPlayer.getDuration();
            }
        }
    }

    public static class CommentHintCell extends FrameLayout {
        public LiveModels.CommentLiveHintObject hintObject;
        private final TextView textView;

        public CommentHintCell(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(-1);
            textView.setTextSize(1, 13.0f);
            textView.setLines(1);
            textView.setMaxLines(1);
            textView.setSingleLine(true);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setGravity(17);
            textView.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.shape_white_comment_hint));
            textView.setShadowLayer(20.0f, 1.0f, 1.0f, -1728053248);
            addView(textView, LayoutHelper.createFrame(-2, 32.0f, 16, 4.0f, 0.0f, 4.0f, 0.0f));
        }

        public void setData(LiveModels.CommentLiveHintObject commentLiveHintObject) {
            this.hintObject = commentLiveHintObject;
            if (commentLiveHintObject != null) {
                TextView textView = this.textView;
                textView.setText(Emoji.replaceEmoji(commentLiveHintObject.text, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
            } else {
                this.textView.setText(BuildConfig.FLAVOR);
            }
        }
    }

    public static class CommentCell extends FrameLayout {
        private final AvatarDrawable avatarDrawable;
        private final BackupImageView avatarImageView;
        private int currentId;
        private CharSequence currentName;
        private TLRPC$TL_LiveComment currentObject;
        private CharSequence currentStatus;
        private final TextView nameTextView;
        private final TextView statusTextView;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public CommentCell(Context context) {
            super(context);
            this.avatarDrawable = new AvatarDrawable();
            BackupImageView backupImageView = new BackupImageView(context);
            this.avatarImageView = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(24.0f));
            boolean z = LocaleController.isRTL;
            addView(backupImageView, LayoutHelper.createFrame(32, 32.0f, (z ? 5 : 3) | 48, z ? 0.0f : 7, 2.0f, z ? 7 : 0.0f, 2.0f));
            TextView textView = new TextView(context);
            this.nameTextView = textView;
            textView.setShadowLayer(20.0f, 1.0f, 1.0f, -1728053248);
            textView.setTextColor(-1);
            textView.setTextSize(12.0f);
            textView.setGravity((LocaleController.isRTL ? 5 : 3) | 17);
            boolean z2 = LocaleController.isRTL;
            addView(textView, LayoutHelper.createFrame(-1, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 28 : 64, 2.0f, z2 ? 64 : 28, 0.0f));
            TextView textView2 = new TextView(context);
            this.statusTextView = textView2;
            textView2.setShadowLayer(20.0f, 1.0f, 1.0f, -1728053248);
            textView2.setTextSize(12.0f);
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            textView2.setTextColor(-1);
            boolean z3 = LocaleController.isRTL;
            addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z3 ? 5 : 3) | 48, z3 ? 28 : 64, 18.0f, z3 ? 64 : 28, 0.0f));
            setFocusable(true);
        }

        public CharSequence getName() {
            return this.nameTextView.getText();
        }

        public void setData(TLRPC$TL_LiveComment tLRPC$TL_LiveComment) {
            TLRPC$User tLRPC$User;
            String str;
            if (tLRPC$TL_LiveComment == null || (tLRPC$User = tLRPC$TL_LiveComment.user) == null || (str = tLRPC$TL_LiveComment.text) == null) {
                this.currentStatus = null;
                this.currentName = null;
                this.currentObject = null;
                this.nameTextView.setText(BuildConfig.FLAVOR);
                this.statusTextView.setText(BuildConfig.FLAVOR);
                this.avatarImageView.setImageDrawable(null);
                return;
            }
            this.currentStatus = str;
            this.currentObject = tLRPC$TL_LiveComment;
            if (UserObject.isDeleted(tLRPC$User)) {
                this.currentName = LocaleController.getString("HiddenName", R.string.HiddenName);
            } else {
                TLRPC$User tLRPC$User2 = tLRPC$TL_LiveComment.user;
                this.currentName = ContactsController.formatName(tLRPC$User2.first_name, tLRPC$User2.last_name).replace('\n', ' ');
            }
            update();
        }

        public Object getCurrentObject() {
            return this.currentObject;
        }

        public void setNameTypeface(Typeface typeface) {
            this.nameTextView.setTypeface(typeface);
        }

        public void setCurrentId(int i) {
            this.currentId = i;
        }

        public void update() {
            TLRPC$User tLRPC$User = this.currentObject.user;
            if (tLRPC$User == null) {
                tLRPC$User = null;
            }
            if (tLRPC$User != null) {
                this.avatarDrawable.setInfo(tLRPC$User);
            } else {
                CharSequence charSequence = this.currentName;
                if (charSequence != null) {
                    this.avatarDrawable.setInfo(this.currentId, charSequence.toString(), null);
                } else {
                    this.avatarDrawable.setInfo(this.currentId, "#", null);
                }
            }
            CharSequence charSequence2 = this.currentName;
            if (charSequence2 != null) {
                this.nameTextView.setText(charSequence2);
            } else {
                this.nameTextView.setText(tLRPC$User != null ? UserObject.getUserName(tLRPC$User) : BuildConfig.FLAVOR);
            }
            CharSequence charSequence3 = this.currentStatus;
            if (charSequence3 != null) {
                TextView textView = this.statusTextView;
                textView.setText(Emoji.replaceEmoji(charSequence3, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
            }
            if (tLRPC$User != null) {
                this.avatarImageView.setForUserOrChat(tLRPC$User, this.avatarDrawable);
            } else {
                this.avatarImageView.setImageDrawable(this.avatarDrawable);
            }
        }
    }
}
