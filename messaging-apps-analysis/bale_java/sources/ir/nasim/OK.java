package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class OK implements InterfaceC8344Vo3 {
    private final Map a = new ConcurrentHashMap();
    private final List b = new IJ().a();
    private final C23682xL c;

    public OK(AbstractC9119Yo3 abstractC9119Yo3, String str) {
        this.c = new C23682xL(abstractC9119Yo3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(long j, C7234Qv5 c7234Qv5, AbstractC17902nl0 abstractC17902nl0) {
        AbstractC17902nl0 abstractC17902nl02 = (AbstractC17902nl0) this.a.get(Long.valueOf(j));
        if (abstractC17902nl02 != null) {
            c7234Qv5.b(abstractC17902nl02);
            return;
        }
        if (abstractC17902nl0 != null) {
            this.a.put(Long.valueOf(j), abstractC17902nl0);
        }
        c7234Qv5.b(abstractC17902nl0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(final long j, final C7234Qv5 c7234Qv5) {
        AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.a.get(Long.valueOf(j));
        if (abstractC17902nl0 != null) {
            c7234Qv5.b(abstractC17902nl0);
        } else {
            this.c.v(j).m0(new InterfaceC24449ye1() { // from class: ir.nasim.NK
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.o(j, c7234Qv5, (AbstractC17902nl0) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(List list, C7234Qv5 c7234Qv5) {
        C6517Nv5 c6517Nv5X = this.c.x(list);
        Objects.requireNonNull(c7234Qv5);
        c6517Nv5X.m0(new LN2(c7234Qv5));
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 a(final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.LK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.p(j, c7234Qv5);
            }
        });
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void b(long j) {
        AbstractC20507s76.d();
        this.a.remove(Long.valueOf(j));
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC8578Wo3) it.next()).a(j);
        }
        this.c.F(j);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void c(List list) {
        AbstractC20507s76.d();
        for (Object obj : list) {
            this.a.put(Long.valueOf(((InterfaceC8844Xo3) obj).a()), obj);
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC8578Wo3) it.next()).c(list);
        }
        this.c.q(list);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public void clear() {
        AbstractC20507s76.d();
        this.a.clear();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC8578Wo3) it.next()).b();
        }
        this.c.r();
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public /* bridge */ /* synthetic */ InterfaceC8844Xo3 d(long j) {
        return (InterfaceC8844Xo3) n(j);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public List f(List list) {
        return this.c.w(list);
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 g(final List list) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.MK
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.q(list, c7234Qv5);
            }
        });
    }

    @Override // ir.nasim.InterfaceC8344Vo3
    public C6517Nv5 h() {
        AbstractC20507s76.d();
        return this.c.t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ir.nasim.InterfaceC8344Vo3
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void e(AbstractC17902nl0 abstractC17902nl0) {
        AbstractC20507s76.d();
        this.a.put(Long.valueOf(((InterfaceC8844Xo3) abstractC17902nl0).a()), abstractC17902nl0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(abstractC17902nl0);
        this.c.q(arrayList);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC8578Wo3) it.next()).c(arrayList);
        }
    }

    public void m() {
        AbstractC20507s76.d();
        this.a.clear();
        this.c.s();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((InterfaceC8578Wo3) it.next()).b();
        }
    }

    public AbstractC17902nl0 n(long j) {
        AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) this.a.get(Long.valueOf(j));
        if (abstractC17902nl0 != null) {
            return abstractC17902nl0;
        }
        AbstractC20507s76.d();
        AbstractC17902nl0 abstractC17902nl0U = this.c.u(j);
        if (abstractC17902nl0U != null) {
            this.a.put(Long.valueOf(j), abstractC17902nl0U);
        }
        return abstractC17902nl0U;
    }

    public void r(InterfaceC8578Wo3 interfaceC8578Wo3) {
        if (this.b.contains(interfaceC8578Wo3)) {
            return;
        }
        this.b.add(interfaceC8578Wo3);
    }
}
