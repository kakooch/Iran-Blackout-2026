package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class yn extends aak {
    private int d;

    public yn(vh vhVar, int[] iArr) {
        super(vhVar, iArr);
        this.d = o(vhVar.a(iArr[0]));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int a() {
        return this.d;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int b() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final Object c() {
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final void d(long j, long j2, List<? extends wc> list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (t(this.d, jElapsedRealtime)) {
            int i = this.b;
            do {
                i--;
                if (i < 0) {
                    throw new IllegalStateException();
                }
            } while (t(i, jElapsedRealtime));
            this.d = i;
        }
    }
}
