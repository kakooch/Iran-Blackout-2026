package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.te7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C21432te7 extends Y57 {
    public String b;
    public ArrayList c = new ArrayList();

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            W57 w57D = W57.d(t1, t1.e(z), z);
            if (w57D == null) {
                return;
            }
            this.c.add(w57D);
        }
    }
}
