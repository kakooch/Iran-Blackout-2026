package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.ei7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C12497ei7 extends AbstractC3315Ai7 {
    public ArrayList c = new ArrayList();
    public AbstractC19061pi7 d;

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        if ((iE & 1) != 0) {
            int iE2 = t1.e(z);
            if (iE2 != 481674261) {
                if (z) {
                    throw new RuntimeException(String.format("wrong Vector magic, got %x", Integer.valueOf(iE2)));
                }
                return;
            }
            int iE3 = t1.e(z);
            for (int i = 0; i < iE3; i++) {
                AbstractC18106o57 abstractC18106o57D = AbstractC18106o57.d(t1, t1.e(z), z);
                if (abstractC18106o57D == null) {
                    return;
                }
                this.c.add(abstractC18106o57D);
            }
        }
        if ((this.b & 2) != 0) {
            this.d = AbstractC19061pi7.d(t1, t1.e(z), z);
        }
    }
}
