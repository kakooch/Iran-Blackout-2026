package ir.nasim;

import ir.nasim.AbstractC16253kx5;
import ir.nasim.C6266Mw5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.ou, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18582ou implements InterfaceC17991nu {
    private final AbstractC3625Bq6 a;
    private final C22837vu b;

    /* renamed from: ir.nasim.ou$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11375cu.values().length];
            iArr[EnumC11375cu.PROPERTY.ordinal()] = 1;
            iArr[EnumC11375cu.PROPERTY_GETTER.ordinal()] = 2;
            iArr[EnumC11375cu.PROPERTY_SETTER.ordinal()] = 3;
            a = iArr;
        }
    }

    public C18582ou(InterfaceC8507Wg4 interfaceC8507Wg4, C21830uC4 c21830uC4, AbstractC3625Bq6 abstractC3625Bq6) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        AbstractC13042fc3.i(abstractC3625Bq6, "protocol");
        this.a = abstractC3625Bq6;
        this.b = new C22837vu(interfaceC8507Wg4, c21830uC4);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List a(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "proto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List b(AbstractC16253kx5 abstractC16253kx5, C7477Rw5 c7477Rw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c7477Rw5, "proto");
        List listM = (List) c7477Rw5.s(this.a.d());
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), abstractC16253kx5.b()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List c(C10647bx5 c10647bx5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c10647bx5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        List listM = (List) c10647bx5.s(this.a.k());
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), interfaceC6692Oo4));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List d(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List e(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
        List listM;
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "proto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        if (lVar instanceof C6765Ow5) {
            listM = (List) ((C6765Ow5) lVar).s(this.a.c());
        } else if (lVar instanceof C7950Tw5) {
            listM = (List) ((C7950Tw5) lVar).s(this.a.f());
        } else {
            if (!(lVar instanceof C9193Yw5)) {
                throw new IllegalStateException(AbstractC13042fc3.q("Unknown message: ", lVar).toString());
            }
            int i = a.a[enumC11375cu.ordinal()];
            if (i == 1) {
                listM = (List) ((C9193Yw5) lVar).s(this.a.h());
            } else if (i == 2) {
                listM = (List) ((C9193Yw5) lVar).s(this.a.i());
            } else {
                if (i != 3) {
                    throw new IllegalStateException("Unsupported callable kind with property proto".toString());
                }
                listM = (List) ((C9193Yw5) lVar).s(this.a.j());
            }
        }
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), abstractC16253kx5.b()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List f(AbstractC16253kx5.a aVar) {
        AbstractC13042fc3.i(aVar, "container");
        List listM = (List) aVar.f().s(this.a.a());
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), aVar.b()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List g(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu, int i, C13280fx5 c13280fx5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "callableProto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        AbstractC13042fc3.i(c13280fx5, "proto");
        List listM = (List) c13280fx5.s(this.a.g());
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), abstractC16253kx5.b()));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List h(C12053dx5 c12053dx5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c12053dx5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        List listM = (List) c12053dx5.s(this.a.l());
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        List list = listM;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.b.a((C6266Mw5) it.next(), interfaceC6692Oo4));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List i(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC17991nu
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public AbstractC7068Qd1 j(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5, AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        AbstractC13042fc3.i(abstractC4099Dr3, "expectedType");
        C6266Mw5.b.c cVar = (C6266Mw5.b.c) AbstractC15662jx5.a(c9193Yw5, this.a.b());
        if (cVar == null) {
            return null;
        }
        return this.b.f(abstractC4099Dr3, cVar, abstractC16253kx5.b());
    }
}
