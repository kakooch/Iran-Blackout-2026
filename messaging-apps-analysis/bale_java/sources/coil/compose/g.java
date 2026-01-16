package coil.compose;

import android.content.Context;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.compose.AsyncImagePainter;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13301g;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.AbstractC4663Ga3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC6919Pn6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9601aE6;
import ir.nasim.AbstractC9939ao6;
import ir.nasim.B26;
import ir.nasim.C17833ne1;
import ir.nasim.C19938rB7;
import ir.nasim.C20213re1;
import ir.nasim.EnumC14254hc6;
import ir.nasim.FT1;
import ir.nasim.InterfaceC11943do6;
import ir.nasim.InterfaceC13157fl1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OD6;
import ir.nasim.PD6;
import ir.nasim.UA2;
import ir.nasim.W23;
import ir.nasim.ZD6;

/* loaded from: classes2.dex */
public abstract class g {
    private static final long a = C17833ne1.b.c(0, 0);
    private static final ZD6 b = AbstractC9601aE6.a(PD6.d);

    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.e = str;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.e0(interfaceC11943do6, this.e);
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.e());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(UA2 ua2, UA2 ua22, UA2 ua23) {
            super(1);
            this.e = ua2;
            this.f = ua22;
            this.g = ua23;
        }

        public final void a(AsyncImagePainter.State state) {
            if (state instanceof AsyncImagePainter.State.Loading) {
                UA2 ua2 = this.e;
                if (ua2 != null) {
                    ua2.invoke(state);
                    return;
                }
                return;
            }
            if (state instanceof AsyncImagePainter.State.Success) {
                UA2 ua22 = this.f;
                if (ua22 != null) {
                    ua22.invoke(state);
                    return;
                }
                return;
            }
            if (!(state instanceof AsyncImagePainter.State.Error)) {
                boolean z = state instanceof AsyncImagePainter.State.a;
                return;
            }
            UA2 ua23 = this.g;
            if (ua23 != null) {
                ua23.invoke(state);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AsyncImagePainter.State) obj);
            return C19938rB7.a;
        }
    }

    public static final float a(long j, float f) {
        return AbstractC23053wG5.l(f, C17833ne1.m(j), C17833ne1.k(j));
    }

    public static final float b(long j, float f) {
        return AbstractC23053wG5.l(f, C17833ne1.n(j), C17833ne1.l(j));
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, String str) {
        return str != null ? AbstractC6919Pn6.d(eVar, false, new a(str), 1, null) : eVar;
    }

    public static final long d() {
        return a;
    }

    public static final boolean e(long j) {
        return ((double) OD6.i(j)) >= 0.5d && ((double) OD6.g(j)) >= 0.5d;
    }

    public static final UA2 f(UA2 ua2, UA2 ua22, UA2 ua23) {
        if (ua2 == null && ua22 == null && ua23 == null) {
            return null;
        }
        return new b(ua2, ua22, ua23);
    }

    public static final W23 g(Object obj, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.A(1087186730);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1087186730, i, -1, "coil.compose.requestOf (utils.kt:31)");
        }
        if (obj instanceof W23) {
            W23 w23 = (W23) obj;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.U();
            return w23;
        }
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        interfaceC22053ub1.A(375474364);
        boolean zV = interfaceC22053ub1.V(context) | interfaceC22053ub1.V(obj);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new W23.a(context).d(obj).a();
            interfaceC22053ub1.s(objB);
        }
        W23 w232 = (W23) objB;
        interfaceC22053ub1.U();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return w232;
    }

    public static final W23 h(Object obj, InterfaceC13157fl1 interfaceC13157fl1, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        ZD6 zd6;
        interfaceC22053ub1.A(1677680258);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1677680258, i, -1, "coil.compose.requestOfWithSizeResolver (utils.kt:50)");
        }
        boolean z = obj instanceof W23;
        if (z) {
            W23 w23 = (W23) obj;
            if (w23.q().m() != null) {
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
                interfaceC22053ub1.U();
                return w23;
            }
        }
        interfaceC22053ub1.A(-679565543);
        if (AbstractC13042fc3.d(interfaceC13157fl1, InterfaceC13157fl1.a.g())) {
            zd6 = b;
        } else {
            interfaceC22053ub1.A(-679565452);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C20213re1();
                interfaceC22053ub1.s(objB);
            }
            zd6 = (C20213re1) objB;
            interfaceC22053ub1.U();
        }
        interfaceC22053ub1.U();
        if (z) {
            interfaceC22053ub1.A(-679565365);
            interfaceC22053ub1.A(-679565358);
            boolean zV = interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(zd6);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = W23.R((W23) obj, null, 1, null).o(zd6).a();
                interfaceC22053ub1.s(objB2);
            }
            W23 w232 = (W23) objB2;
            interfaceC22053ub1.U();
            interfaceC22053ub1.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.U();
            return w232;
        }
        interfaceC22053ub1.A(-679565199);
        Context context = (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g());
        interfaceC22053ub1.A(-679565153);
        boolean zV2 = interfaceC22053ub1.V(context) | interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(zd6);
        Object objB3 = interfaceC22053ub1.B();
        if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
            objB3 = new W23.a(context).d(obj).o(zd6).a();
            interfaceC22053ub1.s(objB3);
        }
        W23 w233 = (W23) objB3;
        interfaceC22053ub1.U();
        interfaceC22053ub1.U();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.U();
        return w233;
    }

    public static final long i(long j) {
        return AbstractC4663Ga3.a(AbstractC20723sV3.d(OD6.i(j)), AbstractC20723sV3.d(OD6.g(j)));
    }

    public static final EnumC14254hc6 j(InterfaceC13157fl1 interfaceC13157fl1) {
        InterfaceC13157fl1.a aVar = InterfaceC13157fl1.a;
        return AbstractC13042fc3.d(interfaceC13157fl1, aVar.e()) ? true : AbstractC13042fc3.d(interfaceC13157fl1, aVar.f()) ? EnumC14254hc6.b : EnumC14254hc6.a;
    }

    public static final PD6 k(long j) {
        if (C17833ne1.p(j)) {
            return null;
        }
        return new PD6(C17833ne1.h(j) ? AbstractC13301g.a(C17833ne1.l(j)) : FT1.b.a, C17833ne1.g(j) ? AbstractC13301g.a(C17833ne1.k(j)) : FT1.b.a);
    }
}
