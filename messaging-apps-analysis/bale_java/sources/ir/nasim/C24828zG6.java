package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.zG6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C24828zG6 implements InterfaceC4031Dj7 {
    private final CG6 a;
    private final InterfaceC10163bB1 b;
    private final InterfaceC5766Kt c;
    private InterfaceC9309Zj4 d = androidx.compose.foundation.gestures.d.f();

    /* renamed from: ir.nasim.zG6$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C24828zG6.this.i(null, 0.0f, null, this);
        }
    }

    /* renamed from: ir.nasim.zG6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ float e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ InterfaceC8748Xd6 g;

        /* renamed from: ir.nasim.zG6$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C10873cL5 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C10873cL5 c10873cL5, UA2 ua2) {
                super(1);
                this.e = c10873cL5;
                this.f = ua2;
            }

            public final void a(float f) {
                C10873cL5 c10873cL5 = this.e;
                float f2 = c10873cL5.a - f;
                c10873cL5.a = f2;
                this.f.invoke(Float.valueOf(f2));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).floatValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.zG6$b$b, reason: collision with other inner class name */
        static final class C1806b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C10873cL5 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1806b(C10873cL5 c10873cL5, UA2 ua2) {
                super(1);
                this.e = c10873cL5;
                this.f = ua2;
            }

            public final void a(float f) {
                C10873cL5 c10873cL5 = this.e;
                float f2 = c10873cL5.a - f;
                c10873cL5.a = f2;
                this.f.invoke(Float.valueOf(f2));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).floatValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(float f, UA2 ua2, InterfaceC8748Xd6 interfaceC8748Xd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = f;
            this.f = ua2;
            this.g = interfaceC8748Xd6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C24828zG6.this.new b(this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C10873cL5 c10873cL5;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                float fB = C24828zG6.this.a.b(this.e, AbstractC11543dB1.a(C24828zG6.this.b, 0.0f, this.e));
                if (!(!Float.isNaN(fB))) {
                    P73.c("calculateApproachOffset returned NaN. Please use a valid value.");
                }
                c10873cL5 = new C10873cL5();
                float fAbs = Math.abs(fB) * Math.signum(this.e);
                c10873cL5.a = fAbs;
                this.f.invoke(AbstractC6392Nk0.c(fAbs));
                C24828zG6 c24828zG6 = C24828zG6.this;
                InterfaceC8748Xd6 interfaceC8748Xd6 = this.g;
                float f = c10873cL5.a;
                float f2 = this.e;
                C1806b c1806b = new C1806b(c10873cL5, this.f);
                this.b = c10873cL5;
                this.c = 1;
                obj = c24828zG6.l(interfaceC8748Xd6, f, f2, c1806b, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        AbstractC10685c16.b(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c10873cL5 = (C10873cL5) this.b;
                AbstractC10685c16.b(obj);
            }
            C6233Mt c6233Mt = (C6233Mt) obj;
            float fA = C24828zG6.this.a.a(((Number) c6233Mt.z()).floatValue());
            if (!(true ^ Float.isNaN(fA))) {
                P73.c("calculateSnapOffset returned NaN. Please use a valid value.");
            }
            c10873cL5.a = fA;
            InterfaceC8748Xd6 interfaceC8748Xd62 = this.g;
            C6233Mt c6233MtG = AbstractC6483Nt.g(c6233Mt, 0.0f, 0.0f, 0L, 0L, false, 30, null);
            InterfaceC5766Kt interfaceC5766Kt = C24828zG6.this.c;
            a aVar = new a(c10873cL5, this.f);
            this.b = null;
            this.c = 2;
            obj = AG6.h(interfaceC8748Xd62, fA, fA, c6233MtG, interfaceC5766Kt, aVar, this);
            return obj == objE ? objE : obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.zG6$c */
    static final class c extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C24828zG6.this.b(null, 0.0f, null, this);
        }
    }

    /* renamed from: ir.nasim.zG6$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return C24828zG6.this.l(null, 0.0f, 0.0f, null, this);
        }
    }

    public C24828zG6(CG6 cg6, InterfaceC10163bB1 interfaceC10163bB1, InterfaceC5766Kt interfaceC5766Kt) {
        this.a = cg6;
        this.b = interfaceC10163bB1;
        this.c = interfaceC5766Kt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(ir.nasim.InterfaceC8748Xd6 r11, float r12, ir.nasim.UA2 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof ir.nasim.C24828zG6.a
            if (r0 == 0) goto L13
            r0 = r14
            ir.nasim.zG6$a r0 = (ir.nasim.C24828zG6.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ir.nasim.zG6$a r0 = new ir.nasim.zG6$a
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.a
            r13 = r11
            ir.nasim.UA2 r13 = (ir.nasim.UA2) r13
            ir.nasim.AbstractC10685c16.b(r14)
            goto L51
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.Zj4 r14 = r10.d
            ir.nasim.zG6$b r2 = new ir.nasim.zG6$b
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r12
            r7 = r13
            r8 = r11
            r4.<init>(r6, r7, r8, r9)
            r0.a = r13
            r0.d = r3
            java.lang.Object r14 = ir.nasim.AbstractC9323Zl0.g(r14, r2, r0)
            if (r14 != r1) goto L51
            return r1
        L51:
            ir.nasim.Ft r14 = (ir.nasim.C4581Ft) r14
            r11 = 0
            java.lang.Float r11 = ir.nasim.AbstractC6392Nk0.c(r11)
            r13.invoke(r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24828zG6.i(ir.nasim.Xd6, float, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    private final boolean j(float f, float f2) {
        return Math.abs(AbstractC11543dB1.a(this.b, 0.0f, f2)) >= Math.abs(f);
    }

    private final Object k(InterfaceC8748Xd6 interfaceC8748Xd6, float f, float f2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AG6.i(interfaceC8748Xd6, f, f2, j(f, f2) ? new C12186eB1(this.b) : new C22729vj7(this.c), ua2, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(ir.nasim.InterfaceC8748Xd6 r19, float r20, float r21, ir.nasim.UA2 r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            r18 = this;
            r0 = r23
            boolean r1 = r0 instanceof ir.nasim.C24828zG6.d
            if (r1 == 0) goto L18
            r1 = r0
            ir.nasim.zG6$d r1 = (ir.nasim.C24828zG6.d) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.c = r2
            r8 = r18
        L16:
            r7 = r1
            goto L20
        L18:
            ir.nasim.zG6$d r1 = new ir.nasim.zG6$d
            r8 = r18
            r1.<init>(r0)
            goto L16
        L20:
            java.lang.Object r0 = r7.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r7.c
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            ir.nasim.AbstractC10685c16.b(r0)
            goto L73
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            ir.nasim.AbstractC10685c16.b(r0)
            float r0 = java.lang.Math.abs(r20)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L46
            goto L4e
        L46:
            float r0 = java.lang.Math.abs(r21)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L60
        L4e:
            r16 = 28
            r17 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r9 = r20
            r10 = r21
            ir.nasim.Mt r0 = ir.nasim.AbstractC6483Nt.c(r9, r10, r11, r13, r15, r16, r17)
            goto L79
        L60:
            r7.c = r3
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            java.lang.Object r0 = r2.k(r3, r4, r5, r6, r7)
            if (r0 != r1) goto L73
            return r1
        L73:
            ir.nasim.Ft r0 = (ir.nasim.C4581Ft) r0
            ir.nasim.Mt r0 = r0.c()
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24828zG6.l(ir.nasim.Xd6, float, float, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ir.nasim.InterfaceC4031Dj7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(ir.nasim.InterfaceC8748Xd6 r5, float r6, ir.nasim.UA2 r7, ir.nasim.InterfaceC20295rm1 r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof ir.nasim.C24828zG6.c
            if (r0 == 0) goto L13
            r0 = r8
            ir.nasim.zG6$c r0 = (ir.nasim.C24828zG6.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.zG6$c r0 = new ir.nasim.zG6$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            ir.nasim.AbstractC10685c16.b(r8)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            ir.nasim.AbstractC10685c16.b(r8)
            r0.c = r3
            java.lang.Object r8 = r4.i(r5, r6, r7, r0)
            if (r8 != r1) goto L3d
            return r1
        L3d:
            ir.nasim.Ft r8 = (ir.nasim.C4581Ft) r8
            java.lang.Object r5 = r8.a()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            ir.nasim.Mt r6 = r8.b()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L53
            goto L5d
        L53:
            java.lang.Object r5 = r6.z()
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = r5.floatValue()
        L5d:
            java.lang.Float r5 = ir.nasim.AbstractC6392Nk0.c(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24828zG6.b(ir.nasim.Xd6, float, ir.nasim.UA2, ir.nasim.rm1):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C24828zG6)) {
            return false;
        }
        C24828zG6 c24828zG6 = (C24828zG6) obj;
        return AbstractC13042fc3.d(c24828zG6.c, this.c) && AbstractC13042fc3.d(c24828zG6.b, this.b) && AbstractC13042fc3.d(c24828zG6.a, this.a);
    }

    public int hashCode() {
        return (((this.c.hashCode() * 31) + this.b.hashCode()) * 31) + this.a.hashCode();
    }
}
