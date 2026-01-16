package ir.nasim;

/* renamed from: ir.nasim.rt8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C20372rt8 implements InterfaceC19763qt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;
    public static final AbstractC11344cq8 e;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).b().a();
        a = lp8A.f("measurement.client.global_params", true);
        b = lp8A.f("measurement.service.global_params_in_payload", true);
        c = lp8A.f("measurement.service.clear_global_params_on_uninstall", true);
        d = lp8A.f("measurement.service.global_params", true);
        e = lp8A.d("measurement.id.service.global_params", 0L);
    }

    @Override // ir.nasim.InterfaceC19763qt8
    public final boolean c() {
        return ((Boolean) c.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC19763qt8
    public final boolean zza() {
        return true;
    }
}
