package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.Ue7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C8024Ue7 extends AbstractC11500d67 {
    public static int i = -96535659;
    public ArrayList h = new ArrayList();

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.g(z);
        this.d = t1.e(z);
        this.e = t1.e(z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i2 = 0; i2 < iE2; i2++) {
            this.h.add(Integer.valueOf(t1.e(z)));
        }
        if (this.h.isEmpty()) {
            return;
        }
        this.f = ((Integer) this.h.get(r5.size() - 1)).intValue();
    }

    @Override // ir.nasim.AbstractC12724f57
    public void c(T1 t1) {
        t1.m(i);
        t1.o(this.b);
        t1.m(this.d);
        t1.m(this.e);
        t1.m(481674261);
        int size = this.h.size();
        t1.m(size);
        for (int i2 = 0; i2 < size; i2++) {
            t1.m(((Integer) this.h.get(i2)).intValue());
        }
    }
}
