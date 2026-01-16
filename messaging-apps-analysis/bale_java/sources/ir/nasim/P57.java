package ir.nasim;

/* loaded from: classes7.dex */
public abstract class P57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public Z57 d;
    public String e;
    public int f;
    public int g;
    public String h;
    public Z57 i;
    public int j;
    public String k;

    public static P57 d(T1 t1, int i, boolean z) {
        P57 c10440bc7;
        switch (i) {
            case -947462709:
                c10440bc7 = new C10440bc7();
                break;
            case -332168592:
                c10440bc7 = new C9240Zb7();
                break;
            case -85986132:
                c10440bc7 = new C11030cc7();
                break;
            case 893020267:
                c10440bc7 = new C9820ac7();
                break;
            case 1436466797:
                c10440bc7 = new C11825dc7();
                break;
            case 1601666510:
                c10440bc7 = new C9006Yb7();
                break;
            default:
                c10440bc7 = null;
                break;
        }
        if (c10440bc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageFwdHeader", Integer.valueOf(i)));
        }
        if (c10440bc7 != null) {
            c10440bc7.b(t1, z);
        }
        return c10440bc7;
    }
}
