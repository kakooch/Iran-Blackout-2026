package io.sentry.android.replay.util;

import android.graphics.Rect;
import ir.nasim.AbstractC10836cH4;
import ir.nasim.AbstractC12000du3;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C19038pg4;
import ir.nasim.C24381yX0;
import ir.nasim.C3419Au3;
import ir.nasim.C4414Fa3;
import ir.nasim.CK5;
import ir.nasim.EV4;
import ir.nasim.InterfaceC11379cu3;
import ir.nasim.VX0;
import ir.nasim.ZG4;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class k {
    public static final Rect a(InterfaceC11379cu3 interfaceC11379cu3, InterfaceC11379cu3 interfaceC11379cu32) {
        AbstractC13042fc3.i(interfaceC11379cu3, "<this>");
        if (interfaceC11379cu32 == null) {
            interfaceC11379cu32 = AbstractC12000du3.d(interfaceC11379cu3);
        }
        float fG = C4414Fa3.g(interfaceC11379cu32.a());
        float f = C4414Fa3.f(interfaceC11379cu32.a());
        CK5 ck5W = InterfaceC11379cu3.W(interfaceC11379cu32, interfaceC11379cu3, false, 2, null);
        float fI = ck5W.i();
        if (fI < 0.0f) {
            fI = 0.0f;
        }
        if (fI > fG) {
            fI = fG;
        }
        float fL = ck5W.l();
        if (fL < 0.0f) {
            fL = 0.0f;
        }
        if (fL > f) {
            fL = f;
        }
        float fJ = ck5W.j();
        if (fJ < 0.0f) {
            fJ = 0.0f;
        }
        if (fJ <= fG) {
            fG = fJ;
        }
        float fE = ck5W.e();
        float f2 = fE >= 0.0f ? fE : 0.0f;
        if (f2 <= f) {
            f = f2;
        }
        if (fI == fG || fL == f) {
            return new Rect();
        }
        long jA0 = interfaceC11379cu32.a0(AbstractC10836cH4.a(fI, fL));
        long jA02 = interfaceC11379cu32.a0(AbstractC10836cH4.a(fG, fL));
        long jA03 = interfaceC11379cu32.a0(AbstractC10836cH4.a(fG, f));
        long jA04 = interfaceC11379cu32.a0(AbstractC10836cH4.a(fI, f));
        float fM = ZG4.m(jA0);
        float fM2 = ZG4.m(jA02);
        float fM3 = ZG4.m(jA04);
        float fM4 = ZG4.m(jA03);
        float fMin = Math.min(fM, Math.min(fM2, Math.min(fM3, fM4)));
        float fMax = Math.max(fM, Math.max(fM2, Math.max(fM3, fM4)));
        float fN = ZG4.n(jA0);
        float fN2 = ZG4.n(jA02);
        float fN3 = ZG4.n(jA04);
        float fN4 = ZG4.n(jA03);
        return new Rect((int) fMin, (int) Math.min(fN, Math.min(fN2, Math.min(fN3, fN4))), (int) fMax, (int) Math.max(fN, Math.max(fN2, Math.max(fN3, fN4))));
    }

    public static final EV4 b(C3419Au3 c3419Au3) {
        AbstractC13042fc3.i(c3419Au3, "<this>");
        List listK = c3419Au3.k();
        int size = listK.size();
        for (int i = 0; i < size; i++) {
            androidx.compose.ui.e eVarA = ((C19038pg4) listK.get(i)).a();
            String name = eVarA.getClass().getName();
            AbstractC13042fc3.h(name, "modifier::class.java.name");
            if (AbstractC20762sZ6.X(name, "Painter", false, 2, null)) {
                try {
                    Field declaredField = eVarA.getClass().getDeclaredField("painter");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(eVarA);
                    if (obj instanceof EV4) {
                        return (EV4) obj;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static final n c(C3419Au3 c3419Au3) {
        VX0 vx0;
        AbstractC13042fc3.i(c3419Au3, "<this>");
        List listK = c3419Au3.k();
        int size = listK.size();
        C24381yX0 c24381yX0K = null;
        boolean z = false;
        for (int i = 0; i < size; i++) {
            androidx.compose.ui.e eVarA = ((C19038pg4) listK.get(i)).a();
            String name = eVarA.getClass().getName();
            AbstractC13042fc3.h(name, "modifierClassName");
            if (AbstractC20762sZ6.X(name, "Text", false, 2, null)) {
                try {
                    Field declaredField = eVarA.getClass().getDeclaredField("color");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(eVarA);
                    vx0 = obj instanceof VX0 ? (VX0) obj : null;
                } catch (Throwable unused) {
                }
                c24381yX0K = vx0 != null ? C24381yX0.k(vx0.a()) : null;
            } else if (AbstractC20762sZ6.X(name, "Fill", false, 2, null)) {
                z = true;
            }
        }
        return new n(c24381yX0K, z, null);
    }

    public static final boolean d(EV4 ev4) {
        AbstractC13042fc3.i(ev4, "<this>");
        String name = ev4.getClass().getName();
        AbstractC13042fc3.h(name, "className");
        return (AbstractC20762sZ6.X(name, "Vector", false, 2, null) || AbstractC20762sZ6.X(name, "Color", false, 2, null) || AbstractC20762sZ6.X(name, "Brush", false, 2, null)) ? false : true;
    }
}
