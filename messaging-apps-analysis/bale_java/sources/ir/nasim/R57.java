package ir.nasim;

/* loaded from: classes7.dex */
public abstract class R57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public Z57 e;
    public AbstractC13961h67 f;
    public int g;

    public static R57 d(T1 t1, int i, boolean z) {
        R57 c5387Jc7;
        switch (i) {
            case -1938180548:
                c5387Jc7 = new C5387Jc7();
                break;
            case -1826077446:
                c5387Jc7 = new C5621Kc7();
                break;
            case -1319698788:
                c5387Jc7 = new C6088Mc7();
                break;
            case 1370914559:
                c5387Jc7 = new C5855Lc7();
                break;
            default:
                c5387Jc7 = null;
                break;
        }
        if (c5387Jc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessagePeerReaction", Integer.valueOf(i)));
        }
        if (c5387Jc7 != null) {
            c5387Jc7.b(t1, z);
        }
        return c5387Jc7;
    }
}
