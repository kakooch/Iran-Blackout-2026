package ir.nasim;

/* loaded from: classes7.dex */
public abstract class F57 extends AbstractC12724f57 {
    public long b;
    public long c;
    public String d;

    public static F57 d(T1 t1, int i, boolean z) {
        F57 n97;
        switch (i) {
            case -2044933984:
                n97 = new N97();
                break;
            case -1645763991:
                n97 = new L97();
                break;
            case -930399486:
                n97 = new M97();
                break;
            case -427863538:
                n97 = new G97();
                break;
            case -4838507:
                n97 = new K97();
                break;
            case 42402760:
                n97 = new F97();
                break;
            case 80008398:
                n97 = new J97();
                break;
            case 701560302:
                n97 = new H97();
                break;
            case 1153562857:
                n97 = new I97();
                break;
            default:
                n97 = null;
                break;
        }
        if (n97 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputStickerSet", Integer.valueOf(i)));
        }
        if (n97 != null) {
            n97.b(t1, z);
        }
        return n97;
    }
}
