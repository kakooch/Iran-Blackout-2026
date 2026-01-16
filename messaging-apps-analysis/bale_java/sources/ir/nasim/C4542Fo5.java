package ir.nasim;

import ai.bale.proto.PresenceOuterClass$ResponseGetUsersPresence;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.PI7;
import ir.nasim.Z06;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Fo5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4542Fo5 implements InterfaceC4308Eo5 {
    private final QI7 a;
    private final C12555eo5 b;
    private final InterfaceC20315ro1 c;
    private final AbstractC13778go1 d;
    private final ConcurrentHashMap e;
    private final long f;

    /* renamed from: ir.nasim.Fo5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new a(this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Z06 z06;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C12555eo5 c12555eo5 = C4542Fo5.this.b;
                List listE = AbstractC9766aX0.e(AbstractC6392Nk0.d(this.e));
                this.c = 1;
                obj = c12555eo5.b(listE, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z06 = (Z06) this.b;
                    AbstractC10685c16.b(obj);
                    return (PI7) AbstractC15401jX0.s0(XI7.h(((PresenceOuterClass$ResponseGetUsersPresence) ((Z06.b) z06).a()).getPresencesList(), null, 1, null));
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z062 = (Z06) obj;
            if (z062 instanceof Z06.a) {
                C19406qI3.d("PresenceRepository.fetchUsersPresence", ((Z06.a) z062).a());
                return null;
            }
            if (!(z062 instanceof Z06.b)) {
                throw new NoWhenBranchMatchedException();
            }
            this.b = z062;
            this.c = 2;
            if (C4542Fo5.this.u((Z06.b) z062, this) == objE) {
                return objE;
            }
            z06 = z062;
            return (PI7) AbstractC15401jX0.s0(XI7.h(((PresenceOuterClass$ResponseGetUsersPresence) ((Z06.b) z06).a()).getPresencesList(), null, 1, null));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4542Fo5 c4542Fo5 = C4542Fo5.this;
                List list = this.d;
                this.b = 1;
                if (c4542Fo5.f(list, false, this) == objE) {
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

    /* renamed from: ir.nasim.Fo5$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ C4542Fo5 d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, C4542Fo5 c4542Fo5, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = c4542Fo5;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, this.d, this.e, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r5.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                ir.nasim.AbstractC10685c16.b(r6)
                goto L82
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                ir.nasim.AbstractC10685c16.b(r6)
                goto L5f
            L21:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.a16 r6 = (ir.nasim.C9475a16) r6
                java.lang.Object r6 = r6.l()
                goto L43
            L2b:
                ir.nasim.AbstractC10685c16.b(r6)
                boolean r6 = r5.c
                if (r6 == 0) goto L48
                ir.nasim.Fo5 r6 = r5.d
                ir.nasim.eo5 r6 = ir.nasim.C4542Fo5.n(r6)
                java.util.List r1 = r5.e
                r5.b = r4
                java.lang.Object r6 = r6.c(r1, r5)
                if (r6 != r0) goto L43
                return r0
            L43:
                ir.nasim.a16 r6 = ir.nasim.C9475a16.a(r6)
                goto L84
            L48:
                ir.nasim.Fo5 r6 = r5.d
                ir.nasim.eo5 r6 = ir.nasim.C4542Fo5.n(r6)
                java.util.List r1 = r5.e
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.List r1 = ir.nasim.ZW0.m1(r1)
                r5.b = r3
                java.lang.Object r6 = r6.b(r1, r5)
                if (r6 != r0) goto L5f
                return r0
            L5f:
                ir.nasim.Z06 r6 = (ir.nasim.Z06) r6
                boolean r1 = r6 instanceof ir.nasim.Z06.a
                if (r1 == 0) goto L71
                ir.nasim.Z06$a r6 = (ir.nasim.Z06.a) r6
                ir.nasim.core.network.RpcException r6 = r6.a()
                java.lang.String r0 = "PresenceRepository.fetchUsersPresence"
                ir.nasim.C19406qI3.d(r0, r6)
                goto L82
            L71:
                boolean r1 = r6 instanceof ir.nasim.Z06.b
                if (r1 == 0) goto L85
                ir.nasim.Fo5 r1 = r5.d
                ir.nasim.Z06$b r6 = (ir.nasim.Z06.b) r6
                r5.b = r2
                java.lang.Object r6 = ir.nasim.C4542Fo5.q(r1, r6, r5)
                if (r6 != r0) goto L82
                return r0
            L82:
                ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a
            L84:
                return r6
            L85:
                kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                r6.<init>()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4542Fo5.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$d */
    public static final class d implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Fo5$d$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Fo5$d$a$a, reason: collision with other inner class name */
            public static final class C0376a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0376a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
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
                    boolean r0 = r6 instanceof ir.nasim.C4542Fo5.d.a.C0376a
                    if (r0 == 0) goto L13
                    r0 = r6
                    ir.nasim.Fo5$d$a$a r0 = (ir.nasim.C4542Fo5.d.a.C0376a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Fo5$d$a$a r0 = new ir.nasim.Fo5$d$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r6)
                    goto L49
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    ir.nasim.AbstractC10685c16.b(r6)
                    ir.nasim.Gq2 r6 = r4.a
                    ir.nasim.SI7 r5 = (ir.nasim.SI7) r5
                    if (r5 == 0) goto L3f
                    ir.nasim.PI7 r5 = ir.nasim.XI7.f(r5)
                    goto L40
                L3f:
                    r5 = 0
                L40:
                    r0.b = r3
                    java.lang.Object r5 = r6.a(r5, r0)
                    if (r5 != r1) goto L49
                    return r1
                L49:
                    ir.nasim.rB7 r5 = ir.nasim.C19938rB7.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4542Fo5.d.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public d(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fo5$e */
    public static final class e implements InterfaceC4557Fq2 {
        final /* synthetic */ InterfaceC4557Fq2 a;

        /* renamed from: ir.nasim.Fo5$e$a */
        public static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ InterfaceC4806Gq2 a;

            /* renamed from: ir.nasim.Fo5$e$a$a, reason: collision with other inner class name */
            public static final class C0377a extends AbstractC22163um1 {
                /* synthetic */ Object a;
                int b;

                public C0377a(InterfaceC20295rm1 interfaceC20295rm1) {
                    super(interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= RecyclerView.UNDEFINED_DURATION;
                    return a.this.a(null, this);
                }
            }

            public a(InterfaceC4806Gq2 interfaceC4806Gq2) {
                this.a = interfaceC4806Gq2;
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
                    boolean r0 = r9 instanceof ir.nasim.C4542Fo5.e.a.C0377a
                    if (r0 == 0) goto L13
                    r0 = r9
                    ir.nasim.Fo5$e$a$a r0 = (ir.nasim.C4542Fo5.e.a.C0377a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    ir.nasim.Fo5$e$a$a r0 = new ir.nasim.Fo5$e$a$a
                    r0.<init>(r9)
                L18:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L9a
                L29:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L31:
                    ir.nasim.AbstractC10685c16.b(r9)
                    ir.nasim.Gq2 r9 = r7.a
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r5 = ir.nasim.ZW0.x(r8, r4)
                    r2.<init>(r5)
                    java.util.Iterator r8 = r8.iterator()
                L49:
                    boolean r5 = r8.hasNext()
                    if (r5 == 0) goto L5d
                    java.lang.Object r5 = r8.next()
                    ir.nasim.SI7 r5 = (ir.nasim.SI7) r5
                    ir.nasim.PI7 r5 = ir.nasim.XI7.f(r5)
                    r2.add(r5)
                    goto L49
                L5d:
                    int r8 = ir.nasim.ZW0.x(r2, r4)
                    int r8 = ir.nasim.AbstractC18278oO3.f(r8)
                    r4 = 16
                    int r8 = ir.nasim.AbstractC21867uG5.e(r8, r4)
                    java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
                    r4.<init>(r8)
                    java.util.Iterator r8 = r2.iterator()
                L74:
                    boolean r2 = r8.hasNext()
                    if (r2 == 0) goto L91
                    java.lang.Object r2 = r8.next()
                    r5 = r2
                    ir.nasim.PI7 r5 = (ir.nasim.PI7) r5
                    ir.nasim.d25 r5 = r5.s()
                    long r5 = r5.u()
                    java.lang.Long r5 = ir.nasim.AbstractC6392Nk0.e(r5)
                    r4.put(r5, r2)
                    goto L74
                L91:
                    r0.b = r3
                    java.lang.Object r8 = r9.a(r4, r0)
                    if (r8 != r1) goto L9a
                    return r1
                L9a:
                    ir.nasim.rB7 r8 = ir.nasim.C19938rB7.a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C4542Fo5.e.a.a(java.lang.Object, ir.nasim.rm1):java.lang.Object");
            }
        }

        public e(InterfaceC4557Fq2 interfaceC4557Fq2) {
            this.a = interfaceC4557Fq2;
        }

        @Override // ir.nasim.InterfaceC4557Fq2
        public Object b(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            Object objB = this.a.b(new a(interfaceC4806Gq2), interfaceC20295rm1);
            return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Fo5$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new f(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                QI7 qi7 = C4542Fo5.this.a;
                long j = this.d;
                this.b = 1;
                obj = qi7.c(j, this);
                if (obj == objE) {
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
            if (obj == null) {
                C4542Fo5 c4542Fo5 = C4542Fo5.this;
                int i2 = (int) this.d;
                this.b = 2;
                if (c4542Fo5.b(i2, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC4806Gq2 interfaceC4806Gq2, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC4806Gq2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;
        final /* synthetic */ boolean e;
        final /* synthetic */ C4542Fo5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j, long j2, boolean z, C4542Fo5 c4542Fo5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = j;
            this.d = j2;
            this.e = z;
            this.f = c4542Fo5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new g(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                SI7 si7 = new SI7(C11458d25.r(this.c).u(), this.d, PI7.a.OFFLINE.p(), this.e);
                QI7 qi7 = this.f.a;
                this.b = 1;
                if (qi7.d(si7, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.f.e.get(AbstractC6392Nk0.e(this.c));
            if (interfaceC13730gj3 != null) {
                InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new h(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4542Fo5.this.r(this.d);
                QI7 qi7 = C4542Fo5.this.a;
                long j = this.d;
                long j2 = this.e;
                int iP = PI7.a.OFFLINE.p();
                this.b = 1;
                if (qi7.e(j, j2, iP, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$i */
    static final class i extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new i(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C4542Fo5.this.t(this.d, this.e);
                QI7 qi7 = C4542Fo5.this.a;
                long j = this.d;
                long j2 = this.e;
                int iP = PI7.a.ONLINE.p();
                this.b = 1;
                if (qi7.e(j, j2, iP, this) == objE) {
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

    /* renamed from: ir.nasim.Fo5$j */
    static final class j extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C4542Fo5.this.new j(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long j = C4542Fo5.this.f;
                this.b = 1;
                if (HG1.b(j, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            C4542Fo5.this.e(this.d, this.e);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((j) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.Fo5$k */
    static final class k extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Z06.b c;
        final /* synthetic */ C4542Fo5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Z06.b bVar, C4542Fo5 c4542Fo5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = bVar;
            this.d = c4542Fo5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new k(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                List listL = XI7.l(((PresenceOuterClass$ResponseGetUsersPresence) this.c.a()).getPresencesList(), null, 1, null);
                QI7 qi7 = this.d.a;
                this.b = 1;
                if (qi7.f(listL, this) == objE) {
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
            return ((k) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C4542Fo5(QI7 qi7, C12555eo5 c12555eo5, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(qi7, "presenceDao");
        AbstractC13042fc3.i(c12555eo5, "presenceApi");
        AbstractC13042fc3.i(interfaceC20315ro1, "externalScope");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = qi7;
        this.b = c12555eo5;
        this.c = interfaceC20315ro1;
        this.d = abstractC13778go1;
        this.e = new ConcurrentHashMap();
        this.f = PI7.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long j2) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.e.remove(Long.valueOf(j2));
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
    }

    private final void s(long j2, long j3, boolean z) {
        AbstractC10533bm0.d(this.c, this.d, null, new g(j2, j3, z, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(long j2, long j3) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) this.e.get(Long.valueOf(j2));
        if (interfaceC13730gj3 != null) {
            InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        }
        this.e.put(Long.valueOf(j2), AbstractC10533bm0.d(this.c, null, null, new j(j2, j3, null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object u(Z06.b bVar, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.d, new k(bVar, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public InterfaceC4557Fq2 a(List list) {
        AbstractC13042fc3.i(list, "userIds");
        return new e(AbstractC6459Nq2.V(this.a.a(AbstractC15401jX0.m1(list)), this.d));
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public Object b(int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.d, new a(i2, null), interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public InterfaceC4557Fq2 c(long j2) {
        return new d(AbstractC6459Nq2.V(AbstractC6459Nq2.c0(this.a.b(j2), new f(j2, null)), this.d));
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public void d(long j2, long j3) {
        s(j2, j3, false);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public void e(long j2, long j3) {
        AbstractC10533bm0.d(this.c, this.d, null, new h(j2, j3, null), 2, null);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public Object f(List list, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        if (list.isEmpty()) {
            return C19938rB7.a;
        }
        Object objG = AbstractC9323Zl0.g(this.d, new c(z, this, list, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public void g(long j2, long j3) {
        s(j2, j3, true);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public Object h(long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.a.c(j2, interfaceC20295rm1);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public void i(List list) {
        AbstractC13042fc3.i(list, "userIds");
        AbstractC10533bm0.d(this.c, null, null, new b(list, null), 3, null);
    }

    @Override // ir.nasim.InterfaceC4308Eo5
    public void j(long j2, long j3) {
        AbstractC10533bm0.d(this.c, this.d, null, new i(j2, j3, null), 2, null);
    }
}
