package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.qi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC19652qi7 extends AbstractC12724f57 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean L;
    public boolean M;
    public AbstractC19288q57 N;
    public int P;
    public long b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;
    public AbstractC20852si7 h;
    public AbstractC21539ti7 i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;
    public ArrayList K = new ArrayList();
    public ArrayList O = new ArrayList();

    public static AbstractC19652qi7 d(T1 t1, int i, boolean z) {
        AbstractC19652qi7 c4013Dh7;
        switch (i) {
            case -1885878744:
                c4013Dh7 = new C4013Dh7();
                break;
            case -1820043071:
                c4013Dh7 = new C3306Ah7();
                break;
            case -1414139616:
                c4013Dh7 = new C8776Xg7();
                break;
            case -1298475060:
                c4013Dh7 = new C10490bh7();
                break;
            case -894214632:
                c4013Dh7 = new C9051Yg7();
                break;
            case -787638374:
                c4013Dh7 = new C4247Eh7();
                break;
            case -742634630:
                c4013Dh7 = new C11080ch7();
                break;
            case -704549510:
                c4013Dh7 = new C9870ah7();
                break;
            case -640891665:
                c4013Dh7 = new C17869nh7();
                break;
            case -218397927:
                c4013Dh7 = new C9285Zg7();
                break;
            case 123533224:
                c4013Dh7 = new C12487eh7();
                break;
            case 476112392:
                c4013Dh7 = new C19642qh7();
                break;
            case 537022650:
                c4013Dh7 = new C11875dh7();
                break;
            case 585404530:
                c4013Dh7 = new C4481Fh7();
                break;
            case 585682608:
                c4013Dh7 = new C18460oh7();
                break;
            case 773059779:
                c4013Dh7 = new C25079zh7();
                break;
            case 1073147056:
                c4013Dh7 = new C3545Bh7();
                break;
            case 1377093789:
                c4013Dh7 = new C13123fh7();
                break;
            case 1570352622:
                c4013Dh7 = new C3779Ch7();
                break;
            case 1879553105:
                c4013Dh7 = new C19051ph7();
                break;
            case 1912944108:
                c4013Dh7 = new C20249rh7();
                break;
            default:
                c4013Dh7 = null;
                break;
        }
        if (c4013Dh7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in User", Integer.valueOf(i)));
        }
        if (c4013Dh7 != null) {
            c4013Dh7.b(t1, z);
        }
        return c4013Dh7;
    }
}
