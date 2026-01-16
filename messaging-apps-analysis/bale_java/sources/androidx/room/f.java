package androidx.room;

import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14251hc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6929Po7;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.D26;
import ir.nasim.HE0;
import ir.nasim.IE0;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC22753vm1;
import ir.nasim.UA2;
import ir.nasim.WA1;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes2.dex */
public abstract class f {

    static final class a implements Runnable {
        final /* synthetic */ InterfaceC11938do1 a;
        final /* synthetic */ HE0 b;
        final /* synthetic */ D26 c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* renamed from: androidx.room.f$a$a, reason: collision with other inner class name */
        static final class C0123a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ D26 d;
            final /* synthetic */ HE0 e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0123a(D26 d26, HE0 he0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = d26;
                this.e = he0;
                this.f = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0123a c0123a = new C0123a(this.d, this.e, this.f, interfaceC20295rm1);
                c0123a.c = obj;
                return c0123a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                InterfaceC20295rm1 interfaceC20295rm1;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC11938do1.b bVarA = ((InterfaceC20315ro1) this.c).getCoroutineContext().a(InterfaceC22753vm1.g0);
                    AbstractC13042fc3.f(bVarA);
                    InterfaceC11938do1 interfaceC11938do1B = f.b(this.d, (InterfaceC22753vm1) bVarA);
                    HE0 he0 = this.e;
                    C9475a16.a aVar = C9475a16.b;
                    InterfaceC14603iB2 interfaceC14603iB2 = this.f;
                    this.c = he0;
                    this.b = 1;
                    obj = AbstractC9323Zl0.g(interfaceC11938do1B, interfaceC14603iB2, this);
                    if (obj == objE) {
                        return objE;
                    }
                    interfaceC20295rm1 = he0;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    interfaceC20295rm1 = (InterfaceC20295rm1) this.c;
                    AbstractC10685c16.b(obj);
                }
                interfaceC20295rm1.resumeWith(C9475a16.b(obj));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0123a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC11938do1 interfaceC11938do1, HE0 he0, D26 d26, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC11938do1;
            this.b = he0;
            this.c = d26;
            this.d = interfaceC14603iB2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AbstractC9323Zl0.e(this.a.l(InterfaceC22753vm1.g0), new C0123a(this.c, this.b, this.d, null));
            } catch (Throwable th) {
                this.b.F(th);
            }
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ D26 d;
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(D26 d26, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = d26;
            this.e = ua2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            g gVar;
            g gVarE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC11938do1.b bVarA = ((InterfaceC20315ro1) this.c).getCoroutineContext().a(g.c);
                    AbstractC13042fc3.f(bVarA);
                    g gVar2 = (g) bVarA;
                    gVar2.f();
                    try {
                        this.d.e();
                        try {
                            UA2 ua2 = this.e;
                            this.c = gVar2;
                            this.b = 1;
                            Object objInvoke = ua2.invoke(this);
                            if (objInvoke == gVarE) {
                                return gVarE;
                            }
                            gVar = gVar2;
                            obj = objInvoke;
                        } catch (Throwable th2) {
                            th = th2;
                            this.d.j();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        gVarE = gVar2;
                        th = th3;
                        gVarE.i();
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    gVar = (g) this.c;
                    try {
                        AbstractC10685c16.b(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        this.d.j();
                        throw th;
                    }
                }
                this.d.F();
                this.d.j();
                gVar.i();
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC11938do1 b(D26 d26, InterfaceC22753vm1 interfaceC22753vm1) {
        g gVar = new g(interfaceC22753vm1);
        return interfaceC22753vm1.X(gVar).X(AbstractC6929Po7.a(d26.s(), Integer.valueOf(System.identityHashCode(gVar))));
    }

    private static final Object c(D26 d26, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        try {
            d26.t().execute(new a(interfaceC11938do1, ie0, d26, interfaceC14603iB2));
        } catch (RejectedExecutionException e) {
            ie0.F(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    public static final Object d(D26 d26, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        b bVar = new b(d26, ua2, null);
        g gVar = (g) interfaceC20295rm1.getContext().a(g.c);
        InterfaceC22753vm1 interfaceC22753vm1H = gVar != null ? gVar.h() : null;
        return interfaceC22753vm1H != null ? AbstractC9323Zl0.g(interfaceC22753vm1H, bVar, interfaceC20295rm1) : c(d26, interfaceC20295rm1.getContext(), bVar, interfaceC20295rm1);
    }
}
