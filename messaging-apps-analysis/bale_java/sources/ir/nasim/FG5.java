package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public final class FG5 extends AbstractC6200Mp2 implements EG5 {

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String str) {
            AbstractC13042fc3.i(str, "it");
            return AbstractC13042fc3.q("(raw) ", str);
        }
    }

    private FG5(XC6 xc6, XC6 xc62, boolean z) {
        super(xc6, xc62);
        if (z) {
            return;
        }
        InterfaceC4333Er3.a.b(xc6, xc62);
    }

    private static final boolean X0(String str, String str2) {
        return AbstractC13042fc3.d(str, AbstractC20762sZ6.C0(str2, "out ")) || AbstractC13042fc3.d(str2, Separators.STAR);
    }

    private static final List Y0(FI1 fi1, AbstractC4099Dr3 abstractC4099Dr3) {
        List listJ0 = abstractC4099Dr3.J0();
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
        Iterator it = listJ0.iterator();
        while (it.hasNext()) {
            arrayList.add(fi1.y((InterfaceC3932Cy7) it.next()));
        }
        return arrayList;
    }

    private static final String Z0(String str, String str2) {
        if (!AbstractC20762sZ6.W(str, '<', false, 2, null)) {
            return str;
        }
        return AbstractC20762sZ6.g1(str, '<', null, 2, null) + '<' + str2 + '>' + AbstractC20762sZ6.c1(str, '>', null, 2, null);
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public XC6 R0() {
        return S0();
    }

    @Override // ir.nasim.AbstractC6200Mp2
    public String U0(FI1 fi1, II1 ii1) {
        AbstractC13042fc3.i(fi1, "renderer");
        AbstractC13042fc3.i(ii1, "options");
        String strX = fi1.x(S0());
        String strX2 = fi1.x(T0());
        if (ii1.j()) {
            return "raw (" + strX + ".." + strX2 + ')';
        }
        if (T0().J0().isEmpty()) {
            return fi1.u(strX, strX2, AbstractC7731Sy7.e(this));
        }
        List listY0 = Y0(fi1, S0());
        List listY02 = Y0(fi1, T0());
        List list = listY0;
        String strA0 = AbstractC15401jX0.A0(list, ", ", null, null, 0, null, a.e, 30, null);
        List<XV4> listV1 = AbstractC15401jX0.v1(list, listY02);
        if ((listV1 instanceof Collection) && listV1.isEmpty()) {
            strX2 = Z0(strX2, strA0);
        } else {
            for (XV4 xv4 : listV1) {
                if (!X0((String) xv4.e(), (String) xv4.f())) {
                    break;
                }
            }
            strX2 = Z0(strX2, strA0);
        }
        String strZ0 = Z0(strX, strA0);
        return AbstractC13042fc3.d(strZ0, strX2) ? strZ0 : fi1.u(strZ0, strX2, AbstractC7731Sy7.e(this));
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public FG5 O0(boolean z) {
        return new FG5(S0().O0(z), T0().O0(z));
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public AbstractC6200Mp2 U0(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        return new FG5((XC6) abstractC5284Ir3.g(S0()), (XC6) abstractC5284Ir3.g(T0()), true);
    }

    @Override // ir.nasim.AbstractC18174oC7
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public FG5 Q0(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "newAnnotations");
        return new FG5(S0().Q0(interfaceC4356Eu), T0().Q0(interfaceC4356Eu));
    }

    @Override // ir.nasim.AbstractC6200Mp2, ir.nasim.AbstractC4099Dr3
    public W24 o() {
        MU0 mu0T = K0().t();
        InterfaceC21331tU0 interfaceC21331tU0 = mu0T instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0T : null;
        if (interfaceC21331tU0 == null) {
            throw new IllegalStateException(AbstractC13042fc3.q("Incorrect classifier: ", K0().t()).toString());
        }
        W24 w24H = interfaceC21331tU0.H(DG5.c);
        AbstractC13042fc3.h(w24H, "classDescriptor.getMemberScope(RawSubstitution)");
        return w24H;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FG5(XC6 xc6, XC6 xc62) {
        this(xc6, xc62, false);
        AbstractC13042fc3.i(xc6, "lowerBound");
        AbstractC13042fc3.i(xc62, "upperBound");
    }
}
