package ir.nasim;

/* renamed from: ir.nasim.s57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC20488s57 extends AbstractC12724f57 {
    public int b;
    public long c;
    public int d;
    public long e;
    public byte[] f;
    public byte[] g;
    public byte[] h;

    public static AbstractC20488s57 d(T1 t1, int i, boolean z) {
        AbstractC20488s57 c18727p87;
        switch (i) {
            case -1132476723:
                c18727p87 = new C18727p87();
                break;
            case 152900075:
                c18727p87 = new C20518s87();
                break;
            case 1406570614:
                c18727p87 = new C19909r87();
                break;
            case 1431655764:
                c18727p87 = new C18136o87();
                break;
            case 2086234950:
                c18727p87 = new C19318q87();
                break;
            default:
                c18727p87 = null;
                break;
        }
        if (c18727p87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in FileLocation", Integer.valueOf(i)));
        }
        if (c18727p87 != null) {
            c18727p87.b(t1, z);
        }
        return c18727p87;
    }
}
