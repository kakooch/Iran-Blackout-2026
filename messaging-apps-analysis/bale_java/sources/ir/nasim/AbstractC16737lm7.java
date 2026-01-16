package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC6693Oo5;

/* renamed from: ir.nasim.lm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16737lm7 {

    /* renamed from: ir.nasim.lm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ InterfaceC18507om4 f;

        /* renamed from: ir.nasim.lm7$a$a, reason: collision with other inner class name */
        static final class C1379a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ InterfaceC18507om4 f;

            /* renamed from: ir.nasim.lm7$a$a$a, reason: collision with other inner class name */
            public static final class C1380a implements KV1 {
                final /* synthetic */ InterfaceC9102Ym4 a;
                final /* synthetic */ InterfaceC18507om4 b;

                public C1380a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC18507om4 interfaceC18507om4) {
                    this.a = interfaceC9102Ym4;
                    this.b = interfaceC18507om4;
                }

                @Override // ir.nasim.KV1
                public void dispose() {
                    InterfaceC6693Oo5.b bVar = (InterfaceC6693Oo5.b) this.a.getValue();
                    if (bVar != null) {
                        InterfaceC6693Oo5.a aVar = new InterfaceC6693Oo5.a(bVar);
                        InterfaceC18507om4 interfaceC18507om4 = this.b;
                        if (interfaceC18507om4 != null) {
                            interfaceC18507om4.a(aVar);
                        }
                        this.a.setValue(null);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1379a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC18507om4 interfaceC18507om4) {
                super(1);
                this.e = interfaceC9102Ym4;
                this.f = interfaceC18507om4;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KV1 invoke(LV1 lv1) {
                return new C1380a(this.e, this.f);
            }
        }

        /* renamed from: ir.nasim.lm7$a$b */
        static final class b implements PointerInputEventHandler {
            final /* synthetic */ InterfaceC20315ro1 a;
            final /* synthetic */ InterfaceC9102Ym4 b;
            final /* synthetic */ InterfaceC18507om4 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* renamed from: ir.nasim.lm7$a$b$a, reason: collision with other inner class name */
            static final class C1381a extends AbstractC19859r37 implements InterfaceC15796kB2 {
                int b;
                private /* synthetic */ Object c;
                /* synthetic */ long d;
                final /* synthetic */ InterfaceC20315ro1 e;
                final /* synthetic */ InterfaceC9102Ym4 f;
                final /* synthetic */ InterfaceC18507om4 g;

                /* renamed from: ir.nasim.lm7$a$b$a$a, reason: collision with other inner class name */
                static final class C1382a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    int c;
                    final /* synthetic */ InterfaceC9102Ym4 d;
                    final /* synthetic */ long e;
                    final /* synthetic */ InterfaceC18507om4 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1382a(InterfaceC9102Ym4 interfaceC9102Ym4, long j, InterfaceC18507om4 interfaceC18507om4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = interfaceC9102Ym4;
                        this.e = j;
                        this.f = interfaceC18507om4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1382a(this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
                    @Override // ir.nasim.E90
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                        /*
                            r7 = this;
                            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                            int r1 = r7.c
                            r2 = 0
                            r3 = 2
                            r4 = 1
                            if (r1 == 0) goto L27
                            if (r1 == r4) goto L1f
                            if (r1 != r3) goto L17
                            java.lang.Object r0 = r7.b
                            ir.nasim.Oo5$b r0 = (ir.nasim.InterfaceC6693Oo5.b) r0
                            ir.nasim.AbstractC10685c16.b(r8)
                            goto L66
                        L17:
                            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r8.<init>(r0)
                            throw r8
                        L1f:
                            java.lang.Object r1 = r7.b
                            ir.nasim.Ym4 r1 = (ir.nasim.InterfaceC9102Ym4) r1
                            ir.nasim.AbstractC10685c16.b(r8)
                            goto L4b
                        L27:
                            ir.nasim.AbstractC10685c16.b(r8)
                            ir.nasim.Ym4 r8 = r7.d
                            java.lang.Object r8 = r8.getValue()
                            ir.nasim.Oo5$b r8 = (ir.nasim.InterfaceC6693Oo5.b) r8
                            if (r8 == 0) goto L4f
                            ir.nasim.om4 r1 = r7.f
                            ir.nasim.Ym4 r5 = r7.d
                            ir.nasim.Oo5$a r6 = new ir.nasim.Oo5$a
                            r6.<init>(r8)
                            if (r1 == 0) goto L4c
                            r7.b = r5
                            r7.c = r4
                            java.lang.Object r8 = r1.c(r6, r7)
                            if (r8 != r0) goto L4a
                            return r0
                        L4a:
                            r1 = r5
                        L4b:
                            r5 = r1
                        L4c:
                            r5.setValue(r2)
                        L4f:
                            ir.nasim.Oo5$b r8 = new ir.nasim.Oo5$b
                            long r4 = r7.e
                            r8.<init>(r4, r2)
                            ir.nasim.om4 r1 = r7.f
                            if (r1 == 0) goto L67
                            r7.b = r8
                            r7.c = r3
                            java.lang.Object r1 = r1.c(r8, r7)
                            if (r1 != r0) goto L65
                            return r0
                        L65:
                            r0 = r8
                        L66:
                            r8 = r0
                        L67:
                            ir.nasim.Ym4 r0 = r7.d
                            r0.setValue(r8)
                            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16737lm7.a.b.C1381a.C1382a.invokeSuspend(java.lang.Object):java.lang.Object");
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1382a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* renamed from: ir.nasim.lm7$a$b$a$b, reason: collision with other inner class name */
                static final class C1383b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    Object b;
                    int c;
                    final /* synthetic */ InterfaceC9102Ym4 d;
                    final /* synthetic */ boolean e;
                    final /* synthetic */ InterfaceC18507om4 f;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C1383b(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z, InterfaceC18507om4 interfaceC18507om4, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = interfaceC9102Ym4;
                        this.e = z;
                        this.f = interfaceC18507om4;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        return new C1383b(this.d, this.e, this.f, interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        InterfaceC9102Ym4 interfaceC9102Ym4;
                        InterfaceC9102Ym4 interfaceC9102Ym42;
                        Object objE = AbstractC14862ic3.e();
                        int i = this.c;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            InterfaceC6693Oo5.b bVar = (InterfaceC6693Oo5.b) this.d.getValue();
                            if (bVar != null) {
                                boolean z = this.e;
                                InterfaceC18507om4 interfaceC18507om4 = this.f;
                                interfaceC9102Ym4 = this.d;
                                InterfaceC22645vb3 cVar = z ? new InterfaceC6693Oo5.c(bVar) : new InterfaceC6693Oo5.a(bVar);
                                if (interfaceC18507om4 != null) {
                                    this.b = interfaceC9102Ym4;
                                    this.c = 1;
                                    if (interfaceC18507om4.c(cVar, this) == objE) {
                                        return objE;
                                    }
                                    interfaceC9102Ym42 = interfaceC9102Ym4;
                                }
                                interfaceC9102Ym4.setValue(null);
                            }
                            return C19938rB7.a;
                        }
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        interfaceC9102Ym42 = (InterfaceC9102Ym4) this.b;
                        AbstractC10685c16.b(obj);
                        interfaceC9102Ym4 = interfaceC9102Ym42;
                        interfaceC9102Ym4.setValue(null);
                        return C19938rB7.a;
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    /* renamed from: n, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                        return ((C1383b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1381a(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC18507om4 interfaceC18507om4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(3, interfaceC20295rm1);
                    this.e = interfaceC20315ro1;
                    this.f = interfaceC9102Ym4;
                    this.g = interfaceC18507om4;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC6194Mo5 interfaceC6194Mo5 = (InterfaceC6194Mo5) this.c;
                        AbstractC10533bm0.d(this.e, null, null, new C1382a(this.f, this.d, this.g, null), 3, null);
                        this.b = 1;
                        obj = interfaceC6194Mo5.R0(this);
                        if (obj == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    AbstractC10533bm0.d(this.e, null, null, new C1383b(this.f, ((Boolean) obj).booleanValue(), this.g, null), 3, null);
                    return C19938rB7.a;
                }

                public final Object n(InterfaceC6194Mo5 interfaceC6194Mo5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1381a c1381a = new C1381a(this.e, this.f, this.g, interfaceC20295rm1);
                    c1381a.c = interfaceC6194Mo5;
                    c1381a.d = j;
                    return c1381a.invokeSuspend(C19938rB7.a);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    return n((InterfaceC6194Mo5) obj, ((ZG4) obj2).t(), (InterfaceC20295rm1) obj3);
                }
            }

            /* renamed from: ir.nasim.lm7$a$b$b, reason: collision with other inner class name */
            static final class C1384b extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ InterfaceC9664aL6 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1384b(InterfaceC9664aL6 interfaceC9664aL6) {
                    super(1);
                    this.e = interfaceC9664aL6;
                }

                public final void a(long j) {
                    ((UA2) this.e.getValue()).invoke(ZG4.d(j));
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a(((ZG4) obj).t());
                    return C19938rB7.a;
                }
            }

            b(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC18507om4 interfaceC18507om4, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = interfaceC20315ro1;
                this.b = interfaceC9102Ym4;
                this.c = interfaceC18507om4;
                this.d = interfaceC9664aL6;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                Object objI = AbstractC20271rj7.i(interfaceC9049Yg5, new C1381a(this.a, this.b, this.c, null), new C1384b(this.d), interfaceC20295rm1);
                return objI == AbstractC14862ic3.e() ? objI : C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2, InterfaceC18507om4 interfaceC18507om4) {
            super(3);
            this.e = ua2;
            this.f = interfaceC18507om4;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-102778667);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-102778667, i, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
            }
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB;
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB2;
            InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(this.e, interfaceC22053ub1, 0);
            InterfaceC18507om4 interfaceC18507om4 = this.f;
            boolean zV = interfaceC22053ub1.V(this.f);
            InterfaceC18507om4 interfaceC18507om42 = this.f;
            Object objB3 = interfaceC22053ub1.B();
            if (zV || objB3 == aVar.a()) {
                objB3 = new C1379a(interfaceC9102Ym4, interfaceC18507om42);
                interfaceC22053ub1.s(objB3);
            }
            AbstractC10721c52.a(interfaceC18507om4, (UA2) objB3, interfaceC22053ub1, 0);
            e.a aVar2 = androidx.compose.ui.e.a;
            InterfaceC18507om4 interfaceC18507om43 = this.f;
            boolean zD = interfaceC22053ub1.D(interfaceC20315ro1) | interfaceC22053ub1.V(this.f) | interfaceC22053ub1.V(interfaceC9664aL6Q);
            InterfaceC18507om4 interfaceC18507om44 = this.f;
            Object objB4 = interfaceC22053ub1.B();
            if (zD || objB4 == aVar.a()) {
                objB4 = new b(interfaceC20315ro1, interfaceC9102Ym4, interfaceC18507om44, interfaceC9664aL6Q);
                interfaceC22053ub1.s(objB4);
            }
            androidx.compose.ui.e eVarC = AbstractC21071t37.c(aVar2, interfaceC18507om43, (PointerInputEventHandler) objB4);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarC;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, boolean z, UA2 ua2) {
        return z ? androidx.compose.ui.c.c(eVar, null, new a(ua2, interfaceC18507om4), 1, null) : eVar;
    }
}
