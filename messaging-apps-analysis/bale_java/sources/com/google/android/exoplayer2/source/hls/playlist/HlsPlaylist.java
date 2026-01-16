package com.google.android.exoplayer2.source.hls.playlist;

import ir.nasim.InterfaceC18525oo2;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class HlsPlaylist implements InterfaceC18525oo2 {
    public final String a;
    public final List b;
    public final boolean c;

    protected HlsPlaylist(String str, List list, boolean z) {
        this.a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = z;
    }
}
