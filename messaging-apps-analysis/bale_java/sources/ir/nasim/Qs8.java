package ir.nasim;

/* loaded from: classes3.dex */
public final class Qs8 implements Ps8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).b().a();
        a = lp8A.f("measurement.collection.event_safelist", true);
        b = lp8A.f("measurement.service.store_null_safelist", true);
        c = lp8A.f("measurement.service.store_safelist", true);
    }

    @Override // ir.nasim.Ps8
    public final boolean c() {
        return ((Boolean) b.b()).booleanValue();
    }

    @Override // ir.nasim.Ps8
    public final boolean e() {
        return ((Boolean) c.b()).booleanValue();
    }

    @Override // ir.nasim.Ps8
    public final boolean zza() {
        return true;
    }
}
