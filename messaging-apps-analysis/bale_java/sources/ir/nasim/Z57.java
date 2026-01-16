package ir.nasim;

/* loaded from: classes7.dex */
public abstract class Z57 extends AbstractC12724f57 {
    public long b;
    public long c;
    public long d;

    public static Z57 d(T1 t1, int i, boolean z) {
        Z57 c5171Ie7;
        switch (i) {
            case -1649296275:
                c5171Ie7 = new C5171Ie7();
                break;
            case -1566230754:
                c5171Ie7 = new C3752Ce7();
                break;
            case -1160714821:
                c5171Ie7 = new C4454Fe7();
                break;
            case -1109531342:
                c5171Ie7 = new C3986De7();
                break;
            case 918946202:
                c5171Ie7 = new C4220Ee7();
                break;
            case 1498486562:
                c5171Ie7 = new C4937He7();
                break;
            default:
                c5171Ie7 = null;
                break;
        }
        if (c5171Ie7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Peer", Integer.valueOf(i)));
        }
        if (c5171Ie7 != null) {
            c5171Ie7.b(t1, z);
        }
        return c5171Ie7;
    }
}
