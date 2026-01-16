package ir.nasim;

/* loaded from: classes7.dex */
public abstract class Q57 extends AbstractC12724f57 {
    public long A;
    public AbstractC25089zi7 B;
    public String C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public O57 I;
    public boolean J;
    public int K;
    public AbstractC18116o67 L;
    public boolean M;
    public byte[] b;
    public AbstractC13951h57 c;
    public int d;
    public boolean e;
    public AbstractC10736c67 f;
    public AbstractC21765u57 g;
    public int h;
    public String i;
    public String j;
    public int k;
    public long l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public AbstractC22129ui7 r;
    public AbstractC18106o57 s;
    public AbstractC18106o57 t;
    public String u;
    public C21795u87 v;
    public String w;
    public String x;
    public String y;
    public String z;

    public static Q57 d(T1 t1, int i, boolean z) {
        Q57 c22659vc7;
        C16046kc7 c16046kc7;
        switch (i) {
            case -2074799289:
                c22659vc7 = new C22659vc7();
                break;
            case -1666158377:
                c22659vc7 = new C16637lc7();
                break;
            case -1618676578:
                c22659vc7 = new C3734Cc7();
                break;
            case -1563278704:
                c22659vc7 = new C4919Hc7();
                break;
            case -1557277184:
                c22659vc7 = new C5153Ic7();
                break;
            case -1256047857:
                c22659vc7 = new C24435yc7();
                break;
            case -1186937242:
                c22659vc7 = new C20792sc7();
                break;
            case -961117440:
                c22659vc7 = new C12437ec7();
                break;
            case -926655958:
                c22659vc7 = new C25029zc7();
                break;
            case -877523576:
                c22659vc7 = new C3500Bc7();
                break;
            case -873313984:
                c22659vc7 = new C13664gc7();
                break;
            case -203411800:
                c22659vc7 = new C17228mc7();
                break;
            case -156940077:
                c22659vc7 = new C22069uc7();
                break;
            case -38694904:
                c22659vc7 = new C19592qc7();
                break;
            case 694364726:
                c22659vc7 = new C3968Dc7();
                break;
            case 784356159:
                c22659vc7 = new C4202Ec7();
                break;
            case 802824708:
                c22659vc7 = new C18410oc7();
                break;
            case 1032643901:
                c22659vc7 = new C23845xc7();
                break;
            case 1038967584:
                c22659vc7 = new C19001pc7();
                break;
            case 1065280907:
                c22659vc7 = new C14866ic7();
                break;
            case 1272375192:
                c22659vc7 = new C3261Ac7();
                break;
            case 1291114285:
                c22659vc7 = new C16046kc7();
                break;
            case 1457575028:
                c22659vc7 = new C20199rc7();
                break;
            case 1540298357:
                c22659vc7 = new C4685Gc7();
                break;
            case 1585262393:
                c22659vc7 = new C14255hc7();
                break;
            case 1670374507:
                c22659vc7 = new C15455jc7();
                break;
            case 1766936791:
                c22659vc7 = new C23255wc7();
                break;
            case 1882335561:
                c22659vc7 = new C13046fc7();
                break;
            case 2031269663:
                c22659vc7 = new C4436Fc7();
                break;
            case 2084316681:
                c22659vc7 = new C21412tc7();
                break;
            case 2084836563:
                c22659vc7 = new C17819nc7();
                break;
            default:
                c22659vc7 = null;
                break;
        }
        if (c22659vc7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageMedia", Integer.valueOf(i)));
        }
        if (c22659vc7 == null) {
            return c22659vc7;
        }
        c22659vc7.b(t1, z);
        if (c22659vc7.r != null) {
            c16046kc7 = new C16046kc7();
            if (c22659vc7.r instanceof C5198Ih7) {
                R77 r77 = new R77();
                c16046kc7.s = r77;
                AbstractC22129ui7 abstractC22129ui7 = c22659vc7.r;
                r77.n = abstractC22129ui7.n;
                r77.o = abstractC22129ui7.o;
            } else {
                c16046kc7.s = new A77();
            }
            c16046kc7.d = 3;
            AbstractC18106o57 abstractC18106o57 = c16046kc7.s;
            abstractC18106o57.e = new byte[0];
            AbstractC22129ui7 abstractC22129ui72 = c22659vc7.r;
            abstractC18106o57.c = abstractC22129ui72.b;
            abstractC18106o57.d = abstractC22129ui72.c;
            abstractC18106o57.g = abstractC22129ui72.e;
            String str = abstractC22129ui72.l;
            if (str != null) {
                abstractC18106o57.i = str;
            } else {
                abstractC18106o57.i = "video/mp4";
            }
            abstractC18106o57.j = abstractC22129ui72.g;
            abstractC18106o57.k.add(abstractC22129ui72.h);
            c16046kc7.s.m = c22659vc7.r.i;
            c16046kc7.u = c22659vc7.u;
            N77 n77 = new N77();
            AbstractC22129ui7 abstractC22129ui73 = c22659vc7.r;
            n77.j = abstractC22129ui73.j;
            n77.k = abstractC22129ui73.k;
            n77.d = abstractC22129ui73.f;
            c16046kc7.s.p.add(n77);
            if (c16046kc7.u == null) {
                c16046kc7.u = "";
            }
        } else {
            if (c22659vc7.c == null) {
                return c22659vc7;
            }
            c16046kc7 = new C16046kc7();
            if (c22659vc7.c instanceof C19889r67) {
                R77 r772 = new R77();
                c16046kc7.s = r772;
                AbstractC13951h57 abstractC13951h57 = c22659vc7.c;
                r772.n = abstractC13951h57.j;
                r772.o = abstractC13951h57.k;
            } else {
                c16046kc7.s = new A77();
            }
            c16046kc7.d = 3;
            AbstractC18106o57 abstractC18106o572 = c16046kc7.s;
            abstractC18106o572.e = new byte[0];
            AbstractC13951h57 abstractC13951h572 = c22659vc7.c;
            abstractC18106o572.c = abstractC13951h572.b;
            abstractC18106o572.d = abstractC13951h572.c;
            abstractC18106o572.g = abstractC13951h572.d;
            String str2 = abstractC13951h572.f;
            if (str2 != null) {
                abstractC18106o572.i = str2;
            } else {
                abstractC18106o572.i = "audio/ogg";
            }
            abstractC18106o572.j = abstractC13951h572.g;
            C7788Te7 c7788Te7 = new C7788Te7();
            c7788Te7.b = "s";
            c16046kc7.s.k.add(c7788Te7);
            c16046kc7.s.m = c22659vc7.c.h;
            c16046kc7.u = c22659vc7.u;
            C77 c77 = new C77();
            c77.d = c22659vc7.c.e;
            c77.o = true;
            c16046kc7.s.p.add(c77);
            if (c16046kc7.u == null) {
                c16046kc7.u = "";
            }
        }
        return c16046kc7;
    }
}
