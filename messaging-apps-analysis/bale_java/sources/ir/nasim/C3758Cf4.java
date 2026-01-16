package ir.nasim;

import ir.nasim.AbstractC23365wn7;
import ir.nasim.AbstractC9998au2;

/* renamed from: ir.nasim.Cf4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3758Cf4 {
    public static final a h = new a(null);
    public static final int i = 8;
    private static C3758Cf4 j;
    private final EnumC12613eu3 a;
    private final C9348Zn7 b;
    private final WH1 c;
    private final AbstractC9998au2.b d;
    private final C9348Zn7 e;
    private float f = Float.NaN;
    private float g = Float.NaN;

    /* renamed from: ir.nasim.Cf4$a */
    public static final class a {
        private a() {
        }

        public final C3758Cf4 a(C3758Cf4 c3758Cf4, EnumC12613eu3 enumC12613eu3, C9348Zn7 c9348Zn7, WH1 wh1, AbstractC9998au2.b bVar) {
            if (c3758Cf4 != null && enumC12613eu3 == c3758Cf4.g() && AbstractC13042fc3.d(AbstractC10560bo7.d(c9348Zn7, enumC12613eu3), c3758Cf4.f()) && wh1.getDensity() == c3758Cf4.d().getDensity() && bVar == c3758Cf4.e()) {
                return c3758Cf4;
            }
            C3758Cf4 c3758Cf42 = C3758Cf4.j;
            if (c3758Cf42 != null && enumC12613eu3 == c3758Cf42.g() && AbstractC13042fc3.d(AbstractC10560bo7.d(c9348Zn7, enumC12613eu3), c3758Cf42.f()) && wh1.getDensity() == c3758Cf42.d().getDensity() && bVar == c3758Cf42.e()) {
                return c3758Cf42;
            }
            C3758Cf4 c3758Cf43 = new C3758Cf4(enumC12613eu3, AbstractC10560bo7.d(c9348Zn7, enumC12613eu3), YH1.a(wh1.getDensity(), wh1.t1()), bVar);
            C3758Cf4.j = c3758Cf43;
            return c3758Cf43;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C3758Cf4(EnumC12613eu3 enumC12613eu3, C9348Zn7 c9348Zn7, WH1 wh1, AbstractC9998au2.b bVar) {
        this.a = enumC12613eu3;
        this.b = c9348Zn7;
        this.c = wh1;
        this.d = bVar;
        this.e = AbstractC10560bo7.d(c9348Zn7, enumC12613eu3);
    }

    public final long c(long j2, int i2) {
        float f = this.g;
        float f2 = this.f;
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            String str = AbstractC3992Df4.a;
            C9348Zn7 c9348Zn7 = this.e;
            long jB = AbstractC19606qe1.b(0, 0, 0, 0, 15, null);
            WH1 wh1 = this.c;
            AbstractC9998au2.b bVar = this.d;
            AbstractC23365wn7.a aVar = AbstractC23365wn7.a;
            float height = AbstractC13605gW4.a(str, c9348Zn7, jB, wh1, bVar, (64 & 32) != 0 ? AbstractC10360bX0.m() : null, (64 & 64) != 0 ? AbstractC10360bX0.m() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : 1, (64 & 256) != 0 ? AbstractC23365wn7.a.a() : aVar.a()).getHeight();
            float height2 = AbstractC13605gW4.a(AbstractC3992Df4.b, this.e, AbstractC19606qe1.b(0, 0, 0, 0, 15, null), this.c, this.d, (64 & 32) != 0 ? AbstractC10360bX0.m() : null, (64 & 64) != 0 ? AbstractC10360bX0.m() : null, (64 & 128) != 0 ? Integer.MAX_VALUE : 2, (64 & 256) != 0 ? AbstractC23365wn7.a.a() : aVar.a()).getHeight() - height;
            this.g = height;
            this.f = height2;
            f2 = height2;
            f = height;
        }
        return AbstractC19606qe1.a(C17833ne1.n(j2), C17833ne1.l(j2), i2 != 1 ? AbstractC23053wG5.i(AbstractC23053wG5.e(Math.round(f + (f2 * (i2 - 1))), 0), C17833ne1.k(j2)) : C17833ne1.m(j2), C17833ne1.k(j2));
    }

    public final WH1 d() {
        return this.c;
    }

    public final AbstractC9998au2.b e() {
        return this.d;
    }

    public final C9348Zn7 f() {
        return this.b;
    }

    public final EnumC12613eu3 g() {
        return this.a;
    }
}
