package com.google.android.gms.internal.vision;

/* loaded from: classes3.dex */
final class N extends U {
    private final int f;
    private final int g;

    N(byte[] bArr, int i, int i2) {
        super(bArr);
        K.P(i, i + i2, bArr.length);
        this.f = i;
        this.g = i2;
    }

    @Override // com.google.android.gms.internal.vision.U, com.google.android.gms.internal.vision.K
    final byte N(int i) {
        return this.e[this.f + i];
    }

    @Override // com.google.android.gms.internal.vision.U
    protected final int W() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.vision.U, com.google.android.gms.internal.vision.K
    public final byte f(int i) {
        int iJ = j();
        if (((iJ - (i + 1)) | i) >= 0) {
            return this.e[this.f + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(iJ);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.vision.U, com.google.android.gms.internal.vision.K
    public final int j() {
        return this.g;
    }
}
