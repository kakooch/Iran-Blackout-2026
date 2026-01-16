package ir.nasim;

/* renamed from: ir.nasim.ut8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C22240ut8 implements InterfaceC21650tt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.f("measurement.sdk.collection.enable_extend_user_property_size", true);
        b = lp8A.f("measurement.sdk.collection.last_deep_link_referrer2", true);
        c = lp8A.f("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        d = lp8A.d("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // ir.nasim.InterfaceC21650tt8
    public final boolean zza() {
        return ((Boolean) c.b()).booleanValue();
    }
}
