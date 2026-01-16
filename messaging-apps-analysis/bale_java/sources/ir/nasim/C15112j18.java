package ir.nasim;

/* renamed from: ir.nasim.j18, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15112j18 {
    private final byte[] a;
    private final int b;
    private int c;
    private int d;

    public C15112j18(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    private void a() {
        int i;
        int i2 = this.c;
        AbstractC20011rK.g(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.d == 0)));
    }

    public int b() {
        return (this.c * 8) + this.d;
    }

    public boolean c() {
        boolean z = (((this.a[this.c] & 255) >> this.d) & 1) == 1;
        e(1);
        return z;
    }

    public int d(int i) {
        int i2 = this.c;
        int iMin = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & 255) >> this.d) & (255 >> (8 - iMin));
        while (iMin < i) {
            i4 |= (this.a[i3] & 255) << iMin;
            iMin += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - i));
        e(i);
        return i5;
    }

    public void e(int i) {
        int i2 = i / 8;
        int i3 = this.c + i2;
        this.c = i3;
        int i4 = this.d + (i - (i2 * 8));
        this.d = i4;
        if (i4 > 7) {
            this.c = i3 + 1;
            this.d = i4 - 8;
        }
        a();
    }
}
