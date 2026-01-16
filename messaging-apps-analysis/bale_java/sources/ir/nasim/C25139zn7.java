package ir.nasim;

import ir.nasim.InterfaceC25129zm7;

/* renamed from: ir.nasim.zn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C25139zn7 {
    public static final C25139zn7 a = new C25139zn7();

    private C25139zn7() {
    }

    public final void a(UE0 ue0, C13774gn7 c13774gn7) {
        boolean z = c13774gn7.i() && !AbstractC23365wn7.g(c13774gn7.l().f(), AbstractC23365wn7.a.e());
        if (z) {
            float fB = (int) (c13774gn7.B() >> 32);
            float fB2 = (int) (c13774gn7.B() & 4294967295L);
            CK5 ck5B = FK5.b(ZG4.b.c(), OD6.d((Float.floatToRawIntBits(fB2) & 4294967295L) | (Float.floatToRawIntBits(fB) << 32)));
            ue0.n();
            UE0.s(ue0, ck5B, 0, 2, null);
        }
        C12863fI6 c12863fI6Y = c13774gn7.l().i().y();
        C24525yl7 c24525yl7S = c12863fI6Y.s();
        if (c24525yl7S == null) {
            c24525yl7S = C24525yl7.b.c();
        }
        C24525yl7 c24525yl7 = c24525yl7S;
        C5566Jw6 c5566Jw6R = c12863fI6Y.r();
        if (c5566Jw6R == null) {
            c5566Jw6R = C5566Jw6.d.a();
        }
        C5566Jw6 c5566Jw6 = c5566Jw6R;
        AbstractC18051o02 abstractC18051o02H = c12863fI6Y.h();
        if (abstractC18051o02H == null) {
            abstractC18051o02H = C8568Wn2.a;
        }
        AbstractC18051o02 abstractC18051o02 = abstractC18051o02H;
        try {
            AbstractC12520el0 abstractC12520el0F = c12863fI6Y.f();
            if (abstractC12520el0F != null) {
                c13774gn7.w().I(ue0, abstractC12520el0F, (64 & 4) != 0 ? Float.NaN : c12863fI6Y.t() != InterfaceC25129zm7.b.b ? c12863fI6Y.t().a() : 1.0f, (64 & 8) != 0 ? null : c5566Jw6, (64 & 16) != 0 ? null : c24525yl7, (64 & 32) != 0 ? null : abstractC18051o02, (64 & 64) != 0 ? InterfaceC17460n02.i0.a() : 0);
            } else {
                c13774gn7.w().G(ue0, (32 & 2) != 0 ? C24381yX0.b.i() : c12863fI6Y.t() != InterfaceC25129zm7.b.b ? c12863fI6Y.t().d() : C24381yX0.b.a(), (32 & 4) != 0 ? null : c5566Jw6, (32 & 8) != 0 ? null : c24525yl7, (32 & 16) == 0 ? abstractC18051o02 : null, (32 & 32) != 0 ? InterfaceC17460n02.i0.a() : 0);
            }
            if (z) {
                ue0.i();
            }
        } catch (Throwable th) {
            if (z) {
                ue0.i();
            }
            throw th;
        }
    }
}
