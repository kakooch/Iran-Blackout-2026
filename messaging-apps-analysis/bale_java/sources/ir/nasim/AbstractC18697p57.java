package ir.nasim;

/* renamed from: ir.nasim.p57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18697p57 extends AbstractC12724f57 {
    public String b;
    public F57 c;
    public double d;
    public int e;
    public C18390oa7 f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public int k;
    public boolean l;
    public String m;
    public String n;
    public boolean o;
    public byte[] p;
    public int q;
    public boolean r;

    public static AbstractC18697p57 d(T1 t1, int i, boolean z) {
        AbstractC18697p57 h77;
        switch (i) {
            case -1744710921:
                h77 = new H77();
                break;
            case -1739392570:
                h77 = new C77();
                break;
            case -1723033470:
                h77 = new L77();
                break;
            case -745541182:
                h77 = new N77();
                break;
            case -556656416:
                h77 = new D77();
                break;
            case -83208409:
                h77 = new M77();
                break;
            case -48981863:
                h77 = new F77();
                break;
            case 85215461:
                h77 = new E77();
                break;
            case 250621158:
                h77 = new O77();
                break;
            case 297109817:
                h77 = new B77();
                break;
            case 358154344:
                h77 = new G77();
                break;
            case 978674434:
                h77 = new K77();
                break;
            case 1494273227:
                h77 = new P77();
                break;
            case 1662637586:
                h77 = new J77();
                break;
            case 1815593308:
                h77 = new I77();
                break;
            default:
                h77 = null;
                break;
        }
        if (h77 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in DocumentAttribute", Integer.valueOf(i)));
        }
        if (h77 != null) {
            h77.b(t1, z);
        }
        return h77;
    }
}
