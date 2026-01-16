package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.o67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18116o67 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public String m;
    public boolean n;
    public Q57 p;
    public C24475yg7 r;
    public ArrayList o = new ArrayList();
    public ArrayList q = new ArrayList();

    public static AbstractC18116o67 d(T1 t1, int i, boolean z) {
        AbstractC18116o67 c22699vg7 = i != -5388013 ? i != 1374088783 ? i != 1445635639 ? null : new C22699vg7() : new C23295wg7() : new C23885xg7();
        if (c22699vg7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in StoryItem", Integer.valueOf(i)));
        }
        if (c22699vg7 != null) {
            c22699vg7.b(t1, z);
        }
        return c22699vg7;
    }
}
