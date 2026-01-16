package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC20906so1;
import ir.nasim.AbstractC9323Zl0;
import ir.nasim.C12366eV1;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.C9475a16;
import ir.nasim.HE0;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC19699qn4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.WM3;

/* loaded from: classes2.dex */
public abstract class w {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ j d;
        final /* synthetic */ j.b e;
        final /* synthetic */ InterfaceC14603iB2 f;

        /* renamed from: androidx.lifecycle.w$a$a, reason: collision with other inner class name */
        static final class C0094a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            Object c;
            Object d;
            Object e;
            Object f;
            Object g;
            int h;
            final /* synthetic */ j i;
            final /* synthetic */ j.b j;
            final /* synthetic */ InterfaceC20315ro1 k;
            final /* synthetic */ InterfaceC14603iB2 l;

            /* renamed from: androidx.lifecycle.w$a$a$a, reason: collision with other inner class name */
            static final class C0095a implements n {
                final /* synthetic */ j.a a;
                final /* synthetic */ C12889fL5 b;
                final /* synthetic */ InterfaceC20315ro1 c;
                final /* synthetic */ j.a d;
                final /* synthetic */ HE0 e;
                final /* synthetic */ InterfaceC19699qn4 f;
                final /* synthetic */ InterfaceC14603iB2 g;

                /* renamed from: androidx.lifecycle.w$a$a$a$a, reason: collision with other inner class name */
                static final class C0096a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    Object c;
                    int d;
                    final /* synthetic */ InterfaceC19699qn4 e;
                    final /* synthetic */ InterfaceC14603iB2 f;

                    /* renamed from: androidx.lifecycle.w$a$a$a$a$a, reason: collision with other inner class name */
                    static final class C0097a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                        int b;
                        private /* synthetic */ Object c;
                        final /* synthetic */ InterfaceC14603iB2 d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C0097a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                            super(2, interfaceC20295rm1);
                            this.d = interfaceC14603iB2;
                        }

                        @Override // ir.nasim.E90
                        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                            C0097a c0097a = new C0097a(this.d, interfaceC20295rm1);
                            c0097a.c = obj;
                            return c0097a;
                        }

                        @Override // ir.nasim.E90
                        public final Object invokeSuspend(Object obj) {
                            Object objE = AbstractC14862ic3.e();
                            int i = this.b;
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                                this.b = 1;
                                if (interfaceC14603iB2.invoke(interfaceC20315ro1, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                AbstractC10685c16.b(obj);
                            }
                            return C19938rB7.a;
                        }

                        @Override // ir.nasim.InterfaceC14603iB2
                        /* renamed from: n, reason: merged with bridge method [inline-methods] */
                        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                            return ((C0097a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0096a(InterfaceC19699qn4 interfaceC19699qn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.e = interfaceC19699qn4;
                        this.f = interfaceC14603iB2;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C0096a(this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        InterfaceC19699qn4 interfaceC19699qn4;
                        InterfaceC14603iB2 interfaceC14603iB2;
                        InterfaceC19699qn4 interfaceC19699qn42;
                        Throwable th;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.d;
                        try {
                            if (i == 0) {
                                AbstractC10685c16.b(obj);
                                interfaceC19699qn4 = this.e;
                                interfaceC14603iB2 = this.f;
                                this.b = interfaceC19699qn4;
                                this.c = interfaceC14603iB2;
                                this.d = 1;
                                if (interfaceC19699qn4.a(null, this) == objE) {
                                    return objE;
                                }
                            } else {
                                if (i != 1) {
                                    if (i != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    interfaceC19699qn42 = (InterfaceC19699qn4) this.b;
                                    try {
                                        AbstractC10685c16.b(obj);
                                        C19938rB7 c19938rB7 = C19938rB7.a;
                                        interfaceC19699qn42.e(null);
                                        return C19938rB7.a;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        interfaceC19699qn42.e(null);
                                        throw th;
                                    }
                                }
                                interfaceC14603iB2 = (InterfaceC14603iB2) this.c;
                                InterfaceC19699qn4 interfaceC19699qn43 = (InterfaceC19699qn4) this.b;
                                AbstractC10685c16.b(obj);
                                interfaceC19699qn4 = interfaceC19699qn43;
                            }
                            C0097a c0097a = new C0097a(interfaceC14603iB2, null);
                            this.b = interfaceC19699qn4;
                            this.c = null;
                            this.d = 2;
                            if (AbstractC20906so1.e(c0097a, this) == objE) {
                                return objE;
                            }
                            interfaceC19699qn42 = interfaceC19699qn4;
                            C19938rB7 c19938rB72 = C19938rB7.a;
                            interfaceC19699qn42.e(null);
                            return C19938rB7.a;
                        } catch (Throwable th3) {
                            interfaceC19699qn42 = interfaceC19699qn4;
                            th = th3;
                            interfaceC19699qn42.e(null);
                            throw th;
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C0096a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                C0095a(j.a aVar, C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, j.a aVar2, HE0 he0, InterfaceC19699qn4 interfaceC19699qn4, InterfaceC14603iB2 interfaceC14603iB2) {
                    this.a = aVar;
                    this.b = c12889fL5;
                    this.c = interfaceC20315ro1;
                    this.d = aVar2;
                    this.e = he0;
                    this.f = interfaceC19699qn4;
                    this.g = interfaceC14603iB2;
                }

                @Override // androidx.lifecycle.n
                public final void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
                    AbstractC13042fc3.i(interfaceC18633oz3, "<anonymous parameter 0>");
                    AbstractC13042fc3.i(aVar, "event");
                    if (aVar == this.a) {
                        this.b.a = AbstractC10533bm0.d(this.c, null, null, new C0096a(this.f, this.g, null), 3, null);
                        return;
                    }
                    if (aVar == this.d) {
                        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.b.a;
                        if (interfaceC13730gj3 != null) {
                            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
                        }
                        this.b.a = null;
                    }
                    if (aVar == j.a.ON_DESTROY) {
                        HE0 he0 = this.e;
                        C9475a16.a aVar2 = C9475a16.b;
                        he0.resumeWith(C9475a16.b(C19938rB7.a));
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0094a(j jVar, j.b bVar, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.i = jVar;
                this.j = bVar;
                this.k = interfaceC20315ro1;
                this.l = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0094a(this.i, this.j, this.k, this.l, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x00b7  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00d9  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 223
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.w.a.C0094a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0094a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(j jVar, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = jVar;
            this.e = bVar;
            this.f = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                WM3 wm3F0 = C12366eV1.c().F0();
                C0094a c0094a = new C0094a(this.d, this.e, interfaceC20315ro1, this.f, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(wm3F0, c0094a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final Object a(j jVar, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        if (bVar == j.b.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        }
        if (jVar.b() == j.b.DESTROYED) {
            return C19938rB7.a;
        }
        Object objE = AbstractC20906so1.e(new a(jVar, bVar, interfaceC14603iB2, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public static final Object b(InterfaceC18633oz3 interfaceC18633oz3, j.b bVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = a(interfaceC18633oz3.getLifecycle(), bVar, interfaceC14603iB2, interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }
}
