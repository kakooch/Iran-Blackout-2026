package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import ir.nasim.C5045Hq7;

/* loaded from: classes2.dex */
public final class TimestampAdjusterProvider {
    private final SparseArray a = new SparseArray();

    public C5045Hq7 a(int i) {
        C5045Hq7 c5045Hq7 = (C5045Hq7) this.a.get(i);
        if (c5045Hq7 != null) {
            return c5045Hq7;
        }
        C5045Hq7 c5045Hq72 = new C5045Hq7(9223372036854775806L);
        this.a.put(i, c5045Hq72);
        return c5045Hq72;
    }

    public void b() {
        this.a.clear();
    }
}
