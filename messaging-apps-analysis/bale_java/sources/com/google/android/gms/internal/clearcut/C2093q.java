package com.google.android.gms.internal.clearcut;

/* renamed from: com.google.android.gms.internal.clearcut.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2093q extends AbstractC2091o {
    private final byte[] d;
    private final boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    private C2093q(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.j = Integer.MAX_VALUE;
        this.d = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = i;
        this.e = z;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2091o
    public final int c() {
        return this.h - this.i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC2091o
    public final int d(int i) throws zzco {
        if (i < 0) {
            throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iC = i + c();
        int i2 = this.j;
        if (iC > i2) {
            throw zzco.a();
        }
        this.j = iC;
        int i3 = this.f + this.g;
        this.f = i3;
        int i4 = i3 - this.i;
        if (i4 > iC) {
            int i5 = i4 - iC;
            this.g = i5;
            this.f = i3 - i5;
        } else {
            this.g = 0;
        }
        return i2;
    }
}
