package ir.nasim;

/* renamed from: ir.nasim.xi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23905xi7 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public static AbstractC23905xi7 d(T1 t1, int i, boolean z) {
        AbstractC23905xi7 c8285Vh7 = i != -1590738760 ? i != 84438264 ? i != 499236004 ? null : new C8285Vh7() : new C8785Xh7() : new C8519Wh7();
        if (c8285Vh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaperSettings", Integer.valueOf(i)));
        }
        if (c8285Vh7 != null) {
            c8285Vh7.b(t1, z);
        }
        return c8285Vh7;
    }
}
