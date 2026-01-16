package ir.nasim;

/* loaded from: classes3.dex */
public final class At8 implements InterfaceC25200zt8 {
    public static final AbstractC11344cq8 a;
    public static final AbstractC11344cq8 b;
    public static final AbstractC11344cq8 c;
    public static final AbstractC11344cq8 d;
    public static final AbstractC11344cq8 e;

    static {
        Lp8 lp8A = new Lp8(Ap8.a("com.google.android.gms.measurement")).a();
        a = lp8A.f("measurement.test.boolean_flag", false);
        b = lp8A.c("measurement.test.double_flag", -3.0d);
        c = lp8A.d("measurement.test.int_flag", -2L);
        d = lp8A.d("measurement.test.long_flag", -1L);
        e = lp8A.e("measurement.test.string_flag", "---");
    }

    @Override // ir.nasim.InterfaceC25200zt8
    public final long c() {
        return ((Long) c.b()).longValue();
    }

    @Override // ir.nasim.InterfaceC25200zt8
    public final String d() {
        return (String) e.b();
    }

    @Override // ir.nasim.InterfaceC25200zt8
    public final long e() {
        return ((Long) d.b()).longValue();
    }

    @Override // ir.nasim.InterfaceC25200zt8
    public final boolean g() {
        return ((Boolean) a.b()).booleanValue();
    }

    @Override // ir.nasim.InterfaceC25200zt8
    public final double zza() {
        return ((Double) b.b()).doubleValue();
    }
}
