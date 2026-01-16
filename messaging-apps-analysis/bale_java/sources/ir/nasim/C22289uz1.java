package ir.nasim;

import java.io.InputStream;

/* renamed from: ir.nasim.uz1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22289uz1 extends InputStream {
    private final com.google.android.exoplayer2.upstream.a a;
    private final com.google.android.exoplayer2.upstream.b b;
    private long f;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public C22289uz1(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    private void a() {
        if (this.d) {
            return;
        }
        this.a.b(this.b);
        this.d = true;
    }

    public void b() {
        a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.e) {
            return;
        }
        this.a.close();
        this.e = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        AbstractC20011rK.g(!this.e);
        a();
        int i3 = this.a.read(bArr, i, i2);
        if (i3 == -1) {
            return -1;
        }
        this.f += i3;
        return i3;
    }
}
