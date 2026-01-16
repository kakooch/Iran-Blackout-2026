package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class O34 implements EB3 {
    private final Q34 b;
    private final InterfaceC17311ml0 c;
    private final C17025mG4 a = new C17025mG4();
    private List d = new IJ().a();

    class a implements GB3 {
        final /* synthetic */ GB3 a;

        a(GB3 gb3) {
            this.a = gb3;
        }

        @Override // ir.nasim.GB3
        public void a(List list, long j, long j2) {
            for (Object obj : list) {
                O34.this.a.c(Long.valueOf(((HB3) obj).a()), obj);
            }
            this.a.a(list, j, j2);
        }
    }

    public O34(YB3 yb3, InterfaceC17311ml0 interfaceC17311ml0) {
        this.b = (Q34) yb3;
        this.c = interfaceC17311ml0;
    }

    private void C(GB3 gb3, List list) {
        if (list.size() == 0) {
            gb3.a(list, 0L, 0L);
            return;
        }
        long j = ((HB3) ((AbstractC17902nl0) list.get(0))).j();
        Iterator it = list.iterator();
        long j2 = j;
        long j3 = j2;
        while (it.hasNext()) {
            long j4 = ((HB3) ((AbstractC17902nl0) it.next())).j();
            if (j2 < j4) {
                j2 = j4;
            }
            if (j3 > j4) {
                j3 = j4;
            }
        }
        gb3.a(list, j2, j3);
    }

    private ArrayList D(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(AbstractC16720ll0.b((AbstractC17902nl0) this.c.a(), ((IB3) it.next()).a()));
            } catch (IOException e) {
                C19406qI3.c("MemoryListEngine", "Error in convertList on parse: " + e.getMessage(), e);
            }
        }
        return arrayList;
    }

    private GB3 E(GB3 gb3) {
        return new a(gb3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void F(C7234Qv5 c7234Qv5) {
        c7234Qv5.b(new ArrayList());
    }

    private AbstractC17902nl0 G(long j) {
        AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.a.b(Long.valueOf(j));
        if (abstractC17902nl0 != null) {
            return abstractC17902nl0;
        }
        IB3 ib3C = this.b.c(j);
        if (ib3C == null) {
            return null;
        }
        try {
            AbstractC17902nl0 abstractC17902nl02 = (AbstractC17902nl0) this.c.a();
            abstractC17902nl02.parse(new C19084pl0(AbstractC18493ol0.a(new C9207Yy1(ib3C.a()))));
            this.a.c(Long.valueOf(j), abstractC17902nl02);
            return abstractC17902nl02;
        } catch (IOException e) {
            C19406qI3.d("MemoryListEngine", e);
            return null;
        }
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 a(long j) {
        return G(j);
    }

    @Override // ir.nasim.DB3
    public void b(long j) {
        this.a.e(Long.valueOf(j));
        this.b.b(j);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).e(j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public void c(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
            HB3 hb3 = (HB3) abstractC17902nl0;
            this.a.d(Long.valueOf(hb3.a()), abstractC17902nl0);
            arrayList.add(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        }
        this.b.f(arrayList);
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((FB3) it2.next()).d(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public void d(AbstractC17902nl0 abstractC17902nl0) {
        HB3 hb3 = (HB3) abstractC17902nl0;
        this.a.d(Long.valueOf(hb3.a()), abstractC17902nl0);
        this.b.j(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).a(abstractC17902nl0);
        }
    }

    @Override // ir.nasim.EB3
    public void e(String str, long j, int i, GB3 gb3) {
        C(E(gb3), D(this.b.p(str, Long.valueOf(j), i)));
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 f(long j, EnumC24659yz5 enumC24659yz5) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.N34
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                O34.F(c7234Qv5);
            }
        });
    }

    @Override // ir.nasim.EB3
    public void g(String str, long j, int i, GB3 gb3) {
        C(E(gb3), D(this.b.n(str, Long.valueOf(j), i)));
    }

    @Override // ir.nasim.DB3
    public int getCount() {
        return this.b.getCount();
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 h() {
        throw new RuntimeException(" removeByDateToDirection is not implemented by MemoryListEngine !");
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 i(long j, long j2) {
        return a(j2);
    }

    @Override // ir.nasim.DB3
    public boolean isEmpty() {
        return this.b.v();
    }

    @Override // ir.nasim.EB3
    public void j(FB3 fb3) {
        if (this.d.contains(fb3)) {
            return;
        }
        this.d.add(fb3);
    }

    @Override // ir.nasim.DB3
    public List k() {
        return null;
    }

    @Override // ir.nasim.DB3
    public void l(boolean z) {
        this.a.clear();
        if (!z) {
            this.b.clear();
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).b();
        }
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 m() {
        Long lT = this.b.t();
        if (lT == null) {
            return null;
        }
        return G(lT.longValue());
    }

    @Override // ir.nasim.EB3
    public void n(FB3 fb3) {
        this.d.remove(fb3);
    }

    @Override // ir.nasim.EB3
    public void o(long j, int i, GB3 gb3) {
        C(E(gb3), D(this.b.h(Long.valueOf(j), i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public void p(List list, EnumC24659yz5 enumC24659yz5) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
            HB3 hb3 = (HB3) abstractC17902nl0;
            this.a.d(Long.valueOf(hb3.a()), abstractC17902nl0);
            arrayList.add(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        }
        this.b.f(arrayList);
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((FB3) it2.next()).g(list, enumC24659yz5);
        }
    }

    @Override // ir.nasim.EB3
    public void q(String str, int i, GB3 gb3) {
        C(E(gb3), D(this.b.n(str, null, i)));
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 r() {
        Long lU = this.b.u();
        if (lU == null) {
            return null;
        }
        return G(lU.longValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.DB3
    public void s(List list) {
        this.a.clear();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) it.next();
            HB3 hb3 = (HB3) abstractC17902nl0;
            this.a.d(Long.valueOf(hb3.a()), abstractC17902nl0);
            arrayList.add(new IB3(hb3.a(), hb3.j(), hb3.p(), abstractC17902nl0.toByteArray()));
        }
        this.b.clear();
        this.b.f(arrayList);
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((FB3) it2.next()).c(list);
        }
    }

    @Override // ir.nasim.DB3
    public AbstractC17902nl0 t(long j, boolean z) {
        return null;
    }

    @Override // ir.nasim.EB3
    public void u(long j, int i, GB3 gb3) {
        C(E(gb3), D(this.b.p(null, Long.valueOf(j), i)));
    }

    @Override // ir.nasim.DB3
    public void v(AbstractC17902nl0 abstractC17902nl0) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((FB3) it.next()).a(abstractC17902nl0);
        }
    }

    @Override // ir.nasim.EB3
    public void w(int i, GB3 gb3) {
        C(E(gb3), D(this.b.n(null, null, i)));
    }

    @Override // ir.nasim.DB3
    public C6517Nv5 x(String str, long j, EnumC24659yz5 enumC24659yz5, int i, boolean z) {
        throw new RuntimeException(" getItemsByQuery is not implemented by MemoryListEngine !");
    }

    @Override // ir.nasim.EB3
    public void y(int i, GB3 gb3) {
        C(E(gb3), D(this.b.p(null, null, i)));
    }

    @Override // ir.nasim.EB3
    public void z(long j, int i, GB3 gb3) {
        C(E(gb3), D(this.b.n(null, Long.valueOf(j), i)));
    }
}
