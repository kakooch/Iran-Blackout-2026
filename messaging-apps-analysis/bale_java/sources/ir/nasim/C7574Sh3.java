package ir.nasim;

/* renamed from: ir.nasim.Sh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C7574Sh3 implements InterfaceC20102rU0 {
    private final InterfaceC20347rr3 a;
    private final C12867fJ1 b;

    public C7574Sh3(InterfaceC20347rr3 interfaceC20347rr3, C12867fJ1 c12867fJ1) {
        AbstractC13042fc3.i(interfaceC20347rr3, "kotlinClassFinder");
        AbstractC13042fc3.i(c12867fJ1, "deserializedDescriptorResolver");
        this.a = interfaceC20347rr3;
        this.b = c12867fJ1;
    }

    @Override // ir.nasim.InterfaceC20102rU0
    public C19511qU0 a(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        InterfaceC22805vr3 interfaceC22805vr3A = AbstractC20938sr3.a(this.a, c24948zU0);
        if (interfaceC22805vr3A == null) {
            return null;
        }
        AbstractC13042fc3.d(interfaceC22805vr3A.f(), c24948zU0);
        return this.b.k(interfaceC22805vr3A);
    }
}
