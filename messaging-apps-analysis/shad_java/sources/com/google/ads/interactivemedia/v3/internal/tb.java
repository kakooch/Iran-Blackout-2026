package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class tb implements vd {
    protected final vd[] a;

    public tb(vd[] vdVarArr) {
        this.a = vdVarArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final void f(long j) {
        for (vd vdVar : this.a) {
            vdVar.f(j);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long h() {
        long jMin = Long.MAX_VALUE;
        for (vd vdVar : this.a) {
            long jH = vdVar.h();
            if (jH != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jH);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final long l() {
        long jMin = Long.MAX_VALUE;
        for (vd vdVar : this.a) {
            long jL = vdVar.l();
            if (jL != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jL);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean n(long j) {
        boolean zN;
        boolean z = false;
        do {
            long jL = l();
            if (jL == Long.MIN_VALUE) {
                break;
            }
            zN = false;
            for (vd vdVar : this.a) {
                long jL2 = vdVar.l();
                boolean z2 = jL2 != Long.MIN_VALUE && jL2 <= j;
                if (jL2 == jL || z2) {
                    zN |= vdVar.n(j);
                }
            }
            z |= zN;
        } while (zN);
        return true == z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.vd
    public final boolean o() {
        for (vd vdVar : this.a) {
            if (vdVar.o()) {
                return true;
            }
        }
        return false;
    }
}
