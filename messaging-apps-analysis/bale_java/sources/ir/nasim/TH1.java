package ir.nasim;

import android.gov.nist.core.Separators;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public final class TH1 {
    private static final a k = new a(null);
    public static final int l = 8;
    private final InterfaceC20315ro1 a;
    private final AbstractC13778go1 b;
    private final VI5 c;
    private final String d;
    private final ReentrantLock e;
    private final InterfaceC17639nJ0 f;
    private final HashMap g;
    private final AtomicInteger h;
    private final AtomicBoolean i;
    private final InterfaceC22299v01 j;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class c extends AbstractC22163um1 {
        Object a;
        int b;
        /* synthetic */ Object c;
        int e;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= RecyclerView.UNDEFINED_DURATION;
            return TH1.this.i(0, this);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = obj;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TH1.this.new d(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC17639nJ0 interfaceC17639nJ0 = TH1.this.f;
                Object obj2 = this.d;
                this.b = 1;
                if (interfaceC17639nJ0.o(obj2, this) == objE) {
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

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return TH1.this.new e(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006f -> B:11:0x0027). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                int r1 = r9.c
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L31
                if (r1 == r6) goto L29
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                ir.nasim.AbstractC10685c16.b(r10)
                goto Lb2
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L20:
                java.lang.Object r1 = r9.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                ir.nasim.AbstractC10685c16.b(r10)
            L27:
                r10 = r1
                goto L3e
            L29:
                java.lang.Object r1 = r9.b
                ir.nasim.CJ0 r1 = (ir.nasim.CJ0) r1
                ir.nasim.AbstractC10685c16.b(r10)
                goto L4c
            L31:
                ir.nasim.AbstractC10685c16.b(r10)
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                ir.nasim.VI5 r10 = ir.nasim.TH1.b(r10)
                ir.nasim.CJ0 r10 = r10.iterator()
            L3e:
                r9.b = r10
                r9.c = r6
                java.lang.Object r1 = r10.a(r9)
                if (r1 != r0) goto L49
                return r0
            L49:
                r8 = r1
                r1 = r10
                r10 = r8
            L4c:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                if (r10 == 0) goto L72
                java.lang.Object r10 = r1.next()
                ir.nasim.TH1 r7 = ir.nasim.TH1.this
                java.util.concurrent.atomic.AtomicInteger r7 = ir.nasim.TH1.f(r7)
                r7.incrementAndGet()
                ir.nasim.TH1 r7 = ir.nasim.TH1.this
                ir.nasim.nJ0 r7 = ir.nasim.TH1.e(r7)
                r9.b = r1
                r9.c = r3
                java.lang.Object r10 = r7.o(r10, r9)
                if (r10 != r0) goto L27
                return r0
            L72:
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                java.util.concurrent.atomic.AtomicBoolean r10 = ir.nasim.TH1.c(r10)
                r10.set(r6)
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                java.util.concurrent.atomic.AtomicInteger r10 = ir.nasim.TH1.f(r10)
                int r10 = r10.get()
                if (r10 <= 0) goto La5
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                java.lang.String r10 = ir.nasim.TH1.g(r10)
                java.lang.String r1 = "Waiting for the consumption of items."
                java.lang.Object[] r3 = new java.lang.Object[r5]
                ir.nasim.C19406qI3.j(r10, r1, r3)
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                ir.nasim.v01 r10 = ir.nasim.TH1.d(r10)
                r9.b = r4
                r9.c = r2
                java.lang.Object r10 = r10.y(r9)
                if (r10 != r0) goto Lb2
                return r0
            La5:
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                java.lang.String r10 = ir.nasim.TH1.g(r10)
                java.lang.String r0 = "No need to wait for the consumption of items."
                java.lang.Object[] r1 = new java.lang.Object[r5]
                ir.nasim.C19406qI3.a(r10, r0, r1)
            Lb2:
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                ir.nasim.nJ0 r10 = ir.nasim.TH1.e(r10)
                ir.nasim.InterfaceC16756lo6.a.a(r10, r4, r6, r4)
                ir.nasim.TH1 r10 = ir.nasim.TH1.this
                java.lang.String r10 = ir.nasim.TH1.g(r10)
                java.lang.String r0 = "Channel closed"
                java.lang.Object[] r1 = new java.lang.Object[r5]
                ir.nasim.C19406qI3.j(r10, r0, r1)
                ir.nasim.rB7 r10 = ir.nasim.C19938rB7.a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TH1.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public TH1(int i, int i2, InterfaceC20315ro1 interfaceC20315ro1, AbstractC13778go1 abstractC13778go1, VI5 vi5) {
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(vi5, "inputChannel");
        this.a = interfaceC20315ro1;
        this.b = abstractC13778go1;
        this.c = vi5;
        this.d = "DeliveryBuffer(" + i + Separators.RPAREN;
        this.e = new ReentrantLock(true);
        this.f = DJ0.b(i2, null, new UA2() { // from class: ir.nasim.SH1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TH1.k(this.a, obj);
            }
        }, 2, null);
        this.g = new HashMap();
        this.h = new AtomicInteger();
        this.i = new AtomicBoolean();
        this.j = AbstractC23485x01.c(null, 1, null);
    }

    private final void j(InterfaceC22299v01 interfaceC22299v01, Object obj) {
        if (interfaceC22299v01.b()) {
            interfaceC22299v01.U(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(TH1 th1, Object obj) {
        AbstractC13042fc3.i(th1, "this$0");
        C19406qI3.j(th1.d, "Undelivered item: " + obj, new Object[0]);
        th1.l(obj);
        return C19938rB7.a;
    }

    private final void l(Object obj) {
        AbstractC10533bm0.d(this.a, this.b, null, new d(obj, null), 2, null);
    }

    public final void h(int i, Object obj) {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            if (this.g.remove(b.a(i), obj) && this.h.decrementAndGet() == 0 && this.i.get()) {
                C19406qI3.a(this.d, "No remaining items, closing the channel.", new Object[0]);
                j(this.j, C19938rB7.a);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(int r6, ir.nasim.InterfaceC20295rm1 r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ir.nasim.TH1.c
            if (r0 == 0) goto L13
            r0 = r7
            ir.nasim.TH1$c r0 = (ir.nasim.TH1.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ir.nasim.TH1$c r0 = new ir.nasim.TH1$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            int r6 = r0.b
            java.lang.Object r0 = r0.a
            ir.nasim.TH1 r0 = (ir.nasim.TH1) r0
            ir.nasim.AbstractC10685c16.b(r7)
            ir.nasim.GJ0 r7 = (ir.nasim.GJ0) r7
            java.lang.Object r7 = r7.k()
            goto L64
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            ir.nasim.AbstractC10685c16.b(r7)
            java.util.concurrent.locks.ReentrantLock r7 = r5.e
            r7.lock()
            java.util.HashMap r2 = r5.g     // Catch: java.lang.Throwable -> L85
            ir.nasim.TH1$b r4 = ir.nasim.TH1.b.a(r6)     // Catch: java.lang.Throwable -> L85
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L85
            r7.unlock()
            if (r2 != 0) goto L84
            ir.nasim.nJ0 r7 = r5.f
            r0.a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r7 = r7.x(r0)
            if (r7 != r1) goto L63
            return r1
        L63:
            r0 = r5
        L64:
            java.lang.Object r2 = ir.nasim.GJ0.f(r7)
            if (r2 == 0) goto L83
            java.util.concurrent.locks.ReentrantLock r7 = r0.e
            r7.lock()
            ir.nasim.TH1$b r6 = ir.nasim.TH1.b.a(r6)     // Catch: java.lang.Throwable -> L7e
            java.util.HashMap r0 = r0.g     // Catch: java.lang.Throwable -> L7e
            r0.put(r6, r2)     // Catch: java.lang.Throwable -> L7e
            ir.nasim.rB7 r6 = ir.nasim.C19938rB7.a     // Catch: java.lang.Throwable -> L7e
            r7.unlock()
            goto L84
        L7e:
            r6 = move-exception
            r7.unlock()
            throw r6
        L83:
            r2 = 0
        L84:
            return r2
        L85:
            r6 = move-exception
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TH1.i(int, ir.nasim.rm1):java.lang.Object");
    }

    public final void m(int i) {
        ReentrantLock reentrantLock = this.e;
        reentrantLock.lock();
        try {
            Object objRemove = this.g.remove(b.a(i));
            if (objRemove == null) {
                return;
            }
            C19406qI3.a(this.d, "Sending item(" + objRemove + ") to the channel.", new Object[0]);
            l(objRemove);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void n() {
        C19406qI3.a(this.d, "start()", new Object[0]);
        AbstractC10533bm0.d(this.a, this.b, null, new e(null), 2, null);
    }

    public static final class b {
        private final int a;

        private /* synthetic */ b(int i) {
            this.a = i;
        }

        public static final /* synthetic */ b a(int i) {
            return new b(i);
        }

        public static boolean c(int i, Object obj) {
            return (obj instanceof b) && i == ((b) obj).f();
        }

        public static int d(int i) {
            return Integer.hashCode(i);
        }

        public static String e(int i) {
            return "OwnerId(id=" + i + Separators.RPAREN;
        }

        public boolean equals(Object obj) {
            return c(this.a, obj);
        }

        public final /* synthetic */ int f() {
            return this.a;
        }

        public int hashCode() {
            return d(this.a);
        }

        public String toString() {
            return e(this.a);
        }

        public static int b(int i) {
            return i;
        }
    }
}
