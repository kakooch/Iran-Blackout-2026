package ir.nasim;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.Wi5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C8526Wi5 extends FilterInputStream {
    private long a;
    private long b;

    public C8526Wi5(InputStream inputStream) {
        this(inputStream, 0L);
    }

    public long a() {
        return this.a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.b = this.a;
        super.mark(i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i >= 0) {
            this.a++;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.a = this.b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long j2 = this.a;
        long jSkip = super.skip(j);
        this.a = j2 + jSkip;
        return jSkip;
    }

    public C8526Wi5(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.a;
        int i3 = super.read(bArr, i, i2);
        if (i3 > 0) {
            this.a = j + i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }
}
