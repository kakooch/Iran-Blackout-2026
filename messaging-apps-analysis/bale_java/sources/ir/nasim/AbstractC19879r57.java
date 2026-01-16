package ir.nasim;

/* renamed from: ir.nasim.r57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19879r57 extends AbstractC12724f57 {
    public int A;
    public long B;
    public byte[] C;
    public int b;
    public int c;
    public int d;
    public long e;
    public int f;
    public long g;
    public long h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public long l;
    public boolean m;
    public byte[] n;
    public byte[] o;
    public long p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public byte[] w;
    public short x;
    public short y;
    public long z;

    public static AbstractC19879r57 d(T1 t1, int i, boolean z) {
        AbstractC19879r57 c12754f87;
        switch (i) {
            case -1417756512:
                c12754f87 = new C12754f87();
                break;
            case -931638658:
                c12754f87 = new C13981h87();
                break;
            case -94974410:
                c12754f87 = new C16954m87();
                break;
            case -39213129:
                c12754f87 = new C15181j87();
                break;
            case 332848423:
                c12754f87 = new C12163e87();
                break;
            case 505183301:
                c12754f87 = new C11520d87();
                break;
            case 1006044124:
                c12754f87 = new C16363l87();
                break;
            case 1223809356:
                c12754f87 = new C13390g87();
                break;
            case 1643173063:
                c12754f87 = new C10756c87();
                break;
            case 1651608194:
                c12754f87 = new C14579i87();
                break;
            case 1711395151:
                c12754f87 = new C17545n87();
                break;
            case 1722964307:
                c12754f87 = new C15772k87();
                break;
            default:
                c12754f87 = null;
                break;
        }
        if (c12754f87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in EncryptedChat", Integer.valueOf(i)));
        }
        if (c12754f87 != null) {
            c12754f87.b(t1, z);
        }
        return c12754f87;
    }
}
