package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC15087iz3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20267rj3;
import ir.nasim.C12366eV1;
import ir.nasim.C19938rB7;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;

/* loaded from: classes2.dex */
public final class l extends AbstractC15087iz3 implements n {
    private final j a;
    private final InterfaceC11938do1 b;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = l.this.new a(interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
            if (l.this.a().b().compareTo(j.b.INITIALIZED) >= 0) {
                l.this.a().a(l.this);
            } else {
                AbstractC20267rj3.e(interfaceC20315ro1.getCoroutineContext(), null, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public l(j jVar, InterfaceC11938do1 interfaceC11938do1) {
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.i(interfaceC11938do1, "coroutineContext");
        this.a = jVar;
        this.b = interfaceC11938do1;
        if (a().b() == j.b.DESTROYED) {
            AbstractC20267rj3.e(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // ir.nasim.AbstractC15087iz3
    public j a() {
        return this.a;
    }

    public final void f() {
        AbstractC10533bm0.d(this, C12366eV1.c().F0(), null, new a(null), 2, null);
    }

    @Override // ir.nasim.InterfaceC20315ro1
    public InterfaceC11938do1 getCoroutineContext() {
        return this.b;
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "event");
        if (a().b().compareTo(j.b.DESTROYED) <= 0) {
            a().d(this);
            AbstractC20267rj3.e(getCoroutineContext(), null, 1, null);
        }
    }
}
