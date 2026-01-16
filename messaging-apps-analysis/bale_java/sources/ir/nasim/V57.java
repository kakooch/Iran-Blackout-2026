package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes7.dex */
public abstract class V57 extends AbstractC12724f57 {
    public int b;
    public boolean c;
    public boolean d;
    public String e;
    public ArrayList f = new ArrayList();
    public ArrayList g = new ArrayList();
    public ArrayList h = new ArrayList();
    public boolean i;
    public int j;

    public static V57 d(T1 t1, int i, boolean z) {
        V57 c22679ve7;
        switch (i) {
            case -1913754556:
                c22679ve7 = new C22679ve7();
                break;
            case -1908433218:
                c22679ve7 = new C23275we7();
                break;
            case -1738178803:
                c22679ve7 = new C3270Ad7();
                break;
            case -1366746132:
                c22679ve7 = new C3279Ae7();
                break;
            case -677274263:
                c22679ve7 = new C19021pe7();
                break;
            case 1433323434:
                c22679ve7 = new C19612qe7();
                break;
            default:
                c22679ve7 = null;
                break;
        }
        if (c22679ve7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Page", Integer.valueOf(i)));
        }
        if (c22679ve7 != null) {
            c22679ve7.b(t1, z);
        }
        return c22679ve7;
    }
}
