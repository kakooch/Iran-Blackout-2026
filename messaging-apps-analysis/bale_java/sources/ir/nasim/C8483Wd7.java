package ir.nasim;

/* renamed from: ir.nasim.Wd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8483Wd7 extends C8249Vd7 {
    @Override // ir.nasim.C8249Vd7, ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.e = t1.a(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            AbstractC16343l67 abstractC16343l67D = AbstractC16343l67.d(t1, t1.e(z), z);
            if (abstractC16343l67D == null) {
                return;
            }
            C20812se7 c20812se7 = new C20812se7();
            c20812se7.b = abstractC16343l67D;
            this.f.add(c20812se7);
        }
    }
}
