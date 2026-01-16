package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.vd7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C22669vd7 extends AbstractC12724f57 {
    public static int e = -443640366;
    public int b;
    public boolean c;
    public ArrayList d = new ArrayList();

    public static C22669vd7 d(T1 t1, int i, boolean z) {
        if (e != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_messages_deleteMessages", Integer.valueOf(i)));
            }
            return null;
        }
        C22669vd7 c22669vd7 = new C22669vd7();
        c22669vd7.b(t1, z);
        return c22669vd7;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        int iE2 = t1.e(z);
        if (iE2 != 481674261) {
            if (z) {
                throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
            }
        } else {
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                this.d.add(Integer.valueOf(t1.e(z)));
            }
        }
    }
}
