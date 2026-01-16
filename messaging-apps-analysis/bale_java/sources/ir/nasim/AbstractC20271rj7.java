package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.rj7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20271rj7 {
    private static final InterfaceC15796kB2 a = new a(null);

    /* renamed from: ir.nasim.rj7$a */
    static final class a extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        public final Object n(InterfaceC6194Mo5 interfaceC6194Mo5, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(interfaceC20295rm1).invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC6194Mo5) obj, ((ZG4) obj2).t(), (InterfaceC20295rm1) obj3);
        }
    }

    /* renamed from: ir.nasim.rj7$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int e;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC20271rj7.e(null, false, null, this);
        }
    }

    /* renamed from: ir.nasim.rj7$c */
    static final class c extends V06 implements InterfaceC14603iB2 {
        long a;
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ C6616Og5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C6616Og5 c6616Og5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c6616Og5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            c cVar = new c(this.d, interfaceC20295rm1);
            cVar.c = obj;
            return cVar;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0046 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0044 -> B:12:0x0047). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r11.b
                r2 = 1
                if (r1 == 0) goto L1d
                if (r1 != r2) goto L15
                long r3 = r11.a
                java.lang.Object r1 = r11.c
                ir.nasim.EV r1 = (ir.nasim.EV) r1
                ir.nasim.AbstractC10685c16.b(r12)
                goto L47
            L15:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L1d:
                ir.nasim.AbstractC10685c16.b(r12)
                java.lang.Object r12 = r11.c
                ir.nasim.EV r12 = (ir.nasim.EV) r12
                ir.nasim.Og5 r1 = r11.d
                long r3 = r1.o()
                ir.nasim.oW7 r1 = r12.getViewConfiguration()
                long r5 = r1.b()
                long r3 = r3 + r5
                r1 = r12
            L34:
                r11.c = r1
                r11.a = r3
                r11.b = r2
                r6 = 0
                r7 = 0
                r9 = 3
                r10 = 0
                r5 = r1
                r8 = r11
                java.lang.Object r12 = ir.nasim.AbstractC20271rj7.f(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L47
                return r0
            L47:
                ir.nasim.Og5 r12 = (ir.nasim.C6616Og5) r12
                long r5 = r12.o()
                int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r5 < 0) goto L34
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj7$d */
    static final class d extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC20271rj7.h(null, this);
        }
    }

    /* renamed from: ir.nasim.rj7$e */
    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9049Yg5 d;
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ C6433No5 g;

        /* renamed from: ir.nasim.rj7$e$a */
        static final class a extends V06 implements InterfaceC14603iB2 {
            Object a;
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ InterfaceC20315ro1 d;
            final /* synthetic */ InterfaceC15796kB2 e;
            final /* synthetic */ UA2 f;
            final /* synthetic */ C6433No5 g;

            /* renamed from: ir.nasim.rj7$e$a$a, reason: collision with other inner class name */
            static final class C1516a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC15796kB2 c;
                final /* synthetic */ C6433No5 d;
                final /* synthetic */ C6616Og5 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1516a(InterfaceC15796kB2 interfaceC15796kB2, C6433No5 c6433No5, C6616Og5 c6616Og5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC15796kB2;
                    this.d = c6433No5;
                    this.e = c6616Og5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1516a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC15796kB2 interfaceC15796kB2 = this.c;
                        C6433No5 c6433No5 = this.d;
                        ZG4 zg4D = ZG4.d(this.e.h());
                        this.b = 1;
                        if (interfaceC15796kB2.q(c6433No5, zg4D, this) == objE) {
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
                    return ((C1516a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$e$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
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
                    this.c.b();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$e$a$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new c(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.h();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$e$a$d */
            static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6433No5 c6433No5 = this.c;
                        this.b = 1;
                        if (c6433No5.o(this) == objE) {
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

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = interfaceC20315ro1;
                this.e = interfaceC15796kB2;
                this.f = ua2;
                this.g = c6433No5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, this.g, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x008e  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) {
                /*
                    r12 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r12.b
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L2e
                    if (r1 == r3) goto L21
                    if (r1 != r2) goto L19
                    java.lang.Object r0 = r12.c
                    ir.nasim.gj3 r0 = (ir.nasim.InterfaceC13730gj3) r0
                    ir.nasim.AbstractC10685c16.b(r13)
                    r6 = r0
                    goto L8a
                L19:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r0)
                    throw r13
                L21:
                    java.lang.Object r1 = r12.a
                    ir.nasim.gj3 r1 = (ir.nasim.InterfaceC13730gj3) r1
                    java.lang.Object r5 = r12.c
                    ir.nasim.EV r5 = (ir.nasim.EV) r5
                    ir.nasim.AbstractC10685c16.b(r13)
                    r11 = r5
                    goto L5d
                L2e:
                    ir.nasim.AbstractC10685c16.b(r13)
                    java.lang.Object r13 = r12.c
                    ir.nasim.EV r13 = (ir.nasim.EV) r13
                    ir.nasim.ro1 r5 = r12.d
                    ir.nasim.xo1 r7 = ir.nasim.AbstractC20271rj7.c()
                    ir.nasim.rj7$e$a$d r8 = new ir.nasim.rj7$e$a$d
                    ir.nasim.No5 r1 = r12.g
                    r8.<init>(r1, r4)
                    r9 = 1
                    r10 = 0
                    r6 = 0
                    ir.nasim.gj3 r1 = ir.nasim.AbstractC9323Zl0.d(r5, r6, r7, r8, r9, r10)
                    r12.c = r13
                    r12.a = r1
                    r12.b = r3
                    r6 = 0
                    r7 = 0
                    r9 = 3
                    r5 = r13
                    r8 = r12
                    java.lang.Object r5 = ir.nasim.AbstractC20271rj7.f(r5, r6, r7, r8, r9, r10)
                    if (r5 != r0) goto L5b
                    return r0
                L5b:
                    r11 = r13
                    r13 = r5
                L5d:
                    ir.nasim.Og5 r13 = (ir.nasim.C6616Og5) r13
                    r13.a()
                    ir.nasim.kB2 r5 = r12.e
                    ir.nasim.kB2 r6 = ir.nasim.AbstractC20271rj7.d()
                    if (r5 == r6) goto L7c
                    ir.nasim.ro1 r5 = r12.d
                    ir.nasim.rj7$e$a$a r8 = new ir.nasim.rj7$e$a$a
                    ir.nasim.kB2 r6 = r12.e
                    ir.nasim.No5 r7 = r12.g
                    r8.<init>(r6, r7, r13, r4)
                    r9 = 2
                    r10 = 0
                    r7 = 0
                    r6 = r1
                    ir.nasim.AbstractC20271rj7.p(r5, r6, r7, r8, r9, r10)
                L7c:
                    r12.c = r1
                    r12.a = r4
                    r12.b = r2
                    java.lang.Object r13 = ir.nasim.AbstractC20271rj7.t(r11, r4, r12, r3, r4)
                    if (r13 != r0) goto L89
                    return r0
                L89:
                    r6 = r1
                L8a:
                    ir.nasim.Og5 r13 = (ir.nasim.C6616Og5) r13
                    if (r13 != 0) goto L9e
                    ir.nasim.ro1 r5 = r12.d
                    ir.nasim.rj7$e$a$b r8 = new ir.nasim.rj7$e$a$b
                    ir.nasim.No5 r13 = r12.g
                    r8.<init>(r13, r4)
                    r9 = 2
                    r10 = 0
                    r7 = 0
                    ir.nasim.AbstractC20271rj7.p(r5, r6, r7, r8, r9, r10)
                    goto Lbf
                L9e:
                    r13.a()
                    ir.nasim.ro1 r5 = r12.d
                    ir.nasim.rj7$e$a$c r8 = new ir.nasim.rj7$e$a$c
                    ir.nasim.No5 r0 = r12.g
                    r8.<init>(r0, r4)
                    r9 = 2
                    r10 = 0
                    r7 = 0
                    ir.nasim.AbstractC20271rj7.p(r5, r6, r7, r8, r9, r10)
                    ir.nasim.UA2 r0 = r12.f
                    if (r0 == 0) goto Lbf
                    long r1 = r13.h()
                    ir.nasim.ZG4 r13 = ir.nasim.ZG4.d(r1)
                    r0.invoke(r13)
                Lbf:
                    ir.nasim.rB7 r13 = ir.nasim.C19938rB7.a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.e.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9049Yg5;
            this.e = interfaceC15796kB2;
            this.f = ua2;
            this.g = c6433No5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            e eVar = new e(this.d, this.e, this.f, this.g, interfaceC20295rm1);
            eVar.c = obj;
            return eVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC9049Yg5 interfaceC9049Yg5 = this.d;
                a aVar = new a(interfaceC20315ro1, this.e, this.f, this.g, null);
                this.b = 1;
                if (AbstractC8163Uu2.d(interfaceC9049Yg5, aVar, this) == objE) {
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
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC9049Yg5 d;
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ UA2 h;

        /* renamed from: ir.nasim.rj7$f$a */
        static final class a extends V06 implements InterfaceC14603iB2 {
            Object a;
            Object b;
            Object c;
            int d;
            private /* synthetic */ Object e;
            final /* synthetic */ InterfaceC20315ro1 f;
            final /* synthetic */ InterfaceC15796kB2 g;
            final /* synthetic */ UA2 h;
            final /* synthetic */ UA2 i;
            final /* synthetic */ UA2 j;
            final /* synthetic */ C6433No5 k;

            /* renamed from: ir.nasim.rj7$f$a$a, reason: collision with other inner class name */
            static final class C1517a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC15796kB2 c;
                final /* synthetic */ C6433No5 d;
                final /* synthetic */ C6616Og5 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1517a(InterfaceC15796kB2 interfaceC15796kB2, C6433No5 c6433No5, C6616Og5 c6616Og5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC15796kB2;
                    this.d = c6433No5;
                    this.e = c6616Og5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1517a(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC15796kB2 interfaceC15796kB2 = this.c;
                        C6433No5 c6433No5 = this.d;
                        ZG4 zg4D = ZG4.d(this.e.h());
                        this.b = 1;
                        if (interfaceC15796kB2.q(c6433No5, zg4D, this) == objE) {
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
                    return ((C1517a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$b */
            static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
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
                    this.c.h();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$c */
            static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                c(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new c(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.b();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$d */
            static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                d(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new d(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.h();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$e */
            static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC13730gj3 c;
                final /* synthetic */ C6433No5 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                e(InterfaceC13730gj3 interfaceC13730gj3, C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC13730gj3;
                    this.d = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new e(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
                        this.b = 1;
                        if (interfaceC13730gj3.k0(this) == objE) {
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
                        AbstractC10685c16.b(obj);
                    }
                    C6433No5 c6433No5 = this.d;
                    this.b = 2;
                    if (c6433No5.o(this) == objE) {
                        return objE;
                    }
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$f, reason: collision with other inner class name */
            static final class C1518f extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ InterfaceC15796kB2 c;
                final /* synthetic */ C6433No5 d;
                final /* synthetic */ C6616Og5 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1518f(InterfaceC15796kB2 interfaceC15796kB2, C6433No5 c6433No5, C6616Og5 c6616Og5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = interfaceC15796kB2;
                    this.d = c6433No5;
                    this.e = c6616Og5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1518f(this.c, this.d, this.e, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        InterfaceC15796kB2 interfaceC15796kB2 = this.c;
                        C6433No5 c6433No5 = this.d;
                        ZG4 zg4D = ZG4.d(this.e.h());
                        this.b = 1;
                        if (interfaceC15796kB2.q(c6433No5, zg4D, this) == objE) {
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
                    return ((C1518f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$g */
            static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                g(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new g(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.h();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$h */
            static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                h(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new h(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.b();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$i */
            static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                i(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new i(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C6433No5 c6433No5 = this.c;
                        this.b = 1;
                        if (c6433No5.o(this) == objE) {
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
                    return ((i) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* renamed from: ir.nasim.rj7$f$a$j */
            static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C6433No5 c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                j(C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c6433No5;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new j(this.c, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    this.c.h();
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, UA2 ua22, UA2 ua23, C6433No5 c6433No5, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.f = interfaceC20315ro1;
                this.g = interfaceC15796kB2;
                this.h = ua2;
                this.i = ua22;
                this.j = ua23;
                this.k = c6433No5;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.f, this.g, this.h, this.i, this.j, this.k, interfaceC20295rm1);
                aVar.e = obj;
                return aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00cd  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00eb  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0117  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0146  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0159  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x016a  */
            /* JADX WARN: Removed duplicated region for block: B:49:0x017f  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x01a8  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x01b9  */
            /* JADX WARN: Removed duplicated region for block: B:78:0x022f  */
            /* JADX WARN: Removed duplicated region for block: B:84:0x0262  */
            /* JADX WARN: Removed duplicated region for block: B:91:0x0279  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x0299  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r24) {
                /*
                    Method dump skipped, instructions count: 734
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.f.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, UA2 ua22, UA2 ua23, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC9049Yg5;
            this.e = interfaceC15796kB2;
            this.f = ua2;
            this.g = ua22;
            this.h = ua23;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C6433No5 c6433No5 = new C6433No5(this.d);
                InterfaceC9049Yg5 interfaceC9049Yg5 = this.d;
                a aVar = new a(interfaceC20315ro1, this.e, this.f, this.g, this.h, c6433No5, null);
                this.b = 1;
                if (AbstractC8163Uu2.d(interfaceC9049Yg5, aVar, this) == objE) {
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC13730gj3 d;
        final /* synthetic */ InterfaceC14603iB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC13730gj3;
            this.e = interfaceC14603iB2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(this.d, this.e, interfaceC20295rm1);
            gVar.c = obj;
            return gVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC20315ro1 interfaceC20315ro1;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                if (C9225Za1.d) {
                    InterfaceC13730gj3 interfaceC13730gj3 = this.d;
                    this.c = interfaceC20315ro1;
                    this.b = 1;
                    if (interfaceC13730gj3.k0(this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                AbstractC10685c16.b(obj);
            }
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            this.c = null;
            this.b = 2;
            if (interfaceC14603iB2.invoke(interfaceC20315ro1, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj7$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int c;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC20271rj7.q(null, null, this);
        }
    }

    /* renamed from: ir.nasim.rj7$i */
    static final class i extends V06 implements InterfaceC14603iB2 {
        int a;
        private /* synthetic */ Object b;
        final /* synthetic */ EnumC4002Dg5 c;
        final /* synthetic */ C12889fL5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(EnumC4002Dg5 enumC4002Dg5, C12889fL5 c12889fL5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = enumC4002Dg5;
            this.d = c12889fL5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            i iVar = new i(this.c, this.d, interfaceC20295rm1);
            iVar.b = obj;
            return iVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x005f, code lost:
        
            if (ir.nasim.AbstractC20862sj7.b(r14) == false) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
        
            r13.d.a = ir.nasim.AbstractC15278jJ3.c.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        
            r14 = r14.c();
            r5 = r14.size();
            r6 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        
            if (r6 >= r5) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        
            r7 = (ir.nasim.C6616Og5) r14.get(r6);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
        
            if (r7.p() != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x008f, code lost:
        
            if (ir.nasim.AbstractC3768Cg5.f(r7, r1.a(), r1.t0()) == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0092, code lost:
        
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0095, code lost:
        
            r13.d.a = ir.nasim.AbstractC15278jJ3.a.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
        
            r14 = ir.nasim.EnumC4002Dg5.c;
            r13.b = r1;
            r13.a = 2;
            r14 = r1.f0(r14, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        
            if (r14 != r0) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a8, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
        
            r13.d.a = ir.nasim.AbstractC15278jJ3.a.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00eb, code lost:
        
            return ir.nasim.C19938rB7.a;
         */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a6 -> B:34:0x00a9). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(EV ev, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((i) create(ev, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.rj7$j */
    static final class j extends AbstractC22163um1 {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        j(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return AbstractC20271rj7.s(null, null, this);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(ir.nasim.EV r7, boolean r8, ir.nasim.EnumC4002Dg5 r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            boolean r0 = r10 instanceof ir.nasim.AbstractC20271rj7.b
            if (r0 == 0) goto L13
            r0 = r10
            ir.nasim.rj7$b r0 = (ir.nasim.AbstractC20271rj7.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.rj7$b r0 = new ir.nasim.rj7$b
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r7 = r0.c
            java.lang.Object r8 = r0.b
            ir.nasim.Dg5 r8 = (ir.nasim.EnumC4002Dg5) r8
            java.lang.Object r9 = r0.a
            ir.nasim.EV r9 = (ir.nasim.EV) r9
            ir.nasim.AbstractC10685c16.b(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L51
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            ir.nasim.AbstractC10685c16.b(r10)
        L42:
            r0.a = r7
            r0.b = r9
            r0.c = r8
            r0.e = r3
            java.lang.Object r10 = r7.f0(r9, r0)
            if (r10 != r1) goto L51
            return r1
        L51:
            ir.nasim.Bg5 r10 = (ir.nasim.C3534Bg5) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = n(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L42
            java.util.List r7 = r10.c()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.e(ir.nasim.EV, boolean, ir.nasim.Dg5, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object f(EV ev, boolean z, EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            enumC4002Dg5 = EnumC4002Dg5.b;
        }
        return e(ev, z, enumC4002Dg5, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object g(EV ev, C6616Og5 c6616Og5, InterfaceC20295rm1 interfaceC20295rm1) {
        return ev.f1(ev.getViewConfiguration().a(), new c(c6616Og5, null), interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[LOOP:0: B:19:0x0053->B:20:0x0055, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(ir.nasim.EV r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC20271rj7.d
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.rj7$d r0 = (ir.nasim.AbstractC20271rj7.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.rj7$d r0 = new ir.nasim.rj7$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.a
            ir.nasim.EV r8 = (ir.nasim.EV) r8
            ir.nasim.AbstractC10685c16.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            ir.nasim.AbstractC10685c16.b(r9)
        L38:
            r0.a = r8
            r0.c = r3
            r9 = 0
            java.lang.Object r9 = ir.nasim.EV.D0(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            ir.nasim.Bg5 r9 = (ir.nasim.C3534Bg5) r9
            java.util.List r2 = r9.c()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L53:
            if (r6 >= r4) goto L61
            java.lang.Object r7 = r2.get(r6)
            ir.nasim.Og5 r7 = (ir.nasim.C6616Og5) r7
            r7.a()
            int r6 = r6 + 1
            goto L53
        L61:
            java.util.List r9 = r9.c()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        L6c:
            if (r5 >= r2) goto L7e
            java.lang.Object r4 = r9.get(r5)
            ir.nasim.Og5 r4 = (ir.nasim.C6616Og5) r4
            boolean r4 = r4.i()
            if (r4 == 0) goto L7b
            goto L38
        L7b:
            int r5 = r5 + 1
            goto L6c
        L7e:
            ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.h(ir.nasim.EV, ir.nasim.rm1):java.lang.Object");
    }

    public static final Object i(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new e(interfaceC9049Yg5, interfaceC15796kB2, ua2, new C6433No5(interfaceC9049Yg5), null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public static final Object j(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, UA2 ua22, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua23, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objE = AbstractC20906so1.e(new f(interfaceC9049Yg5, interfaceC15796kB2, ua22, ua2, ua23, null), interfaceC20295rm1);
        return objE == AbstractC14862ic3.e() ? objE : C19938rB7.a;
    }

    public static /* synthetic */ Object k(InterfaceC9049Yg5 interfaceC9049Yg5, UA2 ua2, UA2 ua22, InterfaceC15796kB2 interfaceC15796kB2, UA2 ua23, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        UA2 ua24 = (i2 & 1) != 0 ? null : ua2;
        UA2 ua25 = (i2 & 2) != 0 ? null : ua22;
        if ((i2 & 4) != 0) {
            interfaceC15796kB2 = a;
        }
        return j(interfaceC9049Yg5, ua24, ua25, interfaceC15796kB2, (i2 & 8) != 0 ? null : ua23, interfaceC20295rm1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnumC23959xo1 l() {
        return C9225Za1.d ? EnumC23959xo1.UNDISPATCHED : EnumC23959xo1.DEFAULT;
    }

    private static final boolean m(C3534Bg5 c3534Bg5, boolean z, boolean z2) {
        if (z2) {
            List listC = c3534Bg5.c();
            int size = listC.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (!AbstractC11873dh5.g(((C6616Og5) listC.get(i2)).n(), AbstractC11873dh5.a.b())) {
                        break;
                    }
                    i2++;
                } else if (!AbstractC4470Fg5.b(c3534Bg5.b())) {
                    return false;
                }
            }
        }
        List listC2 = c3534Bg5.c();
        int size2 = listC2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            C6616Og5 c6616Og5 = (C6616Og5) listC2.get(i3);
            if (!(z ? AbstractC3768Cg5.a(c6616Og5) : AbstractC3768Cg5.b(c6616Og5))) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean n(C3534Bg5 c3534Bg5, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = AbstractC20862sj7.a();
        }
        return m(c3534Bg5, z, z2);
    }

    private static final InterfaceC13730gj3 o(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC13730gj3 interfaceC13730gj3, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2) {
        return AbstractC10533bm0.d(interfaceC20315ro1, null, enumC23959xo1, new g(interfaceC13730gj3, interfaceC14603iB2, null), 1, null);
    }

    static /* synthetic */ InterfaceC13730gj3 p(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC13730gj3 interfaceC13730gj3, EnumC23959xo1 enumC23959xo1, InterfaceC14603iB2 interfaceC14603iB2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            enumC23959xo1 = l();
        }
        return o(interfaceC20315ro1, interfaceC13730gj3, enumC23959xo1, interfaceC14603iB2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object q(ir.nasim.EV r7, ir.nasim.EnumC4002Dg5 r8, ir.nasim.InterfaceC20295rm1 r9) {
        /*
            boolean r0 = r9 instanceof ir.nasim.AbstractC20271rj7.h
            if (r0 == 0) goto L13
            r0 = r9
            ir.nasim.rj7$h r0 = (ir.nasim.AbstractC20271rj7.h) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ir.nasim.rj7$h r0 = new ir.nasim.rj7$h
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.a
            ir.nasim.fL5 r7 = (ir.nasim.C12889fL5) r7
            ir.nasim.AbstractC10685c16.b(r9)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            goto L5b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            ir.nasim.AbstractC10685c16.b(r9)
            ir.nasim.fL5 r9 = new ir.nasim.fL5
            r9.<init>()
            ir.nasim.jJ3$a r2 = ir.nasim.AbstractC15278jJ3.a.a
            r9.a = r2
            ir.nasim.oW7 r2 = r7.getViewConfiguration()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            long r4 = r2.c()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            ir.nasim.rj7$i r2 = new ir.nasim.rj7$i     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r6 = 0
            r2.<init>(r8, r9, r6)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r0.a = r9     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r0.c = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            java.lang.Object r7 = r7.Q(r4, r2, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r7 = r9
        L5b:
            java.lang.Object r7 = r7.a
            return r7
        L5e:
            ir.nasim.jJ3$c r7 = ir.nasim.AbstractC15278jJ3.c.a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.q(ir.nasim.EV, ir.nasim.Dg5, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object r(EV ev, EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC4002Dg5 = EnumC4002Dg5.b;
        }
        return q(ev, enumC4002Dg5, interfaceC20295rm1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c6 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s(ir.nasim.EV r18, ir.nasim.EnumC4002Dg5 r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20271rj7.s(ir.nasim.EV, ir.nasim.Dg5, ir.nasim.rm1):java.lang.Object");
    }

    public static /* synthetic */ Object t(EV ev, EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC4002Dg5 = EnumC4002Dg5.b;
        }
        return s(ev, enumC4002Dg5, interfaceC20295rm1);
    }
}
