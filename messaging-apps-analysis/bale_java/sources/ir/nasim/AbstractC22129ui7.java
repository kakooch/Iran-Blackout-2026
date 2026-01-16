package ir.nasim;

/* renamed from: ir.nasim.ui7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC22129ui7 extends AbstractC12724f57 {
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public int g;
    public AbstractC11500d67 h;
    public int i;
    public int j;
    public int k;
    public String l;
    public String m;
    public byte[] n;
    public byte[] o;

    public static AbstractC22129ui7 d(T1 t1, int i, boolean z) {
        AbstractC22129ui7 c4964Hh7;
        switch (i) {
            case -1056548696:
                c4964Hh7 = new C4964Hh7();
                break;
            case -291550643:
                c4964Hh7 = new C7110Qh7();
                break;
            case -148338733:
                c4964Hh7 = new C6632Oh7();
                break;
            case 948937617:
                c4964Hh7 = new C6866Ph7();
                break;
            case 1431655763:
                c4964Hh7 = new C5198Ih7();
                break;
            case 1510253727:
                c4964Hh7 = new C7344Rh7();
                break;
            default:
                c4964Hh7 = null;
                break;
        }
        if (c4964Hh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Video", Integer.valueOf(i)));
        }
        if (c4964Hh7 != null) {
            c4964Hh7.b(t1, z);
        }
        return c4964Hh7;
    }
}
