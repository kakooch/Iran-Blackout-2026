package ir.nasim;

/* renamed from: ir.nasim.pe7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C19021pe7 extends C3270Ad7 {
    @Override // ir.nasim.C3270Ad7, ir.nasim.AbstractC12724f57
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
            W57 w57D = W57.d(t1, t1.e(z), z);
            if (w57D == null) {
                return;
            }
            this.f.add(w57D);
        }
        int iE3 = t1.e(z);
        if (iE3 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE3)));
            }
            return;
        }
        int iE4 = t1.e(z);
        for (int i2 = 0; i2 < iE4; i2++) {
            AbstractC10736c67 abstractC10736c67D = AbstractC10736c67.d(t1, t1.e(z), z);
            if (abstractC10736c67D == null) {
                return;
            }
            this.g.add(abstractC10736c67D);
        }
        int iE5 = t1.e(z);
        if (iE5 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE5)));
            }
            return;
        }
        int iE6 = t1.e(z);
        for (int i3 = 0; i3 < iE6; i3++) {
            AbstractC18106o57 abstractC18106o57D = AbstractC18106o57.d(t1, t1.e(z), z);
            if (abstractC18106o57D == null) {
                return;
            }
            this.h.add(abstractC18106o57D);
        }
    }
}
