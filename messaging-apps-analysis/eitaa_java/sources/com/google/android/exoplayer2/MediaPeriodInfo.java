package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;

/* loaded from: classes.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource.MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    MediaPeriodInfo(MediaSource.MediaPeriodId id, long startPositionUs, long contentPositionUs, long endPositionUs, long durationUs, boolean isLastInTimelinePeriod, boolean isFinal) {
        this.id = id;
        this.startPositionUs = startPositionUs;
        this.contentPositionUs = contentPositionUs;
        this.endPositionUs = endPositionUs;
        this.durationUs = durationUs;
        this.isLastInTimelinePeriod = isLastInTimelinePeriod;
        this.isFinal = isFinal;
    }

    public MediaPeriodInfo copyWithStartPositionUs(long startPositionUs) {
        return startPositionUs == this.startPositionUs ? this : new MediaPeriodInfo(this.id, startPositionUs, this.contentPositionUs, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public MediaPeriodInfo copyWithContentPositionUs(long contentPositionUs) {
        return contentPositionUs == this.contentPositionUs ? this : new MediaPeriodInfo(this.id, this.startPositionUs, contentPositionUs, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || MediaPeriodInfo.class != o.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) o;
        return this.startPositionUs == mediaPeriodInfo.startPositionUs && this.contentPositionUs == mediaPeriodInfo.contentPositionUs && this.endPositionUs == mediaPeriodInfo.endPositionUs && this.durationUs == mediaPeriodInfo.durationUs && this.isLastInTimelinePeriod == mediaPeriodInfo.isLastInTimelinePeriod && this.isFinal == mediaPeriodInfo.isFinal && Util.areEqual(this.id, mediaPeriodInfo.id);
    }

    public int hashCode() {
        return ((((((((((((527 + this.id.hashCode()) * 31) + ((int) this.startPositionUs)) * 31) + ((int) this.contentPositionUs)) * 31) + ((int) this.endPositionUs)) * 31) + ((int) this.durationUs)) * 31) + (this.isLastInTimelinePeriod ? 1 : 0)) * 31) + (this.isFinal ? 1 : 0);
    }
}
