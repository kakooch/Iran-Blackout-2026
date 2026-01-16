package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC22753vm1;

/* renamed from: ir.nasim.go1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13778go1 extends L0 implements InterfaceC22753vm1 {
    public static final a b = new a(null);

    /* renamed from: ir.nasim.go1$a */
    public static final class a extends M0 {

        /* renamed from: ir.nasim.go1$a$a, reason: collision with other inner class name */
        static final class C1261a extends AbstractC8614Ws3 implements UA2 {
            public static final C1261a e = new C1261a();

            C1261a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC13778go1 invoke(InterfaceC11938do1.b bVar) {
                if (bVar instanceof AbstractC13778go1) {
                    return (AbstractC13778go1) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        private a() {
            super(InterfaceC22753vm1.g0, C1261a.e);
        }
    }

    public AbstractC13778go1() {
        super(InterfaceC22753vm1.g0);
    }

    public boolean A0(InterfaceC11938do1 interfaceC11938do1) {
        return true;
    }

    public AbstractC13778go1 B0(int i) {
        AbstractC3703Bz3.a(i);
        return new C3464Az3(this, i);
    }

    @Override // ir.nasim.L0, ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC22753vm1.a.a(this, cVar);
    }

    @Override // ir.nasim.L0, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC22753vm1.a.b(this, cVar);
    }

    @Override // ir.nasim.InterfaceC22753vm1
    public final InterfaceC20295rm1 m0(InterfaceC20295rm1 interfaceC20295rm1) {
        return new TU1(this, interfaceC20295rm1);
    }

    public String toString() {
        return YA1.a(this) + '@' + YA1.b(this);
    }

    @Override // ir.nasim.InterfaceC22753vm1
    public final void u(InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((TU1) interfaceC20295rm1).o();
    }

    public abstract void x0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable);

    public void z0(InterfaceC11938do1 interfaceC11938do1, Runnable runnable) {
        x0(interfaceC11938do1, runnable);
    }
}
