package ir.nasim;

/* renamed from: ir.nasim.wJ3, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23078wJ3 implements Cloneable {
    private long[] a;
    private int[] b;
    private int c;

    public C23078wJ3() {
        this(10);
    }

    private static int b(long[] jArr, int i, int i2, long j) {
        int i3 = i2 + i;
        int i4 = i - 1;
        int i5 = i3;
        while (i5 - i4 > 1) {
            int i6 = (i5 + i4) / 2;
            if (jArr[i6] < j) {
                i4 = i6;
            } else {
                i5 = i6;
            }
        }
        return i5 == i3 ? ~i3 : jArr[i5] == j ? i5 : ~i5;
    }

    private void f(int i) {
        int iB = UJ.b(i);
        long[] jArr = new long[iB];
        int[] iArr = new int[iB];
        long[] jArr2 = this.a;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        int[] iArr2 = this.b;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.a = jArr;
        this.b = iArr;
    }

    public void c() {
        this.c = 0;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C23078wJ3 clone() {
        C23078wJ3 c23078wJ3 = null;
        try {
            C23078wJ3 c23078wJ32 = (C23078wJ3) super.clone();
            try {
                c23078wJ32.a = (long[]) this.a.clone();
                c23078wJ32.b = (int[]) this.b.clone();
                return c23078wJ32;
            } catch (CloneNotSupportedException unused) {
                c23078wJ3 = c23078wJ32;
                return c23078wJ3;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public int e(long j, int i) {
        int iB = b(this.a, 0, this.c, j);
        return iB < 0 ? i : this.b[iB];
    }

    public void h(long j, int i) {
        int iB = b(this.a, 0, this.c, j);
        if (iB >= 0) {
            this.b[iB] = i;
            return;
        }
        int i2 = ~iB;
        int i3 = this.c;
        if (i3 >= this.a.length) {
            f(i3 + 1);
        }
        int i4 = this.c;
        if (i4 - i2 != 0) {
            long[] jArr = this.a;
            int i5 = i2 + 1;
            System.arraycopy(jArr, i2, jArr, i5, i4 - i2);
            int[] iArr = this.b;
            System.arraycopy(iArr, i2, iArr, i5, this.c - i2);
        }
        this.a[i2] = j;
        this.b[i2] = i;
        this.c++;
    }

    public C23078wJ3(int i) {
        int iB = UJ.b(i);
        this.a = new long[iB];
        this.b = new int[iB];
        this.c = 0;
    }
}
