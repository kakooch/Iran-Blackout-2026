package ir.nasim;

/* renamed from: ir.nasim.wi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23315wi7 extends AbstractC12724f57 {
    public long b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long h;
    public String i;
    public AbstractC18106o57 j;
    public AbstractC23905xi7 k;

    public static AbstractC23315wi7 d(T1 t1, int i, boolean z) {
        AbstractC23315wi7 c8051Uh7;
        switch (i) {
            case -1963717851:
                c8051Uh7 = new C8051Uh7();
                break;
            case -1539849235:
                c8051Uh7 = new C7578Sh7();
                break;
            case -528465642:
                c8051Uh7 = new C7815Th7();
                break;
            case -263220756:
                c8051Uh7 = new C9060Yh7();
                break;
            default:
                c8051Uh7 = null;
                break;
        }
        if (c8051Uh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in WallPaper", Integer.valueOf(i)));
        }
        if (c8051Uh7 != null) {
            c8051Uh7.b(t1, z);
        }
        return c8051Uh7;
    }
}
