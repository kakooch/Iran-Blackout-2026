package ir.nasim;

/* renamed from: ir.nasim.p77, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C18717p77 extends AbstractC16924m57 {
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
            this.d.add(Long.valueOf(t1.f(z)));
        }
    }
}
