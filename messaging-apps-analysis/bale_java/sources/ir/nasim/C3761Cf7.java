package ir.nasim;

/* renamed from: ir.nasim.Cf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C3761Cf7 extends AbstractC15161j67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            C13644ga7 c13644ga7D = C13644ga7.d(t1, t1.e(z), z);
            if (c13644ga7D == null) {
                return;
            }
            this.h.add(c13644ga7D);
        }
    }
}
