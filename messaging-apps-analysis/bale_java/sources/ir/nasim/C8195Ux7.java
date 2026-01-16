package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Ux7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8195Ux7 {
    public static final a e = new a(null);
    private final C8195Ux7 a;
    private final InterfaceC7722Sx7 b;
    private final List c;
    private final Map d;

    /* renamed from: ir.nasim.Ux7$a */
    public static final class a {
        private a() {
        }

        public final C8195Ux7 a(C8195Ux7 c8195Ux7, InterfaceC7722Sx7 interfaceC7722Sx7, List list) {
            AbstractC13042fc3.i(interfaceC7722Sx7, "typeAliasDescriptor");
            AbstractC13042fc3.i(list, "arguments");
            List parameters = interfaceC7722Sx7.j().getParameters();
            AbstractC13042fc3.h(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            List list2 = parameters;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC22882vy7) it.next()).a());
            }
            return new C8195Ux7(c8195Ux7, interfaceC7722Sx7, list, AbstractC20051rO3.w(AbstractC15401jX0.v1(arrayList, list)), null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C8195Ux7(C8195Ux7 c8195Ux7, InterfaceC7722Sx7 interfaceC7722Sx7, List list, Map map, ED1 ed1) {
        this(c8195Ux7, interfaceC7722Sx7, list, map);
    }

    public final List a() {
        return this.c;
    }

    public final InterfaceC7722Sx7 b() {
        return this.b;
    }

    public final InterfaceC3932Cy7 c(InterfaceC13882gy7 interfaceC13882gy7) {
        AbstractC13042fc3.i(interfaceC13882gy7, "constructor");
        MU0 mu0D = interfaceC13882gy7.d();
        if (mu0D instanceof InterfaceC22882vy7) {
            return (InterfaceC3932Cy7) this.d.get(mu0D);
        }
        return null;
    }

    public final boolean d(InterfaceC7722Sx7 interfaceC7722Sx7) {
        AbstractC13042fc3.i(interfaceC7722Sx7, "descriptor");
        if (!AbstractC13042fc3.d(this.b, interfaceC7722Sx7)) {
            C8195Ux7 c8195Ux7 = this.a;
            if (!(c8195Ux7 == null ? false : c8195Ux7.d(interfaceC7722Sx7))) {
                return false;
            }
        }
        return true;
    }

    private C8195Ux7(C8195Ux7 c8195Ux7, InterfaceC7722Sx7 interfaceC7722Sx7, List list, Map map) {
        this.a = c8195Ux7;
        this.b = interfaceC7722Sx7;
        this.c = list;
        this.d = map;
    }
}
