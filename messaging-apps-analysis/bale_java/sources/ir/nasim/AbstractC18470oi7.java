package ir.nasim;

/* renamed from: ir.nasim.oi7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC18470oi7 extends AbstractC12724f57 {
    public static C6857Pg7 d(T1 t1, int i, boolean z) {
        C6857Pg7 c6857Pg7;
        switch (i) {
            case -1609668650:
                c6857Pg7 = new C6857Pg7();
                break;
            case -402474788:
                c6857Pg7 = new C8510Wg7();
                break;
            case -136770336:
                c6857Pg7 = new C8042Ug7();
                break;
            case 42930452:
                c6857Pg7 = new C8276Vg7();
                break;
            case 1211967244:
                c6857Pg7 = new C7101Qg7();
                break;
            default:
                c6857Pg7 = null;
                break;
        }
        if (c6857Pg7 == null && z) {
            throw new RuntimeException(String.format("can't parse magic %x in Theme", Integer.valueOf(i)));
        }
        if (c6857Pg7 != null) {
            c6857Pg7.b(t1, z);
        }
        return c6857Pg7;
    }
}
