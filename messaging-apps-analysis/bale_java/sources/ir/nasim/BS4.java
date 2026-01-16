package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public final class BS4 implements DS4 {
    private final Collection a;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C9424Zw2 invoke(InterfaceC24340yS4 interfaceC24340yS4) {
            AbstractC13042fc3.i(interfaceC24340yS4, "it");
            return interfaceC24340yS4.e();
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9424Zw2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C9424Zw2 c9424Zw2) {
            super(1);
            this.e = c9424Zw2;
        }

        public final boolean a(C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(c9424Zw2, "it");
            return !c9424Zw2.d() && AbstractC13042fc3.d(c9424Zw2.e(), this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((C9424Zw2) obj));
        }
    }

    public BS4(Collection collection) {
        AbstractC13042fc3.i(collection, "packageFragments");
        this.a = collection;
    }

    @Override // ir.nasim.DS4
    public void a(C9424Zw2 c9424Zw2, Collection collection) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(collection, "packageFragments");
        for (Object obj : this.a) {
            if (AbstractC13042fc3.d(((InterfaceC24340yS4) obj).e(), c9424Zw2)) {
                collection.add(obj);
            }
        }
    }

    @Override // ir.nasim.AS4
    public List b(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        Collection collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (AbstractC13042fc3.d(((InterfaceC24340yS4) obj).e(), c9424Zw2)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // ir.nasim.AS4
    public Collection l(C9424Zw2 c9424Zw2, UA2 ua2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return AbstractC11342cq6.K(AbstractC11342cq6.r(AbstractC11342cq6.C(AbstractC15401jX0.g0(this.a), a.e), new b(c9424Zw2)));
    }
}
