package ir.nasim;

/* renamed from: ir.nasim.ot8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18581ot8 implements InterfaceC17990nt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.f("measurement.client.sessions.check_on_reset_and_enable2", true);
        b = lp8A.f("measurement.client.sessions.check_on_startup", true);
        c = lp8A.f("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // ir.nasim.InterfaceC17990nt8
    public final boolean c() {
        return ((Boolean) a.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC17990nt8
    public final boolean zza() {
        return true;
    }
}
