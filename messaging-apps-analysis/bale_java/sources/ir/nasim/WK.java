package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class WK implements EB3 {
    private final C18838pL a;
    private final C17025mG4 b = new C17025mG4();
    private CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public WK(YB3 yb3, InterfaceC17311ml0 interfaceC17311ml0) {
        this.a = new C18838pL(yb3, interfaceC17311ml0);
    }

    private GB3 D(final GB3 gb3) {
        return new GB3() { // from class: ir.nasim.TK
            @Override // ir.nasim.GB3
            public final void a(List list, long j, long j2) {
                this.a.F(gb3, list, j, j2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(GB3 gb3, List list, long j, long j2) {
        for (Object obj : list) {
            this.b.c(Long.valueOf(((HB3) obj).a()), obj);
        }
        gb3.a(list, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(C7234Qv5 c7234Qv5, List list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.b.e((Long) list.get(i));
            jArr[i] = ((Long) list.get(i)).longValue();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).f(jArr);
        }
        c7234Qv5.b(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(long j, EnumC24659yz5 enumC24659yz5, final C7234Qv5 c7234Qv5) {
        this.a.W(j, enumC24659yz5).m0(new InterfaceC24449ye1() { // from class: ir.nasim.VK
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.G(c7234Qv5, (List) obj);
            }
        });
    }

    public int E(String str) {
        AbstractC20507s76.d();
        return this.a.z(str);
    }

    public void I(String str, int i, int i2, GB3 gb3) {
        this.a.U(str, i, i2, D(gb3));
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 a(long j) {
        AbstractC20507s76.d();
        AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.b.b(Long.valueOf(j));
        if (abstractC17902nl0 != null) {
            return abstractC17902nl0;
        }
        AbstractC17902nl0 abstractC17902nl0D = this.a.D(j);
        if (abstractC17902nl0D != null) {
            this.b.c(Long.valueOf(j), abstractC17902nl0D);
        }
        return abstractC17902nl0D;
    }

    @Override // ir.nasim.DB3
    public void b(long j) {
        AbstractC20507s76.d();
        this.b.e(Long.valueOf(j));
        this.a.V(new long[]{j});
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).e(j);
        }
    }

    @Override // ir.nasim.DB3
    public void c(List list) {
        AbstractC20507s76.d();
        for (Object obj : list) {
            this.b.d(Long.valueOf(((HB3) obj).a()), obj);
        }
        this.a.u(list);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).d(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public void d(AbstractC17902nl0 abstractC17902nl0) {
        AbstractC20507s76.d();
        this.b.d(Long.valueOf(((HB3) abstractC17902nl0).a()), abstractC17902nl0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC17902nl0);
        this.a.u(arrayList);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).a(abstractC17902nl0);
        }
    }

    @Override // ir.nasim.EB3
    public void e(String str, long j, int i, GB3 gb3) {
        this.a.R(str, Long.valueOf(j), i, D(gb3));
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 f(final long j, final EnumC24659yz5 enumC24659yz5) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.UK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.H(j, enumC24659yz5, c7234Qv5);
            }
        });
    }

    @Override // ir.nasim.EB3
    public void g(String str, long j, int i, GB3 gb3) {
        this.a.T(str, Long.valueOf(j), i, D(gb3));
    }

    @Override // ir.nasim.DB3
    public int getCount() {
        AbstractC20507s76.d();
        return this.a.y();
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 h() {
        AbstractC20507s76.d();
        return this.a.x();
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 i(long j, long j2) {
        AbstractC20507s76.d();
        return this.a.F(j, j2);
    }

    @Override // ir.nasim.DB3
    public boolean isEmpty() {
        AbstractC20507s76.d();
        return getCount() == 0;
    }

    @Override // ir.nasim.EB3
    public void j(FB3 fb3) {
        if (this.c.contains(fb3)) {
            return;
        }
        this.c.add(fb3);
    }

    @Override // ir.nasim.DB3
    public List k() {
        AbstractC20507s76.d();
        return this.a.w();
    }

    @Override // ir.nasim.DB3
    public void l(boolean z) {
        AbstractC20507s76.d();
        this.b.clear();
        if (!z) {
            this.a.v();
        }
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public AbstractC17902nl0 m() {
        AbstractC20507s76.d();
        AbstractC17902nl0 abstractC17902nl0C = this.a.C();
        if (abstractC17902nl0C != 0) {
            this.b.c(Long.valueOf(((HB3) abstractC17902nl0C).a()), abstractC17902nl0C);
        }
        return abstractC17902nl0C;
    }

    @Override // ir.nasim.EB3
    public void n(FB3 fb3) {
        this.c.remove(fb3);
    }

    @Override // ir.nasim.EB3
    public void o(long j, int i, GB3 gb3) {
        this.a.S(j, i, D(gb3));
    }

    @Override // ir.nasim.DB3
    public void p(List list, EnumC24659yz5 enumC24659yz5) {
        AbstractC20507s76.d();
        for (Object obj : list) {
            this.b.d(Long.valueOf(((HB3) obj).a()), obj);
        }
        this.a.u(list);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).g(list, enumC24659yz5);
        }
    }

    @Override // ir.nasim.EB3
    public void q(String str, int i, GB3 gb3) {
        this.a.T(str, null, i, D(gb3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public AbstractC17902nl0 r() {
        AbstractC20507s76.d();
        AbstractC17902nl0 abstractC17902nl0A = this.a.A();
        if (abstractC17902nl0A != 0) {
            this.b.c(Long.valueOf(((HB3) abstractC17902nl0A).a()), abstractC17902nl0A);
        }
        return abstractC17902nl0A;
    }

    @Override // ir.nasim.DB3
    public void s(List list) {
        AbstractC20507s76.d();
        this.b.clear();
        for (Object obj : list) {
            this.b.d(Long.valueOf(((HB3) obj).a()), obj);
        }
        this.a.X(list);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).c(list);
        }
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 t(long j, boolean z) {
        AbstractC20507s76.d();
        return this.a.E(j, z);
    }

    @Override // ir.nasim.EB3
    public void u(long j, int i, GB3 gb3) {
        this.a.R(null, Long.valueOf(j), i, D(gb3));
    }

    @Override // ir.nasim.DB3
    public void v(AbstractC17902nl0 abstractC17902nl0) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).a(abstractC17902nl0);
        }
    }

    @Override // ir.nasim.EB3
    public void w(int i, GB3 gb3) {
        this.a.T(null, null, i, D(gb3));
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 x(String str, long j, EnumC24659yz5 enumC24659yz5, int i, boolean z) {
        AbstractC20507s76.d();
        return this.a.B(str, j, enumC24659yz5, i);
    }

    @Override // ir.nasim.EB3
    public void y(int i, GB3 gb3) {
        this.a.R(null, null, i, D(gb3));
    }

    @Override // ir.nasim.EB3
    public void z(long j, int i, GB3 gb3) {
        this.a.T(null, Long.valueOf(j), i, D(gb3));
    }
}
