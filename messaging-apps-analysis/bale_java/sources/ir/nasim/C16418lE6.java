package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC6693Oo5;

/* renamed from: ir.nasim.lE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16418lE6 {
    public static final C16418lE6 a = new C16418lE6();
    private static final float b;
    private static final float c;
    private static final V05 d;

    /* renamed from: ir.nasim.lE6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC18507om4 c;
        final /* synthetic */ C14063hH6 d;

        /* renamed from: ir.nasim.lE6$a$a, reason: collision with other inner class name */
        static final class C1369a implements InterfaceC4806Gq2 {
            final /* synthetic */ C14063hH6 a;

            C1369a(C14063hH6 c14063hH6) {
                this.a = c14063hH6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                    this.a.remove(((InterfaceC6693Oo5.c) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                    this.a.remove(((InterfaceC6693Oo5.a) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof GZ1) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof HZ1) {
                    this.a.remove(((HZ1) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof FZ1) {
                    this.a.remove(((FZ1) interfaceC22645vb3).a());
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC18507om4 interfaceC18507om4, C14063hH6 c14063hH6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC18507om4;
            this.d = c14063hH6;
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
                InterfaceC4557Fq2 interfaceC4557Fq2B = this.c.b();
                C1369a c1369a = new C1369a(this.d);
                this.b = 1;
                if (interfaceC4557Fq2B.b(c1369a, this) == objE) {
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

    /* renamed from: ir.nasim.lE6$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC18507om4 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ C15236jE6 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ long j;
        final /* synthetic */ int k;
        final /* synthetic */ int l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC18507om4 interfaceC18507om4, androidx.compose.ui.e eVar, C15236jE6 c15236jE6, boolean z, long j, int i, int i2) {
            super(2);
            this.f = interfaceC18507om4;
            this.g = eVar;
            this.h = c15236jE6;
            this.i = z;
            this.j = j;
            this.k = i;
            this.l = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C16418lE6.this.a(this.f, this.g, this.h, this.i, this.j, interfaceC22053ub1, QJ5.a(this.k | 1), this.l);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lE6$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C15236jE6 e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C15236jE6 c15236jE6, boolean z) {
            super(2);
            this.e = c15236jE6;
            this.f = z;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02, long j) {
            C16418lE6 c16418lE6 = C16418lE6.a;
            c16418lE6.g(interfaceC17460n02, j, c16418lE6.l(), this.e.d(this.f, true));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC17460n02) obj, ((ZG4) obj2).t());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lE6$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        public static final d e = new d();

        d() {
            super(3);
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02, long j, long j2) {
            C16418lE6 c16418lE6 = C16418lE6.a;
            c16418lE6.g(interfaceC17460n02, j, c16418lE6.k(), j2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC17460n02) obj, ((ZG4) obj2).t(), ((C24381yX0) obj3).y());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lE6$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C17600nE6 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ float j;
        final /* synthetic */ float k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC15796kB2 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C17600nE6 c17600nE6, long j, long j2, long j3, long j4, float f, float f2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2) {
            super(1);
            this.e = c17600nE6;
            this.f = j;
            this.g = j2;
            this.h = j3;
            this.i = j4;
            this.j = f;
            this.k = f2;
            this.l = interfaceC14603iB2;
            this.m = interfaceC15796kB2;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            C16418lE6.a.h(interfaceC17460n02, this.e.n(), 0.0f, this.e.f(), this.f, this.g, this.h, this.i, interfaceC17460n02.o1(this.e.p()), interfaceC17460n02.D(0), interfaceC17460n02.o1(this.e.m()), this.j, this.k, this.l, this.m, false);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lE6$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C17600nE6 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ C15236jE6 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC15796kB2 k;
        final /* synthetic */ float l;
        final /* synthetic */ float m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C17600nE6 c17600nE6, androidx.compose.ui.e eVar, boolean z, C15236jE6 c15236jE6, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC15796kB2 interfaceC15796kB2, float f, float f2, int i, int i2) {
            super(2);
            this.f = c17600nE6;
            this.g = eVar;
            this.h = z;
            this.i = c15236jE6;
            this.j = interfaceC14603iB2;
            this.k = interfaceC15796kB2;
            this.l = f;
            this.m = f2;
            this.n = i;
            this.o = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C16418lE6.this.b(this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC22053ub1, QJ5.a(this.n | 1), this.o);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        C18191oE6 c18191oE6 = C18191oE6.a;
        b = c18191oE6.o();
        c = c18191oE6.o();
        d = AbstractC21611tq.a();
    }

    private C16418lE6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(InterfaceC17460n02 interfaceC17460n02, long j, float f2, long j2) {
        InterfaceC17460n02.L(interfaceC17460n02, j2, interfaceC17460n02.w1(f2) / 2.0f, j, 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(ir.nasim.InterfaceC17460n02 r31, float[] r32, float r33, float r34, long r35, long r37, long r39, long r41, float r43, float r44, float r45, float r46, float r47, ir.nasim.InterfaceC14603iB2 r48, ir.nasim.InterfaceC15796kB2 r49, boolean r50) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16418lE6.h(ir.nasim.n02, float[], float, float, long, long, long, long, float, float, float, float, float, ir.nasim.iB2, ir.nasim.kB2, boolean):void");
    }

    private final void i(InterfaceC17460n02 interfaceC17460n02, long j, long j2, long j3, float f2, float f3) {
        long jA = AbstractC9108Yn1.a(f2, f2);
        long jA2 = AbstractC9108Yn1.a(f3, f3);
        I46 i46B = J46.b(FK5.b(AbstractC10836cH4.a(ZG4.m(j), 0.0f), UD6.a(OD6.i(j2), OD6.g(j2))), jA, jA2, jA2, jA);
        V05 v05 = d;
        V05.p(v05, i46B, null, 2, null);
        InterfaceC17460n02.X0(interfaceC17460n02, v05, j3, 0.0f, null, null, 0, 60, null);
        v05.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(ir.nasim.InterfaceC18507om4 r24, androidx.compose.ui.e r25, ir.nasim.C15236jE6 r26, boolean r27, long r28, ir.nasim.InterfaceC22053ub1 r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16418lE6.a(ir.nasim.om4, androidx.compose.ui.e, ir.nasim.jE6, boolean, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x026a A[PHI: r2 r29
      0x026a: PHI (r2v12 ir.nasim.iB2) = (r2v10 ir.nasim.iB2), (r2v13 ir.nasim.iB2) binds: [B:178:0x0268, B:175:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x026a: PHI (r29v4 boolean) = (r29v2 boolean), (r29v5 boolean) binds: [B:178:0x0268, B:175:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(ir.nasim.C17600nE6 r28, androidx.compose.ui.e r29, boolean r30, ir.nasim.C15236jE6 r31, ir.nasim.InterfaceC14603iB2 r32, ir.nasim.InterfaceC15796kB2 r33, float r34, float r35, ir.nasim.InterfaceC22053ub1 r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 727
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16418lE6.b(ir.nasim.nE6, androidx.compose.ui.e, boolean, ir.nasim.jE6, ir.nasim.iB2, ir.nasim.kB2, float, float, ir.nasim.ub1, int, int):void");
    }

    public final C15236jE6 e(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:845)");
        }
        C15236jE6 c15236jE6J = j(C15386jV3.a.a(interfaceC22053ub1, 6));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c15236jE6J;
    }

    public final C15236jE6 f(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3) {
        long j11;
        long j12;
        long jI = (i3 & 1) != 0 ? C24381yX0.b.i() : j;
        long jI2 = (i3 & 2) != 0 ? C24381yX0.b.i() : j2;
        long jI3 = (i3 & 4) != 0 ? C24381yX0.b.i() : j3;
        long jI4 = (i3 & 8) != 0 ? C24381yX0.b.i() : j4;
        long jI5 = (i3 & 16) != 0 ? C24381yX0.b.i() : j5;
        long jI6 = (i3 & 32) != 0 ? C24381yX0.b.i() : j6;
        long jI7 = (i3 & 64) != 0 ? C24381yX0.b.i() : j7;
        long jI8 = (i3 & 128) != 0 ? C24381yX0.b.i() : j8;
        long jI9 = (i3 & 256) != 0 ? C24381yX0.b.i() : j9;
        long jI10 = (i3 & 512) != 0 ? C24381yX0.b.i() : j10;
        if (AbstractC5138Ib1.I()) {
            j12 = jI9;
            j11 = jI7;
            AbstractC5138Ib1.Q(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:887)");
        } else {
            j11 = jI7;
            j12 = jI9;
        }
        C15236jE6 c15236jE6A = j(C15386jV3.a.a(interfaceC22053ub1, 6)).a(jI, jI2, jI3, jI4, jI5, jI6, j11, jI8, j12, jI10);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c15236jE6A;
    }

    public final C15236jE6 j(XX0 xx0) {
        C15236jE6 c15236jE6I = xx0.i();
        if (c15236jE6I != null) {
            return c15236jE6I;
        }
        C18191oE6 c18191oE6 = C18191oE6.a;
        C15236jE6 c15236jE6 = new C15236jE6(ZX0.d(xx0, c18191oE6.i()), ZX0.d(xx0, c18191oE6.b()), ZX0.d(xx0, c18191oE6.m()), ZX0.d(xx0, c18191oE6.m()), ZX0.d(xx0, c18191oE6.b()), DX0.h(C24381yX0.o(ZX0.d(xx0, c18191oE6.e()), c18191oE6.f(), 0.0f, 0.0f, 0.0f, 14, null), xx0.H()), C24381yX0.o(ZX0.d(xx0, c18191oE6.c()), c18191oE6.d(), 0.0f, 0.0f, 0.0f, 14, null), C24381yX0.o(ZX0.d(xx0, c18191oE6.g()), c18191oE6.h(), 0.0f, 0.0f, 0.0f, 14, null), C24381yX0.o(ZX0.d(xx0, c18191oE6.g()), c18191oE6.h(), 0.0f, 0.0f, 0.0f, 14, null), C24381yX0.o(ZX0.d(xx0, c18191oE6.c()), c18191oE6.d(), 0.0f, 0.0f, 0.0f, 14, null), null);
        xx0.a0(c15236jE6);
        return c15236jE6;
    }

    public final float k() {
        return c;
    }

    public final float l() {
        return b;
    }
}
