package ir.nasim;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import ir.nasim.C13245fu;
import ir.nasim.C14377ho7;
import ir.nasim.C24525yl7;
import ir.nasim.C4888Gz3;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.kI6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15863kI6 {

    /* renamed from: ir.nasim.kI6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ Spannable e;
        final /* synthetic */ InterfaceC16978mB2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Spannable spannable, InterfaceC16978mB2 interfaceC16978mB2) {
            super(3);
            this.e = spannable;
            this.f = interfaceC16978mB2;
        }

        public final void a(C12863fI6 c12863fI6, int i, int i2) {
            Spannable spannable = this.e;
            InterfaceC16978mB2 interfaceC16978mB2 = this.f;
            AbstractC9998au2 abstractC9998au2I = c12863fI6.i();
            C4593Fu2 c4593Fu2N = c12863fI6.n();
            if (c4593Fu2N == null) {
                c4593Fu2N = C4593Fu2.b.d();
            }
            C3418Au2 c3418Au2L = c12863fI6.l();
            C3418Au2 c3418Au2C = C3418Au2.c(c3418Au2L != null ? c3418Au2L.i() : C3418Au2.b.b());
            C3657Bu2 c3657Bu2M = c12863fI6.m();
            spannable.setSpan(new C20428rz7((Typeface) interfaceC16978mB2.e(abstractC9998au2I, c4593Fu2N, c3418Au2C, C3657Bu2.e(c3657Bu2M != null ? c3657Bu2M.m() : C3657Bu2.b.a()))), i, i2, 33);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((C12863fI6) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    private static final MetricAffectingSpan a(long j, WH1 wh1) {
        long jG = C13193fo7.g(j);
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.b())) {
            return new C7966Ty3(wh1.I0(j));
        }
        if (C14377ho7.g(jG, aVar.a())) {
            return new C7727Sy3(C13193fo7.h(j));
        }
        return null;
    }

    public static final void b(C12863fI6 c12863fI6, List list, InterfaceC15796kB2 interfaceC15796kB2) {
        if (list.size() <= 1) {
            if (!list.isEmpty()) {
                interfaceC15796kB2.q(f(c12863fI6, (C12863fI6) ((C13245fu.d) list.get(0)).g()), Integer.valueOf(((C13245fu.d) list.get(0)).h()), Integer.valueOf(((C13245fu.d) list.get(0)).f()));
                return;
            }
            return;
        }
        int size = list.size();
        int i = size * 2;
        int[] iArr = new int[i];
        List list2 = list;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i2);
            iArr[i2] = dVar.h();
            iArr[i2 + size] = dVar.f();
        }
        AbstractC9648aK.H(iArr);
        int iA0 = AbstractC10242bK.a0(iArr);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            if (i4 != iA0) {
                int size3 = list2.size();
                C12863fI6 c12863fI6F = c12863fI6;
                for (int i5 = 0; i5 < size3; i5++) {
                    C13245fu.d dVar2 = (C13245fu.d) list.get(i5);
                    if (dVar2.h() != dVar2.f() && AbstractC13836gu.i(iA0, i4, dVar2.h(), dVar2.f())) {
                        c12863fI6F = f(c12863fI6F, (C12863fI6) dVar2.g());
                    }
                }
                if (c12863fI6F != null) {
                    interfaceC15796kB2.q(c12863fI6F, Integer.valueOf(iA0), Integer.valueOf(i4));
                }
                iA0 = i4;
            }
        }
    }

    private static final boolean c(C12863fI6 c12863fI6) {
        long jG = C13193fo7.g(c12863fI6.o());
        C14377ho7.a aVar = C14377ho7.b;
        return C14377ho7.g(jG, aVar.b()) || C14377ho7.g(C13193fo7.g(c12863fI6.o()), aVar.a());
    }

    private static final boolean d(C9348Zn7 c9348Zn7) {
        return AbstractC23955xn7.d(c9348Zn7.N()) || c9348Zn7.n() != null;
    }

    private static final boolean e(WH1 wh1) {
        return ((double) wh1.t1()) > 1.05d;
    }

    private static final C12863fI6 f(C12863fI6 c12863fI6, C12863fI6 c12863fI62) {
        return c12863fI6 == null ? c12863fI62 : c12863fI6.y(c12863fI62);
    }

    private static final float g(long j, float f, WH1 wh1) {
        float fH;
        long jG = C13193fo7.g(j);
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.b())) {
            if (!e(wh1)) {
                return wh1.I0(j);
            }
            fH = C13193fo7.h(j) / C13193fo7.h(wh1.j0(f));
        } else {
            if (!C14377ho7.g(jG, aVar.a())) {
                return Float.NaN;
            }
            fH = C13193fo7.h(j);
        }
        return fH * f;
    }

    public static final void h(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            v(spannable, new BackgroundColorSpan(DX0.k(j)), i, i2);
        }
    }

    private static final void i(Spannable spannable, C18413od0 c18413od0, int i, int i2) {
        if (c18413od0 != null) {
            v(spannable, new C19595qd0(c18413od0.h()), i, i2);
        }
    }

    private static final void j(Spannable spannable, AbstractC12520el0 abstractC12520el0, float f, int i, int i2) {
        if (abstractC12520el0 != null) {
            if (abstractC12520el0 instanceof CH6) {
                l(spannable, ((CH6) abstractC12520el0).b(), i, i2);
            } else if (abstractC12520el0 instanceof AbstractC4147Dw6) {
                v(spannable, new C4381Ew6((AbstractC4147Dw6) abstractC12520el0, f), i, i2);
            }
        }
    }

    public static final void k(Spannable spannable, List list, float f, WH1 wh1, C5477Jm7 c5477Jm7) {
        if (c5477Jm7 != null) {
            long jG = C13193fo7.g(c5477Jm7.b());
            C14377ho7.a aVar = C14377ho7.b;
            if (C14377ho7.g(jG, aVar.b())) {
                wh1.I0(c5477Jm7.b());
            } else if (C14377ho7.g(jG, aVar.a())) {
                C13193fo7.h(c5477Jm7.b());
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((C13245fu.d) list.get(i)).g();
        }
    }

    public static final void l(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            v(spannable, new ForegroundColorSpan(DX0.k(j)), i, i2);
        }
    }

    private static final void m(Spannable spannable, AbstractC18051o02 abstractC18051o02, int i, int i2) {
        if (abstractC18051o02 != null) {
            v(spannable, new C18642p02(abstractC18051o02), i, i2);
        }
    }

    private static final void n(Spannable spannable, C9348Zn7 c9348Zn7, List list, InterfaceC16978mB2 interfaceC16978mB2) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i);
            if ((dVar.g() instanceof C12863fI6) && (AbstractC23955xn7.d((C12863fI6) dVar.g()) || ((C12863fI6) dVar.g()).m() != null)) {
                AbstractC13042fc3.g(dVar, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                arrayList.add(dVar);
            }
        }
        b(d(c9348Zn7) ? new C12863fI6(0L, 0L, c9348Zn7.o(), c9348Zn7.m(), c9348Zn7.n(), c9348Zn7.j(), (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65475, (ED1) null) : null, arrayList, new a(spannable, interfaceC16978mB2));
    }

    private static final void o(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            v(spannable, new C13839gu2(str), i, i2);
        }
    }

    public static final void p(Spannable spannable, long j, WH1 wh1, int i, int i2) {
        long jG = C13193fo7.g(j);
        C14377ho7.a aVar = C14377ho7.b;
        if (C14377ho7.g(jG, aVar.b())) {
            v(spannable, new AbsoluteSizeSpan(AbstractC20723sV3.d(wh1.I0(j)), false), i, i2);
        } else if (C14377ho7.g(jG, aVar.a())) {
            v(spannable, new RelativeSizeSpan(C13193fo7.h(j)), i, i2);
        }
    }

    private static final void q(Spannable spannable, C3590Bm7 c3590Bm7, int i, int i2) {
        if (c3590Bm7 != null) {
            v(spannable, new ScaleXSpan(c3590Bm7.b()), i, i2);
            v(spannable, new C12218eE6(c3590Bm7.c()), i, i2);
        }
    }

    public static final void r(Spannable spannable, long j, float f, WH1 wh1, C4888Gz3 c4888Gz3) {
        float fG = g(j, f, wh1);
        if (Float.isNaN(fG)) {
            return;
        }
        v(spannable, new C5122Hz3(fG, 0, (spannable.length() == 0 || AbstractC22039uZ6.u1(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), C4888Gz3.d.h(c4888Gz3.d()), C4888Gz3.d.i(c4888Gz3.d()), c4888Gz3.b(), C4888Gz3.c.f(c4888Gz3.c(), C4888Gz3.c.b.b())), 0, spannable.length());
    }

    public static final void s(Spannable spannable, long j, float f, WH1 wh1) {
        float fG = g(j, f, wh1);
        if (Float.isNaN(fG)) {
            return;
        }
        v(spannable, new C4654Fz3(fG), 0, spannable.length());
    }

    public static final void t(Spannable spannable, IH3 ih3, int i, int i2) {
        if (ih3 != null) {
            v(spannable, LH3.a.a(ih3), i, i2);
        }
    }

    private static final void u(Spannable spannable, C5566Jw6 c5566Jw6, int i, int i2) {
        if (c5566Jw6 != null) {
            v(spannable, new C6527Nw6(DX0.k(c5566Jw6.c()), Float.intBitsToFloat((int) (c5566Jw6.d() >> 32)), Float.intBitsToFloat((int) (c5566Jw6.d() & 4294967295L)), AbstractC23955xn7.b(c5566Jw6.b())), i, i2);
        }
    }

    public static final void v(Spannable spannable, Object obj, int i, int i2) {
        spannable.setSpan(obj, i, i2, 33);
    }

    private static final void w(Spannable spannable, C12863fI6 c12863fI6, int i, int i2, WH1 wh1) {
        i(spannable, c12863fI6.e(), i, i2);
        l(spannable, c12863fI6.g(), i, i2);
        j(spannable, c12863fI6.f(), c12863fI6.c(), i, i2);
        y(spannable, c12863fI6.s(), i, i2);
        p(spannable, c12863fI6.k(), wh1, i, i2);
        o(spannable, c12863fI6.j(), i, i2);
        q(spannable, c12863fI6.u(), i, i2);
        t(spannable, c12863fI6.p(), i, i2);
        h(spannable, c12863fI6.d(), i, i2);
        u(spannable, c12863fI6.r(), i, i2);
        m(spannable, c12863fI6.h(), i, i2);
    }

    public static final void x(Spannable spannable, C9348Zn7 c9348Zn7, List list, WH1 wh1, InterfaceC16978mB2 interfaceC16978mB2) {
        MetricAffectingSpan metricAffectingSpanA;
        n(spannable, c9348Zn7, list, interfaceC16978mB2);
        List list2 = list;
        int size = list2.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i);
            if (dVar.g() instanceof C12863fI6) {
                int iH = dVar.h();
                int iF = dVar.f();
                if (iH >= 0 && iH < spannable.length() && iF > iH && iF <= spannable.length()) {
                    w(spannable, (C12863fI6) dVar.g(), iH, iF, wh1);
                    if (c((C12863fI6) dVar.g())) {
                        z = true;
                    }
                }
            }
        }
        if (z) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                C13245fu.d dVar2 = (C13245fu.d) list.get(i2);
                C13245fu.a aVar = (C13245fu.a) dVar2.g();
                if (aVar instanceof C12863fI6) {
                    int iH2 = dVar2.h();
                    int iF2 = dVar2.f();
                    if (iH2 >= 0 && iH2 < spannable.length() && iF2 > iH2 && iF2 <= spannable.length() && (metricAffectingSpanA = a(((C12863fI6) aVar).o(), wh1)) != null) {
                        v(spannable, metricAffectingSpanA, iH2, iF2);
                    }
                }
            }
        }
    }

    public static final void y(Spannable spannable, C24525yl7 c24525yl7, int i, int i2) {
        if (c24525yl7 != null) {
            C24525yl7.a aVar = C24525yl7.b;
            v(spannable, new C25119zl7(c24525yl7.d(aVar.d()), c24525yl7.d(aVar.b())), i, i2);
        }
    }

    public static final void z(Spannable spannable, C5477Jm7 c5477Jm7, float f, WH1 wh1) {
        if (c5477Jm7 != null) {
            if ((C13193fo7.e(c5477Jm7.b(), AbstractC13784go7.g(0)) && C13193fo7.e(c5477Jm7.c(), AbstractC13784go7.g(0))) || C13193fo7.f(c5477Jm7.b()) == 0 || C13193fo7.f(c5477Jm7.c()) == 0) {
                return;
            }
            long jG = C13193fo7.g(c5477Jm7.b());
            C14377ho7.a aVar = C14377ho7.b;
            float fH = 0.0f;
            float fI0 = C14377ho7.g(jG, aVar.b()) ? wh1.I0(c5477Jm7.b()) : C14377ho7.g(jG, aVar.a()) ? C13193fo7.h(c5477Jm7.b()) * f : 0.0f;
            long jG2 = C13193fo7.g(c5477Jm7.c());
            if (C14377ho7.g(jG2, aVar.b())) {
                fH = wh1.I0(c5477Jm7.c());
            } else if (C14377ho7.g(jG2, aVar.a())) {
                fH = C13193fo7.h(c5477Jm7.c()) * f;
            }
            v(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fI0), (int) Math.ceil(fH)), 0, spannable.length());
        }
    }
}
