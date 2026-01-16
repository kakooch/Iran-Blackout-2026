package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.zv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C25215zv3 {
    private final int a;
    private final C24031xv3[] b;
    private final C4852Gv3 c;
    private final List d;
    private final boolean e;
    private final int f;
    private final int g;
    private final int h;

    public C25215zv3(int i, C24031xv3[] c24031xv3Arr, C4852Gv3 c4852Gv3, List list, boolean z, int i2) {
        this.a = i;
        this.b = c24031xv3Arr;
        this.c = c4852Gv3;
        this.d = list;
        this.e = z;
        this.f = i2;
        int iMax = 0;
        for (C24031xv3 c24031xv3 : c24031xv3Arr) {
            iMax = Math.max(iMax, c24031xv3.r());
        }
        this.g = iMax;
        this.h = AbstractC23053wG5.e(iMax + this.f, 0);
    }

    public final int a() {
        return this.a;
    }

    public final C24031xv3[] b() {
        return this.b;
    }

    public final int c() {
        return this.g;
    }

    public final int d() {
        return this.h;
    }

    public final boolean e() {
        return this.b.length == 0;
    }

    public final C24031xv3[] f(int i, int i2, int i3) {
        C24031xv3[] c24031xv3Arr = this.b;
        int length = c24031xv3Arr.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            C24031xv3 c24031xv3 = c24031xv3Arr[i4];
            int i7 = i5 + 1;
            int iD = C10870cL2.d(((C10870cL2) this.d.get(i5)).g());
            int i8 = this.c.a()[i6];
            boolean z = this.e;
            c24031xv3.u(i, i8, i2, i3, z ? this.a : i6, z ? i6 : this.a);
            C19938rB7 c19938rB7 = C19938rB7.a;
            i6 += iD;
            i4++;
            i5 = i7;
        }
        return this.b;
    }
}
