package ir.nasim;

/* renamed from: ir.nasim.Ne7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6345Ne7 extends AbstractC10736c67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = t1.f(z);
        this.e = t1.f(z);
        this.f = t1.c(z);
        this.g = t1.e(z);
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            AbstractC11500d67 abstractC11500d67D = AbstractC11500d67.d(this.d, 0L, 0L, t1, t1.e(z), z);
            if (abstractC11500d67D == null) {
                return;
            }
            this.h.add(abstractC11500d67D);
        }
        if ((this.b & 2) != 0) {
            int iE4 = t1.e(z);
            if (iE4 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE4)));
                }
                return;
            }
            int iE5 = t1.e(z);
            for (int i2 = 0; i2 < iE5; i2++) {
                AbstractC22719vi7 abstractC22719vi7D = AbstractC22719vi7.d(this.d, 0L, t1, t1.e(z), z);
                if (abstractC22719vi7D == null) {
                    return;
                }
                this.i.add(abstractC22719vi7D);
            }
        }
        this.j = t1.e(z);
    }
}
