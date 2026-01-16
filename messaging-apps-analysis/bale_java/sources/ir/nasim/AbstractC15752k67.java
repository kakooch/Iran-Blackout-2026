package ir.nasim;

/* renamed from: ir.nasim.k67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC15752k67 extends AbstractC12724f57 {
    public int b;
    public Boolean c;
    public U67 d;
    public U67 e;
    public Boolean f;
    public Boolean g;
    public Boolean h;

    public static AbstractC15752k67 d(T1 t1, int i, boolean z) {
        AbstractC15752k67 c5648Kf7 = i != -906990053 ? i != 865857388 ? i != 1597737472 ? null : new C5648Kf7() : new C5180If7() : new C5414Jf7();
        if (c5648Kf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in RequestPeerType", Integer.valueOf(i)));
        }
        if (c5648Kf7 != null) {
            c5648Kf7.b(t1, z);
        }
        return c5648Kf7;
    }
}
