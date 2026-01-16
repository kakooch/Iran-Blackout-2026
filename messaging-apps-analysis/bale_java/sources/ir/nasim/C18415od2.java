package ir.nasim;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.od2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C18415od2 extends InputStream {
    private final InputStream a;
    private int b = 1073741824;

    public C18415od2(InputStream inputStream) {
        this.a = inputStream;
    }

    private final int a(int i) {
        if (i == -1) {
            this.b = 0;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return a(this.a.read());
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.a.skip(j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return a(this.a.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return a(this.a.read(bArr, i, i2));
    }
}
