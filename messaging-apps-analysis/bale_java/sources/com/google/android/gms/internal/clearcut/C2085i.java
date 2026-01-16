package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2085i extends C2089m {
    private final int e;
    private final int f;

    C2085i(byte[] bArr, int i, int i2) {
        super(bArr);
        AbstractC2081f.E(i, i + i2, bArr.length);
        this.e = i;
        this.f = i2;
    }

    @Override // com.google.android.gms.internal.clearcut.C2089m, com.google.android.gms.internal.clearcut.AbstractC2081f
    public final byte N(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.d[this.e + i];
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
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.clearcut.C2089m
    protected final int R() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.clearcut.C2089m, com.google.android.gms.internal.clearcut.AbstractC2081f
    public final int size() {
        return this.f;
    }
}
