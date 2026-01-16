package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Ld7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C5864Ld7 extends W57 {
    public int e;
    public boolean f;
    public ArrayList g = new ArrayList();
    public AbstractC16343l67 h;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.f = (iE & 1) != 0;
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            W57 w57D = W57.d(t1, t1.e(z), z);
            if (w57D == null) {
                return;
            }
            this.g.add(w57D);
        }
        this.h = AbstractC16343l67.d(t1, t1.e(z), z);
    }
}
