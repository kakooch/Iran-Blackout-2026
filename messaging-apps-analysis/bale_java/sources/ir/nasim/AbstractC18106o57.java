package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.o57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18106o57 extends AbstractC12724f57 {
    public int b;
    public long c;
    public long d;
    public byte[] e;
    public long f;
    public int g;
    public String h;
    public String i;
    public long j;
    public int m;
    public byte[] n;
    public byte[] o;
    public String q;
    public String r;
    public ArrayList k = new ArrayList();
    public ArrayList l = new ArrayList();
    public ArrayList p = new ArrayList();

    public static AbstractC18106o57 d(T1 t1, int i, boolean z) {
        AbstractC18106o57 w77;
        switch (i) {
            case -2027738169:
                w77 = new W77();
                break;
            case -1881881384:
                w77 = new A77();
                break;
            case -1683841855:
                w77 = new T77();
                break;
            case -1627626714:
                w77 = new Y77();
                break;
            case -106717361:
                w77 = new V77();
                break;
            case 512177195:
                w77 = new U77();
                break;
            case 922273905:
                w77 = new Q77();
                break;
            case 1431655766:
                w77 = new S77();
                break;
            case 1431655768:
                w77 = new R77();
                break;
            case 1498631756:
                w77 = new X77();
                break;
            default:
                w77 = null;
                break;
        }
        if (w77 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Document", Integer.valueOf(i)));
        }
        if (w77 != null) {
            w77.b(t1, z);
            w77.q = C4278El2.C(w77);
        }
        return w77;
    }
}
