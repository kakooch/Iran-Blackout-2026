package ir.nasim;

/* renamed from: ir.nasim.u57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21765u57 extends AbstractC12724f57 {
    public int b;
    public double c;
    public double d;
    public int e;
    public long f;

    public static AbstractC21765u57 d(T1 t1, int i, boolean z) {
        AbstractC21765u57 c22385v87;
        switch (i) {
            case -1297942941:
                c22385v87 = new C22385v87();
                break;
            case 43446532:
                c22385v87 = new C23571x87();
                break;
            case 286776671:
                c22385v87 = new C22981w87();
                break;
            case 541710092:
                c22385v87 = new C24161y87();
                break;
            default:
                c22385v87 = null;
                break;
        }
        if (c22385v87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in GeoPoint", Integer.valueOf(i)));
        }
        if (c22385v87 != null) {
            c22385v87.b(t1, z);
        }
        return c22385v87;
    }
}
