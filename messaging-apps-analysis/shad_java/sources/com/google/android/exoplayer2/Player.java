package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.List;

/* loaded from: classes.dex */
public interface Player {

    public interface AudioComponent {
        void setVolume(float f);
    }

    public interface TextComponent {
        void addTextOutput(TextOutput textOutput);

        List<Cue> getCurrentCues();

        void removeTextOutput(TextOutput textOutput);
    }

    public interface VideoComponent {
        void addVideoListener(VideoListener videoListener);

        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        void removeVideoListener(VideoListener videoListener);

        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer);

        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);
    }

    void addListener(EventListener eventListener);

    Looper getApplicationLooper();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    long getDuration();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    ExoPlaybackException getPlayerError();

    int getPreviousWindowIndex();

    int getRendererType(int i);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    TextComponent getTextComponent();

    long getTotalBufferedDuration();

    VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowSeekable();

    boolean isPlaying();

    boolean isPlayingAd();

    void prepare();

    void removeListener(EventListener eventListener);

    void seekTo(int i, long j);

    void seekTo(long j);

    void setPlayWhenReady(boolean z);

    void setRepeatMode(int i);

    void setShuffleModeEnabled(boolean z);

    void stop(boolean z);

    public interface EventListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z);

        void onIsLoadingChanged(boolean z);

        void onIsPlayingChanged(boolean z);

        @Deprecated
        void onLoadingChanged(boolean z);

        void onMediaItemTransition(MediaItem mediaItem, int i);

        void onPlayWhenReadyChanged(boolean z, int i);

        void onPlaybackParametersChanged(PlaybackParameters playbackParameters);

        void onPlaybackStateChanged(int i);

        void onPlaybackSuppressionReasonChanged(int i);

        void onPlayerError(ExoPlaybackException exoPlaybackException);

        @Deprecated
        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity(int i);

        void onRepeatModeChanged(int i);

        @Deprecated
        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z);

        void onTimelineChanged(Timeline timeline, int i);

        @Deprecated
        void onTimelineChanged(Timeline timeline, Object obj, int i);

        void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

        /* renamed from: com.google.android.exoplayer2.Player$EventListener$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onExperimentalOffloadSchedulingEnabledChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onIsPlayingChanged(EventListener eventListener, boolean z) {
            }

            @Deprecated
            public static void $default$onLoadingChanged(EventListener eventListener, boolean z) {
            }

            public static void $default$onMediaItemTransition(EventListener eventListener, MediaItem mediaItem, int i) {
            }

            public static void $default$onPlayWhenReadyChanged(EventListener eventListener, boolean z, int i) {
            }

            public static void $default$onPlaybackParametersChanged(EventListener eventListener, PlaybackParameters playbackParameters) {
            }

            public static void $default$onPlaybackStateChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlaybackSuppressionReasonChanged(EventListener eventListener, int i) {
            }

            public static void $default$onPlayerError(EventListener eventListener, ExoPlaybackException exoPlaybackException) {
            }

            @Deprecated
            public static void $default$onPlayerStateChanged(EventListener eventListener, boolean z, int i) {
            }

            public static void $default$onPositionDiscontinuity(EventListener eventListener, int i) {
            }

            public static void $default$onRepeatModeChanged(EventListener eventListener, int i) {
            }

            @Deprecated
            public static void $default$onSeekProcessed(EventListener eventListener) {
            }

            public static void $default$onShuffleModeEnabledChanged(EventListener eventListener, boolean z) {
            }

            @Deprecated
            public static void $default$onTimelineChanged(EventListener eventListener, Timeline timeline, Object obj, int i) {
            }

            public static void $default$onTracksChanged(EventListener eventListener, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            }
        }
    }
}
