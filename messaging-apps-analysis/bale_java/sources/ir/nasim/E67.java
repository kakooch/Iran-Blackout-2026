package ir.nasim;

/* loaded from: classes7.dex */
public class E67 extends AbstractC12724f57 {
    public static int l = 1489977929;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;

    public static E67 d(T1 t1, int i, boolean z) {
        if (l != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_channelBannedRights_layer92", Integer.valueOf(i)));
            }
            return null;
        }
        E67 e67 = new E67();
        e67.b(t1, z);
        return e67;
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
        this.i = (iE & 64) != 0;
        this.j = (iE & 128) != 0;
        this.k = t1.e(z);
    }
}
