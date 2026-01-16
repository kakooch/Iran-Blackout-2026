package ir.nasim;

/* loaded from: classes7.dex */
public class V77 extends A77 {
    public static int t = -106717361;

    @Override // ir.nasim.A77, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.c = t1.f(z);
        this.d = t1.f(z);
        this.g = t1.e(z);
        this.i = t1.g(z);
        this.j = t1.e(z);
        this.k.add(AbstractC11500d67.d(0L, 0L, 0L, t1, t1.e(z), z));
        this.m = t1.e(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
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
        t1.n(this.c);
        t1.n(this.d);
        t1.m(this.g);
        t1.o(this.i);
        t1.m((int) this.j);
        ((AbstractC11500d67) this.k.get(0)).c(t1);
        t1.m(this.m);
        t1.m(481674261);
        int size = this.p.size();
        t1.m(size);
        for (int i = 0; i < size; i++) {
            ((AbstractC18697p57) this.p.get(i)).c(t1);
        }
    }
}
