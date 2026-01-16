package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class VL3 implements InterfaceC8578Wo3 {
    private final OK a;
    private final Map b = new ConcurrentHashMap();
    private final InterfaceC20073rQ7 c;

    public VL3(AbstractC9119Yo3 abstractC9119Yo3, InterfaceC20073rQ7 interfaceC20073rQ7) {
        this.c = interfaceC20073rQ7;
        OK ok = new OK(abstractC9119Yo3, "D_db");
        this.a = ok;
        ok.r(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractC14869id0 q(AbstractC17902nl0 abstractC17902nl0) {
        if (abstractC17902nl0 != null) {
            return this.c.a(abstractC17902nl0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(long j, C7234Qv5 c7234Qv5, AbstractC14869id0 abstractC14869id0) {
        AbstractC14869id0 abstractC14869id02 = (AbstractC14869id0) this.b.get(Long.valueOf(j));
        if (abstractC14869id02 != null) {
            c7234Qv5.b(abstractC14869id02);
        } else if (abstractC14869id0 == null) {
            c7234Qv5.a(new NullPointerException("value is null"));
        } else {
            this.b.put(Long.valueOf(j), abstractC14869id0);
            c7234Qv5.b(abstractC14869id0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final long j, final C7234Qv5 c7234Qv5) {
        AbstractC14869id0 abstractC14869id0 = (AbstractC14869id0) this.b.get(Long.valueOf(j));
        if (abstractC14869id0 != null) {
            c7234Qv5.b(abstractC14869id0);
        } else {
            o().a(j).h0(new InterfaceC17569nB2() { // from class: ir.nasim.PL3
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return this.a.q((AbstractC17902nl0) obj);
                }
            }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.QL3
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    this.a.r(j, c7234Qv5, (AbstractC14869id0) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(List list) {
        for (Object obj : list) {
            InterfaceC8844Xo3 interfaceC8844Xo3 = (InterfaceC8844Xo3) obj;
            if (this.b.containsKey(Long.valueOf(interfaceC8844Xo3.a()))) {
                ((AbstractC14869id0) this.b.get(Long.valueOf(interfaceC8844Xo3.a()))).a(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(long j) {
        this.b.remove(Long.valueOf(j));
    }

    @Override // ir.nasim.InterfaceC8578Wo3
    public void a(final long j) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.RL3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v(j);
            }
        });
    }

    @Override // ir.nasim.InterfaceC8578Wo3
    public void b() {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.TL3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.u();
            }
        });
    }

    @Override // ir.nasim.InterfaceC8578Wo3
    public void c(final List list) {
        AbstractC20507s76.z(new Runnable() { // from class: ir.nasim.SL3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t(list);
            }
        });
    }

    public void j() {
        this.a.clear();
        this.b.clear();
    }

    public C6517Nv5 k(final long j) {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.OL3
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                this.a.s(j, c7234Qv5);
            }
        });
    }

    public C16835lw5 l(ArrayList arrayList) {
        return C16835lw5.K(arrayList).I(new InterfaceC17569nB2() { // from class: ir.nasim.UL3
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.k(((Integer) obj).intValue());
            }
        });
    }

    public List m(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            long jLongValue = l.longValue();
            AbstractC14869id0 abstractC14869id0 = (AbstractC14869id0) this.b.get(l);
            if (abstractC14869id0 == null) {
                AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) o().d(jLongValue);
                if (abstractC17902nl0 != null) {
                    AbstractC14869id0 abstractC14869id0A = this.c.a(abstractC17902nl0);
                    this.b.put(l, abstractC14869id0A);
                    arrayList.add(abstractC14869id0A);
                } else {
                    arrayList.add(null);
                }
            } else {
                arrayList.add(abstractC14869id0);
            }
        }
        return arrayList;
    }

    public AbstractC14869id0 n(long j) {
        if (this.b.get(Long.valueOf(j)) == null) {
            AbstractC17902nl0 abstractC17902nl0 = (AbstractC17902nl0) o().d(j);
            if (abstractC17902nl0 == null) {
                return null;
            }
            try {
                this.b.put(Long.valueOf(j), this.c.a(abstractC17902nl0));
            } catch (ClassCastException unused) {
                C19406qI3.a("MVVMCollectionDebug", "Unable to find object " + j + " -> " + abstractC17902nl0.getClass().getName(), new Object[0]);
            }
        }
        return (AbstractC14869id0) this.b.get(Long.valueOf(j));
    }

    public InterfaceC8344Vo3 o() {
        return this.a;
    }

    public List p(List list) {
        ArrayList arrayList = new ArrayList();
        List listF = o().f(list);
        if (listF == null) {
            return arrayList;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.a((AbstractC17902nl0) it.next()));
        }
        return arrayList;
    }
}
