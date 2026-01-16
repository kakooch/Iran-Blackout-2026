package ir.nasim;

/* renamed from: ir.nasim.ai7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9880ai7 extends AbstractC24495yi7 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.d = t1.e(z);
        this.e = t1.g(z);
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
            this.f.add(abstractC18697p57D);
        }
    }
}
