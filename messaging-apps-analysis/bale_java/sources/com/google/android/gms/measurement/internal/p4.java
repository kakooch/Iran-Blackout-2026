package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C2126j;
import com.google.android.gms.internal.measurement.C2136o;
import ir.nasim.AbstractC3795Cj5;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes3.dex */
abstract class p4 {
    final String a;
    final int b;
    Boolean c;
    Boolean d;
    Long e;
    Long f;

    p4(String str, int i) {
        this.a = str;
        this.b = i;
    }

    private static Boolean d(String str, int i, boolean z, String str2, List list, String str3, C2227d1 c2227d1) {
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 != null) {
                    try {
                        break;
                    } catch (PatternSyntaxException unused) {
                        if (c2227d1 != null) {
                            c2227d1.w().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                        }
                        return null;
                    }
                }
                break;
            case 6:
                if (list != null) {
                    break;
                }
                break;
        }
        return null;
    }

    static Boolean e(BigDecimal bigDecimal, C2126j c2126j, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        AbstractC3795Cj5.j(c2126j);
        if (c2126j.G()) {
            if (c2126j.L() != 1) {
                if (c2126j.L() == 5) {
                    if (!c2126j.K() || !c2126j.J()) {
                        return null;
                    }
                } else if (!c2126j.H()) {
                    return null;
                }
                int iL = c2126j.L();
                if (c2126j.L() == 5) {
                    if (a4.N(c2126j.E()) && a4.N(c2126j.D())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(c2126j.E());
                            bigDecimal4 = new BigDecimal(c2126j.D());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!a4.N(c2126j.C())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(c2126j.C());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (iL == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = iL - 1;
                if (i == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                }
                if (i == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                }
                if (i != 3) {
                    if (i == 4 && bigDecimal3 != null) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                    }
                    return null;
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (d != 0.0d) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0);
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
            }
        }
        return null;
    }

    static Boolean f(String str, C2136o c2136o, C2227d1 c2227d1) {
        List list;
        AbstractC3795Cj5.j(c2136o);
        if (str == null || !c2136o.I() || c2136o.J() == 1) {
            return null;
        }
        if (c2136o.J() == 7) {
            if (c2136o.A() == 0) {
                return null;
            }
        } else if (!c2136o.H()) {
            return null;
        }
        int iJ = c2136o.J();
        boolean zF = c2136o.F();
        String strD = (zF || iJ == 2 || iJ == 7) ? c2136o.D() : c2136o.D().toUpperCase(Locale.ENGLISH);
        if (c2136o.A() == 0) {
            list = null;
        } else {
            List listE = c2136o.E();
            if (!zF) {
                ArrayList arrayList = new ArrayList(listE.size());
                Iterator it = listE.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                listE = Collections.unmodifiableList(arrayList);
            }
            list = listE;
        }
        return d(str, iJ, zF, strD, list, iJ == 2 ? strD : null, c2227d1);
    }

    static Boolean g(double d, C2126j c2126j) {
        try {
            return e(new BigDecimal(d), c2126j, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(long j, C2126j c2126j) {
        try {
            return e(new BigDecimal(j), c2126j, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, C2126j c2126j) {
        if (!a4.N(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), c2126j, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    abstract int a();

    abstract boolean b();

    abstract boolean c();
}
