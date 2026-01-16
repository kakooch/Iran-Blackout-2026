package ir.nasim;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class EZ2 {
    private final InputStream a;

    public EZ2(InputStream inputStream) {
        this.a = inputStream;
    }

    public byte a() throws IOException {
        int i = this.a.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public final void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = this.a.read(bArr, i + i3, i2 - i3);
            if (i4 <= 0) {
                throw new EOFException();
            }
            i3 += i4;
        }
    }

    public byte[] c(int i) throws IOException {
        byte[] bArr = new byte[i];
        b(bArr, 0, i);
        return bArr;
    }

    public int d() {
        return ((a() & 255) << 24) | ((a() & 255) << 16) | ((a() & 255) << 8) | (a() & 255);
    }

    public int e() {
        return ((a() & 127) << 21) | ((a() & 127) << 14) | ((a() & 127) << 7) | (a() & 127);
    }

    public void f(long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            long jSkip = this.a.skip(j - j2);
            if (jSkip <= 0) {
                throw new EOFException();
            }
            j2 += jSkip;
        }
    }
}
