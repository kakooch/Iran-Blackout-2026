package ir.nasim;

import ir.nasim.AbstractC5389Jd0;
import ir.nasim.InterfaceC10676c07;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Jd0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5389Jd0 {

    /* renamed from: ir.nasim.Jd0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ C8271Vg2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ InterfaceC9664aL6 d;

        /* renamed from: ir.nasim.Jd0$a$a, reason: collision with other inner class name */
        static final class C0448a implements InterfaceC15796kB2 {
            final /* synthetic */ C8271Vg2 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* renamed from: ir.nasim.Jd0$a$a$a, reason: collision with other inner class name */
            static final class C0449a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ SA2 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0449a(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = sa2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0449a(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.invoke();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C0449a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.Jd0$a$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ SA2 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = sa2;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new b(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.invoke();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            C0448a(C8271Vg2 c8271Vg2, SA2 sa2, SA2 sa22, InterfaceC9664aL6 interfaceC9664aL6) {
                this.a = c8271Vg2;
                this.b = sa2;
                this.c = sa22;
                this.d = interfaceC9664aL6;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C8271Vg2 c8271Vg2, EnumC7123Qj2 enumC7123Qj2, String str) {
                AbstractC13042fc3.i(enumC7123Qj2, "rate");
                AbstractC13042fc3.i(str, "opinion");
                c8271Vg2.S0(enumC7123Qj2, str);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 k(SA2 sa2) {
                AbstractC13042fc3.i(sa2, "$onClosePressed");
                sa2.invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 n(C8271Vg2 c8271Vg2) {
                c8271Vg2.T0();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 o(SA2 sa2) {
                AbstractC13042fc3.i(sa2, "$onClosePressed");
                sa2.invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 p(C8271Vg2 c8271Vg2, boolean z) {
                c8271Vg2.P0(z);
                return C19938rB7.a;
            }

            public final void h(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(zy0, "$this$Card");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC10676c07 interfaceC10676c07E = AbstractC5389Jd0.e(this.d);
                if (AbstractC13042fc3.d(interfaceC10676c07E, InterfaceC10676c07.c.a)) {
                    interfaceC22053ub1.W(1262530421);
                    interfaceC22053ub1.W(1426203051);
                    boolean zD = interfaceC22053ub1.D(this.a);
                    final C8271Vg2 c8271Vg2 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zD || objB == InterfaceC22053ub1.a.a()) {
                        objB = new InterfaceC14603iB2() { // from class: ir.nasim.Ed0
                            @Override // ir.nasim.InterfaceC14603iB2
                            public final Object invoke(Object obj, Object obj2) {
                                return AbstractC5389Jd0.a.C0448a.i(c8271Vg2, (EnumC7123Qj2) obj, (String) obj2);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) objB;
                    interfaceC22053ub1.Q();
                    interfaceC22053ub1.W(1426206469);
                    boolean zV = interfaceC22053ub1.V(this.b);
                    final SA2 sa2 = this.b;
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new SA2() { // from class: ir.nasim.Fd0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC5389Jd0.a.C0448a.k(sa2);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC23354wm6.e(interfaceC14603iB2, (SA2) objB2, interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!(interfaceC10676c07E instanceof InterfaceC10676c07.d)) {
                    if (AbstractC13042fc3.d(interfaceC10676c07E, InterfaceC10676c07.a.a)) {
                        interfaceC22053ub1.W(1263487949);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                        interfaceC22053ub1.W(1426232769);
                        boolean zV2 = interfaceC22053ub1.V(this.b);
                        SA2 sa22 = this.b;
                        Object objB3 = interfaceC22053ub1.B();
                        if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                            objB3 = new C0449a(sa22, null);
                            interfaceC22053ub1.s(objB3);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 6);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (!AbstractC13042fc3.d(interfaceC10676c07E, InterfaceC10676c07.b.a)) {
                        interfaceC22053ub1.W(1426198451);
                        interfaceC22053ub1.Q();
                        throw new NoWhenBranchMatchedException();
                    }
                    interfaceC22053ub1.W(1263719953);
                    C19938rB7 c19938rB72 = C19938rB7.a;
                    interfaceC22053ub1.W(1426240253);
                    boolean zV3 = interfaceC22053ub1.V(this.c);
                    SA2 sa23 = this.c;
                    Object objB4 = interfaceC22053ub1.B();
                    if (zV3 || objB4 == InterfaceC22053ub1.a.a()) {
                        objB4 = new b(sa23, null);
                        interfaceC22053ub1.s(objB4);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC10721c52.e(c19938rB72, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 6);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(1262895694);
                InterfaceC10676c07 interfaceC10676c07E2 = AbstractC5389Jd0.e(this.d);
                AbstractC13042fc3.g(interfaceC10676c07E2, "null cannot be cast to non-null type ir.nasim.features.call.data.SubmitFeedbackScreenState.SubmitRateOnBazar");
                boolean zA = ((InterfaceC10676c07.d) interfaceC10676c07E2).a();
                interfaceC22053ub1.W(1426220438);
                boolean zD2 = interfaceC22053ub1.D(this.a);
                final C8271Vg2 c8271Vg22 = this.a;
                Object objB5 = interfaceC22053ub1.B();
                if (zD2 || objB5 == InterfaceC22053ub1.a.a()) {
                    objB5 = new SA2() { // from class: ir.nasim.Gd0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5389Jd0.a.C0448a.n(c8271Vg22);
                        }
                    };
                    interfaceC22053ub1.s(objB5);
                }
                SA2 sa24 = (SA2) objB5;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1426223237);
                boolean zV4 = interfaceC22053ub1.V(this.b);
                final SA2 sa25 = this.b;
                Object objB6 = interfaceC22053ub1.B();
                if (zV4 || objB6 == InterfaceC22053ub1.a.a()) {
                    objB6 = new SA2() { // from class: ir.nasim.Hd0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5389Jd0.a.C0448a.o(sa25);
                        }
                    };
                    interfaceC22053ub1.s(objB6);
                }
                SA2 sa26 = (SA2) objB6;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(1426225785);
                boolean zD3 = interfaceC22053ub1.D(this.a);
                final C8271Vg2 c8271Vg23 = this.a;
                Object objB7 = interfaceC22053ub1.B();
                if (zD3 || objB7 == InterfaceC22053ub1.a.a()) {
                    objB7 = new UA2() { // from class: ir.nasim.Id0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC5389Jd0.a.C0448a.p(c8271Vg23, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB7);
                }
                interfaceC22053ub1.Q();
                AbstractC7535Sd0.i(zA, sa24, sa26, (UA2) objB7, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                h((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(C8271Vg2 c8271Vg2, SA2 sa2, SA2 sa22, InterfaceC9664aL6 interfaceC9664aL6) {
            this.a = c8271Vg2;
            this.b = sa2;
            this.c = sa22;
            this.d = interfaceC9664aL6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                PG0.a(null, N46.d(C17784nZ1.q(20)), null, null, null, AbstractC19242q11.e(-2059588760, true, new C0448a(this.a, this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, 196608, 29);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0229  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final ir.nasim.SA2 r30, final ir.nasim.SA2 r31, ir.nasim.C8271Vg2 r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5389Jd0.d(ir.nasim.SA2, ir.nasim.SA2, ir.nasim.Vg2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC10676c07 e(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC10676c07) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClosePressed");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(SA2 sa2, SA2 sa22, C8271Vg2 c8271Vg2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onClosePressed");
        AbstractC13042fc3.i(sa22, "$openBazzar");
        d(sa2, sa22, c8271Vg2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
