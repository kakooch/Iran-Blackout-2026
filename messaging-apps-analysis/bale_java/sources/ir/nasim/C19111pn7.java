package ir.nasim;

import ir.nasim.AbstractC9998au2;
import java.util.List;

/* renamed from: ir.nasim.pn7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19111pn7 {
    public static final a f = new a(null);
    private final AbstractC9998au2.b a;
    private final WH1 b;
    private final EnumC12613eu3 c;
    private final int d;
    private final C11313cn7 e;

    /* renamed from: ir.nasim.pn7$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C13774gn7 b(C13183fn7 c13183fn7) {
            C25116zl4 c25116zl4 = new C25116zl4(c13183fn7.j(), AbstractC10560bo7.d(c13183fn7.i(), c13183fn7.d()), c13183fn7.g(), c13183fn7.b(), c13183fn7.c());
            int iN = C17833ne1.n(c13183fn7.a());
            int iL = ((c13183fn7.h() || AbstractC20311rn7.b(c13183fn7.f())) && C17833ne1.h(c13183fn7.a())) ? C17833ne1.l(c13183fn7.a()) : Integer.MAX_VALUE;
            int iE = (c13183fn7.h() || !AbstractC20311rn7.b(c13183fn7.f())) ? c13183fn7.e() : 1;
            if (iN != iL) {
                iL = AbstractC23053wG5.m(AbstractC13605gW4.d(c25116zl4.c()), iN, iL);
            }
            return new C13774gn7(c13183fn7, new C24522yl4(c25116zl4, C17833ne1.b.b(0, iL, 0, C17833ne1.k(c13183fn7.a())), iE, c13183fn7.f(), null), AbstractC19606qe1.d(c13183fn7.a(), C4414Fa3.c((((int) Math.ceil(r13.h())) & 4294967295L) | (((int) Math.ceil(r13.D())) << 32))), null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C19111pn7(AbstractC9998au2.b bVar, WH1 wh1, EnumC12613eu3 enumC12613eu3, int i) {
        this.a = bVar;
        this.b = wh1;
        this.c = enumC12613eu3;
        this.d = i;
        this.e = i > 0 ? new C11313cn7(i) : null;
    }

    public static /* synthetic */ C13774gn7 d(C19111pn7 c19111pn7, C13245fu c13245fu, C9348Zn7 c9348Zn7, int i, boolean z, int i2, List list, long j, EnumC12613eu3 enumC12613eu3, WH1 wh1, AbstractC9998au2.b bVar, boolean z2, int i3, Object obj) {
        return c19111pn7.c(c13245fu, (i3 & 2) != 0 ? C9348Zn7.d.a() : c9348Zn7, (i3 & 4) != 0 ? AbstractC23365wn7.a.a() : i, (i3 & 8) != 0 ? true : z, (i3 & 16) != 0 ? Integer.MAX_VALUE : i2, (i3 & 32) != 0 ? AbstractC10360bX0.m() : list, (i3 & 64) != 0 ? AbstractC19606qe1.b(0, 0, 0, 0, 15, null) : j, (i3 & 128) != 0 ? c19111pn7.c : enumC12613eu3, (i3 & 256) != 0 ? c19111pn7.b : wh1, (i3 & 512) != 0 ? c19111pn7.a : bVar, (i3 & 1024) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C13774gn7 a(String str, C9348Zn7 c9348Zn7, int i, boolean z, int i2, long j, EnumC12613eu3 enumC12613eu3, WH1 wh1, AbstractC9998au2.b bVar, boolean z2) {
        return d(this, new C13245fu(str, null, 2, 0 == true ? 1 : 0), c9348Zn7, i, z, i2, null, j, enumC12613eu3, wh1, bVar, z2, 32, null);
    }

    public final C13774gn7 c(C13245fu c13245fu, C9348Zn7 c9348Zn7, int i, boolean z, int i2, List list, long j, EnumC12613eu3 enumC12613eu3, WH1 wh1, AbstractC9998au2.b bVar, boolean z2) {
        C11313cn7 c11313cn7;
        C13183fn7 c13183fn7 = new C13183fn7(c13245fu, c9348Zn7, list, i2, z, i, wh1, enumC12613eu3, bVar, j, (ED1) null);
        C13774gn7 c13774gn7A = (z2 || (c11313cn7 = this.e) == null) ? null : c11313cn7.a(c13183fn7);
        if (c13774gn7A != null) {
            return c13774gn7A.a(c13183fn7, AbstractC19606qe1.d(j, C4414Fa3.c((AbstractC13605gW4.d(c13774gn7A.w().h()) & 4294967295L) | (AbstractC13605gW4.d(c13774gn7A.w().D()) << 32))));
        }
        C13774gn7 c13774gn7B = f.b(c13183fn7);
        C11313cn7 c11313cn72 = this.e;
        if (c11313cn72 == null) {
            return c13774gn7B;
        }
        c11313cn72.b(c13183fn7, c13774gn7B);
        return c13774gn7B;
    }
}
