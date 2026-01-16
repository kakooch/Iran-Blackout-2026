package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Mq2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6209Mq2 {
    private static final Object a = new Object();

    /* renamed from: ir.nasim.Mq2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4557Fq2 d;
        final /* synthetic */ InterfaceC15796kB2 e;

        /* renamed from: ir.nasim.Mq2$a$a, reason: collision with other inner class name */
        static final class C0509a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC15796kB2 b;
            final /* synthetic */ InterfaceC4806Gq2 c;

            /* renamed from: ir.nasim.Mq2$a$a$a, reason: collision with other inner class name */
            static final class C0510a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C0510a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return C0509a.this.a(null, this);
                }
            }

            C0509a(C12889fL5 c12889fL5, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c12889fL5;
                this.b = interfaceC15796kB2;
                this.c = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x007e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r8, ir.nasim.InterfaceC20295rm1 r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof ir.nasim.AbstractC6209Mq2.a.C0509a.C0510a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Mq2$a$a$a r0 = (ir.nasim.AbstractC6209Mq2.a.C0509a.C0510a) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.Mq2$a$a$a r0 = new ir.nasim.Mq2$a$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L7f
                L2c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L34:
                    java.lang.Object r8 = r0.b
                    ir.nasim.fL5 r8 = (ir.nasim.C12889fL5) r8
                    java.lang.Object r2 = r0.a
                    ir.nasim.Mq2$a$a r2 = (ir.nasim.AbstractC6209Mq2.a.C0509a) r2
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L66
                L40:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.fL5 r9 = r7.a
                    java.lang.Object r2 = r9.a
                    java.lang.Object r5 = ir.nasim.AbstractC6209Mq2.a()
                    if (r2 != r5) goto L4f
                    r2 = r7
                    goto L69
                L4f:
                    ir.nasim.kB2 r2 = r7.b
                    ir.nasim.fL5 r5 = r7.a
                    java.lang.Object r5 = r5.a
                    r0.a = r7
                    r0.b = r9
                    r0.e = r4
                    java.lang.Object r8 = r2.q(r5, r8, r0)
                    if (r8 != r1) goto L62
                    return r1
                L62:
                    r2 = r7
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L66:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L69:
                    r9.a = r8
                    ir.nasim.Gq2 r8 = r2.c
                    ir.nasim.fL5 r9 = r2.a
                    java.lang.Object r9 = r9.a
                    r2 = 0
                    r0.a = r2
                    r0.b = r2
                    r0.e = r3
                    java.lang.Object r8 = r8.a(r9, r0)
                    if (r8 != r1) goto L7f
                    return r1
                L7f:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6209Mq2.a.C0509a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
            this.e = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C12889fL5 c12889fL5 = new C12889fL5();
                c12889fL5.a = AbstractC6209Mq2.a;
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                C0509a c0509a = new C0509a(c12889fL5, this.e, interfaceC4806Gq2);
                this.b = 1;
                if (interfaceC4557Fq2.b(c0509a, this) == objE) {
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
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mq2$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ Object e;
        final /* synthetic */ InterfaceC4557Fq2 f;
        final /* synthetic */ InterfaceC15796kB2 g;

        /* renamed from: ir.nasim.Mq2$b$a */
        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12889fL5 a;
            final /* synthetic */ InterfaceC15796kB2 b;
            final /* synthetic */ InterfaceC4806Gq2 c;

            /* renamed from: ir.nasim.Mq2$b$a$a, reason: collision with other inner class name */
            static final class C0511a extends AbstractC22163um1 {
                Object a;
                Object b;
                /* synthetic */ Object c;
                int e;

                C0511a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            a(C12889fL5 c12889fL5, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = c12889fL5;
                this.b = interfaceC15796kB2;
                this.c = interfaceC4806Gq2;
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
                    boolean r0 = r9 instanceof ir.nasim.AbstractC6209Mq2.b.a.C0511a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Mq2$b$a$a r0 = (ir.nasim.AbstractC6209Mq2.b.a.C0511a) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.Mq2$b$a$a r0 = new ir.nasim.Mq2$b$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L40
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L70
                L2c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L34:
                    java.lang.Object r8 = r0.b
                    ir.nasim.fL5 r8 = (ir.nasim.C12889fL5) r8
                    java.lang.Object r2 = r0.a
                    ir.nasim.Mq2$b$a r2 = (ir.nasim.AbstractC6209Mq2.b.a) r2
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L5a
                L40:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.fL5 r9 = r7.a
                    ir.nasim.kB2 r2 = r7.b
                    java.lang.Object r5 = r9.a
                    r0.a = r7
                    r0.b = r9
                    r0.e = r4
                    java.lang.Object r8 = r2.q(r5, r8, r0)
                    if (r8 != r1) goto L56
                    return r1
                L56:
                    r2 = r7
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L5a:
                    r8.a = r9
                    ir.nasim.Gq2 r8 = r2.c
                    ir.nasim.fL5 r9 = r2.a
                    java.lang.Object r9 = r9.a
                    r2 = 0
                    r0.a = r2
                    r0.b = r2
                    r0.e = r3
                    java.lang.Object r8 = r8.a(r9, r0)
                    if (r8 != r1) goto L70
                    return r1
                L70:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC6209Mq2.b.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = obj;
            this.f = interfaceC4557Fq2;
            this.g = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.e, this.f, this.g, interfaceC20295rm1);
            bVar.d = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C12889fL5 c12889fL5;
            InterfaceC4806Gq2 interfaceC4806Gq2;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq22 = (InterfaceC4806Gq2) this.d;
                c12889fL5 = new C12889fL5();
                Object obj2 = this.e;
                c12889fL5.a = obj2;
                this.d = interfaceC4806Gq22;
                this.b = c12889fL5;
                this.c = 1;
                if (interfaceC4806Gq22.a(obj2, this) == objE) {
                    return objE;
                }
                interfaceC4806Gq2 = interfaceC4806Gq22;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                c12889fL5 = (C12889fL5) this.b;
                interfaceC4806Gq2 = (InterfaceC4806Gq2) this.d;
                AbstractC10685c16.b(obj);
            }
            InterfaceC4557Fq2 interfaceC4557Fq2 = this.f;
            a aVar = new a(c12889fL5, this.g, interfaceC4806Gq2);
            this.d = null;
            this.b = null;
            this.c = 2;
            if (interfaceC4557Fq2.b(aVar, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Mq2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC4557Fq2 d;
        final /* synthetic */ InterfaceC15796kB2 e;

        /* renamed from: ir.nasim.Mq2$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ InterfaceC15796kB2 d;
            final /* synthetic */ C21215tJ0 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC15796kB2 interfaceC15796kB2, C21215tJ0 c21215tJ0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC15796kB2;
                this.e = c21215tJ0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    Object obj2 = this.c;
                    InterfaceC15796kB2 interfaceC15796kB2 = this.d;
                    C21215tJ0 c21215tJ0 = this.e;
                    this.b = 1;
                    if (interfaceC15796kB2.q(c21215tJ0, obj2, this) == objE) {
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
            public final Object invoke(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(obj, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC4557Fq2;
            this.e = interfaceC15796kB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, this.e, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                OC6 oc6 = (OC6) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.d;
                a aVar = new a(this.e, new C21215tJ0(oc6), null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2, aVar, this) == objE) {
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
        public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC15796kB2, "operation");
        return AbstractC6459Nq2.R(new a(interfaceC4557Fq2, interfaceC15796kB2, null));
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, Object obj, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC15796kB2, "operation");
        return AbstractC6459Nq2.R(new b(obj, interfaceC4557Fq2, interfaceC15796kB2, null));
    }

    public static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC15796kB2, "transform");
        return BC6.a(new c(interfaceC4557Fq2, interfaceC15796kB2, null));
    }
}
