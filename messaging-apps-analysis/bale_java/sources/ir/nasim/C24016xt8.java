package ir.nasim;

/* renamed from: ir.nasim.xt8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24016xt8 implements InterfaceC23426wt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.d("measurement.id.lifecycle.app_in_background_parameter", 0L);
        b = lp8A.f("measurement.lifecycle.app_backgrounded_tracking", true);
        c = lp8A.f("measurement.lifecycle.app_in_background_parameter", false);
        d = lp8A.d("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // ir.nasim.InterfaceC23426wt8
    public final boolean zza() {
        return ((Boolean) c.b()).booleanValue();
    }
}
