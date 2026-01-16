package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.OD6;

/* loaded from: classes2.dex */
public final class OQ7 extends CN7 {
    private final C14104hM2 b;
    private String c;
    private boolean d;
    private final XZ1 e;
    private SA2 f;
    private final InterfaceC9102Ym4 g;
    private AbstractC24975zX0 h;
    private final InterfaceC9102Ym4 i;
    private long j;
    private float k;
    private float l;
    private final UA2 m;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(CN7 cn7) {
            OQ7.this.h();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((CN7) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            C14104hM2 c14104hM2L = OQ7.this.l();
            OQ7 oq7 = OQ7.this;
            float f = oq7.k;
            float f2 = oq7.l;
            long jC = ZG4.b.c();
            YZ1 yz1Z1 = interfaceC17460n02.z1();
            long jD = yz1Z1.d();
            yz1Z1.e().n();
            try {
                yz1Z1.b().f(f, f2, jC);
                c14104hM2L.a(interfaceC17460n02);
            } finally {
                yz1Z1.e().i();
                yz1Z1.g(jD);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    public OQ7(C14104hM2 c14104hM2) {
        super(null);
        this.b = c14104hM2;
        c14104hM2.d(new a());
        this.c = "";
        this.d = true;
        this.e = new XZ1();
        this.f = c.e;
        this.g = AbstractC13472gH6.d(null, null, 2, null);
        OD6.a aVar = OD6.b;
        this.i = AbstractC13472gH6.d(OD6.c(aVar.b()), null, 2, null);
        this.j = aVar.a();
        this.k = 1.0f;
        this.l = 1.0f;
        this.m = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.d = true;
        this.f.invoke();
    }

    @Override // ir.nasim.CN7
    public void a(InterfaceC17460n02 interfaceC17460n02) {
        i(interfaceC17460n02, 1.0f, null);
    }

    public final void i(InterfaceC17460n02 interfaceC17460n02, float f, AbstractC24975zX0 abstractC24975zX0) {
        int iA = (this.b.j() && this.b.g() != 16 && TQ7.f(k()) && TQ7.f(abstractC24975zX0)) ? Z03.b.a() : Z03.b.b();
        if (this.d || !OD6.f(this.j, interfaceC17460n02.d()) || !Z03.i(iA, j())) {
            this.h = Z03.i(iA, Z03.b.a()) ? AbstractC24975zX0.a.b(AbstractC24975zX0.b, this.b.g(), 0, 2, null) : null;
            this.k = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)) / Float.intBitsToFloat((int) (m() >> 32));
            this.l = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)) / Float.intBitsToFloat((int) (m() & 4294967295L));
            this.e.b(iA, C4414Fa3.c((((int) Math.ceil(Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)))) & 4294967295L) | (((int) Math.ceil(Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)))) << 32)), interfaceC17460n02, interfaceC17460n02.getLayoutDirection(), this.m);
            this.d = false;
            this.j = interfaceC17460n02.d();
        }
        if (abstractC24975zX0 == null) {
            abstractC24975zX0 = k() != null ? k() : this.h;
        }
        this.e.c(interfaceC17460n02, f, abstractC24975zX0);
    }

    public final int j() {
        Y03 y03D = this.e.d();
        return y03D != null ? y03D.b() : Z03.b.b();
    }

    public final AbstractC24975zX0 k() {
        return (AbstractC24975zX0) this.g.getValue();
    }

    public final C14104hM2 l() {
        return this.b;
    }

    public final long m() {
        return ((OD6) this.i.getValue()).m();
    }

    public final void n(AbstractC24975zX0 abstractC24975zX0) {
        this.g.setValue(abstractC24975zX0);
    }

    public final void o(SA2 sa2) {
        this.f = sa2;
    }

    public final void p(String str) {
        this.c = str;
    }

    public final void q(long j) {
        this.i.setValue(OD6.c(j));
    }

    public String toString() {
        String str = "Params: \tname: " + this.c + Separators.RETURN + "\tviewportWidth: " + Float.intBitsToFloat((int) (m() >> 32)) + Separators.RETURN + "\tviewportHeight: " + Float.intBitsToFloat((int) (m() & 4294967295L)) + Separators.RETURN;
        AbstractC13042fc3.h(str, "toString(...)");
        return str;
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        public static final c e = new c();

        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }

        public final void a() {
        }
    }
}
