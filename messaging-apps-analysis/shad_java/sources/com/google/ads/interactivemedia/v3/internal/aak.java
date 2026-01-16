package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class aak implements aba {
    protected final vh a;
    protected final int b;
    protected final int[] c;
    private final cy[] d;
    private final long[] e;
    private int f;

    public aak(vh vhVar, int... iArr) {
        int length = iArr.length;
        int i = 0;
        ary.q(length > 0);
        ary.t(vhVar);
        this.a = vhVar;
        this.b = length;
        this.d = new cy[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = vhVar.a(iArr[i2]);
        }
        Arrays.sort(this.d, aaj.a);
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i >= i3) {
                this.e = new long[i3];
                return;
            } else {
                this.c[i] = vhVar.b(this.d[i]);
                i++;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aak aakVar = (aak) obj;
            if (this.a == aakVar.a && Arrays.equals(this.c, aakVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public void f() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public void g() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public void h(float f) {
    }

    public final int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        int iIdentityHashCode = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        this.f = iIdentityHashCode;
        return iIdentityHashCode;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public int i(long j, List<? extends wc> list) {
        return list.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final vh k() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int l() {
        return this.c.length;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final cy m(int i) {
        return this.d[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int n(int i) {
        return this.c[i];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int o(cy cyVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.d[i] == cyVar) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int p(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final cy q() {
        return this.d[a()];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final int r() {
        return this.c[a()];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final boolean s(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zT = t(i, jElapsedRealtime);
        int i2 = 0;
        while (true) {
            if (i2 < this.b) {
                if (zT) {
                    break;
                }
                zT = (i2 == i || t(i2, jElapsedRealtime)) ? false : true;
                i2++;
            } else if (!zT) {
                return false;
            }
        }
        long[] jArr = this.e;
        jArr[i] = Math.max(jArr[i], aeu.aj(jElapsedRealtime, j));
        return true;
    }

    protected final boolean t(int i, long j) {
        return this.e[i] > j;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aba
    public final boolean u() {
        return false;
    }
}
