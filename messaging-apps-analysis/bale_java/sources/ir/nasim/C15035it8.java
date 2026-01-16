package ir.nasim;

/* renamed from: ir.nasim.it8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15035it8 implements InterfaceC14428ht8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.f("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        b = lp8A.f("measurement.audience.refresh_event_count_filters_timestamp", false);
        c = lp8A.f("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        d = lp8A.f("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // ir.nasim.InterfaceC14428ht8
    public final boolean c() {
        return ((Boolean) b.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC14428ht8
    public final boolean d() {
        return ((Boolean) d.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC14428ht8
    public final boolean e() {
        return ((Boolean) c.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC14428ht8
    public final boolean zza() {
        return true;
    }
}
