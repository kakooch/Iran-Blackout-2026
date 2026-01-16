package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2152w0 extends C2156y0 {
    private final int f;

    C2152w0(byte[] bArr, int i, int i2) {
        super(bArr);
        A0.L(0, i2, bArr.length);
        this.f = i2;
    }

    @Override // com.google.android.gms.internal.measurement.C2156y0
    protected final int R() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.C2156y0, com.google.android.gms.internal.measurement.A0
    public final byte f(int i) {
        int i2 = this.f;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.e[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }

    @Override // com.google.android.gms.internal.measurement.C2156y0, com.google.android.gms.internal.measurement.A0
    final byte j(int i) {
        return this.e[i];
    }

    @Override // com.google.android.gms.internal.measurement.C2156y0, com.google.android.gms.internal.measurement.A0
    public final int r() {
        return this.f;
    }
}
