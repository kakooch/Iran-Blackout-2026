package ir.nasim;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public interface OU0 {

    public static final class a implements OU0 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.OU0
        public String a(MU0 mu0, FI1 fi1) {
            AbstractC13042fc3.i(mu0, "classifier");
            AbstractC13042fc3.i(fi1, "renderer");
            if (mu0 instanceof InterfaceC22882vy7) {
                C6432No4 name = ((InterfaceC22882vy7) mu0).getName();
                AbstractC13042fc3.h(name, "classifier.name");
                return fi1.w(name, false);
            }
            C10027ax2 c10027ax2M = OI1.m(mu0);
            AbstractC13042fc3.h(c10027ax2M, "getFqName(classifier)");
            return fi1.v(c10027ax2M);
        }
    }

    public static final class b implements OU0 {
        public static final b a = new b();

        private b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [ir.nasim.MU0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [ir.nasim.So4, ir.nasim.fB1] */
        /* JADX WARN: Type inference failed for: r2v2, types: [ir.nasim.fB1] */
        @Override // ir.nasim.OU0
        public String a(MU0 mu0, FI1 fi1) {
            AbstractC13042fc3.i(mu0, "classifier");
            AbstractC13042fc3.i(fi1, "renderer");
            if (mu0 instanceof InterfaceC22882vy7) {
                C6432No4 name = ((InterfaceC22882vy7) mu0).getName();
                AbstractC13042fc3.h(name, "classifier.name");
                return fi1.w(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(mu0.getName());
                mu0 = mu0.b();
            } while (mu0 instanceof InterfaceC21331tU0);
            return DO5.c(AbstractC14201hX0.V(arrayList));
        }
    }

    public static final class c implements OU0 {
        public static final c a = new c();

        private c() {
        }

        private final String b(MU0 mu0) {
            C6432No4 name = mu0.getName();
            AbstractC13042fc3.h(name, "descriptor.name");
            String strB = DO5.b(name);
            if (mu0 instanceof InterfaceC22882vy7) {
                return strB;
            }
            InterfaceC12795fB1 interfaceC12795fB1B = mu0.b();
            AbstractC13042fc3.h(interfaceC12795fB1B, "descriptor.containingDeclaration");
            String strC = c(interfaceC12795fB1B);
            if (strC == null || AbstractC13042fc3.d(strC, "")) {
                return strB;
            }
            return ((Object) strC) + '.' + strB;
        }

        private final String c(InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC12795fB1 instanceof InterfaceC21331tU0) {
                return b((MU0) interfaceC12795fB1);
            }
            if (!(interfaceC12795fB1 instanceof InterfaceC24340yS4)) {
                return null;
            }
            C10027ax2 c10027ax2J = ((InterfaceC24340yS4) interfaceC12795fB1).e().j();
            AbstractC13042fc3.h(c10027ax2J, "descriptor.fqName.toUnsafe()");
            return DO5.a(c10027ax2J);
        }

        @Override // ir.nasim.OU0
        public String a(MU0 mu0, FI1 fi1) {
            AbstractC13042fc3.i(mu0, "classifier");
            AbstractC13042fc3.i(fi1, "renderer");
            return b(mu0);
        }
    }

    String a(MU0 mu0, FI1 fi1);
}
