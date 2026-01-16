package com.google.android.exoplayer2t.text;

import java.util.List;

/* loaded from: classes.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
