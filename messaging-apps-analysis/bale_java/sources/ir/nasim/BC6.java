package ir.nasim;

import ir.nasim.InterfaceC16756lo6;

/* loaded from: classes2.dex */
public abstract class BC6 {

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 d;

        /* renamed from: ir.nasim.BC6$a$a, reason: collision with other inner class name */
        static final class C0286a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            Object b;
            int c;
            private /* synthetic */ Object d;
            final /* synthetic */ InterfaceC4806Gq2 e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* renamed from: ir.nasim.BC6$a$a$a, reason: collision with other inner class name */
            static final class C0287a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC17639nJ0 c;
                final /* synthetic */ InterfaceC14603iB2 d;

                /* renamed from: ir.nasim.BC6$a$a$a$a, reason: collision with other inner class name */
                static final class C0288a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                    int b;
                    private /* synthetic */ Object c;
                    final /* synthetic */ InterfaceC17639nJ0 d;
                    final /* synthetic */ InterfaceC14603iB2 e;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0288a(InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                        super(2, interfaceC20295rm1);
                        this.d = interfaceC17639nJ0;
                        this.e = interfaceC14603iB2;
                    }

                    @Override // ir.nasim.E90
                    public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                        C0288a c0288a = new C0288a(this.d, this.e, interfaceC20295rm1);
                        c0288a.c = obj;
                        return c0288a;
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        Object objE = AbstractC14862ic3.e();
                        int i = this.b;
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            PC6 pc6 = new PC6((InterfaceC20315ro1) this.c, this.d);
                            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
                            this.b = 1;
                            if (interfaceC14603iB2.invoke(pc6, this) == objE) {
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
                        return ((C0288a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0287a(InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC17639nJ0;
                    this.d = interfaceC14603iB2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0287a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    try {
                        if (i == 0) {
                            AbstractC10685c16.b(obj);
                            C0288a c0288a = new C0288a(this.c, this.d, null);
                            this.b = 1;
                            if (AbstractC20906so1.e(c0288a, this) == objE) {
                                return objE;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                        }
                        InterfaceC16756lo6.a.a(this.c, null, 1, null);
                    } catch (Throwable th) {
                        this.c.w(th);
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0287a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0286a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.e = interfaceC4806Gq2;
                this.f = interfaceC14603iB2;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C0286a c0286a = new C0286a(this.e, this.f, interfaceC20295rm1);
                c0286a.d = obj;
                return c0286a;
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x007e  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007b -> B:7:0x001a). Please report as a decompilation issue!!! */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r12.c
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L31
                    if (r1 == r3) goto L25
                    if (r1 != r2) goto L1d
                    java.lang.Object r1 = r12.b
                    ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                    java.lang.Object r5 = r12.d
                    ir.nasim.gj3 r5 = (ir.nasim.InterfaceC13730gj3) r5
                    ir.nasim.AbstractC10685c16.b(r13)
                L1a:
                    r13 = r1
                    r1 = r5
                    goto L52
                L1d:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L25:
                    java.lang.Object r1 = r12.b
                    ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                    java.lang.Object r5 = r12.d
                    ir.nasim.gj3 r5 = (ir.nasim.InterfaceC13730gj3) r5
                    ir.nasim.AbstractC10685c16.b(r13)
                    goto L63
                L31:
                    ir.nasim.AbstractC10685c16.b(r13)
                    java.lang.Object r13 = r12.d
                    r5 = r13
                    ir.nasim.ro1 r5 = (ir.nasim.InterfaceC20315ro1) r5
                    r13 = 0
                    r1 = 6
                    ir.nasim.nJ0 r13 = ir.nasim.DJ0.b(r13, r4, r4, r1, r4)
                    ir.nasim.BC6$a$a$a r8 = new ir.nasim.BC6$a$a$a
                    ir.nasim.iB2 r1 = r12.f
                    r8.<init>(r13, r1, r4)
                    r9 = 3
                    r10 = 0
                    r6 = 0
                    r7 = 0
                    ir.nasim.gj3 r1 = ir.nasim.AbstractC9323Zl0.d(r5, r6, r7, r8, r9, r10)
                    ir.nasim.CJ0 r13 = r13.iterator()
                L52:
                    r12.d = r1
                    r12.b = r13
                    r12.c = r3
                    java.lang.Object r5 = r13.a(r12)
                    if (r5 != r0) goto L5f
                    return r0
                L5f:
                    r11 = r1
                    r1 = r13
                    r13 = r5
                    r5 = r11
                L63:
                    java.lang.Boolean r13 = (java.lang.Boolean) r13
                    boolean r13 = r13.booleanValue()
                    if (r13 == 0) goto L7e
                    java.lang.Object r13 = r1.next()
                    ir.nasim.Gq2 r6 = r12.e
                    r12.d = r5
                    r12.b = r1
                    r12.c = r2
                    java.lang.Object r13 = r6.a(r13, r12)
                    if (r13 != r0) goto L1a
                    return r0
                L7e:
                    ir.nasim.InterfaceC13730gj3.a.a(r5, r4, r3, r4)
                    ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.BC6.a.C0286a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0286a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C0286a c0286a = new C0286a((InterfaceC4806Gq2) this.c, this.d, null);
                this.b = 1;
                if (AbstractC20906so1.e(c0286a, this) == objE) {
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

    public static final InterfaceC4557Fq2 a(InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "block");
        return AbstractC7420Rq2.b(AbstractC6459Nq2.R(new a(interfaceC14603iB2, null)), -2, null, 2, null);
    }
}
