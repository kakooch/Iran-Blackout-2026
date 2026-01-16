package ir.nasim;

/* renamed from: ir.nasim.h67, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC13961h67 extends AbstractC12724f57 {
    public static AbstractC13961h67 d(T1 t1, int i, boolean z) {
        AbstractC13961h67 c3527Bf7 = i != -1992950669 ? i != 455247544 ? i != 2046153753 ? null : new C3527Bf7() : new C3288Af7() : new C25059zf7();
        if (c3527Bf7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Reaction", Integer.valueOf(i)));
        }
        if (c3527Bf7 != null) {
            c3527Bf7.b(t1, z);
        }
        return c3527Bf7;
    }
}
