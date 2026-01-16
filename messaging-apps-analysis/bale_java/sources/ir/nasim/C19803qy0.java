package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.call.ui.startOutGoingCall.StartOutGoingCallPeerData;

/* renamed from: ir.nasim.qy0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19803qy0 extends VW7 {
    private final C4627Fy0 b;
    private final int c;
    private final InterfaceC11621dJ7 d;
    private final C15874kK e;
    private final InterfaceC9336Zm4 f;
    private final InterfaceC10258bL6 g;
    private defpackage.y h;

    /* renamed from: ir.nasim.qy0$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19803qy0.this.new a(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[RETURN] */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                r29 = this;
                r0 = r29
                java.lang.Object r1 = ir.nasim.AbstractC13660gc3.e()
                int r2 = r0.c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L25
                if (r2 == r4) goto L1d
                if (r2 != r3) goto L15
                ir.nasim.AbstractC10685c16.b(r30)
                goto L91
            L15:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L1d:
                java.lang.Object r2 = r0.b
                ir.nasim.qy0 r2 = (ir.nasim.C19803qy0) r2
                ir.nasim.AbstractC10685c16.b(r30)
                goto L85
            L25:
                ir.nasim.AbstractC10685c16.b(r30)
                ir.nasim.qy0 r2 = ir.nasim.C19803qy0.this
                ir.nasim.Zm4 r2 = ir.nasim.C19803qy0.U0(r2)
            L2e:
                java.lang.Object r5 = r2.getValue()
                r6 = r5
                ir.nasim.oy0 r6 = (ir.nasim.C18621oy0) r6
                r27 = 524031(0x7feff, float:7.34324E-40)
                r28 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 1
                r16 = 0
                r17 = 0
                r18 = 0
                r19 = 0
                r20 = 0
                r22 = 0
                r23 = 0
                r24 = 0
                r25 = 0
                r26 = 0
                ir.nasim.oy0 r6 = ir.nasim.C18621oy0.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26, r27, r28)
                boolean r5 = r2.f(r5, r6)
                if (r5 == 0) goto L2e
                ir.nasim.qy0 r2 = ir.nasim.C19803qy0.this
                ir.nasim.bL6 r2 = r2.a1()
                java.lang.Object r2 = r2.getValue()
                ir.nasim.oy0 r2 = (ir.nasim.C18621oy0) r2
                java.lang.Long r2 = r2.c()
                if (r2 == 0) goto L91
                ir.nasim.qy0 r5 = ir.nasim.C19803qy0.this
                long r6 = r2.longValue()
                r0.b = r5
                r0.c = r4
                java.lang.Object r2 = ir.nasim.C19803qy0.W0(r5, r6, r0)
                if (r2 != r1) goto L84
                return r1
            L84:
                r2 = r5
            L85:
                r4 = 0
                r0.b = r4
                r0.c = r3
                java.lang.Object r2 = ir.nasim.C19803qy0.X0(r2, r0)
                if (r2 != r1) goto L91
                return r1
            L91:
                ir.nasim.rB7 r1 = ir.nasim.C19938rB7.a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19803qy0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qy0$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        int h;
        int i;
        int j;
        int k;
        int l;
        int m;
        int n;
        long o;
        int p;
        final /* synthetic */ int r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.r = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19803qy0.this.new b(this.r, interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00b9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00f4  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x012e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ba -> B:20:0x00cc). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r42) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19803qy0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qy0$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        Object c;
        Object d;
        Object e;
        int f;
        int g;
        int h;
        int i;
        int j;
        int k;
        int l;
        int m;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19803qy0.this.new c(interfaceC20295rm1);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0079 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00df  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x007a -> B:13:0x0085). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r37) {
            /*
                Method dump skipped, instructions count: 231
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19803qy0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qy0$d */
    static final class d extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        d(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI1 = C19803qy0.this.i1(0, this);
            return objI1 == AbstractC14862ic3.e() ? objI1 : C9475a16.a(objI1);
        }
    }

    /* renamed from: ir.nasim.qy0$e */
    static final class e implements InterfaceC4806Gq2 {
        e() {
        }

        @Override // ir.nasim.InterfaceC4806Gq2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object a(XV4 xv4, InterfaceC20295rm1 interfaceC20295rm1) {
            long jLongValue = ((Number) xv4.e()).longValue();
            Long lC = ((C18621oy0) C19803qy0.this.a1().getValue()).c();
            if (lC != null && jLongValue == lC.longValue()) {
                boolean zBooleanValue = ((Boolean) xv4.f()).booleanValue();
                InterfaceC9336Zm4 interfaceC9336Zm4 = C19803qy0.this.f;
                while (true) {
                    Object value = interfaceC9336Zm4.getValue();
                    C18621oy0 c18621oy0 = (C18621oy0) value;
                    InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
                    if (interfaceC9336Zm42.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : zBooleanValue, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : !zBooleanValue ? AbstractC6392Nk0.d(AbstractC12217eE5.nasim_call_preview_request_to_join_denied) : c18621oy0.l()))) {
                        break;
                    }
                    interfaceC9336Zm4 = interfaceC9336Zm42;
                }
            }
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qy0$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        f(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19803qy0.this.new f(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                Long lC = ((C18621oy0) C19803qy0.this.a1().getValue()).c();
                if (lC != null) {
                    C19803qy0 c19803qy0 = C19803qy0.this;
                    long jLongValue = lC.longValue();
                    C4627Fy0 c4627Fy0 = c19803qy0.b;
                    this.b = 1;
                    if (c4627Fy0.a1(jLongValue, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                ((C9475a16) obj).l();
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19803qy0(C4627Fy0 c4627Fy0, int i, InterfaceC11621dJ7 interfaceC11621dJ7, C15874kK c15874kK) {
        AbstractC13042fc3.i(c4627Fy0, "callRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(c15874kK, "askToJoinCallUseCase");
        this.b = c4627Fy0;
        this.c = i;
        this.d = interfaceC11621dJ7;
        this.e = c15874kK;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C18621oy0(null, null, null, false, false, false, false, false, false, false, null, null, null, 0L, null, 0, false, null, null, 524287, null));
        this.f = interfaceC9336Zm4A;
        this.g = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b1(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        return this.d.a(i, interfaceC20295rm1);
    }

    private final InterfaceC13730gj3 g1(int i) {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(i, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i1(int r9, ir.nasim.InterfaceC20295rm1 r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ir.nasim.C19803qy0.d
            if (r0 == 0) goto L14
            r0 = r10
            ir.nasim.qy0$d r0 = (ir.nasim.C19803qy0.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.c = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            ir.nasim.qy0$d r0 = new ir.nasim.qy0$d
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r5.a
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r5.c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.a16 r10 = (ir.nasim.C9475a16) r10
            java.lang.Object r9 = r10.l()
            goto L4c
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            ir.nasim.AbstractC10685c16.b(r10)
            ir.nasim.dJ7 r1 = r8.d
            long r9 = (long) r9
            r5.c = r2
            r4 = 0
            r6 = 2
            r7 = 0
            r2 = r9
            java.lang.Object r9 = ir.nasim.InterfaceC11621dJ7.q(r1, r2, r4, r5, r6, r7)
            if (r9 != r0) goto L4c
            return r0
        L4c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19803qy0.i1(int, ir.nasim.rm1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object l1(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = this.e.c(j, interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    private final void m1() {
        defpackage.y yVar = this.h;
        if (yVar != null) {
            yVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object p1(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objB = AbstractC6459Nq2.F(this.e.a()).b(new e(), interfaceC20295rm1);
        return objB == AbstractC14862ic3.e() ? objB : C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v1(C19803qy0 c19803qy0, boolean z) {
        Object value;
        C18621oy0 c18621oy0;
        AbstractC13042fc3.i(c19803qy0, "$this_run");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c19803qy0.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : z, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : null)));
        return C19938rB7.a;
    }

    public final InterfaceC13730gj3 Y0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
    }

    public final void Z0() {
        Object value;
        C18621oy0 c18621oy0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : ((C17448mz0) C18039nz0.a.d().getValue()).l(), (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : null)));
    }

    public final InterfaceC10258bL6 a1() {
        return this.g;
    }

    public final void c1(long j, String str, String str2, int i, long j2, boolean z, String str3) {
        Object value;
        C18621oy0 c18621oy0;
        AbstractC13042fc3.i(str, "callTitle");
        AbstractC13042fc3.i(str3, "callPreviewInfo");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : EnumC18030ny0.a, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : Long.valueOf(j), (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : z, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : str, (524031 & 4096) != 0 ? c18621oy0.m : str2, (524031 & 8192) != 0 ? c18621oy0.n : j2, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : i, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : str3, (524031 & 262144) != 0 ? c18621oy0.s : null)));
        g1(i);
    }

    public final void d1(StartOutGoingCallPeerData startOutGoingCallPeerData, String str, String str2) {
        AbstractC13042fc3.i(str2, "callPreviewInfo");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        while (true) {
            Object value = interfaceC9336Zm4.getValue();
            C18621oy0 c18621oy0 = (C18621oy0) value;
            InterfaceC9336Zm4 interfaceC9336Zm42 = interfaceC9336Zm4;
            if (interfaceC9336Zm42.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : EnumC18030ny0.b, (524031 & 2) != 0 ? c18621oy0.b : startOutGoingCallPeerData, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : str, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : str2, (524031 & 262144) != 0 ? c18621oy0.s : null))) {
                return;
            } else {
                interfaceC9336Zm4 = interfaceC9336Zm42;
            }
        }
    }

    public final boolean e1() {
        return ((C17448mz0) C18039nz0.a.d().getValue()).l();
    }

    public final void f1(Long l) {
        Object value;
        C18621oy0 c18621oy0;
        Object value2;
        C18621oy0 c18621oy02;
        if (l != null) {
            long jLongValue = l.longValue();
            if (this.b.M0(l.longValue())) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
                do {
                    value2 = interfaceC9336Zm4.getValue();
                    c18621oy02 = (C18621oy0) value2;
                } while (!interfaceC9336Zm4.f(value2, c18621oy02.a((524031 & 1) != 0 ? c18621oy02.a : null, (524031 & 2) != 0 ? c18621oy02.b : null, (524031 & 4) != 0 ? c18621oy02.c : null, (524031 & 8) != 0 ? c18621oy02.d : false, (524031 & 16) != 0 ? c18621oy02.e : false, (524031 & 32) != 0 ? c18621oy02.f : false, (524031 & 64) != 0 ? c18621oy02.g : false, (524031 & 128) != 0 ? c18621oy02.h : false, (524031 & 256) != 0 ? c18621oy02.i : false, (524031 & 512) != 0 ? c18621oy02.j : false, (524031 & 1024) != 0 ? c18621oy02.k : null, (524031 & 2048) != 0 ? c18621oy02.l : null, (524031 & 4096) != 0 ? c18621oy02.m : null, (524031 & 8192) != 0 ? c18621oy02.n : 0L, (524031 & 16384) != 0 ? c18621oy02.o : null, (32768 & 524031) != 0 ? c18621oy02.p : 0, (524031 & 65536) != 0 ? c18621oy02.q : false, (524031 & 131072) != 0 ? c18621oy02.r : null, (524031 & 262144) != 0 ? c18621oy02.s : Integer.valueOf(AbstractC12217eE5.nasim_call_preview_you_are_inside_call_error))));
                return;
            }
            if (e1()) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = this.f;
                do {
                    value = interfaceC9336Zm42.getValue();
                    c18621oy0 = (C18621oy0) value;
                } while (!interfaceC9336Zm42.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : Integer.valueOf(AbstractC12217eE5.nasim_call_preview_join_2_calls_error))));
                return;
            }
            C4627Fy0 c4627Fy0 = this.b;
            boolean z = ((C18621oy0) this.g.getValue()).h() == this.c;
            long jH = ((C18621oy0) this.g.getValue()).h();
            c4627Fy0.O0(jLongValue, z, Long.valueOf(jH), ((C18621oy0) this.g.getValue()).d(), ((C18621oy0) this.g.getValue()).k(), Long.valueOf(((C18621oy0) this.g.getValue()).g()), ((C18621oy0) this.g.getValue()).u(), ((C18621oy0) this.g.getValue()).s(), ((C18621oy0) this.g.getValue()).t());
        }
    }

    public final InterfaceC13730gj3 h1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void j1() {
        Object value;
        C18621oy0 c18621oy0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : true, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : Integer.valueOf(AbstractC12217eE5.nasim_call_preview_video_muted))));
    }

    public final void k1() {
        Object value;
        C18621oy0 c18621oy0;
        o1();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : true, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : Integer.valueOf(AbstractC12217eE5.nasim_call_preview_voice_muted))));
    }

    public final void o1() {
        Object value;
        C18621oy0 c18621oy0;
        defpackage.y yVar = this.h;
        if (yVar != null) {
            yVar.f();
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : null)));
    }

    public final void q1(boolean z) {
        Object value;
        C18621oy0 c18621oy0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : z, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : null)));
    }

    public final InterfaceC13730gj3 s1() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new f(null), 3, null);
    }

    public final void t1(boolean z) {
        Object value;
        C18621oy0 c18621oy0;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : true, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : z ? Integer.valueOf(AbstractC12217eE5.nasim_call_preview_video_unmuted) : ((C18621oy0) this.g.getValue()).l())));
    }

    public final void u1(boolean z) {
        Object value;
        C18621oy0 c18621oy0;
        if (this.h == null) {
            this.h = new defpackage.y(new UA2() { // from class: ir.nasim.py0
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return C19803qy0.v1(this.a, ((Boolean) obj).booleanValue());
                }
            });
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        m1();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.f;
        do {
            value = interfaceC9336Zm4.getValue();
            c18621oy0 = (C18621oy0) value;
        } while (!interfaceC9336Zm4.f(value, c18621oy0.a((524031 & 1) != 0 ? c18621oy0.a : null, (524031 & 2) != 0 ? c18621oy0.b : null, (524031 & 4) != 0 ? c18621oy0.c : null, (524031 & 8) != 0 ? c18621oy0.d : false, (524031 & 16) != 0 ? c18621oy0.e : false, (524031 & 32) != 0 ? c18621oy0.f : false, (524031 & 64) != 0 ? c18621oy0.g : false, (524031 & 128) != 0 ? c18621oy0.h : false, (524031 & 256) != 0 ? c18621oy0.i : false, (524031 & 512) != 0 ? c18621oy0.j : false, (524031 & 1024) != 0 ? c18621oy0.k : null, (524031 & 2048) != 0 ? c18621oy0.l : null, (524031 & 4096) != 0 ? c18621oy0.m : null, (524031 & 8192) != 0 ? c18621oy0.n : 0L, (524031 & 16384) != 0 ? c18621oy0.o : null, (32768 & 524031) != 0 ? c18621oy0.p : 0, (524031 & 65536) != 0 ? c18621oy0.q : false, (524031 & 131072) != 0 ? c18621oy0.r : null, (524031 & 262144) != 0 ? c18621oy0.s : z ? Integer.valueOf(AbstractC12217eE5.nasim_call_preview_voice_unmuted) : ((C18621oy0) this.g.getValue()).l())));
    }
}
