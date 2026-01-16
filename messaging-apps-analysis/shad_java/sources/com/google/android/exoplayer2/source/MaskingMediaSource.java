package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    private boolean hasRealTimeline;
    private boolean hasStartedPreparing;
    private boolean isPrepared;
    private final MediaSource mediaSource;
    private final Timeline.Period period;
    private MaskingTimeline timeline;
    private MaskingMediaPeriod unpreparedMaskingMediaPeriod;
    private final boolean useLazyPreparation;
    private final Timeline.Window window;

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        this.mediaSource = mediaSource;
        this.useLazyPreparation = z && mediaSource.isSingleWindow();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        Timeline initialTimeline = mediaSource.getInitialTimeline();
        if (initialTimeline != null) {
            this.timeline = MaskingTimeline.createWithRealTimeline(initialTimeline, null, null);
            this.hasRealTimeline = true;
        } else {
            this.timeline = MaskingTimeline.createWithPlaceholderTimeline(mediaSource.getMediaItem());
        }
    }

    public Timeline getTimeline() {
        return this.timeline;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        if (this.useLazyPreparation) {
            return;
        }
        this.hasStartedPreparing = true;
        prepareChildSource(null, this.mediaSource);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MaskingMediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(this.mediaSource, mediaPeriodId, allocator, j);
        if (this.isPrepared) {
            maskingMediaPeriod.createPeriod(mediaPeriodId.copyWithPeriodUid(getInternalPeriodUid(mediaPeriodId.periodUid)));
        } else {
            this.unpreparedMaskingMediaPeriod = maskingMediaPeriod;
            if (!this.hasStartedPreparing) {
                this.hasStartedPreparing = true;
                prepareChildSource(null, this.mediaSource);
            }
        }
        return maskingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).releasePeriod();
        if (mediaPeriod == this.unpreparedMaskingMediaPeriod) {
            this.unpreparedMaskingMediaPeriod = null;
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.isPrepared = false;
        this.hasStartedPreparing = false;
        super.releaseSourceInternal();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void lambda$prepareChildSource$0(java.lang.Void r12, com.google.android.exoplayer2.source.MediaSource r13, com.google.android.exoplayer2.Timeline r14) {
        /*
            r11 = this;
            boolean r12 = r11.isPrepared
            if (r12 == 0) goto L19
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            r11.timeline = r12
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.unpreparedMaskingMediaPeriod
            if (r12 == 0) goto L8d
            long r12 = r12.getPreparePositionOverrideUs()
            r11.setPreparePositionOverrideToUnpreparedMaskingPeriod(r12)
            goto L8d
        L19:
            boolean r12 = r14.isEmpty()
            if (r12 == 0) goto L35
            boolean r12 = r11.hasRealTimeline
            if (r12 == 0) goto L2a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            goto L32
        L2a:
            java.lang.Object r12 = com.google.android.exoplayer2.Timeline.Window.SINGLE_WINDOW_UID
            java.lang.Object r13 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r14, r12, r13)
        L32:
            r11.timeline = r12
            goto L8d
        L35:
            r12 = 0
            com.google.android.exoplayer2.Timeline$Window r13 = r11.window
            r14.getWindow(r12, r13)
            com.google.android.exoplayer2.Timeline$Window r12 = r11.window
            long r12 = r12.getDefaultPositionUs()
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r11.unpreparedMaskingMediaPeriod
            if (r0 == 0) goto L51
            long r0 = r0.getPreparePositionUs()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L51
            r9 = r0
            goto L52
        L51:
            r9 = r12
        L52:
            com.google.android.exoplayer2.Timeline$Window r6 = r11.window
            java.lang.Object r12 = r6.uid
            com.google.android.exoplayer2.Timeline$Period r7 = r11.period
            r8 = 0
            r5 = r14
            android.util.Pair r13 = r5.getPeriodPosition(r6, r7, r8, r9)
            java.lang.Object r0 = r13.first
            java.lang.Object r13 = r13.second
            java.lang.Long r13 = (java.lang.Long) r13
            long r1 = r13.longValue()
            boolean r13 = r11.hasRealTimeline
            if (r13 == 0) goto L73
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r11.timeline
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = r12.cloneWithUpdatedTimeline(r14)
            goto L77
        L73:
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r12 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.createWithRealTimeline(r14, r12, r0)
        L77:
            r11.timeline = r12
            com.google.android.exoplayer2.source.MaskingMediaPeriod r12 = r11.unpreparedMaskingMediaPeriod
            if (r12 == 0) goto L8d
            r11.setPreparePositionOverrideToUnpreparedMaskingPeriod(r1)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r12.id
            java.lang.Object r13 = r12.periodUid
            java.lang.Object r13 = r11.getInternalPeriodUid(r13)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r12.copyWithPeriodUid(r13)
            goto L8e
        L8d:
            r12 = 0
        L8e:
            r13 = 1
            r11.hasRealTimeline = r13
            r11.isPrepared = r13
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r13 = r11.timeline
            r11.refreshSourceInfo(r13)
            if (r12 == 0) goto La5
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = r11.unpreparedMaskingMediaPeriod
            java.lang.Object r13 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r13)
            com.google.android.exoplayer2.source.MaskingMediaPeriod r13 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r13
            r13.createPeriod(r12)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.lambda$prepareChildSource$0(java.lang.Void, com.google.android.exoplayer2.source.MediaSource, com.google.android.exoplayer2.Timeline):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r1, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.copyWithPeriodUid(getExternalPeriodUid(mediaPeriodId.periodUid));
    }

    private Object getInternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !obj.equals(MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID)) ? obj : this.timeline.replacedInternalPeriodUid;
    }

    private Object getExternalPeriodUid(Object obj) {
        return (this.timeline.replacedInternalPeriodUid == null || !this.timeline.replacedInternalPeriodUid.equals(obj)) ? obj : MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private void setPreparePositionOverrideToUnpreparedMaskingPeriod(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.unpreparedMaskingMediaPeriod;
        int indexOfPeriod = this.timeline.getIndexOfPeriod(maskingMediaPeriod.id.periodUid);
        if (indexOfPeriod == -1) {
            return;
        }
        long j2 = this.timeline.getPeriod(indexOfPeriod, this.period).durationUs;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.overridePreparePositionUs(j);
    }

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object MASKING_EXTERNAL_PERIOD_UID = new Object();
        private final Object replacedInternalPeriodUid;
        private final Object replacedInternalWindowUid;

        public static MaskingTimeline createWithPlaceholderTimeline(MediaItem mediaItem) {
            return new MaskingTimeline(new PlaceholderTimeline(mediaItem), Timeline.Window.SINGLE_WINDOW_UID, MASKING_EXTERNAL_PERIOD_UID);
        }

        public static MaskingTimeline createWithRealTimeline(Timeline timeline, Object obj, Object obj2) {
            return new MaskingTimeline(timeline, obj, obj2);
        }

        private MaskingTimeline(Timeline timeline, Object obj, Object obj2) {
            super(timeline);
            this.replacedInternalWindowUid = obj;
            this.replacedInternalPeriodUid = obj2;
        }

        public MaskingTimeline cloneWithUpdatedTimeline(Timeline timeline) {
            return new MaskingTimeline(timeline, this.replacedInternalWindowUid, this.replacedInternalPeriodUid);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            this.timeline.getWindow(i, window, j);
            if (Util.areEqual(window.uid, this.replacedInternalWindowUid)) {
                window.uid = Timeline.Window.SINGLE_WINDOW_UID;
            }
            return window;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            this.timeline.getPeriod(i, period, z);
            if (Util.areEqual(period.uid, this.replacedInternalPeriodUid) && z) {
                period.uid = MASKING_EXTERNAL_PERIOD_UID;
            }
            return period;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            Object obj2;
            Timeline timeline = this.timeline;
            if (MASKING_EXTERNAL_PERIOD_UID.equals(obj) && (obj2 = this.replacedInternalPeriodUid) != null) {
                obj = obj2;
            }
            return timeline.getIndexOfPeriod(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            Object uidOfPeriod = this.timeline.getUidOfPeriod(i);
            return Util.areEqual(uidOfPeriod, this.replacedInternalPeriodUid) ? MASKING_EXTERNAL_PERIOD_UID : uidOfPeriod;
        }
    }

    public static final class PlaceholderTimeline extends Timeline {
        private final MediaItem mediaItem;

        @Override // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return 1;
        }

        public PlaceholderTimeline(MediaItem mediaItem) {
            this.mediaItem = mediaItem;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Window getWindow(int i, Timeline.Window window, long j) {
            window.set(Timeline.Window.SINGLE_WINDOW_UID, this.mediaItem, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, false, 0L, -9223372036854775807L, 0, 0, 0L);
            window.isPlaceholder = true;
            return window;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
            return period.set(z ? 0 : null, z ? MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID : null, 0, -9223372036854775807L, 0L);
        }

        @Override // com.google.android.exoplayer2.Timeline
        public int getIndexOfPeriod(Object obj) {
            return obj == MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.Timeline
        public Object getUidOfPeriod(int i) {
            return MaskingTimeline.MASKING_EXTERNAL_PERIOD_UID;
        }
    }
}
