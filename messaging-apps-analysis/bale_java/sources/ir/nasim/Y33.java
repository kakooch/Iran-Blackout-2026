package ir.nasim;

import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class Y33 extends OutputStream {
    public byte[] a;
    protected int b;

    public Y33(int i) {
        this.a = new byte[i];
    }

    private void a(int i) {
        if (i - this.a.length > 0) {
            b(i);
        }
    }

    private void b(int i) {
        int length = this.a.length << 1;
        if (length - i < 0) {
            length = i;
        }
        if (length - 2147483639 > 0) {
            length = c(i);
        }
        this.a = Arrays.copyOf(this.a, length);
    }

    private static int c(int i) {
        if (i >= 0) {
            return i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        throw new OutOfMemoryError();
    }

    public void d(int i) {
        a(this.b + 4);
        byte[] bArr = this.a;
        int i2 = this.b;
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
        this.b = i2 + 4;
    }

    public synchronized void reset() {
        this.b = 0;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        a(this.b + 1);
        byte[] bArr = this.a;
        int i2 = this.b;
        bArr[i2] = (byte) i;
        this.b = i2 + 1;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        if (i >= 0) {
            if (i <= bArr.length && i2 >= 0 && (i + i2) - bArr.length <= 0) {
                a(this.b + i2);
                System.arraycopy(bArr, i, this.a, this.b, i2);
                this.b += i2;
            }
        }
        throw new IndexOutOfBoundsException();
    }
}
