package ir.nasim;

import androidx.compose.animation.core.MutationInterruptedException;
import ir.nasim.InterfaceC11938do1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.ln4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16744ln4 {
    private final AtomicReference a = new AtomicReference(null);
    private final InterfaceC19699qn4 b = AbstractC20899sn4.b(false, 1, null);

    /* renamed from: ir.nasim.ln4$a */
    private static final class a {
        private final EnumC16153kn4 a;
        private final InterfaceC13730gj3 b;

        public a(EnumC16153kn4 enumC16153kn4, InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = enumC16153kn4;
            this.b = interfaceC13730gj3;
        }

        public final boolean a(a aVar) {
            return this.a.compareTo(aVar.a) >= 0;
        }

        public final void b() {
            this.b.g(new MutationInterruptedException());
        }
    }

    /* renamed from: ir.nasim.ln4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ EnumC16153kn4 g;
        final /* synthetic */ C16744ln4 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC16153kn4 enumC16153kn4, C16744ln4 c16744ln4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = enumC16153kn4;
            this.h = c16744ln4;
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
            C16744ln4 c16744ln4;
            a aVar2;
            Throwable th;
            C16744ln4 c16744ln42;
            InterfaceC19699qn4 interfaceC19699qn42;
            Object objE = AbstractC14862ic3.e();
            ?? r1 = this.e;
            try {
                try {
                    if (r1 == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.f;
                        EnumC16153kn4 enumC16153kn4 = this.g;
                        InterfaceC11938do1.b bVarA = interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
                        AbstractC13042fc3.f(bVarA);
                        a aVar3 = new a(enumC16153kn4, (InterfaceC13730gj3) bVarA);
                        this.h.f(aVar3);
                        interfaceC19699qn4 = this.h.b;
                        UA2 ua22 = this.i;
                        C16744ln4 c16744ln43 = this.h;
                        this.f = aVar3;
                        this.b = interfaceC19699qn4;
                        this.c = ua22;
                        this.d = c16744ln43;
                        this.e = 1;
                        if (interfaceC19699qn4.a(null, this) == objE) {
                            return objE;
                        }
                        ua2 = ua22;
                        aVar = aVar3;
                        c16744ln4 = c16744ln43;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c16744ln42 = (C16744ln4) this.c;
                            interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                            aVar2 = (a) this.f;
                            try {
                                AbstractC10685c16.b(obj);
                                AbstractC16775lq5.a(c16744ln42.a, aVar2, null);
                                interfaceC19699qn42.e(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                AbstractC16775lq5.a(c16744ln42.a, aVar2, null);
                                throw th;
                            }
                        }
                        c16744ln4 = (C16744ln4) this.d;
                        ua2 = (UA2) this.c;
                        InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                        aVar = (a) this.f;
                        AbstractC10685c16.b(obj);
                        interfaceC19699qn4 = interfaceC19699qn43;
                    }
                    this.f = aVar;
                    this.b = interfaceC19699qn4;
                    this.c = c16744ln4;
                    this.d = null;
                    this.e = 2;
                    Object objInvoke = ua2.invoke(this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    c16744ln42 = c16744ln4;
                    interfaceC19699qn42 = interfaceC19699qn4;
                    obj = objInvoke;
                    aVar2 = aVar;
                    AbstractC16775lq5.a(c16744ln42.a, aVar2, null);
                    interfaceC19699qn42.e(null);
                    return obj;
                } catch (Throwable th3) {
                    aVar2 = aVar;
                    th = th3;
                    c16744ln42 = c16744ln4;
                    AbstractC16775lq5.a(c16744ln42.a, aVar2, null);
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

    public static /* synthetic */ Object e(C16744ln4 c16744ln4, EnumC16153kn4 enumC16153kn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC16153kn4 = EnumC16153kn4.a;
        }
        return c16744ln4.d(enumC16153kn4, ua2, interfaceC20295rm1);
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

    public final Object d(EnumC16153kn4 enumC16153kn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new b(enumC16153kn4, this, ua2, null), interfaceC20295rm1);
    }
}
