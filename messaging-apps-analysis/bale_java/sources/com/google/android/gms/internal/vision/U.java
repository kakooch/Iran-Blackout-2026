package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC25160zp8;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
class U extends Q {
    protected final byte[] e;

    U(byte[] bArr) {
        bArr.getClass();
        this.e = bArr;
    }

    @Override // com.google.android.gms.internal.vision.K
    public final K C(int i, int i2) {
        int iP = K.P(0, i2, j());
        return iP == 0 ? K.b : new N(this.e, W(), iP);
    }

    @Override // com.google.android.gms.internal.vision.K
    protected final String F(Charset charset) {
        return new String(this.e, W(), j(), charset);
    }

    @Override // com.google.android.gms.internal.vision.K
    final void L(AbstractC25160zp8 abstractC25160zp8) {
        abstractC25160zp8.a(this.e, W(), j());
    }

    @Override // com.google.android.gms.internal.vision.K
    byte N(int i) {
        return this.e[i];
    }

    @Override // com.google.android.gms.internal.vision.Q
    final boolean V(K k, int i, int i2) {
        if (i2 > k.j()) {
            int iJ = j();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(iJ);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 > k.j()) {
            int iJ2 = k.j();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(iJ2);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!(k instanceof U)) {
            return k.C(0, i2).equals(C(0, i2));
        }
        U u = (U) k;
        byte[] bArr = this.e;
        byte[] bArr2 = u.e;
        int iW = W() + i2;
        int iW2 = W();
        int iW3 = u.W();
        while (iW2 < iW) {
            if (bArr[iW2] != bArr2[iW3]) {
                return false;
            }
            iW2++;
            iW3++;
        }
        return true;
    }

    protected int W() {
        return 0;
    }

    @Override // com.google.android.gms.internal.vision.K
    public final boolean e() {
        int iW = W();
        return k1.g(this.e, iW, j() + iW);
    }

    @Override // com.google.android.gms.internal.vision.K
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof K) || j() != ((K) obj).j()) {
            return false;
        }
        if (j() == 0) {
            return true;
        }
        if (!(obj instanceof U)) {
            return obj.equals(this);
        }
        U u = (U) obj;
        int iS = S();
        int iS2 = u.S();
        if (iS == 0 || iS2 == 0 || iS == iS2) {
            return V(u, 0, j());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.K
    public byte f(int i) {
        return this.e[i];
    }

    @Override // com.google.android.gms.internal.vision.K
    public int j() {
        return this.e.length;
    }

    @Override // com.google.android.gms.internal.vision.K
    protected final int w(int i, int i2, int i3) {
        return AbstractC2184m0.a(i, this.e, W(), i3);
    }
}
