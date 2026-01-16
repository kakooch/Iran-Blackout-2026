package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public class S67 extends AbstractC12724f57 {
    public static int d = -2067661490;
    public AbstractC22951w57 b;
    public ArrayList c = new ArrayList();

    public static S67 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_channels_deleteMessages", Integer.valueOf(i)));
            }
            return null;
        }
        S67 s67 = new S67();
        s67.b(t1, z);
        return s67;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = AbstractC22951w57.d(t1, t1.e(z), z);
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
