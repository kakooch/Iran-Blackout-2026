package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Yd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C9024Yd7 extends W57 {
    public ArrayList e = new ArrayList();

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
            Y57 y57D = Y57.d(t1, t1.e(z), z);
            if (y57D == null) {
                return;
            }
            this.e.add(y57D);
        }
    }
}
