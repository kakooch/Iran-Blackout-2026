package ir.nasim;

/* renamed from: ir.nasim.Bi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3554Bi7 extends AbstractC12724f57 {
    public static AbstractC3554Bi7 d(T1 t1, int i, boolean z) {
        AbstractC3554Bi7 c24751z87 = i != -1000708810 ? i != -860107216 ? null : new C24751z87() : new A87();
        if (c24751z87 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in help_AppUpdate", Integer.valueOf(i)));
        }
        if (c24751z87 != null) {
            c24751z87.b(t1, z);
        }
        return c24751z87;
    }
}
