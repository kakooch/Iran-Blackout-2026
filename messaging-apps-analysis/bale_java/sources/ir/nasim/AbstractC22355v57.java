package ir.nasim;

/* renamed from: ir.nasim.v57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22355v57 extends AbstractC12724f57 {
    public static AbstractC22355v57 d(T1 t1, int i, boolean z) {
        AbstractC22355v57 g87;
        switch (i) {
            case -2093215828:
                g87 = new G87();
                break;
            case -681130742:
                g87 = new E87();
                break;
            case 238759180:
                g87 = new C87();
                break;
            case 813821341:
                g87 = new H87();
                break;
            case 1589952067:
                g87 = new F87();
                break;
            case 1664413338:
                g87 = new D87();
                break;
            default:
                g87 = null;
                break;
        }
        if (g87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InlineQueryPeerType", Integer.valueOf(i)));
        }
        if (g87 != null) {
            g87.b(t1, z);
        }
        return g87;
    }
}
