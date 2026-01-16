package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.iy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15082iy7 extends AbstractC5117Hy7 {
    public static final a c = new a(null);

    /* renamed from: ir.nasim.iy7$a */
    public static final class a {

        /* renamed from: ir.nasim.iy7$a$a, reason: collision with other inner class name */
        public static final class C1309a extends AbstractC15082iy7 {
            final /* synthetic */ Map d;
            final /* synthetic */ boolean e;

            C1309a(Map map, boolean z) {
                this.d = map;
                this.e = z;
            }

            @Override // ir.nasim.AbstractC5117Hy7
            public boolean a() {
                return this.e;
            }

            @Override // ir.nasim.AbstractC5117Hy7
            public boolean f() {
                return this.d.isEmpty();
            }

            @Override // ir.nasim.AbstractC15082iy7
            public InterfaceC3932Cy7 j(InterfaceC13882gy7 interfaceC13882gy7) {
                AbstractC13042fc3.i(interfaceC13882gy7, "key");
                return (InterfaceC3932Cy7) this.d.get(interfaceC13882gy7);
            }
        }

        private a() {
        }

        public static /* synthetic */ AbstractC15082iy7 e(a aVar, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return aVar.d(map, z);
        }

        public final AbstractC5117Hy7 a(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "kotlinType");
            return b(abstractC4099Dr3.K0(), abstractC4099Dr3.J0());
        }

        public final AbstractC5117Hy7 b(InterfaceC13882gy7 interfaceC13882gy7, List list) {
            AbstractC13042fc3.i(interfaceC13882gy7, "typeConstructor");
            AbstractC13042fc3.i(list, "arguments");
            List parameters = interfaceC13882gy7.getParameters();
            AbstractC13042fc3.h(parameters, "typeConstructor.parameters");
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) AbstractC15401jX0.F0(parameters);
            if (!AbstractC13042fc3.d(interfaceC22882vy7 == null ? null : Boolean.valueOf(interfaceC22882vy7.S()), Boolean.TRUE)) {
                return new C13957h63(parameters, list);
            }
            List parameters2 = interfaceC13882gy7.getParameters();
            AbstractC13042fc3.h(parameters2, "typeConstructor.parameters");
            List list2 = parameters2;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((InterfaceC22882vy7) it.next()).j());
            }
            return e(this, AbstractC20051rO3.w(AbstractC15401jX0.v1(arrayList, list)), false, 2, null);
        }

        public final AbstractC15082iy7 c(Map map) {
            AbstractC13042fc3.i(map, "map");
            return e(this, map, false, 2, null);
        }

        public final AbstractC15082iy7 d(Map map, boolean z) {
            AbstractC13042fc3.i(map, "map");
            return new C1309a(map, z);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final AbstractC5117Hy7 h(InterfaceC13882gy7 interfaceC13882gy7, List list) {
        return c.b(interfaceC13882gy7, list);
    }

    public static final AbstractC15082iy7 i(Map map) {
        return c.c(map);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "key");
        return j(abstractC4099Dr3.K0());
    }

    public abstract InterfaceC3932Cy7 j(InterfaceC13882gy7 interfaceC13882gy7);
}
