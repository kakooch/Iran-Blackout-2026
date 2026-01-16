package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.l66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16342l66 extends Z6 implements InterfaceC3817Cm0 {

    /* renamed from: ir.nasim.l66$a */
    static class a {
        private final C11458d25 a;
        private final boolean b;

        public a(C11458d25 c11458d25, boolean z) {
            this.a = c11458d25;
            this.b = z;
        }

        public C11458d25 a() {
            return this.a;
        }

        public boolean b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.l66$b */
    static class b {
        private final C11458d25 a;
        private final long b;
        private final int c;

        public b(C11458d25 c11458d25, long j, int i) {
            this.a = c11458d25;
            this.b = j;
            this.c = i;
        }

        public long a() {
            return this.b;
        }

        public int b() {
            return this.c;
        }

        public C11458d25 c() {
            return this.a;
        }
    }

    public C16342l66(final C9057Yh4 c9057Yh4) {
        super(C12736f7.n().g("actor/router", C4614Fw5.d(new V6() { // from class: ir.nasim.k66
            @Override // ir.nasim.V6
            public final K6 create() {
                return C16342l66.m(c9057Yh4);
            }
        }), true));
        c9057Yh4.a().h(this, "peer_chat_opened");
        c9057Yh4.a().h(this, "peer_chat_closed");
        c9057Yh4.a().h(this, "app_visible_changed");
        c9057Yh4.a().h(this, "SettingsSynced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 m(C9057Yh4 c9057Yh4) {
        return new K56(c9057Yh4);
    }

    public C6517Nv5 A(C11458d25 c11458d25, J44 j44) {
        return c(new C21100t66(c11458d25, j44));
    }

    public C6517Nv5 B(List list, List list2) {
        return c(new C22960w66(list, list2));
    }

    public void C(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        i(new C23550x66(c11458d25, q64, exPeerType));
    }

    public void D(C11458d25 c11458d25, Q64 q64, ExPeerType exPeerType) {
        i(new C24140y66(c11458d25, q64, exPeerType));
    }

    public C6517Nv5 E(AbstractC20556sC7 abstractC20556sC7) {
        return c(new C18706p66(abstractC20556sC7));
    }

    public C6517Nv5 F(C17637nI7 c17637nI7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c17637nI7);
        return G(arrayList);
    }

    public C6517Nv5 G(List list) {
        return B(list, new ArrayList());
    }

    @Override // ir.nasim.InterfaceC3817Cm0
    /* renamed from: g */
    public void T(AbstractC18385oa2 abstractC18385oa2) {
        if (abstractC18385oa2 instanceof C18074o25) {
            C18074o25 c18074o25 = (C18074o25) abstractC18385oa2;
            i(new U56(c18074o25.c(), c18074o25.b()));
            return;
        }
        if (abstractC18385oa2 instanceof C17483n25) {
            i(new T56(((C17483n25) abstractC18385oa2).b()));
            return;
        }
        if (!(abstractC18385oa2 instanceof XE)) {
            if (abstractC18385oa2 instanceof C24043xw6) {
                i(new ZE4(true));
            }
        } else if (((XE) abstractC18385oa2).a) {
            i(new M56());
        } else {
            i(new L56());
        }
    }

    public C6517Nv5 k(C11458d25 c11458d25, long j, long j2) {
        return c(new V56(c11458d25, j, j2));
    }

    public C6517Nv5 l() {
        return c(new YF2());
    }

    public void n(C11458d25 c11458d25) {
        i(new C16690li0(c11458d25));
    }

    public C6517Nv5 o(C11458d25 c11458d25, Y64 y64, Long l, Long l2, boolean z, DB3 db3) {
        return c(new N56(c11458d25, y64, l, l2, z, db3));
    }

    public void p(C11458d25 c11458d25, boolean z) {
        i(new R56(c11458d25, z));
    }

    public void q(C11458d25 c11458d25, boolean z) {
        i(new a(c11458d25, z));
    }

    public void r(C11458d25 c11458d25, long j, int i) {
        i(new b(c11458d25, j, i));
    }

    public C6517Nv5 s(List list) {
        return c(new O56(list));
    }

    public C6517Nv5 t(C14697iL2 c14697iL2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c14697iL2);
        return u(arrayList);
    }

    public C6517Nv5 u(List list) {
        return B(new ArrayList(), list);
    }

    public C6517Nv5 v(C11458d25 c11458d25, long j, AbstractC17457n0 abstractC17457n0) {
        return c(new C18115o66(c11458d25, j, abstractC17457n0));
    }

    public C6517Nv5 w(C11458d25 c11458d25, List list, List list2) {
        return c(new W56(c11458d25, list, list2));
    }

    public C6517Nv5 x(C11458d25 c11458d25, J44 j44) {
        return c(new C19297q66(c11458d25, j44));
    }

    public C6517Nv5 y(C11458d25 c11458d25, List list) {
        return c(new C19888r66(c11458d25, list));
    }

    public C6517Nv5 z(C11458d25 c11458d25, long j) {
        return c(new C20497s66(c11458d25, j));
    }
}
