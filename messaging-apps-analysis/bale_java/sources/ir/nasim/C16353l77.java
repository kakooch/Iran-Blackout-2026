package ir.nasim;

/* renamed from: ir.nasim.l77, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16353l77 extends AbstractC12724f57 {
    public static int c = 2104790276;
    public String b;

    public static C16353l77 d(T1 t1, int i, boolean z) {
        if (c != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_dataJSON", Integer.valueOf(i)));
            }
            return null;
        }
        C16353l77 c16353l77 = new C16353l77();
        c16353l77.b(t1, z);
        return c16353l77;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
    }
}
