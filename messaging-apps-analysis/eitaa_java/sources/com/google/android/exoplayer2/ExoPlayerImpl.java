package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
final class ExoPlayerImpl extends BasePlayer implements Player {
    final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private MediaSource mediaSource;
    private final ArrayDeque<Runnable> pendingListenerNotifications;
    private int pendingOperationAcks;
    private int pendingSetPlaybackParametersAcks;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private int playbackSuppressionReason;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] renderers, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, Clock clock, Looper looper) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.7] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(renderers.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(renderers);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArrayList<>();
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[renderers.length], new TrackSelection[renderers.length], null);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.period = new Timeline.Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackSuppressionReason = 0;
        Handler handler = new Handler(looper) { // from class: com.google.android.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                ExoPlayerImpl.this.handleEvent(msg);
            }
        };
        this.eventHandler = handler;
        this.playbackInfo = PlaybackInfo.createDummy(0L, trackSelectorResult);
        this.pendingListenerNotifications = new ArrayDeque<>();
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(renderers, trackSelector, trackSelectorResult, loadControl, bandwidthMeter, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, handler, clock);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    public Looper getApplicationLooper() {
        return this.eventHandler.getLooper();
    }

    public void addListener(Player.EventListener listener) {
        this.listeners.addIfAbsent(new BasePlayer.ListenerHolder(listener));
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.playbackSuppressionReason;
    }

    public void prepare(MediaSource mediaSource, boolean resetPosition, boolean resetState) {
        this.mediaSource = mediaSource;
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(resetPosition, resetState, true, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, resetPosition, resetState);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false);
    }

    public void setPlayWhenReady(final boolean playWhenReady, final int playbackSuppressionReason) {
        boolean zIsPlaying = isPlaying();
        boolean z = this.playWhenReady && this.playbackSuppressionReason == 0;
        boolean z2 = playWhenReady && playbackSuppressionReason == 0;
        if (z != z2) {
            this.internalPlayer.setPlayWhenReady(z2);
        }
        final boolean z3 = this.playWhenReady != playWhenReady;
        final boolean z4 = this.playbackSuppressionReason != playbackSuppressionReason;
        this.playWhenReady = playWhenReady;
        this.playbackSuppressionReason = playbackSuppressionReason;
        final boolean zIsPlaying2 = isPlaying();
        final boolean z5 = zIsPlaying != zIsPlaying2;
        if (z3 || z4 || z5) {
            final int i = this.playbackInfo.playbackState;
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$Anl4wgLYsC6plFqgFnquoglVB8k
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    ExoPlayerImpl.lambda$setPlayWhenReady$0(z3, playWhenReady, i, z4, playbackSuppressionReason, z5, zIsPlaying2, eventListener);
                }
            });
        }
    }

    static /* synthetic */ void lambda$setPlayWhenReady$0(boolean z, boolean z2, int i, boolean z3, int i2, boolean z4, boolean z5, Player.EventListener eventListener) {
        if (z) {
            eventListener.onPlayerStateChanged(z2, i);
        }
        if (z3) {
            eventListener.onPlaybackSuppressionReasonChanged(i2);
        }
        if (z4) {
            eventListener.onIsPlayingChanged(z5);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public void setRepeatMode(final int repeatMode) {
        if (this.repeatMode != repeatMode) {
            this.repeatMode = repeatMode;
            this.internalPlayer.setRepeatMode(repeatMode);
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$tGV_XqXG6_HwwroKzxWphBtarXU
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onRepeatModeChanged(repeatMode);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int windowIndex, long positionMs) {
        Timeline timeline = this.playbackInfo.timeline;
        if (windowIndex < 0 || (!timeline.isEmpty() && windowIndex >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, windowIndex, positionMs);
        }
        this.hasPendingSeek = true;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        this.maskingWindowIndex = windowIndex;
        if (timeline.isEmpty()) {
            this.maskingWindowPositionMs = positionMs == -9223372036854775807L ? 0L : positionMs;
            this.maskingPeriodIndex = 0;
        } else {
            long defaultPositionUs = positionMs == -9223372036854775807L ? timeline.getWindow(windowIndex, this.window).getDefaultPositionUs() : C.msToUs(positionMs);
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, windowIndex, defaultPositionUs);
            this.maskingWindowPositionMs = C.usToMs(defaultPositionUs);
            this.maskingPeriodIndex = timeline.getIndexOfPeriod(periodPosition.first);
        }
        this.internalPlayer.seekTo(timeline, windowIndex, C.msToUs(positionMs));
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$9ZjGv0SCSpToDB7Ws9WHMmbE9xw
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                eventListener.onPositionDiscontinuity(1);
            }
        });
    }

    public void setPlaybackParameters(final PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (this.playbackParameters.equals(playbackParameters)) {
            return;
        }
        this.pendingSetPlaybackParametersAcks++;
        this.playbackParameters = playbackParameters;
        this.internalPlayer.setPlaybackParameters(playbackParameters);
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$l_K9Bc1W_xCr0bkgStCqoLXamH4
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                eventListener.onPlaybackParametersChanged(playbackParameters);
            }
        });
    }

    public void release(boolean async) {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.7] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        this.mediaSource = null;
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
        this.playbackInfo = getResetPlaybackInfo(false, false, false, 1);
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    public int getCurrentPeriodIndex() {
        if (shouldMaskPosition()) {
            return this.maskingPeriodIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    public long getDuration() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.periodId;
            playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
            return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
        }
        return getContentDuration();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.periodId.isAd()) {
            return C.usToMs(this.playbackInfo.positionUs);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return periodPositionUsToWindowPositionMs(playbackInfo.periodId, playbackInfo.positionUs);
    }

    public long getBufferedPosition() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            if (playbackInfo.loadingMediaPeriodId.equals(playbackInfo.periodId)) {
                return C.usToMs(this.playbackInfo.bufferedPositionUs);
            }
            return getDuration();
        }
        return getContentBufferedPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if (isPlayingAd()) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period);
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (playbackInfo2.contentPositionUs == -9223372036854775807L) {
                return playbackInfo2.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
            }
            return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.contentPositionUs);
        }
        return getCurrentPosition();
    }

    public long getContentBufferedPosition() {
        if (shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.loadingMediaPeriodId.windowSequenceNumber != playbackInfo.periodId.windowSequenceNumber) {
            return playbackInfo.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j = playbackInfo.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            Timeline.Period periodByUid = playbackInfo2.timeline.getPeriodByUid(playbackInfo2.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        return periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, j);
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    void handleEvent(Message msg) {
        int i = msg.what;
        if (i != 0) {
            if (i == 1) {
                handlePlaybackParameters((PlaybackParameters) msg.obj, msg.arg1 != 0);
                return;
            }
            throw new IllegalStateException();
        }
        PlaybackInfo playbackInfo = (PlaybackInfo) msg.obj;
        int i2 = msg.arg1;
        int i3 = msg.arg2;
        handlePlaybackInfo(playbackInfo, i2, i3 != -1, i3);
    }

    private void handlePlaybackParameters(final PlaybackParameters playbackParameters, boolean operationAck) {
        if (operationAck) {
            this.pendingSetPlaybackParametersAcks--;
        }
        if (this.pendingSetPlaybackParametersAcks != 0 || this.playbackParameters.equals(playbackParameters)) {
            return;
        }
        this.playbackParameters = playbackParameters;
        notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$7X3yJ-X9QlG_PTT7tzuaSJAZ84A
            @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
            public final void invokeListener(Player.EventListener eventListener) {
                eventListener.onPlaybackParametersChanged(playbackParameters);
            }
        });
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo, int operationAcks, boolean positionDiscontinuity, int positionDiscontinuityReason) {
        int i = this.pendingOperationAcks - operationAcks;
        this.pendingOperationAcks = i;
        if (i == 0) {
            if (playbackInfo.startPositionUs == -9223372036854775807L) {
                playbackInfo = playbackInfo.copyWithNewPosition(playbackInfo.periodId, 0L, playbackInfo.contentPositionUs, playbackInfo.totalBufferedDurationUs);
            }
            PlaybackInfo playbackInfo2 = playbackInfo;
            if (!this.playbackInfo.timeline.isEmpty() && playbackInfo2.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            int i2 = this.hasPendingPrepare ? 0 : 2;
            boolean z = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfo2, positionDiscontinuity, positionDiscontinuityReason, i2, z);
        }
    }

    private PlaybackInfo getResetPlaybackInfo(boolean resetPosition, boolean resetState, boolean resetError, int playbackState) {
        MediaSource.MediaPeriodId dummyFirstMediaPeriodId;
        if (resetPosition) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0L;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        boolean z = resetPosition || resetState;
        if (z) {
            dummyFirstMediaPeriodId = this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window, this.period);
        } else {
            dummyFirstMediaPeriodId = this.playbackInfo.periodId;
        }
        MediaSource.MediaPeriodId mediaPeriodId = dummyFirstMediaPeriodId;
        long j = z ? 0L : this.playbackInfo.positionUs;
        return new PlaybackInfo(resetState ? Timeline.EMPTY : this.playbackInfo.timeline, mediaPeriodId, j, z ? -9223372036854775807L : this.playbackInfo.contentPositionUs, playbackState, resetError ? null : this.playbackInfo.playbackError, false, resetState ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups, resetState ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult, mediaPeriodId, j, 0L, j);
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, boolean seekProcessed) {
        boolean zIsPlaying = isPlaying();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo;
        notifyListeners(new PlaybackInfoUpdate(playbackInfo, playbackInfo2, this.listeners, this.trackSelector, positionDiscontinuity, positionDiscontinuityReason, timelineChangeReason, seekProcessed, this.playWhenReady, zIsPlaying != isPlaying()));
    }

    private void notifyListeners(final BasePlayer.ListenerInvocation listenerInvocation) {
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.listeners);
        notifyListeners(new Runnable() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$b59raXxaB-trjwE5bgpZInm1QnU
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerImpl.invokeAll(copyOnWriteArrayList, listenerInvocation);
            }
        });
    }

    private void notifyListeners(Runnable listenerNotificationRunnable) {
        boolean z = !this.pendingListenerNotifications.isEmpty();
        this.pendingListenerNotifications.addLast(listenerNotificationRunnable);
        if (z) {
            return;
        }
        while (!this.pendingListenerNotifications.isEmpty()) {
            this.pendingListenerNotifications.peekFirst().run();
            this.pendingListenerNotifications.removeFirst();
        }
    }

    private long periodPositionUsToWindowPositionMs(MediaSource.MediaPeriodId periodId, long positionUs) {
        long jUsToMs = C.usToMs(positionUs);
        this.playbackInfo.timeline.getPeriodByUid(periodId.periodUid, this.period);
        return jUsToMs + this.period.getPositionInWindowMs();
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class PlaybackInfoUpdate implements Runnable {
        private final boolean isLoadingChanged;
        private final boolean isPlayingChanged;
        private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listenerSnapshot;
        private final boolean playWhenReady;
        private final boolean playbackErrorChanged;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo, PlaybackInfo previousPlaybackInfo, CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners, TrackSelector trackSelector, boolean positionDiscontinuity, int positionDiscontinuityReason, int timelineChangeReason, boolean seekProcessed, boolean playWhenReady, boolean isPlayingChanged) {
            this.playbackInfo = playbackInfo;
            this.listenerSnapshot = new CopyOnWriteArrayList<>(listeners);
            this.trackSelector = trackSelector;
            this.positionDiscontinuity = positionDiscontinuity;
            this.positionDiscontinuityReason = positionDiscontinuityReason;
            this.timelineChangeReason = timelineChangeReason;
            this.seekProcessed = seekProcessed;
            this.playWhenReady = playWhenReady;
            this.isPlayingChanged = isPlayingChanged;
            this.playbackStateChanged = previousPlaybackInfo.playbackState != playbackInfo.playbackState;
            ExoPlaybackException exoPlaybackException = previousPlaybackInfo.playbackError;
            ExoPlaybackException exoPlaybackException2 = playbackInfo.playbackError;
            this.playbackErrorChanged = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.timelineChanged = previousPlaybackInfo.timeline != playbackInfo.timeline;
            this.isLoadingChanged = previousPlaybackInfo.isLoading != playbackInfo.isLoading;
            this.trackSelectorResultChanged = previousPlaybackInfo.trackSelectorResult != playbackInfo.trackSelectorResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.timelineChanged || this.timelineChangeReason == 0) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$5CYzqjAoGrz_o7QaAaFLbO__BNY
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$0$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.positionDiscontinuity) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$IhxLhBdLWmnpBK6yRnjm5odmxSM
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$1$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackErrorChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$06WAXA7vL-SBfQvmAx45uxQjmso
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$2$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$UqsaXpFuuRv863XYMXs39hUf7yo
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$3$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.isLoadingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$AiQa3tTLztqLMUDkLaoRx1DcPcw
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$4$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$f6PAGX8HQVJ6dHmWeyT7ZcoD5DI
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$5$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.isPlayingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$ExoPlayerImpl$PlaybackInfoUpdate$b8AtGdawGxQCz-_rX1H1__vkxF4
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$6$ExoPlayerImpl$PlaybackInfoUpdate(eventListener);
                    }
                });
            }
            if (this.seekProcessed) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.-$$Lambda$oCd7Sd1J7S2dXaSGw9hdygGVcYE
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        eventListener.onSeekProcessed();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onTimelineChanged(this.playbackInfo.timeline, this.timelineChangeReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$1$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPositionDiscontinuity(this.positionDiscontinuityReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$2$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlayerError(this.playbackInfo.playbackError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$3$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            eventListener.onTracksChanged(playbackInfo.trackGroups, playbackInfo.trackSelectorResult.selections);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$4$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onLoadingChanged(this.playbackInfo.isLoading);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$5$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$6$ExoPlayerImpl$PlaybackInfoUpdate(Player.EventListener eventListener) {
            eventListener.onIsPlayingChanged(this.playbackInfo.playbackState == 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeAll(CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners, BasePlayer.ListenerInvocation listenerInvocation) {
        Iterator<BasePlayer.ListenerHolder> it = listeners.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }
}
