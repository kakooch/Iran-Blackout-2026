package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.k57, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15742k57 extends AbstractC12724f57 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public D67 J;
    public E67 K;
    public U67 L;
    public V67 M;
    public V67 N;
    public AbstractC22951w57 O;
    public boolean P;
    public boolean Q;
    public long b;
    public String c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public AbstractC16333l57 m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public long r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public String x;
    public boolean y;
    public boolean z;
    public ArrayList I = new ArrayList();
    public ArrayList R = new ArrayList();

    public static AbstractC15742k57 d(T1 t1, int i, boolean z) {
        return e(t1, i, z, true);
    }

    public static AbstractC15742k57 e(T1 t1, int i, boolean z, boolean z2) {
        AbstractC15742k57 l67;
        switch (i) {
            case -2107528095:
                l67 = new L67();
                break;
            case -2094689180:
                l67 = new C67();
                break;
            case -2059962289:
                l67 = new I67();
                break;
            case -1683826688:
                l67 = new X67();
                break;
            case -1588737454:
                l67 = new N67();
                break;
            case -930515796:
                l67 = new Q67();
                break;
            case -753232354:
                l67 = new K67();
                break;
            case -652419756:
                l67 = new C14569i77();
                break;
            case -83047359:
                l67 = new C9536a77();
                break;
            case 120753115:
                l67 = new Z67();
                break;
            case 213142300:
                l67 = new O67();
                break;
            case 399807445:
                l67 = new F67();
                break;
            case 681420594:
                l67 = new G67();
                break;
            case 693512293:
                l67 = new W67();
                break;
            case 763724588:
                l67 = new H67();
                break;
            case 1004149726:
                l67 = new C13971h77();
                break;
            case 1103884886:
                l67 = new T67();
                break;
            case 1158377749:
                l67 = new P67();
                break;
            case 1260090630:
                l67 = new M67();
                break;
            case 1307772980:
                l67 = new J67();
                break;
            case 1704108455:
                l67 = new Y67();
                break;
            case 1737397639:
                l67 = new R67();
                break;
            case 1855757255:
                l67 = new C15762k77();
                break;
            case 1930607688:
                l67 = new C15171j77();
                break;
            default:
                l67 = null;
                break;
        }
        if (l67 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Chat", Integer.valueOf(i)));
        }
        if (l67 != null) {
            l67.h(t1, z, z2);
        }
        return l67;
    }

    protected static U67 f(D67 d67) {
        if (d67 == null) {
            return null;
        }
        U67 u67 = new U67();
        u67.c = d67.c;
        u67.d = d67.d;
        u67.e = d67.e;
        u67.f = d67.f;
        u67.g = d67.g;
        u67.h = d67.h;
        u67.i = d67.i;
        u67.j = d67.j;
        return u67;
    }

    protected static V67 g(E67 e67) {
        if (e67 == null) {
            return null;
        }
        V67 v67 = new V67();
        v67.c = e67.c;
        v67.d = e67.d;
        boolean z = e67.e;
        v67.e = z;
        v67.f = e67.f;
        v67.g = e67.g;
        v67.h = e67.h;
        v67.i = e67.i;
        v67.j = e67.j;
        v67.k = z;
        v67.l = true;
        v67.m = true;
        v67.n = true;
        v67.w = e67.k;
        return v67;
    }

    private void h(T1 t1, boolean z, boolean z2) {
        b(t1, z);
    }
}
