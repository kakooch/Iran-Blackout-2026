package androidx.camera.view;

import androidx.camera.view.PreviewView;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.AbstractC20567sE0;
import ir.nasim.C20298rm4;
import ir.nasim.FK;
import ir.nasim.HG4;
import ir.nasim.InterfaceC14021hD0;
import ir.nasim.InterfaceC14623iD0;
import ir.nasim.InterfaceC15221jD0;
import ir.nasim.InterfaceC21819uB2;
import ir.nasim.InterfaceFutureC15215jC3;
import ir.nasim.JB0;
import ir.nasim.MB2;
import ir.nasim.NB2;
import ir.nasim.PI3;
import ir.nasim.QB0;
import ir.nasim.WB2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class d implements HG4.a {
    private final InterfaceC14623iD0 a;
    private final C20298rm4 b;
    private PreviewView.f c;
    private final i d;
    InterfaceFutureC15215jC3 e;
    private boolean f = false;

    class a implements MB2 {
        final /* synthetic */ List a;
        final /* synthetic */ InterfaceC14021hD0 b;

        a(List list, InterfaceC14021hD0 interfaceC14021hD0) {
            this.a = list;
            this.b = interfaceC14021hD0;
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            d.this.e = null;
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            d.this.e = null;
            if (this.a.isEmpty()) {
                return;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((InterfaceC14623iD0) this.b).f((JB0) it.next());
            }
            this.a.clear();
        }
    }

    class b extends JB0 {
        final /* synthetic */ AbstractC16967mA0.a a;
        final /* synthetic */ InterfaceC14021hD0 b;

        b(AbstractC16967mA0.a aVar, InterfaceC14021hD0 interfaceC14021hD0) {
            this.a = aVar;
            this.b = interfaceC14021hD0;
        }

        @Override // ir.nasim.JB0
        public void b(int i, QB0 qb0) {
            this.a.c(null);
            ((InterfaceC14623iD0) this.b).f(this);
        }
    }

    d(InterfaceC14623iD0 interfaceC14623iD0, C20298rm4 c20298rm4, i iVar) {
        this.a = interfaceC14623iD0;
        this.b = c20298rm4;
        this.d = iVar;
        synchronized (this) {
            this.c = (PreviewView.f) c20298rm4.f();
        }
    }

    private void f() {
        InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = this.e;
        if (interfaceFutureC15215jC3 != null) {
            interfaceFutureC15215jC3.cancel(false);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceFutureC15215jC3 h(Void r1) {
        return this.d.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void i(Void r1) {
        m(PreviewView.f.STREAMING);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object j(InterfaceC14021hD0 interfaceC14021hD0, List list, AbstractC16967mA0.a aVar) {
        b bVar = new b(aVar, interfaceC14021hD0);
        list.add(bVar);
        ((InterfaceC14623iD0) interfaceC14021hD0).c(AbstractC20567sE0.a(), bVar);
        return "waitForCaptureResult";
    }

    private void l(InterfaceC14021hD0 interfaceC14021hD0) {
        m(PreviewView.f.IDLE);
        ArrayList arrayList = new ArrayList();
        NB2 nb2D = NB2.a(n(interfaceC14021hD0, arrayList)).e(new FK() { // from class: androidx.camera.view.a
            @Override // ir.nasim.FK
            public final InterfaceFutureC15215jC3 apply(Object obj) {
                return this.a.h((Void) obj);
            }
        }, AbstractC20567sE0.a()).d(new InterfaceC21819uB2() { // from class: androidx.camera.view.b
            @Override // ir.nasim.InterfaceC21819uB2
            public final Object apply(Object obj) {
                return this.a.i((Void) obj);
            }
        }, AbstractC20567sE0.a());
        this.e = nb2D;
        WB2.g(nb2D, new a(arrayList, interfaceC14021hD0), AbstractC20567sE0.a());
    }

    private InterfaceFutureC15215jC3 n(final InterfaceC14021hD0 interfaceC14021hD0, final List list) {
        return AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: androidx.camera.view.c
            @Override // ir.nasim.AbstractC16967mA0.c
            public final Object a(AbstractC16967mA0.a aVar) {
                return this.a.j(interfaceC14021hD0, list, aVar);
            }
        });
    }

    @Override // ir.nasim.HG4.a
    public void a(Throwable th) {
        g();
        m(PreviewView.f.IDLE);
    }

    void g() {
        f();
    }

    @Override // ir.nasim.HG4.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void b(InterfaceC15221jD0.a aVar) {
        if (aVar == InterfaceC15221jD0.a.CLOSING || aVar == InterfaceC15221jD0.a.CLOSED || aVar == InterfaceC15221jD0.a.RELEASING || aVar == InterfaceC15221jD0.a.RELEASED) {
            m(PreviewView.f.IDLE);
            if (this.f) {
                this.f = false;
                f();
                return;
            }
            return;
        }
        if ((aVar == InterfaceC15221jD0.a.OPENING || aVar == InterfaceC15221jD0.a.OPEN || aVar == InterfaceC15221jD0.a.PENDING_OPEN) && !this.f) {
            l(this.a);
            this.f = true;
        }
    }

    void m(PreviewView.f fVar) {
        synchronized (this) {
            try {
                if (this.c.equals(fVar)) {
                    return;
                }
                this.c = fVar;
                PI3.a("StreamStateObserver", "Update Preview stream state to " + fVar);
                this.b.n(fVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
