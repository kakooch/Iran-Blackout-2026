package ir.nasim;

/* loaded from: classes3.dex */
public final class Gt8 implements Ft8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;
    public static final AbstractC11344cq8 e;
    public static final AbstractC11344cq8 f;
    public static final AbstractC11344cq8 g;
    public static final AbstractC11344cq8 h;
    public static final AbstractC11344cq8 i;
    public static final AbstractC11344cq8 j;
    public static final AbstractC11344cq8 k;
    public static final AbstractC11344cq8 l;
    public static final AbstractC11344cq8 m;
    public static final AbstractC11344cq8 n;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).b().a();
        a = lp8A.f("measurement.redaction.app_instance_id", true);
        b = lp8A.f("measurement.redaction.client_ephemeral_aiid_generation", true);
        c = lp8A.f("measurement.redaction.config_redacted_fields", true);
        d = lp8A.f("measurement.redaction.device_info", true);
        e = lp8A.f("measurement.redaction.e_tag", true);
        f = lp8A.f("measurement.redaction.enhanced_uid", true);
        g = lp8A.f("measurement.redaction.populate_ephemeral_app_instance_id", true);
        h = lp8A.f("measurement.redaction.google_signals", true);
        i = lp8A.f("measurement.redaction.no_aiid_in_config_request", true);
        j = lp8A.f("measurement.redaction.retain_major_os_version", true);
        k = lp8A.f("measurement.redaction.scion_payload_generator", true);
        l = lp8A.f("measurement.redaction.upload_redacted_fields", true);
        m = lp8A.f("measurement.redaction.upload_subdomain_override", true);
        n = lp8A.f("measurement.redaction.user_id", true);
    }

    @Override // ir.nasim.Ft8
    public final boolean c() {
        return ((Boolean) b.b()).booleanValue();
    }

    @Override // ir.nasim.Ft8
    public final boolean d() {
        return ((Boolean) j.b()).booleanValue();
    }

    @Override // ir.nasim.Ft8
    public final boolean e() {
        return ((Boolean) e.b()).booleanValue();
    }

    @Override // ir.nasim.Ft8
    public final boolean g() {
        return ((Boolean) k.b()).booleanValue();
    }

    @Override // ir.nasim.Ft8
    public final boolean zza() {
        return true;
    }
}
