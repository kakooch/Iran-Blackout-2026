package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.InterfaceC13730gj3;

/* renamed from: ir.nasim.gU7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13590gU7 {
    private final AbstractC13778go1 a;
    private final InterfaceC20315ro1 b;
    private InterfaceC13730gj3 c;
    private long d;
    private long e;
    private long f;
    private long g;

    /* renamed from: ir.nasim.gU7$a */
    static final class a extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C13590gU7.this.j(null, false, this);
        }
    }

    /* renamed from: ir.nasim.gU7$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(com.google.android.exoplayer2.E0 e0, C11637dL5 c11637dL5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = c11637dL5;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new b(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13590gU7 c13590gU7 = C13590gU7.this;
                com.google.android.exoplayer2.E0 e0 = this.d;
                int i2 = this.e.a;
                boolean z = this.f;
                this.b = 1;
                if (c13590gU7.o(e0, i2, false, z, this) == objE) {
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

    /* renamed from: ir.nasim.gU7$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(com.google.android.exoplayer2.E0 e0, C11637dL5 c11637dL5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = c11637dL5;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new c(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13590gU7 c13590gU7 = C13590gU7.this;
                com.google.android.exoplayer2.E0 e0 = this.d;
                int i2 = this.e.a;
                boolean z = this.f;
                this.b = 1;
                if (c13590gU7.o(e0, i2, false, z, this) == objE) {
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

    /* renamed from: ir.nasim.gU7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.google.android.exoplayer2.E0 e0, C11637dL5 c11637dL5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = c11637dL5;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13590gU7 c13590gU7 = C13590gU7.this;
                com.google.android.exoplayer2.E0 e0 = this.d;
                int i2 = this.e.a;
                boolean z = this.f;
                this.b = 1;
                if (c13590gU7.o(e0, i2, false, z, this) == objE) {
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

    /* renamed from: ir.nasim.gU7$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        boolean d;
        /* synthetic */ Object e;
        int g;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C13590gU7.this.k(null, false, this);
        }
    }

    /* renamed from: ir.nasim.gU7$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(com.google.android.exoplayer2.E0 e0, C11637dL5 c11637dL5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = c11637dL5;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new f(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13590gU7 c13590gU7 = C13590gU7.this;
                com.google.android.exoplayer2.E0 e0 = this.d;
                int i2 = this.e.a - 1;
                boolean z = this.f;
                this.b = 1;
                if (c13590gU7.o(e0, i2, true, z, this) == objE) {
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

    /* renamed from: ir.nasim.gU7$g */
    static final class g extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ C11637dL5 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(com.google.android.exoplayer2.E0 e0, C11637dL5 c11637dL5, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = c11637dL5;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new g(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C13590gU7 c13590gU7 = C13590gU7.this;
                com.google.android.exoplayer2.E0 e0 = this.d;
                int i2 = this.e.a - 1;
                boolean z = this.f;
                this.b = 1;
                if (c13590gU7.o(e0, i2, true, z, this) == objE) {
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
            return ((g) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gU7$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ com.google.android.exoplayer2.E0 d;
        final /* synthetic */ boolean e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(com.google.android.exoplayer2.E0 e0, boolean z, boolean z2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = e0;
            this.e = z;
            this.f = z2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C13590gU7.this.new h(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                long jCurrentTimeMillis = System.currentTimeMillis();
                C13590gU7.this.d = jCurrentTimeMillis;
                C13590gU7.this.f = jCurrentTimeMillis;
                C13590gU7.this.e = this.d.D0();
                C13590gU7.this.g = this.d.D0();
                if (this.e) {
                    C13590gU7 c13590gU7 = C13590gU7.this;
                    com.google.android.exoplayer2.E0 e0 = this.d;
                    boolean z = this.f;
                    this.b = 1;
                    if (c13590gU7.k(e0, z, this) == objE) {
                        return objE;
                    }
                } else {
                    C13590gU7 c13590gU72 = C13590gU7.this;
                    com.google.android.exoplayer2.E0 e02 = this.d;
                    boolean z2 = this.f;
                    this.b = 2;
                    if (c13590gU72.j(e02, z2, this) == objE) {
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
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.gU7$i */
    static final class i extends AbstractC22163um1 {
        Object a;
        Object b;
        int c;
        boolean d;
        boolean e;
        /* synthetic */ Object f;
        int h;

        i(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= RecyclerView.UNDEFINED_DURATION;
            return C13590gU7.this.o(null, 0, false, false, this);
        }
    }

    public C13590gU7(AbstractC13778go1 abstractC13778go1, InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
        AbstractC13042fc3.i(interfaceC20315ro1, "coroutineScope");
        this.a = abstractC13778go1;
        this.b = interfaceC20315ro1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e2 A[PHI: r0
      0x00e2: PHI (r0v9 java.lang.Object) = (r0v8 java.lang.Object), (r0v1 java.lang.Object) binds: [B:29:0x00df, B:14:0x0033] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(com.google.android.exoplayer2.E0 r22, boolean r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13590gU7.j(com.google.android.exoplayer2.E0, boolean, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(com.google.android.exoplayer2.E0 r24, boolean r25, ir.nasim.InterfaceC20295rm1 r26) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13590gU7.k(com.google.android.exoplayer2.E0, boolean, ir.nasim.rm1):java.lang.Object");
    }

    private final void l(com.google.android.exoplayer2.E0 e0, float f2, boolean z) {
        if (z) {
            e0.x(this.g);
        } else {
            e0.x(e0.D0());
        }
        e0.Q0(f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(C13590gU7 c13590gU7, com.google.android.exoplayer2.E0 e0, float f2, boolean z, Throwable th) {
        AbstractC13042fc3.i(c13590gU7, "this$0");
        AbstractC13042fc3.i(e0, "$player");
        c13590gU7.l(e0, f2, z);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00e0 -> B:44:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(com.google.android.exoplayer2.E0 r19, int r20, boolean r21, boolean r22, ir.nasim.InterfaceC20295rm1 r23) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C13590gU7.o(com.google.android.exoplayer2.E0, int, boolean, boolean, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean i() {
        InterfaceC13730gj3 interfaceC13730gj3 = this.c;
        if (interfaceC13730gj3 == null) {
            return false;
        }
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        this.c = null;
        return true;
    }

    public final boolean m(boolean z, final com.google.android.exoplayer2.E0 e0) {
        AbstractC13042fc3.i(e0, "player");
        if (this.c != null) {
            return false;
        }
        final float f2 = e0.c().a;
        final boolean z2 = (z && e0.i()) ? false : true;
        InterfaceC13730gj3 interfaceC13730gj3D = AbstractC10533bm0.d(this.b, this.a, null, new h(e0, z, z2, null), 2, null);
        interfaceC13730gj3D.s(new UA2() { // from class: ir.nasim.dU7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C13590gU7.n(this.a, e0, f2, z2, (Throwable) obj);
            }
        });
        this.c = interfaceC13730gj3D;
        return true;
    }
}
