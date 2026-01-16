package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.story.ClockSticker;

/* loaded from: classes3.dex */
public class RubinoClockObject {
    public long date;
    public ClockSticker.ClockMode mode;
    public int sizeInDp;

    public RubinoClockObject(ClockSticker.ClockMode clockMode, long j, int i) {
        this.mode = clockMode;
        this.date = j;
        this.sizeInDp = i;
    }
}
