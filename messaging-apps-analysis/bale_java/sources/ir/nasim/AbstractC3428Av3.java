package ir.nasim;

import ir.nasim.C5788Kv3;
import java.util.List;

/* renamed from: ir.nasim.Av3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3428Av3 {
    private final boolean a;
    private final C4852Gv3 b;
    private final int c;
    private final int d;
    private final AbstractC24621yv3 e;
    private final C5788Kv3 f;

    public AbstractC3428Av3(boolean z, C4852Gv3 c4852Gv3, int i, int i2, AbstractC24621yv3 abstractC24621yv3, C5788Kv3 c5788Kv3) {
        this.a = z;
        this.b = c4852Gv3;
        this.c = i;
        this.d = i2;
        this.e = abstractC24621yv3;
        this.f = c5788Kv3;
    }

    public final long a(int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = this.b.b()[i];
        } else {
            int i4 = (i2 + i) - 1;
            i3 = (this.b.a()[i4] + this.b.b()[i4]) - this.b.a()[i];
        }
        int iE = AbstractC23053wG5.e(i3, 0);
        return this.a ? C17833ne1.b.e(iE) : C17833ne1.b.d(iE);
    }

    public abstract C25215zv3 b(int i, C24031xv3[] c24031xv3Arr, List list, int i2);

    public final C25215zv3 c(int i) {
        C5788Kv3.c cVarC = this.f.c(i);
        int size = cVarC.b().size();
        int i2 = (size == 0 || cVarC.a() + size == this.c) ? 0 : this.d;
        C24031xv3[] c24031xv3Arr = new C24031xv3[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int iD = C10870cL2.d(((C10870cL2) cVarC.b().get(i4)).g());
            C24031xv3 c24031xv3D = this.e.d(cVarC.a() + i4, a(i3, iD), i3, iD, i2);
            i3 += iD;
            C19938rB7 c19938rB7 = C19938rB7.a;
            c24031xv3Arr[i4] = c24031xv3D;
        }
        return b(i, c24031xv3Arr, cVarC.b(), i2);
    }

    public final int d(int i) {
        C5788Kv3 c5788Kv3 = this.f;
        return c5788Kv3.i(i, c5788Kv3.e());
    }
}
