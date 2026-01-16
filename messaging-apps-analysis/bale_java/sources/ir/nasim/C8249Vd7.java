package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Vd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8249Vd7 extends W57 {
    public boolean e;
    public ArrayList f = new ArrayList();

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
            X57 x57D = X57.d(t1, t1.e(z), z);
            if (x57D == null) {
                return;
            }
            this.f.add(x57D);
        }
    }
}
