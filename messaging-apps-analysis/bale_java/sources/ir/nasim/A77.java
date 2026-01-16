package ir.nasim;

/* loaded from: classes7.dex */
public class A77 extends AbstractC18106o57 {
    public static int s = -1881881384;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.f(z);
        this.d = t1.f(z);
        this.e = t1.c(z);
        this.g = t1.e(z);
        this.i = t1.g(z);
        this.j = t1.f(z);
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
                AbstractC11500d67 abstractC11500d67D = AbstractC11500d67.d(0L, this.c, 0L, t1, t1.e(z), z);
                if (abstractC11500d67D == null) {
                    return;
                }
                this.k.add(abstractC11500d67D);
            }
        }
        if ((this.b & 2) != 0) {
            int iE3 = t1.e(z);
            if (iE3 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE3)));
                }
                return;
            }
            int iE4 = t1.e(z);
            for (int i2 = 0; i2 < iE4; i2++) {
                AbstractC22719vi7 abstractC22719vi7D = AbstractC22719vi7.d(0L, this.c, t1, t1.e(z), z);
                if (abstractC22719vi7D == null) {
                    return;
                }
                this.l.add(abstractC22719vi7D);
            }
        }
        this.m = t1.e(z);
        int iE5 = t1.e(z);
        if (iE5 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE5)));
            }
            return;
        }
        int iE6 = t1.e(z);
        for (int i3 = 0; i3 < iE6; i3++) {
            AbstractC18697p57 abstractC18697p57D = AbstractC18697p57.d(t1, t1.e(z), z);
            if (abstractC18697p57D == null) {
                return;
            }
            this.p.add(abstractC18697p57D);
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(s);
        t1.m(this.b);
        t1.n(this.c);
        t1.n(this.d);
        t1.k(this.e);
        t1.m(this.g);
        t1.o(this.i);
        t1.n(this.j);
        if ((this.b & 1) != 0) {
            t1.m(481674261);
            int size = this.k.size();
            t1.m(size);
            for (int i = 0; i < size; i++) {
                ((AbstractC11500d67) this.k.get(i)).c(t1);
            }
        }
        if ((this.b & 2) != 0) {
            t1.m(481674261);
            int size2 = this.l.size();
            t1.m(size2);
            for (int i2 = 0; i2 < size2; i2++) {
                ((AbstractC22719vi7) this.l.get(i2)).c(t1);
            }
        }
        t1.m(this.m);
        t1.m(481674261);
        int size3 = this.p.size();
        t1.m(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            ((AbstractC18697p57) this.p.get(i3)).c(t1);
        }
    }
}
