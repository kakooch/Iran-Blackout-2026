package ir.nasim;

import androidx.compose.ui.e;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputResetException;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.w37, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22931w37 extends e.c implements InterfaceC22335v37, InterfaceC9049Yg5, WH1 {
    private Object o;
    private Object p;
    private Object[] q;
    private InterfaceC14603iB2 r;
    private PointerInputEventHandler s;
    private InterfaceC13730gj3 t;
    private C3534Bg5 u = AbstractC21071t37.a;
    private final C12544en4 v;
    private final Object w;
    private final C12544en4 x;
    private C3534Bg5 y;
    private long z;

    /* renamed from: ir.nasim.w37$a */
    private final class a implements EV, WH1, InterfaceC20295rm1 {
        private final InterfaceC20295rm1 a;
        private final /* synthetic */ C22931w37 b;
        private HE0 c;
        private EnumC4002Dg5 d = EnumC4002Dg5.b;
        private final InterfaceC11938do1 e = C18712p72.a;

        /* renamed from: ir.nasim.w37$a$a, reason: collision with other inner class name */
        static final class C1735a extends AbstractC22163um1 {
            Object a;
            /* synthetic */ Object b;
            int d;

            C1735a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= RecyclerView.UNDEFINED_DURATION;
                return a.this.Q(0L, null, this);
            }
        }

        /* renamed from: ir.nasim.w37$a$b */
        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ long c;
            final /* synthetic */ a d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(long j, a aVar, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = j;
                this.d = aVar;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(this.c, this.d, interfaceC20295rm1);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
            @Override // ir.nasim.E90
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
                    int r1 = r8.b
                    r2 = 8
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L20
                    if (r1 == r5) goto L1c
                    if (r1 != r4) goto L14
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L38
                L14:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L1c:
                    ir.nasim.AbstractC10685c16.b(r9)
                    goto L2f
                L20:
                    ir.nasim.AbstractC10685c16.b(r9)
                    long r6 = r8.c
                    long r6 = r6 - r2
                    r8.b = r5
                    java.lang.Object r9 = ir.nasim.HG1.b(r6, r8)
                    if (r9 != r0) goto L2f
                    return r0
                L2f:
                    r8.b = r4
                    java.lang.Object r9 = ir.nasim.HG1.b(r2, r8)
                    if (r9 != r0) goto L38
                    return r0
                L38:
                    ir.nasim.w37$a r9 = r8.d
                    ir.nasim.HE0 r9 = ir.nasim.C22931w37.a.h(r9)
                    if (r9 == 0) goto L54
                    ir.nasim.a16$a r0 = ir.nasim.C9475a16.b
                    androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r0 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                    long r1 = r8.c
                    r0.<init>(r1)
                    java.lang.Object r0 = ir.nasim.AbstractC10685c16.a(r0)
                    java.lang.Object r0 = ir.nasim.C9475a16.b(r0)
                    r9.resumeWith(r0)
                L54:
                    ir.nasim.rB7 r9 = ir.nasim.C19938rB7.a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22931w37.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.w37$a$c */
        static final class c extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int c;

            c(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return a.this.f1(0L, null, this);
            }
        }

        public a(InterfaceC20295rm1 interfaceC20295rm1) {
            this.a = interfaceC20295rm1;
            this.b = C22931w37.this;
        }

        @Override // ir.nasim.WH1
        public int A1(long j) {
            return this.b.A1(j);
        }

        @Override // ir.nasim.WH1
        public int B0(float f) {
            return this.b.B0(f);
        }

        @Override // ir.nasim.WH1
        public float D(int i) {
            return this.b.D(i);
        }

        @Override // ir.nasim.WH1
        public float I0(long j) {
            return this.b.I0(j);
        }

        @Override // ir.nasim.WH1
        public long I1(long j) {
            return this.b.I1(j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r11v0, types: [long] */
        /* JADX WARN: Type inference failed for: r11v1, types: [ir.nasim.gj3] */
        /* JADX WARN: Type inference failed for: r11v3, types: [ir.nasim.gj3] */
        /* JADX WARN: Type inference failed for: r11v7 */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r13v0, types: [ir.nasim.iB2] */
        @Override // ir.nasim.EV
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object Q(long r11, ir.nasim.InterfaceC14603iB2 r13, ir.nasim.InterfaceC20295rm1 r14) {
            /*
                r10 = this;
                boolean r0 = r14 instanceof ir.nasim.C22931w37.a.C1735a
                if (r0 == 0) goto L13
                r0 = r14
                ir.nasim.w37$a$a r0 = (ir.nasim.C22931w37.a.C1735a) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.d = r1
                goto L18
            L13:
                ir.nasim.w37$a$a r0 = new ir.nasim.w37$a$a
                r0.<init>(r14)
            L18:
                java.lang.Object r14 = r0.b
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r11 = r0.a
                ir.nasim.gj3 r11 = (ir.nasim.InterfaceC13730gj3) r11
                ir.nasim.AbstractC10685c16.b(r14)     // Catch: java.lang.Throwable -> L2d
                goto L75
            L2d:
                r12 = move-exception
                goto L7b
            L2f:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L37:
                ir.nasim.AbstractC10685c16.b(r14)
                r4 = 0
                int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r14 > 0) goto L56
                ir.nasim.HE0 r14 = r10.c
                if (r14 == 0) goto L56
                ir.nasim.a16$a r2 = ir.nasim.C9475a16.b
                androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r2 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
                r2.<init>(r11)
                java.lang.Object r2 = ir.nasim.AbstractC10685c16.a(r2)
                java.lang.Object r2 = ir.nasim.C9475a16.b(r2)
                r14.resumeWith(r2)
            L56:
                ir.nasim.w37 r14 = ir.nasim.C22931w37.this
                ir.nasim.ro1 r4 = r14.U1()
                ir.nasim.w37$a$b r7 = new ir.nasim.w37$a$b
                r14 = 0
                r7.<init>(r11, r10, r14)
                r8 = 3
                r9 = 0
                r5 = 0
                r6 = 0
                ir.nasim.gj3 r11 = ir.nasim.AbstractC9323Zl0.d(r4, r5, r6, r7, r8, r9)
                r0.a = r11     // Catch: java.lang.Throwable -> L2d
                r0.d = r3     // Catch: java.lang.Throwable -> L2d
                java.lang.Object r14 = r13.invoke(r10, r0)     // Catch: java.lang.Throwable -> L2d
                if (r14 != r1) goto L75
                return r1
            L75:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r12 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.a
                r11.g(r12)
                return r14
            L7b:
                androidx.compose.ui.input.pointer.CancelTimeoutCancellationException r13 = androidx.compose.ui.input.pointer.CancelTimeoutCancellationException.a
                r11.g(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22931w37.a.Q(long, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        @Override // ir.nasim.EV
        public C3534Bg5 S0() {
            return C22931w37.this.u;
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public long T(float f) {
            return this.b.T(f);
        }

        @Override // ir.nasim.WH1
        public long U(long j) {
            return this.b.U(j);
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float Y(long j) {
            return this.b.Y(j);
        }

        @Override // ir.nasim.EV
        public long a() {
            return C22931w37.this.z;
        }

        @Override // ir.nasim.EV
        public Object f0(EnumC4002Dg5 enumC4002Dg5, InterfaceC20295rm1 interfaceC20295rm1) {
            IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
            ie0.w();
            this.d = enumC4002Dg5;
            this.c = ie0;
            Object objT = ie0.t();
            if (objT == AbstractC14862ic3.e()) {
                WA1.c(interfaceC20295rm1);
            }
            return objT;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.EV
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object f1(long r5, ir.nasim.InterfaceC14603iB2 r7, ir.nasim.InterfaceC20295rm1 r8) {
            /*
                r4 = this;
                boolean r0 = r8 instanceof ir.nasim.C22931w37.a.c
                if (r0 == 0) goto L13
                r0 = r8
                ir.nasim.w37$a$c r0 = (ir.nasim.C22931w37.a.c) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.w37$a$c r0 = new ir.nasim.w37$a$c
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                ir.nasim.AbstractC10685c16.b(r8)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                goto L3e
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                ir.nasim.AbstractC10685c16.b(r8)
                r0.c = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                java.lang.Object r8 = r4.Q(r5, r7, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L3d
                if (r8 != r1) goto L3e
                return r1
            L3d:
                r8 = 0
            L3e:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C22931w37.a.f1(long, ir.nasim.iB2, ir.nasim.rm1):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC20295rm1
        public InterfaceC11938do1 getContext() {
            return this.e;
        }

        @Override // ir.nasim.WH1
        public float getDensity() {
            return this.b.getDensity();
        }

        @Override // ir.nasim.EV
        public InterfaceC18354oW7 getViewConfiguration() {
            return C22931w37.this.getViewConfiguration();
        }

        @Override // ir.nasim.WH1
        public long j0(float f) {
            return this.b.j0(f);
        }

        @Override // ir.nasim.WH1
        public float o1(float f) {
            return this.b.o1(f);
        }

        @Override // ir.nasim.InterfaceC20295rm1
        public void resumeWith(Object obj) {
            Object obj2 = C22931w37.this.w;
            C22931w37 c22931w37 = C22931w37.this;
            synchronized (obj2) {
                c22931w37.v.t(this);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            this.a.resumeWith(obj);
        }

        @Override // ir.nasim.EV
        public long t0() {
            return C22931w37.this.t0();
        }

        @Override // ir.nasim.InterfaceC23430wu2
        public float t1() {
            return this.b.t1();
        }

        public final void u(Throwable th) {
            HE0 he0 = this.c;
            if (he0 != null) {
                he0.F(th);
            }
            this.c = null;
        }

        @Override // ir.nasim.WH1
        public float w1(float f) {
            return this.b.w1(f);
        }

        public final void z(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5) {
            HE0 he0;
            if (enumC4002Dg5 != this.d || (he0 = this.c) == null) {
                return;
            }
            this.c = null;
            he0.resumeWith(C9475a16.b(c3534Bg5));
        }
    }

    /* renamed from: ir.nasim.w37$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC4002Dg5.values().length];
            try {
                iArr[EnumC4002Dg5.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC4002Dg5.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC4002Dg5.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.w37$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a aVar) {
            super(1);
            this.e = aVar;
        }

        public final void a(Throwable th) {
            this.e.u(th);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.w37$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22931w37.this.new d(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (C22931w37.this.r != null) {
                    InterfaceC14603iB2 interfaceC14603iB2 = C22931w37.this.r;
                    AbstractC13042fc3.f(interfaceC14603iB2);
                    C22931w37 c22931w37 = C22931w37.this;
                    this.b = 1;
                    if (interfaceC14603iB2.invoke(c22931w37, this) == objE) {
                        return objE;
                    }
                } else {
                    PointerInputEventHandler pointerInputEventHandlerB2 = C22931w37.this.B2();
                    C22931w37 c22931w372 = C22931w37.this;
                    this.b = 2;
                    if (pointerInputEventHandlerB2.invoke(c22931w372, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
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

    public C22931w37(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        this.o = obj;
        this.p = obj2;
        this.q = objArr;
        this.s = pointerInputEventHandler;
        C12544en4 c12544en4 = new C12544en4(new a[16], 0);
        this.v = c12544en4;
        this.w = c12544en4;
        this.x = new C12544en4(new a[16], 0);
        this.z = C4414Fa3.b.a();
    }

    private final void A2(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5) {
        synchronized (this.w) {
            C12544en4 c12544en4 = this.x;
            c12544en4.f(c12544en4.o(), this.v);
        }
        try {
            int i = b.a[enumC4002Dg5.ordinal()];
            if (i == 1 || i == 2) {
                C12544en4 c12544en42 = this.x;
                Object[] objArr = c12544en42.a;
                int iO = c12544en42.o();
                for (int i2 = 0; i2 < iO; i2++) {
                    ((a) objArr[i2]).z(c3534Bg5, enumC4002Dg5);
                }
            } else if (i == 3) {
                C12544en4 c12544en43 = this.x;
                int iO2 = c12544en43.o() - 1;
                Object[] objArr2 = c12544en43.a;
                if (iO2 < objArr2.length) {
                    while (iO2 >= 0) {
                        ((a) objArr2[iO2]).z(c3534Bg5, enumC4002Dg5);
                        iO2--;
                    }
                }
            }
        } finally {
            this.x.k();
        }
    }

    @Override // ir.nasim.InterfaceC9049Yg5
    public Object B1(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        a aVar = new a(ie0);
        synchronized (this.w) {
            this.v.d(aVar);
            InterfaceC20295rm1 interfaceC20295rm1A = AbstractC23349wm1.a(interfaceC14603iB2, aVar, aVar);
            C9475a16.a aVar2 = C9475a16.b;
            interfaceC20295rm1A.resumeWith(C9475a16.b(C19938rB7.a));
        }
        ie0.J(new c(aVar));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    public PointerInputEventHandler B2() {
        return this.s;
    }

    public final void C2(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        boolean z = !AbstractC13042fc3.d(this.o, obj);
        this.o = obj;
        if (!AbstractC13042fc3.d(this.p, obj2)) {
            z = true;
        }
        this.p = obj2;
        Object[] objArr2 = this.q;
        if (objArr2 != null && objArr == null) {
            z = true;
        }
        if (objArr2 == null && objArr != null) {
            z = true;
        }
        if (objArr2 != null && objArr != null && !Arrays.equals(objArr, objArr2)) {
            z = true;
        }
        this.q = objArr;
        if (B2().getClass() == pointerInputEventHandler.getClass() ? z : true) {
            N0();
        }
        this.s = pointerInputEventHandler;
    }

    @Override // ir.nasim.JG1, ir.nasim.InterfaceC8508Wg5
    public void E() {
        N0();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void J1() {
        N0();
    }

    @Override // ir.nasim.InterfaceC22335v37
    public void N0() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.t;
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(new PointerInputResetException());
            this.t = null;
        }
    }

    public long a() {
        return this.z;
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        N0();
        super.f2();
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return KG1.o(this).T().getDensity();
    }

    @Override // ir.nasim.InterfaceC9049Yg5
    public InterfaceC18354oW7 getViewConfiguration() {
        return KG1.o(this).D0();
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void i1() {
        C3534Bg5 c3534Bg5 = this.y;
        if (c3534Bg5 == null) {
            return;
        }
        int size = c3534Bg5.c().size();
        for (int i = 0; i < size; i++) {
            if (!(!((C6616Og5) r2.get(i)).i())) {
                List listC = c3534Bg5.c();
                ArrayList arrayList = new ArrayList(listC.size());
                int size2 = listC.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C6616Og5 c6616Og5 = (C6616Og5) listC.get(i2);
                    arrayList.add(new C6616Og5(c6616Og5.f(), c6616Og5.o(), c6616Og5.h(), false, c6616Og5.j(), c6616Og5.o(), c6616Og5.h(), c6616Og5.i(), c6616Og5.i(), c6616Og5.n(), 0L, 1024, (ED1) null));
                }
                C3534Bg5 c3534Bg52 = new C3534Bg5(arrayList);
                this.u = c3534Bg52;
                A2(c3534Bg52, EnumC4002Dg5.a);
                A2(c3534Bg52, EnumC4002Dg5.b);
                A2(c3534Bg52, EnumC4002Dg5.c);
                this.y = null;
                return;
            }
        }
    }

    @Override // ir.nasim.InterfaceC8508Wg5
    public void k1(C3534Bg5 c3534Bg5, EnumC4002Dg5 enumC4002Dg5, long j) {
        this.z = j;
        if (enumC4002Dg5 == EnumC4002Dg5.a) {
            this.u = c3534Bg5;
        }
        if (this.t == null) {
            this.t = AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new d(null), 1, null);
        }
        A2(c3534Bg5, enumC4002Dg5);
        List listC = c3534Bg5.c();
        int size = listC.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = true;
                break;
            } else if (!AbstractC3768Cg5.d((C6616Og5) listC.get(i))) {
                break;
            } else {
                i++;
            }
        }
        if (!(!z)) {
            c3534Bg5 = null;
        }
        this.y = c3534Bg5;
    }

    public long t0() {
        long jI1 = I1(getViewConfiguration().e());
        long jA = a();
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (jI1 >> 32)) - ((int) (jA >> 32))) / 2.0f;
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (jI1 & 4294967295L)) - ((int) (jA & 4294967295L))) / 2.0f;
        return OD6.d((Float.floatToRawIntBits(fMax) << 32) | (Float.floatToRawIntBits(fMax2) & 4294967295L));
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return KG1.o(this).T().t1();
    }
}
