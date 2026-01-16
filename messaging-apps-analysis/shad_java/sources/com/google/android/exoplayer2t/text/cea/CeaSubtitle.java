package com.google.android.exoplayer2t.text.cea;

import com.google.android.exoplayer2t.text.Cue;
import com.google.android.exoplayer2t.text.Subtitle;
import com.google.android.exoplayer2t.util.Assertions;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class CeaSubtitle implements Subtitle {
    private final List<Cue> cues;

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public int getEventTimeCount() {
        return 1;
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        return j < 0 ? 0 : -1;
    }

    public CeaSubtitle(List<Cue> list) {
        this.cues = list;
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i == 0);
        return 0L;
    }

    @Override // com.google.android.exoplayer2t.text.Subtitle
    public List<Cue> getCues(long j) {
        return j >= 0 ? this.cues : Collections.emptyList();
    }
}
