package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.yi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC24495yi7 extends AbstractC12724f57 {
    public String b;
    public long c;
    public int d;
    public String e;
    public ArrayList f = new ArrayList();

    public static AbstractC24495yi7 d(T1 t1, int i, boolean z) {
        AbstractC24495yi7 c9294Zh7 = i != -971322408 ? i != -104284986 ? i != 475467473 ? null : new C9294Zh7() : new C9880ai7() : new C10500bi7();
        if (c9294Zh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WebDocument", Integer.valueOf(i)));
        }
        if (c9294Zh7 != null) {
            c9294Zh7.b(t1, z);
        }
        return c9294Zh7;
    }
}
