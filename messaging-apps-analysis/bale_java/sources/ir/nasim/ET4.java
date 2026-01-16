package ir.nasim;

import ir.nasim.AbstractC22184uo2;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ET4 {

    public static final class a implements CG6 {
        final /* synthetic */ GT4 a;
        final /* synthetic */ InterfaceC15796kB2 b;
        final /* synthetic */ CT4 c;

        a(GT4 gt4, InterfaceC15796kB2 interfaceC15796kB2, CT4 ct4) {
            this.a = gt4;
            this.b = interfaceC15796kB2;
            this.c = ct4;
        }

        private final XV4 e(FG6 fg6, float f) {
            float f2;
            List listI = c().i();
            GT4 gt4 = this.a;
            int size = listI.size();
            int i = 0;
            float f3 = Float.NEGATIVE_INFINITY;
            float f4 = Float.POSITIVE_INFINITY;
            while (true) {
                f2 = 0.0f;
                if (i >= size) {
                    break;
                }
                InterfaceC9734aT4 interfaceC9734aT4 = (InterfaceC9734aT4) listI.get(i);
                float fA = GG6.a(AbstractC18324oT4.a(c()), c().e(), c().c(), c().h(), interfaceC9734aT4.getOffset(), interfaceC9734aT4.getIndex(), fg6, gt4.H());
                if (fA <= 0.0f && fA > f3) {
                    f3 = fA;
                }
                if (fA >= 0.0f && fA < f4) {
                    f4 = fA;
                }
                i++;
            }
            if (f3 == Float.NEGATIVE_INFINITY) {
                f3 = f4;
            }
            if (f4 == Float.POSITIVE_INFINITY) {
                f4 = f3;
            }
            if (!this.a.e()) {
                if (ET4.e(this.a, f)) {
                    f3 = 0.0f;
                    f4 = 0.0f;
                } else {
                    f4 = 0.0f;
                }
            }
            if (this.a.d()) {
                f2 = f3;
            } else if (!ET4.e(this.a, f)) {
                f4 = 0.0f;
            }
            return AbstractC4616Fw7.a(Float.valueOf(f2), Float.valueOf(f4));
        }

        @Override // ir.nasim.CG6
        public float a(float f) {
            XV4 xv4E = e(this.a.C().n(), f);
            float fFloatValue = ((Number) xv4E.a()).floatValue();
            float fFloatValue2 = ((Number) xv4E.b()).floatValue();
            float fFloatValue3 = ((Number) this.b.q(Float.valueOf(f), Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2))).floatValue();
            if (!(fFloatValue3 == fFloatValue || fFloatValue3 == fFloatValue2 || fFloatValue3 == 0.0f)) {
                P73.c("Final Snapping Offset Should Be one of " + fFloatValue + ", " + fFloatValue2 + " or 0.0");
            }
            if (d(fFloatValue3)) {
                return fFloatValue3;
            }
            return 0.0f;
        }

        @Override // ir.nasim.CG6
        public float b(float f, float f2) {
            int I = this.a.I() + this.a.K();
            if (I == 0) {
                return 0.0f;
            }
            int iY = f < 0.0f ? this.a.y() + 1 : this.a.y();
            int iE = AbstractC23053wG5.e(Math.abs((AbstractC23053wG5.m(this.c.a(iY, AbstractC23053wG5.m(((int) (f2 / I)) + iY, 0, this.a.H()), f, this.a.I(), this.a.K()), 0, this.a.H()) - iY) * I) - I, 0);
            if (iE == 0) {
                return iE;
            }
            return Math.signum(f) * iE;
        }

        public final InterfaceC17733nT4 c() {
            return this.a.C();
        }

        public final boolean d(float f) {
            return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
        }
    }

    public static final CG6 a(GT4 gt4, CT4 ct4, InterfaceC15796kB2 interfaceC15796kB2) {
        return new a(gt4, interfaceC15796kB2, ct4);
    }

    public static final float c(GT4 gt4, EnumC12613eu3 enumC12613eu3, float f, float f2, float f3, float f4) {
        boolean zE = e(gt4, f2);
        if (gt4.C().a() != EnumC24286yM4.a && enumC12613eu3 != EnumC12613eu3.a) {
            zE = !zE;
        }
        int iH = gt4.C().h();
        float fD = iH == 0 ? 0.0f : d(gt4) / iH;
        float f5 = fD - ((int) fD);
        int iB = AbstractC17433mx3.b(gt4.x(), f2);
        AbstractC22184uo2.a aVar = AbstractC22184uo2.a;
        if (AbstractC22184uo2.e(iB, aVar.a())) {
            if (Math.abs(f5) > f) {
                if (!zE) {
                    return f3;
                }
            } else if (Math.abs(fD) >= Math.abs(gt4.N())) {
                if (zE) {
                    return f3;
                }
            } else if (Math.abs(f3) < Math.abs(f4)) {
                return f3;
            }
        } else if (!AbstractC22184uo2.e(iB, aVar.b())) {
            if (AbstractC22184uo2.e(iB, aVar.c())) {
                return f3;
            }
            return 0.0f;
        }
        return f4;
    }

    private static final float d(GT4 gt4) {
        return gt4.C().a() == EnumC24286yM4.b ? Float.intBitsToFloat((int) (gt4.T() >> 32)) : Float.intBitsToFloat((int) (gt4.T() & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(GT4 gt4, float f) {
        boolean zG = gt4.C().g();
        boolean z = (gt4.V() ? -f : d(gt4)) > 0.0f;
        return (z && zG) || !(z || zG);
    }
}
