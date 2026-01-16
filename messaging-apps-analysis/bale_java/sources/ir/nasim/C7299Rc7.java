package ir.nasim;

/* renamed from: ir.nasim.Rc7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C7299Rc7 extends C7065Qc7 {
    @Override // ir.nasim.C7065Qc7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = t1.e(z);
        this.e = t1.e(z);
        if ((this.b & 2) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                Z57 z57D = Z57.d(t1, t1.e(z), z);
                if (z57D == null) {
                    return;
                }
                this.f.add(z57D);
            }
        }
        if ((this.b & 1) != 0) {
            this.g = t1.e(z);
        }
        if ((this.b & 4) != 0) {
            this.h = t1.e(z);
        }
        if ((this.b & 8) != 0) {
            this.i = t1.e(z);
        }
    }
}
