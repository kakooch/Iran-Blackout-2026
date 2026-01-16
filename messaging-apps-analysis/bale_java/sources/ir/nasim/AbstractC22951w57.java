package ir.nasim;

/* renamed from: ir.nasim.w57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22951w57 extends AbstractC12724f57 {
    public long b;
    public long c;

    public static AbstractC22951w57 d(T1 t1, int i, boolean z) {
        AbstractC22951w57 n87;
        switch (i) {
            case -1343524562:
                n87 = new N87();
                break;
            case -292807034:
                n87 = new K87();
                break;
            case -212145112:
                n87 = new J87();
                break;
            case 707290417:
                n87 = new M87();
                break;
            case 1536380829:
                n87 = new L87();
                break;
            default:
                n87 = null;
                break;
        }
        if (n87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputChannel", Integer.valueOf(i)));
        }
        if (n87 != null) {
            n87.b(t1, z);
        }
        return n87;
    }
}
