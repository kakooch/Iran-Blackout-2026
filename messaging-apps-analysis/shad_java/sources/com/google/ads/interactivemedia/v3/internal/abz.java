package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class abz extends InputStream {
    private final abx a;
    private final acb b;
    private long f;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public abz(abx abxVar, acb acbVar) {
        this.a = abxVar;
        this.b = acbVar;
    }

    private final void b() throws IOException {
        if (this.d) {
            return;
        }
        this.a.c(this.b);
        this.d = true;
    }

    public final void a() throws IOException {
        b();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.e) {
            return;
        }
        this.a.f();
        this.e = true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        ary.q(!this.e);
        b();
        int iA = this.a.a(bArr, i, i2);
        if (iA == -1) {
            return -1;
        }
        this.f += iA;
        return iA;
    }
}
