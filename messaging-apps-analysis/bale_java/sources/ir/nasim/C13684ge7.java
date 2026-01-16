package ir.nasim;

/* renamed from: ir.nasim.ge7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13684ge7 extends C13066fe7 {
    @Override // ir.nasim.C13066fe7, ir.nasim.AbstractC12724f57
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
            this.e.add(w57D);
        }
        C18430oe7 c18430oe7 = new C18430oe7();
        this.f = c18430oe7;
        c18430oe7.b = AbstractC16343l67.d(t1, t1.e(z), z);
        this.f.c = new C4004Dg7();
    }
}
