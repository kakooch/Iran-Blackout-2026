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
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.TeeAudioProcessor;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
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
import ir.appp.rghapp.rubinoPostSlider.FourierTransform;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;

/* loaded from: classes3.dex */
public class VideoPlayer implements Player.EventListener, SimpleExoPlayer.VideoListener, NotificationCenter.NotificationCenterDelegate {
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private SimpleExoPlayer audioPlayer;
    private boolean audioPlayerReady;
    private String audioType;
    Handler audioUpdateHandler = new Handler(Looper.getMainLooper());
    private Uri audioUri;
    private AudioVisualizerDelegate audioVisualizerDelegate;
    private boolean autoplay;
    private Uri currentUri;
    private VideoPlayerDelegate delegate;
    private boolean lastReportedPlayWhenReady;
    private int lastReportedPlaybackState;
    private boolean looping;
    private boolean loopingMediaSource;
    private Handler mainHandler;
    private DataSource.Factory mediaDataSourceFactory;
    private boolean mixedAudio;
    private boolean mixedPlayWhenReady;
    private SimpleExoPlayer player;
    private Surface surface;
    private TextureView textureView;
    private MappingTrackSelector trackSelector;
    private boolean videoPlayerReady;
    private String videoType;
    private Uri videoUri;

    public interface AudioVisualizerDelegate {
        boolean needUpdate();

        void onVisualizerUpdate(boolean z, boolean z2, float[] fArr);
    }

    public interface VideoPlayerDelegate {
        void onError(VideoPlayer videoPlayer, Exception exc);

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

    public VideoPlayer() {
        Context context = ApplicationLoader.applicationContext;
        DefaultBandwidthMeter defaultBandwidthMeter = BANDWIDTH_METER;
        this.mediaDataSourceFactory = new ExtendedDefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/47.0 (Chrome)", defaultBandwidthMeter));
        this.mainHandler = new Handler();
        this.trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory());
        this.lastReportedPlaybackState = 1;
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.playerDidStartPlaying);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.playerDidStartPlaying && (objArr[0] instanceof VideoPlayer) && ((VideoPlayer) objArr[0]) != this && isPlaying()) {
            pause();
            maybeReportPlayerState(true);
        }
    }

    private void ensurePleyaerCreated() {
        DefaultRenderersFactory defaultRenderersFactory;
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, MessagesController.UPDATE_MASK_CHECK), 50000, 50000, 100, 5000, -1, false);
        if (this.player == null) {
            if (this.audioVisualizerDelegate != null) {
                defaultRenderersFactory = new AudioVisualizerRenderersFactory(ApplicationLoader.applicationContext);
            } else {
                defaultRenderersFactory = new DefaultRenderersFactory(ApplicationLoader.applicationContext);
            }
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
        if (this.mixedAudio && this.audioPlayer == null) {
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance2 = ExoPlayerFactory.newSimpleInstance(ApplicationLoader.applicationContext, this.trackSelector, defaultLoadControl, 2);
            this.audioPlayer = simpleExoPlayerNewSimpleInstance2;
            simpleExoPlayerNewSimpleInstance2.addListener(new Player.EventListener() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoPlayer.1
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
                public void onPlayerError(ExoPlaybackException exoPlaybackException) {
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
                public void onPlayerStateChanged(boolean z, int i) {
                    if (VideoPlayer.this.audioPlayerReady || i != 3) {
                        return;
                    }
                    VideoPlayer.this.audioPlayerReady = true;
                    VideoPlayer.this.checkPlayersReady();
                }
            });
            this.audioPlayer.setPlayWhenReady(this.autoplay);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void preparePlayer(android.net.Uri r16, java.lang.String r17) {
        /*
            r15 = this;
            r0 = r15
            r2 = r16
            r1 = r17
            r0.videoUri = r2
            r0.videoType = r1
            r3 = 0
            r0.audioUri = r3
            r0.audioType = r3
            r3 = 0
            r0.loopingMediaSource = r3
            r0.videoPlayerReady = r3
            r0.mixedAudio = r3
            r0.currentUri = r2
            java.lang.String r4 = r16.getScheme()
            if (r4 == 0) goto L23
            java.lang.String r5 = "file"
            boolean r4 = r4.startsWith(r5)
        L23:
            r15.ensurePleyaerCreated()
            r17.hashCode()
            r4 = -1
            int r5 = r17.hashCode()
            r7 = 1
            switch(r5) {
                case -920168181: goto L55;
                case 3680: goto L4a;
                case 103407: goto L3f;
                case 3075986: goto L34;
                default: goto L32;
            }
        L32:
            r3 = -1
            goto L5e
        L34:
            java.lang.String r3 = "dash"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L3d
            goto L32
        L3d:
            r3 = 3
            goto L5e
        L3f:
            java.lang.String r3 = "hls"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L48
            goto L32
        L48:
            r3 = 2
            goto L5e
        L4a:
            java.lang.String r3 = "ss"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L53
            goto L32
        L53:
            r3 = 1
            goto L5e
        L55:
            java.lang.String r5 = "rubino"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L5e
            goto L32
        L5e:
            switch(r3) {
                case 0: goto La6;
                case 1: goto L93;
                case 2: goto L87;
                case 3: goto L74;
                default: goto L61;
            }
        L61:
            com.google.android.exoplayer2.source.ExtractorMediaSource r8 = new com.google.android.exoplayer2.source.ExtractorMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r3 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.extractor.DefaultExtractorsFactory r4 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
            r4.<init>()
            android.os.Handler r5 = r0.mainHandler
            r6 = 0
            r1 = r8
            r2 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            goto Lc3
        L74:
            com.google.android.exoplayer2.source.dash.DashMediaSource r8 = new com.google.android.exoplayer2.source.dash.DashMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r3 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r4 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r4.<init>(r3)
            android.os.Handler r5 = r0.mainHandler
            r6 = 0
            r1 = r8
            r2 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            goto Lc3
        L87:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r1 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            com.google.android.exoplayer2.upstream.DataSource$Factory r3 = r0.mediaDataSourceFactory
            r1.<init>(r3)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r8 = r1.createMediaSource(r2)
            goto Lc3
        L93:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r8 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r3 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r4 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r4.<init>(r3)
            android.os.Handler r5 = r0.mainHandler
            r6 = 0
            r1 = r8
            r2 = r16
            r1.<init>(r2, r3, r4, r5, r6)
            goto Lc3
        La6:
            com.google.android.exoplayer2.source.ExtractorMediaSource r8 = new com.google.android.exoplayer2.source.ExtractorMediaSource
            ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment$CacheDataSourceFactory r3 = new ir.iranlms.asemnavideoplayerlibrary.player.PlayerBaseFragment$CacheDataSourceFactory
            org.rbmain.ui.LaunchActivity r10 = org.rbmain.messenger.ApplicationLoader.applicationActivity
            r11 = 734003200(0x2bc00000, double:3.62645765E-315)
            r13 = 524288000(0x1f400000, double:2.590326893E-315)
            r9 = r3
            r9.<init>(r10, r11, r13)
            com.google.android.exoplayer2.extractor.DefaultExtractorsFactory r4 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
            r4.<init>()
            r5 = 0
            r6 = 0
            r1 = r8
            r2 = r16
            r1.<init>(r2, r3, r4, r5, r6)
        Lc3:
            com.google.android.exoplayer2.SimpleExoPlayer r1 = r0.player
            r1.prepare(r8, r7, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.rubinoPostSlider.VideoPlayer.preparePlayer(android.net.Uri, java.lang.String):void");
    }

    public void releasePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.player = null;
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.release();
            this.audioPlayer = null;
        }
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.playerDidStartPlaying);
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

    public void setSurface(Surface surface) {
        if (this.surface == surface) {
            return;
        }
        this.surface = surface;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVideoSurface(surface);
    }

    public Uri getCurrentUri() {
        return this.currentUri;
    }

    public void play() {
        this.mixedPlayWhenReady = true;
        if (this.mixedAudio && (!this.audioPlayerReady || !this.videoPlayerReady)) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.setPlayWhenReady(false);
                return;
            }
            return;
        }
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.setPlayWhenReady(true);
        }
        SimpleExoPlayer simpleExoPlayer4 = this.audioPlayer;
        if (simpleExoPlayer4 != null) {
            simpleExoPlayer4.setPlayWhenReady(true);
        }
    }

    public void pause() {
        this.mixedPlayWhenReady = false;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setPlayWhenReady(false);
        }
        if (this.audioVisualizerDelegate != null) {
            this.audioUpdateHandler.removeCallbacksAndMessages(null);
            this.audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
        }
    }

    public void setPlayWhenReady(boolean z) {
        this.mixedPlayWhenReady = z;
        if (z && this.mixedAudio && (!this.audioPlayerReady || !this.videoPlayerReady)) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.setPlayWhenReady(false);
                return;
            }
            return;
        }
        this.autoplay = z;
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.setPlayWhenReady(z);
        }
        SimpleExoPlayer simpleExoPlayer4 = this.audioPlayer;
        if (simpleExoPlayer4 != null) {
            simpleExoPlayer4.setPlayWhenReady(z);
        }
    }

    public long getDuration() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getDuration();
        }
        return 0L;
    }

    public long getCurrentPosition() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    public void setMute(boolean z) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(z ? 0.0f : 1.0f);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setVolume(z ? 0.0f : 1.0f);
        }
    }

    public void seekTo(long j) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(j);
        }
    }

    public void setDelegate(VideoPlayerDelegate videoPlayerDelegate) {
        if (videoPlayerDelegate == null) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.playerDidStartPlaying);
        }
        this.delegate = videoPlayerDelegate;
    }

    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer;
        return (this.mixedAudio && this.mixedPlayWhenReady) || ((simpleExoPlayer = this.player) != null && simpleExoPlayer.getPlayWhenReady());
    }

    public void setLooping(boolean z) {
        if (this.looping != z) {
            this.looping = z;
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setRepeatMode(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPlayersReady() {
        if (this.audioPlayerReady && this.videoPlayerReady && this.mixedPlayWhenReady) {
            play();
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(final boolean z, final int i) {
        if (Thread.currentThread() != ApplicationLoader.applicationHandler.getLooper().getThread()) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoPlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    VideoPlayer.this.onPlayerStateChangedInternal(z, i);
                }
            });
        } else {
            onPlayerStateChangedInternal(z, i);
        }
    }

    void onPlayerStateChangedInternal(boolean z, int i) {
        maybeReportPlayerState(false);
        if (i == 2 || i == 3) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.playerDidStartPlaying, this);
        }
        if (!this.videoPlayerReady && i == 3) {
            this.videoPlayerReady = true;
            checkPlayersReady();
        }
        if (i != 3) {
            this.audioUpdateHandler.removeCallbacksAndMessages(null);
            AudioVisualizerDelegate audioVisualizerDelegate = this.audioVisualizerDelegate;
            if (audioVisualizerDelegate != null) {
                audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
            }
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

    private class AudioVisualizerRenderersFactory extends DefaultRenderersFactory {
        public AudioVisualizerRenderersFactory(Context context) {
            super(context);
        }

        @Override // com.google.android.exoplayer2.DefaultRenderersFactory
        protected void buildAudioRenderers(Context context, int i, MediaCodecSelector mediaCodecSelector, boolean z, AudioSink audioSink, Handler handler, AudioRendererEventListener audioRendererEventListener, ArrayList<Renderer> arrayList) {
            super.buildAudioRenderers(context, i, mediaCodecSelector, z, new DefaultAudioSink(null, new AudioProcessor[]{new TeeAudioProcessor(VideoPlayer.this.new VisualizerBufferSink())}), handler, audioRendererEventListener, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class VisualizerBufferSink implements TeeAudioProcessor.AudioBufferSink {
        ByteBuffer byteBuffer;
        long lastUpdateTime;
        FourierTransform.FFT fft = new FourierTransform.FFT(1024, 48000.0f);
        float[] real = new float[1024];
        int position = 0;

        public VisualizerBufferSink() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(8192);
            this.byteBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.position(0);
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int i, int i2, int i3) {
            if (VideoPlayer.this.audioVisualizerDelegate == null) {
                return;
            }
            VideoPlayer.this.audioUpdateHandler.removeCallbacksAndMessages(null);
            VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(false, false, null);
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(ByteBuffer byteBuffer) {
            if (VideoPlayer.this.audioVisualizerDelegate == null) {
                return;
            }
            if (byteBuffer != AudioProcessor.EMPTY_BUFFER && VideoPlayer.this.mixedPlayWhenReady) {
                if (VideoPlayer.this.audioVisualizerDelegate.needUpdate()) {
                    int iLimit = byteBuffer.limit();
                    int i = 0;
                    if (iLimit > 8192) {
                        VideoPlayer.this.audioUpdateHandler.removeCallbacksAndMessages(null);
                        VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
                        return;
                    }
                    this.byteBuffer.put(byteBuffer);
                    int i2 = this.position + iLimit;
                    this.position = i2;
                    if (i2 >= 1024) {
                        this.byteBuffer.position(0);
                        for (int i3 = 0; i3 < 1024; i3++) {
                            this.real[i3] = this.byteBuffer.getShort() / 32768.0f;
                        }
                        this.byteBuffer.rewind();
                        this.position = 0;
                        this.fft.forward(this.real);
                        int i4 = 0;
                        float f = 0.0f;
                        while (true) {
                            float f2 = 1.0f;
                            if (i4 >= 1024) {
                                break;
                            }
                            float f3 = this.fft.getSpectrumReal()[i4];
                            float f4 = this.fft.getSpectrumImaginary()[i4];
                            float fSqrt = ((float) Math.sqrt((f3 * f3) + (f4 * f4))) / 30.0f;
                            if (fSqrt <= 1.0f) {
                                f2 = fSqrt < 0.0f ? 0.0f : fSqrt;
                            }
                            f += f2 * f2;
                            i4++;
                        }
                        float fSqrt2 = (float) Math.sqrt(f / 1024);
                        final float[] fArr = new float[7];
                        fArr[6] = fSqrt2;
                        if (fSqrt2 < 0.4f) {
                            while (i < 7) {
                                fArr[i] = 0.0f;
                                i++;
                            }
                        } else {
                            while (i < 6) {
                                int i5 = 170 * i;
                                float f5 = this.fft.getSpectrumReal()[i5];
                                float f6 = this.fft.getSpectrumImaginary()[i5];
                                fArr[i] = (float) (Math.sqrt((f5 * f5) + (f6 * f6)) / 30.0d);
                                if (fArr[i] > 1.0f) {
                                    fArr[i] = 1.0f;
                                } else if (fArr[i] < 0.0f) {
                                    fArr[i] = 0.0f;
                                }
                                i++;
                            }
                        }
                        if (System.currentTimeMillis() - this.lastUpdateTime < 64) {
                            return;
                        }
                        this.lastUpdateTime = System.currentTimeMillis();
                        VideoPlayer.this.audioUpdateHandler.postDelayed(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoPlayer$VisualizerBufferSink$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$handleBuffer$1(fArr);
                            }
                        }, 130L);
                        return;
                    }
                    return;
                }
                return;
            }
            VideoPlayer.this.audioUpdateHandler.postDelayed(new Runnable() { // from class: ir.appp.rghapp.rubinoPostSlider.VideoPlayer$VisualizerBufferSink$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleBuffer$0();
                }
            }, 80L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleBuffer$0() {
            VideoPlayer.this.audioUpdateHandler.removeCallbacksAndMessages(null);
            VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleBuffer$1(float[] fArr) {
            VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(true, true, fArr);
        }
    }

    public SimpleExoPlayer getInternalVideoPlayer() {
        return this.player;
    }
}
