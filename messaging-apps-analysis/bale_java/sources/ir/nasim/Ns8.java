package ir.nasim;

/* loaded from: classes3.dex */
public final class Ns8 implements Ms8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.f("measurement.client.consent_state_v1", true);
        b = lp8A.f("measurement.client.3p_consent_state_v1", true);
        c = lp8A.f("measurement.service.consent_state_v1_W36", true);
        d = lp8A.d("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // ir.nasim.Ms8
    public final long zza() {
        return ((Long) d.b()).longValue();
    }
}
