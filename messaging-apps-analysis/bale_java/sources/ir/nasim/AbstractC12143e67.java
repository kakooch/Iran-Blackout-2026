package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.e67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12143e67 extends AbstractC12724f57 {
    public long b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public String h;
    public ArrayList i = new ArrayList();
    public int j;
    public int k;

    public static AbstractC12143e67 d(T1 t1, int i, boolean z) {
        AbstractC12143e67 c17258mf7 = i != -2032041631 ? i != -1351325818 ? i != -716006138 ? null : new C17258mf7() : new C17849nf7() : new C12467ef7();
        if (c17258mf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Poll", Integer.valueOf(i)));
        }
        if (c17258mf7 != null) {
            c17258mf7.b(t1, z);
        }
        return c17258mf7;
    }
}
