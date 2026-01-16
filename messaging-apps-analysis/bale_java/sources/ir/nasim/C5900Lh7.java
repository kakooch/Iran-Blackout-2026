package ir.nasim;

/* renamed from: ir.nasim.Lh7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5900Lh7 extends AbstractC22719vi7 {
    public static int l = 228623102;
    public F57 j;
    public long k;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.j = F57.d(t1, t1.e(z), z);
        this.k = t1.f(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            this.i.add(Integer.valueOf(t1.e(z)));
        }
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(l);
        this.j.c(t1);
        t1.n(this.k);
        t1.m(481674261);
        int size = this.i.size();
        t1.m(size);
        for (int i = 0; i < size; i++) {
            t1.m(((Integer) this.i.get(i)).intValue());
        }
    }
}
