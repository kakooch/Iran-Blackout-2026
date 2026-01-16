package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.yg7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C24475yg7 extends AbstractC12724f57 {
    public static int e = -748199729;
    public int b;
    public int c;
    public ArrayList d = new ArrayList();

    public static C24475yg7 d(T1 t1, int i, boolean z) {
        if (e != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_storyViews", Integer.valueOf(i)));
            }
            return null;
        }
        C24475yg7 c24475yg7 = new C24475yg7();
        c24475yg7.b(t1, z);
        return c24475yg7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = t1.e(z);
        this.c = t1.e(z);
        if ((this.b & 1) != 0) {
            int iE = t1.e(z);
            if (iE != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
                }
                return;
            }
            int iE2 = t1.e(z);
            for (int i = 0; i < iE2; i++) {
                this.d.add(Long.valueOf(t1.f(z)));
            }
        }
    }
}
