package ir.nasim;

import android.graphics.Typeface;
import ir.nasim.C14377ho7;
import ir.nasim.C22179un7;
import ir.nasim.C24381yX0;

/* renamed from: ir.nasim.xn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC23955xn7 {
    public static final C12863fI6 a(C13806gr c13806gr, C12863fI6 c12863fI6, InterfaceC16978mB2 interfaceC16978mB2, WH1 wh1, boolean z) {
        long jG = C13193fo7.g(c12863fI6.k());
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.b())) {
            c13806gr.setTextSize(wh1.I0(c12863fI6.k()));
        } else if (C14377ho7.g(jG, aVar.a())) {
            c13806gr.setTextSize(c13806gr.getTextSize() * C13193fo7.h(c12863fI6.k()));
        }
        if (d(c12863fI6)) {
            AbstractC9998au2 abstractC9998au2I = c12863fI6.i();
            C4593Fu2 c4593Fu2N = c12863fI6.n();
            if (c4593Fu2N == null) {
                c4593Fu2N = C4593Fu2.b.d();
            }
            C3418Au2 c3418Au2L = c12863fI6.l();
            C3418Au2 c3418Au2C = C3418Au2.c(c3418Au2L != null ? c3418Au2L.i() : C3418Au2.b.b());
            C3657Bu2 c3657Bu2M = c12863fI6.m();
            c13806gr.setTypeface((Typeface) interfaceC16978mB2.e(abstractC9998au2I, c4593Fu2N, c3418Au2C, C3657Bu2.e(c3657Bu2M != null ? c3657Bu2M.m() : C3657Bu2.b.a())));
        }
        if (c12863fI6.p() != null && !AbstractC13042fc3.d(c12863fI6.p(), IH3.c.a())) {
            LH3.a.b(c13806gr, c12863fI6.p());
        }
        if (c12863fI6.j() != null && !AbstractC13042fc3.d(c12863fI6.j(), "")) {
            c13806gr.setFontFeatureSettings(c12863fI6.j());
        }
        if (c12863fI6.u() != null && !AbstractC13042fc3.d(c12863fI6.u(), C3590Bm7.c.a())) {
            c13806gr.setTextScaleX(c13806gr.getTextScaleX() * c12863fI6.u().b());
            c13806gr.setTextSkewX(c13806gr.getTextSkewX() + c12863fI6.u().c());
        }
        c13806gr.f(c12863fI6.g());
        c13806gr.e(c12863fI6.f(), OD6.b.a(), c12863fI6.c());
        c13806gr.h(c12863fI6.r());
        c13806gr.i(c12863fI6.s());
        c13806gr.g(c12863fI6.h());
        if (C14377ho7.g(C13193fo7.g(c12863fI6.o()), aVar.b()) && C13193fo7.h(c12863fI6.o()) != 0.0f) {
            float textSize = c13806gr.getTextSize() * c13806gr.getTextScaleX();
            float fI0 = wh1.I0(c12863fI6.o());
            if (textSize != 0.0f) {
                c13806gr.setLetterSpacing(fI0 / textSize);
            }
        } else if (C14377ho7.g(C13193fo7.g(c12863fI6.o()), aVar.a())) {
            c13806gr.setLetterSpacing(C13193fo7.h(c12863fI6.o()));
        }
        return c(c12863fI6.o(), z, c12863fI6.d(), c12863fI6.e());
    }

    public static final float b(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    private static final C12863fI6 c(long j, boolean z, long j2, C18413od0 c18413od0) {
        long jI = j2;
        boolean z2 = false;
        boolean z3 = z && C14377ho7.g(C13193fo7.g(j), C14377ho7.b.b()) && C13193fo7.h(j) != 0.0f;
        C24381yX0.a aVar = C24381yX0.b;
        boolean z4 = (C24381yX0.q(jI, aVar.i()) || C24381yX0.q(jI, aVar.h())) ? false : true;
        if (c18413od0 != null) {
            if (!C18413od0.e(c18413od0.h(), C18413od0.b.a())) {
                z2 = true;
            }
        }
        if (!z3 && !z4 && !z2) {
            return null;
        }
        long jA = z3 ? j : C13193fo7.b.a();
        if (!z4) {
            jI = aVar.i();
        }
        return new C12863fI6(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, jA, z2 ? c18413od0 : null, (C3590Bm7) null, (IH3) null, jI, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 63103, (ED1) null);
    }

    public static final boolean d(C12863fI6 c12863fI6) {
        return (c12863fI6.i() == null && c12863fI6.l() == null && c12863fI6.n() == null) ? false : true;
    }

    public static final void e(C13806gr c13806gr, C22179un7 c22179un7) {
        if (c22179un7 == null) {
            c22179un7 = C22179un7.c.a();
        }
        c13806gr.setFlags(c22179un7.c() ? c13806gr.getFlags() | 128 : c13806gr.getFlags() & (-129));
        int iB = c22179un7.b();
        C22179un7.b.a aVar = C22179un7.b.b;
        if (C22179un7.b.g(iB, aVar.b())) {
            c13806gr.setFlags(c13806gr.getFlags() | 64);
            c13806gr.setHinting(0);
        } else if (C22179un7.b.g(iB, aVar.a())) {
            c13806gr.getFlags();
            c13806gr.setHinting(1);
        } else if (!C22179un7.b.g(iB, aVar.c())) {
            c13806gr.getFlags();
        } else {
            c13806gr.getFlags();
            c13806gr.setHinting(0);
        }
    }
}
