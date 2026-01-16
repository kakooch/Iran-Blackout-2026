package ir.nasim;

import ir.nasim.C20576sF0;

/* loaded from: classes2.dex */
public final class XZ1 {
    private Y03 a;
    private UE0 b;
    private WH1 c;
    private EnumC12613eu3 d = EnumC12613eu3.a;
    private long e = C4414Fa3.b.a();
    private int f = Z03.b.b();
    private final C20576sF0 g = new C20576sF0();

    private final void a(InterfaceC17460n02 interfaceC17460n02) {
        InterfaceC17460n02.C1(interfaceC17460n02, C24381yX0.b.a(), 0L, 0L, 0.0f, null, null, AbstractC7094Qg0.a.a(), 62, null);
    }

    public final void b(int i, long j, WH1 wh1, EnumC12613eu3 enumC12613eu3, UA2 ua2) {
        this.c = wh1;
        this.d = enumC12613eu3;
        Y03 y03B = this.a;
        UE0 ue0A = this.b;
        if (y03B == null || ue0A == null || ((int) (j >> 32)) > y03B.getWidth() || ((int) (j & 4294967295L)) > y03B.getHeight() || !Z03.i(this.f, i)) {
            y03B = AbstractC9472a13.b((int) (j >> 32), (int) (j & 4294967295L), i, false, null, 24, null);
            ue0A = AbstractC23039wF0.a(y03B);
            this.a = y03B;
            this.b = ue0A;
            this.f = i;
        }
        this.e = j;
        C20576sF0 c20576sF0 = this.g;
        long jD = AbstractC4663Ga3.d(j);
        C20576sF0.a aVarE = c20576sF0.E();
        WH1 wh1A = aVarE.a();
        EnumC12613eu3 enumC12613eu3B = aVarE.b();
        UE0 ue0C = aVarE.c();
        long jD2 = aVarE.d();
        C20576sF0.a aVarE2 = c20576sF0.E();
        aVarE2.j(wh1);
        aVarE2.k(enumC12613eu3);
        aVarE2.i(ue0A);
        aVarE2.l(jD);
        ue0A.n();
        a(c20576sF0);
        ua2.invoke(c20576sF0);
        ue0A.i();
        C20576sF0.a aVarE3 = c20576sF0.E();
        aVarE3.j(wh1A);
        aVarE3.k(enumC12613eu3B);
        aVarE3.i(ue0C);
        aVarE3.l(jD2);
        y03B.a();
    }

    public final void c(InterfaceC17460n02 interfaceC17460n02, float f, AbstractC24975zX0 abstractC24975zX0) {
        Y03 y03 = this.a;
        if (!(y03 != null)) {
            M73.b("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        InterfaceC17460n02.H1(interfaceC17460n02, y03, 0L, this.e, 0L, 0L, f, null, abstractC24975zX0, 0, 0, 858, null);
    }

    public final Y03 d() {
        return this.a;
    }
}
