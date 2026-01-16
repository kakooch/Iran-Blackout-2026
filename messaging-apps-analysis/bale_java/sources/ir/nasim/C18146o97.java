package ir.nasim;

/* renamed from: ir.nasim.o97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18146o97 extends C57 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.f = iE;
        this.y = (iE & 4) != 0;
        this.i = AbstractC24721z57.d(t1, t1.e(z), z);
        if ((this.f & 1) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
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
