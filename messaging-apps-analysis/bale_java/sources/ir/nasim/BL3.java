package ir.nasim;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class BL3 extends C8526Wi5 {
    public BL3(InputStream inputStream) {
        super(inputStream);
    }

    public final void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = read(bArr, i + i3, i2 - i3);
            if (i4 <= 0) {
                throw new EOFException();
            }
            i3 += i4;
        }
    }

    public void c(long j) throws IOException {
        long j2 = 0;
        while (j2 < j) {
            long jSkip = skip(j - j2);
            if (jSkip <= 0) {
                throw new EOFException();
            }
            j2 += jSkip;
        }
    }

    public String toString() {
        return "mp3[pos=" + a() + "]";
    }
}
