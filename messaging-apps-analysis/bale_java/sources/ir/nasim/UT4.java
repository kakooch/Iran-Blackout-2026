package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
abstract /* synthetic */ class UT4 {

    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        /* renamed from: ir.nasim.UT4$a$a, reason: collision with other inner class name */
        public static final class C0689a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC14603iB2 b;

            /* renamed from: ir.nasim.UT4$a$a$a, reason: collision with other inner class name */
            public static final class C0690a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0690a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0689a.this.a(null, this);
                }
            }

            public C0689a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC14603iB2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.UT4.a.C0689a.C0690a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.UT4$a$a$a r0 = (ir.nasim.UT4.a.C0689a.C0690a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.UT4$a$a$a r0 = new ir.nasim.UT4$a$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.VS4 r7 = (ir.nasim.VS4) r7
                    ir.nasim.iB2 r2 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.a(r2, r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UT4.a.C0689a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0689a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c == null) {
                return this.d;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(Object obj, Object obj2, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, interfaceC20295rm1);
            bVar.c = obj2;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (this.c == null) {
                return this.d;
            }
            return null;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(Object obj, Object obj2, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, interfaceC20295rm1);
            cVar.c = obj;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ InterfaceC14603iB2 b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ InterfaceC14603iB2 b;

            /* renamed from: ir.nasim.UT4$d$a$a, reason: collision with other inner class name */
            public static final class C0691a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;
                Object c;

                public C0691a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC14603iB2 interfaceC14603iB2) {
                this.a = interfaceC4806Gq2;
                this.b = interfaceC14603iB2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r7, ir.nasim.InterfaceC20295rm1 r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof ir.nasim.UT4.d.a.C0691a
                    if (r0 == 0) goto L13
                    r0 = r8
                    ir.nasim.UT4$d$a$a r0 = (ir.nasim.UT4.d.a.C0691a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.UT4$d$a$a r0 = new ir.nasim.UT4$d$a$a
                    r0.<init>(r8)
                L18:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L3c
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L5f
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L34:
                    java.lang.Object r7 = r0.c
                    ir.nasim.Gq2 r7 = (ir.nasim.InterfaceC4806Gq2) r7
                    ir.nasim.AbstractC10685c16.b(r8)
                    goto L53
                L3c:
                    ir.nasim.AbstractC10685c16.b(r8)
                    ir.nasim.Gq2 r8 = r6.a
                    ir.nasim.VS4 r7 = (ir.nasim.VS4) r7
                    ir.nasim.iB2 r2 = r6.b
                    r0.c = r8
                    r0.b = r4
                    java.lang.Object r7 = r7.c(r2, r0)
                    if (r7 != r1) goto L50
                    return r1
                L50:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L53:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r7 = r7.a(r8, r0)
                    if (r7 != r1) goto L5f
                    return r1
                L5f:
                    ir.nasim.rB7 r7 = ir.nasim.C19938rB7.a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.UT4.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
            this.a = interfaceC4557Fq2;
            this.b = interfaceC14603iB2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    public static final /* synthetic */ NT4 a(NT4 nt4, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(nt4, "<this>");
        AbstractC13042fc3.i(interfaceC14603iB2, "predicate");
        return new NT4(new a(nt4.d(), interfaceC14603iB2), nt4.f(), nt4.e(), null, 8, null);
    }

    public static final NT4 b(NT4 nt4, EnumC5225Ik7 enumC5225Ik7, Object obj) {
        AbstractC13042fc3.i(nt4, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        AbstractC13042fc3.i(obj, "item");
        return e(nt4, enumC5225Ik7, new b(obj, null));
    }

    public static /* synthetic */ NT4 c(NT4 nt4, EnumC5225Ik7 enumC5225Ik7, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            enumC5225Ik7 = EnumC5225Ik7.FULLY_COMPLETE;
        }
        return TT4.b(nt4, enumC5225Ik7, obj);
    }

    public static final NT4 d(NT4 nt4, EnumC5225Ik7 enumC5225Ik7, Object obj) {
        AbstractC13042fc3.i(nt4, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        AbstractC13042fc3.i(obj, "item");
        return e(nt4, enumC5225Ik7, new c(obj, null));
    }

    public static final /* synthetic */ NT4 e(NT4 nt4, EnumC5225Ik7 enumC5225Ik7, InterfaceC15796kB2 interfaceC15796kB2) {
        AbstractC13042fc3.i(nt4, "<this>");
        AbstractC13042fc3.i(enumC5225Ik7, "terminalSeparatorType");
        AbstractC13042fc3.i(interfaceC15796kB2, "generator");
        return new NT4(AbstractC14386hp6.c(nt4.d(), enumC5225Ik7, interfaceC15796kB2), nt4.f(), nt4.e(), null, 8, null);
    }

    public static /* synthetic */ NT4 f(NT4 nt4, EnumC5225Ik7 enumC5225Ik7, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC5225Ik7 = EnumC5225Ik7.FULLY_COMPLETE;
        }
        return e(nt4, enumC5225Ik7, interfaceC15796kB2);
    }

    public static final /* synthetic */ NT4 g(NT4 nt4, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(nt4, "<this>");
        AbstractC13042fc3.i(interfaceC14603iB2, "transform");
        return new NT4(new d(nt4.d(), interfaceC14603iB2), nt4.f(), nt4.e(), null, 8, null);
    }
}
