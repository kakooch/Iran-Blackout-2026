package ir.nasim;

/* loaded from: classes7.dex */
public class U67 extends AbstractC12724f57 {
    public static int o = 1605510357;
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

    public static U67 d(T1 t1, int i, boolean z) {
        if (o != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_chatAdminRights", Integer.valueOf(i)));
            }
            return null;
        }
        U67 u67 = new U67();
        u67.b(t1, z);
        return u67;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        int iE = t1.e(z);
        this.b = iE;
        this.c = (iE & 1) != 0;
        this.d = (iE & 2) != 0;
        this.e = (iE & 4) != 0;
        this.f = (iE & 8) != 0;
        this.g = (iE & 16) != 0;
        this.h = (iE & 32) != 0;
        this.i = (iE & 128) != 0;
        this.j = (iE & 512) != 0;
        this.k = (iE & 1024) != 0;
        this.l = (iE & 2048) != 0;
        this.m = (iE & 4096) != 0;
        this.n = (iE & 8192) != 0;
    }
}
