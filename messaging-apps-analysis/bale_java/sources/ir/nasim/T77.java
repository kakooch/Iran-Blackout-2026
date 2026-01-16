package ir.nasim;

/* loaded from: classes7.dex */
public class T77 extends A77 {
    public static int t = -1683841855;

    @Override // ir.nasim.A77, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.f(z);
        this.d = t1.f(z);
        this.e = t1.c(z);
        this.g = t1.e(z);
        this.i = t1.g(z);
        this.j = t1.e(z);
        if ((this.b & 1) != 0) {
            int iE = t1.e(z);
            if (iE != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
                }
                return;
            }
            int iE2 = t1.e(z);
            for (int i = 0; i < iE2; i++) {
                AbstractC11500d67 abstractC11500d67D = AbstractC11500d67.d(0L, 0L, 0L, t1, t1.e(z), z);
                if (abstractC11500d67D == null) {
                    return;
                }
                this.k.add(abstractC11500d67D);
            }
        }
        this.m = t1.e(z);
        int iE3 = t1.e(z);
        if (iE3 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE3)));
            }
            return;
        }
        int iE4 = t1.e(z);
        for (int i2 = 0; i2 < iE4; i2++) {
            AbstractC18697p57 abstractC18697p57D = AbstractC18697p57.d(t1, t1.e(z), z);
            if (abstractC18697p57D == null) {
                return;
            }
            this.p.add(abstractC18697p57D);
        }
    }

    @Override // ir.nasim.A77, ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(t);
        t1.m(this.b);
        t1.n(this.c);
        t1.n(this.d);
        t1.k(this.e);
        t1.m(this.g);
        t1.o(this.i);
        t1.m((int) this.j);
        if ((this.b & 1) != 0) {
            t1.m(481674261);
            int size = this.k.size();
            t1.m(size);
            for (int i = 0; i < size; i++) {
                ((AbstractC11500d67) this.k.get(i)).c(t1);
            }
        }
        t1.m(this.m);
        t1.m(481674261);
        int size2 = this.p.size();
        t1.m(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            ((AbstractC18697p57) this.p.get(i2)).c(t1);
        }
    }
}
