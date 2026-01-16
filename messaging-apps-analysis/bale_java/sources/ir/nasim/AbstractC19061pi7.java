package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.pi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19061pi7 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public AbstractC14549i57 d;
    public int e;
    public int f;
    public ArrayList g = new ArrayList();
    public AbstractC23315wi7 h;

    public static AbstractC19061pi7 d(T1 t1, int i, boolean z) {
        AbstractC19061pi7 c7335Rg7 = i != -1917524116 ? i != -1676371894 ? i != -94849324 ? null : new C7335Rg7() : new C7569Sg7() : new C7806Tg7();
        if (c7335Rg7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in ThemeSettings", Integer.valueOf(i)));
        }
        if (c7335Rg7 != null) {
            c7335Rg7.b(t1, z);
        }
        return c7335Rg7;
    }
}
