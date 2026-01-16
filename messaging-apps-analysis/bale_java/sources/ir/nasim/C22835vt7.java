package ir.nasim;

/* renamed from: ir.nasim.vt7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22835vt7 {
    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final com.google.android.exoplayer2.X f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final C24605yt7[] k;

    public C22835vt7(int i, int i2, long j, long j2, long j3, com.google.android.exoplayer2.X x, int i3, C24605yt7[] c24605yt7Arr, int i4, long[] jArr, long[] jArr2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = x;
        this.g = i3;
        this.k = c24605yt7Arr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public C24605yt7 a(int i) {
        C24605yt7[] c24605yt7Arr = this.k;
        if (c24605yt7Arr == null) {
            return null;
        }
        return c24605yt7Arr[i];
    }
}
