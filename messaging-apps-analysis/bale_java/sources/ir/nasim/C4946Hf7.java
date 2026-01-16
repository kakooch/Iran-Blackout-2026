package ir.nasim;

/* renamed from: ir.nasim.Hf7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C4946Hf7 extends C4712Gf7 {
    @Override // ir.nasim.C4712Gf7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.f = (iE & 4) != 0;
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            C13644ga7 c13644ga7D = C13644ga7.d(t1, t1.e(z), z);
            if (c13644ga7D == null) {
                return;
            }
            this.h.add(c13644ga7D);
        }
    }
}
