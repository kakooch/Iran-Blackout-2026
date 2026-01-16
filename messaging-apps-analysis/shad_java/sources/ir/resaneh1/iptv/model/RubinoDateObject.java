package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.story.DateSticker;

/* loaded from: classes3.dex */
public class RubinoDateObject {
    public long date;
    public int sizeInDp;
    public DateSticker.DateTheme theme;

    public RubinoDateObject(DateSticker.DateTheme dateTheme, long j, int i) {
        this.theme = dateTheme;
        this.date = j;
        this.sizeInDp = i;
    }
}
