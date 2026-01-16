package ir.nasim;

/* renamed from: ir.nasim.n97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17555n97 extends C57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.f = iE;
        this.r = (iE & 8) != 0;
        this.s = (iE & 16) != 0;
        this.y = (iE & 32) != 0;
        this.i = AbstractC24721z57.d(t1, t1.e(z), z);
        if ((this.f & 4) != 0) {
            this.u = AbstractC24721z57.d(t1, t1.e(z), z);
        }
        this.v = t1.g(z);
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            AbstractC18697p57 abstractC18697p57D = AbstractC18697p57.d(t1, t1.e(z), z);
            if (abstractC18697p57D == null) {
                return;
            }
            this.w.add(abstractC18697p57D);
        }
        if ((this.f & 1) != 0) {
            int iE4 = t1.e(z);
            if (iE4 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE4)));
                }
                return;
            }
            int iE5 = t1.e(z);
            for (int i2 = 0; i2 < iE5; i2++) {
                AbstractC24131y57 abstractC24131y57D = AbstractC24131y57.d(t1, t1.e(z), z);
                if (abstractC24131y57D == null) {
                    return;
                }
                this.j.add(abstractC24131y57D);
            }
        }
        if ((this.f & 2) != 0) {
            this.g = t1.e(z);
        }
    }
}
