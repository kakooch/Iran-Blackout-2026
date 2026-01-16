package ir.nasim;

/* renamed from: ir.nasim.vg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22699vg7 extends AbstractC18116o67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 32) != 0;
        this.d = (iE & 128) != 0;
        this.e = (iE & 256) != 0;
        this.i = (iE & 512) != 0;
        this.h = (iE & 1024) != 0;
        this.n = (iE & 2048) != 0;
        this.f = (iE & 4096) != 0;
        this.g = (iE & 8192) != 0;
        this.j = t1.e(z);
        this.k = t1.e(z);
        this.l = t1.e(z);
        if ((this.b & 1) != 0) {
            this.m = t1.g(z);
        }
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
                N57 n57D = N57.d(t1, t1.e(z), z);
                if (n57D == null) {
                    return;
                }
                this.o.add(n57D);
            }
        }
        this.p = Q57.d(t1, t1.e(z), z);
        if ((this.b & 4) != 0) {
            int iE4 = t1.e(z);
            if (iE4 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE4)));
                }
                return;
            }
            int iE5 = t1.e(z);
            for (int i2 = 0; i2 < iE5; i2++) {
                AbstractC13370g67 abstractC13370g67D = AbstractC13370g67.d(t1, t1.e(z), z);
                if (abstractC13370g67D == null) {
                    return;
                }
                this.q.add(abstractC13370g67D);
            }
        }
        if ((this.b & 8) != 0) {
            this.r = C24475yg7.d(t1, t1.e(z), z);
        }
    }
}
