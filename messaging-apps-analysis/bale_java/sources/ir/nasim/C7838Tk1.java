package ir.nasim;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: ir.nasim.Tk1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7838Tk1 extends FilterInputStream {
    private final long a;
    private int b;

    private C7838Tk1(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
        } else if (this.a - this.b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return i;
    }

    public static InputStream b(InputStream inputStream, long j) {
        return new C7838Tk1(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.a - this.b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i;
        i = super.read();
        a(i >= 0 ? 1 : -1);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return a(super.read(bArr, i, i2));
    }
}
