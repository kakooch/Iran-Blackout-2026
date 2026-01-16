package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.wd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C23265wd7 extends AbstractC12724f57 {
    public static int d = 1504586518;
    public D57 b;
    public ArrayList c = new ArrayList();

    public static C23265wd7 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_deleteScheduledMessages", Integer.valueOf(i)));
            }
            return null;
        }
        C23265wd7 c23265wd7 = new C23265wd7();
        c23265wd7.b(t1, z);
        return c23265wd7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = D57.d(t1, t1.e(z), z);
        int iE = t1.e(z);
        if (iE != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE)));
            }
            return;
        }
        int iE2 = t1.e(z);
        for (int i = 0; i < iE2; i++) {
            this.c.add(Integer.valueOf(t1.e(z)));
        }
    }
}
