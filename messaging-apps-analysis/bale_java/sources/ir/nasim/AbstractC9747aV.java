package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.gov.nist.core.Separators;
import android.graphics.Paint;
import android.graphics.Rect;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.aV, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC9747aV {
    private static final List a = AbstractC10360bX0.p(C24381yX0.k(DX0.d(4280391411L)), C24381yX0.k(DX0.d(4283610061L)), C24381yX0.k(DX0.d(4286476011L)), C24381yX0.k(DX0.d(4292760647L)), C24381yX0.k(DX0.d(4293819959L)), C24381yX0.k(DX0.d(4293746827L)), C24381yX0.k(DX0.d(4285187388L)));
    private static final float b = C17784nZ1.q(50);
    private static final float c = C17784nZ1.q(18);

    /* renamed from: ir.nasim.aV$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        public final void a(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-563627171);
            int i2 = 0;
            for (Object obj : this.a) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    AbstractC10360bX0.w();
                }
                androidx.compose.foundation.layout.f.a(AbstractC9747aV.k(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, AbstractC9747aV.b), i2, (String) obj, 0.0f, false, null, 20, null), interfaceC22053ub1, 0);
                i2 = i3;
            }
            interfaceC22053ub1.Q();
            androidx.compose.foundation.layout.f.a(AbstractC9747aV.k(androidx.compose.foundation.layout.t.t(androidx.compose.ui.e.a, AbstractC9747aV.b), AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, "First Name", 0.0f, true, null, 20, null), interfaceC22053ub1, 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.aV$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9747aV.d(this.a, interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1433122324);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ c24254yJ = C24254yJ.a;
            float f = 8;
            AbstractC12582er2.b(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16)), c24254yJ.o(C17784nZ1.q(f)), c24254yJ.o(C17784nZ1.q(f)), null, 0, 0, AbstractC19242q11.e(1848577127, true, new a(list), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1573302, 56);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ZU
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9747aV.e(list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$titles");
        d(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void f(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(list, "names");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(86672846);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(1278776883, true, new b(list), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.XU
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9747aV.g(list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$names");
        f(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final androidx.compose.ui.e j(androidx.compose.ui.e eVar, int i, String str, float f, boolean z, List list) {
        String upperCase;
        AbstractC13042fc3.i(eVar, "$this$drawAvatarPlaceHolder");
        AbstractC13042fc3.i(list, "backgroundColors");
        if (z) {
            upperCase = "";
        } else if (str == null || !(!AbstractC20762sZ6.n0(str))) {
            upperCase = Separators.QUESTION;
        } else {
            String strValueOf = String.valueOf(AbstractC22039uZ6.s1(AbstractC20762sZ6.n1(str).toString()));
            AbstractC13042fc3.g(strValueOf, "null cannot be cast to non-null type java.lang.String");
            upperCase = strValueOf.toUpperCase(Locale.ROOT);
            AbstractC13042fc3.h(upperCase, "toUpperCase(...)");
        }
        return l(eVar, upperCase, f, ((C24381yX0) list.get(i == 0 ? AbstractC22039uZ6.s1(upperCase) % list.size() : Math.abs(i) % list.size())).y());
    }

    public static /* synthetic */ androidx.compose.ui.e k(androidx.compose.ui.e eVar, int i, String str, float f, boolean z, List list, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = c;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 16) != 0) {
            list = a;
        }
        return j(eVar, i, str, f2, z2, list);
    }

    public static final androidx.compose.ui.e l(androidx.compose.ui.e eVar, final String str, final float f, final long j) {
        AbstractC13042fc3.i(eVar, "$this$drawCircleTextPlaceHolderBackground");
        AbstractC13042fc3.i(str, "placeholderTitle");
        final Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setTypeface(C6011Lu2.i());
        return eVar.i(androidx.compose.ui.draw.b.b(androidx.compose.ui.e.a, new UA2() { // from class: ir.nasim.YU
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC9747aV.m(paint, f, j, str, (InterfaceC17460n02) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(Paint paint, float f, long j, String str, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(paint, "$textPaint");
        AbstractC13042fc3.i(str, "$placeholderTitle");
        AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
        paint.setTextSize(interfaceC17460n02.w1(f));
        CK5 ck5 = new CK5(0.0f, 0.0f, Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)), Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L)));
        InterfaceC17460n02.L(interfaceC17460n02, j, Math.min(Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)), Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L))) / 2.0f, ck5.h(), 0.0f, null, null, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, null);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        float fIntBitsToFloat = Float.intBitsToFloat((int) (ck5.h() >> 32));
        float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (ck5.h() & 4294967295L)) - (r2.height() / 2.0f)) - r2.top;
        AbstractC7624Sn.d(interfaceC17460n02.z1().e()).drawText(str, fIntBitsToFloat, fIntBitsToFloat2, paint);
        AbstractC7624Sn.d(interfaceC17460n02.z1().e()).drawText(str, fIntBitsToFloat, fIntBitsToFloat2, paint);
        return C19938rB7.a;
    }
}
