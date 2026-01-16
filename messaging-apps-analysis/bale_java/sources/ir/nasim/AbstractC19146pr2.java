package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC19146pr2;
import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.pr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC19146pr2 {

    /* renamed from: ir.nasim.pr2$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        private /* synthetic */ Object d;
        final /* synthetic */ InterfaceC4557Fq2 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.pr2$a$a, reason: collision with other inner class name */
        static final class C1456a implements InterfaceC4806Gq2 {
            final /* synthetic */ C12280eL5 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ InterfaceC16204ks5 c;
            final /* synthetic */ C12889fL5 d;
            final /* synthetic */ C12889fL5 e;

            /* renamed from: ir.nasim.pr2$a$a$a, reason: collision with other inner class name */
            static final class C1457a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                private /* synthetic */ Object c;
                final /* synthetic */ SA2 d;
                final /* synthetic */ long e;
                final /* synthetic */ C12280eL5 f;
                final /* synthetic */ C12889fL5 g;
                final /* synthetic */ C12889fL5 h;
                final /* synthetic */ InterfaceC16204ks5 i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1457a(SA2 sa2, long j, C12280eL5 c12280eL5, C12889fL5 c12889fL5, C12889fL5 c12889fL52, InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.d = sa2;
                    this.e = j;
                    this.f = c12280eL5;
                    this.g = c12889fL5;
                    this.h = c12889fL52;
                    this.i = interfaceC16204ks5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    C1457a c1457a = new C1457a(this.d, this.e, this.f, this.g, this.h, this.i, interfaceC20295rm1);
                    c1457a.c = obj;
                    return c1457a;
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    InterfaceC20315ro1 interfaceC20315ro1;
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                        long jLongValue = ((Number) this.d.invoke()).longValue() - (this.e - this.f.a);
                        this.c = interfaceC20315ro1;
                        this.b = 1;
                        if (HG1.b(jLongValue, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            AbstractC10685c16.b(obj);
                            this.f.a = System.currentTimeMillis();
                            this.h.a = null;
                            return C19938rB7.a;
                        }
                        interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                        AbstractC10685c16.b(obj);
                    }
                    AbstractC20906so1.f(interfaceC20315ro1);
                    Object obj2 = this.g.a;
                    if (obj2 != null) {
                        InterfaceC16204ks5 interfaceC16204ks5 = this.i;
                        this.c = null;
                        this.b = 2;
                        if (interfaceC16204ks5.o(obj2, this) == objE) {
                            return objE;
                        }
                    }
                    this.f.a = System.currentTimeMillis();
                    this.h.a = null;
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1457a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.pr2$a$a$b */
            static final class b extends AbstractC22163um1 {
                Object a;
                long b;
                /* synthetic */ Object c;
                int e;

                b(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= RecyclerView.UNDEFINED_DURATION;
                    return C1456a.this.a(null, this);
                }
            }

            C1456a(C12280eL5 c12280eL5, SA2 sa2, InterfaceC16204ks5 interfaceC16204ks5, C12889fL5 c12889fL5, C12889fL5 c12889fL52) {
                this.a = c12280eL5;
                this.b = sa2;
                this.c = interfaceC16204ks5;
                this.d = c12889fL5;
                this.e = c12889fL52;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r13, ir.nasim.InterfaceC20295rm1 r14) {
                /*
                    r12 = this;
                    boolean r0 = r14 instanceof ir.nasim.AbstractC19146pr2.a.C1456a.b
                    if (r0 == 0) goto L13
                    r0 = r14
                    ir.nasim.pr2$a$a$b r0 = (ir.nasim.AbstractC19146pr2.a.C1456a.b) r0
                    int r1 = r0.e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.e = r1
                    goto L18
                L13:
                    ir.nasim.pr2$a$a$b r0 = new ir.nasim.pr2$a$a$b
                    r0.<init>(r14)
                L18:
                    java.lang.Object r14 = r0.c
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.e
                    r3 = 1
                    if (r2 == 0) goto L37
                    if (r2 != r3) goto L2f
                    long r1 = r0.b
                    java.lang.Object r13 = r0.a
                    ir.nasim.pr2$a$a r13 = (ir.nasim.AbstractC19146pr2.a.C1456a) r13
                    ir.nasim.AbstractC10685c16.b(r14)
                    goto L65
                L2f:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L37:
                    ir.nasim.AbstractC10685c16.b(r14)
                    long r4 = java.lang.System.currentTimeMillis()
                    ir.nasim.eL5 r14 = r12.a
                    long r6 = r14.a
                    long r6 = r4 - r6
                    ir.nasim.SA2 r14 = r12.b
                    java.lang.Object r14 = r14.invoke()
                    java.lang.Number r14 = (java.lang.Number) r14
                    long r8 = r14.longValue()
                    int r14 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    if (r14 < 0) goto L6a
                    ir.nasim.ks5 r14 = r12.c
                    r0.a = r12
                    r0.b = r4
                    r0.e = r3
                    java.lang.Object r13 = r14.o(r13, r0)
                    if (r13 != r1) goto L63
                    return r1
                L63:
                    r13 = r12
                    r1 = r4
                L65:
                    ir.nasim.eL5 r13 = r13.a
                    r13.a = r1
                    goto L92
                L6a:
                    ir.nasim.fL5 r14 = r12.d
                    r14.a = r13
                    ir.nasim.fL5 r13 = r12.e
                    java.lang.Object r0 = r13.a
                    if (r0 != 0) goto L92
                    ir.nasim.ks5 r9 = r12.c
                    ir.nasim.pr2$a$a$a r10 = new ir.nasim.pr2$a$a$a
                    ir.nasim.SA2 r1 = r12.b
                    ir.nasim.eL5 r6 = r12.a
                    r8 = 0
                    r0 = r10
                    r2 = r4
                    r4 = r6
                    r5 = r14
                    r6 = r13
                    r7 = r9
                    r0.<init>(r1, r2, r4, r5, r6, r7, r8)
                    r14 = 3
                    r11 = 0
                    r7 = 0
                    r6 = r9
                    r9 = r10
                    r10 = r14
                    ir.nasim.gj3 r14 = ir.nasim.AbstractC9323Zl0.d(r6, r7, r8, r9, r10, r11)
                    r13.a = r14
                L92:
                    ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19146pr2.a.C1456a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC4557Fq2 interfaceC4557Fq2, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = interfaceC4557Fq2;
            this.f = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 y(C12889fL5 c12889fL5) {
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) c12889fL5.a;
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.e, this.f, interfaceC20295rm1);
            aVar.d = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            final C12889fL5 c12889fL5;
            InterfaceC16204ks5 interfaceC16204ks5;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC16204ks5 interfaceC16204ks52 = (InterfaceC16204ks5) this.d;
                C12280eL5 c12280eL5 = new C12280eL5();
                C12889fL5 c12889fL52 = new C12889fL5();
                c12889fL5 = new C12889fL5();
                InterfaceC4557Fq2 interfaceC4557Fq2 = this.e;
                C1456a c1456a = new C1456a(c12280eL5, this.f, interfaceC16204ks52, c12889fL52, c12889fL5);
                this.d = interfaceC16204ks52;
                this.b = c12889fL5;
                this.c = 1;
                if (interfaceC4557Fq2.b(c1456a, this) == objE) {
                    return objE;
                }
                interfaceC16204ks5 = interfaceC16204ks52;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                c12889fL5 = (C12889fL5) this.b;
                interfaceC16204ks5 = (InterfaceC16204ks5) this.d;
                AbstractC10685c16.b(obj);
            }
            SA2 sa2 = new SA2() { // from class: ir.nasim.or2
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC19146pr2.a.y(c12889fL5);
                }
            };
            this.d = null;
            this.b = null;
            this.c = 2;
            if (AbstractC13822gs5.a(interfaceC16204ks5, sa2, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC16204ks5 interfaceC16204ks5, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC16204ks5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2, SA2 sa2) {
        AbstractC13042fc3.i(interfaceC4557Fq2, "<this>");
        AbstractC13042fc3.i(sa2, "timeWindow");
        return AbstractC6459Nq2.j(new a(interfaceC4557Fq2, sa2, null));
    }
}
