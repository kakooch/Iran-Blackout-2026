package ir.nasim;

/* loaded from: classes7.dex */
public abstract class D57 extends AbstractC12724f57 {
    public D57 b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;

    public static D57 d(T1 t1, int i, boolean z) {
        D57 c21131t97;
        switch (i) {
            case -1667893317:
                c21131t97 = new C21131t97();
                break;
            case -1468331492:
                c21131t97 = new A97();
                break;
            case -1121318848:
                c21131t97 = new C20528s97();
                break;
            case -571955892:
                c21131t97 = new C24761z97();
                break;
            case 396093539:
                c21131t97 = new C22991w97();
                break;
            case 398123750:
                c21131t97 = new B97();
                break;
            case 548253432:
                c21131t97 = new C21805u97();
                break;
            case 666680316:
                c21131t97 = new C19919r97();
                break;
            case 900291769:
                c21131t97 = new C22395v97();
                break;
            case 2072935910:
                c21131t97 = new C97();
                break;
            case 2107670217:
                c21131t97 = new C24171y97();
                break;
            case 2134579434:
                c21131t97 = new C23581x97();
                break;
            default:
                c21131t97 = null;
                break;
        }
        if (c21131t97 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputPeer", Integer.valueOf(i)));
        }
        if (c21131t97 != null) {
            c21131t97.b(t1, z);
        }
        return c21131t97;
    }
}
