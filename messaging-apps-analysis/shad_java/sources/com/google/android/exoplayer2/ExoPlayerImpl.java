package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private final AnalyticsCollector analyticsCollector;
    private final Looper applicationLooper;
    private final BandwidthMeter bandwidthMeter;
    final TrackSelectorResult emptyTrackSelectorResult;
    private boolean hasAdsMediaSource;
    private boolean hasPendingDiscontinuity;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private final MediaSourceFactory mediaSourceFactory;
    private final List<MediaSourceHolderSnapshot> mediaSourceHolderSnapshots;
    private int pendingDiscontinuityReason;
    private final ArrayDeque<Runnable> pendingListenerNotifications;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private final Handler playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    @Override // com.google.android.exoplayer2.Player
    public Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.google.android.exoplayer2.Player
    public Player.VideoComponent getVideoComponent() {
        return null;
    }

    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, SeekParameters seekParameters, boolean z2, Clock clock, Looper looper) {
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.12.2] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(rendererArr.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.mediaSourceFactory = mediaSourceFactory;
        this.bandwidthMeter = bandwidthMeter;
        this.analyticsCollector = analyticsCollector;
        this.useLazyPreparation = z;
        this.applicationLooper = looper;
        this.repeatMode = 0;
        this.listeners = new CopyOnWriteArrayList<>();
        this.mediaSourceHolderSnapshots = new ArrayList();
        this.shuffleOrder = new ShuffleOrder.DefaultShuffleOrder(0);
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr.length], new TrackSelection[rendererArr.length], null);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.period = new Timeline.Period();
        this.maskingWindowIndex = -1;
        this.playbackInfoUpdateHandler = new Handler(looper);
        ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener = new ExoPlayerImplInternal.PlaybackInfoUpdateListener() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda3
            @Override // com.google.android.exoplayer2.ExoPlayerImplInternal.PlaybackInfoUpdateListener
            public final void onPlaybackInfoUpdate(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
                this.f$0.lambda$new$1(playbackInfoUpdate);
            }
        };
        this.playbackInfoUpdateListener = playbackInfoUpdateListener;
        this.playbackInfo = PlaybackInfo.createDummy(trackSelectorResult);
        this.pendingListenerNotifications = new ArrayDeque<>();
        if (analyticsCollector != null) {
            analyticsCollector.setPlayer(this);
            addListener(analyticsCollector);
            bandwidthMeter.addEventListener(new Handler(looper), analyticsCollector);
        }
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArr, trackSelector, trackSelectorResult, loadControl, bandwidthMeter, this.repeatMode, this.shuffleModeEnabled, analyticsCollector, seekParameters, z2, looper, clock, playbackInfoUpdateListener);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.playbackInfoUpdateHandler.post(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0(playbackInfoUpdate);
            }
        });
    }

    public void experimentalDisableThrowWhenStuckBuffering() {
        this.internalPlayer.experimentalDisableThrowWhenStuckBuffering();
    }

    @Override // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    @Override // com.google.android.exoplayer2.Player
    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.listeners.addIfAbsent(new BasePlayer.ListenerHolder(eventListener));
    }

    @Override // com.google.android.exoplayer2.Player
    public void removeListener(Player.EventListener eventListener) {
        Iterator<BasePlayer.ListenerHolder> it = this.listeners.iterator();
        while (it.hasNext()) {
            BasePlayer.ListenerHolder next = it.next();
            if (next.listener.equals(eventListener)) {
                next.release();
                this.listeners.remove(next);
            }
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    @Override // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    @Override // com.google.android.exoplayer2.Player
    public void prepare() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playbackState != 1) {
            return;
        }
        PlaybackInfo playbackInfoCopyWithPlaybackError = playbackInfo.copyWithPlaybackError(null);
        PlaybackInfo playbackInfoCopyWithPlaybackState = playbackInfoCopyWithPlaybackError.copyWithPlaybackState(playbackInfoCopyWithPlaybackError.timeline.isEmpty() ? 4 : 2);
        this.pendingOperationAcks++;
        this.internalPlayer.prepare();
        updatePlaybackInfo(playbackInfoCopyWithPlaybackState, false, 4, 1, 1, false);
    }

    public void setMediaSources(List<MediaSource> list, int i, long j) {
        setMediaSourcesInternal(list, i, j, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        setPlayWhenReady(z, 0, 1);
    }

    public void setPlayWhenReady(boolean z, int i, int i2) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        if (playbackInfo.playWhenReady == z && playbackInfo.playbackSuppressionReason == i) {
            return;
        }
        this.pendingOperationAcks++;
        PlaybackInfo playbackInfoCopyWithPlayWhenReady = playbackInfo.copyWithPlayWhenReady(z, i);
        this.internalPlayer.setPlayWhenReady(z, i);
        updatePlaybackInfo(playbackInfoCopyWithPlayWhenReady, false, 4, 0, i2, false);
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setRepeatMode(final int i) {
        if (this.repeatMode != i) {
            this.repeatMode = i;
            this.internalPlayer.setRepeatMode(i);
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onRepeatModeChanged(i);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode;
    }

    @Override // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(final boolean z) {
        if (this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    eventListener.onShuffleModeEnabledChanged(z);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override // com.google.android.exoplayer2.Player
    public void seekTo(int i, long j) {
        Timeline timeline = this.playbackInfo.timeline;
        if (i < 0 || (!timeline.isEmpty() && i >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo));
        } else {
            PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo.copyWithPlaybackState(getPlaybackState() != 1 ? 2 : 1), timeline, getPeriodPositionOrMaskWindowPosition(timeline, i, j));
            this.internalPlayer.seekTo(timeline, i, C.msToUs(j));
            updatePlaybackInfo(playbackInfoMaskTimelineAndPosition, true, 1, 0, 1, true);
        }
    }

    @Override // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackInfo.playbackParameters;
    }

    @Override // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId;
        if (z) {
            playbackInfoCopyWithLoadingMediaPeriodId = removeMediaItemsInternal(0, this.mediaSourceHolderSnapshots.size()).copyWithPlaybackError(null);
        } else {
            PlaybackInfo playbackInfo = this.playbackInfo;
            playbackInfoCopyWithLoadingMediaPeriodId = playbackInfo.copyWithLoadingMediaPeriodId(playbackInfo.periodId);
            playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
            playbackInfoCopyWithLoadingMediaPeriodId.totalBufferedDurationUs = 0L;
        }
        PlaybackInfo playbackInfoCopyWithPlaybackState = playbackInfoCopyWithLoadingMediaPeriodId.copyWithPlaybackState(1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop();
        updatePlaybackInfo(playbackInfoCopyWithPlaybackState, false, 4, 0, 1, false);
    }

    public void release() {
        Log.i("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.12.2] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        if (!this.internalPlayer.release()) {
            notifyListeners(new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda2
                @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                public final void invokeListener(Player.EventListener eventListener) {
                    ExoPlayerImpl.lambda$release$5(eventListener);
                }
            });
        }
        this.playbackInfoUpdateHandler.removeCallbacksAndMessages(null);
        AnalyticsCollector analyticsCollector = this.analyticsCollector;
        if (analyticsCollector != null) {
            this.bandwidthMeter.removeEventListener(analyticsCollector);
        }
        PlaybackInfo playbackInfoCopyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(1);
        this.playbackInfo = playbackInfoCopyWithPlaybackState;
        PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId = playbackInfoCopyWithPlaybackState.copyWithLoadingMediaPeriodId(playbackInfoCopyWithPlaybackState.periodId);
        this.playbackInfo = playbackInfoCopyWithLoadingMediaPeriodId;
        playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$release$5(Player.EventListener eventListener) {
        eventListener.onPlayerError(ExoPlaybackException.createForTimeout(new TimeoutException("Player release timed out."), 1));
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingPeriodIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getIndexOfPeriod(playbackInfo.periodId.periodUid);
    }

    @Override // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    @Override // com.google.android.exoplayer2.Player
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
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        if (this.playbackInfo.periodId.isAd()) {
            return C.usToMs(this.playbackInfo.positionUs);
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return periodPositionUsToWindowPositionMs(playbackInfo.periodId, playbackInfo.positionUs);
    }

    @Override // com.google.android.exoplayer2.Player
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

    @Override // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return this.playbackInfo.periodId.isAd();
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
            if (playbackInfo2.requestedContentPositionUs == -9223372036854775807L) {
                return playbackInfo2.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
            }
            return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.requestedContentPositionUs);
        }
        return getCurrentPosition();
    }

    @Override // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if (this.playbackInfo.timeline.isEmpty()) {
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
    public int getRendererType(int i) {
        return this.renderers[i].getTrackType();
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    @Override // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    @Override // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    private int getCurrentWindowIndexInternal() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handlePlaybackInfo, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        int i = this.pendingOperationAcks - playbackInfoUpdate.operationAcks;
        this.pendingOperationAcks = i;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.hasPendingDiscontinuity = true;
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (i == 0) {
            Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
            if (!this.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                this.maskingWindowIndex = -1;
                this.maskingWindowPositionMs = 0L;
                this.maskingPeriodIndex = 0;
            }
            if (!timeline.isEmpty()) {
                List<Timeline> childTimelines = ((PlaylistTimeline) timeline).getChildTimelines();
                Assertions.checkState(childTimelines.size() == this.mediaSourceHolderSnapshots.size());
                for (int i2 = 0; i2 < childTimelines.size(); i2++) {
                    this.mediaSourceHolderSnapshots.get(i2).timeline = childTimelines.get(i2);
                }
            }
            boolean z = this.hasPendingDiscontinuity;
            this.hasPendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, z, this.pendingDiscontinuityReason, 1, this.pendingPlayWhenReadyChangeReason, false);
        }
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean z, int i, int i2, int i3, boolean z2) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo;
        Pair<Boolean, Integer> pairEvaluateMediaItemTransitionReason = evaluateMediaItemTransitionReason(playbackInfo, playbackInfo2, z, i, !playbackInfo2.timeline.equals(playbackInfo.timeline));
        boolean zBooleanValue = ((Boolean) pairEvaluateMediaItemTransitionReason.first).booleanValue();
        int iIntValue = ((Integer) pairEvaluateMediaItemTransitionReason.second).intValue();
        MediaItem mediaItem = null;
        if (zBooleanValue && !playbackInfo.timeline.isEmpty()) {
            mediaItem = playbackInfo.timeline.getWindow(playbackInfo.timeline.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex, this.window).mediaItem;
        }
        notifyListeners(new PlaybackInfoUpdate(playbackInfo, playbackInfo2, this.listeners, this.trackSelector, z, i, i2, zBooleanValue, iIntValue, mediaItem, i3, z2));
    }

    private Pair<Boolean, Integer> evaluateMediaItemTransitionReason(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, boolean z, int i, boolean z2) {
        Timeline timeline = playbackInfo2.timeline;
        Timeline timeline2 = playbackInfo.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i2 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        Object obj = timeline.getWindow(timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex, this.window).uid;
        Object obj2 = timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo.periodId.periodUid, this.period).windowIndex, this.window).uid;
        int i3 = this.window.firstPeriodIndex;
        if (!obj.equals(obj2)) {
            if (z && i == 0) {
                i2 = 1;
            } else if (z && i == 1) {
                i2 = 2;
            } else if (!z2) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i2));
        }
        if (z && i == 0 && timeline2.getIndexOfPeriod(playbackInfo.periodId.periodUid) == i3) {
            return new Pair<>(Boolean.TRUE, 0);
        }
        return new Pair<>(Boolean.FALSE, -1);
    }

    private void setMediaSourcesInternal(List<MediaSource> list, int i, long j, boolean z) {
        int firstWindowIndex;
        long j2;
        validateMediaSources(list, true);
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolderSnapshots.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolderSnapshots.size());
        }
        List<MediaSourceList.MediaSourceHolder> listAddMediaSourceHolders = addMediaSourceHolders(0, list);
        Timeline timelineCreateMaskingTimeline = createMaskingTimeline();
        if (!timelineCreateMaskingTimeline.isEmpty() && i >= timelineCreateMaskingTimeline.getWindowCount()) {
            throw new IllegalSeekPositionException(timelineCreateMaskingTimeline, i, j);
        }
        if (z) {
            j2 = -9223372036854775807L;
            firstWindowIndex = timelineCreateMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
        } else if (i == -1) {
            firstWindowIndex = currentWindowIndexInternal;
            j2 = currentPosition;
        } else {
            firstWindowIndex = i;
            j2 = j;
        }
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, timelineCreateMaskingTimeline, getPeriodPositionOrMaskWindowPosition(timelineCreateMaskingTimeline, firstWindowIndex, j2));
        int i2 = playbackInfoMaskTimelineAndPosition.playbackState;
        if (firstWindowIndex != -1 && i2 != 1) {
            i2 = (timelineCreateMaskingTimeline.isEmpty() || firstWindowIndex >= timelineCreateMaskingTimeline.getWindowCount()) ? 4 : 2;
        }
        PlaybackInfo playbackInfoCopyWithPlaybackState = playbackInfoMaskTimelineAndPosition.copyWithPlaybackState(i2);
        this.internalPlayer.setMediaSources(listAddMediaSourceHolders, firstWindowIndex, C.msToUs(j2), this.shuffleOrder);
        updatePlaybackInfo(playbackInfoCopyWithPlaybackState, false, 4, 0, 1, false);
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i2), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i2 + i, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource.getTimeline()));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i, arrayList.size());
        return arrayList;
    }

    private PlaybackInfo removeMediaItemsInternal(int i, int i2) {
        boolean z = false;
        Assertions.checkArgument(i >= 0 && i2 >= i && i2 <= this.mediaSourceHolderSnapshots.size());
        int currentWindowIndex = getCurrentWindowIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolderSnapshots.size();
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i, i2);
        Timeline timelineCreateMaskingTimeline = createMaskingTimeline();
        PlaybackInfo playbackInfoMaskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, timelineCreateMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, timelineCreateMaskingTimeline));
        int i3 = playbackInfoMaskTimelineAndPosition.playbackState;
        if (i3 != 1 && i3 != 4 && i < i2 && i2 == size && currentWindowIndex >= playbackInfoMaskTimelineAndPosition.timeline.getWindowCount()) {
            z = true;
        }
        if (z) {
            playbackInfoMaskTimelineAndPosition = playbackInfoMaskTimelineAndPosition.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i, i2, this.shuffleOrder);
        return playbackInfoMaskTimelineAndPosition;
    }

    private void removeMediaSourceHolders(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.mediaSourceHolderSnapshots.remove(i3);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i, i2);
        if (this.mediaSourceHolderSnapshots.isEmpty()) {
            this.hasAdsMediaSource = false;
        }
    }

    private void validateMediaSources(List<MediaSource> list, boolean z) {
        if (this.hasAdsMediaSource && !z && !list.isEmpty()) {
            throw new IllegalStateException();
        }
        int size = list.size() + (z ? 0 : this.mediaSourceHolderSnapshots.size());
        for (int i = 0; i < list.size(); i++) {
            if (((MediaSource) Assertions.checkNotNull(list.get(i))) instanceof AdsMediaSource) {
                if (size > 1) {
                    throw new IllegalArgumentException();
                }
                this.hasAdsMediaSource = true;
            }
        }
    }

    private Timeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo, Timeline timeline, Pair<Object, Long> pair) {
        long adDurationUs;
        Assertions.checkArgument(timeline.isEmpty() || pair != null);
        Timeline timeline2 = playbackInfo.timeline;
        PlaybackInfo playbackInfoCopyWithTimeline = playbackInfo.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId = playbackInfoCopyWithTimeline.copyWithNewPosition(dummyPeriodForEmptyTimeline, C.msToUs(this.maskingWindowPositionMs), C.msToUs(this.maskingWindowPositionMs), 0L, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult).copyWithLoadingMediaPeriodId(dummyPeriodForEmptyTimeline);
            playbackInfoCopyWithLoadingMediaPeriodId.bufferedPositionUs = playbackInfoCopyWithLoadingMediaPeriodId.positionUs;
            return playbackInfoCopyWithLoadingMediaPeriodId;
        }
        Object obj = playbackInfoCopyWithTimeline.periodId.periodUid;
        boolean z = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z ? new MediaSource.MediaPeriodId(pair.first) : playbackInfoCopyWithTimeline.periodId;
        long jLongValue = ((Long) pair.second).longValue();
        long jMsToUs = C.msToUs(getContentPosition());
        if (!timeline2.isEmpty()) {
            jMsToUs -= timeline2.getPeriodByUid(obj, this.period).getPositionInWindowUs();
        }
        if (z || jLongValue < jMsToUs) {
            Assertions.checkState(!mediaPeriodId.isAd());
            PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId2 = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaPeriodId, jLongValue, jLongValue, 0L, z ? TrackGroupArray.EMPTY : playbackInfoCopyWithTimeline.trackGroups, z ? this.emptyTrackSelectorResult : playbackInfoCopyWithTimeline.trackSelectorResult).copyWithLoadingMediaPeriodId(mediaPeriodId);
            playbackInfoCopyWithLoadingMediaPeriodId2.bufferedPositionUs = jLongValue;
            return playbackInfoCopyWithLoadingMediaPeriodId2;
        }
        if (jLongValue == jMsToUs) {
            int indexOfPeriod = timeline.getIndexOfPeriod(playbackInfoCopyWithTimeline.loadingMediaPeriodId.periodUid);
            if (indexOfPeriod != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex) {
                return playbackInfoCopyWithTimeline;
            }
            timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
            if (mediaPeriodId.isAd()) {
                adDurationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
            } else {
                adDurationUs = this.period.durationUs;
            }
            PlaybackInfo playbackInfoCopyWithLoadingMediaPeriodId3 = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaPeriodId, playbackInfoCopyWithTimeline.positionUs, playbackInfoCopyWithTimeline.positionUs, adDurationUs - playbackInfoCopyWithTimeline.positionUs, playbackInfoCopyWithTimeline.trackGroups, playbackInfoCopyWithTimeline.trackSelectorResult).copyWithLoadingMediaPeriodId(mediaPeriodId);
            playbackInfoCopyWithLoadingMediaPeriodId3.bufferedPositionUs = adDurationUs;
            return playbackInfoCopyWithLoadingMediaPeriodId3;
        }
        Assertions.checkState(!mediaPeriodId.isAd());
        long jMax = Math.max(0L, playbackInfoCopyWithTimeline.totalBufferedDurationUs - (jLongValue - jMsToUs));
        long j = playbackInfoCopyWithTimeline.bufferedPositionUs;
        if (playbackInfoCopyWithTimeline.loadingMediaPeriodId.equals(playbackInfoCopyWithTimeline.periodId)) {
            j = jLongValue + jMax;
        }
        PlaybackInfo playbackInfoCopyWithNewPosition = playbackInfoCopyWithTimeline.copyWithNewPosition(mediaPeriodId, jLongValue, jLongValue, jMax, playbackInfoCopyWithTimeline.trackGroups, playbackInfoCopyWithTimeline.trackSelectorResult);
        playbackInfoCopyWithNewPosition.bufferedPositionUs = j;
        return playbackInfoCopyWithNewPosition;
    }

    private Pair<Object, Long> getPeriodPositionAfterTimelineChanged(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z = !timeline.isEmpty() && timeline2.isEmpty();
            int currentWindowIndexInternal = z ? -1 : getCurrentWindowIndexInternal();
            if (z) {
                contentPosition = -9223372036854775807L;
            }
            return getPeriodPositionOrMaskWindowPosition(timeline2, currentWindowIndexInternal, contentPosition);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, getCurrentWindowIndex(), C.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPosition)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPosition;
        }
        Object objResolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
        if (objResolveSubsequentPeriod != null) {
            timeline2.getPeriodByUid(objResolveSubsequentPeriod, this.period);
            int i = this.period.windowIndex;
            return getPeriodPositionOrMaskWindowPosition(timeline2, i, timeline2.getWindow(i, this.window).getDefaultPositionMs());
        }
        return getPeriodPositionOrMaskWindowPosition(timeline2, -1, -9223372036854775807L);
    }

    private Pair<Object, Long> getPeriodPositionOrMaskWindowPosition(Timeline timeline, int i, long j) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.maskingWindowPositionMs = j;
            this.maskingPeriodIndex = 0;
            return null;
        }
        if (i == -1 || i >= timeline.getWindowCount()) {
            i = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j = timeline.getWindow(i, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPosition(this.window, this.period, i, C.msToUs(j));
    }

    private void notifyListeners(final BasePlayer.ListenerInvocation listenerInvocation) {
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.listeners);
        notifyListeners(new Runnable() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ExoPlayerImpl.invokeAll(copyOnWriteArrayList, listenerInvocation);
            }
        });
    }

    private void notifyListeners(Runnable runnable) {
        boolean z = !this.pendingListenerNotifications.isEmpty();
        this.pendingListenerNotifications.addLast(runnable);
        if (z) {
            return;
        }
        while (!this.pendingListenerNotifications.isEmpty()) {
            this.pendingListenerNotifications.peekFirst().run();
            this.pendingListenerNotifications.removeFirst();
        }
    }

    private long periodPositionUsToWindowPositionMs(MediaSource.MediaPeriodId mediaPeriodId, long j) {
        long jUsToMs = C.usToMs(j);
        this.playbackInfo.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return jUsToMs + this.period.getPositionInWindowMs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class PlaybackInfoUpdate implements Runnable {
        private final boolean isLoadingChanged;
        private final boolean isPlayingChanged;
        private final CopyOnWriteArrayList<BasePlayer.ListenerHolder> listenerSnapshot;
        private final MediaItem mediaItem;
        private final int mediaItemTransitionReason;
        private final boolean mediaItemTransitioned;
        private final boolean offloadSchedulingEnabledChanged;
        private final int playWhenReadyChangeReason;
        private final boolean playWhenReadyChanged;
        private final boolean playbackErrorChanged;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackParametersChanged;
        private final boolean playbackStateChanged;
        private final boolean playbackSuppressionReasonChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, TrackSelector trackSelector, boolean z, int i, int i2, boolean z2, int i3, MediaItem mediaItem, int i4, boolean z3) {
            this.playbackInfo = playbackInfo;
            this.listenerSnapshot = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.trackSelector = trackSelector;
            this.positionDiscontinuity = z;
            this.positionDiscontinuityReason = i;
            this.timelineChangeReason = i2;
            this.mediaItemTransitioned = z2;
            this.mediaItemTransitionReason = i3;
            this.mediaItem = mediaItem;
            this.playWhenReadyChangeReason = i4;
            this.seekProcessed = z3;
            this.playbackStateChanged = playbackInfo2.playbackState != playbackInfo.playbackState;
            ExoPlaybackException exoPlaybackException = playbackInfo2.playbackError;
            ExoPlaybackException exoPlaybackException2 = playbackInfo.playbackError;
            this.playbackErrorChanged = (exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null) ? false : true;
            this.isLoadingChanged = playbackInfo2.isLoading != playbackInfo.isLoading;
            this.timelineChanged = !playbackInfo2.timeline.equals(playbackInfo.timeline);
            this.trackSelectorResultChanged = playbackInfo2.trackSelectorResult != playbackInfo.trackSelectorResult;
            this.playWhenReadyChanged = playbackInfo2.playWhenReady != playbackInfo.playWhenReady;
            this.playbackSuppressionReasonChanged = playbackInfo2.playbackSuppressionReason != playbackInfo.playbackSuppressionReason;
            this.isPlayingChanged = isPlaying(playbackInfo2) != isPlaying(playbackInfo);
            this.playbackParametersChanged = !playbackInfo2.playbackParameters.equals(playbackInfo.playbackParameters);
            this.offloadSchedulingEnabledChanged = playbackInfo2.offloadSchedulingEnabled != playbackInfo.offloadSchedulingEnabled;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.timelineChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda1
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$0(eventListener);
                    }
                });
            }
            if (this.positionDiscontinuity) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda3
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$1(eventListener);
                    }
                });
            }
            if (this.mediaItemTransitioned) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda0
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$2(eventListener);
                    }
                });
            }
            if (this.playbackErrorChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda7
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$3(eventListener);
                    }
                });
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda2
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$4(eventListener);
                    }
                });
            }
            if (this.isLoadingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda12
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$5(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged || this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda10
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$6(eventListener);
                    }
                });
            }
            if (this.playbackStateChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda5
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$7(eventListener);
                    }
                });
            }
            if (this.playWhenReadyChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda4
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$8(eventListener);
                    }
                });
            }
            if (this.playbackSuppressionReasonChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda9
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$9(eventListener);
                    }
                });
            }
            if (this.isPlayingChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda6
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$10(eventListener);
                    }
                });
            }
            if (this.playbackParametersChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda11
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$11(eventListener);
                    }
                });
            }
            if (this.seekProcessed) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda13
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        eventListener.onSeekProcessed();
                    }
                });
            }
            if (this.offloadSchedulingEnabledChanged) {
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, new BasePlayer.ListenerInvocation() { // from class: com.google.android.exoplayer2.ExoPlayerImpl$PlaybackInfoUpdate$$ExternalSyntheticLambda8
                    @Override // com.google.android.exoplayer2.BasePlayer.ListenerInvocation
                    public final void invokeListener(Player.EventListener eventListener) {
                        this.f$0.lambda$run$12(eventListener);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Player.EventListener eventListener) {
            eventListener.onTimelineChanged(this.playbackInfo.timeline, this.timelineChangeReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(Player.EventListener eventListener) {
            eventListener.onPositionDiscontinuity(this.positionDiscontinuityReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2(Player.EventListener eventListener) {
            eventListener.onMediaItemTransition(this.mediaItem, this.mediaItemTransitionReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$3(Player.EventListener eventListener) {
            eventListener.onPlayerError(this.playbackInfo.playbackError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$4(Player.EventListener eventListener) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            eventListener.onTracksChanged(playbackInfo.trackGroups, playbackInfo.trackSelectorResult.selections);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$5(Player.EventListener eventListener) {
            eventListener.onIsLoadingChanged(this.playbackInfo.isLoading);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$6(Player.EventListener eventListener) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            eventListener.onPlayerStateChanged(playbackInfo.playWhenReady, playbackInfo.playbackState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$7(Player.EventListener eventListener) {
            eventListener.onPlaybackStateChanged(this.playbackInfo.playbackState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$8(Player.EventListener eventListener) {
            eventListener.onPlayWhenReadyChanged(this.playbackInfo.playWhenReady, this.playWhenReadyChangeReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$9(Player.EventListener eventListener) {
            eventListener.onPlaybackSuppressionReasonChanged(this.playbackInfo.playbackSuppressionReason);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$10(Player.EventListener eventListener) {
            eventListener.onIsPlayingChanged(isPlaying(this.playbackInfo));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$11(Player.EventListener eventListener) {
            eventListener.onPlaybackParametersChanged(this.playbackInfo.playbackParameters);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$12(Player.EventListener eventListener) {
            eventListener.onExperimentalOffloadSchedulingEnabledChanged(this.playbackInfo.offloadSchedulingEnabled);
        }

        private static boolean isPlaying(PlaybackInfo playbackInfo) {
            return playbackInfo.playbackState == 3 && playbackInfo.playWhenReady && playbackInfo.playbackSuppressionReason == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void invokeAll(CopyOnWriteArrayList<BasePlayer.ListenerHolder> copyOnWriteArrayList, BasePlayer.ListenerInvocation listenerInvocation) {
        Iterator<BasePlayer.ListenerHolder> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next().invoke(listenerInvocation);
        }
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        private Timeline timeline;
        private final Object uid;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline) {
            this.uid = obj;
            this.timeline = timeline;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Object getUid() {
            return this.uid;
        }

        @Override // com.google.android.exoplayer2.MediaSourceInfoHolder
        public Timeline getTimeline() {
            return this.timeline;
        }
    }
}
