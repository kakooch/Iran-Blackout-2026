package ir.nasim;

/* renamed from: ir.nasim.bJ1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C10235bJ1 implements InterfaceC20102rU0 {
    private final AS4 a;

    public C10235bJ1(AS4 as4) {
        AbstractC13042fc3.i(as4, "packageFragmentProvider");
        this.a = as4;
    }

    @Override // ir.nasim.InterfaceC20102rU0
    public C19511qU0 a(C24948zU0 c24948zU0) {
        C19511qU0 c19511qU0A;
        AbstractC13042fc3.i(c24948zU0, "classId");
        AS4 as4 = this.a;
        C9424Zw2 c9424Zw2H = c24948zU0.h();
        AbstractC13042fc3.h(c9424Zw2H, "classId.packageFqName");
        for (InterfaceC24340yS4 interfaceC24340yS4 : CS4.b(as4, c9424Zw2H)) {
            if ((interfaceC24340yS4 instanceof AbstractC14678iJ1) && (c19511qU0A = ((AbstractC14678iJ1) interfaceC24340yS4).I0().a(c24948zU0)) != null) {
                return c19511qU0A;
            }
        }
        return null;
    }
}
