package com.google.android.gms.internal.clearcut;

import ir.nasim.Dj8;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.clearcut.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2089m extends AbstractC2088l {
    protected final byte[] d;

    C2089m(byte[] bArr) {
        this.d = bArr;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    public final boolean C() {
        int iR = R();
        return q0.i(this.d, iR, size() + iR);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    public byte N(int i) {
        return this.d[i];
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2088l
    final boolean Q(AbstractC2081f abstractC2081f, int i, int i2) {
        if (i2 > abstractC2081f.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > abstractC2081f.size()) {
            int size2 = abstractC2081f.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(abstractC2081f instanceof C2089m)) {
            return abstractC2081f.j(0, i2).equals(j(0, i2));
        }
        C2089m c2089m = (C2089m) abstractC2081f;
        byte[] bArr = this.d;
        byte[] bArr2 = c2089m.d;
        int iR = R() + i2;
        int iR2 = R();
        int iR3 = c2089m.R();
        while (iR2 < iR) {
            if (bArr[iR2] != bArr2[iR3]) {
                return false;
            }
            iR2++;
            iR3++;
        }
        return true;
    }

    protected int R() {
        return 0;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2081f) || size() != ((AbstractC2081f) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof C2089m)) {
            return obj.equals(this);
        }
        C2089m c2089m = (C2089m) obj;
        int iD = D();
        int iD2 = c2089m.D();
        if (iD == 0 || iD2 == 0 || iD == iD2) {
            return Q(c2089m, 0, size());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    protected final int f(int i, int i2, int i3) {
        return B.c(i, this.d, R(), i3);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    public final AbstractC2081f j(int i, int i2) {
        int iE = AbstractC2081f.E(0, i2, size());
        return iE == 0 ? AbstractC2081f.b : new C2085i(this.d, R(), iE);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    protected final String r(Charset charset) {
        return new String(this.d, R(), size(), charset);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    public int size() {
        return this.d.length;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2081f
    final void w(Dj8 dj8) {
        dj8.a(this.d, R(), size());
    }
}
