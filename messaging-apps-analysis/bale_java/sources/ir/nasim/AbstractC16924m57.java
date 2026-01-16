package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.m57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC16924m57 extends AbstractC12724f57 {
    public int b;
    public int c;
    public ArrayList d = new ArrayList();
    public long e;
    public long f;
    public AbstractC17525n67 g;
    public byte[] h;
    public int i;
    public int j;
    public byte[] k;

    public static AbstractC16924m57 d(T1 t1, int i, boolean z) {
        AbstractC16924m57 c22971w77;
        switch (i) {
            case -1967000459:
                c22971w77 = new C22971w77();
                break;
            case -1586283796:
                c22971w77 = new C23561x77();
                break;
            case -1473258141:
                c22971w77 = new C19899r77();
                break;
            case -860719551:
                c22971w77 = new C24151y77();
                break;
            case -586814357:
                c22971w77 = new C16944m77();
                break;
            case -332526693:
                c22971w77 = new C18126o77();
                break;
            case -217806717:
                c22971w77 = new C20508s77();
                break;
            case -204906213:
                c22971w77 = new C21785u77();
                break;
            case 206520510:
                c22971w77 = new C21111t77();
                break;
            case 1360072880:
                c22971w77 = new C22375v77();
                break;
            case 1700872964:
                c22971w77 = new C18717p77();
                break;
            case 1729750108:
                c22971w77 = new C19308q77();
                break;
            case 1877046107:
                c22971w77 = new C17535n77();
                break;
            default:
                c22971w77 = null;
                break;
        }
        if (c22971w77 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in DecryptedMessageAction", Integer.valueOf(i)));
        }
        if (c22971w77 != null) {
            c22971w77.b(t1, z);
        }
        return c22971w77;
    }
}
