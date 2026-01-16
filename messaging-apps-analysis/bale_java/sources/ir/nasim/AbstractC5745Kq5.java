package ir.nasim;

import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.Kq5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5745Kq5 {
    private static final Map a = AbstractC20051rO3.n(AbstractC4616Fw7.a(AbstractC10882cM5.b(String.class), AbstractC18503om0.z(DY6.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(Character.TYPE), AbstractC18503om0.s(YJ0.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(char[].class), AbstractC18503om0.c()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Double.TYPE), AbstractC18503om0.t(C15402jX1.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(double[].class), AbstractC18503om0.d()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Float.TYPE), AbstractC18503om0.v(C9361Zp2.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(float[].class), AbstractC18503om0.e()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Long.TYPE), AbstractC18503om0.x(C10237bJ3.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(long[].class), AbstractC18503om0.h()), AbstractC4616Fw7.a(AbstractC10882cM5.b(C14599iA7.class), AbstractC18503om0.C(C14599iA7.b)), AbstractC4616Fw7.a(AbstractC10882cM5.b(C15201jA7.class), AbstractC18503om0.n()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Integer.TYPE), AbstractC18503om0.w(C15431ja3.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(int[].class), AbstractC18503om0.f()), AbstractC4616Fw7.a(AbstractC10882cM5.b(C11540dA7.class), AbstractC18503om0.B(C11540dA7.b)), AbstractC4616Fw7.a(AbstractC10882cM5.b(C12183eA7.class), AbstractC18503om0.m()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Short.TYPE), AbstractC18503om0.y(C24660yz6.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(short[].class), AbstractC18503om0.k()), AbstractC4616Fw7.a(AbstractC10882cM5.b(C24771zA7.class), AbstractC18503om0.D(C24771zA7.b)), AbstractC4616Fw7.a(AbstractC10882cM5.b(AA7.class), AbstractC18503om0.o()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Byte.TYPE), AbstractC18503om0.r(C5488Jo0.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(byte[].class), AbstractC18503om0.b()), AbstractC4616Fw7.a(AbstractC10882cM5.b(C7743Sz7.class), AbstractC18503om0.A(C7743Sz7.b)), AbstractC4616Fw7.a(AbstractC10882cM5.b(C7979Tz7.class), AbstractC18503om0.l()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Boolean.TYPE), AbstractC18503om0.q(C7571Sh0.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(boolean[].class), AbstractC18503om0.a()), AbstractC4616Fw7.a(AbstractC10882cM5.b(C19938rB7.class), AbstractC18503om0.E(C19938rB7.a)), AbstractC4616Fw7.a(AbstractC10882cM5.b(Void.class), AbstractC18503om0.j()), AbstractC4616Fw7.a(AbstractC10882cM5.b(Q12.class), AbstractC18503om0.u(Q12.b)));

    public static final SerialDescriptor a(String str, AbstractC25167zq5 abstractC25167zq5) {
        AbstractC13042fc3.i(str, "serialName");
        AbstractC13042fc3.i(abstractC25167zq5, "kind");
        c(str);
        return new C3858Cq5(str, abstractC25167zq5);
    }

    private static final String b(String str) {
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append((Object) (Character.isLowerCase(cCharAt) ? AbstractC11632dL0.i(cCharAt) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    private static final void c(String str) {
        Iterator it = a.keySet().iterator();
        while (it.hasNext()) {
            String strP = ((InterfaceC11299cm3) it.next()).p();
            AbstractC13042fc3.f(strP);
            String strB = b(strP);
            if (AbstractC20153rZ6.D(str, "kotlin." + strB, true) || AbstractC20153rZ6.D(str, strB, true)) {
                throw new IllegalArgumentException(AbstractC16016kZ6.g("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + str + " there already exist " + b(strB) + "Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }
}
