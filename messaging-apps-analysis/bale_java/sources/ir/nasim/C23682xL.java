package ir.nasim;

import ir.nasim.SK;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.xL, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23682xL extends Z6 {
    private static int b;

    public C23682xL(final AbstractC9119Yo3 abstractC9119Yo3, String str) {
        C12736f7 c12736f7N = C12736f7.n();
        C4614Fw5 c4614Fw5A = C4614Fw5.d(new V6() { // from class: ir.nasim.rL
            @Override // ir.nasim.V6
            public final K6 create() {
                return C23682xL.D(abstractC9119Yo3);
            }
        }).a(str);
        StringBuilder sb = new StringBuilder();
        sb.append("keyValue_engine//");
        int i = b;
        b = i + 1;
        sb.append(i);
        super(c12736f7N.c(c4614Fw5A, sb.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(Object obj) {
        synchronized (obj) {
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Object obj, List list, AbstractC17902nl0 abstractC17902nl0) {
        synchronized (obj) {
            if (abstractC17902nl0 != null) {
                try {
                    list.add(abstractC17902nl0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Object obj, List list, List list2) {
        synchronized (obj) {
            list.addAll(list2);
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ K6 D(AbstractC9119Yo3 abstractC9119Yo3) {
        return new SK(abstractC9119Yo3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Object obj) {
        synchronized (obj) {
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(Object obj) {
        synchronized (obj) {
            obj.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Object obj) {
        synchronized (obj) {
            obj.notify();
        }
    }

    public void F(long j) {
        final Object obj = new Object();
        synchronized (obj) {
            try {
                i(new SK.k(j, new SK.l() { // from class: ir.nasim.tL
                    @Override // ir.nasim.SK.l
                    public final void K() {
                        C23682xL.E(obj);
                    }
                }));
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q(List list) {
        final Object obj = new Object();
        synchronized (obj) {
            try {
                i(new SK.a(list, new SK.l() { // from class: ir.nasim.sL
                    @Override // ir.nasim.SK.l
                    public final void K() {
                        C23682xL.y(obj);
                    }
                }));
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void r() {
        final Object obj = new Object();
        synchronized (obj) {
            try {
                i(new SK.b(new SK.l() { // from class: ir.nasim.vL
                    @Override // ir.nasim.SK.l
                    public final void K() {
                        C23682xL.z(obj);
                    }
                }));
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s() {
        final Object obj = new Object();
        synchronized (obj) {
            try {
                i(new SK.c(new SK.l() { // from class: ir.nasim.wL
                    @Override // ir.nasim.SK.l
                    public final void K() {
                        C23682xL.A(obj);
                    }
                }));
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6517Nv5 t() {
        return c(new SK.d());
    }

    public AbstractC17902nl0 u(long j) {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                i(new SK.e(j, new SK.i() { // from class: ir.nasim.qL
                    @Override // ir.nasim.SK.i
                    public final void a(AbstractC17902nl0 abstractC17902nl0) {
                        C23682xL.B(obj, arrayList, abstractC17902nl0);
                    }
                }));
                try {
                    obj.wait();
                    if (arrayList.size() <= 0) {
                        return null;
                    }
                    return (AbstractC17902nl0) arrayList.get(0);
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C6517Nv5 v(long j) {
        return c(new SK.f(j));
    }

    public List w(List list) {
        final Object obj = new Object();
        final ArrayList arrayList = new ArrayList();
        synchronized (obj) {
            try {
                i(new SK.g(list, new SK.j() { // from class: ir.nasim.uL
                    @Override // ir.nasim.SK.j
                    public final void a(List list2) {
                        C23682xL.C(obj, arrayList, list2);
                    }
                }));
                try {
                    obj.wait();
                } catch (InterruptedException unused) {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public C6517Nv5 x(List list) {
        return c(new SK.h(list));
    }
}
