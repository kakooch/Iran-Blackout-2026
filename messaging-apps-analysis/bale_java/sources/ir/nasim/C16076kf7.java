package ir.nasim;

/* renamed from: ir.nasim.kf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16076kf7 extends C14285hf7 {
    @Override // ir.nasim.C14285hf7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        if ((iE & 2) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                C13694gf7 c13694gf7D = C13694gf7.d(t1, t1.e(z), z);
                if (c13694gf7D == null) {
                    return;
                }
                this.d.add(c13694gf7D);
            }
        }
        if ((this.b & 4) != 0) {
            this.e = t1.e(z);
        }
        if ((this.b & 8) != 0) {
            int iE4 = t1.e(z);
            if (iE4 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE4)));
                }
                return;
            }
            int iE5 = t1.e(z);
            for (int i2 = 0; i2 < iE5; i2++) {
                C4937He7 c4937He7 = new C4937He7();
                c4937He7.b = t1.e(z);
                this.f.add(c4937He7);
            }
        }
        if ((this.b & 16) != 0) {
            this.g = t1.g(z);
        }
        if ((this.b & 16) != 0) {
            int iE6 = t1.e(z);
            if (iE6 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE6)));
                }
                return;
            }
            int iE7 = t1.e(z);
            for (int i3 = 0; i3 < iE7; i3++) {
                N57 n57D = N57.d(t1, t1.e(z), z);
                if (n57D == null) {
                    return;
                }
                this.h.add(n57D);
            }
        }
    }
}
