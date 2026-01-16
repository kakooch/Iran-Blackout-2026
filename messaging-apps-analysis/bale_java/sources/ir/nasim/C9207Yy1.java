package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.Yy1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9207Yy1 {
    private byte[] a;
    private int b;
    private int c;

    public C9207Yy1(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data can't be null");
        }
        this.a = bArr;
        this.b = 0;
        this.c = bArr.length;
    }

    public boolean a() {
        return this.c <= this.b;
    }

    public int b() throws IOException {
        int i = this.b;
        if (i == this.c) {
            throw new IOException();
        }
        byte[] bArr = this.a;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public byte[] c(int i) throws IOException {
        if (i < 0) {
            throw new IOException("Count can't be negative");
        }
        if (i > 1048576) {
            throw new IOException("Unable to read more than 1 MB");
        }
        if (this.b + i > this.c) {
            throw new IOException("Too many to read, max len: " + this.c + ", required len: " + (this.b + i));
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr2 = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            bArr[i2] = bArr2[i3];
        }
        return bArr;
    }

    public int d() throws IOException {
        int i = this.b;
        if (i + 4 > this.c) {
            throw new IOException();
        }
        byte[] bArr = this.a;
        int i2 = (bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 1] & 255) << 16) + ((bArr[i] & 255) << 24);
        this.b = i + 4;
        return i2;
    }

    public long e() throws IOException {
        int i = this.b;
        if (i + 8 > this.c) {
            throw new IOException();
        }
        byte[] bArr = this.a;
        long j = (bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 1] & 255) << 16) + ((bArr[i] & 255) << 24);
        long j2 = (bArr[i + 7] & 255) + ((bArr[i + 6] & 255) << 8) + ((bArr[i + 5] & 255) << 16) + ((bArr[i + 4] & 255) << 24);
        this.b = i + 8;
        return j2 + (j << 32);
    }

    public boolean f() {
        return b() != 0;
    }

    public byte[] g() throws IOException {
        long jK = k();
        if (jK < 0) {
            throw new IOException();
        }
        if (jK <= 1048576) {
            return c((int) jK);
        }
        throw new IOException();
    }

    public long[] h() throws IOException {
        long jK = k();
        if (jK < 0) {
            throw new IOException();
        }
        if (jK > 1048576) {
            throw new IOException();
        }
        int i = (int) jK;
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = e();
        }
        return jArr;
    }

    public String i() {
        return new String(g(), "UTF-8");
    }

    public long j() throws IOException {
        int i = this.b;
        if (i + 4 > this.c) {
            throw new IOException();
        }
        byte[] bArr = this.a;
        long j = bArr[i + 3] & 255;
        long j2 = bArr[i + 2] & 255;
        long j3 = bArr[i + 1] & 255;
        long j4 = bArr[i] & 255;
        this.b = i + 4;
        return j + (j2 << 8) + (j3 << 16) + (j4 << 24);
    }

    public long k() throws IOException {
        long j = 0;
        long j2 = 0;
        do {
            int i = this.b;
            if (i == this.c) {
                throw new IOException();
            }
            byte[] bArr = this.a;
            this.b = i + 1;
            long j3 = bArr[i] & 255;
            if ((128 & j3) == 0) {
                return (j3 << ((int) j2)) | j;
            }
            j |= (j3 & 127) << ((int) j2);
            j2 += 7;
        } while (j2 <= 70);
        throw new IOException();
    }

    public C9207Yy1(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data can't be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Offset can't be negative");
        }
        if (i2 >= 0) {
            int i3 = i + i2;
            if (bArr.length >= i3) {
                this.a = bArr;
                this.b = i;
                this.c = i3;
                return;
            }
            throw new IllegalArgumentException("Inconsistent lengths, total: " + bArr.length + ", offset: " + i + ", len: " + i2);
        }
        throw new IllegalArgumentException("Length can't be negative");
    }
}
