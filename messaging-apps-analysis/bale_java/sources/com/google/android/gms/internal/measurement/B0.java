package com.google.android.gms.internal.measurement;

import ir.nasim.Nq8;

/* loaded from: classes3.dex */
final class B0 extends C0 {
    private final byte[] b;
    private int c;
    private int d;
    private int e;

    /* synthetic */ B0(byte[] bArr, int i, int i2, boolean z, Nq8 nq8) {
        super(null);
        this.e = Integer.MAX_VALUE;
        this.b = bArr;
        this.c = 0;
    }

    public final int c(int i) {
        int i2 = this.e;
        this.e = 0;
        int i3 = this.c + this.d;
        this.c = i3;
        if (i3 > 0) {
            this.d = i3;
            this.c = i3 - i3;
        } else {
            this.d = 0;
        }
        return i2;
    }
}
