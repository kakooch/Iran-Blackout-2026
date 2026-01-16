package ir.nasim;

import androidx.compose.material.AnchoredDragFinishedSignal;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Vm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8322Vm {

    /* renamed from: ir.nasim.Vm$a */
    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ float d;
        final /* synthetic */ C8556Wm e;

        /* renamed from: ir.nasim.Vm$a$a, reason: collision with other inner class name */
        static final class C0715a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C8556Wm c;
            final /* synthetic */ float d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0715a(C8556Wm c8556Wm, float f, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c8556Wm;
                this.d = f;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0715a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    C8556Wm c8556Wm = this.c;
                    float f = this.d;
                    this.b = 1;
                    if (c8556Wm.F(f, this) == objE) {
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
                return ((C0715a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C8556Wm c8556Wm, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = c8556Wm;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC10533bm0.d((InterfaceC20315ro1) this.c, null, null, new C0715a(this.e, this.d, null), 3, null);
            return C19938rB7.a;
        }

        public final Object n(InterfaceC20315ro1 interfaceC20315ro1, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.e, interfaceC20295rm1);
            aVar.c = interfaceC20315ro1;
            aVar.d = f;
            return aVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC20315ro1) obj, ((Number) obj2).floatValue(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.Vm$b */
    static final class b extends AbstractC19859r37 implements InterfaceC16978mB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        /* synthetic */ Object e;
        final /* synthetic */ C8556Wm f;
        final /* synthetic */ float g;

        /* renamed from: ir.nasim.Vm$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC7854Tm e;
            final /* synthetic */ C10873cL5 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC7854Tm interfaceC7854Tm, C10873cL5 c10873cL5) {
                super(2);
                this.e = interfaceC7854Tm;
                this.f = c10873cL5;
            }

            public final void a(float f, float f2) {
                this.e.a(f, f2);
                this.f.a = f;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C8556Wm c8556Wm, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            super(4, interfaceC20295rm1);
            this.f = c8556Wm;
            this.g = f;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC7854Tm interfaceC7854Tm = (InterfaceC7854Tm) this.c;
                float fE = ((KZ1) this.d).e(this.e);
                if (!Float.isNaN(fE)) {
                    C10873cL5 c10873cL5 = new C10873cL5();
                    float fV = Float.isNaN(this.f.v()) ? 0.0f : this.f.v();
                    c10873cL5.a = fV;
                    float f = this.g;
                    InterfaceC5766Kt interfaceC5766KtO = this.f.o();
                    a aVar = new a(interfaceC7854Tm, c10873cL5);
                    this.c = null;
                    this.d = null;
                    this.b = 1;
                    if (AbstractC18086o37.b(fV, fE, f, interfaceC5766KtO, aVar, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object e(InterfaceC7854Tm interfaceC7854Tm, KZ1 kz1, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.f, this.g, interfaceC20295rm1);
            bVar.c = interfaceC7854Tm;
            bVar.d = kz1;
            bVar.e = obj;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Vm$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC8322Vm.i(null, null, this);
        }
    }

    /* renamed from: ir.nasim.Vm$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* renamed from: ir.nasim.Vm$d$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC20315ro1 b;
            final /* synthetic */ InterfaceC14603iB2 c;

            /* renamed from: ir.nasim.Vm$d$a$a, reason: collision with other inner class name */
            static final class C0716a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC14603iB2 c;
                final /* synthetic */ Object d;
                final /* synthetic */ InterfaceC20315ro1 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0716a(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC14603iB2;
                    this.d = obj;
                    this.e = interfaceC20315ro1;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0716a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC14603iB2 interfaceC14603iB2 = this.c;
                        Object obj2 = this.d;
                        this.b = 1;
                        if (interfaceC14603iB2.invoke(obj2, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                    }
                    AbstractC20906so1.c(this.e, new AnchoredDragFinishedSignal());
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0716a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Vm$d$a$b */
            static final class b extends AbstractC22163um1 {
                Object a;
                Object b;
                Object c;
                /* synthetic */ Object d;
                int f;

                b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.d = obj;
                    this.f |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C12889fL5 c12889fL5, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = c12889fL5;
                this.b = interfaceC20315ro1;
                this.c = interfaceC14603iB2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.AbstractC8322Vm.d.a.b
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Vm$d$a$b r0 = (ir.nasim.AbstractC8322Vm.d.a.b) r0
                    int r1 = r0.f
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f = r1
                    goto L18
                L13:
                    ir.nasim.Vm$d$a$b r0 = new ir.nasim.Vm$d$a$b
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.d
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.f
                    r3 = 1
                    if (r2 == 0) goto L3b
                    if (r2 != r3) goto L33
                    java.lang.Object r8 = r0.c
                    ir.nasim.gj3 r8 = (ir.nasim.InterfaceC13730gj3) r8
                    java.lang.Object r8 = r0.b
                    java.lang.Object r0 = r0.a
                    ir.nasim.Vm$d$a r0 = (ir.nasim.AbstractC8322Vm.d.a) r0
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L5e
                L33:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3b:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.fL5 r9 = r7.a
                    java.lang.Object r9 = r9.a
                    ir.nasim.gj3 r9 = (ir.nasim.InterfaceC13730gj3) r9
                    if (r9 == 0) goto L5d
                    androidx.compose.material.AnchoredDragFinishedSignal r2 = new androidx.compose.material.AnchoredDragFinishedSignal
                    r2.<init>()
                    r9.g(r2)
                    r0.a = r7
                    r0.b = r8
                    r0.c = r9
                    r0.f = r3
                    java.lang.Object r9 = r9.k0(r0)
                    if (r9 != r1) goto L5d
                    return r1
                L5d:
                    r0 = r7
                L5e:
                    ir.nasim.fL5 r9 = r0.a
                    ir.nasim.ro1 r1 = r0.b
                    ir.nasim.xo1 r3 = ir.nasim.EnumC23959xo1.UNDISPATCHED
                    ir.nasim.Vm$d$a$a r4 = new ir.nasim.Vm$d$a$a
                    ir.nasim.iB2 r0 = r0.c
                    r2 = 0
                    r4.<init>(r0, r8, r1, r2)
                    r5 = 1
                    r6 = 0
                    ir.nasim.gj3 r8 = ir.nasim.AbstractC9323Zl0.d(r1, r2, r3, r4, r5, r6)
                    r9.a = r8
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8322Vm.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = sa2;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C12889fL5 c12889fL5 = new C12889fL5();
                InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC10222bH6.r(this.d);
                a aVar = new a(c12889fL5, interfaceC20315ro1, this.e);
                this.b = 1;
                if (interfaceC4557Fq2R.b(aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final KZ1 a(UA2 ua2) {
        MZ1 mz1 = new MZ1();
        ua2.invoke(mz1);
        return new PN3(mz1.b());
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, C8556Wm c8556Wm, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC18507om4 interfaceC18507om4, boolean z3) {
        return NZ1.g(eVar, c8556Wm.t(), enumC24286yM4, (32 & 4) != 0 ? true : z, (32 & 8) != 0 ? null : interfaceC18507om4, (32 & 16) != 0 ? false : z3, (32 & 32) != 0 ? NZ1.a : null, (32 & 64) != 0 ? NZ1.b : new a(c8556Wm, null), (32 & 128) != 0 ? false : z2);
    }

    public static /* synthetic */ androidx.compose.ui.e e(androidx.compose.ui.e eVar, C8556Wm c8556Wm, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC18507om4 interfaceC18507om4, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = false;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            interfaceC18507om4 = null;
        }
        InterfaceC18507om4 interfaceC18507om42 = interfaceC18507om4;
        if ((i & 32) != 0) {
            z3 = c8556Wm.x();
        }
        return d(eVar, c8556Wm, enumC24286yM4, z4, z5, interfaceC18507om42, z3);
    }

    public static final Object f(C8556Wm c8556Wm, Object obj, float f, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objK = C8556Wm.k(c8556Wm, obj, null, new b(c8556Wm, f, null), interfaceC20295rm1, 2, null);
        return objK == AbstractC14862ic3.e() ? objK : C19938rB7.a;
    }

    public static /* synthetic */ Object g(C8556Wm c8556Wm, Object obj, float f, InterfaceC20295rm1 interfaceC20295rm1, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = c8556Wm.u();
        }
        return f(c8556Wm, obj, f, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PN3 h() {
        return new PN3(AbstractC20051rO3.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object i(ir.nasim.SA2 r4, ir.nasim.InterfaceC14603iB2 r5, ir.nasim.InterfaceC20295rm1 r6) {
        /*
            boolean r0 = r6 instanceof ir.nasim.AbstractC8322Vm.c
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.Vm$c r0 = (ir.nasim.AbstractC8322Vm.c) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            ir.nasim.Vm$c r0 = new ir.nasim.Vm$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r6)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L43
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.Vm$d r6 = new ir.nasim.Vm$d     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L43
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L43
            r0.b = r3     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L43
            java.lang.Object r4 = ir.nasim.AbstractC20906so1.e(r6, r0)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L43
            if (r4 != r1) goto L43
            return r1
        L43:
            ir.nasim.rB7 r4 = ir.nasim.C19938rB7.a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8322Vm.i(ir.nasim.SA2, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
    }
}
