package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.TeeAudioProcessor;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.video.SurfaceNotValidException;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FourierTransform;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.secretmedia.ExtendedDefaultDataSourceFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.linphone.mediastream.Factory;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class VideoPlayer implements Player.EventListener, SimpleExoPlayer.VideoListener, AnalyticsListener, NotificationCenter.NotificationCenterDelegate {
    private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
    private SimpleExoPlayer audioPlayer;
    private boolean audioPlayerReady;
    private String audioType;
    Handler audioUpdateHandler;
    private Uri audioUri;
    private AudioVisualizerDelegate audioVisualizerDelegate;
    private boolean autoplay;
    private Uri currentUri;
    private VideoPlayerDelegate delegate;
    private boolean isStreaming;
    private boolean lastReportedPlayWhenReady;
    private int lastReportedPlaybackState;
    private boolean looping;
    private boolean loopingMediaSource;
    private Handler mainHandler;
    private DataSource.Factory mediaDataSourceFactory;
    private boolean mixedAudio;
    private boolean mixedPlayWhenReady;
    private SimpleExoPlayer player;
    private int repeatCount;
    private boolean shouldPauseOther;
    private Surface surface;
    private TextureView textureView;
    private MappingTrackSelector trackSelector;
    private boolean triedReinit;
    private boolean videoPlayerReady;
    private String videoType;
    private Uri videoUri;

    public interface AudioVisualizerDelegate {
        boolean needUpdate();

        void onVisualizerUpdate(boolean playing, boolean animate, float[] values);
    }

    public interface VideoPlayerDelegate {

        /* renamed from: ir.eitaa.ui.Components.VideoPlayer$VideoPlayerDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onRenderedFirstFrame(VideoPlayerDelegate videoPlayerDelegate, AnalyticsListener.EventTime eventTime) {
            }

            public static void $default$onSeekFinished(VideoPlayerDelegate videoPlayerDelegate, AnalyticsListener.EventTime eventTime) {
            }

            public static void $default$onSeekStarted(VideoPlayerDelegate videoPlayerDelegate, AnalyticsListener.EventTime eventTime) {
            }
        }

        void onError(VideoPlayer player, Exception e);

        void onRenderedFirstFrame();

        void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime);

        void onSeekFinished(AnalyticsListener.EventTime eventTime);

        void onSeekStarted(AnalyticsListener.EventTime eventTime);

        void onStateChanged(boolean playWhenReady, int playbackState);

        boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture);

        void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture);

        void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        AnalyticsListener.CC.$default$onAudioAttributesChanged(this, eventTime, audioAttributes);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioSessionId(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onAudioSessionId(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        AnalyticsListener.CC.$default$onAudioUnderrun(this, eventTime, i, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        AnalyticsListener.CC.$default$onBandwidthEstimate(this, eventTime, i, j, j2);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onDecoderDisabled(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
        AnalyticsListener.CC.$default$onDecoderEnabled(this, eventTime, i, decoderCounters);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
        AnalyticsListener.CC.$default$onDecoderInitialized(this, eventTime, i, str, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
        AnalyticsListener.CC.$default$onDecoderInputFormatChanged(this, eventTime, i, format);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onDownstreamFormatChanged(this, eventTime, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmKeysLoaded(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmKeysRestored(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmSessionAcquired(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        AnalyticsListener.CC.$default$onDrmSessionManagerError(this, eventTime, exc);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onDrmSessionReleased(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        AnalyticsListener.CC.$default$onDroppedVideoFrames(this, eventTime, i, j);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onIsPlayingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onIsPlayingChanged(boolean z) {
        Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onLoadCanceled(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onLoadCompleted(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadError(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.CC.$default$onLoadError(this, eventTime, loadEventInfo, mediaLoadData, iOException, z);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onLoadStarted(this, eventTime, loadEventInfo, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
        AnalyticsListener.CC.$default$onLoadingChanged(this, eventTime, z);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean isLoading) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMediaPeriodCreated(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onMediaPeriodCreated(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMediaPeriodReleased(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onMediaPeriodReleased(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        AnalyticsListener.CC.$default$onMetadata(this, eventTime, metadata);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        AnalyticsListener.CC.$default$onPlaybackParametersChanged(this, eventTime, playbackParameters);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
        Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onPlaybackSuppressionReasonChanged(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        AnalyticsListener.CC.$default$onPlayerError(this, eventTime, exoPlaybackException);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        AnalyticsListener.CC.$default$onPlayerStateChanged(this, eventTime, z, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onPositionDiscontinuity(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onReadingStarted(AnalyticsListener.EventTime eventTime) {
        AnalyticsListener.CC.$default$onReadingStarted(this, eventTime);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int repeatMode) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onRepeatModeChanged(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int width, int height) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
        AnalyticsListener.CC.$default$onSurfaceSizeChanged(this, eventTime, i, i2);
    }

    /* JADX WARN: Failed to inline method: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
    /* JADX WARN: Not passed register '(r1v0 com.google.android.exoplayer2.Timeline)' in method call: com.google.android.exoplayer2.Player.EventListener.-CC.$default$onTimelineChanged(com.google.android.exoplayer2.Player$EventListener, com.google.android.exoplayer2.Timeline, int):void */
    @Override // com.google.android.exoplayer2.Player.EventListener
    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, i);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
        AnalyticsListener.CC.$default$onTimelineChanged(this, eventTime, i);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.CC.$default$onTracksChanged(this, eventTime, trackGroupArray, trackSelectionArray);
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaSourceEventListener.MediaLoadData mediaLoadData) {
        AnalyticsListener.CC.$default$onUpstreamDiscarded(this, eventTime, mediaLoadData);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
        AnalyticsListener.CC.$default$onVideoSizeChanged(this, eventTime, i, i2, i3, f);
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
        AnalyticsListener.CC.$default$onVolumeChanged(this, eventTime, f);
    }

    public VideoPlayer() {
        this(true);
    }

    public VideoPlayer(boolean pauseOther) {
        this.audioUpdateHandler = new Handler(Looper.getMainLooper());
        Context context = ApplicationLoader.applicationContext;
        DefaultBandwidthMeter defaultBandwidthMeter = BANDWIDTH_METER;
        this.mediaDataSourceFactory = new ExtendedDefaultDataSourceFactory(context, defaultBandwidthMeter, new DefaultHttpDataSourceFactory("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/47.0 (Chrome)", defaultBandwidthMeter));
        this.mainHandler = new Handler();
        this.trackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter));
        this.lastReportedPlaybackState = 1;
        this.shouldPauseOther = pauseOther;
        if (pauseOther) {
            NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.playerDidStartPlaying);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.playerDidStartPlaying && ((VideoPlayer) args[0]) != this && isPlaying()) {
            pause();
        }
    }

    private void ensurePleyaerCreated() {
        DefaultRenderersFactory defaultRenderersFactory;
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, 65536), 15000, 50000, 100, 5000, -1, true);
        if (this.player == null) {
            if (this.audioVisualizerDelegate != null) {
                defaultRenderersFactory = new AudioVisualizerRenderersFactory(ApplicationLoader.applicationContext);
            } else {
                defaultRenderersFactory = new DefaultRenderersFactory(ApplicationLoader.applicationContext);
            }
            defaultRenderersFactory.setExtensionRendererMode(2);
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance = ExoPlayerFactory.newSimpleInstance(ApplicationLoader.applicationContext, defaultRenderersFactory, this.trackSelector, defaultLoadControl, (DrmSessionManager<FrameworkMediaCrypto>) null);
            this.player = simpleExoPlayerNewSimpleInstance;
            simpleExoPlayerNewSimpleInstance.addAnalyticsListener(this);
            this.player.addListener(this);
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
            SimpleExoPlayer simpleExoPlayerNewSimpleInstance2 = ExoPlayerFactory.newSimpleInstance(ApplicationLoader.applicationContext, this.trackSelector, defaultLoadControl, (DrmSessionManager<FrameworkMediaCrypto>) null, 2);
            this.audioPlayer = simpleExoPlayerNewSimpleInstance2;
            simpleExoPlayerNewSimpleInstance2.addListener(new Player.EventListener() { // from class: ir.eitaa.ui.Components.VideoPlayer.1
                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onIsPlayingChanged(boolean z) {
                    Player.EventListener.CC.$default$onIsPlayingChanged(this, z);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onLoadingChanged(boolean isLoading) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.EventListener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlayerError(ExoPlaybackException error) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPositionDiscontinuity(int reason) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onRepeatModeChanged(int repeatMode) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onSeekProcessed() {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                    onTimelineChanged(timeline, timeline.getWindowCount() == 1 ? timeline.getWindow(0, new Timeline.Window()).manifest : null, i);
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
                }

                @Override // com.google.android.exoplayer2.Player.EventListener
                public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                    if (VideoPlayer.this.audioPlayerReady || playbackState != 3) {
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void preparePlayerLoop(android.net.Uri r19, java.lang.String r20, android.net.Uri r21, java.lang.String r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r0.videoUri = r1
            r2 = r21
            r0.audioUri = r2
            r3 = r20
            r0.videoType = r3
            r4 = r22
            r0.audioType = r4
            r5 = 1
            r0.loopingMediaSource = r5
            r0.mixedAudio = r5
            r6 = 0
            r0.audioPlayerReady = r6
            r0.videoPlayerReady = r6
            r18.ensurePleyaerCreated()
            r7 = 0
            r8 = r7
            r9 = 0
        L22:
            r10 = 2
            if (r9 >= r10) goto Laf
            if (r9 != 0) goto L2a
            r13 = r1
            r11 = r3
            goto L2c
        L2a:
            r13 = r2
            r11 = r4
        L2c:
            r11.hashCode()
            r12 = -1
            int r14 = r11.hashCode()
            switch(r14) {
                case 3680: goto L4d;
                case 103407: goto L42;
                case 3075986: goto L39;
                default: goto L37;
            }
        L37:
            r10 = -1
            goto L57
        L39:
            java.lang.String r14 = "dash"
            boolean r11 = r11.equals(r14)
            if (r11 != 0) goto L57
            goto L37
        L42:
            java.lang.String r10 = "hls"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L4b
            goto L37
        L4b:
            r10 = 1
            goto L57
        L4d:
            java.lang.String r10 = "ss"
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L56
            goto L37
        L56:
            r10 = 0
        L57:
            switch(r10) {
                case 0: goto L8e;
                case 1: goto L82;
                case 2: goto L6e;
                default: goto L5a;
            }
        L5a:
            com.google.android.exoplayer2.source.ExtractorMediaSource r10 = new com.google.android.exoplayer2.source.ExtractorMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r14 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.extractor.DefaultExtractorsFactory r15 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
            r15.<init>()
            android.os.Handler r11 = r0.mainHandler
            r17 = 0
            r12 = r10
            r16 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            goto La1
        L6e:
            com.google.android.exoplayer2.source.dash.DashMediaSource r10 = new com.google.android.exoplayer2.source.dash.DashMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r14 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r15 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r15.<init>(r14)
            android.os.Handler r11 = r0.mainHandler
            r17 = 0
            r12 = r10
            r16 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            goto La1
        L82:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r10 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            com.google.android.exoplayer2.upstream.DataSource$Factory r11 = r0.mediaDataSourceFactory
            r10.<init>(r11)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r10 = r10.createMediaSource(r13)
            goto La1
        L8e:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r10 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r14 = r0.mediaDataSourceFactory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r15 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r15.<init>(r14)
            android.os.Handler r11 = r0.mainHandler
            r17 = 0
            r12 = r10
            r16 = r11
            r12.<init>(r13, r14, r15, r16, r17)
        La1:
            com.google.android.exoplayer2.source.LoopingMediaSource r11 = new com.google.android.exoplayer2.source.LoopingMediaSource
            r11.<init>(r10)
            if (r9 != 0) goto Laa
            r7 = r11
            goto Lab
        Laa:
            r8 = r11
        Lab:
            int r9 = r9 + 1
            goto L22
        Laf:
            com.google.android.exoplayer2.SimpleExoPlayer r1 = r0.player
            r1.prepare(r7, r5, r5)
            com.google.android.exoplayer2.SimpleExoPlayer r1 = r0.audioPlayer
            r1.prepare(r8, r5, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.VideoPlayer.preparePlayerLoop(android.net.Uri, java.lang.String, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void preparePlayer(android.net.Uri r10, java.lang.String r11) {
        /*
            r9 = this;
            r9.videoUri = r10
            r9.videoType = r11
            r0 = 0
            r9.audioUri = r0
            r9.audioType = r0
            r0 = 0
            r9.loopingMediaSource = r0
            r9.videoPlayerReady = r0
            r9.mixedAudio = r0
            r9.currentUri = r10
            java.lang.String r1 = r10.getScheme()
            r2 = 1
            if (r1 == 0) goto L23
            java.lang.String r3 = "file"
            boolean r1 = r1.startsWith(r3)
            if (r1 != 0) goto L23
            r1 = 1
            goto L24
        L23:
            r1 = 0
        L24:
            r9.isStreaming = r1
            r9.ensurePleyaerCreated()
            r11.hashCode()
            r1 = -1
            int r3 = r11.hashCode()
            switch(r3) {
                case 3680: goto L57;
                case 103407: goto L4c;
                case 3075986: goto L41;
                case 3511141: goto L36;
                default: goto L34;
            }
        L34:
            r0 = -1
            goto L60
        L36:
            java.lang.String r0 = "rtmp"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L3f
            goto L34
        L3f:
            r0 = 3
            goto L60
        L41:
            java.lang.String r0 = "dash"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L4a
            goto L34
        L4a:
            r0 = 2
            goto L60
        L4c:
            java.lang.String r0 = "hls"
            boolean r11 = r11.equals(r0)
            if (r11 != 0) goto L55
            goto L34
        L55:
            r0 = 1
            goto L60
        L57:
            java.lang.String r3 = "ss"
            boolean r11 = r11.equals(r3)
            if (r11 != 0) goto L60
            goto L34
        L60:
            switch(r0) {
                case 0: goto La2;
                case 1: goto L96;
                case 2: goto L84;
                case 3: goto L75;
                default: goto L63;
            }
        L63:
            com.google.android.exoplayer2.source.ExtractorMediaSource r11 = new com.google.android.exoplayer2.source.ExtractorMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r5 = r9.mediaDataSourceFactory
            com.google.android.exoplayer2.extractor.DefaultExtractorsFactory r6 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
            r6.<init>()
            android.os.Handler r7 = r9.mainHandler
            r8 = 0
            r3 = r11
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            goto Lb3
        L75:
            ir.eitaa.messenger.exoplayer2.ext.rtmp.RtmpDataSourceFactory r11 = new ir.eitaa.messenger.exoplayer2.ext.rtmp.RtmpDataSourceFactory
            r11.<init>()
            com.google.android.exoplayer2.source.ExtractorMediaSource$Factory r0 = new com.google.android.exoplayer2.source.ExtractorMediaSource$Factory
            r0.<init>(r11)
            com.google.android.exoplayer2.source.ExtractorMediaSource r11 = r0.createMediaSource(r10)
            goto Lb3
        L84:
            com.google.android.exoplayer2.source.dash.DashMediaSource r11 = new com.google.android.exoplayer2.source.dash.DashMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r5 = r9.mediaDataSourceFactory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r6 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r6.<init>(r5)
            android.os.Handler r7 = r9.mainHandler
            r8 = 0
            r3 = r11
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            goto Lb3
        L96:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r11 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            com.google.android.exoplayer2.upstream.DataSource$Factory r0 = r9.mediaDataSourceFactory
            r11.<init>(r0)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r11 = r11.createMediaSource(r10)
            goto Lb3
        La2:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r11 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
            com.google.android.exoplayer2.upstream.DataSource$Factory r5 = r9.mediaDataSourceFactory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r6 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r6.<init>(r5)
            android.os.Handler r7 = r9.mainHandler
            r8 = 0
            r3 = r11
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8)
        Lb3:
            com.google.android.exoplayer2.SimpleExoPlayer r10 = r9.player
            r10.prepare(r11, r2, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.VideoPlayer.preparePlayer(android.net.Uri, java.lang.String):void");
    }

    public boolean isPlayerPrepared() {
        return this.player != null;
    }

    public void releasePlayer(boolean async) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release(async);
            this.player = null;
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.release(async);
            this.audioPlayer = null;
        }
        if (this.shouldPauseOther) {
            NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.playerDidStartPlaying);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onSeekStarted(eventTime);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onSeekFinished(eventTime);
        }
    }

    @Override // com.google.android.exoplayer2.analytics.AnalyticsListener
    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Surface surface) {
        VideoPlayerDelegate videoPlayerDelegate = this.delegate;
        if (videoPlayerDelegate != null) {
            videoPlayerDelegate.onRenderedFirstFrame(eventTime);
        }
    }

    public void setTextureView(TextureView texture) {
        if (this.textureView == texture) {
            return;
        }
        this.textureView = texture;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVideoTextureView(texture);
    }

    public void setSurface(Surface s) {
        if (this.surface == s) {
            return;
        }
        this.surface = s;
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        simpleExoPlayer.setVideoSurface(s);
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
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

    public void setPlaybackSpeed(float speed) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(speed, speed > 1.0f ? 0.98f : 1.0f));
        }
    }

    public void setPlayWhenReady(boolean playWhenReady) {
        this.mixedPlayWhenReady = playWhenReady;
        if (playWhenReady && this.mixedAudio && (!this.audioPlayerReady || !this.videoPlayerReady)) {
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
        this.autoplay = playWhenReady;
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.setPlayWhenReady(playWhenReady);
        }
        SimpleExoPlayer simpleExoPlayer4 = this.audioPlayer;
        if (simpleExoPlayer4 != null) {
            simpleExoPlayer4.setPlayWhenReady(playWhenReady);
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

    public boolean isMuted() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        return simpleExoPlayer != null && simpleExoPlayer.getVolume() == 0.0f;
    }

    public void setMute(boolean value) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(value ? 0.0f : 1.0f);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setVolume(value ? 0.0f : 1.0f);
        }
    }

    public void setVolume(float volume) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(volume);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setVolume(volume);
        }
    }

    public void seekTo(long positionMs) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.seekTo(positionMs);
        }
    }

    public void setDelegate(VideoPlayerDelegate videoPlayerDelegate) {
        this.delegate = videoPlayerDelegate;
    }

    public void setAudioVisualizerDelegate(AudioVisualizerDelegate audioVisualizerDelegate) {
        this.audioVisualizerDelegate = audioVisualizerDelegate;
    }

    public long getBufferedPosition() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            return this.isStreaming ? simpleExoPlayer.getBufferedPosition() : simpleExoPlayer.getDuration();
        }
        return 0L;
    }

    public boolean isPlaying() {
        SimpleExoPlayer simpleExoPlayer;
        return (this.mixedAudio && this.mixedPlayWhenReady) || ((simpleExoPlayer = this.player) != null && simpleExoPlayer.getPlayWhenReady());
    }

    public boolean isBuffering() {
        return this.player != null && this.lastReportedPlaybackState == 2;
    }

    public void setStreamType(int type) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setAudioStreamType(type);
        }
        SimpleExoPlayer simpleExoPlayer2 = this.audioPlayer;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.setAudioStreamType(type);
        }
    }

    public void setLooping(boolean looping) {
        if (this.looping != looping) {
            this.looping = looping;
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setRepeatMode(looping ? 2 : 0);
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
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        maybeReportPlayerState();
        if (playWhenReady && playbackState == 3 && !isMuted() && this.shouldPauseOther) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.playerDidStartPlaying, this);
        }
        if (!this.videoPlayerReady && playbackState == 3) {
            this.videoPlayerReady = true;
            checkPlayersReady();
        }
        if (playbackState != 3) {
            this.audioUpdateHandler.removeCallbacksAndMessages(null);
            AudioVisualizerDelegate audioVisualizerDelegate = this.audioVisualizerDelegate;
            if (audioVisualizerDelegate != null) {
                audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int reason) {
        if (reason == 0) {
            this.repeatCount++;
        }
    }

    @Override // com.google.android.exoplayer2.Player.EventListener
    public void onPlayerError(ExoPlaybackException error) {
        Throwable cause = error.getCause();
        TextureView textureView = this.textureView;
        if (textureView != null && ((!this.triedReinit && (cause instanceof MediaCodecRenderer.DecoderInitializationException)) || (cause instanceof SurfaceNotValidException))) {
            this.triedReinit = true;
            if (this.player != null) {
                ViewGroup viewGroup = (ViewGroup) textureView.getParent();
                if (viewGroup != null) {
                    int iIndexOfChild = viewGroup.indexOfChild(this.textureView);
                    viewGroup.removeView(this.textureView);
                    viewGroup.addView(this.textureView, iIndexOfChild);
                }
                this.player.clearVideoTextureView(this.textureView);
                this.player.setVideoTextureView(this.textureView);
                if (this.loopingMediaSource) {
                    preparePlayerLoop(this.videoUri, this.videoType, this.audioUri, this.audioType);
                } else {
                    preparePlayer(this.videoUri, this.videoType);
                }
                play();
                return;
            }
            return;
        }
        this.delegate.onError(this, error);
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
        this.delegate.onVideoSizeChanged(width, height, unappliedRotationDegrees, pixelWidthHeightRatio);
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onRenderedFirstFrame() {
        this.delegate.onRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public boolean onSurfaceDestroyed(SurfaceTexture surfaceTexture) {
        return this.delegate.onSurfaceDestroyed(surfaceTexture);
    }

    @Override // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.delegate.onSurfaceTextureUpdated(surfaceTexture);
    }

    private void maybeReportPlayerState() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer == null) {
            return;
        }
        boolean playWhenReady = simpleExoPlayer.getPlayWhenReady();
        int playbackState = this.player.getPlaybackState();
        if (this.lastReportedPlayWhenReady == playWhenReady && this.lastReportedPlaybackState == playbackState) {
            return;
        }
        this.delegate.onStateChanged(playWhenReady, playbackState);
        this.lastReportedPlayWhenReady = playWhenReady;
        this.lastReportedPlaybackState = playbackState;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    private class AudioVisualizerRenderersFactory extends DefaultRenderersFactory {
        public AudioVisualizerRenderersFactory(Context context) {
            super(context);
        }

        @Override // com.google.android.exoplayer2.DefaultRenderersFactory
        protected void buildAudioRenderers(Context context, int extensionRendererMode, MediaCodecSelector mediaCodecSelector, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, boolean playClearSamplesWithoutKeys, boolean enableDecoderFallback, AudioProcessor[] audioProcessors, Handler eventHandler, AudioRendererEventListener eventListener, ArrayList<Renderer> out) {
            super.buildAudioRenderers(context, extensionRendererMode, mediaCodecSelector, drmSessionManager, playClearSamplesWithoutKeys, enableDecoderFallback, new AudioProcessor[]{new TeeAudioProcessor(VideoPlayer.this.new VisualizerBufferSink())}, eventHandler, eventListener, out);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class VisualizerBufferSink implements TeeAudioProcessor.AudioBufferSink {
        ByteBuffer byteBuffer;
        long lastUpdateTime;
        private final int BUFFER_SIZE = Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV;
        private final int MAX_BUFFER_SIZE = 8192;
        FourierTransform.FFT fft = new FourierTransform.FFT(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV, 48000.0f);
        float[] real = new float[Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
        int position = 0;

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void flush(int sampleRateHz, int channelCount, int encoding) {
        }

        public VisualizerBufferSink() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(8192);
            this.byteBuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.position(0);
        }

        @Override // com.google.android.exoplayer2.audio.TeeAudioProcessor.AudioBufferSink
        public void handleBuffer(ByteBuffer buffer) {
            if (VideoPlayer.this.audioVisualizerDelegate == null) {
                return;
            }
            if (buffer != AudioProcessor.EMPTY_BUFFER && VideoPlayer.this.mixedPlayWhenReady) {
                if (VideoPlayer.this.audioVisualizerDelegate.needUpdate()) {
                    int iLimit = buffer.limit();
                    int i = 0;
                    if (iLimit > 8192) {
                        VideoPlayer.this.audioUpdateHandler.removeCallbacksAndMessages(null);
                        VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
                        return;
                    }
                    this.byteBuffer.put(buffer);
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
                        float fSqrt2 = (float) Math.sqrt(f / Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV);
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
                        VideoPlayer.this.audioUpdateHandler.postDelayed(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoPlayer$VisualizerBufferSink$yA4Gtax9XEpYwq4luurC6UKKV40
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$handleBuffer$1$VideoPlayer$VisualizerBufferSink(fArr);
                            }
                        }, 130L);
                        return;
                    }
                    return;
                }
                return;
            }
            VideoPlayer.this.audioUpdateHandler.postDelayed(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoPlayer$VisualizerBufferSink$PBNueWp7sfwHT4tzhZ8gTMvFd5M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleBuffer$0$VideoPlayer$VisualizerBufferSink();
                }
            }, 80L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleBuffer$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleBuffer$0$VideoPlayer$VisualizerBufferSink() {
            VideoPlayer.this.audioUpdateHandler.removeCallbacksAndMessages(null);
            VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(false, true, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$handleBuffer$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$handleBuffer$1$VideoPlayer$VisualizerBufferSink(float[] fArr) {
            VideoPlayer.this.audioVisualizerDelegate.onVisualizerUpdate(true, true, fArr);
        }
    }

    public void addListener(Player.EventListener listener) {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.addListener(listener);
        }
    }
}
