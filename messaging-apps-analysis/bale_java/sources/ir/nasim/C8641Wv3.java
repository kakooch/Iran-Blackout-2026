package ir.nasim;

import ir.nasim.InterfaceC25246zy7;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.Wv3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8641Wv3 implements DS4 {
    private final C9182Yv3 a;
    private final InterfaceC20324rp0 b;

    /* renamed from: ir.nasim.Wv3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC22715vi3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC22715vi3 interfaceC22715vi3) {
            super(0);
            this.f = interfaceC22715vi3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8407Vv3 invoke() {
            return new C8407Vv3(C8641Wv3.this.a, this.f);
        }
    }

    public C8641Wv3(C3784Ci3 c3784Ci3) {
        AbstractC13042fc3.i(c3784Ci3, "components");
        C9182Yv3 c9182Yv3 = new C9182Yv3(c3784Ci3, InterfaceC25246zy7.a.a, AbstractC13860gw3.c(null));
        this.a = c9182Yv3;
        this.b = c9182Yv3.e().a();
    }

    private final C8407Vv3 d(C9424Zw2 c9424Zw2) {
        InterfaceC22715vi3 interfaceC22715vi3A = this.a.a().d().a(c9424Zw2);
        if (interfaceC22715vi3A == null) {
            return null;
        }
        return (C8407Vv3) this.b.a(c9424Zw2, new a(interfaceC22715vi3A));
    }

    @Override // ir.nasim.DS4
    public void a(C9424Zw2 c9424Zw2, Collection collection) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(collection, "packageFragments");
        YW0.a(collection, d(c9424Zw2));
    }

    @Override // ir.nasim.AS4
    public List b(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return AbstractC10360bX0.q(d(c9424Zw2));
    }

    @Override // ir.nasim.AS4
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List l(C9424Zw2 c9424Zw2, UA2 ua2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ua2, "nameFilter");
        C8407Vv3 c8407Vv3D = d(c9424Zw2);
        List listN0 = c8407Vv3D == null ? null : c8407Vv3D.N0();
        return listN0 != null ? listN0 : AbstractC10360bX0.m();
    }
}
