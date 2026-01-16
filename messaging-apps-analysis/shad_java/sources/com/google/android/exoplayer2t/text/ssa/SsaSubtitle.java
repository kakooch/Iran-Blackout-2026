package com.google.android.exoplayer2t.text.ssa;

import com.google.android.exoplayer2t.text.Cue;
import com.google.android.exoplayer2t.text.Subtitle;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.Util;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class SsaSubtitle implements Subtitle {
    private final List<Long> cueTimesUs;
    private final List<List<Cue>> cues;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.cues = list;
        this.cueTimesUs = list2;
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iBinarySearchCeil = Util.binarySearchCeil((List<? extends Comparable<? super Long>>) this.cueTimesUs, Long.valueOf(j), false, false);
        if (iBinarySearchCeil < this.cueTimesUs.size()) {
            return iBinarySearchCeil;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public int getEventTimeCount() {
        return this.cueTimesUs.size();
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i >= 0);
        Assertions.checkArgument(i < this.cueTimesUs.size());
        return this.cueTimesUs.get(i).longValue();
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public List<Cue> getCues(long j) {
        int iBinarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) this.cueTimesUs, Long.valueOf(j), true, false);
        if (iBinarySearchFloor == -1) {
            return Collections.emptyList();
        }
        return this.cues.get(iBinarySearchFloor);
    }
}
