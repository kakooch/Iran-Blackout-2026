package ir.nasim;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class PU0 extends FilterInputStream {
    int a;
    int b;

    public PU0(InputStream inputStream) {
        super(inputStream);
        this.a = -1;
        this.b = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i == 3 && this.a == 0 && this.b == 0) {
            this.a = -1;
            this.b = -1;
            i = super.read();
        }
        this.a = this.b;
        this.b = i;
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = read();
        if (i3 == -1) {
            return -1;
        }
        bArr[i] = (byte) i3;
        int i4 = 1;
        while (i4 < i2) {
            try {
                int i5 = read();
                if (i5 == -1) {
                    break;
                }
                bArr[i + i4] = (byte) i5;
                i4++;
            } catch (IOException unused) {
            }
        }
        return i4;
    }
}
