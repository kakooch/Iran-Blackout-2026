package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.Z06;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.lI2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16450lI2 {
    public static final a f = new a(null);
    public static final int g = 8;
    private static final InterfaceC8327Vm4 h = AbstractC11420cy6.b(0, 1, EnumC6162Ml0.DROP_OLDEST, 1, null);
    private final InterfaceC5377Jb6 a;
    private final C15859kI2 b;
    private final InterfaceC3570Bk5 c;
    private final C10218bH2 d;
    private final AbstractC13778go1 e;

    /* renamed from: ir.nasim.lI2$a */
    public static final class a {
        private a() {
        }

        public final InterfaceC8327Vm4 a() {
            return C16450lI2.h;
        }

        public final void b() {
            C19406qI3.a("GifsRepository", "handle update", new Object[0]);
            AbstractC5969Lp4.e().c().g("should_refresh_saved_gifs", true);
            a().c(Boolean.TRUE);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.lI2$b */
    static final class b extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objF = C16450lI2.this.f(0L, 0L, 0, null, null, this);
            return objF == AbstractC14862ic3.e() ? objF : C9475a16.a(objF);
        }
    }

    /* renamed from: ir.nasim.lI2$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ byte[] h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, long j2, int i, String str, byte[] bArr, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = i;
            this.g = str;
            this.h = bArr;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16450lI2.this.new c(this.d, this.e, this.f, this.g, this.h, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15859kI2 c15859kI2 = C16450lI2.this.b;
                long j = this.d;
                long j2 = this.e;
                int i2 = this.f;
                String str = this.g;
                byte[] bArr = this.h;
                this.b = 1;
                obj = c15859kI2.a(j, j2, i2, str, bArr, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C19406qI3.a("GifsRepository", "addGifToSaved success", new Object[0]);
                return C9475a16.a(C9475a16.b(null));
            }
            if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            Z06.a aVar = (Z06.a) z06;
            C19406qI3.a("GifsRepository", "addGifToSaved failure: " + aVar.a(), new Object[0]);
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.a(C9475a16.b(AbstractC10685c16.a(aVar.a())));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lI2$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ String d;
        final /* synthetic */ C16450lI2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, C16450lI2 c16450lI2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = c16450lI2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00a7 -> B:38:0x00aa). Please report as a decompilation issue!!! */
        @Override // ir.nasim.E90
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16450lI2.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lI2$e */
    static final class e extends AbstractC22163um1 {
        /* synthetic */ Object a;
        int c;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= RecyclerView.UNDEFINED_DURATION;
            Object objI = C16450lI2.this.i(0L, 0L, 0, this);
            return objI == AbstractC14862ic3.e() ? objI : C9475a16.a(objI);
        }
    }

    /* renamed from: ir.nasim.lI2$f */
    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j, long j2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16450lI2.this.new f(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15859kI2 c15859kI2 = C16450lI2.this.b;
                long j = this.d;
                long j2 = this.e;
                int i2 = this.f;
                this.b = 1;
                obj = c15859kI2.c(j, j2, i2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C19406qI3.a("GifsRepository", "removeGifFromSaved success", new Object[0]);
                return C9475a16.a(C9475a16.b(null));
            }
            if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            Z06.a aVar = (Z06.a) z06;
            C19406qI3.a("GifsRepository", "removeGifFromSaved failure: " + aVar.a(), new Object[0]);
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.a(C9475a16.b(aVar.a()));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.lI2$g */
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
            Object objK = C16450lI2.this.k(0L, 0L, 0, this);
            return objK == AbstractC14862ic3.e() ? objK : C9475a16.a(objK);
        }
    }

    /* renamed from: ir.nasim.lI2$h */
    static final class h extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ long d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j, long j2, int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = j;
            this.e = j2;
            this.f = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C16450lI2.this.new h(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C15859kI2 c15859kI2 = C16450lI2.this.b;
                long j = this.d;
                long j2 = this.e;
                int i2 = this.f;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.b = 1;
                obj = c15859kI2.d(j, j2, i2, jCurrentTimeMillis, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            Z06 z06 = (Z06) obj;
            if (z06 instanceof Z06.b) {
                C19406qI3.a("GifsRepository", "useGif success", new Object[0]);
                C16450lI2.this.c.g("should_refresh_saved_gifs", true);
                return C9475a16.a(C9475a16.b(null));
            }
            if (!(z06 instanceof Z06.a)) {
                throw new NoWhenBranchMatchedException();
            }
            Z06.a aVar = (Z06.a) z06;
            C19406qI3.a("GifsRepository", "useGif failure: " + aVar.a(), new Object[0]);
            C9475a16.a aVar2 = C9475a16.b;
            return C9475a16.a(C9475a16.b(AbstractC10685c16.a(aVar.a())));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((h) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C16450lI2(InterfaceC5377Jb6 interfaceC5377Jb6, C15859kI2 c15859kI2, InterfaceC3570Bk5 interfaceC3570Bk5, C10218bH2 c10218bH2, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(interfaceC5377Jb6, "savedGifDao");
        AbstractC13042fc3.i(c15859kI2, "gifsRemoteService");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(c10218bH2, "gifDescriptorToGifEntityMapper");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.a = interfaceC5377Jb6;
        this.b = c15859kI2;
        this.c = interfaceC3570Bk5;
        this.d = c10218bH2;
        this.e = abstractC13778go1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(long r17, long r19, int r21, java.lang.String r22, byte[] r23, ir.nasim.InterfaceC20295rm1 r24) {
        /*
            r16 = this;
            r10 = r16
            r0 = r24
            boolean r1 = r0 instanceof ir.nasim.C16450lI2.b
            if (r1 == 0) goto L18
            r1 = r0
            ir.nasim.lI2$b r1 = (ir.nasim.C16450lI2.b) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.c = r2
        L16:
            r11 = r1
            goto L1e
        L18:
            ir.nasim.lI2$b r1 = new ir.nasim.lI2$b
            r1.<init>(r0)
            goto L16
        L1e:
            java.lang.Object r0 = r11.a
            java.lang.Object r12 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r11.c
            r13 = 1
            if (r1 == 0) goto L37
            if (r1 != r13) goto L2f
            ir.nasim.AbstractC10685c16.b(r0)
            goto L62
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            ir.nasim.AbstractC10685c16.b(r0)
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "GifsRepository"
            java.lang.String r2 = "addGifToSaved"
            ir.nasim.C19406qI3.a(r1, r2, r0)
            ir.nasim.go1 r14 = r10.e
            ir.nasim.lI2$c r15 = new ir.nasim.lI2$c
            r9 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r4 = r19
            r6 = r21
            r7 = r22
            r8 = r23
            r0.<init>(r2, r4, r6, r7, r8, r9)
            r11.c = r13
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r14, r15, r11)
            if (r0 != r12) goto L62
            return r12
        L62:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16450lI2.f(long, long, int, java.lang.String, byte[], ir.nasim.rm1):java.lang.Object");
    }

    public final InterfaceC4557Fq2 g() {
        C19406qI3.a("GifsRepository", "getSavedGifs", new Object[0]);
        return this.a.d();
    }

    public final Object h(String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objG = AbstractC9323Zl0.g(this.e, new d(str, this, null), interfaceC20295rm1);
        return objG == AbstractC14862ic3.e() ? objG : C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(long r15, long r17, int r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r14 = this;
            r8 = r14
            r0 = r20
            boolean r1 = r0 instanceof ir.nasim.C16450lI2.e
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.lI2$e r1 = (ir.nasim.C16450lI2.e) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r9 = r1
            goto L1d
        L17:
            ir.nasim.lI2$e r1 = new ir.nasim.lI2$e
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r9.a
            java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r9.c
            r11 = 1
            if (r1 == 0) goto L36
            if (r1 != r11) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L51
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r12 = r8.e
            ir.nasim.lI2$f r13 = new ir.nasim.lI2$f
            r7 = 0
            r0 = r13
            r1 = r14
            r2 = r15
            r4 = r17
            r6 = r19
            r0.<init>(r2, r4, r6, r7)
            r9.c = r11
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r12, r13, r9)
            if (r0 != r10) goto L51
            return r10
        L51:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16450lI2.i(long, long, int, ir.nasim.rm1):java.lang.Object");
    }

    public final boolean j() {
        return this.c.h("should_refresh_saved_gifs", true);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(long r15, long r17, int r19, ir.nasim.InterfaceC20295rm1 r20) {
        /*
            r14 = this;
            r8 = r14
            r0 = r20
            boolean r1 = r0 instanceof ir.nasim.C16450lI2.g
            if (r1 == 0) goto L17
            r1 = r0
            ir.nasim.lI2$g r1 = (ir.nasim.C16450lI2.g) r1
            int r2 = r1.c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.c = r2
        L15:
            r9 = r1
            goto L1d
        L17:
            ir.nasim.lI2$g r1 = new ir.nasim.lI2$g
            r1.<init>(r0)
            goto L15
        L1d:
            java.lang.Object r0 = r9.a
            java.lang.Object r10 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r9.c
            r11 = 1
            if (r1 == 0) goto L36
            if (r1 != r11) goto L2e
            ir.nasim.AbstractC10685c16.b(r0)
            goto L51
        L2e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L36:
            ir.nasim.AbstractC10685c16.b(r0)
            ir.nasim.go1 r12 = r8.e
            ir.nasim.lI2$h r13 = new ir.nasim.lI2$h
            r7 = 0
            r0 = r13
            r1 = r14
            r2 = r15
            r4 = r17
            r6 = r19
            r0.<init>(r2, r4, r6, r7)
            r9.c = r11
            java.lang.Object r0 = ir.nasim.AbstractC9323Zl0.g(r12, r13, r9)
            if (r0 != r10) goto L51
            return r10
        L51:
            ir.nasim.a16 r0 = (ir.nasim.C9475a16) r0
            java.lang.Object r0 = r0.l()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16450lI2.k(long, long, int, ir.nasim.rm1):java.lang.Object");
    }
}
