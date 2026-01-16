package ir.nasim;

/* renamed from: ir.nasim.b67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC10120b67 extends AbstractC12724f57 {
    public static AbstractC10120b67 d(T1 t1, int i, boolean z) {
        AbstractC10120b67 c6106Me7;
        switch (i) {
            case -2048646399:
                c6106Me7 = new C6106Me7();
                break;
            case -527056480:
                c6106Me7 = new C5639Ke7();
                break;
            case -84416311:
                c6106Me7 = new C5405Je7();
                break;
            case 1471006352:
                c6106Me7 = new C5873Le7();
                break;
            default:
                c6106Me7 = null;
                break;
        }
        if (c6106Me7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in PhoneCallDiscardReason", Integer.valueOf(i)));
        }
        if (c6106Me7 != null) {
            c6106Me7.b(t1, z);
        }
        return c6106Me7;
    }
}
