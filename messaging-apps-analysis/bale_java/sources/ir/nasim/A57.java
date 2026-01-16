package ir.nasim;

/* loaded from: classes7.dex */
public abstract class A57 extends AbstractC12724f57 {
    public G57 b;
    public String c;
    public long d;
    public long e;

    public static A57 d(T1 t1, int i, boolean z) {
        A57 v87 = i != -1020139510 ? i != 53231223 ? null : new V87() : new W87();
        if (v87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in InputGame", Integer.valueOf(i)));
        }
        if (v87 != null) {
            v87.b(t1, z);
        }
        return v87;
    }
}
