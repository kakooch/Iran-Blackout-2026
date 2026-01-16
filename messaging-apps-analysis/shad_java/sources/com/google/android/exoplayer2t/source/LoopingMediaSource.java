package com.google.android.exoplayer2t.source;

import com.google.android.exoplayer2t.Timeline;
import com.google.android.exoplayer2t.source.MediaSource;
import com.google.android.exoplayer2t.source.ShuffleOrder;
import com.google.android.exoplayer2t.upstream.Allocator;
import com.google.android.exoplayer2t.upstream.TransferListener;
import com.google.android.exoplayer2t.util.Assertions;
import java.util.HashMap;
import java.util.Map;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public final class LoopingMediaSource extends CompositeMediaSource<Void> {
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final MediaSource childSource;
    private final int loopCount;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, ConnectionsManager.DEFAULT_DATACENTER_ID);
    }

    public LoopingMediaSource(MediaSource mediaSource, int i) {
        Assertions.checkArgument(i > 0);
        this.childSource = mediaSource;
        this.loopCount = i;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }

    @Override // com.google.android.exoplayer2t.source.CompositeMediaSource, com.google.android.exoplayer2t.source.BaseMediaSource
    protected void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.childSource);
    }

    @Override // com.google.android.exoplayer2t.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.childSource.createPeriod(mediaPeriodId, allocator, j);
        }
        MediaSource.MediaPeriodId mediaPeriodIdCopyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(mediaPeriodIdCopyWithPeriodUid, mediaPeriodId);
        MediaPeriod mediaPeriodCreatePeriod = this.childSource.createPeriod(mediaPeriodIdCopyWithPeriodUid, allocator, j);
        this.mediaPeriodToChildMediaPeriodId.put(mediaPeriodCreatePeriod, mediaPeriodIdCopyWithPeriodUid);
        return mediaPeriodCreatePeriod;
    }

    @Override // com.google.android.exoplayer2t.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.childSource.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId mediaPeriodIdRemove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (mediaPeriodIdRemove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(mediaPeriodIdRemove);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2t.source.CompositeMediaSource
    /* renamed from: onChildSourceInfoRefreshed, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void lambda$prepareChildSource$0(Void r1, MediaSource mediaSource, Timeline timeline) {
        Timeline infinitelyLoopingTimeline;
        if (this.loopCount != Integer.MAX_VALUE) {
            infinitelyLoopingTimeline = new LoopingTimeline(timeline, this.loopCount);
        } else {
            infinitelyLoopingTimeline = new InfinitelyLoopingTimeline(timeline);
        }
        refreshSourceInfo(infinitelyLoopingTimeline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2t.source.CompositeMediaSource
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void r2, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.loopCount != Integer.MAX_VALUE ? this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId) : mediaPeriodId;
    }

    private static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        public LoopingTimeline(Timeline timeline, int i) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i));
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i;
            if (periodCount > 0) {
                Assertions.checkState(i <= ConnectionsManager.DEFAULT_DATACENTER_ID / periodCount, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.google.android.exoplayer2t.Timeline
        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2t.Timeline
        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected int getChildIndexByPeriodIndex(int i) {
            return i / this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected int getChildIndexByWindowIndex(int i) {
            return i / this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected int getChildIndexByChildUid(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected Timeline getTimelineByChildIndex(int i) {
            return this.childTimeline;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected int getFirstPeriodIndexByChildIndex(int i) {
            return i * this.childPeriodCount;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected int getFirstWindowIndexByChildIndex(int i) {
            return i * this.childWindowCount;
        }

        @Override // com.google.android.exoplayer2t.source.AbstractConcatenatedTimeline
        protected Object getChildUidByChildIndex(int i) {
            return Integer.valueOf(i);
        }
    }

    private static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        @Override // com.google.android.exoplayer2t.Timeline
        public int getNextWindowIndex(int i, int i2, boolean z) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i, i2, z);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z) : nextWindowIndex;
        }
    }
}
