package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class eg {
    public static final eg a;
    public static final eg b;
    public final long c;
    public final long d;

    static {
        eg egVar = new eg(0L, 0L);
        a = egVar;
        new eg(Long.MAX_VALUE, Long.MAX_VALUE);
        new eg(Long.MAX_VALUE, 0L);
        new eg(0L, Long.MAX_VALUE);
        b = egVar;
    }

    public eg(long j, long j2) {
        ary.o(j >= 0);
        ary.o(j2 >= 0);
        this.c = j;
        this.d = j2;
    }

    public final long a(long j, long j2, long j3) {
        long j4 = this.c;
        if (j4 == 0 && this.d == 0) {
            return j;
        }
        long jAt = aeu.at(j, j4);
        long jAj = aeu.aj(j, this.d);
        boolean z = jAt <= j2 && j2 <= jAj;
        boolean z2 = jAt <= j3 && j3 <= jAj;
        return (z && z2) ? Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3 : z ? j2 : z2 ? j3 : jAt;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && eg.class == obj.getClass()) {
            eg egVar = (eg) obj;
            if (this.c == egVar.c && this.d == egVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.c) * 31) + ((int) this.d);
    }
}
