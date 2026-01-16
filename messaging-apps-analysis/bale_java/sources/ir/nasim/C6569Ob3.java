package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC19699qn4;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Ob3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6569Ob3 {
    private final AtomicReference a = new AtomicReference(null);
    private final InterfaceC19699qn4 b = AbstractC20899sn4.b(false, 1, null);

    /* renamed from: ir.nasim.Ob3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ EnumC15562jn4 g;
        final /* synthetic */ C6569Ob3 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EnumC15562jn4 enumC15562jn4, C6569Ob3 c6569Ob3, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = enumC15562jn4;
            this.h = c6569Ob3;
            this.i = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.g, this.h, this.i, interfaceC20295rm1);
            aVar.f = obj;
            return aVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, ir.nasim.qn4] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            UA2 ua2;
            b bVar;
            C6569Ob3 c6569Ob3;
            b bVar2;
            Throwable th;
            C6569Ob3 c6569Ob32;
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
                        b bVar3 = new b(enumC15562jn4, (InterfaceC13730gj3) bVarA);
                        this.h.f(bVar3);
                        interfaceC19699qn4 = this.h.b;
                        UA2 ua22 = this.i;
                        C6569Ob3 c6569Ob33 = this.h;
                        this.f = bVar3;
                        this.b = interfaceC19699qn4;
                        this.c = ua22;
                        this.d = c6569Ob33;
                        this.e = 1;
                        if (interfaceC19699qn4.a(null, this) == objE) {
                            return objE;
                        }
                        ua2 = ua22;
                        bVar = bVar3;
                        c6569Ob3 = c6569Ob33;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c6569Ob32 = (C6569Ob3) this.c;
                            interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                            bVar2 = (b) this.f;
                            try {
                                AbstractC10685c16.b(obj);
                                AbstractC16775lq5.a(c6569Ob32.a, bVar2, null);
                                interfaceC19699qn42.e(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                AbstractC16775lq5.a(c6569Ob32.a, bVar2, null);
                                throw th;
                            }
                        }
                        c6569Ob3 = (C6569Ob3) this.d;
                        ua2 = (UA2) this.c;
                        InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                        bVar = (b) this.f;
                        AbstractC10685c16.b(obj);
                        interfaceC19699qn4 = interfaceC19699qn43;
                    }
                    this.f = bVar;
                    this.b = interfaceC19699qn4;
                    this.c = c6569Ob3;
                    this.d = null;
                    this.e = 2;
                    Object objInvoke = ua2.invoke(this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    c6569Ob32 = c6569Ob3;
                    interfaceC19699qn42 = interfaceC19699qn4;
                    obj = objInvoke;
                    bVar2 = bVar;
                    AbstractC16775lq5.a(c6569Ob32.a, bVar2, null);
                    interfaceC19699qn42.e(null);
                    return obj;
                } catch (Throwable th3) {
                    bVar2 = bVar;
                    th = th3;
                    c6569Ob32 = c6569Ob3;
                    AbstractC16775lq5.a(c6569Ob32.a, bVar2, null);
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Ob3$b */
    private static final class b {
        private final EnumC15562jn4 a;
        private final InterfaceC13730gj3 b;

        public b(EnumC15562jn4 enumC15562jn4, InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = enumC15562jn4;
            this.b = interfaceC13730gj3;
        }

        public final boolean a(b bVar) {
            return this.a.compareTo(bVar.a) >= 0;
        }

        public final void b() {
            InterfaceC13730gj3.a.a(this.b, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(b bVar) {
        b bVar2;
        do {
            bVar2 = (b) this.a.get();
            if (bVar2 != null && !bVar.a(bVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!AbstractC16775lq5.a(this.a, bVar2, bVar));
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    public final Object d(EnumC15562jn4 enumC15562jn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new a(enumC15562jn4, this, ua2, null), interfaceC20295rm1);
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
