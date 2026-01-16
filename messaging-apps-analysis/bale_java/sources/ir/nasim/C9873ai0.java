package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10274bN4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.ai0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9873ai0 extends RG1 {
    private C9053Yh0 q;
    private float r;
    private AbstractC12520el0 s;
    private InterfaceC10031ax6 t;
    private final InterfaceC14380hp0 u;

    /* renamed from: ir.nasim.ai0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC10274bN4.a e;
        final /* synthetic */ AbstractC12520el0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractC10274bN4.a aVar, AbstractC12520el0 abstractC12520el0) {
            super(1);
            this.e = aVar;
            this.f = abstractC12520el0;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            InterfaceC17460n02.G0(interfaceC23919xk1, this.e.b(), this.f, 0.0f, null, null, 0, 60, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ai0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ CK5 e;
        final /* synthetic */ C12889fL5 f;
        final /* synthetic */ long g;
        final /* synthetic */ AbstractC24975zX0 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CK5 ck5, C12889fL5 c12889fL5, long j, AbstractC24975zX0 abstractC24975zX0) {
            super(1);
            this.e = ck5;
            this.f = c12889fL5;
            this.g = j;
            this.h = abstractC24975zX0;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            float fI = this.e.i();
            float fL = this.e.l();
            C12889fL5 c12889fL5 = this.f;
            long j = this.g;
            AbstractC24975zX0 abstractC24975zX0 = this.h;
            interfaceC23919xk1.z1().b().c(fI, fL);
            try {
                InterfaceC17460n02.H1(interfaceC23919xk1, (Y03) c12889fL5.a, 0L, j, 0L, 0L, 0.0f, null, abstractC24975zX0, 0, 0, 890, null);
            } finally {
                interfaceC23919xk1.z1().b().c(-fI, -fL);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ai0$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ AbstractC12520el0 f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ float i;
        final /* synthetic */ long j;
        final /* synthetic */ long k;
        final /* synthetic */ C23815xZ6 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, AbstractC12520el0 abstractC12520el0, long j, float f, float f2, long j2, long j3, C23815xZ6 c23815xZ6) {
            super(1);
            this.e = z;
            this.f = abstractC12520el0;
            this.g = j;
            this.h = f;
            this.i = f2;
            this.j = j2;
            this.k = j3;
            this.l = c23815xZ6;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) throws Throwable {
            long j;
            YZ1 yz1;
            interfaceC23919xk1.N1();
            if (this.e) {
                InterfaceC17460n02.d0(interfaceC23919xk1, this.f, 0L, 0L, this.g, 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, null);
                return;
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (this.g >> 32));
            float f = this.h;
            if (fIntBitsToFloat >= f) {
                InterfaceC17460n02.d0(interfaceC23919xk1, this.f, this.j, this.k, AbstractC9287Zh0.l(this.g, f), 0.0f, this.l, null, 0, 208, null);
                return;
            }
            float f2 = this.i;
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC23919xk1.d() >> 32)) - this.i;
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (interfaceC23919xk1.d() & 4294967295L)) - this.i;
            int iA = GV0.a.a();
            AbstractC12520el0 abstractC12520el0 = this.f;
            long j2 = this.g;
            YZ1 yz1Z1 = interfaceC23919xk1.z1();
            long jD = yz1Z1.d();
            yz1Z1.e().n();
            try {
                yz1Z1.b().b(f2, f2, fIntBitsToFloat2, fIntBitsToFloat3, iA);
                j = jD;
                yz1 = yz1Z1;
                try {
                    InterfaceC17460n02.d0(interfaceC23919xk1, abstractC12520el0, 0L, 0L, j2, 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.LOAD_STICKER_COLLECTION_FIELD_NUMBER, null);
                    yz1.e().i();
                    yz1.g(j);
                } catch (Throwable th) {
                    th = th;
                    yz1.e().i();
                    yz1.g(j);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                j = jD;
                yz1 = yz1Z1;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ai0$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ V05 e;
        final /* synthetic */ AbstractC12520el0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(V05 v05, AbstractC12520el0 abstractC12520el0) {
            super(1);
            this.e = v05;
            this.f = abstractC12520el0;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            InterfaceC17460n02.G0(interfaceC23919xk1, this.e, this.f, 0.0f, null, null, 0, 60, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ai0$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C16869m02 invoke(C14988ip0 c14988ip0) {
            if (c14988ip0.w1(C9873ai0.this.H2()) < 0.0f || OD6.h(c14988ip0.d()) <= 0.0f) {
                return AbstractC9287Zh0.j(c14988ip0);
            }
            float f = 2;
            float fMin = Math.min(C17784nZ1.s(C9873ai0.this.H2(), C17784nZ1.b.a()) ? 1.0f : (float) Math.ceil(c14988ip0.w1(C9873ai0.this.H2())), (float) Math.ceil(OD6.h(c14988ip0.d()) / f));
            float f2 = fMin / f;
            long jE = ZG4.e((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
            float fIntBitsToFloat = Float.intBitsToFloat((int) (c14988ip0.d() >> 32)) - fMin;
            long jD = OD6.d((Float.floatToRawIntBits(Float.intBitsToFloat((int) (c14988ip0.d() & 4294967295L)) - fMin) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
            boolean z = f * fMin > OD6.h(c14988ip0.d());
            AbstractC10274bN4 abstractC10274bN4A = C9873ai0.this.G2().a(c14988ip0.d(), c14988ip0.getLayoutDirection(), c14988ip0);
            if (abstractC10274bN4A instanceof AbstractC10274bN4.a) {
                C9873ai0 c9873ai0 = C9873ai0.this;
                return c9873ai0.D2(c14988ip0, c9873ai0.F2(), (AbstractC10274bN4.a) abstractC10274bN4A, z, fMin);
            }
            if (abstractC10274bN4A instanceof AbstractC10274bN4.c) {
                C9873ai0 c9873ai02 = C9873ai0.this;
                return c9873ai02.E2(c14988ip0, c9873ai02.F2(), (AbstractC10274bN4.c) abstractC10274bN4A, jE, jD, z, fMin);
            }
            if (abstractC10274bN4A instanceof AbstractC10274bN4.b) {
                return AbstractC9287Zh0.k(c14988ip0, C9873ai0.this.F2(), jE, jD, z, fMin);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ C9873ai0(float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6, ED1 ed1) {
        this(f, abstractC12520el0, interfaceC10031ax6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ir.nasim.C16869m02 D2(ir.nasim.C14988ip0 r50, ir.nasim.AbstractC12520el0 r51, ir.nasim.AbstractC10274bN4.a r52, boolean r53, float r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C9873ai0.D2(ir.nasim.ip0, ir.nasim.el0, ir.nasim.bN4$a, boolean, float):ir.nasim.m02");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C16869m02 E2(C14988ip0 c14988ip0, AbstractC12520el0 abstractC12520el0, AbstractC10274bN4.c cVar, long j, long j2, boolean z, float f) {
        if (J46.e(cVar.b())) {
            return c14988ip0.h(new c(z, abstractC12520el0, cVar.b().h(), f / 2, f, j, j2, new C23815xZ6(f, 0.0f, 0, 0, null, 30, null)));
        }
        if (this.q == null) {
            this.q = new C9053Yh0(null, null, null, null, 15, null);
        }
        C9053Yh0 c9053Yh0 = this.q;
        AbstractC13042fc3.f(c9053Yh0);
        return c14988ip0.h(new d(AbstractC9287Zh0.i(c9053Yh0.g(), cVar.b(), f, z), abstractC12520el0));
    }

    public final AbstractC12520el0 F2() {
        return this.s;
    }

    public final InterfaceC10031ax6 G2() {
        return this.t;
    }

    public final float H2() {
        return this.r;
    }

    public final void I2(AbstractC12520el0 abstractC12520el0) {
        if (AbstractC13042fc3.d(this.s, abstractC12520el0)) {
            return;
        }
        this.s = abstractC12520el0;
        this.u.W0();
    }

    public final void J2(float f) {
        if (C17784nZ1.s(this.r, f)) {
            return;
        }
        this.r = f;
        this.u.W0();
    }

    public final void V(InterfaceC10031ax6 interfaceC10031ax6) {
        if (AbstractC13042fc3.d(this.t, interfaceC10031ax6)) {
            return;
        }
        this.t = interfaceC10031ax6;
        this.u.W0();
    }

    private C9873ai0(float f, AbstractC12520el0 abstractC12520el0, InterfaceC10031ax6 interfaceC10031ax6) {
        this.r = f;
        this.s = abstractC12520el0;
        this.t = interfaceC10031ax6;
        this.u = (InterfaceC14380hp0) v2(androidx.compose.ui.draw.b.a(new e()));
    }
}
