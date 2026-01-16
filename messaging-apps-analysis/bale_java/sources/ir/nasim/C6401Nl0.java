package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* renamed from: ir.nasim.Nl0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C6401Nl0 implements InterfaceC17639nJ0 {
    private static final AtomicLongFieldUpdater d = AtomicLongFieldUpdater.newUpdater(C6401Nl0.class, "sendersAndCloseStatus");
    private static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(C6401Nl0.class, "receivers");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(C6401Nl0.class, "bufferEnd");
    private static final AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(C6401Nl0.class, "completedExpandBuffersAndPauseFlag");
    private static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C6401Nl0.class, Object.class, "sendSegment");
    private static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(C6401Nl0.class, Object.class, "receiveSegment");
    private static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(C6401Nl0.class, Object.class, "bufferEndSegment");
    private static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(C6401Nl0.class, Object.class, "_closeCause");
    private static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(C6401Nl0.class, Object.class, "closeHandler");
    private volatile Object _closeCause;
    private final int a;
    public final UA2 b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private final InterfaceC15796kB2 c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* renamed from: ir.nasim.Nl0$a */
    private final class a implements CJ0, InterfaceC21726u18 {
        private Object a = AbstractC6661Ol0.p;
        private IE0 b;

        public a() {
        }

        private final Object f(JJ0 jj0, int i, long j, InterfaceC20295rm1 interfaceC20295rm1) {
            Boolean boolA;
            C6401Nl0 c6401Nl0 = C6401Nl0.this;
            IE0 ie0B = KE0.b(AbstractC14251hc3.c(interfaceC20295rm1));
            try {
                this.b = ie0B;
                Object objR0 = c6401Nl0.R0(jj0, i, j, this);
                if (objR0 == AbstractC6661Ol0.m) {
                    c6401Nl0.x0(this, jj0, i);
                } else {
                    UA2 ua2A = null;
                    if (objR0 == AbstractC6661Ol0.o) {
                        if (j < c6401Nl0.Y()) {
                            jj0.b();
                        }
                        JJ0 jj02 = (JJ0) C6401Nl0.i.get(c6401Nl0);
                        while (true) {
                            if (c6401Nl0.f0()) {
                                h();
                                break;
                            }
                            long andIncrement = C6401Nl0.e.getAndIncrement(c6401Nl0);
                            int i2 = AbstractC6661Ol0.b;
                            long j2 = andIncrement / i2;
                            int i3 = (int) (andIncrement % i2);
                            if (jj02.c != j2) {
                                JJ0 jj0Q = c6401Nl0.Q(j2, jj02);
                                if (jj0Q != null) {
                                    jj02 = jj0Q;
                                }
                            }
                            Object objR02 = c6401Nl0.R0(jj02, i3, andIncrement, this);
                            if (objR02 == AbstractC6661Ol0.m) {
                                c6401Nl0.x0(this, jj02, i3);
                                break;
                            }
                            if (objR02 == AbstractC6661Ol0.o) {
                                if (andIncrement < c6401Nl0.Y()) {
                                    jj02.b();
                                }
                            } else {
                                if (objR02 == AbstractC6661Ol0.n) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                jj02.b();
                                this.a = objR02;
                                this.b = null;
                                boolA = AbstractC6392Nk0.a(true);
                                UA2 ua2 = c6401Nl0.b;
                                if (ua2 != null) {
                                    ua2A = AbstractC16470lK4.a(ua2, objR02, ie0B.getContext());
                                }
                            }
                        }
                    } else {
                        jj0.b();
                        this.a = objR0;
                        this.b = null;
                        boolA = AbstractC6392Nk0.a(true);
                        UA2 ua22 = c6401Nl0.b;
                        if (ua22 != null) {
                            ua2A = AbstractC16470lK4.a(ua22, objR0, ie0B.getContext());
                        }
                    }
                    ie0B.N(boolA, ua2A);
                }
                Object objT = ie0B.t();
                if (objT == AbstractC14862ic3.e()) {
                    WA1.c(interfaceC20295rm1);
                }
                return objT;
            } catch (Throwable th) {
                ie0B.H();
                throw th;
            }
        }

        private final boolean g() throws Throwable {
            this.a = AbstractC6661Ol0.z();
            Throwable thU = C6401Nl0.this.U();
            if (thU == null) {
                return false;
            }
            throw FJ6.a(thU);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            IE0 ie0 = this.b;
            AbstractC13042fc3.f(ie0);
            this.b = null;
            this.a = AbstractC6661Ol0.z();
            Throwable thU = C6401Nl0.this.U();
            if (thU == null) {
                C9475a16.a aVar = C9475a16.b;
                ie0.resumeWith(C9475a16.b(Boolean.FALSE));
            } else {
                C9475a16.a aVar2 = C9475a16.b;
                ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(thU)));
            }
        }

        @Override // ir.nasim.CJ0
        public Object a(InterfaceC20295rm1 interfaceC20295rm1) {
            JJ0 jj0;
            C6401Nl0 c6401Nl0 = C6401Nl0.this;
            JJ0 jj02 = (JJ0) C6401Nl0.i.get(c6401Nl0);
            while (!c6401Nl0.f0()) {
                long andIncrement = C6401Nl0.e.getAndIncrement(c6401Nl0);
                int i = AbstractC6661Ol0.b;
                long j = andIncrement / i;
                int i2 = (int) (andIncrement % i);
                if (jj02.c != j) {
                    JJ0 jj0Q = c6401Nl0.Q(j, jj02);
                    if (jj0Q == null) {
                        continue;
                    } else {
                        jj0 = jj0Q;
                    }
                } else {
                    jj0 = jj02;
                }
                Object objR0 = c6401Nl0.R0(jj0, i2, andIncrement, null);
                if (objR0 == AbstractC6661Ol0.m) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (objR0 != AbstractC6661Ol0.o) {
                    if (objR0 == AbstractC6661Ol0.n) {
                        return f(jj0, i2, andIncrement, interfaceC20295rm1);
                    }
                    jj0.b();
                    this.a = objR0;
                    return AbstractC6392Nk0.a(true);
                }
                if (andIncrement < c6401Nl0.Y()) {
                    jj0.b();
                }
                jj02 = jj0;
            }
            return AbstractC6392Nk0.a(g());
        }

        @Override // ir.nasim.InterfaceC21726u18
        public void d(AbstractC23344wl6 abstractC23344wl6, int i) {
            IE0 ie0 = this.b;
            if (ie0 != null) {
                ie0.d(abstractC23344wl6, i);
            }
        }

        public final boolean i(Object obj) {
            IE0 ie0 = this.b;
            AbstractC13042fc3.f(ie0);
            this.b = null;
            this.a = obj;
            Boolean bool = Boolean.TRUE;
            UA2 ua2 = C6401Nl0.this.b;
            return AbstractC6661Ol0.B(ie0, bool, ua2 != null ? AbstractC16470lK4.a(ua2, obj, ie0.getContext()) : null);
        }

        public final void j() {
            IE0 ie0 = this.b;
            AbstractC13042fc3.f(ie0);
            this.b = null;
            this.a = AbstractC6661Ol0.z();
            Throwable thU = C6401Nl0.this.U();
            if (thU == null) {
                C9475a16.a aVar = C9475a16.b;
                ie0.resumeWith(C9475a16.b(Boolean.FALSE));
            } else {
                C9475a16.a aVar2 = C9475a16.b;
                ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(thU)));
            }
        }

        @Override // ir.nasim.CJ0
        public Object next() throws Throwable {
            Object obj = this.a;
            if (obj == AbstractC6661Ol0.p) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.a = AbstractC6661Ol0.p;
            if (obj != AbstractC6661Ol0.z()) {
                return obj;
            }
            throw FJ6.a(C6401Nl0.this.V());
        }
    }

    /* renamed from: ir.nasim.Nl0$b */
    /* synthetic */ class b extends EB2 implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
            super(3, C6401Nl0.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            y((C6401Nl0) obj, (InterfaceC16145km6) obj2, obj3);
            return C19938rB7.a;
        }

        public final void y(C6401Nl0 c6401Nl0, InterfaceC16145km6 interfaceC16145km6, Object obj) {
            c6401Nl0.F0(interfaceC16145km6, obj);
        }
    }

    /* renamed from: ir.nasim.Nl0$c */
    /* synthetic */ class c extends EB2 implements InterfaceC15796kB2 {
        public static final c a = new c();

        c() {
            super(3, C6401Nl0.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object q(C6401Nl0 c6401Nl0, Object obj, Object obj2) {
            return c6401Nl0.z0(obj, obj2);
        }
    }

    /* renamed from: ir.nasim.Nl0$d */
    /* synthetic */ class d extends EB2 implements InterfaceC15796kB2 {
        public static final d a = new d();

        d() {
            super(3, C6401Nl0.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            y((C6401Nl0) obj, (InterfaceC16145km6) obj2, obj3);
            return C19938rB7.a;
        }

        public final void y(C6401Nl0 c6401Nl0, InterfaceC16145km6 interfaceC16145km6, Object obj) {
            c6401Nl0.F0(interfaceC16145km6, obj);
        }
    }

    /* renamed from: ir.nasim.Nl0$e */
    /* synthetic */ class e extends EB2 implements InterfaceC15796kB2 {
        public static final e a = new e();

        e() {
            super(3, C6401Nl0.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final Object q(C6401Nl0 c6401Nl0, Object obj, Object obj2) {
            return c6401Nl0.A0(obj, obj2);
        }
    }

    /* renamed from: ir.nasim.Nl0$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC15796kB2 {

        /* renamed from: ir.nasim.Nl0$f$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ Object e;
            final /* synthetic */ C6401Nl0 f;
            final /* synthetic */ InterfaceC16145km6 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, C6401Nl0 c6401Nl0, InterfaceC16145km6 interfaceC16145km6) {
                super(1);
                this.e = obj;
                this.f = c6401Nl0;
                this.g = interfaceC16145km6;
            }

            public final void a(Throwable th) {
                if (this.e != AbstractC6661Ol0.z()) {
                    AbstractC16470lK4.b(this.f.b, this.e, this.g.getContext());
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        f() {
            super(3);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UA2 q(InterfaceC16145km6 interfaceC16145km6, Object obj, Object obj2) {
            return new a(obj2, C6401Nl0.this, interfaceC16145km6);
        }
    }

    /* renamed from: ir.nasim.Nl0$g */
    static final class g extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        g(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objC0 = C6401Nl0.C0(C6401Nl0.this, this);
            return objC0 == AbstractC14862ic3.e() ? objC0 : GJ0.b(objC0);
        }
    }

    /* renamed from: ir.nasim.Nl0$h */
    static final class h extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        long d;
        /* synthetic */ Object e;
        int g;

        h(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            Object objD0 = C6401Nl0.this.D0(null, 0, 0L, this);
            return objD0 == AbstractC14862ic3.e() ? objD0 : GJ0.b(objD0);
        }
    }

    public C6401Nl0(int i2, UA2 ua2) {
        this.a = i2;
        this.b = ua2;
        if (i2 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i2 + ", should be >=0").toString());
        }
        this.bufferEnd = AbstractC6661Ol0.A(i2);
        this.completedExpandBuffersAndPauseFlag = T();
        JJ0 jj0 = new JJ0(0L, null, this, 3);
        this.sendSegment = jj0;
        this.receiveSegment = jj0;
        if (j0()) {
            jj0 = AbstractC6661Ol0.a;
            AbstractC13042fc3.g(jj0, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = jj0;
        this.c = ua2 != null ? new f() : null;
        this._closeCause = AbstractC6661Ol0.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object A0(Object obj, Object obj2) {
        return GJ0.b(obj2 == AbstractC6661Ol0.z() ? GJ0.b.a(U()) : GJ0.b.c(obj2));
    }

    static /* synthetic */ Object B0(C6401Nl0 c6401Nl0, InterfaceC20295rm1 interfaceC20295rm1) throws Throwable {
        JJ0 jj0 = (JJ0) i.get(c6401Nl0);
        while (!c6401Nl0.f0()) {
            long andIncrement = e.getAndIncrement(c6401Nl0);
            int i2 = AbstractC6661Ol0.b;
            long j2 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (jj0.c != j2) {
                JJ0 jj0Q = c6401Nl0.Q(j2, jj0);
                if (jj0Q == null) {
                    continue;
                } else {
                    jj0 = jj0Q;
                }
            }
            Object objR0 = c6401Nl0.R0(jj0, i3, andIncrement, null);
            if (objR0 == AbstractC6661Ol0.m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objR0 != AbstractC6661Ol0.o) {
                if (objR0 == AbstractC6661Ol0.n) {
                    return c6401Nl0.E0(jj0, i3, andIncrement, interfaceC20295rm1);
                }
                jj0.b();
                return objR0;
            }
            if (andIncrement < c6401Nl0.Y()) {
                jj0.b();
            }
        }
        throw FJ6.a(c6401Nl0.V());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object C0(ir.nasim.C6401Nl0 r13, ir.nasim.InterfaceC20295rm1 r14) {
        /*
            boolean r0 = r14 instanceof ir.nasim.C6401Nl0.g
            if (r0 == 0) goto L14
            r0 = r14
            ir.nasim.Nl0$g r0 = (ir.nasim.C6401Nl0.g) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.Nl0$g r0 = new ir.nasim.Nl0$g
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L3a
            if (r1 != r2) goto L32
            ir.nasim.AbstractC10685c16.b(r14)
            ir.nasim.GJ0 r14 = (ir.nasim.GJ0) r14
            java.lang.Object r13 = r14.k()
            goto Lb2
        L32:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3a:
            ir.nasim.AbstractC10685c16.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = d()
            java.lang.Object r14 = r14.get(r13)
            ir.nasim.JJ0 r14 = (ir.nasim.JJ0) r14
        L47:
            boolean r1 = r13.f0()
            if (r1 == 0) goto L58
            ir.nasim.GJ0$b r14 = ir.nasim.GJ0.b
            java.lang.Throwable r13 = r13.U()
            java.lang.Object r13 = r14.a(r13)
            goto Lb2
        L58:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = e()
            long r4 = r1.getAndIncrement(r13)
            int r1 = ir.nasim.AbstractC6661Ol0.b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            ir.nasim.JJ0 r1 = a(r13, r7, r14)
            if (r1 != 0) goto L76
            goto L47
        L76:
            r14 = r1
        L77:
            r12 = 0
            r7 = r13
            r8 = r14
            r9 = r3
            r10 = r4
            java.lang.Object r1 = D(r7, r8, r9, r10, r12)
            ir.nasim.i47 r7 = ir.nasim.AbstractC6661Ol0.r()
            if (r1 == r7) goto Lb3
            ir.nasim.i47 r7 = ir.nasim.AbstractC6661Ol0.h()
            if (r1 != r7) goto L98
            long r7 = r13.Y()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L47
            r14.b()
            goto L47
        L98:
            ir.nasim.i47 r7 = ir.nasim.AbstractC6661Ol0.s()
            if (r1 != r7) goto La9
            r6.c = r2
            r1 = r13
            r2 = r14
            java.lang.Object r13 = r1.D0(r2, r3, r4, r6)
            if (r13 != r0) goto Lb2
            return r0
        La9:
            r14.b()
            ir.nasim.GJ0$b r13 = ir.nasim.GJ0.b
            java.lang.Object r13 = r13.c(r1)
        Lb2:
            return r13
        Lb3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.C0(ir.nasim.Nl0, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D0(ir.nasim.JJ0 r11, int r12, long r13, ir.nasim.InterfaceC20295rm1 r15) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.D0(ir.nasim.JJ0, int, long, ir.nasim.rm1):java.lang.Object");
    }

    private final Object E0(JJ0 jj0, int i2, long j2, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0B = KE0.b(AbstractC14251hc3.c(interfaceC20295rm1));
        try {
            Object objR0 = R0(jj0, i2, j2, ie0B);
            if (objR0 == AbstractC6661Ol0.m) {
                x0(ie0B, jj0, i2);
            } else {
                UA2 ua2A = null;
                ua2A = null;
                if (objR0 == AbstractC6661Ol0.o) {
                    if (j2 < Y()) {
                        jj0.b();
                    }
                    JJ0 jj02 = (JJ0) i.get(this);
                    while (true) {
                        if (f0()) {
                            r0(ie0B);
                            break;
                        }
                        long andIncrement = e.getAndIncrement(this);
                        int i3 = AbstractC6661Ol0.b;
                        long j3 = andIncrement / i3;
                        int i4 = (int) (andIncrement % i3);
                        if (jj02.c != j3) {
                            JJ0 jj0Q = Q(j3, jj02);
                            if (jj0Q != null) {
                                jj02 = jj0Q;
                            }
                        }
                        objR0 = R0(jj02, i4, andIncrement, ie0B);
                        if (objR0 == AbstractC6661Ol0.m) {
                            IE0 ie0 = ie0B instanceof InterfaceC21726u18 ? ie0B : null;
                            if (ie0 != null) {
                                x0(ie0, jj02, i4);
                            }
                        } else if (objR0 == AbstractC6661Ol0.o) {
                            if (andIncrement < Y()) {
                                jj02.b();
                            }
                        } else {
                            if (objR0 == AbstractC6661Ol0.n) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            jj02.b();
                            UA2 ua2 = this.b;
                            if (ua2 != null) {
                                ua2A = AbstractC16470lK4.a(ua2, objR0, ie0B.getContext());
                            }
                        }
                    }
                } else {
                    jj0.b();
                    UA2 ua22 = this.b;
                    if (ua22 != null) {
                        ua2A = AbstractC16470lK4.a(ua22, objR0, ie0B.getContext());
                    }
                }
                ie0B.N(objR0, ua2A);
            }
            Object objT = ie0B.t();
            if (objT == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objT;
        } catch (Throwable th) {
            ie0B.H();
            throw th;
        }
    }

    private final boolean F(long j2) {
        return j2 < T() || j2 < W() + ((long) this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(InterfaceC16145km6 interfaceC16145km6, Object obj) {
        JJ0 jj0 = (JJ0) i.get(this);
        while (!f0()) {
            long andIncrement = e.getAndIncrement(this);
            int i2 = AbstractC6661Ol0.b;
            long j2 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (jj0.c != j2) {
                JJ0 jj0Q = Q(j2, jj0);
                if (jj0Q == null) {
                    continue;
                } else {
                    jj0 = jj0Q;
                }
            }
            Object objR0 = R0(jj0, i3, andIncrement, interfaceC16145km6);
            if (objR0 == AbstractC6661Ol0.m) {
                InterfaceC21726u18 interfaceC21726u18 = interfaceC16145km6 instanceof InterfaceC21726u18 ? (InterfaceC21726u18) interfaceC16145km6 : null;
                if (interfaceC21726u18 != null) {
                    x0(interfaceC21726u18, jj0, i3);
                    return;
                }
                return;
            }
            if (objR0 != AbstractC6661Ol0.o) {
                if (objR0 == AbstractC6661Ol0.n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                jj0.b();
                interfaceC16145km6.b(objR0);
                return;
            }
            if (andIncrement < Y()) {
                jj0.b();
            }
        }
        s0(interfaceC16145km6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (ir.nasim.JJ0) r12.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void G0(ir.nasim.JJ0 r12) {
        /*
            r11 = this;
            ir.nasim.UA2 r0 = r11.b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = ir.nasim.X73.b(r1, r2, r1)
        L8:
            int r4 = ir.nasim.AbstractC6661Ol0.b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.c
            int r8 = ir.nasim.AbstractC6661Ol0.b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.w(r4)
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.f()
            if (r8 == r9) goto Lbb
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.d
            if (r8 != r9) goto L48
            long r9 = r11.W()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = ir.nasim.AbstractC16470lK4.c(r0, r5, r1)
        L40:
            r12.s(r4)
            r12.p()
            goto Laf
        L48:
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof ir.nasim.InterfaceC21726u18
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof ir.nasim.C22316v18
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.p()
            if (r8 == r9) goto Lbb
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.q()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.W()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof ir.nasim.C22316v18
            if (r9 == 0) goto L80
            r9 = r8
            ir.nasim.v18 r9 = (ir.nasim.C22316v18) r9
            ir.nasim.u18 r9 = r9.a
            goto L83
        L80:
            r9 = r8
            ir.nasim.u18 r9 = (ir.nasim.InterfaceC21726u18) r9
        L83:
            ir.nasim.i47 r10 = ir.nasim.AbstractC6661Ol0.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = ir.nasim.AbstractC16470lK4.c(r0, r5, r1)
        L97:
            java.lang.Object r3 = ir.nasim.X73.c(r3, r9)
            r12.s(r4)
            r12.p()
            goto Laf
        La2:
            ir.nasim.i47 r9 = ir.nasim.AbstractC6661Ol0.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.p()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            ir.nasim.Cc1 r12 = r12.g()
            ir.nasim.JJ0 r12 = (ir.nasim.JJ0) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            ir.nasim.u18 r3 = (ir.nasim.InterfaceC21726u18) r3
            r11.I0(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            ir.nasim.AbstractC13042fc3.g(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            ir.nasim.u18 r0 = (ir.nasim.InterfaceC21726u18) r0
            r11.I0(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.G0(ir.nasim.JJ0):void");
    }

    private final void H(JJ0 jj0, long j2) {
        Object objB = X73.b(null, 1, null);
        loop0: while (jj0 != null) {
            for (int i2 = AbstractC6661Ol0.b - 1; -1 < i2; i2--) {
                if ((jj0.c * AbstractC6661Ol0.b) + i2 < j2) {
                    break loop0;
                }
                while (true) {
                    Object objW = jj0.w(i2);
                    if (objW != null && objW != AbstractC6661Ol0.e) {
                        if (!(objW instanceof C22316v18)) {
                            if (!(objW instanceof InterfaceC21726u18)) {
                                break;
                            }
                            if (jj0.r(i2, objW, AbstractC6661Ol0.z())) {
                                objB = X73.c(objB, objW);
                                jj0.x(i2, true);
                                break;
                            }
                        } else {
                            if (jj0.r(i2, objW, AbstractC6661Ol0.z())) {
                                objB = X73.c(objB, ((C22316v18) objW).a);
                                jj0.x(i2, true);
                                break;
                            }
                        }
                    } else {
                        if (jj0.r(i2, objW, AbstractC6661Ol0.z())) {
                            jj0.p();
                            break;
                        }
                    }
                }
            }
            jj0 = (JJ0) jj0.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                H0((InterfaceC21726u18) objB);
                return;
            }
            AbstractC13042fc3.g(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                H0((InterfaceC21726u18) arrayList.get(size));
            }
        }
    }

    private final void H0(InterfaceC21726u18 interfaceC21726u18) {
        J0(interfaceC21726u18, true);
    }

    private final JJ0 I() {
        Object obj = j.get(this);
        JJ0 jj0 = (JJ0) h.get(this);
        if (jj0.c > ((JJ0) obj).c) {
            obj = jj0;
        }
        JJ0 jj02 = (JJ0) i.get(this);
        if (jj02.c > ((JJ0) obj).c) {
            obj = jj02;
        }
        return (JJ0) AbstractC3494Bc1.b((AbstractC3728Cc1) obj);
    }

    private final void I0(InterfaceC21726u18 interfaceC21726u18) {
        J0(interfaceC21726u18, false);
    }

    private final void J0(InterfaceC21726u18 interfaceC21726u18, boolean z) {
        if (interfaceC21726u18 instanceof HE0) {
            InterfaceC20295rm1 interfaceC20295rm1 = (InterfaceC20295rm1) interfaceC21726u18;
            C9475a16.a aVar = C9475a16.b;
            interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(z ? V() : X())));
        } else if (interfaceC21726u18 instanceof UI5) {
            IE0 ie0 = ((UI5) interfaceC21726u18).a;
            C9475a16.a aVar2 = C9475a16.b;
            ie0.resumeWith(C9475a16.b(GJ0.b(GJ0.b.a(U()))));
        } else if (interfaceC21726u18 instanceof a) {
            ((a) interfaceC21726u18).j();
        } else {
            if (interfaceC21726u18 instanceof InterfaceC16145km6) {
                ((InterfaceC16145km6) interfaceC21726u18).f(this, AbstractC6661Ol0.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + interfaceC21726u18).toString());
        }
    }

    private final void K(long j2) {
        G0(L(j2));
    }

    static /* synthetic */ Object K0(C6401Nl0 c6401Nl0, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        JJ0 jj0 = (JJ0) h.get(c6401Nl0);
        while (true) {
            long andIncrement = d.getAndIncrement(c6401Nl0);
            long j2 = 1152921504606846975L & andIncrement;
            boolean zH0 = c6401Nl0.h0(andIncrement);
            int i2 = AbstractC6661Ol0.b;
            long j3 = j2 / i2;
            int i3 = (int) (j2 % i2);
            if (jj0.c != j3) {
                JJ0 jj0R = c6401Nl0.R(j3, jj0);
                if (jj0R != null) {
                    jj0 = jj0R;
                } else if (zH0) {
                    Object objT0 = c6401Nl0.t0(obj, interfaceC20295rm1);
                    if (objT0 == AbstractC14862ic3.e()) {
                        return objT0;
                    }
                }
            }
            int iT0 = c6401Nl0.T0(jj0, i3, obj, j2, null, zH0);
            if (iT0 == 0) {
                jj0.b();
                break;
            }
            if (iT0 == 1) {
                break;
            }
            if (iT0 != 2) {
                if (iT0 == 3) {
                    Object objL0 = c6401Nl0.L0(jj0, i3, obj, j2, interfaceC20295rm1);
                    if (objL0 == AbstractC14862ic3.e()) {
                        return objL0;
                    }
                } else if (iT0 == 4) {
                    if (j2 < c6401Nl0.W()) {
                        jj0.b();
                    }
                    Object objT02 = c6401Nl0.t0(obj, interfaceC20295rm1);
                    if (objT02 == AbstractC14862ic3.e()) {
                        return objT02;
                    }
                } else if (iT0 == 5) {
                    jj0.b();
                }
            } else if (zH0) {
                jj0.p();
                Object objT03 = c6401Nl0.t0(obj, interfaceC20295rm1);
                if (objT03 == AbstractC14862ic3.e()) {
                    return objT03;
                }
            }
        }
        return C19938rB7.a;
    }

    private final JJ0 L(long j2) {
        JJ0 jj0I = I();
        if (i0()) {
            long jK0 = k0(jj0I);
            if (jK0 != -1) {
                N(jK0);
            }
        }
        H(jj0I, j2);
        return jj0I;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object L0(ir.nasim.JJ0 r21, int r22, java.lang.Object r23, long r24, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.L0(ir.nasim.JJ0, int, java.lang.Object, long, ir.nasim.rm1):java.lang.Object");
    }

    private final void M() {
        A();
    }

    private final boolean M0(long j2) {
        if (h0(j2)) {
            return false;
        }
        return !F(j2 & 1152921504606846975L);
    }

    private final boolean N0(Object obj, Object obj2) {
        if (obj instanceof InterfaceC16145km6) {
            return ((InterfaceC16145km6) obj).f(this, obj2);
        }
        if (obj instanceof UI5) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            UI5 ui5 = (UI5) obj;
            IE0 ie0 = ui5.a;
            GJ0 gj0B = GJ0.b(GJ0.b.c(obj2));
            UA2 ua2 = this.b;
            return AbstractC6661Ol0.B(ie0, gj0B, ua2 != null ? AbstractC16470lK4.a(ua2, obj2, ui5.a.getContext()) : null);
        }
        if (obj instanceof a) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        }
        if (obj instanceof HE0) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            HE0 he0 = (HE0) obj;
            UA2 ua22 = this.b;
            return AbstractC6661Ol0.B(he0, obj2, ua22 != null ? AbstractC16470lK4.a(ua22, obj2, he0.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final void O() {
        if (j0()) {
            return;
        }
        JJ0 jj0 = (JJ0) j.get(this);
        while (true) {
            long andIncrement = f.getAndIncrement(this);
            int i2 = AbstractC6661Ol0.b;
            long j2 = andIncrement / i2;
            if (Y() <= andIncrement) {
                if (jj0.c < j2 && jj0.e() != null) {
                    o0(j2, jj0);
                }
                b0(this, 0L, 1, null);
                return;
            }
            if (jj0.c != j2) {
                JJ0 jj0P = P(j2, jj0, andIncrement);
                if (jj0P == null) {
                    continue;
                } else {
                    jj0 = jj0P;
                }
            }
            if (P0(jj0, (int) (andIncrement % i2), andIncrement)) {
                b0(this, 0L, 1, null);
                return;
            }
            b0(this, 0L, 1, null);
        }
    }

    private final boolean O0(Object obj, JJ0 jj0, int i2) {
        if (obj instanceof HE0) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return AbstractC6661Ol0.C((HE0) obj, C19938rB7.a, null, 2, null);
        }
        if (!(obj instanceof InterfaceC16145km6)) {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        EnumC19201pw7 enumC19201pw7F = ((C15554jm6) obj).F(this, C19938rB7.a);
        if (enumC19201pw7F == EnumC19201pw7.REREGISTER) {
            jj0.s(i2);
        }
        return enumC19201pw7F == EnumC19201pw7.SUCCESSFUL;
    }

    private final JJ0 P(long j2, JJ0 jj0, long j3) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) AbstractC6661Ol0.y();
        loop0: while (true) {
            objC = AbstractC3494Bc1.c(jj0, j2, interfaceC14603iB2);
            if (!AbstractC3341Al6.c(objC)) {
                AbstractC23344wl6 abstractC23344wl6B = AbstractC3341Al6.b(objC);
                while (true) {
                    AbstractC23344wl6 abstractC23344wl6 = (AbstractC23344wl6) atomicReferenceFieldUpdater.get(this);
                    if (abstractC23344wl6.c >= abstractC23344wl6B.c) {
                        break loop0;
                    }
                    if (!abstractC23344wl6B.q()) {
                        break;
                    }
                    if (F1.a(atomicReferenceFieldUpdater, this, abstractC23344wl6, abstractC23344wl6B)) {
                        if (abstractC23344wl6.m()) {
                            abstractC23344wl6.k();
                        }
                    } else if (abstractC23344wl6B.m()) {
                        abstractC23344wl6B.k();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC3341Al6.c(objC)) {
            M();
            o0(j2, jj0);
            b0(this, 0L, 1, null);
            return null;
        }
        JJ0 jj02 = (JJ0) AbstractC3341Al6.b(objC);
        long j4 = jj02.c;
        if (j4 <= j2) {
            return jj02;
        }
        int i2 = AbstractC6661Ol0.b;
        if (f.compareAndSet(this, j3 + 1, i2 * j4)) {
            a0((jj02.c * i2) - j3);
            return null;
        }
        b0(this, 0L, 1, null);
        return null;
    }

    private final boolean P0(JJ0 jj0, int i2, long j2) {
        Object objW = jj0.w(i2);
        if (!(objW instanceof InterfaceC21726u18) || j2 < e.get(this) || !jj0.r(i2, objW, AbstractC6661Ol0.g)) {
            return Q0(jj0, i2, j2);
        }
        if (O0(objW, jj0, i2)) {
            jj0.A(i2, AbstractC6661Ol0.d);
            return true;
        }
        jj0.A(i2, AbstractC6661Ol0.j);
        jj0.x(i2, false);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JJ0 Q(long j2, JJ0 jj0) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
        InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) AbstractC6661Ol0.y();
        loop0: while (true) {
            objC = AbstractC3494Bc1.c(jj0, j2, interfaceC14603iB2);
            if (!AbstractC3341Al6.c(objC)) {
                AbstractC23344wl6 abstractC23344wl6B = AbstractC3341Al6.b(objC);
                while (true) {
                    AbstractC23344wl6 abstractC23344wl6 = (AbstractC23344wl6) atomicReferenceFieldUpdater.get(this);
                    if (abstractC23344wl6.c >= abstractC23344wl6B.c) {
                        break loop0;
                    }
                    if (!abstractC23344wl6B.q()) {
                        break;
                    }
                    if (F1.a(atomicReferenceFieldUpdater, this, abstractC23344wl6, abstractC23344wl6B)) {
                        if (abstractC23344wl6.m()) {
                            abstractC23344wl6.k();
                        }
                    } else if (abstractC23344wl6B.m()) {
                        abstractC23344wl6B.k();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC3341Al6.c(objC)) {
            M();
            if (jj0.c * AbstractC6661Ol0.b >= Y()) {
                return null;
            }
            jj0.b();
            return null;
        }
        JJ0 jj02 = (JJ0) AbstractC3341Al6.b(objC);
        if (!j0() && j2 <= T() / AbstractC6661Ol0.b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = j;
            while (true) {
                AbstractC23344wl6 abstractC23344wl62 = (AbstractC23344wl6) atomicReferenceFieldUpdater2.get(this);
                if (abstractC23344wl62.c >= jj02.c || !jj02.q()) {
                    break;
                }
                if (F1.a(atomicReferenceFieldUpdater2, this, abstractC23344wl62, jj02)) {
                    if (abstractC23344wl62.m()) {
                        abstractC23344wl62.k();
                    }
                } else if (jj02.m()) {
                    jj02.k();
                }
            }
        }
        long j3 = jj02.c;
        if (j3 <= j2) {
            return jj02;
        }
        int i2 = AbstractC6661Ol0.b;
        V0(j3 * i2);
        if (jj02.c * i2 >= Y()) {
            return null;
        }
        jj02.b();
        return null;
    }

    private final boolean Q0(JJ0 jj0, int i2, long j2) {
        while (true) {
            Object objW = jj0.w(i2);
            if (objW instanceof InterfaceC21726u18) {
                if (j2 < e.get(this)) {
                    if (jj0.r(i2, objW, new C22316v18((InterfaceC21726u18) objW))) {
                        return true;
                    }
                } else if (jj0.r(i2, objW, AbstractC6661Ol0.g)) {
                    if (O0(objW, jj0, i2)) {
                        jj0.A(i2, AbstractC6661Ol0.d);
                        return true;
                    }
                    jj0.A(i2, AbstractC6661Ol0.j);
                    jj0.x(i2, false);
                    return false;
                }
            } else {
                if (objW == AbstractC6661Ol0.j) {
                    return false;
                }
                if (objW == null) {
                    if (jj0.r(i2, objW, AbstractC6661Ol0.e)) {
                        return true;
                    }
                } else {
                    if (objW == AbstractC6661Ol0.d || objW == AbstractC6661Ol0.h || objW == AbstractC6661Ol0.i || objW == AbstractC6661Ol0.k || objW == AbstractC6661Ol0.z()) {
                        return true;
                    }
                    if (objW != AbstractC6661Ol0.f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objW).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JJ0 R(long j2, JJ0 jj0) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) AbstractC6661Ol0.y();
        loop0: while (true) {
            objC = AbstractC3494Bc1.c(jj0, j2, interfaceC14603iB2);
            if (!AbstractC3341Al6.c(objC)) {
                AbstractC23344wl6 abstractC23344wl6B = AbstractC3341Al6.b(objC);
                while (true) {
                    AbstractC23344wl6 abstractC23344wl6 = (AbstractC23344wl6) atomicReferenceFieldUpdater.get(this);
                    if (abstractC23344wl6.c >= abstractC23344wl6B.c) {
                        break loop0;
                    }
                    if (!abstractC23344wl6B.q()) {
                        break;
                    }
                    if (F1.a(atomicReferenceFieldUpdater, this, abstractC23344wl6, abstractC23344wl6B)) {
                        if (abstractC23344wl6.m()) {
                            abstractC23344wl6.k();
                        }
                    } else if (abstractC23344wl6B.m()) {
                        abstractC23344wl6B.k();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC3341Al6.c(objC)) {
            M();
            if (jj0.c * AbstractC6661Ol0.b >= W()) {
                return null;
            }
            jj0.b();
            return null;
        }
        JJ0 jj02 = (JJ0) AbstractC3341Al6.b(objC);
        long j3 = jj02.c;
        if (j3 <= j2) {
            return jj02;
        }
        int i2 = AbstractC6661Ol0.b;
        W0(j3 * i2);
        if (jj02.c * i2 >= W()) {
            return null;
        }
        jj02.b();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object R0(JJ0 jj0, int i2, long j2, Object obj) {
        Object objW = jj0.w(i2);
        if (objW == null) {
            if (j2 >= (d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return AbstractC6661Ol0.n;
                }
                if (jj0.r(i2, objW, obj)) {
                    O();
                    return AbstractC6661Ol0.m;
                }
            }
        } else if (objW == AbstractC6661Ol0.d && jj0.r(i2, objW, AbstractC6661Ol0.i)) {
            O();
            return jj0.y(i2);
        }
        return S0(jj0, i2, j2, obj);
    }

    private final Object S0(JJ0 jj0, int i2, long j2, Object obj) {
        while (true) {
            Object objW = jj0.w(i2);
            if (objW == null || objW == AbstractC6661Ol0.e) {
                if (j2 < (d.get(this) & 1152921504606846975L)) {
                    if (jj0.r(i2, objW, AbstractC6661Ol0.h)) {
                        O();
                        return AbstractC6661Ol0.o;
                    }
                } else {
                    if (obj == null) {
                        return AbstractC6661Ol0.n;
                    }
                    if (jj0.r(i2, objW, obj)) {
                        O();
                        return AbstractC6661Ol0.m;
                    }
                }
            } else {
                if (objW != AbstractC6661Ol0.d) {
                    if (objW != AbstractC6661Ol0.j && objW != AbstractC6661Ol0.h) {
                        if (objW == AbstractC6661Ol0.z()) {
                            O();
                            return AbstractC6661Ol0.o;
                        }
                        if (objW != AbstractC6661Ol0.g && jj0.r(i2, objW, AbstractC6661Ol0.f)) {
                            boolean z = objW instanceof C22316v18;
                            if (z) {
                                objW = ((C22316v18) objW).a;
                            }
                            if (O0(objW, jj0, i2)) {
                                jj0.A(i2, AbstractC6661Ol0.i);
                                O();
                                return jj0.y(i2);
                            }
                            jj0.A(i2, AbstractC6661Ol0.j);
                            jj0.x(i2, false);
                            if (z) {
                                O();
                            }
                            return AbstractC6661Ol0.o;
                        }
                    }
                    return AbstractC6661Ol0.o;
                }
                if (jj0.r(i2, objW, AbstractC6661Ol0.i)) {
                    O();
                    return jj0.y(i2);
                }
            }
        }
    }

    private final long T() {
        return f.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T0(JJ0 jj0, int i2, Object obj, long j2, Object obj2, boolean z) {
        jj0.B(i2, obj);
        if (z) {
            return U0(jj0, i2, obj, j2, obj2, z);
        }
        Object objW = jj0.w(i2);
        if (objW == null) {
            if (F(j2)) {
                if (jj0.r(i2, null, AbstractC6661Ol0.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (jj0.r(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objW instanceof InterfaceC21726u18) {
            jj0.s(i2);
            if (N0(objW, obj)) {
                jj0.A(i2, AbstractC6661Ol0.i);
                v0();
                return 0;
            }
            if (jj0.t(i2, AbstractC6661Ol0.k) != AbstractC6661Ol0.k) {
                jj0.x(i2, true);
            }
            return 5;
        }
        return U0(jj0, i2, obj, j2, obj2, z);
    }

    private final int U0(JJ0 jj0, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object objW = jj0.w(i2);
            if (objW == null) {
                if (!F(j2) || z) {
                    if (z) {
                        if (jj0.r(i2, null, AbstractC6661Ol0.j)) {
                            jj0.x(i2, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (jj0.r(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (jj0.r(i2, null, AbstractC6661Ol0.d)) {
                    return 1;
                }
            } else {
                if (objW != AbstractC6661Ol0.e) {
                    if (objW == AbstractC6661Ol0.k) {
                        jj0.s(i2);
                        return 5;
                    }
                    if (objW == AbstractC6661Ol0.h) {
                        jj0.s(i2);
                        return 5;
                    }
                    if (objW == AbstractC6661Ol0.z()) {
                        jj0.s(i2);
                        M();
                        return 4;
                    }
                    jj0.s(i2);
                    if (objW instanceof C22316v18) {
                        objW = ((C22316v18) objW).a;
                    }
                    if (N0(objW, obj)) {
                        jj0.A(i2, AbstractC6661Ol0.i);
                        v0();
                        return 0;
                    }
                    if (jj0.t(i2, AbstractC6661Ol0.k) != AbstractC6661Ol0.k) {
                        jj0.x(i2, true);
                    }
                    return 5;
                }
                if (jj0.r(i2, objW, AbstractC6661Ol0.d)) {
                    return 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable V() {
        Throwable thU = U();
        return thU == null ? new ClosedReceiveChannelException("Channel was closed") : thU;
    }

    private final void V0(long j2) {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j2) {
                return;
            }
        } while (!e.compareAndSet(this, j3, j2));
    }

    private final void W0(long j2) {
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            j4 = 1152921504606846975L & j3;
            if (j4 >= j2) {
                return;
            }
        } while (!d.compareAndSet(this, j3, AbstractC6661Ol0.w(j4, (int) (j3 >> 60))));
    }

    private final void a0(long j2) {
        if ((g.addAndGet(this, j2) & 4611686018427387904L) != 0) {
            while ((g.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    static /* synthetic */ void b0(C6401Nl0 c6401Nl0, long j2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i2 & 1) != 0) {
            j2 = 1;
        }
        c6401Nl0.a0(j2);
    }

    private final void c0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!F1.a(atomicReferenceFieldUpdater, this, obj, obj == null ? AbstractC6661Ol0.q : AbstractC6661Ol0.r));
        if (obj == null) {
            return;
        }
        ((UA2) obj).invoke(U());
    }

    private final boolean d0(JJ0 jj0, int i2, long j2) {
        Object objW;
        do {
            objW = jj0.w(i2);
            if (objW != null && objW != AbstractC6661Ol0.e) {
                if (objW == AbstractC6661Ol0.d) {
                    return true;
                }
                if (objW == AbstractC6661Ol0.j || objW == AbstractC6661Ol0.z() || objW == AbstractC6661Ol0.i || objW == AbstractC6661Ol0.h) {
                    return false;
                }
                if (objW == AbstractC6661Ol0.g) {
                    return true;
                }
                return objW != AbstractC6661Ol0.f && j2 == W();
            }
        } while (!jj0.r(i2, objW, AbstractC6661Ol0.h));
        O();
        return false;
    }

    private final boolean e0(long j2, boolean z) {
        int i2 = (int) (j2 >> 60);
        if (i2 == 0 || i2 == 1) {
            return false;
        }
        if (i2 == 2) {
            L(j2 & 1152921504606846975L);
            if (z && Z()) {
                return false;
            }
        } else {
            if (i2 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i2).toString());
            }
            K(j2 & 1152921504606846975L);
        }
        return true;
    }

    private final boolean g0(long j2) {
        return e0(j2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h0(long j2) {
        return e0(j2, false);
    }

    private final boolean j0() {
        long jT = T();
        return jT == 0 || jT == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (ir.nasim.JJ0) r8.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long k0(ir.nasim.JJ0 r8) {
        /*
            r7 = this;
        L0:
            int r0 = ir.nasim.AbstractC6661Ol0.b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.c
            int r5 = ir.nasim.AbstractC6661Ol0.b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.W()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.w(r0)
            if (r1 == 0) goto L2c
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.d
            if (r1 != r2) goto L39
            return r3
        L2c:
            ir.nasim.i47 r2 = ir.nasim.AbstractC6661Ol0.z()
            boolean r1 = r8.r(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.p()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            ir.nasim.Cc1 r8 = r8.g()
            ir.nasim.JJ0 r8 = (ir.nasim.JJ0) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.k0(ir.nasim.JJ0):long");
    }

    private final void l0() {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (((int) (j2 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, AbstractC6661Ol0.w(1152921504606846975L & j2, 1)));
    }

    private final void m0() {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, AbstractC6661Ol0.w(1152921504606846975L & j2, 3)));
    }

    private final void n0() {
        long j2;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = d;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            int i2 = (int) (j2 >> 60);
            if (i2 == 0) {
                jW = AbstractC6661Ol0.w(j2 & 1152921504606846975L, 2);
            } else if (i2 != 1) {
                return;
            } else {
                jW = AbstractC6661Ol0.w(j2 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, jW));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void o0(long r5, ir.nasim.JJ0 r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            ir.nasim.Cc1 r0 = r7.e()
            ir.nasim.JJ0 r0 = (ir.nasim.JJ0) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.h()
            if (r5 == 0) goto L22
            ir.nasim.Cc1 r5 = r7.e()
            ir.nasim.JJ0 r5 = (ir.nasim.JJ0) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = ir.nasim.C6401Nl0.j
        L24:
            java.lang.Object r6 = r5.get(r4)
            ir.nasim.wl6 r6 = (ir.nasim.AbstractC23344wl6) r6
            long r0 = r6.c
            long r2 = r7.c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.q()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = ir.nasim.F1.a(r5, r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.m()
            if (r5 == 0) goto L49
            r6.k()
        L49:
            return
        L4a:
            boolean r6 = r7.m()
            if (r6 == 0) goto L24
            r7.k()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.o0(long, ir.nasim.JJ0):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(HE0 he0) {
        C9475a16.a aVar = C9475a16.b;
        he0.resumeWith(C9475a16.b(GJ0.b(GJ0.b.a(U()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(HE0 he0) {
        C9475a16.a aVar = C9475a16.b;
        he0.resumeWith(C9475a16.b(AbstractC10685c16.a(V())));
    }

    private final void s0(InterfaceC16145km6 interfaceC16145km6) {
        interfaceC16145km6.b(AbstractC6661Ol0.z());
    }

    private final Object t0(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        UndeliveredElementException undeliveredElementExceptionD;
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        UA2 ua2 = this.b;
        if (ua2 == null || (undeliveredElementExceptionD = AbstractC16470lK4.d(ua2, obj, null, 2, null)) == null) {
            Throwable thX = X();
            C9475a16.a aVar = C9475a16.b;
            ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(thX)));
        } else {
            AbstractC16632lc2.a(undeliveredElementExceptionD, X());
            C9475a16.a aVar2 = C9475a16.b;
            ie0.resumeWith(C9475a16.b(AbstractC10685c16.a(undeliveredElementExceptionD)));
        }
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT == AbstractC14862ic3.e() ? objT : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0(Object obj, HE0 he0) {
        UA2 ua2 = this.b;
        if (ua2 != null) {
            AbstractC16470lK4.b(ua2, obj, he0.getContext());
        }
        Throwable thX = X();
        C9475a16.a aVar = C9475a16.b;
        he0.resumeWith(C9475a16.b(AbstractC10685c16.a(thX)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(InterfaceC21726u18 interfaceC21726u18, JJ0 jj0, int i2) {
        w0();
        interfaceC21726u18.d(jj0, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(InterfaceC21726u18 interfaceC21726u18, JJ0 jj0, int i2) {
        interfaceC21726u18.d(jj0, i2 + AbstractC6661Ol0.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object z0(Object obj, Object obj2) throws Throwable {
        if (obj2 != AbstractC6661Ol0.z()) {
            return obj2;
        }
        throw V();
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public boolean A() {
        return h0(d.get(this));
    }

    public boolean G(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return J(th, true);
    }

    protected boolean J(Throwable th, boolean z) {
        if (z) {
            l0();
        }
        boolean zA = F1.a(k, this, AbstractC6661Ol0.s, th);
        if (z) {
            m0();
        } else {
            n0();
        }
        M();
        p0();
        if (zA) {
            c0();
        }
        return zA;
    }

    protected final void N(long j2) {
        UndeliveredElementException undeliveredElementExceptionD;
        JJ0 jj0 = (JJ0) i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = e;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.a + j3, T())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, j3 + 1)) {
                int i2 = AbstractC6661Ol0.b;
                long j4 = j3 / i2;
                int i3 = (int) (j3 % i2);
                if (jj0.c != j4) {
                    JJ0 jj0Q = Q(j4, jj0);
                    if (jj0Q == null) {
                        continue;
                    } else {
                        jj0 = jj0Q;
                    }
                }
                Object objR0 = R0(jj0, i3, j3, null);
                if (objR0 != AbstractC6661Ol0.o) {
                    jj0.b();
                    UA2 ua2 = this.b;
                    if (ua2 != null && (undeliveredElementExceptionD = AbstractC16470lK4.d(ua2, objR0, null, 2, null)) != null) {
                        throw undeliveredElementExceptionD;
                    }
                } else if (j3 < Y()) {
                    jj0.b();
                }
            }
        }
    }

    protected final Throwable U() {
        return (Throwable) k.get(this);
    }

    public final long W() {
        return e.get(this);
    }

    protected final Throwable X() {
        Throwable thU = U();
        return thU == null ? new ClosedSendChannelException("Channel was closed") : thU;
    }

    public final void X0(long j2) {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        if (j0()) {
            return;
        }
        while (T() <= j2) {
        }
        int i2 = AbstractC6661Ol0.c;
        for (int i3 = 0; i3 < i2; i3++) {
            long jT = T();
            if (jT == (4611686018427387903L & g.get(this)) && jT == T()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = g;
        do {
            j3 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j3, AbstractC6661Ol0.v(j3 & 4611686018427387903L, true)));
        while (true) {
            long jT2 = T();
            atomicLongFieldUpdater = g;
            long j5 = atomicLongFieldUpdater.get(this);
            long j6 = j5 & 4611686018427387903L;
            boolean z = (4611686018427387904L & j5) != 0;
            if (jT2 == j6 && jT2 == T()) {
                break;
            } else if (!z) {
                atomicLongFieldUpdater.compareAndSet(this, j5, AbstractC6661Ol0.v(j6, true));
            }
        }
        do {
            j4 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, AbstractC6661Ol0.v(j4 & 4611686018427387903L, false)));
    }

    public final long Y() {
        return d.get(this) & 1152921504606846975L;
    }

    public final boolean Z() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = i;
            JJ0 jj0Q = (JJ0) atomicReferenceFieldUpdater.get(this);
            long jW = W();
            if (Y() <= jW) {
                return false;
            }
            int i2 = AbstractC6661Ol0.b;
            long j2 = jW / i2;
            if (jj0Q.c == j2 || (jj0Q = Q(j2, jj0Q)) != null) {
                jj0Q.b();
                if (d0(jj0Q, (int) (jW % i2), jW)) {
                    return true;
                }
                e.compareAndSet(this, jW, jW + 1);
            } else if (((JJ0) atomicReferenceFieldUpdater.get(this)).c < j2) {
                return false;
            }
        }
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public void f(UA2 ua2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
        if (F1.a(atomicReferenceFieldUpdater, this, null, ua2)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != AbstractC6661Ol0.q) {
                if (obj == AbstractC6661Ol0.r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!F1.a(l, this, AbstractC6661Ol0.q, AbstractC6661Ol0.r));
        ua2.invoke(U());
    }

    public boolean f0() {
        return g0(d.get(this));
    }

    @Override // ir.nasim.VI5
    public final void g(CancellationException cancellationException) {
        G(cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return ir.nasim.GJ0.b.c(ir.nasim.C19938rB7.a);
     */
    @Override // ir.nasim.InterfaceC16756lo6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object h(java.lang.Object r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = ir.nasim.C6401Nl0.d
            long r0 = r0.get(r14)
            boolean r0 = r14.M0(r0)
            if (r0 == 0) goto L13
            ir.nasim.GJ0$b r15 = ir.nasim.GJ0.b
            java.lang.Object r15 = r15.b()
            return r15
        L13:
            ir.nasim.i47 r8 = ir.nasim.AbstractC6661Ol0.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = k()
            java.lang.Object r0 = r0.get(r14)
            ir.nasim.JJ0 r0 = (ir.nasim.JJ0) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = l()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = m(r14, r1)
            int r1 = ir.nasim.AbstractC6661Ol0.b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L59
            ir.nasim.JJ0 r1 = b(r14, r2, r0)
            if (r1 != 0) goto L57
            if (r11 == 0) goto L21
        L4b:
            ir.nasim.GJ0$b r15 = ir.nasim.GJ0.b
            java.lang.Throwable r0 = r14.X()
            java.lang.Object r15 = r15.a(r0)
            goto Lbe
        L57:
            r13 = r1
            goto L5a
        L59:
            r13 = r0
        L5a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = E(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lba
            r1 = 1
            if (r0 == r1) goto Lb1
            r1 = 2
            if (r0 == r1) goto L94
            r1 = 3
            if (r0 == r1) goto L88
            r1 = 4
            if (r0 == r1) goto L7c
            r1 = 5
            if (r0 == r1) goto L77
            goto L7a
        L77:
            r13.b()
        L7a:
            r0 = r13
            goto L21
        L7c:
            long r0 = r14.W()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4b
            r13.b()
            goto L4b
        L88:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L94:
            if (r11 == 0) goto L9a
            r13.p()
            goto L4b
        L9a:
            boolean r15 = r8 instanceof ir.nasim.InterfaceC21726u18
            if (r15 == 0) goto La1
            ir.nasim.u18 r8 = (ir.nasim.InterfaceC21726u18) r8
            goto La2
        La1:
            r8 = 0
        La2:
            if (r8 == 0) goto La7
            u(r14, r8, r13, r12)
        La7:
            r13.p()
            ir.nasim.GJ0$b r15 = ir.nasim.GJ0.b
            java.lang.Object r15 = r15.b()
            goto Lbe
        Lb1:
            ir.nasim.GJ0$b r15 = ir.nasim.GJ0.b
            ir.nasim.rB7 r0 = ir.nasim.C19938rB7.a
            java.lang.Object r15 = r15.c(r0)
            goto Lbe
        Lba:
            r13.b()
            goto Lb1
        Lbe:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.h(java.lang.Object):java.lang.Object");
    }

    @Override // ir.nasim.VI5
    public Object i(InterfaceC20295rm1 interfaceC20295rm1) {
        return B0(this, interfaceC20295rm1);
    }

    protected boolean i0() {
        return false;
    }

    @Override // ir.nasim.VI5
    public CJ0 iterator() {
        return new a();
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public Object o(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        return K0(this, obj, interfaceC20295rm1);
    }

    @Override // ir.nasim.VI5
    public InterfaceC13763gm6 r() {
        b bVar = b.a;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        InterfaceC15796kB2 interfaceC15796kB2 = (InterfaceC15796kB2) AbstractC19810qy7.g(bVar, 3);
        c cVar = c.a;
        AbstractC13042fc3.g(cVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new C14356hm6(this, interfaceC15796kB2, (InterfaceC15796kB2) AbstractC19810qy7.g(cVar, 3), this.c);
    }

    @Override // ir.nasim.VI5
    public InterfaceC13763gm6 t() {
        d dVar = d.a;
        AbstractC13042fc3.g(dVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        InterfaceC15796kB2 interfaceC15796kB2 = (InterfaceC15796kB2) AbstractC19810qy7.g(dVar, 3);
        e eVar = e.a;
        AbstractC13042fc3.g(eVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new C14356hm6(this, interfaceC15796kB2, (InterfaceC15796kB2) AbstractC19810qy7.g(eVar, 3), this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x01d4, code lost:
    
        r3 = (ir.nasim.JJ0) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01db, code lost:
    
        if (r3 != null) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C6401Nl0.toString():java.lang.String");
    }

    @Override // ir.nasim.VI5
    public Object v() {
        JJ0 jj0;
        long j2 = e.get(this);
        long j3 = d.get(this);
        if (g0(j3)) {
            return GJ0.b.a(U());
        }
        if (j2 >= (j3 & 1152921504606846975L)) {
            return GJ0.b.b();
        }
        Object obj = AbstractC6661Ol0.k;
        JJ0 jj02 = (JJ0) i.get(this);
        while (!f0()) {
            long andIncrement = e.getAndIncrement(this);
            int i2 = AbstractC6661Ol0.b;
            long j4 = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (jj02.c != j4) {
                JJ0 jj0Q = Q(j4, jj02);
                if (jj0Q == null) {
                    continue;
                } else {
                    jj0 = jj0Q;
                }
            } else {
                jj0 = jj02;
            }
            Object objR0 = R0(jj0, i3, andIncrement, obj);
            if (objR0 == AbstractC6661Ol0.m) {
                InterfaceC21726u18 interfaceC21726u18 = obj instanceof InterfaceC21726u18 ? (InterfaceC21726u18) obj : null;
                if (interfaceC21726u18 != null) {
                    x0(interfaceC21726u18, jj0, i3);
                }
                X0(andIncrement);
                jj0.p();
                return GJ0.b.b();
            }
            if (objR0 != AbstractC6661Ol0.o) {
                if (objR0 == AbstractC6661Ol0.n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                jj0.b();
                return GJ0.b.c(objR0);
            }
            if (andIncrement < Y()) {
                jj0.b();
            }
            jj02 = jj0;
        }
        return GJ0.b.a(U());
    }

    @Override // ir.nasim.InterfaceC16756lo6
    public boolean w(Throwable th) {
        return J(th, false);
    }

    @Override // ir.nasim.VI5
    public Object x(InterfaceC20295rm1 interfaceC20295rm1) {
        return C0(this, interfaceC20295rm1);
    }

    protected void p0() {
    }

    protected void v0() {
    }

    protected void w0() {
    }
}
