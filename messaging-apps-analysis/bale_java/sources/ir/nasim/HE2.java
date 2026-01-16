package ir.nasim;

/* loaded from: classes5.dex */
public abstract class HE2 {
    private final byte[] a = new byte[4];
    private int b = 0;
    private long c;

    protected HE2() {
    }

    public void a() {
        long j = this.c << 3;
        f((byte) -128);
        while (this.b != 0) {
            f((byte) 0);
        }
        c(j);
        b();
    }

    protected abstract void b();

    protected abstract void c(long j);

    protected abstract void d(byte[] bArr, int i);

    public void e() {
        this.c = 0L;
        this.b = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }

    public void f(byte b) {
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            d(bArr, 0);
            this.b = 0;
        }
        this.c++;
    }

    public void g(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i2);
        if (this.b != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= iMax) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.a;
                int i5 = this.b;
                int i6 = i5 + 1;
                this.b = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    d(bArr2, 0);
                    this.b = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = ((iMax - i3) & (-4)) + i3;
        while (i3 < i8) {
            d(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < iMax) {
            byte[] bArr3 = this.a;
            int i9 = this.b;
            this.b = i9 + 1;
            bArr3[i9] = bArr[i3 + i];
            i3++;
        }
        this.c += iMax;
    }
}
