package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC19699qn4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Nb3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6314Nb3 {
    private final AtomicReference a = new AtomicReference(null);
    private final InterfaceC19699qn4 b = AbstractC20899sn4.b(false, 1, null);

    /* renamed from: ir.nasim.Nb3$a */
    private static final class a {
        private final EnumC15562jn4 a;
        private final InterfaceC13730gj3 b;

        public a(EnumC15562jn4 enumC15562jn4, InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = enumC15562jn4;
            this.b = interfaceC13730gj3;
        }

        public final boolean a(a aVar) {
            return this.a.compareTo(aVar.a) >= 0;
        }

        public final void b() {
            InterfaceC13730gj3.a.a(this.b, null, 1, null);
        }
    }

    /* renamed from: ir.nasim.Nb3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ EnumC15562jn4 g;
        final /* synthetic */ C6314Nb3 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC15562jn4 enumC15562jn4, C6314Nb3 c6314Nb3, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = enumC15562jn4;
            this.h = c6314Nb3;
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.g, this.h, this.i, interfaceC20295rm1);
            bVar.f = obj;
            return bVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, ir.nasim.qn4] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            UA2 ua2;
            a aVar;
            C6314Nb3 c6314Nb3;
            a aVar2;
            Throwable th;
            C6314Nb3 c6314Nb32;
            InterfaceC19699qn4 interfaceC19699qn42;
            Object objE = AbstractC14862ic3.e();
            ?? r1 = this.e;
            try {
                try {
                    if (r1 == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                        EnumC15562jn4 enumC15562jn4 = this.g;
                        InterfaceC11938do1.b bVarA = interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
                        AbstractC13042fc3.f(bVarA);
                        a aVar3 = new a(enumC15562jn4, (InterfaceC13730gj3) bVarA);
                        this.h.f(aVar3);
                        interfaceC19699qn4 = this.h.b;
                        UA2 ua22 = this.i;
                        C6314Nb3 c6314Nb33 = this.h;
                        this.f = aVar3;
                        this.b = interfaceC19699qn4;
                        this.c = ua22;
                        this.d = c6314Nb33;
                        this.e = 1;
                        if (interfaceC19699qn4.a(null, this) == objE) {
                            return objE;
                        }
                        ua2 = ua22;
                        aVar = aVar3;
                        c6314Nb3 = c6314Nb33;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c6314Nb32 = (C6314Nb3) this.c;
                            interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                            aVar2 = (a) this.f;
                            try {
                                AbstractC10685c16.b(obj);
                                AbstractC16775lq5.a(c6314Nb32.a, aVar2, null);
                                interfaceC19699qn42.e(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                AbstractC16775lq5.a(c6314Nb32.a, aVar2, null);
                                throw th;
                            }
                        }
                        c6314Nb3 = (C6314Nb3) this.d;
                        ua2 = (UA2) this.c;
                        InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                        aVar = (a) this.f;
                        AbstractC10685c16.b(obj);
                        interfaceC19699qn4 = interfaceC19699qn43;
                    }
                    this.f = aVar;
                    this.b = interfaceC19699qn4;
                    this.c = c6314Nb3;
                    this.d = null;
                    this.e = 2;
                    Object objInvoke = ua2.invoke(this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    c6314Nb32 = c6314Nb3;
                    interfaceC19699qn42 = interfaceC19699qn4;
                    obj = objInvoke;
                    aVar2 = aVar;
                    AbstractC16775lq5.a(c6314Nb32.a, aVar2, null);
                    interfaceC19699qn42.e(null);
                    return obj;
                } catch (Throwable th3) {
                    aVar2 = aVar;
                    th = th3;
                    c6314Nb32 = c6314Nb3;
                    AbstractC16775lq5.a(c6314Nb32.a, aVar2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r1.e(null);
                throw th4;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a aVar) {
        a aVar2;
        do {
            aVar2 = (a) this.a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!AbstractC16775lq5.a(this.a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    public final Object d(EnumC15562jn4 enumC15562jn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new b(enumC15562jn4, this, ua2, null), interfaceC20295rm1);
    }

    public final boolean e(SA2 sa2) {
        boolean zB = InterfaceC19699qn4.a.b(this.b, null, 1, null);
        if (zB) {
            try {
                sa2.invoke();
            } finally {
                InterfaceC19699qn4.a.c(this.b, null, 1, null);
            }
        }
        return zB;
    }
}
