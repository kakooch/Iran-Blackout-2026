package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.VS4;
import ir.nasim.YT4;
import ir.nasim.ZS4;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class XS4 {
    private final Object a;
    private final YT4 b;
    private final MT4 c;
    private final InterfaceC4557Fq2 d;
    private final InterfaceC22520vN5 e;
    private final ZT4 f;
    private final SA2 g;
    private final C13621gY2 h;
    private final AtomicBoolean i;
    private final InterfaceC17639nJ0 j;
    private final ZS4.a k;
    private final InterfaceC24075y01 l;
    private final InterfaceC4557Fq2 m;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC16433lG3.values().length];
            try {
                iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC16433lG3.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC16433lG3.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class b extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        private /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ XS4 e;
        final /* synthetic */ EnumC16433lG3 f;
        Object g;
        int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC20295rm1 interfaceC20295rm1, XS4 xs4, EnumC16433lG3 enumC16433lG3) {
            super(3, interfaceC20295rm1);
            this.e = xs4;
            this.f = enumC16433lG3;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            int iIntValue;
            ZS4.a aVar;
            InterfaceC19699qn4 interfaceC19699qn4;
            InterfaceC4557Fq2 eVar;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    iIntValue = ((Number) this.d).intValue();
                    aVar = this.e.k;
                    interfaceC19699qn4 = aVar.b;
                    this.c = interfaceC4806Gq2;
                    this.d = aVar;
                    this.g = interfaceC19699qn4;
                    this.h = iIntValue;
                    this.b = 1;
                    if (interfaceC19699qn4.a(null, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    iIntValue = this.h;
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.g;
                    aVar = (ZS4.a) this.d;
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    AbstractC10685c16.b(obj);
                }
                ZS4 zs4 = aVar.c;
                AbstractC13460gG3 abstractC13460gG3A = zs4.p().a(this.f);
                AbstractC13460gG3.c.a aVar2 = AbstractC13460gG3.c.b;
                if (AbstractC13042fc3.d(abstractC13460gG3A, aVar2.a())) {
                    eVar = AbstractC6459Nq2.U(new OE2[0]);
                } else {
                    if (!(zs4.p().a(this.f) instanceof AbstractC13460gG3.a)) {
                        zs4.p().c(this.f, aVar2.b());
                    }
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    interfaceC19699qn4.e(null);
                    eVar = new e(AbstractC6459Nq2.y(this.e.h.c(this.f), iIntValue == 0 ? 0 : 1), iIntValue);
                }
                this.c = null;
                this.d = null;
                this.g = null;
                this.b = 2;
                if (AbstractC6459Nq2.A(interfaceC4806Gq2, eVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            } finally {
                interfaceC19699qn4.e(null);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(InterfaceC4806Gq2 interfaceC4806Gq2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(interfaceC20295rm1, this.e, this.f);
            bVar.c = interfaceC4806Gq2;
            bVar.d = obj;
            return bVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class c extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ Object c;
        /* synthetic */ Object d;
        final /* synthetic */ EnumC16433lG3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(EnumC16433lG3 enumC16433lG3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
            this.e = enumC16433lG3;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            OE2 oe2 = (OE2) this.c;
            OE2 oe22 = (OE2) this.d;
            return YS4.a(oe22, oe2, this.e) ? oe22 : oe2;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(OE2 oe2, OE2 oe22, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.e, interfaceC20295rm1);
            cVar.c = oe2;
            cVar.d = oe22;
            return cVar.invokeSuspend(C19938rB7.a);
        }
    }

    static final class d implements InterfaceC4806Gq2 {
        final /* synthetic */ EnumC16433lG3 b;

        d(EnumC16433lG3 enumC16433lG3) {
            this.b = enumC16433lG3;
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(OE2 oe2, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
            Object objT = XS4.this.t(this.b, oe2, interfaceC20295rm1);
            return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
        }
    }

    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;
        final /* synthetic */ int b;

        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;
            final /* synthetic */ int b;

            /* renamed from: ir.nasim.XS4$e$a$a, reason: collision with other inner class name */
            public static final class C0751a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0751a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2, int i) {
                this.a = interfaceC4806Gq2;
                this.b = i;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ir.nasim.InterfaceC4806Gq2
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object a(java.lang.Object r6, ir.nasim.InterfaceC20295rm1 r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof ir.nasim.XS4.e.a.C0751a
                    if (r0 == 0) goto L13
                    r0 = r7
                    ir.nasim.XS4$e$a$a r0 = (ir.nasim.XS4.e.a.C0751a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.XS4$e$a$a r0 = new ir.nasim.XS4$e$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r7)
                    goto L48
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    ir.nasim.AbstractC10685c16.b(r7)
                    ir.nasim.Gq2 r7 = r5.a
                    ir.nasim.sY7 r6 = (ir.nasim.AbstractC20754sY7) r6
                    ir.nasim.OE2 r2 = new ir.nasim.OE2
                    int r4 = r5.b
                    r2.<init>(r4, r6)
                    r0.b = r3
                    java.lang.Object r6 = r7.a(r2, r0)
                    if (r6 != r1) goto L48
                    return r1
                L48:
                    ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2, int i) {
            this.a = interfaceC4557Fq2;
            this.b = i;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2, this.b), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    static final class f extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= RecyclerView.UNDEFINED_DURATION;
            return XS4.this.r(this);
        }
    }

    static final class g extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return XS4.this.s(this);
        }
    }

    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        int l;
        int m;
        /* synthetic */ Object n;
        int p;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.n = obj;
            this.p |= RecyclerView.UNDEFINED_DURATION;
            return XS4.this.t(null, null, this);
        }
    }

    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;
        private /* synthetic */ Object f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ XS4 c;
            final /* synthetic */ OC6 d;

            /* renamed from: ir.nasim.XS4$i$a$a, reason: collision with other inner class name */
            static final class C0752a implements InterfaceC4806Gq2 {
                final /* synthetic */ OC6 a;

                /* renamed from: ir.nasim.XS4$i$a$a$a, reason: collision with other inner class name */
                static final class C0753a extends AbstractC22163um1 {
                    /* synthetic */ Object a;
                    int c;

                    C0753a(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.c |= RecyclerView.UNDEFINED_DURATION;
                        return C0752a.this.a(null, this);
                    }
                }

                C0752a(OC6 oc6) {
                    this.a = oc6;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.VS4 r5, ir.nasim.InterfaceC20295rm1 r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ir.nasim.XS4.i.a.C0752a.C0753a
                        if (r0 == 0) goto L13
                        r0 = r6
                        ir.nasim.XS4$i$a$a$a r0 = (ir.nasim.XS4.i.a.C0752a.C0753a) r0
                        int r1 = r0.c
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.c = r1
                        goto L18
                    L13:
                        ir.nasim.XS4$i$a$a$a r0 = new ir.nasim.XS4$i$a$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.a
                        java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                        int r2 = r0.c
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        ir.nasim.AbstractC10685c16.b(r6)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                        goto L3f
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        ir.nasim.AbstractC10685c16.b(r6)
                        ir.nasim.OC6 r6 = r4.a     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                        r0.c = r3     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                        java.lang.Object r5 = r6.o(r5, r0)     // Catch: kotlinx.coroutines.channels.ClosedSendChannelException -> L3f
                        if (r5 != r1) goto L3f
                        return r1
                    L3f:
                        ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.i.a.C0752a.a(ir.nasim.VS4, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(XS4 xs4, OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = xs4;
                this.d = oc6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(this.c.j);
                    C0752a c0752a = new C0752a(this.d);
                    this.b = 1;
                    if (interfaceC4557Fq2R.b(c0752a, this) == objE) {
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

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ XS4 c;
            final /* synthetic */ InterfaceC17639nJ0 d;

            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ InterfaceC17639nJ0 a;

                a(InterfaceC17639nJ0 interfaceC17639nJ0) {
                    this.a = interfaceC17639nJ0;
                }

                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object a(C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
                    this.a.h(c19938rB7);
                    return C19938rB7.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(XS4 xs4, InterfaceC17639nJ0 interfaceC17639nJ0, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = xs4;
                this.d = interfaceC17639nJ0;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    InterfaceC4557Fq2 interfaceC4557Fq2 = this.c.d;
                    a aVar = new a(this.d);
                    this.b = 1;
                    if (interfaceC4557Fq2.b(aVar, this) == objE) {
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
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC17639nJ0 d;
            final /* synthetic */ XS4 e;

            static final class a implements InterfaceC4806Gq2 {
                final /* synthetic */ XS4 a;
                final /* synthetic */ InterfaceC20315ro1 b;

                /* renamed from: ir.nasim.XS4$i$c$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0754a {
                    public static final /* synthetic */ int[] a;

                    static {
                        int[] iArr = new int[EnumC16433lG3.values().length];
                        try {
                            iArr[EnumC16433lG3.REFRESH.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        a = iArr;
                    }
                }

                static final class b extends AbstractC22163um1 {
                    Object a;
                    Object b;
                    Object c;
                    Object d;
                    Object e;
                    Object f;
                    Object g;
                    Object h;
                    /* synthetic */ Object i;
                    int k;

                    b(InterfaceC20295rm1 interfaceC20295rm1) {
                        super(interfaceC20295rm1);
                    }

                    @Override // ir.nasim.E90
                    public final Object invokeSuspend(Object obj) {
                        this.i = obj;
                        this.k |= RecyclerView.UNDEFINED_DURATION;
                        return a.this.a(null, this);
                    }
                }

                a(XS4 xs4, InterfaceC20315ro1 interfaceC20315ro1) {
                    this.a = xs4;
                    this.b = interfaceC20315ro1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:107:0x0386  */
                /* JADX WARN: Removed duplicated region for block: B:108:0x038a  */
                /* JADX WARN: Removed duplicated region for block: B:116:0x03de A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:117:0x03df  */
                /* JADX WARN: Removed duplicated region for block: B:120:0x03e7  */
                /* JADX WARN: Removed duplicated region for block: B:126:0x0419  */
                /* JADX WARN: Removed duplicated region for block: B:136:0x0434  */
                /* JADX WARN: Removed duplicated region for block: B:144:0x0471 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:145:0x0472  */
                /* JADX WARN: Removed duplicated region for block: B:153:0x048e  */
                /* JADX WARN: Removed duplicated region for block: B:154:0x0492  */
                /* JADX WARN: Removed duplicated region for block: B:162:0x04e4 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:163:0x04e5  */
                /* JADX WARN: Removed duplicated region for block: B:166:0x04ea  */
                /* JADX WARN: Removed duplicated region for block: B:173:0x051d  */
                /* JADX WARN: Removed duplicated region for block: B:55:0x0259  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x026c  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x027a  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x027e  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x02d0 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:71:0x02d1  */
                /* JADX WARN: Removed duplicated region for block: B:74:0x02d9  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                /* JADX WARN: Removed duplicated region for block: B:80:0x030a  */
                /* JADX WARN: Removed duplicated region for block: B:90:0x0325  */
                /* JADX WARN: Removed duplicated region for block: B:98:0x0367 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:99:0x0368  */
                /* JADX WARN: Type inference failed for: r1v0, types: [int] */
                /* JADX WARN: Type inference failed for: r1v1, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v14, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v2, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v3, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v39, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v68, types: [ir.nasim.qn4] */
                /* JADX WARN: Type inference failed for: r1v86 */
                /* JADX WARN: Type inference failed for: r1v87 */
                /* JADX WARN: Type inference failed for: r1v89 */
                /* JADX WARN: Type inference failed for: r1v90 */
                /* JADX WARN: Type inference failed for: r1v92 */
                /* JADX WARN: Type inference failed for: r1v93 */
                @Override // ir.nasim.InterfaceC4806Gq2
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object a(ir.nasim.C19938rB7 r14, ir.nasim.InterfaceC20295rm1 r15) {
                    /*
                        Method dump skipped, instructions count: 1370
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.i.c.a.a(ir.nasim.rB7, ir.nasim.rm1):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC17639nJ0 interfaceC17639nJ0, XS4 xs4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC17639nJ0;
                this.e = xs4;
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
                    InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                    InterfaceC4557Fq2 interfaceC4557Fq2R = AbstractC6459Nq2.r(this.d);
                    a aVar = new a(this.e, interfaceC20315ro1);
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
                return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = XS4.this.new i(interfaceC20295rm1);
            iVar.f = obj;
            return iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00dc A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 294
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(OC6 oc6, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(oc6, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            j jVar = XS4.this.new j(interfaceC20295rm1);
            jVar.e = obj;
            return jVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4806Gq2 interfaceC4806Gq2;
            ZS4.a aVar;
            InterfaceC19699qn4 interfaceC19699qn4;
            Object objE = AbstractC14862ic3.e();
            int i = this.d;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.e;
                    aVar = XS4.this.k;
                    InterfaceC19699qn4 interfaceC19699qn42 = aVar.b;
                    this.e = aVar;
                    this.b = interfaceC19699qn42;
                    this.c = interfaceC4806Gq2;
                    this.d = 1;
                    if (interfaceC19699qn42.a(null, this) == objE) {
                        return objE;
                    }
                    interfaceC19699qn4 = interfaceC19699qn42;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    interfaceC4806Gq2 = (InterfaceC4806Gq2) this.c;
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.b;
                    aVar = (ZS4.a) this.e;
                    AbstractC10685c16.b(obj);
                }
                C14653iG3 c14653iG3D = aVar.c.p().d();
                interfaceC19699qn4.e(null);
                VS4.c cVar = new VS4.c(c14653iG3D, null, 2, null);
                this.e = null;
                this.b = null;
                this.c = null;
                this.d = 2;
                if (interfaceC4806Gq2.a(cVar, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ XS4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(XS4 xs4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = xs4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                AbstractC20754sY7 abstractC20754sY7 = (AbstractC20754sY7) this.c;
                return AbstractC6392Nk0.a(abstractC20754sY7.d() * (-1) > this.d.c.f || abstractC20754sY7.c() * (-1) > this.d.c.f);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(AbstractC20754sY7 abstractC20754sY7, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(abstractC20754sY7, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        k(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XS4.this.new k(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2Z = AbstractC6459Nq2.Z(XS4.this.h.c(EnumC16433lG3.APPEND), XS4.this.h.c(EnumC16433lG3.PREPEND));
                a aVar = new a(XS4.this, null);
                this.b = 1;
                obj = AbstractC6459Nq2.J(interfaceC4557Fq2Z, aVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            AbstractC20754sY7 abstractC20754sY7 = (AbstractC20754sY7) obj;
            if (abstractC20754sY7 != null) {
                XS4 xs4 = XS4.this;
                XT4 xt4 = XT4.a;
                if (xt4.a(3)) {
                    xt4.b(3, "Jump triggered on PagingSource " + xs4.v() + " by " + abstractC20754sY7, null);
                }
                XS4.this.g.invoke();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class l extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        l(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XS4.this.new l(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            XS4 xs4;
            ZS4.a aVar;
            InterfaceC19699qn4 interfaceC19699qn4;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    xs4 = XS4.this;
                    aVar = xs4.k;
                    InterfaceC19699qn4 interfaceC19699qn42 = aVar.b;
                    this.b = aVar;
                    this.c = interfaceC19699qn42;
                    this.d = xs4;
                    this.e = 1;
                    if (interfaceC19699qn42.a(null, this) == objE) {
                        return objE;
                    }
                    interfaceC19699qn4 = interfaceC19699qn42;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    xs4 = (XS4) this.d;
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.c;
                    aVar = (ZS4.a) this.b;
                    AbstractC10685c16.b(obj);
                }
                InterfaceC4557Fq2 interfaceC4557Fq2F = aVar.c.f();
                interfaceC19699qn4.e(null);
                EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.PREPEND;
                this.b = null;
                this.c = null;
                this.d = null;
                this.e = 2;
                if (xs4.q(interfaceC4557Fq2F, enumC16433lG3, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((l) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class m extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        int e;

        m(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return XS4.this.new m(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            XS4 xs4;
            ZS4.a aVar;
            InterfaceC19699qn4 interfaceC19699qn4;
            Object objE = AbstractC14862ic3.e();
            int i = this.e;
            try {
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    xs4 = XS4.this;
                    aVar = xs4.k;
                    InterfaceC19699qn4 interfaceC19699qn42 = aVar.b;
                    this.b = aVar;
                    this.c = interfaceC19699qn42;
                    this.d = xs4;
                    this.e = 1;
                    if (interfaceC19699qn42.a(null, this) == objE) {
                        return objE;
                    }
                    interfaceC19699qn4 = interfaceC19699qn42;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC10685c16.b(obj);
                        return C19938rB7.a;
                    }
                    xs4 = (XS4) this.d;
                    interfaceC19699qn4 = (InterfaceC19699qn4) this.c;
                    aVar = (ZS4.a) this.b;
                    AbstractC10685c16.b(obj);
                }
                InterfaceC4557Fq2 interfaceC4557Fq2E = aVar.c.e();
                interfaceC19699qn4.e(null);
                EnumC16433lG3 enumC16433lG3 = EnumC16433lG3.APPEND;
                this.b = null;
                this.c = null;
                this.d = null;
                this.e = 2;
                if (xs4.q(interfaceC4557Fq2E, enumC16433lG3, this) == objE) {
                    return objE;
                }
                return C19938rB7.a;
            } catch (Throwable th) {
                interfaceC19699qn4.e(null);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((m) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public XS4(Object obj, YT4 yt4, MT4 mt4, InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC22520vN5 interfaceC22520vN5, ZT4 zt4, SA2 sa2) {
        AbstractC13042fc3.i(yt4, "pagingSource");
        AbstractC13042fc3.i(mt4, "config");
        AbstractC13042fc3.i(interfaceC4557Fq2, "retryFlow");
        AbstractC13042fc3.i(sa2, "jumpCallback");
        this.a = obj;
        this.b = yt4;
        this.c = mt4;
        this.d = interfaceC4557Fq2;
        this.e = interfaceC22520vN5;
        this.f = zt4;
        this.g = sa2;
        if (mt4.f != Integer.MIN_VALUE && !yt4.b()) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
        }
        this.h = new C13621gY2();
        this.i = new AtomicBoolean(false);
        this.j = DJ0.b(-2, null, null, 6, null);
        this.k = new ZS4.a(mt4);
        InterfaceC24075y01 interfaceC24075y01B = AbstractC20267rj3.b(null, 1, null);
        this.l = interfaceC24075y01B;
        this.m = AbstractC6459Nq2.c0(DE0.a(interfaceC24075y01B, new i(null)), new j(null));
    }

    private final void A() {
        p();
        this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B(EnumC16433lG3 enumC16433lG3, AbstractC20754sY7 abstractC20754sY7, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        if (a.a[enumC16433lG3.ordinal()] == 1) {
            Object objS = s(interfaceC20295rm1);
            return objS == AbstractC14862ic3.e() ? objS : C19938rB7.a;
        }
        if (abstractC20754sY7 == null) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
        }
        this.h.a(enumC16433lG3, abstractC20754sY7);
        return C19938rB7.a;
    }

    private final Object C(ZS4 zs4, EnumC16433lG3 enumC16433lG3, AbstractC13460gG3.a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
        if (AbstractC13042fc3.d(zs4.p().a(enumC16433lG3), aVar)) {
            return C19938rB7.a;
        }
        zs4.p().c(enumC16433lG3, aVar);
        Object objO = this.j.o(new VS4.c(zs4.p().d(), null), interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object D(ZS4 zs4, EnumC16433lG3 enumC16433lG3, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13460gG3 abstractC13460gG3A = zs4.p().a(enumC16433lG3);
        AbstractC13460gG3.b bVar = AbstractC13460gG3.b.b;
        if (AbstractC13042fc3.d(abstractC13460gG3A, bVar)) {
            return C19938rB7.a;
        }
        zs4.p().c(enumC16433lG3, bVar);
        Object objO = this.j.o(new VS4.c(zs4.p().d(), null), interfaceC20295rm1);
        return objO == AbstractC14862ic3.e() ? objO : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(InterfaceC20315ro1 interfaceC20315ro1) {
        if (this.c.f != Integer.MIN_VALUE) {
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new k(null), 3, null);
        }
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new l(null), 3, null);
        AbstractC10533bm0.d(interfaceC20315ro1, null, null, new m(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(InterfaceC4557Fq2 interfaceC4557Fq2, EnumC16433lG3 enumC16433lG3, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC6459Nq2.q(AbstractC6209Mq2.b(AbstractC6209Mq2.d(interfaceC4557Fq2, new b(null, this, enumC16433lG3)), new c(enumC16433lG3, null))).b(new d(enumC16433lG3), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0186 A[Catch: all -> 0x0194, TryCatch #1 {all -> 0x0194, blocks: (B:54:0x0162, B:56:0x0186, B:59:0x0197, B:61:0x01a0), top: B:137:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a0 A[Catch: all -> 0x0194, TRY_LEAVE, TryCatch #1 {all -> 0x0194, blocks: (B:54:0x0162, B:56:0x0186, B:59:0x0197, B:61:0x01a0), top: B:137:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0271  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r2v2, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r2v41, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v9, types: [ir.nasim.qn4] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(ir.nasim.InterfaceC20295rm1 r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.s(ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0357, code lost:
    
        r0 = r9;
        r8 = r12;
        r9 = r13;
        r12 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:208:0x066f, B:211:0x067a], limit reached: 263 */
    /* JADX WARN: Path cross not found for [B:214:0x067f, B:217:0x0689], limit reached: 263 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0525 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x059a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05b7 A[Catch: all -> 0x05f2, TRY_LEAVE, TryCatch #3 {all -> 0x05f2, blocks: (B:182:0x05a9, B:184:0x05b7), top: B:255:0x05a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0610 A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:188:0x05e8, B:192:0x05f9, B:194:0x0610, B:196:0x061c, B:198:0x0624, B:200:0x0631, B:199:0x062b, B:201:0x0634, B:205:0x0665, B:14:0x0087, B:19:0x00c2), top: B:257:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0624 A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:188:0x05e8, B:192:0x05f9, B:194:0x0610, B:196:0x061c, B:198:0x0624, B:200:0x0631, B:199:0x062b, B:201:0x0634, B:205:0x0665, B:14:0x0087, B:19:0x00c2), top: B:257:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x062b A[Catch: all -> 0x0096, TryCatch #4 {all -> 0x0096, blocks: (B:188:0x05e8, B:192:0x05f9, B:194:0x0610, B:196:0x061c, B:198:0x0624, B:200:0x0631, B:199:0x062b, B:201:0x0634, B:205:0x0665, B:14:0x0087, B:19:0x00c2), top: B:257:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x065e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x06ee  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0701 A[Catch: all -> 0x0257, TRY_ENTER, TryCatch #5 {all -> 0x0257, blocks: (B:43:0x0223, B:68:0x02d4, B:50:0x023a, B:52:0x024a, B:55:0x025b, B:57:0x0265, B:59:0x027e, B:60:0x0281, B:62:0x029a, B:65:0x02b8, B:67:0x02d1, B:243:0x0701, B:244:0x0706), top: B:259:0x0223 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0324 A[Catch: all -> 0x0347, TRY_LEAVE, TryCatch #6 {all -> 0x0347, blocks: (B:73:0x030b, B:75:0x0324), top: B:260:0x030b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03c0  */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [ir.nasim.qn4] */
    /* JADX WARN: Type inference failed for: r6v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:225:0x06ba -> B:262:0x06bf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(ir.nasim.EnumC16433lG3 r20, ir.nasim.OE2 r21, ir.nasim.InterfaceC20295rm1 r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1842
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.t(ir.nasim.lG3, ir.nasim.OE2, ir.nasim.rm1):java.lang.Object");
    }

    private final YT4.a x(EnumC16433lG3 enumC16433lG3, Object obj) {
        return YT4.a.c.a(enumC16433lG3, obj, enumC16433lG3 == EnumC16433lG3.REFRESH ? this.c.d : this.c.a, this.c.c);
    }

    private final String y(EnumC16433lG3 enumC16433lG3, Object obj, YT4.b bVar) {
        if (bVar == null) {
            return "End " + enumC16433lG3 + " with loadkey " + obj + ". Load CANCELLED.";
        }
        return "End " + enumC16433lG3 + " with loadKey " + obj + ". Returned " + bVar;
    }

    private final Object z(ZS4 zs4, EnumC16433lG3 enumC16433lG3, int i2, int i3) {
        if (i2 == zs4.j(enumC16433lG3) && !(zs4.p().a(enumC16433lG3) instanceof AbstractC13460gG3.a) && i3 < this.c.b) {
            return enumC16433lG3 == EnumC16433lG3.PREPEND ? ((YT4.b.c) AbstractC15401jX0.q0(zs4.m())).o() : ((YT4.b.c) AbstractC15401jX0.C0(zs4.m())).j();
        }
        return null;
    }

    public final void o(AbstractC20754sY7 abstractC20754sY7) {
        AbstractC13042fc3.i(abstractC20754sY7, "viewportHint");
        this.h.d(abstractC20754sY7);
    }

    public final void p() {
        InterfaceC13730gj3.a.a(this.l, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(ir.nasim.InterfaceC20295rm1 r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ir.nasim.XS4.f
            if (r0 == 0) goto L13
            r0 = r6
            ir.nasim.XS4$f r0 = (ir.nasim.XS4.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ir.nasim.XS4$f r0 = new ir.nasim.XS4$f
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.f
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r1 = r0.c
            ir.nasim.qn4 r1 = (ir.nasim.InterfaceC19699qn4) r1
            java.lang.Object r2 = r0.b
            ir.nasim.ZS4$a r2 = (ir.nasim.ZS4.a) r2
            java.lang.Object r0 = r0.a
            ir.nasim.XS4 r0 = (ir.nasim.XS4) r0
            ir.nasim.AbstractC10685c16.b(r6)
            goto L58
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3e:
            ir.nasim.AbstractC10685c16.b(r6)
            ir.nasim.ZS4$a r2 = r5.k
            ir.nasim.qn4 r6 = ir.nasim.ZS4.a.a(r2)
            r0.a = r5
            r0.b = r2
            r0.c = r6
            r0.f = r3
            java.lang.Object r0 = r6.a(r4, r0)
            if (r0 != r1) goto L56
            return r1
        L56:
            r0 = r5
            r1 = r6
        L58:
            ir.nasim.ZS4 r6 = ir.nasim.ZS4.a.b(r2)     // Catch: java.lang.Throwable -> L6a
            ir.nasim.gY2 r0 = r0.h     // Catch: java.lang.Throwable -> L6a
            ir.nasim.sY7$a r0 = r0.b()     // Catch: java.lang.Throwable -> L6a
            ir.nasim.ZT4 r6 = r6.g(r0)     // Catch: java.lang.Throwable -> L6a
            r1.e(r4)
            return r6
        L6a:
            r6 = move-exception
            r1.e(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.XS4.r(ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 u() {
        return this.m;
    }

    public final YT4 v() {
        return this.b;
    }

    public final InterfaceC22520vN5 w() {
        return this.e;
    }
}
