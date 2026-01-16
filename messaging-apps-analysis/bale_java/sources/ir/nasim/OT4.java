package ir.nasim;

import androidx.recyclerview.widget.C1976b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC13460gG3;

/* loaded from: classes2.dex */
public abstract class OT4 extends RecyclerView.h {
    private boolean d;
    private final XK e;
    private final InterfaceC4557Fq2 f;
    private final InterfaceC4557Fq2 g;

    public static final class a extends RecyclerView.j {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public void d(int i, int i2) {
            OT4.z(OT4.this);
            OT4.this.unregisterAdapterDataObserver(this);
            super.d(i, i2);
        }
    }

    public static final class b implements UA2 {
        private boolean a = true;

        b() {
        }

        public void a(C13628gZ0 c13628gZ0) {
            AbstractC13042fc3.i(c13628gZ0, "loadStates");
            if (this.a) {
                this.a = false;
            } else if (c13628gZ0.e().f() instanceof AbstractC13460gG3.c) {
                OT4.z(OT4.this);
                OT4.this.H(this);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13628gZ0) obj);
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC14051hG3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC14051hG3 abstractC14051hG3) {
            super(1);
            this.e = abstractC14051hG3;
        }

        public final void a(C13628gZ0 c13628gZ0) {
            AbstractC13042fc3.i(c13628gZ0, "loadStates");
            this.e.D(c13628gZ0.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C13628gZ0) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ OT4(i.f fVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12, int i, ED1 ed1) {
        this(fVar, (i & 2) != 0 ? C12366eV1.c() : interfaceC11938do1, (i & 4) != 0 ? C12366eV1.a() : interfaceC11938do12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(OT4 ot4) {
        if (ot4.getStateRestorationPolicy() != RecyclerView.h.a.PREVENT || ot4.d) {
            return;
        }
        ot4.setStateRestorationPolicy(RecyclerView.h.a.ALLOW);
    }

    public final void B(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.e.k(ua2);
    }

    public final void C(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.e.m(sa2);
    }

    protected final Object D(int i) {
        return this.e.o(i);
    }

    public final InterfaceC4557Fq2 E() {
        return this.f;
    }

    public final InterfaceC4557Fq2 F() {
        return this.g;
    }

    public final void G() {
        this.e.u();
    }

    public final void H(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "listener");
        this.e.v(ua2);
    }

    public final void I(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "listener");
        this.e.w(sa2);
    }

    public final void J() {
        this.e.x();
    }

    public final C11066cg3 K() {
        return this.e.y();
    }

    public final Object L(NT4 nt4, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objZ = this.e.z(nt4, interfaceC20295rm1);
        return objZ == AbstractC14862ic3.e() ? objZ : C19938rB7.a;
    }

    public final void M(androidx.lifecycle.j jVar, NT4 nt4) {
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.i(nt4, "pagingData");
        this.e.A(jVar, nt4);
    }

    public final androidx.recyclerview.widget.f N(AbstractC14051hG3 abstractC14051hG3) {
        AbstractC13042fc3.i(abstractC14051hG3, "footer");
        B(new c(abstractC14051hG3));
        return new androidx.recyclerview.widget.f(this, abstractC14051hG3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final long getItemId(int i) {
        return super.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable ids are unsupported on PagingDataAdapter.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void setStateRestorationPolicy(RecyclerView.h.a aVar) {
        AbstractC13042fc3.i(aVar, "strategy");
        this.d = true;
        super.setStateRestorationPolicy(aVar);
    }

    public OT4(i.f fVar, InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1 interfaceC11938do12) {
        AbstractC13042fc3.i(fVar, "diffCallback");
        AbstractC13042fc3.i(interfaceC11938do1, "mainDispatcher");
        AbstractC13042fc3.i(interfaceC11938do12, "workerDispatcher");
        XK xk = new XK(fVar, new C1976b(this), interfaceC11938do1, interfaceC11938do12);
        this.e = xk;
        super.setStateRestorationPolicy(RecyclerView.h.a.PREVENT);
        registerAdapterDataObserver(new a());
        B(new b());
        this.f = xk.q();
        this.g = xk.s();
    }
}
