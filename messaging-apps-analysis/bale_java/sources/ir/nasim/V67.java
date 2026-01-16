package ir.nasim;

/* loaded from: classes7.dex */
public class V67 extends AbstractC12724f57 {
    public static int x = -1626209256;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
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
    public int w;

    public static V67 d(T1 t1, int i, boolean z) {
        if (x != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatBannedRights", Integer.valueOf(i)));
            }
            return null;
        }
        V67 v67 = new V67();
        v67.b(t1, z);
        return v67;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        boolean z2 = (iE & 4) != 0;
        this.e = z2;
        this.f = (iE & 8) != 0;
        this.g = (iE & 16) != 0;
        this.h = (iE & 32) != 0;
        this.i = (iE & 64) != 0;
        this.j = (iE & 128) != 0;
        this.k = (iE & 256) != 0;
        this.l = (iE & 1024) != 0;
        this.m = (32768 & iE) != 0;
        this.n = (131072 & iE) != 0;
        this.o = (262144 & iE) != 0;
        this.p = (524288 & iE) != 0;
        this.q = (1048576 & iE) != 0;
        this.r = (2097152 & iE) != 0;
        this.s = (4194304 & iE) != 0;
        this.t = (8388608 & iE) != 0;
        this.u = (16777216 & iE) != 0;
        this.v = (iE & 33554432) != 0;
        if (z2) {
            this.p = true;
            this.q = true;
            this.r = true;
            this.s = true;
            this.t = true;
            this.u = true;
        }
        this.w = t1.e(z);
    }
}
