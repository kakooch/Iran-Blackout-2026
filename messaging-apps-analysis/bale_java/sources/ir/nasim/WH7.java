package ir.nasim;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import ir.nasim.C22473vI3;
import ir.nasim.InterfaceC17505n47;
import ir.nasim.ZV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class WH7 {
    private final Context a;
    private final XV b;
    private final InterfaceC13031fb2 c;
    private final InterfaceC16628lb8 d;
    private final Executor e;
    private final InterfaceC17505n47 f;
    private final QV0 g;
    private final QV0 h;
    private final InterfaceC21340tV0 i;

    public WH7(Context context, XV xv, InterfaceC13031fb2 interfaceC13031fb2, InterfaceC16628lb8 interfaceC16628lb8, Executor executor, InterfaceC17505n47 interfaceC17505n47, QV0 qv0, QV0 qv02, InterfaceC21340tV0 interfaceC21340tV0) {
        this.a = context;
        this.b = xv;
        this.c = interfaceC13031fb2;
        this.d = interfaceC16628lb8;
        this.e = executor;
        this.f = interfaceC17505n47;
        this.g = qv0;
        this.h = qv02;
        this.i = interfaceC21340tV0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean l(AbstractC5792Kv7 abstractC5792Kv7) {
        return Boolean.valueOf(this.c.B1(abstractC5792Kv7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable m(AbstractC5792Kv7 abstractC5792Kv7) {
        return this.c.I1(abstractC5792Kv7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, AbstractC5792Kv7 abstractC5792Kv7, long j) {
        this.c.K0(iterable);
        this.c.t1(abstractC5792Kv7, this.g.getTime() + j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.c.L(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.i.b();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.i.c(((Integer) r0.getValue()).intValue(), C22473vI3.b.INVALID_PAYLOD, (String) ((Map.Entry) it.next()).getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(AbstractC5792Kv7 abstractC5792Kv7, long j) {
        this.c.t1(abstractC5792Kv7, this.g.getTime() + j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object s(AbstractC5792Kv7 abstractC5792Kv7, int i) {
        this.d.b(abstractC5792Kv7, i + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(final AbstractC5792Kv7 abstractC5792Kv7, final int i, Runnable runnable) {
        try {
            try {
                InterfaceC17505n47 interfaceC17505n47 = this.f;
                final InterfaceC13031fb2 interfaceC13031fb2 = this.c;
                Objects.requireNonNull(interfaceC13031fb2);
                interfaceC17505n47.a(new InterfaceC17505n47.a() { // from class: ir.nasim.MH7
                    @Override // ir.nasim.InterfaceC17505n47.a
                    public final Object execute() {
                        return Integer.valueOf(interfaceC13031fb2.cleanUp());
                    }
                });
                if (k()) {
                    u(abstractC5792Kv7, i);
                } else {
                    this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.NH7
                        @Override // ir.nasim.InterfaceC17505n47.a
                        public final Object execute() {
                            return this.a.s(abstractC5792Kv7, i);
                        }
                    });
                }
            } catch (SynchronizationException unused) {
                this.d.b(abstractC5792Kv7, i + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    public AbstractC7747Ta2 j(InterfaceC5558Jv7 interfaceC5558Jv7) {
        InterfaceC17505n47 interfaceC17505n47 = this.f;
        final InterfaceC21340tV0 interfaceC21340tV0 = this.i;
        Objects.requireNonNull(interfaceC21340tV0);
        return interfaceC5558Jv7.b(AbstractC7747Ta2.a().i(this.g.getTime()).k(this.h.getTime()).j("GDT_CLIENT_METRICS").h(new X72(C11515d82.b("proto"), ((C23183wV0) interfaceC17505n47.a(new InterfaceC17505n47.a() { // from class: ir.nasim.LH7
            @Override // ir.nasim.InterfaceC17505n47.a
            public final Object execute() {
                return interfaceC21340tV0.d();
            }
        })).f())).d());
    }

    boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public ZV u(final AbstractC5792Kv7 abstractC5792Kv7, int i) {
        ZV zvA;
        InterfaceC5558Jv7 interfaceC5558Jv7 = this.b.get(abstractC5792Kv7.b());
        long jMax = 0;
        ZV zvE = ZV.e(0L);
        while (true) {
            final long j = jMax;
            while (((Boolean) this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.OH7
                @Override // ir.nasim.InterfaceC17505n47.a
                public final Object execute() {
                    return this.a.l(abstractC5792Kv7);
                }
            })).booleanValue()) {
                final Iterable iterable = (Iterable) this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.PH7
                    @Override // ir.nasim.InterfaceC17505n47.a
                    public final Object execute() {
                        return this.a.m(abstractC5792Kv7);
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return zvE;
                }
                if (interfaceC5558Jv7 == null) {
                    SI3.b("Uploader", "Unknown backend for %s, deleting event batch for it...", abstractC5792Kv7);
                    zvA = ZV.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((U45) it.next()).b());
                    }
                    if (abstractC5792Kv7.e()) {
                        arrayList.add(j(interfaceC5558Jv7));
                    }
                    zvA = interfaceC5558Jv7.a(YV.a().b(arrayList).c(abstractC5792Kv7.c()).a());
                }
                zvE = zvA;
                if (zvE.c() == ZV.a.TRANSIENT_ERROR) {
                    this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.QH7
                        @Override // ir.nasim.InterfaceC17505n47.a
                        public final Object execute() {
                            return this.a.n(iterable, abstractC5792Kv7, j);
                        }
                    });
                    this.d.a(abstractC5792Kv7, i + 1, true);
                    return zvE;
                }
                this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.RH7
                    @Override // ir.nasim.InterfaceC17505n47.a
                    public final Object execute() {
                        return this.a.o(iterable);
                    }
                });
                if (zvE.c() == ZV.a.OK) {
                    jMax = Math.max(j, zvE.b());
                    if (abstractC5792Kv7.e()) {
                        this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.SH7
                            @Override // ir.nasim.InterfaceC17505n47.a
                            public final Object execute() {
                                return this.a.p();
                            }
                        });
                    }
                } else if (zvE.c() == ZV.a.INVALID_PAYLOAD) {
                    final HashMap map = new HashMap();
                    Iterator it2 = iterable.iterator();
                    while (it2.hasNext()) {
                        String strJ = ((U45) it2.next()).b().j();
                        if (map.containsKey(strJ)) {
                            map.put(strJ, Integer.valueOf(((Integer) map.get(strJ)).intValue() + 1));
                        } else {
                            map.put(strJ, 1);
                        }
                    }
                    this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.TH7
                        @Override // ir.nasim.InterfaceC17505n47.a
                        public final Object execute() {
                            return this.a.q(map);
                        }
                    });
                }
            }
            this.f.a(new InterfaceC17505n47.a() { // from class: ir.nasim.UH7
                @Override // ir.nasim.InterfaceC17505n47.a
                public final Object execute() {
                    return this.a.r(abstractC5792Kv7, j);
                }
            });
            return zvE;
        }
    }

    public void v(final AbstractC5792Kv7 abstractC5792Kv7, final int i, final Runnable runnable) {
        this.e.execute(new Runnable() { // from class: ir.nasim.KH7
            @Override // java.lang.Runnable
            public final void run() {
                this.a.t(abstractC5792Kv7, i, runnable);
            }
        });
    }
}
