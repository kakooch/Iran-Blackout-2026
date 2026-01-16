package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.ee7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12457ee7 extends W57 {
    public AbstractC16343l67 e;
    public ArrayList f = new ArrayList();

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.e = AbstractC16343l67.d(t1, t1.e(z), z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            C23865xe7 c23865xe7D = C23865xe7.d(t1, t1.e(z), z);
            if (c23865xe7D == null) {
                return;
            }
            this.f.add(c23865xe7D);
        }
    }
}
