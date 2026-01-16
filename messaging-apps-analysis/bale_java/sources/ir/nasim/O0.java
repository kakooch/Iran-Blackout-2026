package ir.nasim;

import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class O0 implements DS4 {
    private final ON6 a;
    private final InterfaceC24581yr3 b;
    private final InterfaceC8507Wg4 c;
    protected TI1 d;
    private final J34 e;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC24340yS4 invoke(C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            AbstractC14678iJ1 abstractC14678iJ1C = O0.this.c(c9424Zw2);
            if (abstractC14678iJ1C == null) {
                return null;
            }
            abstractC14678iJ1C.K0(O0.this.d());
            return abstractC14678iJ1C;
        }
    }

    public O0(ON6 on6, InterfaceC24581yr3 interfaceC24581yr3, InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC24581yr3, "finder");
        AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
        this.a = on6;
        this.b = interfaceC24581yr3;
        this.c = interfaceC8507Wg4;
        this.e = on6.b(new a());
    }

    @Override // ir.nasim.DS4
    public void a(C9424Zw2 c9424Zw2, Collection collection) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(collection, "packageFragments");
        YW0.a(collection, this.e.invoke(c9424Zw2));
    }

    @Override // ir.nasim.AS4
    public List b(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return AbstractC10360bX0.q(this.e.invoke(c9424Zw2));
    }

    protected abstract AbstractC14678iJ1 c(C9424Zw2 c9424Zw2);

    protected final TI1 d() {
        TI1 ti1 = this.d;
        if (ti1 != null) {
            return ti1;
        }
        AbstractC13042fc3.y("components");
        throw null;
    }

    protected final InterfaceC24581yr3 e() {
        return this.b;
    }

    protected final InterfaceC8507Wg4 f() {
        return this.c;
    }

    protected final ON6 g() {
        return this.a;
    }

    protected final void h(TI1 ti1) {
        AbstractC13042fc3.i(ti1, "<set-?>");
        this.d = ti1;
    }

    @Override // ir.nasim.AS4
    public Collection l(C9424Zw2 c9424Zw2, UA2 ua2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return AbstractC4597Fu6.d();
    }
}
