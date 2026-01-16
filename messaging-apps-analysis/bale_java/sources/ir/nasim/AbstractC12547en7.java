package ir.nasim;

import ir.nasim.AbstractC9998au2;
import java.util.List;

/* renamed from: ir.nasim.en7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC12547en7 {
    public static final boolean a(C13774gn7 c13774gn7, C13245fu c13245fu, C9348Zn7 c9348Zn7, List list, int i, boolean z, int i2, WH1 wh1, EnumC12613eu3 enumC12613eu3, AbstractC9998au2.b bVar, long j) {
        C13183fn7 c13183fn7L = c13774gn7.l();
        if (c13774gn7.w().j().a() || !AbstractC13042fc3.d(c13183fn7L.j(), c13245fu) || !c13183fn7L.i().G(c9348Zn7) || !AbstractC13042fc3.d(c13183fn7L.g(), list) || c13183fn7L.e() != i || c13183fn7L.h() != z || !AbstractC23365wn7.g(c13183fn7L.f(), i2) || !AbstractC13042fc3.d(c13183fn7L.b(), wh1) || c13183fn7L.d() != enumC12613eu3 || !AbstractC13042fc3.d(c13183fn7L.c(), bVar) || C17833ne1.n(j) != C17833ne1.n(c13183fn7L.a())) {
            return false;
        }
        if (z || AbstractC23365wn7.g(i2, AbstractC23365wn7.a.b())) {
            return C17833ne1.l(j) == C17833ne1.l(c13183fn7L.a()) && C17833ne1.k(j) == C17833ne1.k(c13183fn7L.a());
        }
        return true;
    }

    public static final float b(C13774gn7 c13774gn7, int i) {
        if (i < 0 || c13774gn7.l().j().length() == 0) {
            return 0.0f;
        }
        int iMin = Math.min(c13774gn7.w().p(i), Math.min(c13774gn7.w().w() - 1, c13774gn7.w().m() - 1));
        if (i > C24522yl4.o(c13774gn7.w(), iMin, false, 2, null)) {
            return 0.0f;
        }
        return c13774gn7.w().r(iMin);
    }
}
