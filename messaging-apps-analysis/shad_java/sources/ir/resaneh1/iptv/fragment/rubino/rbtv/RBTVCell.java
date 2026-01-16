package ir.resaneh1.iptv.fragment.rubino.rbtv;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import ir.appp.rghapp.rubinoPostSlider.RGHAnimatedView;
import ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RubinoCommentListActivity;
import ir.resaneh1.iptv.fragment.rubino.RubinoController;
import ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVUtils;
import ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell;
import ir.resaneh1.iptv.helper.GlideHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.Components.LayoutHelper;

/* compiled from: RBTVCell.kt */
/* loaded from: classes3.dex */
public final class RBTVCell extends FrameLayout {
    private final RBTVCallBack callback;
    private final Lazy commentCountTv$delegate;
    private final Lazy commentIv$delegate;
    private SimpleExoPlayer exoPlayer;
    private boolean isMute;
    private final Lazy likeCountTv$delegate;
    private final Lazy likeIv$delegate;
    private final Handler myHandler;
    private final Lazy optionIv$delegate;
    private PlayerView playerView;
    private RubinoPostObject postObject;
    private final Lazy progressBar$delegate;
    private final Lazy rbtvInfoCell$delegate;
    public Runnable refresh;
    public Runnable runnable;
    private final Lazy seekBar$delegate;
    private boolean seekBarStarted;
    private int seekToProgressPending;
    private final Lazy sendIv$delegate;
    private ImageView soundIv;
    private final Lazy textProgress$delegate;
    private int videoHeight;
    private int videoWidth;

    /* compiled from: RBTVCell.kt */
    public interface RBTVCallBack {
        void onVideoEnded();
    }

    static {
        new Companion(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RBTVCell(final Context context, RBTVCallBack callback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new LinkedHashMap();
        this.callback = callback;
        this.seekBar$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SeekBar>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$seekBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SeekBar invoke() {
                return new SeekBar(context);
            }
        });
        this.textProgress$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$textProgress$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return new TextView(context);
            }
        });
        this.progressBar$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ProgressBar>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$progressBar$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProgressBar invoke() {
                return new ProgressBar(context);
            }
        });
        this.likeIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RGHAnimatedView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$likeIv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RGHAnimatedView invoke() {
                return new RGHAnimatedView(context, R.drawable.rubino_like_heart_filled_24, R.drawable.rubino_like_heart_outline, R.color.like, RBTVUtils.Companion.getTextColor());
            }
        });
        this.commentIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$commentIv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return RBTVUtils.Companion.createIv(context, R.drawable.rubino_comment_outline);
            }
        });
        this.sendIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$sendIv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return RBTVUtils.Companion.createIv(context, R.drawable.rubino_send_message_direct_outline_24);
            }
        });
        this.optionIv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$optionIv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return RBTVUtils.Companion.createIv(context, R.drawable.rubino_option_grey);
            }
        });
        this.likeCountTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$likeCountTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return RBTVUtils.Companion.createTv(context);
            }
        });
        this.commentCountTv$delegate = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$commentCountTv$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return RBTVUtils.Companion.createTv(context);
            }
        });
        this.soundIv = new ImageView(context);
        this.rbtvInfoCell$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RBTVInfoCell>() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$rbtvInfoCell$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RBTVInfoCell invoke() {
                return new RBTVInfoCell(context);
            }
        });
        this.myHandler = new Handler(Looper.getMainLooper());
        this.playerView = new PlayerView(context);
        RBTVUtils.Companion companion = RBTVUtils.Companion;
        setBackgroundColor(companion.getBackgroundColor());
        initEventListeners();
        addView(this.playerView, LayoutHelper.createFrame(-1.0f, 300.0f, 17));
        addView(getProgressBar(), LayoutHelper.createFrame(-2, -2, 17));
        addView(initBottomLayout(), LayoutHelper.createFrame(-1, -2.0f, 80, 16.0f, 0.0f, 16.0f, 16.0f));
        addView(getRbtvInfoCell(), LayoutHelper.createFrame(-1, -2.0f, 80, 16.0f, 0.0f, 72.0f, 64.0f));
        ImageView imageView = this.soundIv;
        imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_circle_black_transparent));
        imageView.setVisibility(4);
        imageView.setPadding(48, 48, 48, 48);
        imageView.setColorFilter(companion.getTextColor());
        addView(this.soundIv, LayoutHelper.createFrame(60, 60, 17));
        getSeekBar().setMax(CloseCodes.NORMAL_CLOSURE);
    }

    /* compiled from: RBTVCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SeekBar getSeekBar() {
        return (SeekBar) this.seekBar$delegate.getValue();
    }

    public final TextView getTextProgress() {
        return (TextView) this.textProgress$delegate.getValue();
    }

    public final ProgressBar getProgressBar() {
        return (ProgressBar) this.progressBar$delegate.getValue();
    }

    private final RGHAnimatedView getLikeIv() {
        return (RGHAnimatedView) this.likeIv$delegate.getValue();
    }

    private final ImageView getCommentIv() {
        return (ImageView) this.commentIv$delegate.getValue();
    }

    private final ImageView getSendIv() {
        return (ImageView) this.sendIv$delegate.getValue();
    }

    private final ImageView getOptionIv() {
        return (ImageView) this.optionIv$delegate.getValue();
    }

    private final TextView getLikeCountTv() {
        return (TextView) this.likeCountTv$delegate.getValue();
    }

    private final TextView getCommentCountTv() {
        return (TextView) this.commentCountTv$delegate.getValue();
    }

    public final ImageView getSoundIv() {
        return this.soundIv;
    }

    public final void setSoundIv(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.soundIv = imageView;
    }

    private final RBTVInfoCell getRbtvInfoCell() {
        return (RBTVInfoCell) this.rbtvInfoCell$delegate.getValue();
    }

    public final RubinoPostObject getPostObject() {
        return this.postObject;
    }

    public final void setPostObject(RubinoPostObject rubinoPostObject) {
        this.postObject = rubinoPostObject;
    }

    public final SimpleExoPlayer getExoPlayer() {
        return this.exoPlayer;
    }

    public final void setExoPlayer(SimpleExoPlayer simpleExoPlayer) {
        this.exoPlayer = simpleExoPlayer;
    }

    public final void setMute(boolean z) {
        this.isMute = z;
    }

    public final int getVideoWidth() {
        return this.videoWidth;
    }

    public final void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public final int getVideoHeight() {
        return this.videoHeight;
    }

    public final void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public final Runnable getRunnable() {
        Runnable runnable = this.runnable;
        if (runnable != null) {
            return runnable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("runnable");
        return null;
    }

    public final void setRunnable(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.runnable = runnable;
    }

    public final Handler getMyHandler() {
        return this.myHandler;
    }

    public final Runnable getRefresh() {
        Runnable runnable = this.refresh;
        if (runnable != null) {
            return runnable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refresh");
        return null;
    }

    public final void setRefresh(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.refresh = runnable;
    }

    private final void initExoPlayer() {
        View videoSurfaceView;
        initCallBack();
        if (this.exoPlayer == null) {
            this.exoPlayer = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory()));
        }
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setPlayer(getExoPlayer());
            playerView.setUseController(false);
            playerView.setResizeMode(1);
            playerView.setBackgroundColor(0);
        }
        getSeekBar().setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell.initExoPlayer.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                SimpleExoPlayer exoPlayer;
                if (!z || (exoPlayer = RBTVCell.this.getExoPlayer()) == null) {
                    return;
                }
                RBTVCell rBTVCell = RBTVCell.this;
                if (exoPlayer.getDuration() == -9223372036854775807L) {
                    rBTVCell.seekToProgressPending = i;
                } else {
                    exoPlayer.seekTo((int) ((i * r0) / CloseCodes.NORMAL_CLOSURE));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                RBTVCell.this.seekBarStarted = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                RBTVCell.this.seekBarStarted = false;
            }
        });
        PlayerView playerView2 = this.playerView;
        if (playerView2 != null && (videoSurfaceView = playerView2.getVideoSurfaceView()) != null) {
            videoSurfaceView.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RBTVCell.m506initExoPlayer$lambda2(this.f$0, view);
                }
            });
        }
        SimpleExoPlayer simpleExoPlayer2 = this.exoPlayer;
        if (simpleExoPlayer2 == null) {
            return;
        }
        simpleExoPlayer2.addListener(new Player.EventListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell.initExoPlayer.4
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
            public /* synthetic */ void onLoadingChanged(boolean z) {
                Player.EventListener.CC.$default$onLoadingChanged(this, z);
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
            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
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
            public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
                Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onPositionDiscontinuity(int i) {
                Player.EventListener.CC.$default$onPositionDiscontinuity(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onRepeatModeChanged(int i) {
                Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onSeekProcessed() {
                Player.EventListener.CC.$default$onSeekProcessed(this);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            /* JADX WARN: Not passed register '(r1v0 'timeline' com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i) {
                Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
                Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
            }

            @Override // com.google.android.exoplayer2.Player.EventListener
            public void onPlayerStateChanged(boolean z, int i) {
                if (i == 3) {
                    RBTVCell.this.getProgressBar().setVisibility(8);
                }
                if ((i == 3 || i == 1) && RBTVCell.this.seekToProgressPending != 0) {
                    SimpleExoPlayer exoPlayer = RBTVCell.this.getExoPlayer();
                    Intrinsics.checkNotNull(exoPlayer);
                    int duration = (int) ((exoPlayer.getDuration() * RBTVCell.this.seekToProgressPending) / CloseCodes.NORMAL_CLOSURE);
                    SimpleExoPlayer exoPlayer2 = RBTVCell.this.getExoPlayer();
                    Intrinsics.checkNotNull(exoPlayer2);
                    exoPlayer2.seekTo(duration);
                    RBTVCell.this.seekToProgressPending = 0;
                }
                if (z && i == 4) {
                    RBTVCell.this.callback.onVideoEnded();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initExoPlayer$lambda-2, reason: not valid java name */
    public static final void m506initExoPlayer$lambda2(RBTVCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVolume(!this$0.isMute);
    }

    public final void setVolume(boolean z) {
        if (z == this.isMute) {
            return;
        }
        this.isMute = z;
        if (z) {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(0.0f);
            }
            ImageView imageView = this.soundIv;
            imageView.startAnimation(fadeAnimation(imageView, R.drawable.rubino_igtv_mute));
            return;
        }
        ImageView imageView2 = this.soundIv;
        imageView2.startAnimation(fadeAnimation(imageView2, R.drawable.rubino_igtv_unmute));
        SimpleExoPlayer simpleExoPlayer2 = this.exoPlayer;
        if (simpleExoPlayer2 == null) {
            return;
        }
        simpleExoPlayer2.setVolume(1.0f);
    }

    private final void initEventListeners() {
        RGHAnimatedView likeIv = getLikeIv();
        likeIv.setFilledAndrOutlineColor(-2337189, RBTVUtils.Companion.getTextColor());
        likeIv.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVCell.m502initEventListeners$lambda4$lambda3(this.f$0, view);
            }
        });
        getOptionIv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVCell.m503initEventListeners$lambda6$lambda5(this.f$0, view);
            }
        });
        getSendIv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVCell.m504initEventListeners$lambda8$lambda7(this.f$0, view);
            }
        });
        getCommentIv().setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RBTVCell.m505initEventListeners$lambda9(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initEventListeners$lambda-4$lambda-3, reason: not valid java name */
    public static final void m502initEventListeners$lambda4$lambda3(RBTVCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateLike();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initEventListeners$lambda-6$lambda-5, reason: not valid java name */
    public static final void m503initEventListeners$lambda6$lambda5(RBTVCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showOptionBottomSheet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initEventListeners$lambda-8$lambda-7, reason: not valid java name */
    public static final void m504initEventListeners$lambda8$lambda7(RBTVCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showShareBottomSheet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initEventListeners$lambda-9, reason: not valid java name */
    public static final void m505initEventListeners$lambda9(RBTVCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new RubinoCommentListActivity(RubinoCommentListActivity.commentWithCaptionType, this$0.postObject, true));
    }

    private final LinearLayout initBottomLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(initOptionsVerticalLayout(), LayoutHelper.createLinear(-2, -2, 5, 0, 0, 0, 16));
        linearLayout.addView(initBottomSeekbarLayout(), LayoutHelper.createLinear(-1, -2));
        return linearLayout;
    }

    private final LinearLayout initBottomSeekbarLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        Drawable progressDrawable = getSeekBar().getProgressDrawable();
        RBTVUtils.Companion companion = RBTVUtils.Companion;
        progressDrawable.setColorFilter(companion.getTextColor(), PorterDuff.Mode.SRC_IN);
        getSeekBar().getThumb().setColorFilter(companion.getTextColor(), PorterDuff.Mode.SRC_IN);
        linearLayout.addView(getSeekBar(), LayoutHelper.createLinear(-1, -2, 1.0f, 17));
        getTextProgress().setTextColor(companion.getTextColor());
        linearLayout.addView(getTextProgress(), LayoutHelper.createLinear(-2, -2, 17));
        return linearLayout;
    }

    private final LinearLayout initOptionsVerticalLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.addView(initImageTextLayout(getLikeIv(), getLikeCountTv()), LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 0.0f, 16.0f));
        linearLayout.addView(initImageTextLayout(getCommentIv(), getCommentCountTv()), LayoutHelper.createLinear(-2, -2, 0.0f, 0.0f, 0.0f, 16.0f));
        getSendIv().setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        linearLayout.addView(getSendIv(), LayoutHelper.createLinear(35, 35, 0.0f, 0.0f, 0.0f, 16.0f));
        getOptionIv().setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        linearLayout.addView(getOptionIv(), LayoutHelper.createLinear(35, 35, 0.0f, 0.0f, 0.0f, 16.0f));
        return linearLayout;
    }

    private final LinearLayout initImageTextLayout(View view, TextView textView) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        view.setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
        linearLayout.addView(view, LayoutHelper.createLinear(35, 35, 0.0f, 0.0f, 0.0f, 0.0f));
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2));
        return linearLayout;
    }

    public final void setData(RubinoPostObject postObject, long j, long j2) {
        Intrinsics.checkNotNullParameter(postObject, "postObject");
        this.postObject = postObject;
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setLayoutParams(LayoutHelper.createFrame(-1.0f, AndroidUtilities.px(AndroidUtilities.getScreenWidth()) * postObject.viewHWRatio, 17));
        }
        setLikeComment();
        getRbtvInfoCell().setData(postObject);
        getLikeIv().updateIcon(postObject.isLiked, false);
        Long lValueOf = Long.valueOf(j);
        if (!(lValueOf.longValue() > 0)) {
            lValueOf = null;
        }
        long jLongValue = lValueOf == null ? 0L : lValueOf.longValue();
        Rubino.PostObjectFromServer postObjectFromServer = postObject.post;
        playStream(postObjectFromServer != null ? postObjectFromServer.full_file_url : null, jLongValue);
        if (jLongValue <= 0 || j2 <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            getSeekBar().setProgress((int) ((CloseCodes.NORMAL_CLOSURE * jLongValue) / j2), true);
        } else {
            getSeekBar().setProgress((int) ((CloseCodes.NORMAL_CLOSURE * jLongValue) / j2));
        }
    }

    private final void setLikeComment() {
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject == null) {
            return;
        }
        getLikeCountTv().setText(NumberUtils.toPersian(rubinoPostObject.post.likes_count));
        if (rubinoPostObject.post.likes_count == 0) {
            getLikeCountTv().setVisibility(8);
        }
        getCommentCountTv().setText(NumberUtils.toPersian(rubinoPostObject.post.comment_count));
        if (rubinoPostObject.post.comment_count == 0) {
            getCommentCountTv().setVisibility(8);
        }
    }

    private final void updateLike() {
        RubinoPostObject rubinoPostObject = this.postObject;
        if (rubinoPostObject == null) {
            return;
        }
        RubinoController.getInstance(UserConfig.selectedAccount).onLikePostClick(rubinoPostObject, getLikeIv().isShowingFilledState ? Rubino.LikeActionTypeEnum.Unlike : Rubino.LikeActionTypeEnum.Like);
        getLikeIv().updateIcon(rubinoPostObject.isLiked, true);
        getLikeCountTv().setText(NumberUtils.toPersian(rubinoPostObject.post.likes_count));
    }

    private final void showOptionBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialog);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog.setContentView(new RBTVOptionBottomSheetCell(context, this.postObject, new RBTVOptionBottomSheetCell.DismissListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$showOptionBottomSheet$contentView$1
            @Override // ir.resaneh1.iptv.fragment.rubino.rbtv.option.RBTVOptionBottomSheetCell.DismissListener
            public void dismiss() {
                bottomSheetDialog.dismiss();
            }
        }));
        bottomSheetDialog.show();
    }

    private final void showShareBottomSheet() {
        RubinoController.getInstance(UserConfig.selectedAccount).shareOrCopyPost(false, true, ApplicationLoader.applicationActivity.getLastFragment().compositeDisposable, this.postObject);
    }

    private final Animation fadeAnimation(final ImageView imageView, int i) {
        GlideHelper.loadCircle(getContext(), imageView, i, i);
        imageView.setColorFilter(getContext().getResources().getColor(R.color.white));
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(getFadeInAnimation());
        animationSet.addAnimation(getFadeOutAnimation());
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell$fadeAnimation$1$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                imageView.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                imageView.setVisibility(4);
            }
        });
        return animationSet;
    }

    private final Animation getFadeOutAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setStartOffset(1500L);
        alphaAnimation.setDuration(500L);
        return alphaAnimation;
    }

    private final Animation getFadeInAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(500L);
        return alphaAnimation;
    }

    private final void updateSeekBar() {
        this.myHandler.postDelayed(getRefresh(), 1000L);
    }

    private final void initCallBack() {
        setRefresh(new Runnable() { // from class: ir.resaneh1.iptv.fragment.rubino.rbtv.RBTVCell.initCallBack.1
            @Override // java.lang.Runnable
            public void run() {
                SimpleExoPlayer exoPlayer = RBTVCell.this.getExoPlayer();
                if (exoPlayer == null) {
                    return;
                }
                RBTVCell rBTVCell = RBTVCell.this;
                if (!rBTVCell.seekBarStarted) {
                    rBTVCell.getSeekBar().setProgress((int) ((exoPlayer.getCurrentPosition() * CloseCodes.NORMAL_CLOSURE) / exoPlayer.getDuration()));
                }
                rBTVCell.getTextProgress().setText(RBTVUtils.Companion.timeInString((int) ((exoPlayer.getDuration() - exoPlayer.getCurrentPosition()) / CloseCodes.NORMAL_CLOSURE)));
                rBTVCell.getMyHandler().postDelayed(this, 1000L);
            }
        });
    }

    private final void playStream(String str, long j) {
        if (str != null) {
            if (!(str.length() == 0)) {
                ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(Uri.parse(str), new PlayerBaseFragment.CacheDataSourceFactory(ApplicationLoader.applicationActivity, 734003200L, 524288000L), new DefaultExtractorsFactory(), null, null);
                if (this.exoPlayer == null) {
                    initExoPlayer();
                }
                stopPlayer();
                SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
                if (simpleExoPlayer != null) {
                    simpleExoPlayer.setPlayWhenReady(true);
                    simpleExoPlayer.prepare(extractorMediaSource);
                    simpleExoPlayer.seekTo(j);
                }
                getProgressBar().setVisibility(0);
                updateSeekBar();
                return;
            }
        }
        stopPlayer();
    }

    private final void stopPlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(false);
        simpleExoPlayer.stop();
    }

    public final void stopAndReleasePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            stopPlayer();
            simpleExoPlayer.release();
        }
        this.exoPlayer = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLikeComment();
    }

    public final void resumePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(true);
    }

    public final void pausePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setPlayWhenReady(false);
    }
}
