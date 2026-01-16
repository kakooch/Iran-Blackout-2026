package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
final class MediaPeriodQueue {
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Period period = new Timeline.Period();
    private final Timeline.Window window = new Timeline.Window();
    private Timeline timeline = Timeline.EMPTY;

    private boolean areDurationsCompatible(long previousDurationUs, long newDurationUs) {
        return previousDurationUs == -9223372036854775807L || previousDurationUs == newDurationUs;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public boolean updateRepeatMode(int repeatMode) {
        this.repeatMode = repeatMode;
        return updateForPlaybackModeChange();
    }

    public boolean updateShuffleModeEnabled(boolean shuffleModeEnabled) {
        this.shuffleModeEnabled = shuffleModeEnabled;
        return updateForPlaybackModeChange();
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long rendererPositionUs) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(rendererPositionUs);
        }
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered() && this.loading.info.durationUs != -9223372036854775807L && this.length < 100);
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long rendererPositionUs, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(mediaPeriodHolder, rendererPositionUs);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.MediaPeriodHolder enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[] r12, com.google.android.exoplayer2.trackselection.TrackSelector r13, com.google.android.exoplayer2.upstream.Allocator r14, com.google.android.exoplayer2.source.MediaSource r15, com.google.android.exoplayer2.MediaPeriodInfo r16, com.google.android.exoplayer2.trackselection.TrackSelectorResult r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 != 0) goto L1e
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.id
            boolean r1 = r1.isAd()
            if (r1 == 0) goto L1b
            long r1 = r8.contentPositionUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L1b
            goto L2c
        L1b:
            r1 = 0
            goto L2c
        L1e:
            long r1 = r1.getRendererOffset()
            com.google.android.exoplayer2.MediaPeriodHolder r3 = r0.loading
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r3.info
            long r3 = r3.durationUs
            long r1 = r1 + r3
            long r3 = r8.startPositionUs
            long r1 = r1 - r3
        L2c:
            r3 = r1
            com.google.android.exoplayer2.MediaPeriodHolder r10 = new com.google.android.exoplayer2.MediaPeriodHolder
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 == 0) goto L43
            r1.setNext(r10)
            goto L47
        L43:
            r0.playing = r10
            r0.reading = r10
        L47:
            r1 = 0
            r0.oldFrontPeriodUid = r1
            r0.loading = r10
            int r1 = r0.length
            int r1 = r1 + 1
            r0.length = r1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[], com.google.android.exoplayer2.trackselection.TrackSelector, com.google.android.exoplayer2.upstream.Allocator, com.google.android.exoplayer2.source.MediaSource, com.google.android.exoplayer2.MediaPeriodInfo, com.google.android.exoplayer2.trackselection.TrackSelectorResult):com.google.android.exoplayer2.MediaPeriodHolder");
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) ? false : true);
        MediaPeriodHolder next = this.reading.getNext();
        this.reading = next;
        return next;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        int i = this.length - 1;
        this.length = i;
        if (i == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.id.windowSequenceNumber;
        }
        MediaPeriodHolder next = this.playing.getNext();
        this.playing = next;
        return next;
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z = false;
        Assertions.checkState(mediaPeriodHolder != null);
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext(null);
        return z;
    }

    public void clear(boolean keepFrontPeriodUid) {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder != null) {
            this.oldFrontPeriodUid = keepFrontPeriodUid ? mediaPeriodHolder.uid : null;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.id.windowSequenceNumber;
            removeAfter(mediaPeriodHolder);
            mediaPeriodHolder.release();
        } else if (!keepFrontPeriodUid) {
            this.oldFrontPeriodUid = null;
        }
        this.playing = null;
        this.loading = null;
        this.reading = null;
        this.length = 0;
    }

    public boolean updateQueuedPeriods(long rendererPositionUs, long maxRendererReadPositionUs) {
        MediaPeriodInfo updatedMediaPeriodInfo;
        MediaPeriodHolder next = this.playing;
        MediaPeriodHolder mediaPeriodHolder = null;
        while (next != null) {
            MediaPeriodInfo mediaPeriodInfo = next.info;
            if (mediaPeriodHolder == null) {
                updatedMediaPeriodInfo = getUpdatedMediaPeriodInfo(mediaPeriodInfo);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(mediaPeriodHolder, rendererPositionUs);
                if (followingMediaPeriodInfo == null) {
                    return !removeAfter(mediaPeriodHolder);
                }
                if (!canKeepMediaPeriodHolder(mediaPeriodInfo, followingMediaPeriodInfo)) {
                    return !removeAfter(mediaPeriodHolder);
                }
                updatedMediaPeriodInfo = followingMediaPeriodInfo;
            }
            next.info = updatedMediaPeriodInfo.copyWithContentPositionUs(mediaPeriodInfo.contentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo.durationUs, updatedMediaPeriodInfo.durationUs)) {
                long j = updatedMediaPeriodInfo.durationUs;
                return (removeAfter(next) || (next == this.reading && ((maxRendererReadPositionUs > Long.MIN_VALUE ? 1 : (maxRendererReadPositionUs == Long.MIN_VALUE ? 0 : -1)) == 0 || (maxRendererReadPositionUs > ((j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(j)) ? 1 : (maxRendererReadPositionUs == ((j > (-9223372036854775807L) ? 1 : (j == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : next.toRendererTime(j)) ? 0 : -1)) >= 0))) ? false : true;
            }
            mediaPeriodHolder = next;
            next = next.getNext();
        }
        return true;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(MediaPeriodInfo info) {
        long durationUs;
        MediaSource.MediaPeriodId mediaPeriodId = info.id;
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(mediaPeriodId, zIsLastInPeriod);
        this.timeline.getPeriodByUid(info.id.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            durationUs = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            durationUs = info.endPositionUs;
            if (durationUs == -9223372036854775807L || durationUs == Long.MIN_VALUE) {
                durationUs = this.period.getDurationUs();
            }
        }
        return new MediaPeriodInfo(mediaPeriodId, info.startPositionUs, info.contentPositionUs, info.endPositionUs, durationUs, zIsLastInPeriod, zIsLastInTimeline);
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Object periodUid, long positionUs) {
        return resolveMediaPeriodIdForAds(periodUid, positionUs, resolvePeriodIndexToWindowSequenceNumber(periodUid));
    }

    private MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Object periodUid, long positionUs, long windowSequenceNumber) {
        this.timeline.getPeriodByUid(periodUid, this.period);
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(positionUs);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(periodUid, windowSequenceNumber, this.period.getAdGroupIndexAfterPositionUs(positionUs));
        }
        return new MediaSource.MediaPeriodId(periodUid, adGroupIndexForPositionUs, this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs), windowSequenceNumber);
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Object periodUid) {
        int indexOfPeriod;
        int i = this.timeline.getPeriodByUid(periodUid, this.period).windowIndex;
        Object obj = this.oldFrontPeriodUid;
        if (obj != null && (indexOfPeriod = this.timeline.getIndexOfPeriod(obj)) != -1 && this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder next = this.playing; next != null; next = next.getNext()) {
            if (next.uid.equals(periodUid)) {
                return next.info.id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder next2 = this.playing; next2 != null; next2 = next2.getNext()) {
            int indexOfPeriod2 = this.timeline.getIndexOfPeriod(next2.uid);
            if (indexOfPeriod2 != -1 && this.timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i) {
                return next2.info.id.windowSequenceNumber;
            }
        }
        long j = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j;
        if (this.playing == null) {
            this.oldFrontPeriodUid = periodUid;
            this.oldFrontPeriodWindowSequenceNumber = j;
        }
        return j;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo oldInfo, MediaPeriodInfo newInfo) {
        return oldInfo.startPositionUs == newInfo.startPositionUs && oldInfo.id.equals(newInfo.id);
    }

    private boolean updateForPlaybackModeChange() {
        MediaPeriodHolder next = this.playing;
        if (next == null) {
            return true;
        }
        int indexOfPeriod = this.timeline.getIndexOfPeriod(next.uid);
        while (true) {
            indexOfPeriod = this.timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (next.getNext() != null && !next.info.isLastInTimelinePeriod) {
                next = next.getNext();
            }
            MediaPeriodHolder next2 = next.getNext();
            if (indexOfPeriod == -1 || next2 == null || this.timeline.getIndexOfPeriod(next2.uid) != indexOfPeriod) {
                break;
            }
            next = next2;
        }
        boolean zRemoveAfter = removeAfter(next);
        next.info = getUpdatedMediaPeriodInfo(next.info);
        return !zRemoveAfter;
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.periodId, playbackInfo.contentPositionUs, playbackInfo.startPositionUs);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(MediaPeriodHolder mediaPeriodHolder, long rendererPositionUs) {
        long jLongValue;
        Object obj;
        long j;
        long j2;
        long j3;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - rendererPositionUs;
        long j4 = 0;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            int nextPeriodIndex = this.timeline.getNextPeriodIndex(this.timeline.getIndexOfPeriod(mediaPeriodInfo.id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i = this.timeline.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj2 = this.period.uid;
            long j5 = mediaPeriodInfo.id.windowSequenceNumber;
            if (this.timeline.getWindow(i, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPosition = this.timeline.getPeriodPosition(this.window, this.period, i, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPosition == null) {
                    return null;
                }
                Object obj3 = periodPosition.first;
                long jLongValue2 = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder next = mediaPeriodHolder.getNext();
                if (next != null && next.uid.equals(obj3)) {
                    j3 = next.info.id.windowSequenceNumber;
                } else {
                    j3 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j3;
                }
                j2 = jLongValue2;
                j4 = -9223372036854775807L;
                j = j3;
                obj = obj3;
            } else {
                obj = obj2;
                j = j5;
                j2 = 0;
            }
            return getMediaPeriodInfo(resolveMediaPeriodIdForAds(obj, j2, j), j4, j2);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.id;
        this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            int i2 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i2);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i2, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                if (this.period.isAdAvailable(i2, nextAdIndexToPlay)) {
                    return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, i2, nextAdIndexToPlay, mediaPeriodInfo.contentPositionUs, mediaPeriodId.windowSequenceNumber);
                }
                return null;
            }
            long j6 = mediaPeriodInfo.contentPositionUs;
            if (j6 == -9223372036854775807L) {
                Timeline timeline = this.timeline;
                Timeline.Window window = this.window;
                Timeline.Period period = this.period;
                Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window, period, period.windowIndex, -9223372036854775807L, Math.max(0L, rendererOffset));
                if (periodPosition2 == null) {
                    return null;
                }
                jLongValue = ((Long) periodPosition2.second).longValue();
            } else {
                jLongValue = j6;
            }
            return getMediaPeriodInfoForContent(mediaPeriodId.periodUid, jLongValue, mediaPeriodId.windowSequenceNumber);
        }
        int adGroupIndexForPositionUs = this.period.getAdGroupIndexForPositionUs(mediaPeriodInfo.endPositionUs);
        if (adGroupIndexForPositionUs == -1) {
            return getMediaPeriodInfoForContent(mediaPeriodId.periodUid, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
        }
        int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(adGroupIndexForPositionUs);
        if (this.period.isAdAvailable(adGroupIndexForPositionUs, firstAdIndexToPlay)) {
            return getMediaPeriodInfoForAd(mediaPeriodId.periodUid, adGroupIndexForPositionUs, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
        }
        return null;
    }

    private MediaPeriodInfo getMediaPeriodInfo(MediaSource.MediaPeriodId id, long contentPositionUs, long startPositionUs) {
        this.timeline.getPeriodByUid(id.periodUid, this.period);
        if (id.isAd()) {
            if (this.period.isAdAvailable(id.adGroupIndex, id.adIndexInAdGroup)) {
                return getMediaPeriodInfoForAd(id.periodUid, id.adGroupIndex, id.adIndexInAdGroup, contentPositionUs, id.windowSequenceNumber);
            }
            return null;
        }
        return getMediaPeriodInfoForContent(id.periodUid, startPositionUs, id.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long contentPositionUs, long windowSequenceNumber) {
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(periodUid, adGroupIndex, adIndexInAdGroup, windowSequenceNumber);
        return new MediaPeriodInfo(mediaPeriodId, adIndexInAdGroup == this.period.getFirstAdIndexToPlay(adGroupIndex) ? this.period.getAdResumePositionUs() : 0L, contentPositionUs, -9223372036854775807L, this.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup), false, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Object periodUid, long startPositionUs, long windowSequenceNumber) {
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(startPositionUs);
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(periodUid, windowSequenceNumber, adGroupIndexAfterPositionUs);
        boolean zIsLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean zIsLastInTimeline = isLastInTimeline(mediaPeriodId, zIsLastInPeriod);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        return new MediaPeriodInfo(mediaPeriodId, startPositionUs, -9223372036854775807L, adGroupTimeUs, (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) ? this.period.durationUs : adGroupTimeUs, zIsLastInPeriod, zIsLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId id) {
        return !id.isAd() && id.nextAdGroupIndex == -1;
    }

    private boolean isLastInTimeline(MediaSource.MediaPeriodId id, boolean isLastMediaPeriodInPeriod) {
        int indexOfPeriod = this.timeline.getIndexOfPeriod(id.periodUid);
        return !this.timeline.getWindow(this.timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic && this.timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && isLastMediaPeriodInPeriod;
    }
}
