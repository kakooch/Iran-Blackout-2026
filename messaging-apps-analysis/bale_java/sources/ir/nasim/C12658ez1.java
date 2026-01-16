package ir.nasim;

import java.io.UnsupportedEncodingException;

/* renamed from: ir.nasim.ez1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C12658ez1 {
    private byte[] a = new byte[16];
    private int b;

    private void a(int i) {
        int length = this.a.length;
        while (length < i) {
            length = b(length);
        }
        byte[] bArr = new byte[length];
        System.arraycopy(this.a, 0, bArr, 0, this.b);
        this.a = bArr;
    }

    public static int b(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    public byte[] c() {
        byte[] bArr = new byte[this.b];
        for (int i = 0; i < this.b; i++) {
            bArr[i] = this.a[i];
        }
        return bArr;
    }

    public void d(byte b) {
        int length = this.a.length;
        int i = this.b;
        if (length <= i + 1) {
            a(i + 1);
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        bArr[i2] = b;
    }

    public void e(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Value can't be negative");
        }
        if (i > 255) {
            throw new IllegalArgumentException("Value can't be more than 255");
        }
        int length = this.a.length;
        int i2 = this.b;
        if (length <= i2 + 1) {
            a(i2 + 1);
        }
        byte[] bArr = this.a;
        int i3 = this.b;
        this.b = i3 + 1;
        bArr[i3] = (byte) i;
    }

    public void f(byte[] bArr) {
        g(bArr, 0, bArr.length);
    }

    public void g(byte[] bArr, int i, int i2) {
        if (i2 > 1048576) {
            throw new IllegalArgumentException("Unable to write more than 1 MB");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Length can't be negative");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Offset can't be negative");
        }
        if (i + i2 > bArr.length) {
            throw new IllegalArgumentException("Inconsistent sizes");
        }
        int length = this.a.length;
        int i3 = this.b;
        if (length < bArr.length + i3) {
            a(i3 + bArr.length);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            byte[] bArr2 = this.a;
            int i5 = this.b;
            this.b = i5 + 1;
            bArr2[i5] = bArr[i4 + i];
        }
    }

    public void h(int i) {
        int length = this.a.length;
        int i2 = this.b;
        if (length <= i2 + 4) {
            a(i2 + 4);
        }
        byte[] bArr = this.a;
        int i3 = this.b;
        bArr[i3] = (byte) ((i >> 24) & 255);
        bArr[i3 + 1] = (byte) ((i >> 16) & 255);
        bArr[i3 + 2] = (byte) ((i >> 8) & 255);
        this.b = i3 + 4;
        bArr[i3 + 3] = (byte) (i & 255);
    }

    public void i(long j) {
        int length = this.a.length;
        int i = this.b;
        if (length <= i + 8) {
            a(i + 8);
        }
        byte[] bArr = this.a;
        int i2 = this.b;
        bArr[i2] = (byte) ((j >> 56) & 255);
        bArr[i2 + 1] = (byte) ((j >> 48) & 255);
        bArr[i2 + 2] = (byte) ((j >> 40) & 255);
        bArr[i2 + 3] = (byte) ((j >> 32) & 255);
        bArr[i2 + 4] = (byte) ((j >> 24) & 255);
        bArr[i2 + 5] = (byte) ((j >> 16) & 255);
        bArr[i2 + 6] = (byte) ((j >> 8) & 255);
        this.b = i2 + 8;
        bArr[i2 + 7] = (byte) (j & 255);
    }

    public void j(boolean z) {
        e(z ? 1 : 0);
    }

    public void k(byte[] bArr, int i, int i2) {
        n(i2);
        g(bArr, i, i2);
    }

    public void l(long[] jArr) {
        if (jArr.length > 1048576) {
            throw new IllegalArgumentException("Values can't be more than 1048576");
        }
        n(jArr.length);
        for (long j : jArr) {
            i(j);
        }
    }

    public void m(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("UTF-8");
        k(bytes, 0, bytes.length);
    }

    public void n(long j) {
        while (((-128) & j) != 0) {
            e((int) ((j & 127) | 128));
            j >>>= 7;
        }
        e((int) (j & 127));
    }
}
