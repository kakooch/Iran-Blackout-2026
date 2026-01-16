package ir.nasim;

/* loaded from: classes3.dex */
public final class Yt8 implements Xt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;
    public static final AbstractC11344cq8 e;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).b().a();
        a = lp8A.f("measurement.collection.enable_session_stitching_token.client.dev", true);
        b = lp8A.f("measurement.session_stitching_token_enabled", false);
        c = lp8A.f("measurement.collection.enable_session_stitching_token.service", false);
        d = lp8A.f("measurement.collection.enable_session_stitching_token.service_new", true);
        e = lp8A.d("measurement.id.collection.enable_session_stitching_token.client.dev", 0L);
    }

    @Override // ir.nasim.Xt8
    public final boolean c() {
        return ((Boolean) a.b()).booleanValue();
    }

    @Override // ir.nasim.Xt8
    public final boolean d() {
        return ((Boolean) c.b()).booleanValue();
    }

    @Override // ir.nasim.Xt8
    public final boolean e() {
        return ((Boolean) b.b()).booleanValue();
    }

    @Override // ir.nasim.Xt8
    public final boolean g() {
        return ((Boolean) d.b()).booleanValue();
    }

    @Override // ir.nasim.Xt8
    public final boolean zza() {
        return true;
    }
}
