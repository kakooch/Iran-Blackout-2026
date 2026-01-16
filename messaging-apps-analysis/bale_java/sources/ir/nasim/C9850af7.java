package ir.nasim;

/* renamed from: ir.nasim.af7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9850af7 extends C6345Ne7 {
    @Override // ir.nasim.C6345Ne7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = t1.f(z);
        this.e = t1.f(z);
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
            AbstractC11500d67 abstractC11500d67D = AbstractC11500d67.d(0L, 0L, 0L, t1, t1.e(z), z);
            if (abstractC11500d67D == null) {
                return;
            }
            this.h.add(abstractC11500d67D);
        }
    }
}
