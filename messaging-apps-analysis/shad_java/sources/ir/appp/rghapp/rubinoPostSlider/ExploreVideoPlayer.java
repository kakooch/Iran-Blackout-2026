package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import ir.appp.rghapp.components.ExtendedDefaultDataSourceFactory;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class ExploreVideoPlayer implements Player.EventListener, SimpleExoPlayer.VideoListener, NotificationCenter.NotificationCenterDelegate {
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    Handler audioUpdateHandler = new Handler(Looper.getMainLooper());
    private boolean autoplay;
    private VideoPlayerDelegate delegate;
    private boolean lastReportedPlayWhenReady;
    private int lastReportedPlaybackState;
    private boolean looping;
    private boolean loopingMediaSource;
    private Handler mainHandler;
    private DataSource.Factory mediaDataSourceFactory;
    private SimpleExoPlayer player;
    private Surface surface;
    private TextureView textureView;
    private MappingTrackSelector trackSelector;
    private boolean videoPlayerReady;
    private String videoType;
    private Uri videoUri;

    public interface VideoPlayerDelegate {
        void onError(ExploreVideoPlayer exploreVideoPlayer, Exception exc);

        void onRenderedFirstFrame();

        void onStateChanged(boolean z, int i, boolean z2);

        void onVideoSizeChanged(int i, int i2, int i3, float f);
    }

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
    public void onLoadingChanged(boolean z) {
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

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int i, int i2) {
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

    public ExploreVideoPlayer() {
        Context context = ApplicationLoader.applicationContext;
        DefaultBandwidthMeter defaultBandwidthMeter = BANDWIDTH_METER;
        this.mediaDataSourceFactory = new ExtendedDefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/47.0 (Chrome)", defaultBandwidthMeter));
        this.mainHandler = new Handler();
        this.trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory());
        this.lastReportedPlaybackState = 1;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.explorePlayerDidStartPlaying);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.explorePlayerDidStartPlaying && ((ExploreVideoPlayer) objArr[0]) != this && isPlaying()) {
            pause();
            maybeReportPlayerState(true);
        }
    }

    private void ensurePleyaerCreated() {
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, MessagesController.UPDATE_MASK_CHECK), 50000, 50000, 100, 5000, -1, false);
        if (this.player == null) {
            DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(ApplicationLoader.applicationContext);
            defaultRenderersFactory.setExtensionRendererMode(2);
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(ApplicationLoader.applicationContext, defaultRenderersFactory, this.trackSelector, defaultLoadControl);
            this.player = simpleExoPlayerNewSimpleInstance;
            simpleExoPlayerNewSimpleInstance.addListener(this);
            this.player.setVideoListener(this);
            TextureView textureView = this.textureView;
            if (textureView != null) {
                this.player.setVideoTextureView(textureView);
            } else {
                Surface surface = this.surface;
                if (surface != null) {
                    this.player.setVideoSurface(surface);
                }
            }
            this.player.setPlayWhenReady(this.autoplay);
            this.player.setRepeatMode(this.looping ? 2 : 0);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void preparePlayer(android.net.Uri r9, java.lang.String r10) {
        /*
            r8 = this;
            r8.videoUri = r9
            r8.videoType = r10
            r2 = 0
            r8.loopingMediaSource = r2
            r8.videoPlayerReady = r2
            java.lang.String r3 = r9.getScheme()
            if (r3 == 0) goto L15
            java.lang.String r4 = "file"
            boolean r3 = r3.startsWith(r4)
        L15:
            r8.ensurePleyaerCreated()
            r10.hashCode()
            r3 = -1
            int r4 = r10.hashCode()
            r6 = 1
            switch(r4) {
                case 3680: goto L3c;
                case 103407: goto L31;
                case 3075986: goto L26;
                default: goto L24;
            }
        L24:
            r2 = -1
            goto L45
        L26:
            java.lang.String r2 = "dash"
            boolean r0 = r10.equals(r2)
            if (r0 != 0) goto L2f
            goto L24
        L2f:
            r2 = 2
            goto L45
        L31:
            java.lang.String r2 = "hls"
            boolean r0 = r10.equals(r2)
            if (r0 != 0) goto L3a
            goto L24
        L3a:
            r2 = 1
            goto L45
        L3c:
            java.lang.String r4 = "ss"
            boolean r0 = r10.equals(r4)
            if (r0 != 0) goto L45
            goto L24
        L45:
            switch(r2) {
                case 0: goto L78;
                case 1: goto L6c;
                case 2: goto L5a;
                default: goto L48;
            }
        L48:
            com.google.android.exoplayer2.source.ExtractorMediaSource r7 = new com.google.android.exoplayer2.source.ExtractorMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r2 = r8.mediaDataSourceFactory
            com.google.android.exoplayer2.extractor.DefaultExtractorsFactory r3 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
            r3.<init>()
            android.os.Handler r4 = r8.mainHandler
            r5 = 0
            r0 = r7
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            goto L89
        L5a:
            com.google.android.exoplayer2.source.dash.DashMediaSource r7 = new com.google.android.exoplayer2.source.dash.DashMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r2 = r8.mediaDataSourceFactory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r3 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r3.<init>(r2)
            android.os.Handler r4 = r8.mainHandler
            r5 = 0
            r0 = r7
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            goto L89
        L6c:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r0 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            com.google.android.exoplayer2.upstream.DataSource$Factory r2 = r8.mediaDataSourceFactory
            r0.<init>(r2)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r7 = r0.createMediaSource(r9)
            goto L89
        L78:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r7 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r2 = r8.mediaDataSourceFactory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r3 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r3.<init>(r2)
            android.os.Handler r4 = r8.mainHandler
            r5 = 0
            r0 = r7
            r1 = r9
            r0.<init>(r1, r2, r3, r4, r5)
        L89:
            com.google.android.exoplayer2.SimpleExoPlayer r0 = r8.player
            r0.prepare(r7, r6, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.ExploreVideoPlayer.preparePlayer(android.net.Uri, java.lang.String):void");
    }

    public void releasePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.player = null;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.explorePlayerDidStartPlaying);
    }

    public void setTextureView(TextureView textureView) {
        if (this.textureView == textureView) {
            return;
        }
        this.textureView = textureView;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVideoTextureView(textureView);
    }

    public void play() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(true);
        }
    }

    public void pause() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
    }

    public void setPlayWhenReady(boolean z) {
        this.autoplay = z;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(z);
        }
    }

    public void setMute(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(z ? 0.0f : 1.0f);
        }
    }

    public void setDelegate(VideoPlayerDelegate videoPlayerDelegate) {
        if (videoPlayerDelegate == null) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.explorePlayerDidStartPlaying);
        }
        this.delegate = videoPlayerDelegate;
    }

    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        return simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady();
    }

    public void setLooping(boolean z) {
        if (this.looping != z) {
            this.looping = z;
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setRepeatMode(z ? 2 : 0);
            }
        }
    }

    private void checkPlayersReady() {
        if (this.videoPlayerReady) {
            play();
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z, int i) {
        maybeReportPlayerState(false);
        if (i == 3) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.explorePlayerDidStartPlaying, this);
        }
        if (!this.videoPlayerReady && i == 3) {
            this.videoPlayerReady = true;
            checkPlayersReady();
        }
        if (i != 3) {
            this.audioUpdateHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        exoPlaybackException.getCause();
        TextureView textureView = this.textureView;
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onError(this, exoPlaybackException);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onVideoSizeChanged(i, i2, i3, f);
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onRenderedFirstFrame() {
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onRenderedFirstFrame();
        }
    }

    private void maybeReportPlayerState(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        boolean playWhenReady = simpleExoPlayer.getPlayWhenReady();
        int playbackState = this.player.getPlaybackState();
        if (this.lastReportedPlayWhenReady == playWhenReady && this.lastReportedPlaybackState == playbackState && !z) {
            return;
        }
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onStateChanged(playWhenReady, playbackState, z);
        }
        this.lastReportedPlayWhenReady = playWhenReady;
        this.lastReportedPlaybackState = playbackState;
    }
}
