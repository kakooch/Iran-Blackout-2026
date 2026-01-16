package ir.nasim;

import java.util.Collection;

/* renamed from: ir.nasim.Ir3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5284Ir3 {

    /* renamed from: ir.nasim.Ir3$a */
    public static final class a extends AbstractC5284Ir3 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public InterfaceC21331tU0 a(C24948zU0 c24948zU0) {
            AbstractC13042fc3.i(c24948zU0, "classId");
            return null;
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public W24 b(InterfaceC21331tU0 interfaceC21331tU0, SA2 sa2) {
            AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
            AbstractC13042fc3.i(sa2, "compute");
            return (W24) sa2.invoke();
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public boolean c(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "moduleDescriptor");
            return false;
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public boolean d(InterfaceC13882gy7 interfaceC13882gy7) {
            AbstractC13042fc3.i(interfaceC13882gy7, "typeConstructor");
            return false;
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public Collection f(InterfaceC21331tU0 interfaceC21331tU0) {
            AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
            Collection collectionB = interfaceC21331tU0.j().b();
            AbstractC13042fc3.h(collectionB, "classDescriptor.typeConstructor.supertypes");
            return collectionB;
        }

        @Override // ir.nasim.AbstractC5284Ir3
        public AbstractC4099Dr3 g(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "type");
            return abstractC4099Dr3;
        }

        @Override // ir.nasim.AbstractC5284Ir3
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public InterfaceC21331tU0 e(InterfaceC12795fB1 interfaceC12795fB1) {
            AbstractC13042fc3.i(interfaceC12795fB1, "descriptor");
            return null;
        }
    }

    public abstract InterfaceC21331tU0 a(C24948zU0 c24948zU0);

    public abstract W24 b(InterfaceC21331tU0 interfaceC21331tU0, SA2 sa2);

    public abstract boolean c(InterfaceC8507Wg4 interfaceC8507Wg4);

    public abstract boolean d(InterfaceC13882gy7 interfaceC13882gy7);

    public abstract MU0 e(InterfaceC12795fB1 interfaceC12795fB1);

    public abstract Collection f(InterfaceC21331tU0 interfaceC21331tU0);

    public abstract AbstractC4099Dr3 g(AbstractC4099Dr3 abstractC4099Dr3);
}
