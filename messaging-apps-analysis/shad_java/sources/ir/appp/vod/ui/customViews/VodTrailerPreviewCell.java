package ir.appp.vod.ui.customViews;

import android.content.Context;
import android.media.AudioManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerView;
import ir.appp.vod.domain.model.VodPlayUrl;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.GlideHelper;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.webrtc.MediaStreamTrack;

/* compiled from: VodTrailerPreviewCell.kt */
/* loaded from: classes3.dex */
public final class VodTrailerPreviewCell extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static boolean isMute = true;
    private final long MAX_UPDATE_INTERVAL_MS;
    private final long animDuration;
    private AudioAttributes audioAttributes;
    private final int autoWatchDuration;
    private Button cancelBtn;
    private final View contentView;
    private String coverUrl;
    private boolean firstStart;
    private boolean isPaused;
    private Function0<Unit> onWatchVideoClick;
    private SimpleExoPlayer player;
    private VodTrailerPlayerLoading playerLoading;
    private DefaultTimeBar playerProgressBar;
    private PlayerView playerView;
    private ProgressBar progressBar;
    private ImageView trailerCoverImageView;
    private final Runnable updateProgressAction;
    private ImageView videoMute;
    private TextView videoTag;
    private ImageView videoUnMute;
    private FrameLayout videoVolume;
    private VodProgressiveMaterialButton watchVideoBtn;

    /* compiled from: VodTrailerPreviewCell.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Function0<Unit> getOnWatchVideoClick() {
        return this.onWatchVideoClick;
    }

    public final void setOnWatchVideoClick(Function0<Unit> function0) {
        this.onWatchVideoClick = function0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VodTrailerPreviewCell(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        new LinkedHashMap();
        this.firstStart = true;
        this.MAX_UPDATE_INTERVAL_MS = 1000L;
        this.animDuration = 200L;
        this.autoWatchDuration = 10000;
        View viewInflate = FrameLayout.inflate(getContext(), R.layout.vod_trailer_player, null);
        this.contentView = viewInflate;
        setId(R.id.vodTrailerPreviewCellId);
        this.playerView = viewInflate == null ? null : (PlayerView) viewInflate.findViewById(R.id.trailer_player_view);
        this.videoTag = viewInflate == null ? null : (TextView) viewInflate.findViewById(R.id.video_tag);
        this.videoVolume = viewInflate == null ? null : (FrameLayout) viewInflate.findViewById(R.id.video_volume);
        this.videoMute = viewInflate == null ? null : (ImageView) viewInflate.findViewById(R.id.video_mute);
        this.videoUnMute = viewInflate == null ? null : (ImageView) viewInflate.findViewById(R.id.video_un_mute);
        this.trailerCoverImageView = viewInflate == null ? null : (ImageView) viewInflate.findViewById(R.id.trailer_cover);
        this.progressBar = viewInflate == null ? null : (ProgressBar) viewInflate.findViewById(R.id.trailer_progressbar);
        this.playerProgressBar = viewInflate == null ? null : (DefaultTimeBar) viewInflate.findViewById(R.id.exo_progress);
        this.playerLoading = viewInflate == null ? null : (VodTrailerPlayerLoading) viewInflate.findViewById(R.id.trailer_loading);
        this.cancelBtn = viewInflate == null ? null : (Button) viewInflate.findViewById(R.id.trailer_cancel_button);
        this.watchVideoBtn = viewInflate != null ? (VodProgressiveMaterialButton) viewInflate.findViewById(R.id.trailer_watch_video) : null;
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setShowBuffering(0);
        }
        Button button = this.cancelBtn;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodTrailerPreviewCell.m371_init_$lambda0(this.f$0, view);
                }
            });
        }
        final VodProgressiveMaterialButton vodProgressiveMaterialButton = this.watchVideoBtn;
        if (vodProgressiveMaterialButton != null) {
            vodProgressiveMaterialButton.setOnTimeEnded(new Function0<Unit>() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.hideWatchVideoView();
                    if (this.this$0.isPaused) {
                        return;
                    }
                    SimpleExoPlayer simpleExoPlayer = this.this$0.player;
                    if (!(simpleExoPlayer != null && simpleExoPlayer.getPlaybackState() == 1)) {
                        SimpleExoPlayer simpleExoPlayer2 = this.this$0.player;
                        if (!(simpleExoPlayer2 != null && simpleExoPlayer2.getPlaybackState() == 4)) {
                            return;
                        }
                    }
                    vodProgressiveMaterialButton.callOnClick();
                }
            });
            vodProgressiveMaterialButton.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodTrailerPreviewCell.m374lambda2$lambda1(this.f$0, vodProgressiveMaterialButton, view);
                }
            });
        }
        VodTrailerPlayerLoading vodTrailerPlayerLoading = this.playerLoading;
        if (vodTrailerPlayerLoading != null) {
            vodTrailerPlayerLoading.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodTrailerPreviewCell.m372_init_$lambda3(this.f$0, view);
                }
            });
        }
        FrameLayout frameLayout = this.videoVolume;
        if (frameLayout != null) {
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VodTrailerPreviewCell.m373_init_$lambda4(this.f$0, view);
                }
            });
        }
        addView(viewInflate, -1, -1);
        this.updateProgressAction = new Runnable() { // from class: ir.appp.vod.ui.customViews.VodTrailerPreviewCell$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                VodTrailerPreviewCell.m375updateProgressAction$lambda10(this.f$0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final void m371_init_$lambda0(VodTrailerPreviewCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Button button = this$0.cancelBtn;
        if (button != null) {
            button.setVisibility(8);
        }
        VodProgressiveMaterialButton vodProgressiveMaterialButton = this$0.watchVideoBtn;
        if (vodProgressiveMaterialButton != null) {
            vodProgressiveMaterialButton.setVisibility(8);
        }
        VodProgressiveMaterialButton vodProgressiveMaterialButton2 = this$0.watchVideoBtn;
        if (vodProgressiveMaterialButton2 == null) {
            return;
        }
        vodProgressiveMaterialButton2.stopWatchVideoTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-1, reason: not valid java name */
    public static final void m374lambda2$lambda1(VodTrailerPreviewCell this$0, VodProgressiveMaterialButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.hideWatchVideoView();
        Function0<Unit> function0 = this$0.onWatchVideoClick;
        if (function0 != null) {
            function0.invoke();
        }
        this_apply.stopWatchVideoTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-3, reason: not valid java name */
    public static final void m372_init_$lambda3(VodTrailerPreviewCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.firstStart) {
            return;
        }
        SimpleExoPlayer simpleExoPlayer = this$0.player;
        boolean z = false;
        if (!(simpleExoPlayer != null && simpleExoPlayer.getPlaybackState() == 1)) {
            SimpleExoPlayer simpleExoPlayer2 = this$0.player;
            if (simpleExoPlayer2 != null && simpleExoPlayer2.getPlaybackState() == 4) {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        this$0.firstStart = true;
        SimpleExoPlayer simpleExoPlayer3 = this$0.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.prepare();
        }
        SimpleExoPlayer simpleExoPlayer4 = this$0.player;
        if (simpleExoPlayer4 != null) {
            simpleExoPlayer4.seekTo(0L);
        }
        SimpleExoPlayer simpleExoPlayer5 = this$0.player;
        if (simpleExoPlayer5 == null) {
            return;
        }
        simpleExoPlayer5.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-4, reason: not valid java name */
    public static final void m373_init_$lambda4(VodTrailerPreviewCell this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isMute) {
            Object systemService = this$0.getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            }
            AudioManager audioManager = (AudioManager) systemService;
            if (audioManager.getStreamVolume(3) == 0) {
                audioManager.adjustStreamVolume(3, 0, 1);
            }
        }
        isMute = !isMute;
        this$0.showMuteState();
    }

    private final void showMuteState() {
        Player.AudioComponent audioComponent;
        boolean z = !isMute;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            AudioAttributes audioAttributes = this.audioAttributes;
            if (audioAttributes == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audioAttributes");
                audioAttributes = null;
            }
            simpleExoPlayer.setAudioAttributes(audioAttributes, z);
        }
        ImageView imageView = this.videoUnMute;
        if (imageView != null) {
            imageView.setVisibility(!isMute ? 0 : 8);
        }
        ImageView imageView2 = this.videoMute;
        if (imageView2 != null) {
            imageView2.setVisibility(isMute ? 0 : 8);
        }
        if (isMute) {
            SimpleExoPlayer simpleExoPlayer2 = this.player;
            audioComponent = simpleExoPlayer2 != null ? simpleExoPlayer2.getAudioComponent() : null;
            if (audioComponent == null) {
                return;
            }
            audioComponent.setVolume(0.0f);
            return;
        }
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        audioComponent = simpleExoPlayer3 != null ? simpleExoPlayer3.getAudioComponent() : null;
        if (audioComponent == null) {
            return;
        }
        audioComponent.setVolume(1.0f);
    }

    public final void setData(VodPlayUrl vodPlayUrl, String str) {
        this.coverUrl = str;
        if (str != null) {
            GlideHelper.load(getContext(), this.trailerCoverImageView, str, R.color.vod_trailer_cover_holder_color);
        }
        TextView textView = this.videoTag;
        if (textView == null) {
            return;
        }
        textView.setText(getContext().getString(R.string.vod_no_preview));
    }

    private final void updateProgressBar() {
        long currentPosition;
        int playbackState;
        long preferredUpdateDelay;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            currentPosition = 0;
        } else {
            Intrinsics.checkNotNull(simpleExoPlayer);
            currentPosition = simpleExoPlayer.getCurrentPosition();
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress((int) currentPosition);
        }
        removeCallbacks(this.updateProgressAction);
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 == null) {
            playbackState = 1;
        } else {
            Intrinsics.checkNotNull(simpleExoPlayer2);
            playbackState = simpleExoPlayer2.getPlaybackState();
        }
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        Intrinsics.checkNotNull(simpleExoPlayer3);
        if (simpleExoPlayer3.getPlayWhenReady() && playbackState == 3) {
            DefaultTimeBar defaultTimeBar = this.playerProgressBar;
            if (defaultTimeBar != null) {
                Intrinsics.checkNotNull(defaultTimeBar);
                preferredUpdateDelay = defaultTimeBar.getPreferredUpdateDelay();
            } else {
                preferredUpdateDelay = this.MAX_UPDATE_INTERVAL_MS;
            }
            long j = CloseCodes.NORMAL_CLOSURE;
            long jMin = Math.min(preferredUpdateDelay, j - (currentPosition % j));
            SimpleExoPlayer simpleExoPlayer4 = this.player;
            Intrinsics.checkNotNull(simpleExoPlayer4);
            float f = simpleExoPlayer4.getPlaybackParameters().speed;
            postDelayed(this.updateProgressAction, f > 0.0f ? (long) (jMin / f) : this.MAX_UPDATE_INTERVAL_MS);
        }
    }

    public final void onPause() {
        this.isPaused = true;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.stop();
        }
        removeCallbacks(this.updateProgressAction);
    }

    public final void onResume() {
        this.isPaused = false;
        VodTrailerPlayerLoading vodTrailerPlayerLoading = this.playerLoading;
        if (vodTrailerPlayerLoading == null) {
            return;
        }
        vodTrailerPlayerLoading.setIndeterminateState(this.firstStart);
    }

    public final void onDestroy() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
        }
        VodProgressiveMaterialButton vodProgressiveMaterialButton = this.watchVideoBtn;
        if (vodProgressiveMaterialButton != null) {
            vodProgressiveMaterialButton.stopWatchVideoTimer();
        }
        removeCallbacks(this.updateProgressAction);
    }

    public final void hideWatchVideoView() {
        Button button = this.cancelBtn;
        if (button == null) {
            return;
        }
        button.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateProgressAction$lambda-10, reason: not valid java name */
    public static final void m375updateProgressAction$lambda10(VodTrailerPreviewCell this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateProgressBar();
    }
}
