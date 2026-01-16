package ir.nasim;

import android.graphics.Typeface;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import ir.nasim.AbstractC13406gA3;
import ir.nasim.AbstractC9998au2;
import ir.nasim.C13245fu;
import ir.nasim.C24525yl7;
import java.util.List;

/* renamed from: ir.nasim.cn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC11305cn {
    private static final void a(SpannableString spannableString, C12863fI6 c12863fI6, int i, int i2, WH1 wh1, AbstractC9998au2.b bVar) {
        AbstractC15863kI6.l(spannableString, c12863fI6.g(), i, i2);
        AbstractC15863kI6.p(spannableString, c12863fI6.k(), wh1, i, i2);
        if (c12863fI6.n() != null || c12863fI6.l() != null) {
            C4593Fu2 c4593Fu2N = c12863fI6.n();
            if (c4593Fu2N == null) {
                c4593Fu2N = C4593Fu2.b.d();
            }
            C3418Au2 c3418Au2L = c12863fI6.l();
            spannableString.setSpan(new StyleSpan(AbstractC13195fp.c(c4593Fu2N, c3418Au2L != null ? c3418Au2L.i() : C3418Au2.b.b())), i, i2, 33);
        }
        if (c12863fI6.i() != null) {
            if (c12863fI6.i() instanceof TE2) {
                spannableString.setSpan(new TypefaceSpan(((TE2) c12863fI6.i()).o()), i, i2, 33);
            } else if (Build.VERSION.SDK_INT >= 28) {
                AbstractC9998au2 abstractC9998au2I = c12863fI6.i();
                C3657Bu2 c3657Bu2M = c12863fI6.m();
                Object value = AbstractC9998au2.b.a(bVar, abstractC9998au2I, null, 0, c3657Bu2M != null ? c3657Bu2M.m() : C3657Bu2.b.a(), 6, null).getValue();
                AbstractC13042fc3.g(value, "null cannot be cast to non-null type android.graphics.Typeface");
                spannableString.setSpan(C19183pv.a.a((Typeface) value), i, i2, 33);
            }
        }
        if (c12863fI6.s() != null) {
            C24525yl7 c24525yl7S = c12863fI6.s();
            C24525yl7.a aVar = C24525yl7.b;
            if (c24525yl7S.d(aVar.d())) {
                spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (c12863fI6.s().d(aVar.b())) {
                spannableString.setSpan(new StrikethroughSpan(), i, i2, 33);
            }
        }
        if (c12863fI6.u() != null) {
            spannableString.setSpan(new ScaleXSpan(c12863fI6.u().b()), i, i2, 33);
        }
        AbstractC15863kI6.t(spannableString, c12863fI6.p(), i, i2);
        AbstractC15863kI6.h(spannableString, c12863fI6.d(), i, i2);
    }

    public static final SpannableString b(C13245fu c13245fu, WH1 wh1, AbstractC9998au2.b bVar, C23001wA7 c23001wA7) {
        SpannableString spannableString = new SpannableString(c13245fu.k());
        List listH = c13245fu.h();
        if (listH != null) {
            int size = listH.size();
            for (int i = 0; i < size; i++) {
                C13245fu.d dVar = (C13245fu.d) listH.get(i);
                C12863fI6 c12863fI6 = (C12863fI6) dVar.a();
                a(spannableString, c12863fI6.a((65503 & 1) != 0 ? c12863fI6.g() : 0L, (65503 & 2) != 0 ? c12863fI6.b : 0L, (65503 & 4) != 0 ? c12863fI6.c : null, (65503 & 8) != 0 ? c12863fI6.d : null, (65503 & 16) != 0 ? c12863fI6.e : null, (65503 & 32) != 0 ? c12863fI6.f : null, (65503 & 64) != 0 ? c12863fI6.g : null, (65503 & 128) != 0 ? c12863fI6.h : 0L, (65503 & 256) != 0 ? c12863fI6.i : null, (65503 & 512) != 0 ? c12863fI6.j : null, (65503 & 1024) != 0 ? c12863fI6.k : null, (65503 & 2048) != 0 ? c12863fI6.l : 0L, (65503 & 4096) != 0 ? c12863fI6.m : null, (65503 & 8192) != 0 ? c12863fI6.n : null, (65503 & 16384) != 0 ? c12863fI6.o : null, (65503 & 32768) != 0 ? c12863fI6.p : null), dVar.b(), dVar.c(), wh1, bVar);
            }
        }
        List listL = c13245fu.l(0, c13245fu.length());
        int size2 = listL.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C13245fu.d dVar2 = (C13245fu.d) listL.get(i2);
            spannableString.setSpan(AbstractC4148Dw7.a((AbstractC3914Cw7) dVar2.a()), dVar2.b(), dVar2.c(), 33);
        }
        List listM = c13245fu.m(0, c13245fu.length());
        int size3 = listM.size();
        for (int i3 = 0; i3 < size3; i3++) {
            C13245fu.d dVar3 = (C13245fu.d) listM.get(i3);
            spannableString.setSpan(c23001wA7.c((C12255eI7) dVar3.a()), dVar3.b(), dVar3.c(), 33);
        }
        List listE = c13245fu.e(0, c13245fu.length());
        int size4 = listE.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C13245fu.d dVar4 = (C13245fu.d) listE.get(i4);
            if (dVar4.h() != dVar4.f()) {
                AbstractC13406gA3 abstractC13406gA3 = (AbstractC13406gA3) dVar4.g();
                if ((abstractC13406gA3 instanceof AbstractC13406gA3.b) && abstractC13406gA3.a() == null) {
                    spannableString.setSpan(c23001wA7.b(c(dVar4)), dVar4.h(), dVar4.f(), 33);
                } else {
                    spannableString.setSpan(c23001wA7.a(dVar4), dVar4.h(), dVar4.f(), 33);
                }
            }
        }
        return spannableString;
    }

    private static final C13245fu.d c(C13245fu.d dVar) {
        Object objG = dVar.g();
        AbstractC13042fc3.g(objG, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        return new C13245fu.d((AbstractC13406gA3.b) objG, dVar.h(), dVar.f());
    }
}
