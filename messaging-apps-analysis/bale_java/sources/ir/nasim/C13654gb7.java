package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.gb7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C13654gb7 extends M57 {
    public ArrayList F = new ArrayList();

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
            AbstractC16934m67 abstractC16934m67D = AbstractC16934m67.d(t1, t1.e(z), z);
            if (abstractC16934m67D == null) {
                return;
            }
            this.F.add(abstractC16934m67D);
        }
    }
}
