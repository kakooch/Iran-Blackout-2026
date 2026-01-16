package ir.nasim;

/* loaded from: classes7.dex */
public abstract class O57 extends AbstractC12724f57 {
    public static O57 d(T1 t1, int i, boolean z) {
        O57 c7997Ub7 = i != -1386050360 ? i != -297296796 ? null : new C7997Ub7() : new C8231Vb7();
        if (c7997Ub7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in MessageExtendedMedia", Integer.valueOf(i)));
        }
        if (c7997Ub7 != null) {
            c7997Ub7.b(t1, z);
        }
        return c7997Ub7;
    }
}
