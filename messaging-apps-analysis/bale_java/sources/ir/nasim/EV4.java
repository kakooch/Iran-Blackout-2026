package ir.nasim;

/* loaded from: classes2.dex */
public abstract class EV4 {
    private InterfaceC12969fU4 a;
    private boolean b;
    private AbstractC24975zX0 c;
    private float d = 1.0f;
    private EnumC12613eu3 e = EnumC12613eu3.a;
    private final UA2 f = new a();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            EV4.this.n(interfaceC17460n02);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    private final void g(float f) {
        if (this.d == f) {
            return;
        }
        if (!a(f)) {
            if (f == 1.0f) {
                InterfaceC12969fU4 interfaceC12969fU4 = this.a;
                if (interfaceC12969fU4 != null) {
                    interfaceC12969fU4.c(f);
                }
                this.b = false;
            } else {
                m().c(f);
                this.b = true;
            }
        }
        this.d = f;
    }

    private final void h(AbstractC24975zX0 abstractC24975zX0) {
        if (AbstractC13042fc3.d(this.c, abstractC24975zX0)) {
            return;
        }
        if (!c(abstractC24975zX0)) {
            if (abstractC24975zX0 == null) {
                InterfaceC12969fU4 interfaceC12969fU4 = this.a;
                if (interfaceC12969fU4 != null) {
                    interfaceC12969fU4.e(null);
                }
                this.b = false;
            } else {
                m().e(abstractC24975zX0);
                this.b = true;
            }
        }
        this.c = abstractC24975zX0;
    }

    private final void i(EnumC12613eu3 enumC12613eu3) {
        if (this.e != enumC12613eu3) {
            f(enumC12613eu3);
            this.e = enumC12613eu3;
        }
    }

    public static /* synthetic */ void k(EV4 ev4, InterfaceC17460n02 interfaceC17460n02, long j, float f, AbstractC24975zX0 abstractC24975zX0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
        }
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i & 4) != 0) {
            abstractC24975zX0 = null;
        }
        ev4.j(interfaceC17460n02, j, f2, abstractC24975zX0);
    }

    private final InterfaceC12969fU4 m() {
        InterfaceC12969fU4 interfaceC12969fU4 = this.a;
        if (interfaceC12969fU4 != null) {
            return interfaceC12969fU4;
        }
        InterfaceC12969fU4 interfaceC12969fU4A = AbstractC15587jq.a();
        this.a = interfaceC12969fU4A;
        return interfaceC12969fU4A;
    }

    protected boolean a(float f) {
        return false;
    }

    protected boolean c(AbstractC24975zX0 abstractC24975zX0) {
        return false;
    }

    protected boolean f(EnumC12613eu3 enumC12613eu3) {
        return false;
    }

    public final void j(InterfaceC17460n02 interfaceC17460n02, long j, float f, AbstractC24975zX0 abstractC24975zX0) {
        g(f);
        h(abstractC24975zX0);
        i(interfaceC17460n02.getLayoutDirection());
        int i = (int) (j >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) - Float.intBitsToFloat(i);
        int i2 = (int) (j & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) - Float.intBitsToFloat(i2);
        interfaceC17460n02.z1().b().h(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f > 0.0f) {
            try {
                if (Float.intBitsToFloat(i) > 0.0f && Float.intBitsToFloat(i2) > 0.0f) {
                    if (this.b) {
                        long jC = ZG4.b.c();
                        float fIntBitsToFloat3 = Float.intBitsToFloat(i);
                        float fIntBitsToFloat4 = Float.intBitsToFloat(i2);
                        CK5 ck5B = FK5.b(jC, OD6.d((Float.floatToRawIntBits(fIntBitsToFloat4) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32)));
                        UE0 ue0E = interfaceC17460n02.z1().e();
                        try {
                            ue0E.j(ck5B, m());
                            n(interfaceC17460n02);
                            ue0E.i();
                        } catch (Throwable th) {
                            ue0E.i();
                            throw th;
                        }
                    } else {
                        n(interfaceC17460n02);
                    }
                }
            } catch (Throwable th2) {
                interfaceC17460n02.z1().b().h(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
                throw th2;
            }
        }
        interfaceC17460n02.z1().b().h(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
    }

    public abstract long l();

    protected abstract void n(InterfaceC17460n02 interfaceC17460n02);
}
