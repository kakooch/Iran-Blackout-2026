package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.je7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C15475je7 extends W57 {
    public int e;
    public boolean f;
    public boolean g;
    public AbstractC16343l67 h;
    public ArrayList i = new ArrayList();

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.e = iE;
        this.f = (iE & 1) != 0;
        this.g = (iE & 2) != 0;
        this.h = AbstractC16343l67.d(t1, t1.e(z), z);
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
            return;
        }
        int iE3 = t1.e(z);
        for (int i = 0; i < iE3; i++) {
            C25049ze7 c25049ze7D = C25049ze7.d(t1, t1.e(z), z);
            if (c25049ze7D == null) {
                return;
            }
            this.i.add(c25049ze7D);
        }
    }
}
