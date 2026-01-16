package ir.nasim;

/* renamed from: ir.nasim.wa7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23235wa7 extends M57 {
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
            this.f.add(Long.valueOf(t1.f(z)));
        }
    }
}
