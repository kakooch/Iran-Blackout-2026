package ir.nasim;

/* renamed from: ir.nasim.Sg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7569Sg7 extends AbstractC19061pi7 {
    public static int i = -1676371894;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE;
        int iE2;
        this.b = t1.e(z);
        this.d = AbstractC14549i57.d(t1, t1.e(z), z);
        this.e = t1.e(z);
        if ((this.b & 1) != 0 && (iE2 = t1.e(z)) != 0) {
            this.g.add(Integer.valueOf(iE2));
        }
        if ((this.b & 1) != 0 && (iE = t1.e(z)) != 0) {
            this.g.add(0, Integer.valueOf(iE));
        }
        if ((this.b & 2) != 0) {
            this.h = AbstractC23315wi7.d(t1, t1.e(z), z);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(i);
        t1.m(this.b);
        this.d.c(t1);
        t1.m(this.e);
        if ((this.b & 1) != 0) {
            t1.m(this.g.size() > 1 ? ((Integer) this.g.get(1)).intValue() : 0);
        }
        if ((this.b & 1) != 0) {
            t1.m(this.g.size() > 0 ? ((Integer) this.g.get(0)).intValue() : 0);
        }
        if ((this.b & 2) != 0) {
            this.h.c(t1);
        }
    }
}
