package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC20933sq8;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2156y0 extends AbstractC2154x0 {
    protected final byte[] e;

    C2156y0(byte[] bArr) {
        bArr.getClass();
        this.e = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.A0
    public final A0 C(int i, int i2) {
        int iL = A0.L(0, i2, r());
        return iL == 0 ? A0.b : new C2152w0(this.e, 0, iL);
    }

    @Override // com.google.android.gms.internal.measurement.A0
    protected final String D(Charset charset) {
        return new String(this.e, 0, r(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.A0
    final void E(AbstractC20933sq8 abstractC20933sq8) {
        ((D0) abstractC20933sq8).D(this.e, 0, r());
    }

    @Override // com.google.android.gms.internal.measurement.A0
    public final boolean F() {
        return E1.f(this.e, 0, r());
    }

    protected int R() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.A0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof A0) || r() != ((A0) obj).r()) {
            return false;
        }
        if (r() == 0) {
            return true;
        }
        if (!(obj instanceof C2156y0)) {
            return obj.equals(this);
        }
        C2156y0 c2156y0 = (C2156y0) obj;
        int iN = N();
        int iN2 = c2156y0.N();
        if (iN != 0 && iN2 != 0 && iN != iN2) {
            return false;
        }
        int iR = r();
        if (iR > c2156y0.r()) {
            throw new IllegalArgumentException("Length too large: " + iR + r());
        }
        if (iR > c2156y0.r()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iR + ", " + c2156y0.r());
        }
        byte[] bArr = this.e;
        byte[] bArr2 = c2156y0.e;
        c2156y0.R();
        int i = 0;
        int i2 = 0;
        while (i < iR) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.A0
    public byte f(int i) {
        return this.e[i];
    }

    @Override // com.google.android.gms.internal.measurement.A0
    byte j(int i) {
        return this.e[i];
    }

    @Override // com.google.android.gms.internal.measurement.A0
    public int r() {
        return this.e.length;
    }

    @Override // com.google.android.gms.internal.measurement.A0
    protected final int w(int i, int i2, int i3) {
        return R0.d(i, this.e, 0, i3);
    }
}
