package ir.nasim;

/* renamed from: ir.nasim.ef7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12467ef7 extends AbstractC12143e67 {
    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.f(z);
        int iE = t1.e(z);
        this.c = iE;
        this.d = (iE & 1) != 0;
        this.e = (iE & 2) != 0;
        this.f = (iE & 4) != 0;
        this.g = (iE & 8) != 0;
        this.h = t1.g(z);
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            C13103ff7 c13103ff7D = C13103ff7.d(t1, t1.e(z), z);
            if (c13103ff7D == null) {
                return;
            }
            this.i.add(c13103ff7D);
        }
        if ((this.c & 16) != 0) {
            this.j = t1.e(z);
        }
        if ((this.c & 32) != 0) {
            this.k = t1.e(z);
        }
    }
}
