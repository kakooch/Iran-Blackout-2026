package ir.nasim;

/* renamed from: ir.nasim.Oc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C6582Oc7 extends C6327Nc7 {
    @Override // ir.nasim.C6327Nc7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 4) != 0;
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            AbstractC14559i67 abstractC14559i67D = AbstractC14559i67.d(t1, t1.e(z), z);
            if (abstractC14559i67D == null) {
                return;
            }
            this.e.add(abstractC14559i67D);
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
                R57 r57D = R57.d(t1, t1.e(z), z);
                if (r57D == null) {
                    return;
                }
                this.f.add(r57D);
            }
        }
    }
}
