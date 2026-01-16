package ir.nasim;

/* renamed from: ir.nasim.Jt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C5540Jt7 {
    public final C22835vt7 a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public C5540Jt7(C22835vt7 c22835vt7, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        AbstractC20011rK.a(iArr.length == jArr2.length);
        AbstractC20011rK.a(jArr.length == jArr2.length);
        AbstractC20011rK.a(iArr2.length == jArr2.length);
        this.a = c22835vt7;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int i = AbstractC9683aN7.i(this.f, j, true, false); i >= 0; i--) {
            if ((this.g[i] & 1) != 0) {
                return i;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iE = AbstractC9683aN7.e(this.f, j, true, false); iE < this.f.length; iE++) {
            if ((this.g[iE] & 1) != 0) {
                return iE;
            }
        }
        return -1;
    }
}
