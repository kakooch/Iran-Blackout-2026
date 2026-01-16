package ir.nasim;

/* loaded from: classes7.dex */
public class U87 extends AbstractC12724f57 {
    public static int d = -70073706;
    public D57 b;
    public int c;

    public static U87 d(T1 t1, int i, boolean z) {
        if (d != i) {
            if (z) {
                throw new RuntimeException(String.format("can't parse magic %x in TL_inputFolderPeer", Integer.valueOf(i)));
            }
            return null;
        }
        U87 u87 = new U87();
        u87.b(t1, z);
        return u87;
    }

    @Override // ir.nasim.AbstractC12724f57
    public void b(T1 t1, boolean z) {
        this.b = D57.d(t1, t1.e(z), z);
        this.c = t1.e(z);
    }
}
