package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14970in2;
import ir.nasim.InterfaceC10839cH7;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeer;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.List;

/* renamed from: ir.nasim.in2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14970in2 extends AbstractC21707u0 {
    public static final a i = new a(null);
    public static final int j = 8;
    private final C9057Yh4 b;
    private final b c;
    private final InterfaceC23211wY1 d;
    private final InterfaceC8344Vo3 e;
    private C9528a7 f;
    private C9528a7 g;
    private C9528a7 h;

    /* renamed from: ir.nasim.in2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.in2$b */
    private static final class b implements InterfaceC10258bL6 {
        private final InterfaceC9336Zm4 a;

        /* renamed from: ir.nasim.in2$b$a */
        static final class a extends AbstractC22163um1 {
            /* synthetic */ Object a;
            int c;

            a(InterfaceC20295rm1 interfaceC20295rm1) {
                super(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.c |= RecyclerView.UNDEFINED_DURATION;
                return b.this.b(null, this);
            }
        }

        public b(Object obj) {
            this.a = AbstractC12281eL6.a(AbstractC12281eL6.a(obj));
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ir.nasim.InterfaceC10040ay6, ir.nasim.InterfaceC4557Fq2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(ir.nasim.InterfaceC4806Gq2 r5, ir.nasim.InterfaceC20295rm1 r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof ir.nasim.C14970in2.b.a
                if (r0 == 0) goto L13
                r0 = r6
                ir.nasim.in2$b$a r0 = (ir.nasim.C14970in2.b.a) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                ir.nasim.in2$b$a r0 = new ir.nasim.in2$b$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.a
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 == r3) goto L2d
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L2d:
                ir.nasim.AbstractC10685c16.b(r6)
                goto L43
            L31:
                ir.nasim.AbstractC10685c16.b(r6)
                ir.nasim.Zm4 r6 = r4.a
                ir.nasim.Fq2 r6 = ir.nasim.AbstractC6459Nq2.P(r6)
                r0.c = r3
                java.lang.Object r5 = r6.b(r5, r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                java.util.concurrent.CancellationException r5 = new java.util.concurrent.CancellationException
                r5.<init>()
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C14970in2.b.b(ir.nasim.Gq2, ir.nasim.rm1):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC10040ay6
        public List e() {
            return ((InterfaceC10258bL6) this.a.getValue()).e();
        }

        @Override // ir.nasim.InterfaceC10258bL6
        public Object getValue() {
            return ((InterfaceC10258bL6) this.a.getValue()).getValue();
        }

        public final void h(InterfaceC10258bL6 interfaceC10258bL6) {
            Object value;
            AbstractC13042fc3.i(interfaceC10258bL6, "stateFlow");
            InterfaceC9336Zm4 interfaceC9336Zm4 = this.a;
            do {
                value = interfaceC9336Zm4.getValue();
            } while (!interfaceC9336Zm4.f(value, interfaceC10258bL6));
        }
    }

    /* renamed from: ir.nasim.in2$c */
    public static final class c implements InterfaceC7850Tl4 {
        final /* synthetic */ InterfaceC7850Tl4 b;

        c(InterfaceC7850Tl4 interfaceC7850Tl4) {
            this.b = interfaceC7850Tl4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(InterfaceC7850Tl4 interfaceC7850Tl4, List list) {
            AbstractC13042fc3.i(interfaceC7850Tl4, "$callback");
            AbstractC13042fc3.i(list, "$downloadStates");
            interfaceC7850Tl4.a(list);
        }

        @Override // ir.nasim.InterfaceC7850Tl4
        public void a(final List list) {
            AbstractC13042fc3.i(list, "downloadStates");
            C14970in2 c14970in2 = C14970in2.this;
            final InterfaceC7850Tl4 interfaceC7850Tl4 = this.b;
            c14970in2.z(new Runnable() { // from class: ir.nasim.jn2
                @Override // java.lang.Runnable
                public final void run() {
                    C14970in2.c.c(interfaceC7850Tl4, list);
                }
            });
        }
    }

    /* renamed from: ir.nasim.in2$d */
    public static final class d implements InterfaceC8807Xk2 {
        final /* synthetic */ InterfaceC8807Xk2 b;

        d(InterfaceC8807Xk2 interfaceC8807Xk2) {
            this.b = interfaceC8807Xk2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(InterfaceC8807Xk2 interfaceC8807Xk2, InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
            AbstractC13042fc3.i(interfaceC3346Am2, "$reference");
            interfaceC8807Xk2.d(interfaceC3346Am2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(InterfaceC8807Xk2 interfaceC8807Xk2, float f) {
            AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
            interfaceC8807Xk2.c(f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(InterfaceC8807Xk2 interfaceC8807Xk2, DX1 dx1) {
            AbstractC13042fc3.i(interfaceC8807Xk2, "$callback");
            interfaceC8807Xk2.g(dx1);
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void c(final float f) {
            C14970in2 c14970in2 = C14970in2.this;
            final InterfaceC8807Xk2 interfaceC8807Xk2 = this.b;
            c14970in2.z(new Runnable() { // from class: ir.nasim.mn2
                @Override // java.lang.Runnable
                public final void run() {
                    C14970in2.d.i(interfaceC8807Xk2, f);
                }
            });
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void d(final InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            C14970in2 c14970in2 = C14970in2.this;
            final InterfaceC8807Xk2 interfaceC8807Xk2 = this.b;
            c14970in2.z(new Runnable() { // from class: ir.nasim.ln2
                @Override // java.lang.Runnable
                public final void run() {
                    C14970in2.d.h(interfaceC8807Xk2, interfaceC3346Am2);
                }
            });
        }

        @Override // ir.nasim.InterfaceC8807Xk2
        public void g(final DX1 dx1) {
            C14970in2 c14970in2 = C14970in2.this;
            final InterfaceC8807Xk2 interfaceC8807Xk2 = this.b;
            c14970in2.z(new Runnable() { // from class: ir.nasim.kn2
                @Override // java.lang.Runnable
                public final void run() {
                    C14970in2.d.j(interfaceC8807Xk2, dx1);
                }
            });
        }
    }

    /* renamed from: ir.nasim.in2$e */
    public static final class e implements InterfaceC19401qH7 {
        final /* synthetic */ boolean a;
        final /* synthetic */ C14970in2 b;
        final /* synthetic */ C11458d25 c;
        final /* synthetic */ EnumC5360Iz7 d;
        final /* synthetic */ C9528a7 e;
        final /* synthetic */ C7880To7 f;

        e(boolean z, C14970in2 c14970in2, C11458d25 c11458d25, EnumC5360Iz7 enumC5360Iz7, C9528a7 c9528a7, C7880To7 c7880To7) {
            this.a = z;
            this.b = c14970in2;
            this.c = c11458d25;
            this.d = enumC5360Iz7;
            this.e = c9528a7;
            this.f = c7880To7;
        }

        @Override // ir.nasim.InterfaceC19401qH7
        public void a(long j, FileReference fileReference, Long l) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            if (this.a) {
                this.b.L().U().F(this.c, this.d);
            }
            this.e.d(new VG7(j, fileReference, l, this.f));
        }

        @Override // ir.nasim.InterfaceC19401qH7
        public void b(long j) {
            if (this.f != null) {
                return;
            }
            this.b.L().U().F(this.c, this.d);
        }

        @Override // ir.nasim.InterfaceC19401qH7
        public void c(long j) {
            if (this.f == null) {
                this.b.L().U().F(this.c, this.d);
            }
            this.e.d(new C9629aH7(j));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14970in2(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.b = c9057Yh4;
        this.c = new b(null);
        C5721Ko c5721Ko = C5721Ko.a;
        InterfaceC23211wY1 interfaceC23211wY1 = (InterfaceC23211wY1) C92.a(c5721Ko.d(), InterfaceC23211wY1.class);
        this.d = interfaceC23211wY1;
        this.e = new C9030Ye4(((InterfaceC3375Ap4) C92.a(c5721Ko.d(), InterfaceC3375Ap4.class)).B(), interfaceC23211wY1.L(), interfaceC23211wY1.T0());
    }

    public static /* synthetic */ void K(C14970in2 c14970in2, FileReference fileReference, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        c14970in2.I(fileReference, interfaceC8807Xk2, z, z2);
    }

    public static /* synthetic */ void W(C14970in2 c14970in2, long j2, long j3, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        c14970in2.V(j2, j3, interfaceC8807Xk2, z);
    }

    public static /* synthetic */ void Z(C14970in2 c14970in2, long j2, long j3, ExPeer exPeer, String str, String str2, String str3, C9528a7 c9528a7, Long l, EnumC5360Iz7 enumC5360Iz7, boolean z, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6, InterfaceC10839cH7 interfaceC10839cH7, int i2, Object obj) {
        c14970in2.Y(j2, j3, exPeer, str, str2, str3, c9528a7, (i2 & 128) != 0 ? null : l, (i2 & 256) != 0 ? EnumC5360Iz7.b : enumC5360Iz7, (i2 & 512) != 0 ? false : z, c7880To7, enumC4543Fo6, interfaceC10839cH7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 d0(C14970in2 c14970in2) {
        AbstractC13042fc3.i(c14970in2, "this$0");
        return new C21368tY1(c14970in2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 e0(C14970in2 c14970in2) {
        AbstractC13042fc3.i(c14970in2, "this$0");
        return new C24649yy4(c14970in2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K6 f0(C14970in2 c14970in2) {
        AbstractC13042fc3.i(c14970in2, "this$0");
        C24649yy4 c24649yy4 = new C24649yy4(c14970in2.b);
        if (C8386Vt0.a.Rb()) {
            c14970in2.c.h(c24649yy4.D0());
        }
        return c24649yy4;
    }

    public static /* synthetic */ void i0(C14970in2 c14970in2, FileReference fileReference, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        c14970in2.h0(fileReference, z);
    }

    public final InterfaceC7857Tm2 D(FileReference fileReference, boolean z, InterfaceC8091Um2 interfaceC8091Um2, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(interfaceC8091Um2, "callback");
        C8325Vm2 c8325Vm2 = new C8325Vm2(fileReference, z, this, interfaceC8091Um2, z2, z3, z4);
        c8325Vm2.init();
        return c8325Vm2;
    }

    public final void F(long j2, InterfaceC10223bH7 interfaceC10223bH7) {
        C9528a7 c9528a7 = this.g;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(interfaceC10223bH7);
        c9528a7.d(new C8017Ue0(j2, interfaceC10223bH7));
    }

    public final void G(long j2, InterfaceC10223bH7 interfaceC10223bH7) {
        C9528a7 c9528a7 = this.h;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(interfaceC10223bH7);
        c9528a7.d(new C8017Ue0(j2, interfaceC10223bH7));
    }

    public final void H(long j2) {
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new C23030wE0(j2));
    }

    public final void I(FileReference fileReference, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z, boolean z2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new C7544Se0(fileReference, true, interfaceC8807Xk2, z, z2, false, 32, null));
    }

    public final void J(FileReference fileReference, boolean z, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z2, boolean z3, boolean z4) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(interfaceC8807Xk2, "callback");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new C7544Se0(fileReference, z, interfaceC8807Xk2, z2, z3, z4));
    }

    public final C9057Yh4 L() {
        return this.b;
    }

    public final InterfaceC10258bL6 M() {
        return this.c;
    }

    public final String N(long j2) {
        C10405bZ1 c10405bZ1 = (C10405bZ1) this.e.d(j2);
        if (c10405bZ1 != null) {
            return c10405bZ1.q();
        }
        return null;
    }

    public final InterfaceC8344Vo3 O() {
        return this.e;
    }

    public final void P(FileReference fileReference, InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(fileReference, "fileReference");
        AbstractC13042fc3.i(interfaceC8807Xk2, "fileCallback");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new GV5(fileReference.getFileId(), fileReference.getAccessHash(), interfaceC8807Xk2, false, null, 24, null));
    }

    public final void Q(List list) {
        AbstractC13042fc3.i(list, "fileIds");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new GN5(list));
    }

    public final void R(long j2) {
        C9528a7 c9528a7 = this.h;
        if (c9528a7 != null) {
            c9528a7.d(new KN5(j2));
        }
    }

    public final void S(long j2) {
        C9528a7 c9528a7 = this.g;
        if (c9528a7 != null) {
            c9528a7.d(new KN5(j2));
        }
    }

    public final void T(List list, InterfaceC7850Tl4 interfaceC7850Tl4) {
        AbstractC13042fc3.i(list, "fileIds");
        AbstractC13042fc3.i(interfaceC7850Tl4, "callback");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new C8084Ul4(list, new c(interfaceC7850Tl4)));
    }

    public final void U(long j2, long j3, InterfaceC8807Xk2 interfaceC8807Xk2) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "callback");
        W(this, j2, j3, interfaceC8807Xk2, false, 8, null);
    }

    public final void V(long j2, long j3, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z) {
        AbstractC13042fc3.i(interfaceC8807Xk2, "callback");
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        c9528a7.d(new GV5(j2, j3, new d(interfaceC8807Xk2), z, null, 16, null));
    }

    public final void X(long j2, long j3, ExPeer exPeer, String str, String str2, String str3, C9528a7 c9528a7, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6, InterfaceC10839cH7 interfaceC10839cH7) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(c9528a7, "requester");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC10839cH7, "fileType");
        Z(this, j2, j3, exPeer, str, str2, str3, c9528a7, null, null, false, c7880To7, enumC4543Fo6, interfaceC10839cH7, 896, null);
    }

    public final void Y(long j2, long j3, ExPeer exPeer, String str, String str2, String str3, C9528a7 c9528a7, Long l, EnumC5360Iz7 enumC5360Iz7, boolean z, C7880To7 c7880To7, EnumC4543Fo6 enumC4543Fo6, InterfaceC10839cH7 interfaceC10839cH7) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(c9528a7, "requester");
        AbstractC13042fc3.i(enumC5360Iz7, "typingType");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        AbstractC13042fc3.i(interfaceC10839cH7, "fileType");
        C11458d25 c11458d25 = new C11458d25(exPeer);
        boolean z2 = (c11458d25.s() == W25.b || exPeer.getExPeerType() == ExPeerType.PRIVATE) && c7880To7 == null;
        if (z2) {
            this.b.U().D(c11458d25, enumC5360Iz7);
        }
        C9528a7 c9528a72 = this.g;
        if (c9528a72 != null) {
            c9528a72.e(new LK6(j2, j3, exPeer, str, str2, str3, l, enumC4543Fo6, interfaceC10839cH7, z, new e(z2, this, c11458d25, enumC5360Iz7, c9528a7, c7880To7), null), null);
        }
    }

    public final void a0(long j2, InterfaceC10223bH7 interfaceC10223bH7) {
        AbstractC13042fc3.i(interfaceC10223bH7, "callback");
        C9528a7 c9528a7 = this.g;
        if (c9528a7 != null) {
            c9528a7.d(new C12379eW5(j2, interfaceC10223bH7));
        }
    }

    public final void b0(long j2, ExPeer exPeer, String str, String str2, String str3, InterfaceC19401qH7 interfaceC19401qH7, EnumC4543Fo6 enumC4543Fo6, ir.nasim.tgwidgets.editor.messenger.H h) {
        AbstractC13042fc3.i(exPeer, "exPeer");
        AbstractC13042fc3.i(str, "descriptor");
        AbstractC13042fc3.i(str2, "fileName");
        AbstractC13042fc3.i(interfaceC19401qH7, "requester");
        AbstractC13042fc3.i(enumC4543Fo6, "sendType");
        C9528a7 c9528a7 = this.h;
        if (c9528a7 != null) {
            long jU = C11458d25.E(this.b.i0()).u();
            EnumC4543Fo6 enumC4543Fo62 = EnumC4543Fo6.c;
            c9528a7.e(new LK6(j2, jU, exPeer, str, str2, str3, null, enumC4543Fo6, enumC4543Fo6 == enumC4543Fo62 ? InterfaceC10839cH7.a.a : InterfaceC10839cH7.b.a, enumC4543Fo6 == enumC4543Fo62, interfaceC19401qH7, h), null);
        }
    }

    public final void c0() {
        this.d.L().e();
        this.f = C12736f7.n().g("actor/download/manager", C4614Fw5.d(new V6() { // from class: ir.nasim.fn2
            @Override // ir.nasim.V6
            public final K6 create() {
                return C14970in2.d0(this.a);
            }
        }).a("D_heavy"), true);
        this.h = C12736f7.n().f("actor/upload/manager/story", C4614Fw5.d(new V6() { // from class: ir.nasim.gn2
            @Override // ir.nasim.V6
            public final K6 create() {
                return C14970in2.e0(this.a);
            }
        }).a("D_heavy"));
        this.g = C12736f7.n().g("actor/upload/manager", C4614Fw5.d(new V6() { // from class: ir.nasim.hn2
            @Override // ir.nasim.V6
            public final K6 create() {
                return C14970in2.f0(this.a);
            }
        }).a("D_heavy"), true);
    }

    public final void g0(FileReference fileReference) {
        i0(this, fileReference, false, 2, null);
    }

    public final void h0(FileReference fileReference, boolean z) {
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(fileReference);
        c9528a7.d(new C9655aK6(fileReference, z));
    }

    public final void j0(long j2, InterfaceC8807Xk2 interfaceC8807Xk2, boolean z) {
        C9528a7 c9528a7 = this.f;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(interfaceC8807Xk2);
        c9528a7.d(new WA7(j2, z, interfaceC8807Xk2));
    }

    public final void k0(long j2, InterfaceC10223bH7 interfaceC10223bH7) {
        C9528a7 c9528a7 = this.g;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(interfaceC10223bH7);
        c9528a7.d(new XA7(j2, interfaceC10223bH7));
    }

    public final void l0(long j2, InterfaceC10223bH7 interfaceC10223bH7) {
        C9528a7 c9528a7 = this.h;
        AbstractC13042fc3.f(c9528a7);
        AbstractC13042fc3.f(interfaceC10223bH7);
        c9528a7.d(new XA7(j2, interfaceC10223bH7));
    }

    public final void m0(long j2, long j3) {
        C9528a7 c9528a7 = this.f;
        if (c9528a7 != null) {
            c9528a7.d(new DF7(j2, j3));
        }
    }
}
