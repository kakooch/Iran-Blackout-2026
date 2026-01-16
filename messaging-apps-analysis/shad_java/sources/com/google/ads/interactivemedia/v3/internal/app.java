package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class app {
    private auh a;
    private byte[] b;
    private final int c = 239;

    public app() {
        a();
    }

    public final void a() {
        byte[] bArr = new byte[this.c];
        this.b = bArr;
        this.a = auh.a(bArr);
    }

    public final void b(int i, long j) throws IOException {
        auh auhVar = this.a;
        auhVar.e(i, 0);
        auhVar.h(j);
    }

    public final void c(int i, String str) throws IOException {
        auh auhVar = this.a;
        auhVar.e(i, 2);
        auhVar.b(str);
    }

    public final byte[] d() throws IOException {
        int iC = this.a.c();
        if (iC < 0) {
            throw new IOException();
        }
        if (iC == 0) {
            return this.b;
        }
        byte[] bArr = this.b;
        int length = bArr.length - iC;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
