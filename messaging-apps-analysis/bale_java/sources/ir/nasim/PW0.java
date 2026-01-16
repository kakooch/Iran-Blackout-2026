package ir.nasim;

import androidx.compose.ui.semantics.SemanticsConfiguration;
import ir.nasim.X2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class PW0 {

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    private static final boolean a(List list) {
        List listM;
        long jT;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() <= 1) {
            listM = AbstractC10360bX0.m();
        } else {
            ArrayList arrayList = new ArrayList();
            Object obj = list.get(0);
            int iO = AbstractC10360bX0.o(list);
            int i = 0;
            while (i < iO) {
                i++;
                Object obj2 = list.get(i);
                C7631Sn6 c7631Sn6 = (C7631Sn6) obj2;
                C7631Sn6 c7631Sn62 = (C7631Sn6) obj;
                arrayList.add(ZG4.d(ZG4.e((Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (c7631Sn62.i().h() >> 32)) - Float.intBitsToFloat((int) (c7631Sn6.i().h() >> 32)))) << 32) | (Float.floatToRawIntBits(Math.abs(Float.intBitsToFloat((int) (c7631Sn62.i().h() & 4294967295L)) - Float.intBitsToFloat((int) (c7631Sn6.i().h() & 4294967295L)))) & 4294967295L))));
                obj = obj2;
            }
            listM = arrayList;
        }
        if (listM.size() == 1) {
            jT = ((ZG4) AbstractC15401jX0.q0(listM)).t();
        } else {
            if (listM.isEmpty()) {
                AbstractC12806fC3.f("Empty collection can't be reduced.");
            }
            Object objQ0 = AbstractC15401jX0.q0(listM);
            int iO2 = AbstractC10360bX0.o(listM);
            if (1 <= iO2) {
                int i2 = 1;
                while (true) {
                    objQ0 = ZG4.d(ZG4.q(((ZG4) objQ0).t(), ((ZG4) listM.get(i2)).t()));
                    if (i2 == iO2) {
                        break;
                    }
                    i2++;
                }
            }
            jT = ((ZG4) objQ0).t();
        }
        return Float.intBitsToFloat((int) (4294967295L & jT)) < Float.intBitsToFloat((int) (jT >> 32));
    }

    public static final boolean b(C7631Sn6 c7631Sn6) {
        SemanticsConfiguration semanticsConfigurationN = c7631Sn6.n();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        return (AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.a()) == null && AbstractC5719Kn6.a(c7631Sn6.n(), c8838Xn6.D()) == null) ? false : true;
    }

    private static final boolean c(OW0 ow0) {
        return ow0.b() < 0 || ow0.a() < 0;
    }

    public static final void d(C7631Sn6 c7631Sn6, X2 x2) {
        SemanticsConfiguration semanticsConfigurationN = c7631Sn6.n();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        OW0 ow0 = (OW0) AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.a());
        if (ow0 != null) {
            x2.r0(f(ow0));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (AbstractC5719Kn6.a(c7631Sn6.n(), c8838Xn6.D()) != null) {
            List listT = c7631Sn6.t();
            int size = listT.size();
            for (int i = 0; i < size; i++) {
                C7631Sn6 c7631Sn62 = (C7631Sn6) listT.get(i);
                if (c7631Sn62.n().i(C8838Xn6.a.E())) {
                    arrayList.add(c7631Sn62);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            boolean zA = a(arrayList);
            x2.r0(X2.e.b(zA ? 1 : arrayList.size(), zA ? arrayList.size() : 1, false, 0));
        }
    }

    public static final void e(C7631Sn6 c7631Sn6, X2 x2) {
        SemanticsConfiguration semanticsConfigurationN = c7631Sn6.n();
        C8838Xn6 c8838Xn6 = C8838Xn6.a;
        QW0 qw0 = (QW0) AbstractC5719Kn6.a(semanticsConfigurationN, c8838Xn6.b());
        if (qw0 != null) {
            x2.s0(g(qw0, c7631Sn6));
        }
        C7631Sn6 c7631Sn6R = c7631Sn6.r();
        if (c7631Sn6R == null || AbstractC5719Kn6.a(c7631Sn6R.n(), c8838Xn6.D()) == null) {
            return;
        }
        OW0 ow0 = (OW0) AbstractC5719Kn6.a(c7631Sn6R.n(), c8838Xn6.a());
        if ((ow0 == null || !c(ow0)) && c7631Sn6.n().i(c8838Xn6.E())) {
            ArrayList arrayList = new ArrayList();
            List listT = c7631Sn6R.t();
            int size = listT.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C7631Sn6 c7631Sn62 = (C7631Sn6) listT.get(i2);
                if (c7631Sn62.n().i(C8838Xn6.a.E())) {
                    arrayList.add(c7631Sn62);
                    if (c7631Sn62.q().B0() < c7631Sn6.q().B0()) {
                        i++;
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                boolean zA = a(arrayList);
                X2.f fVarA = X2.f.a(zA ? 0 : i, 1, zA ? i : 0, 1, false, ((Boolean) c7631Sn6.n().v(C8838Xn6.a.E(), a.e)).booleanValue());
                if (fVarA != null) {
                    x2.s0(fVarA);
                }
            }
        }
    }

    private static final X2.e f(OW0 ow0) {
        return X2.e.b(ow0.b(), ow0.a(), false, 0);
    }

    private static final X2.f g(QW0 qw0, C7631Sn6 c7631Sn6) {
        return X2.f.a(qw0.c(), qw0.d(), qw0.a(), qw0.b(), false, ((Boolean) c7631Sn6.n().v(C8838Xn6.a.E(), b.e)).booleanValue());
    }
}
