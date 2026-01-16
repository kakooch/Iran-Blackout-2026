package ir.nasim;

import ir.nasim.Q12;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class T12 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j, int i) {
        return Q12.s((j << 1) + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long j(long j) {
        return Q12.s((j << 1) + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long k(long j) {
        return (-4611686018426L > j || j >= 4611686018427L) ? j(AbstractC23053wG5.o(j, -4611686018427387903L, 4611686018427387903L)) : l(n(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long l(long j) {
        return Q12.s(j << 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j) {
        return (-4611686018426999999L > j || j >= 4611686018427000000L) ? j(o(j)) : l(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long n(long j) {
        return j * 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long o(long j) {
        return j / 1000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(String str, boolean z) {
        long jP;
        char cCharAt;
        char cCharAt2;
        int i;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Q12.a aVar = Q12.b;
        long jC = aVar.c();
        char cCharAt4 = str.charAt(0);
        boolean z2 = true;
        int length2 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z3 = length2 > 0;
        boolean z4 = z3 && AbstractC20762sZ6.S0(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c = ':';
        char c2 = '0';
        if (str.charAt(length2) == 'P') {
            int i2 = length2 + 1;
            if (i2 == length) {
                throw new IllegalArgumentException();
            }
            W12 w12 = null;
            boolean z5 = false;
            while (i2 < length) {
                if (str.charAt(i2) != 'T') {
                    int i3 = i2;
                    while (i3 < str.length() && ((c2 <= (cCharAt3 = str.charAt(i3)) && cCharAt3 < c) || AbstractC20762sZ6.W("+-.", cCharAt3, false, 2, null))) {
                        i3++;
                        c = ':';
                        c2 = '0';
                    }
                    AbstractC13042fc3.g(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i2, i3);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i2 + strSubstring.length();
                    if (length3 < 0 || length3 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt5 = str.charAt(length3);
                    int i4 = length3 + 1;
                    W12 w12E = Z12.e(cCharAt5, z5);
                    if (w12 != null && w12.compareTo(w12E) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iK0 = AbstractC20762sZ6.k0(strSubstring, '.', 0, false, 6, null);
                    if (w12E != W12.e || iK0 <= 0) {
                        i = i4;
                        jC = Q12.P(jC, t(q(strSubstring), w12E));
                    } else {
                        AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iK0);
                        AbstractC13042fc3.h(strSubstring2, "substring(...)");
                        i = i4;
                        long jP2 = Q12.P(jC, t(q(strSubstring2), w12E));
                        AbstractC13042fc3.g(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iK0);
                        AbstractC13042fc3.h(strSubstring3, "substring(...)");
                        jC = Q12.P(jP2, r(Double.parseDouble(strSubstring3), w12E));
                    }
                    i2 = i;
                    w12 = w12E;
                    c = ':';
                    c2 = '0';
                    z2 = true;
                } else {
                    if (z5 || (i2 = i2 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z5 = z2;
                }
            }
        } else {
            if (z) {
                throw new IllegalArgumentException();
            }
            String str2 = "Unexpected order of duration components";
            if (AbstractC20153rZ6.G(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                jC = aVar.a();
            } else {
                boolean z6 = !z3;
                if (z3 && str.charAt(length2) == '(' && AbstractC22039uZ6.u1(str) == ')') {
                    length2++;
                    length--;
                    if (length2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    jP = jC;
                    z6 = true;
                } else {
                    jP = jC;
                }
                W12 w122 = null;
                boolean z7 = false;
                while (length2 < length) {
                    if (z7 && z6) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i5 = length2;
                    while (i5 < str.length() && (('0' <= (cCharAt2 = str.charAt(i5)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i5++;
                    }
                    AbstractC13042fc3.g(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring4 = str.substring(length2, i5);
                    AbstractC13042fc3.h(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i6 = length4;
                    while (i6 < str.length() && 'a' <= (cCharAt = str.charAt(i6)) && cCharAt < '{') {
                        i6++;
                    }
                    AbstractC13042fc3.g(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str.substring(length4, i6);
                    AbstractC13042fc3.h(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    W12 w12F = Z12.f(strSubstring5);
                    if (w122 != null && w122.compareTo(w12F) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int iK02 = AbstractC20762sZ6.k0(strSubstring4, '.', 0, false, 6, null);
                    if (iK02 > 0) {
                        AbstractC13042fc3.g(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring6 = strSubstring4.substring(0, iK02);
                        AbstractC13042fc3.h(strSubstring6, "substring(...)");
                        long jP3 = Q12.P(jP, t(Long.parseLong(strSubstring6), w12F));
                        AbstractC13042fc3.g(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring7 = strSubstring4.substring(iK02);
                        AbstractC13042fc3.h(strSubstring7, "substring(...)");
                        jP = Q12.P(jP3, r(Double.parseDouble(strSubstring7), w12F));
                        length2 = length2;
                        if (length2 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jP = Q12.P(jP, t(Long.parseLong(strSubstring4), w12F));
                    }
                    str2 = str3;
                    w122 = w12F;
                    z7 = true;
                }
                jC = jP;
            }
        }
        return z4 ? Q12.T(jC) : jC;
    }

    private static final long q(String str) {
        int length = str.length();
        int i = (length <= 0 || !AbstractC20762sZ6.W("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i > 16) {
            Iterable c24411ya3 = new C24411ya3(i, AbstractC20762sZ6.f0(str));
            if (!(c24411ya3 instanceof Collection) || !((Collection) c24411ya3).isEmpty()) {
                Iterator it = c24411ya3.iterator();
                while (it.hasNext()) {
                    char cCharAt = str.charAt(((AbstractC18386oa3) it).b());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (AbstractC20153rZ6.S(str, "+", false, 2, null)) {
            str = AbstractC22039uZ6.q1(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d, W12 w12) {
        AbstractC13042fc3.i(w12, "unit");
        double dA = Y12.a(d, w12, W12.b);
        if (!(!Double.isNaN(dA))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jE = AbstractC20723sV3.e(dA);
        return (-4611686018426999999L > jE || jE >= 4611686018427000000L) ? k(AbstractC20723sV3.e(Y12.a(d, w12, W12.d))) : l(jE);
    }

    public static final long s(int i, W12 w12) {
        AbstractC13042fc3.i(w12, "unit");
        return w12.compareTo(W12.e) <= 0 ? l(Y12.c(i, w12, W12.b)) : t(i, w12);
    }

    public static final long t(long j, W12 w12) {
        AbstractC13042fc3.i(w12, "unit");
        W12 w122 = W12.b;
        long jC = Y12.c(4611686018426999999L, w122, w12);
        return ((-jC) > j || j > jC) ? j(AbstractC23053wG5.o(Y12.b(j, w12, W12.d), -4611686018427387903L, 4611686018427387903L)) : l(Y12.c(j, w12, w122));
    }
}
