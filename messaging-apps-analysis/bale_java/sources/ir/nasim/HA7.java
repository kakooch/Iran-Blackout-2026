package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.KotlinNothingValueException;

/* loaded from: classes8.dex */
public abstract class HA7 {
    public static final byte a(String str) {
        AbstractC13042fc3.i(str, "<this>");
        C7743Sz7 c7743Sz7B = b(str);
        if (c7743Sz7B != null) {
            return c7743Sz7B.p();
        }
        AbstractC19562qZ6.m(str);
        throw new KotlinNothingValueException();
    }

    public static final C7743Sz7 b(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return c(str, 10);
    }

    public static final C7743Sz7 c(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        C11540dA7 c11540dA7F = f(str, i);
        if (c11540dA7F == null) {
            return null;
        }
        int iP = c11540dA7F.p();
        if (Integer.compare(iP ^ RecyclerView.UNDEFINED_DURATION, C11540dA7.h(255) ^ RecyclerView.UNDEFINED_DURATION) > 0) {
            return null;
        }
        return C7743Sz7.a(C7743Sz7.h((byte) iP));
    }

    public static final int d(String str) {
        AbstractC13042fc3.i(str, "<this>");
        C11540dA7 c11540dA7E = e(str);
        if (c11540dA7E != null) {
            return c11540dA7E.p();
        }
        AbstractC19562qZ6.m(str);
        throw new KotlinNothingValueException();
    }

    public static final C11540dA7 e(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return f(str, 10);
    }

    public static final C11540dA7 f(String str, int i) {
        int i2;
        AbstractC13042fc3.i(str, "<this>");
        AbstractC10868cL0.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC13042fc3.k(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iH = C11540dA7.h(i);
        int iA = 119304647;
        while (i2 < length) {
            int iB = AbstractC10868cL0.b(str.charAt(i2), i);
            if (iB < 0) {
                return null;
            }
            if (Integer.compare(i3 ^ RecyclerView.UNDEFINED_DURATION, iA ^ RecyclerView.UNDEFINED_DURATION) > 0) {
                if (iA == 119304647) {
                    iA = GA7.a(-1, iH);
                    if (Integer.compare(i3 ^ RecyclerView.UNDEFINED_DURATION, iA ^ RecyclerView.UNDEFINED_DURATION) > 0) {
                    }
                }
                return null;
            }
            int iH2 = C11540dA7.h(i3 * iH);
            int iH3 = C11540dA7.h(C11540dA7.h(iB) + iH2);
            if (Integer.compare(iH3 ^ RecyclerView.UNDEFINED_DURATION, iH2 ^ RecyclerView.UNDEFINED_DURATION) < 0) {
                return null;
            }
            i2++;
            i3 = iH3;
        }
        return C11540dA7.a(i3);
    }

    public static final long g(String str) {
        AbstractC13042fc3.i(str, "<this>");
        C14599iA7 c14599iA7H = h(str);
        if (c14599iA7H != null) {
            return c14599iA7H.q();
        }
        AbstractC19562qZ6.m(str);
        throw new KotlinNothingValueException();
    }

    public static final C14599iA7 h(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return i(str, 10);
    }

    public static final C14599iA7 i(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        AbstractC10868cL0.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC13042fc3.k(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jH = C14599iA7.h(i);
        long j = 0;
        long jA = 512409557603043100L;
        while (i2 < length) {
            if (AbstractC10868cL0.b(str.charAt(i2), i) < 0) {
                return null;
            }
            if (Long.compare(j ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = EA7.a(-1L, jH);
                    if (Long.compare(j ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jH2 = C14599iA7.h(j * jH);
            long jH3 = C14599iA7.h(C14599iA7.h(C11540dA7.h(r13) & 4294967295L) + jH2);
            if (Long.compare(jH3 ^ Long.MIN_VALUE, jH2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i2++;
            j = jH3;
        }
        return C14599iA7.a(j);
    }

    public static final short j(String str) {
        AbstractC13042fc3.i(str, "<this>");
        C24771zA7 c24771zA7K = k(str);
        if (c24771zA7K != null) {
            return c24771zA7K.p();
        }
        AbstractC19562qZ6.m(str);
        throw new KotlinNothingValueException();
    }

    public static final C24771zA7 k(String str) {
        AbstractC13042fc3.i(str, "<this>");
        return l(str, 10);
    }

    public static final C24771zA7 l(String str, int i) {
        AbstractC13042fc3.i(str, "<this>");
        C11540dA7 c11540dA7F = f(str, i);
        if (c11540dA7F == null) {
            return null;
        }
        int iP = c11540dA7F.p();
        if (Integer.compare(iP ^ RecyclerView.UNDEFINED_DURATION, C11540dA7.h(65535) ^ RecyclerView.UNDEFINED_DURATION) > 0) {
            return null;
        }
        return C24771zA7.a(C24771zA7.h((short) iP));
    }
}
