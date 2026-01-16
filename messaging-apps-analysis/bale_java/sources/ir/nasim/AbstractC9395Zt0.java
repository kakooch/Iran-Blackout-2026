package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Zt0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9395Zt0 {

    /* renamed from: ir.nasim.Zt0$a */
    public static final class a implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Zt0$a$a, reason: collision with other inner class name */
        public static final class C0818a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Zt0$a$a$a, reason: collision with other inner class name */
            public static final class C0819a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0819a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return C0818a.this.a(null, this);
                }
            }

            public C0818a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r5, ir.nasim.InterfaceC20295rm1 r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof ir.nasim.AbstractC9395Zt0.a.C0818a.C0819a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Zt0$a$a$a r0 = (ir.nasim.AbstractC9395Zt0.a.C0818a.C0819a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Zt0$a$a$a r0 = new ir.nasim.Zt0$a$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L45
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.Pl4 r5 = (ir.nasim.C6899Pl4) r5
                    ir.nasim.NT4 r5 = r5.b()
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC9395Zt0.a.C0818a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public a(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new C0818a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Zt0$b */
    public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ InterfaceC20315ro1 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC20315ro1 interfaceC20315ro1, N5 n5) {
            super(3, interfaceC20295rm1);
            this.e = interfaceC20315ro1;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4806Gq2 interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                C6899Pl4 c6899Pl4 = new C6899Pl4(this.e, (NT4) this.d, null);
                this.b = 1;
                if (interfaceC4806Gq2.a(c6899Pl4, this) == objE) {
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

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1, this.e, null);
            bVar.c = interfaceC4806Gq2;
            bVar.d = obj;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zt0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C6899Pl4 c6899Pl4 = (C6899Pl4) this.c;
                AbstractC10685c16.b(obj);
                return c6899Pl4;
            }
            AbstractC10685c16.b(obj);
            C6899Pl4 c6899Pl42 = (C6899Pl4) this.c;
            C6899Pl4 c6899Pl43 = (C6899Pl4) this.d;
            this.c = c6899Pl43;
            this.b = 1;
            return c6899Pl42.c(this) == objE ? objE : c6899Pl43;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(C6899Pl4 c6899Pl4, C6899Pl4 c6899Pl42, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(interfaceC20295rm1);
            cVar.c = c6899Pl4;
            cVar.d = c6899Pl42;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zt0$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(N5 n5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(null, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Zt0$e */
    static final class e extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        e(N5 n5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Throwable th, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(null, interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        return b(interfaceC4557Fq2, interfaceC20315ro1, null);
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC20315ro1 interfaceC20315ro1, N5 n5) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(interfaceC20315ro1, "scope");
        return AbstractC6459Nq2.m0(AbstractC6459Nq2.a0(AbstractC6459Nq2.c0(new a(AbstractC6209Mq2.b(AbstractC6209Mq2.d(interfaceC4557Fq2, new b(null, interfaceC20315ro1, n5)), new c(null))), new d(n5, null)), new e(n5, null)), interfaceC20315ro1, InterfaceC16863lz6.a.d(), 1);
    }
}
