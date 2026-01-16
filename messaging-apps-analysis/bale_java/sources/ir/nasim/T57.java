package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class T57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public int d;
    public int e;
    public ArrayList f = new ArrayList();
    public long g;
    public int h;
    public int i;

    public static T57 d(T1 t1, int i, boolean z) {
        T57 c7299Rc7 = i != -2083123262 ? i != 1093204652 ? null : new C7299Rc7() : new C7065Qc7();
        if (c7299Rc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageReplies", Integer.valueOf(i)));
        }
        if (c7299Rc7 != null) {
            c7299Rc7.b(t1, z);
        }
        return c7299Rc7;
    }
}
