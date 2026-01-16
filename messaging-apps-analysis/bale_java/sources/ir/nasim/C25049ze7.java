package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.ze7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C25049ze7 extends AbstractC12724f57 {
    public static int c = -524237339;
    public ArrayList b = new ArrayList();

    public static C25049ze7 d(T1 t1, int i, boolean z) {
        if (c != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_pageTableRow", Integer.valueOf(i)));
            }
            return null;
        }
        C25049ze7 c25049ze7 = new C25049ze7();
        c25049ze7.b(t1, z);
        return c25049ze7;
    }

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
            C24455ye7 c24455ye7D = C24455ye7.d(t1, t1.e(z), z);
            if (c24455ye7D == null) {
                return;
            }
            this.b.add(c24455ye7D);
        }
    }
}
