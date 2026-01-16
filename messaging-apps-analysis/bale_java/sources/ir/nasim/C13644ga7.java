package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.ga7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13644ga7 extends AbstractC12724f57 {
    public static int c = 2002815875;
    public ArrayList b = new ArrayList();

    public static C13644ga7 d(T1 t1, int i, boolean z) {
        if (c != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_keyboardButtonRow", Integer.valueOf(i)));
            }
            return null;
        }
        C13644ga7 c13644ga7 = new C13644ga7();
        c13644ga7.b(t1, z);
        return c13644ga7;
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
            K57 k57D = K57.d(t1, t1.e(z), z);
            if (k57D == null) {
                return;
            }
            this.b.add(k57D);
        }
    }
}
