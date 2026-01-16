package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.m97, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C16964m97 extends C57 {
    public String B;
    public AbstractC12143e67 z;
    public ArrayList A = new ArrayList();
    public ArrayList C = new ArrayList();

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.f = t1.e(z);
        this.z = AbstractC12143e67.d(t1, t1.e(z), z);
        if ((this.f & 1) != 0) {
            int iE = t1.e(z);
            if (iE != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
                }
                return;
            } else {
                int iE2 = t1.e(z);
                for (int i = 0; i < iE2; i++) {
                    this.A.add(t1.c(z));
                }
            }
        }
        if ((this.f & 2) != 0) {
            this.B = t1.g(z);
        }
        if ((this.f & 2) != 0) {
            int iE3 = t1.e(z);
            if (iE3 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE3)));
                }
                return;
            }
            int iE4 = t1.e(z);
            for (int i2 = 0; i2 < iE4; i2++) {
                N57 n57D = N57.d(t1, t1.e(z), z);
                if (n57D == null) {
                    return;
                }
                this.C.add(n57D);
            }
        }
    }
}
