package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes8.dex */
public final class Q12 implements Comparable {
    public static final a b = new a(null);
    private static final long c = s(0);
    private static final long d = T12.j(4611686018427387903L);
    private static final long e = T12.j(-4611686018427387903L);
    private final long a;

    public static final class a {
        private a() {
        }

        public final long a() {
            return Q12.d;
        }

        public final long b() {
            return Q12.e;
        }

        public final long c() {
            return Q12.c;
        }

        public final long d(String str) {
            AbstractC13042fc3.i(str, "value");
            try {
                return T12.p(str, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e);
            }
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    private /* synthetic */ Q12(long j) {
        this.a = j;
    }

    public static final long A(long j) {
        return (L(j) && K(j)) ? I(j) : R(j, W12.d);
    }

    public static final long B(long j) {
        return R(j, W12.f);
    }

    public static final long C(long j) {
        long jI = I(j);
        if (M(j)) {
            return jI;
        }
        if (jI > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jI < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return T12.n(jI);
    }

    public static final long D(long j) {
        return R(j, W12.e);
    }

    public static final int E(long j) {
        if (N(j)) {
            return 0;
        }
        return (int) (B(j) % 60);
    }

    public static final int F(long j) {
        if (N(j)) {
            return 0;
        }
        return (int) (L(j) ? T12.n(I(j) % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT) : I(j) % Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
    }

    public static final int G(long j) {
        if (N(j)) {
            return 0;
        }
        return (int) (D(j) % 60);
    }

    private static final W12 H(long j) {
        return M(j) ? W12.b : W12.d;
    }

    private static final long I(long j) {
        return j >> 1;
    }

    public static int J(long j) {
        return Long.hashCode(j);
    }

    public static final boolean K(long j) {
        return !N(j);
    }

    private static final boolean L(long j) {
        return (((int) j) & 1) == 1;
    }

    private static final boolean M(long j) {
        return (((int) j) & 1) == 0;
    }

    public static final boolean N(long j) {
        return j == d || j == e;
    }

    public static final boolean O(long j) {
        return j < 0;
    }

    public static final long P(long j, long j2) {
        if (N(j)) {
            if (K(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (N(j2)) {
            return j2;
        }
        if ((((int) j) & 1) != (((int) j2) & 1)) {
            return L(j) ? j(j, I(j), I(j2)) : j(j, I(j2), I(j));
        }
        long jI = I(j) + I(j2);
        return M(j) ? T12.m(jI) : T12.k(jI);
    }

    public static final String Q(long j) {
        StringBuilder sb = new StringBuilder();
        if (O(j)) {
            sb.append('-');
        }
        sb.append("PT");
        long jV = v(j);
        long jY = y(jV);
        int iE = E(jV);
        int iG = G(jV);
        int iF = F(jV);
        if (N(j)) {
            jY = 9999999999999L;
        }
        boolean z = false;
        boolean z2 = jY != 0;
        boolean z3 = (iG == 0 && iF == 0) ? false : true;
        if (iE != 0 || (z3 && z2)) {
            z = true;
        }
        if (z2) {
            sb.append(jY);
            sb.append('H');
        }
        if (z) {
            sb.append(iE);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            o(j, sb, iG, iF, 9, TokenNames.S, true);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static final long R(long j, W12 w12) {
        AbstractC13042fc3.i(w12, "unit");
        if (j == d) {
            return Long.MAX_VALUE;
        }
        if (j == e) {
            return Long.MIN_VALUE;
        }
        return Y12.b(I(j), H(j), w12);
    }

    public static String S(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == d) {
            return "Infinity";
        }
        if (j == e) {
            return "-Infinity";
        }
        boolean zO = O(j);
        StringBuilder sb = new StringBuilder();
        if (zO) {
            sb.append('-');
        }
        long jV = v(j);
        long jX = x(jV);
        int iW = w(jV);
        int iE = E(jV);
        int iG = G(jV);
        int iF = F(jV);
        int i = 0;
        boolean z = jX != 0;
        boolean z2 = iW != 0;
        boolean z3 = iE != 0;
        boolean z4 = (iG == 0 && iF == 0) ? false : true;
        if (z) {
            sb.append(jX);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iW);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iE);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iG != 0 || z || z2 || z3) {
                o(j, sb, iG, iF, 9, "s", false);
            } else if (iF >= 1000000) {
                o(j, sb, iF / 1000000, iF % 1000000, 6, "ms", false);
            } else if (iF >= 1000) {
                o(j, sb, iF / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, iF % AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 3, "us", false);
            } else {
                sb.append(iF);
                sb.append("ns");
            }
            i = i4;
        }
        if (zO && i > 1) {
            sb.insert(1, '(').append(')');
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public static final long T(long j) {
        return T12.i(-I(j), ((int) j) & 1);
    }

    private static final long j(long j, long j2, long j3) {
        long jO = T12.o(j3);
        long j4 = j2 + jO;
        if (-4611686018426L > j4 || j4 >= 4611686018427L) {
            return T12.j(AbstractC23053wG5.o(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return T12.l(T12.n(j4) + (j3 - T12.n(jO)));
    }

    private static final void o(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String strW0 = AbstractC20762sZ6.w0(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = strW0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i5 = length - 1;
                    if (strW0.charAt(length) != '0') {
                        i4 = length;
                        break;
                    } else if (i5 < 0) {
                        break;
                    } else {
                        length = i5;
                    }
                }
            }
            int i6 = i4 + 1;
            if (z || i6 >= 3) {
                sb.append((CharSequence) strW0, 0, ((i4 + 3) / 3) * 3);
                AbstractC13042fc3.h(sb, "append(...)");
            } else {
                sb.append((CharSequence) strW0, 0, i6);
                AbstractC13042fc3.h(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ Q12 p(long j) {
        return new Q12(j);
    }

    public static int r(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return AbstractC13042fc3.l(j, j2);
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return O(j) ? -i : i;
    }

    public static long s(long j) {
        if (S12.a()) {
            if (M(j)) {
                long jI = I(j);
                if (-4611686018426999999L > jI || jI >= 4611686018427000000L) {
                    throw new AssertionError(I(j) + " ns is out of nanoseconds range");
                }
            } else {
                long jI2 = I(j);
                if (-4611686018427387903L > jI2 || jI2 >= 4611686018427387904L) {
                    throw new AssertionError(I(j) + " ms is out of milliseconds range");
                }
                long jI3 = I(j);
                if (-4611686018426L <= jI3 && jI3 < 4611686018427L) {
                    throw new AssertionError(I(j) + " ms is denormalized");
                }
            }
        }
        return j;
    }

    public static boolean t(long j, Object obj) {
        return (obj instanceof Q12) && j == ((Q12) obj).U();
    }

    public static final boolean u(long j, long j2) {
        return j == j2;
    }

    public static final long v(long j) {
        return O(j) ? T(j) : j;
    }

    public static final int w(long j) {
        if (N(j)) {
            return 0;
        }
        return (int) (y(j) % 24);
    }

    public static final long x(long j) {
        return R(j, W12.h);
    }

    public static final long y(long j) {
        return R(j, W12.g);
    }

    public static final long z(long j) {
        return R(j, W12.c);
    }

    public final /* synthetic */ long U() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return q(((Q12) obj).U());
    }

    public boolean equals(Object obj) {
        return t(this.a, obj);
    }

    public int hashCode() {
        return J(this.a);
    }

    public int q(long j) {
        return r(this.a, j);
    }

    public String toString() {
        return S(this.a);
    }
}
