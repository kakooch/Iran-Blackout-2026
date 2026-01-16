package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class S57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public ArrayList e = new ArrayList();
    public ArrayList f = new ArrayList();

    public static C6327Nc7 d(T1 t1, int i, boolean z) {
        C6327Nc7 c6327Nc7 = i != -1199954735 ? i != 142306870 ? i != 1328256121 ? null : new C6327Nc7() : new C6582Oc7() : new C6821Pc7();
        if (c6327Nc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageReactions", Integer.valueOf(i)));
        }
        if (c6327Nc7 != null) {
            c6327Nc7.b(t1, z);
        }
        return c6327Nc7;
    }
}
