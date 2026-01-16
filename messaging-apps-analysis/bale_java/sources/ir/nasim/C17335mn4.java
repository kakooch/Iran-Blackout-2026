package ir.nasim;

import androidx.compose.foundation.MutationInterruptedException;
import ir.nasim.InterfaceC11938do1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.mn4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C17335mn4 {
    private final AtomicReference a = new AtomicReference(null);
    private final InterfaceC19699qn4 b = AbstractC20899sn4.b(false, 1, null);

    /* renamed from: ir.nasim.mn4$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;
        final /* synthetic */ EnumC15562jn4 g;
        final /* synthetic */ C17335mn4 h;
        final /* synthetic */ UA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(EnumC15562jn4 enumC15562jn4, C17335mn4 c17335mn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.g = enumC15562jn4;
            this.h = c17335mn4;
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
            c cVar;
            C17335mn4 c17335mn4;
            c cVar2;
            Throwable th;
            C17335mn4 c17335mn42;
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
                        c cVar3 = new c(enumC15562jn4, (InterfaceC13730gj3) bVarA);
                        this.h.g(cVar3);
                        interfaceC19699qn4 = this.h.b;
                        UA2 ua22 = this.i;
                        C17335mn4 c17335mn43 = this.h;
                        this.f = cVar3;
                        this.b = interfaceC19699qn4;
                        this.c = ua22;
                        this.d = c17335mn43;
                        this.e = 1;
                        if (interfaceC19699qn4.a(null, this) == objE) {
                            return objE;
                        }
                        ua2 = ua22;
                        cVar = cVar3;
                        c17335mn4 = c17335mn43;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c17335mn42 = (C17335mn4) this.c;
                            interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                            cVar2 = (c) this.f;
                            try {
                                AbstractC10685c16.b(obj);
                                AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                                interfaceC19699qn42.e(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                                throw th;
                            }
                        }
                        c17335mn4 = (C17335mn4) this.d;
                        ua2 = (UA2) this.c;
                        InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                        cVar = (c) this.f;
                        AbstractC10685c16.b(obj);
                        interfaceC19699qn4 = interfaceC19699qn43;
                    }
                    this.f = cVar;
                    this.b = interfaceC19699qn4;
                    this.c = c17335mn4;
                    this.d = null;
                    this.e = 2;
                    Object objInvoke = ua2.invoke(this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    c17335mn42 = c17335mn4;
                    interfaceC19699qn42 = interfaceC19699qn4;
                    obj = objInvoke;
                    cVar2 = cVar;
                    AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                    interfaceC19699qn42.e(null);
                    return obj;
                } catch (Throwable th3) {
                    cVar2 = cVar;
                    th = th3;
                    c17335mn42 = c17335mn4;
                    AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
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

    /* renamed from: ir.nasim.mn4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        private /* synthetic */ Object g;
        final /* synthetic */ EnumC15562jn4 h;
        final /* synthetic */ C17335mn4 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC15562jn4 enumC15562jn4, C17335mn4 c17335mn4, InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.h = enumC15562jn4;
            this.i = c17335mn4;
            this.j = interfaceC14603iB2;
            this.k = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.h, this.i, this.j, this.k, interfaceC20295rm1);
            bVar.g = obj;
            return bVar;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, ir.nasim.qn4] */
        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC19699qn4 interfaceC19699qn4;
            InterfaceC14603iB2 interfaceC14603iB2;
            Object obj2;
            c cVar;
            C17335mn4 c17335mn4;
            c cVar2;
            Throwable th;
            C17335mn4 c17335mn42;
            InterfaceC19699qn4 interfaceC19699qn42;
            Object objE = AbstractC14862ic3.e();
            ?? r1 = this.f;
            try {
                try {
                    if (r1 == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.g;
                        EnumC15562jn4 enumC15562jn4 = this.h;
                        InterfaceC11938do1.b bVarA = interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
                        AbstractC13042fc3.f(bVarA);
                        c cVar3 = new c(enumC15562jn4, (InterfaceC13730gj3) bVarA);
                        this.i.g(cVar3);
                        interfaceC19699qn4 = this.i.b;
                        interfaceC14603iB2 = this.j;
                        Object obj3 = this.k;
                        C17335mn4 c17335mn43 = this.i;
                        this.g = cVar3;
                        this.b = interfaceC19699qn4;
                        this.c = interfaceC14603iB2;
                        this.d = obj3;
                        this.e = c17335mn43;
                        this.f = 1;
                        if (interfaceC19699qn4.a(null, this) == objE) {
                            return objE;
                        }
                        obj2 = obj3;
                        cVar = cVar3;
                        c17335mn4 = c17335mn43;
                    } else {
                        if (r1 != 1) {
                            if (r1 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            c17335mn42 = (C17335mn4) this.c;
                            interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                            cVar2 = (c) this.g;
                            try {
                                AbstractC10685c16.b(obj);
                                AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                                interfaceC19699qn42.e(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                                throw th;
                            }
                        }
                        c17335mn4 = (C17335mn4) this.e;
                        obj2 = this.d;
                        interfaceC14603iB2 = (InterfaceC14603iB2) this.c;
                        InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                        cVar = (c) this.g;
                        AbstractC10685c16.b(obj);
                        interfaceC19699qn4 = interfaceC19699qn43;
                    }
                    this.g = cVar;
                    this.b = interfaceC19699qn4;
                    this.c = c17335mn4;
                    this.d = null;
                    this.e = null;
                    this.f = 2;
                    Object objInvoke = interfaceC14603iB2.invoke(obj2, this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    c17335mn42 = c17335mn4;
                    interfaceC19699qn42 = interfaceC19699qn4;
                    obj = objInvoke;
                    cVar2 = cVar;
                    AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
                    interfaceC19699qn42.e(null);
                    return obj;
                } catch (Throwable th3) {
                    cVar2 = cVar;
                    th = th3;
                    c17335mn42 = c17335mn4;
                    AbstractC16775lq5.a(c17335mn42.a, cVar2, null);
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

    /* renamed from: ir.nasim.mn4$c */
    private static final class c {
        private final EnumC15562jn4 a;
        private final InterfaceC13730gj3 b;

        public c(EnumC15562jn4 enumC15562jn4, InterfaceC13730gj3 interfaceC13730gj3) {
            this.a = enumC15562jn4;
            this.b = interfaceC13730gj3;
        }

        public final boolean a(c cVar) {
            return this.a.compareTo(cVar.a) >= 0;
        }

        public final void b() {
            this.b.g(new MutationInterruptedException());
        }
    }

    public static /* synthetic */ Object e(C17335mn4 c17335mn4, EnumC15562jn4 enumC15562jn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC15562jn4 = EnumC15562jn4.a;
        }
        return c17335mn4.d(enumC15562jn4, ua2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(c cVar) {
        c cVar2;
        do {
            cVar2 = (c) this.a.get();
            if (cVar2 != null && !cVar.a(cVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!AbstractC16775lq5.a(this.a, cVar2, cVar));
        if (cVar2 != null) {
            cVar2.b();
        }
    }

    public final Object d(EnumC15562jn4 enumC15562jn4, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new a(enumC15562jn4, this, ua2, null), interfaceC20295rm1);
    }

    public final Object f(Object obj, EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC20906so1.e(new b(enumC15562jn4, this, interfaceC14603iB2, obj, null), interfaceC20295rm1);
    }
}
