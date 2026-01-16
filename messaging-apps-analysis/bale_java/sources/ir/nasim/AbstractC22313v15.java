package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC18655p15;
import java.util.List;

/* renamed from: ir.nasim.v15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC22313v15 {
    private static final float[] a = new float[0];

    private static final void a(V05 v05, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d3;
        double d11 = 4;
        int iCeil = (int) Math.ceil(Math.abs((d9 * d11) / 3.141592653589793d));
        double dCos = Math.cos(d7);
        double dSin = Math.sin(d7);
        double dCos2 = Math.cos(d8);
        double dSin2 = Math.sin(d8);
        double d12 = -d10;
        double d13 = d12 * dCos;
        double d14 = d4 * dSin;
        double d15 = (d13 * dSin2) - (d14 * dCos2);
        double d16 = d12 * dSin;
        double d17 = d4 * dCos;
        double d18 = (dSin2 * d16) + (dCos2 * d17);
        double d19 = d9 / iCeil;
        double d20 = d5;
        double d21 = d18;
        double d22 = d15;
        int i = 0;
        double d23 = d6;
        double d24 = d8;
        while (i < iCeil) {
            double d25 = d24 + d19;
            double dSin3 = Math.sin(d25);
            double dCos3 = Math.cos(d25);
            int i2 = iCeil;
            double d26 = (d + ((d10 * dCos) * dCos3)) - (d14 * dSin3);
            double d27 = d2 + (d10 * dSin * dCos3) + (d17 * dSin3);
            double d28 = (d13 * dSin3) - (d14 * dCos3);
            double d29 = (dSin3 * d16) + (dCos3 * d17);
            double d30 = d25 - d24;
            double dTan = Math.tan(d30 / 2);
            double dSin4 = (Math.sin(d30) * (Math.sqrt(d11 + ((3.0d * dTan) * dTan)) - 1)) / 3;
            v05.b((float) (d20 + (d22 * dSin4)), (float) (d23 + (d21 * dSin4)), (float) (d26 - (dSin4 * d28)), (float) (d27 - (dSin4 * d29)), (float) d26, (float) d27);
            i++;
            d19 = d19;
            dSin = dSin;
            d20 = d26;
            d16 = d16;
            d24 = d25;
            d21 = d29;
            d11 = d11;
            d22 = d28;
            dCos = dCos;
            iCeil = i2;
            d23 = d27;
            d10 = d3;
        }
    }

    private static final void b(V05 v05, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        double d8;
        double d9;
        double d10 = (d7 / SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER) * 3.141592653589793d;
        double dCos = Math.cos(d10);
        double dSin = Math.sin(d10);
        double d11 = ((d * dCos) + (d2 * dSin)) / d5;
        double d12 = (((-d) * dSin) + (d2 * dCos)) / d6;
        double d13 = ((d3 * dCos) + (d4 * dSin)) / d5;
        double d14 = (((-d3) * dSin) + (d4 * dCos)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d15 * d15) + (d16 * d16);
        if (d20 == 0.0d) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double dSqrt = (float) (Math.sqrt(d20) / 1.99999d);
            b(v05, d, d2, d3, d4, d5 * dSqrt, d6 * dSqrt, d7, z, z2);
            return;
        }
        double dSqrt2 = Math.sqrt(d21);
        double d22 = d15 * dSqrt2;
        double d23 = dSqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double dAtan2 = Math.atan2(d12 - d9, d11 - d8);
        double dAtan22 = Math.atan2(d14 - d9, d13 - d8) - dAtan2;
        if (z2 != (dAtan22 >= 0.0d)) {
            dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
        }
        double d24 = d8 * d5;
        double d25 = d9 * d6;
        a(v05, (d24 * dCos) - (d25 * dSin), (d24 * dSin) + (d25 * dCos), d5, d6, d, d2, d10, dAtan2, dAtan22);
    }

    public static final V05 c(List list, V05 v05) {
        AbstractC18655p15 abstractC18655p15;
        float f;
        int i;
        int i2;
        float f2;
        float f3;
        float fC;
        float fE;
        float fD;
        float fD2;
        float f4;
        float f5;
        float f6;
        float f7;
        float fE2;
        float fD3;
        float f8;
        float f9;
        float f10;
        List list2 = list;
        V05 v052 = v05;
        int iQ = v05.q();
        v05.t();
        v052.h(iQ);
        AbstractC18655p15 abstractC18655p152 = list.isEmpty() ? AbstractC18655p15.b.c : (AbstractC18655p15) list2.get(0);
        int size = list2.size();
        float f11 = 0.0f;
        int i3 = 0;
        float fC2 = 0.0f;
        float fD4 = 0.0f;
        float fC3 = 0.0f;
        float fD5 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (i3 < size) {
            AbstractC18655p15 abstractC18655p153 = (AbstractC18655p15) list2.get(i3);
            if (abstractC18655p153 instanceof AbstractC18655p15.b) {
                v05.close();
                abstractC18655p15 = abstractC18655p153;
                f = f11;
                i = i3;
                i2 = size;
                fC2 = f12;
                fC3 = fC2;
                fD4 = f13;
                fD5 = fD4;
            } else {
                if (abstractC18655p153 instanceof AbstractC18655p15.n) {
                    AbstractC18655p15.n nVar = (AbstractC18655p15.n) abstractC18655p153;
                    fC3 += nVar.c();
                    fD5 += nVar.d();
                    v052.e(nVar.c(), nVar.d());
                    f12 = fC3;
                } else if (abstractC18655p153 instanceof AbstractC18655p15.f) {
                    AbstractC18655p15.f fVar = (AbstractC18655p15.f) abstractC18655p153;
                    float fC4 = fVar.c();
                    float fD6 = fVar.d();
                    v052.a(fVar.c(), fVar.d());
                    fC3 = fC4;
                    f12 = fC3;
                    fD5 = fD6;
                } else {
                    if (abstractC18655p153 instanceof AbstractC18655p15.m) {
                        AbstractC18655p15.m mVar = (AbstractC18655p15.m) abstractC18655p153;
                        v052.s(mVar.c(), mVar.d());
                        fC3 += mVar.c();
                        f5 = mVar.d();
                    } else {
                        if (abstractC18655p153 instanceof AbstractC18655p15.e) {
                            AbstractC18655p15.e eVar = (AbstractC18655p15.e) abstractC18655p153;
                            v052.c(eVar.c(), eVar.d());
                            fD2 = eVar.c();
                            f4 = eVar.d();
                        } else {
                            if (abstractC18655p153 instanceof AbstractC18655p15.l) {
                                AbstractC18655p15.l lVar = (AbstractC18655p15.l) abstractC18655p153;
                                v052.s(lVar.c(), f11);
                                fC3 += lVar.c();
                            } else if (abstractC18655p153 instanceof AbstractC18655p15.d) {
                                AbstractC18655p15.d dVar = (AbstractC18655p15.d) abstractC18655p153;
                                v052.c(dVar.c(), fD5);
                                fC3 = dVar.c();
                            } else if (abstractC18655p153 instanceof AbstractC18655p15.r) {
                                AbstractC18655p15.r rVar = (AbstractC18655p15.r) abstractC18655p153;
                                v052.s(f11, rVar.c());
                                f5 = rVar.c();
                            } else if (abstractC18655p153 instanceof AbstractC18655p15.s) {
                                AbstractC18655p15.s sVar = (AbstractC18655p15.s) abstractC18655p153;
                                v052.c(fC3, sVar.c());
                                fD5 = sVar.c();
                            } else {
                                if (abstractC18655p153 instanceof AbstractC18655p15.k) {
                                    AbstractC18655p15.k kVar = (AbstractC18655p15.k) abstractC18655p153;
                                    v05.f(kVar.c(), kVar.f(), kVar.d(), kVar.g(), kVar.e(), kVar.h());
                                    fC = kVar.d() + fC3;
                                    fE = kVar.g() + fD5;
                                    fC3 += kVar.e();
                                    fD = kVar.h();
                                } else {
                                    if (abstractC18655p153 instanceof AbstractC18655p15.c) {
                                        AbstractC18655p15.c cVar = (AbstractC18655p15.c) abstractC18655p153;
                                        v05.b(cVar.c(), cVar.f(), cVar.d(), cVar.g(), cVar.e(), cVar.h());
                                        fC = cVar.d();
                                        fE2 = cVar.g();
                                        fD3 = cVar.e();
                                        f8 = cVar.h();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.p) {
                                        if (abstractC18655p152.a()) {
                                            f10 = fD5 - fD4;
                                            f9 = fC3 - fC2;
                                        } else {
                                            f9 = f11;
                                            f10 = f9;
                                        }
                                        AbstractC18655p15.p pVar = (AbstractC18655p15.p) abstractC18655p153;
                                        v05.f(f9, f10, pVar.c(), pVar.e(), pVar.d(), pVar.f());
                                        fC = pVar.c() + fC3;
                                        fE = pVar.e() + fD5;
                                        fC3 += pVar.d();
                                        fD = pVar.f();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.h) {
                                        if (abstractC18655p152.a()) {
                                            float f14 = 2;
                                            f7 = (f14 * fD5) - fD4;
                                            f6 = (fC3 * f14) - fC2;
                                        } else {
                                            f6 = fC3;
                                            f7 = fD5;
                                        }
                                        AbstractC18655p15.h hVar = (AbstractC18655p15.h) abstractC18655p153;
                                        v05.b(f6, f7, hVar.c(), hVar.e(), hVar.d(), hVar.f());
                                        fC = hVar.c();
                                        fE2 = hVar.e();
                                        fD3 = hVar.d();
                                        f8 = hVar.f();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.o) {
                                        AbstractC18655p15.o oVar = (AbstractC18655p15.o) abstractC18655p153;
                                        v052.n(oVar.c(), oVar.e(), oVar.d(), oVar.f());
                                        fC2 = oVar.c() + fC3;
                                        fD4 = oVar.e() + fD5;
                                        fC3 += oVar.d();
                                        f5 = oVar.f();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.g) {
                                        AbstractC18655p15.g gVar = (AbstractC18655p15.g) abstractC18655p153;
                                        v052.i(gVar.c(), gVar.e(), gVar.d(), gVar.f());
                                        fC2 = gVar.c();
                                        fD4 = gVar.e();
                                        fD2 = gVar.d();
                                        f4 = gVar.f();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.q) {
                                        if (abstractC18655p152.b()) {
                                            f2 = fC3 - fC2;
                                            f3 = fD5 - fD4;
                                        } else {
                                            f2 = f11;
                                            f3 = f2;
                                        }
                                        AbstractC18655p15.q qVar = (AbstractC18655p15.q) abstractC18655p153;
                                        v052.n(f2, f3, qVar.c(), qVar.d());
                                        fC = f2 + fC3;
                                        fE = f3 + fD5;
                                        fC3 += qVar.c();
                                        fD = qVar.d();
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.i) {
                                        if (abstractC18655p152.b()) {
                                            float f15 = 2;
                                            fC3 = (fC3 * f15) - fC2;
                                            fD5 = (f15 * fD5) - fD4;
                                        }
                                        AbstractC18655p15.i iVar = (AbstractC18655p15.i) abstractC18655p153;
                                        v052.i(fC3, fD5, iVar.c(), iVar.d());
                                        float fC5 = iVar.c();
                                        fD4 = fD5;
                                        abstractC18655p15 = abstractC18655p153;
                                        f = f11;
                                        i = i3;
                                        i2 = size;
                                        fD5 = iVar.d();
                                        float f16 = fC3;
                                        fC3 = fC5;
                                        fC2 = f16;
                                    } else if (abstractC18655p153 instanceof AbstractC18655p15.j) {
                                        AbstractC18655p15.j jVar = (AbstractC18655p15.j) abstractC18655p153;
                                        float fC6 = jVar.c() + fC3;
                                        float fD7 = jVar.d() + fD5;
                                        abstractC18655p15 = abstractC18655p153;
                                        i = i3;
                                        f = 0.0f;
                                        i2 = size;
                                        b(v05, fC3, fD5, fC6, fD7, jVar.e(), jVar.g(), jVar.f(), jVar.h(), jVar.i());
                                        fD4 = fD7;
                                        fD5 = fD4;
                                        fC2 = fC6;
                                        fC3 = fC2;
                                    } else {
                                        abstractC18655p15 = abstractC18655p153;
                                        f = f11;
                                        i = i3;
                                        i2 = size;
                                        if (abstractC18655p15 instanceof AbstractC18655p15.a) {
                                            AbstractC18655p15.a aVar = (AbstractC18655p15.a) abstractC18655p15;
                                            b(v05, fC3, fD5, aVar.c(), aVar.d(), aVar.e(), aVar.g(), aVar.f(), aVar.h(), aVar.i());
                                            fC3 = aVar.c();
                                            fD4 = aVar.d();
                                            fD5 = fD4;
                                            fC2 = fC3;
                                        }
                                    }
                                    fC3 = fD3;
                                    fD5 = f8;
                                    abstractC18655p15 = abstractC18655p153;
                                    f = f11;
                                    i = i3;
                                    i2 = size;
                                    fD4 = fE2;
                                    fC2 = fC;
                                }
                                fD5 += fD;
                                fD4 = fE;
                                abstractC18655p15 = abstractC18655p153;
                                f = f11;
                                i = i3;
                                i2 = size;
                                fC2 = fC;
                            }
                            abstractC18655p15 = abstractC18655p153;
                            f = f11;
                            i = i3;
                            i2 = size;
                        }
                        fD5 = f4;
                        fC3 = fD2;
                        abstractC18655p15 = abstractC18655p153;
                        f = f11;
                        i = i3;
                        i2 = size;
                    }
                    fD5 += f5;
                    abstractC18655p15 = abstractC18655p153;
                    f = f11;
                    i = i3;
                    i2 = size;
                }
                f13 = fD5;
                abstractC18655p15 = abstractC18655p153;
                f = f11;
                i = i3;
                i2 = size;
            }
            i3 = i + 1;
            v052 = v05;
            abstractC18655p152 = abstractC18655p15;
            f11 = f;
            size = i2;
            list2 = list;
        }
        return v05;
    }
}
