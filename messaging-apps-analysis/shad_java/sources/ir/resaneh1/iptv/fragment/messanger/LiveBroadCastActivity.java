package ir.resaneh1.iptv.fragment.messanger;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Camera;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.stetho.websocket.CloseCodes;
import com.github.faucamp.simplertmp.io.RtmpConnection;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.jakewharton.rxbinding2.view.RxView;
import com.pedro.encoder.input.video.CameraHelper;
import com.pedro.encoder.input.video.CameraOpenException;
import com.pedro.rtplibrary.rtmp.RtmpCamera1;
import com.pedro.rtplibrary.util.BitrateAdapter;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.UIProgressBarNewStyle;
import ir.resaneh1.iptv.UIView.UI_LivePublishText;
import ir.resaneh1.iptv.apiMessanger.ApiServerException;
import ir.resaneh1.iptv.dialog.JustLinearLayoutDialog;
import ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert;
import ir.resaneh1.iptv.fragment.rubino.RubinoBottomUpAlert;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.AppRubinoPreferences;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.FragmentType;
import ir.resaneh1.iptv.model.LiveModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoProfileObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import ir.resaneh1.iptv.presenter.MainPresenterSelector;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.LiveCommentHintPresenter;
import ir.resaneh1.iptv.presenters.LiveCommentPresenter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import net.ossrs.rtmp.ConnectCheckerRtmp;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.ui.ActionBar.ActionBarAnimationType;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes3.dex */
public class LiveBroadCastActivity extends PresenterFragment implements ConnectCheckerRtmp, View.OnClickListener, NotificationCenter.NotificationCenterDelegate {
    private final Object StopObjectSync;
    private DisposableObserver<Long> addCommentTimer;
    private ObjectAnimator animatorCommon;
    private final AvatarDrawable avatarDrawable;
    private BackupImageView backupImageView;
    private BitrateAdapter bitrateAdapter;
    private View buttonClose;
    private Button buttonStart;
    SurfaceHolder.Callback callback;
    private int cameraFacing;
    ViewGroup commonLayout;
    private EditText editTextComment;
    private EditText edittextTitle;
    ViewGroup endBroadCastLayoutf;
    private Button exitButton;
    private SimpleExoPlayer exoPlayer;
    private PlayerView exoPlayerView;
    private boolean forceBack;
    private boolean forceDisconnect;
    private FrameLayout frameLayoutComment;
    private FrameLayout frameLayoutVideo;
    private DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> getCommentRequestTimer;
    private DisposableObserver getLiveStatusObservable;
    private MainAdapter hintAdapter;
    private String hostStreamUrl;
    private ImageView imageViewOption;
    private ImageView imageViewRevertCamera;
    private View imageViewSendComment;
    private ImageView imageViewUser;
    private View imageviewOptionBeforeStart;
    boolean isBroadCastMode;
    boolean isBroadcastIsByExternalPublisher;
    private boolean isCommonLayoutInVisible;
    private boolean isExternalCreator;
    private boolean isPlaying;
    private boolean isStopedStreamMyself;
    private boolean isVODMode;
    private boolean is_owner;
    private Boolean lastAllowComment;
    private Camera.Size lastSize;
    private long lastTimeCommentApiCalled;
    private LiveCommentHintPresenter liveCommentHintPresenter;
    private LiveCommentPresenter liveCommentPresenter;
    private TextView liveTextView;
    private HashMap<String, LiveModels.LiveCommentObject> myComments;
    private String nextStartIdComment;
    View.OnTouchListener onRecyclerViewTouch;
    private LiveModels.PlayTypeEnum playType;
    private int playerHeight;
    private int playerWidth;
    ViewGroup progressLayout;
    private ProgressBar progressbarVideo;
    private String publishText;
    private RecyclerView recyclerViewCommentHint;
    private int rotation;
    private RtmpCamera1 rtmpCamera1;
    private String rubinoLiveId;
    private LiveModels.LiveStatus rubinoLiveStatus;
    private RubinoProfileObject rubinoProfile;
    private final int screenWidth;
    private DisposableObserver scrollTimer;
    private FrameLayout sendProgressBarContainer;
    public boolean showClean;
    ViewGroup startBroadCastLayout;
    private Observer stopLiveObserver;
    private String streamingUrl;
    private SurfaceView surfaceView;
    private TextView textViewAvatar;
    private TextView textViewMemberCount;
    private TextView textViewProgress;
    private ImageView toggleCameraImageView;

    public enum FinishedReason {
        rtmpDisconnectedForBroadCaster,
        liveFinishedForViewer,
        liveFinishedBeforeForViewer,
        playbackVideoDoesntExist,
        liveBanedForViewer
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_live_broadcast;
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onAuthErrorRtmp() {
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onAuthSuccessRtmp() {
    }

    public LiveBroadCastActivity(RubinoProfileObject rubinoProfileObject, int i) {
        this.isExternalCreator = false;
        this.isBroadCastMode = true;
        this.isBroadcastIsByExternalPublisher = false;
        this.hostStreamUrl = null;
        this.avatarDrawable = new AvatarDrawable();
        this.streamingUrl = null;
        this.isStopedStreamMyself = false;
        this.StopObjectSync = new Object();
        this.showClean = false;
        this.playerHeight = 0;
        this.playerWidth = 0;
        this.isCommonLayoutInVisible = false;
        this.callback = new SurfaceHolder.Callback() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.22
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) throws IOException {
                LiveBroadCastActivity.this.rtmpCamera1.startPreview(LiveBroadCastActivity.this.cameraFacing == 1 ? CameraHelper.Facing.FRONT : CameraHelper.Facing.BACK, LiveBroadCastActivity.this.lastSize.width, LiveBroadCastActivity.this.lastSize.height, LiveBroadCastActivity.this.rotation);
                if (LiveBroadCastActivity.this.streamingUrl != null) {
                    LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                    liveBroadCastActivity.startStreamingWithUrl(liveBroadCastActivity.streamingUrl);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (LiveBroadCastActivity.this.rtmpCamera1.isStreaming()) {
                    LiveBroadCastActivity.this.rtmpCamera1.stopStream();
                    LiveBroadCastActivity.this.startBroadCastLayout.setVisibility(0);
                }
                LiveBroadCastActivity.this.rtmpCamera1.stopPreview();
            }
        };
        this.onRecyclerViewTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                LiveBroadCastActivity.this.startTimerToScroll();
                return false;
            }
        };
        FragmentType fragmentType = FragmentType.Rubino;
        this.fragmentName = "LiveBroadCastActivity";
        this.rubinoProfile = rubinoProfileObject;
        this.cameraFacing = i;
        this.swipeBackEnabled = false;
        this.isFullScreen = false;
        this.isForceBlackTheme = true;
        this.screenWidth = AndroidUtilities.getScreenWidth();
        MyLog.e("LiveActivity", "liveActivity" + this);
    }

    public LiveBroadCastActivity(RubinoProfileObject rubinoProfileObject) {
        this.isExternalCreator = false;
        this.isBroadCastMode = true;
        this.isBroadcastIsByExternalPublisher = false;
        this.hostStreamUrl = null;
        this.avatarDrawable = new AvatarDrawable();
        this.streamingUrl = null;
        this.isStopedStreamMyself = false;
        this.StopObjectSync = new Object();
        this.showClean = false;
        this.playerHeight = 0;
        this.playerWidth = 0;
        this.isCommonLayoutInVisible = false;
        this.callback = new SurfaceHolder.Callback() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.22
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) throws IOException {
                LiveBroadCastActivity.this.rtmpCamera1.startPreview(LiveBroadCastActivity.this.cameraFacing == 1 ? CameraHelper.Facing.FRONT : CameraHelper.Facing.BACK, LiveBroadCastActivity.this.lastSize.width, LiveBroadCastActivity.this.lastSize.height, LiveBroadCastActivity.this.rotation);
                if (LiveBroadCastActivity.this.streamingUrl != null) {
                    LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                    liveBroadCastActivity.startStreamingWithUrl(liveBroadCastActivity.streamingUrl);
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                if (LiveBroadCastActivity.this.rtmpCamera1.isStreaming()) {
                    LiveBroadCastActivity.this.rtmpCamera1.stopStream();
                    LiveBroadCastActivity.this.startBroadCastLayout.setVisibility(0);
                }
                LiveBroadCastActivity.this.rtmpCamera1.stopPreview();
            }
        };
        this.onRecyclerViewTouch = new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.26
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0 && motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    return false;
                }
                LiveBroadCastActivity.this.startTimerToScroll();
                return false;
            }
        };
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "LiveBroadCastActivity";
        this.rubinoProfile = rubinoProfileObject;
        this.screenWidth = AndroidUtilities.getScreenWidth();
        this.isBroadCastMode = false;
        this.isFullScreen = false;
        this.swipeBackEnabled = false;
        this.isForceBlackTheme = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerOrientation() {
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            ((FrameLayout.LayoutParams) this.exoPlayerView.getLayoutParams()).gravity = 17;
            this.exoPlayerView.setRotation(-90.0f);
        } else if (rotation == 3) {
            ((FrameLayout.LayoutParams) this.exoPlayerView.getLayoutParams()).gravity = 17;
            this.exoPlayerView.setRotation(90.0f);
        } else {
            ((FrameLayout.LayoutParams) this.exoPlayerView.getLayoutParams()).gravity = 49;
            this.exoPlayerView.setRotation(0.0f);
        }
        this.exoPlayerView.requestLayout();
    }

    public void setIsSwipeDownEnable(boolean z) {
        this.swipeDownEnabled = z;
        if (z) {
            this.swipeBackEnabled = false;
            this.fragmentAnimationDuration = 300.0f;
            this.presentAnimationType = ActionBarAnimationType.EXPAND;
            if (this.fragmentPresentOriginX != 0.0f && this.fragmentPresentOriginY != 0.0f) {
                this.dismissAnimationType = ActionBarAnimationType.COLLAPSE;
            } else {
                this.dismissAnimationType = ActionBarAnimationType.UTD;
            }
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        if (this.isBroadCastMode) {
            this.needLockOrientation = true;
            lockOrientationPortrait();
        }
        initVertical();
        MainAdapter mainAdapter = new MainAdapter(this.mContext, this.mainArrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.liveComment) {
                    return LiveBroadCastActivity.this.liveCommentPresenter;
                }
                return MainPresenterSelector.getInstance(LiveBroadCastActivity.this.mContext).getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                if (liveBroadCastActivity.isBroadCastMode || liveBroadCastActivity.is_owner) {
                    Titem titem = ((LiveCommentPresenter.MyViewHolder) abstractViewHolder).item;
                    if (((LiveModels.LiveCommentObject) titem).comment_user_info == null && ((LiveModels.LiveCommentObject) titem).profile_id != null) {
                        LiveBroadCastActivity.this.showBlockRubinoProfile(((LiveModels.LiveCommentObject) titem).profile_id);
                    }
                }
            }
        }, null);
        this.mainAdapter = mainAdapter;
        mainAdapter.setParentLifeCycleObservable(getLifecycle());
        this.mainRecyclerView.setAdapter(this.mainAdapter);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveModels.CommentLiveHintObject(LocaleController.getString("CommentOther", R.string.CommentOther)));
        arrayList.add(new LiveModels.CommentLiveHintObject("😍"));
        arrayList.add(new LiveModels.CommentLiveHintObject("😂😂😂"));
        arrayList.add(new LiveModels.CommentLiveHintObject("❤️❤"));
        arrayList.add(new LiveModels.CommentLiveHintObject("☹️"));
        arrayList.add(new LiveModels.CommentLiveHintObject("😎️"));
        arrayList.add(new LiveModels.CommentLiveHintObject("👍🏻"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 0, true);
        this.linearLayoutManager = linearLayoutManager;
        this.recyclerViewCommentHint.setLayoutManager(linearLayoutManager);
        MainAdapter mainAdapter2 = new MainAdapter(this.mContext, arrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.3
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.liveCommentHint) {
                    return LiveBroadCastActivity.this.liveCommentHintPresenter;
                }
                return MainPresenterSelector.getInstance(LiveBroadCastActivity.this.mContext).getPresenter(presenterItemType);
            }
        }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.4
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                LiveModels.CommentLiveHintObject commentLiveHintObject = (LiveModels.CommentLiveHintObject) abstractViewHolder.item;
                Editable text = LiveBroadCastActivity.this.editTextComment.getText();
                LiveBroadCastActivity.this.editTextComment.setText(commentLiveHintObject.text);
                LiveBroadCastActivity.this.addMyCommentComment(false);
                LiveBroadCastActivity.this.editTextComment.setText(text);
            }
        }, null);
        this.hintAdapter = mainAdapter2;
        mainAdapter2.setParentLifeCycleObservable(getLifecycle());
        this.recyclerViewCommentHint.setAdapter(this.hintAdapter);
        refreshViewWithLiveSetting(false);
        setAvatarAndTitle();
        setMemberCount();
        setComments();
        if (this.isBroadCastMode) {
            setIsSwipeDownEnable(false);
            this.swipeBackEnabled = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBlockRubinoProfile(final String str) {
        if ((!this.isBroadCastMode && !this.is_owner) || str == null || str.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("AreYouSureBlockUser", R.string.AreYouSureBlockUser));
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showBlockRubinoProfile$0(str, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBlockRubinoProfile$0(String str, DialogInterface dialogInterface, int i) {
        getRubinoController().doBlockAction(str);
    }

    private void setAvatarAndTitle() {
        if (this.showClean) {
            this.textViewAvatar.setVisibility(4);
            this.backupImageView.setVisibility(4);
            return;
        }
        RubinoProfileObject rubinoProfileObject = this.rubinoProfile;
        if (rubinoProfileObject != null) {
            String str = rubinoProfileObject.full_thumbnail_url;
            if (str != null && !str.isEmpty()) {
                GlideHelper.loadCircle(getContext(), this.imageViewUser, this.rubinoProfile.full_thumbnail_url, R.drawable.circle_grey);
            } else {
                this.imageViewUser.setImageResource(R.drawable.placeholder_avatar_man);
            }
            this.textViewAvatar.setText(this.rubinoProfile.username + BuildConfig.FLAVOR);
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
        this.startBroadCastLayout = (ViewGroup) this.fragmentView.findViewById(R.id.startLiveView);
        this.endBroadCastLayoutf = (ViewGroup) this.fragmentView.findViewById(R.id.endLiveView);
        this.textViewProgress = (TextView) this.fragmentView.findViewById(R.id.textViewProgress);
        ((EditText) this.fragmentView.findViewById(R.id.liveTitleEditText)).setHint(LocaleController.getString("LiveTitle", R.string.LiveTitle));
        ((TextView) this.fragmentView.findViewById(R.id.textViewStartLiveTitle)).setText(LocaleController.getString("StartLiveTitle", R.string.StartLiveTitle));
        ((TextView) this.fragmentView.findViewById(R.id.textViewEnterLiveTitleAndStart)).setText(LocaleController.getString("EnterLiveTitleAndStart", R.string.EnterLiveTitleAndStart));
        this.textViewProgress.setText(LocaleController.getString("Connecting", R.string.Connecting));
        View viewFindViewById = this.fragmentView.findViewById(R.id.imageViewOptionBeforeStart);
        this.imageviewOptionBeforeStart = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$findView$2(view);
            }
        });
        this.progressLayout = (ViewGroup) this.fragmentView.findViewById(R.id.progressLiveView);
        View viewFindViewById2 = this.fragmentView.findViewById(R.id.imageViewClose);
        this.buttonClose = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        Button button = (Button) this.fragmentView.findViewById(R.id.buttonExitBroadCast);
        this.exitButton = button;
        button.setText(LocaleController.getString("Close", R.string.Close));
        this.exitButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f$0.onClick(view);
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbarVideo);
        this.progressbarVideo = progressBar;
        progressBar.setMax(CloseCodes.NORMAL_CLOSURE);
        this.commonLayout = (ViewGroup) findViewById(R.id.frameLayoutCommon);
        this.imageViewSendComment = findViewById(R.id.imageViewSend);
        ImageView imageView = (ImageView) findViewById(R.id.imageViewRevertCamera);
        this.imageViewRevertCamera = imageView;
        if (!this.isBroadCastMode) {
            imageView.setVisibility(8);
        } else {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    this.f$0.onClick(view);
                }
            });
        }
        this.edittextTitle = (EditText) findViewById(R.id.liveTitleEditText);
        ImageView imageView2 = (ImageView) findViewById(R.id.toggleCamera);
        this.toggleCameraImageView = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                this.f$0.onClick(view);
            }
        });
        this.sendProgressBarContainer = (FrameLayout) findViewById(R.id.sendProgressBarContainer);
        UIProgressBarNewStyle.addToFrameWhiteWithTransparentBackground(ApplicationLoader.applicationActivity, this.sendProgressBarContainer, 30);
        this.frameLayoutComment = (FrameLayout) findViewById(R.id.frameLayoutComment);
        this.liveCommentPresenter = new LiveCommentPresenter(this.mContext);
        this.liveCommentHintPresenter = new LiveCommentHintPresenter(this.mContext);
        TextView textView = (TextView) findViewById(R.id.textViewOnlineCount);
        this.textViewMemberCount = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$findView$3(view);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.textViewLive);
        this.liveTextView = textView2;
        textView2.setText(LocaleController.getString(R.string.Live));
        ((TextView) findViewById(R.id.textviewIsLiveNow)).setText(LocaleController.getString(R.string.Live));
        EditText editText = (EditText) findViewById(R.id.editText);
        this.editTextComment = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
            }
        });
        this.recyclerViewCommentHint = (RecyclerView) findViewById(R.id.recyclerView2);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.imageViewAvatarContainer);
        this.textViewAvatar = (TextView) findViewById(R.id.textViewTitle);
        this.avatarDrawable.setTextSize(AndroidUtilities.dp(13.0f));
        ImageView imageView3 = (ImageView) findViewById(R.id.imageViewOption);
        this.imageViewOption = imageView3;
        imageView3.setOnClickListener(this);
        if (this.rubinoProfile != null) {
            ImageView imageView4 = new ImageView(getContext());
            this.imageViewUser = imageView4;
            frameLayout.addView(imageView4, LayoutHelper.createFrame(-1, -1.0f));
        }
        if (!this.isBroadCastMode) {
            PlayerView playerView = (PlayerView) findViewById(R.id.simpleExoPlayerView);
            this.exoPlayerView = playerView;
            int i = this.screenWidth;
            this.playerHeight = (int) (i * 1.7777778f);
            this.playerWidth = i;
            playerView.getLayoutParams().height = this.playerHeight;
            this.exoPlayerView.getLayoutParams().width = this.playerWidth;
            this.exoPlayerView.setVisibility(0);
            this.frameLayoutVideo = (FrameLayout) findViewById(R.id.frameLayoutVideo);
            setRotationListener();
            setPlayerOrientation();
            this.frameLayoutComment.getLayoutParams().width = this.screenWidth;
            this.frameLayoutComment.getLayoutParams().height = (int) (this.screenWidth * 0.8f);
            ((FrameLayout.LayoutParams) this.frameLayoutComment.getLayoutParams()).gravity = 85;
            this.mainRecyclerView.getLayoutParams().width = this.screenWidth;
            ViewGroup.LayoutParams layoutParams = this.mainRecyclerView.getLayoutParams();
            int i2 = this.screenWidth;
            layoutParams.height = Math.min((int) (i2 * 0.6f), (i2 - AndroidUtilities.dp(64.0f)) - AndroidUtilities.dp(108.0f));
            ((FrameLayout.LayoutParams) this.mainRecyclerView.getLayoutParams()).gravity = 85;
            findViewById(R.id.frameLayoutPlayer).setVisibility(0);
            playStream();
            return;
        }
        this.surfaceView = (SurfaceView) this.fragmentView.findViewById(R.id.surfaceView);
        Button button2 = (Button) this.fragmentView.findViewById(R.id.buttonStartBroadCast);
        this.buttonStart = button2;
        button2.setText(LocaleController.getString("Start", R.string.Start));
        this.buttonStart.setOnClickListener(this);
        this.startBroadCastLayout.setVisibility(0);
        Button button3 = (Button) this.fragmentView.findViewById(R.id.switch_camera);
        button3.setText(LocaleController.getString("SwitchCamera", R.string.SwitchCamera));
        button3.setOnClickListener(this);
        RtmpCamera1 rtmpCamera1 = new RtmpCamera1(this.surfaceView, this);
        this.rtmpCamera1 = rtmpCamera1;
        rtmpCamera1.setReTries(10);
        this.surfaceView.getHolder().addCallback(this.callback);
        float f = 100.0f;
        float f2 = 10000.0f;
        for (Camera.Size size : this.rtmpCamera1.getResolutionsFront()) {
            float fAbs = Math.abs(((size.width * 1.0f) / size.height) - 1.7777778f);
            if (fAbs <= f) {
                if (fAbs != 0.0f || f != 0.0f || Math.abs(size.height - 480) <= f2) {
                    float fAbs2 = Math.abs(size.height - 480);
                    this.lastSize = size;
                    this.rotation = 90;
                    f2 = fAbs2;
                    f = fAbs;
                }
            }
            float fAbs3 = Math.abs(((size.height * 1.0f) / size.width) - 1.7777778f);
            if (fAbs3 <= f && (fAbs3 != 0.0f || f != 0.0f || Math.abs(size.width - 480) <= f2)) {
                float fAbs4 = Math.abs(size.width - 480);
                this.lastSize = size;
                this.rotation = 0;
                f2 = fAbs4;
                f = fAbs3;
            }
        }
        Camera.Size size2 = this.lastSize;
        float f3 = (size2.height * 1.0f) / size2.width;
        if (f3 < 1.0f) {
            f3 = 1.0f / f3;
        }
        float f4 = 1.7777778f / f3;
        this.surfaceView.getLayoutParams().height = (int) (((int) (this.screenWidth * f3)) * f4);
        this.surfaceView.getLayoutParams().width = (int) (this.screenWidth * f4);
        SurfaceView surfaceView = this.surfaceView;
        surfaceView.setLayoutParams(surfaceView.getLayoutParams());
        this.surfaceView.getHolder().setFixedSize(this.surfaceView.getLayoutParams().width, this.surfaceView.getLayoutParams().height);
        this.surfaceView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findView$2(View view) {
        PopupMenu popupMenu = new PopupMenu(this.mContext, view);
        popupMenu.getMenuInflater().inflate(R.menu.live_setting, popupMenu.getMenu());
        popupMenu.getMenu().getItem(0).setTitle(LocaleController.getString(R.string.setting));
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda6
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return this.f$0.lambda$findView$1(menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$findView$1(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.liveSetting) {
            return false;
        }
        ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(1).delay(150L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) {
                LiveBroadCastActivity.this.presentFragment(new LiveSettingActivity());
            }
        }));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findView$3(View view) {
        if ((!this.is_owner && !this.isBroadCastMode) || this.rubinoProfile == null || this.rubinoLiveStatus == null || this.rubinoLiveId == null) {
            return;
        }
        showDialog(new RubinoLiveViewerAlert(getContext(), this.rubinoLiveId, new RubinoLiveViewerAlert.OnItemClicked(this) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.6
            @Override // ir.resaneh1.iptv.fragment.messanger.RubinoLiveViewerAlert.OnItemClicked
            public void onclick(RubinoProfileObject rubinoProfileObject) {
            }
        }));
    }

    private void setHideCommonLayoutListener() {
        this.commonLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setHideCommonLayoutListener$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setHideCommonLayoutListener$4(View view) {
        if (!this.isCommonLayoutInVisible) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.commonLayout, "alpha", 0.0f).setDuration(250L);
            this.animatorCommon = duration;
            duration.setInterpolator(new DecelerateInterpolator());
            this.isCommonLayoutInVisible = true;
            toggleFullscreenSwitch(true);
            this.isFullScreen = true;
        } else {
            ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.commonLayout, "alpha", 1.0f).setDuration(250L);
            this.animatorCommon = duration2;
            duration2.setInterpolator(new AccelerateInterpolator());
            this.isCommonLayoutInVisible = false;
            toggleFullscreenSwitch(false);
            this.isFullScreen = false;
        }
        this.animatorCommon.start();
    }

    private void setRotationListener() {
        if (Build.VERSION.SDK_INT >= 17) {
            ((DisplayManager) this.mContext.getSystemService("display")).registerDisplayListener(new DisplayManager.DisplayListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.8
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    LiveBroadCastActivity.this.setPlayerOrientation();
                }
            }, ApplicationLoader.applicationHandler);
        }
    }

    private void initVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 1, true);
        this.linearLayoutManager = linearLayoutManager;
        this.mainRecyclerView.setLayoutManager(linearLayoutManager);
    }

    void makeViewForPlaying(LiveModels.PlayTypeEnum playTypeEnum) {
        if (!this.showClean) {
            this.commonLayout.setVisibility(0);
            this.commonLayout.setAlpha(1.0f);
            this.isCommonLayoutInVisible = false;
            ObjectAnimator objectAnimator = this.animatorCommon;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        if (playTypeEnum == LiveModels.PlayTypeEnum.VOD) {
            this.frameLayoutComment.setVisibility(8);
            this.recyclerViewCommentHint.setVisibility(8);
            this.mainRecyclerView.setVisibility(8);
            if (!this.is_owner) {
                this.textViewMemberCount.setVisibility(8);
            } else {
                this.textViewMemberCount.setVisibility(0);
            }
            this.liveTextView.setVisibility(8);
            this.isVODMode = true;
        } else {
            setHideCommonLayoutListener();
            callGetComments();
            callGetLiveStatus();
        }
        playStream();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.liveStatusChanged);
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.emojiDidLoad);
        RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
        if (rtmpCamera1 != null) {
            if (rtmpCamera1.isStreaming()) {
                this.rtmpCamera1.stopStream();
            }
            this.rtmpCamera1.stopPreview();
        }
        stopAndReleasePlayer();
        CompositeDisposable compositeDisposable = ((PresenterFragment) this).compositeDisposable;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        try {
            if (!ApplicationLoader.applicationActivity.getMainTabFragment().isPaused) {
                ApplicationLoader.applicationActivity.getMainTabFragment().rubinoFragment.refreshStory();
            } else {
                ApplicationLoader.applicationActivity.getMainTabFragment().rubinoFragment.needToRefreshStory = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        getNotificationCenter().addObserver(this, NotificationCenter.liveStatusChanged);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.emojiDidLoad);
        return true;
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onConnectionSuccessRtmp() {
        if (Build.VERSION.SDK_INT >= 19) {
            BitrateAdapter bitrateAdapter = new BitrateAdapter(new BitrateAdapter.Listener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.9
                @Override // com.pedro.rtplibrary.util.BitrateAdapter.Listener
                public void onBitrateAdapted(int i) {
                    MyLog.e("Bitrate", "BitrateChanged: " + (i / 1024));
                    if (i <= 614400) {
                        i = 614400;
                    }
                    LiveBroadCastActivity.this.rtmpCamera1.setVideoBitrateOnFly(i);
                }
            });
            this.bitrateAdapter = bitrateAdapter;
            bitrateAdapter.setMaxBitrate(this.rtmpCamera1.getBitrate());
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LiveBroadCastActivity.this.onBroadCasting();
            }
        });
    }

    @Override // net.ossrs.rtmp.ConnectCheckerRtmp
    public void onConnectionFailedRtmp(String str) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onConnectionFailedRtmp$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConnectionFailedRtmp$5() {
        if (this.isStopedStreamMyself) {
            this.isStopedStreamMyself = false;
        } else {
            this.rtmpCamera1.stopStream();
            onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
        }
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (LiveBroadCastActivity.this.isStopedStreamMyself) {
                    LiveBroadCastActivity.this.isStopedStreamMyself = false;
                    return;
                }
                LiveBroadCastActivity.this.forceDisconnect = false;
                LiveBroadCastActivity.this.rtmpCamera1.stopStream();
                LiveBroadCastActivity.this.onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
            }
        });
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
        onFaildBroadCasting();
    }

    void onFaildBroadCasting() {
        this.progressLayout.setVisibility(8);
        this.startBroadCastLayout.setVisibility(0);
        this.commonLayout.setVisibility(4);
        this.streamingUrl = null;
        DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver = this.getCommentRequestTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = this.getLiveStatusObservable;
        if (disposableObserver2 != null) {
            disposableObserver2.dispose();
        }
        if (this.rtmpCamera1.isStreaming()) {
            this.rtmpCamera1.stopStream();
        }
        ((PresenterFragment) this).compositeDisposable.dispose();
        ((PresenterFragment) this).compositeDisposable = new CompositeDisposable();
    }

    void onBroadCastingFinished(FinishedReason finishedReason) {
        String string;
        synchronized (this.StopObjectSync) {
            this.progressLayout.setVisibility(8);
            this.startBroadCastLayout.setVisibility(4);
            this.endBroadCastLayoutf.setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.textViewEndDescription);
            textView.setText(LocaleController.getString("LiveEnded", R.string.LiveEnded));
            String string2 = BuildConfig.FLAVOR;
            if (finishedReason == FinishedReason.rtmpDisconnectedForBroadCaster) {
                string2 = LocaleController.getString(R.string.liveEndRtmpDisconnected);
            } else if (finishedReason == FinishedReason.liveFinishedForViewer || finishedReason == FinishedReason.liveFinishedBeforeForViewer) {
                if (finishedReason == FinishedReason.liveFinishedBeforeForViewer) {
                    string = LocaleController.getString("LiveAlreadyFinished", R.string.LiveAlreadyFinished);
                } else {
                    string = LocaleController.getString("LiveFinished", R.string.LiveFinished);
                    ((TextView) findViewById(R.id.textViewEndDescription2)).setText(LocaleController.getString("ThankForYourView", R.string.ThankForYourView));
                }
                string2 = string;
                if (this.rubinoProfile != null) {
                    getStoryController().setProfileHasLive(this.rubinoProfile, false, true);
                }
            } else if (finishedReason == FinishedReason.playbackVideoDoesntExist) {
                string2 = LocaleController.getString(R.string.playbackVideoDoesntExist);
            } else if (finishedReason == FinishedReason.liveBanedForViewer) {
                string2 = LocaleController.getString(R.string.liveBanedForViewer);
                if (this.rubinoProfile != null) {
                    getStoryController().setProfileHasLive(this.rubinoProfile, false, true);
                }
            }
            textView.setText(string2);
            this.commonLayout.setVisibility(4);
            PlayerView playerView = this.exoPlayerView;
            if (playerView != null) {
                playerView.setVisibility(4);
            }
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.stop();
                SimpleExoPlayer simpleExoPlayer2 = this.exoPlayer;
                if (simpleExoPlayer2 != null) {
                    simpleExoPlayer2.release();
                }
                this.exoPlayer = null;
            }
            this.streamingUrl = null;
            DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver = this.getCommentRequestTimer;
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
            DisposableObserver disposableObserver2 = this.getLiveStatusObservable;
            if (disposableObserver2 != null) {
                disposableObserver2.dispose();
            }
            RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
            if (rtmpCamera1 != null && rtmpCamera1.isStreaming()) {
                this.rtmpCamera1.stopStream();
            }
            ((PresenterFragment) this).compositeDisposable.dispose();
            ((PresenterFragment) this).compositeDisposable = new CompositeDisposable();
        }
    }

    void onConnectingBroadCast() {
        this.startBroadCastLayout.setVisibility(8);
        this.progressLayout.setVisibility(0);
        this.commonLayout.setVisibility(4);
    }

    void onBroadCasting() {
        if (!this.showClean) {
            this.commonLayout.setVisibility(0);
            this.commonLayout.setAlpha(1.0f);
            this.isCommonLayoutInVisible = false;
            ObjectAnimator objectAnimator = this.animatorCommon;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        this.progressLayout.setVisibility(8);
    }

    void requestForBroadCastRubino() {
        this.isBroadcastIsByExternalPublisher = getAppPreferences().getBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false);
        onConnectingBroadCast();
        this.nextStartIdComment = null;
        LiveModels.RubinoSendLiveInput rubinoSendLiveInput = new LiveModels.RubinoSendLiveInput();
        rubinoSendLiveInput.profile_id = this.rubinoProfile.id;
        rubinoSendLiveInput.title = "-";
        rubinoSendLiveInput.device_type = this.isBroadcastIsByExternalPublisher ? LiveModels.DeviceTypeEnum.Software : LiveModels.DeviceTypeEnum.Mobile;
        rubinoSendLiveInput.rnd = AndroidUtilities.getNextRnd();
        ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoSendLive(rubinoSendLiveInput).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoSendLiveOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.12
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<LiveModels.RubinoSendLiveOutput> messangerOutput) throws IOException {
                LiveBroadCastActivity.this.rubinoLiveId = messangerOutput.data.live_id;
                LiveBroadCastActivity.this.rubinoLiveStatus = new LiveModels.LiveStatus();
                LiveBroadCastActivity.this.rubinoLiveStatus.status = LiveModels.LiveStatus.LiveStatusEnum.Ready;
                LiveBroadCastActivity.this.rubinoLiveStatus.allow_comment = true;
                LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                LiveModels.RubinoSendLiveOutput rubinoSendLiveOutput = messangerOutput.data;
                liveBroadCastActivity.afterSuccessSendLive(rubinoSendLiveOutput.publish_url, rubinoSendLiveOutput.publish_text, null);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                LiveBroadCastActivity.this.onFaildBroadCasting();
            }
        }));
    }

    void afterSuccessSendLive(String str, String str2, LiveModels.LiveMessage liveMessage) throws IOException {
        this.streamingUrl = str;
        if (this.isBroadcastIsByExternalPublisher) {
            ApplicationLoader.applicationActivity.onBackPressed();
            this.publishText = str2;
            showPublishTextDialog(str2);
        } else {
            startStreamingWithUrl(str);
            callGetComments();
            callGetLiveStatus();
            refreshViewWithLiveSetting(true);
            setAvatarAndTitle();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        int i = 0;
        try {
            switch (view.getId()) {
                case R.id.buttonExitBroadCast /* 2131361951 */:
                    if (ApplicationLoader.applicationActivity != null) {
                        this.forceDisconnect = true;
                        this.forceBack = true;
                        ApplicationLoader.applicationActivity.onBackPressed();
                        return;
                    }
                    return;
                case R.id.buttonStartBroadCast /* 2131361958 */:
                    AndroidUtilities.hideKeyboard(this.edittextTitle);
                    if (this.rubinoProfile != null) {
                        requestForBroadCastRubino();
                        return;
                    }
                    return;
                case R.id.imageViewClose /* 2131362340 */:
                    if (onBackClicked() || ApplicationLoader.applicationActivity == null) {
                        return;
                    }
                    this.forceDisconnect = true;
                    this.forceBack = true;
                    ApplicationLoader.applicationActivity.onBackPressed();
                    return;
                case R.id.imageViewOption /* 2131362357 */:
                    onOptionClicked();
                    return;
                case R.id.imageViewRevertCamera /* 2131362371 */:
                    RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
                    if (rtmpCamera1 != null) {
                        rtmpCamera1.switchCamera();
                        if (this.cameraFacing != 1) {
                            i = 1;
                        }
                        this.cameraFacing = i;
                        break;
                    } else {
                        return;
                    }
                case R.id.switch_camera /* 2131362864 */:
                case R.id.toggleCamera /* 2131363047 */:
                    this.rtmpCamera1.switchCamera();
                    if (this.cameraFacing != 1) {
                        i = 1;
                    }
                    this.cameraFacing = i;
                    break;
                default:
                    return;
            }
        } catch (CameraOpenException unused) {
        }
    }

    private void onOptionClicked() {
        String str;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
        if (this.isBroadCastMode || this.is_owner || this.isExternalCreator) {
            if (liveStatus != null && liveStatus.allow_comment) {
                arrayList.add(LocaleController.getString(R.string.stopComment));
                arrayList2.add(1);
            } else {
                arrayList.add(LocaleController.getString(R.string.turnOnComment));
                arrayList2.add(2);
            }
            if (this.isExternalCreator && (str = this.publishText) != null && !str.isEmpty()) {
                arrayList.add(LocaleController.getString(R.string.publishInfo));
                arrayList2.add(4);
            }
            arrayList.add(LocaleController.getString(R.string.stopLive));
            arrayList2.add(5);
        } else {
            arrayList.add(LocaleController.getString(R.string.reportLive));
            arrayList2.add(3);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[0]), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (((Integer) arrayList2.get(i)).intValue() == 1) {
                    LiveBroadCastActivity.this.setLiveSetting(false);
                    return;
                }
                if (((Integer) arrayList2.get(i)).intValue() == 2) {
                    LiveBroadCastActivity.this.setLiveSetting(true);
                    return;
                }
                if (((Integer) arrayList2.get(i)).intValue() == 3) {
                    if (LiveBroadCastActivity.this.rubinoProfile != null) {
                        ArrayList arrayList3 = new ArrayList();
                        final RubinoBottomUpAlert rubinoBottomUpAlertCreateRubinoDialogItems = RubinoBottomUpAlert.createRubinoDialogItems(ApplicationLoader.applicationActivity.getLastFragment(), LocaleController.getString(R.string.rubinoReport), arrayList3);
                        arrayList3.add(new Rubino.AlertBoldItem(LocaleController.getString(R.string.rubinoReportLiveQuestion)));
                        arrayList3.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoSpam), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.13.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                LiveBroadCastActivity.this.getRubinoController().reportLive(LiveBroadCastActivity.this.rubinoProfile.id, LiveBroadCastActivity.this.rubinoLiveId, 1);
                                rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                            }
                        }));
                        arrayList3.add(new Rubino.AlertItem(LocaleController.getString(R.string.rubinoInAppropriate), 0, new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.13.2
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                LiveBroadCastActivity.this.getRubinoController().reportLive(LiveBroadCastActivity.this.rubinoProfile.id, LiveBroadCastActivity.this.rubinoLiveId, 2);
                                rubinoBottomUpAlertCreateRubinoDialogItems.dismiss();
                            }
                        }));
                        rubinoBottomUpAlertCreateRubinoDialogItems.listAdapter.notifyDataSetChanged();
                        LiveBroadCastActivity.this.showDialog(rubinoBottomUpAlertCreateRubinoDialogItems);
                        return;
                    }
                    return;
                }
                if (((Integer) arrayList2.get(i)).intValue() == 4) {
                    LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                    liveBroadCastActivity.showPublishTextDialog(liveBroadCastActivity.publishText);
                } else if (((Integer) arrayList2.get(i)).intValue() == 5) {
                    LiveBroadCastActivity.this.showAlertForStopLive();
                }
            }
        });
        showDialog(builder.create());
    }

    public void showPublishTextDialog(String str) {
        LaunchActivity launchActivity = ApplicationLoader.applicationActivity;
        if (launchActivity == null || str == null || str.isEmpty()) {
            return;
        }
        final UI_LivePublishText uI_LivePublishText = new UI_LivePublishText();
        uI_LivePublishText.createView(launchActivity);
        uI_LivePublishText.textView.setText(str);
        JustLinearLayoutDialog justLinearLayoutDialog = new JustLinearLayoutDialog(launchActivity, uI_LivePublishText.view);
        uI_LivePublishText.shareButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().shareStringOrLink(((Object) uI_LivePublishText.textView.getText()) + BuildConfig.FLAVOR);
            }
        });
        uI_LivePublishText.copyButton.setOnClickListener(new View.OnClickListener(this) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MainClickHandler().onCopyClicked(((Object) uI_LivePublishText.textView.getText()) + BuildConfig.FLAVOR);
            }
        });
        justLinearLayoutDialog.show();
    }

    public void setLiveSetting(boolean z) {
        if ((this.isBroadCastMode || this.is_owner) && this.rubinoLiveId != null) {
            LiveModels.RubinoSetLiveSettingInput rubinoSetLiveSettingInput = new LiveModels.RubinoSetLiveSettingInput();
            rubinoSetLiveSettingInput.allow_comment = z;
            rubinoSetLiveSettingInput.live_id = this.rubinoLiveId;
            rubinoSetLiveSettingInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            ArrayList<LiveModels.EnumParams> arrayList = new ArrayList<>();
            rubinoSetLiveSettingInput.updated_parameters = arrayList;
            arrayList.add(LiveModels.EnumParams.allow_comment);
            ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoSetLiveSetting(rubinoSetLiveSettingInput).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoSetLiveSettingOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.16
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<LiveModels.RubinoSetLiveSettingOutput> messangerOutput) {
                    LiveBroadCastActivity.this.rubinoLiveStatus = messangerOutput.data.live_status;
                    LiveBroadCastActivity.this.onLiveStatusChanged();
                }
            }));
        }
    }

    public void refreshViewWithLiveSetting(boolean z) {
        LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
        boolean z2 = liveStatus != null && liveStatus.allow_comment;
        Boolean bool = this.lastAllowComment;
        if (bool == null || bool.booleanValue() != z2 || z) {
            if (!z2) {
                this.recyclerViewCommentHint.setVisibility(4);
                this.mainRecyclerView.setVisibility(4);
                this.editTextComment.setHint(LocaleController.getString(R.string.commentsAreOff));
                this.editTextComment.setEnabled(false);
                this.editTextComment.setAlpha(0.7f);
                this.lastAllowComment = Boolean.FALSE;
                DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver = this.getCommentRequestTimer;
                if (disposableObserver != null) {
                    disposableObserver.dispose();
                    return;
                }
                return;
            }
            this.recyclerViewCommentHint.setVisibility(0);
            this.mainRecyclerView.setVisibility(0);
            this.editTextComment.setHint(LocaleController.getString(R.string.commentsAreOnHint));
            this.editTextComment.setEnabled(true);
            this.editTextComment.setAlpha(1.0f);
            this.lastAllowComment = Boolean.TRUE;
            DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver2 = this.getCommentRequestTimer;
            if (disposableObserver2 == null || disposableObserver2.isDisposed()) {
                callGetComments();
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertForStopLive() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString(R.string.AppName));
        builder.setMessage(LocaleController.getString(R.string.AreYouSureStopLive));
        builder.setPositiveButton(LocaleController.getString(R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showAlertForStopLive$6(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString(R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertForStopLive$6(DialogInterface dialogInterface, int i) {
        this.forceDisconnect = true;
        this.forceBack = true;
        if (ApplicationLoader.applicationActivity != null) {
            ApplicationLoader.applicationActivity.onBackPressed();
        }
        stopLive();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (onBackClicked()) {
            return false;
        }
        return super.onBackPressed();
    }

    private void stopLive() {
        ((PresenterFragment) this).compositeDisposable.dispose();
        ((PresenterFragment) this).compositeDisposable = new CompositeDisposable();
        RtmpCamera1 rtmpCamera1 = this.rtmpCamera1;
        if (rtmpCamera1 != null && rtmpCamera1.isStreaming()) {
            this.startBroadCastLayout.setVisibility(0);
            this.progressLayout.setVisibility(8);
            this.rtmpCamera1.stopStream();
        }
        RubinoProfileObject rubinoProfileObject = this.rubinoProfile;
        if (rubinoProfileObject == null || !rubinoProfileObject.id.equals(AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id)) {
            return;
        }
        getStoryController().setProfileHasLive(this.rubinoProfile, false, true);
        LiveModels.RubinoStopLiveInput rubinoStopLiveInput = new LiveModels.RubinoStopLiveInput();
        rubinoStopLiveInput.live_id = this.rubinoLiveId;
        rubinoStopLiveInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
        this.stopLiveObserver = getApiRequestMessangerRx().rubinoStopLive(rubinoStopLiveInput).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoStopLiveOutput>>(this) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.17
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<LiveModels.RubinoStopLiveOutput> messangerOutput) {
            }
        });
    }

    public void playStream() {
        String str = this.hostStreamUrl;
        if (str != null && !str.isEmpty()) {
            playStream(this.hostStreamUrl, this.playType);
            return;
        }
        onConnectingBroadCast();
        if (this.rubinoProfile != null) {
            LiveModels.RubinoGetLiveInfolInput rubinoGetLiveInfolInput = new LiveModels.RubinoGetLiveInfolInput();
            rubinoGetLiveInfolInput.live_profile_id = this.rubinoProfile.id;
            rubinoGetLiveInfolInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getInstaCurrentProfileObject().id;
            ((PresenterFragment) this).compositeDisposable.add((Disposable) getApiRequestMessangerRx().rubinoGetLiveInfo(rubinoGetLiveInfolInput).delay(200L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoGetLiveInfoOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.18
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<LiveModels.RubinoGetLiveInfoOutput> messangerOutput) {
                    LiveModels.RubinoGetLiveInfoOutput rubinoGetLiveInfoOutput = messangerOutput.data;
                    if (!rubinoGetLiveInfoOutput.is_live_exist) {
                        LiveBroadCastActivity.this.onBroadCastingFinished(FinishedReason.liveFinishedBeforeForViewer);
                        return;
                    }
                    LiveBroadCastActivity.this.rubinoLiveId = rubinoGetLiveInfoOutput.live_id;
                    LiveBroadCastActivity.this.rubinoLiveStatus = messangerOutput.data.live_status;
                    LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                    LiveModels.RubinoGetLiveInfoOutput rubinoGetLiveInfoOutput2 = messangerOutput.data;
                    liveBroadCastActivity.onGetLivePlayUrlResponse(rubinoGetLiveInfoOutput2.play_type, rubinoGetLiveInfoOutput2.play_url, rubinoGetLiveInfoOutput2.is_owner, rubinoGetLiveInfoOutput2.live_status);
                    LiveBroadCastActivity.this.onLiveStatusChanged();
                }
            }));
        }
    }

    void onGetLivePlayUrlResponse(LiveModels.PlayTypeEnum playTypeEnum, String str, boolean z, LiveModels.LiveStatus liveStatus) {
        this.playType = playTypeEnum;
        this.hostStreamUrl = str;
        this.is_owner = z;
        if (str != null && !str.isEmpty() && liveStatus.can_play) {
            if (!this.showClean) {
                this.commonLayout.setVisibility(0);
                this.commonLayout.setAlpha(1.0f);
                this.isCommonLayoutInVisible = false;
                ObjectAnimator objectAnimator = this.animatorCommon;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
            }
            this.progressLayout.setVisibility(4);
            makeViewForPlaying(this.playType);
            playStream(this.hostStreamUrl, this.playType);
            return;
        }
        onBroadCastingFinished(FinishedReason.playbackVideoDoesntExist);
    }

    public void playStream(String str, LiveModels.PlayTypeEnum playTypeEnum) {
        MediaSource mediaSourceCreateMediaSource;
        if (this.isPlaying) {
            return;
        }
        if (str == null || str.isEmpty()) {
            stopPlayer();
            return;
        }
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        Context context = this.mContext;
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, Util.getUserAgent(context, "exoplayer2example"), defaultBandwidthMeter);
        if (playTypeEnum == LiveModels.PlayTypeEnum.Live) {
            mediaSourceCreateMediaSource = new HlsMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(str));
        } else {
            mediaSourceCreateMediaSource = new ProgressiveMediaSource.Factory(defaultDataSourceFactory).createMediaSource(Uri.parse(str));
        }
        if (this.exoPlayer == null) {
            initExoPlayer();
        }
        stopPlayer();
        this.isPlaying = true;
        this.exoPlayer.setPlayWhenReady(true);
        this.exoPlayer.prepare(mediaSourceCreateMediaSource);
        LiveModels.PlayTypeEnum playTypeEnum2 = LiveModels.PlayTypeEnum.VOD;
        if (playTypeEnum == playTypeEnum2) {
            this.frameLayoutVideo.setOnTouchListener(new View.OnTouchListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.19
                float downX;
                float downY;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.downX = motionEvent.getX();
                        this.downY = motionEvent.getY();
                    } else if (motionEvent.getAction() == 1 && Math.abs(this.downX - motionEvent.getX()) < AndroidUtilities.dp(15.0f) && Math.abs(this.downY - motionEvent.getY()) < AndroidUtilities.dp(15.0f) && LiveBroadCastActivity.this.exoPlayer != null) {
                        if (this.downX < AndroidUtilities.dp(100.0f)) {
                            long currentPosition = LiveBroadCastActivity.this.exoPlayer.getCurrentPosition() - Math.max(LiveBroadCastActivity.this.exoPlayer.getDuration() / 20, 1000L);
                            SimpleExoPlayer simpleExoPlayer = LiveBroadCastActivity.this.exoPlayer;
                            if (currentPosition <= 0) {
                                currentPosition = 0;
                            }
                            simpleExoPlayer.seekTo(currentPosition);
                        } else if (this.downX > LiveBroadCastActivity.this.screenWidth - AndroidUtilities.dp(150.0f)) {
                            long currentPosition2 = LiveBroadCastActivity.this.exoPlayer.getCurrentPosition() + Math.max(LiveBroadCastActivity.this.exoPlayer.getDuration() / 20, 1000L);
                            SimpleExoPlayer simpleExoPlayer2 = LiveBroadCastActivity.this.exoPlayer;
                            if (currentPosition2 >= LiveBroadCastActivity.this.exoPlayer.getDuration()) {
                                currentPosition2 = LiveBroadCastActivity.this.exoPlayer.getDuration() - 1;
                            }
                            simpleExoPlayer2.seekTo(currentPosition2);
                        }
                    }
                    return true;
                }
            });
        }
        if (playTypeEnum == playTypeEnum2) {
            this.progressbarVideo.setVisibility(0);
            ((PresenterFragment) this).compositeDisposable.add((Disposable) Observable.just(0).delay(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).repeat().subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.20
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    if (LiveBroadCastActivity.this.exoPlayer == null || LiveBroadCastActivity.this.exoPlayer.getDuration() <= 0) {
                        return;
                    }
                    LiveBroadCastActivity.this.progressbarVideo.setProgress((int) ((LiveBroadCastActivity.this.exoPlayer.getCurrentPosition() * 1000) / LiveBroadCastActivity.this.exoPlayer.getDuration()));
                }
            }));
        }
    }

    public void stopPlayer() {
        this.isPlaying = false;
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
            this.exoPlayer.stop();
        }
    }

    public void stopAndReleasePlayer() {
        if (this.exoPlayer != null) {
            stopPlayer();
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.release();
            }
            this.exoPlayer = null;
        }
    }

    private void initExoPlayer() {
        if (this.exoPlayer == null) {
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance(this.mContext, new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        }
        this.exoPlayer.setPlayWhenReady(true);
        this.exoPlayerView.setPlayer(this.exoPlayer);
        this.exoPlayerView.setUseController(false);
        this.exoPlayerView.setResizeMode(4);
        this.exoPlayerView.setBackgroundColor(0);
        this.exoPlayer.addListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.21
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
                Player.EventListener.CC.$default$onExperimentalOffloadSchedulingEnabledChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                onLoadingChanged(z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                Player.EventListener.CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                Player.EventListener.CC.$default$onPlayWhenReadyChanged(this, z, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackStateChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackStateChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPositionDiscontinuity(int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onRepeatModeChanged(int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onSeekProcessed() {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onShuffleModeEnabledChanged(boolean z) {
            }

            /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTimelineChanged(Timeline timeline, Object obj, int i) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onLoadingChanged(boolean z) {
                if (z) {
                    return;
                }
                MyLog.e("GameFragment", "loading false");
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean z, int i) {
                LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                if (!liveBroadCastActivity.isBroadCastMode && i == 4) {
                    liveBroadCastActivity.onBroadCastingFinished(FinishedReason.liveFinishedForViewer);
                }
                if (LiveBroadCastActivity.this.progressLayout.getVisibility() == 0) {
                    LiveBroadCastActivity.this.progressLayout.setVisibility(4);
                }
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                LiveBroadCastActivity.this.isPlaying = false;
                ((PresenterFragment) LiveBroadCastActivity.this).compositeDisposable.add((Disposable) Observable.timer(700L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.21.1
                    @Override // io.reactivex.Observer
                    public void onComplete() {
                    }

                    @Override // io.reactivex.Observer
                    public void onError(Throwable th) {
                    }

                    @Override // io.reactivex.Observer
                    public void onNext(Long l) {
                        LiveBroadCastActivity.this.playStream();
                    }
                }));
            }
        });
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        RtmpCamera1 rtmpCamera1;
        super.onPause();
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            if (this.isBroadCastMode && (rtmpCamera1 = this.rtmpCamera1) != null) {
                this.isStopedStreamMyself = true;
                rtmpCamera1.stopStream();
                this.rtmpCamera1.stopPreview();
            }
            LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
            if (!this.isBroadCastMode || liveStatus == null || liveStatus.status == LiveModels.LiveStatus.LiveStatusEnum.InProgress) {
                return;
            }
            LiveModels.LiveStatus.LiveStatusEnum liveStatusEnum = LiveModels.LiveStatus.LiveStatusEnum.Ready;
        } catch (Exception unused) {
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment, org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (this.isBroadCastMode) {
            lockOrientationPortrait();
        }
        if (this.isBroadCastMode) {
            if (getAppPreferences().getBoolean(AppPreferences.Key.LiveBroadCastExternalMode, false)) {
                this.buttonStart.setText(LocaleController.getString("SendLiveByExternalDevice", R.string.SendLiveByExternalDevice));
            } else {
                this.buttonStart.setText(LocaleController.getString("Start", R.string.Start));
            }
        }
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
        if (this.isBroadCastMode) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.surfaceViewContainer);
            frameLayout.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.surfaceView.getLayoutParams();
            SurfaceView surfaceView = new SurfaceView(getContext());
            this.surfaceView = surfaceView;
            frameLayout.addView(surfaceView, layoutParams);
            RtmpCamera1 rtmpCamera1 = new RtmpCamera1(this.surfaceView, this);
            this.rtmpCamera1 = rtmpCamera1;
            rtmpCamera1.setReTries(10);
            this.surfaceView.getHolder().addCallback(this.callback);
        }
    }

    private void setComments() {
        EditText editText = this.editTextComment;
        editText.setFilters(InputFilterHelper.getFilter(128, 1, editText));
        this.sendProgressBarContainer.setVisibility(4);
        ((PresenterFragment) this).compositeDisposable.add((Disposable) RxView.clicks(this.imageViewSendComment).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Object>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.23
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Object obj) {
                LiveBroadCastActivity.this.addMyCommentComment(true);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                MyLog.handleException(th);
            }
        }));
        this.mainRecyclerView.setOnTouchListener(this.onRecyclerViewTouch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMyCommentComment(boolean z) {
        this.imageViewSendComment.setVisibility(8);
        this.sendProgressBarContainer.setVisibility(0);
        String string = this.editTextComment.getText().toString();
        if (!string.isEmpty()) {
            LiveModels.LiveCommentObject liveCommentObject = new LiveModels.LiveCommentObject();
            liveCommentObject.text = string;
            liveCommentObject.profile_username = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().username;
            liveCommentObject.full_profile_thumbnail_url = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().full_thumbnail_url;
            this.mainArrayList.add(0, liveCommentObject);
            this.mainAdapter.notifyItemInserted(0);
            try {
                this.mainRecyclerView.scrollToPosition(0);
                if (z) {
                    AndroidUtilities.hideKeyboard(this.editTextComment);
                }
            } catch (Exception e) {
                MyLog.handleException(e);
            }
            callAddComment(string);
        }
        this.editTextComment.setText(BuildConfig.FLAVOR);
        this.sendProgressBarContainer.setVisibility(4);
        this.imageViewSendComment.setVisibility(0);
    }

    private void callAddComment(String str) {
        Observable<MessangerOutput<LiveModels.AddLiveCommentOutput>> observableRubinoAddLiveComment = null;
        LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
        if (liveStatus == null) {
            return;
        }
        int i = 10000;
        int i2 = liveStatus.play_count;
        if (i2 < 10) {
            i = 0;
        } else if (i2 < 100) {
            i = 3000;
        }
        if (System.currentTimeMillis() - this.lastTimeCommentApiCalled < i) {
            return;
        }
        this.lastTimeCommentApiCalled = System.currentTimeMillis();
        if (this.rubinoProfile != null) {
            LiveModels.RubinoAddLiveCommentInput rubinoAddLiveCommentInput = new LiveModels.RubinoAddLiveCommentInput();
            rubinoAddLiveCommentInput.live_id = this.rubinoLiveId;
            rubinoAddLiveCommentInput.text = str;
            rubinoAddLiveCommentInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            rubinoAddLiveCommentInput.live_profile_id = this.rubinoProfile.id;
            observableRubinoAddLiveComment = getApiRequestMessangerRx().rubinoAddLiveComment(rubinoAddLiveCommentInput);
        }
        if (observableRubinoAddLiveComment != null) {
            ((PresenterFragment) this).compositeDisposable.add((Disposable) observableRubinoAddLiveComment.subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.AddLiveCommentOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.24
                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<LiveModels.AddLiveCommentOutput> messangerOutput) {
                    LiveModels.AddLiveCommentOutput addLiveCommentOutput;
                    if (messangerOutput == null || (addLiveCommentOutput = messangerOutput.data) == null || addLiveCommentOutput.live_comment == null) {
                        return;
                    }
                    if (LiveBroadCastActivity.this.myComments == null) {
                        LiveBroadCastActivity.this.myComments = new HashMap();
                    }
                    HashMap map = LiveBroadCastActivity.this.myComments;
                    LiveModels.AddLiveCommentOutput addLiveCommentOutput2 = messangerOutput.data;
                    map.put(addLiveCommentOutput2.live_comment.comment_id, addLiveCommentOutput2.live_comment);
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimerToScroll() {
        DisposableObserver disposableObserver = this.scrollTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver disposableObserver2 = (DisposableObserver) Observable.timer(20L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.25
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                try {
                    LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, LiveBroadCastActivity.this.mContext) { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.25.1
                        @Override // androidx.recyclerview.widget.LinearSmoothScroller
                        protected int getVerticalSnapPreference() {
                            return -1;
                        }
                    };
                    linearSmoothScroller.setTargetPosition(0);
                    LiveBroadCastActivity.this.mainRecyclerView.getLayoutManager().startSmoothScroll(linearSmoothScroller);
                } catch (Exception unused) {
                }
            }
        });
        this.scrollTimer = disposableObserver2;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetLiveStatus() {
        if (this.rubinoProfile == null || this.rubinoLiveId == null) {
            return;
        }
        DisposableObserver disposableObserver = this.getLiveStatusObservable;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            LiveModels.RubinoGetLiveStatusInput rubinoGetLiveStatusInput = new LiveModels.RubinoGetLiveStatusInput();
            rubinoGetLiveStatusInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
            rubinoGetLiveStatusInput.live_profile_id = this.rubinoProfile.id;
            rubinoGetLiveStatusInput.live_id = this.rubinoLiveId;
            DisposableObserver disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().rubinoGetLiveStatus(rubinoGetLiveStatusInput).doOnNext(new Consumer<MessangerOutput<LiveModels.RubinoGetLiveStatusOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.28
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<LiveModels.RubinoGetLiveStatusOutput> messangerOutput) throws Exception {
                    LiveBroadCastActivity.this.rubinoLiveStatus = messangerOutput.data.live_status;
                    LiveBroadCastActivity.this.rubinoLiveStatus.isBlocked = messangerOutput.data.is_blocked;
                    LiveBroadCastActivity.this.onLiveStatusChanged();
                }
            }).delay(this.isBroadCastMode ? 15L : 30L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.RubinoGetLiveStatusOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.27
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<LiveModels.RubinoGetLiveStatusOutput> messangerOutput) {
                    LiveBroadCastActivity.this.getLiveStatusObservable = null;
                    LiveBroadCastActivity.this.callGetLiveStatus();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (th instanceof ApiServerException) {
                        ApiServerException apiServerException = (ApiServerException) th;
                        if (apiServerException.status == MessangerOutput.EnumStatus.ERROR_BAD_ENC || apiServerException.status_det == MessangerOutput.EnumStatusDet.INVALID_AUTH) {
                            LiveBroadCastActivity.this.getLiveStatusObservable = null;
                            LiveBroadCastActivity liveBroadCastActivity = LiveBroadCastActivity.this;
                            if (liveBroadCastActivity.isBroadCastMode) {
                                return;
                            }
                            liveBroadCastActivity.onBroadCastingFinished(FinishedReason.liveBanedForViewer);
                            return;
                        }
                    }
                    ((PresenterFragment) LiveBroadCastActivity.this).compositeDisposable.add((Disposable) Observable.just(1).delay(LiveBroadCastActivity.this.isBroadCastMode ? 15L : 30L, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.27.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th2) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Integer num) {
                            LiveBroadCastActivity.this.getLiveStatusObservable = null;
                            LiveBroadCastActivity.this.callGetLiveStatus();
                        }
                    }));
                }
            });
            this.getLiveStatusObservable = disposableObserver2;
            ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetComments() {
        if (this.showClean) {
            return;
        }
        DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver = this.getCommentRequestTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        if (this.rubinoProfile == null || this.rubinoLiveId != null) {
            if (this.isBroadCastMode) {
                checkRtmpAck();
            }
            Observable<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> observableRubinoGetLiveComment = null;
            if (this.rubinoProfile != null) {
                LiveModels.RubinoGetLiveCommnetsInput rubinoGetLiveCommnetsInput = new LiveModels.RubinoGetLiveCommnetsInput();
                rubinoGetLiveCommnetsInput.profile_id = AppRubinoPreferences.getInstance(this.currentAccount).getRubinoCurrentProfileObject().id;
                rubinoGetLiveCommnetsInput.live_profile_id = this.rubinoProfile.id;
                rubinoGetLiveCommnetsInput.live_id = this.rubinoLiveId;
                rubinoGetLiveCommnetsInput.start_id = this.nextStartIdComment;
                observableRubinoGetLiveComment = getApiRequestMessangerRx().rubinoGetLiveComment(5, rubinoGetLiveCommnetsInput);
            }
            if (observableRubinoGetLiveComment == null) {
                return;
            }
            DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>> disposableObserver2 = (DisposableObserver) observableRubinoGetLiveComment.observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<MessangerOutput<LiveModels.GetLiveCommnetsOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.30
                @Override // io.reactivex.functions.Consumer
                public void accept(MessangerOutput<LiveModels.GetLiveCommnetsOutput> messangerOutput) throws Exception {
                    LiveModels.GetLiveCommnetsOutput getLiveCommnetsOutput;
                    if (messangerOutput == null || (getLiveCommnetsOutput = messangerOutput.data) == null || getLiveCommnetsOutput.live_comments == null) {
                        return;
                    }
                    ArrayList<LiveModels.LiveCommentObject> arrayList = getLiveCommnetsOutput.live_comments;
                    if (getLiveCommnetsOutput.next_start_id != null) {
                        LiveBroadCastActivity.this.nextStartIdComment = getLiveCommnetsOutput.next_start_id;
                    }
                    if (arrayList.size() > 0) {
                        LiveBroadCastActivity.this.startAddCommentTimer(arrayList);
                    }
                }
            }).delay(5L, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<MessangerOutput<LiveModels.GetLiveCommnetsOutput>>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.29
                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<LiveModels.GetLiveCommnetsOutput> messangerOutput) {
                    LiveBroadCastActivity.this.callGetComments();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    ((PresenterFragment) LiveBroadCastActivity.this).compositeDisposable.add((Disposable) Observable.just(1).delay(5L, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.29.1
                        @Override // io.reactivex.Observer
                        public void onComplete() {
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th2) {
                        }

                        @Override // io.reactivex.Observer
                        public void onNext(Integer num) {
                            LiveBroadCastActivity.this.callGetComments();
                        }
                    }));
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
            this.getCommentRequestTimer = disposableObserver2;
            ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
        }
    }

    private void checkRtmpAck() {
        if (this.isBroadCastMode) {
            if (System.currentTimeMillis() - RtmpConnection.lastAcknowledgementTime > 40000 || System.currentTimeMillis() - RtmpConnection.lastAcknowledgementTimeSendPacket > 20000) {
                if (this.rtmpCamera1.isStreaming()) {
                    this.rtmpCamera1.stopStream();
                }
                this.streamingUrl = null;
                stopLive();
                onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddCommentTimer(final ArrayList<LiveModels.LiveCommentObject> arrayList) {
        DisposableObserver<Long> disposableObserver = this.addCommentTimer;
        if (disposableObserver != null) {
            disposableObserver.dispose();
        }
        DisposableObserver<Long> disposableObserver2 = (DisposableObserver) Observable.interval(20L, 700L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Long>() { // from class: ir.resaneh1.iptv.fragment.messanger.LiveBroadCastActivity.31
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Long l) {
                int iLongValue = (int) l.longValue();
                if (iLongValue < arrayList.size()) {
                    LiveModels.LiveCommentObject liveCommentObject = (LiveModels.LiveCommentObject) arrayList.get(iLongValue);
                    if (LiveBroadCastActivity.this.myComments != null) {
                        if (LiveBroadCastActivity.this.myComments.get(liveCommentObject.comment_id) == null) {
                            LiveBroadCastActivity.this.addComment(liveCommentObject);
                            return;
                        }
                        return;
                    }
                    LiveBroadCastActivity.this.addComment(liveCommentObject);
                    return;
                }
                dispose();
            }
        });
        this.addCommentTimer = disposableObserver2;
        ((PresenterFragment) this).compositeDisposable.add(disposableObserver2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addComment(LiveModels.LiveCommentObject liveCommentObject) {
        LiveModels.LiveCommentObject liveCommentObject2;
        LiveCommentPresenter.MyViewHolder myViewHolder;
        boolean z = true;
        if (this.mainArrayList.size() > 1000) {
            ArrayList<PresenterItem> arrayList = this.mainArrayList;
            arrayList.remove(arrayList.size() - 1);
            this.mainAdapter.notifyItemRemoved(this.mainArrayList.size());
        }
        try {
            liveCommentObject2 = (LiveModels.LiveCommentObject) this.mainArrayList.get(0);
        } catch (Exception unused) {
            liveCommentObject2 = null;
        }
        if (liveCommentObject2 != null) {
            for (int i = 0; i < this.mainRecyclerView.getChildCount(); i++) {
                try {
                    myViewHolder = (LiveCommentPresenter.MyViewHolder) this.mainRecyclerView.getChildAt(i).getTag();
                } catch (Exception unused2) {
                    myViewHolder = null;
                }
                if (myViewHolder != null && myViewHolder.item == liveCommentObject2) {
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (liveCommentObject != null) {
            this.mainArrayList.add(0, liveCommentObject);
            this.mainAdapter.notifyItemInserted(0);
        } else if (MyLog.isDebugAble) {
            MyLog.handleException(new Exception("ExceptionComment"));
        }
        if (z) {
            try {
                this.mainRecyclerView.scrollToPosition(0);
            } catch (Exception unused3) {
            }
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (this.isVODMode) {
            return;
        }
        try {
            if (i == NotificationCenter.emojiDidLoad) {
                MainAdapter mainAdapter = this.hintAdapter;
                if (mainAdapter != null) {
                    mainAdapter.notifyDataSetChanged();
                }
                MainAdapter mainAdapter2 = this.mainAdapter;
                if (mainAdapter2 != null) {
                    mainAdapter2.notifyDataSetChanged();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLiveStatusChanged() {
        LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
        if (liveStatus != null) {
            boolean z = this.isBroadCastMode;
            if (!z && liveStatus.isBlocked) {
                onBroadCastingFinished(FinishedReason.liveBanedForViewer);
                return;
            }
            LiveModels.LiveStatus.LiveStatusEnum liveStatusEnum = liveStatus.status;
            if (liveStatusEnum == LiveModels.LiveStatus.LiveStatusEnum.Finish) {
                if (z) {
                    if (this.rtmpCamera1.isStreaming()) {
                        this.rtmpCamera1.stopStream();
                    }
                    this.streamingUrl = null;
                    onBroadCastingFinished(FinishedReason.rtmpDisconnectedForBroadCaster);
                } else {
                    SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
                    if (simpleExoPlayer == null || simpleExoPlayer.getPlaybackState() != 3) {
                        onBroadCastingFinished(FinishedReason.liveFinishedForViewer);
                    }
                }
            } else if (liveStatusEnum == LiveModels.LiveStatus.LiveStatusEnum.InProgress) {
                setMemberCount();
            }
        }
        refreshViewWithLiveSetting(false);
    }

    private void setMemberCount() {
        LiveModels.LiveStatus liveStatus = this.rubinoProfile != null ? this.rubinoLiveStatus : null;
        if (liveStatus != null) {
            this.textViewMemberCount.setText(NumberUtils.toCuteStringWithKOrMEnglish(liveStatus.play_count));
        }
    }
}
